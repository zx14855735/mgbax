package CikNvS;

import ADYaiT.CtFAbx;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends View.BaseSavedState {
    public static final Parcelable.Creator<AaHO0E> CREATOR = new AaHO0E.AlLFFp(2);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1810AcNBzu;

    static {
        ajXji();
    }

    private static /* synthetic */ void ajXji() {
        char[] charArray = "òþü¿öðüô¿óþè¿âùôýý¿ÛÿøÓãøõöô".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 145);
        }
        String str = new String(charArray);
        char[] charArray2 = "òýøÿøå".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 145);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" scrollPosition=");
        return CtFAbx.AZkASS("}", this.f1810AcNBzu, sb);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1810AcNBzu);
    }
}
