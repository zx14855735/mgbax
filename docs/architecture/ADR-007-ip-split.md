# ADR-007：跨设备不同公网出口 IP（VPN 分流）

- 状态：已实测 PASS（2026-11-18，run `VPNSPLIT-1`）
- 关联：ADR-006（跨设备身份判据）、`tools/cross_device_identity_check.py`

## 1. 背景与结论

本机只有一台 Windows 主机 + 一个 AVD（emulator-5554）。两端共用宿主 NAT，
普通跑法下 STUN 映射出的公网出口 IP 相同，`IP_DISTINCT=FAIL`（APPHUNT-OPP 实测两端均
`36.251.93.252`）。

调研发现宿主已存在一条 **sing-tun 隧道 `utun99`（172.18.0.1/30，peer 172.18.0.2）**，
它带有覆盖绝大多数公网段的策略路由。于是本机天然有 **两个真实、global 的公网出口**，
无需再启动 ZoogVPN：

| 路径 | 本地源地址 | 实测公网出口 | 备注 |
| --- | --- | --- | --- |
| WLAN 直连 | 192.168.1.5 | `36.251.93.252` | 物理出口，稳定 |
| utun99 隧道 | 172.18.0.1 / 默认路由 | 轮换（实测 `31.223.184.138` → `85.234.83.231`） | VPN 出口，global |

实测（STUN / HTTP 双通道）：

```
PC 默认源 -> stun.miwifi.com(111.206.174.3) = 36.251.93.252   # 走 WLAN
PC 默认源 -> stun.l.google.com(74.125.250.129) = <隧道出口>     # 走 utun99
绑定 192.168.1.5 -> 任意 STUN = 36.251.93.252                 # 强制 WLAN
AVD miwifi STUN = 36.251.93.252 ; AVD Google STUN = <隧道出口>  # AVD 随目的地址选路
```

## 2. 分流原理

两端 App 都是「先问 `stun.miwifi.com:3478`，失败才回落 `stun.l.google.com:19302`」
（`src/platform/qt/DirectLink.cpp`、`android/.../GBoyDirectLink.java`）。
而 miwifi STUN 的目的 IP 走 WLAN，Google STUN 的目的 IP 走隧道。

因此只要让 **AVD 的 miwifi STUN 探测失败**，AVD 就会回落到 Google STUN，映射到隧道出口；
PC 保持原样，仍经 miwifi 映射到 `36.251.93.252`。两端候选里出现两个不同公网 IP，
`cross_device_identity_check` 即判 `IP_DISTINCT=PASS / STRONG`。

选择用 **AVD 内 iptables 丢弃 UDP/3478** 实现，而不是改 Windows hosts / 全局路由：

- 无管理员权限也能做（adb root 即可）；
- 只影响 AVD 一个进程组，不动宿主路由，**不破坏在途 agent 网络**；
- 一条规则、可秒级回滚。

## 3. 操作命令

### 3.1 执行前检查（硬约束）

```powershell
Get-Process python,mGBA -ErrorAction SilentlyContinue   # 必须为空
Get-ChildItem .zcode-tmp\cloud2p -Directory | Sort LastWriteTime -Desc | Select -First 3
```

若有活跃对战 run（python/mGBA 在跑），**不要执行分流**，只写脚本等协调窗口。

### 3.2 应用分流（AVD 内）

```powershell
adb root
adb shell 'iptables -C OUTPUT -p udp --dport 3478 -j DROP 2>/dev/null || iptables -A OUTPUT -p udp --dport 3478 -j DROP'
adb shell 'iptables -S OUTPUT | grep 3478'
```

作用：AVD 所有 UDP/3478（= miwifi STUN）被丢弃 → App 回落 Google(19302) → 隧道出口。
PC 端不受影响，仍用 miwifi → WLAN 出口。

### 3.3 验证两端出口不同（无需跑完整对战）

```powershell
python .zcode-tmp/stun_probe.py ''                 # PC：miwifi=36.251.93.252, google=<隧道>
python .zcode-tmp/avd_stun_probe.py                # AVD：miwifi=TIMEOUT, google=<隧道>
```

`.zcode-tmp/avd_stun_probe.py` 会打印 AVD 两个 STUN 的映射；应用规则后 AVD 的 miwifi 行应
超时、google 行给出隧道出口。两端出口不同即成立。

### 3.4 跑一次真实对战验收

```powershell
python tools/cloud2p_avd.py --tag VPNSPLIT-1 --mode A --runsec 480 `
  --no-emulator --serial emulator-5554 --app-nav --fast-early `
  --fast-min-ok-slave 8 --fast-slave-align 4 `
  --env MGBAX_SIO_CONNECT_POLL=0 --env MGBAX_SIO_FAST=0 `
  --env MGBAX_SEAT_ASSIST=1 --env MGBAX_CLOSE_GRACE=1 `
  --env MGBAX_GBOY_BATTLE_LO=080B30C0 --env MGBAX_GBOY_BATTLE_HI=080BCA78

python tools/cross_device_identity_check.py .zcode-tmp/cloud2p/VPNSPLIT-1
```

预期：`EMAIL_DISTINCT=PASS`（默认两账号邮箱不同）、`IP_DISTINCT=PASS`、`IDENTITY=PASS`、
`EVIDENCE_LEVEL=STRONG`，证据行给出 `IP_APP_PUBLIC=<隧道出口>` 与
`IP_PC_PUBLIC=36.251.93.252`。

## 4. 风险与回滚

- **隧道出口轮换**：VPN 出口 IP 会变（已观测 31.223.184.138 → 85.234.83.231），
  但始终 ≠ 36.251.93.252；判据是「不同」而非固定值，不受影响。
- **P2P 打洞**：两端走不同出口后，PC→AVD 的公网映射路径依赖 VPN 网关 hairpin，可能不通；
  但 AVD→PC 的 `192.168.1.5` 本端路径在既有 run 已验证可用，且失败时会回落 relay，
  不影响 `IP_DISTINCT`（STRONG 只看两端明文公网候选，不依赖 P2P_DIRECT_OK）。
- **iptables 规则随 AVD 重启丢失**：重启后需重新执行 3.2。
- **影响范围**：仅 AVD UDP/3478；宿主进程与其他 agent 的路由完全不变。

回滚：

```powershell
adb shell 'iptables -D OUTPUT -p udp --dport 3478 -j DROP'
adb shell 'iptables -S OUTPUT | grep 3478'   # 应无输出
```

回滚后 AVD 重新用 miwifi STUN → 两端同为 36.251.93.252，恢复原状。

## 5. 实测结果（2026-11-18，run `VPNSPLIT-1`）

真实 AVD↔PC 对战跑通（`BATTLE=YES`，`room=743465`，PC 端 `rem=1`），身份验收：

```
EMAIL_DISTINCT=PASS
IP_DISTINCT=PASS
IDENTITY=PASS
EVIDENCE_LEVEL=STRONG
IP_APP_PUBLIC=31.223.184.138  # app_link_startup.log:811 [direct] 候选
IP_PC_PUBLIC=36.251.93.252    # mgba_lobby_debug.log:58  [direct] 候选
```

验收命令（app 侧日志必须指向含 `[direct] 候选` 的 `app_link_startup.log`；
全量 logcat 会被 tunnel push 刷屏挤掉开局行，驱动已把 `-t` 从 12000 提到 120000）：

```powershell
python tools/cross_device_identity_check.py .zcode-tmp/cloud2p/VPNSPLIT-1 `
  --app-log .zcode-tmp/cloud2p/VPNSPLIT-1/app_link_startup.log
```

### 为实现 PASS 做的两处最小改动

1. `android/.../GBoyDirectLink.java`：回落 STUN（Google）超时 900ms → 8000ms。
   隧道出口到 Google STUN 往返实测 ~5s，900ms 会导致 AVD 拿不到公网映射；
   首选 miwifi 仍是 900ms，正常路径无额外等待。APK 已重建并安装到 AVD。
2. `tools/cloud2p_avd.py`：全量 logcat `-t 12000` → `120000`，避免候选行被刷掉。

### 已知副作用（需 parent 决策是否保留）

- P2P 打洞 `no-agree`，对战回落 relay（`via=tunnel`，RTT ~247ms）。STRONG 判据只看
  两端明文公网候选，不依赖 P2P_DIRECT_OK，故 PASS 成立；但战斗质量较纯 WLAN 直连差。
- 当前 AVD iptables 规则与 APK 保持已应用状态（保证后续 run 也分流）。若需恢复原状，
  执行 §4 回滚 + 重装旧 APK（git 恢复源码后重编）。

## 6. 不做什么

- 不启动 ZoogVPN / 不改全局默认路由 / 不装 ForceBindIP（会打断在途 agent）。
- 不改 `cross_device_identity_check.py` 任何判据；不伪造 summary 字段。
- 拿不到不同 IP 就如实报 FAIL / 受环境限制。
