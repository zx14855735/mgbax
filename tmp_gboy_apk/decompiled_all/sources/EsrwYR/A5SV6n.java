package EsrwYR;

import ADYaiT.BmvVmW;
import NOd7IU.AlLFFp;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements EmJGcg.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2551AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Context f2552AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public String f2553AmA8tU;

    public A5SV6n(Context context, int i) {
        this.f2551AcNBzu = i;
        switch (i) {
            case 1:
                if (!(context instanceof Application)) {
                    this.f2552AlLFFp = context.getApplicationContext();
                    break;
                } else {
                    this.f2552AlLFFp = context;
                    break;
                }
            default:
                this.f2552AlLFFp = context;
                break;
        }
    }

    public static String A5SV6n(IBinder iBinder, String str, String str2) {
        ErKPGd.A5SV6n a5SV6n;
        int i = ErKPGd.A4TApA.f2548A2egSU;
        if (iBinder == null) {
            a5SV6n = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ErKPGd.A5SV6n)) {
                ErKPGd.A2egSU a2egSU = new ErKPGd.A2egSU();
                a2egSU.f2547A2egSU = iBinder;
                a5SV6n = a2egSU;
            } else {
                a5SV6n = (ErKPGd.A5SV6n) queryLocalInterface;
            }
        }
        if (a5SV6n == null) {
            throw new GL2Jh7.A2egSU("IOpenID is null");
        }
        ErKPGd.A2egSU a2egSU2 = (ErKPGd.A2egSU) a5SV6n;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString("OUID");
            a2egSU2.f2547A2egSU.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String A2egSU(IBinder iBinder) {
        Context context = this.f2552AlLFFp;
        String packageName = context.getPackageName();
        String str = this.f2553AmA8tU;
        if (str != null) {
            return A5SV6n(iBinder, packageName, str);
        }
        byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String sb2 = sb.toString();
        this.f2553AmA8tU = sb2;
        return A5SV6n(iBinder, packageName, sb2);
    }

    @Override // EmJGcg.A2egSU
    public final void A4TApA(GEYgCP.A2egSU a2egSU) {
        switch (this.f2551AcNBzu) {
            case 0:
                Context context = this.f2552AlLFFp;
                if (context != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        try {
                            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                            if (!TextUtils.isEmpty(string)) {
                                AlLFFp.f5886AlLFFp = string;
                                break;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (TextUtils.isEmpty(this.f2553AmA8tU) && !mo0a()) {
                        new GL2Jh7.A2egSU("Huawei Advertising ID not available");
                        break;
                    } else {
                        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                        intent.setPackage(this.f2553AmA8tU);
                        AMqCpz.A2egSU(context, intent, a2egSU, new BmvVmW(21));
                        break;
                    }
                }
                break;
            default:
                Context context2 = this.f2552AlLFFp;
                if (context2 != null) {
                    Intent intent2 = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
                    intent2.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                    AMqCpz.A2egSU(context2, intent2, a2egSU, new KCxDWD.A5SV6n(19, this));
                    break;
                }
                break;
        }
    }

    @Override // EmJGcg.A2egSU
    /* renamed from: a */
    public final boolean mo0a() {
        switch (this.f2551AcNBzu) {
            case 0:
                Context context = this.f2552AlLFFp;
                if (context == null) {
                    return false;
                }
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                        this.f2553AmA8tU = "com.huawei.hwid";
                    } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                        this.f2553AmA8tU = "com.huawei.hwid.tv";
                    } else {
                        this.f2553AmA8tU = "com.huawei.hms";
                        if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                            return false;
                        }
                    }
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            default:
                Context context2 = this.f2552AlLFFp;
                if (context2 == null) {
                    return false;
                }
                try {
                    return context2.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
                } catch (Exception unused2) {
                    return false;
                }
        }
    }
}
