package androidx.viewpager.widget;

import ADYaiT.CtFAbx;
import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<AZkASS> CREATOR = new H0qugq(18);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f9539AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Parcelable f9540AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ClassLoader f9541AmA8tU;

    static {
        GGCM();
    }

    public AZkASS(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? AZkASS.class.getClassLoader() : classLoader;
        this.f9539AcNBzu = parcel.readInt();
        this.f9540AlLFFp = parcel.readParcelable(classLoader);
        this.f9541AmA8tU = classLoader;
    }

    private static /* synthetic */ void GGCM() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" position=");
        return CtFAbx.AZkASS("}", this.f9539AcNBzu, sb);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f9539AcNBzu);
        parcel.writeParcelable(this.f9540AlLFFp, i);
    }
}
