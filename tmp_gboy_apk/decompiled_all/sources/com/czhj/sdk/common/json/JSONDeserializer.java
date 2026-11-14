package com.czhj.sdk.common.json;

import ADYaiT.CtFAbx;
import RFbdkT.A4TApA;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class JSONDeserializer {
    public static <T> T Deserialize(Class<T> cls, Object obj) {
        if (obj instanceof JSONObject) {
            return (T) DeserializeObject(cls, (JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return (T) DeserializeArray(cls, (JSONArray) obj);
        }
        return null;
    }

    private static <T> T DeserializeArray(Class<T> cls, JSONArray jSONArray) {
        if (cls.isArray()) {
            return (T) DeserializeArrayImpl(cls.getComponentType(), jSONArray);
        }
        throw new MatchTypeException("Assigning json array to non array type: " + cls.getCanonicalName());
    }

    private static Object DeserializeArrayImpl(Class<?> cls, JSONArray jSONArray) {
        Object Deserialize;
        Object newInstance = Array.newInstance(cls, jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (isPrimitive(jSONArray.get(i).getClass())) {
                    Deserialize = jSONArray.get(i);
                } else {
                    Object obj = jSONArray.get(i);
                    if (obj != null) {
                        Deserialize = Deserialize(cls, obj);
                    } else {
                        Array.set(newInstance, i, null);
                    }
                }
                Array.set(newInstance, i, Deserialize);
            } catch (Throwable th) {
                throw new MatchTypeException("JSON error while deserializing array: " + th.toString());
            }
        }
        return newInstance;
    }

    private static <T> List<T> DeserializeList(Class<?> cls, Class<?> cls2, JSONArray jSONArray) {
        try {
            Object DeserializeArrayImpl = DeserializeArrayImpl(cls2, jSONArray);
            A4TApA a4TApA = (List<T>) ((List) cls.getConstructor(new Class[0]).newInstance(new Object[0]));
            for (int i = 0; i < Array.getLength(DeserializeArrayImpl); i++) {
                a4TApA.add(Array.get(DeserializeArrayImpl, i));
            }
            return a4TApA;
        } catch (Exception e) {
            throw new MatchTypeException(CtFAbx.AZOQYO(e, new StringBuilder("Exception deserializing list: ")));
        }
    }

    private static <T> T DeserializeObject(Class<T> cls, JSONObject jSONObject) {
        Object Deserialize;
        T t = (T) createTarget(cls);
        if (t == null) {
            return null;
        }
        for (Field field : t.getClass().getDeclaredFields()) {
            if (isValidDeserializableField(field)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    if (isPrimitive(type)) {
                        Deserialize = jSONObject.opt(field.getName());
                    } else {
                        Object opt = jSONObject.opt(field.getName());
                        if (opt == null) {
                            field.set(t, null);
                        } else if (List.class.isAssignableFrom(type)) {
                            StringTokenizer stringTokenizer = new StringTokenizer(((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0].toString(), " ");
                            stringTokenizer.nextToken();
                            Deserialize = DeserializeList(type, Class.forName(stringTokenizer.nextToken()), (JSONArray) opt);
                        } else {
                            Deserialize = Deserialize(type, opt);
                        }
                    }
                    field.set(t, Deserialize);
                } catch (Throwable th) {
                    throw new MatchTypeException("Setting " + field.getName() + " in " + type.getCanonicalName() + " got error: " + th.toString());
                }
            }
        }
        return t;
    }

    private static <T> T createTarget(Class<T> cls) {
        try {
            if (!cls.isMemberClass()) {
                return cls.newInstance();
            }
            Class<?> enclosingClass = cls.getEnclosingClass();
            if (enclosingClass == null) {
                return null;
            }
            Object newInstance = enclosingClass.newInstance();
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(enclosingClass);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(newInstance);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean isPrimitive(Class<?> cls) {
        return cls == Character.class || cls == Character.TYPE || cls == Byte.class || cls == Byte.TYPE || cls == Short.class || cls == Short.TYPE || cls == Integer.class || cls == Integer.TYPE || cls == Long.class || cls == Long.TYPE || cls == Float.class || cls == Float.TYPE || cls == Double.class || cls == Double.TYPE || cls == Boolean.class || cls == Boolean.TYPE || cls == String.class;
    }

    private static boolean isValidDeserializableField(Field field) {
        return (field.isAnnotationPresent(Transient.class) || field.getName().startsWith("this$")) ? false : true;
    }
}
