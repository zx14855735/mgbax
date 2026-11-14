package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaae;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends JSONObject {
    public aaaaaaaa() {
    }

    public JSONObject aaaaaaa0(String str) {
        return aaaaaaaa(aaaaaaae.aaaaaaa0(str));
    }

    public JSONObject aaaaaaaa(String str) {
        Object opt = super.opt(str);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    @Override // org.json.JSONObject
    public Object get(String str) {
        return super.get(aaaaaaae.aaaaaaa0(str));
    }

    @Override // org.json.JSONObject
    public boolean getBoolean(String str) {
        return super.getBoolean(str);
    }

    @Override // org.json.JSONObject
    public double getDouble(String str) {
        return super.getDouble(str);
    }

    @Override // org.json.JSONObject
    public int getInt(String str) {
        return super.getInt(str);
    }

    @Override // org.json.JSONObject
    public JSONArray getJSONArray(String str) {
        return super.getJSONArray(str);
    }

    @Override // org.json.JSONObject
    public JSONObject getJSONObject(String str) {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw aaaaaaaa(str, obj, "JSONObject");
    }

    @Override // org.json.JSONObject
    public long getLong(String str) {
        return super.getLong(str);
    }

    @Override // org.json.JSONObject
    public String getString(String str) {
        return super.getString(str);
    }

    @Override // org.json.JSONObject
    public boolean has(String str) {
        return super.has(aaaaaaae.aaaaaaa0(str));
    }

    @Override // org.json.JSONObject
    public boolean isNull(String str) {
        return super.isNull(aaaaaaae.aaaaaaa0(str));
    }

    @Override // org.json.JSONObject
    public Object opt(String str) {
        return super.opt(aaaaaaae.aaaaaaa0(str));
    }

    @Override // org.json.JSONObject
    public boolean optBoolean(String str) {
        return super.optBoolean(str);
    }

    @Override // org.json.JSONObject
    public double optDouble(String str) {
        return super.optDouble(str);
    }

    @Override // org.json.JSONObject
    public int optInt(String str) {
        return super.optInt(str);
    }

    @Override // org.json.JSONObject
    public JSONArray optJSONArray(String str) {
        return super.optJSONArray(str);
    }

    @Override // org.json.JSONObject
    public long optLong(String str) {
        return super.optLong(str);
    }

    @Override // org.json.JSONObject
    public String optString(String str) {
        return super.optString(str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        return super.put(aaaaaaae.aaaaaaa0(str), z);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        return super.remove(aaaaaaae.aaaaaaa0(str));
    }

    @Override // org.json.JSONObject
    public JSONArray toJSONArray(JSONArray jSONArray) {
        return super.toJSONArray(jSONArray);
    }

    public aaaaaaaa(Map map) {
        super(map);
    }

    @Override // org.json.JSONObject
    public boolean optBoolean(String str, boolean z) {
        return super.optBoolean(str, z);
    }

    @Override // org.json.JSONObject
    public double optDouble(String str, double d) {
        return super.optDouble(str, d);
    }

    @Override // org.json.JSONObject
    public int optInt(String str, int i) {
        return super.optInt(str, i);
    }

    @Override // org.json.JSONObject
    public aaaaaaaa optJSONObject(String str) {
        Object opt = opt(str);
        if (opt == null) {
            return null;
        }
        try {
            return new aaaaaaaa(opt.toString());
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // org.json.JSONObject
    public long optLong(String str, long j) {
        return super.optLong(str, j);
    }

    @Override // org.json.JSONObject
    public String optString(String str, String str2) {
        return super.optString(str, str2);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d) {
        return super.put(aaaaaaae.aaaaaaa0(str), d);
    }

    public aaaaaaaa(String str) {
        super(str);
    }

    public static JSONException aaaaaaaa(Object obj, Object obj2, String str) {
        if (obj2 == null) {
            throw new JSONException("Value at " + obj + " is null.");
        }
        throw new JSONException("Value " + obj2 + " at " + obj + " of type " + obj2.getClass().getName() + " cannot be converted to " + str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i) {
        return super.put(aaaaaaae.aaaaaaa0(str), i);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j) {
        return super.put(aaaaaaae.aaaaaaa0(str), j);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) {
        return super.put(aaaaaaae.aaaaaaa0(str), obj);
    }
}
