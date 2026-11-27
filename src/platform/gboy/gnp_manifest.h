/* gnp_manifest.h — S2 邮槽地址清单（唯一允许出现裸 hex 的文件）
 *
 * 由 .zcode-tmp/reanchor.py 从 gen8 重编产物自动生成（父会话独占串行）：
 *   来源 = arm-none-eabi-nm rom.elf + rom.map 的具名符号实测值（符号名是稳定接口）
 *   轮次 tag = ATK-COLOSSEUM-01
 *   rom.gba 整文件 md5    = E80D66973ABE06C4F2F27D59E3CA9CF9
 *   title/gameCode        = POKEMON EMER / BPEE
 * 灰区流程便捷化产物（MGBAX_P0_COLOSSEUM_DEFAULT：服务菜单默认项进战斗场）：
 *   CROSSED 可信度存疑、非纯零注入、不进裁决；门 FAIL/0/9 不变。
 * 混合配置：APP 用新 ROM(E80D6697)+新 manifest；PC 用旧 exe(旧 manifest)+旧 ROM，避免 PC AV 崩溃。
 */
#ifndef GUARD_GNP_MANIFEST_H
#define GUARD_GNP_MANIFEST_H

#define GNP_MB_IW       0x03004C6Cu   /* gGnpMvpMailbox，本轮 nm 实测 */
#define GNP_PEEK_IW     0x03004E80u   /* gGnpMvpPeek */
#define GNP_APPLIED_IW  0x03004E98u   /* gGnpMvpApplied */
#define GNP_DIAG_EW     0x020298F8u   /* gNetGateDiag（EWRAM，NETGATE 诊断镜） */
#define NET_TX_PORT_ABS 0x02029938u   /* gGnpTxPort（EWRAM，条件落地） */
#define GNP_ROM_MD5_HEX  "67677B95F7A515688E6A90F3BDA444F2"

/* party provenance：仅锚绝对地址参考，锚同值写。C 端 producer 逐字节 GBAView8 搬运，不做预知串。 */
#define GNP_ENEMY_PARTY_EW   0x0202A9B0u   /* gEnemyParty：收到的对端 party（rx） */
#define GNP_PLAYER_PARTY_EW  0x0202A7D0u   /* gPlayerParty：本端真 party（tx） */
#define GNP_PLAYER_PARTY_COUNT_EW 0x0202A7CDu  /* gPlayerPartyCount */
#define GNP_PARTY_BLOB_BYTES 480u          /* 6 * sizeof(Pokemon) = 0x1E0 */
/* gTasks EWRAM 锚（nm 实测，取代运行时引用计数扫描在移动靶 ROM 上 cnt<100 的失败）：
 * gTasks=0x02033FD8，EW delta = 0x02033FD8 - MOBILE_EW_BASE_GTASKS(0x02033D0C) = 0x2CC */
#define GNP_GTASKS_EW        0x02033FD8u
/* 菜单光标 sMenu.cursorPos（gen8 menu.c:42 struct Menu.offset2, sMenu=0x02029780）。
 * PEEK 旧基准 0x02032B00+delta 在新 ROM 落在 gSelectedOrderFromParty(非菜单)。具名宏锚定真菜单光标。 */
#define GNP_MENU_CURSOR_EW   0x02029782u   /* sMenu.cursorPos */
#define GNP_MENU_MIN_EW      0x02029783u   /* sMenu.minCursorPos */
#define GNP_MENU_MAX_EW      0x02029784u   /* sMenu.maxCursorPos */
#define GNP_MENU_WIN_EW      0x02029785u   /* sMenu.windowId */
/* §3.6 游戏层 trading state 同步诊断（frozen ELF syms_nm.txt 具名实测，非裸 hex 散用）：
 * Task_EnterCableClubSeat case2 → sub_8087214() → AreAllPlayersInTradingState(UNK_2=0x82)。
 * sPlayerTradingStates 由对方经 SIO 逐帧交换的 link key code LINK_KEY_CODE_UNK_2(0x16) 写入，
 * sub_80871AC() 广播该 key。读这四项判定「逐帧 key code 交换是否把 UNK_2 送过链路」。 */
#define GNP_TRADING_STATES_EW 0x03004EB0u   /* sPlayerTradingStates[4] (u8) */
#define GNP_HELD_KEY_EW       0x03004ECCu   /* gHeldKeyCodeToSend (u16) */
#define GNP_LOCAL_LINK_ID_EW  0x03004ED8u   /* gLocalLinkPlayerId (u8) */
#define GNP_FIELD_LINK_CNT_EW 0x03004ED9u   /* gFieldLinkPlayerCount (u8) */
/* gSpecialVar_Result（0x020219C0，u16，syms_nm.txt 具名实测）：linkup task 结果码。
 * LINKUP_* 见 constants/cable_club.h：0=ONGOING 1=SUCCESS 4=WRONG_NUM 6=CONN_ERR
 * 7=PLAYER_NOT_READY 9=PARTNER_NOT_READY。判定数据块交换失败的具体分支。 */
#define GNP_SPECIAL_VAR_RESULT_EW 0x020219C0u
/* 块重组进度（frozen ELF syms_nm.txt 具名实测）：struct BlockTransfer{pos,size,src*,active,id}=12B，
 * sBlockRecv[4]@0x03002BF0。link.c:599 pos>=size 才算块收完 → HandleReceiveRemoteLinkPlayer →
 * gRemoteLinkPlayersNotReceived[i]=FALSE → 全部清零才置 gReceivedRemoteLinkPlayers(0x03002D21)。
 * 读 p0 的 pos/size/active 判定 party 块是否启动、卡在多少字节。 */
#define GNP_BLOCK_RECV_EW      0x03002BF0u   /* sBlockRecv[0].pos (u16) */
#define GNP_RECV_REMOTE_PL_EW  0x03002D21u   /* gReceivedRemoteLinkPlayers (u8) */
/* gLinkCallback（0x03002D34，u32 函数指针，syms_nm.txt 具名实测）：OpenLink 后应为
 * LinkCB_RequestPlayerDataExchange(0x0818F26A)。0x2222 启动字只在该回调里由主机发。
 * 读低16位判定回调链是否断；LINK_STAT_MASTER=bit5(0x20) 判定主机条件。 */
#define GNP_LINK_CALLBACK_IW   0x03002D34u
#define GNP_LINK_STAT_MASTER  0x20u
/* 灰区 GZ8（§3.5 全解禁）：握手闭合瞬间写真值回调，修"回调安装晚于握手窗口"时序错配。
 * LinkCB_RequestPlayerDataExchange 具名地址 = ROM 实链接地址 | Thumb bit(bit0)。
 * 仅具名门开时写；写的是**真实存在的游戏函数地址**，非造数据/非伪造信任位/CROSSED。
 * 产物须标"灰区 GZ8、CROSSED 可信度存疑、非纯零注入"，门 FAIL/0/9 不变。 */
#define GNP_LCB_REQ_PLAYER_DATA 0x0818F26Au   /* LinkCB_RequestPlayerDataExchange (frozen ELF) */
#define GNP_THUMB_BIT          0x1u
/* 灰区 GZ9：驱动层直接写 sendCmd[0]=LINKCMD_SEND_LINK_TYPE(0x2222) 启动块交换。
 * gSendCmd[8] 旧构建基准 0x03002AB0，运行时 NAV_IW()+delta 解析。0x2222 是游戏真实
 * 协议命令字（非造 party/信任位/CROSSED）；仿 sioStandbyInject 写 0x2FFE 的既有先例。 */
#define GNP_SENDCMD0_IW        0x03002AB0u
#define GNP_LINKCMD_SEND_TYPE  0x2222u
/* GZ10 只读实测：gLocalLinkPlayerBlock(0x03002C54,0x3C) 有线侧是否被真填充。
 * magic1[16] 应为 sASCIIGameFreakInc；gLocalLinkPlayer(0x02027BC8).trainerId(+0)。
 * 仅 PEEK 判据，不注入、不造假；决定 GZ10 搬真块是否可行。 */
#define GNP_LOCAL_LP_BLOCK_IW  0x03002C54u
#define GNP_LOCAL_LP_EW        0x02027BC8u

/* 参考锚（解析自同一 nm/map；禁作身份锚/信任根/游戏态写目标）：
 *   gGnpTxPort=0x02029938 / gRngValue=0x0300503C / gPlayerParty=0x0202A7D0
 *   gEnemyParty=0x0202A9B0 / gEnemyPartyCount=0x0202A7CE / gLinkOpen=0x02027BC0
 */

#endif  /* GUARD_GNP_MANIFEST_H */
