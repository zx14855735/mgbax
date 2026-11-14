package NUY5pn;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A2egSU extends Binder implements C4FrIb {
    public static C4FrIb A2egSU(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        if (queryLocalInterface != null && (queryLocalInterface instanceof C4FrIb)) {
            return (C4FrIb) queryLocalInterface;
        }
        C2rE4F c2rE4F = new C2rE4F();
        c2rE4F.f6033A2egSU = iBinder;
        return c2rE4F;
    }
}
