package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends u {
    public xj(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    public List<ObjectAnimator> xj() {
        float yo = this.hf.yo() / 100.0f;
        float v = this.hf.v() / 100.0f;
        if ("reverse".equals(this.hf.zg()) && this.hf.am() <= 0.0d) {
            v = yo;
            yo = v;
        }
        this.w.setAlpha(yo);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "alpha", yo, v).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        return arrayList;
    }
}
