#!/usr/bin/env bash
# 4 核进程内锁步「进对战」诊断套件的可重复入口（long，单独门控）。
#
# 背景：2026-11-15 实测发现三个会制造假阴性的因素：
#   1) 旧默认 BUSGAME_FRAMES=3000 小于进战斗稳定帧 f≈3073，必然 BATTLE=NO；
#   2) 直接把 D:/gen8/rom.sav 传给用例时，运行会回写该共享存档，下一次
#      起始状态就变了，同一套参数可能从 BATTLE=YES 变成 BATTLE=NO；
#   3) 判据把 battle_main.o .text 写死成旧 ROM 布局的绝对区间；而
#      /d/gen8 的 decomp 工程被并发会话反复重编译，代码整体平移，
#      明明进了 BattleMainCB2 也会报 BATTLE=NO（T-03 根因诊断）。
# 现在 gboylink_test.cpp 改为按 ROM 身份动态解析判据窗口：从 .map 读
# `.text <start> <size> src/battle_main.o` / BattleMainCB2 符号，用「符号在
# 段内偏移 + 段长」这套相对几何算窗口，再用当前 ROM 段首 12 字节序言校验；
# 找不到 .map 报 STALE_BATTLE_WINDOW 而不是静默退回旧常量。
#
# 因此本脚本每次把 ROM 与其 .map **一起快照**到独立工作目录（只读副本），
# 不再直接读会被并发重建的 D:/gen8/rom.gba；存档也从只读母本现拷。
# 结果文件 ls_result.txt 现在带 ROM md5 / mtime / 动态窗口 / cb2rel 相对序列，
# 换 ROM 后结论不会再串线。
set -euo pipefail

cd /d/mgba-android-version
export PATH="/c/msys64/mingw64/bin:$PATH"

WORK=".zcode-tmp/busgame-run"
mkdir -p "$WORK"

# --- ROM + map 快照（避开 /d/gen8 的并发重编译）-------------------------
SRC_ROM="/d/gen8/rom.gba"
SRC_MAP="/d/gen8/rom.map"
cp -f "$SRC_ROM" "$WORK/rom.gba"
if [ -f "$SRC_MAP" ]; then
    cp -f "$SRC_MAP" "$WORK/rom.map"
else
    echo "WARN: $SRC_MAP 不存在，用例将尝试工作区符号表；仍可能 STALE_BATTLE_WINDOW" >&2
fi
# 快照完整性：大小必须是 32 MiB，且 md5/mtime 记录下来供审计
ROM_SIZE=$(stat -c '%s' "$WORK/rom.gba")
if [ "$ROM_SIZE" != "33554432" ]; then
    echo "ERROR: ROM 快照大小异常 ($ROM_SIZE)，疑似并发重编译撕裂，放弃本次运行" >&2
    exit 3
fi
echo "ROM snapshot: size=$ROM_SIZE"
stat -c '  src mtime=%y' "$SRC_ROM"
md5sum "$WORK/rom.gba"

cp -f tmp_bus/rom.sav "$WORK/rom.sav"

BUSGAME_FRAMES=9000 \
BUSGAME_TIMEOUT_MS=260000 \
BUSGAME_MODE_DOWNS=2 \
BUSGAME_MENU_AT=1500 \
BUSGAME_HSL=1 \
BUSGAME_LOGLEVEL=0 \
  build-win/qt/test-gboylink.exe busgame-lockstep \
  "D:/mgba-android-version/$WORK/rom.gba" \
  "D:/mgba-android-version/$WORK/rom.sav" 4
