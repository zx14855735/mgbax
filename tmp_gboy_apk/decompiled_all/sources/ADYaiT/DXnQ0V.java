package ADYaiT;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DXnQ0V extends AZOQYO.A4TApA implements AZkASS.AcNBzu {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Context f244AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AZkASS.AmA8tU f245AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public K1Z3yj.A2egSU f246B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public WeakReference f247B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final /* synthetic */ DXuj49 f248B3GDIM;

    public DXnQ0V(DXuj49 dXuj49, Context context, K1Z3yj.A2egSU a2egSU) {
        this.f248B3GDIM = dXuj49;
        this.f244AmA8tU = context;
        this.f246B25kr6 = a2egSU;
        AZkASS.AmA8tU amA8tU = new AZkASS.AmA8tU(context);
        amA8tU.f504BI9f7h = 1;
        this.f245AzWtSf = amA8tU;
        amA8tU.f497B25kr6 = this;
    }

    @Override // AZOQYO.A4TApA
    public final void A2egSU() {
        DXuj49 dXuj49 = this.f248B3GDIM;
        if (dXuj49.f258AZOQYO != this) {
            return;
        }
        if (dXuj49.f265B25kr6) {
            dXuj49.f259AZkASS = this;
            dXuj49.f260AaHO0E = this.f246B25kr6;
        } else {
            this.f246B25kr6.AYUAbz(this);
        }
        this.f246B25kr6 = null;
        dXuj49.B4ZgIw(false);
        ActionBarContextView actionBarContextView = dXuj49.f255ARc23Z;
        if (actionBarContextView.f8096BChYOn == null) {
            actionBarContextView.AMqCpz();
        }
        dXuj49.f253A5SV6n.setHideOnContentScrollEnabled(dXuj49.f270B9tovu);
        dXuj49.f258AZOQYO = null;
    }

    @Override // AZOQYO.A4TApA
    public final View A4TApA() {
        WeakReference weakReference = this.f247B2KMhB;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // AZOQYO.A4TApA
    public final AZkASS.AmA8tU A5SV6n() {
        return this.f245AzWtSf;
    }

    @Override // AZOQYO.A4TApA
    public final MenuInflater ADYaiT() {
        return new AZOQYO.AZkASS(this.f244AmA8tU);
    }

    @Override // AZOQYO.A4TApA
    public final CharSequence AMqCpz() {
        return this.f248B3GDIM.f255ARc23Z.getSubtitle();
    }

    @Override // AZOQYO.A4TApA
    public final CharSequence ARc23Z() {
        return this.f248B3GDIM.f255ARc23Z.getTitle();
    }

    @Override // AZOQYO.A4TApA
    public final void ASJ6gh() {
        if (this.f248B3GDIM.f258AZOQYO != this) {
            return;
        }
        AZkASS.AmA8tU amA8tU = this.f245AzWtSf;
        amA8tU.BJ7GGh();
        try {
            this.f246B25kr6.ADYaiT(this, amA8tU);
        } finally {
            amA8tU.BIYEnU();
        }
    }

    @Override // AZOQYO.A4TApA
    public final boolean AYUAbz() {
        return this.f248B3GDIM.f255ARc23Z.f8104BmvVmW;
    }

    @Override // AZOQYO.A4TApA
    public final void AZOQYO(View view) {
        this.f248B3GDIM.f255ARc23Z.setCustomView(view);
        this.f247B2KMhB = new WeakReference(view);
    }

    @Override // AZkASS.AcNBzu
    public final boolean AZkASS(AZkASS.AmA8tU amA8tU, MenuItem menuItem) {
        K1Z3yj.A2egSU a2egSU = this.f246B25kr6;
        if (a2egSU != null) {
            return ((AZOQYO.A2egSU) a2egSU.f4174AlLFFp).ARc23Z(this, menuItem);
        }
        return false;
    }

    @Override // AZOQYO.A4TApA
    public final void AaHO0E(int i) {
        AlLFFp(this.f248B3GDIM.f251A2egSU.getResources().getString(i));
    }

    @Override // AZkASS.AcNBzu
    public final void AcNBzu(AZkASS.AmA8tU amA8tU) {
        if (this.f246B25kr6 == null) {
            return;
        }
        ASJ6gh();
        AaHO0E.AzWtSf azWtSf = this.f248B3GDIM.f255ARc23Z.f8089AzWtSf;
        if (azWtSf != null) {
            azWtSf.AmA8tU();
        }
    }

    @Override // AZOQYO.A4TApA
    public final void AlLFFp(CharSequence charSequence) {
        this.f248B3GDIM.f255ARc23Z.setSubtitle(charSequence);
    }

    @Override // AZOQYO.A4TApA
    public final void AmA8tU(int i) {
        AzWtSf(this.f248B3GDIM.f251A2egSU.getResources().getString(i));
    }

    @Override // AZOQYO.A4TApA
    public final void AzWtSf(CharSequence charSequence) {
        this.f248B3GDIM.f255ARc23Z.setTitle(charSequence);
    }

    @Override // AZOQYO.A4TApA
    public final void B25kr6(boolean z) {
        this.f352AlLFFp = z;
        this.f248B3GDIM.f255ARc23Z.setTitleOptional(z);
    }
}
