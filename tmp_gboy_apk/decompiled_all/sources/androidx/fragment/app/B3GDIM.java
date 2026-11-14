package androidx.fragment.app;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM extends CNPG0E {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ CNPG0E f8761AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ B4ZgIw f8762AlLFFp;

    public B3GDIM(B4ZgIw b4ZgIw, CNPG0E cnpg0e) {
        this.f8762AlLFFp = b4ZgIw;
        this.f8761AcNBzu = cnpg0e;
    }

    @Override // androidx.fragment.app.CNPG0E
    public final View A4TApA(int i) {
        CNPG0E cnpg0e = this.f8761AcNBzu;
        return cnpg0e.A5SV6n() ? cnpg0e.A4TApA(i) : this.f8762AlLFFp.onFindViewById(i);
    }

    @Override // androidx.fragment.app.CNPG0E
    public final boolean A5SV6n() {
        return this.f8761AcNBzu.A5SV6n() || this.f8762AlLFFp.onHasView();
    }
}
