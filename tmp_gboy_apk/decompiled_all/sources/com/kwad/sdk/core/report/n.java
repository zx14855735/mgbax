package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class n extends e {
    public String NB;
    public long ND;
    public String Nz;
    public String PI;
    public long aHN;
    public URLPackage aLA;
    public String aLB;
    public JSONArray aLC;
    public JSONArray aLD;
    public a aLE;
    public int aLF;
    public int aLG;
    public int aLH;
    public int aLI;
    public String aLJ;
    public int aLK;
    public int aLL;
    public String aLM;
    public JSONObject aLN;
    public JSONArray aLO;
    public int aLP;
    public int aLQ;
    public int aLR;
    public JSONArray aLT;
    public boolean aLU;
    public String aLV;
    public long aLY;
    public int aLZ;
    public long aLq;
    public JSONObject aLr;
    public JSONObject aLs;
    public long aLt;
    public long aLu;
    public long aLv;
    public long aLw;
    public long aLx;
    public long aLz;
    public String aMa;
    public long aMb;
    public long aMc;
    public long aMd;
    public long aMe;
    public String aMf;
    public int aMg;
    public JSONArray aMh;
    public long aMi;
    public long aMj;
    public JSONArray aMk;
    public String aMl;
    public String aMm;
    public String aMn;
    public String aMo;
    public String aMp;
    public String aMr;
    public String aMs;
    public int aMt;
    public long aMw;
    public long aMx;
    public String aMy;
    public long aaB;
    public long aaC;
    public long aaD;
    public String aau;
    public long abv;
    public long actionType;
    public transient SceneImpl adScene;
    public long age;
    public int ahA;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sdkApiVersion;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long aLy = -1;
    public int aCH = 0;
    public long aLS = 0;
    public int aLW = 0;
    public int aLX = -1;
    public int aMq = 0;
    public int aMu = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String aMv = BuildConfig.VERSION_NAME;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int aMA;
        public int aMz;

        public static a Kp() {
            a aVar = new a();
            aVar.aMz = b.aMz;
            aVar.aMA = b.aMA;
            return aVar;
        }
    }

    public static class b {
        public static int aMA;
        public static int aMz;
    }

    public n(long j) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aMy = "";
        this.actionType = j;
    }

    private void co(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        try {
            this.aLG = 3;
            s sVar = (s) ServiceProvider.get(s.class);
            if (sVar != null) {
                this.aLW = sVar.xN();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = t.Ku();
            try {
                this.ND = t.Kv();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            this.aLq = t.Kw();
            SceneImpl sceneImpl2 = this.adScene;
            if (sceneImpl2 != null) {
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                this.adScene = sceneImpl;
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.aLt = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.b.e.eo(adTemplate);
                String ep = com.kwad.sdk.core.response.b.e.ep(adTemplate);
                if (!TextUtils.isEmpty(ep)) {
                    try {
                        this.aLr = new JSONObject(ep);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                    }
                }
                String eq = com.kwad.sdk.core.response.b.e.eq(adTemplate);
                if (!TextUtils.isEmpty(eq)) {
                    try {
                        this.aLs = new JSONObject(eq);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e3);
                    }
                }
                this.posId = com.kwad.sdk.core.response.b.e.ek(adTemplate);
                this.contentType = com.kwad.sdk.core.response.b.e.en(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.b.e.ex(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
                    this.creativeId = er.adBaseInfo.creativeId;
                    this.aLu = com.kwad.sdk.core.response.b.a.M(er) * 1000;
                    this.abv = er.advertiserInfo.userId;
                }
                this.aLF = adTemplate.mMediaPlayerType;
                this.aLH = adTemplate.mIsLeftSlipStatus;
                this.aLI = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.pageType = pageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.b.e.ey(adTemplate);
            }
            this.aLE = a.Kp();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e4);
        }
    }

    public final n Kn() {
        co(this.mAdTemplate);
        return this;
    }

    public final void Ko() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.aLP = jVar.tU() ? 1 : 0;
        this.aLQ = jVar.tV();
        this.aLR = jVar.tW();
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aLG = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.aLL = jSONObject.optInt("num");
        this.aLK = jSONObject.optInt("state");
        this.aLS = jSONObject.optLong("timeSpend");
        this.aMi = jSONObject.optLong("loadingDuration");
        this.aMj = jSONObject.optLong("loadingDurationLimt");
        this.aLX = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        aa.putValue(jSONObject, "actionId", this.actionId);
        int i = this.adStyle;
        if (i > 0) {
            aa.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.aLL;
        if (i2 > 0) {
            aa.putValue(jSONObject, "num", i2);
        }
        int i3 = this.aLK;
        if (i3 != 0) {
            aa.putValue(jSONObject, "state", i3);
        }
        long j = this.aLS;
        if (j > 0) {
            aa.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.aMi;
        if (j2 > 0) {
            aa.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.aMj;
        if (j3 > 0) {
            aa.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        aa.putValue(jSONObject, "playerTypeInfo", this.aLX);
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        if (TextUtils.isEmpty(this.aMy)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.aMy + '}';
    }

    public n(long j, AdTemplate adTemplate) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aMy = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
    }

    public n(long j, AdTemplate adTemplate, String str) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aMy = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
        this.PI = str;
    }

    public n(String str, String str2, boolean z) {
        String apiVersion;
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null) {
            apiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        } else {
            apiVersion = "";
        }
        this.sdkApiVersion = apiVersion;
        this.sdkType = 1;
        this.actionId = str;
        this.aMy = str2;
    }
}
