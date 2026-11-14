package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.renderview.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTLottieVideoContainer extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.hf {
    private hf.xj xj;

    public TTLottieVideoContainer(Context context) {
        super(context);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(hf.xj xjVar) {
        this.xj = xjVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public void xj(com.bykv.vk.openvk.component.video.api.renderview.xj xjVar) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public void xj(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
