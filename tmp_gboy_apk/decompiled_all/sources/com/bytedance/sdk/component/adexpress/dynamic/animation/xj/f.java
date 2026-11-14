package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends u {
    public f(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> xj() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.hf.tf() * 1000.0d));
        ((ViewGroup) this.w.getParent()).setClipChildren(false);
        ((ViewGroup) this.w.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.w.getParent().getParent().getParent()).setClipChildren(false);
        this.w.setTag(2097610712, this.hf.f());
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        return arrayList;
    }
}
