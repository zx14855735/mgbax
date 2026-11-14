package com.bytedance.pangle.res.xj;

import ADYaiT.CtFAbx;
import java.io.EOFException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u {
    public static int hf(InputStream inputStream, byte[] bArr, int i, int i2) {
        xj(inputStream);
        xj(bArr);
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(CtFAbx.ASJ6gh(i2, "len (", ") cannot be negative"));
        }
        xj(i, i + i2, bArr.length);
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    public static <T> T xj(T t) {
        t.getClass();
        return t;
    }

    public static void xj(InputStream inputStream, byte[] bArr) {
        xj(inputStream, bArr, 0, bArr.length);
    }

    public static void xj(InputStream inputStream, byte[] bArr, int i, int i2) {
        int hf = hf(inputStream, bArr, i, i2);
        if (hf == i2) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + hf + " bytes; " + i2 + " bytes expected");
    }

    public static void xj(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(i2);
            sb.append(i3);
            throw new IndexOutOfBoundsException(sb.toString());
        }
    }
}
