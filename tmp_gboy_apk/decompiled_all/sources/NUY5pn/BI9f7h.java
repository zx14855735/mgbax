package NUY5pn;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BI9f7h extends NUtxJj.A2egSU {
    public static final Parcelable.Creator<BI9f7h> CREATOR = new BIYEnU();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5975AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f5976AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f5977AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public String f5978AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public IBinder f5979B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public NSK3xo.A2egSU[] f5980B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Bundle f5981B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public Account f5982B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final long f5983B7CMnp;

    static {
        UolyIjJ();
    }

    public BI9f7h(int i) {
        this.f5975AcNBzu = 3;
        this.f5977AmA8tU = NOd7IU.AYUAbz.f5868A2egSU;
        this.f5976AlLFFp = i;
    }

    private static /* synthetic */ void UolyIjJ() {
        char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 19);
        }
        String str = new String(charArray);
        char[] charArray2 = "p\u007fz}zg".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 19);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5975AcNBzu);
        JrXYwF.A4TApA.AcNBzu(parcel, 2, 4);
        parcel.writeInt(this.f5976AlLFFp);
        JrXYwF.A4TApA.AcNBzu(parcel, 3, 4);
        parcel.writeInt(this.f5977AmA8tU);
        JrXYwF.A4TApA.ASJ6gh(parcel, 4, this.f5978AzWtSf);
        IBinder iBinder = this.f5979B25kr6;
        if (iBinder != null) {
            int AZkASS3 = JrXYwF.A4TApA.AZkASS(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            JrXYwF.A4TApA.AmA8tU(parcel, AZkASS3);
        }
        NSK3xo.A2egSU[] a2egSUArr = this.f5980B2KMhB;
        if (a2egSUArr != null) {
            int AZkASS4 = JrXYwF.A4TApA.AZkASS(parcel, 6);
            parcel.writeInt(a2egSUArr.length);
            for (NSK3xo.A2egSU a2egSU : a2egSUArr) {
                if (a2egSU == null) {
                    parcel.writeInt(0);
                } else {
                    int dataPosition = parcel.dataPosition();
                    parcel.writeInt(1);
                    int dataPosition2 = parcel.dataPosition();
                    a2egSU.writeToParcel(parcel, i);
                    int dataPosition3 = parcel.dataPosition();
                    parcel.setDataPosition(dataPosition);
                    parcel.writeInt(dataPosition3 - dataPosition2);
                    parcel.setDataPosition(dataPosition3);
                }
            }
            JrXYwF.A4TApA.AmA8tU(parcel, AZkASS4);
        }
        Bundle bundle = this.f5981B3GDIM;
        if (bundle != null) {
            int AZkASS5 = JrXYwF.A4TApA.AZkASS(parcel, 7);
            parcel.writeBundle(bundle);
            JrXYwF.A4TApA.AmA8tU(parcel, AZkASS5);
        }
        JrXYwF.A4TApA.ARc23Z(parcel, 8, this.f5982B4ZgIw, i);
        JrXYwF.A4TApA.AcNBzu(parcel, 9, 8);
        parcel.writeLong(this.f5983B7CMnp);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }

    public BI9f7h(int i, int i2, int i3, String str, IBinder iBinder, NSK3xo.A2egSU[] a2egSUArr, Bundle bundle, Account account, long j) {
        C4FrIb A2egSU2;
        this.f5975AcNBzu = i;
        this.f5976AlLFFp = i2;
        this.f5977AmA8tU = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f5978AzWtSf = "com.google.android.gms";
        } else {
            this.f5978AzWtSf = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null && (A2egSU2 = A2egSU.A2egSU(iBinder)) != null) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    account2 = ((C2rE4F) A2egSU2).A2egSU();
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    throw th;
                }
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
            this.f5982B4ZgIw = account2;
        } else {
            this.f5979B25kr6 = iBinder;
            this.f5982B4ZgIw = account;
        }
        this.f5980B2KMhB = a2egSUArr;
        this.f5981B3GDIM = bundle;
        this.f5983B7CMnp = j;
    }
}
