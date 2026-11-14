package com.bytedance.sdk.openadsdk.core.ra;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.component.hf.xj.d;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class en {
    private static final Set<String> c;
    private static final Set<String> d;
    private static final Set<String> f;
    private static final Set<String> kd;
    private static final Map<String, String> p;

    /* renamed from: pl, reason: collision with root package name */
    private static volatile boolean f10401pl;
    private static boolean tf;
    public static final Set<String> xj;
    private static final Set<String> y;
    private int hf;
    private static final Set<String> w = new HashSet();
    private static final Set<String> u = new CopyOnWriteArraySet();

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        kd = copyOnWriteArraySet;
        y = new CopyOnWriteArraySet();
        c = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        f = copyOnWriteArraySet2;
        d = new CopyOnWriteArraySet();
        tf = false;
        p = new HashMap();
        xj = new CopyOnWriteArraySet();
        f10401pl = false;
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
        ZydYEJC();
    }

    public en(JSONObject jSONObject) {
        this.hf = jSONObject.optInt("block_auto_open");
    }

    private static /* synthetic */ void ZydYEJC() {
        char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'k');
        }
        String str = new String(charArray);
        char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'k');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                u.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        u.add(optString);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                kd.clear();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String optString2 = optJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(optString2)) {
                        kd.add(optString2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray optJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                y.clear();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    String optString3 = optJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(optString3)) {
                        y.add(optString3);
                    }
                }
            }
        } catch (Exception unused3) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                JSONArray optJSONArray4 = optJSONObject.optJSONArray("url_report_rule_list");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    c.clear();
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        String optString4 = optJSONArray4.optString(i4);
                        if (!TextUtils.isEmpty(optString4)) {
                            c.add(optString4);
                        }
                    }
                }
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("net_url_block_list");
                if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                    f.clear();
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        String optString5 = optJSONArray5.optString(i5);
                        if (!TextUtils.isEmpty(optString5)) {
                            f.add(optString5);
                        }
                    }
                }
                JSONArray optJSONArray6 = optJSONObject.optJSONArray("dialog_black_list");
                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                    d.clear();
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        String optString6 = optJSONArray6.optString(i6);
                        if (!TextUtils.isEmpty(optString6)) {
                            d.add(optString6);
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
        tf = true;
    }

    public void xj(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.hf);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static void xj(com.bytedance.sdk.component.u.hf.w wVar) {
        wVar.put("turn_up_white_list", u);
        wVar.put("turn_up_black_list_1", kd);
        wVar.put("turn_up_black_list_2", y);
        wVar.put("url_report_rule_list", c);
        wVar.put("net_url_block_list", f);
        wVar.put("_turn_up_is_get_list", tf);
        wVar.put("dialog_black_list", d);
    }

    public static int xj(ws wsVar) {
        en xx;
        if (wsVar == null || (xx = wsVar.xx()) == null) {
            return 0;
        }
        return xx.hf;
    }

    public static boolean xj(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.j jVar, String str, boolean z, boolean z2) {
        if (!str.startsWith("bytedance") && !str.startsWith("nativeapp") && !str.startsWith("bds")) {
            if (!com.bytedance.sdk.openadsdk.core.a.wo.xj(str, atomicInteger) && xj(webView, atomicInteger, str, true)) {
                return true;
            }
            if (jVar == null || !TextUtils.isEmpty(hf(str, w)) || !TextUtils.isEmpty(hf(str, u))) {
                return false;
            }
            String hf = hf(str, c);
            if (!TextUtils.isEmpty(hf)) {
                hf(jVar.f(), str, hf);
            }
            String xj2 = xj(str, jVar.kd(z2), z, z2);
            if (!TextUtils.isEmpty(xj2) && tf) {
                xj(jVar.f(), str, xj2);
            }
            if (!TextUtils.isEmpty(xj2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean xj(WebView webView, AtomicInteger atomicInteger, String str, boolean z) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = p;
            if (map.containsKey(path)) {
                return xj(atomicInteger, map.get(path), str, webView, z);
            }
            if (!f10401pl) {
                for (String str2 : com.bytedance.sdk.openadsdk.core.a.j.xj("cloud_path_check_res").get("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split = str2.split(",");
                        p.put(split[0], split[1]);
                    }
                }
                Map<String, String> map2 = p;
                if (map2.containsKey(path)) {
                    return xj(atomicInteger, map2.get(path), str, webView, z);
                }
            }
            com.bytedance.sdk.component.d.hf.kd hf = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
            hf.xj(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter("aid", "1181").appendQueryParameter("device_platform", "android").appendQueryParameter("device_id", com.bytedance.sdk.openadsdk.core.yo.w()).appendQueryParameter("scc_mode", "raw").appendQueryParameter("scc_from", "App").toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("scene", "common");
            jSONObject.put("url", str);
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, "");
            hf.xj(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            hf.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.en.1
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                    try {
                        strArr[0] = new JSONObject(hfVar.u()).optJSONObject(PointParamKey.DATA).optString("label");
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(strArr[0])) {
                        return;
                    }
                    if (en.p.size() > 1000) {
                        Iterator it = en.p.entrySet().iterator();
                        for (int i = 0; i < 200; i++) {
                            it.next();
                            it.remove();
                        }
                    }
                    en.p.put(path, strArr[0]);
                    if (!en.f10401pl) {
                        boolean unused2 = en.f10401pl = true;
                        com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ra.en.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.a.j.xj("cloud_path_check_res");
                                xj2.clear();
                                HashSet hashSet = new HashSet();
                                for (Map.Entry entry : en.p.entrySet()) {
                                    hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                }
                                xj2.put("cloud_path_check_res", hashSet);
                                boolean unused3 = en.f10401pl = false;
                            }
                        }, 1800000L);
                    }
                    countDownLatch.countDown();
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return xj(atomicInteger, strArr[0], str, webView, z);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void hf(com.bytedance.sdk.component.u.hf.w wVar) {
        Set<String> set = u;
        set.addAll(wVar.get("turn_up_white_list", set));
        Set<String> set2 = kd;
        set2.addAll(wVar.get("turn_up_black_list_1", set2));
        Set<String> set3 = y;
        set3.addAll(wVar.get("turn_up_black_list_2", set3));
        Set<String> set4 = c;
        set4.addAll(wVar.get("url_report_rule_list", set4));
        Set<String> set5 = f;
        set5.addAll(wVar.get("net_url_block_list", set5));
        tf = wVar.get("_turn_up_is_get_list", false);
        Set<String> set6 = d;
        set6.addAll(wVar.get("dialog_black_list", set6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hf(String str, Set<String> set) {
        if (str == null) {
            return null;
        }
        try {
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && Pattern.compile(str2).matcher(str).find()) {
                    return str2;
                }
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("JumpModel", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean xj(AtomicInteger atomicInteger, String str, String str2, WebView webView, boolean z) {
        String str3;
        if (webView == null || TextUtils.isEmpty(str) || atomicInteger == null) {
            return false;
        }
        if (atomicInteger.get() == 1) {
            return true;
        }
        switch (str.hashCode()) {
            case -284840886:
                str3 = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
                str.equals(str3);
                break;
            case 3181155:
                str3 = "gray";
                str.equals(str3);
                break;
            case 93818879:
                if (str.equals("black")) {
                    atomicInteger.set(1);
                    com.bytedance.sdk.openadsdk.core.a.y.xj(webView.getContext(), (String) null, true, (y.xj) null);
                    break;
                }
                break;
            case 113101865:
                str3 = "white";
                str.equals(str3);
                break;
        }
        return false;
    }

    public static void hf(final ws wsVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.en.4
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", wsVar.jq());
                jSONObject2.put("cid", wsVar.ho());
                jSONObject2.put("req_id", wsVar.zf());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.a.wo.p(wsVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("stats_url_report_rule").f(wsVar.jf()).hf(jSONObject.toString());
            }
        }, "stats_url_report_rule");
    }

    public static com.bytedance.sdk.component.hf.xj.d hf() {
        return new com.bytedance.sdk.component.hf.xj.d() { // from class: com.bytedance.sdk.openadsdk.core.ra.en.5
            @Override // com.bytedance.sdk.component.hf.xj.d
            public com.bytedance.sdk.component.hf.xj.zg xj(d.xj xjVar) {
                String str;
                com.bytedance.sdk.component.hf.xj.zg xj2 = xjVar.xj(xjVar.xj());
                String str2 = "";
                final String xj3 = xj2.xj("csj-location-record", "");
                final String xj4 = xj2.xj("csj-source-from", "");
                final String xj5 = xj2.xj("csj-extra-info", "");
                if (xj2.w() == 8848) {
                    final String kd2 = xj2.kd();
                    com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.en.5.1
                        @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                        public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", kd2);
                            jSONObject.putOpt("sourceFrom", xj4);
                            jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, xj5);
                            return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("stats_net_block_url").hf(jSONObject.toString());
                        }
                    }, "stats_net_block_url");
                }
                int i = 0;
                try {
                    String[] xj6 = en.xj(xj3);
                    if (xj6 == null || xj6.length <= 1) {
                        str = "";
                    } else {
                        String str3 = xj6[0];
                        try {
                            str = xj6[xj6.length - 1];
                            str2 = str3;
                        } catch (Exception unused) {
                            str = "";
                            str2 = str3;
                        }
                    }
                    try {
                        i = Integer.parseInt(xj4);
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str = "";
                }
                final String str4 = str2;
                final String str5 = str;
                if (!TextUtils.isEmpty(xj3) && i != 0 && TextUtils.isEmpty(en.hf(str4, en.u))) {
                    com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.en.5.2
                        @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                        public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", xj3);
                            jSONObject.putOpt("sourceFrom", xj4);
                            jSONObject.putOpt("sourceUrl", str4);
                            jSONObject.putOpt("destUrl", str5);
                            jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, xj5);
                            return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("stats_net_locations_url").hf(jSONObject.toString());
                        }
                    }, "stats_net_locations_url");
                }
                return xj2;
            }
        };
    }

    public static boolean xj(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.j jVar, WebResourceRequest webResourceRequest, boolean z, boolean z2) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return xj(webView, atomicInteger, jVar, url.toString(), z, z2);
    }

    public static boolean xj(final com.bytedance.sdk.openadsdk.core.j jVar, final int i, final String str) {
        final String hf = hf(str, d);
        final boolean z = (tf && TextUtils.isEmpty(hf)) ? false : true;
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.en.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("url", str);
                    jSONObject.putOpt(PointParamKey.TYPE, Integer.valueOf(i));
                    jSONObject.putOpt("is_block", Boolean.valueOf(z));
                    jSONObject.putOpt("is_get_setting", Boolean.valueOf(en.tf));
                    jSONObject.putOpt("pattern", hf);
                    jSONObject.putOpt("customer_id", com.bytedance.sdk.openadsdk.core.a.wo.p(jVar.f()));
                    return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("stats_dialog_report_rule").f(jVar.f().jf()).hf(jSONObject.toString());
                } catch (Throwable unused) {
                    return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf();
                }
            }
        }, "stats_dialog_report_rule");
        return z;
    }

    private static String xj(String str, int i, boolean z, boolean z2) {
        boolean z3 = (!z2 || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
        if (i == 1) {
            if (tf) {
                return hf(str, y);
            }
            return null;
        }
        if (i == 2) {
            if (!tf) {
                if (z) {
                    return "local://no-setting";
                }
                return null;
            }
            if (z3) {
                return "local://short-internal";
            }
            String hf = hf(str, kd);
            if (!TextUtils.isEmpty(hf)) {
                return hf;
            }
            String hf2 = hf(str, y);
            if (TextUtils.isEmpty(hf2)) {
                return null;
            }
            return hf2;
        }
        if (i != 3) {
            return null;
        }
        if (z || !tf) {
            return "local://preload-setting:" + tf;
        }
        if (z3) {
            return "local://short-internal";
        }
        String hf3 = hf(str, kd);
        if (!TextUtils.isEmpty(hf3)) {
            return hf3;
        }
        String hf4 = hf(str, y);
        if (TextUtils.isEmpty(hf4)) {
            return null;
        }
        return hf4;
    }

    public static void xj(final ws wsVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.en.3
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", wsVar.jq());
                jSONObject2.put("cid", wsVar.ho());
                jSONObject2.put("req_id", wsVar.zf());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.a.wo.p(wsVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("stats_block_report").f(wsVar.jf()).hf(jSONObject.toString());
            }
        }, "stats_block_report");
    }

    public static Set<String> xj() {
        return f;
    }

    public static String[] xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}
