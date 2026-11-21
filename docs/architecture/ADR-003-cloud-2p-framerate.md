# ADR-003 · 云端 2P（path A）把帧率拉回单机水平

- 状态：已实施（`46f32a221` + `c2c6f2618` + `c023f52eb` + `e50233d26`）。同机双 PC 实例在 P2P 14~16ms 下已验证到 LINKUP（`lstate=4 pc=2`）+ 59.7~60.3 fps（§4.1）；**进球场对打与真机跨设备仍待补实测**
- 日期：2026-11-15（2026-11-16 上午追加 §4.2「接手复盘」：撤回一条基于 path B 读数的结论、修掉导航与诊断里 5 处对当前 ROM 过期的判据）
- 相关：`ADR-002-2p-patha-capability-negotiation.md`（C0 能力协商）

## 1. 问题

2P 云端联机走 path A（每端 1 核 + SIO 20 字节包中继）。两端都走到有线俱乐部
「大竞技场 → 单打」进球场后：

- PC 标题栏实测 **4.6 fps**，无法游玩；
- LINKUP 握手段（`gLink.state=2 → 4`）极慢，双端会长时间停在「请稍候 / 训练家卡片」。

目标（用户口径）：**联机对战帧率必须与单机相同**（贴 59.7 fps 上限）。

## 2. 根因（两处，互相独立）

### R1 · PC 侧单线程 SIO 泵每轮固定付 20ms

`CloudLink::startSioBridge()` 是单线程循环：`select` 本地 socket → `cur->send()`，
循环尾 `cur->recv(&pkt, 20)` 用阻塞收包「让出 CPU」。联机线是一问一答，
**这个 20ms 会原封不动加到每一轮 SIO 传输上**：

- 实测 RTT 只有 6 ms，但 `[sio-rtt]` 显示 `n≈40/s`（≈25 ms/轮）；
- gen8 每帧要 9 轮 MULTI ⇒ 9×25ms ≈ 225ms/帧 ⇒ **4.4 fps**（与 4.6 观测吻合）。

注：`[sio-rtt]` 的量法看不见这 20ms（它只量「本地发出→对端回来」，20ms 发生在发出之前）。

### R2 · 「零等待取字 + 复用上一轮对端字」只在 Qt 主机侧有

`sioFastFrame()`（`src/platform/qt/sio_link.c`）让模拟时钟不再被墙钟按停，
命中后帧率回到单机。但它只挂在**主机**的 `sioDoneEvent` 上：

- Qt **从机**（`sioSlaveDoneEvent`）没有这条路径 → PC 作为 2P 时照旧阻塞；
- 移动端（Android/iOS 共用 `src/platform/mobile/mgba_mobile.c`）**完全没有**等价实现；
- 而且移动端从机分支还多了一个 `sioFastRemoteValid` 守卫，而该字段只在快帧分支内部
  置位 ⇒ **从机快帧是死代码**（永远不会命中）。

## 3. 修复

| # | 位置 | 内容 | 提交 |
|---|---|---|---|
| F1 | `src/platform/qt/CloudLink.cpp:1718/1770` | 单线程泵改非阻塞：`recv(&pkt, 0)`，两向都没数据时 `QThread::usleep(200)` 让出 CPU | `c2c6f2618` |
| F2 | `src/platform/qt/sio_link.c` | 从机侧加与主机同构的快帧分支（同一道门、同一套锁存） | `46f32a221` |
| F3 | `src/platform/mobile/mgba_mobile.c` | 新增 `mobileFastFrame()`，主机/从机两处接入；门判据与 Qt 逐条对齐 | `46f32a221` |
| F4 | `src/platform/mobile/mgba_mobile.c:3184/3513` | 在两条「严格等待」路径拿到真实字时补写 `sioFastRemote/Valid`，把从机快帧从死代码救活 | `c2c6f2618` |
| F6 | `src/platform/qt/CloudLink.cpp` `tryDirectLink` 的 `sendMarker` | 候选公告被大厅 100 字符上限挤掉 `a` 字段：原来超限只删 `r`（省 ~12），而 `a` 里三条候选 + 外壳约 105 ⇒ 对端只收到**没有候选的 `w":"p`**，直连永远起不来。改成逐条丢尾部候选直到 ≤94 字符，并在对端静默丢弃时打日志 | `c023f52eb` |
| F7 | `src/platform/qt/DirectLink.cpp` `candidates()` | 候选按网段排序：192.168/16、10/8 优先，172.16/12（Hyper-V/WSL/Docker 虚拟网卡）垫底；同时修一个字节序错误（用 `htonl` 之后的值比 `0xC0A80000`，小端机器上永不匹配，排序等于没写） | `c023f52eb` |
| F8 | 快帧门判据（`sioFastGateReadyEx`，`src/platform/qt/sio_link.c:3688`） | 把原先逐条复制在多处的一致判据抽成具名纯函数；当前实际门为 `sioFastGateReadyEx(disabled, ok, gLinkState, gLinkPlayerCount, minOk)` = `!disabled && ok >= minOk && gLinkState >= 4 && gLinkPlayerCount >= 2`（`d1854896b` 把 state 门从 `>=2` 收紧到 `>=4`；移动端镜像同判据见 `mgba_mobile.c:3166`）；新增 `test-gboylink --fastgate` 9 条断言（开关关闭、`ok` 边界、`state=1`/`pc=0` 假阳性、`state=2` 拦截 / `state=4` 放行、`ok` 单调性）全 PASS | `e50233d26` |
| F5 | `src/platform/qt/DirectLink.cpp` | 连通后**不再跟随来源地址**（原来无条件 `m_peer = from;`，会把流量从内网 1~3ms 悄悄迁到公网回环几十~上百 ms，界面仍显示「直连已启用」） | 本轮未提交 |

快帧门（判据本体见 F8）：
① `MGBAX_SIO_FAST=0`（Android 另有系统属性 `mgbax.sio.fast`）可整体关闭；
② 链路 `netLinkState == 2`；③ `sioOk >= 256`（握手/训练家卡片块交换期间必须等真实字）；
④ `gLink.state >= 4` 且 `gLink.playerCount >= 2`。
命中后**锁存**，连续 240 轮无新字则解锁（回落到严格等待，不假死）。
这四条的组合已抽成 `sioFastGateReady` 一个函数；`--fastgate` 只测这个函数，
**不测真实会话** —— 它与「现场有没有命中」是两件事（见 §4.1 的 `SIO fast` 命中数 = 0）。

> **门曾经多一条、且这一条把门焊死（`ddd1edd5a` 已修）**：原先还要求
> `gFieldLinkPlayerCount >= 2`。该字段只在野外/联机房间那条路线被写入，
> 有线俱乐部的「大竞技场 / 交换中心」这条路上它**恒为 0** ——
> 11-15 21:41 实测两端已 LINKUP（app PEEK `link[m=8 st=4 id=0 pc=2]`、都停在柜台），
> PC 仍是 4.9 fps、app 日志里一条 `SIO fast` 都没有，就是被这条卡死的。
> 现在它只作加强信号写进日志（`field=` 字段）；会话判据回到 gLink 的
> state/playerCount —— 这正是 LINKUP 的真判据，历史上「只看 cnt 会误判」
> 那种情况（lstate=1 pc=0 却 cnt=2）已被 state>=4 排除了。

## 4. 已验证 / 未验证

**已验证（实测数字）**
- 回归门：`--c0` 45 ok、`--gatetest` 85 ok、`--fastgate` 9 条断言全 PASS、`frames`+`buslocal` PASS、
  `mgba_mobile_test` 严格 ROM 252 ok / 0 skip / mismatch 0 / 「你是 2P」=1。
- F1 的直接效果：同一条服务器隧道上，每轮延迟 **142ms → 122ms**（正好少掉那 20ms）。
- P2P 直连可用（`via=p2p`），但本机用模拟器实测走公网回环，RTT **72ms / 159ms** 抖动；
  真机同 Wi-Fi 曾测到 6~11ms。
- **跨过 LINKUP 的实测（21:41）**：F1 之后两端在 P2P 159ms 下约 2.5 分钟握完，
  app `link[m=8 st=4 id=0 pc=2]`，两端同时停在「大竞技场」柜台的训练家卡片 / 请稍候。
  —— 这一步在 F1 之前从未达成过。
- **同一次实测也暴露了门被第四条焊死**：LINKUP 已成立但 PC 仍 **4.9 fps**、`SIO fast` 一条都没有；
  去掉 `gFieldLinkPlayerCount` 必要条件（`ddd1edd5a`）后两端重建，PC 回到 59.9~60.4 fps。
- **双 PC 实例端到端闭环（00:0x，俱乐部联机态，非球场对打）**：同机 P2P 14~16ms 下两实例
  同时到 `lstate=4 pc=2`、59.7~60.3 fps，驱动脚本 `verify_patha.sh` PASS=9/FAIL=0（详见 §4.1）。

**未验证（不得当成已达成）**
- **「进球场开打后帧率 = 单机」仍未拿到端到端实测**：上面的 60fps 读数出现在柜台/对话框阶段，
  还没走到球场对打；握手段本身仍按真实对端字走，隧道（122ms）下会拖到几十分钟。
  本轮受直连 RTT 72ms + 取消实验所限，没有跑完到出手表读数。
- 复用陈旧字对**游戏后期块校验**（战斗中队伍/招式块）的影响未验证；历史上陈旧字曾把
  `cnt` 打回 0，现用 `sioOk>=256` + 三重门挡在前面，但 256 轮之后的块传输没有专门断言。
- 快帧是**强版本绑定**：两端都必须带 F2/F3，一端旧版本时那一轮会超时成空槽 → 通信错误。
- 帧率上限的物理约束仍在：一旦快帧被解除锁存（对端停摆 240 轮），帧率立刻回落到
  `fps ≈ 1000/(9×RTT)`，隧道 122ms 时只有 ~0.9fps。

### 4.1 实测基线（2026-11-16 00:0x，同机双 PC 实例 · P2P 192.168.1.5）

拓扑：同一台机器跑两个 PC 实例，`MGBAX_DIRECT_LOCAL_FIRST=1` 让候选公告优先本机内网地址，
直连命中 192.168.1.5，日志 `via=p2p`。

| 观测项 | 读数 |
|---|---|
| 链路 | `via=p2p avg=14~16ms peak=27~36ms` |
| 帧率 | 两实例 `59.7 / 59.8 / 60.0 / 60.3 fps`（同时稳定，未回落） |
| 联机状态 | 结束前最后一个 `[diag]` 行 `lstate=4 pc=2`（已 LINKUP：主机 state=4、playerCount=2） |
| SIO 主机 | `multi ok=26176 fb=25918 last=0.4ms to=0` |
| SIO 从机 | `ok=26176 mis=26165 last=131283ms` |
| 快帧是否参与 | **无法判定** —— PC 侧**没有任何输出 `SIO fast` 的日志语句**（该字符串在 `sio_link.c` 里仅出现一次，是 :1122 的注释）；`fb` 也不能用（见下） |

> **`fb` 不能当快帧指标**：`sioFallback` 有三个增量点 —— `sio_link.c:229`（普通注入路径，与快帧无关）、
> `:785`（从机快帧复用）、`:1189`（3/4 人总线空槽收尾），共用一个计数器。所以主机 `fb=25918/26176`
> 无法区分是哪条路径贡献的，**不可据此推断快帧命中率**。
>
> 表里从机侧 `mis=26165`、`last=131283ms` **属数据在手、机理未定**，本轮未做解读（为什么 `last` 是 131 秒、
> `mis` 比 `ok` 少 11，都没有验证），**不要当成已知现象引用**；待查项。

结论（第 1、2 条由这组读数直接支撑，第 3、4 条是它**不能**支撑的部分）：

1. **14~16ms RTT 下泵本身就跟得上**：`multi` 每轮 `last=0.4ms`，一帧 9 轮的预算远未用满，
   快帧门未命中也能贴 60fps。⇒ 4.6fps 那组读数的瓶颈是**每轮 RTT**，不是引擎效率；
   `fps ≈ 1000/(1.9×RTT)` 在 14ms 下给出约 60fps 的上界，与实测一致。**同机 P2P 14ms 下
   「2 人俱乐部联机 + 满帧」成立。**
2. **`last=0.4ms` 只能证明「每轮没有等墙钟」，不能反推是哪条路径做到的**：14~16ms 链路上
   严格路径的等待本来就在亚毫秒~数毫秒量级，与快帧复用旧字的读数落在同一区间。
   加上 PC 侧没有任何 `SIO fast` 日志语句（`sio_link.c` 里该字符串只出现在 :1122 的注释中）、
   `fb` 又是三处共用计数器，**「这一组 60fps 里快帧有没有参与」本轮无法判定**。
   （最早一版写「命中数 = 0 ⇒ 快帧没触发」是错的：拿一条 PC 上从不打印的日志当阴性证据，等于没测。）
   同理 §6 第 3 条里 `SIO fast on`/`SIO fast me=…` 两行**只在 app 端 `adb logcat` 里存在**，与 PC 无关。
3. **未验证**：本轮**没有**在「快帧已锁存（`SIO fast on`）+ RTT 大到泵跟不上」的组合下取到帧率读数。
   所以「快帧把帧率拉回单机」这条因果，目前只有 21:41 那次间接读数（去掉第四条门后 59.9~60.4fps，
   但当时同样没有可用的快帧证据）与 `--fastgate` 的判据单测支撑，**缺一组
   「高 RTT + 每轮 `last` 掉回亚毫秒 + 55~60fps」的现场对照**——注意这里的判据是 `last` 的阶梯，
   不是 `SIO fast`/`fb`（两者在 PC 侧都不成立）。
4. 仍缺：**进球场对打阶段**的帧率（本轮读数停在俱乐部联机/柜台阶段）。
5. 操作前提：两个实例必须各用独立 `TEMP`，否则两份实例写同一个 `%TEMP%/mgba_sio.log`，
   `[diag]` 行无法归属到实例。

### 4.2 接手复盘（2026-11-16 上午 · 一次「结论要撤回」的复盘）

> 本节只写**当场能复核**的读数与落盘位置；未复核的推断一律标出来。

#### (a) 基线复核（本轮实跑）

| 门 | 命令 | 读数 |
|---|---|---|
| C0 帧层 | `build-win/qt/test-gboylink.exe --c0` | `45 ok / 0 FAIL`，EXIT=0 |
| 协商门 | `--gatetest` | `85 ok / 0 FAIL`，EXIT=0，wall **9.34 s** |
| 快帧门 | `--fastgate` | `PASS (0 FAIL)`，EXIT=0 |
| 帧/总线/锁步 | `frames` / `buslocal` / `product-lockstep` | 三条全 EXIT=0 |
| Android 自检门禁 | `cd android && ./gradlew :app:runLinkSelfTests --offline` | **`runLinkSelfTests: 8/8 PASS`**、BUILD SUCCESSFUL（清单里写的 6/6 已过期，条数以当次输出为准） |
| Android 编译 | `:app:compileDebugJavaWithJavac --offline` | BUILD SUCCESSFUL |

`--gatetest` 9.34 s 落在 §2.4 记的「约 8.7~9.3 s」上沿附近（多 0.04 s），不触发
「窗口被缩水」的怀疑；条数 85 与清单 Rev.9 的口径一致（以当次输出为准）。

#### (b) path B（本机 4 核总线）**已经**达成「进对战」——这是本轮最硬的一条新证据

`tools/busgame-lockstep.sh`（固定 `BUSGAME_FRAMES=9000 / TIMEOUT=260000 / MODE_DOWNS=2 /
MENU_AT=1500`，ROM+map 快照到 `.zcode-tmp/busgame-run/`）本轮实跑**三次**：

| 次数 | 时间 | 结论 |
|---|---|---|
| ① | 09:27 | `LINKUP-ACHIEVED BATTLE=YES`，`battleSamples=4560`，`lastCb2=080B3C3D`（BattleMainCB2） |
| ② | 09:35 | `BATTLE=YES` 但 `battleSamples=313`、`lastCb2=081E27C1`（掉回文本框）——**同期机器在跑 Gradle 构建**，属已知的 load-sensitive flaky |
| ③ | 09:45（空载重跑） | `LINKUP-ACHIEVED BATTLE=YES`，`battleSamples=3737`，`lastCb2=080B3C3D` |

三次共同的硬读数：`4/4 cores reached playerCount=4`、`4 cores saw 8FFF`、
`linkType=[2211×4] var8004=[5×4] result=[1×4]`、`field pos=[(3,4),(10,4),(3,6),(10,6)]`、
`party type=[13×4] sel=[0102×4] slot=[6×4]`、`ROM md5=f7886655167767f960319aaf46987a94`、
动态 battle 窗口 `battleWindow=[080B24B8,080BBE4C)`。

⇒ **「4 核本机总线能推进到对战」这一条不再是待验证项**（口径：4 核**同机**场景；
跨设备 path B 的 20~31 fps 上限仍按 R-3 记，不因本条改变）。

#### (c) ⚠ 要撤回的一条：2026-11-16 02:51 那轮（`.zcode-tmp/cloud2p/NAV1`）**不是 path A**

现场读数是 `lstate=2 pc=0 mu=0 rem=0`，一度被读成「PC path A 的握手卡在 lstate=2」。
逐条回查该轮的大厅日志（`NAV1/a_tmp/mgba_lobby_debug.log`）后判定：**那一轮走的是 path B**：

```
[status] 联机模式协商通过：B（本机多核 + 网络只传按键）（WSS 隧道，2 人房）
[status] 房间已创建，房号 769032 官方镜像联机（本机多核，网络仅传按键）正在启动镜像核心
[arm]    t=12345 released: visible f0 + 3 mirrors CONNECTED
```

`2 人房` + AUTO 映射（2P→A）本该解析成 **A**，却协商成了 **B** ⇒ 只能是**显式覆盖**
（环境里残留 `MGBAX_OFFICIAL_LINK=1` 或 `MGBAX_LINK_MODE=B`；`CloudLink` 构造器
`CloudLink.cpp:635-648` 读这两个变量，`MGBAX_OFFICIAL_LINK` 等价于 B）。
path B 下可见核**不产生 SIO MULTI 轮次**（MULTI 走本机环回总线），所以 `mu=0` 是路径特征、
不是「握手坏了」的证据；`lstate=2` 也没在比较同一个协议层。

⇒ **教训（已落成工具）**：双实例驱动必须**钉死联机模式并把协商结果落盘**，否则
「这一轮到底跑的是哪条路径」要靠猜。新的 `tools/cloud2p-duo.py` 会清掉环境里的
`MGBAX_OFFICIAL_LINK` / `MGBAX_LINK_MODE` / `MGBAX_NAV_AT`，`--mode A|B|AUTO` 显式指定，
并把 `mode_negotiated_A/B`、`official_mode_A/B`、`nav_at_leak` 写进 `summary.txt`。

#### (d) 产品侧导航（`mgba_mobile.c` 的 `mgbaMobileBusGameNavKeys`）对**当前 ROM** 有三处过期/错读

当前 `rom.gba` = `rom.md5 f7886655…`（= `D:/gen8/rom.gba`，两份 md5 相同；
`rom_b.gba` 是另一次构建 `99a90d5b…`，但**关键地址的字面量计数与 rom.gba 完全一致**，
所以两侧可以用同一套常量）。对照 `D:/gen8/rom.map` 逐个核：

| # | 位置 | 问题 | 证据 | 处置 |
|---|---|---|---|---|
| N1 | `mgba_mobile.c` `ready2` | 用 `gFieldLinkPlayerCount`（0x03004A39）当「2P 已连上」的门。该变量**连锁完成后**才由 `cable_club.c:373/:421` 写 ⇒ 门恒假，2P 分支永远进不去 | `gen8/src/cable_club.c:373,421` | 改用 `gLink.playerCount`（0x03002AF7，`link.c:2288` 在收到 MASTER_HANDSHAKE 时写）：`ready2 = (!multi4 && gLink.state>=4 && gLink.playerCount==2)`，并用 `multi4`（var8004=5 且 gLinkType∈{0x2255,0x2211}）把 4P 路径隔开，避免回归已验证的 path B |
| N2 | `mgba_mobile.c` `busGameTitleCb` | cb2 区间是**随 ROM 重新链接平移的代码地址**，旧区间对当前 ROM **一个都不匹配**：标题画面 `CB2_InitTitleScreen @0x081F83F0`（cb2=0x081F83F1，屏内还跳 0x081F86F5 / 0x081F8A65）、版权画面 `CB2_InitCopyrightScreenAfterBootup @0x0815DBA4` | `rom.map` + 本轮 `cb2trace` | 补上当前 ROM 的两个区间（0x081F8300..0x081F8D00 标题、0x0815D800..0x0815DCFF 版权/开机过场），旧区间保留 |
| N3 | `mgba_mobile.c` `mgbaMobileBusGameInBattle` | 战斗窗口写死 `[0x08099848,0x080A30FC]`，与当前 ROM 的 `battle_main.o .text` `[0x080B24B8,0x080BBE4C)` **完全不相交** ⇒ 「已进战斗」永远判不出 ⇒ 导航进战斗后不停手 | 本轮 busgame-lockstep 的动态窗口（`rom.map`） | 改成「`gMain.inBattle`（数据标志：`gMain @0x02029114` +0x439 的 bit1 = 0x0202954D，`battle_main.c:657` 置 TRUE）**或** cb2 落在窗口内」；窗口可用 `MGBAX_GBOY_BATTLE_LO/HI` 覆盖，换 ROM 不必重编 |

#### (e) `[room]` 的 `cb2` 高半一直是坏的 —— 连带把脚本的「进没进游戏」判据废掉了

`sio_link.c` 原来把 32 位的 `gMain.callback2` 拆成两个 16 位读：低半 `0x02029118`（对）、
高半 `0x020290EA`（**错**，那还是 EWRAM 整体上移 0x30 之前的地址，比低半还低 0x2E）。
现场读数：真实 `gMain.callback2 = 0x08188981`（`CB2_Overworld`），而 `[room]` 打出来是
**`0x00008981`** —— 高半被削成 0。

这条不是小洁癖：双实例驱动判定「进没进游戏」用的就是 `[room] cb2=0816F9C5`
（俱乐部柜台）。高半坏掉之后**这个判据永远匹配不上**，脚本只能一直盲按 A 到超时。
已改为一次 `GBAView32(0x02029118)`。

#### (f) 同一批「EWRAM 整体上移 0x30」里**漏改**的其余几处（本轮一并核出）

`c1977bcfe` 那次 +0x30 是 76 处替换，但至少 4 处漏了（本轮用 `rom.map` + ROM 字面量计数交叉核出）：

| 位置 | 旧值 | 正确值 | 影响 |
|---|---|---|---|
| `sio_link.c` `sMenu.minCursorPos` / `windowId` | 0x020296C3 / 0x020296C5 | **0x020296F3 / 0x020296F5** | `[diag] menu=c/mi/ma/w` 里的 `mi`、`w` 一直是垃圾字节（`cursorPos`/`maxCursorPos` 当时被改了，这俩没改） |
| `sio_link.c` `gBattleCommunication[MULTIUSE_STATE]`（两处） | 0x0201CFC4 | **0x0201CFF4** | `mu=` 字段读的是 `gDisableStructs` 那一片 |
| `mgba_mobile.c` `PEEK_LINK_OPEN` | 0x02027B80 | **0x02027BB0**（`gLinkOpen`） | Android `PEEK` 的 `open=` 一直在读 `gBlockSendBuffer` 附近的垃圾 |
| `mgba_mobile.c` `gBattleCommunication[MULTIUSE_STATE]` | 0x0201CFC4 | **0x0201CFF4** | 同上 |

核对方法（可复用）：`rom.map` 取符号地址 → 与代码常量对表；再用**ROM 二进制里绝对地址
字面量的出现次数**做交叉验证（例如 `sMenu` 基址 0x020296F0 在 rom.gba 里出现 19 次，
`0x020296C0` 出现 0 次）。

#### (g) path A 双实例（本轮实跑）：握手失败的**机理**第一次被定位到具体代码行

`tools/cloud2p-duo.py --tag PA2 --mode A --nav`（P2P 直连，`[sio-rtt] via=p2p avg=15~23ms`，
两端协商到的模式都是 **A**，`official_mode=False`）：

```
mode_negotiated_A=A mode_negotiated_B=A   official_mode_A=False official_mode_B=False
multi_A=SIO multi me=0 role=0 mst=1 idx=128 ok=128 last=32.8ms peak=58.1ms to=0  fb=0 mis=0   m0=B9A0 m1=B9A0
multi_B=SIO multi me=1 role=1 mst=0 idx=128 ok=128 last=34053.3ms peak=34053.3ms to=15236 fb=0 mis=128 m0=B9A0 m1=B9A0
final_A l=2 pc=2   final_B l=1 pc=0
```

⇒ **path A 确实跑起来了**（这是第一次拿到「模式=A」的干净读数）：主机侧 128 轮 MULTI
全部成功（`to=0`、`mis=0`）、收到了从机的握手字 `0xB9A0`；两端都进了联机俱乐部、
`gLink.state` 到 2（HANDSHAKE）。但**握手没能收尾**，两侧最后都退回到 `lstate=1`。

机理（逐条对上代码，不是推测）：

1. **游戏侧有两条硬时限**（`gen8/src/link.c` / `cable_club.c`）：
   - `link.c:2190` `if (++sNumVBlanksWithoutSerialIntr > 10)` —— 串口中断**超过 10 个
     VBlank**不来，就把握手重置（`gLink.playerCount = 0`）。即**每一轮 MULTI 必须在
     ≈167 ms 内落地**，否则握手被反复清零。
   - `cable_club.c:563-569` `TryLinkTimeout()` —— 任务计时器超过 **600 帧（≈10 s）**
     就进 `Task_LinkupConnectionError`，`gSpecialVar_Result = LINKUP_CONNECTION_ERROR`。
2. **从机侧的时间全坏了**：`to=15236`（超时次数）、`last=34053ms`（**单轮 34 秒**）、
   `slave miss-rate n=8316/1000ms`（每 1000 ms 空转 8316 次）、`slave miss … age=1005ms`
   → `age=2430ms`（**对端上一次推字已经过去 2.4 秒**）、`q=0`（对端队列空）、
   `stale=0 drop=0`（不是被判旧字丢的）。主机侧 `wait=0/31ms`（每轮等对端 31 ms）、
   `last=32.8ms`。
3. ⇒ **两侧互相等**：主机每轮要等从机回字（31 ms），从机在 2048 cycles 的固定
   短周期里空转等主机推字（`sio_link.c:1034`），而对端推字要等自己那一轮结束才发。
   节奏一旦错开，就会出现 >10 帧的空档 ⇒ 触发 (1) 的握手重置 ⇒ 600 帧后
   (2) 报 `LINKUP_CONNECTION_ERROR`。
4. **现场判据**：从机的 `gSpecialVar_Result`（`[diag] linkup=`）= **6** =
   `LINKUP_CONNECTION_ERROR`（`gen8/include/constants/cable_club.h:23`）。
   **这条可以作为「握手没收尾」的机器可读判据**，比盯画面可靠。

⇒ 剩余动作从「不知道卡在哪」变成一条具体的：**从机的轮周期必须跟住主机**
（`sio_link.c` 的 `sioPeerCycles` / `sioSlavePeriod` 适配：从机只在**成功取到字**之后
才更新周期（`:1039-1050`），取不到就退回固定 2048 cycles 空转，于是永远学不到主机的
节奏）。两个候选修法（都还没实施、不在本轮结论里）：
① 从机在**没取到字**时也用「上次已知的主机周期」而不是固定 2048 去排下一轮；
② 把主机推字与从机收字解耦（主机按固定节拍推，从机按固定节拍取），去掉互相等待。

#### (h) 进一步定位：**两端都退化成了从机**，谁也没当上主机

从 §4.2 (g) 的数据继续往下问「为什么握手收不了尾」，答案是**主机选举**：

- gen8 侧（`gen8/src/link.c`）：
  - `CheckMasterOrSlave()`（`:2057`）：`terminals = SIOCNT & (SIO_MULTI_SI|SIO_MULTI_SD)`，
    **只有 `terminals == SIO_MULTI_SD`（bit2 清、bit3 置）且 `gLink.localId == 0` 才是主机**；
    否则 `gLink.isMaster = LINK_SLAVE(0)`。
  - `LinkMain1()`（`:1980`）：`shouldAdvanceLinkState==1` 时，若
    `gLink.isMaster == LINK_MASTER(8)` 且 `gLink.playerCount > 1` 才把
    `gLink.handshakeAsMaster` 置真 —— 主机随后才会往 `SIOMLT_SEND` 写
    `MASTER_HANDSHAKE(0x8FFF)`（`:2260`）。
  - `DoHandshake()`（`:2289`）：收尾条件是 `tempRecvBuffer[0] == MASTER_HANDSHAKE`。
- 现场读数（PA2）：**A 的自槽字 = 0xB9A0、B 的自槽字 = 0xB9A0** ——
  `0xB9A0` 是 `SLAVE_HANDSHAKE` ⇒ **两端都把自己当成从机**，场上根本没有 0x8FFF，
  收尾条件永远不成立。与 `[diag] st(gLinkStatus)=00000000` 一致
  （`gLinkStatus = LinkMain1(...)`，全 0 ⇒ localId=0、playerCount=0、isMaster≠8）。
- 仓库里**早就有人踩到过这个形态**：`sio_link.c` 的 `maybeRearmHandshake` 注释写着
  「**两侧都退化成从机时 isMaster 都是 0**，旧代码直接 return，补触发永远不执行」，
  并把门改成了「链路 1P 且 isMaster != 8 也放行」。但那个补触发**默认是关的**
  （要 `MGBAX_LINK_REARM=1` 才开），原因是历史上开了之后出现过
  「选举时机与游戏脚本搅在一起 → 链路崩溃（`C0000005` 特征）」。
  ⇒ **PA2 的 `[rearm]` 零行不是新 bug，是开关默认关**（这点必须写清楚，否则会被
  当成「补触发没生效」的证据）。

⇒ 下一步的两个最小动作（本轮只做完了第 0 步）：

0. **加观测**（本轮已做）：`[diag]` 增加 `role=im%u/lid%u/hs%u sc=%04X/%u`
   —— `im`=`gLink.isMaster`、`lid`=`gLink.localId`、`hs`=`gLink.handshakeAsMaster`、
   `sc`=`REG_SIOCNT` 及其 bit2/3。下一次跑就能直接看出是
   「bit2 没清掉」「bit3 没置上」「还是 localId 不为 0」。
   ⚠ `sc` 要从 `gba->sio.siocnt` 读（游戏真正看到的寄存器）；`0x04000128` 是 IO 区、
   `0x03000128` 是 IWRAM 里无关的变量 —— 第一版读错了，已改。
1. **A/B 试补触发**：`MGBAX_LINK_REARM=1` 跑一轮双实例，看握手能不能收尾
   （判据：`[diag] linkup=` 从 6 变 1、`lstate` 到 4）。**同时要盯崩溃**：
   历史上开这个开关会出 `C0000005`。若能收尾又不崩，再讨论「是否默认打开」；
   若崩，就地记录崩溃特征（哪个核、哪个时刻、linkup= 是什么）。

##### (h.1) A/B 结果（PA4，`MGBAX_LINK_REARM=1`）：**角色选举是对的，握手也成功了，但链路随后被清空**

PA4 的 `[diag]`（lstate=2 期间，摘录）：

```
A: st=00000228 lstate=2 pc=2 intr=44 linkup=1 role=im8/lid0/hs0
B: st=00000209 lstate=2 pc=2 intr=38 linkup=0 role=im0/lid1/hs0
```

- **角色完全正确**：`im8/lid0` = A 是主机（`LINK_MASTER=8` 且 `localId=0`），
  `im0/lid1` = B 是从机且 id=1 —— `CheckMasterOrSlave()`（`link.c:2057`）判定通过。
  ⇒ **「两端都当从机」是 REARM 关闭时的形态，不是常态**；补触发让选举走通了。
- `st`（gLinkStatus）不再是 0：A=0x228（含 MASTER 位 + playerCount=2），B=0x209。
- `intr` 在涨（44/54）⇒ 串口中断在流，`link.c:2190` 的「10 个 VBlank 没来就重置」没触发。
- **A 的 `linkup=1` = `LINKUP_SUCCESS`** ⇒ **主机侧的握手成功了一次**。
- 但 `hs0`（`handshakeAsMaster`）仍是 0、且收尾时两端都退回
  `lstate=1 pc=0 intr=0 linkup=1` —— **`intr` 归零 + `lstate` 回 1 是
  `CpuFill32(&gLink)` 的特征**（`sio_link.c` 里 `maybeRearmHandshake` 的注释
  记录过同一个签名：「lstate 1 pc 0 intr 0 linkup=6」）。

⇒ 结论（比 §4.2 (h) 前进了一步）：**补触发能让主机选举成功并把主机侧握手推成
`LINKUP_SUCCESS`；真正剩下的问题是「成功后链路被清空」**。两个待分辨的可能：
① 从机侧（B）没跟上（B 的 `linkup=0`，仍 ONGOING），主机等不到对端就收链；
② 补触发与游戏脚本抢时序（历史上开这个开关崩在这附近）。

##### (h.2) 游戏侧「收尾」到底要什么（读 gen8 源码得到，2026-11-16）

`GetLinkPlayerDataExchangeStatusTimed()`（`gen8/src/link.c:825-898`）是收尾的唯一判据：

```
if (gReceivedRemoteLinkPlayers == TRUE) {
    numPlayers = GetLinkPlayerCount_2();           // 来自 gLinkStatus
    if (minPlayers > numPlayers || numPlayers > maxPlayers) → EXCHANGE_WRONG_NUM_PLAYERS(4)
    else {
        count = 统计 gLinkPlayers[i].linkType == gLinkPlayers[0].linkType 的个数;
        count == GetLinkPlayerCount() → EXCHANGE_COMPLETE(1) → LINKUP_SUCCESS
        否则                      → EXCHANGE_DIFF_SELECTIONS(3)
    }
} else if (++gLinkTimeOutCounter > 600) {
    → EXCHANGE_TIMED_OUT → LINKUP_ONGOING(0)     ← 「一直没收到对端数据」就落这里
}
```

三条关键事实：

1. **`gReceivedRemoteLinkPlayers` 是前置条件**，它由 `HandleReceiveRemoteLinkPlayer()`
   （`link.c:513-528`）置位，而后者只被 **`ProcessRecvCmds()`** 调用 ——
   即**对端的 linkType 是走 MULTI 命令通道（`gRecvCmds[]` ← `SIOMLT_RECV0..3`）过来的**，
   **不是**走块传输。
2. **`gLinkTimeOutCounter > 600`** ⇒ 600 帧（≈10 s）内没收到对端数据 ⇒
   `LINKUP_ONGOING`（=0）。现场从机侧读到的正是 **linkup=0**，即它卡在这一档。
3. 「训练家卡片」的**块传输**是 `LINKUP_SUCCESS` **之后**的事
   （`cable_club.c:429` 的 `SendBlockRequest(2)`），走 NORMAL_8 通道。
   ⇒ 所以路径顺序是：**握手 → cmd 通道交换 linkType（决定 SUCCESS/ONGOING）→
   块通道传卡片 → 进对战**。本轮现场 `[room] rc=0000:0000,0000:0000` ⇒
   **cmd 通道里一个命令字都没落地**；`n8/n32` 计数（本轮新增）⇒ 块通道是否启动过。

⇒ path A 的收尾分三段，逐段可判：

| 段 | 判据（都在 `[diag]` 里） | 本轮读数 |
|---|---|---|
| ① 握手 | `role=im8/lid0`（主机）+ `pc=2` + `hs=1` | PA4 达成 `im8/lid0`+`pc=2`，但 **`hs` 仍是 0**（`handshakeAsMaster` 没置真 ⇒ 主机还没开始发 0x8FFF） |
| ② cmd 交换 linkType | 对端槽位出现非 0 命令字；`linkup` 由 0 变 1 | 主机侧 linkup=1、从机侧 linkup=0；`rc` 全 0 |
| ③ 块通道传卡片 | `n8>0`、`brs!=0000` | `n8=0`、`brs=0000/0000` ⇒ **第 ③ 段根本没开始** |

##### (h.3) 根因定位（本轮收口，两条独立根因）

**先修掉一个实验缺陷**（它制造了大半的「时好时坏」）：`tools/cloud2p-duo.py` 原来
每轮直接跑仓库里的 `rom.gba`/`rom_b.gba`，而 mGBA 是按 `<rom>.sav` 读电池存档、
退出时写回同一个 `.sav` ⇒ **存档每轮都在漂**，而导航是「盲按 A」，落到哪个菜单
取决于存档里玩家站在哪 ⇒ 同一套参数这轮能进联机、下一轮就停在柜台。
实测：PA5~PA7（存档已漂）三轮 `SLOT` 零行、连一轮 MULTI 都没成；改成每轮用
**母本存档（`D:/gen8/rom.sav`）的干净副本**之后（PA8~PA10），每轮都能稳定走到
`state=2 / pc=2 / im8`。另外把闭环步数上限 26 → 4000（旧上限 ≈30 秒，
而握手本身要几十秒，于是实验全在握手前就被砍掉）。

**根因 A · 主机不设 `handshakeAsMaster`，于是永远发从机握手字**

现场（PA8/PA9，主机侧连续 256 轮）：

```
SLOT n=192 me=0 mst=1 data=B9A0,B9A0,FFFF,FFFF pc=2 lstate=2 im=8 hs=0
```

`data[0]` 是主机自己的槽 ⇒ 主机**每轮都在发 `0xB9A0`（SLAVE_HANDSHAKE）**，
从没发过 `0x8FFF`（MASTER_HANDSHAKE）。于是：

- 对端 `DoHandshake()`（`link.c:2289`）的收尾条件
  `tempRecvBuffer[0] == MASTER_HANDSHAKE` **永远不成立** ⇒ 从机侧
  `gLinkTimeOutCounter>600` ⇒ `EXCHANGE_TIMED_OUT` ⇒ `linkup=0`；
- 主机自己也就不会把 linkType 命令字发出去 ⇒ 从机的
  `gReceivedRemoteLinkPlayers` 起不来。

**为什么 `handshakeAsMaster` 没被置真**：游戏靠 `LinkMain1()` 的
`case 1:`（`link.c:1980`）置它，而那条分支要求 `*shouldAdvanceLinkState == 1`
**恰好**在 LinkMain1 跑到那一帧时为 1 —— 但 `LinkMain1` 在**每次调用结尾**都
无条件 `*shouldAdvanceLinkState = 0`（`link.c:2000`）。模拟器的补触发
（`maybeRearmHandshake`）是在 SIO 中断上下文里置这个标志的：**置得晚一帧就被
LinkMain1 的收尾清掉** ⇒ 实测 `[rearm] fired n=1..3` 而 `hs` 始终 0。

⇒ **本轮的修法**：`maybeRearmHandshake()` 改为**每轮**都把
`gLink.handshakeAsMaster`（struct Link +0x0E = 0x03002B02）置真
（游戏每轮自己会清掉它，正好一轮一清），并把该函数的调用点从「每 64 轮」
挪到**每轮**。旧行为只在每 64 轮补一次 ⇒ 主机 62/63 的轮次发的是 0xB9A0。

**根因 B · 从机侧轮周期跟不上主机 ⇒ 偶尔丢轮 ⇒ 游戏误判「人数不对」直接拆链**

PA10 的现场：

```
SLOT n=192 me=0 mst=1 data=B9A0,FFFF,FFFF,FFFF pc=1 lstate=2 im=8 hs=0
multi_B=SIO multi me=1 role=1 mst=0 idx=192 ok=192 last=68902.4ms to=58832 mis=192
```

主机侧某几轮**对端槽是 FFFF**（对端那轮没答上来）⇒ `gLink.playerCount` 从 2
掉到 **1** ⇒ 游戏的 `GetLinkPlayerDataExchangeStatusTimed()`（`link.c:838`）
判 `numPlayers < minPlayers` ⇒ **`LINKUP_WRONG_NUM_PLAYERS`** ⇒
`cable_club.c:360` 走 `SetCloseLinkCallback()` ⇒ **链路的 task 死了** ⇒
`DoHandshake()` / `LinkMain1()` 都不再跑 ⇒ 随后 `CloseLink()` →
`DisableSerial()` → `CpuFill32(0, &gLink, sizeof(gLink))`（`link.c:1926`）——
**这正是仓库早就记下的那个签名**（`lstate 1 pc 0 intr 0 linkup=6`）。

从机侧丢轮的机制在 §4.2 (g) 已经量过：`to=58832`、空转 8000+ 次/秒、
对端推字 age 可达 2.4 秒 ⇒ 从机的轮周期（`sioSlavePeriod`）跟不上主机
（只在**成功取到字**之后才更新，`sio_link.c:1039-1050`）。

⇒ 两条根因的关系：**B 让对端偶尔丢轮 ⇒ A 的 playerCount 掉到 1 ⇒ 游戏判人数不对
⇒ 拆链 ⇒ 链路的 task 死了 ⇒ A 也再也没机会设 handshakeAsMaster ⇒ 握手彻底卡死**。
所以要修的是 **B（从机轮周期）** + **A（每轮补 handshakeAsMaster）** 两处；
只修 A 会被 B 的拆链打断。

⇒ 下一步（可执行，按优先级）：
① **从机轮周期跟住主机**（根因 B，§4.2 (g) 的候选修法 ①）：从机在**取不到字**时
   也按「上次已知的主机周期」排下一轮，而不是固定 2048 cycles 空转。
② **抑制误拆链**（根因 B 的兜底）：某轮对端字缺失导致 `gLink.playerCount` 掉到 1 时，
   不要让游戏看到 1（保留上一轮稳定值）——「人数」在联机里不会一帧就变。
③ 验证 ①/② 之后 A 的自槽应变成 **0x8FFF**（`SLOT` 日志一眼可见），
   从机的 `linkup` 应由 0 变 1，最后 `lstate` 稳在 4、`pc=2` 不回退。

⚠ **`mis` 不是错轮判据**：从机侧 `mis ≈ 成功轮数` 是**健康**表现
（`sio_link.c:1059-1061` 已写明：主机下一轮永远是 +1，每轮成功取字都会 +1 到这里）。
本轮 `B: ok=128 mis=128` 正是健康读数，**不要**拿它当故障证据。

##### (h.4) 2026-11-16 11:47 重大纠偏：不是「轮次不同步」，是 cmd 阶段一字相位差

**推翻 h.3 根因 B 的「从机慢 17 轮」说法**。那是把不同时刻的日志尾部 grep 在一起
造成的采样错位。逐轮原始 `SLOT` 数据（CLN1，修复后干净验证）证明**两端严格同步**：

```
n=21  A: data=8FFF,B9A0 pc=2 lstate=4    B: data=8FFF,B9A0 pc=2 lstate=4   ← 两端同轮 LINKUP
n=22  A: data=2222,B9A0 pc=0 lstate=1    B: data=2222,B9A0 pc=2 lstate=4   ← A 当轮即崩，B 尚正常
n=23  A: data=2222,B9A0 pc=0 lstate=1    B: data=2222,B9A0 pc=0 lstate=1   ← B 慢一轮也崩
```

两端在同一轮（n=21）握手成功、同一轮（n=22）开始收到 cmd 字 `2222`，不是谁快谁慢。

**真机理（gen8 源码 + 数据双向确认）**：

1. 握手成功判据 `DoHandshake()`（`link.c:2289`）要求
   `tempRecvBuffer[0] == MASTER_HANDSHAKE(0x8FFF)`；rearm 每轮补 hs ⇒ 主机持续发 8FFF
   ⇒ 两端 n=21 同时成功。
2. 成功后**两端状态机路径不同**：主机进 `LINK_STATE_INIT_TIMER`(3) 再转 4
   （`link.c:2228`），从机**直接** `LINK_STATE_CONN_ESTABLISHED`(4)（`:2232`）。
3. **一字相位差出现在 cmd 字切换**：n=22 主机自槽已切 `2222`
   （`DoSend()` 从 sendQueue 取 `LINKCMD_SEND_LINK_TYPE`），但从机自槽**仍是 `B9A0`
   握手字**（晚一轮）。根因是两端扣自槽字的时机不同：从机在**游戏写 SIOCNT 起轮时**
   扣（`sio_link.c:1856`），主机在 `beginMultiTransfer` 起轮时扣（`:1686`）；两者相对
   各自 SerialCB / DoSend 的执行错开一轮。
4. `LinkCB_RequestPlayerDataExchange()`（`link.c:1252`）**只有主机** `BuildSendCmd(2222)`；
   从机收到 2222 后在 `case LINKCMD_SEND_LINK_TYPE`（`:543`）→ `InitBlockSend(训练家卡片块)`
   回送。从机没在正确轮次切到块发送 ⇒ 主机收不到 from-slave 的 linkType/块 ⇒
   `gLinkTimeOutCounter` 超时（`:894`）或校验失败 ⇒ `Task_LinkupConnectionError` 置 `linkup=6`。

**插桩**：`sio_link.c` 的 `SLOT` 日志新增 `sq=%u w=%04X`（`sendCmdIndex` + 收尾前
`SIOMLT_SEND`），用于直接观测两端 DoSend 时机；已编译同步 dist。

**(h.5) PHASE2 插桩复测（11:52）——三次纠偏后定论：路障在驱动脚本，不在产品链路**

带 `sq/w` 的复测 + 逐行验证给出精确读数：

```
A(主机) n=15 data=8FFF,B9A0 pc=2 lstate=4 im=8 sq=0   ← 全场唯一的自发握手成功
        n=16 pc=0 lstate=1 im=0                       ← 随即被打断
B(从机) n=13 lstate=4  n=14..16 sq=1,2,3 w=0000        ← 进 DoSend 但 sendQueue 空
上报: linkup=1×297  linkup=0×71  linkup=6×33  linkup=255×14
```

⚠ **纠正一个反复踩的陷阱**：`linkup=1` 出现 297 次**不是** LINKUP_SUCCESS。逐行核对
（`gSpecialVar_Result=0x020219AC` 地址已用 rom.map 确认无误）发现 `linkup=1` 时
`role=im0/lid0/hs0`（isMaster=0、pc=0）、`st=0`（293/297）、`menu=c0/0/1/w2` —— 它是
脚本在大地图菜单反复按 A 留下的**残留值**。真正握手成功全场只 1 次
（`lstate=4 pc=2 st=00000828 role=im8`）。**禁止把 `linkup=1` 当成功判据**；成功判据是
`lstate=4 && pc=2 && st 含 MASTER(0x20)` 的稳定态。

`cb2=08188981` 经 rom.map 验证 = **CB2_Overworld**（0x08188980+1）：游戏停在大地图。
`ltype=0` 全程为 0（`LINKTYPE_BATTLE=0x2211`；旧记录里的「4403」作废）。

**真卡点 = 驱动脚本震荡**：`tools/cloud2p-duo.py` 的 loop 里 A 端反复
`l=2 menu=w2`（菜单开）→ 按 A → `l=1 menu=w0`（菜单关）→ 下一 step 又 `l=2`，
两端在两态间横跳，从未一致推进过确认框；n=15 握手是链路偶然自发达成、随即被按 A 打断。

**产品侧结论**：P2P 候选排序修复 + 每轮 rearm 均生效（SIO 能自发跑到 n=15 并握手），
路障在**驱动脚本的导航/闭环状态机**，不在仿真/握手代码。本轮产品代码仅加插桩
（`sio_link.c` 的 `sq/w` 字段，无行为改动）。2P 云端进对战仍未闭环，交付门维持 **FAIL**。
**下一步**：修 `cloud2p-duo.py` 的按 A 节奏——菜单状态变化后等待稳定，不再每次 diag 都按 A。

**(h.6) PHASE3/FASTEARLY1（12:00-12:11）—— LAG_MASTER 拆链根因 + 主机侧突破**

`st=`(gLinkStatus)、`cq/c0`(sendQueue) 插桩（地址均用 gen8 struct Link 布局核对）给出
完整因果链，修正 h.4/h.5 的「cmd 相位差」方向：

```
PHASE3(默认门限):  A n=34 data=8FFF,B9A0 pc=2 ls=4 st=0x368 cq=1 c0=2222
                     ← 2222 已入队、st 无错误位；握手+cmd入队这段是通的
                   A n=46 pc=0 st=0x10368  ← 多出 LAG_MASTER(0x10000) → 拆链
FASTEARLY1(门限8): A n=39 sq=1 w=2222 → n=40 sq=2 w=1133 → n=41..46 sq=3..8
                     ← cmd 通道 8 字首次完整跑通
                   A n=64 仍 ls=4 pc=2 sq=6 st=0x368  ← 链路保住，LAG 消失
                   B n=64 pc=0 st=0x2249  ← badChecksum(0x2000)，从机新卡点
```

**LAG_MASTER 机理**（gen8 源码坐实）：握手成功时 SerialCB 把 `gLink.serialIntrCounter`
预置 8（`link.c:2228`）；每个 VBlank `LinkVSync` 要求它 ≥9 才 `StartTransfer()`，
否则 `gLink.lag=LAG_MASTER`（`:2159-2170`）→ `EXTRACT_LINK_ERRORS` 含 0x10000 →
`CheckErrorStatus()`（`:1606`）→ `CloseLink()` → `CpuFill32(&gLink)` → state=1 pc=0。
path A 云端握手在 n≈34 就达成，但快帧门 `sioOk>=256` 让这 220 轮走慢速网络往返
（每轮约 51ms≈3 帧），每帧 SIO 中断远不到 9 次 ⇒ 必被判 LAG。

**修法**（可开关、默认关）：新增 `sioFastGateReadyEx(...,minOk)`，
`MGBAX_FAST_MIN_OK=8` 让快帧在握手后立即生效，一帧喂满中断。
单测 `--fastgate` 新增 7 条 Ex 断言全 PASS，c0 45/0、gatetest 85/0 无回归。

⚠ **辨析**：`st` 里 0x100/0x200 是 RECEIVED_NOTHING/UNK_FLAG_9，**不是**错误位
（错误位是 0x7F000：HW 0x1000 / CKSUM 0x2000 / QFULL 0x4000 / LAG_MASTER 0x10000 /
BADID 0x20000 / LAGS 0x40000）。badChecksum 假设在 PHASE3 被证伪（st 从无 0x2000），
但在 FASTEARLY1 的**从机**上真实出现了。

**剩余卡点**：从机快帧取字 `netLinkTakePeerWordAny(sioIndex,...)` 拿自己冻结的
`sioIndex` 当期望序号（`slave fastframe miss idx=50 q=0`，主机已推到 idx 576），
永远 miss ⇒ 复用旧字 ⇒ 块交换 checksum 失败。正常门限 256 给了 200+ 轮让两端
idx 对齐；提早生效暴露了这个不对齐。下一轮需让从机跟随主机最新 idx，或给快帧门
加「两端 idx 已对齐」条件。**主机侧已从必死救到稳定**；2P 云端交付门仍 **FAIL**。

### 4.3 path B 双实例（2026-11-17 晚 · TCP 星型总线 → 进程内总线）

PC 上 `--mode B` 的两个云实例各自要跑「可见核 + 3 镜像核」的 4 核本地房间。
之前镜像核用 `netLinkBusJoin` 连 `127.0.0.1:<port>`、可见核用 `netLinkBusHost`
监听，结果**四核 SIO 轮次永远对齐不了**：

- PB13/PB14：两端都抢 18781，镜像核随机连进另一进程的 bus；修成 A=18781 /
  B=18782 并把官方握手三步挪到「3 镜像 LINK_CONNECTED + nav_at 写好 + 放开
  arm hold」之后，隧道不再 2.7~5.7 秒自断。
- PB15：端口已隔离、3 个镜像 1~3ms 全部 welcome，但可见核 `m1=FFFF`、镜像
  核 `mis≈5700 / to≈1800`。根因不是带宽，而是 TCP 星型总线让每个核各算各的
  轮次号，加上 Windows 的 2ms 定时器地板把错位放大成「主机等从机本轮字、
  从机等主机广播」的互等。

**决定**：PC 的 4 核本机房间改走 `netLinkBusHostLocal` /
`netLinkBusJoinLocalSlot`（`LocalBus`，共享内存 + 只有主机一个时钟源，
从机永远跟随主机当前轮次；轮次号天然对齐，无 socket、无 2ms 地板）。
可见核占总线槽位 0，镜像核按会话槽位 2/3/4 占 1/2/3；key 每局重新生成，
四核共用。`MGBAX_LOCAL_BUS=0` 保留 TCP 分支仅作对照实验。
验证入口：`tools/cloud2p-duo.py --tag PB16 --mode B --nav --runsec 150`
（看 `[mirror]` 的 `l/pc/st` 与 `[SIO multi]` 的 `mis/to` 是否收敛）。

### 4.4 接手复盘（2026-11-17 晚 · PB16–PB33 + gboy APK 源码比对，path B 进对战仍未打通）

**结论先行**：这一轮把 path B 的传输层缺陷基本修完，但「两实例进对战」仍未达成；根因是**架构级**的，不是再打一个补丁能解决。

**已修并有实证的缺陷**（均已编译部署，保留）：
- TCP 星型总线 → 进程内 `LocalBus`（PB15 `mis≈5700/to≈1800` → PB16 `mis=0/to=0`；PB26 广播出真实 `8FFF/B9A0`）。
- 6 处 `0x03002Axx` 硬编码绕过 `SIO_IW()/NAV_IW()`（`sio_link.c:1037/1250/1266/2573/3264`、`mgba_mobile.c:2768`），其中 `handshakeAsMaster` 写错地址导致主机发不出 `0x8FFF`（现场 `hs0`）。
- TYPE_STATE 载入触发 `mTimingClear()` 冲掉从机事件但 `sioSlaveArmed` 残留 true（`mobileLoadStateLocked` 成功分支重建事件链）。
- `navIwDelta()` 的「先置 init 后读 env」并发竞态（同进程 4 核会读错 IWRAM delta）。
- `MGBAX_LOCALBUS_DIAG`/`MGBAX_SLAVE_DIAG` env-gated 诊断 + `BCAST`/`SIO slave arm` 日志降噪。

**逐一排除的假设**（均未让 pc 从 0 上升）：LocalBus 已在 PB16 修好；PB26 主机已推 `8FFF`；NPC 镜像推 `0000`（PB33 强灌 `B9A0` 反而更差，已回退）；ready4 读恒 0 的 `gFieldLinkPlayerCount`（PB31 修复被 `multi4` 门吞掉成 no-op，已回退）；旧 ROM 基线 `f7886…`；`CB2_Overworld` 判据；ARM 相位对齐（PB32 开了 `MGBAX_OFFICIAL_ARM=1`，四核 t=234 同时起跑仍卡）；CoreController 锁步接入（PB27/28 跨线程 `setPeripheral` 导致 `0xC0000005`）。

**APK 源码比对（`tmp_gboy_apk/decompiled_all/sources/com/game/boy/`）的关键发现**：
1. 官方是**自研 `libgboy.so`，不是 mGBA 内核**。JNI 面 32 个函数，Java 层零 `lockstep`/`mgbaMobile*`/`setBusGame`/`linkHost`/`join`。
2. 官方**只有 1 个模拟线程**（`KpHwm4/AaHO0E.java:95-100` 的 `D8MqeW`），每帧只调**一次** `Link.runFrame(boolean)` 顺序推进全部核；SIO 由 native 内部总线同步，**无一核一线程/墙钟超时**。
3. 4 颗核 = 4 个真人各自导航，镜像核重放远端真人按键流（`NETPLAY_AUDIT.md:340-350`）；**官方没有自动导航脚本**，也没有 `var8004/gLinkType/gSpecialVar_Result` 内存判据。
4. 官方开局有**统一 reset + 帧闸 rendezvous**（`AaHO0E.java:184-203`：`ASJ6gh` 停帧 → 可见核+所有镜像 `reset(false)` → `AMqCpz` 放行）；我们的 `cloudArmReload` 默认关、load 后有意不 reset，是最大顺序差异。
5. 官方 `Link.patch()`（唯一内存写 JNI）**零调用点**——它不注入任何握手字，让 pc 0→4 的是游戏收到正确四槽字后自己数的（`link.c:2289`）。

**结论**：我们 PC path B 用「4 线程 + 自动导航脚本 + 跨线程总线/锁步会合」模拟官方「单线程顺序推进 + 真实按键」，这是结构性错位。唯一稳定 `BATTLE=YES` 的是不含 Qt 可见核的 `busgame-product`（4 个 mGBA 核同进程锁步，`ls_result.txt`）。

**后续方向（需决策）**：① 对齐官方架构——把可见核也纳入单协调器顺序推进（产品化 `busgameLockstepTest`），唯一有 `BATTLE=YES` 背书，工作量大；② 继续在 4 线程架构补统一 reset/帧闸 + 让 NPC 镜像真正进握手流程，风险高且与官方反向。当前 `MGBAX_LOCKSTEP` 默认关（锁步接入会崩），path B 停在「总线通但 pc=0」。

## 5. iOS 对齐结论

**先纠正一句容易误导的说法**：不能说「iOS 没有 path A」。准确的是两件事：

1. **iOS 的云端 2P 不是 path A**：`EmulatorViewController.swift` 的云端路径是
   `armCloudMulticore` → `GBoyConsoleSet(players: 4, localSlot: 1)` →
   `mgbaMobileLinkHostLockstep/JoinLockstep`，SIO 在进程内由协调器会合，网络上只跑按键。
   所以 **F1（Qt 泵去阻塞）在 iOS 侧没有对应实现，也不需要** —— 那条路径不存在。
2. **iOS 的「远程联机」（`RemoteLink` → `mgbaMobileLinkHost/Join`）确实是 SIO 包中继**，
   只是线协议是 `link_net` 的 `struct Packet`，与 PC/Android 的 GBoy 帧 path A **不互通**。
   这条路径会命中 `mobileFastFrame()`，所以 F3/F4 对 iOS 是**实质生效**的（不是「名义覆盖」）。

其余对齐事实：

- iOS 与 Android 共用 `src/platform/mobile/mgba_mobile.c`（`CMakeLists.txt:1404-1411` 的
  `mgba_mobile` 静态库对 `ANDROID OR CMAKE_SYSTEM_NAME STREQUAL "iOS"` 生效；
  `ios/build-core.sh:80` 只构建该目标，`-DBUILD_QT=OFF`）。`ios/` 下没有任何 `.c/.m/.mm`，
  SIO 驱动只有两份：`mgba_mobile.c`（netLink）与 `src/gba/sio/lockstep.c`（协调器）。
  ⇒ F2/F3/F4 里移动端那两份自动生效，Qt 那份不适用。
- 门放宽（`ddd1edd5a`）也在共享文件里 ⇒ iOS 下次编译自动拿到。
- 非 Android 分支的开关走 `getenv("MGBAX_SIO_FAST")`，iOS 上恒 NULL ⇒ **默认开启**；
  代价是设备侧没有关闭开关（要 A/B 只能改代码重编；最小加开关方案见下方 R-iOS-2）。
- **iOS 唯一真正缺的能力不是本轮这些**，而是 **C0 能力协商**（`linkMode`/能力位/协商门）：
  iOS 只走 B 且不发能力位（ADR-002 的红线），代价是
  **iOS 与 PC/Android 在官方云大厅组 2P 房时，对方约 2 秒后按「对端未声明联机模式」断开，
  而 iOS 侧没有任何提示**。影响面仅云端 GBoy 帧通路；iOS↔Android 的局域网 GBoy 大厅
  与「远程联机」不受影响。
- 未验证：iOS 编译（Windows 无 `xcodebuild`/iOS SDK）、真机帧率、
  「iOS 远程联机开快帧后是否回到单机帧率」。

## 6. 现场判据（下次直接看这五处）

1. PC 日志 `%TEMP%/mgba_lobby_debug.log`：`[sio-rtt] ... via=p2p avg=?ms`
   —— 决定握手段能不能快速过；隧道时 avg 上百毫秒，握手会拖到几十分钟。
2. **PC 端要看 `[diag]` 必须同时设 `MGBAX_SIO_LOG=1` 与 `MGBAX_LINK_DIAG=1`**：`MGBAX_LINK_DIAG=1` 只打开采集，`SIO_LOG` 里 `mLOG(GBA_SIO, INFO, …)` 在 release 下不落 stderr，只有 `sioLogFile` 会写 `%TEMP%/mgba_sio.log`。**只设后者会得到零行**，很容易误判成「没有 SIO 活动」。字段：`lstate`=gLink.state、`pc`=playerCount、`px/py`=存档坐标、`menu=c光标/min/max/w`、`mt/mid`=多选任务 id 与当前项、`cb2`=回调地址、**`keys=%03X`=核心内 `gba->keysActive & 0x3FF`（判断按键是否真到核心，只看这一个字段）**。
3. app `adb logcat -s mGBA:I mGBA-App:I GBoyLink:I`：`SIO fast on`（快帧锁存瞬间）与
   `SIO fast me=… n=… reuse=… miss=…`（每 256 轮一条）。**完全没有这两行 = 门没命中**
   （注意日志 tag 是 `mGBA` / `mGBA-App` / `GBoyLink`，不是 `mGBA:I` 就能全收）。
   但反过来**不成立**：命中数 = 0 不代表联机异常 —— RTT 只有 14~16ms 时泵自己就跟得上，
   满帧也不会触发快帧（见 §4.1）。
4. 进球场后看 PC 标题栏 fps：贴 59~60 即达标；仍在 4~5 先查 `gLink` 的 state/playerCount
   与 `sioOk`（`[diag]` 里 `lstate`/`pc`），**再看 `[SIO multi]` 的 `last=`**：
   若 `last` 仍≈链路 RTT，说明每轮还在等墙钟（快帧没进）；`last` 掉回亚毫秒而 fps 仍低，
   则是别处的瓶颈（渲染/音频同步），不是 SIO。PC 侧**没有** `SIO fast on` 这行，别去找。
5. **下结论前的进程判活三件套**（三条不全就分不清当前日志与上一轮残留）：`tasklist` 能看到
   `mGBA.exe` + `pcfps.py` 打印出实时帧率（报 `no mGBA window` 即已死）+ `<dir>/_started.txt` 存在。
   后台起的 GUI 进程会随进程树被回收，进程一死日志就停在上一轮，据此得出的
   「按键无效」结论已经错过两次。另：两实例必须各用独立 `TEMP`，否则 `%TEMP%/mgba_sio.log`
   被两个实例混写，`[diag]` 行无法归属。

`pcfps.py`（本机临时工具，读窗口标题）可直接打印 PC 实时帧率，不必截图；它同时也是判活手段之一。

## 7. 剩余动作

**先分清两段，别混着说「联机掉帧」**：

| 阶段 | 谁在等 | 帧率公式 | 机制结论 | 本轮证据 |
|---|---|---|---|---|
| 握手 / 训练家卡片（`gLink.state` 0→4） | 每轮都要真实对端字（块校验不能用陈旧字） | `fps ≈ 1000/(9×RTT)` | **不可能**解决：这是协议约束，快帧有意不覆盖这一段 | 159ms 隧道下 **3.4fps**；P2P 159ms 实测 **2.5 分钟**握完；真机同 Wi-Fi 6~11ms ⇒ 按同一公式推算约 6~20 秒（推算值，非本机读数） |
| 进球场之后（`state=4, pc=2`） | 不再等墙钟（快帧命中后复用上一轮字） | 本机模拟速度 | **机制上成立**（快帧命中并锁存后不再等墙钟，帧率跟随本机模拟速度）；实现是 F1~F4 + 门放宽（`ddd1edd5a`） | 00:0x 只测到**俱乐部联机态** `lstate=4 pc=2` + 59.7~60.3fps，且 `SIO fast` 命中数 = 0（14ms 下没走快帧分支）；**球场对打阶段的读数未取得**，「高 RTT + 命中数 > 0 + 60fps」的现场对照也缺（§4.1） |

| # | 事项 | 现状 | 最小动作 |
|---|---|---|---|
| R-1 | 「球场对打」帧率终测 | **未做，且前置未打通**：00:0x 的同机 P2P 14ms 双实例已拿到 59.7~60.3fps，但读数停在**俱乐部联机/柜台**阶段，没进对打。2026-11-16 上午重跑（`tools/cloud2p-duo.py --mode A --nav`）确认**握手本身还没收尾**（见 R-8），所以到不了球场 | 前提是 R-8 先修好；之后两端进到球场按下准备后看 PC 标题栏是否贴 59~60；同时 `adb logcat -s mGBA:I \| grep "SIO fast"` 应有 `on` 行与递增的 `n=`（若 RTT 已在 14ms 量级、命中数仍为 0，属 §4.1 的正常情况，不据此判失败） |
| R-2 | 握手段在隧道 / 公网回环（72~159ms）下太慢 | 协议上限 | 快帧**有意不覆盖**握手段；缩短只能靠 P2P 走内网。**F5 就是干这个的**：修完后再测 `[direct] 忽略来自 …` 是否出现、`[sio-rtt] via=p2p avg=` 是否回到 1~3ms 量级 |
| R-3 | 想要「全程」贴单机 | **path B 做不到 60fps** | **别把 path B 当解药**：它的实测是同一台机器 4 核 59.7fps（菜单期）、**真机跨设备整场只有 20~31fps**，而且是「4 人房 + 2 个 NPC 陪位」不是 1v1。命令（注意 Android 是 `--es mode B`，不是 `--ei value 1`）：PC `MGBAX_LINK_MODE=B`（或 `MGBAX_OFFICIAL_LINK=1`）+ `MGBAX_AUTOLINK=…`；Android `am broadcast -a io.mgba.android.action.GBOY_LINK_MODE --es mode B`。两端必须都设，C0 会校验一致 |
| R-4 | **P2P 候选交换是单向的** | **已修（F6/F7）** | 根因不是「收不到」而是「收到了但 `a` 被 100 字符上限挤掉」：现场 `[demux] w=p` 有、`[direct] 对端候选` 没有。修后同机双实例双向都拿到候选并 P2P 成功（`直连加速已启用（P2P 192.168.1.5:…，RTT 21 ms）`），此前一侧恒为 `peerCandidates=0`、永远回落 120~200ms 隧道 |
| R-5 | **双 PC 实例无法被驱动到联机态（已闭环；历经两次更正，更正过程本身是防重犯的关键）** | **更正 1（23:12 那版）**：把「桥接空转的 RTT 探针」误读成握手轮次 —— `sio-rtt` 4 轮/秒、每轮 96~154ms 只是桥接探针的往返，与握手无关，**不能支持任何握手结论**。**更正 2（原 R-5b，撤回更正 1 的根因）**：把根因判成「path A 可见核没有按键注入」是错的 —— 单实例实测 `MGBAX_SCRIPT_DIR` + `<dir>/keys` 在 path A **生效**，证据链 `_mask.txt` → `_keys_applied.txt: gm=8 active=8` → `[diag] keys=008` → 轻按 START 后 `cb2` 逐屏变化 → 轻按 A 后 `cb2=0816F9C5`、`px=10 py=4`（俱乐部柜台）。**最终结论（三根因，全部实测）**：① 仓库自带 `rom.sav` 是 131072 字节全 `0xFF` 的空档 ⇒ 主菜单没有「继续游戏」，按什么都进不去；② GBA 输入是**边沿触发**，`<dir>/keys` 只给电平，**长按 3~4 秒不产生按键边沿**（长按 START 4s `cb2` 纹丝不动，轻按一次即推进）；③ 后台起的 GUI 进程会被回收，进程一死 `%TEMP%/mgba_sio.log` 读到的就是上一轮残留。「按了不动」是这三条叠加的**观测假象**，不是引擎或协议缺陷 | 驱动 PC 的前提固定为：存档非空（用 `D:/gen8/rom.sav`，空档已备份为 `.zcode-tmp/cloud2p/rom.sav.blank`）+ 按键一律「按住 150-250ms 再归零」+ 父进程用看门狗保活 + 下结论前过判活三件套（`tasklist` / `pcfps.py` 有帧率 / `<dir>/_started.txt`）。另：`MGBAX_SCRIPT_DIR` + `MGBAX_NAV_AT` 是 path B 4 核 busgame 自动驾驶，与 path A 无关，别混用 |
| R-6 | **产品侧导航对当前 ROM 的判据过期**（`mgba_mobile.c` `mgbaMobileBusGameNavKeys` + `sio_link.c` 诊断） | **本轮已修**（详见 §4.2 (d)(e)(f)）：`ready2` 读错变量（N1）、标题/版权 cb2 区间与当前 ROM 完全不匹配（N2）、战斗窗口与当前 ROM `battle_main.o .text` 完全不相交（N3）、`[room] cb2` 高半读错地址导致脚本的「进没进游戏」判据永远失配（e）、`+0x30` 批量替换里漏改的 4 处地址（f） | 修完的验证口径分两层：① **path B 单机 4 核**（`tools/busgame-lockstep.sh`）三次实跑两次 `BATTLE=YES`、一次空载重跑 `BATTLE=YES`（§4.2 (b)）；② **path A 双实例**用新工具 `tools/cloud2p-duo.py --mode A --nav` 跑，见 R-1。**不要**用旧结论（「path A 握手卡在 lstate=2」）反推这批修复的效果——那条结论来自一轮 path B（§4.2 (c)） |
| R-7 | **双实例驱动没有钉死联机模式** | **本轮已修**：环境里残留 `MGBAX_OFFICIAL_LINK=1` 会把 2 人房悄悄拽成 path B（§4.2 (c)） | 改用 `tools/cloud2p-duo.py`（新进仓库）：`--mode AUTO|A|B` 显式钉死模式、清掉环境残留、把 `mode_negotiated_A/B` 与 `official_mode_A/B`、`nav_at_leak` 落进 `summary.txt`；`--nav` 给可见核装内存驱动导航（path A 用：path A 没有镜像核，`nav_at` 只能自己写） |
| R-8 | **path A 的握手/收尾走不完** | **本轮定位到机理并前进了一步，未修完**（§4.2 (g)(h)(h.1)(h.2)）：① 关闭补触发时（PA2）两端都退化成从机（自槽字都是 `0xB9A0`，全场没有 `0x8FFF`），`[diag] st(gLinkStatus)=0`；② 打开 `MGBAX_LINK_REARM=1`（PA4）后**角色选举正确**（A `im8/lid0` 主机、B `im0/lid1` 从机，双方 `pc=2`、`intr` 在涨），**主机侧握手推到 `linkup=1`（`LINKUP_SUCCESS`）**，但随后两端都退回 `lstate=1 pc=0 intr=0 linkup=1` —— `intr` 归零 + `lstate` 回 1 是 `CpuFill32(&gLink)` 的特征（**链路成功后被清空**）；③ 读 gen8 源码确认收尾分三段（握手 → cmd 通道换 linkType → 块通道传卡片），现场卡在第 ② 段（从机 `linkup=0` = `gLinkTimeOutCounter>600` 的 EXCHANGE_TIMED_OUT），第 ③ 段根本没开始（`n8=0`） | 仪表本轮已装好：`SLOT` 每轮四槽载荷日志、`N8/N32` 计数、`role=im/lid/hs/sc`。**下一步**：跑一轮 `MGBAX_LINK_REARM=1`，看从机槽位里有没有出现主机的命令字；有 ⇒ 查从机取字路径是否与主机对称（`completeMultiTransfer()` 的 `data[me==0?1:0]` + `sioSelfSlot`）；没有 ⇒ 查主机为什么没把命令字推出去。**验证判据**：`lstate==4 && pc==2 && st 含 MASTER(0x20)` 稳定不回退 + `n8>0`（剔除 `linkup=1`：它是菜单 A 残留值，见 §4.2 h.5 / `ADR-004` §1.3 BLK-H4） |
| R-iOS-1 | iOS 缺 C0 能力协商 | 缺（ADR-002 红线） | `LobbyFrames.swift` 的 `registerFrame` 增 `linkMode` 参数、`playerCount != 1` 时写 `wire[11]=0x41`；并在 `LobbyLink.handle` 增 `typeRegister` 分支解析对端能力位。**只补写侧不够**：AUTO 2P 会 A/B 冲突，需两端同模式 || R-iOS-2 | iOS 关不掉快帧 | 默认开、无法 A/B | `mgba_mobile.h` 加 `void mgbaMobileSetSioFast(struct MgbaMobile*, bool)`；实现写 `sioFastEnabled` 并在关闭时清 `sioFastLatched/Miss`；`EmulatorViewController.swift` 用 `link_fast_frame` 开关在 4 个启动点（局域网 host/join、中继 host/join）各调一次 |
| R-iOS-3 | iOS 真机验证 | 0 证据 | macOS + Xcode 构建 `libmgba_ios.a`，两台真机跑「远程联机」看 `SIO fast on` |

### P1 方案（未实施）：握手段「有界预测」

先把话说清楚：**握手阶段的慢不是网络层串行化造成的**。模拟器语义上，下一轮
`SIOMLT_SEND` 要等本轮 SIO 中断（`finishMultiTransfer/hl`）之后才被游戏写出，
`netLinkPush` 推的就是「AI 本轮参与的值」—— 所以「我方连推 N 轮」在协议上无处可用。
实测也吻合：1 轮/帧时 `fps ≈ 1000/RTT`（159ms → 3.4fps 正是 st=2 段读数），
2~4 轮/帧的窗口 `fps ≈ 1000/(1.9×RTT)`。文献里 ADR 原写的 `9×RTT` 只适用于
「全员在场、每帧 9 轮」的激战段（sio_link.c:944 的历史注释就是那个场景）。

若要继续压握手段，唯一有价值的杠杆是**有界预测**，且必须按下面的门与退路做，
否则就是重演「陈旧字把 cnt 打回 0」：

1. 只在**牌型包**上允许复用（`data[0]/data[1] ∈ {0x8FFF, 0xB9A0}`），数据块一律等真实字；
2. 复用轮次上限 2（`sioFastMiss < 2`），第 3 轮强制阻塞；
3. 需要「对端仍活着」的证据：`netLinkPushAgeMs < 2×RTT`；
4. 一旦本会话出现 `sioTimeouts>0 || ck!=0`，**整局**退回严格等待（不许再预测）；
5. 判据：`SIO fast … reuse/n` 与 `[room] cnt` 不被打回 0，且 `st=2→4` 的墙钟时间下降。

**不建议**的做法（有历史证据）：把预热 `sioOk>=256` 整体下调 —— 在真机上只会重演
「cu->st=2 却没 established 时被快帧打坏，末尾 linkup=6」；只在没有 `sioFastFrame` 的
旧版本上「看起来很赚」，收益是 0 而风险是整局。

### 工具现状（本轮实测，避免重复踩）

| 手段 | 结论 |
|---|---|
| `MGBAX_SIO_LOG=1` + `MGBAX_LINK_DIAG=1` | **PC 端唯一能看到 `gLink`/`px`/`menu` 的组合**（写 `%TEMP%/mgba_sio.log`）；只设后者会得到零行，容易误判「没有 SIO 活动」 |
| `[diag]` 字段 | `lstate`=gLink.state、`pc`=playerCount、`brs`=块接收状态、`rem`=已就绪远端数、`cb`=gLinkCallback、`px/py`=存档坐标、`menu=c光标/min/max/w窗口`、`mt/mid`=多选任务与当前项、`cb2`=回调、`keys`=核心内 `gba->keysActive & 0x3FF`（**判断按键是否真到核，只看这一个字段**） |
| `MGBAX_SCRIPT_DIR` + `<dir>/keys` | 钩子在 `Window.cpp:3128-3131`，path A 生效（`CoreController::updateKeys` 并入 `ScriptedControl::globalMask()` 后）。判据链：`<dir>/_mask.txt`（进程读到）→ `<dir>/_keys_applied.txt`（进了 `core->setKeys`）→ `[diag] keys=008`（进了 `gba->keysActive`）。**协议只支持「电平掩码」：长按不会产生 JOY_NEW 边沿，标题/主菜单必须轻按（按住 ~150-250ms 再归零）**，长按会永远停在标题 |
| `MGBAX_SCRIPT_DIR` + `MGBAX_NAV_AT` | 这是 **path B 4 核 busgame 自动驾驶**（`CloudLink.cpp:2047-2062`），与 path A 无关 |
| `test-gboylink --fastgate` | 只测 `sioFastGateReadyEx` 的**判据逻辑**（9 条断言：开关、`ok` 边界、`state=1`/`pc=0` 假阳性、`state=2` 拦截 / `state=4` 放行、`ok` 单调性）。**不测真实会话、不能替代现场 `SIO fast` 读数** |
| 双实例 `[diag]` 归属 | 两个 PC 实例必须各用独立 `TEMP`，否则同时写 `%TEMP%/mgba_sio.log`，`[diag]` 行无法判断来自哪个实例 |
| app 端 `adb` 驱动 | 已验证可用（`ctl.py app`），是当前唯一可靠的双端驱动方式 |
