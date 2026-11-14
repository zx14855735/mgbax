# GBoy 联机栈逐方法清点 + 三端对照审计（2026-11-14 起草，2026-11-15 01:1x 按三端最终代码复核）

> 对象：官方客户端 `GBoy_261018.Apk`（dpt-shell，已静态脱壳）。
> 官方源码：`tmp_gboy_apk/decompiled_all/sources/`（jadx 1.5.1，`decoded/classes*.dex`）。
> 辅助反汇编：`.workbuddy/gboy/dd/p1.txt`（classes.dex）、`p2.txt`、`p3.txt`（dexdump 全量）。
> 端上实现：`src/platform/qt/`、`android/app/src/main/java/io/mgba/android/`、`ios/mGBA/`。
>
> **本文不改动任何源码，只产出这一份 Markdown。**
>
> 方法名/类名是混淆名（`A2egSU`、`ADYaiT` 之类在**不同包里是同名不同类**，引用时一律带包名）。
> 所有 `KpHwm4/AYUAbz` 这类写法都指 `包名/类名`；行号以 `decompiled_all/sources/` 下文件为准。

---

# 0. 本次清点推翻的三个既有结论（先看这个）

`NETPLAY_SPEC.md` 的消息表有三条是错的，而三端实现全都照抄了这三条错。逐字节复核如下。

### 0.1 `type 0` 不是帧率，是**按键掩码**

`NETPLAY_SPEC.md §2` 写「type 0 = int32 v → 帧率上限」。实际发送点是
`KpHwm4/AaHO0E` 的模拟线程（`ADYaiT/D8MqeW.run`，字节码 `p1.txt:34821a` 与 `p1.txt:348364`）：

```
|01e5: invoke-static {v11, v0}, LKpHwm4/B25kr6;.ARc23Z:(SI)Ljava/nio/ByteBuffer;
|01e9: invoke-virtual {v9, v13}, Ljava/nio/ByteBuffer;.putInt:(I)Ljava/nio/ByteBuffer;
|01ed: invoke-virtual {v15, v9}, LMcNXgv/A5SV6n;.A2egSU:(Ljava/nio/ByteBuffer;)V
```

`v11` 在该方法 `0x000d` 被 `const/4 v11, #0` 置 0 后**再未写过**（`p1.txt:347e6a`，
方法内所有 `v11` 读取都是常量 0 语义），`v0 = 4`（`p1.txt:347e5c`），`v13` 是本帧算出的
按键掩码。所以线帧是 **`type 0` + `int32 keys`，每帧、每个对端各发一条**。

接收侧与之对称：`KpHwm4/AYUAbz` 的 dispatch 里 `case 0` 正是
`a5SV6n.BI9f7h.setKeys(getInt())`（`p2.txt:379f2c-379f36`，`case 0` 目标 `0x0138`）。

> 旁证：如果 `0` 真是"帧率"，官方房间模式里就**没有任何一条消息承载对端按键**，
> 4 人房不可能动——所以 `0 = 按键` 是唯一自洽的解读。`AmA8tU:213-221` /
> `AzWtSf:174-179` 把 `0` 当 `AZkASS`（倍率）处理，是客户端路径上的**遗留/中继语义**，
> 与直连路径冲突，属于官方自己的分裂（见 A.5 注）。

### 0.2 `type 9` 不是按键，是**模拟速度倍率**（0.5x / 1x / 2x / 4x，直接改帧闸）

唯一发送点 `KpHwm4/B25kr6.AZOQYO(int)`（`KpHwm4/B25kr6.java:253-258`）：
`ARc23Z((short) 9, 4).putInt(i)`。调用者不是输入层，而是**倍速菜单**：
`com/game/boy/activity/EmulatorActivity` 的菜单分支（`p2.txt:63c94e / 63c980 / 63c9aa / 63c9d4`），
分别传 `1 / -1 / 2 / 4`，对应 "1x / 0.5x / 2x / 4x"（`p2.txt:63c98a` 有字符串 `"0.5x"`、
`63c9b4` `"2x"`、`63c9de` `"4x"`）。

接收侧 `case 9` 直接写 `AaHO0E.f4302AZkASS`（速度倍率）并重算帧闸
（`p2.txt:379d5a-379dce`）：`i > 0` 时把倍率设成 `i`，`i <= 0` 时设 0.5f。

### 0.3 官方**没有**「帧率下发」消息，也没有「ready ack」

- 全 APK 的 `B25kr6.ARc23Z(short,int)` 调用点共 **16 处**（Java 层 14 处字面常量 + 字节码里 2 处
  用寄存器传 type 的 `D8MqeW.run`；`AmA8tU`/`AzWtSf` 两个方法的 dexdump 有损坏，以 Java 源码为准），
  穷举见 A.13.1。构造出的类型号只有 **0、1、2、3、5、6、9**。没有一条 fps/pacing 帧：
  `9` 的唯一调用者是倍速菜单，`0` 的调用者在模拟线程里（按键）。
- `type 5` 不是 ready-ack，是 **reset**：发送点
  `com/game/boy/activity/EmulatorActivity.BmvVmW`（`EmulatorActivity.java:1333`，
  `ARc23Z((short) 5, 4).putInt(0)`），由"重置游戏"菜单触发；接收侧 `case 5`
  做 `Link.A2egSU.reset(false)` + 遍历镜像核 `reset(false)`（`p2.txt:379e76-379ec8`）。

> **独立复核**：general-purpose-1 用 `jadx --show-bad-code` 另行反编译了 `D8MqeW.run` 与 `AYUAbz`，
> 看到的是同一组指令（`ARc23Z((short)0,4).putInt(keys)` 紧跟 `console.setKeys(keys)`；`case 0/5/9` =
> `setKeys` / 双核 `reset` / `AaHO0E.AYUAbz(speed)`），结论一致。两条独立路径互证，不再是单点判断。

> **后果（三端全中）**：我们把 `0` 当帧率、把 `9` 当按键。于是
> (a) 我们发出的每一帧按键，在官方客户端眼里都是"改倍速"，按键掩码 `0x0001/0x0002…`
> 会被当成 1x/2x 倍速；(b) 官方客户端每帧发来的 `type 0`（按键），我们当成 fps 丢掉，
> 对端永远不动；(c) 我们每秒发的 `TYPE_FPS(60)`，官方会当成"按键掩码 60"写进镜像核。
> 这不是"编号偏移一条"，是整条输入通道语义反了。

### 0.4 两种读法的调和：按「阶段」分开，不是二选一

`type 0` 在官方代码里确实出现了两种处理，容易各执一词。按调用链拆开就没有矛盾：

| 阶段 | 谁在读 | 读到 type 0 做什么 | 代码 |
|---|---|---|---|
| 握手期（msg1 之前） | `AmA8tU.A5SV6n` / `AzWtSf.A4TApA` 的读循环 | 把 int 写进 `AaHO0E.f4302AZkASS`（节奏/倍率字段），KCP 版写完就 `break` 出循环 | `AmA8tU:212-221`、`AzWtSf:169-180` |
| 稳态（msg1 之后） | `B25kr6.AYUAbz`（由模拟线程每帧对每个 peer 调用） | `peer.BI9f7h.setKeys(getInt())` | `p2.txt:379f2c` |
| 稳态发送侧 | `ADYaiT/D8MqeW.run` | 每帧/每 5 帧把本帧按键掩码打成 `type0 + int32` | `p1.txt:34821a/348364` |

也就是说：`type 0` 在**握手期是节点下发的节奏信号**，在**稳态是按键**。同一个号、两个阶段。
`type 9` 没有这种分裂——它**只有**"速度倍率"一个发送点（倍速菜单）和一个接收分支（改帧闸）。

> 判定性实验（10 分钟）：官方客户端 ↔ 我们客户端，稳态下观察。
> 若我们发 `type9=按键`，官方会按按键掩码改倍速（按「左」=0x20 → 32 倍速，画面立刻飞）；
> 若官方发 `type0=按键`，我们的 `m_remoteFps` 会变成 0/1/64 之类的掩码值（帧率在 60 与 1 之间跳）。
> 两个现象任意出现一个，就说明 0/9 的映射必须交换。

---

# A. 官方源码清点（按类，逐方法）

## A.1 `KpHwm4/B25kr6` —— 会话编排（259 行）

| 成员 | 行号 | 作用 |
|---|---|---|
| `static final UUID f4349AcNBzu` | 21 | `3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47`（蓝牙 SDP） |
| `Handler f4350A2egSU` | 24 | 指向 `ADYaiT/AZkASS`（UI 消息泵） |
| `McNXgv/A4TApA f4351A4TApA` | 27 | 当前传输线程（TCP accept / TCP client / KCP） |
| `boolean AMqCpz` | 28 | **本端是否"服务端/已在房内"**（true=接受连接方） |
| `boolean f4354ARc23Z` | 31 | **是否"房间/多对端"模式**（true=云端中继） |
| `volatile boolean f4355ASJ6gh` | 34 | 会话运行标志 |
| `CopyOnWriteArrayList f4352A5SV6n` | 43 | 每对端一条 `McNXgv.A5SV6n` 通道 |
| `CopyOnWriteArrayList f4353ADYaiT` | 46 | 每对端一个帧读取器 |
| `AtomicInteger f4357AZOQYO` | 49 | 未使用（构造后无读写） |
| `ArrayList f4358AZkASS` | 52 | 未使用（仅 `EmulatorActivity.java:1373` 清空） |

### 方法逐一

**`B25kr6(Handler, AaHO0E)` — 58-61**
保存 UI handler 与模拟循环引用。**不做任何网络动作**。

**`static int A2egSU(int playerCount, int index)` — 63-89 —— 槽位映射原文**

```java
if (playerCount == 1) return index + 1;
if (playerCount == 2) { if (index == 0) return 0; if (index == 1) return 2; }
else if (playerCount == 3) { if (index == 0) return 1; if (index == 1) return 0; }
else if (playerCount == 4) return 2 - index;
return 3;
```

映射表（`index` = 状态数组下标，返回值 = 状态/名字数组下标）：

| playerCount \ index | 0 | 1 | 2 | 3 |
|---|---|---|---|---|
| 1 | 1 | — | — | — |
| 2 | 0 | 2 | 3 (兜底) | 3 |
| 3 | 1 | 0 | 3 (兜底) | 3 |
| 4 | 2 | 1 | 0 | -1 |

**`static ByteBuffer ARc23Z(short type, int payloadLen)` — 91-96 —— 唯一帧构造器**

```java
int len = payloadLen + 2;            // len 含 type 那 2 字节
ByteBuffer b = ByteBuffer.allocate(payloadLen + 6);  // 4B len + 2B type + payload
b.putInt(len);                       // 大端
return b.putShort(type);
```
所有发送者都拿返回的 `ByteBuffer` 继续 `putInt/putShort/put` 填充 payload，
sender 线程写的是 `byteBuffer.array()` 全量（`McNXgv/A5SV6n.java:126`），
所以**没填满的 payload 字节以 0 上线**（`EmulatorActivity.java:1037` 的
`ARc23Z((short)3, 4)` 就是 4 个 0 字节的"空体 4 字节"）。

**`int A4TApA(InputStream, OutputStream)` — 116-173 —— 直连（TCP accept / 蓝牙）握手**

按顺序、**阻塞**执行，任一步类型不符直接 `return 2`（协议错）：

| 步 | 行号 | 动作 |
|---|---|---|
| 1 | 117-118 | `new BTvldC.ADYaiT(in)` 帧读器；`new McNXgv.A5SV6n(out, f4354ARc23Z)` 对端通道（并 `start()` 发送线程） |
| 2 | 119-120 | 把读器/通道登记进 `f4353ADYaiT` / `f4352A5SV6n` |
| 3 | 121-123 | **若 `!AMqCpz`（连接发起方）先发 `type1 + int 6`** |
| 4 | 124-131 | 读一帧，期望 `type 1`；若本端 `AMqCpz==true` 且 payload `int==6` → 回 `type1 + int 6`；然后 `msg 3`（UI：对端已连上） |
| 5 | 132-138 | 读一帧，期望 `type 2`：`byte[32] name` + `short n` + `byte[n] desc`；`msg 4`（UI：**建镜像 Console**，阻塞等 UI 回 `B25kr6.ADYaiT(peer)`） |
| 6 | 139-142 | 读一帧，期望 `type 3`（空体）；**若 `!AMqCpz` → `msg 5`**（UI：把本机 savestate 发过去） |
| 7 | 143-152 | 读一帧，期望 `type 6`：`int size` + `byte[size]` → `console.loadStateFromMemory()` |
| 8 | 149-152 | **返回码映射**：`-5 → 3`，其它非 0 → `1`，0 → 继续；非 0 直接 `return`（连接终止） |
| 9 | 153-155 | **若 `AMqCpz` → `msg 5`**（服务端在这一步发自己的 savestate） |
| 10 | 156-157 | `Link.A2egSU.reset(false)`（可见核）+ `peer.BI9f7h.reset(false)`（对端核） |
| 11 | 158 | `msg 1`（UI：**进入"运行中"**，解阻塞） |
| 12 | 159-167 | **转发循环**：循环 `readFrame()` → `peer.f5296BIYEnU.put(frame)`（交给 `AYUAbz` 逐帧消费） |
| 13 | 172 | 循环退出返回 `2`（正常断开也走这里） |

要点：
- **握手是双向对称**的：双方都发 `type2`，都发 `type6`，都用 `AMqCpz` 决定"我第几步发"。
- `AMqCpz` 在整个 APK 里**只在 UI 层赋 true**（`com/game/boy/activity/BI9f7h.java:18` 蓝牙服务端、
  `com/game/boy/activity/.../I3HV03.A4TApA.A2egSU` 的 Wi-Fi 服务端，
  `src` 行 `I3HV03/A4TApA.java:113`），`B25kr6.AMqCpz(...)` 里反而显式置 false（195-197）。

**`void A5SV6n(Message msg, McNXgv.A5SV6n peer)` — 175-186 —— 同步阻塞泵**
`msg.sendToTarget()` 后把 `msg.what` 写进 `peer.f5294BChYOn`，然后 `wait()` 直到 UI 线程
调 `ADYaiT(peer)` 把它清 0。**握手第 5 步（建核）与第 11 步（开局）都是靠它把网络线程挂住**，
所以 UI 处理消息的耗时直接等于握手耗时。

**`void ADYaiT(McNXgv.A5SV6n peer)` — 188-193**
`peer.f5294BChYOn = 0; notify();` —— 解除上一方法的等待。

**`void AMqCpz(InetAddress addr, int port, boolean useKcp, ArrayList states, ArrayList names)` — 195-203**
房间/中继入口：`AMqCpz = false; f4354ARc23Z = true;`
`useKcp ? new AzWtSf(...) : new AmA8tU(...)` → `ASJ6gh(thread)`。
`states` = 所有玩家的 savestate（`byte[]`），`names` = 对应 ROM 名，来自房间 JSON（见 A.12）。

**`void ASJ6gh(McNXgv.A4TApA thread)` — 205-213**
只允许一条传输线程（已有则 `IllegalStateException`）；置 `ASJ6gh=true; AYUAbz=false;` 并 `start()`。

**`void AYUAbz(McNXgv.A5SV6n peer)` — 245-251 —— 逐帧 dispatch（**关键**）**

jadx 反编译失败（"Method dump skipped"），从 `p2.txt:379ca4-379f3a` 字节码还原。
入口 `take()` 取一帧，`while (remaining >= 6)` 循环，`short type = getShort()`：

| type | 字节码目标 | 行为 |
|---|---|---|
| 0 | `0x0138` | `peer.BI9f7h.setKeys(getInt())` —— **对端的按键，落到"代表对端那颗核"** |
| 1..4 | `0x010b` | `getInt()` → 先按 (playerCount=`peer.B9tovu`, type) 算出槽位 `i2`，再 `this.A5SV6n.get(0).B2KMhB.get(i2).setKeys(keys)` |
| 5 | `0x00e1` | `getInt()`（丢弃）→ `Link.A2egSU.reset(false)` + `this.A5SV6n.get(0).B2KMhB` 全部 `reset(false)` |
| 6 | `0x00cd` | `int n` + `n` 字节 → `Link.A2egSU.loadStateFromMemory()`（**灌进本机可见核**） |
| 7 | `0x00be` | `Link.A2egSU.setKeys(getInt())`（本机可见核按键） |
| 8 | `0x00b6` | `peer.BJ7GGh = getInt()`（`BJ7GGh` 只在 `p1.txt:348252` 被读作"每帧推进次数"） |
| 9 | `0x0053` | `getInt()` → 速度倍率，写 `AaHO0E.AZkASS` 并重算帧闸（见 0.2） |
| 10 | `0x0049` | `handler.obtainMessage(2, 2, 0)` —— 断开通知 |
| 其它 | — | 忽略 |

**type 1..4 的槽位表（字节码 `0x001b-0x0045`，`peer.B9tovu` = playerCount）**

| playerCount | type1 | type2 | type3 | type4 |
|---|---|---|---|---|
| 1 | — | 0 | 1 | 2 |
| 2 | 0 | — | 1 | 2 |
| 3 | 1 | 0 | 2 | — |
| 4 | 2 | 1 | 0 | — |

> 这张表和 `A2egSU(playerCount,index)` **不是同一套**（只有 `playerCount==4` 时两者吻合），
> 且 APK 内**没有任何代码发送 type 1/2/3/4 的按键帧**（发送点全量枚举见 0.3）。
> 结论：`type 1..4 的按键` 与 `type 7/8/10` 属于**中继节点侧/遗留协议**，不是本机直连路径会出现的帧。
> 本机直连实际只会收到 `0 / 5 / 6 / 9`（以及握手阶段的 1/2/3）。
> **注意类型号是"阶段相关"的**：握手阶段 `1/2/3` 是握手，进入转发后 `1/2/3` 是"玩家 N 的按键"。

**`void AZOQYO(int value)` — 253-258**
`f4352A5SV6n.get(0).A2egSU(ARc23Z((short)9, 4).putInt(value))`；`IOException` 静默吞掉。
只发给 **channel[0]**（房主/中继），不是广播。

## A.2 `KpHwm4/A2egSU` —— TCP 服务端 / 蓝牙客户端（77 行）

| 构造 | 行号 | 行为 |
|---|---|---|
| `A2egSU(B25kr6, String btMac)` | 23-29 | 蓝牙**客户端**：`getRemoteDevice(mac).createRfcommSocketToServiceRecord(uuid)`；`cancelDiscovery()` |
| `A2egSU(B25kr6, B25kr6, ServerSocket)` | 72-76 | TCP **服务端**：只保存 `ServerSocket`（由 UI 层创建） |

- `A4TApA()` 56-69：
  - `case 0`（蓝牙客户端）：`Process.setThreadPriority(-19)` → `BluetoothSocket.connect()` → `session.A4TApA(in,out)`
  - `default`（TCP 服务端）：`ServerSocket.accept()` → `setSoTimeout(500)` → `setTcpNoDelay(true)` → `session.A4TApA(in,out)`
- `A2egSU()` 32-53：按 `f4270AlLFFp` 关闭 `BluetoothSocket` 或 `ServerSocket`。
- **监听参数在 UI 层**：`com/game/boy/activity/EmulatorActivity.CNPG0E()`（`:1500-1509`）
  `new ServerSocket(6374, 1, InetAddress.getByName("0.0.0.0"))` —— **固定端口 6374、backlog 1、绑 0.0.0.0**。

## A.3 `KpHwm4/A4TApA` —— 蓝牙服务端（55 行）

- 构造 21-27：`cancelDiscovery()` → `listenUsingRfcommWithServiceRecord("GBoy", uuid)`。
- `A4TApA()` 48-54：`Process.setThreadPriority(-19)` → `accept()` → **立刻关闭服务端 socket** → `session.A4TApA(in,out)`（**只接一个对端**）。

## A.4 `KpHwm4/AmA8tU` —— TCP 客户端（296 行）

**`int A4TApA()` 86-164 —— 连接 + 重连循环**

| 行号 | 内容 |
|---|---|
| 88 | 循环条件 `session.ASJ6gh && !interrupted()` |
| 90-94 | `new Socket()`；`connect(InetSocketAddress, 10000)`；`setSoTimeout(500)`；`setTcpNoDelay(true)` |
| 95-98 | **首次连接失败直接抛**：`if (!f4332B9tovu) throw e;`——`f4332B9tovu` 只在握手成功后才置真（`:228`），所以"2s×50s 重试"**只作用于掉线重连**，不作用于首连 |
| 99-118 | 重连失败分支：`f4335BIYEnU`（上次成功时刻）距今 ≥ **10000ms** 则把 50 秒窗口起点 `f4333BChYOn` 清零；窗口 ≥ **50000ms** → `ADYaiT()`(发 msg8) + 抛异常；否则 `msg7`(带剩余毫秒) + `sleep(2000)` |
| 120-123 | 若已是重连状态 → `ARc23Z(socket)`（发 10 字节握手包）后进入转发 |
| 124-126 | 否则 `A5SV6n(socket)`（首次握手） |

**`int A5SV6n(Socket)` 167-239 —— 首次握手（客户端侧）+ 读循环**

| 行号 | 内容 |
|---|---|
| 168-171 | 帧读器 + 对端通道；登记进 session 两个列表 |
| 173-178 | 发 `type1`：`int playerCount`；**仅当 `playerCount == 1`** 再 `short 0` + `int listSize`。`ARc23Z(1,10)` 分配 **16 字节**（长度字段 12 = 2 类型 + 10 payload），发送线程写整个 `array()`，所以**帧长恒 16**；pc≠1 时尾部 6 字节为 0 |
| 179-222 | 读循环：<br>`type 3` → `int rtt` 存 `peer.B9tovu`；`for i2 in 0..listSize-2`：msg4（建镜像核，阻塞）→ 从 `states[A2egSU(rtt,i2)]` 取 blob 灌进 `peer.B2KMhB.get(i2)`；任一失败 → 发 `type1` 空体 + 返回错误码（3/1）；全成功 → 发 **`type3` 空体**<br>`type 0` → `int v` → `AaHO0E.BPw6Q8=false; AZkASS=v`<br>其它 → `return 2` |
| 224-228 | 循环结束：发 `type1` 空体（"我走了"）、`msg1`、`f4332B9tovu=true`（以后掉线走 `ARc23Z(Socket)`） |
| 229-237 | 转发循环：`readFrame()` → `peer.BIYEnU.put()` |

**`void ARc23Z(Socket)` 263-295 —— 断线重连握手包**

```java
ByteBuffer b = ByteBuffer.allocate(10);
b.putInt(6);              // 长度
b.putShort((short) 100);  // 类型 100
b.putInt(lastRtt);        // 上次 RTT（-1 = 未知）
out.write(b.array()); out.flush();
```
然后换新读器、`msg8`（隐藏"重连中"）、进入转发循环。

**`ADYaiT()` 241-249 / `AMqCpz()` 251-260**：`msg8`（连接已断）/ `msg7`（重连倒计时，arg1=剩余毫秒，≤0 → 50000）。

## A.5 `KpHwm4/AzWtSf` —— KCP/UDP 客户端（188 行）

| 行号 | 内容 |
|---|---|
| 51-62 | 构造：保存 `InetAddress`、端口、states、names |
| 65-116 | `A2egSU()`（关闭）：给所有 KCP 会话发 `DISC` → `sleep(100)` → 停心跳 → 关 socket → 关三个调度器（各 `awaitTermination(500ms)`） |
| 121-187 | `A4TApA()`（主流程）：<br>`new MhxuEA.A5SV6n(new IQ76hF.AmA8tU(2, this))` 建通道管理器；<br>提交 `MOpbMP.A2egSU(...,12, InetSocketAddress)`＝KCP 连接任务；<br>等 `f4343B3GDIM`（握手完成）最多 **10000ms**，超时 `return -1`；<br>循环 1：`take()` → `type 3` → 同 AmA8tU 的 rtt + 逐槽 load（**不建核**，核由 msg4 建），失败直接 return，成功回 `type3` 空体；<br>循环 2：`take()` → `type 0` → 设 `AZkASS` 后 **break**；<br>发 `type1` 空体 → `msg1` → `f4346B9tovu.await()`（等会话结束） |

**注意**：KCP 路径里 `type 0` 只当作"帧率/速度"就 `break` 出循环了（`AzWtSf.java:174-179`），
这与 A.1 的 `case 0 = 按键` 直接冲突——说明 **KCP/中继路径与直连路径用的是两套编号语义**。
这是官方自身的遗留分裂，照抄时必须**按传输分别选语义**，不能统一成一张表。

## A.6 `McNXgv/A5SV6n` —— 每对端通道（168 行）

| 成员 | 行号 | 说明 |
|---|---|---|
| `OutputStream f5284AcNBzu` | 21 | 直连写端 |
| `ARc23Z f5285AlLFFp` | 24 | KCP 模式下的会话句柄 |
| `boolean f5286AmA8tU` | 27 | true = 走 KCP（写进 `MdiDtx.A5SV6n`），false = 直接写 socket |
| `ArrayList f5287AzWtSf` | 30 | 发送队列（`ArrayList`，自带 `wait/notify`） |
| `Console f5295BI9f7h` | 54 | **"代表对端这个玩家"的那颗核**（直连模式） |
| `LinkedBlockingQueue f5296BIYEnU` / `ArrayBlockingQueue(1)` | 57 / 75-78 | 收包队列；**KCP 模式无界、直连模式容量 1** |
| `CopyOnWriteArrayList f5289B2KMhB` | 36 | 镜像核列表（房间模式，最多 4） |
| `int f5293B9tovu` | 48 | 最近 RTT / type3 的 int |
| `int f5294BChYOn` | 51 | 阻塞握手的"当前消息号"（配合 `B25kr6.A5SV6n`） |
| `int f5297BJ7GGh` | 60 | 每帧推进次数（`AYUAbz case 8` 可改） |
| `int f5298BNL6CD` | 63 | 最近一次速度值（`case 9` 去重用） |

- 构造 65-80：置 `f5288B25kr6=true`，`f5297BJ7GGh=f5298BNL6CD=1`，队列按模式选型，**`start()` 自己**（发送线程名 = 默认 `Thread-N`，官方未命名）。
- `A2egSU(ByteBuffer)` 82-96：发送线程死亡则抛 `IOException`；入队并 `notify`。
- `run()` 99-154：`wait()` → 取出 → KCP 模式：逐会话 `ADYaiT(array)`（KCP 发送）；直连模式：`write()+flush()`；写失败从第一次起累计 **5 秒**（`PushUIConfig.dismissTime = 5000`，`com/bytedance/android/live/base/api/push/model/PushUIConfig.java:5`）后 `close()`。

## A.7 `BTvldC/ADYaiT` —— 帧读取器（173 行；本类被混淆合并了多个同名类，构造函数 157-161 才是网络版）

| 行号 | 内容 |
|---|---|
| 157-161 | `(InputStream)`：`byte[4]` 头缓冲、超时计数 `f1447AcNBzu=0` |
| 79-101 | `A5SV6n(byte[])` 读满：`SocketTimeoutException` → 计数 +1，**≥8** → 计数归零并抛 `SocketTimeoutException("连续 8 次静默超时，判定对端不可达")`；`read < 0` → `EOFException("对端已关闭连接 (EOF)")`；读到数据则计数归零 |
| 103-113 | `ADYaiT()`：读 4 字节大端长度；`i < 0 || i > 8388608` → `IOException("非法消息长度…")`；再读 `i` 字节，`ByteBuffer.wrap` 返回 |

**常量：帧长上限 8 MiB（8388608），静默判定 = 500ms × 8 = 4s。**

## A.8 `KpHwm4/AaHO0E` + `KpHwm4/A5SV6n` —— 模拟循环与帧闸

**`AaHO0E`（232 行）**

| 行号 | 内容 |
|---|---|
| 95-100 | 构造：起线程跑 `ADYaiT/D8MqeW(23, this)`（模拟主循环） |
| 102-115 | `A2egSU(Runnable)`：把任务投进模拟线程并**同步等它跑完**（帧边界执行器） |
| 117-142 | `A4TApA(Console, samples)`：`getAudioSamples()` → `AudioTrack.write()`；`AZkASS != 1.0f` 时走非阻塞写 |
| 169-182 | `AMqCpz()`：等待"可以跑帧"（`B2KMhB` 状态机 3→0） |
| 184-203 | `ARc23Z(B25kr6)`：**会话开始时把可见核 + 所有镜像核 `reset(false)`**，速度重置，`f4313B9tovu=5`（5 帧后开始发键） |
| 220-231 | `AYUAbz(float speed)`：`AZkASS=speed`；帧闸 `A5SV6n.f4276A2egSU = 1e9/(speed*60)`；`f4278A5SV6n = max(0, round(speed)-1)`（追帧预算） |

**`KpHwm4/A5SV6n`（86 行）= 帧闸**：`A2egSU()` 45-85。
`f4276A2egSU` 默认 `1e9/60`；允许一次补 `f4278A5SV6n` 帧（≤ `2*N` 帧落后则重置基准）；
剩余 >2ms 用 `Thread.sleep`，否则自旋（API 33+ `Thread.onSpinWait`）。

**`ADYaiT/D8MqeW.run` 的模拟主循环（字节码 `p1.txt:347f60-3483d0`）**

1. 汇总本机按键掩码 `v13`（含 L/R、连发等映射）。
2. `session == null` → 只 `console.setKeys(v13)` + `runFrame` + 音频。
3. `session != null && session.f4354ARc23Z`（房间模式）→ 对每个 peer：
   `send(ARc23Z(0,4).putInt(v13))` → 若该 peer 收包队列积压超阈值先 `AYUAbz(peer)` → 跑 `runFrame`（按 `BJ7GGh` 次数补帧）。
4. `session != null && !f4354ARc23Z`（直连模式）→ 每 5 帧（`B9tovu` 倒计时）对每个 peer：
   `send(ARc23Z(0,4).putInt(v13))` + **本机可见核 `setKeys(v13)`** + `AYUAbz(peer)` + `runFrame`。

> 这一段是"**每帧发键**"的权威出处：直连模式其实还是 5 帧一次（`f4313B9tovu=5` 递减），
> 房间模式是**每帧**。`NETPLAY_SPEC` 说的 12Hz 只对直连模式成立。

## A.9 `ADYaiT/AZkASS` —— UI Handler（289 行，`handleMessage` 29-279）

`f47A2egSU` 是 switch 选择子；网络会话用的是 `case 1`（47-263）。消息契约：

| msg | 发送点 | 参数 | UI 动作 |
|---|---|---|---|
| 1 | `B25kr6:158` / `AmA8tU:227` / `AzWtSf:184` | `McNXgv.A2egSU(peer[, port])` | 清房间列表、`session.ADYaiT(peer)`（**解阻塞**）、隐藏"等待" |
| 2 | `McNXgv/A4TApA.run:30` | `arg1 = 传输线程返回码` | 1/2/3 → 三种错误弹窗；`f4356AYUAbz` 为真时先走"重连中" |
| 3 | `B25kr6:131` | `peer` | **发 `type2`**：`romHash.getBytes()` + `short romName.length` + `romName.getBytes()`（`AZkASS.java:136`） |
| 4 | `B25kr6:138` / `AmA8tU:194` / `AzWtSf:152` | `String[]{romName, desc}` + `peer` + `slot` | 按名字找/换 ROM → `EmulatorActivity.B9tovu(name, peer, slot)` 建核 |
| 5 | `B25kr6:141/154` | `peer` | **发 `type6`**：`saveStateToMemory()` + `int len` + blob（`AZkASS.java:194`） |
| 6 | `AmA8tU:194` / `AzWtSf:152` | 同上 | 同 msg4（房间模式建镜像核） |
| 7 | `AmA8tU:257` | `arg1 = 剩余毫秒` | "正在重连"进度框；≤0 时 50000 |
| 8 | `AmA8tU:245` | — | 隐藏连接框 / toast"连接已断开" |

## A.10 KCP 子层

### `MhxuEA/A5SV6n` —— 通道管理器（157 行）

| 常量 | 行号 | 值 |
|---|---|---|
| `f5350B3GDIM` | 21 | `{'H','S'}` = **"HS"**（连接请求） |
| `f5351B4ZgIw` | 24 | `{'H','K'}` = **"HK"**（连接应答） |
| `f5352B7CMnp` | 27 | `"PING"` |
| `f5353B9tovu` | 30 | `"PONG"` |
| `f5354BChYOn` | 33 | `"DISC"` |

- 线程池 55-61：`KCP-Receive` / `KCP-Update` / `KCP-Connect`（`MhxuEA/A4TApA` 线程工厂，
  `newThread` 命名 `"KCP-Receive-1"` 且 `setDaemon(true)`）。
- 心跳 88-100：`scheduleAtFixedRate(..., 1L, 1L, SECONDS)` → **每 1 秒**跑一次心跳任务。
- 换 socket 109-138：300ms 节流。

### `MhxuEA/A2egSU` —— 三个任务（124 行）

| case | 行号 | 内容 |
|---|---|---|
| 0 收包 | 31-61 | `DatagramSocket.setSoTimeout(500)` 循环 `receive`；按**前 4 字节大端 = conv** 找会话；异常时重建 socket |
| 1 更新 | 62-76 | 遍历会话 `update(now)` + `A5SV6n()`（把 KCP 收到的完整消息交给 `DUi7mC.B4ZgIw`） |
| 2 心跳 | 78-121 | 距上次收到 >**1500ms** → 给所有会话发 `PING`；>**3000ms** → 清零计数；>`60000ms` → `countDown()` 判死 |

### `MdiDtx/A5SV6n` —— 单会话（115 行）

构造 27-48 设置 KCP 参数：

| 字段 | 值 | 含义 |
|---|---|---|
| `f5336BTvldC` | 1 | nodelay |
| `f5332BIYEnU` | 30 | interval (ms) |
| `f5339BniPrB` | 2 | fastresend |
| `BpkvW3` | 1 | nocwnd |
| `f5334BNL6CD` | 10 | dead_link 阈值 |
| `f5315ASJ6gh` / `f5316AYUAbz` | 128 / 128 | sndwnd / rcvwnd（`r.b.d = 128`，`com/sigmob/sdk/base/views/r.java:53`） |
| `f5321AlLFFp` | 512 | mtu |
| `f5322AmA8tU` | 488 | mss |
| `f5323AzWtSf` | `byte[1608]` | 发送缓冲 |

`MdiDtx/A4TApA`：`ASJ6gh/AYUAbz` 111-127 明确是**大端**编解码（`ikcp` 原版头）。

### `MOpbMP/A2egSU` case 12 —— 连接任务（176-205）

```
conv = UUID.randomUUID().hashCode() & Integer.MAX_VALUE
创建 MdiDtx.A5SV6n(conv, DatagramSocket, remote, DUi7mC 回调)
最多 3 次：send("HS") → 等 HK 3 秒
成功 → 启动心跳
```

### `ADYaiT/DUi7mC.B4ZgIw` —— KCP 收到的字节（315-397）

| 行号 | 判定 |
|---|---|
| 317-327 | 4 字节 == `"PONG"` → 刷新最近收到时间、清零重传计数 |
| 329-357 | 未握手 且 ≥2 字节 == `"HK"` → 置已连接、`countDown`、建 `McNXgv.A5SV6n`（发送走 KCP）、登记、**发 `type1`（int playerCount [+ short + int listSize]）** |
| 362-372 | 已握手 且 4 字节 == `"DISC"` → 置断开 + `countDown` |
| 373-396 | 其它：`while (remaining >= 4)` 按 **4 字节大端长度**切包 → `peer.BIYEnU.put()` |

> 即 KCP 上跑的还是同一套 `4B 长度 + 2B type + payload` 帧，只是外层套了 KCP 分段。

## A.11 `LLYwnm/AYUAbz` —— WSS 房间信令（161 行）

| 方法 | 行号 | 报文 |
|---|---|---|
| `AMqCpz(String roomId)` | 118-124 | `action=join_room`, `room_id` |
| `ADYaiT(String message, String roomId, cb)` | 98-116 | `action=send_message`, `message`, `roomID`, `uuid` |
| `ARc23Z(HashMap, action, cb)` | 126-160 | 通用：补 `token`，10 秒超时重试（`ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT = 10000`） |
| `A2egSU(Object)` / `A4TApA(Object)` | 63-75 | bool/string 宽松解析 |

`leave_room` / `update_room_settings` / `create_game_room` 不在这个类里，
在房间 UI（`LHpdLt`、`Mi9UWv`）直接组 JSON 发 —— 三端各自实现即可。

## A.12 UI/核心侧（联机相关）

| 位置 | 行号 | 内容 |
|---|---|---|
| `com/game/boy/activity/EmulatorActivity.CNPG0E()` | 1500-1509 | Wi-Fi 服务端：`ServerSocket(6374, 1, 0.0.0.0)` |
| `com/game/boy/activity/I3HV03.A4TApA.A2egSU` | 107-116 | `AMqCpz=true; f4354ARc23Z=false;` → `A2egSU(session, session, serverSocket)` |
| `com/game/boy/activity/BI9f7h.A2egSU` | 12-25 | 蓝牙服务端：同上，但用 `KpHwm4.A4TApA`（RFCOMM accept） |
| `com/game/boy/activity/B7CMnp` + `B4ZgIw.run` | 30-48 | 房间加入：解析 JSON 的 `node ip/port/udp/states[]/names[]` → `session.AMqCpz(ip, port, udp, states, names)` |
| `EmulatorActivity.B9tovu(name, peer, slot)` | 1013-1042 | 建核：`Link.A4TApA(slot, romName)` → `reset(false)`；`f4354ARc23Z` 为真时加进 `peer.B2KMhB`（≤4），否则设 `peer.BI9f7h` 并**发 `type3` 4 字节空体**；最后 `session.ADYaiT(peer)` 解阻塞 |
| `EmulatorActivity.BmvVmW()` | 1328-1336 | 用户点"重置"：`ARc23Z((short)5,4).putInt(0)` |
| `EmulatorActivity.C2rE4F()` | 1349-1400+ | 结束会话：`interrupt()` + `close()` + 速度归 1 + `f4354ARc23Z=false` + `ASJ6gh=false` + 可见核 `saveState(slot 9)` + 逐个 `Link.A5SV6n(console)` 关核 |
| `com/game/boy/emu/gba/Console` | 166-188 | `loadStateFromMemory(byte[])`/`saveStateToMemory()`/`setKeys(int)`/`reset(boolean)` 全是 native |
| `com/game/boy/emu/gba/Console.A2egSU()` | 68-92 | **自动槽位**：同 ROM 的核里取最低空闲 0..3；slot>0 时电池存档名追加 `slot+1` |
| `com/game/boy/emu/gba/Link` | 43-92 | `allocateBuffer/deallocateBuffer/openConsole(native)/runFrame(boolean)/loadRom/unloadRom` |

## A.13 全部帧构造 / 帧读取调用点（穷举，一条不漏）

### A.13.1 构造一条消息：`B25kr6.ARc23Z(short type, int payloadLen)` 的全部调用点

（`ARc23Z` 是按字面常量枚举 + 字节码 `method@1ca7/0494` 交叉核对过的；`D8MqeW` 那两条
的 type 在寄存器 `v11=0` 里，所以字面量 grep 抓不到。）

| # | 类:方法 | 行号 | type | payload 字段顺序 | 触发时机 |
|---|---|---|---|---|---|
| 1 | `KpHwm4.B25kr6.A4TApA` | 122 | 1 | `int32 6` | 直连握手，`!AMqCpz`（发起方）连上即发 |
| 2 | `KpHwm4.B25kr6.A4TApA` | 128 | 1 | `int32 6` | 收到对端 `type1` 且值 6、本端 `AMqCpz` 时回 |
| 3 | `KpHwm4.B25kr6.AZOQYO` | 255 | 9 | `int32 speed` | 用户切倍速（0.5x/1x/2x/4x） |
| 4 | `KpHwm4.AmA8tU.A5SV6n` | 173 | 1 | `int32 playerCount` +（仅 pc==1 才填）`int16 0` + `int32 listSize`；**帧长恒 16**（`ARc23Z(1,10)`） | TCP 客户端连上后第一帧 |
| 5 | `KpHwm4.AmA8tU.A5SV6n` | 204 | 1 | 空（len=0） | 某槽 `loadStateFromMemory` 失败 → 断开 |
| 6 | `KpHwm4.AmA8tU.A5SV6n` | 211 | 3 | 空（4 字节 0） | 全部槽载入成功 → "我灌完了" |
| 7 | `KpHwm4.AmA8tU.A5SV6n` | 226 | 1 | 空（len=0） | 读循环退出（会话结束） |
| 8 | `KpHwm4.AzWtSf.A4TApA` | 166 | 3 | 空 | KCP 客户端各槽载入成功 |
| 9 | `KpHwm4.AzWtSf.A4TApA` | 183 | 1 | 空 | KCP 握手完成、进转发前 |
| 10 | `ADYaiT.AZkASS.handleMessage` | 136 | 2 | `byte[32] romHash` + `int16 n` + `byte[n] romName` | 直连握手第 4 步（收到对端 type1 后 msg3） |
| 11 | `ADYaiT.AZkASS.handleMessage` | 194 | 6 | `int32 size` + `byte[size]` | 握手第 6 步（`!AMqCpz`）或第 8 步（`AMqCpz`），msg5 |
| 12 | `ADYaiT.DUi7mC.B4ZgIw` | 345 | 1 | `int32 playerCount`（==1 时再 `int16 0` + `int32 listSize`） | KCP 收到 `"HK"`、建好通道后 |
| 13 | `com.game.boy.activity.EmulatorActivity.B9tovu` | 1037 | 3 | 4 字节 0 | 直连模式建好"对端核"后（解阻塞前） |
| 14 | `com.game.boy.activity.EmulatorActivity.BmvVmW` | 1333 | 5 | `int32 0` | 用户点"重置游戏" |
| 15 | `ADYaiT.D8MqeW.run`（模拟线程，`p1.txt:34821a`） | 字节码 0x01e5 | 0 | `int32 keys` | **房间模式：每帧 × 每个对端** |
| 16 | `ADYaiT.D8MqeW.run`（模拟线程，`p1.txt:348364`） | 字节码 0x028a | 0 | `int32 keys` | **直连模式：每 5 帧 × 每个对端** |

### A.13.2 读一帧：`BTvldC.ADYaiT.ADYaiT()` 的全部调用点

| # | 类:方法 | 行号 | 期望 type | 读到什么 | 失败分支 |
|---|---|---|---|---|---|
| 1 | `B25kr6.A4TApA` | 124 | 1 | `int32`（6 才回） | 非 1 → `return 2` |
| 2 | `B25kr6.A4TApA` | 132 | 2 | `byte[32]` + `int16 n` + `byte[n]` | 非 2 → 退出方法 `return 2` |
| 3 | `B25kr6.A4TApA` | 139 | 3 | 空 | 非 3 → `return 2` |
| 4 | `B25kr6.A4TApA` | 143 | 6 | `int32 size` + blob | 非 6 → `return 2`；load 非 0 → 返回 1/3 |
| 5 | `B25kr6.A4TApA` | 160 | 任意 | 整帧 → `peer.BIYEnU` | `IOException`/EOF → 抛出，线程结束（msg2） |
| 6 | `AmA8tU.A5SV6n` | 183 | 3 / 0 | type3: `int32 rtt`；type0: `int32 v` | 其它 → `return 2`（断开） |
| 7 | `AmA8tU.ARc23Z` | 287 | 任意 | 整帧 → `peer.BIYEnU` | 抛出 → 重连循环 |
| 8 | `AzWtSf.A4TApA` | 142 | 3 | `int32 rtt` + 载入各槽 | 载入非 0 → 直接 `return` 错误码 |
| 9 | `AzWtSf.A4TApA` | 173 | 0 | `int32 v` → `AZkASS` | 非 0 → 继续循环（**没有退出**，靠 `ASJ6gh` 结束） |
| 10 | `B25kr6.AYUAbz` | 226 | 任意（队列 `take()`，不是 ADYaiT） | `while remaining>=6` 按 type 分发（见 A.1 表） | `InterruptedException` 直接结束 |

## A.14 官方消息总表（按阶段区分语义）

### 握手阶段（直连 A4TApA / 客户端 AmA8tU / KCP AzWtSf）

| type | 方向 | payload | 语义 | 代码 |
|---|---|---|---|---|
| 1 | 双向 | `int32 6` | "我在等你 / 我到了" | `B25kr6:122/128` |
| 1 | 发起方→接受方 | `int32 playerCount`（**线上恒 16 字节**，长度字段 12；仅 pc==1 时才填 `short 0` + `int32 listSize`，否则尾 6 字节为 0） | 注册 | `AmA8tU:173-178`、`DUi7mC:345` |
| 1 | 任意 | 空体（len=0） | 断开/结束 | `AmA8tU:204/226`、`AzWtSf:183` |
| 2 | 双向 | `byte[32] name` + `int16 n` + `byte[n] desc` | 自我介绍（ROM 名 / 房间） | `AZkASS:136` |
| 3 | 接受方→发起方 | `int32 rtt` | "RTT 给你，**现在把各槽存档灌进镜像核**" | `AmA8tU:185`、`AzWtSf:143` |
| 3 | 发起方→接受方 | 空体（4 字节 0） | "我灌完了" | `AmA8tU:211`、`AzWtSf:166` |
| 6 | 双向 | `int32 size` + `byte[size]` | 整份 savestate | `AZkASS:194` |
| 100 | 重连方→对端 | `int32 rtt`（裸 10 字节） | 断线重连 | `AmA8tU:263-272` |

### 稳态（转发循环 + `AYUAbz` 逐帧 dispatch）

| type | 方向 | payload | 语义 | 代码 |
|---|---|---|---|---|
| 0 | 双向、每帧/每对端 | `int32 keys` | 本帧按键掩码 | `p1.txt:34821a`、`348364`；收 `p2.txt:379f2c` |
| 5 | 双向 | `int32 0` | 重置全部核 | `EmulatorActivity:1333`；收 `p2.txt:379e76` |
| 6 | 双向 | `int32 size` + blob | 中途补存档（灌**本机可见核**） | 收 `p2.txt:379e76-379e72` |
| 7 | ← | `int32 keys` | 本机可见核按键（无发送方） | 收 `p2.txt:379e30` |
| 8 | ← | `int32 n` | 每帧推进次数（无发送方） | 收 `p2.txt:379e20` |
| 9 | → channel[0] | `int32 speed`（1/-1/2/4） | 模拟速度倍率 | `B25kr6:253-258`；收 `p2.txt:379d5a` |
| 10 | ← | 无 | 断开通知（转 UI msg 2） | 收 `p2.txt:379d46` |
| 1..4 | ← | `int32 keys` | 玩家 N 的按键（中继/遗留，本机不发） | 收 `p2.txt:379eca` |

## A.15 常量汇总

| 项 | 值 | 出处 |
|---|---|---|
| 帧头 | 4B 大端长度（含 type）+ 2B 大端 type | `B25kr6:91-96`、`BTvldC/ADYaiT:103-113` |
| 帧长上限 | 8 MiB | `BTvldC/ADYaiT:107` |
| 静默判死 | 500ms × 8 | `BTvldC/ADYaiT:79-101` |
| TCP 端口 / backlog / 绑定 | 6374 / 1 / 0.0.0.0 | `EmulatorActivity:1505` |
| TCP accept 后 | `soTimeout 500`、`tcpNoDelay true` | `A2egSU:64-67` |
| TCP connect 超时 | 10000ms | `AmA8tU:92` |
| 重连间隔 / 总窗口 | 2000ms / 50000ms | `AmA8tU:107/114` |
| 重连"最近成功"窗口 | 10000ms | `AmA8tU:101` |
| KCP mtu / mss | 512 / 488 | `MdiDtx/A5SV6n:44-46` |
| KCP interval / nodelay / fastresend / nocwnd | 30ms / 1 / 2 / 1 | 同上 36-40 |
| KCP sndwnd / rcvwnd | 128 / 128 | 同上 41-43 |
| KCP 更新周期 | 10ms | `MOpbMP/A2egSU:189` |
| KCP 心跳周期 | 1s | `MhxuEA/A5SV6n:97` |
| PING 阈值 / 判死阈值 / 放弃 | 1500ms / 3000ms / 60000ms | `MhxuEA/A2egSU:86/92/102` |
| HS 重试 / 等待 | 3 次 / 3s | `MOpbMP/A2egSU:197-203` |
| 蓝牙 UUID / 服务名 / 优先级 | `3a1f7b2e-…` / `GBoy` / -19 | `B25kr6:21`、`A4TApA:26`、`A2egSU:59` |
| UDP socket 收超时 | 500ms | `MhxuEA/A2egSU:36` |
| 信号重试 | 10s | `LLYwnm/AYUAbz:150` |
| 帧率基准 | `1e9/60` ns | `KpHwm4/A5SV6n:21` |

---

# B. 对照表（每条官方行为 → 三端现状）

结论记号：`✅一致` / `⚠️等价（差异）` / `❌缺失` / `❌不一致（差异）`。

| # | 官方行为（类:方法:行） | PC | Android | iOS | 结论 |
|---|---|---|---|---|---|
| 1 | 线格式 `u32长度(含type)+u16 type+payload`（`B25kr6:91-96`、`BTvldC/ADYaiT:103-113`） | `GBoyFrames.cpp:13-35`；`Reader` 147-165 | `GBoyFrames.java` 同 | `LobbyFrames.swift:21-90` 同 | ✅一致 |
| 2 | 帧长上限 8 MiB（`BTvldC/ADYaiT:107`） | 16 MiB（`GBoyFrames.h:36`） | 16 MiB（`GBoyFrames.java:36`） | 16 MiB（`LobbyFrames.swift:31`） | ⚠️等价（放宽一倍，仍能拒掉明显错位） |
| 3 | 非法长度 → 抛 `IOException` 断链（`BTvldC/ADYaiT:107-109`） | 清空缓冲继续读（`GBoyFrames.cpp:152-156`）；TCP 层判 closed（`TcpDirectLink.cpp:409-412`） | 丢弃缓冲 | 丢弃缓冲 | ⚠️等价（不崩，但不像官方那样立刻断） |
| 4 | 8×500ms 静默判对端不可达（`BTvldC/ADYaiT:85-92`） | **有意偏离**：`SO_KEEPALIVE` 2s+1s / 2/1/3（`TcpDirectLink.cpp:57-80`），约 5s 判死 | `GBoySocketLink.java:56-57/270-274` 8 次 | `GBoyLink.swift` 无（靠 EOF/写失败） | ⚠️等价（PC 换成 keepalive，理由见 C10；iOS 仍是缺口） |
| 5 | **type 0 = 按键掩码**（`p1.txt:34821a`） | `TYPE_KEYS=0`（`GBoyFrames.h:57`），收 → `pushKeys` | 同（`GBoyFrames.java:49`、`GBoyLinkSession.java:285-300`） | 同（`LobbyFrames.swift:57`） | ✅一致（2026-11-15 三端已改） |
| 6 | **type 9 = 速度倍率**（`B25kr6:253-258`） | `TYPE_SPEED=9`（`GBoyFrames.h:66`），收下存 `m_remoteSpeed`（`GBoyLinkSession.cpp:205-210`）**但没人用** | 同（`GBoyLinkSession.java:296-300`、`:456-459`），`GBoyCloudLink`/`EmulatorActivity` 无消费点 | 同（`GBoyLink.swift:534`、`LobbyLink.swift:859-866`），只记录 | ⚠️等价（号对了、也识别了，但没像官方那样改帧闸/倍率，见 C11） |
| 7 | type 2 自我介绍双向发送（`AZkASS:136`） | `startOfficialMatch` 发一次（`CloudLink.cpp:1861`） | 已发（`GBoyCloudLink.java:1929`、会话身份 `:301`/`:371-381`） | 握手内发送（`GBoyLink.swift:391-395`） | ✅一致（2026-11-15 三端都会发） |
| 8 | type 2 payload：`32B name + int16 n + n字节` | `nameFrame`（`GBoyFrames.cpp:46-54`） | `nameFrame` 同 | `romInfo()`（`GBoyLink.swift:931`） | ✅一致 |
| 9 | type 3 语义（就绪/载入指令/空 ack/稳态=玩家3键，四处复用） | 当"ready+RTT"（`GBoyLinkSession.cpp:120-145`） | 同（`GBoyLinkSession.java:222-238`） | 同（`GBoyLink.swift:476-483`） | ❌不一致（丢了"载入指令"与"ack"） |
| 10 | type 5 = 重置（`EmulatorActivity:1333`；收 `379e76`） | `TYPE_RESET=5`（`GBoyFrames.h:61`），`sendReset` 发 5（`GBoyLinkSession.cpp:294-296`） | 同（`GBoyFrames.java:57`；`sendReset` 覆盖 KCP / TCP / 蓝牙 / WS 隧道四路） | 同（`LobbyFrames.swift:65`、`GBoyLink.swift:185-191`） | ✅一致（2026-11-15 三端已改） |
| 11 | 不再使用自研 type 13（官方没有） | 仅保留 `TYPE_RESET_LEGACY=13` 接收兼容（`GBoyFrames.h:71`、`GBoyLinkSession.cpp:188`），不发送 | 同（`GBoyFrames.java:79`、`GBoyLinkSession.java:283`） | 同（`LobbyFrames.swift:80`、`LobbyLink.swift:869`） | ✅一致（13 只收不发） |
| 12 | type 6 payload：`int32 size + blob` | `stateFrame`（`GBoyFrames.cpp:56-63`） | 同 | `GBoyLink.swift:947` | ✅一致 |
| 13 | type 6 时机：握手第 7 步各发一次（`B25kr6:143-155`） | 连上后一次 + 按需（`CloudLink.cpp:2269-2287`、`1966-1976`） | 连上后一次（`GBoyCloudLink.java:2095`） | 握手内双向（`GBoyLink.swift:400-420`） | ⚠️等价（时机近似，无周期补发） |
| 14 | type 6 落地目标 = **对端那颗粒**（`B25kr6:144-152` 用 `peer.BI9f7h`） | 镜像核 slot2（`CloudLink.cpp:1830-1842`） | 镜像 slot2（`GBoyConsoleSet.java:591-611`） | 镜像 slot2（`GBoyConsoleSet.swift:328-350`） | ⚠️等价（我们用"对端=slot2"固定约定，官方按位置表） |
| 15 | load 后 `reset(false)` 两颗粒（`B25kr6:156-157`） | 已撤（`GBoyMirror.cpp` 载入后只 load+计数；`emit remoteReset` 只剩 1837 的 type5 与 2286 的 `handle()`） | 已撤（仅 `type5` 的 `onReset/onRemoteReset` 调 `requestMirrorResets`） | 有意不跟（`GBoyConsoleSet.swift:379-388`） | ⚠️等价（三端一致：**只载入不复位**；官方 `reset(false)` 语义不可复现，照抄会清零 EWRAM/IWRAM。**有意偏离，勿“修回去”**） |
| 16 | load 返回码 `-5→3 / 其它→1 / 0→成功`，失败即断（`B25kr6:148-152`） | 已接：帧边界结果 → `m_mirrorStateError` → `CloudLink.cpp:2049-2054` 断链 | 已接：`EmulatorActivity:2282-2283` / `:4944-4945` 非 0 关链路 | 已接：`onStateLoadResult` → `abortSession(errorCode:)`（`EmulatorViewController.swift:5969-5980`） | ✅一致（2026-11-15 三端已接） |
| 17 | 握手顺序 `1→2→3→6` 且每步阻塞（`B25kr6:116-173`） | 只有 1/3/6，无 2（云端模式补发 2）（`CloudLink.cpp:2151-2175`） | 只有 1/3/6（`GBoyCloudLink.java:1886-1904`） | 2→3→6 完整，且 type1 校验 `==6`、宿主回 6（`GBoyLink.swift:795-822`） | ⚠️等价（PC/Android 缺 type2 阶段；iOS 最接近官方） |
| 18 | type 1 握手值 6（`B25kr6:122/128`） | `sendSocketHandshake`（`GBoyLinkSession.cpp:257-259`） | 同（`GBoyLinkSession.java:359-362`） | `helloFrame()`（`GBoyLink.swift:735-737`） | ✅一致 |
| 19 | type 1 注册帧：**线上恒 16 字节**（长度字段 12）；`pc` 之后那 6 字节**仅 pc==1 才填** `short 0 + int listSize`，否则保持 0（`AmA8tU:173-178` + `ARc23Z(1,10)` 分配 16 + 发送线程写整个 `array()`） | 恒 16、pc==1 才填（`GBoyFrames.cpp:99-108`） | 恒 16、pc==1 才填（`GBoyFrames.java:126-136`） | 恒 16、pc==1 才填（`LobbyFrames.swift:150-165`） | ✅一致（2026-11-15 01:1x 三端逐字节一致） |
| 20 | type 1 空体 = 断开（`AmA8tU:204/226`） | 未发 | 未发 | 未发 | ❌缺失 |
| 21 | 重连裸 10 字节 `int32 6 + int16 100 + int32 rtt`（`AmA8tU:263-272`） | 有（`GBoyFrames.cpp:68-70`、`TcpDirectLink.cpp:288-295`） | 有（`GBoySocketLink.java:196/320`） | 有（`GBoyLink.swift:742-760`） | ⚠️等价（官方只发不收；我们收下当 ready） |
| 22 | TCP 服务端：6374 / backlog 1 / 0.0.0.0（`EmulatorActivity:1505`） | 端口由 UI 传、backlog 4、`INADDR_ANY`（`TcpDirectLink.cpp:205-208`） | `new ServerSocket(port)`（`GBoySocketLink.java:107`） | 默认 6374（`GBoyLink.swift:50`，UI 可改，`EmulatorViewController.swift:5664`） | ⚠️等价（参数不同，能互通） |
| 23 | TCP 客户端：10s connect / 500ms read / nodelay（`AmA8tU:92-94`） | `TcpDirectLink.cpp:38, 152-163` | `GBoySocketLink.java:168-171` | `GBoyLink.swift:324-360` | ✅一致 |
| 24 | 重连 2s 间隔 / 50s 窗口（`AmA8tU:107-114`） | `TcpDirectLink.cpp:39-40, 343-369` | `GBoySocketLink.java:59-61, 370+` | `GBoyLink.swift:360-372` | ✅一致 |
| 25 | KCP mtu512/mss488/30ms/1/2/1/wnd128（`MdiDtx/A5SV6n:27-48`） | `KcpChannel.h:69-71` + `KcpChannel.cpp:41-43,126-129` | `KcpChannel.java:63-67` | `LobbyKcp.swift:43-45` | ✅一致 |
| 26 | KCP 线程名 `KCP-Receive/Update/Connect/Heartbeat`（`MhxuEA/A5SV6n:55-61`） | `std::thread` 无名（`KcpChannel.cpp`） | `"lobby-kcp"` / `"lobby-tcp"`（`KcpChannel.java:88/108`） | 未命名 | ⚠️等价（仅调试可读性） |
| 27 | `HS/HK`，3 次 × 3s（`MOpbMP/A2egSU:176-205`） | `KcpChannel.cpp:423-425,452,532` | `KcpChannel.java:47-48,146-148` | `LobbyKcp.swift:32-33,47,147+` | ✅一致 |
| 28 | `PING/PONG/DISC` + 1s 心跳（`MhxuEA/A5SV6n:97`） | 1s 发 PING（`KcpChannel.cpp:638-641`）、DISC（686）、PONG（536-545） | 同 | 同 | ✅一致 |
| 29 | 心跳阈值 1.5s 发 PING / 3s 清零 / 60s 判死（`MhxuEA/A2egSU:86-102`） | 只按 1s 周期发，无阈值与 60s 放弃 | 有 | 有 | ⚠️等价（PC 不主动判死） |
| 30 | 蓝牙 UUID/服务名/`cancelDiscovery`（`B25kr6:21`、`A4TApA:26`） | `BtLink.h:17-35`（仅 Windows `AF_BTH`） | `GBoyBluetoothLink.java:44-46,74-102` | 无（iOS 无经典 RFCOMM API） | ⚠️等价（PC 平台受限、iOS 缺） |
| 31 | 蓝牙线程优先级 -19（`A2egSU:59`、`A4TApA:49`） | 无（Windows 无此概念） | `Process.THREAD_PRIORITY_URGENT_AUDIO`（`GBoyBluetoothLink.java:78/103/109`） | N/A | ⚠️等价 |
| 32 | 蓝牙服务端只接一个对端后关监听（`A4TApA:50-52`） | 一次性 accept | 一次性 accept（`GBoyBluetoothLink.java:79-80`） | N/A | ✅一致 |
| 33 | 每对端一条通道 + 一颗镜像核（`McNXgv/A5SV6n`） | 单 `GBoyLinkSession` + N 个 `GBoyMirror` | 单 session + `GBoyConsoleSet` | 单 session + `GBoyConsoleSet` | ⚠️等价（我们单连接多槽位） |
| 34 | 槽位映射 `A2egSU(pc,index)` 表（`B25kr6:63-89`） | `mirrorSlotFor` 取"除本机外升序"（`GBoyLinkSession.cpp:48-64`） | 同（`GBoyLinkSession.java:134-150`） | 同（`LobbyLink.swift:712-720`） | ❌不一致（只有 pc=4 时与官方重合） |
| 35 | `Console.setKeys/loadStateFromMemory/saveStateToMemory/reset`（`Console.java:166-188`） | `mgbaMobile*` 封装齐全 | 同 | 同 | ✅一致 |
| 36 | 自动槽位：同 ROM 取最低空闲 0..3，slot>0 存档名加 `slot+1`（`Console.java:68-92`） | 镜像核用独立目录 `mirrorN/`（`CloudLink.cpp:1904-1910`） | 按 slot 建核 | 同 | ⚠️等价（换了一种隔离方式） |
| 37 | 建核时机 = 握手第 5 步（阻塞）（`B25kr6:132-138`） | 启动期一次性建 3 镜像（`CloudLink.cpp:1904`） | 启动期 | 启动期 | ⚠️等价（提前建，握手不再阻塞） |
| 38 | 帧节奏 `1e9/(speed*60)` + 追帧预算（`KpHwm4/A5SV6n:21,45-85`） | 16ms / fps 上限（`CloudLink.cpp:1978-1982`） | 16ms | 16ms | ⚠️等价（无追帧预算） |
| 39 | 速度倍率生效（`AaHO0E.AYUAbz(float)` 220-231） | 无 | 无 | 无 | ❌缺失 |
| 40 | 稳态按键频率：房间模式每帧、直连模式 5 帧（`p1.txt:348210/348362`） | 5 帧 + 边沿（`GBoyLinkSession.cpp:20-46`） | 同（`GBoyLinkSession.java:106-128`） | 同 | ⚠️等价（少发，靠边沿补） |
| 41 | 断开清理：速度归 1 / 存 slot9 / 关全部镜像核（`EmulatorActivity.C2rE4F:1349-1400`） | 部分（`CloudLink` 停镜像） | 部分 | 部分 | ⚠️等价 |
| 42 | WSS 四动作 `create_game_room/join_room/send_message/update_room_settings`（+`leave_room`） | 全有（`CloudLink.cpp:92/103/112/741/799`） | 全有 | 全有 | ✅一致 |
| 43 | 房间状态分发：JSON 里带 `node ip/port/udp` + `states[]/names[]`（`B4ZgIw.run:26-48`） | 用自定义 `gboy_node` marker + WS 隧道（`CloudLink.cpp:2300-2320`） | 同思路 | 同 | ⚠️等价（不是官方那套字段，但自成闭环；与官方客户端不同房） |
| 44 | `type 10` 断开通知 → 结束会话（`p2.txt:379d46`；APK 内无发送方，应来自中继） | 无（未知类型仅记日志） | 无 | **有**：`typeDisconnect=10`，收到即正常收尾（`LobbyFrames.swift:71`、`LobbyLink.swift:877`、`GBoyLink.swift` drop） | ⚠️等价（iOS 仅接收侧；三端都不主动发，关闭走 socket） |
| 45 | `type 8` 每帧推进次数（`p2.txt:379e20`） | 无 | 无 | 无 | ❌缺失（官方只在多对端时用） |
| 46 | `type 7` 本机可见核按键（`p2.txt:379e30`） | 用自研 14（`TYPE_KEYS_LOCAL`） | 同 | 同 | ❌不一致（无发送方，仅语义差异） |
| 47 | 服务端 accept 单次（`A2egSU:64`） | 循环 accept（`TcpDirectLink.cpp:428-440`） | 循环 accept（`GBoySocketLink.java:111-147`） | 每会话一次、掉线后重新 select+accept（`GBoyLink.swift:665-690`） | ⚠️等价（有意扩展） |
| 48 | 大存档分片：TCP 靠流、KCP 靠 `frg`（`MdiDtx`） | `DirectLink` 加 `TYPE_FRAG`（1000B/48 窗） | 同 | 同 | ⚠️等价（官方原生分片，我们自研） |
| 49 | **首次连接单次 10s、失败即抛**；只有掉线重连才 2s×50s（`AmA8tU:95-98` 的 `if (!f4332B9tovu) throw e;`，`f4332B9tovu` 只在握手成功后置真 `:228`） | 首连单次（`TcpDirectLink::connectTo`）；失败按架构回落 WS 隧道 | 首连单次（`GBoySocketLink.java:159-189`），重连 2s/50s（`:389-423`） | 首连单次，重连 2s/50s（`GBoyLink.swift:346-372`） | ✅一致（重连窗口只作用于已连过的会话） |
| 50 | 帧循环阻塞收包不得压低帧率（官方帧闸与收包解耦，`KpHwm4/A5SV6n`+`AmA8tU`） | `recv` 超时按 `tickMs` 收窄（`CloudLink.cpp:2037-2039`），否则 60fps 被压到 33fps | 独立读线程 | 独立读线程+睡眠节拍 | ⚠️等价（PC 单线程结构导致，已修） |
| 51 | `type 6` 与 SIO 中继桥共用 6 的判别（官方无此问题） | `GBoyFrames::stateOf` 用"u32 头是否放得下"区分（`GBoyFrames.cpp:72-84`） | 同 | 同 | ⚠️等价（我们自造的分层，官方没有桥） |
| 52 | 交付实测状态 | 编译+回归绿（`buslocal`、`frames` 4 条）；`dual` 单次可 PASS（00:42 一次全绿），但**同一二进制 5 跑 3 次无诊断退出**、`bus test.gba 4` FAIL（SIOMULTI0=ffff）→ 判 harness/4P 既有状态，**未稳定**；蓝牙仅编译（无适配器） | `assembleDebug` PASS；未真机 | `swiftc -parse` 通过；**未编译未真机** | ⚠️等价（**已实现未实测**：iOS 全部、PC/Android 蓝牙、4P 稳定性） |
| 53 | **直连通道也必须发握手 type 1(6)**：两端互发，`case TYPE_KEYS` 的握手期门控才放行按键（`B25kr6:122/128`；门控见 `GBoyLinkSession.cpp:113`） | 已补：`CloudLink.cpp:1905` 在 `startOfficialMatch` 里 `sendSocketHandshake()`（直连/TCP-peer/蓝牙都走这里）。**修前直连路径一次没发，两端 `m_ready` 恒 false，每帧 type 0 被当"节奏信号"丢弃 → 对端按键全无响应** | `GBoySocketLink.java:196/320` 连上/回包即发 `sendSocketHandshake` | `GBoyLink.swift:735-737` `helloFrame()`，宿主收到值 6 回发（`expectHello`） | ✅一致（2026-11-15 01:2x 由 g5 补上；**只有端到端对局能验，`buslocal`/`frames`/`dual` 覆盖不到**） |
| 54 | **握手顺序必须 `1 → 2 → 3 → 6`**（官方 `A4TApA` 按此顺序硬读，任何一步不符 `return 2`；`B25kr6:122-144`） | 线上是 **2 → 1 → 6**：`CloudLink.cpp:1901` 先发 name，`:1905` 才发 1；**从不发 3**（`TYPE_READY` 只在 relay 的 `handshake():2208` 发） | **1 → 2 → 6**：`GBoySocketLink:196/320` 发 1，`GBoyLinkSession.sendSocketHandshake()` 紧跟 2；**直连不发 3**（只有 relay `GBoyCloudLink:1909` 发） | **1 → 2 → 3 → 6 完整**（`GBoyLink.swift:377-420`：hello→romInfo→msgReady→state） | ❌不一致（PC 顺序错且缺 3；Android 缺 3；iOS 正确。**对官方房主/官方客户端都会在第一/三步断开**，自家三端不受影响） |

**已知偏差（4P 槽位键）**：官方稳态用 `type 1..4` 表示"第 N 号玩家的按键"（`AYUAbz` 前半段按 playerCount 算槽位），
我们三端用自家扩展 `11/12/17`。APK 内**没有**任何代码发送 1..4，它们只可能来自中继节点（节点给按键打玩家标签）；
我们自己的中继不打标签，所以内部自洽但与官方 4P 房不互通。**不要**为了"对齐"去发 1..4：
那会和握手期的 `1=注册`、`3=RTT` 撞号，必须做阶段二义（风险高、收益低）。真要与官方 4P 互通，
正确做法是"只发 `type 0`，让节点打标签"。

**争议行说明（5/6/9/10）**：PC 侧主张「0=帧率、9=按键、5=就绪确认」，依据是 `NETPLAY_SPEC.md`。
本节坚持相反结论，依据是**发送端全量枚举**（12 处 `ARc23Z` 调用，类型只有 0/1/2/3/5/6/9，`type9` 的唯一调用者是倍速菜单）
与**接收端字节码**（`AYUAbz` case 0 = `setKeys`、case 9 = 改帧闸）。两种读法只在「握手期 vs 稳态」分阶段时才自洽，
见 §0.4；判定性实验见同节。在实验做完之前，5/6/9/10 行按 ❌不一致 计。

**统计：`✅一致` 20 条，`⚠️等价` 27 条，`❌缺失` 3 条，`❌不一致` 4 条，共 54 条。**

按"一致 + 等价"计，照抄率 **47/54 ≈ 87%**；若只算"逐字节可互通"的条目（✅），**20/54 ≈ 37%**。

---

# C. 缺口清单（按修复量从小到大）

> **进度（2026-11-15 01:2x）**：C1/C2/C3/C5/C6/C7 **三端已完成**；另有一条不在 C 清单里的 P0 已修——
> 直连路径此前从不发握手 `type 1(6)`（第 53 行，已修）、且**握手顺序不是 `1→2→3→6`**（第 54 行 / C13，**未修**）；
> C4 **三端已完成**（PC 00:34 撤掉两处；`ninja mgba-qt` / `test-gboylink` / `frames` / `buslocal` 全绿）；
> C8/C9/C11/C12 暂不动（team-lead 决定）。下表保留原始描述与证据，行内标注现状。

> 每条给：缺什么 / 改哪里 / 动几端 / 风险 / 怎么验证。
> `Pn` = 优先级（P0 = 与官方客户端互通必须改）。

### C1. `type 0` / `type 9` 语义对调（P0，三端，1 行/端）
> **先做 §0.4 的判定实验再动手**：PC 侧刚按「0=帧率、9=按键」落地并跑绿，
> 改这一条要与 general-purpose-1 同步，避免边改边回退。

- **缺什么**：官方 `0 = 按键`、`9 = 速度倍率`；我们反过来。
- **改哪**：
  - PC `src/platform/qt/GBoyFrames.h:48,54` 交换常量值（`TYPE_KEYS = 0`、`TYPE_SPEED = 9`），
    同步 `GBoyLinkSession.cpp:195-200`（`case TYPE_KEYS → pushKeys`）与
    `286-288`（`sendFps` → `sendSpeed`），`CloudLink.cpp:2216-2221`（每秒那条 60 删掉）。
  - Android `GBoyFrames.java:46,58` + `GBoyLinkSession.java:210-212/291-300` + `GBoyCloudLink.java:2112-2120`。
  - iOS `LobbyFrames.swift:44,56` + `GBoyLink.swift:462-492` + `LobbyLink.swift:688-692`。
- **风险**：改完自家三端之间仍能通（同一处同时改），但与"旧版我们自己的客户端"不再互通（可接受）。
- **验证**：抓包看 `type` 字段；跑官方客户端 + 我们客户端，官方侧按键应能驱动我们 slot2，反之亦然。

### C2. 删掉每秒 `TYPE_FPS(60)`（P0，三端，各 3-5 行）
- **缺什么**：官方没有任何 pacing 帧；我们每秒发一条 `0 + int 60`，在官方眼里是"按键=60"。
- **改哪**：`CloudLink.cpp:2216-2221`、`GBoyCloudLink.java:2118-2121`、`LobbyLink.swift` 对应 `typeFps` 发送处。
- **风险**：无（这条本来就是我们自造）。
- **验证**：官方客户端连接后不再出现"画面突然加速/按键黏住"。

### C3. `type 5` 定为 reset，resync 的 `TYPE_RESET(13)` 并入 5（P0，三端，各 2-3 行）
- **缺什么**：官方 5 = `int32 0` 重置全部核；我们 5 = ack、13 = reset。
- **改哪**：`GBoyFrames.h:52,59`、`GBoyLinkSession.cpp:120-145/282-284`；
  `GBoyFrames.java:54/74`、`GBoyLinkSession.java`；
  `LobbyFrames.swift:52/65`、`GBoyLink.swift:465-474`。
- **风险**：低（13 号继续保留给自家旧版本，收 5 时执行 reset 即可）。
- **验证**：一端按"重置"，另一端所有核重启到开机画面。

### C4. `type 6` load 后复位的两颗粒 —— **不要照抄（三端已撤，2026-11-15 01:0x 闭环）**
- **缺什么**：官方 `B25kr6:156-157` 在 load 成功后 `reset(false)` **可见核 + 对端核**。
- **结论：不要跟。这不是"缺一条"，是"跟了就是 bug"。** 证据链（2026-11-14 复核，全部可在本仓库核对）：
  1. 官方 `Console.reset(boolean)` 是 libgboy 的 native 方法（`libgboy.so` 有
     `Java_com_game_boy_emu_gba_Console_reset`，签名带一个 boolean），但 libgboy **不是 mGBA 内核**
     （`.so` 里查不到 mGBA / GBASIOReset / SavedataUnmask 任何字符串），函数体也不可静态读。
  2. 我们这边的 `mgbaMobileReset` = `emu->core->reset(core)`（`src/platform/mobile/mgba_mobile.c:4883`），
     GBA 的 reset 走 `GBAReset`（`src/gba/gba.c:245`）→ `GBAMemoryReset`（`src/gba/memory.c:219-228`）
     **`memset(wram,0,256K)` + `memset(iwram,0,32K)` + 清 IO + `GBAIOInit` + `GBASIOReset`**。
  3. 而载入是 `mCoreLoadStateNamed`（`mgba_mobile.c:4799`），它已经把 CPU/内存/IO 全部恢复好了，
     **不需要**任何 reset。载入后再 reset = 把刚恢复的 RAM 清零、PC 回 0 → 镜像核回到开机画面。
  4. 反证：官方若真在 load 后做"开机复位"，它自己的状态同步就是无效的；所以 `reset(false)` 一定
     不是"开机复位"。我们无法复现它的真实语义（很可能是"软复位 SIO/帧闸"），**没有等价 native 接口**。
- **现状（2026-11-14 23:5x 复核后更新）**：iOS 已经有意不跟并写清了理由
  （`GBoyConsoleSet.swift:379-388`）——**这是正确做法**；
  **PC 曾有两处**（已撤，见下）：`GBoyMirror.cpp:227`（镜像核帧边界 reset）**和** `CloudLink.cpp:1862`
  的 `emit remoteReset()` → `LobbyView.cpp:257` → `CoreController::reset`（**连玩家正在玩的可见核一起重启**）；
  **Android 一处**：`GBoyConsoleSet.java` 的 `applyRemoteState` 成功分支（**2026-11-15 00:4x 已撤**，
  现在只有 `type5` 的 `onReset/onRemoteReset` 会调 `requestMirrorResets`）。三者都属于 P0 缺陷，
  会把对端存档当场抹掉，表现为"握手成功、两边都在开机画面、SIO 永远凑不齐"。
- **已完成（2026-11-15 01:0x）**：PC 两处（`GBoyMirror.cpp` 载入后的 reset、`CloudLink.cpp:1862` 的 `emit remoteReset`）
  已删除，`emit remoteReset` 全文只剩 1837（type5 的 `onReset`）与 2286（`handle()` 的 `TYPE_RESET`）两条正确链路；
  Android 早在 00:4x 撤完；iOS 本来就没跟。`type 5`（用户点“重置游戏”）链路保留不动。
- **验收**：PC `ninja mgba-qt` / `test-gboylink` EXIT=0，`frames` 4 条 + `buslocal` 2 条全 PASS，dist 已更新（00:34）。
- **可替代的等价动作**（若真观察到载入后 SIO 卡死）：只重建联机线（`linkClose`+`linkJoin`），
  绝不整机 reset。

### C5. `type 6` load 失败要可见（P1，三端，各 ~10 行）——**不做异步回包**
- **缺什么**：官方 `-5 → 3`（尺寸不符）、`其它 → 1`、`0 → 成功`，失败即断链。
- **为什么不做完整等价物**：官方是在网络线程**同步** load（同一线程、无帧边界），所以能把返回码
  直接映射成 `type1` 错误包。我们的 load 在镜像线程帧边界执行，要"异步回传再发错误包"会改时序、
  增加一条反向通路，收益只是让对端 UI 显示 3 而不是"断开"——**不值得**。
- **建议的最小实现（两段，都不跨线程回包）**：
  1. **尺寸预检（网络线程，零风险）**：建镜像核时在镜像线程取一次 `mgbaMobileStateSize()` 存进
     `applyRemoteState` 的期望值；收到 `type6` 时先比 `size`，不等就**直接关连接**（等价于官方的 `3`）。
  2. **结果上报（镜像线程，3 行）**：帧边界 load 的返回值写进一个 `std::atomic<int>`/`volatile int`，
     会话循环下一拍读到非 0 → 关连接 + 日志。对端看到的是 EOF，等价于官方的 `type1` 空体。
- **现状（2026-11-15 已闭环）**：三端都把结果用起来了——PC 帧边界结果经 `m_mirrorStateError`
  在 `CloudLink.cpp:2049-2054` 收口断链；Android 在 `EmulatorActivity:2282-2283` / `:4944-4945`
  非 0 即关链路；iOS 走 `onStateLoadResult` → `abortSession(errorCode:)`。
- **改哪**：`GBoyMirror.cpp:242`、`GBoyConsoleSet.java:591`、`GBoyConsoleSet.swift:328`。
- **风险**：低（只把静默失败变成显式失败）。
- **验证**：故意发一个 100 字节假存档 → 5 秒内断链并有明确日志，而不是"看起来连上了但核不动"。

### C6. `type 1` 注册帧：iOS 应为恒 16 字节 —— **已完成（2026-11-15 01:1x）**
- **原文澄清（2026-11-15 更正）**：`ARc23Z((short)1, 10)` 分配的是 **16 字节**（`len+6`，长度字段 = 12），
  发送线程写的是 `byteBuffer.array()`（**整个 backing array**，不受 position/limit 影响）。所以官方线上
  type1 注册帧**永远是 16 字节**；`AmA8tU:173-178` 的 `if (playerCount == 1)` 只决定尾部 6 字节
  **填不填**，不是决定"发不发"。pc≠1 时那 6 字节是 0。
- **现状（已闭环）**：PC（`GBoyFrames.cpp:99-108`）、Android（`GBoyFrames.java:126-136`）、
  iOS（`LobbyFrames.swift:150-165`）三端均为"恒 16、pc==1 才填"，与官方逐字节一致。
- **改哪**：`LobbyFrames.swift:150-164` —— 去掉 10 字节分支，统一 `[UInt8](repeating: 0, count: 16)` + `putInt(12)`，
  `pc == 1` 时才写 `putShort(10, 0)` 与 `putInt(12, baseStateCount)`。
- **风险**：低（长度字段同步改成 12，分帧自洽）。
- **验证**：抓包比 pc=1 与 pc=2 两种房间的 type1 帧长，都应是 16 字节；pc=2 时尾部 6 字节为 0。

### C7. 补 `type 2`（名字）发送（**2026-11-15 已完成**：Android `GBoyCloudLink.java:1929` 已发）
- **缺什么**：官方 `AZkASS:136` 双向发；Android 完全没有发送点。
- **改哪**：Android `GBoyCloudLink.java` 官方模式启动处（对照 PC `CloudLink.cpp:1861`）。
- **风险**：低。
- **验证**：对端 UI/日志出现"peer <romHash> (<romName>)"。

### C8. `type 3` 拆成三态（P1，三端，中等）
- **缺什么**：官方 type3 在握手阶段是 `int rtt` + "载入指令"，客户端回空体 ack；
  稳态又表示"玩家 3 的按键"。我们现在只有一个 `READY`。
- **改哪**：会话层加"握手阶段 / 稳态"状态位：`GBoyLinkSession.{h,cpp}`、
  `GBoyLinkSession.java`、`GBoyLink.swift`；`CloudLink.cpp:2151-2175` 的 `handshake()` 里
  把"发空体 type3"当成 ack（已部分做对）。
- **风险**：中（要重构状态机，容易把现有直连回归打回）。
- **验证**：官方客户端 ↔ 我们客户端，握手不再 4s 超时；`pc` 不再恒 0。

### C9. 槽位映射换成官方 `A2egSU(pc,index)` 表（P1，三端，各 1 个函数）
- **缺什么**：`B25kr6:63-89` 的表（pc=2: 0/2；pc=3: 1/0；pc=4: 2-i）。
- **改哪**：`GBoyLinkSession.cpp:48-64`、`GBoyLinkSession.java:134-150`、`LobbyLink.swift:712-720`。
- **风险**：中（会改变 3/4 人房谁控哪颗粒；需回归 4 核布局）。
- **验证**：4 人房，1P 输入应落在 1P 的核、2P 落在 2P 的核（用 `dumpMirrorStates` 看）。

### C10. 补断线检测（PC 已用 keepalive 代替）+ `type 10`（P2，iOS 为主）
- **缺什么**：官方 8×500ms 静默判死；`type 10 → UI msg2`。
- **PC 现状**：**有意偏离且更合理**——`SO_KEEPALIVE` 2s+1s / 2/1/3（`TcpDirectLink.cpp:57-80`），
  约 5s 判死。理由成立（我们的流每 5 帧有按键心跳，静默计数会被大存档传输误杀；
  而无 FIN 的掉线只有 keepalive 能在大约 5-10s 发现，否则要等 tcp_retries2）。
  **不要求 PC 回退**，只补 `case 10` 映射到 msg2。
- **iOS 现状**：既无静默计数也无 keepalive，对端拔网线时可能长期挂着。
  二选一：8×500ms 计数 或 同样的 keepalive 参数。
- **改哪**：`GBoyLink.swift` 读循环；`GBoyLinkSession.cpp:206-210` 的 default 分支加 `case 10`。
- **风险**：低。
- **验证**：拔网线 5-10 秒内两端都提示"连接已断开"，而不是挂着假连接。

### C11. 速度倍率（type 9）真正生效（P2，三端）
- **缺什么**：收到 type9 后改本机帧节奏（官方 `AaHO0E.AYUAbz(float)`）。
- **改哪**：三端帧循环 + 帧闸；PC `CloudLink.cpp:1978-1982` 的 `fpsLimit` 改为 `speed*60`。
- **风险**：低-中（影响所有核的节奏，跑不稳会抖）。
- **验证**：一端切 2x，另一端核也跑 2x（画面/音频同步加速）。

### C12. TCP 服务端参数对齐 6374/backlog1/0.0.0.0（P3，PC + Android）
- **改哪**：`TcpDirectLink.cpp:205-208`（backlog 1，UI 默认 6374）；`GBoySocketLink.java:107`（显式 `bind`）。
- **风险**：低（端口可配，保持兼容）。
- **验证**：官方客户端直连我们的监听端口。

### C13. 握手顺序 `1 → 2 → 3 → 6`（P0 互通项，PC + Android）
- **缺什么**：官方 `A4TApA` 是**按顺序硬读**的：`122` 发 1(6) → `124/125` 必须读到 1 → `132/133` 必须读到 2
  → `139` 必须读到 3 → `143/144` 必须读到 6；任何一步不符直接 `return 2`，会话结束。
- **现状**：PC 直连是 **2 → 1 → 6**（`CloudLink.cpp:1901/1905` 顺序反了，且从发 3）；
  Android 直连是 **1 → 2 → 6**（缺 3）；iOS 是 **1 → 2 → 3 → 6**（`GBoyLink.swift:377-420`，正确）。
- **影响**：我们 ↔ 官方，**两个方向都会断**——官方房主收到我们的 2（PC）或 6（Android）就 `return 2`；
  我们作为房主时，官方客户端读循环期望 3，收到 2 也 `return 2`。自家三端互不校验顺序，所以测试全绿。
- **证据强度**：「顺序必须 1→2→3→6」是**硬证据**（`122-152` 是顺序 `getShort()` 判断，错一步 `return 2`）；
  「必须回空体 3」依据是 `AmA8tU:211` 的发送 + 服务端 `139` 的 `getShort()==3`，强度次之但成立。
- **改哪（最小）**：`sendSocketHandshake()` 提到 `nameFrame` 之前 → 收到/发出 2 之后补一条**空体 type 3**
  （`AmA8tU:211` `ARc23Z((short)3,0)`）→ 再发 type 6。PC `CloudLink.cpp:1898-1905` + `serveOfficial`；
  Android `GBoyLinkSession.sendSocketHandshake()`（现在只发 1+2，补 3）。
- **风险**：低（自家三端都不校验顺序，插一条空体 3 不会破坏现有流程；PC 的 `onFrameBody` 已把 3 当 ready）。
- **验证**：**只有端到端对局能验**——与官方客户端互连，观察是否还停在第一帧；单测/`buslocal`/`frames`/`dual` 覆盖不到。

---

## 结论

**协议层已按字节码真值收敛（2026-11-15 01:1x）**

- `0 = 按键 / 9 = 速度 / 5 = 重置`：三端已落地（C1/C2/C3），每秒 fps 帧已删、13 号只留接收兼容。
- `type 6` 载入后**不复位**（C4）：三端一致、有意偏离，已闭环；官方 `reset(false)` 的语义无法复现，
  照抄会 `memset` 掉 EWRAM/IWRAM —— 这条已在代码与本文里都写了"勿修回去"。
- `type 6` 失败即断链并区分 `3 / 1`（C5）、注册帧恒 16 字节（C6）、`type 2` 三端都发（C7）：均已闭环。
- 直连/蓝牙路径的**握手 `type 1(6)`** 此前从未发出，导致 ready 恒 false、按键被门控丢弃（第 53 行）；g5 已补。
- **握手顺序**仍不是官方的 `1→2→3→6`（PC `2→1→6`、Android `1→2→6`，iOS 正确）——这是目前唯一还会挡住与官方互连的项（第 54 行 / C13）。

**照抄率（54 条）**：`✅20 / ⚠️27 / ❌缺失 3 / ❌不一致 4`；
"逐字节互通"口径 **37%**，"行为等价"口径 **87%**。

**验证边界（对外表述请带上）**：iOS 只过 `swiftc -parse`，未编译未真机；PC/Android 蓝牙只有编译验证（无适配器）；
PC 的 `dual` 同一二进制 5 跑 3 次无诊断退出、`bus test.gba 4` 失败（SIOMULTI0=ffff），属 harness/4P 既有状态，
所以 **4 人房不可宣称"已验证"**。`buslocal`、`frames`（FRAMES/KCP/RECONNECT/TCPDIRECT）是稳定门禁。

**剩余 7 条**

| # | 差异 | 是否会挡住"与官方互连" | 建议 |
|---|---|---|---|
| 54 | 握手顺序：官方硬读 `1→2→3→6`；PC 是 `2→1→6`、Android 是 `1→2→6`、iOS 正确 | **会**（官方房主/客户端都会在第一或第三步断） | **C13，P0，优先修** |
| 9 | `type 3` 在官方是"rtt + 载入指令 / 空 ack / 稳态玩家3键"三重语义，我们只当 ready+RTT | 可能会（与 54 同源，修完 54 再看） | C8，按阶段重构，风险中 |
| 34 | 槽位映射：官方 `A2egSU(pc,index)` 表 vs 我们"除本机升序" | 3/4 人房会 | C9，改动小但要回归 4 核 |
| 46 | `type 7`（本机可见核按键）我们用自研 14 号 | 不会（APK 内无发送方） | 可不动 |
| 20 | `type 1` 空体（=断开）我们不发，直接关 socket | 不会（对端看 EOF，等价） | 可不动 |
| 39 | `type 9` 倍速只记录、未改帧闸 | 不会（只影响倍速同步） | C11，锦上添花 |
| 45 | `type 8`（每帧推进次数）未实现 | 不会（中继/多对端场景） | 可不动 |

**下一步**：**先做 C13**（握手顺序 + 补空体 3），这是目前唯一还会挡住"与官方客户端互连"的项；
之后若继续，顺序为 **C9（槽位表，需 4 核回归）→ C11（倍速生效）→ C8（type3 阶段二义）**。
C8/C9 都要动状态机/核布局，务必先跑 `buslocal`/`frames`/`dual` 再合；C13 只能靠端到端对局验。
