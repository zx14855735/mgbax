package com.fl.saas.base.inner.interstitial.coustomView;

import ADYaiT.BChYOn;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InterstitialVMHView implements InnerNativeCustomView {
    private final TextView CATView;
    private final View adView;
    private final ImageView bgView;
    private final TextView desView;
    private final ImageView logoIcon;
    private final Context mContext;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialVMHView(Context context) {
        this.mContext = context;
        View inflate = ViewHelper.inflate(context, R.layout.yd_saas_interstitial_v_material_h);
        this.adView = inflate;
        this.bgView = (ImageView) inflate.findViewById(R.id.yd_saas_view_background);
        this.logoIcon = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_interstitia_icon);
        this.mediaContainer = (FrameLayout) inflate.findViewById(R.id.yd_saas_custom_interstitial_media_container);
        this.mainImageView = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_interstitial);
        this.titleView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_interstitia_title);
        this.desView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_interstitia_desc);
        this.CATView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_interstitia_btn);
        ImageLoader.loadImageDrawable(CommConstant.ImageUrl.CUSTOM_SPREAD_BG, new Kce6Pf.A2egSU(14, inflate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$3(Bitmap bitmap) {
        this.logoIcon.setVisibility(0);
        this.logoIcon.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        if (this.mediaContainer.getVisibility() == 0) {
            this.mainImageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        DeviceUtil.postUI(new BChYOn(this, 23, ImageUtils.rsBlur(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new A2egSU(this, drawable, 0));
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
        return new Kce6Pf.A2egSU(13, this);
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
        this.bgView.setVisibility(drawable == null ? 8 : 0);
        if (view == null) {
            if (drawable != null) {
                this.mainImageView.setImageDrawable(drawable);
                this.mediaContainer.setVisibility(8);
                this.mainImageView.setVisibility(0);
                if (drawable instanceof BitmapDrawable) {
                    this.bgView.post(new A2egSU(this, drawable, 1));
                }
            }
            return this;
        }
        this.mediaContainer.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (drawable != null) {
            layoutParams.height = Math.round(((((Integer) InterstitialViewHelper.getInterstitialSize().f1610A2egSU).intValue() - (DeviceUtil.dip2px(15.0f) * 2)) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
        } else {
            this.mainImageView.setVisibility(8);
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
