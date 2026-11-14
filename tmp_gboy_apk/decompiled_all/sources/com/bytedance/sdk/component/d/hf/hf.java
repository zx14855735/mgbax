package com.bytedance.sdk.component.d.hf;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import com.sigmob.sdk.downloader.core.c;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends u {
    public File hf;
    public File xj;

    public hf(pl plVar) {
        super(plVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c(Map<String, String> map) {
        String str = map.containsKey("content-length") ? map.get("content-length") : map.containsKey(c.e) ? map.get(c.e) : null;
        if (!TextUtils.isEmpty(str) && str != null) {
            try {
                return Long.valueOf(str).longValue();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        try {
            this.xj.delete();
        } catch (Throwable unused) {
        }
        try {
            this.hf.delete();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y(Map<String, String> map) {
        if (TextUtils.equals(map.get(c.i), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get(c.f);
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    public void xj(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.xj = new File(str, str2);
        this.hf = new File(str, CtFAbx.AcNBzu(str2, ".temp"));
    }

    public void xj(final com.bytedance.sdk.component.d.xj.xj xjVar) {
        File file = this.xj;
        if (file == null || this.hf == null) {
            if (xjVar != null) {
                xjVar.xj(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.xj.length() != 0 && xjVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.d.hf hfVar = new com.bytedance.sdk.component.d.hf(true, 200, "Success", null, null, currentTimeMillis, currentTimeMillis);
            hfVar.xj(this.xj);
            xjVar.xj(this, hfVar);
            return;
        }
        long length = this.hf.length();
        final long j = length >= 0 ? length : 0L;
        am.xj xjVar2 = new am.xj();
        xjVar2.xj((Object) hf());
        hf(c.b, "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.y)) {
            xjVar.xj(this, new IOException("Url is Empty"));
            return;
        }
        try {
            xjVar2.xj(this.y);
            xj(xjVar2);
            this.w.xj(xjVar2.xj().hf()).xj(new com.bytedance.sdk.component.hf.xj.w() { // from class: com.bytedance.sdk.component.d.hf.hf.1
                @Override // com.bytedance.sdk.component.hf.xj.w
                public void onFailure(com.bytedance.sdk.component.hf.xj.hf hfVar2, IOException iOException) {
                    com.bytedance.sdk.component.d.xj.xj xjVar3 = xjVar;
                    if (xjVar3 != null) {
                        xjVar3.xj(hf.this, iOException);
                    }
                    hf.this.kd();
                }

                /* JADX WARN: Code restructure failed: missing block: B:96:0x0206, code lost:
                
                    if (0 != 0) goto L104;
                 */
                /* JADX WARN: Removed duplicated region for block: B:54:0x014f A[Catch: all -> 0x013b, TryCatch #5 {all -> 0x013b, blocks: (B:46:0x0122, B:48:0x0130, B:50:0x0134, B:51:0x013e, B:52:0x0145, B:54:0x014f, B:56:0x015b, B:60:0x0163, B:64:0x0171, B:67:0x017d, B:69:0x0187, B:71:0x0193, B:73:0x019f, B:84:0x01ae, B:85:0x01bb, B:88:0x01d5), top: B:45:0x0122 }] */
                /* JADX WARN: Removed duplicated region for block: B:62:0x016f A[EDGE_INSN: B:62:0x016f->B:63:0x016f BREAK  A[LOOP:1: B:52:0x0145->B:59:0x016c], SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:64:0x0171 A[Catch: all -> 0x013b, TryCatch #5 {all -> 0x013b, blocks: (B:46:0x0122, B:48:0x0130, B:50:0x0134, B:51:0x013e, B:52:0x0145, B:54:0x014f, B:56:0x015b, B:60:0x0163, B:64:0x0171, B:67:0x017d, B:69:0x0187, B:71:0x0193, B:73:0x019f, B:84:0x01ae, B:85:0x01bb, B:88:0x01d5), top: B:45:0x0122 }] */
                /* JADX WARN: Removed duplicated region for block: B:87:0x01d4  */
                @Override // com.bytedance.sdk.component.hf.xj.w
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onResponse(com.bytedance.sdk.component.hf.xj.hf r22, com.bytedance.sdk.component.hf.xj.zg r23) {
                    /*
                        Method dump skipped, instructions count: 538
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.hf.hf.AnonymousClass1.onResponse(com.bytedance.sdk.component.hf.xj.hf, com.bytedance.sdk.component.hf.xj.zg):void");
                }
            });
        } catch (IllegalArgumentException unused) {
            xjVar.xj(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0213 A[EDGE_INSN: B:115:0x0213->B:116:0x0213 BREAK  A[LOOP:1: B:69:0x01e1->B:81:0x020b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0215 A[Catch: all -> 0x0210, TryCatch #10 {all -> 0x0210, blocks: (B:76:0x01f3, B:78:0x01fb, B:82:0x0201, B:117:0x0215, B:124:0x0230, B:126:0x0238, B:128:0x0242, B:130:0x024c, B:140:0x0258, B:150:0x026e, B:153:0x0282, B:164:0x0226), top: B:75:0x01f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02b8 A[Catch: all -> 0x02bc, TryCatch #19 {all -> 0x02bc, blocks: (B:87:0x02b1, B:89:0x02b8, B:90:0x02be), top: B:86:0x02b1, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // com.bytedance.sdk.component.d.hf.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.d.hf xj() {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.hf.hf.xj():com.bytedance.sdk.component.d.hf");
    }
}
