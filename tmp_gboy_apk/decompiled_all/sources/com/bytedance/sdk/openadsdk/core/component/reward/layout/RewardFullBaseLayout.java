package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardFullBaseLayout extends FrameLayout {
    private int am;
    private FrameLayout c;
    private FrameLayout d;
    private int e;
    private FrameLayout f;
    private FrameLayout g;
    protected TTProgressBar hf;
    xj kd;
    private FrameLayout p;

    /* renamed from: pl, reason: collision with root package name */
    private FrameLayout f10313pl;
    private int qt;
    private FrameLayout tf;
    long u;
    float w;
    protected TTProgressBar xj;
    private FrameLayout y;
    private int zg;

    public interface xj {
        void xj();
    }

    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    private FrameLayout hf() {
        this.g = kd();
        FrameLayout kd = kd();
        this.f10313pl = kd;
        this.g.addView(kd);
        FrameLayout kd2 = kd();
        this.c = kd2;
        kd2.setVisibility(8);
        this.f10313pl.addView(this.c);
        FrameLayout kd3 = kd();
        this.f = kd3;
        kd3.setVisibility(8);
        this.f10313pl.addView(this.f);
        this.p = kd();
        return this.g;
    }

    private FrameLayout kd() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout u() {
        FrameLayout kd = kd();
        this.tf = kd;
        return kd;
    }

    private FrameLayout w() {
        FrameLayout kd = kd();
        this.d = kd;
        return kd;
    }

    public FrameLayout getEasyPlayableContainer() {
        return this.p;
    }

    public FrameLayout getEndCardFrameContainer() {
        return this.d;
    }

    public FrameLayout getExpressFrameContainer() {
        return this.f;
    }

    public FrameLayout getSceneFrame() {
        return this.f10313pl;
    }

    public FrameLayout getSceneFrameContainer() {
        return this.g;
    }

    public FrameLayout getTopFrameContainer() {
        return this.tf;
    }

    public FrameLayout getWidgetFrameContainer() {
        return this.c;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.kd == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.w = motionEvent.getY();
            this.u = System.currentTimeMillis();
        } else if (action == 1) {
            float y = motionEvent.getY();
            float f = this.w;
            if (y < f && Math.abs(y - f) > r.w(getContext(), 30.0f)) {
                this.kd.xj();
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar) {
        FrameLayout kd = kd();
        this.y = kd;
        kd.setPadding(this.am, this.qt, this.zg, this.e);
        this.y.setClipChildren(false);
        this.y.addView(hf());
        this.y.addView(w());
        this.y.addView(u());
        addView(this.y);
        this.c.addView(xjVar.d());
        this.d.addView(xjVar.tf());
        this.tf.addView(xjVar.p());
    }

    public void xj(int i) {
        if (this.xj == null) {
            this.xj = new TTProgressBar(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT, AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT);
            layoutParams.gravity = 17;
            this.xj.setLayoutParams(layoutParams);
            try {
                this.xj.setIndeterminateDrawable(jk.w(getContext(), "tt_video_loading_progress_bar"));
            } catch (Throwable unused) {
            }
            addView(this.xj);
        }
        this.xj.setVisibility(i);
    }

    public void xj(int i, TTProgressBar tTProgressBar) {
        TTProgressBar tTProgressBar2 = this.hf;
        if (tTProgressBar2 != null) {
            tTProgressBar2.setVisibility(8);
            removeView(this.hf);
        }
        if (tTProgressBar == null) {
            return;
        }
        this.hf = tTProgressBar;
        addView(tTProgressBar);
        this.hf.setVisibility(i);
    }

    public void xj(xj xjVar) {
        this.kd = xjVar;
    }

    public void xj() {
        this.kd = null;
    }

    public void xj(int i, int i2, int i3, int i4) {
        this.am = i;
        this.qt = i2;
        this.zg = i3;
        this.e = i4;
    }
}
