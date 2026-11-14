package com.baidu.mobads.sdk.api;

import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BaiduNativeFeedSession {
    private static HashMap<String, String> sessionHashMap = new HashMap<>();
    private static BaiduNativeFeedSession theInstance;

    static {
        ggYabjX();
    }

    private BaiduNativeFeedSession() {
    }

    public static synchronized BaiduNativeFeedSession getInstance() {
        BaiduNativeFeedSession baiduNativeFeedSession;
        synchronized (BaiduNativeFeedSession.class) {
            try {
                if (theInstance == null) {
                    theInstance = new BaiduNativeFeedSession();
                }
                baiduNativeFeedSession = theInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return baiduNativeFeedSession;
    }

    private static /* synthetic */ void ggYabjX() {
        char[] charArray = "Û×Õ\u0096ßÙÕÝ\u0096Ú×Á\u0096ËÐÝÔÔ\u0096òÖÑúÊÑÜßÝ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 184);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÛÔÑÖÑÌ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 184);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getSequenceId(int i) {
        int i2 = 1;
        if (i < 1) {
            return 1;
        }
        try {
        } catch (Exception unused) {
        }
        if (!sessionHashMap.containsKey(i + "")) {
            sessionHashMap.put(i + "", "1");
            return 1;
        }
        int parseInt = Integer.parseInt(sessionHashMap.get(i + "")) + 1;
        if (parseInt >= 1) {
            i2 = parseInt;
        }
        sessionHashMap.put(i + "", i2 + "");
        return i2;
    }
}
