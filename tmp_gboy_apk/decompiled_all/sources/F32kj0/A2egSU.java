package F32kj0;

import DuwtYk.AMqCpz;
import EY4UKY.ADYaiT;
import GJee0v.AZOQYO;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.czhj.sdk.common.Constants;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final GYpKKt.A2egSU f2564A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public HashMap f2565A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f2566A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f2567ADYaiT;

    public A2egSU(GYpKKt.A2egSU a2egSU) {
        this.f2564A2egSU = a2egSU;
    }

    public abstract Object A2egSU(String str);

    public final HashMap A4TApA(AMqCpz aMqCpz) {
        String str;
        String str2;
        String str3;
        String str4;
        HashMap hashMap = new HashMap();
        Context context = EY4UKY.A2egSU.A5SV6n().f2499A2egSU;
        if (context == null) {
            context = null;
        }
        if (context != null) {
            try {
                str = Build.MANUFACTURER;
            } catch (Exception unused) {
                str = "";
            }
            hashMap.put("make", str);
            try {
                str2 = Build.MODEL;
            } catch (Exception e) {
                e.printStackTrace();
                str2 = "";
            }
            hashMap.put(bn.i, str2);
            try {
                str3 = Build.BRAND;
            } catch (Exception unused2) {
                str3 = "";
            }
            hashMap.put(bn.j, str3);
            hashMap.put("os", "Android");
            try {
                str4 = Build.VERSION.RELEASE;
            } catch (Exception unused3) {
                str4 = "";
            }
            hashMap.put("osv", str4);
            hashMap.put("resolution", DeviceUtil.AmA8tU(context));
            hashMap.put("ver", DeviceUtil.ARc23Z(context));
            hashMap.put("sdkver", DeviceUtil.AYUAbz());
            hashMap.put("gid", DeviceUtil.ASJ6gh(context));
            hashMap.put("platform", 2);
            hashMap.put("ua", ADYaiT.B4ZgIw(context));
            hashMap.put("startuptime", ADYaiT.f2513AzWtSf);
            hashMap.put("boottime", ADYaiT.f2514B25kr6);
            hashMap.put("bootmark", EY4UKY.A2egSU.f2497A5SV6n);
            hashMap.put("updatemark", EY4UKY.A2egSU.f2498ADYaiT);
            hashMap.put("devicetype", ADYaiT.A2egSU(context));
            hashMap.put("dpi", ADYaiT.f2523BJ7GGh);
            hashMap.put("ppi", ADYaiT.f2525BPw6Q8);
            hashMap.put("density", ADYaiT.f2524BNL6CD);
            hashMap.put("orientation", ADYaiT.f2526BTvldC);
            hashMap.put("osupdatetime", ADYaiT.f2527BV3sI0);
            hashMap.put("itime", "" + System.currentTimeMillis());
            hashMap.put("ltime", ADYaiT.f2516B3GDIM);
            hashMap.put("lgid", DeviceUtil.getLgid());
            hashMap.put("isnew", Integer.valueOf(DeviceUtil.B25kr6(context)));
            hashMap.put("onetime", DeviceUtil.AlLFFp(context));
            hashMap.put("cookieid", DeviceUtil.AZOQYO(context));
            String str5 = Constants.FAIL;
            hashMap.put("sysid", Constants.FAIL);
            hashMap.put("cgid", Constants.FAIL);
            hashMap.put("installTime", ADYaiT.f2517B4ZgIw);
            hashMap.put(MediaFormat.KEY_LANGUAGE, ADYaiT.f2518B7CMnp);
            hashMap.put("disk", ADYaiT.f2519B9tovu);
            hashMap.put("memory", ADYaiT.f2520BChYOn);
            hashMap.put("timezone", ADYaiT.f2521BI9f7h);
            hashMap.put("apppackage", DeviceUtil.A2egSU(context));
            hashMap.put("appstoreversion", DeviceUtil.AMqCpz(context));
            hashMap.put("devicename", DeviceUtil.AZkASS(context));
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                if (packageInfo != null) {
                    hashMap.put("hmsversion", packageInfo.versionName);
                }
            } catch (PackageManager.NameNotFoundException unused4) {
                hashMap.put("hmsversion", "");
            }
            hashMap.put("secondsfromgmt", com.bumptech.glide.A5SV6n.A4TApA());
            hashMap.put("hwmodel", Build.HARDWARE);
            hashMap.put("fulllanguage", com.bumptech.glide.A5SV6n.AmA8tU(context));
            hashMap.put("countrycode", com.bumptech.glide.A5SV6n.ADYaiT(context));
            hashMap.put("birthtime", ADYaiT.f2528BmvVmW);
            hashMap.put("hmsCoreVer", DeviceUtil.AcNBzu(context));
            hashMap.put("hmsAGVerCode", DeviceUtil.AaHO0E(context));
            String str6 = DeviceUtil.f9708A2egSU;
            HashMap hashMap2 = this.f2565A4TApA;
            hashMap2.put("appid", str6);
            hashMap2.put("appList", GGG1xW.A2egSU.f2987AZOQYO.A2egSU());
            String str7 = aMqCpz.f2482ARc23Z;
            hashMap.put("userId", (str7 == null || str7.isEmpty()) ? ADYaiT.f2532CASmeH : aMqCpz.f2482ARc23Z);
            String str8 = AlLFFp.f5890B2KMhB;
            int i = AZOQYO.f3039AcNBzu;
            hashMap.put("ip", str8);
            hashMap.put("ipv6", AlLFFp.f5891B3GDIM);
            hashMap.put("carrier", AlLFFp.B25kr6());
            hashMap.put("androidid", AlLFFp.ARc23Z());
            hashMap.put("imei", AlLFFp.B3GDIM());
            hashMap.put("mac", AlLFFp.f5889B25kr6);
            hashMap.put("oaid", AlLFFp.CASmeH());
            if (!AlLFFp.f5901BTvldC) {
                str5 = "1";
            }
            hashMap.put("enablePersonalized", str5);
            hashMap.put("connectiontype", Integer.valueOf(AlLFFp.f5892B4ZgIw));
            double[] C2rE4F2 = AlLFFp.C2rE4F();
            if (C2rE4F2 != null && C2rE4F2.length >= 2) {
                hashMap.put("geo", C2rE4F2[0] + "," + C2rE4F2[1]);
            }
        }
        return hashMap;
    }

    public final void A5SV6n() {
        EY4UKY.A5SV6n.f2501A2egSU.submit(new GcSJYy.AMqCpz(this).f3071A2egSU);
    }

    public abstract void ADYaiT(F1loUV.A2egSU a2egSU);

    public abstract void AMqCpz(Object obj);

    public abstract String ARc23Z();

    public void ASJ6gh() {
    }

    public A2egSU(GYpKKt.A2egSU a2egSU, int i) {
        this(a2egSU);
        this.f2565A4TApA = new HashMap();
        this.f2566A5SV6n = false;
        this.f2567ADYaiT = 1;
    }
}
