package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FullRewardExpressBackupView extends BackupView {
    private NativeExpressView am;
    private View g;
    private FrameLayout qt;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.xj = context;
    }

    private void hf() {
        FrameLayout frameLayout = new FrameLayout(this.xj);
        this.g = frameLayout;
        frameLayout.setId(2114387734);
        addView(this.g);
        FrameLayout frameLayout2 = (FrameLayout) this.g.findViewById(2114387734);
        this.qt = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.qt;
    }

    public void xj(ws wsVar, NativeExpressView nativeExpressView) {
        setBackgroundColor(-1);
        this.hf = wsVar;
        this.am = nativeExpressView;
        if (wo.f(wsVar) == 7) {
            this.kd = "rewarded_video";
        } else {
            this.kd = "fullscreen_interstitial_ad";
        }
        xj();
        this.am.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void xj() {
        this.y = r.w(this.xj, this.am.getExpectExpressWidth());
        this.c = r.w(this.xj, this.am.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.y, this.c);
        }
        layoutParams.width = this.y;
        layoutParams.height = this.c;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void xj(View view, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
        NativeExpressView nativeExpressView = this.am;
        if (nativeExpressView != null) {
            nativeExpressView.xj(view, i, raVar);
        }
    }
}
