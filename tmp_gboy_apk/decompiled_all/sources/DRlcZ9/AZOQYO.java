package DRlcZ9;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO extends AcNBzu {
    public static final Parcelable.Creator<AZOQYO> CREATOR = new AaHO0E.AlLFFp(5);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public HashSet f2084AcNBzu;

    static {
        jrxktC();
    }

    public AZOQYO(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        this.f2084AcNBzu = new HashSet();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Collections.addAll(this.f2084AcNBzu, strArr);
    }

    private static /* synthetic */ void jrxktC() {
        char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 220);
        }
        String str = new String(charArray);
        char[] charArray2 = "¿°µ²µ¨".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 220);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2084AcNBzu.size());
        HashSet hashSet = this.f2084AcNBzu;
        parcel.writeStringArray((String[]) hashSet.toArray(new String[hashSet.size()]));
    }

    public AZOQYO() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
