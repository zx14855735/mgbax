package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D07BeM implements Parcelable {
    public static final Parcelable.Creator<D07BeM> CREATOR = new AaHO0E.AlLFFp(27);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public String f8866AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f8867AlLFFp;

    static {
        MtgV();
    }

    public D07BeM(String str, int i) {
        this.f8866AcNBzu = str;
        this.f8867AlLFFp = i;
    }

    private static /* synthetic */ void MtgV() {
        char[] charArray = "\u009f\u0093\u0091Ò\u009b\u009d\u0091\u0099Ò\u009e\u0093\u0085Ò\u008f\u0094\u0099\u0090\u0090Ò¶\u0092\u0095¾\u008e\u0095\u0098\u009b\u0099".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 252);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009f\u0090\u0095\u0092\u0095\u0088".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 252);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8866AcNBzu);
        parcel.writeInt(this.f8867AlLFFp);
    }
}
