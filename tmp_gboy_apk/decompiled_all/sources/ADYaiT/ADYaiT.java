package ADYaiT;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ View f11AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ View f12AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f13AzWtSf;

    public /* synthetic */ ADYaiT(AcNBzu acNBzu, View view, View view2, int i) {
        this.f10AcNBzu = i;
        this.f13AzWtSf = acNBzu;
        this.f11AlLFFp = view;
        this.f12AmA8tU = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10AcNBzu) {
            case 0:
                AcNBzu.A4TApA(this.f13AzWtSf.f65B3GDIM, this.f11AlLFFp, this.f12AmA8tU);
                break;
            default:
                AcNBzu.A4TApA(this.f13AzWtSf.f53ARc23Z, this.f11AlLFFp, this.f12AmA8tU);
                break;
        }
    }
}
