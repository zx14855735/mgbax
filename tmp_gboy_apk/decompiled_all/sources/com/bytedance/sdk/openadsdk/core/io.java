package com.bytedance.sdk.openadsdk.core;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class io extends com.bytedance.sdk.openadsdk.zg.w.w.u implements Serializable, Function<SparseArray<Object>, Object> {
    com.bytedance.sdk.openadsdk.zg.w.w.u xj;

    public io(com.bytedance.sdk.openadsdk.zg.w.w.u uVar) {
        super(null);
        this.xj = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public String am() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.am() : uVar.am();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public com.bytedance.sdk.openadsdk.zg.w.w.w d() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.d() : uVar.d();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public boolean f() {
        if (ai.w < 7000) {
            return true;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.f() : uVar.f();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public boolean hf() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.hf() : uVar.hf();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public boolean kd() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.kd() : uVar.kd() && com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(pz.getContext(), com.kuaishou.weapon.p0.g.j);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public String p() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.p() : uVar.p();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public String pl() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.pl() : uVar.pl();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public Map<String, Object> qt() {
        if (ai.w < 6408) {
            return null;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.qt() : uVar.qt();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public String tf() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.tf() : uVar.tf();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public boolean u() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.u() : uVar.u() && com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(pz.getContext(), com.kuaishou.weapon.p0.g.d);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public boolean w() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.w() : uVar.w() && com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(pz.getContext(), com.kuaishou.weapon.p0.g.c);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public boolean xj() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.xj() && com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(pz.getContext(), com.kuaishou.weapon.p0.g.h) && com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(pz.getContext(), com.kuaishou.weapon.p0.g.g) : uVar.xj() && com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(pz.getContext(), com.kuaishou.weapon.p0.g.h) && com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(pz.getContext(), com.kuaishou.weapon.p0.g.g);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
    public boolean y() {
        com.bytedance.sdk.openadsdk.zg.w.w.u uVar = this.xj;
        return uVar == null ? super.y() : uVar.y();
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        int intValue = ((Integer) sparseArray.get(-99999987)).intValue();
        switch (intValue) {
            case 262101:
                return Boolean.valueOf(xj());
            case 262102:
                com.bytedance.sdk.openadsdk.zg.w.w.w d = d();
                if (d == null) {
                    return null;
                }
                double xj = d.xj();
                double hf = d.hf();
                AYUAbz A4TApA2 = AYUAbz.A4TApA();
                Double valueOf = Double.valueOf(xj);
                SparseArray sparseArray2 = A4TApA2.f4119A2egSU;
                sparseArray2.put(262001, valueOf);
                sparseArray2.put(262002, Double.valueOf(hf));
                return A4TApA2.A2egSU().sparseArray();
            case 262103:
                return Boolean.valueOf(hf());
            case 262104:
                return Boolean.valueOf(w());
            case 262105:
                return tf();
            case 262106:
                return Boolean.valueOf(u());
            case 262107:
                return p();
            case 262108:
                return Boolean.valueOf(kd());
            case 262109:
                return pl();
            case 262110:
                return Boolean.valueOf(y());
            case 262111:
                return Boolean.valueOf(c());
            case 262112:
                return am();
            default:
                switch (intValue) {
                    case 262119:
                        return qt();
                    case 262120:
                        return Boolean.valueOf(f());
                    default:
                        return null;
                }
        }
    }
}
