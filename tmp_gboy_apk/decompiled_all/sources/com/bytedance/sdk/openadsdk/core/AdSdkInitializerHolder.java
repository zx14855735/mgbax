package com.bytedance.sdk.openadsdk.core;

import IySJvm.A2egSU;
import P8ccfD.AaHO0E;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdSdkInitializerHolder {
    private static String MEDIATION_CLASS_NAME = "com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder";
    private static String PACKAGE_NAME = "com.byted.pangle";
    private static volatile Object mDispatchAdSdkInitializer;
    private static volatile w mInitializer;

    private static Object getDispatchAdSdkInitializer(Bundle bundle, w wVar) {
        try {
            return Class.forName(MEDIATION_CLASS_NAME).getDeclaredMethod("getInstance", Bundle.class, w.class).invoke(null, bundle, wVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static Object getNewInstance(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        if (mInitializer == null) {
            synchronized (AdSdkInitializerHolder.class) {
                try {
                    if (mInitializer == null) {
                        mInitializer = new w(bundle);
                        mDispatchAdSdkInitializer = getDispatchAdSdkInitializer(bundle, mInitializer);
                    }
                } finally {
                }
            }
        }
        int i = bundle.getInt("api_sdk_version", 0);
        if (i == 0) {
            i = getSdkVersion();
            com.bytedance.sdk.component.utils.pl.xj("wzj,通过反射取apiSdkVersion值=".concat(String.valueOf(i)));
            if (i == 0) {
                return null;
            }
        }
        A2egSU A2egSU2 = A2egSU.A2egSU();
        if (i <= 0) {
            A2egSU2.getClass();
        } else {
            A2egSU2.f4098A2egSU = i;
        }
        return i < 6803 ? mDispatchAdSdkInitializer != null ? new com.bytedance.sdk.openadsdk.zg.hf.hf.hf(AaHO0E.AYUAbz(mDispatchAdSdkInitializer)) : new com.bytedance.sdk.openadsdk.zg.hf.hf.xj(mInitializer) : mDispatchAdSdkInitializer != null ? mDispatchAdSdkInitializer : mInitializer;
    }

    private static int getSdkVersion() {
        try {
            String str = TTAdSdk.BRANCH;
            return TTAdSdk.class.getField("SDK_VERSION_CODE").getInt(null);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("init", th);
            com.bytedance.sdk.component.utils.pl.xj(th);
            return 0;
        }
    }

    public static boolean hasDispatchAdSdkInitializer() {
        return mDispatchAdSdkInitializer != null;
    }

    public static boolean isSdkInitSuccess() {
        if (mInitializer != null) {
            return mInitializer.xj();
        }
        return false;
    }
}
