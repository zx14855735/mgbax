package com.fl.saas.base.inner.interstitial;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.inner.InnerNativeAdLogo;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.InnerNativeViewHelper;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialEnvelopeView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialFullScreenView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialHMHView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialHMVView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialVMHView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialVMVView;
import com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView;
import com.fl.saas.base.innterNative.BindActionView;
import com.fl.saas.base.widget.RainTextureView;
import com.fl.saas.common.saas.bean.CloseButtonPosition;
import com.fl.saas.common.saas.bean.Orientation;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.StringUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.widget.CountDownTextView;
import com.fl.saas.common.widget.InterceptClickLayout;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InterstitialViewHelper implements NativeInterstitialView {
    private WeakReference<Activity> activityRef;
    private final FrameLayout adContainer;
    private int animalStartTime;
    private int animalTime;
    private int clickType;
    private ImageView closeView;
    private final RelativeLayout closeViewLayout;
    private int count;
    private Dialog dialog;
    private final Orientation dialogStyle;
    private ImageView envelopeCloseView;
    private View envelopeVClose;
    private boolean isFullScreenInterstitial;
    private boolean isShakeType;
    private boolean isVisible;
    private final ImageView mAdLogo;
    private final Context mContext;
    private CountDownTextView mEnvelopeSkip;
    private InnerNativeCustomView mInterstitialView;
    private boolean mIsAutoClose;
    private final InterceptClickLayout mLayout;
    private final InterstitialViewEvent mLoaderEvent;
    private final NativeMaterial mMaterial;
    private CountDownTextView mSkip;
    private NativeAdView nativeAdView;
    private CloseButtonPosition pos;
    private RainTextureView rainTextureView;
    private int scaleSize;
    private int speed;
    private View vBottomArea;
    private View vClose;
    private View vTopArea;
    private boolean isApi = false;
    private boolean smallEnvelope = false;

    /* renamed from: com.fl.saas.base.inner.interstitial.InterstitialViewHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$common$saas$bean$CloseButtonPosition;
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$common$saas$bean$Orientation;

        static {
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$fl$saas$common$saas$bean$Orientation = iArr;
            try {
                iArr[Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fl$saas$common$saas$bean$Orientation[Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CloseButtonPosition.values().length];
            $SwitchMap$com$fl$saas$common$saas$bean$CloseButtonPosition = iArr2;
            try {
                iArr2[CloseButtonPosition.IMAGE_BOTTOM_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fl$saas$common$saas$bean$CloseButtonPosition[CloseButtonPosition.IMAGE_TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public InterstitialViewHelper(Context context, boolean z, NativeMaterial nativeMaterial, Orientation orientation, InterstitialViewEvent interstitialViewEvent) {
        int i = 1;
        this.mContext = context;
        this.isFullScreenInterstitial = z;
        this.mMaterial = nativeMaterial;
        this.dialogStyle = orientation;
        this.mLoaderEvent = interstitialViewEvent;
        InterceptClickLayout interceptClickLayout = (InterceptClickLayout) ViewHelper.inflate(context, z ? R.layout.yd_saas_fullscreen_interstitial : R.layout.yd_saas_interstitial);
        this.mLayout = interceptClickLayout;
        this.adContainer = (FrameLayout) interceptClickLayout.findViewById(R.id.yd_saas_interstitial_ad_container);
        this.mSkip = (CountDownTextView) interceptClickLayout.findViewById(R.id.tv_skip);
        this.mAdLogo = (ImageView) interceptClickLayout.findViewById(R.id.iv_ad_logo);
        this.closeView = (ImageView) interceptClickLayout.findViewById(R.id.iv_close);
        this.vClose = interceptClickLayout.findViewById(R.id.v_close);
        this.vTopArea = interceptClickLayout.findViewById(R.id.v_top);
        this.vBottomArea = interceptClickLayout.findViewById(R.id.v_bottom);
        this.closeViewLayout = (RelativeLayout) interceptClickLayout.findViewById(R.id.yd_saas_interstitial_close_layout);
        this.vClose.setOnClickListener(new A5SV6n(this, 5));
        this.mSkip.setOnTick(new AZOQYO(20));
        this.mSkip.setFinish(new ARc23Z(this, i));
        interceptClickLayout.addFilterViews(this.closeView);
        interceptClickLayout.addFilterViews(this.vClose);
        loadView();
    }

    private boolean addAdView() {
        int i;
        ViewGroup.LayoutParams layoutParams = this.adContainer.getLayoutParams();
        if (this.isFullScreenInterstitial) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            try {
                CNPG0E.A4TApA interstitialSize = getInterstitialSize();
                layoutParams.width = ((Integer) interstitialSize.f1610A2egSU).intValue();
                if (this.dialogStyle != Orientation.HORIZONTAL && !this.smallEnvelope) {
                    i = ((Integer) interstitialSize.f1611A4TApA).intValue();
                    layoutParams.height = i;
                }
                i = -2;
                layoutParams.height = i;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        this.adContainer.setLayoutParams(layoutParams);
        RainTextureView rainTextureView = this.rainTextureView;
        if (rainTextureView == null) {
            return true;
        }
        this.closeViewLayout.addView(rainTextureView, r1.getChildCount() - 2, ViewHelper.getMatchParent());
        return true;
    }

    private void addAppInfo() {
        TextView createAppInfoView = InnerNativeViewHelper.createAppInfoView(this.mContext, this.mMaterial);
        if (createAppInfoView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int dip2px = DeviceUtil.dip2px(10.0f);
        createAppInfoView.setPadding(dip2px, 0, dip2px, dip2px);
        layoutParams.gravity = 80;
        this.mLayout.addView(createAppInfoView, layoutParams);
        this.mLayout.addFilterViews(createAppInfoView);
    }

    private void bindMediaView(InnerNativeCustomView innerNativeCustomView, Drawable drawable) {
        innerNativeCustomView.setMediaView((this.mMaterial.getAdType() != 3 || this.mMaterial.getAdMediaView() == null) ? null : this.mMaterial.getAdMediaView(), drawable);
        this.adContainer.addView(this.mInterstitialView.getAdView());
    }

    private InnerNativeCustomView createAdView(Orientation orientation) {
        ImageView imageView;
        int i = 0;
        if (this.isFullScreenInterstitial) {
            return new InterstitialFullScreenView(this.mContext, this.mMaterial);
        }
        Orientation orientation2 = this.dialogStyle;
        if (orientation2 == Orientation.HORIZONTAL) {
            int i2 = AnonymousClass1.$SwitchMap$com$fl$saas$common$saas$bean$Orientation[orientation.ordinal()];
            if (i2 == 1) {
                return new InterstitialHMVView(this.mContext);
            }
            if (i2 == 2) {
                return new InterstitialHMHView(this.mContext);
            }
        } else if (orientation2 == Orientation.VERTICAL) {
            int i3 = AnonymousClass1.$SwitchMap$com$fl$saas$common$saas$bean$Orientation[orientation.ordinal()];
            if (i3 == 1) {
                return new InterstitialVMVView(this.mContext);
            }
            if (i3 == 2) {
                return new InterstitialVMHView(this.mContext);
            }
        } else if (orientation2 == Orientation.ENVELOPE) {
            boolean z = TextUtils.isEmpty(!TextUtils.isEmpty(this.mMaterial.getMainImageUrl()) ? this.mMaterial.getMainImageUrl() : (String) Check.findFirstNonNull(this.mMaterial.getImageUrlList())) || TextUtils.isEmpty(this.mMaterial.getTitle()) || TextUtils.isEmpty(this.mMaterial.getDescription());
            this.smallEnvelope = z;
            Context context = this.mContext;
            CloseButtonPosition closeButtonPosition = this.pos;
            CloseButtonPosition closeButtonPosition2 = CloseButtonPosition.IMAGE_TOP_RIGHT;
            InterstitialEnvelopeView interstitialEnvelopeView = new InterstitialEnvelopeView(context, orientation, z, closeButtonPosition == closeButtonPosition2, this.animalStartTime, this.animalTime);
            interstitialEnvelopeView.setSpeed(this.speed);
            interstitialEnvelopeView.setAdType(this.isApi);
            interstitialEnvelopeView.setOnlyButton(isOnlyButton());
            CloseButtonPosition closeButtonPosition3 = this.pos;
            if (closeButtonPosition3 != CloseButtonPosition.FLOAT_TOP_RIGHT && closeButtonPosition3 != closeButtonPosition2) {
                this.mEnvelopeSkip = interstitialEnvelopeView.getSkip();
                this.envelopeCloseView = interstitialEnvelopeView.getCloseView();
                this.envelopeVClose = interstitialEnvelopeView.getSpaceView();
                this.mEnvelopeSkip.setVisibility(8);
                this.envelopeCloseView.setVisibility(8);
                this.envelopeVClose.setVisibility(8);
                return interstitialEnvelopeView;
            }
            this.mSkip.setVisibility(8);
            this.closeView.setVisibility(8);
            this.vClose.setVisibility(8);
            this.mEnvelopeSkip = interstitialEnvelopeView.getSkip();
            this.envelopeCloseView = interstitialEnvelopeView.getCloseView();
            this.envelopeVClose = interstitialEnvelopeView.getSpaceView();
            this.mLayout.addFilterViews(this.envelopeCloseView);
            this.mLayout.addFilterViews(this.envelopeVClose);
            View view = this.envelopeVClose;
            if (view != null) {
                view.bringToFront();
            }
            ImageView imageView2 = this.envelopeCloseView;
            if (imageView2 != null) {
                imageView2.bringToFront();
            }
            if (this.isVisible) {
                this.mEnvelopeSkip.setVisibility(0);
                this.envelopeCloseView.setVisibility(4);
                this.envelopeVClose.setVisibility(4);
            } else {
                this.mEnvelopeSkip.setVisibility(4);
                this.envelopeCloseView.setVisibility(0);
                this.envelopeVClose.setVisibility(0);
                this.mEnvelopeSkip.setCount(this.count);
            }
            this.envelopeVClose.setOnClickListener(new A5SV6n(this, i));
            this.mEnvelopeSkip.setOnTick(new AZOQYO(19));
            this.mEnvelopeSkip.setFinish(new ARc23Z(this, i));
            RainTextureView rainTextureView = this.rainTextureView;
            if (rainTextureView != null) {
                rainTextureView.setSaveClickItem(false);
            }
            if (this.scaleSize > 0 && (imageView = this.envelopeCloseView) != null) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int dip2px = DeviceUtil.dip2px((this.scaleSize * 20) / 50.0f);
                layoutParams.width = dip2px;
                layoutParams.height = dip2px;
                this.envelopeCloseView.setLayoutParams(layoutParams);
            }
            return interstitialEnvelopeView;
        }
        return new InterstitialVMVView(this.mContext);
    }

    public static CNPG0E.A4TApA getInterstitialSize() {
        int round;
        int round2;
        int mobileWidth = DeviceUtil.getMobileWidth();
        if (mobileWidth > DeviceUtil.getMobileHeight()) {
            round2 = Math.round(mobileWidth * 0.8f);
            round = Math.round((round2 / 16.0f) * 9.0f);
        } else {
            round = Math.round(mobileWidth * 0.8f);
            round2 = Math.round((round / 9.0f) * 16.0f);
        }
        return new CNPG0E.A4TApA(Integer.valueOf(round), Integer.valueOf(round2));
    }

    private boolean isOnlyButton() {
        if (this.clickType == 1 && (this.mMaterial.getAdType() == 2 || this.mMaterial.getAdType() == 1)) {
            return true;
        }
        if (this.clickType == 2 && this.mMaterial.getAdType() == 3) {
            return true;
        }
        return this.clickType == 3 && this.mMaterial.getAdType() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$click$13(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$click$14(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAdView$4(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createAdView$5(Integer num) {
        return num + "s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAdView$6() {
        this.mEnvelopeSkip.setVisibility(4);
        this.envelopeCloseView.setVisibility(0);
        this.envelopeVClose.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadView$7(Drawable drawable) {
        this.mInterstitialView = createAdView(drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight() ? Orientation.HORIZONTAL : Orientation.VERTICAL);
        Consumer<Bitmap> loadIcon = this.mInterstitialView.loadIcon();
        if (loadIcon != null && !TextUtils.isEmpty(this.mMaterial.getIconUrl())) {
            ImageLoader.loadImageBitmap(this.mMaterial.getIconUrl(), loadIcon);
        }
        bindMediaView(this.mInterstitialView, drawable);
        this.mLoaderEvent.onLoaded(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$1(Integer num) {
        return num + "s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() {
        this.mSkip.setVisibility(4);
        this.closeView.setVisibility(0);
        this.vClose.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$render$8() {
        return "查看详情";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRainView$10() {
        this.rainTextureView = null;
        this.mLayout.setFilterPattern(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setRainView$9(float f, float f2) {
        RainTextureView rainTextureView = this.rainTextureView;
        if (rainTextureView != null) {
            return rainTextureView.isClickItem(f, f2) || this.rainTextureView.hasClickItem();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$11(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$12(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        if (r2.isFinishing() == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$showDialog$3(android.content.DialogInterface r2) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.app.Activity> r2 = r1.activityRef     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto L1c
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L29
            android.app.Activity r2 = (android.app.Activity) r2     // Catch: java.lang.Exception -> L29
            boolean r2 = r2.isFinishing()     // Catch: java.lang.Exception -> L29
            if (r2 != 0) goto L1c
            java.lang.ref.WeakReference<android.app.Activity> r2 = r1.activityRef     // Catch: java.lang.Exception -> L29
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L29
            android.app.Activity r2 = (android.app.Activity) r2     // Catch: java.lang.Exception -> L29
        L18:
            r2.finish()     // Catch: java.lang.Exception -> L29
            goto L29
        L1c:
            android.app.Activity r2 = com.fl.saas.config.utils.DeviceUtil.getTopActivity()     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto L29
            boolean r0 = r2.isFinishing()     // Catch: java.lang.Exception -> L29
            if (r0 != 0) goto L29
            goto L18
        L29:
            com.fl.saas.base.inner.interstitial.InterstitialViewEvent r2 = r1.mLoaderEvent
            r2.onDismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.inner.interstitial.InterstitialViewHelper.lambda$showDialog$3(android.content.DialogInterface):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdIcon(Bitmap bitmap) {
        ImageView imageView;
        int i;
        if (bitmap == null) {
            return;
        }
        InnerNativeCustomView innerNativeCustomView = this.mInterstitialView;
        if (innerNativeCustomView instanceof InnerNativeAdLogo) {
            ((InnerNativeAdLogo) innerNativeCustomView).setAdLogo(bitmap);
            imageView = this.mAdLogo;
            i = 8;
        } else {
            this.mAdLogo.setImageBitmap(bitmap);
            imageView = this.mAdLogo;
            i = 0;
        }
        imageView.setVisibility(i);
    }

    private void loadView() {
        NativeMaterial nativeMaterial = this.mMaterial;
        if (nativeMaterial == null) {
            return;
        }
        View adMediaView = nativeMaterial.getAdMediaView();
        String mainImageUrl = !TextUtils.isEmpty(this.mMaterial.getMainImageUrl()) ? this.mMaterial.getMainImageUrl() : (String) Check.findFirstNonNull(this.mMaterial.getImageUrlList());
        if (!TextUtils.isEmpty(mainImageUrl)) {
            ADYaiT aDYaiT = new ADYaiT(this, 1);
            InterstitialViewEvent interstitialViewEvent = this.mLoaderEvent;
            Objects.requireNonNull(interstitialViewEvent);
            ImageLoader.loadImageDrawable(mainImageUrl, aDYaiT, new Kce6Pf.A2egSU(9, interstitialViewEvent));
            return;
        }
        if (adMediaView == null) {
            this.mLoaderEvent.onAdFailed(YdError.create(ErrorCodeConstant.RENDER_ERROR, "media and imgUrl is empty"));
            return;
        }
        InnerNativeCustomView createAdView = createAdView(Orientation.VERTICAL);
        this.mInterstitialView = createAdView;
        Consumer<Bitmap> loadIcon = createAdView.loadIcon();
        if (loadIcon != null && !TextUtils.isEmpty(this.mMaterial.getIconUrl())) {
            ImageLoader.loadImageBitmap(this.mMaterial.getIconUrl(), loadIcon);
        }
        bindMediaView(this.mInterstitialView, null);
        this.mLoaderEvent.onLoaded(this);
    }

    private void render() {
        int i = 0;
        this.mInterstitialView.setTitle(this.mMaterial.getTitle()).setCAT(StringUtils.checkEmpty(this.mMaterial.getCallToAction(), new AZOQYO(17))).setDes(this.mMaterial.getDescription());
        if (this.mMaterial.getAdLogo() != null) {
            loadAdIcon(this.mMaterial.getAdLogo());
        } else if (!TextUtils.isEmpty(this.mMaterial.getAdLogoUrl())) {
            ImageLoader.loadImageBitmap(this.mMaterial.getAdLogoUrl(), new ADYaiT(this, i));
        }
        this.mLayout.addFilterViews(this.adContainer, this.mInterstitialView.getCATView(), this.vTopArea, this.vBottomArea);
    }

    private void stopRain() {
        Optional.ofNullable(this.rainTextureView).ifPresent(new KiXkPs.A2egSU(20));
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void addActionView(View view) {
        if (view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.adContainer.addView(view, layoutParams);
        this.mLayout.addFilterViews(view);
        InnerNativeCustomView innerNativeCustomView = this.mInterstitialView;
        if (innerNativeCustomView instanceof BindActionView) {
            ((BindActionView) innerNativeCustomView).bindActionView(view);
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void click() {
        ImageView imageView = this.closeView;
        if (imageView != null) {
            imageView.setOnClickListener(new A5SV6n(this, 3));
        }
        ImageView imageView2 = this.envelopeCloseView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new A5SV6n(this, 4));
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void closeDialog() {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void destroy() {
        InnerNativeCustomView innerNativeCustomView = this.mInterstitialView;
        if (innerNativeCustomView != null && (innerNativeCustomView instanceof InterstitialEnvelopeView)) {
            ((InterstitialEnvelopeView) innerNativeCustomView).cancelAnimal();
        }
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.dialog = null;
        this.activityRef = null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public View getCATView() {
        return (View) Optional.of(this.mInterstitialView).map(new AZOQYO(18)).orElse(null);
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public View[] getClicks() {
        return isOnlyButton() ? new View[]{this.rainTextureView} : new View[]{this.rainTextureView, this.adContainer, this.vTopArea, this.vBottomArea};
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public NativeAdView getNativeAdView() {
        NativeAdView nativeAdView = this.nativeAdView;
        if (nativeAdView == null) {
            NativeAdView nativeAdView2 = new NativeAdView(this.mContext);
            this.nativeAdView = nativeAdView2;
            nativeAdView2.addView(getSelfView(), ViewHelper.getMatchParent());
        } else {
            ViewHelper.removeParent(nativeAdView);
        }
        return this.nativeAdView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public ViewGroup getSelfView() {
        return this.mLayout;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public void onClicked() {
        Dialog dialog;
        stopRain();
        if (this.mIsAutoClose && (dialog = this.dialog) != null && dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAdType(boolean z) {
        this.isApi = z;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAnimalStartTime(int i) {
        this.animalStartTime = i;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAnimalTime(int i) {
        this.animalTime = i;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAutoClose(boolean z) {
        this.mIsAutoClose = z;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setClickType(int i) {
        this.clickType = i;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setClosePos(CloseButtonPosition closeButtonPosition) {
        this.pos = closeButtonPosition;
        if (!this.isFullScreenInterstitial) {
            if (closeButtonPosition == CloseButtonPosition.FLOAT_TOP_RIGHT) {
                this.vTopArea.setVisibility(8);
                this.vBottomArea.setVisibility(8);
                return this;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSkip.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.closeView.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.vClose.getLayoutParams();
            layoutParams.removeRule(7);
            layoutParams.removeRule(6);
            layoutParams2.removeRule(7);
            layoutParams2.removeRule(6);
            layoutParams3.removeRule(7);
            layoutParams3.removeRule(6);
            int dip2px = DeviceUtil.dip2px(20.0f);
            int i = AnonymousClass1.$SwitchMap$com$fl$saas$common$saas$bean$CloseButtonPosition[closeButtonPosition.ordinal()];
            if (i == 1) {
                this.vTopArea.setVisibility(8);
                this.vBottomArea.setVisibility(0);
                layoutParams.addRule(3, R.id.yd_saas_interstitial_ad_container);
                layoutParams.addRule(14);
                layoutParams.setMargins(0, dip2px, 0, 0);
                this.mSkip.setLayoutParams(layoutParams);
                layoutParams2.addRule(3, R.id.yd_saas_interstitial_ad_container);
                layoutParams2.addRule(14);
                layoutParams2.setMargins(0, dip2px, 0, 0);
                this.closeView.setLayoutParams(layoutParams2);
                layoutParams3.addRule(3, R.id.yd_saas_interstitial_ad_container);
                layoutParams3.addRule(14);
                layoutParams3.setMargins(0, dip2px, 0, 0);
                this.vClose.setLayoutParams(layoutParams3);
                return this;
            }
            if (i == 2) {
                if (this.dialogStyle == Orientation.ENVELOPE) {
                    this.vTopArea.setVisibility(8);
                } else {
                    this.vTopArea.setVisibility(0);
                }
                this.vBottomArea.setVisibility(8);
                layoutParams.addRule(2, R.id.yd_saas_interstitial_ad_container);
                layoutParams.addRule(7, R.id.yd_saas_interstitial_ad_container);
                layoutParams.setMargins(0, 0, 0, dip2px);
                this.mSkip.setLayoutParams(layoutParams);
                layoutParams2.addRule(2, R.id.yd_saas_interstitial_ad_container);
                layoutParams2.addRule(7, R.id.yd_saas_interstitial_ad_container);
                layoutParams2.setMargins(0, 0, 0, dip2px);
                this.closeView.setLayoutParams(layoutParams2);
                layoutParams3.addRule(2, R.id.yd_saas_interstitial_ad_container);
                layoutParams3.addRule(7, R.id.yd_saas_interstitial_ad_container);
                layoutParams3.setMargins(0, 0, 0, dip2px);
                this.vClose.setLayoutParams(layoutParams3);
                return this;
            }
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setCloseViewSize(int i) {
        this.scaleSize = i;
        if (i <= 0) {
            return this;
        }
        ViewGroup.LayoutParams layoutParams = this.closeView.getLayoutParams();
        int dip2px = DeviceUtil.dip2px((i * 24) / 50.0f);
        layoutParams.width = dip2px;
        layoutParams.height = dip2px;
        this.closeView.setLayoutParams(layoutParams);
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setCountDown(boolean z, int i) {
        this.isVisible = z;
        this.count = i;
        if (z) {
            if (this.mEnvelopeSkip == null) {
                this.mSkip.setVisibility(0);
                this.closeView.setVisibility(4);
                this.vClose.setVisibility(4);
                return this;
            }
            this.mSkip.setVisibility(8);
            this.closeView.setVisibility(8);
            this.vClose.setVisibility(8);
            this.mEnvelopeSkip.setVisibility(0);
            this.envelopeCloseView.setVisibility(4);
            this.envelopeVClose.setVisibility(4);
            return this;
        }
        if (this.mEnvelopeSkip == null) {
            this.mSkip.setVisibility(4);
            this.closeView.setVisibility(0);
            this.vClose.setVisibility(0);
            this.mSkip.setCount(i);
            return this;
        }
        this.mSkip.setVisibility(8);
        this.closeView.setVisibility(8);
        this.vClose.setVisibility(8);
        this.mEnvelopeSkip.setVisibility(4);
        this.envelopeCloseView.setVisibility(0);
        this.envelopeVClose.setVisibility(0);
        this.mEnvelopeSkip.setCount(i);
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setRainView(boolean z) {
        if (!z) {
            return this;
        }
        this.rainTextureView = new RainTextureView(this.mContext);
        this.mLayout.setFilterPattern(2);
        this.mLayout.setOutIntercept(new ASJ6gh(this));
        this.rainTextureView.setAutoRemove();
        this.rainTextureView.setOnStatusListener(new ASJ6gh(this));
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setShakeType(boolean z) {
        this.isShakeType = z;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setSpeed(int i) {
        this.speed = i;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void setViewType(boolean z, int i) {
        if (isOnlyButton()) {
            return;
        }
        if (!z) {
            ImageView imageView = this.closeView;
            if (imageView != null) {
                imageView.setOnClickListener(new A5SV6n(this, 1));
            }
            ImageView imageView2 = this.envelopeCloseView;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new A5SV6n(this, 2));
                return;
            }
            return;
        }
        View view = this.vClose;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int dip2px = DeviceUtil.dip2px((i * 40) / 100.0f);
            layoutParams.width = dip2px;
            layoutParams.height = dip2px;
            this.vClose.setLayoutParams(layoutParams);
        }
        View view2 = this.envelopeVClose;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            int dip2px2 = DeviceUtil.dip2px((i * 40) / 100.0f);
            layoutParams2.width = dip2px2;
            layoutParams2.height = dip2px2;
            this.envelopeVClose.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public boolean showDialog(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
        render();
        Dialog dialog = new Dialog(activity);
        this.dialog = dialog;
        Window window = dialog.getWindow();
        window.requestFeature(1);
        this.dialog.getWindow().setDimAmount(0.7f);
        this.dialog.getWindow().addFlags(2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (!addAdView()) {
            return false;
        }
        this.dialog.setContentView(getNativeAdView());
        window.setLayout(-1, -1);
        this.dialog.setCancelable(false);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.fl.saas.base.inner.interstitial.AMqCpz
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                InterstitialViewHelper.this.lambda$showDialog$3(dialogInterface);
            }
        });
        addAppInfo();
        this.dialog.show();
        return true;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView startCountdown() {
        if (this.mSkip.getVisibility() == 0) {
            this.mSkip.start();
        }
        CountDownTextView countDownTextView = this.mEnvelopeSkip;
        if (countDownTextView != null && countDownTextView.getVisibility() == 0) {
            this.mEnvelopeSkip.start();
        }
        return this;
    }
}
