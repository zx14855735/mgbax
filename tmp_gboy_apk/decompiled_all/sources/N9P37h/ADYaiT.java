package N9P37h;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends NUtxJj.A2egSU {
    public static final Parcelable.Creator<ADYaiT> CREATOR = new ASJ6gh();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5627AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final String f5628AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final String f5629AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final A2egSU f5630AzWtSf;

    static {
        ieMyz();
    }

    public ADYaiT(int i, String str, A2egSU a2egSU, String str2) {
        this.f5627AcNBzu = i;
        this.f5630AzWtSf = a2egSU;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("8.3 and 8.4 SDKs require non-null email");
        }
        this.f5628AlLFFp = str;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("8.3 and 8.4 SDKs require non-null userId");
        }
        this.f5629AmA8tU = str2;
    }

    private static /* synthetic */ void ieMyz() {
        char[] charArray = "öúø»òôøð»÷úì»æýðùù»ßûü×çüñòð".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 149);
        }
        String str = new String(charArray);
        char[] charArray2 = "öùüûüá".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 149);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5627AcNBzu);
        JrXYwF.A4TApA.ASJ6gh(parcel, 4, this.f5628AlLFFp);
        JrXYwF.A4TApA.ARc23Z(parcel, 7, this.f5630AzWtSf, i);
        JrXYwF.A4TApA.ASJ6gh(parcel, 8, this.f5629AmA8tU);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }
}
