package com.bytedance.sdk.openadsdk.core.ugeno.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.yo;
import com.bytedance.sdk.openadsdk.core.hf.xj.hf.w;
import com.bytedance.sdk.openadsdk.core.nativeexpress.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.g;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.c.kd;
import com.bytedance.sdk.openadsdk.core.ugeno.d.w;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import com.sigmob.sdk.base.common.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements tf, f, u, w {
    protected JSONObject am;
    protected com.bytedance.adsdk.ugeno.hf.w<View> c;
    protected List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> d;
    private y dk;
    protected int e;
    private FrameLayout et;
    protected com.bytedance.adsdk.ugeno.hf.w<View> f;
    protected Map<String, Object> g;
    protected Context hf;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10426io;
    protected InterfaceC0184xj jk;
    protected ws kd;

    /* renamed from: pl, reason: collision with root package name */
    protected String f10427pl;
    protected int qt;
    protected com.bytedance.sdk.openadsdk.core.am.y u;
    protected hf v;
    protected ViewGroup w;
    protected com.bytedance.sdk.openadsdk.core.ugeno.y.xj xj;
    protected com.bytedance.sdk.openadsdk.core.ugeno.u.xj y;
    protected int yo;
    protected int zg;
    private boolean ht = true;
    private boolean ra = true;
    protected AtomicInteger pz = new AtomicInteger(2);
    protected AtomicInteger tf = new AtomicInteger();
    protected Map<Integer, Boolean> p = new HashMap();

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.c.xj$6, reason: invalid class name */
    public class AnonymousClass6 extends d {
        final /* synthetic */ com.bytedance.adsdk.ugeno.hf.w xj;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(String str, com.bytedance.adsdk.ugeno.hf.w wVar) {
            super(str);
            this.xj = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            xj xjVar = xj.this;
            com.bytedance.sdk.openadsdk.core.et.hf.xj(xjVar.kd, xjVar.am, new com.bytedance.sdk.openadsdk.core.jk.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.6.1
                @Override // com.bytedance.sdk.openadsdk.core.jk.w
                public void xj(boolean z, List<ws> list, boolean z2) {
                    if (list == null || list.size() <= 0) {
                        if (xj.this.pz.get() > 0) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            xj.this.xj(anonymousClass6.xj);
                            xj.this.pz.decrementAndGet();
                            return;
                        } else {
                            InterfaceC0184xj interfaceC0184xj = xj.this.jk;
                            if (interfaceC0184xj != null) {
                                interfaceC0184xj.xj();
                                return;
                            }
                            return;
                        }
                    }
                    xj.this.zg = list.size();
                    xj xjVar2 = xj.this;
                    xjVar2.e = list.size() + xjVar2.e;
                    xj xjVar3 = xj.this;
                    xjVar3.yo = xjVar3.qt();
                    ws wsVar = list.get(0);
                    if (wsVar != null) {
                        xj.this.am = wsVar.pn();
                    }
                    final List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> xj = xj.this.xj(list);
                    v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.adsdk.ugeno.hf.w wVar = AnonymousClass6.this.xj;
                            if (wVar == null || !(wVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y)) {
                                return;
                            }
                            ((com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) wVar).hf(xj);
                        }
                    });
                }
            }, xj.this.kd.gh());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.c.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0184xj {
        void xj();
    }

    public xj(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.am.y yVar, ws wsVar, String str, int i) {
        this.hf = context;
        this.w = viewGroup;
        this.u = yVar;
        this.kd = wsVar;
        this.f10427pl = str;
        this.xj = wsVar.x();
        y yVar2 = new y(this.hf, this.u, wsVar, str, i);
        this.dk = yVar2;
        yVar2.xj((u) this);
        this.dk.xj((w) this);
        if (this.kd.m() != null) {
            this.dk.xj((f) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public View e() {
        this.et = new FrameLayout(this.hf);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.et.setBackground(gradientDrawable);
        final GifView gifView = new GifView(this.hf);
        com.bytedance.sdk.openadsdk.f.hf.xj(com.bytedance.sdk.openadsdk.core.f.w.xj("shop_page_guide_gif.gif")).type(3).config(Bitmap.Config.RGB_565).to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.3
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg zgVar) {
                Object result = zgVar.getResult();
                try {
                    if (result instanceof byte[]) {
                        if (zgVar.isGif()) {
                            gifView.xj((byte[]) result, false);
                        } else {
                            gifView.setImageDrawable(yo.xj((byte[]) result, 0));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
        int w = r.w(this.hf, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(w, w);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = r.w(this.hf, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.et.addView(gifView);
        TextView textView = new TextView(this.hf);
        textView.setText("需要浏览页面才能领取奖励");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = r.w(this.hf, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.et.addView(textView);
        this.et.setOnTouchListener(new com.bytedance.sdk.openadsdk.core.ugeno.d.w(this.hf, new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.w.xj
            public void hf() {
                xj.this.et.setVisibility(8);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.w.xj
            public void xj() {
                com.bytedance.adsdk.ugeno.hf.w<View> wVar = xj.this.f;
                if ((wVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) && wVar.d() != null) {
                    ((RecyclerView) xj.this.f.d()).hf(1);
                }
                xj xjVar = xj.this;
                xjVar.xj(xjVar.f);
                xj.this.et.setVisibility(8);
                com.bytedance.sdk.openadsdk.core.am.u.xj(xj.this.kd, "landingpage", "in_web_click", (com.bytedance.sdk.openadsdk.y.xj.xj) null);
            }
        }, 200));
        this.et.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.5
            @Override // java.lang.Runnable
            public void run() {
                xj.this.et.setVisibility(8);
            }
        }, 3000L);
        return this.et;
    }

    public boolean am() {
        com.bytedance.adsdk.ugeno.hf.w<View> u;
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.c;
        return (wVar == null || (u = wVar.u("interactionWebView")) == null || u.d() == null || u.d().getVisibility() != 0) ? false : true;
    }

    public void g() {
        try {
            this.d = pl();
            kd.xj(this.xj, new kd.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.kd.xj
                public void xj(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        xj xjVar = xj.this;
                        xjVar.xj(jSONObject, xjVar.d);
                        return;
                    }
                    xj.this.u.xj(-1, "template info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar2 = xj.this.y;
                    if (xjVar2 != null) {
                        xjVar2.xj(-1);
                    }
                }
            });
        } catch (Exception e) {
            this.u.xj(-3, e.getMessage());
            com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar = this.y;
            if (xjVar != null) {
                xjVar.xj(-3);
            }
        }
    }

    public abstract List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> pl();

    public int qt() {
        int i = this.zg;
        int i2 = this.qt;
        return Math.max(i < i2 ? this.e - i : this.e - i2, 0);
    }

    public void zg() {
        ws wsVar = this.kd;
        ff.hf(wsVar != null ? wsVar.kd() : 0);
    }

    public void hf(boolean z) {
        this.f10426io = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(ws wsVar, com.bytedance.adsdk.ugeno.hf.w wVar) {
        String hf = wo.hf(this.kd);
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(this.hf, wsVar, hf, wo.hf(hf));
        Map<String, Object> kd = ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).kd();
        kd.put("click_element_type", wVar.j());
        Map<String, Object> map = this.g;
        if (map != null) {
            kd.putAll(map);
        }
        final String ho = wsVar.ho();
        com.bytedance.sdk.openadsdk.core.pl.hf.u hf2 = com.bytedance.sdk.openadsdk.core.pl.f.hf(this.hf, wsVar, hf, false);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj((com.bytedance.sdk.openadsdk.core.pl.hf.w) hf2);
        xjVar.xj(null, new com.bytedance.sdk.openadsdk.core.ra.tf());
        if (hf2 != null) {
            hf2.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.9
                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void hf(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void w(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj() {
                    xj.C0198xj.xj(ho, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        xj.C0198xj.xj(ho, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(long j, String str, String str2) {
                    xj.C0198xj.xj(ho, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
                public void xj(String str, String str2) {
                    xj.C0198xj.xj(ho, 6, 100);
                }
            });
        }
        Object obj = this.hf;
        if (obj instanceof com.bytedance.sdk.openadsdk.core.f.hf) {
            ((com.bytedance.sdk.openadsdk.core.f.hf) obj).xj(2);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar) {
        this.y = xjVar;
    }

    public void xj(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> list) {
        this.u.hf();
        this.dk.xj((tf) this);
        this.dk.xj(jSONObject, list, new c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(int i, String str) {
                com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar = xj.this.y;
                if (xjVar != null) {
                    xjVar.xj(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
            public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                xj xjVar = xj.this;
                xjVar.c = wVar;
                xjVar.f = xjVar.dk.xj();
                xj.this.w.addView(wVar.d(), new FrameLayout.LayoutParams(wVar.l(), wVar.ff()));
                if (xj.this.f10426io) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r.w(xj.this.hf, 200.0f), r.w(xj.this.hf, 200.0f));
                    layoutParams.gravity = 17;
                    xj xjVar2 = xj.this;
                    xjVar2.w.addView(xjVar2.e(), layoutParams);
                }
                com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar3 = xj.this.y;
                if (xjVar3 != null) {
                    xjVar3.xj(wVar.d());
                }
                xj xjVar4 = xj.this;
                com.bytedance.sdk.openadsdk.core.am.u.xj(xjVar4.kd, xjVar4.f10427pl, "ugeno_coin_eCommerce_page_show_success", (com.bytedance.sdk.openadsdk.y.xj.xj) null);
            }
        });
    }

    public void xj(hf hfVar) {
        this.v = hfVar;
        y yVar = this.dk;
        if (yVar != null) {
            yVar.xj(hfVar);
        }
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        com.bytedance.sdk.component.tf.c.hf(new AnonymousClass6("shop_page", wVar));
    }

    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> xj(List<ws> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ws wsVar : list) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w wVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w();
            JSONObject ac = wsVar.ac();
            try {
                ac.put("voice_btn_position", com.bytedance.sdk.openadsdk.core.ra.v.qt(this.kd));
            } catch (JSONException unused) {
            }
            wVar.xj(-2134548432);
            wVar.xj(ac);
            arrayList.add(wVar);
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.f
    public void hf(com.bytedance.adsdk.ugeno.hf.w wVar) {
        ws wsVar = this.kd;
        if (wsVar == null || wsVar.m() == null) {
            return;
        }
        wVar.hf(0);
    }

    public void xj(final ws wsVar, final com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (TextUtils.equals(wVar.j(), a.z)) {
            com.bytedance.adsdk.ugeno.hf.xj z = wVar.z();
            if (z != null) {
                com.bytedance.adsdk.ugeno.hf.w u = z.u("video_" + wsVar.rx());
                if (u instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) u;
                    if (hfVar.f()) {
                        hfVar.u(false);
                        if (wVar instanceof com.bytedance.adsdk.ugeno.widget.image.hf) {
                            ((com.bytedance.adsdk.ugeno.widget.image.hf) wVar).hf(jk.w(this.hf, "tt_unmute"));
                            return;
                        }
                        return;
                    }
                    hfVar.u(true);
                    if (wVar instanceof com.bytedance.adsdk.ugeno.widget.image.hf) {
                        ((com.bytedance.adsdk.ugeno.widget.image.hf) wVar).hf(jk.w(this.hf, "tt_mute"));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.ht) {
            if (!com.bytedance.sdk.openadsdk.core.ugeno.tf.y(this.kd)) {
                xj(this.kd, this.g);
            }
            com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, this.f10427pl, "ugeno_coin_eCommerce_click_content", (com.bytedance.sdk.openadsdk.y.xj.xj) null);
            com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, this.f10427pl, "page_click", (com.bytedance.sdk.openadsdk.y.xj.xj) null);
            this.ht = false;
        }
        xj(wsVar);
        if (this instanceof com.bytedance.sdk.openadsdk.core.ugeno.d.u) {
            wsVar.d(1);
            ws wsVar2 = this.kd;
            if (wsVar2 != null) {
                wsVar.xj(wsVar2.x());
            }
        }
        if (com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.xj(wsVar, true)) {
            com.bytedance.sdk.openadsdk.core.hf.xj.hf.w wVar2 = new com.bytedance.sdk.openadsdk.core.hf.xj.hf.w(wsVar, this.hf);
            wVar2.xj(new w.hf() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.7
                @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.hf
                public void xj() {
                    v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ws wsVar3 = wsVar;
                            if (wsVar3 == null || wsVar3.yl() == null) {
                                return;
                            }
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            x.xj(xj.this.hf, wsVar.yl().u(), 0);
                        }
                    });
                    xj.this.hf(wsVar, wVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.hf
                public void xj(final String str, final boolean z2) {
                    v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z2 && "has_applied".equals(str)) {
                                x.xj(xj.this.hf, "你已领券，快去直播间下单吧", 0);
                            } else {
                                x.xj(xj.this.hf, "领券失败", 0);
                            }
                        }
                    });
                    xj.this.hf(wsVar, wVar);
                }
            });
            wVar2.xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.xj.8
                @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.xj
                public void xj() {
                }
            });
            return;
        }
        hf(wsVar, wVar);
    }

    private void xj(ws wsVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.d.xj ai;
        JSONObject hf;
        g xj;
        if (wsVar == null || (ai = wsVar.ai()) == null || (hf = ai.hf()) == null || (xj = g.xj(hf)) == null) {
            return;
        }
        if (xj.w() == 0 || xj.w() == 5) {
            wsVar.xj(xj);
        }
    }

    public void xj(JSONObject jSONObject) {
        ws xj;
        if (jSONObject == null || (xj = com.bytedance.sdk.openadsdk.core.xj.xj(jSONObject)) == null) {
            return;
        }
        String hf = wo.hf(this.kd);
        HashMap hashMap = new HashMap();
        hashMap.put("is_slide", this.tf);
        com.bytedance.sdk.openadsdk.core.am.u.xj(xj, hf, hashMap, (Double) null);
        com.bytedance.sdk.openadsdk.core.q.xj.xj().u();
        ws wsVar = this.kd;
        ff.xj(wsVar != null ? wsVar.kd() : 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.ra && this.tf.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.tf);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.am.u.xj(xj, hf, "is_slide", jSONObject2, (com.bytedance.sdk.openadsdk.y.xj.xj) null);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    public void xj(Map<String, Object> map) {
        this.g = map;
    }

    public void xj(InterfaceC0184xj interfaceC0184xj) {
        this.jk = interfaceC0184xj;
    }

    private void xj(ws wsVar, Map<String, Object> map) {
        if (wsVar == null) {
            return;
        }
        String hf = wo.hf(wsVar);
        int f = r.f(pz.getContext());
        com.bytedance.sdk.openadsdk.core.am.u.xj("click", wsVar, new d.xj().y(-1.0f).kd(-1.0f).u(-1.0f).w(-1.0f).hf(-1L).xj(-1L).w(-1).u(-1).kd(-1024).hf(com.bytedance.sdk.openadsdk.core.f.zg().w() ? 1 : 2).xj(f).xj(r.y(pz.getContext())).hf(r.c(pz.getContext())).xj(), hf, true, map, -1, false);
    }
}
