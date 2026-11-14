package com.sigmob.sdk.base.network;

import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.App;
import com.czhj.sdk.common.models.ModelBuilderCreator;
import com.czhj.sdk.common.models.Permission;
import com.czhj.sdk.common.models.Privacy;
import com.czhj.sdk.common.models.User;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.HttpHeaderParser;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.ab;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends SigmobRequest<BidResponse> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13195a = "a";
    private final e.a b;
    private final LoadAdRequest c;
    private byte[] d;

    public a(String str, LoadAdRequest loadAdRequest, e.a aVar) {
        super(str, 1, null);
        Preconditions.NoThrow.checkNotNull(aVar);
        this.b = aVar;
        this.c = loadAdRequest;
        setRetryPolicy(new DefaultRetryPolicy(5000, 0, 0.0f));
        setShouldCache(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x019a A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:3:0x000f, B:5:0x0035, B:6:0x0040, B:8:0x0047, B:14:0x005b, B:16:0x0071, B:18:0x0081, B:20:0x008b, B:21:0x00af, B:23:0x00b5, B:26:0x00c3, B:27:0x019d, B:29:0x01c4, B:30:0x01c7, B:32:0x01f1, B:33:0x01f8, B:35:0x0216, B:36:0x0218, B:38:0x0222, B:39:0x0224, B:41:0x0233, B:42:0x0236, B:44:0x0240, B:45:0x0243, B:47:0x0254, B:49:0x0258, B:50:0x025f, B:51:0x0332, B:53:0x0381, B:54:0x038c, B:64:0x0119, B:65:0x0134, B:66:0x0190, B:68:0x019a, B:69:0x0138, B:70:0x0268), top: B:2:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.czhj.sdk.common.models.BidRequest.Builder a(com.sigmob.sdk.base.models.LoadAdRequest r14) {
        /*
            Method dump skipped, instructions count: 939
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.network.a.a(com.sigmob.sdk.base.models.LoadAdRequest):com.czhj.sdk.common.models.BidRequest$Builder");
    }

    public static App.Builder b() {
        App.Builder createApp = ModelBuilderCreator.createApp();
        createApp.sdk_ext_cap.add(4);
        createApp.app_id(WindAds.sharedAds().getAppId());
        Permission.Builder builder = new Permission.Builder();
        boolean j = o.a().j();
        boolean sensorStatus = WindAds.sharedAds().getSensorStatus();
        boolean f = (!sensorStatus || j) ? false : com.sigmob.sdk.b.f();
        boolean z = sensorStatus && f;
        SigmobLogger.d(f13195a, "createApp: accelerometer = " + z + ", complianceMark = " + j + ", sensorStatus = " + sensorStatus + ", sensorEnable = " + f, new Object[0]);
        builder.accelerometer(Boolean.valueOf(z));
        createApp.permission(builder.build());
        return createApp;
    }

    public static User.Builder c() {
        User.Builder builder = new User.Builder();
        builder.is_minor = Boolean.valueOf(!i.a().d());
        builder.disable_personalized_recommendation = Boolean.valueOf(!i.a().e());
        builder.change_recommendation_state = Boolean.valueOf(i.a().f());
        return builder;
    }

    public static Privacy.Builder d() {
        int i;
        Privacy.Builder builder = new Privacy.Builder();
        builder.age(Integer.valueOf(i.a().b()));
        builder.child_protection(Integer.valueOf(i.a().c()));
        try {
            i = i.a().g();
        } catch (Throwable unused) {
            i = 0;
        }
        builder.gdpr_consent(Integer.valueOf(i));
        WindAdOptions options = WindAds.sharedAds().getOptions();
        WindCustomController windCustomController = (options == null || options.getCustomController() == null) ? new WindCustomController() : options.getCustomController();
        builder.allow_geo = Boolean.valueOf(windCustomController.isCanUseLocation());
        builder.allow_imei = Boolean.valueOf(windCustomController.isCanUsePhoneState());
        builder.allow_oaid = Boolean.valueOf(windCustomController.isCanUseOaid());
        builder.allow_android_id = Boolean.valueOf(windCustomController.isCanUseAndroidId());
        builder.allow_installed_apps = Boolean.valueOf(windCustomController.isCanUseAppList());
        builder.allow_carrier_code = Boolean.valueOf(windCustomController.isCanUseSimOperator());
        return builder;
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        e.a aVar;
        WindAdError windAdError;
        z a2;
        if (this.c.getAdType() == 5 && (a2 = z.a(this.c.getPlacementId())) != null) {
            a2.g = a2.c;
        }
        if (volleyError instanceof ParseError) {
            aVar = this.b;
            windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
        } else {
            SigmobLog.e(this.c.getPlacementId() + " ERROR_SIGMOB_NETWORK " + volleyError.getMessage());
            aVar = this.b;
            windAdError = WindAdError.ERROR_SIGMOB_NETWORK;
        }
        e.a(aVar, windAdError.getErrorCode(), volleyError.getMessage(), null, this.c);
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public byte[] getBody() {
        return this.d;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public String getBodyContentType() {
        return "application/octet-stream";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        /*
            r7 = this;
            java.lang.String r0 = "cp"
            java.lang.String r1 = "1"
            java.lang.String r2 = "e"
            java.lang.String r3 = "agn"
            java.util.Map r4 = super.getHeaders()
            byte[] r5 = com.czhj.sdk.common.utils.AESUtil.generateNonce()     // Catch: java.lang.NoSuchMethodError -> L19
            r6 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r6)     // Catch: java.lang.NoSuchMethodError -> L19
            r4.put(r3, r5)     // Catch: java.lang.NoSuchMethodError -> L19
            goto L1c
        L19:
            r4.put(r2, r1)
        L1c:
            r5 = 0
            com.sigmob.sdk.base.models.LoadAdRequest r6 = r7.c     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L32
            com.czhj.sdk.common.models.BidRequest$Builder r6 = a(r6)     // Catch: java.lang.Throwable -> L2a
            com.czhj.sdk.common.models.BidRequest r6 = r6.build()     // Catch: java.lang.Throwable -> L2a
            goto L33
        L2a:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r6)
        L32:
            r6 = r5
        L33:
            if (r6 != 0) goto L3b
            java.lang.String r0 = "builder Ads Post entry fail "
            com.czhj.sdk.logger.SigmobLog.e(r0)
            return r5
        L3b:
            byte[] r5 = r6.encode()     // Catch: java.lang.Throwable -> L4b
            r7.d = r5     // Catch: java.lang.Throwable -> L4b
            byte[] r5 = com.sigmob.sdk.base.network.c.b(r5)     // Catch: java.lang.Throwable -> L4b
            r7.d = r5     // Catch: java.lang.Throwable -> L4b
            r4.put(r0, r1)     // Catch: java.lang.Throwable -> L4b
            goto L54
        L4b:
            r4.remove(r0)
            byte[] r0 = r6.encode()
            r7.d = r0
        L54:
            byte[] r0 = r7.d     // Catch: java.lang.Exception -> L5f
            java.lang.String r1 = "KGpfzbYsn4T9Jyuq"
            byte[] r0 = com.czhj.sdk.common.utils.AESUtil.Encrypt(r0, r1)     // Catch: java.lang.Exception -> L5f
            r7.d = r0     // Catch: java.lang.Exception -> L5f
            goto L69
        L5f:
            r0 = move-exception
            r0.printStackTrace()
            r4.remove(r2)
            r4.remove(r3)
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.network.a.getHeaders():java.util.Map");
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Response<BidResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        ParseError parseError;
        try {
            if (networkResponse.data == null) {
                parseError = new ParseError(networkResponse);
            } else {
                BidResponse decode = BidResponse.ADAPTER.decode((networkResponse.headers.containsKey("cp") && "1".equals(networkResponse.headers.get("cp"))) ? c.a(networkResponse.data) : networkResponse.data);
                if (decode != null) {
                    return Response.success(decode, HttpHeaderParser.parseCacheHeaders(networkResponse));
                }
                parseError = new ParseError(networkResponse);
            }
            return Response.error(parseError);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return Response.error(new ParseError(th));
        }
    }

    public e.a a() {
        return this.b;
    }

    private void a(int i, String str, String str2, int i2, String str3) {
        ae.a(PointCategory.SERVER_ERROR, i2, str3, (BaseAdUnit) null, new A2egSU(i, 0, str2, str));
    }

    @Override // com.czhj.volley.Request
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(BidResponse bidResponse) {
        String DecryptString;
        z a2;
        AndroidMarket androidMarket;
        Integer num;
        NativeAdSetting nativeAdSetting;
        z a3;
        int adType = this.c.getAdType();
        String placementId = this.c.getPlacementId();
        AndroidMarket androidMarket2 = null;
        if (bidResponse != null) {
            int i = 0;
            if (adType == 5) {
                z a4 = z.a(this.c.getPlacementId());
                if (a4 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    a4.c = currentTimeMillis;
                    a4.g = currentTimeMillis;
                    a4.b = 0;
                    a4.f13166a = 0;
                    SlotAdSetting slotAdSetting = bidResponse.slot_ad_setting;
                    if (slotAdSetting != null && (nativeAdSetting = slotAdSetting.native_setting) != null) {
                        a4.e = ((Integer) Wire.get(nativeAdSetting.ad_pool_size, 0)).intValue();
                        a4.d = ((Integer) Wire.get(nativeAdSetting.req_interval_time, 0)).intValue();
                        a4.f = ((Integer) Wire.get(nativeAdSetting.media_expected_floor, 0)).intValue();
                        ab.a().a(((Integer) Wire.get(nativeAdSetting.log_interval_time, 0)).intValue());
                    }
                }
                z.a(placementId, a4);
            }
            List<Ad> list = bidResponse.ads;
            int size = list.size();
            if (com.sigmob.sdk.base.utils.e.b(list)) {
                o.f13203a = Boolean.valueOf(q.a(bidResponse.noncompliance_mark));
            }
            SigmobLog.d("noncomplianceMark(bid) = " + o.f13203a + ", size = " + size);
            String str = bidResponse.uid;
            if (com.sigmob.sdk.base.utils.o.b(str)) {
                try {
                    DecryptString = AESUtil.DecryptStringServer(str, "KGpfzbYsn4T9Jyuq");
                } catch (NoSuchMethodError unused) {
                    DecryptString = AESUtil.DecryptString(str, "KGpfzbYsn4T9Jyuq");
                }
                ClientMetadata.getInstance().setUid(DecryptString);
            }
            if (com.sigmob.sdk.base.utils.o.b(bidResponse.adx_id)) {
                this.c.setAdx_id(bidResponse.adx_id);
            }
            this.c.setRequestId(bidResponse.request_id);
            if (com.sigmob.sdk.base.utils.e.a(list)) {
                a(adType, placementId, bidResponse.request_id, bidResponse.error_code.intValue(), bidResponse.error_message);
                e.a(this.b, bidResponse.error_code.intValue(), bidResponse.error_message, bidResponse.request_id, this.c);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (i < size) {
                    Ad ad = list.get(i);
                    if (this.c.getAdType() == 6 && com.sigmob.sdk.base.utils.e.b(ad.materials) && q.b(bidResponse.slot_ad_setting) && q.b(bidResponse.slot_ad_setting.interstitial_setting)) {
                        for (MaterialMeta materialMeta : ad.materials) {
                            if (materialMeta != null && (androidMarket = materialMeta.android_market) != null && (num = androidMarket.type) != null) {
                                InterstitialSetting interstitialSetting = bidResponse.slot_ad_setting.interstitial_setting;
                                Boolean bool = interstitialSetting.click_close_ad;
                                Integer num2 = interstitialSetting.seconds_close_ad;
                                if (num.intValue() == 1) {
                                    if (!q.a(bool)) {
                                        if (q.a((Number) num2)) {
                                        }
                                    }
                                    materialMeta.android_market = androidMarket2;
                                }
                            }
                        }
                    }
                    BaseAdUnit adUnit = BaseAdUnit.adUnit(ad, bidResponse.request_id, this.c, bidResponse.slot_ad_setting, bidResponse.scene, bidResponse.uid, bidResponse.expiration_time, bidResponse.bidding_response);
                    adUnit.setAd_type(adType);
                    adUnit.setAdx_id(this.c.getAdx_id());
                    adUnit.setAdslot_id(this.c.getPlacementId());
                    adUnit.setHalfInterstitial(this.c.isHalfInterstitial());
                    adUnit.setRvCallBackUrl(bidResponse.rv_callback_url);
                    adUnit.setTraceId(this.c.getTraceId());
                    adUnit.setOriginVid(this.c.getOriginVid());
                    adUnit.setBid_token(this.c.getBidToken());
                    adUnit.setRequestSceneType(this.c.getRequest_scene_type());
                    arrayList.add(adUnit);
                    i++;
                    androidMarket2 = null;
                }
                if (adType == 5 && (a2 = z.a(this.c.getPlacementId())) != null) {
                    h.a(placementId, arrayList, a2.e);
                }
                e.a(this.b, arrayList, this.c);
                if (adType == 6 || adType == 1 || adType == 4) {
                    h.a(bidResponse.request_id, bidResponse);
                    return;
                }
                return;
            } catch (Throwable th) {
                SigmobLog.e("ads Response: error ", th);
            }
        } else if (adType == 5 && (a3 = z.a(this.c.getPlacementId())) != null) {
            a3.g = a3.c;
        }
        e.a(this.b, WindAdError.ERROR_SIGMOB_INFORMATION_LOSE.getErrorCode(), "bidResponse is null", null, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, int i, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            PointEntitySigmobError pointEntitySigmobError = (PointEntitySigmobError) obj;
            pointEntitySigmobError.setRequest_id(str);
            pointEntitySigmobError.setPlacement_id(str2);
            pointEntitySigmobError.setAdtype(String.valueOf(i));
        }
    }
}
