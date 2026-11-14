package com.fl.saas.base.widget;

import android.content.Context;
import android.widget.RelativeLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FlowView extends RelativeLayout {
    private RenderListener mRenderListener;

    public FlowView(Context context) {
        super(context);
    }

    public void render() {
        this.mRenderListener.render();
    }

    public void setRenderListener(RenderListener renderListener) {
        this.mRenderListener = renderListener;
    }
}
