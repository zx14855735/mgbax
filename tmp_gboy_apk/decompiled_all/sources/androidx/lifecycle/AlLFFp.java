package androidx.lifecycle;

import java.lang.reflect.Method;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp {
    private static final /* synthetic */ AlLFFp[] $VALUES;
    public static final AaHO0E Companion;
    public static final AlLFFp ON_ANY;
    public static final AlLFFp ON_CREATE;
    public static final AlLFFp ON_DESTROY;
    public static final AlLFFp ON_PAUSE;
    public static final AlLFFp ON_RESUME;
    public static final AlLFFp ON_START;
    public static final AlLFFp ON_STOP;

    static {
        AlLFFp alLFFp = new AlLFFp("ON_CREATE", 0);
        ON_CREATE = alLFFp;
        AlLFFp alLFFp2 = new AlLFFp("ON_START", 1);
        ON_START = alLFFp2;
        AlLFFp alLFFp3 = new AlLFFp("ON_RESUME", 2);
        ON_RESUME = alLFFp3;
        AlLFFp alLFFp4 = new AlLFFp("ON_PAUSE", 3);
        ON_PAUSE = alLFFp4;
        AlLFFp alLFFp5 = new AlLFFp("ON_STOP", 4);
        ON_STOP = alLFFp5;
        AlLFFp alLFFp6 = new AlLFFp("ON_DESTROY", 5);
        ON_DESTROY = alLFFp6;
        AlLFFp alLFFp7 = new AlLFFp("ON_ANY", 6);
        ON_ANY = alLFFp7;
        $VALUES = new AlLFFp[]{alLFFp, alLFFp2, alLFFp3, alLFFp4, alLFFp5, alLFFp6, alLFFp7};
        Companion = new AaHO0E();
        hixY();
    }

    private static /* synthetic */ void hixY() {
        char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 127);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 127);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static AlLFFp valueOf(String str) {
        return (AlLFFp) Enum.valueOf(AlLFFp.class, str);
    }

    public static AlLFFp[] values() {
        return (AlLFFp[]) $VALUES.clone();
    }

    public final AmA8tU A2egSU() {
        switch (AcNBzu.f8976A2egSU[ordinal()]) {
            case 1:
            case 2:
                return AmA8tU.f8979AmA8tU;
            case 3:
            case 4:
                return AmA8tU.f8980AzWtSf;
            case 5:
                return AmA8tU.f8981B25kr6;
            case 6:
                return AmA8tU.f8977AcNBzu;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
