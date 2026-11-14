package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.br;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.hf.u;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class j implements com.bytedance.sdk.component.adexpress.kd.hf, ai.xj, com.bytedance.sdk.openadsdk.core.yo.hf {
    private static volatile boolean aq;
    private static final Map<String, Boolean> w;

    /* renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.widget.xj.xj f10360a;
    private List<ws> ai;
    private String am;
    private boolean b;
    private com.bytedance.sdk.openadsdk.core.yo.w c;
    private WeakReference<View> d;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.c.hf> dc;
    private WeakReference<com.bytedance.sdk.openadsdk.tf.xj> dk;
    private com.bytedance.sdk.openadsdk.y.xj en;
    private JSONObject et;
    private String f;
    private String ff;
    private ws g;
    private JSONObject hl;
    private WeakReference<com.bytedance.sdk.openadsdk.core.jk.xj> ht;

    /* renamed from: io, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.jk.hf> f10361io;
    private JSONObject jk;
    private com.bytedance.sdk.component.xj.e l;
    private c.xj n;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10362pl;
    private WeakReference<com.bytedance.sdk.openadsdk.core.yo.u> pz;
    private HashMap<String, d> q;
    private boolean r;
    private WeakReference<com.bytedance.sdk.openadsdk.core.jk.u> ra;
    private WeakReference<com.bytedance.sdk.openadsdk.core.jk.kd> s;
    private String tf;
    private AtomicBoolean tu;
    private WeakReference<SSWebView> u;
    private List<JSONObject> vm;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d> wn;
    private WeakReference<com.bytedance.sdk.openadsdk.core.jk.y> x;
    protected Map<String, Object> xj;
    private final WeakReference<Context> y;
    private SoftReference<com.bytedance.sdk.component.adexpress.hf.p> yo;
    private com.bytedance.sdk.openadsdk.core.ugeno.hf yy;
    boolean hf = false;
    private boolean qt = false;
    private boolean zg = true;
    private boolean e = true;
    private final com.bytedance.sdk.openadsdk.core.nativeexpress.p v = new com.bytedance.sdk.openadsdk.core.nativeexpress.p();
    private boolean z = false;
    private boolean j = false;
    private boolean wo = false;
    private boolean ws = false;
    private boolean eu = false;
    private boolean tj = false;
    private com.bytedance.sdk.component.utils.ai kd = new com.bytedance.sdk.component.utils.ai(Looper.getMainLooper(), this);

    public static class xj {
        public String hf;
        public int kd;
        public JSONObject u;
        public String w;
        public String xj;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        w = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
        aq = false;
        PfMfgT();
    }

    public j(Context context) {
        this.y = new WeakReference<>(context);
    }

    private static /* synthetic */ void PfMfgT() {
        char[] charArray = "ÏÃÁ\u0082ËÍÁÉ\u0082ÎÃÕ\u0082ßÄÉÀÀ\u0082æÂÅîÞÅÈËÉ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 172);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÏÀÅÂÅØ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 172);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean a() {
        return f.zg().yy();
    }

    private JSONObject b() {
        View view;
        SSWebView sSWebView;
        try {
            view = this.d.get();
            sSWebView = this.u.get();
        } catch (Throwable unused) {
        }
        if (view == null || sSWebView == null) {
            com.bytedance.sdk.component.utils.pl.u("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        }
        int[] hf = r.hf(view);
        int[] hf2 = r.hf(sSWebView);
        if (hf != null && hf2 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", r.u(pz.getContext(), hf[0] - hf2[0]));
            jSONObject.put("y", r.u(pz.getContext(), hf[1] - hf2[1]));
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, r.u(pz.getContext(), view.getWidth()));
            jSONObject.put("h", r.u(pz.getContext(), view.getHeight()));
            jSONObject.put("isExist", true);
            return jSONObject;
        }
        com.bytedance.sdk.component.utils.pl.u("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
        return null;
    }

    private void dc() {
        if (this.c == null) {
            this.c = com.bytedance.sdk.openadsdk.core.yo.xj.xj(this, this.g, this.ws);
        }
    }

    private void eu() {
        WeakReference<com.bytedance.sdk.openadsdk.core.jk.y> weakReference = this.x;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.x.get().xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl() {
        Context context;
        List<ws> list = this.ai;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.q = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.u;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.y;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (ws wsVar : this.ai) {
            this.q.put(wsVar.ho(), new d(context, wsVar, sSWebView, this.ff));
        }
    }

    private JSONObject n() {
        return xj(this.g, this.tu);
    }

    private void qt(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.jk.hf> weakReference = this.f10361io;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.f10361io.get().xj(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, -1), jSONObject.optString(br.c, ""));
    }

    private com.bytedance.sdk.component.g.w r() {
        WeakReference<SSWebView> weakReference = this.u;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void tj() {
        WeakReference<com.bytedance.sdk.openadsdk.core.jk.y> weakReference = this.x;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.x.get().hf();
    }

    private boolean vm() {
        ws wsVar = this.g;
        if (wsVar == null || wsVar.pn() == null || com.bytedance.sdk.openadsdk.core.a.ht.hf(this.g) || this.z || this.g.pn().optInt("parent_type") != 2) {
            return false;
        }
        int f = wo.f(this.g);
        if (f != 8 && f != 7) {
            return false;
        }
        this.z = true;
        return true;
    }

    private boolean wn() {
        return this.wn != null;
    }

    private void wo() {
        ws wsVar;
        WeakReference<SSWebView> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null || (wsVar = this.g) == null) {
            return;
        }
        int ee = wsVar.ee();
        int pw = this.g.pw();
        int ky = this.g.ky();
        int le = this.g.le();
        int oa = this.g.oa();
        JSONObject ki = this.g.ki();
        JSONObject ya = this.g.ya();
        JSONObject eg = this.g.eg();
        this.u.get().setShakeValue(ee);
        this.u.get().setDeepShakeValue(pw);
        this.u.get().setWriggleValue(ky);
        this.u.get().setTwistConfig(ki);
        this.u.get().setShakeInteractConf(ya);
        this.u.get().setTwistInteractConf(eg);
        this.u.get().setCalculationMethod(le);
        this.u.get().setCalculationTwistMethod(oa);
    }

    private static List<String> ws() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private void yy() {
        ne kt;
        Context context;
        ws wsVar = this.g;
        if (wsVar != null && (kt = wsVar.kt()) != null && kt.hf() == 1 && kt.y() == 1) {
            dc();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PointParamKey.DATA, new JSONObject());
            } catch (Throwable unused) {
            }
            WeakReference<Context> weakReference = this.y;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            this.c.xj(context, jSONObject, this.tf, this.p, this.qt, true);
            xj(jSONObject, false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void adAnalysisData(String str) {
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = pl();
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public void ai() {
        com.bytedance.sdk.openadsdk.core.yo.w wVar = this.c;
        if (wVar != null) {
            wVar.hf();
        }
    }

    public void am() {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().w(this.g, "stats_reward_full_deal_skip_video");
        this.v.c();
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            w(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public boolean c() {
        return this.eu;
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    j.this.c(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    j.this.tf(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        });
    }

    public boolean d() {
        ws wsVar = this.g;
        return wsVar != null && wsVar.hl();
    }

    public void dk() {
        ws wsVar = this.g;
        if (wsVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.w(wsVar, this.y.get(), io());
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            pl(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public void e() {
        this.v.kd();
    }

    public void en() {
        WeakReference<com.bytedance.sdk.openadsdk.core.jk.kd> weakReference = this.s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.s.get().xj();
    }

    public JSONObject et() {
        JSONObject jSONObject = new JSONObject();
        ws wsVar = this.g;
        if (wsVar != null) {
            String he = wsVar.he();
            if (!TextUtils.isEmpty(he)) {
                try {
                    return new JSONObject(he);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        }
        return jSONObject;
    }

    public void f(boolean z) {
        this.tj = z;
    }

    public void ff() {
        this.v.y();
    }

    public JSONObject g() {
        JSONObject jSONObject = this.jk;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        if (this.g != null) {
            jSONObject.put("setting", n());
            jSONObject.put("extension", this.g.m());
        }
        this.jk = jSONObject;
        return jSONObject;
    }

    public Context getContext() {
        return this.y.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        zg(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.jk.toString();
        }
        try {
            JSONObject xj2 = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(this.jk, new JSONObject(str));
            return xj2 == null ? this.jk.toString() : xj2.toString();
        } catch (Exception unused) {
            return this.jk.toString();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public String getTemplateInfo() {
        hf("getTemplateInfo", true);
        try {
            g();
            hf("getTemplateInfo", false);
            return this.jk.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean ht() {
        ws wsVar = this.g;
        return wsVar != null && com.bytedance.sdk.openadsdk.core.ra.jk.p(wsVar) == 1;
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void initRenderFinish() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f10360a != null) {
                    com.bytedance.sdk.openadsdk.core.widget.xj.xj unused = j.this.f10360a;
                }
            }
        });
    }

    public String io() {
        return wo.xj(this.p);
    }

    public int j() {
        if (this.v.pl() == null) {
            return 0;
        }
        return this.v.pl().w();
    }

    public void jk() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClickCommon.CLICK_AREA_MATERIAL, xj(this.ai));
            xj("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    public int kd(boolean z) {
        if (com.bytedance.sdk.openadsdk.core.ra.en.xj(this.g) != 0 && z) {
            return 2;
        }
        if (this.r) {
            return 1;
        }
        return this.b ? com.bytedance.sdk.openadsdk.core.ra.en.xj(this.g) == 2 ? 2 : 1 : com.bytedance.sdk.openadsdk.core.ra.en.xj(this.g) == 0 ? 1 : 2;
    }

    public void l() {
        if (this.v.pl() != null) {
            this.v.pl().d();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    j.this.y(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        });
    }

    public JSONObject p() {
        return this.hl;
    }

    public JSONObject pl() {
        return com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(this.g, this.am);
    }

    public boolean pz() {
        return this.wo;
    }

    public void q() {
        kd();
        com.bytedance.sdk.openadsdk.core.yo.w wVar = this.c;
        if (wVar != null) {
            wVar.w();
        }
        WeakReference<SSWebView> weakReference = this.u;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<View> weakReference2 = this.d;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<Context> weakReference3 = this.y;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        this.f10360a = null;
        this.yy = null;
    }

    public void ra() {
        ws wsVar = this.g;
        if (wsVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.hf(wsVar, this.y.get(), io());
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            p(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.v.xj(jSONObject.optInt("time"), jSONObject.optString("flag"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state_type", 2);
            jSONObject2.put("jsb_name", "requestPauseVideo");
            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(this.g, jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.hf
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().w(this.g, "stats_reward_full_call_skip_video");
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.8
            @Override // java.lang.Runnable
            public void run() {
                j.this.am();
            }
        });
    }

    public boolean tf() {
        return this.hf;
    }

    public void v() {
        xj((JSONObject) null, new com.bytedance.sdk.openadsdk.core.jk.w() { // from class: com.bytedance.sdk.openadsdk.core.j.12
            @Override // com.bytedance.sdk.openadsdk.core.jk.w
            public void xj(boolean z, List<ws> list, boolean z2) {
                j.this.ai = list;
                j.this.hl();
                j.this.jk();
            }
        });
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.yo.w wVar = this.c;
        if (wVar != null) {
            wVar.xj();
        }
        if (vm()) {
            v();
        }
    }

    public com.bytedance.sdk.component.xj.e y() {
        return this.l;
    }

    public void yo() {
        WeakReference<com.bytedance.sdk.openadsdk.tf.xj> weakReference = this.dk;
        if (weakReference == null || weakReference.get() == null) {
            this.v.p();
        } else {
            this.dk.get().xj();
        }
    }

    public void z() {
        WeakReference<com.bytedance.sdk.openadsdk.core.jk.u> weakReference = this.ra;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ra.get().xj();
    }

    public void zg() {
        this.v.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private JSONObject pz(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh;
        if (this.xj != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                if (ai.c()) {
                    try {
                        ws wsVar = this.g;
                        if (wsVar != null && (gh = wsVar.gh()) != null) {
                            String g = gh.g();
                            if (!TextUtils.isEmpty(g)) {
                                jSONObject2.putOpt("media_extra", g);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.xj.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.w(e.toString());
            }
        }
        return jSONObject;
    }

    private void v(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            jk(jSONObject);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.jk(jSONObject);
                }
            });
        }
    }

    private boolean zg(JSONObject jSONObject) {
        if (this.v.pl() != null && jSONObject != null) {
            double xj2 = this.v.pl().xj();
            int hf = this.v.pl().hf();
            try {
                jSONObject.put("currentTime", xj2 / 1000.0d);
                jSONObject.put("state", hf);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void c(boolean z) {
        this.eu = z;
    }

    public void d(boolean z) {
        this.hf = z;
    }

    public ws f() {
        return this.g;
    }

    public void p(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.y.xj xjVar = this.en;
        if (xjVar != null) {
            xjVar.w(jSONObject);
        }
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("renderDidFinish") { // from class: com.bytedance.sdk.openadsdk.core.j.10
            @Override // java.lang.Runnable
            public void run() {
                int i;
                double d;
                double d2;
                boolean z;
                double d3;
                double d4;
                int i2;
                String optString;
                double d5;
                double d6;
                double d7;
                if (j.this.yo == null || j.this.yo.get() == null || jSONObject == null || j.this.y == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.hf.am amVar = new com.bytedance.sdk.component.adexpress.hf.am();
                amVar.xj(1);
                try {
                    boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
                    JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
                    if (optJSONObject != null) {
                        d = optJSONObject.optDouble(MediaFormat.KEY_WIDTH);
                        d2 = optJSONObject.optDouble(MediaFormat.KEY_HEIGHT);
                    } else {
                        d = 0.0d;
                        d2 = 0.0d;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("videoInfo");
                    if (optJSONObject2 != null) {
                        float f = ((Context) j.this.y.get()).getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        double optDouble = optJSONObject2.optDouble("x");
                        z = optBoolean;
                        i2 = 101;
                        double optDouble2 = optJSONObject2.optDouble("y");
                        d4 = d2;
                        double optDouble3 = optJSONObject2.optDouble(MediaFormat.KEY_WIDTH);
                        double optDouble4 = optJSONObject2.optDouble(MediaFormat.KEY_HEIGHT);
                        if (j.this.e(optJSONObject2)) {
                            d3 = d;
                            double optDouble5 = optJSONObject2.optDouble("borderRadiusTopLeft");
                            d6 = optDouble4;
                            double optDouble6 = optJSONObject2.optDouble("borderRadiusTopRight");
                            d7 = optDouble3;
                            double optDouble7 = optJSONObject2.optDouble("borderRadiusBottomLeft");
                            d5 = optDouble2;
                            double optDouble8 = optJSONObject2.optDouble("borderRadiusBottomRight");
                            if (pz.hf().fa()) {
                                amVar.xj(r.hf(f, r.xj(f2, (float) optDouble5)));
                                amVar.hf(r.hf(f, r.xj(f2, (float) optDouble6)));
                                amVar.w(r.hf(f, r.xj(f2, (float) optDouble7)));
                                amVar.u(r.hf(f, r.xj(f2, (float) optDouble8)));
                            } else {
                                amVar.xj((float) optDouble5);
                                amVar.hf((float) optDouble6);
                                amVar.w((float) optDouble7);
                                amVar.u((float) optDouble8);
                            }
                        } else {
                            d5 = optDouble2;
                            d6 = optDouble4;
                            d3 = d;
                            d7 = optDouble3;
                        }
                        if (pz.hf().fa()) {
                            amVar.w(r.hf(f, r.xj(f2, (float) optDouble)));
                            amVar.u(r.hf(f, r.xj(f2, (float) d5)));
                            amVar.kd(r.hf(f, r.xj(f2, (float) d7)));
                            amVar.y(r.hf(f, r.xj(f2, (float) d6)));
                        } else {
                            amVar.w(optDouble);
                            amVar.u(d5);
                            amVar.kd(d7);
                            amVar.y(d6);
                        }
                    } else {
                        z = optBoolean;
                        d3 = d;
                        d4 = d2;
                        i2 = 101;
                    }
                    optString = jSONObject.optString(br.c, c.xj(i2));
                    i = 101;
                } catch (Exception unused) {
                    i = 101;
                }
                try {
                    int optInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, 101);
                    amVar.xj(z);
                    amVar.xj(d3);
                    amVar.hf(d4);
                    amVar.xj(optString);
                    amVar.hf(optInt);
                    ((com.bytedance.sdk.component.adexpress.hf.p) j.this.yo.get()).xj(amVar);
                } catch (Exception unused2) {
                    amVar.hf(i);
                    amVar.xj(c.xj(i));
                    ((com.bytedance.sdk.component.adexpress.hf.p) j.this.yo.get()).xj(amVar);
                }
            }
        });
    }

    public void pl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri parse = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.core.a.pz.xj(parse, this);
            }
        } catch (Exception unused) {
        }
    }

    public void tf(JSONObject jSONObject) {
        j jVar;
        SoftReference<com.bytedance.sdk.component.adexpress.hf.p> softReference;
        double optDouble;
        double d;
        double d2;
        double d3;
        double d4;
        String str;
        String str2;
        String str3;
        double d5;
        double d6;
        int i;
        int i2;
        JSONObject jSONObject2;
        double d7;
        double d8;
        com.bytedance.sdk.openadsdk.core.ra.ra xj2;
        int i3;
        SoftReference<com.bytedance.sdk.component.adexpress.hf.p> softReference2;
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("clickAreaType");
            String optString3 = jSONObject.optString("clickAreaId");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            String optString4 = jSONObject.optString("subConvertLinkTag");
            int optInt2 = jSONObject.optInt("dpaPosition", -1);
            JSONObject jSONObject3 = new JSONObject();
            com.bytedance.sdk.openadsdk.core.ra.zg.xj(jSONObject.optString("clickScene"));
            jSONObject3.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            jSONObject3.put("live_saas_param_interaction_type", jSONObject.optInt("live_saas_param_interaction_type", -1));
            jSONObject3.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            double d9 = -1.0d;
            if (optJSONObject != null) {
                try {
                    double optDouble2 = optJSONObject.optDouble("down_x", -1.0d);
                    double optDouble3 = optJSONObject.optDouble("down_y", -1.0d);
                    double optDouble4 = optJSONObject.optDouble("up_x", -1.0d);
                    double optDouble5 = optJSONObject.optDouble("up_y", -1.0d);
                    double optDouble6 = optJSONObject.optDouble("down_time", -1.0d);
                    double optDouble7 = optJSONObject.optDouble("up_time", -1.0d);
                    double optDouble8 = optJSONObject.optDouble("button_x", -1.0d);
                    double optDouble9 = optJSONObject.optDouble("button_y", -1.0d);
                    double optDouble10 = optJSONObject.optDouble("button_width", -1.0d);
                    optDouble = optJSONObject.optDouble("button_height", -1.0d);
                    d9 = optDouble2;
                    d = optDouble3;
                    d2 = optDouble4;
                    d3 = optDouble9;
                    d4 = optDouble10;
                    str = optString;
                    str2 = optString2;
                    str3 = optString4;
                    d5 = optDouble5;
                    d6 = optDouble6;
                    i = optInt;
                    i2 = optInt2;
                    jSONObject2 = jSONObject3;
                    d7 = optDouble7;
                    d8 = optDouble8;
                } catch (Exception unused) {
                    jVar = this;
                    softReference = jVar.yo;
                    if (softReference != null || softReference.get() == null) {
                        jVar.yy();
                    } else {
                        jVar.yo.get().xj(null, -1, null);
                        return;
                    }
                }
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                optDouble = -1.0d;
                str = optString;
                i = optInt;
                str2 = optString2;
                str3 = optString4;
                i2 = optInt2;
                jSONObject2 = jSONObject3;
                d7 = -1.0d;
                d6 = -1.0d;
                d5 = -1.0d;
                d8 = -1.0d;
            }
            xj2 = new ra.xj().u((float) d9).w((float) d).hf((float) d2).xj((float) d5).hf((long) d6).xj((long) d7).xj((int) d8).hf((int) d3).w((int) d4).u((int) optDouble).xj(str2).hf(optString3).xj(true).xj((SparseArray<u.xj>) null).xj(jSONObject2).kd(str3).kd(i2).xj();
            jVar = this;
            i3 = i;
        } catch (Exception unused2) {
            jVar = this;
        }
        try {
            if (jVar.xj(str, i3, xj2) || (softReference2 = jVar.yo) == null || softReference2.get() == null) {
                jVar.yy();
            } else {
                jVar.yo.get().xj(null, i3, xj2);
            }
        } catch (Exception unused3) {
            softReference = jVar.yo;
            if (softReference != null) {
            }
            jVar.yy();
        }
    }

    public boolean u() {
        WeakReference<SSWebView> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.u.get().H_();
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d w() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d> weakReference = this.wn;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public j y(boolean z) {
        this.j = z;
        return this;
    }

    public void am(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f = jSONObject.optString("cid");
        this.tf = jSONObject.optString("log_extra");
    }

    public void c(JSONObject jSONObject) {
        if (this.v.pl() == null || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("stateType", -1);
            this.v.pl().xj(optInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jsb_name", "changeVideoState");
            jSONObject2.put("state_type", optInt);
            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(this.g, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void d(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        String str;
        String str2;
        double d8;
        double d9;
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("adId");
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("subConvertLinkTag");
            int optInt2 = jSONObject.optInt("dpaPosition", -1);
            String optString3 = jSONObject.optString("clickAreaType");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            double d10 = -1.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", -1.0d);
                double optDouble2 = optJSONObject.optDouble("down_y", -1.0d);
                double optDouble3 = optJSONObject.optDouble("up_x", -1.0d);
                double optDouble4 = optJSONObject.optDouble("up_y", -1.0d);
                double optDouble5 = optJSONObject.optDouble("down_time", -1.0d);
                double optDouble6 = optJSONObject.optDouble("up_time", -1.0d);
                double optDouble7 = optJSONObject.optDouble("button_x", -1.0d);
                double optDouble8 = optJSONObject.optDouble("button_y", -1.0d);
                double optDouble9 = optJSONObject.optDouble("button_width", -1.0d);
                d7 = optJSONObject.optDouble("button_height", -1.0d);
                str = optString;
                d10 = optDouble;
                d = optDouble2;
                d8 = optDouble3;
                d2 = optDouble5;
                d3 = optDouble6;
                d4 = optDouble7;
                d5 = optDouble8;
                d6 = optDouble9;
                str2 = optString2;
                d9 = optDouble4;
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                d7 = -1.0d;
                str = optString;
                str2 = optString2;
                d8 = -1.0d;
                d9 = -1.0d;
            }
            com.bytedance.sdk.openadsdk.core.ra.ra xj2 = new ra.xj().u((int) d10).w((int) d).hf((int) d8).xj((int) d9).hf((long) d2).xj((long) d3).xj((int) d4).hf((int) d5).w((int) d6).u((int) d7).xj(optString3).xj(true).xj(jSONObject2).xj((SparseArray<u.xj>) null).kd(str2).kd(optInt2).xj();
            SoftReference<com.bytedance.sdk.component.adexpress.hf.p> softReference = this.yo;
            if (softReference != null && softReference.get() != null) {
                this.yo.get().xj(null, optInt, xj2, f(jSONObject));
            }
            xj(str, optInt, xj2);
        } catch (Exception unused) {
            SoftReference<com.bytedance.sdk.component.adexpress.hf.p> softReference2 = this.yo;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.yo.get().xj(null, -1, null, 0);
        }
    }

    public int f(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.g.w(true);
            return 2;
        }
        if (jSONObject.optInt("downloadDialogStatus") != 1) {
            return 0;
        }
        if (this.g.kc().xj() == 2) {
            this.g.w(true);
        }
        return 1;
    }

    public JSONObject hf() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d> weakReference = this.wn;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.wn.get().getCreativeVideoViewInfo();
    }

    public void y(JSONObject jSONObject) {
        if (this.v.pl() == null || jSONObject == null) {
            return;
        }
        try {
            this.v.pl().xj(jSONObject.optBoolean(com.sigmob.sdk.base.common.a.z, false));
        } catch (Exception unused) {
        }
    }

    private void yo(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.yo.u> weakReference;
        com.bytedance.sdk.openadsdk.core.yo.u uVar;
        if (jSONObject == null || (weakReference = this.pz) == null || (uVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                uVar.xj(true, optJSONArray);
            } else {
                uVar.xj(false, null);
            }
        } catch (Exception unused) {
            uVar.xj(false, null);
        }
    }

    public void u(boolean z) {
        this.b = z;
    }

    public void w(boolean z) {
        this.r = z;
    }

    public static void hf(boolean z) {
        aq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(JSONObject jSONObject) {
        com.bytedance.sdk.component.g.w r = r();
        if (r != null) {
            com.bytedance.sdk.component.utils.p.xj(r, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")");
        }
    }

    public void p(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", !z ? 1 : 0);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("TTAndroidObject", e.getMessage());
        }
        u("visibleStateChange", jSONObject);
    }

    public j u(String str) {
        this.tf = str;
        return this;
    }

    public j w(String str) {
        this.am = str;
        return this;
    }

    public static JSONArray xj(List<ws> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                jSONArray.put(list.get(i).ac());
            }
        }
        return jSONArray;
    }

    private void y(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                xj xjVar = new xj();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        xjVar.xj = optJSONObject.optString("__msg_type", null);
                        xjVar.hf = optJSONObject.optString("__callback_id", null);
                        xjVar.w = optJSONObject.optString("func");
                        xjVar.u = optJSONObject.optJSONObject("params");
                        xjVar.kd = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(xjVar.xj) && !TextUtils.isEmpty(xjVar.w)) {
                    Message obtainMessage = this.kd.obtainMessage(11);
                    obtainMessage.obj = xjVar;
                    this.kd.sendMessage(obtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.component.utils.pl.xj()) {
                com.bytedance.sdk.component.utils.pl.hf("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            com.bytedance.sdk.component.utils.pl.hf("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    public j hf(SSWebView sSWebView) {
        this.u = new WeakReference<>(sSWebView);
        return this;
    }

    public void kd() {
        com.bytedance.sdk.component.xj.e eVar = this.l;
        if (eVar == null) {
            return;
        }
        eVar.xj();
        this.l = null;
    }

    public void u(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.y.xj xjVar;
        if (jSONObject == null || (xjVar = this.en) == null) {
            return;
        }
        xjVar.u(jSONObject);
    }

    public j w(int i) {
        this.p = i;
        return this;
    }

    public j hf(String str) {
        this.f = str;
        return this;
    }

    public void pl(boolean z) {
        this.tu = new AtomicBoolean(z);
    }

    public j w(List<ws> list) {
        this.ai = list;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        int indexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    com.bytedance.sdk.component.g.w r = r();
                    if (r != null) {
                        com.bytedance.sdk.component.utils.p.xj(r, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (str.startsWith("bytedance://private/setresult/") && (indexOf = str.indexOf(38, 30)) > 0) {
                    String substring = str.substring(30, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (!substring.equals("SCENE_FETCHQUEUE") || substring2.length() <= 0) {
                        return;
                    }
                    y(substring2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void w(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = ws().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.core.f.xj.xj());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.core.f.xj.kd());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.core.f.xj.hf());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.core.f.xj.w());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.core.f.xj.u());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.core.f.xj.y());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.core.f.xj.c());
        jSONObject.put("themeStatus", f.zg().wn());
    }

    public boolean g(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", xj(this.ai));
        } catch (Exception unused) {
        }
        return true;
    }

    public j hf(List<JSONObject> list) {
        this.vm = list;
        return this;
    }

    public void qt() {
        this.v.f();
    }

    public void u(int i) {
        this.v.hf(i);
    }

    private void u(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            v(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public j hf(int i) {
        this.qt = true;
        return this;
    }

    public j kd(String str) {
        this.f10362pl = str;
        return this;
    }

    private boolean c(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || ht();
    }

    public void hf(JSONObject jSONObject) {
        this.hl = jSONObject;
    }

    public j kd(JSONObject jSONObject) {
        this.jk = jSONObject;
        return this;
    }

    public j xj(String str) {
        this.ff = str;
        return this;
    }

    private void hf(String str, boolean z) {
        if (this.en == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.en.y(str);
        } else {
            this.en.c(str);
        }
    }

    private void kd(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject2;
        String str6 = "click";
        String str7 = "";
        try {
            if ("show".equals(str)) {
                jSONArray = jSONObject.optJSONArray("show_url");
                str6 = "show";
            } else if ("click".equals(str)) {
                jSONArray = jSONObject.getJSONArray("click_url");
            } else {
                str6 = null;
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                String w2 = yo.w();
                if (TextUtils.isEmpty(w2)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                String optString = jSONObject.optString("log_extra");
                try {
                    jSONObject2 = new JSONObject(optString);
                    str2 = jSONObject2.optString(MediationConstant.EXTRA_ADID);
                    try {
                        str3 = jSONObject2.optString("creative_id");
                    } catch (Throwable unused) {
                        str3 = "";
                        str4 = str3;
                        str5 = str4;
                        HashMap hashMap = new HashMap();
                        hashMap.put("aid", str2);
                        hashMap.put("cid", str3);
                        hashMap.put("req_id", str4);
                        hashMap.put("customer_id", str5);
                        com.bytedance.sdk.openadsdk.core.ht.hf.xj(w2, arrayList, true, hashMap, com.bytedance.sdk.openadsdk.core.am.u.xj(optString, str2, str4, str7, str6));
                    }
                } catch (Throwable unused2) {
                    str2 = "";
                    str3 = str2;
                }
                try {
                    str4 = jSONObject2.optString("req_id");
                    try {
                        str5 = jSONObject2.optString("customer_id");
                        try {
                            str7 = wo.hf(jSONObject2.optInt("ad_slot_type"));
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable unused4) {
                        str5 = "";
                    }
                } catch (Throwable unused5) {
                    str4 = "";
                    str5 = str4;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("aid", str2);
                    hashMap2.put("cid", str3);
                    hashMap2.put("req_id", str4);
                    hashMap2.put("customer_id", str5);
                    com.bytedance.sdk.openadsdk.core.ht.hf.xj(w2, arrayList, true, hashMap2, com.bytedance.sdk.openadsdk.core.am.u.xj(optString, str2, str4, str7, str6));
                }
                HashMap hashMap22 = new HashMap();
                hashMap22.put("aid", str2);
                hashMap22.put("cid", str3);
                hashMap22.put("req_id", str4);
                hashMap22.put("customer_id", str5);
                com.bytedance.sdk.openadsdk.core.ht.hf.xj(w2, arrayList, true, hashMap22, com.bytedance.sdk.openadsdk.core.am.u.xj(optString, str2, str4, str7, str6));
            }
        } catch (Throwable unused6) {
        }
    }

    public j xj(boolean z) {
        this.ws = z;
        return this;
    }

    public j xj(SSWebView sSWebView) {
        com.bytedance.sdk.component.utils.pl.u("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        com.bytedance.sdk.component.xj.e hf = com.bytedance.sdk.component.xj.e.xj(sSWebView).xj(new com.bytedance.sdk.openadsdk.d.xj()).xj("ToutiaoJSBridge").xj(new com.bytedance.sdk.component.xj.pl() { // from class: com.bytedance.sdk.openadsdk.core.j.1
            @Override // com.bytedance.sdk.component.xj.pl
            public <T> T xj(String str, Type type) {
                return null;
            }

            @Override // com.bytedance.sdk.component.xj.pl
            public <T> String xj(T t) {
                return null;
            }
        }).xj(a()).hf(true).xj().hf();
        this.l = hf;
        com.bytedance.sdk.openadsdk.core.v.xj.pz.xj(hf, this);
        com.bytedance.sdk.openadsdk.core.v.xj.kd.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.y.xj(this.l, this, this.g);
        com.bytedance.sdk.openadsdk.core.v.xj.am.xj(this.l);
        com.bytedance.sdk.openadsdk.core.v.xj.dk.xj(this.l, sSWebView);
        com.bytedance.sdk.openadsdk.core.v.xj.c.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.p.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.l.xj(this.l, this);
        com.bytedance.sdk.openadsdk.d.xj.u.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.v.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.e.xj(this.l, this);
        com.bytedance.sdk.openadsdk.d.xj.w.xj(this.l, this);
        com.bytedance.sdk.openadsdk.d.xj.xj.xj(this.l, this);
        com.bytedance.sdk.openadsdk.d.xj.kd.xj(this.l, this);
        com.bytedance.sdk.openadsdk.d.xj.y.xj(this.l, this);
        com.bytedance.sdk.openadsdk.d.xj.hf.xj(this.l, this);
        wo();
        com.bytedance.sdk.openadsdk.core.v.xj.w.xj(this.l, this.u.get(), this.f);
        com.bytedance.sdk.openadsdk.core.v.xj.io.xj(this.l, this.u.get(), this.f);
        com.bytedance.sdk.openadsdk.core.v.xj.hf.xj(this.l, this.u.get(), this.f);
        com.bytedance.sdk.openadsdk.core.v.xj.et.xj(this.l, this.u.get(), this.f);
        com.bytedance.sdk.openadsdk.core.v.xj.z.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.jk.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.en.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.zg.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.qt.xj(this.l, this.g);
        com.bytedance.sdk.openadsdk.core.v.xj.ht.xj(this.l, this.y.get(), this.g);
        com.bytedance.sdk.openadsdk.core.v.xj.tf.xj(this.l, this.g, this.vm);
        com.bytedance.sdk.openadsdk.core.v.xj.ra.xj(this.l, this, this.dc);
        com.bytedance.sdk.openadsdk.core.v.xj.q.xj(this.l, this, this.dc);
        com.bytedance.sdk.openadsdk.core.v.xj.wo.xj(this.l, sSWebView, this);
        com.bytedance.sdk.openadsdk.core.v.xj.d.xj(this.l, this.g, this);
        com.bytedance.sdk.openadsdk.core.v.xj.g.xj(this.l, this.g, this);
        com.bytedance.sdk.openadsdk.core.v.xj.a.xj(this.l, this.n);
        com.bytedance.sdk.openadsdk.core.v.xj.ff.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.x.xj(this.l, this.yy);
        com.bytedance.sdk.openadsdk.core.v.xj.ai.xj(this.l, this, this.g);
        com.bytedance.sdk.openadsdk.core.v.xj.pl.xj(this.l, this.jk);
        com.bytedance.sdk.openadsdk.core.v.xj.f.xj(this.l, this.g, this);
        com.bytedance.sdk.openadsdk.core.v.xj.xj.xj(this.l, this.y.get());
        com.bytedance.sdk.openadsdk.core.v.xj.j.xj(this.l, this.g);
        com.bytedance.sdk.openadsdk.core.v.xj.u.xj(this.l, this);
        com.bytedance.sdk.openadsdk.core.v.xj.yo.xj(this.l, this, this.y.get(), this.g);
        return this;
    }

    public void hf(final Uri uri) {
        long j;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.component.utils.pl.hf("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.3
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.f(uri.toString());
                    }
                });
                return;
            }
            String queryParameter = uri.getQueryParameter(PointParamKey.CATEGORY);
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            if (c(queryParameter3)) {
                if (com.bytedance.sdk.openadsdk.core.ra.l.hf(this.g) && TextUtils.equals(queryParameter3, "track")) {
                    return;
                }
                long j2 = 0;
                try {
                    j = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception unused) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                JSONObject jSONObject = new JSONObject();
                String queryParameter4 = uri.getQueryParameter(BaseConstants.EVENT_LABEL_EXTRA);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused3) {
                    }
                }
                kd(queryParameter3, jSONObject);
                if ("click".equals(queryParameter3)) {
                    jSONObject = pz(jSONObject);
                    WeakReference<com.bytedance.sdk.openadsdk.core.jk.u> weakReference = this.ra;
                    if (weakReference != null && weakReference.get() != null) {
                        this.ra.get().hf();
                    }
                }
                com.bytedance.sdk.openadsdk.core.am.u.xj(queryParameter, xj(queryParameter2, queryParameter3), queryParameter3, j, j2, jSONObject);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.hf("TTAndroidObject", "handleUri exception: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            v(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void hf(String str, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.xj.e eVar = this.l;
            if (eVar != null) {
                eVar.xj(str, (String) jSONObject);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.w("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public void tf(boolean z) {
        this.wo = z;
    }

    public JSONObject xj() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d> weakReference = this.wn;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.wn.get().getContainerInfo();
    }

    public void xj(SSWebView.hf hfVar) {
        WeakReference<SSWebView> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null || hfVar == null) {
            return;
        }
        this.u.get().setOnShakeListener(hfVar);
    }

    public j xj(com.bytedance.sdk.openadsdk.core.ugeno.c.hf hfVar) {
        this.dc = new WeakReference<>(hfVar);
        return this;
    }

    public j xj(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d dVar) {
        this.wn = new WeakReference<>(dVar);
        return this;
    }

    public void xj(int i) {
        if (aq) {
            com.bytedance.sdk.component.utils.pl.hf("TTAndroidObject", "blocked Twist");
            return;
        }
        if (i != 1) {
            if (i == 2) {
                xj("twist_callback", (JSONObject) null);
            }
        } else {
            if (this.g != null && u()) {
                com.bytedance.sdk.openadsdk.core.pl.w.w.y.u = true;
            }
            xj("wobble_callback", (JSONObject) null);
        }
    }

    public j xj(com.bytedance.sdk.openadsdk.y.xj xjVar) {
        this.en = xjVar;
        return this;
    }

    public j xj(View view) {
        this.d = new WeakReference<>(view);
        return this;
    }

    public j xj(com.bytedance.sdk.openadsdk.core.jk.hf hfVar) {
        this.f10361io = new WeakReference<>(hfVar);
        return this;
    }

    public j xj(com.bytedance.sdk.openadsdk.core.jk.y yVar) {
        this.x = new WeakReference<>(yVar);
        return this;
    }

    public j xj(ws wsVar) {
        this.g = wsVar;
        return this;
    }

    public j xj(com.bytedance.sdk.component.adexpress.hf.p pVar) {
        this.yo = new SoftReference<>(pVar);
        return this;
    }

    public j xj(com.bytedance.sdk.openadsdk.core.nativeexpress.tf tfVar) {
        this.v.xj(tfVar);
        return this;
    }

    public j xj(com.bytedance.sdk.openadsdk.core.yo.u uVar) {
        this.pz = new WeakReference<>(uVar);
        return this;
    }

    public j xj(JSONObject jSONObject) {
        this.et = jSONObject;
        return this;
    }

    public j xj(Map<String, Object> map) {
        this.xj = map;
        return this;
    }

    public j xj(com.bytedance.sdk.openadsdk.core.jk.xj xjVar) {
        this.ht = new WeakReference<>(xjVar);
        return this;
    }

    public j xj(com.bytedance.sdk.openadsdk.core.jk.u uVar) {
        this.ra = new WeakReference<>(uVar);
        return this;
    }

    public j xj(com.bytedance.sdk.openadsdk.tf.xj xjVar) {
        this.dk = new WeakReference<>(xjVar);
        return this;
    }

    public void xj(c.xj xjVar) {
        this.n = xjVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.hf hfVar) {
        this.yy = hfVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x023b, code lost:
    
        if (r0 != null) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x023d, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0269, code lost:
    
        if (r0 != null) goto L156;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject xj(com.bytedance.sdk.openadsdk.core.j.xj r13, int r14) {
        /*
            Method dump skipped, instructions count: 930
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.j.xj(com.bytedance.sdk.openadsdk.core.j$xj, int):org.json.JSONObject");
    }

    public void xj(float f) {
        if (this.v.pl() == null) {
            return;
        }
        try {
            this.v.pl().xj(f);
        } catch (Exception unused) {
        }
    }

    public void xj(float f, float f2, float f3, float f4, int i) {
        this.v.xj(f, f2, f3, f4, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0052 A[Catch: Exception -> 0x00aa, TryCatch #0 {Exception -> 0x00aa, blocks: (B:6:0x000d, B:9:0x0027, B:11:0x002d, B:13:0x0033, B:16:0x003a, B:17:0x0044, B:19:0x0052, B:20:0x0070, B:22:0x008d, B:25:0x0095, B:27:0x009c, B:28:0x00a0, B:36:0x005f, B:37:0x0068, B:39:0x001f), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c A[Catch: Exception -> 0x00aa, TryCatch #0 {Exception -> 0x00aa, blocks: (B:6:0x000d, B:9:0x0027, B:11:0x002d, B:13:0x0033, B:16:0x003a, B:17:0x0044, B:19:0x0052, B:20:0x0070, B:22:0x008d, B:25:0x0095, B:27:0x009c, B:28:0x00a0, B:36:0x005f, B:37:0x0068, B:39:0x001f), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject xj(com.bytedance.sdk.openadsdk.core.ra.ws r9, java.util.concurrent.atomic.AtomicBoolean r10) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.bytedance.sdk.openadsdk.core.j.tf r1 = com.bytedance.sdk.openadsdk.core.pz.hf()
            if (r1 != 0) goto Ld
            goto Laa
        Ld:
            int r1 = com.bytedance.sdk.openadsdk.core.a.wo.d(r9)     // Catch: java.lang.Exception -> Laa
            int r2 = com.bytedance.sdk.openadsdk.core.a.wo.f(r9)     // Catch: java.lang.Exception -> Laa
            r3 = 1
            boolean r4 = com.bytedance.sdk.openadsdk.core.ra.j.hf(r3, r9, r3)     // Catch: java.lang.Exception -> Laa
            r5 = 0
            if (r4 == 0) goto L1f
            r4 = 0
            goto L27
        L1f:
            com.bytedance.sdk.openadsdk.core.j.tf r4 = com.bytedance.sdk.openadsdk.core.pz.hf()     // Catch: java.lang.Exception -> Laa
            int r4 = r4.kd(r1)     // Catch: java.lang.Exception -> Laa
        L27:
            boolean r6 = com.bytedance.sdk.openadsdk.core.ra.j.hf(r5, r9, r3)     // Catch: java.lang.Exception -> Laa
            if (r6 != 0) goto L43
            boolean r6 = com.bytedance.sdk.openadsdk.core.ra.x.xj(r9)     // Catch: java.lang.Exception -> Laa
            if (r6 == 0) goto L3a
            int r6 = com.bytedance.sdk.openadsdk.core.ra.x.hf(r9)     // Catch: java.lang.Exception -> Laa
            if (r6 <= 0) goto L3a
            goto L43
        L3a:
            com.bytedance.sdk.openadsdk.core.j.tf r6 = com.bytedance.sdk.openadsdk.core.pz.hf()     // Catch: java.lang.Exception -> Laa
            int r6 = r6.y(r1)     // Catch: java.lang.Exception -> Laa
            goto L44
        L43:
            r6 = 0
        L44:
            com.bytedance.sdk.openadsdk.core.j.tf r7 = com.bytedance.sdk.openadsdk.core.pz.hf()     // Catch: java.lang.Exception -> Laa
            java.lang.String r8 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> Laa
            boolean r7 = r7.kd(r8)     // Catch: java.lang.Exception -> Laa
            if (r10 == 0) goto L57
            boolean r10 = r10.get()     // Catch: java.lang.Exception -> Laa
            goto L70
        L57:
            r10 = 7
            if (r2 == r10) goto L68
            r10 = 8
            if (r2 != r10) goto L5f
            goto L68
        L5f:
            com.bytedance.sdk.openadsdk.core.j.tf r10 = com.bytedance.sdk.openadsdk.core.pz.hf()     // Catch: java.lang.Exception -> Laa
            boolean r10 = r10.u(r1)     // Catch: java.lang.Exception -> Laa
            goto L70
        L68:
            com.bytedance.sdk.openadsdk.core.j.tf r10 = com.bytedance.sdk.openadsdk.core.pz.hf()     // Catch: java.lang.Exception -> Laa
            boolean r10 = r10.xj(r9, r1)     // Catch: java.lang.Exception -> Laa
        L70:
            java.lang.String r1 = "ad_slot_type"
            r0.put(r1, r2)     // Catch: java.lang.Exception -> Laa
            java.lang.String r1 = "voice_control"
            r0.put(r1, r10)     // Catch: java.lang.Exception -> Laa
            java.lang.String r10 = "rv_skip_time"
            r0.put(r10, r4)     // Catch: java.lang.Exception -> Laa
            java.lang.String r10 = "fv_skip_show"
            r0.put(r10, r7)     // Catch: java.lang.Exception -> Laa
            java.lang.String r10 = "iv_skip_time"
            r0.put(r10, r6)     // Catch: java.lang.Exception -> Laa
            java.lang.String r10 = "show_dislike"
            if (r9 == 0) goto L94
            boolean r1 = r9.oz()     // Catch: java.lang.Exception -> Laa
            if (r1 == 0) goto L94
            goto L95
        L94:
            r3 = 0
        L95:
            r0.put(r10, r3)     // Catch: java.lang.Exception -> Laa
            java.lang.String r10 = "video_adaptation"
            if (r9 == 0) goto La0
            int r5 = r9.bl()     // Catch: java.lang.Exception -> Laa
        La0:
            r0.put(r10, r5)     // Catch: java.lang.Exception -> Laa
            java.lang.String r9 = "h5_cache_resources_enable"
            boolean r10 = com.bytedance.sdk.openadsdk.core.ra.ai.xj     // Catch: java.lang.Exception -> Laa
            r0.put(r9, r10)     // Catch: java.lang.Exception -> Laa
        Laa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.j.xj(com.bytedance.sdk.openadsdk.core.ra.ws, java.util.concurrent.atomic.AtomicBoolean):org.json.JSONObject");
    }

    private void xj(final xj xjVar, final JSONObject jSONObject) {
        if (xjVar == null) {
            return;
        }
        try {
            xj(xjVar.u, new com.bytedance.sdk.openadsdk.core.jk.w() { // from class: com.bytedance.sdk.openadsdk.core.j.11
                @Override // com.bytedance.sdk.openadsdk.core.jk.w
                public void xj(boolean z, List<ws> list, boolean z2) {
                    if (!z) {
                        j.this.w(xjVar.hf, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", j.xj(list));
                        j.this.w(xjVar.hf, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean xj(String str, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
        HashMap<String, d> hashMap;
        d dVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.q) == null || (dVar = hashMap.get(str)) == null) {
            return false;
        }
        dVar.xj(i, raVar);
        return true;
    }

    public void xj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.jk.w wVar) {
        com.bytedance.sdk.openadsdk.core.et.hf.xj(this.g, jSONObject, wVar, (com.bytedance.sdk.openadsdk.zg.w.w.hf) null);
    }

    public boolean xj(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("bytedance".equals(uri.getScheme())) {
            return w.containsKey(uri.getHost());
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void xj(ws wsVar, int i) {
        WeakReference<Context> weakReference = this.y;
        if (weakReference == null || wsVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.y.get();
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(context, wsVar, this.ff, this.p);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).hf(true);
        com.bytedance.sdk.component.p.kd.xj.xj().xj(wsVar.hashCode() + wsVar.zf()).put("live_saas_interaction_type", Integer.valueOf(i));
        final String ho = wsVar.ho();
        com.bytedance.sdk.openadsdk.core.pl.hf.u hf = com.bytedance.sdk.openadsdk.core.pl.f.hf(context, wsVar, this.ff, false);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj((com.bytedance.sdk.openadsdk.core.pl.hf.w) hf);
        xjVar.xj(null, new com.bytedance.sdk.openadsdk.core.ra.tf());
        if (hf != null) {
            hf.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.j.4
                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void hf(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void w(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj() {
                    xj.C0198xj.xj(ho, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(long j, String str, String str2) {
                    xj.C0198xj.xj(ho, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(String str, String str2) {
                    xj.C0198xj.xj(ho, 6, 100);
                }
            });
        }
        if (wn()) {
            WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d> weakReference2 = this.wn;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.wn.get().u();
            return;
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.f.hf) {
            ((com.bytedance.sdk.openadsdk.core.f.hf) context).xj(1);
        }
    }

    private String xj(String str, String str2) {
        return ((("landing_perf_stats".equals(str2) || "landing_perf_exception".equals(str2)) && "landingpage".equals(str)) || this.yo != null || wn()) ? str : wo.xj(this.p);
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof xj) {
                try {
                    xj((xj) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void xj(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.yo.w wVar = this.c;
        if (wVar != null) {
            wVar.xj(str, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.hf
    public void xj(String str, JSONObject jSONObject) {
        a();
        u(str, jSONObject);
    }

    public void xj(JSONObject jSONObject, boolean z) {
        WeakReference<Context> weakReference;
        if (this.c == null || (weakReference = this.y) == null || weakReference.get() == null) {
            return;
        }
        this.c.xj(this.e && this.zg);
        this.c.hf(z);
        this.c.xj(this.y.get(), jSONObject, this.ff, this.tf);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.jk.kd kdVar) {
        this.s = new WeakReference<>(kdVar);
    }

    public void xj(int i, int i2) {
        int w2 = r.w(pz.getContext(), i);
        int w3 = r.w(pz.getContext(), i2);
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d> weakReference = this.wn;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wn.get().xj(Integer.MIN_VALUE, Integer.MIN_VALUE, w2, w3);
    }

    public void xj(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = Integer.MIN_VALUE;
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            i5 = Integer.MIN_VALUE;
            i6 = Integer.MIN_VALUE;
        } else {
            i5 = r.w(pz.getContext(), i);
            i6 = r.w(pz.getContext(), i2);
        }
        if (i3 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) {
            i7 = Integer.MIN_VALUE;
        } else {
            i8 = r.w(pz.getContext(), i3);
            i7 = r.w(pz.getContext(), i4);
        }
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d> weakReference = this.wn;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wn.get().xj(i5, i6, i8, i7);
    }
}
