# GBoy / mGBAx 双人联机实现拆解与移植方案

> 本文来自对 `C:/Users/lenovo/Desktop/GBoy_261018.Apk` 的静态拆解，以及 2026-11-10 夜里
> PC + 安卓双端走 gboy 服务器实测的日志。目的是把「两人联机到底怎么实现的」讲清楚，
> 并给出 PC 端要对齐时需要改哪些地方。

---

## 1. APK 结构：壳 + 4 个真 dex

`classes.dex` 的头部只有 **162 个字符串、6 个类**，是个壳。真正的代码以 ZIP 形式
**原样（stored，未压缩）** 附在 `classes.dex` 尾部：

| 偏移 | 条目 | 大小 |
|---|---|---|
| `0x25a4` | classes.dex | 8,080,212 |
| `0x7b7124` | classes2.dex | 8,112,324 |
| `0xf73a14` | classes3.dex | 6,578,848 |
| `0x15b9ce0` | classes4.dex | 21,584 |

剥离方式（不需要任何工具，按 ZIP local header 切片即可）：

```python
import struct, zlib
data = open('classes.dex', 'rb').read()
for off in (0x25a4, 0x7b7124, 0xf73a14, 0x15b9ce0):
    sig, ver, flags, method, mt, md, crc, cs, us, nl, el = \
        struct.unpack_from('<IHHHHHIIIHH', data, off)
    body = data[off + 30 + nl + el: off + 30 + nl + el + cs]
    raw = zlib.decompress(body, -15) if method == 8 else body
    open('classes_%x.dex' % off, 'wb').write(raw)
```

**方法体是加密的**：androguard 解析报 `opcode 0xed/0xee/0x42` 和
`High byte of opcode with format 10x must be zero`，连 com/* 第三方 SDK 也一样。
所以**只能拿签名与字符串常量，拿不到可读的 Java 实现**——这是硬边界，别指望反编译。

---

## 2. 联机 API 面：`com.game.boy.emu.gba.Link`

位于 classes2.dex。它与 native 的全部契约就是这 9 个方法：

```java
long     nativeOpenConsole(String romPath, int index);   // 起一个"掌机"，返回原生句柄
void     nativeCloseConsole(Console c);
ByteBuffer allocateBuffer(int size);                     // 与 native 共享的链路缓冲
void     deallocateBuffer(ByteBuffer b);
int      patch(ByteBuffer buf, int off, byte[] data);    // 直接改模拟器内存（传按键/同步用）
void     loadBios(byte[] b);
String   loadRom(ByteBuffer buf, int size);
void     unloadRom(String name);
void     runFrame(boolean draw);
```

字段只有一个 `ArrayList` 的 Console 列表 —— 说明**同一进程里可以挂多个掌机实例**（本地多核）。

`libgboy.so`（1.6MB）只导出上面这几个 JNI 符号，**没有任何 socket/select/recv 符号**，
⇒ **网络全部在 Java 层**，native 只负责模拟 + 共享内存。

---

## 3. 传输层：三条通道

| 通道 | 关键证据（dex 字符串池） | 说明 |
|---|---|---|
| WiFi 热点 / 局域网 | `GBoy-Hotspot`、`setWifiApEnabled`、`wifi_server`、`wifi_client`、`WifiManager$LocalOnlyHotspotCallback` | 房主开热点或同网段，直连 |
| 蓝牙 | `BluetoothDeviceListActivity`、`BLUETOOTH_CONNECT/SCAN`、`BLUETOOTH_ADMIN` | 经典蓝牙 RFCOMM |
| 远程房间 | `wss://gboy.top:23459`、`https://gboy.top/RoomConfig.php`、`47.103.87.123:<node_port>` | 大厅 WS 信令 + 每房间一个 KCP 中继节点 |

### 3.1 大厅信令
`create_game_room` **要调两次**：第一次只给 `room_id`，join/ready/`update_room_settings`
之后**再调一次**才会在返回里带 `node_address` + `node_port`。 `node_port` 是**按房间随机分配**
的高位端口（40097/50372/… 各不相同），不能缓存复用。

### 3.2 数据帧格式（关键）

官方中继上跑的是**带长度前缀的自定义帧**，不是裸字节流：

```
+--------+--------+------------------+
| u32 BE | u16 BE |     body ...     |
| length |  type  |                  |
+--------+--------+------------------+
   length = 2 + body.length   （即包含 type 那 2 字节）
```

类型表（`GBoyFrames`，classes2.dex 常量）：

| type | 名称 | 用途 |
|---|---|---|
| 1 | REGISTER | 会话注册，body 固定 10 字节：`int players, short 0, int baseStateCount` |
| 2 | INPUT_2 | 打到 2 号槽位的按键掩码 |
| 3 | READY | 握手就绪；联机中复用为 3 号槽位按键 |
| 4 | INPUT_4 | 打到 4 号槽位按键 |
| 5 | RESET | 重开，body 是一个 int 0 |
| 6 | STATE | **存档/状态传输**；2P 联机时被复用成「字节管道」，见下 |
| 7 | KEYS_LOCAL | 本地玩家按键掩码 |
| 8 | COUNTER | 自由计数器 |
| 9 | FPS | 帧率上报（实测固定发 60） |
| 10 | EVENT | 带外事件 |

两个最常用的封装：

```java
// 只带一个 int 的帧（10 字节）——实测在隧道上以 ~30 帧/秒 的节奏刷，内容是
// 00 00 00 06 | 00 00 | 00 00 00 00  → len=6, type=0, value=0
static byte[] frame(int type, int value) {
    byte[] out = new byte[10];
    putInt(out, 0, 6); putShort(out, 4, type); putInt(out, 6, value);
}
// 带裸载荷的帧（length 计的是 type + body）
static byte[] frame(int type, byte[] payload) {
    byte[] out = new byte[4 + 2 + payload.length];
    putInt(out, 0, 2 + payload.length); putShort(out, 4, type);
    System.arraycopy(payload, 0, out, 6, payload.length);
}
```

### 3.3 2P 的 SIO 数据怎么走

`GBoyCloudLink.startSioRelayBridge()` 是整个 2P 联机的核心：本地 netLink 的
**20 字节包**被逐个封进 `type=6 (STATE)` 帧，经 KCP 中继转发；对端拆出 payload
按字节写回本地 socket，交给自己的 netLink 拆包：

```java
// 出向
int n = in.read(buf);                       // 本地 netLink 的 20 字节包
link.send(GBoyFrames.frame(TYPE_STATE, buf[0..n]));

// 入向
relayReader.append(message, message.length);
while ((body = relayReader.next()) != null) {
    if (GBoyFrames.typeOf(body) != TYPE_STATE) continue;   // 握手残留/心跳，忽略
    os.write(GBoyFrames.payloadOf(body));                  // 写回本地 socket
}
```

注释里写得很直白：**官方中继对 type 1..6 是透明转发，两条客户端之间它就是一条字节管道**，
而且「官方中继（阿里云上海）的 RTT 低 3–7 倍」。

### 3.4 两条通道的取舍

| | WS 大厅隧道 | KCP 中继节点 |
|---|---|---|
| 载荷 | `{"w":"f","r":房号,"o":id,"d":"<hex>"}`，20 字节切片 → 40 hex | `GBoyFrames` 二进制帧 |
| 拿到节点 | 不需要 | 建房第二次调用才返回 |
| RTT | 高（实测 95–215ms） | 低（节点 ping 30–38ms） |
| 回退 | —— | 拿不到/不应答就退回 WS 隧道 |

---

## 4. 我们这边实测到的差距（2026-11-10 夜）

环境：PC `192.168.1.5`（Qt 版）、安卓模拟器 `10.0.2.17`，都加载 `D:/gen8/rom.gba`，
房间走 gboy 大厅（房号 808534），`MGBAX_NO_DIRECT=1` 禁 P2P。

现场日志：

```
[sio-io] me=633ef4a7 tx=1180B rx=94700B short(tx/rx)=0/9470
[sio-rtt] avg=95ms / 16ms / 43ms / 68ms  via=tunnel
Link reader desync magic=06000000 head=00000006 shift=-1   ×65 → 读线程退出
```

三件事：

1. **PC 发的是 20 字节 MBL1 包（`txShort=0`），对端发的是 10 字节 GBoy 控制帧**
   （`rxShort=9470`，9470×10=94700 字节全对上）。也就是两端在**同一根隧道上跑了两套帧格式**。
2. **PC 的读线程会被这些控制帧耗死**：`link_net.c` 里 resync 超过 64 次就 `break`。
   已修为真正的字节流重同步（保留窗口末 3 字节跨窗续接、永不退出），修复后变成
   `stray windows=5000` 持续扫描、不再退出。
3. **PC 侧几乎没有 SIO 流量**（5 分钟只发 1180 字节），说明 PC 的游戏始终没真正进入联机会话，
   而安卓侧在持续刷帧 —— 两端在**游戏状态层面**就是错开的。

### 帧率为什么必须分开谈

gen8 每帧要跑 **9 轮 MULTI**，每轮的字互为函数（第 k+1 轮要等第 k 轮数据到手）。

- 严格锁步：每帧 ≥ 9×RTT。RTT 200ms ⇒ **0.5 fps**；RTT 60ms ⇒ **1.8 fps**。
- 代码里的 `sioFastFrame`（复用上一轮对端字）**只在 LINKUP 完成、cnt≥2 之后**才放开，
  之后能回到 ~60fps。

所以「走服务器 + 全程和单机一样 60fps」在真锁步下不成立，只有**进战斗之后**才能 60fps。
要全程 60fps，只能改成「每帧一格的前瞻缓冲 / 网络只传按键」——也就是 GBoy 的
`TYPE_KEYS` 模型：两端各跑完整本地核，网络只送按键掩码（type 3/7）和状态（type 6）。

---

## 5. PC 端对齐清单（按收益排序）

1. **PC 走 KCP 中继而不是 WS 隧道**：`CloudLink::connectRelay()` 已有 `KcpChannel`，
   但实测日志里没有 `host: node …` 行，说明拿节点那步没成功，直接落到 WS 隧道。
   先在 `hostCreateRoom()` 的第二次 `create_game_room` 上确认 `node_address/node_port`
   被写进 `Room`，再确认 `startRelayLink()` 返回非空。RTT 能从 200ms 降到 60–80ms。
2. **统一 2P 载荷封装**：PC 侧 `WsLink::send()` 直接切 20 字节裸包；安卓侧是
   `TYPE_STATE(6)` 包 20 字节裸包。走中继时必须按 GBoy 帧封装/拆封，
   否则对端 `relayReader` 会把整段当噪声丢掉。
3. **过滤控制帧**：`type != 6` 的帧不要写进本地 SIO socket（安卓侧已有这个判断，
   PC 侧缺）。这是 `magic=06000000` 错位的直接来源。
4. **（可选，换 60fps）** 把 PC 的 2P 路径改成 `TYPE_KEYS` 前瞻模型：本地跑全速，
   每帧只发/收按键掩码，用 `TYPE_STATE` 做周期性存档校验兜底。

---

## 6. 复现用的脚本

| 脚本 | 作用 |
|---|---|
| `.workbuddy/drive/launch_pc.py` | 常驻托管 PC（父进程活着，避免作业对象回收子进程） |
| `.workbuddy/drive/launch_and.py` | `prep` 推存档 / `boot` 起 app 加载 ROM / `join <房号>` |
| `.workbuddy/drive/duel.py` | 两端状态观测 + 定向按键 |
| `.workbuddy/drive/drive_menu.py` | 按 PC 内存状态机把菜单推到 LINKUP |

关键环境变量：`MGBAX_NO_DIRECT=1`（禁 P2P，只走服务器）、`MGBAX_SIO_PIPELINE=1`
（按帧流水线，一帧一次往返）、`MGBAX_LINK_DIAG=1`（`[diag]`/`[room]` 打点）。

---

## 7. 本地代码实现全图（2026-11-11 接手分析）

> 上一节拆的是**官方 APK**；本节落到**本仓库实际存在的代码**上。依据：只读勘查
> PC/Qt、Android、iOS 三端 + `src/platform/mobile/{link_net.c,mgba_mobile.c}`
> + `.workbuddy/gboy/PROTOCOL.md`（624 行）。行号对应本次勘查时的版本。

### 7.1 代码地图（按层）

| 层 | PC / Qt | Android | iOS |
|---|---|---|---|
| UI 入口 | `LobbyView.cpp:217`（云房间）、`LinkView.cpp:29`（LAN） | `EmulatorActivity.java:181-235`（广播入口） | `EmulatorViewController.swift:5669,5702` |
| 编排 | `CloudLink.cpp`（2303 行，三级通道择优/降级） | `GBoyCloudLink.java`（2341 行，同构） | `LobbyLink.swift`（980 行，KCP only） |
| 信令 | `GbCloud.cpp/h`（HTTPS + WSS） | 同上（Java 内） | `LobbySignaling.swift`、`tools/gboy_room.py` |
| 传输 | `KcpChannel.cpp`、`DirectLink.cpp`、`WsLink`（`CloudLink.cpp:327-589`） | `KcpChannel.java`、`GBoyDirectLink.java`、`WsLink`（`GBoyCloudLink.java:1425-1706`） | `LobbyKcp.swift`；**无 WsLink** |
| 帧协议 | `GBoyFrames.cpp/h`、`GBoyLink.cpp`（另一套 LAN 协议） | `GBoyFrames.java`、`GBoyLinkSession.java` | `LobbyFrames.swift`、`GBoyLink.swift`（LAN 版） |
| 会话/按键 | `GBoyLinkSession.cpp`、`GBoyMirror.cpp` | `GBoyLinkSession.java`、`GBoyConsoleSet.java` | `EmulatorViewController.swift` 直接 `publishKeys` |
| native SIO | `sio_link.c` | `mgba_mobile.c` + `link_net.c`（JNI 桥 `jni_bridge.cpp:290-334` 仅转发） | `RemoteLink.swift`（Wi-Fi 中继，非 SIO 桥） |
| 回归 | `src/platform/qt/test/gboylink_test.cpp`、`mobile_test.c` | `GBoyLinkSessionTest.java`、`GBoySocketLinkTest.java` | 无 |

`jni_bridge.cpp` 里没有任何 GBoy/帧层代码，`nativeLinkHostPlayers` (`:300`) 只是
转到 `mgbaMobileLinkHost`。**云联机全在 Java 层**，这一点与官方 APK 拆解结论一致。

### 7.2 三条对战路径与唯一分叉点

分叉就在 `EmulatorActivity.java:221-229` 的 `ncore` 布尔：

| 路径 | 触发 | 数据在网络上跑什么 | 现状 |
|---|---|---|---|
| A 单核跨设备 SIO | 默认 / `officialMode=false` | 20 字节 `struct Packet` 逐轮透传 | 2P 直连 60fps ✅；云端隧道 0.7~1.5fps ❌ |
| B 本机 N 核 + 按键 | `ncore=true` 或 `MGBAX_OFFICIAL_LINK=1` | 只有 12Hz 按键掩码 | 本机 2P 60fps ✅；**3/4 人已改走进程内总线（§9），游戏侧 LINKUP 仍未达成** |
| C 3/4 人单核跨设备总线 | `players>2 && !ncore` | 28 字节 `BusPacket` 逐轮汇聚广播（TCP 星型） | 链路层 ✅，`busgame` 游戏侧 LINKUP `cnt=0` ❌ |

路径 A 调用链：`LobbyView::startRoom` → `CloudLink::runLobby`（`create_game_room`
**两次**，第二次才带 `node_address/node_port`）→ `connectRelay` 择优
`KCP 中继 → WS 隧道 → P2P 直连`（`CloudLink.cpp:857-872, 1326-1331`，断线自动回落
`:1439-1448, 1599-1605`）→ `attachDriverLoopback`（本机 `127.0.0.1:18765+t`
挂 native 驱动，`:1353-1404`）→ `startSioRelayBridge` / `startSioBridge` →
`core` 每帧 `sioLinkPump` → 游戏写 `SIOCNT` → `beginMultiTransfer`
(`sio_link.c:1132`) → `netLinkPush` → `sioDoneEvent` 取对端字 → `finishMultiTransfer`。

路径 B（`GBoyConsoleSet.java`）：可见核 slot 1 + `players-1` 个镜像核占 slot 2..N，
**一核一线程**（`:190-196`，单线程交替 `runFrame` 会死锁），`beginFrame/endFrame`
帧栅栏（`:201-240`），镜像线程 `keysForSlot(index+2)` 取按键（`:363`）。网络侧
`GBoyLinkSession.onLocalFrame` 每 5 帧（12Hz）广播一次 `TYPE_KEYS`
(`GBoyLinkSession.java:102-127`)，超 `BACKLOG_LIMIT=2` 丢最旧。

**路径 B 的 3/4 人核间链路已于 2026-11-11 改为进程内总线**（详见 §9）：
`GBoyConsoleSet.start()` 在 `players>2` 时走 `linkHostLocal(key, players)` /
`linkJoinLocal(key)` → `jni_bridge.cpp` 新增的两个 JNI 入口 →
`mgbaMobileLinkHostLocal/JoinLocal` → `netLinkBusHostLocal/JoinLocal`。
不再开 socket、不起 IO 线程，会合靠共享内存 + cond 广播。
**`startBusLink()`（路径 C，单核跨设备 3/4 人）仍走 127.0.0.1 TCP 星型总线**，
与 `busgame` 的 TCP 模式是同一份实现；两人直连路径一字未动。

### 7.3 帧协议：三处易混淆点

1. **wire 布局三端一致**：`[u32 BE length][u16 BE type][payload]`，
   `length = 2 + payload.length`（`GBoyFrames.cpp:28-35`、
   `GBoyFrames.java:84-90`、`LobbyFrames.swift:56-82`）；`Reader` 增量拆包，
   上限 16 MiB。旧上限 65535 会把 ~790 KiB 的存档帧判非法并丢弃整段流，
   造成后续按键从错误偏移解析（幻影输入），已有大帧回归测试。
2. **同一个客户端里并存两套语义不同的协议**：`GBoyLink.cpp:36-41`（WiFi 局域网，
   1=HELLO / 4=KEYS / 6=STATE）与 `GBoyFrames.h:38-50`（云房间，
   0=KEYS / 2=INPUT_2 / 3=READY / 4=INPUT_4 / 6=STATE / 7..10）线格式相同但
   type 编号含义不同，分别服务 `LinkView` / `LobbyView`，不共用一条流。
   `GBoyLink.cpp:417` 里的 `6` 是 HELLO 版本号，不是 `TYPE_STATE`。
3. **type 6 有三种含义**：① 存档 = `int len + blob`；② SIO 桥 = **裸 20 字节
   netLink 包、无长度头**（`CloudLink.cpp:1571`、`GBoyCloudLink.java:1297`）；
   ③ iOS LAN 的 `msgState=6` 是 zlib 压缩的 GBASTATE v4。
   `stateOf()` 用 `length > payload.size()-4` 拒绝裸包（`GBoyFrames.cpp:54-66`）。
   官方中继对 type 1..6 透明转发，所以桥「借壳」type 6 而没另开类型。

历史缺陷已修、证据完整：`startSioRelayBridge` 出向曾把裸 `MBL1` 包直接发进 KCP，
对端 `Reader` 把头 4 字节当 length（≈826 MB）而丢弃整条流 —— 提交
`3fa798899` 改为 `frame(TYPE_STATE, packet)`（`CloudLink.cpp:1567-1572`）；
入向配套过滤 `typeOf(body) != TYPE_STATE → continue`（`:1580-1582`）。
注意 **WS 隧道路径仍发裸 20 字节是设计如此**：两端都不经过 `Reader`，
`WsLink` 只做 20 字节切片 + hex/base64 信封，是透明字节管道。

WS 信封还有一处「代码领先文档」：`PROTOCOL.md §12.2` 记的是
`{"gboy_ws":"f","room":...,"from":...,"d":base64}`，而当前代码已因服务器
**关键词过滤 + 100 字符上限**改成短键名 hex `{"w":"f","r":...,"o":...,"d":...}`
（`CloudLink.cpp:358-378`、`GBoyCloudLink.java:1516-1531`），靠 hello/accept
里的 `"c":1` 能力协商与老版本互通。分析以代码为准。

### 7.4 锁步：性能边界与两个独立缺陷

gen8 每帧要跑 **9 轮 MULTI**，每轮的字互为函数（第 k+1 轮要等第 k 轮数据到手），
因此严格锁步下**每轮至少 1 个 RTT**，跨公网必然 0.7~1.5fps。代码层面对应：

- `sioFastFrame`（`sio_link.c:936-984`）：仅在 `netLinkState==2`、`sioOk>=256`、
  `gLink.state>=2` 且 `fieldLinkPlayerCount>=2` 后锁存「复用上一轮对端字」零等待，
  LINKUP 之后才能回到 ~60fps。**安卓 `mgba_mobile.c` 没有等价实现**，这是 PC/安卓
  可对比的行为差异。
- `sioPeerWaitMs`（`sio_link.c:804-861` / `mgba_mobile.c:2648-2700` 同构）：
  总线模式为 `RTT×3` clamp `[2,120]` ms；对端没动静时返回 0 立刻空槽收尾，
  防止整帧假死。
- 帧率必须按 115200 baud（5755 cycles）调度，否则一帧只有 3.7 次 SIO 中断，
  游戏直接报通信错误（`sio_link.c:1300-1307`）。

**3/4 人游戏侧 LINKUP 至今 `cnt=0`，已定量定位为两个独立缺陷，只修一个不够**：

| 缺陷 | 实测证据 | 性质 |
|---|---|---|
| `full=0` 空槽 | `netLinkBusDiag` 461 轮里 220 轮空槽、495 次从机 PUSH 全部落后（`lead=[-32,0]`）；主机严格 `p->index == index`，从机 `max(自身, busHostIndex)` 不收敛 | 轮次索引对齐（架构级节奏） |
| 5.6fps | `BUSGAME_BARRIER=1` 且 `barrier=1` 时三核帧号 `242/242/242`、`full=1`，但 c0 `run=592ms`（2.3ms/帧）、c1/c2 `run≈49.5s`（**195ms/帧**），瓶颈在从机 `runFrame` 内部逐轮跨线程会合吃满 2ms 地板 | TCP 总线 + 帧锁步的物理冲突 |

四种栅栏顺序实测：**零等待 → 73fps 但 `full=0` 全空槽；有等待 → 有字但 5.6fps**。
`full=1` 与 60fps 不可兼得，这是 **TCP 星型总线**路线的终点。轮次对齐
**不要放宽 `==index` 配对**（会把 32 轮前的陈旧字喂进握手块校验）。

**进程内总线已把这两个独立缺陷同时解决（2026-11-11 实测，见 §9）**：主机是唯一
时钟源，从机永远采用主机轮次号；会合用一次性绝对 deadline 的 `cond_timedwait`，
广播到达即 µs 级返回。C 侧回归 4 人 120 轮墙钟 **16ms**、`busRoundLocal` 内部
累计 37ms（四核累加，约 78µs/轮/核），
`diag=120/120/0/0/0/0/0`（轮数/收齐/空槽/落后/超前/最小偏差/最大偏差）。
Qt `busgame` 本地总线模式 6000 帧 `wait=0ms`、`lead=[0,0]`、`empty=0`、
`full=111/115`，与 TCP 模式的历史 `lead=[-32,0]`、5.6fps 形成对照。

### 7.5 三端对齐矩阵

| 能力 | PC / Qt | Android | iOS |
|---|---|---|---|
| `TYPE_STATE` 收发 | ✅ `CloudLink.cpp:1571,1580,1970` | ✅ `GBoyCloudLink.java:1297,1315` | ✅ `LobbyLink.swift:632,662` |
| SIO 分开控制桥（§13） | ✅ `CloudLink.cpp:1353-1404` | ✅ `GBoyCloudLink.java:1121-1178` | ❌ 未找到（仍是按键合并） |
| WS 隧道 fallback | ✅ `WsLink` `:327-589` | ✅ `WsLink` `:1425-1706` | ❌ 未找到（KCP 死等 5 分钟） |
| `self` + nonce 双重回显过滤 | ✅ `CloudLink.cpp:2079-2080` | ⚠️ 仅 nonce（`:2077-2079`） | ❌ 未找到 |
| `query_room` | ❌ | ❌ | ❌ |
| 3/4 人按键槽位发送侧 | — | ✅ 按 `localSlot` 发 `TYPE_KEYS/INPUT_2/READY(带 int)/INPUT_4`（见 §10），两人路径不变 | — |
| 本机 N 核 / 星型总线 | ✅ `GBoyMirror` | ✅ `GBoyConsoleSet` + `netLinkBusHost` | ❌ |

`query_room` 在 `PROTOCOL.md §2.4` 被列为已知动作，但三端生产代码全无调用
（只在 `tools/probe_node.py:158` 的探测候选里）——**文档列出的动作 ≠ 客户端已实现**。
三端改用房主每 2s 广播 `gboy_node` 或手动 `NODE2:` 传节点地址。

### 7.6 接手基线（已验证 / 未验证，勿凭印象推翻）

- **已绿（2026-11-11 本轮重跑）**：`--bus`（含新增进程内总线用例）通过；
  `--link` 155 ok / 0 FAIL / EXIT=0；`--dual` 16 ok / 0 FAIL；完整 C 套件
  242 ok / 0 FAIL / EXIT=0。Java 编译与 Android NDK 原生构建均 `BUILD SUCCESSFUL`。
  此前「完整套件段错误 139」已定位修复（`nativeHoldGenerate` budget 未钳到
  scratch 容量导致堆溢出；`netLinkClose` 未 join `pingThread` 导致 UAF）。
- **已实测可用**：P2P 直连两端各 1 核 → LINKUP `cnt=2`、训练家卡片块交换 `ts=0x80`、
  走位到座位、进 `BattleMainCB2`、60fps；本机双核心 → 同样到 `ts=0x80`、60fps。
- **LINKUP 判据**：用 `ts`（0x80 进房 / 0x82 就绪）与 `gLink.playerCount`，
  **不要用 `brs`**（卡片拷完会被 `ResetBlockReceivedFlags()` 清零）。
- **未达成**：3/4 人游戏侧 LINKUP。`busgame` 本地总线模式已跑满 6000 帧且轮次
  完全对齐，但 ROM 仍停在 BIOS/标题（`cb2=0`、`cnt=0`），卡点在菜单脚本与存档
  状态，不是 SIO 总线；`busgame` 是诊断入口，不进默认套件。
- **环境前提**：构建前 `export PATH="/c/msys64/mingw64/bin:$PATH"`；起测前
  `taskkill /F /IM mGBA.exe`（残留进程锁住 `rom.sav`）；ROM 必须复制进工作区
  （工作区外 `D:/gen8` 的 `VFileOpen` 返回 NULL）；`gboy_tcp_relay.py` 连上后
  必须 `settimeout(None)`，否则 3 秒空闲超时会掐断总线。

---

## 8. 下一步（按优先级，2026-11-11 重排）

1. **游戏侧 LINKUP（当前唯一未解决项）**：用 2P 已验证的干净存档
   （`D:/gen8/rom.sav.bak-before-link`，已复制到 `tmp_bus/`）后，2P 直连对照
   `cnt=2` 成功、3 人本地总线 `cnt=0`；链路侧已做到 `lead=[0,0]`、
   `stalePush=0`、`empty` 接近 0，但三核 SIOMULTI 仍从 **f=1191** 起分叉。
   卡点是**三核 SIO 中断在同一模拟帧内的收尾时刻不一致**，属帧内节奏，
   不是轮次聚合、帧栅栏或超时参数：`BUSGAME_BARRIER=1` 实测反而把 `full`
   从 118/122 拉到 157/346、`empty` 涨到 165。可行方向是让三核在每一轮 SIO
   上同时收尾，或由主机统一广播收尾后的 SIOMULTI 四槽快照，其余核不再自行写
   SIOMULTI。三次机制性尝试（空槽广播修复保留、从机等待开轮按实测回退、
   帧栅栏否决）后按纪律停止调参。
2. **N 设备按键槽位路由（已完成，见 §10）**：三端会话层按 `localSlot`
   发 `TYPE_KEYS/INPUT_2/READY(带 int)/INPUT_4`，共享 C 层的本地总线支持指定
   槽位 join（`netLinkBusJoinLocalSlot` + `slotTaken[]`，host 恒占链路槽位 0），
   `GBoyConsoleSet` 让可见核占 `localSlot-1` 的链路槽位、镜像核按 `mirrorSlotFor`
   读按键。三端（Android/PC-Qt/iOS）都有槽位映射与帧类型的回归断言。
   **剩余的是真机验证**：本机只能跑 C/Qt/JVM/Swift 语法与构建回归，
   N 台设备同时开玩仍需上机确认（§10.3）。
3. **iOS 对齐**：补 `WsLink` 隧道 fallback、SIO 分开控制桥、`self`+nonce 过滤；
   改动需 macOS + Xcode 做类型检查（本机只能 `swiftc -parse`）。
4. **WSS 房间信令逐行对齐官方混淆类**：需账号 + 真机抓包；`query_room`、
   `create_game_room` 调用次数（脚本 2 次 / iOS 3 次）三端尚未统一。
5. **路径 C 的跨设备 3/4 人**：仍受 TCP 星型总线每轮 1.5 RTT 限制。若要公网可玩，
   需改成每台设备各跑 N 核、网络只传按键（路径 B 的多设备版），并先完成第 2 项。

回归入口：`mgba_mobile_test --bus` / `--link` / `--dual`、完整 C 套件；
`test-gboylink busgame`（诊断，默认关，`BUSGAME_LOCAL_BUS=1` 切本地总线）；
Java `gradlew :app:compileDebugJavaWithJavac`、
NDK `gradlew :app:externalNativeBuildDebug`；驱动脚本 `.workbuddy/drive/walk_battle.py`。

---

## 9. 本轮工程改动与验证（2026-11-11）

### 9.1 改动清单

| 文件 | 改动 |
|---|---|
| `src/platform/mobile/link_net.c` | ① `struct LocalBus` 加 `inited`，`localBusCreate` 改为逐字段重置数据，不再 memset 后对已初始化的 mutex/cond 重复 init；② `busRoundLocal` 统计改为「每轮一次」，修掉把 2ms 轮询迭代记成空槽轮次；③ 会合改为一次性绝对 deadline 的 `cond_timedwait`，消除 2ms 分片在 Windows 上的定时器粒度；④ `netLinkBusDiag` 本地分支返回与头文件、`busgame` 打印一致的 7 项契约；⑤ 新增 `netLinkBusDiagTiming`（内部累计墙钟 / 从机调用次数）；⑥ 新增 `roundAborted`：主机会合没收齐时不再广播空槽，按契约返回 -1 并通知从机立即放弃本轮（`empty` 清零、`lead` 从 `[-15,0]` 改善到 `[0,0]`） |
| `src/platform/mobile/link_net.h` | 声明 `netLinkBusDiagTiming` |
| `src/platform/mobile/mgba_mobile.h/.c` | 新增 `mgbaMobileLinkHostLocal/JoinLocal`，转发到已有的 `netLinkBusHostLocal/JoinLocal` |
| `android/app/src/main/cpp/jni_bridge.cpp` | 新增 `nativeLinkHostLocal` / `nativeLinkJoinLocal` 两个 JNI 入口 |
| `android/app/src/main/java/io/mgba/android/MgbaCore.java` | 新增两个 native 声明与 `linkHostLocal(key, players)` / `linkJoinLocal(key)` 包装 |
| `android/app/src/main/java/io/mgba/android/GBoyConsoleSet.java` | `players>2` 由 TCP 星型总线改走进程内总线（`basePort` 作 key）；两人直连路径一字未动；类注释同步 |
| `src/platform/mobile/mobile_test.c` | 新增 `testBusLocal`：4/3/4 人三个 case 各 120 轮，验证轮次由主机唯一决定、四槽逐字一致、`full/empty/stale/future/lead`、槽位复用、未知 key 拒绝、无每轮 2ms 地板；挂到 `--bus` / `--link` |

### 9.2 验证结果

| 检查 | 结果 |
|---|---|
| 桌面 C 增量构建 | 通过（仅 4 条既有 warning） |
| `mgba_mobile_test --bus` | 全绿；4 人 120 轮 elapsed=16ms、inside=37,469µs、`diag=120/120/0/0/0/0/0` |
| `--link` / `--dual` / 完整套件 | 155 ok / 16 ok / 242 ok，均 0 FAIL、EXIT=0 |
| Java 编译 / Android NDK 原生构建 | 均 `BUILD SUCCESSFUL` |
| Qt `test-gboylink` 重建 | 通过 |
| `busgame` 本地总线（3 人） | 多轮诊断：`battle_pc/rom.sav` + `attachAt=0` → 卡 BIOS；换 `arena_save.sav` → 前 2048 帧 SIO 零分叉但 `rounds=0`；改用 2P 已验证的干净存档（`tmp_bus/rom.sav`）→ `cb2=0815329F`、ROM 正常启动、`rounds=122 full=118`；**2P 直连同存档对照 `cnt=2` 成功**。空槽广播修复后 `lead=[0,0]`、`stalePush=0`、`rounds=120 full=114`。**LINKUP 仍未达成**（`cnt=0`），f=1191 起 SIOMULTI 分叉 |

### 9.3 已知限制

- 3/4 人游戏侧 LINKUP 未达成。卡点已缩小到**三核 SIO 中断在同一模拟帧内的
  收尾时刻不一致**：用 2P 干净存档后 ROM 正常启动（`cb2=0815329F`）、2P 对照
  `cnt=2` 成功，链路侧 `lead=[0,0]` / `stalePush=0` / `empty≈0` 也已对齐，
  但 f=1191 起 c0/c1/c2 的 `SIOMULTI0..3` 仍分叉（例：c1 还停在 `494E`）。
  **帧栅栏不是解药**：`BUSGAME_BARRIER=1` 让三核帧号完全一致，却把 `full`
  从 118/122 拉到 157/346、`empty` 涨到 165、`wait=23s`。
  三次机制性尝试后按纪律停止调链路参数（空槽广播修复保留；「从机等待主机
  开轮」实测 `stalePush` 1→39、`lead` [-1,0]→[-17,0]，已回退）。
- 进程内总线只覆盖**同一进程**的 N 核（Android ncore 与 Qt busgame）。
  跨设备 3/4 人（路径 C）仍是 TCP 星型总线，未改动。
- 未做真机验证；本轮验证均为本机 C/Java/NDK 构建与 Qt 诊断程序。

---

## 10. 3/4 人按键槽位路由（三端同步，2026-11-11）

> 目标：让 `localSlot > 1` 的设备在 SIO 层也占正确槽位，而不再被游戏认成玩家 1。
> 关键不变量：**host 恒占链路槽位 0**（恰是游戏认定的 1P），所以 `sio_link.c` /
> `mgba_mobile.c` 里「`player != 0` 才起轮」的判据仍然成立，**两端 SIO 驱动无需改动**。

### 10.1 改动清单

| 层 | 文件 | 改动 |
|---|---|---|
| native | `src/platform/mobile/link_net.c` / `.h` | `struct LocalBus` 加 `slotTaken[BUS_MAX_PLAYERS]`（`slot 0` 恒归 host）；新增 `netLinkBusJoinLocalSlot(link, key, slot)`，校验 `1≤slot<players` 且未被占用，占用后写入 `slotTaken`；`netLinkBusJoinLocal` 改为按接入顺序求第一个空槽（旧行为）。`localBusCreate` 用 `inited` 标记 + 逐字段重置，避免对已初始化的 mutex/cond 重复 init |
| native | `src/platform/mobile/mgba_mobile.c` / `.h` | 新增 `mgbaMobileLinkJoinLocalSlot(emu, key, slot)` 转发到 `netLinkBusJoinLocalSlot` |
| JNI | `android/.../jni_bridge.cpp` / `MgbaCore.java` | 新增 `nativeLinkJoinLocalSlot` 与 `linkJoinLocal(key, slot)` 重载（旧 `linkJoinLocal(key)` 保留） |
| Android | `android/.../GBoyConsoleSet.java` | 构造器加 `localSlot` 字段（1..players）；`localSlot>1` 时可见核占链路槽位 `localSlot-1`（`primary.linkJoinLocal(busKey, localSlot-1)`），`localSlot==1` 时仍作 host；镜像核按 `mirrorSlotFor(localSlot, players, index)` 读按键；新增 `mirrorSlotFor` 静态转发 |
| Android | `android/.../GBoyLinkSession.java` | `playerCount>2` 时 `onLocalFrame` 按 `localSlot` 发带槽位帧：1→`TYPE_KEYS`、2→`TYPE_INPUT_2`、3→带 int 的 `TYPE_READY`、4→`TYPE_INPUT_4`；无参 `onFrameBody`/`onWireFrame` 的默认 `senderSlot` 在 3/4 人时固定 1；新增 `localSlot()`/`playerCount()`/`mirrorSlotFor`/`keysForSlot`；**两人路径一字不动** |
| Android | `android/.../EmulatorActivity.java` | 新增 9 参 `startGBoyLocalLink(..., localSlot)`，从 `GBOY_LOCAL_LINK` 广播读 `--ei slot`；8 参重载默认 slot 1；日志带 slot |
| PC/Qt | `src/platform/qt/sio_link.c` / `.h` | 新增 `sioLinkJoinPlayersLocalSlot(sio, key, slot)` 转发到 `netLinkBusJoinLocalSlot`（旧 `sioLinkJoinPlayersLocal` 保留） |
| PC/Qt | `src/platform/qt/GBoyLinkSession.cpp` / `.h` | 与 Android 同源移植：`localSlot`/`playerCount` 构造参数，`pushKeys` 按 `localSlot` 选帧类型，`keysForSlot` 按帧 type 反解槽位，`mirrorSlotFor` 静态方法；**两人路径不变** |
| iOS | `ios/mGBA/LobbyLink.swift` | `keyFrameType()` 按 `localSlot` 选 `typeKeys/typeInput2/typeReady/typeInput4`；`handle` 对 `typeInput2/typeReady/typeInput4` 按 type 反解目标槽位（`typeReady` 带 int 荷载） |
| 测试 | `src/platform/mobile/mobile_test.c` | 新增 `testBusLocalSlots`：乱序指定槽位（2→1→3）、冲突拒绝（同一槽位二次 join 失败）、未知 key 拒绝、槽位 0/超界拒绝、退出后槽位释放复用；挂 `--bus`/`--link` |
| 测试 | `src/platform/qt/test/gboylink_test.cpp` | 新增 `busLocalSlotTest`（指定槽位本地总线建链）+ `sessionSlotTest`（PC 会话层四槽帧类型与 `mirrorSlotFor` 映射），分发到 `buslocal` 模式 |
| 测试 | `android/.../GBoyLinkSessionTest.java` | 新增三个用例：四槽发送帧类型、四设备会话级槽位路由（含 slot 3 带 int 的 READY 不触发握手）、两人路径回归 |
| 测试 | `android/.../GBoySocketLinkTest.java` | 新增 `slotTypedKeysOverLoopback`：4 人会话下 slot 1 / slot 2 两台设备经真实 loopback TCP 交换带槽位键位帧，验证落到对端正确槽位 |

### 10.2 验证

| 检查 | 结果 |
|---|---|
| C 回归 `mgba_mobile_test --bus` | 含 `testBusLocalSlots`，164 ok / 0 FAIL、EXIT=0 |
| C 回归 `--link` / `--dual` / 完整套件 | 155 ok / 16 ok / 242 ok，均 0 FAIL、EXIT=0 |
| Qt `test-gboylink buslocal` | `BUSLOCAL TEST: PASS` + `SESSIONSLOT TEST: PASS`（含指定槽位建链与 PC 会话层路由），EXIT=0 |
| JVM `javac -encoding UTF-8` + `GBoyLinkSessionTest` | `GBoyLinkSessionTest ok`，EXIT=0 |
| JVM `javac -encoding UTF-8` + `GBoySocketLinkTest`（含 socket 用例） | `GBoySocketLinkTest ok`，EXIT=0 |
| `gradlew :app:compileDebugJavaWithJavac` / `:app:externalNativeBuildDebug` | 均 BUILD SUCCESSFUL |
| `swiftc -parse` on `LobbyLink.swift` / `LobbyFrames.swift` | 语法 OK（本机无 Xcode，仅解析级检查） |
| `gradlew :app:testDebugUnitTest --offline` | **既有配置问题**：项目单测是 plain JVM `main`、无 JUnit 依赖，任务报 `did not discover any tests`；等价验证以上述 javac 直跑为准 |

### 10.3 已知限制

- **未做真机多设备验证**：本机只能跑 C/Qt/JVM/Swift 语法与构建回归，N 台设备
  同时开玩（每台 `localSlot` 不同）仍需上机确认。`mirrorSlotFor` 的布局规则
  已在三端共享同一份纯函数逻辑并各有单测，但仍缺真机多核同时推进联机菜单的
  端到端证据。
- `GBoyCloudLink.newSession` 固定 `playerCount=2`，云端 officialMode 仍是两人
  会话，不受本次改动影响。
- iOS 改动仅做了 `swiftc -parse` 级语法检查；类型检查与真机跑通需 macOS + Xcode。
- 3/4 人游戏侧 LINKUP（`cnt=0`）仍是 §8 第 1 项记录的架构级卡点（三核 SIO 中断
  帧内收尾不同步），与本次槽位路由无关；槽位路由是「链路层身份正确」的前提，
  但游戏侧起轮本身尚未打通。

