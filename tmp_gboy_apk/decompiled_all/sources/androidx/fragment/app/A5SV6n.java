package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements Parcelable {
    public static final Parcelable.Creator<A5SV6n> CREATOR = new AaHO0E.AlLFFp(26);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f8719AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f8720AlLFFp;

    static {
        GzbNY();
    }

    public A5SV6n(Parcel parcel) {
        this.f8719AcNBzu = parcel.createStringArrayList();
        this.f8720AlLFFp = parcel.createTypedArrayList(A4TApA.CREATOR);
    }

    private static /* synthetic */ void GzbNY() {
        char[] charArray = "êæä§îèäì§ëæð§úáìåå§ÃçàËûàíîì".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 137);
        }
        String str = new String(charArray);
        char[] charArray2 = "êåàçàý".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 137);
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
        parcel.writeStringList(this.f8719AcNBzu);
        parcel.writeTypedList(this.f8720AlLFFp);
    }
}
