package QgOIY0;

import ADYaiT.CtFAbx;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AmA8tU extends B2KMhB implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: D07BeM, reason: collision with root package name */
    public int f7535D07BeM = 0;

    /* renamed from: D6DOie, reason: collision with root package name */
    public int f7536D6DOie = 0;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public boolean f7537D6yqiO = true;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public boolean f7538D8MqeW = true;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public int f7539D8cQ8b = -1;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public Dialog f7540D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public boolean f7541DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public boolean f7542DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public boolean f7543DRlcZ9;

    @Override // QgOIY0.B2KMhB
    public final void AMqCpz(B7CMnp b7CMnp) {
        super.AMqCpz(b7CMnp);
        if (this.f7543DRlcZ9) {
            return;
        }
        this.f7542DG07BK = false;
    }

    @Override // QgOIY0.B2KMhB
    public final void ARc23Z(Bundle bundle) {
        super.ARc23Z(bundle);
        this.f7538D8MqeW = this.f7557B2KMhB == 0;
        if (bundle != null) {
            this.f7535D07BeM = bundle.getInt("android:style", 0);
            this.f7536D6DOie = bundle.getInt("android:theme", 0);
            this.f7537D6yqiO = bundle.getBoolean("android:cancelable", true);
            this.f7538D8MqeW = bundle.getBoolean("android:showsDialog", this.f7538D8MqeW);
            this.f7539D8cQ8b = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // QgOIY0.B2KMhB
    public final LayoutInflater AZOQYO(Bundle bundle) {
        if (!this.f7538D8MqeW) {
            return super.AZOQYO(bundle);
        }
        Dialog B3GDIM2 = B3GDIM();
        this.f7540D9tr6l = B3GDIM2;
        if (B3GDIM2 == null) {
            return (LayoutInflater) this.f7552AcNBzu.f7588A4TApA.getSystemService("layout_inflater");
        }
        int i = this.f7535D07BeM;
        if (i != 1 && i != 2) {
            if (i == 3) {
                B3GDIM2.getWindow().addFlags(24);
            }
            return (LayoutInflater) this.f7540D9tr6l.getContext().getSystemService("layout_inflater");
        }
        B3GDIM2.requestWindowFeature(1);
        return (LayoutInflater) this.f7540D9tr6l.getContext().getSystemService("layout_inflater");
    }

    @Override // QgOIY0.B2KMhB
    public final void AaHO0E(Bundle bundle) {
        Bundle bundle2;
        this.f7563BI9f7h = true;
        if (this.f7538D8MqeW) {
            B3GDIM b3gdim = this.f7552AcNBzu;
            B7CMnp b7CMnp = b3gdim == null ? null : b3gdim.f7587A2egSU;
            if (b7CMnp != null) {
                this.f7540D9tr6l.setOwnerActivity(b7CMnp);
            }
            this.f7540D9tr6l.setCancelable(this.f7537D6yqiO);
            this.f7540D9tr6l.setOnCancelListener(this);
            this.f7540D9tr6l.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.f7540D9tr6l.onRestoreInstanceState(bundle2);
        }
    }

    @Override // QgOIY0.B2KMhB
    public final void AcNBzu() {
        this.f7563BI9f7h = true;
        if (this.f7543DRlcZ9 || this.f7542DG07BK) {
            return;
        }
        this.f7542DG07BK = true;
    }

    @Override // QgOIY0.B2KMhB
    public final void AlLFFp(Bundle bundle) {
        Bundle onSaveInstanceState;
        Dialog dialog = this.f7540D9tr6l;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.f7535D07BeM;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.f7536D6DOie;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.f7537D6yqiO;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.f7538D8MqeW;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.f7539D8cQ8b;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // QgOIY0.B2KMhB
    public final void AmA8tU() {
        super.AmA8tU();
        Dialog dialog = this.f7540D9tr6l;
        if (dialog != null) {
            this.f7541DAk1zC = false;
            dialog.show();
        }
    }

    @Override // QgOIY0.B2KMhB
    public final void AzWtSf() {
        this.f7563BI9f7h = true;
        Dialog dialog = this.f7540D9tr6l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // QgOIY0.B2KMhB
    public final void B25kr6() {
        this.f7563BI9f7h = true;
        Dialog dialog = this.f7540D9tr6l;
        if (dialog != null) {
            this.f7541DAk1zC = true;
            dialog.dismiss();
            this.f7540D9tr6l = null;
        }
    }

    public Dialog B3GDIM() {
        B3GDIM b3gdim = this.f7552AcNBzu;
        return new Dialog(b3gdim == null ? null : b3gdim.f7587A2egSU, this.f7536D6DOie);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.f7541DAk1zC || this.f7542DG07BK) {
            return;
        }
        this.f7542DG07BK = true;
        this.f7543DRlcZ9 = false;
        Dialog dialog = this.f7540D9tr6l;
        if (dialog != null) {
            dialog.dismiss();
            this.f7540D9tr6l = null;
        }
        this.f7541DAk1zC = true;
        int i = this.f7539D8cQ8b;
        if (i >= 0) {
            BNL6CD bnl6cd = this.f7586CrfGsy;
            bnl6cd.getClass();
            if (i < 0) {
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "Bad id: "));
            }
            bnl6cd.ADYaiT(new BIYEnU(bnl6cd, i), false);
            this.f7539D8cQ8b = -1;
            return;
        }
        BNL6CD bnl6cd2 = this.f7586CrfGsy;
        bnl6cd2.getClass();
        AaHO0E aaHO0E = new AaHO0E(bnl6cd2);
        AZkASS aZkASS = new AZkASS();
        aZkASS.f7499A2egSU = 3;
        aZkASS.f7500A4TApA = this;
        aaHO0E.ADYaiT(aZkASS);
        aaHO0E.A4TApA(true);
    }
}
