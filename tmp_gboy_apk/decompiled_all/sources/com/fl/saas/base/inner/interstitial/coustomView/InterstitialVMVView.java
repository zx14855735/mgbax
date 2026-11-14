package com.fl.saas.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fl.saas.base.inner.InnerNativeAdLogo;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InterstitialVMVView implements InnerNativeCustomView, InnerNativeAdLogo {
    private final TextView CATView;
    private final ImageView adLogo;
    private final View adView;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final View textContent;
    private final TextView titleView;

    public InterstitialVMVView(Context context) {
        View inflate = ViewHelper.inflate(context, R.layout.yd_saas_interstitial_v_material_v);
        this.adView = inflate;
        this.titleView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_vertical_title);
        this.CATView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_vertical_btn);
        this.mainImageView = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_vertical_img);
        this.mediaContainer = (FrameLayout) inflate.findViewById(R.id.iv_yd_saas_custom_vertical_video);
        this.adLogo = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_vertical_adlogo);
        this.textContent = inflate.findViewById(R.id.rl_yd_saas_custom_content);
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

    @Override // com.fl.saas.base.inner.InnerNativeAdLogo
    public void setAdLogo(Bitmap bitmap) {
        this.adLogo.setImageBitmap(bitmap);
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        ViewHelper.setTextView(this.CATView, str);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, Drawable drawable) {
        if (view != null) {
            this.mediaContainer.removeAllViews();
            this.mediaContainer.addView(view, ViewHelper.getMatchParent());
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
            return this;
        }
        if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        if (!TextUtils.isEmpty(str)) {
            this.textContent.setVisibility(0);
        }
        return this;
    }
}
