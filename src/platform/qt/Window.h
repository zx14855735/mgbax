/* Copyright (c) 2013-2017 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QAction>
#include <QDateTime>
#include <QElapsedTimer>
#include <QList>
#include <QMainWindow>
#include <QTimer>

#include <functional>
#include <memory>

#include <mgba/core/core.h>
#include <mgba/core/thread.h>

#include "ActionMapper.h"
#include "InputController.h"
#include "LoadSaveState.h"
#include "LogController.h"
#include "SettingsView.h"
#ifdef ENABLE_SCRIPTING
#include "scripting/ScriptingController.h"
#endif

class QLabel;
class QToolButton;

namespace QGBA {

class AiTranslate;
class AiOverlay;
class AudioProcessor;
class ConfigController;
class CoreController;
class CoreManager;
class DebuggerConsoleController;
class Display;
class DolphinConnector;
class ScriptedControl;
class EnhancementsView;
class LinkView;
class LobbyView;
class WebDavView;
class FrameView;
class GDBController;
class GIFView;
class LibraryController;
class LogView;
class OverrideView;
class SensorView;
class ShaderSelector;
class ShortcutController;
class VideoView;
class WindowBackground;

class Window : public QMainWindow {
Q_OBJECT

public:
	Window(CoreManager* manager, ConfigController* config, int playerId = 0, QWidget* parent = nullptr);
	virtual ~Window();

	std::shared_ptr<CoreController> controller() { return m_controller; }

	void setConfig(ConfigController*);
	ConfigController* config() { return m_config; }

	void argumentsPassed();

	void resizeFrame(const QSize& size);

	void updateMultiplayerStatus(bool canOpenAnother);
	void updateMultiplayerActive(bool active);

	InputController* inputController() { return &m_inputController; }

	QSize contentSize(bool fallback) const;

signals:
	void startDrawing();
	void shutdown();
	void paused(bool);
	void shaderSelectorAdded(ShaderSelector*);

public slots:
	void setController(CoreController* controller);
	void selectROM();
	void bootBIOS();
#ifdef USE_SQLITE3
	void selectROMInArchive();
	void addDirToLibrary();
#endif
	void selectSave(bool temporary);
	void selectState(bool load);
	void selectPatch();
	void scanCard();
	void parseCard();
	void enterFullScreen();
	void exitFullScreen();
	void toggleFullScreen();
	void loadConfig();
	void reloadConfig();
	void saveConfig();

	void loadCamImage();

	void replaceROM();

	void multiplayerChanged();
	/** 联机倍速（官方 type 9）：本地菜单选中 0.5x/1x/2x/4x（-1/1/2/4）。 */
	void setNetSpeed(int wireValue);
	/** 只同步菜单勾选（收到对端倍速或断开回 1x 时用），不广播。 */
	void reflectNetSpeed(int wireValue);

	void importSharkport();
	void exportSharkport();

	void openSettingsWindow();
	void openSettingsWindow(SettingsView::Page);

	void startVideoLog();

	void openView(QWidget* widget);
	void showMenu(bool);
	/** 把本进程的所有窗口横向并排铺满屏幕（本地双人 = 移动端同屏分屏的等价交互）。 */
	void tileWindows();

#ifdef ENABLE_DEBUGGERS
	void consoleOpen();
#endif

#ifdef ENABLE_GDB_STUB
	void gdbOpen();
#endif

#ifdef ENABLE_SCRIPTING
	void scriptingOpen();
#endif

protected:
	virtual void keyPressEvent(QKeyEvent* event) override;
	virtual void keyReleaseEvent(QKeyEvent* event) override;
	virtual bool eventFilter(QObject*, QEvent*) override;
	virtual void resizeEvent(QResizeEvent*) override;
	virtual void showEvent(QShowEvent*) override;
	virtual void hideEvent(QHideEvent*) override;
	virtual void closeEvent(QCloseEvent*) override;
	virtual void focusInEvent(QFocusEvent*) override;
	virtual void focusOutEvent(QFocusEvent*) override;
	virtual void dragEnterEvent(QDragEnterEvent*) override;
	virtual void dropEvent(QDropEvent*) override;
#ifndef Q_OS_MAC
	virtual void changeEvent(QEvent*) override;
#endif

private slots:
	void gameStarted();
	void gameStopped();
	void gameCrashed(const QString&);
	void gameFailed();
	void unimplementedBiosCall(int);

	void reloadAudioDriver();
	void reloadDisplayDriver();
	void attachDisplay();
	void changeRenderer();

	void tryMakePortable();
	void mustRestart();
	void mustReset();

	void recordFrame();
	void showFPS();
	void focusCheck();

	void updateFrame();
	void updateMute();

	void setLogo();

	void delayedCleanup();

private:
	static const int FPS_TIMER_INTERVAL = 2000;
	static const int MUST_RESTART_TIMEOUT = 10000;

	void setupMenu(QMenuBar*);
	void setupOptions();
	void openStateWindow(LoadSave);
	void takeScreenshot();
	void applyFilters();
	void storePerGameFilter();
	void toggleGifBall(bool enable);
	void startGifRecording();
	void stopGifRecording();
	void applySticker();
	void translateScreen();
	QString perGameSpeedKey() const;
	void storePerGameSpeed();
	void applyPerGameSpeed();
	void syncFastForwardSpeedMenu(float ratio);

	void attachWidget(QWidget* widget);
	void detachWidget();

	void appendMRU(const QString& fname);
	void clearMRU();
	void updateMRU();

	void ensureScripting();
	void recalculateFrameSize(const QSize&);

	template <typename T, typename... A> std::function<void()> openTView(A... arg);
	template <typename T, typename... A> std::function<void()> openControllerTView(A... arg);
	template <typename T, typename... A> std::function<void()> openNamedTView(QPointer<T>*, bool keepalive, A... arg);
	template <typename T, typename... A> std::function<void()> openNamedControllerTView(QPointer<T>*, bool keepalive, A... arg);

	std::shared_ptr<Action> addGameAction(const QString& visibleName, const QString& name, Action::Function action, const QString& menu = {}, const QKeySequence& = {});
	template<typename T, typename V> std::shared_ptr<Action> addGameAction(const QString& visibleName, const QString& name, T* obj, V (T::*action)(), const QString& menu = {}, const QKeySequence& = {});
	template<typename V> std::shared_ptr<Action> addGameAction(const QString& visibleName, const QString& name, V (CoreController::*action)(), const QString& menu = {}, const QKeySequence& = {});
	std::shared_ptr<Action> addGameAction(const QString& visibleName, const QString& name, Action::BooleanFunction action, const QString& menu = {}, const QKeySequence& = {});

	void updateTitle(float fps = -1);

	QString getFiltersArchive() const;

	CoreManager* m_manager;
	std::shared_ptr<CoreController> m_controller;
	ScriptedControl* m_scripted = nullptr;
	std::unique_ptr<AudioProcessor> m_audioProcessor;

	std::unique_ptr<QGBA::Display> m_display;
	QSize m_initialSize;
	QSize m_savedSize;
	int m_savedScale;

	// TODO: Move these to a new class
	ActionMapper m_actions;
	std::shared_ptr<Action> m_netSpeedActions[4];
	QList<std::shared_ptr<Action>> m_gameActions;
	QList<std::shared_ptr<Action>> m_nonMpActions;
	QMultiMap<mPlatform, std::shared_ptr<Action>> m_platformActions;
	std::shared_ptr<Action> m_multiWindow;
	QMap<int, std::shared_ptr<Action>> m_frameSizes;
	QMap<double, std::shared_ptr<Action>> m_ffspeedActions;

	LogController m_log{0};
	LogView* m_logView;
#ifdef ENABLE_DEBUGGERS
	DebuggerConsoleController* m_console = nullptr;
#endif
	LoadSaveState* m_stateWindow = nullptr;
	WindowBackground* m_screenWidget;
	QPixmap m_logo{":/res/mgba-1024.png"};
	ConfigController* m_config;
	InputController m_inputController;
	QList<qint64> m_frameList;
	QElapsedTimer m_frameTimer;
	QTimer m_fpsTimer;
	QTimer m_mustRestart;
	QTimer m_mustReset;
	QStringList m_mruFiles;
	ShortcutController* m_shortcutController;
#if defined(BUILD_GL) || defined(BUILD_GLES2)
	std::unique_ptr<ShaderSelector> m_shaderView;
#endif
	bool m_fullscreenOnStart = false;
	QTimer m_focusCheck;
	bool m_autoresume = false;
	bool m_wasOpened = false;
	QString m_pendingPatch;
	QString m_pendingState;
	bool m_pendingPause = false;
	bool m_pendingClose = false;
	/** 当前画面是否由内置滤镜着色器接管（用于「None」时恢复用户外部 shader）。 */
	bool m_builtinFilterActive = false;
	QPointer<QToolButton> m_gifBall;
	QPointer<AiOverlay> m_aiOverlay;
	AiTranslate* m_aiTranslate = nullptr;
	QPointer<QLabel> m_sticker;
	bool m_gifRecording = false;

	bool m_hitUnimplementedBiosCall;

	bool m_inactiveMute = false;
	bool m_minimizedMute = false;
	bool m_multiActive = true;
	int m_playerId;

	QPointer<OverrideView> m_overrideView;
	QPointer<SensorView> m_sensorView;
	QPointer<DolphinConnector> m_dolphinView;
	QPointer<LinkView> m_linkView;
#ifdef BUILD_QT_CLOUD
	QPointer<LobbyView> m_lobbyView;
#endif
	QPointer<WebDavView> m_webdavView;
#if defined(M_CORE_GBA) || defined(M_CORE_GB)
	QPointer<EnhancementsView> m_enhancementsView;
#endif
	QPointer<FrameView> m_frameView;

#ifdef USE_FFMPEG
	QPointer<VideoView> m_videoView;
	QPointer<GIFView> m_gifView;
#endif

#ifdef ENABLE_GDB_STUB
	GDBController* m_gdbController = nullptr;
#endif

#ifdef USE_SQLITE3
	LibraryController* m_libraryView;
#endif

#ifdef ENABLE_SCRIPTING
	std::unique_ptr<ScriptingController> m_scripting;
#endif

	std::unique_ptr<QGBA::Display> m_cleanupDisplay;
	std::shared_ptr<CoreController> m_cleanupController;

#ifdef BUILD_QT_CLOUD
	/** MGBAX_AUTOLINK 测试钩子：载入游戏后自动进云端联机，见 Window.cpp。 */
	void startAutoCloudLink();
#endif
};

class WindowBackground : public QWidget {
Q_OBJECT

public:
	WindowBackground(QWidget* parent = 0);

	void setPixmap(const QPixmap& pixmap);
	void setSizeHint(const QSize& size);
	virtual QSize sizeHint() const override;
	void setDimensions(int width, int height);
	void setLockIntegerScaling(bool lock);
	void setLockAspectRatio(bool lock);

	const QPixmap& pixmap() const { return m_pixmap; }

protected:
	virtual void paintEvent(QPaintEvent*) override;

private:
	QPixmap m_pixmap;
	QSize m_sizeHint;
	int m_aspectWidth;
	int m_aspectHeight;
};

}
