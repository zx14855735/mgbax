package androidx.swiperefreshlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.EdQ5bb;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends View.BaseSavedState {
    public static final Parcelable.Creator<AZkASS> CREATOR = new EdQ5bb(1);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final boolean f9526AcNBzu;

    static {
        ICKeoKR();
    }

    public AZkASS(Parcelable parcelable, boolean z) {
        super(parcelable);
        this.f9526AcNBzu = z;
    }

    private static /* synthetic */ void ICKeoKR() {
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

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f9526AcNBzu ? (byte) 1 : (byte) 0);
    }

    public AZkASS(Parcel parcel) {
        super(parcel);
        this.f9526AcNBzu = parcel.readByte() != 0;
    }
}
