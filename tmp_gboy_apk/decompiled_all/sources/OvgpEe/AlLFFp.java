package OvgpEe;

import ADYaiT.CcAIMM;
import AaHO0E.GEYgCP;
import android.animation.ObjectAnimator;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp extends CcAIMM {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final GEYgCP f6888B7CMnp = new GEYgCP(Float.class, "animationFraction", 10);

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ObjectAnimator f6889AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final D8cQ8b.A4TApA f6890AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final B25kr6 f6891B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f6892B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f6893B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public float f6894B4ZgIw;

    static {
        PTDGW();
    }

    public AlLFFp(B25kr6 b25kr6) {
        super(3);
        this.f6892B2KMhB = 1;
        this.f6891B25kr6 = b25kr6;
        this.f6890AzWtSf = new D8cQ8b.A4TApA();
    }

    private static /* synthetic */ void PTDGW() {
        char[] charArray = "\u0001\r\u000fL\u0005\u0003\u000f\u0007L\u0000\r\u001bL\u0011\n\u0007\u000e\u000eL(\f\u000b \u0010\u000b\u0006\u0005\u0007".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'b');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0001\u000e\u000b\f\u000b\u0016".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // ADYaiT.CcAIMM
    public final void A5SV6n() {
        ObjectAnimator objectAnimator = this.f6889AmA8tU;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // ADYaiT.CcAIMM
    public final void AZOQYO() {
        B25kr6();
        this.f6889AmA8tU.setDuration((long) (this.f6891B25kr6.f6920AmA8tU * 333.0f));
        B2KMhB();
    }

    @Override // ADYaiT.CcAIMM
    public final void AaHO0E(A5SV6n a5SV6n) {
    }

    @Override // ADYaiT.CcAIMM
    public final void AcNBzu() {
    }

    @Override // ADYaiT.CcAIMM
    public final void AmA8tU() {
        B25kr6();
        B2KMhB();
        this.f6889AmA8tU.start();
    }

    @Override // ADYaiT.CcAIMM
    public final void AzWtSf() {
    }

    public final void B25kr6() {
        if (this.f6889AmA8tU == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f6888B7CMnp, 0.0f, 1.0f);
            this.f6889AmA8tU = ofFloat;
            ofFloat.setDuration((long) (this.f6891B25kr6.f6920AmA8tU * 333.0f));
            this.f6889AmA8tU.setInterpolator(null);
            this.f6889AmA8tU.setRepeatCount(-1);
            this.f6889AmA8tU.addListener(new AaHO0E.A5SV6n(11, this));
        }
    }

    public final void B2KMhB() {
        this.f6893B3GDIM = true;
        this.f6892B2KMhB = 1;
        Iterator it = ((ArrayList) this.f136AlLFFp).iterator();
        while (it.hasNext()) {
            AYUAbz aYUAbz = (AYUAbz) it.next();
            B25kr6 b25kr6 = this.f6891B25kr6;
            aYUAbz.f6865A5SV6n = b25kr6.AMqCpz[0];
            aYUAbz.f6866ADYaiT = b25kr6.f6915AZOQYO / 2;
        }
    }
}
