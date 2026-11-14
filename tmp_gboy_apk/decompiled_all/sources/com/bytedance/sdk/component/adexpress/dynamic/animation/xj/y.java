package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends u {
    public y(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    public List<ObjectAnimator> xj() {
        float f = this.w.getLayoutParams().width;
        this.w.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "translationX", f, 0.0f).setDuration((int) (this.hf.tf() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.w, "alpha", 0.0f, 1.0f).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        arrayList.add(xj(duration2));
        return arrayList;
    }
}
