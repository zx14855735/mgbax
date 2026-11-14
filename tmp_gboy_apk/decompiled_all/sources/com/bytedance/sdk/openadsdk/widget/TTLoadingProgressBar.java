package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTLoadingProgressBar extends LinearLayout {
    private ImageView hf;
    private View w;
    private View xj;

    private int xj(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public View getProgressBar() {
        return this.xj;
    }

    public ImageView getProgressIcon() {
        return this.hf;
    }

    public void setProgress(int i) {
        if (this.hf.getVisibility() == 0 && i > 3) {
            ((LinearLayout.LayoutParams) this.hf.getLayoutParams()).leftMargin = xj(this.xj.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.xj.getLayoutParams();
        float f = i / 100.0f;
        layoutParams.weight = f;
        this.xj.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.w.getLayoutParams();
        layoutParams2.weight = 1.0f - f;
        this.w.setLayoutParams(layoutParams2);
        requestLayout();
    }
}
