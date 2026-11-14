package com.kwad.components.ad.reward.retryReward;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bx;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e {
    private Object AJ;

    public static class a {
        private static final e AK = new e(0);

        static {
            zGBJr();
        }

        private static /* synthetic */ void zGBJr() {
            char[] charArray = "MAC\u0000IOCK\u0000LAW\u0000]FKBB\u0000d@Gl\\GJIK".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '.');
            }
            String str = new String(charArray);
            char[] charArray2 = "MBG@GZ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '.');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e kx() {
        return a.AK;
    }

    public static boolean ky() {
        return bx.aC(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion(), BuildConfig.VERSION_NAME);
    }

    public final void e(Object obj) {
        try {
            if (ky() && (obj instanceof KsRewardVideoAd.KSAdRewardRetryTaskListener)) {
                this.AJ = obj;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void onAdRewardRetryTaskNotify(KSAdInfoData kSAdInfoData) {
        try {
            if (ky()) {
                Object obj = this.AJ;
                if (obj instanceof KsRewardVideoAd.KSAdRewardRetryTaskListener) {
                    ((KsRewardVideoAd.KSAdRewardRetryTaskListener) obj).onAdRewardRetryTaskNotify(kSAdInfoData);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private e() {
    }
}
