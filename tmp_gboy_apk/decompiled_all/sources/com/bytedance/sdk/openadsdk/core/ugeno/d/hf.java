package com.bytedance.sdk.openadsdk.core.ugeno.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.am.y;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.c.kd;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends com.bytedance.sdk.openadsdk.core.ugeno.c.xj implements ai.xj {
    private AtomicBoolean ai;
    private final Handler dk;
    private com.bytedance.sdk.openadsdk.core.jk.w et;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf ht;

    /* renamed from: io, reason: collision with root package name */
    private long f10434io;
    private boolean ra;
    private boolean x;

    public hf(Context context, ViewGroup viewGroup, y yVar, ws wsVar, String str, int i) {
        super(context, viewGroup, yVar, wsVar, str, i);
        this.ra = false;
        this.dk = new ai(Looper.getMainLooper(), this);
        this.x = true;
        this.ai = new AtomicBoolean();
        this.f10434io = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void d() {
    }

    public void e() {
        ScrollView scrollView = new ScrollView(this.hf);
        LinearLayout linearLayout = new LinearLayout(this.hf);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.hf);
        jk.xj(this.hf, "tt_ecomm_page_backup_img", imageView);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        imageView.setScaleType(scaleType);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = r.w(this.hf, 10.0f);
        layoutParams.leftMargin = r.w(this.hf, 10.0f);
        layoutParams.rightMargin = r.w(this.hf, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.hf);
        imageView2.setScaleType(scaleType);
        jk.xj(this.hf, "tt_ecomm_page_backup_img", imageView2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = r.w(this.hf, 10.0f);
        layoutParams2.leftMargin = r.w(this.hf, 10.0f);
        layoutParams2.rightMargin = r.w(this.hf, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.w.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void f() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int hf() {
        return 0;
    }

    public void jk() {
        this.dk.removeMessages(10082);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void kd() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void p() {
    }

    public void pz() {
        if (tf.hf(this.kd)) {
            this.dk.sendEmptyMessageDelayed(10081, PushUIConfig.dismissTime);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void tf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void u() {
    }

    public void v() {
        Handler handler = this.dk;
        if (handler != null) {
            handler.removeMessages(10081);
            this.dk.removeMessages(10082);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int w() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long xj() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void y() {
    }

    public void yo() {
        v();
        if (this.x) {
            this.x = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.f10434io);
                jSONObject.put(PointCategory.END, System.currentTimeMillis());
            } catch (JSONException e) {
                pl.xj(e);
            }
            com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.hf.3
                @Override // com.bytedance.sdk.openadsdk.y.xj.xj
                public void xj(JSONObject jSONObject2) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.xj
    public void zg() {
        super.zg();
        com.bytedance.sdk.openadsdk.core.playable.hf.xj().hf(this.kd);
        v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.xj
    public void g() {
        try {
            this.qt = tf.xj(this.kd);
            JSONObject pn = this.kd.pn();
            this.et = new com.bytedance.sdk.openadsdk.core.jk.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.hf.1
                @Override // com.bytedance.sdk.openadsdk.core.jk.w
                public void xj(boolean z, List<ws> list, boolean z2) {
                    if (!z) {
                        if (((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).pz.get() > 0) {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).pz.get();
                            ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).pz.decrementAndGet();
                            hf.this.g();
                            return;
                        } else {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).u.xj(-3, "ad meta info load fail");
                            if (((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).y != null) {
                                ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).y.xj(-3);
                                return;
                            }
                            return;
                        }
                    }
                    if (list != null && list.size() > 0) {
                        hf.this.hf(list);
                        return;
                    }
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).pz.get() <= 0) {
                        if (((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).y != null) {
                            ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).y.xj(-2);
                        }
                    } else {
                        ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).pz.get();
                        ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).pz.decrementAndGet();
                        hf.this.g();
                    }
                }
            };
            ws wsVar = this.kd;
            if (wsVar != null) {
                if (wsVar.ai() != null) {
                    if (this.kd.ai().w() != null) {
                        if (this.kd.ai().w().optInt("use_gnd_prefetch", 0) == 1) {
                        }
                        ws wsVar2 = this.kd;
                        com.bytedance.sdk.openadsdk.core.et.hf.xj(wsVar2, pn, this.et, wsVar2.gh());
                    }
                }
            }
            if (com.bytedance.sdk.openadsdk.core.playable.hf.xj().xj(this.kd, this.et)) {
                return;
            }
            ws wsVar22 = this.kd;
            com.bytedance.sdk.openadsdk.core.et.hf.xj(wsVar22, pn, this.et, wsVar22.gh());
        } catch (Exception e) {
            if (this.pz.get() > 0) {
                this.pz.get();
                this.pz.decrementAndGet();
                g();
            } else {
                this.u.xj(-3, e.getMessage());
                com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar = this.y;
                if (xjVar != null) {
                    xjVar.xj(-3);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void hf(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.xj
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> pl() {
        this.d = new ArrayList();
        JSONObject ac = this.kd.ac();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "android");
            ac.put("env_info", jSONObject);
        } catch (JSONException e) {
            pl.xj(e);
        }
        this.d.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w(ac, -2134548432));
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void u(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void w(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void kd(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        JSONObject tf;
        if (wVar == null || (tf = wVar.tf()) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w<View> u = wVar.u("video_".concat(String.valueOf(tf.optInt("image_mode"))));
        if (u instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) u;
            this.ht = hfVar;
            hfVar.u(this.ra);
            this.ht.tu();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void y(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        JSONObject tf;
        if (wVar == null || (tf = wVar.tf()) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w<View> u = wVar.u("video_".concat(String.valueOf(tf.optInt("image_mode"))));
        if (u instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) u).qd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(List<ws> list) {
        this.zg = list.size();
        this.e = list.size();
        this.yo = qt();
        ws wsVar = list.get(0);
        if (wsVar != null) {
            this.am = wsVar.pn();
        }
        this.d = xj(list);
        kd.xj(this.xj, new kd.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.hf.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.kd.xj
            public void xj(JSONObject jSONObject) {
                if (jSONObject != null) {
                    hf hfVar = hf.this;
                    hfVar.xj(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w>) ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hfVar).d);
                } else {
                    ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).u.xj(-1, "template info load fail");
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).y != null) {
                        ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) hf.this).y.xj(-1);
                    }
                }
            }
        });
    }

    public void u(int i) {
        if (i == 0) {
            if (this.ai.get()) {
                return;
            }
            this.dk.sendEmptyMessageDelayed(10081, PushUIConfig.dismissTime);
            return;
        }
        if (this.ai.get()) {
            com.bytedance.sdk.openadsdk.core.ugeno.c.hf hfVar = this.v;
            if (hfVar != null) {
                hfVar.hf();
            }
            this.ai.set(false);
        }
        this.dk.removeMessages(10081);
        this.dk.removeMessages(10082);
    }

    public void w(boolean z) {
        this.ra = z;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = this.ht;
        if (hfVar != null) {
            hfVar.u(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.w
    public void w(com.bytedance.adsdk.ugeno.hf.w wVar) {
        ws xj;
        if (wVar == null) {
            return;
        }
        if (wVar.tf().has("ugen_sub_meta")) {
            xj = com.bytedance.sdk.openadsdk.core.xj.xj(wVar.tf().optJSONObject("ugen_sub_meta"));
        } else {
            xj = com.bytedance.sdk.openadsdk.core.xj.xj(wVar.tf());
        }
        if (xj != null) {
            xj(xj, wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void xj(int i, int i2) {
        if (i2 > 0) {
            this.tf.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void xj(RecyclerView recyclerView, int i) {
        if (tf.hf(this.kd)) {
            u(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, int i, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w wVar2) {
        if (wVar2 == null || wVar2.xj() == null) {
            return;
        }
        int hashCode = wVar2.xj().hashCode();
        if (this.p.get(Integer.valueOf(hashCode)) != null && this.p.containsKey(Integer.valueOf(hashCode)) && this.p.get(Integer.valueOf(hashCode)).booleanValue()) {
            return;
        }
        xj(wVar2.xj());
        if (i == this.yo) {
            xj(wVar);
        }
        this.p.put(Integer.valueOf(hashCode), Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("is_slide", 1);
        } catch (JSONException e) {
            pl.xj(e);
        }
        if (this.tf.get() == 1) {
            com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, this.f10427pl, "ugeno_coin_eCommerce_is_slide", jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(int i) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = this.ht;
        if (hfVar == null) {
            pl.u("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i == 2) {
            hfVar.dq();
        } else if (i == 3) {
            hfVar.s();
        }
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i = message.what;
        if (i != 10081) {
            if (i != 10082) {
                return;
            }
            if (this.ai.get()) {
                xj(jk.xj(this.hf, "tt_ecomm_page_reward_slide_tip"));
                this.dk.sendEmptyMessageDelayed(10082, 6000L);
                return;
            } else {
                this.dk.removeMessages(10082);
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.c.hf hfVar = this.v;
        if (hfVar != null) {
            hfVar.xj();
            this.ai.set(true);
            xj(jk.xj(this.hf, "tt_ecomm_page_reward_slide_tip"));
            this.dk.sendEmptyMessageDelayed(10082, 6000L);
        }
    }

    public void xj(String str) {
        ViewGroup viewGroup = this.w;
        if (viewGroup == null || !viewGroup.isShown()) {
            return;
        }
        x.hf(this.hf, str, 0, 49, 0, 60);
    }
}
