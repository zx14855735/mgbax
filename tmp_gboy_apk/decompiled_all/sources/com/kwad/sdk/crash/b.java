package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private static volatile boolean aTc;
    private static volatile boolean aTd;
    private static volatile boolean aTe;
    private static Handler agN = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] aTf = {"c++_shared", "plt-base", "plt-unwind", "exception-handler"};
    private static boolean aTg = false;
    private static boolean aTh = false;

    static {
        JofTK();
    }

    private static /* synthetic */ void JofTK() {
        char[] charArray = "gki*ceia*fk}*wlahh*NjmFvm`ca".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 4);
        }
        String str = new String(charArray);
        char[] charArray2 = "ghmjmp".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 4);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean MU() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : aTf) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "loadExceptionLibSo load " + str);
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "loadExceptionLibSo fail\n" + Log.getStackTraceString(th));
            ISLOADED.set(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MV() {
        if (Build.VERSION.SDK_INT <= 23) {
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "initNativeFunc 版本过低, 会有崩溃");
            return;
        }
        com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init onLoad：enableAnrReport:" + aTg + " *enableNativeReport" + aTh);
        if (aTg) {
            MW();
        }
        if (aTh) {
            c(false, "/sdcard/");
        }
    }

    private static void MW() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.a.a.Nu(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.Nj().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final File Nf() {
                return new File(com.kwad.sdk.crash.a.a.Ns(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                if (exceptionMessage == null || TextUtils.isEmpty(exceptionMessage.mCrashDetail) || !com.kwad.sdk.crash.b.a.fT(exceptionMessage.mCrashDetail)) {
                    return;
                }
                com.kwad.sdk.core.d.c.e("AnrAndNativeExceptionCollector", "ANR true upload:" + exceptionMessage.mCrashDetail);
                a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    private static synchronized void MX() {
        synchronized (b.class) {
            if (!aTc) {
                aTc = true;
                com.kwad.sdk.utils.h.schedule(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.MZ();
                        } catch (Throwable unused) {
                        }
                    }
                }, d.aTK, TimeUnit.SECONDS);
            }
        }
    }

    public static synchronized void MY() {
        synchronized (b.class) {
            if (!aTd) {
                aTd = true;
                com.kwad.sdk.utils.h.schedule(new Runnable() { // from class: com.kwad.sdk.crash.b.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.Na();
                        } catch (Throwable unused) {
                        }
                    }
                }, d.aTK, TimeUnit.SECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MZ() {
        Nb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Na() {
        if (aTg) {
            Nc();
        }
        if (aTh) {
            Nd();
        }
    }

    private static void Nb() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.Ny().getUploader());
        fVar.D(com.kwad.sdk.crash.a.a.Nt());
    }

    private static void Nc() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.D(com.kwad.sdk.crash.a.a.Nu());
    }

    private static void Nd() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.D(com.kwad.sdk.crash.a.a.Nv());
    }

    public static void a(c cVar) {
        if (cVar.context == null || aTe) {
            return;
        }
        aTe = true;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.a.a.init(cVar.context, cVar.aTv);
            e.Nj().a(cVar);
            cj(cVar.context);
            MX();
        } catch (Throwable unused) {
        }
    }

    public static void b(c cVar) {
        aTg = cVar.aTg;
        aTh = cVar.aTh;
        if (ci(cVar.context)) {
            return;
        }
        if (aTg || aTh) {
            g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                @Override // com.kwad.sdk.crash.g.a
                public final void Ne() {
                    GlobalThreadPools.Lq().execute(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                b.MV();
                                b.MY();
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                        }
                    });
                }

                @Override // com.kwad.sdk.crash.g.a
                public final void qF() {
                    com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init fail");
                }
            });
        }
    }

    private static void c(boolean z, String str) {
        if (com.kwad.sdk.crash.a.a.A(com.kwad.sdk.crash.a.a.Nv())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.a.a.Nv(), false, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
                @Override // com.kwad.sdk.crash.report.e
                public final File Nf() {
                    return new File(com.kwad.sdk.crash.a.a.Ns(), "native_crash_log/upload");
                }

                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                    try {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "Native upload");
                        if (exceptionMessage == null) {
                            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "Native upload but msg is null");
                            return;
                        }
                        if (com.kwad.sdk.crash.b.a.fS(exceptionMessage.mThreadName) || com.kwad.sdk.crash.b.a.fT(exceptionMessage.mCrashDetail)) {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "true upload msg:" + exceptionMessage.mCrashDetail);
                            a(exceptionMessage, 4, countDownLatch);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static boolean ci(Context context) {
        return context == null || ag.de(context) >= 3;
    }

    private static void cj(Context context) {
        com.kwad.sdk.crash.handler.c.Ny().init(com.kwad.sdk.crash.a.a.Nt(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.Nj().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final File Nf() {
                return new File(com.kwad.sdk.crash.a.a.Ns(), "java_crash/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    public static void n(final Throwable th) {
        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.o(th)) {
                        com.kwad.sdk.crash.handler.a.handleCaughtException(th);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
    }
}
