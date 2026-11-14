package androidx.activity;

import android.window.BackEvent;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final A2egSU f7934A2egSU = new A2egSU();

    static {
        BPnUo();
    }

    private static /* synthetic */ void BPnUo() {
        char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'i');
        }
        String str = new String(charArray);
        char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'i');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final BackEvent A2egSU(float f, float f2, float f3, int i) {
        return new BackEvent(f, f2, f3, i);
    }

    public final float A4TApA(BackEvent backEvent) {
        RXb0Sz.ARc23Z.AMqCpz(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int A5SV6n(BackEvent backEvent) {
        RXb0Sz.ARc23Z.AMqCpz(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float ADYaiT(BackEvent backEvent) {
        RXb0Sz.ARc23Z.AMqCpz(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float AMqCpz(BackEvent backEvent) {
        RXb0Sz.ARc23Z.AMqCpz(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
