package Mm8v1u;

import android.view.View;
import android.view.animation.AccelerateInterpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5501AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ BChYOn f5502AlLFFp;

    public /* synthetic */ AmA8tU(BChYOn bChYOn, int i) {
        this.f5501AcNBzu = i;
        this.f5502AlLFFp = bChYOn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5501AcNBzu) {
            case 0:
                BChYOn bChYOn = this.f5502AlLFFp;
                bChYOn.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator()).withEndAction(new B2KMhB(bChYOn, 0)).start();
                break;
            default:
                BChYOn.A2egSU(this.f5502AlLFFp);
                break;
        }
    }
}
