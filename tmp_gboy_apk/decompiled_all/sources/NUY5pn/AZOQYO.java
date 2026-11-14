package NUY5pn;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO extends NUtxJj.A2egSU {
    public static final Parcelable.Creator<AZOQYO> CREATOR = new AZkASS();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5950AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Account f5951AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f5952AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final N9P37h.A2egSU f5953AzWtSf;

    static {
        WkAT();
    }

    public AZOQYO(int i, Account account, int i2, N9P37h.A2egSU a2egSU) {
        this.f5950AcNBzu = i;
        this.f5951AlLFFp = account;
        this.f5952AmA8tU = i2;
        this.f5953AzWtSf = a2egSU;
    }

    private static /* synthetic */ void WkAT() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5950AcNBzu);
        JrXYwF.A4TApA.ARc23Z(parcel, 2, this.f5951AlLFFp, i);
        JrXYwF.A4TApA.AcNBzu(parcel, 3, 4);
        parcel.writeInt(this.f5952AmA8tU);
        JrXYwF.A4TApA.ARc23Z(parcel, 4, this.f5953AzWtSf, i);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }
}
