package com.ss.android.downloadlib.c;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.components.core.s.t;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.config.v;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {
    private static final String xj = "f";

    private static void c(Context context, com.ss.android.downloadlib.addownload.hf.kd kdVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.xj(str, kdVar.xj);
        } catch (Exception unused) {
            com.ss.android.downloadlib.hf.xj.xj(xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
            hf(kdVar, jSONObject, 13, 10, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
        }
    }

    private static void d(Context context, com.ss.android.downloadlib.addownload.hf.kd kdVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.xj(str, kdVar.xj, BaseConstants.VIVO_MARKET_NEED_COMMENT);
        } catch (Exception unused) {
            com.ss.android.downloadlib.hf.xj.xj(xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
            hf(kdVar, jSONObject, 9, 8, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
        }
    }

    private static void f(final Context context, final com.ss.android.downloadlib.addownload.hf.kd kdVar, final String str) {
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.c.f.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
                String optString = d.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                g.xj(jSONObject2, t.TAG, com.kuaishou.weapon.p0.t.c);
                g.xj(jSONObject2, com.kuaishou.weapon.p0.t.b, str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.pl.u().xj(xj2, com.ss.android.downloadlib.addownload.pl.yo().xj(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new v() { // from class: com.ss.android.downloadlib.c.f.7.1
                    @Override // com.ss.android.download.api.config.v
                    public void xj(String str2) {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        f.hf(context, str, str2, kdVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.v
                    public void xj(Throwable th) {
                        com.ss.android.downloadlib.hf.xj.xj(f.xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
                        g.xj(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        f.hf(kdVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    private static void kd(final Context context, final com.ss.android.downloadlib.addownload.hf.kd kdVar, final String str) {
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.c.f.5
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.hf.xj.xj(f.xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
                    Thread.sleep(d.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.xj.xj.xj.xj().xj(context, true);
                    com.ss.android.downloadlib.xj.xj.hf hfVar = new com.ss.android.downloadlib.xj.xj.hf();
                    hfVar.xj = 1;
                    hfVar.hf = 0;
                    String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString(com.kuaishou.weapon.p0.t.c), d.optString("s"));
                    hfVar.w = String.format(xj2, str);
                    com.ss.android.downloadlib.xj.xj.xj.xj().xj(hfVar, (com.ss.android.downloadlib.xj.xj.u) null);
                    com.ss.android.downloadlib.xj.xj.xj.xj().hf();
                    f.hf(kdVar, jSONObject, -1, 2, String.format(xj2, str));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                    f.hf(kdVar, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static com.ss.android.downloadlib.addownload.hf.c u(Context context, String str) {
        try {
            Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hf.c(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.hf.c(6, 14);
        }
    }

    private static void w(Context context, com.ss.android.downloadlib.addownload.hf.kd kdVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.xj(context, str, kdVar.xj);
        } catch (Exception unused) {
            com.ss.android.downloadlib.hf.xj.xj(xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
            hf(kdVar, jSONObject, 14, 11, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
        }
    }

    private static void y(final Context context, final com.ss.android.downloadlib.addownload.hf.kd kdVar, final String str) {
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.c.f.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String optString = d.optString("s");
                    String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bw"), optString);
                    String xj3 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bx"), optString);
                    String xj4 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("by"), optString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(xj2).appendPath(xj3).appendQueryParameter(xj4, str);
                    com.ss.android.downloadlib.addownload.pl.u().xj(an.c, builder.build().toString(), null, new v() { // from class: com.ss.android.downloadlib.c.f.6.1
                        @Override // com.ss.android.download.api.config.v
                        public void xj(String str2) {
                            if (!TextUtils.isEmpty(str2)) {
                                String w = f.w(str2);
                                if (!TextUtils.isEmpty(w)) {
                                    String u = f.u(w);
                                    if (!TextUtils.isEmpty(u)) {
                                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                        f.hf(context, kdVar, str, u);
                                        return;
                                    }
                                }
                            }
                            com.ss.android.downloadlib.hf.xj.xj(f.xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
                            f.hf(kdVar, jSONObject, 10, 9, BaseConstants.MARKET_PREFIX + str);
                        }

                        @Override // com.ss.android.download.api.config.v
                        public void xj(Throwable th) {
                            com.ss.android.downloadlib.hf.xj.xj(f.xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
                            g.xj(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                            f.hf(kdVar, jSONObject, 11, 9, BaseConstants.MARKET_PREFIX + str);
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    f.hf(kdVar, jSONObject, 4, 9, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static com.ss.android.downloadlib.addownload.hf.c hf(Context context, com.ss.android.downloadlib.addownload.hf.kd kdVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(com.kuaishou.weapon.p0.t.b, str);
        intent.putExtra(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, kdVar.xj);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hf.c(7, "am_kllk2");
        } catch (Throwable unused) {
            hf(kdVar, jSONObject, 1, 3, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            return xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    public static com.ss.android.downloadlib.addownload.hf.c xj(Context context, Uri uri) {
        Intent intent;
        if (!com.ss.android.socialbase.appdownloader.y.kd.w() && (context == null || uri == null || !BaseConstants.SCHEME_MARKET.equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.hf.c(6, 12);
        }
        try {
            String tf = com.ss.android.socialbase.appdownloader.y.kd.tf();
            if (com.ss.android.socialbase.appdownloader.y.kd.e() && (TextUtils.isEmpty(tf) || !g.kd(context, tf))) {
                tf = "com.huawei.appmarket";
                Uri.Builder buildUpon = uri.buildUpon();
                buildUpon.scheme(BaseConstants.SCHEME_MARKET);
                intent = new Intent("android.intent.action.VIEW", buildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!g.xj(context, intent)) {
                return new com.ss.android.downloadlib.addownload.hf.c(6, 13);
            }
            if (g.kd(context, tf) && !com.ss.android.socialbase.appdownloader.y.kd.c()) {
                intent.setPackage(tf);
            }
            if (com.ss.android.socialbase.downloader.f.xj.w().xj("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            if (com.ss.android.socialbase.downloader.f.xj.w().hf("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.kd.w.xj().xj(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.hf.c(6, 25);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hf.c(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.hf.c(6, 14);
        }
    }

    public static boolean w(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String tf = com.ss.android.socialbase.appdownloader.y.kd.tf();
        if (g.kd(com.ss.android.downloadlib.addownload.pl.getContext(), tf)) {
            intent.setPackage(tf);
        }
        if (!g.xj(com.ss.android.downloadlib.addownload.pl.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "start HM2");
            return false;
        }
    }

    private static com.ss.android.downloadlib.addownload.hf.c u(Context context, com.ss.android.downloadlib.addownload.hf.kd kdVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("dl", true);
        intent.putExtra(com.kuaishou.weapon.p0.t.b, str);
        intent.putExtra(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, kdVar.xj);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO);
        } else if (g.kd(context, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
        } else if (g.kd(context, BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO);
        } else {
            return xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hf.c(7, "am_kllk3");
        } catch (Throwable unused) {
            hf(kdVar, jSONObject, 1, 3, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            return xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Context context, String str, String str2, com.ss.android.downloadlib.addownload.hf.kd kdVar, JSONObject jSONObject) {
        g.xj(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(new JSONObject(str2).optString(com.kuaishou.weapon.p0.t.f));
            if (!TextUtils.isEmpty(xj2)) {
                TTDelegateActivity.xj(str, kdVar.xj, xj2, jSONObject);
                return;
            }
            com.ss.android.downloadlib.hf.xj.xj(xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
            hf(kdVar, jSONObject, 5, 5, BaseConstants.MARKET_PREFIX + str);
        } catch (Exception unused) {
            com.ss.android.downloadlib.hf.xj.xj(xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
            hf(kdVar, jSONObject, 6, 5, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
        }
    }

    public static boolean w(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w(String str) {
        String str2;
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        if (matcher.find()) {
            str2 = matcher.group();
        } else {
            str2 = "";
        }
        if (!str2.equals(null) && str2.length() > 0) {
            for (String str3 : str2.split("\\n")) {
                if (str3.startsWith("<input")) {
                    for (String str4 : str3.split("\\s")) {
                        if (str4.startsWith("value")) {
                            return CtFAbx.AMqCpz(1, 7, str4);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static com.ss.android.downloadlib.addownload.hf.c xj(final Context context, Uri uri, com.ss.android.downloadlib.addownload.hf.kd kdVar) {
        com.ss.android.downloadad.api.xj.hf hfVar;
        if (context != null && com.ss.android.downloadlib.hf.tf.xj(uri)) {
            try {
                final Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!g.xj(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.hf.c(6, 13);
                }
                String tf = com.ss.android.socialbase.appdownloader.y.kd.tf();
                if (g.kd(context, tf)) {
                    intent.setPackage(tf);
                }
                intent.addFlags(335544320);
                if (com.ss.android.socialbase.downloader.f.xj.w().hf("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.pl.tf().w)) {
                    com.ss.android.downloadlib.kd.w.xj().xj(false, "jump market error");
                    return new com.ss.android.downloadlib.addownload.hf.c(6, 25);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                long optLong = com.ss.android.downloadlib.addownload.pl.d().optLong("market_jump_delay", 1000L);
                if (optLong > 0 && kdVar != null && (hfVar = kdVar.kd) != null && !hfVar.op()) {
                    com.ss.android.downloadlib.f.xj().hf().post(new Runnable() { // from class: com.ss.android.downloadlib.c.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.pl.w().xj(8, com.ss.android.downloadlib.addownload.pl.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                        }
                    });
                }
                com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.c.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        context.startActivity(intent);
                    }
                }, optLong);
                return new com.ss.android.downloadlib.addownload.hf.c(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.hf.c(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.hf.c(6, 12);
    }

    public static boolean hf(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String tf = com.ss.android.socialbase.appdownloader.y.kd.tf();
        if (g.kd(com.ss.android.downloadlib.addownload.pl.getContext(), tf)) {
            intent.setPackage(tf);
        }
        if (!g.xj(com.ss.android.downloadlib.addownload.pl.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "start HM1");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return (String) A2egSU.AlLFFp(pathSegments, 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(com.ss.android.downloadlib.addownload.hf.kd kdVar, JSONObject jSONObject, int i, int i2, String str) {
        g.xj(jSONObject, "error_code", Integer.valueOf(i));
        g.xj(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        g.xj(jSONObject, "rmu", str);
        g.xj(jSONObject, com.ss.android.socialbase.appdownloader.y.kd.tf(), Integer.valueOf(g.hf(com.ss.android.downloadlib.addownload.pl.getContext(), com.ss.android.socialbase.appdownloader.y.kd.tf())));
        com.ss.android.downloadlib.u.xj.xj().hf("am_result", jSONObject, kdVar);
    }

    public static com.ss.android.downloadlib.addownload.hf.c hf(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.hf.c(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.pl.getContext();
        }
        Intent c = g.c(context, str);
        if (c == null) {
            return new com.ss.android.downloadlib.addownload.hf.c(4, 22);
        }
        c.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(c);
            return new com.ss.android.downloadlib.addownload.hf.c(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.hf.c(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.hf.c xj(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.y.kd.c() && g.kd(context, "com.sec.android.app.samsungapps")) {
                return u(context, str);
            }
            return xj(context, com.ss.android.download.api.w.xj.xj(context, str));
        }
        return new com.ss.android.downloadlib.addownload.hf.c(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.hf.c xj(Context context, com.ss.android.downloadlib.addownload.hf.kd kdVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.y.kd.c() && g.kd(context, "com.sec.android.app.samsungapps")) {
                return u(context, str);
            }
            if (kdVar.hf.isAd() && kdVar.u.enableAM()) {
                JSONArray optJSONArray = com.ss.android.downloadlib.addownload.pl.d().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.y.kd.kd() && com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONArray, "am_3")) {
                    return hf(context, kdVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.y.kd.y() && com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONArray, "am_2")) {
                    kd(context, kdVar, str);
                    return new com.ss.android.downloadlib.addownload.hf.c(7, "am_m2");
                }
                if (com.ss.android.socialbase.appdownloader.y.kd.u() && com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONArray, "am_5")) {
                    f(context, kdVar, str);
                    return new com.ss.android.downloadlib.addownload.hf.c(7, "am_v1");
                }
                if (com.ss.android.socialbase.appdownloader.y.kd.kd() && com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONArray, "am_7")) {
                    DownloadController downloadController = kdVar.u;
                    if ((downloadController instanceof AdDownloadController) && ((AdDownloadController) downloadController).enableOppoAutoDownload()) {
                        return u(context, kdVar, str);
                    }
                }
                if (com.ss.android.socialbase.appdownloader.y.kd.u() && com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONArray, "am_8") && g.xj(g.w(context, "com.bbk.appstore"), BaseConstants.VIVO_V2_REQUIRED_MARKET_VERSION) >= 0) {
                    d(context, kdVar, str);
                    return new com.ss.android.downloadlib.addownload.hf.c(7, "am_v2");
                }
                if ((com.ss.android.socialbase.appdownloader.y.kd.xj() || com.ss.android.socialbase.appdownloader.y.kd.hf()) && com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONArray, "am_9")) {
                    y(context, kdVar, str);
                    return new com.ss.android.downloadlib.addownload.hf.c(7, "am_hr");
                }
                if ((com.ss.android.socialbase.appdownloader.y.kd.xj() || com.ss.android.socialbase.appdownloader.y.kd.hf()) && com.ss.android.socialbase.appdownloader.y.xj.xj(optJSONArray, "am_10")) {
                    c(context, kdVar, str);
                    return new com.ss.android.downloadlib.addownload.hf.c(7, "am_hr2");
                }
                DownloadController downloadController2 = kdVar.u;
                if ((downloadController2 instanceof AdDownloadController) && ((AdDownloadController) downloadController2).enableOppoAutoDownload() && ((AdDownloadController) kdVar.u).getDownloadMarketInterceptor() != null && kdVar.hf.getDownloadSettings().optInt("is_use_obm_convert", 0) == 1) {
                    w(context, kdVar, str);
                    return new com.ss.android.downloadlib.addownload.hf.c(7, "am_kllk4");
                }
                return xj(context, com.ss.android.download.api.w.xj.xj(context, str));
            }
            return xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        return new com.ss.android.downloadlib.addownload.hf.c(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.hf.c hf(String str, com.ss.android.downloadad.api.xj.xj xjVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.hf.c(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.pl.getContext();
        String packageName = xjVar.pz().getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            pl.xj().xj(xj, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            Intent xj2 = xj(context, xjVar, packageName, 2, str);
            if (xj2 != null) {
                com.ss.android.downloadlib.addownload.hf.c xj3 = xj(context, xj2, xjVar, true, str);
                if (xj3.getType() == 1) {
                    return xj3;
                }
            }
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (com.ss.android.socialbase.downloader.f.xj.w().xj("fix_app_link_flag")) {
            intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
        }
        return xj(context, intent, xjVar, false, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Context context, com.ss.android.downloadlib.addownload.hf.kd kdVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.hf(str, kdVar.xj, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.hf.xj.xj(xj(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kdVar, true);
            hf(kdVar, jSONObject, 12, 9, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
        }
    }

    public static void hf(Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
        String optString = d.optString("s");
        String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bz"), optString);
        String xj3 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("ca"), optString);
        String xj4 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("cb"), optString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.MARKET_SCHEME_HW_HONOR).authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(xj2)) {
            builder.appendQueryParameter(xj2, str2);
        }
        if (!TextUtils.isEmpty(xj3) && !TextUtils.isEmpty(xj4)) {
            builder.appendQueryParameter(xj3, xj4);
        }
        if (hf(activity, builder.build())) {
            hf(kd, jSONObject, -1, 9, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            com.ss.android.downloadlib.hf.xj.xj("am_hr", jSONObject, kd, true);
        } else {
            hf(kd, jSONObject, 2, 9, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            com.ss.android.downloadlib.hf.xj.xj(xj((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
        }
    }

    public static boolean xj(Context context, com.ss.android.downloadlib.addownload.hf.kd kdVar, String str, JSONObject jSONObject, boolean z, int i) {
        g.xj(jSONObject, "download_scene", Integer.valueOf(kdVar.jk()));
        com.ss.android.downloadlib.u.xj.xj().hf("market_click_open", jSONObject, kdVar);
        com.ss.android.downloadlib.addownload.hf.c xj2 = xj(context, Uri.parse(str));
        String xj3 = g.xj(xj2.hf(), PointCategory.OPEN_MARKET);
        int type = xj2.getType();
        if (type == 5) {
            com.ss.android.downloadlib.hf.xj.xj(xj3, jSONObject, kdVar, true);
        } else {
            if (type == 6) {
                g.xj(jSONObject, "error_code", Integer.valueOf(xj2.xj()));
                g.xj(jSONObject, "download_scene", Integer.valueOf(kdVar.jk()));
                com.ss.android.downloadlib.u.xj.xj().hf("market_open_failed", jSONObject, kdVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        if (z) {
            com.ss.android.downloadlib.u.xj.xj().xj(kdVar.xj, i);
        }
        return true;
    }

    public static void xj(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        try {
            JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
            String optString = d.optString("s");
            String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("aa"), optString);
            String xj3 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("ac"), optString);
            String xj4 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("af"), optString);
            boolean xj5 = com.ss.android.socialbase.appdownloader.y.xj.xj(d, context, xj3);
            StringBuilder sb = new StringBuilder(String.format(xj2, str, xj4, xj3));
            Intent intent = new Intent("android.intent.action.VIEW");
            String tf = com.ss.android.socialbase.appdownloader.y.kd.tf();
            if (g.kd(context, tf)) {
                intent.setPackage(tf);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            g.xj(jSONObject, "mf", Boolean.valueOf(xj5));
            g.xj(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.ss.android.downloadlib.hf.xj.xj("am_kllk2", jSONObject, kd, true);
            if (xj5) {
                hf(kd, jSONObject, -1, 3, sb.toString());
            } else {
                hf(kd, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.hf.xj.xj(xj(com.ss.android.downloadlib.addownload.pl.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
            hf(kd, jSONObject, 2, 3, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
        }
    }

    public static void hf(Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        JSONObject jSONObject = new JSONObject();
        DownloadController downloadController = kd.u;
        if (downloadController instanceof AdDownloadController) {
            boolean enableOppoAutoDownload = ((AdDownloadController) downloadController).enableOppoAutoDownload();
            HashMap hashMap = new HashMap();
            hashMap.put("is_button", Boolean.valueOf(enableOppoAutoDownload));
            g.xj(jSONObject, "is_button", Boolean.valueOf(enableOppoAutoDownload));
            DownloadMarketInterceptor downloadMarketInterceptor = ((AdDownloadController) kd.u).getDownloadMarketInterceptor();
            if (downloadMarketInterceptor != null) {
                Map<String, Object> interceptObmMarket = downloadMarketInterceptor.interceptObmMarket(hashMap);
                if (interceptObmMarket != null && interceptObmMarket.get("convert_result") != null && Boolean.parseBoolean(interceptObmMarket.get("convert_result").toString())) {
                    hf(kd, jSONObject, -1, 11, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
                    com.ss.android.downloadlib.hf.xj.xj("am_kllk4", jSONObject, kd, true);
                    return;
                } else {
                    hf(kd, jSONObject, 15, 11, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
                    com.ss.android.downloadlib.hf.xj.xj(xj((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
                    return;
                }
            }
            hf(kd, jSONObject, 15, 11, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            com.ss.android.downloadlib.hf.xj.xj(xj((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
            return;
        }
        hf(kd, jSONObject, 15, 11, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
        com.ss.android.downloadlib.hf.xj.xj(xj((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
    }

    public static void xj(final Context context, String str, long j, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        try {
            JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
            String optString = d.optString("s");
            String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("br"), optString);
            String xj3 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bs_1"), optString);
            String xj4 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bs_2"), optString);
            String xj5 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bs_3"), optString);
            String xj6 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bt"), optString);
            String xj7 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bu"), optString);
            StringBuilder sb = new StringBuilder("https://");
            sb.append(xj2);
            sb.append(xj3);
            sb.append(xj4);
            sb.append(xj5);
            sb.append(xj6);
            sb.append(xj7);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            g.xj(jSONObject, "dl", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            long optLong = com.ss.android.downloadlib.addownload.pl.d().optLong("oppo_browser_jump_delay", 1000L);
            if (optLong > 0) {
                com.ss.android.downloadlib.f.xj().hf().post(new Runnable() { // from class: com.ss.android.downloadlib.c.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.pl.w().xj(12, com.ss.android.downloadlib.addownload.pl.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.c.f.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, optLong);
            com.ss.android.downloadad.api.xj.hf hfVar = kd.kd;
            if (hfVar != null) {
                hfVar.ht(true);
            }
            com.ss.android.downloadlib.hf.xj.xj("am_kllk3", jSONObject, kd, true);
            hf(kd, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            com.ss.android.downloadad.api.xj.hf hfVar2 = kd.kd;
            if (hfVar2 != null) {
                hfVar2.ht(false);
            }
            com.ss.android.downloadlib.hf.xj.xj(xj(com.ss.android.downloadlib.addownload.pl.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str), kd), kd, true);
            hf(kd, jSONObject, 2, 7, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static boolean xj(Activity activity, String str, HashMap<String, String> hashMap) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra("param", hashMap);
        String tf = com.ss.android.socialbase.appdownloader.y.kd.tf();
        if (g.kd(com.ss.android.downloadlib.addownload.pl.getContext(), tf)) {
            intent.setPackage(tf);
        }
        if (!g.xj(com.ss.android.downloadlib.addownload.pl.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "start v1");
            return false;
        }
    }

    public static void xj(Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        try {
            JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
            boolean xj2 = com.ss.android.socialbase.appdownloader.y.xj.xj(d, activity, com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bg"), d.optString("s")));
            HashMap<String, String> hf = g.hf(new JSONObject(str2));
            if (!xj2 || hf.isEmpty() || !xj(activity, str, hf)) {
                if (xj2) {
                    i = hf.isEmpty() ? 1 : 2;
                } else {
                    i = 3;
                }
                hf(kd, jSONObject, i, 5, BaseConstants.MARKET_PREFIX + str);
                com.ss.android.downloadlib.hf.xj.xj(xj((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
                return;
            }
            hf(kd, jSONObject, -1, 5, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.hf.xj.xj("am_v1", jSONObject, kd, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.hf.xj.xj(xj(com.ss.android.downloadlib.addownload.pl.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
            hf(kd, jSONObject, 4, 5, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
        }
    }

    public static void xj(Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
        String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("bv"), d.optString("s"));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.SCHEME_MARKET).authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, str);
        if (!TextUtils.isEmpty(xj2)) {
            builder.appendQueryParameter(xj2, str2);
        }
        if (xj(activity, builder.build())) {
            hf(kd, jSONObject, -1, 8, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            com.ss.android.downloadlib.hf.xj.xj("am_v2", jSONObject, kd, true);
        } else {
            hf(kd, jSONObject, 2, 8, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            com.ss.android.downloadlib.hf.xj.xj(xj((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
        }
    }

    public static boolean xj(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String tf = com.ss.android.socialbase.appdownloader.y.kd.tf();
        if (g.kd(com.ss.android.downloadlib.addownload.pl.getContext(), tf)) {
            intent.setPackage(tf);
        }
        if (!g.xj(com.ss.android.downloadlib.addownload.pl.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "start v2");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.hf.c xj(Context context, String str, com.ss.android.downloadad.api.xj.xj xjVar) {
        Intent xj2 = xj(context, xjVar, str, 1, (String) null);
        if (xj2 != null) {
            pl.xj().xj(xj, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.ss.android.downloadlib.addownload.hf.c xj3 = xj(xj2, true, context, str, xjVar);
            if (xj3.getType() == 3) {
                return xj3;
            }
        }
        Intent c = g.c(context, str);
        if (c == null) {
            return new com.ss.android.downloadlib.addownload.hf.c(4, 22);
        }
        return xj(c, false, context, str, xjVar);
    }

    private static com.ss.android.downloadlib.addownload.hf.c xj(Intent intent, boolean z, Context context, String str, com.ss.android.downloadad.api.xj.xj xjVar) {
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.pl.d().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.pl.pl() != null && com.ss.android.downloadlib.addownload.pl.pl().xj() && xjVar.e() && !z) {
            TTDelegateActivity.hf(str, xjVar);
            return new com.ss.android.downloadlib.addownload.hf.c(3);
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.hf.c(3);
        } catch (Exception e) {
            if (z) {
                pl.xj().hf(xj, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.hf.c(8, 23);
            }
            pl.xj().hf(xj, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e.getMessage());
            return new com.ss.android.downloadlib.addownload.hf.c(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.hf.c xj(String str, com.ss.android.downloadad.api.xj.xj xjVar) {
        return xj(com.ss.android.downloadlib.addownload.pl.getContext(), str, xjVar);
    }

    private static com.ss.android.downloadlib.addownload.hf.c xj(Context context, Intent intent, com.ss.android.downloadad.api.xj.xj xjVar, boolean z, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.pl.getContext();
        }
        if (g.hf(context, intent)) {
            if (com.ss.android.downloadlib.addownload.pl.d().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.pl.pl() != null && com.ss.android.downloadlib.addownload.pl.pl().xj() && Build.VERSION.SDK_INT >= 26 && xjVar.e() && !z) {
                TTDelegateActivity.xj(str, xjVar);
                return new com.ss.android.downloadlib.addownload.hf.c(1);
            }
            try {
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.hf.c(1);
            } catch (Exception e) {
                if (z) {
                    pl.xj().hf(xj, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e.getMessage());
                    return new com.ss.android.downloadlib.addownload.hf.c(9);
                }
                pl.xj().hf(xj, "realTryOpenByUrl", "url调起失败了，抛出异常" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.hf.c(2);
            }
        }
        return new com.ss.android.downloadlib.addownload.hf.c(2, 24);
    }

    public static com.ss.android.downloadlib.addownload.hf.c xj(com.ss.android.downloadad.api.xj.hf hfVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.hf.c hf = hf(str, hfVar);
        return (com.ss.android.downloadlib.hf.y.xj(hfVar) && hf.getType() == 2) ? xj(str2, hfVar) : hf;
    }

    public static void xj(Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.hf.kd kd = com.ss.android.downloadlib.addownload.hf.y.xj().kd(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject d = com.ss.android.downloadlib.addownload.pl.d();
        String optString = d.optString("s");
        String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("ca"), optString);
        String xj3 = com.ss.android.socialbase.appdownloader.y.w.xj(d.optString("cc"), optString);
        StringBuilder sb = new StringBuilder(BaseConstants.MARKET_PREFIX);
        if (!TextUtils.isEmpty(xj2) && !TextUtils.isEmpty(xj3)) {
            com.bykv.vk.component.ttvideo.player.A2egSU.BIYEnU(sb, str, "&", xj2, "=");
            sb.append(xj3);
        }
        if (w(activity, Uri.parse(sb.toString()))) {
            hf(kd, jSONObject, -1, 10, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            com.ss.android.downloadlib.hf.xj.xj("am_hr2", jSONObject, kd, true);
        } else {
            hf(kd, jSONObject, 2, 10, CtFAbx.BChYOn(BaseConstants.MARKET_PREFIX, str));
            com.ss.android.downloadlib.hf.xj.xj(xj((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), kd, true);
        }
    }

    private static Intent xj(Context context, com.ss.android.downloadad.api.xj.xj xjVar, String str, int i, String str2) {
        if (!xjVar.w() || xjVar.ra() == null || xjVar.ra().getDownloadMode() != 2 || xjVar.pz() == null || kd.xj(xjVar).xj("app_link_market_open_add_info", 0) != 1) {
            return null;
        }
        String w = com.ss.android.downloadlib.addownload.d.w(xjVar.pz());
        String u = com.ss.android.downloadlib.addownload.d.u(xjVar.pz());
        Intent intent = new Intent();
        intent.setClassName(str, AdBaseConstants.MARKET_OPEN_BRIDGE_ACTIVITY);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (TextUtils.isEmpty(w) || resolveActivity == null) {
            return null;
        }
        intent.putExtra(AdBaseConstants.MARKET_OPEN_CLICK_ID, w);
        if (!(context instanceof Activity)) {
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
        }
        if (!TextUtils.isEmpty(u)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA, u);
        }
        if (i == 2 && !TextUtils.isEmpty(str2)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str2);
        }
        return intent;
    }
}
