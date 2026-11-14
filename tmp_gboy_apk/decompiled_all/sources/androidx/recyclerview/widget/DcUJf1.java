package androidx.recyclerview.widget;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DcUJf1 extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<DcUJf1> CREATOR = new H0qugq(17);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Parcelable f9360AcNBzu;

    static {
        nkUS();
    }

    public DcUJf1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f9360AcNBzu = parcel.readParcelable(classLoader == null ? RecyclerView.ARc23Z.class.getClassLoader() : classLoader);
    }

    private static /* synthetic */ void nkUS() {
        char[] charArray = "ÄÈÊ\u0089ÀÆÊÂ\u0089ÅÈÞ\u0089ÔÏÂËË\u0089íÉÎåÕÎÃÀÂ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 167);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÄËÎÉÎÓ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 167);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f9360AcNBzu, 0);
    }
}
