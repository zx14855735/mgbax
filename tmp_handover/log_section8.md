
## 2026-11-14 移交:iOS 云端 2P 移植计划(下一会话执行)

- **Android 侧已提交的云端 2P 演化**(08534e032..HEAD,6169d9a7f 等):
  1. GBoyConsoleSet:初始存档快照缓存(static resetInitialSaveSnapshot/
     restoreInitialSaveSnapshot——云重载后写回,防四核起点分歧)+ 存档
     一次读取分发(已移植 iOS ✓)+ 云重载房间重建用 **players=4**;
  2. GBoyCloudLink:会话改 4 槽位(本机可见核 slot1、对手 slot2、
     slot3/4 恒 0 作 NPC 队位——大竞技场 4P 要求);
  3. mgba_mobile.c:从机轮距饥饿修复(已同步镜像仓,iOS 编译验证过)。
- **iOS 移植要点**(下一会话):
  1. GBoyConsoleSet.swift:静态快照缓存 + restore(云重载场景;iOS 无
     reload 流则仅缓存);
  2. 云端 2P 的会话槽位:iOS 云端流在 LobbyLink/LobbySignaling(架构与
     Android GBoyCloudLink 不同),需梳理 iOS 大厅进房→会话创建→按键
     路由,把 2 槽会话升 4 槽(对手 slot2、NPC slot3/4),可见核 slot1;
  3. GBoyConsoleSet 的 4 核起步(镜像 3 个,NPC 队位空按键);
  4. 快照/帧钟/锁步骨架已就位(本轮已验证)。
- **注意**:GBoyConsoleSet.java/mgba_mobile.c 由云端 2P 线继续持有;
  iOS 移植只动 Swift。
- tmp_handover/ 下的诊断脚本会被另一线清理,需要时重建(parse_swift.sh/
  gen_rom.py/dispatch_ios.ps1/fetch_art*.ps1/e2e_4p_battle_repro.sh)。
