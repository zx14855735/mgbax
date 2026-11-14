package PSeUZ5;

import AaHO0E.AlLFFp;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends View.BaseSavedState {
    public static final Parcelable.Creator<A5SV6n> CREATOR = new AlLFFp(19);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public float f7175AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f7176AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ArrayList f7177AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public float f7178AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f7179B25kr6;

    static {
        eqbtzpZ();
    }

    private static /* synthetic */ void eqbtzpZ() {
        char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 127);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 127);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f7175AcNBzu);
        parcel.writeFloat(this.f7176AlLFFp);
        parcel.writeList(this.f7177AmA8tU);
        parcel.writeFloat(this.f7178AzWtSf);
        parcel.writeBooleanArray(new boolean[]{this.f7179B25kr6});
    }
}
