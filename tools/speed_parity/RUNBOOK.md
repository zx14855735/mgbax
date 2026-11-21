# SPEEDTEST / speed parity 验收 RUNBOOK

`tools/speed_parity_check.py` 的操作手册。目标判据（用户 2026-11-18）：
**两端使用相同倍速时，联机对战正常，且帧率与单机相同倍速一致。**

判定优先级 `FAIL > UNOBSERVED > PASS`；退出码 `0=PASS / 1=FAIL / 3=UNOBSERVED`。
`UNOBSERVED` 是"证据不足"，永远不能当成 PASS。

---

## 0. wire 映射（三端必须一致）

倍速 R → type-9 wire 值，公式 `1e9 / (rate * 60)`：

| 倍速 | wire |
|---|---|
| 0.5x | `-1` |
| 1x   | `1` |
| 2x   | `2` |
| 4x   | `4` |

- **PC 端**：启动驱动时带 `--env MGBAX_SPEED_9=1`，并在驱动 script dir 写 `speed` 文件
  （内容 `1` / `-1` / `2` / `4`）。日志证据：
  `[gboy] speed hook: <wire>`、`[gboy] type 9 speed sent: <wire>`。
- **Android 端**：`adb shell am broadcast -a io.mgba.android.action.SPEED --ei value <wire>`。
  日志证据：`speed broadcast value=<wire>`。
- 1x 是产品默认值（断链会复位到 1x），未看到 override 也可判 PASS；**R>1 必须有日志 wire 证据**。

先看完整计划（不改任何文件）：

```powershell
python tools/speed_parity_check.py --speed 2 --dry-run
```

---

## 1. 生成单机基线（1x 与 2x 各一份）

基线默认目录：`.zcode-tmp/speed-parity/`，文件名 `baseline_1x.txt` / `baseline_2x.txt`。
`--from-summary` 不传 `--baseline` 时会自动按倍速搜这里（也会搜 run 目录）。

### 方式 A：实测（Windows，采 mGBA 窗口标题 fps）

```powershell
python tools/speed_parity_check.py --measure-baseline --speed 1 --seconds 30 `
  --out .zcode-tmp/speed-parity/baseline_1x.txt
python tools/speed_parity_check.py --measure-baseline --speed 2 --seconds 30 `
  --out .zcode-tmp/speed-parity/baseline_2x.txt
```

R>1 时 solo PC 没有 env speed hook：在 settle 窗口内手动 `Tools -> Speed -> 2x`，或传
`--speed-cmd`。采到 `fps_min/fps_max/samples`，取中位数写 `fps`。

### 方式 B：外部已测 fps 直接落盘

```powershell
python tools/speed_parity_check.py --write-baseline `
  .zcode-tmp/speed-parity/baseline_1x.txt --speed 1 --baseline-fps 60.0
python tools/speed_parity_check.py --write-baseline `
  .zcode-tmp/speed-parity/baseline_2x.txt --speed 2 --baseline-fps 120.0 --baseline-1x 60.0
```

> 注意参数名是 `--baseline-fps` / `--baseline-1x`（旧版 dry-run 误写成 `--fps` / `--fps-1x`，已修）。
> 2x 的 `fps_1x` 也可写进 `baseline_2x.txt`，供 `speed_scale` 检查验证 fps 随倍速缩放。

---

## 2. 跑 E2E（两端同倍速）

**跨设备 PC↔Android 才是 2P 验收的权威证据**：

```powershell
python tools/cloud2p_avd.py --tag SPD-AVX --mode A --runsec 420 `
  --env MGBAX_SPEED_9=1 --app-user <APP_USER> --app-pass <APP_PASS> `
  --pc-acc <PC_USER>:<PC_PASS>
```

**同机双 PC PROXY（仅调试，不可当跨设备证据）**：

```powershell
python tools/cloud2p-duo.py --tag SPD-DUO --mode A --runsec 420 --nav `
  --env MGBAX_SPEED_9=1
```

> DUO 是同一台机器上的两个代理实例，链路走本机 PROXY，不能证明"跨设备"场景；
> 只用来快速验证倍速/wire 打点逻辑，最终结论必须用 cloud2p_avd 的跨设备 run。

---

## 3. 会话进行中给两端上速（arm-speed）

```powershell
python tools/speed_parity_check.py --arm-speed .zcode-tmp/cloud2p/<TAG> --speed 2
adb shell am broadcast -a io.mgba.android.action.SPEED --ei value 2
```

`--arm-speed` 把 wire 写进 run 下的 `keys_a/keys_b/pc_keys/...` 的 `speed` 文件，并打印 adb 命令。
驱动要先启动（它才会创建这些 script dir）。PC 端仍须带 `--env MGBAX_SPEED_9=1`。

---

## 4. 判读与出结论

1. 人工看 `<run>/battle_screenshot_*.png`：对手必须是**真精灵（非 ???）**，
   确认后才把 summary.txt 的 `opponent_data_real` 改成 `True`。
2. 跑判定：

```powershell
python tools/speed_parity_check.py --from-summary .zcode-tmp/cloud2p/<TAG> `
  --baseline .zcode-tmp/speed-parity/baseline_2x.txt --speed 2 --json
```

输出逐项 `[PASS|FAIL|UNOBSERVED] check detail`，最后一行 `VERDICT: ...`。

PASS 的必备条件：`BATTLE=YES` + `battle_samples>0` + `in_battle_frame` 非 False
+ `opponent_data_real=True` + 两端 wire 都命中 2 + 双端 in-battle fps ≥ 90% 单机基线
+ 双端 fps 差 ≤ 10% + R>1 时 `baseline(2x)/baseline(1x)` 落在 `[1.5x, 2.67x]`。

---

## 5. 三处 UNOBSERVED 陷阱（FRAMERATE 审计）

只要任一检查是 UNOBSERVED，总 verdict 就是 UNOBSERVED（优先级低于 FAIL、高于 PASS）：

1. **`opponent_data_real=UNOBSERVED`**：driver 默认永不自动置 True，必须人工核对战斗截图后
   在 summary.txt 写 `opponent_data_real=True`；否则整局直接 UNOBSERVED。
2. **大日志整份跳过 → wire 证据丢失**：真实 run 里 `app_logcat_after.log` 达 13.49MB，
   旧版 `collect_speed_evidence` 对 >8MB 日志直接 `continue`，2x wire 行被丢，
   `speed_app` 误报 UNOBSERVED。**已修**：改为流式逐行匹配，内存恒定，大日志也能取到证据行。
3. **基线找不到**：基线默认在 `.zcode-tmp/speed-parity/`，旧 `find_baseline` 只扫 run_dir，
   不显式传 `--baseline` 就 `baseline_fps/netplay_fps/speed_scale` 全 UNOBSERVED。
   **已修**：同时搜 run_dir 和默认目录，并按当次 speed 匹配（文件名 `2x` 或内容 `speed/wire`）。

若以上都已修仍 UNOBSERVED，按输出 detail 补齐对应证据（日志 wire 行、基线文件、人工判读），
不要改判据阈值去"凑" PASS。

---

## 6. 证据映射速查

| summary / 日志字段 | 含义 | 落到哪个检查 |
|---|---|---|
| `BATTLE=YES`, `battle_samples`, `in_battle_frame` | 真进战斗且 fps 是 in-battle 采样 | `battle` |
| `opponent_data_real` | 人工判读：对手是不是真精灵 | `opponent_data_real` |
| `fps_pc_A` / `fps_pc_B` (duo) | 双端 in-battle fps | `fps_A` / `fps_B` / `ends_match` |
| `fps_pc` / `fps_app` (avd) | 跨设备双端 fps | `fps_PC` / `fps_app` / `ends_match` |
| `[gboy] speed hook: N` / `type 9 speed sent: N` | PC 端 wire | `speed_A` / `speed_B` / `speed_PC` |
| `speed broadcast value=N` | Android 端 wire | `speed_app` |
| baseline `fps` / `fps_1x` | 同倍速单机基线 / 1x 基线 | `baseline_fps` / `fps_*` / `speed_scale` |
