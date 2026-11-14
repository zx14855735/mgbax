package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DG07BK implements Parcelable {
    public static final Parcelable.Creator<DG07BK> CREATOR = new AaHO0E.AlLFFp(29);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final String f8886AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final String f8887AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final boolean f8888AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f8889AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f8890B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final String f8891B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final boolean f8892B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final boolean f8893B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final boolean f8894B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final boolean f8895B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final int f8896BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final String f8897BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final int f8898BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final boolean f8899BJ7GGh;

    static {
        MFKIV();
    }

    public DG07BK(Fragment fragment) {
        this.f8886AcNBzu = fragment.getClass().getName();
        this.f8887AlLFFp = fragment.mWho;
        this.f8888AmA8tU = fragment.mFromLayout;
        this.f8889AzWtSf = fragment.mFragmentId;
        this.f8890B25kr6 = fragment.mContainerId;
        this.f8891B2KMhB = fragment.mTag;
        this.f8892B3GDIM = fragment.mRetainInstance;
        this.f8893B4ZgIw = fragment.mRemoving;
        this.f8894B7CMnp = fragment.mDetached;
        this.f8895B9tovu = fragment.mHidden;
        this.f8896BChYOn = fragment.mMaxState.ordinal();
        this.f8897BI9f7h = fragment.mTargetWho;
        this.f8898BIYEnU = fragment.mTargetRequestCode;
        this.f8899BJ7GGh = fragment.mUserVisibleHint;
    }

    private static /* synthetic */ void MFKIV() {
        char[] charArray = "\u0016\u001a\u0018[\u0012\u0014\u0018\u0010[\u0017\u001a\f[\u0006\u001d\u0010\u0019\u0019[?\u001b\u001c7\u0007\u001c\u0011\u0012\u0010".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'u');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0016\u0019\u001c\u001b\u001c\u0001".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'u');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("FragmentState{");
        sb.append(this.f8886AcNBzu);
        sb.append(" (");
        sb.append(this.f8887AlLFFp);
        sb.append(")}:");
        if (this.f8888AmA8tU) {
            sb.append(" fromLayout");
        }
        int i = this.f8890B25kr6;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.f8891B2KMhB;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f8892B3GDIM) {
            sb.append(" retainInstance");
        }
        if (this.f8893B4ZgIw) {
            sb.append(" removing");
        }
        if (this.f8894B7CMnp) {
            sb.append(" detached");
        }
        if (this.f8895B9tovu) {
            sb.append(" hidden");
        }
        String str2 = this.f8897BI9f7h;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.f8898BIYEnU);
        }
        if (this.f8899BJ7GGh) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8886AcNBzu);
        parcel.writeString(this.f8887AlLFFp);
        parcel.writeInt(this.f8888AmA8tU ? 1 : 0);
        parcel.writeInt(this.f8889AzWtSf);
        parcel.writeInt(this.f8890B25kr6);
        parcel.writeString(this.f8891B2KMhB);
        parcel.writeInt(this.f8892B3GDIM ? 1 : 0);
        parcel.writeInt(this.f8893B4ZgIw ? 1 : 0);
        parcel.writeInt(this.f8894B7CMnp ? 1 : 0);
        parcel.writeInt(this.f8895B9tovu ? 1 : 0);
        parcel.writeInt(this.f8896BChYOn);
        parcel.writeString(this.f8897BI9f7h);
        parcel.writeInt(this.f8898BIYEnU);
        parcel.writeInt(this.f8899BJ7GGh ? 1 : 0);
    }

    public DG07BK(Parcel parcel) {
        this.f8886AcNBzu = parcel.readString();
        this.f8887AlLFFp = parcel.readString();
        this.f8888AmA8tU = parcel.readInt() != 0;
        this.f8889AzWtSf = parcel.readInt();
        this.f8890B25kr6 = parcel.readInt();
        this.f8891B2KMhB = parcel.readString();
        this.f8892B3GDIM = parcel.readInt() != 0;
        this.f8893B4ZgIw = parcel.readInt() != 0;
        this.f8894B7CMnp = parcel.readInt() != 0;
        this.f8895B9tovu = parcel.readInt() != 0;
        this.f8896BChYOn = parcel.readInt();
        this.f8897BI9f7h = parcel.readString();
        this.f8898BIYEnU = parcel.readInt();
        this.f8899BJ7GGh = parcel.readInt() != 0;
    }
}
