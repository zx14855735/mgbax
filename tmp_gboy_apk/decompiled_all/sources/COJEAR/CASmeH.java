package COJEAR;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CASmeH extends BpkvW3 {

    /* renamed from: A4TApA, reason: collision with root package name */
    public View f1658A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public WindowInsetsController f1659A5SV6n;

    /* JADX WARN: Type inference failed for: r4v0, types: [COJEAR.C4FrIb] */
    @Override // COJEAR.BpkvW3
    public final void A2egSU() {
        int ime;
        WindowInsetsController windowInsetsController = this.f1659A5SV6n;
        View view = this.f1658A4TApA;
        if (windowInsetsController == null) {
            windowInsetsController = view != null ? view.getWindowInsetsController() : null;
        }
        if (windowInsetsController == null) {
            super.A2egSU();
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ?? r4 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: COJEAR.C4FrIb
            @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
            public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i) {
                atomicBoolean.set((i & 8) != 0);
            }
        };
        windowInsetsController.addOnControllableInsetsChangedListener(r4);
        if (!atomicBoolean.get() && view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        windowInsetsController.removeOnControllableInsetsChangedListener(r4);
        ime = WindowInsets.Type.ime();
        windowInsetsController.hide(ime);
    }

    @Override // COJEAR.BpkvW3
    public final void A4TApA() {
        int ime;
        View view = this.f1658A4TApA;
        if (view != null && Build.VERSION.SDK_INT < 33) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
        }
        WindowInsetsController windowInsetsController = this.f1659A5SV6n;
        if (windowInsetsController == null) {
            windowInsetsController = view != null ? view.getWindowInsetsController() : null;
        }
        if (windowInsetsController == null) {
            super.A4TApA();
        } else {
            ime = WindowInsets.Type.ime();
            windowInsetsController.show(ime);
        }
    }
}
