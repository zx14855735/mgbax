package com.bytedance.msdk.w.xj.xj;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class w extends com.bytedance.msdk.hf.w {
    protected com.bytedance.msdk.w.w.hf.xj.xj.hf d;
    protected Function<SparseArray<Object>, Object> tf;

    public w(com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar, Function<SparseArray<Object>, Object> function) {
        this.d = hfVar;
        this.tf = function;
    }

    @Override // com.bytedance.msdk.hf.w
    public void e() {
        super.e();
        com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar = this.d;
        if (hfVar != null) {
            hfVar.pl();
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf(Map<String, Object> map) {
        xj(true, da(), -1, null);
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean kd() {
        return false;
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Map<String, Object> map) {
        int i;
        if (map == null) {
            return;
        }
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            i = intValue > 0 ? intValue : 10001;
        } catch (Exception unused) {
            i = 10001;
        }
        xj(false, -1.0d, i, null);
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar = this.d;
        return hfVar != null ? hfVar.tf() : super.y();
    }

    @Override // com.bytedance.msdk.hf.w
    public void yo() {
        super.yo();
        com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar = this.d;
        if (hfVar != null) {
            hfVar.g();
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void zg() {
        super.zg();
        com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar = this.d;
        if (hfVar != null) {
            hfVar.p();
        }
    }

    public void xj(boolean z, double d, int i, Map<String, Object> map) {
        com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar = this.d;
        if (hfVar != null) {
            hfVar.xj(z, d, i, map);
        }
    }
}
