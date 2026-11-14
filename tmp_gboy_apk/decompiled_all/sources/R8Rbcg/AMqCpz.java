package R8Rbcg;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AMqCpz {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final AMqCpz f7832A4TApA = new AMqCpz(0);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final AMqCpz f7833A5SV6n = new AMqCpz(1);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f7834A2egSU;

    public /* synthetic */ AMqCpz(int i) {
        this.f7834A2egSU = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ylxkc() {
        char[] charArray = "ÊÆÄ\u0087ÎÈÄÌ\u0087ËÆÐ\u0087ÚÁÌÅÅ\u0087ãÇÀëÛÀÍÎÌ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 169);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÊÅÀÇÀÝ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 169);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String toString() {
        switch (this.f7834A2egSU) {
            case 1:
                return "kotlin.Unit";
            default:
                return super.toString();
        }
    }
}
