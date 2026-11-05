import os
import sys
import subprocess

# 当被 PyInstaller 打成单文件后，所有 dist 内容会被解压到 sys._MEIPASS；
# 未打包（直接 python stub.py）时则回退到脚本所在目录，方便调试。
BASE = getattr(sys, "_MEIPASS", os.path.dirname(os.path.abspath(__file__)))
EXE = os.path.join(BASE, "mGBA.exe")

LOG = os.path.join(
    os.environ.get("TEMP", BASE),
    "mGBAx_launch.log",
)


def log(msg):
    try:
        with open(LOG, "a", encoding="utf-8") as f:
            f.write(msg + "\n")
    except Exception:
        pass


def main():
    # 每次运行先清空上次的诊断日志（写在 TEMP，出错时便于排查）
    try:
        open(LOG, "w", encoding="utf-8").close()
    except Exception:
        pass
    log("=== mGBAx launch %s ===" % sys.argv)
    log("BASE=%s exists=%s" % (BASE, os.path.isdir(BASE)))
    log("EXE=%s exists=%s" % (EXE, os.path.exists(EXE)))
    if not os.path.exists(EXE):
        log("ERROR: 找不到 mGBA.exe")
        sys.stderr.write("找不到 mGBA.exe (在 %s)\n" % EXE)
        sys.exit(1)
    # 透传任何命令行参数（如双击 .gba 打开、-- 选项等）
    args = [EXE] + sys.argv[1:]
    # cwd 设为解压根目录，保证 Qt 插件(platforms/ 等)与 SDL2.dll 能被找到
    log("launching: %s cwd=%s" % (args, BASE))
    try:
        proc = subprocess.Popen(
            args, cwd=BASE,
            stdout=open(os.path.join(os.environ.get("TEMP", BASE), "mGBAx_stdout.log"), "w", encoding="utf-8", errors="replace"),
            stderr=subprocess.STDOUT,
        )
    except Exception as e:
        log("ERROR spawning mGBA: %r" % e)
        sys.exit(2)
    try:
        rc = proc.wait()
    except KeyboardInterrupt:
        proc.terminate()
        rc = 1
    log("mGBA exited rc=%s" % rc)
    sys.exit(rc)


if __name__ == "__main__":
    main()
