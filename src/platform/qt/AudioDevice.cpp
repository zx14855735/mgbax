/* Copyright (c) 2013-2015 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "AudioDevice.h"
#include "moc_AudioDevice.cpp"

#include "ConfigController.h"
#include "CoreController.h"
#include "GBAApp.h"
#include "LogController.h"

#include <mgba/core/core.h>
#include <mgba/core/thread.h>
#include <mgba/internal/gba/audio.h>

#include <QDebug>

#include <chrono>
#include <cstdio>

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
 *
 * Locking contract: the caller must hold the core's audio lock, and this
 * function RELEASES it - mCoreSyncConsumeAudio() wakes the emulation thread
 * and unlocks on its way out. Callers must therefore not unlock again: a
 * second unlock unbalances the critical section, the emulation thread then
 * races the audio thread over the same buffers, and it can block forever in
 * mCoreSyncProduceAudio() waiting for audio that will never be consumed.
 */
void AudioDevice::pumpAudio() {
	// The caller holds the core's audio lock; this function owns releasing it.
	if (!m_context || !m_context->core) {
		// The game was closed while the device was still polling: hand the
		// lock back, or the emulation thread blocks on it forever.
		if (m_context) {
			mCoreSyncConsumeAudio(&m_context->impl->sync);
		}
		return;
	}
	mCore* core = m_context->core;
	unsigned coreRate = core->audioSampleRate(core);
	bool holdOn = false;
	double holdStretch = 1.0;
	double holdRate = 1.0;
	if (m_controller) {
		m_controller->audioHoldState(&holdOn, &holdStretch, &holdRate);
	}
	size_t want = 4096;
	struct mAudioBuffer* coreBuffer = core->getAudioBuffer(core);
	struct mAudioBuffer* src = audioStretchProcess(&m_stretch, coreBuffer, coreRate, holdOn, holdStretch, holdRate, want);
	/* 倍速声音不变开启时，WSOLA/保持引擎已把核心音频压成 1x 的 audioHold，
	 * 重采样器必须按 1x 目标速率播放；否则这段 1x 音频会被再按倍速重放，
	 * 表现为音调抬高、断续的「电音」。普通快进（holdOn 为假）仍走原 fauxClock
	 * 路径：核心以倍速灌入、重采样器以倍速消费，音调保持不变。
	 * 音乐自身的速度由 holdRate 决定：源速率同步放大，音高不变、速度即倍率。 */
	double fauxClock = holdOn ? 1.0
	                         : mCoreCalculateFramerateRatio(core, m_context->impl->sync.fpsTarget);
	double sourceRate = holdOn ? coreRate * holdRate : coreRate;
	size_t diagBefore = mAudioBufferAvailable(&m_buffer);
	mAudioResamplerSetSource(&m_resampler, src, sourceRate, true);
	mAudioResamplerSetDestination(&m_resampler, &m_buffer, m_format.sampleRate() * fauxClock);
	mAudioResamplerProcess(&m_resampler);
	/* TEMP DIAGNOSTIC: measure the pitch of what actually reaches the device,
	 * so "the music sped up" can be checked as a number instead of guessed. */
	{
		size_t after = mAudioBufferAvailable(&m_buffer);
		static int lastSign = 0;
		static long long crossings = 0;
		static std::chrono::steady_clock::time_point lastTime = std::chrono::steady_clock::now();
		for (size_t i = diagBefore; i < after; ++i) {
			int16_t s = mAudioBufferPeek(&m_buffer, 0, i);
			int sign = s > 0 ? 1 : (s < 0 ? -1 : 0);
			if (sign && lastSign && sign != lastSign) {
				++crossings;
			}
			if (sign) {
				lastSign = sign;
			}
		}
		auto now = std::chrono::steady_clock::now();
		double elapsed = std::chrono::duration<double>(now - lastTime).count();
		if (elapsed >= 1.0) {
			QString line = QString("[AUDIOHOLD] on=%1 stretch=%2 faux=%3 coreRate=%4 fpsTarget=%5 fresh=%6 pitch=%7Hz\n")
			                   .arg((int) holdOn).arg(holdStretch, 0, 'f', 3).arg(fauxClock, 0, 'f', 4)
			                   .arg(coreRate).arg(m_context->impl->sync.fpsTarget, 0, 'f', 1)
			                   .arg(after - diagBefore).arg(crossings / 2.0 / elapsed, 0, 'f', 0);
			QFile diagFile(ConfigController::configDir() + "/audiodiag.log");
			if (diagFile.open(QIODevice::WriteOnly | QIODevice::Append | QIODevice::Text)) {
				diagFile.write(line.toUtf8());
				diagFile.close();
			}
			fprintf(stderr, "%s", line.toUtf8().constData());
			fflush(stderr);
			crossings = 0;
			lastTime = now;
		}
	}
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
	if (mAudioBufferAvailable(&m_buffer) < 32) {
		// Audio is running slow...let's wait a tiny bit for more to come in
		QThread::usleep(100);
		mCoreSyncLockAudio(&m_context->impl->sync);
		pumpAudio();
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

	if (!wasAvailable && mAudioBufferAvailable(&m_buffer)) {
		emit readyRead();
	}

	/* While the fast-forward stretcher is running, the emulation thread is
	 * paced by the audio (its ring has to drain or the game stops), so the
	 * pump must keep going even when the playback buffer is full: the device
	 * may be slow to ask for the next block, and a stalled pump would leave
	 * the emulation thread waiting for audio that never arrives. */
	bool holdOn = false;
	double holdStretch = 1.0;
	double holdRate = 1.0;
	if (m_controller) {
		m_controller->audioHoldState(&holdOn, &holdStretch, &holdRate);
	}
	if (mAudioBufferFull(&m_buffer) && !holdOn) {
		m_updateTimer.stop();
	}
}

void AudioDevice::adjustResampler() {
	mCore* core = m_context->core;
	double fauxClock = mCoreCalculateFramerateRatio(m_context->core, m_context->impl->sync.fpsTarget);
	bool holdOn = false;
	double holdStretch = 1.0;
	double holdRate = 1.0;
	if (m_controller) {
		m_controller->audioHoldState(&holdOn, &holdStretch, &holdRate);
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
		/* Keep the high water mark below the core ring's capacity, with
		 * headroom: the emulation thread only blocks once the ring reaches
		 * the mark, so a mark at (or above) the capacity would let the ring
		 * overflow first and the samples would be dropped - the "electric"
		 * artefact. */
		size_t limit = destSize - (destSize >> 2);
		if (limit < 16) {
			limit = destSize;
		}
		if (m_context->impl->sync.audioHighWater >= limit) {
			m_context->impl->sync.audioHighWater = limit;
		}
	}
}
