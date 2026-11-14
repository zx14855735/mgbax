package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class UGTimerContainer extends FrameLayout {
    private com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xj;

    public UGTimerContainer(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xjVar = this.xj;
        if (xjVar != null) {
            if (i == 0) {
                xjVar.xj();
            } else {
                xjVar.hf();
            }
        }
    }

    public void setTimerHolder(com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xjVar) {
        this.xj = xjVar;
    }
}
