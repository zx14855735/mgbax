package com.bytedance.sdk.component.w.hf.xj.kd;

import com.bytedance.sdk.component.w.hf.dk;
import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.ra;
import com.bytedance.sdk.component.w.hf.yo;
import com.bytedance.sdk.component.w.hf.z;
import com.bytedance.sdk.component.w.xj.v;
import com.bytedance.sdk.component.w.xj.yo;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class y implements com.bytedance.sdk.component.w.hf.xj.w.w {
    private static final com.bytedance.sdk.component.w.xj.y c;
    private static final com.bytedance.sdk.component.w.xj.y d;
    private static final com.bytedance.sdk.component.w.xj.y f;
    private static final com.bytedance.sdk.component.w.xj.y hf;
    private static final com.bytedance.sdk.component.w.xj.y kd;
    private static final List<com.bytedance.sdk.component.w.xj.y> p;
    private static final List<com.bytedance.sdk.component.w.xj.y> tf;
    private static final com.bytedance.sdk.component.w.xj.y u;
    private static final com.bytedance.sdk.component.w.xj.y w;
    private static final com.bytedance.sdk.component.w.xj.y y;
    private final c am;
    private final jk.xj g;

    /* renamed from: pl, reason: collision with root package name */
    private final ra f10239pl;
    private d qt;
    final com.bytedance.sdk.component.w.hf.xj.hf.c xj;

    static {
        com.bytedance.sdk.component.w.xj.y xj2 = com.bytedance.sdk.component.w.xj.y.xj("connection");
        hf = xj2;
        com.bytedance.sdk.component.w.xj.y xj3 = com.bytedance.sdk.component.w.xj.y.xj("host");
        w = xj3;
        com.bytedance.sdk.component.w.xj.y xj4 = com.bytedance.sdk.component.w.xj.y.xj("keep-alive");
        u = xj4;
        com.bytedance.sdk.component.w.xj.y xj5 = com.bytedance.sdk.component.w.xj.y.xj("proxy-connection");
        kd = xj5;
        com.bytedance.sdk.component.w.xj.y xj6 = com.bytedance.sdk.component.w.xj.y.xj("transfer-encoding");
        y = xj6;
        com.bytedance.sdk.component.w.xj.y xj7 = com.bytedance.sdk.component.w.xj.y.xj("te");
        c = xj7;
        com.bytedance.sdk.component.w.xj.y xj8 = com.bytedance.sdk.component.w.xj.y.xj("encoding");
        f = xj8;
        com.bytedance.sdk.component.w.xj.y xj9 = com.bytedance.sdk.component.w.xj.y.xj("upgrade");
        d = xj9;
        tf = com.bytedance.sdk.component.w.hf.xj.w.xj(xj2, xj3, xj4, xj5, xj7, xj6, xj8, xj9, w.w, w.u, w.kd, w.y);
        p = com.bytedance.sdk.component.w.hf.xj.w.xj(xj2, xj3, xj4, xj5, xj7, xj6, xj8, xj9);
        IDkc();
    }

    public y(ra raVar, jk.xj xjVar, com.bytedance.sdk.component.w.hf.xj.hf.c cVar, c cVar2) {
        this.f10239pl = raVar;
        this.g = xjVar;
        this.xj = cVar;
        this.am = cVar2;
    }

    private static /* synthetic */ void IDkc() {
        char[] charArray = "\u001d\u0011\u0013P\u0019\u001f\u0013\u001bP\u001c\u0011\u0007P\r\u0016\u001b\u0012\u0012P4\u0010\u0017<\f\u0017\u001a\u0019\u001b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '~');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001d\u0012\u0017\u0010\u0017\n".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '~');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public void hf() {
        this.qt.f().close();
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public void w() {
        d dVar = this.qt;
        if (dVar != null) {
            dVar.hf(hf.CANCEL);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public yo xj(io ioVar, long j) {
        return this.qt.f();
    }

    public static List<w> hf(io ioVar) {
        com.bytedance.sdk.component.w.hf.yo w2 = ioVar.w();
        ArrayList arrayList = new ArrayList(w2.xj() + 4);
        arrayList.add(new w(w.w, ioVar.hf()));
        arrayList.add(new w(w.u, com.bytedance.sdk.component.w.hf.xj.w.d.xj(ioVar.xj())));
        String xj2 = ioVar.xj("Host");
        if (xj2 != null) {
            arrayList.add(new w(w.y, xj2));
        }
        arrayList.add(new w(w.kd, ioVar.xj().w()));
        int xj3 = w2.xj();
        for (int i = 0; i < xj3; i++) {
            com.bytedance.sdk.component.w.xj.y xj4 = com.bytedance.sdk.component.w.xj.y.xj(w2.xj(i).toLowerCase(Locale.US));
            if (!tf.contains(xj4)) {
                arrayList.add(new w(xj4, w2.hf(i)));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public void xj(io ioVar) {
        if (this.qt != null) {
            return;
        }
        d xj2 = this.am.xj(hf(ioVar), ioVar.u() != null);
        this.qt = xj2;
        com.bytedance.sdk.component.w.xj.jk kd2 = xj2.kd();
        long w2 = this.g.w();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        kd2.xj(w2, timeUnit);
        this.qt.y().xj(this.g.u(), timeUnit);
    }

    public class xj extends com.bytedance.sdk.component.w.xj.f {
        long hf;
        boolean xj;

        public xj(v vVar) {
            super(vVar);
            this.xj = false;
            this.hf = 0L;
        }

        @Override // com.bytedance.sdk.component.w.xj.f, com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            xj(null);
        }

        @Override // com.bytedance.sdk.component.w.xj.f, com.bytedance.sdk.component.w.xj.v
        public long xj(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            try {
                long xj = hf().xj(wVar, j);
                if (xj <= 0) {
                    return xj;
                }
                this.hf += xj;
                return xj;
            } catch (IOException e) {
                xj(e);
                throw e;
            }
        }

        private void xj(IOException iOException) {
            if (this.xj) {
                return;
            }
            this.xj = true;
            y yVar = y.this;
            yVar.xj.xj(false, (com.bytedance.sdk.component.w.hf.xj.w.w) yVar, this.hf, iOException);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public void xj() {
        this.am.hf();
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public q.xj xj(boolean z) {
        q.xj xj2 = xj(this.qt.u());
        if (z && com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(xj2) == 100) {
            return null;
        }
        return xj2;
    }

    public static q.xj xj(List<w> list) {
        yo.xj xjVar = new yo.xj();
        int size = list.size();
        com.bytedance.sdk.component.w.hf.xj.w.p pVar = null;
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar == null) {
                if (pVar != null && pVar.hf == 100) {
                    xjVar = new yo.xj();
                    pVar = null;
                }
            } else {
                com.bytedance.sdk.component.w.xj.y yVar = wVar.c;
                String xj2 = wVar.f.xj();
                if (yVar.equals(w.hf)) {
                    pVar = com.bytedance.sdk.component.w.hf.xj.w.p.xj("HTTP/1.1 ".concat(String.valueOf(xj2)));
                } else if (!p.contains(yVar)) {
                    com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(xjVar, yVar.xj(), xj2);
                }
            }
        }
        if (pVar != null) {
            return new q.xj().xj(dk.HTTP_2).xj(pVar.hf).xj(pVar.w).xj(xjVar.xj());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public z xj(q qVar) {
        return new com.bytedance.sdk.component.w.hf.xj.w.f(qVar.xj("Content-Type"), com.bytedance.sdk.component.w.hf.xj.w.kd.xj(qVar), com.bytedance.sdk.component.w.xj.pl.xj(new xj(this.qt.c())));
    }
}
