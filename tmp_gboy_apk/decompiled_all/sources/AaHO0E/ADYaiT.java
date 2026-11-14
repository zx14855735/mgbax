package AaHO0E;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f600AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f601AlLFFp;

    public /* synthetic */ ADYaiT(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.f600AcNBzu = i;
        this.f601AlLFFp = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f600AcNBzu) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f601AlLFFp;
                actionBarOverlayLayout.A4TApA();
                actionBarOverlayLayout.f8130C4FrIb = actionBarOverlayLayout.f8112AzWtSf.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f8131CASmeH);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f601AlLFFp;
                actionBarOverlayLayout2.A4TApA();
                actionBarOverlayLayout2.f8130C4FrIb = actionBarOverlayLayout2.f8112AzWtSf.animate().translationY(-actionBarOverlayLayout2.f8112AzWtSf.getHeight()).setListener(actionBarOverlayLayout2.f8131CASmeH);
                break;
        }
    }
}
