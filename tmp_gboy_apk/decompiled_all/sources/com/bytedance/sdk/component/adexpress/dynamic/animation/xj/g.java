package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g extends u {
    public g(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    public List<ObjectAnimator> xj() {
        View view = this.w;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicImageView)) {
            View view2 = (View) this.w.getParent();
            this.w = view2;
            ((ViewGroup) view2).setClipChildren(true);
            ((ViewGroup) this.w.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        return arrayList;
    }
}
