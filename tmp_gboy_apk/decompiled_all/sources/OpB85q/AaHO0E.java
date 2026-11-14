package OpB85q;

import Oay4Bh.BJ7GGh;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements Parcelable {
    public static final Parcelable.Creator<AaHO0E> CREATOR = new AaHO0E.AlLFFp(18);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f6779AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BJ7GGh f6780AlLFFp;

    static {
        sVmHSZe();
    }

    private static /* synthetic */ void sVmHSZe() {
        char[] charArray = "P\\^\u001dTR^V\u001dQ\\J\u001d@[V__\u001dy]ZqAZWTV".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '3');
        }
        String str = new String(charArray);
        char[] charArray2 = "P_Z]ZG".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '3');
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
        parcel.writeInt(this.f6779AcNBzu);
        parcel.writeParcelable(this.f6780AlLFFp, 0);
    }
}
