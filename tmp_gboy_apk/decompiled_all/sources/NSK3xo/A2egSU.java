package NSK3xo;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends NUtxJj.A2egSU {
    public static final Parcelable.Creator<A2egSU> CREATOR = new B25kr6();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5919AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final String f5920AlLFFp;

    static {
        zcaQovy();
    }

    public A2egSU(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("scopeUri must not be null or empty");
        }
        this.f5919AcNBzu = i;
        this.f5920AlLFFp = str;
    }

    private static /* synthetic */ void zcaQovy() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A2egSU)) {
            return false;
        }
        return this.f5920AlLFFp.equals(((A2egSU) obj).f5920AlLFFp);
    }

    public final int hashCode() {
        return this.f5920AlLFFp.hashCode();
    }

    public final String toString() {
        return this.f5920AlLFFp;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5919AcNBzu);
        JrXYwF.A4TApA.ASJ6gh(parcel, 2, this.f5920AlLFFp);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }
}
