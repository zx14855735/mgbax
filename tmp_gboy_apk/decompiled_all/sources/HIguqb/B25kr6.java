package HIguqb;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 extends B2KMhB {
    public static final Parcelable.Creator<B25kr6> CREATOR = new AaHO0E.AlLFFp(13);

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f3378AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f3379AzWtSf;

    static {
        uEjET();
    }

    public B25kr6(Parcel parcel) {
        super(parcel);
        this.f3378AmA8tU = parcel.readInt();
        this.f3379AzWtSf = parcel.readInt();
    }

    private static /* synthetic */ void uEjET() {
        char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'N');
        }
        String str = new String(charArray);
        char[] charArray2 = "-\"' ':".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'N');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HIguqb.B2KMhB, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // HIguqb.B2KMhB, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f3378AmA8tU);
        parcel.writeInt(this.f3379AzWtSf);
    }
}
