package com.bytedance.sdk.openadsdk.tools;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fl.saas.base.cache.DatabaseHelper;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static boolean hf = false;
    private static long u = 0;
    private static Map<Integer, String> w = null;
    private static String xj = "SettingRitRepertoryImpl";

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    public static void hf() {
        hf = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        if (0 == 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.Map<java.lang.Integer, java.lang.String> u() {
        /*
            java.lang.String r0 = "value"
            java.lang.String r1 = "_id"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.pz.getContext()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4e
            java.lang.String r5 = "setting_global_info"
            java.lang.String[] r6 = new java.lang.String[]{r1, r0}     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4e
            r10 = 0
            r11 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r3 = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4e
            if (r3 != 0) goto L25
            if (r3 == 0) goto L59
            r3.close()
            return r2
        L25:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4e
            if (r4 == 0) goto L4a
            int r4 = r3.getColumnIndex(r1)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            int r4 = r3.getInt(r4)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            int r5 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            if (r5 != 0) goto L46
            java.lang.String r5 = ""
            goto L46
        L44:
            r0 = move-exception
            goto L50
        L46:
            r2.put(r4, r5)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L44
            goto L25
        L4a:
            r3.close()
            goto L59
        L4e:
            goto L56
        L50:
            if (r3 == 0) goto L55
            r3.close()
        L55:
            throw r0
        L56:
            if (r3 == 0) goto L59
            goto L4a
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.hf.u():java.util.Map");
    }

    public static String w() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT,preview_ads TEXT)";
    }

    public static boolean xj() {
        return hf;
    }

    public static JSONObject hf(String str) {
        int columnIndex;
        if (!xj()) {
            return null;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (query == null || query.getCount() <= 0) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        try {
            String string = (!query.moveToNext() || (columnIndex = query.getColumnIndex("config")) < 0) ? "" : query.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(com.bytedance.sdk.component.utils.xj.w(string));
            }
        } finally {
            try {
                query.close();
                return null;
            } finally {
                try {
                    query.close();
                } catch (Throwable unused) {
                }
            }
        }
        try {
            query.close();
        } catch (Throwable unused2) {
        }
        return null;
    }

    public static JSONObject w(String str) {
        int columnIndex;
        if (!xj()) {
            return null;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (query == null || query.getCount() <= 0) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        try {
            String string = (!query.moveToNext() || (columnIndex = query.getColumnIndex("preview_ads")) < 0) ? "" : query.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(com.bytedance.sdk.component.utils.xj.w(string));
            }
        } finally {
            try {
                query.close();
                return null;
            } finally {
                try {
                    query.close();
                } catch (Throwable unused) {
                }
            }
        }
        try {
            query.close();
        } catch (Throwable unused2) {
        }
        return null;
    }

    public static String xj(int i, String str) {
        if (w == null || System.currentTimeMillis() - u > 2000) {
            u = System.currentTimeMillis();
            w = u();
        }
        Map<Integer, String> map = w;
        if (map == null || map.containsKey(Integer.valueOf(i))) {
            try {
                String w2 = com.bytedance.sdk.component.utils.xj.w(map.get(Integer.valueOf(i)));
                return "null".equals(w2) ? "" : w2;
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static Map<String, String> xj(String str) {
        JSONObject hf2 = hf(str);
        if (hf2 == null) {
            return null;
        }
        String optString = hf2.optString(n.m);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            try {
                JSONObject optJSONObject = new JSONObject(optString).optJSONObject("headers");
                if (optJSONObject == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, optJSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception unused) {
                return hashMap;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0026 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean u(java.lang.String r8) {
        /*
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.pz.getContext()
            java.lang.String[] r4 = new java.lang.String[]{r8}
            r6 = 0
            r7 = 0
            java.lang.String r1 = "setting_rit"
            r2 = 0
            java.lang.String r3 = "rit=?"
            r5 = 0
            android.database.Cursor r8 = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r8 == 0) goto L23
            int r0 = r8.getCount()     // Catch: java.lang.Throwable -> L1e
            if (r0 <= 0) goto L23
            r0 = 1
            goto L24
        L1e:
            r0 = move-exception
            r8.close()
            throw r0
        L23:
            r0 = 0
        L24:
            if (r8 == 0) goto L29
            r8.close()
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.hf.u(java.lang.String):boolean");
    }

    public static void hf(JSONObject jSONObject, String str) {
        JSONObject w2;
        if ((jSONObject == null && TextUtils.isEmpty(str)) || (w2 = w(str)) == null) {
            return;
        }
        if (w2.has("image_mode")) {
            jSONObject.put("image_mode", w2.optString("image_mode"));
        }
        if (w2.has("preview_extra")) {
            jSONObject.put("preview_extra", w2.optString("preview_extra"));
        }
        if (w2.has("preview_ads")) {
            jSONObject.put("preview_ads", w2.optJSONObject("preview_ads"));
        }
    }

    public static void w(int i, String str) {
        if (xj()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i)}, null, null, null);
            boolean z = query != null && query.getCount() > 0;
            if (query != null) {
                try {
                    query.close();
                } catch (Exception unused) {
                }
            }
            String hf2 = com.bytedance.sdk.component.utils.xj.hf(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.COLUMN_ID, Integer.valueOf(i));
            contentValues.put("value", hf2);
            if (z) {
                com.bytedance.sdk.openadsdk.core.multipro.xj.xj.update(pz.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i)});
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.xj.xj.insert(pz.getContext(), "setting_global_info", contentValues);
            }
        }
    }

    public static void xj(JSONObject jSONObject, String str) {
        JSONObject hf2 = hf(str);
        if (hf2 == null) {
            return;
        }
        String optString = hf2.optString("aid");
        String optString2 = hf2.optString("cid");
        String optString3 = hf2.optString(n.m);
        if (!TextUtils.isEmpty(optString)) {
            jSONObject.put(MediationConstant.EXTRA_ADID, optString);
        }
        if (!TextUtils.isEmpty(optString2)) {
            jSONObject.put("creative_id", optString2);
        }
        if (TextUtils.isEmpty(optString3)) {
            return;
        }
        jSONObject.put(n.m, optString3);
    }

    public static void hf(int i, String str) {
        if (xj()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            try {
                com.bytedance.sdk.openadsdk.core.multipro.xj.xj.xj(pz.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i + ", '" + com.bytedance.sdk.component.utils.xj.hf(str) + "')", "setting_base_info");
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public static void xj(String str, JSONObject jSONObject) {
        if (!xj() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        boolean z = query != null && query.getCount() > 0;
        if (query != null) {
            try {
                query.close();
            } catch (Throwable unused) {
            }
        }
        JSONObject xj2 = com.bytedance.sdk.component.utils.xj.xj(jSONObject);
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put("value", xj2.toString());
        if (z) {
            com.bytedance.sdk.openadsdk.core.multipro.xj.xj.update(pz.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.xj.xj.insert(pz.getContext(), "setting_rit", contentValues);
        }
    }

    public static void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (xj()) {
            String u2 = hfVar.u();
            if (u(u2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", hfVar.y());
                    jSONObject.put("img_height", hfVar.c());
                    jSONObject.put("express_width", hfVar.f());
                    jSONObject.put("express_height", hfVar.d());
                    jSONObject.put(PointParamKey.AD_COUNT, hfVar.pl());
                } catch (JSONException e) {
                    pl.xj(e);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", u2);
                contentValues.put("slot", com.bytedance.sdk.component.utils.xj.hf(jSONObject.toString()));
                com.bytedance.sdk.openadsdk.core.multipro.xj.xj.update(pz.getContext(), "setting_rit", contentValues, "rit=?", new String[]{u2});
            }
        }
    }
}
