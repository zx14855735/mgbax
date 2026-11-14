package CrfGsy;

import ADYaiT.D8MqeW;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends CqNSpT.AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f1870A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public CqNSpT.ARc23Z f1871A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final D8MqeW f1872A5SV6n = new D8MqeW(7, this);

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f1873ADYaiT;

    public ARc23Z(DrawerLayout drawerLayout, int i) {
        this.f1873ADYaiT = drawerLayout;
        this.f1870A2egSU = i;
    }

    @Override // CqNSpT.AMqCpz
    public final int A2egSU(int i, View view) {
        DrawerLayout drawerLayout = this.f1873ADYaiT;
        if (drawerLayout.A4TApA(3, view)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = drawerLayout.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    @Override // CqNSpT.AMqCpz
    public final int A4TApA(int i, View view) {
        return view.getTop();
    }

    @Override // CqNSpT.AMqCpz
    public final int A5SV6n(View view) {
        if (DrawerLayout.AlLFFp(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // CqNSpT.AMqCpz
    public final void AMqCpz(int i, int i2) {
        int i3 = i & 1;
        DrawerLayout drawerLayout = this.f1873ADYaiT;
        View AMqCpz = i3 == 1 ? drawerLayout.AMqCpz(3) : drawerLayout.AMqCpz(5);
        if (AMqCpz == null || drawerLayout.AYUAbz(AMqCpz) != 0) {
            return;
        }
        this.f1871A4TApA.A4TApA(AMqCpz, i2);
    }

    @Override // CqNSpT.AMqCpz
    public final void ARc23Z() {
        this.f1873ADYaiT.postDelayed(this.f1872A5SV6n, 160L);
    }

    @Override // CqNSpT.AMqCpz
    public final void ASJ6gh(int i, View view) {
        ((ADYaiT) view.getLayoutParams()).f1863A5SV6n = false;
        int i2 = this.f1870A2egSU == 3 ? 5 : 3;
        DrawerLayout drawerLayout = this.f1873ADYaiT;
        View AMqCpz = drawerLayout.AMqCpz(i2);
        if (AMqCpz != null) {
            drawerLayout.A5SV6n(AMqCpz, true);
        }
    }

    @Override // CqNSpT.AMqCpz
    public final void AYUAbz(int i) {
        this.f1873ADYaiT.B4ZgIw(i, this.f1871A4TApA.f1855B7CMnp);
    }

    @Override // CqNSpT.AMqCpz
    public final void AZOQYO(View view, int i, int i2) {
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.f1873ADYaiT;
        float width2 = (drawerLayout.A4TApA(3, view) ? i + width : drawerLayout.getWidth() - i) / width;
        drawerLayout.B25kr6(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        drawerLayout.invalidate();
    }

    @Override // CqNSpT.AMqCpz
    public final void AZkASS(View view, float f, float f2) {
        int i;
        DrawerLayout drawerLayout = this.f1873ADYaiT;
        int[] iArr = DrawerLayout.f8614CcAIMM;
        float f3 = ((ADYaiT) view.getLayoutParams()).f1862A4TApA;
        int width = view.getWidth();
        if (drawerLayout.A4TApA(3, view)) {
            i = (f > 0.0f || (f == 0.0f && f3 > 0.5f)) ? 0 : -width;
        } else {
            int width2 = drawerLayout.getWidth();
            if (f < 0.0f || (f == 0.0f && f3 > 0.5f)) {
                width2 -= width;
            }
            i = width2;
        }
        this.f1871A4TApA.B25kr6(i, view.getTop());
        drawerLayout.invalidate();
    }

    @Override // CqNSpT.AMqCpz
    public final boolean AaHO0E(View view, int i) {
        DrawerLayout drawerLayout = this.f1873ADYaiT;
        return DrawerLayout.AlLFFp(view) && drawerLayout.A4TApA(this.f1870A2egSU, view) && drawerLayout.AYUAbz(view) == 0;
    }
}
