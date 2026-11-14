package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ft extends vl {
    private boolean am;
    protected String g;

    /* renamed from: pl, reason: collision with root package name */
    protected String f10104pl;

    public ft(String str, boolean z, String str2) {
        this.g = str;
        this.am = z;
        this.f10104pl = str2;
        this.tf = 0;
    }

    @Override // com.bytedance.embedapplog.vl
    public String d() {
        return this.f10104pl;
    }

    @Override // com.bytedance.embedapplog.vl
    public String f() {
        return this.g;
    }

    @Override // com.bytedance.embedapplog.vl
    public JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.hf);
        jSONObject.put("tea_event_index", this.w);
        jSONObject.put("session_id", this.u);
        long j = this.kd;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.y) ? JSONObject.NULL : this.y);
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.put("ssid", this.c);
        }
        jSONObject.put("event", this.g);
        if (this.am) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.f10104pl)) {
            jSONObject.put("params", new JSONObject(this.f10104pl));
        }
        jSONObject.put("datetime", this.p);
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("ab_sdk_version", this.f);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.vl
    public String u() {
        return "eventv3";
    }

    @Override // com.bytedance.embedapplog.vl
    public List<String> xj() {
        List<String> xj = super.xj();
        ArrayList arrayList = new ArrayList(xj.size());
        arrayList.addAll(xj);
        arrayList.addAll(Arrays.asList("event", "varchar", "params", "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.vl
    public int xj(Cursor cursor) {
        int xj = super.xj(cursor);
        this.g = cursor.getString(xj);
        int i = xj + 2;
        this.f10104pl = cursor.getString(xj + 1);
        int i2 = xj + 3;
        this.am = cursor.getInt(i) == 1;
        return i2;
    }

    public ft(String str, boolean z, String str2, int i) {
        this.g = str;
        this.am = z;
        this.f10104pl = str2;
        this.tf = i;
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(ContentValues contentValues) {
        super.xj(contentValues);
        contentValues.put("event", this.g);
        contentValues.put("params", this.f10104pl);
        contentValues.put("is_bav", Integer.valueOf(this.am ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(JSONObject jSONObject) {
        super.xj(jSONObject);
        jSONObject.put("event", this.g);
        jSONObject.put("params", this.f10104pl);
        jSONObject.put("is_bav", this.am);
    }

    @Override // com.bytedance.embedapplog.vl
    public vl hf(JSONObject jSONObject) {
        super.hf(jSONObject);
        this.g = jSONObject.optString("event", null);
        this.f10104pl = jSONObject.optString("params", null);
        this.am = jSONObject.optBoolean("is_bav", false);
        return this;
    }
}
