package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.hf;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, hf {
    private hf.xj hf;
    private xj xj;

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            pl.xj(th);
            if (com.bykv.vk.openvk.component.video.api.y.w.hf()) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TextureView", "rethrow exception for debug & local_test, (TextureView)", th);
            }
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TextureView", "onSurfaceTextureAvailable: ");
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TextureView", "onSurfaceTextureDestroyed: ");
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.xj(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TextureView", "onSurfaceTextureSizeChanged: ");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(hf.xj xjVar) {
        this.hf = xjVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public void xj(xj xjVar) {
        this.xj = xjVar;
        setSurfaceTextureListener(this);
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public void xj(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
