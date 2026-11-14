package ADYaiT;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CQhlFr implements Window.Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Window.Callback f124AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public D8cQ8b f125AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f126AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f127AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f128B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ CkXcdM f129B2KMhB;

    public CQhlFr(CkXcdM ckXcdM, Window.Callback callback) {
        this.f129B2KMhB = ckXcdM;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f124AcNBzu = callback;
    }

    public final void A2egSU(Window.Callback callback) {
        try {
            this.f126AmA8tU = true;
            callback.onContentChanged();
        } finally {
            this.f126AmA8tU = false;
        }
    }

    public final boolean A4TApA(int i, Menu menu) {
        return this.f124AcNBzu.onMenuOpened(i, menu);
    }

    public final void A5SV6n(int i, Menu menu) {
        this.f124AcNBzu.onPanelClosed(i, menu);
    }

    public final void ADYaiT(List list, Menu menu, int i) {
        AZOQYO.AmA8tU.A2egSU(this.f124AcNBzu, list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f124AcNBzu.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.f127AzWtSf;
        Window.Callback callback = this.f124AcNBzu;
        return z ? callback.dispatchKeyEvent(keyEvent) : this.f129B2KMhB.BChYOn(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (!this.f124AcNBzu.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            CkXcdM ckXcdM = this.f129B2KMhB;
            ckXcdM.BV3sI0();
            A2egSU a2egSU = ckXcdM.f161BNL6CD;
            if (a2egSU == null || !a2egSU.AZOQYO(keyCode, keyEvent)) {
                CikNvS cikNvS = ckXcdM.f184D07BeM;
                if (cikNvS == null || !ckXcdM.C4FrIb(cikNvS, keyEvent.getKeyCode(), keyEvent)) {
                    if (ckXcdM.f184D07BeM == null) {
                        CikNvS BTvldC2 = ckXcdM.BTvldC(0);
                        ckXcdM.CASmeH(BTvldC2, keyEvent);
                        boolean C4FrIb2 = ckXcdM.C4FrIb(BTvldC2, keyEvent.getKeyCode(), keyEvent);
                        BTvldC2.f147AaHO0E = false;
                        if (C4FrIb2) {
                        }
                    }
                    return false;
                }
                CikNvS cikNvS2 = ckXcdM.f184D07BeM;
                if (cikNvS2 != null) {
                    cikNvS2.f148AcNBzu = true;
                    return true;
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f124AcNBzu.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f124AcNBzu.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f124AcNBzu.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f124AcNBzu.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f124AcNBzu.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f124AcNBzu.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f126AmA8tU) {
            this.f124AcNBzu.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof AZkASS.AmA8tU)) {
            return this.f124AcNBzu.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        D8cQ8b d8cQ8b = this.f125AlLFFp;
        if (d8cQ8b != null) {
            View view = i == 0 ? new View(d8cQ8b.f221AcNBzu.f224A2egSU.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.f124AcNBzu.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f124AcNBzu.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f124AcNBzu.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        A4TApA(i, menu);
        CkXcdM ckXcdM = this.f129B2KMhB;
        if (i != 108) {
            ckXcdM.getClass();
            return true;
        }
        ckXcdM.BV3sI0();
        A2egSU a2egSU = ckXcdM.f161BNL6CD;
        if (a2egSU != null) {
            a2egSU.A5SV6n(true);
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.f128B25kr6) {
            this.f124AcNBzu.onPanelClosed(i, menu);
            return;
        }
        A5SV6n(i, menu);
        CkXcdM ckXcdM = this.f129B2KMhB;
        if (i == 108) {
            ckXcdM.BV3sI0();
            A2egSU a2egSU = ckXcdM.f161BNL6CD;
            if (a2egSU != null) {
                a2egSU.A5SV6n(false);
                return;
            }
            return;
        }
        if (i != 0) {
            ckXcdM.getClass();
            return;
        }
        CikNvS BTvldC2 = ckXcdM.BTvldC(i);
        if (BTvldC2.f149AlLFFp) {
            ckXcdM.B7CMnp(BTvldC2, false);
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        AZOQYO.AzWtSf.A2egSU(this.f124AcNBzu, z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        AZkASS.AmA8tU amA8tU = menu instanceof AZkASS.AmA8tU ? (AZkASS.AmA8tU) menu : null;
        if (i == 0 && amA8tU == null) {
            return false;
        }
        if (amA8tU != null) {
            amA8tU.f516CNPG0E = true;
        }
        D8cQ8b d8cQ8b = this.f125AlLFFp;
        if (d8cQ8b != null && i == 0) {
            DAk1zC dAk1zC = d8cQ8b.f221AcNBzu;
            if (!dAk1zC.f227ADYaiT) {
                dAk1zC.f224A2egSU.f908AcNBzu = true;
                dAk1zC.f227ADYaiT = true;
            }
        }
        boolean onPreparePanel = this.f124AcNBzu.onPreparePanel(i, view, menu);
        if (amA8tU != null) {
            amA8tU.f516CNPG0E = false;
        }
        return onPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        AZkASS.AmA8tU amA8tU = this.f129B2KMhB.BTvldC(0).f144AYUAbz;
        if (amA8tU != null) {
            ADYaiT(list, amA8tU, i);
        } else {
            ADYaiT(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return AZOQYO.AlLFFp.A2egSU(this.f124AcNBzu, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f124AcNBzu.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.f124AcNBzu.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        CkXcdM ckXcdM = this.f129B2KMhB;
        ckXcdM.getClass();
        if (i != 0) {
            return AZOQYO.AlLFFp.A4TApA(this.f124AcNBzu, callback, i);
        }
        AZOQYO.ARc23Z aRc23Z = new AZOQYO.ARc23Z(ckXcdM.f157BChYOn, callback);
        AZOQYO.A4TApA AmA8tU2 = ckXcdM.AmA8tU(aRc23Z);
        if (AmA8tU2 != null) {
            return aRc23Z.A5SV6n(AmA8tU2);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f124AcNBzu.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        CkXcdM ckXcdM = this.f129B2KMhB;
        ckXcdM.getClass();
        AZOQYO.ARc23Z aRc23Z = new AZOQYO.ARc23Z(ckXcdM.f157BChYOn, callback);
        AZOQYO.A4TApA AmA8tU2 = ckXcdM.AmA8tU(aRc23Z);
        if (AmA8tU2 != null) {
            return aRc23Z.A5SV6n(AmA8tU2);
        }
        return null;
    }
}
