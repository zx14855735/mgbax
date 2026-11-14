package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.animation.ObjectAnimator;
import android.view.View;
import com.sigmob.sdk.base.common.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am extends u {
    public am(View view, com.bytedance.sdk.component.adexpress.dynamic.w.xj xjVar) {
        super(view, xjVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.xj.u
    public List<ObjectAnimator> xj() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.w, a.B, 0.0f, this.hf.kd(), 0.0f, this.hf.kd(), 0.0f).setDuration((int) (this.hf.tf() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj(duration));
        return arrayList;
    }
}
