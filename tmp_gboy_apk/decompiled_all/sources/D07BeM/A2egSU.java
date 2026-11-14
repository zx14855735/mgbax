package D07BeM;

import android.text.Editable;
import androidx.emoji2.text.BJ7GGh;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends Editable.Factory {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Object f1922A2egSU = new Object();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile A2egSU f1923A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static Class f1924A5SV6n;

    static {
        sGsiKQc();
    }

    private static /* synthetic */ void sGsiKQc() {
        char[] charArray = "\u0091\u009d\u009fÜ\u0095\u0093\u009f\u0097Ü\u0090\u009d\u008bÜ\u0081\u009a\u0097\u009e\u009eÜ¸\u009c\u009b°\u0080\u009b\u0096\u0095\u0097".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 242);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0091\u009e\u009b\u009c\u009b\u0086".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 242);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f1924A5SV6n;
        return cls != null ? new BJ7GGh(cls, charSequence) : super.newEditable(charSequence);
    }
}
