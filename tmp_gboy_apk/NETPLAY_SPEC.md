# GBoy 联机栈逆向规格（GBoy_261018.Apk）

> 来源：`GBoy_261018.Apk`（dpt-shell 加固，已静态脱壳，122,908 个方法体全部还原，0 缺失）。
> 反编译产物：`tmp_gboy_apk/decompiled_all/sources/`（13,658 个 java 文件）。
> 本文是**照抄依据**：所有消息格式、时序、槽位规则都能对到具体反编译文件。

## 0. 一句话结论

GBoy 的联机 = **WSS 只做房间信令** + **游戏数据走 P2P 直连（TCP / KCP-over-UDP / 蓝牙 RFCOMM 三选一）**
+ **握手时整份 savestate 灌进每个镜像核** + **之后只传按键掩码**。
它没有中继服务器转发游戏帧（我们卡死的 100 字符隧道限制在这套架构里根本不存在）。

## 1. 分层与文件对照

| 层 | 类（混淆名） | 职责 |
|---|---|---|
| 信令 | `LLYwnm.AYUAbz` | WebSocket：`join_room` / `send_message` / `leave_room` / `update_room_settings`，字段 `action`+`token`+`uuid`+`roomID` |
| 大厅 UI | `LHpdLt.BTvldC`(30KB) / `Mi9UWv.ASJ6gh` | 房间列表、创建/加入、邀请（`invite.enabled` / `invite.room_id`）、"初始化联机中…" |
| 会话编排 | `KpHwm4.B25kr6` | 每连接一个对端；创建镜像核；消息号 1..9 的收发编排 |
| TCP 直连服务端 | `KpHwm4.A2egSU` | `ServerSocket.accept()` → `B25kr6.A4TApA(in,out)` |
| TCP 直连客户端 | `KpHwm4.AmA8tU` | `Socket.connect(host,port,10s)`，`setSoTimeout(500)`、`setTcpNoDelay(true)` |
| KCP/UDP | `KpHwm4.AzWtSf` + `MhxuEA.*` + `IQ76hF.*` + `MdiDtx.*` | 线程名 `KCP-Receive/Update/Connect/Heartbeat`；UDP 打洞/心跳，`PING`/`PONG`/`DISC` 魔数 + KCP 通道 |
| 蓝牙 | `KpHwm4.A4TApA` / `KpHwm4.A2egSU(str)` | RFCOMM，UUID `3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47`，服务名 `GBoy` |
| 帧封装 | `BTvldC.ADYaiT`(InputStream) | **帧读**：4 字节大端长度 + 该长度的 body（上限 8 MiB），8 次静默超时判对端不可达 |
| 对端通道 | `McNXgv.A5SV6n` | 每对端：发送线程 + `CopyOnWriteArrayList<Console>` 镜像核 + 收包队列 + 最近 RTT |
| 模拟循环 | `KpHwm4.AaHO0E` | 帧节奏（`A5SV6n.A2egSU()` 60Hz 闸）、音频、runFrame |
| 核与槽位 | `com.game.boy.emu.gba.Console` / `Link` | `Console.setKeys(int)`、`loadStateFromMemory(byte[])`、`saveStateToMemory()`；槽位按 **同 ROM 的 Console 下标** 自动分配 |
| 状态栏文案 | `com.game.boy.service.EmulatorService` | "联机中 · WiFi 服务端 / WiFi 客户端 / 蓝牙服务端 / 蓝牙客户端 / 远程房间" |

## 2. 线格式（wire format）

```
+--------+--------+--------+--------+
| len (4B, 大端, = body 长度)        |   ← BTvldC.ADYaiT.ADYaiT()
+--------+--------+--------+--------+
| type (2B, 大端) | payload (len-2) |
+--------+--------+------------------+
```

`B25kr6.ARc23Z(short type, int payloadLen)`：`putInt(payloadLen + 2)` 后 `putShort(type)`，所以 **len 包含 type 那 2 字节**。

### 消息表

| type | 方向 | payload | 语义 / 代码位置 |
|---|---|---|---|
| `0` | 任意 | `int32 v` | 节奏/延迟通知。接收方设 `AaHO0E.f4302AZkASS = v`（帧率上限）。`AzWtSf:174-179`、`AmA8tU:213-221` |
| `1` | 双向 | 握手：`int32 playerCount` +（若 ==1 再 `int16 0` + `int32 listSize`）；长度 0 的 `1` 表示"断开/结束" | 建连确认。`B25kr6:122`、`AmA8tU:173-178` |
| `2` | → | `byte[32] name` + `int16 n` + `byte[n] str` | 对端自我介绍（第 2 段是房间/ROM 描述串）。`B25kr6:133-138` |
| `3` | 双向 | `int32 rtt` | 就绪 + 上报 RTT，存进 `A5SV6n.f5293B9tovu`。`AzWtSf:143-146`、`AmA8tU:185-187` |
| `5` | ← | 空 | 就绪 ACK（仅客户端路径发 `obtainMessage(5)`）。`B25kr6:141` |
| `6` | 双向 | `int32 size` + `byte[size] savestate` | **整份状态同步** → `console.loadStateFromMemory(bytes)`；返回 `-5`=`STATE_SIZE_MISMATCH`→判 3，`0`=成功。`B25kr6:144-152`、`AzWtSf:157`、`AmA8tU:199` |
| `9` | → 对端 | `int32 keys` | **按键掩码**（GBA 位图）。`B25kr6.AZOQYO(int):253-257` |

补充：`AmA8tU.ARc23Z(Socket)`（**断线重连**）会先发一个裸 10 字节 `int32 6 + int16 100 + int32 rtt`（`AmA8tU:263-272`），再进入读循环 —— 即"重连握手包"。

## 3. 时序（照抄要点）

### 3.1 建房（服务端）

```
A2egSU(ServerSocket).accept()
  → B25kr6.A4TApA(in, out)              # 每个 socket 一个对端
      ADD peer(reader, writer)
      若非"我已在房内"：writer.send(type1, putInt(6))       # B25kr6:122
      type1 回包 → 若 payload==6 再回 type1(6)               # 122-130
      handler msg3: 新对端通道就绪                            # 131
      type2 → 读 32B name + str，msg4 报 UI                  # 133-138
      type3 → 若服务端：msg5                              # 139-142
      type6 → size + savestate → console.loadStateFromMemory  # 144-152
             失败/成功都继续；成功后 reset 双方核，msg1 进入"运行中"
      然后进"转发循环"：读到的每帧直接塞进对端通道的发送队列   # 159-167
```

### 3.2 入房（客户端）

```
AmA8tU.A4TApA():
  循环 Socket.connect(ip, port, 10s)；最多重试 50s 后放弃
  → A5SV6n(socket):
      writer.send(type1, putInt(playerCount)
                      [+ (short)0 + (int32)listSize  当 playerCount==1])
      读循环：
        type3 → 记 rtt
        type6 → 逐槽 console.loadStateFromMemory(list.get(slot))   # 189-208
                全部成功后回 type3(0)
        type0 → 设帧率
      → 回 type1(0)，msg1 进"运行中"，之后裸转发
```

**关键点**：状态同步发生在 **SIO 开始跑之前**，而且目标是**每个镜像核**，不是共享一份。

### 3.3 槽位映射（`B25kr6.A2egSU(int rtt, int i2)`）

```
玩家数 1: slot = i2 + 1
玩家数 2: slot = i2==0 ? 0 : (i2==1 ? 2 : 3)
玩家数 3: slot = i2==0 ? 1 : (i2==1 ? 0 : 3)
玩家数 4: slot = 2 - i2
```
`Console.A2egSU()` 另有一套"本地自动槽位"：同 ROM 的 Console 里取最低空闲位 0..3，非 0 槽会额外加载 `xxx<N+1>.sav`。

## 4. 与我们的实现对比（差异清单）

| 环节 | GBoy | 我们（当前） | 影响 |
|---|---|---|---|
| 游戏数据通道 | P2P 直连 TCP（或 KCP/UDP） | WSS 中继隧道，单帧 ≤100 字符 | 我们**没法发 savestate**；每帧多一跳 |
| 状态同步 | 握手期 `type6` 把 host 的 savestate 灌进每个镜像核 | 无（镜像核只读电池存档） | **两核起步状态不同 → SIO 永远等不到同一子状态（st=4 后双向 park）** |
| 按键 | `type9 int mask`，每对端一路 | 有（12Hz/边沿） | 基本等价 |
| 核数量 | 每端 = 1 可见核 + (N-1) 镜像核 | 4 核/端（含空 NPC 位） | GBoy 不需要 NPC 位，因为状态同步后核数=玩家数即可 |
| 节奏 | `type0` 下发 fps 上限，60Hz 闸 | 无 | 次要 |
| 断线 | `AmA8tU.ARc23Z()` 带 10 字节重连握手 | 无 | 次要 |

## 5. 落地顺序（三端同步）

> **范围修订（2026-11-14 23:0x）**：本文件早期写过「KCP/UDP 打洞、蓝牙 RFCOMM、
> gboy.top 的 WSS 后端不在范围内」。按最终指示**全部照抄**，不再有例外清单。
> 照抄的意思是「同样的分层、同样的线格式、同样的时序」；实现载体允许是我们
> 已有的等价物，但行为必须对得上。

1. **游戏通道一律 P2P**：WSS 只做房间信令。TCP 直连（`ServerSocket.accept`
   / `Socket.connect`）与 KCP-over-UDP（打洞 + `PING`/`PONG`/`DISC` + 心跳）
   两条都要有；PC 侧对应 `KcpChannel`（KCP 参数与大端头照抄）与
   `DirectLink`（UDP 打洞 + 自带可靠层，线格式 `MBLD` v1）。
2. **加 `type6` 状态同步**：两端各把可见核 savestate 推给对端，对端灌进
   「代表这个玩家」的那颗镜像核（按槽位，不灌全部），成功后才 arm SIO。
   整份状态约 790 KiB，所以**必须**分片：GBoy 靠 KCP 的 `frg`，我们的
   `DirectLink` 加 `TYPE_FRAG`（首片带总长 + 续片，窗口 48）。
3. **核布局回到「1 + (N-1)」**：GBoy 每端 = 1 可见核 + (N−1) 镜像核，不需要
   NPC 位。我们这款 gen8 改版要求 4 人才放开球场（2 核被锁位），所以固定
   4 核；slot 3/4 是 NPC 陪位，**永远不喂对端存档**。
4. **PC / Android / iOS 共用同一套线格式**，三端只做参数与 UI 接线。
5. **蓝牙 RFCOMM**：UUID `3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47`、服务名
   `GBoy`、服务端 `listenUsingRfcommWithServiceRecord` / 客户端
   `createRfcommSocketToServiceRecord`，字节流上就是同一套
   「4B 大端长度 + u16 type」帧。**iOS 没有经典蓝牙 RFCOMM API**（Apple 只
   开放 BLE／MFi），这一条只能到 Android + PC，iOS 侧留 BLE 通道。
6. **WSS 后端**：`join_room` / `send_message` / `leave_room` /
   `update_room_settings`，字段 `action`+`token`+`uuid`+`roomID`。我们
   `GbCloud` 已经在说这套协议（gboy.top 的服务器），照抄即等价于「后端不变」。

> 三端对照：PC `src/platform/qt/{KcpChannel,DirectLink,CloudLink,GBoyLinkSession}.cpp`、
> Android `io.mgba.android.{KcpChannel,GBoyDirectLink,GBoyCloudLink,GBoyLinkSession}`、
> iOS `ios/mGBA/GBoyLink.swift`。任何一端改线格式，三端必须同时改。
