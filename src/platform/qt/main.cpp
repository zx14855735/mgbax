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
		// 调用栈：Release 里没有行号，但符号表还在，把每个返回地址的
		// "模块内偏移"打出来，再用 addr2line 还原成函数名。
		void* frames[40];
		USHORT count = CaptureStackBackTrace(0, 40, frames, nullptr);
		fprintf(f, "frames=%u\n", count);
		for (USHORT i = 0; i < count; ++i) {
			fprintf(f, "frame%u=%llX\n", i,
			        (unsigned long long) ((uintptr_t) frames[i] - (uintptr_t) base));
		}
		fclose(f);
	}
	return EXCEPTION_EXECUTE_HANDLER;
}
#endif

int main(int argc, char* argv[]) {
#ifdef Q_OS_WIN
	AttachConsole(ATTACH_PARENT_PROCESS);
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

	QTranslator qtTranslator;
#if (QT_VERSION < QT_VERSION_CHECK(6, 0, 0))
	if (qtTranslator.load(locale, "qt", "_", QLibraryInfo::location(QLibraryInfo::TranslationsPath))) {
#else
	if (qtTranslator.load(locale, "qt", "_", QLibraryInfo::path(QLibraryInfo::TranslationsPath))) {
#endif
		application.installTranslator(&qtTranslator);
	}

#ifdef QT_STATIC
	QTranslator qtStaticTranslator;
	qtStaticTranslator.load(locale, "qtbase", "_", ":/translations/");
	application.installTranslator(&qtStaticTranslator);
#endif

	QTranslator langTranslator;
	if (langTranslator.load(locale, binaryName, "-", ":/translations/")) {
		application.installTranslator(&langTranslator);
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
