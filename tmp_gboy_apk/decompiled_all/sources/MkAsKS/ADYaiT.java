package MkAsKS;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.game.boy.activity.LayoutEditor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A2egSU f5432A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Bitmap f5433A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Rect f5434A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public String f5435ADYaiT;
    public boolean AMqCpz = true;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f5436ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f5437ASJ6gh;

    public ADYaiT(A2egSU a2egSU, Bitmap bitmap, Rect rect) {
        this.f5432A2egSU = a2egSU;
        this.f5433A4TApA = bitmap;
        this.f5434A5SV6n = rect;
    }

    public final void A2egSU(int i, int i2, int i3, int i4) {
        Rect rect = this.f5434A5SV6n;
        if (rect.left == i && rect.top == i2 && rect.width() == i3 && rect.height() == i4) {
            return;
        }
        A2egSU a2egSU = this.f5432A2egSU;
        a2egSU.A4TApA(this);
        rect.left = i;
        rect.top = i2;
        rect.right = i + i3;
        rect.bottom = i2 + i4;
        if (a2egSU.f5422B25kr6 == this) {
            a2egSU.f5421AzWtSf.A2egSU();
        }
        a2egSU.A4TApA(this);
        ARc23Z aRc23Z = a2egSU.f5426B7CMnp;
        if (aRc23Z != null) {
            ((LayoutEditor) aRc23Z).f11055B25kr6 = true;
        }
    }
}
