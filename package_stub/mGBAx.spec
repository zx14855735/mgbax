# -*- mode: python ; coding: utf-8 -*-
import os

HERE = os.getcwd()                                          # 调用时 cwd = workspace 根
STUB = os.path.join(HERE, 'package_stub', 'stub.py')
DIST = os.path.join(HERE, 'build-win', 'dist')

# 把 build-win/dist 下所有文件（含子目录 platforms/、imageformats/、shaders/ 等）
# 作为数据嵌进单文件 exe，运行时解压到临时目录(_MEIPASS)。排除开发用头文件
# 目录 include/ 以减小体积（运行时完全不需要）。
datas = []
for root, dirs, files in os.walk(DIST):
    if 'include' in dirs:
        dirs.remove('include')  # 不递归进开发用头文件
    for f in files:
        full = os.path.join(root, f)
        rel = os.path.relpath(full, DIST).replace(os.sep, '/')
        dst = os.path.dirname(rel)
        if not dst or dst == '.':
            dst = '.'  # PyInstaller datas 的第二个元素是"目标目录"，不能用文件名
        datas.append((full, dst))  # (源绝对路径, 目标目录)

a = Analysis(
    [STUB],
    pathex=[],
    binaries=[],
    datas=datas,
    hiddenimports=[],
    hookspath=[],
    hooksconfig={},
    runtime_hooks=[],
    excludes=[],
    noarchive=False,
)

pyz = PYZ(a.pure)

exe = EXE(
    pyz,
    a.scripts,
    a.binaries,
    a.datas,
    [],
    name='mGBAx',
    debug=False,
    bootloader_ignore_signals=False,
    strip=False,
    upx=False,
    runtime_tmpdir=None,
    console=False,
    disable_windowed_traceback=False,
    argv_emulation=False,
    target_arch=None,
    codesign_identity=None,
    entitlements_file=None,
)
