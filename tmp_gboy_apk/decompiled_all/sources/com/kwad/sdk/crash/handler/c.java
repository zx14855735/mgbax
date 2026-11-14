package com.kwad.sdk.crash.handler;

import android.content.Context;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c extends b {

    public static class a {
        private static final c aUb = new c(0);

        static {
            PdGbB();
        }

        private static /* synthetic */ void PdGbB() {
            char[] charArray = "HDF\u0005LJFN\u0005IDR\u0005XCNGG\u0005aEBiYBOLN".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '+');
            }
            String str = new String(charArray);
            char[] charArray2 = "HGBEB_".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '+');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c Ny() {
        return a.aUb;
    }

    public final void a(Throwable th, ExceptionMessage exceptionMessage, Context context) {
        a(th, exceptionMessage, context, ((f) ServiceProvider.get(f.class)).CT());
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, com.kwad.sdk.crash.f fVar, e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.Nj().isDebug()) {
            b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }

    private c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01aa A[Catch: all -> 0x01c3, TryCatch #2 {all -> 0x01c3, blocks: (B:29:0x01a0, B:31:0x01aa, B:33:0x01bd, B:35:0x01c7, B:37:0x01cc, B:39:0x01d9, B:42:0x01e1, B:43:0x01e4, B:44:0x0206, B:49:0x01ea, B:51:0x01ef, B:52:0x01f7, B:55:0x01ff), top: B:28:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.Throwable r18, com.kwad.sdk.crash.model.message.ExceptionMessage r19, android.content.Context r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.handler.c.a(java.lang.Throwable, com.kwad.sdk.crash.model.message.ExceptionMessage, android.content.Context, boolean):void");
    }
}
