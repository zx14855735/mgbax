package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ht {
    private static final SparseArray<HashMap> xj = new SparseArray<>();

    static {
        QMixZS();
    }

    private static /* synthetic */ void QMixZS() {
        char[] charArray = "($&e,*&.e)$2e8#.''e\u0001%\"\t9\"/,.".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'K');
        }
        String str = new String(charArray);
        char[] charArray2 = "('\"%\"?".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'K');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static <T> T hf(String str, Class<T> cls) {
        HashMap hashMap;
        if (cls == null || str == null || (hashMap = xj.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) hashMap.remove(str);
    }

    public static <T> void xj(String str, T t, Class cls) {
        if (t == null) {
            return;
        }
        int hashCode = cls.hashCode();
        SparseArray<HashMap> sparseArray = xj;
        HashMap hashMap = sparseArray.get(hashCode);
        if (hashMap == null) {
            hashMap = new HashMap();
            sparseArray.put(hashCode, hashMap);
        }
        hashMap.put(str, t);
    }

    public static <T> void xj(String str) {
        int size = xj.size();
        for (int i = 0; i < size; i++) {
            SparseArray<HashMap> sparseArray = xj;
            HashMap hashMap = sparseArray.get(sparseArray.keyAt(i));
            if (hashMap != null) {
                hashMap.remove(str);
            }
        }
    }

    public static <T> T xj(String str, Class<T> cls) {
        HashMap hashMap;
        if (cls == null || str == null || (hashMap = xj.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) hashMap.get(str);
    }
}
