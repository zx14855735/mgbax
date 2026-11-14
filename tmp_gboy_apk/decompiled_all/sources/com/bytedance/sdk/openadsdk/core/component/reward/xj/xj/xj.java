package com.bytedance.sdk.openadsdk.core.component.reward.xj.xj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.kd.u.kd;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.w;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile xj xj;
    private final Context hf;
    private long u;
    private final hf w;

    private xj(Context context) {
        this.hf = context == null ? pz.getContext() : context.getApplicationContext();
        this.w = new hf();
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj(pz.getContext());
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void hf() {
        File[] listFiles;
        kd.xj(7).xj();
        kd.xj(8).xj();
        File w = (("mounted".equals(w.xj()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.openadsdk.api.plugin.hf.w(this.hf) != null) ? com.bytedance.sdk.openadsdk.api.plugin.hf.w(this.hf) : com.bytedance.sdk.openadsdk.api.plugin.hf.hf(this.hf);
        if (w == null || !w.exists() || !w.isDirectory() || (listFiles = w.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null) {
                    return file.getName().contains("reward_video_cache");
                }
                return false;
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            try {
                y.w(file);
            } catch (Throwable unused) {
            }
        }
    }

    public String xj(boolean z, String str) {
        long w = pz.hf().w(str);
        if (w > 0 && System.currentTimeMillis() - this.u < w) {
            return "1";
        }
        int i = z ? 7 : 8;
        ws hf = hf(z, str);
        if (hf == null) {
            return Constants.FAIL;
        }
        if (hf.a() + hf.ra() < System.currentTimeMillis()) {
            kd.xj(i).xj(str);
            return "1";
        }
        JSONObject xj2 = xj(hf);
        if (xj2 != null) {
            this.u = System.currentTimeMillis();
            return xj2.toString();
        }
        return Constants.FAIL;
    }

    public void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xj(hfVar, str);
    }

    public synchronized ws hf(boolean z, String str) {
        ws xj2 = com.bytedance.sdk.openadsdk.core.component.reward.xj.kd.xj(z, false).xj(str, 0L);
        if (xj2 == null) {
            return null;
        }
        if (ht.w(xj2)) {
            if (TextUtils.isEmpty(str) || !str.endsWith("again")) {
                return xj2;
            }
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(xj2)) {
            return xj2;
        }
        if (h.am(xj2) == null) {
            return null;
        }
        return xj2;
    }

    private JSONObject xj(ws wsVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", wsVar.q());
            jSONObject.put("aid", Long.valueOf(wsVar.jq()));
            jSONObject.put("cid", Long.valueOf(wsVar.ho()));
            jSONObject.put("price", wsVar.ff());
            jSONObject.put("material_key", wsVar.en());
            jSONObject.put("s_send_ts", wsVar.a());
            jSONObject.put("cache_time", wsVar.ra());
            jSONObject.put(n.m, wsVar.dk());
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str) {
        this.w.xj(str, hfVar);
    }

    public com.bytedance.sdk.openadsdk.zg.w.w.hf xj(String str) {
        return this.w.xj(str);
    }
}
