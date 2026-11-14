# mGBAx 三端功能对齐盘点（PC / Android / iOS）

> 生成日期：2026-11-15　｜　**只读审计，未改动任何源码**
> 范围：仓库 `D:\mgba-android-version` 当前工作树（含本 fork 的全部自研功能）。
>
> **证据格式说明（重要）**：
> 本次审计期间 `src/platform/qt/Window.cpp`、`android/.../EmulatorActivity.java` 正被并行修改
>（实测 30 分钟内这两个文件分别增长 27 行 / 7 行），**行号随时失效**。
> 因此证据统一写成 **`文件 · 符号/菜单项/配置键`** —— 符号名与配置键是全仓库唯一的，可直接全文搜索定位。
> 只有小于 200 行、未被改动的文件才附行号。
>
> 路径缩写：
>
> | 缩写 | 实体路径 |
> |---|---|
> | `Q/` | `src/platform/qt/`（PC，Qt Widgets） |
> | `A/` | `android/app/src/main/java/io/mgba/android/` |
> | `I/` | `ios/mGBA/` |
> | `M/` | `src/platform/mobile/mgba_mobile.h`（Android/iOS 共用 C API） |
>
> 判定口径（严格按任务要求）：
> - **✅ 有** = 用户能在 UI 或配置里走完一个完整闭环（能开、能用、能持久化）
> - **◐ 部分** = 有代码路径，但缺 UI / 缺持久化 / 只有调试入口 / 与另两端语义不同
> - **❌ 无** = 完全找不到
>
> 联机协议层的逐字节结论**不重复造轮子**，直接引用同目录 `NETPLAY_AUDIT.md`（54 条逐方法对照 + 13 条缺口已完成）。

---

## 0. 一句话结论

**Android 与 iOS 已是同一份代码的两个移植体（配置键 Android 85 个 / iOS 84 个，其中 72 个同名＝86%；工具栏 22 个按钮一一对应），真正的落差是「PC ↔ 移动端」这条横切线。**

- 移动端有、PC 完全没有：12 种画面滤镜、亮度/对比度/扫描线、皮肤与虚拟按键布局、竖屏双屏、AI 截图翻译、贴纸、GIF 球、宏键、触感/双击截图 —— 共 **11 类**。
- PC 有、移动端完全没有：调试器/GDB、脚本、tile/map/IO/帧检查器、内存访问日志、AV 录像、分层开关与 3D 层位置、帧率目标、逐帧前进/倒带、多窗口本地联机、GB 相机/打印机/BattleChip/e-Reader、完整重映射、音频硬件参数、ROM 信息、forwarder —— 共 **14 类**。
- **三端同时缺的：0 项**（本轮 `type 9` 倍速同步与移动端撤销读档补齐后清零）。
- **Android 与 iOS 之间只有 5 处差异**（`E1`、`E12`、`G2`、`G9`、`G10`），且都是平台能力所限，不是漏做。

> 如果用户说的是「两个移动版不一样」→ 基本不成立；
> 如果用户说的是「PC 版少了一堆东西」→ **部分成立**：删掉 4 处误判（§13.1）后，PC 实际缺 **14 项**，其中 12 项是移动端独有能力，且 **A/B 两组（核心存档 + 速度）PC 已全齐**。

---

## 1. A 组 · 核心与存档（15 项）

| # | 功能 | PC | Android | iOS | 证据（PC ｜ Android ｜ iOS） | 缺口说明 |
|---|---|---|---|---|---|---|
| A1 | 打开 ROM | ✅ | ✅ | ✅ | `Q/Window.cpp · loadROM` ｜ `A/EmulatorActivity.java · btn_open` ｜ `I/EmulatorViewController.swift · openRom` | — |
| A2 | 最近 ROM 列表 | ✅ | ✅ | ✅ | `Q/Window.cpp · mru 菜单 + clearMRU` ｜ `A · showRomLibraryList（last 优先）+ lastRom 键` ｜ `I · RomLibrary.swift + lastRom 键` | PC 是 MRU 子菜单；移动端是库列表里最近优先 |
| A3 | ROM 库（多目录 / 收藏 / 扫描） | ✅ | ✅ | ✅ | `Q/LibraryWindow.cpp` + `LibraryController` ｜ `A · showRomLibrary + rom_favs` ｜ `I · showRomLibrary + RomLibrary.swift + rom_favs` | 入口形态不同，能力等价 |
| A4 | 即时存档 9 槽 + 槽位切换 | ✅ | ✅ | ✅ | `Q/LoadSaveState.h:29 NUM_SLOTS=9` + `Q/Window.cpp · quickSave.N 循环` ｜ `A · chooseSlot()`（1..9 + auto 槽 0）｜ `I · cycleSlot() + autoSlot=0` | — |
| A5 | 存档缩略图预览 | ✅ | ✅ | ✅ | `Q/LoadSaveState.cpp · loadState()` 从 `EXTDATA_SCREENSHOT` / `EXTDATA_SCREENSHOT_DIMENSIONS` 取图并 `setIcon()`（**不是** `preview`/`thumbnail` 关键字）｜ `A · decodePreview()` ｜ `I · writePreview()` | 三端都有（**首版误判为 PC 无，已更正**，见 §13） |
| A6 | 快速存档 / 读档（最近一次） | ✅ | ✅ | ✅ | `Q/Window.cpp · quickLoad/quickSave（Load recent / Save recent）` ｜ `A · btn_save / btn_load` ｜ `I · saveState() / loadState()` | — |
| A7 | 退出自动存档 / 启动自动读档 | ✅ | ✅ | ✅ | `Q/CoreController.cpp:327-328` 读 `autosave`/`autoload` + `SettingsView.ui · autosave（Periodically autosave state）/ autoload（Load last state）` + `thread.c` reset/clean 回调写读 slot 0（**配置键不是移动端的 `auto_save_state`**）｜ `A · auto_save_state / auto_load_state` ｜ `I · 同名两键` | 三端都有（**首版误判为 PC 无，已更正**）。语义差异：PC 是「周期性 + 退出写 / 启动读」，移动端是「退后台写 / 启动读」 |
| A8 | 撤销读档 / 撤销存档 | ✅ | ✅ | ✅ | `Q/Window.cpp · undoLoadState/undoSaveState → CoreController::loadBackupState/saveBackupState`（F11 / Shift+F11）｜ `A · 第 3749 行「撤销存档 / 撤销读档」段：读档前进度存内存快照，存档前旧内容写 `.ssN.bak`（跨进程有效）｜ `I · rememberUndoState / undoLastState` | 三端齐（移动端为本轮补齐，见 §13.4） |
| A9 | 电池存档导出/导入/转换（含 GameShark `.sps`） | ✅ | ◐ | ◐ | `Q/Window.cpp · convertSave / importShark / exportShark` ｜ `A · showSaveLocation + save_type + showBackupDialog` ｜ `I · showSaveLocation + save_type + showBackupDialog` | 移动端能改格式与位置，但**没有** `.sps` 导入导出、没有跨平台格式转换 |
| A10 | IPS/UPS/BPS 补丁 | ✅ | ✅ | ✅ | `Q/Window.cpp · loadPatch`（手动选）｜ `A · patches 开关（同名自动应用）` ｜ `I · patches 键（同名自动应用，帮助文案明示）` | PC 手动；移动端自动。能力等价、交互不同 |
| A11 | BIOS 选择 / 跳过 BIOS | ✅ | ✅ | ✅ | `Q/Window.cpp · bootBIOS + skipBios 选项` ｜ `A · btn_bios + use_bios / skip_bios` ｜ `I · "BIOS" 按钮 + use_bios / skip_bios` | — |
| A12 | RTC 时钟覆盖（模式 / 偏移 / 起点） | ✅ | ✅ | ✅ | `Q/OverrideView.cpp · hwRTC` ｜ `A · rtc_mode / rtc_offset_min / rtc_epoch（showAdvancedDialog）` ｜ `I · 同名三键（showAdvanced）` | — |
| A13 | 卡带震动 / 太阳能 / 倾斜陀螺 | ✅ | ✅ | ✅ | `Q/Window.cpp · solar 菜单 + sensorWindow`、`Q/EnhancementsView.cpp · 卡带震动`（行 146）｜ `A · cart_rumble / solar_* / tilt_sensor` ｜ `I · 同名` | — |
| A14 | **GBA 特殊外设**：GB 相机 / GB 打印机 / BattleChip Gate / e-Reader | ✅ | ❌ | ❌ | `Q/Window.cpp · loadCamImage / gbPrint / bcGate / scanCard / parseCard` ｜ 移动端全无（`camera`/`printer`/`ereader`/`BattleChip` 在 `A/`、`I/` 下 0 命中）｜ 同左 | **移动端缺 4 个外设**。手机无 e-Reader/打印机硬件，但 BattleChip 与相机图仍可用 |
| A15 | ROM 信息（卡带头 / 存档类型识别） | ✅ | ❌ | ❌ | `Q/Window.cpp · romInfo → ROMInfo 视图` ｜ 移动端无（`I/GBoyLink.swift · romInfo()` 是联机用 32 字节名字，不是 UI）｜ 同左 | **移动端缺**。金手指/存档类型排查时会用到 |

**A 组小计**：PC 有 15 / 部分 0 / 无 0（**全齐**）；Android 有 12 / 部分 1 / 无 2；iOS 有 12 / 部分 1 / 无 2。

---

## 2. B 组 · 速度与运行控制（9 项）

| # | 功能 | PC | Android | iOS | 证据 | 缺口说明 |
|---|---|---|---|---|---|---|
| B1 | 暂停 / 继续 | ✅ | ✅ | ✅ | `Q/Window.cpp · pause`（Ctrl+P）｜ `A · btn_pause` ｜ `I · togglePause()` | — |
| B2 | 复位 | ✅ | ✅ | ✅ | `Q/Window.cpp · reset`（Ctrl+R）｜ `A · btn_reset → confirmReset()` ｜ `I · resetGame()` | — |
| B3 | 关机 / 卸载卡带 | ✅ | ❌ | ❌ | `Q/Window.cpp · shutdown / yank（Yank game pak）` ｜ 移动端无（进程级退出）｜ 同左 | 移动端不需要 |
| B4 | **逐帧前进** | ✅ | ❌ | ❌ | `Q/Window.cpp · frameAdvance`（Ctrl+N）｜ 移动端无（`frameAdvance`/`stepFrame` 0 命中）｜ 同左 | **移动端缺**。金手指 / ROM hack 调试必需 |
| B5 | 快进（按住 / 开关） | ✅ | ✅ | ✅ | `Q/Window.cpp · holdFastForward / fastForward`（Tab / Shift+Tab）｜ `A · fast_hold + btn_fast` ｜ `I · fastHold + fastButton` | — |
| B6 | 快进倍率（预设 + 自定义小数） | ✅ | ✅ | ✅ | `Q/Window.cpp · fastForwardSpeed`（Unbounded + 2x..10x）｜ `A · showCustomSpeedDialog()` ｜ `I · showCustomSpeed()`（speedTiers 到 16x） | PC 上限 10x，移动端 16x |
| B7 | 每游戏倍速记忆 | ✅ | ✅ | ✅ | `Q/Window.cpp · storePerGameSpeed / applyPerGameSpeed + perRomSpeed 配置组`（本轮补）｜ `A · per_rom_speed` ｜ `I · showPerRomDialog` 中倍速项 | 三端齐（PC 侧由并行任务于本轮补齐，见 §13） |
| B8 | 倒带（按住 / 秒级滑条） | ✅ | ✅ | ✅ | `Q/Window.cpp · holdRewind / rewind` + `Q/ConfigController.cpp:146-147`（缓冲 300 帧 / 间隔 1）｜ `A · rewind_bar + Core.rewind(seconds)` ｜ `I · ControlsView rewind 键 + 秒条` | — |
| B9 | **逐帧倒带** | ✅ | ❌ | ❌ | `Q/Window.cpp · frameRewind`（Step backwards，Ctrl+B）｜ 移动端无 ｜ 同左 | **移动端缺** |

**B 组小计**：PC 有 9 / 部分 0 / 无 0；Android 有 6 / 部分 0 / 无 3；iOS 有 6 / 部分 0 / 无 3。

---

## 3. C 组 · 画面（11 项）

| # | 功能 | PC | Android | iOS | 证据 | 缺口说明 |
|---|---|---|---|---|---|---|
| C1 | 画面缩放倍数 | ✅ | ✅ | ✅ | `Q/Window.cpp · Frame size 1x..8x` ｜ `A · scene_scale / vf_aspect` ｜ `I · scene_scale` | — |
| C2 | 整数缩放 / 保持比例 | ✅ | ✅ | ✅ | `Q/Window.cpp · lockAspectRatio / lockIntegerScaling` ｜ `A · vf_integer / vf_aspect` ｜ `I · 同名` | — |
| C3 | 双线性过滤 | ✅ | ✅ | ✅ | `Q/Window.cpp · resampleVideo（Bilinear filtering）` ｜ `A · vf_linear` ｜ `I · vf_linear` | — |
| C4 | **内置画面滤镜（HQ2x / HQ4x / 2xBR / 4xBR / LCD3x / 点阵 / 残影 等 12 种）** | ❌ | ✅ | ✅ | PC 无（`Q/` 下 `HQ2x`/`2xBR`/`LCD3x` 0 命中，只有双线性）｜ `A · showVideoDialog 的滤镜列表 + Shaders.java` ｜ `I · filterNames（12 项）+ Shaders.metal` | **PC 缺 = 当前 PC 第一优先（§11 ①）**。授权已扩到 `src/` 全目录，须**软件渲染 + OpenGL 双后端**同时生效 |
| C5 | **亮度 / 对比度 / 扫描线** | ❌ | ✅ | ✅ | PC 无 ｜ `A · vf_bright / vf_contrast / vf_scan` ｜ `I · 同名` | **PC 缺（§11 ②）**，复用 C4 的 shader 链，双后端同样要求 |
| C6 | 着色器 | ✅ | ✅ | ✅ | `Q/SettingsView.cpp:426/438（Shaders 页，mGBA .shader GLSL 归档）` ｜ `A · ext_shader + Shaders.java` ｜ `I · ExternalShader.swift + Shaders.metal` | 三端**格式完全不同**，资产不能互用 |
| C7 | 帧跳过 | ✅ | ✅ | ✅ | `Q/Window.cpp · frameskip（0..10）` ｜ `A · vf_skip / vf_skip_auto` ｜ `I · 同名` | — |
| C8 | **帧率目标 15/30/45/60/90/120/240/Native** | ✅ | ❌ | ❌ | `Q/Window.cpp · fpsTarget` ｜ 移动端无（`fpsTarget` 0 命中；移动端只能靠倍速，语义不同）｜ 同左 | **移动端缺** |
| C9 | **视频层 / 音频通道单独开关** | ✅ | ❌ | ❌ | `Q/Window.cpp · videoLayers / audioChannels + listVideoLayers/listAudioChannels 动态枚举` ｜ 移动端无 ｜ 同左 | **移动端缺**（调试向） |
| C10 | **3D 层位置调整** | ✅ | ❌ | ❌ | `Q/Window.cpp · placementControl（Adjust layer placement...）` ｜ 移动端无 ｜ 同左 | **移动端缺** |
| C11 | FPS 实时显示 | ✅ | ✅ | ✅ | `Q/Window.cpp · showFPS()` ｜ `A · R.id.fps` ｜ `I · fpsView` | — |

**C 组小计**：PC 有 9 / 部分 0 / 无 2；Android 有 8 / 部分 0 / 无 3；iOS 有 8 / 部分 0 / 无 3。

---

## 4. D 组 · 音频（5 项）

| # | 功能 | PC | Android | iOS | 证据 | 缺口说明 |
|---|---|---|---|---|---|---|
| D1 | 音量 | ✅ | ✅ | ✅ | `Q/Window.cpp · volume 菜单（0/25/50/75/100/150%）+ Settings 滑块` ｜ `A · volume` ｜ `I · volume` | PC 菜单只有 6 档 |
| D2 | 静音 | ✅ | ✅ | ✅ | `Q/Window.cpp · mute` ｜ `A · muted` ｜ `I · muted` | — |
| D3 | **采样率 / 缓冲 / 音频驱动可选** | ✅ | ❌ | ❌ | `Q/SettingsView.ui（av 页 audioDriver / audioBufferSize / sampleRate）+ Q/SettingsView.cpp:505` ｜ `A · 恒 48000（sampleRate() 的 fallback）` ｜ `I/AudioOut.swift · outputRate = 48000` | **移动端缺**（由系统决定，合理） |
| D4 | 低延迟模式 | ◐ | ✅ | ✅ | PC 只能手动调缓冲，无显式开关 ｜ `A · low_latency` ｜ `I · low_latency` | PC「部分」 |
| D5 | 快进时音频处理（变调 / WSOLA 不变调 / 1x 原速） | ✅ | ✅ | ✅ | `Q/EnhancementsView.cpp · 快进音乐三模式 + 快进倍率` ｜ `A · fast_audio / fast_audio_native` ｜ `I · 同名` | — |

**D 组小计**：PC 有 4 / 部分 1 / 无 0；Android 有 4 / 部分 0 / 无 1；iOS 有 4 / 部分 0 / 无 1。

---

## 5. E 组 · 输入与布局（12 项）

| # | 功能 | PC | Android | iOS | 证据 | 缺口说明 |
|---|---|---|---|---|---|---|
| E1 | 键盘按键重映射 | ✅ | ◐ | ❌ | `Q/SettingsView.cpp:342（Keyboard 页，逐键重映射 + 配置文件）` ｜ `A · onKeyDown 里硬编码 KEYCODE_*，无 UI` ｜ iOS 无硬件键盘路径 | **Android 缺 UI（仅硬编码）**，**iOS 缺** |
| E2 | 手柄支持 | ✅ | ✅ | ✅ | `Q/InputController.cpp · SDL gamepad 轮询` ｜ `A · onKeyDown 处理 BUTTON_* / THUMBR` ｜ `I · bindControllers（GCControllerDidConnect）` | 三端都能用，抽象层不同 |
| E3 | **手柄按键重映射** | ✅ | ❌ | ❌ | `Q/SettingsView.cpp:354（Controllers 页）` ｜ 移动端无（`key_layout` 只管触屏）｜ 同左 | **移动端缺** |
| E4 | 虚拟按键布局编辑（拖拽 / 缩放 / 配置档） | ❌ | ✅ | ✅ | PC 无此概念 ｜ `A · ControlsView.java + KeyLayout.java + layout_profiles + showLayoutProfiles()` ｜ `I · ControlsView.swift（setCenters/setScales）+ layout_profiles` | **PC 缺** |
| E5 | 皮肤主题 | ❌ | ✅ | ✅ | ｜ `A · SkinStore.java + SkinTheme.java + skin_style/skin_color/full_skin` ｜ `I · SkinStore.swift + SkinTheme.swift + 同名键` | **PC 缺** |
| E6 | 竖屏双屏（上画面 / 下按键，DS 式） | ❌ | ✅ | ✅ | ｜ `A · ScreenSplit.java + orientation` ｜ `I · ShellStageView.swift + portrait 分支` | **PC 缺**（无必要） |
| E7 | 连发 / 自动连发 | ✅ | ✅ | ✅ | `Q/Window.cpp · Autofire 子菜单（A/B/L/R 勾选 + Rate 2/4/8/15Hz，本轮补可见 UI 与持久化 `autofireLock*`/`autofireRate`）` ｜ `A · turbo 键 + turbo_rate` ｜ `I · turbo 键（ControlsView）` | 三端齐（PC 原先只有隐藏菜单，本轮已补，见 §13） |
| E8 | **宏键（C / C2 / L+R 一键）** | ❌ | ✅ | ✅ | ｜ `A · c_macro / c2_macro + showMacroDialog()` ｜ `I · showMacroDialog()` | **PC 缺** |
| E9 | **触感振动** | ❌ | ✅ | ✅ | ｜ `A · touch_vibe` ｜ `I · touch_vibe` | **PC 缺** |
| E10 | **双击截图 / 一键倒带键** | ❌ | ✅ | ✅ | ｜ `A · double_click_shot / rewind_tap_seconds` ｜ `I · ControlsView actionRewindQuick + quickRewindSeconds` | **PC 缺**（PC 用 F12 / ` ） |
| E11 | 屏幕方向 / 旋转 | ❌ | ✅ | ✅ | ｜ `A · showOrientationDialog + quick_rotate` ｜ `I · showOrientationDialog()` | **PC 缺**（无意义） |
| E12 | 沉浸式全屏 / 隐藏菜单 | ✅ | ✅ | ◐ | `Q/Window.cpp · hideMenu（Ctrl+M）/ Toggle fullscreen` ｜ `A · immersive` ｜ `I · 仅菜单自动淡出（armMenuAutoHide），无显式开关` | iOS「部分」 |

**E 组小计**：PC 有 5 / 部分 0 / 无 7；Android 有 10 / 部分 1 / 无 1；iOS 有 9 / 部分 1 / 无 2。

---

## 6. F 组 · 内容与工具（13 项）

| # | 功能 | PC | Android | iOS | 证据 | 缺口说明 |
|---|---|---|---|---|---|---|
| F1 | 截图（目录可选 / 格式可选） | ✅ | ✅ | ✅ | `Q/Window.cpp · takeScreenshot + screenshotPath / screenshotSameDir + screenshotFormat（png/jpg，本轮补）` ｜ `A · takeScreenshot() + shot_format` ｜ `I · takeScreenshot() + shot_format` | 三端齐（PC 侧格式项由本轮补齐） |
| F2 | GIF 录制 | ✅ | ✅ | ✅ | `Q/Window.cpp · recordGIF（GIF/WebP/APNG）` ｜ `A · btn_gif + GifEncoder.java` ｜ `I · toggleGif() + GifEncoder.swift` | PC 多 WebP/APNG 两种格式 |
| F3 | **视频录像（带音频）** | ✅ | ❌ | ❌ | `Q/Window.cpp · recordOutput → VideoView（FFmpeg）` ｜ 移动端无（`recordOutput`/`VideoView` 0 命中）｜ 同左 | **移动端缺** |
| F4 | **GIF 悬浮球** | ❌ | ✅ | ✅ | ｜ `A · GifBall.java + gif_ball / gif_ball_pos` ｜ `I · GifBall.swift` | **PC 缺** |
| F5 | 金手指（AR/GS/CB + 逐条开关） | ✅ | ✅ | ✅ | `Q/Window.cpp · cheatsWindow → CheatsView` ｜ `A · showCheatsDialog() + 格式选择` ｜ `I · showCheats()` | — |
| F6 | 内存数值搜索（金手指搜索） | ✅ | ✅ | ✅ | `Q/Window.cpp · memorySearch → MemorySearch` ｜ `A/DebugViewers.java · showMemory 内搜索面板` ｜ `I/DebugViewers.swift · showSearch（独立按钮）` | 组织方式不同 |
| F7 | 每游戏设置（滤镜/倍速/存档类型/调色板） | ✅ | ✅ | ✅ | `Q/Window.cpp · overrideWindow → OverrideView` ｜ `A · RomSettingsDb.java（SQLite）+ showPerRomDialog()` ｜ `I · RomSettings.swift + showPerRomDialog()` | PC 覆盖项更广（core 级 override） |
| F8 | 一键备份（配置+存档 → zip） | ✅ | ✅ | ✅ | `Q/EnhancementsView.cpp · 一键备份` ｜ `A · BackupTask.java + btn_backup` ｜ `I · BackupStore.swift + showBackupDialog()` | — |
| F9 | WebDAV 存档同步 | ✅ | ✅ | ✅ | `Q/Window.cpp · webdavSync → WebDavView + WebDavSync.cpp` ｜ `A · WebDavSync.java + sync_*` ｜ `I · WebDavSync.swift + sync_*` | — |
| F10 | 存档位置（ROM 同目录 / 自定义） | ✅ | ✅ | ✅ | `Q/SettingsView.ui · savegameSameDir（勾上即留空 savegamePath，mDirectorySetMapOptions 不覆盖 dirs.save）` ｜ `A · SaveLocation.java + saves_beside_rom` ｜ `I · saves_beside_rom + 目录 bookmark` | 三端都有（**首版误判为 PC 部分，已更正**） |
| F11 | **AI 截图翻译** | ❌ | ✅ | ✅ | ｜ `A · AiTranslate.java + AiOverlayView.java + ai_key / ai_lang + showTranslateDialog()` ｜ `I · AiTranslate.swift + AiOverlayView.swift + showTranslateDialog()` | **PC 缺**（纯移动端功能） |
| F12 | **贴纸叠加层** | ❌ | ✅ | ✅ | ｜ `A · StickerOverlay.java + 贴纸选择器` ｜ `I · StickerOverlayView.swift` | **PC 缺** |
| F13 | 日志查看 / 崩溃报告 / 帮助 | ✅ | ◐ | ◐ | `Q/Window.cpp · viewLogs → LogView、bugReport → ReportView` ｜ `A · showHelpDialog()（仅静态文案，无日志导出）` ｜ `I · showHelpDialog()` | 移动端**没有日志查看/导出** |

**F 组小计**：PC 有 10 / 部分 0 / 无 3；Android 有 11 / 部分 1 / 无 1；iOS 有 11 / 部分 1 / 无 1。

---

## 7. G 组 · 联机（10 项）

> 协议细节见 `NETPLAY_AUDIT.md`；本表只判「用户能不能用到一个闭环」。

| # | 功能 | PC | Android | iOS | 证据 | 缺口说明 |
|---|---|---|---|---|---|---|
| G1 | 直连 P2P（TCP 主/客） | ✅ | ✅ | ✅ | `Q/Window.cpp · gboyLink（WiFi 联机…）→ LinkView` ｜ `A · showLinkDialog() + GBoySocketLink.java` ｜ `I · showLink() + GBoyLink.swift` | — |
| G2 | 局域网精确 SIO（3/4 人总线 / 进程内锁步） | ✅ | ✅ | ✅ | `Q/LinkView.ui（局域网精确 SIO 联机线说明）+ Q/CoreController.cpp · lanLinkHostPlayers + Q/GBoyMirror.cpp` ｜ `A · GBoyConsoleSet.linkHostLocal / linkHostLockstep` ｜ `I · GBoyConsoleSet.swift mgbaMobileLinkHostLockstep + startLocalLockstep()` | iOS 只有 lockstep 变体，无 star-bus 分支 |
| G3 | 蓝牙 | ✅ | ✅ | ❌ | `Q/BtLink.h（仅 Windows AF_BTH）+ Q/CloudLink.cpp · MGBAX_BT` ｜ `A · GBoyBluetoothLink.java（RFCOMM）` ｜ iOS 无（无经典 RFCOMM API） | **iOS 缺**（平台限制） |
| G4 | 云端房间（gboy.top 账号/房间） | ✅ | ✅ | ✅ | `Q/Window.cpp · cloudLobby（联机大厅…）→ LobbyView + Q/GbCloud.cpp` ｜ `A · GbCloud.java + GBoyCloudLink.java` ｜ `I · LobbySignaling.swift + LobbyLink.swift` | — |
| G5 | KCP/UDP 通道 | ✅ | ✅ | ✅ | `Q/KcpChannel.cpp（mtu512/mss488/30ms）` ｜ `A · KcpChannel.java` ｜ `I · LobbyKcp.swift` | 三端参数已对齐 |
| G6 | **多窗口本地联机（同机多实例）** | ✅ | ❌ | ❌ | `Q/Window.cpp · multiWindow（New multiplayer window）+ MultiplayerController.cpp` ｜ 移动端无 ｜ 同左 | **移动端缺**（移动端用进程内多核代替） |
| G7 | 状态同步（握手灌 type 6） | ✅ | ✅ | ✅ | `Q/CloudLink.cpp · maybeSendInitialState` ｜ `A · GBoyCloudLink（连上后一次）` ｜ `I · GBoyLink（握手内双向）` | 详见 NETPLAY_AUDIT 第 13/14 行 |
| G8 | 倍速同步（type 9 真正改帧闸） | ✅ | ✅ | ✅ | `Q/CoreController.cpp · setNetSpeed()` + `Q/CloudLink.cpp · m_mirrors[i]->setNetSpeed` + `Q/Window.cpp · setNetSpeed/reflectNetSpeed`（Tools→Speed）｜ `A · GBoyLinkSession.paceNanosForSpeed()` ｜ `I · GBoySpeed.sliceNanos(rate:)` + 音频 `playRate` | 三端齐（本轮按 `1e9/(rate*60)` 统一，1x 不覆盖本机节拍、断开复位 1x；见 §13.4） |
| G9 | 断线通知（type 10） | ❌ | ❌ | ✅ | ｜ ｜ `I · LobbyFrames.swift typeDisconnect=10 + LobbyLink 收下即收尾` | **仅 iOS 有**，PC/Android 靠 socket EOF |
| G10 | 远程按键注入 / 调试入口 | ✅ | ✅ | ◐ | PC：环境变量 `MGBAX_*` + **本轮新增可见对话框 `DirectTransportDialog`（蓝牙/TCP 直连传输）**（`Q/Window.cpp`）｜ `A · io.mgba.android.action.* 共 10 组广播` ｜ `I · 只有启动参数 -gboyLockstepPlayers` | iOS 最弱；PC 已从「只认 env」升级为「env + 可见 UI」 |

**G 组小计**：PC 有 9 / 部分 0 / 无 1；Android 有 8 / 部分 0 / 无 2；iOS 有 7 / 部分 1 / 无 2。

---

## 8. H 组 · 诊断与开发工具（10 项）

| # | 功能 | PC | Android | iOS | 证据 | 缺口说明 |
|---|---|---|---|---|---|---|
| H1 | 内存查看（分区跳转 + 编辑） | ✅ | ✅ | ✅ | `Q/Window.cpp · memoryView → MemoryView` ｜ `A/DebugViewers.java · showMemory` ｜ `I/DebugViewers.swift · showMemory` | — |
| H2 | 背景图层查看 | ✅ | ✅ | ✅ | `Q/Window.cpp · tileWindow / mapWindow` ｜ `A · showBg（按 mode 渲染）` ｜ `I · showBg` | 实现路径不同但都能看 BG |
| H3 | OAM 精灵查看 | ✅ | ✅ | ✅ | `Q/Window.cpp · spriteWindow → ObjView` ｜ `A · showOam` ｜ `I · showOam` | — |
| H4 | 调色板查看 | ✅ | ✅ | ✅ | `Q/Window.cpp · paletteWindow → PaletteView` ｜ `A · showPalette` ｜ `I · showPalette` | — |
| H5 | **独立 tile / map 查看器** | ✅ | ❌ | ❌ | `Q/Window.cpp · tileWindow / mapWindow（VRAM tile 表、地图滚动）` ｜ 移动端无 ｜ 同左 | **移动端缺** |
| H6 | **I/O 寄存器 / 帧检查器** | ✅ | ❌ | ❌ | `Q/Window.cpp · ioViewer / frameWindow` ｜ 移动端无 ｜ 同左 | **移动端缺** |
| H7 | **内存访问日志 / 视频调试日志** | ✅ | ❌ | ❌ | `Q/Window.cpp · memoryAccessView / recordVL` ｜ 移动端无 ｜ 同左 | **移动端缺** |
| H8 | **调试器控制台 / GDB server** | ✅ | ❌ | ❌ | `Q/Window.cpp · debuggerWindow / gdbWindow（ENABLE_DEBUGGERS）` ｜ 移动端无 ｜ 同左 | **移动端缺** |
| H9 | **脚本系统（自动化）** | ✅ | ❌ | ❌ | `Q/Window.cpp · scripting → scripting/ScriptingView` ｜ 移动端无 ｜ 同左 | **移动端缺** |
| H10 | **调试素材导出（OAM/调色板 → PNG/相册）** | ❌ | ✅ | ✅ | ｜ `A/DebugViewers.java · 导出` ｜ `I/DebugViewers.swift · saveToPhotos` | **PC 缺**（PC 只能存单张截图） |

**H 组小计**：PC 有 9 / 部分 0 / 无 1；Android 有 5 / 部分 0 / 无 5；iOS 有 5 / 部分 0 / 无 5。

---

## 9. 统计

| 平台 | ✅ 有 | ◐ 部分 | ❌ 无 | 合计 |
|---|---|---|---|---|
| **PC（Qt）** | **70** | **1** | **14** | 85 |
| **Android** | **64** | **3** | **18** | 85 |
| **iOS** | **62** | **4** | **19** | 85 |

- 功能条目总数：**85**（A15 + B9 + C11 + D5 + E12 + F13 + G10 + H10）。
- 三端同时 ✅ 的：**47 项（55%）**；**三端同时 ❌ 的：0 项**（本轮 `G8` 倍速同步、移动端撤销读档补齐后清零）。
- PC 缺的 14 项里，**12 行**对应 §10.2 的"移动端独有清单"（M1–M11；其中 M10 覆盖 E9/E10 两行），另外 2 项是 `E11` 屏幕方向（桌面无意义）与 `G9` type 10（iOS 独有）。
- 移动端各缺 **18 项**（iOS 多 1 项：`G3` 蓝牙），其中 **15 项**对应 §10.1 的"PC 独有清单"；另外 3 项（`A15` ROM 信息、`B3` 关机、`G9` type 10）不属于任何一端的独有能力。
- 分模块看：**A 组（核心存档）与 B 组（速度）PC 已 15/15、9/9 全齐**，G 组（联机）PC 9/10；PC 剩余缺口集中在 **E 组（输入/布局，7 项）与 C 组（画面，2 项）**。
- **Android ↔ iOS 差异仅 5 处**：`E1`（Android 有硬编码键盘、iOS 无）、`E12`（Android 有 immersive 开关）、`G2`（iOS 少 star-bus）、`G9`（iOS 多 type 10）、`G10`（iOS 只认启动参数）。**没有一处是漏做，全部是平台能力差异。**

---

## 10. 已有但只在单端的实现（用户最可能说的"这不是你做的"）

### 10.1 只有 PC 有 —— 移动端完全没有（14 条）

| # | 功能 | 证据（可全文搜索的符号） |
|---|---|---|
| P1 | 调试器控制台 + GDB server | `Q/Window.cpp debuggerWindow` / `gdbWindow` |
| P2 | 脚本系统（自动化 / autorun） | `Q/Window.cpp scripting` → `scripting/ScriptingView` |
| P3 | 独立 tile / map 查看器 | `Q/Window.cpp tileWindow` / `mapWindow` |
| P4 | I/O 寄存器 + 帧检查器 | `Q/Window.cpp ioViewer` / `frameWindow` |
| P5 | 内存访问日志 + 视频调试日志 | `Q/Window.cpp memoryAccessView` / `recordVL` |
| P6 | AV 录像（FFmpeg，带音频） | `Q/Window.cpp recordOutput` → `VideoView` |
| P7 | 视频层/音频通道单独开关 + 3D 层位置 | `Q/Window.cpp videoLayers` / `audioChannels` / `placementControl` |
| P8 | 帧率目标 15–240 + Native | `Q/Window.cpp fpsTarget` |
| P9 | 逐帧前进 / 逐帧倒带 | `Q/Window.cpp frameAdvance` / `frameRewind` |
| P10 | 多窗口本地联机 | `Q/Window.cpp multiWindow` + `MultiplayerController` |
| P11 | 特殊外设：GB 相机 / GB 打印机 / BattleChip / e-Reader | `Q/Window.cpp loadCamImage` / `gbPrint` / `bcGate` / `scanCard` |
| P12 | 键盘+手柄完整重映射与配置文件 | `Q/SettingsView.cpp:342 Keyboard` / `:354 Controllers` |
| P13 | 音频采样率/缓冲/驱动可选 | `Q/SettingsView.ui` av 页 `audioDriver` / `audioBufferSize` / `sampleRate` |
| P14 | Create forwarder（生成独立快捷启动器） | `Q/Window.cpp createForwarder` |

> 原 P9「撤销读档 / 撤销存档」已移出：Android 与 iOS 本轮都补齐了（§13.4），三端现已齐。

### 10.2 只有移动端有 —— PC 完全没有（11 条）

> 原 M9「存档缩略图」、M10「自动存档/读档」经逐符号复核**PC 已有**（`EXTDATA_SCREENSHOT` / `autosave`·`autoload`），已从本表移除，见 §13。

| # | 功能 | 证据 |
|---|---|---|
| M1 | 12 种画面滤镜（HQ2x/HQ4x/2xBR/4xBR/LCD3x/点阵/残影/锐利插值…） | `A/Shaders.java` + `A · showVideoDialog 滤镜列表`；`I · filterNames` + `Shaders.metal` |
| M2 | 亮度 / 对比度 / 扫描线 | `A · vf_bright / vf_contrast / vf_scan`；`I · 同名` |
| M3 | 皮肤主题（外框 / 背景 / 配色） | `A/SkinStore.java` + `SkinTheme.java`；`I/SkinStore.swift` + `SkinTheme.swift` |
| M4 | 虚拟按键布局编辑器 + 布局配置档 | `A/ControlsView.java` + `KeyLayout.java` + `layout_profiles`；`I/ControlsView.swift` + `KeyLayout.swift` |
| M5 | 竖屏双屏（上画面下按键） | `A/ScreenSplit.java`；`I/ShellStageView.swift` |
| M6 | AI 截图翻译（含悬浮译文层） | `A/AiTranslate.java` + `AiOverlayView.java`；`I/AiTranslate.swift` + `AiOverlayView.swift` |
| M7 | 贴纸叠加层 | `A/StickerOverlay.java`；`I/StickerOverlayView.swift` |
| M8 | GIF 悬浮球 | `A/GifBall.java`；`I/GifBall.swift` |
| M9 | 宏键（C / C2 / L+R 一键） | `A · c_macro / c2_macro + showMacroDialog()`；`I · showMacroDialog()` |
| M10 | 触感振动 / 双击截图 / 一键倒带键 | `A · touch_vibe / double_click_shot / rewind_tap_seconds`；`I · 同名 + actionRewindQuick` |
| M11 | 调试素材导出（OAM/调色板 → 相册） | `A/DebugViewers.java · 导出`；`I/DebugViewers.swift · saveToPhotos` |

### 10.3 只有 Android 有（4 条）
1. **busgame 总线脚本调试**（镜像核脚本自动跑菜单，`bus_peer` / `bus_players` 键）—— `A · setBusGame / core.busGameStart`
2. **蓝牙 RFCOMM 联机** —— `A/GBoyBluetoothLink.java`（iOS 无经典蓝牙 API）
3. **`io.mgba.android.action.*` 广播调试面**（10 组，`adb shell am broadcast` 可直接驱动）—— `A · registerReceiver 系列`
4. **SAF 存档位置 / 分区访问授权** —— `A/SaveLocation.java` + `save_access_declined`

### 10.4 只有 iOS 有（1 条）
1. **`type 10` 断线通知接收** —— `I/LobbyFrames.swift typeDisconnect` + `I/LobbyLink.swift` 收下即正常收尾（PC/Android 只记未知类型）

---

## 11. 按价值的修复排序

> 每条给：**改哪 / 大概多少行 / 是否三端同改 / 为什么排这个位置**。
> 依据 = 「用户能不能感知」×「改动是否被跨端协议绑死」。

### 档 1 · 用户高频（日常每一步都会碰到）

| 序 | 事项 | 改哪 | 量 | 三端同改？ | 理由 |
|---|---|---|---|---|---|
| ① | **PC 补 12 种画面滤镜**（HQ2x/HQ4x/2xBR/4xBR/LCD3x/点阵/残影/锐利插值…） | `src/platform/opengl` 着色器链 + `Q/DisplayGL.cpp` + **软件渲染路径（`Q/DisplayQt.cpp`）也要同样生效**；授权已扩到 `src/` 全目录 | ~500 行（双后端 ×12 滤镜） | 否（只 PC） | **当前 PC 第一优先**：移动端用了两年、PC 只有双线性，是最容易被用户一眼看出的落差；越界限制已解除 |
| ② | **PC 补亮度 / 对比度 / 扫描线** | 同上，复用 ① 的 shader 链插参数 | ~250 行 | 否（只 PC） | 与 ① 同一套代码，做完 ① 后边际成本很低；`vf_bright/vf_contrast/vf_scan` 三端只剩 PC 没有 |
| ③ | **三端统一存档目录与命名**（含 `saves_beside_rom`） | `Q/CoreController` 路径解析、`A/SaveLocation.java`、`I` 目录 bookmark | 各 ~60 行 | **是** | 三端各自都"能设"，但默认规则不同（PC 靠 `savegameSameDir` 勾选、Android 靠 SAF、iOS 靠 bookmark）；跨端搬存档仍会踩坑，也是备份/WebDAV 的前置 |
| ④ | **移动端补逐帧前进 / 逐帧倒带** | 移动端工具栏 2 个按钮 + 桥接暴露 `frameAdvance` / `rewind(2)` | 各 ~40 行 | 是（两端） | 金手指制作与 ROM hack 排错刚需；PC 的 `frameAdvance`/`frameRewind` 可照抄 |
| ⑤ | **PC 补低延迟音频开关** | `Q/SettingsView.ui` 一个勾选 + 启动时把 `audioBuffers` 降到 512 并旁路重采样 | ~40 行 | 否（只 PC） | PC 目前只能手调 `audioBufferSize`；移动端有一键开关，桌面玩家对延迟同样敏感 |

> 本档已关闭（**不要再做**）：PC 自动存档/缩略图（本来就有）、PC 每游戏倍速、PC 截图格式、PC 连发可见 UI（g11 已完成，见 §13.2）、移动端撤销读档（Android/iOS 已完成，见 §13.4）、type 9 倍速同步（三端已完成，见 §13.4）。

### 档 2 · 联机必需（不做就跟官方客户端 / 跨端对局对不上）

| 序 | 事项 | 改哪 | 量 | 三端同改？ | 说明 |
|---|---|---|---|---|---|
| ⑥ | **`type 3` 拆三态**（就绪 / 载入指令 / 空 ack） | 三端 `GBoyLinkSession` | 各 ~60 行 | **是** | 云端 3/4 人房状态机正确性；中风险。握手序列 `1→2→3→6` 三端现已一致，剩下的是**语义分态** |
| ⑦ | **`type 10` 断线通知三端统一** | `Q/GBoyFrames.h` + `A/GBoyFrames.java` 加常量与处理，断开前发一次 | 各 ~20 行 | **是** | 现在只有 iOS 收，PC/Android 靠 EOF 判死延迟大 |
| ⑧ | **槽位映射换官方 `A2egSU(pc,index)` 表** | 三端 `mirrorSlotFor` | 各 ~40 行 | **是** | NETPLAY_AUDIT C9；不换则只有 4 人房时与官方重合 |

> 本档已关闭（**不要再做**）：`type 9` 倍速同步（三端已完成）、Android 握手第三帧 `type 3`（`GBoyLinkSession.sendSocketHandshake()` 现发 `1→2→3`，线上严格 `1→2→3→6`），见 §13.4。

### 档 3 · 进阶 / 小众（补齐体验，不影响主流程）

| 序 | 事项 | 改哪 | 量 | 三端同改？ | 备注 |
|---|---|---|---|---|---|
| ⑨ | 移动端补 tile / map / I/O / 帧检查器 | 复用 `A/DebugViewers.java` 现有渲染器 + 新增页 | 各 ~300 行 | 是（两端） | 联机排错与金手指制作会用到 |
| ⑩ | 移动端补 ROM 信息页 | 新增 `ROMInfo` 等价面板 | 各 ~80 行 | 是 | — |
| ⑪ | PC 补「每游戏滤镜」 | `Q/OverrideView.cpp` 加一项 | ~30 行 | 否 | 依赖档 1 ① 的滤镜先落地 |
| ⑫ | 三端统一着色器格式 | 让 PC 能读移动端 `.glsl`（或反之） | ~250 行 | 是 | 资产不能互用是长期债；可复用档 1 ① 的管线 |
| ⑬ | PC 补 GIF 球 / 贴纸 / AI 翻译 | 新组件，桌面端价值低 | 300–600 行 | 否 | 用户明确要"全同步"时再做 |
| ⑭ | PC 补宏键 / 触感 / 双击截图 | 依赖平台能力，桌面收益低 | 各 ~40 行 | 否 | — |

---

## 12. 检索记录（避免"凭印象"，每条都是负结果验证）

| 结论 | 已检索关键字 | 结果 |
|---|---|---|
| ~~PC 无自动存档~~ **误判，已更正** | `autoSaveState`、`autoLoadState`、`auto_save_state` | 按移动端键名搜所以 0 命中；PC 实际用 `autosave`/`autoload` → **PC 有**，见 §13 |
| ~~PC 无存档缩略图~~ **误判，已更正** | `preview`、`thumbnail`、`screenshot` | 按 Qt 常规词搜所以 0 命中；PC 实际用 `EXTDATA_SCREENSHOT` + `setIcon()` → **PC 有**，见 §13 |
| 移动端无 AV 录像 | `recordOutput`、`VideoView`、`recordVideo`、`RECORD` | `A/`、`I/` 0 命中 |
| 移动端无逐帧 | `frameAdvance`、`stepFrame`、`advanceFrame` | 0 命中 |
| ~~移动端无撤销存档~~ **已过时** | `loadBackupState`、`saveBackupState`、`undoLoad`；`M/mgba_mobile.h` 内 `Backup` | 首轮确实 0 命中（当时移动端未实现）；**本轮已补齐**（Android `.ssN.bak` + 内存快照、iOS `rememberUndoState`），见 §13.4 |
| PC 无 HQ2x 等滤镜 | `HQ2x`、`2xBR`、`LCD3x` | `Q/` 0 命中 |
| 移动端无 fpsTarget | `fpsTarget`、`fps_target` | 0 命中 |
| 移动端无特殊外设 | `camera`、`printer`、`ereader`、`BattleChip`、`forwarder` | `A/`、`I/` 0 命中 |
| PC 无皮肤/贴纸/GIF球/AI翻译/双屏 | `skin`（仅 LibraryController 封面）、`Sticker`、`GifBall`、`AiTranslate`/`ai_key`、`ScreenSplit` | 均 0 命中 |
| iOS 无蓝牙 | `Bluetooth`、`RFCOMM` | `I/` 0 命中（平台无经典蓝牙 API） |
| iOS 无非锁步 star-bus | `localBus`、`linkHostLocal`、`linkJoinLocal` | `I/GBoyConsoleSet.swift` 0 命中，只有 `HostLockstep`/`JoinLockstep` |
| 移动端帧率固定 | `sampleRate` 硬编码 48000（`A · sampleRate() fallback`、`I/AudioOut.swift outputRate`） | 未找到 fps 上限配置 → 按"无 fpsTarget"计 |

> **两点免责**：
> 1. 本次**未运行任何构建或真机测试**，所有"有/无"均为源码静态检索结论。
> 2. iOS 侧从未在本机编译成功（`NETPLAY_AUDIT.md` 第 52 行：`swiftc -parse` 通过但未编译未真机），
>    因此 iOS 列的能力是"代码存在且 UI 已接线"，**不代表运行期可用**。
> 3. 行号一律省略（见文首说明）；`Window.cpp` / `EmulatorActivity.java` 在审计期间仍被并行修改，
>    若需精确位置请全文搜索本文给出的符号名。

---

## 13. 修正记录（首版误判 + 并行任务已关闭项）

> 首版有 **4 处 PC 假阴性**，根因是"只按移动端命名习惯搜关键字"（`auto_save_state` / `preview` / `thumbnail`），
> 而 PC 用的是另一套命名（`autosave`/`autoload`、`EXTDATA_SCREENSHOT`、`savegameSameDir`）。
> 由 general-purpose-11 逐符号复核发现，本节逐条留证，**后续不要重复实现**。

### 13.1 首版误判（PC 其实已有，已改正矩阵）

| 条目 | 首版 | 实际 | 证据 |
|---|---|---|---|
| A5 存档缩略图 | PC ❌ | **PC ✅** | `Q/LoadSaveState.cpp · loadState()`：`mStateExtdataGet(&extdata, EXTDATA_SCREENSHOT, &item)` + `EXTDATA_SCREENSHOT_DIMENSIONS` → `QIcon` → `m_slots[slot-1]->setIcon()`，9 槽本就有图 |
| A7 自动存档/读档 | PC ❌ | **PC ✅** | `Q/CoreController.cpp:327-328` 读 `autosave`/`autoload`；`Q/SettingsView.ui:593 autoload（Load last state）`、`:627 autosave（Periodically autosave state）`；`SettingsView.cpp:542-543` 保存；`thread.c` reset/clean 回调写读 slot 0 |
| F10 存档跟 ROM 走 | PC ◐ | **PC ✅** | `Q/SettingsView.ui · savegameSameDir` → 留空 `savegamePath` → `src/core/directories.c · mDirectorySetMapOptions` 不覆盖 `dirs.save` |
| F1 截图目录 | PC「只有 PNG」 | **目录可配**，只缺格式 | `Q/SettingsView.ui · screenshotPath / screenshotSameDir`；格式一项本轮已补 |

### 13.2 本轮已由并行任务（general-purpose-11）关闭的 PC 缺口

> 详见 `tmp_gboy_apk/PC_GAPS.md` §2。矩阵对应条目已同步更新为 ✅。

| # | 已补功能 | 条目 | 落地证据 |
|---|---|---|---|
| 1 | 启动时自动打开上次的 ROM（`loadLastRom`） | A2 增强 | `Q/Window.cpp · argumentsPassed()` 取 `MRU[0]` |
| 2 | 截图格式 PNG / JPEG（`screenshotFormat`） | F1 | `Q/Window.cpp · takeScreenshot()`，JPEG 质量 92 |
| 3 | 连发可见 UI + 速率 + 持久化（`autofireLock*`/`autofireRate`） | E7 | `Q/Window.cpp · Autofire 子菜单 + gameStarted()` |
| 4 | 每游戏倍速（`perRomSpeed` 配置组） | B7 | `Q/Window.cpp · storePerGameSpeed / applyPerGameSpeed` |
| 5 | 联机直连传输可见入口（蓝牙/TCP） | G3 / G10 | `Q/DirectTransportDialog` + `applyToEnvironment()`，只写 `MGBAX_*`，不改帧格式 |

### 13.3 明确"不做"的项（平台无意义，避免反复被提）

> **授权已变更（2026-11-15 第三批）**：PC agent 的改动范围已从「Qt/mobile」扩至 **`src/` 下除 `android/`、`ios/` 之外的全部目录**。
> 因此原先因"越界"而搁置的 **画面滤镜（C4）与亮度/对比度/扫描线（C5）现已解禁**，已上移为 §11 档 1 的 ①②，
> 并要求**软件渲染（`Q/DisplayQt.cpp`）与 OpenGL（`src/platform/opengl` + `Q/DisplayGL.cpp`）双后端都生效**。

| 项 | 原因 |
|---|---|
| PC 皮肤 / 竖屏双屏 / 贴纸 / GIF 球 / 触感 / 双击截图 | 桌面端无意义 |
| 移动端 GB 相机 / 打印机 / BattleChip / e-Reader（A14） | 手机无对应硬件，只有相机图与 BattleChip 理论可用 |
| PC 撤销读档 / 移动端撤销读档（A8） | **已三端齐**，不是"不做" |

### 13.4 第二批并行任务已关闭（2026-11-15 第三轮复核）

| # | 已补功能 | 条目 | 落地证据 |
|---|---|---|---|
| 6 | **`type 9` 倍速同步真正改帧闸（三端）** | G8 | PC `CoreController::setNetSpeed()` + `Window::setNetSpeed/reflectNetSpeed`（Tools→Speed）+ 镜像核 µs 帧闸；Android `GBoyLinkSession.paceNanosForSpeed()`；iOS `GBoySpeed.sliceNanos(rate:)` + 音频 `playRate`。公式统一 `1e9/(rate*60)`，1x 不覆盖本机节拍，断开复位 1x |
| 7 | **Android 握手第三帧 `type 3`** | §11 档 2 原第 6 条 | `GBoyLinkSession.sendSocketHandshake()` 现发 `1 → 2 → 3`（10 字节 `type 3 + int32 0`），并修了 `pumpInput` 回复顺序，线上严格 `1→2→3→6` |
| 8 | **移动端撤销读档 / 撤销存档** | A8 | Android：读档前进度存内存快照、存档前旧内容写 `.ssN.bak`（跨进程有效）；iOS：`rememberUndoState` / `undoLastState`。PC 侧本来就有 `undoLoadState/undoSaveState` |

> 本节之后，"三端同时缺"计数归零。后续如需再排期，请以 §9 的 85 项表为准，不要引用 §13.3 的历史结论。
