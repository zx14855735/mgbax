package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.adsdk.ugeno.w.ht;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.yo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.express.hf;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class UGenVideoOrImgPanelView extends NativeExpressView {
    private boolean ai;
    private ViewGroup dk;
    private final Context et;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.u hf;
    private final xj ht;

    /* renamed from: io, reason: collision with root package name */
    private final AtomicBoolean f10446io;
    private final CopyOnWriteArrayList<Message> kd;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c q;
    private View ra;
    private final View u;
    private final NativeVideoTsView w;
    private volatile boolean x;
    private final ws xj;

    public static class xj extends Handler {
        UGenVideoOrImgPanelView xj;

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r3) {
            /*
                r2 = this;
                super.handleMessage(r3)
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r0 = r2.xj
                if (r0 != 0) goto L8
                goto L30
            L8:
                boolean r0 = com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.y(r0)
                if (r0 == 0) goto Lf
                goto L30
            Lf:
                if (r3 != 0) goto L12
                goto L30
            L12:
                java.lang.Object r0 = r3.obj
                boolean r1 = r0 instanceof java.lang.ref.WeakReference
                if (r1 == 0) goto L25
                java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
                java.lang.Object r0 = r0.get()
                boolean r1 = r0 instanceof android.view.View
                if (r1 == 0) goto L25
                android.view.View r0 = (android.view.View) r0
                goto L26
            L25:
                r0 = 0
            L26:
                if (r0 != 0) goto L29
                goto L30
            L29:
                int r3 = r3.what
                if (r3 == 0) goto L37
                r1 = 2
                if (r3 == r1) goto L31
            L30:
                return
            L31:
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r3 = r2.xj
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.w(r3, r0)
                return
            L37:
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r3 = r2.xj
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.hf(r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.xj.handleMessage(android.os.Message):void");
        }

        public void xj(UGenVideoOrImgPanelView uGenVideoOrImgPanelView) {
            this.xj = uGenVideoOrImgPanelView;
        }

        private xj(Looper looper) {
            super(looper);
        }
    }

    public UGenVideoOrImgPanelView(Context context, ws wsVar, NativeVideoTsView nativeVideoTsView, View view, ViewGroup viewGroup, String str, boolean z) {
        super(context, wsVar, new com.bytedance.sdk.openadsdk.zg.w.w.hf(new SparseArray()), str);
        this.kd = new CopyOnWriteArrayList<>();
        xj xjVar = new xj(Looper.getMainLooper());
        this.ht = xjVar;
        this.f10446io = new AtomicBoolean(true);
        this.x = false;
        this.ai = false;
        this.q = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void hf() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void kd() {
                UGenVideoOrImgPanelView.this.qt();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void u() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void xj() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void xj(boolean z2) {
            }
        };
        this.et = context;
        this.xj = wsVar;
        this.w = nativeVideoTsView;
        this.u = view;
        this.dk = viewGroup;
        xjVar.xj(this);
        this.ai = z;
        am();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt() {
        View view = this.ra;
        if (view != null) {
            view.setVisibility(8);
            if (this.ra.getParent() != null) {
                ((ViewGroup) this.ra.getParent()).removeView(this.ra);
            }
        }
    }

    public void am() {
        ws wsVar;
        JSONObject ir;
        JSONArray optJSONArray;
        if (this.f10446io.getAndSet(false) && (wsVar = this.xj) != null) {
            if ((this.w == null && this.u == null) || (ir = wsVar.ir()) == null || (optJSONArray = ir.optJSONArray("components")) == null) {
                return;
            }
            this.jk = pz.hf().u(wo.d(this.xj));
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                final int optInt = optJSONObject.optInt("render_sequence");
                final int optInt2 = optJSONObject.optInt("displayAreaAndroid");
                String optString = optJSONObject.optString("ugen_md5");
                String optString2 = optJSONObject.optString("ugen_url");
                final String optString3 = optJSONObject.optString("ugen_id");
                tf.xj(optString2, optString, new com.bytedance.sdk.openadsdk.core.ugeno.w() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.2
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
                    public void xj() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
                    public void xj(String str) {
                        try {
                            UGenVideoOrImgPanelView.this.xj(new JSONObject(str), optInt2, optString3, optInt);
                        } catch (Throwable th) {
                            pl.xj(th);
                        }
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void g() {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.9
            @Override // java.lang.Runnable
            public void run() {
                UGenVideoOrImgPanelView.this.x = true;
                if (UGenVideoOrImgPanelView.this.ra != null) {
                    ViewParent parent = UGenVideoOrImgPanelView.this.ra.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(UGenVideoOrImgPanelView.this.ra);
                    }
                }
                UGenVideoOrImgPanelView.super.g();
                if (UGenVideoOrImgPanelView.this.hf != null) {
                    UGenVideoOrImgPanelView.this.hf.p();
                }
            }
        });
    }

    public void setAdSlot(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        this.f = hfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hf(final View view) {
        ViewGroup viewGroup = this.dk;
        if (viewGroup == null || view == null || this.w == null) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.7
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.dk.getWidth(), UGenVideoOrImgPanelView.this.dk.getHeight()));
                view.setVisibility(0);
                UGenVideoOrImgPanelView.this.w.removeView(view);
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                UGenVideoOrImgPanelView.this.w.addView(view);
                UGenVideoOrImgPanelView.this.dk.getGlobalVisibleRect(new Rect());
                UGenVideoOrImgPanelView.this.w.getGlobalVisibleRect(new Rect());
                view.setTranslationY(r2.top - r3.top);
                for (ViewParent parent2 = UGenVideoOrImgPanelView.this.w.getParent(); parent2 != null; parent2 = parent2.getParent()) {
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).setClipChildren(false);
                        if (parent2.hashCode() == UGenVideoOrImgPanelView.this.dk.hashCode()) {
                            return;
                        }
                    }
                }
            }
        });
        return true;
    }

    private void w(final int i, final String str) {
        this.hf.xj(new com.bytedance.sdk.component.adexpress.hf.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.5
            @Override // com.bytedance.sdk.component.adexpress.hf.c
            public void xj(View view, am amVar) {
                View childAt;
                if ((UGenVideoOrImgPanelView.this.w == null && UGenVideoOrImgPanelView.this.u == null) || view == null) {
                    return;
                }
                UGenVideoOrImgPanelView.this.ra = view;
                boolean xj2 = UGenVideoOrImgPanelView.this.xj(view, i);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (viewGroup.getChildCount() > 0 && (childAt = viewGroup.getChildAt(0)) != null && childAt.getVisibility() == 8) {
                        HashMap hashMap = new HashMap();
                        A2egSU.BNL6CD(105, hashMap, "error_code", 1, "render_type");
                        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(UGenVideoOrImgPanelView.this.xj, false, str, 3, (Map<String, Object>) hashMap);
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(UGenVideoOrImgPanelView.this.xj, xj2, str, 3, (Map<String, Object>) null);
            }

            @Override // com.bytedance.sdk.component.adexpress.hf.c
            public void xj(int i2, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("error_code", Integer.valueOf(i2));
                hashMap.put("error_msg", str2);
                hashMap.put("render_type", 1);
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(UGenVideoOrImgPanelView.this.xj, false, str, 3, (Map<String, Object>) hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(final View view) {
        if (view == null) {
            return false;
        }
        ViewGroup viewGroup = this.dk;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.8
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.dk.getWidth(), UGenVideoOrImgPanelView.this.dk.getHeight()));
                view.setVisibility(0);
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                UGenVideoOrImgPanelView.this.dk.removeView(view);
                UGenVideoOrImgPanelView.this.dk.addView(view);
            }
        });
        return true;
    }

    public static boolean xj(ws wsVar) {
        JSONObject ir;
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        return (wsVar == null || (ir = wsVar.ir()) == null || (optJSONArray = ir.optJSONArray("components")) == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null || TextUtils.isEmpty(optJSONObject.optString("ugen_url"))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final JSONObject jSONObject, final int i, final String str, final int i2) {
        if (jSONObject == null) {
            return;
        }
        NativeVideoTsView nativeVideoTsView = this.w;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.3
                @Override // java.lang.Runnable
                public void run() {
                    UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                    uGenVideoOrImgPanelView.xj(uGenVideoOrImgPanelView.w, jSONObject, i, str, i2);
                }
            });
            return;
        }
        View view = this.u;
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 0) {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView.xj(uGenVideoOrImgPanelView.dk, jSONObject, i, str, i2);
                    } else {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView2.xj(uGenVideoOrImgPanelView2.u, jSONObject, i, str, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(View view, JSONObject jSONObject, int i, String str, int i2) {
        if (i2 == 3) {
            jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(this.xj, com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(view), jSONObject, this.ai, null);
        }
        JSONObject xj2 = tf.xj(this.xj, view, this.ai);
        if (xj2 != null && !TextUtils.isEmpty(str)) {
            try {
                xj2.put("ugen_id", str);
            } catch (JSONException unused) {
            }
        }
        hf.xj xjVar = new hf.xj();
        xjVar.kd(xj2);
        xjVar.xj(jSONObject);
        xjVar.xj((ht) new yo());
        xjVar.hf(view.getHeight());
        xjVar.xj(view.getWidth());
        xjVar.xj(f.zg().kd());
        xjVar.tf(this.xj.kd());
        com.bytedance.sdk.openadsdk.core.ugeno.express.hf xj3 = xjVar.xj();
        if (i2 == 3) {
            this.hf = new com.bytedance.sdk.openadsdk.core.ugeno.express.y(this.et, this.xj, xj3, this.dk);
        } else {
            this.hf = new com.bytedance.sdk.openadsdk.core.ugeno.express.u(this.et, this.xj, xj3, this.dk);
        }
        this.hf.xj(this);
        this.hf.xj(this.q);
        w(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean xj(android.view.View r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.x
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            if (r5 == 0) goto L57
            r2 = 2
            if (r5 == r2) goto L3b
            com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView r5 = r3.w
            if (r5 == 0) goto L32
            android.view.ViewParent r5 = r4.getParent()
            if (r5 == 0) goto L1f
            android.view.ViewParent r5 = r4.getParent()
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r5.removeView(r4)
        L1f:
            android.view.ViewGroup$LayoutParams r5 = new android.view.ViewGroup$LayoutParams
            r2 = -1
            r5.<init>(r2, r2)
            r4.setLayoutParams(r5)
            r4.setVisibility(r1)
            com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView r5 = r3.w
            r5.addView(r4)
        L30:
            r1 = 1
            goto L73
        L32:
            android.view.View r5 = r3.u
            if (r5 == 0) goto L73
            boolean r1 = r3.xj(r4)
            goto L73
        L3b:
            android.view.ViewGroup r5 = r3.dk
            if (r5 == 0) goto L44
            boolean r1 = r3.hf(r4)
            goto L73
        L44:
            android.os.Message r5 = android.os.Message.obtain()
            r5.what = r2
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            r5.obj = r1
            java.util.concurrent.CopyOnWriteArrayList<android.os.Message> r1 = r3.kd
            r1.add(r5)
            goto L30
        L57:
            android.view.ViewGroup r5 = r3.dk
            if (r5 == 0) goto L60
            boolean r1 = r3.w(r4)
            goto L73
        L60:
            android.os.Message r5 = android.os.Message.obtain()
            r5.what = r1
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            r5.obj = r1
            java.util.concurrent.CopyOnWriteArrayList<android.os.Message> r1 = r3.kd
            r1.add(r5)
            goto L30
        L73:
            android.view.View r5 = r3.u
            if (r5 != 0) goto L7f
            r4.bringToFront()
            boolean r4 = r3.jk
            r3.xj(r4)
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.xj(android.view.View, int):boolean");
    }

    private boolean xj(final View view) {
        if (view == null) {
            return false;
        }
        ViewGroup viewGroup = this.dk;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            return false;
        }
        this.u.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.6
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                UGenVideoOrImgPanelView.this.u.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                UGenVideoOrImgPanelView.this.dk.getLocationInWindow(iArr2);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (UGenVideoOrImgPanelView.this.dk instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UGenVideoOrImgPanelView.this.u.getWidth(), UGenVideoOrImgPanelView.this.u.getHeight());
                    layoutParams.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.dk.addView(view, layoutParams);
                }
                if (UGenVideoOrImgPanelView.this.dk instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UGenVideoOrImgPanelView.this.u.getWidth(), UGenVideoOrImgPanelView.this.u.getHeight());
                    layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.dk.addView(view, layoutParams2);
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.hf.f
    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
        super.xj(view, i, wVar);
        View view2 = this.w;
        if (view2 == null) {
            view2 = this.u;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(this.xj, com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(view2, wVar), com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(wVar), 3, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.hf.f
    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, int i2) {
        super.xj(view, i, wVar, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(boolean z) {
        NativeVideoTsView nativeVideoTsView = this.w;
        if (nativeVideoTsView == null) {
            return;
        }
        this.jk = z;
        nativeVideoTsView.hf(z, true);
        com.bykv.vk.openvk.component.video.api.u.w nativeVideoController = this.w.getNativeVideoController();
        if (nativeVideoController != null) {
            nativeVideoController.hf(z);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.u uVar = this.hf;
        if (uVar == null) {
            return;
        }
        uVar.setSoundMute(z);
    }
}
