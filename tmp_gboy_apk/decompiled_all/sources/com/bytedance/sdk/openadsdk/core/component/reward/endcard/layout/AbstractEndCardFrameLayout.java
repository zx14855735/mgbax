package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.hf.hf;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AbstractEndCardFrameLayout extends FrameLayout {
    protected final ws hf;
    protected final TTBaseVideoActivity xj;

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity);
        this.xj = tTBaseVideoActivity;
        this.hf = wsVar;
        xj();
    }

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    public void hf() {
    }

    public abstract void setClickListener(hf hfVar);

    public abstract void xj();
}
