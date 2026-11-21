# 2P 联机 · 变更日志（CHANGELOG）

> **编排说明**：项目尚未对「2P 联机」打版本标签，**本文档不编造版本号**；以「变更批次日期 + 提交哈希 + 实际提交时间」作为唯一标识。已落地批次的提交时间取自 `git log --format="%h | %ad | %s" --date=format:"%Y-%m-%d %H:%M"`（只读核查）。**续作批次（T-03 / T-04）与二次续作批次（T-03 / T-05 / T-06 文档收口）的源码改动在本任务核查时仍在并发工作区、尚未提交，无提交哈希可引用——如实标注，不臆造哈希。**
> **范围**：本日志记录「已修并落地的缺陷」「本轮口径更正 / 已裁定产品口径」「本轮新发现缺陷（修复中）」「**已知限制（未解除 / 交付范围边界）**」，并把未闭环项集中到「已知问题」段落。**不要把诊断脚本跑完、本地回归全绿、某一条腿的 `BATTLE=YES`、或「口径已裁定」写成「2P 云端已闭环 / 功能已交付」；也不要把「已知限制」写成「已修复」。**
> **证据纪律**：所有结论以落盘日志 / 断言输出为准；`MEMORY.md` 顶部勘误优先级高于旧条目。**Rev.2 / Rev.3 续作证据由主理人中转 T-03 / T-04 / T-05 结论，本任务未自行复跑、未改任何代码、未提交。**
> **本轮动作性质**：Rev.1–Rev.3 为纯文档整理 / 只读核查，未修改任何代码、配置、构建脚本、测试文件、根目录教程，未执行任何 git commit / push / tag / 删除操作；**Rev.4 仅修改本目录两份发布文档并按主理人明确指令做一次本地 `git commit`（不 push、不 tag、不删除、不 --force）**。
> **修订记录**：Rev.1 2026-11-15 初版（批次 13:31–14:10，条目 ①–④ + 口径更正 1–5）；Rev.2 2026-11-15 续作（条目 ⑤⑥、口径更正 6、新发现缺陷段、验证汇总与已知问题全面改判）；Rev.3 2026-11-15 二次续作（条目 ⑦⑧、口径更正 7–9、产品口径已裁定段、教程改写合并记录、flaky 采样 18 次、符号级证据、双门判定维持）；**Rev.4 2026-11-15 B6（新增 `### 已知限制（未解除）` 独立条目：iOS 无 path A 与 2P 房间硬拒绝 / AUTO 对 iOS 不友好 / `allow_legacy` 不建议用于交付 / 四条未解除限制的边界声明）**。

---

## 变更批次 · 2026-11-15 13:31–14:10 · 2P 联机预置修复（已提交）

| 提交 | 实际提交时间 | 提交信息 | 说明 |
| --- | --- | --- | --- |
| `24902fc6d` | 2026-11-15 13:31 | `联机` | 四处确凿缺陷修复，由并发会话提交，改动内容完整保留 |
| `f84d6356a` | 2026-11-15 14:10 | `联机` | 后续补充：`gboylink_test.cpp` 注释引用脚本 + 新增/修订诊断脚本 |

> 同期相邻提交 `cfda51a44`（2026-11-15 12:30，`md`）为 `ios-build.yml` 断言改动，属**诊断增强不是修复**，不计入本批次缺陷条目；对应「iOS CI #65 缺新 job 验证」见「已知问题」。
> 初版核查时（14:13）`git status --short` 为空、工作区已被并发会话收干净；当前分支 `master`。

---

### ① path A 不再把整份即时存档灌进 SIO 20 字节字节管道

- **现象（给使用者）**：在直连 / 云端 SIO 包中继模式（path A）下，连接建立时有可能把一整份即时存档塞进本应只传 20 字节 SIO 包的通道，造成帧边界被撑破、联机卡死或串帧。**普通 GUI 默认路径下这条路径实际不会命中**（触发条件较窄，见根因），属于静态确凿缺陷而非已复现的线上事故。
- **根因（工程）**：PC `src/platform/qt/CloudLink.cpp:1723`（`startSioRelayBridge`）与 `:2319`（`serve`）在 path A 里调用 `maybeSendInitialState()` 发出 `frame(TYPE_STATE, [u32 len][blob])`；而 path A 接收侧 `:1748-1763` 把 payload **原样写回 netLink socket**，整份 savestate 会破坏 20 字节 SIO 帧边界。`handle():2363-2369` 的 `stateOf→remoteState→Window.cpp:3400` 又把状态灌进**可见核**（不是镜像核）。`m_stateSnapshot` 只由 `Window.cpp:3391` 设置、LobbyView 没设，故普通 GUI 下 `CloudLink.cpp:2380` 直接 return，**仅 `MGBAX_AUTOLINK` + 未设 `officialMode` 的组合会命中**。Android path A 干净（`GBoyCloudLink.java:1469-1546` 不调 `sendInitialState`）。
- **改动**：`src/platform/qt/CloudLink.cpp:2378` `maybeSendInitialState()` 加 `if (!m_officialMode) return false;`。**一处门控覆盖 path A 全部调用点**（`:1723` / `:2319`）；path B 的 `:2024 serveOfficial` 不受影响，多核镜像布局「连上互发一次即时存档、不覆盖屏幕进度」的行为保持不变。
- **验证方式**：`ninja -C build-win test-gboylink` `EXIT=0`（重编 `CloudLink.cpp` + `gboylink_test.cpp`）；`test-gboylink frames` / `buslocal` / `product-lockstep` 全 `EXIT=0`；`mgba_mobile_test` 全套 `mobile tests passed` `EXIT=0`。
- **待补（Rev.3 更新）**：仍**无针对「path A 不触发 `maybeSendInitialState`」的端到端自动断言**。4 组协议层断言（见 ⑥）不覆盖该门控，AC1–AC6 端到端断言仍为 0（发布控制清单 §3.1）；**且验收矩阵须按 path A / path B 分列，禁止用 path B 的 AC 判 path A 可用性**（口径更正 9 / R10）。

---

### ② busgame 默认参数不再必然误报「没进对战」

- **现象（给使用者）**：用默认参数跑 `test-gboylink busgame-lockstep` 时，无论代码是否正确，结果都稳定报 `BATTLE=NO` / `cb2=08170A81`（或 `080B2EED`），看起来像「联机进不了对战」，实际是**测试窗口不够长**叠加**判据写死旧 ROM 地址**。
- **根因（工程）**：`src/platform/qt/test/gboylink_test.cpp:2283-2284` 默认 `BUSGAME_FRAMES=3000`、`BUSGAME_TIMEOUT_MS=45000`。三条落盘日志的进战斗起始帧分别是 **3073 / 3090 / 3077**，默认 3000 帧**必然跑不到进战斗帧 f≈3073**；45 秒超时也不足以跑完 9000 帧。属**确定性假阴性**，不是架构失败。`08170A81` 应重判读为「连机菜单 / 座位脚本未走完的通用 overworld 状态」，不是 2P 专属、也不是 ROM 硬性要求 4 人的证据。
- **改动**：默认值 `BUSGAME_FRAMES` **3000 → 9000**、`BUSGAME_TIMEOUT_MS` **45000 → 260000**；注释如实写明「窗口对齐只是必要条件」，不宣称改完即闭环。
- **验证方式**：`ninja -C build-win test-gboylink` `EXIT=0`；`test-gboylink frames` / `buslocal` / `product-lockstep` 全 `EXIT=0`；`mgba_mobile_test` 全套 `EXIT=0`。
- **待补（Rev.2 改判 / Rev.3 补强）**：窗口对齐后两次实跑仍报 `BATTLE=NO / 080B2EED`，**根因由 T-03 定位为第二重判据假阴性**，Rev.3 已补**符号级证据**（口径更正 7）；**不是存档起始状态或并发负载差异**。本次改动只消除「参数窗口」这一重假阴性，**不构成绿灯证据**。

---

### ③ Android 过时使用例同步 11-13 后的新按键语义

- **现象（给使用者）**：Android 6 个 plain JVM 自检此前 **2/6 FAIL**（`GBoyLinkSessionTest` / `GBoySocketLinkTest`），看起来像产品回归；实际是测试没跟上协议变更。修复后自检恢复全绿，**并已在本轮续作接入 Gradle 门禁**（见 ⑤）。
- **根因（工程）**：11-13 把 `pushKeys` 改为直接覆盖 `currentKeys[slot]`（`GBoyLinkSession.java:349-359`，`pending[]` 仅构造初始化、`backlog()` 恒 0），语义变为「**最新即生效、不排队**」；用例仍断言旧的 5 帧队列（`backlog(...) > 0`），属 **stale test 非产品回归**。另两处协议过时：slot3 按键应使用 `TYPE_INPUT_3`，而非 `TYPE_READY`（后者现为「就绪 + RTT」）。11-11 全绿 → 11-13 改按键语义 → 用例未同步，是 FAIL 的完整链条。
- **改动（4 处 + 连带 3 处）**：
  - `GBoyLinkSessionTest.java`：两处过时用例改为「最新即生效、不排队」（`remoteKeysApplyImmediately` / `latestMaskWinsWithoutQueueing`），并补 **1 帧短按按下+松开**断言（针对 12Hz「5 帧采一次按键」整块吞掉短按的问题）；另两处按 11-15 协议复核改为 slot3 用 `TYPE_INPUT_3`。
  - `GBoySocketLinkTest.java`：`keyMaskReachesTheOtherConsole` 与 `slotTypedKeysOverLoopback` 的 `backlog(...) > 0` 改判 **`keysForSlot(...) == 掩码`**（新语义下 `backlog()` 恒 0）。
  - 修复过程中额外暴露并修掉 3 处被首个断言挡住的过时使用例（`slotTypedFrames` / `backPressureDropsOldest` / `slotTypedKeysOverLoopback`），印证 stale test 判断。
- **验证方式**：`javac -encoding UTF-8` 重编两个自检类 `JAVAC_EXIT=0`；`GBoyLinkSessionTest ok` `EXIT=0`、`GBoySocketLinkTest ok` `EXIT=0`。后者后台重连线程因本地 JVM classpath 无 `android.util.Log` 打印 `NoClassDefFoundError`，**属缺 `android.jar` 的环境问题、不影响主流程，非断言失败**，须与真实 FAIL 分列。
- **待补 → 已闭环（Rev.2）**：`:app:testDebugUnitTest` 因 0 个 `@Test`、无 `testImplementation`、离线缓存无 `junit:junit` **仍不可用**；但 6 个自检已由 T-04 以 **`:app:runLinkSelfTests`** 接入 Gradle 并实跑 `6/6 PASS`（见 ⑤）。**门禁请用 `runLinkSelfTests`，不要用 `testDebugUnitTest`**；两者不得混为一谈。

---

### ④ 新增可重复的 `tools/busgame-lockstep.sh` 诊断入口

- **现象（给使用者）**：此前 busgame 诊断靠手工拼一长串环境变量，且多轮复跑共享同一份 `D:/gen8/rom.sav`，存档被回写污染后每次起始状态都不同，结果无法复现、也无法判断是代码问题还是存档问题。
- **根因（工程）**：诊断参数未固化（需 `BUSGAME_FRAMES=9000` + `TIMEOUT=260000` + `MODE_DOWNS=2` + `MENU_AT=1500` + `HSL=1` + `LOGLEVEL=0` + `D:/gen8/rom.gba` / `rom.sav` / `4`），且共享存档母本被实跑回写（`D:/gen8/rom.sav` 与 `rom.gba` 本轮被回写为 13:38）。属**参数依赖型伪回归信号**。
- **改动**：新增 `tools/busgame-lockstep.sh`——固定历史全部环境变量，并**每次从 `tmp_bus/rom.sav` 复制存档到独立目录**，杜绝共享存档被回写污染；后续在 `gboylink_test.cpp` 注释中引用该脚本。
- **验证方式**：脚本可重复执行，两次实跑分别耗时 4m20s（默认新参数）与 4m37s（干净存档母本 + 全部历史参数），均产出完整诊断输出（`st4Frames` / `battleSamples` / `pc` / `walk` / `lastCb2`）。
- **重要口径（Rev.3 补强）**：两次实跑报 `BATTLE=NO / 080B2EED / battleSamples=0`，**现由 T-03 的 A/B 证据与符号级证据定位为判据假阴性，游戏实际进了对战**（见「口径更正 6 / 7」）。但该脚本**仍是可重复的 long/flaky 诊断入口，不是绿灯用例**；判据动态化与新旧 ROM 双腿复跑验证完成前，**不得用「跑完了」当作回归通过，也不得把任何一条腿的 `BATTLE=YES` 当作放行依据**。

---

## 变更批次 · 2026-11-15 续作 · T-03 / T-04 实跑结论（未提交）

> **批次性质**：本批次由 T-03 / T-04 并行线实跑产出，结论经主理人中转。**核查时（`git log -6` / `git status --short`）确认：无新增提交哈希，源码改动仍在并发工作区**（`android/app/src/main/java/io/mgba/android/EmulatorActivity.java`、`GBoyCloudLink.java`、`src/platform/qt/LobbyView.cpp` 为 `M`，`production/` 为 `??`）。**故本批次不列提交哈希、不臆造提交时间**；本任务不触碰上述文件、不提交。
> **判门口径**：本批次使「6 自检未挂 Gradle」**闭环**、「AC1–AC6 零自动断言」**部分缓解**；**2P 云端 0 条断言无变化，仍成立**；同时新增 3 项阻塞（C 层 flaky、空 blob 误断链、绝对地址判据不可靠）。发布门控仍 **FAIL**。

### ⑤ Gradle 自检门禁接入：`:app:runLinkSelfTests`（T-04 · 已闭环）

- **现象（给使用者）**：6 个 plain JVM 自检此前只能靠手工 `javac` + `java` 跑，`gradlew :app:testDebugUnitTest` 发现不到任何测试、报「0 个测试」却 `BUILD SUCCESSFUL`，看起来像门禁已过，实际**根本没有门禁**。
- **根因（工程）**：工程里没有 `@Test` 注解、没有 `testImplementation` 依赖，且离线 Gradle 缓存中无 `junit:junit`，JUnit 路线在 `--offline` 下走不通；这 6 个类是带 `main()` 的纯 JVM 自检，本就不属于 JUnit 测试集。`testDebugUnitTest` 不是可用门禁。接入过程另遇 3 个实跑坑（见下）。
- **改动**：
  - 新增 `:app:compileLinkSelfTests`（编译）+ **6 个 `:app:runLinkSelfTest_<Class>`**（单类执行）+ **`:app:runLinkSelfTests`（聚合）**，形成唯一权威门禁。
  - **实跑坑 1**：Gradle **9.3.1 移除了 `Project.javaexec()`**，原写法直接失败 → 改为 6 个 `JavaExec` 任务 + 一个聚合任务。
  - **实跑坑 2**：`LayoutOverlayTest` 使用相对路径读资源，在 Gradle 默认工作目录下找不到文件 → 给对应任务设 **`workingDir = 仓库根`**。
  - **实跑坑 3**：块注释里出现 `res/values*/dimens.xml`，其中 **`*/` 提前闭合了 Groovy 块注释**，后续内容被当代码解析导致脚本解析失败 → 将该处改为 ASCII 表述避开注释终止符。
- **验证方式**：`cd android && ./gradlew :app:runLinkSelfTests --offline --console=plain` → **`BUILD SUCCESSFUL` / `EXIT=0` / 13~16s / `runLinkSelfTests: 6/6 PASS`**。
- **口径**：⛔ **门禁请用 `runLinkSelfTests`，不要用 `testDebugUnitTest`**（后者仍 0 个 `@Test`、无 `testImplementation`、离线缓存无 `junit:junit`）。此项使发布控制清单 §3.2 **已闭环、移出阻塞**，但**不改变 2P 云端交付门 FAIL 判定**。

### ⑥ 4 组纯 JVM 协议层断言（T-04 · 已落地，AC1–AC6 部分缓解）

- **现象（给使用者）**：type 6 状态帧与协议号此前只有实现、没有自动断言；`TYPE_READY` 语义从「按键」改成「就绪 + RTT」后，曾出现用例仍按旧含义写 slot3 按键（见 ③），说明协议号漂移没有护栏。
- **根因（工程）**：`GBoyFrames.cpp:72-84` 的 `stateOf()` 状态帧解析逻辑（合法帧接受、裸 20 字节 SIO 桥包拒绝、长度字段校验）缺自动断言；协议号常量缺回归锁。AC1–AC6 产品验收项此前**零自动断言**。
- **改动（4 组断言，实跑通过）**：
  - `typeSixStateFrameRoundTrip`：type 6 状态帧组包 → `stateOf()` 解包，往返一致。
  - `typeSixRejectsRawSioBridgePacket`：裸 20 字节 SIO 桥包被 `stateOf()` 拒绝为空，不构成合法状态帧。
  - `typeSixRejectsTruncatedAndIllegalLengths`：截断帧与非法长度帧被拒绝（对应载入失败 `-5→3` / 其它非 0→1）。
  - `protocolNumbersGuardAgainstReadyDrift`：锁住协议号，防止 `TYPE_READY` 语义漂移（slot3 按键须用 `TYPE_INPUT_3`）。
- **验证方式**：随 `:app:runLinkSelfTests` 聚合任务实跑通过（`6/6 PASS`，`EXIT=0`）。
- **口径（Rev.3 补充）**：⛔ **端到端断言仍为 0，不得标完成**。这 4 组是**协议层纯 JVM 断言**，不覆盖三端 `loadStateFromMemory` 落地、可见核进度保护、复位联动的端到端行为，**也不构成 2P 云端路径断言**（§3.3 仍成立）。**且 AC1–AC6 是 path B 语义，验收矩阵须按 path A / path B 分列**（口径更正 9 / R10）。发布控制清单 §3.1 由「全部 MISSING」改为「**部分缓解**」，仍列阻塞。

---

## 变更批次 · 2026-11-15 二次续作 · T-03 能力协商 / T-05 产品口径 / T-06 文档收口（未提交）

> **批次性质**：本批次由 T-03（能力协商与 AUTO 默认落地、判据符号级证据）、T-05（设计评审与四项产品决策）、T-06（发布线文档收口）产出，结论经主理人中转。**核查时（`git log -6` / `git status --short`）确认：仍无新增提交哈希**，工作区为 3 个源码文件 `M` 与 `design/` / `docs/` / `production/` / `tests/` 未跟踪项（并发会话改动）。**故本批次不列提交哈希、不臆造提交时间**；本任务仅在 `production/release/` 下改两份文档，未触碰其它文件、未提交。
> **判门口径**：**2P 云端交付门 FAIL、C/Qt 本地回归门 CONCERNS，分列不变**；禁止用 `6/6 PASS`、汇总 ok 数或单腿 `BATTLE=YES` 互相替代。

### ⑦ AUTO 默认与 `mode` 能力协商落地（T-03 · 代码已落地，默认策略变更仍须人工审批）

- **现象（给使用者）**：此前 PC 默认 path A、Android 默认 path B，2P 最常见的 PC↔Android 组合在默认态就命中能力协商失败；且失败文案写「请在两端统一模式」时，普通玩家**没有任何界面可以照做**（环境变量 / private pref / ADB 均无 UI）。
- **根因（工程）**：两套架构（path A = 每端 1 核 + SIO 包中继；path B = 本机 4 核 + 网络只传按键）由 `officialMode` 分派，PC `CloudLink.cpp:611` 与 Android `EmulatorActivity.java:5525-5526` 默认值不一致；`flow.sh:101` 靠 `MGBAX_OFFICIAL_LINK` 环境变量强拉，属测试脚手架。`CloudLink.cpp:608-610` 记过两套帧格式同流耗死读线程（9470 碎片包）的事故。
- **改动（T-03 落地）**：
  - **AUTO 默认**：PC / Android 同逻辑 **`resolveLinkMode(playerCount)`——2P→A、3/4P→B**；原「未设 `MGBAX_OFFICIAL_LINK` 即 A」与「`gboy_official_link=true` 恒 B」的默认值被取代。
  - **`mode` 能力协商**：type 1 握手加 1 bit `mode`（A/B），两端取协商结果，**不一致直接 fail + 玩家可见提示，禁止静默降级**。
  - **PC 大厅下拉框**（`LobbyView.cpp`），QSettings 持久化 `link_mode` —— **PC 可 UI 自救**。
  - **Android `GBOY_LINK_MODE` ADB 广播**，持久化 `gboy_link_mode` —— **仅 ADB 可达、无 UI 复选框**。
  - **iOS 无 path A**，2P 房间会**可见协商失败**（不静默）。
- **验证方式**：由主理人中转 T-03 落地结论；**本任务未自行复跑、未改代码**。清单侧核对：§1 三端表、§3.7 / §3.10、§8 阻塞项 6 已按新口径改判。
- **口径**：✅ 原阻塞项「PC 默认 A / Android 默认 B 且无能力协商」**撤回**；改判为「能力协商已落地；PC 可 UI 自救，Android 仅 ADB 广播可达、无 UI 复选框，iOS 无 path A 且 2P 房间会可见协商失败」。⛔ 剩余缺口仍列阻塞（§3.7 / §8 第 6 条）：Android 自救可达性、iOS 隐藏「改用兼容模式」、S3 分平台可执行步骤 + 一键复制命令（裁定 ①）。⛔ **「切换三端默认联机模式」仍保留在发布控制清单 §6.2 人工审批清单（高影响动作，本轮未执行）**——代码落地不等于默认策略变更获批。

### ⑧ 发布线文档收口：教程改写合并 + 产品口径已裁定（T-06 文档域 · 非代码改动）

- **现象（给使用者）**：教程的 7 条产品既有承诺与当前架构脱节（「互发即时存档给隐藏核」是 path B 专属、「帧格式完全一致」与两套帧格式隔离冲突、通道顺序与 P2P 直连优先相反、两份教程的重连动作互相矛盾）；同时 T-05 §6 的四项产品决策待拍板，发布线无统一口径可依。
- **根因（工程 / 文档）**：架构从「默认 path B」转向「2P 首选 path A + type 6 并存 + `mode` 隔离」后，教程仍按旧架构做「全模式承诺」；T-05 `design/gdd/2p-link-scope-review.md` §4 已逐条核对并给出可直接粘贴文本，但未落盘到教程（属发布线文档域）。
- **改动（本任务，仅 `production/release/` 两份文档）**：
  - **合并 T-05 §4 的 8 处改写落点**到发布控制清单 §5.2 D-1~D-8（P0×2 / P1×4 / P2×1 / 已覆盖×1），逐条标注来源与优先级，保留可直接粘贴文本；§5.1 补齐 7 条用户可见限制（同游戏但文件指纹不同 / 不同账号 / 不同 uuid / 同档仍卡看状态栏 / 互发即时存档为 path B 专属 / 复位联动措辞 / 模式切换可达性差异）。
  - **消解结论**：「**通道级 P2P→隧道回退属设计内允许**」（不中断、不弹错误，但状态栏如实显示）与「**架构级 A↔B 禁止静默降级**」不冲突；「帧格式完全一致」改为「**同一联机模式内**帧格式一致」。
  - **新增「产品口径已裁定」段**（发布控制清单 §5.3）：主理人对 T-05 四项决策**全部采纳 A**。
  - **登记 AC1–AC6 口径分裂为发布风险 R10**：验收矩阵必须按 path A / path B 分列，**禁止用 path B 的 AC 判 path A 的可用性**（见口径更正 9）。
- **验证方式**：本任务逐段写入并扫描旧口径残留；教程改写文本**只落在清单内，未改根目录 `安卓版完整使用教程.md` / `PC版完整使用教程.md`**。
- **口径**：⛔ **教程正式改写发布仍属 §6.2 人工审批动作，本轮未执行**；⛔ 产品口径「已裁定」≠「已执行 / 已交付」，四项决策的 UI / 文案落地未逐项验收（§8 第 13 条）。

---

## 产品口径已裁定（Rev.3 新增 · 主理人拍板，T-05 四项决策全部采纳 A）

> **状态区分**：以下是**已裁定的产品口径**（决策生效），**不是已执行的产品代码或已发布的教程**。来源：T-05 `design/gdd/2p-link-scope-review.md` §6、`design/gdd/2p-link-ux-spec.md`（经主理人中转）。**「切换默认模式」与「正式改写发布教程」仍属人工审批动作，不得标为已执行。**

| # | 决策（全部采纳 A） | 落地口径 | 状态 |
| --- | --- | --- | --- |
| ① | **能力协商失败后「统一模式」自救路径 = A** | S3 对话框内提供**分平台可执行步骤 + 一键复制命令**（PC 大厅模式下拉框 / Android `GBOY_LINK_MODE` ADB 广播），**零新增产品代码**；`mode` 仍不一致时「重试」置灰并给原因 | 口径已裁定；代码落地由 T-03 负责，未标为已执行 |
| ② | **path B 对外命名与露出 = A** | 统一命名「**兼容模式（实验性）· 2 真人 + 2 电脑占位**」+ 进房前说明卡 + **席位灰显**（`3P、4P 电脑占位（不操作）`）+ 常驻实验性徽标 + **不计成绩**；不默认、不自动、需二次确认 | 口径已裁定；「NPC 队伍 / AI / 台词」等角色化表现明确**不做**，不写成已实现 |
| ③ | **帧率可玩阈值 = A** | **GREEN ≥ 50 fps / YELLOW 10–50 fps / RED < 10 fps 三档 + 6 s 去抖**；标注「**设计侧建议值，待 PC / Android 分端真机校准**」；`F_eff` 实测优先于通道徽标判档；同一连接内说明条只弹一次 | 口径已裁定；数值定稿延后至真机 Playtest，不得当作已校准数据 |
| ④ | **iOS 对外口径 = A** | 明确写「**iOS 暂不支持双人联机**」；能力协商失败时若任一端为 iOS，文案切换为指名 iOS 的失败原因并**隐藏「改用兼容模式继续」** | 口径已裁定；iOS 2P 功能实现仍延后 |

> **T-05 设计侧强保留意见（如实收录）**：若「PC/Android 默认模式对齐」与「失败对话框的统一模式自救路径」两项不在本冲刺落地，2P 功能对玩家等价于「开箱即失败且无法自救」；设计侧建议在此前提下**不放行 2P 联机的对外交付**。**默认对齐已由 AUTO 落地；自救路径在 Android 侧仍受「仅 ADB 广播可达、无 UI 复选框」限制，该保留意见未被完全解除。**

---

## 本轮口径更正（非代码改动，但影响发布口径，优先级高于旧结论）

> 以下为核查结论的更正 / 已裁定口径，**不是已修缺陷**，记录在此以免发布清单按旧口径签署 go。

1. **type 6 语义更正**：`GBoy联机实现拆解与移植方案.md:122` 的 `GBoyCloudLink.startSioRelayBridge()` 是**本仓自家类**（`GBoyCloudLink.java:1469`；PC `CloudLink.cpp:1713`），不是官方 APK 类；官方类为混淆名 `KpHwm4.B25kr6` 等。11-14 脱壳字节码显示：官方客户端 `case 6` = `size + savestate → console.loadStateFromMemory`，房主 / 入房方逐槽灌镜像核（`NETPLAY_SPEC.md:69,84,90`）。⇒ 三端 `case 6 → loadStateFromMemory` **与官方一致，不是误做**，**不要全量改回 SIO 包中继**（会失去官方 case 6 互通并要改三端全部落地点）。条目 ① 修的是「path A 误发整份 savestate」，不是改 type 6 语义。

2. **两套架构并存且默认不一致（Rev.3 已被 ⑦ 取代，保留作历史）**：path A = 每端 1 核 + SIO 包中继；path B = 本机 4 核 + 网络只传按键。PC `CloudLink.cpp:611` 默认 A（`MGBAX_OFFICIAL_LINK` 未设），Android `EmulatorActivity.java:5525-5526` 默认 B（`gboy_official_link=true`），由 `officialMode` 分派；`flow.sh:101` 靠环境变量强拉 PC 到 B，是测试脚手架不是产品形态。`CloudLink.cpp:608-610` 记过两套帧格式同流耗死读线程（9470 碎片包）的事故。⇒ **Rev.3 更正：AUTO 默认 + `mode` 能力协商已落地（见 ⑦），「默认不一致」不再是现状结论**；但两套帧格式不能同流的约束仍成立（R2）。

3. **撤回「必须维持 4 核/设备」**：
   「ROM 硬性要求 4 人」从「强推断」降级为**未证实、现有反证倾向否定**——11-08 有 2P（每端 1 核）`LINKUP cnt=2 → cb2` 落 battle_main.o 的实跑（`2026-11-08.md:929-932`；旧精确判据 `0x0809A241` 虽作废但落在旧 ROM 区间 `0x08099848~0x080A30FC` 内），§7.6 亦记 P2P 直连两端各 1 核进 `BattleMainCB2` / 60fps。⇒ 4 核只是 **path B 实现路线的约束，不是 ROM 约束**。

4. **2P 首选改为 path A**：path A 代码完整仍在、未被 11-12 锁步改造覆盖（`§7.2:272` 两人直连一字未动）；iOS 完全没有 path A。**默认假设：2P 仅 PC↔Android 可用，iOS 只支持 path B**。

5. **「跨设备云端 2P 已闭环」不成立**：本机 4 核脚本驱动 `BATTLE=YES` 有落盘证据（`.workbuddy/final_busgame_product.out`、`build-win/qt/ls_result.txt`），但所有云端 `flow_*.log` 的 BATTLE 计数**全 0**；「房间 830480 BATTLE=YES 连续 20 个采样」无落盘 logcat 佐证，疑与本机 LS 日志串线。**勿据此跳过产品化。**

6. **【Rev.2】`busgame-lockstep` 两次 `BATTLE=NO` 是判据假阴性，不是架构失败（Rev.3 由 7 补强为符号级证据）**：
   - **A/B 证据**：`/d/gen8/rom.gba` 被并发会话**重新编译**（md5 `074cfcdb…`、mtime **13:51:30**），与 `tmp_bus/rom.gba` 在 **23,246,794 / 33,554,432 字节**处不同；两次 `cb2trace` 的 30 条非零项**全部均匀 `+0x16E64`**，且 **`080B2EED − 0809C089 = 0x16E64`**；`/d/gen8/rom.map:7199` 的 `.text 0x080b19e4 0x98b4 src/battle_main.o` **包含 `080B2EED`** ⇒ 游戏**实际进了对战**，只是地址随 ROM 重编译整体平移。
   - **旧 ROM 腿对照实跑**：`BATTLE=YES / 0809AFCD / battleSamples=3387 / battleFrames=[3077,4668]`。
   - **根因**：`gboylink_test.cpp:2693-2700` 把 `battle_main.o` 区间**写死成旧 ROM 常量**；判据修复已裁决给 **T-03**。
   - **⇒ 撤回 K1 旧结论**「还有未定位的存档起始状态或并发负载差异」「四座位齐但没进战斗」；`080B2EED` 重判读为**新 ROM 的 battle_main 内地址**，不是 overworld 状态。
   - ⛔ **但修复与新旧 ROM 双腿复跑验证完成前，仍不得作为放行依据**；旧 ROM 腿的 `BATTLE=YES` 只证明判据假设，**不证明跨设备 2P 云端闭环**（口径更正 5 / §3.6 仍成立）。衍生独立风险见 K6 / 发布控制清单 §7 R8。

7. **【Rev.3 新增 · T-03】`busgame` 判据假阴性补强为符号级证据（补强 6，不新增代码改动）**：
   - 新 ROM 腿 **`lastCb2=080B3169` = `rom.map:7204 BattleMainCB2 0x080b3168` +1**（Thumb 指针 +1）；旧 ROM 腿 **`0809AFCD` = `syms.txt:249127 0809afcd BattleMainCB2`**。
   - ⇒ 两腿的 `cb2` 都**精确落在各自 ROM 的 `BattleMainCB2` 符号**上，直接证明「游戏进了对战」；判据误报的根因不只是「地址平移」，而是**判据绑绝对地址、未绑符号**。这进一步坐实 K6 / R8。
   - **判据动态化四项（T-03 进行中，未落地）**：① 从当前 ROM `.map` 取 `battle_main.o` / `BattleMainCB2` 区间；② **判据输出绑定 ROM md5**；③ **新 ROM 腿 + 旧 ROM 腿双腿复跑验证**；④ **`.map` 缺失时报 `STALE_BATTLE_WINDOW`**（不得静默沿用旧常量）。
   - ⛔ **修复中，双腿验证完成前不得作为放行依据**（发布控制清单 §3.13 / §7 R5）。

8. **【Rev.3 新增 · 主理人裁定】T-05 四项产品决策全部采纳 A**：见上方「产品口径已裁定」段。裁定生效 ≠ 已执行；「切换默认模式」与「正式改写发布教程」仍属人工审批动作。

9. **【Rev.3 新增 · T-05 §4 交叉项 / T-04 处理中】AC1–AC6 是 path B 语义，验收矩阵必须按路径分列**：
   - AC1–AC6（互发一次即时存档 / 只灌隐藏核 / 载入不复位 / 不冲掉可见核进度 / 失败断链 / 复位联动）依赖**镜像核与整份 savestate**，属 **path B**；2P 首选 **path A 无镜像核**，且 `!m_officialMode` 门控**明确不发整份 savestate**（条目 ①）。
   - ⇒ **禁止用 path B 的 AC 判 path A 的可用性**：否则会把「path A 正确地不发存档」误判为功能缺失，并按错误矩阵做出与架构相反的产品改动。T-04 正在把验收矩阵按 path A / path B 分列（**未完成**）。
   - 教程侧对应承诺 d 已按模式分别陈述（发布控制清单 §5.2 D-1）；登记为发布风险 **R10**。

---

## 本轮新发现缺陷 / 风险（修复中 / 定位中，未落地，不计入「已修」）

> 以下由 T-03 / T-04 / T-05 在本轮实跑或评审中暴露，**尚未修复完成**，按发布控制清单 §3.11 / §3.12 / §7 R10 / R11 列为阻塞项。

**N1 · path A 借壳 type 6 的空 blob 误断链（T-03 修复中）**
- 链路：`GBoyLinkSession.onFrameBody` 的 `case TYPE_STATE` **无条件** `events.onState(stateOf(body))`；PC `CloudLink.cpp:2367` 却有 `if (!state.isEmpty())` 保护。裸 20 字节 SIO 桥包被 `stateOf()` 拒绝为空后仍派发 → `applyRemoteState(empty)` 返回 `STATE_ERROR(1)` → `EmulatorActivity.close()` **断链**。
- 性质：**跨端实现不一致的缺陷**，不是设计差异；PC 侧不复现，易被误判为网络问题。⑥ 的 `typeSixRejectsRawSioBridgePacket` 只锁住协议层「拒绝」，**未覆盖「拒绝后仍派发」的端到端行为**。
- 状态：已指派 **T-03 修 main 侧**，清单记为「修复中」，不得标完成；关联风险 R7、断链策略见清单 §4.5 第 7 条。

**N2 · C 层低频 flaky 未隔离（Rev.3 采样数更新 · T-04 定位中）**
- `mgba_mobile_test` **18 次采样 1 次 `mobile tests failed / EXIT=1`、17 次 `mobile tests passed / EXIT=0`**（低频 flaky）；**首次失败完整日志未留存**。T-04 正在扩大采样定位。
- ⛔ **flaky 隔离前不得作为干净 CI 信号**；**C/Qt 本地回归门 CONCERNS**。禁止用「17 次通过」的多数结果掩盖 1 次失败；热修回归须多次采样并留存每次完整日志（清单 §4.3）。

**N3 · 【Rev.3 新增】AC1–AC6 口径分裂（T-04 分列进行中）**
- AC1–AC6 是 **path B 语义**，2P 首选 path A 无镜像核且 `!m_officialMode` 门控不发整份 savestate（口径更正 9）。
- ⛔ **验收矩阵必须按 path A / path B 分列，禁止用 path B 的 AC 判 path A 的可用性**；T-04 分列完成前，AC1–AC6 不得作为 path A 的放行判据。登记为发布风险 **R10**。

**N4 · 【Rev.3 新增】教程承诺与架构脱节 + 自救可达性差异（T-06 文本已合并，正式改写属人工审批）**
- T-05 §4 逐条核对 7 条产品既有承诺，给出 **8 处改写落点**；文本已合并进发布控制清单 §5.2 D-1~D-8，**未改根目录教程**。
- **Android 仅 `GBOY_LINK_MODE` ADB 广播可达、无 UI 复选框**，失败提示要求「统一模式」时普通玩家无界面可照做 → 无效重连循环；裁定 ① 的 S3 分平台可执行步骤 + 一键复制命令待 T-03 落地。
- ⛔ **教程正式改写发布仍属人工审批动作，本轮未执行**；登记为发布风险 **R11**。

---

## 本轮实跑验证汇总

### 初版批次（2026-11-15 13:xx）

| 项 | 结果 |
| --- | --- |
| `ninja -C build-win test-gboylink` | `EXIT=0`（重编 `CloudLink.cpp` + `gboylink_test.cpp`） |
| `test-gboylink frames` / `buslocal` / `product-lockstep` | 全 `EXIT=0` |
| `mgba_mobile_test` 全套 | `mobile tests passed` `EXIT=0`（**单次；已被 flaky 采样推翻为不可作干净信号**） |
| `javac -encoding UTF-8` 两个自检类 | `JAVAC_EXIT=0`；`GBoyLinkSessionTest ok` / `GBoySocketLinkTest ok` 均 `EXIT=0` |
| `tools/busgame-lockstep.sh` | 可重复执行；两次报 `BATTLE=NO / 080B2EED / battleSamples=0`（**判据假阴性，游戏实际进对战**；仍是诊断入口，**非绿灯**） |
| C/Qt 本地回归（上一轮基线） | 242 / 164 / 169 / 64 / 37 全 0 失败；iOS 本地类型检查 0 error / 90 warning |

### 续作批次（2026-11-15 · T-03 / T-04 实跑，主理人中转）

| 项 | 结果 |
| --- | --- |
| `cd android && ./gradlew :app:runLinkSelfTests --offline --console=plain` | **`BUILD SUCCESSFUL` / `EXIT=0` / 13~16s / `runLinkSelfTests: 6/6 PASS`**（⑤ 已闭环） |
| `:app:testDebugUnitTest` | **仍不可用**：0 个 `@Test`、无 `testImplementation`、离线缓存无 `junit:junit`；**不得作门禁** |
| T-04 新增 4 组协议层断言 | 全部实跑通过（⑥ 部分缓解，端到端仍 0；**且须按 path A / path B 分列**，R10） |
| `mgba_mobile_test` 采样 | **Rev.3 更新：18 次 1 次 `EXIT=1` / 17 次 `EXIT=0`**（低频 flaky，N2 / CONCERNS 来源） |
| 旧 ROM 腿 busgame 对照 | **`BATTLE=YES / 0809AFCD / battleSamples=3387 / battleFrames=[3077,4668]`** |
| 新 ROM 腿 cb2trace | 30 条非零项均匀 `+0x16E64`；`080B2EED` 落在 `/d/gen8/rom.map:7199` `battle_main.o` 区间内 ⇒ **实际进对战，旧判据误报** |
| 2P 云端路径断言 | **仍为 0 条，无变化** |
| `git log -6` / `git status --short`（续作核查） | 无新增提交哈希；3 个源码文件 `M`、`production/` `??`（并发会话改动，本任务不触碰、不提交） |

### 二次续作批次（2026-11-15 · T-03 / T-05 / T-06，主理人中转，本任务未自行复跑）

| 项 | 结果 |
| --- | --- |
| AUTO 默认 `resolveLinkMode(playerCount)` | **2P→A、3/4P→B，PC / Android 同逻辑**（⑦ 代码已落地） |
| `mode` 能力协商 | type 1 握手 1 bit `mode`；**不一致 fail + 玩家可见提示，禁止静默降级**（⑦） |
| PC 大厅下拉框 | `LobbyView.cpp`，QSettings 持久化 `link_mode` —— **PC 可 UI 自救** |
| Android 模式入口 | `GBOY_LINK_MODE` ADB 广播，持久化 `gboy_link_mode` —— **仅 ADB 可达、无 UI 复选框** |
| iOS 2P 房间 | **可见协商失败**；按裁定 ④ 隐藏「改用兼容模式」 |
| `busgame` 判据符号级证据 | 新腿 `lastCb2=080B3169` = `rom.map:7204 BattleMainCB2 0x080b3168` **+1**；旧腿 `0809AFCD` = `syms.txt:249127 0809afcd BattleMainCB2`（口径更正 7） |
| 判据动态化四项 | `.map` 取区间 + ROM md5 绑定 + 双腿验证 + `.map` 缺失报 `STALE_BATTLE_WINDOW`（**进行中，未落地**） |
| T-05 四项产品决策 | **全部采纳 A**（产品口径已裁定段）；口径生效、落地未执行 |
| T-05 §4 教程改写 | **8 处落点文本已合并进发布控制清单 §5.2 D-1~D-8**；**未改根目录教程**，正式发布属人工审批 |
| AC1–AC6 口径分裂 | 登记为发布风险 **R10**；T-04 正在按 path A / path B 分列（未完成） |
| `git log -6` / `git status --short`（二次续作核查） | **仍无新增提交哈希**；3 个源码文件 `M`，`design/` / `docs/` / `production/` / `tests/` `??`（并发会话改动，本任务不触碰、不提交） |

> **分路径结论（勿混列 · Rev.3 维持）**：**C/Qt 本地回归门 = CONCERNS**（C 层低频 flaky 未隔离，18 次采样 1 次 `EXIT=1`）；**2P 云端交付门 = FAIL**。禁止用汇总 ok 数、`6/6 PASS`、单腿 `BATTLE=YES`、或「口径已裁定」代替分路径结论。

---

## 变更批次 · 2026-11-15 Rev.4 · B6 已知限制正式登记（文档 · 本次提交）

> **批次性质**：本轮为**文档批次**，仅修改 `production/release/2p-link-release-checklist.md` 与 `production/release/CHANGELOG-2p-link.md` 两份发布文档；**未改代码、未改配置、未改测试、未改根目录教程**。按主理人明确指令执行一次**本地 `git commit`**；**未 push、未 tag、未删除、未 --force**（推送纪律见清单 §6.1，push 仍属人工审批动作）。

### 已知限制（未解除）

> **性质声明（最重要）**：以下四条（及 KL-1~KL-3 的架构限制）**不是回归、不是本次改动引入、不是待修 TODO**，而是**当前交付范围的边界声明**。它们决定「哪些组合能交付、哪些不能」。**任何对外文案不得把「范围外」写成「后续会修」或「已修复」。**
> **完整口径与逐条「现象 → 影响范围 → 规避方式 → 依据文件」见发布控制清单 §5.4**（KL-1 ~ KL-4）。

| # | 已知限制（未解除） | 一句话口径 | 依据文件 |
| --- | --- | --- | --- |
| **KL-1** | **iOS 没有 path A，与 PC / Android 组 2P 房间会协商失败并断开** | 能力位不一致是**设计上的硬拒绝**——不是崩溃、不是静默降级。**iOS 目前只能与 iOS 组 3/4 人 B 模式房间** | `ios/mGBA/GBoyConsoleSet.swift`（仅 N 核路径；`ios/` grep `sioRelay`/`pathA` 零命中）；`CloudLink.cpp:2834-2841,2925-2948` |
| **KL-2** | **AUTO 默认对 iOS 不友好**：`resolveLinkMode(playerCount)` 是 2 人→A、3/4 人→B，iOS 用户建 2 人房必然撞这条 | 规避：改用 **3/4 人房**，或 **PC / Android 端显式覆盖为 B** | `CloudLink.cpp:2855`（`resolveLinkMode` 定义 / AUTO 分档 `:2855-2861`）、`:1462,2270,2328,2893`；`GBoyCloudLink.java:1055,2651-2656`；`LobbyView.cpp` |
| **KL-3** | **会话级 / 通道级回退 vs 架构级降级**：通道级（UDP 中继→隧道→P2P 直连）设计内允许；架构级 A↔B 静默降级**禁止** | `allow_legacy=true`（PC `MGBAX_LINK_ALLOW_LEGACY=1`）是**显式**回落、状态栏打警告，且**该路径未经 2P 云端验收**——定位为「**不建议用于交付**」，交付默认保持关闭 | `CloudLink.cpp:2925-2948`（回落与警告）、`:644`（`m_allowLegacyPeer` 初始 false）；`GBoyCloudLink.java:2704-2719`；`ADR-002:84,158` |
| **KL-4.1** | **跨设备云端 2P 从未闭环** | 所有云端 `flow_*.log` 的 BATTLE 计数**全 0**；本机 4 核脚本驱动的 `BATTLE=YES` **只是进程内锁步证据**，不能外推 | `2026-11-15.md` 硬结论 1；`MEMORY.md` 顶部勘误；本清单 §3.6 |
| **KL-4.2** | **PC path A 曾在 11-08 出现进战斗后 `C0000005` 崩溃，至今未找到已修证据** | 长时间对战存在进程级崩溃风险；**不得声称已修**；崩溃须给「上次连接异常结束」可见提示 | `2026-11-08.md:934-937`；本清单 §3.8 / §4.2 |
| **KL-4.3** | **`sioFastFrame` 只有 PC / Qt 实现，Android native 无等价物** | Android native path A 实测 **4.6~4.9 fps**；跨公网帧锁步约 0.7~1.5 fps 物理不可行 | `src/platform/qt/sio_link.c`（全仓唯一实现处）；本清单 §3.9 |
| **KL-4.4** | **2P 局域网 ADB 入口零覆盖（无自动化断言）** | 唯一入口 `GBOY_LOCAL_LINK --ez host true --ei players 2` 无任何自动断言；定位为**调试 / 自动化向**，非面向玩家的交付路径 | 本清单 §5.1 #2 / §3.3；`安卓版完整使用教程.md:98,127-129` |

> **与「已知问题 K1–K8」的区别（避免混淆）**：`已知问题`（下方 K 段）记录的是**本轮新发现、修复中的缺陷**（有明确修复责任方与修复中状态）；`已知限制（未解除）` 记录的是**不打算在本冲刺修的交付范围边界**。二者**不得互相替代**：不得因为「已登记为已知限制」就不修 K 段的缺陷，也不得把 K 段缺陷包装成「已知限制」。
> **判定不变**：本批次仅登记边界，**不改变** 2P 云端交付门 **FAIL**、C/Qt 本地回归门 **CONCERNS** 的双门判定（清单 §8）。

---

## 已知问题（未闭环 · 如实记录，勿报全绿）

**K1 · `busgame-lockstep` 判据假阴性：符号级证据坐实，修复中（Rev.3 补强，覆盖初版「仍未进对战」结论）**
- 历史落盘数据（保留作证据，不作现状结论）：① 新默认参数跑 4m20s → `lastCb2=080B2EED` / `st4Frames=[1365,8971]` / `battleSamples=0` / `pc=[4,4,4,4]`；② `tools/busgame-lockstep.sh`（干净存档母本）跑 4m37s → `BATTLE=NO / 080B2EED / battleSamples=0`、`st4Frames=[1366,8191]`、`walk=[...00]`。
- **改判依据（Rev.2 A/B）**：`/d/gen8/rom.gba` 被重编译（md5 `074cfcdb…`、mtime 13:51:30），与 `tmp_bus/rom.gba` 在 23,246,794 / 33,554,432 字节处不同；`080B2EED − 0809C089 = 0x16E64` 且 30 条 cb2trace 非零项均匀 `+0x16E64`；`/d/gen8/rom.map:7199` `.text 0x080b19e4 0x98b4 src/battle_main.o` 包含 `080B2EED`；旧 ROM 腿实跑 `BATTLE=YES / 0809AFCD / battleSamples=3387 / battleFrames=[3077,4668]`。
- **【Rev.3 新增】符号级证据（T-03）**：新 ROM 腿 `lastCb2=080B3169` = `rom.map:7204 BattleMainCB2 0x080b3168` **+1**；旧腿 `0809AFCD` = `syms.txt:249127 0809afcd BattleMainCB2`。⇒ 两腿 `cb2` 精确落在各自 ROM 的 `BattleMainCB2` 符号上，**直接证明进了对战**。
- **根因**：`gboylink_test.cpp:2693-2700` 把 `battle_main.o` 区间写死成旧 ROM 常量（**绑绝对地址、未绑符号**）；判据修复已裁决给 T-03（未落地）。⇒ **撤回**「存档起始状态 / 并发负载差异未定位」与「四座位齐但没进战斗」两条旧判断。
- **判据动态化四项（进行中）**：`.map` 取区间 + ROM md5 绑定 + 双腿验证 + `.map` 缺失报 `STALE_BATTLE_WINDOW`。
- ⛔ **修复与新旧 ROM 双腿复跑验证完成前，仍不得作为放行依据**；该脚本仍为 long/flaky 诊断入口、非绿灯用例。衍生方法论风险见 K6。

**K2 · 质量门 FAIL 的阻塞项（Rev.3 逐条改判；对应发布控制清单 §3）**
- AC1–AC6 **端到端自动断言仍为 0**：4 组协议层纯 JVM 断言只是**部分缓解**，不得标完成（§3.1）。**【Rev.3 新增】验收矩阵须按 path A / path B 分列，禁止用 path B 的 AC 判 path A 可用性（R10 / N3）**。
- **2P 云端路径仍为 0 条断言，无变化、仍成立**；2P 局域网 ADB 入口零覆盖（§3.3）。
- ✅ **Android 6 个 plain JVM 自检接入 Gradle 已闭环**：`:app:runLinkSelfTests` `6/6 PASS` / `EXIT=0`；**门禁请用 `runLinkSelfTests`，不要用 `testDebugUnitTest`**（§3.2，已从阻塞清单移出）。
- **【Rev.3 改判】默认模式不一致**：AUTO 默认 + `mode` 能力协商**已落地**（⑦ / §3.7），原「PC 默认 A / Android 默认 B 且无能力协商」撤回；**剩余缺口**：Android 仅 ADB 广播可达、无 UI 复选框；iOS 2P 房间可见协商失败、隐藏「改用兼容模式」待落地；S3 分平台可执行步骤 + 一键复制命令（裁定 ①）待 T-03 落地。⛔ **「切换三端默认联机模式」仍属 §6.2 人工审批、本轮未执行**。
- iOS CI #65 **缺新 job 验证**：真实根因 `EmulatorViewController.swift:6474:71` 多余尾随闭包已在远端 main 源码侧消除，但上次 job 在 build 步骤就终止，**runtime check 从未执行**；本地 stub typecheck 漏检过真实 UIKit 签名错误，编译门以 CI `xcodebuild` 为唯一权威。
- 真机 Playtest 未做（AVD 4P/2P 均 59.7fps 已过，真机过游戏 UI 进对战未验证）；**帧率三档 50 / 10 fps 待分端真机校准**（裁定 ③）。
- 跨设备 E2E 未闭环：所有云端 `flow_*.log` BATTLE 计数全 0；F19 判据（落盘 logcat + 双端截图 + 全量 PEEK、`BATTLE=YES 计数 > 0`、cb2 落**当前 ROM 的 `battle_main.o` / `BattleMainCB2` 区间**）未达成。**旧常量区间 `0x08099848~0x080A30FC` / `0x0809AFCD` 仅对旧 ROM 有效，不得沿用**（K6 / R8）。
- **【Rev.3 更新】C 层低频 flaky 未隔离（N2 / §3.11）**：`mgba_mobile_test` **18 次 1 次 `EXIT=1` / 17 次 `EXIT=0`**，首次失败完整日志未留存；**C/Qt 本地回归门 CONCERNS**。
- **path A 借壳 type 6 空 blob 误断链（N1 / §3.12）**：T-03 修复中，不得标完成。
- **【Rev.3 新增】教程承诺一致性收口未完成（N4 / §3.14 / R11）**：T-05 §4 的 8 处改写文本已合并进 §5.2，但**正式改写发布教程属 §6.2 人工审批、本轮未执行**；上线前须做「教程文案 ↔ 实现行为」对拍。
- **【Rev.3 新增】产品口径已裁定但落地未验（§5.3）**：四项决策采纳 A；裁定 ①②③④ 的 UI / 文案落地状态未逐项验收，**不得把「口径已裁定」写成「功能已交付」**。

**K3 · path A 成为默认前的硬前置（未解）**
- ① 11-08 PC `C0000005` 进战斗后 50~200s 崩于 `cb=081520D1`（`2026-11-08.md:934-937`），**未找到已修证据**，path A 头号阻塞。
- ② `sioFastFrame` 仅 PC/Qt 有，Android native 无等价实现（实测 4.6~4.9fps）；其 `sio_link.c:984-989` 三条件（sioOk≥256、gLink.state/playerCount/fieldCount 同时≥2）不能放宽。
- ③ 11-10 云端中继形态当年没跑通（停在「请稍候」、扫不到 MBL1 包头），跑通的是 P2P 直连。
- ④ ~ ⑥ **【Rev.3 改判】**：④ C0 能力协商位**已落地**（AUTO 默认 + `mode` 握手，⑦），不再列为「未上线」；⑤ 三端默认模式**已由 AUTO 对齐**，但 `gboy_official_link` 无 UI 复选框（Android 仅 `GBOY_LINK_MODE` 广播可达），且**默认策略变更仍属 §6.2 人工审批**；⑥ 空 blob 误断链（N1）修复中，须补门控后才可考虑把 path A 设为默认。

**K4 · 构建产物一致性缺口**
- `build-win/dist/test-gboylink.exe`（11-14 14:39）落后于 `build-win/qt/test-gboylink.exe`（11-15 04:44）；
- `build-win/qt/libmgba.dll`（11-14 23:04）≠ `build-win/libmgba.dll`（11-15 04:20）；重建 libmgba 后必须 `cp -f build-win/libmgba.dll build-win/qt/libmgba.dll`，否则测到旧二进制。

**K5 · 其他已知限制**
- 11-13「镜像核 `own=0000 / st=2 / pc=0`」卡点**只可能发生在 path B**（path A 无镜像核）；其决定性根因**至今无定论**——`MEMORY.md:103-104`「双向 TYPE_STATE 作废、卡点不在状态不同步」与 `2026-11-14.md:389-400`「按官方改双向 + DirectLink TYPE_FRAG 分片」互相矛盾，不要当已定论。
- WSS 隧道单条 ≤ 100 字符，整份状态须走 `DirectLink.cpp:563-616 TYPE_FRAG` 分片。
- 22 条 Swift 6 并发捕获警告（升 Swift 6 会变硬错误）；22 项移动端 / PC 替代实现仍待真机验证。
- 本地 stub 类型检查 0 error **漏检过**真实 UIKit 签名错误；Windows 上 `swiftc` 必须剥代理（`env -u HTTP_PROXY ... -u no_proxy swiftc`）。
- 推送纪律：本地 master 历史含约 2.4 万 tmp 文件，**禁止 push 本地 master、禁止 --force**；`.gitignore` 已含 `/.zcode-tmp/`、`/.workbuddy/`，那些 tmp 文件是被 `git add -f` 强加进去的。正确做法见发布控制清单 §6.1。
- **并发事实（Rev.3 核查）**：二次续作核查时工作区存在并发会话改动（3 个源码文件 `M`，`design/` / `docs/` / `production/` / `tests/` `??`），**本任务未触碰、未提交**；T-03 / T-04 / T-05 改动尚无提交哈希，故本日志续作与二次续作批次均不列哈希。

**K6 ·【Rev.3 补强】绝对地址判据在 ROM 会被重编译的前提下不可靠**
- `/d/gen8/rom.gba` 被并发会话重编译后，`battle_main.o` 地址整体 `+0x16E64`；任何写死的 `cb2` 精确值 / 区间常量（含 `0x08099848~0x080A30FC`、`0x0809AFCD`、`0x0809C089`）在新 ROM 上全部失效。
- **【Rev.3 新增】符号级证据进一步坐实**：新腿 `080B3169` = `rom.map:7204 BattleMainCB2 0x080b3168 +1`、旧腿 `0809AFCD` = `syms.txt:249127 0809afcd BattleMainCB2` ⇒ 判据应绑**符号**而非绝对地址。
- 影响：把「真进对战」误判为「未进」（K1），或把区间外地址误判为进对战；F19 判据（§3.6）、busgame 判据（§3.13）、历史落盘结论均可能失真；重编译随时可再发生。
- 缓解：判据改为**从当前 ROM 的 `.map` 动态解析 `battle_main.o` / `BattleMainCB2` 区间**；判据输出绑定 ROM md5 / mtime；**新旧 ROM 双腿复跑**；`.map` 缺失报 `STALE_BATTLE_WINDOW`；**禁用一切写死绝对地址的产品验收判据**。对应发布控制清单 §7 R8、§3.13。

**K7 ·【Rev.3 新增】AC1–AC6 口径分裂（同 N3 / R10）**
- AC1–AC6 是 **path B 语义**（依赖镜像核与整份 savestate）；2P 首选 **path A 无镜像核**且 `!m_officialMode` 门控不发整份 savestate。
- ⛔ **验收矩阵必须按 path A / path B 分列，禁止用 path B 的 AC 判 path A 的可用性**；T-04 分列进行中（未完成）。教程承诺 d 已按模式分别陈述（§5.2 D-1）。

**K8 ·【Rev.3 新增】通道级回退与架构级降级的口径区分（T-05 §4 承诺 g 消解结论）**
- **通道级 P2P 直连 → UDP 中继 / 服务器隧道回退属设计内允许**：不中断连接、不弹错误，但**状态栏如实显示当前通道与帧率**（裁定 ③ 三档 50 / 10 fps + 6 s 去抖，设计侧建议值待分端真机校准）。
- **架构级 path A ↔ path B 切换属禁止的静默降级**：会改变帧格式（20 字节 SIO 包 vs 按键帧），由 `mode` 握手隔离、不一致直接 fail。
- 两者**不冲突**；「帧格式完全一致」改为「**同一联机模式内**帧格式一致」。禁止把通道回退说成「加速」、把架构降级包装成「智能优化」。对应发布控制清单 §4.5 / §5.2 D-2。

---

## 发布门控引用

**判定：FAIL（限定「2P 云端交付门」）· 本冲刺不得建议放行。**
**C/Qt 本地回归门：CONCERNS（C 层低频 flaky 未隔离，18 次采样 1 次 `EXIT=1`）**——两门分列，禁止互相替代；禁止用 `6/6 PASS`、汇总 ok 数、单腿 `BATTLE=YES` 或「口径已裁定」代替分路径结论。
完整阻塞项、构建后必做清单、降级与回滚策略、用户可见限制、教程改写草案（含 T-05 §4 的 8 处合并文本）、产品口径已裁定段、**已知限制（Known Limitations，KL-1~KL-4）**、推送纪律与人工审批清单，见 `production/release/2p-link-release-checklist.md`（T-06 / RCL-2P-01 **Rev.4**）§3、§5（含 **§5.4 已知限制**）、§7 与 §8。
