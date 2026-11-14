package com.bytedance.sdk.openadsdk.core.c;

import android.content.Context;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static volatile boolean xj;

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf() {
        c.hf(new d("fetch_lg_command") { // from class: com.bytedance.sdk.openadsdk.core.c.xj.2
            @Override // java.lang.Runnable
            public void run() {
                w.hf();
            }
        });
    }

    public static void u(String str, String str2) {
        if (xj) {
            w.u(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (xj) {
            w.w(str, str2);
        }
    }

    public static void hf(String str, String str2) {
        if (xj) {
            w.hf(str, str2);
        }
    }

    private static void xj(Context context, hf hfVar) {
        if (hfVar != null && LogAdapter.xj == null && e.xj(pz.getContext()) && hfVar.u()) {
            String path = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context).getPath();
            String file = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(context).toString();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("buffer_dir_path", path + "/aa");
                jSONObject.putOpt("log_dir_path", file + "/aa");
                Boolean bool = Boolean.TRUE;
                jSONObject.putOpt("compress", bool);
                jSONObject.putOpt("encrypt", bool);
                jSONObject.putOpt("level", Integer.valueOf(hfVar.xj()));
                jSONObject.putOpt("log_file_exp_days", Integer.valueOf(hfVar.hf()));
                jSONObject.putOpt("max_dir_size", Integer.valueOf(hfVar.w() * 1048576));
                jSONObject.putOpt("per_size", 2097152);
                jSONObject.putOpt("offload_main_write", bool);
                if (!w.xj(context, jSONObject)) {
                    pl.u("ACL", "init failed");
                    return;
                }
                pl.xj(new kd());
                w.xj(context, "3892", tf.e());
                w.xj("mon.zijieapi.com");
                xj = true;
                w.w();
            } catch (JSONException e) {
                pl.u("ACL", "init failed:" + e.getMessage());
            }
        }
    }

    public static void hf(String str, String str2, Throwable th) {
        if (xj) {
            w.hf(str, str2, th);
        }
    }

    public static void xj(hf hfVar) {
        if (!xj) {
            xj(pz.getContext(), hfVar);
        } else if (hfVar != null && hfVar.u()) {
            w.xj(hfVar.xj());
            f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.hf();
                }
            }, PushUIConfig.dismissTime);
        } else {
            w.xj();
        }
    }

    public static void xj(String str, String str2) {
        if (xj) {
            w.xj(str, str2);
        }
    }

    public static void xj(String str, String str2, Throwable th) {
        if (xj) {
            w.xj(str, str2, th);
        }
    }

    public static void xj(String str, Throwable th) {
        if (xj) {
            w.xj(str, th);
        }
    }
}
