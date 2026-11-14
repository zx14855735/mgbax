package NGepWW;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class C2rE4F extends NUtxJj.A2egSU {
    public static final Parcelable.Creator<C2rE4F> CREATOR = new C4FrIb();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5707AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final NUY5pn.AZOQYO f5708AlLFFp;

    static {
        EcjVNG();
    }

    public C2rE4F(int i, NUY5pn.AZOQYO azoqyo) {
        this.f5707AcNBzu = i;
        this.f5708AlLFFp = azoqyo;
    }

    private static /* synthetic */ void EcjVNG() {
        char[] charArray = "\u00ad¡£à©¯£«à¬¡·à½¦«¢¢à\u0084 §\u008c¼§ª©«".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 206);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u00ad¢§ §º".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 206);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5707AcNBzu);
        JrXYwF.A4TApA.ARc23Z(parcel, 2, this.f5708AlLFFp, i);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }
}
