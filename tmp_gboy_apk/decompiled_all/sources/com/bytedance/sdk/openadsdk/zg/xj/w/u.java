package com.bytedance.sdk.openadsdk.zg.xj.w;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    public static final SparseArray<Object> xj(final TTCustomController tTCustomController) {
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        A4TApA2.AMqCpz(262101, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.1
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseLocation());
            }
        });
        A4TApA2.AMqCpz(262102, new Supplier<SparseArray<Object>>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.8
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public SparseArray<Object> get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return w.xj(tTCustomController2 == null ? null : tTCustomController2.getTTLocation());
            }
        });
        A4TApA2.AMqCpz(262103, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.9
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.alist());
            }
        });
        A4TApA2.AMqCpz(262104, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.10
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePhoneState());
            }
        });
        A4TApA2.AMqCpz(262105, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.11
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevImei();
            }
        });
        A4TApA2.AMqCpz(262106, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.12
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWifiState());
            }
        });
        A4TApA2.AMqCpz(262107, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.13
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getMacAddress();
            }
        });
        A4TApA2.AMqCpz(262108, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.14
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWriteExternal());
            }
        });
        A4TApA2.AMqCpz(262109, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.15
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevOaid();
            }
        });
        A4TApA2.AMqCpz(262110, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.2
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseAndroidId());
            }
        });
        A4TApA2.AMqCpz(262113, (tTCustomController == null || tTCustomController.getMediationPrivacyConfig() == null) ? null : com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.hf.xj(tTCustomController.getMediationPrivacyConfig()));
        A4TApA2.AMqCpz(262112, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.3
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getAndroidId();
            }
        });
        A4TApA2.AMqCpz(262111, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.4
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePermissionRecordAudio());
            }
        });
        A4TApA2.AMqCpz(262119, new Supplier<Map>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.5
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Map get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.userPrivacyConfig();
            }
        });
        A4TApA2.AMqCpz(262120, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.6
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = TTCustomController.this;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseMessage());
            }
        });
        A4TApA2.AMqCpz(262121, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.zg.xj.w.u.7
            @Override // java.util.function.Supplier
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this == null);
            }
        });
        return A4TApA2.A2egSU().sparseArray();
    }
}
