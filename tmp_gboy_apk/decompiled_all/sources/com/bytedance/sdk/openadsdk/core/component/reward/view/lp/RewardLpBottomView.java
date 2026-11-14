package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardLpBottomView extends LinearLayout {
    private SlideUpLoadMoreArrow hf;
    private RewardLandingPageAppInfoView w;
    private boolean xj;

    public RewardLpBottomView(Context context) {
        super(context);
        this.xj = false;
    }

    private void u() {
        if (this.w == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RewardLpBottomView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RewardLpBottomView.this.w == null) {
                    return;
                }
                int measuredHeight = RewardLpBottomView.this.w.getMeasuredHeight();
                View findViewById = RewardLpBottomView.this.getRootView().findViewById(2114387658);
                if (findViewById == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = measuredHeight;
                    findViewById.setLayoutParams(layoutParams2);
                }
            }
        });
    }

    private void w() {
        this.hf = new SlideUpLoadMoreArrow(getContext(), this.xj ? 12 : 48, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.hf, layoutParams);
    }

    public void hf() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow;
        if (getVisibility() == 0 && (slideUpLoadMoreArrow = this.hf) != null) {
            slideUpLoadMoreArrow.hf();
            this.hf.setVisibility(8);
        }
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = this.w;
        if (rewardLandingPageAppInfoView == null || onClickListener == null) {
            return;
        }
        rewardLandingPageAppInfoView.setDownLoadClickListener(onClickListener);
    }

    public void xj(ws wsVar, String str) {
        if (wsVar == null) {
            return;
        }
        this.xj = xj(wsVar);
        w();
        if (!v.w(wsVar)) {
            hf(wsVar, str);
        }
        setOrientation(1);
        setVisibility(8);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -2013265920}));
    }

    private void hf(ws wsVar, String str) {
        if (this.xj) {
            RewardLandingPageAppInfoView rewardLandingPageAppInfoView = new RewardLandingPageAppInfoView(getContext());
            this.w = rewardLandingPageAppInfoView;
            rewardLandingPageAppInfoView.xj(wsVar, str);
            addView(this.w, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private boolean xj(ws wsVar) {
        return wsVar.vw() == 4;
    }

    public void xj() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.hf;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.xj();
        }
        u();
    }
}
