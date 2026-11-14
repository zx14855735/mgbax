package com.kwad.components.offline.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adInnerEc.IAdInnerEcOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bx;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b extends com.kwad.components.core.offline.b.a<IAdInnerEcOfflineCompo> {
    private static Handler iK;

    public static final class a {
        private static final b ans = new b();

        static {
            cusPM();
        }

        private static /* synthetic */ void cusPM() {
            char[] charArray = "ÕÙÛ\u0098Ñ×ÛÓ\u0098ÔÙÏ\u0098ÅÞÓÚÚ\u0098üØßôÄßÒÑÓ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 182);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÕÚßØßÂ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 182);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.b.b.class, methodId = "initOC")
    public static void aN(Context context) {
        xR().init(context);
    }

    private static b xR() {
        return a.ans;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String getTag() {
        return "AdInnerEcInitModule";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.aGB)).booleanValue() && bx.aC(((f) ServiceProvider.get(f.class)).getApiVersion(), (String) e.b(com.kwad.sdk.core.config.c.aGG));
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rs() {
        return "INNEREC";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rt() {
        return IAdInnerEcOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ru() {
        return "4.8.30.2";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rv() {
        return "https://p4-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adInnerEc/ks_so-adInnerEcNoSoRelease-4.8.30.1-ebce5b9c19-227.zip";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rw() {
        return "bf147525d1f7408539d5c3f95b393dde";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rx() {
        return "ks_adinnerec_48302";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ry() {
        return IAdInnerEcOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IAdInnerEcOfflineCompo iAdInnerEcOfflineCompo) {
        a(context, iAdInnerEcOfflineCompo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.offline.a.a.a aVar) {
        com.kwad.sdk.core.d.c.d("AdInnerEcInitModule", ": setHostProvider 执行：");
        if (ServiceProvider.Re() != null) {
            aVar.rm();
        }
    }

    private void a(Context context, final IAdInnerEcOfflineCompo iAdInnerEcOfflineCompo) {
        iAdInnerEcOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.aL(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    com.kwad.sdk.core.d.c.d("AdInnerEcInitModule", "onOfflineCompoLoaded: 电商内循环离线组件初始化成功");
                    final com.kwad.components.offline.a.a aVar = new com.kwad.components.offline.a.a(iAdInnerEcOfflineCompo);
                    d.a(com.kwad.components.core.offline.a.a.a.class, aVar);
                    b.this.rr();
                    if (b.iK == null) {
                        Handler unused = b.iK = new Handler(Looper.getMainLooper());
                    }
                    b.iK.postDelayed(new Runnable() { // from class: com.kwad.components.offline.a.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b bVar = b.this;
                            b.a(aVar);
                        }
                    }, 3000L);
                    com.kwad.sdk.core.d.c.d("AdInnerEcInitModule", "onOfflineCompoLoaded: 电商内循环离线组件 注册 完成：");
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.d("AdInnerEcInitModule", "onOfflineCompoLoaded: 电商内循环离线组件 异常：" + th.getMessage());
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
