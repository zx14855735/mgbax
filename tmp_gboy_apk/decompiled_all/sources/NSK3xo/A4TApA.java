package NSK3xo;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends NUtxJj.A2egSU implements AmA8tU {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final A4TApA f5921B25kr6 = new A4TApA(0, null);

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final A4TApA f5922B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final A4TApA f5923B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final A4TApA f5924B4ZgIw;
    public static final Parcelable.Creator<A4TApA> CREATOR;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5925AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f5926AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final String f5927AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final PendingIntent f5928AzWtSf;

    static {
        new A4TApA(14, null);
        f5922B2KMhB = new A4TApA(8, null);
        f5923B3GDIM = new A4TApA(15, null);
        f5924B4ZgIw = new A4TApA(16, null);
        new A4TApA(17, null);
        new A4TApA(18, null);
        CREATOR = new B2KMhB();
        mJUfYTI();
    }

    public A4TApA(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f5925AcNBzu = i;
        this.f5926AlLFFp = i2;
        this.f5927AmA8tU = str;
        this.f5928AzWtSf = pendingIntent;
    }

    private static /* synthetic */ void mJUfYTI() {
        char[] charArray = "ÒÞÜ\u009fÖÐÜÔ\u009fÓÞÈ\u009fÂÙÔÝÝ\u009fûßØóÃØÕÖÔ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 177);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÒÝØßØÅ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 177);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // NSK3xo.AmA8tU
    public final A4TApA a() {
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof A4TApA)) {
            return false;
        }
        A4TApA a4TApA = (A4TApA) obj;
        return this.f5925AcNBzu == a4TApA.f5925AcNBzu && this.f5926AlLFFp == a4TApA.f5926AlLFFp && NUY5pn.AYUAbz.ARc23Z(this.f5927AmA8tU, a4TApA.f5927AmA8tU) && NUY5pn.AYUAbz.ARc23Z(this.f5928AzWtSf, a4TApA.f5928AzWtSf);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5925AcNBzu), Integer.valueOf(this.f5926AlLFFp), this.f5927AmA8tU, this.f5928AzWtSf});
    }

    public final String toString() {
        I3HV03.A4TApA a4TApA = new I3HV03.A4TApA(this);
        String str = this.f5927AmA8tU;
        if (str == null) {
            str = com.bumptech.glide.A5SV6n.A5SV6n(this.f5926AlLFFp);
        }
        a4TApA.AZOQYO("statusCode", str);
        a4TApA.AZOQYO("resolution", this.f5928AzWtSf);
        return a4TApA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5926AlLFFp);
        JrXYwF.A4TApA.ASJ6gh(parcel, 2, this.f5927AmA8tU);
        JrXYwF.A4TApA.ARc23Z(parcel, 3, this.f5928AzWtSf, i);
        JrXYwF.A4TApA.AcNBzu(parcel, 1000, 4);
        parcel.writeInt(this.f5925AcNBzu);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }

    public A4TApA(int i, String str) {
        this(1, i, null, str);
    }
}
