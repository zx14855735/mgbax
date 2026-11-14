package NCeV4Q;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends NUtxJj.A2egSU {
    public static final Parcelable.Creator<A2egSU> CREATOR = new B2KMhB();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5631AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final String f5632AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final N9P37h.A5SV6n f5633AmA8tU;

    static {
        pByZ();
    }

    public A2egSU(int i, String str, N9P37h.A5SV6n a5SV6n) {
        this.f5631AcNBzu = i;
        NUY5pn.AYUAbz.ADYaiT(str);
        this.f5632AlLFFp = str;
        this.f5633AmA8tU = a5SV6n;
    }

    private static /* synthetic */ void pByZ() {
        char[] charArray = "ßÓÑ\u0092ÛÝÑÙ\u0092ÞÓÅ\u0092ÏÔÙÐÐ\u0092öÒÕþÎÕØÛÙ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 188);
        }
        String str = new String(charArray);
        char[] charArray2 = "ßÐÕÒÕÈ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 188);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            A2egSU a2egSU = (A2egSU) obj;
            N9P37h.A5SV6n a5SV6n = a2egSU.f5633AmA8tU;
            if (!this.f5632AlLFFp.equals(a2egSU.f5632AlLFFp)) {
                return false;
            }
            N9P37h.A5SV6n a5SV6n2 = this.f5633AmA8tU;
            return a5SV6n2 == null ? a5SV6n == null : a5SV6n2.equals(a5SV6n);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        AZOQYO azoqyo = new AZOQYO();
        azoqyo.A2egSU(this.f5632AlLFFp);
        azoqyo.A2egSU(this.f5633AmA8tU);
        return azoqyo.f5649A2egSU;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5631AcNBzu);
        JrXYwF.A4TApA.ASJ6gh(parcel, 2, this.f5632AlLFFp);
        JrXYwF.A4TApA.ARc23Z(parcel, 5, this.f5633AmA8tU, i);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }
}
