package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements Parcelable {
    public static final Parcelable.Creator<A4TApA> CREATOR = new AaHO0E.AlLFFp(25);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int[] f8705AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f8706AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int[] f8707AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int[] f8708AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f8709B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final String f8710B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f8711B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f8712B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final CharSequence f8713B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final int f8714B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final CharSequence f8715BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final ArrayList f8716BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final ArrayList f8717BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final boolean f8718BJ7GGh;

    static {
        LfUbEXS();
    }

    public A4TApA(A2egSU a2egSU) {
        int size = a2egSU.f8917A2egSU.size();
        this.f8705AcNBzu = new int[size * 6];
        if (!a2egSU.f8922ASJ6gh) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f8706AlLFFp = new ArrayList(size);
        this.f8707AmA8tU = new int[size];
        this.f8708AzWtSf = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            DXnQ0V dXnQ0V = (DXnQ0V) a2egSU.f8917A2egSU.get(i2);
            int i3 = i + 1;
            this.f8705AcNBzu[i] = dXnQ0V.f8909A2egSU;
            ArrayList arrayList = this.f8706AlLFFp;
            Fragment fragment = dXnQ0V.f8910A4TApA;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f8705AcNBzu;
            iArr[i3] = dXnQ0V.f8911A5SV6n ? 1 : 0;
            iArr[i + 2] = dXnQ0V.f8912ADYaiT;
            iArr[i + 3] = dXnQ0V.AMqCpz;
            int i4 = i + 5;
            iArr[i + 4] = dXnQ0V.f8913ARc23Z;
            i += 6;
            iArr[i4] = dXnQ0V.f8914ASJ6gh;
            this.f8707AmA8tU[i2] = dXnQ0V.f8915AYUAbz.ordinal();
            this.f8708AzWtSf[i2] = dXnQ0V.f8916AZOQYO.ordinal();
        }
        this.f8709B25kr6 = a2egSU.f8921ARc23Z;
        this.f8710B2KMhB = a2egSU.f8924AZOQYO;
        this.f8711B3GDIM = a2egSU.f8704B7CMnp;
        this.f8712B4ZgIw = a2egSU.f8925AZkASS;
        this.f8713B7CMnp = a2egSU.f8926AaHO0E;
        this.f8714B9tovu = a2egSU.f8927AcNBzu;
        this.f8715BChYOn = a2egSU.f8928AlLFFp;
        this.f8716BI9f7h = a2egSU.f8929AmA8tU;
        this.f8717BIYEnU = a2egSU.f8930AzWtSf;
        this.f8718BJ7GGh = a2egSU.f8931B25kr6;
    }

    private static /* synthetic */ void LfUbEXS() {
        char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 204);
        }
        String str = new String(charArray);
        char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 204);
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
        parcel.writeIntArray(this.f8705AcNBzu);
        parcel.writeStringList(this.f8706AlLFFp);
        parcel.writeIntArray(this.f8707AmA8tU);
        parcel.writeIntArray(this.f8708AzWtSf);
        parcel.writeInt(this.f8709B25kr6);
        parcel.writeString(this.f8710B2KMhB);
        parcel.writeInt(this.f8711B3GDIM);
        parcel.writeInt(this.f8712B4ZgIw);
        TextUtils.writeToParcel(this.f8713B7CMnp, parcel, 0);
        parcel.writeInt(this.f8714B9tovu);
        TextUtils.writeToParcel(this.f8715BChYOn, parcel, 0);
        parcel.writeStringList(this.f8716BI9f7h);
        parcel.writeStringList(this.f8717BIYEnU);
        parcel.writeInt(this.f8718BJ7GGh ? 1 : 0);
    }

    public A4TApA(Parcel parcel) {
        this.f8705AcNBzu = parcel.createIntArray();
        this.f8706AlLFFp = parcel.createStringArrayList();
        this.f8707AmA8tU = parcel.createIntArray();
        this.f8708AzWtSf = parcel.createIntArray();
        this.f8709B25kr6 = parcel.readInt();
        this.f8710B2KMhB = parcel.readString();
        this.f8711B3GDIM = parcel.readInt();
        this.f8712B4ZgIw = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f8713B7CMnp = (CharSequence) creator.createFromParcel(parcel);
        this.f8714B9tovu = parcel.readInt();
        this.f8715BChYOn = (CharSequence) creator.createFromParcel(parcel);
        this.f8716BI9f7h = parcel.createStringArrayList();
        this.f8717BIYEnU = parcel.createStringArrayList();
        this.f8718BJ7GGh = parcel.readInt() != 0;
    }
}
