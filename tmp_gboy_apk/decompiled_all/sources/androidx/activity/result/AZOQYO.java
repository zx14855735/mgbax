package androidx.activity.result;

import AaHO0E.AlLFFp;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements Parcelable {
    public static final Parcelable.Creator<AZOQYO> CREATOR = new AlLFFp(24);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final IntentSender f8006AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Intent f8007AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f8008AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f8009AzWtSf;

    static {
        GLBSoxg();
    }

    public AZOQYO(IntentSender intentSender, Intent intent, int i, int i2) {
        this.f8006AcNBzu = intentSender;
        this.f8007AlLFFp = intent;
        this.f8008AmA8tU = i;
        this.f8009AzWtSf = i2;
    }

    private static /* synthetic */ void GLBSoxg() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 160);
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
        RXb0Sz.ARc23Z.AMqCpz(parcel, "dest");
        parcel.writeParcelable(this.f8006AcNBzu, i);
        parcel.writeParcelable(this.f8007AlLFFp, i);
        parcel.writeInt(this.f8008AmA8tU);
        parcel.writeInt(this.f8009AzWtSf);
    }
}
