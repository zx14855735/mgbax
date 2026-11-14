package com.ss.android.socialbase.appdownloader.y.xj;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private boolean hf;
    private int w;
    private InputStream xj;

    public u() {
    }

    public final int hf() {
        return xj(4);
    }

    public final void w(int i) {
        if (i > 0) {
            long j = i;
            long skip = this.xj.skip(j);
            this.w = (int) (this.w + skip);
            if (skip != j) {
                throw new EOFException();
            }
        }
    }

    public final void xj(InputStream inputStream, boolean z) {
        this.xj = inputStream;
        this.hf = z;
        this.w = 0;
    }

    public u(InputStream inputStream, boolean z) {
        xj(inputStream, z);
    }

    public final int[] hf(int i) {
        int[] iArr = new int[i];
        xj(iArr, 0, i);
        return iArr;
    }

    public final void w() {
        w(4);
    }

    public final void xj() {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            xj(null, false);
        }
    }

    public final int xj(int i) {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.hf) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int read = this.xj.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.w++;
                    i2 |= read << i3;
                }
                return i2;
            }
            int i4 = i * 8;
            int i5 = 0;
            while (i2 != i4) {
                int read2 = this.xj.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.w++;
                i5 |= read2 << i2;
                i2 += 8;
            }
            return i5;
        }
        throw new IllegalArgumentException();
    }

    public final void xj(int[] iArr, int i, int i2) {
        while (i2 > 0) {
            iArr[i] = hf();
            i2--;
            i++;
        }
    }
}
