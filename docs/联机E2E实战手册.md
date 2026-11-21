# 联机 E2E 实战手册

> 性质：**操作指引**，不是成功声明。本文所有结论均从仓库内既有真实材料归纳（见 §0 来源表），未新跑任何 E2E、未改源码/工具/产物。
> 铁律：判定优先级 `FAIL > UNOBSERVED > PASS`；`UNOBSERVED`（证据不足）永远不等于 PASS。
> 当前总门 = **FAIL**（对战里程碑达成但闭环待证；对手 `? Lv0`、视觉未闭环、帧率 STUTTER FAIL、IDENTITY FAIL）。任何局部绿灯都不得改写这个总状态。

---

## 0. 本文归纳来源与权威性说明

| 来源（路径均已核对存在） | 提供内容 |
|---|---|
| `production/联机实现全过程.md` | 唯一权威结论文档（当前状态 FAIL、三标准、证据纪律、复现入口） |
| `tools/speed_parity/RUNBOOK.md` | 版本库内的 speed parity 操作手册（wire 映射、基线、判读流程） |
| `.zcode-tmp/speed-parity/RUNBOOK.md` | 内部实战版（8 条工具坑、已实测基线；被忽略未入库） |
| `.zcode-tmp/P4_abdesign.md` | B7 块中继 A/B 四组命令模板、fail-fast 判据链 |
| `.zcode-tmp/H14_env_precheck.md` | Run C 实际命令原文（第 24 行）与环境预检 |
| `.zcode-tmp/H15_gate_matrix.md` | gate 矩阵、判据真伪、当前门 FAIL 分析 |
| `.zcode-tmp/H18_ios_static.md` | iOS 控制面静态验证、swift gate 覆盖缺口 |
| `.zcode-tmp/H8_vpn_identity.md` | VPN 分流命令与身份验收时机 |
| `.zcode-tmp/P10_finalaccept.md` | 三标准终极验收清单、一票否决项 |
| `.zcode-tmp/P16_delivery.md` | 交付完整性核对（产物 md5、悬空引用、release 过期） |

**关于"哪份 RUNBOOK 权威"的判定**：

- **版本库权威** = `tools/speed_parity/RUNBOOK.md`（tracked、可长期引用；权威文档 `production/联机实现全过程.md` 的"复现入口"与 P10/§1.3 均指向它）。
- **实战细节权威** = `.zcode-tmp/speed-parity/RUNBOOK.md`（含 8 条关键工具坑与已落盘基线 1x=60.100、2x=123.300，但被 `/.zcode-tmp/` 忽略、未入库）。
- 结论：跑 E2E 时**两份都要读**——前者是正式引用入口，后者才是真正可执行的知识。因后者未入库，本文把关键坑内联在 §2.3 与 §3，避免再次丢失。

> 说明：P16 发现顶层文档存在若干指向"不存在文档"的悬空引用。本文**不引用任何不存在的文档路径**，所有引用的路径在文末 §7 统一核对；悬空引用本身不在本文职责内（本文只新建 docs/ 文档）。

---

## 1. E2E 命令模板

### 1.1 权威入口与倍速 wire 映射

`tools/speed_parity/RUNBOOK.md` 规定：倍速 R → type-9 wire 值 `1e9 / (rate * 60)`，三端必须一致。

| 倍速 | 0.5x | 1x | 2x | 4x |
|---|---|---|---|---|
| wire | `-1` | `1` | `2` | `4` |

- PC 端：启动驱动带 `--env MGBAX_SPEED_9=1`，并在驱动 script dir 写 `speed` 文件（内容 `1`/`-1`/`2`/`4`）；日志证据 `[gboy] speed hook: <wire>`、`[gboy] type 9 speed sent: <wire>`。
- Android 端：`adb shell am broadcast -a io.mgba.android.action.SPEED --ei value <wire>`；日志证据 `speed broadcast value=<wire>`。
- 1x 是产品默认值（断链复位到 1x），未看到 override 也可判 PASS；**R>1 必须有日志 wire 证据**。
- 先看完整计划（不落地）：`python tools/speed_parity_check.py --speed 2 --dry-run`。

### 1.2 Run C 实际命令（跨设备 AVD 基线，权威 run）

来源 `.zcode-tmp/H14_env_precheck.md:24`，tag `MIN-ADVANCE`：

```powershell
python tools/cloud2p_avd_vis.py --tag MIN-ADVANCE --mode A --runsec 480 --no-emulator --serial emulator-5554 --app-nav --fast-early --env MGBAX_RH_OFF=1 --env MGBAX_FORCE_EXCHANGE=0 --env MGBAX_HANDOFF_GUARD=0 --env MGBAX_RH_VERBOSE=0 --env MGBAX_SEAT_ASSIST=1 --env MGBAX_CLOSE_GRACE=1 --env MGBAX_SIO_CONNECT_POLL=0 --env MGBAX_SIO_FAST=0
```

配套固定产物：dist `build-win/dist/mGBA.exe`（MD5 `5055EE9F…`）、APK `android/app/build/outputs/apk/debug/app-debug.apk`（MD5 `AF57189E…`）。`--no-emulator` 表示复用**已启动的**新 dist 实例，须确认该进程加载的确是新 dist。

### 1.3 P4 的 A/B 命令模板（B7 块中继实验，只读设计方案）

来源 `.zcode-tmp/P4_abdesign.md` §5。两个**正交**轴：`RH_OFF`（PC `MGBAX_RH_OFF`，Android `debug.mgbax.link.rh_off`）与 `RELAY`（PC `MGBAX_BATTLE_RELAY`，Android `debug.mgbax.link.battle_relay`），默认都 OFF。四组：

| 组 | tag | RH_OFF | RELAY | 价值 |
|---|---|---|---|---|
| G1 | `B7-RH1-REL0` | 1 | 0 | 阴性对照（= Run C 现状） |
| G2 | `B7-RH1-REL1` | 1 | 1 | **目标组**（零注入 + 块中继） |
| G3 | `B7-RH0-REL0` | 0 | 0 | 全注入旧态对照 |
| G4 | `B7-RH0-REL1` | 0 | 1 | 混合，仅诊断，**不得证明 B7 生效** |

G2（其余组只改 tag 与两轴，其余字节完全一致）：

```powershell
python tools/cloud2p_avd_vis.py --tag B7-RH1-REL1 --mode A --runsec 480 --no-emulator --serial emulator-5554 --app-nav --fast-early --env MGBAX_RH_OFF=1 --env MGBAX_BATTLE_RELAY=1 --env MGBAX_FORCE_EXCHANGE=0 --env MGBAX_HANDOFF_GUARD=0 --env MGBAX_RH_VERBOSE=0 --env MGBAX_SEAT_ASSIST=1 --env MGBAX_CLOSE_GRACE=1 --env MGBAX_SIO_CONNECT_POLL=0 --env MGBAX_SIO_FAST=0
```

> 诊断专用：末尾追加 `--env MGBAX_BATTLE_RELAY_VERBOSE=1`，不与验收混用。
>
> **开跑前阻塞前置（P4 §0.3，务必满足，否则整组作废）**：① 驱动须补 `setprop("debug.mgbax.link.battle_relay", …)` 一行，日志见 `readback=1`，否则 app 侧门恒 0（PC-on/app-off 半开态）；② 新 dist md5 ≠ `5055EE9F…` 且与新 APK 同 commit；③ 视觉抓窗已按本轮 PC PID 过滤（FIXSCREEN）；④ 门是**进程启动时静态缓存**，必须全新进程 + 全新会话，不能热切。

### 1.4 跑完后的收口顺序（fail-fast，禁止跳步）

来源 P4 §2/§5.4、P10 §5、H15 §3：

1. 先按 Step 1 握手不退化 → Step 2 对手框 ≠ `? Lv0` → Step 3 文字框有字 → Step 4 视觉硬门 → Step 5 帧率/parity 逐步判定；**第 N 步 FAIL 就停在第 N 步**，后续一律不执行、不报 PASS。
2. 再跑 gate：`frame_stutter_check`（BATTLE/STUTTER）→ `battle_visual_gate`（本轮 PC PID 截图）→ `speed_parity_check`（`opponent_data_real` 须引用前两步机器可读结果，不得手写 True）。`diff_party_check` **仅在 RH_OFF=0 的 G3/G4 有意义**，G1/G2 零注入下标签消失属预期 `UNOBSERVED`，不得记 FAIL。
3. 所有产物（summary、截图、日志、verdict JSON）必须绑定**同一 tag + 同一 dist md5 + 同一 APK md5 + 同一 commit**；跨 run 拼凑的 PASS 不成立。

---

## 2. 判据工具清单与用法

通用：`FAIL > UNOBSERVED > PASS`；缺证据记 UNOBSERVED，不凑阈值、不伪造字段。

### 2.1 `tools/battle_visual_gate.py` —— 战斗画面的视觉硬门槛（唯一不读日志的 gate）

- **一句话用途**：直接看 PC 战斗截图像素，独立判定"画面不是卡死/空框"。
- **用法**：`python tools/battle_visual_gate.py <run_dir> [--json-out PATH]`
- **PASS 条件**：`VISUAL_GATE=PASS`，即 `HP_BAR`（对手框绿像素 G>120 且 G>R+40/G>B+40 占比≥30%、连续绿列≥30%）+ `TEXTBOX`（浅色框底连续≥10 行且深笔画占比>0.5%）+ `LIVENESS`（三帧关键区差异>0）三项全 PASS；截图须来自本轮 PC PID。
- **常见假阳性陷阱**：
  - 抓错窗口：`find_window()` 取首个可见 mGBA 窗口、不分 PID，Run C 抓到别的 agent 实例（标题 `0.11-9601-e34796963` ≠ 本轮 `0.11-10027-dirty`）→ 应记 `UNOBSERVED` 而非 `FAIL`（FIXSCREEN / commit `be8b2011f` 已按 PID 过滤）。
  - 它只证"画面非卡死"，**不证"对手是哪只精灵"**；对手真实性须靠 `diff_party_check` 的 CROSSED。

### 2.2 `tools/diff_party_check.py` —— 差分 party 实验（唯一结构性"对手真实"判据）

- **一句话用途**：验证两端对手框是否**交叉**（APP 显示 PC 首位、PC 显示 APP 首位），排除自我回显。
- **用法**：`python tools/diff_party_check.py <run_dir> [--json]`；`--self-test` 自测。`exit 0=CROSSED(PASS) / 1=SELF_ECHO(FAIL) / 3=UNOBSERVED / 2=输入错误`。
- **PASS 条件**：`CROSSED` —— 实验设定 PC 首位=喷火龙 `0x0006`、APP 首位=壶壶 `0x00D5`；APP 对手框=`0006` 且 PC 对手框=`00D5`，两端交叉。
- **常见假阳性陷阱**：
  - 侧别判定依赖注入期标签 `PC_ONLY=[RHVIS]/[SPENC]`、`APP_ONLY=[RHREND]/[SPDEC]`；零注入 `MGBAX_RH_OFF=1` 下四类标签全消失 → 恒 `UNOBSERVED`（H3/H15 已证）。**这是当前最大工具缺口：标准 B 在正道下没有可用硬门槛**。
  - `SELF_ECHO`（对手框显示本端自己的 `00D5`）是自我回显铁证，绝不可记 PASS；`ver=4003` trainer 卡、species/name/level/icon 全是我方 party 回显，均不能判对手真实。
  - `0x058B` 是名表长度/越界哨兵（合法 species 范围 `0..0x58A`），不是宝可梦；须按当次 ROM 的 `rom.map` 运行时解析地址，禁止硬编码。

### 2.3 `tools/speed_parity_check.py` —— 双方同倍速帧率 parity

- **一句话用途**：判定"两端同倍速时对战正常且帧率≈单机同倍速"。
- **用法**：`python tools/speed_parity_check.py --from-summary <run> --baseline .zcode-tmp/speed-parity/baseline_2x.txt --speed 2 --json`；`exit 0=PASS / 1=FAIL / 3=UNOBSERVED`。基线用 `--measure-baseline` 或 `--write-baseline` 生成（默认目录 `.zcode-tmp/speed-parity/`）。
- **PASS 条件**：`BATTLE=YES` + `battle_samples>0` + `in_battle_frame` 非 False + `opponent_data_real=True` + 两端 wire 都命中当次倍速 + 双端 in-battle fps ≥ 90% 单机基线 + 双端 fps 差 ≤10% + R>1 时 `baseline(2x)/baseline(1x)` 落在 `[1.5x, 2.67x]`。
- **常见假阳性陷阱**（详见 `tools/speed_parity/RUNBOOK.md` §5 与 `.zcode-tmp/speed-parity/RUNBOOK.md` §0）：
  - `opponent_data_real` 是**人工信任位**：driver 默认永不自动置 True；须人工核对 `<run>/battle_screenshot_*.png` 后才写 True，且应引用 `battle_visual_gate` verdict + `diff_party_check` CROSSED，不得单独手写。
  - `--from-summary` 的 wire 只判集合成员，严格性不足；须人工取每端**最后一条**证据核对同值。
  - `--measure-baseline` 默认 EXE=`build-win/mGBA.exe` 缺 Qt DLL（0xC0000135），须指定 `--exe build-win/dist/mGBA.exe`；窗口 fps 采样不按 PID，同机多实例会串窗，需 PID 过滤采样 + `--write-baseline`。
  - `--dry-run` 示例旧版误写 `--fps`，实际参数是 `--baseline-fps` / `--baseline-1x`（已修）。
  - path A 坑：`MGBAX_SPEED_9` + `speed` 文件**只在 `serveOfficial`（path B）生效**；path A（`--mode A`）须走产品真实入口 `Tools → Speed → 2x`（UIA 自动化 `.zcode-tmp/speed-parity/set_pc_speed.ps1`，按 PID 定位），执行前后用窗口标题 fps 验证（1x≈60、2x≈120）。
  - 大日志（实测 13.49MB）曾被整份跳过丢 2x wire → `speed_app` 误报 UNOBSERVED（已改为流式逐行匹配）；基线找不到也曾致全 UNOBSERVED（已改为同时搜默认目录与 run 目录）。若仍 UNOBSERVED，按 detail 补证据，不要改阈值凑 PASS。

### 2.4 `tools/cross_device_identity_check.py` —— 跨设备身份硬核验

- **一句话用途**：核验两端"不同邮箱 + 不同公网出口 IP"，排除同机同 NAT 与中继节点。
- **用法**：`python tools/cross_device_identity_check.py <run> [--json]`；`exit 0=PASS / 1=FAIL / 3=UNOBSERVED / 2=输入错误`。
- **PASS 条件**：`EMAIL_DISTINCT=PASS` 且 `IP_DISTINCT=PASS` 且 `EVIDENCE_LEVEL=STRONG` → `IDENTITY=PASS`。公网 IP 由两端日志 `[direct] 候选 … / 本地端口` / `[MGBAX_P2P] event=announce … list=` 用 `is_global` 提取，中继 `node_address` 显式排除；相同即 FAIL（同 NAT）。判据详见 `docs/architecture/ADR-006-cross-device-identity.md`。
- **常见假阳性陷阱**：
  - driver 的 `ip_distinct` / `ip_local_PC` / `ip_local_APP` 只作 `DRIVER_CLAIM` 交叉核对，**不作判据**：`pick_ip()` 从倒序日志抓到 `peer=` 对端地址，制造假 `ip_distinct=true`（张冠李戴）。
  - summary 显式 `public_ip_*` / `pc_public_ip` 字段会被直接采信为 STRONG（H8 §5.3 潜在伪造通道，当前所有 summary 无此字段）；邮箱被掩码只能是 MEDIUM，不可冒充 STRONG。
  - VPN 分流规则随 AVD 重启丢失 → 两端都 STUN 到同一出口 → 必 FAIL；须先按 §4.2 apply 再验收。

### 2.5 `tools/frame_stutter_check.py`（FRAMEGUARD）—— 卡帧/断链量化检测

- **一句话用途**：量化"真进战斗 / 卡帧 / 对手真实性"三条平行判据 `BATTLE=` / `STUTTER=` / `OPPONENT=`。
- **用法**：`python tools/frame_stutter_check.py --run-dir <run> --json out.json`；`--self-test` 自测。`--stable-sec 20 --max-gap-ms 33.3 --rtt-spike-ms 100` 可调。
- **PASS 条件**：
  - `BATTLE=PASS`：双端 cb2 ∈ `[0x080B4845, 0x080B48A8)`（BattleMainCB2..FreeRestoreBattleData），用当次 `rom.map` 交叉核对；**单端进战斗不算**。
  - `STUTTER=PASS`：真进主循环、无 dispositive 断链（GLINK rem=0 / LINK_RESET / st=0868/0968 / 通信错误 cb2=0816D8CD / RTT 尖峰≥100ms）、`stable_sec≥20`、最大帧间隔 ≤33.34ms。
  - `OPPONENT=PASS`：`battle_gate==PASS` ∧ `trainer_card_real==PASS`（`[RHPLYR] lp1 ver/tid/name` 非零且 `ver≠0xFFFF`）∧ `species_real==PASS`（`[OPPSPECIES]` species 合法 `1..0x0FFF`）。
- **常见假阳性陷阱**：
  - `BATTLE=PASS` / `OPPONENT=PASS` **仅数据层、权威文档明禁作成功判据**：cb2/species 都是 driver 打印的文本，写一行即可伪造；`OPPONENT=PASS` 只判"species 合法非零"，不判"是不是对端 party"。
  - `STUTTER=PASS` 本质是"没有出现失败签名"，可被"不写失败行 + 造干净时间戳"伪造；它是优秀的**反假阴性诊断工具**，不是反造假工具。
  - 进战斗过渡黑屏（仅短暂 fps dip、rem 保持 1、无错误态）记 `TRANSITION_BLACKSCREEN`，**不算卡帧**。
  - 时钟纪律：app logcat（06:xx）与 PC（14:xx）相差 8 小时时区，**绝不跨时钟做差**；稳定时长只用 app 单一时钟。

### 2.6 三条标准的最小充分 PASS 组合（H15 §3.1）

```
A 对战稳定 = FRAMEGUARD(BATTLE=PASS ∧ STUTTER=PASS)
           ∧ battle_visual_gate(VISUAL_GATE=PASS)
           ∧ [跨设备] cloud2p_evidence(E-7 strict REAL-DEVICE PASS, anti 无 HIT)

B 对手真实 = diff_party_check(CROSSED, exit 0, 零注入)
           ∧ battle_visual_gate(PASS) 佐证 ∧ [前提] A 的 BATTLE=PASS

C 帧率 parity = speed_parity_check(PASS, opponent_data_real 由 B 提供)
              ∧ FRAMEGUARD(STUTTER=PASS) ∧ 基线可溯源 ∧ [前提] A ∧ B

总验收 = A ∧ B ∧ C，且必须来自同一 run/tag、同一 commit、同一 dist md5 + APK md5。
```

> 禁用判据（权威口径）：单独 `BATTLE=PASS`、单独 `OPPONENT=PASS`、`ip_distinct`、CI 绿表（全 LOCAL）、注入期 `[RHVIS]/[SPENC]/[RHREND]` 标签。

---

## 3. 三端构建

### 3.1 PC dist（`build-win/dist/`）

- 权威产物：`build-win/dist/mGBA.exe`，MD5 `5055EE9F0B29A1A08556682B586654B8`（HANDSHAKE2，含握手根因①②修复，不含未提交的 B7/FIXSCREEN）。
- **必须用 dist，不要用 `build-win/mGBA.exe`**：后者缺 Qt DLL（0xC0000135），也是另一路构建（MD5 `56731628…`），非本轮验收基线；`.zcode-tmp/pbdist/mGBA.exe` 等同理禁止混用。
- 重建方式：源码改动后 `ninja` 构建 `mGBA.exe`（H10 日志即 `[8/8] Linking CXX executable mGBA.exe`），再用 `tools/deploy-win.sh`（内部 `windeployqt`）补齐运行库。注意 H10 实测：全新重编得 `A88934CE…`（162 字节时间戳/资源差异），但保留的 dist 仍是 `5055EE9F…`；版本串与源码 commit 不一致属正常，**以登记的 md5 为准，不要混用两份**。
- 校验：`Get-FileHash -Algorithm MD5 build-win/dist/mGBA.exe`。

### 3.2 Android debug APK（及 release 过期问题）

- 权威 APK：`android/app/build/outputs/apk/debug/app-debug.apk`，MD5 `AF57189E61A85A37510DC73F093813E1`（11-19，含根因②），与权威文档一致——但它位于**被忽略的 build 目录且是 debug 构建**。
- 同 commit 重编并安装（来源 `.zcode-tmp/P4_abdesign.md` §5.1、Run C 基线流程）：

```powershell
cd android && cmd /c gradlew.bat :app:assembleDebug --offline
adb -s emulator-5554 install -r android/app/build/outputs/apk/debug/app-debug.apk
```

- **release 过期问题（P16 §1.2）**：可分发包 `android/app/build/outputs/apk/release/app-release.apk` 与 `out/app-release.apk` 均为 MD5 `8D8542E0`、日期 11-15，**比权威 debug 包旧 4 天**，未包含最新修复。权威文档引用的 APK 不是可分发产物。交付前应把 `AF57189E` 对应构建以 **release** 形式落到 `out/`，并更新登记 md5。
- 可用 `tools/apphunt_auto_next.py` 的 watcher（监听 dist md5 变化 → 重编/安装 APK → 起 E2E），但其内部命令模板较旧（无 RELAY），须显式替换为 §1.3 的命令。

### 3.3 iOS（H19 swift gate）

- **H19 swift gate = `swift_parse_netplay`**：由 commit `041904c6d` 根治历史 exit 127（干净 PATH 探测 swiftc + Runtimes DLL + 纳入 AppDelegate）；最新 `ci-run` 的 `RESULT.md` 显示 exit 0 / 5 OK / PASS。
- gate 命令（来源 `tests/2p-cloud/ci-netplay-selfcheck.sh`、`production/联机实现全过程.md:28`）：

```powershell
SELFCHECK_ONLY=swift_parse_netplay bash tests/2p-cloud/ci-netplay-selfcheck.sh
# 或全量：bash tests/2p-cloud/ci-netplay-selfcheck.sh
# 结果落盘：tests/2p-cloud/ci-run-*/RESULT.md
```

- gate 解析文件仅 `GBoyConsoleSet.swift` / `GBoyLink.swift` / `LobbyFrames.swift` / `LobbyLink.swift` 四个，**不含 `AppDelegate.swift`**（H18 R2）→ 零注入控制面新增代码不在任何现有 gate 解析范围，PASS 不能替它背书。
- iOS 静态验证（来源 `.zcode-tmp/H18_ios_static.md`，复现命令）：

```powershell
swiftc -parse ios/mGBA/AppDelegate.swift                       # EXIT=0
python ios/typecheck/prepare.py ios/mGBA <tmp>/build
swiftc -typecheck ... ios/typecheck/stubs/*.swift <tmp>/build/*.swift   # 仓库现状：1 error（stub 缺 mgbaMobileSetRhOff）
swiftc -parse ios/mGBA/GBoyConsoleSet.swift ios/mGBA/GBoyLink.swift ios/mGBA/LobbyFrames.swift ios/mGBA/LobbyLink.swift
```

- iOS 构建面：`ios/build-core.sh` 用 `-DCMAKE_SYSTEM_NAME=iOS` 编 `mgba_mobile` target（`mgba_mobile.c` 在其中），再 `libtool`/`lipo` 汇总为 `libmgba_ios.a`。
- 诚实边界：**Windows 无 iOS SDK / 真机**，H18 是静态 + stub 模拟验证，非真机编译；stub `CCore.swift` 未同步新符号（R1）、gate 覆盖缺口（R2）、无运行时验证（R3）均须如实标注。B7 的 `mgbaMobileSetBattleRelay` 在 iOS stub 与 AppDelegate 尚未闭环（P13/P10）。

> CI 提醒（P16 §1.7）：`android-link-selftests.yml` 与 `ios-build.yml` 均 `branches: [main]`，而活跃分支是 `master`——本仓库分支策略下 CI 不会自动触发。CI 表全 LOCAL，**不是跨设备 E2E**。

---

## 4. 环境前提

### 4.1 AVD boot（`tools/cloud2p_avd*.py` 跨设备载体）

来源 H14 §1、H8 §1（来源命令用绝对路径 `D:\Android\Sdk\platform-tools\adb.exe`）：

```powershell
adb devices -l                                  # emulator-5554  device
adb -s emulator-5554 shell getprop sys.boot_completed   # 1（启动完成）
```

- 磁盘：D 盘剩余建议 >20GB（H14 实测 206.91GB），长 run 截图/日志空间充裕。
- 多 mGBA 实例并存会串窗/占资源：`--no-emulator` 须确认加载的是本轮新 dist（PID 与路径可查）；视觉 gate 截图必须按本轮 PC PID 过滤（FIXSCREEN）。

### 4.2 VPN 分流（身份验收前置，ADR-007）

来源 `.zcode-tmp/H8_vpn_identity.md`，判据详见 `docs/architecture/ADR-007-ip-split.md`：

```powershell
python tools/vpn_split.py status    # 只读：期望 RULE_AVD_DROP_UDP3478=True、EGRESS_DISTINCT=True
python tools/vpn_split.py apply     # 加 AVD iptables OUTPUT -p udp --dport 3478 -j DROP
python tools/vpn_split.py restore   # 回滚
```

- 规则随 AVD 重启丢失（ADR-007）；当前实测无 3478 规则 → 此刻跑对战，两端同出口 `36.251.93.252` → `IDENTITY=FAIL`。
- `active_battle()` 保护：有 `cloud2p`/`mGBA.exe` 活跃进程时 `apply` 返回 `REFUSE(2)`。**必须等活跃 run 完全结束 → apply → status 通过 → 再跑真实对战产出新 run → 最后才做身份验收**。身份验收须放到最后一步；零注入 A/B 不以身份为主判据，不要为 A/B 去 apply。
- 身份验收命令（最后一步，`--app-log` 指向含开局 `[direct] 候选` 行的 `app_link_startup.log`）：

```powershell
python tools/cross_device_identity_check.py .zcode-tmp/cloud2p/<TAG> --app-log .zcode-tmp/cloud2p/<TAG>/app_link_startup.log
```

### 4.3 driver 参数（Run C 固定项）

来源 P4 §1、H14、H8：

- 拓扑固定：`--mode A --runsec 480 --no-emulator --serial emulator-5554 --app-nav --fast-early`。
- 环境固定：`MGBAX_FORCE_EXCHANGE=0`（硬约束，必须 OFF）、`MGBAX_HANDOFF_GUARD=0`、`MGBAX_RH_VERBOSE=0`（诊断 verbose 会拖垮 RTT/导航）、`MGBAX_SEAT_ASSIST=1`、`MGBAX_CLOSE_GRACE=1`、`MGBAX_SIO_CONNECT_POLL=0`、`MGBAX_SIO_FAST=0`。
- 实验轴：`MGBAX_RH_OFF`（零注入=1）、`MGBAX_BATTLE_RELAY`（B7 灰度门，默认 0）。
- 倍速：`--env MGBAX_SPEED_9=1` + `speed` 文件（path B）或 UIA `Tools→Speed`（path A），见 §2.3。
- 组间隔离：每组新进程 + 新房间/会话 + 新页面；setprop 属性跨 run 残留（A13 教训），driver 每次显式写 0/1 并核对 readback。

---

## 5. 当前状态与一票否决（诚实边界）

- **当前总门 FAIL**：对战里程碑达成（两端 cb2=080B4845）但闭环待证（后段 st=4→2、net=2→1、cmdguard=639 回落）；对手 `? Lv0`（HP 空）；视觉 UNOBSERVED（抓错窗，FIXSCREEN 待重抓）；帧率 STUTTER FAIL(LINK_RESET)；IDENTITY FAIL（需重 apply vpn_split）；B7 未提交/未接 driver/iOS 缺 setter。来源 `production/联机实现全过程.md:10-13`、P10 §6、H15 §4.6。
- 出现任一信号，**绝不能宣称成功**（P10 §4、H15 §2）：
  1. 用废弃宽窗口 `summary.battle_window=[080B30C0,080BCA78)`、单端进 cb2、或单独 `BATTLE=PASS` 当成功；
  2. 对手框 `? Lv0`、species=0/FFFF/越界（含 `058B`）、HP_BAR green 0%、TEXTBOX dark 0%；
  3. `diff_party_check` 返回 `SELF_ECHO`、两端都 `0xD5` 却宣称"传对"；
  4. 抓错窗口截图（非本轮 PC PID）导致视觉 gate FAIL 不可信；
  5. 未经人工看截图就手写 `opponent_data_real=True`；
  6. 同机同 NAT 却判身份 PASS，用 `peer=`/`node_address`/私有 IP 当本端出口；
  7. CI 绿表（全 LOCAL）冒充跨设备 E2E。
- 只有 §2.6 的最小充分组合在**同一 run**上全部真 PASS，才允许更新 `production/联机实现全过程.md` 状态为 PASS；提前改 PASS = 造假。

---

## 6. 待补的交付缺口（本文未覆盖，属其他职责）

P16 盘点中，以下组织性缺口不在本文范围（本文只新建 docs/ 文档，未改源码/tools/production）。列出以便主理人安排：

- `production/sprint-2p/` 空目录的 HANDOVER/T-03；ADR-001 缺失；把内部 RUNBOOK 实战坑并入 tracked 版；10 个新 `ci-run` 的 `RESULT.md` 未入库；release APK 未更新；CI workflow 分支 `main` 与实际 `master` 不一致。详见 `.zcode-tmp/P16_delivery.md` §5。

---

## 7. 本文路径引用核对（全部存在）

`production/联机实现全过程.md` · `tools/speed_parity/RUNBOOK.md` · `.zcode-tmp/speed-parity/RUNBOOK.md` · `.zcode-tmp/speed-parity/set_pc_speed.ps1` · `.zcode-tmp/P4_abdesign.md` · `.zcode-tmp/H14_env_precheck.md` · `.zcode-tmp/H15_gate_matrix.md` · `.zcode-tmp/H18_ios_static.md` · `.zcode-tmp/H8_vpn_identity.md` · `.zcode-tmp/P10_finalaccept.md` · `.zcode-tmp/P13_truthcheck.md` · `.zcode-tmp/P16_delivery.md` · `.zcode-tmp/H10_build.log` · `.zcode-tmp/cloud2p/` · `tools/battle_visual_gate.py` · `tools/diff_party_check.py` · `tools/speed_parity_check.py` · `tools/cross_device_identity_check.py` · `tools/frame_stutter_check.py` · `tools/cloud2p_avd.py` · `tools/cloud2p_avd_vis.py` · `tools/cloud2p-duo.py` · `tools/apphunt_auto_next.py` · `tools/vpn_split.py` · `tools/deploy-win.sh` · `build-win/dist/mGBA.exe` · `build-win/mGBA.exe` · `android/app/build/outputs/apk/debug/app-debug.apk` · `android/app/build/outputs/apk/release/app-release.apk` · `out/app-release.apk` · `android/gradlew.bat` · `ios/build-core.sh` · `ios/typecheck/prepare.py` · `ios/typecheck/stubs/CCore.swift` · `tests/2p-cloud/ci-netplay-selfcheck.sh` · `tests/2p-cloud/ci-run-*/RESULT.md` · `docs/architecture/ADR-006-cross-device-identity.md` · `docs/architecture/ADR-007-ip-split.md` · `.github/workflows/android-link-selftests.yml` · `.github/workflows/ios-build.yml` · `tools/speed_parity_check.py --dry-run` 输出中的 `.zcode-tmp/speed-parity/baseline_1x.txt` / `baseline_2x.txt`。

> 核对方式：`Test-Path` 对仓库根逐项验证（通配符 `ci-run-*/RESULT.md` 为目录模式，已确认存在匹配目录）。本文未引用任何不存在的文档路径。
