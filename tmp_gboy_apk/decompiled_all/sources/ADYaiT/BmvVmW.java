package ADYaiT;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BmvVmW implements A4TApA, AZkASS.BJ7GGh, androidx.lifecycle.CqNSpT, DUi7mC.AMqCpz, HFjH17.A5SV6n, EsrwYR.ADYaiT, Ixu71n.A2egSU {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static BmvVmW f112AlLFFp = null;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static BmvVmW f113AmA8tU = null;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static boolean f114AzWtSf = true;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static Method f115B25kr6 = null;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static boolean f116B2KMhB = false;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static Field f117B3GDIM = null;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static boolean f118B4ZgIw = false;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static boolean f119B7CMnp = true;

    /* renamed from: B9tovu, reason: collision with root package name */
    public static boolean f120B9tovu = true;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f121AcNBzu;

    public /* synthetic */ BmvVmW(int i) {
        this.f121AcNBzu = i;
    }

    private final void ASJ6gh(int i, Serializable serializable) {
    }

    @Override // AZkASS.BJ7GGh
    public void A2egSU(AZkASS.AmA8tU amA8tU, boolean z) {
    }

    @Override // androidx.lifecycle.CqNSpT
    public androidx.lifecycle.CikNvS A4TApA(Class cls) {
        return new DAk1zC.A4TApA();
    }

    @Override // DUi7mC.AMqCpz
    public void A5SV6n(int i, Serializable serializable) {
        switch (this.f121AcNBzu) {
            case 11:
                break;
            default:
                if (i == 6 || i == 7 || i == 8) {
                    break;
                }
                break;
        }
    }

    public float ADYaiT(View view) {
        if (f114AzWtSf) {
            try {
                return DaOi9o.C2rE4F.A2egSU(view);
            } catch (NoSuchMethodError unused) {
                f114AzWtSf = false;
            }
        }
        return view.getAlpha();
    }

    @Override // AZkASS.BJ7GGh
    public boolean AMqCpz(AZkASS.AmA8tU amA8tU) {
        return false;
    }

    @Override // Ixu71n.A2egSU
    public Object ARc23Z() {
        return new HXc4pW.BPw6Q8();
    }

    public CharSequence AYUAbz(Preference preference) {
        switch (this.f121AcNBzu) {
            case 9:
                EditTextPreference editTextPreference = (EditTextPreference) preference;
                return TextUtils.isEmpty(editTextPreference.f9069DRlcZ9) ? editTextPreference.getContext().getString(2131886653) : editTextPreference.f9069DRlcZ9;
            default:
                ListPreference listPreference = (ListPreference) preference;
                return TextUtils.isEmpty(listPreference.BniPrB()) ? listPreference.getContext().getString(2131886653) : listPreference.BniPrB();
        }
    }

    public void AZOQYO(View view, int i, int i2, int i3, int i4) {
        if (!f116B2KMhB) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                f115B25kr6 = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f116B2KMhB = true;
        }
        Method method = f115B25kr6;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused2) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void AZkASS(K1Z3yj.A2egSU a2egSU, float f) {
        AzWtSf.A2egSU a2egSU2 = (AzWtSf.A2egSU) ((Drawable) a2egSU.f4174AlLFFp);
        CardView cardView = (CardView) a2egSU.f4175AmA8tU;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f != a2egSU2.AMqCpz || a2egSU2.f961ARc23Z != useCompatPadding || a2egSU2.f962ASJ6gh != preventCornerOverlap) {
            a2egSU2.AMqCpz = f;
            a2egSU2.f961ARc23Z = useCompatPadding;
            a2egSU2.f962ASJ6gh = preventCornerOverlap;
            a2egSU2.A4TApA(null);
            a2egSU2.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            a2egSU.B7CMnp(0, 0, 0, 0);
            return;
        }
        AzWtSf.A2egSU a2egSU3 = (AzWtSf.A2egSU) ((Drawable) a2egSU.f4174AlLFFp);
        float f2 = a2egSU3.AMqCpz;
        float f3 = a2egSU3.f957A2egSU;
        int ceil = (int) Math.ceil(AzWtSf.A4TApA.A2egSU(f2, f3, cardView.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(AzWtSf.A4TApA.A4TApA(f2, f3, cardView.getPreventCornerOverlap()));
        a2egSU.B7CMnp(ceil, ceil2, ceil, ceil2);
    }

    public void AaHO0E(View view, float f) {
        if (f114AzWtSf) {
            try {
                DaOi9o.C2rE4F.A4TApA(view, f);
                return;
            } catch (NoSuchMethodError unused) {
                f114AzWtSf = false;
            }
        }
        view.setAlpha(f);
    }

    public void AcNBzu(View view, int i) {
        if (!f118B4ZgIw) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f117B3GDIM = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f118B4ZgIw = true;
        }
        Field field = f117B3GDIM;
        if (field != null) {
            try {
                f117B3GDIM.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void AlLFFp(View view, Matrix matrix) {
        if (f119B7CMnp) {
            try {
                DaOi9o.C4FrIb.A4TApA(view, matrix);
            } catch (NoSuchMethodError unused) {
                f119B7CMnp = false;
            }
        }
    }

    public void AmA8tU(View view, Matrix matrix) {
        if (f120B9tovu) {
            try {
                DaOi9o.C4FrIb.A5SV6n(view, matrix);
            } catch (NoSuchMethodError unused) {
                f120B9tovu = false;
            }
        }
    }

    @Override // androidx.lifecycle.CqNSpT
    public androidx.lifecycle.CikNvS AzWtSf(Class cls, D9tr6l.ADYaiT aDYaiT) {
        return A4TApA(cls);
    }

    @Override // EsrwYR.ADYaiT
    public String a(IBinder iBinder) {
        IInterface iInterface = null;
        IInterface iInterface2 = null;
        IInterface iInterface3 = null;
        IInterface iInterface4 = null;
        IInterface iInterface5 = null;
        IInterface iInterface6 = null;
        IInterface iInterface7 = null;
        switch (this.f121AcNBzu) {
            case 18:
                int i = EPdU4G.A4TApA.f2489A2egSU;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof EPdU4G.A5SV6n)) {
                        EPdU4G.A2egSU a2egSU = new EPdU4G.A2egSU();
                        a2egSU.f2488A2egSU = iBinder;
                        iInterface = a2egSU;
                    } else {
                        iInterface = (EPdU4G.A5SV6n) queryLocalInterface;
                    }
                }
                if (iInterface == null) {
                    throw new GL2Jh7.A2egSU("IDidAidlInterface is null");
                }
                IBinder iBinder2 = ((EPdU4G.A2egSU) iInterface).f2488A2egSU;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    iBinder2.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (!(obtain2.readInt() != 0)) {
                        throw new GL2Jh7.A2egSU("IDidAidlInterface#isSupport return false");
                    }
                    Parcel obtain3 = Parcel.obtain();
                    Parcel obtain4 = Parcel.obtain();
                    try {
                        obtain3.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        iBinder2.transact(3, obtain3, obtain4, 0);
                        obtain4.readException();
                        return obtain4.readString();
                    } finally {
                    }
                } finally {
                }
            case 19:
                int i2 = EH1KK8.A4TApA.f2487A2egSU;
                if (iBinder != null) {
                    IInterface queryLocalInterface2 = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                    if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof EH1KK8.A5SV6n)) {
                        EH1KK8.A2egSU a2egSU2 = new EH1KK8.A2egSU();
                        a2egSU2.f2486A2egSU = iBinder;
                        iInterface7 = a2egSU2;
                    } else {
                        iInterface7 = (EH1KK8.A5SV6n) queryLocalInterface2;
                    }
                }
                if (iInterface7 == null) {
                    throw new GL2Jh7.A2egSU("IdsSupplier is null");
                }
                EH1KK8.A2egSU a2egSU3 = (EH1KK8.A2egSU) iInterface7;
                Parcel obtain5 = Parcel.obtain();
                Parcel obtain6 = Parcel.obtain();
                try {
                    obtain5.writeInterfaceToken("com.android.creator.IdsSupplier");
                    a2egSU3.f2486A2egSU.transact(3, obtain5, obtain6, 0);
                    obtain6.readException();
                    return obtain6.readString();
                } finally {
                }
            case 20:
                int i3 = EicXu4.A4TApA.f2546A2egSU;
                if (iBinder != null) {
                    IInterface queryLocalInterface3 = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (queryLocalInterface3 == null || !(queryLocalInterface3 instanceof EicXu4.A5SV6n)) {
                        EicXu4.A2egSU a2egSU4 = new EicXu4.A2egSU();
                        a2egSU4.f2545A2egSU = iBinder;
                        iInterface6 = a2egSU4;
                    } else {
                        iInterface6 = (EicXu4.A5SV6n) queryLocalInterface3;
                    }
                }
                EicXu4.A2egSU a2egSU5 = (EicXu4.A2egSU) iInterface6;
                a2egSU5.getClass();
                Parcel obtain7 = Parcel.obtain();
                Parcel obtain8 = Parcel.obtain();
                try {
                    obtain7.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain7.writeInt(1);
                    a2egSU5.f2545A2egSU.transact(2, obtain7, obtain8, 0);
                    obtain8.readException();
                    obtain8.readInt();
                    obtain8.recycle();
                    obtain7.recycle();
                    EicXu4.A2egSU a2egSU6 = (EicXu4.A2egSU) iInterface6;
                    Parcel obtain9 = Parcel.obtain();
                    Parcel obtain10 = Parcel.obtain();
                    try {
                        obtain9.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        a2egSU6.f2545A2egSU.transact(1, obtain9, obtain10, 0);
                        obtain10.readException();
                        return obtain10.readString();
                    } finally {
                    }
                } finally {
                }
            case 21:
                int i4 = F508T2.A4TApA.f2571A2egSU;
                if (iBinder != null) {
                    IInterface queryLocalInterface4 = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (queryLocalInterface4 == null || !(queryLocalInterface4 instanceof F508T2.A5SV6n)) {
                        F508T2.A2egSU a2egSU7 = new F508T2.A2egSU();
                        a2egSU7.f2570A2egSU = iBinder;
                        iInterface5 = a2egSU7;
                    } else {
                        iInterface5 = (F508T2.A5SV6n) queryLocalInterface4;
                    }
                }
                F508T2.A2egSU a2egSU8 = (F508T2.A2egSU) iInterface5;
                a2egSU8.getClass();
                Parcel obtain11 = Parcel.obtain();
                Parcel obtain12 = Parcel.obtain();
                try {
                    obtain11.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    a2egSU8.f2570A2egSU.transact(2, obtain11, obtain12, 0);
                    obtain12.readException();
                    if (obtain12.readInt() != 0) {
                        throw new GL2Jh7.A2egSU("User has disabled advertising identifier");
                    }
                    F508T2.A2egSU a2egSU9 = (F508T2.A2egSU) iInterface5;
                    Parcel obtain13 = Parcel.obtain();
                    Parcel obtain14 = Parcel.obtain();
                    try {
                        obtain13.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                        a2egSU9.f2570A2egSU.transact(1, obtain13, obtain14, 0);
                        obtain14.readException();
                        return obtain14.readString();
                    } finally {
                    }
                } finally {
                }
            case 22:
                int i5 = Ff5QvW.A4TApA.f2872A2egSU;
                if (iBinder != null) {
                    IInterface queryLocalInterface5 = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
                    if (queryLocalInterface5 == null || !(queryLocalInterface5 instanceof Ff5QvW.A5SV6n)) {
                        Ff5QvW.A2egSU a2egSU10 = new Ff5QvW.A2egSU();
                        a2egSU10.f2871A2egSU = iBinder;
                        iInterface4 = a2egSU10;
                    } else {
                        iInterface4 = (Ff5QvW.A5SV6n) queryLocalInterface5;
                    }
                }
                if (iInterface4 == null) {
                    throw new GL2Jh7.A2egSU("IDeviceidInterface is null");
                }
                IBinder iBinder3 = ((Ff5QvW.A2egSU) iInterface4).f2871A2egSU;
                Parcel obtain15 = Parcel.obtain();
                Parcel obtain16 = Parcel.obtain();
                try {
                    obtain15.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    iBinder3.transact(3, obtain15, obtain16, 0);
                    obtain16.readException();
                    if (!(obtain16.readInt() != 0)) {
                        throw new GL2Jh7.A2egSU("IDeviceidInterface#isSupport return false");
                    }
                    Parcel obtain17 = Parcel.obtain();
                    Parcel obtain18 = Parcel.obtain();
                    try {
                        obtain17.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        iBinder3.transact(1, obtain17, obtain18, 0);
                        obtain18.readException();
                        return obtain18.readString();
                    } finally {
                    }
                } finally {
                }
            case 23:
                int i6 = EUIRHA.A4TApA.f2495A2egSU;
                if (iBinder != null) {
                    IInterface queryLocalInterface6 = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                    if (queryLocalInterface6 == null || !(queryLocalInterface6 instanceof EUIRHA.A5SV6n)) {
                        EUIRHA.A2egSU a2egSU11 = new EUIRHA.A2egSU();
                        a2egSU11.f2494A2egSU = iBinder;
                        iInterface3 = a2egSU11;
                    } else {
                        iInterface3 = (EUIRHA.A5SV6n) queryLocalInterface6;
                    }
                }
                if (iInterface3 == null) {
                    throw new GL2Jh7.A2egSU("MsaIdInterface is null");
                }
                IBinder iBinder4 = ((EUIRHA.A2egSU) iInterface3).f2494A2egSU;
                Parcel obtain19 = Parcel.obtain();
                Parcel obtain20 = Parcel.obtain();
                try {
                    obtain19.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    iBinder4.transact(1, obtain19, obtain20, 0);
                    obtain20.readException();
                    if (!(obtain20.readInt() != 0)) {
                        throw new GL2Jh7.A2egSU("MsaIdInterface#isSupported return false");
                    }
                    Parcel obtain21 = Parcel.obtain();
                    Parcel obtain22 = Parcel.obtain();
                    try {
                        obtain21.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        iBinder4.transact(3, obtain21, obtain22, 0);
                        obtain22.readException();
                        return obtain22.readString();
                    } finally {
                    }
                } finally {
                }
            default:
                int i7 = EwN40Z.A4TApA.f2558A2egSU;
                if (iBinder != null) {
                    IInterface queryLocalInterface7 = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (queryLocalInterface7 == null || !(queryLocalInterface7 instanceof EwN40Z.A5SV6n)) {
                        EwN40Z.A2egSU a2egSU12 = new EwN40Z.A2egSU();
                        a2egSU12.f2557A2egSU = iBinder;
                        iInterface2 = a2egSU12;
                    } else {
                        iInterface2 = (EwN40Z.A5SV6n) queryLocalInterface7;
                    }
                }
                if (iInterface2 == null) {
                    throw new GL2Jh7.A2egSU("IDeviceIdService is null");
                }
                EwN40Z.A2egSU a2egSU13 = (EwN40Z.A2egSU) iInterface2;
                Parcel obtain23 = Parcel.obtain();
                Parcel obtain24 = Parcel.obtain();
                try {
                    obtain23.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    a2egSU13.f2557A2egSU.transact(1, obtain23, obtain24, 0);
                    obtain24.readException();
                    return obtain24.readString();
                } finally {
                }
        }
    }

    @Override // HFjH17.A5SV6n
    public void a(boolean z) {
        switch (this.f121AcNBzu) {
            case 15:
                FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                if (a4TApA != null) {
                    if (z) {
                        a4TApA.CqNSpT(a4TApA.f3187AYUAbz);
                        break;
                    } else {
                        a4TApA.CSDoyG(a4TApA.f3187AYUAbz);
                        break;
                    }
                }
                break;
            default:
                FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                if (a4TApA2 != null) {
                    if (z) {
                        a4TApA2.CqNSpT(a4TApA2.f3187AYUAbz);
                        break;
                    } else {
                        a4TApA2.CSDoyG(a4TApA2.f3187AYUAbz);
                        break;
                    }
                }
                break;
        }
    }
}
