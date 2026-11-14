package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EwN40Z {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final B4ZgIw.AMqCpz f9402ADYaiT = new B4ZgIw.AMqCpz(20);

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f9403A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public RecyclerView.ADYaiT.A2egSU f9404A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public RecyclerView.ADYaiT.A2egSU f9405A5SV6n;

    static {
        bbupZq();
    }

    public static EwN40Z A2egSU() {
        EwN40Z ewN40Z = (EwN40Z) f9402ADYaiT.A2egSU();
        return ewN40Z == null ? new EwN40Z() : ewN40Z;
    }

    private static /* synthetic */ void bbupZq() {
        char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 30);
        }
        String str = new String(charArray);
        char[] charArray2 = "}rwpwj".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 30);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
