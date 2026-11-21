#!/bin/bash
# 打包 Windows 单文件版（自解压到临时目录后启动 mGBA）。
#
# 为什么不用真·静态链接：本机 msys64 只有动态 Qt，静态构建要先编一套静态 Qt（数小时），
# 因此这里用 PyInstaller onefile 把 exe + 全部依赖打进一个文件，运行时解到 %TEMP%\_MEI*。
#
# 用法：bash tools/build-single-file.sh
set -euo pipefail
export PATH="/c/msys64/mingw64/bin:$PATH"

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

echo "[1/4] windeployqt 收集 Qt 依赖 → dist-portable/"
rm -rf dist-portable && mkdir -p dist-portable
cp -f build-win/mGBA.exe dist-portable/
windeployqt --release --no-system-d3d-compiler --no-opengl-sw --no-quick-import dist-portable/mGBA.exe >/dev/null

echo "[2/4] 补齐 windeployqt 不处理的依赖"
# mGBA.exe 运行时还要 libmgba.dll（objdump 的直接导入列表里看不到它）
cp -f build-win/libmgba.dll dist-portable/
for d in libgcc_s_seh-1.dll libstdc++-6.dll libwinpthread-1.dll libepoxy-0.dll; do
  [ -f "dist-portable/$d" ] || cp -f "/c/msys64/mingw64/bin/$d" dist-portable/ || true
done

echo "[2.5/4] 递归补齐传递依赖（关键！）"
# windeployqt 只覆盖直接依赖；Qt6 还依赖 pcre2/zlib/libpng/freetype/harfbuzz/icu 等，
# 缺任一个都会让 mGBA.exe 以 0xC0000135(STATUS_DLL_NOT_FOUND) 静默退出。
# 注意：不要在 PATH 含 msys64/bin 的情况下「试跑」portable 目录 —— 那样缺的库会被 PATH 补上，
# 看起来能跑，但打成单文件后必然失败（这正是第一版踩的坑）。
python - "$ROOT/dist-portable" <<'PYEOF'
import subprocess, os, shutil, glob, re, sys
root = sys.argv[1]
mingw = r"C://msys64//mingw64//bin"
def deps(path):
    try:
        out = subprocess.run(["ldd", path], capture_output=True, text=True).stdout
    except Exception:
        return []
    return [os.path.basename(m.group(1)) for m in re.finditer(r"=>\s+(\S+)", out)]
queue = glob.glob(os.path.join(root, "**", "*.exe"), recursive=True) + \
        glob.glob(os.path.join(root, "**", "*.dll"), recursive=True)
seen, copied = set(), []
while queue:
    for base in deps(queue.pop()):
        if base in seen:
            continue
        seen.add(base)
        src = os.path.join(mingw, base)
        if not os.path.isfile(src):
            continue
        dst = os.path.join(root, base)
        if not os.path.exists(dst):
            shutil.copy2(src, dst)
            copied.append(base)
        queue.append(dst)
print("   追加 %d 个传递依赖" % len(copied))
PYEOF

echo "[3/4] PyInstaller onefile 打包"
rm -rf .zcode-tmp/single/build .zcode-tmp/single/dist
# 注意：--add-data 的源路径按 spec 所在目录解析，必须给绝对路径，否则报
# "Unable to find ...\dist-portable when adding binary and data files"
python -m PyInstaller --noconfirm --clean --onefile --noconsole \
  --name mGBAx-single \
  --distpath .zcode-tmp/single/dist \
  --workpath .zcode-tmp/single/build \
  --specpath .zcode-tmp/single \
  --add-data "$(cygpath -w "$ROOT/dist-portable");." \
  tools/single-file-launch.py >/dev/null

echo "[4/4] 输出"
mkdir -p out
cp -f .zcode-tmp/single/dist/mGBAx-single.exe out/
ls -la out/mGBAx-single.exe
echo "完成：out/mGBAx-single.exe"
