package com.kwad.sdk.crash.utils;

import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class i {
    private static SimpleDateFormat aVY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        sgfj();
    }

    public static String aO(long j) {
        return j <= 0 ? MediationConfigUserInfoForSegment.GENDER_UNKNOWN : aVY.format(new Date(j));
    }

    private static /* synthetic */ void sgfj() {
        char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 30);
        }
        String str = new String(charArray);
        char[] charArray2 = "}rwpwj".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 30);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
