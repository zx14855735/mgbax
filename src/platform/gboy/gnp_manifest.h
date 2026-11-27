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

/* 参考锚（解析自同一 nm/map；禁作身份锚/信任根/游戏态写目标）：
 *   gGnpTxPort=0x02029938 / gRngValue=0x0300503C / gPlayerParty=0x0202A7D0
 *   gEnemyParty=0x0202A9B0 / gEnemyPartyCount=0x0202A7CE / gLinkOpen=0x02027BC0
 */

#endif  /* GUARD_GNP_MANIFEST_H */
