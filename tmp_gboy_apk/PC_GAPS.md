# PC（Qt）端功能缺口清单 · 完整版

> 更新：2026-11-15（批次 2 后）｜ 基准：`FEATURE_MATRIX.md` 85 项 + 逐符号复核
> 优先级：**P1 用户高频** > **P2 联机相关** > **P3 进阶/调试**
> 状态：`✅ 已做` / `⏳ 待做（已排批次）` / `N/A 平台不适用（附四栏替代方案，见 §4）`
> 红线：联机号表/握手/type 6 不复位/倍速公式一律不动。

## 0. FEATURE_MATRIX 的 6 处 PC 假阴性（按移动端键名搜出来的误判，保留作证据）

| 矩阵条目 | 矩阵判定 | 实测 | 证据 |
|---|---|---|---|
| A5 存档缩略图 | ❌ | **✅** | `LoadSaveState.cpp · loadState()` 读 `EXTDATA_SCREENSHOT` 后 `setIcon()` |
| A7/M10 自动存档+自动读档 | ❌ | **✅** | `autosave` / `autoload`（`CoreController.cpp:327-328`、`SettingsView.ui` 两个勾选框）；`thread.c` 首次 reset → `resetCallback` 读 slot 0，`cleanCallback` 退出写 slot 0 |
| F10 存档跟 ROM 走 | ◐ | **✅** | `savegameSameDir` + `mDirectorySetMapOptions` 默认写 ROM 目录 |
| F1 截图目录 | 只 PNG | **目录 ✅** | `screenshotPath` / `screenshotSameDir` 已存在，真缺口仅格式 |
| H10 调试素材导出 | ❌ | **✅（精灵）** | `ObjView::exportObj()` 存 PNG、`copyObj()` 进剪贴板；`PaletteView::exportPalette()` 存 .pal/.act（PNG 本轮补） |
| E9 触感振动 | ❌ | **✅（等价）** | 卡带震动 → `mPERIPH_RUMBLE` → `SDLInputDriver::rumble()`（手柄马达） |

## 1. 完整缺口表

| # | 功能 | 优 | PC 现状 | 参照 | 状态 |
|---|---|---|---|---|---|
| 1 | 启动自动开上次 ROM | P1 | 只有 MRU 菜单 | A `lastRom` / I `RomLibrary.lastRom` | ✅ 批次0 |
| 2 | 截图格式 PNG/JPEG | P1 | 写死 PNG | A/I `shot_format` | ✅ 批次0 |
| 3 | 连发可见+持久+速率 | P1 | 只有 hidden 按住动作 | A `turbo`/`turbo_rate` | ✅ 批次0 |
| 4 | 每游戏倍速记忆 | P1 | 只有全局倍速 | A `per_rom_speed` | ✅ 批次0 |
| 5 | 联机直连传输 UI（蓝牙/TCP） | P2 | 只有 env 变量 | A `GBoyBluetoothLink` 联机页 | ✅ 批次0 |
| 6 | 自定义倍速 0.25x–16x + 任意值 | P1 | 菜单只 2x–10x（设置里可填但入口深） | A 0.1–16 / I 0.25–16 | ✅ 批次1 |
| 7 | 低延迟音频 | P1 | 只能手调 audioBuffers | A/I `low_latency` | ✅ 批次1 |
| 8 | 双击画面截图 | P1 | 只有 F12 | A `double_click_shot` / I 同名 | ✅ 批次1 |
| 9 | 调色板导出 PNG | P3 | 只有 .pal/.act | A/I 导出到相册 | ✅ 批次2 |
| 10 | 本地双人“同屏”等价：窗口并排 | P2 | 多窗口但需手动摆 | A `ScreenSplit` | ✅ 批次2 |
| 11 | 宏按键（C=A+B / C2=L+R） | P1 | 无 | A `c_macro`/`c2_macro` | ✅ 批次2 |
| 12 | **内置滤镜套件（10 种）** | P1 | 只有外部 shader | A `Shaders.java` 12 种 | ✅ 批次3 |
| 13 | **亮度 / 对比度 / 扫描线** | P1 | 无 | A `vf_bright/vf_contrast/vf_scan` | ✅ 批次3（与 12 共用通道） |
| 14 | 每游戏滤镜记忆 | P2 | 无 | A `RomSettingsDb` 滤镜列 | ✅ 批次4 |
| 15 | 贴纸/叠图（PNG overlay） | P3 | 无 | A `StickerOverlay` / I `StickerOverlayView` | ✅ 批次4 |
| 16 | GIF 悬浮球 | P3 | 只有菜单录制 | A `GifBall` / I `GifBall` | ✅ 批次4（受 `USE_FFMPEG` 构建开关约束） |
| 17 | AI 截图翻译浮层 | P3 | 无 | A `AiTranslate`+`AiOverlayView` / I 同名 | ✅ 批次5 |
| 18 | 存档槽缩略图 | — | 已有 | — | ✅ 误判 |
| 19 | 自动存档/读档 | — | 已有 | — | ✅ 误判 |
| 20 | 调试素材导出 | — | 已有（精灵 PNG；调色板 PNG 见 #9） | — | ✅ 误判 |
| 21 | 触感振动 | — | 已有（手柄 rumble） | — | ✅ 等价 |
| 22 | 虚拟按键布局编辑 | — | 无触摸 | A/I `ControlsView`+`layout_profiles` | N/A → §4.1 |
| 23 | 皮肤主题 | — | 只有背景图 | A `SkinStore`/`SkinTheme` | N/A → §4.2 |
| 24 | 竖屏双屏（DS 式） | — | 无 | A `ScreenSplit` / I portrait | N/A → §4.3 |
| 25 | 屏幕方向/旋转 | — | 无 | A `orientation` | N/A → §4.4 |
| 26 | `type 10` 断线通知 | — | 靠 socket EOF | I `typeDisconnect` | N/A → §4.5（协议红线） |

## 2. 批次 1 / 批次 2 的实现口径

### 批次 1（3 项）
1. **自定义倍速**：Emulation → Fast forward speed 增加 `0.25x / 0.5x / 1.5x` 与 `2x…16x`，末尾 `Custom...`（QInputDialog，0.01–20）。生效：写 `fastForwardRatio` → `CoreController::loadConfig` → `updateFastForward()`；持久化：`fastForwardRatio`（qt.ini）。
2. **低延迟音频**：Audio/Video → `Low latency audio`。生效：`AudioProcessor::configure()` 在勾选时把缓冲压到 ≤512 帧（`LOW_LATENCY_BUFFERS`），勾选变化即时 `reloadAudioDriver()` 重建后端；持久化：`lowLatency`。
3. **双击截图**：Audio/Video → `Double-click screen to screenshot`（默认关）。生效：`Window::eventFilter()` 监听画面控件（含 DisplayGL 子控件）的 `MouseButtonDblClick` → `takeScreenshot()`；持久化：`doubleClickScreenshot`。

### 批次 2（3 项）
4. **调色板导出 PNG**：PaletteView 右键菜单 → `Export as PNG...`，整幅 `grab()` 存 PNG（BG/OBJ 两栏 + 选中色一起）。
5. **窗口并排**：File → `Tile windows side by side`，把本进程所有窗口按屏幕宽度均分横排（本地双人的桌面等价交互，替代移动端同屏分屏）。
6. **宏按键**：Emulation → `Macro C (A+B, held)` / `Macro C2 (L+R, held)`，`CoreController::setMacroKeys()` 直接并入本帧按键掩码；可在 设置→Keyboard/Controllers 绑定快捷键或手柄键（与移动端 C/C2 虚拟键等价）。

### 批次 3（3 项，★本轮重点）
7. **内置滤镜套件（10 种）**：Audio/Video → `Filters` → None / GBA color / Grayscale / HQ2x / HQ4x / 2xBR / 4xBR / Dot matrix / LCD3x / Scanlines / Quilez。
   - **OpenGL 后端**：`Filters::buildShaderDir()` 把公式写成 mGBA `.shader` 目录（`manifest.ini` + `shader.fs`，与 `ExternalShader::convert()` 同一套 contract），目录 `configDir/filters/<id>_<b>_<c>_<s>/`，再 `Display::setShaders()`；切换 None 时 `clearShaders()` 并自动恢复用户自己的外部 shader。
   - **软件后端**：`Filters::applyCpu()` 用同一套公式在**输出分辨率**上采样（`DisplayQt::paintEvent` 前处理），两侧观感一致；实现覆盖 10 种全部。
   - `MOTION_BLUR` 不单列：Android 依赖 7 帧历史纹理，mGBA 着色器链无 history，PC 用已有 `Interframe blending` 等价。
   - 持久化：`filter` 键。
8. **亮度**：Audio/Video → Filters → `Brightness`（70/85/100/115/130/150%），持久化 `filterBrightness`；无滤镜时也会生成 passthrough shader 生效。
9. **对比度 + 扫描线**：`Contrast`（70–150%）与 `Scanline strength`（0/25/50/75/100%），持久化 `filterContrast` / `filterScanlines`；两条后端同公式。

## 3. 批次 4+ 的实现路径（已定，不再评估）

### 批次 5（2 项）
13. **AI 截图翻译浮层**：Tools → `AI 翻译` → `翻译当前画面…` / `设置 API Key…` / `目标语言…` / `清除译文浮层`。
    - 取 `CoreController::getPixels()` 当前帧，长边压到 720 后 PNG → base64，按 Android `AiTranslate.java` 的同一提示词与 Gemini `generateContent` 接口发送（Qt Network，无新依赖）；
    - 返回 `[{x,y,w,h,t}]` 归一化文本块，画成 `AiOverlay`（半透明黑底 + 白字，鼠标穿透），失败/无 Key 时浮层显示错误文案；
    - 持久化：`aiKey`、`aiLang`（qt.ini）。
14. **`src/platform/mobile/` 4 个 C 接口**（阻塞 iOS/Android）：`mgbaMobileListVideoLayers` / `mgbaMobileSetVideoLayer` / `mgbaMobileRewindFrames` / `mgbaMobileSetMemoryWatch`，实现与测试见交付记录（`mobile_test.c · testCoreSurface`）。

### 批次 4（3 项）
10. **每游戏滤镜记忆**：Audio/Video → Filters → `Remember filter for this game`。进场读 `perRomFilter/<rom 基名>`（格式 `id,bright,contrast,scan`），改任一滤镜项即写回；持久化 `perRomFilter*`。
11. **贴纸叠图**：Audio/Video → `Sticker` → `Load sticker image...` / `Clear sticker` / `Size`（15/25/35/50% 画面高）。实现为画面控件的透明 `QLabel` 子控件，右下角对齐，路径与尺寸持久化（qt.ini `stickerPath` + `stickerScale`），换游戏/重挂画面自动重贴。
12. **GIF 悬浮球**：Audio/Video → `GIF floating button`。无边框置顶小按钮，点一下开始/停止录制；输出 `<截图目录或 ROM 目录>/<rom 基名>-<yyyyMMdd-hhmmss>.gif`；`GIFView::setOutputPath()` 新增以跳过文件对话框。**注意**：本仓库 `build-win` 的 `USE_FFMPEG=OFF`，该项在此构建里为空实现（菜单也不出现）；开启 FFmpeg 构建后即可用。

- **滤镜 10 种**：已完成（批次 3）。
- **每游戏滤镜**：与 `perRomSpeed` 同结构，键 `perRomFilter/<rom 基名>`。
- **贴纸**：`Audio/Video → Sticker...` 载入 PNG，`WindowBackground` 之上叠一个可拖拽/缩放的透明层，位置/缩放写 qt.ini。
- **GIF 悬浮球**：无边框置顶 `QToolButton`，点一下开始/停止 `GIFView` 录制，位置持久化（等价移动端 GifBall）。
- **AI 翻译**：`Tools → AI 翻译截图…`，复用移动端 `AiTranslate` 的接口（`ai_key`/`ai_lang` 配置），结果用半透明浮层显示，不引入新依赖（Qt Network 已在用）。

## 4. 平台限制项的替代方案（四栏）

### 4.1 虚拟按键布局编辑（A/I `ControlsView`）
1. **原生能力**：桌面无触摸屏输入概念；等价物是 Qt 的 `QKeySequence`/`QGamepad`。查证：`src/platform/qt/SettingsView.ui` 已有 Keyboard / Controllers 两页，`ShortcutController` 存自定义绑定。
2. **替代方案**：①（已存在）键盘逐键重映射 + 手柄逐键重映射 + 配置文件；② 新增「布局配置档」只适用于手柄（多套映射切换）。
3. **取舍**：触摸布局在桌面无输入源，重映射已覆盖 100% 的按键可达性，新增虚拟按键只会占画面。
4. **可验收效果**：用户可在 设置→Keyboard 把任意 GBA 键绑到任意键/手柄键，并能保存多套配置——与移动端“换布局”目的相同。

### 4.2 皮肤主题（A `SkinStore`/`SkinTheme`）
1. **原生能力**：Qt `QWidget` 自绘 + QSS；已有 `SettingsView.ui · backgroundImage`（封面背景图）。
2. **替代方案**：①（已存在）自定义背景图 + 整数缩放/无边框全屏；② 后续可加“边框颜色/圆角”QSS 预设（工作量 ~60 行，无新依赖）。
3. **取舍**：手机皮肤的核心诉求是“外壳配色 + 背景”，桌面已有背景图，边框配色收益低。
4. **可验收效果**：设置→Interface 选一张背景图后，窗口背景即换成该图（已有）；如需配色，走 §4.2②。

### 4.3 竖屏双屏（A/I `ScreenSplit`）
1. **原生能力**：Qt 多窗口 + `QScreen::availableGeometry()`（本轮已用于 `Tile windows side by side`）。
2. **替代方案**：①（已做）多窗口横向并排铺满屏幕；② 竖屏显示器下改为上下并排（同一函数按 `height > width` 切换）。
3. **取舍**：桌面屏幕足够大，并排即达到“上看画面下按键/双人同屏”的目的，且不牺牲分辨率。
4. **可验收效果**：File→New multiplayer window 再点 Tile windows，两块画面各占半屏，可同时操作（本地 2P）。

### 4.4 屏幕方向/旋转（A `orientation`）
1. **原生能力**：Windows 无应用级旋转 API 需求；画面旋转可用 `QPainter::rotate` 或 `Display::setRotation`。
2. **替代方案**：① 显示器/系统旋转（OS 级）；② 后续可加“画面旋转 90/180/270”配置（~40 行）。
3. **取舍**：桌面设备形态固定，旋转属于小众；系统级旋转已覆盖平板/竖屏显示器。
4. **可验收效果**：需要竖屏时在系统显示设置旋转即可，模拟器画面跟随窗口不变形。

### 4.5 `type 10` 断线通知（仅 iOS 有）
1. **原生能力**：无需新 API；`GBoyFrames` 只需加常量与分支。
2. **替代方案**：①（现状）socket EOF + 心跳超时判死，UI 立即提示断线；② 若要严格对齐，三端同时加 `type 10`（iOS 已有）并约定“收到即收尾”。
3. **取舍**：红线要求本轮冻结联机线格式，方案②需三端同步改协议，不在本批。
4. **可验收效果**：断线时 PC 在 1 个心跳周期内提示“连接已断开”并停止转发（现状行为），不会卡死。

## 5. 验证记录

| 批次 | 构建 | 回归 |
|---|---|---|
| 批次 0（5 项） | `mgba-qt` 全绿 | buslocal PASS / frames PASS；ROM 冒烟 10s 无崩溃 |
| 批次 1（3 项） | `mgba-qt` 全绿（[8/8] Linking） | buslocal PASS / frames PASS |
| 批次 2（3 项） | `mgba-qt` 全绿（[58/58] Linking） | buslocal PASS / frames PASS |
| 批次 3（滤镜+亮度/对比度/扫描线） | `mgba-qt` 全绿（[8/8] Linking） | buslocal PASS / frames PASS；`-C filter=3` 运行 10s 无 stderr，着色器目录 `configDir/filters/3_100_100_0/{manifest.ini,shader.fs}` 正常生成 |
| 批次 4（每游戏滤镜/贴纸/GIF 球） | `mgba-qt` 全绿（[8/8] Linking） | buslocal PASS / frames PASS；`-C filter=5 -C filterScanlines=50` 运行 10s 无 stderr |
| 批次 5（AI 翻译 + mobile C 接口） | `mgba-qt` 全绿（[4/4] Linking）；`build-mtest` 的 `mgba_mobile_test` 全绿 | buslocal PASS / frames PASS；`mgba_mobile_test`：video layer list / frame counter stepped back one / memory watch fired 三条新断言 PASS |
| 产物 | `build-win/dist/mGBA.exe` + `libmgba.dll` 每批覆盖 | — |

> `test-gboylink` 不带参数在源码里只打印 usage（`return 2`），不是用例；验收用 `buslocal` + `frames`。
