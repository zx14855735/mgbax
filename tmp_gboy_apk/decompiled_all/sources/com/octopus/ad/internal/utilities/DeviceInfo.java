package com.octopus.ad.internal.utilities;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.octopus.ad.R;
import com.octopus.ad.internal.q;
import com.octopus.ad.model.g;
import com.octopus.ad.utils.b.i;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DeviceInfo {
    public static String SDK_UID_KEY = "SDK_UID_KEY";
    public static String SDK_UID_KEY_NEW = "SDK_UID_KEY_NEW";
    private static final int algorithmVersion = 1;
    public static String density;
    public static String densityDpi;
    public static String harddiskSizeByte;
    public static String physicalMemoryByte;
    private static DeviceInfo sDeviceInfoInstance;
    public String agVercode;
    public String appList;
    public String appstoreVersion;
    public String bootMark;
    public final String brand;
    public String browserVersion;
    public final String countryCode;
    public g.b devType;
    public String hmsVercode;
    public boolean isDeveloperMode;
    public boolean isVpnOpen;
    public final String language;
    public final String manufacturer;
    public final String model;
    public final String os;
    public String resolution;
    public String root;
    public String screenSize;
    public String sysVersion;
    public String updateMark;
    public String visionWindowVersion;
    public String vivoMiniGameVersion;
    public String vivoMusicVersion;
    public boolean wxInstalled;
    public String sdkUID = null;
    public boolean firstLaunch = false;

    private DeviceInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        sb.append(" (");
        this.os = CtFAbx.B25kr6(sb, Build.VERSION.RELEASE, ")");
        this.devType = g.b.DEVICE_OTHER;
        this.brand = Build.BRAND;
        this.model = Build.MODEL;
        this.manufacturer = Build.MANUFACTURER;
        this.resolution = null;
        this.screenSize = null;
        this.language = Locale.getDefault().getLanguage();
        this.countryCode = Locale.getDefault().getCountry();
    }

    private String generateCurrentTimeMillis() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.clear();
        calendar.set(2020, 0, 1, 0, 0, 0);
        return String.valueOf(System.currentTimeMillis() - calendar.getTimeInMillis());
    }

    private String generateFourDigitRandom() {
        Random random = new Random();
        return "" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
    }

    public static DeviceInfo getInstance() {
        DeviceInfo deviceInfo;
        synchronized (DeviceInfo.class) {
            try {
                if (sDeviceInfoInstance == null) {
                    sDeviceInfoInstance = new DeviceInfo();
                    HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.init));
                    Context context = q.a().n;
                    if (context != null) {
                        String string = SPUtils.getString(context, "density");
                        density = string;
                        if (TextUtils.isEmpty(string)) {
                            String str = context.getResources().getDisplayMetrics().density + "";
                            density = str;
                            SPUtils.put(context, "density", str);
                        }
                        String string2 = SPUtils.getString(context, "ppi");
                        densityDpi = string2;
                        if (TextUtils.isEmpty(string2)) {
                            String str2 = context.getResources().getDisplayMetrics().densityDpi + "";
                            densityDpi = str2;
                            SPUtils.put(context, "ppi", str2);
                        }
                        physicalMemoryByte = i.l(context);
                        harddiskSizeByte = i.b();
                    }
                }
                deviceInfo = sDeviceInfoInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return deviceInfo;
    }

    public void generateSdkUID(Context context) {
        String generateFourDigitRandom = generateFourDigitRandom();
        String generateCurrentTimeMillis = generateCurrentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(this.brand);
        sb.append("_");
        sb.append(this.model);
        sb.append("_");
        sb.append(i.d(context));
        sb.append("_1_");
        String str = StringUtil.md5(A2egSU.B3GDIM(sb, generateFourDigitRandom, "_", generateCurrentTimeMillis)) + "_1_" + generateFourDigitRandom + "_" + generateCurrentTimeMillis;
        this.sdkUID = str;
        SPUtils.put(context, SDK_UID_KEY_NEW, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:3:0x0005, B:6:0x000f, B:13:0x002f, B:15:0x003f, B:17:0x0049, B:19:0x005b, B:25:0x006a, B:27:0x0072, B:29:0x007c, B:30:0x008c, B:32:0x002a), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:3:0x0005, B:6:0x000f, B:13:0x002f, B:15:0x003f, B:17:0x0049, B:19:0x005b, B:25:0x006a, B:27:0x0072, B:29:0x007c, B:30:0x008c, B:32:0x002a), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getMarks(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = "0"
            java.lang.String r1 = "SystemMarkStatus"
            r2 = 0
            int r3 = com.octopus.ad.internal.utilities.SPUtils.getInt(r11, r1, r2)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r4 = "SystemMarkStatusExpireTime"
            r5 = 3
            r6 = 1
            if (r3 != r6) goto L22
            com.octopus.ad.internal.utilities.SPUtils.putInt(r11, r1, r5)     // Catch: java.lang.Throwable -> L1f
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1f
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L1f
            com.octopus.ad.internal.utilities.SPUtils.put(r11, r4, r3)     // Catch: java.lang.Throwable -> L1f
            r3 = 3
            goto L22
        L1f:
            r11 = move-exception
            goto L9a
        L22:
            r7 = 2
            if (r3 == 0) goto L2a
            if (r3 != r7) goto L28
            goto L2a
        L28:
            r6 = r3
            goto L2d
        L2a:
            com.octopus.ad.internal.utilities.SPUtils.putInt(r11, r1, r6)     // Catch: java.lang.Throwable -> L1f
        L2d:
            if (r6 != r5) goto L6a
            long r5 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r3 = com.octopus.ad.internal.utilities.SPUtils.get(r11, r4, r3)     // Catch: java.lang.Throwable -> L1f
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto La1
            long r5 = r3.longValue()     // Catch: java.lang.Throwable -> L1f
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto La1
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1f
            long r7 = r3.longValue()     // Catch: java.lang.Throwable -> L1f
            long r5 = r5 - r7
            r7 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto La1
            com.octopus.ad.internal.utilities.SPUtils.putInt(r11, r1, r2)     // Catch: java.lang.Throwable -> L1f
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L1f
            com.octopus.ad.internal.utilities.SPUtils.put(r11, r4, r0)     // Catch: java.lang.Throwable -> L1f
            return
        L6a:
            com.octopus.ad.internal.q r0 = com.octopus.ad.internal.q.a()     // Catch: java.lang.Throwable -> L1f
            boolean r0 = r0.b     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L8c
            com.octopus.ad.utils.OctUtil r0 = com.octopus.ad.utils.OctUtil.a()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r0 = r0.getBootMark()     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L8c
            int r3 = r0.length()     // Catch: java.lang.Throwable -> L1f
            r4 = 36
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r0 = r0.substring(r2, r3)     // Catch: java.lang.Throwable -> L1f
            r10.bootMark = r0     // Catch: java.lang.Throwable -> L1f
        L8c:
            com.octopus.ad.utils.OctUtil r0 = com.octopus.ad.utils.OctUtil.a()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r0 = r0.getUpdateMark()     // Catch: java.lang.Throwable -> L1f
            r10.updateMark = r0     // Catch: java.lang.Throwable -> L1f
            com.octopus.ad.internal.utilities.SPUtils.putInt(r11, r1, r7)     // Catch: java.lang.Throwable -> L1f
            return
        L9a:
            java.lang.String r0 = "OctopusAd"
            java.lang.String r1 = "A Throwable Caught"
            com.octopus.ad.utils.b.f.a(r0, r1, r11)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.utilities.DeviceInfo.getMarks(android.content.Context):void");
    }
}
