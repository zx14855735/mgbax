package GGG1xW;

import ADYaiT.CtFAbx;
import ADYaiT.D8MqeW;
import EY4UKY.ADYaiT;
import GJee0v.AZOQYO;
import GJee0v.AZkASS;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.alliance.ssp.ad.manager.applist.bean.InitConfigBean;
import com.alliance.ssp.ad.utils.DeviceUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final C0000A2egSU f2985ASJ6gh = new C0000A2egSU();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static String f2986AYUAbz = "";

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final A2egSU f2987AZOQYO = new A2egSU();

    /* renamed from: A2egSU, reason: collision with root package name */
    public SharedPreferences f2988A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public SharedPreferences.Editor f2989A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Context f2990A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public InitConfigBean f2991ADYaiT;
    public boolean AMqCpz = false;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f2992ARc23Z = false;

    /* renamed from: GGG1xW.A2egSU$A2egSU, reason: collision with other inner class name */
    public class C0000A2egSU extends ArrayList {
        public C0000A2egSU() {
            add("com.sankuai.meituan");
            add("com.xunmeng.pinduoduo");
            add("com.sankuai.meituan.takeoutnew");
            add("com.jingdong.app.mall");
            add("com.smile.gifmaker");
            add("com.kuaishou.nebula");
            add("com.eg.android.AlipayGphone");
            add("com.ss.android.ugc.aweme.lite");
            add("com.ss.android.ugc.aweme");
            add("com.taobao.taobao");
            add("com.jd.jrapp");
            add("com.baidu.searchbox");
            add("com.xingin.xhs");
            add("ctrip.android.view");
        }
    }

    static {
        UBCCZL();
    }

    public static String A4TApA(String str) {
        if (!ADYaiT(str)) {
            return "";
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return decode == null ? "" : new String(decode, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static void A5SV6n(Exception exc) {
        CtFAbx.B4ZgIw(exc, new StringBuilder("NMNativeFeedAdImpl 001"), new ADYaiT(), "004", exc);
    }

    public static boolean ADYaiT(String... strArr) {
        for (String str : strArr) {
            if (str == null || str.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean AMqCpz(List... listArr) {
        for (List list : listArr) {
            if (list == null || list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static String ARc23Z(String str) {
        if (!ADYaiT(str)) {
            return "";
        }
        try {
            byte[] encode = Base64.encode(str.getBytes("UTF-8"), 0);
            return encode == null ? "" : new String(encode, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    private static /* synthetic */ void UBCCZL() {
        char[] charArray = "\u000f\u0003\u0001B\u000b\r\u0001\tB\u000e\u0003\u0015B\u001f\u0004\t\u0000\u0000B&\u0002\u0005.\u001e\u0005\b\u000b\t".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'l');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000f\u0000\u0005\u0002\u0005\u0018".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'l');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String A2egSU() {
        SharedPreferences sharedPreferences;
        if (this.f2990A5SV6n == null) {
            int i = AZOQYO.f3039AcNBzu;
            return "";
        }
        if (this.f2992ARc23Z && this.f2991ADYaiT != null) {
            this.f2992ARc23Z = false;
            AZkASS.f3040ADYaiT.f3041A2egSU.execute(new D8MqeW(13, this));
        } else if (!ADYaiT(f2986AYUAbz) && (sharedPreferences = this.f2988A2egSU) != null) {
            f2986AYUAbz = A4TApA(sharedPreferences.getString("yt_sdk_2_intersection_list", ""));
        }
        return f2986AYUAbz;
    }

    public final void ASJ6gh(String str) {
        long j = this.f2988A2egSU.getLong("yt_sdk_2_last_report_list_time", 0L);
        if (j > 0 && DeviceUtil.ADYaiT(j)) {
            int i = AZOQYO.f3039AcNBzu;
        } else if (ADYaiT(str)) {
            int i2 = AZOQYO.f3039AcNBzu;
            new ADYaiT().AZkASS(2, 0, str, null);
            this.f2989A4TApA.putLong("yt_sdk_2_last_report_list_time", System.currentTimeMillis());
            this.f2989A4TApA.apply();
        }
    }
}
