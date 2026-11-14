package com.kwai.adclient.kscommerciallogger.model;

import com.octopus.ad.ADBidEvent;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum SubBusinessType {
    OTHER(ADBidEvent.OTHER);

    public String value;

    static {
        QCAIh();
    }

    SubBusinessType(String str) {
        this.value = str;
    }

    private static /* synthetic */ void QCAIh() {
        char[] charArray = "ÕÙÛ\u0098Ñ×ÛÓ\u0098ÔÙÏ\u0098ÅÞÓÚÚ\u0098üØßôÄßÒÑÓ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 182);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÕÚßØßÂ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 182);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
