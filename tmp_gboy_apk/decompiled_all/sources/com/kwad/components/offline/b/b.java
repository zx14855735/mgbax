package com.kwad.components.offline.b;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b extends com.kwad.components.core.offline.b.a<IAdLiveOfflineCompo> {

    public static final class a {
        private static final b anH = new b(0);

        static {
            XUyJ();
        }

        private static /* synthetic */ void XUyJ() {
            char[] charArray = "nb`#jl`h#obt#~ehaa#GcdO\u007fdijh".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '\r');
            }
            String str = new String(charArray);
            char[] charArray2 = "nadcdy".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '\r');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.b.b.class, methodId = "initOC")
    public static void aN(Context context) {
        xV().init(context);
    }

    private static b xV() {
        return a.anH;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        a(context, iAdLiveOfflineCompo);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.aEx)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rs() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rt() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ru() {
        return "4.8.10";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rv() {
        return "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-4.8.10-f5fb172841-126.zip";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rw() {
        return "4cc470fe636c81efbccf35028d26f1bb";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rx() {
        return "ks_live_4810";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ry() {
        return IAdLiveOfflineCompo.IMPL;
    }

    private b() {
    }

    private void a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.aL(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    d.a(com.kwad.components.core.offline.a.c.a.class, new com.kwad.components.offline.b.a(iAdLiveOfflineCompo));
                    b.this.rr();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
