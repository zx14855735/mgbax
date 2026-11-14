package PMC23c;

import AaHO0E.H0qugq;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends CmUvjW.A4TApA {
    public static final Parcelable.Creator<ADYaiT> CREATOR = new H0qugq(14);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f7171AcNBzu;

    static {
        rzlXc();
    }

    public ADYaiT(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f7171AcNBzu = parcel.readInt();
    }

    private static /* synthetic */ void rzlXc() {
        char[] charArray = "×ÛÙ\u009aÓÕÙÑ\u009aÖÛÍ\u009aÇÜÑØØ\u009aþÚÝöÆÝÐÓÑ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 180);
        }
        String str = new String(charArray);
        char[] charArray2 = "×ØÝÚÝÀ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 180);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // CmUvjW.A4TApA, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f7171AcNBzu);
    }

    public ADYaiT(SideSheetBehavior sideSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f7171AcNBzu = sideSheetBehavior.f11795B4ZgIw;
    }
}
