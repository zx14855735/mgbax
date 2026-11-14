package androidx.lifecycle;

import android.os.Handler;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class C2rE4F implements B9tovu {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final C2rE4F f8999B7CMnp = new C2rE4F();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f9000AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f9001AlLFFp;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Handler f9004B25kr6;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f9002AmA8tU = true;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f9003AzWtSf = true;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final BI9f7h f9005B2KMhB = new BI9f7h(this);

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final CtFAbx.A2egSU f9006B3GDIM = new CtFAbx.A2egSU(21, this);

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final NGepWW.A2egSU f9007B4ZgIw = new NGepWW.A2egSU(10, this);

    static {
        JrqCn();
    }

    private static /* synthetic */ void JrqCn() {
        char[] charArray = "\u007fsq2{}qy2~se2otypp2Vru^nux{y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 28);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u007fpuruh".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 28);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU() {
        int i = this.f9001AlLFFp + 1;
        this.f9001AlLFFp = i;
        if (i == 1) {
            if (this.f9002AmA8tU) {
                this.f9005B2KMhB.ARc23Z(AlLFFp.ON_RESUME);
                this.f9002AmA8tU = false;
            } else {
                Handler handler = this.f9004B25kr6;
                RXb0Sz.ARc23Z.A4TApA(handler);
                handler.removeCallbacks(this.f9006B3GDIM);
            }
        }
    }

    @Override // androidx.lifecycle.B9tovu
    public final AzWtSf getLifecycle() {
        return this.f9005B2KMhB;
    }
}
