/* Copyright (c) 2013-2017 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "CoreController.h"

#include "ConfigController.h"
#include "InputController.h"
#include "LogController.h"
#include "MemoryAccessLogController.h"
#include "MultiplayerController.h"
#include "Override.h"

#include <QAbstractButton>
#include <QDateTime>
#include <QMessageBox>
#include <QMutexLocker>

#include <mgba/core/serialize.h>
#include <mgba/core/version.h>
#include <mgba/feature/video-logger.h>
#ifdef M_CORE_GBA
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/renderers/cache-set.h>
#include <mgba/internal/gba/sharkport.h>
#endif
#ifdef M_CORE_GB
#include <mgba/internal/gb/gb.h>
#include <mgba/internal/gb/renderers/cache-set.h>
#endif
#include "feature/sqlite3/no-intro.h"
#include <mgba-util/math.h>
#include <mgba-util/vfs.h>

#include <QSettings>

#ifdef M_CORE_GBA
#include "sio_link.h"
#endif

#include "moc_CoreController.cpp"

#if defined(M_CORE_GBA) || defined(M_CORE_GB)
namespace {

// The mobile layer owns the GBALuminanceSource inside its emulator struct and
// recovers the owner with offsetof. The Qt frontend already attaches
// InputController's luminance source (mPERIPH_GBA_LUMINANCE), so the solar
// slider drives that one instead of inventing a second source: no container
// trick, no pointer arithmetic on a foreign struct.

QSettings& featureSettings() {
	static QSettings settings(QStringLiteral("mGBAx"), QStringLiteral("features"));
	return settings;
}

}
#endif

#define AUTOSAVE_GRANULARITY 600

using namespace QGBA;

CoreController::CoreController(mCore* core, QObject* parent)
	: QObject(parent)
	, m_loadStateFlags(SAVESTATE_SCREENSHOT | SAVESTATE_RTC)
	, m_saveStateFlags(SAVESTATE_SCREENSHOT | SAVESTATE_SAVEDATA | SAVESTATE_CHEATS | SAVESTATE_RTC)
{
	m_threadContext.core = core;
	m_threadContext.userData = this;
	updateROMInfo();

#ifdef M_CORE_GBA
	GBASIODolphinCreate(&m_dolphin);
#endif

#ifdef ENABLE_DEBUGGERS
	mDebuggerInit(&m_debugger);
#endif

	m_resetActions.append([this]() {
		if (m_autoload) {
			mCoreLoadState(m_threadContext.core, 0, m_loadStateFlags);
		}
	});

	m_threadContext.startCallback = [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);

		switch (context->core->platform(context->core)) {
#ifdef M_CORE_GBA
		case mPLATFORM_GBA:
			context->core->setPeripheral(context->core, mPERIPH_GBA_LUMINANCE, controller->m_inputController->luminance());
			break;
#endif
		default:
			break;
		}

		controller->updateFastForward();

		if (controller->m_multiplayer) {
			controller->m_multiplayer->attachGame(controller);
			controller->updatePlayerSave();
		}

		if (controller->m_override) {
			controller->m_override->identify(context->core);
			context->core->setOverride(context->core, controller->m_override->raw());
		}

		QMetaObject::invokeMethod(controller, "started");
	};

	m_threadContext.resetCallback = [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		for (auto& action : controller->m_resetActions) {
			action();
		}

		controller->m_resetActions.clear();
		controller->m_frameCounter = -1;

		if (!controller->m_hwaccel) {
			context->core->setVideoBuffer(context->core, reinterpret_cast<mColor*>(controller->m_activeBuffer.data()), controller->screenDimensions().width());
		}

		QString message(tr("Reset r%1-%2 %3").arg(gitRevision).arg(QLatin1String(gitCommitShort)).arg(controller->m_crc32, 8, 16, QLatin1Char('0')));
		QMetaObject::invokeMethod(controller, "didReset");
		if (controller->m_showResetInfo) {
			QMetaObject::invokeMethod(controller, "statusPosted", Q_ARG(const QString&, message));
		}
		controller->finishFrame();
	};

	m_threadContext.frameCallback = [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);

		if (controller->m_autosaveCounter == AUTOSAVE_GRANULARITY) {
			if (controller->m_autosave) {
				mCoreSaveState(context->core, 0, controller->m_saveStateFlags);
			}
			controller->m_autosaveCounter = 0;
		}
		++controller->m_autosaveCounter;

		controller->finishFrame();
	};

	m_threadContext.cleanCallback = [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);

		if (controller->m_autosave) {
			mCoreSaveState(context->core, 0, controller->m_saveStateFlags);
		}

		controller->clearMultiplayerController();
#ifdef M_CORE_GBA
		controller->detachDolphin();
#endif
		QMetaObject::invokeMethod(controller, "stopping");
	};

	m_threadContext.pauseCallback = [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);

		QMetaObject::invokeMethod(controller, "paused");
	};

	m_threadContext.unpauseCallback = [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);

		QMetaObject::invokeMethod(controller, "unpaused");
	};

	m_logger.self = this;
	m_logger.log = [](mLogger* logger, int category, enum mLogLevel level, const char* format, va_list args) {
		CoreLogger* logContext = static_cast<CoreLogger*>(logger);

		static const char* savestateMessage = "State %i saved";
		static const char* loadstateMessage = "State %i loaded";
		static const char* savestateFailedMessage = "State %i failed to load";
		static int biosCat = -1;
		static int statusCat = -1;
		if (!logContext) {
			return;
		}
		CoreController* controller = logContext->self;
		QString message;
		if (biosCat < 0) {
			biosCat = mLogCategoryById("gba.bios");
		}
		if (statusCat < 0) {
			statusCat = mLogCategoryById("core.status");
		}
#ifdef M_CORE_GBA
		if (level == mLOG_STUB && category == biosCat) {
			va_list argc;
			va_copy(argc, args);
			int immediate = va_arg(argc, int);
			va_end(argc);
			QMetaObject::invokeMethod(controller, "unimplementedBiosCall", Q_ARG(int, immediate));
		} else
#endif
		if (category == statusCat) {
			// Slot 0 is reserved for suspend points
			if (strncmp(loadstateMessage, format, strlen(loadstateMessage)) == 0) {
				va_list argc;
				va_copy(argc, args);
				int slot = va_arg(argc, int);
				va_end(argc);
				if (slot == 0) {
					format = "Loaded suspend state";
				}
			} else if (strncmp(savestateFailedMessage, format, strlen(savestateFailedMessage)) == 0 || strncmp(savestateMessage, format, strlen(savestateMessage)) == 0) {
				va_list argc;
				va_copy(argc, args);
				int slot = va_arg(argc, int);
				va_end(argc);
				if (slot == 0) {
					return;
				}
			}
			va_list argc;
			va_copy(argc, args);
			message = QString::vasprintf(format, argc);
			va_end(argc);
			QMetaObject::invokeMethod(controller, "statusPosted", Q_ARG(const QString&, message));
		}
		message = QString::vasprintf(format, args);
		QMetaObject::invokeMethod(controller, "logPosted", Q_ARG(int, level), Q_ARG(int, category), Q_ARG(const QString&, message));
		if (level == mLOG_FATAL && !controller->m_crashSeen) {
			controller->m_crashSeen = true;
			QMetaObject::invokeMethod(controller, "crashed", Q_ARG(const QString&, message));
		}
	};
	m_threadContext.logger.logger = &m_logger;
}

CoreController::~CoreController() {
	endVideoLog();
	stop();
	disconnect();

	mCoreThreadJoin(&m_threadContext);

#ifdef ENABLE_DEBUGGERS
	mDebuggerDeinit(&m_debugger);
#endif

	if (m_cacheSet) {
		mCacheSetDeinit(m_cacheSet.get());
		m_cacheSet.reset();
	}

	mCoreConfigDeinit(&m_threadContext.core->config);
	m_threadContext.core->deinit(m_threadContext.core);
}

void CoreController::setPath(const QString& path, const QString& base) {
	m_path = path;
	m_baseDirectory = base;
}

const mColor* CoreController::drawContext() {
	if (m_hwaccel) {
		return nullptr;
	}
	QMutexLocker locker(&m_bufferMutex);
	return reinterpret_cast<const mColor*>(m_completeBuffer.constData());
}

QImage CoreController::getPixels() {
	QByteArray buffer;
	QSize size = screenDimensions();
	size_t stride = size.width() * BYTES_PER_PIXEL;

	if (!m_hwaccel) {
		buffer = m_completeBuffer;
	} else {
		Interrupter interrupter(this);
		const void* pixels;
		m_threadContext.core->getPixels(m_threadContext.core, &pixels, &stride);
		stride *= BYTES_PER_PIXEL;
		buffer = QByteArray::fromRawData(static_cast<const char*>(pixels), stride * size.height());
	}

	QImage image(reinterpret_cast<const uchar*>(buffer.constData()),
	             size.width(), size.height(), stride, QImage::Format_RGBX8888);
	image.bits(); // Cause QImage to detach
	return image;
}

bool CoreController::isPaused() {
	return mCoreThreadIsPaused(&m_threadContext);
}

bool CoreController::hasStarted() {
	return mCoreThreadHasStarted(&m_threadContext);
}

mPlatform CoreController::platform() const {
	return m_threadContext.core->platform(m_threadContext.core);
}

QSize CoreController::screenDimensions() const {
	unsigned width, height;
	m_threadContext.core->currentVideoSize(m_threadContext.core, &width, &height);

	return QSize(width, height);
}

unsigned CoreController::videoScale() const {
	return m_threadContext.core->videoScale(m_threadContext.core);
}

void CoreController::loadConfig(ConfigController* config) {
	Interrupter interrupter(this);
	m_loadStateFlags = config->getOption("loadStateExtdata", m_loadStateFlags).toInt();
	m_saveStateFlags = config->getOption("saveStateExtdata", m_saveStateFlags).toInt();
	m_fastForwardRatio = config->getOption("fastForwardRatio", m_fastForwardRatio).toFloat();
	m_fastForwardHeldRatio = config->getOption("fastForwardHeldRatio", m_fastForwardRatio).toFloat();
	m_videoSync = config->getOption("videoSync", m_videoSync).toInt();
	m_audioSync = config->getOption("audioSync", m_audioSync).toInt();
	m_fpsTarget = config->getOption("fpsTarget").toFloat();
	m_autosave = config->getOption("autosave", false).toInt();
	m_autoload = config->getOption("autoload", true).toInt();
	m_autofireThreshold = config->getOption("autofireThreshold", m_autofireThreshold).toInt();
	m_fastForwardVolume = config->getOption("fastForwardVolume", -1).toInt();
	m_fastForwardMute = config->getOption("fastForwardMute", false).toInt();
	/* 用户上次保存的静音选择要在焦点重载后保持；音量保持 -1（跟随
	 * config），否则会永久盖掉「倍速音量」这个独立设置。 */
	m_userVolume = -1;
	m_userMute = config->getOption("mute", false).toInt();
	mCoreConfigCopyValue(&m_threadContext.core->config, config->config(), "volume");
	mCoreConfigCopyValue(&m_threadContext.core->config, config->config(), "mute");
	m_preload = config->getOption("preload", true).toInt();

	QSize sizeBefore = screenDimensions();
	m_activeBuffer.resize(256 * 224 * sizeof(mColor));
	m_threadContext.core->setVideoBuffer(m_threadContext.core, reinterpret_cast<mColor*>(m_activeBuffer.data()), sizeBefore.width());

	mCoreLoadForeignConfig(m_threadContext.core, config->config());

	QSize sizeAfter = screenDimensions();
	m_activeBuffer.resize(sizeAfter.width() * sizeAfter.height() * sizeof(mColor));
	m_threadContext.core->setVideoBuffer(m_threadContext.core, reinterpret_cast<mColor*>(m_activeBuffer.data()), sizeAfter.width());

	if (hasStarted()) {
		updateFastForward();
		mCoreThreadRewindParamsChanged(&m_threadContext);
	}
#ifdef M_CORE_GB
	if (sizeBefore != sizeAfter) {
		mCoreConfigSetIntValue(&m_threadContext.core->config, "sgb.borders", 0);
		m_threadContext.core->reloadConfigOption(m_threadContext.core, "sgb.borders", nullptr);
		mCoreConfigCopyValue(&m_threadContext.core->config, config->config(), "sgb.borders");
		m_threadContext.core->reloadConfigOption(m_threadContext.core, "sgb.borders", nullptr);
	}
	m_threadContext.core->reloadConfigOption(m_threadContext.core, "gb.pal", config->config());
#endif
#if defined(M_CORE_GBA) || defined(M_CORE_GB)
	applyPersistedFeatures();
#endif
}

#ifdef ENABLE_DEBUGGERS
void CoreController::attachDebugger(bool interrupt) {
	Interrupter interrupter(this);
	if (!m_threadContext.core->debugger) {
		mDebuggerAttach(&m_debugger, m_threadContext.core);
	}
	if (interrupt) {
		mDebuggerEnter(&m_debugger, DEBUGGER_ENTER_ATTACHED, 0);
	}
}

void CoreController::detachDebugger() {
	Interrupter interrupter(this);
	if (!m_threadContext.core->debugger) {
		return;
	}
	m_threadContext.core->detachDebugger(m_threadContext.core);
}

void CoreController::attachDebuggerModule(mDebuggerModule* module, bool interrupt) {
	Interrupter interrupter(this);
	if (module) {
		mDebuggerAttachModule(&m_debugger, module);
	}
	attachDebugger(interrupt);
}

void CoreController::detachDebuggerModule(mDebuggerModule* module) {
	Interrupter interrupter(this);
	mDebuggerDetachModule(&m_debugger, module);
}
#endif

void CoreController::setMultiplayerController(MultiplayerController* controller) {
	if (controller == m_multiplayer) {
		return;
	}
	clearMultiplayerController();
	m_multiplayer = controller;
	if (!mCoreThreadHasStarted(&m_threadContext)) {
		return;
	}
	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* thread) {
		CoreController* controller = static_cast<CoreController*>(thread->userData);
		controller->m_multiplayer->attachGame(controller);
	});
}

void CoreController::clearMultiplayerController() {
	if (!m_multiplayer) {
		return;
	}
	m_multiplayer->detachGame(this);
	m_multiplayer = nullptr;
}

mCacheSet* CoreController::graphicCaches() {
	if (m_cacheSet) {
		return m_cacheSet.get();
	}
	Interrupter interrupter(this);
	switch (platform()) {
#ifdef M_CORE_GBA
	case mPLATFORM_GBA: {
		GBA* gba = static_cast<GBA*>(m_threadContext.core->board);
		m_cacheSet = std::make_unique<mCacheSet>();
		GBAVideoCacheInit(m_cacheSet.get());
		GBAVideoCacheAssociate(m_cacheSet.get(), &gba->video);
		break;
	}
#endif
#ifdef M_CORE_GB
	case mPLATFORM_GB: {
		GB* gb = static_cast<GB*>(m_threadContext.core->board);
		m_cacheSet = std::make_unique<mCacheSet>();
		GBVideoCacheInit(m_cacheSet.get());
		GBVideoCacheAssociate(m_cacheSet.get(), &gb->video);
		break;
	}
#endif
	default:
		return nullptr;
	}
	return m_cacheSet.get();
}

#ifdef M_CORE_GBA
bool CoreController::attachDolphin(const Address& address) {
	if (platform() != mPLATFORM_GBA) {
		return false;
	}
	if (GBASIODolphinConnect(&m_dolphin, &address, 0, 0)) {
		clearMultiplayerController();
		m_threadContext.core->setPeripheral(m_threadContext.core, mPERIPH_GBA_LINK_PORT, &m_dolphin.d);
		return true;
	}
	return false;
}

void CoreController::detachDolphin() {
	if (platform() == mPLATFORM_GBA) {
		// TODO: Reattach to multiplayer controller
		m_threadContext.core->setPeripheral(m_threadContext.core, mPERIPH_GBA_LINK_PORT, NULL);
	}
	GBASIODolphinDestroy(&m_dolphin);
}

bool CoreController::lanLinkHost(quint16 port) {
	return lanLinkHostPlayers(port, 2);
}

/* players：本局人数。2 走原来的两人直连（行为不变）；3/4 走星型总线 ——
 * 主机 accept 最多 players-1 个从机，每轮收齐所有人的字后一次广播。两边
 * 填的人数必须一致：总线和两人直连是两种包格式，TCP 能连上但解不出包。 */
bool CoreController::lanLinkHostPlayers(quint16 port, int players) {
	if (!m_lanLink) {
		m_lanLink = sioLinkCreate();
	}
	return m_lanLink && sioLinkHostPlayers(m_lanLink, port, players);
}

bool CoreController::lanLinkJoin(const QString& host, quint16 port) {
	return lanLinkJoinPlayers(host, port, 2);
}

bool CoreController::lanLinkJoinPlayers(const QString& host, quint16 port, int players) {
	if (!m_lanLink) {
		m_lanLink = sioLinkCreate();
	}
	return m_lanLink && sioLinkJoinPlayers(m_lanLink, host.toUtf8().constData(), port, players);
}

void CoreController::lanLinkClose() {
	if (m_lanLink) {
		sioLinkDestroy(m_lanLink);
		m_lanLink = nullptr;
	}
}

int CoreController::lanLinkState() const {
	return m_lanLink ? sioLinkState(m_lanLink) : 0;
}

int CoreController::lanLinkPlayer() const {
	return m_lanLink ? sioLinkPlayer(m_lanLink) : -1;
}

int CoreController::lanLinkPlayers() const {
	return m_lanLink ? sioLinkPlayerCount(m_lanLink) : 2;
}

// ---- mobile-parity features ----

void CoreController::setChannelVolumes(const int gains[6]) {
	for (int i = 0; i < 6; ++i) {
		m_channelGains[i] = gains[i];
	}
	Interrupter interrupter(this);
	if (m_threadContext.core && m_threadContext.core->board) {
		switch (platform()) {
#ifdef M_CORE_GBA
		case mPLATFORM_GBA: {
			struct GBA* gba = static_cast<struct GBA*>(m_threadContext.core->board);
			for (int i = 0; i < 4; ++i) {
				gba->audio.psg.chGain[i] = static_cast<int16_t>(gains[i]);
			}
			gba->audio.chGainA = static_cast<int16_t>(gains[4]);
			gba->audio.chGainB = static_cast<int16_t>(gains[5]);
			break;
		}
#endif
#ifdef M_CORE_GB
		case mPLATFORM_GB: {
			struct GB* gb = static_cast<struct GB*>(m_threadContext.core->board);
			for (int i = 0; i < 4; ++i) {
				gb->audio.chGain[i] = static_cast<int16_t>(gains[i]);
			}
			break;
		}
#endif
		default:
			break;
		}
	}
	QByteArray stored;
	for (int i = 0; i < 6; ++i) {
		stored.append(reinterpret_cast<const char*>(&m_channelGains[i]), sizeof(int));
	}
	featureSettings().setValue("channelGains", stored);
}

void CoreController::channelVolumes(int gains[6]) const {
	for (int i = 0; i < 6; ++i) {
		gains[i] = m_channelGains[i];
	}
}

#ifdef M_CORE_GBA
void CoreController::setSolarLevel(int level) {
	if (level > 10) {
		level = 10;
	} else if (level < -1) {
		level = -1;
	}
	m_solarLevel = level;
	featureSettings().setValue("solarLevel", level);
	if (platform() != mPLATFORM_GBA || !m_threadContext.core) {
		return;
	}
	Interrupter interrupter(this);
	struct GBA* gba = static_cast<struct GBA*>(m_threadContext.core->board);
	if (level >= 0) {
		// Drive the console's own 0-10 sunlight scale through the luminance
		// source the frontend already attached (InputController's), then force
		// the cartridge hardware bit so games that do not auto-detect the
		// sensor (Boktai detects it, most hacks do not) still see it.
		if (m_inputController) {
			m_inputController->setLuminanceLevel(level);
		}
		gba->memory.hw.devices |= HW_LIGHT_SENSOR;
	} else {
		if (m_inputController) {
			m_inputController->setLuminanceLevel(0);
		}
		gba->memory.hw.devices &= ~HW_LIGHT_SENSOR;
	}
}

void CoreController::setCartRumble(bool enabled) {
	m_cartRumble = enabled;
	featureSettings().setValue("cartRumble", enabled ? 1 : 0);
	if (platform() != mPLATFORM_GBA || !m_threadContext.core) {
		return;
	}
	Interrupter interrupter(this);
	struct GBA* gba = static_cast<struct GBA*>(m_threadContext.core->board);
	if (enabled) {
		gba->memory.hw.devices |= HW_RUMBLE;
		// Keep whatever mPERIPH_RUMBLE attached; only fill in if the game was
		// loaded before an input driver was available.
		if (!gba->rumble && m_inputController) {
			gba->rumble = m_inputController->rumble();
		}
	} else {
		gba->memory.hw.devices &= ~HW_RUMBLE;
		gba->rumble = NULL;
	}
}
#endif

void CoreController::setGbPalette(const int32_t colors[12]) {
	memcpy(m_gbPalette, colors, sizeof(m_gbPalette));
	m_gbPaletteSet = true;
	QByteArray stored;
	for (int i = 0; i < 12; ++i) {
		stored.append(reinterpret_cast<const char*>(&m_gbPalette[i]), sizeof(int32_t));
	}
	featureSettings().setValue("gbPalette", stored);
	featureSettings().setValue("gbPaletteSet", 1);
	if (platform() == mPLATFORM_GB) {
		Interrupter interrupter(this);
		for (int i = 0; i < 12; ++i) {
			char key[16];
			snprintf(key, sizeof(key), "gb.pal[%d]", i);
			mCoreConfigSetOverrideIntValue(&m_threadContext.core->config, key, m_gbPalette[i]);
		}
		m_threadContext.core->reloadConfigOption(m_threadContext.core, "gb.pal", NULL);
	}
}

void CoreController::clearGbPalette() {
	m_gbPaletteSet = false;
	featureSettings().setValue("gbPaletteSet", 0);
	if (platform() == mPLATFORM_GB) {
		Interrupter interrupter(this);
		for (int i = 0; i < 12; ++i) {
			char key[16];
			snprintf(key, sizeof(key), "gb.pal[%d]", i);
			ConfigurationClearValue(&m_threadContext.core->config.overridesTable, m_threadContext.core->config.port, key);
		}
		m_threadContext.core->reloadConfigOption(m_threadContext.core, "gb.pal", NULL);
	}
}

void CoreController::gbPalette(int32_t colors[12]) const {
	memcpy(colors, m_gbPalette, sizeof(m_gbPalette));
}

void CoreController::setAudioHoldMode(int mode) {
	if (mode < 0 || mode > 2) {
		mode = 0;
	}
	if (m_audioHoldMode == mode) {
		return;
	}
	m_audioHoldMode = mode;
	featureSettings().setValue("audioHoldMode5", mode);
	syncAudioHold();
	// The fast-forward pacing depends on the mode (the music feature turns the
	// free-running fast-forward into a controlled one), so re-apply it now.
	if (m_fastForward || m_fastForwardForced) {
		updateFastForward();
	}
}

void CoreController::setAudioHoldRatio(double ratio) {
	if (ratio < 2.0 || ratio > 32.0) {
		// 1x would pace the core at native speed and make the turbo key do
		// nothing; the smallest useful controlled fast-forward is 2x.
		return;
	}
	if (fabs(ratio - m_audioHoldRatio) < 0.01) {
		return;
	}
	m_audioHoldRatio = ratio;
	featureSettings().setValue("audioHoldRatio", ratio);
	syncAudioHold();
	if (m_fastForward || m_fastForwardForced) {
		updateFastForward();
	}
}

void CoreController::setAudioHoldRate(double rate) {
	if (rate < 0.5 || rate > 4.0) {
		return;
	}
	if (fabs(rate - m_audioHoldRate) < 0.01) {
		return;
	}
	m_audioHoldRate = rate;
	featureSettings().setValue("audioHoldRate2", rate);
	syncAudioHold();
}

void CoreController::syncAudioHold() {
	if (!m_threadContext.impl) {
		return;
	}
	m_threadContext.impl->sync.audioHoldMode = m_audioHoldMode;
	m_threadContext.impl->sync.audioHoldRatio = m_audioHoldRatio;
	m_threadContext.impl->sync.audioHoldRate = m_audioHoldRate;
}

void CoreController::audioHoldState(bool* on, double* stretch, double* rate) const {
	// The hold feature only does something in the two stretch modes
	// (1 = WSOLA, 2 = native "skip a section"). Mode 0 is "变调" - the pitch
	// follows the game, which is exactly what the user is trying to avoid, so
	// it must never engage the stretcher.
	if (m_audioHoldMode == 0) {
		if (on) {
			*on = false;
		}
		return;
	}
	mCore* core = m_threadContext.core;
	double nativeFps = core ? mCoreCalculateFramerateRatio(core, 1.0) : 0.0;
	if (nativeFps <= 0.0) {
		if (on) {
			*on = false;
		}
		return;
	}
	// Decide purely from the core's live pacing: updateFastForward sets
	// sync.fpsTarget to (m_fpsTarget * m_audioHoldRatio) the instant a
	// fast-forward starts, in ANY hold mode, and restores it to the native
	// target the moment it stops. The emulation thread never writes this
	// field, so reading it here is a stable, race-free reflection of whether
	// the game is actually running faster than native. Tying the decision to
	// this - rather than to m_fastForward, which the audio thread may not
	// observe at the same instant - is what makes the hold engage reliably.
	double speed = m_threadContext.impl->sync.fpsTarget / nativeFps;
	if (!(speed > 1.05 && speed < 64.0)) {
		/* The game is not actually running faster than native, so there is no
		 * surplus to absorb and the music needs no help. */
		if (on) {
			*on = false;
		}
		return;
	}
	if (on) {
		*on = true;
	}
	/* The music may play faster than its own tempo, but never slower than the
	 * game runs - slowing it down would need compression, not stretching. */
	double musicRate = m_audioHoldRate > 0.05 ? m_audioHoldRate : 1.0;
	if (musicRate > speed) {
		musicRate = speed;
	}
	if (rate) {
		*rate = musicRate;
	}
	if (stretch) {
		/* The surplus has to be compressed by this much: the game runs at
		 * `speed`, the music plays at `musicRate`, so the stretcher has to
		 * absorb the difference. */
		*stretch = speed / musicRate;
	}
}

void CoreController::applyPersistedFeatures() {
	QSettings& settings = featureSettings();
	/* Key bumped (audioHoldMode4 -> audioHoldMode5) so configs that stored
	 * mode 1 pick up the new default. Mode 1 (WSOLA) keeps the PITCH but
	 * uniformly compresses 4 s of music into 1 s of wall clock, so the melody
	 * still advances at 4x - it is NOT "1x speed" (audiodiag.log shows
	 * rate=1.00 stretch=4.02 and the user still hears the tune racing).
	 * Mode 2 (NATIVE) plays real untransposed samples at exactly 1x
	 * wall-clock tempo and cuts whole surplus sections at quiet gaps, which is
	 * what 音乐一倍速 actually means. Its ring-drift bug was fixed earlier
	 * (natR = natW on the degenerate cut); both hold/audioff tests cover it. */
	m_audioHoldMode = settings.value("audioHoldMode5", 2).toInt();
	if (m_audioHoldMode < 0 || m_audioHoldMode > 2) {
		m_audioHoldMode = 2;
	}
	m_audioHoldRatio = settings.value("audioHoldRatio", 4.0).toDouble();
	/* 1x used to be offered as a fast-forward ratio, but it paced the core at
	 * its native speed and so made the turbo key do nothing. Treat any value
	 * below 2x as the 4x default so fast-forward always actually speeds up. */
	if (m_audioHoldRatio < 2.0 || m_audioHoldRatio > 32.0) {
		m_audioHoldRatio = 4.0;
	}
	/* Key bumped (audioHoldRate -> audioHoldRate2) to drop any stale value.
	 * The default stays 1.0: only then does WSOLA hold the music at BOTH its
	 * original tempo and its original pitch. Higher music rates deliberately
	 * let the pitch follow the game partway - the resampler's source rate is
	 * scaled by the music rate, so 2x comes out an octave up (880 Hz from a
	 * 440 Hz tone, proved by the audioff CASE_4X_RATE2 scenario). That is a
	 * valid "brighter / faster tune" option but it is NOT pitch-held, so it
	 * must never be the default for a feature whose whole point is 不变调. */
	m_audioHoldRate = settings.value("audioHoldRate2", 1.0).toDouble();
	if (m_audioHoldRate < 0.5 || m_audioHoldRate > 4.0) {
		m_audioHoldRate = 1.0;
	}
	syncAudioHold();
	QByteArray stored = settings.value("channelGains").value<QByteArray>();
	if (stored.size() == int(6 * sizeof(int))) {
		int gains[6];
		memcpy(gains, stored.constData(), sizeof(gains));
		setChannelVolumes(gains);
	}
#ifdef M_CORE_GBA
	int solar = settings.value("solarLevel", -1).toInt();
	if (solar != m_solarLevel || solar >= 0) {
		setSolarLevel(solar);
	}
	if (settings.value("cartRumble", 0).toInt()) {
		setCartRumble(true);
	}
#endif
	if (settings.value("gbPaletteSet", 0).toInt()) {
		QByteArray pal = settings.value("gbPalette").value<QByteArray>();
		if (pal.size() == int(12 * sizeof(int32_t))) {
			int32_t colors[12];
			memcpy(colors, pal.constData(), sizeof(colors));
			setGbPalette(colors);
		}
	}
}
#endif

void CoreController::setOverride(std::unique_ptr<Override> override) {
	Interrupter interrupter(this);
	m_override = std::move(override);
	m_override->identify(m_threadContext.core);
}

void CoreController::setInputController(InputController* inputController) {
	m_inputController = inputController;
	m_threadContext.core->setPeripheral(m_threadContext.core, mPERIPH_ROTATION, m_inputController->rotationSource());
	m_threadContext.core->setPeripheral(m_threadContext.core, mPERIPH_RUMBLE, m_inputController->rumble());
	m_threadContext.core->setPeripheral(m_threadContext.core, mPERIPH_IMAGE_SOURCE, m_inputController->imageSource());
}

void CoreController::setLogger(LogController* logger) {
	disconnect(m_log);
	m_log = logger;
	m_logger.filter = logger->filter();
	connect(this, &CoreController::logPosted, m_log, &LogController::postLog);
}

#ifdef ENABLE_DEBUGGERS
std::weak_ptr<MemoryAccessLogController> CoreController::memoryAccessLogController() {
	if (!m_malController) {
		m_malController = std::make_shared<MemoryAccessLogController>(this);
	}
	return m_malController;
}
#endif

void CoreController::start() {
	QSize size(screenDimensions());
	m_activeBuffer.resize(size.width() * size.height() * sizeof(mColor));
	m_activeBuffer.fill(0xFF);
	m_completeBuffer = m_activeBuffer;

	m_threadContext.core->setVideoBuffer(m_threadContext.core, reinterpret_cast<mColor*>(m_activeBuffer.data()), size.width());

	if (!m_patched) {
		mCoreAutoloadPatch(m_threadContext.core);
	}
	if (!mCoreThreadStart(&m_threadContext)) {
		emit failed();
		emit stopping();
		return;
	}
	// The thread impl now exists, so the audio-hold settings can finally be
	// mirrored into the sync struct (applyPersistedFeatures could not do it at
	// startup). The SDL audio callback reads them from here.
	syncAudioHold();
}

void CoreController::stop() {
	setSync(false);
#ifdef ENABLE_DEBUGGERS
	if (m_malController) {
		m_malController->stop();
	}

	detachDebugger();
#endif
	setPaused(false);
	mCoreThreadEnd(&m_threadContext);
#ifdef M_CORE_GBA
	lanLinkClose();
#endif
}

void CoreController::reset() {
	m_crashSeen = false;
	mCoreThreadReset(&m_threadContext);
}

void CoreController::setPaused(bool paused) {
	QMutexLocker locker(&m_actionMutex);
	if (paused) {
		if (m_moreFrames < 0) {
			m_moreFrames = 1;
		}
	} else {
		m_moreFrames = -1;
		if (isPaused()) {
			mCoreThreadUnpause(&m_threadContext);
		}
	}
}

void CoreController::frameAdvance() {
	QMutexLocker locker(&m_actionMutex);
	m_moreFrames = 1;
	if (isPaused()) {
		mCoreThreadUnpause(&m_threadContext);
	}
}

void CoreController::addFrameAction(std::function<void ()> action) {
	QMutexLocker locker(&m_actionMutex);
	m_frameActions.append(action);
}

void CoreController::setSync(bool sync) {
	if (sync) {
		m_threadContext.impl->sync.audioWait = m_audioSync;
		m_threadContext.impl->sync.videoFrameWait = m_videoSync;
	} else {
		m_threadContext.impl->sync.audioWait = false;
		m_threadContext.impl->sync.videoFrameWait = false;
	}
}

void CoreController::showResetInfo(bool enable) {
	m_showResetInfo = enable;
}

void CoreController::setRewinding(bool rewind) {
	if (!m_threadContext.core->opts.rewindEnable) {
		if (rewind) {
			emit statusPosted(tr("Rewinding not currently enabled"));
		}
		return;
	}
	if (rewind && m_multiplayer && m_multiplayer->attached() > 1) {
		return;
	}

	if (rewind && isPaused()) {
		setPaused(false);
		// TODO: restore autopausing
	}
	mCoreThreadSetRewinding(&m_threadContext, rewind);
}

void CoreController::rewind(int states) {
	if (!m_threadContext.core->opts.rewindEnable) {
		emit statusPosted(tr("Rewinding not currently enabled"));
	}
	Interrupter interrupter(this);
	if (!states) {
		states = INT_MAX;
	}
	mCoreRewindRestore(&m_threadContext.impl->rewind, m_threadContext.core, states);
	interrupter.resume();
	emit frameAvailable();
	emit rewound();
}

void CoreController::setFastForward(bool enable) {
	if (m_fastForward == enable) {
		return;
	}
	m_fastForward = enable;
	updateFastForward();
	emit fastForwardChanged(enable);
}

void CoreController::forceFastForward(bool enable) {
	if (m_fastForwardForced == enable) {
		return;
	}
	m_fastForwardForced = enable;
	updateFastForward();
	emit fastForwardChanged(enable || m_fastForward);
}

void CoreController::changePlayer(int id) {
	Interrupter interrupter(this);
	int playerId = 0;
	mCoreConfigGetIntValue(&m_threadContext.core->config, "savePlayerId", &playerId);
	if (id == playerId) {
		return;
	}
	interrupter.resume();

	QMessageBox* resetPrompt = new QMessageBox(QMessageBox::Question, tr("Reset the game?"),
		tr("Most games will require a reset to load the new save. Do you want to reset now?"),
		QMessageBox::Yes | QMessageBox::No | QMessageBox::Cancel);
	connect(resetPrompt, &QMessageBox::buttonClicked, this, [this, resetPrompt, id](QAbstractButton* button) {
		Interrupter interrupter(this);
		switch (resetPrompt->standardButton(button)) {
		default:
			return;
		case QMessageBox::Yes:
			mCoreConfigSetOverrideIntValue(&m_threadContext.core->config, "savePlayerId", id);
			m_resetActions.append([this]() {
				updatePlayerSave();
			});
			interrupter.resume();
			reset();
			break;
		case QMessageBox::No:
			mCoreConfigSetOverrideIntValue(&m_threadContext.core->config, "savePlayerId", id);
			updatePlayerSave();
			break;
		}
	});
	resetPrompt->setAttribute(Qt::WA_DeleteOnClose);
	resetPrompt->show();
}

void CoreController::overrideMute(bool override) {
	m_mute = override;

	Interrupter interrupter(this);
	mCore* core = m_threadContext.core;
	/* 用户在设置/菜单里主动静音后，焦点恢复触发的 overrideMute(false)
	 * 不能把静音解除掉。 */
	if (m_mute || m_userMute) {
		core->opts.mute = true;
	} else {
		if (m_fastForward || m_fastForwardForced) {
			core->opts.mute = m_fastForwardMute;
		} else {
			mCoreConfigGetBoolValue(&core->config, "mute", &core->opts.mute);
		}
	}
	core->reloadConfigOption(core, NULL, NULL);
}

void CoreController::setVolume(int volume) {
	m_userVolume = volume;
	Interrupter interrupter(this);
	mCore* core = m_threadContext.core;
	core->opts.volume = volume;
	core->reloadConfigOption(core, NULL, NULL);
}

void CoreController::setMute(bool mute) {
	m_userMute = mute;
	Interrupter interrupter(this);
	mCore* core = m_threadContext.core;
	/* 焦点丢失/最小化带来的临时静音仍然优先，解除用户静音不会盖过它。 */
	core->opts.mute = mute || m_mute;
	core->reloadConfigOption(core, NULL, NULL);
}

void CoreController::loadState(int slot) {
	if (slot > 0 && slot != m_stateSlot) {
		m_stateSlot = slot;
		m_backupSaveState.clear();
	}
	m_crashSeen = false;
	mCoreThreadClearCrashed(&m_threadContext);
	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		if (!controller->m_backupLoadState.isOpen()) {
			controller->m_backupLoadState = VFileDevice::openMemory();
		}
		mCoreSaveStateNamed(context->core, controller->m_backupLoadState, controller->m_saveStateFlags);
		if (mCoreLoadState(context->core, controller->m_stateSlot, controller->m_loadStateFlags)) {
			emit controller->frameAvailable();
			emit controller->stateLoaded();
		}
	});
}

void CoreController::loadState(const QString& path, int flags) {
	m_statePath = path;
	int savedFlags = m_loadStateFlags;
	if (flags != -1) {
		m_loadStateFlags = flags;
	}
	m_crashSeen = false;
	mCoreThreadClearCrashed(&m_threadContext);
	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		VFile* vf = VFileDevice::open(controller->m_statePath, O_RDONLY);
		if (!vf) {
			return;
		}
		if (!controller->m_backupLoadState.isOpen()) {
			controller->m_backupLoadState = VFileDevice::openMemory();
		}
		mCoreSaveStateNamed(context->core, controller->m_backupLoadState, controller->m_saveStateFlags);
		if (mCoreLoadStateNamed(context->core, vf, controller->m_loadStateFlags)) {
			emit controller->frameAvailable();
			emit controller->stateLoaded();
		}
		vf->close(vf);
	});
	m_loadStateFlags = savedFlags;
}

void CoreController::loadState(QIODevice* iodev, int flags) {
	m_stateVf = VFileDevice::wrap(iodev, QIODevice::ReadOnly);
	if (!m_stateVf) {
		return;
	}
	int savedFlags = m_loadStateFlags;
	if (flags != -1) {
		m_loadStateFlags = flags;
	}
	m_crashSeen = false;
	mCoreThreadClearCrashed(&m_threadContext);
	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		VFile* vf = controller->m_stateVf;
		if (!vf) {
			return;
		}
		if (!controller->m_backupLoadState.isOpen()) {
			controller->m_backupLoadState = VFileDevice::openMemory();
		}
		mCoreSaveStateNamed(context->core, controller->m_backupLoadState, controller->m_saveStateFlags);
		if (mCoreLoadStateNamed(context->core, vf, controller->m_loadStateFlags)) {
			emit controller->frameAvailable();
			emit controller->stateLoaded();
		}
		vf->close(vf);
	});
	m_loadStateFlags = savedFlags;
}

void CoreController::saveState(int slot) {
	if (slot > 0) {
		m_stateSlot = slot;
	}
	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		VFile* vf = mCoreGetState(context->core, controller->m_stateSlot, false);
		if (vf) {
			controller->m_backupSaveState.resize(vf->size(vf));
			vf->read(vf, controller->m_backupSaveState.data(), controller->m_backupSaveState.size());
			vf->close(vf);
		}
		mCoreSaveState(context->core, controller->m_stateSlot, controller->m_saveStateFlags);
	});
}

void CoreController::saveState(const QString& path, int flags) {
	m_statePath = path;
	int savedFlags = m_saveStateFlags;
	if (flags != -1) {
		m_saveStateFlags = flags;
	}
	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		VFile* vf = VFileDevice::open(controller->m_statePath, O_RDONLY);
		if (vf) {
			controller->m_backupSaveState.resize(vf->size(vf));
			vf->read(vf, controller->m_backupSaveState.data(), controller->m_backupSaveState.size());
			vf->close(vf);
		}
		vf = VFileDevice::open(controller->m_statePath, O_RDWR | O_CREAT | O_TRUNC);
		if (!vf) {
			return;
		}
		mCoreSaveStateNamed(context->core, vf, controller->m_saveStateFlags);
		vf->close(vf);
	});
	m_saveStateFlags = savedFlags;
}

void CoreController::saveState(QIODevice* iodev, int flags) {
	m_stateVf = VFileDevice::wrap(iodev, QIODevice::WriteOnly | QIODevice::Truncate);
	if (!m_stateVf) {
		return;
	}
	int savedFlags = m_saveStateFlags;
	if (flags != -1) {
		m_saveStateFlags = flags;
	}
	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		VFile* vf = controller->m_stateVf;
		if (!vf) {
			return;
		}
		mCoreSaveStateNamed(context->core, vf, controller->m_saveStateFlags);
		vf->close(vf);
	});
	m_saveStateFlags = savedFlags;
}

void CoreController::loadBackupState() {
	if (!m_backupLoadState.isOpen()) {
		return;
	}

	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		controller->m_backupLoadState.seek(0);
		if (mCoreLoadStateNamed(context->core, controller->m_backupLoadState, controller->m_loadStateFlags)) {
			mLOG(STATUS, INFO, "Undid state load");
			controller->frameAvailable();
			controller->stateLoaded();
		}
		controller->m_backupLoadState.close();
	});
}

void CoreController::saveBackupState() {
	if (m_backupSaveState.isEmpty()) {
		return;
	}

	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		CoreController* controller = static_cast<CoreController*>(context->userData);
		VFile* vf = mCoreGetState(context->core, controller->m_stateSlot, true);
		if (vf) {
			vf->write(vf, controller->m_backupSaveState.constData(), controller->m_backupSaveState.size());
			vf->close(vf);
			mLOG(STATUS, INFO, "Undid state save");
		}
		controller->m_backupSaveState.clear();
	});
}

void CoreController::loadSave(const QString& path, bool temporary) {
	m_resetActions.append([this, path, temporary]() {
		VFile* vf = VFileDevice::open(path, temporary ? O_RDONLY : O_RDWR);
		if (!vf) {
			LOG(QT, ERROR) << tr("Failed to open save file: %1").arg(path);
			return;
		}

		bool ok;
		if (temporary) {
			ok = m_threadContext.core->loadTemporarySave(m_threadContext.core, vf);
		} else {
			ok = m_threadContext.core->loadSave(m_threadContext.core, vf);
		}
		if (!ok) {
			vf->close(vf);
		} else {
			m_savePath = path;
		}
	});
	if (hasStarted()) {
		reset();
	}
}

void CoreController::loadSave(VFile* vf, bool temporary, const QString& path) {
	m_resetActions.append([this, vf, temporary, path]() {
		bool ok;
		if (temporary) {
			ok = m_threadContext.core->loadTemporarySave(m_threadContext.core, vf);
		} else {
			ok = m_threadContext.core->loadSave(m_threadContext.core, vf);
		}
		if (!ok) {
			vf->close(vf);
		} else {
			m_savePath = path;
		}
	});
	if (hasStarted()) {
		reset();
	}
}

void CoreController::loadPatch(const QString& patchPath) {
	Interrupter interrupter(this);
	VFile* patch = VFileDevice::open(patchPath, O_RDONLY);
	if (patch) {
		m_threadContext.core->loadPatch(m_threadContext.core, patch);
		m_patched = true;
		patch->close(patch);
		updateROMInfo();
	}
	if (mCoreThreadHasStarted(&m_threadContext)) {
		interrupter.resume();
		reset();
	}
}

void CoreController::replaceGame(const QString& path) {
	QFileInfo info(path);
	if (!info.isReadable()) {
		LOG(QT, ERROR) << tr("Failed to open game file: %1").arg(path);
		return;
	}
	QString fname = info.canonicalFilePath();
	Interrupter interrupter(this);
	mDirectorySetDetachBase(&m_threadContext.core->dirs);
	if (m_preload) {
		mCorePreloadFile(m_threadContext.core, fname.toUtf8().constData());
	} else {
		mCoreLoadFile(m_threadContext.core, fname.toUtf8().constData());
	}
	// TODO: Make sure updating the path is handled properly by everything that calls path() and baseDirectory()
	updateROMInfo();
}

void CoreController::yankPak() {
	Interrupter interrupter(this);

	switch (platform()) {
#ifdef M_CORE_GBA
	case mPLATFORM_GBA:
		GBAYankROM(static_cast<GBA*>(m_threadContext.core->board));
		break;
#endif
#ifdef M_CORE_GB
	case mPLATFORM_GB:
		GBYankROM(static_cast<GB*>(m_threadContext.core->board));
		break;
#endif
	case mPLATFORM_NONE:
		LOG(QT, ERROR) << tr("Can't yank pack in unexpected platform!");
		break;
	}
}

void CoreController::addKey(int key) {
	m_activeKeys |= 1 << key;
}

void CoreController::clearKey(int key) {
	m_activeKeys &= ~(1 << key);
	m_removedKeys |= 1 << key;
}

void CoreController::setAutofire(int key, bool enable) {
	if (key >= 32 || key < 0) {
		return;
	}

	m_autofire[key] = enable;
	m_autofireStatus[key] = 0;
}

#ifdef USE_PNG
void CoreController::screenshot() {
	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* context) {
		mCoreTakeScreenshot(context->core);
	});
}
#endif

void CoreController::setRealTime() {
	m_threadContext.core->rtc.override = RTC_NO_OVERRIDE;
}

void CoreController::setFixedTime(const QDateTime& time) {
	m_threadContext.core->rtc.override = RTC_FIXED;
	m_threadContext.core->rtc.value = time.toMSecsSinceEpoch();
}

void CoreController::setFakeEpoch(const QDateTime& time) {
	m_threadContext.core->rtc.override = RTC_FAKE_EPOCH;
	m_threadContext.core->rtc.value = time.toMSecsSinceEpoch();
}

void CoreController::setTimeOffset(qint64 offset) {
	m_threadContext.core->rtc.override = RTC_WALLCLOCK_OFFSET;
	m_threadContext.core->rtc.value = offset * 1000LL;
}

void CoreController::scanCard(const QString& path) {
#ifdef M_CORE_GBA
	QImage image(path);
	if (image.isNull()) {
		QFile file(path);
		if (!file.open(QIODevice::ReadOnly)) {
			return;
		}
		QByteArray eReaderData = file.read(2912);
		if (eReaderData.isEmpty()) {
			return;
		}

		file.seek(0);
		QStringList lines;
		QDir basedir(QFileInfo(path).dir());

		while (true) {
			QByteArray line = file.readLine().trimmed();
			if (line.isEmpty()) {
				break;
			}
			QString filepath(QString::fromUtf8(line));
			if (filepath.isEmpty() || filepath[0] == QChar('#')) {
				continue;
			}
			if (QFileInfo(filepath).isRelative()) {
				lines.append(basedir.filePath(filepath));
			} else {
				lines.append(filepath);
			}
		}
		scanCards(lines);
		m_eReaderData = std::move(eReaderData);
	} else if (image.size() == QSize(989, 44) || image.size() == QSize(639, 44)) {
		const uchar* bits = image.constBits();
		size_t size;
#if (QT_VERSION >= QT_VERSION_CHECK(5, 10, 0))
		size = image.sizeInBytes();
#else
		size = image.byteCount();
#endif
		m_eReaderData.setRawData(reinterpret_cast<const char*>(bits), size);
	}

	mCoreThreadRunFunction(&m_threadContext, [](mCoreThread* thread) {
		CoreController* controller = static_cast<CoreController*>(thread->userData);
		GBACartEReaderQueueCard(static_cast<GBA*>(thread->core->board), controller->m_eReaderData.constData(), controller->m_eReaderData.size());
	});
#endif
}

void CoreController::scanCards(const QStringList& paths) {
	for (const QString& path : paths) {
		scanCard(path);
	}
}

void CoreController::importSharkport(const QString& path) {
#ifdef M_CORE_GBA
	if (platform() != mPLATFORM_GBA) {
		return;
	}
	VFile* vf = VFileDevice::open(path, O_RDONLY);
	if (!vf) {
		LOG(QT, ERROR) << tr("Failed to open snapshot file for reading: %1").arg(path);
		return;
	}
	Interrupter interrupter(this);
	GBASavedataImportSharkPort(static_cast<GBA*>(m_threadContext.core->board), vf, false);
	GBASavedataImportGSV(static_cast<GBA*>(m_threadContext.core->board), vf, false);
	vf->close(vf);
#endif
}

void CoreController::exportSharkport(const QString& path) {
#ifdef M_CORE_GBA
	if (platform() != mPLATFORM_GBA) {
		return;
	}
	VFile* vf = VFileDevice::open(path, O_WRONLY | O_CREAT | O_TRUNC);
	if (!vf) {
		LOG(QT, ERROR) << tr("Failed to open snapshot file for writing: %1").arg(path);
		return;
	}
	Interrupter interrupter(this);
	GBASavedataExportSharkPort(static_cast<GBA*>(m_threadContext.core->board), vf);
	vf->close(vf);
#endif
}

#ifdef M_CORE_GB
void CoreController::attachPrinter() {
	if (platform() != mPLATFORM_GB) {
		return;
	}
	GB* gb = static_cast<GB*>(m_threadContext.core->board);
	clearMultiplayerController();
	GBPrinterCreate(&m_printer);
	m_printer.parent = this;
	m_printer.print = [](GBPrinter* printer, int height, const uint8_t* data) {
		QGBPrinter* qPrinter = reinterpret_cast<QGBPrinter*>(printer);
		QImage image(GB_VIDEO_HORIZONTAL_PIXELS, height, QImage::Format_Indexed8);
		QVector<QRgb> colors;
		colors.append(qRgb(0xF8, 0xF8, 0xF8));
		colors.append(qRgb(0xA8, 0xA8, 0xA8));
		colors.append(qRgb(0x50, 0x50, 0x50));
		colors.append(qRgb(0x00, 0x00, 0x00));
		image.setColorTable(std::move(colors));
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < GB_VIDEO_HORIZONTAL_PIXELS; x += 4) {
				uint8_t byte = data[(x + y * GB_VIDEO_HORIZONTAL_PIXELS) / 4];
				image.setPixel(x + 0, y, (byte & 0xC0) >> 6);
				image.setPixel(x + 1, y, (byte & 0x30) >> 4);
				image.setPixel(x + 2, y, (byte & 0x0C) >> 2);
				image.setPixel(x + 3, y, (byte & 0x03) >> 0);
			}
		}
		QMetaObject::invokeMethod(qPrinter->parent, "imagePrinted", Q_ARG(const QImage&, image));
	};
	Interrupter interrupter(this);
	GBSIOSetDriver(&gb->sio, &m_printer.d);
}

void CoreController::detachPrinter() {
	if (platform() != mPLATFORM_GB) {
		return;
	}
	Interrupter interrupter(this);
	GB* gb = static_cast<GB*>(m_threadContext.core->board);
	GBPrinterDonePrinting(&m_printer);
	GBSIOSetDriver(&gb->sio, nullptr);
}

void CoreController::endPrint() {
	if (platform() != mPLATFORM_GB) {
		return;
	}
	Interrupter interrupter(this);
	GBPrinterDonePrinting(&m_printer);
}
#endif

#ifdef M_CORE_GBA
void CoreController::attachBattleChipGate() {
	if (platform() != mPLATFORM_GBA) {
		return;
	}
	Interrupter interrupter(this);
	clearMultiplayerController();
	GBASIOBattlechipGateCreate(&m_battlechip);
	m_threadContext.core->setPeripheral(m_threadContext.core, mPERIPH_GBA_LINK_PORT, &m_battlechip);
}

void CoreController::detachBattleChipGate() {
	if (platform() != mPLATFORM_GBA) {
		return;
	}
	Interrupter interrupter(this);
	m_threadContext.core->setPeripheral(m_threadContext.core, mPERIPH_GBA_LINK_PORT, nullptr);
}

void CoreController::setBattleChipId(uint16_t id) {
	if (platform() != mPLATFORM_GBA) {
		return;
	}
	Interrupter interrupter(this);
	m_battlechip.chipId = id;
}

void CoreController::setBattleChipFlavor(int flavor) {
	if (platform() != mPLATFORM_GBA) {
		return;
	}
	Interrupter interrupter(this);
	m_battlechip.flavor = flavor;
}
#endif

void CoreController::setAVStream(mAVStream* stream) {
	Interrupter interrupter(this);
	m_threadContext.core->setAVStream(m_threadContext.core, stream);
}

void CoreController::clearAVStream() {
	Interrupter interrupter(this);
	m_threadContext.core->setAVStream(m_threadContext.core, nullptr);
}

void CoreController::clearOverride() {
	m_override.reset();
}

void CoreController::startVideoLog(const QString& path, bool compression) {
	if (m_vl) {
		return;
	}

	VFile* vf = VFileDevice::open(path, O_WRONLY | O_CREAT | O_TRUNC);
	if (!vf) {
		return;
	}
	startVideoLog(vf, compression);
}

void CoreController::startVideoLog(VFile* vf, bool compression) {
	if (m_vl || !vf) {
		return;
	}

	Interrupter interrupter(this);
	m_vl = mVideoLogContextCreate(m_threadContext.core);
	m_vlVf = vf;
	mVideoLogContextSetOutput(m_vl, m_vlVf);
	mVideoLogContextSetCompression(m_vl, compression);
	mVideoLogContextWriteHeader(m_vl, m_threadContext.core);
}

void CoreController::endVideoLog(bool closeVf) {
	if (!m_vl) {
		return;
	}

	Interrupter interrupter(this);
	mVideoLogContextDestroy(m_threadContext.core, m_vl, closeVf);
	if (closeVf) {
		m_vlVf = nullptr;
	}
	m_vl = nullptr;
}

void CoreController::setFramebufferHandle(int fb) {
	Interrupter interrupter(this);
	if (fb < 0) {
		if (!m_hwaccel) {
			return;
		}
		mCoreConfigSetIntValue(&m_threadContext.core->config, "hwaccelVideo", 0);
		m_threadContext.core->setVideoGLTex(m_threadContext.core, -1);
		m_hwaccel = false;
	} else {
		mCoreConfigSetIntValue(&m_threadContext.core->config, "hwaccelVideo", 1);
		m_threadContext.core->setVideoGLTex(m_threadContext.core, fb);
		if (m_hwaccel) {
			return;
		}
		m_hwaccel = true;
	}
	if (hasStarted()) {
		m_threadContext.core->reloadConfigOption(m_threadContext.core, "hwaccelVideo", NULL);
		if (!m_hwaccel) {
			m_threadContext.core->setVideoBuffer(m_threadContext.core, reinterpret_cast<mColor*>(m_activeBuffer.data()), screenDimensions().width());
		}
	}
}

void CoreController::updateKeys() {
	int polledKeys = m_inputController->pollEvents() | updateAutofire();
	int activeKeys = m_activeKeys | polledKeys;
	activeKeys |= m_remoteKeys.load(std::memory_order_relaxed);
	activeKeys |= m_threadContext.core->getKeys(m_threadContext.core) & ~m_removedKeys;
	m_removedKeys = polledKeys;
	m_threadContext.core->setKeys(m_threadContext.core, activeKeys);
	m_lastKeys.store(activeKeys, std::memory_order_relaxed);
}

int CoreController::updateAutofire() {
	int active = 0;
	for (int k = 0; k < 32; ++k) {
		if (!m_autofire[k]) {
			continue;
		}
		++m_autofireStatus[k];
		if (m_autofireStatus[k] >= 2 * m_autofireThreshold) {
			m_autofireStatus[k] = 0;
		} else if (m_autofireStatus[k] >= m_autofireThreshold) {
			active |= 1 << k;
		}
	}
	return active;
}

void CoreController::finishFrame() {
#ifdef M_CORE_GBA
	/* 只读诊断与联机对象无关：联机链路可能要到游戏已经进了菜单才建立，
	 * 甚至整轮都没建立，脚本仍需靠游戏内存判定光标/项目码。 */
	sioLinkDiagCore(m_threadContext.core);
	if (m_lanLink) {
		// Per-frame top-up on the core thread: attaches the SIO driver once
		// the peer connects, re-attaches after a reset, drains requests and
		// publishes our current send register (mirrors mgbaMobilePumpLink).
		sioLinkPump(m_lanLink, m_threadContext.core);
	}
#endif
	if (!m_hwaccel) {
		unsigned width, height;
		m_threadContext.core->currentVideoSize(m_threadContext.core, &width, &height);

		QMutexLocker locker(&m_bufferMutex);
		memcpy(m_completeBuffer.data(), m_activeBuffer.constData(), width * height * BYTES_PER_PIXEL);
	}

	{
		QMutexLocker locker(&m_actionMutex);
		QList<std::function<void ()>> frameActions(m_frameActions);
		m_frameActions.clear();
		for (auto& action : frameActions) {
			action();
		}
		if (m_moreFrames > 0) {
			--m_moreFrames;
			if (!m_moreFrames) {
				mCoreThreadPauseFromThread(&m_threadContext);
			}
		}
		++m_frameCounter;
	}
	updateKeys();

	QMetaObject::invokeMethod(this, "frameAvailable");
}

void CoreController::updatePlayerSave() {
	if (m_saveBlocked) {
		return;
	}
	int savePlayerId = m_multiplayer->saveId(this);

	QString saveSuffix;
	if (savePlayerId < 2) {
		saveSuffix = QLatin1String(".sav");
	} else {
		saveSuffix = QString(".sa%1").arg(savePlayerId);
	}
	QByteArray saveSuffixBin(saveSuffix.toUtf8());
	VFile* save = mDirectorySetOpenSuffix(&m_threadContext.core->dirs, m_threadContext.core->dirs.save, saveSuffixBin.constData(), O_CREAT | O_RDWR);
	if (save) {
		if (!m_threadContext.core->loadSave(m_threadContext.core, save)) {
			save->close(save);
		} else {
			if (m_threadContext.core->dirs.save == m_threadContext.core->dirs.base) {
				m_savePath = m_baseDirectory;
			} else {
				m_savePath = QString::fromUtf8(m_threadContext.core->opts.savegamePath);
			}
			m_savePath += PATH_SEP + QString::fromUtf8(m_threadContext.core->dirs.baseName) + saveSuffix;
		}
	}
}

void CoreController::updateFastForward() {
	// If we have "Fast forward" checked in the menu (m_fastForwardForced)
	// or are holding the fast forward button (m_fastForward):
	if (m_fastForward || m_fastForwardForced) {
		/* 用户显式设定的总音量优先；未显式设定时才用倍速专用音量，
		 * 这样两个设置不会互相覆盖。 */
		if (m_userVolume >= 0) {
			m_threadContext.core->opts.volume = m_userVolume;
		} else if (m_fastForwardVolume >= 0) {
			m_threadContext.core->opts.volume = m_fastForwardVolume;
		}
		m_threadContext.core->opts.mute = m_fastForwardMute || m_mute || m_userMute;
		setSync(false);

		// 倍速声音不变：把快进改成「固定倍率、由音频时钟驱动」的受控快进。
		// 默认的快进是解除同步让核心全速跑：核心的音频环形缓冲以倍速产出，
		// 而重采样器只按 1x 消费，缓冲溢出就丢样本，音乐于是变成断断续续的
		// 「电音」。受控快进把核心产出速率钉死在已知倍率上，与拉伸引擎的
		// 消耗速率一致，零丢弃，而且倍速可预期（不再取决于机器快慢）。
		if (m_audioHoldMode != 0 && m_audioHoldRatio > 1.01) {
			double nativeFps = m_threadContext.core ? mCoreCalculateFramerateRatio(m_threadContext.core, 1.0) : 0.0;
			double base = (m_fpsTarget > 0 ? m_fpsTarget : nativeFps);
			m_threadContext.impl->sync.fpsTarget = base * m_audioHoldRatio;
			m_threadContext.impl->sync.audioWait = true;
		} else if (!m_fastForward) {
			// If we aren't holding the fast forward button
			// then use the non "(held)" ratio
			if (m_fastForwardRatio > 0) {
				m_threadContext.impl->sync.fpsTarget = m_fpsTarget * m_fastForwardRatio;
				m_threadContext.impl->sync.audioWait = true;
			}
		} else {
			// If we are holding the fast forward button,
			// then use the held ratio
			if (m_fastForwardHeldRatio > 0) {
				m_threadContext.impl->sync.fpsTarget = m_fpsTarget * m_fastForwardHeldRatio;
				m_threadContext.impl->sync.audioWait = true;
			}
		}
	} else {
		if (!mCoreConfigGetIntValue(&m_threadContext.core->config, "volume", &m_threadContext.core->opts.volume)) {
			m_threadContext.core->opts.volume = 0x100;
		}
		if (m_userVolume >= 0) {
			m_threadContext.core->opts.volume = m_userVolume;
		}
		mCoreConfigGetBoolValue(&m_threadContext.core->config, "mute", &m_threadContext.core->opts.mute);
		if (m_userMute) {
			m_threadContext.core->opts.mute = true;
		}
		m_threadContext.impl->sync.fpsTarget = m_fpsTarget;
		setSync(true);
	}

	// Mirror the audio-hold settings into the shared sync struct every time we
	// touch pacing. The emulation thread reads them from there (the SDL audio
	// callback has no CoreController to ask), and applyPersistedFeatures
	// cannot do it at startup because the thread impl does not exist yet. If we
	// skip this, sync.audioHoldMode stays 0 and the music stretcher never
	// engages, so the music still races with the game on fast-forward - the
	// exact "still ineffective" symptom.
	syncAudioHold();

	m_threadContext.core->reloadConfigOption(m_threadContext.core, NULL, NULL);
}

void CoreController::updateROMInfo() {
	const NoIntroDB* db = GBAApp::app()->gameDB();
	NoIntroGame game{};
	m_crc32 = 0;
	mCore* core = m_threadContext.core;
	core->checksum(core, &m_crc32, mCHECKSUM_CRC32);

	mGameInfo info;
	core->getGameInfo(core, &info);
	m_internalTitle = QLatin1String(info.title);

#ifdef USE_SQLITE3
	if (db && m_crc32 && NoIntroDBLookupGameByCRC(db, m_crc32, &game)) {
		m_dbTitle = QString::fromUtf8(game.name);
	}
#endif
}

CoreController::Interrupter::Interrupter()
	: m_parent(nullptr)
{
}

CoreController::Interrupter::Interrupter(CoreController* parent)
	: m_parent(parent)
{
	interrupt();
}

CoreController::Interrupter::Interrupter(std::shared_ptr<CoreController> parent)
	: m_parent(parent.get())
{
	interrupt();
}

CoreController::Interrupter::Interrupter(const Interrupter& other)
	: m_parent(other.m_parent)
{
	interrupt();
}

CoreController::Interrupter::~Interrupter() {
	resume();
}

CoreController::Interrupter& CoreController::Interrupter::operator=(const Interrupter& other)
{
	interrupt(other.m_parent);
	return *this;
}

void CoreController::Interrupter::interrupt(CoreController* controller) {
	if (m_parent != controller) {
		CoreController* old = m_parent;
		m_parent = controller;
		interrupt();
		resume(old);
	}
}

void CoreController::Interrupter::interrupt(std::shared_ptr<CoreController> controller) {
	interrupt(controller.get());
}

void CoreController::Interrupter::interrupt() {
	if (!m_parent || !m_parent->thread()->impl) {
		return;
	}

	if (mCoreThreadGet() != m_parent->thread()) {
		mCoreThreadInterrupt(m_parent->thread());
	} else {
		mCoreThreadInterruptFromThread(m_parent->thread());
	}
}

void CoreController::Interrupter::resume() {
	resume(m_parent);
	m_parent = nullptr;
}

void CoreController::Interrupter::resume(CoreController* controller) {
	if (!controller || !controller->thread()->impl) {
		return;
	}

	mCoreThreadContinue(controller->thread());
}

bool CoreController::Interrupter::held() const {
	return m_parent && m_parent->thread()->impl;
}
