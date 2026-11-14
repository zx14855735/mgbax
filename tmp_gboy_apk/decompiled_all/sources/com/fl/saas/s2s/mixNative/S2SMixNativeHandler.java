package com.fl.saas.s2s.mixNative;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdAppInfo;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.adapter.MixNativeAPI;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.annotation.MixNativeLoad;
import com.fl.saas.base.innterNative.AdAppInfo;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.feature.Size;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.mixNative.S2SMixNativeHandler;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CacheListener;
import com.fl.saas.s2s.sdk.helper.OnYqAdListener;
import com.fl.saas.s2s.sdk.helper.S2sRequestHelper;
import com.fl.spi.SPI;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Advertiser(5)
@SPI({MixNativeAPI.class})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SMixNativeHandler extends MixNativeHandler {
    private static final String TAG = CommConstant.getClassTag("S2S", S2SMixNativeHandler.class);

    /* renamed from: com.fl.saas.s2s.mixNative.S2SMixNativeHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements OnYqAdListener {
        final /* synthetic */ AdSource val$source;

        public AnonymousClass1(AdSource adSource) {
            this.val$source = adSource;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ NativeAd lambda$onNativeAdReceived$1(final AdSource adSource, AdInfoPoJo adInfoPoJo) {
            S2SNative s2SNative = new S2SNative(S2SMixNativeHandler.this.getContext(), adInfoPoJo, adSource, new CacheListener() { // from class: com.fl.saas.s2s.mixNative.A4TApA
                @Override // com.fl.saas.s2s.sdk.helper.CacheListener
                public final boolean isCache() {
                    boolean z;
                    z = AdSource.this.isCacheAd;
                    return z;
                }
            });
            if (S2SMixNativeHandler.this.getAdStyle() != NativeStyle.EXPRESS) {
                return s2SNative;
            }
            return new S2SNativeExpress(S2SMixNativeHandler.this.getContext(), s2SNative, DeviceUtil.dip2px(S2SMixNativeHandler.this.getAdParams().getExpressWidth()), DeviceUtil.dip2px(S2SMixNativeHandler.this.getAdParams().getExpressHeight())).setClickType(adSource.only_button);
        }

        @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
        public void onAdFailed(YdError ydError) {
            S2SMixNativeHandler.this.onAdFailed(ydError);
        }

        @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
        public void onNativeAdReceived(List<AdInfoPoJo> list) {
            AdInfoPoJo adInfoPoJo = (AdInfoPoJo) Check.findFirstNonNull(list);
            if (adInfoPoJo == null) {
                S2SMixNativeHandler.this.onAdFailed(YdError.create(ErrorCodeConstant.AD_DATA_ERROR, "onNativeAdReceived but pojoList is empty"));
                return;
            }
            S2SMixNativeHandler s2SMixNativeHandler = S2SMixNativeHandler.this;
            final AdSource adSource = this.val$source;
            s2SMixNativeHandler.handleAd(adInfoPoJo, new AmA8tU.A2egSU() { // from class: com.fl.saas.s2s.mixNative.A2egSU
                @Override // AmA8tU.A2egSU
                public final Object apply(Object obj) {
                    NativeAd lambda$onNativeAdReceived$1;
                    lambda$onNativeAdReceived$1 = S2SMixNativeHandler.AnonymousClass1.this.lambda$onNativeAdReceived$1(adSource, (AdInfoPoJo) obj);
                    return lambda$onNativeAdReceived$1;
                }
            });
        }
    }

    static {
        fypPDxy();
    }

    public static NativeMaterial adInfoToNativeMaterial(final AdInfoPoJo adInfoPoJo, final View view) {
        return new NativeMaterial() { // from class: com.fl.saas.s2s.mixNative.S2SMixNativeHandler.2
            Bitmap adLogo;
            Bitmap adLogoBitmap;
            private List<String> imgs;
            private NativeAdAppInfo mAdAppInfo;

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public NativeAdAppInfo getAdAppInfo() {
                if (this.mAdAppInfo == null) {
                    this.mAdAppInfo = new AdAppInfo() { // from class: com.fl.saas.s2s.mixNative.S2SMixNativeHandler.2.1
                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppName() {
                            return AdInfoPoJo.this.app_name;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppPermissionUrl() {
                            return AdInfoPoJo.this.permissions_url;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppPrivacyUrl() {
                            return AdInfoPoJo.this.privacy_agreement;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppVersion() {
                            return AdInfoPoJo.this.app_version;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getFunctionUrl() {
                            return AdInfoPoJo.this.app_intro_url;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getPublisher() {
                            return AdInfoPoJo.this.advertiser_name;
                        }
                    };
                }
                return this.mAdAppInfo;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Bitmap getAdLogo() {
                Bitmap convertMipmapToBitmap;
                if (this.adLogo == null) {
                    try {
                        AdInfoPoJo adInfoPoJo2 = AdInfoPoJo.this;
                        if (adInfoPoJo2.adv_id != 0 && !"广告".equals(adInfoPoJo2.advName)) {
                            convertMipmapToBitmap = ImageUtils.textToAdLogo(AdInfoPoJo.this.advName);
                            this.adLogo = convertMipmapToBitmap;
                        }
                        convertMipmapToBitmap = ImageUtils.convertMipmapToBitmap(DeviceUtil.getContext(), R.mipmap.yd_saas_icon_logo);
                        this.adLogo = convertMipmapToBitmap;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return this.adLogo;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Bitmap getAdLogoBitmap() {
                Bitmap convertMipmapToBitmap;
                if (this.adLogoBitmap == null) {
                    try {
                        AdInfoPoJo adInfoPoJo2 = AdInfoPoJo.this;
                        if (adInfoPoJo2.adv_id != 0 && !"广告".equals(adInfoPoJo2.advName)) {
                            convertMipmapToBitmap = ImageUtils.textToAdLogo(AdInfoPoJo.this.advName);
                            this.adLogoBitmap = convertMipmapToBitmap;
                        }
                        convertMipmapToBitmap = ImageUtils.convertMipmapToBitmap(DeviceUtil.getContext(), R.mipmap.yd_saas_icon_no_text_logo);
                        this.adLogoBitmap = convertMipmapToBitmap;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return this.adLogoBitmap;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getAdLogoUrl() {
                return null;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public View getAdMediaView() {
                return view;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public int getAdType() {
                int i = AdInfoPoJo.this.creative.ctype;
                if (i != 1) {
                    if (i == 2) {
                        return 3;
                    }
                    if (i != 3) {
                        return 0;
                    }
                }
                return 1;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getCallToAction() {
                return TextUtils.equals("1", AdInfoPoJo.this.ac_type) ? "开始下载" : "查看详情";
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getDescription() {
                return AdInfoPoJo.this.description;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getIconUrl() {
                return AdInfoPoJo.this.logo_icon;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public List<String> getImageUrlList() {
                if (this.imgs == null) {
                    ArrayList arrayList = new ArrayList();
                    this.imgs = arrayList;
                    arrayList.add(AdInfoPoJo.this.img_url);
                }
                return this.imgs;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getMainImageUrl() {
                return AdInfoPoJo.this.img_url;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Size getSize() {
                AdInfoPoJo.Video video;
                AdInfoPoJo adInfoPoJo2 = AdInfoPoJo.this;
                AdInfoPoJo.Creative creative = adInfoPoJo2.creative;
                return (creative.ctype != 2 || (video = creative.video) == null) ? new Size(adInfoPoJo2.width, adInfoPoJo2.height) : new Size(video.width, video.height);
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getTitle() {
                return AdInfoPoJo.this.title;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public double getVideoDuration() {
                return AdInfoPoJo.this.VIDEO_TIME * 1000;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getVideoUrl() {
                return AdInfoPoJo.this.video_url;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public boolean isNativeAppAd() {
                return !TextUtils.isEmpty(AdInfoPoJo.this.download_url);
            }
        };
    }

    private static /* synthetic */ void fypPDxy() {
        char[] charArray = "îâà£êìàè£ïâô£þåèáá£ÇãäÏÿäéêè".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 141);
        }
        String str = new String(charArray);
        char[] charArray2 = "îáäãäù".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 141);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @MixNativeLoad
    private void loadNative(Activity activity, AdSource adSource) {
        S2sRequestHelper.getInstance().requestAd(1, adSource, new AnonymousClass1(adSource));
    }

    @Override // com.fl.saas.base.adapter.MixNativeHandler
    public void init() {
    }
}
