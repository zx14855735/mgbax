package com.fl.saas.base.inner.spread.coustomView;

import ADYaiT.BChYOn;
import Kce6Pf.A2egSU;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SpreadHorizontalView implements InnerNativeCustomView {
    private final TextView CATView;
    private final View adView;
    private final ImageView bgView;
    private final TextView desView;
    private final ImageView iconView;
    private final Context mContext;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final RatingBar reserveView;
    private final TextView titleView;

    public SpreadHorizontalView(Context context) {
        this.mContext = context;
        View inflate = ViewHelper.inflate(context, R.layout.yd_saas_spread_material_horizontal);
        this.adView = inflate;
        this.titleView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_spread_title);
        this.desView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_spread_desc);
        this.CATView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_spread_btn);
        this.bgView = (ImageView) inflate.findViewById(R.id.yd_saas_view_background);
        this.iconView = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_spread_icon);
        this.mainImageView = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_spread);
        this.reserveView = (RatingBar) inflate.findViewById(R.id.rb_yd_saas_custom_spread_icon_reserve);
        this.mediaContainer = (FrameLayout) inflate.findViewById(R.id.yd_saas_custom_spread_media_container);
        ImageLoader.loadImageDrawable(CommConstant.ImageUrl.CUSTOM_SPREAD_BG, new A2egSU(14, inflate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$3(Bitmap bitmap) {
        if (bitmap == null) {
            this.iconView.setVisibility(8);
            this.reserveView.setVisibility(0);
        } else {
            this.iconView.setImageBitmap(bitmap);
            this.iconView.setVisibility(0);
            this.reserveView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        this.bgView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        DeviceUtil.postUI(new BChYOn(this, 10, ImageUtils.rsBlur(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new BChYOn(this, 11, drawable));
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
        return new A2egSU(0, this);
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
        if (view != null) {
            this.mediaContainer.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (drawable != null) {
                layoutParams.height = Math.round(((DeviceUtil.getMobileWidth() - (DeviceUtil.dip2px(25.0f) * 2)) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            }
            this.mediaContainer.addView(view, layoutParams);
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
        } else if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
        }
        if (drawable instanceof BitmapDrawable) {
            this.adView.post(new BChYOn(this, 12, (BitmapDrawable) drawable));
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
