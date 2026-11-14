package OpB85q;

import AaHO0E.H0qugq;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<B25kr6> CREATOR = new H0qugq(10);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Bundle f6789AcNBzu;

    static {
        UgmzS();
    }

    public B25kr6(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6789AcNBzu = parcel.readBundle(classLoader == null ? B25kr6.class.getClassLoader() : classLoader);
    }

    private static /* synthetic */ void UgmzS() {
        char[] charArray = "$(*i &*\"i%(>i4/\"++i\r).\u00055.# \"".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'G');
        }
        String str = new String(charArray);
        char[] charArray2 = "$+.).3".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'G');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.f6789AcNBzu);
    }
}
