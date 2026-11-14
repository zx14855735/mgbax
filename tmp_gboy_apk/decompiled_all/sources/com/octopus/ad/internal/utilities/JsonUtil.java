package com.octopus.ad.internal.utilities;

import com.baidu.mobads.sdk.api.IAdInterListener;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaa0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class JsonUtil {
    public static JSONArray getJSONArray(JSONObject jSONObject, String str) {
        JSONArray jSONArray;
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONArray = jSONObject.getJSONArray(str);
        } catch (JSONException unused) {
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }

    public static boolean getJSONBoolean(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static double getJSONDouble(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0.0d;
        }
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return 0.0d;
        }
    }

    public static int getJSONInt(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONObject getJSONObjectFromArray(JSONArray jSONArray, int i) {
        if (jSONArray == null) {
            return null;
        }
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String getJSONString(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static ArrayList<String> getStringArrayList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add((String) jSONArray.get(i));
                }
                return arrayList;
            }
        } catch (ClassCastException | JSONException unused) {
        }
        return null;
    }

    public static String getStringFromArray(JSONArray jSONArray, int i) {
        if (jSONArray == null) {
            return "";
        }
        try {
            return jSONArray.getString(i);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static HashMap<String, Object> getStringObjectHashMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            HashMap<String, Object> hashMap = new HashMap<>();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static <T> String listToJson(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            if (obj instanceof String) {
                sb.append(stringToJson((String) obj));
                sb.append(",");
            } else if ((obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double)) {
                sb.append(obj);
                sb.append(",");
            } else {
                sb.append(objectToJson(obj));
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private static <T> String objectToJson(T t) {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder(declaredFields.length << 4);
        sb.append("{");
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            String name = field.getName();
            if (!name.contains("this$")) {
                String name2 = type.getName();
                if (!name2.equals("java.lang.Integer") && !name2.equals("double")) {
                    if (!name2.equals("java.util.ArrayList")) {
                        if (!name2.equals("java.lang.Float") && !name2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL) && !name2.equals("long") && !name2.equals("boolean")) {
                            if (!name2.equals("java.util.List")) {
                                if (!name2.equals("float") && !name2.equals("java.lang.Boolean") && !name2.equals("java.lang.Long") && !name2.equals("java.lang.Double")) {
                                    if (name2.equals("java.lang.String")) {
                                        sb.append("\"");
                                        sb.append(name);
                                        sb.append("\":");
                                        sb.append(stringToJson((String) field.get(t)));
                                        sb.append(",");
                                    } else {
                                        try {
                                            Object obj = field.get(t);
                                            if (obj != null) {
                                                sb.append("\"");
                                                sb.append(name);
                                                sb.append("\":");
                                                sb.append("{");
                                                sb.append(objectToJson(obj));
                                                sb.setCharAt(sb.length() - 1, '}');
                                                sb.append(",");
                                            }
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    List list = (List) field.get(t);
                    if (list != null && !list.isEmpty()) {
                        sb.append("\"");
                        sb.append(name);
                        sb.append("\":");
                        sb.append("[");
                        sb.append(listToJson(list));
                        sb.setCharAt(sb.length() - 1, ']');
                        sb.append(",");
                    }
                }
                sb.append("\"");
                sb.append(name);
                sb.append("\":");
                sb.append(field.get(t));
                sb.append(",");
            }
        }
        if (sb.length() == 1) {
            sb.append("}");
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    private static <T, V> ArrayList<T> parseArray(JSONArray jSONArray, Class<T> cls, V v) {
        aaaaaaa0.aaaaaaac aaaaaaacVar = (ArrayList<T>) new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (jSONArray.get(i) instanceof JSONObject) {
                    aaaaaaacVar.add(parseObject(jSONArray.getJSONObject(i), cls, v));
                } else {
                    aaaaaaacVar.add(jSONArray.get(i));
                }
            } catch (Exception unused) {
            }
        }
        return aaaaaaacVar;
    }

    private static <T, V> T parseObject(JSONObject jSONObject, Class<T> cls, V v) {
        T t;
        try {
            if (v == null) {
                t = cls.newInstance();
            } else {
                Constructor<?> constructor = cls.getDeclaredConstructors()[0];
                constructor.setAccessible(true);
                t = (T) constructor.newInstance(v);
            }
        } catch (Exception unused) {
            t = null;
        }
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            String name = field.getName();
            if (jSONObject.has(name)) {
                String name2 = type.getName();
                if (!name2.equals("java.lang.Integer")) {
                    if (!name2.equals("double")) {
                        if (!name2.equals("java.util.ArrayList")) {
                            if (!name2.equals("java.lang.Float")) {
                                if (!name2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                                    if (!name2.equals("long")) {
                                        if (!name2.equals("boolean")) {
                                            if (!name2.equals("java.util.List")) {
                                                if (!name2.equals("float")) {
                                                    if (!name2.equals("java.lang.Boolean")) {
                                                        if (!name2.equals("java.lang.Long")) {
                                                            if (!name2.equals("java.lang.Double")) {
                                                                if (name2.equals("java.lang.String")) {
                                                                    try {
                                                                        String string = jSONObject.getString(name);
                                                                        if (string.equals("null")) {
                                                                            string = "";
                                                                        }
                                                                        field.set(t, string);
                                                                    } catch (Exception unused2) {
                                                                        field.set(t, "");
                                                                    }
                                                                } else {
                                                                    try {
                                                                        Object obj = jSONObject.get(name);
                                                                        Class<?> cls2 = Class.forName(name2);
                                                                        if (obj instanceof JSONObject) {
                                                                            field.set(t, parseObject((JSONObject) obj, cls2, t));
                                                                        }
                                                                    } catch (Exception unused3) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        field.set(t, Boolean.valueOf(jSONObject.getBoolean(name)));
                                    }
                                    field.set(t, Long.valueOf(jSONObject.getLong(name)));
                                }
                            }
                            field.set(t, Float.valueOf(jSONObject.getString(name)));
                        }
                        Object obj2 = jSONObject.get(name);
                        Class<?> cls3 = Class.forName(field.getGenericType().toString().replace("<", "").replace(type.getName(), "").replace(">", ""));
                        if (obj2 instanceof JSONArray) {
                            field.set(t, parseArray((JSONArray) obj2, cls3, t));
                        }
                    }
                    field.set(t, Double.valueOf(jSONObject.getDouble(name)));
                }
                field.set(t, Integer.valueOf(jSONObject.getInt(name)));
            }
        }
        return t;
    }

    private static String stringToJson(String str) {
        if (str == null || str.isEmpty()) {
            return "\"\"";
        }
        StringBuilder sb = new StringBuilder((str.length() + 2) << 4);
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            sb.append(charAt == '\"' ? "\\\"" : charAt == '\\' ? "\\\\" : charAt == '/' ? "\\/" : charAt == '\b' ? "\\b" : charAt == '\f' ? "\\f" : charAt == '\n' ? "\\n" : charAt == '\r' ? "\\r" : charAt == '\t' ? "\\t" : Character.valueOf(charAt));
        }
        sb.append('\"');
        return sb.toString();
    }

    public static <T> T toBean(String str, Class<T> cls) {
        try {
            return (T) parseObject(new JSONObject(str), cls, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> String toJsonStr(T t) {
        return t == null ? "{}" : objectToJson(t);
    }

    public static boolean getJSONBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }
}
