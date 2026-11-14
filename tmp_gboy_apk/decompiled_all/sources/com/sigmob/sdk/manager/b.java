package com.sigmob.sdk.manager;

import ADYaiT.CtFAbx;
import DaOi9o.AYUAbz;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.models.rtb.FrequencyControl;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.network.g;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.sdk.videoAd.m;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b {
    private static final ConcurrentHashMap<String, Boolean> f = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public final String f13439a = getClass().getSimpleName();
    protected AdStatus b = AdStatus.AdStatusNone;
    protected final int c = 8193;
    protected String d;
    protected String e;

    static {
        dDLzZQ();
    }

    public static void b(BaseAdUnit baseAdUnit, String str, String str2) {
        j(baseAdUnit);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            SigmobLogger.e("BaseAdManager", "trackDeeplinkResult: error = " + e.getMessage(), new Object[0]);
        }
        g.a(baseAdUnit, str);
        ae.a(str, (String) null, baseAdUnit, new AYUAbz(str2, 6, baseAdUnit));
    }

    public static boolean c(Integer num) {
        if (num == null) {
            return false;
        }
        return num.intValue() == j.NormalRequest.a() || a(num);
    }

    private static /* synthetic */ void dDLzZQ() {
        char[] charArray = "áíï¬åãïç¬àíû¬ñêçîî¬ÈìëÀðëæåç".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 130);
        }
        String str = new String(charArray);
        char[] charArray2 = "áîëìëö".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 130);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String j() {
        return UUID.randomUUID().toString();
    }

    public static boolean m(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return false;
        }
        String ad_source_channel = baseAdUnit.getAd_source_channel();
        if (o.a((CharSequence) ad_source_channel)) {
            return false;
        }
        return ad_source_channel.equalsIgnoreCase(n.i);
    }

    public void a(int i) {
        boolean c = c();
        boolean z = !c;
        boolean z2 = !c && a(Integer.valueOf(i));
        SigmobLogger.i(this.f13439a, "addToWindAdExpirationManager: allowAdd = " + z2 + ", unready = " + z + ", requestSceneTypeValue = " + i, new Object[0]);
        if (z2) {
            a(this);
        }
    }

    public abstract boolean c();

    public abstract boolean d();

    public abstract BaseAdUnit e();

    public abstract LoadAdRequest f();

    public boolean f(BaseAdUnit baseAdUnit) {
        return baseAdUnit != null && baseAdUnit.isExpiredAd();
    }

    public abstract void g();

    public boolean g(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return false;
        }
        int playMode = baseAdUnit.getPlayMode();
        SigmobLogger.d(this.f13439a, CtFAbx.ARc23Z(playMode, "checkAdUnit: playMode = "), new Object[0]);
        if (playMode != 0) {
            return true;
        }
        try {
            boolean isEndCardIndexExist = baseAdUnit.isEndCardIndexExist();
            SigmobLogger.d(this.f13439a, "checkAdUnit: isEndCardReady = " + isEndCardIndexExist, new Object[0]);
            return isEndCardIndexExist;
        } catch (Throwable th) {
            SigmobLogger.e(this.f13439a, J3FDQU.A2egSU.B4ZgIw(th, new StringBuilder("checkAdUnit: error = ")), new Object[0]);
            return false;
        }
    }

    public String h() {
        LoadAdRequest f2 = f();
        if (f2 == null) {
            return null;
        }
        return f2.getPlacementId();
    }

    public abstract BaseAdUnit i();

    public Map<String, BiddingResponse> i(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return hashMap;
    }

    public void k(BaseAdUnit baseAdUnit) {
        a(baseAdUnit, (ae.a) new AYUAbz(this, 7, baseAdUnit));
    }

    public Map<String, String> l(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return null;
        }
        List<FrequencyControl> frequencyControl = baseAdUnit.getFrequencyControl();
        if (com.sigmob.sdk.base.utils.e.a(frequencyControl)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PointParamKey.FREQUENCY_CONTROL_LIST, com.sigmob.sdk.base.utils.g.a(frequencyControl));
        for (FrequencyControl frequencyControl2 : frequencyControl) {
            SigmobLogger.d(this.f13439a, "频控策略 ID = " + frequencyControl2.strategy_id + ", 频控策略类型 = " + frequencyControl2.frequency_control_event, new Object[0]);
        }
        return hashMap;
    }

    public static void j(BaseAdUnit baseAdUnit) {
        int interactionType;
        if (baseAdUnit == null || (interactionType = baseAdUnit.getInteractionType()) == 7 || interactionType == 8 || !baseAdUnit.enableDetectPkg()) {
            return;
        }
        String str = baseAdUnit.canOpen() ? PointCategory.CAN_DP : PointCategory.NO_CAN_DP;
        ae.a(str, (String) null, baseAdUnit);
        String requestId = baseAdUnit.getRequestId();
        ConcurrentHashMap<String, Boolean> concurrentHashMap = f;
        if (concurrentHashMap.containsKey(requestId)) {
            return;
        }
        g.a(baseAdUnit, str);
        concurrentHashMap.put(requestId, Boolean.TRUE);
    }

    public void a(AdStatus adStatus) {
        this.b = adStatus;
    }

    public void b(b bVar) {
        d.a().b(bVar);
    }

    public String h(BaseAdUnit baseAdUnit) {
        BiddingResponse biddingResponse;
        Integer num;
        if (baseAdUnit != null && (biddingResponse = baseAdUnit.bidding_response) != null && (num = biddingResponse.ecpm) != null) {
            try {
                String valueOf = String.valueOf(num);
                SigmobLogger.d(this.f13439a, "getEcpm: eCPM = ".concat(valueOf), new Object[0]);
                return valueOf;
            } catch (Exception e) {
                SigmobLogger.e(this.f13439a, CtFAbx.AZOQYO(e, new StringBuilder("getEcpm: error = ")), new Object[0]);
            }
        }
        return null;
    }

    public static boolean b(Integer num) {
        if (num == null) {
            return false;
        }
        return num.intValue() == j.AutoNextPreload.a() || num.intValue() == j.SplashCloseRequest.a();
    }

    public void a(BaseAdUnit baseAdUnit, ae.a aVar) {
        ae.a(PointCategory.RESPOND, "1", baseAdUnit, aVar);
    }

    public void a(BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest) {
        if (a(Integer.valueOf(loadAdRequest.getRequest_scene_type()))) {
            this.b = AdStatus.AdStatusReady;
            a(this);
        }
        ae.a(PointCategory.READY, (String) null, baseAdUnit, loadAdRequest, (ae.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseAdUnit baseAdUnit, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
            options.put(PointParamKey.IS_CACHE, "1");
            Map<String, String> l = l(baseAdUnit);
            if (com.sigmob.sdk.base.utils.e.b(l)) {
                options.putAll(l);
            }
        }
    }

    public void a(BaseAdUnit baseAdUnit, String str, int i, String str2, String str3, WindAdError windAdError) {
        ae.a(str, windAdError, baseAdUnit, new com.sigmob.sdk.base.network.A2egSU(i, 1, str3, str2));
    }

    public void a(BaseAdUnit baseAdUnit, String str, String str2) {
        if (baseAdUnit == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    public void a(LoadAdRequest loadAdRequest) {
        loadAdRequest.setRequestId("");
        String traceId = loadAdRequest.getTraceId();
        int request_scene_type = loadAdRequest.getRequest_scene_type();
        if (request_scene_type == j.NormalRequest.a()) {
            return;
        }
        ae.a(PointCategory.REQUEST, a(Integer.valueOf(request_scene_type)) ? "init" : PointCategory.PLAY, (WindAdRequest) null, loadAdRequest, new com.sigmob.sdk.base.network.A2egSU(this, traceId, request_scene_type));
    }

    public void a(b bVar) {
        d.a().a(bVar);
        e.a().a(bVar);
    }

    public void a(WindAdError windAdError, m mVar) {
        AdStatus adStatus = this.b;
        if (adStatus != AdStatus.AdStatusLoading && adStatus != AdStatus.AdStatusClose) {
            g();
            this.b = AdStatus.AdStatusNone;
        }
        if (mVar == null || windAdError == null) {
            return;
        }
        mVar.onAdShowError(windAdError, h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i, Object obj) {
        if (obj instanceof PointEntitySigmobRequest) {
            PointEntitySigmobRequest pointEntitySigmobRequest = (PointEntitySigmobRequest) obj;
            pointEntitySigmobRequest.setTrace_id(str);
            pointEntitySigmobRequest.setAdx_id(null);
            Map<String, String> options = pointEntitySigmobRequest.getOptions();
            options.putAll(d.a().a(this, Integer.valueOf(i)));
            pointEntitySigmobRequest.setOptions(options);
        }
    }

    public void a(String str, BaseAdUnit baseAdUnit) {
        e.a().a(str, baseAdUnit, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, BaseAdUnit baseAdUnit, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            if (o.b(str)) {
                pointEntitySigmob.setFinal_url(str);
            }
            if (baseAdUnit == null) {
                return;
            }
            AndroidMarket androidMarket = baseAdUnit.getAndroidMarket();
            if (baseAdUnit.getInteractionType() == 8 || q.b(androidMarket)) {
                pointEntitySigmob.getOptions().put(PointParamKey.FAST_PKG, com.sigmob.sdk.b.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, int i, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            PointEntitySigmobError pointEntitySigmobError = (PointEntitySigmobError) obj;
            pointEntitySigmobError.setLoad_id(str);
            pointEntitySigmobError.setPlacement_id(str2);
            pointEntitySigmobError.setAdtype(String.valueOf(i));
        }
    }

    public void a(String str, String str2, j jVar) {
        this.d = str;
        this.e = str2;
        SigmobLogger.i(this.f13439a, CtFAbx.AmA8tU("expiredAdReload: originVid = ", str, ", originPrice = ", str2), new Object[0]);
    }

    public void a(String str, Map<String, String> map) {
        BaseAdUnit i = i();
        if (com.sigmob.sdk.base.o.a().ah()) {
            ae.a(str, (String) null, i, new A2egSU(1, map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, BaseAdUnit baseAdUnit, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put(PointParamKey.AD_COUNT, String.valueOf(list.size()));
            Map<String, String> l = l(baseAdUnit);
            if (com.sigmob.sdk.base.utils.e.b(l)) {
                options.putAll(l);
            }
            pointEntitySigmob.setOptions(options);
        }
    }

    public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest, BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.RESPOND, "1", baseAdUnit, loadAdRequest, new GnQT2j.A4TApA(8, this, list, baseAdUnit));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Map map, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            if (map == null) {
                return;
            }
            pointEntitySigmob.getOptions().putAll(map);
        }
    }

    public static boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        return a(Integer.valueOf(jVar.a()));
    }

    public static boolean a(Integer num) {
        if (num == null) {
            return false;
        }
        return num.intValue() == j.ReloadAfterExpiration.a() || num.intValue() == j.ActiveFailureReload.a();
    }
}
