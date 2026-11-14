/* Copyright (c) 2013-2015 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "AudioProcessor.h"
#include "moc_AudioProcessor.cpp"

#include "AudioProcessorDummy.h"
#include "ConfigController.h"

#ifdef BUILD_SDL
#include "AudioProcessorSDL.h"
#endif

#ifdef BUILD_QT_MULTIMEDIA
#include "AudioProcessorQt.h"
#endif

using namespace QGBA;

#ifndef BUILD_SDL
AudioProcessor::Driver AudioProcessor::s_driver = AudioProcessor::Driver::QT_MULTIMEDIA;
#else
AudioProcessor::Driver AudioProcessor::s_driver = AudioProcessor::Driver::SDL;
#endif

AudioProcessor* AudioProcessor::create() {
	switch (s_driver) {
	case Driver::DUMMY:
		return new AudioProcessorDummy();
#ifdef BUILD_SDL
	case Driver::SDL:
		return new AudioProcessorSDL();
#endif

#ifdef BUILD_QT_MULTIMEDIA
	case Driver::QT_MULTIMEDIA:
		return new AudioProcessorQt();
#endif

	default:
#ifdef BUILD_SDL
		return new AudioProcessorSDL();
#else
		return new AudioProcessorQt();
#endif
	}
}

AudioProcessor::AudioProcessor(QObject* parent)
	: QObject(parent)
{
}

AudioProcessor::~AudioProcessor() {
	stop();
}

void AudioProcessor::configure(ConfigController* config) {
	const mCoreOptions* opts = config->options();
	int buffers = opts->audioBuffers;
	/* 低延迟模式（对齐移动端 low_latency）：把缓冲压到 512 帧以内，
	 * 牺牲一点抗抖动换更小的按键/画面延迟。设置页的 audioBuffers 仍然生效，
	 * 只是这里取两者较小值。 */
	if (config->getOption("lowLatency").toInt() && (buffers <= 0 || buffers > LOW_LATENCY_BUFFERS)) {
		buffers = LOW_LATENCY_BUFFERS;
	}
	setBufferSamples(buffers);
	requestSampleRate(opts->sampleRate);
}

void AudioProcessor::setInput(std::shared_ptr<CoreController> input) {
	m_context = std::move(input);
	connect(m_context.get(), &CoreController::stopping, this, &AudioProcessor::stop);
	connect(m_context.get(), &CoreController::fastForwardChanged, this, &AudioProcessor::inputParametersChanged);
	connect(m_context.get(), &CoreController::paused, this, &AudioProcessor::pause);
	connect(m_context.get(), &CoreController::unpaused, this, &AudioProcessor::start);
}

void AudioProcessor::stop() {
	m_context.reset();
}

void AudioProcessor::setBufferSamples(int samples) {
	m_samples = samples;
}
