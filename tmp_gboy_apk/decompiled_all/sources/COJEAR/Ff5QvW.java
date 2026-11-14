package COJEAR;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Ff5QvW {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final JrXYwF.A4TApA f1753A2egSU;

    public Ff5QvW(WindowInsetsController windowInsetsController) {
        this.f1753A2egSU = new FdMWEC(windowInsetsController, new KCxDWD.A5SV6n(windowInsetsController));
    }

    public Ff5QvW(Window window, View view) {
        WindowInsetsController insetsController;
        KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            insetsController = window.getInsetsController();
            FdMWEC fdMWEC = new FdMWEC(insetsController, a5SV6n);
            fdMWEC.f1752AcNBzu = window;
            this.f1753A2egSU = fdMWEC;
            return;
        }
        if (i >= 26) {
            this.f1753A2egSU = new FSFw2u(window, a5SV6n);
        } else if (i >= 23) {
            this.f1753A2egSU = new FOAO9d(window, a5SV6n);
        } else {
            this.f1753A2egSU = new FM663C(window, a5SV6n);
        }
    }
}
