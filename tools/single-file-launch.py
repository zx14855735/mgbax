# -*- coding: utf-8 -*-
"""mGBAx 单文件启动器。

PyInstaller onefile 会把 dist-portable 的内容解到临时目录（sys._MEIPASS），目录结构保持原样。
这里做三件事：
  1. 显式设定 Qt 插件路径（否则插件找不到会「静默退出、返回 0」，很难查）；
  2. 把启动过程写进 %TEMP%\\mGBAx-single.log，出问题能直接看到 mGBA 的退出码与输出；
  3. 子进程异常退出时，把解压目录另存一份，便于定位缺哪个文件。
"""
import os
import shutil
import subprocess
import sys
import time

base = getattr(sys, "_MEIPASS", os.path.dirname(os.path.abspath(__file__)))
exe = os.path.join(base, "mGBA.exe")
log_path = os.path.join(os.environ.get("TEMP", base), "mGBAx-single.log")


def log(msg):
    try:
        with open(log_path, "a", encoding="utf-8") as f:
            f.write("[%s] %s\n" % (time.strftime("%H:%M:%S"), msg))
    except Exception:
        pass


log("=== launch ===")
log("MEIPASS=%s" % base)
log("exe=%s exists=%s" % (exe, os.path.isfile(exe)))
os.environ.setdefault("QT_PLUGIN_PATH", base)
os.environ.setdefault("QT_QPA_PLATFORM_PLUGIN_PATH", os.path.join(base, "platforms"))
log("QT_PLUGIN_PATH=%s" % os.environ["QT_PLUGIN_PATH"])
log("platforms exists=%s" % os.path.isdir(os.path.join(base, "platforms")))
os.chdir(base)

if not os.path.isfile(exe):
    log("FATAL mGBA.exe missing")
    sys.exit(2)

try:
    rc = subprocess.call([exe] + sys.argv[1:])
except Exception as exc:  # noqa: BLE001 - 需要把任何异常写进日志
    log("EXCEPTION %r" % (exc,))
    sys.exit(3)

log("mGBA exited rc=%s" % rc)
if rc != 0:
    keep = os.path.join(os.environ.get("TEMP", base), "mGBAx-single-failed")
    try:
        if os.path.isdir(keep):
            shutil.rmtree(keep, ignore_errors=True)
        shutil.copytree(base, keep)
        log("kept extraction dir at %s" % keep)
    except Exception as exc:  # noqa: BLE001
        log("keep failed %r" % (exc,))
sys.exit(rc)
