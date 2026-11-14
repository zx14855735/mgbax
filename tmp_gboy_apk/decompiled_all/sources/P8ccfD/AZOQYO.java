package P8ccfD;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<AZOQYO> CREATOR = new H0qugq(13);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public String f6973AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f6974AlLFFp;

    static {
        afTS();
    }

    public AZOQYO(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6973AcNBzu = parcel.readString();
        this.f6974AlLFFp = parcel.readInt();
    }

    private static /* synthetic */ void afTS() {
        char[] charArray = "TXZ\u0019PVZR\u0019UXN\u0019D_R[[\u0019}Y^uE^SPR".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '7');
        }
        String str = new String(charArray);
        char[] charArray2 = "T[^Y^C".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '7');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f6973AcNBzu);
        parcel.writeInt(this.f6974AlLFFp);
    }
}
