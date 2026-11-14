package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ay extends ax {
    public static final String b = "logout";
    private static final String[] c = {"#", "#", "V", "D", "I", "W", "E", "A"};

    static {
        RAEqkf();
    }

    private static /* synthetic */ void RAEqkf() {
        char[] charArray = "\u0091\u009d\u009fÜ\u0095\u0093\u009f\u0097Ü\u0090\u009d\u008bÜ\u0081\u009a\u0097\u009e\u009eÜ¸\u009c\u009b°\u0080\u009b\u0096\u0095\u0097".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 242);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0091\u009e\u009b\u009c\u009b\u0086".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 242);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    public String a() {
        return b;
    }

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    public void a(int i, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory c2 = aa.a().c();
            if (c2 != null) {
                c2.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + c[i] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (Throwable unused) {
        }
    }
}
