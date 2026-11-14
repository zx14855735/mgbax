package K7mCWO;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AtomicReference f4197A2egSU = new AtomicReference(0L);

    static {
        FuVi();
    }

    public static void A2egSU(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 5) {
                AtomicReference atomicReference = f4197A2egSU;
                Long l = (Long) atomicReference.get();
                Long valueOf = Long.valueOf(l.longValue() | j);
                while (!atomicReference.compareAndSet(l, valueOf)) {
                    if (atomicReference.get() != l) {
                        break;
                    }
                }
                return;
            }
            return;
            i = i2;
        }
    }

    private static /* synthetic */ void FuVi() {
        char[] charArray = "¼°²ñ¸¾²ºñ½°¦ñ¬·º³³ñ\u0095±¶\u009d\u00ad¶»¸º".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 223);
        }
        String str = new String(charArray);
        char[] charArray2 = "¼³¶±¶«".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 223);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
