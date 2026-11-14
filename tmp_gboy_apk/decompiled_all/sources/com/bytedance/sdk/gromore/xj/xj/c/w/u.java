package com.bytedance.sdk.gromore.xj.xj.c.w;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static Bundle xj(com.bytedance.msdk.api.w.xj xjVar) {
        Bundle bundle = new Bundle();
        if (xjVar != null) {
            float hf = xjVar.hf();
            String w = xjVar.w();
            Map<String, Object> u = xjVar.u();
            if (u == null) {
                u = new HashMap<>();
            }
            Object obj = u.get(MediationConstant.KEY_EXTRA_INFO);
            if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                bundle2.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, hf);
                bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, w);
                return bundle2;
            }
            bundle.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, w);
            bundle.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, hf);
            Object obj2 = u.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
            if (obj2 instanceof Boolean) {
                bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj2).booleanValue());
            }
            Object obj3 = u.get("transId");
            if (obj3 instanceof String) {
                bundle.putString("transId", (String) obj3);
            }
            Object obj4 = u.get(MediationConstant.KEY_REASON);
            if (obj4 instanceof Integer) {
                bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj4).intValue());
            }
            Object obj5 = u.get("gromoreExtra");
            if (obj5 instanceof String) {
                bundle.putString("gromoreExtra", (String) obj5);
            }
            Object obj6 = u.get(MediationConstant.KEY_ERROR_CODE);
            if (obj6 instanceof Integer) {
                bundle.putInt(MediationConstant.KEY_ERROR_CODE, ((Integer) obj6).intValue());
            }
            Object obj7 = u.get(MediationConstant.KEY_ERROR_MSG);
            if (obj7 instanceof String) {
                bundle.putString(MediationConstant.KEY_ERROR_MSG, (String) obj7);
            }
            Object obj8 = u.get(MediationConstant.KEY_ADN_NAME);
            if (obj8 instanceof String) {
                bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj8);
            }
        }
        return bundle;
    }
}
