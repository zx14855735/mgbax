package M0ztbm;

import android.content.DialogInterface;
import com.game.boy.activity.B3GDIM;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4955AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ B3GDIM f4956AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ A4TApA f4957AmA8tU;

    public /* synthetic */ A2egSU(B3GDIM b3gdim, A4TApA a4TApA, int i) {
        this.f4955AcNBzu = i;
        this.f4956AlLFFp = b3gdim;
        this.f4957AmA8tU = a4TApA;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f4955AcNBzu) {
            case 0:
                B3GDIM b3gdim = this.f4956AlLFFp;
                if (b3gdim != null) {
                    b3gdim.A2egSU(this.f4957AmA8tU, true);
                    break;
                }
                break;
            default:
                B3GDIM b3gdim2 = this.f4956AlLFFp;
                if (b3gdim2 != null) {
                    b3gdim2.A2egSU(this.f4957AmA8tU, false);
                    break;
                }
                break;
        }
    }
}
