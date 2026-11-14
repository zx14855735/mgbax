package com.qq.e.comm.util;

import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final HashMap f12982A2egSU = new HashMap();

    static {
        vUupT();
    }

    public static boolean A2egSU(Class cls, String str, Class... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        for (Class cls2 : clsArr) {
            sb.append("_");
            sb.append(cls2.getName());
        }
        String sb2 = sb.toString();
        HashMap hashMap = f12982A2egSU;
        Boolean bool = (Boolean) hashMap.get(sb2);
        if (bool != null) {
            return Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            hashMap.put(sb2, Boolean.TRUE);
            return true;
        } catch (NoSuchMethodException unused) {
            hashMap.put(sb2, Boolean.FALSE);
            return false;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return A2egSU(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return A2egSU(obj.getClass(), "onRenderSuccess", new Class[0]);
    }

    private static /* synthetic */ void vUupT() {
        char[] charArray = "DHJ\t@FJB\tEH^\tTOBKK\tmINeUNC@B".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\'');
        }
        String str = new String(charArray);
        char[] charArray2 = "DKNINS".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\'');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
