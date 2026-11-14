package com.bytedance.pangle.res.xj;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends y {
    public c(d dVar) {
        super(dVar);
    }

    public void hf(int i, int i2) {
        int readInt = readInt();
        if (readInt == i2 || readInt < i) {
            hf(i, -1);
        } else if (readInt != i) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Integer.valueOf(i), Integer.valueOf(readInt)));
        }
    }

    @Override // com.bytedance.pangle.res.xj.y, java.io.DataInput
    public final int skipBytes(int i) {
        int i2 = 0;
        while (i2 < i) {
            int skipBytes = super.skipBytes(i - i2);
            if (skipBytes <= 0) {
                break;
            }
            i2 += skipBytes;
        }
        return i2;
    }

    public int[] xj(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    public void xj() {
        skipBytes(4);
    }

    public void xj(int i, int i2) {
        int readInt = readInt();
        if (readInt != i && readInt != i2) {
            throw new IOException(String.format("Expected: 0x%08x or 0x%08x, got: 0x%08x", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(readInt)));
        }
    }

    public void xj(short s) {
        short readShort = readShort();
        if (readShort != s) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Short.valueOf(s), Short.valueOf(readShort)));
        }
    }

    public void xj(byte b) {
        byte readByte = readByte();
        if (readByte != b) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Byte.valueOf(b), Byte.valueOf(readByte)));
        }
    }
}
