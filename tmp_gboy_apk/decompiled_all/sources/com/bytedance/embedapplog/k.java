package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class k extends vl {
    public String am;
    public String e;
    public String g;
    public String jk;

    /* renamed from: pl, reason: collision with root package name */
    public long f10105pl;
    public String qt;
    public int v;
    public String yo;
    public String zg;

    private JSONObject pl() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.am);
        jSONObject.put("refer_page_key", this.g);
        jSONObject.put("is_back", this.v);
        jSONObject.put(MediationConstant.EXTRA_DURATION, this.f10105pl);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.qt);
        jSONObject.put("refer_page_title", this.zg);
        jSONObject.put("page_path", this.e);
        jSONObject.put("referrer_page_path", this.yo);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.vl
    public String f() {
        return this.am + ", " + this.f10105pl;
    }

    @Override // com.bytedance.embedapplog.vl
    public vl hf(JSONObject jSONObject) {
        super.hf(jSONObject);
        this.am = jSONObject.optString("page_key", null);
        this.g = jSONObject.optString("refer_page_key", null);
        this.f10105pl = jSONObject.optLong(MediationConstant.EXTRA_DURATION, 0L);
        this.v = jSONObject.optInt("is_back", 0);
        this.qt = jSONObject.optString(ArticleInfo.PAGE_TITLE, null);
        this.zg = jSONObject.optString("refer_page_title", null);
        this.e = jSONObject.optString("page_path", null);
        this.yo = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    public boolean p() {
        return this.am.contains(":");
    }

    public boolean tf() {
        return this.f10105pl == -1;
    }

    @Override // com.bytedance.embedapplog.vl
    public String u() {
        return "page";
    }

    @Override // com.bytedance.embedapplog.vl
    public List<String> xj() {
        List<String> xj = super.xj();
        ArrayList arrayList = new ArrayList(xj.size());
        arrayList.addAll(xj);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", MediationConstant.EXTRA_DURATION, "integer", "is_back", "integer", "last_session", "varchar", ArticleInfo.PAGE_TITLE, "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.vl
    public int xj(Cursor cursor) {
        int xj = super.xj(cursor);
        this.am = cursor.getString(xj);
        this.g = cursor.getString(xj + 1);
        this.f10105pl = cursor.getLong(xj + 2);
        this.v = cursor.getInt(xj + 3);
        this.jk = cursor.getString(xj + 4);
        this.qt = cursor.getString(xj + 5);
        this.zg = cursor.getString(xj + 6);
        int i = xj + 8;
        this.e = cursor.getString(xj + 7);
        int i2 = xj + 9;
        this.yo = cursor.getString(i);
        return i2;
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", pl());
        jSONObject.put("datetime", this.p);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(ContentValues contentValues) {
        super.xj(contentValues);
        contentValues.put("page_key", this.am);
        contentValues.put("refer_page_key", this.g);
        contentValues.put(MediationConstant.EXTRA_DURATION, Long.valueOf(this.f10105pl));
        contentValues.put("is_back", Integer.valueOf(this.v));
        contentValues.put("last_session", this.jk);
        contentValues.put(ArticleInfo.PAGE_TITLE, this.qt);
        contentValues.put("refer_page_title", this.zg);
        contentValues.put("page_path", this.e);
        contentValues.put("referrer_page_path", this.yo);
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(JSONObject jSONObject) {
        super.xj(jSONObject);
        jSONObject.put("page_key", this.am);
        jSONObject.put("refer_page_key", this.g);
        jSONObject.put(MediationConstant.EXTRA_DURATION, this.f10105pl);
        jSONObject.put("is_back", this.v);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.qt);
        jSONObject.put("refer_page_title", this.zg);
        jSONObject.put("page_path", this.e);
        jSONObject.put("referrer_page_path", this.yo);
    }
}
