package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.et;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.w.y;
import com.bytedance.sdk.openadsdk.g.xj;
import com.bytedance.sdk.openadsdk.x.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements com.bytedance.sdk.openadsdk.core.dislike.hf.xj {
    private final WeakReference<Context> hf;
    private String u;
    private final u w;
    private final ws xj;

    public kd(ws wsVar, Context context, u uVar) {
        this.xj = wsVar;
        this.hf = new WeakReference<>(context);
        this.w = uVar;
    }

    private String w(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("app_name", f.zg().ht());
            jSONObject.putOpt(PluginConstants.KEY_APP_ID, f.zg().pz());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", tf.e());
            jSONObject.putOpt(PluginConstants.KEY_SDK_VERSION, 7132);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(ai.w));
            jSONObject.putOpt("live_sdk_version", com.bytedance.sdk.openadsdk.core.live.hf.xj().c());
            jSONObject.putOpt(br.c, str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt("ad_info", this.xj.og());
            com.bytedance.sdk.openadsdk.zg.w.w.hf gh = this.xj.gh();
            if (gh != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(gh.jk()));
                jSONObject.putOpt("rit", gh.v());
            }
            return jSONObject.toString();
        } catch (Exception e) {
            pl.hf("#oncall#", e);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(String str, String str2) {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext()), str);
        file.mkdirs();
        et etVar = (et) pz.xj();
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh = this.xj.gh();
        JSONObject xj = etVar.xj(gh, new tj(), gh.jk(), false, 6);
        if (xj == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.u.xj(y.xj().hf(xj.toString()).u().toString(), new File(file, "request.info"));
        HashMap hashMap = null;
        com.bytedance.sdk.openadsdk.x.u.xj(com.bytedance.sdk.component.utils.xj.xj(com.bytedance.sdk.openadsdk.core.j.f.xj((com.bytedance.sdk.openadsdk.core.j.kd) null).kd()).toString(), new File(file, "setting.info"));
        com.bytedance.sdk.openadsdk.x.u.xj(com.bytedance.sdk.component.utils.xj.xj(this.xj.ac()).toString(), new File(file, "meta.info"));
        File xj2 = com.bytedance.sdk.openadsdk.x.u.xj(file, str + ".zip");
        String w = w(str2, str);
        HashMap hashMap2 = new HashMap();
        Pair<Integer, JSONObject> xj3 = y.xj().xj(w, false);
        if (xj3 != null) {
            hashMap = new HashMap();
            hashMap2.put("deviceInfo", ((JSONObject) xj3.second).optString("message"));
            hashMap.put("x-pglcypher", String.valueOf(xj3.first));
        }
        new com.bytedance.sdk.openadsdk.g.xj().xj(this.w.w(), xj2, hashMap2, new xj.InterfaceC0200xj() { // from class: com.bytedance.sdk.openadsdk.core.dislike.kd.5
            @Override // com.bytedance.sdk.openadsdk.g.xj.InterfaceC0200xj
            public void xj(String str3) {
                kd.this.xj("反馈上传成功！");
            }

            @Override // com.bytedance.sdk.openadsdk.g.xj.InterfaceC0200xj
            public void xj(int i, String str3) {
                kd.this.xj("反馈失败！");
            }
        }, hashMap);
        xj2.delete();
        com.bytedance.sdk.openadsdk.x.u.xj(file);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.xj
    public boolean xj(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.hf.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return xj(this.hf.get(), str, dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.xj
    public boolean xj(com.bytedance.sdk.openadsdk.zg.w.hf.y yVar, String str, Dialog dialog) {
        com.bytedance.sdk.openadsdk.core.dislike.w.w xj = u.xj();
        if (xj == null || !TextUtils.equals(yVar.xj(), xj.xj()) || !TextUtils.equals(yVar.hf(), xj.hf())) {
            return false;
        }
        pl.hf("TTAdDislikeImpl", "click feedback :" + yVar.hf() + ":" + yVar.xj());
        return xj(this.hf.get(), str, dialog);
    }

    public boolean xj(Context context, final String str, Dialog dialog) {
        try {
            if (this.u == null) {
                this.u = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.kd.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    kd kdVar = kd.this;
                    kdVar.xj(kdVar.u, str);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.kd.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setMessage(this.w.u() + "\n\n您此次反馈的id为：" + this.u).setCancelable(true).create().show();
            return true;
        } catch (Exception e) {
            pl.xj(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str) {
        c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.kd.3
            @Override // java.lang.Runnable
            public void run() {
                if (kd.this.hf.get() != null) {
                    x.xj((Context) kd.this.hf.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str, final String str2) {
        xj("反馈上传中，请您稍等！");
        com.bytedance.sdk.component.tf.c.hf(new d("upload_oncall") { // from class: com.bytedance.sdk.openadsdk.core.dislike.kd.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kd.this.hf(str, str2);
                } catch (Throwable th) {
                    pl.hf("#oncall#", th);
                }
            }
        });
    }

    public static void xj(Context context, com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar, ws wsVar) {
        u se;
        if (xjVar == null || wsVar == null || (se = pz.hf().se()) == null || !se.hf() || TextUtils.isEmpty(se.w())) {
            return;
        }
        xjVar.xj(new kd(wsVar, context, se));
    }
}
