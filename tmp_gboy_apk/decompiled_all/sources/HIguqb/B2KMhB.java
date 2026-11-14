package HIguqb;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class B2KMhB implements Parcelable {
    public static final Parcelable.Creator<B2KMhB> CREATOR = new AaHO0E.AlLFFp(14);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final long f3380AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f3381AlLFFp;

    static {
        FiKi();
    }

    public B2KMhB(Parcel parcel) {
        this.f3380AcNBzu = parcel.readLong();
        this.f3381AlLFFp = parcel.readInt();
    }

    private static /* synthetic */ void FiKi() {
        char[] charArray = "ÜÐÒ\u0091ØÞÒÚ\u0091ÝÐÆ\u0091Ì×ÚÓÓ\u0091õÑÖýÍÖÛØÚ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 191);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÜÓÖÑÖË".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 191);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f3380AcNBzu);
        parcel.writeInt(this.f3381AlLFFp);
    }
}
