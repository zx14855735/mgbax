package DRlcZ9;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B7CMnp extends AcNBzu {
    public static final Parcelable.Creator<B7CMnp> CREATOR = new AaHO0E.AlLFFp(7);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f2112AcNBzu;

    static {
        aImEGzz();
    }

    public B7CMnp(Parcel parcel) {
        super(parcel);
        this.f2112AcNBzu = parcel.readInt();
    }

    private static /* synthetic */ void aImEGzz() {
        char[] charArray = "òþü¿öðüô¿óþè¿âùôýý¿ÛÿøÓãøõöô".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 145);
        }
        String str = new String(charArray);
        char[] charArray2 = "òýøÿøå".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 145);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2112AcNBzu);
    }

    public B7CMnp(int i) {
        super(AbsSavedState.EMPTY_STATE);
        this.f2112AcNBzu = i;
    }
}
