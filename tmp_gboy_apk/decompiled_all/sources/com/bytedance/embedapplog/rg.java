package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class rg extends vl {
    public boolean am;
    public String e;
    public String g;
    public boolean jk;

    /* renamed from: pl, reason: collision with root package name */
    public int f10107pl;
    public String qt;
    public boolean v;
    public String yo;
    public int zg;

    public rg(boolean z) {
        this.jk = z;
    }

    @Override // com.bytedance.embedapplog.vl
    public String f() {
        return this.am ? "bg" : "fg";
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
        boolean z = this.am;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.p);
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("ab_sdk_version", this.f);
        }
        if (!TextUtils.isEmpty(this.qt)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.qt);
        }
        if (this.zg == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.jk);
        jSONObject.put("is_background", !this.jk);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.vl
    public String u() {
        return "launch";
    }

    @Override // com.bytedance.embedapplog.vl
    public List<String> xj() {
        List<String> xj = super.xj();
        ArrayList arrayList = new ArrayList(xj.size());
        arrayList.addAll(xj);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer", ArticleInfo.PAGE_TITLE, "varchar", "page_key", "varchar", "resume_from_background", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.vl
    public int xj(Cursor cursor) {
        int xj = super.xj(cursor);
        this.g = cursor.getString(xj);
        this.f10107pl = cursor.getInt(xj + 1);
        this.qt = cursor.getString(xj + 2);
        this.zg = cursor.getInt(xj + 3);
        this.e = cursor.getString(xj + 4);
        int i = xj + 6;
        this.yo = cursor.getString(xj + 5);
        int i2 = xj + 7;
        this.v = cursor.getInt(i) == 0;
        return i2;
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(ContentValues contentValues) {
        super.xj(contentValues);
        contentValues.put("ver_name", this.g);
        contentValues.put("ver_code", Integer.valueOf(this.f10107pl));
        contentValues.put("last_session", this.qt);
        contentValues.put("is_first_time", Integer.valueOf(this.zg));
        contentValues.put(ArticleInfo.PAGE_TITLE, this.e);
        contentValues.put("page_key", this.yo);
        contentValues.put("resume_from_background", Integer.valueOf(this.v ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(JSONObject jSONObject) {
        cu.hf((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.vl
    public vl hf(JSONObject jSONObject) {
        cu.hf((Throwable) null);
        return null;
    }
}
