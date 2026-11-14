package com.kwad.components.core.webview.tachikoma;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum TKRenderFailReason {
    UNKNOWN,
    SWITCH_CLOSE,
    PLUGIN_NOT_READY,
    TK_FILE_LOAD_ERROR,
    RENDER_ERROR,
    TK_FILE_LOAD_TIMEOUT;

    static {
        jMMkAA();
    }

    private static /* synthetic */ void jMMkAA() {
        char[] charArray = ")%'d-+'/d(%3d9\"/&&d\u0000$#\b8#.-/".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'J');
        }
        String str = new String(charArray);
        char[] charArray2 = ")&#$#>".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'J');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
