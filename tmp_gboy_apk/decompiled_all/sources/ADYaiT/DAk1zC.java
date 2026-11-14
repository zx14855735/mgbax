package ADYaiT;

import AaHO0E.GhvxjZ;
import AaHO0E.H6qKiO;
import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DAk1zC extends A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final H6qKiO f224A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final CQhlFr f225A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final D8cQ8b f226A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f227ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f228ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final ArrayList f229ASJ6gh = new ArrayList();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final D8MqeW f230AYUAbz = new D8MqeW(0, this);

    public DAk1zC(Toolbar toolbar, CharSequence charSequence, CQhlFr cQhlFr) {
        D8cQ8b d8cQ8b = new D8cQ8b(this);
        H6qKiO h6qKiO = new H6qKiO(toolbar, false);
        this.f224A2egSU = h6qKiO;
        cQhlFr.getClass();
        this.f225A4TApA = cQhlFr;
        h6qKiO.f907AaHO0E = cQhlFr;
        toolbar.setOnMenuItemClickListener(d8cQ8b);
        if (!h6qKiO.f903ASJ6gh) {
            h6qKiO.f904AYUAbz = charSequence;
            if ((h6qKiO.f899A4TApA & 8) != 0) {
                Toolbar toolbar2 = h6qKiO.f898A2egSU;
                toolbar2.setTitle(charSequence);
                if (h6qKiO.f903ASJ6gh) {
                    COJEAR.DG07BK.B7CMnp(toolbar2.getRootView(), charSequence);
                }
            }
        }
        this.f226A5SV6n = new D8cQ8b(this);
    }

    @Override // ADYaiT.A2egSU
    public final boolean A2egSU() {
        AaHO0E.AzWtSf azWtSf;
        ActionMenuView actionMenuView = this.f224A2egSU.f898A2egSU.f8219AcNBzu;
        return (actionMenuView == null || (azWtSf = actionMenuView.f8140BniPrB) == null || !azWtSf.AcNBzu()) ? false : true;
    }

    @Override // ADYaiT.A2egSU
    public final boolean A4TApA() {
        AZkASS.B25kr6 b25kr6;
        GhvxjZ ghvxjZ = this.f224A2egSU.f898A2egSU.f8256D07BeM;
        if (ghvxjZ == null || (b25kr6 = ghvxjZ.f889AlLFFp) == null) {
            return false;
        }
        if (ghvxjZ == null) {
            b25kr6 = null;
        }
        if (b25kr6 == null) {
            return true;
        }
        b25kr6.collapseActionView();
        return true;
    }

    @Override // ADYaiT.A2egSU
    public final void A5SV6n(boolean z) {
        if (z == this.f228ARc23Z) {
            return;
        }
        this.f228ARc23Z = z;
        ArrayList arrayList = this.f229ASJ6gh;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // ADYaiT.A2egSU
    public final int ADYaiT() {
        return this.f224A2egSU.f899A4TApA;
    }

    @Override // ADYaiT.A2egSU
    public final Context AMqCpz() {
        return this.f224A2egSU.getContext();
    }

    @Override // ADYaiT.A2egSU
    public final boolean ARc23Z() {
        H6qKiO h6qKiO = this.f224A2egSU;
        Toolbar toolbar = h6qKiO.f898A2egSU;
        D8MqeW d8MqeW = this.f230AYUAbz;
        toolbar.removeCallbacks(d8MqeW);
        Toolbar toolbar2 = h6qKiO.f898A2egSU;
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        toolbar2.postOnAnimation(d8MqeW);
        return true;
    }

    @Override // ADYaiT.A2egSU
    public final void ASJ6gh() {
    }

    @Override // ADYaiT.A2egSU
    public final void AYUAbz() {
        this.f224A2egSU.f898A2egSU.removeCallbacks(this.f230AYUAbz);
    }

    @Override // ADYaiT.A2egSU
    public final boolean AZOQYO(int i, KeyEvent keyEvent) {
        Menu B4ZgIw2 = B4ZgIw();
        if (B4ZgIw2 == null) {
            return false;
        }
        B4ZgIw2.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return B4ZgIw2.performShortcut(i, keyEvent, 0);
    }

    @Override // ADYaiT.A2egSU
    public final boolean AZkASS(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            AaHO0E();
        }
        return true;
    }

    @Override // ADYaiT.A2egSU
    public final boolean AaHO0E() {
        return this.f224A2egSU.f898A2egSU.BChYOn();
    }

    @Override // ADYaiT.A2egSU
    public final void AcNBzu(boolean z) {
    }

    @Override // ADYaiT.A2egSU
    public final void AlLFFp(boolean z) {
        H6qKiO h6qKiO = this.f224A2egSU;
        h6qKiO.A2egSU((h6qKiO.f899A4TApA & (-5)) | 4);
    }

    @Override // ADYaiT.A2egSU
    public final void AmA8tU() {
        H6qKiO h6qKiO = this.f224A2egSU;
        h6qKiO.A2egSU((h6qKiO.f899A4TApA & (-3)) | 2);
    }

    @Override // ADYaiT.A2egSU
    public final void AzWtSf(boolean z) {
    }

    @Override // ADYaiT.A2egSU
    public final void B25kr6() {
        H6qKiO h6qKiO = this.f224A2egSU;
        h6qKiO.f903ASJ6gh = true;
        h6qKiO.f904AYUAbz = "互传";
        if ((h6qKiO.f899A4TApA & 8) != 0) {
            Toolbar toolbar = h6qKiO.f898A2egSU;
            toolbar.setTitle("互传");
            if (h6qKiO.f903ASJ6gh) {
                COJEAR.DG07BK.B7CMnp(toolbar.getRootView(), "互传");
            }
        }
    }

    @Override // ADYaiT.A2egSU
    public final void B2KMhB(CharSequence charSequence) {
        H6qKiO h6qKiO = this.f224A2egSU;
        if (h6qKiO.f903ASJ6gh) {
            return;
        }
        h6qKiO.f904AYUAbz = charSequence;
        if ((h6qKiO.f899A4TApA & 8) != 0) {
            Toolbar toolbar = h6qKiO.f898A2egSU;
            toolbar.setTitle(charSequence);
            if (h6qKiO.f903ASJ6gh) {
                COJEAR.DG07BK.B7CMnp(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final Menu B4ZgIw() {
        boolean z = this.AMqCpz;
        H6qKiO h6qKiO = this.f224A2egSU;
        if (!z) {
            D9tr6l d9tr6l = new D9tr6l(this);
            KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(1, this);
            Toolbar toolbar = h6qKiO.f898A2egSU;
            toolbar.f8257D6DOie = d9tr6l;
            toolbar.f8258D6yqiO = a5SV6n;
            ActionMenuView actionMenuView = toolbar.f8219AcNBzu;
            if (actionMenuView != null) {
                actionMenuView.BpkvW3 = d9tr6l;
                actionMenuView.f8141C2rE4F = a5SV6n;
            }
            this.AMqCpz = true;
        }
        return h6qKiO.f898A2egSU.getMenu();
    }
}
