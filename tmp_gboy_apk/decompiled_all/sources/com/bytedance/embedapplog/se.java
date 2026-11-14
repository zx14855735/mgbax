package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class se extends vl {
    private String g;

    /* renamed from: pl, reason: collision with root package name */
    private String f10108pl;

    public se(String str, JSONObject jSONObject) {
        this.g = str;
        this.f10108pl = jSONObject.toString();
        this.tf = 0;
    }

    @Override // com.bytedance.embedapplog.vl
    public String d() {
        return this.f10108pl;
    }

    @Override // com.bytedance.embedapplog.vl
    public String f() {
        return "param:" + this.f10108pl + " logType:" + this.g;
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
        jSONObject.put("log_type", this.g);
        try {
            JSONObject jSONObject2 = new JSONObject(this.f10108pl);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    cu.hf("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            cu.w("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.vl
    public String u() {
        return "event_misc";
    }

    @Override // com.bytedance.embedapplog.vl
    public List<String> xj() {
        List<String> xj = super.xj();
        ArrayList arrayList = new ArrayList(xj.size());
        arrayList.addAll(xj);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.vl
    public int xj(Cursor cursor) {
        int xj = super.xj(cursor);
        int i = xj + 1;
        this.f10108pl = cursor.getString(xj);
        int i2 = xj + 2;
        this.g = cursor.getString(i);
        return i2;
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(ContentValues contentValues) {
        super.xj(contentValues);
        contentValues.put("params", this.f10108pl);
        contentValues.put("log_type", this.g);
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(JSONObject jSONObject) {
        super.xj(jSONObject);
        jSONObject.put("params", this.f10108pl);
        jSONObject.put("log_type", this.g);
    }

    @Override // com.bytedance.embedapplog.vl
    public vl hf(JSONObject jSONObject) {
        super.hf(jSONObject);
        this.f10108pl = jSONObject.optString("params", null);
        this.g = jSONObject.optString("log_type", null);
        return this;
    }
}
