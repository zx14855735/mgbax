
## 2026-11-14 收官:iOS 锁步运行时 CI 验证全通(#39)

- **三端运行时验证全部闭环**:Android(AVD 4P 进对战 BATTLE=YES)、
  PC(product-lockstep/busgame-product)、**iOS 模拟器(生成 ROM 4 核锁步
  600+ 帧,GBOY_RT 里程碑全过,head 71d339d run #39)**。
- **iOS 最终根因(崩溃栈实证)**:iOS 的 VFile 以只读 mmap 映射 ROM 文件,
  GBALoadROM 向映射内 memset 补零(gba.c:513),小于 32MB 的 ROM 在映射外
  写 → Translation fault。修:加载前小 ROM 原地补零到 32MB(loadRom 内,
  对真 32MB ROM 空操作)。PC 的 VFile 无此问题。
- **6 层修复链全记录**(崩溃报告+相位标记逐层定位):校验和 0xBD →
  设备码 0xB2=0x96 → audio.start 于 CI(-gboySilent)→ mirrorFrames
  越界(count vs players)→ 主线程 watchdog(16MB 栈专用线程)→
  小 ROM mmap 写越界(补零)。详见记忆 mgba-ios-runtime-ci。
- **并发会话的云端 2P 改动已同步进 mgbax**(android-build #6 / pc-build #8
  全绿——他们的 native 从机轮距修复在三平台编译验证过);iOS 的存档快照
  一次读取分发(与 Android 的 cloud-rearm 修复同源)也已对齐。
- 主仓/镜像仓全部同步;CI 产物(IPA/截图/锁步日志)在最新绿 run。
