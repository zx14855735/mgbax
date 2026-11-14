package EY4UKY;

import GJee0v.AZkASS;
import NOd7IU.AlLFFp;
import android.content.Context;
import com.alliance.ssp.ad.api.SAAllianceAdInitParams;
import com.alliance.ssp.ad.utils.DeviceUtil;
import java.text.DecimalFormat;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static A2egSU f2496A4TApA = null;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static String f2497A5SV6n = "";

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static String f2498ADYaiT = "";

    /* renamed from: A2egSU, reason: collision with root package name */
    public Context f2499A2egSU = null;

    public static String A2egSU(long j) {
        long j2 = j / 1000;
        String format = new DecimalFormat("0.000000").format((j % 1000.0f) / 1000.0f);
        int lastIndexOf = format.lastIndexOf(46);
        if (lastIndexOf > 0) {
            return "" + j2 + format.substring(lastIndexOf);
        }
        return "" + j2 + ".000000";
    }

    public static A2egSU A5SV6n() {
        if (f2496A4TApA == null) {
            synchronized (A2egSU.class) {
                f2496A4TApA = new A2egSU();
            }
        }
        return f2496A4TApA;
    }

    public final void A4TApA(String str, Context context, SAAllianceAdInitParams sAAllianceAdInitParams) {
        com.bumptech.glide.A5SV6n.f9894AlLFFp = sAAllianceAdInitParams.getDebug();
        String str2 = DeviceUtil.f9708A2egSU;
        if (str2 != null && !str2.isEmpty()) {
            StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("sdk已初始化完成，当前appId为\"");
            AMqCpz.append(DeviceUtil.f9708A2egSU);
            AMqCpz.append("\", 不可重复初始化。");
            return;
        }
        context.getPackageName();
        this.f2499A2egSU = context;
        ADYaiT.f2503ADYaiT = sAAllianceAdInitParams.getOaid();
        ADYaiT.AMqCpz = sAAllianceAdInitParams.getImei();
        sAAllianceAdInitParams.getAndroidId();
        ADYaiT.f2504ARc23Z = sAAllianceAdInitParams.getMac();
        ADYaiT.f2532CASmeH = sAAllianceAdInitParams.getUserId();
        ADYaiT.f2505ASJ6gh = sAAllianceAdInitParams.getCarrier();
        ADYaiT.f2506AYUAbz = sAAllianceAdInitParams.getLocation();
        if (str != null) {
            DeviceUtil.f9708A2egSU = str;
        }
        AlLFFp.f5884AaHO0E = sAAllianceAdInitParams.getAndroidId();
        AlLFFp.f5885AcNBzu = sAAllianceAdInitParams.getImei();
        AlLFFp.f5886AlLFFp = sAAllianceAdInitParams.getOaid();
        AlLFFp.f5889B25kr6 = sAAllianceAdInitParams.getMac();
        AlLFFp.f5888AzWtSf = sAAllianceAdInitParams.getLocation();
        AlLFFp.f5887AmA8tU = sAAllianceAdInitParams.getCarrier();
        AlLFFp.f5893B7CMnp = sAAllianceAdInitParams.isCanUseIMei();
        AlLFFp.f5894B9tovu = sAAllianceAdInitParams.isCanUseOaid();
        AlLFFp.f5896BI9f7h = sAAllianceAdInitParams.isCanUseLocation();
        AlLFFp.f5897BIYEnU = sAAllianceAdInitParams.isCanUseMac();
        AlLFFp.f5898BJ7GGh = sAAllianceAdInitParams.isCanUseCarrier();
        AlLFFp.f5899BNL6CD = sAAllianceAdInitParams.isCanUseInstallAppList();
        AlLFFp.f5901BTvldC = sAAllianceAdInitParams.isEnablePersonalized();
        AlLFFp.f5902BV3sI0 = sAAllianceAdInitParams.isCanUseWifiState();
        AlLFFp.f5905C2rE4F = sAAllianceAdInitParams;
        AZkASS.f3040ADYaiT.f3041A2egSU.execute(new Dphsd2.AlLFFp(this, str, sAAllianceAdInitParams, context));
    }
}
