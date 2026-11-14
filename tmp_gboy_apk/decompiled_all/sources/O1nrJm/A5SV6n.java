package O1nrJm;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<A5SV6n> CREATOR = new H0qugq(7);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f6160AcNBzu;

    static {
        UZcW();
    }

    public A5SV6n(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            A5SV6n.class.getClassLoader();
        }
        this.f6160AcNBzu = parcel.readInt() == 1;
    }

    private static /* synthetic */ void UZcW() {
        char[] charArray = "´¸ºù°¶º²ùµ¸®ù¤¿²»»ù\u009d¹¾\u0095¥¾³°²".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 215);
        }
        String str = new String(charArray);
        char[] charArray2 = "´»¾¹¾£".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 215);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f6160AcNBzu ? 1 : 0);
    }
}
