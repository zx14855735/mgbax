package DRlcZ9;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BpkvW3 extends AcNBzu {
    public static final Parcelable.Creator<BpkvW3> CREATOR = new AaHO0E.AlLFFp(8);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f2148AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f2149AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f2150AmA8tU;

    static {
        WcrsRVE();
    }

    public BpkvW3(Parcel parcel) {
        super(parcel);
        this.f2148AcNBzu = parcel.readInt();
        this.f2149AlLFFp = parcel.readInt();
        this.f2150AmA8tU = parcel.readInt();
    }

    private static /* synthetic */ void WcrsRVE() {
        char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 220);
        }
        String str = new String(charArray);
        char[] charArray2 = "¿°µ²µ¨".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 220);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2148AcNBzu);
        parcel.writeInt(this.f2149AlLFFp);
        parcel.writeInt(this.f2150AmA8tU);
    }

    public BpkvW3() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
