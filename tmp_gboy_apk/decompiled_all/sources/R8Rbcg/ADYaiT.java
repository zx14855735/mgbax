package R8Rbcg;

import RXb0Sz.ARc23Z;
import androidx.activity.AzWtSf;
import androidx.lifecycle.CQhlFr;
import androidx.lifecycle.D07BeM;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ADYaiT implements Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AzWtSf f7829AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public volatile Object f7830AlLFFp = AMqCpz.f7832A4TApA;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f7831AmA8tU = this;

    public ADYaiT(AzWtSf azWtSf) {
        this.f7829AcNBzu = azWtSf;
    }

    public final Object A2egSU() {
        Object obj;
        Object obj2 = this.f7830AlLFFp;
        AMqCpz aMqCpz = AMqCpz.f7832A4TApA;
        if (obj2 != aMqCpz) {
            return obj2;
        }
        synchronized (this.f7831AmA8tU) {
            obj = this.f7830AlLFFp;
            if (obj == aMqCpz) {
                AzWtSf azWtSf = this.f7829AcNBzu;
                ARc23Z.A4TApA(azWtSf);
                obj = CQhlFr.AMqCpz((D07BeM) azWtSf.f7959AmA8tU);
                this.f7830AlLFFp = obj;
                this.f7829AcNBzu = null;
            }
        }
        return obj;
    }

    public final String toString() {
        return this.f7830AlLFFp != AMqCpz.f7832A4TApA ? String.valueOf(A2egSU()) : "Lazy value not initialized yet.";
    }
}
