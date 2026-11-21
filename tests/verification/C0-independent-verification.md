# C0 能力协商位 · 独立验证报告（T-08）

| 项 | 内容 |
| --- | --- |
| 任务 | T-08 · C0 独立验证（验证与实现分离，fresh eyes） |
| 验证者 | quality-lead-2（独立验证侧，非实现者） |
| 项目 | `D:\mgba-android-version`，三端（PC Qt / Android / iOS）自研 GBoy 联机 |
| **本次复验基线** | **`git HEAD = f355bd59f`**（`test(c0): 用例 11 强制走到 negotiateLinkMode 的 INVALID 分支 + exchange 保护`），工作区仅他人未提交改动（`android/app/build.gradle` 等，非本报告产物） |
| 初版基线 | v1 基于 `910970de8`（T-03 刚落地时） |
| 验证手段 | 只读代码核查 + `git` 历史比对 + 跑现成 `test-gboylink.exe`（`frames/buslocal/product-lockstep/--c0/--gatetest`）+ 位运算静态等价演算 |
| 编辑边界 | **仅创建/写入本文件**。未修改任何源码、配置、构建脚本或其它文档；未重编、未跑 `ninja`/`gradlew`；未 commit/push |
| 验证侧判定（v3） | **PASS（附 1 项 Android 残留 + 1 项 iOS 风险）** |

> ⚠️ **判定作用域（主理人补充，勿误读）**：本报告的 `PASS` **仅指「C0 能力协商位的实现与两端一致性已验证」**，
> 覆盖范围是 `linkModeOf` / `registerFrame` / 协商门判定 / 有限等待的时序语义。
> 它**不是** 2P 云端交付门的判定，也**不构成**放行依据：
> 云端数据通路端到端仍 **0 条**断言、跨设备真机 E2E 仍 **0 条**（所有云端 `flow_*.log` 的 BATTLE 计数全 0），
> 2P 云端交付门维持 **FAIL**、C/Qt 本地回归门维持 **CONCERNS**。
> 引用本报告时不得省略本段。

> 证据分级：`[CODE]` 文件:行号；`[CMD]` 真实命令输出；`[CALC]` 位运算静态等价演算（**重演源码逻辑，非执行实际二进制**）；`[EXT]` 他方提供、本人未独立复现的外部证据（已注明）；`[NO-JUDGE]` 无法判定。
> 本报告不接受「实现者自述」作为证据；对 engineering-lead-2 的反馈，逐条回到代码与命令输出复核后才采信。

---

## 0. 修订记录（v1 → v3）

T-08 初版（基于 `910970de8`）判定为 **CONCERNS**，列出 B1–B6。此后主分支推进到 `df5f7fe84`，初版所列的多数问题已被修复并补上断言。v2 基于当前 HEAD 逐项复验，变更如下：

| 初版项 | v1 结论 | v2 复验结论 | 依据 |
| --- | --- | --- | --- |
| **F8**（INVALID 不回写 → 「可能静默放行」） | ⚠️ 报告为「allow_legacy 可能放行畸形」 | **初版后果被推翻：这是我的误报**。真性质=状态可观测性缺陷；安全由 `m_modeRejected` 短路保证。且已修回写 | `CloudLink.cpp:2870-2900`（回写 + 正确因果注释）、`gboylink_test.cpp:3852-3911`（用例 4/7） |
| **F1 / B1**（Android 缺 UNKNOWN 有界等待） | ❌ FAIL | **已修**：`awaitPeerLinkMode()` 20×100ms=2000ms 上界，WSS/KCP 分通道且不吞游戏帧 | `GBoyCloudLink.java:178-179, 2790-2861` |
| **F2 / B2**（Android `runManual` 绕过协商门） | ❌ FAIL | **已修**：`runManual` 补门 | `GBoyCloudLink.java:908-921` |
| **F5 / B3**（C0 零自动化断言） | ❌ 证据缺口 | **已消除**：`--c0`(45) + `--gatetest`(76, 12 用例) + Android `C0LinkModeTest`/`C0GateTest` | `[CMD]` 见 V7；`gboylink_test.cpp:3345-4059` |
| **F7**（声称 2s 实际 ~1.2s） | ⚠️ | **已修**：deadline 循环 + `waitAndProcess` 补齐；实测 2004~2014ms、≤2400ms 上界 | `CloudLink.cpp:2946-2992`；`[CMD]` gatetest 用例 3/5/8 |
| **F9**（畸形文案缺模式/改法） | ⚠️ | **PC 已修；Android 未同步**（残留） | `CloudLink.cpp:2995-3003` vs `GBoyCloudLink.java:2891-2894` |
| **F6**（头文件 Doxygen「10 字节」自相矛盾） | ⚠️ | **已修**：改为「always 16 bytes on the wire（length 12）」并说明旧读数系误读 | `GBoyFrames.h:145-160` |
| **F12**（单人房 `body[11]` 误读，新缺陷） | 初版不存在 | **新发现，已修并钉死**：读侧加 `playerCount == 1` 门 | `GBoyFrames.cpp:133-135`、`GBoyFrames.java:177-179`；`[CMD]` `--c0` 三条断言 |
| **v3 增补**：`peer==INVALID` 分支覆盖事实 | v1/v2 只标注「不可达」 | 现由 `--gatetest` **用例 11 强制覆盖**（探针清 `m_modeRejected` + 直接设 `m_peerLinkMode=INVALID`，8 条断言：refuse/closed/rejected by branch/says 畸形/**无「来源」**/只一条文案/peer 保持 INVALID/二次短路）；PC 给该分支补 `exchange` 保护、文案幂等 | `CloudLink.cpp:2995-3013`、`gboylink_test.cpp:4038-4059`；`[CMD]` 见 V7 |
| **v3 增补**：`--c0` 弱断言升级 | v2 曾见「两产物互比」 | 已改为对**写死的官方 16 字节数组**做绝对比对（`kOfficialPc4B[16]` / `kOfficialPc1Count40[16]`）；另有 6 条枚举/常量钉属规格钉、不计入「验证行为」份额 | `gboylink_test.cpp:3486-3508` |

> **v3 复验触发**：engineering-lead-2 提交 `f355bd59f`（用例 11）。本人回到当前 HEAD 复核并实跑 `--c0`（45 ok）、`--gatetest`（76 ok / 12 用例 / worst 2007ms ≤ 2400ms），确认用例 11 的 8 条断言、绝对比对数组、`peer==INVALID` 分支的 `exchange` 保护均与描述一致后采信。**断言条数会随增补变动，本报告所有条数一律「以当次输出为准」，本次实测锚点为 commit `f355bd59f`。**

> **关于 F8 的自我纠正**：v1 推演「INVALID 从 `notePeerLinkMode` 的 INVALID 分支进入、但 `m_peerLinkMode` 仍为 UNKNOWN，若在 `negotiateLinkMode` 等待循环期间到达就会走到 UNKNOWN 分支回落 B」。复验发现该推演的**到达时序静态不可达**：`INVALID` 只可能来自 `linkModeOf(body)`（`handle()` 内，而 `handle()` 在 `serve()` 里、晚于 `negotiateLinkMode()`）；WSS marker 的 `"m"` 仅由 A/B 写入（`sendWsMarker` / `WsLink::sendMarker`），不会产生 `-2`。因此 INVALID 不在等待循环期间出现；而「INVALID 先到」的时序被 `negotiateLinkMode()` 顶部 `if (m_modeRejected) return false;` 短路。engineering-lead-2 提供的变异实验（删回写后 `--gatetest` 只红用例 4、用例 7 照旧绿）与该静态分析一致；本人因禁改源码/禁重编未独立复现该变异，标注 `[EXT]`。**结论：v1 的 F8 后果描述不成立，v2 已改正；F8 的现象（不回写导致状态与实际不符、`peer==INVALID` 分支不可达）属实但严重度为 P2/P3，且已修复。**

---

## 1. 逐项判定汇总（v2）

| 项 | 判定 | 结论 | 证据强度 |
| --- | --- | --- | --- |
| V1 | **PASS** | 两端 `linkModeOf()` 6 类输入一致、全 256 值等价；**现有 `--c0` 与 Android `C0LinkModeTest` 双端断言** | 强（静态 + 可执行） |
| V2 | **PASS** | 2 参数恒 16 字节、与官方逐字节一致；3 参数仅 `playerCount != 1` 写 `wire[15]`；`--c0` 有逐字节断言 | 强 |
| V3 | **PASS** | 本轮 C0 提交未触及 `startSioRelayBridge()`（两侧）与 `maybeSendInitialState()` 门控 | 强（git 历史） |
| V4 | **PASS**（v1 为 FAIL） | PC 三处门 + deadline 等待；**Android 三处门**（`connectRelay`/`runTunnel`/`runManual`）+ `awaitPeerLinkMode` 20×100ms | 强（可执行 gatetest + 静态） |
| V5 | **PASS** | AUTO 单一实现 `GBoyFrames::resolveLinkMode()` 两端复用；`--c0` 断言 AUTO/override/malformed；入口与持久化齐备 | 强 |
| V6 | **PASS（附 Android 残留）** | 不静默降级；PC 失败文案已补齐模式/改法；**Android `PEER_INVALID` 两条文案仍为旧短句**（残留，P3） | 中（文案对照） |
| V7 | **PASS** | 五条实测全绿：`frames`/`buslocal`/`product-lockstep`/`--c0`(45 ok)/`--gatetest`(76 ok, 12 用例) 退出码均 0 | 强 |
| V8 | **如实记录（不下结论）** | `GBoyLinkSession.java:288-301` 空 blob 门控存在；T-07 已完成（commit 4fff0a340），按指令不代其判定 | `[NO-JUDGE]` |
| V9 | **RISK（记录，不要求修）** | iOS 无 C0 能力位/协商门，2P 默认 A 房间会被 PC/Android 判「对端未声明」 | 中（静态） |

---

## 2. 逐项证据（v2）

### V1 — `linkModeOf()` 两端逐项对照 → PASS

`[CODE]` PC `GBoyFrames.cpp:123-142`、Android `GBoyFrames.java:165-186`；常量 `GBoyFrames.h:109-110` / `GBoyFrames.java:88-94`。两端枚举 `UNKNOWN=-1/INVALID=-2/A=0/B=1`、`MAGIC=0x40/MODE_BIT=0x01` 一致，函数体逐行同构。

| 输入 | PC | Android | 一致 |
| --- | --- | --- | --- |
| `0x00` | UNKNOWN(-1) | UNKNOWN(-1) | ✅ |
| `0x40` | A(0) | A(0) | ✅ |
| `0x41` | B(1) | B(1) | ✅ |
| 保留位非 0（0x01/0x02/0x42/0x80/0xC0/0x3F/0xFF） | INVALID(-2) | INVALID(-2) | ✅ |
| body 长度 < 12 / 非 type-1 帧 | UNKNOWN | UNKNOWN | ✅ |
| `body == null`（仅 Android） | 不适用 | UNKNOWN | 语言差异 |

`[CALC]` 遍历 0..255 全值演算 `ALL_EQUAL=True`。`[CMD]` 现有断言：PC `--c0` 含 `linkModeOf(cap 0x40)==A`、`0x41==B`、`0x00==UNKNOWN`、`0x42==INVALID`、`0xFF==INVALID`、`type 3 body with 0x40 → UNKNOWN`、`11-byte truncated → UNKNOWN` 等；Android `C0LinkModeTest.java:53-113` 覆盖同六类（含 null 与短帧），**未执行**（见 §5）。

### V2 — `registerFrame()` 帧布局 → PASS

`[CODE]` PC `GBoyFrames.cpp:101-121`、Android `GBoyFrames.java:139-162`，同构。2 参数委托 3 参数 + UNKNOWN（不写 `wire[15]`），多人房 16 字节、`wire[15]=0`，与官方逐字节一致；`playerCount == 1` 先写 `short 0 + int baseStateCount` 再 return，不写能力位；`playerCount != 1` 且 `linkMode∈{A,B}` 才写 `out[15]`。`[CMD]` `--c0` 逐字节断言：`registerFrame(2,0) is byte-identical to the official 16-byte frame`、`registerFrame(1,3)` 同、`(2,0,UNKNOWN) falls back to 2-arg`、`(2,0,A) == official except wire[15]=0x40`、`(2,0,B)==…0x41`、`(4,0,B) writes 0x41`、`(1,3,B) identical to 2-arg（1-player no cap bit）`、`register frame is 16 bytes for 1..4 players` → 全部 ok。`bench`：`gboylink_test.cpp:2908-2910` 旧长度断言仍在。

`[CODE]` F6 已修：`GBoyFrames.h:145-160` Doxygen 明确「always 16 bytes on the wire（length field 12 = 2 type + 10 payload）」，并说明「earlier 10 bytes reading was a misreading of fill-vs-not-fill」，与实现一致。

### V3 — 回归防护 → PASS

`[CMD]` `git diff HEAD -- <8 个 T-03 文件>` 为空（工作区仅他人未提交的 `build.gradle`/`C0GateTest.java`）。历史比对：

- PC `startSioRelayBridge()`：`git log -L :startSioRelayBridge:src/platform/qt/CloudLink.cpp --oneline` 最近一次触及仍是 `3fa798899`（早于 C0 提交 `f84d6356a`/`910970de8`/`df5f7fe84`）→ 一字未改 ✅
- Android `startSioRelayBridge()`：`git show --format= --unified=0 HEAD -- GBoyCloudLink.java | grep -c startSioRelayBridge` = **0**（HEAD 提交 hunk 不覆盖该函数）→ 一字未改 ✅
- `maybeSendInitialState()` 门控：`CloudLink.cpp:2463-2465` 的 `if (!m_officialMode) return false;` 仍在（由 `24902fc6d` 引入，后续未移除）✅

### V4 — 分派门与有界等待 → PASS（v1 为 FAIL）

**PC**：门 `CloudLink.cpp:949`（KCP 中继）/`:1500`（WSS 隧道）/`:2762`（手动中继），均在按键帧/savestate/SIO 包之前；UNKNOWN 等待为 **deadline 循环**（`:2962-2992`）：`kPeerModeWaitMs = 2000`，`while (!m_closed && peer==UNKNOWN)` 内取 `slice = min(left,100)`，`m_gatePump`（测试注入）/`drainSignaling` 后若有剩余再 `waitAndProcess(min(left,100))` 补齐 —— **两条分支都受同一 deadline 约束**。`[CMD]` `--gatetest` 用例 3「bounded wait actually ran (>=1800ms) / stays bounded (<=2400ms)」实测 **2007ms**；用例 8「instant pump: bounded wait still ~2s」2008ms；用例 10「closed mid-wait: exits immediately」108ms；最坏 2013ms ≤2400ms；用例 9「late peer bit … exits early, no full-window wait (B1)」320ms。✅

**Android**：门 `GBoyCloudLink.java:641`（KCP 中继）/`:1214`（WSS 隧道）/`:913`（手动中继）；`negotiateLinkMode(room, where, link)`（`:2863-2911`）在判定前调 `awaitPeerLinkMode(link)`（`:2872-2875`）；`awaitPeerLinkMode`（`:2811-2829`）= `LINK_MODE_WAIT_ROUNDS(20) × LINK_MODE_WAIT_STEP_MS(100)` = **2000ms 上界**，每轮先查 `peerLinkMode/closed/link.isClosed()` 再推进；WSS 走 `pumpMarkers`、KCP 走 `recv`+`feedForLinkMode`，且 `replayBytes`/`recvLink` 保证**不吞游戏帧、保序**（`:2835-2861`）。✅

`[NO-JUDGE]` Android `--gatetest` 等价用例在 JVM 中是否通过：Android 测试存在（`C0GateTest.java`/`C0LinkModeTest.java`）但**未执行**（职责边界禁止跑 `gradlew`，见 §5）；上述为静态核实。

### V5 — AUTO / 兼容入口 / 直连 → PASS

`[CODE]` AUTO 单一实现：`GBoyFrames.cpp:146-159`（`autoLinkMode` + `resolveLinkMode`），`CloudLink::resolveLinkMode`（`CloudLink.cpp:2864-2868`）委托之，Android `GBoyCloudLink.java:2727-2732` 同逻辑 `playerCount>=3?B:A`。`[CMD]` `--c0` 断言：`AUTO: 1/2 player→A`、`3/4→B`、`resolve(2P,AUTO)→A`、`resolve(3P,AUTO)→B`、`override A beats AUTO(3P→A)`、`override B beats AUTO(2P→B)`、`malformed override falls back to AUTO` 全部 ok（**malformed override 兜底**同时消除 v1 对「构造器 `m_linkMode` 初值」的边缘担忧）。
兼容入口：`MGBAX_OFFICIAL_LINK=1`→B（`CloudLink.cpp:639-640,645`）；蓝牙/WiFi 直连显式 B（`EmulatorActivity.java:423,438` `setOfficialMode(true)`）；PC 下拉框 AUTO/A/B + QSettings `link_mode` 且 `LobbyView.cpp:291-299` 回灌 `setLinkMode`；Android `GBOY_LINK_MODE` 广播 + `gboy_link_mode`/`gboy_link_allow_legacy` 持久化（`EmulatorActivity.java:5582-5602`）。✅
Minor（保留）：QSettings 存 AUTO 而环境变量为 B 时 UI 与实际模式可能不一致（无运行时提示）。

### V6 — 失败文案与「不静默降级」→ PASS（附 Android 残留）

`[CODE]` 不静默降级：`fail()` 置 `m_closed`/`closed`（`CloudLink.cpp:2819-2823` / `GBoyCloudLink.java:2913-2918`）；调用方立即 close+return 不发游戏帧；回落仅 `allow_legacy` 下发生且文案以「警告：…显式许可回落…未经 2P 云端验收」开头（PC `:2930-2933` / Android `:2886-2890`）。
PC 失败文案已补齐：`CloudLink.cpp:2875-2900`（notePeerLinkMode INVALID 含本机/来源/改法）、`:2995-3003`（negotiate PEER_INVALID 含本机/where/改法）。`[CMD]` `--gatetest` 用例 2「message names the local mode (本机=) / peer mode (对端=) / tells how to fix it」、用例 4「message names the local mode (F9)」全部 ok。
**残留（Android）**：`GBoyCloudLink.java:2891-2894` 的 `LINK_DECISION_PEER_INVALID` 仍为「【联机模式协商失败】对端能力位畸形，已断开。」，`notePeerLinkMode` 的 INVALID 分支（`:2738-2745`）为「…（来源 X）…请两端使用相同版本。」——**均未列出对端/本机模式与改法**，与 PC 已修版本、与 V6「统一列出本机/对端模式与改法」不完全对齐。功能正确（确实 refuse 且不回落），仅文案完整度差异。

### V7 — 现成测试程序 → PASS

`[CMD]`（`export PATH="/c/msys64/mingw64/bin:$PATH"`，未重编）：

```
### frames EXIT=0
RECONNECT TEST: PASS (10 byte handshake recognised as a handshake)
TCPDIRECT TEST: PASS (framing, 800 KiB state, auto reconnect + 10 byte handshake)
### buslocal EXIT=0
BUSLOCAL TEST: PASS (slot-tagged local bus join)
SESSIONSLOT TEST: PASS (PC session slot routing)
### product-lockstep EXIT=0
product-lockstep: PASS (4 cores, product SIO lockstep)
### --c0 EXIT=0 → c0 tests passed (45 ok / 0 FAIL)
### --gatetest EXIT=0 → gatetest passed (76 ok / 0 FAIL, 12 cases, worst-case 2007 ms ≤ 2400 ms)
```

`--c0` 覆盖帧层（六类解码 / 对**写死的官方 16 字节数组**逐字节绝对比对 / AUTO 与 override / 单人房 F12 / SIO 裸包；其中 6 条为枚举常量钉、属规格钉不计入行为份额）。`--gatetest` 覆盖协商门本体，**五类判定按层拆开计**：一致 / 冲突 / 未声明拒绝 / 未声明+allowLegacy 回落由用例 1/2/3/5/6 覆盖；畸形（第 4 类）分两层——**早退层**（`notePeerLinkMode` + `m_modeRejected` 短路）由用例 4/7 覆盖，**`negotiateLinkMode()` 自身 `peer==INVALID` 分支**（生产不可达、第二道锁）由用例 11 强制覆盖；另有 8/9/10 覆盖时序与中途 close、invariant 守 2400ms 上界。**C0 新增逻辑现已有两端可执行断言**，v1 的「零断言」缺口消除。（条数以当次输出为准）

### V8 — `GBoyLinkSession.java:288-290` 空 blob 门控（如实记录，不下结论）

观察锚点：本次复验读取时刻（`HEAD=f355bd59f`，未对该文件做任何写入）。`[CODE] android/app/src/main/java/io/mgba/android/GBoyLinkSession.java:288-301`：

```java
case GBoyFrames.TYPE_STATE: {
    /* … stateOf() 会把裸 20 字节 netLink 包正确拒绝为空；此时绝不能继续派发空 blob，
     * 否则 applyRemoteState(empty) 返回 STATE_ERROR(1) 会断链（与 AC5 冲突）。
     * 与 PC CloudLink.cpp 的 `if (!state.isEmpty())` 门控对齐：空即忽略。 */
    byte[] state = stateOf(body);
    if (state != null && state.length > 0) {   // ← :298 门控存在
        events.onState(state);
    }
    break;
}
```

**记录**：门控存在，且注释与 PC `CloudLink.cpp:2444-2446` 对齐。T-07 已完成（`GBoyLinkSession.java` 最近提交 `4fff0a340`）。按任务指令**不评价其修复正确性、不替 T-07 下结论**；此门控是否与 T-07 验收断言配套属 `[NO-JUDGE]`，建议以 T-07 报告为准。

### V9 — iOS 未改动风险 → RISK（记录，不要求修）

`[CMD]` `grep -rnE "LINK_MODE|linkModeOf|LINK_CAP|\"m\"|gboy_ws|协商失败" ios/` 无 C0 相关命中；`ios/mGBA/LobbyFrames.swift:155-166` 只有 2 参数 `registerFrame`（`wire[15]=0`）。推演：iOS 进 2P 默认 A 房间 → PC/Android `linkModeOf` 与 WSS `"m"` 均落 UNKNOWN → 默认 `fail「对端未声明联机模式」`；仅两端 `allow_legacy=true` 才回落 B。按指令仅记录，**不要求修**；建议 release-ops 写入已知问题/发布说明。

---

## 3. 发现清单（F1–F12，含状态）

| # | 性质 | 状态 | 证据 |
| --- | --- | --- | --- |
| F1 | Android 缺 UNKNOWN 有界等待 | **已修** | `GBoyCloudLink.java:2811-2829`（20×100ms） |
| F2 | Android `runManual` 绕过协商门 | **已修** | `GBoyCloudLink.java:908-921` |
| F3 | `startSioRelayBridge` 两侧一字未改；门控仍在 | ✅ 确认无问题 | git 历史 + `CloudLink.cpp:2463-2465` |
| F4 | 两端 `linkModeOf` 全 256 值等价 | ✅ 确认无问题 | 静态 + `--c0` + `C0LinkModeTest` |
| F5 | C0 零自动化断言 | **已消除** | `--c0`(45)/`--gatetest`(76, 12 用例)/Android 两套（条数以当次输出为准） |
| F6 | 头文件 Doxygen「10 字节」自相矛盾 | **已修** | `GBoyFrames.h:145-160` |
| F7 | 声称 2s 实际 ~1.2s | **已修** | `CloudLink.cpp:2946-2992`；实测 2007ms |
| F8 | INVALID 不回写 → 「可能静默放行」 | **我的误报已纠正；现象已修**（真实性质=状态一致性，安全靠 `modeRejected` 短路）；`peer==INVALID` 分支生产不可达、作为第二道锁由**用例 11 强制覆盖** | `CloudLink.cpp:2870-2900`、`:2995-3013`；`gboylink_test.cpp:3852-3911`（用例 4/7 早退层）、`:4038-4059`（用例 11）；`[EXT]` 变异实验 |
| F9 | 畸形文案缺模式/改法 | **PC 已修；Android 未同步（残留）** | `CloudLink.cpp:2995-3003` vs `GBoyCloudLink.java:2891-2894` |
| F10 | 不静默降级（closed + 可见提示 + 显式许可文案） | ✅ 确认无问题 | `CloudLink.cpp:2819-2823,2930-2933`；`GBoyCloudLink.java:2913-2918,2886-2890` |
| F11 | AUTO 同逻辑 / 入口齐备 | ✅ 确认无问题 | `GBoyFrames.cpp:146-159`；`--c0`；`LobbyView.cpp:291-299`；`EmulatorActivity.java:5582-5602` |
| F12 | 单人房 `body[11]` 是 `baseStateCount` 最低字节被误读为能力位 | **新缺陷，已修并钉死** | `GBoyFrames.cpp:133-135`、`GBoyFrames.java:177-179`；`--c0` 三条（0x01/0x40/0x41 → UNKNOWN） |

---

## 4. 验证侧判定与阻塞项（v2）

### 判定：**PASS（附 1 项 Android 残留 + 1 项 iOS 风险）**

初版 CONCERNS 的阻塞项 B1/B2/B3 已全部闭环（见修订记录）；PC 与 Android 的协商门、有界等待、能力位编解码、帧布局均已就位并有可执行断言（PC 侧本人实跑全绿；Android 断言存在但未执行）。唯一实质不一致是 Android `PEER_INVALID` 文案比 PC 短、缺本机/对端与改法（功能正确，仅文案完整度），列为 P3 建议而非阻塞。V9 的 iOS 互操作风险按指令不影响判定。

按 SOP，质量门为**建议性判定，最终放行由主理人/用户决定**。

### 阻塞项状态

| 编号 | 初版内容 | v2 状态 |
| --- | --- | --- |
| B1 | Android 补 UNKNOWN 有界等待 | **已闭环**（`awaitPeerLinkMode` 20×100ms） |
| B2 | Android `runManual` 补门 | **已闭环**（`:913`） |
| B3 | 补 C0 自动化断言 | **已闭环**（`--c0` 45 / `--gatetest` 76 / Android 两套；条数以当次输出为准） |
| B4 | 文档/时长/状态机/文案一致性 | **基本闭环**：F6/F7/F8 已修；**仅剩 F9 Android 文案未同步（P3）** |
| B5 | V8 待 T-07 签收 | T-07 已完成（commit 4fff0a340），门控存在；按指令不代判 |
| B6 | iOS 与 A 房间互操作限制 | 仍在；按指令不要求修，建议 release-ops 记入已知问题 |

**唯一待办（建议，非阻塞）**：Android 侧 `LINK_DECISION_PEER_INVALID` 与 `notePeerLinkMode` INVALID 分支文案对齐 PC 的「本机=/对端能力位畸形（来源）/改法」格式（`GBoyCloudLink.java:2738-2745, 2891-2894`）。P3。

---

## 5. 无法判定项 `[NO-JUDGE]`

- **Android 单测可执行结果**：`C0LinkModeTest.java` / `C0GateTest.java` 存在且源码覆盖六类解码、五类决策、时序等，但本任务禁止跑 `gradlew`，**只做了静态核实，未执行**。其是否全绿以 Android 侧当次输出为准。
- **F8 变异实验的独立复现**：禁改源码/禁重编，未独立复现 engineering-lead-2 的「删回写后只红用例 4」变异；以其可复现命令+输出为 `[EXT]`，并以本人静态路径分析交叉验证（INVALID 到达时序不可达 + `modeRejected` 短路）。
- **V8 修复正确性与归属**：按任务指令只读记录，不替 T-07 下结论。
- **实机 PC↔Android / iOS 协商行为**：无设备，V4/V6/V9 运行时结论为静态推演 + 测试注入（非真网络）。
- **`%TEMP%/mgba_lobby_debug.log` 与 Android UI 的实际呈现**：只读到写入路径，未实机观察。

---

*报告 v2 结束。本文件为 T-08 唯一写入产物；复验过程未修改任何源码、配置、构建脚本或其它文档。*

---

## 6. 复验纪律声明

本次复验由 quality-lead-2 独立完成，未使用 engineering-lead-2 的结论作为直接证据：对 F8，先回到 `CloudLink.cpp:2870-2900` 与 `GBoyFrames`/`gboylink_test` 核实变异实验的因果链，再用静态到达时序分析独立判定，最后才采信其修正；对 F1/F2/F5/F12，逐一读当前 HEAD 代码并以本人实跑的 `--c0`/`--gatetest` 输出为准。凡本人未执行的（Android JVM 单测、变异实验、实机联机）均显式标 `[NO-JUDGE]` 或 `[EXT]`。

---

## 7. 补记（2026-11-17 · Wave-2 文档同步）：**V9 已被 ADR-005 取代 —— 但仍设备未验证**

> **边界**：本补记只追加在本文件末尾，**不修改上方 v2/v3 正文的任何判定、证据与条数**。
> 它不是 quality-lead-2 的重新复验：以下为按提交事实同步的状态更新，证据级别为 `[CODE]` / 提交历史
> （`[EXT]`：本人未独立复现、未重编、未跑真机）。

- **V9（iOS 无 C0 能力位/协商门 → RISK）的前提已不成立（代码层）**。Agent 9 提交 `de97dc2e8`
  （主分支等价落地 `0734cd266`）在 `ios/mGBA/LobbyFrames.swift` 与 `LobbyLink.swift` 补齐了
  C0 帧能力位、解码、协商门与 WSS `"m"` 主协商通道。故 V9 所述「iOS 无 C0 → 被判对端未声明」
  作为**代码层风险**已被 **`docs/architecture/ADR-005-ios-c0-and-interop.md` 取代（SUPERSEDED）**，
  设计/矩阵/残留风险以 ADR-005 为准。

- **风险形态改变，未消失**：iOS 云端 2P 走 path B，声明 **mode B**（不是 PC/Android 的
  「AUTO 2P→A」）。因此 iOS ↔ PC/Android 要互通，PC/Android 必须显式设 **B**；若仍为 2P 默认 AUTO，
  会以「本机=B / 对端=A」触发**可见冲突 fail**，而不是静默降级。这从 V9 的「未声明」变成「模式冲突」，
  但都需要显式对齐后才放行。

- **仍是设备未验证（关键）**：本次 iOS 改动**仅过 `swiftc -parse`**，未做 Xcode `typecheck`、
  未做真机、未做 PC↔iOS / Android↔iOS 跨设备 E2E。移除 V9 只是**代码/解析级**事实，
  **不构成设备层风险已消除**。按本报告 §0 的作用域声明，**2P 云端交付门维持 FAIL**，
  C/Qt 本地门维持 CONCERNS；引用本补记时不得省略本段。

- 对应 ADR-002 §5 R3、§6 R3 与 ADR-004 R3 所述的「iOS 无 path A」覆盖缺口，
  其**协商面**已由 ADR-005 补上；**60fps / 4 核路径可行性**仍属 ADR-004 R3 的未决约束，未因本改动关闭。

*补记结束。上方 v2/v3 正文及其所有判定保持原样。*
