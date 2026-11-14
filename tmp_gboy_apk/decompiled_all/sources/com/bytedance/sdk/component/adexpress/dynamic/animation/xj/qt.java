package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt extends u {
    public qt(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    public List<ObjectAnimator> xj() {
        float f;
        float xj = com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.hf.y());
        float xj2 = com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), this.hf.c());
        float f2 = 0.0f;
        if ("reverse".equals(this.hf.zg())) {
            f2 = xj;
            f = xj2;
            xj = 0.0f;
            xj2 = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.u.w.xj(this.w.getContext())) {
            xj = -xj;
            f2 = -f2;
        }
        this.w.setTranslationX(xj);
        this.w.setTranslationY(xj2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "translationX", xj, f2).setDuration((int) (this.hf.tf() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.w, "translationY", xj2, f).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        arrayList.add(xj(duration2));
        return arrayList;
    }
}
