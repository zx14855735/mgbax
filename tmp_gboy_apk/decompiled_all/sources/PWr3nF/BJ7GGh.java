package PWr3nF;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BJ7GGh extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<BJ7GGh> CREATOR = new H0qugq(15);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public CharSequence f7404AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f7405AlLFFp;

    static {
        VqhdWj();
    }

    public BJ7GGh(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f7404AcNBzu = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f7405AlLFFp = parcel.readInt() == 1;
    }

    private static /* synthetic */ void VqhdWj() {
        char[] charArray = "kge&oiem&jgq&{`mdd&BfaJzalom".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\b');
        }
        String str = new String(charArray);
        char[] charArray2 = "kdafa|".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f7404AcNBzu) + "}";
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.f7404AcNBzu, parcel, i);
        parcel.writeInt(this.f7405AlLFFp ? 1 : 0);
    }
}
