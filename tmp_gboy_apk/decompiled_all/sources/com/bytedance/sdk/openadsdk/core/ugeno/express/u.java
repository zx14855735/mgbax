package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.d;
import com.bytedance.adsdk.ugeno.w.jk;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.adexpress.hf.f;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.openadsdk.core.a.l;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.common.a;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements jk, yo, com.bytedance.sdk.component.adexpress.dynamic.u, com.bytedance.sdk.component.adexpress.hf.u<View> {
    protected com.bytedance.adsdk.ugeno.hf.w am;
    protected hf c;
    protected f d;
    protected UGTimerContainer f;
    protected WeakReference<ViewGroup> g;
    protected Context hf;
    private String ht;
    private List<com.bytedance.adsdk.ugeno.hf.w<View>> jk;
    protected JSONObject kd;
    protected am p;
    private String pz;
    protected com.bytedance.adsdk.ugeno.hf.w qt;
    private boolean ra;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.f tf;
    protected JSONObject u;
    protected com.bytedance.sdk.openadsdk.core.ugeno.tf.xj v;
    protected com.bytedance.adsdk.ugeno.hf.w<View> w;
    protected qt xj;
    protected ws y;
    protected ht yo;
    protected c zg;

    /* renamed from: pl, reason: collision with root package name */
    protected tf f10435pl = new tf();
    protected AtomicBoolean e = new AtomicBoolean(false);

    public u(Context context, ws wsVar, hf hfVar, ViewGroup viewGroup) {
        JSONObject optJSONObject;
        this.ra = false;
        this.hf = context;
        this.xj = new qt(context);
        this.y = wsVar;
        this.c = hfVar;
        this.f = new UGTimerContainer(context);
        this.g = new WeakReference<>(viewGroup);
        JSONObject xj = xj();
        this.u = xj;
        if (wsVar != null && xj != null && (optJSONObject = xj.optJSONObject("event_template")) != null) {
            this.ra = true;
            com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(optJSONObject);
        }
        if (com.bytedance.sdk.openadsdk.kd.xj.u(wsVar)) {
            this.xj.xj(new com.bytedance.adsdk.ugeno.w.f() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.u.1
                @Override // com.bytedance.adsdk.ugeno.w.f
                public void hf(d.xj xjVar) {
                    com.bytedance.sdk.openadsdk.kd.xj.xj(false, xjVar);
                }

                @Override // com.bytedance.adsdk.ugeno.w.f
                public void xj(d.xj xjVar) {
                    com.bytedance.sdk.openadsdk.kd.xj.xj(true, xjVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int am() {
        ws wsVar = this.y;
        if (wsVar != null) {
            return wsVar.kd();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    public View c() {
        return this.f;
    }

    public boolean d() {
        return this.ra;
    }

    public List<com.bytedance.adsdk.ugeno.hf.w<View>> f() {
        return this.jk;
    }

    public void g() {
        com.bytedance.adsdk.ugeno.hf.w<View> u;
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.w;
        if (wVar == null || (u = wVar.u("corver_container")) == null || u.d() == null) {
            return;
        }
        u.d().setVisibility(8);
    }

    public void hf() {
        List<com.bytedance.adsdk.ugeno.hf.w<View>> list = this.jk;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.hf.w<View>> it = this.jk.iterator();
        while (it.hasNext()) {
            it.next().tj();
        }
    }

    public com.bytedance.adsdk.ugeno.hf.w kd() {
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.w;
        if (wVar == null) {
            return null;
        }
        return wVar.kd("VideoPlaceholder");
    }

    public void p() {
        this.e.set(false);
        ht htVar = this.yo;
        if (htVar != null) {
            htVar.hf(am());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xjVar = this.v;
        if (xjVar != null) {
            xjVar.hf();
        }
    }

    public void pl() {
        com.bytedance.adsdk.ugeno.hf.w<View> u;
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.w;
        if (wVar == null || (u = wVar.u("corver_container")) == null || u.d() == null) {
            return;
        }
        u.d().setVisibility(0);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u
    public void setSoundMute(boolean z) {
        com.bytedance.adsdk.ugeno.hf.w<View> u;
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.w;
        if (wVar == null || (u = wVar.u("mute_image")) == null) {
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(this.pz)) {
                ((com.bytedance.adsdk.ugeno.widget.image.hf) u).pl(this.pz);
            }
        } else if (!TextUtils.isEmpty(this.ht)) {
            ((com.bytedance.adsdk.ugeno.widget.image.hf) u).pl(this.ht);
        }
        u.hf();
    }

    public JSONObject tf() {
        return this.c.en();
    }

    public float[] u() {
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.w;
        if (wVar == null) {
            return null;
        }
        com.bytedance.adsdk.ugeno.hf.w<View> kd = wVar.kd("InteractContainerView");
        if (kd instanceof p) {
            return ((p) kd).s();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    public int w() {
        return hl.hf(this.y);
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
    }

    public com.bytedance.adsdk.ugeno.hf.w y() {
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.w;
        if (wVar == null) {
            return null;
        }
        return wVar.kd("PlayableComponent");
    }

    private void w(zg zgVar) {
        JSONObject w;
        if (zgVar == null || (w = zgVar.w()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(this.y, w.optString("uttieUrl"), w.optLong(MediationConstant.EXTRA_DURATION));
    }

    public void hf(com.bytedance.sdk.component.adexpress.hf.c cVar) {
        this.xj.xj((yo) this);
        this.xj.xj((jk) this);
        this.w = this.xj.xj(this.u);
        this.c.l().hf();
        this.c.l().w();
        this.xj.hf(this.kd);
    }

    public void xj(f fVar) {
        this.d = fVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.f fVar) {
        this.tf = fVar;
    }

    private boolean u(zg zgVar) {
        JSONObject w;
        return zgVar != null && zgVar.hf() == 1 && (w = zgVar.w()) != null && w.optBoolean("lottieEvent", false);
    }

    private void w(final zg zgVar, final yo.hf hfVar, final yo.xj xjVar) {
        if (this.yo == null) {
            ht htVar = new ht(pz.getContext(), 2, this.c.d());
            this.yo = htVar;
            htVar.xj(this.y.ee());
            this.yo.w(this.y.pw());
            this.yo.hf(this.y.ky());
            this.yo.xj(this.y.ki());
            this.yo.y(this.y.oa());
            this.yo.kd(this.y.le());
            this.yo.hf(this.y.eg());
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final float[] fArr = {0.0f};
        this.yo.xj(new ht.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.u.2
            @Override // com.bytedance.sdk.component.utils.ht.xj
            public void xj(int i) {
                if (i != 2) {
                    return;
                }
                u uVar = u.this;
                uVar.yo.hf(uVar.am());
                fArr[0] = 0.0f;
                View d = ((com.bytedance.adsdk.ugeno.hf.w) hfVar).d();
                if (d != null) {
                    d.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.u.2.1
                        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                        public void onWindowFocusChanged(boolean z) {
                            if (z) {
                                u uVar2 = u.this;
                                uVar2.yo.xj(uVar2.am());
                            } else {
                                u uVar3 = u.this;
                                uVar3.yo.hf(uVar3.am());
                                fArr[0] = 0.0f;
                            }
                        }
                    });
                }
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(true);
                }
                u.this.xj(zgVar, hfVar, xjVar, 2);
            }
        });
        this.yo.xj(new ht.hf() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.u.3
            float xj = 0.0f;
            float hf = 0.0f;
            float w = 0.0f;
            float u = 0.0f;
            float kd = 0.0f;
            float y = 0.0f;
            long c = System.currentTimeMillis();

            @Override // com.bytedance.sdk.component.utils.ht.hf
            public void xj(float f, float f2, float f3) {
                JSONObject w;
                View d;
                boolean z;
                float f4;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.c < 100) {
                    return;
                }
                this.c = currentTimeMillis;
                zg zgVar2 = zgVar;
                if (zgVar2 == null || (w = zgVar2.w()) == null) {
                    return;
                }
                double optDouble = w.optDouble("rotateZ", -1.0d);
                if (optDouble == -1.0d) {
                    return;
                }
                yo.hf hfVar2 = hfVar;
                if ((hfVar2 instanceof com.bytedance.adsdk.ugeno.hf.w) && (d = ((com.bytedance.adsdk.ugeno.hf.w) hfVar2).d()) != null && d.isShown()) {
                    float abs = Math.abs(f);
                    float abs2 = Math.abs(f2);
                    float abs3 = Math.abs(f3);
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    float f5 = 0.0f;
                    if (atomicBoolean2 != null && atomicBoolean2.get()) {
                        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f) {
                            atomicBoolean.set(false);
                        }
                        this.xj = abs;
                        this.hf = abs2;
                        this.w = abs3;
                        this.u = f;
                        this.kd = f2;
                        this.y = f3;
                        return;
                    }
                    float max = Math.max(Math.abs(abs - this.xj), Math.max(Math.abs(abs2 - this.hf), Math.abs(abs3 - this.w)));
                    int ky = u.this.y.ky();
                    if (ky <= 0) {
                        ky = 50;
                    }
                    if (Math.abs(abs - this.xj) == max) {
                        f5 = f >= this.u ? max : -max;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (Math.abs(abs2 - this.hf) == max) {
                        f5 = f2 >= this.kd ? max : -max;
                        z = true;
                    }
                    if (Math.abs(abs3 - this.w) == max) {
                        if (f3 < this.y) {
                            max = -max;
                        }
                        f5 = max;
                    }
                    if (u.this.y.oa() == 0) {
                        f4 = (float) Math.ceil((f5 * 180.0f) / optDouble);
                    } else {
                        double degrees = Math.toDegrees(f5);
                        float ceil = (float) Math.ceil(degrees / optDouble);
                        if (z && Math.abs(degrees) < ky - 8) {
                            return;
                        } else {
                            f4 = z ? -Math.abs(ceil) : ceil;
                        }
                    }
                    if (Math.abs(f4 - fArr[0]) < 1.3d) {
                        return;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(d, a.B, fArr[0], f4);
                    ofFloat.setInterpolator(new LinearInterpolator());
                    ofFloat.setDuration(100L);
                    ofFloat.start();
                    fArr[0] = f4;
                }
            }
        });
        this.yo.xj(am());
    }

    private void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar, List<com.bytedance.adsdk.ugeno.hf.w<View>> list) {
        if (wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) {
            if (wVar.xj(4)) {
                list.add(wVar);
            }
            List<com.bytedance.adsdk.ugeno.hf.w<View>> c = ((com.bytedance.adsdk.ugeno.hf.xj) wVar).c();
            if (c == null || c.size() == 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.hf.w<View>> it = c.iterator();
            while (it.hasNext()) {
                xj(it.next(), list);
            }
            return;
        }
        if (wVar == null || !wVar.xj(4)) {
            return;
        }
        list.add(wVar);
    }

    private void u(final zg zgVar, final yo.hf hfVar, final yo.xj xjVar) {
        WeakReference<ViewGroup> weakReference = this.g;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        l.xj(this.g, new com.bytedance.sdk.openadsdk.core.hf.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.u.4
            @Override // com.bytedance.sdk.openadsdk.core.hf.w
            public void xj() {
                WeakReference<ViewGroup> weakReference2 = u.this.g;
                if (weakReference2 == null || weakReference2.get() == null || !l.xj(u.this.g.get())) {
                    return;
                }
                u.this.xj(zgVar, hfVar, xjVar, 1);
            }
        });
    }

    private void hf(zg zgVar) {
        JSONObject w;
        if (zgVar == null || (w = zgVar.w()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(this.y, w.optString("uttieUrl"));
    }

    private void hf(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        JSONObject w = zgVar.w();
        if (w == null) {
            return;
        }
        String optString = w.optString(PointParamKey.TYPE, null);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        optString.getClass();
        if (optString.equals("clickEvent")) {
            xj(zgVar, hfVar, xjVar, 0);
            return;
        }
        if (optString.equals("close")) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.f fVar = this.tf;
            if (fVar != null) {
                fVar.xj();
            }
            com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(this.y, w.optString("uttieUrl"));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    public void xj(com.bytedance.sdk.component.adexpress.hf.c cVar) {
        this.c.l().xj();
        this.u = xj();
        JSONObject tf = tf();
        this.kd = tf;
        if (this.u != null && tf != null) {
            hf(cVar);
            if (this.w != null) {
                w wVar = new w();
                this.p = wVar;
                wVar.xj(true);
                this.p.xj(w());
                com.bytedance.adsdk.ugeno.hf.w kd = kd();
                this.am = kd;
                if (kd != null && (kd instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.u.xj)) {
                    ((w) this.p).xj((FrameLayout) kd.d());
                }
                com.bytedance.adsdk.ugeno.hf.w y = y();
                this.qt = y;
                if (y != null && (y instanceof com.bytedance.adsdk.ugeno.widget.frame.xj)) {
                    ((w) this.p).hf((FrameLayout) y.d());
                }
                am amVar = this.p;
                if (amVar instanceof w) {
                    ((w) amVar).xj(this.v);
                }
                this.f.setTimerHolder(this.v);
                int l = this.w.l();
                int ff = this.w.ff();
                ArrayList arrayList = new ArrayList();
                this.jk = arrayList;
                xj(this.w, arrayList);
                View d = this.w.d();
                ViewGroup viewGroup = (ViewGroup) d.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(d);
                }
                this.f.addView(this.w.d(), new FrameLayout.LayoutParams(l, ff));
                float z = this.c.z();
                float j = this.c.j();
                float w = r.w(this.hf, z);
                float w2 = r.w(this.hf, j);
                int u = r.u(this.hf);
                int p = (int) (r.p(this.hf) + r.d(this.hf));
                float f = u;
                if (w > f) {
                    w = f;
                }
                float f2 = p;
                if (w2 > f2) {
                    w2 = f2;
                }
                if (j <= 0.0f) {
                    this.f.setLayoutParams(new FrameLayout.LayoutParams((int) w, -2));
                } else {
                    this.f.setLayoutParams(new FrameLayout.LayoutParams((int) w, (int) w2));
                }
                if (j <= 0.0f) {
                    this.f.measure(View.MeasureSpec.makeMeasureSpec((int) w, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                    int u2 = r.u(this.hf, this.f.getMeasuredWidth());
                    int u3 = r.u(this.hf, this.f.getMeasuredHeight());
                    this.p.xj(u2);
                    this.p.hf(u3);
                } else {
                    this.p.xj(r.u(this.hf, w));
                    this.p.hf(r.u(this.hf, w2));
                }
                if (this.e.get()) {
                    cVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, (String) null);
                    return;
                } else {
                    cVar.xj(this.f, this.p);
                    return;
                }
            }
            cVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, (String) null);
            return;
        }
        cVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, (String) null);
    }

    private void w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.w.xj(optJSONObject, this.hf, this.y);
    }

    private void hf(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.hf.w<View> wVar;
        com.bytedance.adsdk.ugeno.hf.w u;
        if (jSONObject == null) {
            return;
        }
        String xj = com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString(PointParamKey.TYPE), tf());
        String xj2 = com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("nodeId"), tf());
        if (TextUtils.isEmpty(xj2) || (wVar = this.w) == null || (u = wVar.hf(wVar).u(xj2)) == null) {
            return;
        }
        if (TextUtils.equals(xj, "onDismiss")) {
            u.hf(8);
        } else if (TextUtils.equals(xj, "onShow")) {
            u.hf(0);
        } else if (TextUtils.equals(xj, "haptic")) {
            w(jSONObject);
        }
    }

    public JSONObject xj() {
        return this.c.kd();
    }

    public void xj(boolean z) {
        this.e.set(z);
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        if (zgVar == null) {
            return;
        }
        if (zgVar.hf() == 18) {
            w(zgVar, hfVar, xjVar);
        } else if (zgVar.hf() == 3) {
            u(zgVar, hfVar, xjVar);
        } else if (zgVar.hf() == 9) {
            hf(zgVar.w());
        } else if (zgVar.hf() == 10) {
            xj(zgVar.w());
        } else if (zgVar.hf() == 21) {
            hf(zgVar);
        } else if (zgVar.hf() == 19) {
            w(zgVar);
        } else if (zgVar.hf() != 20) {
            if (u(zgVar)) {
                hf(zgVar, hfVar, xjVar);
            } else if (zgVar.hf() == 22) {
                xj(zgVar);
            } else {
                xj(zgVar, hfVar, xjVar, 0);
            }
        }
        if (zgVar.w() != null) {
            String optString = zgVar.w().optString("next");
            try {
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                zg zgVar2 = new zg();
                zgVar2.xj(1);
                zgVar2.xj(new JSONObject(optString));
                zgVar2.xj(this.w);
                xj(zgVar2, (yo.hf) null, (yo.xj) null);
            } catch (JSONException unused) {
            }
        }
    }

    private void xj(zg zgVar) {
        JSONObject w;
        if (zgVar == null || (w = zgVar.w()) == null) {
            return;
        }
        String optString = w.optString(PointParamKey.TYPE);
        String optString2 = w.optString("uchain");
        JSONObject optJSONObject = w.optJSONObject("params");
        JSONObject jSONObject = new JSONObject();
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject.put(next, com.bytedance.adsdk.ugeno.u.hf.xj(optJSONObject.optString(next), tf()));
                } catch (Throwable unused) {
                }
            }
        }
        if ("true".equals(optString2)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("material_meta", this.y);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("ugen_event_params", jSONObject);
            String hf = wo.hf(this.y);
            wo.x();
            com.bytedance.sdk.openadsdk.core.d.xj.u.xj.xj(this.y, hashMap, optString, hashMap2, hf, hashMap3);
        }
    }

    private void xj(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.hf.w<View> wVar;
        com.bytedance.adsdk.ugeno.hf.w u;
        if (jSONObject == null) {
            return;
        }
        String xj = com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString(PointParamKey.TYPE), tf());
        String xj2 = com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("nodeId"), tf());
        if (TextUtils.isEmpty(xj2) || (wVar = this.w) == null || (u = wVar.hf(wVar).u(xj2)) == null) {
            return;
        }
        if (TextUtils.equals(xj, "onShow")) {
            u.hf(0);
        } else if (TextUtils.equals(xj, "onDismiss")) {
            u.hf(8);
        } else if (TextUtils.equals(xj, "haptic")) {
            w(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(zg zgVar, yo.hf hfVar, yo.xj xjVar, int i) {
        com.bytedance.adsdk.ugeno.hf.w xj;
        int i2;
        String str;
        JSONObject en;
        CharSequence text;
        if (zgVar == null || (xj = zgVar.xj()) == null) {
            return;
        }
        JSONObject w = zgVar.w();
        String xj2 = com.bytedance.adsdk.ugeno.u.hf.xj(w.optString("nodeId"), tf());
        String xj3 = com.bytedance.adsdk.ugeno.u.hf.xj(w.optString(PointParamKey.TYPE), tf());
        int i3 = -1;
        if (TextUtils.equals(xj3, "clickEvent")) {
            str = w.optString("subConvertLinkTag");
            i3 = w.optInt("dpaPosition", -1);
            i2 = 2;
        } else {
            if (TextUtils.equals(xj3, "muteVideo")) {
                this.pz = w.optString("muteSrc");
                this.ht = w.optString("unmuteSrc");
                i2 = 5;
            } else if (TextUtils.equals(xj3, PointCategory.DISLIKE)) {
                i2 = 3;
            } else if (TextUtils.equals(xj3, "skip")) {
                i2 = 6;
            } else if (TextUtils.equals(xj3, "openPolicy")) {
                i2 = 7;
            } else if (TextUtils.equals(xj3, "openAppPolicy")) {
                i2 = 9;
            } else if (TextUtils.equals(xj3, "openAppPermission")) {
                i2 = 10;
            } else if (TextUtils.equals(xj3, "close")) {
                str = "";
                i2 = 8;
            } else if (TextUtils.equals(xj3, "openAppFunctionDesc")) {
                i2 = 12;
            } else if (TextUtils.equals(xj3, "videoControl") || TextUtils.equals(xj3, "pauseVideo")) {
                i2 = 4;
            } else if (TextUtils.equals(xj3, "openCommonUrl")) {
                i2 = 13;
            } else {
                if (TextUtils.equals(xj3, "onDismiss")) {
                    com.bytedance.adsdk.ugeno.hf.w u = zgVar.xj().hf(zgVar.xj()).u(xj2);
                    if (u != null) {
                        u.hf(8);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(xj3, "onShow")) {
                    com.bytedance.adsdk.ugeno.hf.w u2 = zgVar.xj().hf(zgVar.xj()).u(xj2);
                    if (u2 != null) {
                        u2.hf(0);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(xj3, "haptic")) {
                    w(zgVar.w());
                    return;
                }
                if (TextUtils.equals(xj3, "closeWidget")) {
                    this.zg.kd();
                    return;
                } else if (TextUtils.equals(xj3, "dismiss")) {
                    xj.hf(8);
                    return;
                } else {
                    str = "";
                    i2 = 0;
                }
            }
            str = "";
        }
        ra.xj kd = new ra.xj().u(this.f10435pl.am()).w(this.f10435pl.qt()).hf(this.f10435pl.zg()).xj(this.f10435pl.e()).xj(xj.j()).hf(this.f10435pl.pl()).xj(this.f10435pl.g()).kd(str).kd(i3);
        JSONObject jSONObject = new JSONObject();
        if (i > 0) {
            try {
                jSONObject.put("convertActionType", i);
            } catch (Throwable unused) {
            }
        }
        View d = xj.d();
        try {
            if ((d instanceof TextView) && (text = ((TextView) d).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        try {
            if (this.y != null && this.ra && w.optBoolean("uchain", false)) {
                jSONObject.put("uchain_event_name", xj3);
            }
        } catch (JSONException unused3) {
        }
        try {
            hf hfVar2 = this.c;
            if (hfVar2 != null && (en = hfVar2.en()) != null) {
                jSONObject.put("ugen_id", en.optString("ugen_id"));
            }
        } catch (JSONException unused4) {
        }
        try {
            String xj4 = com.bytedance.adsdk.ugeno.u.hf.xj(w.optString("webUrl"), tf());
            String xj5 = com.bytedance.adsdk.ugeno.u.hf.xj(w.optString("webTitle"), tf());
            jSONObject.put("openCommonWebUrl", xj4);
            jSONObject.put("openCommonWebTitle", xj5);
        } catch (JSONException unused5) {
        }
        kd.xj(jSONObject);
        ra xj6 = kd.xj();
        f fVar = this.d;
        if (fVar != null) {
            fVar.xj(d, i2, xj6);
        }
        if (hfVar == null || zgVar.u() == null) {
            return;
        }
        hfVar.xj(zgVar.u());
    }

    public void xj(c cVar) {
        this.zg = cVar;
    }

    public void xj(long j, long j2) {
        com.bytedance.adsdk.ugeno.hf.w wVar = this.am;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.u.xj) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.u.xj) wVar).xj(j, j2);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u
    public void xj(CharSequence charSequence, int i, int i2, boolean z) {
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.w;
        if (wVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w<View> u = wVar.u("count_down_skip_container");
        if (u != null && u.d() != null) {
            u.d().setVisibility(0);
        }
        com.bytedance.adsdk.ugeno.hf.w<View> u2 = this.w.u("count_down");
        com.bytedance.adsdk.ugeno.hf.w<View> u3 = this.w.u("skip");
        if ((u2 instanceof com.bytedance.adsdk.ugeno.widget.text.hf) && (u3 instanceof com.bytedance.adsdk.ugeno.widget.text.hf)) {
            if (i2 != 0) {
                ((com.bytedance.adsdk.ugeno.widget.text.hf) u2).p(((Object) charSequence) + "s ");
                return;
            }
            if (!TextUtils.equals(charSequence, Constants.FAIL) && !z) {
                ((com.bytedance.adsdk.ugeno.widget.text.hf) u2).p(((Object) charSequence) + "s ");
                com.bytedance.adsdk.ugeno.widget.text.hf hfVar = (com.bytedance.adsdk.ugeno.widget.text.hf) u3;
                hfVar.p("| 跳过");
                hfVar.d().setVisibility(0);
                return;
            }
            ((com.bytedance.adsdk.ugeno.widget.text.hf) u2).d().setVisibility(8);
            ((com.bytedance.adsdk.ugeno.widget.text.hf) u3).p("跳过");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.jk
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return;
            }
            this.f10435pl.w(motionEvent.getRawX());
            this.f10435pl.u(motionEvent.getRawY());
            this.f10435pl.hf(System.currentTimeMillis());
            return;
        }
        this.f10435pl.kd((int) motionEvent.getRawX());
        this.f10435pl.y((int) motionEvent.getRawY());
        this.f10435pl.xj(motionEvent.getRawX());
        this.f10435pl.hf(motionEvent.getRawY());
        this.f10435pl.xj(System.currentTimeMillis());
        this.f10435pl.hf(motionEvent.getToolType(0));
        this.f10435pl.w(motionEvent.getDeviceId());
        this.f10435pl.u(motionEvent.getSource());
    }
}
