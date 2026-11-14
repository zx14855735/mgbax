package com.kwad.components.ad.reward.e;

import com.kwad.sdk.api.KsRewardVideoAd;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class f {
    private static final HashMap<String, f> uw = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private com.kwad.components.core.j.d ru;
    private KsRewardVideoAd.RewardAdInteractionListener ux;

    static {
        oWEx();
    }

    private static f M(String str) {
        return uw.get(str);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener N(String str) {
        f M = M(str);
        if (M != null) {
            return M.ux;
        }
        return null;
    }

    public static void O(String str) {
        f M = M(str);
        if (M != null) {
            M.ux = M.mInteractionListener;
        }
    }

    public static com.kwad.components.core.j.d P(String str) {
        f M = M(str);
        if (M != null) {
            return M.ru;
        }
        return null;
    }

    public static void Q(String str) {
        f M = M(str);
        if (M != null) {
            M.destroy();
            uw.put(str, null);
        }
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.ru = dVar;
        fVar.ux = rewardAdInteractionListener;
        uw.put(str, fVar);
    }

    private void destroy() {
        this.mInteractionListener = null;
        this.ux = null;
        com.kwad.components.core.j.d dVar = this.ru;
        if (dVar != null) {
            dVar.destroy();
            this.ru = null;
        }
    }

    private static /* synthetic */ void oWEx() {
        char[] charArray = "@LN\rDBNF\rALZ\rPKFOO\riMJaQJGDF".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '#');
        }
        String str = new String(charArray);
        char[] charArray2 = "@OJMJW".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '#');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
