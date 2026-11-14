package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface aaaaaeaa {
    public static final aaaaaeaa aaaaaaaa = new aaaaaaaa();

    public class aaaaaaaa implements aaaaaeaa {
        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaeaa
        public void aaaaaaaa(int i, aaaaaaa0 aaaaaaa0Var) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaeaa
        public boolean aaaaaaaa(int i, List list) {
            return true;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaeaa
        public boolean aaaaaaaa(int i, List list, boolean z) {
            return true;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaeaa
        public boolean aaaaaaaa(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, int i2, boolean z) {
            aaaaaaauVar.skip(i2);
            return true;
        }
    }

    static {
        jDHpnbx();
    }

    private static /* synthetic */ void jDHpnbx() {
        char[] charArray = "\u0006\n\bK\u0002\u0004\b\u0000K\u0007\n\u001cK\u0016\r\u0000\t\tK/\u000b\f'\u0017\f\u0001\u0002\u0000".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'e');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0006\t\f\u000b\f\u0011".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'e');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    void aaaaaaaa(int i, aaaaaaa0 aaaaaaa0Var);

    boolean aaaaaaaa(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, int i2, boolean z);

    boolean aaaaaaaa(int i, List list);

    boolean aaaaaaaa(int i, List list, boolean z);
}
