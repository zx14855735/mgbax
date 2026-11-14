package com.bytedance.sdk.openadsdk.core.hf.xj;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {
    protected Context hf;
    protected View u;
    protected tf w;
    protected ws xj;

    public abstract int xj(Map<String, Object> map, w wVar);

    public void xj(tf tfVar) {
        this.w = tfVar;
    }

    public void xj(View view) {
        this.u = view;
    }
}
