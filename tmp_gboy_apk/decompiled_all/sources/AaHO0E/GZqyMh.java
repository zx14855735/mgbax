package AaHO0E;

import androidx.appcompat.widget.Toolbar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class GZqyMh implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f886AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Toolbar f887AlLFFp;

    public /* synthetic */ GZqyMh(Toolbar toolbar, int i) {
        this.f886AcNBzu = i;
        this.f887AlLFFp = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f886AcNBzu) {
            case 0:
                GhvxjZ ghvxjZ = this.f887AlLFFp.f8256D07BeM;
                AZkASS.B25kr6 b25kr6 = ghvxjZ == null ? null : ghvxjZ.f889AlLFFp;
                if (b25kr6 != null) {
                    b25kr6.collapseActionView();
                    break;
                }
                break;
            default:
                this.f887AlLFFp.AmA8tU();
                break;
        }
    }
}
