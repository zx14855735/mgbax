package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl extends u {
    public pl(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> xj() {
        int i;
        int i2;
        this.w.setTag(2097610711, Integer.valueOf(this.hf.u()));
        View view = this.w;
        if (view == null || !com.bytedance.sdk.component.adexpress.u.w.xj(view.getContext())) {
            i = 0;
            i2 = 1;
        } else {
            i = 1;
            i2 = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "shineValue", i, i2).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        return arrayList;
    }
}
