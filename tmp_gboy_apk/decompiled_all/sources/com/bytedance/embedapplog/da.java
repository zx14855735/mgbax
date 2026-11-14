package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class da extends vl {
    String am;
    long g;

    /* renamed from: pl, reason: collision with root package name */
    long f10100pl;
    public int qt = 0;

    @Override // com.bytedance.embedapplog.vl
    public String f() {
        return String.valueOf(this.f10100pl);
    }

    @Override // com.bytedance.embedapplog.vl
    public JSONObject hf() {
        rg rgVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.hf);
        jSONObject.put("tea_event_index", this.w);
        jSONObject.put("session_id", this.u);
        jSONObject.put("stop_timestamp", this.g / 1000);
        jSONObject.put(MediationConstant.EXTRA_DURATION, this.f10100pl / 1000);
        jSONObject.put("datetime", this.p);
        long j = this.kd;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.y) ? JSONObject.NULL : this.y);
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.put("ssid", this.c);
        }
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("ab_sdk_version", this.f);
        }
        if (!TextUtils.isEmpty(this.am)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.am, this.u)) {
                jSONObject.put("original_session_id", this.am);
            }
        }
        if (this.qt == 0 && (rgVar = (rg) h.hf.get("launch")) != null && !rgVar.jk) {
            this.qt = 6;
        }
        jSONObject.put("launch_from", this.qt);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.vl
    public String u() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.vl
    public List<String> xj() {
        return null;
    }

    @Override // com.bytedance.embedapplog.vl
    public int xj(Cursor cursor) {
        cu.hf((Throwable) null);
        return 0;
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(ContentValues contentValues) {
        cu.hf((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(JSONObject jSONObject) {
        cu.hf((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.vl
    public vl hf(JSONObject jSONObject) {
        cu.hf((Throwable) null);
        return this;
    }
}
