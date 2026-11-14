package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.adexpress.dynamic.w.tf;
import com.bytedance.sdk.component.utils.ht;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class WriggleGuideAnimationView extends LinearLayout {
    private LottieAnimationView c;
    private boolean d;
    private tf f;
    private TextView hf;
    private xj kd;
    private TextView u;
    private ht w;
    public int xj;
    private LinearLayout y;

    public interface xj {
        void xj();
    }

    public WriggleGuideAnimationView(Context context, View view, tf tfVar, boolean z, int i) {
        super(context);
        this.f = tfVar;
        this.d = z;
        this.xj = i;
        xj(context, view);
    }

    public TextView getTopTextView() {
        return this.hf;
    }

    public LinearLayout getWriggleLayout() {
        return this.y;
    }

    public View getWriggleProgressIv() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.w == null) {
                this.w = new ht(getContext().getApplicationContext(), 2, this.d);
            }
            this.w.xj(new ht.xj() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.2
                @Override // com.bytedance.sdk.component.utils.ht.xj
                public void xj(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.kd != null) {
                        WriggleGuideAnimationView.this.kd.xj();
                    }
                }
            });
            if (this.f != null) {
                this.w.hf(r0.w());
                this.w.y(this.f.kd());
                this.w.xj(this.f.y());
                this.w.hf(this.f.f());
            }
            this.w.xj(this.xj);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ht htVar = this.w;
        if (htVar != null) {
            htVar.hf(this.xj);
        }
        try {
            LottieAnimationView lottieAnimationView = this.c;
            if (lottieAnimationView != null) {
                lottieAnimationView.y();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ht htVar = this.w;
        if (htVar != null) {
            if (z) {
                htVar.xj(this.xj);
            } else {
                htVar.hf(this.xj);
            }
        }
    }

    public void setOnShakeViewListener(xj xjVar) {
        this.kd = xjVar;
    }

    public void setShakeText(String str) {
        this.u.setText(str);
    }

    private void xj(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.y = (LinearLayout) findViewById(2097610722);
        this.hf = (TextView) findViewById(2097610719);
        this.u = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.c = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.c.setImageAssetsFolder("images/");
        this.c.xj(true);
    }

    public void xj() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.c.xj();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }
}
