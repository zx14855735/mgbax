package CrfGsy;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<AMqCpz> CREATOR = new H0qugq(3);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1865AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f1866AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f1867AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f1868AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f1869B25kr6;

    static {
        FZpkA();
    }

    public AMqCpz(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f1865AcNBzu = 0;
        this.f1865AcNBzu = parcel.readInt();
        this.f1866AlLFFp = parcel.readInt();
        this.f1867AmA8tU = parcel.readInt();
        this.f1868AzWtSf = parcel.readInt();
        this.f1869B25kr6 = parcel.readInt();
    }

    private static /* synthetic */ void FZpkA() {
        char[] charArray = "bnl/f`ld/cnx/ridmm/KohCshefd".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 1);
        }
        String str = new String(charArray);
        char[] charArray2 = "bmhohu".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 1);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1865AcNBzu);
        parcel.writeInt(this.f1866AlLFFp);
        parcel.writeInt(this.f1867AmA8tU);
        parcel.writeInt(this.f1868AzWtSf);
        parcel.writeInt(this.f1869B25kr6);
    }
}
