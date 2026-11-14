package QgOIY0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class BTvldC implements Parcelable {
    public static final Parcelable.Creator<BTvldC> CREATOR = new AaHO0E.AlLFFp(21);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public BV3sI0[] f7633AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int[] f7634AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public AcNBzu[] f7635AmA8tU;

    static {
        ufibd();
    }

    private static /* synthetic */ void ufibd() {
        char[] charArray = ";75v?95=v:7!v+0=44v\u001261\u001a*1<?=".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'X');
        }
        String str = new String(charArray);
        char[] charArray2 = ";4161,".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'X');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f7633AcNBzu, i);
        parcel.writeIntArray(this.f7634AlLFFp);
        parcel.writeTypedArray(this.f7635AmA8tU, i);
    }
}
