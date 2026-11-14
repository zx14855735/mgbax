package com.bytedance.sdk.openadsdk.zg.xj.w;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static SparseArray<Object> xj(final AdConfig adConfig) {
        if (adConfig == null) {
            return new SparseArray<>();
        }
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        A4TApA2.ARc23Z(261001, adConfig.getAppId());
        A4TApA2.ARc23Z(261002, adConfig.getAppName());
        A4TApA2.ASJ6gh(261003, adConfig.isPaid());
        A4TApA2.ARc23Z(261004, adConfig.getKeywords());
        A4TApA2.ARc23Z(261005, adConfig.getData());
        A4TApA2.ADYaiT(261006, adConfig.getTitleBarTheme());
        A4TApA2.ASJ6gh(261007, adConfig.isAllowShowNotify());
        A4TApA2.ASJ6gh(261008, adConfig.isDebug());
        A4TApA2.AMqCpz(261009, adConfig.getDirectDownloadNetworkType());
        A4TApA2.ASJ6gh(261011, adConfig.isSupportMultiProcess());
        A4TApA2.AMqCpz(261012, u.xj(adConfig.getCustomController()));
        A4TApA2.AMqCpz(261013, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.xj.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        A4TApA2.AMqCpz(261014, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.xj.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        A4TApA2.AMqCpz(261015, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.xj.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        A4TApA2.AMqCpz(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.xj(adConfig.getMediationConfig()) : null);
        A4TApA2.ASJ6gh(261017, adConfig.isUseMediation());
        A4TApA2.AMqCpz(261018, new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.xj.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return AdConfig.this.getInitExtra();
            }
        });
        return A4TApA2.A2egSU().sparseArray();
    }
}
