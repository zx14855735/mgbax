package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.ra.j;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import com.bytedance.sdk.openadsdk.core.zg.u;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FullSwiperView extends FrameLayout {
    private boolean am;
    private boolean c;
    private List<Integer> d;
    private List<Integer> f;
    private boolean g;
    private List<xj> hf;
    private float kd;
    private List<FullSwiperItemView> p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10317pl;
    private AtomicBoolean qt;
    private List<Long> tf;
    private float u;
    private TTBaseVideoActivity w;
    private BaseSwiper<ViewGroup> xj;
    private String y;

    public FullSwiperView(TTBaseVideoActivity tTBaseVideoActivity) {
        super(tTBaseVideoActivity);
        this.c = false;
        this.g = true;
        this.am = true;
        this.qt = new AtomicBoolean(false);
        this.w = tTBaseVideoActivity;
        this.f = new ArrayList();
        this.d = new ArrayList();
        this.tf = new ArrayList();
        this.xj = new SwiperView(tTBaseVideoActivity);
        this.p = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.xj, layoutParams);
    }

    public int getCurrentPosition() {
        return this.f10317pl;
    }

    public void c() {
        BaseSwiper<ViewGroup> baseSwiper = this.xj;
        if (baseSwiper != null) {
            baseSwiper.tf(this.f10317pl + 1);
        }
    }

    public void kd() {
        for (FullSwiperItemView fullSwiperItemView : this.p) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.v();
            }
        }
    }

    public void u() {
        y();
    }

    public void y() {
        BaseSwiper<ViewGroup> baseSwiper = this.xj;
        if (baseSwiper != null) {
            baseSwiper.y();
        }
    }

    public void w() {
        FullSwiperItemView w = w(this.f10317pl);
        if (w != null) {
            w.e();
        }
        if (this.f10317pl == this.p.size() - 1) {
            return;
        }
        this.xj.tf(this.f10317pl);
        List<Integer> list = this.d;
        if (list == null || this.f10317pl >= list.size()) {
            return;
        }
        if (!this.g && (!this.qt.get() || j.am() == 1)) {
            xj(this.d.get(this.f10317pl).intValue());
        }
        this.g = false;
    }

    public FullSwiperView hf(float f) {
        this.kd = f;
        return this;
    }

    public FullSwiperView xj(List<xj> list) {
        this.hf = list;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(int i) {
        FullSwiperItemView w = w(i);
        if (w != null) {
            w.am();
        }
    }

    public FullSwiperView xj(float f) {
        this.u = f;
        return this;
    }

    public FullSwiperView xj(String str) {
        this.y = str;
        return this;
    }

    public void hf() {
        FullSwiperItemView w = w(this.f10317pl);
        if (w != null) {
            w.zg();
        }
        List<Long> list = this.tf;
        if (list != null && this.f10317pl < list.size()) {
            this.d.add(this.f10317pl, Integer.valueOf(this.f.get(this.f10317pl).intValue() - ((int) (System.currentTimeMillis() - this.tf.get(this.f10317pl).longValue()))));
        }
        y();
    }

    public void xj() {
        x lq;
        List<xj> list = this.hf;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.xj.xj(false).xj("dot").u(false).w(false).hf(false);
        this.xj.setOnPageChangeListener(new com.bytedance.adsdk.ugeno.swiper.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.1
            @Override // com.bytedance.adsdk.ugeno.swiper.xj
            public void xj(boolean z, int i, int i2, boolean z2, boolean z3) {
                if (FullSwiperView.this.am && i == 1) {
                    return;
                }
                FullSwiperView.this.am = false;
                FullSwiperView.this.f10317pl = i;
                FullSwiperItemView w = FullSwiperView.this.w(i);
                if (w != null && FullSwiperView.this.f10317pl != 0) {
                    w.hf(false);
                }
                FullSwiperItemView w2 = FullSwiperView.this.w(i - 1);
                if (w2 != null) {
                    w2.zg();
                    w2.yo();
                }
                FullSwiperView.this.hf(i + 1);
                if (!FullSwiperView.this.c && i > 0) {
                    FullSwiperView.this.c = true;
                    u.hf(FullSwiperView.this.y);
                }
                int intValue = ((Integer) FullSwiperView.this.f.get(i)).intValue();
                if (intValue > 0 && i != FullSwiperView.this.p.size() - 1) {
                    FullSwiperView.this.tf.add(i, Long.valueOf(System.currentTimeMillis()));
                    int i3 = intValue / 1000;
                    int min = Math.min(j.hf(false), i3);
                    int max = Math.max(i3 - j.hf(false), 0);
                    if (min > 0) {
                        FullSwiperView.this.qt.set(false);
                        FullSwiperView.this.w.xj(-1, min, max);
                    } else if (j.am() == 1) {
                        FullSwiperView.this.xj(intValue);
                    } else {
                        if (FullSwiperView.this.qt.get()) {
                            return;
                        }
                        FullSwiperView.this.xj(intValue);
                    }
                }
            }
        });
        for (xj xjVar : this.hf) {
            ws xj = xjVar.xj();
            if (xj != null && (lq = xj.lq()) != null) {
                this.f.add(Integer.valueOf((int) lq.hf()));
                this.d.add(0);
                this.tf.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.w, xjVar, this.u, this.kd);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.2
                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.xj
                    public void xj() {
                        if (j.am() == 0) {
                            FullSwiperView.this.y();
                            FullSwiperView.this.w.wa();
                        }
                        FullSwiperView.this.qt.set(true);
                    }
                });
                this.xj.xj((BaseSwiper<ViewGroup>) fullSwiperItemView);
                this.p.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.p.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.hf
            public void xj(View view, float f, float f2) {
                int intValue = ((Integer) FullSwiperView.this.f.get(0)).intValue();
                if (intValue <= 0) {
                    FullSwiperView.this.xj.kd();
                } else {
                    FullSwiperView.this.tf.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.xj.kd();
                    if (FullSwiperView.this.p.size() > 1) {
                        int i = intValue / 1000;
                        int min = Math.min(j.hf(false), i);
                        int max = Math.max(i - j.hf(false), 0);
                        if (min > 0) {
                            FullSwiperView.this.w.xj(-1, min, max);
                        } else {
                            FullSwiperView.this.xj(intValue);
                        }
                    }
                }
                fullSwiperItemView2.hf(true);
                FullSwiperView.this.hf(1);
            }
        });
        fullSwiperItemView2.am();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView w(int i) {
        List<FullSwiperItemView> list = this.p;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.p.get(i);
    }

    public void xj(int i) {
        BaseSwiper<ViewGroup> baseSwiper;
        if (Math.min(j.hf(false), i / 1000) <= 0 && (baseSwiper = this.xj) != null) {
            baseSwiper.p(i);
        }
    }
}
