package com.sigmob.sdk.mraid2;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SensorEntity;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.AdSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.mraid2.i;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i extends com.sigmob.sdk.mraid2.a {
    private static final String b = "Mraid2WebView";
    private static final HashMap<String, i> r = new LinkedHashMap();
    private final i c;
    private d d;
    private i e;
    private final String f;
    private v g;
    private t h;
    private b i;
    private boolean j;
    private FrameLayout k;
    private LinearLayout l;
    private boolean m;
    private JSONObject n;
    private BaseAdUnit o;
    private final j p;
    private com.sigmob.sdk.base.common.g q;
    private final HashMap<String, q> s;
    private final d.b t;

    /* renamed from: com.sigmob.sdk.mraid2.i$1, reason: invalid class name */
    public class AnonymousClass1 extends j {
        public AnonymousClass1() {
        }

        private void a() {
            if (i.this.d != null) {
                if (i.this.n != null) {
                    i.this.d.a(i.this.n);
                }
                i.this.d.d();
            }
            if (i.this.c != null && i.this.c.getMraidBridge() != null && com.sigmob.sdk.base.utils.o.b(i.this.f)) {
                i.this.c.getMraidBridge().c(i.this.f);
            }
            if (i.this.j) {
                return;
            }
            i.this.j = true;
            if (i.this.i != null) {
                i.this.i.a(i.this.e);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            Objects.toString(i.this.n);
            if (i.this.d.b()) {
                a();
            } else {
                i.this.d.a(g.b, new ValueCallback() { // from class: com.sigmob.sdk.mraid2.ASJ6gh
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        i.AnonymousClass1.this.a(obj);
                    }
                });
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            d mraidBridge;
            ae.a("h5_error", "mraid2", i, CtFAbx.AlLFFp(str2, " error:", str), (WindAdRequest) null, (LoadAdRequest) null, i.this.getAdUnitList().get(0), (ae.a) null);
            if (i.this.c == null || com.sigmob.sdk.base.utils.o.a((CharSequence) i.this.f) || (mraidBridge = i.this.c.getMraidBridge()) == null) {
                return;
            }
            mraidBridge.a(i.this.f, i, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            ae.a("h5_error", "mraid2", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, i.this.getAdUnitList().get(0), (ae.a) null);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WindAdError windAdError;
            boolean didCrash;
            Objects.toString(renderProcessGoneDetail);
            if (Build.VERSION.SDK_INT < 26) {
                windAdError = null;
            } else {
                if (renderProcessGoneDetail != null) {
                    didCrash = renderProcessGoneDetail.didCrash();
                    if (didCrash) {
                        windAdError = WindAdError.RENDER_PROCESS_GONE_WITH_CRASH;
                    }
                }
                windAdError = WindAdError.RENDER_PROCESS_GONE_UNSPECIFIED;
            }
            SigmobLog.e("handleRenderProcessGone " + windAdError);
            if (com.sigmob.sdk.base.utils.q.b(i.this.i)) {
                i.this.i.a(windAdError);
            }
            i.this.a();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
                return false;
            }
            if (str.startsWith(Constants.HTTP) || str.startsWith("https")) {
                webView.loadUrl(str);
                return true;
            }
            try {
                if (i.this.o != null) {
                    i iVar = i.this;
                    iVar.a(str, iVar.o);
                    return true;
                }
                List<BaseAdUnit> adUnitList = i.this.getAdUnitList();
                if (com.sigmob.sdk.base.utils.e.a(adUnitList)) {
                    return true;
                }
                for (int i = 0; i < adUnitList.size(); i++) {
                    if (i.this.a(str, adUnitList.get(i))) {
                        return true;
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Object obj) {
            a();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            CharSequence description;
            d mraidBridge;
            int errorCode;
            CharSequence description2;
            SigmobLog.i("onReceivedError:" + webResourceError.toString());
            if (Build.VERSION.SDK_INT >= 23) {
                StringBuilder sb = new StringBuilder();
                sb.append(webResourceRequest.getUrl());
                sb.append(" error:");
                description = webResourceError.getDescription();
                sb.append((Object) description);
                ae.a("h5_error", "mraid2", 0, sb.toString(), (WindAdRequest) null, (LoadAdRequest) null, i.this.getAdUnitList().get(0), (ae.a) null);
                if (i.this.c == null || com.sigmob.sdk.base.utils.o.a((CharSequence) i.this.f) || (mraidBridge = i.this.c.getMraidBridge()) == null) {
                    return;
                }
                String str = i.this.f;
                errorCode = webResourceError.getErrorCode();
                StringBuilder sb2 = new StringBuilder("");
                description2 = webResourceError.getDescription();
                sb2.append((Object) description2);
                mraidBridge.a(str, errorCode, sb2.toString());
            }
        }
    }

    public class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            Activity c = com.sigmob.sdk.base.utils.r.c(i.this);
            if (c == null) {
                return;
            }
            com.sigmob.sdk.videoplayer.c.h((Context) c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Activity c = com.sigmob.sdk.base.utils.r.c(i.this);
            if (c == null) {
                return;
            }
            com.sigmob.sdk.videoplayer.c.j(c);
        }

        @JavascriptInterface
        public boolean canInstallByVid(String str, String str2) {
            BaseAdUnit baseAdUnit;
            List<BaseAdUnit> adUnitList = i.this.getAdUnitList();
            if (com.sigmob.sdk.base.utils.e.a(adUnitList)) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i >= adUnitList.size()) {
                    baseAdUnit = null;
                    break;
                }
                baseAdUnit = adUnitList.get(i);
                if (baseAdUnit.getAd().vid.equals(str)) {
                    break;
                }
                i++;
            }
            if (baseAdUnit == null) {
                return false;
            }
            if (!com.sigmob.sdk.base.utils.o.b(str2)) {
                str2 = baseAdUnit.getApkName();
                String apkMd5 = baseAdUnit.getApkMd5();
                if (!com.sigmob.sdk.base.utils.o.b(str2)) {
                    str2 = com.sigmob.sdk.base.utils.o.a((CharSequence) apkMd5) ? "" : CtFAbx.AcNBzu(apkMd5, ".apk");
                }
            }
            return baseAdUnit.canInstall(str2);
        }

        @JavascriptInterface
        public boolean canOpen(String str) {
            return com.sigmob.sdk.base.o.a().b(str).booleanValue();
        }

        @JavascriptInterface
        public boolean canOpenByVid(String str, String str2) {
            BaseAdUnit baseAdUnit;
            if (com.sigmob.sdk.base.utils.o.a((CharSequence) str2)) {
                List<BaseAdUnit> adUnitList = i.this.getAdUnitList();
                int i = 0;
                if (com.sigmob.sdk.base.utils.e.a(adUnitList)) {
                    return false;
                }
                while (true) {
                    if (i >= adUnitList.size()) {
                        baseAdUnit = null;
                        break;
                    }
                    baseAdUnit = adUnitList.get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                    i++;
                }
                if (baseAdUnit != null) {
                    return baseAdUnit.canOpen();
                }
            }
            return com.sigmob.sdk.base.o.a().b(str2).booleanValue();
        }

        @JavascriptInterface
        public void hideSystemUI() {
            ThreadPoolFactory.MainThreadRun(new AYUAbz(this, 0));
        }

        @JavascriptInterface
        public boolean isOpenListReport() {
            com.sigmob.sdk.base.o a2 = com.sigmob.sdk.base.o.a();
            return (a2.V().isEmpty() || com.sigmob.sdk.base.services.b.a() || !a2.N().booleanValue()) ? false : true;
        }

        @JavascriptInterface
        public void onOpenListReport() {
            com.sigmob.sdk.base.services.b.c();
        }

        @JavascriptInterface
        public void showSystemUI() {
            ThreadPoolFactory.MainThreadRun(new AYUAbz(this, 1));
        }

        public /* synthetic */ a(i iVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        QiNrwDr();
    }

    public i(Context context, List<BaseAdUnit> list, FrameLayout frameLayout) {
        this(context, list, frameLayout, null, null);
        a(new a(this, null), "sigandroidh5");
    }

    private static /* synthetic */ void QiNrwDr() {
        char[] charArray = "µ¹»ø±·»³ø´¹¯ø¥¾³ººø\u009c¸¿\u0094¤¿²±³".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 214);
        }
        String str = new String(charArray);
        char[] charArray2 = "µº¿¸¿¢".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 214);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        String str2;
        List<MaterialMeta> list;
        MaterialMeta materialMeta;
        Template template;
        for (int i = 0; i < getAdUnitList().size(); i++) {
            BaseAdUnit baseAdUnit = getAdUnitList().get(i);
            if (baseAdUnit != null) {
                Template template2 = baseAdUnit.scene;
                if (template2 == null || !str.equals(template2.templateId)) {
                    Ad ad = baseAdUnit.getAd();
                    if (ad != null && (list = ad.materials) != null && (materialMeta = list.get(0)) != null) {
                        Template template3 = materialMeta.main_template;
                        if (template3 == null || !str.equals(template3.templateId)) {
                            Template template4 = materialMeta.sub_template;
                            if (template4 != null && str.equals(template4.templateId)) {
                                template = materialMeta.sub_template;
                            }
                        } else {
                            template = materialMeta.main_template;
                        }
                    }
                } else {
                    template = baseAdUnit.scene;
                }
                str2 = template.context.utf8();
                break;
            }
        }
        str2 = null;
        if (com.sigmob.sdk.base.utils.o.b(str2)) {
            c(str2);
        }
    }

    public static HashMap<String, i> getMraidWebViews() {
        return r;
    }

    private Template getTemplate() {
        Template template;
        Template template2;
        List<BaseAdUnit> adUnitList = getAdUnitList();
        if (com.sigmob.sdk.base.utils.e.a(adUnitList)) {
            return null;
        }
        BaseAdUnit baseAdUnit = adUnitList.get(0);
        MaterialMeta material = baseAdUnit.getMaterial();
        Template template3 = baseAdUnit.scene;
        if (template3 != null) {
            return template3;
        }
        if (material != null && (template2 = material.main_template) != null) {
            return template2;
        }
        if (material == null || (template = material.sub_template) == null) {
            return null;
        }
        return template;
    }

    public com.sigmob.sdk.base.common.g getAdSize() {
        return this.q;
    }

    @Override // com.sigmob.sdk.mraid2.a
    public List<BaseAdUnit> getAdUnitList() {
        d dVar = this.d;
        if (dVar == null) {
            return null;
        }
        return dVar.c();
    }

    public d getMraidBridge() {
        return this.d;
    }

    public v getScrollTouchListener() {
        return this.g;
    }

    public String getUniqueId() {
        return this.f;
    }

    public void k() {
        Template template = getTemplate();
        if (template == null) {
            return;
        }
        String utf8 = template.context.utf8();
        int intValue = template.type.intValue();
        if (intValue == 1) {
            d(utf8);
            return;
        }
        if (intValue == 2) {
            c(utf8);
        } else {
            if (intValue == 3) {
                e(utf8);
                return;
            }
            SigmobLog.e("template type error:" + template.type);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        dVar.a(i == 0);
    }

    public void setAdSize(com.sigmob.sdk.base.common.g gVar) {
        this.q = gVar;
    }

    public void setLoadListener(b bVar) {
        this.i = bVar;
    }

    public void setNextWebViewListener(t tVar) {
        this.h = tVar;
    }

    public void setScrollTouchListener(v vVar) {
        this.g = vVar;
    }

    public i(Context context, List<BaseAdUnit> list, FrameLayout frameLayout, i iVar, JSONObject jSONObject) {
        super(context);
        this.m = false;
        this.p = new AnonymousClass1();
        this.s = new LinkedHashMap();
        this.t = new d.b() { // from class: com.sigmob.sdk.mraid2.i.3
            @Override // com.sigmob.sdk.mraid2.d.b
            public void a() {
                if (i.this.h == null) {
                    return;
                }
                i.this.h.a(i.this.e);
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void b() {
                for (com.sigmob.sdk.mraid.n nVar : com.sigmob.sdk.mraid2.a.f13535a.values()) {
                    if (com.sigmob.sdk.base.utils.o.a((CharSequence) nVar.c(), (CharSequence) i.this.f)) {
                        com.sigmob.sdk.base.utils.r.a(nVar.a());
                        nVar.b();
                    }
                }
                com.sigmob.sdk.base.utils.r.a(i.this.e);
                if (com.sigmob.sdk.base.utils.e.b(i.this.s)) {
                    Iterator it = i.this.s.values().iterator();
                    while (it.hasNext()) {
                        ((q) it.next()).c();
                    }
                    i.this.s.clear();
                }
                if (i.this.e != null) {
                    i.this.e = null;
                }
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void c() {
                if (i.this.h == null) {
                    return;
                }
                i.this.h.b(i.this.e);
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void d() {
                if (i.this.h == null) {
                    return;
                }
                i.this.h.a();
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void e(JSONObject jSONObject2) {
                if (i.this.h == null) {
                    return;
                }
                i.this.h.b(i.this.e, jSONObject2);
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void f(JSONObject jSONObject2) {
                h hVar;
                SigmobLog.d("onMotionEvent: json = " + jSONObject2);
                JSONObject optJSONObject = jSONObject2.optJSONObject("args");
                String optString = optJSONObject == null ? null : optJSONObject.optString("uniqueId");
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) optString)) {
                    SigmobLog.e("onMotionViewEvent: uniqueId is null.");
                }
                com.sigmob.sdk.mraid.n nVar = com.sigmob.sdk.mraid2.a.f13535a.get(optString);
                hVar = nVar instanceof h ? (h) nVar : null;
                String optString2 = jSONObject2.optString("subEvent");
                optString2.getClass();
                switch (optString2) {
                    case "init_sensitivity_raw":
                        String optString3 = optJSONObject.optString(PointParamKey.TYPE, "");
                        int optInt = optJSONObject.optInt(com.sigmob.sdk.mraid.g.c, 0);
                        h hVar2 = new h(optString, optString3);
                        hVar2.a(new k() { // from class: com.sigmob.sdk.mraid2.i.3.4
                            @Override // com.sigmob.sdk.mraid2.k
                            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.a(str, str2, str3, hashMap);
                            }
                        });
                        hVar2.b(optInt);
                        hVar2.d();
                        com.sigmob.sdk.mraid2.a.f13535a.put(optString, hVar2);
                        break;
                    case "init":
                        String optString4 = optJSONObject.optString(PointParamKey.TYPE, "");
                        int optInt2 = optJSONObject.optInt(com.sigmob.sdk.mraid.g.b, 0);
                        int optInt3 = optJSONObject.optInt(com.sigmob.sdk.mraid.g.e, 0);
                        int optInt4 = optJSONObject.optInt(com.sigmob.sdk.mraid.g.f, 0);
                        int optInt5 = optJSONObject.optInt(com.sigmob.sdk.mraid.g.g, 0);
                        SigmobLog.d("onMotionEvent: type = " + optString4 + ", level = " + optInt2);
                        h hVar3 = new h(optString, optString4);
                        hVar3.a(new k() { // from class: com.sigmob.sdk.mraid2.i.3.3
                            @Override // com.sigmob.sdk.mraid2.k
                            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.a(str, str2, str3, hashMap);
                            }
                        });
                        hVar3.a(new SensorEntity(optInt2, optInt3, optInt4, optInt5));
                        hVar3.d();
                        com.sigmob.sdk.mraid2.a.f13535a.put(optString, hVar3);
                        break;
                    case "destroy":
                        if (hVar != null) {
                            hVar.b();
                        }
                        com.sigmob.sdk.mraid2.a.f13535a.remove(optString);
                        break;
                }
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void g(JSONObject jSONObject2) {
                com.sigmob.sdk.mraid.l lVar;
                String optString;
                SigmobLog.d("onMotionViewEvent: json = " + jSONObject2);
                JSONObject optJSONObject = jSONObject2.optJSONObject("args");
                String optString2 = optJSONObject == null ? null : optJSONObject.optString("uniqueId");
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) optString2)) {
                    SigmobLog.e("onMotionViewEvent: uniqueId is null.");
                }
                com.sigmob.sdk.mraid.n nVar = com.sigmob.sdk.mraid2.a.f13535a.get(optString2);
                lVar = nVar instanceof com.sigmob.sdk.mraid.l ? (com.sigmob.sdk.mraid.l) nVar : null;
                optString = jSONObject2.optString("subEvent");
                optString.getClass();
                switch (optString) {
                    case "shakeTimeThreshold":
                        if (lVar != null) {
                            lVar.e(optJSONObject.optInt(optString));
                            break;
                        }
                        break;
                    case "widgetIntervalTime":
                        if (lVar != null) {
                            lVar.d(optJSONObject.optInt(optString));
                            break;
                        }
                        break;
                    case "hidden":
                        if (lVar != null) {
                            lVar.a(optJSONObject.optBoolean("hidden"));
                            break;
                        }
                        break;
                    case "init":
                        com.sigmob.sdk.mraid.l lVar2 = new com.sigmob.sdk.mraid.l(com.sigmob.sdk.b.e(), optString2, optJSONObject.optInt(PointParamKey.TYPE), i.this.o);
                        lVar2.a(new k() { // from class: com.sigmob.sdk.mraid2.i.3.5
                            @Override // com.sigmob.sdk.mraid2.k
                            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.a(str, str2, str3, hashMap);
                            }
                        });
                        com.sigmob.sdk.mraid2.a.f13535a.put(optString2, lVar2);
                        break;
                    case "frame":
                        if (lVar != null) {
                            lVar.a(optJSONObject);
                            break;
                        }
                        break;
                    case "start":
                        if (lVar != null) {
                            lVar.d();
                            break;
                        }
                        break;
                    case "sensitivity":
                        if (lVar != null) {
                            lVar.a(optJSONObject.optInt(optString));
                            break;
                        }
                        break;
                    case "destroy":
                        if (lVar != null) {
                            lVar.b();
                        }
                        com.sigmob.sdk.mraid2.a.f13535a.remove(optString2);
                        break;
                    case "sensitivity_raw":
                        if (lVar != null) {
                            lVar.b(optJSONObject.optInt(optString));
                            break;
                        }
                        break;
                    case "shakeTriggerType":
                        if (lVar != null) {
                            lVar.c(optJSONObject.optInt(optString));
                            break;
                        }
                        break;
                }
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void a(BaseAdUnit baseAdUnit, JSONObject jSONObject2) {
                if (i.this.h == null) {
                    return;
                }
                i.this.h.a(i.this.e, baseAdUnit, jSONObject2);
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void b(String str, JSONObject jSONObject2) {
                q qVar;
                SigmobLog.d(" onTimerEvent :" + str + ":" + jSONObject2);
                String optString = jSONObject2.optString("uniqueId");
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) optString)) {
                    return;
                }
                qVar = (q) i.this.s.get(optString);
                str.getClass();
                switch (str) {
                    case "invalidate":
                        if (qVar != null) {
                            qVar.c();
                        }
                        i.this.s.remove(optString);
                        break;
                    case "fire":
                        if (qVar != null) {
                            qVar.b();
                            break;
                        }
                        break;
                    case "init":
                        i.this.s.put(optString, new q(i.this.d, jSONObject2));
                        break;
                    case "pause":
                        if (qVar != null) {
                            qVar.a();
                            break;
                        }
                        break;
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.sigmob.sdk.mraid2.d.b
            public void c(String str, JSONObject jSONObject2) {
                char c;
                JSONObject optJSONObject;
                SigmobLog.d(" onWebViewEvent :" + str + ":" + jSONObject2);
                String optString = jSONObject2.optString("uniqueId");
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) optString)) {
                    return;
                }
                i iVar2 = (i) i.r.get(optString);
                str.getClass();
                switch (str.hashCode()) {
                    case -1435435774:
                        if (str.equals("loadHTMLString")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1097519967:
                        if (str.equals(Constants.LOAD_ID)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -948122918:
                        if (str.equals("stopLoading")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -934641255:
                        if (str.equals("reload")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3237136:
                        if (str.equals("init")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 97692013:
                        if (str.equals("frame")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 336630441:
                        if (str.equals("loadURL")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 723516230:
                        if (str.equals("loadURLByPackage")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        String optString2 = jSONObject2.optString(com.baidu.mobads.sdk.internal.a.f);
                        if (iVar2 != null && com.sigmob.sdk.base.utils.o.b(optString2)) {
                            iVar2.c(optString2);
                            break;
                        }
                        break;
                    case 1:
                        String optString3 = jSONObject2.optString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
                        if (iVar2 != null && com.sigmob.sdk.base.utils.o.b(optString3)) {
                            iVar2.f(optString3);
                            break;
                        }
                        break;
                    case 2:
                        if (iVar2 != null) {
                            iVar2.i();
                            break;
                        }
                        break;
                    case 3:
                        if (iVar2 != null) {
                            iVar2.h();
                            break;
                        }
                        break;
                    case 4:
                        if (i.this.h != null) {
                            i.r.put(optString, i.this.h.a(i.this.e, jSONObject2));
                            break;
                        }
                        break;
                    case 5:
                        if (iVar2 != null && (optJSONObject = jSONObject2.optJSONObject("frame")) != null) {
                            int optInt = optJSONObject.optInt("x", 0);
                            int optInt2 = optJSONObject.optInt("y", 0);
                            int optInt3 = optJSONObject.optInt(IAdInterListener.AdReqParam.WIDTH, -1);
                            int optInt4 = optJSONObject.optInt("h", -1);
                            if (optInt3 > 0) {
                                optInt3 = Dips.dipsToIntPixels(optInt3, com.sigmob.sdk.b.e());
                            }
                            if (optInt4 > 0) {
                                optInt4 = Dips.dipsToIntPixels(optInt4, com.sigmob.sdk.b.e());
                            }
                            iVar2.setLayoutParams(new FrameLayout.LayoutParams(optInt3, optInt4));
                            iVar2.setX(Dips.dipsToIntPixels(optInt, com.sigmob.sdk.b.e()));
                            iVar2.setY(Dips.dipsToIntPixels(optInt2, com.sigmob.sdk.b.e()));
                            iVar2.requestLayout();
                            break;
                        }
                        break;
                    case 6:
                        String optString4 = jSONObject2.optString("url");
                        if (iVar2 != null) {
                            iVar2.d(optString4);
                            break;
                        }
                        break;
                    case 7:
                        String optString5 = jSONObject2.optString("URL");
                        if (iVar2 != null && com.sigmob.sdk.base.utils.o.b(optString5)) {
                            iVar2.e(optString5);
                            break;
                        }
                        break;
                }
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void d(JSONObject jSONObject2) {
                i.this.m = true;
                int optInt = jSONObject2.optInt("flag");
                if (i.this.h != null && i.this.l == null) {
                    i iVar2 = i.this;
                    iVar2.l = iVar2.h.a(i.this.e, optInt);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < i.this.k.getChildCount(); i++) {
                        View childAt = i.this.k.getChildAt(i);
                        if (childAt instanceof com.sigmob.sdk.mraid.r) {
                            arrayList.add((com.sigmob.sdk.mraid.r) childAt);
                        }
                    }
                    arrayList.size();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        com.sigmob.sdk.mraid.r rVar = (com.sigmob.sdk.mraid.r) arrayList.get(i2);
                        rVar.setX(0.0f);
                        rVar.setY(0.0f);
                        com.sigmob.sdk.base.utils.r.a(rVar);
                        i.this.l.addView(rVar);
                    }
                }
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void a(String str) {
                List<BaseAdUnit> adUnitList = i.this.getAdUnitList();
                if (com.sigmob.sdk.base.utils.o.b(str) && com.sigmob.sdk.base.utils.e.a(adUnitList)) {
                    for (int i = 0; i < adUnitList.size(); i++) {
                        i.this.o = adUnitList.get(i);
                        if (str.equals(i.this.o.getVid())) {
                            break;
                        }
                    }
                }
                if (i.this.o == null) {
                    return;
                }
                com.sigmob.sdk.base.common.h.g().j(i.this.o.getCamp_id());
                com.sigmob.sdk.base.common.h.g().i(i.this.o.getCrid());
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void b(JSONObject jSONObject2) {
                ViewGroup viewGroup;
                String optString = jSONObject2.optString("uniqueId");
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) optString)) {
                    return;
                }
                com.sigmob.sdk.mraid.n nVar = com.sigmob.sdk.mraid2.a.f13535a.get(optString);
                if (nVar != null) {
                    nVar.a(i.this.f);
                    View a2 = nVar.a();
                    if (a2 != null) {
                        com.sigmob.sdk.base.utils.r.a(a2);
                        if (!i.this.m || i.this.l == null) {
                            viewGroup = i.this.k;
                        } else {
                            a2.setX(0.0f);
                            a2.setY(0.0f);
                            viewGroup = i.this.l;
                        }
                        viewGroup.addView(a2);
                    }
                }
                i iVar2 = (i) i.r.get(optString);
                if (iVar2 == null) {
                    return;
                }
                com.sigmob.sdk.base.utils.r.a(iVar2);
                i.this.k.addView(iVar2);
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void c(JSONObject jSONObject2) {
                String optString = jSONObject2.optString("uniqueId");
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) optString)) {
                    return;
                }
                com.sigmob.sdk.mraid.n nVar = com.sigmob.sdk.mraid2.a.f13535a.get(optString);
                if (nVar != null) {
                    nVar.a(i.this.f);
                    View a2 = nVar.a();
                    if (a2 != null) {
                        com.sigmob.sdk.base.utils.r.a(a2);
                        if (!i.this.m || i.this.l == null) {
                            i.this.k.addView(a2);
                            i.this.k.bringChildToFront(i.this.e);
                        } else {
                            a2.setX(0.0f);
                            a2.setY(0.0f);
                            i.this.l.addView(a2);
                        }
                    }
                }
                i iVar2 = (i) i.r.get(optString);
                if (iVar2 == null) {
                    return;
                }
                com.sigmob.sdk.base.utils.r.a(iVar2);
                i.this.k.addView(iVar2);
                i.this.k.bringChildToFront(i.this.e);
            }

            @Override // com.sigmob.sdk.mraid2.d.b
            public void a(String str, JSONObject jSONObject2) {
                com.sigmob.sdk.mraid.t tVar;
                SigmobLog.d("onVpaidEvent: subEvent = " + str + ", args = " + jSONObject2);
                String optString = jSONObject2.optString("uniqueId");
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) optString)) {
                    return;
                }
                com.sigmob.sdk.mraid.n nVar = com.sigmob.sdk.mraid2.a.f13535a.get(optString);
                tVar = nVar instanceof com.sigmob.sdk.mraid.t ? (com.sigmob.sdk.mraid.t) nVar : null;
                str.getClass();
                switch (str) {
                    case "replay":
                        if (tVar != null) {
                            tVar.c(jSONObject2);
                            break;
                        }
                        break;
                    case "assetURL":
                        if (tVar != null) {
                            tVar.a(jSONObject2);
                            break;
                        }
                        break;
                    case "init":
                        com.sigmob.sdk.mraid.t tVar2 = new com.sigmob.sdk.mraid.t(optString);
                        tVar2.a(new com.sigmob.sdk.mraid.u() { // from class: com.sigmob.sdk.mraid2.i.3.1
                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, int i) {
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.a(str2, i);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void b(String str2, int i) {
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.b(str2, i);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, int i, String str3) {
                                ae.a("video", i, str3, i.this.o);
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.a(str2, "code:" + i + ", msg:" + str3);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, long j) {
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.c(str2, (int) j);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, long j, int i, int i2) {
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.a(str2, (int) j, i, i2);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, long j, long j2) {
                                if (i.this.d == null) {
                                    return;
                                }
                                i.this.d.a(str2, (int) j, (int) j2);
                            }
                        });
                        tVar2.a(i.this.getContext(), jSONObject2);
                        View a2 = tVar2.a();
                        if (a2 != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
                            layoutParams.topMargin = 0;
                            layoutParams.rightMargin = 0;
                            a2.setLayoutParams(layoutParams);
                        }
                        com.sigmob.sdk.mraid2.a.f13535a.put(optString, tVar2);
                        break;
                    case "play":
                        if (tVar != null) {
                            tVar.b(jSONObject2);
                            break;
                        }
                        break;
                    case "seek":
                        if (tVar != null) {
                            tVar.g(jSONObject2);
                            break;
                        }
                        break;
                    case "stop":
                        if (tVar != null) {
                            tVar.e(jSONObject2);
                            tVar.b();
                            com.sigmob.sdk.mraid2.a.f13535a.remove(tVar);
                            break;
                        }
                        break;
                    case "frame":
                        if (tVar != null) {
                            tVar.h(jSONObject2);
                            break;
                        }
                        break;
                    case "muted":
                        if (tVar != null) {
                            tVar.f(jSONObject2);
                            break;
                        }
                        break;
                    case "pause":
                        if (tVar != null) {
                            tVar.d(jSONObject2);
                            break;
                        }
                        break;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x016c  */
            /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
            @Override // com.sigmob.sdk.mraid2.d.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(org.json.JSONObject r29) {
                /*
                    Method dump skipped, instructions count: 451
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.i.AnonymousClass3.a(org.json.JSONObject):void");
            }
        };
        this.e = this;
        this.k = frameLayout;
        this.c = iVar;
        this.j = false;
        if (jSONObject == null) {
            String str = "wv_" + UUID.randomUUID().toString();
            this.f = str;
            r.put(str, this);
        } else {
            try {
                this.n = new JSONObject(jSONObject.optString("args"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f = jSONObject.optString("uniqueId");
        }
        a(true);
        setBackgroundColor(0);
        com.sigmob.sdk.base.utils.h.a(b, getSettings());
        this.p.a(com.sigmob.sdk.base.o.a().ag());
        BaseAdUnit baseAdUnit = list.get(0);
        if (com.sigmob.sdk.base.utils.q.b(baseAdUnit)) {
            this.p.b(baseAdUnit.isDisablexRequestWith());
        }
        setWebViewClient(this.p);
        d dVar = new d(list);
        this.d = dVar;
        dVar.a(this.t);
        this.d.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            return;
        }
        a(new d.a(this.d), "sigandroid");
        String md5 = Md5Util.md5(str);
        File f = com.sigmob.sdk.base.utils.k.f(com.sigmob.sdk.base.utils.k.c);
        if (f == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f.getAbsolutePath());
        final File file = new File(CtFAbx.B25kr6(sb, File.separator, md5), "endcard.html");
        file.exists();
        file.getAbsolutePath();
        if (file.exists()) {
            a("file://" + file.getAbsolutePath());
        } else {
            File file2 = new File(f, CtFAbx.AcNBzu(md5, ".tgz"));
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = str;
            downloadItem.filePath = file2.getAbsolutePath();
            downloadItem.type = DownloadItem.FileType.FILE;
            com.sigmob.sdk.base.common.s.a().add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.mraid2.i.2
                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void downloadProgress(DownloadItem downloadItem2, long j, long j2) {
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onCancel(DownloadItem downloadItem2) {
                    String str2 = downloadItem2.url;
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onErrorResponse(DownloadItem downloadItem2) {
                    String str2 = downloadItem2.url;
                }

                @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
                public void onSuccess(DownloadItem downloadItem2) {
                    String str2 = downloadItem2.url;
                    try {
                        com.sigmob.sdk.base.utils.f.a(new File(downloadItem2.filePath), new File(downloadItem2.filePath.replace(".tgz", "/")));
                        if (file.exists()) {
                            i.this.e.a("file://" + file.getAbsolutePath());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void c(String str) {
        a(new d.a(this.d), "sigandroid");
        File b2 = com.sigmob.sdk.base.utils.k.b(str, Md5Util.md5(str) + ".html");
        if (com.sigmob.sdk.base.utils.q.b(b2) && com.sigmob.sdk.base.utils.o.b(b2.getAbsolutePath())) {
            a("file://" + b2.getAbsolutePath());
        } else {
            a(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "UTF-8", null);
        }
    }

    public void d(String str) {
        a(new d.a(this.d), "sigandroid");
        a(str);
    }

    @Override // com.sigmob.sdk.mraid2.a
    public void a() {
        try {
            setLoadListener(null);
            setNextWebViewListener(null);
            setScrollTouchListener(null);
            if (this.e != null) {
                this.e = null;
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.g();
                this.d = null;
            }
            super.a();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, BaseAdUnit baseAdUnit) {
        if (!com.sigmob.sdk.base.utils.o.a((CharSequence) str) && baseAdUnit != null) {
            AdSetting adSetting = baseAdUnit.getAdSetting();
            List<String> list = adSetting == null ? null : adSetting.scheme_white_list;
            if (com.sigmob.sdk.base.utils.e.a(list)) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                String str2 = list.get(i);
                if (str.startsWith(str2) || str2.equals("*")) {
                    com.sigmob.sdk.base.common.v.a(getContext(), Uri.parse(str));
                    return true;
                }
            }
        }
        return false;
    }
}
