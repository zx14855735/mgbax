package D6yqiO;

import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final A5SV6n f2006A2egSU = A5SV6n.f2005A2egSU;

    static {
        GzZQfZf();
    }

    public static A5SV6n A2egSU(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                RXb0Sz.ARc23Z.ADYaiT(fragment.getParentFragmentManager(), "declaringFragment.parentFragmentManager");
            }
            fragment = fragment.getParentFragment();
        }
        return f2006A2egSU;
    }

    public static void A4TApA(AYUAbz aYUAbz) {
        if (CtxOCS.C4FrIb(3)) {
            aYUAbz.f2007AcNBzu.getClass();
        }
    }

    public static final void A5SV6n(Fragment fragment, String str) {
        RXb0Sz.ARc23Z.AMqCpz(fragment, "fragment");
        RXb0Sz.ARc23Z.AMqCpz(str, "previousFragmentId");
        A4TApA(new A2egSU(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str));
        A2egSU(fragment).getClass();
    }

    private static /* synthetic */ void GzZQfZf() {
        char[] charArray = "EIK\bAGKC\bDI_\bUNCJJ\blHOdTOBAC".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '&');
        }
        String str = new String(charArray);
        char[] charArray2 = "EJOHOR".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '&');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
