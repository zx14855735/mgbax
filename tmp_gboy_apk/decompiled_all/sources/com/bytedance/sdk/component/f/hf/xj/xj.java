package com.bytedance.sdk.component.f.hf.xj;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    public abstract List<com.bytedance.sdk.component.f.xj.hf> hf(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, List<String> list, String str);

    public abstract boolean hf(int i, String str, com.bytedance.sdk.component.f.xj.hf hfVar);

    public List<com.bytedance.sdk.component.f.xj.hf> xj(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, List<String> list, String str) {
        if (com.bytedance.sdk.component.f.hf.w.xj.xj(i)) {
            return hf(i, hfVar, z, list, str);
        }
        if (xj(hfVar)) {
            return hf(i, hfVar, z, list, str);
        }
        return null;
    }

    public abstract boolean xj(com.bytedance.sdk.component.f.xj.hf hfVar);

    public abstract boolean xj(String str);

    public boolean xj(int i, String str, com.bytedance.sdk.component.f.xj.hf hfVar) {
        if (com.bytedance.sdk.component.f.hf.w.xj.xj(i)) {
            return xj(str);
        }
        if (xj(hfVar)) {
            return hf(i, str, hfVar);
        }
        return false;
    }
}
