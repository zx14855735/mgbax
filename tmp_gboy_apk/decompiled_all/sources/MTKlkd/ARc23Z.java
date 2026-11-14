package MTKlkd;

import AaHO0E.AlLFFp;
import android.os.Parcel;
import android.os.Parcelable;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ARc23Z implements Parcelable {
    public static final Parcelable.Creator<ARc23Z> CREATOR = new AlLFFp(15);

    /* renamed from: AcNBzu, reason: collision with root package name */
    @PlKZ28.A5SV6n(f.f13353a)
    private int f5234AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    @PlKZ28.A5SV6n("name")
    private String f5235AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    @PlKZ28.A5SV6n("imageUrl")
    private String f5236AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    @PlKZ28.A5SV6n("romUrl")
    private String f5237AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    @PlKZ28.A5SV6n("size")
    private String f5238B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    @PlKZ28.A5SV6n(PointParamKey.TYPE)
    private String f5239B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    @PlKZ28.A5SV6n("message")
    private String f5240B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    @PlKZ28.A5SV6n("created_at")
    private String f5241B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    @PlKZ28.A5SV6n("sha256")
    private String f5242B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    @PlKZ28.A5SV6n("imageList")
    private List<String> f5243B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    @PlKZ28.A5SV6n("status")
    private int f5244BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    @PlKZ28.A5SV6n(PointCategory.PROGRESS)
    private int f5245BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    @PlKZ28.A5SV6n("is_favorite")
    private boolean f5246BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    @PlKZ28.A5SV6n("disclaimer")
    private String f5247BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public String f5248BNL6CD;

    static {
        TIrf();
    }

    public ARc23Z() {
        this.f5245BI9f7h = 0;
        this.f5244BChYOn = -1;
    }

    private static /* synthetic */ void TIrf() {
        char[] charArray = "oca\"kmai\"ncu\"\u007fdi``\"FbeN~ehki".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\f');
        }
        String str = new String(charArray);
        char[] charArray2 = "o`ebex".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String A2egSU() {
        return this.f5247BJ7GGh;
    }

    public final int A4TApA() {
        return this.f5234AcNBzu;
    }

    public final List A5SV6n() {
        return this.f5243B9tovu;
    }

    public final String ADYaiT() {
        return this.f5236AmA8tU;
    }

    public final String AMqCpz() {
        return this.f5240B3GDIM;
    }

    public final String ARc23Z() {
        return this.f5235AlLFFp;
    }

    public final int ASJ6gh() {
        return this.f5245BI9f7h;
    }

    public final String AYUAbz() {
        return this.f5237AzWtSf;
    }

    public final String AZOQYO() {
        return this.f5242B7CMnp;
    }

    public final String AZkASS() {
        return this.f5238B25kr6;
    }

    public final int AaHO0E() {
        return this.f5244BChYOn;
    }

    public final boolean AcNBzu() {
        return this.f5246BIYEnU;
    }

    public final void AlLFFp(boolean z) {
        this.f5246BIYEnU = z;
    }

    public final void AmA8tU(String str) {
        this.f5236AmA8tU = str;
    }

    public final void AzWtSf(String str) {
        this.f5235AlLFFp = str;
    }

    public final void B25kr6(int i) {
        this.f5245BI9f7h = i;
    }

    public final void B2KMhB(String str) {
        this.f5238B25kr6 = str;
    }

    public final void B3GDIM(int i) {
        this.f5244BChYOn = i;
    }

    public final void B4ZgIw() {
        this.f5239B2KMhB = "";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getType() {
        return this.f5239B2KMhB;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5234AcNBzu);
        parcel.writeString(this.f5235AlLFFp);
        parcel.writeString(this.f5236AmA8tU);
        parcel.writeString(this.f5237AzWtSf);
        parcel.writeString(this.f5248BNL6CD);
        parcel.writeString(this.f5238B25kr6);
        parcel.writeString(this.f5239B2KMhB);
        parcel.writeString(this.f5240B3GDIM);
        parcel.writeString(this.f5241B4ZgIw);
        parcel.writeString(this.f5242B7CMnp);
        parcel.writeStringList(this.f5243B9tovu);
        parcel.writeInt(this.f5244BChYOn);
        parcel.writeInt(this.f5245BI9f7h);
        parcel.writeByte(this.f5246BIYEnU ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f5247BJ7GGh);
    }

    public ARc23Z(Parcel parcel) {
        this.f5234AcNBzu = parcel.readInt();
        this.f5235AlLFFp = parcel.readString();
        this.f5236AmA8tU = parcel.readString();
        this.f5237AzWtSf = parcel.readString();
        this.f5248BNL6CD = parcel.readString();
        this.f5238B25kr6 = parcel.readString();
        this.f5239B2KMhB = parcel.readString();
        this.f5240B3GDIM = parcel.readString();
        this.f5241B4ZgIw = parcel.readString();
        this.f5242B7CMnp = parcel.readString();
        this.f5243B9tovu = parcel.createStringArrayList();
        this.f5244BChYOn = parcel.readInt();
        this.f5245BI9f7h = parcel.readInt();
        this.f5246BIYEnU = parcel.readByte() != 0;
        this.f5247BJ7GGh = parcel.readString();
    }
}
