package com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static final SparseArray<Object> xj(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        A4TApA2.AMqCpz(262114, new Supplier<List<String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.hf.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return IMediationPrivacyConfig.this.getCustomAppList();
            }
        });
        A4TApA2.AMqCpz(262115, new Supplier<List<String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.hf.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return IMediationPrivacyConfig.this.getCustomDevImeis();
            }
        });
        A4TApA2.AMqCpz(262116, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.hf.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isCanUseOaid());
            }
        });
        A4TApA2.AMqCpz(262117, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.hf.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isLimitPersonalAds());
            }
        });
        A4TApA2.AMqCpz(262118, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.hf.5
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isProgrammaticRecommend());
            }
        });
        return A4TApA2.A2egSU().sparseArray();
    }
}
