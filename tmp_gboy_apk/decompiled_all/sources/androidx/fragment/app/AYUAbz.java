package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AYUAbz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f8736AcNBzu = 1;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f8737AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f8738AmA8tU;

    public /* synthetic */ AYUAbz(AaHO0E aaHO0E, DyaChj dyaChj) {
        this.f8737AlLFFp = aaHO0E;
        this.f8738AmA8tU = dyaChj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8736AcNBzu) {
            case 0:
                Dphsd2.ASJ6gh((Rect) this.f8738AmA8tU, (View) this.f8737AlLFFp);
                break;
            default:
                AaHO0E aaHO0E = (AaHO0E) this.f8737AlLFFp;
                RXb0Sz.ARc23Z.AMqCpz(aaHO0E, "$transitionInfo");
                DyaChj dyaChj = (DyaChj) this.f8738AmA8tU;
                RXb0Sz.ARc23Z.AMqCpz(dyaChj, "$operation");
                aaHO0E.A2egSU();
                if (CtxOCS.C4FrIb(2)) {
                    dyaChj.toString();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ AYUAbz(Dphsd2 dphsd2, View view, Rect rect) {
        this.f8737AlLFFp = view;
        this.f8738AmA8tU = rect;
    }
}
