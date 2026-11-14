package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ClickSlideUpView2 extends SlideUpView {
    private ImageView hf;
    private int kd;
    private ImageView u;
    private ImageView w;
    private TextView xj;
    private AnimatorSet y;

    public ClickSlideUpView2(Context context) {
        super(context);
        this.y = new AnimatorSet();
        hf(context);
    }

    private void hf(Context context) {
        addView(com.bytedance.sdk.component.adexpress.w.xj.hf(context));
        this.hf = (ImageView) findViewById(2097610751);
        this.w = (ImageView) findViewById(2097610750);
        this.u = (ImageView) findViewById(2097610749);
        this.xj = (TextView) findViewById(2097610748);
    }

    private void u() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(2000L);
        ofInt.setRepeatCount(-1);
        ofInt.start();
    }

    public float getAlphaColor() {
        return this.kd;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        ImageView imageView = this.u;
        int rgb = Color.rgb(i2, i2, i2);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(rgb, mode);
        int i3 = ((i + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.w.setColorFilter(Color.rgb(i3, i3, i3), mode);
        int i4 = ((i + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.hf.setColorFilter(Color.rgb(i4, i4, i4), mode);
    }

    public void setButtonText(String str) {
        if (this.xj == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.xj.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void xj(Context context) {
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void xj() {
        u();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void hf() {
        this.y.cancel();
    }
}
