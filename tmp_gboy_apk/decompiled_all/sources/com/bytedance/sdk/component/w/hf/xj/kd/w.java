package com.bytedance.sdk.component.w.hf.xj.kd;

import java.lang.reflect.Method;
import okhttp3.internal.http2.ADYaiT;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w {
    public final com.bytedance.sdk.component.w.xj.y c;
    final int d;
    public final com.bytedance.sdk.component.w.xj.y f;
    public static final com.bytedance.sdk.component.w.xj.y xj = com.bytedance.sdk.component.w.xj.y.xj(":");
    public static final com.bytedance.sdk.component.w.xj.y hf = com.bytedance.sdk.component.w.xj.y.xj(ADYaiT.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.component.w.xj.y w = com.bytedance.sdk.component.w.xj.y.xj(ADYaiT.TARGET_METHOD_UTF8);
    public static final com.bytedance.sdk.component.w.xj.y u = com.bytedance.sdk.component.w.xj.y.xj(ADYaiT.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.component.w.xj.y kd = com.bytedance.sdk.component.w.xj.y.xj(ADYaiT.TARGET_SCHEME_UTF8);
    public static final com.bytedance.sdk.component.w.xj.y y = com.bytedance.sdk.component.w.xj.y.xj(ADYaiT.TARGET_AUTHORITY_UTF8);

    static {
        RvDmCB();
    }

    public w(String str, String str2) {
        this(com.bytedance.sdk.component.w.xj.y.xj(str), com.bytedance.sdk.component.w.xj.y.xj(str2));
    }

    private static /* synthetic */ void RvDmCB() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.c.equals(wVar.c) && this.f.equals(wVar.f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f.hashCode() + ((this.c.hashCode() + 527) * 31);
    }

    public String toString() {
        return com.bytedance.sdk.component.w.hf.xj.w.xj("%s: %s", this.c.xj(), this.f.xj());
    }

    public w(com.bytedance.sdk.component.w.xj.y yVar, String str) {
        this(yVar, com.bytedance.sdk.component.w.xj.y.xj(str));
    }

    public w(com.bytedance.sdk.component.w.xj.y yVar, com.bytedance.sdk.component.w.xj.y yVar2) {
        this.c = yVar;
        this.f = yVar2;
        this.d = yVar2.c() + yVar.c() + 32;
    }
}
