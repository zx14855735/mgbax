package HIguqb;

import android.os.Handler;
import android.os.RemoteException;
import com.game.boy.activity.EmulatorActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final EmulatorActivity f3363A4TApA;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f3365ADYaiT = false;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public AlLFFp f3368AYUAbz = null;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final A2egSU f3366ARc23Z = new A2egSU(this);

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final A4TApA f3367ASJ6gh = new A4TApA(this);

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final A5SV6n f3369AZOQYO = new A5SV6n(this);

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f3362A2egSU = 6;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Handler f3364A5SV6n = null;
    public LQ734U.A5SV6n AMqCpz = null;

    public ADYaiT(EmulatorActivity emulatorActivity) {
        this.f3363A4TApA = emulatorActivity;
    }

    public final void A2egSU() {
        AlLFFp alLFFp;
        A2egSU a2egSU = this.f3366ARc23Z;
        if (this.AMqCpz == null || (alLFFp = this.f3368AYUAbz) == null) {
            return;
        }
        try {
            try {
                ((AaHO0E) alLFFp).B3GDIM(a2egSU, this.f3362A2egSU);
            } catch (RemoteException unused) {
                ((AaHO0E) this.f3368AYUAbz).AMqCpz(a2egSU, this.f3362A2egSU);
            }
        } catch (RemoteException unused2) {
        }
    }

    public final void A4TApA(int i) {
        AlLFFp alLFFp = this.f3368AYUAbz;
        if (alLFFp != null) {
            try {
                ((AaHO0E) alLFFp).B25kr6(i);
            } catch (RemoteException unused) {
            }
        }
    }

    public final void A5SV6n(LQ734U.A5SV6n a5SV6n, Handler handler) {
        AlLFFp alLFFp = this.f3368AYUAbz;
        if (alLFFp != null) {
            try {
                ((AaHO0E) alLFFp).AmA8tU(this.f3366ARc23Z, this.f3362A2egSU);
            } catch (RemoteException unused) {
            }
        }
        this.AMqCpz = a5SV6n;
        this.f3364A5SV6n = handler;
        A2egSU();
    }
}
