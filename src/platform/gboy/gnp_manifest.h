/* gnp_manifest.h — S2 邮槽地址清单（唯一允许出现裸 hex 的文件）
 *
 * 由 .zcode-tmp/reanchor.py 从 gen8 重编产物自动生成（父会话独占串行）：
 *   来源 = arm-none-eabi-nm rom.elf + rom.map 的具名符号实测值（符号名是稳定接口）
 *   轮次 tag = NGLATEST-01
 *   rom.gba 整文件 md5    = 5CB0BF6816C3E42D974A4A4EE63D3792
 *   rom.gba 整文件 sha256 = D0F6C41C612C941F9A60D2DCC35E1B4BCE5C6B402EFCF3058064882EA217E85B
 *   title/gameCode        = POKEMON EMER / BPEE
 *   GNP_FRAME_SIZE=532；重叠硬检 MB+532<=PEEK / 预算 557<=576 见 JSON 报告
 * 换 ROM 必须重生成；md5 不符 -> host fail-closed STALE_NET_MAILBOX。
 * 禁对下列绝对地址再套 SIO_IW()/NAV_IW()（delta 0x244，二次平移）。
 */
#ifndef GUARD_GNP_MANIFEST_H
#define GUARD_GNP_MANIFEST_H

#define GNP_MB_IW       0x03004C50u   /* gGnpMvpMailbox，本轮 nm 实测 */
#define GNP_PEEK_IW     0x03004E64u   /* gGnpMvpPeek */
#define GNP_APPLIED_IW  0x03004E7Cu   /* gGnpMvpApplied */
#define GNP_DIAG_EW     0x020298E8u   /* gNetGateDiag（EWRAM，NETGATE 诊断镜） */
#define NET_TX_PORT_ABS 0x02029928u   /* gGnpTxPort（EWRAM，条件落地） */
#define GNP_ROM_MD5_HEX  "5CB0BF6816C3E42D974A4A4EE63D3792"

/* 参考锚（解析自同一 nm/map；禁作身份锚/信任根/游戏态写目标）：
 *   gGnpTxPort         = 0x02029928
 *   gRngValue          = 0x03005020
 *   gPlayerParty       = 0x0202A7C0
 *   gEnemyParty        = 0x0202A9A0
 *   gEnemyPartyCount   = 0x0202A7BE
 *   gLinkOpen          = 0x02027BB0
 */

#endif  /* GUARD_GNP_MANIFEST_H */
