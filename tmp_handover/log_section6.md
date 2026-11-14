
## 2026-11-14 凌晨:iOS 运行时 CI 验证(6 轮迭代,移交备注)

- **iOS 锁步运行时验证进入 CI**(launch-args 入口 + 生成 ROM + GBOY_RT
  里程碑断言)。6 轮迭代逐层修:ROM 校验和(0xBD)→ 设备码(0xB2=0x96)→
  CI 无音频(audio.start 挂死,-gboySilent 旁路)→ mirrorFrames 越界
  (count vs players)→ 主线程 watchdog(后台队列)→ mLogger 编译错
  (该版本 mLogger={log,filter},无 context)。
- **功能矩阵审计**:Android vs iOS 20 项特性文件级全对齐(iOS 缺口仅剩
  行为级:锁步入口自动化[已建]、云端 2P[并发会话 WIP])。
- **普通锁步回归**:并发会话最新构建上 59.7fps 无冻结(其 budget=4 演化
  修掉了首帧死锁;我此前观察的是中间态)。
- **交接**:GBoyConsoleSet.java 与 mgba_mobile.c 由云端 2P 线活跃编辑中
  (WIP 未提交),本线停止改动;.filter 编译修复在工作树待其扫荡提交。
  测试设备(emulator-5554)已让出。
- **iOS 运行时验证剩余**:loadRom 在 CI 模拟器内静默死亡(诊断标记已
  定位到 mgbaMobileLoad 内部,crc 与 native 之间),load 阶段标记 +
  核心 stderr logger + sim 崩溃抓取已就位,下一轮 CI 或真机可定位。
  失败现场:mgbax run #32(43552355987)步骤日志;后续 run 的
  lockstep-runtime-log 产物。
