package com.ss.android.socialbase.appdownloader.xj;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d extends xj {
    private String kd;
    private String u;

    public d(Context context, com.ss.android.socialbase.downloader.f.xj xjVar, String str, String str2, String str3) {
        super(context, xjVar, str);
        this.u = str2;
        this.kd = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    @Override // com.ss.android.socialbase.appdownloader.xj.kd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.Intent hf() {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            com.ss.android.socialbase.downloader.f.xj r2 = r12.hf
            java.lang.String r3 = "s"
            java.lang.String r2 = r2.w(r3)
            com.ss.android.socialbase.downloader.f.xj r3 = r12.hf
            java.lang.String r4 = "ak"
            java.lang.String r3 = r3.w(r4)
            java.lang.String r3 = com.ss.android.socialbase.appdownloader.y.w.xj(r3, r2)
            com.ss.android.socialbase.downloader.f.xj r4 = r12.hf
            java.lang.String r5 = "am"
            java.lang.String r4 = r4.w(r5)
            java.lang.String r4 = com.ss.android.socialbase.appdownloader.y.w.xj(r4, r2)
            com.ss.android.socialbase.downloader.f.xj r5 = r12.hf
            java.lang.String r6 = "an"
            java.lang.String r5 = r5.w(r6)
            java.lang.String r5 = com.ss.android.socialbase.appdownloader.y.w.xj(r5, r2)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            r7 = 0
            if (r6 != 0) goto Ld3
            java.lang.String r6 = ","
            java.lang.String[] r8 = r5.split(r6)
            int r8 = r8.length
            r9 = 2
            if (r8 == r9) goto L41
            goto Ld3
        L41:
            java.lang.String[] r5 = r5.split(r6)
            com.ss.android.socialbase.downloader.f.xj r8 = r12.hf
            java.lang.String r10 = "al"
            java.lang.String r8 = r8.w(r10)
            java.lang.String r8 = com.ss.android.socialbase.appdownloader.y.w.xj(r8, r2)
            com.ss.android.socialbase.downloader.f.xj r10 = r12.hf
            java.lang.String r11 = "ao"
            java.lang.String r10 = r10.w(r11)
            java.lang.String r2 = com.ss.android.socialbase.appdownloader.y.w.xj(r10, r2)
            boolean r10 = android.text.TextUtils.isEmpty(r2)
            if (r10 != 0) goto Ld3
            java.lang.String[] r10 = r2.split(r6)
            int r10 = r10.length
            if (r10 == r9) goto L6b
            goto Ld3
        L6b:
            java.lang.String[] r2 = r2.split(r6)
            com.ss.android.socialbase.downloader.f.xj r6 = r12.hf
            java.lang.String r9 = "download_dir"
            org.json.JSONObject r6 = r6.u(r9)
            if (r6 == 0) goto Lad
            java.lang.String r7 = "dir_name"
            java.lang.String r6 = r6.optString(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L99
            java.lang.String r7 = "%s"
            boolean r7 = r6.contains(r7)
            if (r7 == 0) goto L99
            java.lang.String r7 = r12.kd     // Catch: java.lang.Throwable -> L99
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L99
            r9[r0] = r7     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = java.lang.String.format(r6, r9)     // Catch: java.lang.Throwable -> L99
        L97:
            r7 = r6
            goto L9c
        L99:
            java.lang.String r6 = r12.kd
            goto L97
        L9c:
            int r6 = r7.length()
            r9 = 255(0xff, float:3.57E-43)
            if (r6 <= r9) goto Lad
            int r6 = r7.length()
            int r6 = r6 - r9
            java.lang.String r7 = r8.substring(r6)
        Lad:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r3)
            r3 = r2[r0]
            r2 = r2[r1]
            r6.putExtra(r3, r2)
            java.lang.String r2 = r12.u
            r6.putExtra(r4, r2)
            r6.putExtra(r8, r7)
            r0 = r5[r0]
            r1 = r5[r1]
            int r1 = java.lang.Integer.parseInt(r1)
            r6.putExtra(r0, r1)
            r0 = 268468224(0x10008000, float:2.5342157E-29)
            r6.addFlags(r0)
            return r6
        Ld3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.xj.d.hf():android.content.Intent");
    }
}
