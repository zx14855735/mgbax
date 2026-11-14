package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.xj.w.u;
import com.bytedance.sdk.component.widget.recycler.xj.w.w;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardJointBottomView extends FrameLayout implements w {
    private View.OnClickListener c;
    private boolean d;
    private boolean f;
    private int[] hf;
    private u kd;
    private final SlideUpLoadMoreArrow tf;
    private SSWebView u;
    private int[] w;
    private float xj;
    private int y;

    public RewardJointBottomView(Context context, ws wsVar) {
        super(context);
        this.hf = new int[2];
        this.w = new int[2];
        this.y = 0;
        this.f = false;
        this.d = false;
        SSWebView sSWebView = new SSWebView(context);
        this.u = sSWebView;
        sSWebView.setMaterialMeta(ff.xj(wsVar));
        this.u.setWebViewClient(null);
        addView(this.u, new ViewGroup.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 23) {
            this.u.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (Math.abs((RewardJointBottomView.this.u.getWebView().getScrollY() + RewardJointBottomView.this.u.getWebView().getHeight()) - (RewardJointBottomView.this.u.getWebView().getScale() * RewardJointBottomView.this.u.getWebView().getContentHeight())) >= 10.0f) {
                        RewardJointBottomView.this.f = false;
                    } else {
                        if (RewardJointBottomView.this.f) {
                            return;
                        }
                        RewardJointBottomView.this.f = true;
                    }
                }
            });
        }
        getScrollingChildHelper().xj(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.tf = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.xj();
    }

    private u getScrollingChildHelper() {
        if (this.kd == null) {
            this.kd = new u(this);
        }
        return this.kd;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return super.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return super.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = 0;
            this.xj = motionEvent.getY();
            xj(2, 0);
            this.d = this.f;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.xj;
                if (y < 0.0f) {
                    xj();
                    if (xj(0, (int) y, this.hf, this.w, 0)) {
                        y -= this.hf[1];
                    }
                    this.y += xj((int) ((Math.floor((double) Math.abs(y)) != 0.0d ? y : 0.0f) - this.y));
                } else {
                    int i = (int) (y - this.y);
                    int xj = xj(i);
                    this.y += xj;
                    xj(0, i - xj, this.hf, this.w, 0);
                }
            }
        } else if (this.d && this.xj - motionEvent.getY() > 100.0f && (onClickListener = this.c) != null) {
            onClickListener.onClick(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public SSWebView getWebView() {
        return this.u;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void hf() {
        xj();
    }

    public void xj(String str) {
        this.u.loadUrl(str);
    }

    public boolean xj(int i, int i2) {
        return getScrollingChildHelper().hf(0);
    }

    public boolean xj(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().xj(i, i2, iArr, iArr2, i3);
    }

    public int xj(int i) {
        if (i < 0) {
            return (int) (-Math.abs(Math.min(this.u.getWebView().getContentHeight() - (this.u.getWebView().getScrollY() + this.u.getWebView().getHeight()), -i)));
        }
        if (i > 0) {
            return Math.min(this.u.getWebView().getScrollY(), i);
        }
        return 0;
    }

    public void xj() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.tf;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.tf.hf();
        }
    }
}
