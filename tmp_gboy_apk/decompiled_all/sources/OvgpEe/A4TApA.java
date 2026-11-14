package OvgpEe;

import android.os.SystemClock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6821AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ADYaiT f6822AlLFFp;

    public /* synthetic */ A4TApA(ADYaiT aDYaiT, int i) {
        this.f6821AcNBzu = i;
        this.f6822AlLFFp = aDYaiT;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6821AcNBzu) {
            case 0:
                ADYaiT aDYaiT = this.f6822AlLFFp;
                if (aDYaiT.f6828AzWtSf > 0) {
                    SystemClock.uptimeMillis();
                }
                aDYaiT.setVisibility(0);
                break;
            default:
                ADYaiT aDYaiT2 = this.f6822AlLFFp;
                ((ASJ6gh) aDYaiT2.getCurrentDrawable()).ADYaiT(false, false, true);
                if ((aDYaiT2.getProgressDrawable() == null || !aDYaiT2.getProgressDrawable().isVisible()) && (aDYaiT2.getIndeterminateDrawable() == null || !aDYaiT2.getIndeterminateDrawable().isVisible())) {
                    aDYaiT2.setVisibility(4);
                }
                aDYaiT2.getClass();
                break;
        }
    }
}
