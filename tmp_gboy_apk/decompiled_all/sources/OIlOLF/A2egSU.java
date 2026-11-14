package OIlOLF;

import ADYaiT.CtFAbx;
import AaHO0E.AlLFFp;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends View.BaseSavedState {
    public static final Parcelable.Creator<A2egSU> CREATOR = new AlLFFp(17);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f6270AcNBzu;

    static {
        jdIEA();
    }

    private static /* synthetic */ void jdIEA() {
        char[] charArray = "ÙÕ×\u0094ÝÛ×ß\u0094ØÕÃ\u0094ÉÒßÖÖ\u0094ðÔÓøÈÓÞÝß".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 186);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÙÖÓÔÓÎ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 186);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" CheckedState=");
        int i = this.f6270AcNBzu;
        return CtFAbx.B25kr6(sb, i != 1 ? i != 2 ? "unchecked" : "indeterminate" : "checked", "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(Integer.valueOf(this.f6270AcNBzu));
    }
}
