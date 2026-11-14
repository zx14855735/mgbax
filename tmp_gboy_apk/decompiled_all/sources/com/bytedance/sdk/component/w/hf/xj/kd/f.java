package com.bytedance.sdk.component.w.hf.xj.kd;

import com.bytedance.sdk.component.w.hf.xj.kd.u;
import com.bytedance.sdk.component.w.xj.jk;
import com.bytedance.sdk.component.w.xj.v;
import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class f implements Closeable {
    static final Logger xj = Logger.getLogger(kd.class.getName());
    final u.xj hf;
    private final boolean kd;
    private final xj u;
    private final com.bytedance.sdk.component.w.xj.kd w;

    public interface hf {
        void xj(int i, int i2, List<w> list);

        void xj(int i, long j);

        void xj(int i, com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar);

        void xj(int i, com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar, com.bytedance.sdk.component.w.xj.y yVar);

        void xj(boolean z, int i, int i2);

        void xj(boolean z, int i, int i2, List<w> list);

        void xj(boolean z, int i, com.bytedance.sdk.component.w.xj.kd kdVar, int i2);

        void xj(boolean z, am amVar);
    }

    static {
        kfvFPCH();
    }

    public f(com.bytedance.sdk.component.w.xj.kd kdVar, boolean z) {
        this.w = kdVar;
        this.kd = z;
        xj xjVar = new xj(kdVar);
        this.u = xjVar;
        this.hf = new u.xj(f.a.c, xjVar);
    }

    private void c(hf hfVar, int i, byte b, int i2) {
        if (i != 8) {
            throw kd.hf("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw kd.hf("TYPE_PING streamId != 0", new Object[0]);
        }
        hfVar.xj((b & 1) != 0, this.w.tf(), this.w.tf());
    }

    private void d(hf hfVar, int i, byte b, int i2) {
        if (i != 4) {
            throw kd.hf("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long tf = this.w.tf() & 2147483647L;
        if (tf == 0) {
            throw kd.hf("windowSizeIncrement was 0", Long.valueOf(tf));
        }
        hfVar.xj(i2, tf);
    }

    private void f(hf hfVar, int i, byte b, int i2) {
        if (i < 8) {
            throw kd.hf("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw kd.hf("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int tf = this.w.tf();
        int tf2 = this.w.tf();
        int i3 = i - 8;
        com.bytedance.sdk.component.w.hf.xj.kd.hf xj2 = com.bytedance.sdk.component.w.hf.xj.kd.hf.xj(tf2);
        if (xj2 == null) {
            throw kd.hf("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(tf2));
        }
        com.bytedance.sdk.component.w.xj.y yVar = com.bytedance.sdk.component.w.xj.y.hf;
        if (i3 > 0) {
            yVar = this.w.w(i3);
        }
        hfVar.xj(tf, xj2, yVar);
    }

    private void hf(hf hfVar, int i, byte b, int i2) {
        if (i2 == 0) {
            throw kd.hf("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw kd.hf("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short f = (b & 8) != 0 ? (short) (this.w.f() & 255) : (short) 0;
        hfVar.xj(z, i2, this.w, xj(i, b, f));
        this.w.f(f);
    }

    private void kd(hf hfVar, int i, byte b, int i2) {
        if (i2 != 0) {
            throw kd.hf("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw kd.hf("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw kd.hf("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        am amVar = new am();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short d = this.w.d();
            int tf = this.w.tf();
            if (d != 2) {
                if (d == 3) {
                    d = 4;
                } else if (d == 4) {
                    if (tf < 0) {
                        throw kd.hf("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    d = 7;
                } else if (d == 5 && (tf < 16384 || tf > 16777215)) {
                    throw kd.hf("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(tf));
                }
            } else if (tf != 0 && tf != 1) {
                throw kd.hf("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
            amVar.xj(d, tf);
        }
        hfVar.xj(false, amVar);
    }

    private static /* synthetic */ void kfvFPCH() {
        char[] charArray = "\u007fsq2{}qy2~se2otypp2Vru^nux{y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 28);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u007fpuruh".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 28);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void u(hf hfVar, int i, byte b, int i2) {
        if (i != 4) {
            throw kd.hf("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw kd.hf("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int tf = this.w.tf();
        com.bytedance.sdk.component.w.hf.xj.kd.hf xj2 = com.bytedance.sdk.component.w.hf.xj.kd.hf.xj(tf);
        if (xj2 == null) {
            throw kd.hf("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(tf));
        }
        hfVar.xj(i2, xj2);
    }

    private void w(hf hfVar, int i, byte b, int i2) {
        if (i != 5) {
            throw kd.hf("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw kd.hf("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        xj(hfVar, i2);
    }

    private void y(hf hfVar, int i, byte b, int i2) {
        if (i2 == 0) {
            throw kd.hf("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short f = (b & 8) != 0 ? (short) (this.w.f() & 255) : (short) 0;
        hfVar.xj(i2, this.w.tf() & Integer.MAX_VALUE, xj(xj(i - 4, b, f), f, b, i2));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.w.close();
    }

    public void xj(hf hfVar) {
        if (this.kd) {
            if (!xj(true, hfVar)) {
                throw kd.hf("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.component.w.xj.kd kdVar = this.w;
        com.bytedance.sdk.component.w.xj.y yVar = kd.xj;
        com.bytedance.sdk.component.w.xj.y w = kdVar.w(yVar.c());
        Logger logger = xj;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.bytedance.sdk.component.w.hf.xj.w.xj("<< CONNECTION %s", w.kd()));
        }
        if (!yVar.equals(w)) {
            throw kd.hf("Expected a connection header but was %s", w.xj());
        }
    }

    public static final class xj implements v {
        byte hf;
        short kd;
        int u;
        int w;
        int xj;
        private final com.bytedance.sdk.component.w.xj.kd y;

        public xj(com.bytedance.sdk.component.w.xj.kd kdVar) {
            this.y = kdVar;
        }

        private void hf() {
            int i = this.w;
            int xj = f.xj(this.y);
            this.u = xj;
            this.xj = xj;
            byte f = (byte) (this.y.f() & 255);
            this.hf = (byte) (this.y.f() & 255);
            Logger logger = f.xj;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(kd.xj(true, this.w, this.xj, f, this.hf));
            }
            int tf = this.y.tf() & Integer.MAX_VALUE;
            this.w = tf;
            if (f != 9) {
                throw kd.hf("%s != TYPE_CONTINUATION", Byte.valueOf(f));
            }
            if (tf != i) {
                throw kd.hf("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // com.bytedance.sdk.component.w.xj.v
        public long xj(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            while (true) {
                int i = this.u;
                if (i != 0) {
                    long xj = this.y.xj(wVar, Math.min(j, i));
                    if (xj == -1) {
                        return -1L;
                    }
                    this.u = (int) (this.u - xj);
                    return xj;
                }
                this.y.f(this.kd);
                this.kd = (short) 0;
                if ((this.hf & 4) != 0) {
                    return -1L;
                }
                hf();
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.v
        public jk xj() {
            return this.y.xj();
        }
    }

    public boolean xj(boolean z, hf hfVar) {
        try {
            this.w.xj(9L);
            int xj2 = xj(this.w);
            if (xj2 < 0 || xj2 > 16384) {
                throw kd.hf("FRAME_SIZE_ERROR: %s", Integer.valueOf(xj2));
            }
            byte f = (byte) (this.w.f() & 255);
            if (z && f != 4) {
                throw kd.hf("Expected a SETTINGS frame but was %s", Byte.valueOf(f));
            }
            byte f2 = (byte) (this.w.f() & 255);
            int tf = this.w.tf() & Integer.MAX_VALUE;
            Logger logger = xj;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(kd.xj(true, tf, xj2, f, f2));
            }
            switch (f) {
                case 0:
                    hf(hfVar, xj2, f2, tf);
                    return true;
                case 1:
                    xj(hfVar, xj2, f2, tf);
                    return true;
                case 2:
                    w(hfVar, xj2, f2, tf);
                    return true;
                case 3:
                    u(hfVar, xj2, f2, tf);
                    return true;
                case 4:
                    kd(hfVar, xj2, f2, tf);
                    return true;
                case 5:
                    y(hfVar, xj2, f2, tf);
                    return true;
                case 6:
                    c(hfVar, xj2, f2, tf);
                    return true;
                case 7:
                    f(hfVar, xj2, f2, tf);
                    return true;
                case 8:
                    d(hfVar, xj2, f2, tf);
                    return true;
                default:
                    this.w.f(xj2);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void xj(hf hfVar, int i, byte b, int i2) {
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            short f = (b & 8) != 0 ? (short) (this.w.f() & 255) : (short) 0;
            if ((b & 32) != 0) {
                xj(hfVar, i2);
                i -= 5;
            }
            hfVar.xj(z, i2, -1, xj(xj(i, b, f), f, b, i2));
            return;
        }
        throw kd.hf("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<w> xj(int i, short s, byte b, int i2) {
        xj xjVar = this.u;
        xjVar.u = i;
        xjVar.xj = i;
        xjVar.kd = s;
        xjVar.hf = b;
        xjVar.w = i2;
        this.hf.xj();
        return this.hf.hf();
    }

    private void xj(hf hfVar, int i) {
        this.w.tf();
        this.w.f();
    }

    public static int xj(com.bytedance.sdk.component.w.xj.kd kdVar) {
        return (kdVar.f() & 255) | ((kdVar.f() & 255) << 16) | ((kdVar.f() & 255) << 8);
    }

    public static int xj(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw kd.hf("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
