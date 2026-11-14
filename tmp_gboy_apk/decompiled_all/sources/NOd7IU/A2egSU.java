package NOd7IU;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends NUtxJj.A2egSU {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final A2egSU f5852B25kr6 = new A2egSU(0);
    public static final Parcelable.Creator<A2egSU> CREATOR = new ASJ6gh();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5853AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f5854AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final PendingIntent f5855AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final String f5856AzWtSf;

    static {
        DlFqQ();
    }

    public A2egSU(int i) {
        this(1, i, null, null);
    }

    public static String A2egSU(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    private static /* synthetic */ void DlFqQ() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A4TApA() {
        return (this.f5854AlLFFp == 0 || this.f5855AmA8tU == null) ? false : true;
    }

    public final boolean A5SV6n() {
        return this.f5854AlLFFp == 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof A2egSU)) {
            return false;
        }
        A2egSU a2egSU = (A2egSU) obj;
        return this.f5854AlLFFp == a2egSU.f5854AlLFFp && NUY5pn.AYUAbz.ARc23Z(this.f5855AmA8tU, a2egSU.f5855AmA8tU) && NUY5pn.AYUAbz.ARc23Z(this.f5856AzWtSf, a2egSU.f5856AzWtSf);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5854AlLFFp), this.f5855AmA8tU, this.f5856AzWtSf});
    }

    public final String toString() {
        I3HV03.A4TApA a4TApA = new I3HV03.A4TApA(this);
        a4TApA.AZOQYO("statusCode", A2egSU(this.f5854AlLFFp));
        a4TApA.AZOQYO("resolution", this.f5855AmA8tU);
        a4TApA.AZOQYO("message", this.f5856AzWtSf);
        return a4TApA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5853AcNBzu);
        JrXYwF.A4TApA.AcNBzu(parcel, 2, 4);
        parcel.writeInt(this.f5854AlLFFp);
        JrXYwF.A4TApA.ARc23Z(parcel, 3, this.f5855AmA8tU, i);
        JrXYwF.A4TApA.ASJ6gh(parcel, 4, this.f5856AzWtSf);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }

    public A2egSU(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f5853AcNBzu = i;
        this.f5854AlLFFp = i2;
        this.f5855AmA8tU = pendingIntent;
        this.f5856AzWtSf = str;
    }

    public A2egSU(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent, null);
    }
}
