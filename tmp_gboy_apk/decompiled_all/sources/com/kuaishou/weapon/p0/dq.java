package com.kuaishou.weapon.p0;

import ADYaiT.CtFAbx;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class dq {
    public static Method a(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Method ", str, " with parameters ");
        B3GDIM2.append(Arrays.asList(clsArr));
        B3GDIM2.append(" not found in ");
        B3GDIM2.append(obj.getClass());
        throw new NoSuchMethodException(B3GDIM2.toString());
    }

    public static Field b(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                Field declaredField2 = Field.class.getDeclaredField("modifiers");
                declaredField2.setAccessible(true);
                declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (Exception unused) {
            }
        }
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Field ", str, " not found in ");
        B3GDIM2.append(obj.getClass());
        throw new NoSuchFieldException(B3GDIM2.toString());
    }

    public static Field a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (Exception unused) {
            }
        }
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Field ", str, " not found in ");
        B3GDIM2.append(obj.getClass());
        throw new NoSuchFieldException(B3GDIM2.toString());
    }
}
