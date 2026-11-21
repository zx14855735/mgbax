# ADR-002 · 2P path A 默认化前的能力协商隔离

- 状态：**Accepted**（主理人 2026-11-15 13:xx 已拍板「type 6 并存 + 能力协商隔离，不做全量回退」）
- 决策者：team-lead（游承峰）；实施：engineering-lead（程基岩），T-03
- 日期：2026-11-15
- 相关：
  - `MEMORY.md`「2026-11-15 12:4x 接手勘误」（最优先，覆盖所有旧结论）
  - `2026-11-15.md` §T-01b 更正 1/2/3、§13:xx 决策
  - `GBoy联机实现拆解与移植方案.md` §7.2:272（两人直连一字未动）、§7.3:286-290（借壳 type 6）
  - `tmp_gboy_apk/NETPLAY_SPEC.md:69,84,90`（官方 case 6 = 整份 savestate → `loadStateFromMemory`）
  - `production/sprint-2p/T-03-busgame-root-cause.md`

---

## 1. 上下文（Context）

三端存在**两套互不复用的联机架构，且默认不一致**：

| | path A | path B |
|---|---|---|
| 核心 | 每端 1 核，SIO 包中继（P2P 直连优先） | 本机 4 核（可见核 + 3 镜像核），网络只传按键 |
| type 6 载荷 | **借壳**：裸 20 字节 netLink 包，无长度头 | 官方 `u32 len + 整份 savestate` → `console.loadStateFromMemory` 逐槽灌镜像核 |
| 代表代码 | PC `CloudLink.cpp:1713-1790 startSioRelayBridge`、`sio_link.c:940-1003 sioFastFrame`；Android `GBoyCloudLink.java:1469-1546` | PC `startOfficialMatch/serveOfficial`、`GBoyMirror`；Android `GBoyConsoleSet` / `GBoyLinkSession` |
| iOS | **完全没有** | 有（`GBoyConsoleSet.swift`） |
| 默认（改动前） | PC `CloudLink.cpp:611`：`MGBAX_OFFICIAL_LINK` 未设 ⇒ A | Android `EmulatorActivity.java:5525-5526`：`gboy_official_link=true` ⇒ B |

- **事故**：`CloudLink.cpp:608-610` 记过两套帧格式同流（PC 发裸 MBL1 / SIO 包、Android 发 GBoy 帧），
  **9470 个碎片包耗死读线程**。`flow.sh:101` 靠 `MGBAX_OFFICIAL_LINK=1` 强对齐，只是测试脚手架。
- **不推翻的架构前提**：
  1. 2P 首选 **path A**，代码完整仍在（`§7.2:272` 两人直连一字未动）。
  2. **type 6 并存 + 能力协商隔离，不做全量回退**。官方 `case 6` 以 11-14 脱壳字节码为准 =
     整份 savestate → `loadStateFromMemory`；三端当前实现与官方一致，**不是误做**。全量改回
     SIO 包中继会失去官方 case 6 互通并要改三端全部落地点。
  3. 「必须维持 4 核/设备」已撤回：那是 **path B 实现路线**的约束，不是 ROM 约束
     （11-08 有 2P 每端 1 核 `LINKUP cnt=2 → cb2 落 battle_main.o` 实跑）。
  4. 默认假设：**2P 仅 PC↔Android 可用，iOS 只支持 path B**。
- **静态缺陷（上一轮已修，本轮保留）**：PC `CloudLink.cpp:2378 maybeSendInitialState()` 的
  `if (!m_officialMode) return false;` 门控住 path A 的 `:1723` / `:2319` 两处调用，避免整份
  savestate 混进 SIO 20 字节字节管道。

问题陈述：**在把 path A 设为 2P 默认之前，必须有一种机制保证「一条隧道上只跑一种帧格式」，
且两端不一致时不能被悄悄降级到任意一种。**

---

## 2. 决策（Decision）

### D1 · 在 type-1 握手帧加 1 bit `mode`，两端取协商结果

官方 type-1 注册帧恒 **16 字节**（`B25kr6.ARc23Z(1, 10)` 分配 16 字节、发送线程写整个 backing
array），多人房尾部 6 字节官方恒为 0。能力位放在 **wire[15] == 12 字节 body 的 index 11**：

```
官方 16B: [u32 len=12][u16 type=1][u32 playerCount][u16 0][u32 baseStateCount]
                                                                  ^^^^^^^^^^^^
wire[15] = body[11] = LINK_CAP_MAGIC(0x40, bit6) | mode(bit0)
  0x00            = 未声明（官方 APK / 旧客户端）
  0x40            = A（每端 1 核 + SIO 包中继）
  0x41            = B（本机多核 + 网络只传按键）
  bit6=0 或保留位非 0 = INVALID（畸形，按不一致处理）
```

- **mode 本身只占 1 bit**；magic 用于区分「显式 A(0x40)」与「未声明(0x00)」。
- 只在 `playerCount != 1` 时写；单人房尾部承载 `baseStateCount`，不能占用。
- 保留 2 参数 `registerFrame()` → 输出与官方逐字节一致，**不破坏官方 case 6 互通**。
- 帧长、长度字段、其余字段**一律不改**，旧端读到非零只会当保留字段忽略。

### D2 · WSS hello/accept 标记作为冗余主协商通道

中继是否转发对端的 type-1 注册帧**不确定**，而 WSS 信令的 `hello`/`accept` 两端必然互见。
故在已有 `"c":1` 能力协商位旁再加 `"m":0|1`（沿用短键名信封，长度影响可忽略）。
两端在 `type-1` 注册帧、`isTunnelMarkerText` / `pollSignaling` / `WsLink::demux`、
Android `isTunnelMarker()` / `WsLink.demux()` 四处解析对端模式，任一处先到都生效。

### D3 · 不一致直接 fail 并给可见提示，禁止静默降级

分派门 `negotiateLinkMode()` 在**任何游戏帧发出之前**执行：

| 对端状态 | 行为 |
|---|---|
| 已声明且与本机一致 | `status("联机模式协商通过：…")`，放行 |
| 已声明但与本机不同 | **`fail()`**：状态栏显示「【联机模式协商失败】本机=… 对端=…」，列改法；置 `m_closed` / `closed` 让工作线程退出，不发任何游戏帧 |
| 能力位畸形 | 同上，按不一致处理，**不猜测** |
| 未声明（官方 APK / 旧客户端） | **默认 fail**。仅 `MGBAX_LINK_ALLOW_LEGACY=1`（PC）/ ADB `allow_legacy=true`（Android）显式许可时回落 B，且状态栏明确打「警告…显式许可回落」，不是静默降级 |
| 尚未收到 | 有界等 2s 让 WSS hello 到达（期间只排空信令，数据通道还没跑），超时按「未声明」处理，绝不无限等 |

失败提示路径：
- PC：`CloudLink::fail()` → `status()` → `emit statusMessage` → `LobbyView::status()` 追加到大厅
  状态栏，并写 `%TEMP%/mgba_lobby_debug.log`。
- Android：`GBoyCloudLink.fail()` → `hooks.onStatus()` → `EmulatorActivity.onStatus()`
  （含「失败」字样，触发 toast + `linkStatusView`）。

### D4 · 默认模式按玩家数对齐 + 显式可达入口

| 入口 | PC | Android |
|---|---|---|
| 默认（AUTO） | 2P → **A**；3/4P → **B** | 同左 |
| 可视化 UI | `LobbyView.cpp` 新增大厅下拉框「联机模式：AUTO / A / B」，持久化到 `QSettings("mGBAx","cloud")` 的 `link_mode` | —— |
| 无人值守 / ADB | `MGBAX_LINK_MODE=A\|B\|AUTO`；`MGBAX_OFFICIAL_LINK=1` 兼容旧 `flow.sh`（等价 B）；`MGBAX_LINK_ALLOW_LEGACY=1` | `am broadcast -a io.mgba.android.action.GBOY_LINK_MODE --es mode A\|B\|AUTO [--ez allow_legacy true]`，持久化到 `gboy_link_mode` / `gboy_link_allow_legacy` |
| 旧私有开关 | —— | `gboy_official_link` 仅在 SharedPreferences 里**确实存在**时作为兼容覆盖；不再是无 UI、无广播的隐式默认 |

- 蓝牙 / WiFi 直连（`startBluetooth` / `startTcp`）仍显式 B（本机多核），不受 AUTO 影响。
- PC 大厅选 AUTO 时**不覆盖**环境变量显式值，保留 `flow.sh` 脚手架。

### D5 · 保持 `startSioRelayBridge` 纯 SIO 字节管道语义不改

PC `CloudLink.cpp:1713-1790` 的函数体本轮**一字未改**；
`maybeSendInitialState()` 的 `if (!m_officialMode) return false;` 门控保留。C0 只做「选哪条路」
和「能不能开跑」，不碰任何一条路内部的数据格式。

**Android 端有一处例外（Rev.2 补充，2026-11-15）**：`GBoyCloudLink.java` 的
`startSioRelayBridge` 在 sio-relay-in 读数据处改了 **1 行** —— `link.recv(200)` 改为
`recvLink(link, 200)`（约 `:1609`）。原因是 B1 的有界等待期会把非能力帧原序暂存进
`replayBytes`，若该入口仍直接 `recv()`，暂存的 type-6 SIO 包将没人取，等于确定性丢包。
改动**只换读数据入口，不碰字节管道语义、不碰数据格式**（`recvLink` 先投暂存队列再读链路，
保序）。同一批改动另有两个入口同步改走 `recvLink`：`serve()`（约 `:2307`）、
`startSioBridge` 的 sio-bridge-in（约 `:1513`）。

---

## 3. 分派点（改动位置）

| 平台 | 位置 | 改动 |
|---|---|---|
| PC | `CloudLink.cpp` 原 `:908-934`（KCP 中继分派） | 插入 `negotiateLinkMode(room, "KCP 中继")` 门 |
| PC | `CloudLink.cpp` 原 `:1448-1487`（`runTunnel` 分派） | 插入 `negotiateLinkMode(room, "WSS 隧道")` 门 |
| PC | `runManual` → `serve()` 前 | 插入手动中继门 |
| PC | `sendRegister()` / `handle()` / `sendWsMarker()` / `WsLink::sendMarker()` / `demux()` / `isTunnelMarkerText()` / `pollSignaling()` | 发/收能力位 |
| PC | `CloudLink.cpp` 构造器、`startLink()` | 解析环境变量、重置协商态 |
| PC | `LobbyView.cpp` | 大厅下拉框 + `setLinkMode` / `setAllowLegacyPeer` |
| Android | `GBoyCloudLink.java` 原 `:566`、`runTunnel` 原 `:1103` | 插入协商门 |
| Android | `GBoyCloudLink.java` `sendRegister()` / `handle()` / `sendWsMarker()` / `WsLink.demux()` / `isTunnelMarker()` | 发/收能力位 |
| Android | `EmulatorActivity.java` `ensureCloud()` | `gboyLinkModeOverride()` + `setLinkMode` + `setAllowLegacyPeer` |
| Android | `EmulatorActivity.java` | 新增 `GBOY_LINK_MODE` 广播接收器（含注册/注销） |
| 三端共用格式 | `GBoyFrames.h/.cpp`、`GBoyFrames.java` | `LinkMode` 枚举、`LINK_CAP_*`、3 参数 `registerFrame()`、`linkModeOf()` |

**文件归属红线遵守**：未改 `src/platform/mobile/mgba_mobile.c`、`GBoyConsoleSet.{java,swift}`、
`ios/**`、`android/app/build.gradle`、`android/app/src/test/**`、
`src/platform/qt/test/gboylink_test.cpp`。

---

## 4. 备选方案（Alternatives）

| 方案 | 为什么不选 |
|---|---|
| **A1 · 全量统一成 path B**（PC 也默认 4 核） | 与已拍板的「2P 首选 path A」冲突；path B 每端 4 核 CPU（20~31fps）、需 NPC 柜台对话 + 就位导航、跨公网锁步每轮 1 RTT 物理不可行；且 2 核本机环回已证伪。 |
| **A2 · 全量回退成 SIO 包中继**（取消官方 case 6） | 与 11-14 脱壳字节码相反证据冲突：三端 `case 6 → loadStateFromMemory` **与官方一致**，改回去会失去官方互通，并要改三端全部落地点。已明确「不做全量回退」。 |
| **A3 · 只靠环境变量 / 私有 pref 对齐**（沿用 `flow.sh`） | 现状正是事故根因：PC 默认 A、Android 默认 B，且 `gboy_official_link` 全仓只有 private pref 无 UI/广播入口。产品形态不可接受。 |
| **A4 · 运行时按首帧内容自动探测对端格式** | 这正是 9470 个碎片包耗死读线程的模式：**先污染、后判断**，无法保证帧边界不被破坏；且静默降级违背「禁止静默降级」。 |
| **A5 · 新增独立 type 号做能力协商** | 官方 0..9 已占满、自家扩展从 11 起；新增号要三端同步且旧端不认。复用 type-1 保留字节 + 已有 WSS `"c":1` 协商通道成本最低、向后兼容最好。 |
| **A6 · 不一致时挑选「能跑的」一侧静默降级** | 明确禁止：用户无法预期哪条路生效，且会重新引入两套帧格式同流风险。 |

---

## 5. 后果（Consequences）

### 正面
- 一条隧道上只可能出现一种帧格式，消除 9470 碎片包事故的前提条件。
- path A 可以安全地成为 2P 默认，且 3/4P 自动回 B，无需用户手动改环境变量。
- 官方 `case 6` 互通不受影响（2 参数 `registerFrame` 字节不变、两端都是新端时只多一个保留字节）。
- 失败**可见且可操作**：状态栏/toast 直接给出两端模式和改法，不再靠读日志猜。

### 负面 / 代价
1. **默认拒绝旧客户端与官方 APK 互通**：对端未声明能力位时默认 fail。必须两端显式
   `MGBAX_LINK_ALLOW_LEGACY=1` / `allow_legacy=true` 才按 B 回落，且该路径未经 2P 云端验收。
   这是「禁止静默降级」的直接代价，需产品侧明确告知。
2. **协商增加最多 2s 有界等待**（WSS hello 与 KCP 握手不同步时），首连延迟略增。
3. **两端必须同时升级**：混跑新旧 build 时新端会因「对端未声明」而断链。
4. **WSS 标记多 1 个键**（`"m"`）：单条 ≤100 字符限制仍在，`hello`/`accept` 长信封原本就较短；
   需在真机 AVD 上确认没有被服务器拒收（本轮未做真机验证）。
5. **AUTO 依赖房间 `playerCount`**：房间服务器 `player_joined` 上报的人数若不准，会选错模式；
   两端同时取同一房间人数，且不一致会被协商门挡住，最坏情况是 fail 而非同流。
6. **iOS 无 path A**：iOS 端没有本 ADR 的协商实现（红线禁止改 `ios/**`）；iOS 只能走 path B，
   与 2P 默认 A 的 PC/Android 房间**必然协商失败**。这是已知且未解决的覆盖缺口，见 §6。

---

## 6. 已知风险与缓解（含 path A 成为默认前的硬前置）

| # | 风险 | 证据 | 缓解 / 状态 |
|---|---|---|---|
| R1 | **PC 进战斗后 `C0000005` 崩溃** | `2026-11-08.md:934-937`：11-08 的 2P path A 实跑，进战斗后 50~200s 崩于 `cb=081520D1`；**未找到已修证据** | **硬前置 P1-5**：path A 成为 2P 默认之前必须复现并定位。当前 AUTO 虽把 2P 指向 A，但该路径在生产上未验收；建议交付门保持 CONCERNS，不宣称 2P 云端可用。 |
| R2 | **`sioFastFrame` 仅 PC/Qt 有，Android native 无等价实现** | `sio_link.c:940-1003`；实测 Android path A 仅 **4.6~4.9fps**；其 `:984-989` 三条件（`sioOk≥256` + `gLink.state/playerCount/fieldCount` 同时 ≥2）不能放宽 | **硬前置 P1-4**：移植前 Android 侧 path A 不可用。缓解：ADB/UI 显式把 Android 设为 B（`--es mode B`），或保持 3/4P→B；不要放宽三条件 hack。 |
| R3 | **iOS 完全没有 path A** | `ios/mGBA/*.swift` grep 零命中、`§7.5:344` ❌ | 默认假设「iOS 只支持 path B」；iOS 与 2P 默认 A 房间会协商失败（**可见提示，不是静默**）。范围决策 P0-11 未做；需 macOS + Xcode 真机验证。 |
| R4 | **两套帧格式同流**（历史事故） | `CloudLink.cpp:608-610`，9470 碎片包耗死读线程 | 本 ADR 的协商门 + `maybeSendInitialState` 的 `!m_officialMode` 门控；`startSioRelayBridge` 语义保持原样（Android 仅换读数据入口为 `recvLink`，见 §D5）。 |
| R5 | **官方 APK / 旧客户端互通被默认拒绝** | 官方 `case 6` 是整份 savestate；旧端不带能力位 | 显式 `allow_legacy` 开关；状态栏明确警告。需在真机验证「显式许可后是否真能互通」，**本轮未验证**。 |
| R6 | **WSS 单条 ≤100 字符** | 记忆 `2026-11-15.md:117` | `"m"` 只加 1 个短键；长信封风险由已有 `"c":1` 短键名信封机制覆盖。AVD 真机验证待做。 |
| R7 | **判据地址窗口过期导致 `BATTLE=NO` 假阴性** | `production/sprint-2p/T-03-busgame-root-cause.md`；`/d/gen8/rom.gba` 被并发会话重建，13:51 构建 `BattleMainCB2+1=0x080B3169` 落在硬编码 `battle_main.o` 窗口外 | **已修复（T-03 补做，主理人裁决：判据段改派 engineering-lead）**：`gboylink_test.cpp` 三处硬编码区间改为按 ROM 身份动态解析 —— 从 `.map` 读 `battle_main.o .text` 与 `BattleMainCB2` 推导相对几何（符号偏移 / 段长），再用当前 ROM 段首 12 字节序言校验候选窗口；找不到 `.map` 报 `STALE_BATTLE_WINDOW` 并退出码 2，绝不静默退回旧常量。结果文件带 ROM md5/mtime/窗口来源/`cb2rel` 相对序列。旧 ROM 腿与新 ROM 腿双向验证见 §7 与根因文档 §7。 |
| R8 | **并发会话继续重建 ROM** | `/d/gen8` 的 AI-perf 会话仍在改 `src/battle_ai_master.c`；13:38 / 13:51 / 14:30 多次重建 | **已缓解**：`tools/busgame-lockstep.sh` 每次把 ROM 与 `rom.map` 一起快照到独立工作目录（校验 32 MiB 大小 + 记录 md5/mtime），存档也从只读母本现拷；不再直接读 `D:/gen8/rom.gba`。 |
| R9 | **本轮未做真机 / 云端 E2E** | 本轮验证只到 `ninja` / `javac` / 本地 C/Qt 回归 | 交付门前需补：双账号双 uuid 房间、两端模式不一致的可见 fail、一致时进对战 logcat + 双端截图。 |

---

## 7. 验证证据（本轮实跑）

| 命令 | 退出码 | 输出要点 |
|---|---|---|
| `export PATH="/c/msys64/mingw64/bin:$PATH"` 后 `ninja -C build-win test-gboylink` | **0** | `[9/9] Linking CXX executable qt\test-gboylink.exe` |
| `ninja -C build-win mgba-qt` | **0** | 编译 `CloudLink.cpp.obj` / `GBoyFrames.cpp.obj` / `LobbyView.cpp.obj`，`[10/10] Linking CXX executable mGBA.exe`；仅既有 unused 参数 warning，无 error |
| `test-gboylink frames` | **0** | FRAMES / KCP FRAME / RECONNECT / TCPDIRECT 均 PASS |
| `test-gboylink buslocal` | **0** | BUSLOCAL PASS + SESSIONSLOT PASS |
| `test-gboylink product-lockstep` | **0** | `PASS (4 cores, product SIO lockstep)` |
| `javac -encoding UTF-8`（`GBoyFrames.java` / `GBoyLinkSession.java` / `GBoyCloudLink.java` / `EmulatorActivity.java`，classpath = android.jar + 预编译 Gradle classes + R.jar + 133 个 Gradle 缓存 jar + 31 个 AAR 的 classes.jar） | **0** | 仅 deprecation note，无 error；未跑 `gradlew` / `gradle build` |
| **R7 旧 ROM 腿**：`busgame-lockstep tmp_bus/rom.gba dyn_old.sav 4` | **0** | `BATTLE=YES / lastCb2=0809AFCD / battleSamples=3824`；动态窗口 `[08099848,080A30FC)` 来源 `D:/gen8/syms.txt (BattleMainCB2-offset)`；`LS rom md5=8876036e…`；`cb2rel delta=-695324 relOK=YES` |
| **R7 新 ROM 腿**：`bash tools/busgame-lockstep.sh`（ROM+map 快照副本，md5 `074cfcdb…`） | **0** | `BATTLE=YES / lastCb2=080B3169 / battleSamples=4028`；动态窗口 `[080B19E4,080BB298)` 来源快照 `rom.map (.text)`；`LS rom md5=074cfcdb…`；`cb2rel delta=-695324 relOK=YES`。**修复前同一 `lastCb2` 被判 `BATTLE=NO`** |
| **R7 `.map` 缺失场景**：`BUSGAME_BATTLE_MAP=<不存在>` | **2** | `STALE_BATTLE_WINDOW: 显式 BUSGAME_BATTLE_MAP 不存在或不可解析`，`ls_result.txt` 记 `LS: FAIL BATTLE=NO (STALE_BATTLE_WINDOW)` + ROM md5/mtime；启动 4 核前立即退出，不静默降级 |

- 测试前按纪律 `cp -f build-win/libmgba.dll build-win/qt/libmgba.dll`。
- 输出留档 `.zcode-tmp/t03-ab/test-{frames,buslocal,product-lockstep}.out`、
  `.zcode-tmp/t03-javac/final2-javac.out`；判据补做双腿与 `.map` 缺失场景留档
  `.zcode-tmp/t03-ab/dyn-old-ls_result.txt`、`dyn-new-ls_result.txt`、
  `stale/stale-ls_result.txt` / `stale/stale-run.out`，完整原文见根因文档 §7。
- T-04 已实跑关闭「6 个自检未挂 Gradle」：任务 `:app:runLinkSelfTests`，
  `./gradlew :app:runLinkSelfTests --offline --console=plain` → BUILD SUCCESSFUL / EXIT=0 / 6/6 PASS。
- **门控口径（主理人裁决，汇编采用覆盖更全、更严格的口径）**：`test-gboylink` 五条命令
  EXIT=0，但 T-04 用 18 次采样实测 `mgba_mobile_test` 有 1 次 `mobile tests failed` EXIT=1
  （低频 flaky 未隔离），合并后 **C/Qt 本地回归门 = CONCERNS**；**2P 云端交付门 = FAIL**，
  两门分列，禁止用汇总 ok 数代替分路径结论。发布清单由 T-06 同步，本文不改 `production/release/**`。
- **未验证**：双端云端 E2E、AVD 真机、iOS；本 ADR 不跑 `gradlew` / Gradle 构建（工具隔离）。

---

## 8. 未决事项 / 下一步

1. ~~T-04：修 `gboylink_test.cpp` 的 `battle_main.o` 硬编码窗口（ADR §6 R7）~~ → **已由 T-03 补做完成**（主理人裁决改派；T-04 红线禁改 C++/Qt，两边都不能动会悬空）。双腿验证见 §7。
2. P1-5：复现并定位 `C0000005`（R1）；P1-4：`sioFastFrame` 移植 Android native（R2）。
3. P0-11：iOS 范围决策 —— 要么补 path A，要么产品上明确「iOS 只支持 3/4P path B」（R3）。
4. 真机双端验证 D3 的可见 fail 与 D4 的 AUTO 对齐（R9）。
5. 评估「官方 APK 互通」是否需要把 `allow_legacy` 做成产品 UI 开关，而不只是 ADB（R5）。
