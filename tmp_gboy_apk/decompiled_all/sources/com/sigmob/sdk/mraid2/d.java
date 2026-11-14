package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.common.util.CommConstant;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ai;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.mraid2.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d implements k {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13539a = "Mraid2Bridge";
    private static p e;
    private static final HashMap<String, List<String>> h = new HashMap<>();
    private final List<BaseAdUnit> b;
    private b c;
    private i d;
    private f f;
    private final List<BaseAdUnit> g;
    private volatile boolean i;
    private boolean j;
    private String k;

    /* renamed from: com.sigmob.sdk.mraid2.d$2, reason: invalid class name */
    public class AnonymousClass2 implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f13541a;
        final /* synthetic */ String b;

        public AnonymousClass2(d dVar, String str) {
            this.f13541a = dVar;
            this.b = str;
        }

        @Override // com.sigmob.sdk.base.network.e.a
        public void a(int i, String str, String str2, LoadAdRequest loadAdRequest) {
            this.f13541a.a(this.b, (BidResponse) null, i, str);
            ae.a(PointCategory.RESPOND, Constants.FAIL, loadAdRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(List list, BaseAdUnit baseAdUnit, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                Map<String, String> options = ((PointEntitySigmob) obj).getOptions();
                options.put(PointParamKey.AD_COUNT, String.valueOf(list.size()));
                options.put(PointParamKey.REQUEST_ID, baseAdUnit.getRequestId());
            }
        }

        @Override // com.sigmob.sdk.base.network.e.a
        public void a(final List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
            if (com.sigmob.sdk.base.utils.e.a(list)) {
                return;
            }
            list.size();
            d.this.g.addAll(list);
            this.f13541a.a(this.b, d.this.a(list), 0, (String) null);
            final BaseAdUnit baseAdUnit = list.get(0);
            ae.a(PointCategory.RESPOND, "1", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.mraid2.A2egSU
                @Override // com.sigmob.sdk.base.common.ae.a
                public final void onAddExtra(Object obj) {
                    d.AnonymousClass2.a(list, baseAdUnit, obj);
                }
            });
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<d> f13542a;

        public a(d dVar) {
            this.f13542a = new WeakReference<>(dVar);
        }

        public d a() {
            return this.f13542a.get();
        }

        @JavascriptInterface
        public String addDclog(JSONObject jSONObject) {
            Objects.toString(jSONObject);
            try {
                if (jSONObject == null) {
                    return d.a(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, "not params", (Object) null);
                }
                d a2 = a();
                final JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
                if (optJSONObject == null || !optJSONObject.has(PointParamKey._AC_TYPE)) {
                    return d.a(300, "_ac_type is empty", (Object) null);
                }
                String optString = optJSONObject.optString(PointParamKey._AC_TYPE);
                String optString2 = jSONObject.optString(PointParamKey.VID);
                if (optJSONObject.optString(PointParamKey.CATEGORY).equals("start") && a2 != null && a2.f != null) {
                    a2.f.d();
                }
                ae.a(optString, a2 == null ? null : a2.b(optString2), a2 == null ? null : a2.j(), new ae.a() { // from class: com.sigmob.sdk.mraid2.AMqCpz
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public final void onAddExtra(Object obj) {
                        d.a.a(optJSONObject, obj);
                    }
                });
                return d.a(200, "add dc log success", (Object) null);
            } catch (Throwable th) {
                return d.a(500, th.toString(), (Object) null);
            }
        }

        @JavascriptInterface
        public String func(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.has("func") ? jSONObject.getString("func") : null;
                if (TextUtils.isEmpty(string)) {
                    return d.a(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, "func is empty", (Object) null);
                }
                ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(this, string.replace(":", ""));
                methodBuilder.addParam(JSONObject.class, jSONObject);
                return (String) methodBuilder.execute();
            } catch (Throwable th) {
                return d.a(500, th.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String getDeviceInfo() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clientType", ClientMetadata.getDeviceModel());
                jSONObject.put("osVersion", ClientMetadata.getDeviceOsVersion());
                jSONObject.put("appVersion", ClientMetadata.getInstance().getAppVersion());
                jSONObject.put(MediaFormat.KEY_WIDTH, ClientMetadata.getInstance().getDisplayMetrics().widthPixels);
                jSONObject.put(MediaFormat.KEY_HEIGHT, ClientMetadata.getInstance().getDisplayMetrics().heightPixels);
                jSONObject.put("screenDensity", ClientMetadata.getInstance().getDensityDpi());
                jSONObject.put("networkType", ClientMetadata.getInstance().getActiveNetworkType());
                jSONObject.put("pkgName", ClientMetadata.getInstance().getAppPackageName());
                jSONObject.put("userAgent", Networking.getUserAgent());
                jSONObject.put("uid", ClientMetadata.getUid());
                jSONObject.put("udid", ClientMetadata.getInstance().getUDID());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("imei", "");
                jSONObject2.put("androidId", ClientMetadata.getInstance().getAndroidId());
                jSONObject2.put("googleId", ClientMetadata.getInstance().getAdvertisingId());
                jSONObject2.put("oaid", ClientMetadata.getInstance().getOAID());
                jSONObject.put("android", jSONObject2);
                return jSONObject.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @JavascriptInterface
        public String getUniqueId() {
            d a2 = a();
            if (a2 == null) {
                return null;
            }
            return a2.a().getUniqueId();
        }

        @JavascriptInterface
        public String handleMacro(JSONObject jSONObject) {
            String optString;
            JSONObject optJSONObject;
            char c;
            Objects.toString(jSONObject);
            if (jSONObject == null) {
                return null;
            }
            try {
                optString = jSONObject.optString("event");
                optJSONObject = jSONObject.optJSONObject("args");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (optJSONObject == null) {
                return null;
            }
            String optString2 = optJSONObject.optString("key");
            String optString3 = optJSONObject.optString("value");
            BaseAdUnit b = a() != null ? a().b(optJSONObject.optString(PointParamKey.VID)) : null;
            switch (optString.hashCode()) {
                case -1253019733:
                    if (optString.equals("addMacro")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -759131257:
                    if (optString.equals("addAllMacros")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -750002817:
                    if (optString.equals("clearMacro")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -310745688:
                    if (optString.equals("removeMacro")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1959477782:
                    if (optString.equals("getMacro")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("maps");
                if (optJSONObject2 == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    (b == null ? Sigmob.getInstance().getMacroCommon() : b.getMacroCommon()).addMarcoKey(next, optJSONObject2.optString(next));
                }
            } else if (c != 1) {
                if (c == 2) {
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return (b == null ? Sigmob.getInstance().getMacroCommon() : b.getMacroCommon()).getMarcoKey(optString2);
                }
                if (c != 3) {
                    if (c == 4) {
                        (b == null ? Sigmob.getInstance().getMacroCommon() : b.getMacroCommon()).clearMacro();
                    }
                } else {
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    (b == null ? Sigmob.getInstance().getMacroCommon() : b.getMacroCommon()).removeMarcoKey(optString2);
                }
            } else {
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                (b == null ? Sigmob.getInstance().getMacroCommon() : b.getMacroCommon()).addMarcoKey(optString2, optString3);
            }
            return null;
        }

        @JavascriptInterface
        public void postMessage(String str) {
            d a2;
            if (TextUtils.isEmpty(str) || (a2 = a()) == null || a2.d == null) {
                return;
            }
            a2.d.post(new A4TApA(a2, str, 0));
        }

        @JavascriptInterface
        public String storage(String str) {
            char c;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("event");
                    JSONObject optJSONObject = jSONObject.optJSONObject("args");
                    if (optJSONObject != null) {
                        int optInt = optJSONObject.optInt(PointParamKey.TYPE);
                        String optString2 = optJSONObject.optString("key");
                        String optString3 = optJSONObject.optString("value");
                        if (optInt == 1 || optInt == 2) {
                            if (d.e == null) {
                                p unused = d.e = new p(a().d.getContext());
                            }
                            switch (optString.hashCode()) {
                                case -1106363674:
                                    if (optString.equals("length")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -625809843:
                                    if (optString.equals("addEventListener")) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -75439223:
                                    if (optString.equals("getItem")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 94746189:
                                    if (optString.equals("clear")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1098253751:
                                    if (optString.equals("removeItem")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1984670357:
                                    if (optString.equals("setItem")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            if (c == 0) {
                                d.e.a(optInt, optString2, optString3);
                                return null;
                            }
                            if (c == 1) {
                                return d.e.a(optInt, optString2);
                            }
                            if (c == 2) {
                                d.e.b(optInt, optString2);
                                return null;
                            }
                            if (c == 3) {
                                d.e.a(optInt);
                                return null;
                            }
                            if (c == 4) {
                                return String.valueOf(d.e.b(optInt));
                            }
                            if (c == 5) {
                                d.e.a(optInt, optString2, new p.a() { // from class: com.sigmob.sdk.mraid2.A5SV6n
                                    @Override // com.sigmob.sdk.mraid2.p.a
                                    public final void valueChange(JSONObject jSONObject2) {
                                        d.a.this.a(jSONObject2);
                                    }
                                });
                                return null;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @JavascriptInterface
        public String tracking(JSONObject jSONObject) {
            int optInt;
            String optString;
            boolean z;
            boolean z2;
            boolean optBoolean;
            Objects.toString(jSONObject);
            try {
                if (jSONObject == null) {
                    return d.a(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, "not params", (Object) null);
                }
                String optString2 = jSONObject.optString("event");
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
                if (optJSONObject == null) {
                    optString = "";
                    optInt = 0;
                    optBoolean = false;
                    z = false;
                    z2 = false;
                } else {
                    boolean optBoolean2 = optJSONObject.optBoolean("inQueue");
                    boolean optBoolean3 = optJSONObject.optBoolean("statistic");
                    optInt = optJSONObject.optInt("retry");
                    optString = optJSONObject.optString(PointParamKey.VID);
                    z = optBoolean2;
                    z2 = optBoolean3;
                    optBoolean = optJSONObject.optBoolean("repeat");
                }
                d a2 = a();
                Context context = a2 == null ? null : a2.d.getContext();
                BaseAdUnit b = a2 == null ? null : a2.b(optString);
                if (TextUtils.equals(optString2, "click") && context != null && b != null) {
                    String requestId = b.getRequestId();
                    int optInt2 = optJSONObject == null ? 0 : optJSONObject.optInt("clickLoseRate");
                    int i = com.sigmob.sdk.base.utils.c.b;
                    if (optJSONObject != null) {
                        i = optJSONObject.optInt("clickCbState", i);
                    }
                    com.sigmob.sdk.base.utils.c.a(requestId, Integer.valueOf(optInt2), Integer.valueOf(i));
                    if (optJSONObject == null || optJSONObject.optBoolean("normalClick", true)) {
                        BaseBroadcastReceiver.a(context, b.getUuid(), IntentActions.ACTION_INTERSTITIAL_CLICK);
                    }
                }
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        ai aiVar = new ai(optJSONArray.optString(i2), optString2, b != null ? b.getRequestId() : "");
                        aiVar.setRetryNum(Integer.valueOf(optInt));
                        aiVar.setSource("js");
                        com.sigmob.sdk.base.network.g.a(aiVar, b, optBoolean, z, z2, null);
                    }
                    return d.a(200, "tracking success", (Object) null);
                }
                List<ai> adTracker = b != null ? b.getAdTracker(optString2) : null;
                if (adTracker != null) {
                    for (ai aiVar2 : adTracker) {
                        aiVar2.setRetryNum(Integer.valueOf(optInt));
                        aiVar2.setSource("js");
                        com.sigmob.sdk.base.network.g.a(aiVar2, b, optBoolean, z, z2, null);
                    }
                }
                return d.a(300, "urls is empty", (Object) null);
            } catch (Throwable th) {
                return d.a(500, "unknown error: " + th.getMessage(), (Object) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(JSONObject jSONObject) {
            i a2;
            d a3 = a();
            if (a3 == null || (a2 = a3.a()) == null) {
                return;
            }
            a2.post(new ADYaiT(a3, 0, jSONObject));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(JSONObject jSONObject, Object obj) {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!next.equalsIgnoreCase(PointParamKey._AC_TYPE)) {
                    hashMap.put(next, jSONObject.optString(next));
                }
            }
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                if (com.sigmob.sdk.base.utils.e.b(hashMap)) {
                    pointEntitySigmob.getOptions().putAll(hashMap);
                }
            }
        }
    }

    public interface b {
        void a();

        void a(BaseAdUnit baseAdUnit, JSONObject jSONObject);

        void a(String str);

        void a(String str, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b();

        void b(String str, JSONObject jSONObject);

        void b(JSONObject jSONObject);

        void c();

        void c(String str, JSONObject jSONObject);

        void c(JSONObject jSONObject);

        void d();

        void d(JSONObject jSONObject);

        void e(JSONObject jSONObject);

        void f(JSONObject jSONObject);

        void g(JSONObject jSONObject);
    }

    static {
        GfiQ();
    }

    public d(List<BaseAdUnit> list) {
        LinkedList linkedList = new LinkedList();
        this.g = linkedList;
        this.j = false;
        this.b = list;
        linkedList.addAll(list);
        ThreadPoolFactory.getFixIOExecutor().submit(new ADYaiT(this, 2, list));
    }

    private static /* synthetic */ void GfiQ() {
        char[] charArray = "åéë¨áçëã¨äéÿ¨õîãêê¨ÌèïÄôïâáã".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 134);
        }
        String str = new String(charArray);
        char[] charArray2 = "åêïèïò".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 134);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void i() {
        this.i = true;
        this.d.post(new AaHO0E(1, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LoadAdRequest j() {
        if (com.sigmob.sdk.base.utils.e.a(this.b)) {
            return null;
        }
        return this.b.get(0).getAdRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        try {
            f fVar = this.f;
            if (fVar != null) {
                fVar.c();
            }
            a(true);
            e();
            a(this.d.getAdSize());
            f();
            a(100);
            a(a(this.b), this.k);
        } catch (Throwable th) {
            SigmobLog.e("handleMraidLoad", th);
        }
    }

    public BaseAdUnit b(String str) {
        if (!TextUtils.isEmpty(str) && !com.sigmob.sdk.base.utils.e.a(this.g)) {
            for (int i = 0; i < this.g.size(); i++) {
                BaseAdUnit baseAdUnit = this.b.get(i);
                if (str.equals(baseAdUnit.getAd().vid)) {
                    return baseAdUnit;
                }
            }
        }
        return null;
    }

    public void g() {
        if (e != null) {
            e = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        a((b) null);
        a((f) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BidResponse a(List<BaseAdUnit> list) {
        Template build;
        List<MaterialMeta> list2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Ad ad = list.get(i).getAd();
            ArrayList arrayList2 = new ArrayList();
            if (ad != null && (list2 = ad.materials) != null && !list2.isEmpty()) {
                MaterialMeta.Builder newBuilder = ad.materials.get(0).newBuilder();
                Template template = newBuilder.main_template;
                if (template != null && template.type.intValue() == 2) {
                    Template build2 = newBuilder.main_template.newBuilder().context(null).build();
                    build2.templateId = newBuilder.main_template.templateId;
                    newBuilder.main_template(build2);
                }
                Template template2 = newBuilder.sub_template;
                if (template2 != null && template2.type.intValue() == 2) {
                    Template build3 = newBuilder.sub_template.newBuilder().context(null).build();
                    build3.templateId = newBuilder.sub_template.templateId;
                    newBuilder.sub_template(build3);
                }
                arrayList2.add(newBuilder.html_snippet(null).build());
                arrayList.add(ad.newBuilder().materials(arrayList2).build());
            }
        }
        BidResponse.Builder builder = new BidResponse.Builder();
        BaseAdUnit baseAdUnit = list.get(0);
        if (baseAdUnit != null) {
            Template template3 = baseAdUnit.scene;
            if (template3 != null) {
                if (template3.type.intValue() == 2) {
                    build = baseAdUnit.scene.newBuilder().context(null).build();
                    build.templateId = baseAdUnit.scene.templateId;
                } else {
                    build = baseAdUnit.scene.newBuilder().build();
                }
                builder.scene(build);
            }
            SlotAdSetting slotAdSetting = baseAdUnit.slotAdSetting;
            if (slotAdSetting != null) {
                builder.slot_ad_setting(slotAdSetting.newBuilder().build());
            }
            BiddingResponse biddingResponse = baseAdUnit.bidding_response;
            if (biddingResponse != null) {
                builder.bidding_response(biddingResponse.newBuilder().build());
            }
            builder.request_id(baseAdUnit.getRequestId());
            builder.uid(baseAdUnit.uid);
            builder.expiration_time(Integer.valueOf(baseAdUnit.expiration_time));
        }
        return builder.ads(arrayList).build();
    }

    public List<BaseAdUnit> c() {
        return this.g;
    }

    public void d() {
        a("mraidbridge.fireReadyEvent();");
    }

    public void e() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("orientation", ClientMetadata.getInstance().getOrientationInt());
            jSONObject2.put(PointCategory.LOCKED, true);
            jSONObject.put("orientation", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommConstant.SdkVersion.SDK_VERSION_KEY, com.sigmob.sdk.base.n.k);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ")", this);
    }

    public void g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public i a() {
        return this.d;
    }

    public void b(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("state", i);
            jSONObject.put("vdLoadStateChanged", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject.put("wvFinished", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void d(String str) {
        a("mraidbridge.nativeCallComplete(" + JSONObject.quote(str) + ")");
    }

    private void d(JSONObject jSONObject) {
        HashMap<String, i> mraidWebViews;
        d mraidBridge;
        if (jSONObject == null) {
            return;
        }
        String uniqueId = a().getUniqueId();
        String optString = jSONObject.optString("event");
        if (TextUtils.isEmpty(uniqueId) || TextUtils.isEmpty(optString)) {
            return;
        }
        List<String> list = h.get(uniqueId + "~" + optString);
        if (list == null || list.isEmpty() || (mraidWebViews = i.getMraidWebViews()) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            i iVar = mraidWebViews.get(it.next());
            if (iVar != null && (mraidBridge = iVar.getMraidBridge()) != null) {
                mraidBridge.a(uniqueId, optString, jSONObject);
            }
        }
    }

    public static String a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("message", str);
            }
            if (obj != null) {
                jSONObject.put(PointParamKey.DATA, obj);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public void a(int i) {
        a("mraidbridge.fireChangeEvent({\"exposure\":" + i + "});");
    }

    public void a(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PointParamKey.TYPE, i);
            jSONObject.put("index", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.notifyPageChangeEvent(", jSONObject, ");", this);
    }

    public void e(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", "fire_" + str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void f(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("message", str2);
            }
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void c(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("currentTime", i / 1000.0f);
            jSONObject.put("vdPlayToEnd", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void a(int i, int i2, int i3, int i4) {
        a("mraidbridge.setSafeAreaInsets(" + (i + "," + i2 + "," + i3 + "," + i4) + ")");
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        int pixelsToIntDips;
        int i;
        Context context = this.d.getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (gVar == null) {
                i = Dips.pixelsToIntDips(displayMetrics.widthPixels, context);
                pixelsToIntDips = Dips.pixelsToIntDips(displayMetrics.heightPixels, context);
            } else {
                int pixelsToIntDips2 = Dips.pixelsToIntDips(gVar.a(), context);
                pixelsToIntDips = Dips.pixelsToIntDips(gVar.b(), context);
                i = pixelsToIntDips2;
            }
            jSONObject2.put(MediaFormat.KEY_WIDTH, i);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, pixelsToIntDips);
            jSONObject.put("screenSize", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    private void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("uniqId");
        String optString2 = jSONObject.optString("event");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return;
        }
        HashMap<String, List<String>> hashMap = h;
        List<String> list = hashMap.get(optString2);
        if (list == null) {
            list = new ArrayList<>();
            hashMap.put(optString + "~" + optString2, list);
        }
        list.add(this.d.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list) {
        this.k = JSONSerializer.Serialize(a((List<BaseAdUnit>) list), "bidResponse", true, true);
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("uniqId");
        String optString2 = jSONObject.optString("event");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return;
        }
        List<String> list = h.get(optString + "~" + optString2);
        if (list == null) {
            return;
        }
        Iterator it = new CopyOnWriteArrayList(list).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.equals(optString)) {
                list.remove(str);
            }
        }
    }

    public void b(JSONObject jSONObject) {
        a("mraidbridge.onStorageChanged(" + jSONObject.toString() + ");");
    }

    public boolean b() {
        return this.i;
    }

    public void a(BidResponse bidResponse, String str) {
        if (TextUtils.isEmpty(str)) {
            str = JSONSerializer.Serialize(bidResponse, "bidResponse", true, true);
        }
        a("mraidbridge.fireChangeEvent(" + str + ");");
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01e5 A[Catch: Exception -> 0x0047, TryCatch #0 {Exception -> 0x0047, blocks: (B:3:0x000a, B:6:0x003b, B:11:0x019f, B:14:0x01a6, B:16:0x01ad, B:18:0x01b4, B:27:0x01ec, B:29:0x01dd, B:31:0x01e1, B:32:0x01e5, B:34:0x01e9, B:35:0x01c3, B:38:0x01cd, B:41:0x01f0, B:43:0x01f8, B:45:0x01fe, B:49:0x021c, B:51:0x0220, B:52:0x0223, B:54:0x0227, B:56:0x022b, B:57:0x022e, B:59:0x0232, B:61:0x023a, B:64:0x0246, B:66:0x024e, B:69:0x0258, B:71:0x0260, B:74:0x026a, B:76:0x026e, B:79:0x0272, B:81:0x0276, B:82:0x0279, B:84:0x027d, B:86:0x0281, B:87:0x0284, B:89:0x0288, B:91:0x028c, B:92:0x028f, B:94:0x0293, B:96:0x0297, B:99:0x029b, B:101:0x029f, B:102:0x02a2, B:104:0x02a6, B:106:0x02aa, B:107:0x02ad, B:109:0x02b1, B:111:0x02b5, B:112:0x02b8, B:114:0x02bc, B:116:0x02c4, B:119:0x02c8, B:121:0x02cc, B:124:0x02d0, B:126:0x02d4, B:129:0x02d8, B:131:0x02dc, B:134:0x02e0, B:136:0x02e6, B:137:0x02ed, B:139:0x02f3, B:140:0x02f7, B:142:0x02fd, B:143:0x0300, B:146:0x0304, B:148:0x030e, B:150:0x0314, B:151:0x0319, B:153:0x033f, B:155:0x0347, B:157:0x036a, B:158:0x0371, B:160:0x0379, B:161:0x0380, B:162:0x03cb, B:164:0x03fb, B:167:0x038b, B:168:0x03b9, B:173:0x03c4, B:174:0x03c8, B:175:0x03fe, B:177:0x0402, B:179:0x040c, B:181:0x0412, B:182:0x0417, B:183:0x041e, B:185:0x0424, B:188:0x0428, B:190:0x0439, B:191:0x043d, B:193:0x0443, B:195:0x0451, B:197:0x045e, B:200:0x048c, B:203:0x049e, B:208:0x04af, B:210:0x04b5, B:211:0x04bc, B:212:0x04c2, B:214:0x04c6, B:216:0x04ca, B:219:0x04ce, B:222:0x004a, B:225:0x0055, B:228:0x0061, B:231:0x006d, B:234:0x0079, B:237:0x0085, B:240:0x0090, B:243:0x009c, B:246:0x00a8, B:249:0x00b1, B:252:0x00bd, B:255:0x00c9, B:258:0x00d5, B:261:0x00e0, B:264:0x00ec, B:267:0x00f8, B:270:0x0103, B:273:0x010f, B:276:0x011b, B:279:0x0127, B:282:0x0132, B:285:0x013d, B:288:0x0148, B:291:0x0153, B:294:0x015e, B:297:0x0168, B:300:0x0173, B:303:0x017e, B:306:0x0189), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.sigmob.sdk.mraid2.d r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.d.a(com.sigmob.sdk.mraid2.d, java.lang.String):void");
    }

    public void a(f fVar) {
        this.f = fVar;
    }

    public void a(i iVar) {
        this.d = iVar;
        iVar.setScrollContainer(false);
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setBackgroundColor(0);
        this.d.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.mraid2.d.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return d.this.f == null ? super.onConsoleMessage(consoleMessage) : d.this.f.a(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (d.this.i || d.this.j || i <= 70) {
                    return;
                }
                d.this.j = true;
                d.this.a(g.b, (ValueCallback) null);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
    }

    public void a(String str) {
        if (!this.i) {
            SigmobLog.e("MRAID JS Not Load attached:\n\t" + str);
        } else if (this.d == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
        } else {
            SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
            this.d.b(str, (ValueCallback) null);
        }
    }

    public void a(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("state", i);
            jSONObject.put("vdPlayStateChanged", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void a(String str, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("currentTime", i / 1000.0f);
            jSONObject2.put(MediationConstant.EXTRA_DURATION, i2 / 1000.0f);
            jSONObject.put("vdPlayCurrentTime", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void a(String str, int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put(MediationConstant.EXTRA_DURATION, i / 1000.0f);
            jSONObject2.put(MediaFormat.KEY_WIDTH, i2);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, i3);
            jSONObject.put("vdReadyToPlay", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void a(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(PluginConstants.KEY_ERROR_CODE, i);
            jSONObject2.put("message", str2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("uniqueId", str);
            jSONObject3.put("error", jSONObject2);
            jSONObject.put("wvError", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void a(String str, ValueCallback valueCallback) {
        if (this.d == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
        } else {
            SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
            this.d.b(str, valueCallback);
        }
    }

    public void a(String str, BidResponse bidResponse, int i, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (bidResponse == null) {
                jSONObject = new JSONObject();
                jSONObject.put(PointParamKey.DATA, (Object) null);
            } else {
                jSONObject = new JSONObject(JSONSerializer.Serialize(bidResponse, PointParamKey.DATA, true, true));
            }
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            jSONObject.put("message", str2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("event", str);
            jSONObject3.put("message", jSONObject);
            jSONObject2.put("notify", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject2, ");", this);
    }

    public void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", str);
            jSONObject2.put("error", str2);
            jSONObject.put("vdPlayError", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    @Override // com.sigmob.sdk.mraid2.k
    public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str3);
            jSONObject2.put("uniqueId", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeFired", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void a(String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Object opt = jSONObject.opt(PointParamKey.DATA);
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("event", str + "~" + str2);
            if (opt != null) {
                jSONObject3.put(PointParamKey.DATA, opt);
            }
            jSONObject2.put("onChangeEvent", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject2, ");", this);
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeEvent", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    private void a(String str, Map map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ");", this);
    }

    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("bindData", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject2, ");", this);
    }

    public void a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewable", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.kwad.components.ad.reward.A2egSU.AMqCpz("mraidbridge.fireChangeEvent(", jSONObject, ")", this);
    }
}
