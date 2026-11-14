package NSK3xo;

import android.os.Looper;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AcNBzu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final Set f5944AcNBzu = Collections.newSetFromMap(new WeakHashMap());

    static {
        EtXiwx();
    }

    private static /* synthetic */ void EtXiwx() {
        char[] charArray = "ßÓÑ\u0092ÛÝÑÙ\u0092ÞÓÅ\u0092ÏÔÙÐÐ\u0092öÒÕþÎÕØÛÙ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 188);
        }
        String str = new String(charArray);
        char[] charArray2 = "ßÐÕÒÕÈ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 188);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public NCeV4Q.ASJ6gh A5SV6n(NCeV4Q.ASJ6gh aSJ6gh) {
        throw new UnsupportedOperationException();
    }

    public boolean ADYaiT(NCeV4Q.A5SV6n a5SV6n) {
        throw new UnsupportedOperationException();
    }

    public Looper AMqCpz() {
        throw new UnsupportedOperationException();
    }

    public void ARc23Z() {
        throw new UnsupportedOperationException();
    }

    public abstract void ASJ6gh();
}
