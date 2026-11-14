package O1Vn2F;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<A5SV6n> CREATOR = new H0qugq(6);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f6152AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f6153AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final boolean f6154AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final boolean f6155AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final boolean f6156B25kr6;

    static {
        pfhjO();
    }

    public A5SV6n(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6152AcNBzu = parcel.readInt();
        this.f6153AlLFFp = parcel.readInt();
        this.f6154AmA8tU = parcel.readInt() == 1;
        this.f6155AzWtSf = parcel.readInt() == 1;
        this.f6156B25kr6 = parcel.readInt() == 1;
    }

    private static /* synthetic */ void pfhjO() {
        char[] charArray = "ÒÞÜ\u009fÖÐÜÔ\u009fÓÞÈ\u009fÂÙÔÝÝ\u009fûßØóÃØÕÖÔ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 177);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÒÝØßØÅ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 177);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f6152AcNBzu);
        parcel.writeInt(this.f6153AlLFFp);
        parcel.writeInt(this.f6154AmA8tU ? 1 : 0);
        parcel.writeInt(this.f6155AzWtSf ? 1 : 0);
        parcel.writeInt(this.f6156B25kr6 ? 1 : 0);
    }

    public A5SV6n(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f6152AcNBzu = bottomSheetBehavior.f11427D6DOie;
        this.f6153AlLFFp = bottomSheetBehavior.f11393B25kr6;
        this.f6154AmA8tU = bottomSheetBehavior.f11390AlLFFp;
        this.f6155AzWtSf = bottomSheetBehavior.f11422CqNSpT;
        this.f6156B25kr6 = bottomSheetBehavior.f11423CrfGsy;
    }
}
