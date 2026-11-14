package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface aaaaaaea {
    public static final aaaaaaea aaaaaaaa = new aaaaaaaa();

    public class aaaaaaaa implements aaaaaaea {
        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaea
        public void aaaaaaaa(aaaaoaaa aaaaoaaaVar, List list) {
        }
    }

    static {
        bZRWOR();
    }

    private static /* synthetic */ void bZRWOR() {
        char[] charArray = "dhj)`fjb)eh~)tobkk)MinEunc`b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 7);
        }
        String str = new String(charArray);
        char[] charArray2 = "dknins".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 7);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    void aaaaaaaa(aaaaoaaa aaaaoaaaVar, List list);
}
