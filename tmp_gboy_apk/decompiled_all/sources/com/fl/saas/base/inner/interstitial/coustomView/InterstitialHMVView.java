package com.fl.saas.base.inner.interstitial.coustomView;

import ADYaiT.BChYOn;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.base.innterNative.BindActionView;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InterstitialHMVView implements InnerNativeCustomView, BindActionView {
    private final TextView CATView;
    private final View adView;
    private final TextView desView;
    private final ImageView logoIcon;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialHMVView(Context context) {
        View inflate = ViewHelper.inflate(context, R.layout.yd_saas_interstitial_h_material_v);
        this.adView = inflate;
        this.mainImageView = (ImageView) inflate.findViewById(R.id.yd_saas_interstitial_img);
        this.logoIcon = (ImageView) inflate.findViewById(R.id.iv_yd_saas_interstitial_icon);
        this.titleView = (TextView) inflate.findViewById(R.id.tv_yd_saas_interstitial_title);
        this.desView = (TextView) inflate.findViewById(R.id.tv_yd_saas_interstitial_des);
        this.CATView = (TextView) inflate.findViewById(R.id.tv_yd_saas_interstitial_cta);
        this.mediaContainer = (FrameLayout) inflate.findViewById(R.id.yd_saas_interstitial_media_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindActionView$2(View view) {
        FrameLayout.LayoutParams layoutParams;
        int width = this.mainImageView.getWidth();
        int height = this.mainImageView.getHeight();
        if (width <= 0 || height <= 0) {
            view.setScaleY(0.8f);
            view.setScaleX(0.8f);
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            layoutParams.setMargins(0, 0, 0, DeviceUtil.dip2px(20.0f));
        } else {
            int[] selfMeasure = ViewHelper.selfMeasure(view);
            int i = selfMeasure[0];
            int i2 = selfMeasure[1];
            int dip2px = DeviceUtil.dip2px(10.0f);
            int min = Math.min(width - (dip2px * 6), Math.round((width * 5) / 8.0f));
            int i3 = height - (dip2px * 10);
            if (min < i || i3 < i2) {
                float f = i2;
                view.setPivotY(f);
                float f2 = i;
                view.setPivotX(f2 / 2.0f);
                float min2 = Math.min(min / f2, i3 / f);
                view.setScaleY(min2);
                view.setScaleX(min2);
            }
            layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.gravity = 81;
            layoutParams.setMargins(0, 0, 0, dip2px * 2);
        }
        ((FrameLayout) this.adView.findViewById(R.id.yd_saas_interstitial_container)).addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$1(Bitmap bitmap) {
        this.logoIcon.setVisibility(0);
        this.logoIcon.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Drawable drawable) {
        ImageUtils.setBlurImage(this.mainImageView, drawable);
    }

    @Override // com.fl.saas.base.innterNative.BindActionView
    public void bindActionView(View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        this.mainImageView.post(new BChYOn(this, 21, view));
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
        return new Kce6Pf.A2egSU(12, this);
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
            layoutParams.height = Math.round((Math.round((((Integer) InterstitialViewHelper.getInterstitialSize().f1610A2egSU).intValue() * 5) / 9) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            this.mediaContainer.post(new BChYOn(this, 22, drawable));
        } else {
            this.mainImageView.setVisibility(8);
        }
        this.mediaContainer.addView(view, layoutParams);
        this.mediaContainer.setVisibility(0);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
