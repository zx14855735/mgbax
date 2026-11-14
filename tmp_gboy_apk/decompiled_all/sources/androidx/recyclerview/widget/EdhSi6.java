package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EdhSi6 implements Parcelable {
    public static final Parcelable.Creator<EdhSi6> CREATOR = new EdQ5bb(0);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f9387AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f9388AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int[] f9389AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f9390AzWtSf;

    static {
        hlxUOi();
    }

    private static /* synthetic */ void hlxUOi() {
        char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 204);
        }
        String str = new String(charArray);
        char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 204);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f9387AcNBzu + ", mGapDir=" + this.f9388AlLFFp + ", mHasUnwantedGapAfter=" + this.f9390AzWtSf + ", mGapPerSpan=" + Arrays.toString(this.f9389AmA8tU) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9387AcNBzu);
        parcel.writeInt(this.f9388AlLFFp);
        parcel.writeInt(this.f9390AzWtSf ? 1 : 0);
        int[] iArr = this.f9389AmA8tU;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f9389AmA8tU);
        }
    }
}
