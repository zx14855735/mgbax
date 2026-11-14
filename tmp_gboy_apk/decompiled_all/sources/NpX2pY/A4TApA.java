package NpX2pY;

import AaHO0E.AlLFFp;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements Parcelable {
    public static final Parcelable.Creator<A4TApA> CREATOR = new AlLFFp(16);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f6085AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Integer f6086AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Integer f6087AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Integer f6088AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Integer f6089B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Integer f6090B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Integer f6091B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public Integer f6092B4ZgIw;

    /* renamed from: B9tovu, reason: collision with root package name */
    public String f6094B9tovu;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public Locale f6098BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public String f6099BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public CharSequence f6100BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f6101BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f6102BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public Integer f6103BmvVmW;
    public Integer BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public Integer f6105C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public Integer f6106C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public Integer f6107CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public Integer f6108CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public Integer f6109COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public Integer f6110CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public Integer f6111CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public Integer f6112CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public Boolean f6113CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public Integer f6114Cd8JRx;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f6093B7CMnp = 255;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f6095BChYOn = -2;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f6096BI9f7h = -2;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f6097BIYEnU = -2;

    /* renamed from: BniPrB, reason: collision with root package name */
    public Boolean f6104BniPrB = Boolean.TRUE;

    static {
        zqKBg();
    }

    private static /* synthetic */ void zqKBg() {
        char[] charArray = "Q]_\u001cUS_W\u001cP]K\u001cAZW^^\u001cx\\[p@[VUW".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '2');
        }
        String str = new String(charArray);
        char[] charArray2 = "Q^[\\[F".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '2');
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
        parcel.writeInt(this.f6085AcNBzu);
        parcel.writeSerializable(this.f6086AlLFFp);
        parcel.writeSerializable(this.f6087AmA8tU);
        parcel.writeSerializable(this.f6088AzWtSf);
        parcel.writeSerializable(this.f6089B25kr6);
        parcel.writeSerializable(this.f6090B2KMhB);
        parcel.writeSerializable(this.f6091B3GDIM);
        parcel.writeSerializable(this.f6092B4ZgIw);
        parcel.writeInt(this.f6093B7CMnp);
        parcel.writeString(this.f6094B9tovu);
        parcel.writeInt(this.f6095BChYOn);
        parcel.writeInt(this.f6096BI9f7h);
        parcel.writeInt(this.f6097BIYEnU);
        String str = this.f6099BNL6CD;
        parcel.writeString(str != null ? str.toString() : null);
        CharSequence charSequence = this.f6100BPw6Q8;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        parcel.writeInt(this.f6101BTvldC);
        parcel.writeSerializable(this.f6103BmvVmW);
        parcel.writeSerializable(this.BpkvW3);
        parcel.writeSerializable(this.f6105C2rE4F);
        parcel.writeSerializable(this.f6106C4FrIb);
        parcel.writeSerializable(this.f6107CASmeH);
        parcel.writeSerializable(this.f6108CNPG0E);
        parcel.writeSerializable(this.f6109COJEAR);
        parcel.writeSerializable(this.f6112CTkVKb);
        parcel.writeSerializable(this.f6110CQhlFr);
        parcel.writeSerializable(this.f6111CSDoyG);
        parcel.writeSerializable(this.f6104BniPrB);
        parcel.writeSerializable(this.f6098BJ7GGh);
        parcel.writeSerializable(this.f6113CcAIMM);
        parcel.writeSerializable(this.f6114Cd8JRx);
    }
}
