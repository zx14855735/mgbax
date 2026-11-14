package com.bytedance.sdk.component.w.hf.xj.kd;

import com.bytedance.sdk.component.w.hf.xj.kd.u;
import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class tf implements Closeable {
    private static final Logger hf = Logger.getLogger(kd.class.getName());
    private boolean c;
    private final com.bytedance.sdk.component.w.xj.w kd;
    private final boolean u;
    private final com.bytedance.sdk.component.w.xj.u w;
    final u.hf xj;
    private int y;

    static {
        MQcwUvP();
    }

    public tf(com.bytedance.sdk.component.w.xj.u uVar, boolean z) {
        this.w = uVar;
        this.u = z;
        com.bytedance.sdk.component.w.xj.w wVar = new com.bytedance.sdk.component.w.xj.w();
        this.kd = wVar;
        this.xj = new u.hf(wVar);
        this.y = f.a.d;
    }

    private static /* synthetic */ void MQcwUvP() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.c = true;
        this.w.close();
    }

    public synchronized void hf() {
        if (this.c) {
            throw new IOException("closed");
        }
        this.w.flush();
    }

    public int w() {
        return this.y;
    }

    public synchronized void xj() {
        try {
            if (this.c) {
                throw new IOException("closed");
            }
            if (this.u) {
                Logger logger = hf;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(com.bytedance.sdk.component.w.hf.xj.w.xj(">> CONNECTION %s", kd.xj.kd()));
                }
                this.w.w(kd.xj.f());
                this.w.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void hf(am amVar) {
        try {
            if (!this.c) {
                int i = 0;
                xj(0, amVar.hf() * 6, (byte) 4, (byte) 0);
                while (i < 10) {
                    if (amVar.xj(i)) {
                        this.w.f(i == 4 ? 3 : i == 7 ? 4 : i);
                        this.w.c(amVar.hf(i));
                    }
                    i++;
                }
                this.w.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void xj(am amVar) {
        try {
            if (!this.c) {
                this.y = amVar.u(this.y);
                if (amVar.w() != -1) {
                    this.xj.xj(amVar.w());
                }
                xj(0, 0, (byte) 4, (byte) 1);
                this.w.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void hf(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min(this.y, j);
            long j2 = min;
            j -= j2;
            xj(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.w.a_(this.kd, j2);
        }
    }

    public synchronized void xj(int i, int i2, List<w> list) {
        if (!this.c) {
            this.xj.xj(list);
            long hf2 = this.kd.hf();
            int min = (int) Math.min(this.y - 4, hf2);
            long j = min;
            xj(i, min + 4, (byte) 5, hf2 == j ? (byte) 4 : (byte) 0);
            this.w.c(i2 & Integer.MAX_VALUE);
            this.w.a_(this.kd, j);
            if (hf2 > j) {
                hf(i, hf2 - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void xj(boolean z, int i, int i2, List<w> list) {
        if (!this.c) {
            xj(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void xj(int i, hf hfVar) {
        if (!this.c) {
            if (hfVar.c != -1) {
                xj(i, 4, (byte) 3, (byte) 0);
                this.w.c(hfVar.c);
                this.w.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void xj(boolean z, int i, com.bytedance.sdk.component.w.xj.w wVar, int i2) {
        if (!this.c) {
            xj(i, z ? (byte) 1 : (byte) 0, wVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    public void xj(int i, byte b, com.bytedance.sdk.component.w.xj.w wVar, int i2) {
        xj(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.w.a_(wVar, i2);
        }
    }

    public synchronized void xj(boolean z, int i, int i2) {
        if (!this.c) {
            xj(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.w.c(i);
            this.w.c(i2);
            this.w.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void xj(int i, hf hfVar, byte[] bArr) {
        try {
            if (!this.c) {
                if (hfVar.c != -1) {
                    xj(0, bArr.length + 8, (byte) 7, (byte) 0);
                    this.w.c(i);
                    this.w.c(hfVar.c);
                    if (bArr.length > 0) {
                        this.w.w(bArr);
                    }
                    this.w.flush();
                } else {
                    throw kd.xj("errorCode.httpCode == -1", new Object[0]);
                }
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void xj(int i, long j) {
        if (this.c) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            xj(i, 4, (byte) 8, (byte) 0);
            this.w.c((int) j);
            this.w.flush();
        } else {
            throw kd.xj("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
    }

    public void xj(int i, int i2, byte b, byte b2) {
        Logger logger = hf;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(kd.xj(false, i, i2, b, b2));
        }
        int i3 = this.y;
        if (i2 > i3) {
            throw kd.xj("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw kd.xj("reserved bit set: %s", Integer.valueOf(i));
        }
        xj(this.w, i2);
        this.w.d(b & 255);
        this.w.d(b2 & 255);
        this.w.c(i & Integer.MAX_VALUE);
    }

    private static void xj(com.bytedance.sdk.component.w.xj.u uVar, int i) {
        uVar.d((i >>> 16) & 255);
        uVar.d((i >>> 8) & 255);
        uVar.d(i & 255);
    }

    public void xj(boolean z, int i, List<w> list) {
        if (!this.c) {
            this.xj.xj(list);
            long hf2 = this.kd.hf();
            int min = (int) Math.min(this.y, hf2);
            long j = min;
            byte b = hf2 == j ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            xj(i, min, (byte) 1, b);
            this.w.a_(this.kd, j);
            if (hf2 > j) {
                hf(i, hf2 - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
