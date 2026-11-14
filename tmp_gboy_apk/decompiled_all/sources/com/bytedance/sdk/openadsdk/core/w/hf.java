package com.bytedance.sdk.openadsdk.core.w;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static volatile hf xj;
    private volatile SharedPreferences hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), "sp_dynamic_tmpl_config", 0);
    private volatile SharedPreferences w = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), "sp_dynamic_tmpl_config_v3", 0);

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void delete(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String hf = hf(str, null, z);
            if (TextUtils.isEmpty(hf)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(hf);
            if (jSONArray.length() > 0) {
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        i = -1;
                        break;
                    }
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && str2.equals(optJSONObject.getString(f.f13353a))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    jSONArray.remove(i);
                    xj(str, jSONArray.toString(), z);
                }
            }
        } catch (Exception unused) {
        }
    }

    public JSONArray hf(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!w.xj().xj(i)) {
            return xj(str);
        }
        try {
            final String hf = hf(str, null, true);
            c.hf(new d("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.w.hf.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        Set<com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj> xj2 = com.bytedance.sdk.openadsdk.core.nativeexpress.xj.hf.xj().xj(str);
                        JSONArray jSONArray = new JSONArray();
                        if (xj2 == null || xj2.size() <= 0) {
                            z = false;
                        } else {
                            for (com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj xjVar : xj2) {
                                if (xjVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    String[] split = xjVar.xj().split("_");
                                    if (split.length == 2) {
                                        jSONObject.put(f.f13353a, split[1]);
                                        jSONObject.put(TKDownloadReason.KSAD_TK_MD5, xjVar.hf());
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                            z = true;
                        }
                        if (!(hf == null && z) && jSONArray.toString().equals(hf)) {
                            return;
                        }
                        hf.this.xj(str, jSONArray.toString(), true);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(hf)) {
                return null;
            }
            return new JSONArray(hf);
        } catch (Exception unused) {
            return null;
        }
    }

    public void update(String str, com.bytedance.sdk.component.adexpress.xj.w.w wVar, boolean z) {
        if (wVar == null || wVar.hf() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String hf = hf(str, null, z);
            JSONArray jSONArray = hf == null ? new JSONArray() : new JSONArray(hf);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f.f13353a, wVar.hf());
            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, wVar.w());
            jSONArray.put(jSONObject);
            xj(str, jSONArray.toString(), z);
        } catch (Exception unused) {
        }
    }

    public void xj(String str, String str2) {
        delete(str, str2, false);
    }

    public String hf(String str, String str2, boolean z) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z) {
                sharedPreferences = this.w;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.hf;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (w.xj().hf()) {
                return com.bytedance.sdk.component.c.w.xj.hf.hf(str3, str, str2);
            }
            return sharedPreferences.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void xj(String str, com.bytedance.sdk.component.adexpress.xj.w.w wVar) {
        update(str, wVar, false);
    }

    public JSONArray xj(final String str, int i) {
        try {
            final String hf = hf(str, null, false);
            c.hf(new d("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.w.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        Set<com.bytedance.sdk.component.adexpress.xj.w.hf> xj2 = com.bytedance.sdk.component.adexpress.xj.hf.hf.xj(str, false);
                        JSONArray jSONArray = new JSONArray();
                        if (xj2 == null || xj2.size() <= 0) {
                            z = false;
                        } else {
                            for (com.bytedance.sdk.component.adexpress.xj.w.hf hfVar : xj2) {
                                if (hfVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(f.f13353a, hfVar.hf());
                                    jSONObject.put(TKDownloadReason.KSAD_TK_MD5, hfVar.w());
                                    jSONArray.put(jSONObject);
                                }
                            }
                            z = true;
                        }
                        if (!(hf == null && z) && jSONArray.toString().equals(hf)) {
                            return;
                        }
                        hf.this.xj(str, jSONArray.toString(), false);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(hf)) {
                return null;
            }
            return new JSONArray(hf);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray xj(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj> xj2 = com.bytedance.sdk.openadsdk.core.nativeexpress.xj.hf.xj().xj(str);
            if (xj2 != null && xj2.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj xjVar : xj2) {
                    if (xjVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        String[] split = xjVar.xj().split("_");
                        if (split.length == 2) {
                            jSONObject.put(f.f13353a, split[1]);
                            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, xjVar.hf());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            pl.w("BidOptTmplManager", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    public void xj(String str, String str2, boolean z) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z) {
                sharedPreferences = this.w;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.hf;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (w.xj().hf()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj(str3, str, str2);
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
