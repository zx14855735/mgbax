package com.bytedance.sdk.component.w.hf;

import com.bytedance.sdk.component.w.hf.xj.xj.u;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w implements Closeable, Flushable {
    final com.bytedance.sdk.component.w.hf.xj.xj.u hf;
    final com.bytedance.sdk.component.w.hf.xj.xj.y xj;

    public static class xj extends z {
        private final com.bytedance.sdk.component.w.xj.kd hf;
        private final String u;
        private final String w;
        final u.w xj;

        @Override // com.bytedance.sdk.component.w.hf.z
        public long hf() {
            try {
                String str = this.u;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.z
        public com.bytedance.sdk.component.w.xj.kd w() {
            return this.hf;
        }

        @Override // com.bytedance.sdk.component.w.hf.z
        public pz xj() {
            String str = this.w;
            if (str != null) {
                return pz.xj(str);
            }
            return null;
        }
    }

    private void xj(u.xj xjVar) {
        if (xjVar != null) {
            try {
                xjVar.w();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.hf.close();
    }

    public void delete() {
        this.hf.delete();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.hf.flush();
    }

    public void update(q qVar, q qVar2) {
        u.xj xjVar;
        hf hfVar = new hf(qVar2);
        try {
            xjVar = ((xj) qVar.f()).xj.xj();
            if (xjVar != null) {
                try {
                    hfVar.xj(xjVar);
                    xjVar.hf();
                } catch (IOException unused) {
                    xj(xjVar);
                }
            }
        } catch (IOException unused2) {
            xjVar = null;
        }
    }

    public static final class hf {
        private final int c;
        private final yo d;
        private final String f;
        private final String kd;
        private final long p;

        /* renamed from: pl, reason: collision with root package name */
        private final long f10234pl;
        private final e tf;
        private final yo u;
        private final String w;
        private final dk y;
        private static final String xj = com.bytedance.sdk.component.w.hf.xj.c.kd.hf().w() + "-Sent-Millis";
        private static final String hf = com.bytedance.sdk.component.w.hf.xj.c.kd.hf().w() + "-Received-Millis";

        static {
            slAZebh();
        }

        public hf(q qVar) {
            this.w = qVar.xj().xj().toString();
            this.u = com.bytedance.sdk.component.w.hf.xj.w.kd.hf(qVar);
            this.kd = qVar.xj().hf();
            this.y = qVar.hf();
            this.c = qVar.w();
            this.f = qVar.kd();
            this.d = qVar.c();
            this.tf = qVar.y();
            this.p = qVar.g();
            this.f10234pl = qVar.am();
        }

        private static /* synthetic */ void slAZebh() {
            char[] charArray = "^RP\u0013Z\\PX\u0013_RD\u0013NUXQQ\u0013wST\u007fOTYZX".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '=');
            }
            String str = new String(charArray);
            char[] charArray2 = "^QTSTI".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '=');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public void xj(u.xj xjVar) {
            com.bytedance.sdk.component.w.xj.u xj2 = com.bytedance.sdk.component.w.xj.pl.xj(xjVar.xj(0));
            xj2.hf(this.w).d(10);
            xj2.hf(this.kd).d(10);
            xj2.pl(this.u.xj()).d(10);
            int xj3 = this.u.xj();
            for (int i = 0; i < xj3; i++) {
                xj2.hf(this.u.xj(i)).hf(": ").hf(this.u.hf(i)).d(10);
            }
            xj2.hf(new com.bytedance.sdk.component.w.hf.xj.w.p(this.y, this.c, this.f).toString()).d(10);
            xj2.pl(this.d.xj() + 2).d(10);
            int xj4 = this.d.xj();
            for (int i2 = 0; i2 < xj4; i2++) {
                xj2.hf(this.d.xj(i2)).hf(": ").hf(this.d.hf(i2)).d(10);
            }
            xj2.hf(xj).hf(": ").pl(this.p).d(10);
            xj2.hf(hf).hf(": ").pl(this.f10234pl).d(10);
            if (xj()) {
                xj2.d(10);
                xj2.hf(this.tf.hf().xj()).d(10);
                xj(xj2, this.tf.w());
                xj(xj2, this.tf.u());
                xj2.hf(this.tf.xj().xj()).d(10);
            }
            xj2.close();
        }

        private boolean xj() {
            return this.w.startsWith("https://");
        }

        private void xj(com.bytedance.sdk.component.w.xj.u uVar, List<Certificate> list) {
            try {
                uVar.pl(list.size()).d(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    uVar.hf(com.bytedance.sdk.component.w.xj.y.xj(list.get(i).getEncoded()).hf()).d(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
