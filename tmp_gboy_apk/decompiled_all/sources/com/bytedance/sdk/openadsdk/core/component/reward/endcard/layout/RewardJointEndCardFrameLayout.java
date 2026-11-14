package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.xj.w.y;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.f.hf;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.x.c;
import com.sigmob.sdk.base.blurkit.d;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements y {
    private RewardJointBottomView kd;
    private View u;
    private FrameLayout w;
    private FrameLayout y;

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
    }

    private boolean u() {
        if (this.hf.rx() == 15) {
            return true;
        }
        if (this.hf.rx() == 5) {
            return false;
        }
        if (this.hf.lx() == null || this.hf.lx().isEmpty()) {
            return true;
        }
        z zVar = this.hf.lx().get(0);
        return zVar.w() > zVar.hf();
    }

    private void w() {
        if (ws.hf(this.hf)) {
            hf.xj(h.hf(this.hf)).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(RewardJointEndCardFrameLayout.this.getContext(), zgVar.getResult(), 25);
                    if (xj == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), xj);
                    c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.y != null) {
                                RewardJointEndCardFrameLayout.this.y.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        } else {
            hf.xj(this.hf.lx().get(0)).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(RewardJointEndCardFrameLayout.this.getContext(), zgVar.getResult(), 25);
                    if (xj == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), xj);
                    c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.w != null) {
                                RewardJointEndCardFrameLayout.this.w.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.kd.getWebView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.y;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.bytedance.sdk.component.widget.recycler.xj.w.kd
    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        r.xj(this.u, (View.OnClickListener) hfVar, "bar_view");
        this.kd.setClickListener(hfVar);
    }

    private void hf(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(r.w(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(r.w(getContext(), 40.0f), r.w(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setGravity(16);
        textView.setMaxWidth(r.w(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(d.f13043a);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, r.w(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(truncateAt);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(r.w(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(r.w(getContext(), 70.0f), r.w(getContext(), 24.0f));
        layoutParams2.setMarginEnd(r.w(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, r.w(getContext(), 60.0f)));
        this.u = linearLayout;
        z uf = this.hf.uf();
        if (uf == null || TextUtils.isEmpty(uf.xj())) {
            jk.xj(getContext(), "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
        } else {
            hf.xj(uf).to(tTRoundRectImageView);
        }
        if (this.hf.vh() == null || TextUtils.isEmpty(this.hf.vh().w())) {
            textView.setText(this.hf.ci());
        } else {
            textView.setText(this.hf.vh().w());
        }
        textView2.setText(this.hf.kr());
        textView3.setText(this.hf.bh());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void xj() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        xj(linearLayout);
        hf(linearLayout);
        w(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext(), this.hf);
        this.kd = rewardJointBottomView;
        if (u()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, r.w(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.xj(ht.xj(this.hf));
    }

    private void xj(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.w = frameLayout;
        if (u()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, r.w(getContext(), 200.0f)));
        }
        w();
        if (!ws.hf(this.hf)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            hf.xj(this.hf.lx().get(0)).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.1
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    imageView.setImageBitmap(zgVar.getResult());
                }
            });
        } else {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.y = frameLayout2;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.xj.w.y
    public boolean xj(View view, View view2, int i, int i2) {
        return u();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.xj.w.y
    public void xj(View view, int i, int i2, int[] iArr, int i3) {
        int xj = xj(i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kd.getLayoutParams();
        layoutParams.height -= xj;
        this.kd.setLayoutParams(layoutParams);
        if (xj != 0) {
            this.xj.dc().tj();
        }
        iArr[1] = iArr[1] + xj;
    }

    private int xj(int i) {
        if (i > 0) {
            int height = this.kd.getHeight() - r.w(getContext(), 200.0f);
            if (height > 0) {
                if (height < Math.abs(i)) {
                    i = height;
                }
            }
            i = 0;
        } else {
            int height2 = this.w.getHeight() - r.w(getContext(), 160.0f);
            if (height2 > 0) {
                if (height2 < Math.abs(i)) {
                    i = -height2;
                }
            }
            i = 0;
        }
        if (Math.abs(i) > 400) {
            return 0;
        }
        return i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void hf() {
        super.hf();
        RewardJointBottomView rewardJointBottomView = this.kd;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.hf();
        }
    }
}
