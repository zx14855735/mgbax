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
