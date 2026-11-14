package com.sigmob.sdk;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.exceptions.CrashHandler;
import com.czhj.sdk.common.models.BidRequest;
import com.czhj.sdk.common.mta.PointEntityCommon;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.common.network.JsonRequest;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.common.util.CommConstant;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobCrash;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.services.f;
import com.sigmob.sdk.base.utils.k;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class Sigmob {

    /* renamed from: a, reason: collision with root package name */
    private static Sigmob f13017a;
    public static SigMacroCommon macroCommon;
    private WindAdError b;

    private Sigmob() {
    }

    private String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private static void b() {
        try {
            if (o.a().S()) {
                return;
            }
            f.a(f.f13211a, i.a().i());
        } catch (Throwable th) {
            SigmobLog.e("updateLocationMonitor fail", th);
        }
    }

    private static void c() {
        try {
            f.a(f.b, true);
        } catch (Throwable th) {
            SigmobLog.e("initAppInstallService fail", th);
        }
    }

    public static BidRequest createRequest() {
        BidRequest.Builder builder = new BidRequest.Builder();
        try {
            builder = com.sigmob.sdk.base.network.a.a((LoadAdRequest) null);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        return builder.build();
    }

    private static void d() {
        try {
            f.a(f.c, i.a().i() && o.a().W());
        } catch (Throwable th) {
            SigmobLog.e("updateWifiScanService fail", th);
        }
    }

    private static void e() {
        try {
            f.a(f.d, true);
        } catch (Throwable th) {
            SigmobLog.e("initDownloadService fail", th);
        }
    }

    private void f() {
        Networking.getSigRequestQueue().add(new JsonRequest(o.d(), new JsonRequest.Listener() { // from class: com.sigmob.sdk.Sigmob.2
            @Override // com.czhj.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                Sigmob.this.h();
                i.a().a((Boolean) null);
            }

            @Override // com.czhj.sdk.common.network.JsonRequest.Listener
            public void onSuccess(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        i.a().a(Boolean.valueOf(jSONObject.getBoolean(Constants.IS_REQUEST_IN_EEA_OR_UNKNOWN)));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                Sigmob.this.h();
            }
        }, 0));
    }

    private void g() {
        try {
            File[] k = k.k();
            if (k == null) {
                return;
            }
            for (File file : k) {
                String readFileToString = FileUtil.readFileToString(file);
                if (!TextUtils.isEmpty(readFileToString)) {
                    a(file, readFileToString);
                }
            }
        } catch (Throwable th) {
            SigmobLog.e("send crash Log fail", th);
        }
    }

    public static synchronized Sigmob getInstance() {
        Sigmob sigmob;
        synchronized (Sigmob.class) {
            try {
                if (f13017a == null) {
                    synchronized (Sigmob.class) {
                        f13017a = new Sigmob();
                    }
                }
                sigmob = f13017a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sigmob;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        e();
        b.d();
        o.a().a(new com.fl.saas.base.manager.loader.ADYaiT(21)).f();
        if (o.a().aa()) {
            String[] split = WindAds.class.getName().split("\\.");
            if (split.length <= 2) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(split[0]);
            sb.append(".");
            final String B25kr62 = CtFAbx.B25kr6(sb, split[1], ".");
            CrashHandler.getInstance().add(new CrashHandler.CrashHandlerListener() { // from class: com.sigmob.sdk.A5SV6n
                @Override // com.czhj.sdk.common.exceptions.CrashHandler.CrashHandlerListener
                public final void reportCrash(String str) {
                    Sigmob.this.a(B25kr62, str);
                }
            });
            g();
        }
        i();
    }

    private void i() {
        Context e = b.e();
        if (e == null) {
            return;
        }
        ImageManager.with(e).clearCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        ae.a(PointCategory.APP);
        this.b = com.sigmob.sdk.base.common.f.b();
        f();
    }

    public SigMacroCommon getMacroCommon() {
        if (macroCommon == null) {
            macroCommon = new SigMacroCommon();
        }
        return macroCommon;
    }

    public String getSDKToken() {
        b.a(true);
        String str = "2.01|" + a(createRequest().encode());
        ae.a("token_request", (String) null, (BaseAdUnit) null, (ae.a) null);
        SigmobLog.d("getSDKToken: " + str);
        return str;
    }

    public WindAdError getSigMobError() {
        return this.b;
    }

    public void init() {
        boolean z;
        int i;
        WindCustomController customController;
        VolleyLog.DEBUG = n.f.booleanValue();
        WindAdOptions options = WindAds.sharedAds().getOptions();
        o a2 = o.a();
        final int ae = a2.ae();
        boolean j = a2.j();
        final boolean T = a2.T();
        boolean z2 = false;
        if (options == null || (customController = options.getCustomController()) == null) {
            z = true;
            i = 0;
        } else {
            z = customController.isCanUseAppList();
            i = z ? 1 : 2;
        }
        if (!j && (ae == 1 || (ae != 2 && z && !T))) {
            z2 = true;
        }
        final boolean d = com.sigmob.sdk.base.common.f.d();
        final int i2 = i;
        final boolean z3 = z2;
        ae.a("init", new ae.a() { // from class: com.sigmob.sdk.A2egSU
            @Override // com.sigmob.sdk.base.common.ae.a
            public final void onAddExtra(Object obj) {
                Sigmob.a(i2, d, T, ae, z3, obj);
            }
        });
        if (o.a().Y()) {
            ae.a(PointCategory.PERMISSION, "init", (BaseAdUnit) null, new com.fl.saas.base.manager.loader.ADYaiT(20));
        }
        h.e();
        final int i3 = 0;
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable(this) { // from class: com.sigmob.sdk.A4TApA

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ Sigmob f12993AlLFFp;

            {
                this.f12993AlLFFp = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        this.f12993AlLFFp.j();
                        break;
                    default:
                        this.f12993AlLFFp.a();
                        break;
                }
            }
        });
        TrackManager.getInstance().setSigmobTrackListener(new TrackManager.Listener() { // from class: com.sigmob.sdk.Sigmob.1
            @Override // com.czhj.sdk.common.track.TrackManager.Listener
            public void onErrorResponse(AdTracker adTracker, VolleyError volleyError) {
                ae.a(adTracker, adTracker.getUrl(), (BaseAdUnit) null, volleyError);
            }

            @Override // com.czhj.sdk.common.track.TrackManager.Listener
            public void onSuccess(AdTracker adTracker, NetworkResponse networkResponse) {
                ae.a(adTracker, adTracker.getUrl(), (BaseAdUnit) null, networkResponse, (ae.a) null);
            }
        });
        final int i4 = 1;
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable(this) { // from class: com.sigmob.sdk.A4TApA

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ Sigmob f12993AlLFFp;

            {
                this.f12993AlLFFp = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i4) {
                    case 0:
                        this.f12993AlLFFp.j();
                        break;
                    default:
                        this.f12993AlLFFp.a();
                        break;
                }
            }
        });
        TrackManager.getInstance().startRetryTracking();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        h.b();
        h.l();
        h.j();
        h.i();
        h.h();
        h.k();
        h.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, boolean z, boolean z2, int i2, boolean z3, Object obj) {
        if (obj instanceof PointEntityCommon) {
            PointEntityCommon pointEntityCommon = (PointEntityCommon) obj;
            Map<String, String> options = pointEntityCommon.getOptions();
            options.put(PointParamKey.IS_MINOR, i.a().d() ? Constants.FAIL : "1");
            options.put(PointParamKey.IS_UNPERSONALIZED, i.a().e() ? Constants.FAIL : "1");
            options.put("canUseAppList", String.valueOf(i));
            options.put("appListPermission", z ? "1" : Constants.FAIL);
            options.put("disableUpAppInfo", z2 ? "1" : Constants.FAIL);
            options.put("EnableAppList", String.valueOf(i2));
            options.put("uploadAppList", z3 ? "1" : Constants.FAIL);
            options.put("common_version", String.valueOf(WindAds.sharedAds().getCommonVersion()));
            pointEntityCommon.setOptions(options);
        }
    }

    private void a(final File file, String str) {
        PointEntitySigmobCrash WindCrash = PointEntitySigmobCrash.WindCrash(str);
        if (file != null) {
            try {
                WindCrash.setCrashTime(Long.parseLong(file.getName().replace(".log", "")));
            } catch (Throwable th) {
                SigmobLog.e("set crash time fail", th);
            }
        }
        WindCrash.sendServe(new BuriedPointRequest.RequestListener() { // from class: com.sigmob.sdk.Sigmob.3
            @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
            public void onErrorResponse(VolleyError volleyError) {
            }

            @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
            public void onSuccess() {
                File file2 = file;
                if (file2 == null) {
                    return;
                }
                file2.delete();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setPermission(ClientMetadata.getInstance().getPermission(b.e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.contains(str) || str2.contains("com.czhj.")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("crashTime", System.currentTimeMillis());
                jSONObject.put(MedProConst.AD_APPID, WindAds.sharedAds().getAppId());
                jSONObject.put(CommConstant.SdkVersion.SDK_VERSION_KEY, WindAds.sharedAds().getAppId());
                jSONObject.put("commonVersion", n.k);
                jSONObject.put("wmsession_id", PointEntitySuper.getSessionId());
                jSONObject.put("crashLog", URLEncoder.encode(str2, "UTF-8"));
                String jSONObject2 = jSONObject.toString();
                SigmobLog.e("crashLog " + jSONObject2);
                File j = k.j();
                if (j != null) {
                    FileUtil.writeToBuffer(jSONObject2.getBytes(), j.getAbsolutePath());
                }
                a(j, jSONObject2);
            } catch (Throwable th) {
                SigmobLog.e("error ", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z) {
        if (z) {
            b();
            com.sigmob.sdk.base.services.b.b();
            c();
            com.sigmob.sdk.base.services.b.d();
        }
    }
}
