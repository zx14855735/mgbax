package EY4UKY;

import ADYaiT.CtFAbx;
import GJee0v.AZOQYO;
import GJee0v.AZkASS;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.n;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ADYaiT {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static String f2503ADYaiT;
    public static String AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static String f2504ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static String f2505ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static double[] f2506AYUAbz;

    /* renamed from: A2egSU, reason: collision with root package name */
    public HashMap f2534A2egSU = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public JSONObject f2535A4TApA = new JSONObject();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final HashMap f2502A5SV6n = new HashMap();

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static long f2507AZOQYO = 0;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static long f2508AZkASS = 0;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static long f2509AaHO0E = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static long f2510AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static long f2511AlLFFp = 0;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static long f2512AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static String f2513AzWtSf = "";

    /* renamed from: B25kr6, reason: collision with root package name */
    public static String f2514B25kr6 = "";

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static String f2515B2KMhB = "";

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static String f2516B3GDIM = "";

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static String f2517B4ZgIw = "";

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static String f2518B7CMnp = "";

    /* renamed from: B9tovu, reason: collision with root package name */
    public static String f2519B9tovu = "";

    /* renamed from: BChYOn, reason: collision with root package name */
    public static String f2520BChYOn = "";

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static String f2521BI9f7h = "";

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static int f2522BIYEnU = 0;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public static String f2523BJ7GGh = "";

    /* renamed from: BNL6CD, reason: collision with root package name */
    public static String f2524BNL6CD = "";

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public static String f2525BPw6Q8 = "";

    /* renamed from: BTvldC, reason: collision with root package name */
    public static String f2526BTvldC = Constants.FAIL;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public static String f2527BV3sI0 = "";

    /* renamed from: BmvVmW, reason: collision with root package name */
    public static String f2528BmvVmW = "";

    /* renamed from: BniPrB, reason: collision with root package name */
    public static String f2529BniPrB = "";
    public static String BpkvW3 = "";

    /* renamed from: C2rE4F, reason: collision with root package name */
    public static String f2530C2rE4F = "";

    /* renamed from: C4FrIb, reason: collision with root package name */
    public static boolean f2531C4FrIb = true;

    /* renamed from: CASmeH, reason: collision with root package name */
    public static String f2532CASmeH = "";

    /* renamed from: CNPG0E, reason: collision with root package name */
    public static String f2533CNPG0E = "";

    static {
        PPvoSub();
    }

    public static String A2egSU(Context context) {
        String str = f2533CNPG0E;
        if (str != null && !str.isEmpty()) {
            return f2533CNPG0E;
        }
        String B4ZgIw2 = B4ZgIw(context);
        if (B4ZgIw2 != null && !B4ZgIw2.isEmpty()) {
            if (B4ZgIw2.contains("Windows")) {
                f2533CNPG0E = "2";
                return "2";
            }
            if (B4ZgIw2.contains("TV")) {
                f2533CNPG0E = "3";
                return "3";
            }
            if (B4ZgIw2.contains("Mobile")) {
                f2533CNPG0E = "4";
                return "4";
            }
            if (B4ZgIw2.contains("Tablet") || B4ZgIw2.contains("PlayBook")) {
                f2533CNPG0E = "5";
                return "5";
            }
        }
        f2533CNPG0E = "4";
        return "4";
    }

    public static String A4TApA(Exception exc) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        exc.printStackTrace(new PrintStream(byteArrayOutputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        String str = null;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return str;
                }
                str = str + readLine + "\n";
            } catch (IOException e) {
                e.getMessage();
                int i = AZOQYO.f3039AcNBzu;
                return str;
            }
        }
    }

    public static String A5SV6n(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return "" + (Float.parseFloat(str) / 100.0f);
            } catch (Exception unused) {
                int i = AZOQYO.f3039AcNBzu;
            }
        }
        return Constants.FAIL;
    }

    public static void AMqCpz(int i, int i2, int i3, HashMap hashMap) {
        String AZkASS2 = CtFAbx.AZkASS("\nreportParams : \n", i3, J3FDQU.A2egSU.B7CMnp(i, i2, "state : ", " ", " "));
        for (Map.Entry entry : hashMap.entrySet()) {
            StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("  | ");
            AMqCpz2.append((String) entry.getKey());
            AMqCpz2.append(" : ");
            AMqCpz2.append(entry.getValue());
            AMqCpz2.append("\n");
            AZkASS2 = CtFAbx.AcNBzu(AZkASS2, AMqCpz2.toString());
        }
        int i4 = AZOQYO.f3039AcNBzu;
    }

    public static void B25kr6(JSONObject jSONObject, SAAllianceAdData sAAllianceAdData) {
        try {
            jSONObject.put("tagName", sAAllianceAdData.getTagName());
            jSONObject.put("tagVer", sAAllianceAdData.getTagVer());
            jSONObject.put("tagCode", sAAllianceAdData.getTagCode());
            if (sAAllianceAdData.getInteraction() != null) {
                jSONObject.put("clickArea", sAAllianceAdData.getInteraction().clickArea);
            }
            if (sAAllianceAdData.getParentCrequestid() != null && !sAAllianceAdData.getParentCrequestid().isEmpty()) {
                jSONObject.put("parentCrequestid", sAAllianceAdData.getParentCrequestid());
            }
            if (sAAllianceAdData.getSpostype() == 6 && sAAllianceAdData.getMaterial() != null) {
                jSONObject.put("rewardVerifyDuration", sAAllianceAdData.getMaterial().getDuration());
            }
            if (sAAllianceAdData.getValidExposeTime() != 0.0f) {
                jSONObject.put("validExposeTime", sAAllianceAdData.getValidExposeTime());
            }
        } catch (Exception e) {
            e.getMessage();
            A4TApA(e);
            int i = AZOQYO.f3039AcNBzu;
        }
    }

    public static void B2KMhB(JSONObject jSONObject, String str) {
        if (str != null) {
            try {
                HashMap hashMap = f2502A5SV6n;
                if (hashMap != null && hashMap.containsKey(str)) {
                    Integer num = (Integer) hashMap.get(str);
                    jSONObject.put("tolerateTimeout", String.valueOf(num != null ? num.intValue() : 0));
                }
            } catch (Exception e) {
                e.getMessage();
                A4TApA(e);
                int i = AZOQYO.f3039AcNBzu;
                return;
            }
        }
        String str2 = f2503ADYaiT;
        if (str2 != null && !str2.isEmpty()) {
            jSONObject.put("custom_oaid", f2503ADYaiT);
        }
        String str3 = f2504ARc23Z;
        if (str3 != null && !str3.isEmpty()) {
            jSONObject.put("custom_mac", f2504ARc23Z);
        }
        String str4 = AMqCpz;
        if (str4 != null && !str4.isEmpty()) {
            jSONObject.put("custom_imei", AMqCpz);
        }
        String str5 = f2505ASJ6gh;
        if (str5 != null && !str5.isEmpty()) {
            jSONObject.put("custom_carrier", f2505ASJ6gh);
        }
        double[] dArr = f2506AYUAbz;
        if (dArr != null && dArr.length == 2) {
            jSONObject.put("custom_geo", f2506AYUAbz[0] + "," + f2506AYUAbz[1]);
        }
        boolean z = f2531C4FrIb;
        String str6 = Constants.FAIL;
        jSONObject.put("enableShake", z ? "1" : Constants.FAIL);
        if (!AlLFFp.f5901BTvldC) {
            str6 = "1";
        }
        jSONObject.put("enablePersonalized", str6);
    }

    public static String B4ZgIw(Context context) {
        String property;
        String str = f2515B2KMhB;
        if (str != null && !str.isEmpty()) {
            return f2515B2KMhB;
        }
        try {
            property = WebSettings.getDefaultUserAgent(context);
        } catch (Exception unused) {
            property = System.getProperty("http.agent");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        for (int i = 0; i < length; i++) {
            char charAt = property.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                stringBuffer.append(charAt);
            }
        }
        f2515B2KMhB = property;
        return stringBuffer.toString();
    }

    public static void B7CMnp(JSONObject jSONObject, SAAllianceAdData sAAllianceAdData) {
        try {
            if (sAAllianceAdData.getDpss() != null) {
                jSONObject.put("dpss", sAAllianceAdData.getDpss());
            }
            if (sAAllianceAdData.getDpsm() != null) {
                jSONObject.put("dpsm", sAAllianceAdData.getDpsm());
            }
            if (sAAllianceAdData.getCsec() != null) {
                jSONObject.put("csec", sAAllianceAdData.getCsec());
            }
            if (sAAllianceAdData.getCsec2() != null) {
                jSONObject.put("csec2", sAAllianceAdData.getCsec2());
            }
            if (sAAllianceAdData.getDpres() != null) {
                jSONObject.put("dpRes", sAAllianceAdData.getDpres());
            }
        } catch (JSONException e) {
            e.getMessage();
            A4TApA(e);
            int i = AZOQYO.f3039AcNBzu;
        }
    }

    private static /* synthetic */ void PPvoSub() {
        char[] charArray = "jfd'nhdl'kfp'zalee'Cg`K{`mnl".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\t');
        }
        String str = new String(charArray);
        char[] charArray2 = "je`g`}".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\t');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void ADYaiT() {
        int i = 1;
        HashMap hashMap = this.f2534A2egSU;
        if (hashMap == null || hashMap.isEmpty()) {
            int i2 = AZOQYO.f3039AcNBzu;
            return;
        }
        this.f2534A2egSU.put("value", this.f2535A4TApA.toString());
        BTvldC.ADYaiT aDYaiT = new BTvldC.ADYaiT("https://jp.ad.gameley.com/stat/ikanstat/adnlog", 1, this.f2534A2egSU, false);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : this.f2534A2egSU.entrySet()) {
            if (entry.getValue() != null) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                String trim = entry.getValue().toString().trim();
                try {
                    trim = URLEncoder.encode(trim, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.getMessage();
                    A4TApA(e);
                    int i3 = AZOQYO.f3039AcNBzu;
                }
                sb.append(((String) entry.getKey()).trim());
                sb.append("=");
                sb.append(trim);
            }
        }
        try {
            if (this.f2535A4TApA.has("sdkecode")) {
                Objects.toString(this.f2535A4TApA.get("sdkecode"));
            }
            if (this.f2535A4TApA.has("errmsg")) {
                Objects.toString(this.f2535A4TApA.get("errmsg"));
            }
            AMqCpz(this.f2535A4TApA.getInt("stage"), this.f2535A4TApA.getInt("status"), this.f2535A4TApA.getInt("ecode"), this.f2534A2egSU);
            Objects.toString(this.f2534A2egSU.get("crequestid"));
            this.f2535A4TApA.getInt("stage");
            this.f2535A4TApA.getInt("status");
            this.f2535A4TApA.getInt("ecode");
            Objects.toString(this.f2534A2egSU.get("dtime"));
            this.f2534A2egSU.toString();
            int i4 = AZOQYO.f3039AcNBzu;
        } catch (JSONException e2) {
            e2.getMessage();
            A4TApA(e2);
            int i5 = AZOQYO.f3039AcNBzu;
        }
        AZkASS.f3040ADYaiT.f3041A2egSU.execute(new CtFAbx.A2egSU(i, aDYaiT));
        HashMap hashMap2 = this.f2534A2egSU;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        if (this.f2535A4TApA != null) {
            this.f2535A4TApA = null;
        }
    }

    public final void ARc23Z(int i, int i2, SAAllianceAdData sAAllianceAdData, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        if (this.f2534A2egSU == null) {
            this.f2534A2egSU = new HashMap();
        }
        if (this.f2535A4TApA == null) {
            this.f2535A4TApA = new JSONObject();
        }
        try {
            Context context = A2egSU.A5SV6n().f2499A2egSU;
            if (context == null) {
                context = null;
            }
            Context context2 = context;
            if (context2 != null && DuwtYk.AMqCpz.f2468AZOQYO == 0) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                int i3 = displayMetrics.widthPixels;
                int i4 = displayMetrics.heightPixels;
                DuwtYk.AMqCpz.f2468AZOQYO = i3;
                DuwtYk.AMqCpz.f2469AZkASS = i4;
            }
            try {
                this.f2535A4TApA.put("status", i);
                this.f2535A4TApA.put("ecode", i2);
            } catch (JSONException e) {
                e.getMessage();
                A4TApA(e);
                int i5 = AZOQYO.f3039AcNBzu;
            }
            this.f2534A2egSU.put("oaid", AlLFFp.CASmeH());
            DuwtYk.AMqCpz.f2471AcNBzu = AlLFFp.B3GDIM();
            DuwtYk.AMqCpz.f2477B3GDIM = AlLFFp.ARc23Z();
            String str7 = AlLFFp.f5889B25kr6;
            int i6 = AZOQYO.f3039AcNBzu;
            DuwtYk.AMqCpz.f2476B2KMhB = str7;
            this.f2534A2egSU.put("carrier", AlLFFp.B25kr6());
            double[] C2rE4F2 = AlLFFp.C2rE4F();
            if (C2rE4F2 != null && C2rE4F2.length >= 2) {
                this.f2534A2egSU.put("geo", C2rE4F2[0] + "," + C2rE4F2[1]);
                StringBuilder sb = new StringBuilder("");
                sb.append(C2rE4F2[0]);
                DuwtYk.AMqCpz.f2475B25kr6 = sb.toString();
                DuwtYk.AMqCpz.f2474AzWtSf = "" + C2rE4F2[1];
            }
            this.f2534A2egSU.put("connectiontype", Integer.valueOf(AlLFFp.f5892B4ZgIw));
            this.f2534A2egSU.put("ip", AlLFFp.f5890B2KMhB);
            this.f2534A2egSU.put("ipv6", AlLFFp.f5891B3GDIM);
            this.f2534A2egSU.put("imei", DuwtYk.AMqCpz.f2471AcNBzu);
            this.f2534A2egSU.put("androidid", DuwtYk.AMqCpz.f2477B3GDIM);
            this.f2534A2egSU.put("mac", DuwtYk.AMqCpz.f2476B2KMhB);
            this.f2534A2egSU.put("cookieid", DeviceUtil.AZOQYO(context2));
            this.f2534A2egSU.put("onetime", DeviceUtil.AlLFFp(context2));
            this.f2534A2egSU.put("isnew", Integer.valueOf(DeviceUtil.B25kr6(context2)));
            HashMap hashMap = this.f2534A2egSU;
            try {
                str3 = Build.MANUFACTURER;
            } catch (Exception unused) {
                str3 = "";
            }
            hashMap.put("make", str3);
            HashMap hashMap2 = this.f2534A2egSU;
            try {
                str4 = Build.BRAND;
            } catch (Exception unused2) {
                str4 = "";
            }
            hashMap2.put(bn.j, str4);
            HashMap hashMap3 = this.f2534A2egSU;
            try {
                str5 = Build.MODEL;
            } catch (Exception e2) {
                e2.printStackTrace();
                str5 = "";
            }
            hashMap3.put(bn.i, str5);
            this.f2534A2egSU.put("platform", 2);
            this.f2534A2egSU.put("os", "Android");
            HashMap hashMap4 = this.f2534A2egSU;
            try {
                str6 = Build.VERSION.RELEASE;
            } catch (Exception unused3) {
                str6 = "";
            }
            hashMap4.put("osv", str6);
            this.f2534A2egSU.put("ua", B4ZgIw(context2));
            this.f2534A2egSU.put("resolution", DeviceUtil.AmA8tU(context2));
            this.f2534A2egSU.put("ltime", f2516B3GDIM);
            this.f2534A2egSU.put("lgid", DeviceUtil.getLgid());
            this.f2534A2egSU.put("ver", DeviceUtil.ARc23Z(context2));
            this.f2534A2egSU.put("sdkver", DeviceUtil.AYUAbz());
            this.f2534A2egSU.put("gid", DeviceUtil.ASJ6gh(context2));
            this.f2534A2egSU.put("cgid", Constants.FAIL);
            this.f2534A2egSU.put("apppackage", DeviceUtil.A2egSU(context2));
            this.f2534A2egSU.put("appid", DeviceUtil.f9708A2egSU);
            this.f2534A2egSU.put("itime", str);
            this.f2534A2egSU.put("dtime", str2);
            this.f2534A2egSU.put("sysid", "5");
            this.f2534A2egSU.put("idfa", "");
            this.f2534A2egSU.put("idfastatus", Constants.FAIL);
            this.f2534A2egSU.put("birthtime", f2528BmvVmW);
            this.f2534A2egSU.put("countrycode", com.bumptech.glide.A5SV6n.ADYaiT(context2));
            this.f2534A2egSU.put("secondsfromgmt", com.bumptech.glide.A5SV6n.A4TApA());
            this.f2534A2egSU.put("hwmodel", Build.HARDWARE);
            this.f2534A2egSU.put("fulllanguage", com.bumptech.glide.A5SV6n.AmA8tU(context2));
            this.f2534A2egSU.put("adHeight", f2529BniPrB);
            this.f2534A2egSU.put("adWidth", BpkvW3);
            this.f2534A2egSU.put("count", f2530C2rE4F);
            this.f2534A2egSU.put("appstoreversion", DeviceUtil.AMqCpz(context2));
            this.f2534A2egSU.put("bootmark", A2egSU.f2497A5SV6n);
            this.f2534A2egSU.put("boottime", f2514B25kr6);
            this.f2534A2egSU.put("dpi", f2523BJ7GGh);
            this.f2534A2egSU.put("ppi", f2525BPw6Q8);
            this.f2534A2egSU.put("density", f2524BNL6CD);
            this.f2534A2egSU.put("devicename", DeviceUtil.AZkASS(context2));
            this.f2534A2egSU.put("devicetype", A2egSU(context2));
            this.f2534A2egSU.put("disk", f2519B9tovu);
            if (context2 != null) {
                try {
                    PackageInfo packageInfo = context2.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                    if (packageInfo != null) {
                        this.f2534A2egSU.put("hmsversion", packageInfo.versionName);
                    }
                } catch (PackageManager.NameNotFoundException unused4) {
                    this.f2534A2egSU.put("hmsversion", "");
                }
            }
            this.f2534A2egSU.put("installTime", f2517B4ZgIw);
            this.f2534A2egSU.put(MediaFormat.KEY_LANGUAGE, f2518B7CMnp);
            this.f2534A2egSU.put("memory", f2520BChYOn);
            this.f2534A2egSU.put("orientation", f2526BTvldC);
            this.f2534A2egSU.put("osupdatetime", f2527BV3sI0);
            this.f2534A2egSU.put("startuptime", f2513AzWtSf);
            this.f2534A2egSU.put("timezone", f2521BI9f7h);
            this.f2534A2egSU.put("updatemark", A2egSU.f2498ADYaiT);
            this.f2534A2egSU.put("hmsCoreVer", DeviceUtil.AcNBzu(context2));
            this.f2534A2egSU.put("hmsAGVerCode", DeviceUtil.AaHO0E(context2));
            this.f2534A2egSU.put("userId", (sAAllianceAdData == null || sAAllianceAdData.getUserId() == null || sAAllianceAdData.getUserId().isEmpty()) ? f2532CASmeH : sAAllianceAdData.getUserId());
        } catch (Exception e3) {
            e3.getMessage();
            A4TApA(e3);
            int i7 = AZOQYO.f3039AcNBzu;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(4:(1:(13:146|6|7|8|(1:10)|11|(1:14)|15|(1:18)|(5:20|(10:22|23|(3:133|(1:139)(1:137)|138)(1:27)|28|29|30|(9:(2:80|(6:(2:83|84)|47|48|49|(1:51)|52))(1:129)|88|(2:90|(13:103|104|(1:110)|111|(1:117)|118|(1:122)|123|47|48|49|(0)|52))(1:128)|(3:94|95|(2:97|(1:99)))|47|48|49|(0)|52)(11:33|34|(2:36|(1:40))(2:69|(1:75))|41|(1:45)|46|47|48|49|(0)|52)|130|131|67)(1:140)|53|54|55)(1:141)|56|57|59))(1:4)|56|57|59)|5|6|7|8|(0)|11|(1:14)|15|(1:18)|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0040, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0041, code lost:
    
        r18 = "004";
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038 A[Catch: Exception -> 0x0040, TryCatch #1 {Exception -> 0x0040, blocks: (B:8:0x0034, B:10:0x0038, B:11:0x0045, B:14:0x0052, B:15:0x0064, B:18:0x0075, B:20:0x0080, B:22:0x00df, B:25:0x011d, B:27:0x0123, B:28:0x013d, B:133:0x0129, B:135:0x012d, B:137:0x0133, B:138:0x013a), top: B:7:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0080 A[Catch: Exception -> 0x0040, TryCatch #1 {Exception -> 0x0040, blocks: (B:8:0x0034, B:10:0x0038, B:11:0x0045, B:14:0x0052, B:15:0x0064, B:18:0x0075, B:20:0x0080, B:22:0x00df, B:25:0x011d, B:27:0x0123, B:28:0x013d, B:133:0x0129, B:135:0x012d, B:137:0x0133, B:138:0x013a), top: B:7:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0410 A[Catch: Exception -> 0x0415, TryCatch #6 {Exception -> 0x0415, blocks: (B:49:0x0406, B:51:0x0410, B:52:0x0417, B:54:0x0420), top: B:48:0x0406 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ASJ6gh(int r20, int r21, com.alliance.ssp.ad.bean.SAAllianceAdData r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26) {
        /*
            Method dump skipped, instructions count: 1131
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: EY4UKY.ADYaiT.ASJ6gh(int, int, com.alliance.ssp.ad.bean.SAAllianceAdData, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:0|1|(1:(16:(1:70)(1:(1:74))|71|8|9|10|(1:12)|13|14|(1:17)|(3:20|(1:28)(1:26)|27)|29|(5:31|32|(3:44|(1:50)(1:48)|49)(1:36)|(3:40|(1:42)|43)|39)|51|52|53|55)(1:68))(2:4|(1:6))|7|8|9|10|(0)|13|14|(8:17|(4:20|(1:22)|28|27)|29|(0)|51|52|53|55)|17|(0)|29|(0)|51|52|53|55|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0059, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x019d, code lost:
    
        ADYaiT.CtFAbx.B4ZgIw(r0, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 005: "), new EY4UKY.ADYaiT(), "004", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[Catch: Exception -> 0x0059, TryCatch #1 {Exception -> 0x0059, blocks: (B:10:0x004d, B:12:0x0051, B:13:0x005d, B:17:0x007a, B:20:0x0093, B:22:0x0099, B:24:0x009d, B:26:0x00a3, B:27:0x00a8, B:28:0x00a6, B:29:0x00ab, B:31:0x00b2, B:34:0x0149, B:36:0x014f, B:39:0x0181, B:40:0x016d, B:42:0x0177, B:43:0x017b, B:44:0x0155, B:46:0x0159, B:48:0x015f, B:49:0x0166, B:51:0x018e), top: B:9:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2 A[Catch: Exception -> 0x0059, TRY_LEAVE, TryCatch #1 {Exception -> 0x0059, blocks: (B:10:0x004d, B:12:0x0051, B:13:0x005d, B:17:0x007a, B:20:0x0093, B:22:0x0099, B:24:0x009d, B:26:0x00a3, B:27:0x00a8, B:28:0x00a6, B:29:0x00ab, B:31:0x00b2, B:34:0x0149, B:36:0x014f, B:39:0x0181, B:40:0x016d, B:42:0x0177, B:43:0x017b, B:44:0x0155, B:46:0x0159, B:48:0x015f, B:49:0x0166, B:51:0x018e), top: B:9:0x004d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AYUAbz(int r15, int r16, com.alliance.ssp.ad.bean.SAAllianceAdData r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, DuwtYk.AMqCpz r23) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: EY4UKY.ADYaiT.AYUAbz(int, int, com.alliance.ssp.ad.bean.SAAllianceAdData, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, DuwtYk.AMqCpz):void");
    }

    public final void AZOQYO(int i, int i2, Integer num, String str, int i3) {
        long currentTimeMillis;
        long currentTimeMillis2 = System.currentTimeMillis();
        if (i == 0 && i2 == 0) {
            f2508AZkASS = currentTimeMillis2;
            currentTimeMillis = 0;
        } else {
            currentTimeMillis = System.currentTimeMillis() - f2508AZkASS;
        }
        ARc23Z(i, i2, null, String.valueOf(currentTimeMillis2), String.valueOf(currentTimeMillis));
        try {
            if (this.f2535A4TApA == null) {
                this.f2535A4TApA = new JSONObject();
            }
            this.f2535A4TApA.put("stage", 2);
            JSONObject jSONObject = new JSONObject();
            if ((i == 1 && i2 == 0) || (i == 1 && i2 == 1)) {
                if (str != null && !str.isEmpty()) {
                    jSONObject.put("applist", str);
                }
                if (num != null) {
                    jSONObject.put("pkgGetOpen", num);
                }
            } else if (i == 1 && i2 == 2) {
                jSONObject.put("responseCode", i3);
            }
            B2KMhB(jSONObject, null);
            this.f2534A2egSU.put(n.m, jSONObject.toString());
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 030: "), new ADYaiT(), "004", e);
        }
        try {
            ADYaiT();
        } catch (Exception e2) {
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 031: "), new ADYaiT(), "004", e2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:0|1|(1:3)(1:(16:42|5|6|7|(1:9)|10|(1:16)|(1:19)|20|21|22|(1:24)|26|27|28|30))|4|5|6|7|(0)|10|(2:14|16)|(1:19)|20|21|22|(0)|26|27|28|30|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x003c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        ADYaiT.CtFAbx.B4ZgIw(r0, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 001: "), new EY4UKY.ADYaiT(), "004", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[Catch: Exception -> 0x007b, TRY_LEAVE, TryCatch #2 {Exception -> 0x007b, blocks: (B:22:0x006c, B:24:0x0070), top: B:21:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034 A[Catch: Exception -> 0x003c, TryCatch #1 {Exception -> 0x003c, blocks: (B:7:0x0030, B:9:0x0034, B:10:0x003e, B:14:0x004b, B:16:0x0051, B:19:0x005c, B:20:0x0065, B:26:0x007b), top: B:6:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZkASS(int r14, int r15, java.lang.String r16, java.lang.String r17) {
        /*
            r13 = this;
            r0 = r17
            java.lang.String r7 = "004"
            java.lang.String r8 = ""
            long r1 = java.lang.System.currentTimeMillis()
            r9 = 1
            r10 = 2
            if (r15 != 0) goto L11
            EY4UKY.ADYaiT.f2507AZOQYO = r1
            goto L16
        L11:
            if (r15 == r9) goto L19
            if (r15 != r10) goto L16
            goto L19
        L16:
            r4 = 0
            goto L20
        L19:
            long r4 = java.lang.System.currentTimeMillis()
            long r11 = EY4UKY.ADYaiT.f2507AZOQYO
            long r4 = r4 - r11
        L20:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r6 = java.lang.String.valueOf(r4)
            r4 = 0
            r2 = r14
            r3 = r15
            r5 = r1
            r1 = r13
            r1.ARc23Z(r2, r3, r4, r5, r6)
            org.json.JSONObject r4 = r13.f2535A4TApA     // Catch: java.lang.Exception -> L3c
            if (r4 != 0) goto L3e
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3c
            r4.<init>()     // Catch: java.lang.Exception -> L3c
            r13.f2535A4TApA = r4     // Catch: java.lang.Exception -> L3c
            goto L3e
        L3c:
            r0 = move-exception
            goto L8e
        L3e:
            org.json.JSONObject r4 = r13.f2535A4TApA     // Catch: java.lang.Exception -> L3c
            java.lang.String r5 = "stage"
            r4.put(r5, r9)     // Catch: java.lang.Exception -> L3c
            if (r14 != 0) goto L58
            if (r15 != r10) goto L58
            if (r0 == 0) goto L58
            boolean r4 = r0.isEmpty()     // Catch: java.lang.Exception -> L3c
            if (r4 != 0) goto L58
            org.json.JSONObject r4 = r13.f2535A4TApA     // Catch: java.lang.Exception -> L3c
            java.lang.String r5 = "sdkecode"
            r4.put(r5, r0)     // Catch: java.lang.Exception -> L3c
        L58:
            if (r14 != r10) goto L65
            if (r15 != 0) goto L65
            java.util.HashMap r0 = r13.f2534A2egSU     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = "installedapplist"
            r3 = r16
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L3c
        L65:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3c
            r0.<init>()     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = "initParams"
            com.alliance.ssp.ad.api.SAAllianceAdInitParams r3 = NOd7IU.AlLFFp.f5905C2rE4F     // Catch: java.lang.Exception -> L7b
            if (r3 == 0) goto L7b
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L7b
            r3.<init>()     // Catch: java.lang.Exception -> L7b
            com.alliance.ssp.ad.api.SAAllianceAdInitParams r4 = NOd7IU.AlLFFp.f5905C2rE4F     // Catch: java.lang.Exception -> L7b
            java.lang.String r8 = r3.toJson(r4)     // Catch: java.lang.Exception -> L7b
        L7b:
            r0.put(r2, r8)     // Catch: java.lang.Exception -> L3c
            r2 = 0
            B2KMhB(r0, r2)     // Catch: java.lang.Exception -> L3c
            java.util.HashMap r2 = r13.f2534A2egSU     // Catch: java.lang.Exception -> L3c
            java.lang.String r3 = "ext"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L3c
            r2.put(r3, r0)     // Catch: java.lang.Exception -> L3c
            goto L9c
        L8e:
            EY4UKY.ADYaiT r2 = new EY4UKY.ADYaiT
            r2.<init>()
            java.lang.String r3 = "SAAllianceAdConsoleMessageManager 001: "
            java.lang.StringBuilder r3 = JrXYwF.A4TApA.AMqCpz(r3)
            ADYaiT.CtFAbx.B4ZgIw(r0, r3, r2, r7, r0)
        L9c:
            r13.ADYaiT()     // Catch: java.lang.Exception -> La0
            goto Laf
        La0:
            r0 = move-exception
            EY4UKY.ADYaiT r2 = new EY4UKY.ADYaiT
            r2.<init>()
            java.lang.String r3 = "SAAllianceAdConsoleMessageManager 002: "
            java.lang.StringBuilder r3 = JrXYwF.A4TApA.AMqCpz(r3)
            ADYaiT.CtFAbx.B4ZgIw(r0, r3, r2, r7, r0)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: EY4UKY.ADYaiT.AZkASS(int, int, java.lang.String, java.lang.String):void");
    }

    public final void AaHO0E(int i, SAAllianceAdData sAAllianceAdData, String str) {
        long currentTimeMillis;
        long currentTimeMillis2 = System.currentTimeMillis();
        if (i == 0) {
            f2511AlLFFp = currentTimeMillis2;
            currentTimeMillis = 0;
        } else {
            currentTimeMillis = System.currentTimeMillis() - f2511AlLFFp;
        }
        ARc23Z(i, 0, sAAllianceAdData, String.valueOf(currentTimeMillis2), String.valueOf(currentTimeMillis));
        try {
            if (this.f2535A4TApA == null) {
                this.f2535A4TApA = new JSONObject();
            }
            this.f2535A4TApA.put("stage", 7);
            this.f2534A2egSU.put("crequestid", str);
            JSONObject jSONObject = new JSONObject();
            if (sAAllianceAdData != null) {
                this.f2534A2egSU.put("sposprice", sAAllianceAdData.getAdtype());
                this.f2534A2egSU.put("adtesting", sAAllianceAdData.getIstesting());
                this.f2534A2egSU.put("payload", sAAllianceAdData.getPayload());
                this.f2534A2egSU.put("sposid", sAAllianceAdData.getSposid());
                this.f2534A2egSU.put("spostype", Integer.valueOf(sAAllianceAdData.getSpostype()));
                this.f2534A2egSU.put("restype", Integer.valueOf(sAAllianceAdData.getRestype()));
                this.f2534A2egSU.put("aecpm", A5SV6n(sAAllianceAdData.getPrice()));
                Material material = sAAllianceAdData.getMaterial();
                if (material != null) {
                    this.f2534A2egSU.put("ldptype", Integer.valueOf(material.getLdptype()));
                    this.f2534A2egSU.put("deeplink", material.getDeeplink());
                    this.f2534A2egSU.put("desc", material.getDesc());
                    this.f2534A2egSU.put("ldp", material.getLdp());
                    String videourl = material.getVideourl();
                    List<String> imgurl = material.getImgurl();
                    if (videourl == null || TextUtils.isEmpty(videourl)) {
                        this.f2534A2egSU.put("murl", (imgurl == null || imgurl.isEmpty()) ? "" : imgurl.get(0));
                    } else {
                        this.f2534A2egSU.put("murl", videourl);
                    }
                    this.f2534A2egSU.put("tempid", material.getTempid() != null ? material.getTempid() : "");
                } else {
                    int i2 = AZOQYO.f3039AcNBzu;
                }
                this.f2534A2egSU.put("loadtype", Integer.valueOf(sAAllianceAdData.getLoadtype()));
                B25kr6(jSONObject, sAAllianceAdData);
            } else {
                int i3 = AZOQYO.f3039AcNBzu;
            }
            B2KMhB(jSONObject, str);
            this.f2534A2egSU.put(n.m, jSONObject.toString());
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 011: "), new ADYaiT(), "004", e);
        }
        try {
            ADYaiT();
        } catch (Exception e2) {
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 012: "), new ADYaiT(), "004", e2);
        }
    }

    public final void AcNBzu(int i, SAAllianceAdData sAAllianceAdData, String str, float f, int i2, int i3, int i4) {
        ARc23Z(4, i, sAAllianceAdData, String.valueOf(System.currentTimeMillis()), String.valueOf(0L));
        try {
            if (this.f2535A4TApA == null) {
                this.f2535A4TApA = new JSONObject();
            }
            this.f2535A4TApA.put("stage", 6);
            this.f2534A2egSU.put("crequestid", str);
            JSONObject jSONObject = new JSONObject();
            if (sAAllianceAdData != null) {
                this.f2534A2egSU.put("sposid", sAAllianceAdData.getSposid());
                this.f2534A2egSU.put("spostype", Integer.valueOf(sAAllianceAdData.getSpostype()));
                this.f2534A2egSU.put("sposprice", sAAllianceAdData.getAdtype());
                this.f2534A2egSU.put("adtesting", sAAllianceAdData.getIstesting());
                this.f2534A2egSU.put("payload", sAAllianceAdData.getPayload());
                this.f2534A2egSU.put("restype", Integer.valueOf(sAAllianceAdData.getRestype()));
                this.f2534A2egSU.put("aecpm", A5SV6n(sAAllianceAdData.getPrice()));
                Material material = sAAllianceAdData.getMaterial();
                if (material != null) {
                    this.f2534A2egSU.put("ldptype", Integer.valueOf(material.getLdptype()));
                    this.f2534A2egSU.put("deeplink", material.getDeeplink());
                    this.f2534A2egSU.put("desc", material.getDesc());
                    this.f2534A2egSU.put("ldp", material.getLdp());
                    String str2 = "";
                    this.f2534A2egSU.put("tempid", material.getTempid() != null ? material.getTempid() : "");
                    String videourl = material.getVideourl();
                    List<String> imgurl = material.getImgurl();
                    if (videourl == null || TextUtils.isEmpty(videourl)) {
                        HashMap hashMap = this.f2534A2egSU;
                        if (imgurl != null && !imgurl.isEmpty()) {
                            str2 = imgurl.get(0);
                        }
                        hashMap.put("murl", str2);
                    } else {
                        this.f2534A2egSU.put("murl", videourl);
                    }
                }
                this.f2534A2egSU.put("loadtype", Integer.valueOf(sAAllianceAdData.getLoadtype()));
                B25kr6(jSONObject, sAAllianceAdData);
                jSONObject.put("bidding_ecmp", f);
                jSONObject.put("bidding_currency", i2);
                jSONObject.put("bidding_type", i3);
                if (i == 2) {
                    jSONObject.put("bidding_reason", i4);
                }
            }
            B2KMhB(jSONObject, str);
            this.f2534A2egSU.put(n.m, jSONObject.toString());
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 005: "), new ADYaiT(), "004", e);
        }
        try {
            ADYaiT();
        } catch (Exception e2) {
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 006: "), new ADYaiT(), "004", e2);
        }
    }

    public final void AlLFFp(SAAllianceAdData sAAllianceAdData, String str, String str2, String str3) {
        ARc23Z(2, 2, sAAllianceAdData, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() - f2510AcNBzu));
        try {
            if (this.f2535A4TApA == null) {
                this.f2535A4TApA = new JSONObject();
            }
            this.f2535A4TApA.put("stage", 6);
            this.f2535A4TApA.put("sdkecode", "100006");
            this.f2535A4TApA.put("errmsg", "100006-" + str2 + "-" + str3);
            this.f2534A2egSU.put("crequestid", str);
            JSONObject jSONObject = new JSONObject();
            if (sAAllianceAdData != null) {
                this.f2534A2egSU.put("sposprice", sAAllianceAdData.getAdtype());
                this.f2534A2egSU.put("adtesting", sAAllianceAdData.getIstesting());
                this.f2534A2egSU.put("payload", sAAllianceAdData.getPayload());
                this.f2534A2egSU.put("sposid", sAAllianceAdData.getSposid());
                this.f2534A2egSU.put("spostype", Integer.valueOf(sAAllianceAdData.getSpostype()));
                Material material = sAAllianceAdData.getMaterial();
                this.f2534A2egSU.put("restype", Integer.valueOf(sAAllianceAdData.getRestype()));
                this.f2534A2egSU.put("aecpm", A5SV6n(sAAllianceAdData.getPrice()));
                this.f2534A2egSU.put("ldptype", Integer.valueOf(material.getLdptype()));
                this.f2534A2egSU.put("deeplink", material.getDeeplink());
                this.f2534A2egSU.put("desc", material.getDesc());
                this.f2534A2egSU.put("ldp", material.getLdp());
                String videourl = material.getVideourl();
                List<String> imgurl = material.getImgurl();
                if (videourl == null || TextUtils.isEmpty(videourl)) {
                    this.f2534A2egSU.put("murl", (imgurl == null || imgurl.isEmpty()) ? "" : imgurl.get(0));
                } else {
                    this.f2534A2egSU.put("murl", videourl);
                }
                this.f2534A2egSU.put("tempid", material.getTempid() != null ? material.getTempid() : "");
                B25kr6(jSONObject, sAAllianceAdData);
                this.f2534A2egSU.put("loadtype", Integer.valueOf(sAAllianceAdData.getLoadtype()));
            }
            B2KMhB(jSONObject, str);
            this.f2534A2egSU.put(n.m, jSONObject.toString());
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 007: "), new ADYaiT(), "004", e);
        }
        try {
            ADYaiT();
        } catch (Exception e2) {
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 008: "), new ADYaiT(), "004", e2);
        }
    }

    public final void AmA8tU(String str, String str2, Exception exc) {
        ARc23Z(0, 0, null, String.valueOf(System.currentTimeMillis()), "");
        try {
            if (this.f2535A4TApA == null) {
                this.f2535A4TApA = new JSONObject();
            }
            this.f2535A4TApA.put("stage", 10);
            JSONObject jSONObject = new JSONObject();
            B2KMhB(jSONObject, null);
            this.f2534A2egSU.put(n.m, jSONObject.toString());
        } catch (Exception e) {
            e.getMessage();
            A4TApA(e);
            int i = AZOQYO.f3039AcNBzu;
        }
        try {
            this.f2535A4TApA.put("sdkecode", str);
            if (exc != null) {
                this.f2535A4TApA.put("errmsg", str2 + "\nstackTrace info =\n" + A4TApA(exc));
            } else {
                this.f2535A4TApA.put("errmsg", str2);
            }
            ADYaiT();
        } catch (Exception e2) {
            e2.getMessage();
            A4TApA(e2);
            int i2 = AZOQYO.f3039AcNBzu;
        }
    }

    public final void AzWtSf(String str, String str2, boolean z, SAAllianceAdData sAAllianceAdData, String str3) {
        ARc23Z(0, 0, sAAllianceAdData, String.valueOf(System.currentTimeMillis()), Constants.FAIL);
        try {
            if (this.f2535A4TApA == null) {
                this.f2535A4TApA = new JSONObject();
            }
            this.f2535A4TApA.put("stage", 11);
            this.f2535A4TApA.put("trackurl", str2);
            this.f2535A4TApA.put("event", str);
            this.f2534A2egSU.put("crequestid", str3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("track_result", z);
            if (sAAllianceAdData != null) {
                this.f2534A2egSU.put("sposprice", sAAllianceAdData.getAdtype());
                this.f2534A2egSU.put("adtesting", sAAllianceAdData.getIstesting());
                this.f2534A2egSU.put("payload", sAAllianceAdData.getPayload());
                this.f2534A2egSU.put("sposid", sAAllianceAdData.getSposid());
                this.f2534A2egSU.put("spostype", Integer.valueOf(sAAllianceAdData.getSpostype()));
                this.f2534A2egSU.put("restype", Integer.valueOf(sAAllianceAdData.getRestype()));
                this.f2534A2egSU.put("aecpm", A5SV6n(sAAllianceAdData.getPrice()));
                Material material = sAAllianceAdData.getMaterial();
                if (material != null) {
                    this.f2534A2egSU.put("ldptype", Integer.valueOf(material.getLdptype()));
                    this.f2534A2egSU.put("deeplink", material.getDeeplink());
                    this.f2534A2egSU.put("desc", material.getDesc());
                    this.f2534A2egSU.put("ldp", material.getLdp());
                    String videourl = material.getVideourl();
                    List<String> imgurl = material.getImgurl();
                    if (videourl == null || TextUtils.isEmpty(videourl)) {
                        this.f2534A2egSU.put("murl", (imgurl == null || imgurl.isEmpty()) ? "" : imgurl.get(0));
                    } else {
                        this.f2534A2egSU.put("murl", videourl);
                    }
                    this.f2534A2egSU.put("tempid", material.getTempid() != null ? material.getTempid() : "");
                } else {
                    int i = AZOQYO.f3039AcNBzu;
                }
                this.f2534A2egSU.put("loadtype", Integer.valueOf(sAAllianceAdData.getLoadtype()));
                B25kr6(jSONObject, sAAllianceAdData);
            } else {
                int i2 = AZOQYO.f3039AcNBzu;
            }
            B2KMhB(jSONObject, null);
            this.f2534A2egSU.put(n.m, jSONObject.toString());
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 011: "), new ADYaiT(), "004", e);
        }
        try {
            ADYaiT();
        } catch (Exception e2) {
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 012: "), new ADYaiT(), "004", e2);
        }
    }

    public final void B3GDIM(int i, int i2, SAAllianceAdData sAAllianceAdData, String str, String str2) {
        ASJ6gh(i, i2, sAAllianceAdData, str, str2, "", 0);
    }
}
