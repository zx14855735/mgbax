package com.fl.saas.base.inner.interstitial.coustomView;

import ADYaiT.BChYOn;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.base.innterNative.BindActionView;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InterstitialHMHView implements InnerNativeCustomView, BindActionView {
    private final TextView CATView;
    private final RelativeLayout adView;
    private final TextView desView;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialHMHView(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) ViewHelper.inflate(context, R.layout.yd_saas_interstitial_h_material_h);
        this.adView = relativeLayout;
        this.mainImageView = (ImageView) relativeLayout.findViewById(R.id.yd_saas_interstitial_img);
        this.mediaContainer = (FrameLayout) relativeLayout.findViewById(R.id.yd_saas_interstitial_media_container);
        this.titleView = (TextView) relativeLayout.findViewById(R.id.tv_yd_saas_interstitial_title);
        this.desView = (TextView) relativeLayout.findViewById(R.id.tv_yd_saas_interstitial_des);
        this.CATView = (TextView) relativeLayout.findViewById(R.id.tv_yd_saas_interstitial_cta);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindActionView$0(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int width = this.mainImageView.getWidth();
        int height = this.mainImageView.getHeight();
        if (width <= 0 || height <= 0) {
            view.setScaleY(0.8f);
            view.setScaleX(0.8f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            marginLayoutParams = layoutParams;
        } else {
            int[] selfMeasure = ViewHelper.selfMeasure(view);
            int i = selfMeasure[0];
            int i2 = selfMeasure[1];
            int dip2px = DeviceUtil.dip2px(10.0f);
            int i3 = width - (dip2px * 10);
            int min = Math.min(height - (dip2px * 5), Math.round(width / 3.0f));
            if (i3 < i || min < i2) {
                float f = i2;
                view.setPivotY(f);
                float f2 = i;
                view.setPivotX(f2 / 2.0f);
                float min2 = Math.min(i3 / f2, min / f);
                view.setScaleY(min2);
                view.setScaleX(min2);
            }
            ViewGroup.MarginLayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(i, i2, 6, 14);
            BTvldC2.setMargins(0, (height - dip2px) - i2, 0, 0);
            marginLayoutParams = BTvldC2;
        }
        this.adView.addView(view, marginLayoutParams);
    }

    @Override // com.fl.saas.base.innterNative.BindActionView
    public void bindActionView(View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        this.mainImageView.post(new BChYOn(this, 20, view));
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getCATView() {
        return this.CATView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public Consumer<Bitmap> loadIcon() {
        return null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        ViewHelper.setTextView(this.CATView, str);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        ViewHelper.setTextView(this.desView, str);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, Drawable drawable) {
        if (view == null) {
            if (drawable != null) {
                this.mainImageView.setImageDrawable(drawable);
                this.mediaContainer.setVisibility(8);
                this.mainImageView.setVisibility(0);
            }
            return this;
        }
        this.mediaContainer.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (drawable != null) {
            layoutParams.height = Math.round((((Integer) InterstitialViewHelper.getInterstitialSize().f1610A2egSU).intValue() * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
        }
        this.mediaContainer.addView(view, layoutParams);
        this.mediaContainer.setVisibility(0);
        this.mainImageView.setVisibility(8);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
