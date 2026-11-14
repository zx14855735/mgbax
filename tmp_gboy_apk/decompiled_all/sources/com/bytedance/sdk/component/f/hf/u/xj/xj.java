package com.bytedance.sdk.component.f.hf.u.xj;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.f.xj.hf {
    private long c;
    private String d;
    private String f;
    private hf hf;
    private long kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10205pl;
    private byte tf;
    private byte u;
    private byte w;
    protected JSONObject xj;
    private long y;

    public xj(String str, JSONObject jSONObject) {
        this.d = str;
        this.xj = jSONObject;
    }

    public static com.bytedance.sdk.component.f.xj.hf u(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(PointParamKey.TYPE);
            int optInt2 = jSONObject.optInt("priority");
            xj xjVar = new xj();
            xjVar.xj((byte) optInt);
            xjVar.hf((byte) optInt2);
            xjVar.xj(jSONObject.optJSONObject("event"));
            xjVar.xj(jSONObject.optString("localId"));
            xjVar.hf(jSONObject.optString("genTime"));
            xjVar.xj(jSONObject.optInt("channel"));
            return xjVar;
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public synchronized JSONObject c() {
        hf hfVar;
        try {
            if (this.xj == null && (hfVar = this.hf) != null) {
                this.xj = hfVar.xj(tf());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public long d() {
        return this.y;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public long f() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public byte hf() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public byte kd() {
        return this.u;
    }

    public String p() {
        return this.f;
    }

    public String tf() {
        return this.p;
    }

    public void w(String str) {
        this.p = str;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public hf xj() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public String y() {
        if (TextUtils.isEmpty(this.d)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.d);
            jSONObject.put("event", c());
            jSONObject.put("genTime", p());
            jSONObject.put("priority", (int) this.u);
            jSONObject.put(PointParamKey.TYPE, (int) this.w);
            jSONObject.put("channel", this.f10205pl);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void hf(String str) {
        this.f = str;
    }

    public void w(byte b) {
        this.tf = b;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void xj(JSONObject jSONObject) {
        this.xj = jSONObject;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void hf(long j) {
        this.y = j;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public String w() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void xj(byte b) {
        this.w = b;
    }

    public xj(String str, hf hfVar) {
        this.d = str;
        this.hf = hfVar;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void hf(byte b) {
        this.u = b;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void w(long j) {
        this.c = j;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void xj(String str) {
        this.d = str;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void xj(long j) {
        this.kd = j;
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public void xj(int i) {
        this.f10205pl = i;
    }

    private xj() {
    }

    @Override // com.bytedance.sdk.component.f.xj.hf
    public byte u() {
        return this.w;
    }
}
