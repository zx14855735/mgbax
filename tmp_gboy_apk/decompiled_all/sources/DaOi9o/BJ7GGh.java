package DaOi9o;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BJ7GGh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final A2egSU f2270A2egSU = new A2egSU();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ThreadLocal f2271A4TApA = new ThreadLocal();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final ArrayList f2272A5SV6n = new ArrayList();

    static {
        UvKMApU();
    }

    public BJ7GGh() {
        new B25kr6.ADYaiT();
        new B25kr6.ADYaiT();
    }

    public static void A2egSU(ViewGroup viewGroup, B4ZgIw b4ZgIw) {
        ArrayList arrayList = f2272A5SV6n;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (b4ZgIw == null) {
            b4ZgIw = f2270A2egSU;
        }
        B4ZgIw clone = b4ZgIw.clone();
        ArrayList arrayList2 = (ArrayList) A4TApA().get(viewGroup);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((B4ZgIw) it.next()).BIYEnU(viewGroup);
            }
        }
        clone.AYUAbz(viewGroup, true);
        if (viewGroup.getTag(2131298121) != null) {
            throw new ClassCastException();
        }
        viewGroup.setTag(2131298121, null);
        BIYEnU bIYEnU = new BIYEnU();
        bIYEnU.f2268AcNBzu = clone;
        bIYEnU.f2269AlLFFp = viewGroup;
        viewGroup.addOnAttachStateChangeListener(bIYEnU);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(bIYEnU);
    }

    public static B25kr6.ADYaiT A4TApA() {
        B25kr6.ADYaiT aDYaiT;
        ThreadLocal threadLocal = f2271A4TApA;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (aDYaiT = (B25kr6.ADYaiT) weakReference.get()) != null) {
            return aDYaiT;
        }
        B25kr6.ADYaiT aDYaiT2 = new B25kr6.ADYaiT();
        threadLocal.set(new WeakReference(aDYaiT2));
        return aDYaiT2;
    }

    private static /* synthetic */ void UvKMApU() {
        char[] charArray = "µ¹»ø±·»³ø´¹¯ø¥¾³ººø\u009c¸¿\u0094¤¿²±³".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 214);
        }
        String str = new String(charArray);
        char[] charArray2 = "µº¿¸¿¢".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 214);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
