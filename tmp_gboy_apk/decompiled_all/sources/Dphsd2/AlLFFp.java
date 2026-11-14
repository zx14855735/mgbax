package Dphsd2;

import ADYaiT.BmvVmW;
import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.BTvldC;
import androidx.core.app.BV3sI0;
import androidx.emoji2.text.B9tovu;
import androidx.emoji2.text.BChYOn;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.api.SAAllianceAdInitParams;
import com.alliance.ssp.ad.manager.applist.bean.RequestConfigBean;
import com.alliance.ssp.ad.service.YTSDKDownloadService;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.alliance.ssp.ad.utils.jni_interface;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.fl.saas.config.http.HttpCallbackBytesListener;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.HttpUtils;
import com.google.gson.Gson;
import com.sigmob.sdk.base.db.a;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.nativead.b;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaa0;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTInterstitialAd;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTNativeAdLoader;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTRewardAd;
import io.dcloud.sdk.poly.adapter.custom.yt.CustomYTSplashAd;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AlLFFp implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2458AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2459AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f2460AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f2461AzWtSf;

    public /* synthetic */ AlLFFp(int i, Object obj, Object obj2, Object obj3) {
        this.f2458AcNBzu = i;
        this.f2461AzWtSf = obj;
        this.f2459AlLFFp = obj2;
        this.f2460AmA8tU = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        int i;
        String str2;
        String str3;
        RequestBody requestBody;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        NotificationManager notificationManager;
        int i2 = 17;
        int i3 = 0;
        switch (this.f2458AcNBzu) {
            case 0:
                AmA8tU amA8tU = (AmA8tU) this.f2461AzWtSf;
                amA8tU.getClass();
                ((ImageView) this.f2459AlLFFp).setImageBitmap((Bitmap) this.f2460AmA8tU);
                FrameLayout frameLayout = amA8tU.f2464AmA8tU.f9634C2rE4F;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                    return;
                }
                return;
            case 1:
                NMRewardVideoActivity nMRewardVideoActivity = ((AmA8tU) this.f2461AzWtSf).f2464AmA8tU;
                boolean z = nMRewardVideoActivity.f9680EiK8oA;
                ImageView imageView = (ImageView) this.f2459AlLFFp;
                Bitmap bitmap = (Bitmap) this.f2460AmA8tU;
                if (z) {
                    imageView.setImageBitmap(JrXYwF.A4TApA.A4TApA(bitmap, 20.0f));
                    return;
                }
                imageView.setImageBitmap(bitmap);
                FrameLayout frameLayout2 = nMRewardVideoActivity.f9634C2rE4F;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(0);
                    return;
                }
                return;
            case 2:
                EY4UKY.A2egSU a2egSU = (EY4UKY.A2egSU) this.f2461AzWtSf;
                a2egSU.getClass();
                Context context = EY4UKY.A2egSU.A5SV6n().f2499A2egSU;
                Context context2 = context != null ? context : null;
                if (context2 != null) {
                    try {
                        GJee0v.AmA8tU A2egSU2 = GJee0v.AmA8tU.A2egSU();
                        A2egSU2.getClass();
                        SharedPreferences sharedPreferences = context2.getSharedPreferences("yx_game", 0);
                        A2egSU2.f3053A2egSU = sharedPreferences;
                        sharedPreferences.edit();
                        NOd7IU.AlLFFp.Cd8JRx();
                        DeviceUtil.AZOQYO(context2);
                        DeviceUtil.getLgid();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        EY4UKY.ADYaiT.f2513AzWtSf = EY4UKY.A2egSU.A2egSU(elapsedRealtime);
                        EY4UKY.ADYaiT.f2514B25kr6 = EY4UKY.A2egSU.A2egSU(System.currentTimeMillis() - elapsedRealtime);
                        String B4ZgIw2 = EY4UKY.ADYaiT.B4ZgIw(context2);
                        EY4UKY.ADYaiT.f2515B2KMhB = B4ZgIw2;
                        try {
                            DuwtYk.AMqCpz.f2473AmA8tU = URLEncoder.encode(B4ZgIw2, "UTF-8");
                        } catch (Exception e) {
                            new EY4UKY.ADYaiT().AmA8tU("004", "AdAllianceManager 002: " + e.getMessage(), e);
                        }
                        DeviceUtil.AlLFFp(context2);
                        DeviceUtil.B25kr6(context2);
                        DisplayMetrics displayMetrics = a2egSU.f2499A2egSU.getResources().getDisplayMetrics();
                        EY4UKY.ADYaiT.f2523BJ7GGh = "" + displayMetrics.densityDpi;
                        EY4UKY.ADYaiT.f2524BNL6CD = "" + displayMetrics.density;
                        EY4UKY.ADYaiT.f2525BPw6Q8 = "" + JrXYwF.A4TApA.A2egSU(context2);
                        if (a2egSU.f2499A2egSU.getResources().getConfiguration().orientation == 1) {
                            EY4UKY.ADYaiT.f2526BTvldC = "1";
                        } else {
                            EY4UKY.ADYaiT.f2526BTvldC = "2";
                        }
                        EY4UKY.ADYaiT.f2528BmvVmW = "" + SystemClock.elapsedRealtime();
                        EY4UKY.ADYaiT.f2527BV3sI0 = EY4UKY.A2egSU.A2egSU(Build.TIME);
                        GJee0v.AaHO0E.f3044A5SV6n.A4TApA(context2);
                        EY4UKY.ADYaiT.f2516B3GDIM = "" + System.currentTimeMillis();
                        String str9 = com.bumptech.glide.A5SV6n.f9887ARc23Z;
                        if (str9 == null || str9.isEmpty()) {
                            try {
                                com.bumptech.glide.A5SV6n.f9887ARc23Z = TimeZone.getDefault().getID();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            str2 = com.bumptech.glide.A5SV6n.f9887ARc23Z;
                        } else {
                            str2 = com.bumptech.glide.A5SV6n.f9887ARc23Z;
                        }
                        EY4UKY.ADYaiT.f2521BI9f7h = str2;
                        String str10 = com.bumptech.glide.A5SV6n.f9889AYUAbz;
                        if (str10 == null || str10.isEmpty()) {
                            try {
                                com.bumptech.glide.A5SV6n.f9889AYUAbz = context2.getResources().getConfiguration().locale.getLanguage();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            str3 = com.bumptech.glide.A5SV6n.f9889AYUAbz;
                        } else {
                            str3 = com.bumptech.glide.A5SV6n.f9889AYUAbz;
                        }
                        EY4UKY.ADYaiT.f2518B7CMnp = str3;
                        try {
                            PackageManager packageManager = context2.getPackageManager();
                            PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 1);
                            if (packageInfo != null) {
                                EY4UKY.ADYaiT.f2517B4ZgIw = "" + new File(packageManager.getApplicationInfo(packageInfo.packageName, 0).sourceDir).lastModified();
                            }
                        } catch (PackageManager.NameNotFoundException e4) {
                            int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                            new EY4UKY.ADYaiT().AmA8tU("004", "AdAllianceManager 003: " + e4.getMessage(), e4);
                        }
                        try {
                            ActivityManager activityManager = (ActivityManager) context2.getSystemService(TTDownloadField.TT_ACTIVITY);
                            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                            activityManager.getMemoryInfo(memoryInfo);
                            long j = memoryInfo.totalMem;
                            EY4UKY.ADYaiT.f2520BChYOn = "" + j;
                            EY4UKY.ADYaiT.f2522BIYEnU = (int) (j / C.MICROS_PER_SECOND);
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                            EY4UKY.ADYaiT.f2519B9tovu = "" + (statFs.getBlockSizeLong() * statFs.getBlockCountLong());
                        } catch (Exception e5) {
                            new EY4UKY.ADYaiT().AmA8tU("004", "AdAllianceManager 004: " + e5.getMessage(), e5);
                        }
                        try {
                            EY4UKY.A2egSU.f2497A5SV6n = jni_interface.GetBoot();
                            EY4UKY.A2egSU.f2498ADYaiT = jni_interface.GetUpdate();
                        } catch (Exception e6) {
                            new EY4UKY.ADYaiT().AmA8tU("004", "AdAllianceManager 006: " + e6.getMessage(), e6);
                        } catch (UnsatisfiedLinkError e7) {
                            new EY4UKY.ADYaiT().AmA8tU("004", "AdAllianceManager 005: " + e7.getMessage(), null);
                        }
                        Application application = (Application) GJee0v.A2egSU.A2egSU();
                        if (application != null) {
                            application.registerActivityLifecycleCallbacks(new GJee0v.AMqCpz(new GJee0v.ARc23Z(), new BmvVmW(i2)));
                        }
                    } catch (Exception e8) {
                        str = null;
                        i = 0;
                        new EY4UKY.ADYaiT().AZkASS(0, 2, "", null);
                        CtFAbx.B4ZgIw(e8, JrXYwF.A4TApA.AMqCpz("AdAllianceManager 001: "), new EY4UKY.ADYaiT(), "004", e8);
                    }
                }
                str = null;
                i = 0;
                new EY4UKY.ADYaiT().AZkASS(i, i, "", str);
                String str11 = (String) this.f2459AlLFFp;
                Context context3 = (Context) this.f2460AmA8tU;
                String str12 = context3 == null ? "sdk初始化失败！请检查传入Context是否为空。" : (str11 == null || str11.isEmpty()) ? "sdk初始化失败！请检查传入appId是否为空。" : null;
                if (str12 != null && !str12.isEmpty()) {
                    new EY4UKY.ADYaiT().AZkASS(0, 2, "", "10001");
                    return;
                }
                GGG1xW.A2egSU a2egSU2 = GGG1xW.A2egSU.f2987AZOQYO;
                a2egSU2.f2990A5SV6n = context3;
                new EY4UKY.ADYaiT().AZkASS(0, 1, "", null);
                int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                if (context3 == null || !GGG1xW.A2egSU.ADYaiT(str11)) {
                    return;
                }
                a2egSU2.f2990A5SV6n = context3;
                if (!GGG1xW.A2egSU.ADYaiT(GGG1xW.A2egSU.f2986AYUAbz)) {
                    SharedPreferences sharedPreferences2 = context3.getSharedPreferences("adalliancesdk", 0);
                    a2egSU2.f2988A2egSU = sharedPreferences2;
                    GGG1xW.A2egSU.f2986AYUAbz = GGG1xW.A2egSU.A4TApA(sharedPreferences2.getString("yt_sdk_2_intersection_list", ""));
                }
                HashMap hashMap = new HashMap();
                Context context4 = EY4UKY.A2egSU.A5SV6n().f2499A2egSU;
                if (context4 == null) {
                    context4 = null;
                }
                if (context4 != null) {
                    hashMap.put("appid", str11);
                    try {
                        str4 = Build.MANUFACTURER;
                    } catch (Exception unused) {
                        str4 = "";
                    }
                    hashMap.put("make", str4);
                    try {
                        str5 = Build.MODEL;
                    } catch (Exception e9) {
                        e9.printStackTrace();
                        str5 = "";
                    }
                    hashMap.put(bn.i, str5);
                    try {
                        str6 = Build.BRAND;
                    } catch (Exception unused2) {
                        str6 = "";
                    }
                    hashMap.put(bn.j, str6);
                    hashMap.put("os", "Android");
                    try {
                        str7 = Build.VERSION.RELEASE;
                    } catch (Exception unused3) {
                        str7 = "";
                    }
                    hashMap.put("osv", str7);
                    hashMap.put("resolution", DeviceUtil.AmA8tU(context4));
                    hashMap.put("ver", DeviceUtil.ARc23Z(context4));
                    hashMap.put("sdkver", DeviceUtil.AYUAbz());
                    hashMap.put("gid", DeviceUtil.ASJ6gh(context4));
                    hashMap.put("platform", 2);
                    hashMap.put("ua", EY4UKY.ADYaiT.B4ZgIw(context4));
                    hashMap.put("startuptime", EY4UKY.ADYaiT.f2513AzWtSf);
                    hashMap.put("boottime", EY4UKY.ADYaiT.f2514B25kr6);
                    hashMap.put("bootmark", EY4UKY.A2egSU.f2497A5SV6n);
                    hashMap.put("updatemark", EY4UKY.A2egSU.f2498ADYaiT);
                    hashMap.put("devicetype", EY4UKY.ADYaiT.A2egSU(context4));
                    hashMap.put("dpi", EY4UKY.ADYaiT.f2523BJ7GGh);
                    hashMap.put("ppi", EY4UKY.ADYaiT.f2525BPw6Q8);
                    hashMap.put("density", EY4UKY.ADYaiT.f2524BNL6CD);
                    hashMap.put("orientation", EY4UKY.ADYaiT.f2526BTvldC);
                    hashMap.put("osupdatetime", EY4UKY.ADYaiT.f2527BV3sI0);
                    hashMap.put("itime", "" + System.currentTimeMillis());
                    hashMap.put("ltime", EY4UKY.ADYaiT.f2516B3GDIM);
                    hashMap.put("lgid", DeviceUtil.getLgid());
                    hashMap.put("isnew", Integer.valueOf(DeviceUtil.B25kr6(context4)));
                    hashMap.put("onetime", DeviceUtil.AlLFFp(context4));
                    hashMap.put("cookieid", DeviceUtil.AZOQYO(context4));
                    hashMap.put("sysid", Constants.FAIL);
                    hashMap.put("cgid", Constants.FAIL);
                    hashMap.put("installTime", EY4UKY.ADYaiT.f2517B4ZgIw);
                    hashMap.put(MediaFormat.KEY_LANGUAGE, EY4UKY.ADYaiT.f2518B7CMnp);
                    hashMap.put("disk", EY4UKY.ADYaiT.f2519B9tovu);
                    hashMap.put("memory", EY4UKY.ADYaiT.f2520BChYOn);
                    hashMap.put("timezone", EY4UKY.ADYaiT.f2521BI9f7h);
                    hashMap.put("apppackage", DeviceUtil.A2egSU(context4));
                    hashMap.put("appstoreversion", DeviceUtil.AMqCpz(context4));
                    hashMap.put("devicename", DeviceUtil.AZkASS(context4));
                    try {
                        PackageInfo packageInfo2 = context4.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                        if (packageInfo2 != null) {
                            hashMap.put("hmsversion", packageInfo2.versionName);
                        }
                    } catch (PackageManager.NameNotFoundException unused4) {
                        hashMap.put("hmsversion", "");
                    }
                    hashMap.put("secondsfromgmt", com.bumptech.glide.A5SV6n.A4TApA());
                    hashMap.put("hwmodel", Build.HARDWARE);
                    hashMap.put("fulllanguage", com.bumptech.glide.A5SV6n.AmA8tU(context4));
                    hashMap.put("countrycode", com.bumptech.glide.A5SV6n.ADYaiT(context4));
                    hashMap.put("birthtime", EY4UKY.ADYaiT.f2528BmvVmW);
                    hashMap.put("hmsCoreVer", DeviceUtil.AcNBzu(context4));
                    hashMap.put("hmsAGVerCode", DeviceUtil.AaHO0E(context4));
                    String str13 = NOd7IU.AlLFFp.f5890B2KMhB;
                    int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                    hashMap.put("ip", str13);
                    hashMap.put("ipv6", NOd7IU.AlLFFp.f5891B3GDIM);
                    hashMap.put("carrier", NOd7IU.AlLFFp.B25kr6());
                    hashMap.put("androidid", NOd7IU.AlLFFp.ARc23Z());
                    hashMap.put("imei", NOd7IU.AlLFFp.B3GDIM());
                    hashMap.put("mac", NOd7IU.AlLFFp.f5889B25kr6);
                    hashMap.put("oaid", NOd7IU.AlLFFp.CASmeH());
                    hashMap.put("enablePersonalized", NOd7IU.AlLFFp.f5901BTvldC ? Constants.FAIL : "1");
                    hashMap.put("connectiontype", Integer.valueOf(NOd7IU.AlLFFp.f5892B4ZgIw));
                    double[] C2rE4F2 = NOd7IU.AlLFFp.C2rE4F();
                    if (C2rE4F2 != null && C2rE4F2.length >= 2) {
                        hashMap.put("geo", C2rE4F2[0] + "," + C2rE4F2[1]);
                    }
                }
                RequestConfigBean requestConfigBean = new RequestConfigBean(hashMap);
                EiK8oA.A4TApA a4TApA = EiK8oA.A4TApA.f2543A4TApA;
                KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(i2, a2egSU2);
                a4TApA.getClass();
                try {
                    String[] AZkASS2 = com.bumptech.glide.A5SV6n.AZkASS(new Gson().toJson(requestConfigBean));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("cipher", AZkASS2[0]);
                    jSONObject.put("encryptParams", AZkASS2[1]);
                    requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString());
                } catch (Exception unused5) {
                    requestBody = null;
                }
                if (requestBody == null) {
                    int i7 = GJee0v.AZOQYO.f3039AcNBzu;
                    return;
                } else {
                    new EY4UKY.ADYaiT().AZOQYO(0, 0, null, null, 0);
                    a4TApA.f2544A2egSU.newCall(new Request.Builder().url("https://de.ad.gameley.com/delivery/request/getad/config").post(requestBody).build()).enqueue(new DUi7mC(a4TApA, new int[]{0}, a5SV6n, 4, false));
                    return;
                }
            case 3:
                Thread.currentThread().setUncaughtExceptionHandler(GJee0v.AlLFFp.f3048ADYaiT);
                String str14 = (String) this.f2461AzWtSf;
                if (TextUtils.isEmpty(str14) || !str14.contains(".apk")) {
                    str8 = "";
                } else {
                    int lastIndexOf = str14.lastIndexOf(".apk");
                    str8 = str14.substring(str14.lastIndexOf(47, lastIndexOf) + 1, lastIndexOf + 4);
                }
                ArrayList arrayList = GnQT2j.ARc23Z.f3097A4TApA;
                if (arrayList.contains(str8)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                Context context5 = (Context) this.f2459AlLFFp;
                sb.append(context5.getExternalCacheDir());
                sb.append("/nmssp_download/");
                String sb2 = sb.toString();
                File file = new File(sb2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                G58fqA.A2egSU a2egSU3 = GnQT2j.ARc23Z.f3101ASJ6gh;
                if (a2egSU3 != null) {
                    a2egSU3.A4TApA();
                    GnQT2j.ARc23Z.f3101ASJ6gh = null;
                }
                GnQT2j.AMqCpz aMqCpz = (GnQT2j.AMqCpz) this.f2460AmA8tU;
                G58fqA.A2egSU a2egSU4 = new G58fqA.A2egSU(new GnQT2j.A4TApA(i3, str14, str8, aMqCpz), context5);
                GnQT2j.ARc23Z.f3101ASJ6gh = a2egSU4;
                a2egSU4.AMqCpz("SA_TARGET_YT_NOTIFICATION_CANCEL", "SA_TARGET_YT_NOTIFICATION_CLICK");
                G58fqA.A4TApA a4TApA2 = GnQT2j.ARc23Z.f3100ARc23Z;
                if (a4TApA2 != null) {
                    if (a4TApA2.AMqCpz && (notificationManager = a4TApA2.f2981A4TApA) != null) {
                        notificationManager.cancel(a4TApA2.f2980A2egSU);
                        a4TApA2.f2981A4TApA = null;
                        a4TApA2.f2982A5SV6n = null;
                        a4TApA2.f2983ADYaiT = null;
                        a4TApA2.AMqCpz = false;
                    }
                    GnQT2j.ARc23Z.f3100ARc23Z = null;
                }
                G58fqA.A4TApA a4TApA3 = new G58fqA.A4TApA(context5, arrayList.indexOf(str8));
                GnQT2j.ARc23Z.f3100ARc23Z = a4TApA3;
                String BChYOn2 = CtFAbx.BChYOn("下载中 ", str8);
                if (a4TApA3.AMqCpz) {
                    Intent intent = new Intent(context5, (Class<?>) YTSDKDownloadService.class);
                    intent.setAction("SA_TARGET_YT_NOTIFICATION_CLICK");
                    PendingIntent service = PendingIntent.getService(context5, 0, intent, 201326592);
                    Intent intent2 = new Intent(context5, (Class<?>) YTSDKDownloadService.class);
                    intent2.setAction("SA_TARGET_YT_NOTIFICATION_CANCEL");
                    PendingIntent service2 = PendingIntent.getService(context5, 0, intent2, 201326592);
                    try {
                        BV3sI0 bV3sI0 = new BV3sI0(context5.getApplicationContext(), "download_channel_id");
                        bV3sI0.f8551CikNvS.icon = context5.getResources().getIdentifier("nmadssp_icon_shuffle_on", "drawable", context5.getPackageName());
                        bV3sI0.AMqCpz = BV3sI0.A4TApA(BChYOn2);
                        bV3sI0.f8515ARc23Z = BV3sI0.A4TApA("");
                        bV3sI0.f8522AlLFFp = 2;
                        bV3sI0.f8516ASJ6gh = service;
                        bV3sI0.f8551CikNvS.deleteIntent = service2;
                        bV3sI0.AMqCpz(8, true);
                        Notification notification = bV3sI0.f8551CikNvS;
                        notification.sound = null;
                        notification.audioStreamType = -1;
                        notification.audioAttributes = BTvldC.A2egSU(BTvldC.AMqCpz(BTvldC.A5SV6n(BTvldC.A4TApA(), 4), 5));
                        bV3sI0.f8551CikNvS.vibrate = null;
                        bV3sI0.AMqCpz(16, false);
                        bV3sI0.AMqCpz(2, false);
                        a4TApA3.f2982A5SV6n = bV3sI0;
                    } catch (Exception e10) {
                        e10.getMessage();
                    }
                    NotificationManager notificationManager2 = a4TApA3.f2981A4TApA;
                    if (notificationManager2 != null) {
                        notificationManager2.notify(a4TApA3.f2980A2egSU, a4TApA3.f2982A5SV6n.A2egSU());
                    }
                }
                GnQT2j.A2egSU a2egSU5 = new GnQT2j.A2egSU(context5);
                File file2 = new File(sb2, str8);
                GnQT2j.ARc23Z.f3097A4TApA.add(str8);
                Toast.makeText(context5, "正在下载" + str8, 1).show();
                aMqCpz.c();
                GnQT2j.ARc23Z.f3104AZkASS = false;
                GnQT2j.ARc23Z.f3102AYUAbz = false;
                GnQT2j.ARc23Z.f3103AZOQYO = false;
                EY4UKY.AMqCpz aMqCpz2 = new EY4UKY.AMqCpz();
                aMqCpz2.f2536AcNBzu = str8;
                aMqCpz2.f2537AlLFFp = file2;
                aMqCpz2.f2538AmA8tU = aMqCpz;
                aMqCpz2.f2539AzWtSf = sb2;
                aMqCpz2.f2540B25kr6 = context5;
                GnQT2j.AZOQYO azoqyo = GnQT2j.AZOQYO.f3117AZOQYO;
                if (azoqyo == null && azoqyo == null) {
                    GnQT2j.AZOQYO.f3117AZOQYO = new GnQT2j.AZOQYO(a2egSU5, aMqCpz2);
                }
                GnQT2j.AZOQYO azoqyo2 = GnQT2j.AZOQYO.f3117AZOQYO;
                azoqyo2.AMqCpz = null;
                azoqyo2.f3120A5SV6n = aMqCpz2;
                GnQT2j.AZkASS aZkASS = new GnQT2j.AZkASS(str8, str14);
                azoqyo2.A2egSU(aZkASS);
                GnQT2j.AZOQYO.f3116AYUAbz = sb2;
                azoqyo2.A5SV6n(str14, sb2);
                GnQT2j.ARc23Z.f3098A5SV6n.put(str14, str8);
                GnQT2j.ARc23Z.f3099ADYaiT.put(str14, azoqyo2);
                GnQT2j.ARc23Z.AMqCpz.put(str14, aZkASS);
                return;
            case 4:
                a.b((SQLiteDatabase) this.f2461AzWtSf, (SQLiteBuider.Insert) this.f2459AlLFFp, (a.InterfaceC0448a) this.f2460AmA8tU);
                return;
            case 5:
                NOd7IU.AmA8tU amA8tU2 = (NOd7IU.AmA8tU) this.f2461AzWtSf;
                androidx.emoji2.text.AlLFFp alLFFp = (androidx.emoji2.text.AlLFFp) this.f2459AlLFFp;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f2460AmA8tU;
                amA8tU2.getClass();
                try {
                    BChYOn BTvldC2 = NOd7IU.AlLFFp.BTvldC(amA8tU2.f5913AlLFFp);
                    if (BTvldC2 == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    B9tovu b9tovu = (B9tovu) BTvldC2.f8654A2egSU;
                    synchronized (b9tovu.f8675AzWtSf) {
                        b9tovu.f8677B2KMhB = threadPoolExecutor;
                    }
                    BTvldC2.f8654A2egSU.A2egSU(new androidx.emoji2.text.B25kr6(alLFFp, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    alLFFp.A2egSU(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 6:
                ((HttpUtils) this.f2461AzWtSf).lambda$doGet$2((String) this.f2459AlLFFp, (HttpCallbackBytesListener) this.f2460AmA8tU);
                return;
            case 7:
                HttpUtils.lambda$uploadFile$4((String) this.f2461AzWtSf, (File[]) this.f2459AlLFFp, (HttpCallbackStringListener) this.f2460AmA8tU);
                return;
            case 8:
                ((b) this.f2461AzWtSf).a((BidResponse) this.f2459AlLFFp, (Context) this.f2460AmA8tU);
                return;
            case 9:
                ((aaaaaaaa) this.f2461AzWtSf).aaaaaaaa((TextView) this.f2459AlLFFp, (FrameLayout) this.f2460AmA8tU);
                return;
            case 10:
                ((aaaaaaa0) this.f2461AzWtSf).aaaaaaaa((String) this.f2459AlLFFp, (HashMap) this.f2460AmA8tU);
                return;
            case 11:
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa) this.f2461AzWtSf).aaaaaaaa((String) this.f2459AlLFFp, (String) this.f2460AmA8tU);
                return;
            case 12:
                ((CustomYTInterstitialAd) this.f2461AzWtSf).lambda$load$0((UniAdSlot) this.f2459AlLFFp, (Activity) this.f2460AmA8tU);
                return;
            case 13:
                ((CustomYTNativeAdLoader) this.f2461AzWtSf).lambda$load$0((UniAdSlot) this.f2459AlLFFp, (Activity) this.f2460AmA8tU);
                return;
            case 14:
                ((CustomYTRewardAd) this.f2461AzWtSf).lambda$load$0((UniAdSlot) this.f2459AlLFFp, (Activity) this.f2460AmA8tU);
                return;
            default:
                ((CustomYTSplashAd) this.f2461AzWtSf).lambda$load$0((UniAdSlot) this.f2459AlLFFp, (Activity) this.f2460AmA8tU);
                return;
        }
    }

    public /* synthetic */ AlLFFp(EY4UKY.A2egSU a2egSU, String str, SAAllianceAdInitParams sAAllianceAdInitParams, Context context) {
        this.f2458AcNBzu = 2;
        this.f2461AzWtSf = a2egSU;
        this.f2459AlLFFp = str;
        this.f2460AmA8tU = context;
    }

    public /* synthetic */ AlLFFp(GnQT2j.ADYaiT aDYaiT, String str, Context context, GnQT2j.AMqCpz aMqCpz) {
        this.f2458AcNBzu = 3;
        this.f2461AzWtSf = str;
        this.f2459AlLFFp = context;
        this.f2460AmA8tU = aMqCpz;
    }
}
