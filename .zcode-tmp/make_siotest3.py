"""Lightweight version of siotest2: same 0x600F (no busy) Multi pattern, but
with no VRAM drawing and only a short completion wait, so the emulator runs many
more link iterations per real second. Exchange correctness is verified via the
driver's "SIO multi me=.. ok=.. m0=.. m1=.." log, not the screen.
"""
import struct

from keystone import Ks, KS_ARCH_ARM, KS_MODE_ARM

SRC = r"""
    .syntax unified
    .arm
start:
    mov r10, #0x04000000
    add r12, r10, #0x120

    @ RCNT -> 0, then SIOCNT = multi, baud 0 (NO busy, NO start)
    mov r1, #0
    strh r1, [r12, #0x14]
    ldr r1, =0x2000
    strh r1, [r12, #8]

    mov r8, #0
loop:
    add r8, r8, #1

    @ send = ((id + 1) << 12) | (counter & 0x0FFF)
    ldr r1, =0x0FFF
    and r1, r8, r1
    ldrh r2, [r12, #8]
    and r2, r2, #0x30
    add r2, r2, #0x10
    mov r2, r2, lsl #8
    orr r1, r1, r2
    strh r1, [r12, #0xA]

    @ Pokemon pattern: SIOCNT = 0x600F (MULTI | IRQ, busy NOT set)
    ldr r1, =0x600F
    strh r1, [r12, #8]

    @ short wait for the exchange to complete (busy never set by the game)
    ldr r0, =0x8000
waitx:
    subs r0, r0, #1
    bne waitx

    @ read SIOMULTI0..3 so the completed values are actually consumed
    ldrh r4, [r12]
    ldrh r5, [r12, #2]
    ldrh r6, [r12, #4]
    ldrh r7, [r12, #6]

    b loop
"""


def main():
    ks = Ks(KS_ARCH_ARM, KS_MODE_ARM)
    encoding, count = ks.asm(SRC)
    code = bytes(encoding)
    assert len(code) <= 0xC0 + 0x4000

    header = bytearray(0xC0)
    struct.pack_into("<I", header, 0, 0xEA00002E)
    try:
        with open("quetzal.gba", "rb") as f:
            rom = f.read(0xA0)
        header[4:0xA0] = rom[4:0xA0]
    except FileNotFoundError:
        pass
    header[0xA0:0xAC] = b"SIOTEST3    "
    header[0xAC:0xB0] = b"ST3 "
    header[0xB0:0xB2] = b"01"
    header[0xB2] = 0x96
    total = sum(header[0xA0:0xBD]) & 0xFF
    checksum = (-(total + 0x19)) & 0xFF
    header[0xBD] = checksum ^ 0xFF
    header[0xBE] = checksum

    out = bytearray(header)
    out += code
    out += b"\x00" * (0x10000 - len(out))
    with open("siotest3.gba", "wb") as f:
        f.write(out)
    print("code bytes", len(code), "instructions", count, "rom", len(out))


if __name__ == "__main__":
    main()
