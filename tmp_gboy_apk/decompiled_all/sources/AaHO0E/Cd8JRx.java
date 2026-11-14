package AaHO0E;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Cd8JRx implements CtxOCS, DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ADYaiT.AmA8tU f695AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public CkXcdM f696AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public CharSequence f697AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ D07BeM f698AzWtSf;

    public Cd8JRx(D07BeM d07BeM) {
        this.f698AzWtSf = d07BeM;
    }

    @Override // AaHO0E.CtxOCS
    public final int A2egSU() {
        return 0;
    }

    @Override // AaHO0E.CtxOCS
    public final void A4TApA(int i) {
    }

    @Override // AaHO0E.CtxOCS
    public final CharSequence A5SV6n() {
        return this.f697AmA8tU;
    }

    @Override // AaHO0E.CtxOCS
    public final Drawable ADYaiT() {
        return null;
    }

    @Override // AaHO0E.CtxOCS
    public final void ARc23Z(CharSequence charSequence) {
        this.f697AmA8tU = charSequence;
    }

    @Override // AaHO0E.CtxOCS
    public final void ASJ6gh(Drawable drawable) {
    }

    @Override // AaHO0E.CtxOCS
    public final void AYUAbz(int i) {
    }

    @Override // AaHO0E.CtxOCS
    public final void AZkASS(int i) {
    }

    @Override // AaHO0E.CtxOCS
    public final void AaHO0E(int i, int i2) {
        if (this.f696AlLFFp == null) {
            return;
        }
        D07BeM d07BeM = this.f698AzWtSf;
        ADYaiT.AlLFFp alLFFp = new ADYaiT.AlLFFp(d07BeM.getPopupContext());
        CharSequence charSequence = this.f697AmA8tU;
        ADYaiT.AZOQYO azoqyo = alLFFp.f81AcNBzu;
        if (charSequence != null) {
            azoqyo.AMqCpz = charSequence;
        }
        CkXcdM ckXcdM = this.f696AlLFFp;
        int selectedItemPosition = d07BeM.getSelectedItemPosition();
        azoqyo.f39B3GDIM = ckXcdM;
        azoqyo.f40B4ZgIw = this;
        azoqyo.f45BIYEnU = selectedItemPosition;
        azoqyo.f44BI9f7h = true;
        ADYaiT.AmA8tU A2egSU2 = alLFFp.A2egSU();
        this.f695AcNBzu = A2egSU2;
        AlertController$RecycleListView alertController$RecycleListView = A2egSU2.f83B2KMhB.f53ARc23Z;
        alertController$RecycleListView.setTextDirection(i);
        alertController$RecycleListView.setTextAlignment(i2);
        this.f695AcNBzu.show();
    }

    @Override // AaHO0E.CtxOCS
    public final int AcNBzu() {
        return 0;
    }

    @Override // AaHO0E.CtxOCS
    public final void AlLFFp(ListAdapter listAdapter) {
        this.f696AlLFFp = (CkXcdM) listAdapter;
    }

    @Override // AaHO0E.CtxOCS
    public final void dismiss() {
        ADYaiT.AmA8tU amA8tU = this.f695AcNBzu;
        if (amA8tU != null) {
            amA8tU.dismiss();
            this.f695AcNBzu = null;
        }
    }

    @Override // AaHO0E.CtxOCS
    public final boolean isShowing() {
        ADYaiT.AmA8tU amA8tU = this.f695AcNBzu;
        if (amA8tU != null) {
            return amA8tU.isShowing();
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        D07BeM d07BeM = this.f698AzWtSf;
        d07BeM.setSelection(i);
        if (d07BeM.getOnItemClickListener() != null) {
            d07BeM.performItemClick(null, i, this.f696AlLFFp.getItemId(i));
        }
        dismiss();
    }
}
