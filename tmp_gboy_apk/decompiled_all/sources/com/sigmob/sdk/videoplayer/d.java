package com.sigmob.sdk.videoplayer;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum d {
    STATE_IDLE,
    STATE_NORMAL,
    STATE_BUFFERING_START,
    STATE_BUFFERING_END,
    STATE_PREPARING,
    STATE_PREPARING_CHANGING_URL,
    STATE_PREPARED,
    STATE_PLAYING,
    STATE_PAUSE,
    STATE_AUTO_COMPLETE,
    STATE_STOP,
    STATE_ERROR;

    static {
        QDWwdRl();
    }

    private static /* synthetic */ void QDWwdRl() {
        char[] charArray = "ÁÍÏ\u008cÅÃÏÇ\u008cÀÍÛ\u008cÑÊÇÎÎ\u008cèÌËàÐËÆÅÇ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 162);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÁÎËÌËÖ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 162);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
