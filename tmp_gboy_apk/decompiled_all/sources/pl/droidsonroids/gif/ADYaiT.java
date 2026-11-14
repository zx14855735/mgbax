package pl.droidsonroids.gif;

import ADYaiT.AZkASS;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ADYaiT extends AMqCpz {
    @Override // pl.droidsonroids.gif.AMqCpz
    public final void A2egSU() {
        A5SV6n a5SV6n = this.f14093AcNBzu;
        long AaHO0E2 = a5SV6n.f14081B3GDIM.AaHO0E(a5SV6n.f14080B2KMhB);
        if (AaHO0E2 >= 0) {
            this.f14093AcNBzu.f14077AmA8tU = SystemClock.uptimeMillis() + AaHO0E2;
            if (this.f14093AcNBzu.isVisible() && this.f14093AcNBzu.f14076AlLFFp) {
                A5SV6n a5SV6n2 = this.f14093AcNBzu;
                if (!a5SV6n2.f14086BI9f7h) {
                    a5SV6n2.f14075AcNBzu.remove(this);
                    A5SV6n a5SV6n3 = this.f14093AcNBzu;
                    a5SV6n3.f14090BPw6Q8 = a5SV6n3.f14075AcNBzu.schedule(this, AaHO0E2, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f14093AcNBzu.f14082B4ZgIw.isEmpty() && this.f14093AcNBzu.f14081B3GDIM.A2egSU() == this.f14093AcNBzu.f14081B3GDIM.AYUAbz() - 1) {
                A5SV6n a5SV6n4 = this.f14093AcNBzu;
                AZkASS aZkASS = a5SV6n4.f14087BIYEnU;
                GifInfoHandle gifInfoHandle = a5SV6n4.f14081B3GDIM;
                int A4TApA2 = gifInfoHandle.A4TApA();
                if (A4TApA2 != 0 && A4TApA2 >= gifInfoHandle.ARc23Z()) {
                    A4TApA2--;
                }
                aZkASS.sendEmptyMessageAtTime(A4TApA2, this.f14093AcNBzu.f14077AmA8tU);
            }
        } else {
            A5SV6n a5SV6n5 = this.f14093AcNBzu;
            a5SV6n5.f14077AmA8tU = Long.MIN_VALUE;
            a5SV6n5.f14076AlLFFp = false;
        }
        if (!this.f14093AcNBzu.isVisible() || this.f14093AcNBzu.f14087BIYEnU.hasMessages(-1)) {
            return;
        }
        this.f14093AcNBzu.f14087BIYEnU.sendEmptyMessageAtTime(-1, 0L);
    }
}
