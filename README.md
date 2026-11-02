# mGBAx (iOS)

基于 [mGBA](https://mgba.io)（MPL-2.0）的 iOS GBA/GB 模拟器，与同系列 Android 版共享模拟核心（`src/platform/mobile/`）。

特性：皮肤/按键自定义布局、倒带、倍速（音乐保持原速）、GBoy/My Boy 兼容 WiFi 联机、云大厅、AI 覆盖层、WebDAV 同步等。

## 本仓库说明

这是一个 **CI 镜像仓库**，只包含 iOS 构建所需内容（App：`ios/`；核心：`src/` + `include/` + 根 `CMakeLists.txt`），不含开发主仓库的全部内容与历史。

## CI

推送到 `main` 或手动触发 `workflow_dispatch` 会运行 macOS runner：

1. CMake 编译 mGBA 核心（`ios/build-core.sh`，静态库 `libmgba_ios.a`）
2. Xcode 为 iOS 模拟器构建 App（`ios/mGBA.xcodeproj`，product: `mGBAx`）
3. 启动 iPhone 模拟器 → 安装 → 启动 App → 20 秒存活检查 → 截图上传 Artifacts
4. **`ipa` job**：同时产出**未签名真机 IPA**（Artifact `mgbax-unsigned-ipa`）
5. 手动勾选 "release" 触发时：签名归档 → 上传 TestFlight（需先配置 secrets）

## 安装到 iPhone（免费，无需开发者账号）

每次构建的 [Artifacts](https://github.com/zx14855735/mgbax-ios/actions) 里下载 `mgbax-unsigned-ipa`，二选一：

- **TrollStore**（iOS 14.0~16.6.1、17.0 支持）：设备已装 TrollStore 的话，直接打开 IPA 安装，**永久有效、无需刷新**。
- **Sideloadly**（任意 iOS 版本，Windows/Mac 工具）：数据线连 iPhone，把 IPA 拖进 [Sideloadly](https://sideloadly.io)，用自己的免费 Apple ID 签名安装。限制：**每 7 天需重新签名**，每个 Apple ID 最多 3 个自签 App。

> TestFlight / App Store 正式分发需要 Apple 开发者账号（$99/年）。CI 的 `release` 流水线已就绪，配置 secrets 后一键上传。

## License

MPL-2.0，见 [LICENSE](LICENSE)。上游项目 mGBA 版权归 Jeffrey Pfau 及贡献者所有。
