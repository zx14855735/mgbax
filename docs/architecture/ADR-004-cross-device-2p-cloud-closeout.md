# ADR-004 · 跨设备 2P 云端收口计划（10-Agent 冲刺的执行口径）

- 状态：**计划 / 未验收**。本文不宣称任何跨设备 2P 云端闭环；门控维持 **2P 云端交付门 = FAIL**。
- 日期：2026-11-17（10 个并行 agent 冲刺期间，文档/综合 agent 第 10 号落盘）
- 相关：`ADR-003-cloud-2p-framerate.md`（§4.2 h.3–h.6、§6、§7 R-1..R-8、§4.4）、
  `ADR-002-2p-patha-capability-negotiation.md`（C0 能力协商）、
  `.workbuddy/memory/MEMORY.md` §1/§5/§7、`.workbuddy/memory/2026-11-16.md`、
  `tests/2p-cloud/AC1-AC6-验收矩阵.md`、`production/release/2p-link-release-checklist.md`、
  `production/sprint-2p/HANDOVER-10-agents.md`。

> **纪律（沿用 `production/sprint-2p/T-03-busgame-root-cause.md` 开头）**：
> 事实与推断分列；没有证据的地方明确写「未找到证据」；不把「定位到根因」写成「已修好」，
> 不把「本机双实例 / 本机 4 核锁步的 `BATTLE=YES`」写成「跨设备 2P 云端已闭环」。
> 任何「已闭环」的判断都必须绑定具体 commit + 二进制 md5 + 落盘日志（独立复核报告
> `production/qa/2p-independent-review-0be5da192.md` 的元结论）。

---

## 0. 单一目标与诚实门控状态

### 0.1 单一目标（本冲刺唯一口径）

**让「跨设备 2P 云端」真正进球场对打并稳定 60fps，拿到机器可判定的端到端证据。**

「跨设备」在本 ADR 中有严格含义，缺一不算：

1. **两个不同云端账号**（同账号会让先登录者 token 失效，`MEMORY.md:68`）；
2. **两个不同 game uuid**（uuid = `"BPEE," + ROM md5`；同 ROM 会被服务器当同一玩家，
   消息只回显 `"self":true`，`MEMORY.md:69`）；做法是 PC 用 1 字节填充改过的
   `rom_b.gba` + 独立 `.sav`，app 用另一份 ROM（`:70`）；
3. **两台物理上分开的设备 / 端到端**：PC ↔ Android、PC ↔ iOS，或两台真机；
   启动顺序为先 app 作 host（CLOUD 广播不带 room，等 `advertised relay ... for room <R>`），
   再起 PC `MGBAX_AUTOLINK="邮箱:密码:R"`，之后**不得重启 app**（`MEMORY.md:71-73`）。

> ⛔ **本机两个 PC 实例经 P2P/回环的「代理」拓扑不算跨设备**。ADR-003 §4.1 的
> `lstate=4 pc=2 + 59.7~60.3fps`、2026-11-16 的 FR6/TR44 等，全部是**同机进程**证据
> （同一台 PC 上的两个实例或两个 mGBA 核），只证明链路层可达，不构成 §3 的放行证据。

### 0.2 门控状态（分列，禁止用汇总 ok 数互相替代）

| 门 | 本 ADR 采用的状态 | 依据 | 需审计的分歧 |
|---|---|---|---|
| **2P 云端交付门** | **FAIL**（从未跨设备端到端进对战；所有 `flow_*.log` 的 `BATTLE` 计数全 0） | `MEMORY.md:4-6`、AC 矩阵 §0-C③/§7、`production/qa/2p-independent-review-0be5da192.md` §0 | 无分歧，10 个 agent 都不得推翻 |
| **C/Qt 本地回归门** | **CONCERNS** | `MEMORY.md:7-9`：C 全套 242 / 40 / 37 / 164 / 169 / 64 全 0 FAIL，Qt `frames`/`buslocal`/`product-lockstep`/`busgame-lockstep` 全 EXIT=0，但 `mgba_mobile_test` 38 次采样 1 次 EXIT=1（flaky，已标 QUARANTINED） | ⚠ `production/release/2p-link-release-checklist.md` §0 的 **Rev.12 块**声称该门由 CONCERNS 升为 **PASS**（依据 §5.4 KL-7 的 `fdfc23290` 修复 + 60/60 全绿）。**本 ADR 不裁定这处分歧**；两份文档对同一门给出不同结论，放行前必须人工对账并统一口径。见 §5 风险 R-11 |
| **C0 能力协商** | **CONCERNS** | `MEMORY.md:10-11`：PC 侧完整；Android 缺口 B1 `negotiateLinkMode()` 无 UNKNOWN 有界等待、B2 `runManual()` 无协商门 | Agent5 / Agent9 在补 |

**结论（事实）**：本冲刺开始时，2P 云端门 FAIL；10 个 agent 并行改动尚未产生任何
跨设备 E2E 的 `BATTLE=YES` 落盘证据。本 ADR 落盘时（2026-11-17），
`git log` 顶部为 workbuddy 的 6 个 `联机` 提交（`0d0bc46c7` / `954078a9f` / `340f94ec3` /
`4696726dd` / `06edb15c2` / `ab369caa5`），工作区另有对
`docs/architecture/ADR-003-cloud-2p-framerate.md` 的未提交改动（§4.4），**本文不覆盖该文件**。

---

## 1. 已知阻塞项全表（含精确 file:line 与证据）

> 下表只列「有落盘证据或源码核对」的阻塞项。每条标注证据出处与状态，
> **未找到证据**的条目单独写明。行号来自上述文档记录，并发会话会使其漂移，
> 以符号名 / 类名 / 方法名为准。

### 1.1 path A 三条硬前置（`MEMORY.md:21-23`，全部未解）

| # | 阻塞 | 精确位置 / 证据 | 现状 |
|---|---|---|---|
| BLK-A1 | PC path A 进战斗后 `C0000005` 崩溃，无已修证据 | `2026-11-08.md:934-937`；`cb=081520D1`，进战斗后 50~200s | **未找到已修证据** |
| BLK-A2 | Android native 无 `sioFastFrame` 等价实现（实测 4.6~4.9fps） | `src/platform/mobile/mgba_mobile.c`（`mobileFastFrame` 门与 Qt 对齐但仍缺完整 path A 快帧）；AC 矩阵 PA7；`MEMORY.md:22` | 未闭环 |
| BLK-A3 | iOS 完全没有 path A | `ADR-003` §5；AC 矩阵 §0/§5 | 未闭环；iOS 仅 path B |

### 1.2 帧格式 / savestate 同流风险（`MEMORY.md:24-32`）

| # | 阻塞 | 精确位置 / 证据 | 现状 |
|---|---|---|---|
| BLK-F1 | path A 里发整份 savestate，破坏 20 字节帧边界 | `src/platform/qt/CloudLink.cpp:1723`（`startSioRelayBridge`）/`:2319`（`serve`）发送；接收侧 `:1748-1763` 把 payload 原样写回 netLink socket | 已加门控 `maybeSendInitialState():2378`（`!m_officialMode` 时 return false，提交 `24902fc6d`）；**门控本身无专用自动断言**（AC 矩阵 PA3） |
| BLK-F2 | 两套帧格式同流耗死读线程 | `CloudLink.cpp:608-610`（历史事故：9470 个碎片包） | C0 能力协商位隔离，但端到端「不降级 + 可见失败」仍需 mock |
| BLK-F3 | C0 能力协商 Android 两处缺口 | B1 `negotiateLinkMode()` 无 UNKNOWN 有界等待；B2 `runManual()` 无协商门（`MEMORY.md:10-11`） | 未闭环 |

> **勿回退**：`type 6` 三语义与官方一致（`NETPLAY_SPEC.md:69,84,90`），
> `GBoyCloudLink.startSioRelayBridge()`（`GBoyCloudLink.java:1469`）是本仓自家类「借壳 type 6」；
> **不要全量改回 SIO 包中继**（`MEMORY.md:28-32`）。

### 1.3 握手 / 收尾链路（`ADR-003` §4.2 h.3–h.6）

| # | 阻塞 | 精确位置 / 证据 | 现状 |
|---|---|---|---|
| BLK-H1 | 主机不设 `handshakeAsMaster` → 一直发 `0xB9A0`，全场无 `0x8FFF` | `ADR-003` §4.2 h.3：`SLOT n=192 me=0 data=B9A0,B9A0 pc=2 lstate=2 im=8 hs=0`；`link.c:1980/2000/2289`；修法在 `sio_link.c::maybeRearmHandshake` 每轮置位（原每 64 轮） | h.4 后提议每轮补触发；**状态需重验** |
| BLK-H2 | 从机轮周期跟不上主机 → 丢轮 → `playerCount` 掉 1 → 游戏判人数不对拆链 | `ADR-003` §4.2 h.3：`multi_B idx=192 ok=192 last=68902.4ms to=58832 mis=192`；`sio_link.c:1039-1050`（从机只在成功取字后更新周期）；`link.c:838`、`cable_club.c:360`、`link.c:1926` | `mis≈成功轮数` 是健康读数（h.3 注），**不可当故障证据** |
| BLK-H3 | cmd 阶段一字相位差（推翻「轮次不同步」） | `ADR-003` §4.2 h.4：`n=21` 两端 `8FFF,B9A0 pc=2 lstate=4`；`n=22` 主机自槽切 `2222`、从机仍 `B9A0`；从机扣字在 `sio_link.c:1856`，主机在 `:1686`；`link.c:1252`（仅主机发 `2222`）、`:543`、`:894` | 机理已定位，产品链路未闭环 |
| BLK-H4 | `linkup=1` 是残留值陷阱，不能当成功判据 | `ADR-003` §4.2 h.5：`linkup=1` 出现 297 次但 `role=im0/lid0/hs0`、`st=0`、`menu=w2`；真成功全场只 1 次 `lstate=4 pc=2 st=00000828` | **判据已钉死**：成功 = `lstate=4 && pc=2 && st 含 MASTER(0x20)` 的稳定态 |
| BLK-H5 | LAG_MASTER 拆链（握手后快帧门太晚） | `ADR-003` §4.2 h.6：`PHASE3 A n=34 st=0x368` → `n=46 st=0x10368`（LAG_MASTER 0x10000）；`link.c:2228`（serialIntrCounter 预置 8）、`:2159-2170`（LinkVSync）、`:1606`（CheckErrorStatus）；修法 `sioFastGateReadyEx` / `MGBAX_FAST_MIN_OK=8` | 主机侧 FASTEARLY1 `n=64 ls=4 pc=2 st=0x368` 救回；从机 `n=64 pc=0 st=0x2249`（badChecksum 0x2000）新卡点 |
| BLK-H6 | 从机飞转复用旧字 → badChecksum | `ADR-003` §4.2 h.6 / `MEMORY.md` 11-16 12:30-12:45：`FASTEARLY1 B idx=482 ok=1600~2304`；`sioFastFrameSlave` 固定 256 | FASTEARLY3 从机 badChecksum=0、idx 同步；产品链路仍未端到端进对战 |
| BLK-H7 | 块交换完成判据误用 `brs` | `MEMORY.md` 11-16 13:44：`brs`(=`gBlockReceivedStatus[4]`) 只对块请求 `0xCCCC` 后的资料块置位；训练家卡块故意不置 | 真判据 = `gReceivedRemoteLinkPlayers==1`（REMW 检查点）/ `ts` 0x80/0x82；勿用 brs 判「块没到」 |
| BLK-H8 | 握手「竞速不对称」独占收尾 | `MEMORY.md:294-302`：主机进 state4 后推命令字，从机仍 state2 要 `tempRecvBuffer[0]==0x8FFF` 连续两轮 ⇒ 超时 `cb2=0816CA9D` | 已提出 `sioHandshakeHold`（只加在从机），**未找到已实现/验证证据** |

### 1.4 §7 剩余动作 R-1..R-8（`ADR-003:667-678`）

| # | 事项 | 状态（照抄 ADR-003，未更新） | 最小动作 |
|---|---|---|---|
| R-1 | 球场对打帧率终测 | 未做；前置 R-8 未打通（读数停在俱乐部联机/柜台） | R-8 修好后两端进球场按下准备看 fps 贴 59~60 + `SIO fast on` 递增 `n=`（14ms 下命中数 0 属正常，§4.1） |
| R-2 | 握手段隧道 / 公网回环（72~159ms）太慢 | 协议上限；F5（连通后不跟随来源地址）**本轮未提交** | 修后验 `[sio-rtt] via=p2p avg=` 回 1~3ms、`[direct] 忽略来自 …` 消失 |
| R-3 | path B 做不到「全程 60fps」 | 本机 4 核 59.7fps，**真机跨设备整场只有 20~31fps**，且是「4 人房 + 2 NPC」不是 1v1 | 别把 path B 当解药；两端必须都设模式，C0 校验一致 |
| R-4 | P2P 候选交换单向 | 已修（F6/F7）；同机双实例双向拿到候选并 P2P 成功 | 跨设备 E2E 需复核 `peerCandidates_A/B>0` |
| R-5 | 双 PC 实例无法被驱动到联机态 | 已闭环（三根因：空存档 / 边沿触发 / 后台进程被回收），仅限同机 | 父进程看门狗 + 独立 TEMP + 判活三件套 |
| R-6 | 产品侧导航对当前 ROM 判据过期 | 本轮已修 N1/N2/N3 + (e)(f) 六处；path B 单机 4 核 BATTLE=YES 三次中两次 | 跨设备 path A 用新工具验 |
| R-7 | 双实例驱动没钉死联机模式 | 已修（`tools/cloud2p-duo.py` 显式 `--mode` 并落盘 `mode_negotiated_A/B`） | summary.txt 必查 |
| R-8 | path A 握手/收尾走不完 | 定位到机理、未修完（§4.2 g/h/h.1/h.2）；卡在第②段 cmd 交换 linkType、第③段块通道根本没开始（`n8=0`） | 仪表已装：`SLOT`/`N8`/`role=im/lid/hs/sc`；验证判据 = LINKUP 真判据 `lstate==4 && pc==2 && st 含 MASTER(0x20)` 稳定不回退（见 §1.3 BLK-H4；`linkup=1` 是菜单 A 残留值，已剔除、不作成功判据）+ `n8>0` |

### 1.5 path B 架构级错位与 iOS（`ADR-003` §4.4/§5、R-iOS-1..3）

| # | 阻塞 | 证据 | 现状 |
|---|---|---|---|
| BLK-B1 | PC path B 用「4 线程 + 自动导航脚本 + 跨线程总线/锁步会合」模拟官方「单线程顺序推进 + 真实按键」，结构性错位 | `ADR-003` §4.4（PB16–PB33 + gboy APK 源码比对）：官方单一模拟线程 `D8MqeW`、每帧一次 `Link.runFrame()`；官方 `Link.patch()` 零调用点；开局统一 reset + 帧闸 rendezvous（`AaHO0E.java:184-203`） | path B 停在「总线通但 pc=0」；唯一稳定 `BATTLE=YES` 是不含 Qt 可见核的 `busgame-product` |
| BLK-B2 | path B 真正的跨设备性能天花板 20~31fps | `ADR-003` R-3 | 与 1v1 目标不符 |
| BLK-iOS1 | iOS 缺 C0 能力协商（只走 B 且不发能力位） | `ADR-003` §5 / R-iOS-1：与 PC/Android 组 2P 房时对方约 2s 后断开、iOS 无提示 | 未闭环 |
| BLK-iOS2 | iOS 关不掉快帧，无法 A/B | `ADR-003` R-iOS-2 | 未闭环 |
| BLK-iOS3 | iOS 真机 0 证据 | `ADR-003` R-iOS-3：Windows 无 `xcodebuild`/iOS SDK | 未验证 |

### 1.6 已废弃、勿返工（`MEMORY.md:97-100`）

TCP 总线调参 / 帧级栅栏（死锁 frame≈11）/ serial 驱动 / `st>=4` 停手按键 /
盲按 DOWN 选模式 / 旧地址 `0x0809A241` /「ncore 仍走 TCP」/
「双向补发 TYPE_STATE」（隧道单条 ≤100 字符限制走不通）/「ROM 硬性要求 4 人」/
「必须维持 4 核/设备」。

---

## 2. 阻塞 → Agent 映射（10 个并行 agent）

> **事实**：以下分工来自主理人对 10 个 agent 的派单（见 `production/sprint-2p/HANDOVER-10-agents.md`）。
> **推断 / 待回填**：agent 尚未全部提交，本节仅按派单归属，不声称任何人「已修好」。

| Agent | 派单范围 | 负责的阻塞项 | 结果（待提交后回填） |
|---|---|---|---|
| 1 | Qt `src/platform/qt/sio_link.c` | BLK-H1/H2/H3/H5/H6/H8、BLK-A1（崩溃侧） | 待回填 |
| 2 | mobile `src/platform/mobile/mgba_mobile.c` | BLK-A2、R-6（N1/N2/N3）、移动端延迟线/锁存 | 待回填 |
| 3 | `src/platform/qt/CloudLink.cpp` | BLK-F1/F2、R-2/R-4（F5/F6/F7）、P2P 候选排序 | 待回填 |
| 4 | `tools/cloud2p-duo.py` 驱动 | BLK-H4（导航震荡/残留值陷阱）、R-5/R-7、§3 机器可读字段落盘 | 待回填 |
| 5 | Android `GBoyCloudLink.java` | BLK-F3（B1/B2）、BLK-A2（Android 侧）、2P 局域网 ADB 入口 | 待回填 |
| 6 | tests（AC 矩阵 / 自检 / cloudTest / cloudPairTest） | §3 机器可读证据的自动断言、数据通路 0 条 | 待回填 |
| 7 | `link_net` / `link_lockstep` | BLK-B1/B2（进程内总线/包语义）、跨设备按键传输 | 待回填 |
| 8 | `DirectLink` / `CoreController` / `GBoyMirror` | R-2/R-4（DirectLink 候选排序）、BLK-B1（单协调器）、BLK-A1（CoreController 崩溃侧） | 待回填 |
| 9 | iOS Swift | BLK-A3、BLK-iOS1/2/3 | 待回填 |
| 10 | 文档 / 综合（本 ADR 作者） | ADR-004、AC 矩阵 cross-device 行、发布清单、HANDOVER | 本文件即产出 |

---

## 3. 机器可读证据清单（门从 FAIL 翻 GREEN 的充分条件）

> **事实（口径来源）**：ADR-003 §6「现场判据（下次直接看这五处）」+
> `tools/cloud2p-duo.py` 的 `summary.txt` 字段（`:826-842`：`tag` /
> `mode_requested` / `mode_negotiated_A` / `mode_negotiated_B` / `official_mode_A` /
> `official_mode_B` / `nav_at_leak` / `exitcode_A` / `exitcode_B` / `linkup_s` /
> `final_A` / `final_B` / `rtt_A` / `rtt_B` / `multi_A` / `multi_B`）。
> **推断（本文综合）**：把上述字段组合成下面 8 条可判定项；每条必须**同时**满足，
> 且必须落在**同一次真实跨设备 E2E** 的落盘日志里（绑定 commit + 二进制 md5）。

| # | 机器可读项 | 精确判据 | 来源字段 / 落盘位置 | 当前状态 |
|---|---|---|---|---|
| E-1 | 两端 LINKUP 稳定态 | 两端 `[diag]` 同时 `lstate=4 && pc=2 && st` 含 `MASTER(0x20)`，**且 `st` 不含任何 `0x7F000` 错误位**，持续 ≥5s（多采样不回退到 `lstate=1 pc=0`） | `summary.txt` `final_A`/`final_B`（`snap()` 含 `l/pc/st`）；`%TEMP%/mgba_sio.log` 的 `[diag]`（须同时设 `MGBAX_SIO_LOG=1` + `MGBAX_LINK_DIAG=1`） | 同机双实例达成过；跨设备**未找到证据** |
| E-2 | 真实进对战帧 | `gMain.callback2 @0x020290E8` 落在**当前 ROM `.map` 动态解析**的 `battle_main.o .text` 区间（禁止写死 `0x08099848..0x080A30FD`），且 `BATTLE=YES`、`battleSamples>0`；判据绑定 ROM md5，`.map` 缺失报 `STALE_BATTLE_WINDOW` | 驱动结果 `BATTLE=YES` + 日志 `lastCb2`；`resolveBattleWindow(rom)`（AC 矩阵 §0-A） | 仅本机 4 核进程内锁步；跨设备 E2E `BATTLE` 计数全 0 |
| E-3 | 在战斗帧率 | 两端进球场对打后 PC 标题栏 fps 贴 **59~60**（≥50），稳定不回落；app `adb logcat -s mGBA:I` 可见 `SIO fast on` 与递增 `n=`（若 RTT 已在 14ms 量级命中数 0 属 §4.1 正常，不据此判失败） | `pcfps.py` 读数 / 双端截图；`adb logcat` | 同机俱乐部联机态拿过 59.7~60.3fps；球场对打未取得 |
| E-4 | P2P 直连 | `[sio-rtt] ... via=p2p`；`summary.txt` 中 `peerCandidates_A>0 && peerCandidates_B>0`（F6/F7 双向候选） | `rtt_A`/`rtt_B`（`via=p2p avg=`）；大厅日志 `%TEMP%/mgba_lobby_debug.log` | 同机双实例达成；跨设备待验 |
| E-5 | 模式协商一致 | `mode_negotiated_A=A && mode_negotiated_B=A && official_mode_A=False && official_mode_B=False && nav_at_leak=False`（2P path A）；或两端同为 B 且无降级 | `summary.txt` 对应字段 | 同机驱动已落盘；跨设备待验 |
| E-6 | 握手/块交换中间态 | `linkup_s` 不是「未到LINKUP」；`rem=1`（`gReceivedRemoteLinkPlayers==1`）/ `brs=0101`（u8[0]=1、u8[1]=1，**勿用 brs 判「块没到」**）；`n8>0`（块通道启动） | `summary.txt` `linkup_s`；`[diag] rem/brs`；`REMW` 检查点 | 同机协议层达成；跨设备未找到证据 |
| E-7 | 跨设备拓扑真实性 | 两个账号、两个 game uuid（`PC rom_b.gba md5 ≠ app rom md5`）；**不是**本机两 PC 实例 / 本机 4 核锁步；拓扑为 PC↔Android / PC↔iOS / 两台真机，且启动顺序符合 §0.1 | 两端账号脱敏记录、两份 ROM md5、`advertised relay ... for room <R>`、双端设备标识 | 无 |
| E-8 | 证据绑定 | 结论绑定具体 commit + `test-gboylink.exe`/`mGBA.exe` 二进制 md5 + 源码 md5 + 落盘日志路径；`EXIT=0`；两次独立复核一致 | `git rev-parse HEAD`、`sha256sum`、日志落盘目录 | 部分满足（QA 报告已绑）；本次冲刺产物待绑 |

### 3.1 明确的反判据（出现任一即不得翻绿）

- `lstate=1 pc=0 intr=0`（`CpuFill32(&gLink)` 复位签名）；
- `st` 含 `0x7F000` 任一错误位，尤其 `LAG_MASTER(0x10000)` / `badChecksum(0x2000)` /
  `QUEUE_FULL(0x4000)`；
- `linkup=1` 但 `role=im0/lid0/hs0`（残留值陷阱，ADR-003 h.5）；
- 服务器隧道在 P2P 启用后断开、`BATTLE` 计数 0、`rem=0`、`ts` 全 `0x80`
  （无人发过 `0x16`，`MEMORY.md` 11-16 00:4x）；
- 任何 `BATTLE=YES` 来自同机双 PC 实例 / 本机 4 核 `busgame-lockstep` / `busgame-product`。

---

## 4. Agent 产物的验收顺序（门翻转前的执行清单）

1. Agent 1/3/7/8 的链路层改动落地后，先在**同机双实例**重跑 `tools/cloud2p-duo.py`，
   确认 E-1/E-4/E-5/E-6 在同机可复现（`summary.txt` 全字段落盘）。
   这一步只证明「回归没坏」，**不是放行**。
2. Agent 2/5/9 的三端改动落地后，跑 `mgba_mobile_test` / `:app:runLinkSelfTests` /
   iOS typecheck，确认 C0 / 帧层契约未回归（条数以当次输出为准）。
3. Agent 6 把 E-1..E-8 写成可机器判定的断言 / 检查脚本，输出结构化结果。
4. **按 §0.1 拓扑做真实跨设备 E2E**（两账号 + 两 uuid + PC↔Android/iOS 或两真机），
   一次性落盘 E-1..E-8 全部证据 + commit/二进制 md5。
5. Agent 10 汇总，更新 AC 矩阵 §cross-device 行与发布清单，由用户/放行责任人裁定。
   在此之前，**门维持 FAIL**。

---

## 5. 风险与未决

| # | 风险 | 说明 |
|---|---|---|
| R-10-1 | 并发提交导致证据不绑定 | workbuddy 持续提交 `联机`（顶部 6 条均为该 message），且 ADR-003 有未提交改动；任何 agent 的「绿灯」若未绑定 commit + 二进制 md5 都不可引用（QA 复核元结论） |
| R-10-2 | `linkup=1` / `brs` / `fb` / `mis` 四类误判 | 见 §1.3 BLK-H4/H7 与 ADR-003 §4.1 注；禁止当作成功信号 |
| R-10-3 | path B 被误当解药 | R-3：真机跨设备 20~31fps、4 人房 + NPC，不是 1v1 60fps |
| R-10-4 | 同机 `BATTLE=YES` 被写成跨设备闭环 | 历史多次踩中（`busgame-product` / FR6 / TR44）；本文 §0/§3 明令禁止 |
| R-10-5 | C/Qt 门状态分歧未裁定 | §0.2：MEMORY.md = CONCERNS，release checklist Rev.12 = PASS。放行前必须人工对账 |
| R-10-6 | ADR-003 §7 状态过期 | R-1..R-8 为 11-15/11-16 口径；本文 §1.4 照抄并标「未更新」，结论以新落盘证据为准，不据旧条目推断当前代码状态 |
| R-10-7 | 未找到证据 ≠ 不存在 | 本文多处写「未找到证据」，仅表示本 ADR 落盘时未取得落盘材料，不断言缺陷已修或不存在 |

---

## 6. 一句话收口

**目标只有一个：跨设备 2P 云端进球场对打并稳定 60fps。当前所有证据都只到「同机链路层」，
2P 云端交付门维持 FAIL。§3 的 E-1..E-8 全部在真实跨设备 E2E 上落盘之前，
禁止把任何 agent 的改动称作「跨设备 2P 已闭环」。**
