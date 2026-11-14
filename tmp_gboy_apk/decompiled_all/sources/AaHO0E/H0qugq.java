package AaHO0E;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class H0qugq implements Parcelable.ClassLoaderCreator {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f893A2egSU;

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f893A2egSU) {
            case 0:
                return new H1wUHe(parcel, classLoader);
            case 1:
                return new BNL6CD.A4TApA(parcel, classLoader);
            case 2:
                if (parcel.readParcelable(classLoader) == null) {
                    return CmUvjW.A4TApA.EMPTY_STATE;
                }
                throw new IllegalStateException("superState must be null");
            case 3:
                return new CrfGsy.AMqCpz(parcel, classLoader);
            case 4:
                if (Build.VERSION.SDK_INT >= 24) {
                    return new De4eam.AmA8tU(parcel, classLoader);
                }
                De4eam.AmA8tU amA8tU = new De4eam.AmA8tU(parcel);
                amA8tU.f2416AcNBzu = parcel.readInt();
                amA8tU.f2417AlLFFp = parcel.readInt();
                amA8tU.f2418AmA8tU = parcel.readParcelable(null);
                return amA8tU;
            case 5:
                return new NuExGq.A5SV6n(parcel, classLoader);
            case 6:
                return new O1Vn2F.A5SV6n(parcel, classLoader);
            case 7:
                return new O1nrJm.A5SV6n(parcel, classLoader);
            case 8:
                return new Oay4Bh.A4TApA(parcel, classLoader);
            case 9:
                return new Oay4Bh.BJ7GGh(parcel, classLoader);
            case 10:
                return new OpB85q.B25kr6(parcel, classLoader);
            case 11:
                return new OpB85q.B7CMnp(parcel, classLoader);
            case 12:
                return new P8ccfD.A5SV6n(parcel, classLoader);
            case 13:
                return new P8ccfD.AZOQYO(parcel, classLoader);
            case 14:
                return new PMC23c.ADYaiT(parcel, classLoader);
            case 15:
                return new PWr3nF.BJ7GGh(parcel, classLoader);
            case 16:
                return new androidx.fragment.app.BV3sI0(parcel, classLoader);
            case 17:
                return new androidx.recyclerview.widget.DcUJf1(parcel, classLoader);
            default:
                return new androidx.viewpager.widget.AZkASS(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f893A2egSU) {
            case 0:
                return new H1wUHe[i];
            case 1:
                return new BNL6CD.A4TApA[i];
            case 2:
                return new CmUvjW.A4TApA[i];
            case 3:
                return new CrfGsy.AMqCpz[i];
            case 4:
                return new De4eam.AmA8tU[i];
            case 5:
                return new NuExGq.A5SV6n[i];
            case 6:
                return new O1Vn2F.A5SV6n[i];
            case 7:
                return new O1nrJm.A5SV6n[i];
            case 8:
                return new Oay4Bh.A4TApA[i];
            case 9:
                return new Oay4Bh.BJ7GGh[i];
            case 10:
                return new OpB85q.B25kr6[i];
            case 11:
                return new OpB85q.B7CMnp[i];
            case 12:
                return new P8ccfD.A5SV6n[i];
            case 13:
                return new P8ccfD.AZOQYO[i];
            case 14:
                return new PMC23c.ADYaiT[i];
            case 15:
                return new PWr3nF.BJ7GGh[i];
            case 16:
                return new androidx.fragment.app.BV3sI0[i];
            case 17:
                return new androidx.recyclerview.widget.DcUJf1[i];
            default:
                return new androidx.viewpager.widget.AZkASS[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f893A2egSU) {
            case 0:
                return new H1wUHe(parcel, null);
            case 1:
                return new BNL6CD.A4TApA(parcel, null);
            case 2:
                if (parcel.readParcelable(null) == null) {
                    return CmUvjW.A4TApA.EMPTY_STATE;
                }
                throw new IllegalStateException("superState must be null");
            case 3:
                return new CrfGsy.AMqCpz(parcel, null);
            case 4:
                if (Build.VERSION.SDK_INT >= 24) {
                    return new De4eam.AmA8tU(parcel, null);
                }
                De4eam.AmA8tU amA8tU = new De4eam.AmA8tU(parcel);
                amA8tU.f2416AcNBzu = parcel.readInt();
                amA8tU.f2417AlLFFp = parcel.readInt();
                amA8tU.f2418AmA8tU = parcel.readParcelable(null);
                return amA8tU;
            case 5:
                return new NuExGq.A5SV6n(parcel, null);
            case 6:
                return new O1Vn2F.A5SV6n(parcel, null);
            case 7:
                return new O1nrJm.A5SV6n(parcel, null);
            case 8:
                return new Oay4Bh.A4TApA(parcel, null);
            case 9:
                return new Oay4Bh.BJ7GGh(parcel, null);
            case 10:
                return new OpB85q.B25kr6(parcel, null);
            case 11:
                return new OpB85q.B7CMnp(parcel, null);
            case 12:
                return new P8ccfD.A5SV6n(parcel, null);
            case 13:
                return new P8ccfD.AZOQYO(parcel, null);
            case 14:
                return new PMC23c.ADYaiT(parcel, null);
            case 15:
                return new PWr3nF.BJ7GGh(parcel, null);
            case 16:
                return new androidx.fragment.app.BV3sI0(parcel, null);
            case 17:
                return new androidx.recyclerview.widget.DcUJf1(parcel, null);
            default:
                return new androidx.viewpager.widget.AZkASS(parcel, null);
        }
    }
}
