package LHpdLt;

import com.bytedance.android.live.base.api.push.model.PushUIConfig;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4514AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ BTvldC f4515AlLFFp;

    public /* synthetic */ AmA8tU(BTvldC bTvldC, int i) {
        this.f4514AcNBzu = i;
        this.f4515AlLFFp = bTvldC;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BTvldC bTvldC;
        LLYwnm.AYUAbz aYUAbz;
        switch (this.f4514AcNBzu) {
            case 0:
                if (this.f4515AlLFFp.AMqCpz || !this.f4515AlLFFp.f4564ADYaiT) {
                    return;
                }
                try {
                    BTvldC bTvldC2 = this.f4515AlLFFp;
                    if (bTvldC2.f4593CASmeH && (aYUAbz = bTvldC2.f4598CTkVKb) != null && aYUAbz.f4626A2egSU.ADYaiT()) {
                        BTvldC.ADYaiT(this.f4515AlLFFp);
                    }
                } catch (Exception unused) {
                    if (this.f4515AlLFFp.AMqCpz || !this.f4515AlLFFp.f4564ADYaiT) {
                        return;
                    }
                    bTvldC = this.f4515AlLFFp;
                    if (bTvldC.f4597CSDoyG != this) {
                        return;
                    }
                } catch (Throwable th) {
                    if (!this.f4515AlLFFp.AMqCpz && this.f4515AlLFFp.f4564ADYaiT) {
                        BTvldC bTvldC3 = this.f4515AlLFFp;
                        if (bTvldC3.f4597CSDoyG == this) {
                            bTvldC3.f4596CQhlFr.postDelayed(this, PushUIConfig.dismissTime);
                        }
                    }
                    throw th;
                }
                if (this.f4515AlLFFp.AMqCpz || !this.f4515AlLFFp.f4564ADYaiT) {
                    return;
                }
                bTvldC = this.f4515AlLFFp;
                if (bTvldC.f4597CSDoyG != this) {
                    return;
                }
                bTvldC.f4596CQhlFr.postDelayed(this, PushUIConfig.dismissTime);
                return;
            case 1:
                this.f4515AlLFFp.AmA8tU();
                return;
            case 2:
                BTvldC bTvldC4 = this.f4515AlLFFp;
                try {
                    bTvldC4.B2KMhB();
                    bTvldC4.f4569AZkASS = bTvldC4.f4563A5SV6n.getWidth();
                    bTvldC4.f4570AaHO0E = bTvldC4.f4563A5SV6n.getHeight();
                    float max = Math.max(0, bTvldC4.f4567AYUAbz - bTvldC4.f4569AZkASS);
                    float max2 = Math.max(0, bTvldC4.f4568AZOQYO - bTvldC4.f4570AaHO0E);
                    bTvldC4.f4565ARc23Z = BTvldC.A2egSU(bTvldC4, bTvldC4.f4565ARc23Z, max);
                    bTvldC4.f4566ASJ6gh = BTvldC.A2egSU(bTvldC4, bTvldC4.f4566ASJ6gh, max2);
                    bTvldC4.f4563A5SV6n.setX(bTvldC4.f4565ARc23Z);
                    bTvldC4.f4563A5SV6n.setY(bTvldC4.f4566ASJ6gh);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            default:
                this.f4515AlLFFp.AZOQYO();
                return;
        }
    }
}
