package COJEAR;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.fl.saas.videocache.ProxyCacheUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class FdMWEC extends JrXYwF.A4TApA {

    /* renamed from: AZkASS, reason: collision with root package name */
    public final WindowInsetsController f1750AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final KCxDWD.A5SV6n f1751AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Window f1752AcNBzu;

    public FdMWEC(WindowInsetsController windowInsetsController, KCxDWD.A5SV6n a5SV6n) {
        new B25kr6.AzWtSf();
        this.f1750AZkASS = windowInsetsController;
        this.f1751AaHO0E = a5SV6n;
    }

    @Override // JrXYwF.A4TApA
    public final void CTkVKb() {
        ((BpkvW3) this.f1751AaHO0E.f4241AlLFFp).A2egSU();
        this.f1750AZkASS.hide(0);
    }

    @Override // JrXYwF.A4TApA
    public final boolean CcAIMM() {
        int systemBarsAppearance;
        this.f1750AZkASS.setSystemBarsAppearance(0, 0);
        systemBarsAppearance = this.f1750AZkASS.getSystemBarsAppearance();
        return (systemBarsAppearance & 8) != 0;
    }

    @Override // JrXYwF.A4TApA
    public final void D6DOie(boolean z) {
        Window window = this.f1752AcNBzu;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f1750AZkASS.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f1750AZkASS.setSystemBarsAppearance(0, 16);
    }

    @Override // JrXYwF.A4TApA
    public final void D6yqiO(boolean z) {
        Window window = this.f1752AcNBzu;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            }
            this.f1750AZkASS.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f1750AZkASS.setSystemBarsAppearance(0, 8);
    }

    @Override // JrXYwF.A4TApA
    public final void DXnQ0V() {
        ((BpkvW3) this.f1751AaHO0E.f4241AlLFFp).A4TApA();
        this.f1750AZkASS.show(0);
    }
}
