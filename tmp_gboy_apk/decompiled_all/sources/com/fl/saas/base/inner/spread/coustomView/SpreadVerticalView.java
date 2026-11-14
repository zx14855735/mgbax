package com.fl.saas.base.inner.spread.coustomView;

import ADYaiT.BChYOn;
import Kce6Pf.A4TApA;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SpreadVerticalView implements InnerNativeCustomView {
    private final FrameLayout adView;
    private final ImageView bgView;
    private final Context mContext;
    private final ImageView mainImageView;

    public SpreadVerticalView(Context context) {
        this.mContext = context;
        FrameLayout frameLayout = (FrameLayout) ViewHelper.inflate(context, R.layout.yd_saas_spread_material_vertical);
        this.adView = frameLayout;
        this.mainImageView = (ImageView) frameLayout.findViewById(R.id.iv_yd_saas_custom_spread_vertical_img);
        this.bgView = (ImageView) frameLayout.findViewById(R.id.yd_saas_view_background);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        this.bgView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        DeviceUtil.postUI(new BChYOn(this, 13, ImageUtils.rsBlur(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new A4TApA(this, drawable, 0));
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getCATView() {
        return null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public Consumer<Bitmap> loadIcon() {
        return null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, Drawable drawable) {
        ImageView imageView;
        int i;
        if (view != null) {
            this.adView.removeAllViews();
            this.adView.addView(view, ViewHelper.getMatchParent());
            imageView = this.mainImageView;
            i = 8;
        } else {
            if (drawable == null) {
                return this;
            }
            ImageView.ScaleType scaleType = DeviceUtil.scaleType;
            if (scaleType != null) {
                this.mainImageView.setScaleType(scaleType);
                if (drawable instanceof BitmapDrawable) {
                    this.adView.post(new A4TApA(this, drawable, 1));
                }
            }
            this.mainImageView.setImageDrawable(drawable);
            imageView = this.mainImageView;
            i = 0;
        }
        imageView.setVisibility(i);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        return this;
    }
}
