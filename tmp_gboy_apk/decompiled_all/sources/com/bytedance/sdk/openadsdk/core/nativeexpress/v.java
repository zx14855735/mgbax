package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class v {
    private Map<String, xj> xj;

    public static v w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        v vVar = new v();
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null && optJSONArray.length() == 2) {
                    hashMap.put(next, new xj(optJSONArray.optInt(0), optJSONArray.optInt(1)));
                }
            }
            vVar.xj(hashMap);
            return vVar;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return vVar;
        }
    }

    public int hf(String str) {
        int xj2 = xj(false);
        Map<String, xj> map = this.xj;
        if (map != null && map.containsKey(str)) {
            xj xjVar = this.xj.get(str);
            xj2 = xjVar != null ? xj2 + xjVar.hf() : xj2 + 5000;
        }
        return xj2 + 5000;
    }

    public String toString() {
        if (this.xj == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, xj> entry : this.xj.entrySet()) {
            xj value = entry.getValue();
            JSONArray jSONArray = new JSONArray();
            if (value != null) {
                jSONArray.put(value.xj());
                jSONArray.put(value.hf());
                try {
                    jSONObject.put(entry.getKey(), jSONArray);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        }
        return jSONObject.toString();
    }

    public void xj(Map<String, xj> map) {
        this.xj = map;
    }

    public int xj(String str) {
        int xj2 = xj(true);
        Map<String, xj> map = this.xj;
        if (map != null && map.containsKey(str)) {
            xj xjVar = this.xj.get(str);
            xj2 = xjVar != null ? xj2 + xjVar.xj() : xj2 + 5000;
        }
        return xj2 + 5000;
    }

    public static class xj {
        private int hf;
        private int xj;

        public xj(int i, int i2) {
            this.xj = i;
            this.hf = i2;
        }

        public int hf() {
            return this.hf;
        }

        public int xj() {
            return this.xj;
        }

        public xj() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078 A[Catch: JSONException -> 0x0051, NumberFormatException -> 0x0054, TryCatch #4 {NumberFormatException -> 0x0054, JSONException -> 0x0051, blocks: (B:23:0x0048, B:26:0x0059, B:29:0x006c, B:31:0x0078, B:32:0x0081, B:34:0x00a6, B:37:0x00bb, B:38:0x00c4, B:41:0x00af), top: B:22:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6 A[Catch: JSONException -> 0x0051, NumberFormatException -> 0x0054, TryCatch #4 {NumberFormatException -> 0x0054, JSONException -> 0x0051, blocks: (B:23:0x0048, B:26:0x0059, B:29:0x006c, B:31:0x0078, B:32:0x0081, B:34:0x00a6, B:37:0x00bb, B:38:0x00c4, B:41:0x00af), top: B:22:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb A[Catch: JSONException -> 0x0051, NumberFormatException -> 0x0054, TryCatch #4 {NumberFormatException -> 0x0054, JSONException -> 0x0051, blocks: (B:23:0x0048, B:26:0x0059, B:29:0x006c, B:31:0x0078, B:32:0x0081, B:34:0x00a6, B:37:0x00bb, B:38:0x00c4, B:41:0x00af), top: B:22:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af A[Catch: JSONException -> 0x0051, NumberFormatException -> 0x0054, TryCatch #4 {NumberFormatException -> 0x0054, JSONException -> 0x0051, blocks: (B:23:0x0048, B:26:0x0059, B:29:0x006c, B:31:0x0078, B:32:0x0081, B:34:0x00a6, B:37:0x00bb, B:38:0x00c4, B:41:0x00af), top: B:22:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int xj(boolean r10) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.v.xj(boolean):int");
    }
}
