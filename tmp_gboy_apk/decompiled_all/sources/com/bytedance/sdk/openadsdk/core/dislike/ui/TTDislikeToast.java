package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTDislikeToast extends FrameLayout {
    private TextView hf;
    private Handler xj;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public void hf() {
        try {
            xj(jk.xj(getContext(), "tt_dislike_feedback_repeat"));
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public void w() {
        setVisibility(8);
        this.xj.removeCallbacksAndMessages(null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void xj(Context context) {
        TextView textView = new TextView(context);
        this.hf = textView;
        textView.setClickable(false);
        this.hf.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int xj = com.bytedance.sdk.openadsdk.core.dislike.xj.xj.hf().xj(getContext(), 20.0f);
        int xj2 = com.bytedance.sdk.openadsdk.core.dislike.xj.xj.hf().xj(getContext(), 12.0f);
        this.hf.setPadding(xj, xj2, xj, xj2);
        this.hf.setLayoutParams(layoutParams);
        this.hf.setTextColor(-1);
        this.hf.setTextSize(16.0f);
        this.hf.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.xj.xj.hf().xj(getContext(), 6.0f));
        this.hf.setBackgroundDrawable(gradientDrawable);
        addView(this.hf);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xj = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        xj(context);
    }

    public void xj(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.xj.removeCallbacksAndMessages(null);
        this.xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.hf != null) {
                    TTDislikeToast.this.hf.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.xj.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void xj() {
        xj(jk.xj(getContext(), "tt_dislike_feedback_success"));
    }
}
