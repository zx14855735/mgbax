package MkAsKS;

import android.graphics.Rect;
import com.game.boy.activity.LayoutEditor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A2egSU f5438A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ADYaiT f5439A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f5440A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f5441ADYaiT;

    public AMqCpz(A2egSU a2egSU, ADYaiT aDYaiT) {
        this.f5438A2egSU = a2egSU;
        this.f5439A4TApA = aDYaiT;
    }

    @Override // MkAsKS.A5SV6n
    public final void a() {
    }

    @Override // MkAsKS.A5SV6n
    public final void b(int i, int i2) {
        ADYaiT aDYaiT = this.f5439A4TApA;
        Rect rect = aDYaiT.f5434A5SV6n;
        int i3 = i - this.f5440A5SV6n;
        A2egSU a2egSU = this.f5438A2egSU;
        int A2egSU2 = A2egSU.A2egSU(a2egSU, i3, a2egSU.getWidth() - rect.width());
        int A2egSU3 = A2egSU.A2egSU(a2egSU, i2 - this.f5441ADYaiT, a2egSU.getHeight() - rect.height());
        if (A2egSU2 == rect.left && A2egSU3 == rect.top) {
            return;
        }
        a2egSU.A4TApA(aDYaiT);
        rect.offsetTo(A2egSU2, A2egSU3);
        a2egSU.f5421AzWtSf.A2egSU();
        a2egSU.A4TApA(aDYaiT);
        ARc23Z aRc23Z = a2egSU.f5426B7CMnp;
        if (aRc23Z != null) {
            ((LayoutEditor) aRc23Z).f11055B25kr6 = true;
        }
        a2egSU.cancelLongPress();
    }

    @Override // MkAsKS.A5SV6n
    public final void a(int i, int i2) {
        Rect rect = this.f5439A4TApA.f5434A5SV6n;
        this.f5440A5SV6n = i - rect.left;
        this.f5441ADYaiT = i2 - rect.top;
    }
}
