package com.czhj.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public @interface WireField {

    public enum Label {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED;

        static {
            NzJPRC();
        }

        private static /* synthetic */ void NzJPRC() {
            char[] charArray = "ÜÐÒ\u0091ØÞÒÚ\u0091ÝÐÆ\u0091Ì×ÚÓÓ\u0091õÑÖýÍÖÛØÚ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 191);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÜÓÖÑÖË".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 191);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public boolean a() {
            return this == REPEATED || this == PACKED;
        }

        public boolean b() {
            return this == PACKED;
        }

        public boolean c() {
            return this == ONE_OF;
        }
    }

    String adapter();

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
