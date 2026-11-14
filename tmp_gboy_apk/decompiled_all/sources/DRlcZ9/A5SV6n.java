package DRlcZ9;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends AcNBzu {
    public static final Parcelable.Creator<A5SV6n> CREATOR = new AaHO0E.AlLFFp(3);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public String f2072AcNBzu;

    static {
        rbDls();
    }

    public A5SV6n(Parcel parcel) {
        super(parcel);
        this.f2072AcNBzu = parcel.readString();
    }

    private static /* synthetic */ void rbDls() {
        char[] charArray = "1=?|53?7|0=+|!:7>>|\u0018<;\u0010 ;657".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'R');
        }
        String str = new String(charArray);
        char[] charArray2 = "1>;<;&".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'R');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2072AcNBzu);
    }

    public A5SV6n() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
