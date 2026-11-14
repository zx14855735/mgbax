package com.kwad.sdk.crash.report;

import android.util.Log;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class c implements e {
    private ArrayList<a> aVj = new ArrayList<>();

    public static class a {
        private ExceptionMessage aVk;
        private int aVl;

        public a(ExceptionMessage exceptionMessage, int i) {
            this.aVk = exceptionMessage;
            this.aVl = i;
        }
    }

    private void NM() {
        if (this.aVj.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.aVj.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.aVk, next.aVl, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i, CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e Nj = com.kwad.sdk.crash.e.Nj();
            if (Nj.No() != null && Nj.Nn() != 2) {
                List<com.kwad.sdk.crash.a> list = Nj.No().aTA;
                double d = Nj.No().aTb;
                String appId = Nj.getAppId();
                String sdkVersion = Nj.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null) {
                        if (!com.kwad.sdk.crash.utils.c.b(aVar.aSY) && !aVar.aSY.contains(appId)) {
                        }
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aSZ) || aVar.aSZ.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aTa) || a(exceptionMessage.mCrashDetail, aVar.aTa)) {
                                d = aVar.aTb;
                            }
                        }
                    }
                }
                return Math.random() < d;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("BaseExceptionUploader", Log.getStackTraceString(e));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i, CountDownLatch countDownLatch) {
        try {
            NM();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            this.aVj.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private static boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
