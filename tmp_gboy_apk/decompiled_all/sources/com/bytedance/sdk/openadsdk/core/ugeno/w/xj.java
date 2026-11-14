package com.bytedance.sdk.openadsdk.core.ugeno.w;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.am.y;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.et.hf;
import com.bytedance.sdk.openadsdk.core.pl.f;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.u;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.c.kd;
import com.bytedance.sdk.openadsdk.core.ugeno.w.hf;
import com.sigmob.sdk.base.common.a;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements hf.xj {
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf am;
    private Activity c;
    private com.bytedance.adsdk.ugeno.hf.w d;
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj e = new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xj.8
        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void hf(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void w(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(long j, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(String str, String str2) {
        }
    };
    private ViewGroup f;
    private String g;
    protected hf hf;
    protected int kd;
    private JSONObject p;

    /* renamed from: pl, reason: collision with root package name */
    private u f10440pl;
    private com.bytedance.adsdk.ugeno.widget.image.hf qt;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w tf;
    protected String u;
    protected com.bytedance.sdk.openadsdk.core.ugeno.u.xj w;
    protected ws xj;
    private y y;
    private com.bytedance.sdk.openadsdk.core.multipro.hf.xj zg;

    public xj(Activity activity, ViewGroup viewGroup, y yVar, ws wsVar, String str, int i, com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar) {
        this.xj = wsVar;
        this.c = activity;
        this.y = yVar;
        this.f = viewGroup;
        this.u = str;
        this.kd = i;
        this.zg = xjVar;
    }

    private String c() {
        return wo.zg(this.xj);
    }

    private void d() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = this.am;
        if (hfVar != null) {
            hfVar.xj(this.zg);
        }
    }

    private void f() {
        if (this.tf == null) {
            com.bytedance.sdk.openadsdk.core.pl.hf.w xj = f.xj(this.c, this.g, this.xj, this.u);
            this.tf = xj;
            xj.xj(tf.xj(this.xj));
            this.tf.xj(this.e, false);
            this.tf.hf(false);
        }
        this.tf.xj(this.c);
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        ws wsVar = this.xj;
        if (wsVar == null || h.d(wsVar) != 200) {
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w u = this.d.u("video");
        if (u instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) u;
            this.am = hfVar;
            hfVar.kd(true);
            d();
        }
        com.bytedance.adsdk.ugeno.hf.w u2 = this.d.u(a.z);
        if (u2 instanceof com.bytedance.adsdk.ugeno.widget.image.hf) {
            this.qt = (com.bytedance.adsdk.ugeno.widget.image.hf) u2;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
            shapeDrawable.setIntrinsicWidth(r.w(this.c, 28.0f));
            shapeDrawable.setIntrinsicHeight(r.w(this.c, 28.0f));
            this.qt.d().setBackground(shapeDrawable);
        }
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = this.zg;
        if (xjVar != null) {
            xj(xjVar.f);
        } else {
            xj(true);
        }
    }

    private void u(final JSONObject jSONObject) {
        if (this.f10440pl != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.f10440pl.y());
                jSONObject2.put("is_support_func_desc", "true");
                jSONObject.put(PointCategory.APP, jSONObject2);
                w(jSONObject);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String y = y();
        this.g = y;
        if (!TextUtils.isEmpty(y)) {
            c.hf(new d("tt_pl_download_check") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xj.4
                @Override // java.lang.Runnable
                public void run() {
                    xj xjVar = xj.this;
                    dk<com.bytedance.sdk.openadsdk.core.am.xj> xj = pz.xj();
                    xj xjVar2 = xj.this;
                    xjVar.f10440pl = xj.xj(xjVar2.xj, xjVar2.g);
                    try {
                        JSONObject jSONObject3 = xj.this.f10440pl != null ? new JSONObject(xj.this.f10440pl.y()) : xj.this.xj.he() != null ? new JSONObject(xj.this.xj.he()) : new JSONObject();
                        jSONObject3.put("is_support_func_desc", "true");
                        jSONObject.put(PointCategory.APP, jSONObject3);
                        jSONObject3.put("download_url", xj.this.g);
                        xj.this.w(jSONObject);
                    } catch (Throwable unused2) {
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj(-4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final JSONObject jSONObject) {
        kd.xj(this.xj.v(), "lp_" + this.xj.yo(), this.xj.jk(), new kd.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.kd.xj
            public void xj(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    xj.this.y.xj(-1, "template info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar = xj.this.w;
                    if (xjVar != null) {
                        xjVar.xj(-1);
                        return;
                    }
                    return;
                }
                try {
                    jSONObject.put("creative", xj.this.xj.ac());
                    xj.this.xj(jSONObject);
                    xj.this.xj(jSONObject2, jSONObject);
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        });
    }

    private String y() {
        JSONObject jSONObject = this.p;
        if (jSONObject == null) {
            return c();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("download_buttons");
        if (optJSONArray == null) {
            return c();
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return c();
        }
        String optString = optJSONObject.optString("url");
        return TextUtils.isEmpty(optString) ? c() : optString;
    }

    public void xj(JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(JSONObject jSONObject) {
        this.p = jSONObject;
        u(jSONObject);
    }

    private void hf(boolean z) {
        f();
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.tf;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.f) {
            ((com.bytedance.sdk.openadsdk.core.pl.w.f) wVar).y().xj(z);
        }
    }

    private void w(boolean z) {
        hf(false);
        u(z);
    }

    private void w(ws wsVar) {
        String d;
        if (wsVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ra.y ut = wsVar.ut();
        u uVar = this.f10440pl;
        if (uVar != null) {
            d = uVar.u();
        } else {
            d = ut == null ? "" : ut.d();
        }
        com.bytedance.sdk.openadsdk.core.a.y.hf(this.c, d, wsVar.ho(), new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xj.7
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                xj.this.u(true);
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }
        });
    }

    private boolean hf(zg zgVar) {
        if (zgVar == null) {
            return false;
        }
        View d = zgVar.xj().d();
        if (!(d instanceof TextView)) {
            return false;
        }
        CharSequence text = ((TextView) d).getText();
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return text.toString().contains("下载");
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar) {
        this.w = xjVar;
    }

    public void xj() {
        this.hf = new hf(this.c, this.y, this.u, this.kd);
        if (this.xj.ht() != null) {
            try {
                hf(new JSONObject(this.xj.ht().toString()));
                return;
            } catch (JSONException e) {
                pl.xj(e);
                return;
            }
        }
        int yo = this.xj.yo();
        if (yo != 5 && yo != 4) {
            com.bytedance.sdk.openadsdk.core.et.hf.xj(this.xj.e(), new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xj.1
                @Override // com.bytedance.sdk.openadsdk.core.et.hf.xj
                public void xj(JSONObject jSONObject) {
                    xj.this.hf(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.et.hf.xj
                public void xj(int i, String str) {
                    xj.this.y.xj(-3, "ad meta info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar = xj.this.w;
                    if (xjVar != null) {
                        xjVar.xj(-3);
                    }
                }
            });
        } else {
            hf(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        f();
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(this.c, this.xj, "embeded_ad_landingpage", this.kd);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(true);
        this.tf.w(z);
        this.tf.xj(this.xj, false);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.tf);
        this.tf.xj(wo.v(this.xj), false);
    }

    public void w() {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.tf;
        if (wVar != null) {
            wVar.xj();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = this.am;
        if (hfVar != null) {
            hfVar.s();
        }
    }

    private void hf(ws wsVar) {
        String he;
        if (wsVar == null) {
            return;
        }
        if (this.f10440pl != null) {
            com.bytedance.sdk.openadsdk.core.ra.y ut = wsVar.ut();
            if (ut != null) {
                this.f10440pl.xj(ut.u());
                this.f10440pl.xj(ut.w());
            }
            he = this.f10440pl.y();
        } else {
            he = wsVar.he();
        }
        Activity activity = this.c;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).w();
        }
        com.bytedance.sdk.openadsdk.core.a.y.xj(this.c, wsVar.ho(), new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xj.6
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                xj.this.u(true);
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }
        }, he);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(JSONObject jSONObject, JSONObject jSONObject2) {
        this.y.hf();
        this.hf.xj(this);
        this.hf.xj(jSONObject, jSONObject2, new com.bytedance.sdk.openadsdk.core.ugeno.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xj.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(int i, String str) {
                com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar = xj.this.w;
                if (xjVar != null) {
                    xjVar.xj(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                xj.this.d = wVar;
                xj.this.f.addView(wVar.d(), new FrameLayout.LayoutParams(wVar.l(), wVar.ff()));
                com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar = xj.this.w;
                if (xjVar != null) {
                    xjVar.xj(wVar.d());
                }
                xj.this.kd();
                xj.this.xj(wVar);
            }
        });
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.tf;
        if (wVar != null) {
            wVar.hf();
        }
    }

    private void xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = this.am;
        if (hfVar != null) {
            hfVar.u(z);
        }
        com.bytedance.adsdk.ugeno.widget.image.hf hfVar2 = this.qt;
        if (hfVar2 == null || hfVar2.d() == null) {
            return;
        }
        jk.xj((Context) this.c, z ? "tt_mute" : "tt_unmute", (ImageView) this.qt.d());
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = this.am;
        if (hfVar != null) {
            hfVar.dq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w.hf.xj
    public void xj(zg zgVar) {
        JSONObject w;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar;
        if (zgVar == null || zgVar.hf() != 1 || (w = zgVar.w()) == null) {
            return;
        }
        String optString = w.optString(PointParamKey.TYPE);
        optString.getClass();
        switch (optString) {
            case "openAppPermission":
                xj(this.xj);
                break;
            case "clickVideo":
                com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar2 = this.am;
                if (hfVar2 != null) {
                    hfVar2.wa();
                    break;
                }
                break;
            case "openAppFunctionDesc":
                w(this.xj);
                break;
            case "downloadEvent":
                hf(true);
                u(hf(zgVar));
                break;
            case "downloadDirect":
                w(hf(zgVar));
                break;
            case "muteVideo":
                if (this.qt != null && (hfVar = this.am) != null) {
                    xj(!hfVar.f());
                    break;
                }
                break;
            case "openAppPolicy":
                hf(this.xj);
                break;
            case "openInfringement":
                com.bytedance.sdk.openadsdk.core.a.y.xj(this.c, this.u, this.xj);
                break;
        }
    }

    private void xj(ws wsVar) {
        String he;
        if (wsVar == null) {
            return;
        }
        if (this.f10440pl != null) {
            com.bytedance.sdk.openadsdk.core.ra.y ut = wsVar.ut();
            if (ut != null) {
                this.f10440pl.xj(ut.u());
                this.f10440pl.xj(ut.w());
            }
            he = this.f10440pl.y();
        } else {
            he = wsVar.he();
        }
        Activity activity = this.c;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).w();
        }
        com.bytedance.sdk.openadsdk.core.a.y.xj(this.c, wsVar.ho(), he, new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xj.5
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                xj.this.u(true);
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                if (xj.this.c instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) xj.this.c).u();
                }
            }
        });
    }
}
