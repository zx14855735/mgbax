package De4eam;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU extends View.BaseSavedState {
    public static final Parcelable.Creator<AmA8tU> CREATOR = new H0qugq(4);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f2416AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f2417AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Parcelable f2418AmA8tU;

    static {
        TKnloAC();
    }

    public AmA8tU(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2416AcNBzu = parcel.readInt();
        this.f2417AlLFFp = parcel.readInt();
        this.f2418AmA8tU = parcel.readParcelable(classLoader);
    }

    private static /* synthetic */ void TKnloAC() {
        char[] charArray = "fjh+bdh`+gj|+vm`ii+OklGwlab`".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 5);
        }
        String str = new String(charArray);
        char[] charArray2 = "filklq".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 5);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2416AcNBzu);
        parcel.writeInt(this.f2417AlLFFp);
        parcel.writeParcelable(this.f2418AmA8tU, i);
    }
}
