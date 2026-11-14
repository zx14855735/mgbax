package io.dcloud.openapi.poly.adapter.gdt;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.util.AdError;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class GDTFeedAOLEntry extends DCBaseAOL implements AOLLoader.NativeAOLListener, NativeADEventListener, NativeADMediaListener {

    /* renamed from: a, reason: collision with root package name */
    public Object f13965a;
    public int b;
    public MediaView c;
    public AOLLoader.VideoAdListener d;
    public AOLLoader.AppDownloadListener e;

    public GDTFeedAOLEntry(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.b = 0;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13965a != null) {
            int i4 = i3 != 2 ? 10001 : 1;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.WIN_PRICE, i4, IBidding.LOSS_REASON);
            hashMap.put(IBidding.ADN_ID, 2);
            Object obj = this.f13965a;
            if (obj instanceof NativeExpressADView) {
                ((NativeExpressADView) obj).sendLossNotification(hashMap);
            } else if (obj instanceof NativeUnifiedADData) {
                ((NativeUnifiedADData) obj).sendLossNotification(hashMap);
            }
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        if (this.f13965a != null) {
            this.b = i;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.EXPECT_COST_PRICE, i2, IBidding.HIGHEST_LOSS_PRICE);
            Object obj = this.f13965a;
            if (obj instanceof NativeExpressADView) {
                ((NativeExpressADView) obj).sendWinNotification(hashMap);
            } else if (obj instanceof NativeUnifiedADData) {
                ((NativeUnifiedADData) obj).sendWinNotification(hashMap);
            }
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        Object obj = this.f13965a;
        if (obj instanceof NativeExpressADView) {
            ((NativeExpressADView) obj).destroy();
        } else if (obj instanceof NativeUnifiedADData) {
            ((NativeUnifiedADData) obj).destroy();
        }
        this.f13965a = null;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void dislike(Activity activity) {
        if (!(this.f13965a instanceof NativeUnifiedADData) || getFeedAdCallback() == null) {
            return;
        }
        getFeedAdCallback().onClosed("");
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public View getExpressAdView(Activity activity) {
        Object obj = this.f13965a;
        if (!(obj instanceof View) || ((View) obj).getParent() == null) {
            Object obj2 = this.f13965a;
            if (obj2 instanceof NativeExpressADView) {
                return (NativeExpressADView) obj2;
            }
            return null;
        }
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
            getFeedAdCallback().onShowError();
        }
        return null;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public SparseArray<Object> getNativeAdInfo() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        Object obj = this.f13965a;
        if (obj instanceof NativeUnifiedADData) {
            sparseArray.put(PluginConstants.ERROR_PLUGIN_DOWNLOAD, ((NativeUnifiedADData) obj).getTitle());
            sparseArray.put(1000, ((NativeUnifiedADData) this.f13965a).getButtonText());
            sparseArray.put(1001, ((NativeUnifiedADData) this.f13965a).getDesc());
            sparseArray.put(1002, ((NativeUnifiedADData) this.f13965a).getIconUrl());
            sparseArray.put(1005, Boolean.FALSE);
            if (((NativeUnifiedADData) this.f13965a).isAppAd()) {
                final NativeUnifiedADAppMiitInfo appMiitInfo = ((NativeUnifiedADData) this.f13965a).getAppMiitInfo();
                sparseArray.put(PluginConstants.ERROR_PLUGIN_FETCH, 1);
                sparseArray.put(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, new AOLLoader.AppInfo() { // from class: io.dcloud.openapi.poly.adapter.gdt.GDTFeedAOLEntry.1
                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getApkSize() {
                        return appMiitInfo.getPackageSizeBytes() + "";
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppDownloadCount() {
                        return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).getDownloadCount() + "";
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppName() {
                        return appMiitInfo.getAppName();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppPackageName() {
                        return "";
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppScore() {
                        return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).getAppScore() + "";
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getAppVersion() {
                        return appMiitInfo.getVersionName();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getDeveloperName() {
                        return appMiitInfo.getAuthorName();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getFunctionDescUrl() {
                        return appMiitInfo.getDescriptionUrl();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getPermissionInfoUrl() {
                        return appMiitInfo.getPermissionsUrl();
                    }

                    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppInfo
                    public String getPrivacyUrl() {
                        return appMiitInfo.getPrivacyAgreement();
                    }
                });
            } else {
                sparseArray.put(PluginConstants.ERROR_PLUGIN_FETCH, 0);
            }
            int adPatternType = ((NativeUnifiedADData) this.f13965a).getAdPatternType();
            if (adPatternType == 3) {
                sparseArray.put(1008, 3);
                List<String> imgList = ((NativeUnifiedADData) this.f13965a).getImgList();
                ArrayList arrayList = new ArrayList();
                if (imgList != null && imgList.size() > 0) {
                    for (final String str : imgList) {
                        arrayList.add(new AOLLoader.AdImage() { // from class: io.dcloud.openapi.poly.adapter.gdt.GDTFeedAOLEntry.2
                            @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                            public int getHeight() {
                                return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).getPictureHeight();
                            }

                            @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                            public String getUrl() {
                                return str;
                            }

                            @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                            public int getWidth() {
                                return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).getPictureWidth();
                            }

                            @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                            public boolean isValid() {
                                return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).isValid();
                            }
                        });
                    }
                }
                sparseArray.put(1009, arrayList);
                return sparseArray;
            }
            if (adPatternType != 4 && adPatternType != 1) {
                if (adPatternType != 2) {
                    sparseArray.put(1008, 0);
                    return sparseArray;
                }
                sparseArray.put(1008, 1);
                sparseArray.put(1010, Double.valueOf(((NativeUnifiedADData) this.f13965a).getVideoDuration() / 1000.0d));
                return sparseArray;
            }
            sparseArray.put(1008, 2);
            ((NativeUnifiedADData) this.f13965a).getImgUrl();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new AOLLoader.AdImage() { // from class: io.dcloud.openapi.poly.adapter.gdt.GDTFeedAOLEntry.3
                @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                public int getHeight() {
                    return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).getPictureHeight();
                }

                @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                public String getUrl() {
                    return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).getImgUrl();
                }

                @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                public int getWidth() {
                    return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).getPictureWidth();
                }

                @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AdImage
                public boolean isValid() {
                    return ((NativeUnifiedADData) GDTFeedAOLEntry.this.f13965a).isValid();
                }
            });
            sparseArray.put(1009, arrayList2);
        }
        return sparseArray;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return "gdt";
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public View getVideoView(Activity activity) {
        Object obj = this.f13965a;
        if ((obj instanceof NativeUnifiedADData) && ((NativeUnifiedADData) obj).getAdPatternType() == 2 && this.c == null) {
            this.c = new MediaView(activity);
        }
        return this.c;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        Object obj = this.f13965a;
        if (obj instanceof NativeExpressADView) {
            return ((NativeExpressADView) obj).isValid();
        }
        if (obj instanceof NativeUnifiedADData) {
            return ((NativeUnifiedADData) obj).isValid();
        }
        return false;
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShowError();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
        AOLLoader.AppDownloadListener appDownloadListener;
        Object obj = this.f13965a;
        if ((obj instanceof NativeUnifiedADData) && ((NativeUnifiedADData) obj).isAppAd()) {
            int appStatus = ((NativeUnifiedADData) this.f13965a).getAppStatus();
            if (appStatus == 1) {
                AOLLoader.AppDownloadListener appDownloadListener2 = this.e;
                if (appDownloadListener2 != null) {
                    appDownloadListener2.onInstalled(null, null);
                    return;
                }
                return;
            }
            if (appStatus == 4) {
                AOLLoader.AppDownloadListener appDownloadListener3 = this.e;
                if (appDownloadListener3 != null) {
                    appDownloadListener3.onDownloadActive(100L, 50L, null, null);
                    return;
                }
                return;
            }
            if (appStatus != 8) {
                if (appStatus == 16 && (appDownloadListener = this.e) != null) {
                    appDownloadListener.onDownloadFailed(100L, 50L, null, null);
                    return;
                }
                return;
            }
            AOLLoader.AppDownloadListener appDownloadListener4 = this.e;
            if (appDownloadListener4 != null) {
                appDownloadListener4.onDownloadFinished(100L, null, null);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoClicked() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoCompleted() {
        AOLLoader.VideoAdListener videoAdListener = this.d;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoError(AdError adError) {
        AOLLoader.VideoAdListener videoAdListener = this.d;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoaded(int i) {
        AOLLoader.VideoAdListener videoAdListener = this.d;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoPause() {
        AOLLoader.VideoAdListener videoAdListener = this.d;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoReady() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoResume() {
        AOLLoader.VideoAdListener videoAdListener = this.d;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdResume();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStart() {
        AOLLoader.VideoAdListener videoAdListener = this.d;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStop() {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void registerViewForInteraction(Activity activity, FrameLayout frameLayout, List<View> list, List<View> list2, List<ImageView> list3) {
        NativeAdContainer nativeAdContainer;
        Object obj = this.f13965a;
        if (obj instanceof NativeUnifiedADData) {
            if (this.c == null && ((NativeUnifiedADData) obj).getAdPatternType() == 2) {
                return;
            }
            if (frameLayout.getChildAt(0) instanceof NativeAdContainer) {
                NativeAdContainer nativeAdContainer2 = (NativeAdContainer) frameLayout.getChildAt(0);
                int i = 0;
                while (i < nativeAdContainer2.getChildCount()) {
                    View childAt = nativeAdContainer2.getChildAt(i);
                    if (childAt != null) {
                        Object tag = childAt.getTag();
                        if (!(tag instanceof String) || !tag.equals("gdt_view_tag")) {
                            nativeAdContainer2.removeView(childAt);
                        }
                    }
                    i++;
                }
                nativeAdContainer = nativeAdContainer2;
            } else {
                NativeAdContainer nativeAdContainer3 = new NativeAdContainer(activity);
                while (frameLayout.getChildCount() > 0) {
                    View childAt2 = frameLayout.getChildAt(0);
                    childAt2.setTag("gdt_view_tag");
                    int indexOfChild = frameLayout.indexOfChild(childAt2);
                    frameLayout.removeViewInLayout(childAt2);
                    nativeAdContainer3.addView(childAt2, indexOfChild, childAt2.getLayoutParams());
                }
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdContainer3, -1, -1);
                nativeAdContainer = nativeAdContainer3;
            }
            ((NativeUnifiedADData) this.f13965a).setNativeAdEventListener(this);
            ((NativeUnifiedADData) this.f13965a).bindAdToView(activity, nativeAdContainer, null, list, list2);
            MediaView mediaView = this.c;
            if (mediaView != null) {
                ((NativeUnifiedADData) this.f13965a).bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayMuted(false).setEnableUserControl(false).build(), this);
            } else {
                if (((NativeUnifiedADData) this.f13965a).getAdPatternType() == 2 || list3 == null || list3.isEmpty()) {
                    return;
                }
                ((NativeUnifiedADData) this.f13965a).bindImageViews(list3, 0);
            }
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void render() {
        Object obj = this.f13965a;
        if ((obj instanceof View) && ((View) obj).getParent() != null) {
            if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
                getFeedAdCallback().onShowError();
                return;
            }
            return;
        }
        Object obj2 = this.f13965a;
        if (obj2 instanceof NativeExpressADView) {
            ((IBidding) obj2).setBidECPM(this.b);
            ((NativeExpressADView) this.f13965a).render();
        } else if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
    }

    public void setAdEntry(Object obj) {
        this.f13965a = obj;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setAppDownloadListener(AOLLoader.AppDownloadListener appDownloadListener) {
        if (this.f13965a instanceof NativeUnifiedADData) {
            this.e = appDownloadListener;
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setVideoAdListener(AOLLoader.VideoAdListener videoAdListener) {
        if (this.f13965a instanceof NativeUnifiedADData) {
            this.d = videoAdListener;
        }
    }
}
