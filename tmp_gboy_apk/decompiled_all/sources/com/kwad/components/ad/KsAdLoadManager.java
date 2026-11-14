package com.kwad.components.ad;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.g;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class KsAdLoadManager {
    private volatile boolean bA;

    public enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager(0);

        static {
            NpfwN();
        }

        Holder() {
        }

        private static /* synthetic */ void NpfwN() {
            char[] charArray = "\u0019\u0015\u0017T\u001d\u001b\u0017\u001fT\u0018\u0015\u0003T\t\u0012\u001f\u0016\u0016T0\u0014\u00138\b\u0013\u001e\u001d\u001f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'z');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0019\u0016\u0013\u0014\u0013\u000e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'z');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    private static void N() {
        boolean Ii = e.Ii();
        A2egSU.B9tovu("reportInstallerCheckRecord isInstallerCheckEnable: ", "AdLoadManager", Ii);
        if (Ii) {
            Context context = ServiceProvider.getContext();
            try {
                com.kwad.components.ad.j.b.ak(context);
                com.kwad.components.ad.j.b.al(context);
            } catch (Throwable th) {
                com.kwad.sdk.crash.b.n(th);
            }
        }
    }

    private static boolean b(com.kwad.components.core.request.model.a aVar) {
        try {
            d.f(DevelopMangerComponents.class);
            return false;
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
            return false;
        }
    }

    public final void a(com.kwad.components.core.request.model.a aVar) {
        if (!l.DP().Eq()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aIZ;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, true);
        } else {
            if (c.c(aVar) || b(aVar)) {
                return;
            }
            if (!this.bA) {
                N();
                this.bA = true;
            }
            com.kwad.components.core.c.d.oq().d(aVar);
        }
    }

    private KsAdLoadManager() {
        this.bA = false;
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g.oz().add(it.next());
        }
    }

    public final synchronized <T> void a(T t) {
        g.oz().add(t);
    }
}
