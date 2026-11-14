package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.g;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private static final Map<Class<?>, Class<?>> bdf = new HashMap(r.b.d);
    private static final Map<Class<?>, Class<?>> bdg = new HashMap();
    private static boolean bdh = false;
    private static boolean bdi = false;

    static {
        NZsLlr();
    }

    private static /* synthetic */ void NZsLlr() {
        char[] charArray = "L@B\u0001HNBJ\u0001M@V\u0001\\GJCC\u0001eAFm]FKHJ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '/');
        }
        String str = new String(charArray);
        char[] charArray2 = "LCFAF[".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '/');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static synchronized void QZ() {
        synchronized (c.class) {
            if (bdh) {
                return;
            }
            Ra();
            bdh = true;
        }
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    private static void Ra() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        g.register();
        com.kwad.components.core.r.a.a.register();
        FileDownloadServiceProxy.register();
        com.kwad.sdk.collector.b.a.register();
        a.register();
    }

    private static synchronized void Rb() {
        synchronized (c.class) {
            if (bdi) {
                return;
            }
            Rc();
            bdi = true;
        }
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    private static void Rc() {
        com.kwad.components.ad.reward.retryReward.a.register();
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.p.b.register();
        SceneImpl.register();
    }

    public static void a(Class cls, Class cls2) {
        bdg.put(cls, cls2);
    }

    public static Class<?> g(Class<?> cls) {
        QZ();
        return bdf.get(cls);
    }

    public static Class<?> h(Class<?> cls) {
        Rb();
        return bdg.get(cls);
    }

    public static void init() {
        QZ();
        Rb();
    }

    public static void putComponentProxy(Class<?> cls, Class<?> cls2) {
        bdf.put(cls, cls2);
    }
}
