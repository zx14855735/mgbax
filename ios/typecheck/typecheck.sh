#!/usr/bin/env bash
# iOS 源码的本地类型检查（Windows，无 iOS SDK）
#
# 原理：
#   Windows 上装不了 iOS SDK，连 Foundation 都用不了（缺 MSVC/UCRT 头文件，
#   `could not build C module 'SwiftOverlayShims'`）。所以这里把 iOS 侧用到的
#   全部 Apple 框架类型用 Swift 重新声明一遍（ios/typecheck/stubs/），
#   再把 ios/mGBA/*.swift 预处理成“同模块可直接看见这些声明”的副本，
#   最后一次 swiftc -typecheck 全部一起检查。
#
#   真正的 Swift 标准库（String/Array/Dictionary/Optional/闭包/泛型/async）
#   是工具链自带的真家伙，这部分检查是真实的。
#
# 用法：
#   bash ios/typecheck/typecheck.sh            # 检查全部
#   bash ios/typecheck/typecheck.sh GBoyLink   # 只检查名字匹配的文件 + 全部 stub
set -u

HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT="$(cd "$HERE/../.." && pwd)"
SRC="$ROOT/ios/mGBA"
BUILD="$HERE/build"

# Windows: Swift toolchain is not on PATH by default. Probe an absolute path so
# this harness works even when invoked from a stripped-PATH environment.
if ! command -v swiftc >/dev/null 2>&1; then
  # Add every Swift bin dir: swiftc.exe + its DLLs (BlocksRuntime.dll, UCRT)
  # live across Toolchains/Runtimes/Tools, so PATH needs all of them.
  for base in \
    /c/Users/*/AppData/Local/Programs/Swift/Toolchains/*/usr/bin \
    /c/Users/*/AppData/Local/Programs/Swift/Runtimes/*/usr/bin \
    /c/Users/*/AppData/Local/Programs/Swift/Tools/* \
    "/c/Program Files/Swift/Toolchains/"*/usr/bin \
    "/c/Program Files/Swift/Runtimes/"*/usr/bin; do
    [ -d "$base" ] && export PATH="$base:$PATH"
  done
fi

# 必须清掉大小写重复的代理变量，否则 swiftc 会因为
# Fatal error: Duplicate values for key 'ProcessEnvironmentKey("http_proxy")' 直接崩。
CLEAN_ENV=(env -u HTTP_PROXY -u HTTPS_PROXY -u ALL_PROXY -u NO_PROXY
               -u http_proxy -u https_proxy -u all_proxy -u no_proxy)

python "$HERE/prepare.py" "$SRC" "$BUILD" >/dev/null || exit 2

if [ $# -gt 0 ]; then
  FILES=()
  for pat in "$@"; do
    for f in "$BUILD"/${pat}*.swift; do [ -e "$f" ] && FILES+=("$f"); done
  done
else
  FILES=("$BUILD"/*.swift)
fi

LOGFILE="$HERE/last-errors.log"
"${CLEAN_ENV[@]}" swiftc -typecheck \
  -module-name mGBA \
  -swift-version 5 \
  -Xcc -Wno-everything \
  "$HERE"/stubs/*.swift "${FILES[@]}" 2>"$LOGFILE"
CODE=$?

if [ -s "$LOGFILE" ]; then
  cat "$LOGFILE"
fi

ERRS=$(grep -c ': error: ' "$LOGFILE" 2>/dev/null || true)
WARNS=$(grep -c ': warning: ' "$LOGFILE" 2>/dev/null || true)
echo "----------------------------------------------------------------"
echo "swiftc -typecheck exit=$CODE  errors=${ERRS:-0}  warnings=${WARNS:-0}"
echo "log: $LOGFILE"
exit $CODE
