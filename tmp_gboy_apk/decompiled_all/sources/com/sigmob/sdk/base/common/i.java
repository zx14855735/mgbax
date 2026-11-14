package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.network.JsonRequest;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ao;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.views.q;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13137a = "i";
    protected Map<String, String> b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected String h;
    protected String i;
    public boolean k;
    private boolean m;
    private boolean n;
    private String o;
    private boolean p;
    private ac q;
    private com.sigmob.sdk.base.views.q r;
    private WeakReference<Activity> s;
    private q.b t;
    private WeakReference<BaseAdUnit> u;
    private boolean v;
    private int w;
    protected int j = 1;
    private final List<com.sigmob.sdk.videoAd.d> l = new ArrayList();

    /* renamed from: com.sigmob.sdk.base.common.i$2, reason: invalid class name */
    public class AnonymousClass2 implements JsonRequest.Listener {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(i.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(i.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(i.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(i.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(i.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(i.this.o);
            }
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ae.a("download_start", Constants.FAIL, i.this.l(), new AZkASS(this, 0));
            ae.a("download_start", 0, volleyError.getMessage(), i.this.l(), new AZkASS(this, 1));
            SigmobLog.e(i.f13137a + "handleFourDownload#onErrorResponse: error = " + volleyError.getMessage());
        }

        @Override // com.czhj.sdk.common.network.JsonRequest.Listener
        public void onSuccess(JSONObject jSONObject) {
            try {
                SigmobLog.d(i.f13137a + "handleFourDownload#onSuccess: response = " + jSONObject);
                if (jSONObject.getInt("ret") != 0) {
                    ae.a("download_start", Constants.FAIL, i.this.l(), new AZkASS(this, 2));
                    ae.a("download_start", 0, jSONObject.toString(), i.this.l(), new AZkASS(this, 3));
                    return;
                }
                String string = jSONObject.getJSONObject(PointParamKey.DATA).getString("dstlink");
                i.this.l().getMacroCommon().addMarcoKey(SigMacroCommon._CLICKID_, jSONObject.getJSONObject(PointParamKey.DATA).getString("clickid"));
                i.this.o = string;
                q.a(string, i.this.l());
            } catch (Throwable th) {
                SigmobLog.e(i.f13137a + "handleFourDownload#onSuccess: error = " + th.getMessage());
                ae.a("download_start", Constants.FAIL, i.this.l(), new AZkASS(this, 4));
                ae.a("download_start", 0, th.getMessage(), i.this.l(), new AZkASS(this, 5));
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.i$3, reason: invalid class name */
    public class AnonymousClass3 implements JsonRequest.Listener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseAdUnit f13140a;
        final /* synthetic */ String b;

        public AnonymousClass3(BaseAdUnit baseAdUnit, String str) {
            this.f13140a = baseAdUnit;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str, Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(String str, Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(str);
            }
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ae.a("download_start", Constants.FAIL, this.f13140a, new AaHO0E(this.b, 4));
            ae.a("download_start", 0, volleyError.getMessage(), this.f13140a, new AaHO0E(this.b, 5));
            SigmobLog.e(i.f13137a + "handleMRAID2Download#onErrorResponse: error = " + volleyError.getMessage());
        }

        @Override // com.czhj.sdk.common.network.JsonRequest.Listener
        public void onSuccess(JSONObject jSONObject) {
            try {
                SigmobLog.d(i.f13137a + "handleMRAID2Download#onSuccess: response = " + jSONObject);
                if (jSONObject.getInt("ret") != 0) {
                    ae.a("download_start", Constants.FAIL, this.f13140a, new AaHO0E(this.b, 0));
                    ae.a("download_start", 0, jSONObject.toString(), this.f13140a, new AaHO0E(this.b, 1));
                } else {
                    String string = jSONObject.getJSONObject(PointParamKey.DATA).getString("dstlink");
                    this.f13140a.getMacroCommon().addMarcoKey(SigMacroCommon._CLICKID_, jSONObject.getJSONObject(PointParamKey.DATA).getString("clickid"));
                    q.a(string, this.f13140a);
                }
            } catch (Throwable th) {
                SigmobLog.e(i.f13137a + "handleMRAID2Download#onSuccess: error = " + th.getMessage());
                ae.a("download_start", Constants.FAIL, this.f13140a, new AaHO0E(this.b, 2));
                ae.a("download_start", 0, th.getMessage(), this.f13140a, new AaHO0E(this.b, 3));
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.i$4, reason: invalid class name */
    public class AnonymousClass4 implements ao.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseAdUnit f13141a;
        final /* synthetic */ boolean b;
        final /* synthetic */ AndroidMarket c;
        final /* synthetic */ boolean d;
        final /* synthetic */ com.sigmob.sdk.base.a e;

        public AnonymousClass4(BaseAdUnit baseAdUnit, boolean z, AndroidMarket androidMarket, boolean z2, com.sigmob.sdk.base.a aVar) {
            this.f13141a = baseAdUnit;
            this.b = z;
            this.c = androidMarket;
            this.d = z2;
            this.e = aVar;
        }

        @Override // com.sigmob.sdk.base.common.ao.b
        public void a(String str, an anVar) {
            SigmobLog.d(i.f13137a + "urlHandlingSucceeded: action = " + anVar.name() + ", url = " + str);
            this.f13141a.getClickCommon().is_final_click = true;
            if (!this.f13141a.getAd().forbiden_parse_landingpage.booleanValue()) {
                ae.a(this.f13141a, anVar.name(), str);
            }
            this.f13141a.getClickCommon().isDeeplink = Constants.FAIL;
            int i = AnonymousClass5.b[anVar.ordinal()];
            if (i == 3) {
                if (this.b) {
                    com.sigmob.sdk.manager.b.b(this.f13141a, a.G, str);
                }
                this.f13141a.getClickCommon().isDeeplink = "1";
            } else if (i != 5) {
                if (i == 6) {
                    if (this.d && i.this.j()) {
                        this.f13141a.getClickCommon().is_final_click = false;
                    } else {
                        i.this.f(str);
                    }
                }
            } else if (this.b) {
                AndroidMarket androidMarket = this.c;
                if (androidMarket != null) {
                    ae.a(PointCategory.APK_CLICK, ((Integer) Wire.get(androidMarket.type, 0)).intValue() == 0 ? BaseConstants.SCHEME_MARKET : "mimarket", this.f13141a);
                    if (!com.sigmob.sdk.base.utils.o.a((CharSequence) this.c.app_package_name)) {
                        try {
                            FileUtil.writeToCache(this.f13141a, new File(com.sigmob.sdk.base.utils.k.g(), this.c.app_package_name + ".log").getAbsolutePath());
                        } catch (Throwable th) {
                            SigmobLog.e(i.f13137a + "urlHandlingSucceeded: error = " + th.getMessage());
                        }
                    }
                }
                ae.a(PointCategory.OPEN_MARKET, (String) null, this.f13141a, new AcNBzu(str, this.c, 0));
            }
            this.f13141a.setCustomDeeplink(null);
            this.f13141a.setCustomAndroidMarket(null);
            this.f13141a.setCustomLandPageUrl(null);
            if (i.this.q != null) {
                i.this.q.onAdClick(this.b, this.e);
            }
        }

        @Override // com.sigmob.sdk.base.common.ao.b
        public void b(String str, an anVar) {
            SigmobLog.d(i.f13137a + "urlHandlingFailed: action = " + anVar.name() + ", url = " + str);
            this.f13141a.getClickCommon().isDeeplink = Constants.FAIL;
            int i = AnonymousClass5.b[anVar.ordinal()];
            if (i == 3 || i == 4) {
                if (this.b) {
                    com.sigmob.sdk.manager.b.b(this.f13141a, a.H, str);
                    return;
                }
                return;
            }
            if (i == 5) {
                if (this.b) {
                    ae.a(PointCategory.OPEN_MARKET_FAILED, str, this.f13141a, new AcNBzu(str, this.c, 1));
                }
            } else {
                if (i != 8) {
                    return;
                }
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) && !this.f13141a.getAd().forbiden_parse_landingpage.booleanValue()) {
                    ae.a(this.f13141a, anVar.name(), str);
                }
                this.f13141a.setCustomDeeplink(null);
                this.f13141a.setCustomAndroidMarket(null);
                this.f13141a.setCustomLandPageUrl(null);
                if (i.this.q != null) {
                    i.this.q.onAdClick(this.b, this.e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, AndroidMarket androidMarket, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                Map<String, String> options = pointEntitySigmob.getOptions();
                options.put("app_package_name", androidMarket.app_package_name);
                options.put("store_package_name", androidMarket.appstore_package_name);
                pointEntitySigmob.setOptions(options);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, AndroidMarket androidMarket, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                if (androidMarket == null) {
                    return;
                }
                Map<String, String> options = pointEntitySigmob.getOptions();
                options.put("app_package_name", androidMarket.app_package_name);
                options.put("store_package_name", androidMarket.appstore_package_name);
                pointEntitySigmob.setOptions(options);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.i$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13142a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[an.values().length];
            b = iArr;
            try {
                iArr[an.FOLLOW_PACKAGE_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[an.IGNORE_ABOUT_SCHEME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[an.MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[an.FOLLOW_DEEP_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[an.MARKET_SCHEME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[an.DOWNLOAD_APK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[an.OPEN_WITH_BROWSER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[an.NOOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[com.sigmob.sdk.base.a.values().length];
            f13142a = iArr2;
            try {
                iArr2[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13142a[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static i a(BaseAdUnit baseAdUnit) {
        i iVar = new i();
        iVar.b(baseAdUnit);
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseAdUnit l() {
        WeakReference<BaseAdUnit> weakReference = this.u;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.sigmob.sdk.base.views.q qVar = this.r;
        if (qVar == null) {
            return;
        }
        qVar.dismiss();
        this.r.c();
        this.r = null;
        this.m = false;
    }

    public String c() {
        return this.c;
    }

    public String e() {
        return this.g;
    }

    public Map<String, String> g() {
        return this.b;
    }

    public boolean h() {
        return this.n;
    }

    public boolean i() {
        final BaseAdUnit l = l();
        if (l == null) {
            return false;
        }
        SigmobLog.i(f13137a + Constants.SHOW_DOWNLOAD_DIALOG);
        WeakReference<Activity> weakReference = this.s;
        Activity activity = weakReference == null ? null : weakReference.get();
        if (activity != null && l.getadPrivacy() != null && this.r == null) {
            com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(activity, l);
            this.r = qVar;
            qVar.a(new q.b() { // from class: com.sigmob.sdk.base.common.i.1
                @Override // com.sigmob.sdk.base.views.q.b
                public void a() {
                    SigmobLog.i(i.f13137a + "onCloseClick");
                    i.this.m();
                    ah sessionManager = l.getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a(a.g, 0);
                    }
                    if (i.this.t != null) {
                        i.this.t.a();
                    }
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void b() {
                    SigmobLog.i(i.f13137a + "onShowSuccess");
                    ah sessionManager = l.getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a(a.f, 0);
                    }
                    if (i.this.t == null || !i.this.m) {
                        return;
                    }
                    i.this.t.b();
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(Error error) {
                    SigmobLog.e(i.f13137a + "onShowFail: error = " + error);
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(String str, String str2) {
                    SigmobLog.i(i.f13137a + "onButtonClick");
                    if (i.this.t != null) {
                        i.this.t.a(str, str2);
                    }
                    i.this.a(l.getClickCommon().clickUIType, str, str2, true);
                }
            });
        }
        com.sigmob.sdk.base.views.q qVar2 = this.r;
        if (qVar2 == null || !qVar2.a()) {
            return false;
        }
        if (activity != null && !this.m) {
            boolean isFinishing = activity.isFinishing();
            boolean isDestroyed = activity.isDestroyed();
            if (!isFinishing && !isDestroyed) {
                this.r.show();
                this.m = true;
                return true;
            }
            this.m = false;
            this.r.dismiss();
            this.r.c();
            this.r = null;
        }
        return true;
    }

    public boolean j() {
        BaseAdUnit l = l();
        if (l == null || !l.isDownloadDialog()) {
            return false;
        }
        return i();
    }

    public void k() {
        this.t = null;
        this.q = null;
        m();
    }

    public String b() {
        return this.i;
    }

    public void c(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public String d() {
        return this.f;
    }

    public String f() {
        return this.h;
    }

    public List<com.sigmob.sdk.videoAd.d> a(long j, long j2) {
        if (j2 <= 0 || j <= 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        com.sigmob.sdk.videoAd.d dVar = new com.sigmob.sdk.videoAd.d(a.k, j / j2);
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            com.sigmob.sdk.videoAd.d dVar2 = this.l.get(i);
            if (dVar2.compareTo(dVar) > 0) {
                break;
            }
            if (!dVar2.isTracked()) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    public void b(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void c(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
    }

    public void d(String str) {
        if (str == null) {
            return;
        }
        this.g = str;
    }

    public void e(String str) {
        if (str == null) {
            return;
        }
        this.h = str;
    }

    public void f(String str) {
        BaseAdUnit l = l();
        if (l == null) {
            return;
        }
        if (q.a(this.o)) {
            try {
                ak.a(com.sigmob.sdk.b.e(), "正在下载", 1).show();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String landing_page = l.getLanding_page();
        if (!com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            landing_page = str;
        }
        String macroProcess = l.getMacroCommon().macroProcess(landing_page);
        if (l.getsubInteractionType() != 1) {
            this.o = str;
            q.a(str, l());
            return;
        }
        JsonRequest jsonRequest = new JsonRequest(macroProcess, new AnonymousClass2(), 1);
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue != null) {
            jsonRequest.setTag("GDTRequestConvert");
            sigRequestQueue.add(jsonRequest);
        } else {
            final int i = 0;
            ae.a("download_start", Constants.FAIL, l(), new ae.a(this) { // from class: com.sigmob.sdk.base.common.AZOQYO

                /* renamed from: AlLFFp, reason: collision with root package name */
                public final /* synthetic */ i f13068AlLFFp;

                {
                    this.f13068AlLFFp = this;
                }

                @Override // com.sigmob.sdk.base.common.ae.a
                public final void onAddExtra(Object obj) {
                    switch (i) {
                        case 0:
                            this.f13068AlLFFp.b(obj);
                            break;
                        default:
                            this.f13068AlLFFp.a(obj);
                            break;
                    }
                }
            });
            final int i2 = 1;
            ae.a("download_start", 0, "request queue is null.", l(), new ae.a(this) { // from class: com.sigmob.sdk.base.common.AZOQYO

                /* renamed from: AlLFFp, reason: collision with root package name */
                public final /* synthetic */ i f13068AlLFFp;

                {
                    this.f13068AlLFFp = this;
                }

                @Override // com.sigmob.sdk.base.common.ae.a
                public final void onAddExtra(Object obj) {
                    switch (i2) {
                        case 0:
                            this.f13068AlLFFp.b(obj);
                            break;
                        default:
                            this.f13068AlLFFp.a(obj);
                            break;
                    }
                }
            });
        }
    }

    public void a(int i) {
        this.w = i;
    }

    public void b(Context context, BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.LANDING_PAGE_CLOSE, (String) null, baseAdUnit);
    }

    public void c(String str) {
        if (str == null) {
            return;
        }
        this.f = str;
    }

    private void b(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z) {
        ah sessionManager;
        BaseAdUnit l = l();
        if (l == null || (sessionManager = l.getSessionManager()) == null) {
            return;
        }
        int i = AnonymousClass5.f13142a[aVar.ordinal()];
        sessionManager.a(i != 1 ? i != 2 ? "click" : a.t : a.s, 0);
    }

    public void a(Activity activity, BaseAdUnit baseAdUnit, q.b bVar) {
        if (baseAdUnit == null) {
            return;
        }
        if (activity != null) {
            this.s = new WeakReference<>(activity);
        }
        this.t = bVar;
    }

    public void a(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null.");
        ae.b("start", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "start");
    }

    public void b(BaseAdUnit baseAdUnit) {
        this.u = new WeakReference<>(baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(this.o);
        }
    }

    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(Context context, BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.LANDING_PAGE_SHOW, (String) null, baseAdUnit);
    }

    public void b(String str) {
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(str);
        }
    }

    public void a(Context context, String str, BaseAdUnit baseAdUnit, String str2, int i) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ae.a(str2, i, str, baseAdUnit);
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z) {
        a(aVar, str, str2, z, false);
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z, boolean z2) {
        ClickCommon clickCommon;
        BaseAdUnit l = l();
        if (l == null || (clickCommon = l.getClickCommon()) == null) {
            return;
        }
        AndroidMarket androidMarket = l.getAndroidMarket();
        String str3 = com.sigmob.sdk.base.utils.o.a((CharSequence) str) ? this.c : str;
        clickCommon.clickUIType = aVar;
        clickCommon.clickCoordinate = str2;
        clickCommon.clickUrl = str3;
        a(l, z);
        new ao.a().a(an.IGNORE_ABOUT_SCHEME, an.OPEN_WITH_BROWSER, an.MARKET_SCHEME, an.DOWNLOAD_APK, an.FOLLOW_PACKAGE_NAME, an.FOLLOW_DEEP_LINK, an.MINI_PROGRAM).a(new AnonymousClass4(l, z, androidMarket, z2, aVar)).a(l()).a(l.isSkipSigmobBrowser()).b(l.getAd().forbiden_parse_landingpage.booleanValue()).a().a(com.sigmob.sdk.b.e(), str);
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z, boolean z2, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append(f13137a);
        sb.append("handleUrlAction: clickUIType = ");
        sb.append(aVar);
        sb.append(", url = ");
        com.bykv.vk.component.ttvideo.player.A2egSU.BIYEnU(sb, str, ", coordinate = ", str2, ", isRecord = ");
        sb.append(z);
        sb.append(", showAppElement = ");
        sb.append(z2);
        sb.append(", ext = ");
        sb.append(jSONObject);
        SigmobLog.d(sb.toString());
        int optInt = jSONObject == null ? 2 : jSONObject.optInt("interaction_type", 2);
        int i = 0;
        boolean optBoolean = jSONObject == null ? false : jSONObject.optBoolean("disable_landing", false);
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) || !optBoolean) {
            a(aVar, str, str2, z, z2);
            return;
        }
        String optString = jSONObject.optString("failback_url");
        String optString2 = jSONObject.optString("product_name");
        String optString3 = jSONObject.optString("app_icon_url");
        Context e = com.sigmob.sdk.b.e();
        try {
            try {
                BaseAdUnit l = l();
                boolean b = com.sigmob.sdk.base.utils.q.b(l);
                if (b) {
                    l.setMraidInteractionType(optInt);
                }
                boolean z3 = b && l.enableSmallWindow(Integer.valueOf(optInt));
                if (optInt == 1) {
                    v.a(e, Uri.parse(str), (String) null, z3);
                } else if (optInt == 2) {
                    this.o = str;
                    if (l != null) {
                        i = l.getApkDownloadType();
                    }
                    q.a(this.o, optString3, optString2, i);
                } else if (optInt == 7) {
                    v.a(e, jSONObject.optString("wx_app_id"), jSONObject.optString("wx_app_username"), jSONObject.optString("wx_app_path"), jSONObject.optInt("wx_business_type"), jSONObject.optString("wx_ext_msg"));
                } else if (optInt == 9) {
                    v.a(e, (Uri) null, jSONObject.optString(com.sigmob.sdk.base.n.p), z3);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            v.a(e, Uri.parse(optString));
        }
        ac acVar = this.q;
        if (acVar != null) {
            acVar.onAdClick(z, aVar);
        }
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, boolean z) {
        a(aVar, (String) null, str, z, true);
    }

    public void a(ac acVar) {
        this.q = acVar;
    }

    public static void a(BaseAdUnit baseAdUnit, String str, boolean z) {
        String macroProcess = baseAdUnit.getMacroCommon().macroProcess(str);
        String apkPackageName = baseAdUnit.getApkPackageName();
        if (baseAdUnit.getsubInteractionType() == 2 || !com.sigmob.sdk.base.utils.o.a((CharSequence) apkPackageName)) {
            String productId = baseAdUnit.getProductId();
            if (com.sigmob.sdk.base.utils.o.a((CharSequence) apkPackageName)) {
                apkPackageName = productId;
            }
            if (!com.sigmob.sdk.base.utils.o.a((CharSequence) apkPackageName)) {
                try {
                    h.c(baseAdUnit);
                    v.c(com.sigmob.sdk.b.e(), apkPackageName);
                    return;
                } catch (Throwable th) {
                    h.c((BaseAdUnit) null);
                    SigmobLog.e(f13137a + "handleMRAID2Download: error = " + th.getMessage());
                }
            }
        }
        if (baseAdUnit.getsubInteractionType() != 1 || z) {
            q.a(macroProcess, baseAdUnit);
            return;
        }
        JsonRequest jsonRequest = new JsonRequest(macroProcess, new AnonymousClass3(baseAdUnit, macroProcess), 1);
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue == null) {
            ae.a("download_start", Constants.FAIL, baseAdUnit, new AaHO0E(macroProcess, 14));
            ae.a("download_start", 0, "request queue is null", baseAdUnit, new AaHO0E(macroProcess, 15));
        } else {
            jsonRequest.setTag("GDTRequestConvert");
            sigRequestQueue.add(jsonRequest);
        }
    }

    private void a(BaseAdUnit baseAdUnit, boolean z) {
        ClickCommon clickCommon;
        if (baseAdUnit == null || !z || (clickCommon = baseAdUnit.getClickCommon()) == null) {
            return;
        }
        String str = clickCommon.is_final_click ? "1" : Constants.FAIL;
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        macroCommon.addMarcoKey("_AX_", clickCommon.adarea_x);
        macroCommon.addMarcoKey("_AY_", clickCommon.adarea_y);
        macroCommon.addMarcoKey("_AW_", clickCommon.adarea_w);
        macroCommon.addMarcoKey("_AH_", clickCommon.adarea_h);
        if ("5".equals(clickCommon.sld)) {
            macroCommon.updateClickMarco(SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY);
            macroCommon.addMarcoKey(SigMacroCommon._SLD_, clickCommon.sld);
            macroCommon.addMarcoKey("_TURNX_", clickCommon.turn_x);
            macroCommon.addMarcoKey("_TURNY_", clickCommon.turn_y);
            macroCommon.addMarcoKey("_TURNZ_", clickCommon.turn_z);
            macroCommon.addMarcoKey("_TURNTIME_", clickCommon.turn_time);
            macroCommon.addMarcoKey("_CPTIDS_", String.valueOf(clickCommon.widget_id));
        } else if ("2".equals(clickCommon.sld)) {
            macroCommon.updateClickMarco(SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY);
            macroCommon.addMarcoKey(SigMacroCommon._SLD_, clickCommon.sld);
            macroCommon.addMarcoKey("_CPTIDS_", String.valueOf(clickCommon.widget_id));
            macroCommon.addMarcoKey("_XMAXACC_", clickCommon.x_max_acc);
            macroCommon.addMarcoKey("_YMAXACC_", clickCommon.y_max_acc);
            macroCommon.addMarcoKey("_ZMAXACC_", clickCommon.z_max_acc);
        } else if (baseAdUnit.getCreativeType() != 9) {
            clickCommon.sld = Constants.FAIL;
            macroCommon.updateClickMarco(clickCommon.down, clickCommon.up);
            macroCommon.addMarcoKey(SigMacroCommon._SLD_, Constants.FAIL);
        }
        if (baseAdUnit.getTemplateId() > 0) {
            macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
        }
        if (!com.sigmob.sdk.base.utils.o.a((CharSequence) clickCommon.click_area)) {
            macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(clickCommon.click_area));
        }
        if (!com.sigmob.sdk.base.utils.o.a((CharSequence) clickCommon.click_scene)) {
            macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(clickCommon.click_scene));
        }
        macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFinal_url(this.o);
        }
    }

    public void a(String str) {
        this.i = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFinal_url(str);
        }
    }

    public void a(List<com.sigmob.sdk.videoAd.d> list) {
        Preconditions.NoThrow.checkNotNull(list, "fractionalTrackers cannot be null");
        this.l.addAll(list);
        Collections.sort(this.l);
    }

    public boolean a() {
        return this.v;
    }
}
