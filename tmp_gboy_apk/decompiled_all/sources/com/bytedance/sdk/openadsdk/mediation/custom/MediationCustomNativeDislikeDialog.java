package com.bytedance.sdk.openadsdk.mediation.custom;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface MediationCustomNativeDislikeDialog {
    void dislikeClick(String str, Map<String, Object> map);

    MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map);
}
