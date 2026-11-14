package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class bx {

    /* renamed from: a, reason: collision with root package name */
    private static String f12226a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);
    private static String b = c.b(b, 2);
    private static String b = c.b(b, 2);

    static {
        CvqZK();
    }

    private static /* synthetic */ void CvqZK() {
        char[] charArray = "\u0001\r\u000fL\u0005\u0003\u000f\u0007L\u0000\r\u001bL\u0011\n\u0007\u000e\u000eL(\f\u000b \u0010\u000b\u0006\u0005\u0007".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'b');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0001\u000e\u000b\f\u000b\u0016".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? Constants.FAIL : "1";
        String c = c(context);
        if (TextUtils.isEmpty(c)) {
            return Constants.FAIL.concat(str);
        }
        String concat = "1".concat(str);
        b(context, c);
        return concat;
    }

    public static String b(Context context) {
        String c = c(context);
        String d = d(context);
        if (!TextUtils.isEmpty(c) && TextUtils.equals(c, d)) {
            return c;
        }
        if (!TextUtils.isEmpty(c)) {
            b(context, c);
            return c;
        }
        if (TextUtils.isEmpty(d)) {
            return "";
        }
        a(context, d);
        return d;
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f12226a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return df.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        boolean canWrite;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                canWrite = Settings.System.canWrite(context.getApplicationContext());
                if (!canWrite) {
                    return;
                }
            }
            Settings.System.putString(context.getContentResolver(), f12226a, str);
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        df.a(context).d(str);
    }
}
