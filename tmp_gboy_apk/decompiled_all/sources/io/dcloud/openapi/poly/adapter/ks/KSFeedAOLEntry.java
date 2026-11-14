package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.A4TApA;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class KSFeedAOLEntry extends DCBaseAOL implements KsFeedAd.AdInteractionListener, AOLLoader.NativeAOLListener, KsNativeAd.AdInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public Object f13981a;
    public View b;

    public KSFeedAOLEntry(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public final /* synthetic */ void a() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderSuccess();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13981a != null) {
            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
            adExposureFailedReason.winEcpm = i;
            Object obj = this.f13981a;
            if (obj instanceof KsFeedAd) {
                ((KsFeedAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
            } else if (obj instanceof KsNativeAd) {
                ((KsNativeAd) obj).reportAdExposureFailed(2, adExposureFailedReason);
            }
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        Object obj = this.f13981a;
        if (obj instanceof KsFeedAd) {
            ((KsFeedAd) obj).setBidEcpm(i);
        } else if (obj instanceof KsNativeAd) {
            ((KsNativeAd) obj).setBidEcpm(i);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        if (this.f13981a != null) {
            this.f13981a = null;
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void dislike(Activity activity) {
        if (this.f13981a instanceof KsNativeAd) {
            onDislikeClicked();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public View getExpressAdView(Activity activity) {
        View view = this.b;
        if (view == null || view.getParent() == null) {
            Object obj = this.f13981a;
            if (obj instanceof KsFeedAd) {
                this.b = ((KsFeedAd) obj).getFeedView(activity);
            }
            return this.b;
        }
        if (getFeedAdCallback() == null) {
            return null;
        }
        getFeedAdCallback().onShowError();
        return null;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public SparseArray<Object> getNativeAdInfo() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        Object obj = this.f13981a;
        if (obj instanceof KsNativeAd) {
            sparseArray.put(1000, ((KsNativeAd) obj).getActionDescription());
            sparseArray.put(1001, ((KsNativeAd) this.f13981a).getAdDescription());
            sparseArray.put(1002, ((KsNativeAd) this.f13981a).getAppIconUrl());
            sparseArray.put(1003, ((KsNativeAd) this.f13981a).getAdSource());
            sparseArray.put(1005, Boolean.FALSE);
            sparseArray.put(PluginConstants.ERROR_PLUGIN_FETCH, Integer.valueOf(((KsNativeAd) this.f13981a).getInteractionType()));
            if (((KsNativeAd) this.f13981a).getInteractionType() == 1) {
                sparseArray.put(PluginConstants.ERROR_PLUGIN_DOWNLOAD, ((KsNativeAd) this.f13981a).getAppName());
                sparseArray.put(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, new AOLLoader.AppInfo() { // from class: io.dcloud.openapi.poly.adapter.ks.KSFeedAOLEntry.1
                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getApkSize() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getAppPackageSize() + "";
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppDownloadCount() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getAppDownloadCountDes();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppName() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getAppName();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppPackageName() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getAppPackageName();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppScore() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getAppScore() + "";
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppVersion() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getAppVersion();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getDeveloperName() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getCorporationName();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getFunctionDescUrl() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getIntroductionInfoUrl();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getPermissionInfoUrl() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getPermissionInfoUrl();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getPrivacyUrl() {
                        return ((KsNativeAd) KSFeedAOLEntry.this.f13981a).getAppPrivacyUrl();
                    }
                });
            } else {
                sparseArray.put(PluginConstants.ERROR_PLUGIN_DOWNLOAD, ((KsNativeAd) this.f13981a).getProductName());
            }
            int materialType = ((KsNativeAd) this.f13981a).getMaterialType();
            if (materialType != 1 && materialType != 8) {
                if (materialType == 2) {
                    sparseArray.put(1008, 2);
                    List<KsImage> imageList = ((KsNativeAd) this.f13981a).getImageList();
                    ArrayList arrayList = new ArrayList();
                    if (imageList != null && !imageList.isEmpty()) {
                        for (final KsImage ksImage : imageList) {
                            arrayList.add(new AOLLoader.AdImage() { // from class: io.dcloud.openapi.poly.adapter.ks.KSFeedAOLEntry.2
                                @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                                public int getHeight() {
                                    return KsImage.this.getHeight();
                                }

                                @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                                public String getUrl() {
                                    return KsImage.this.getImageUrl();
                                }

                                @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                                public int getWidth() {
                                    return KsImage.this.getWidth();
                                }

                                @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                                public boolean isValid() {
                                    return KsImage.this.isValid();
                                }
                            });
                        }
                    }
                    sparseArray.put(1009, arrayList);
                    return sparseArray;
                }
                if (materialType != 5 && materialType != 3) {
                    sparseArray.put(1008, 0);
                    return sparseArray;
                }
                sparseArray.put(1008, 3);
                List<KsImage> imageList2 = ((KsNativeAd) this.f13981a).getImageList();
                ArrayList arrayList2 = new ArrayList();
                if (imageList2 != null && !imageList2.isEmpty()) {
                    for (final KsImage ksImage2 : imageList2) {
                        arrayList2.add(new AOLLoader.AdImage() { // from class: io.dcloud.openapi.poly.adapter.ks.KSFeedAOLEntry.2
                            @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                            public int getHeight() {
                                return KsImage.this.getHeight();
                            }

                            @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                            public String getUrl() {
                                return KsImage.this.getImageUrl();
                            }

                            @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                            public int getWidth() {
                                return KsImage.this.getWidth();
                            }

                            @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                            public boolean isValid() {
                                return KsImage.this.isValid();
                            }
                        });
                    }
                }
                sparseArray.put(1009, arrayList2);
                return sparseArray;
            }
            if (materialType == 1) {
                sparseArray.put(1010, Integer.valueOf(((KsNativeAd) this.f13981a).getVideoDuration()));
            } else {
                sparseArray.put(1010, 0);
            }
            sparseArray.put(1008, 1);
        }
        return sparseArray;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return "ks";
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public View getVideoView(Activity activity) {
        Object obj = this.f13981a;
        if ((obj instanceof KsNativeAd) && ((KsNativeAd) obj).getMaterialType() == 1) {
            return ((KsNativeAd) this.f13981a).getVideoView(activity, (KsAdVideoPlayConfig) null);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        return this.f13981a != null;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClosed("");
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener, com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onDownloadTipsDialogDismiss() {
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener, com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onDownloadTipsDialogShow() {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void registerViewForInteraction(Activity activity, FrameLayout frameLayout, List<View> list, List<View> list2, List<ImageView> list3) {
        if (this.f13981a instanceof KsNativeAd) {
            HashMap hashMap = new HashMap();
            if (list != null) {
                for (View view : list) {
                    if (view != null) {
                        hashMap.put(view, 2);
                    }
                }
            }
            if (list2 != null) {
                for (View view2 : list2) {
                    if (view2 != null) {
                        hashMap.put(view2, 1);
                    }
                }
            }
            Context context = frameLayout.getContext();
            float f = context.getResources().getDisplayMetrics().density;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            int i = (int) (1.0f * f);
            float f2 = 2.0f * f;
            linearLayout.setPadding(0, i, (int) f2, i);
            String adSourceLogoUrl = ((KsNativeAd) this.f13981a).getAdSourceLogoUrl(0);
            if (!TextUtils.isEmpty(adSourceLogoUrl)) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                A4TApA.ARc23Z(frameLayout.getContext()).AaHO0E(adSourceLogoUrl).BTvldC(imageView);
                linearLayout.addView(imageView, new ViewGroup.LayoutParams((int) (14.0f * f), (int) (10.0f * f)));
            }
            String adSource = ((KsNativeAd) this.f13981a).getAdSource();
            if (!TextUtils.isEmpty(adSource)) {
                TextView textView = new TextView(context);
                textView.setText(adSource);
                textView.setTextSize(f * 4.0f);
                textView.setGravity(17);
                textView.setTextColor(-1);
                linearLayout.addView(textView);
            }
            if (linearLayout.getChildCount() != 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                int i2 = (int) (f * 4.0f);
                layoutParams.setMargins(0, 0, i2, i2);
                layoutParams.gravity = 8388693;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(f2);
                gradientDrawable.setColor(Color.parseColor("#aa444444"));
                linearLayout.setBackground(gradientDrawable);
                frameLayout.addView(linearLayout, layoutParams);
            }
            ((KsNativeAd) this.f13981a).registerViewForInteraction(activity, frameLayout, hashMap, this);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void render() {
        View view = this.b;
        if (view != null && view.getParent() != null) {
            if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
                getFeedAdCallback().onShowError();
                return;
            }
            return;
        }
        Object obj = this.f13981a;
        if (obj instanceof KsFeedAd) {
            ((KsFeedAd) obj).setAdInteractionListener(this);
            MainHandlerUtil.getMainHandler().post(new A2egSU(this, 1));
        } else if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
    }

    public void setAdEntry(Object obj) {
        this.f13981a = obj;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setAppDownloadListener(final AOLLoader.AppDownloadListener appDownloadListener) {
        Object obj = this.f13981a;
        if (obj instanceof KsNativeAd) {
            ((KsNativeAd) obj).setDownloadListener(new KsAppDownloadListener() { // from class: io.dcloud.openapi.poly.adapter.ks.KSFeedAOLEntry.3
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    AOLLoader.AppDownloadListener.this.onDownloadFailed(100L, 50L, "", "");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    AOLLoader.AppDownloadListener.this.onDownloadFinished(100L, "", "");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    AOLLoader.AppDownloadListener.this.onIdle();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    AOLLoader.AppDownloadListener.this.onIdle();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    AOLLoader.AppDownloadListener.this.onInstalled("", "");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    AOLLoader.AppDownloadListener.this.onDownloadActive(100L, i, "", "");
                }
            });
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setVideoAdListener(final AOLLoader.VideoAdListener videoAdListener) {
        Object obj = this.f13981a;
        if (obj instanceof KsNativeAd) {
            ((KsNativeAd) obj).setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: io.dcloud.openapi.poly.adapter.ks.KSFeedAOLEntry.4
                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayComplete() {
                    AOLLoader.VideoAdListener.this.onVideoAdComplete();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayError(int i, int i2) {
                    AOLLoader.VideoAdListener.this.onVideoError(i, i2 + "");
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayPause() {
                    AOLLoader.VideoAdListener.this.onVideoAdPaused();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayReady() {
                    AOLLoader.VideoAdListener.this.onVideoLoad();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayResume() {
                    AOLLoader.VideoAdListener.this.onVideoAdResume();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayStart() {
                    AOLLoader.VideoAdListener.this.onVideoAdStartPlay();
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
    public void onAdShow(KsNativeAd ksNativeAd) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }
}
