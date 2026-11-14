package AaHO0E;

import androidx.appcompat.widget.ActionBarContextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements COJEAR.DjONCG {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f593A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f594A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Object f595A5SV6n;

    @Override // COJEAR.DjONCG
    public void A2egSU() {
        this.f594A4TApA = true;
    }

    @Override // COJEAR.DjONCG
    public void A4TApA() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.f594A4TApA = false;
    }

    @Override // COJEAR.DjONCG
    public void A5SV6n() {
        if (this.f594A4TApA) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f595A5SV6n;
        actionBarContextView.f8091B2KMhB = null;
        super/*android.view.ViewGroup*/.setVisibility(this.f593A2egSU);
    }
}
