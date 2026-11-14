package com.bytedance.sdk.component.w.hf;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ht extends x {
    private final com.bytedance.sdk.component.w.xj.y d;
    private long g = -1;
    private final pz p;

    /* renamed from: pl, reason: collision with root package name */
    private final List<hf> f10225pl;
    private final pz tf;
    public static final pz xj = pz.xj("multipart/mixed");
    public static final pz hf = pz.xj("multipart/alternative");
    public static final pz w = pz.xj("multipart/digest");
    public static final pz u = pz.xj("multipart/parallel");
    public static final pz kd = pz.xj("multipart/form-data");
    private static final byte[] y = {58, 32};
    private static final byte[] c = {13, 10};
    private static final byte[] f = {45, 45};

    public static final class xj {
        private pz hf;
        private final List<hf> w;
        private final com.bytedance.sdk.component.w.xj.y xj;

        public xj() {
            this(UUID.randomUUID().toString());
        }

        public xj xj(pz pzVar) {
            if (pzVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!pzVar.xj().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(pzVar)));
            }
            this.hf = pzVar;
            return this;
        }

        public xj(String str) {
            this.hf = ht.xj;
            this.w = new ArrayList();
            this.xj = com.bytedance.sdk.component.w.xj.y.xj(str);
        }

        public xj xj(String str, String str2, x xVar) {
            return xj(hf.xj(str, str2, xVar));
        }

        public xj xj(hf hfVar) {
            if (hfVar != null) {
                this.w.add(hfVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public ht xj() {
            if (!this.w.isEmpty()) {
                return new ht(this.xj, this.hf, this.w);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    public ht(com.bytedance.sdk.component.w.xj.y yVar, pz pzVar, List<hf> list) {
        this.d = yVar;
        this.tf = pzVar;
        this.p = pz.xj(pzVar + "; boundary=" + yVar.xj());
        this.f10225pl = com.bytedance.sdk.component.w.hf.xj.w.xj(list);
    }

    @Override // com.bytedance.sdk.component.w.hf.x
    public long hf() {
        long j = this.g;
        if (j != -1) {
            return j;
        }
        long xj2 = xj((com.bytedance.sdk.component.w.xj.u) null, true);
        this.g = xj2;
        return xj2;
    }

    @Override // com.bytedance.sdk.component.w.hf.x
    public pz xj() {
        return this.p;
    }

    @Override // com.bytedance.sdk.component.w.hf.x
    public void xj(com.bytedance.sdk.component.w.xj.u uVar) {
        xj(uVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long xj(com.bytedance.sdk.component.w.xj.u uVar, boolean z) {
        com.bytedance.sdk.component.w.xj.w wVar;
        if (z) {
            uVar = new com.bytedance.sdk.component.w.xj.w();
            wVar = uVar;
        } else {
            wVar = 0;
        }
        int size = this.f10225pl.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            hf hfVar = this.f10225pl.get(i);
            yo yoVar = hfVar.xj;
            x xVar = hfVar.hf;
            uVar.w(f);
            uVar.hf(this.d);
            uVar.w(c);
            if (yoVar != null) {
                int xj2 = yoVar.xj();
                for (int i2 = 0; i2 < xj2; i2++) {
                    uVar.hf(yoVar.xj(i2)).w(y).hf(yoVar.hf(i2)).w(c);
                }
            }
            pz xj3 = xVar.xj();
            if (xj3 != null) {
                uVar.hf("Content-Type: ").hf(xj3.toString()).w(c);
            }
            long hf2 = xVar.hf();
            if (hf2 != -1) {
                uVar.hf("Content-Length: ").pl(hf2).w(c);
            } else if (z) {
                wVar.yo();
                return -1L;
            }
            byte[] bArr = c;
            uVar.w(bArr);
            if (z) {
                j += hf2;
            } else {
                xVar.xj(uVar);
            }
            uVar.w(bArr);
        }
        byte[] bArr2 = f;
        uVar.w(bArr2);
        uVar.hf(this.d);
        uVar.w(bArr2);
        uVar.w(c);
        if (!z) {
            return j;
        }
        long hf3 = wVar.hf() + j;
        wVar.yo();
        return hf3;
    }

    public static final class hf {
        final x hf;
        final yo xj;

        private hf(yo yoVar, x xVar) {
            this.xj = yoVar;
            this.hf = xVar;
        }

        public static hf xj(yo yoVar, x xVar) {
            if (xVar == null) {
                throw new NullPointerException("body == null");
            }
            if (yoVar != null && yoVar.xj("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (yoVar == null || yoVar.xj(com.sigmob.sdk.downloader.core.c.e) == null) {
                return new hf(yoVar, xVar);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static hf xj(String str, String str2, x xVar) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                ht.xj(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    ht.xj(sb, str2);
                }
                return xj(yo.xj(com.sigmob.sdk.downloader.core.c.j, sb.toString()), xVar);
            }
            throw new NullPointerException("name == null");
        }
    }

    public static StringBuilder xj(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }
}
