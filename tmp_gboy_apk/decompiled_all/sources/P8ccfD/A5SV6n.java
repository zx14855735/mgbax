package P8ccfD;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<A5SV6n> CREATOR = new H0qugq(12);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public String f6962AcNBzu;

    static {
        hzufNwH();
    }

    public A5SV6n(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6962AcNBzu = parcel.readString();
    }

    private static /* synthetic */ void hzufNwH() {
        char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 170);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 170);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f6962AcNBzu);
    }
}
