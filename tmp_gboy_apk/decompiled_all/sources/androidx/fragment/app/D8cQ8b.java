package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D8cQ8b implements Parcelable {
    public static final Parcelable.Creator<D8cQ8b> CREATOR = new AaHO0E.AlLFFp(28);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ArrayList f8872AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ArrayList f8873AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A4TApA[] f8874AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f8875AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public String f8876B25kr6 = null;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ArrayList f8877B2KMhB = new ArrayList();

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ArrayList f8878B3GDIM = new ArrayList();

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ArrayList f8879B4ZgIw;

    static {
        DOJp();
    }

    private static /* synthetic */ void DOJp() {
        char[] charArray = "q}\u007f<us\u007fw<p}k<azw~~<X|{P`{vuw".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 18);
        }
        String str = new String(charArray);
        char[] charArray2 = "q~{|{f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 18);
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
        parcel.writeStringList(this.f8872AcNBzu);
        parcel.writeStringList(this.f8873AlLFFp);
        parcel.writeTypedArray(this.f8874AmA8tU, i);
        parcel.writeInt(this.f8875AzWtSf);
        parcel.writeString(this.f8876B25kr6);
        parcel.writeStringList(this.f8877B2KMhB);
        parcel.writeTypedList(this.f8878B3GDIM);
        parcel.writeTypedList(this.f8879B4ZgIw);
    }
}
