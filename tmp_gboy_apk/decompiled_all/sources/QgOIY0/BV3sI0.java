package QgOIY0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class BV3sI0 implements Parcelable {
    public static final Parcelable.Creator<BV3sI0> CREATOR = new AaHO0E.AlLFFp(22);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final String f7636AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f7637AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final boolean f7638AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f7639AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f7640B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final String f7641B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final boolean f7642B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final boolean f7643B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Bundle f7644B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final boolean f7645B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public Bundle f7646BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public B2KMhB f7647BI9f7h;

    static {
        DOeqZIG();
    }

    public BV3sI0(B2KMhB b2KMhB) {
        this.f7636AcNBzu = b2KMhB.getClass().getName();
        this.f7637AlLFFp = b2KMhB.f7574CASmeH;
        this.f7638AmA8tU = b2KMhB.f7582CikNvS;
        this.f7639AzWtSf = b2KMhB.f7556B25kr6;
        this.f7640B25kr6 = b2KMhB.f7557B2KMhB;
        this.f7641B2KMhB = b2KMhB.f7558B3GDIM;
        this.f7642B3GDIM = b2KMhB.f7561B9tovu;
        this.f7643B4ZgIw = b2KMhB.f7560B7CMnp;
        this.f7644B7CMnp = b2KMhB.f7576COJEAR;
        this.f7645B9tovu = b2KMhB.f7559B4ZgIw;
    }

    private static /* synthetic */ void DOeqZIG() {
        char[] charArray = "957t=;7?t85#t)2?66t\u001043\u0018(3>=?".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Z');
        }
        String str = new String(charArray);
        char[] charArray2 = "96343.".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Z');
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
        parcel.writeString(this.f7636AcNBzu);
        parcel.writeInt(this.f7637AlLFFp);
        parcel.writeInt(this.f7638AmA8tU ? 1 : 0);
        parcel.writeInt(this.f7639AzWtSf);
        parcel.writeInt(this.f7640B25kr6);
        parcel.writeString(this.f7641B2KMhB);
        parcel.writeInt(this.f7642B3GDIM ? 1 : 0);
        parcel.writeInt(this.f7643B4ZgIw ? 1 : 0);
        parcel.writeBundle(this.f7644B7CMnp);
        parcel.writeInt(this.f7645B9tovu ? 1 : 0);
        parcel.writeBundle(this.f7646BChYOn);
    }

    public BV3sI0(Parcel parcel) {
        this.f7636AcNBzu = parcel.readString();
        this.f7637AlLFFp = parcel.readInt();
        this.f7638AmA8tU = parcel.readInt() != 0;
        this.f7639AzWtSf = parcel.readInt();
        this.f7640B25kr6 = parcel.readInt();
        this.f7641B2KMhB = parcel.readString();
        this.f7642B3GDIM = parcel.readInt() != 0;
        this.f7643B4ZgIw = parcel.readInt() != 0;
        this.f7644B7CMnp = parcel.readBundle();
        this.f7645B9tovu = parcel.readInt() != 0;
        this.f7646BChYOn = parcel.readBundle();
    }
}
