package com.czhj.wire;

import ADYaiT.CtFAbx;
import java.lang.reflect.Method;
import java.net.ProtocolException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);

    final int value;

    /* renamed from: com.czhj.wire.FieldEncoding$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10665a;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            f10665a = iArr;
            try {
                iArr[FieldEncoding.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10665a[FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10665a[FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10665a[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        RSAnr();
    }

    FieldEncoding(int i) {
        this.value = i;
    }

    private static /* synthetic */ void RSAnr() {
        char[] charArray = "\u008d\u0081\u0083À\u0089\u008f\u0083\u008bÀ\u008c\u0081\u0097À\u009d\u0086\u008b\u0082\u0082À¤\u0080\u0087¬\u009c\u0087\u008a\u0089\u008b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 238);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008d\u0082\u0087\u0080\u0087\u009a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 238);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static FieldEncoding a(int i) {
        if (i == 0) {
            return VARINT;
        }
        if (i == 1) {
            return FIXED64;
        }
        if (i == 2) {
            return LENGTH_DELIMITED;
        }
        if (i == 5) {
            return FIXED32;
        }
        throw new ProtocolException(CtFAbx.ARc23Z(i, "Unexpected FieldEncoding: "));
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int i = AnonymousClass1.f10665a[ordinal()];
        if (i == 1) {
            return ProtoAdapter.UINT64;
        }
        if (i == 2) {
            return ProtoAdapter.FIXED32;
        }
        if (i == 3) {
            return ProtoAdapter.FIXED64;
        }
        if (i == 4) {
            return ProtoAdapter.BYTES;
        }
        throw new AssertionError();
    }
}
