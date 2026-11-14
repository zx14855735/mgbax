package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AdResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final String TAG = "AdResultData";
    private static final long serialVersionUID = -818939163644825380L;
    public AdGlobalConfigInfo adGlobalConfigInfo;
    public boolean hasMore;
    public int mAdCacheId;
    private String mAdSource;
    private List<AdTemplate> mAdTemplateList;
    protected String mOriginalJson;
    private Map<Long, SceneImpl> mRequestAdSceneMap;
    private SceneImpl mScene;
    public PageInfo pageInfo;
    public String pcursor;

    public AdResultData() {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
    }

    public static AdResultData createFromResponseJson(String str, SceneImpl sceneImpl) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(sceneImpl);
        adResultData.parseJson(jSONObject);
        adResultData.mOriginalJson = str;
        return adResultData;
    }

    public static AdVideoPreCacheConfig obtainVideoPreCacheConfig(AdResultData adResultData, int i) {
        AdVideoPreCacheConfig adVideoPreCacheConfig;
        if (adResultData == null) {
            return null;
        }
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        return (adGlobalConfigInfo == null || (adVideoPreCacheConfig = adGlobalConfigInfo.adVideoPreCacheConfig) == null) ? new AdVideoPreCacheConfig(i, false) : adVideoPreCacheConfig;
    }

    private static boolean styleMatch(SceneImpl sceneImpl, AdTemplate adTemplate) {
        int i = sceneImpl.adStyle;
        int i2 = adTemplate.adStyle;
        return i == 13 ? i2 == 13 || i2 == 23 : i == i2;
    }

    public SceneImpl getAdScene(long j) {
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j)) : null;
        return sceneImpl == null ? new SceneImpl(j) : sceneImpl;
    }

    public String getAdSource() {
        String str = this.mAdSource;
        return str != null ? str : "network";
    }

    public List<AdTemplate> getAdTemplateList() {
        return this.mAdTemplateList;
    }

    public SceneImpl getDefaultAdScene() {
        return getAdScene(getPosId());
    }

    public AdTemplate getFirstAdTemplate() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null || adTemplateList.size() == 0) {
            return null;
        }
        return adTemplateList.get(0);
    }

    public long getPosId() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0) {
            return 0L;
        }
        return proceedTemplateList.get(0).posId;
    }

    public List<AdTemplate> getProceedTemplateList() {
        ArrayList arrayList = new ArrayList();
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList != null) {
            int size = adTemplateList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(adTemplateList.get(i));
            }
        }
        return arrayList;
    }

    public String getResponseJson() {
        String str = this.mOriginalJson;
        if (str != null) {
            return str;
        }
        JSONObject json = super.toJson();
        aa.putValue(json, "pcursor", this.pcursor);
        aa.a(json, "pageInfo", this.pageInfo);
        aa.putValue(json, "impAdInfo", ((e) d.f(e.class)).av(aa.S(getAdTemplateList()).toString()));
        return json.toString();
    }

    public boolean isAdResultDataEmpty() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList.isEmpty()) {
            c.w(TAG, "adTemplateList is empty");
            return true;
        }
        c.d(TAG, "adTemplateList size = " + adTemplateList.size());
        List<AdInfo> list = adTemplateList.get(0).adInfoList;
        if (list.isEmpty()) {
            c.w(TAG, "adInfoList is empty");
            return true;
        }
        if (list.get(0) != null) {
            return false;
        }
        c.w(TAG, "adInfo is null");
        return true;
    }

    public boolean isBidding() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        return proceedTemplateList.size() != 0 && com.kwad.sdk.core.response.b.e.eF(proceedTemplateList.get(0)) > 0;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007d -> B:21:0x0084). Please report as a decompilation issue!!! */
    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        JSONArray jSONArray;
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.pcursor = jSONObject.optString("pcursor");
            this.hasMore = jSONObject.optBoolean("hasMore");
            String optString = jSONObject.optString("adGlobalConfigInfo");
            e eVar = (e) d.f(e.class);
            if (!bp.isNullString(optString)) {
                String responseData = eVar.getResponseData(optString);
                AdGlobalConfigInfo adGlobalConfigInfo = new AdGlobalConfigInfo();
                this.adGlobalConfigInfo = adGlobalConfigInfo;
                adGlobalConfigInfo.parseJson(new JSONObject(responseData));
                ag.c(ServiceProvider.getContext(), this.adGlobalConfigInfo.uaidEnable);
                try {
                    AdGlobalConfigInfo adGlobalConfigInfo2 = this.adGlobalConfigInfo;
                    if (adGlobalConfigInfo2.authError == AdGlobalConfigInfo.AUTH_SERVICE_TOKEN_CHECK_FAIL) {
                        ag.e(ServiceProvider.getContext(), true);
                    } else {
                        AdGlobalConfigInfo.RefreshToken refreshToken = adGlobalConfigInfo2.refreshToken;
                        if (refreshToken != null && refreshToken.isDataValid()) {
                            ag.c(ServiceProvider.getContext(), this.adGlobalConfigInfo.refreshToken.toJson().toString(), true);
                        }
                    }
                } catch (Throwable th) {
                    c.printStackTrace(th);
                }
            }
            try {
                String optString2 = jSONObject.optString("pageInfo");
                if (!bp.isNullString(optString2)) {
                    this.pageInfo.parseJson(new JSONObject(eVar.getResponseData(optString2)));
                }
            } catch (Exception e) {
                c.d("json bug", e.toString());
                c.printStackTrace(e);
            }
            String optString3 = jSONObject.optString("impAdInfo");
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            String responseData2 = eVar.getResponseData(optString3);
            try {
                if (bp.isNullString(responseData2)) {
                    return;
                }
                try {
                    jSONArray = new JSONArray(responseData2);
                } catch (Throwable unused) {
                    com.kwad.sdk.commercial.e.a.a(this.mScene, this.llsid, optString3, responseData2);
                    jSONArray = null;
                }
                if (jSONArray == null || jSONArray.length() <= 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AdTemplate adTemplate = new AdTemplate();
                        adTemplate.parseJson(optJSONObject);
                        adTemplate.llsid = this.llsid;
                        adTemplate.extra = this.extra;
                        adTemplate.mAdScene = getAdScene(adTemplate.posId);
                        adTemplate.mPageInfo = this.pageInfo;
                        this.mAdTemplateList.add(adTemplate);
                        com.kwad.sdk.commercial.e.a.bP(adTemplate);
                        SceneImpl sceneImpl = this.mScene;
                        if (sceneImpl != null && !styleMatch(sceneImpl, adTemplate)) {
                            int i2 = adTemplate.adStyle;
                            adTemplate.adStyle = this.mScene.adStyle;
                            com.kwad.sdk.commercial.e.a.c(adTemplate, "ad_style", String.valueOf(i2));
                        }
                    }
                }
            } catch (Throwable unused2) {
                com.kwad.sdk.commercial.e.a.a(this.mScene, this.llsid, optString3);
            }
        } catch (Throwable th2) {
            c.printStackTrace(th2);
        }
    }

    public void setAdSource(String str) {
        this.mAdSource = str;
    }

    public void setAdTemplateList(List<AdTemplate> list) {
        this.mAdTemplateList = list;
    }

    public void setRequestAdSceneList(List<SceneImpl> list) {
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (SceneImpl sceneImpl : list) {
                this.mRequestAdSceneMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "pcursor", this.pcursor);
        aa.putValue(json, "hasMore", this.hasMore);
        aa.a(json, "pageInfo", this.pageInfo);
        aa.putValue(json, "impAdInfo", getAdTemplateList());
        aa.a(json, "adGlobalConfigInfo", this.adGlobalConfigInfo);
        int i = this.mAdCacheId;
        if (i != 0) {
            aa.putValue(json, "adCacheId", i);
        }
        return json;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AdResultData m16clone() {
        AdResultData adResultData = new AdResultData();
        try {
            adResultData.parseJson(toJson());
            return adResultData;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            return adResultData;
        }
    }

    public AdResultData(SceneImpl sceneImpl) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        this.mScene = sceneImpl;
        if (sceneImpl != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
        }
    }

    public AdResultData(BaseResultData baseResultData, SceneImpl sceneImpl, List<AdTemplate> list) {
        this(sceneImpl);
        if (baseResultData == null) {
            return;
        }
        super.parseJson(baseResultData.baseToJson());
        if (list != null) {
            getAdTemplateList().addAll(list);
        }
    }

    public AdResultData(List<SceneImpl> list) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        setRequestAdSceneList(list);
    }
}
