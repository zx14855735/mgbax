package CmUvjW;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA implements Parcelable {
    private final Parcelable mSuperState;
    public static final A4TApA EMPTY_STATE = new A2egSU();
    public static final Parcelable.Creator<A4TApA> CREATOR = new H0qugq(2);

    static {
        JNuLAPJ();
    }

    public A4TApA() {
        this.mSuperState = null;
    }

    private static /* synthetic */ void JNuLAPJ() {
        char[] charArray = "\\PR\u0011X^RZ\u0011]PF\u0011LWZSS\u0011uQV}MV[XZ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '?');
        }
        String str = new String(charArray);
        char[] charArray2 = "\\SVQVK".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '?');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }

    public A4TApA(Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public A4TApA(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
    }
}
