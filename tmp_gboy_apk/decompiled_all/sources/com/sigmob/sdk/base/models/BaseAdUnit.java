package com.sigmob.sdk.base.models;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.content.Context;
import android.net.Uri;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.czhj.wire.Wire;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.common.ai;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.i;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.AdSetting;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.models.rtb.ClickAreaSetting;
import com.sigmob.sdk.base.models.rtb.Color;
import com.sigmob.sdk.base.models.rtb.FrequencyControl;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.models.rtb.LinkAction;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.ResponseAsset;
import com.sigmob.sdk.base.models.rtb.ResponseAssetImage;
import com.sigmob.sdk.base.models.rtb.ResponseAssetVideo;
import com.sigmob.sdk.base.models.rtb.ResponseNativeAd;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.models.rtb.SplashAdSetting;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.models.rtb.Tracking;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.base.models.rtb.Widget;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.utils.k;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.views.n;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.nativead.e;
import com.sigmob.sdk.videoAd.a;
import com.sigmob.sdk.videoAd.d;
import com.sigmob.windad.natives.AdAppInfo;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class BaseAdUnit implements Serializable {
    private static final String TAG = "BaseAdUnit";
    private static final long serialVersionUID = 1;
    private Ad ad;
    private transient AdAppInfo adAppInfo;
    private transient i adConfig;
    private int adHeight;
    private LoadAdRequest adRequest;
    private HashMap<String, List<ai>> adTrackersMap;
    private int adWidth;
    private String ad_scene_desc;
    private String ad_scene_id;
    private String ad_source_channel;
    private int ad_type;
    private String adslot_id;
    private String adx_id;
    private String apkName;
    private String apkPackageName;
    private String bid_token;
    public BiddingResponse bidding_response;
    private String camp_id;
    private ClickCommon clickCommon;
    private long create_time;
    private String crid;
    private transient Uri deeplinkUri;
    private Long downloadId;
    private transient f downloadTask;
    private String downloadUrl;
    private List<d> download_trackers;
    private String endcard_md5;
    public int expiration_time;
    private transient List<SigImage> imageUrlList;
    private boolean isHalfInterstitial;
    private String landUrl;
    private String load_id;
    private AndroidMarket mCustomAndroidMarket;
    private String mCustomDeeplink;
    private String mCustomLandPageUrl;
    private transient HashMap<String, Integer> mRedirectCountMap;
    private transient ah mSessionManager;
    private SigMacroCommon macroCommon;
    private int mraidInteractionType;
    private SigVideo nativeVideo;
    private String originVid;
    private int requestSceneType;
    private String request_id;
    private String rv_callback_url;
    public Template scene;
    public SlotAdSetting slotAdSetting;
    private String traceId;
    public String uid;
    private String uuid;
    private VideoStatusCommon videoCommon;
    private String video_md5;
    private double adPercent = -1.0d;
    private double realAdPercent = -1.0d;
    private boolean useDownloadedApk = false;
    private boolean isDislikeReported = false;
    private boolean record = true;
    private boolean catchVideo = false;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:15:0x0020, B:17:0x005e, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:26:0x008d, B:28:0x00a6, B:29:0x00af, B:31:0x00b4, B:33:0x00ba, B:35:0x00c3, B:37:0x00c7, B:40:0x0070, B:42:0x0074), top: B:14:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:15:0x0020, B:17:0x005e, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:26:0x008d, B:28:0x00a6, B:29:0x00af, B:31:0x00b4, B:33:0x00ba, B:35:0x00c3, B:37:0x00c7, B:40:0x0070, B:42:0x0074), top: B:14:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:15:0x0020, B:17:0x005e, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:26:0x008d, B:28:0x00a6, B:29:0x00af, B:31:0x00b4, B:33:0x00ba, B:35:0x00c3, B:37:0x00c7, B:40:0x0070, B:42:0x0074), top: B:14:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #1 {all -> 0x006d, blocks: (B:15:0x0020, B:17:0x005e, B:20:0x0077, B:22:0x0081, B:23:0x0087, B:26:0x008d, B:28:0x00a6, B:29:0x00af, B:31:0x00b4, B:33:0x00ba, B:35:0x00c3, B:37:0x00c7, B:40:0x0070, B:42:0x0074), top: B:14:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.sigmob.sdk.base.models.BaseAdUnit adUnit(com.sigmob.sdk.base.models.rtb.Ad r5, java.lang.String r6, com.sigmob.sdk.base.models.LoadAdRequest r7, com.sigmob.sdk.base.models.rtb.SlotAdSetting r8, com.sigmob.sdk.base.models.rtb.Template r9, java.lang.String r10, java.lang.Integer r11, com.sigmob.sdk.base.models.rtb.BiddingResponse r12) {
        /*
            r0 = 0
            if (r5 == 0) goto Ld1
            java.util.List<com.sigmob.sdk.base.models.rtb.MaterialMeta> r1 = r5.materials
            if (r1 == 0) goto Ld1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto Lf
            goto Ld1
        Lf:
            java.util.List<com.sigmob.sdk.base.models.rtb.MaterialMeta> r1 = r5.materials
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.sigmob.sdk.base.models.rtb.MaterialMeta r1 = (com.sigmob.sdk.base.models.rtb.MaterialMeta) r1
            if (r1 != 0) goto L1b
            return r0
        L1b:
            com.sigmob.sdk.base.models.BaseAdUnit r2 = new com.sigmob.sdk.base.models.BaseAdUnit     // Catch: java.lang.Throwable -> Lcb
            r2.<init>()     // Catch: java.lang.Throwable -> Lcb
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6d
            r2.create_time = r3     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = r5.adslot_id     // Catch: java.lang.Throwable -> L6d
            r2.adslot_id = r0     // Catch: java.lang.Throwable -> L6d
            java.lang.Integer r0 = r5.ad_type     // Catch: java.lang.Throwable -> L6d
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L6d
            r2.ad_type = r0     // Catch: java.lang.Throwable -> L6d
            r2.ad = r5     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = r5.crid     // Catch: java.lang.Throwable -> L6d
            r2.crid = r0     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = r5.camp_id     // Catch: java.lang.Throwable -> L6d
            r2.camp_id = r0     // Catch: java.lang.Throwable -> L6d
            r2.request_id = r6     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = r1.endcard_md5     // Catch: java.lang.Throwable -> L6d
            r2.endcard_md5 = r6     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = r1.video_md5     // Catch: java.lang.Throwable -> L6d
            r2.video_md5 = r6     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = r7.getLoadId()     // Catch: java.lang.Throwable -> L6d
            r2.load_id = r6     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = r5.ad_source_channel     // Catch: java.lang.Throwable -> L6d
            r2.ad_source_channel = r6     // Catch: java.lang.Throwable -> L6d
            java.lang.Integer r6 = r1.creative_type     // Catch: java.lang.Throwable -> L6d
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L6d
            com.sigmob.sdk.base.common.n r0 = com.sigmob.sdk.base.common.n.CreativeTypeVideo_Html_Snippet     // Catch: java.lang.Throwable -> L6d
            int r0 = r0.a()     // Catch: java.lang.Throwable -> L6d
            if (r6 == r0) goto L70
            java.lang.Integer r6 = r1.creative_type     // Catch: java.lang.Throwable -> L6d
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L6d
            com.sigmob.sdk.base.common.n r0 = com.sigmob.sdk.base.common.n.CreativeTypeVideo_transparent_html     // Catch: java.lang.Throwable -> L6d
            int r0 = r0.a()     // Catch: java.lang.Throwable -> L6d
            if (r6 != r0) goto L77
            goto L70
        L6d:
            r5 = move-exception
            r0 = r2
            goto Lcc
        L70:
            com.czhj.wire.okio.ByteString r6 = r1.html_snippet     // Catch: java.lang.Throwable -> L6d
            if (r6 == 0) goto L77
            r6.size()     // Catch: java.lang.Throwable -> L6d
        L77:
            r2.slotAdSetting = r8     // Catch: java.lang.Throwable -> L6d
            r2.adRequest = r7     // Catch: java.lang.Throwable -> L6d
            r2.scene = r9     // Catch: java.lang.Throwable -> L6d
            r2.uid = r10     // Catch: java.lang.Throwable -> L6d
            if (r11 == 0) goto L87
            int r6 = r11.intValue()     // Catch: java.lang.Throwable -> L6d
            r2.expiration_time = r6     // Catch: java.lang.Throwable -> L6d
        L87:
            com.sigmob.sdk.base.models.rtb.BiddingResponse r6 = r5.bidding_response     // Catch: java.lang.Throwable -> L6d
            if (r6 != 0) goto L8c
            goto L8d
        L8c:
            r12 = r6
        L8d:
            r2.bidding_response = r12     // Catch: java.lang.Throwable -> L6d
            java.lang.Boolean r6 = r8.use_downloaded_apk     // Catch: java.lang.Throwable -> L6d
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r6 = com.czhj.wire.Wire.get(r6, r7)     // Catch: java.lang.Throwable -> L6d
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L6d
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L6d
            r2.useDownloadedApk = r6     // Catch: java.lang.Throwable -> L6d
            initAdTrackerMap(r2)     // Catch: java.lang.Throwable -> L6d
            java.util.Map<java.lang.String, java.lang.String> r6 = r5.ad_track_macro     // Catch: java.lang.Throwable -> L6d
            if (r6 == 0) goto Laf
            com.sigmob.sdk.base.models.SigMacroCommon r6 = r2.getMacroCommon()     // Catch: java.lang.Throwable -> L6d
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.ad_track_macro     // Catch: java.lang.Throwable -> L6d
            r6.setServerMacroMap(r5)     // Catch: java.lang.Throwable -> L6d
        Laf:
            int r5 = r2.ad_type     // Catch: java.lang.Throwable -> L6d
            r6 = 5
            if (r5 != r6) goto Lca
            com.sigmob.sdk.base.models.rtb.ResponseNativeAd r5 = r2.getNativeAd()     // Catch: java.lang.Throwable -> L6d
            if (r5 == 0) goto Lca
            java.lang.Integer r5 = r5.type     // Catch: java.lang.Throwable -> L6d
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L6d
            r6 = 1
            if (r5 != r6) goto Lc7
            r2.getNativeVideo()     // Catch: java.lang.Throwable -> L6d
            return r2
        Lc7:
            r2.getImageUrlList()     // Catch: java.lang.Throwable -> L6d
        Lca:
            return r2
        Lcb:
            r5 = move-exception
        Lcc:
            java.lang.String r6 = "adUnit error"
            com.czhj.sdk.logger.SigmobLog.e(r6, r5)
        Ld1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.models.BaseAdUnit.adUnit(com.sigmob.sdk.base.models.rtb.Ad, java.lang.String, com.sigmob.sdk.base.models.LoadAdRequest, com.sigmob.sdk.base.models.rtb.SlotAdSetting, com.sigmob.sdk.base.models.rtb.Template, java.lang.String, java.lang.Integer, com.sigmob.sdk.base.models.rtb.BiddingResponse):com.sigmob.sdk.base.models.BaseAdUnit");
    }

    private static boolean checkFileMD5(String str, String str2) {
        String fileMd5 = Md5Util.fileMd5(str);
        StringBuilder BChYOn2 = A2egSU.BChYOn("path: [ ", str, " ] calc [ ", fileMd5, " ] origin ");
        BChYOn2.append(str2);
        SigmobLog.d(BChYOn2.toString());
        return fileMd5 != null && fileMd5.equalsIgnoreCase(str2);
    }

    public static List<ai> createTrackersForUrls(List<String> list, String str, String str2, Integer num) {
        Preconditions.NoThrow.checkNotNull(list);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ai aiVar = new ai(it.next(), str, str2);
            aiVar.setRetryNum(num);
            arrayList.add(aiVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAppSize() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy != null && (map = adPrivacy.privacy_template_info) != null) {
            String str = map.get("app_size");
            if (o.a((CharSequence) str)) {
                return 0;
            }
            try {
                return Integer.parseInt(str);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

    public static String getTAG() {
        return TAG;
    }

    private static void initAdTrackerMap(BaseAdUnit baseAdUnit) {
        List<Tracking> ad_tracking = baseAdUnit.getAd_tracking();
        baseAdUnit.adTrackersMap = new HashMap<>();
        for (Tracking tracking : ad_tracking) {
            String str = tracking.tracking_event_type;
            baseAdUnit.adTrackersMap.put(str, createTrackersForUrls(tracking.tracking_url, str, baseAdUnit.request_id, Integer.valueOf(baseAdUnit.getTrackingRetryNum())));
        }
    }

    public void addRedirectCount(Uri uri) {
        if (uri == null || uri.getScheme() == null) {
            return;
        }
        String AlLFFp2 = CtFAbx.AlLFFp(uri.getScheme(), ":", uri.getHost());
        int redirectCount = getRedirectCount(uri) + 1;
        synchronized (this) {
            try {
                if (this.mRedirectCountMap == null) {
                    this.mRedirectCountMap = new HashMap<>();
                }
                this.mRedirectCountMap.put(AlLFFp2, Integer.valueOf(redirectCount));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Boolean allowClickToAutoClose() {
        InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
        if (newInterstitialSetting == null) {
            return null;
        }
        return newInterstitialSetting.click_close_ad;
    }

    public Integer allowCountdownEndsClose() {
        InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
        if (newInterstitialSetting == null) {
            return null;
        }
        return newInterstitialSetting.seconds_close_ad;
    }

    public boolean canInstall(String str) {
        boolean z = (!o.b(getApkMd5()) && getDownloadTask() == null && getDownloadId() == null) ? false : true;
        if (canUseDownloadApk() && !o.a((CharSequence) str) && z) {
            Context e = b.e();
            File file = new File(k.a(e), str);
            if (file.exists() && ClientMetadata.getPackageInfoWithUri(e, file.getAbsolutePath()) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean canOpen() {
        return com.sigmob.sdk.base.o.a().b(o.a((CharSequence) this.apkPackageName) ? getProductId() : this.apkPackageName).booleanValue();
    }

    public boolean canUseDownloadApk() {
        return this.useDownloadedApk;
    }

    public boolean checkEndCardZipValid() {
        if (o.a((CharSequence) getEndcard_url()) || o.a((CharSequence) this.endcard_md5)) {
            return true;
        }
        return checkFileMD5(getEndCardZipPath(), getEndcard_md5());
    }

    public boolean checkVideoValid() {
        if (o.a((CharSequence) getVideo_url()) || o.a((CharSequence) this.video_md5)) {
            return true;
        }
        return checkFileMD5(getVideoPath(), getVideo_OriginMD5());
    }

    public void destroy() {
        i iVar = this.adConfig;
        if (iVar != null) {
            iVar.k();
            this.adConfig = null;
        }
        ah ahVar = this.mSessionManager;
        if (ahVar != null) {
            ahVar.a();
        }
    }

    public void dislikeReport() {
        this.isDislikeReported = true;
    }

    public boolean enableDetectPkg() {
        return com.sigmob.sdk.base.o.a().N().booleanValue();
    }

    public boolean enableDevToRender(int i) {
        Widget widget = getWidget(i);
        if (widget == null) {
            return false;
        }
        return widget.enable_developer_render.booleanValue();
    }

    public Boolean enableSmallWindow() {
        Ad ad = getAd();
        if (ad == null) {
            return null;
        }
        return ad.enable_small_window;
    }

    public void enableUseDownloadApk(boolean z) {
        this.useDownloadedApk = z;
    }

    public boolean enableWidgetInteraction() {
        NativeAdSetting nativeAdSetting = getNativeAdSetting();
        if (nativeAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(nativeAdSetting.enable_advanced_interaction, Boolean.FALSE)).booleanValue();
    }

    public boolean enable_full_click() {
        SplashAdSetting splashAdSetting = getSplashAdSetting();
        if (splashAdSetting == null) {
            return false;
        }
        return splashAdSetting.enable_full_click.booleanValue();
    }

    public boolean expiredAdCanReload() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(adSetting.can_expire_reload, Boolean.FALSE)).booleanValue();
    }

    public int expiredAdReloadNum() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.expire_reload_count, 0)).intValue();
    }

    public Ad getAd() {
        return this.ad;
    }

    public AdAppInfo getAdAppInfo() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (this.adAppInfo == null && adPrivacy != null) {
            try {
                this.adAppInfo = new AdAppInfo() { // from class: com.sigmob.sdk.base.models.BaseAdUnit.1
                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getAppName() {
                        return BaseAdUnit.this.getPrivacyAppName();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public int getAppSize() {
                        return BaseAdUnit.this.getAppSize();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getAuthorName() {
                        return BaseAdUnit.this.getCompanyName();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getDescription() {
                        return BaseAdUnit.this.getDescription();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getDescriptionUrl() {
                        return BaseAdUnit.this.getDescriptionUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPermissions() {
                        return BaseAdUnit.this.getPermissions();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPermissionsUrl() {
                        return BaseAdUnit.this.getPermissionsUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPrivacyAgreement() {
                        return BaseAdUnit.this.getPrivacyAgreement();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPrivacyAgreementUrl() {
                        return BaseAdUnit.this.getPrivacyAgreementUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getVersionName() {
                        return BaseAdUnit.this.getAppVersion();
                    }

                    public String toString() {
                        return String.format(Locale.getDefault(), "appName %s \n AuthorName %s \n  versionName %s \n permissionsUrl %s \n permissions %s \nprivacyAgreementUrl %s \n privacyAgreement %s \n descriptionUrl %s \n description %s \n  appsize %d", getAppName(), getAuthorName(), getVersionName(), getPermissionsUrl(), getPermissions(), getPrivacyAgreementUrl(), getPrivacyAgreement(), getDescriptionUrl(), getDescription(), Integer.valueOf(getAppSize()));
                    }
                };
            } catch (Throwable unused) {
            }
        }
        return this.adAppInfo;
    }

    public i getAdConfig() {
        i d;
        if (this.adConfig == null) {
            switch (getAd_type()) {
                case 1:
                case 4:
                    d = a.d(this);
                    break;
                case 2:
                    d = com.sigmob.sdk.splash.a.d(this);
                    break;
                case 3:
                case 6:
                    d = com.sigmob.sdk.newInterstitial.d.d(this);
                    break;
                case 5:
                    d = e.d(this);
                    break;
            }
            this.adConfig = d;
            return d;
        }
        return this.adConfig;
    }

    public Integer getAdExpiredTime() {
        Integer num;
        Ad ad = this.ad;
        return Integer.valueOf((ad == null || (num = ad.expired_time) == null) ? 0 : num.intValue() * 1000);
    }

    public List<LinkAction> getAdLinkActions() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return null;
        }
        return adSetting.link_actions;
    }

    public String getAdLogo() {
        return getAd_source_logo();
    }

    public double getAdPercent() {
        double d = this.adPercent;
        if (d > 0.0d) {
            return d;
        }
        double d2 = this.realAdPercent;
        if (d2 > 0.0d) {
            return d2;
        }
        return 1.7777777910232544d;
    }

    public File getAdPrivacyTemplateFile() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null) {
            return null;
        }
        String str = adPrivacy.privacy_template_url;
        if (o.a((CharSequence) str)) {
            return null;
        }
        String md5 = Md5Util.md5(str);
        return k.a(k.d(k.b), md5 + ".html");
    }

    public LoadAdRequest getAdRequest() {
        return this.adRequest;
    }

    public AdSetting getAdSetting() {
        Ad ad = this.ad;
        if (ad == null) {
            return null;
        }
        return ad.ad_setting;
    }

    public List<ai> getAdTracker(String str) {
        HashMap<String, List<ai>> hashMap = this.adTrackersMap;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public String getAd_scene_desc() {
        return this.ad_scene_desc;
    }

    public String getAd_scene_id() {
        return this.ad_scene_id;
    }

    public String getAd_source_channel() {
        return this.ad_source_channel;
    }

    public String getAd_source_logo() {
        Ad ad = this.ad;
        if (ad == null) {
            return null;
        }
        return ad.ad_source_logo;
    }

    public List<Tracking> getAd_tracking() {
        Ad ad = this.ad;
        if (ad == null) {
            return null;
        }
        return ad.ad_tracking;
    }

    public int getAd_type() {
        return this.ad_type;
    }

    public String getAdslot_id() {
        return this.adslot_id;
    }

    public String getAdxEncPrice() {
        BiddingResponse biddingResponse = this.bidding_response;
        return biddingResponse == null ? "" : (String) Wire.get(biddingResponse.price_for_ssp_enc, "");
    }

    public int getAdxPrice() {
        BiddingResponse biddingResponse = this.bidding_response;
        if (biddingResponse == null) {
            return 0;
        }
        return ((Integer) Wire.get(biddingResponse.price_for_ssp, 0)).intValue();
    }

    public String getAdx_id() {
        return this.adx_id;
    }

    public AndroidMarket getAndroidMarket() {
        AndroidMarket androidMarket;
        MaterialMeta material = getMaterial();
        AndroidMarket androidMarket2 = material != null ? material.android_market : null;
        return (androidMarket2 != null || (androidMarket = this.mCustomAndroidMarket) == null) ? androidMarket2 : androidMarket;
    }

    public int getApkDownloadType() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(slotAdSetting.apk_download_type, 0)).intValue();
    }

    public String getApkMd5() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return (String) Wire.get(material.apk_md5, null);
    }

    public String getApkName() {
        return this.apkName;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public String getAppName() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.app_name;
    }

    public String getAppVersion() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get(n.r);
    }

    public int getBP() {
        Ad ad = this.ad;
        if (ad == null) {
            return 0;
        }
        return ((Integer) Wire.get(ad.bid_price, 0)).intValue();
    }

    public int getBidEcpm() {
        BiddingResponse biddingResponse = this.bidding_response;
        if (biddingResponse == null) {
            return 0;
        }
        return ((Integer) Wire.get(biddingResponse.ecpm, 0)).intValue();
    }

    public String getBid_token() {
        return this.bid_token;
    }

    public int getButtonColor() {
        Color color;
        MaterialMeta material = getMaterial();
        return (material == null || (color = material.button_color) == null) ? android.graphics.Color.parseColor("#FF5A57") : android.graphics.Color.argb((int) (color.alpha.floatValue() * 255.0f), material.button_color.red.intValue(), material.button_color.green.intValue(), material.button_color.blue.intValue());
    }

    public String getCTAText() {
        MaterialMeta material = getMaterial();
        String str = material != null ? material.button_text : null;
        return o.b(str) ? str : getInteractionType() != 2 ? "查看详情" : "立即下载";
    }

    public String getCamp_id() {
        return this.camp_id;
    }

    public int getChargePercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.charge_percent, 0)).intValue();
    }

    public int getChargeSeconds() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.charge_seconds, 0)).intValue();
    }

    public ClickAreaSetting getClickAreaSetting() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return null;
        }
        ClickAreaSetting clickAreaSetting = rvAdSetting.click_setting;
        if (clickAreaSetting != null) {
            return clickAreaSetting;
        }
        ClickAreaSetting.Builder builder = new ClickAreaSetting.Builder();
        builder.bottom = Float.valueOf(0.1f);
        builder.right = Float.valueOf(0.1f);
        builder.top = Float.valueOf(0.1f);
        builder.left = Float.valueOf(0.1f);
        return builder.build();
    }

    public ClickCommon getClickCommon() {
        if (this.clickCommon == null) {
            this.clickCommon = new ClickCommon();
        }
        return this.clickCommon;
    }

    public int getClickType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return ((Integer) Wire.get(material.click_type, 0)).intValue();
    }

    public String getCloseCardHtmlData() {
        ByteString byteString;
        MaterialMeta material = getMaterial();
        if (material == null || (byteString = material.closecard_html_snippet) == null || byteString.size() < 10) {
            return null;
        }
        return material.closecard_html_snippet.utf8();
    }

    public String getCompanyName() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_company");
    }

    public int getConfirmDialog() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.confirm_dialog, 0)).intValue();
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public n.b getCreativeResourceType() {
        return (o.b(getEndcard_url()) && (getCreativeType() == com.sigmob.sdk.base.common.n.CreativeTypeVideo_Tar.a() || getCreativeType() == com.sigmob.sdk.base.common.n.CreativeTypeVideo_Tar_Companion.a())) ? n.b.NATIVE_RESOURCE : o.b(getHtmlData()) ? n.b.HTML_RESOURCE : o.b(getHtmlUrl()) ? n.b.URL_RESOURCE : n.b.NATIVE_RESOURCE;
    }

    public String getCreativeTitle() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.creative_title;
    }

    public int getCreativeType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.creative_type.intValue();
    }

    public String getCrid() {
        return this.crid;
    }

    public Uri getDeeplinkUri() {
        return this.deeplinkUri;
    }

    public String getDeeplinkUrl() {
        MaterialMeta material = getMaterial();
        String str = material != null ? material.deeplink_url : null;
        return (o.a((CharSequence) str) && o.b(this.mCustomDeeplink)) ? this.mCustomDeeplink : str;
    }

    public String getDesc() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.desc;
    }

    public String getDescription() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_func");
    }

    public String getDescriptionUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_func_url");
    }

    public boolean getDisableAutoLoad() {
        Boolean bool;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return false;
            }
            bool = newInterstitialSetting.disable_auto_load;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return false;
            }
            bool = rvAdSetting.disable_auto_load;
        }
        return bool.booleanValue();
    }

    public int getDisplay_orientation() {
        Ad ad = getAd();
        if (ad == null) {
            return 0;
        }
        return ((Integer) Wire.get(ad.display_orientation, 0)).intValue();
    }

    public Long getDownloadId() {
        return this.downloadId;
    }

    public List<d> getDownloadQuarterTrack() {
        return this.download_trackers;
    }

    public f getDownloadTask() {
        return this.downloadTask;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getDuration() {
        int endTime = getEndTime();
        if (endTime > 0) {
            return endTime * 1000;
        }
        return 33333;
    }

    public boolean getEnableDeeplinkAndLandingPage() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(slotAdSetting.enable_deeplink_and_landing_page, Boolean.FALSE)).booleanValue();
    }

    public String getEndCardDirPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(k.b());
        sb.append("/" + getEndcard_md5() + "/");
        return sb.toString();
    }

    public String getEndCardImageUrl() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.endcard_image_src;
    }

    public String getEndCardIndexPath() {
        return getEndCardDirPath() + "endcard.html";
    }

    public String getEndCardZipPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(k.b());
        sb.append("/" + this.endcard_md5 + ".tgz");
        return sb.toString();
    }

    public String getEndCard_OriginMD5() {
        return this.endcard_md5;
    }

    public int getEndTime() {
        RvAdSetting rvAdSetting;
        if (this.ad_type == 6 || (rvAdSetting = getRvAdSetting()) == null) {
            return 0;
        }
        return rvAdSetting.end_time.intValue();
    }

    public int getEndcardCloseImage() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return rvAdSetting.endcard_close_image.intValue();
    }

    public String getEndcard_md5() {
        return o.b(this.endcard_md5) ? this.endcard_md5 : Md5Util.md5(getCrid());
    }

    public String getEndcard_url() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.endcard_url;
    }

    public float getFinishedTime() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 1.0f;
        }
        return rvAdSetting.finished.floatValue();
    }

    public int getFloor() {
        NativeAdSetting nativeAdSetting = getNativeAdSetting();
        if (nativeAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(nativeAdSetting.media_expected_floor, 0)).intValue();
    }

    public List<FrequencyControl> getFrequencyControl() {
        Ad ad;
        if (o.b(this.bid_token) || (ad = getAd()) == null) {
            return null;
        }
        return ad.frequency_control;
    }

    public boolean getFullClickOnVideo() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return false;
        }
        return rvAdSetting.full_click_on_video.booleanValue();
    }

    public String getHtmlData() {
        ByteString byteString;
        MaterialMeta material = getMaterial();
        if (material == null || (byteString = material.html_snippet) == null || byteString.size() < 10) {
            return null;
        }
        return material.html_snippet.utf8();
    }

    public String getHtmlUrl() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.html_url;
    }

    public String getIconUrl() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.icon_url;
    }

    public List<SigImage> getImageUrlList() {
        ResponseNativeAd nativeAd = getNativeAd();
        if (this.imageUrlList == null) {
            ArrayList arrayList = new ArrayList();
            this.imageUrlList = arrayList;
            if (nativeAd == null) {
                return arrayList;
            }
            if (nativeAd.type.intValue() == 1) {
                return this.imageUrlList;
            }
            Iterator<ResponseAsset> it = nativeAd.assets.iterator();
            while (it.hasNext()) {
                ResponseAssetImage responseAssetImage = it.next().image;
                if (responseAssetImage != null) {
                    SigImage sigImage = new SigImage(responseAssetImage.url, responseAssetImage.w.intValue(), responseAssetImage.h.intValue());
                    if (this.adPercent < 0.0d && responseAssetImage.w.intValue() > 0 && responseAssetImage.h.intValue() > 0) {
                        this.adPercent = (responseAssetImage.w.intValue() * 1.0f) / responseAssetImage.h.intValue();
                    }
                    this.imageUrlList.add(sigImage);
                }
            }
        }
        return this.imageUrlList;
    }

    public int getInteractionType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 1;
        }
        return material.interaction_type.intValue();
    }

    public boolean getInvisibleAdLabel() {
        RvAdSetting rvAdSetting;
        Boolean bool;
        int ad_type = getAd_type();
        if (ad_type == 2) {
            SplashAdSetting splashAdSetting = getSplashAdSetting();
            if (splashAdSetting == null) {
                return false;
            }
            bool = splashAdSetting.invisible_ad_label;
        } else {
            if ((ad_type != 1 && ad_type != 4) || (rvAdSetting = getRvAdSetting()) == null) {
                return false;
            }
            bool = rvAdSetting.invisible_ad_label;
        }
        return bool.booleanValue();
    }

    public int getIsMute() {
        Integer num;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return 0;
            }
            num = newInterstitialSetting.if_mute;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return 0;
            }
            num = rvAdSetting.if_mute;
        }
        return num.intValue();
    }

    public String getLandUrl() {
        return this.landUrl;
    }

    public String getLanding_page() {
        MaterialMeta material = getMaterial();
        String str = material == null ? null : material.landing_page;
        return (o.a((CharSequence) str) && o.b(this.mCustomLandPageUrl)) ? this.mCustomLandPageUrl : str;
    }

    public String getLoad_id() {
        return this.load_id;
    }

    public SigMacroCommon getMacroCommon() {
        if (this.macroCommon == null) {
            this.macroCommon = new SigMacroCommon();
            String video_url = getVideo_url();
            if (o.b(video_url)) {
                try {
                    String encode = URLEncoder.encode(video_url, "UTF-8");
                    if (o.b(encode)) {
                        this.macroCommon.addMarcoKey(SigMacroCommon._VURL_, encode);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.macroCommon;
    }

    public String getMainImage() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.image_src;
    }

    public List<String> getMarketPackageNameList() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.market_package_name;
    }

    public MaterialMeta getMaterial() {
        List<MaterialMeta> list;
        Ad ad = this.ad;
        if (ad == null || (list = ad.materials) == null || list.isEmpty()) {
            return null;
        }
        return this.ad.materials.get(0);
    }

    public int getMraidInteractionType() {
        return this.mraidInteractionType;
    }

    public ResponseNativeAd getNativeAd() {
        List<MaterialMeta> list;
        Ad ad = this.ad;
        if (ad == null || (list = ad.materials) == null || list.isEmpty()) {
            return null;
        }
        return this.ad.materials.get(0).native_ad;
    }

    public NativeAdSetting getNativeAdSetting() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.native_setting;
    }

    public SigVideo getNativeVideo() {
        ResponseNativeAd nativeAd = getNativeAd();
        if (this.nativeVideo == null) {
            if (nativeAd == null) {
                return null;
            }
            if (nativeAd.type.intValue() == 1) {
                for (ResponseAsset responseAsset : nativeAd.assets) {
                    ResponseAssetVideo responseAssetVideo = responseAsset.video;
                    if (responseAssetVideo != null) {
                        if (this.nativeVideo == null) {
                            this.nativeVideo = new SigVideo();
                        }
                        SigVideo sigVideo = this.nativeVideo;
                        sigVideo.url = responseAssetVideo.url;
                        sigVideo.height = responseAssetVideo.h.intValue();
                        this.nativeVideo.width = responseAssetVideo.w.intValue();
                        if (this.adPercent < 0.0d && responseAssetVideo.h.intValue() > 0 && responseAssetVideo.w.intValue() > 0) {
                            this.adPercent = (responseAssetVideo.w.intValue() * 1.0f) / responseAssetVideo.h.intValue();
                        }
                    }
                    ResponseAssetImage responseAssetImage = responseAsset.image;
                    if (responseAssetImage != null) {
                        if (this.nativeVideo == null) {
                            this.nativeVideo = new SigVideo();
                        }
                        this.nativeVideo.thumbUrl = responseAssetImage.url;
                    }
                }
            }
        }
        return this.nativeVideo;
    }

    public InterstitialSetting getNewInterstitialSetting() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.interstitial_setting;
    }

    public String getOriginVid() {
        return this.originVid;
    }

    public String getPermissions() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_permission");
    }

    public String getPermissionsUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_permission_url");
    }

    public int getPlayMode() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.play_mode.intValue();
    }

    public String getPrivacyAgreement() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_privacy_text");
    }

    public String getPrivacyAgreementUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_privacy_url");
    }

    public String getPrivacyAppName() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_name");
    }

    public String getProductId() {
        Ad ad = getAd();
        if (ad == null) {
            return null;
        }
        return ad.product_id;
    }

    public String getProxyVideoUrl() {
        String video_url = getVideo_url();
        return o.a((CharSequence) video_url) ? video_url : h.d().a(video_url);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[Catch: all -> 0x003a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x003a, blocks: (B:8:0x0004, B:11:0x000b, B:15:0x002d, B:17:0x0033, B:18:0x0037, B:22:0x0051, B:26:0x003c, B:28:0x0042, B:29:0x0049), top: B:7:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int getRedirectCount(android.net.Uri r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 == 0) goto L59
            java.lang.String r1 = r5.getScheme()     // Catch: java.lang.Throwable -> L3a
            if (r1 != 0) goto Lb
            goto L59
        Lb:
            java.lang.String r1 = r5.getScheme()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = r5.getHost()     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r2.<init>()     // Catch: java.lang.Throwable -> L3a
            r2.append(r1)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = ":"
            r2.append(r1)     // Catch: java.lang.Throwable -> L3a
            r2.append(r5)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L3a
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r4.mRedirectCountMap     // Catch: java.lang.Throwable -> L3a
            if (r1 != 0) goto L2d
            monitor-exit(r4)
            return r0
        L2d:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L3a
            r3 = 24
            if (r2 < r3) goto L3c
            java.lang.Object r5 = com.google.android.material.datepicker.BPw6Q8.ARc23Z(r5, r1)     // Catch: java.lang.Throwable -> L3a
        L37:
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> L3a
            goto L4d
        L3a:
            r5 = move-exception
            goto L57
        L3c:
            boolean r1 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L49
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r4.mRedirectCountMap     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r5 = r1.get(r5)     // Catch: java.lang.Throwable -> L3a
            goto L37
        L49:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L3a
        L4d:
            if (r5 != 0) goto L51
            monitor-exit(r4)
            return r0
        L51:
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r4)
            return r5
        L57:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3a
            throw r5
        L59:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.models.BaseAdUnit.getRedirectCount(android.net.Uri):int");
    }

    public String getRequestId() {
        return this.request_id;
    }

    public int getRequestSceneType() {
        return this.requestSceneType;
    }

    public int getRewardPercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.reward_percent, 0)).intValue();
    }

    public int getRewardSeconds() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.reward_seconds, 0)).intValue();
    }

    public int getRewardStyle() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.reward_style, 0)).intValue();
    }

    public RvAdSetting getRvAdSetting() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.rv_setting;
    }

    public String getRvCallBackUrl() {
        return this.rv_callback_url;
    }

    public Template getScene() {
        return this.scene;
    }

    public int getSensitivity() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.sensitivity, 0)).intValue();
    }

    public ah getSessionManager() {
        return this.mSessionManager;
    }

    public int getShakeCount() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.shake_count, 0)).intValue();
    }

    public int getShakeTimeThreshold() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.shake_time_threshold, 0)).intValue();
    }

    public int getShakeTriggerType() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.shake_trigger_type, 0)).intValue();
    }

    public SingleNativeAdSetting getSingleNativeSetting() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return null;
        }
        return adSetting.single_native_setting;
    }

    public int getSkipPercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return -1;
        }
        return ((Integer) Wire.get(rvAdSetting.skip_percent, 0)).intValue();
    }

    public int getSkipSeconds() {
        Integer num;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return -1;
            }
            num = newInterstitialSetting.show_skip_seconds;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return -1;
            }
            num = (Integer) Wire.get(rvAdSetting.skip_seconds, 0);
        }
        return num.intValue();
    }

    public List<LinkAction> getSlotAdLinkActions() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.link_actions;
    }

    public SlotAdSetting getSlotAdSetting() {
        return this.slotAdSetting;
    }

    public SplashAdSetting getSplashAdSetting() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.splash_setting;
    }

    public String getSplashFilePath() {
        StringBuilder sb;
        String str;
        if (com.sigmob.sdk.base.common.n.CreativeTypeSplashVideo.a() == getMaterial().creative_type.intValue()) {
            sb = new StringBuilder();
            sb.append(k.e());
            sb.append(File.separator);
            str = getMaterial().video_url;
        } else {
            sb = new StringBuilder();
            sb.append(k.e());
            sb.append(File.separator);
            str = getMaterial().image_src;
        }
        sb.append(Md5Util.md5(str));
        return sb.toString();
    }

    public String getSplashURL() {
        return com.sigmob.sdk.base.common.n.CreativeTypeSplashVideo.a() == getMaterial().creative_type.intValue() ? getMaterial().video_url : getMaterial().image_src;
    }

    public int getTemplateId() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.template_id.intValue();
    }

    public int getTemplateType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.template_type.intValue();
    }

    public String getTitle() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.title;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public int getTrackingRetryNum() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(slotAdSetting.retry_count, 0)).intValue();
    }

    public String getUuid() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID().toString();
        }
        return this.uuid;
    }

    public String getVid() {
        Ad ad = getAd();
        if (ad == null) {
            return null;
        }
        return ad.vid;
    }

    public VideoStatusCommon getVideoCommon() {
        if (this.videoCommon == null) {
            this.videoCommon = new VideoStatusCommon();
        }
        return this.videoCommon;
    }

    public String getVideoCoverImageUrl() {
        SigVideo sigVideo = this.nativeVideo;
        if (sigVideo == null) {
            return null;
        }
        return sigVideo.thumbUrl;
    }

    public boolean getVideoErrorReward() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(rvAdSetting.video_error_reward, Boolean.FALSE)).booleanValue();
    }

    public String getVideoPath() {
        File videoProxyFile = getVideoProxyFile();
        if (videoProxyFile == null) {
            return null;
        }
        return videoProxyFile.getAbsolutePath();
    }

    public File getVideoProxyFile() {
        String video_url = getVideo_url();
        if (o.a((CharSequence) video_url)) {
            return null;
        }
        return h.d().c(video_url);
    }

    public String getVideoTmpPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(k.a());
        sb.append("/" + getVideo_md5() + ".mp4.tmp");
        return sb.toString();
    }

    public String getVideo_OriginMD5() {
        return this.video_md5;
    }

    public String getVideo_md5() {
        return o.b(this.video_md5) ? this.video_md5 : Md5Util.md5(getVideo_url());
    }

    public String getVideo_url() {
        List<MaterialMeta> list;
        String str;
        Ad ad = this.ad;
        if (ad == null || (list = ad.materials) == null || list.isEmpty()) {
            return null;
        }
        if (this.ad_type == 5) {
            SigVideo nativeVideo = getNativeVideo();
            if (nativeVideo == null) {
                return null;
            }
            str = nativeVideo.url;
        } else {
            MaterialMeta materialMeta = this.ad.materials.get(0);
            if (materialMeta == null) {
                return null;
            }
            str = materialMeta.video_url;
        }
        return StringUtil.getUrl(str);
    }

    public WXProgramRes getWXProgramRes() {
        WXProgramRes wXProgramRes;
        Ad ad = getAd();
        if (ad == null || (wXProgramRes = ad.wx_program_res) == null) {
            return null;
        }
        return wXProgramRes;
    }

    public Widget getWidget(int i) {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        List<Widget> list = material.Widget_list;
        if (!com.sigmob.sdk.base.utils.e.a(list) && com.sigmob.sdk.base.utils.e.a(i, list.size())) {
            return list.get(i);
        }
        return null;
    }

    public long getWidgetId(int i) {
        Widget widget = getWidget(i);
        if (widget == null) {
            return 0L;
        }
        return widget.widget_id.longValue();
    }

    public int getWidgetIntervalTime() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.widget_interval_time, 0)).intValue();
    }

    public AdPrivacy getadPrivacy() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.ad_privacy;
    }

    public int getsubInteractionType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.sub_interaction_type.intValue();
    }

    public boolean hasEndCard() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return false;
        }
        return material.has_endcard.booleanValue();
    }

    public boolean isCatchVideo() {
        return this.catchVideo;
    }

    public boolean isClickAutoCloseSplash() {
        return false;
    }

    public boolean isDisable_download_listener() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(adSetting.disable_download_listener, Boolean.FALSE)).booleanValue();
    }

    public boolean isDisablexRequestWith() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(slotAdSetting.disable_x_requested_with, Boolean.FALSE)).booleanValue();
    }

    public boolean isDislikeReported() {
        return this.isDislikeReported;
    }

    public boolean isDownloadDialog() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return false;
        }
        return material.download_dialog.booleanValue();
    }

    public boolean isEndCardIndexExist() {
        if (!o.b(getEndcard_url())) {
            return true;
        }
        if (getCreativeType() == com.sigmob.sdk.base.common.n.CreativeTypeVideo_Tar.a() || getCreativeType() == com.sigmob.sdk.base.common.n.CreativeTypeVideo_Tar_Companion.a()) {
            return new File(getEndCardIndexPath()).exists();
        }
        return true;
    }

    public boolean isExpiredAd() {
        long intValue = getAdExpiredTime().intValue();
        return (intValue == 0 || this.create_time == 0 || System.currentTimeMillis() - this.create_time < intValue) ? false : true;
    }

    public boolean isHalfInterstitial() {
        return this.isHalfInterstitial;
    }

    public boolean isNativeAdH5() {
        return true;
    }

    public boolean isRecord() {
        return this.record;
    }

    public boolean isResumableDownload() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(slotAdSetting.resumable_download, Boolean.FALSE)).booleanValue();
    }

    public boolean isSkipSigmobBrowser() {
        AdSetting adSetting = getAdSetting();
        return (adSetting == null || ((Boolean) Wire.get(adSetting.in_app, Boolean.FALSE)).booleanValue()) ? false : true;
    }

    public boolean isUse_floating_btn() {
        SplashAdSetting splashAdSetting = getSplashAdSetting();
        if (splashAdSetting == null) {
            return false;
        }
        return splashAdSetting.use_floating_btn.booleanValue();
    }

    public boolean isValid(int i) {
        return (i == 1 && o.b(getDeeplinkUrl())) || i == 9;
    }

    public boolean isVideoExist() {
        if (o.a((CharSequence) getVideo_url())) {
            return true;
        }
        String videoPath = getVideoPath();
        boolean BPw6Q82 = com.bykv.vk.component.ttvideo.player.A2egSU.BPw6Q8(videoPath);
        SigmobLog.d("isVideoExist path :" + videoPath + " isExist: " + BPw6Q82);
        return BPw6Q82;
    }

    public boolean noHasDownloadDialog() {
        return ((getInteractionType() == 2 || getInteractionType() == 3) && getadPrivacy() != null && isDownloadDialog()) ? false : true;
    }

    public String resourcePath() {
        return (o.b(getEndcard_url()) && (getCreativeType() == com.sigmob.sdk.base.common.n.CreativeTypeVideo_Tar.a() || getCreativeType() == com.sigmob.sdk.base.common.n.CreativeTypeVideo_Tar_Companion.a())) ? getEndCardIndexPath() : o.b(getHtmlData()) ? getHtmlData() : getHtmlUrl();
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public void setAdSize(int i, int i2) {
        this.adWidth = i;
        this.adHeight = i2;
        getMacroCommon().addMarcoKey(SigMacroCommon._WIDTH_, String.valueOf(i));
        getMacroCommon().addMarcoKey(SigMacroCommon._HEIGHT_, String.valueOf(i2));
    }

    public void setAd_scene_desc(String str) {
        this.ad_scene_desc = str;
    }

    public void setAd_scene_id(String str) {
        this.ad_scene_id = str;
    }

    public void setAd_source_channel(String str) {
        this.ad_source_channel = str;
    }

    public void setAd_type(int i) {
        this.ad_type = i;
    }

    public void setAdslot_id(String str) {
        this.adslot_id = str;
    }

    public void setAdx_id(String str) {
        this.adx_id = str;
    }

    public void setApkName(String str) {
        this.apkName = str;
    }

    public void setApkPackageName(String str) {
        this.apkPackageName = str;
    }

    public void setBid_token(String str) {
        this.bid_token = str;
    }

    public void setCamp_id(String str) {
        this.camp_id = str;
    }

    public void setCatchVideo(boolean z) {
        this.catchVideo = z;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void setCrid(String str) {
        this.crid = str;
    }

    public void setCustomAndroidMarket(AndroidMarket androidMarket) {
        this.mCustomAndroidMarket = androidMarket;
    }

    public void setCustomDeeplink(String str) {
        this.mCustomDeeplink = str;
    }

    public void setCustomLandPageUrl(String str) {
        this.mCustomLandPageUrl = str;
    }

    public void setDeeplinkUri(Uri uri) {
        this.deeplinkUri = uri;
    }

    public void setDownloadId(Long l) {
        this.downloadId = l;
    }

    public void setDownloadQuarterTrack(List<d> list) {
        this.download_trackers = list;
    }

    public void setDownloadTask(f fVar) {
        this.downloadTask = fVar;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setEndcard_md5(String str) {
        this.endcard_md5 = str;
    }

    public void setHalfInterstitial(boolean z) {
        this.isHalfInterstitial = z;
    }

    public void setLoad_id(String str) {
        this.load_id = str;
    }

    public void setMacroCommon(SigMacroCommon sigMacroCommon) {
        this.macroCommon = sigMacroCommon;
    }

    public void setMraidInteractionType(int i) {
        this.mraidInteractionType = i;
    }

    public void setOriginVid(String str) {
        this.originVid = str;
    }

    public void setRecord(boolean z) {
        this.record = z;
    }

    public void setRequestSceneType(int i) {
        this.requestSceneType = i;
    }

    public void setRequest_id(String str) {
        this.request_id = str;
    }

    public void setRvCallBackUrl(String str) {
        this.rv_callback_url = str;
    }

    public void setSessionManager(ah ahVar) {
        this.mSessionManager = ahVar;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUrl(String str) {
        this.landUrl = str;
    }

    public void setVideo_md5(String str) {
        this.video_md5 = str;
    }

    public void updateRealAdPercent(double d) {
        this.realAdPercent = d;
    }

    public boolean enableSmallWindow(Integer num) {
        int interactionType = num == null ? getInteractionType() : num.intValue();
        Boolean enableSmallWindow = enableSmallWindow();
        return enableSmallWindow != null && isValid(interactionType) && enableSmallWindow.booleanValue();
    }
}
