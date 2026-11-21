/* Copyright (c) 2013-2014 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

// This must be defined before anything else is included.
#define SDL_MAIN_HANDLED

#include "ConfigController.h"
#include "GBAApp.h"
#include "Window.h"

#include <mgba/core/version.h>
#include <mgba/gba/interface.h>

#ifdef BUILD_SDL
#define SDL_MAIN_HANDLED
#include "platform/sdl/sdl-events.h"
#if SDL_VERSION_ATLEAST(3, 0, 0)
#include <SDL_main.h>
#endif
#endif

#include <QLibraryInfo>
#include <QTranslator>
#include "MgbaTranslate.h"

#ifdef BUILD_GLES2
#include <QSurfaceFormat>
#endif

#ifdef QT_STATIC
#include <QtPlugin>
#ifdef Q_OS_WIN
Q_IMPORT_PLUGIN(QJpegPlugin);
Q_IMPORT_PLUGIN(QWindowsIntegrationPlugin);
Q_IMPORT_PLUGIN(QWindowsVistaStylePlugin);
#ifdef BUILD_QT_MULTIMEDIA
Q_IMPORT_PLUGIN(QWindowsAudioPlugin);
Q_IMPORT_PLUGIN(DSServicePlugin);
#endif
#elif defined(Q_OS_MAC)
Q_IMPORT_PLUGIN(QCocoaIntegrationPlugin);
#ifdef BUILD_QT_MULTIMEDIA
Q_IMPORT_PLUGIN(CoreAudioPlugin);
Q_IMPORT_PLUGIN(AVFServicePlugin);
#endif
#elif defined(Q_OS_UNIX)
Q_IMPORT_PLUGIN(QXcbIntegrationPlugin);
Q_IMPORT_PLUGIN(QWaylandIntegrationPlugin);
#endif
#endif

#ifdef Q_OS_WIN
#include <process.h>
#include <wincon.h>
extern "C" __declspec (dllexport) DWORD NoHotPatch = 0x1;
#else
#include <unistd.h>
#endif

using namespace QGBA;

#ifdef Q_OS_WIN
#include <windows.h>
#include <cstdio>
#include <QDir>

/**
 * 崩溃现场落地：Windows 上进程被 SIGSEGV 带走时什么都不会留下，联机这种
 * 「跑几分钟才炸」的问题根本无从下手。这里把异常码、出错地址和模块基址写进
 * %TEMP%\mgba_crash.txt，再用 addr2line 减一下就知道崩在哪个函数。
 * 只在设置了 MGBAX_CRASH_LOG=1 时安装，正常使用完全不参与。
 */
static LONG WINAPI crashFilter(EXCEPTION_POINTERS* info) {
	char path[MAX_PATH];
	const char* temp = getenv("TEMP");
	snprintf(path, sizeof(path), "%s\\mgba_crash.txt", temp ? temp : ".");
	FILE* f = fopen(path, "w");
	if (f) {
		HMODULE base = GetModuleHandle(nullptr);
		fprintf(f, "code=%08lX\n",
		        info->ExceptionRecord ? info->ExceptionRecord->ExceptionCode : 0);
		fprintf(f, "address=%p\n", info->ExceptionRecord ? info->ExceptionRecord->ExceptionAddress : nullptr);
		fprintf(f, "base=%p\n", (void*) base);
		fprintf(f, "offset=%llX\n",
		        (unsigned long long) ((uintptr_t) (info->ExceptionRecord ? info->ExceptionRecord->ExceptionAddress : nullptr)
		                              - (uintptr_t) base));
		if (info->ExceptionRecord && info->ExceptionRecord->NumberParameters >= 2) {
			fprintf(f, "param0=%llX\nparam1=%llX\n",
			        (unsigned long long) info->ExceptionRecord->ExceptionInformation[0],
			        (unsigned long long) info->ExceptionRecord->ExceptionInformation[1]);
		}
		/* 出错地址可能在 libmgba.dll / Qt DLL 里，不能一律减 exe 基址：
		 * 23:01 那次战斗崩溃的 frame1..6 全被算成 0x6Axxxxxxxx 这种
		 * 无意义的巨大偏移，就是因为把 DLL 地址减了 mGBA.exe 的基址。 */
		void* fault = info->ExceptionRecord ? (void*) info->ExceptionRecord->ExceptionAddress : nullptr;
		HMODULE faultMod = NULL;
		char faultName[MAX_PATH] = "?";
		if (fault && GetModuleHandleExA(GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS
		                               | GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT,
		                               (LPCSTR) fault, &faultMod)) {
			GetModuleFileNameA(faultMod, faultName, MAX_PATH);
		}
		fprintf(f, "faultModule=%s+%llX\n", faultName,
		        (unsigned long long) ((uintptr_t) fault - (uintptr_t) faultMod));
		// 调用栈：Release 里没有行号，但符号表还在；每个返回地址都单独
		// 解析所属模块，输出「模块名 + 模块内偏移」，再用 nm 还原函数名。
		void* frames[40];
		USHORT count = CaptureStackBackTrace(0, 40, frames, nullptr);
		fprintf(f, "frames=%u\n", count);
		for (USHORT i = 0; i < count; ++i) {
			HMODULE mod = NULL;
			char name[MAX_PATH] = "?";
			if (GetModuleHandleExA(GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS
			                       | GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT,
			                       (LPCSTR) frames[i], &mod)) {
				GetModuleFileNameA(mod, name, MAX_PATH);
			}
			fprintf(f, "frame%u=%p module=%s+%llX\n", i, frames[i], name,
			        (unsigned long long) ((uintptr_t) frames[i] - (uintptr_t) mod));
		}
		fclose(f);
	}
	return EXCEPTION_EXECUTE_HANDLER;
}
#endif

int main(int argc, char* argv[]) {
#ifdef Q_OS_WIN
	AttachConsole(ATTACH_PARENT_PROCESS);
	/* 联机锁步时每一轮 SIO 都要在两个线程之间来回唤醒一次，一帧 9 轮。
	 * Windows 默认定时器精度 15.6ms，condvar/select 的毫秒级等待会被拖到
	 * 一个 tick 才醒来 —— 9×15.6≈140ms/帧，实测只有 4.6fps。把系统定时器
	 * 提到 1ms 后等待才能真正按毫秒返回。动态加载 winmm，避免改链接配置。 */
	{
		typedef UINT (WINAPI *TimePeriodFn)(UINT);
		HMODULE winmm = LoadLibraryA("winmm.dll");
		if (winmm) {
			TimePeriodFn begin = (TimePeriodFn) (void*) GetProcAddress(winmm, "timeBeginPeriod");
			if (begin) {
				begin(1);
			}
		}
	}
	if (!qEnvironmentVariableIsEmpty("MGBAX_CRASH_LOG")) {
		SetUnhandledExceptionFilter(crashFilter);
	}
#endif
#ifdef BUILD_SDL
#if SDL_VERSION_ATLEAST(2, 0, 0) // CPP does not shortcut function lookup
	SDL_SetMainReady();
#endif
#endif

	ConfigController configController;

	QLocale locale;
	if (!configController.getQtOption("language").isNull()) {
		locale = QLocale(configController.getQtOption("language").toString());
		QLocale::setDefault(locale);
	}

	if (configController.parseArguments(argc, argv)) {
		if (configController.args()->showHelp) {
			configController.usage(argv[0]);
			return 0;
		}
		if (configController.args()->showVersion) {
			version(argv[0]);
			return 0;
		}
	} else {
		configController.usage(argv[0]);
		return 1;
	}

	QApplication::setApplicationName(projectName);
	QApplication::setApplicationVersion(projectVersion);
#if (QT_VERSION < QT_VERSION_CHECK(6, 0, 0))
	QApplication::setAttribute(Qt::AA_UseHighDpiPixmaps, true);
#endif
#if (QT_VERSION > QT_VERSION_CHECK(5, 14, 0))
	QApplication::setHighDpiScaleFactorRoundingPolicy(Qt::HighDpiScaleFactorRoundingPolicy::Round);
#endif

#ifdef BUILD_GLES2
	QSurfaceFormat format;
	format.setVersion(3, 0);
	QSurfaceFormat::setDefaultFormat(format);
#endif

	GBAApp application(argc, argv, &configController);

#ifndef Q_OS_MAC
	QApplication::setWindowIcon(QIcon(":/res/mgba-256.png"));
#endif

#ifdef Q_OS_UNIX
	QApplication::setDesktopFileName(QString("io.mgba.mGBA"));
#endif

	/* 本项目以中文为默认界面语言：无条件加载 zh_CN，而不是跟随系统 locale。
	 * 原因：系统 locale 为 en 时会命中 mgba-en.ts（英文源串），中文用户看到的仍是英文；
	 * 而我们新增的 GBoy / 联机界面源码里本来就是中文，源串回退也不会变英文。
	 * 需要对比原版英文或排查翻译问题时，用环境变量覆盖，例如
	 *   MGBAX_LANG=en     → 加载 mgba-en.ts（英文）
	 *   MGBAX_LANG=none   → 不装应用翻译，直接显示源串
	 * 其余语言（de/ja/ko/ru…）同理由 MGBAX_LANG 指定。 */
	QString uiLang = qEnvironmentVariable("MGBAX_LANG");
	if (uiLang.isEmpty()) {
		uiLang = QStringLiteral("zh_CN");
	}

	QTranslator qtTranslator;
	/* Qt 自带控件（文件对话框、按钮）也走同一语言，规则同上：先按 uiLang，再退 zh_CN。 */
	QString qtLang = uiLang;
#if (QT_VERSION < QT_VERSION_CHECK(6, 0, 0))
	if (!qtTranslator.load(qtLang, "qt", "_", QLibraryInfo::location(QLibraryInfo::TranslationsPath))) {
		qtTranslator.load(QStringLiteral("zh_CN"), "qt", "_",
		                  QLibraryInfo::location(QLibraryInfo::TranslationsPath));
	}
#else
	if (!qtTranslator.load(qtLang, "qt", "_", QLibraryInfo::path(QLibraryInfo::TranslationsPath))) {
		qtTranslator.load(QStringLiteral("zh_CN"), "qt", "_",
		                  QLibraryInfo::path(QLibraryInfo::TranslationsPath));
	}
#endif
	application.installTranslator(&qtTranslator);

#ifdef QT_STATIC
	QTranslator qtStaticTranslator;
	qtStaticTranslator.load(qtLang, "qtbase", "_", ":/translations/");
	application.installTranslator(&qtStaticTranslator);
#endif

	QTranslator langTranslator;
	bool langLoaded = false;
	if (uiLang.compare(QLatin1String("none"), Qt::CaseInsensitive) != 0) {
		langLoaded = langTranslator.load(uiLang, binaryName, "-", ":/translations/");
		if (!langLoaded && uiLang != QStringLiteral("zh_CN")) {
			/* 指定的语言没有对应 .qm 时退回中文，避免静默显示英文。 */
			langLoaded = langTranslator.load(QStringLiteral("zh_CN"), binaryName, "-",
			                                 ":/translations/");
		}
	}
	if (langLoaded) {
		application.installTranslator(&langTranslator);
	}

	/* 中文界面走项目自带的翻译表（MgbaTranslate.cpp）：按源串查表、忽略 context，
	 * 不依赖 .ts/.qm 的 context 匹配，因此不会出现「译文在文件里但界面不生效」。
	 * 设 MGBAX_LANG=none 可关闭，用来对照原版英文。 */
	static SimpleTranslator zhTable;
	bool zhInstalled = false;
	if (uiLang.startsWith(QStringLiteral("zh"), Qt::CaseInsensitive)) {
		application.installTranslator(&zhTable);
		zhInstalled = true;
	}
	/* 启动自检：把「界面语言 / 翻译表是否挂上 / 一个探针串的翻译结果」写进临时日志。
	 * 排查「界面还是英文」时先看这个文件，能立刻区分「表没挂上」和「键对不上」。 */
	{
		QString logPath = QDir::tempPath() + QStringLiteral("/mgba-startup.log");
		FILE* log = fopen(logPath.toUtf8().constData(), "a");
		if (log) {
			fprintf(log, "uiLang=%s installed=%d probe(Audio/Video)=%s\n",
			        uiLang.toUtf8().constData(), zhInstalled ? 1 : 0,
			        QCoreApplication::translate("QGBA::SettingsView", "Audio/Video")
			                .toUtf8().constData());
			fclose(log);
		}
	}

	Window* w = application.newWindow();
	w->argumentsPassed();

	application.initMultiplayer();

	int ret = application.exec();
	if (ret != 0) {
		return ret;
	}
	QString invoke = application.invokeOnExit();
	if (!invoke.isNull()) {
		QByteArray proc = invoke.toUtf8();
#ifdef Q_OS_WIN
		_execl(proc.constData(), proc.constData(), NULL);
#else
		execl(proc.constData(), proc.constData(), NULL);
#endif
	}

	return ret;
}

#ifdef _WIN32
#include <mgba-util/string.h>
#include <vector>

extern "C"
int wmain(int argc, wchar_t* argv[]) {
	std::vector<char*> argv8;
	for (int i = 0; i < argc; ++i) {
		argv8.push_back(utf16to8(reinterpret_cast<uint16_t*>(argv[i]), wcslen(argv[i]) * 2));
	}
	__argv = argv8.data();
	int ret = main(argc, argv8.data());
	for (char* ptr : argv8) {
		free(ptr);
	}
	return ret;
}
#endif
