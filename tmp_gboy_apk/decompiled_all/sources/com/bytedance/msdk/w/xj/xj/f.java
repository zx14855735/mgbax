package com.bytedance.msdk.w.xj.xj;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class f extends w {
    private boolean g;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10167pl;

    public f(com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar, Function<SparseArray<Object>, Object> function) {
        super(hfVar, function);
        this.p = 0;
        this.f10167pl = 0;
        this.g = false;
    }

    public final void hf(xj xjVar) {
        if (!this.g) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
            return;
        }
        int i = this.p;
        if (i >= 2) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        this.p = i + 1;
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void p() {
        try {
            this.g = true;
            if (((w) this).tf != null) {
                ((w) this).tf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6083).xj(Void.class).hf());
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public abstract void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar);

    public final void xj(xj xjVar) {
        int i = this.f10167pl;
        if (i >= 60) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter click方法回调次数需要小于60次");
            return;
        }
        this.f10167pl = i + 1;
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar, List<View> list4) {
        super.xj(activity, viewGroup, list, list2, list3, tfVar, list4);
        try {
            this.g = true;
            xj(activity, viewGroup, list, list2, list3, tfVar);
        } catch (Exception e) {
            pl.xj(e);
        }
    }
}
