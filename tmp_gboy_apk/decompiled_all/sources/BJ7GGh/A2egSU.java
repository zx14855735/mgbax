package BJ7GGh;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A2egSU f1327AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A2egSU f1328AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final A2egSU f1329AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final A2egSU f1330AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final A2egSU f1331B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final A2egSU f1332B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final A2egSU f1333B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final A2egSU f1334B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final /* synthetic */ A2egSU[] f1335B7CMnp;

    static {
        A2egSU a2egSU = new A2egSU("INT_TYPE", 0);
        f1327AcNBzu = a2egSU;
        A2egSU a2egSU2 = new A2egSU("FLOAT_TYPE", 1);
        f1328AlLFFp = a2egSU2;
        A2egSU a2egSU3 = new A2egSU("COLOR_TYPE", 2);
        f1329AmA8tU = a2egSU3;
        A2egSU a2egSU4 = new A2egSU("COLOR_DRAWABLE_TYPE", 3);
        f1330AzWtSf = a2egSU4;
        A2egSU a2egSU5 = new A2egSU("STRING_TYPE", 4);
        f1331B25kr6 = a2egSU5;
        A2egSU a2egSU6 = new A2egSU("BOOLEAN_TYPE", 5);
        f1332B2KMhB = a2egSU6;
        A2egSU a2egSU7 = new A2egSU("DIMENSION_TYPE", 6);
        f1333B3GDIM = a2egSU7;
        A2egSU a2egSU8 = new A2egSU("REFERENCE_TYPE", 7);
        f1334B4ZgIw = a2egSU8;
        f1335B7CMnp = new A2egSU[]{a2egSU, a2egSU2, a2egSU3, a2egSU4, a2egSU5, a2egSU6, a2egSU7, a2egSU8};
        pUWWR();
    }

    private static /* synthetic */ void pUWWR() {
        char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'g');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'g');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static A2egSU valueOf(String str) {
        return (A2egSU) Enum.valueOf(A2egSU.class, str);
    }

    public static A2egSU[] values() {
        return (A2egSU[]) f1335B7CMnp.clone();
    }
}
