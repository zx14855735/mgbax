package com.bytedance.msdk.core.xj.xj;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ra.yo;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements y {
    private String hf;
    private Function<SparseArray<Object>, Object> xj;

    @Override // com.bytedance.msdk.core.xj.xj.y
    public String c() {
        return this.hf;
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public String f() {
        return "ks";
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public Function<SparseArray<Object>, Object> hf() {
        return kd.hf("ks");
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public String kd() {
        return f.zg().l();
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public String u() {
        return "k_adn_version";
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public String w() {
        return "k_class_name";
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public boolean xj() {
        return yo.hf();
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public Function<SparseArray<Object>, Object> y() {
        return this.xj;
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public void xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function;
    }

    @Override // com.bytedance.msdk.core.xj.xj.y
    public void xj(String str) {
        this.hf = str;
    }
}
