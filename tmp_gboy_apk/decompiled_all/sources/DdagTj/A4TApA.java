package DdagTj;

import ADYaiT.CtFAbx;
import B25kr6.ADYaiT;
import android.os.Parcel;
import android.util.SparseIntArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends A2egSU {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final SparseIntArray f2394ADYaiT;
    public final Parcel AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f2395ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final int f2396ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final String f2397AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f2398AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f2399AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f2400AaHO0E;

    public A4TApA(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ADYaiT(), new ADYaiT(), new ADYaiT());
    }

    @Override // DdagTj.A2egSU
    public final A4TApA A2egSU() {
        Parcel parcel = this.AMqCpz;
        int dataPosition = parcel.dataPosition();
        int i = this.f2399AZkASS;
        if (i == this.f2395ARc23Z) {
            i = this.f2396ASJ6gh;
        }
        return new A4TApA(parcel, dataPosition, i, CtFAbx.B25kr6(new StringBuilder(), this.f2397AYUAbz, "  "), this.f2391A2egSU, this.f2392A4TApA, this.f2393A5SV6n);
    }

    @Override // DdagTj.A2egSU
    public final boolean AMqCpz(int i) {
        while (this.f2399AZkASS < this.f2396ASJ6gh) {
            int i2 = this.f2400AaHO0E;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i3 = this.f2399AZkASS;
            Parcel parcel = this.AMqCpz;
            parcel.setDataPosition(i3);
            int readInt = parcel.readInt();
            this.f2400AaHO0E = parcel.readInt();
            this.f2399AZkASS += readInt;
        }
        return this.f2400AaHO0E == i;
    }

    @Override // DdagTj.A2egSU
    public final void AYUAbz(int i) {
        int i2 = this.f2398AZOQYO;
        SparseIntArray sparseIntArray = this.f2394ADYaiT;
        Parcel parcel = this.AMqCpz;
        if (i2 >= 0) {
            int i3 = sparseIntArray.get(i2);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i3);
            parcel.writeInt(dataPosition - i3);
            parcel.setDataPosition(dataPosition);
        }
        this.f2398AZOQYO = i;
        sparseIntArray.put(i, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i);
    }

    public A4TApA(Parcel parcel, int i, int i2, String str, ADYaiT aDYaiT, ADYaiT aDYaiT2, ADYaiT aDYaiT3) {
        super(aDYaiT, aDYaiT2, aDYaiT3);
        this.f2394ADYaiT = new SparseIntArray();
        this.f2398AZOQYO = -1;
        this.f2400AaHO0E = -1;
        this.AMqCpz = parcel;
        this.f2395ARc23Z = i;
        this.f2396ASJ6gh = i2;
        this.f2399AZkASS = i;
        this.f2397AYUAbz = str;
    }
}
