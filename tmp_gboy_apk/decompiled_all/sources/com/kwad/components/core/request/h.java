package com.kwad.components.core.request;

import android.content.Context;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class h {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean aaM = false;
    private static final List<a> aaN = new CopyOnWriteArrayList();

    public interface a {
        void d(SdkConfigData sdkConfigData);

        void tN();
    }

    public interface b extends a {
        void tO();
    }

    static {
        LLkX();
    }

    private static /* synthetic */ void LLkX() {
        char[] charArray = "6:8{2480{7:,{&=099{\u001f;<\u0017'<120".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'U');
        }
        String str = new String(charArray);
        char[] charArray2 = "69<;<!".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'U');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized void a(a aVar) {
        synchronized (h.class) {
            com.kwad.sdk.core.d.c.d("ConfigRequestManager", "init config");
            if (sHasInit.get()) {
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "config request manager has init");
            } else {
                aaN.add(aVar);
                com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.request.h.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        Context Re = ServiceProvider.Re();
                        ag.l(Re, ag.de(Re) + 1);
                        com.kwad.sdk.core.config.e.bB(Re);
                        h.tJ();
                        h.tI();
                    }
                });
            }
        }
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        aaM = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(int i, String str) {
        for (a aVar : aaN) {
            try {
                if (aVar instanceof b) {
                    ((b) aVar).tO();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static void tI() {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "requestConfig");
        new com.kwad.sdk.core.network.l<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.2
            private static SdkConfigData aP(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    ag.ao(ServiceProvider.Re(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                    return sdkConfigData;
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                    return sdkConfigData;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: tM, reason: merged with bridge method [inline-methods] */
            public g createRequest() {
                GlobalThreadPools.Lq().execute(new Runnable() { // from class: com.kwad.components.core.request.h.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.kwad.sdk.core.request.model.e.KG();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return new g();
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return aP(str);
            }
        }.request(new o<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(g gVar, int i, String str) {
                super.onError(gVar, i, str);
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                h.p(i, str);
            }

            private static void c(SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.d.c.U("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.bz(ServiceProvider.Re());
                    com.kwad.sdk.core.config.e.f(sdkConfigData);
                    h.access$102(true);
                    h.a(sdkConfigData);
                    af.Sb();
                    af.RV();
                    ag.l(ServiceProvider.Re(), 0);
                    if (ag.Si() != com.kwad.sdk.core.config.e.HZ()) {
                        ag.f(ServiceProvider.Re(), com.kwad.sdk.core.config.e.HZ());
                    }
                    h.sHasInit.set(true);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tJ() {
        Iterator<a> it = aaN.iterator();
        while (it.hasNext()) {
            try {
                it.next().tN();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static void b(a aVar) {
        try {
            aaN.add(aVar);
            if (com.kwad.sdk.core.config.e.isLoaded()) {
                aVar.tN();
            }
            if (aaM) {
                aVar.d(com.kwad.sdk.core.config.e.Hl());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(SdkConfigData sdkConfigData) {
        Iterator<a> it = aaN.iterator();
        while (it.hasNext()) {
            try {
                it.next().d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
