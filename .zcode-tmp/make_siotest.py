"""Build a tiny GBA multi-mode SIO test ROM.

Both consoles load the same ROM. Player 0 (lobby host) is the clock master.
Every ~35 ms each console sends a 16-bit value that encodes its player number
and a counter, then displays the four SIOMULTI registers as 16-bit binary
ribbons (8x8 blocks, MSB left). The top four ribbons are SIOMULTI0..3, so the
two players' counters can be compared by eye.
"""
import struct

from keystone import Ks, KS_ARCH_ARM, KS_MODE_ARM

SRC = r"""
    .syntax unified
    .arm
start:
    mov r10, #0x04000000
    mov r11, #0x06000000

    @ DISPCNT = mode 3
    ldr r0, =0x0403
    strh r0, [r10]

    @ clear VRAM (19200 words)
    mov r0, r11
    mov r1, #0
    ldr r2, =19200
clear:
    str r1, [r0], #4
    subs r2, r2, #1
    bne clear

    @ RCNT -> 0 (leave GPIO/reset mode), then SIOCNT = multi, baud 0
    add r12, r10, #0x120
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

    @ SIOMLT_SEND is written above, now set the start bit
    ldr r1, =0x2080
    strh r1, [r12, #8]
waitbusy:
    ldrh r2, [r12, #8]
    tst r2, #0x80
    bne waitbusy

    ldrh r4, [r12]
    ldrh r5, [r12, #2]
    ldrh r6, [r12, #4]
    ldrh r7, [r12, #6]

    mov r0, r4
    mov r1, #0
    bl draw_bits
    mov r0, r5
    mov r1, #12
    bl draw_bits
    mov r0, r6
    mov r1, #24
    bl draw_bits
    mov r0, r7
    mov r1, #36
    bl draw_bits

    @ bottom ribbon: local SIOCNT (id bits) and the low counter bits
    ldrh r0, [r12, #8]
    mov r1, #52
    bl draw_bits

    ldr r0, =0x00060000
delay:
    subs r0, r0, #1
    bne delay
    b loop

@ r0 = 16-bit value, r1 = top row (pixels)
draw_bits:
    push {r4-r9, lr}
    mov r4, #480
    mul r3, r1, r4
    add r4, r11, r3
    ldr r9, =0x7FFF7FFF
    mov r1, #0
    mov r2, #15
dloop:
    mov r5, r0, lsr r2
    and r5, r5, #1
    cmp r5, #0
    moveq r5, #0
    movne r5, r9
    add r6, r4, r1, lsl #4
    mov r7, #8
drow:
    str r5, [r6], #4
    str r5, [r6], #4
    str r5, [r6], #4
    str r5, [r6], #4
    add r6, r6, #464
    subs r7, r7, #1
    bne drow
    subs r2, r2, #1
    add r1, r1, #1
    bpl dloop
    pop {r4-r9, pc}
"""


def main():
    ks = Ks(KS_ARCH_ARM, KS_MODE_ARM)
    encoding, count = ks.asm(SRC)
    code = bytes(encoding)
    assert len(code) <= 0xC0 + 0x4000

    header = bytearray(0xC0)
    # ARM branch from 0x08000000 (PC=0x08000008) to 0x080000C0
    struct.pack_into("<I", header, 0, 0xEA00002E)
    with open("quetzal.gba", "rb") as f:
        rom = f.read(0xA0)
    header[4:0xA0] = rom[4:0xA0]
    header[0xA0:0xAC] = b"SIOTEST     "
    header[0xAC:0xB0] = b"SIOT"
    header[0xB0:0xB2] = b"01"
    header[0xB2] = 0x96
    # checksum over 0xA0..0xBC
    total = sum(header[0xA0:0xBD]) & 0xFF
    checksum = (-(total + 0x19)) & 0xFF
    header[0xBD] = checksum ^ 0xFF
    header[0xBE] = checksum

    out = bytearray(header)
    out += code
    out += b"\x00" * (0x10000 - len(out))
    with open("siotest.gba", "wb") as f:
        f.write(out)
    print("code bytes", len(code), "instructions", count, "rom", len(out))


if __name__ == "__main__":
    main()
