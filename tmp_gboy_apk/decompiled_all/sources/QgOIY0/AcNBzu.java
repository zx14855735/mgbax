package QgOIY0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AcNBzu implements Parcelable {
    public static final Parcelable.Creator<AcNBzu> CREATOR = new AaHO0E.AlLFFp(20);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int[] f7522AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f7523AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f7524AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final String f7525AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f7526B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int f7527B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final CharSequence f7528B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f7529B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final CharSequence f7530B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final ArrayList f7531B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final ArrayList f7532BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final boolean f7533BI9f7h;

    static {
        PptM();
    }

    public AcNBzu(AaHO0E aaHO0E) {
        int size = aaHO0E.f7505A4TApA.size();
        this.f7522AcNBzu = new int[size * 6];
        if (!aaHO0E.f7511AZOQYO) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            AZkASS aZkASS = (AZkASS) aaHO0E.f7505A4TApA.get(i2);
            int[] iArr = this.f7522AcNBzu;
            int i3 = i + 1;
            iArr[i] = aZkASS.f7499A2egSU;
            int i4 = i + 2;
            B2KMhB b2KMhB = aZkASS.f7500A4TApA;
            iArr[i3] = b2KMhB != null ? b2KMhB.f7574CASmeH : -1;
            iArr[i4] = aZkASS.f7501A5SV6n;
            iArr[i + 3] = aZkASS.f7502ADYaiT;
            int i5 = i + 5;
            iArr[i + 4] = aZkASS.AMqCpz;
            i += 6;
            iArr[i5] = aZkASS.f7503ARc23Z;
        }
        this.f7523AlLFFp = aaHO0E.f7509ASJ6gh;
        this.f7524AmA8tU = aaHO0E.f7510AYUAbz;
        this.f7525AzWtSf = aaHO0E.f7512AZkASS;
        this.f7526B25kr6 = aaHO0E.f7514AcNBzu;
        this.f7527B2KMhB = aaHO0E.f7515AlLFFp;
        this.f7528B3GDIM = aaHO0E.f7516AmA8tU;
        this.f7529B4ZgIw = aaHO0E.f7517AzWtSf;
        this.f7530B7CMnp = aaHO0E.f7518B25kr6;
        this.f7531B9tovu = aaHO0E.f7519B2KMhB;
        this.f7532BChYOn = aaHO0E.f7520B3GDIM;
        this.f7533BI9f7h = aaHO0E.f7521B4ZgIw;
    }

    private static /* synthetic */ void PptM() {
        char[] charArray = ">20s:<08s?2$s.5811s\u001734\u001f/49:8".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ']');
        }
        String str = new String(charArray);
        char[] charArray2 = ">1434)".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ']');
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
        parcel.writeIntArray(this.f7522AcNBzu);
        parcel.writeInt(this.f7523AlLFFp);
        parcel.writeInt(this.f7524AmA8tU);
        parcel.writeString(this.f7525AzWtSf);
        parcel.writeInt(this.f7526B25kr6);
        parcel.writeInt(this.f7527B2KMhB);
        TextUtils.writeToParcel(this.f7528B3GDIM, parcel, 0);
        parcel.writeInt(this.f7529B4ZgIw);
        TextUtils.writeToParcel(this.f7530B7CMnp, parcel, 0);
        parcel.writeStringList(this.f7531B9tovu);
        parcel.writeStringList(this.f7532BChYOn);
        parcel.writeInt(this.f7533BI9f7h ? 1 : 0);
    }

    public AcNBzu(Parcel parcel) {
        this.f7522AcNBzu = parcel.createIntArray();
        this.f7523AlLFFp = parcel.readInt();
        this.f7524AmA8tU = parcel.readInt();
        this.f7525AzWtSf = parcel.readString();
        this.f7526B25kr6 = parcel.readInt();
        this.f7527B2KMhB = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f7528B3GDIM = (CharSequence) creator.createFromParcel(parcel);
        this.f7529B4ZgIw = parcel.readInt();
        this.f7530B7CMnp = (CharSequence) creator.createFromParcel(parcel);
        this.f7531B9tovu = parcel.createStringArrayList();
        this.f7532BChYOn = parcel.createStringArrayList();
        this.f7533BI9f7h = parcel.readInt() != 0;
    }
}
