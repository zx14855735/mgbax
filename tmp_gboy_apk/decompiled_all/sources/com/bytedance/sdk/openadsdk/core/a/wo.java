package com.bytedance.sdk.openadsdk.core.a;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.nb;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.ss;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class wo {
    public static volatile long c = 0;
    public static volatile int f = -1;
    public static volatile int hf = 0;
    public static volatile long kd = 0;
    private static long p = -1;

    /* renamed from: pl, reason: collision with root package name */
    private static volatile boolean f10277pl;
    public static volatile String u;
    public static volatile int w;
    public static volatile int xj;
    public static volatile long y;
    private static final AtomicBoolean g = new AtomicBoolean(false);
    private static volatile String am = "";
    private static volatile String qt = null;
    private static volatile String zg = null;
    private static volatile String e = null;
    public static String d = null;
    public static String tf = null;

    /* renamed from: com.bytedance.sdk.openadsdk.core.a.wo$4, reason: invalid class name */
    public static class AnonymousClass4 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = wo.am = wo.zg(new SSWebView(com.bytedance.sdk.openadsdk.core.pz.getContext()).getUserAgentString());
                com.bytedance.sdk.openadsdk.core.w.u.xj().u("sdk_local_web_ua", wo.am);
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.a.wo$5, reason: invalid class name */
    public static class AnonymousClass5 implements FilenameFilter {
        private Pattern xj = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.xj.matcher(str).matches();
        }
    }

    static {
        nhkdS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a() {
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("tt-webua") { // from class: com.bytedance.sdk.openadsdk.core.a.wo.3
            @Override // java.lang.Runnable
            public void run() {
                wo.wo();
            }
        });
    }

    public static void ai() {
        String fh = com.bytedance.sdk.openadsdk.core.pz.hf().fh();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(fh);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (!TextUtils.isEmpty(group)) {
                    com.bytedance.sdk.openadsdk.core.ra.en.xj.add(group);
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(fh)) {
            return;
        }
        Set<String> set = com.bytedance.sdk.openadsdk.core.ra.en.xj;
        if (set.isEmpty()) {
            set.add("empty");
        }
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        JSONObject jb;
        if (wsVar == null || (jb = wsVar.jb()) == null) {
            return false;
        }
        try {
            int optInt = new JSONObject(jb.optString("compliance_data")).optJSONObject(ClickCommon.CLICK_SCENE_AD).optInt("pricing_type");
            return optInt == 3 || optInt == 6;
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.pl.u("ToolUtils", "error:" + e2.getMessage());
            return false;
        }
    }

    public static int d(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        JSONObject jb = wsVar.jb();
        if (jb != null) {
            return jb.optInt("rit", 0);
        }
        return 0;
    }

    public static String dk() {
        String BChYOn2 = CtFAbx.BChYOn("https://", yo(com.bytedance.sdk.openadsdk.core.pz.hf().v()));
        return a.hf(Uri.parse(BChYOn2).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    public static String e(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        return (wsVar.vh() == null || TextUtils.isEmpty(wsVar.vh().w())) ? !TextUtils.isEmpty(wsVar.ci()) ? wsVar.ci() : !TextUtils.isEmpty(wsVar.kr()) ? wsVar.kr() : "" : wsVar.vh().w();
    }

    public static String et() {
        return a.hf("https://applog.bytedance.net/service/2/app_log_test/");
    }

    public static int f(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        JSONObject jb = wsVar.jb();
        if (jb != null) {
            return jb.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    private static String ff() {
        String str;
        long j;
        try {
            String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("sdk_local_web_ua", "");
            if (TextUtils.isEmpty(w2)) {
                str = null;
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(w2);
                str = jSONObject.getString("value");
                j = jSONObject.getLong("time");
                am = str;
            }
            if (TextUtils.isEmpty(str)) {
                wo();
            } else if (System.currentTimeMillis() - j > 259200000 && g.compareAndSet(false, true)) {
                if (com.bytedance.sdk.openadsdk.core.u.xj.f()) {
                    new com.bytedance.sdk.openadsdk.core.u.hf("device_get_webua").xj(5).hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.wo.2
                        @Override // java.lang.Runnable
                        public void run() {
                            wo.a();
                        }
                    });
                } else {
                    a();
                }
            }
        } catch (Throwable unused) {
        }
        return am;
    }

    public static String g(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        JSONObject jb = wsVar.jb();
        return jb != null ? jb.optString("req_id", "") : "";
    }

    public static Intent hf(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33 && !launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
        return launchIntentForPackage;
    }

    public static int ht() {
        if (f >= 0) {
            return f;
        }
        int hf2 = com.bytedance.sdk.openadsdk.core.w.u.xj().hf("is_root", -1);
        f = hf2;
        return hf2;
    }

    public static String io() {
        return d() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static long jk() {
        if (c > 0) {
            return c;
        }
        long hf2 = com.bytedance.sdk.openadsdk.core.w.u.xj().hf("sdcard_storage", 0L);
        c = hf2;
        return hf2;
    }

    public static int kd(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        List<String> ci;
        com.bytedance.sdk.openadsdk.core.j.tf hf2 = com.bytedance.sdk.openadsdk.core.pz.hf();
        if (com.bytedance.sdk.openadsdk.core.f.zg().dc()) {
            com.bytedance.sdk.openadsdk.core.f.zg().c(false);
            return;
        }
        if (hf2.si() || (ci = hf2.ci()) == null) {
            return;
        }
        int my = hf2.my();
        for (int i = 0; i < my && i < ci.size(); i++) {
            Uri parse = Uri.parse(ci.get(i));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            xj(com.bytedance.sdk.openadsdk.core.pz.getContext(), intent, true);
        }
    }

    private static /* synthetic */ void nhkdS() {
        char[] charArray = "YUW\u0014][W_\u0014XUC\u0014IR_VV\u0014pTSxHS^]_".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ':');
        }
        String str = new String(charArray);
        char[] charArray2 = "YVSTSN".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ':');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String p(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        JSONObject jb = wsVar.jb();
        return jb != null ? jb.optString("customer_id", "") : "";
    }

    public static double pl(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        return w(wsVar.jb());
    }

    public static long pz() {
        try {
            if (!r()) {
                return 0L;
            }
            StatFs statFs = new StatFs(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(com.bytedance.sdk.openadsdk.core.pz.getContext(), null).getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    private static boolean r() {
        try {
            return "mounted".equals(com.bytedance.sdk.openadsdk.x.w.xj());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean ra() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String tf(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        JSONObject jb = wsVar.jb();
        return jb != null ? jb.optString("origin_req_id", "") : "";
    }

    public static boolean u() {
        return (com.bytedance.sdk.openadsdk.core.f.zg() == null || com.bytedance.sdk.openadsdk.core.f.zg().xj()) ? false : true;
    }

    public static long v() {
        if (y > 0) {
            return y;
        }
        long hf2 = com.bytedance.sdk.openadsdk.core.w.u.xj().hf("free_storage", 0L);
        y = hf2;
        return hf2;
    }

    public static boolean w(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (hf(context)) {
                try {
                    if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                        return true;
                    }
                } catch (Throwable unused) {
                    return false;
                }
            } else if (com.bytedance.sdk.openadsdk.core.pz.hf().pn()) {
                return xj(str);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wo() {
        try {
            am = zg(WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.pz.getContext()));
            com.bytedance.sdk.openadsdk.core.w.u.xj().u("sdk_local_web_ua", am);
            g.set(false);
        } catch (Throwable unused) {
        }
    }

    public static void x() {
        if (f10277pl) {
            return;
        }
        f10277pl = true;
        com.bytedance.sdk.component.p.c.xj xj2 = com.bytedance.sdk.component.p.c.xj.xj();
        xj2.xj("open_sass_live", new com.bytedance.sdk.openadsdk.core.d.xj.hf.p());
        xj2.xj("open_miniapp", new com.bytedance.sdk.openadsdk.core.d.xj.hf.pl());
        xj2.xj("open_landing_page", new com.bytedance.sdk.openadsdk.core.d.xj.hf.tf());
        xj2.xj("download", new com.bytedance.sdk.openadsdk.core.d.xj.hf.c());
        xj2.xj("open_scheme", new com.bytedance.sdk.openadsdk.core.d.xj.hf.g());
        xj2.xj("open_policy", new com.bytedance.sdk.openadsdk.core.d.xj.hf.am());
        xj2.xj("end_card", new com.bytedance.sdk.openadsdk.core.d.xj.hf.d());
        xj2.xj("common_popup", new com.bytedance.sdk.openadsdk.core.d.xj.hf.xj());
        xj2.xj("desc_popup", new com.bytedance.sdk.openadsdk.core.d.xj.hf.hf());
        xj2.xj("permission_popup", new com.bytedance.sdk.openadsdk.core.d.xj.hf.w());
        xj2.xj("privacy_popup", new com.bytedance.sdk.openadsdk.core.d.xj.hf.u());
        xj2.xj("registration_pop", new com.bytedance.sdk.openadsdk.core.d.xj.hf.kd());
        xj2.xj("dislike_popup", new com.bytedance.sdk.openadsdk.core.d.xj.hf.y());
        xj2.xj("download_popup", new com.bytedance.sdk.openadsdk.core.d.xj.hf.f());
        xj2.xj("reward_again", new com.bytedance.sdk.openadsdk.core.d.xj.hf.yo());
        xj2.xj("reward_continue", new com.bytedance.sdk.openadsdk.core.d.xj.hf.yo());
        xj2.xj("close_reward", new com.bytedance.sdk.openadsdk.core.d.xj.hf.e());
        xj2.xj("report_event", new com.bytedance.sdk.openadsdk.core.d.xj.hf.qt());
        xj2.xj("report_stats", new com.bytedance.sdk.openadsdk.core.d.xj.hf.zg());
    }

    public static boolean xj(Context context, String str) {
        Intent hf2;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (hf(context)) {
                    if (!w(context, str) || (hf2 = hf(context, str)) == null) {
                        return false;
                    }
                    hf2.putExtra("START_ONLY_FOR_ANDROID", true);
                    com.bytedance.sdk.component.utils.hf.xj(context, hf2, null);
                    return true;
                }
                Intent hf3 = hf(context, str);
                if (hf3 == null) {
                    return false;
                }
                hf3.putExtra("START_ONLY_FOR_ANDROID", true);
                context.startActivity(hf3);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean y(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        int f2 = f(wsVar);
        return f2 == 3 || f2 == 4;
    }

    public static String yo(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        return !TextUtils.isEmpty(wsVar.kr()) ? wsVar.kr() : !TextUtils.isEmpty(wsVar.uj()) ? wsVar.uj() : "";
    }

    public static String zg(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.ra.kd vh = wsVar.vh();
        String hf2 = vh != null ? vh.hf() : null;
        return TextUtils.isEmpty(hf2) ? wsVar.zg() : hf2;
    }

    public static int am(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        JSONObject jb = wsVar.jb();
        if (jb != null) {
            return jb.optInt("pricing", 0);
        }
        return 0;
    }

    public static boolean kd(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        int f2 = f(wsVar);
        return f2 == 5 || f2 == 1 || f2 == 2;
    }

    public static String pl() {
        if (!TextUtils.isEmpty(u) && !u.equals(Constants.FAIL)) {
            return u;
        }
        String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("total_memory", Constants.FAIL);
        u = w2;
        return w2;
    }

    public static int qt(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        JSONObject jb = wsVar.jb();
        if (jb != null) {
            return jb.optInt("price", 0);
        }
        return 0;
    }

    public static String ra(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return "";
        }
        String fh = wsVar.fh();
        return (!TextUtils.isEmpty(fh) || wsVar.ut() == null) ? fh : wsVar.ut().g();
    }

    public static boolean u(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar != null) {
            boolean z = f(wsVar) == 5;
            if (hl.hf(wsVar) == 7 && z) {
                return true;
            }
        }
        return false;
    }

    public static double y(String str) {
        return w(w(str));
    }

    public static String d() {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        if (com.bytedance.sdk.openadsdk.core.pz.getContext() != null) {
            try {
                e = com.bytedance.sdk.openadsdk.core.pz.getContext().getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.w("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return e;
    }

    public static String f() {
        return UUID.randomUUID().toString();
    }

    public static int kd(String str) {
        return hf(w(str));
    }

    public static int am() {
        if (xj > 0) {
            return xj;
        }
        int hf2 = com.bytedance.sdk.openadsdk.core.w.u.xj().hf("cpu_cnt", 0);
        xj = hf2;
        return hf2;
    }

    public static String f(String str) {
        return xj(str, false, 0);
    }

    public static int g() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    public static String p() {
        if (TextUtils.isEmpty(zg) && com.bytedance.sdk.openadsdk.core.pz.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.pz.getContext().getPackageManager().getPackageInfo(d(), 0);
                qt = String.valueOf(packageInfo.versionCode);
                zg = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.w("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return zg;
    }

    public static int qt() {
        if (hf > 0) {
            return hf;
        }
        int hf2 = com.bytedance.sdk.openadsdk.core.w.u.xj().hf("cpu_max_freq", 0);
        hf = hf2;
        return hf2;
    }

    public static String tf() {
        if (TextUtils.isEmpty(qt) && com.bytedance.sdk.openadsdk.core.pz.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.pz.getContext().getPackageManager().getPackageInfo(d(), 0);
                qt = String.valueOf(packageInfo.versionCode);
                zg = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.w("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return qt;
    }

    public static long u(String str) {
        return xj(w(str));
    }

    public static String y() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i = lastIndexOf + 1;
            String substring = str.substring(0, i);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(str.substring(i));
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static long g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("/([^/]+)/video/tos/cn").matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            if (TextUtils.isEmpty(group)) {
                return 0L;
            }
            try {
                long parseLong = Long.parseLong(group, 16);
                return str.contains("v3-be-pack") ? parseLong + 10800 : parseLong;
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public static boolean ht(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        return wsVar != null && TextUtils.equals(wsVar.jq(), wsVar.ho()) && wsVar.vw() == 3 && !TextUtils.isEmpty(ra(wsVar));
    }

    public static boolean jk(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null || com.bytedance.sdk.openadsdk.core.ra.v.u(wsVar)) {
            return false;
        }
        int yo = wsVar.yo();
        return yo == 5 || yo == 4;
    }

    public static long kd() {
        return p;
    }

    public static JSONObject v(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.jb();
    }

    public static String kd(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean pl(String str) {
        long g2 = g(str);
        return g2 != 0 && System.currentTimeMillis() - (g2 * 1000) > 0;
    }

    public static String u(Context context, String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, f.a.c);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.pl.xj(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        } finally {
                        }
                    }
                } while (!readLine.contains(str));
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = readLine.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    private static String v(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", tf()).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static long yo() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String c() {
        if (!TextUtils.isEmpty(am)) {
            return am;
        }
        return ff();
    }

    public static boolean hf(Context context, Intent intent, boolean z) {
        Boolean xj2;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String xj3 = x.xj(data);
        if (z && (xj2 = x.xj(xj3, 86400000L)) != null) {
            return xj2.booleanValue();
        }
        boolean hf2 = hf(context, intent);
        x.xj(xj3, Boolean.valueOf(hf2));
        return hf2;
    }

    public static boolean pz(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return true;
        }
        int c2 = com.bytedance.sdk.openadsdk.core.pz.hf().c(d(wsVar));
        if (c2 == 1) {
            return com.bytedance.sdk.component.utils.am.u(com.bytedance.sdk.openadsdk.core.pz.getContext());
        }
        if (c2 == 2) {
            return com.bytedance.sdk.component.utils.am.kd(com.bytedance.sdk.openadsdk.core.pz.getContext()) || com.bytedance.sdk.component.utils.am.u(com.bytedance.sdk.openadsdk.core.pz.getContext()) || com.bytedance.sdk.component.utils.am.y(com.bytedance.sdk.openadsdk.core.pz.getContext());
        }
        if (c2 != 3) {
            return c2 != 5 || com.bytedance.sdk.component.utils.am.u(com.bytedance.sdk.openadsdk.core.pz.getContext()) || com.bytedance.sdk.component.utils.am.y(com.bytedance.sdk.openadsdk.core.pz.getContext());
        }
        return false;
    }

    public static void w() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.wo.1
                @Override // java.lang.Runnable
                public void run() {
                    wo.l();
                }
            });
        } else {
            l();
        }
    }

    public static long e() {
        if (kd > 0) {
            return kd;
        }
        long hf2 = com.bytedance.sdk.openadsdk.core.w.u.xj().hf("internal_storage", 0L);
        kd = hf2;
        return hf2;
    }

    public static String d(String str) {
        return xj(str, false, 1);
    }

    public static boolean c(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject w(String str) {
        if (!TextUtils.isEmpty(str) && str != null && !str.isEmpty()) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.pl.xj(e2);
            }
        }
        return null;
    }

    public static JSONObject xj(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static String yo(String str) {
        if (TextUtils.isEmpty(str)) {
            tf = "empty";
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        if (!str.contains("service/2/app_log")) {
            tf = str;
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        tf = null;
        return str;
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            d = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        if (!str.contains("api-access")) {
            d = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        d = null;
        return str;
    }

    public static boolean hf() {
        try {
            PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.pz.getContext().getPackageManager().getPackageInfo(com.bytedance.sdk.openadsdk.core.pz.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int[] p(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                iArr[i] = Integer.parseInt(split[i]);
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static String tf(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static String dk(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        com.bytedance.sdk.openadsdk.core.ra.y ut;
        if (wsVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ra.kd vh = wsVar.vh();
        String u2 = vh != null ? vh.u() : null;
        if (TextUtils.isEmpty(u2) && (ut = wsVar.ut()) != null) {
            u2 = ut.g();
        }
        return TextUtils.isEmpty(u2) ? wsVar.fh() : u2;
    }

    public static boolean w(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        return wsVar != null && f(wsVar) == 9;
    }

    public static int zg() {
        if (w > 0) {
            return w;
        }
        int hf2 = com.bytedance.sdk.openadsdk.core.w.u.xj().hf("cpu_min_freq", 0);
        w = hf2;
        return hf2;
    }

    private static double w(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static boolean xj(String str) {
        boolean exists = xj(PointParamKey.DATA, str).exists();
        return !exists ? xj("media", str).exists() : exists;
    }

    public static int w(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        int i2 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int parseInt = Integer.parseInt(bufferedReader3.readLine());
                        if (parseInt > i2) {
                            i2 = parseInt;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.pl.u("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                            bufferedReader2 = bufferedReader;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader2;
                th = th4;
            }
        }
    }

    private static boolean hf(Context context, Intent intent) {
        try {
            List<ResolveInfo> xj2 = tf.xj(intent, 65536);
            if (xj2 != null) {
                if (xj2.size() > 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static File xj(String str, String str2) {
        String str3 = System.getenv("EXTERNAL_STORAGE");
        if (str3 == null) {
            str3 = "/sdcard";
        }
        return new File(str3, CtFAbx.AmA8tU("Android/", str, "/", str2));
    }

    public static Class y(int i) {
        if (i == 2) {
            return TTNativePageActivity.class;
        }
        if (i == 3) {
            return TTVideoWebPageActivity.class;
        }
        if (i != 4) {
            return TTWebPageActivity.class;
        }
        return TTVideoScrollWebPageActivity.class;
    }

    public static int hf(String str) {
        str.getClass();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "fullscreen_interstitial_ad":
                return 5;
            case "splash_ad":
            case "cache_splash_ad":
                return 4;
            case "interaction":
                return 3;
            case "draw_ad":
                return 6;
            default:
                return 1;
        }
    }

    public static String hf(int i) {
        switch (i) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return "embeded_ad";
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    public static int u(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        int i2 = 0;
        FileReader fileReader2 = null;
        BufferedReader bufferedReader3 = null;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq");
                try {
                    bufferedReader2 = new BufferedReader(fileReader);
                } catch (Throwable th2) {
                    BufferedReader bufferedReader4 = bufferedReader3;
                    th = th2;
                    fileReader2 = fileReader;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th3) {
                bufferedReader = bufferedReader3;
                th = th3;
            }
            try {
                int parseInt = Integer.parseInt(bufferedReader2.readLine());
                if (parseInt < i2 || i2 == 0) {
                    i2 = parseInt;
                }
                try {
                    bufferedReader2.close();
                    fileReader.close();
                } catch (Exception unused) {
                }
                bufferedReader3 = bufferedReader2;
                fileReader2 = fileReader;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = bufferedReader2;
                fileReader2 = fileReader;
                try {
                    com.bytedance.sdk.component.utils.pl.u("ToolUtils", th.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                            bufferedReader3 = bufferedReader;
                        }
                    }
                    bufferedReader3 = bufferedReader;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (fileReader2 != null) {
                        fileReader2.close();
                    }
                }
            }
        }
    }

    public static long w(Context context) {
        int i;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
            try {
                com.bytedance.sdk.component.utils.pl.xj("ToolUtils", "targetSdkVersion = ", Integer.valueOf(i));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i = -1;
        }
        return i;
    }

    public static String hf(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        try {
            return hf(f(wsVar));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean xj(Context context, Intent intent, boolean z) {
        if (intent == null || context == null || !hf(context)) {
            return false;
        }
        return hf(context, intent, z);
    }

    private static int hf(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static boolean xj(Context context, Intent intent) {
        if (intent == null || context == null || !hf(context)) {
            return false;
        }
        return hf(context, intent, false);
    }

    public static Map<String, Object> hf(boolean z, com.bytedance.sdk.openadsdk.core.ra.ws wsVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", wsVar.ho());
        hashMap.put("load_time", Long.valueOf(j));
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static long u(Context context) {
        int i = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i = context.getApplicationInfo().minSdkVersion;
                com.bytedance.sdk.component.utils.pl.xj("ToolUtils", "minSdkVersion = ", Integer.valueOf(i));
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static List<String> xj() {
        ArrayList arrayList = new ArrayList();
        if (com.bytedance.sdk.openadsdk.core.pz.hf().lm() && com.bytedance.sdk.openadsdk.core.f.zg().e().hf()) {
            Intent intent = new Intent("android.intent.action.MAIN");
            if (Build.VERSION.SDK_INT >= 23) {
                Iterator<ResolveInfo> it = tf.xj(intent, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT).iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null) {
                        String str = activityInfo.packageName;
                        if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean hf(android.content.Context r4) {
        /*
            if (r4 == 0) goto L3
            goto L7
        L3:
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.pz.getContext()
        L7:
            r0 = 0
            if (r4 != 0) goto L10
            java.lang.String r4 = "params context is null"
            com.bytedance.sdk.component.utils.pl.w(r4)
            return r0
        L10:
            android.content.pm.ApplicationInfo r1 = r4.getApplicationInfo()
            int r1 = r1.targetSdkVersion
            r2 = 1
            r3 = 30
            if (r1 < r3) goto L27
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r3) goto L27
            int r4 = com.bytedance.pangle.wrapper.AMqCpz.BV3sI0(r4)
            if (r4 == 0) goto L27
            r4 = 1
            goto L28
        L27:
            r4 = 0
        L28:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "can query all package = "
            r1.<init>(r3)
            r3 = r4 ^ 1
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "ToolUtils"
            com.bytedance.sdk.component.utils.pl.xj(r3, r1)
            if (r4 != 0) goto L40
            return r2
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.wo.hf(android.content.Context):boolean");
    }

    public static String hf(long j, long j2) {
        return String.valueOf(((int) (Math.abs(j2 - j) / 86400000)) + 1);
    }

    public static int xj(com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        int am2 = com.bytedance.sdk.openadsdk.core.pz.hf().am();
        if (am2 == -1) {
            try {
                ss c2 = hl.c(wsVar);
                nb y2 = hl.y(wsVar);
                if (c2 != null) {
                    String y3 = c2.y();
                    if (TextUtils.isEmpty(y3)) {
                        return 0;
                    }
                    return Integer.valueOf(y3).intValue();
                }
                if (y2 != null) {
                    String pl2 = y2.pl();
                    if (TextUtils.isEmpty(pl2)) {
                        return 0;
                    }
                    return Integer.valueOf(pl2).intValue();
                }
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.pl.u("tl", e2.getMessage());
            }
        } else if (am2 != 0 && am2 == 1) {
            return 1;
        }
        return 0;
    }

    public static int hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (hfVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(hfVar.u());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String hf(com.bytedance.sdk.openadsdk.core.ra.ws wsVar, String str) {
        ne kt;
        if (wsVar == null || (kt = wsVar.kt()) == null || kt.hf() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") != -1) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("open_method=");
        if (!com.bytedance.sdk.openadsdk.core.hf.xj.hf.u.w().xj()) {
            sb.append(2);
            return sb.toString();
        }
        sb.append(kt.y());
        return sb.toString();
    }

    public static String xj(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static void hf(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        } else if (com.bytedance.sdk.openadsdk.core.pz.hf().v(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
    }

    private static long xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public static String xj(com.bytedance.sdk.openadsdk.core.ra.ws wsVar, String str) {
        JSONObject jb = wsVar.jb();
        return jb != null ? jb.optString("rit", str) : str;
    }

    public static String xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(hfVar.pz());
            int optInt = jSONObject.optInt("cypher");
            String optString = jSONObject.optString("message");
            if (optInt == 3) {
                str = com.bytedance.sdk.component.utils.xj.w(optString);
            } else if (optInt == 4) {
                com.bytedance.sdk.component.u.xj hf2 = dk.hf();
                str = hf2 == null ? "" : hf2.decryptWithCBC(optString);
                if (str == null) {
                    str = "";
                }
            } else {
                str = null;
            }
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("creatives");
            StringBuilder sb = new StringBuilder();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString2 = ((JSONObject) optJSONArray.get(i)).optString("material_key");
                    if (i != 0) {
                        sb.append("," + optString2);
                    } else {
                        sb.append(optString2);
                    }
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, Object> xj(long j, com.bytedance.sdk.openadsdk.core.ra.ws wsVar, com.bykv.vk.openvk.component.video.api.xj xjVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j));
        if (wsVar != null) {
            if (!TextUtils.isEmpty(wsVar.ho())) {
                hashMap.put("creative_id", wsVar.ho());
            }
            com.bykv.vk.openvk.component.video.api.w.w am2 = h.am(wsVar);
            if (am2 != null) {
                hashMap.put("video_resolution", am2.d());
                hashMap.put("video_size", Long.valueOf(am2.kd()));
            }
        }
        xj(hashMap, xjVar);
        return hashMap;
    }

    public static Map<String, Object> xj(boolean z, com.bytedance.sdk.openadsdk.core.ra.ws wsVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", wsVar.ho());
        hashMap.put("load_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.w.w am2 = h.am(wsVar);
        if (am2 != null) {
            hashMap.put("video_size", Long.valueOf(am2.kd()));
            hashMap.put("video_resolution", am2.d());
            hashMap.put("video_preload_size", Long.valueOf(Build.VERSION.SDK_INT >= 23 ? am2.zg() : am2.kd()));
        }
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static Map<String, Object> xj(com.bytedance.sdk.openadsdk.core.ra.ws wsVar, long j, com.bykv.vk.openvk.component.video.api.xj xjVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", wsVar.ho());
        hashMap.put("buffers_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.w.w am2 = h.am(wsVar);
        if (am2 != null) {
            hashMap.put("video_size", Long.valueOf(am2.kd()));
            hashMap.put("video_resolution", am2.d());
        }
        xj(hashMap, xjVar);
        return hashMap;
    }

    private static void xj(Map<String, Object> map, com.bykv.vk.openvk.component.video.api.xj xjVar) {
        if (map.containsKey("video_resolution") || xjVar == null) {
            return;
        }
        try {
            map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(xjVar.p()), Integer.valueOf(xjVar.pl())));
        } catch (Throwable unused) {
        }
    }

    public static String xj(Context context) {
        Locale locale;
        LocaleList locales;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locales = context.getResources().getConfiguration().getLocales();
                locale = locales.get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.pl.u("ToolUtils", e2.toString());
            return "";
        }
    }

    public static boolean xj(boolean z, com.bytedance.sdk.openadsdk.core.ra.ws wsVar, String str) {
        if (z || wsVar == null) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.core.ra.zg yt = wsVar.yt();
            boolean z2 = yt != null && yt.w() == 2 && !yt.xj() && com.bytedance.sdk.openadsdk.core.hf.xj().get("dpl_reject_by_dialog", false);
            if (!wsVar.ta() && !z2) {
                return false;
            }
            String ol = wsVar.ol();
            if (TextUtils.isEmpty(ol) && yt != null && yt.kd() == 1 && !TextUtils.isEmpty(yt.u())) {
                ol = yt.u();
            }
            if (!TextUtils.isEmpty(ol)) {
                com.bytedance.sdk.openadsdk.core.ff.xj(ol, wsVar, str);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String xj(String str, boolean z) {
        return xj(str, z, 0);
    }

    private static String xj(String str, boolean z, int i) {
        String tf2 = i == 0 ? com.bytedance.sdk.openadsdk.core.pz.hf().tf() : e(com.bytedance.sdk.openadsdk.core.pz.hf().qt());
        String str2 = "/ad_union_qa/sdk/get_ads";
        if (com.bytedance.sdk.openadsdk.tools.hf.xj() && com.bytedance.sdk.openadsdk.core.f.zg().wa() && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            tf2 = com.bytedance.sdk.openadsdk.core.f.zg().gh();
            str = "/ad_union_qa/sdk/get_ads";
        }
        if (com.bytedance.sdk.openadsdk.core.f.zg().nb() != null && d().equals("com.pangolin_demo.toutiao") && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            tf2 = com.bytedance.sdk.openadsdk.core.f.zg().gh();
        } else {
            str2 = str;
        }
        String BI9f7h2 = CtFAbx.BI9f7h("https://", tf2, str2);
        if (a.xj()) {
            if (!z) {
                BI9f7h2 = a.hf(BI9f7h2);
            }
            String xj2 = a.xj("testIp.txt");
            if (xj2 != null) {
                BI9f7h2 = a.xj(BI9f7h2, xj2);
            }
        }
        return z ? v(BI9f7h2) : BI9f7h2;
    }

    public static boolean xj(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && xj(j) == xj(j2);
    }

    public static long xj(long j) {
        return (j + TimeZone.getDefault().getOffset(j)) / 86400000;
    }

    public static Bundle xj(int i, Bundle bundle) {
        int i2 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i3 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        float f2 = bundle.getFloat("callback_extra_key_reward_propose");
        boolean z = bundle.getBoolean("callback_extra_key_video_complete_reward");
        boolean z2 = bundle.getBoolean("callback_extra_key_is_server_verify");
        Bundle bundle2 = new Bundle();
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_CODE, i3);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_MSG, string2);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, string);
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, i2);
        bundle2.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_PROPOSE, f2);
        bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_IS_SERVER_VERIFY, z2);
        if (i == 0) {
            bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD, z);
        }
        return bundle2;
    }

    public static String xj(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            if (i < iArr.length - 1) {
                sb.append(iArr[i] + ",");
            } else {
                sb.append(iArr[i]);
            }
        }
        return sb.toString();
    }

    public static void xj(Intent intent, com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.pz.hf().ha()) {
            intent.putExtra("multi_process_materialmeta", wsVar.ac().toString());
            return;
        }
        String str = wsVar.hashCode() + wsVar.zf();
        intent.putExtra("multi_process_materialmeta_key", str);
        if (com.bytedance.sdk.component.utils.e.xj(com.bytedance.sdk.openadsdk.core.pz.getContext())) {
            com.bytedance.sdk.openadsdk.core.ht.xj(str, wsVar, com.bytedance.sdk.openadsdk.core.ra.ws.class);
        } else {
            j.xj("sp_meta").put(str, com.bytedance.sdk.component.utils.xj.hf(wsVar.ac().toString()));
        }
    }

    public static int xj(Class cls) {
        if (TTWebPageActivity.class.equals(cls)) {
            return 0;
        }
        if (TTNativePageActivity.class.equals(cls)) {
            return 2;
        }
        if (TTVideoWebPageActivity.class.equals(cls)) {
            return 3;
        }
        return TTVideoScrollWebPageActivity.class.equals(cls) ? 4 : 0;
    }

    public static void xj(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.ra.ws wsVar) {
        if (wsVar == null || map == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.pz.hf().ha()) {
            map.put("multi_process_materialmeta", wsVar.ac().toString());
            return;
        }
        String str = wsVar.hashCode() + wsVar.zf();
        map.put("multi_process_materialmeta_key", str);
        if (com.bytedance.sdk.component.utils.e.xj(com.bytedance.sdk.openadsdk.core.pz.getContext())) {
            com.bytedance.sdk.openadsdk.core.ht.xj(str, wsVar, com.bytedance.sdk.openadsdk.core.ra.ws.class);
        } else {
            j.xj("sp_meta").put(str, com.bytedance.sdk.component.utils.xj.hf(wsVar.ac().toString()));
        }
    }

    public static com.bytedance.sdk.openadsdk.core.ra.ws xj(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra)) {
                com.bytedance.sdk.openadsdk.core.ra.ws xj2 = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(stringExtra));
                if (xj2 != null) {
                    return xj2;
                }
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.pl.w("ToolUtils", "getMaterialMeta from intent failed", e2);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        com.bytedance.sdk.openadsdk.core.ra.ws wsVar = (com.bytedance.sdk.openadsdk.core.ra.ws) com.bytedance.sdk.openadsdk.core.ht.hf(stringExtra2, com.bytedance.sdk.openadsdk.core.ra.ws.class);
        if (wsVar != null) {
            return wsVar;
        }
        com.bytedance.sdk.component.u.hf.w xj3 = j.xj("sp_meta");
        String w2 = com.bytedance.sdk.component.utils.xj.w(xj3.get(stringExtra2, ""));
        try {
            if (TextUtils.isEmpty(w2)) {
                com.bytedance.sdk.component.utils.pl.u("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(w2));
        } catch (Exception e3) {
            com.bytedance.sdk.component.utils.pl.xj(e3);
            com.bytedance.sdk.component.utils.pl.w("ToolUtils", "getMaterialMeta from keva failed", e3);
            return null;
        } finally {
            xj3.remove(stringExtra2);
        }
    }

    public static boolean xj(String str, AtomicInteger atomicInteger) {
        if (TextUtils.isEmpty(str) || atomicInteger == null) {
            return true;
        }
        if (atomicInteger.get() == 1) {
            return false;
        }
        if (str.startsWith("bytedance") || str.startsWith("nativeapp")) {
            return true;
        }
        if (!str.startsWith("https:") && !str.startsWith("http:")) {
            return true;
        }
        Set<String> set = com.bytedance.sdk.openadsdk.core.ra.en.xj;
        if (set.isEmpty()) {
            ai();
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host) || set.isEmpty()) {
            return true;
        }
        for (String str2 : set) {
            if (!TextUtils.isEmpty(str2) && host.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
