package com.sigmob.sdk.base.utils;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import RD2OKB.A4TApA;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.logger.SigmobLogger;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13217a = "g";

    public static <T> T a(String str, Class<T> cls) {
        if (cls == null || str == null || str.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (d(jSONObject)) {
            return null;
        }
        return (T) a(jSONObject, cls);
    }

    public static Map<String, Object> b(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        HashMap hashMap = new HashMap();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Field field : cls.getDeclaredFields()) {
            try {
                String name = field.getName();
                String simpleName = field.getType().getSimpleName();
                String a2 = a(name, "get");
                if (a(declaredMethods, a2)) {
                    obj2 = cls.getMethod(a2, new Class[0]).invoke(obj, new Object[0]);
                } else {
                    boolean isAccessible = field.isAccessible();
                    if (!isAccessible) {
                        field.setAccessible(true);
                    }
                    Object obj3 = field.get(obj);
                    if (!isAccessible) {
                        field.setAccessible(false);
                    }
                    obj2 = obj3;
                }
                if (obj2 != null) {
                    if ("Date".equals(simpleName)) {
                        obj2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format((Date) obj2);
                    }
                    hashMap.put(field.getName(), obj2);
                }
            } catch (Exception e) {
                SigmobLogger.e(f13217a, CtFAbx.AZOQYO(e, new StringBuilder("beanToMap: error = ")), new Object[0]);
            }
        }
        return hashMap;
    }

    public static JSONObject c(Object obj) {
        try {
            String a2 = a(obj);
            SigmobLogger.d(f13217a, "bean2JSONObject: json = " + a2, new Object[0]);
            return new JSONObject(a2);
        } catch (JSONException e) {
            SigmobLogger.e(f13217a, "bean2JSONObject: error = " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static boolean d(Class<?> cls) {
        return cls != null && cls.isArray();
    }

    public static boolean e(Class<?> cls) {
        return cls != null && Collection.class.isAssignableFrom(cls);
    }

    public static boolean f(Class<?> cls) {
        return cls != null && Map.class.isAssignableFrom(cls);
    }

    public static boolean g(Class<?> cls) {
        return cls != null && List.class.isAssignableFrom(cls);
    }

    private static <T> T h(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isInterface()) {
            try {
                return cls.newInstance();
            } catch (Exception unused) {
                throw new JSONException("Unknown class type: " + cls);
            }
        }
        if (cls.equals(Map.class)) {
            return (T) new HashMap();
        }
        if (cls.equals(List.class)) {
            return (T) new ArrayList();
        }
        if (cls.equals(Set.class)) {
            return (T) new HashSet();
        }
        throw new JSONException("Unknown interface: " + cls);
    }

    private static boolean i(Class<?> cls) {
        return a(cls) || b(cls) || c(cls);
    }

    private static boolean j(Class<?> cls) {
        return (cls == null || i(cls) || d(cls) || e(cls) || f(cls)) ? false : true;
    }

    public static <T> T a(JSONObject jSONObject, Class<T> cls) {
        T t;
        if (cls == null || d(jSONObject) || (t = (T) h(cls)) == null) {
            return null;
        }
        if (f(cls)) {
            a(t, jSONObject);
            return t;
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Field field : cls.getDeclaredFields()) {
            String a2 = a(field.getName(), "set");
            if (a(declaredMethods, a2)) {
                try {
                    a(t, cls.getMethod(a2, field.getType()), field, jSONObject);
                } catch (Exception e) {
                    SigmobLogger.e(f13217a, CtFAbx.AZOQYO(e, new StringBuilder("parseObject: error = ")), new Object[0]);
                }
            } else {
                field.setAccessible(true);
                if (jSONObject.opt(field.getName()) != null) {
                    a(t, field, jSONObject);
                }
            }
        }
        return t;
    }

    private static void c(JSONStringer jSONStringer, Object obj) {
        Object obj2;
        try {
            jSONStringer.object();
            Class<?> cls = obj.getClass();
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Field field : cls.getDeclaredFields()) {
                try {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        String simpleName = field.getType().getSimpleName();
                        String a2 = a(name, "get");
                        if (a(declaredMethods, a2)) {
                            obj2 = cls.getMethod(a2, new Class[0]).invoke(obj, new Object[0]);
                        } else {
                            boolean isAccessible = field.isAccessible();
                            if (!isAccessible) {
                                field.setAccessible(true);
                            }
                            Object obj3 = field.get(obj);
                            if (!isAccessible) {
                                field.setAccessible(false);
                            }
                            obj2 = obj3;
                        }
                        if (obj2 != null) {
                            if ("Date".equals(simpleName)) {
                                obj2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format((Date) obj2);
                            }
                            jSONStringer.key(field.getName());
                            a(jSONStringer, obj2);
                        }
                    }
                } catch (Exception e) {
                    SigmobLogger.e(f13217a, "serializeObject: error = " + e.getMessage(), new Object[0]);
                }
            }
            jSONStringer.endObject();
        } catch (Exception e2) {
            SigmobLogger.e(f13217a, CtFAbx.AZOQYO(e2, new StringBuilder("serializeObject: error = ")), new Object[0]);
        }
    }

    private static boolean d(Object obj) {
        return obj instanceof JSONObject ? JSONObject.NULL.equals(obj) : obj == null;
    }

    private static void b(JSONStringer jSONStringer, Object obj) {
        try {
            jSONStringer.array();
            for (int i = 0; i < Array.getLength(obj); i++) {
                a(jSONStringer, Array.get(obj, i));
            }
            jSONStringer.endArray();
        } catch (Exception e) {
            SigmobLogger.e(f13217a, CtFAbx.AZOQYO(e, new StringBuilder("serializeArray: error = ")), new Object[0]);
        }
    }

    public static String a(Object obj) {
        JSONStringer jSONStringer = new JSONStringer();
        a(jSONStringer, obj);
        return jSONStringer.toString();
    }

    public static boolean c(Class<?> cls) {
        if (cls != null) {
            return String.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls);
        }
        return false;
    }

    public static String a(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str2);
        A4TApA2.append(str.substring(0, 1).toUpperCase());
        A4TApA2.append(str.substring(1));
        return A4TApA2.toString();
    }

    public static boolean b(Class<?> cls) {
        if (cls != null) {
            return Byte.TYPE.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls);
        }
        return false;
    }

    public static <T> T[] b(String str, Class<T> cls) {
        JSONArray jSONArray;
        if (cls == null || str == null || str.isEmpty()) {
            return null;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            SigmobLogger.e(f13217a, "parseArray: error = " + e.getMessage(), new Object[0]);
            jSONArray = null;
        }
        if (d(jSONArray)) {
            return null;
        }
        return (T[]) a(jSONArray, cls);
    }

    public static <T> Collection<T> a(String str, Class<?> cls, Class<T> cls2) {
        JSONArray jSONArray;
        if (cls == null || cls2 == null || str == null || str.isEmpty()) {
            return null;
        }
        try {
            int indexOf = str.indexOf("[");
            String substring = -1 != indexOf ? str.substring(indexOf) : null;
            jSONArray = substring != null ? new JSONArray(substring) : new JSONArray(str);
        } catch (JSONException e) {
            SigmobLogger.e(f13217a, "parseCollection: error = " + e.getMessage(), new Object[0]);
            jSONArray = null;
        }
        if (d(jSONArray)) {
            return null;
        }
        return a(jSONArray, cls, cls2);
    }

    public static <T> Collection<T> a(JSONArray jSONArray, Class<?> cls, Class<T> cls2) {
        if (cls == null || cls2 == null || d(jSONArray)) {
            return null;
        }
        A4TApA a4TApA = (Collection<T>) ((Collection) h(cls));
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof JSONObject) {
                        obj = a((JSONObject) obj, cls2);
                    }
                    a4TApA.add(obj);
                }
            } catch (JSONException e) {
                SigmobLogger.e(f13217a, "parseCollection: error = " + e.getMessage(), new Object[0]);
            }
        }
        return a4TApA;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x001d, B:8:0x0021, B:12:0x0028, B:14:0x002e, B:16:0x0036, B:18:0x0042, B:20:0x0045, B:21:0x004b, B:23:0x0055, B:26:0x005a, B:28:0x0060, B:32:0x006a, B:35:0x0073, B:38:0x0089, B:41:0x009a, B:44:0x00ac, B:47:0x00be, B:48:0x00cc, B:50:0x00f1, B:52:0x00f7, B:54:0x0101, B:56:0x0107, B:58:0x010d, B:60:0x0117, B:62:0x011d, B:63:0x0124), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.Object r5, java.lang.reflect.Field r6, org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.utils.g.a(java.lang.Object, java.lang.reflect.Field, org.json.JSONObject):void");
    }

    public static void a(Object obj, Method method, String str, Object obj2) {
        if (obj2 == null || "".equals(obj2)) {
            return;
        }
        try {
            if ("String".equals(str)) {
                method.invoke(obj, obj2.toString());
                return;
            }
            if ("Date".equals(str)) {
                method.invoke(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(obj2.toString()));
                return;
            }
            if (!"Integer".equals(str) && !IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL.equals(str)) {
                if ("Long".equalsIgnoreCase(str)) {
                    method.invoke(obj, Long.valueOf(Long.parseLong(obj2.toString())));
                    return;
                }
                if ("Double".equalsIgnoreCase(str)) {
                    method.invoke(obj, Double.valueOf(Double.parseDouble(obj2.toString())));
                    return;
                }
                if ("Boolean".equalsIgnoreCase(str)) {
                    method.invoke(obj, Boolean.valueOf(Boolean.parseBoolean(obj2.toString())));
                    return;
                }
                method.invoke(obj, obj2);
                String str2 = f13217a;
                SigmobLogger.e(str2, str2 + "setFieldValue: not supper type = " + str, new Object[0]);
                return;
            }
            method.invoke(obj, Integer.valueOf(Integer.parseInt(obj2.toString())));
        } catch (Exception e) {
            String str3 = f13217a;
            SigmobLogger.e(str3, CtFAbx.AZOQYO(e, AYUAbz.A5SV6n(str3, "setFieldValue: error = ")), new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[Catch: Exception -> 0x0029, TryCatch #0 {Exception -> 0x0029, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x001d, B:8:0x0025, B:12:0x002c, B:14:0x0032, B:16:0x003a, B:18:0x0046, B:20:0x0049, B:21:0x004f, B:23:0x0059, B:26:0x0062, B:28:0x0068, B:30:0x006e, B:32:0x0073, B:34:0x0079, B:36:0x0083, B:38:0x008c, B:42:0x0093, B:43:0x009a), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.Object r4, java.lang.reflect.Method r5, java.lang.reflect.Field r6, org.json.JSONObject r7) {
        /*
            java.lang.String r0 = r6.getName()
            java.lang.Class r1 = r6.getType()
            r2 = 0
            boolean r3 = d(r1)     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L2c
            java.lang.Class r6 = r1.getComponentType()     // Catch: java.lang.Exception -> L29
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: java.lang.Exception -> L29
            boolean r0 = d(r7)     // Catch: java.lang.Exception -> L29
            if (r0 != 0) goto Lad
            java.lang.Object[] r6 = a(r7, r6)     // Catch: java.lang.Exception -> L29
            java.lang.String r7 = r1.getSimpleName()     // Catch: java.lang.Exception -> L29
        L25:
            a(r4, r5, r7, r6)     // Catch: java.lang.Exception -> L29
            return
        L29:
            r4 = move-exception
            goto L9b
        L2c:
            boolean r3 = e(r1)     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L62
            java.lang.reflect.Type r6 = r6.getGenericType()     // Catch: java.lang.Exception -> L29
            boolean r3 = r6 instanceof java.lang.reflect.ParameterizedType     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L4e
            java.lang.reflect.ParameterizedType r6 = (java.lang.reflect.ParameterizedType) r6     // Catch: java.lang.Exception -> L29
            java.lang.reflect.Type[] r6 = r6.getActualTypeArguments()     // Catch: java.lang.Exception -> L29
            boolean r3 = com.sigmob.sdk.base.utils.q.b(r6)     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L4e
            int r3 = r6.length     // Catch: java.lang.Exception -> L29
            if (r3 <= 0) goto L4e
            r6 = r6[r2]     // Catch: java.lang.Exception -> L29
            java.lang.Class r6 = (java.lang.Class) r6     // Catch: java.lang.Exception -> L29
            goto L4f
        L4e:
            r6 = 0
        L4f:
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: java.lang.Exception -> L29
            boolean r0 = d(r7)     // Catch: java.lang.Exception -> L29
            if (r0 != 0) goto Lad
            java.util.Collection r6 = a(r7, r1, r6)     // Catch: java.lang.Exception -> L29
            java.lang.String r7 = r1.getSimpleName()     // Catch: java.lang.Exception -> L29
            goto L25
        L62:
            boolean r6 = i(r1)     // Catch: java.lang.Exception -> L29
            if (r6 == 0) goto L73
            java.lang.Object r6 = r7.opt(r0)     // Catch: java.lang.Exception -> L29
            if (r6 == 0) goto Lad
            java.lang.String r7 = r1.getSimpleName()     // Catch: java.lang.Exception -> L29
            goto L25
        L73:
            boolean r6 = j(r1)     // Catch: java.lang.Exception -> L29
            if (r6 == 0) goto L8c
            org.json.JSONObject r6 = r7.optJSONObject(r0)     // Catch: java.lang.Exception -> L29
            boolean r7 = d(r6)     // Catch: java.lang.Exception -> L29
            if (r7 != 0) goto Lad
            java.lang.Object r6 = a(r6, r1)     // Catch: java.lang.Exception -> L29
            java.lang.String r7 = r1.getSimpleName()     // Catch: java.lang.Exception -> L29
            goto L25
        L8c:
            boolean r4 = g(r1)     // Catch: java.lang.Exception -> L29
            if (r4 == 0) goto L93
            goto Lad
        L93:
            java.lang.Exception r4 = new java.lang.Exception     // Catch: java.lang.Exception -> L29
            java.lang.String r5 = "Unknown type"
            r4.<init>(r5)     // Catch: java.lang.Exception -> L29
            throw r4     // Catch: java.lang.Exception -> L29
        L9b:
            java.lang.String r5 = com.sigmob.sdk.base.utils.g.f13217a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "setField: error = "
            r6.<init>(r7)
            java.lang.String r4 = ADYaiT.CtFAbx.AZOQYO(r4, r6)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.czhj.sdk.logger.SigmobLogger.e(r5, r4, r6)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.utils.g.a(java.lang.Object, java.lang.reflect.Method, java.lang.reflect.Field, org.json.JSONObject):void");
    }

    public static void a(Object obj, Map<String, String> map) {
        Class<?> cls = obj.getClass();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Field field : cls.getDeclaredFields()) {
            try {
                String a2 = a(field.getName(), "set");
                if (a(declaredMethods, a2)) {
                    Method method = cls.getMethod(a2, field.getType());
                    String str = map.get(field.getName());
                    if (str != null && !str.isEmpty()) {
                        String simpleName = field.getType().getSimpleName();
                        if ("String".equals(simpleName)) {
                            method.invoke(obj, str);
                        } else if ("Date".equals(simpleName)) {
                            method.invoke(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str));
                        } else {
                            if (!"Integer".equals(simpleName) && !IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL.equals(simpleName)) {
                                if ("Long".equalsIgnoreCase(simpleName)) {
                                    method.invoke(obj, Long.valueOf(Long.parseLong(str)));
                                } else if ("Double".equalsIgnoreCase(simpleName)) {
                                    method.invoke(obj, Double.valueOf(Double.parseDouble(str)));
                                } else if ("Boolean".equalsIgnoreCase(simpleName)) {
                                    method.invoke(obj, Boolean.valueOf(Boolean.parseBoolean(str)));
                                } else {
                                    SigmobLogger.e(f13217a, "setFieldValue: not supper type = " + simpleName, new Object[0]);
                                }
                            }
                            method.invoke(obj, Integer.valueOf(Integer.parseInt(str)));
                        }
                    }
                }
            } catch (Exception e) {
                SigmobLogger.e(f13217a, CtFAbx.AZOQYO(e, new StringBuilder("setFieldValue: error = ")), new Object[0]);
            }
        }
    }

    private static void a(Object obj, JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            Map map = (Map) obj;
            while (keys.hasNext()) {
                String next = keys.next();
                map.put(next, jSONObject.get(next));
            }
        } catch (JSONException e) {
            SigmobLogger.e(f13217a, "setField: error = " + e.getMessage(), new Object[0]);
        }
    }

    private static void a(JSONStringer jSONStringer, Object obj) {
        if (d(obj)) {
            try {
                jSONStringer.value((Object) null);
                return;
            } catch (JSONException e) {
                SigmobLogger.e(f13217a, "serialize: error = " + e.getMessage(), new Object[0]);
                return;
            }
        }
        Class<?> cls = obj.getClass();
        if (j(cls)) {
            c(jSONStringer, obj);
            return;
        }
        if (d(cls)) {
            b(jSONStringer, obj);
            return;
        }
        if (e(cls)) {
            a(jSONStringer, (Collection<?>) obj);
            return;
        }
        if (f(cls)) {
            a(jSONStringer, (Map<?, ?>) obj);
            return;
        }
        try {
            jSONStringer.value(obj);
        } catch (JSONException e2) {
            SigmobLogger.e(f13217a, "serialize: error = " + e2.getMessage(), new Object[0]);
        }
    }

    private static void a(JSONStringer jSONStringer, Collection<?> collection) {
        try {
            jSONStringer.array();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                a(jSONStringer, it.next());
            }
            jSONStringer.endArray();
        } catch (Exception e) {
            SigmobLogger.e(f13217a, CtFAbx.AZOQYO(e, new StringBuilder("serializeCollect: error = ")), new Object[0]);
        }
    }

    private static void a(JSONStringer jSONStringer, Map<?, ?> map) {
        try {
            jSONStringer.object();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                jSONStringer.key((String) entry.getKey());
                a(jSONStringer, entry.getValue());
            }
            jSONStringer.endObject();
        } catch (Exception e) {
            SigmobLogger.e(f13217a, CtFAbx.AZOQYO(e, new StringBuilder("serializeMap: error = ")), new Object[0]);
        }
    }

    public static boolean a(Class<?> cls) {
        if (cls != null) {
            return Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls);
        }
        return false;
    }

    public static boolean a(Method[] methodArr, String str) {
        for (Method method : methodArr) {
            if (str.equals(method.getName())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] a(JSONArray jSONArray, Class<T> cls) {
        if (cls == null || d(jSONArray)) {
            return null;
        }
        int length = jSONArray.length();
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
        for (int i = 0; i < length; i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof JSONObject) {
                        obj = a((JSONObject) obj, cls);
                    }
                    tArr[i] = obj;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return tArr;
    }
}
