package McNXgv;

import KpHwm4.B25kr6;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA extends Thread {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B25kr6 f5283AcNBzu;

    public A4TApA(B25kr6 b25kr6) {
        this.f5283AcNBzu = b25kr6;
    }

    public abstract void A2egSU();

    public abstract int A4TApA();

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        try {
            try {
                i = A4TApA();
            } catch (Exception e) {
                e.printStackTrace();
                A2egSU();
                i = -1;
            }
            this.f5283AcNBzu.f4350A2egSU.obtainMessage(2, i, 0).sendToTarget();
        } finally {
            A2egSU();
        }
    }
}
