# mGBAx 安卓功能 → PC(Qt)版 移植并编译

## Context
把本仓库安卓版(mGBAx)特有的功能移植到 PC(Qt 前端 `src/platform/qt`)并编译出 Windows 可执行文件。用户已选定范围:**联机全套 + WebDAV 同步 + 外部 GLSL 滤镜**。

- PC 版已有等价物,跳过:调试工具全家桶(Tools 菜单)、倒带、金手指、存档目录管理、内置 .shader。
- 共享核心(`src/gba`)的改动(64MB ROM、EWRAM 512KB、每通道音量、flash 修复)PC 编译自动生效,无需移植。
- 移植蓝本:安卓 Java(`GBoyCloudLink/GbCloud/KcpChannel/GBoyFrames/WebDavSync/Shaders.adaptExternal`)、iOS Swift(`ios/mGBA/GBoyLink.swift`、`LobbyLink*.swift`)、native 纯 C(`src/platform/mobile/link_net.c`、`remote_link.c`)。协议规格已逆向完毕(见 `.workbuddy/gboy/PROTOCOL.md` 与项目记忆)。

## 阶段 0:工具链 + 基础编译(先跑通)
1. 本机仅有 MSYS2(gcc/g++ 已装)。用 `C:\msys64\usr\bin\pacman -S --noconfirm` 装:`mingw-w64-x86_64-cmake ninja libepoxy SDL2 qt6-base qt6-tools qt6-multimedia qt6-websockets`(zlib/png/sqlite3/minizip/lzma 仓库自带捆绑兜底;FFmpeg 用 `-DUSE_FFMPEG=OFF` 绕开)。
2. 配置:`PATH=C:\msys64\mingw64\bin`,根目录 `cmake -B build-win -G Ninja -DCMAKE_BUILD_TYPE=Release -DUSE_FFMPEG=OFF`(无 Windows preset,preset 只有 Linux 的,直接显式传参)。
3. `cmake --build build-win` + `cmake --install build-win --prefix build-win/dist`(WIN32 DATADIR=".",shader/数据装到 exe 旁),启动 `mgba.exe` 验证加载 ROM 正常。

## 阶段 1:GBoy WiFi 联机(TCP 6374,My Boy/GBoy 兼容)
协议(已逆向):明文 TCP 6374,帧 `[4B 大端长度][type u16 BE + payload]`;1=HELLO、2=ROM_INFO(32B MD5 hex+文件名)、3=CONSOLE_READY、4=KEYS(u32 掩码,与 mGBA 位定义一致 A=1..L=0x200)、5=RESET;握手后每 ~83ms(5 帧)互发 KEYS;采用安卓现行的**纯按键合并模式**(不做 SAVESTATE/串口隧道)。
- 新增 `src/platform/qt/GBoyLink.{h,cpp}`:host=`QTcpServer`,join=`QTcpSocket`,QTimer 发 KEYS,远程掩码经队列信号上报。
- `CoreController.{h,cpp}`:`updateKeys()`(CoreController.cpp:1223)处 OR 进 `m_remoteKeys`(std::atomic,int 键位掩码);新增 `setRemoteKeys()` 槽与 `localKeys()` 读取。
- 新增 `LinkView.{h,cpp,ui}` 对话框(创建/加入、端口 6374、远端游戏名、状态),参照 `DolphinConnector` 的接入方式;`Window.cpp` File 菜单(约 :1474)加入口。
- 验证:两个 mgba.exe 本机互连 + Python 对端脚本(复用 `tools/gboy_test.py` 思路)双向 KEYS 回归。

## 阶段 2:gboy.top 云端大厅 + 镜像联机
- 新增移植(全部 C++/Qt Network,工作线程 QThread):
  - `GbCloud.{h,cpp}`:QNetworkAccessManager POST `api/api.php`;邮箱验证码自动注册→回落登录(逻辑照抄 `GbCloud.java`,服务器文案匹配规则照记忆);账号存 QSettings。
  - `LobbySignaling.{h,cpp}`:QWebSocket 连 `wss://gboy.top:23459`,房间协议 create_game_room/join_room/ready/send_message/player_joined(TLS 不校验证书,与安卓 TRUST_ANY 对齐)。
  - `KcpChannel.{h,cpp}`:忠实移植 `KcpChannel.java`(大端头、MTU512、30ms tick、窗口 128 + HS/HK/PING/DISC 握手),QUdpSocket+QTimer。
  - `GBoyFrames.{h,cpp}`:`u32 BE len + u16 BE type`,类型 0-8(KEYS/REGISTER/READY/RESET/STATE/COUNTER)。
  - `CloudLink.{h,cpp}` 主类:建房/加入/中继解析(保留 NODE:/NODE2: 手动指定)/KEYS 镜像(onRemoteKeys→setRemoteKeys,即镜像联机)。
- 新增 `LobbyView.{h,cpp,ui}`:登录(邮箱→验证码/直接密码)、建房(显示房号)、加入(房号)、状态。
- 已知坑规避:房主创建后 ~10s 内加入(服务端节点问题会关 WS 解散房间)、加入者拿不到 node_port(手动 NODE2: 兜底)。
- 验证:真实 gboy.top,用 `.workbuddy/gboy/account*.json` 测试账号双开回归(建房/加入/双向按键)。

## 阶段 3:WebDAV 存档同步
- 新增 `WebDavSync.{h,cpp}`:QNetworkAccessManager PROPFIND(Depth 1,QXmlStreamReader 取 getlastmodified)/PUT/GET + Basic Auth;设置存 QSettings;冲突按 mtime 新者胜;同步 savegamePath 下 `.sav/.saN`(与安卓 `WebDavSync.java` 行为一致)。
- Tools 菜单加 "WebDAV 存档同步..." 对话框(服务器/用户/密码/远程目录/立即同步/状态)。
- 验证:本地 python WebDAV mock 往返 + mtime 冲突方向性。

## 阶段 4:RetroArch .glsl 外部滤镜加载
- 新增 `ExternalShader.{h,cpp}`:读 .glsl → 移植 `Shaders.java adaptExternal`(:417)规则(丢 #version/attribute/vTexCoord varying;自带 uniform 重名丢弃;sampler 别名→`tex`;TextureSize/InputSize→`texSize`;OutputSize→按 mGLES2Shader 实际提供的 uniform 集合映射,实现时核对;COMPAT_TEXTURE/texture→texture2D)→ 在 QTemporaryDir 生成 mGBA 格式 `manifest.ini`(单 pass,width/height=-2)+ `.fs` → `VFileDevice::openDir` → 现有 `Display::setShaders` 管线。
- `ShaderSelector` 加 "加载外部 .glsl..." 入口(Window Tools 菜单可达)。
- 验证:把安卓 `Shaders.java` 的一个内置滤镜导出为 .glsl 装入,视觉核对。

## 阶段 5(风险项,最后做,失败不阻塞交付):LAN SIO 联机线(精确周期)
- CMake 把 `src/platform/mobile/link_net.c`、`remote_link.c` 编入 Qt 目标(纯 C,已带 `#ifdef _WIN32` winsock 路径,WIN32 链 ws2_32)。
- 新增 `src/platform/qt/link_driver.{h,c}`:复刻 `mgba_mobile.c` 的 GbaLinkDriver(约 2300-2640 行)vtable,含三修复(①仅未挂 SIO 驱动时才 barrier;②`GBASIOMultiplayerSetId/SetSlave/FillReady/ClearError` 修 SIOCNT 主从位;③reset 后校验重挂驱动);挂载用 `attachDolphin` 模式(CoreController.cpp:425:`setPeripheral(mPERIPH_GBA_LINK_PORT, &d)`);每帧 pump 用 `addFrameAction`(finishFrame 每帧回调)。
- UI:LinkView 加 "LAN 联机线(精确 SIO)" host/join(端口 18765,可选中继 8766+房号,复用 remote_link.c)。
- 验证:双 exe 跑宝可梦对战房间握手(参照 [[mgba-link-cable-native]] 的双台流程)。

## 约定
- 每阶段完成单独 commit(中文短消息,仓库惯例),不 push。
- 全程不改安卓/iOS 侧代码、不动 SAVESTATE_VERSION、不清理 TEMP PROBE 探针。
- 明确不做:皮肤/虚拟按键/GIF 浮球/贴纸/AI 翻译/前台通知(触屏或 Android 专属)、串口隧道 6375。

## 最终验证
build-win 下 mgba.exe 正常游玩;联机三类(WiFi 6374 / 云端大厅 / LAN SIO)+ WebDAV + 外部 .glsl 按上述各自 E2E 通过;交付时报告每项结果。