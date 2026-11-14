package com.kwad.sdk.api.loader;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.g;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class m {
    private final String ayH;
    private final String ayI;
    private final String ayJ;
    private Resources ayK;
    private ClassLoader ayL;
    private IKsAdSDK ayM;

    private m(String str, String str2, String str3) {
        this.ayH = str;
        this.ayI = str2;
        this.ayJ = str3;
    }

    private void Fa() {
        if (TextUtils.isEmpty(this.ayH)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.ayH);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    public static synchronized m a(Context context, ClassLoader classLoader, String str) {
        m b;
        synchronized (m.class) {
            try {
                b = b(context, classLoader, j.x(context, str), j.y(context, str), j.z(context, str));
            } catch (Throwable th) {
                com.kwad.sdk.api.c.m(th);
                return null;
            }
        }
        return b;
    }

    public static m b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("mApk not a file");
        }
        try {
            if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                file.setReadOnly();
            }
        } catch (Throwable unused) {
        }
        m mVar = new m(str, str2, str3);
        mVar.a(context, classLoader);
        return mVar;
    }

    public final Resources EY() {
        return this.ayK;
    }

    public final IKsAdSDK EZ() {
        return this.ayM;
    }

    public final ClassLoader getClassLoader() {
        return this.ayL;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.ayH + "', mDexDir='" + this.ayI + "', mNativeLibDir='" + this.ayJ + "', mResource=" + this.ayK + ", mClassLoader=" + this.ayL + ", mKsSdk=" + this.ayM + '}';
    }

    private void a(Context context, ClassLoader classLoader) {
        Fa();
        Resources a2 = w.a(context, context.getResources(), this.ayH);
        ClassLoader a3 = g.a(context, classLoader, this.ayH, this.ayI, this.ayJ);
        IKsAdSDK a4 = Loader.a(a3);
        this.ayK = a2;
        this.ayL = a3;
        this.ayM = a4;
        if (a4.getClass().getClassLoader() instanceof g.a) {
            int sDKType = a4.getSDKType();
            if (sDKType != 1) {
                throw new RuntimeException(CtFAbx.ARc23Z(sDKType, "sdkType error apiType: 1 , sdkType:"));
            }
            return;
        }
        throw new RuntimeException("classLoader is not expect dynamic classloader:");
    }
}
