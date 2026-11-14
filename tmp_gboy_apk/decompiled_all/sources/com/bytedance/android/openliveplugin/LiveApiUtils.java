package com.bytedance.android.openliveplugin;

import J3FDQU.A2egSU;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LiveApiUtils {
    public static Map<String, Integer> getCJPayAnimationResourceMap() {
        HashMap hashMap = new HashMap();
        A2egSU.BNL6CD(2130771994, hashMap, "TTCJPayKeyActivityAddInAnimationResource", 2130771997, "TTCJPayKeyActivityRemoveOutAnimationResource");
        A2egSU.BNL6CD(2130771995, hashMap, "TTCJPayKeyActivityFadeInAnimationResource", 2130771996, "TTCJPayKeyActivityFadeOutAnimationResource");
        A2egSU.BNL6CD(2130772002, hashMap, "TTCJPayKeySlideInFromBottomAnimationResource", 2130772003, "TTCJPayKeySlideOutToBottomAnimationResource");
        A2egSU.BNL6CD(2130772004, hashMap, "TTCJPayKeySlideRightInAnimationResource", 2130772000, "TTCJPayKeyFragmentUpInAnimationResource");
        hashMap.put("TTCJPayKeyFragmentDownOutAnimationResource", 2130771999);
        return hashMap;
    }
}
