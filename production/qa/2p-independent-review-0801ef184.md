# 2P 联机 · 独立复核报告（只读复核 + 一次可回滚临时变异）

> **⚠ 本文件已被 [`2p-independent-review-0be5da192.md`](2p-independent-review-0be5da192.md) 取代。**
> 取代原因：新版按主理人与复核人合并后的统一措辞重写了 C/Qt 门控一节（含三条可执行升级条件）、
> 新增「批次 D 干净工作树验证」、并把两处口径收窄（`isReady()` 只对 Android Java 成立、
> `m_gatePump` 应表述为「零注入点」而非「零调用点」）。
> **保留本文件仅为对应 `0801ef184` 时点的历史快照**，其中的断言条数（76）与该时点的红态记录仍有留档价值；
> **引用当前结论请用新版**。两份报告都以「绑定 commit + 二进制 md5」为前提，这一点不变。

> **元结论（先读这句，比报告里任何数字都重要）**
> **复核期间仓库有 8 个提交、两次真实红态都发生在我复核过程中，
> 因此任何「全绿」结论都必须绑定到具体 commit + 二进制哈希，否则不可引用。**

| 项 | 值 |
|---|---|
| 复核人 | quality-lead-2-2（独立复核者，非实现者） |
| 复核结束时 HEAD | `0801ef184`（`fix(android): 对齐 PC 的「能力位畸形」三要素文案 + 幂等保护；C0GateTest 钉住文案契约`） |
| 复核结束时工作区 | 干净（`git status --porcelain` 空）；**注：跑测期间曾含他人未提交改动**，见 §1 |
| 结论所用二进制 | `build-win/qt/test-gboylink.exe` = `9999b192a2c45c89e665f2bb65816e21` |
| 结论所用移动端二进制 | `build-mobile-test/mgba_mobile_test.exe` = `91f142639eeae33c344097d314fec126` |
| 结论所用源码 | `CloudLink.cpp` = `02f08d44dc766238ab987ef654b0478f`<br>`gboylink_test.cpp` = `fc60c05e7b1d8a66aeb5e9ea0a3aa181`<br>`GBoyFrames.cpp` = `e2daf63de5b739fe83f2a5a98c2487d8` |
| 平台 | Windows + Git Bash，`mingw64`，PATH 含 `build-win` 与 `build-win/qt`（否则 `test-gboylink.exe` exit 127） |

> **版本落差声明**：本报告落盘时工作区**又领先于 `HEAD 0801ef184`**（`M src/platform/qt/test/gboylink_test.cpp`、
> `M android/app/src/main/java/io/mgba/android/GBoyCloudLink.java`、`M production/release/2p-link-release-checklist.md`）。
> 文中所有数字均对应上表哈希；工作区中更新的断言（例如 §4 债 1 的 `expectSecondCall`）**不在这些数字的覆盖范围内**。

---

## 0. 一句话结论

- **C0 能力协商位 + 帧层 + 本机自检这一层：已被独立证据证明为真。**
- **跨设备云端 2P 可玩性：未被证明，且所有已落盘云端日志的 `BATTLE=YES` 计数仍为 0。**

---

## 1. 全量回归（按批次绑定 revision/哈希，不跨批混用）

### 1.1 批次说明（关于「钉住 revision」的诚实交代）

复核起点 `HEAD = 6d30e23e6`，终点 `HEAD = 0801ef184`，期间共 8 个提交。
**缺口（不掩盖）**：最初的批次 A 是**按批次记哈希、不是按命令记 HEAD**，且该批次执行期间 HEAD 发生了变化。
按「同一组数字不能混着结论用」的规则，**批次 A 的数字不作为本报告结论依据**，仅作为过程记录。

| 批次 | HEAD | 工作区 | 用途 |
|---|---|---|---|
| A（起点） | `6d30e23e6`，执行中变化 | **不干净**（2 份文档 + `gboylink_test.cpp` 为 M） | 仅过程记录，**不用于结论** |
| B | `df5f7fe84` | **不干净**（`build.gradle` M + 未跟踪 `C0GateTest.java`、`android/util/Log.java`） | 过程记录 + 重编后复核 |
| C（快照批次） | 跨 `f355bd59f`~`0be5da192` 的移动窗口，**以哈希钉住** | **不干净**（`CloudLink.cpp`、`gboylink_test.cpp` 为 M，是同事在写；按规定未 checkout/stash） | **主要证据批次**，跑前跑后哈希一致（`SNAPSHOT_STABLE=YES`） |
| D（干净工作区） | `0801ef184` | **干净**（跑前 `git status` 空） | **最终复核批次**，用于确认结论在干净树上成立 |

### 1.2 批次 C（主要证据批次，跑前跑后哈希一致）

```
a99e49de  build-win/qt/test-gboylink.exe
91f14263  build-mobile-test/mgba_mobile_test.exe
02f08d44  src/platform/qt/CloudLink.cpp
f0f89215  src/platform/qt/test/gboylink_test.cpp
e2daf63d  src/platform/qt/GBoyFrames.cpp
```

| 命令 | 输出末尾 | EXIT |
|---|---|---|
| `ninja -C build-win test-gboylink mgba-qt` | 链接成功 | 0 |
| `cp -f build-win/libmgba.dll build-win/qt/ && cmp` | `CMP_OK=identical` | 0 |
| `test-gboylink --c0` | `c0 tests passed (45 ok / 0 FAIL)` | 0 |
| `test-gboylink --gatetest` ×3 | `gatetest passed (76 ok / 0 FAIL)` ×3 | 0 / 0 / 0 |
| `test-gboylink frames` | `RECONNECT TEST: PASS` + `TCPDIRECT TEST: PASS` | 0 |
| `test-gboylink buslocal` | `BUSLOCAL TEST: PASS` + `SESSIONSLOT TEST: PASS` | 0 |
| `test-gboylink product-lockstep` | `product-lockstep: PASS (4 cores, product SIO lockstep)` | 0 |
| `mgba_mobile_test --bus` | `164 ok` | 0 |
| `mgba_mobile_test --link` | `169 ok` | 0 |
| `mgba_mobile_test --lockstep` | `37 ok` | 0 |
| `mgba_mobile_test --audioall` | `64 ok` | 0 |
| `mgba_mobile_test`（全套）×3 | `252 ok / 0 FAIL` ×3 | 0 / 0 / 0 |
| `gradlew :app:compileDebugJavaWithJavac --offline` | `BUILD SUCCESSFUL` | 0 |
| `gradlew :app:runLinkSelfTests --offline` | `51/51 PASS`、`58/58 PASS`、`runLinkSelfTests: 8/8 PASS` | 0 |

`--gatetest` 三次 timing 全表（批次 C）：

```
RUN1  1)A vs A=2ms  2)A vs B=1ms  3)undeclared+legacy=2009  4)cap 0x42=0
      5)1-player(baseStateCount=1)=2017  5b)1-player+legacy=2013  6)3P AUTO vs B=1
      7)cap 0xFF+legacy=0  8)instant pump=2012  9)round3=320  10)closed round2=104
      11)forced INVALID=1   → worst-case over 12 cases = 2017ms
RUN2  1)1ms 2)2ms 3)2011 4)0 5)2007 5b)2004 6)1 7)0 8)2008 9)321 10)105 11)1  → worst 2008ms
RUN3  1)1ms 2)1ms 3)2012 4)0 5)2010 5b)2008 6)1 7)0 8)2015 9)321 10)118 11)2  → worst 2015ms
```

有界等待稳定落在 **2001~2017 ms**，从未突破 2400 ms 上界。

### 1.3 批次 D（干净工作区，`HEAD 0801ef184`）

跑前 `git status --porcelain` 为空；跑后出现 `M src/platform/qt/test/gboylink_test.cpp`（同事在我跑完的瞬间开始写，与本次结果无关）。

```
$ ninja -C build-win test-gboylink mgba-qt          → BUILD_EXIT=0
$ md5sum build-win/qt/test-gboylink.exe             → 9999b192...
$ ./build-win/qt/test-gboylink.exe --c0             → c0 tests passed (45 ok / 0 FAIL)      EXIT=0
$ ./build-win/qt/test-gboylink.exe --gatetest  #×3  → gatetest passed (81 ok / 0 FAIL) ×3     EXIT=0/0/0
$ ./build-win/qt/test-gboylink.exe frames           → TCPDIRECT TEST: PASS                    EXIT=0
$ ./build-win/qt/test-gboylink.exe buslocal         → SESSIONSLOT TEST: PASS                  EXIT=0
$ ./build-win/qt/test-gboylink.exe product-lockstep → product-lockstep: PASS (4 cores)        EXIT=0
```

### 1.4 flaky 采样（只报「没复现」，不报「已解决」）

- `mgba_mobile_test` 全套累计 **6 次**（批次 A 3 次 + 批次 C 3 次）：**6/6 `252 ok / 0 FAIL`**。
- `--gatetest` 累计 **8 次**（A 3 + C 3 + D 3 中的 3 次为 81 ok）：全绿。
- **本轮未复现历史那次低频 flaky**（历史 38 次采样 1 次 EXIT=1）。**这只说明「没复现」，不构成「无 flaky」**，
  且历史那次**从未被归因**、首次失败日志还被 `tail` 截断。
- `android/app/src/test/java/android/util/Log.java` 桩**在复核期间已存在**（4055 B，mtime 15:38），
  三份自检日志中 `grep -c NoClassDefFoundError` = **0 / 0 / 0** ⇒ 噪声确实消失，**不是「桩还没来」**。

### 1.5 本次复核期间观察到的两次真实红态（均已恢复，但必须留档）

**(a) 生产代码中的遗留变异体（交付级风险）**

`android/app/src/main/java/io/mgba/android/GBoyCloudLink.java:2802`

```java
if (peer == GBoyFrames.LINK_MODE_UNKNOWN) {
    return LINK_DECISION_PEER_UNKNOWN; /* MUTANT */   // 原为 allowLegacy ? LEGACY_B : PEER_UNKNOWN
}
```

实测：

```
$ ./gradlew :app:runLinkSelfTests --offline --console=plain
=== RUN C0GateTest ===
FAIL: undeclared peer with allowLegacy=true is accepted (fallback)
FAIL: fallback switches linkMode() to B
FAIL: fallback switches officialMode() to true
FAIL: fallback does not mark the gate rejected
FAIL: fallback is announced as a warning, not a silent downgrade
46/51 PASS, 5 FAIL
BUILD FAILED in 3s            ← EXIT=1，连跑 2 次同样 5 红
```

全仓 `grep -rn "MUTANT|MUTATION|XXX-MUT"` 当时只有这一处（其余命中在 `src/third-party/sqlite3`，无关）。
该变异体在复核结束时已消失、自检回到 `51/51 PASS`。
**副产物（正向）**：它证明 `C0GateTest` 的 allowLegacy 断言不是空断言。

**(b) `--gatetest` 用例 11 一度 3/3 红**

某个中间二进制上 `gatetest failed (71 ok / 5 FAIL)`，5 条全为 `11) forced INVALID: ...`。
说明「用例 11」与其所需的 `peer == INVALID` 幂等分支是分两步落地的，中间存在红窗口。当前已绿。

---

## 2. 「已知结论」逐条裁定

| # | 结论 | 裁定 | 证据 |
|---|---|---|---|
| 1 | `android/gradlew` index mode = `100755` | **成立** | `git ls-files -s android/gradlew` → `100755 adff685a...`；`ls -l` → `-rwxr-xr-x`。**风险**：`git config core.fileMode = false`，本机权限位变化不会被 git 发现，只有 index 位有意义 |
| 2 | `dependsOn 'compileDebugJavaWithJavac'` 在 `android/app/build.gradle` | **成立** | `grep -n` → `157:    dependsOn 'compileDebugJavaWithJavac'`（行号随他人注释插入浮动，内容不变） |
| 3 | PC / Android `linkModeOf` 判定顺序逐分支一致（F12） | **成立**（并有强证据） | 逐分支：`len<12 或 type!=REGISTER` → `intOf==1 → UNKNOWN` → `cap==0 → UNKNOWN` → `magic 缺失或保留位≠0 → INVALID` → `mode bit ? B : A`；常量同 `0x40/0x01`。另做**跨语言差分**：`GBoyFrames.cpp` 与 `GBoyFrames.java` 各自独立编译、同表 24 读 + 18 写，`diff -u` **EXIT=0、43 行全同**。唯一形式差异是 Java 的 `body==null` 分支，C++ 空 `QByteArray` 走同一条 `<12` 分支，语义等价 |
| 4 | 写侧：`registerFrame(p,b,mode)` 在 `p==1` 时不写能力位、与 2 参数版逐字节相同 | **成立** | 8 个用例（b=0/1/0x40/0x41/0x12345678/-1 × mode UNKNOWN/A/B/INVALID）全部 `same=1`；`p≠1` 且显式 A/B 才写 `0x40/0x41`；`mode=UNKNOWN/INVALID` 一律 `wire[15]=0` |
| 5 | `--gatetest` 驱动真 `negotiateLinkMode()` 本体 | **成立（附一条口径边界）** | `result.accepted = link.negotiateLinkMode(&room, "gatetest")`；读真成员 `m_officialMode/m_linkMode/m_peerLinkMode/m_closed/m_modeRejected`；`QObject::connect(&link, &QGBA::CloudLink::statusMessage, ...)`。**边界**：帧→模式的接线是测试手工串的 `notePeerLinkMode(linkModeOf(wire.mid(4)), ...)`，**不是真 socket 收包路径**；判定逻辑/状态机/成员/信号是真的，「谁来喂帧」是模拟的 |
| 6 | `isReady()` 只有 `GBoySocketLink` 一个调用点 | **部分成立（口径须收窄到 Android）** | `android/app/src/main`：`GBoyLinkSession.isReady()` **零外部调用点**，2 处调用打的是 `startTcp()` 内的局部 `GBoySocketLink link`（`GBoyCloudLink.java:345`）。**但 PC 侧是功能依赖**：`GBoyLinkSession.cpp:117 if (!isReady()) { onStatus("pre-ready key frame ignored"); break; }` 是**按键门控**；`CloudLink.cpp:2185` 才是诊断日志。不能当作「全仓无功能依赖」 |
| 7 | `m_gatePump` 生产零调用点 / 未注入时行为不变 | **部分成立** | 生产有 **3 处读**：`CloudLink.cpp:2972 / 2976 / 2981`；**零生产写入**（唯一赋值 `gboylink_test.cpp:3685`）。`std::function` 默认空 ⇒ 2972 `!m_gatePump` 恒真、2976 恒走 else ⇒ **「未注入时行为不变」成立**。正确说法是「零注入点」，不是「零调用点」 |
| 8 | `sioFastFrame` 只在 PC/Qt | **成立** | 全仓仅 `src/platform/qt/sio_link.c`（955 定义 / 1017 注释 / 1069 调用）；只被 `src/platform/qt/CMakeLists.txt:235/295` 引用；根 `CMakeLists.txt:1082 if(BUILD_QT) add_subdirectory(src/platform/qt)`，`android/app/build.gradle:25` 传 `-DBUILD_QT=OFF` ⇒ **Android 不编译该文件** |
| 9 | 两端 `GBoyLinkSession` 行为对齐 | **不成立（不对称，需工程确认）** | Java 版**没有** C++ 的 pre-ready 按键门控：`TYPE_KEYS` 直接 `pushKeys(senderSlot, intOf(body))`，`ready` 仅用于判 `first` 触发一次 `onReady()`。C++ 注释称无此门会「凭空按下 1/2/4 号键」。**本条不判为缺陷**，但需回答「Android 上 ready 之前的键帧会不会被误按下」 |

---

## 3. 临时变异：证明 `dependsOn 'compileDebugJavaWithJavac'` 真生效

| 项 | 事实 |
|---|---|
| 变异目标 | `android/app/src/main/java/io/mgba/android/GBoyFrames.java:93`：`LINK_CAP_MAGIC 0x40 → 0x42`（该常量被 `C0LinkModeTest:59/64` **硬编码**断言，不会因读写同源而自洽） |
| 执行方式 | **只跑** `./gradlew :app:runLinkSelfTests --offline --console=plain`，**不手动预编译** |
| 结果 | `C0LinkModeTest` **58/58 → 52/58，6 条红**，**EXIT=1** |
| 红的断言 | `capability bits stay bit6=declared / bit0=mode`；`3-arg registerFrame writes 0x40 into wire[15]`；`... writes 0x41 into wire[15] for mode B`；`reserved bit set (0x42) -> INVALID(-2)`；`3-player frames still carry 0x40 / 0x41 at wire[15]`；`mode A writes 0x40 and mode B writes 0x41` |
| 红的性质 | **断言红，非编译错**：`> Task :app:compileDebugJavaWithJavac` 正常完成后 `=== RUN C0LinkModeTest ===` 打印 FAIL，Gradle 因 java 进程 `non-zero exit value 1` 而 `BUILD FAILED` |
| 关键证据 | `> Task :app:compileDebugJavaWithJavac`（**无 `UP-TO-DATE` 后缀**）⇒ `dependsOn` 确实把主源码编译拉起来了 |
| 字节码级复核 | `javap -p -constants` → `static final int LINK_CAP_MAGIC = 66`（=0x42），**排除增量缓存跑旧 class 的一切解释** |
| 还原 | `git checkout -- android/app/src/main/java/io/mgba/android/GBoyFrames.java` |
| 还原后 | `43/43 PASS`、`58/58 PASS`、`8/8 PASS`，**EXIT=0**；`javap` 回到 `64`；`git diff --quiet → CLEAN` |
| 最终态 | `GBoyFrames.java` 不在 `git status` 中，常量 `0x40` |

**一次失败尝试（如实记录）**：首次跑出 `> Task :app:compileDebugJavaWithJavac UP-TO-DATE` 却仍 6 条红。
UP-TO-DATE 却有红，只能解释为**并发会话在我编辑后、我跑之前抢先编译过**；该跑法证明不了 `dependsOn`，
故**作废**，改用 `javap` 读字节码重做。

**教训（写给后来人）**：**共享工作区不允许做任何变异**。本次变异虽在 2 分钟内还原，仍污染了同事的验收
（`52/58` 被当作 P0 上报）。若要再做变异验证，必须满足：单独 worktree / 冻结工作区 / 提前告知在跑验收的人。

---

## 4. 测试债（必须转派，不能只留在报告里）

### 债 1 · `expectShortCircuit` 在 `accepted == true` 时空转通过（**假阴性断言**）—— ⚠️ **已在工作区修复（未提交）**

> **状态更新（写报告时实测）**：本条我报告后已被工程侧修掉，但**修在工作区、尚未进 `HEAD 0801ef184`**。
> 证据：
> ```
> $ git show HEAD:src/platform/qt/test/gboylink_test.cpp | grep -c "expectSecondCall\|secondCallDone"   → 0
> $ grep -c "expectSecondCall\|secondCallDone" src/platform/qt/test/gboylink_test.cpp                    → 21
> $ git status --porcelain →  M src/platform/qt/test/gboylink_test.cpp
> ```
> 新实现 `expectSecondCall(what, r, expectShortCircuit)` 引入 `secondCallDone / secondFailCount`，
> 并把「第一次接受」与「第一次拒绝」两种场景参数化；源码注释里已写明旧版「在 accepted 场景下必然绿，属于假阴性断言」。
> **但「修了」不等于「修对」**：仍需按下面的验收标准验证一次，否则只是把假阴性换了个位置。

- **原问题（留档）**：旧 `expectShortCircuit` 断言 `!r.secondAccepted && r.secondElapsedMs < 50 && r.secondStatusCount == 0`，
  而「第二次调用」整段包在 `if (!result.accepted) { ... }` 里。当协商被**错误接受**时该段被跳过，
  三个字段停在默认值 `secondAccepted=false / secondElapsedMs=0 / secondStatusCount=0`，
  于是 `!false && 0<50 && 0==0` ⇒ **恒真通过**。
- **危害**：比「缺断言」更坏——它给出虚假覆盖感。用例 11 那次红时它「绿着」就是实例。
- **原建议修法（供核对是否与落地实现一致）**：
  - **A（最小改动）**：`expectShortCircuit` 内加前置断言 `expect(!r.accepted, "... precondition")`；
  - **B（结构调整，即实际落地的那条）**：把第二次调用移出 `if (!result.accepted)`，引入
    `secondCallDone` 标记「探针真的调过」，让恒 0/恒 false 不再是「通过」的理由。
- **验收标准（尚未执行，需补做）**：临时注释掉 `negotiateLinkMode()` 顶部的 `if (m_modeRejected) return false;`，
  第二次调用相关断言必须**变红**。若仍全绿，说明新实现只是把假阴性从「accepted 场景」挪到了别处。
  **本条未做 —— 原因：报告落盘时工作区正在被并发改动，按纪律不做第二次变异，改由责任人在冻结 commit 上补做。**

### 债 2 · 读写往返断言用自家 writer 造的帧（**对称性缺陷盲区**）—— ⚠️ **仍未修（本报告落盘时全仓无固定向量文件）**

- **状态核验**：`ls tests/2p-cloud/` 只有 3 份 md；`find tests -name "*vector*" -o -name "*.hex"` 无命中
  ⇒ **「官方抓包固定向量」尚未落盘，本条成立且未修**。
- **现状**：`--c0` / `--gatetest` 中大量断言形如 `linkModeOf(registerFrame(p, b, mode))`，
  若 writer 与 reader 同时朝同一方向写错，会互相抵消而全绿。
- **已有的部分兜底**：`--c0` 里有两组**写死的官方 16 字节数组**做绝对比对；`0x42 / 0xFF / 1 人房 /
  11 字节 / null / 伪造 20 字节 SIO 包（player=0x0240 让第 11 字节正好 0x40）** 都是手写固定夹具。
  但这些不是全表基准。
- **可执行修法**：新增一份「官方 APK 抓包固定向量」表（至少覆盖 type 1 注册帧 5 类输入 + type 2/3/5/6/100
  各 1 条真实字节），放成 `tests/2p-cloud/vectors/*.hex`，由 `--c0` 与 Android `C0LinkModeTest` **各自独立读取**
  同一份向量做绝对比对（而不是各自用自己的 writer 生成期望值）。
- **验收标准**：把 writer 的 `LINK_CAP_MAGIC` 与 reader 的 `LINK_CAP_MAGIC` **同时**改成 `0x42`，
  现有断言应保持全绿（证明存在盲区）；接入固定向量后，同一变异必须变红。

---

## 5. 门控判定

### 5.1 2P 云端交付门：**FAIL（不放行）** — 主理人已采纳

依据（均为可复现事实）：

- **云端数据通路端到端断言：0 条**；**跨设备真机 E2E 落盘证据：0 条**。
- **所有云端 `flow_*.log` 的 `BATTLE=YES` 计数全为 0**：
  `flow_2pA / flow_4core / flow_4core_v2 / flow_fix3 / flow_script / flow_sync / flow_title / flow_verdict` = **0**，
  其余日志无该计数字段，**没有任何一份出现非 0** ⇒「从未进过对战」这一事实**没有被本轮任何证据推翻**。
- KL-5（协商门 2 s 在真实云端链路从未实测）、KL-4（跨设备 2P 未闭环 / PC `C0000005` /
  `sioFastFrame` 仅 PC-Qt / 2P 局域网 ADB 零覆盖）仍然成立。

**口径红线**：**禁止用「本地回归全绿」替代「跨设备云端 2P 闭环」。**
本机绿的是「协商门 + 帧层 + 自检」，不是「可玩的 2P 云端」。

### 5.2 C/Qt 本地回归门：**CONCERNS（不放行 P0 级别之外的收口）**

- 复核人初始建议为 **PASS**，**主理人裁定为 CONCERNS**，理由是：6 次采样全绿只是「没复现」，
  而历史那次低频 flaky（38 次采样 1 次 `EXIT=1`）**从未被归因**、首次失败日志被 `tail` 截断丢失。
  一个未归因的低频 flaky 留在主测试二进制里，会直接折损 CI 信号可信度——而这正是本轮修 `dependsOn` 想保住的东西。
- **升级为 PASS 的条件（二选一）**：
  1. 在**冻结 commit** 上连跑 `mgba_mobile_test` 全套 **≥ 20 次全绿**（并保留每次完整日志）；或
  2. 复现该 flaky 并修掉根因，附根因说明与回归断言。
- **另加两道硬门（已由主理人转派责任人）**：
  1. `grep -rn "MUTANT" android/app/src src/platform` 必须为空，且提交前逐个过 `git diff`——本轮实测出现过一次
     「生产代码带遗留变异体」的交付级风险。
  2. 放行前在冻结 commit 上重跑本条 §1 全量并记录二进制 md5；否则 `--gatetest` 条数会继续漂
     （本轮实测 56 → 64 → 76 → **81**），文档与实跑对不上。

---

## 6. 三句话

**（1）这次复核实际证明了什么**
在 `HEAD 0801ef184`（干净工作区）与批次 C 快照双绑定下，证明了**「C0 能力协商位 + 帧层 + 本机自检」这一层是真的**：
两端 `linkModeOf/registerFrame` 逐字节等价（43 行跨语言差分零差异，含 1 人房 `0x40/0x41` 尾巴、`playerCount=0`、
`0xFFFFFFFF`、11 字节、null、非注册 type）；`--gatetest` 驱动真 `negotiateLinkMode()` 本体、读真成员、听真 `statusMessage`；
2 s 有界等待 8 次采样稳定 2001~2017 ms 且不越 2400 ms（用例 8 钉死 F7）；本地五档套件与 Android 自检全绿；
`dependsOn` 修正**真生效**——字节码级证据 `66 ↔ 64`、红→绿闭环。

**（2）这次复核没有证明什么**
跨设备云端 2P 端到端闭环（`BATTLE=YES` 全 0）；真实 WSS 会话下 `drainSignaling()` 主路径时序（只覆盖注入泵的
「排空语义」模拟）；真机双机走位、真机帧率、Android native path A `4.6~4.9fps` 达标性、PC path A `C0000005`
是否已修、iOS 互操作；也没有证明「无 flaky」（只证明 13 次采样未复现）。此外本报告**有效期极短**：
复核期内 HEAD 漂了 8 个提交、断言条数漂了 4 次、出现两次真实红态。

**（3）建议的最终门控判定**
**2P 云端交付门 = FAIL**（云端数据通路 0 条断言 / 真机 E2E 0 条证据 / `BATTLE=YES` 全 0）；
**C/Qt 本地回归门 = CONCERNS**（本地全绿但低频 flaky 未归因未隔离，升级条件见 §5.2）。
