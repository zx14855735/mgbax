package com.bytedance.pangle.res.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl {
    public static void xj(c cVar) {
        cVar.hf(1835009, 0);
        int readInt = cVar.readInt();
        int readInt2 = cVar.readInt();
        int readInt3 = cVar.readInt();
        cVar.xj();
        int readInt4 = cVar.readInt();
        int readInt5 = cVar.readInt();
        cVar.skipBytes(readInt2 * 4);
        if (readInt3 != 0) {
            cVar.skipBytes(readInt3 * 4);
        }
        cVar.skipBytes((readInt5 == 0 ? readInt : readInt5) - readInt4);
        if (readInt5 == 0) {
            return;
        }
        int i = readInt - readInt5;
        cVar.skipBytes(i);
        int i2 = i % 4;
        if (i2 <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            cVar.readByte();
            i2 = i3;
        }
    }
}
