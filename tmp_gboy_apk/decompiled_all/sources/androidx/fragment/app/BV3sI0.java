package androidx.fragment.app;

import AaHO0E.H0qugq;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BV3sI0 implements Parcelable {
    public static final Parcelable.Creator<BV3sI0> CREATOR = new H0qugq(16);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Bundle f8796AcNBzu;

    static {
        KsYmZo();
    }

    public BV3sI0(Bundle bundle) {
        this.f8796AcNBzu = bundle;
    }

    private static /* synthetic */ void KsYmZo() {
        char[] charArray = "±½¿üµ³¿·ü°½«ü¡º·¾¾ü\u0098¼»\u0090 »¶µ·".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 210);
        }
        String str = new String(charArray);
        char[] charArray2 = "±¾»¼»¦".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 210);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f8796AcNBzu);
    }

    public BV3sI0(Parcel parcel, ClassLoader classLoader) {
        Bundle readBundle = parcel.readBundle();
        this.f8796AcNBzu = readBundle;
        if (classLoader == null || readBundle == null) {
            return;
        }
        readBundle.setClassLoader(classLoader);
    }
}
