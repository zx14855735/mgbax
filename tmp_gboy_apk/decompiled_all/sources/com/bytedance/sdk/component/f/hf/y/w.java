package com.bytedance.sdk.component.f.hf.y;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.utils.pl;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements hf {
    private final kd hf;
    private com.bytedance.sdk.component.f.xj.kd w;
    private final Context xj;

    @SuppressLint({"StaticFieldLeak"})
    public class xj extends com.bytedance.sdk.component.f.hf.kd.hf {
        private final u hf;
        private final Map<String, String> u;
        private final String w;

        private String w(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.w)) ? str.replace("{UID}", this.w).replace("__UID__", this.w) : str;
        }

        public String hf(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return str.replace("[ss_random]", String.valueOf(w.hf().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
                } catch (Exception e) {
                    pl.xj(e);
                }
            }
            return str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.f.xj.u u = w.this.w.u();
            if (u == null || w.this.w.getContext() == null || !u.u()) {
                return;
            }
            if (!xj(this.hf.w())) {
                u uVar = this.hf;
                xj(null, u, uVar, uVar.w(), "not http url");
                return;
            }
            if (this.hf.kd() == 0) {
                w.this.hf.delete(this.hf);
                u uVar2 = this.hf;
                xj(null, u, uVar2, uVar2.w(), "retry max");
                return;
            }
            try {
                if (this.hf.kd() == 5) {
                    w.this.hf.insert(this.hf);
                }
                if (!u.xj(w.this.getContext())) {
                    u uVar3 = this.hf;
                    xj(null, u, uVar3, uVar3.w(), "no net");
                    return;
                }
                System.currentTimeMillis();
                String w = this.hf.w();
                if (u.tf() == 0) {
                    w = w(this.hf.w());
                    if (this.hf.u()) {
                        w = hf(w);
                    }
                }
                String str = w;
                com.bytedance.sdk.component.f.xj.xj.hf c = u.c();
                com.bytedance.sdk.component.f.xj.xj.kd kdVar = null;
                if (c == null) {
                    xj(null, this.hf, str, "no executor");
                    return;
                }
                c.xj("User-Agent", u.kd());
                c.xj("csj_client_source_from", "1");
                if (this.u != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.u.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    c.xj("csj_extra_info", jSONObject.toString());
                }
                c.xj(str);
                try {
                    kdVar = c.xj();
                } catch (Throwable unused) {
                }
                if (kdVar == null || !kdVar.xj()) {
                    if (kdVar != null && kdVar.w() == 8848) {
                        kdVar.u();
                        w.this.hf.delete(this.hf);
                    }
                    com.bytedance.sdk.component.f.xj.kd unused2 = w.this.w;
                    this.hf.xj(r0.kd() - 1);
                    if (this.hf.kd() == 0) {
                        w.this.hf.delete(this.hf);
                        com.bytedance.sdk.component.f.xj.kd unused3 = w.this.w;
                    } else {
                        w.this.hf.update(this.hf);
                    }
                    if (kdVar != null) {
                        kdVar.u();
                        System.currentTimeMillis();
                    } else {
                        System.currentTimeMillis();
                    }
                } else {
                    w.this.hf.delete(this.hf);
                    com.bytedance.sdk.component.f.xj.kd unused4 = w.this.w;
                    System.currentTimeMillis();
                }
                xj(kdVar, u, this.hf, str, null);
            } catch (Throwable unused5) {
            }
        }

        public boolean xj(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        private xj(u uVar, String str, Map<String, String> map) {
            super("AdsStats");
            this.hf = uVar;
            this.w = str;
            this.u = map;
        }

        private void xj(com.bytedance.sdk.component.f.xj.xj.kd kdVar, com.bytedance.sdk.component.f.xj.u uVar, u uVar2, String str, String str2) {
            try {
                uVar.xj(this.hf.xj(), xj(kdVar, uVar2, str, str2));
            } catch (Exception e) {
                pl.xj(e);
            }
        }

        private JSONObject xj(com.bytedance.sdk.component.f.xj.xj.kd kdVar, u uVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            if (uVar != null) {
                try {
                    jSONObject.put("retry_count", 5 - uVar.kd());
                    JSONObject xj = uVar.xj();
                    if (xj != null) {
                        jSONObject.put("track_type", xj.optString("track_type", ""));
                    }
                    jSONObject.put("url", str);
                    jSONObject.put("current", System.currentTimeMillis());
                    jSONObject.put("error_msg", str2);
                    if (kdVar != null) {
                        jSONObject.put("http_code", kdVar.w());
                        String hf = kdVar.hf();
                        if (!TextUtils.isEmpty(hf)) {
                            if (hf.length() > 5000) {
                                hf = hf.substring(0, 5000);
                            }
                            jSONObject.put("http_response", hf);
                        }
                        jSONObject.put(cb.o, kdVar.xj() ? 1 : 0);
                    }
                } catch (JSONException unused) {
                }
            }
            return jSONObject;
        }
    }

    public w(kd kdVar, com.bytedance.sdk.component.f.xj.kd kdVar2) {
        this.xj = kdVar2.getContext();
        this.hf = kdVar;
        this.w = kdVar2;
    }

    public Context getContext() {
        Context context = this.xj;
        return context == null ? this.w.getContext() : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random hf() {
        SecureRandom instanceStrong;
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.y.hf
    public void xj(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        com.bytedance.sdk.component.f.xj.u u = this.w.u();
        if (u == null || this.w.getContext() == null || u.f() == null || !u.u() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            u.f().execute(new xj(new u(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z, 5, jSONObject, 1), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.y.hf
    public void xj(final String str) {
        com.bytedance.sdk.component.f.xj.u u = this.w.u();
        if (u == null || this.w.getContext() == null || !u.u()) {
            return;
        }
        com.bytedance.sdk.component.f.hf.kd.hf hfVar = new com.bytedance.sdk.component.f.hf.kd.hf("trackFailedUrls") { // from class: com.bytedance.sdk.component.f.hf.y.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.xj(w.this.hf.xj(), str);
            }
        };
        hfVar.xj(1);
        if (u.f() != null) {
            u.f().execute(hfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(List<u> list, String str) {
        String str2;
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.f.xj.u u = this.w.u();
        for (u uVar : list) {
            if (u == null || u.f() == null) {
                str2 = str;
            } else {
                str2 = str;
                u.f().execute(new xj(uVar, str2, null));
            }
            str = str2;
        }
    }
}
