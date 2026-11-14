package com.bytedance.sdk.openadsdk.core.pl.w.w;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.ugeno.c.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private Context hf;
    private com.bytedance.sdk.openadsdk.core.pl.w.xj.xj kd;
    private xj w;
    private ws xj;
    private boolean u = true;
    private boolean y = false;
    private int c = 0;
    private boolean f = false;

    public w(Context context, ws wsVar) {
        this.hf = context;
        this.xj = wsVar;
    }

    public boolean u(boolean z) {
        xj xjVar = this.w;
        boolean z2 = true;
        if (xjVar == null) {
            return true;
        }
        if (xjVar instanceof hf) {
            hf hfVar = (hf) xjVar;
            if (!z && !this.f) {
                z2 = false;
            }
            hfVar.w(z2);
            hfVar.hf(this.y);
            hfVar.xj(this.c);
        }
        return this.w.xj();
    }

    public void hf(boolean z) {
        this.y = z;
    }

    public void w(boolean z) {
        this.f = z;
    }

    private void hf(final String str) {
        if (jk.yo(this.xj) != 4) {
            return;
        }
        TTDelegateActivity.xj(new c() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.w.w.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(int i, String str2) {
                w.this.xj(str, 1, str2);
                TTDelegateActivity.xj((c) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                w.this.xj(str, 0, "");
                TTDelegateActivity.xj((c) null);
            }
        });
    }

    public String w(long j) {
        return j <= 0 ? "-" : String.format("%.1fMB", Double.valueOf((j / 1024.0d) / 1024.0d));
    }

    private c w(final String str) {
        return new c() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.w.w.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(int i, String str2) {
                w wVar = w.this;
                wVar.xj(wVar.xj, str, 6, i, str2);
                TTDelegateActivity.xj((c) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                w wVar2 = w.this;
                wVar2.xj(wVar2.xj, str, 5, 0, "");
                TTDelegateActivity.xj((c) null);
            }
        };
    }

    public String hf(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(Math.round(j / 1.0E8d)));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(Math.round(j / 10000.0d)));
        }
        if (j > 0) {
            return String.valueOf(j);
        }
        return "-";
    }

    public void xj(xj xjVar) {
        xj(xjVar, this.xj);
    }

    public void xj(xj xjVar, ws wsVar) {
        this.w = xjVar;
        if (xjVar == null) {
            return;
        }
        xjVar.xj(this.hf);
        xjVar.xj(wsVar);
        xjVar.xj(this.u);
    }

    private String u(String str) {
        com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.hf.xj();
        if (xj == null) {
            return null;
        }
        return xj.get(str, "");
    }

    public void xj(boolean z) {
        this.u = z;
    }

    private y.xj hf(final String str, final com.bytedance.sdk.openadsdk.core.pl.w.xj.hf hfVar) {
        return new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.w.w.4
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                com.bytedance.sdk.openadsdk.core.pl.w.xj.hf hfVar2 = hfVar;
                if (hfVar2 != null) {
                    hfVar2.xj();
                }
                if (w.this.kd != null) {
                    w.this.kd.xj();
                }
                y.hf = true;
                com.bytedance.sdk.openadsdk.core.am.u.hf(w.this.xj, str, "pop_up_download", w.this.xj());
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                com.bytedance.sdk.openadsdk.core.am.u.hf(w.this.xj, str, "pop_up_cancel", w.this.xj());
            }
        };
    }

    public void xj(com.bytedance.sdk.openadsdk.core.pl.w.xj.xj xjVar) {
        this.kd = xjVar;
    }

    public void xj(int i) {
        this.c = i;
    }

    public void xj(String str, com.bytedance.sdk.openadsdk.core.pl.w.xj.hf hfVar) {
        if (this.xj == null) {
            return;
        }
        xj((com.bytedance.sdk.openadsdk.core.ra.u) null, str, hfVar);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ra.u uVar, final String str, final String str2, final com.bytedance.sdk.openadsdk.core.pl.w.xj.hf hfVar) {
        ws wsVar = this.xj;
        if (wsVar == null) {
            return;
        }
        if (uVar == null && wsVar.zm() == 2 && !(this.w instanceof kd)) {
            com.bytedance.sdk.component.tf.c.hf(new d("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.pl.w.w.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.xj(pz.xj().xj(w.this.xj, str2), str, hfVar);
                }
            });
        } else {
            xj(uVar, str, hfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.ra.u uVar, String str, com.bytedance.sdk.openadsdk.core.pl.w.xj.hf hfVar) {
        JSONException jSONException;
        String he;
        String hf;
        String str2;
        w wVar;
        String str3;
        y.xj hf2 = hf(str, hfVar);
        try {
            if (uVar != null) {
                com.bytedance.sdk.openadsdk.core.ra.y ut = this.xj.ut();
                if (ut != null) {
                    uVar.xj(ut.u());
                    uVar.xj(ut.w());
                }
                he = uVar.y();
                hf = uVar.xj();
                str2 = uVar.w();
            } else {
                try {
                    he = this.xj.he();
                    hf = tf.hf(this.xj);
                    z uf = this.xj.uf();
                    if (uf != null) {
                        str2 = uf.xj();
                    } else {
                        str2 = "";
                    }
                } catch (JSONException e) {
                    e = e;
                    jSONException = e;
                    pl.xj(jSONException);
                }
            }
            String str4 = str2;
            if (com.bytedance.sdk.openadsdk.core.ugeno.tf.d(this.xj)) {
                try {
                    if (com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(this.hf, this.xj, hf)) {
                        wVar = this;
                        str3 = str;
                    } else {
                        ws wsVar = this.xj;
                        try {
                            xj(wsVar, str, com.bytedance.sdk.openadsdk.core.ugeno.tf.hf(this.hf, wsVar, hf), 0, "");
                            wVar = this;
                            str3 = str;
                        } catch (JSONException e2) {
                            e = e2;
                            jSONException = e;
                            pl.xj(jSONException);
                        }
                    }
                } catch (JSONException e3) {
                    jSONException = e3;
                    pl.xj(jSONException);
                }
            } else {
                wVar = this;
                str3 = str;
                try {
                    com.bytedance.sdk.openadsdk.core.am.u.hf(wVar.xj, str3, "pop_up", xj());
                } catch (JSONException e4) {
                    e = e4;
                    jSONException = e;
                    pl.xj(jSONException);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", hf);
            jSONObject.put("dialog_icon_url", str4);
            jSONObject.put("dialog_app_description", wVar.xj.uj());
            String xj = xj(he);
            hf(str3);
            if (com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(wVar.hf, wVar.xj, hf)) {
                wVar.xj(str3, hf2, xj, str4, jSONObject);
                return;
            }
            w wVar2 = wVar;
            try {
                com.bytedance.sdk.openadsdk.core.a.y.xj(wVar2.hf, wVar2.xj.ho(), xj, jSONObject.toString(), hf2, wVar2.xj);
            } catch (JSONException e5) {
                e = e5;
                jSONException = e;
                pl.xj(jSONException);
            }
        } catch (JSONException e6) {
            jSONException = e6;
        }
    }

    private String xj(String str) {
        int yo = jk.yo(this.xj);
        try {
            if (yo != 4) {
                if (yo != 3) {
                    return str;
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("ugen_url", jk.jk(this.xj));
            jSONObject2.put("ugen_md5", jk.pz(this.xj));
            jSONObject2.put("download_num", hf(this.xj.sv()));
            if (this.xj.vh() == null) {
                return jSONObject2.toString();
            }
            jSONObject2.put("app_size", w(r1.c()));
            jSONObject2.put("comment_num", xj(r1.y()));
            return jSONObject2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, int i, String str2) {
        JSONObject xj = xj();
        try {
            xj.put("ugen_dl_render_fail_msg", str2);
            xj.put("ugen_dl_render_fail", i);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.xj, str, "pop_up", xj);
    }

    public String xj(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(j / 100000000));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(j / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
        }
        if (j > 0) {
            return String.valueOf(j);
        }
        return "-";
    }

    private void xj(String str, y.xj xjVar, String str2, String str3, JSONObject jSONObject) {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.bytedance.sdk.openadsdk.core.a.y.xj(this.hf, this.xj.ho(), com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(this.hf, str2, this.xj, str3), jSONObject.toString(), xjVar, w(str), this.xj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ws wsVar, String str, int i, int i2, String str2) {
        JSONObject xj = xj();
        if (6 == i) {
            try {
                xj.put("easy_dl_render_fail_code", i2);
                if (wsVar != null) {
                    String w = wsVar.wf().w();
                    xj.put("easy_dl_render_fail_msg", str2);
                    xj.put("easy_dl_render_fail_dsl", u(w));
                }
            } catch (Exception unused) {
            }
        }
        xj.put("show_easy_dl_dialog_code", i);
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.xj, str, "pop_up", xj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            xj xjVar = this.w;
            jSONObject.put("download_type", xjVar != null ? xjVar.hf() : 0);
            return jSONObject;
        } catch (Exception e) {
            pl.xj(e);
            return jSONObject;
        }
    }
}
