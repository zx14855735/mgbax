package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.embedapplog.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.fl.saas.base.cache.DatabaseHelper;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class t extends vl {
    public int am;
    private JSONObject dk;
    JSONArray e;
    int g;
    private JSONArray ht;
    JSONArray jk;

    /* renamed from: pl, reason: collision with root package name */
    public byte[] f10109pl;
    long pz;
    JSONArray qt;
    private da ra;
    rg v;
    long yo;
    long zg;

    @Override // com.bytedance.embedapplog.vl
    public String f() {
        return String.valueOf(this.xj);
    }

    @Override // com.bytedance.embedapplog.vl
    public JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.dk);
        jSONObject.put("time_sync", gj.xj);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.v != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.v.y());
            jSONObject.put("launch", jSONArray);
        }
        da daVar = this.ra;
        int i = 0;
        if (daVar != null) {
            JSONObject y = daVar.y();
            JSONArray jSONArray2 = this.ht;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (i2 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.ht.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt(MediationConstant.EXTRA_DURATION, i) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i3 = length;
                long optLong = jSONObject2.optLong("local_time_ms", 0L);
                if (optLong > j) {
                    y.put("$page_title", jSONObject3.optString(ArticleInfo.PAGE_TITLE, ""));
                    y.put("$page_key", jSONObject3.optString("page_key", ""));
                    j = optLong;
                }
                i2++;
                length = i3;
                i = 0;
            }
            if (length > 0) {
                y.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(y);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.qt;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.qt);
        }
        JSONArray jSONArray7 = this.ht;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.e;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.e);
        }
        JSONArray jSONArray9 = this.jk;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.jk);
        }
        StringBuilder sb = new StringBuilder("pack {ts:");
        sb.append(this.hf);
        sb.append(", la:");
        Object obj = this.v;
        Object obj2 = Constants.FAIL;
        if (obj == null) {
            obj = Constants.FAIL;
        }
        sb.append(obj);
        sb.append(", te:");
        da daVar2 = this.ra;
        if (daVar2 != null) {
            obj2 = daVar2;
        }
        sb.append(obj2);
        sb.append(", p:");
        sb.append(length3);
        sb.append(", v1:");
        sb.append(length2);
        sb.append(", v3:");
        sb.append(length4);
        sb.append(", m:");
        sb.append(length5);
        cu.xj(sb.toString());
        return jSONObject;
    }

    public byte[] tf() {
        this.f10109pl = null;
        try {
            byte[] xj = oa.xj(y().toString());
            this.f10109pl = xj;
            return xj;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                h.hf[] hfVarArr = h.w;
                if (i >= hfVarArr.length) {
                    throw new RuntimeException(sb.toString(), e);
                }
                h.hf hfVar = hfVarArr[i];
                if (hfVar != null) {
                    sb.append(hfVar.toString());
                    sb.append(";");
                }
                i++;
            }
        }
    }

    @Override // com.bytedance.embedapplog.vl
    public String u() {
        return "pack";
    }

    public void xj(JSONObject jSONObject, rg rgVar, da daVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        xj(0L);
        this.dk = jSONObject;
        this.v = rgVar;
        this.ra = daVar;
        this.ht = jSONArray;
        this.qt = jSONArrayArr[0];
        this.zg = jArr[0];
        this.e = jSONArrayArr[1];
        this.yo = jArr[1];
        this.jk = jSONArrayArr[2];
        this.pz = jArr[2];
        this.tf = i;
    }

    @Override // com.bytedance.embedapplog.vl
    public List<String> xj() {
        return Arrays.asList(DatabaseHelper.COLUMN_ID, "integer primary key autoincrement", "local_time_ms", "integer", "_data", "blob", "_fail", "integer", "event_type", "integer");
    }

    @Override // com.bytedance.embedapplog.vl
    public int xj(Cursor cursor) {
        this.xj = cursor.getLong(0);
        this.hf = cursor.getLong(1);
        this.f10109pl = cursor.getBlob(2);
        this.g = cursor.getInt(3);
        this.tf = cursor.getInt(4);
        this.u = "";
        this.dk = null;
        this.v = null;
        this.ra = null;
        this.ht = null;
        this.qt = null;
        this.e = null;
        this.jk = null;
        return 5;
    }

    @Override // com.bytedance.embedapplog.vl
    public void xj(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.hf));
        contentValues.put("_data", tf());
        contentValues.put("event_type", Integer.valueOf(this.tf));
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
