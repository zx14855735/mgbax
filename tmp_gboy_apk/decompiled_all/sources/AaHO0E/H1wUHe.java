package AaHO0E;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class H1wUHe extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<H1wUHe> CREATOR = new H0qugq(0);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f894AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f895AlLFFp;

    static {
        SfbAgq();
    }

    public H1wUHe(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f894AcNBzu = parcel.readInt();
        this.f895AlLFFp = parcel.readInt() != 0;
    }

    private static /* synthetic */ void SfbAgq() {
        char[] charArray = "957t=;7?t85#t)2?66t\u001043\u0018(3>=?".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Z');
        }
        String str = new String(charArray);
        char[] charArray2 = "96343.".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Z');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f894AcNBzu);
        parcel.writeInt(this.f895AlLFFp ? 1 : 0);
    }
}
