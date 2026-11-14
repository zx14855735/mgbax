package DRlcZ9;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends AcNBzu {
    public static final Parcelable.Creator<ARc23Z> CREATOR = new AaHO0E.AlLFFp(4);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public String f2078AcNBzu;

    static {
        tdWw();
    }

    public ARc23Z(Parcel parcel) {
        super(parcel);
        this.f2078AcNBzu = parcel.readString();
    }

    private static /* synthetic */ void tdWw() {
        char[] charArray = "®¢ ãª¬ ¨ã¯¢´ã¾¥¨¡¡ã\u0087£¤\u008f¿¤©ª¨".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 205);
        }
        String str = new String(charArray);
        char[] charArray2 = "®¡¤£¤¹".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 205);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2078AcNBzu);
    }

    public ARc23Z() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
