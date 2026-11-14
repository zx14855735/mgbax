package AaHO0E;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CtFAbx extends View.BaseSavedState {
    public static final Parcelable.Creator<CtFAbx> CREATOR = new AlLFFp(1);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f710AcNBzu;

    static {
        pIzt();
    }

    private static /* synthetic */ void pIzt() {
        char[] charArray = "UY[\u0018QW[S\u0018TYO\u0018E^SZZ\u0018|X_tD_RQS".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '6');
        }
        String str = new String(charArray);
        char[] charArray2 = "UZ_X_B".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '6');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f710AcNBzu ? (byte) 1 : (byte) 0);
    }
}
