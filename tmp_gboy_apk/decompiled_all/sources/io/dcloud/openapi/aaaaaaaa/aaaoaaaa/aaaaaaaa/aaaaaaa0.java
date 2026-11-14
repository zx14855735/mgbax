package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface aaaaaaa0 {
    public static final aaaaaaa0 aaaaaaaa = new aaaaaaaa();

    public class aaaaaaaa implements aaaaaaa0 {
        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0
        public aaaacaaa aaaaaaaa(aa0aaaaa aa0aaaaaVar, aaaaaaca aaaaaacaVar) {
            return null;
        }
    }

    static {
        dfcvYxW();
    }

    private static /* synthetic */ void dfcvYxW() {
        char[] charArray = ":64w>84<w;6 w*1<55w\u001370\u001b+0=><".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Y');
        }
        String str = new String(charArray);
        char[] charArray2 = ":5070-".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    aaaacaaa aaaaaaaa(aa0aaaaa aa0aaaaaVar, aaaaaaca aaaaaacaVar);
}
