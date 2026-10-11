#!/bin/sh
set -eu
ROOT="$(CDPATH= cd -- "$(dirname "$0")/.." && pwd)"
: "${BUILT_PRODUCTS_DIR:?}"
: "${DERIVED_FILE_DIR:?}"
: "${PLATFORM_NAME:?}"
: "${ARCHS:?}"
: "${SDKROOT:?}"
CONFIGURATION="${CONFIGURATION:-Release}"
if [ "$CONFIGURATION" = "Debug" ]; then
	BUILD_TYPE=Debug
else
	BUILD_TYPE=Release
fi
CMAKE="${CMAKE:-cmake}"
if ! command -v "$CMAKE" >/dev/null 2>&1; then
	for candidate in /opt/homebrew/bin/cmake /usr/local/bin/cmake; do
		if [ -x "$candidate" ]; then
			CMAKE="$candidate"
			break
		fi
	done
fi
if ! command -v "$CMAKE" >/dev/null 2>&1; then
	echo "cmake is required to build the mGBA core" >&2
	exit 1
fi
GEN="Unix Makefiles"
if command -v ninja >/dev/null 2>&1; then
	GEN="Ninja"
fi
COMBINED=""
for ARCH in $ARCHS; do
	BUILD="${DERIVED_FILE_DIR}/mgba-${PLATFORM_NAME}-${ARCH}"
	"$CMAKE" -S "$ROOT" -B "$BUILD" -G "$GEN" \
		-DCMAKE_SYSTEM_NAME=iOS \
		-DCMAKE_OSX_SYSROOT="$SDKROOT" \
		-DCMAKE_OSX_ARCHITECTURES="$ARCH" \
		-DCMAKE_OSX_DEPLOYMENT_TARGET=15.0 \
		-DCMAKE_BUILD_TYPE="$BUILD_TYPE" \
		-DBUILD_SDL=OFF \
		-DBUILD_QT=OFF \
		-DBUILD_GL=OFF \
		-DBUILD_GLES2=OFF \
		-DBUILD_GLES3=OFF \
		-DBUILD_LIBRETRO=OFF \
		-DBUILD_PERF=OFF \
		-DBUILD_TEST=OFF \
		-DBUILD_SUITE=OFF \
		-DBUILD_CINEMA=OFF \
		-DBUILD_HEADLESS=OFF \
		-DBUILD_EXAMPLE=OFF \
		-DBUILD_PYTHON=OFF \
		-DBUILD_DOCGEN=OFF \
		-DBUILD_MAINTAINER_TOOLS=OFF \
		-DBUILD_SHARED=OFF \
		-DBUILD_STATIC=ON \
		-DBUILD_LTO=OFF \
		-DENABLE_DEBUGGERS=OFF \
		-DENABLE_SCRIPTING=OFF \
		-DUSE_FFMPEG=OFF \
		-DUSE_EDITLINE=OFF \
		-DUSE_LIBZIP=OFF \
		-DUSE_MINIZIP=OFF \
		-DUSE_SQLITE3=OFF \
		-DUSE_ELF=OFF \
		-DUSE_LUA=OFF \
		-DUSE_JSON_C=OFF \
		-DUSE_FREETYPE=OFF \
		-DUSE_DISCORD_RPC=OFF \
		-DUSE_LZMA=OFF \
		-DUSE_EPOXY=OFF \
		-DUSE_ZLIB=ON \
		-DUSE_PNG=ON \
		-DM_CORE_GBA=ON \
		-DM_CORE_GB=ON \
		-DDISABLE_DEPS=OFF \
		-DPNG_HARDWARE_OPTIMIZATIONS=OFF \
		-DSKIP_GIT=ON
	"$CMAKE" --build "$BUILD" --target mgba_mobile
	ARCH_LIB="${BUILD}/libmgba_ios_${ARCH}.a"
	# shellcheck disable=SC2046
	libtool -static -o "$ARCH_LIB" $(find "$BUILD" -name '*.a' ! -name 'libmgba_ios_*.a')
	COMBINED="$COMBINED $ARCH_LIB"
done
# shellcheck disable=SC2086
lipo -create $COMBINED -output "$BUILT_PRODUCTS_DIR/libmgba_ios.a"
{
	printf '%s\n' "$BUILT_PRODUCTS_DIR/libmgba_ios.a"
	printf '%s\n' "-framework" "Foundation" "-framework" "CoreFoundation"
	if ! nm "$BUILT_PRODUCTS_DIR/libmgba_ios.a" | grep -q ' T _inflate'; then
		printf '%s\n' "-lz"
	fi
} > "$BUILT_PRODUCTS_DIR/mgba_ios.link"
