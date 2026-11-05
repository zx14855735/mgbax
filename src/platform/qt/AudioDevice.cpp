/* Copyright (c) 2013-2015 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "AudioDevice.h"
#include "moc_AudioDevice.cpp"

#include "CoreController.h"
#include "GBAApp.h"
#include "LogController.h"

#include <mgba/core/core.h>
#include <mgba/core/thread.h>
#include <mgba/internal/gba/audio.h>

#include <QDebug>

using namespace QGBA;

AudioDevice::AudioDevice(QObject* parent)
	: QIODevice(parent)
	, m_context(nullptr)
{
	setOpenMode(ReadOnly);
	mAudioBufferInit(&m_buffer, 0x4000, 2);
	mAudioResamplerInit(&m_resampler, mINTERPOLATOR_SINC);
	audioStretchInit(&m_stretch);
	m_updateTimer.setSingleShot(false);
	m_updateTimer.setInterval(1);
	connect(&m_updateTimer, &QTimer::timeout, this, &AudioDevice::update);
}

AudioDevice::~AudioDevice() {
	audioStretchDeinit(&m_stretch);
	mAudioResamplerDeinit(&m_resampler);
	mAudioBufferDeinit(&m_buffer);
}

void AudioDevice::setFormat(const QAudioFormat& format) {
	if (!m_context || !mCoreThreadIsActive(m_context)) {
		LOG(QT, INFO) << tr("Can't set format of context-less audio device");
		return;
	}
	mCoreSyncLockAudio(&m_context->impl->sync);
	mCore* core = m_context->core;
	mAudioResamplerSetSource(&m_resampler, core->getAudioBuffer(core), core->audioSampleRate(core), true);
	m_format = format;
	adjustResampler();
	mCoreSyncUnlockAudio(&m_context->impl->sync);
}

void AudioDevice::setBufferSamples(int samples) {
	m_samples = samples;
}

void AudioDevice::setInput(mCoreThread* input) {
	m_context = input;
	// A new game must not replay anything staged by the previous one.
	audioStretchReset(&m_stretch);
}

/*
 * Drains the core's audio into the playback staging, optionally through the
 * fast-forward stretcher (音乐原速): when engaged, the core buffer is parked
 * into the stretch engine and the resampler reads its staged output one for
 * one at the console's own rate, so the tune keeps its tempo and pitch no
 * matter how fast the game runs.
 */
void AudioDevice::pumpAudio() {
	// Caller must hold the audio sync lock.
	if (!m_context || !m_context->core) {
		return;
	}
	mCore* core = m_context->core;
	unsigned coreRate = core->audioSampleRate(core);
	bool holdOn = false;
	double holdStretch = 1.0;
	if (m_controller) {
		m_controller->audioHoldState(&holdOn, &holdStretch);
	}
	size_t want = 4096;
	struct mAudioBuffer* coreBuffer = core->getAudioBuffer(core);
	struct mAudioBuffer* src = audioStretchProcess(&m_stretch, coreBuffer, coreRate, holdOn, holdStretch, want);
	/* 倍速声音不变开启时，WSOLA/保持引擎已把核心音频压成 1x 的 audioHold，
	 * 重采样器必须按 1x 目标速率播放；否则这段 1x 音频会被再按倍速重放，
	 * 表现为音调抬高、断续的「电音」。普通快进（holdOn 为假）仍走原 fauxClock
	 * 路径：核心以倍速灌入、重采样器以倍速消费，音调保持不变。 */
	double fauxClock = holdOn ? 1.0
	                         : mCoreCalculateFramerateRatio(core, m_context->impl->sync.fpsTarget);
	mAudioResamplerSetSource(&m_resampler, src, coreRate, true);
	mAudioResamplerSetDestination(&m_resampler, &m_buffer, m_format.sampleRate() * fauxClock);
	mAudioResamplerProcess(&m_resampler);
	mCoreSyncConsumeAudio(&m_context->impl->sync);
}

qint64 AudioDevice::readData(char* data, qint64 maxSize) {
	if (!m_context->core) {
		LOG(QT, WARN) << tr("Audio device is missing its core");
		return 0;
	}

	if (!maxSize) {
		return 0;
	}

	mCoreSyncLockAudio(&m_context->impl->sync);
	pumpAudio();
	mCoreSyncUnlockAudio(&m_context->impl->sync);
	if (mAudioBufferAvailable(&m_buffer) < 32) {
		// Audio is running slow...let's wait a tiny bit for more to come in
		QThread::usleep(100);
		mCoreSyncLockAudio(&m_context->impl->sync);
		pumpAudio();
		mCoreSyncUnlockAudio(&m_context->impl->sync);
	}
	quint64 available = std::min<quint64>({
		mAudioBufferAvailable(&m_buffer),
		static_cast<quint64>(maxSize / sizeof(mStereoSample)),
		std::numeric_limits<int>::max()
	});
	mAudioBufferRead(&m_buffer, reinterpret_cast<int16_t*>(data), available);
	m_updateTimer.start();
	return available * sizeof(mStereoSample);
}

qint64 AudioDevice::writeData(const char*, qint64) {
	LOG(QT, WARN) << tr("Writing data to read-only audio device");
	return 0;
}

bool AudioDevice::atEnd() const {
	return false;
}

qint64 AudioDevice::bytesAvailable() const {
	if (!m_context->core) {
		return true;
	}
	m_updateTimer.start();
	int available = mAudioBufferAvailable(&m_buffer);
	return available * sizeof(mStereoSample);
}

qint64 AudioDevice::bytesAvailable() {
	if (!m_context->core) {
		return true;
	}
	mCoreSyncLockAudio(&m_context->impl->sync);
	adjustResampler();
	pumpAudio();
	int available = mAudioBufferAvailable(&m_buffer);
	mCoreSyncUnlockAudio(&m_context->impl->sync);
	m_updateTimer.start();
	return available * sizeof(mStereoSample);
}

void AudioDevice::update() {
	if (!m_context->core) {
		return;
	}

	bool wasAvailable = mAudioBufferAvailable(&m_buffer);

	mCoreSyncLockAudio(&m_context->impl->sync);
	pumpAudio();
	mCoreSyncUnlockAudio(&m_context->impl->sync);

	if (!wasAvailable && mAudioBufferAvailable(&m_buffer)) {
		emit readyRead();
	}

	if (mAudioBufferFull(&m_buffer)) {
		m_updateTimer.stop();
	}
}

void AudioDevice::adjustResampler() {
	mCore* core = m_context->core;
	double fauxClock = mCoreCalculateFramerateRatio(m_context->core, m_context->impl->sync.fpsTarget);
	bool holdOn = false;
	double holdStretch = 1.0;
	if (m_controller) {
		m_controller->audioHoldState(&holdOn, &holdStretch);
	}
	/* The high water mark lives in the core's own audio ring, so it is scaled
	 * by the real speed ratio: the core is paced at fauxClock times the native
	 * rate, and the ring must hold enough wall-clock buffering for that. */
	m_context->impl->sync.audioHighWater = m_samples + m_resampler.highWaterMark + m_resampler.lowWaterMark;
	m_context->impl->sync.audioHighWater *= core->audioSampleRate(core) / (m_format.sampleRate() * fauxClock);
	/* The destination rate is a different question: with 倍速声音不变 the
	 * staged audio is already at the console's own rate, so the resampler must
	 * convert it at 1x - replaying 1x audio at the fast-forward rate is what
	 * made it come out pitched up and gappy ("电音"). */
	mAudioResamplerSetDestination(&m_resampler, &m_buffer, m_format.sampleRate() * (holdOn ? 1.0 : fauxClock));

	struct mAudioBuffer* coreBuffer = core->getAudioBuffer(core);
	if (coreBuffer) {
		size_t destSize = mAudioBufferCapacity(coreBuffer);
		if (m_context->impl->sync.audioHighWater >= destSize) {
			m_context->impl->sync.audioHighWater = destSize;
		}
	}
}
