# 2P 联机 · 独立复核报告（只读复核 + 一次可回滚临时变异）

> **元结论（先读这句，比报告里任何数字都重要）**
> **本报告有效期极短：复核期间仓库有 8 个提交，`--gatetest` 断言条数从 56 漂到 81 共四次，
> 两次真实红态都发生在我复核过程中。因此任何「全绿」结论都必须绑定到具体 commit + 二进制哈希，
> 否则不可引用。**

| 项 | 值 |
|---|---|
| 复核人 | quality-lead-2-2（独立复核者，**不是实现者**） |
| **证据主体 revision** | 批次 C（跨 `f355bd59f`→`0be5da192` 的移动窗口，**以哈希钉住**；结论所依据的 HEAD 记为 **`0be5da192`**） |
| 证据主体·PC 测试二进制 | `build-win/qt/test-gboylink.exe` = `a99e49deb03fb9ed4694f6ebe2f7facb` |
| 证据主体·移动端二进制 | `build-mobile-test/mgba_mobile_test.exe` = `91f142639eeae33c344097d314fec126` |
| 证据主体·源码 | `src/platform/qt/CloudLink.cpp` = `02f08d44dc766238ab987ef654b0478f`<br>`src/platform/qt/test/gboylink_test.cpp` = `f0f89215e9942915f00c1431c8d8e90d`<br>`src/platform/qt/GBoyFrames.cpp` = `e2daf63de5b739fe83f2a5a98c2487d8` |
| 补充批次 D | 干净工作区 `HEAD 0801ef184`，`test-gboylink.exe` = `9999b192…`、`gboylink_test.cpp` = `fc60c05e…`，仅作补充（见 §1.4） |
| 平台 | Windows + Git Bash（`msys64/mingw64`）；PATH **必须**含 `build-win` 与 `build-win/qt`，否则 `test-gboylink.exe` exit 127（找不到 `libmgba.dll`） |

> **条数漂移声明（不可省）**
> `--gatetest` 断言条数在复核期间经历 **56 → 64 → 76 → 81（共四次）**，`--c0` 稳定在 **45**，
> Android `runLinkSelfTests` 从 `43/58` 涨到 **`51/58`**。
> **任何写死的条数都不能进交付判定**，只能写「以当次输出为准」+ 绑 revision。

---

## 0. 一句话结论

- **C0 能力协商位 + 帧层 + 本机自检这一层：已被独立证据证明为真。**
- **跨设备云端 2P 可玩性：未被证明，且所有已落盘云端日志的 `BATTLE=YES` 计数仍为 0。**

---

## 1. 全量回归（按批次绑定 revision/哈希，不跨批混用）

### 1.1 批次 A —— **自我作废，不拿它支撑任何结论**

复核起点 `HEAD = 6d30e23e6`，工作区**不干净**（`M production/release/2p-link-release-checklist.md`、
`M src/platform/qt/test/gboylink_test.cpp`、`M tests/2p-cloud/AC1-AC6-验收矩阵.md`）。
该批次的数字（`--gatetest 56 ok ×3`、mobile 全套 `252 ok ×3` 等）**全部作废**，理由是：
**执行期间 HEAD 发生了变化（同事提交），同一组数字无法归属到单一 revision。**
如实交代这个缺口：我最初是**按批次记哈希、不是按命令记 HEAD**，这是方法缺陷，不用它掩盖。

### 1.2 批次 B —— 过程记录（工作区不干净）

`HEAD = df5f7fe84`（记录于 `/tmp/qa_snap_head.txt`）；工作区含他人未提交改动
（`M android/app/build.gradle` + 未跟踪 `C0GateTest.java`、`android/util/Log.java`）。
重编后：`--c0 45/0`、`--gatetest 64/0 ×3`、三件套全 PASS、mobile `164/169/37/64`、全套 `252/0 ×3`。

### 1.3 批次 C —— **本报告的证据主体**（跑前跑后哈希一致：`SNAPSHOT_STABLE=YES`）

工作区状态：**含未提交改动**（`CloudLink.cpp`、`gboylink_test.cpp` 当时均为 `M`，是同事在写；
按规定**未 checkout、未 stash**，只在本报告标注「结果对应含未提交改动的工作区，非某次提交」）。

| 命令 | 输出末尾 | EXIT |
|---|---|---|
| `ninja -C build-win test-gboylink mgba-qt` | 链接成功 | 0 |
| `cp -f build-win/libmgba.dll build-win/qt/ && cmp` | `CMP_OK=identical` | 0 |
| `test-gboylink --c0` | `c0 tests passed (45 ok / 0 FAIL)` | 0 |
| `test-gboylink --gatetest` ×3 | `gatetest passed (76 ok / 0 FAIL)` ×3 | 0 / 0 / 0 |
| `test-gboylink frames` | `RECONNECT TEST: PASS` + `TCPDIRECT TEST: PASS` | 0 |
| `test-gboylink buslocal` | `BUSLOCAL TEST: PASS` + `SESSIONSLOT TEST: PASS` | 0 |
| `test-gboylink product-lockstep` | `product-lockstep: PASS (4 cores, product SIO lockstep)` | 0 |
| `mgba_mobile_test --bus / --link / --lockstep / --audioall` | `164 / 169 / 37 / 64 ok`，0 FAIL | 0 / 0 / 0 / 0 |
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

### 1.4 批次 D —— 干净工作区补充验证（`HEAD 0801ef184`）

落盘前碰到工作区恰好干净（跑前 `git status --porcelain` 为空），补跑一轮：

```
ninja -C build-win test-gboylink mgba-qt   → EXIT=0
test-gboylink.exe --c0                     → c0 tests passed (45 ok / 0 FAIL)      EXIT=0
test-gboylink.exe --gatetest  #×3          → gatetest passed (81 ok / 0 FAIL) ×3   EXIT=0/0/0
test-gboylink.exe frames                   → TCPDIRECT TEST: PASS                  EXIT=0
test-gboylink.exe buslocal                 → SESSIONSLOT TEST: PASS                EXIT=0
test-gboylink.exe product-lockstep         → product-lockstep: PASS (4 cores)      EXIT=0
```

跑完那一瞬 `M src/platform/qt/test/gboylink_test.cpp` 又出现（同事在同一秒开始写）——这就是必须绑哈希的原因。

### 1.5 flaky 采样（只报「没复现」，不报「已解决」）

- `mgba_mobile_test` 全套累计 **6 次**（批次 A 3 + 批次 C 3）：6/6 `252 ok / 0 FAIL`。
- `--gatetest` 累计 **8 次**（A 3 + C 3 + D 3）：全绿。
- **本轮未复现历史那次低频 flaky**（历史 38 次采样 1 次 EXIT=1）。**这只说明「没复现」**；
  且该次失败**从未被归因**、首次失败日志被 `tail` 截断丢失 ⇒ 这是 §5.2 判 CONCERNS 的直接依据。
- `android/app/src/test/java/android/util/Log.java` 桩**在复核期间已存在**（4055 B，mtime 15:38），
  三份自检日志 `grep -c NoClassDefFoundError` = **0 / 0 / 0** ⇒ 噪声确实消失，**不是「桩还没来」**。

### 1.6 环境陷阱（会静默产生错误结论，务必记）

1. **`git config core.fileMode = false`**：本机文件权限位变化**不会**被 git 发现。
   `gradlew` 的可执行位只能用 `git update-index --chmod=+x` 走索引修；若有人 `chmod +x` 后直接提交，
   **会静默失败**，CI 上表现为 `./gradlew: Permission denied`。
2. **PATH 必须含 `build-win` 与 `build-win/qt`**，否则 `test-gboylink.exe` exit 127（找不到 `libmgba.dll`）。
3. **DLL 被占用**：起测前需 `taskkill -F -IM mGBA.exe`，否则链接 `libmgba.dll` 失败。
4. **并发构建会替换 exe/DLL**：一次伪失败（`EXIT=1`、710 ms、日志仅 17 行）根因是并发构建换了二进制，
   不是代码缺陷。**判「红」之前先看二进制 mtime 与 md5 是否变过。**

### 1.7 复核期间观察到的两次真实红态（均已恢复，必须留档）

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
**危害特征**：所有**单端**自测都不会红，只有「Android × 旧客户端」组合失效，而那条组合**零自动化测试**。

**(b) `--gatetest` 用例 11 一度 3/3 红**

某个中间二进制上 `gatetest failed (71 ok / 5 FAIL)`，5 条全为 `11) forced INVALID: ...`。
说明「用例 11」与其所需的 `peer == INVALID` 幂等分支是分两步落地的，中间存在红窗口。当前已绿。

---

## 2. 「已知结论」逐条裁定（9 条，含两处纠正主理人口径）

| # | 结论 | 裁定 | 证据 |
|---|---|---|---|
| 1 | `android/gradlew` index mode = `100755` | **成立** | `git ls-files -s android/gradlew` → `100755 adff685a...`。**陷阱**：`core.fileMode=false`，见 §1.6 |
| 2 | `dependsOn 'compileDebugJavaWithJavac'` 存在 | **成立** | `android/app/build.gradle` → `dependsOn 'compileDebugJavaWithJavac'`（行号随他人注释浮动） |
| 3 | PC / Android `linkModeOf` 判定顺序逐分支一致（F12） | **成立**（强证据） | 逐分支：`len<12 或 type!=REGISTER` → `intOf==1 → UNKNOWN` → `cap==0 → UNKNOWN` → `magic 缺失或保留位≠0 → INVALID` → `mode bit ? B : A`；常量同 `0x40/0x01`。另做**跨语言差分**：`GBoyFrames.cpp` 与 `GBoyFrames.java` 各自独立编译、同表 24 读 + 18 写，`diff -u` **EXIT=0、43 行全同** |
| 4 | 写侧 `registerFrame(p,b,mode)` 在 `p==1` 时不写能力位、与 2 参数版逐字节相同 | **成立** | 8 用例（b=0/1/0x40/0x41/0x12345678/-1 × mode UNKNOWN/A/B/INVALID）全部 `same=1`；`p≠1` 且显式 A/B 才写 `0x40/0x41`；`mode=UNKNOWN/INVALID` 一律 `wire[15]=0` |
| 5 | `--gatetest` 驱动真 `negotiateLinkMode()` 本体 | **成立（附口径边界）** | 调真方法、读真成员 `m_officialMode/m_linkMode/m_peerLinkMode/m_closed/m_modeRejected`、连真 `statusMessage` 信号。**边界**：帧→模式的接线是测试手工串的 `notePeerLinkMode(linkModeOf(wire.mid(4)), ...)`，**不是真 socket 收包路径**——判定逻辑真、喂帧是模拟 |
| 6 | `isReady()` 只有一个调用点 | **部分成立（纠正口径）** | 只对 **Android Java** 成立：`GBoyLinkSession.isReady()` 零外部调用点，2 处调用打的是 `startTcp()` 内的局部 `GBoySocketLink link`（`GBoyCloudLink.java:345`）。**PC 侧是功能依赖**：`GBoyLinkSession.cpp:117 if (!isReady()) { onStatus("pre-ready key frame ignored"); break; }` 是**按键门控**；`CloudLink.cpp:2185` 才是诊断日志 |
| 7 | `m_gatePump` 生产零调用点 | **部分成立（纠正口径）** | 生产有 **3 处读**：`CloudLink.cpp:2972 / 2976 / 2981`；**0 处生产写**（唯一赋值 `gboylink_test.cpp:3685`）。正确说法是「**零注入点**」。`std::function` 默认空 ⇒ 2972 `!m_gatePump` 恒真、2976 恒走 else ⇒ **「未注入时行为不变」成立** |
| 8 | `sioFastFrame` 只在 PC/Qt | **成立** | 全仓仅 `src/platform/qt/sio_link.c`（955/1017/1069）；只被 `src/platform/qt/CMakeLists.txt:235/295` 引用；根 `CMakeLists.txt:1082 if(BUILD_QT) add_subdirectory(src/platform/qt)`，`android/app/build.gradle:25` 传 `-DBUILD_QT=OFF` ⇒ **Android 不编译该文件** |
| 9 | 两端 `GBoyLinkSession` 行为对齐 | **不成立（不对称，需工程确认）** | Java 版**没有** C++ 的 pre-ready 按键门控：`TYPE_KEYS` 直接 `pushKeys(...)`，`ready` 仅用于判 `first` 触发一次 `onReady()`；C++ 注释称无此门会「凭空按下 1/2/4 号键」。**不判为缺陷**，但需回答「Android 上 ready 之前的键帧会不会被误按下」 |

---

## 3. 临时变异：证明 `dependsOn 'compileDebugJavaWithJavac'` 真生效

| 项 | 事实 |
|---|---|
| 变异目标 | `android/app/src/main/java/io/mgba/android/GBoyFrames.java:93`：`LINK_CAP_MAGIC 0x40 → 0x42`（被 `C0LinkModeTest:59/64` **硬编码**断言，不会因读写同源而自洽） |
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

**本次变异造成的事故与机理（写进纪律，见 §6 硬门 3）**：变异虽在 2 分钟内还原，
但仍污染了同事的全量验收（`52/58` 被上游当作 P0 协议漂移上报）。
机理补充：**还原只还原了源文件，变异体编译出的 `.class` 仍留在 `build/intermediates`**
（`android/app/build/intermediates/javac/debug/.../GBoyFrames.class` 里常量是 66），
这解释了「工作区干净但断言仍红」的现象；必须同时保证编译输出不被复用（独立 build 目录）。

---

## 4. 测试债

### 债 1 · `expectShortCircuit` 在 `accepted == true` 时空转通过（假阴性断言）—— ⚠️ **已修复，但修在工作区、未进 `HEAD`**

> **状态（写报告时实测）**：
> ```
> $ git show HEAD:src/platform/qt/test/gboylink_test.cpp | grep -c "expectSecondCall\|secondCallDone"  → 0
> $ grep -c "expectSecondCall\|secondCallDone" src/platform/qt/test/gboylink_test.cpp                  → 21
> $ git status --porcelain →  M src/platform/qt/test/gboylink_test.cpp
> ```
> 新实现 `expectSecondCall(what, r, expectShortCircuit)` 引入 `secondCallDone / secondFailCount`，
> 把「第一次接受」与「第一次拒绝」两种场景参数化；源码注释已写明旧版「在 accepted 场景下必然绿，属于假阴性断言」。

- **原问题（留档）**：旧 `expectShortCircuit` 断言 `!r.secondAccepted && r.secondElapsedMs < 50 && r.secondStatusCount == 0`，
  而「第二次调用」整段包在 `if (!result.accepted) { ... }` 里。协商被**错误接受**时该段被跳过，
  三字段停在默认值 `secondAccepted=false / secondElapsedMs=0 / secondStatusCount=0`，
  于是 `!false && 0<50 && 0==0` ⇒ **恒真通过**。
- **危害**：比「缺断言」更坏——给出虚假覆盖感。用例 11 那次红时它「绿着」就是实例。
- **验收标准（尚未执行）**：临时注释掉 `negotiateLinkMode()` 顶部的 `if (m_modeRejected) return false;`，
  第二次调用相关断言**必须变红**；若仍全绿，说明假阴性只是挪了位置。
  **本条未做** —— 报告落盘时工作区正被并发改动，按纪律**不做第二次变异**，改由责任人在**冻结 commit + 独立 build 目录**上补做。

### 债 2 · 读写往返断言用自家 writer 造的帧（对称性缺陷盲区）—— ⚠️ **仍未修**

- **状态核验**：`ls tests/2p-cloud/` 只有 3 份 md；`find tests -name "*vector*" -o -name "*.hex"` 无命中
  ⇒ **「官方抓包固定向量」尚未落盘，本条成立且未修**。
- **现状**：大量断言形如 `linkModeOf(registerFrame(p, b, mode))`，writer 与 reader 同时朝同一方向写错会互相抵消而全绿。
- **已有部分兜底**：`--c0` 有两组**写死的官方 16 字节数组**做绝对比对；`0x42 / 0xFF / 1 人房 / 11 字节 / null /
  伪造 20 字节 SIO 包（player=0x0240 让第 11 字节正好 0x40）** 都是手写固定夹具。但不是全表基准。
- **修法**：新增「官方 APK 抓包固定向量」表（type 1 注册帧 5 类输入 + type 2/3/5/6/100 各 1 条真实字节），
  放成 `tests/2p-cloud/vectors/*.hex`，由 `--c0` 与 Android `C0LinkModeTest` **各自独立读取同一份向量**做绝对比对。
- **验收标准**：把 writer 与 reader 的 `LINK_CAP_MAGIC` **同时**改成 `0x42`，现有断言应保持全绿（证明盲区存在）；
  接入固定向量后，同一变异必须变红。

---

## 5. 门控判定

### 5.1 2P 云端交付门：**FAIL（不放行）**

依据（均为可复现事实）：

- **云端数据通路端到端断言：0 条**；**跨设备真机 E2E 落盘证据：0 条**。
- **所有云端 `flow_*.log` 的 `BATTLE=YES` 计数全为 0**：
  `flow_2pA / flow_4core / flow_4core_v2 / flow_fix3 / flow_script / flow_sync / flow_title / flow_verdict` = **0**，
  其余日志无该计数字段，**没有任何一份出现非 0** ⇒「从未进过对战」这一事实**没有被本轮任何证据推翻**。
- KL-5（协商门 2 s 在真实云端链路从未实测）、KL-4（跨设备 2P 未闭环 / PC `C0000005` /
  `sioFastFrame` 仅 PC-Qt / 2P 局域网 ADB 零覆盖）仍然成立。

**口径红线**：**禁止用「本地回归全绿」替代「跨设备云端 2P 闭环」。**
本机绿的是「协商门 + 帧层 + 自检」，不是「可玩的 2P 云端」。

### 5.2 C/Qt 本地回归门：**CONCERNS**

**判定与理由（主理人与复核人合并后的统一措辞）**：
> 判 **CONCERNS**，并附复核人的条件原文。
> 标签用 CONCERNS 是因为「**主信号不可信**」这件事本身就是一个 concern；若标 PASS，读者会跳过那句条件。

**复核人条件原文（一字不改）**：
> 本地全套虽全绿，但 `mgba_mobile_test` 的**低频 flaky 未隔离**（历史 38 次采样 1 次 EXIT=1）
> —— 按测试稳定性纪律，**它不该继续以「主信号」身份进 CI 闸门**，要么隔离成 `known-flaky` 单独跑，
> 要么让失败日志留全（本轮我没遇到失败，所以没资格说它已稳）。

**升级为 PASS 的条件（三条任一达成即可）**：
1. 在**冻结 commit** 上 `mgba_mobile_test` 全套**连跑 ≥ 20 次全绿**（并保留每次完整日志）；或
2. **复现并修掉根因**，附根因说明与新增回归断言；或
3. 将它**隔离成 `known-flaky` 并从主 CI 闸门移出**（主闸门只跑稳定子集）。

> 这样后来人看到的不是「两个评审意见不一致」，而是「**差哪三件事就能升级**」。

---

## 6. 建议节：三道硬门（放行前必须全过）

### 硬门 1 · 变异体扫描
```
grep -rn "MUTANT\|MUTATION\|XXX-MUT" android/app/src src/platform    # 必须为空
```
外加提交前逐个过 `git diff`。**依据**：本轮实测出现过一次「生产代码带遗留变异体」——
`GBoyCloudLink.java:2802` 的 `/* MUTANT */` 把 `allowLegacy` 回落整条摘掉，
而**所有单端自测都不会红**，只有「Android × 旧客户端」组合失效（该组合零自动化测试）。

### 硬门 2 · 冻结 commit 重跑 + 记哈希
放行前在**冻结 commit** 上重跑本地全套，并记录 `test-gboylink.exe` / `mgba_mobile_test.exe` 的 md5。
**依据**：本轮 `--gatetest` 条数 56→64→76→81 漂了四次，不绑 revision 的「全绿」无法复核。

### 硬门 3 · 变异验证必须在 `git worktree` + 独立 build 目录里做
**禁止在共享工作目录做任何源码变异。** 本轮三次事故同一根因：四人共用**同一个工作目录**与**同一个
`build/` 输出目录**：
1. 我把 `LINK_CAP_MAGIC` 改成 `0x42`，导致同事的全量验收当场 6 条红、被当作 P0 协议漂移上报；
2. 某人留下的 `/* MUTANT */` 差点随提交进仓库；
3. 并发构建替换 exe/DLL，造成一次**伪失败**（`EXIT=1`、710 ms、日志仅 17 行），最终靠 mtime 才查清。

**机理（这是本条最关键的部分）**：**还原源码 ≠ 还原结论**——
变异还原后，变异体编译出的 `.class` / `.obj` 仍留在 `build/intermediates`（本轮实测
`GBoyFrames.class` 里常量仍是 `66`），于是出现「工作区干净但断言仍红」。
**所以变异验证必须**：`git worktree add` 独立目录 + 独立 build 目录 + 提前告知正在跑验收的人。

---

## 7. 三句话

**（1）这次复核实际证明了什么**
在批次 C（`HEAD 0be5da192` 窗口，哈希 `a99e49de / 91f14263 / 02f08d44 / f0f89215 / e2daf63d` 绑定）下，
证明了**「C0 能力协商位 + 帧层 + 本机自检」这一层是真的**：两端 `linkModeOf/registerFrame` 逐字节等价
（43 行跨语言差分零差异，含 1 人房 `0x40/0x41` 尾巴、`playerCount=0`、`0xFFFFFFFF`、11 字节、null、非注册 type）；
`--gatetest` 驱动真 `negotiateLinkMode()` 本体、读真成员、听真 `statusMessage`；
2 s 有界等待 8 次采样稳定 2001~2017 ms 且不越 2400 ms（用例 8 钉死 F7）；
本地五档套件与 Android 自检全绿；`dependsOn` 修正**真生效**——字节码级证据 `66 ↔ 64`、红→绿闭环。

**（2）这次复核没有证明什么**
跨设备云端 2P 端到端闭环（`BATTLE=YES` 全 0）；真实 WSS 会话下 `drainSignaling()` 主路径时序
（只覆盖注入泵的「排空语义」模拟，不是真网络）；真机双机走位、真机帧率、Android native path A
`4.6~4.9fps` 达标性、PC path A `C0000005` 是否已修、iOS 互操作；
也没有证明「无 flaky」（只证明 13 次采样未复现）。此外本报告**有效期极短**，见文首元结论。

**（3）建议的最终门控判定**
**2P 云端交付门 = FAIL**（云端数据通路 0 条断言 / 真机 E2E 0 条证据 / `BATTLE=YES` 全 0）；
**C/Qt 本地回归门 = CONCERNS**（本地全绿但低频 flaky 未归因未隔离，升级条件见 §5.2 三条任一）。
放行前另须过 §6 三道硬门。
