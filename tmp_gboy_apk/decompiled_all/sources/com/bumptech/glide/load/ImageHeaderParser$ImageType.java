package com.bumptech.glide.load;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    UNKNOWN(false);


    /* renamed from: AcNBzu, reason: collision with root package name */
    public final boolean f9973AcNBzu;

    static {
        YqLl();
    }

    ImageHeaderParser$ImageType(boolean z) {
        this.f9973AcNBzu = z;
    }

    private static /* synthetic */ void YqLl() {
        char[] charArray = "\r\u0001\u0003@\t\u000f\u0003\u000b@\f\u0001\u0017@\u001d\u0006\u000b\u0002\u0002@$\u0000\u0007,\u001c\u0007\n\t\u000b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'n');
        }
        String str = new String(charArray);
        char[] charArray2 = "\r\u0002\u0007\u0000\u0007\u001a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'n');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean hasAlpha() {
        return this.f9973AcNBzu;
    }
}
