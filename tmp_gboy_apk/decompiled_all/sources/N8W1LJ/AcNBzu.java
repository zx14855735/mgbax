package N8W1LJ;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final float f5558AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final float f5559AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final long f5560AmA8tU = System.currentTimeMillis();

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final float f5561AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final float f5562B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ AmA8tU f5563B2KMhB;

    public AcNBzu(AmA8tU amA8tU, float f, float f2, float f3, float f4) {
        this.f5563B2KMhB = amA8tU;
        this.f5558AcNBzu = f3;
        this.f5559AlLFFp = f4;
        this.f5561AzWtSf = f;
        this.f5562B25kr6 = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AmA8tU amA8tU = this.f5563B2KMhB;
        float interpolation = amA8tU.f5568AcNBzu.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f5560AmA8tU) * 1.0f) / amA8tU.f5569AlLFFp));
        float f = this.f5562B25kr6;
        float f2 = this.f5561AzWtSf;
        amA8tU.f5590CASmeH.B4ZgIw(CtFAbx.A4TApA(f, f2, interpolation, f2) / amA8tU.ADYaiT(), this.f5558AcNBzu, this.f5559AlLFFp);
        if (interpolation < 1.0f) {
            amA8tU.f5575B4ZgIw.postOnAnimation(this);
        }
    }
}
