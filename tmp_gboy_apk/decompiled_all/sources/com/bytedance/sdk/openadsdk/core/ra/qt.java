package com.bytedance.sdk.openadsdk.core.ra;

import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt {
    public double hf;
    public double u;
    public double w;
    public double xj;

    public qt(double d, double d2, double d3, double d4) {
        this.xj = d;
        this.hf = d2;
        this.w = d3;
        this.u = d4;
    }

    public static qt hf(qt qtVar, qt qtVar2) {
        if (qtVar == null) {
            return qtVar2;
        }
        if (qtVar2 == null) {
            return null;
        }
        double d = qtVar.xj;
        double d2 = qtVar.hf;
        double d3 = qtVar.w + d;
        double d4 = qtVar.u + d2;
        double d5 = qtVar2.xj;
        double d6 = qtVar2.hf;
        double d7 = qtVar2.w + d5;
        double d8 = qtVar2.u + d6;
        double min = Math.min(d, d5);
        double min2 = Math.min(d2, d6);
        return new qt(min, min2, Math.abs(Math.max(d3, d7) - min), Math.abs(Math.max(d4, d8) - min2));
    }

    public boolean xj(double d, double d2) {
        double d3 = this.w;
        if (d3 <= 0.0d) {
            return false;
        }
        double d4 = this.u;
        if (d4 <= 0.0d) {
            return false;
        }
        double d5 = this.xj;
        if (d <= d5 || d >= d5 + d3) {
            return false;
        }
        double d6 = this.hf;
        return d2 > d6 && d2 < d6 + d4;
    }

    public static qt xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(SQLiteMTAHelper.TABLE_POINT);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("size");
        if (optJSONArray == null || optJSONArray.length() != 2 || optJSONArray2 == null || optJSONArray2.length() != 2) {
            return null;
        }
        return new qt(optJSONArray.optDouble(0), optJSONArray.optDouble(1), optJSONArray2.optInt(0), optJSONArray2.optInt(1));
    }

    public static JSONObject xj(qt qtVar) {
        if (qtVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, qtVar.xj);
            jSONArray.put(1, qtVar.hf);
            jSONObject.put(SQLiteMTAHelper.TABLE_POINT, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, qtVar.w);
            jSONArray2.put(1, qtVar.u);
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj("xeasy", "json:" + e.getMessage());
            return null;
        }
    }

    public static double xj(qt qtVar, qt qtVar2) {
        if (qtVar == null || qtVar2 == null) {
            return 0.0d;
        }
        double d = qtVar.xj;
        double d2 = qtVar.hf;
        double d3 = qtVar.w + d;
        double d4 = qtVar.u + d2;
        double d5 = qtVar2.xj;
        double d6 = qtVar2.hf;
        double d7 = qtVar2.w + d5;
        double d8 = qtVar2.u + d6;
        double max = Math.max(d, d5);
        double max2 = Math.max(d2, d6);
        double min = Math.min(d3, d7);
        double min2 = (Math.min(d4, d8) - max2) * (min - max);
        if (d2 >= d8 || d3 <= d5 || d4 <= d6 || d >= d7) {
            return 0.0d;
        }
        return min2;
    }
}
