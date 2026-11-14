package org.apache.commons.codec.language.bm;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");

    private final String name;

    static {
        MHIjt();
    }

    RuleType(String str) {
        this.name = str;
    }

    private static /* synthetic */ void MHIjt() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String getName() {
        return this.name;
    }
}
