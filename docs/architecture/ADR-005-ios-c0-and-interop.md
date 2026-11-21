# ADR-005 · iOS C0 能力协商与 mode B 声明（跨设备 2P 互操作）

- 状态：**Accepted（代码层）**；**设备未验证**（仅 `swiftc -parse` 级检查）
- 日期：2026-11-17
- 来源提交：Agent 9 `de97dc2e8` — `feat(ios): add C0 capability negotiation and WSS tunnel fallback`。
  主分支等价落地为 `0734cd266`（与 `de97dc2e8` 同父 `efeb4063e`，另含 mobile/Qt 测试改动）。
- 相关：`docs/architecture/ADR-002-2p-patha-capability-negotiation.md`（C0 设计）、
  `docs/architecture/ADR-004-cross-device-2p-cloud-closeout.md`（交付门 / R-2）、
  `tests/verification/C0-independent-verification.md` V9。
- 门控事实：**2P 云端交付门维持 FAIL**。本 ADR 只补 iOS 侧 C0 互操作面，**不构成放行依据**。

---

## 1. 上下文（Context）

ADR-002 定义了 type-1 注册帧 `wire[15]`（body[11]）的 1-bit 能力位与 WSS `"m"` 冗余协商通道，
并在 §5 R3 / §6 R3 记录「iOS 无 path A、未实现 C0」的已知缺口；
`C0-independent-verification.md` V9 据此把「iOS 进 2P 默认 A 房间会被 PC/Android 判对端未声明」列为 RISK。
`de97dc2e8` 在 iOS Swift 侧补齐该能力位、协商门与隧道回退，使上述缺口在**代码层**闭合。

本 ADR 记录该实现的设计选择、互操作矩阵、验证作用域与残留风险；**不声称任何真机 / 跨设备验证**。

## 2. 决策（Decision）

### D1 · iOS 实现 C0 帧能力与解码（与 PC/Android 逐位同源）

`ios/mGBA/LobbyFrames.swift`：

- 新增 `linkCapMagic = 0x40`、`linkCapModeBit = 0x01`，与 PC `GBoyFrames.h` / Android
  `GBoyFrames.java` 的 `LINK_CAP_*` 逐位一致。
- 保留 2 参数 `registerFrame` 的官方 16 字节字节不变；新增 3 参数版本，仅在
  `playerCount != 1` 且 `linkMode ∈ {A, B}` 时写 `out[15]`（`0x40`=A / `0x41`=B）；
  单人房尾部承载 `baseStateCount`，不写能力位（F12 同源防护）。
- 新增 `linkModeOf(body)`：`0x00`→未声明、无 magic 或保留位非 0→畸形、否则按 bit0 解 A/B。
- 新增 `autoLinkMode`（≥3 人→B，否则 A）与 `resolveLinkMode`（显式 A/B 优先，UNKNOWN/INVALID 回落 AUTO），
  与 PC/Android 的同名纯函数口径一致。
- 新增 `GBoyLinkMode` 枚举（`unknown=-1 / invalid=-2 / a=0 / b=1`），
  `wireValue` 与 WSS `"m"` 取值对齐，`displayName` 供失败文案列出本机/对端模式。

### D2 · iOS 云端 2P 声明 mode B，而不是照搬 PC/Android 的「AUTO 2P→A」

`ios/mGBA/LobbyLink.swift` 的 `prepareLinkMode(room:)`：显式 `setLinkMode(.a|.b)` 优先；
否则（AUTO / 未预置）**解析为 `.b`**。理由（见该提交代码注释）：

1. iOS 云端 2P 走 path B —— `armCloudMulticore` 与 `GBoyConsoleSet(players:4, localSlot:1)`
   的本机多核 lockstep，网络只传按键。若声明 A 却实际跑 B，对端会按 path A 发 20 字节 SIO 包，
   本端只收按键，变成「协商通过但链路静默错配」，**比直接 fail 更糟**。
2. 声明 B 可与官方 4 核客户端（默认 official mode = B）直接互通；对端显式 A 时按 ADR-002 D3
   给出**可见冲突 fail**，而非静默降级。

> **互操作含义**：PC/Android 要与 iOS 互通，需把模式显式设为 **B**（`MGBAX_LINK_MODE=B` /
> `--es mode B`）；PC/Android 的 2P 默认 AUTO 解析为 A，会与 iOS 的 B 触发可见冲突 fail。
> 这是设计选择（iOS 无 path A），不是 bug。

### D3 · 互操作矩阵（本机 = iOS B）

| 对端声明 | 结果 | 依据 |
| --- | --- | --- |
| B（PC/Android 显式 B；官方 4 核客户端） | **放行**（一致） | `negotiateLinkMode` 判等 |
| A（PC/Android 2P AUTO→A，或显式 A） | **可见冲突 fail**：「本机=B… 对端=A…」并列改法 | `notePeerLinkMode` 的 `local != mode` 分支 |
| 未声明（官方 APK / 旧客户端，`0x00`） | **默认 fail**「对端未声明」；仅两端 `allow_legacy=true` 时回落 B 并打显式许可警告 | `negotiateLinkMode` 的 UNKNOWN 分支 |
| 畸形（无 magic / 保留位非 0 / `-2`） | **fail**（按不一致处理，不猜测） | `linkModeOf` + `notePeerLinkMode` 的 INVALID 分支 |

协商门在任何游戏帧发出之前执行；`modeRejected` 短路防止重复 fail；2s 有界等待
（`peerModeWaitMs = 2000`，对齐 PC `kPeerModeWaitMs`）期间只排空信令，不消费游戏帧。
发送/接收覆盖 type-1 能力位与 WSS `"m"` 两条通道，任一先到都生效。

### D4 · WSS 隧道回退（PC `WsLink` / Android `WsLink` 的 iOS 等价物）

`LobbyWsTunnel`：KCP 节点持续无应答超过 `relayGraceMs = 12000`（对齐 PC `startRelayLink(..., windowMs)`）
即切到 WSS 隧道，不再像旧实现那样空等 5 分钟；节点已握手成功仍按原长等窗口等对手加入。

- **载荷就是原样 `LobbyFrames` 字节**，经 `LobbyFrames.Reader` 拆帧后走与 KCP 完全相同的
  `handle()`，不引入第二种帧格式（ADR-002 D5）。
- `chunkBytes = 20`（40 hex 字符）保证信封在 100 字符内；hello/accept 标记带 C0 `"m":0|1`
  作为主协商通道；`modeInMarker` 跳过服务器回显的 `"self":true` 与自身 `processNonce`，
  避免把本机模式误当对端已声明（假阳性放行）。
- 隧道与连接同生命周期，`close()`/重连一并收掉，不泄漏旧通道。

## 3. 验证范围（Verification scope）

- **仅 `swiftc -parse`**（在 Windows 上对该 Swift 文件做语法解析），对齐提交代码注释自述。
- **未做** Xcode `typecheck` / 构建、**未做**真机运行、**未做**跨设备真实 E2E（PC↔iOS / Android↔iOS）。
- 因此 D1–D4 的结论是**代码层 / 解析级**事实，不是设备验证结论；
  2P 云端交付门维持 **FAIL**，本 ADR 不改变该判定。

## 4. 开放风险（Open risks）

| # | 风险 | 状态 / 缓解 |
| --- | --- | --- |
| A | PC/Android 2P 默认 AUTO→A 与 iOS B 冲突 | 必须两端显式设 B，否则可见 fail（设计使然）；需在跨设备轮验证提示可见且可操作。 |
| B | 仅 `swiftc -parse`，无 Xcode 类型检查 / 真机 | 最高优先级残留：需在 macOS + Xcode 下 typecheck 并真机跑通 C0 协商。 |
| C | WSS 短键名信封 ≤100 字符 + 关键词过滤可能被服务器拒收 | PC 侧记「3 连拒收才收尾」，iOS 仅做最小实现；未做真机抓包。 |
| D | iOS 云端 2P 为 path B（4 核 / `players:4`） | 受 ADR-004 R3 约束：本机 4 核约 59.7fps，真机跨设备整场仅 20~31fps，非 60fps；不可把 path B 当 60fps 解药。 |
| E |  capability 位与三端口径漂移 | `LobbyFrames` 三参数版本/解码/枚举与 PC、Android 同源，但仅静态对齐；跨设备实跑前不得视为已互操作验证。 |

## 5. 证据纪律

本 ADR 记录的事实均来自提交 `de97dc2e8`（主分支等价 `0734cd266`）的代码与其注释，
属 `[CODE]` / 提交历史证据；**不含设备验证、不含跨设备 E2E 断言**。
引用时不得省略 §3 的验证范围与 §4 的风险表，也不得据此把 2P 云端交付门改写为非 FAIL。
