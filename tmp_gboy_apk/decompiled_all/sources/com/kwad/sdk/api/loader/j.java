package com.kwad.sdk.api.loader;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class j {
    private static File ayt;
    private static final String ayu;

    static {
        ayu = Cb() ? "dynamic_apk" : "dynamic.apk";
        tHpgydD();
    }

    public static void A(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.j.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    File[] listFiles = j.w(context, str).getParentFile().listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file : listFiles) {
                        if (i.L(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            j.h(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private static boolean Cb() {
        int i = Build.VERSION.SDK_INT;
        return i == 30 || i == 31 || i == 32;
    }

    private static File bj(Context context) {
        if (ayt == null) {
            ayt = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return ayt;
    }

    public static void h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                h(file2);
            }
        }
        file.delete();
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists() || !file.isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
            }
            if ((!file.exists() || !file.isDirectory()) && com.kwad.sdk.api.a.oy.booleanValue()) {
                throw new RuntimeException(CtFAbx.AYUAbz(file, "Can not ensureDir:"));
            }
        }
        return file;
    }

    public static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    private static /* synthetic */ void tHpgydD() {
        char[] charArray = "\u0087\u008b\u0089Ê\u0083\u0085\u0089\u0081Ê\u0086\u008b\u009dÊ\u0097\u008c\u0081\u0088\u0088Ê®\u008a\u008d¦\u0096\u008d\u0080\u0083\u0081".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 228);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0087\u0088\u008d\u008a\u008d\u0090".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 228);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static File u(Context context, String str) {
        return new File(bj(context), "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    public static String v(Context context, String str) {
        return i(new File(bj(context), CtFAbx.BChYOn("apk-", str))).getPath();
    }

    public static File w(Context context, String str) {
        return i(new File(bj(context), CtFAbx.BChYOn("apk-", str)));
    }

    public static String x(Context context, String str) {
        return new File(v(context, str), ayu).getPath();
    }

    public static String y(Context context, String str) {
        return i(new File(v(context, str), "dex")).getPath();
    }

    public static String z(Context context, String str) {
        return i(new File(v(context, str), "libs")).getPath();
    }
}
