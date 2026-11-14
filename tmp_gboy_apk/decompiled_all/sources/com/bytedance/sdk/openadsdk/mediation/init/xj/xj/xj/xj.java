package com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static final SparseArray<Object> xj(final IMediationConfig iMediationConfig) {
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        if (iMediationConfig == null) {
            return null;
        }
        A4TApA2.AMqCpz(264101, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return IMediationConfig.this.getPublisherDid();
            }
        });
        A4TApA2.AMqCpz(264102, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isOpenAdnTest());
            }
        });
        A4TApA2.AMqCpz(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? w.xj(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        A4TApA2.AMqCpz(264104, new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return IMediationConfig.this.getLocalExtra();
            }
        });
        A4TApA2.AMqCpz(264105, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.5
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.getHttps());
            }
        });
        A4TApA2.AMqCpz(264106, new Supplier<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.6
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public JSONObject get() {
                return IMediationConfig.this.getCustomLocalConfig();
            }
        });
        A4TApA2.AMqCpz(264107, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.7
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return IMediationConfig.this.getOpensdkVer();
            }
        });
        A4TApA2.AMqCpz(264108, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.8
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isWxInstalled());
            }
        });
        A4TApA2.AMqCpz(264109, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.9
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportH265());
            }
        });
        A4TApA2.AMqCpz(264110, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.10
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportSplashZoomout());
            }
        });
        A4TApA2.AMqCpz(264111, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.xj.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                return IMediationConfig.this.wxAppId();
            }
        });
        return A4TApA2.A2egSU().sparseArray();
    }
}
