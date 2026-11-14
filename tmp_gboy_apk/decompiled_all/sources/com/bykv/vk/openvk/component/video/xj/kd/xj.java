package com.bykv.vk.openvk.component.video.xj.kd;

import android.os.Build;
import android.view.View;
import com.kuaishou.weapon.p0.bi;
import com.sigmob.sdk.archives.tar.e;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final int xj = Build.VERSION.SDK_INT;

    static {
        FflRX();
    }

    private static /* synthetic */ void FflRX() {
        char[] charArray = "\u008d\u0081\u0083À\u0089\u008f\u0083\u008bÀ\u008c\u0081\u0097À\u009d\u0086\u008b\u0082\u0082À¤\u0080\u0087¬\u009c\u0087\u008a\u0089\u008b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 238);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008d\u0082\u0087\u0080\u0087\u009a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 238);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int xj(long j, long j2) {
        return Math.min(Math.max(0, j2 > 0 ? (int) (((j * 1.0d) / j2) * 100.0d) : 0), 100);
    }

    public static String xj(long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / 60000;
        long j3 = ((j % bi.s) % 60000) / 1000;
        if (j2 >= 10) {
            sb.append(j2);
        } else if (j2 > 0) {
            sb.append(0);
            sb.append(j2);
        } else {
            sb.append(e.V);
        }
        sb.append(":");
        if (j3 >= 10) {
            sb.append(j3);
        } else if (j3 > 0) {
            sb.append(0);
            sb.append(j3);
        } else {
            sb.append(e.V);
        }
        return sb.toString();
    }

    public static void xj(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setSystemUiVisibility(0);
            return;
        }
        int i = xj;
        if (i >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
