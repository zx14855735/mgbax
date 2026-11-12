
## 2026-11-13 晚续:三端合一公开仓 mgbax 全绿

- **仓变更**:mgbax-ios 改名 **zx14855735/mgbax**,PC(Qt)+Android+iOS 同仓;
  并入 android/、res/(PC 资源,缺它 Qt 报 mgba.rc.in not found)、三端教程;
  新增 android-build.yml(ubuntu gradle,APK artifact)与 pc-build.yml
  (windows msys2,USE_FFMPEG=OFF 对齐本地,编 mgba-qt+mgba-sdl);
  用户自删了多余分支/临时仓 mgbax-pc-android。
- **CI 逐层清错(全是主仓从未真编译过的代码)**:
  1. link_lockstep.h 桥接头 include 根 → 头只留 struct mCore 前置声明
  2. LobbyKcp close() 给 let 赋值 → var
  3. startLocalLockstep Int32→Int
  4. mgba-sdl 链接 audioStretch* 未定义 → sdl CMakeLists 补 ../qt/audio_stretch.c
     (主仓同 bug,已修,本地 mgba-sdl 链接验证过)
- **终态:run #18/#2/#4(head 33a6dd2)三工作流同轮全绿**:
  PC(mgba-qt+mgba-sdl)、Android(Gradle+NDK,APK artifact)、
  iOS(xcodebuild+模拟器启动+20s 存活+截图+未签名 IPA artifact)。
- **iOS 锁步对齐 Android 修复后行为**(用户要求两端完全一致):
  2P 也走锁步(原 3...4 拒 2P)、镜像线程去掉每帧 1/60 硬睡(自由跑 +
  native park,与 Android 修后一致)、UI 文案改「本机多核锁步(2/3/4 人)」。
  编译验证过;运行时 60fps/进对战待真机。
- 主仓新增提交:b8a4f3f31(头修复)、154d43be6(iOS 对齐)、6cd129938(LobbyKcp)、
  1628d88e8(Int)、52330ba7d(SDL);dist 二进制已刷新。
