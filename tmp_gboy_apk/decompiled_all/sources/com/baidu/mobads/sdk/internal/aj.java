package com.baidu.mobads.sdk.internal;

import J3FDQU.A2egSU;
import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class aj implements u {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f9735a;

    public aj(ae aeVar) {
        this.f9735a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9735a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9735a.h()));
        hashMap.put("entry", 2);
        iArr = this.f9735a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f9735a.a(de.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9735a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f9735a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.f9735a.a(de.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9735a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9735a.h()));
        hashMap.put("entry", 2);
        iArr = this.f9735a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f9735a.a(de.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f9735a.t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.f9735a.a(de.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9735a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9735a.h()));
        hashMap.put("entry", 2);
        iArr = this.f9735a.t;
        A2egSU.BNL6CD(iArr[0], hashMap, URLPackage.KEY_CHANNEL_ID, i, "backgroundColor");
        this.f9735a.a(de.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i = this.f9735a.i("get_cuid");
        String i2 = this.f9735a.i("get_imei");
        String i3 = this.f9735a.i("get_oaid");
        try {
            jSONObject.put("cuid", i);
            jSONObject.put("imei", i2);
            jSONObject.put("oaid", i3);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(long j) {
        this.f9735a.i.a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9735a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9735a.h()));
        hashMap.put("entry", 2);
        iArr = this.f9735a.t;
        A2egSU.BNL6CD(iArr[0], hashMap, URLPackage.KEY_CHANNEL_ID, i, "count_down");
        this.f9735a.a(de.x, hashMap);
    }
}
