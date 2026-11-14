package NGepWW;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CASmeH extends NUtxJj.A2egSU {
    public static final Parcelable.Creator<CASmeH> CREATOR = new CNPG0E();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5709AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final NOd7IU.A2egSU f5710AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final NUY5pn.AaHO0E f5711AmA8tU;

    static {
        YYSNq();
    }

    public CASmeH(int i, NOd7IU.A2egSU a2egSU, NUY5pn.AaHO0E aaHO0E) {
        this.f5709AcNBzu = i;
        this.f5710AlLFFp = a2egSU;
        this.f5711AmA8tU = aaHO0E;
    }

    private static /* synthetic */ void YYSNq() {
        char[] charArray = "ùõ÷´ýû÷ÿ´øõã´éòÿöö´ÐôóØèóþýÿ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 154);
        }
        String str = new String(charArray);
        char[] charArray2 = "ùöóôóî".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 154);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5709AcNBzu);
        JrXYwF.A4TApA.ARc23Z(parcel, 2, this.f5710AlLFFp, i);
        JrXYwF.A4TApA.ARc23Z(parcel, 3, this.f5711AmA8tU, i);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }
}
