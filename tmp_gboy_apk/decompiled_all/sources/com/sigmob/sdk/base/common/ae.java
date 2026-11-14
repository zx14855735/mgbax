package com.sigmob.sdk.base.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Base64;
import android.view.MotionEvent;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.DownloadItem;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityClick;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmobSuper;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ae {

    /* renamed from: com.sigmob.sdk.base.common.ae$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f13102a;
        final /* synthetic */ String b;
        final /* synthetic */ BaseAdUnit c;
        final /* synthetic */ PackageInfo d;

        public AnonymousClass1(String str, String str2, BaseAdUnit baseAdUnit, PackageInfo packageInfo) {
            this.f13102a = str;
            this.b = str2;
            this.c = baseAdUnit;
            this.d = packageInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(PackageInfo packageInfo, Object obj) {
            boolean canRequestPackageInstalls;
            if (obj instanceof PointEntitySigmob) {
                Context e = com.sigmob.sdk.b.e();
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        canRequestPackageInstalls = e.getPackageManager().canRequestPackageInstalls();
                        options.put(com.sigmob.sdk.base.n.t, canRequestPackageInstalls ? "1" : Constants.FAIL);
                    } catch (Throwable th) {
                        SigmobLog.e(th.getMessage());
                    }
                }
                if (packageInfo == null) {
                    return;
                }
                try {
                    options.put("app_name", e.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString());
                } catch (Throwable unused) {
                }
                options.put(com.sigmob.sdk.base.n.p, packageInfo.packageName);
                options.put(com.sigmob.sdk.base.n.q, String.valueOf(packageInfo.lastUpdateTime));
                options.put(com.sigmob.sdk.base.n.r, packageInfo.versionName);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ae.a(this.f13102a, this.b, this.c, new ADYaiT(0, this.d));
        }
    }

    public interface a {
        void onAddExtra(Object obj);
    }

    public static void a(PackageInfo packageInfo, int i) {
        if (packageInfo == null) {
            return;
        }
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.SIGMOB_APP);
        pointEntitySigmobSuper.setCategory(PointCategory.APP);
        Map<String, String> options = pointEntitySigmobSuper.getOptions();
        try {
            options.put("app_name", String.valueOf(AppPackageUtil.getPackageManager(com.sigmob.sdk.b.e()).getApplicationLabel(packageInfo.applicationInfo)));
        } catch (Throwable unused) {
        }
        options.put(com.sigmob.sdk.base.n.p, packageInfo.packageName);
        options.put(com.sigmob.sdk.base.n.q, String.valueOf(packageInfo.lastUpdateTime));
        options.put(com.sigmob.sdk.base.n.r, packageInfo.versionName);
        options.put(com.sigmob.sdk.base.n.s, String.valueOf(i));
        pointEntitySigmobSuper.commit();
    }

    public static void b(String str, String str2, BaseAdUnit baseAdUnit) {
        a(str, str2, baseAdUnit, (a) null);
    }

    public static void a(AdTracker adTracker, String str, BaseAdUnit baseAdUnit, NetworkResponse networkResponse, a aVar) {
        if (adTracker == null) {
            return;
        }
        al.a(adTracker.getEvent()).a(baseAdUnit).a(new androidx.fragment.app.ARc23Z(str, adTracker, networkResponse, aVar, 1)).a();
    }

    public static void a(AdTracker adTracker, String str, BaseAdUnit baseAdUnit, VolleyError volleyError) {
        NetworkResponse networkResponse = volleyError == null ? null : volleyError.networkResponse;
        if (com.sigmob.sdk.base.utils.q.b(networkResponse)) {
            a(adTracker, str, baseAdUnit, networkResponse, (a) null);
        } else {
            a(adTracker, str, baseAdUnit, (NetworkResponse) null, new ADYaiT(3, volleyError));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(VolleyError volleyError, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setHttp_code("-1");
            if (volleyError == null) {
                pointEntitySigmob.setTime_spend(Constants.FAIL);
            } else {
                pointEntitySigmob.setTime_spend(String.valueOf(volleyError.getNetworkTimeMs()));
                pointEntitySigmob.setError_message(volleyError.getMessage());
            }
        }
    }

    public static void a(DownloadItem downloadItem, BaseAdUnit baseAdUnit, String str, boolean z) {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(PointType.DOWNLOAD_TRACKING);
        pointEntitySigmob.setIssuccess(String.valueOf(downloadItem.status));
        pointEntitySigmob.setIscached(z ? "1" : Constants.FAIL);
        pointEntitySigmob.setDuration(String.valueOf(downloadItem.networkMs));
        pointEntitySigmob.setFile_size(String.valueOf(downloadItem.size));
        pointEntitySigmob.setFile_name(Base64.encodeToString(downloadItem.url.getBytes(), 2));
        pointEntitySigmob.setError_message(str);
        pointEntitySigmob.setCategory(String.valueOf(downloadItem.type.getType()));
        a(pointEntitySigmob.getCategory(), pointEntitySigmob.getSub_category(), baseAdUnit, pointEntitySigmob);
        pointEntitySigmob.commit();
    }

    public static void a(com.sigmob.sdk.base.a aVar, String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4) {
        a(aVar, str, baseAdUnit, str2, str3, str4, 0L);
    }

    public static void a(com.sigmob.sdk.base.a aVar, String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4, long j) {
        a(aVar, str, baseAdUnit, str2, str3, str4, j, (JSONObject) null);
    }

    public static void a(com.sigmob.sdk.base.a aVar, final String str, final BaseAdUnit baseAdUnit, final String str2, final String str3, final String str4, final long j, final JSONObject jSONObject) {
        a(aVar == null ? str : aVar.name().toLowerCase(), str, baseAdUnit, new a() { // from class: com.sigmob.sdk.base.common.A5SV6n
            @Override // com.sigmob.sdk.base.common.ae.a
            public final void onAddExtra(Object obj) {
                ae.a(BaseAdUnit.this, str, str2, str3, str4, j, jSONObject, obj);
            }
        });
    }

    public static void a(aa aaVar) {
        if (aaVar != null) {
            if (aaVar.f13097a == 0 && aaVar.b == 0) {
                return;
            }
            PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
            pointEntitySigmobSuper.setAc_type(PointType.LOAD_READY);
            pointEntitySigmobSuper.setCategory(PointCategory.LOAD_READY);
            Map<String, String> options = pointEntitySigmobSuper.getOptions();
            options.put(PointParamKey.PLACEMENT_ID, String.valueOf(aaVar.c));
            options.put(PointParamKey.FEED_PRE_REQUEST_COUNT, String.valueOf(aaVar.f13097a));
            options.put(PointParamKey.FEED_PRE_READY_COUNT, String.valueOf(aaVar.b));
            pointEntitySigmobSuper.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, Object obj) {
        if (aVar == null) {
            return;
        }
        aVar.onAddExtra(obj);
    }

    public static void a(BaseAdUnit baseAdUnit, MotionEvent motionEvent, String str, boolean z) {
        long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
        PointEntityClick pointEntityClick = new PointEntityClick();
        pointEntityClick.setAc_type(PointType.ANTI_SPAM_TOUCH);
        pointEntityClick.setCategory(str);
        pointEntityClick.setLocation(String.format(Locale.getDefault(), "{x:%f,y:%f}", Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY())));
        pointEntityClick.setClick_duration(String.valueOf(eventTime));
        pointEntityClick.setPressure(String.valueOf(motionEvent.getPressure()));
        pointEntityClick.setTouchSize(String.valueOf(motionEvent.getSize()));
        pointEntityClick.setTouchType(String.valueOf(motionEvent.getToolType(0)));
        pointEntityClick.setIs_valid_click(z ? "1" : Constants.FAIL);
        if (com.sigmob.sdk.base.utils.q.b(baseAdUnit)) {
            pointEntityClick.setLoad_id(baseAdUnit.getLoad_id());
        }
        pointEntityClick.commit();
    }

    public static void a(BaseAdUnit baseAdUnit, String str, PackageInfo packageInfo, String str2) {
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new AnonymousClass1(str, str2, baseAdUnit, packageInfo));
    }

    public static void a(BaseAdUnit baseAdUnit, String str, String str2) {
        a(PointCategory.TARGET_URL, (String) null, baseAdUnit, new AaHO0E(str2, 13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(com.sigmob.sdk.base.models.BaseAdUnit r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, long r9, org.json.JSONObject r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.ae.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, org.json.JSONObject, java.lang.Object):void");
    }

    public static void a(PointEntitySigmob pointEntitySigmob) {
        WindAdOptions options = WindAds.sharedAds().getOptions();
        String str = Constants.FAIL;
        if (options == null || options.getCustomController() == null) {
            pointEntitySigmob.setIs_custom_imei(Constants.FAIL);
            pointEntitySigmob.setIs_custom_android_id(Constants.FAIL);
            pointEntitySigmob.setIs_custom_oaid(Constants.FAIL);
        } else {
            WindCustomController customController = options.getCustomController();
            pointEntitySigmob.setIs_custom_imei(customController.isCanUsePhoneState() ? Constants.FAIL : "1");
            pointEntitySigmob.setIs_custom_android_id(customController.isCanUseAndroidId() ? Constants.FAIL : "1");
            if (!com.sigmob.sdk.base.utils.o.a((CharSequence) customController.getDevOaid())) {
                str = "1";
            }
            pointEntitySigmob.setIs_custom_oaid(str);
        }
    }

    public static void a(String str) {
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.ANTI_SPAM_TOUCH);
        pointEntitySigmobSuper.setCategory(str);
        pointEntitySigmobSuper.setSha1(ClientMetadata.getInstance().getApkSha1());
        pointEntitySigmobSuper.setMd5(ClientMetadata.getInstance().getApkMd5());
        pointEntitySigmobSuper.commit();
    }

    public static void a(String str, int i, String str2, BaseAdUnit baseAdUnit) {
        a(str, i, str2, baseAdUnit, (a) null);
    }

    public static void a(String str, int i, String str2, BaseAdUnit baseAdUnit, a aVar) {
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, i, str2);
        if (com.sigmob.sdk.base.utils.q.b(aVar)) {
            aVar.onAddExtra(SigmobError);
        }
        a(str, str, baseAdUnit, SigmobError);
        SigmobError.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, AdTracker adTracker, NetworkResponse networkResponse, a aVar, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setAc_type(PointType.SIGMOB_REPORT_TRACKING);
            pointEntitySigmob.setUrl(str);
            pointEntitySigmob.setRetry(adTracker.getId() == null ? Constants.FAIL : "1");
            pointEntitySigmob.setCategory(adTracker.getEvent());
            pointEntitySigmob.setRequest_id(adTracker.getRequest_id());
            pointEntitySigmob.setSource(adTracker.getSource());
            long timestamp = adTracker.getTimestamp();
            if (timestamp != 0) {
                pointEntitySigmob.setTimestamp(String.valueOf(timestamp));
            }
            if (com.sigmob.sdk.base.utils.q.b(networkResponse)) {
                byte[] bArr = networkResponse.data;
                pointEntitySigmob.setResponse(bArr == null ? null : Base64.encodeToString(bArr, 2));
                pointEntitySigmob.setHttp_code(String.valueOf(networkResponse.statusCode));
                pointEntitySigmob.setTime_spend(String.valueOf(networkResponse.networkTimeMs));
                pointEntitySigmob.setContent_type(networkResponse.headers.get("Content-Type"));
                pointEntitySigmob.setContent_length(networkResponse.headers.get(com.sigmob.sdk.downloader.core.c.e));
            }
        }
        if (com.sigmob.sdk.base.utils.q.b(aVar)) {
            aVar.onAddExtra(obj);
        }
    }

    public static void a(String str, a aVar) {
        int i;
        ad adVar = new ad();
        adVar.setAc_type("1");
        adVar.setCategory(str);
        com.sigmob.sdk.base.o a2 = com.sigmob.sdk.base.o.a();
        boolean T = a2.T();
        boolean S = a2.S();
        adVar.setAppinfo_switch(T ? "0,0" : "1,1");
        if (S) {
            i = 0;
        } else {
            DeviceContext b = com.sigmob.sdk.b.b();
            i = (b == null ? ClientMetadata.getInstance().getLocation() : b.getLocation()) != null ? 1 : 0;
            r2 = 1;
        }
        adVar.setLocation_switch(r2 + "," + i);
        if (com.sigmob.sdk.base.utils.q.b(aVar)) {
            aVar.onAddExtra(adVar);
        }
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options == null || options.getCustomController() == null) {
            adVar.a(Constants.FAIL);
            adVar.b(Constants.FAIL);
            adVar.c(Constants.FAIL);
        } else {
            WindCustomController customController = options.getCustomController();
            adVar.a(customController.isCanUsePhoneState() ? Constants.FAIL : "1");
            adVar.b(customController.isCanUseAndroidId() ? Constants.FAIL : "1");
            adVar.c(com.sigmob.sdk.base.utils.o.a((CharSequence) customController.getDevOaid()) ? Constants.FAIL : "1");
        }
        adVar.commit();
    }

    public static void a(String str, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest, a aVar) {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(str);
        if (com.sigmob.sdk.base.utils.q.b(aVar)) {
            aVar.onAddExtra(pointEntitySigmob);
        }
        a(pointEntitySigmob.getCategory(), pointEntitySigmob.getSub_category(), baseAdUnit, pointEntitySigmob);
        if (com.sigmob.sdk.base.utils.q.b(loadAdRequest)) {
            pointEntitySigmob.setLoad_id(loadAdRequest.getLoadId());
            pointEntitySigmob.setAdtype(String.valueOf(loadAdRequest.getAdType()));
            pointEntitySigmob.setScene_id(loadAdRequest.getAdSceneId());
            pointEntitySigmob.setScene_desc(loadAdRequest.getAdSceneDesc());
            pointEntitySigmob.setPlacement_id(loadAdRequest.getPlacementId());
        }
        pointEntitySigmob.commit();
    }

    public static void a(String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4) {
        a(null, str, baseAdUnit, str2, str3, str4, 0L);
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), (WindAdRequest) null, (LoadAdRequest) null, baseAdUnit, (a) null);
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit, a aVar) {
        if (windAdError == null) {
            return;
        }
        int errorCode = windAdError.getErrorCode();
        String message = windAdError.getMessage();
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, errorCode, message);
        a(str, str, baseAdUnit, SigmobError);
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) message, (CharSequence) WindAdError.ERROR_SIGMOB_VIDEO_FILE.getMessage()) && com.sigmob.sdk.base.utils.o.a((CharSequence) str, (CharSequence) "load") && com.sigmob.sdk.base.utils.q.b(baseAdUnit)) {
            SigmobError.getOptions().put("video_url", baseAdUnit.getVideo_url());
        }
        if (com.sigmob.sdk.base.utils.q.b(aVar)) {
            aVar.onAddExtra(SigmobError);
        }
        SigmobError.commit();
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), (WindAdRequest) null, loadAdRequest, baseAdUnit, (a) null);
    }

    public static void a(String str, WindAdError windAdError, WindAdRequest windAdRequest) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), windAdRequest, (LoadAdRequest) null, (BaseAdUnit) null, (a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(str);
        }
    }

    public static void a(String str, String str2, int i, String str3, LoadAdRequest loadAdRequest) {
        a(str, str2, i, str3, (WindAdRequest) null, loadAdRequest, (BaseAdUnit) null, (a) null);
    }

    public static void a(String str, String str2, int i, String str3, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, BaseAdUnit baseAdUnit, a aVar) {
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, i, str3);
        SigmobError.setSub_category(str2);
        a(str, str, SigmobError, windAdRequest);
        a(str, str, SigmobError, loadAdRequest);
        a(str, str, baseAdUnit, SigmobError);
        if (com.sigmob.sdk.base.utils.q.b(aVar)) {
            aVar.onAddExtra(SigmobError);
        }
        SigmobError.commit();
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit) {
        a(str, str2, baseAdUnit, (a) null);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, a aVar) {
        a(str, str2, baseAdUnit, (WindAdRequest) null, (LoadAdRequest) null, aVar);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest, a aVar) {
        a(str, str2, baseAdUnit, (WindAdRequest) null, loadAdRequest, aVar);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, PointEntitySigmob pointEntitySigmob) {
        if (baseAdUnit == null || pointEntitySigmob == null) {
            return;
        }
        try {
            int ad_type = baseAdUnit.getAd_type();
            pointEntitySigmob.setAdtype(String.valueOf(ad_type));
            pointEntitySigmob.setCampaign_id(baseAdUnit.getCamp_id());
            pointEntitySigmob.setCreative_id(baseAdUnit.getCrid());
            pointEntitySigmob.setRequest_id(baseAdUnit.getRequestId());
            pointEntitySigmob.setPlacement_id(baseAdUnit.getAdslot_id());
            pointEntitySigmob.setLoad_id(baseAdUnit.getLoad_id());
            pointEntitySigmob.setVid(baseAdUnit.getVid());
            pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
            pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
            pointEntitySigmob.setPlay_mode(String.valueOf(baseAdUnit.getPlayMode()));
            pointEntitySigmob.setCreative_type(String.valueOf(baseAdUnit.getCreativeType()));
            pointEntitySigmob.setBid_token(baseAdUnit.getBid_token());
            BiddingResponse biddingResponse = baseAdUnit.bidding_response;
            if (com.sigmob.sdk.base.utils.q.b(biddingResponse)) {
                pointEntitySigmob.setHb_price(biddingResponse.ecpm.intValue());
            }
            pointEntitySigmob.setPrice(baseAdUnit.getAd().settlement_price_enc);
            String str3 = baseAdUnit.getAd().product_id;
            if (com.sigmob.sdk.base.utils.o.b(str3)) {
                pointEntitySigmob.setProduct_id(str3);
            }
            String adx_id = baseAdUnit.getAdx_id();
            if (com.sigmob.sdk.base.utils.o.b(adx_id)) {
                pointEntitySigmob.setAdx_id(adx_id);
            }
            pointEntitySigmob.setTemplate_id(String.valueOf(baseAdUnit.getTemplateId()));
            MaterialMeta material = baseAdUnit.getMaterial();
            if (com.sigmob.sdk.base.utils.q.b(material)) {
                pointEntitySigmob.setTemplate_type(material.template_type.intValue());
            }
            if (com.sigmob.sdk.base.utils.o.a((CharSequence) pointEntitySigmob.getTarget_url())) {
                pointEntitySigmob.setTarget_url(baseAdUnit.getLanding_page());
            }
            WXProgramRes wXProgramRes = baseAdUnit.getWXProgramRes();
            if (com.sigmob.sdk.base.utils.q.b(wXProgramRes)) {
                if (com.sigmob.sdk.base.utils.o.b(wXProgramRes.wx_app_path)) {
                    pointEntitySigmob.setWx_app_path(URLEncoder.encode(wXProgramRes.wx_app_path, "UTF-8"));
                }
                if (com.sigmob.sdk.base.utils.o.b(wXProgramRes.wx_app_username)) {
                    pointEntitySigmob.setWx_app_username(wXProgramRes.wx_app_username);
                }
            }
            String apkMd5 = baseAdUnit.getApkMd5();
            if (com.sigmob.sdk.base.utils.o.b(apkMd5)) {
                pointEntitySigmob.getOptions().put(PointParamKey.APK_MD5, apkMd5);
            }
            pointEntitySigmob.setAd_source_channel(baseAdUnit.getAd_source_channel());
            a(str, str2, pointEntitySigmob, ad_type, baseAdUnit.isHalfInterstitial());
        } catch (Throwable unused) {
        }
        Map<String, String> options = pointEntitySigmob.getOptions();
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) pointEntitySigmob.getCategory())) {
            String str4 = com.sigmob.sdk.base.utils.o.b(str) ? str : options.get(PointParamKey.CATEGORY);
            if (com.sigmob.sdk.base.utils.o.b(str4)) {
                pointEntitySigmob.setCategory(str4);
            }
        }
        if (com.sigmob.sdk.base.utils.o.b(str, PointCategory.REQUEST)) {
            Integer adExpiredTime = baseAdUnit.getAdExpiredTime();
            long create_time = baseAdUnit.getCreate_time();
            boolean expiredAdCanReload = baseAdUnit.expiredAdCanReload();
            options.put(PointParamKey.EXPIRE_RELOAD_COUNT, String.valueOf(baseAdUnit.expiredAdReloadNum()));
            options.put(PointParamKey.CAN_EXPIRE_RELOAD, String.valueOf(expiredAdCanReload ? 1 : 0));
            options.put(PointParamKey.EXPIRE_TIMESTAMP, String.valueOf(create_time + adExpiredTime.intValue()));
            int requestSceneType = baseAdUnit.getRequestSceneType();
            if (requestSceneType > 0) {
                options.put(PointParamKey.REQUEST_SCENE_TYPE, String.valueOf(requestSceneType));
            }
            Boolean enableSmallWindow = baseAdUnit.enableSmallWindow();
            baseAdUnit.getDeeplinkUrl();
            int interactionType = baseAdUnit.getInteractionType();
            int mraidInteractionType = baseAdUnit.getMraidInteractionType();
            boolean isValid = baseAdUnit.isValid(interactionType);
            boolean isValid2 = baseAdUnit.isValid(mraidInteractionType);
            boolean b = com.sigmob.sdk.base.utils.q.b((Object) enableSmallWindow);
            String str5 = Constants.FAIL;
            if (b && (isValid || isValid2)) {
                options.put(PointParamKey.ENABLE_SMALL_WINDOW, enableSmallWindow.booleanValue() ? "1" : Constants.FAIL);
            }
            if (baseAdUnit.getAd_type() == 6) {
                Boolean allowClickToAutoClose = baseAdUnit.allowClickToAutoClose();
                if (com.sigmob.sdk.base.utils.q.b((Object) allowClickToAutoClose)) {
                    if (allowClickToAutoClose.booleanValue()) {
                        str5 = "1";
                    }
                    options.put(PointParamKey.CLICK_CLOSE_AD, str5);
                }
                Integer allowCountdownEndsClose = baseAdUnit.allowCountdownEndsClose();
                if (com.sigmob.sdk.base.utils.q.b(allowCountdownEndsClose)) {
                    options.put(PointParamKey.SECONDS_CLOSE_AD, String.valueOf(allowCountdownEndsClose));
                }
            }
            options.put(PointParamKey.TRACE_ID, baseAdUnit.getTraceId());
            if (requestSceneType == com.sigmob.sdk.base.j.NormalRequest.a() || requestSceneType == com.sigmob.sdk.base.j.ReloadAfterExpiration.a() || requestSceneType == com.sigmob.sdk.base.j.ActiveFailureReload.a()) {
                options.put(PointParamKey.VID, baseAdUnit.getVid());
                String originVid = baseAdUnit.getOriginVid();
                if (com.sigmob.sdk.base.utils.o.b(originVid)) {
                    options.put(PointParamKey.ORIGIN_VID, originVid);
                }
            }
        }
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, WindAdRequest windAdRequest, a aVar) {
        a(str, str2, baseAdUnit, windAdRequest, (LoadAdRequest) null, aVar);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, a aVar) {
        al.a(str).c(str2).a(baseAdUnit).a(windAdRequest).a(loadAdRequest).a(new ADYaiT(4, aVar)).a();
    }

    public static void a(String str, String str2, LoadAdRequest loadAdRequest) {
        a(str, str2, (BaseAdUnit) null, (WindAdRequest) null, loadAdRequest, (a) null);
    }

    private static void a(String str, String str2, PointEntitySigmob pointEntitySigmob, int i, boolean z) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) pointEntitySigmob.getShow_type()) && com.sigmob.sdk.base.utils.o.b(str)) {
            if ((str.equals(PointCategory.REQUEST) || str.equals(PointCategory.READY) || str.equals("start") || str.equals("endcard") || (com.sigmob.sdk.base.utils.o.b(str2) && str2.equals("click"))) && i == 4) {
                pointEntitySigmob.setShow_type(z ? "2" : "1");
            }
        }
    }

    public static void a(String str, String str2, PointEntitySigmob pointEntitySigmob, LoadAdRequest loadAdRequest) {
        if (pointEntitySigmob == null || loadAdRequest == null) {
            return;
        }
        pointEntitySigmob.setPlacement_id(loadAdRequest.getPlacementId());
        String bidToken = loadAdRequest.getBidToken();
        if (com.sigmob.sdk.base.utils.o.b(bidToken)) {
            pointEntitySigmob.setBid_token(bidToken);
        }
        String loadId = loadAdRequest.getLoadId();
        if (com.sigmob.sdk.base.utils.o.b(loadId)) {
            pointEntitySigmob.setLoad_id(loadId);
        }
        String adx_id = loadAdRequest.getAdx_id();
        if (com.sigmob.sdk.base.utils.o.b(adx_id)) {
            pointEntitySigmob.setAdx_id(adx_id);
        }
        int adType = loadAdRequest.getAdType();
        pointEntitySigmob.setAdtype(String.valueOf(adType));
        String requestId = loadAdRequest.getRequestId();
        if (com.sigmob.sdk.base.utils.o.b(requestId)) {
            pointEntitySigmob.setRequest_id(requestId);
        }
        String traceId = loadAdRequest.getTraceId();
        if (com.sigmob.sdk.base.utils.o.b(traceId)) {
            pointEntitySigmob.setTrace_id(traceId);
        }
        Map<String, String> options = loadAdRequest.getOptions();
        if (com.sigmob.sdk.base.utils.q.b(options)) {
            pointEntitySigmob.setExtinfo(new JSONObject(options).toString());
        }
        a(str, str2, pointEntitySigmob, adType, loadAdRequest.isHalfInterstitial());
        int request_scene_type = loadAdRequest.getRequest_scene_type();
        if (request_scene_type > 0) {
            pointEntitySigmob.getOptions().put(PointParamKey.REQUEST_SCENE_TYPE, String.valueOf(request_scene_type));
        }
    }

    public static void a(String str, String str2, PointEntitySigmob pointEntitySigmob, WindAdRequest windAdRequest) {
        if (pointEntitySigmob == null || windAdRequest == null) {
            return;
        }
        int adType = windAdRequest.getAdType();
        pointEntitySigmob.setPlacement_id(windAdRequest.getPlacementId());
        pointEntitySigmob.setLoad_id(windAdRequest.getLoadId());
        pointEntitySigmob.setAdx_id(windAdRequest.getAdxId());
        pointEntitySigmob.setAdtype(String.valueOf(adType));
        if (windAdRequest.hasOptions()) {
            try {
                pointEntitySigmob.setExtinfo(new JSONObject(windAdRequest.getOptions()).toString());
            } catch (Throwable unused) {
            }
        }
        a(str, str2, pointEntitySigmob, adType, windAdRequest.isHalfInterstitial());
    }

    public static void a(String str, String str2, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, a aVar) {
        PointEntitySigmobRequest pointEntitySigmobRequest = new PointEntitySigmobRequest();
        pointEntitySigmobRequest.setAc_type("5");
        pointEntitySigmobRequest.setCategory(str);
        pointEntitySigmobRequest.setSub_category(str2);
        a(str, str, pointEntitySigmobRequest, windAdRequest);
        a(str, str, pointEntitySigmobRequest, loadAdRequest);
        if (com.sigmob.sdk.base.utils.q.b(aVar)) {
            aVar.onAddExtra(pointEntitySigmobRequest);
        }
        a(pointEntitySigmobRequest);
        pointEntitySigmobRequest.commit();
    }

    public static void a(String str, boolean z, int i) {
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.SIGMOB_CANOPEN_APP);
        pointEntitySigmobSuper.setCategory(PointCategory.OPEN_APP);
        Map<String, String> options = pointEntitySigmobSuper.getOptions();
        options.put(PointParamKey.APP_PKG_NAME, str);
        options.put(PointParamKey.CAN_OP, z ? "1" : Constants.FAIL);
        options.put(PointParamKey.TYPE, String.valueOf(i));
        pointEntitySigmobSuper.commit();
    }
}
