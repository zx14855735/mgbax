package com.bytedance.sdk.component.y.xj;

import com.bytedance.sdk.component.tf.u.u;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static final TimeUnit xj = TimeUnit.SECONDS;

    static {
        LXzAAyL();
    }

    private static /* synthetic */ void LXzAAyL() {
        char[] charArray = "°¼¾ý´²¾¶ý±¼ªý »¶¿¿ý\u0099½º\u0091¡º·´¶".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 211);
        }
        String str = new String(charArray);
        char[] charArray2 = "°¿º½º§".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 211);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ExecutorService xj() {
        u uVar = new u(1, 2, 30L, xj, new LinkedBlockingQueue(), new xj("default"));
        uVar.allowCoreThreadTimeOut(true);
        return uVar;
    }
}
