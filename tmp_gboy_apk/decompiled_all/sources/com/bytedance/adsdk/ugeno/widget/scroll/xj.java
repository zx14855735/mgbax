package com.bytedance.adsdk.ugeno.widget.scroll;

import android.content.Context;
import android.widget.ScrollView;
import com.bytedance.adsdk.ugeno.hf.xj;
import com.bytedance.adsdk.ugeno.widget.frame.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.adsdk.ugeno.hf.xj<ScrollView> {
    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public xj.C0026xj f() {
        return new xj.C0030xj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: tu, reason: merged with bridge method [inline-methods] */
    public ScrollView xj() {
        UGScrollView uGScrollView = new UGScrollView(this.hf);
        uGScrollView.xj(this);
        return uGScrollView;
    }
}
