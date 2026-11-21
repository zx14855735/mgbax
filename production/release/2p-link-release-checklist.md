# 2P 联机 · 发布控制清单（Release Control Checklist）

| 项 | 值 |
| --- | --- |
| 文档编号 | T-06 / RCL-2P-01（**Rev.9 · 2026-11-15 耗时上界 9.3 s + 用例 11/12 覆盖**） |
| 适用门 | **限定「2P 云端交付门」**（主判定）；**C/Qt 本地回归门单列为 CONCERNS**（分路径结论，不并入主判定） |
| 项目 | `D:\mgba-android-version` · mGBA 三端（PC Qt / Android / iOS）自研 GBoy 联机 |
| 编写 / 修订日期 | 2026-11-15（Rev.1 初版 → Rev.2 T-03/T-04 实跑修订 → Rev.3 二次续作收口 → Rev.4 B6 已知限制正式登记 → Rev.5 `--gatetest` 入关键回归套件 → Rev.6 KL-5 粒度收敛、`--c0` 入套件 → Rev.7 耗时与条数改为「以当次输出为准」 → Rev.8 补用例 11 覆盖与「4/7 早退 ≠ 11 判定」区分 → **Rev.9 耗时上界放到 9.3 s、补用例 12（短路先于重绑）覆盖并给出 11/12 分工**） |
| 依据 | `.workbuddy/memory/MEMORY.md` 顶部勘误、`2026-11-15.md` 末三章、两份教程用户可见承诺、`git log` / `git status`（只读核查）；Rev.2 追加 T-03 / T-04 实跑结论；Rev.3 追加 T-03 能力协商与 AUTO 默认落地结论、T-05 `design/gdd/2p-link-scope-review.md` §4（8 处教程改写建议）、`design/gdd/2p-link-ux-spec.md` 与四项产品决策裁定；Rev.4 追加 `ios/mGBA/GBoyConsoleSet.swift`、`src/platform/qt/CloudLink.cpp:2855` `resolveLinkMode`、`src/platform/qt/CloudLink.cpp:2925-2948` `allow_legacy`、`src/platform/qt/sio_link.c`；**Rev.5 追加：`src/platform/qt/test/gboylink_test.cpp`（`--gatetest` 实现与断言）；Rev.6 / Rev.7 / Rev.8 追加：本任务实跑 `build-win/qt/test-gboylink.exe --gatetest` 与 `--c0` 的落盘输出（均为当次记录、不作基准：`--gatetest` **约 8.7~9.3 s**、条数随补做持续增长（56 → 64 → 81…）；`--c0` 45 ok / 0 FAIL、约 0.2 s）** |
| 当前门控结论 | **FAIL（不得放行）**，详见 §8；**C/Qt 本地回归门：CONCERNS（C 层低频 flaky 未隔离）**，详见 §3.11 / §8 |
| 本轮动作性质 | 纯文档 / 只读核查：未修改任何代码、配置、构建脚本、测试文件、根目录教程；Rev.1–Rev.4 未执行任何 git commit / push / tag / 删除操作；**Rev.5 仅修改本文件并按主理人明确指令做一次本地 `git commit`（显式列路径，不 `-a` / 不 `add -A`；不 push、不 tag、不删除、不 `--force`）** |
| 文件归属 | 本文件仅落在 `production/release/` 下；不触碰 `src/**`、`android/**`、`ios/**`、`tests/**`、`docs/**`、`design/**`、`production/sprint-2p/**`、`.workbuddy/**` 及根目录任何文件 |
| 修订记录 | Rev.1 2026-11-15 初版；Rev.2 2026-11-15 按 7 条证据更新（6 自检闭环 / AC 部分缓解 / C 层 flaky / 空 blob 误断链 / busgame 判据假阴性 / 绝对地址判据风险 / 变更日志补记）；Rev.3 2026-11-15 按 6 条证据更新（AUTO 默认改判 / T-05 8 处教程文本合并 / R10 AC 口径分裂 / 产品口径已裁定 / 符号级证据 / flaky 18 次采样）；**Rev.4 2026-11-15 按 B6 新增 §5.4「已知限制（Known Limitations）」**：iOS 无 path A 与 2P 房间硬拒绝、AUTO 默认对 iOS 不友好及规避、会话级回退 vs 架构级降级（`allow_legacy` 定位）、四条未解除限制的边界声明；**Rev.5 2026-11-15 新增 `--gatetest` 进 §2.4 关键回归套件（含 PATH 前置坑与覆盖边界标注）、补 §5.4 KL-5（协商门 2 s 有界等待未在真实云端链路实测）**，**并修正 5 处「2P 云端 0 条断言」为分层口径（协商门层已有断言 / 数据通路端到端 0 条 / 跨设备真机 E2E 0 条）——本轮改判**；**Rev.6 2026-11-15 把 `--gatetest` 当次记录更新为 56 ok、新增 `--c0`（帧层，45 ok / 约 0.2 s）入 §2.4、把 KL-5 / R13 / §3.7 / §8 第 15 条的覆盖粒度由「未覆盖该分支」收敛为「未覆盖真实 WSS 会话下的端到端网络时序」、按现行代码行号更新依据文件**；**Rev.7 2026-11-15 修正耗时口径、删除先前误转述的耗时数字与「机器负载」错误归因，并把 `--gatetest` / `--c0` 的条数改为「以当次输出为准、不要写死」（当次记录值随补做持续变化，任何时点都可能已过期）**；**Rev.8 2026-11-15 把耗时收敛为「约 8.7~9.2 s」（多方实测 8.734 / 8.821 / 8.873 / 8.942 / 8.996 s，仅 4 处 2 s 有界等待）、补用例 11（强走 `peer == INVALID` 判定分支）的覆盖与变异证据、并明确「用例 4/7 绿是因顶部短路早退、INVALID 判定由用例 11 覆盖」不得合并；条数继续以当次输出为准（当次已 81 ok / 13 用例）**；**Rev.9 2026-11-15 把耗时上界放到「约 8.7~9.3 s」（12 个实测点合流；另有 12.4 s 一说经核为把窗口数误记为 5 处且未实测 wall clock，已作废）、补用例 12 `early exit before rebinding`（短路先于重绑的顺序断言，引入于 `0be5da192`）并与用例 11 明确分工、断言定位改为「用例名 + commit 短哈希」以免行号漂移** |

> **用法**：本清单是「放行前的物理执行清单」，不是状态声明。所有 `[ ]` 项必须由执行人实际跑命令、留落盘证据后勾选；**汇总「本地回归全绿」不得替代分路径结论**。
> **架构口径（Rev.3 更新）**：2P 首选 **path A**（每端 1 核 + SIO 包中继，P2P 直连优先）；**type 6 并存 + `mode` 能力协商隔离已落地**（AUTO 默认：2P→A、3/4P→B，PC / Android 同逻辑 `resolveLinkMode(playerCount)`）——type 1 握手 1 bit `mode`，不一致**直接 fail，禁止静默降级**。默认假设：**2P 仅 PC↔Android 可用，iOS 只支持 path B**。
> **Rev.3 口径铁律**：① `busgame-lockstep` 的 `BATTLE=NO` 已由**符号级证据**定位为判据假阴性，修复中，**判据动态化与新旧 ROM 双腿复跑完成前仍不得作为放行依据**（§3.13 / §7 R5 / §7 R8）；② **AC1–AC6 是 path B 语义，验收矩阵必须按 path A / path B 分列，禁止用 path B 的 AC 判 path A 的可用性**（§7 R10）；③ **通道级 P2P→隧道回退属设计内允许**，与**架构级 A↔B 禁止静默降级**不冲突，状态栏如实显示、不弹错误（§4.5 / §5.2）。

---

## §0 门控结论速览

> **【Rev.12 · C/Qt 本地回归门由 `CONCERNS` 升为 `PASS`】**
> **变更依据（三段证据，缺一不可）**：
> 1. **根因已定位并修复**：C 层低频 flaky 的唯一已知来源是内嵌中继握手写序竞态（见 **§5.4 KL-7**），
>    修复提交 `fdfc23290`（`remote_link.c` `+9/−2`）。已排除五种替代解释（半包 / 连错对端 / 网络抖动 /
>    端口冲突 / 双实例），见 KL-7。
> 2. **机理验证**：带 `[ORD]` 探针的隔离 worktree 构建——未修 14000 轮命中 12 次 → 修后 **0 次**；
>    独占端口未修 10000 轮 3 次（排除端口冲突）。**探针会改线程调度，此段仅证明机理，不等于产品验证。**
> 3. **真实时序验证**：主仓干净构建（无探针）**40 次 + 第三方独立执行 20 次 = 60/60 全绿**，
>    每次 `EXIT=0 / 252 ok / 0 skip / 中继协议不匹配=0 / 你是 2P=1`；且测试所用 exe md5
>    （`7810c2ce…`）与提交后重编 md5 **相同** ⇒ 结果与 `fdfc23290` 一一对应。
> 4. **静默降级路径已封死**：`MGBA_TEST_REQUIRE_ROM=1` 下「整组跳过」计入失败（`76dc6a2d9`），
>    不再存在「少跑 8 条断言仍打印 `mobile tests passed`」的假绿（见 KL-7 前的 SKIP 修复）。
>
> **本 PASS 明确不声称**（引用时不得省略）：
> - **不声称「已证明无 flaky」**——同一 exe（`7810c2ce…`）上 **60/60 全绿**（修复方 40 + 第三方 20）；
>   若真实复现率仍为约 1/40，60 次零命中的概率约 **0.22**。这是很强的证据，但**不是终局证明**。
> - **不声称「有确定性回归测试」**——该竞态依赖线程调度，现有 relay 用例只能**概率性**捕获它
>   （它确实捕获过，即 1/40 那次）；**未新增能确定性复现的断言**。
> - **不声称「线上联机行为已改变」**——全仓 `grep` 确认 `mobileRelay*` 的**唯一调用方是 `mobile_test.c`**，
>   该库**当前无生产调用方**。准确表述是「**库代码中的潜伏缺陷已修，但该库当前无生产调用方**」；
>   Android 真机走 `GBoyCloudLink`（KCP），不经过该 C 代码。
> - **墙钟不作为判据**：40 次中有 2 次离群（41.9s / 115.9s）但内容全过，判为主机层停顿（KL-7 有可复核依据）；
>   第三方 40 次（两批）**从未超过 13s**，未复现该离群 ⇒ **该离群是否系统性未定论，不得外推**。
>
> **对下文的影响**：本清单 Rev.3–Rev.11 段落中出现的「C/Qt 本地回归门 CONCERNS」「C 层低频 flaky 未隔离」
> 等表述均为**历史状态**（§3.11 / §7 R9 / §8 第 8 条），已被本块取代；**不要再据此拒绝放行 C/Qt 门**。
> **主判定（2P 云端交付门 FAIL）不受本变更影响** —— 两者分列，理由不同（见下一条）。

> **【2026-11-17 跨设备 2P 云端门 · 单列，不改变主判定】**
> 依据：`docs/architecture/ADR-004-cross-device-2p-cloud-closeout.md`、`tests/2p-cloud/AC1-AC6-验收矩阵.md` §0-D。
> 10 个并行 agent 冲刺的唯一目标是「跨设备 2P 云端进球场对打并稳定 60fps」。**本块只新增放行前置项，不声称任何跨设备闭环。**
> - **跨设备定义（缺一不算）**：两个不同云端账号 + 两个不同 game uuid（`uuid="BPEE,"+ROM md5`）+ 两台物理分开的设备/PC↔Android/iOS 端到端；先 app 作 host 等 `advertised relay ... for room <R>`，再起 PC `MGBAX_AUTOLINK`，之后不重启 app（`MEMORY.md:67-75`）。
> - **⛔ 本机两个 PC 实例经 P2P/回环的代理拓扑、本机 4 核 `busgame-lockstep`/`busgame-product` 的 `BATTLE=YES`，一律不算跨设备证据。**
> - **门状态（事实）**：跨设备 2P 云端 8 项证据（XD-1~XD-8，见 ADR-004 §3 / 矩阵 §0-D）全部缺位；所有云端 `flow_*.log` 的 `BATTLE` 计数全 0。**门维持 FAIL。**
> - **与 C/Qt 门状态的分歧未在本文裁定**：`MEMORY.md` §0 记 C/Qt = CONCERNS，本清单 Rev.12 块记 PASS；放行前须人工对账统一口径（ADR-004 §5 R-10-5）。**该分歧不影响 2P 云端门 FAIL。**

- **主判定：FAIL（限定「2P 云端交付门」）· 本冲刺不得建议放行**。所有 §3 未闭环项清零前，本清单不得签署 go。
- **分路径判定：C/Qt 本地回归门 `PASS`（Rev.12 起，原 CONCERNS 已解除，见上方 Rev.12 块）**。历史背景：曾 **18 次采样 1 次 `EXIT=1`** 且首次失败日志未留存，该 flaky 已在 Rev.12 定位为内嵌中继写序竞态并修复（KL-7，`fdfc23290`）。两门分列，**禁止用 C/Qt 本地结果代替 2P 云端结论**。
- **本轮（Rev.3）改判 / 新增——均不改变主判定**：
  - ✅ **默认模式不一致阻塞项改判**：T-03 已落地 **AUTO 默认 + `mode` 能力协商**（PC / Android 同逻辑 `resolveLinkMode(playerCount)`：2P→A、3/4P→B），PC 大厅下拉框（`LobbyView.cpp`，QSettings 持久化 `link_mode`）可 UI 自救；**Android 仅 `GBOY_LINK_MODE` ADB 广播可达（`gboy_link_mode` 持久化）、无 UI 复选框**；iOS 无 path A 且 2P 房间会**可见协商失败**（§1 / §3.7 / §8）。**「切换三端默认联机模式」仍保留在 §6.2 人工审批清单，本轮未执行**。
  - ✅ **产品口径已裁定**：T-05 四项决策全部采纳 A（§5.3），其中「切换默认模式」与「正式改写发布教程」仍属人工审批动作，**不得标为已执行**。
  - ◐ **教程改写草案收口**：T-05 §4 的 8 处建议文本已合并进 §5.2 并标注来源；**仅落在清单内，未改根目录教程**（§6.2 人工审批）。
  - ◐ **`busgame` 判据假阴性补强为符号级证据**，判据动态化四项进行中（§3.13 / §7 R5）。
  - ⚠ **新增风险**：R10 AC1–AC6 口径分裂（path B 语义 vs 2P 首选 path A）。
  - ⛔ **2P 云端断言按层分列（不再用未分层总括）**：① **协商门（连接期模式判定）**已有断言——`--gatetest` 直驱 `negotiateLinkMode()` 本体，五类判定全覆盖（条数以当次输出为准）；② **云端数据通路端到端**（`cloudTest` / `cloudPairTest`、注册帧与握手与按键与状态帧真正经中继到达对端、mock 中继）**仍为 0 条**；③ **跨设备真机 E2E 仍为 0 条**（所有云端 `flow_*.log` 的 BATTLE 计数全 0，§3.6）。**跨设备 E2E 未闭环**；C 层 flaky（§3.11）；空 blob 误断链（§3.12）；绝对地址判据不可靠（§7 R8）。（分层口径详版见 §2.4 / §3.3）
- **【Rev.4 新增 · 交付范围边界】§5.4「已知限制（Known Limitations）」**：KL-1 iOS 无 path A、与 PC / Android 组 2P 房间**协商失败并断开（设计内硬拒绝）**，iOS 目前只能与 iOS 组 3/4 人 B 模式房间；KL-2 AUTO 默认 2 人→A 对 iOS 不友好；KL-3 `allow_legacy` 为显式回落、**不建议用于交付**；KL-4 四条未解除限制（跨设备云端 2P 未闭环 / PC path A `C0000005` / `sioFastFrame` 仅 PC-Qt / 2P 局域网 ADB 零覆盖）。**该节是范围边界声明，不是待修 TODO，对外文案须按原文口径、不得弱化。**
- **【Rev.5 新增 / Rev.9 更新】`--c0` 与 `--gatetest` 已入 §2.4 关键回归套件**：`--c0`（帧层）对应「帧格式正确」；`--gatetest`（协商门本体）直驱 `CloudLink::negotiateLinkMode()` **本体**、覆盖五类判定 + INVALID 判定分支（用例 11）+ 短路先于重绑的顺序（用例 12）+ 等待时序语义 + 失败幂等。两者判据均为**全 PASS / 0 FAIL、`EXIT=0`**，**条数与耗时以当次输出为准、不要写死**（`--c0` 约 0.2 s、无需 ROM / 网络；`--gatetest` 耗时**约 8.7~9.3 s**，偏大是仅 4 处 2 s 有界等待、属预期；条数随补做持续增长，见当次输出）。⚠ 两者运行前都须把 `build-win` 与 `build-win/qt` 加进 `PATH`，否则 `exit 127`（`libmgba.dll` 加载失败，非测试问题）。⛔ **覆盖边界**：**真实 WSS 会话下的端到端网络时序未覆盖**（`sig->recv(60)` 真实行为与服务器推送节奏未实测，§5.4 **KL-5**）——**不得表述为「2P 协商门已验证通过」**。**分层口径（Rev.6 统一）**：**协商门层已有断言（判定 + 等待时序语义）/ 云端数据通路端到端 0 条 / 跨设备真机 E2E 0 条**（详版见 §2.4 / §3.3）。
- Blocker 未清不发布，除非用户明确豁免；豁免须书面留痕并列入 §6 人工审批清单。

---

## §1 一页三端口径对照表（Rev.3 更新默认模式）

| 维度 | PC（Qt / Windows） | Android | iOS |
| --- | --- | --- | --- |
| **默认 path（Rev.3 改判）** | **AUTO 默认**：`resolveLinkMode(playerCount)` **2P→A、3/4P→B**，与 Android 同逻辑。原 `CloudLink.cpp:611` 的「未设 `MGBAX_OFFICIAL_LINK` 即 A」已被 AUTO 取代；`flow.sh:101` 环境变量强拉仍属测试脚手架 | **AUTO 默认**：同一 `resolveLinkMode(playerCount)` **2P→A、3/4P→B**。原 `EmulatorActivity.java:5525-5526` `gboy_official_link=true` 恒 B 已被 AUTO 取代；path A 桥干净（`GBoyCloudLink.java:1469-1546` 不调 `sendInitialState`） | **完全没有 path A**（`ios/mGBA/*.swift` grep 零命中），仅 path B（本机 N 核 + 按键槽位路由）；**iOS 不参与 AUTO 的 2P→A 分支** |
| **两套默认是否一致（Rev.3 改判）** | ✅ 与 Android **默认已对齐**（同 `resolveLinkMode` + `mode` 握手隔离）；不一致直接 fail，不再静默同流。`CloudLink.cpp:608-610` 的 9470 碎片包事故由 `mode` 隔离防住 | ✅ 与 PC **默认已对齐**；不一致直接 fail | — 仅 B，2P 房间会**可见协商失败** |
| **type 6 语义** | 三端 `case 6 → loadStateFromMemory`（整份 savestate 逐槽灌镜像核）**与官方 APK 客户端一致，不是误做**（11-14 脱壳字节码 `NETPLAY_SPEC.md:69,84,90`），**不要全量改回 SIO 包中继**。type 6 三义并存：path A 的 SIO 包中继「借壳」type 6（20 字节 SIO 包）；`maybeSendInitialState()` 已加 `!m_officialMode` 门控，**path A 不再把整份 savestate 灌进 SIO 20 字节管道** | 同左：`GBoyConsoleSet.java:644-669` / `EmulatorActivity.java:2660`。**但本轮新发现借壳包误断链缺陷（§3.12 / R7，T-03 修复中）** | 同左：`LobbyLink.swift:192-218` / `GBoyConsoleSet.swift:286-310`；无 path A |
| **2P 是否可用** | path A **理论可用**，但头号阻塞 = 11-08 PC `C0000005` 进战斗后 50~200s 崩溃（`cb=081520D1`，`2026-11-08.md:934-937`）**未找到已修证据**；`sioFastFrame` 仅 PC/Qt 有 | path A **理论可用**；但 Android native 无 `sioFastFrame` 等价实现（实测 4.6~4.9fps），且 2P 云端跨设备 **从未闭环** | ❌ **不可用**（iOS 只支持 path B，2P 房间可见协商失败；需 macOS + Xcode 真机验证） |
| **UI / 模式切换入口（Rev.3 改判）** | ✅ **PC 大厅下拉框**（`LobbyView.cpp`，QSettings 持久化 `link_mode`）——**玩家可 UI 自救**；`MGBAX_OFFICIAL_LINK` 环境变量仍保留但不再是唯一入口。教程 `PC版完整使用教程.md:106` 的「启动前设环境变量」口径待改写（§5.2 承诺 d / g） | ⚠ **仅 `GBOY_LINK_MODE` ADB 广播可达**（`gboy_link_mode` 持久化），**无 UI 复选框**——普通玩家无法自救；另有「本机多核锁步」UI 开关与广播入口，但那是 lockstep 不是 `officialMode`，勿混为一谈 | 有 `link_use_lockstep` UI 开关（N 核路径），**仅 Swift 语法解析通过，真机 / Xcode 未验证**；按裁定 ④ 隐藏「改用兼容模式」入口 |
| **需要验证的入口** | `File → 联机大厅…`（云端，填房号 / 留空建房）+ **大厅模式下拉框**；`File → WiFi 联机…` 人数填 `2`（点对点）+ 勾「局域网精确 SIO 联机线」；`Tools → 联机直连传输（蓝牙 / TCP）…`；`Tools → Speed` 倍速档 | 菜单栏 **联机** → 上半部分「云端房间」；ADB `io.mgba.android.action.GBOY_LOCAL_LINK --ez host true --ei players 2`（**唯一 2 人局域网无头入口**）；**`GBOY_LINK_MODE` 广播**（模式切换）；`CLOUD` 广播（room 空 = host）；`adb logcat -s GBoyLink GBoySocketLink GBoyCloudLink mGBA`（`PEEK` 行）；**自检门禁 `:app:runLinkSelfTests`** | 需 **macOS + Xcode 真机**；编译门以 **CI 的 xcodebuild 为唯一权威**；本地仅 `ios/typecheck/typecheck.sh`（`swiftc -parse`） |
| **能力协商位（C0）· Rev.3 改判** | ✅ **已落地**：AUTO 默认 + type 1 握手 1 bit `mode`；不一致 fail + 玩家可见提示 | ✅ **已落地**（同逻辑）；剩余缺口 = 无 UI 复选框（§3.7） | 无 path A；**2P 房间会可见协商失败**，按裁定 ④ 隐藏「改用兼容模式」（§5.3） |

> **Rev.2 补充（path A 借壳 type 6 的接收侧差异，仍成立）**：PC `CloudLink.cpp:2367` 对状态帧有 `if (!state.isEmpty())` 保护；Android `GBoyLinkSession.onFrameBody` 的 `case TYPE_STATE` **无条件** `events.onState(stateOf(body))`。裸 20 字节 SIO 桥包被 `stateOf()` 判为空后仍派发，触发误断链（§3.12 / §7 R7）。这是**跨端实现不一致的缺陷**，不是设计差异，修复中。
> **编号映射说明（供主理人中转核对）**：二次续作指令第 5 条所称「R7 更新」按**内容**对应本清单 **R5（`busgame` 判据假阴性具体套件）** 与 **R8（绝对地址判据方法论）**，两条已按符号级证据更新；**R7 仍保持「path A 空 blob 误断链」编号不变**，以免破坏 §3.12 / §4.5 第 7 条 / 变更日志 N1 的交叉引用。

---

## §2 构建后必做清单（有序 · 可执行 · 每条含命令与通过判据）

> 顺序不可颠倒：**先同步产物，再重编，再跑回归**。产物不同步会把回归跑在旧二进制上，得到假绿。

- [ ] **2.1 DLL 同步（重建 libmgba 后必做）**
  - 命令：`cp -f build-win/libmgba.dll build-win/qt/libmgba.dll`
  - 通过判据：`cmp -s build-win/libmgba.dll build-win/qt/libmgba.dll` 返回 0（或两文件 sha256 一致），且 `build-win/qt/` 副本 mtime ≥ `build-win/` 原件。
  - 依据：`build-win/qt/libmgba.dll`（11-14 23:04）≠ `build-win/libmgba.dll`（11-15 04:20），不同步会测到旧二进制。

- [ ] **2.2 dist 测试程序同步**
  - 命令：`cp -f build-win/qt/test-gboylink.exe build-win/dist/test-gboylink.exe`
  - 通过判据：两处 `sha256sum` 一致；`build-win/dist/test-gboylink.exe` mtime 不再停留在 11-14 14:39（须 ≥ `build-win/qt/test-gboylink.exe` 11-15 04:44）。
  - 依据：`build-win/dist/test-gboylink.exe` 落后于 `build-win/qt/test-gboylink.exe`。

- [ ] **2.3 重编测试程序**
  - 前置：`taskkill /F /IM test-gboylink.exe`（运行中的 exe 会导致链接 `Permission denied`）；`export PATH="/c/msys64/mingw64/bin:$PATH"`（缺此 PATH 时 ninja 报 FAILED 但无 diagnostic，实为 `cc1plus` 起不来）。
  - 命令：`ninja -C build-win test-gboylink`
  - 通过判据：`EXIT=0`，且输出无 `FAILED`。

- [ ] **2.4 关键回归套件**
  - 命令（逐条）：
    ```
    ninja -C build-win mgba-qt
    build-win/qt/test-gboylink.exe frames
    build-win/qt/test-gboylink.exe buslocal
    build-win/qt/test-gboylink.exe product-lockstep
    build-win/qt/test-gboylink.exe --c0          # 帧层：期望 全 PASS / 0 FAIL，约 0.2 s
    build-win/qt/test-gboylink.exe --gatetest   # 协商门本体：期望 全 PASS / 0 FAIL，约 8.7~9.3 s（仅 4 处 2 s 有界等待属预期）
    mgba_mobile_test --bus               # CI 脚本 tests/2p-cloud/ci-netplay-selfcheck.sh 的 3 modes 之一
    mgba_mobile_test --link              # 同上
    mgba_mobile_test --dual              # 同上
    ```
  - ⚠ **`--gatetest` 与 `--c0` 运行前都必须把 `build-win` 与 `build-win/qt` 加进 `PATH`**（两者都动态链接 `libmgba.dll`，否则加载失败）：
    ```
    export PATH="$PWD/build-win:$PWD/build-win/qt:$PATH"
    ```
    **不加 PATH 直接跑会 `exit 127`**，报 `error while loading shared libraries: libmgba.dll: cannot open shared object file: No such file or directory`——**这是环境问题，不是测试坏了**。本机实测复现过该现象（不加 PATH = `EXIT=127`；加 PATH 后正常）。
  - ⚠ **并发构建期间不要跑本套件**：若 `test-gboylink.exe` / `libmgba.dll` 在运行中被重建，会出现 **`EXIT=1` 且日志中途截断**（本机实测遇到一次：`EXIT=1`、710 ms、日志仅 17 行停在用例 2；原因 = exe mtime 由 15:54 变为 15:58，且 `build-win/qt/libmgba.dll`(15:55) 落后于 `build-win/libmgba.dll`(15:58)）。**这不是测试失败**：先按 §2.1 同步 DLL、确认产物 mtime 稳定，再重跑。
  - 通过判据：`frames` / `buslocal` / `product-lockstep` 全 `EXIT=0`；`--c0` 与 `--gatetest` **全 PASS / 0 FAIL**、`EXIT=0`；C 套件 `--bus` / `--link` / `--dual`（CI 脚本的 3 modes）全 `EXIT=0`、0 FAIL（条数以当次输出为准）。
  - **断言条数与耗时口径**：两者条数**都会随补做变化**，因此**只以「全 PASS / 0 FAIL」为判据，条数以当次输出为准**；下列数字**仅为本机当次记录、不作为基准写死**：
    - `--c0`（帧层）：判据 = **全 PASS / 0 FAIL、`EXIT=0`**；条数与耗时**以当次输出为准、不要写死**（Rev.6 当次记录 `c0 tests passed (45 ok / 0 FAIL)`、约 0.2 s，无需 ROM / 网络）。
    - `--gatetest`（协商门本体）：判据 = **全 PASS / 0 FAIL、`EXIT=0`**；断言条数与用例数**以当次输出为准、不要写死**（条数随补做持续增长：40 → 56 → 64 → 76 → 81…，用例数亦在增，故本清单不写死具体数字）。耗时**约 8.7~9.3 s**（多方实测：8.734 / 8.794 / 8.821 / 8.873 / 8.880 / 8.942 / 8.951 / 8.978 / 8.996 / 9.020 / 9.101 / 9.248 s）。**⚠ 耗时偏大是设计使然、不是卡死**：全部用例中只有 **4 处 2 s 有界等待**（用例 3 `undeclared+allow_legacy`、用例 5 `baseStateCount=1`、用例 5b、用例 8 `instant pump`，合计约 8.03 s），其余亚秒。**若耗时跌到 1~2 s 反而应怀疑 F7 回归（等待窗口被缩水）**；**若出现 ~12 s 量级则说明多出了 2 s 窗口（约 6 处才会到 12 s），同样应复查**（注：曾有一份报告给出 12.4 s，经核为把窗口数误记为 5 处且未实测 wall clock，已作废）。
  - **分工表述（不要合并成一句「C0 已验证」）**：`--c0` 对应「**帧格式正确**」（`linkModeOf()` 六类输入、`registerFrame()` 与官方 16 字节逐字节一致、3 参数只在多人房写 `wire[15]`、AUTO 映射与 override）；`--gatetest` 对应「**协商门会拒绝冲突**」（五类判定 + 等待时序语义）。两者是两件事，**任一者的全绿都不等于 C0 整体已验证**。
  - **`--gatetest` 覆盖边界（不得表述为「协商门已全部验证」）**：
    - ✅ **已覆盖（判定）**：直接驱动 `CloudLink::negotiateLinkMode()` **本体**（不是只断言纯函数），读取真实的 `m_closed` / `m_officialMode` / `m_linkMode` / `m_peerLinkMode` / `m_modeRejected` 与真实 emit 的状态文案；覆盖协商门五类判定结果——① 两端 A（2P）通过且 `officialMode==false`；② A vs B 拒绝并断链、文案含「本机=」「对端=」「MGBAX_LINK_MODE=A|B」；③ 对端 2 参数官方帧 + `allow_legacy` 回落 B、文案含「警告」「回落」且不含「畸形」；④ 能力位 `0x42` 拒绝、含「畸形」、`peerMode==INVALID`（F8 回写生效）；⑤ 1 人房 + `baseStateCount=1` 走「未声明」而非「畸形」（F12 回归），加 `allow_legacy` 则回落 B。另含 3P + AUTO（门内解析为 B）与 `0xFF` + `allow_legacy=true`（**仍拒绝**、不含「回落」）。
    - ✅ **已覆盖（第二道锁 / INVALID 判定分支 / 短路先于重绑）**——**用例 11 与用例 12 分工，勿混为一条**：
      - **用例 11 `11) forced INVALID`（`gboylink_test.cpp`，引入于 commit `f355bd59f`）**：强制走进 `negotiateLinkMode()` **自身**的 `peer == INVALID` 分支（该分支在生产与旧测试里**一次都没被执行**——INVALID 经 `notePeerLinkMode()` 进来时已置 `modeRejected`、顶部短路先返回，故必须先清掉 `modeRejected` 才能到达）；断言覆盖「拒绝 + `fail()` 断链 + 由**本分支自身**置 `m_modeRejected` + 文案含「能力位畸形」且**无「来源」**（证明确实来自 `negotiateLinkMode()` 而非 `notePeerLinkMode()`）+ 只发一条失败文案 + `peer` 保持 INVALID」。**证明这条分支不是死代码。** 变异验证：把该分支改成 `return true` → **只有用例 11 变红**，其余全绿。
      - **用例 12 `12) early exit before rebinding`（引入于 commit `0be5da192`）**：钉**顺序**——本端 AUTO（2 人房本应 A）→ 用探针把已绑定模式手工置为 **B** → 喂 `0x42` 畸形（`notePeerLinkMode()` fail + 置 `m_modeRejected`）→ 调真实协商门；断言「拒绝 / `m_modeRejected` 已置位 / 只有 1 条失败文案 / **`linkMode` 仍是 B（未被静默重解析成 A）** / `peerMode == INVALID`」。变异验证：把「绑定本端模式」的 4 行挪到 `if (m_modeRejected) return false;` **之前**（一次典型的「顺手重排」重构）→ **其余用例全绿、只有用例 12 变红**。**证明「顶部短路先于重新绑定」这个顺序是被钉住的，不是巧合。**
      - ⛔ **口径区分（勿合并成一句）**：**用例 4 / 7 绿是因为「顶部短路早退在，所以轮不到判定」**——用例 7 的断言原文即「`m_modeRejected` set by the **early exit**」，它证明的是早退这条防线有效，**不是**「INVALID 判定分支不放行」；**INVALID 判定本身由用例 11 覆盖、短路与重绑的顺序由用例 12 覆盖**。若把三者写成一句「4 号能力位不放行」，将来有人删掉顶部短路或重排那 4 行时，会被这几条绿断言误导。
      - **定位建议**：断言位置写 `用例名 + commit 短哈希`（如 `12) early exit before rebinding` @ `0be5da192`），**不要只写行号**——测试文件仍在补做，行号会持续漂移（本清单已因此踩过两次）。
    - ✅ **已覆盖（等待时序语义）**：`m_session == nullptr` 时走 `waitAndProcess()` 分支，实测静默等待 **2001~2017 ms**、能力位就位时 0~2 ms；`m_session` 可用时的 `drainSignaling()` 分支**其等待时序语义**已由用例 8/9/10 以注入泵（`m_gatePump`，生产恒为空）覆盖——用例 8 泵立即返回 0 ms 且永不设对端模式 → 等待仍 **2011 ms**（**钉死 F7**：泵提前返回不再把 2 s 缩成约 1.2 s）；用例 9 第 3 轮才设对端能力位 → **322 ms** 提前退出且 `accepted`（**钉死 B1**：晚到 hello 能等到）；用例 10 第 2 轮 `m_closed` → **104 ms** 立即退出、不硬等；外加上界不变量「所有用例最坏等待 ≤ 2400 ms」（实测 2012~2017 ms，用例数随补做增长、此处不写死个数）。
    - ⛔ **未覆盖**：**真实 WSS 会话下的端到端网络时序**——`drainSignaling()` 内部 `sig->recv(60)` 的真实行为、真实服务器的推送节奏，**均未实测**；需活账号 + 房间，或把 `GbCloud::Session` 抽成可注入接口。**注入泵覆盖的是时序语义，不是真网络**（对应 §5.4 KL-5）。
    - **F8 与 F12 的因果归属（勿混成一条）**：④ 中的 `peerMode==INVALID` 回写 **是「状态可观测性」修复（F8，已修）**，**不是**挡住「畸形被 `allow_legacy` 放行」的那道锁——真正的锁是紧随其后的 `m_modeRejected.exchange(true)` + `negotiateLinkMode()` 顶部 `if (m_modeRejected) return false;` 短路（见 `CloudLink.cpp:2875-2882` 的 F8 注释与 `:2901,2922,2931,3004,3031`）；变异实验（去掉回写重编）只红用例 4 的「INVALID is written back」，用例 7「畸形 + `allow_legacy` 仍拒绝」照旧绿。**真正「可能静默走错路径」的是 F12**（单人房 `body[11]` 是 baseStateCount 而非能力位，`0x40/0x41` 尾字节会被读成「两端都声明且一致」直接放行），PC / Android 两端均已修 + 断言钉住（用例 `4) cap 0x42` 的「INVALID is written back」与 --c0 中「1 人房尾巴 0x40/0x41 必须 UNKNOWN」那组断言；行号随补做漂移，建议按用例名 + commit 短哈希定位）。⇒ **「不静默降级」的结论成立，但理由要落在 `m_modeRejected` 短路；不要把 F8 写成「可能导致静默放行」。**
  - ⚠ **Rev.3 flaky 约束（采样数更新）**：`mgba_mobile_test` **18 次采样出现 1 次 `mobile tests failed / EXIT=1`、17 次 `mobile tests passed / EXIT=0`**，属**低频 flaky**，首次失败完整日志未留存。**单次全绿不足以判定干净**；须按 §3.11 扩大采样、留存失败日志、隔离 flaky 后，本项才可作为干净 CI 信号。**C/Qt 本地回归门本轮为 CONCERNS，不是 PASS。**
  - `test-gboylink busgame-lockstep`：**只允许用** `bash tools/busgame-lockstep.sh`（固定 `BUSGAME_FRAMES=9000`、`TIMEOUT=260000`、`MODE_DOWNS=2`、`MENU_AT=1500`、`HSL=1`、`LOGLEVEL=0` + 每次复制 `tmp_bus/rom.sav` 存档母本到独立目录，杜绝共享 `D:/gen8/rom.sav` 被回写污染）。
  - 通过判据（**Rev.3 口径**）：产出可重复的诊断输出即可；**它是 long/flaky 诊断套件，不是绿灯用例**。两次实跑（4m20s / 4m37s）报 `BATTLE=NO / 080B2EED / battleSamples=0`，**根因已由符号级证据定位为判据假阴性（§3.13 / §7 R5）：游戏实际进了对战，`gboylink_test.cpp:2693-2700` 把 `battle_main.o` 区间写死成旧 ROM 常量**。判据动态化与新旧 ROM 双腿复跑验证完成前，**不得以 `BATTLE=NO` 判定架构失败，也不得把任何一条腿的 `BATTLE=YES` 当作放行依据**。
  - ⛔ **验收矩阵必须按 path A / path B 分列**（§7 R10）：不得用 path B 的 AC1–AC6 判 path A 的可用性；T-04 正在分列，完成前本项不得勾选为「验收完成」。

- [ ] **2.5 Android javac / Gradle 自检门禁（Rev.2 已闭环，命令已替换）**
  - **门禁命令（唯一权威）**：
    ```
    cd android && ./gradlew :app:runLinkSelfTests --offline --console=plain
    ```
    配套任务：`:app:compileLinkSelfTests`（编译）+ 6 个 `:app:runLinkSelfTest_<Class>`（单类执行）+ `:app:runLinkSelfTests`（聚合）。
  - 通过判据：`BUILD SUCCESSFUL` / `EXIT=0` / 13~16s / 输出含 **`runLinkSelfTests: 6/6 PASS`**。
  - 辅助命令（仍建议执行，但非自检门禁）：`javac -encoding UTF-8 <classpath> GBoyLinkSessionTest.java GBoySocketLinkTest.java`；`gradlew :app:assembleDebug`；`gradlew :app:externalNativeBuildDebug` → 均 `EXIT=0`。
  - ⛔ **门禁请用 `runLinkSelfTests`，不要用 `testDebugUnitTest`**：`:app:testDebugUnitTest` 仍不可用（0 个 `@Test`、无 `testImplementation`、离线缓存无 `junit:junit`），发现不到任何测试；**不得把它报成「自检通过」或「零失败」**。
  - 环境注意：Gradle 9.3.1 已移除 `Project.javaexec()`，自检任务须以 6 个 `JavaExec` + 聚合任务实现（3 个接入实跑坑见 `CHANGELOG-2p-link.md` 续作条目 ⑤）。本地 JVM classpath 缺 `android.util.Log` 时后台重连线程会打印 `NoClassDefFoundError`，属环境问题、**非断言失败**，需与真实 FAIL 分列。

- [ ] **2.6 iOS xcodebuild**
  - 命令：以 CI 的 `xcodebuild` 为准；本地仅 `bash ios/typecheck/typecheck.sh`（Windows 上须 `env -u HTTP_PROXY ... -u no_proxy swiftc`，否则 `Fatal error: Duplicate values for key ProcessProperty("http_proxy")`）。
  - 通过判据：**新 CI job 全绿且 `runtime check` 实际执行**；本地 stub typecheck 判据为 `exit 0 / 0 error / 90 warning / 31s`。
  - **硬口径**：本机无 MSVC/UCRT 头，连 Foundation/Dispatch 都编不了；**stub 类型检查漏检过真实 UIKit 签名错误**（iOS CI #65 的 `EmulatorViewController.swift:6474:71` 多余尾随闭包，`DebugViewers.showHub` 不接受闭包）。**编译门以 CI 的 xcodebuild 为唯一权威**，本地 0 error 不得作为编译通过证据。

---

## §3 放行前置清单（质量门 FAIL 阻塞项 → 可勾选项）

> 每一项都必须有落盘证据（日志 / 截图 / 断言输出 / CI job 链接）才能勾选。**禁止用「本地回归全绿」汇总数字代替以下分路径结论。**
> **状态图例**：`[x]` 已闭环（有实跑证据，移出阻塞）；`◐` 部分缓解 / 已改判但仍有缺口（不得标完成）；`[ ]` 未闭环。

- ◐ **3.1 AC1–AC6 自动断言补齐**（Rev.2 **部分缓解**；Rev.3 **新增口径分裂约束**）
  - AC1 互发一次即时存档 / AC2 只灌隐藏核 / AC3 载入不复位 / AC4 不冲掉可见核进度 / AC5 载入失败断链 / AC6 复位联动。
  - **本轮 T-04 新增 4 组纯 JVM 协议层断言并实跑通过**：`typeSixStateFrameRoundTrip`、`typeSixRejectsRawSioBridgePacket`、`typeSixRejectsTruncatedAndIllegalLengths`、`protocolNumbersGuardAgainstReadyDrift`。
  - ⛔ **端到端断言仍为 0，不得标完成**：以上 4 组是**协议层纯 JVM 断言**，不覆盖三端 `loadStateFromMemory` 落地、可见核进度保护、复位联动的端到端行为，也不是 2P 云端路径断言。
  - ⛔ **【Rev.3 新增口径分裂约束】验收矩阵必须按路径分列，禁止用 path B 的 AC 判 path A 的可用性**：AC1–AC6 是 **path B 语义**（互发整份 savestate 给隐藏镜像核）；2P 首选 **path A 无镜像核**，且 `!m_officialMode` 门控**明确不发整份 savestate**。T-04 正在把验收矩阵按 path A / path B 分列。分列完成前，AC1–AC6 不得作为 path A 的放行判据（§7 R10）。
  - 剩余判据：AC1–AC6 六条各有独立端到端自动断言且在 CI/构建中可执行；附 `GBoyFrames.cpp:72-84` 三语义互斥断言；path A 侧另立对应验收项（不交换存档 / 帧格式隔离 / 失败即断链）。

- [x] **3.2 Android 6 个 plain JVM 自检接入 Gradle**（Rev.2 **已闭环，移出阻塞**）
  - ✅ 实跑证据：`cd android && ./gradlew :app:runLinkSelfTests --offline --console=plain` → `BUILD SUCCESSFUL` / `EXIT=0` / 13~16s / **`runLinkSelfTests: 6/6 PASS`**。
  - ⛔ **门禁请用 `runLinkSelfTests`，不要用 `testDebugUnitTest`**：后者仍不可用（0 个 `@Test`、无 `testImplementation`、离线缓存无 `junit:junit`），不得作为门禁或报成通过。

- [ ] **3.3 2P 云端 mock 回归**（**Rev.5 部分缓解：协商门层已有断言，数据通路层与真机 E2E 仍为 0 条**）
  - 判据：存在覆盖云端房间建/入房、按键中继、状态中继、断链重连的自动断言，且能在无真机环境下稳定重跑。
  - **判据按层分列（Rev.9 口径）**：① **协商门（连接期模式判定）**——`--gatetest` 直驱 `negotiateLinkMode()` 本体，覆盖五类判定 + INVALID 判定分支（用例 11）+ 短路先于重绑的顺序（用例 12）+ 等待时序语义 + 失败幂等，**条数与耗时以当次输出为准、不要写死**（条数随补做持续增长：40 → 56 → 64 → 76 → 81…）；② **云端数据通路端到端**（`cloudTest` / `cloudPairTest`、注册帧与握手与按键与状态帧真正经中继到达对端、mock 中继）—— **0 条**；③ **跨设备真机 E2E** —— **0 条**，所有云端 `flow_*.log` 的 BATTLE 计数全 0。（分层口径详版见 §2.4 / §3.3）
  - ⛔ 4 组协议层断言**不构成数据通路断言**；**数据通路层仍为 0 条**，本项继续列阻塞、`[ ]` 不勾选。

- [ ] **3.4 iOS 新 CI job 验证**（iOS CI #65 缺新 job，上次 job 在 build 步骤终止，runtime check 从未执行）
  - 判据：新 job 通过 `xcodebuild` 编译并执行 runtime check；`EmulatorViewController.swift:6474:71` 尾随闭包问题在远端 main 源码侧消除须由新 job 实证。

- [ ] **3.5 真机 Playtest**（AVD 4P/2P 均 59.7fps 已过，但**真机过游戏 UI 进对战未做**）
  - 判据：真机走完游戏内联机房间流程并进对战；记录机型、OS、fps、错误数。**并按 §5.3 决策 ③ 分端校准帧率三档阈值**。

- [ ] **3.6 跨设备 E2E 落盘 logcat + 双端截图 + 全量 PEEK**（所有云端 `flow_*.log` 的 BATTLE 计数全 0，未闭环）
  - 判据（F19）：`gMain.callback2 @0x020290E8` 落在 **`battle_main.o` 区间**、**`BATTLE=YES 计数 > 0`**，且落盘 `adb logcat` + 双端截图 + 全量 `PEEK`。
  - ⚠ **判据口径修正**：旧常量区间 `0x08099848~0x080A30FC` / 精确值 `0x0809AFCD` **仅对旧 ROM 有效**。`/d/gen8/rom.gba` 已被并发会话重新编译（md5 `074cfcdb…`、mtime 13:51:30），`battle_main.o` 地址整体平移 `+0x16E64`。**判据必须从当前 ROM 的 `.map` 中取 `battle_main.o` 的 `.text` 区间**，不得沿用写死的绝对地址（§7 R8）。
  - 口径：`MEMORY.md` 顶部勘误已判定「跨设备云端 2P 已闭环」不成立；「房间 830480 BATTLE=YES 连续 20 个采样」无落盘 logcat 佐证，**不得据此跳过产品化**。本机诊断腿进对战 ≠ 跨设备云端闭环。

- ◐ **3.7 C0 能力协商位 / 默认模式一致性（Rev.3 改判：已落地，剩余可达性缺口）**
  - ✅ **已落地**：AUTO 默认 `resolveLinkMode(playerCount)`（2P→A、3/4P→B，PC / Android 同逻辑）+ type 1 握手 1 bit `mode`（不一致 fail、禁止静默降级）；PC 大厅下拉框（`LobbyView.cpp`，QSettings `link_mode`）；Android `GBOY_LINK_MODE` ADB 广播（`gboy_link_mode` 持久化）。
  - ⛔ **剩余缺口（仍列阻塞，不得标完成）**：① **PC 可 UI 自救，Android 仅 ADB 广播可达、无 UI 复选框**，普通玩家无法自救；② **iOS 无 path A 且 2P 房间会可见协商失败**，按裁定 ④ 须隐藏「改用兼容模式」；③ 失败对话框内 S3 **分平台可执行步骤 + 一键复制命令**（裁定 ① 采纳 A，零新增产品代码）待落地；④ `mode` 仍不一致时「重试」须置灰并给原因。
  - ◐ **【Rev.5 新增 / Rev.9 更新】协商门已有成体系的自动化断言，但覆盖仍不完整**：`--gatetest` 直驱 `CloudLink::negotiateLinkMode()` 本体，覆盖**五类判定结果**、**INVALID 判定分支**（用例 11，此前在生产与旧测试中从未被执行）、**短路先于重新绑定本端模式的顺序**（用例 12，把绑定 4 行挪到短路前会让本端模式被静默改写 B→A，只有用例 12 变红）、**等待时序语义**（用例 8/9/10 注入泵覆盖提前返回 / 晚到 / 中途 close）与**失败幂等**（第二次调用短路、不重复 emit）；命令与边界见 §2.4。**条数以当次输出为准**（40 → 56 → 64 → 76 → 81…，仍在增长）；另 `--c0` 覆盖帧格式（当次 45 ok）。**但真实 WSS 会话下的端到端网络时序未覆盖**，2 s 有界等待未在真实云端链路实测（§5.4 KL-5）。⇒ **不等同于「协商门已全部验证」，本项仍为 `◐`，不改变阻塞状态。**
  - ⛔ **「切换三端默认联机模式」仍保留在 §6.2 人工审批清单**（高影响动作，本轮未执行）；AUTO 默认的代码落地不等于默认策略变更获批。

- [ ] **3.8 PC `C0000005` 崩溃复现与修复**（**未找到已修证据**）
  - 判据：path A 进战斗后持续运行 ≥ 300s 无崩溃（`cb=081520D1` 处）；附复现/回归日志。

- [ ] **3.9 `sioFastFrame` 移植 Android native**（仅 PC/Qt 有，Android 实测 4.6~4.9fps）
  - 判据：Android native 达到可玩帧率；`sio_link.c:984-989` 三条件（sioOk≥256、gLink.state/playerCount/fieldCount 同时≥2）不得放宽。

- ◐ **3.10 三端默认模式对齐 + 产物一致性同步（Rev.3 改判）**
  - ✅ **默认模式对齐部分已落地**：AUTO 默认同逻辑（§3.7）；剩余 = Android 自救可达性、iOS 可见协商失败处理。
  - ⛔ **产物一致性同步仍未完成**：§2.1 / §2.2 两项 `cp -f` 同步须完成并留哈希证据。
  - ⛔ 默认策略的进一步变更仍属 §6.2 人工审批。

- [ ] **3.11 C 层低频 flaky 未隔离（Rev.3 采样数更新 · 直接导致 C/Qt 门降级）**
  - 事实：`mgba_mobile_test` **18 次采样 1 次 `mobile tests failed / EXIT=1`、17 次 `mobile tests passed / EXIT=0`**（低频 flaky）；**首次失败完整日志未留存**。T-04 正在扩大采样定位。
  - 判据：连续多次采样全绿且**失败可复现、根因定位、修复或隔离**；留存每次完整日志（含失败那次）；`mgba_mobile_test` 重新成为确定性用例。
  - ⛔ **flaky 隔离前不得作为干净 CI 信号，C/Qt 本地回归门 CONCERNS**。禁止用「17 次通过」的多数结果掩盖 1 次失败，禁止用 C/Qt 本地结论替代 2P 云端结论。

- [ ] **3.12 path A 借壳 type 6 的空 blob 误断链（T-03 修复中）**
  - 事实链：`GBoyLinkSession.onFrameBody` 的 `case TYPE_STATE` **无条件** `events.onState(stateOf(body))`；而 PC `CloudLink.cpp:2367` 有 `if (!state.isEmpty())` 保护。裸 20 字节 SIO 桥包被 `stateOf()` 拒绝为空后仍派发 → `applyRemoteState(empty)` 返回 `STATE_ERROR(1)` → `EmulatorActivity.close()` **断链**。
  - 状态：**修复中**，已指派 T-03 修 main 侧，**不得标完成**。
  - 判据：补空 blob 门控（对齐 PC 的 `!state.isEmpty()`）并落自动断言；与 §3.1 的 `typeSixRejectsRawSioBridgePacket` 协议层断言形成端到端闭环（§7 R7 / §4.5 第 7 条）。

- [ ] **3.13 `busgame-lockstep` 判据假阴性修复 + 新旧 ROM 双腿复跑（Rev.3 补符号级证据 · T-03 修复中）**
  - **改判**：两次 `BATTLE=NO / 080B2EED` → **判据假阴性（符号级证据坐实），修复中**；不是架构失败、不是存档/并发负载差异。
  - **A/B 证据（Rev.2）**：`/d/gen8/rom.gba` 被并发会话重新编译（md5 `074cfcdb…`、mtime 13:51:30），与 `tmp_bus/rom.gba` 在 **23,246,794 / 33,554,432 字节**处不同；两次 `cb2trace` 30 条非零项**全部均匀 `+0x16E64`**，且 **`080B2EED − 0809C089 = 0x16E64`**；`/d/gen8/rom.map:7199` `.text 0x080b19e4 0x98b4 src/battle_main.o` 包含 `080B2EED`；**旧 ROM 腿实跑 `BATTLE=YES / 0809AFCD / battleSamples=3387 / battleFrames=[3077,4668]`**。
  - **【Rev.3 新增】符号级证据（T-03）**：新 ROM 腿 **`lastCb2=080B3169` = `rom.map:7204 BattleMainCB2 0x080b3168` +1**（Thumb 指针 +1）；旧 ROM 腿 **`0809AFCD` = `syms.txt:249127 0809afcd BattleMainCB2`**。⇒ 两腿的 `cb2` 都精确落在各自 ROM 的 **`BattleMainCB2` 符号**上，直接证明「游戏进了对战」，判据误报与地址平移无关、与符号绑定有关，进一步坐实 R8「绝对地址判据不可靠」。
  - 根因：`gboylink_test.cpp:2693-2700` 把 `battle_main.o` 区间**写死成旧 ROM 常量**；判据修复已裁决给 T-03。
  - **【Rev.3 新增】判据动态化四项（T-03 进行中）**：① 从当前 ROM `.map` 取 `battle_main.o` / `BattleMainCB2` 区间；② **判据输出绑定 ROM md5**；③ **新 ROM 腿 + 旧 ROM 腿双腿复跑验证**；④ **`.map` 缺失时报 `STALE_BATTLE_WINDOW`**（不得静默沿用旧常量）。
  - ⛔ **修复与新旧 ROM 双腿复跑验证完成前，仍不得作为放行依据**。旧 ROM 腿的 `BATTLE=YES` 只证明判据假设，不证明跨设备 2P 云端闭环（§3.6）。
  - 关联风险：§7 R5（具体套件）、§7 R8（绝对地址判据方法论）。

- [ ] **3.14 教程承诺一致性收口（Rev.3 新增 · 文本已合并，正式改写属人工审批）**
  - 事实：T-05 `design/gdd/2p-link-scope-review.md` §4 逐条核对 7 条产品既有承诺，给出 **8 处改写落点**（§4.3 清单）；文本已合并进本清单 §5.2，**未改根目录教程**。
  - 判据：经人工审批后由文档负责人落地；上线前做一次「教程文案 ↔ 实现行为」对拍；**不得写「已闭环」「2P 可用」**（§5.1 #6）。
  - ⛔ **教程正式改写发布仍属 §6.2 人工审批动作，本轮未执行**。

- [ ] **3.15 跨设备 2P 云端 8 项证据（2026-11-17 新增 · 10-agent 冲刺放行前置，全部未闭环）**
  - 判据（必须**同一次真实跨设备 E2E** 同时满足，绑定 commit + 二进制 md5 + 落盘日志；详版见 ADR-004 §3 与矩阵 §0-D）：
    - XD-1 两端 `[diag]` 同时 `lstate=4 && pc=2 && st` 含 `MASTER(0x20)`、无 `0x7F000` 错误位、持续 ≥5s 不回退；
    - XD-2 `gMain.callback2` 落在**当前 ROM `.map` 动态解析**的 `battle_main.o .text`（禁写死旧区间），`BATTLE=YES && battleSamples>0`，绑定 ROM md5，`.map` 缺失报 `STALE_BATTLE_WINDOW`；
    - XD-3 两端进球场对打后 fps 贴 59~60（≥50），app `adb logcat` 有 `SIO fast on` 与递增 `n=`；
    - XD-4 `summary.txt` 中 `via=p2p`（`rtt_A`/`rtt_B`）且 `peerCandidates_A>0 && peerCandidates_B>0`；
    - XD-5 `mode_negotiated_A=A && mode_negotiated_B=A && official_mode_A=False && official_mode_B=False && nav_at_leak=False`（2P path A）；
    - XD-6 `linkup_s` 非「未到LINKUP」、`rem=1`、`brs=0101`、`n8>0`（勿用 brs 判「块没到」）；
    - XD-7 两账号脱敏记录 + 两 ROM md5 不同 + `advertised relay ... for room <R>` + 双端设备标识；
    - XD-8 commit + 二进制 md5 + 源码 md5 + 落盘日志路径绑定，`EXIT=0`，两次独立复核一致。
  - **反判据（出现任一不得勾选）**：`lstate=1 pc=0 intr=0`（`CpuFill32` 复位）、`st` 含 `0x7F000` 错误位、`linkup=1` 但 `role=im0/lid0/hs0`（残留值陷阱）、`rem=0`/`ts` 全 `0x80`、**任何来自同机双 PC 实例 / 本机 4 核锁步的 `BATTLE=YES`**。
  - 现状（事实）：XD-1~XD-8 无一条真实跨设备落盘证据；10-agent 冲刺产物到位并复核前，**本项保持 `[ ]`、门维持 FAIL**。
  - 分工：Agent 1/3/4/7/8 链路层与驱动、Agent 2/5/9 三端、Agent 6 断言化、Agent 10 汇总（见 `production/sprint-2p/HANDOVER-10-agents.md`）。

---

## §4 降级与回滚策略

### 4.1 能力协商不一致时：提示与回退（Rev.3 更新）
- **机制**：AUTO 默认 `resolveLinkMode(playerCount)`（2P→A、3/4P→B）+ type 1 握手 1 bit `mode`；两端取协商结果，不一致**直接 fail**。
- **玩家可读提示（建议文案）**：「两端联机模式不一致（一端为双人直连、一端为兼容模式）。本次连接已安全断开，游戏进度未受影响。请按下方分平台步骤在两端统一到同一模式后重新连接。」
- **【Rev.3 · 裁定 ① 采纳 A】S3 对话框内提供分平台可执行步骤 + 一键复制命令**（零新增产品代码）：PC 用大厅模式下拉框（QSettings `link_mode`）；Android 用 `GBOY_LINK_MODE` ADB 广播（`gboy_link_mode` 持久化）+ 一键复制命令；iOS 端文案切换为「iOS 暂不支持双人联机」并**隐藏「改用兼容模式」**（裁定 ④）。`mode` 仍不一致时「重试」须置灰并给原因。**该路径属已裁定口径，代码落地由 T-03 负责，本清单不标为已执行。**
- **为什么禁止静默降级**：path A 的 20 字节 SIO 包与 path B 的按键帧是两套帧格式，同流会耗死读线程（`CloudLink.cpp:608-610` 记录 9470 个碎片包事故）；path A 里整份 savestate 会破坏 SIO 帧边界（`!m_officialMode` 门控已修）。**自动切到另一端 path 会把帧格式混进同一条流，属高危动作。**

### 4.2 path A 触发 11-08 `C0000005` 崩溃时的回退路径
- **现象**：进战斗后 50~200s 崩于 `cb=081520D1`（`2026-11-08.md:934-937`），PC 端 path A 头号阻塞，**未找到已修证据**。
- **回退路径（有序，禁止热切换）**：
  1. 检测到崩溃 → **先断链并清空读线程缓冲（Drain）**，不得在连接存活期间切换帧格式；
  2. 两端在 UI 层**显式**切到 path B（本机 4 核 + 网络只传按键）——注意 path B 的 **2 核实现有问题**（`flow_2pA.log` f=4200 仍锁位、`127.0.0.1` 环回 `battle=0`），须保持 4 核；
  3. 重建连接，重新走 type 1 握手与能力协商；
  4. 落盘崩溃日志 + 双端 `PEEK`，作为 §3.8 的输入。
- **全程须向玩家显示提示**，不得静默回退；回退后须在状态栏标明「已切换到兼容模式（实验性）」。

### 4.3 热修触发条件
- 线上出现 Blocker：崩溃 / 帧格式错乱 / 存档污染 / 断链无法恢复 / 能力协商大面积 fail / **path A 借壳包误断链（§3.12）**，且影响已放行渠道。
- 热修走**简化流程但保留完整审计**：变更单（现象→根因→改动→验证）+ 回滚预案 + 复现证据 + 人工审批留痕；同样执行 §2 的构建后同步与回归，不得跳过产物同步。
- ⚠ **C 层 flaky 未隔离（§3.11）期间，热修回归须多次采样并留存每次完整日志**，单次 `mobile tests passed` 不构成热修验证通过。
- 字符串冻结后禁止再改字符串，除热修（本轮无字符串冻结，记录口径备查）。

### 4.4 版本回退触发条件
- 热修 2 次未收敛 / 出现数据损坏（共享 `D:/gen8/rom.sav` 被回写污染）/ 能力协商上线后两端大面积 fail / 帧率跌破可玩阈值且无短期修复 / **ROM 重编译导致判据与产物失配且无双腿验证（§7 R8）**。
- 回退到上一个已放行构建：以 `commit-tree` 定位目标树，**不 `--force`、不 `reset --hard` 用户工作区**；回退前保留现场日志与存档快照。

### 4.5 明确禁止静默降级的情况（逐条硬约束）
1. 能力协商 `mode`（A/B）不一致 → 显式 fail + 断链。
2. ROM / `.sav` 指纹不一致 → 显式报「两边的游戏不一致」，禁止自动改用其中之一。
3. 联机倍速不一致（一边 1x 一边 4x）→ 显式提示，禁止自动改档。
4. 帧格式（path A 的 20 字节 SIO 包 / path B 的按键帧）不一致 → 禁止同流。
5. type 6 载入失败（尺寸 `-5→3`、其它非 0→1）→ 直接断链，对端读 EOF 等价，**无 type 1 空体兜底**。
6. 2P 云端跨设备未闭环 → 禁止把「本机 4 核脚本 `BATTLE=YES`」当作跨设备已通而放行。
7. **空 blob 误断链不是预期降级行为**：裸 SIO 桥包被 `stateOf()` 判空后派发导致 `STATE_ERROR(1)` → `EmulatorActivity.close()`（§3.12 / §7 R7），属**缺陷**，不得作为「载入失败断链」的既定策略接受，也不得静默吞掉；须显式修复并给玩家可读提示。
8. **【Rev.3 新增】禁止用 path B 的 AC1–AC6 判 path A 的可用性**（§3.1 / §7 R10）。

> **口径区分（Rev.3 按 T-05 §4 承诺 g 消解结论强化）**：教程所述「P2P 打洞失败 → 继续用服务器隧道」是**通道级自动回退，属设计内允许行为**——允许的是「**不中断连接、不弹错误**」，但按 `ux-spec.md` §7 / 裁定 ③，**通道与帧率变化必须在状态栏如实显示**（显示当前通道、有效帧率与倍速档，6 s 去抖）。**它与「架构级 path A ↔ path B 禁止静默降级」不冲突**：前者只换传输通道、不改帧格式与联机模式；后者会改帧格式，属本节禁止的 8 类一致性破坏。**禁止把通道回退说成「加速」、把架构降级包装成「智能优化」。**

---

## §5 用户可见限制清单 + 建议教程改写文本 + 产品口径已裁定 + 已知限制（Known Limitations）

### 5.1 用户可见限制（须在放行前如实告知；Rev.3 按 T-05 §4 补齐）
1. **iOS 2P 不可用**：iOS 完全没有 path A，默认假设「2P 仅 PC↔Android 可用，iOS 只支持 path B」；**iOS 与 PC / Android 组 2P 房间会协商失败并断开（设计内硬拒绝，不是崩溃、不是静默降级）**，iOS 目前只能与 iOS 组 3/4 人 B 模式房间（**KL-1 / KL-2，详见 §5.4**）；按裁定 ④ 明确写「iOS 暂不支持双人联机」并隐藏「改用兼容模式」；且 iOS 仅过 Swift 语法解析，真机 / Xcode 未验证。
2. **2 人局域网无 UI**：`安卓版完整使用教程.md:98` 已写明「2 人局域网没有界面，只能用 ADB 广播」；唯一入口是 `io.mgba.android.action.GBOY_LOCAL_LINK --ez host true --ei players 2`。该入口**零自动断言覆盖**。
3. **云端不自动重连**：断了点「重新连接中继」（沿用原房间）/「断开」重新建房；房主离开房间即解散。**两份教程动作须统一**（承诺 f）；若提示「两端联机模式不一致」，重连无效，须先统一模式。仅蓝牙 / TCP 客户端模式会自动重试（2 秒 × 50 秒）。
4. **帧率依赖通道 + 状态栏如实显示**：`sioFastFrame` 仅 PC/Qt 有，Android native 无等价实现（实测 4.6~4.9fps）；跨公网锁步每轮 1 RTT、gen8 9 轮/帧 ≈ 0.7~1.5fps，**物理不可行**。**通道 P2P 直连优先**，回落到 UDP 中继 / 服务器隧道不中断、不弹错误，但**状态栏如实显示当前通道与帧率**（裁定 ③ 三档 50 / 10 fps、6 s 去抖，数值为设计侧建议值、待分端真机校准）。同档仍卡时先看状态栏，不要只调倍速（承诺 c）。
5. **两边 ROM / `.sav` / 倍速三前提（Rev.3 按承诺 a / b 补齐）**：
   - **同游戏但文件指纹不同**：两边必须同版本 / 同语言 / 同 dump；但两个 ROM 文件**不要逐字节完全相同**——云端按 `game uuid = "BPEE," + ROM md5` 派发，逐字节相同会被当成同一玩家、消息只回显给自己（`self:true`）。做法：给其中一端 ROM 尾部补 1 字节填充（不改游戏内容）并配单独 `.sav`（`MEMORY.md:52-55`，`[需真机验证]`）。
   - **不同账号**：同账号登录会让先登录者 token 失效，大厅逐帧回「登录已失效，请重新登录」。
   - **不同 game uuid**（即上条 ROM 文件指纹不同）。
   - **不同 `.sav`**：玩家 ID 一样会被判成同一个人。
   - **倍速一致**：仅 `0.5x / 1x / 2x / 4x` 同步，自定义倍速不同步。
6. **当前为验证态**：2P 云端跨设备进对战**尚未闭环**（所有云端 `flow_*.log` 的 BATTLE 计数全 0）；「本机 4 核诊断腿 `BATTLE=YES`」与「两台设备两个真人各玩各的画面」**不是一回事**。此前 `BATTLE=NO` 已由符号级证据定位为判据假阴性（§3.13），但这**只修正本机诊断结论**，不改变「跨设备云端 2P 未闭环」与「**云端数据通路端到端 0 条断言 / 跨设备真机 E2E 0 条**」（分层口径见 §2.4 / §3.3：协商门层已有断言，数据通路层与真机 E2E 仍为 0 条）。
7. **【Rev.3 新增】「互发即时存档给隐藏核」是 path B（兼容模式）专属，不是全模式承诺**（承诺 d）：默认双人直连（path A）**不交换即时存档**，两台设备各从自己的进度开始；兼容模式（实验性）才互发一次即时存档给隐藏核、不覆盖屏幕进度，且它是「2 真人 + 2 电脑占位」的 4 人房、两端各跑一局，**不是 1v1、不计成绩**。
8. **【Rev.3 新增】复位联动措辞按模式区分**（承诺 e）：点复位对端一起复位（兼容模式下连同隐藏核），双方都回到各自当前存档起点；「对端所有核」是 path B 的 4 核措辞，path A 每端仅 1 核。
9. **【Rev.3 新增】模式切换可达性差异**：PC 大厅有模式下拉框可 UI 自救；**Android 仅 `GBOY_LINK_MODE` ADB 广播可达、无 UI 复选框**；iOS 2P 房间会可见协商失败。切换默认模式属高影响动作、须人工审批（§6.2）。

### 5.2 建议的教程改写文本（**只写在本清单内，不直接改根目录教程文件**）

> 以下为可直接粘贴的段落草案，供后续经人工审批后由文档负责人落地。**本轮不修改 `安卓版完整使用教程.md` / `PC版完整使用教程.md`。**
> **Rev.3 来源声明**：本节 **D 部分合并自 T-05 `design/gdd/2p-link-scope-review.md` §4（8 处改写落点，含可直接粘贴文本）**，与其 §4.3 落地清单一一对应；A/B/C 为 Rev.1 发布线自有草案。T-05 §4 明确「只给改写建议文本、不直接修改教程」，与本清单口径一致。
> **消解结论（承诺 g）**：**通道级 P2P→隧道回退属设计内允许**，与**架构级 A↔B 禁止静默降级**不冲突；教程改为「不中断、不弹错误，但**状态栏如实显示**当前通道与帧率」；「帧格式完全一致」改为「**同一联机模式内**帧格式一致」。来源：T-05 §4.2 承诺 g / §4.1 交叉项；`ux-spec.md` §7。

**A. `安卓版完整使用教程.md`「### 云端房间（异地，最常用）」标题下、`先记住三条` 之前插入：**

```markdown
> **双人联机（2P）当前为验证态，请先读这段**：
> - 目前双人联机仅在 **PC ↔ Android** 组合下提供；**iOS 暂不支持双人联机**。
> - 两台设备、两个真人跨设备进对战的稳定性仍在验证中（存在已知的进战斗后崩溃风险），
>   建议短局游玩并随时存档；「本地 4 核脚本进对战」不等于「两台设备跨设备对战」。
> - 2 人局域网没有界面，只能用 ADB 广播（见下方「ADB 广播」）。
> - 云端断线不会自动重连；帧率表现取决于所选通道，P2P 直连优先、效果最好。
> - 三条前提不变：同游戏（但文件指纹不同）、不同账号、不同 `.sav`、倍速一致。
```

**B. `PC版完整使用教程.md`「### 云端大厅」末段（`:104` 之后）追加：**

```markdown
> **双人联机（2P）范围说明**：当前双人联机仅 **PC ↔ Android** 组合可用，
> **iOS 暂不支持双人联机**；进战斗后的长时间稳定性仍在验证（已知存在崩溃风险）。
> 本节「手机和 PC 能互连」仅指**同一联机模式内**通道与帧格式层面互通，
> 不代表跨设备双人对战已闭环。两端模式不一致会直接断开并给出提示，不会自动切换；
> PC 可用大厅模式下拉框统一模式，Android 需 ADB 广播（见失败提示里的分平台步骤）。
```

**C. 两份教程「已知限制」统一增补一行：**

```markdown
- 双人联机（2P）当前仅 PC↔Android 可用，iOS 暂不支持；跨设备双人对战仍在验证态。
- 兼容模式（实验性）是 2 真人 + 2 电脑占位的 4 人房，不是 1v1，不计成绩。
```

---

#### D. T-05 §4 的 8 处改写落点（Rev.3 合并 · 来源 `design/gdd/2p-link-scope-review.md` §4.2 / §4.3）

> **改写原则（T-05 §4 口径）**：① 不引入 path A/B、SIO、type 6、核数等内部术语；② 把「全模式承诺」改为「按模式分别陈述」；③ 保留玩家既有心智词（房号、倍速、复位、重新连接中继）；④ 不把验证态写成已可用。
> **优先级**：P0×2（承诺 d / g）、P1×4（承诺 a / b / c / f）、P2×1（承诺 e），加 1 处已由 A/B/C 覆盖项，共 8 处落点。

**D-1【P0 · 承诺 d】安卓 `:85` / PC `:106`：「互发即时存档给隐藏核」是 path B 专属 → 按模式分别陈述**

安卓 `:85` 替换为：
```
- **连上之后各玩各的**：对端按键不会进你的游戏，双方屏幕进度互不覆盖。
  · **双人直连（默认，PC ↔ Android）**：不交换即时存档，两台设备各从自己的进度开始，
    游戏里的联机由模拟器联机线实时同步。
  · **兼容模式（实验性）**：连上会互发一次即时存档给对端的隐藏核，让两边从同一幕开始，
    **不会覆盖你屏幕上的进度**。此模式是 2 真人 + 2 电脑占位的 4 人房，不是 1v1，详见模式说明。
```
PC `:106` 替换为：
```
> **兼容模式（实验性）**：本机多核 + 网络只传按键的镜像布局，连上会互发一次即时存档给隐藏核，
> 不覆盖屏幕进度。它是 2 真人 + 2 电脑占位的 4 人房，帧率通常低于直连，仅作兼容用途。
> 开启时两端必须同时设为同一模式；只设一端会直接断开并给出提示，不会自动替你切换。
> 默认的双人直连不需要开这个模式（PC 可用大厅模式下拉框切换）。
```

**D-2【P0 · 承诺 g】安卓 `:88` / PC `:71`、`:108`：通道顺序反转 + 帧格式口径 + 降级可见**

安卓 `:88` 替换为：
```
通道会**优先尝试 P2P 直连**（握手后打洞，成功显示「直连加速已启用」）；
打不通时自动回落到 UDP 中继 / 服务器隧道，**不会中断连接、也不会弹错误**。
但状态栏会如实显示当前通道和帧率：走隧道时帧率会明显下降，
这时「卡」是通道造成的，不是游戏坏了、也不是倍速没调一致 —— 点「重新连接中继」可再试直连。
强制只走隧道设 `MGBAX_NO_DIRECT=1`（调试用，会更慢）。
```
PC `:108` 替换为：
```
通道优先 P2P 直连，打不通自动回落到中继 / 服务器隧道，不中断、不弹错误；
状态栏会显示当前通道与帧率，帧率明显下降时点「重新连接中继」重试直连。
强制只走隧道设 `MGBAX_NO_DIRECT=1`。
```
PC `:71` 首句替换为：
```
三条通道 + 一个云同步；**同一联机模式内**帧格式一致，PC ↔ Android 可互连
（iOS 暂不支持双人联机，见「已知限制」）。两端模式不一致会直接断开并提示，不会自动切换。
```

**D-3【P1 · 承诺 a】安卓 `:70` / PC `:82`（`:210` 联动）：同游戏但文件指纹不同**

安卓 `:70` 替换为：
```
1. **两边必须是同一个游戏**（同版本、同语言、同 dump；不同汉化 / 不同版本会被判成不同游戏）。
   但两个 ROM 文件**不要逐字节完全相同**：云端按 ROM 指纹区分玩家，
   两端文件一模一样时会被当成同一个人，消息只回显给自己、对端收不到。
   做法：给其中一端的 ROM 尾部补 1 字节填充（不影响游戏内容），并给它配一份单独的 `.sav`。
```
PC `:82` 替换为：
```
1. **两边必须是同一个游戏**（同版本、同 dump；大厅会比对游戏指纹，不同汉化 / 不同版本报「两边的游戏不一致」）。
   云端另按 ROM 文件指纹区分玩家，两端文件逐字节相同时会被当成同一人、互相收不到消息；
   请给其中一端 ROM 尾部补 1 字节填充并配套单独 `.sav`。「游戏一致」与「文件指纹不同」是两件事，不要混淆。
```
> 备注（T-05 §4.2）：`game uuid = "BPEE," + ROM md5`；「补 1 字节填充」属实现细节，长期应由工程侧消除（改 uuid 生成口径）。标注 `[需真机验证]`——该结论出自 2026-11-13 云端房间实跑，是否同样适用于 path A 待复核。

**D-4【P1 · 承诺 b】安卓 `:71` / PC `:83`：补「不同账号 / 不同 uuid」两条硬前置**

```
2. **两边不能共用同一份 `.sav`**——玩家 ID 会一样，交换 / 对战被判成同一个人。
   云端房间还要多两条：**两端用不同账号登录**（同一个账号同时在线会把先登录的一端挤下线），
   **两端 ROM 文件指纹不同**（见第 1 条）。三条都满足，才不会出现「房间里只有自己」。
```

**D-5【P1 · 承诺 c】安卓 `:112` / PC `:114`（`:208` 同步）：补「同档仍卡看状态栏」例外**

安卓 `:112` 替换为：
```
> **一边 1x 一边 4x 会「拉扯」**：画面一顿一顿、对话错位。先调成同档再判断。
> 如果两端已经同档还是卡，**看状态栏**：显示「服务器隧道 / 通道受限」时，
> 卡顿来自直连没打通、正在走隧道，调倍速没用，请点「重新连接中继」重试直连。
> 自定义倍速（1.5x 等）不同步，联机时别用。
```
PC `:114` 替换为（`:208` 表格行同步改为「先看状态栏，再查倍速」）：
```
> **两端必须同档**，一边 1x 一边 4x 会互相拉扯、对话错位。
> 同档仍卡时看状态栏：显示「服务器隧道 / 通道受限」属于通道回退，不是倍速问题；
> 点「重新连接中继」重试直连，或换网络后重连。
```

**D-6【P1 · 承诺 f】安卓 `:86` / PC `:104` 统一为同一段（消除两份教程互相矛盾）**

```
- **云端不会自动重连**：断了先点 **重新连接中继**（沿用原房间、不重建）；
  还连不上就点 **断开** 重新建房，**房主离开房间即解散**，新房号要重新告诉对端。
  · 若提示的是「两端联机模式不一致」，重连不会成功 —— 先在两端统一模式再连（见失败提示里的「如何统一模式」）。
  · 只有蓝牙 / TCP 的客户端模式会自动重试（每 2 秒、最多 50 秒）。
```

**D-7【P2 · 承诺 e】安卓 `:84` / PC `:104`：「对端所有核」是 path B 措辞 → 微调**

安卓 `:84` 替换为：
```
- **复位联动**：你点复位，对端会一起复位（兼容模式下连同隐藏核一起）。
  两边都会回到各自当前存档的起点，误触代价不小；想重开一局用复位，别用「撤销读档」或逐帧倒带。
```
PC `:104` 内「复位联动」四字展开为：
```
复位联动：你点复位，对端一起复位（双方都回到当前存档起点）；
```

**D-8【已由 A/B/C 覆盖】两份教程「iOS 2P 范围说明 / 已知限制 / 手机 PC 互连」**

T-05 §4 不重复：由本清单 §5.2 A/B/C 承载；PC `:71` 的「手机和 PC 能互连」「帧格式完全一致」由 D-2 的 PC `:71` 首句改写覆盖；安卓 `:107` / PC `:124`「iOS 不提供 RFCOMM 蓝牙」由 A/B 的 iOS 范围说明对齐；PC `:106` 环境变量单端设置会 fail 由 D-1 覆盖。

> **落地前检查（供文档负责人）**：① 8 处文本均不写「已闭环 / 2P 可用」；② 帧率数值以 §5.3 决策 ③ 的三档口径为准（T-05 §4.2 承诺 g 文本中的「约 60 fps / 约 5 fps」为架构侧既有实测与理论值，与三档建议值来源不同，落地时统一为状态栏实测值、不写死数字）；③ 上线前做「教程文案 ↔ 实现行为」对拍。

### 5.3 产品口径已裁定（Rev.3 新增 · 主理人拍板，T-05 四项决策全部采纳 A）

> **状态区分**：以下为**已裁定的产品口径**（决策生效），**不是已执行的产品代码或已发布的教程**。裁定 ①–④ 的代码 / 文案落地由各线负责；**「切换默认模式」与「正式改写发布教程」仍属 §6.2 人工审批动作，本轮未执行**。来源：T-05 `design/gdd/2p-link-scope-review.md` §6、`design/gdd/2p-link-ux-spec.md`（经主理人中转）。

| # | 决策（全部采纳 A） | 落地口径 | 状态 |
| --- | --- | --- | --- |
| ① | **能力协商失败后的「统一模式」自救路径 = A** | S3 对话框内提供**分平台可执行步骤 + 一键复制命令**（PC 大厅模式下拉框 / Android `GBOY_LINK_MODE` ADB 广播），**零新增产品代码**；`mode` 仍不一致时「重试」置灰并给原因 | 口径已裁定；代码落地由 T-03 负责，本清单不标为已执行 |
| ② | **path B 对外命名与露出 = A** | 统一命名「**兼容模式（实验性）· 2 真人 + 2 电脑占位**」+ 进房前说明卡 + **席位灰显**（`3P、4P 电脑占位（不操作）`）+ 常驻实验性徽标 + **不计成绩**（不参与胜负 / 连胜 / 成就 / 排行）；不默认、不自动、需二次确认 | 口径已裁定；「NPC 队伍 / AI / 台词」等角色化表现明确**不做**（T-05 判断 2），不写成已实现 |
| ③ | **帧率可玩阈值 = A** | **GREEN ≥ 50 fps / YELLOW 10–50 fps / RED < 10 fps 三档 + 6 s 去抖**；明确标注「**设计侧建议值，待 PC / Android 分端真机校准**」；`F_eff` 实测优先于通道徽标判档；同一连接内说明条只弹一次 | 口径已裁定；数值定稿延后至真机 Playtest（§3.5），不得当作已校准数据 |
| ④ | **iOS 对外口径 = A** | 明确写「**iOS 暂不支持双人联机**」，能力协商失败时若任一端为 iOS，文案切换为指名 iOS 的失败原因并**隐藏「改用兼容模式继续」**；与 §5.2 A/B/C 完全一致 | 口径已裁定；iOS 2P 功能实现仍延后（§3.4 / T-05 D1） |

> **与人工审批清单的边界**：AUTO 默认与 PC 下拉框是 T-03 的**代码落地**（§1 / §3.7），但**「切换三端默认联机模式」作为高影响动作仍保留在 §6.2**；**「教程正式改写发布」§5.2 的 8 处文本也仍在 §6.2**。二者**均不得标为已执行**。
> **T-05 设计侧强保留意见（随 Handoff 上呈，如实收录）**：若「PC/Android 默认模式对齐」与「失败对话框的统一模式自救路径」两项不在本冲刺落地，2P 功能对玩家等价于「开箱即失败且无法自救」；设计侧建议在此前提下**不放行 2P 联机的对外交付**（可不阻断代码合入与内部验证，但不得以「2P 可用」口径对外）。**默认对齐已由 AUTO 落地，自救路径在 Android 侧仍受「仅 ADB 广播可达、无 UI 复选框」限制（§1 / §3.7），该保留意见未被完全解除。**

---

### 5.4 已知限制（Known Limitations）· Rev.4 新增

> **本节定位**：以下为**交付范围的边界声明**，不是缺陷待办、不是回归、不是 TODO。每一项都是当前架构与验证状态下的既成事实，**决定了「哪些组合能交付、哪些不能」**。任何对外文案与发布说明不得弱化本节的表述，不得把「范围外」写成「后续会修」或「已修复」。
> **登记原则**：逐条给「现象 → 影响范围 → 规避方式 → 依据文件」，依据均为可核对的代码路径 / 落盘证据。
> **取代关系（Rev.4 以本轮事实为准）**：本节**取代** Rev.1–Rev.3 中三处较弱表述——① §5.1 #1「iOS 2P 房间会**可见**协商失败」→ 强化为「与 PC / Android 组 2P 房间**协商失败并断开**，且 iOS 只能与 iOS 组 3/4 人 B 模式房间」；② §1 三端表 iOS 列「2P 房间会可见协商失败」→ 同口径强化；③ 散见各处的「iOS 只支持 path B」→ 明确补充其**互操作后果**（不能与 A 端组房）。Rev.3 其余内容（AUTO 默认、能力协商落地、双门判定等）**不受影响、继续有效**。

#### KL-1 · iOS 没有 path A，与 PC / Android 组 2P 房间会协商失败并断开

- **现象**：path A = 每端 1 核 + SIO 20 字节包中继，是 2P 的首选路径（AUTO 模式下 2 人房默认就是 A）。iOS 端**只有 path B**（本机 N 核 + 网络只传按键，`ios/mGBA/GBoyConsoleSet.swift`），**没有任何 path A 实现**（`ios/` 目录 grep `sioRelay` / `pathA` / `SioRelay` 零命中）。能力位不一致时 `mode` 协商**按设计硬拒绝**：直接 fail 并断开连接。
- **明确不是**：**不是崩溃**、**不是静默降级**、**不是网络故障**。是能力协商的设计内硬拒绝，状态栏给出可见提示。
- **影响范围**：**iOS 与 PC / Android 组 2P 房间会协商失败并断开**。iOS 目前**只能与 iOS 组 3/4 人 B 模式房间**。这是范围外，不是回归。
- **规避方式**：iOS 用户不要使用 2 人房；改用 3/4 人房（AUTO 下 3/4 人→B），或由 PC / Android 端**显式覆盖为 B**（PC 大厅模式下拉框 / Android `GBOY_LINK_MODE` 广播）后再组房。
- **依据文件**：`ios/mGBA/GBoyConsoleSet.swift`（仅 N 核路径）；`mode` 硬拒绝见 `src/platform/qt/CloudLink.cpp:2834-2841,2925-2948`、`android/app/src/main/java/io/mgba/android/GBoyCloudLink.java:2651-2656`；设计取舍见 `design/gdd/2p-link-ux-spec.md` §5.4、`design/gdd/2p-link-scope-review.md` §6 决策 4。

#### KL-2 · AUTO 默认对 iOS 不友好：2 人房必定撞 A

- **现象**：`resolveLinkMode(playerCount)` 的 AUTO 规则是 **2 人 → A、3/4 人 → B**，PC / Android 同逻辑。
- **影响范围**：**iOS 用户建 2 人房必然撞这条规则**（判定为 A），随后因 KL-1 协商失败。
- **规避方式**：① 改用 **3/4 人房**（AUTO→B）；② 或由 **PC / Android 端显式覆盖为 B**（PC 大厅模式下拉框，QSettings `link_mode`；Android `GBOY_LINK_MODE` ADB 广播，持久化 `gboy_link_mode`）。
- **依据文件**：`src/platform/qt/CloudLink.cpp:2855`（`CloudLink::resolveLinkMode` 定义，AUTO 分档 `:2855-2861`）、调用点 `:1462,2270,2328,2893`；`android/app/src/main/java/io/mgba/android/GBoyCloudLink.java:1055`（`resolveLinkMode` 定义 `:2651-2656`）；PC 覆盖入口 `src/platform/qt/LobbyView.cpp`。

#### KL-3 · 会话级 / 通道级回退 vs 架构级降级（两者边界必须分清）

- **现象**：
  - **通道级回退（设计内允许）**：UDP 中继 → 服务器隧道 → P2P 直连之间自动切换，**不中断连接、不弹错误**，但状态栏**如实显示**当前通道与帧率。
  - **架构级降级（禁止静默发生）**：path A ↔ path B 切换会改变帧格式（20 字节 SIO 包 vs 按键帧），**只能靠 `mode` 协商隔离，不一致直接 fail**。
  - **`allow_legacy` 是唯一例外，且是「显式」回落**：PC `MGBAX_LINK_ALLOW_LEGACY=1` / Android ADB `allow_legacy=true`，默认关闭（`m_allowLegacyPeer` 初始 false）；生效条件严格限定「**对端未声明模式**」；状态栏打出**警告**，文案含「按 … 显式许可回落为 B…此路径未经 2P 云端验收，不建议用于交付」。
- **影响范围**：`allow_legacy` 路径**未经 2P 云端验收**，用于交付会把未验收路径暴露给玩家；把它当作「默认兜底」即等于静默降级的变体。
- **定位（明确）**：`allow_legacy` = **诊断 / 旧客户端互通用途，不建议用于交付**；交付默认配置必须保持关闭。
- **规避方式**：交付构建不开启 `allow_legacy`；两端显式统一到同一 `mode`；需要回落时由玩家**显式选择**并在状态栏看到警告，不得由程序自动决定。
- **依据文件**：`src/platform/qt/CloudLink.cpp:2925-2948`（回落与警告）、`:644`（`m_allowLegacyPeer` 初始 false）、`:2834-2841`（`mode` 硬拒绝）；`android/app/src/main/java/io/mgba/android/GBoyCloudLink.java:2704-2719`；`docs/architecture/ADR-002-2p-patha-capability-negotiation.md:84,158`；`design/gdd/2p-link-ux-spec.md` §5.4 / §2.1 F5–F6。

#### KL-4 · 四条仍未解除的已知限制（原样登记，**不许写成「已修复」**）

| # | 限制 | 现象 | 影响范围 | 规避方式 | 依据文件 |
| --- | --- | --- | --- | --- | --- |
| **KL-4.1** | **跨设备云端 2P 从未闭环** | 所有云端 `flow_*.log` 的 BATTLE 计数**全 0** | 跨设备（两台机器、两个真人）2P 对战**没有通过验收的证据**；不得对外声称「云端 2P 可用」 | 仅作内部验证；对外口径按 §5.1 #6「验证态」表述 | `2026-11-15.md` 硬结论 1；`MEMORY.md` 顶部勘误 |
| **KL-4.2** | **PC path A 曾出现进战斗后 `C0000005` 崩溃，至今未找到已修证据** | 11-08 记录：进战斗后 50~200s 崩于 `cb=081520D1` | path A 成为默认前的**头号阻塞**；长时间对战存在进程级崩溃风险，可能被玩家读成「数据丢失」 | 短局游玩并随时存档；崩溃须给「上次连接异常结束」可见提示（§4.2）；**不得声称已修** | `2026-11-08.md:934-937`；本清单 §3.8 / §7 相关条目 |
| **KL-4.3** | **`sioFastFrame` 只有 PC / Qt 实现，Android native 无等价物** | `sioFastFrame` 全仓仅出现在 `src/platform/qt/sio_link.c` | Android native path A 实测 **4.6~4.9 fps**，帧率远低于可玩；跨公网帧锁步约 0.7~1.5 fps 物理不可行 | Android 侧不在交付承诺内；帧率按 `F_eff` 实测如实显示（裁定 ③ 三档） | `src/platform/qt/sio_link.c`（`sioFastFrame` 唯一实现处）；本清单 §3.9 |
| **KL-4.4** | **2P 局域网 ADB 入口零覆盖（无自动化断言）** | 唯一入口 `io.mgba.android.action.GBOY_LOCAL_LINK --ez host true --ei players 2`，**无任何自动断言** | 该路径行为变化不会被 CI 捕获；回归风险不可见 | 该入口定位为**调试 / 自动化向**，不作为面向玩家的交付路径；2 人局域网维持「无 UI、只能 ADB 广播」 | 本清单 §5.1 #2 / §3.3；`安卓版完整使用教程.md:98,127-129` |

> **与既有章节的关系（避免重复计口径）**：KL-4.1 ≈ §3.6 + §5.1 #6；KL-4.2 ≈ §3.8；KL-4.3 ≈ §3.9 + §5.1 #4；KL-4.4 ≈ §3.3 + §5.1 #2。本节是**面向发布说明的合并口径**，不替代 §3 的放行判据，也不因本节登记而改变 §8 的 FAIL 判定。
> **本机 4 核脚本 `BATTLE=YES` 的定位（对应 KL-4.1）**：那是**进程内锁步证据**（`.workbuddy/final_busgame_product.out`、`build-win/qt/ls_result.txt`），**不能外推为跨设备云端可用**；跨设备闭环仍以落盘 logcat + 双端截图 + 全量 PEEK 且 `BATTLE=YES 计数 > 0` 为准（§3.6）。

#### KL-5 · 协商门的 2 s 有界等待从未在真实云端链路上实测（Rev.5 新增 · Rev.9 收窄覆盖粒度）

- **现象**：协商门 **2 s 有界等待从未在真实云端链路实测**。`--gatetest` 已覆盖：五类判定 / 畸形早退层 / **`peer == INVALID` 分支**（用例 11 强制，证明非死代码）/ **短路先于重新绑定本端模式的顺序**（用例 12，变异重排后只有它变红）/ **等待时序语义**（泵注入）/ **失败幂等**（只报一次）。其中 `waitAndProcess()` 分支实测 **2001~2017 ms**；`drainSignaling()` 分支以注入泵（`m_gatePump`，生产恒为空）覆盖**提前返回 / 晚到能力位 / 中途 close** 三种时序（用例 8 泵立即返回 0 ms → 等待仍 2011 ms；用例 9 第 3 轮设能力位 → 322 ms 提前退出并接受；用例 10 第 2 轮 `m_closed` → 104 ms 立即退出；所有用例最坏等待 2012~2017 ms ≤ 2400 ms 上界有证）。**注入泵覆盖的是时序语义，不是真网络。**
- **未覆盖（Rev.9 收窄）**：**真实 WSS 会话下的端到端网络时序**——`drainSignaling()` 内部 `sig->recv(60)` 的真实行为、真实服务器的推送节奏，**均未实测**；需活账号 + 房间，或把 `GbCloud::Session` 抽成可注入接口。
- **影响范围**：**2 s 只是 `deadline` 构造保证的数学上界**，真机 WSS 会话下的实际等待时长、以及超时后的玩家可见行为，**都没有落盘证据**。**不得据此声称「协商门已全部验证」或「2 s 超时已在真机验证」**；56 条全绿**不改变**本条结论。
- **规避方式**：对外不表述协商门时延为已验证指标；真机验证并入 §3.5 真机 Playtest 与 §3.6 跨设备 E2E（落盘 `PEEK` + 时间戳）。
- **与 KL-4.1 的关系**：本条是 KL-4.1「跨设备云端 2P 从未闭环」在**协商门时序**上的具体化——所有云端 `flow_*.log` 的 BATTLE 计数仍全 0，因此「端到端链路下的 2 s 等待表现」无证据。**KL-4.1 已展开的内容此处不再重复**，只登记「协商门时序缺真机证据」这一增量。
- **依据文件**：`src/platform/qt/CloudLink.cpp:2941`（`const qint64 kPeerModeWaitMs = 2000;`）、`:2950`（`const bool signalling = m_session && m_session->isOpen();`，泵为空时退化为原逻辑）、`:2960`（`m_gatePump(slice);` 泵 / drain 二选一后统一补时）、`:2947-2968`（等待循环整体）、`:2933-2941`（F7 口径注释：构造保证的 2000 ms 上界 + 分两分支写实测覆盖）、`:2875-2899`（F8 注释：回写属状态可观测性、非放行锁；含变异反向验证证据）；`src/platform/qt/CloudLink.h:269`（`std::function<int(int)> m_gatePump;`，注释写明生产恒为空、返回值只作诊断、控制流只认 deadline）；`src/platform/qt/test/gboylink_test.cpp` 的 **用例名锚点**：`8) instant pump, peer stays UNKNOWN` / `9) peer bit arrives on round 3` / `10) link closed on round 2` / 上界不变量 / 第二次调用与短路断言助手 / `11) forced INVALID`（`f355bd59f`）/ `12) early exit before rebinding`（`0be5da192`）；本清单 §2.4 / §5.4 KL-4.1。
  - ⚠ **引用方式建议**：测试文件仍在补做，**行号会持续漂移**（本清单已因此返工两次）；引用断言时请用「**用例名 + commit 短哈希**」定位，行号仅在当次核查时有效。

#### KL-6 · Android 缺 `GBoyLinkSession` 的 pre-ready 按键门控（Rev.10 登记 · **Rev.11 已修 `a08071243`**，仍待真机验证）

- **现象**：PC 的 `GBoyLinkSession` 在 `src/platform/qt/GBoyLinkSession.cpp:117` 有一道
  **pre-ready 按键门控** —— ready 之前的 type 0 / 槽位键帧被丢弃（`onStatus("pre-ready key frame ignored")`）。
  **Android 的 `GBoyLinkSession` 没有这道门**：`TYPE_KEYS` 直接 `pushKeys`。
- **为什么判定为真缺口（不是设计差异）**：两端 `ready` 语义同源 —— **都是三个置位触发点**
  （`TYPE_READY` / `TYPE_RECONNECT` / `TYPE_REGISTER`；PC 见 `GBoyLinkSession.cpp:144-145 / :170-171`，
  Android 见 `GBoyLinkSession.java` 的同名三处）。因此不存在「Android 的 ready 天然更晚」这种解释，
  是同一语义下少了一道门。
  > **订正**：本条曾写成「Android 的置位触发点比 PC 更多（只 PC 在 `READY`/`RECONNECT` 置位）」——
  > 该依据**错误**，PC 在 `TYPE_REGISTER`（`GBoyLinkSession.cpp:171`）同样置位，两端触发点数量相同。
  > 结论（真缺口）不变，依据已改。
- **另一处真实不对称（同次核查发现，比缺门控更容易命中）**：`TYPE_REGISTER` 之后的通知，
  PC 有 `first` 保护 —— `if (first && m_events.onReady) m_events.onReady();`（`:167-172`），
  Android 是**无条件** `events.onReady();`（`TYPE_REGISTER` 分支内）。⇒ 对端**重复发注册帧**时，
  Android 会**重复触发 `onReady()`**，PC 只触发一次。这一点不依赖按键时序，只要注册帧重发就会出现。
- **可达性（关键限定）**：**官方握手顺序**（`->1, <-3, ->3, <-0, ->1`）下**不可达** —— 对端首条 type 0
  在 `<-3` 之后到达，此时 `ready` 已为 true。可达场景有两个：① 中继 / WSS 通道**乱序或重传**，
  使 type 0 先于 type 3 被处理；② 对端在 ready 前就按节奏发键（`setLocalKeys` 是独立定时器，
  不依赖 ready）。危害是 ready 前多按一次 → 菜单多走一步 → 两端菜单状态错位。
- **证据强度（必须按此引用）**：PC 那道门判定为 **bug 驱动**（`GBoyLinkSession.cpp:112-116` 注释写明
  「没有 ready 门控时，对端开局那条 0 会凭空按下 1/2/4 号键，于是两边在菜单里各多走一步」），
  但**历史档案缺失** —— 引入 commit `8cf780fcb` 提交信息只有「联机」二字，
  `.workbuddy/memory` / `CHANGELOG-2p-link.md` / `design/` 均无记录 ⇒ **不能作为「已知缺陷编号」引用**。
  `pre-ready key frame ignored` 在本机 `mgba_lobby_debug.log`（232 KB，近期仍在写）grep = **0 次**，
  但该日志只覆盖 **PC 侧本机近期**，Android 不写此文件 ⇒ **只能写「未命中」，不能推断「从未发生」**。
- **处理结果（**已修**，`a08071243`）**：两处都按 PC 对齐，且都在 Android 侧有断言钉住 ——
  1. `TYPE_REGISTER` 加 `first` 保护（`GBoyLinkSession.java`，照 `TYPE_READY` 的写法），
     重复注册帧不再重复触发 `onReady()`；断言钉住 first 判断的**正反两面**（未 ready 时 REGISTER 必须触发一次；
     已 ready 后重发不得再触发）；
  2. 四个按键 case（`TYPE_KEYS` / `TYPE_KEYS_LOCAL` / `TYPE_INPUT_2/3/4`）加
     `if (!isReady()) { events.onStatus("pre-ready key frame ignored"); break; }`，文案与 PC **逐字相同**；
     新增用例 `preReadyKeysAreDropped()` 钉住「握手前丢弃 + 握手后生效」。
  变异验证：把门改成 `if (false)` → `preReadyKeysAreDropped` 变红；还原后 `8/8 PASS`。
  `C0GateTest` 58 → 65（另含两条承重报警器断言，见 T-04 §7 6g）。
  **残留**：两端现已在语义上对齐，但**仍未在真机验证** —— 真机上的乱序 / 提前发键是否真实出现过，
  需要 §3.5 真机 Playtest 才能回答；本条按「代码已对齐、真机未验证」登记。
- **不修的项（有意保持对称）**：`TYPE_NAME` / `TYPE_RECONNECT` 没有 pre-ready 门 —— **PC 也没有**，
  两端一致，故不单方面给 Android 加（避免制造新的不对称）。
- **影响范围**：① `ready` 前误按键导致菜单错位，**仅在帧乱序 / 对端提前发键时触发**，官方顺序下不出现；
  ② `onReady()` 重复触发的具体后果**未逐条核实**（取决于回调体内是否有非幂等副作用，如状态文案 / 重同步），
  按「可能多一次通知」登记，**不夸大**。
- **与门控判定的关系**：本条**不改变** 2P 云端交付门 FAIL / C-Qt CONCERNS —— 它是一条新登记的已知缺口，
  不是新增阻塞项。

#### KL-7 · 内嵌中继握手写序竞态（`relay` 用例 1/40 偶发失败）· **已定位并已修 `fdfc23290`**

- **现象**：`mgba_mobile_test` 的 relay 用例偶发失败（40 次采样命中 1 次），日志形如
  `status 中继协议不匹配` → guest 始终拿不到「你是 2P」→ `FAIL relay guest connected` /
  `FAIL relay local sockets` → 该次耗时 18.9s（正常 10~12s，多出的约 8s 是 `waitFlag(...,8)` 等满）。
- **根因**：`remote_link.c` 内嵌中继的 `guestRoom` 在 `:463-466` 置 `guestFd` / `guestReady=1` + broadcast +
  **unlock**，`:467-468` 才在**锁外**写 `MGBA1 ROOM <code> GUEST`；而 `hostRoom` 在 `:434` 一看到
  `guestReady` 就返回、`:439/:441` 从**另一线程**往同一 socket 写 `MGBA1 PEER`。**两处写无互斥 ⇒ PEER 可超车**
  ⇒ guest 首行读到 `MGBA1 PEER` ⇒ `roomCode()`（`:250-270`）校验失败 ⇒ `:847` 判「中继协议不匹配」。
  这天然解释「host 全绿、guest 全错」的不对称：host 要的是**第二条** PEER，必在 `guestReady` 之后发。
- **已排除的替代解释（五条）**：非粘包/半包（`readLine` 读到完整 `\n` 才返回）；非连错对端（独占实验里
  accept 的 relay 句柄 == 本轮 host relay、`peerPort` == guest `localPort`）；非网络抖动（竞态在服务端本地两线程，
  TCP 保序）；非端口冲突（`SO_EXCLUSIVEADDRUSE` 独占下仍复现 3/10000）；非双实例并行（失败窗口 16:45:35–16:45:54，
  与另两批采样不重叠）。
- **修复**：GUEST 写移进 `room->mu` 内、且在 `guestReady = 1` **之前**（`+9/−2`，仅此一处）。
  注释就地写明「顺序不能改：先 GUEST，再 guestReady」及原因 —— 防止后人做「把写移出锁」的优化时改回去。
- **三段证据（不可互相替代，引用时必须分开）**：
  1. **机理**（带 `[ORD]` 探针的隔离 worktree 构建）：未修 14000 轮命中 **12** 次 → 修后 14000 轮 **0** 次；
     独占端口未修 10000 轮 **3** 次。**探针会改变线程调度、可能压缩竞态窗口，故此段只用于机理验证。**
  2. **真实时序**（主仓干净构建、无探针）：**40/40** 每次 `EXIT=0 / 252 ok / 0 skip / 中继协议不匹配=0 / 你是 2P=1`。
     且**测试所用 exe md5 == 提交后重编 exe md5（`7810c2ce…`）** ⇒ 结果与 `fdfc23290` 一一对应。
  3. **独立性**：第三方在干净构建上独立复验 20 次（结论见 §2.4 与 T-04 记录）。
- **判据修正（重要）**：**墙钟不可作为门控判据**。40 次中 `run_10 = 41.9s`、`run_11 = 115.9s` 严重离群
  （正常 10~12s），但逐行 diff 仅 **RTC 取值字节**差异、relay 段无重试无超时、五项指标全过 ⇒ 主机层停顿。
  正确判据：`EXIT==0 且 ok==252 且 skip==0 且 mismatch==0 且 你是 2P==1`；墙钟 >15s 只作 **triage**
  （要求贴 relay 段 + diff 正常次日志）。**「未进一步定位到具体原因（磁盘/调度/杀软扫描未区分）」这句不可省。**
  可复核的定位信息：`diff run_09.log run_11.log` = **12 行**，全部形如
  `GBA Pak Hardware: RTC output byte 41/31` vs `44/03`；
  `grep -c "正在连接中继\|正在加入房间" run_11.log` = **2**（各 1 次）⇒ 无重试；
  `grep -ciE "timeout|连不上"` = **0**。
- **影响边界（务必保留，措辞按第三方独立 grep 结果收紧）**：全仓 `grep` 确认
  `mobileRelayCreate` / `mobileRelayCreateRoom` / `mobileRelayJoinRoom` 的**唯一调用方是 `mobile_test.c`**，
  其余仅出现在 `remote_link.c`（定义）与 `remote_link.h`（声明）。
  ⇒ 准确表述是「**库代码中的潜伏缺陷已修，但该库当前无生产调用方**」；
  **不要**写成「产品代码里的缺陷已修」（会被读成「线上联机行为变了」）。
  Android 真机联机走 `GBoyCloudLink`（KCP/UDP），不经过这段 C 代码。
  任何将来接入「手机自带中继」的前端，修前会继承此缺陷、修后不再继承。

#### KL-8 · `SO_REUSEADDR` 在 Windows 使端口扫描失效（独立缺陷 · **Rev.13 已修 `9015a1c57`**）

- **现象**：`remote_link.c` 的 `startEmbedded` 用 `SO_REUSEADDR` 绑 `INADDR_ANY`。
  **Windows 的 `SO_REUSEADDR` 允许他人重复绑定同一端口**（与 Unix 语义不同），
  因此 8766..8773 的扫描在 Windows 上**等于死代码**：端口被占也照样「成功」绑 8766，
  两个实例的 relay 会抢同一端口的连接（表现为对端读到不属于本协议的报文 / 握手错乱）。
- **与 KL-7 的关系（必须写清）**：**不是本次 1/40 的原因** —— 独占端口下仍复现 3/10000。
  两者是独立缺陷，**不要把它当 KL-7 的根因去「修」**。
- **实测数据（2026-11-15，本机 Windows；三组，均用独立 Python harness，未改仓库）**：
  1. **E1 前提验证**：进程 A 与进程 B **同时**用 `SO_REUSEADDR` 绑 8766 ⇒ **两者都成功**（`BIND_OK` ×2）
     ⇒ 确认扫描在 Windows 上不会顺延，缺陷前提成立。
  2. **E2 修复可行性**：第二个进程改用 `SO_EXCLUSIVEADDRUSE` ⇒ **bind 失败，
     `WSAEADDRINUSE`/`10048`** ⇒ 扫描能真正顺延到 8767 ⇒ 修复方向可行。
  3. **E3 TIME_WAIT 兼容性（原本缺的那块数据）**：服务端先关闭连接、留下 `8766→*` 的 `TIME_WAIT`，
     **20 轮中 20 轮存在 TIME_WAIT，且独占重绑 20/20 成功**
     ⇒ **不会破坏「退出房间后立刻重新建房」的快速重启**。
     （测试构造要点：服务端 `accept` 后必须先把数据读掉再 `close`，否则带未读数据的关闭会发 RST，
     RST 会跳过 TIME_WAIT，导致测出一个假的「无 TIME_WAIT 也成功」。首次实验即踩此坑，已修正。）
- **修复**：`#ifdef _WIN32` 下改用 `SO_EXCLUSIVEADDRUSE`；其它平台保留 `SO_REUSEADDR`
  （Unix 语义正确、且 `SO_EXCLUSIVEADDRUSE` 是 Windows 专有）。注释就地写明 Android 不受影响、
  以及 TIME_WAIT 实测结论，防止后人回退。
- **验证**：重编 `mgba_mobile_test` 与 `test-gboylink` 后，严格 ROM 下 **5/5**
  `EXIT=0 / 252 ok / 0 skip / mismatch=0 / 你是 2P=1`；`--c0` 45 ok、`--gatetest` 85 ok，均 EXIT=0。
- **残留风险**：本次只验证了「本机 Windows」。跨平台差异（其它 Windows 版本的 TIME_WAIT 行为）未测；
  若将来在别的 Windows 上出现「立刻重新建房失败」，先查这里。

---

## §6 推送纪律（原样收录）与人工审批

### 6.1 推送纪律（硬约束 · 原样收录，不得改写）
> 本地 master 历史含约 2.4 万 tmp 文件，**禁止 push 本地 master、禁止 --force**；正确做法是 `git read-tree FETCH_HEAD` + 临时索引 `GIT_INDEX_FILE` + `git commit-tree` + `git push <C>:main`。

补充事实（如实收录，非改写）：`.gitignore` 已含 `/.zcode-tmp/`、`/.workbuddy/`，那些 tmp 文件是被 `git add -f` 强加进去的。当前分支 `master`；Rev.3 核查时 `git status --short` 显示 3 个源码文件 `M` 与 `design/` / `docs/` / `production/` / `tests/` 未跟踪项（并发会话改动，本任务不触碰、不提交）——**执行推送前必须再确认一次远端目标为 `<C>:main`**。

### 6.2 高影响动作须人工审批（清单）
- 上线 / 发布 2P 联机功能到远端 `main`。
- 执行 `git push <C>:main`（含 `read-tree` / `GIT_INDEX_FILE` / `commit-tree` 全流程）。
- 热修（hotfix）的触发与执行。
- 版本回退 / 回滚到上一已放行构建。
- **切换三端默认联机模式（PC / Android `officialMode` 对齐 / AUTO 默认策略变更）——Rev.3 明确保留**：AUTO 默认虽已由 T-03 代码落地，但默认策略的任何进一步变更仍属高影响动作，本轮未执行。
- 能力协商失败时启用任何非 fail 的处理策略（即放宽「不一致即 fail」）。
- **教程正式改写发布（改根目录 `安卓版完整使用教程.md` / `PC版完整使用教程.md`，含 §5.2 的 8 处文本）——Rev.3 明确保留，本轮未执行**。
- 对 FAIL 门控 Blockers 的任何书面豁免。

---

## §7 发布风险与缓解

| # | 风险 | 影响 | 缓解 | 责任门 |
| --- | --- | --- | --- | --- |
| R1 | **产物一致性**：`build-win/dist/test-gboylink.exe`（11-14 14:39）落后 `build-win/qt/test-gboylink.exe`（11-15 04:44）；`build-win/qt/libmgba.dll`（11-14 23:04）≠ `build-win/libmgba.dll`（11-15 04:20） | 回归跑在旧二进制上 → **假绿**，掩盖真实缺陷 | §2.1 / §2.2 强制 `cp -f` + `cmp`/sha256 校验，作为构建后第一、二步，未同步不得进入 §2.3 | 构建 / 发布 |
| R2 | **【Rev.3 改判】两套帧格式并存**：path A 的 20 字节 SIO 包与 path B 的按键帧不能同流（`CloudLink.cpp:608-610` 记 9470 碎片包事故）；path A 曾把整份 savestate 灌进 SIO 20 字节管道 | 联机卡死 / 帧边界破坏 / 状态污染 | ✅ **AUTO 默认 + `mode` 能力协商已落地**（§3.7），不一致直接 fail；`!m_officialMode` 门控已消除 savestate 混入；仍须由按路径分列的端到端验收矩阵锁住（§3.1 / R10）。**原「PC 默认 A / Android 默认 B 且无能力协商」的表述已撤回** | T-03 / 质量门 |
| R3 | **iOS 口径与教程承诺不符**：教程写「手机和 PC 能互连」「三条通道」，但 iOS 无 path A、2P 不可用；stub typecheck 漏检过真实 UIKit 签名错误 | 用户按教程操作必失败；本地 0 error 误判编译通过 | §5.2 A/B/C + D-2 / D-8 教程改写（**正式发布属 §6.2 人工审批，未执行**）+ §2.6 明确「编译门以 CI xcodebuild 为唯一权威」+ §3.4 新 CI job 验证；裁定 ④ 隐藏「改用兼容模式」 | 文档 / iOS CI |
| R4 | **云端 2P 从未闭环但存在「已闭环」表述**：所有 `flow_*.log` BATTLE 计数全 0，「房间 830480 连续 20 个采样」缺落盘 logcat 佐证 | 据串线证据提前放行，上线即不可用 | F19 判据（§3.6）作为硬门：必须落盘 logcat + 双端截图 + 全量 PEEK 且 `BATTLE=YES 计数 > 0`；本机诊断腿不得替代跨设备证据 | 质量门 / E2E |
| R5 | **【Rev.3 补符号级证据】`busgame-lockstep` 判据假阴性（根因已定位，修复中）**：`gboylink_test.cpp:2693-2700` 把 `battle_main.o` 区间写死成旧 ROM 常量 | 明明进了对战却报「未进」，掩盖真实回归状态；反向也可能把误判结果当绿灯 | **符号级证据**：新 ROM 腿 `lastCb2=080B3169` = `rom.map:7204 BattleMainCB2 0x080b3168` **+1**；旧腿 `0809AFCD` = `syms.txt:249127 0809afcd BattleMainCB2`（§3.13）。**判据动态化四项进行中**：从 `.map` 取区间 + ROM md5 绑定 + 双腿验证 + `.map` 缺失报 `STALE_BATTLE_WINDOW`。⛔ **修复与双腿验证完成前，该脚本仍只是 long/flaky 诊断入口、不是绿灯用例、不得作为放行依据**（§3.13 / §2.4）；固化 `tools/busgame-lockstep.sh` 参数与存档母本隔离不变 | T-03 / 测试 / 发布 |
| R6 | **推送纪律**：本地 `master` 含约 2.4 万 tmp 文件，最容易误 `push origin master` / `--force` | 远端历史被污染、不可逆 | §6.1 原样收录推送纪律；§6.2 把 push 列为人工审批动作；执行前复核远端目标为 `<C>:main` | 发布 / 人工审批 |
| R7 | **path A 借壳 type 6 的空 blob 误断链**：Android `GBoyLinkSession.onFrameBody` 的 `case TYPE_STATE` 无条件 `events.onState(stateOf(body))`，PC `CloudLink.cpp:2367` 却有 `if (!state.isEmpty())`；裸 20 字节 SIO 桥包判空后仍派发 → `STATE_ERROR(1)` → `EmulatorActivity.close()` | path A 直连一收到借壳 SIO 包就断链；跨端行为不一致，PC 侧不复现，易被误判为网络问题 | **状态：修复中，已指派 T-03 修 main 侧**（§3.12）。补空 blob 门控对齐 PC，落端到端断言；修复前 path A 不得放行。热修触发见 §4.3，断链策略见 §4.5 第 7 条 | T-03 / 质量门 |
| R8 | **【Rev.3 补强】绝对地址判据在 ROM 会被重编译的前提下不可靠**：`/d/gen8/rom.gba` 被并发会话重编译（md5 `074cfcdb…`、mtime 13:51:30），`battle_main.o` 地址整体 `+0x16E64`；写死的 `cb2` 精确值 / 区间常量在新 ROM 上全部失效 | 把「真进对战」误判为「未进」；F19 判据（§3.6）、busgame 判据（§3.13）、历史落盘结论全部可能失真 | **符号级证据进一步坐实**：两腿 `cb2` 精确落在各自 ROM 的 `BattleMainCB2` 符号上（R5）⇒ 判据应绑**符号**而非绝对地址。缓解：从当前 ROM `.map` 动态解析 `battle_main.o` / `BattleMainCB2`；判据输出绑定 ROM md5 / mtime；**新旧 ROM 双腿复跑**；`.map` 缺失报 `STALE_BATTLE_WINDOW`；并发会话重编译 ROM 纳入构建前核查。**禁用一切写死绝对地址的产品验收判据** | T-03 / 质量门 / 构建 |
| R9 | **【Rev.3 采样数更新】C 层低频 flaky 未隔离**：`mgba_mobile_test` **18 次采样 1 次 `EXIT=1` / 17 次 `EXIT=0`**，首次失败完整日志未留存 | CI 信号不干净，单次全绿可掩盖偶发失败；热修回归与放行判定失去可信基线；C/Qt 本地回归门 CONCERNS | §3.11 扩大采样（T-04 进行中）、留存每次完整日志、复现并定位 / 隔离 flaky；隔离前 `mgba_mobile_test` 多次采样方可用、且**不得作为干净 CI 信号**；热修回归按 §4.3 多次采样 | T-04 / 质量门 |
| **R10** | **【Rev.3 新增】AC1–AC6 口径分裂**：AC1–AC6 是 **path B 语义**（互发整份 savestate 给隐藏镜像核 / 只灌隐藏核 / 载入不复位 / 不冲掉可见核进度）；而 **2P 首选 path A 无镜像核**、`!m_officialMode` 门控**明确不发整份 savestate** | 用 path B 的 AC 判 path A 的可用性 → 把「path A 正确地不发存档」误判为功能缺失；按错误矩阵补断言会做出与架构相反的产品改动；三套口径（教程 / AC / 架构）互相矛盾 | ⛔ **验收矩阵必须按 path A / path B 分列，禁止用 path B 的 AC 判 path A 的可用性**（§3.1 / §2.4 / §4.5 第 8 条）。T-04 正在分列；教程承诺 d 按模式分别陈述（§5.2 D-1）；上线前做「教程文案 ↔ 实现行为」对拍。path A 侧另立对应验收项（不交换存档 / 帧格式隔离 / 失败即断链） | T-04 / 质量门 / T-06 |
| **R11** | **【Rev.3 新增】教程承诺与架构脱节 + 自救可达性差异**：7 条产品既有承诺中「互发即时存档」「帧格式完全一致」「内容必须一致」「打不通不报错」等仍按旧架构写；Android 仅 ADB 广播可达、无 UI 复选框 | 用户按教程操作必产生与预期不符的结果；失败提示要求「统一模式」但 Android 普通玩家无界面可照做 → 无效重连循环；支持成本上升 | §5.2 合并 T-05 §4 的 8 处改写文本（**正式发布属 §6.2 人工审批，未执行**）；§5.3 裁定 ① 的 S3 分平台可执行步骤 + 一键复制命令（零新增产品代码）待 T-03 落地；`mode` 不一致时「重试」置灰并给原因；Android UI 复选框属延后项（T-05 判断 3 / D3），不得私做以绕过审批 | T-06 / T-03 / 人工审批 |
| **R12** | **【Rev.4 新增】iOS × path A 不可互操作被误读为「故障」**：iOS 无 path A（`ios/` grep `sioRelay`/`pathA` 零命中），与 PC / Android 组 2P 房间**按设计硬拒绝并断开**（KL-1）；叠加 AUTO 2 人→A（KL-2）使 iOS 建 2 人房必然命中 | 玩家把**设计内硬拒绝**读成「软件坏了 / 网络故障」→ 流失与负面口碑；支持侧误判为 bug 并反复重连 | §5.4 KL-1 / KL-2 已登记为**交付范围边界**；对外文案须**直说**「iOS 目前只能与 iOS 组 3/4 人 B 模式房间」并给规避方式（3/4 人房 / PC、Android 显式覆盖 B）；失败文案指名 iOS、隐藏「改用兼容模式」（裁定 ④）；**不得把硬拒绝写成崩溃或静默降级** | T-06 / 文档 / 支持 |
| **R13** | **【Rev.5 新增 / Rev.9 收窄粒度】`--gatetest` / `--c0` 的「全 PASS」被误读为「协商门已全部验证」**：`--c0` 只证帧格式、`--gatetest` 证五类判定 + **INVALID 判定分支（用例 11）** + **短路先于重绑的顺序（用例 12）** + 等待时序语义 + 失败幂等（注入泵驱动）；但**真实 WSS 会话下的端到端网络时序**（`sig->recv(60)` 真实行为、服务器推送节奏）**未覆盖**，2 s 有界等待也**未在真实云端链路实测**（KL-5） | 用本地绿灯替代真机结论 → 把「未覆盖的真网络时序」当已验证放行；真机出现协商超时/文案异常时无预期基线；亦易误读「用例 4/7 绿 = INVALID 判定不放行」（实为早退）或「短路与重绑顺序无关」（实为用例 12 钉住） | §2.4 已逐条标注「已覆盖（判定 / INVALID 分支 / 短路先于重绑 / 时序语义 / 失败幂等）/ 未覆盖（真会话端到端时序）」；§3.7 保持 `◐` 不标完成；KL-5 登记真网络时序缺口；**不得以 `--gatetest` / `--c0` 全 PASS 作为 2P 云端放行依据**（门控仍 FAIL） | T-06 / 质量门 |
| **R14** | **【2026-11-17 新增】跨设备 2P 云端 8 项证据全部缺位 + 并发提交未绑版本**：XD-1~XD-8（ADR-004 §3）无一条真实跨设备 E2E 落盘证据；workbuddy 持续提交 `联机`（顶部 6 条），任何 agent 的「绿灯」若未绑定 commit + 二进制 md5 不可引用；`MEMORY.md` 与 Rev.12 块的 C/Qt 门状态分歧未裁定 | 把同机双实例/本机 4 核的 `BATTLE=YES` 当成跨设备闭环 → 上线即不可用；并行提交污染证据归属 | §3.15 保持 `[ ]`、门维持 FAIL；跨设备证据必须两账号两 uuid + 双端设备 + 启动时序（§0 跨设备块）；证据绑定 commit/二进制 md5/源码 md5/落盘日志（XD-8）；C/Qt 门分歧放行前人工对账（ADR-004 §5 R-10-5）。**10-agent 冲刺产物复核前不得签署 go** | 10 agents / 人工审批 |

---

## §8 发布门控建议判定

> **主判定：FAIL**（三选一：PASS / CONCERNS / **FAIL**）
> 适用范围：**限定「2P 云端交付门」**。**C/Qt 本地回归门：CONCERNS（C 层低频 flaky 未隔离，由 PASS 降级）**——两者分列，**禁止用 C/Qt 本地结果、汇总 ok 数、`6/6 PASS` 或单腿 `BATTLE=YES` 代替 2P 云端分路径结论**。
> **本冲刺不得建议放行。**

**具体阻塞项（未清即不 go）：**
1. AC1–AC6 **端到端断言仍为 0**（§3.1）——4 组协议层纯 JVM 断言只是**部分缓解**；**且验收矩阵尚未按 path A / path B 分列（R10），不得用 path B 的 AC 判 path A 可用性**。
2. **2P 云端断言按层分列（§3.3）**：① 协商门层**已有** `--gatetest` 断言（直驱 `negotiateLinkMode()` 本体、五类判定全覆盖、条数以当次输出为准）；② **云端数据通路端到端 0 条**；③ **跨设备真机 E2E 0 条**，所有云端 `flow_*.log` BATTLE 计数全 0（§3.6）。**跨设备 E2E 未闭环**（分层口径详版见 §2.4 / §3.3）。
3. iOS CI #65 **缺新 job 验证**，runtime check 从未执行；本地 stub typecheck 非编译门（§3.4）。
4. 真机 Playtest 未做；AVD 全绿不等于真机可用；**帧率三档 50 / 10 fps 待分端真机校准**（§3.5 / §5.3 决策 ③）。
5. path A 头号阻塞：PC `C0000005` 崩溃**未找到已修证据**；`sioFastFrame` 未移植 Android native（§3.8 / §3.9）。
6. **【Rev.3 改判】能力协商与 AUTO 默认已落地，但剩余可达性缺口未清**（§3.7）：Android 仅 ADB 广播可达、**无 UI 复选框**；iOS 2P 房间会可见协商失败、隐藏「改用兼容模式」待落地；S3 分平台可执行步骤 + 一键复制命令（裁定 ①）待 T-03 落地。**「切换三端默认联机模式」仍属 §6.2 人工审批、本轮未执行**。
7. 构建产物一致性缺口（dist 测试程序 / `qt/libmgba.dll`）未同步（§2.1 / §2.2 / §3.10）；默认模式对齐部分已落地。
8. **【Rev.3 更新】C 层低频 flaky 未隔离**（§3.11 / R9）：**18 次采样 1 次 `EXIT=1` / 17 次 `EXIT=0`**、失败日志未留存；**C/Qt 门 CONCERNS**。
9. **【Rev.3 补强】`busgame-lockstep` 判据假阴性、符号级证据坐实、修复中**（§3.13 / R5 / R8）：新腿 `080B3169` = `rom.map:7204 BattleMainCB2 0x080b3168 +1`，旧腿 `0809AFCD` = `syms.txt:249127 0809afcd BattleMainCB2`；判据动态化四项（`.map` 取区间 + ROM md5 绑定 + 双腿验证 + `STALE_BATTLE_WINDOW`）进行中。⛔ **修复与新旧 ROM 双腿复跑验证完成前，仍不得作为放行依据**。
10. **path A 借壳 type 6 空 blob 误断链，T-03 修复中**（§3.12 / R7）：不得标完成。
11. **绝对地址判据不可靠**（§7 R8）：F19 与 busgame 判据须改为 `.map` 动态解析并完成双腿复跑。
12. **【Rev.3 新增】教程承诺一致性收口未完成**（§3.14 / R11）：T-05 §4 的 8 处改写文本已合并进 §5.2，但**正式改写发布教程属 §6.2 人工审批、本轮未执行**；上线前须做「教程文案 ↔ 实现行为」对拍。
13. **【Rev.3 新增】产品口径已裁定但落地未验**（§5.3）：四项决策采纳 A，其中裁定 ①（自救路径）、②（命名与席位）、③（帧率三档）、④（iOS 口径）的 UI / 文案落地状态未逐项验收；**不得把「口径已裁定」写成「功能已交付」**。
14. **【Rev.4 新增】已知限制为交付范围边界，非待修项**（§5.4）：KL-1 iOS 无 path A 且 2P 房间硬拒绝、KL-2 AUTO 对 iOS 不友好、KL-3 `allow_legacy` 不建议用于交付、KL-4 四条未解除限制（跨设备云端 2P 未闭环 / PC path A `C0000005` / `sioFastFrame` 仅 PC-Qt / 2P 局域网 ADB 零覆盖）；**【Rev.5 新增 KL-5】协商门 2 s 有界等待从未在真实云端链路实测**（`--gatetest` 只覆盖 `waitAndProcess()` 分支，`m_session` 可用时的 `drainSignaling()` 主路径未覆盖）。⛔ **以上不得写成「已修复」或 TODO；对外文案须按 §5.4 原文口径表述**，任何弱化表述均视为口径违规（另见 §7 R12）。
15. **【Rev.5 新增 / Rev.9 更新】`--c0` / `--gatetest` 覆盖边界**（§2.4 / §3.7 / KL-5）：`--c0` 证**帧格式正确**；`--gatetest` 证**协商门五类判定 + INVALID 判定分支（用例 11）+ 短路先于重绑的顺序（用例 12）+ 等待时序语义 + 失败幂等**。两者判据均为**全 PASS / 0 FAIL、`EXIT=0`**，**条数与用例数以当次输出为准、不要写死**（`--c0` 约 0.2 s；`--gatetest` 约 8.7~9.3 s，条数随补做增长：40 → 56 → 64 → 76 → 81…）。⛔ 但**真实 WSS 会话下的端到端网络时序未覆盖**（`sig->recv(60)` 真实行为与服务器推送节奏未实测）、2 s 有界等待未在真实云端链路实测。⛔ **不得表述为「2P 协商门已验证通过」**，也不得把 `--c0` 与 `--gatetest` 合并成一句「C0 已验证」。**门控判定不变：2P 云端交付门 FAIL。**
16. **【2026-11-17 新增】跨设备 2P 云端 8 项证据全部缺位**（§3.15 / §0 跨设备块 / §7 R14 / ADR-004 §3 / 矩阵 §0-D）：XD-1~XD-8 无一条真实跨设备 E2E 落盘证据；**所有同机 `BATTLE=YES`（双 PC 实例 / 本机 4 核锁步）均不算**。10-agent 冲刺产物到位并绑定 commit/二进制 md5 后复核前，**本项保持阻塞、门维持 FAIL**。

**本轮已闭环 / 改判（不计入上述阻塞，但不改变主判定）：**
- ✅ 3.2 Android 6 个 plain JVM 自检接入 Gradle **已闭环**：`:app:runLinkSelfTests` `6/6 PASS` / `EXIT=0`（门禁请用 `runLinkSelfTests`，不要用 `testDebugUnitTest`）。
- ✅ **默认模式不一致阻塞项改判**：AUTO 默认 `resolveLinkMode(playerCount)`（2P→A、3/4P→B）+ `mode` 能力协商**已落地**，PC 大厅下拉框可 UI 自救；剩余可达性缺口转入第 6 条阻塞。
- ◐ 3.1 AC1–AC6 **部分缓解**：4 组协议层断言通过，端到端仍 0，且新增 R10 口径分裂约束。
- ◐ `busgame-lockstep` 两次 `BATTLE=NO` **根因已由符号级证据坐实**（判据假阴性，非架构失败），判据动态化修复中。
- ◐ **教程改写草案收口**：T-05 §4 的 8 处文本已合并进 §5.2 并标注来源；**仅落在清单内，未改根目录教程**。
- ◐ **产品口径已裁定**：T-05 四项决策全部采纳 A（§5.3）；口径生效、落地未执行。

**下一轮建议（按依赖顺序）：** C 层 flaky 扩大采样并隔离（恢复干净 CI 基线）→ 判据动态化四项 + 新旧 ROM 双腿复跑 → path A 空 blob 门控修复与端到端断言 → **验收矩阵按 path A / path B 分列（T-04，解 R10）** → **裁定 ① 的 S3 分平台自救步骤落地 + Android 可达性方案** → 裁定 ②/③/④ 的 UI 与文案验收 → **教程 8 处改写经人工审批落地并做文案 ↔ 实现对拍** → 产物同步与构建后清单固化 → 真机 Playtest（含帧率三档分端校准）→ 跨设备 E2E（F19 判据，按新 ROM 符号区间）→ 重新召集 go/no-go。
