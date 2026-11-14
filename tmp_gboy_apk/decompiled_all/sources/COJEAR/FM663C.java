package COJEAR;

import android.view.View;
import android.view.Window;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FM663C extends JrXYwF.A4TApA {

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Window f1748AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final KCxDWD.A5SV6n f1749AaHO0E;

    public FM663C(Window window, KCxDWD.A5SV6n a5SV6n) {
        this.f1748AZkASS = window;
        this.f1749AaHO0E = a5SV6n;
    }

    @Override // JrXYwF.A4TApA
    public final void CTkVKb() {
        for (int i = 1; i <= 256; i <<= 1) {
            if ((8 & i) != 0) {
                if (i == 1) {
                    EY4UKY(4);
                } else if (i == 2) {
                    EY4UKY(2);
                } else if (i == 8) {
                    ((BpkvW3) this.f1749AaHO0E.f4241AlLFFp).A2egSU();
                }
            }
        }
    }

    @Override // JrXYwF.A4TApA
    public final void DXnQ0V() {
        for (int i = 1; i <= 256; i <<= 1) {
            if ((8 & i) != 0) {
                if (i == 1) {
                    EdQ5bb(4);
                    this.f1748AZkASS.clearFlags(1024);
                } else if (i == 2) {
                    EdQ5bb(2);
                } else if (i == 8) {
                    ((BpkvW3) this.f1749AaHO0E.f4241AlLFFp).A4TApA();
                }
            }
        }
    }

    public final void EY4UKY(int i) {
        View decorView = this.f1748AZkASS.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public final void EdQ5bb(int i) {
        View decorView = this.f1748AZkASS.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
