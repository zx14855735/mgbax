package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends u {
    public c(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> xj() {
        this.w.setTag(2097610709, Integer.valueOf(this.hf.w()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        return arrayList;
    }
}
