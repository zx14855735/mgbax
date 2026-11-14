package androidx.activity.result;

import AaHO0E.AlLFFp;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements Parcelable {
    public static final Parcelable.Creator<A2egSU> CREATOR = new AlLFFp(23);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f7990AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Intent f7991AlLFFp;

    static {
        TiRHG();
    }

    public A2egSU(int i, Intent intent) {
        this.f7990AcNBzu = i;
        this.f7991AlLFFp = intent;
    }

    private static /* synthetic */ void TiRHG() {
        char[] charArray = "éåç¤íëçï¤èåó¤ùâïææ¤ÀäãÈøãîíï".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 138);
        }
        String str = new String(charArray);
        char[] charArray2 = "éæãäãþ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 138);
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
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i = this.f7990AcNBzu;
        sb.append(i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK");
        sb.append(", data=");
        sb.append(this.f7991AlLFFp);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7990AcNBzu);
        Intent intent = this.f7991AlLFFp;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    public A2egSU(Parcel parcel) {
        this.f7990AcNBzu = parcel.readInt();
        this.f7991AlLFFp = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
