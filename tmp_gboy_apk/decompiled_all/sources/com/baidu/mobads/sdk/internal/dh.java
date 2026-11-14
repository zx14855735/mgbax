package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.kwad.sdk.core.scene.URLPackage;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dh implements u {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ de f9819a;

    public dh(de deVar) {
        this.f9819a = deVar;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9819a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f9819a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f9819a.E));
        hashMap.put("novel_id", this.f9819a.F);
        this.f9819a.a(de.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9819a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9819a.h()));
        hashMap.put("entry", Integer.valueOf(this.f9819a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f9819a.E));
        hashMap.put("novel_id", this.f9819a.F);
        hashMap.put("novel_info", jSONObject);
        this.f9819a.a(de.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9819a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9819a.h()));
        hashMap.put("entry", Integer.valueOf(this.f9819a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f9819a.E));
        hashMap.put("novel_id", this.f9819a.F);
        hashMap.put("novel_info", jSONObject);
        this.f9819a.a(de.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f9819a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f9819a.E));
        hashMap.put("novel_id", this.f9819a.F);
        hashMap.put("isnight", Boolean.valueOf(this.f9819a.x()));
        this.f9819a.a(de.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9819a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9819a.h()));
        hashMap.put("entry", Integer.valueOf(this.f9819a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f9819a.E));
        hashMap.put("novel_id", this.f9819a.F);
        hashMap.put("backgroundColor", Integer.valueOf(i));
        this.f9819a.a(de.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i = this.f9819a.i("get_cuid");
        String i2 = this.f9819a.i("get_imei");
        String i3 = this.f9819a.i("get_oaid");
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
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f9819a.H;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f9819a.H;
            cpuNovelListener2.onReadTime(j);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f9819a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f9819a.h()));
        hashMap.put("entry", Integer.valueOf(this.f9819a.D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f9819a.E));
        hashMap.put("novel_id", this.f9819a.F);
        hashMap.put("count_down", Integer.valueOf(i));
        this.f9819a.a(de.x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f9819a.I;
        if (softReference != null) {
            softReference2 = this.f9819a.I;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f9819a.h);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.f9819a.D));
                hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f9819a.E));
                hashMap.put("novel_id", this.f9819a.F);
                hashMap.put("isnight", Boolean.valueOf(this.f9819a.x()));
                this.f9819a.a(de.w, hashMap);
            }
        }
    }
}
