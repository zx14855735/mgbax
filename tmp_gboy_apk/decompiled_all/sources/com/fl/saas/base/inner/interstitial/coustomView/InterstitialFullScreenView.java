package com.fl.saas.base.inner.interstitial.coustomView;

import ADYaiT.BChYOn;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.inner.InnerNativeAdLogo;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.innterNative.BindActionView;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Size;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InterstitialFullScreenView implements InnerNativeCustomView, InnerNativeAdLogo, BindActionView {
    private final TextView CATView;
    private final ImageView adLogo;
    private final View adView;
    private final ImageView bgView;
    private final TextView desView;
    private final FrameLayout fl_horizontal;
    private final FrameLayout fl_vertical;
    private final ImageView iv_sound_control;
    private final ImageView logoIcon;
    private final Context mContext;
    private final NativeMaterial mMaterial;
    private final ImageView mainImageView;
    private final ImageView mainImageViewVertical;
    private final FrameLayout mediaContainer;
    private final FrameLayout mediaContainerVertical;
    private final TextView titleView;

    public InterstitialFullScreenView(Context context, NativeMaterial nativeMaterial) {
        this.mContext = context;
        this.mMaterial = nativeMaterial;
        View inflate = ViewHelper.inflate(context, R.layout.yd_saas_interstitial_v_fullscreen);
        this.adView = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.yd_saas_view_background);
        this.bgView = imageView;
        this.logoIcon = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_interstitia_icon);
        this.mediaContainer = (FrameLayout) inflate.findViewById(R.id.yd_saas_custom_interstitial_media_container);
        this.mainImageView = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_interstitial);
        this.fl_horizontal = (FrameLayout) inflate.findViewById(R.id.fl_yd_saas_horizontal_container);
        this.mediaContainerVertical = (FrameLayout) inflate.findViewById(R.id.yd_saas_custom_vertical_interstitial_media_container);
        this.mainImageViewVertical = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_vertical_interstitial);
        this.fl_vertical = (FrameLayout) inflate.findViewById(R.id.fl_yd_saas_vertical_container);
        this.titleView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_interstitia_title);
        this.desView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_interstitia_desc);
        this.CATView = (TextView) inflate.findViewById(R.id.tv_yd_saas_custom_interstitia_btn);
        this.adLogo = (ImageView) inflate.findViewById(R.id.iv_yd_saas_custom_vertical_adlogo);
        this.iv_sound_control = (ImageView) inflate.findViewById(R.id.iv_yd_saas_media_sound);
        ImageLoader.loadImage(CommConstant.ImageUrl.CUSTOM_SPREAD_BG, imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$6(Bitmap bitmap) {
        ImageView imageView = this.logoIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.logoIcon.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        DeviceUtil.postUI(new BChYOn(this, 19, ImageUtils.rsBlur(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new BChYOn(this, 17, drawable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$3(int i, int i2, FrameLayout.LayoutParams layoutParams, View view) {
        layoutParams.width = (int) (this.fl_vertical.getHeight() * (i / i2));
        this.mediaContainerVertical.removeAllViews();
        this.mediaContainerVertical.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$4(boolean z) {
        this.iv_sound_control.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$5(VideoSoundControlListener videoSoundControlListener, View view) {
        boolean soundEnable = videoSoundControlListener.getSoundEnable();
        boolean z = !soundEnable;
        this.iv_sound_control.setImageResource(!soundEnable ? R.drawable.yd_saas_volume_on : R.drawable.yd_saas_volume_off);
        videoSoundControlListener.changeSoundEnable(z);
    }

    private void showHorizontalMedia(View view, Size size) {
        double d;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.fl_horizontal.setVisibility(0);
        this.fl_vertical.setVisibility(8);
        int mobileWidth = DeviceUtil.getMobileWidth();
        if (size != null) {
            int width = size.getWidth();
            int height = size.getHeight();
            if (width > 0 && height > 0) {
                d = height / width;
                layoutParams.height = (int) (mobileWidth * d);
                this.mediaContainer.removeAllViews();
                this.mediaContainer.addView(view, layoutParams);
            }
        }
        d = 0.5625d;
        layoutParams.height = (int) (mobileWidth * d);
        this.mediaContainer.removeAllViews();
        this.mediaContainer.addView(view, layoutParams);
    }

    @Override // com.fl.saas.base.innterNative.BindActionView
    public void bindActionView(View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ((RelativeLayout) this.adView.findViewById(R.id.yd_saas_interstitial_container)).addView(view, layoutParams);
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
        return new Kce6Pf.A2egSU(11, this);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdLogo
    public void setAdLogo(Bitmap bitmap) {
        ImageView imageView = this.adLogo;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fl.saas.base.inner.InnerNativeCustomView setMediaView(android.view.View r10, android.graphics.drawable.Drawable r11) {
        /*
            r9 = this;
            android.widget.ImageView r0 = r9.bgView
            if (r0 == 0) goto L15
            boolean r1 = r11 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L15
            ADYaiT.BChYOn r1 = new ADYaiT.BChYOn
            r2 = r11
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
            r3 = 18
            r1.<init>(r9, r3, r2)
            r0.post(r1)
        L15:
            r0 = 8
            r1 = 0
            if (r10 == 0) goto L9d
            com.fl.saas.api.mixNative.NativeMaterial r11 = r9.mMaterial
            if (r11 == 0) goto L65
            com.fl.saas.common.util.feature.Size r11 = r11.getSize()
            if (r11 == 0) goto L65
            com.fl.saas.api.mixNative.NativeMaterial r11 = r9.mMaterial
            com.fl.saas.common.util.feature.Size r11 = r11.getSize()
            int r4 = r11.getWidth()
            com.fl.saas.api.mixNative.NativeMaterial r11 = r9.mMaterial
            com.fl.saas.common.util.feature.Size r11 = r11.getSize()
            int r5 = r11.getHeight()
            if (r5 <= r4) goto L59
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r11 = -2
            r2 = -1
            r6.<init>(r11, r2)
            android.widget.FrameLayout r11 = r9.fl_horizontal
            r11.setVisibility(r0)
            android.widget.FrameLayout r11 = r9.fl_vertical
            r11.setVisibility(r1)
            android.widget.FrameLayout r11 = r9.fl_vertical
            FOAO9d.AMqCpz r2 = new FOAO9d.AMqCpz
            r8 = 1
            r3 = r9
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r11.post(r2)
            goto L69
        L59:
            r3 = r9
            r7 = r10
            com.fl.saas.api.mixNative.NativeMaterial r10 = r3.mMaterial
            com.fl.saas.common.util.feature.Size r10 = r10.getSize()
        L61:
            r9.showHorizontalMedia(r7, r10)
            goto L69
        L65:
            r3 = r9
            r7 = r10
            r10 = 0
            goto L61
        L69:
            boolean r10 = r7 instanceof com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener
            if (r10 == 0) goto Lc9
            r10 = r7
            com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener r10 = (com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener) r10
            android.widget.ImageView r11 = r3.iv_sound_control
            if (r11 == 0) goto Lc9
            r11.setVisibility(r1)
            Cd8JRx.ADYaiT r11 = new Cd8JRx.ADYaiT
            r0 = 12
            r11.<init>(r0, r9)
            r10.setSoundControlViewStateChangeListener(r11)
            boolean r11 = r10.getSoundEnable()
            android.widget.ImageView r0 = r3.iv_sound_control
            if (r11 == 0) goto L8c
            int r11 = com.fl.saas.s2s.R.drawable.yd_saas_volume_on
            goto L8e
        L8c:
            int r11 = com.fl.saas.s2s.R.drawable.yd_saas_volume_off
        L8e:
            r0.setImageResource(r11)
            android.widget.ImageView r11 = r3.iv_sound_control
            FSFw2u.AMqCpz r0 = new FSFw2u.AMqCpz
            r1 = 2
            r0.<init>(r9, r1, r10)
            r11.setOnClickListener(r0)
            return r3
        L9d:
            r3 = r9
            if (r11 == 0) goto Lc9
            int r10 = r11.getIntrinsicWidth()
            int r2 = r11.getIntrinsicHeight()
            if (r10 >= r2) goto Lba
            android.widget.FrameLayout r10 = r3.fl_vertical
            r10.setVisibility(r1)
            android.widget.FrameLayout r10 = r3.fl_horizontal
            r10.setVisibility(r0)
            android.widget.ImageView r10 = r3.mainImageViewVertical
            r10.setImageDrawable(r11)
            return r3
        Lba:
            android.widget.FrameLayout r10 = r3.fl_vertical
            r10.setVisibility(r0)
            android.widget.FrameLayout r10 = r3.fl_horizontal
            r10.setVisibility(r1)
            android.widget.ImageView r10 = r3.mainImageView
            r10.setImageDrawable(r11)
        Lc9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.inner.interstitial.coustomView.InterstitialFullScreenView.setMediaView(android.view.View, android.graphics.drawable.Drawable):com.fl.saas.base.inner.InnerNativeCustomView");
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
