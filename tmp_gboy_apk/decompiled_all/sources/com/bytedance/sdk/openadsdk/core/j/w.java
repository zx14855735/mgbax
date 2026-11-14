package com.bytedance.sdk.openadsdk.core.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.io;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.ws;
import com.bytedance.sdk.openadsdk.core.a.x;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.yo;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends com.bytedance.sdk.component.tf.d {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile w xj;
    private Comparator<JSONObject> c;
    private final Context hf;
    private boolean kd;
    private AtomicBoolean u;
    private final xj w;
    private volatile AtomicBoolean y;

    public static class hf {
        public static String xj(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }

    private w() {
        super("ApplistHelper");
        this.u = new AtomicBoolean(false);
        this.kd = false;
        this.y = new AtomicBoolean(true);
        this.c = new Comparator<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.j.w.1
            @Override // java.util.Comparator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString(n.p).compareTo(jSONObject2.optString(n.p));
            }
        };
        Context context = pz.getContext();
        this.hf = context;
        this.w = new xj(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!am.xj(this.hf)) {
            this.u.set(false);
            return;
        }
        try {
            boolean w = this.w.w();
            this.y.set(false);
            if (w) {
                hf(hf(this.hf));
            } else {
                this.u.set(false);
            }
        } catch (Throwable th) {
            this.u.set(false);
            pl.hf("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    public class xj {
        private com.bytedance.sdk.component.u.hf.w hf;

        public xj(Context context) {
            try {
                this.hf = xj(context);
            } catch (Throwable unused) {
            }
        }

        private com.bytedance.sdk.component.u.hf.w xj(Context context) {
            try {
                return j.xj("tt_sp_app_list");
            } catch (Exception e) {
                pl.xj(e);
                return null;
            }
        }

        public String hf() {
            com.bytedance.sdk.component.u.hf.w wVar = this.hf;
            return wVar == null ? "" : wVar.get("old_app_list", "");
        }

        public boolean w() {
            com.bytedance.sdk.component.u.hf.w wVar = this.hf;
            return !wo.xj(wVar != null ? wVar.get("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }

        public void xj(String str) {
            com.bytedance.sdk.component.u.hf.w wVar;
            if (TextUtils.isEmpty(str) || (wVar = this.hf) == null) {
                return;
            }
            wVar.put("old_app_list", str);
        }

        public void xj() {
            com.bytedance.sdk.component.u.hf.w wVar = this.hf;
            if (wVar == null) {
                return;
            }
            wVar.put("day_update_time", System.currentTimeMillis());
        }
    }

    public static w xj() {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        xj = new w();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void hf() {
        if (wo.hf()) {
            this.kd = pz.hf().uf() && com.bytedance.sdk.openadsdk.core.f.zg().e().hf();
            if (f.u() && this.y.get() && !this.u.get()) {
                this.u.set(true);
                try {
                    com.bytedance.sdk.component.tf.c.xj(this, 1);
                } catch (Throwable unused) {
                    this.u.set(false);
                }
            }
        }
    }

    public List<String> xj(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.xj.w(hf.xj("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object invoke = io.xj(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(io.xj(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((invoke instanceof List) && (list = (List) invoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (xj(packageInfo) != 1) {
                            arrayList.add(MediationConfigUserInfoForSegment.GENDER_UNKNOWN + ":" + packageInfo.packageName);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private List<JSONObject> hf(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (context != null && this.kd && (!com.bytedance.sdk.openadsdk.core.a.io.ht() || Build.VERSION.SDK_INT < 29)) {
            try {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.xj.w(hf.xj("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
                Object invoke = io.xj(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(io.xj(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
                if ((invoke instanceof List) && (list = (List) invoke) != null && !list.isEmpty()) {
                    for (Object obj : list) {
                        if (obj instanceof PackageInfo) {
                            PackageInfo packageInfo = (PackageInfo) obj;
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(n.p, packageInfo.packageName);
                            jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                            jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                            jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                            jSONObject2.put("version_code", packageInfo.versionCode);
                            jSONObject2.put("app_name", MediationConfigUserInfoForSegment.GENDER_UNKNOWN);
                            jSONObject2.put("app_type", xj(packageInfo));
                            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                            jSONObject2.put("apk_dir", applicationInfo != null ? applicationInfo.sourceDir : MediationConfigUserInfoForSegment.GENDER_UNKNOWN);
                            arrayList.add(jSONObject2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    private int xj(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null || (applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return packageInfo.applicationInfo.flags & 1;
    }

    private boolean xj(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, this.c);
        String w = com.bytedance.sdk.component.utils.xj.w(this.w.hf());
        if (TextUtils.isEmpty(w)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(w);
            int length = jSONArray.length();
            if (length != list.size()) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            Collections.sort(arrayList, this.c);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = list.get(i2);
                JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                String optString = jSONObject.optString(n.p);
                String optString2 = jSONObject.optString("last_update_time");
                if (optString == null || optString2 == null || !optString.equals(jSONObject2.optString(n.p)) || !optString2.equals(jSONObject2.optString("last_update_time"))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            pl.w("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void hf(final List<JSONObject> list) {
        boolean xj2 = xj(list);
        JSONObject xj3 = xj(xj2 ? list : new ArrayList<>(), pz.hf().ey(), pz.hf().ci());
        if (list != null) {
            list.size();
        }
        ws wsVar = new ws(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y());
        wsVar.xj(wo.f("/api/ad/union/sdk/upload/app_info/"));
        wsVar.w(xj3, "applist");
        wsVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.j.w.2
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                if (hfVar == null || !hfVar.f() || TextUtils.isEmpty(hfVar.u())) {
                    w.this.y.set(true);
                } else {
                    try {
                        if ("20000".equals(new JSONObject(hfVar.u()).optString("status"))) {
                            w.this.w.xj();
                            w.this.w.xj(com.bytedance.sdk.component.utils.xj.hf(new JSONArray((Collection) list).toString()));
                        }
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                }
                w.this.u.set(false);
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                w.this.u.set(false);
                w.this.y.set(true);
            }
        });
    }

    private JSONObject xj(List<JSONObject> list, List<String> list2, List<String> list3) {
        int i;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            String f = com.bytedance.sdk.openadsdk.core.a.tf.f();
            Object obj2 = "";
            if (TextUtils.isEmpty(f)) {
                f = "";
            }
            if (TextUtils.isEmpty(f)) {
                i = -1;
                obj = "";
            } else {
                obj = f;
                i = 1;
            }
            String w = com.bytedance.sdk.openadsdk.core.a.tf.w(false);
            if (TextUtils.isEmpty(w)) {
                w = "";
            }
            if (i < 0 && !TextUtils.isEmpty(w)) {
                i = 4;
                obj = w;
            }
            String xj2 = com.bytedance.sdk.openadsdk.core.a.tf.xj();
            if (TextUtils.isEmpty(xj2)) {
                xj2 = "";
            }
            String e = com.bytedance.sdk.openadsdk.core.a.tf.e();
            if (!TextUtils.isEmpty(e)) {
                obj2 = e;
            }
            if (i < 0) {
                i = 3;
                obj = xj2;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<JSONObject> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().optString(n.p));
            }
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("app_info", new JSONArray((Collection) list));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", yo.w());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", com.bytedance.sdk.openadsdk.core.a.tf.hf());
            jSONObject.put(PluginConstants.KEY_APP_ID, com.bytedance.sdk.openadsdk.core.f.zg().pz());
            jSONObject.put("app_list_type", 1);
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, ai.u);
            jSONObject.put("device_id_type", i);
            jSONObject.put("imei", f);
            jSONObject.put("oaid", w);
            jSONObject.put("applog_did", obj2);
            jSONObject.put("android_id", xj2);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (wo.w(pz.getContext(), str)) {
                                jSONArray2.put(str);
                            } else {
                                jSONArray3.put(str);
                            }
                        } catch (Throwable unused) {
                            jSONArray3.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray2);
                jSONObject.put("no_applist", jSONArray3);
            }
            boolean si = pz.hf().si();
            jSONObject.put("scheme_get_type", !si ? 1 : 0);
            if (list3 != null && !list3.isEmpty() && si) {
                for (String str2 : list3) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Uri parse = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(parse);
                            wo.xj(pz.getContext(), intent, true);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            Map<String, Boolean> xj3 = x.xj(259200000L);
            if (xj3 != null && xj3.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (Map.Entry<String, Boolean> entry : xj3.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        jSONArray4.put(entry.getKey());
                    } else {
                        jSONArray5.put(entry.getKey());
                    }
                }
                jSONObject.put("scheme_success_list", jSONArray4);
                jSONObject.put("scheme_fail_list", jSONArray5);
            }
            List<String> xj4 = wo.xj();
            if (xj4.size() > 0) {
                jSONObject.put("query_all_package", xj4);
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }
}
