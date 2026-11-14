package AaHO0E;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp implements Parcelable.Creator {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f609A2egSU;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f609A2egSU) {
            case 0:
                AmA8tU amA8tU = new AmA8tU();
                amA8tU.f610AcNBzu = parcel.readInt();
                return amA8tU;
            case 1:
                CtFAbx ctFAbx = new CtFAbx(parcel);
                ctFAbx.f710AcNBzu = parcel.readByte() != 0;
                return ctFAbx;
            case 2:
                CikNvS.AaHO0E aaHO0E = new CikNvS.AaHO0E(parcel);
                aaHO0E.f1810AcNBzu = parcel.readInt();
                return aaHO0E;
            case 3:
                return new DRlcZ9.A5SV6n(parcel);
            case 4:
                return new DRlcZ9.ARc23Z(parcel);
            case 5:
                return new DRlcZ9.AZOQYO(parcel);
            case 6:
                return new DRlcZ9.AcNBzu(parcel);
            case 7:
                return new DRlcZ9.B7CMnp(parcel);
            case 8:
                return new DRlcZ9.BpkvW3(parcel);
            case 9:
                return new DRlcZ9.C2rE4F(parcel);
            case 10:
                return new ParcelImpl(parcel);
            case 11:
                return new HIguqb.AmA8tU(parcel);
            case 12:
                return new HIguqb.AzWtSf(parcel);
            case 13:
                return new HIguqb.B25kr6(parcel);
            case 14:
                return new HIguqb.B2KMhB(parcel);
            case 15:
                return new MTKlkd.ARc23Z(parcel);
            case 16:
                NpX2pY.A4TApA a4TApA = new NpX2pY.A4TApA();
                a4TApA.f6093B7CMnp = 255;
                a4TApA.f6095BChYOn = -2;
                a4TApA.f6096BI9f7h = -2;
                a4TApA.f6097BIYEnU = -2;
                a4TApA.f6104BniPrB = Boolean.TRUE;
                a4TApA.f6085AcNBzu = parcel.readInt();
                a4TApA.f6086AlLFFp = (Integer) parcel.readSerializable();
                a4TApA.f6087AmA8tU = (Integer) parcel.readSerializable();
                a4TApA.f6088AzWtSf = (Integer) parcel.readSerializable();
                a4TApA.f6089B25kr6 = (Integer) parcel.readSerializable();
                a4TApA.f6090B2KMhB = (Integer) parcel.readSerializable();
                a4TApA.f6091B3GDIM = (Integer) parcel.readSerializable();
                a4TApA.f6092B4ZgIw = (Integer) parcel.readSerializable();
                a4TApA.f6093B7CMnp = parcel.readInt();
                a4TApA.f6094B9tovu = parcel.readString();
                a4TApA.f6095BChYOn = parcel.readInt();
                a4TApA.f6096BI9f7h = parcel.readInt();
                a4TApA.f6097BIYEnU = parcel.readInt();
                a4TApA.f6099BNL6CD = parcel.readString();
                a4TApA.f6100BPw6Q8 = parcel.readString();
                a4TApA.f6101BTvldC = parcel.readInt();
                a4TApA.f6103BmvVmW = (Integer) parcel.readSerializable();
                a4TApA.BpkvW3 = (Integer) parcel.readSerializable();
                a4TApA.f6105C2rE4F = (Integer) parcel.readSerializable();
                a4TApA.f6106C4FrIb = (Integer) parcel.readSerializable();
                a4TApA.f6107CASmeH = (Integer) parcel.readSerializable();
                a4TApA.f6108CNPG0E = (Integer) parcel.readSerializable();
                a4TApA.f6109COJEAR = (Integer) parcel.readSerializable();
                a4TApA.f6112CTkVKb = (Integer) parcel.readSerializable();
                a4TApA.f6110CQhlFr = (Integer) parcel.readSerializable();
                a4TApA.f6111CSDoyG = (Integer) parcel.readSerializable();
                a4TApA.f6104BniPrB = (Boolean) parcel.readSerializable();
                a4TApA.f6098BJ7GGh = (Locale) parcel.readSerializable();
                a4TApA.f6113CcAIMM = (Boolean) parcel.readSerializable();
                a4TApA.f6114Cd8JRx = (Integer) parcel.readSerializable();
                return a4TApA;
            case 17:
                OIlOLF.A2egSU a2egSU = new OIlOLF.A2egSU(parcel);
                a2egSU.f6270AcNBzu = ((Integer) parcel.readValue(OIlOLF.A2egSU.class.getClassLoader())).intValue();
                return a2egSU;
            case 18:
                OpB85q.AaHO0E aaHO0E2 = new OpB85q.AaHO0E();
                aaHO0E2.f6779AcNBzu = parcel.readInt();
                aaHO0E2.f6780AlLFFp = (Oay4Bh.BJ7GGh) parcel.readParcelable(OpB85q.AaHO0E.class.getClassLoader());
                return aaHO0E2;
            case 19:
                PSeUZ5.A5SV6n a5SV6n = new PSeUZ5.A5SV6n(parcel);
                a5SV6n.f7175AcNBzu = parcel.readFloat();
                a5SV6n.f7176AlLFFp = parcel.readFloat();
                ArrayList arrayList = new ArrayList();
                a5SV6n.f7177AmA8tU = arrayList;
                parcel.readList(arrayList, Float.class.getClassLoader());
                a5SV6n.f7178AzWtSf = parcel.readFloat();
                a5SV6n.f7179B25kr6 = parcel.createBooleanArray()[0];
                return a5SV6n;
            case 20:
                return new QgOIY0.AcNBzu(parcel);
            case 21:
                QgOIY0.BTvldC bTvldC = new QgOIY0.BTvldC();
                bTvldC.f7633AcNBzu = (QgOIY0.BV3sI0[]) parcel.createTypedArray(QgOIY0.BV3sI0.CREATOR);
                bTvldC.f7634AlLFFp = parcel.createIntArray();
                bTvldC.f7635AmA8tU = (QgOIY0.AcNBzu[]) parcel.createTypedArray(QgOIY0.AcNBzu.CREATOR);
                return bTvldC;
            case 22:
                return new QgOIY0.BV3sI0(parcel);
            case 23:
                return new androidx.activity.result.A2egSU(parcel);
            case 24:
                RXb0Sz.ARc23Z.AMqCpz(parcel, "inParcel");
                Parcelable readParcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                RXb0Sz.ARc23Z.A4TApA(readParcelable);
                return new androidx.activity.result.AZOQYO((IntentSender) readParcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 25:
                return new androidx.fragment.app.A4TApA(parcel);
            case 26:
                return new androidx.fragment.app.A5SV6n(parcel);
            case 27:
                androidx.fragment.app.D07BeM d07BeM = new androidx.fragment.app.D07BeM();
                d07BeM.f8866AcNBzu = parcel.readString();
                d07BeM.f8867AlLFFp = parcel.readInt();
                return d07BeM;
            case 28:
                androidx.fragment.app.D8cQ8b d8cQ8b = new androidx.fragment.app.D8cQ8b();
                d8cQ8b.f8876B25kr6 = null;
                d8cQ8b.f8877B2KMhB = new ArrayList();
                d8cQ8b.f8878B3GDIM = new ArrayList();
                d8cQ8b.f8872AcNBzu = parcel.createStringArrayList();
                d8cQ8b.f8873AlLFFp = parcel.createStringArrayList();
                d8cQ8b.f8874AmA8tU = (androidx.fragment.app.A4TApA[]) parcel.createTypedArray(androidx.fragment.app.A4TApA.CREATOR);
                d8cQ8b.f8875AzWtSf = parcel.readInt();
                d8cQ8b.f8876B25kr6 = parcel.readString();
                d8cQ8b.f8877B2KMhB = parcel.createStringArrayList();
                d8cQ8b.f8878B3GDIM = parcel.createTypedArrayList(androidx.fragment.app.A5SV6n.CREATOR);
                d8cQ8b.f8879B4ZgIw = parcel.createTypedArrayList(androidx.fragment.app.D07BeM.CREATOR);
                return d8cQ8b;
            default:
                return new androidx.fragment.app.DG07BK(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f609A2egSU) {
            case 0:
                return new AmA8tU[i];
            case 1:
                return new CtFAbx[i];
            case 2:
                return new CikNvS.AaHO0E[i];
            case 3:
                return new DRlcZ9.A5SV6n[i];
            case 4:
                return new DRlcZ9.ARc23Z[i];
            case 5:
                return new DRlcZ9.AZOQYO[i];
            case 6:
                return new DRlcZ9.AcNBzu[i];
            case 7:
                return new DRlcZ9.B7CMnp[i];
            case 8:
                return new DRlcZ9.BpkvW3[i];
            case 9:
                return new DRlcZ9.C2rE4F[i];
            case 10:
                return new ParcelImpl[i];
            case 11:
                return new HIguqb.AmA8tU[i];
            case 12:
                return new HIguqb.AzWtSf[i];
            case 13:
                return new HIguqb.B25kr6[i];
            case 14:
                return new HIguqb.B2KMhB[i];
            case 15:
                return new MTKlkd.ARc23Z[i];
            case 16:
                return new NpX2pY.A4TApA[i];
            case 17:
                return new OIlOLF.A2egSU[i];
            case 18:
                return new OpB85q.AaHO0E[i];
            case 19:
                return new PSeUZ5.A5SV6n[i];
            case 20:
                return new QgOIY0.AcNBzu[i];
            case 21:
                return new QgOIY0.BTvldC[i];
            case 22:
                return new QgOIY0.BV3sI0[i];
            case 23:
                return new androidx.activity.result.A2egSU[i];
            case 24:
                return new androidx.activity.result.AZOQYO[i];
            case 25:
                return new androidx.fragment.app.A4TApA[i];
            case 26:
                return new androidx.fragment.app.A5SV6n[i];
            case 27:
                return new androidx.fragment.app.D07BeM[i];
            case 28:
                return new androidx.fragment.app.D8cQ8b[i];
            default:
                return new androidx.fragment.app.DG07BK[i];
        }
    }
}
