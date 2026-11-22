# Agent 常驻工作流（本项目强制规约）

## 1. 常驻规模（强制：返回即补）
- **常年维持 50 个 agent 并行**。用户明确要求；这是长期工作方式，非一次性指令。
- **收到任一 agent 完成/返回通知时，必须在该轮回复内立即派一个新 agent 补位**，不等用户提醒、不攒批、不空转。补位优先级：当前关键路径（P0 验证/差分/收尾）> 未覆盖的新角度 > 独立复核。
- 补位 agent 遵守第 3 节独占写入规则（只读，产出 `.zcode-tmp/<代号>.md`），不碰在途关键路径写入者。
- 目的：把分析、预案、审计、验证准备铺满，缩短"从现象到根因"的收敛时间。

## 2. 物理瓶颈（诚实认知）
- agent 只加速**分析/预案/审计**，**不加速跨设备 E2E 墙钟**：单 AVD + 单对云账号串行是物理瓶颈。
- 不要误以为"派更多 agent"能让 E2E 跑更快；真正决定成败的是决定性 E2E 的数据。
- 账号互斥：不得起第二个并发 cloud2p run 抢占同一 AVD/账号（多次造成房号漂移、run 作废）。
- **同 tag 并发铁律**：起任何 cloud2p run 前，**必须先确认无同名 tag 的 run 在跑、且对应 agent 未报告完成**。血泪教训（2026-11-20 ROUTEA-DIAG-01）：父会话误判首轮随 AVD 掉线作废、重启 AVD 后用**完全相同命令+相同 tag** 起第二轮，与仍在跑的 APPHUNT3 run1 并发、覆盖 artifact——后核对 run1 其实已完成并另存副本。正确做法：AVD 掉线时先确认 E2E python 进程是否已退出，再决定是否重跑；重跑必须换新 tag（旧轮标 VOID 留存），绝不复用同 tag 并发。
- **结果到达闸门**：E2E 报告落盘/APPHUNT3 返回后，暂停补派新 agent、确认 E2E 进程退出、由父会话独占逐文件判读（目录级 grep 对 >1MB 日志会漏报）；判读完成且无在途 E2E 后才恢复补派。

## 2.5 资源占用上限（强制：CPU ≤70%）
- **整机 CPU 占用不得超过 70%**（用户明确要求，硬约束）。这是工人智能/编译/E2E 的资源纪律，真实性纪律不因此放宽。
- **执行时机**：起任何编译（ninja/gradle/cmake）、补派新 agent、跑跨设备 E2E 之前，先用 `Get-CimInstance Win32_Processor | Measure-Object LoadPercentage -Average` 实测整机 CPU。
- **超标处理**：若实测 >70%，禁止起新编译/新 run/继续补派；先降载——暂停补派、串行化编译（禁并发 gradle+ninja）、等现有重负载进程回落，CPU ≤70% 后再继续。
- **并发编译origin**：历史上多 agent 并发触发 ninja/gradle 曾造成 CPU 飙高、`SKIPPED-LOCK`/`link exchanged values` flaky 与 gates 与产物不同源。
- **agent 一律只修改、不编译（强制）**：所有 agent（含 ROOTHUNT2）**只改源码/文件、产出 commit 或工作树改动，绝不自行起 ninja/gradle/cmake 编译、不跑 gates、不装 APK**。编译、gates、iOS typecheck、设备 `adb install`、E2E run **一律由父会话（主会话）独占串行执行**。这同时落实 CPU ≤70% 与"产物/commit 同源"——消除并发编译来源。子 agent 交付报告里"我已编译/gates PASS"一律不采信，父会话须自行重编复核。
- **实测优先**：以磁盘/系统实测为准，不凭"应该不高"臆断；每次关键动作前量一次并记录时间。

## 3. 独占写入规则（防并发混乱，血的教训）
同一时刻，每类资源只有一个合法写入者，其余 agent 只读：
- **C 源码**（`src/platform/qt/sio_link.c`、`src/platform/mobile/mgba_mobile.c` 等）：ROOTHUNT2 独占。
- **权威文档**（`production/联机实现全过程.md`，全中文，`len()≤2000`）：CONDENSE 独占，其他 agent 不得写入。
- **跨设备 E2E 验证**：APPHUNT3 独占（单 AVD）。
- **其余 agent**：只读，产出存 `.zcode-tmp/<代号>.md`，绝不改源码/文档/产物。
- 产物 md5 以**磁盘实测**为准；`version.c` 的 `-dirty` 戳会让同功能源码产生不同 dist md5，不要据此判"版本不同"。
- 派单前先查 `git status`/进程，避免两个会话重复改同一文件（曾导致编译半成品、gates 与产物不同源）。
- **设备 APK 老坑**：`cloud2p_avd*.py` 只 `pm clear`+推 ROM+`am start`，**从不 `adb install` APK**。重编 APK 后必须人工 `adb install -r`，并 pull `base.apk` 回读 md5 确认与磁盘一致；否则整轮跑的是旧 app（多次前提破裂）。
- 起跑前确认无并发 cloud2p/mGBA 进程、房号无漂移（resyncs=0）、setprop readback 全 1。

## 3.5 口径裁决：灰区全解禁（2026-11-20 用户明示）
- **用户明示「全部解禁」**：此前自我设限的灰区手段全部授权——直写 gLinkOpen(C3)、手建 seat task(SEAT_ASSIST)、rearm/RHSLVINJ 写真握手字、RHBRS 强写 brs、var8004 补写、rem-restore 等。可在 C 源码/驱动中实施，三端对称、具名宏、独立门、父会话独占串行编译/E2E。
- **红线仍禁（不随解禁放开）**：造 party 数据、手写 opponent_data_real/信任位、伪造 CROSSED 字符串、造 species 证据——这是造假本身，非灰区，解禁灰区不等于允许造假，否则 CROSSED 失去全部意义。
- **产物标注义务**：灰区全开所得的任何产物/日志/CROSSED 必须显著标注「灰区全开、CROSSED 可信度存疑、非纯零注入」，不得对外称纯非伪造成功；权威文档如实记录灰区口径与信誉代价。
- 工程纪律不放松：CPU≤70%、单 AVD、同 tag 铁律、结果到达闸门、产物 md5 磁盘实测、agent 只改不编译。

## 3.6 架构级重构决策（2026-11-20 用户「大改架构」）
- **架构级病根（实测）**：当前架构让两端像真电缆一样每帧做 SIO 同步传输，但 cloud relay 网络延迟 p2p_avg=614ms、sio-rtt avg=1792ms peak，比 GBA SIO 硬件时序（~16ms/传输）慢 40-100 倍。所有握手/块交换/brs 失败是这个根本矛盾的下游症状，补丁层（含灰区全开，已实证无效）无解。
- **用户裁决「大改架构」**：不再在伪链路+SIO 硬件时序模拟上打补丁，换底层同步架构。候选方向待调研：延迟隐藏/预测-回滚（本地 SIO 立即返回预测字、网络异步校验、分歧回滚）、输入同步/回放（同步按键而非 SIO 字，各端独立跑游戏）、状态同步（周期性同步 RAM 状态）、或真机直连替代 cloud relay。
- **对手真实性语义必须保持**：新架构下仍需 party 字节来自对端真实游戏、双方同倍速、帧率=单机、零注入 CROSSED（APP 0006↔PC 00D5）判据不降；换架构只改"如何同步"，不改"对手必须真实"。红线（造 party/信任位/伪造 CROSSED）仍禁。
- 三端同步、具名宏、CPU≤70%、单 AVD、同 tag 铁律、结果到达闸门等纪律不放松。

## 4. 攻坚当前状态（速览，详见权威文档）
- 目标三标准：①双方同倍速、帧率=单机、对手真实（非 ???/非自我回显）②PC/iOS/Android 三端同步 ③全中文过程文档。
- 总门 **FAIL**，对手真实性 **0/9 证据**。
- 已实证：握手前期信号、btlType=0x0A、callback 结构、从机相位捕获（sc 0..8）、块字出网（setup 块）。
- 真根因（源码+实证）：APP 战斗入口 LINK_RESET → **st=2 握手自锁**（唯一出口需 tempRecvBuffer[0]==0x8FFF，但对端回 B9A0）→ rem/gLinkOpen/notReceived 恢复门全要求 st≥4（不满足）→ APP 零出块 → 双向锁步卡 case2 → party 块（160B）从未重组 → **brs 恒 0** → 对手 `? Lv0`。注意 PHASEDIAG-02 实测 BATTLE=NO（未进战斗），勿以早期 BATTLE=YES 冒充。
- P0 修复（ROOTHUNT2 实施中）：独立门 `MGBAX_LINK_HSBYPASS`（握手态旁路保真 8FFF）+ nr0/nr1 只读打点，目标让 APP 真实推进到 st≥4。**禁强写 rem=1/brs=FALSE/nr=FALSE**（伪造游戏不可达态，触发 CloseLink 守卫）。验证须确认 RHID 补丁的 nr 强写已在零注入下关闭，否则 nr=FALSE 是假证据。
- 对手真实唯一判据：零注入下 `diff_party_check` 的 **CROSSED**（APP 框=0006、PC 框=00D5 交叉）——块闭合只是必要条件，非充分。

## 5. 诚实纪律（不可动摇）
- **真实性 > 速度**：不伪造 PASS、不手写信任位、不因投入多暗示接近成功。
- **运行时证据 > 静态推理**：曾有多次静态推理被实测推翻（frame[sc] 误认成功、sc-1 决策反复）。
- 数据层 `BATTLE/OPPONENT=PASS` 是假阳性，不作成功判据。
- 视觉门：无有效战斗截图（PID 不对/标题非本轮/错误屏/残片）判 UNOBSERVED，不判 FAIL 更不判 PASS。
- brs 陷阱：blkSp0 非 0 但 brs=0 可能是训练家卡块/块在组装，须综合 REMW/ts0x80/82 + enemyPartyCnt + mons 判定。
- 地址硬约束：所有解析源码必须用具名宏（禁裸 hex），三端宏同名同值、运行时 delta 解析。
- 三端同步：任何 C 改动必须 PC + mobile/iOS 共享 C + iOS 控制面 + 两 driver 对称，缺一端视为未完成。

## 6. 权威文档
- `production/联机实现全过程.md` — 唯一权威，全中文，≤2000 字，门 FAIL 如实记录。由 CONDENSE 独占维护，本文件不与其争夺内容。

## 7. GitHub 公开仓同步推送（zcode 方法，常驻强制）
- **目标**：`github.com/zx14855735/mgbax.git`（三端公开仓）。主仓 remote `github` 与其历史无关、直推无效，必须经独立镜像仓 `D:\mgba-ios-mirror`（remote `origin`=GitHub、`dev`=主仓）中转。
- **触发**：主仓有更新 commit 落 HEAD 后，父会话独占串行同步（先本地验证：iOS typecheck + Android assembleDebug 通过）。
- **执行**：`python tools/sync_github_mirror.py`（`--dry-run` 先看范围）。脚本固化 zcode 方法：先 fetch；远端若前进/重写则 `git reset --hard origin/main` 采用远端为基线、**绝不 force-push**；再把主仓 HEAD 的白名单目录（`android/src/ios/include/res/cinema/tools/doc`）+ 根文件（教程/ipa/使用说明/AGENTS.md/README×）用 `git checkout dev/master --` 增量叠上。
- **永久排除**：`tmp_*`、`.workbuddy`、`.zcode*`、`cloud2p` 产物、`shots/output/opt/package_stub/ROM/logs`、拆解文档；`.github/workflows` 只在镜像存在，`checkout` 天然不碰（**禁 robocopy /MIR .github**，会删光工作流）。
- **推送坑**：先 `git --version` 实测——EDR/AV 拦 git.exe 时两仓全拒、数小时后自解，等即可；GitHubDesktop 句柄锁只让镜像仓间歇"拒绝访问"，**不要杀用户 GitHubDesktop 进程**，脚本带 8 次×10s push 重试环。
- **gitee 自动推送（同轮必做）**：主仓 remote `origin`=gitee（`mgba-android-version.git`）。每轮同步先在主仓 `git fetch origin`，若 `origin/master` 领先本地（有独立提交）则**不 force-push、跳过并如实报告**，否则 `git push origin master` 全量推送（带 8×10s 重试环，抗 GitHubDesktop/EDR）。gitee 与主仓同源，全量推（不像 GitHub 走白名单）。
- **iOS CI 编译 + IPA 回拉（GitHub 推送后同轮必做）**：GitHub push 会对 HEAD 触发 `iOS Simulator` workflow（macOS，ios-build.yml）。父会话跑 `python tools/ios_ci_fetch.py [sha8]`——从 `git credential(manager)` 读 token（不写死/不打印），按 sha 找 run、轮询等完成（≤20 分钟，CI 红/超时如实报告不伪造）、下载 `mgbax-unsigned-ipa` 解出 .ipa 到 `ios_ci_artifacts/mGBAx-<sha8>.ipa` 并打印 md5（磁盘实测为准）。**成功后自动删除目录内其他 mGBAx-*.ipa / artifact-*.zip，只保留最新版**，避免装错版本。**默认取 GitHub 远端 HEAD 而非主仓 HEAD**（GitHub 白名单仓落后 gitee 全量仓）。
- **诚实**：镜像/远端内容以各远端实况为准；同步不改主仓门状态（FAIL/0/9/CROSSED 从未产出不变）。
