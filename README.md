# mGBAx 三端合一构建仓（PC / Android / iOS）

mGBAx 的公开镜像与持续构建仓：**PC(Qt)**、**Android**、**iOS** 三端源码同仓，
push 即由 GitHub Actions 在三大系统上完整编译验证（含模拟器启动冒烟测试）。

基于 [mGBA](https://mgba.io)（MPL-2.0）。特性：皮肤/按键自定义布局、倒带、
倍速（音乐保持原速）、GBoy/My Boy 兼容 WiFi 联机、本机多核锁步、云大厅、
AI 覆盖层、WebDAV 同步等。

> 本仓是内部主仓库的**无历史净镜像**：只含可公开的源码与文档，不含逆向材料、
> ROM 与 git 历史。开发在内部仓库进行，本仓由脚本单向同步。

## 目录

| 目录 | 内容 |
|---|---|
| `src/` | 三端共用核心（mGBA 核心 + mobile 联机层 + Qt 桌面端） |
| `include/` | 核心头文件 |
| `android/` | Android App（Gradle，NDK 经根 `CMakeLists.txt` 编核心） |
| `ios/` | iOS App（Xcode 工程，`build-core.sh` 先 cmake 静态核心） |
| `*.md` | 三端使用教程 |

## 直接编译

### PC（Windows / MSYS2 mingw64）

```bash
pacman -S --needed mingw-w64-x86_64-toolchain mingw-w64-x86_64-cmake \
  mingw-w64-x86_64-ninja mingw-w64-x86_64-pkgconf \
  mingw-w64-x86_64-qt6-base mingw-w64-x86_64-qt6-multimedia \
  mingw-w64-x86_64-qt6-websockets mingw-w64-x86_64-qt6-tools \
  mingw-w64-x86_64-SDL2 mingw-w64-x86_64-libepoxy mingw-w64-x86_64-libpng \
  mingw-w64-x86_64-zlib mingw-w64-x86_64-freetype mingw-w64-x86_64-sqlite3 \
  mingw-w64-x86_64-xz mingw-w64-x86_64-ffmpeg mingw-w64-x86_64-wineditline
export PATH=/c/msys64/mingw64/bin:$PATH
cmake -G Ninja -S . -B build -DCMAKE_BUILD_TYPE=Release -DBUILD_LTO=OFF \
      -DBUILD_QT=ON -DBUILD_SDL=ON -DBUILD_SHARED=ON
cmake --build build --target mgba-qt
./build/mGBA.exe
```

### Android（Android Studio 或命令行）

```bash
cd android && ./gradlew :app:assembleDebug
# 产物: android/app/build/outputs/apk/debug/app-debug.apk
```

首次构建会自动下载 NDK 28.2 并经根 `CMakeLists.txt` 编译核心。

### iOS（需 macOS/Xcode，或看 CI 产物）

```bash
cd ios && bash build-core.sh          # cmake 出静态核心
open mGBA.xcodeproj                    # Xcode 选 iphonesimulator 运行
```

## CI

| 工作流 | Runner | 内容 |
|---|---|---|
| `ios-build.yml` | macos-15 | cmake 核心 + xcodebuild + 模拟器启动存活 20s + 截图；附带未签名 IPA 产物（TrollStore/Sideloadly 可装） |
| `android-build.yml` | ubuntu | Gradle `assembleDebug`，APK 传 Artifacts |
| `pc-build.yml` | windows | MSYS2 全依赖 + Ninja 编 `mgba-qt` |

隐私政策：https://zx14855735.github.io/mgbax-ios/
