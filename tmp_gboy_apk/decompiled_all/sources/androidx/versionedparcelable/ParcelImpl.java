package androidx.versionedparcelable;

import AaHO0E.AlLFFp;
import DdagTj.A4TApA;
import DdagTj.A5SV6n;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new AlLFFp(10);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A5SV6n f9527AcNBzu;

    static {
        IvQW();
    }

    public ParcelImpl(Parcel parcel) {
        this.f9527AcNBzu = new A4TApA(parcel).ASJ6gh();
    }

    private static /* synthetic */ void IvQW() {
        char[] charArray = "\u001d\u0011\u0013P\u0019\u001f\u0013\u001bP\u001c\u0011\u0007P\r\u0016\u001b\u0012\u0012P4\u0010\u0017<\f\u0017\u001a\u0019\u001b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '~');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001d\u0012\u0017\u0010\u0017\n".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '~');
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
        new A4TApA(parcel).AZOQYO(this.f9527AcNBzu);
    }
}
