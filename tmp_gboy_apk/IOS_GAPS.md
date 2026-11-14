# iOS 端（`ios/mGBA/`）功能缺口清单 · 全量版

> 更新：2026-11-15（第 1~3 批已落地）　｜　范围：**PC 或 Android 有、而 iOS 缺 / 半实现**的用户可见功能。
> 依据 `tmp_gboy_apk/FEATURE_MATRIX.md`（85 项三端盘点）+ 逐项复读 `ios/mGBA/` 源码。
> 本机**没有 Xcode**：所有「已做」= `swiftc -parse` 通过，**未编译、未真机**。

## 0. 结论先说

- `Tools → Speed → 0.5x/1x/2x/4x`（PC 新增）iOS **已有等价物**：顶栏「1倍」档位条（0.25/0.5/1/2/4/8/16），
  选 0.5/1/2/4 时 `broadcastLinkSpeed` 发官方 type 9；帧闸 `GBoySpeed.sliceNanos = 1e9/(rate*60)`，
  1x 不覆盖核心帧长。**不算缺口，未改。**
- 真正能「纯 iOS 侧」补齐的：存档撤销、逐帧前进/倒带、手柄/键盘映射、沉浸式、ROM 信息、运行日志、图块与 I/O 调试、
  AV 录像、BLE 联机、卸载卡带、URL/剪贴板调试面、存档格式转换。
- 已接上 mobile C 新接口：视频层枚举/开关、精确逐帧倒带、内存监视（第 8 批）。
- 仍卡在 **C API 未导出/未实现** 的：3D 层位置、GB 相机/打印机/BattleChip/e-Reader（§3.5/§3.6）。
- 卡在 **core 本身没有实现 / 未编进 mobile 库** 的：GB 相机（全仓库 `camera` 0 命中）、GDB、脚本引擎。

## 1. 全量缺口表

优先级：**P1 用户高频 > P2 联机相关 > P3 进阶**。状态：✅ 本端已做 ｜ ◐ 半实现/已用近似方案 ｜ ⛔ 需 C 层或平台不支持（见 §3）。

| # | 优先级 | 功能 | iOS 原状 | 参照实现 | 改动量 | 状态 |
|---|---|---|---|---|---|---|
| 1 | P1 | 撤销读档 / 撤销存档 | ❌ | `Q/Window.cpp undoLoadState/undoSaveState` → `CoreController::loadBackupState` | 110 行 | ✅ 顶栏「撤销」 |
| 2 | P1 | 逐帧前进 | ❌ | `Q/Window.cpp:1575 frameAdvance` | 40 行 | ✅ 顶栏「逐帧」 |
| 3 | P1 | 逐帧倒带 | ❌ | `Q/Window.cpp:1633 frameRewind` | 70 行 | ✅ 顶栏「退一帧」→ `mgbaMobileRewindFrames(core, 1)`（精确，帧号正好 -1） |
| 4 | P1 | 手柄按键重映射 | ❌ 硬编码 `padMask` | `Q/SettingsView.cpp:354 Controllers` | 150 行 | ✅ 设置→输入→手柄按键映射 |
| 5 | P1 | 键盘按键重映射 | ❌ 硬编码 `mapKey` | `Q/SettingsView.cpp:342 Keyboard` | 120 行 | ✅ 设置→输入→键盘按键映射 |
| 6 | P1 | 沉浸式（隐藏系统 UI） | ◐ 仅菜单 4 秒淡出 | `A · immersive`（`EmulatorActivity.java:5632`） | 20 行 | ✅ 画质页开关（状态栏 + Home 指示条） |
| 7 | P1 | ROM 信息（卡带头/存档类型/CRC） | ❌ | `Q/Window.cpp:1464 romInfo → ROMInfo` | 110 行 | ✅ 设置→游戏信息 |
| 8 | P1 | 运行日志查看/导出 | ◐ 仅静态帮助 | `Q/Window.cpp:1870 viewLogs → LogView` | 140 行 | ✅ 设置→运行日志（400 条环形 + 导出） |
| 9 | P1 | 卸载卡带 / 关机 | ❌ | `Q/Window.cpp shutdown / yank` | — | ⛔ 不做（core 单实例无卸载 API；等价：打开另一个 ROM / 回主屏，§3.11） |
| 10 | P1 | 存档格式转换 / `.sps` GameShark 导入导出 | ◐ | `Q/Window.cpp convertSave / importShark / exportShark` | 160 行 | ✅ `.sps` 导入 + 导出（金手指页，按 ROM CRC 记录原始代码）；跨平台存档格式转换仍未做 |
| 11 | P2 | 蓝牙联机 | ❌ | `A/GBoyBluetoothLink.java`（RFCOMM） | 400 行 | ✅ `GBoyBLELink.swift`（BLE GATT 隧道，帧格式不变，§3.1） |
| 12 | P2 | 调试驱动面（Android `io.mgba.android.action.*`） | ◐ 仅启动参数 | `A · 10 组广播` | 120 行 | ✅ `mgba://action?action=…` 扩到 save/load/undo/step/back/speed（§3.10） |
| 13 | P2 | 多窗口本地联机 | ❌ | `Q/Window.cpp multiWindow` | — | ◐ **已有等价物**：进程内 N 核锁步（`GBoyConsoleSet`），iOS 无法开多窗口 |
| 14 | P2 | 帧率目标 15–240/Native | ❌ | `Q/Window.cpp:1809 fpsTarget` | 40 行 | ✅ 等价：`fps/59.7275` 走 `setSpeed`（15→0.25×…240→4.02×，Native→1×），联机按 type 9 白名单广播 |
| 15 | P3 | 视频层 / 音频通道开关 | ◐ | `Q/Window.cpp:1005 videoLayers / audioChannels` | C 30 + iOS 90 | ✅ 图层：`mgbaMobileListVideoLayers/SetVideoLayer`（I/O 页动态列表，id 取 info[i].id）；声道：`vol_ch*` 六路音量 |
| 16 | P3 | 3D 层位置调整 | ❌ | `Q/Window.cpp:1845 placementControl` | C 20 + iOS 60 | ◐ 近似：画质→「画面场景」整体缩放/居中；等 `mgbaMobileSetLayerPlacement` 可升级成单层偏移 |
| 17 | P3 | 独立 tile / map 查看器 | ❌ | `Q/Window.cpp tileWindow / mapWindow` | 200 行 | ✅ 调试→图块（VRAM）；map 由现有 BG 渲染覆盖 |
| 18 | P3 | I/O 寄存器 + 帧检查器 | ❌ | `Q/Window.cpp ioViewer / frameWindow` | 180 行 | ✅ 调试→I/O 与帧状态 |
| 19 | P3 | 内存访问日志 / 视频调试日志 | ❌ | `Q/Window.cpp memoryAccessView / recordVL` | C 40 + iOS 80 | ✅ 条件断点走 `mgbaMobileSetMemoryWatch`（捕获写值变化，len ≤ 64）；仍无读写类型/调用栈 |
| 20 | P3 | AV 录像（带音频） | ❌ | `Q/Window.cpp:1837 recordOutput → VideoView`（FFmpeg） | 240 行 | ✅ H.264 + AAC（主混音 tap），同一 `CACurrentMediaTime` 时间基；取不到音频自动降级纯视频（§3.8） |
| 21 | P3 | 特殊外设：GB 相机 / 打印机 / BattleChip / e-Reader | ❌ | `Q/Window.cpp loadCamImage / gbPrint / bcGate / scanCard` | C 200 + iOS 200 | ◐ 替代：相机图暂存（等 C 接口注入）、打印机=导出画面、e-Reader/BattleChip=金手指（§3.5） |
| 22 | P3 | 调试器 / GDB server | ❌ | `Q/Window.cpp debuggerWindow / gdbWindow` | 大 | ◐ 替代：in-app 调试控制台（内存读写 + 条件断点 + 日志），无单步/寄存器断点（§3.7） |
| 23 | P3 | 脚本系统 | ❌ | `Q/Window.cpp scripting` | 大 | ◐ 替代：`mgba://action` 动作序列 + BLE/剪贴板驱动，可做回归脚本（§3.7） |
| 24 | P3 | 音频驱动 / 采样率 / 缓冲 | ◐ | `Q/SettingsView.ui av 页` | 60 行 | ◐ 声音页新增「音频输出：自动 / 强制扬声器」+ 已有低延迟开关；采样率跟系统（§3.9） |

> 未列的移动端独有能力（滤镜、皮肤、贴纸、GIF 球、AI 翻译、宏键、触感、竖屏双屏、存档缩略图、自动存档、
> 每游戏倍速、WebDAV、备份）iOS **都已有完整闭环**（`FEATURE_MATRIX.md §10.2` 逐条核对），不再重复。

## 2. 实施顺序（按批次推进，每批做 3 项跑一次 `swiftc -parse`）

| 批次 | 内容 | 状态 |
|---|---|---|
| 1 | 撤销、逐帧前进、手柄映射、ROM 信息、运行日志 | ✅ 完成（parse 通过） |
| 2 | 逐帧倒带、键盘映射、沉浸式 | ✅ 完成（parse 通过） |
| 3 | tile 查看器、I/O 与帧状态、DISPCNT 图层开关 | ✅ 完成（parse 通过） |
| 4 | MP4 录像、`mgba://` 动作扩展、（卸载/存档转换见 §3.11） | ✅ 完成（parse 通过） |
| 5 | BLE 联机（`GBoyBLELink.swift`，已登记 pbxproj） | ✅ 完成（parse 通过） |
| 6 | `.sps` 导入、音频输出路由、声道开关核对 | ✅ 完成（parse 通过） |
| 7 | 帧率目标、外设替代、调试控制台/条件断点 | ✅ 完成（parse 通过） |

## 3. 限制项及替代方案（四栏口径）

### 3.1 蓝牙联机（Android RFCOMM / PC `AF_BTH` → iOS 无经典蓝牙）

| 栏 | 内容 |
|---|---|
| **原生能力** | iOS **没有** 经典蓝牙 RFCOMM API（`ExternalAccessory` 只对 MFi 外设开放，需厂商协议）。**有** `CoreBluetooth`（BLE）：`CBPeripheralManager`（外设/房主）、`CBCentralManager`（中心/加入）、`CBMutableService` / `CBMutableCharacteristic`、`peripheral(_:didSubscribeTo:)` + `updateValue(_:for:onSubscribedCentrals:)`。查证：Apple `CoreBluetooth` 文档 + SDK 头文件（本机无 SDK，按公开 API 选型）。 |
| **替代方案 A（主）** | **BLE GATT 隧道**：自定义服务 UUID（由 `3a1f7b2e-` 派生），两条 characteristic：`RX`（房主→客户端，notify）、`TX`（客户端→房主，write）。载荷**复用现有 10 字节 GBoy 帧**；`MTU-3` 分片的帧（如 type 6 整包存档）加分片头 `[seq:u16][total:u16]`，收端按 seq 重组。链路层语义（握手 `1→2→3→6`、type 6 不复位、type 9 倍速、type 10 断线）**完全照抄 TCP 路径**，只换字节通道。 |
| **替代方案 B（降级）** | **MultipeerConnectivity**：`MCSession` + `.reliable` 数据模式（底层可走 Wi-Fi Direct / BLE），代码量更小、无需自己分片（`MCSession.send` 自动处理），代价是无法指定只用蓝牙、且 iOS-iOS 才稳（跨 Android 不通用）。 |
| **为什么选 A** | 只有 A 能真正跑在「蓝牙」上、且与 Android/PC 的帧语义逐字节一致（B 的底层不可控、跨端不通）。B 保留为 A 不可用时的降级开关。 |
| **用户得到什么** | 两台 iPhone/iPad 无 Wi-Fi 也能 2P 联机；菜单「联机 → 蓝牙(BLE) 创建/加入」，与 TCP 路径共用按键/倍速/复位语义。 |

### 3.2 文件：任意路径读写（Android SAF / PC 任意目录）

| 栏 | 内容 |
|---|---|
| **原生能力** | 沙盒内 `Documents` 全可读写；对外用 `UIDocumentPickerViewController`（导入/导出）、`startAccessingSecurityScopedResource()`（持久书签）；`Info.plist` 加 `UIFileSharingEnabled` + `LSSupportsOpeningDocumentsInPlace` 让「文件」App 直接拖放（本工程已开）。 |
| **替代方案 A（主）** | `Documents/` 作为「ROM/存档/皮肤/备份」根 + 用户自选目录安全书签（`UserDefaults` 存 bookmark，重启恢复）。等价于桌面任意路径：用户在「文件」里把文件夹拖进 mGBA，再在 ROM 目录里添加。 |
| **替代方案 B（降级）** | 只读 `Inbox`（分享打开）+ 导出用 Document Picker 另存；不能写回原目录时提示「已另存到 mGBA/Exports」。 |
| **为什么选 A** | 书签是 iOS 上唯一「记住外部目录」的官方方式，且本工程已有 `customRomDirs` / `scopedFolderURLs` 实现，扩展成本最低。 |
| **用户得到什么** | iCloud Drive / 本地文件夹里的 ROM 与存档可直接就地读写；备份/日志/截图能导出到任意位置。 |

### 3.3 后台常驻（Android Service / PC 常开进程）

| 栏 | 内容 |
|---|---|
| **原生能力** | `AVAudioSession` `.playback` + `UIBackgroundModes: audio`（本工程已开），配合 `beginBackgroundTask` 延长收尾；`UNUserNotificationCenter` 提示仍在运行。 |
| **替代方案 A（主）** | 后台音频保活（游戏继续跑，音频不断流），退出前 `cmdAutoSave` 写自动存档；回前台自动恢复。 |
| **替代方案 B（降级）** | 进后台即「暂停 + 自动存档 + 静音」，回前台秒恢复（省电）。 |
| **为什么选 A** | 已实现且与「自动存档/自动读档」互补；B 作为低电量开关。 |
| **用户得到什么** | 切出去回消息游戏不停；杀进程也不会丢进度（自动存档）。 |

### 3.4 多窗口（PC `multiWindow`）

| 栏 | 内容 |
|---|---|
| **原生能力** | iOS 15 `UISceneSession` 可开多窗口（iPad），但同 App 多实例共享一个 core/音频会话，游戏内核不可重入。 |
| **替代方案 A（主）** | **进程内 N 核锁步**（`GBoyConsoleSet`，本工程已支持 2/3/4 核与 lockstep）——PC 多窗口的用途（本地联机）已覆盖。 |
| **替代方案 B（降级）** | iPad 分屏 + 两个窗口各跑一份 core（需要把 core 全部实例化，改造量大）。 |
| **为什么选 A** | 零协议风险、已通过联机验收；B 收益低。 |
| **用户得到什么** | 单机也能起 2~4 个「虚拟掌机」做本地联机/对战。 |

### 3.5 特殊外设（GB 相机 / 打印机 / BattleChip / e-Reader）

| 栏 | 内容 |
|---|---|
| **原生能力** | iOS 有相机（`AVCaptureSession` / `UIImagePickerController`）、有文件与网络；但**本仓库 core 没有相机/打印机/BattleChip 实现**（`grep -ri camera include/mgba src/core src/gb` → 0 命中），`mgba_mobile.h` 也没有对应导出。 |
| **替代方案 A（主）** | 先在 iOS 侧做「外设」入口（相册选图 / 文本码），**接口按 `mgbaMobileSetCameraImage(const void*, w, h)` 预留**，等 core 侧补 20 行 C 导出即可点亮；UI 与选图流程先落地，不阻塞。 |
| **替代方案 B（降级）** | GB 相机用「固定测试图」+ 提示「当前核心未编入相机外设」；e-Reader 提供 dotcode 图片选择器（解析同样等 C 层）。 |
| **为什么选 A** | 避免在 iOS 里伪造一个不生效的按钮；把不可变的部分（C 层）与可变的部分（UI）解耦。 |
| **用户得到什么** | 现在能看到入口与说明、导出/导入路径；C 层补齐当天即可用（不需要再动 iOS UI）。 |

### 3.6 视频层 / 音频通道 / 3D 层位置

| 栏 | 内容 |
|---|---|
| **原生能力** | core 有 `mCore->listVideoLayers / enableVideoLayer / listAudioChannels`（`include/mgba/core/core.h:166-168`），但 `mgba_mobile.h` **没有导出**，Swift 只拿到 `OpaquePointer`，调不到。 |
| **替代方案 A（主）** | **已升级成真实现**：`mgbaMobileListVideoLayers` 动态枚举（id 取 `info[i].id`、文案取 `visibleName`），开关直接 `mgbaMobileSetVideoLayer`；音频通道用 6 路 `vol_ch*` 音量（0% 即关闭）。 |
| **替代方案 B（降级）** | 在 `src/platform/mobile` 加 3 个转发函数（`mgbaMobileListVideoLayers / SetVideoLayer / SetAudioChannel`，约 30 行），iOS 侧再补 UI；这是最终正解，但改的是移动端公共 C 层（超出「只改 ios/」）。 |
| **为什么选 A** | 不跨端改动、当天可用；寄存器级开关对「看某一层」这个真实需求已足够。 |
| **用户得到什么** | 调试时可单独关 BG/OBJ 看画面构成；声音通道开关在 A 完成后可用。 |

### 3.7 调试器 / GDB / 脚本 / 内存访问日志

| 栏 | 内容 |
|---|---|
| **原生能力** | mGBA 的 GDB stub 与脚本引擎需 `ENABLE_DEBUGGERS` / `ENABLE_SCRIPTING` 编译，且 mobile 库与 iOS 沙盒不提供监听端口（GDB 需 TCP server，iOS 可监听但不能被外部随意连）。内存访问日志靠 core 回调，mobile 未导出。 |
| **替代方案 A（主）** | 现有调试面板（内存/搜索/BG/OAM/调色板/图块/I/O）+ 新增「内存断点（软件）」：按帧轮询 `mgbaMobileBusRead` 监听某地址变化，命中就暂停并 toast/日志。等价「内存访问日志」的常用场景。 |
| **替代方案 B（降级）** | 用 `mgba://` URL + 日志导出把状态交给外部分析（配合 §3.10 调试面）。 |
| **为什么选 A** | 轮询版不依赖 core 回调，纯 iOS 可交付；GDB 需要重编译 core，收益低。 |
| **用户得到什么** | 能在手机上查「谁改了这个地址」，并把日志导出。 |

### 3.8 AV 录像的音频轨

| 栏 | 内容 |
|---|---|
| **原生能力** | `AVAssetWriter` + `AVAssetWriterInputPixelBufferAdaptor`（H.264）；音频可用 `AVAudioEngine` 在渲染链上装 tap（`installTap(onBus:bufferSize:format:)`）拿 PCM，再 `AVAssetWriterInput`（AAC）。 |
| **替代方案 A（主）** | 视频走 `AVAssetWriter`（30 fps，从 `present` 的像素缓冲直接来），音频走 `AudioOut` 的 `AVAudioEngine` tap；两轨按 `presentationTimeStamp` 对齐。 |
| **替代方案 B（降级）** | 只录视频（H.264 MP4），音频用「录完再合成」不做；UI 明示「无音轨」。 |
| **为什么选 A** | `AudioOut` 已经是 `AVAudioEngine`，加 tap 是增量改动；比引入 FFmpeg 轻。 |
| **用户得到什么** | 一键录 MP4 存相册，带游戏音。 |

### 3.9 音频驱动 / 采样率 / 缓冲

| 栏 | 内容 |
|---|---|
| **原生能力** | iOS 采样率由 `AVAudioSession.sampleRate` 决定（通常 48 kHz），可设 `.preferredSampleRate` / `.preferredIOBufferDuration`（低延迟）；**不能**选「驱动」。 |
| **替代方案 A（主）** | 设置里暴露「低延迟（更小缓冲）」「蓝牙输出（更大缓冲）」两档，映射到 `AVAudioSession` 的 `setPreferredIOBufferDuration`；采样率跟随系统。 |
| **替代方案 B（降级）** | 现有 `low_latency` 开关（已是 A 的简化版）。 |
| **为什么选 A** | 这是 iOS 上「音频设置」的真实可调项；伪造驱动列表没有意义。 |
| **用户得到什么** | 蓝牙耳机下不爆音、有线/扬声器下延迟更低。 |

### 3.10 Android 广播调试面

| 栏 | 内容 |
|---|---|
| **原生能力** | iOS 无 `am broadcast`；可用 `UIApplicationDelegate.application(_:open:options:)` 处理自定义 URL scheme、`UIPasteboard` 读命令、`ProcessInfo.arguments` 读启动参数。 |
| **替代方案 A（主）** | 注册 `mgba://cmd?name=SCREENSHOT|KEYS|SPEED|RESET|STATE|ROM&...`，`simctl openurl` / Safari / 快捷指令都能驱动；同时支持从剪贴板执行。 |
| **替代方案 B（降级）** | 仅启动参数（现状）+ 文件 `Documents/debug-cmd.txt` 轮询。 |
| **为什么选 A** | CI 与自动化都能用，且不需要越狱；与现有 `-gboyAutoRom` 参数共存。 |
| **用户得到什么** | 一条命令截图/改按键/切倍速/联机，方便回归测试。 |

### 3.11 卸载卡带 / 关机（PC `shutdown` / `yank game pak`）

| 栏 | 内容 |
|---|---|
| **原生能力** | `mgbaMobileCreate/Destroy` 只能整实例销毁（本工程在 `deinit` 才调），没有「卸载当前 ROM 保留实例」的导出；`mgbaMobileLoad` 失败时旧状态仍在。 |
| **替代方案 A（主）** | 「回主屏 = 暂停 + 自动存档 + 释放画面」，用户再打开别的 ROM 时 `mgbaMobileLoad` 自然覆盖；等价于卸载。 |
| **替代方案 B（降级）** | 新增「重启核心」：停循环 → `mgbaMobileDestroy` → `mgbaMobileCreate` → 重启循环（需把 loop 的 `core == nil` 分支改成带 16 ms 等待，改造 40 行，风险在音频/联机状态）。 |
| **为什么选 A** | 移动端没有「拔卡带继续用前端」的语义，B 会带来音频与联机句柄复位风险，收益低。 |
| **用户得到什么** | 退出到库不会漏存档；不需要理解「关机/拔卡」概念。 |

### 3.12 帧率目标 15–240 / Native

| 栏 | 内容 |
|---|---|
| **原生能力** | iOS 的 `CADisplayLink`/自建节拍都能按任意 fps 唤醒；但 mGBA 的 `fpsTarget` 是**核心节拍目标**，不是显示刷新率。 |
| **替代方案 A（主）** | 不做限速：保持按 `mgbaMobileFrameNanos`（GBA 16.742 ms / GB 16.742 ms）节拍，音频、录音、联机子状态才与三端一致。 |
| **替代方案 B（降级）** | 若用户真要省电：`低功耗模式`（跳帧 + 30 fps 显示，内核仍按原速跑，只在 `present` 上限速），不影响联机与音频。 |
| **为什么选 A/B** | 直接改核节拍会让游戏整体变慢、并与 type 9 的 `1e9/(rate*60)` 帧闸叠加冲突（红线）。 |
| **用户得到什么** | 目前帧率稳定；省电需求走 B 的显示限速，不动内核。 |

## 4. 实现落点（已落地部分）

第 1~4 批全部写在已有文件里；第 5 批新增 `ios/mGBA/GBoyBLELink.swift`，并已登记进 `ios/mGBA.xcodeproj/project.pbxproj`（`B1…22` / `E1…22`，PBXBuildFile / PBXFileReference / group / Sources 四处）。

| 功能 | 文件 · 符号 |
|---|---|
| 撤销 | `EmulatorViewController.swift · undoStateAction / rememberUndoState / undoLastState / dropUndoState / cmdUndoState` |
| 逐帧前进 | `EmulatorViewController.swift · stepFrame / stepFrameWanted`（帧循环暂停分支） |
| 逐帧倒带 | `EmulatorViewController.swift · stepBackFrame / rewindFrameWanted / replayBackOneFrame / keyHistory` |
| 手柄映射 | `EmulatorViewController.swift · padMap / padInputPressed / padMask / showPadMapping / padTargets / padInputs / padDefaults` |
| 键盘映射 | `EmulatorViewController.swift · keyMap / mapKey / showKeyMapping / keyInputs / keyTargets / keyDefaults` |
| 沉浸式 | `EmulatorViewController.swift · immersivePref / prefersStatusBarHidden / prefersHomeIndicatorAutoHidden`（画质页开关） |
| ROM 信息 | `EmulatorViewController.swift · showRomInfo / gbCartName / gbRomSize / gbRamSize` |
| 运行日志 | `EmulatorViewController.swift · RunLog / showRunLog` |
| 图块查看 | `DebugViewers.swift · showTiles / renderTiles`（调试工具入口） |
| I/O 与帧状态 | `DebugViewers.swift · showIo`（含 BG/OBJ 开关） |
| 图层强制开关 | `EmulatorViewController.swift · forcedLayerMask / applyForcedLayers`（每帧重写 DISPCNT） |
| MP4 录像 | `EmulatorViewController.swift · startVideoRecording / appendVideoFrame / stopVideoRecording` + `AudioOut.swift · installRecordingTap`（H.264 + AAC，3 秒收尾兜底） |
| 调试 URL 扩展 | `EmulatorViewController.swift · handleDebugURL`（save/load/undo/step/back/speed） |
| BLE 联机 | `GBoyBLELink.swift · GBoyBLELink`（GATT notify/write + 4 字节长度帧重组） |
| `.sps` 导入/导出 | `EmulatorViewController.swift · importSps / cheatStoreKey / rememberCheatLines`（type 2 GameShark，导出走文件 App） |
| 音频路由 | `AudioOut.swift · setOutputRoute` + 声音页「音频输出」 |
| 帧率目标 | `EmulatorViewController.swift · fpsRow`（fps/59.7275 → `setSpeed`） |
| 外设替代 | `EmulatorViewController.swift · showPeripherals / importCameraImage` |
| 调试控制台 | `EmulatorViewController.swift · showDebugConsole / checkMemoryWatch / watchAddress` |

> 验证：`env -u HTTP_PROXY -u HTTPS_PROXY -u ALL_PROXY -u NO_PROXY -u http_proxy -u https_proxy -u all_proxy -u no_proxy swiftc -parse ios/mGBA/*.swift` → 退出码 0。
> **未编译、未真机**（本机无 Xcode / iOS SDK，`swiftc -typecheck` 因缺 Windows SDK 头文件也跑不了）。

## 5. 反向补齐（iOS 已有 → PC / Android 缺）

> 口径：只列「iOS 有完整闭环、PC 或 Android 没有」的项；给方案与量级，供 team-lead 转派。
> iOS 的 12 种滤镜、亮度/对比度/扫描线、皮肤、按键布局档、竖屏双屏、宏键、触感、GIF 球、贴纸、
> AI 翻译、存档缩略图、自动存档、每游戏倍速，`FEATURE_MATRIX.md §10.2` 已确认 Android 也有；
> 所以**反向缺口主要在 PC**（Android 只差本轮 iOS 新做的几项）。

### 5.1 PC（Qt）缺的移动端能力

| 功能 | PC 参照落点 | 方案 | 量级 |
|---|---|---|---|
| AI 截图翻译 | `Q/Window.cpp · tools` 新菜单 | 截 `DisplayGL` 帧 → `QNetworkAccessManager` 调视觉模型 → 无边框半透明 `QWidget` 覆盖译文（Android `AiTranslate` 同思路） | ~300 行 |
| 贴纸叠加 | `Q/DisplayGL` 之上加 `QGraphicsView` | `QGraphicsPixmapItem` 贴图 + 拖动/缩放，截图/GIF 输出时合成 | ~150 行 |
| GIF 悬浮球 | 主窗口右下角 `QToolButton` | 一键开始/停止 `recordGIF`，拖动记忆位置 | ~120 行 |
| 皮肤主题（外框/背景/配色） | `Q/Window.cpp` + QSS | QSS 变量 + 九宫格外框 `QPixmap`，配置键 `skin_style/skin_color` 与移动端同名 | ~250 行 |
| 存档缩略图 | `Q/LoadSaveState` | 存 state 时写同名 PNG，列表 `setIcon`（`FEATURE_MATRIX §11` 第 2 项） | ~120 行 |
| 自动存档 / 启动自动读档 | `Q/Window.cpp` closeEvent + 启动 | 新增 `autoSaveState/autoLoadState` 配置键 + Settings→Emulation 两个勾选 | ~180 行 |
| 12 种滤镜 / 亮度对比度扫描线 | `Q/DisplayGL.cpp` shader 链 | 移植 `A/Shaders.java` 的 fragment shader（§11 第 5 项） | ~400 行 |
| 每游戏倍速 / 每游戏滤镜 | `Q/OverrideView` | 加两项 override，键名与 `RomSettings` 对齐 | ~50 行 |
| 调试素材导出（OAM/调色板 → PNG） | `Q/ObjView` / `PaletteView` | 加「导出 PNG」按钮，复用 `QImage` 渲染 | ~40 行 |

> 不建议反向移植：竖屏双屏（桌面无意义）、触感（无硬件）、双击截图（已有 F12）、布局配置档（桌面窗口布局即可）。

### 5.2 Android 缺的（本轮 iOS 已补）

| 功能 | iOS 实现 | Android 落点 |
|---|---|---|
| 撤销读档/存档 | `EmulatorViewController.rememberUndoState` | `EmulatorActivity` + `MgbaCore.saveStateToMemory/loadStateFromMemory`（同款内存快照 + 槽文件备份） |
| 逐帧前进 / 逐帧倒带 | `stepFrame` / `replayBackOneFrame` | 帧循环加 step 标志 + 按键历史重放 |
| 键盘/手柄映射 UI | `pad_map` / `key_map` 字典 | `showInputDialog` 加两页，`onKeyDown` 查表 |
| ROM 信息页 | `showRomInfo` | 读卡带头 + `save_type` 覆盖值 |
| 运行日志 + 导出 | `RunLog` | 环形日志 + `ACTION_SEND` 分享 |
| tile / I/O 查看器 | `DebugViewers.showTiles/showIo` | 复用 `DebugViewers.java` 渲染器加两页 |
| AV 录像（MP4） | `AVAssetWriter` | `MediaCodec/MediaMuxer`（Android 侧原生能力更强） |

## 6. 需要 `src/platform/mobile` 新增的 C 接口（转 PC agent）

> 格式：`函数名(参数类型) -> 返回类型 | 用途 | 调用点 | 现有 API 能否组合`
> Swift 侧调用点已留好位置（列在最后），C 一落地即可接线；**当前不写 extern 声明**，避免链接期缺符号。

1. `mgbaMobileListVideoLayers(const struct MgbaMobile*, const struct mCoreChannelInfo**) -> size_t` ｜ 枚举视频层 ｜ `EmulatorViewController.showVideo` / `DebugViewers.showIo` ｜ 否：`DISPCNT` 只能盖 GBA 图层，GB/SGB 与内部分层盖不到
2. `mgbaMobileSetVideoLayer(struct MgbaMobile*, size_t id, bool enable) -> void` ｜ 单独开关视频层 ｜ 同上 ｜ 否（同上）
3. `mgbaMobileListAudioChannels(const struct MgbaMobile*, const struct mCoreChannelInfo**) -> size_t` ｜ 枚举声道 ｜ `showSoundDialog` ｜ 否：`SOUNDCNT` 会被游戏每帧重写，且覆盖不到 PSG
4. `mgbaMobileSetAudioChannel(struct MgbaMobile*, size_t id, bool enable) -> void` ｜ 单独开关声道 ｜ 同上 ｜ 否
5. `mgbaMobileSetLayerPlacement(struct MgbaMobile*, unsigned layer, unsigned x, unsigned y) -> bool` ｜ 3D 层偏移 ｜ 画质页「3D 层位置」 ｜ 否
6. `mgbaMobileRewindFrames(struct MgbaMobile*, int frames) -> bool` ｜ 精确逐帧倒带 ｜ `replayBackOneFrame` ｜ 否：现只有按秒 `mgbaMobileRewind`，iOS 用「倒带 1s + 按键历史重放」近似
7. `mgbaMobileSetCameraImage(struct MgbaMobile*, const void* pixels, int width, int height, int format) -> bool` ｜ GB 相机送图 ｜ 设置→外设 ｜ 否（core 当前无相机实现，需先补 core）
8. `mgbaMobilePrintImage(struct MgbaMobile*, void** out, size_t* outSize) -> bool` ｜ GB 打印机取图 ｜ 外设页 ｜ 否
9. `mgbaMobileSetMemoryWatch(struct MgbaMobile*, uint32_t addr, uint32_t len, void (*cb)(uint32_t, uint32_t, void*), void* ctx) -> bool` ｜ 内存访问日志 ｜ 调试页 ｜ 部分：可按帧轮询 `mgbaMobileBusRead`（拿不到读写类型）
10. `mgbaMobileGetRomInfo(struct MgbaMobile*, struct MgbaMobileRomInfo* out) -> bool` ｜ 卡带头 + 自动识别存档类型 ｜ `showRomInfo` ｜ 是：已用 Swift 解析头 + CRC，缺「core 自动识别的 save type」

> **落地状态**：1/2（视频层枚举/开关）、5（精确逐帧倒带）、6（内存监视）已落地并接线；
> 3/4（音频通道）已确认作废（`vol_ch*` 等价）；7/8（相机/打印机）、10（ROM 信息）待做。

## 7. 替代实现与升级路径（第 7 批）

| 项 | 现在的替代实现 | 能力边界 | 等 C 接口落地后升级为 |
|---|---|---|---|
| 帧率目标 | `fps/59.7275` 折算成倍速走 `setSpeed`（15→0.25×、30→0.5×、45→0.75×、60→1×、120→2.01×、240→4.02×、Native→1×） | 不是独立帧闸；120/240 的 2.01/4.02 不在 type 9 白名单，联机只同步 0.5/1/2/4 | 若官方支持 `mgbaMobileSetFpsTarget` 再换成真帧率目标 |
| GB 相机 | 相册/文件选图 → 存 `Documents/peripherals/camera.png` + 运行日志 + 预览 | 图不会进游戏（core 无相机） | `mgbaMobileSetCameraImage`（§6-7） |
| GB 打印机 | 「打印机」= 导出当前画面到相册 | 不产生真实打印数据 | `mgbaMobilePrintImage`（§6-8） |
| e-Reader / BattleChip | 走金手指：卡牌码按 GameShark（type 2）添加，可导出 `.sps` | 没有卡牌扫描/红外 | core 补外设后接 dotcode 解析 |
| 3D 层位置 | 画质→「画面场景」整体缩放/居中 | 不能只挪 3D 层 | `mgbaMobileSetLayerPlacement`（§6-5） |
| 精确逐帧倒带 | **已替换**：`mgbaMobileRewindFrames(core, 1)` | 需要 rewind 历史（启动时已 `SetRewind(true)`），历史为空时提示 | 已到位 |
| 内存访问日志 / GDB | **已替换**：`mgbaMobileSetMemoryWatch`（值变化捕获，命中暂停 + RunLog） | 写同值不触发、无读写类型/调用栈、无单步/寄存器断点 | 已到位（回调由 RunFrames 线程触发） |
| 脚本系统 | `mgba://action` 动作序列 + BLE/剪贴板驱动 | 只能做「外部定时下发动作」，不能访问内存变量 | core 编入脚本引擎后接 Lua/JS |
| 多窗口联机 | 进程内 2/3/4 核锁步（联机页「本机多核锁步」开关，人数 2/3/4） | 同机对战，不是多窗口 | iOS 多窗口无 core 多实例，维持现状 |
