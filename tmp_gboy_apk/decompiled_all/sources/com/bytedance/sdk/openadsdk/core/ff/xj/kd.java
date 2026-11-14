package com.bytedance.sdk.openadsdk.core.ff.xj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.yo;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private static final List<String> xj = new ArrayList(Arrays.asList("1", "3", "2"));

    static {
        sYLKX();
    }

    private static /* synthetic */ void sYLKX() {
        char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 204);
        }
        String str = new String(charArray);
        char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 204);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String xj(String str) {
        str.getClass();
        switch (str) {
            case "46000":
            case "46002":
            case "46004":
            case "46007":
            case "46008":
                return "1";
            case "46001":
            case "46006":
            case "46009":
                return "2";
            case "46003":
            case "46005":
            case "46011":
                return "3";
            default:
                return Constants.FAIL;
        }
    }

    public static String xj() {
        String u = tf.u();
        String kd = tf.kd();
        String am = yo.am();
        String zg = yo.zg();
        if (!yo.pl()) {
            return "5";
        }
        if (!TextUtils.isEmpty(u) && !TextUtils.isEmpty(kd)) {
            if (!TextUtils.isEmpty(am) && !TextUtils.isEmpty(zg)) {
                String xj2 = xj(u + kd);
                String xj3 = xj(am + zg);
                List<String> list = xj;
                if (list.contains(xj2) && list.contains(xj3) && !xj3.equals(xj2)) {
                    return "6";
                }
                return list.contains(xj2) ? xj2 : list.contains(xj3) ? xj3 : Constants.FAIL;
            }
            return xj(u + kd);
        }
        if (!TextUtils.isEmpty(am) && !TextUtils.isEmpty(zg)) {
            return xj(am + zg);
        }
        return "4";
    }
}
