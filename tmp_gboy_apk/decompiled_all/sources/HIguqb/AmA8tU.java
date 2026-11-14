package HIguqb;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU extends B2KMhB {
    public static final Parcelable.Creator<AmA8tU> CREATOR = new AaHO0E.AlLFFp(11);

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f3374AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f3375AzWtSf;

    static {
        HOwFmR();
    }

    public AmA8tU(Parcel parcel) {
        super(parcel);
        this.f3374AmA8tU = parcel.readInt();
        this.f3375AzWtSf = parcel.readInt();
    }

    private static /* synthetic */ void HOwFmR() {
        char[] charArray = "ÆÊÈ\u008bÂÄÈÀ\u008bÇÊÜ\u008bÖÍÀÉÉ\u008bïËÌç×ÌÁÂÀ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 165);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÆÉÌËÌÑ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 165);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HIguqb.B2KMhB, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // HIguqb.B2KMhB, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f3374AmA8tU);
        parcel.writeInt(this.f3375AzWtSf);
    }
}
