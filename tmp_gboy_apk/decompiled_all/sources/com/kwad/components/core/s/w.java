package com.kwad.components.core.s;

import android.content.Context;
import android.os.Build;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w {
    private static final String[] add = {"ONEPLUS A6000", "ONEPLUS A6003", "IN2010"};
    private static Boolean ade;

    static {
        xQidoN();
    }

    public static boolean aJ(Context context) {
        Boolean bool = ade;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (bb.RB()) {
            ade = Boolean.valueOf(aK(context));
        } else if (bb.RC()) {
            ade = Boolean.valueOf(uM() || uN());
        } else if (bb.Ta()) {
            ade = Boolean.valueOf(uO());
        } else if (bb.Tb()) {
            ade = Boolean.valueOf(uP());
        } else if (bb.Td()) {
            ade = uL();
        } else {
            ade = Boolean.valueOf(uQ());
        }
        return ade.booleanValue();
    }

    private static boolean aK(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception unused) {
            return false;
        }
    }

    private static Boolean uL() {
        Boolean bool;
        boolean z = false;
        try {
            bool = (Boolean) z.a("smartisanos.api.DisplayUtilsSmt", "isFeatureSupport", 1);
        } catch (Exception unused) {
            bool = null;
        }
        if (bool != null && bool.booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private static boolean uM() {
        Boolean bool;
        try {
            bool = (Boolean) z.a("android.util.FtFeature", "isFeatureSupport", 32);
        } catch (Exception unused) {
            bool = null;
        }
        return bool != null && bool.booleanValue();
    }

    private static boolean uN() {
        Boolean bool;
        try {
            bool = (Boolean) z.a("android.util.FtFeature", "isFeatureSupport", "vivo.hardware.holescreen");
        } catch (Exception unused) {
            bool = null;
        }
        return bool != null && bool.booleanValue();
    }

    private static boolean uO() {
        Boolean bool;
        try {
            bool = (Boolean) z.a("com.huawei.android.util.HwNotchSizeUtil", "hasNotchInScreen", new Object[0]);
        } catch (Exception unused) {
            bool = null;
        }
        return bool != null && bool.booleanValue();
    }

    private static boolean uP() {
        Integer num;
        try {
            num = (Integer) z.a("android.os.SystemProperties", "getInt", "ro.miui.notch", 0);
        } catch (Exception unused) {
            num = null;
        }
        return num != null && num.intValue() == 1;
    }

    private static boolean uQ() {
        for (String str : add) {
            if (str.equalsIgnoreCase(Build.MODEL)) {
                return true;
            }
        }
        return false;
    }

    private static /* synthetic */ void xQidoN() {
        char[] charArray = "ñýÿ¼õóÿ÷¼ðýë¼áú÷þþ¼ØüûÐàûöõ÷".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 146);
        }
        String str = new String(charArray);
        char[] charArray2 = "ñþûüûæ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 146);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
