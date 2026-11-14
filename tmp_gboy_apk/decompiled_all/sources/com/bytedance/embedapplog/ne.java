package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ne extends vl {
    public String am;
    long e;
    public String g;

    /* renamed from: pl, reason: collision with root package name */
    public String f10106pl;
    public String qt;
    public long zg;

    @Override // com.bytedance.embedapplog.vl
    public String d() {
        return this.qt;
    }

    @Override // com.bytedance.embedapplog.vl
    public String f() {
        return this.g + ", " + this.am;
    }

    @Override // com.bytedance.embedapplog.vl
    public vl hf(JSONObject jSONObject) {
        super.hf(jSONObject);
        this.w = jSONObject.optLong("tea_event_index", 0L);
        this.f10106pl = jSONObject.optString(PointParamKey.CATEGORY, null);
        this.g = jSONObject.optString("tag", null);
        this.zg = jSONObject.optLong("value", 0L);
        this.e = jSONObject.optLong("ext_value", 0L);
        this.qt = jSONObject.optString("params", null);
        this.am = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.vl
    public String u() {
        return "event";
    }

    @Override // com.bytedance.embedapplog.vl
    public List<String> xj() {
        List<String> xj = super.xj();
        ArrayList arrayList = new ArrayList(xj.size());
        arrayList.addAll(xj);
        arrayList.addAll(Arrays.asList(PointParamKey.CATEGORY, "varchar", "tag", "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.vl
    public int xj(Cursor cursor) {
        int xj = super.xj(cursor);
        this.f10106pl = cursor.getString(xj);
        this.g = cursor.getString(xj + 1);
        this.zg = cursor.getLong(xj + 2);
        this.e = cursor.getLong(xj + 3);
        int i = xj + 5;
        this.qt = cursor.getString(xj + 4);
        int i2 = xj + 6;
        this.am = cursor.getString(i);
        return i2;
    }

    @Override // com.bytedance.embedapplog.vl
    public JSONObject hf() {
        JSONObject jSONObject = !TextUtils.isEmpty(this.qt) ? new JSONObject(this.qt) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
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
        jSONObject.put(PointParamKey.CATEGORY, this.f10106pl);
        jSONObject.put("tag", this.g);
        jSONObject.put("value", this.zg);
        jSONObject.put("ext_value", this.e);
        jSONObject.put("label", this.am);
        jSONObject.put("datetime", this.p);
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("ab_sdk_version", this.f);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(ContentValues contentValues) {
        super.xj(contentValues);
        contentValues.put(PointParamKey.CATEGORY, this.f10106pl);
        contentValues.put("tag", this.g);
        contentValues.put("value", Long.valueOf(this.zg));
        contentValues.put("ext_value", Long.valueOf(this.e));
        contentValues.put("params", this.qt);
        contentValues.put("label", this.am);
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(JSONObject jSONObject) {
        super.xj(jSONObject);
        jSONObject.put("tea_event_index", this.w);
        jSONObject.put(PointParamKey.CATEGORY, this.f10106pl);
        jSONObject.put("tag", this.g);
        jSONObject.put("value", this.zg);
        jSONObject.put("ext_value", this.e);
        jSONObject.put("params", this.qt);
        jSONObject.put("label", this.am);
    }
}
