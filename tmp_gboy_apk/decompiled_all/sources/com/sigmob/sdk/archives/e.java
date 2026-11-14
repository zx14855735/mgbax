package com.sigmob.sdk.archives;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final d f13024a = new d();

    static {
        FIILE();
    }

    private static /* synthetic */ void FIILE() {
        char[] charArray = "ÅÉË\u0088ÁÇËÃ\u0088ÄÉß\u0088ÕÎÃÊÊ\u0088ìÈÏäÔÏÂÁÃ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 166);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÅÊÏÈÏÒ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 166);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void a() {
        System.out.getClass();
    }

    public static void a(String[] strArr) {
        if (strArr.length == 0) {
            a();
            return;
        }
        PrintStream printStream = System.out;
        String str = strArr[0];
        printStream.getClass();
        File file = new File(strArr[0]);
        if (!file.isFile()) {
            PrintStream printStream2 = System.err;
            file.toString();
            printStream2.getClass();
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        c a2 = strArr.length > 1 ? f13024a.a(strArr[1], bufferedInputStream) : f13024a.a(bufferedInputStream);
        PrintStream printStream3 = System.out;
        a2.toString();
        printStream3.getClass();
        while (true) {
            a a3 = a2.a();
            if (a3 == null) {
                a2.close();
                bufferedInputStream.close();
                return;
            } else {
                PrintStream printStream4 = System.out;
                a3.a();
                printStream4.getClass();
            }
        }
    }
}
