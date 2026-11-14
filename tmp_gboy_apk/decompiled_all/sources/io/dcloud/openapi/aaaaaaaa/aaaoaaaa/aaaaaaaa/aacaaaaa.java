package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum aacaaaaa {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC(LiveConfigKey.QUIC);

    private final String aaaaaaaa;

    static {
        YQiF();
    }

    aacaaaaa(String str) {
        this.aaaaaaaa = str;
    }

    private static /* synthetic */ void YQiF() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.aaaaaaaa;
    }

    public static aacaaaaa aaaaaaaa(String str) {
        aacaaaaa aacaaaaaVar = HTTP_1_0;
        if (str.equals(aacaaaaaVar.aaaaaaaa)) {
            return aacaaaaaVar;
        }
        aacaaaaa aacaaaaaVar2 = HTTP_1_1;
        if (str.equals(aacaaaaaVar2.aaaaaaaa)) {
            return aacaaaaaVar2;
        }
        aacaaaaa aacaaaaaVar3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(aacaaaaaVar3.aaaaaaaa)) {
            return aacaaaaaVar3;
        }
        aacaaaaa aacaaaaaVar4 = HTTP_2;
        if (str.equals(aacaaaaaVar4.aaaaaaaa)) {
            return aacaaaaaVar4;
        }
        aacaaaaa aacaaaaaVar5 = SPDY_3;
        if (str.equals(aacaaaaaVar5.aaaaaaaa)) {
            return aacaaaaaVar5;
        }
        aacaaaaa aacaaaaaVar6 = QUIC;
        if (str.equals(aacaaaaaVar6.aaaaaaaa)) {
            return aacaaaaaVar6;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }
}
