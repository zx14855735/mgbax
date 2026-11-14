package NGepWW;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BIYEnU extends NUtxJj.A2egSU implements NSK3xo.AmA8tU {
    public static final Parcelable.Creator<BIYEnU> CREATOR = new BJ7GGh();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5698AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f5699AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Intent f5700AmA8tU;

    static {
        IzJK();
    }

    public BIYEnU() {
        this(2, 0, null);
    }

    private static /* synthetic */ void IzJK() {
        char[] charArray = "_SQ\u0012[]QY\u0012^SE\u0012OTYPP\u0012vRU~NUX[Y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '<');
        }
        String str = new String(charArray);
        char[] charArray2 = "_PURUH".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '<');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // NSK3xo.AmA8tU
    public final NSK3xo.A4TApA a() {
        return this.f5699AlLFFp == 0 ? NSK3xo.A4TApA.f5921B25kr6 : NSK3xo.A4TApA.f5924B4ZgIw;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5698AcNBzu);
        JrXYwF.A4TApA.AcNBzu(parcel, 2, 4);
        parcel.writeInt(this.f5699AlLFFp);
        JrXYwF.A4TApA.ARc23Z(parcel, 3, this.f5700AmA8tU, i);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }

    public BIYEnU(int i, int i2, Intent intent) {
        this.f5698AcNBzu = i;
        this.f5699AlLFFp = i2;
        this.f5700AmA8tU = intent;
    }
}
