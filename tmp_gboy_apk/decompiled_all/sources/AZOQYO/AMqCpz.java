package AZOQYO;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends A4TApA implements AZkASS.AcNBzu {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Context f353AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ActionBarContextView f354AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public K1Z3yj.A2egSU f355B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public WeakReference f356B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f357B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public AZkASS.AmA8tU f358B4ZgIw;

    @Override // AZOQYO.A4TApA
    public final void A2egSU() {
        if (this.f357B3GDIM) {
            return;
        }
        this.f357B3GDIM = true;
        this.f355B25kr6.AYUAbz(this);
    }

    @Override // AZOQYO.A4TApA
    public final View A4TApA() {
        WeakReference weakReference = this.f356B2KMhB;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // AZOQYO.A4TApA
    public final AZkASS.AmA8tU A5SV6n() {
        return this.f358B4ZgIw;
    }

    @Override // AZOQYO.A4TApA
    public final MenuInflater ADYaiT() {
        return new AZkASS(this.f354AzWtSf.getContext());
    }

    @Override // AZOQYO.A4TApA
    public final CharSequence AMqCpz() {
        return this.f354AzWtSf.getSubtitle();
    }

    @Override // AZOQYO.A4TApA
    public final CharSequence ARc23Z() {
        return this.f354AzWtSf.getTitle();
    }

    @Override // AZOQYO.A4TApA
    public final void ASJ6gh() {
        this.f355B25kr6.ADYaiT(this, this.f358B4ZgIw);
    }

    @Override // AZOQYO.A4TApA
    public final boolean AYUAbz() {
        return this.f354AzWtSf.f8104BmvVmW;
    }

    @Override // AZOQYO.A4TApA
    public final void AZOQYO(View view) {
        this.f354AzWtSf.setCustomView(view);
        this.f356B2KMhB = view != null ? new WeakReference(view) : null;
    }

    @Override // AZkASS.AcNBzu
    public final boolean AZkASS(AZkASS.AmA8tU amA8tU, MenuItem menuItem) {
        return ((A2egSU) this.f355B25kr6.f4174AlLFFp).ARc23Z(this, menuItem);
    }

    @Override // AZOQYO.A4TApA
    public final void AaHO0E(int i) {
        AlLFFp(this.f353AmA8tU.getString(i));
    }

    @Override // AZkASS.AcNBzu
    public final void AcNBzu(AZkASS.AmA8tU amA8tU) {
        ASJ6gh();
        AaHO0E.AzWtSf azWtSf = this.f354AzWtSf.f8089AzWtSf;
        if (azWtSf != null) {
            azWtSf.AmA8tU();
        }
    }

    @Override // AZOQYO.A4TApA
    public final void AlLFFp(CharSequence charSequence) {
        this.f354AzWtSf.setSubtitle(charSequence);
    }

    @Override // AZOQYO.A4TApA
    public final void AmA8tU(int i) {
        AzWtSf(this.f353AmA8tU.getString(i));
    }

    @Override // AZOQYO.A4TApA
    public final void AzWtSf(CharSequence charSequence) {
        this.f354AzWtSf.setTitle(charSequence);
    }

    @Override // AZOQYO.A4TApA
    public final void B25kr6(boolean z) {
        this.f352AlLFFp = z;
        this.f354AzWtSf.setTitleOptional(z);
    }
}
