package com.sigmob.windad;

import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindAdRequest {

    /* renamed from: a, reason: collision with root package name */
    protected int f13783a = 1;
    private final int b;
    private final String c;
    private String d;
    private Map<String, Object> e;
    private Map<String, Object> f;
    private boolean g;

    public WindAdRequest(String str, String str2, Map<String, Object> map, int i) {
        this.c = str;
        this.d = str2;
        this.e = map;
        this.b = i;
    }

    public static boolean isPlacementEmpty(WindAdRequest windAdRequest) {
        return windAdRequest == null || TextUtils.isEmpty(windAdRequest.getPlacementId());
    }

    public int getAdCount() {
        return this.f13783a;
    }

    public int getAdType() {
        return this.b;
    }

    public String getAdxId() {
        Map<String, Object> map = this.f;
        if (map == null) {
            return null;
        }
        Object obj = map.get(WindAds.ADX_ID);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public String getLoadId() {
        Map<String, Object> map = this.f;
        if (map == null) {
            return null;
        }
        Object obj = map.get(Constants.LOAD_ID);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public Map<String, Object> getOptions() {
        return this.e;
    }

    public String getPlacementId() {
        return this.c;
    }

    public String getUserId() {
        return this.d;
    }

    public boolean hasOptions() {
        return this.e != null;
    }

    public boolean isHalfInterstitial() {
        return this.g;
    }

    public void setAdCount(int i) {
        this.f13783a = i;
    }

    public void setExtOptions(Map<String, Object> map) {
        this.f = map;
    }

    public void setHalfInterstitial(boolean z) {
        this.g = z;
    }

    public void setOptions(Map<String, Object> map) {
        this.e = map;
    }

    public void setUserId(String str) {
        this.d = str;
    }
}
