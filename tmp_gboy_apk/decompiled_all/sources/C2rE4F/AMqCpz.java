package C2rE4F;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f1533A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ADYaiT f1534A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f1535A5SV6n;

    public final void A2egSU(ADYaiT aDYaiT) {
        synchronized (this) {
            while (this.f1535A5SV6n) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.f1534A4TApA == aDYaiT) {
                return;
            }
            this.f1534A4TApA = aDYaiT;
            if (this.f1533A2egSU) {
                aDYaiT.onCancel();
            }
        }
    }
}
