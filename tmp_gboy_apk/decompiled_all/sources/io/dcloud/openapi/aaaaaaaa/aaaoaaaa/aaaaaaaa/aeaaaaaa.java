package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface aeaaaaaa {
    public static final aeaaaaaa aaaaaaaa = new aaaaaaaa();

    public class aaaaaaaa implements aeaaaaaa {
        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aeaaaaaa
        public List aaaaaaaa(String str) {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    }

    static {
        FkKDXgN();
    }

    private static /* synthetic */ void FkKDXgN() {
        char[] charArray = "ÇËÉ\u008aÃÅÉÁ\u008aÆËÝ\u008a×ÌÁÈÈ\u008aîÊÍæÖÍÀÃÁ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 164);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÇÈÍÊÍÐ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 164);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    List aaaaaaaa(String str);
}
