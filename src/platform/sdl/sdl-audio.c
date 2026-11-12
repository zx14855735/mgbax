/* Copyright (c) 2013-2015 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "sdl-audio.h"

#include <mgba/core/core.h>
#include <mgba/core/thread.h>

mLOG_DEFINE_CATEGORY(SDL_AUDIO, "SDL Audio", "platform.sdl.audio");

#if SDL_VERSION_ATLEAST(3, 0, 0)
static void _mSDLAudioCallback(void* context, SDL_AudioStream* stream, int additionalLen, int totalLen);
#else
static void _mSDLAudioCallback(void* context, Uint8* data, int len);
#endif

bool mSDLInitAudio(struct mSDLAudio* context, struct mCoreThread* threadContext) {
#if defined(_WIN32) && SDL_VERSION_ATLEAST(2, 0, 8) && !SDL_VERSION_ATLEAST(3, 0, 0)
	if (!getenv("SDL_AUDIODRIVER")) {
		_putenv_s("SDL_AUDIODRIVER", "directsound");
	}
#endif
	if (!SDL_OK(SDL_InitSubSystem(SDL_INIT_AUDIO))) {
		mLOG(SDL_AUDIO, ERROR, "Could not initialize SDL sound system: %s", SDL_GetError());
		return false;
	}

	memset(&context->desiredSpec, 0, sizeof(context->desiredSpec));
	memset(&context->obtainedSpec, 0, sizeof(context->obtainedSpec));
	context->desiredSpec.freq = context->sampleRate;
	context->desiredSpec.channels = 2;
#if SDL_VERSION_ATLEAST(3, 0, 0)
	context->desiredSpec.format = SDL_AUDIO_S16;
	char hint[21];
	snprintf(hint, sizeof(hint), "%" PRIz "u", context->samples);
	SDL_SetHint(SDL_HINT_AUDIO_DEVICE_SAMPLE_FRAMES, hint);
	context->stream = SDL_OpenAudioDeviceStream(SDL_AUDIO_DEVICE_DEFAULT_PLAYBACK, &context->desiredSpec, _mSDLAudioCallback, context);
	if (!context->stream) {
#else
	context->desiredSpec.callback = _mSDLAudioCallback;
	context->desiredSpec.userdata = context;
	context->desiredSpec.samples = context->samples;
	context->desiredSpec.format = AUDIO_S16SYS;
#if SDL_VERSION_ATLEAST(2, 0, 0)
	context->deviceId = SDL_OpenAudioDevice(0, 0, &context->desiredSpec, &context->obtainedSpec, SDL_AUDIO_ALLOW_FREQUENCY_CHANGE);
	if (context->deviceId == 0) {
#else
	if (SDL_OpenAudio(&context->desiredSpec, &context->obtainedSpec) < 0) {
#endif
#endif
		mLOG(SDL_AUDIO, ERROR, "Could not open SDL sound system");
		return false;
	}
	context->core = NULL;

#if SDL_VERSION_ATLEAST(3, 0, 0)
	SDL_GetAudioStreamFormat(context->stream, &context->obtainedSpec, NULL);
#endif
	if (context->obtainedSpec.channels == 0) {
		// This should never happen, but let's make sure
#if SDL_VERSION_ATLEAST(3, 0, 0)
		SDL_DestroyAudioStream(context->stream);
#elif SDL_VERSION_ATLEAST(2, 0, 0)
		SDL_PauseAudioDevice(context->deviceId, 1);
		SDL_CloseAudioDevice(context->deviceId);
#else
		SDL_PauseAudio(1);
		SDL_CloseAudio();
#endif
		return false;
	}

	mAudioBufferInit(&context->buffer, context->samples, context->obtainedSpec.channels);
	mAudioResamplerInit(&context->resampler, mINTERPOLATOR_SINC);
	mAudioResamplerSetDestination(&context->resampler, &context->buffer, context->obtainedSpec.freq);
	audioStretchInit(&context->stretch);

	if (threadContext) {
		context->core = threadContext->core;
		context->sync = &threadContext->impl->sync;

		mSDLResumeAudio(context);
	}

	return true;
}

void mSDLDeinitAudio(struct mSDLAudio* context) {
	UNUSED(context);
#if SDL_VERSION_ATLEAST(3, 0, 0)
	SDL_DestroyAudioStream(context->stream);
#elif SDL_VERSION_ATLEAST(2, 0, 0)
	SDL_PauseAudioDevice(context->deviceId, 1);
	SDL_CloseAudioDevice(context->deviceId);
#else
	SDL_PauseAudio(1);
	SDL_CloseAudio();
#endif
	mAudioBufferDeinit(&context->buffer);
	mAudioResamplerDeinit(&context->resampler);
	audioStretchDeinit(&context->stretch);
	SDL_QuitSubSystem(SDL_INIT_AUDIO);
}

void mSDLPauseAudio(struct mSDLAudio* context) {
#if SDL_VERSION_ATLEAST(3, 0, 0)
	SDL_PauseAudioStreamDevice(context->stream);
#elif SDL_VERSION_ATLEAST(2, 0, 0)
	SDL_PauseAudioDevice(context->deviceId, 1);
#else
	UNUSED(context);
	SDL_PauseAudio(1);
#endif
}

void mSDLResumeAudio(struct mSDLAudio* context) {
#if SDL_VERSION_ATLEAST(3, 0, 0)
	SDL_ResumeAudioStreamDevice(context->stream);
#elif SDL_VERSION_ATLEAST(2, 0, 0)
	SDL_PauseAudioDevice(context->deviceId, 0);
#else
	UNUSED(context);
	SDL_PauseAudio(0);
#endif
}

#if SDL_VERSION_ATLEAST(3, 0, 0)
static void _mSDLAudioCallback(void* context, SDL_AudioStream* stream, int additionalLen, int len) {
	UNUSED(additionalLen);
#else
static void _mSDLAudioCallback(void* context, Uint8* data, int len) {
#endif
	struct mSDLAudio* audioContext = context;
	if (!context || !audioContext->core) {
#if SDL_VERSION_ATLEAST(3, 0, 0)
		return;
#else
		memset(data, 0, len);
		return;
#endif
	}
	struct mAudioBuffer* buffer = audioContext->core->getAudioBuffer(audioContext->core);
	unsigned coreRate = audioContext->core->audioSampleRate(audioContext->core);
	double fauxClock = 1;
	bool holdOn = false;
	double holdStretch = 1.0;
	double holdRate = 1.0;
	int holdMode = 0;
	double fpsTarget = 0;
	if (audioContext->sync) {
		struct mCoreSync* sync = audioContext->sync;
		holdMode = sync->audioHoldMode;
		fpsTarget = sync->fpsTarget;
		if (sync->fpsTarget > 0 && audioContext->core) {
			fauxClock = mCoreCalculateFramerateRatio(audioContext->core, sync->fpsTarget);
		}
		/* 倍速声音不变: mirror of CoreController::audioHoldState, read from the
		 * shared sync struct because this callback has no CoreController. The
		 * hold engages whenever the feature is on and the core is actually
		 * running faster than native - which updateFastForward guarantees by
		 * writing fpsTarget = native * ratio the instant a fast-forward starts. */
		if (sync->audioHoldMode != 0 && sync->fpsTarget > 0) {
			double nativeFps = mCoreCalculateFramerateRatio(audioContext->core, 1.0);
			if (nativeFps > 0.0) {
				double speed = sync->fpsTarget / nativeFps;
				if (speed > 1.05 && speed < 64.0) {
					holdOn = true;
					holdRate = sync->audioHoldRate > 0.05 ? sync->audioHoldRate : 1.0;
					if (holdRate > speed) {
						holdRate = speed;
					}
					holdStretch = speed / holdRate;
				}
			}
		}
		mCoreSyncLockAudio(sync);
		audioContext->sync->audioHighWater = audioContext->samples + audioContext->resampler.highWaterMark + audioContext->resampler.lowWaterMark + (audioContext->samples >> 6);
		/* audioHighWater gates how much CORE audio may pile up before
		 * mCoreSyncProduceAudio throttles the emulation thread. The core
		 * produces audio at the fast-forward rate (4x) regardless of the rate
		 * at which the stretcher stages its OUTPUT, so this gate must use the
		 * same fauxClock a plain 4x fast-forward uses. The old hold-mode
		 * special case (a 1x clock) set the gate four times too low: with
		 * audioWait enabled the core was throttled back towards 1x and the
		 * stretcher was starved of input - the music comes out thin / dull.
		 * A spectral measurement showed WSOLA itself loses no high frequencies
		 * (4k and 8k stay within ~1% of 440 Hz at both 2x and 4x stretch), so
		 * the deficit is on the supply side, not in the stretch algorithm. */
		audioContext->sync->audioHighWater *= coreRate / (fauxClock * audioContext->obtainedSpec.freq);

		if (audioContext->resampler.source) {
			size_t destSize = mAudioBufferCapacity(audioContext->resampler.source);
			if (audioContext->sync->audioHighWater >= destSize) {
				audioContext->sync->audioHighWater = destSize;
			}
		}
	}
	/* Diagnostic log: one line per second so the user can confirm whether the
	 * hold actually engages. expectPitchMul = 1 means the music is at its own
	 * tempo; > 1 means it is racing with the game. Written to
	 * %APPDATA%\mGBA\audiodiag.log. (This backend is the one that actually
	 * runs, unlike the Qt AudioDevice which is dead code in this build.) */
	{
		static Uint32 s_lastDiag = 0;
		static FILE* s_diag = NULL;
		Uint32 now = SDL_GetTicks();
		if (now - s_lastDiag >= 1000) {
			s_lastDiag = now;
			if (!s_diag) {
				const char* appdata = getenv("APPDATA");
				char path[1024];
				if (appdata) {
					snprintf(path, sizeof(path), "%s\\mGBA\\audiodiag.log", appdata);
				} else {
					snprintf(path, sizeof(path), "audiodiag.log");
				}
				s_diag = fopen(path, "a");
			}
			if (s_diag) {
				double expectPitchMul = holdOn ? holdRate : fauxClock;
				fprintf(s_diag, "[AUDIOHOLD] on=%d mode=%d ratio=%.2f rate=%.2f stretch=%.2f fpsTarget=%.1f coreRate=%u outFreq=%d expectPitchMul=%.3f dropped=%zu\n",
					holdOn ? 1 : 0, holdMode, (audioContext->sync ? audioContext->sync->audioHoldRatio : 0.0),
					holdRate, holdStretch, fpsTarget, coreRate, audioContext->obtainedSpec.freq, expectPitchMul,
					audioStretchDropped(&audioContext->stretch));
				fflush(s_diag);
			}
		}
	}
	/* Mirror the chosen hold mode into the stretch engine. The engine defaults
	 * to WSOLA and was never told to switch to NATIVE, so without this the
	 * "原音高但跳段" option silently ran WSOLA - which is why the music kept
	 * sounding muffled / 低沉 no matter what. audioStretchSetMode only acts on
	 * a real change, so calling it every callback is cheap and safe. */
	if (holdMode != 0) {
		audioStretchSetMode(&audioContext->stretch, holdMode);
	}
	/* Feed the core audio through the fast-forward stretcher when engaged; it
	 * returns the core buffer unchanged when disengaged. */
	struct mAudioBuffer* src = audioStretchProcess(&audioContext->stretch, buffer, coreRate, holdOn, holdStretch, holdRate, audioContext->samples * 2);
	/* The resampler reads the (possibly stretched) source at the console rate
	 * scaled by the music rate and writes at the device rate. With the hold on
	 * the destination is 1x (the staged audio is already at native tempo); off,
	 * it is the fast-forward ratio so a plain fast-forward keeps its pitch. */
	double destRate = audioContext->obtainedSpec.freq * (holdOn ? 1.0 : fauxClock);
	double srcRate = coreRate * (holdOn ? holdRate : 1.0);
	mAudioResamplerSetSource(&audioContext->resampler, src, srcRate, true);
	mAudioResamplerSetDestination(&audioContext->resampler, &audioContext->buffer, destRate);
	mAudioResamplerProcess(&audioContext->resampler);
	if (audioContext->sync) {
		mCoreSyncConsumeAudio(audioContext->sync);
	}
#if SDL_VERSION_ATLEAST(3, 0, 0)
	int16_t data[2048];
	while (len > 0) {
		int thisRead = sizeof(data);
		if (len < thisRead) {
			thisRead = len;
		}
		int available = mAudioBufferRead(&audioContext->buffer, data, thisRead / 4) * 4;
		if (!available) {
			break;
		}
		SDL_PutAudioStreamData(stream, data, available);
		len -= available;
	}
#else
	len /= 2 * audioContext->obtainedSpec.channels;
	int available = mAudioBufferRead(&audioContext->buffer, (int16_t*) data, len);

	if (available < len) {
		memset(((short*) data) + audioContext->obtainedSpec.channels * available, 0, (len - available) * audioContext->obtainedSpec.channels * sizeof(short));
	}
#endif
}
