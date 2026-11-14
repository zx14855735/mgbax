package DRlcZ9;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class C2rE4F extends AcNBzu {
    public static final Parcelable.Creator<C2rE4F> CREATOR = new AaHO0E.AlLFFp(9);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f2151AcNBzu;

    static {
        kAMdzVA();
    }

    public C2rE4F(Parcel parcel) {
        super(parcel);
        this.f2151AcNBzu = parcel.readInt() == 1;
    }

    private static /* synthetic */ void kAMdzVA() {
        char[] charArray = "¦ª¨ë¢¤¨ ë§ª¼ë¶\u00ad ©©ë\u008f«¬\u0087·¬¡¢ ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 197);
        }
        String str = new String(charArray);
        char[] charArray2 = "¦©¬«¬±".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 197);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2151AcNBzu ? 1 : 0);
    }

    public C2rE4F() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
