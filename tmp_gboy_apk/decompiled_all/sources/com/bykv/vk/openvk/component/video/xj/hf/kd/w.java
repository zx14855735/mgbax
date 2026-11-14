package com.bykv.vk.openvk.component.video.xj.hf.kd;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {

    public static final class xj {
        private static final w xj = new w();

        static {
            aYaKwYO();
        }

        private static /* synthetic */ void aYaKwYO() {
            char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '}');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '}');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static w xj() {
        return xj.xj;
    }

    public hf hf() {
        return new u();
    }
}
