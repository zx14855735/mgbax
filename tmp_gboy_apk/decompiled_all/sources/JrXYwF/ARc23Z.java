package JrXYwF;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public enum ARc23Z {
    /* JADX INFO: Fake field, exist only in values array */
    LAUNCH("launch"),
    JAVA("java"),
    /* JADX INFO: Fake field, exist only in values array */
    NATIVE("native"),
    ANR("anr"),
    /* JADX INFO: Fake field, exist only in values array */
    BLOCK("block"),
    /* JADX INFO: Fake field, exist only in values array */
    ENSURE("ensure"),
    /* JADX INFO: Fake field, exist only in values array */
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    /* JADX INFO: Fake field, exist only in values array */
    ALL("all");


    /* renamed from: AcNBzu, reason: collision with root package name */
    public final String f4162AcNBzu;

    static {
        nJsmJIJ();
    }

    ARc23Z(String str) {
        this.f4162AcNBzu = str;
    }

    private static /* synthetic */ void nJsmJIJ() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
