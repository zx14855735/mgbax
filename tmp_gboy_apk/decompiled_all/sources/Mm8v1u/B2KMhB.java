package Mm8v1u;

import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B2KMhB implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5504AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ BChYOn f5505AlLFFp;

    public /* synthetic */ B2KMhB(BChYOn bChYOn, int i) {
        this.f5504AcNBzu = i;
        this.f5505AlLFFp = bChYOn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5504AcNBzu) {
            case 0:
                BChYOn bChYOn = this.f5505AlLFFp;
                if (bChYOn.getParent() != null) {
                    ((ViewGroup) bChYOn.getParent()).removeView(bChYOn);
                    break;
                }
                break;
            default:
                this.f5505AlLFFp.f5515AzWtSf.setVisibility(8);
                break;
        }
    }
}
