package com.bytedance.embedapplog;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
abstract class n {
    boolean hf;
    boolean u;
    boolean w;
    boolean xj;

    public n(boolean z, boolean z2) {
        this.hf = z;
        this.w = z2;
        this.u = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String xj(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Le
            goto Lcd
        Le:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r1.getPath()
            r0.append(r1)
            java.lang.String r1 = "/Android/data/com.snssdk.api.embed/cache"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "/"
            java.lang.String r8 = ADYaiT.CtFAbx.AlLFFp(r0, r1, r8)
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            if (r0 != 0) goto L48
            boolean r0 = r2.mkdirs()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            if (r0 != 0) goto L48
            goto Lcd
        L41:
            r8 = move-exception
            r0 = r1
            goto Lce
        L45:
            r8 = move-exception
            r0 = r1
            goto La3
        L48:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.lang.String r2 = "rwd"
            r8.<init>(r0, r2)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            java.nio.channels.FileLock r1 = r2.lock()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            boolean r0 = r0.isFile()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            java.lang.String r2 = "UTF-8"
            if (r0 == 0) goto L8e
            r0 = 129(0x81, float:1.81E-43)
            byte[] r3 = new byte[r0]     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            r4 = 0
            int r5 = r8.read(r3, r4, r0)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            if (r5 <= 0) goto L8e
            if (r5 >= r0) goto L8e
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            r0.<init>(r3, r4, r5, r2)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            boolean r3 = com.bytedance.embedapplog.aq.xj(r0)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            if (r3 == 0) goto L8e
            if (r1 == 0) goto L81
            r1.release()     // Catch: java.lang.Exception -> L81
        L81:
            r8.close()     // Catch: java.lang.Exception -> L84
        L84:
            return r0
        L85:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lce
        L89:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto La3
        L8e:
            byte[] r0 = r9.getBytes(r2)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            r2 = 0
            r8.setLength(r2)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            r8.write(r0)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L89
            if (r1 == 0) goto L9f
            r1.release()     // Catch: java.lang.Exception -> L9f
        L9f:
            r8.close()     // Catch: java.lang.Exception -> La2
        La2:
            return r9
        La3:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lb9
            r3 = 23
            if (r2 < r3) goto Lc1
            com.bytedance.embedapplog.a r2 = com.bytedance.embedapplog.a.y()     // Catch: java.lang.Throwable -> Lb9
            android.app.Application r2 = r2.xj     // Catch: java.lang.Throwable -> Lb9
            int r2 = OQbmgg.A2egSU.A2egSU(r2)     // Catch: java.lang.Throwable -> Lb9
            if (r2 != 0) goto Lbb
            com.bytedance.embedapplog.cu.hf(r8)     // Catch: java.lang.Throwable -> Lb9
            goto Lc1
        Lb9:
            r8 = move-exception
            goto Lce
        Lbb:
            java.lang.SecurityException r9 = new java.lang.SecurityException     // Catch: java.lang.Throwable -> Lb9
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Lb9
            throw r9     // Catch: java.lang.Throwable -> Lb9
        Lc1:
            if (r1 == 0) goto Lc8
            r1.release()     // Catch: java.lang.Exception -> Lc7
            goto Lc8
        Lc7:
        Lc8:
            if (r0 == 0) goto Lcd
            r0.close()     // Catch: java.lang.Exception -> Lcd
        Lcd:
            return r9
        Lce:
            if (r1 == 0) goto Ld5
            r1.release()     // Catch: java.lang.Exception -> Ld4
            goto Ld5
        Ld4:
        Ld5:
            if (r0 == 0) goto Lda
            r0.close()     // Catch: java.lang.Exception -> Lda
        Lda:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.n.xj(java.lang.String, java.lang.String):java.lang.String");
    }

    public abstract boolean xj(JSONObject jSONObject);

    public n(boolean z, boolean z2, boolean z3) {
        this.hf = z;
        this.w = z2;
        this.u = z3;
    }
}
