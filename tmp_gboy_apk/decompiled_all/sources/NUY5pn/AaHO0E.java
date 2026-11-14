package NUY5pn;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E extends NUtxJj.A2egSU {
    public static final Parcelable.Creator<AaHO0E> CREATOR = new AcNBzu();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5954AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final IBinder f5955AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final NOd7IU.A2egSU f5956AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final boolean f5957AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final boolean f5958B25kr6;

    static {
        OMCzEKA();
    }

    public AaHO0E(int i, IBinder iBinder, NOd7IU.A2egSU a2egSU, boolean z, boolean z2) {
        this.f5954AcNBzu = i;
        this.f5955AlLFFp = iBinder;
        this.f5956AmA8tU = a2egSU;
        this.f5957AzWtSf = z;
        this.f5958B25kr6 = z2;
    }

    private static /* synthetic */ void OMCzEKA() {
        char[] charArray = "\u0007\u000b\tJ\u0003\u0005\t\u0001J\u0006\u000b\u001dJ\u0017\f\u0001\b\bJ.\n\r&\u0016\r\u0000\u0003\u0001".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'd');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0007\b\r\n\r\u0010".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'd');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AaHO0E)) {
            return false;
        }
        AaHO0E aaHO0E = (AaHO0E) obj;
        return this.f5956AmA8tU.equals(aaHO0E.f5956AmA8tU) && A2egSU.A2egSU(this.f5955AlLFFp).equals(A2egSU.A2egSU(aaHO0E.f5955AlLFFp));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5954AcNBzu);
        IBinder iBinder = this.f5955AlLFFp;
        if (iBinder != null) {
            int AZkASS3 = JrXYwF.A4TApA.AZkASS(parcel, 2);
            parcel.writeStrongBinder(iBinder);
            JrXYwF.A4TApA.AmA8tU(parcel, AZkASS3);
        }
        JrXYwF.A4TApA.ARc23Z(parcel, 3, this.f5956AmA8tU, i);
        JrXYwF.A4TApA.AcNBzu(parcel, 4, 4);
        parcel.writeInt(this.f5957AzWtSf ? 1 : 0);
        JrXYwF.A4TApA.AcNBzu(parcel, 5, 4);
        parcel.writeInt(this.f5958B25kr6 ? 1 : 0);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }
}
