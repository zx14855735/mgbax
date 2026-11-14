package com.ss.android.socialbase.appdownloader.y.xj;

import com.bytedance.sdk.component.utils.pl;
import java.io.PrintStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends Exception {
    protected int hf;
    protected int w;
    protected Throwable xj;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f(java.lang.String r4, com.ss.android.socialbase.appdownloader.y.xj.c r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            if (r4 != 0) goto Lb
            r4 = r1
            goto L11
        Lb:
            java.lang.String r2 = " "
            java.lang.String r4 = r4.concat(r2)
        L11:
            r0.append(r4)
            if (r5 != 0) goto L18
            r4 = r1
            goto L2f
        L18:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r2 = "(position:"
            r4.<init>(r2)
            java.lang.String r2 = r5.u()
            r4.append(r2)
            java.lang.String r2 = ") "
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L2f:
            r0.append(r4)
            if (r6 != 0) goto L35
            goto L43
        L35:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "caused by: "
            r4.<init>(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
        L43:
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            r4 = -1
            r3.hf = r4
            r3.w = r4
            if (r5 == 0) goto L60
            int r4 = r5.w()
            r3.hf = r4
            int r4 = r5.y()
            r3.w = r4
        L60:
            r3.xj = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.y.xj.f.<init>(java.lang.String, com.ss.android.socialbase.appdownloader.y.xj.c, java.lang.Throwable):void");
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.xj == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            super.getMessage();
            printStream.getClass();
            pl.xj(this.xj);
        }
    }
}
