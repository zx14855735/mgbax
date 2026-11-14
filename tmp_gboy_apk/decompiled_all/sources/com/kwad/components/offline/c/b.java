package com.kwad.components.offline.c;

import android.content.Context;
import android.os.Build;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b extends com.kwad.components.core.offline.b.a<IAdWaynePlayerOfflineCompo> {

    public static final class a {
        private static final b anQ = new b(0);

        static {
            TuOCJM();
        }

        private static /* synthetic */ void TuOCJM() {
            char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '}');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '}');
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
        xX().init(context);
    }

    private static b xX() {
        return a.anQ;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        a(context, iAdWaynePlayerOfflineCompo);
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String getTag() {
        return "AdWaynePlayerInitModule";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final boolean isEnabled() {
        return Build.VERSION.SDK_INT >= e.a(com.kwad.sdk.core.config.c.aGz) && ((Boolean) e.b(com.kwad.sdk.core.config.c.aGw)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rs() {
        return "WAYNEPLAYER";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rt() {
        return IAdWaynePlayerOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ru() {
        return "4.4.20.1";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rv() {
        return "https://p5-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adWaynePlayer/ks_so-adWaynePlayerNoSoRelease-4.4.20.1-f5fa94106c-87.zip";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rw() {
        return "de8902ac8ffc6225035515217d960ba1";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String rx() {
        return "ks_wayne_player_44201";
    }

    @Override // com.kwad.components.core.offline.b.a
    public final String ry() {
        return IAdWaynePlayerOfflineCompo.IMPL;
    }

    private b() {
    }

    private void a(Context context, final IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        iAdWaynePlayerOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.c.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.aL(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    d.a(com.kwad.components.core.offline.a.b.a.class, new com.kwad.components.offline.c.a(iAdWaynePlayerOfflineCompo));
                    b.this.rr();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
