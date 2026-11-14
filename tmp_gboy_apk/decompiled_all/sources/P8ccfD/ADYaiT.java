package P8ccfD;

import android.animation.AnimatorSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6963AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f6964AlLFFp;

    public /* synthetic */ ADYaiT(AzWtSf azWtSf, int i) {
        this.f6963AcNBzu = i;
        this.f6964AlLFFp = azWtSf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6963AcNBzu) {
            case 0:
                this.f6964AlLFFp.AcNBzu();
                break;
            case 1:
                AzWtSf azWtSf = this.f6964AlLFFp;
                azWtSf.f6991A5SV6n.setTranslationY(r1.getHeight());
                AnimatorSet ASJ6gh2 = azWtSf.ASJ6gh(true);
                ASJ6gh2.addListener(new AlLFFp(azWtSf, 2));
                ASJ6gh2.start();
                break;
            default:
                AzWtSf azWtSf2 = this.f6964AlLFFp;
                AnimatorSet ADYaiT2 = azWtSf2.ADYaiT(true);
                ADYaiT2.addListener(new AlLFFp(azWtSf2, 0));
                ADYaiT2.start();
                break;
        }
    }
}
