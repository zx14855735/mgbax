package com.bytedance.msdk.hf;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.explore.model.ExploreConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj {
    public static int hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("gdt")) {
            return 3;
        }
        if (str.startsWith(MediationConstant.ADN_ADMOB)) {
            return 2;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_PANGLE)) {
            return 1;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_MINTEGRAL)) {
            return 4;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_UNITY)) {
            return 5;
        }
        if (str.equalsIgnoreCase("baidu")) {
            return 6;
        }
        if (str.equalsIgnoreCase("ks")) {
            return 7;
        }
        if (str.equalsIgnoreCase("sigmob")) {
            return 8;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KLEVIN)) {
            return 9;
        }
        return str.equalsIgnoreCase(MediationConstant.ADN_XIAOMI) ? 10 : -1;
    }

    public static String xj(String str) {
        return TextUtils.isEmpty(str) ? str : str.equalsIgnoreCase("gdt") ? "gdt" : str.equalsIgnoreCase(MediationConstant.ADN_ADMOB) ? MediationConstant.ADN_ADMOB : str.equalsIgnoreCase(MediationConstant.ADN_PANGLE) ? MediationConstant.ADN_PANGLE : str.equalsIgnoreCase(MediationConstant.ADN_MINTEGRAL) ? MediationConstant.ADN_MINTEGRAL : str.equalsIgnoreCase(MediationConstant.ADN_UNITY) ? MediationConstant.ADN_UNITY : str.equalsIgnoreCase("baidu") ? "baidu" : str.equalsIgnoreCase("ks") ? "ks" : str.equalsIgnoreCase("sigmob") ? "sigmob" : str.equalsIgnoreCase(MediationConstant.ADN_KLEVIN) ? MediationConstant.ADN_KLEVIN : str.equalsIgnoreCase(MediationConstant.ADN_XIAOMI) ? MediationConstant.ADN_XIAOMI : str;
    }

    public static String hf(int i) {
        switch (i) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                return "Native";
            case 6:
            default:
                return "UnKnow";
            case 7:
                return "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                return "InterstitialFull";
        }
    }

    public static String xj(int i) {
        if (i == 3) {
            return "gdt";
        }
        if (i == 2) {
            return MediationConstant.ADN_ADMOB;
        }
        if (i == 1) {
            return MediationConstant.ADN_PANGLE;
        }
        if (i == 4) {
            return MediationConstant.ADN_MINTEGRAL;
        }
        if (i == 5) {
            return MediationConstant.ADN_UNITY;
        }
        if (i == 6) {
            return "baidu";
        }
        if (i == 7) {
            return "ks";
        }
        if (i == 8) {
            return "sigmob";
        }
        if (i == 9) {
            return MediationConstant.ADN_KLEVIN;
        }
        if (i == 10) {
            return MediationConstant.ADN_XIAOMI;
        }
        if (i == -1) {
            return MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
        }
        return "";
    }

    public static String xj(int i, int i2) {
        switch (i) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                if (i2 == 4) {
                    return "Native";
                }
                if (i2 == 5) {
                    return "Draw";
                }
                if (i2 == 3) {
                    return "Banner";
                }
                return "Native";
            case 6:
            default:
                return null;
            case 7:
                return (i2 != 6 && i2 == 7) ? "FullVideo" : "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                if (i2 == 1) {
                    return ExploreConstants.SCENE_INTERSTITIAL;
                }
                if (i2 == 2) {
                    return "FullVideo";
                }
                return null;
        }
    }

    public static String xj(int i, int i2, tf tfVar) {
        switch (i) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                if (i2 == 4) {
                    if (tfVar == null || tfVar.tf() != 1) {
                        return "Native-自渲染";
                    }
                    return "Native-模板渲染";
                }
                if (i2 == 5) {
                    return "NativeDraw";
                }
                if (i2 == 3) {
                    return "Banner";
                }
                return "Native-自渲染";
            case 6:
            default:
                return null;
            case 7:
                if (i2 == 6 || i2 != 7) {
                    return "Reward_RewardVideo";
                }
                return "Reward_FullVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "NativeDraw";
            case 10:
                if (i2 == 1) {
                    return "InterstitialFull—Interstitial";
                }
                if (i2 == 2) {
                    return "InterstitialFull—FullVideo";
                }
                return null;
        }
    }
}
