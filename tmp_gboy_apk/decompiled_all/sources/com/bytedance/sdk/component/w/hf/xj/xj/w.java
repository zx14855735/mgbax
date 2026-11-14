package com.bytedance.sdk.component.w.hf.xj.xj;

import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.yo;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w {
    public final q hf;
    public final io xj;

    public w(io ioVar, q qVar) {
        this.xj = ioVar;
        this.hf = qVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.pl().u() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean xj(com.bytedance.sdk.component.w.hf.q r3, com.bytedance.sdk.component.w.hf.io r4) {
        /*
            int r0 = r3.w()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L59
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L59
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L59
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L59
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L59
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L59
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L59
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L59
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L59
            switch(r0) {
                case 300: goto L59;
                case 301: goto L59;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L58
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.xj(r0)
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.w.hf.u r0 = r3.pl()
            int r0 = r0.w()
            r1 = -1
            if (r0 != r1) goto L59
            com.bytedance.sdk.component.w.hf.u r0 = r3.pl()
            boolean r0 = r0.kd()
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.w.hf.u r0 = r3.pl()
            boolean r0 = r0.u()
            if (r0 != 0) goto L59
        L58:
            return r2
        L59:
            com.bytedance.sdk.component.w.hf.u r3 = r3.pl()
            boolean r3 = r3.hf()
            if (r3 != 0) goto L6f
            com.bytedance.sdk.component.w.hf.u r3 = r4.c()
            boolean r3 = r3.hf()
            if (r3 != 0) goto L6f
            r3 = 1
            return r3
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.xj.xj.w.xj(com.bytedance.sdk.component.w.hf.q, com.bytedance.sdk.component.w.hf.io):boolean");
    }

    public static class xj {
        private String c;
        private long d;
        private Date f;
        final io hf;
        private String kd;
        private String p;

        /* renamed from: pl, reason: collision with root package name */
        private int f10243pl;
        private long tf;
        private Date u;
        final q w;
        final long xj;
        private Date y;

        public xj(long j, io ioVar, q qVar) {
            this.f10243pl = -1;
            this.xj = j;
            this.hf = ioVar;
            this.w = qVar;
            if (qVar != null) {
                this.d = qVar.g();
                this.tf = qVar.am();
                yo c = qVar.c();
                int xj = c.xj();
                for (int i = 0; i < xj; i++) {
                    String xj2 = c.xj(i);
                    String hf = c.hf(i);
                    if ("Date".equalsIgnoreCase(xj2)) {
                        this.u = com.bytedance.sdk.component.w.hf.xj.w.u.xj(hf);
                        this.kd = hf;
                    } else if ("Expires".equalsIgnoreCase(xj2)) {
                        this.f = com.bytedance.sdk.component.w.hf.xj.w.u.xj(hf);
                    } else if ("Last-Modified".equalsIgnoreCase(xj2)) {
                        this.y = com.bytedance.sdk.component.w.hf.xj.w.u.xj(hf);
                        this.c = hf;
                    } else if ("ETag".equalsIgnoreCase(xj2)) {
                        this.p = hf;
                    } else if ("Age".equalsIgnoreCase(xj2)) {
                        this.f10243pl = com.bytedance.sdk.component.w.hf.xj.w.kd.hf(hf, -1);
                    }
                }
            }
        }

        private w hf() {
            String str;
            if (this.w == null) {
                return new w(this.hf, null);
            }
            if (this.hf.f() && this.w.y() == null) {
                return new w(this.hf, null);
            }
            if (!w.xj(this.w, this.hf)) {
                return new w(this.hf, null);
            }
            com.bytedance.sdk.component.w.hf.u c = this.hf.c();
            if (c.xj() || xj(this.hf)) {
                return new w(this.hf, null);
            }
            com.bytedance.sdk.component.w.hf.u pl2 = this.w.pl();
            if (pl2.tf()) {
                return new w(null, this.w);
            }
            long u = u();
            long w = w();
            if (c.w() != -1) {
                w = Math.min(w, TimeUnit.SECONDS.toMillis(c.w()));
            }
            long j = 0;
            long millis = c.f() != -1 ? TimeUnit.SECONDS.toMillis(c.f()) : 0L;
            if (!pl2.y() && c.c() != -1) {
                j = TimeUnit.SECONDS.toMillis(c.c());
            }
            if (!pl2.xj()) {
                long j2 = millis + u;
                if (j2 < j + w) {
                    q.xj d = this.w.d();
                    if (j2 >= w) {
                        d.xj("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (u > 86400000 && kd()) {
                        d.xj("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new w(null, d.xj());
                }
            }
            String str2 = this.p;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.y != null) {
                    str2 = this.c;
                } else {
                    if (this.u == null) {
                        return new w(this.hf, null);
                    }
                    str2 = this.kd;
                }
                str = "If-Modified-Since";
            }
            yo.xj hf = this.hf.w().hf();
            com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(hf, str, str2);
            return new w(this.hf.y().xj(hf.xj()).xj(), this.w);
        }

        private boolean kd() {
            return this.w.pl().w() == -1 && this.f == null;
        }

        private long u() {
            Date date = this.u;
            long max = date != null ? Math.max(0L, this.tf - date.getTime()) : 0L;
            int i = this.f10243pl;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.tf;
            return max + (j - this.d) + (this.xj - j);
        }

        private long w() {
            if (this.w.pl().w() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.w());
            }
            if (this.f != null) {
                Date date = this.u;
                long time = this.f.getTime() - (date != null ? date.getTime() : this.tf);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.y != null && this.w.xj().xj().query() == null) {
                Date date2 = this.u;
                long time2 = (date2 != null ? date2.getTime() : this.d) - this.y.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        public w xj() {
            w hf = hf();
            return (hf.xj == null || !this.hf.c().d()) ? hf : new w(null, null);
        }

        private static boolean xj(io ioVar) {
            return (ioVar.xj("If-Modified-Since") == null && ioVar.xj("If-None-Match") == null) ? false : true;
        }
    }
}
