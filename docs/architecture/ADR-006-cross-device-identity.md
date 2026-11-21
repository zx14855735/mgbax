# ADR-006 · 跨设备身份硬核验：不同邮箱 + 不同 IP

- 状态：**判据已定义 / 验收工具已落盘；当前 APPHUNT-FINAL 证据 = FAIL（IP 不满足）**。
- 日期：2026-11-18（跨设备身份核验 agent 落盘）。
- 相关：`ADR-004-cross-device-2p-cloud-closeout.md` §0.1（跨设备三硬前提）、
  `ADR-002-2p-patha-capability-negotiation.md`、
  `tools/cloud2p_avd.py`（`--pc-acc` / `DEF_PC_ACC` / `DEF_APP_ACC` / summary 落盘）、
  `tools/cloud2p-duo.py`（`p2p_result()` / `kv()`）、
  `tools/cross_device_identity_check.py`（本 ADR 的机器可读验收工具）、
  `tools/cloud2p_cross_device.sh`（账号/uuid/启动时序前提）。

> **纪律**：事实与推断分列；不把「UUID 不同」冒充「邮箱不同」，不把「中继节点 IP」
> 冒充「端 IP」，不把「candidate 列表不同」冒充「明文公网出口 IP 不同」。
> 所有结论必须绑定具体 run 目录 + 原始日志行。用户硬要求「两端使用不同 IP 和不同
> 邮箱登录」，**缺一不可**：任一 FAIL 则整体 IDENTITY=FAIL。

---

## 1. 硬要求与核验对象

用户原话：「请确保两端使用的是不同 IP 和不同邮箱登录」。这是**登录身份**层面的两条
硬证据，与 ADR-004 §0.1 的「跨设备三前提」对应：

| 硬证据 | 对应 ADR-004 前提 | 本 ADR 的机器可读字段 |
|---|---|---|
| 不同邮箱 | ①两个不同云端账号 | `EMAIL_DISTINCT` |
| 不同 IP | ③两台物理上分开的设备/端到端（云端看到不同来源 IP） | `IP_DISTINCT` |

UUID 不同（`uuid_app != uuid_pc`，来自不同 ROM md5）是 ADR-004 前提②，**是补充证据，
不能替代邮箱不同，也不能替代 IP 不同**。

---

## 2. 不同邮箱的核验

### 2.1 判据

- PC 账号：`tools/cloud2p_avd.py` 的 `--pc-acc`（默认 `DEF_PC_ACC = 525612743@qq.com:14855735`），
  邮箱部分 = `pc_acc.split(":", 1)[0]`。
- App 账号：`--app-user`（默认 `DEF_APP_ACC = zx14855734@gmail.com:14855735`），
  邮箱部分 = `app_user`。两端默认即不同域名（gmail.com vs qq.com）。
- **核验方法**：取两端邮箱，做去空格、去 `:` 后密码、大小写归一化的字符串比较；
  `email_app != email_pc` → `EMAIL_DISTINCT=PASS`，否则 `FAIL`。

### 2.2 现有字段与缺口

- driver summary 现有 `accounts_distinct=True`，其生成式就是
  `app_user != args.pc_acc.split(":", 1)[0]`（cloud2p_avd.py:1549），
  **语义上已经是邮箱级比较**，可作 MEDIUM 证据。
- 但 summary **没有落明文邮箱地址**：`uuid_app`/`uuid_pc` 是 ROM UUID 不是账号；
  `avd_driver.log` 只出现 PC 邮箱（`MGBAX_AUTOLINK=525612743@qq.com:…:678752`），
  App 邮箱被驱动省略。因此当前无法在 run 内做「两个明文邮箱逐字符对比」。

### 2.3 需 APPHUNT 补落的字段（向编排器请求，本 agent 不改 driver）

在 `tools/cloud2p_avd.py` 的 summary 追加：

```
email_app=<app_user 的邮箱部分>
email_pc=<pc_acc split(':')[0]>
```

工具会自动识别 `app_email/email_app/app_user/app_account/app_acc` 与
`pc_email/email_pc/pc_user/pc_account/pc_acc` 等别名；一旦两端明文邮箱齐备，
`EMAIL_DISTINCT` 证据等级从 MEDIUM 升为 STRONG。

---

## 3. 不同 IP 的核验

### 3.1 信号源（都是**本端自己宣告**的候选地址，不是中继）

两端 DirectLink 都会把本端候选地址写进日志，格式：

- PC：`pc_tmp/mgba_lobby_debug.log`
  - `[direct] me=1366690c 候选 192.168.1.5:63213,172.18.0.1:63213,36.251.93.252:26128 / 本地端口 63213`
  - `[MGBAX_P2P] me=1366690c event=announce count=3 list=192.168.1.5:63213,...`
  - `[MGBAX_P2P] me=1366690c event=result ... localCandidates=3 directEnabled=1 via=p2p`
- App：`app_logcat_full.log`（`app_logcat.log` 为短窗口回退）
  - `[direct] me=83cc989a6af84b79 候选 [36.251.93.252:26127, 10.0.2.16:45147] / 本地端口 45147`
  - `[MGBAX_P2P] me=83cc989a6af84b79 event=result ... peerCandidates=3 ... peer=192.168.1.5:63213`

注意区分三类地址：

1. **中继节点地址**：`GBoyCloud ... node_address:47.103.87.123`。两端都连它，
   **不算端 IP**，工具显式排除（`node_address` 出现的 IP 加入排除集）。
2. **私有/loopback 候选**：`10.0.2.16`（AVD NAT）、`192.168.1.5`、`172.18.0.1`（Docker 桥）。
   只能作弱/中证据，不能当「不同公网出口 IP」。
3. **公网出口（WAN）候选**：用 Python `ipaddress.ip_address(x).is_global` 判定。
   这才是云端登录看到的来源 IP，是 STRONG 判据的依据。

`[MGBAX_P2P] event=peer-candidates ... list=...` 是**对端**候选（从本端视角看到的对方），
与对端自己宣告的 `候选` 互为镜像；工具只把「本端 `候选` / `event=announce`」当成该端
自己的出口 IP 来源，避免把 peer 列表误认成自己。

### 3.2 判据（STRONG 优先，MEDIUM 回退）

1. **STRONG**：两端各自的明文公网出口 IP 都取到：
   - `app_public_ip != pc_public_ip` → `IP_DISTINCT=PASS`（证据等级 STRONG）
   - `app_public_ip == pc_public_ip` → `IP_DISTINCT=FAIL`（证据等级 STRONG，
     同一 NAT/同一物理主机，即便端口不同、candidate 列表不同也不能算 PASS）。
2. **MEDIUM 回退**：任一端取不到明文公网 IP，但两端 localCandidates 集合不同
   **且** p2p 直连成功（`event=result result=ok` + `directEnabled=1` / `P2P 已启用`，
   非同一进程回环）→ `IP_DISTINCT=PASS`，证据等级标 MEDIUM（弱证据，如实标注）。
3. **UNOBSERVED**：既无明文公网 IP，也无 candidate 差异 + p2p 成功组合。
4. **WEAK**：仅账号/邮箱不同，无任何 IP 证据——不满足用户硬要求，`IDENTITY` 不可能是 PASS。

### 3.3 需 APPHUNT 补落的字段（向编排器请求）

若 driver 能直接读两端出口 IP（例如向云端查询登录来源 IP 或在 WebSocket 握手处取本机
出口），在 summary 追加：

```
public_ip_app=<app 公网出口 IP>
public_ip_pc=<pc 公网出口 IP>
```

工具优先采用这两个字段（别名 `app_wan_ip` / `pc_wan_ip` / `app_egress_ip` 等），
与日志派生值交叉校验；字段齐备时 IP 判据直接 STRONG。

### 3.4 已落地的 driver 字段：仅交叉核对，**不可作判据**

APPHUNT 已按请求在 commit `2d6ff86ea` 给 `tools/cloud2p_avd.py` 加了：

- `email_app=<masked> email_pc=<masked> accounts_distinct_email=<bool>`：邮箱是**掩码**
  （`zx1***557435` / `525***557435`，`mask()` 保留前 3 后 6），**无法做明文逐字符比较**。
  工具识别 `***` 后拒绝把它们当 STRONG 邮箱证据，继续用 `accounts_distinct` /
  `accounts_distinct_email` 布尔断言（MEDIUM）。需 APPHUNT 落**未掩码**邮箱才能升 STRONG。
- `ip_local_PC=<ip> ip_local_APP=<ip> ip_distinct=<true|UNOBSERVED> ip_peer_from_PC=<ip>`：
  由 `identity_evidence().pick_ip()` 从**倒序**的含 `[MGBAX_P2P]`/`[direct]` 行里抓第一个
  IP（只排除 `47.103.87.123`/`10.*`/`127.*`）。这些行大量是 `peer=` / `忽略来自` 的
  **对端地址**，因此会张冠李戴：
  - APPHUNT-FINAL 里 PC 日志末段 `[direct] p2p-rtt ... peer=36.251.93.252:26127`
    被当成 `ip_local_PC=36.251.93.252`（其实是 app 的出口 IP）；
  - app 日志 `[MGBAX_P2P] ... peer=192.168.1.5:63213` 被当成
    `ip_local_APP=192.168.1.5`（其实是 PC 的私有 IP）；
  - 于是 `ip_distinct=true` 是**假 PASS**（两端实际同为 `36.251.93.252`）。

**本工具不采信 `ip_local_*` / `ip_distinct` 作判据**，只输出 `DRIVER_CLAIM=...` 与
`DRIVER_IP_MISMATCH=True/False` 供编排器核对，判据仍以两端 `候选` / `event=announce`
的本端列表为准。这是「不把对端 IP 冒充本端 IP」的证据纪律要求。
修法建议给 APPHUNT：`pick_ip` 只从 `候选 ... / 本地端口` 与 `event=announce ... list=`
行取本端 IP，或直接只落原始候选行由 `cross_device_identity_check.py` 解析。

---

## 4. 证据等级定义

| 等级 | 含义 | IP_DISTINCT 依据 |
|---|---|---|
| **STRONG** | 两端明文公网出口 IP 已取到并比较（相同 → FAIL，不同 → PASS） | 明文 `候选`/`announce` 里的 global IP，或 summary 显式 `public_ip_*` |
| **MEDIUM** | 无明文公网 IP，但 candidate 列表不同 + p2p 直连成功（非回环） | localCandidates 集合差异 + `result=ok&directEnabled=1` |
| **WEAK** | 仅账号/邮箱不同 | 无 IP 证据 |
| **NONE** | 什么都没观测到 | — |

`IDENTITY` 汇总：任一为 FAIL → `FAIL`；否则任一 UNOBSERVED → `UNOBSERVED`；
两者都 PASS → `PASS`。工具退出码：0=PASS、1=FAIL、3=UNOBSERVED（与
`tools/speed_parity_check.py` 一致）。

---

## 5. 当前证据：APPHUNT-FINAL（自测结果）

Run 目录：`.zcode-tmp/cloud2p/APPHUNT-FINAL/`

- **邮箱：PASS（MEDIUM）**。`summary.txt` 有 `accounts_distinct=True`；
  `avd_driver.log:33` 有 PC 邮箱 `525612743@qq.com`；App 邮箱未明文落盘。
  默认值为 `zx14855734@gmail.com` vs `525612743@qq.com`，不同域名。
- **IP：FAIL（STRONG）**。两端 `候选` 里的公网出口 IP **相同**：
  - PC `pc_tmp/mgba_lobby_debug.log:60`：`候选 ... 36.251.93.252:26128`
  - App `app_logcat_full.log:925`：`候选 [36.251.93.252:26127, 10.0.2.16:45147]`
  - 两者 global IP 都是 `36.251.93.252`（端口 26128 vs 26127 不同，但 IP 相同）。
  - `47.103.87.123` 是 `node_address` 中继，已排除。
  - p2p 直连确实成功（PC 连 `36.251.93.252:26127`，App 连 `192.168.1.5:63213`），
    但这是**同一台 Windows 主机上的 PC 进程 + AVD 模拟器**，经同一个 NAT 出口，
    云端看到的是同一个公网 IP——不满足「不同 IP 登录」硬要求。
- **IDENTITY=FAIL**，证据等级 STRONG（强证据证明 IP 相同）。
- **与 driver 新字段的对账**：新 driver 的 `ip_local_PC/ip_local_APP/ip_distinct` 是
  启发式抓 `peer=` 行得到的，会把 app 的 `36.251.93.252` 误标成 PC 本地 IP、把 PC 的
  `192.168.1.5` 误标成 app 本地 IP，从而给出假 `ip_distinct=true`。工具输出
  `DRIVER_IP_MISMATCH=True` 并不采信，仍判 FAIL（见 §3.4）。

> 这不是工具误判：它如实暴露了当前「跨设备 AVD」拓扑的本质——PC 与 AVD 同机同 NAT。
> 要拿到 `IP_DISTINCT=PASS`，必须让两端处于**不同公网出口**：PC 在办公室/有线网络、
> Android 真机走蜂窝数据（或接另一条宽带/代理），再跑同一驱动并落盘。

---

## 6. 验收工具用法

```bash
# 人类可读判定
python tools/cross_device_identity_check.py .zcode-tmp/cloud2p/APPHUNT-FINAL

# 机器可读
python tools/cross_device_identity_check.py .zcode-tmp/cloud2p/<新 run> --json

# 新 dist AC4808ED 的 run（假设 tag=AC4808ED-FINAL）
python tools/cross_device_identity_check.py .zcode-tmp/cloud2p/AC4808ED-FINAL
```

工具**只读** run 目录，不改 driver、不写任何文件；自动发现 PC lobby log 与 app logcat，
支持 summary 新增的明文邮箱/公网 IP 字段。输出 `IDENTITY` / `EMAIL_DISTINCT` /
`IP_DISTINCT` / `EVIDENCE_LEVEL` 及逐行证据（含日志行号与原文片段）。
