package com.tencent.mm.opensdk.diffdev.a;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(TTAdConstant.INTERACTION_TYPE_CODE),
    UUID_ERROR(500);


    /* renamed from: a, reason: collision with root package name */
    private int f13871a;

    static {
        tlrZ();
    }

    d(int i) {
        this.f13871a = i;
    }

    private static /* synthetic */ void tlrZ() {
        char[] charArray = "\u008e\u0082\u0080Ã\u008a\u008c\u0080\u0088Ã\u008f\u0082\u0094Ã\u009e\u0085\u0088\u0081\u0081Ã§\u0083\u0084¯\u009f\u0084\u0089\u008a\u0088".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 237);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008e\u0081\u0084\u0083\u0084\u0099".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 237);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int a() {
        return this.f13871a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f13871a;
    }
}
