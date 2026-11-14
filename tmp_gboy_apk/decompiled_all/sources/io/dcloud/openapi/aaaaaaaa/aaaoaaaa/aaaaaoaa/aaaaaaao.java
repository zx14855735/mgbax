package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa;

import android.content.Context;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaao {
    private static volatile aaaaaaao aaaaaaaa;

    private aaaaaaao() {
    }

    public static aaaaaaao aaaaaaaa() {
        if (aaaaaaaa == null) {
            synchronized (aaaaaaao.class) {
                try {
                    if (aaaaaaaa == null) {
                        aaaaaaaa = new aaaaaaao();
                    }
                } finally {
                }
            }
        }
        return aaaaaaaa;
    }

    public String aaaaaaaa(Context context) {
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), r.b.d).metaData.containsKey("com.google.android.gms.ads.APPLICATION_ID")) {
                Method declaredMethod = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", Context.class);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, context);
                Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getId", null);
                declaredMethod2.setAccessible(true);
                return (String) declaredMethod2.invoke(invoke, null);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
