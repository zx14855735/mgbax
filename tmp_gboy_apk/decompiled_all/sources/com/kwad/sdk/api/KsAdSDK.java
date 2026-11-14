package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.aa;
import com.kwad.sdk.api.loader.e;
import com.kwad.sdk.api.loader.q;
import com.kwad.sdk.api.loader.r;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsAdSDK {
    private static final int INIT_ERROR_IKSADSDK_NULL_CODE = -1;
    private static final String INIT_ERROR_IKSADSDK_NULL_MSG = "IKsAdSDK对象创建异常";
    private static Context mOriginalAppContext;
    private static String sAppTag;
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean sHasRest = new AtomicBoolean(false);

    @A2egSU
    private static IKsAdSDK sSdk;

    @A2egSU
    @Retention(RetentionPolicy.SOURCE)
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    @A2egSU
    @Retention(RetentionPolicy.SOURCE)
    public @interface SdkType {
        public static final int AD = 1;
        public static final int CAR = 5;
        public static final int CT = 2;
        public static final int CT_PURE = 4;
        public static final int EC = 3;
    }

    static {
        vujai();
    }

    @KsAdSdkApi
    @A2egSU
    public static void deleteCache() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.deleteCache();
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static String getAppId() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppId();
        }
        return null;
    }

    @KsAdSdkApi
    @A2egSU
    public static String getAppName() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppName();
        }
        return null;
    }

    @KsAdSdkApi
    @A2egSU
    public static Context getContext() {
        return mOriginalAppContext;
    }

    @KsAdSdkApi
    @A2egSU
    public static String getDid() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getDid();
        }
        return null;
    }

    @KsAdSdkApi
    @A2egSU
    public static synchronized KsLoadManager getLoadManager() {
        synchronized (KsAdSDK.class) {
            if (sSdk == null || !sHasInit.get()) {
                return new b();
            }
            return sSdk.getAdManager();
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static int getSDKType() {
        return 1;
    }

    @KsAdSdkApi
    @A2egSU
    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static boolean haseInit() {
        return sHasInit.get();
    }

    @KsAdSdkApi
    @A2egSU
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        long elapsedRealtime;
        Context context2;
        Throwable th;
        synchronized (KsAdSDK.class) {
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (context == null || sdkConfig == null) {
                throw new RuntimeException("init context or config is null");
            }
            mOriginalAppContext = context;
            try {
                context2 = e.be(context);
                if (context2 == null) {
                    throw new RuntimeException("init wrapperApp Exception");
                }
                try {
                    q Fb = r.Fb();
                    if (Fb != null) {
                        Fb.holdSdkConfig(sdkConfig);
                    }
                    IKsAdSDK init = Loader.get().init(context2, KsAdSDK.class.getClassLoader());
                    sSdk = init;
                    if (init == null) {
                        notifyInitFail(sdkConfig, -1, INIT_ERROR_IKSADSDK_NULL_MSG);
                    }
                    sSdk.setApiVersion(BuildConfig.VERSION_NAME);
                    sSdk.setApiVersionCode(BuildConfig.VERSION_CODE);
                    sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                    Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context2);
                    if (wrapContextIfNeed == null) {
                        throw new RuntimeException("init wrapContextIfNeed Exception");
                    }
                    try {
                        sSdk.setInitStartTime(elapsedRealtime);
                    } catch (Throwable th3) {
                        c.m(th3);
                    }
                    sSdk.init(wrapContextIfNeed, sdkConfig);
                    sSdk.setAppTag(sAppTag);
                    aa.a(context2, sSdk);
                    com.kwad.sdk.api.loader.b.a(context2, sdkConfig);
                    c.oL();
                    sHasInit.set(sSdk != null);
                    return sHasInit.get();
                } catch (Throwable th4) {
                    th = th4;
                    revertDynamic(th, context2, sdkConfig);
                    return false;
                }
            } catch (Throwable th5) {
                context2 = context;
                th = th5;
            }
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static boolean isDebugLogEnable() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.isDebugLogEnable();
        }
        return false;
    }

    private static void notifyInitFail(SdkConfig sdkConfig, int i, String str) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    ksInitCallback.onFail(i, str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static void pauseCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.pauseCurrentPlayer();
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.resumeCurrentPlayer();
        }
    }

    private static void revertDynamic(Throwable th, Context context, SdkConfig sdkConfig) {
        AtomicBoolean atomicBoolean = sHasRest;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        aa.bn(context);
        Loader.get().rest();
        String str = sdkConfig.appId;
        init(context, sdkConfig);
        c.m(th);
    }

    @KsAdSdkApi
    @A2egSU
    public static void setAdxEnable(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAdxEnable(z);
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static void setAppTag(String str) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAppTag(str);
        } else {
            sAppTag = str;
        }
    }

    public static void setLoadingLottieAnimation(boolean z, int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimation(z, i);
        }
    }

    public static void setLoadingLottieAnimationColor(boolean z, int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimationColor(z, i);
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static void setPersonalRecommend(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setPersonalRecommend(z);
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static void setProgrammaticRecommend(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setProgrammaticRecommend(z);
        }
    }

    public static void setThemeMode(int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setThemeMode(i);
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static synchronized void start() {
        synchronized (KsAdSDK.class) {
            try {
                sSdk.start();
            } catch (Throwable th) {
                c.m(th);
            }
        }
    }

    @KsAdSdkApi
    @A2egSU
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }

    private static /* synthetic */ void vujai() {
        char[] charArray = "¤¨ªé ¦ª¢é¥¨¾é´¯¢««é\u008d©®\u0085µ®£ ¢".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 199);
        }
        String str = new String(charArray);
        char[] charArray2 = "¤«®©®³".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 199);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @KsAdSdkApi
    @A2egSU
    public static String getSDKVersion(int i) {
        return i != 1 ? "" : BuildConfig.VERSION_NAME;
    }
}
