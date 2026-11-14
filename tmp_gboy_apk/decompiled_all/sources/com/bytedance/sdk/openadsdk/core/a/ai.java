package com.bytedance.sdk.openadsdk.core.a;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ai {
    public static final hf.xj hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        return new hf.xj(hfVar);
    }

    public static com.bytedance.sdk.openadsdk.zg.w.w.hf xj(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            hf.xj xjVar = new hf.xj();
            xjVar.xj(jSONObject.optString("mAdId", ""));
            xjVar.hf(jSONObject.optString("mCreativeId", ""));
            xjVar.w(jSONObject.optString("mExt", ""));
            xjVar.u(jSONObject.optString("mCodeId", ""));
            xjVar.d(jSONObject.optString("mUserData"));
            xjVar.xj(jSONObject.optBoolean("mIsAutoPlay", true));
            int optInt = jSONObject.optInt("mImgAcceptedWidth", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
            xjVar.hf(jSONObject.optInt("mImgAcceptedHeight", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
            xjVar.xj(optInt);
            double optDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double optDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            xjVar.hf(Double.valueOf(optDouble).floatValue());
            xjVar.xj(Double.valueOf(optDouble2).floatValue());
            xjVar.hf(jSONObject.optBoolean("mSupportDeepLink", true));
            xjVar.w(jSONObject.optInt("mAdCount", 1));
            xjVar.kd(jSONObject.optString("mMediaExtra", ""));
            xjVar.y(jSONObject.optString("mUserID", ""));
            xjVar.u(jSONObject.optInt("mOrientation", 2));
            xjVar.kd(jSONObject.optInt("mNativeAdType"));
            xjVar.xj(wo.p(jSONObject.optString("mExternalABVid", "")));
            xjVar.y(jSONObject.optInt("mAdLoadSeq", 0));
            xjVar.c(jSONObject.optString("mPrimeRit", ""));
            xjVar.f(jSONObject.optString("mBidAdm"));
            xjVar.f(jSONObject.optInt("mRewardAmount", 0));
            xjVar.tf(jSONObject.optString("mRewardName", ""));
            return xjVar.xj();
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mAdId", hfVar.xj());
            jSONObject.put("mCreativeId", hfVar.hf());
            jSONObject.put("mExt", hfVar.w());
            jSONObject.put("mCodeId", str);
            jSONObject.put("mUserData", hfVar.ht());
            jSONObject.put("mIsAutoPlay", hfVar.kd());
            jSONObject.put("mImgAcceptedWidth", hfVar.y());
            jSONObject.put("mImgAcceptedHeight", hfVar.c());
            jSONObject.put("mExpressViewAcceptedWidth", hfVar.f());
            jSONObject.put("mExpressViewAcceptedHeight", hfVar.d());
            jSONObject.put("mSupportDeepLink", hfVar.tf());
            jSONObject.put("mSupportRenderControl", hfVar.p());
            if (com.bytedance.sdk.openadsdk.core.ai.w >= 5900) {
                jSONObject.put("mSupportIconStyle", hfVar.io());
            }
            jSONObject.put("mAdCount", hfVar.pl());
            jSONObject.put("mMediaExtra", hfVar.g());
            jSONObject.put("mUserID", hfVar.am());
            jSONObject.put("mOrientation", hfVar.qt());
            jSONObject.put("mNativeAdType", hfVar.zg());
            jSONObject.put("mExternalABVid", wo.xj(hfVar.e()));
            jSONObject.put("mAdLoadSeq", hfVar.yo());
            jSONObject.put("mPrimeRit", hfVar.v());
            jSONObject.put("mBidAdm", hfVar.pz());
            jSONObject.put("mRewardAmount", hfVar.et());
            jSONObject.put("mRewardName", hfVar.dk());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        return xj(hfVar, hfVar.u());
    }

    public static com.bytedance.sdk.openadsdk.zg.w.w.hf xj(int i, String str, float f, float f2) {
        return xj().u(str).c(i).hf(f2).xj(f).xj();
    }

    public static com.bytedance.sdk.openadsdk.zg.w.w.hf xj(int i) {
        return xj().c(i).xj();
    }

    public static com.bytedance.sdk.openadsdk.zg.w.w.hf xj(int i, PluginValueSet pluginValueSet) {
        com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar = new com.bytedance.sdk.openadsdk.zg.w.w.hf(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>());
        hf.xj xjVar = new hf.xj(hfVar);
        float f = hfVar.f();
        float d = hfVar.d();
        if (f <= 0.0f) {
            f = r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), hfVar.y());
            d = r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), hfVar.c());
        }
        if (f > 0.0f || d > 0.0f) {
            int u = (int) (r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), r.kd(com.bytedance.sdk.openadsdk.core.pz.getContext())) * 1.3d);
            int u2 = (int) (r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), r.u(com.bytedance.sdk.openadsdk.core.pz.getContext())) * 1.3d);
            int max = Math.max(u, u2);
            int min = Math.min(u, u2);
            if (f > d) {
                if (u2 > 0) {
                    float f2 = max;
                    if (f > f2) {
                        d = min;
                        f = f2;
                    }
                }
            } else if (u > 0) {
                float f3 = max;
                if (d > f3) {
                    f = min;
                    d = f3;
                }
            }
        }
        xjVar.xj(f).hf(d);
        return new com.bytedance.sdk.openadsdk.core.ra.w(hf(xjVar.xj()).c(i).xj());
    }

    private static final hf.xj xj() {
        return new hf.xj().w(1).hf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).xj(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).hf(true).y("defaultUser").u(2).xj(true);
    }

    public static boolean xj(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z);
        }
        return ((Boolean) com.bytedance.sdk.openadsdk.core.pz.hf().xj(str, (String) Boolean.valueOf(z))).booleanValue();
    }

    public static long xj(JSONObject jSONObject, String str, long j) {
        if (jSONObject.has(str)) {
            return jSONObject.optLong(str, j);
        }
        return ((Long) com.bytedance.sdk.openadsdk.core.pz.hf().xj(str, (String) Long.valueOf(j))).longValue();
    }

    public static int xj(JSONObject jSONObject, String str, int i) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str, i);
        }
        return ((Integer) com.bytedance.sdk.openadsdk.core.pz.hf().xj(str, (String) Integer.valueOf(i))).intValue();
    }
}
