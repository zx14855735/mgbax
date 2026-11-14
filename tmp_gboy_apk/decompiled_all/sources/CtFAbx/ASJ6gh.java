package CtFAbx;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final AMqCpz f1890AmA8tU = new AMqCpz(1);

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final AMqCpz f1891AzWtSf = new AMqCpz(2);

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final AMqCpz f1892B25kr6 = new AMqCpz(3);

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final AMqCpz f1893B2KMhB = new AMqCpz(4);

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final AMqCpz f1894B3GDIM = new AMqCpz(5);

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final AMqCpz f1895B4ZgIw = new AMqCpz(0);

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Object f1899ADYaiT;
    public final com.bumptech.glide.AMqCpz AMqCpz;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f1902AYUAbz;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public AYUAbz f1905AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public float f1906AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f1907AlLFFp;

    /* renamed from: A2egSU, reason: collision with root package name */
    public float f1896A2egSU = 0.0f;

    /* renamed from: A4TApA, reason: collision with root package name */
    public float f1897A4TApA = Float.MAX_VALUE;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f1898A5SV6n = false;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f1900ARc23Z = false;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public long f1901ASJ6gh = 0;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ArrayList f1903AZOQYO = new ArrayList();

    /* renamed from: AZkASS, reason: collision with root package name */
    public final ArrayList f1904AZkASS = new ArrayList();

    static {
        oKlG();
    }

    public ASJ6gh(Object obj, com.bumptech.glide.AMqCpz aMqCpz) {
        this.f1899ADYaiT = obj;
        this.AMqCpz = aMqCpz;
        if (aMqCpz == f1892B25kr6 || aMqCpz == f1893B2KMhB || aMqCpz == f1894B3GDIM) {
            this.f1902AYUAbz = 0.1f;
        } else if (aMqCpz == f1895B4ZgIw) {
            this.f1902AYUAbz = 0.00390625f;
        } else if (aMqCpz == f1890AmA8tU || aMqCpz == f1891AzWtSf) {
            this.f1902AYUAbz = 0.002f;
        } else {
            this.f1902AYUAbz = 1.0f;
        }
        this.f1905AaHO0E = null;
        this.f1906AcNBzu = Float.MAX_VALUE;
        this.f1907AlLFFp = false;
    }

    public static ADYaiT A4TApA() {
        ThreadLocal threadLocal = ADYaiT.f1879AZOQYO;
        if (threadLocal.get() == null) {
            threadLocal.set(new ADYaiT(new K1Z3yj.A2egSU(10)));
        }
        return (ADYaiT) threadLocal.get();
    }

    private static /* synthetic */ void oKlG() {
        char[] charArray = "/#!b+-!)b.#5b?$)  b\u0006\"%\u000e>%(+)".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'L');
        }
        String str = new String(charArray);
        char[] charArray2 = "/ %\"%8".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'L');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r1v17, types: [CtFAbx.A4TApA, java.lang.Object] */
    public final void A2egSU(float f) {
        float durationScale;
        if (this.f1900ARc23Z) {
            this.f1906AcNBzu = f;
            return;
        }
        if (this.f1905AaHO0E == null) {
            this.f1905AaHO0E = new AYUAbz(f);
        }
        AYUAbz aYUAbz = this.f1905AaHO0E;
        double d = f;
        aYUAbz.f1915AZOQYO = d;
        double d2 = (float) d;
        if (d2 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d2 < -3.4028235E38f) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double abs = Math.abs(this.f1902AYUAbz * 0.75f);
        aYUAbz.f1911ADYaiT = abs;
        aYUAbz.AMqCpz = abs * 62.5d;
        K1Z3yj.A2egSU a2egSU = A4TApA().AMqCpz;
        a2egSU.getClass();
        if (Thread.currentThread() != ((Looper) a2egSU.f4175AmA8tU).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z = this.f1900ARc23Z;
        if (z || z) {
            return;
        }
        this.f1900ARc23Z = true;
        if (!this.f1898A5SV6n) {
            this.f1897A4TApA = this.AMqCpz.BniPrB(this.f1899ADYaiT);
        }
        float f2 = this.f1897A4TApA;
        if (f2 > Float.MAX_VALUE || f2 < -3.4028235E38f) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        ADYaiT A4TApA2 = A4TApA();
        ArrayList arrayList = A4TApA2.f1881A4TApA;
        if (arrayList.size() == 0) {
            K1Z3yj.A2egSU a2egSU2 = A4TApA2.AMqCpz;
            a2egSU2.getClass();
            ((Choreographer) a2egSU2.f4174AlLFFp).postFrameCallback(new A5SV6n(0, A4TApA2.f1883ADYaiT));
            if (Build.VERSION.SDK_INT >= 33) {
                durationScale = ValueAnimator.getDurationScale();
                A4TApA2.f1885ASJ6gh = durationScale;
                if (A4TApA2.f1886AYUAbz == null) {
                    A4TApA2.f1886AYUAbz = new K1Z3yj.A2egSU(9, A4TApA2);
                }
                final K1Z3yj.A2egSU a2egSU3 = A4TApA2.f1886AYUAbz;
                if (((A4TApA) a2egSU3.f4174AlLFFp) == null) {
                    ?? r1 = new ValueAnimator.DurationScaleChangeListener() { // from class: CtFAbx.A4TApA
                        @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                        public final void onChanged(float f3) {
                            ((ADYaiT) K1Z3yj.A2egSU.this.f4175AmA8tU).f1885ASJ6gh = f3;
                        }
                    };
                    a2egSU3.f4174AlLFFp = r1;
                    ValueAnimator.registerDurationScaleChangeListener(r1);
                }
            }
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public final void A5SV6n(float f) {
        this.AMqCpz.Cd8JRx(this.f1899ADYaiT, f);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f1904AZkASS;
            if (i >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i) != null) {
                arrayList.get(i).getClass();
                throw new ClassCastException();
            }
            i++;
        }
    }

    public final void ADYaiT() {
        if (this.f1905AaHO0E.f1909A4TApA <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        K1Z3yj.A2egSU a2egSU = A4TApA().AMqCpz;
        a2egSU.getClass();
        if (Thread.currentThread() != ((Looper) a2egSU.f4175AmA8tU).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f1900ARc23Z) {
            this.f1907AlLFFp = true;
        }
    }
}
