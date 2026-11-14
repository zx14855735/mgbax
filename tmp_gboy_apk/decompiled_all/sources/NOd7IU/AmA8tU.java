package NOd7IU;

import ADYaiT.BmvVmW;
import Hjvs0g.B3GDIM;
import Hjvs0g.BI9f7h;
import Hjvs0g.BIYEnU;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU implements EmJGcg.A2egSU, BIYEnU, androidx.emoji2.text.AcNBzu {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static AmA8tU f5911AmA8tU;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5912AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Context f5913AlLFFp;

    public /* synthetic */ AmA8tU() {
        this.f5912AcNBzu = 9;
    }

    public static AZOQYO A5SV6n(PackageInfo packageInfo, AZOQYO... azoqyoArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        AZkASS aZkASS = new AZkASS(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < azoqyoArr.length; i++) {
            if (azoqyoArr[i].equals(aZkASS)) {
                return azoqyoArr[i];
            }
        }
        return null;
    }

    public static AmA8tU ADYaiT(Context context) {
        NUY5pn.AYUAbz.A4TApA(context);
        synchronized (AmA8tU.class) {
            try {
                if (f5911AmA8tU == null) {
                    AlLFFp.AZkASS(context);
                    f5911AmA8tU = new AmA8tU(context, 0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f5911AmA8tU;
    }

    public static boolean AMqCpz(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures != null) {
            if ((z ? A5SV6n(packageInfo, AcNBzu.f5874A2egSU) : A5SV6n(packageInfo, AcNBzu.f5874A2egSU[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.emoji2.text.AcNBzu
    public void A2egSU(androidx.emoji2.text.AlLFFp alLFFp) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.A2egSU("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new Dphsd2.AlLFFp(5, this, alLFFp, threadPoolExecutor));
    }

    @Override // EmJGcg.A2egSU
    public void A4TApA(GEYgCP.A2egSU a2egSU) {
        switch (this.f5912AcNBzu) {
            case 1:
                Context context = this.f5913AlLFFp;
                if (context != null) {
                    Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
                    intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
                    EsrwYR.AMqCpz.A2egSU(context, intent, a2egSU, new BmvVmW(18));
                    return;
                }
                return;
            case 2:
                Context context2 = this.f5913AlLFFp;
                if (context2 != null) {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
                    EsrwYR.AMqCpz.A2egSU(context2, intent2, a2egSU, new KCxDWD.A5SV6n(18, this));
                    return;
                }
                return;
            case 3:
                Context context3 = this.f5913AlLFFp;
                if (context3 != null) {
                    Intent intent3 = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent3.setPackage("com.google.android.gms");
                    EsrwYR.AMqCpz.A2egSU(context3, intent3, a2egSU, new BmvVmW(20));
                    return;
                }
                return;
            case 4:
                Context context4 = this.f5913AlLFFp;
                if (context4 == null) {
                    return;
                }
                try {
                    Cursor query = context4.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                    try {
                        Objects.requireNonNull(query);
                        query.moveToFirst();
                        String string = query.getString(query.getColumnIndex("value"));
                        if (string == null || string.length() == 0) {
                            throw new GL2Jh7.A2egSU("OAID query failed");
                        }
                        AlLFFp.f5886AlLFFp = string;
                        query.close();
                        return;
                    } finally {
                    }
                } catch (Exception unused) {
                    return;
                }
            case 5:
                Context context5 = this.f5913AlLFFp;
                if (context5 != null) {
                    if (!mo0a()) {
                        new GL2Jh7.A2egSU("Only supports Android 10.0 and above for Nubia");
                        return;
                    }
                    try {
                        ContentProviderClient acquireContentProviderClient = context5.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
                        if (acquireContentProviderClient == null) {
                            return;
                        }
                        Bundle call = acquireContentProviderClient.call("getOAID", null, null);
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireContentProviderClient.release();
                        } else {
                            acquireContentProviderClient.release();
                        }
                        if (call == null) {
                            throw new GL2Jh7.A2egSU("OAID query failed: bundle is null");
                        }
                        String string2 = call.getInt(PluginConstants.KEY_ERROR_CODE, -1) == 0 ? call.getString(f.f13353a) : null;
                        if (string2 != null && string2.length() != 0) {
                            AlLFFp.f5886AlLFFp = string2;
                            return;
                        } else {
                            throw new GL2Jh7.A2egSU("OAID query failed: " + call.getString("message"));
                        }
                    } catch (Exception unused2) {
                        return;
                    }
                }
                return;
            default:
                Context context6 = this.f5913AlLFFp;
                if (context6 != null) {
                    Intent intent4 = new Intent();
                    intent4.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                    EsrwYR.AMqCpz.A2egSU(context6, intent4, a2egSU, new BmvVmW(24));
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x01bb, code lost:
    
        if (r2.length() > 0) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0232  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void ARc23Z(long r18, java.lang.Thread r20, java.lang.Throwable r21) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: NOd7IU.AmA8tU.ARc23Z(long, java.lang.Thread, java.lang.Throwable):void");
    }

    @Override // Hjvs0g.BIYEnU
    public BI9f7h AYUAbz(Hjvs0g.BmvVmW bmvVmW) {
        return new B3GDIM(this.f5913AlLFFp, 2);
    }

    @Override // EmJGcg.A2egSU
    /* renamed from: a */
    public boolean mo0a() {
        switch (this.f5912AcNBzu) {
            case 1:
                Context context = this.f5913AlLFFp;
                if (context != null) {
                    try {
                        if (context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null) {
                        }
                    } catch (Exception unused) {
                        return false;
                    }
                }
                break;
            case 2:
                Context context2 = this.f5913AlLFFp;
                if (context2 != null) {
                    try {
                        if (context2.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null) {
                        }
                    } catch (Exception unused2) {
                        return false;
                    }
                }
                break;
            case 3:
                Context context3 = this.f5913AlLFFp;
                if (context3 != null) {
                    try {
                        if (context3.getPackageManager().getPackageInfo("com.android.vending", 0) != null) {
                        }
                    } catch (Exception unused3) {
                        return false;
                    }
                }
                break;
            case 4:
                Context context4 = this.f5913AlLFFp;
                if (context4 != null) {
                    try {
                        if (context4.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                        }
                    } catch (Exception unused4) {
                        return false;
                    }
                }
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 29) {
                }
                break;
            default:
                Context context5 = this.f5913AlLFFp;
                if (context5 != null) {
                    try {
                        if (context5.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null) {
                        }
                    } catch (Exception unused5) {
                        return false;
                    }
                }
                break;
        }
        return false;
    }

    public AmA8tU(Context context, int i) {
        this.f5912AcNBzu = i;
        switch (i) {
            case 2:
                if (!(context instanceof Application)) {
                    this.f5913AlLFFp = context.getApplicationContext();
                    break;
                } else {
                    this.f5913AlLFFp = context;
                    break;
                }
            case 10:
                this.f5913AlLFFp = context.getApplicationContext();
                break;
            default:
                this.f5913AlLFFp = context.getApplicationContext();
                break;
        }
    }

    public /* synthetic */ AmA8tU(Context context, int i, boolean z) {
        this.f5912AcNBzu = i;
        this.f5913AlLFFp = context;
    }
}
