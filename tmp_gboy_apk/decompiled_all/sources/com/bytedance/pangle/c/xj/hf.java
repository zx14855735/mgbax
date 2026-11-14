package com.bytedance.pangle.c.xj;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private int hf;
    private InputStream xj;

    public hf(InputStream inputStream) {
        xj(inputStream);
    }

    public final int hf() {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int read = this.xj.read();
            if (read == -1) {
                throw new EOFException();
            }
            this.hf++;
            i |= read << i2;
        }
        return i;
    }

    public final void w() {
        long skip = this.xj.skip(4L);
        this.hf = (int) (this.hf + skip);
        if (skip != 4) {
            throw new EOFException();
        }
    }

    public final void xj(InputStream inputStream) {
        this.xj = inputStream;
        this.hf = 0;
    }

    public final void xj() {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            xj((InputStream) null);
        }
    }

    public void hf(int i) {
        int hf = hf();
        if (hf != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(hf)));
        }
    }

    public final int[] xj(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = hf();
            i--;
            i2++;
        }
        return iArr;
    }
}
