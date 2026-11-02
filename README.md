# mGBAx (iOS)

基于 [mGBA](https://mgba.io)（MPL-2.0）的 iOS GBA/GB 模拟器，与同系列 Android 版共享模拟核心（`src/platform/mobile/`）。

特性：皮肤/按键自定义布局、倒带、倍速（音乐保持原速）、GBoy/My Boy 兼容 WiFi 联机、云大厅、AI 覆盖层、WebDAV 同步等。

## 本仓库说明

这是一个 **CI 镜像仓库**，只包含 iOS 构建所需内容（App：`ios/`；核心：`src/` + `include/` + 根 `CMakeLists.txt`），不含开发主仓库的全部内容与历史。

## CI

推送到 `main` 或手动触发 `workflow_dispatch` 会运行 macOS runner：

1. CMake 编译 mGBA 核心（`ios/build-core.sh`，静态库 `libmgba_ios.a`）
2. Xcode 为 iOS 模拟器构建 App（`ios/mGBA.xcodeproj`，product: `mGBAx`）
3. 启动 iPhone 模拟器 → 安装 → 启动 App → 20 秒存活检查
4. 上传模拟器截图到 Artifacts（`ios-simulator-shots`）

本地构建：Xcode 打开 `ios/mGBA.xcodeproj`，选 iOS 模拟器直接 Run（需要 cmake）。

## License

MPL-2.0，见 [LICENSE](LICENSE)。上游项目 mGBA 版权归 Jeffrey Pfau 及贡献者所有。
