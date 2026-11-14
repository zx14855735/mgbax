package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum aaaaaaa0 {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    public final int aaaaaaaa;

    static {
        OiLHV();
    }

    aaaaaaa0(int i) {
        this.aaaaaaaa = i;
    }

    private static /* synthetic */ void OiLHV() {
        char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 193);
        }
        String str = new String(charArray);
        char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 193);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static aaaaaaa0 aaaaaaaa(int i) {
        for (aaaaaaa0 aaaaaaa0Var : values()) {
            if (aaaaaaa0Var.aaaaaaaa == i) {
                return aaaaaaa0Var;
            }
        }
        return null;
    }
}
