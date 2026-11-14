package com.bytedance.sdk.openadsdk.core;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.hf.xj.w.w;
import com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class jk {
    private Activity ai;
    private WeakReference<ViewGroup> am;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj c;
    private volatile com.bytedance.sdk.openadsdk.core.hf.hf dk;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.xj en;
    private volatile com.bytedance.sdk.openadsdk.core.hf.xj et;
    private long f;
    private ViewGroup g;
    private volatile com.bytedance.sdk.openadsdk.core.pl.hf.w hf;
    private EmptyView ht;

    /* renamed from: io, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.hf.xj f10367io;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c j;
    private UpieImageView l;
    private WeakReference<NativeVideoTsView> q;
    private View qt;
    private View ra;
    private com.bytedance.sdk.openadsdk.zg.w.hf.g u;
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj v;
    private final Context w;
    private com.bytedance.sdk.openadsdk.core.hf.xj x;
    private final ws xj;
    private String y;
    private com.bytedance.sdk.component.utils.ht yo;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj zg;
    private List<View> kd = new ArrayList();
    private Double d = null;
    private AtomicBoolean tf = new AtomicBoolean(false);
    private AtomicBoolean p = new AtomicBoolean(false);

    /* renamed from: pl, reason: collision with root package name */
    private AtomicBoolean f10368pl = new AtomicBoolean(false);
    private int e = 5;
    private volatile long jk = 0;
    private volatile boolean pz = true;
    private volatile boolean z = false;

    public jk(Context context, com.bytedance.sdk.openadsdk.zg.w.hf.g gVar, ws wsVar, String str) {
        this.y = "embeded_ad";
        this.u = gVar;
        this.xj = wsVar;
        this.w = context;
        this.y = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> c() {
        NativeVideoTsView nativeVideoTsView;
        HashMap hashMap = new HashMap();
        if (this.kd != null) {
            JSONArray jSONArray = new JSONArray();
            for (View view : this.kd) {
                if (view != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(MediaFormat.KEY_WIDTH, view.getWidth());
                        jSONObject.put(MediaFormat.KEY_HEIGHT, view.getHeight());
                        jSONObject.put("alpha", view.getAlpha());
                    } catch (Throwable unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
            hashMap.put("image_view", jSONArray.toString());
        }
        if (this.g != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(MediaFormat.KEY_WIDTH, this.g.getWidth());
                jSONObject2.put(MediaFormat.KEY_HEIGHT, this.g.getHeight());
                jSONObject2.put("alpha", this.g.getAlpha());
            } catch (Throwable unused2) {
            }
            hashMap.put("root_view", jSONObject2.toString());
        }
        WeakReference<NativeVideoTsView> weakReference = this.q;
        if (weakReference != null && (nativeVideoTsView = weakReference.get()) != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(MediaFormat.KEY_WIDTH, nativeVideoTsView.getWidth());
                jSONObject3.put(MediaFormat.KEY_HEIGHT, nativeVideoTsView.getHeight());
                jSONObject3.put("alpha", nativeVideoTsView.getAlpha());
            } catch (JSONException unused3) {
            }
            hashMap.put("video_view", jSONObject3.toString());
        }
        return hashMap;
    }

    private com.bytedance.sdk.openadsdk.core.ra.p kd() {
        ws wsVar;
        com.bytedance.sdk.openadsdk.core.ra.p mj;
        if (this.e == 5 && (wsVar = this.xj) != null && (mj = wsVar.mj()) != null && mj.xj() == 1) {
            return mj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.hf != null) {
            if (this.dk != null) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.dk.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.hf);
            }
            if (this.et != null) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.et.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.hf);
            }
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar = this.x;
            if (xjVar != null) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.hf);
            }
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar2 = this.f10367io;
            if (xjVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.hf);
            }
            try {
                this.hf.xj(false);
                this.hf.xj(this.v);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        ws wsVar = this.xj;
        if (wsVar == null || wsVar.vw() != 4) {
            return;
        }
        if (this.z) {
            u();
        } else {
            this.z = true;
            com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("feed_register_download") { // from class: com.bytedance.sdk.openadsdk.core.jk.1
                @Override // java.lang.Runnable
                public void run() {
                    if (jk.this.hf == null) {
                        jk jkVar = jk.this;
                        jkVar.hf = com.bytedance.sdk.openadsdk.core.pl.f.xj(jkVar.w, jk.this.xj, jk.this.y, false);
                    }
                    jk.this.hf.xj(jk.this.ai);
                    jk.this.u();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        com.bytedance.sdk.openadsdk.core.ra.p kd = kd();
        if (kd == null) {
            return;
        }
        final float hf = kd.hf();
        final float w = kd.w();
        if (this.yo == null) {
            this.yo = new com.bytedance.sdk.component.utils.ht(pz.getContext(), 1, f.zg().kd());
        }
        this.yo.hf(this.xj.ky());
        this.yo.xj(this.xj.ki());
        this.yo.hf(this.xj.eg());
        this.yo.y(this.xj.oa());
        this.yo.w(this.xj.ya());
        this.yo.xj(this.xj.ee());
        this.yo.kd(this.xj.le());
        this.yo.xj(new ht.xj() { // from class: com.bytedance.sdk.openadsdk.core.jk.6
            @Override // com.bytedance.sdk.component.utils.ht.xj
            public void xj(int i) {
                if (i == 1 && jk.this.pz && l.xj(jk.this.g)) {
                    com.bytedance.sdk.openadsdk.core.a.l.xj(jk.this.am, hf, w, jk.this.jk);
                }
            }
        });
        com.bytedance.sdk.component.utils.ht htVar = this.yo;
        ws wsVar = this.xj;
        htVar.xj(wsVar != null ? wsVar.kd() : 0);
    }

    private View hf(ViewGroup viewGroup) {
        Object obj;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Object tag = childAt.getTag();
            String str = "";
            if ((tag instanceof Map) && (obj = ((Map) tag).get("tag")) != null) {
                str = obj.toString();
            }
            if ("shake_compat".equals(str)) {
                return childAt;
            }
        }
        return null;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.g gVar) {
        this.u = gVar;
    }

    public void xj(Activity activity) {
        this.ai = activity;
        if (this.hf != null) {
            this.hf.xj(activity);
        }
    }

    private EmptyView w(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void xj(View view, int i) {
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar = this.c;
        if (xjVar != null) {
            xjVar.hf(view, this.u);
        }
    }

    public void hf(View view, com.bytedance.sdk.openadsdk.core.ra.tf tfVar) {
        if (this.dk != null) {
            this.dk.xj(view, tfVar);
        }
    }

    public void xj(NativeExpressView nativeExpressView) {
        if (nativeExpressView != null) {
            if (this.et != null) {
                nativeExpressView.setClickCreativeListener(this.et);
            }
            if (this.dk != null) {
                nativeExpressView.setClickListener(this.dk);
            }
        }
    }

    public void hf() {
        if (this.hf != null) {
            this.hf.hf();
        }
        WeakReference<ViewGroup> weakReference = this.am;
        if (weakReference != null) {
            weakReference.clear();
        }
        final ViewGroup viewGroup = this.g;
        final EmptyView emptyView = this.ht;
        if (viewGroup != null && emptyView != null) {
            com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jk.8
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(emptyView);
                }
            });
        }
        final View view = this.ra;
        if (viewGroup != null && view != null) {
            com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jk.9
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view);
                }
            });
        }
        com.bytedance.sdk.component.utils.ht htVar = this.yo;
        if (htVar != null) {
            ws wsVar = this.xj;
            htVar.hf(wsVar != null ? wsVar.kd() : 0);
        }
        ws wsVar2 = this.xj;
        com.bytedance.sdk.openadsdk.core.a.ff.hf(wsVar2 != null ? wsVar2.kd() : 0);
        UpieImageView upieImageView = this.l;
        if (upieImageView != null) {
            upieImageView.setOnClickListener(null);
        }
    }

    public void xj(UpieImageView upieImageView) {
        this.l = upieImageView;
        if (upieImageView == null || this.dk == null) {
            return;
        }
        this.l.setOnClickListener(this.dk);
    }

    public com.bytedance.sdk.openadsdk.core.pl.hf.w xj() {
        return this.hf;
    }

    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar2) {
        EmptyView emptyView;
        final com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar3;
        this.c = xjVar;
        this.g = viewGroup;
        this.am = new WeakReference<>(this.g);
        this.qt = view;
        this.zg = xjVar2;
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.xj);
        Context context = this.w;
        ws wsVar = this.xj;
        String str = this.y;
        this.x = new com.bytedance.sdk.openadsdk.core.hf.xj(context, wsVar, str, wo.hf(str));
        xj(viewGroup);
        EmptyView w = w(viewGroup);
        if (w == null) {
            ws wsVar2 = this.xj;
            EmptyView emptyView2 = new EmptyView(this.w, viewGroup, wsVar2 != null ? wsVar2.cm() : 1000) { // from class: com.bytedance.sdk.openadsdk.core.jk.2
                @Override // android.view.View
                public void onVisibilityChanged(View view2, int i) {
                    super.onVisibilityChanged(view2, i);
                    com.bytedance.sdk.component.utils.ht htVar = jk.this.yo;
                    if (htVar == null) {
                        return;
                    }
                    try {
                        jk.this.pz = isShown();
                        if (isShown()) {
                            htVar.xj(jk.this.xj != null ? jk.this.xj.kd() : 0);
                        } else {
                            htVar.hf(jk.this.xj != null ? jk.this.xj.kd() : 0);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            emptyView2.xj(this.xj, this.y);
            viewGroup.addView(emptyView2);
            emptyView = emptyView2;
        } else {
            emptyView = w;
        }
        emptyView.xj();
        emptyView.setRefClickViews(list2);
        emptyView.setRefCreativeViews(list3);
        emptyView.setRefDirectDownloadViews(list4);
        this.ht = emptyView;
        xj(this.x, this.g, this.qt, xjVar, this.zg, 3);
        this.kd = list;
        Context context2 = this.w;
        ws wsVar3 = this.xj;
        String str2 = this.y;
        this.dk = new com.bytedance.sdk.openadsdk.core.hf.hf(context2, wsVar3, str2, wo.hf(str2));
        xj(this.dk, viewGroup, view, xjVar, xjVar2, 0);
        Context context3 = this.w;
        ws wsVar4 = this.xj;
        String str3 = this.y;
        this.et = new com.bytedance.sdk.openadsdk.core.hf.xj(context3, wsVar4, str3, wo.hf(str3));
        xj(this.et, viewGroup, view, xjVar, xjVar2, 1);
        if (com.bytedance.sdk.component.utils.tf.xj(list4)) {
            xjVar3 = xjVar;
        } else {
            Context context4 = this.w;
            ws wsVar5 = this.xj;
            String str4 = this.y;
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar4 = new com.bytedance.sdk.openadsdk.core.hf.xj(context4, wsVar5, str4, wo.hf(str4));
            this.f10367io = xjVar4;
            xjVar4.xj(2);
            xjVar3 = xjVar;
            xj(this.f10367io, viewGroup, view, xjVar3, xjVar2, 2);
        }
        UpieImageView upieImageView = this.l;
        if (upieImageView != null) {
            upieImageView.setOnClickListener(this.dk);
        }
        emptyView.xj(list2, this.dk);
        emptyView.xj(list3, this.et);
        emptyView.xj(list4, this.f10367io);
        emptyView.setCallback(new EmptyView.xj() { // from class: com.bytedance.sdk.openadsdk.core.jk.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void hf() {
                if (jk.this.hf != null) {
                    jk.this.hf.hf();
                }
                try {
                    if (jk.this.yo != null) {
                        jk.this.yo.hf(jk.this.xj != null ? jk.this.xj.kd() : 0);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.u("ShakeUtils", "onPause error:" + th.getMessage());
                }
                jk.this.tf.set(false);
                jk.this.p.set(false);
                jk jkVar = jk.this;
                jkVar.f = com.bytedance.sdk.openadsdk.core.am.u.xj(jkVar.f, jk.this.xj, jk.this.y, 23);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(boolean z) {
                jk jkVar = jk.this;
                jkVar.f = com.bytedance.sdk.openadsdk.core.am.u.xj(jkVar.f, z, jk.this.xj, jk.this.y, 3);
                if (jk.this.yo != null) {
                    if (z) {
                        jk.this.yo.xj(jk.this.xj != null ? jk.this.xj.kd() : 0);
                        return;
                    }
                    try {
                        if (jk.this.yo != null) {
                            jk.this.yo.hf(jk.this.xj != null ? jk.this.xj.kd() : 0);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.pl.u("ShakeUtils", "onPause error:" + th.getMessage());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj() {
                jk.this.w();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(View view2, Map<String, Object> map) {
                com.bytedance.sdk.openadsdk.core.kd.xj.xj(jk.this.e, jk.this.xj);
                jk.this.w();
                jk.this.f = System.currentTimeMillis();
                Map c = jk.this.c();
                c.put("is_repeat", Boolean.valueOf(jk.this.f10368pl.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    c.put("show_send_type", map.get("show_send_type"));
                }
                c.put("is_repeat", Boolean.valueOf(jk.this.f10368pl.get()));
                jk.this.tf.set(true);
                if (!jk.this.p.get()) {
                    jk.this.p.set(true);
                    com.bytedance.sdk.openadsdk.core.am.u.xj(jk.this.xj, jk.this.y, (Map<String, Object>) c, jk.this.d);
                    com.bytedance.sdk.openadsdk.core.q.xj.xj().u();
                    com.bytedance.sdk.openadsdk.core.a.ff.xj(jk.this.xj != null ? jk.this.xj.kd() : 0);
                }
                if (xjVar3 != null) {
                    boolean db = pz.hf().db();
                    if (!jk.this.f10368pl.getAndSet(true) || db) {
                        xjVar3.xj(jk.this.u);
                    }
                    jk.this.jk = System.currentTimeMillis();
                    jk.this.y();
                }
                if (jk.this.en != null) {
                    jk.this.en.xj();
                }
                if (jk.this.j != null) {
                    jk.this.j.u();
                }
            }
        });
        emptyView.setNeedCheckingShow(true);
        w();
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c cVar) {
        this.j = cVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.video.nativevideo.xj xjVar) {
        this.en = xjVar;
    }

    public void xj(WeakReference<NativeVideoTsView> weakReference) {
        this.q = weakReference;
    }

    private void xj(final com.bytedance.sdk.openadsdk.core.hf.hf hfVar, ViewGroup viewGroup, View view, final com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar, final com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar2, int i) {
        xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        if (i != 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("click_type", 1);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(hashMap);
        }
        hfVar.xj(viewGroup);
        hfVar.hf(view);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.u);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(new xj.InterfaceC0169xj() { // from class: com.bytedance.sdk.openadsdk.core.jk.4
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.InterfaceC0169xj
            public void xj(View view2, int i2) {
                if (hfVar instanceof com.bytedance.sdk.openadsdk.core.hf.xj) {
                    com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar3 = xjVar;
                    if (xjVar3 != null) {
                        xjVar3.hf(view2, jk.this.u);
                    }
                    com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar4 = xjVar2;
                    if (xjVar4 != null) {
                        xjVar4.hf(view2, jk.this.u);
                    }
                } else {
                    com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar5 = xjVar;
                    if (xjVar5 != null) {
                        xjVar5.xj(view2, jk.this.u);
                    }
                    com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar6 = xjVar2;
                    if (xjVar6 != null) {
                        xjVar6.xj(view2, jk.this.u);
                    }
                }
                if (i2 != 2 || jk.this.xj == null) {
                    return;
                }
                jk.this.xj.w(true);
            }
        });
    }

    public void xj(int i) {
        this.e = i;
    }

    private void xj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        View hf = hf(viewGroup);
        if (hf != null) {
            HashMap BI9f7h2 = A2egSU.BI9f7h("tag", "shake_compat");
            BI9f7h2.put("click_listener", this.x);
            try {
                hf.setTag(com.bytedance.sdk.openadsdk.core.a.l.xj, BI9f7h2);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.u("ShakeUtils", "onPause error:" + th.getMessage());
                com.bytedance.sdk.openadsdk.core.a.l.xj(com.bytedance.sdk.openadsdk.core.a.l.xj, th.getMessage());
            }
            this.ra = hf;
            return;
        }
        View view = new View(this.w);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.jk.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                try {
                    if (jk.this.yo != null) {
                        jk.this.yo.hf(jk.this.xj != null ? jk.this.xj.kd() : 0);
                    }
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.pl.u("ShakeUtils", "onPause error:" + th2.getMessage());
                }
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("tag", "shake_compat");
        hashMap.put("click_listener", this.x);
        try {
            view.setTag(com.bytedance.sdk.openadsdk.core.a.l.xj, hashMap);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.pl.u("ShakeUtils", "onPause error:" + th2.getMessage());
            com.bytedance.sdk.openadsdk.core.a.l.xj(com.bytedance.sdk.openadsdk.core.a.l.xj, th2.getMessage());
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(view);
        this.ra = view;
    }

    public void xj(final com.bytedance.sdk.openadsdk.core.hf.xj.w.w wVar) {
        wVar.xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.jk.7
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.w.w.xj
            public boolean xj() {
                wVar.xj(jk.this.ht);
                wVar.xj(jk.this.c());
                wVar.xj(jk.this.y);
                wVar.xj(jk.this.d);
                return jk.this.tf.get();
            }
        });
    }

    public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar) {
        this.v = xjVar;
    }

    public void xj(View view, com.bytedance.sdk.openadsdk.core.ra.tf tfVar) {
        if (this.et != null) {
            this.et.xj(view, tfVar);
        }
    }

    public void xj(Double d) {
        this.d = d;
    }
}
