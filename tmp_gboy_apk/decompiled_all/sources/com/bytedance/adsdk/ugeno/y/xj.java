package com.bytedance.adsdk.ugeno.y;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {

    /* renamed from: com.bytedance.adsdk.ugeno.y.xj$xj, reason: collision with other inner class name */
    public static class C0035xj {
        public int[] hf;
        public float[] w;
        public GradientDrawable.Orientation xj;
    }

    public static C0035xj hf(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String substring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            int xj = xj(substring, '%');
            int indexOf = substring.indexOf(",");
            String substring2 = substring.substring(0, indexOf);
            C0035xj c0035xj = new C0035xj();
            c0035xj.xj = u(substring2);
            String substring3 = substring.substring(indexOf + 1);
            int[] iArr = new int[xj];
            float[] fArr = new float[xj];
            for (int i = 0; i < xj; i++) {
                int indexOf2 = substring3.indexOf("%");
                String trim = substring3.substring(0, indexOf2 + 1).trim();
                int indexOf3 = (trim.contains("rgba") ? trim.indexOf(")") : trim.indexOf(" ")) + 1;
                iArr[i] = xj(trim.substring(0, indexOf3).trim());
                fArr[i] = w.xj(trim.substring(indexOf3, trim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i2 = indexOf2 + 2;
                if (substring3.length() <= i2) {
                    break;
                }
                substring3 = substring3.substring(i2);
            }
            if (xj < 2) {
                return null;
            }
            c0035xj.hf = iArr;
            c0035xj.w = fArr;
            return c0035xj;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static GradientDrawable.Orientation u(String str) {
        try {
            int parseInt = str.contains("deg") ? Integer.parseInt(str.substring(0, str.length() - 3).trim()) : Integer.parseInt(str);
            return parseInt == 90 ? GradientDrawable.Orientation.LEFT_RIGHT : parseInt == 180 ? GradientDrawable.Orientation.TOP_BOTTOM : parseInt == 270 ? GradientDrawable.Orientation.RIGHT_LEFT : parseInt == 135 ? GradientDrawable.Orientation.TL_BR : parseInt == 45 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static boolean w(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }

    public static int xj(String str) {
        return xj(str, com.sigmob.sdk.base.blurkit.d.f13043a);
    }

    public static int xj(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("transparent")) {
                return 0;
            }
            if (str.charAt(0) == '#' && str.length() == 4) {
                StringBuilder sb = new StringBuilder("#");
                char[] charArray = str.toCharArray();
                for (int i2 = 1; i2 < charArray.length; i2++) {
                    sb.append(charArray[i2]);
                    sb.append(charArray[i2]);
                }
                return Color.parseColor(sb.toString());
            }
            if (str.charAt(0) == '#' && str.length() == 7) {
                return Color.parseColor(str);
            }
            if (str.charAt(0) == '#' && str.length() == 9) {
                return Color.parseColor(str);
            }
            if (!str.startsWith("rgba")) {
                return com.sigmob.sdk.base.blurkit.d.f13043a;
            }
            String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
            if (split != null && split.length == 4) {
                return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2]));
            }
        }
        return i;
    }

    public static int xj(String str, char c) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    public static int xj(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            pl.u("ColorUtils", "alpha must be between 0 and 255. ");
            i2 = 255;
        }
        return (i & 16777215) | (i2 << 24);
    }
}
