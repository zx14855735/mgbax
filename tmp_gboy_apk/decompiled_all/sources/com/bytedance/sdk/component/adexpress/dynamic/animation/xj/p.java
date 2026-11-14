package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p extends u {
    public p(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    public List<ObjectAnimator> xj() {
        float f;
        float p = (float) this.hf.p();
        float pl2 = (float) this.hf.pl();
        String zg = this.hf.zg();
        float f2 = 1.0f;
        if ("reverse".equals(zg) || "alternate-reverse".equals(zg)) {
            f = 1.0f;
        } else {
            f2 = p;
            f = pl2;
            p = 1.0f;
            pl2 = 1.0f;
        }
        this.w.setTag(2097610710, this.hf.hf());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "scaleX", p, f2).setDuration((int) (this.hf.tf() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.w, "scaleY", pl2, f).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        arrayList.add(xj(duration2));
        return arrayList;
    }
}
