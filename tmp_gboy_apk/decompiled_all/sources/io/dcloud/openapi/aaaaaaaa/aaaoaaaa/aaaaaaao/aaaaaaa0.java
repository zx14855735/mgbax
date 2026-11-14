package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaao;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaau;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaa0 {
    public final aaaaaaca aaaaaaa0;
    public final aaaacaaa aaaaaaaa;

    public aaaaaaa0(aaaacaaa aaaacaaaVar, aaaaaaca aaaaaacaVar) {
        this.aaaaaaaa = aaaacaaaVar;
        this.aaaaaaa0 = aaaaaacaVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.aaaeaaaa().aaaaaaa0() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca r3, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa r4) {
        /*
            int r0 = r3.aaaaeaaa()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.aaaaaaa0(r0)
            if (r0 != 0) goto L5a
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao r0 = r3.aaaeaaaa()
            int r0 = r0.aaaaaaac()
            r1 = -1
            if (r0 != r1) goto L5a
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao r0 = r3.aaaeaaaa()
            boolean r0 = r0.aaaaaaao()
            if (r0 != 0) goto L5a
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao r0 = r3.aaaeaaaa()
            boolean r0 = r0.aaaaaaa0()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao r3 = r3.aaaeaaaa()
            boolean r3 = r3.aaaaaaeo()
            if (r3 != 0) goto L70
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao r3 = r4.aaaaaaa0()
            boolean r3 = r3.aaaaaaeo()
            if (r3 != 0) goto L70
            r3 = 1
            return r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaao.aaaaaaa0.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa):boolean");
    }

    public static class aaaaaaaa {
        final aaaacaaa aaaaaaa0;
        final long aaaaaaaa;
        private Date aaaaaaac;
        private String aaaaaaae;
        private Date aaaaaaan;
        final aaaaaaca aaaaaaao;
        private String aaaaaaau;
        private Date aaaaaaav;
        private long aaaaaaeo;
        private int aaaaaeaa;
        private String aaaaeaaa;
        private long aaaeaaaa;

        public aaaaaaaa(long j, aaaacaaa aaaacaaaVar, aaaaaaca aaaaaacaVar) {
            this.aaaaaeaa = -1;
            this.aaaaaaaa = j;
            this.aaaaaaa0 = aaaacaaaVar;
            this.aaaaaaao = aaaaaacaVar;
            if (aaaaaacaVar != null) {
                this.aaaaaaeo = aaaaaacaVar.aaaoaaaa();
                this.aaaeaaaa = aaaaaacaVar.aoaaaaaa();
                aaaoaaaa aaaaaaea = aaaaaacaVar.aaaaaaea();
                int aaaaaaa0 = aaaaaaea.aaaaaaa0();
                for (int i = 0; i < aaaaaaa0; i++) {
                    String aaaaaaaa = aaaaaaea.aaaaaaaa(i);
                    String aaaaaaa02 = aaaaaaea.aaaaaaa0(i);
                    if ("Date".equalsIgnoreCase(aaaaaaaa)) {
                        this.aaaaaaac = aaaaaaac.aaaaaaaa(aaaaaaa02);
                        this.aaaaaaau = aaaaaaa02;
                    } else if ("Expires".equalsIgnoreCase(aaaaaaaa)) {
                        this.aaaaaaav = aaaaaaac.aaaaaaaa(aaaaaaa02);
                    } else if ("Last-Modified".equalsIgnoreCase(aaaaaaaa)) {
                        this.aaaaaaan = aaaaaaac.aaaaaaaa(aaaaaaa02);
                        this.aaaaaaae = aaaaaaa02;
                    } else if ("ETag".equalsIgnoreCase(aaaaaaaa)) {
                        this.aaaaeaaa = aaaaaaa02;
                    } else if ("Age".equalsIgnoreCase(aaaaaaaa)) {
                        this.aaaaaeaa = aaaaaaau.aaaaaaaa(aaaaaaa02, -1);
                    }
                }
            }
        }

        private long aaaaaaa0() {
            if (this.aaaaaaao.aaaeaaaa().aaaaaaac() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.aaaaaaac());
            }
            if (this.aaaaaaav != null) {
                Date date = this.aaaaaaac;
                long time = this.aaaaaaav.getTime() - (date != null ? date.getTime() : this.aaaeaaaa);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.aaaaaaan != null && this.aaaaaaao.aaoaaaaa().aaaaaaae().aaaaeaaa() == null) {
                Date date2 = this.aaaaaaac;
                long time2 = (date2 != null ? date2.getTime() : this.aaaaaaeo) - this.aaaaaaan.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private long aaaaaaaa() {
            Date date = this.aaaaaaac;
            long max = date != null ? Math.max(0L, this.aaaeaaaa - date.getTime()) : 0L;
            int i = this.aaaaaeaa;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.aaaeaaaa;
            return max + (j - this.aaaaaaeo) + (this.aaaaaaaa - j);
        }

        private aaaaaaa0 aaaaaaac() {
            String str;
            if (this.aaaaaaao == null) {
                return new aaaaaaa0(this.aaaaaaa0, null);
            }
            if (this.aaaaaaa0.aaaaaaac() && this.aaaaaaao.aaaaaeaa() == null) {
                return new aaaaaaa0(this.aaaaaaa0, null);
            }
            if (!aaaaaaa0.aaaaaaaa(this.aaaaaaao, this.aaaaaaa0)) {
                return new aaaaaaa0(this.aaaaaaa0, null);
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao aaaaaaa0 = this.aaaaaaa0.aaaaaaa0();
            if (aaaaaaa0.aaaaaaav() || aaaaaaaa(this.aaaaaaa0)) {
                return new aaaaaaa0(this.aaaaaaa0, null);
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao aaaeaaaa = this.aaaaaaao.aaaeaaaa();
            long aaaaaaaa = aaaaaaaa();
            long aaaaaaa02 = aaaaaaa0();
            if (aaaaaaa0.aaaaaaac() != -1) {
                aaaaaaa02 = Math.min(aaaaaaa02, TimeUnit.SECONDS.toMillis(aaaaaaa0.aaaaaaac()));
            }
            long j = 0;
            long millis = aaaaaaa0.aaaaaaan() != -1 ? TimeUnit.SECONDS.toMillis(aaaaaaa0.aaaaaaan()) : 0L;
            if (!aaaeaaaa.aaaaaaae() && aaaaaaa0.aaaaaaau() != -1) {
                j = TimeUnit.SECONDS.toMillis(aaaaaaa0.aaaaaaau());
            }
            if (!aaaeaaaa.aaaaaaav()) {
                long j2 = millis + aaaaaaaa;
                if (j2 < j + aaaaaaa02) {
                    aaaaaaca.aaaaaaaa eaaaaaaa = this.aaaaaaao.eaaaaaaa();
                    if (j2 >= aaaaaaa02) {
                        eaaaaaaa.aaaaaaaa("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (aaaaaaaa > 86400000 && aaaaaaau()) {
                        eaaaaaaa.aaaaaaaa("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new aaaaaaa0(null, eaaaaaaa.aaaaaaaa());
                }
            }
            String str2 = this.aaaaeaaa;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.aaaaaaan != null) {
                    str2 = this.aaaaaaae;
                } else {
                    if (this.aaaaaaac == null) {
                        return new aaaaaaa0(this.aaaaaaa0, null);
                    }
                    str2 = this.aaaaaaau;
                }
                str = "If-Modified-Since";
            }
            aaaoaaaa.aaaaaaaa aaaaaaaa2 = this.aaaaaaa0.aaaaaaao().aaaaaaaa();
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(aaaaaaaa2, str, str2);
            return new aaaaaaa0(this.aaaaaaa0.aaaaaaan().aaaaaaaa(aaaaaaaa2.aaaaaaaa()).aaaaaaaa(), this.aaaaaaao);
        }

        private boolean aaaaaaau() {
            return this.aaaaaaao.aaaeaaaa().aaaaaaac() == -1 && this.aaaaaaav == null;
        }

        public aaaaaaa0 aaaaaaao() {
            aaaaaaa0 aaaaaaac = aaaaaaac();
            return (aaaaaaac.aaaaaaaa == null || !this.aaaaaaa0.aaaaaaa0().aaaeaaaa()) ? aaaaaaac : new aaaaaaa0(null, null);
        }

        private static boolean aaaaaaaa(aaaacaaa aaaacaaaVar) {
            return (aaaacaaaVar.aaaaaaaa("If-Modified-Since") == null && aaaacaaaVar.aaaaaaaa("If-None-Match") == null) ? false : true;
        }
    }
}
