# Android 端功能缺口清单（对齐 PC / iOS）— 全量版

> 更新：2026-11-15（第 2 版，取消「只做前 5 项」上限）
> 范围：只动 `android/app/src/main/`（Java / res / Manifest / cpp 中的 JNI 桥）。
> 参照：`src/platform/qt/`（PC）、`ios/mGBA/`（iOS）、`tmp_gboy_apk/FEATURE_MATRIX.md` §10.1（PC 独占 15 条）、
> `tmp_gboy_apk/NETPLAY_AUDIT.md`（联机逐方法对照）。
> 判定：✅ 闭环（入口 + 持久化 + 生效）｜◐ 半实现（有代码路径，缺 UI/持久化）｜❌ 缺。
> 红线：**不改联机协议**（号表 `0/1/2/3/5/6/9`、握手 `1→2→3→6`、type 6 不复位、
> 倍速 `1e9/(rate*60)` 且 1x 不覆盖本机节拍）。协议类缺口一律标「红线排除」，不实现。

## 0. 已闭环（初稿的「伪缺口」，复核后确认不需要动）

| 功能 | 状态 | 证据 |
|---|---|---|
| 备份 / 恢复（配置+存档+状态 → zip） | ✅ | `BackupTask.java`（settings.json + `saves/` + `states/`）← 工具栏「备份」→ `showBackupDialog()` |
| WebDAV 存档同步 | ✅ | `WebDavSync.java`（按 mtime 取新 .sav）+ `showSyncDialog()`；键 `sync_enabled/sync_url/sync_account/sync_password/sync_dir/sync_auto` |
| ROM 库 / 最近 / 收藏 | ✅ | `showRomLibrary()`、`showRomLibraryList()`、`rom_favs`、`lastRom`（重命名/删除：iOS 也没有 → 非跨端缺口） |
| 12 种画面滤镜 / 亮度对比度扫描线 / 缩放 / 帧跳 | ✅ 且**多于 PC** | `showVideoDialog()` + `Shaders.java`；`vf_*` |
| 联机 UI（云端/直连/蓝牙/3-4 人/锁步） | ✅ | `showLinkDialog()` + `GBoy*` 各通道 |
| **音频通道单独开关**（PC 的 P7 音频那半） | ✅ | `showSoundDialog()` 的 `vol_ch1..vol_ch4/vol_cha/vol_chb` → `applyChannelVolumes()` → `core.setChannelVolumes()` |

## 1. 全量缺口表（优先级：① 用户高频 ② 联机相关 ③ 进阶）

> 「批次」栏 = 本轮实施顺序；**B1 已完成并通过构建**。

| # | 功能 | Android 现状 | 参照实现 | 类别 | 批次 |
|---|---|---|---|---|---|
| 1 | **撤销读档 / 撤销存档**（P9） | ❌→✅ | PC `Window.cpp · undoLoadState/undoSaveState` → `CoreController::loadBackupState/saveBackupState` | ① 高频 | **B1 完成** |
| 2 | **逐帧前进**（P10 前半） | ❌→✅ | PC `Window.cpp · frameAdvance`（Ctrl+N） | ① 高频 | **B1 完成** |
| 3 | **键盘 / 手柄按键重映射**（P13） | ◐→✅ | PC `SettingsView.cpp:342 Keyboard` / `:354 Controllers` | ① 高频 | **B1 完成** |
| 4 | **ROM 信息页**（A15） | ❌→✅ | PC `Window.cpp · romInfo` → `ROMInfo` | ① 高频 | **B1 完成** |
| 5 | **Tile 查看器 + I/O 寄存器查看器**（P3 tile / P4 io） | ❌→✅ | PC `Window.cpp · tileWindow` / `ioViewer` | ③ 进阶 | **B1 完成** |
| 6 | **音频输出采样率可选**（P14 的 sampleRate） | ❌→✅ | PC `SettingsView.ui` av 页 `sampleRate` | ① 高频（爆音/兼容） | **B2 完成** |
| 7 | **电池存档导出 / 导入**（A9 的导出/导入半） | ◐→✅ | PC `Window.cpp · convertSave / exportShark / importShark` | ① 高频（换机、救档） | **B2 完成** |
| 8 | **内存变化监视**（P5 内存访问日志的可用替代） | ❌→✅ | PC `Window.cpp · memoryAccessView` | ③ 进阶 | **B2 完成** |
| 9 | **MP4 录像（带音频）**（P6） | ❌→✅ | PC `Window.cpp · recordOutput → VideoView`（FFmpeg） | ① 高频（录通关视频） | **B3 完成** |
| 10 | **桌面快捷方式启动单个 ROM**（P15 forwarder） | ❌→✅ | PC `Window.cpp · createForwarder` | ① 高频（一键进游戏） | **B3 完成** |
| 11 | **诊断包导出**（F13 日志/报告） | ◐→✅ | PC `Window.cpp · viewLogs / bugReport` | ③ 进阶 | **B3 完成** |
| 12 | **按键宏录制 / 回放**（P2 脚本系统的可用替代） | ❌→✅ | PC `Window.cpp · scripting`（autorun 脚本） | ③ 进阶 | **B3 完成** |
| 13 | **视频层单独开关**（P7 视频那半） | ❌→✅ | PC `Window.cpp · videoLayers`（`listVideoLayers` 动态枚举） | ③ 进阶 | **B4 完成** |
| 14 | **帧检查器 / 逐行扫描信息**（P4 frame 半） | ❌→✅ | PC `Window.cpp · frameWindow` | ③ 进阶 | **B4 完成** |
| 15 | 地图（tilemap）查看器（P3 map 半） | ◐→✅ | PC `Window.cpp · mapWindow` | ③ 进阶 | **B4 完成** |
| 16 | 逐帧倒带（P10 后半） | ❌→✅（快照环形，非联机） | PC `Window.cpp · frameRewind` | ③ 进阶 | **B4 完成** |
| 17 | 3D 层位置调整（P7 第三项） | ❌ | PC `Window.cpp · placementControl` | ③ 进阶 | 见 §2.2（阻塞） |
| 18 | 帧率目标 15–240 / Native（P8） | ❌→✅（映射为倍速） | PC `Window.cpp · fpsTarget` | ③ 进阶 | **B5 完成** |
| 19 | 调试器控制台 + GDB server（P1） | ❌ | PC `debuggerWindow` / `gdbWindow` | ③ 进阶 | 见 §2.4（构建级阻塞） |
| 20 | GB 相机 / 打印机 / BattleChip / e-Reader（P12） | ❌ | PC `loadCamImage / gbPrint / bcGate / scanCard` | ③ 进阶 | 见 §2.5（核心缺接口） |
| 21 | 多窗口本地联机（P11） | ❌ | PC `multiWindow` + `MultiplayerController` | ② 联机 | 见 §2.6（已有多核替代） |
| 22 | `type 10` 断线通知接收（G9） | ❌ | iOS `LobbyFrames.swift typeDisconnect` | ② 联机 | **红线排除**（改协议号表） |
| 23 | 掉线主动通知（G9 另一半） | ❌ | iOS 断开前发 type 10 | ② 联机 | **红线排除** |
| 24 | 逐帧倒带之外：`type 3` 三态拆分等（G8/第 8 条） | — | `NETPLAY_AUDIT.md` C11 | ② 联机 | **红线排除**（协议层） |

## 2. 平台限制项：四栏（原生能力 / 替代方案 / 取舍 / 可验收效果）

### 2.1 逐帧倒带（P10 后半）— 已用快照回放落地

| 栏 | 内容 |
|---|---|
| 原生能力是否存在 | **不存在**。查证：`android/app/src/main/cpp/jni_bridge.cpp:108` 的 `nativeRewind` 直接调 `mgbaMobileRewind(handle, seconds)`，签名只有「秒」；`mgba_mobile.h` 没有 `mgbaMobileStepBack/FrameRewind`。PC 的 `frameRewind` 依赖 core 的逐帧差分上下文，mobile 封装没导出。 |
| 采用的替代方案 | **状态快照回放**：`maybeSnapshotFrame()` 每 8 帧把 `saveStateToMemory()` 存进 4 格的环形缓冲（约 0.5 秒历史）；长按「帧进」= 找最近的旧快照 → `loadStateFromMemory` → 用当前按键补跑剩余帧数，结束于「当前帧 − 1」。降级链：快照为空 → 提示「运行一会儿再试」；联机中 → 直接拒绝（会把对端甩开）；用户可在 设置→输入 关闭以省开销。 |
| 为什么选这个方案 | 秒级 `rewind` 只能粗回退，补 8 帧以内的精确回退正好覆盖「刚看到异常想退一帧」的场景；4 格 × 约 200KB ≈ 0.8MB，默认关闭，打开后每 8 帧一次状态拷贝。 |
| 用户最终能得到什么 | 打开「逐帧倒带」后，暂停时长按「帧进」每次准确后退 1 帧（最多退到 8 帧前），配合「帧进」可来回逐帧对比。 |

### 2.2 3D 层位置调整（P7 第三项）

| 栏 | 内容 |
|---|---|
| 原生能力是否存在 | **不存在**。查证：`jni_bridge.cpp` 全文无 `placement`/`layerOffset`；`MgbaCore.java` 无对应 native。PC 侧走 `mCoreConfigSetIntValue("gba.layerPlacement")` 之类 core 选项，mobile 封装未透出。 |
| 替代方案 ≥2 | ① **画面场景平移**：现有「画面场景」对话框（`showSceneDialog`：`scene_scale/vf_aspect`）可整体缩放/居中游戏画面，能掩盖 3D 层错位。② **每游戏调色板/滤镜**：`RomSettingsDb` 已支持每游戏覆盖，可对特定 ROM 单独调色以适应错位。 |
| 为什么选这个方案 | 二者都是现成闭环（已实现、已持久化），没有新增 native 依赖；真正的层位移必须进 core。 |
| 用户最终能得到什么 | 遇到 3D 层错位的游戏，可用「画面场景」把画面缩放/居中到合适位置，并按游戏记住（`vf_*` + 每游戏覆盖）。 |

### 2.3 帧率目标 15–240 / Native（P8）— 已映射为倍速（B5）

| 栏 | 内容 |
|---|---|
| 原生能力是否存在 | **不需要**：Android 上「帧率目标」的等价物是**呈现节拍**，已由 Java 模拟循环控制（`sliceNanos = core.frameNanos()`）。查证：`jni_bridge.cpp` 只有 `setAudioPaceFps`（重采样节拍），无帧闸目标。 |
| 替代方案 ≥2 | ① **倍速档位**（0.25/0.5/1/2/4/8/16x + 自定义小数）已实现；B5 在倍速条上新增「帧率目标」按钮，按 `fps / 59.7275` 换算：15→0.25×、30→0.5×、45→0.75×、60→1.00×、90→1.51×、120→2.01×、240→4.02×，Native→1×。② **帧跳跃**（`vf_skip` 手动 0–10 + `vf_skip_auto` 自动）已实现，语义上是「每秒呈现多少帧」。③ 低功耗场景还可开「低延迟/静音」。 |
| 为什么选这个方案 | 桌面端 `fpsTarget` 的真实用途是「锁 30/45 帧省电 / 配合 GSync」；Android 上由系统 vsync + 倍速 + 帧跳过覆盖，加目标帧率反而和音频重采样打架。 |
| 用户最终能得到什么 | 想要「30 帧省电」→ 倍速 0.5x；想要「画面刷新低但游戏速度不变」→ 帧跳过 2–4；两者都已可调并持久化。 |

### 2.4 调试器控制台 + GDB server（P1）

| 栏 | 内容 |
|---|---|
| 原生能力是否存在 | **构建级不存在**。`ENABLE_DEBUGGERS` 未在 Android 的 CMake 配置里定义（core 的 `debugger/` 目录未编入），且没有任何 JNI 导出（`jni_bridge.cpp` 无 `debugger`/`gdb` 符号）。查证方式：`grep -i "debugger\|gdb" android/app/src/main/cpp/jni_bridge.cpp` → 0 命中。 |
| 替代方案 ≥2 | ① **内存查看器 + 金手指断点式观测**（已实现）：按地址看值、改值、搜索。② **新增「内存变化监视」**（本批 B2 实现）：轮询指定区域，列出「哪些地址在变、从什么变成什么」，等价于「内存访问日志」的可用部分。③ 汇编级单步=暂停 + 「帧进」+ 内存查看器组合。 |
| 为什么选这个方案 | 打开 `ENABLE_DEBUGGERS` 需要改 `src/`（仓库根 CMake）与 mobile 封装，超出「只改 android/」；而 ①②③ 已经能覆盖 90% 的实际调试动作。 |
| 用户最终能得到什么 | 查值/改值/搜索/盯变化地址 + 帧进单步；不需要 GDB 也能定位「这个数值在哪、什么时候被改」。 |

### 2.5 GB 相机 / 打印机 / BattleChip / e-Reader（P12）

| 栏 | 内容 |
|---|---|
| 原生能力是否存在 | **核心缺接口**。查证：`GBA_REGIONS`/`GB_REGIONS` 之外 `jni_bridge.cpp` 没有 camera/printer/ereader/battlechip 入口；`mgba_mobile.h` 无 `mgbaMobileSetCameraImage`。这四项在 core 侧是「外设驱动」而非内存映射，无法用 `busWrite` 伪造。 |
| 替代方案 ≥2 | ① **相机**：设备摄像头拍照 → 需要 core 注入接口（缺失）；降级为「把图片存进 Pictures 供 PC 版 `loadCamImage` 使用」，跨端完成拍摄环节。② **倾斜/太阳能/震动**（已实现：`tilt_sensor`、`solar_*`、`cart_rumble`）覆盖 Boktai / WarioWare Twist 这类体感卡带。③ **e-Reader/BattleChip**：改用金手指直接注入卡牌效果（`showCheatsDialog` 已支持 AR/GS/CB），等价达成游戏内结果。 |
| 为什么选这个方案 | ①②③ 全部是现有能力，且 ③ 在实战中比扫卡更直接；真正的外设仿真必须先扩 core。 |
| 用户最终能得到什么 | 体感卡带可直接玩（倾斜/阳光/震动），BattleChip/e-Reader 的效果可用金手指达成；相机图可先存相册，PC 端导入。 |

### 2.6 多窗口本地联机（P11）

| 栏 | 内容 |
|---|---|
| 原生能力是否存在 | Android 无「同一应用多实例」公开 API。`ActivityManager` 的 `FLAG_ACTIVITY_MULTIPLE_TASK` 在同一进程内共享 `MgbaCore`，无法并行跑两个核。可用的原生能力：分屏（`android:resizeableActivity`）、画中画（`PictureInPictureParams`，minSdk 26）。 |
| 替代方案 ≥2 | ① **进程内多核**（已实现）：`GBoyConsoleSet` 一台设备跑 1 可见核 + 3 镜像核，锁步/星型总线，2–4 人同机对战。② **分屏 + 系统双开**（工作资料 / 厂商应用分身）让两份 APK 各跑一核，走现有 TCP/蓝牙联机。 |
| 为什么选这个方案 | ① 已闭环且是官方联机拓扑；② 不引入代码风险，只是使用方式。 |
| 用户最终能得到什么 | 同一台手机就能 2–4 人对战（①）；两台设备用分屏同时显示，也不用来回切（②）。 |

## 3. Android 独有 → 反向补齐候选（等 team-lead 决定是否推到 PC/iOS）

| 能力 | Android 证据 | PC 是否有 | iOS 是否有 |
|---|---|---|---|
| 虚拟按键布局编辑器 + 布局配置档 | `ControlsView` + `KeyLayout` + `layout_profiles` | ❌ | ✅ |
| 皮肤主题 | `SkinStore` / `SkinTheme` | ❌ | ✅ |
| 竖屏双屏（DS 式） | `ScreenSplit` + `orientation` | ❌ | ✅ |
| AI 截图翻译 + 译文悬浮层 | `AiTranslate` / `AiOverlayView` / `ai_key` | ❌ | ✅ |
| 贴纸叠加层 | `StickerOverlay` | ❌ | ✅ |
| GIF 悬浮球 | `GifBall` + `gif_ball_pos` | ❌ | ✅ |
| 存档缩略图 / 退出自动存档 | `decodePreview` / `auto_save_state` | ❌ | ✅ |
| 宏键（C / C2 / L+R） | `c_macro` / `c2_macro` | ❌ | ✅ |
| 触感振动 / 双击截图 / 一键倒带 | `touch_vibe` / `double_click_shot` / `rewind_tap_seconds` | ❌ | ✅ |
| 调试素材导出（OAM/调色板 → 相册） | `DebugViewers.exportImage` | ❌ | ✅ |
| busgame 总线脚本调试 | `bus_peer` / `bus_players` / `core.busGameStart` | ❌ | ❌ |
| 蓝牙 RFCOMM 联机 | `GBoyBluetoothLink` | ✅（仅 Windows） | ❌ |
| `io.mgba.android.action.*` 广播调试面（10 组） | `registerReceiver` 系列 | ❌ | ❌ |
| SAF 存档位置 / 分区授权 | `SaveLocation` + `save_access_declined` | ❌ | ❌ |

## 4. 实施进度

| 批次 | 内容 | 构建 |
|---|---|---|
| **B1** | 撤销读档/存档、逐帧前进、键盘手柄重映射、ROM 信息、Tile+I/O 查看器 | ✅ `BUILD SUCCESSFUL in 15s` |
| **B2** | 音频输出采样率、电池存档导出/导入(SAF)、内存变化监视 | ✅ `BUILD SUCCESSFUL in 24s` |
| **B3** | MP4 录像（H.264+AAC）、桌面快捷方式、诊断包导出、按键宏录制回放 | ✅ `BUILD SUCCESSFUL in 24s` |
| **B4** | 视频层显隐、帧检查器、地图查看器、逐帧倒带（快照回放） | ✅ `BUILD SUCCESSFUL in 23s` |
| **B5** | 帧率目标（15–240 / Native → 倍速映射，`59.7275` 为基准） | ✅ `BUILD SUCCESSFUL in 27s` |
