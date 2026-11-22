/* gnp_manifest.h — S2 邮槽地址清单（唯一允许出现裸 hex 的文件）
 *
 * 由构建脚本从当轮 gen8 重编产物（D:\gen8\rom.elf / rom.map）自动生成：
 *   - 绝对路径来自 arm-none-eabi-nm 的 gGnpMvpMailbox / gGnpMvpPeek / gGnpMvpApplied 实测值
 *   - GNP_ROM_MD5_HEX = 当轮 D:\gen8\rom.gba 整文件 SHA/MD5（磁盘实测）
 * 本文件由父会话独占串行生成；源码其余位置只用这些具名宏，禁裸 hex（AGENTS §5）。
 *
 * 当轮基线（2026-11-22 03:27 gen8 重编）：
 *   rom.gba md5 = C963ED1872BAF4BD4561660EB6A8467A
 *   gGnpMvpMailbox  = 0x03004c50 (500B)
 *   gGnpMvpPeek     = 0x03004e44 (24B)
 *   gGnpMvpApplied  = 0x03004e5c (1B)
 *   gLastWrittenSector = 0x03004f68  <- 仅参考，禁作身份锚（随存档变化）
 *   end = 0x030060b0 (< sp_sys 0x03007e40)
 *   实际 IW delta = 0x244（源码默认 0xD4 已陈旧）—— 故邮槽用绝对地址直写，
 *   不经 SIO_IW()/NAV_IW()（后者会对绝对地址二次平移）。
 *
 * 换 ROM 必须重生成此文件（md5 不符 -> host fail-closed STALE_NET_MAILBOX）。
 */
#ifndef GUARD_GNP_MANIFEST_H
#define GUARD_GNP_MANIFEST_H

#define GNP_MB_IW        0x03004C50u   /* gGnpMvpMailbox 绝对地址（当轮 nm） */
#define GNP_PEEK_IW      0x03004E44u   /* gGnpMvpPeek */
#define GNP_APPLIED_IW   0x03004E5Cu   /* gGnpMvpApplied */
#define GNP_ROM_MD5_HEX  "C963ED1872BAF4BD4561660EB6A8467A"

#endif  /* GUARD_GNP_MANIFEST_H */
