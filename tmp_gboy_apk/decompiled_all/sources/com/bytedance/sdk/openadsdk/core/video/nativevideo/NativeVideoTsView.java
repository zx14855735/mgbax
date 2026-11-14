package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.yo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.am;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.u;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.x.d;
import com.bytedance.sdk.openadsdk.x.tf;
import com.bytedance.sdk.openadsdk.y.w.e;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NativeVideoTsView extends FrameLayout implements w.xj, ai.xj, u.xj {
    private static volatile com.bytedance.sdk.component.u.hf.w s;

    /* renamed from: a, reason: collision with root package name */
    private long f10443a;
    private boolean ai;
    protected boolean am;
    private ViewGroup aq;
    private boolean b;
    private boolean bl;
    protected FrameLayout c;
    protected boolean d;
    private ViewTreeObserver dc;
    private boolean dk;
    private hf dq;
    AtomicBoolean e;
    private final String en;
    private boolean et;
    private int eu;
    protected boolean f;
    private long ff;
    protected ImageView g;
    private AtomicBoolean gh;
    private boolean hf;
    private w hl;
    private boolean ht;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10444io;
    private boolean j;
    protected final AtomicBoolean jk;
    protected com.bykv.vk.openvk.component.video.api.u.w kd;
    private TTViewStub l;
    private boolean lw;
    private boolean n;
    protected ImageView p;

    /* renamed from: pl, reason: collision with root package name */
    protected ImageView f10445pl;
    private String pz;
    private long q;
    private boolean qd;
    protected String qt;
    private boolean r;
    private boolean ra;
    protected RelativeLayout tf;
    private boolean tj;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c tu;
    protected ws u;
    public u v;
    private ViewTreeObserver.OnGlobalLayoutListener vm;
    protected final Context w;
    private volatile boolean wa;
    private View.OnAttachStateChangeListener wn;
    private w.InterfaceC0013w wo;
    private int ws;
    private NativeExpressVideoView x;
    private boolean xj;
    protected ViewGroup y;
    boolean yo;
    private boolean yy;
    private final ai z;
    protected int zg;

    public class hf implements Runnable {
        private volatile boolean hf;

        private hf() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView.this.hf(this.hf);
        }

        public Runnable xj(boolean z) {
            this.hf = z;
            return this;
        }
    }

    public interface u {
        void xj(boolean z, long j, long j2, long j3, boolean z2, boolean z3);
    }

    public static class w implements dk {
        private int c;
        private WeakReference<ViewGroup> hf;
        private String kd;
        private ws u;
        private WeakReference<GifView> w = new WeakReference<>(null);
        private am xj;
        private int y;

        public w(am amVar, ViewGroup viewGroup, ws wsVar, String str, int i, int i2) {
            this.xj = amVar;
            this.hf = new WeakReference<>(viewGroup);
            this.u = wsVar;
            this.kd = str;
            this.y = i;
            this.c = i2;
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onFailed(int i, String str, Throwable th) {
            pl.u("copflg", "fail: ".concat(String.valueOf(str)));
            GifView gifView = this.w.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.bytedance.sdk.openadsdk.core.am.u.xj(this.u, this.kd, 2);
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onSuccess(final zg zgVar) {
            try {
                ViewGroup viewGroup = this.hf.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) w.this.hf.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            w wVar = w.this;
                            wVar.xj(context, wVar.xj, zgVar, viewGroup2);
                        } catch (Exception e) {
                            pl.xj(e);
                        }
                    }
                }, 100L);
            } catch (Exception e) {
                onFailed(1002, "", e);
            }
        }

        private int xj() {
            if (this.xj.y() > 0.0d) {
                return (int) (this.xj.y() * this.c);
            }
            return this.c / 2;
        }

        private void xj(Context context, FrameLayout.LayoutParams layoutParams, int i) {
            if (this.xj.w() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i;
                layoutParams.bottomMargin = i;
            } else {
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = i;
                layoutParams.topMargin = r.w(context, 19.0f);
            }
        }

        private void xj(Object obj, zg zgVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (zgVar.isGif()) {
                    gifView.xj((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                } else {
                    gifView.setImageDrawable(yo.xj((byte[]) obj, 0));
                }
            }
        }

        private void xj(GifView gifView) {
            if (gifView == null || gifView.getParent() == null) {
                return;
            }
            ((ViewGroup) gifView.getParent()).removeView(gifView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(Context context, am amVar, zg zgVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int w = r.w(context, 12.0f);
            this.y = viewGroup.getWidth() <= 0 ? this.y : viewGroup.getWidth();
            this.c = viewGroup.getHeight() <= 0 ? this.c : viewGroup.getHeight();
            int xj = xj();
            if (amVar.xj() == 3) {
                if (xj > r.w(context, 88.0f)) {
                    xj = r.w(context, 88.0f);
                }
            } else if (amVar.xj() == 4 && xj > r.w(context, 178.0f)) {
                xj = r.w(context, 178.0f);
            }
            int i = this.y - w;
            int c = (int) (amVar.c() * xj);
            if (c > i && c > 0 && i > 0) {
                layoutParams = new FrameLayout.LayoutParams(i, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, xj);
            }
            xj(context, layoutParams, w);
            gifView.setVisibility(0);
            xj(zgVar.getResult(), zgVar, gifView);
            xj(this.w.get());
            viewGroup.addView(gifView, layoutParams);
            this.w = new WeakReference<>(gifView);
            com.bytedance.sdk.openadsdk.core.am.u.xj(this.u, this.kd, 0);
        }
    }

    public interface xj {
        void xj(View view, int i);
    }

    public NativeVideoTsView(Context context, ws wsVar) {
        this(context, wsVar, false, false);
    }

    private boolean ai() {
        if (zg()) {
            return false;
        }
        if (s == null) {
            s = getKvCache();
        }
        return s.get("key_video_is_from_detail_page", false) || s.get("key_video_isfromvideodetailpage", false);
    }

    private void dk() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar == null) {
            return;
        }
        wVar.u(this.xj);
        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) this.kd).xj((u.xj) this);
        this.kd.xj(this);
    }

    private boolean en() {
        return 2 == pz.hf().c(wo.d(this.u));
    }

    private boolean et() {
        return TextUtils.equals(this.qt, "splash_ad") || TextUtils.equals(this.qt, "cache_splash_ad");
    }

    private void f() {
        xj(0L, 0);
        this.wo = null;
    }

    private void ff() {
        r.kd(this.f10445pl);
        r.kd(this.tf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.u.hf.w getKvCache() {
        return j.xj("sp_multi_native_video_data");
    }

    private void ht() {
        if (!(this instanceof NativeDrawVideoTsView) || this.e.get() || f.zg().eu() == null) {
            return;
        }
        this.g.setImageBitmap(f.zg().eu());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        int w2 = r.w(getContext(), this.zg);
        layoutParams.width = w2;
        layoutParams.height = w2;
        this.g.setLayoutParams(layoutParams);
        this.e.set(true);
    }

    private void io() {
        boolean x = x();
        if (this.wa && x) {
            com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
            if (wVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.u) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) wVar).z();
            }
            this.wa = false;
        } else {
            if (this.dq == null) {
                this.dq = new hf();
            } else {
                com.bytedance.sdk.component.utils.f.hf().removeCallbacks(this.dq);
            }
            this.dq.xj(x);
            com.bytedance.sdk.component.utils.f.hf().post(this.dq);
        }
        this.z.sendEmptyMessageDelayed(1, this.ff);
    }

    private void j() {
        if (s == null) {
            s = getKvCache();
        }
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar == null || zg() || !s.get("key_video_is_update_flag", false)) {
            return;
        }
        boolean z = s.get("key_native_video_complete", false);
        long j = s.get("key_video_current_play_position", -1L);
        long j2 = s.get("key_video_total_play_duration", wVar.pl() + wVar.am());
        long j3 = s.get("key_video_duration", wVar.am());
        wVar.w(z);
        if (z) {
            wVar.hf(j3);
        } else {
            wVar.hf(j);
        }
        wVar.w(j2);
        wVar.u(j3);
        s.put("key_video_is_update_flag", false);
    }

    private boolean l() {
        return 5 == pz.hf().c(wo.d(this.u));
    }

    private void pz() {
        addView(xj(this.w));
        B_();
    }

    private void q() {
        if (zg()) {
            return;
        }
        if (s == null) {
            s = getKvCache();
        }
        s.put("key_video_isfromvideodetailpage", false);
        s.put("key_video_is_from_detail_page", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.dc;
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.vm) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private boolean x() {
        View view;
        if (!tf.xj(this.u)) {
            view = this;
        } else if (hl.xj(this.u) == 2) {
            view = this.x;
        } else {
            ViewParent parent = getParent();
            view = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        return l.hf(view, 50, 5);
    }

    private void z() {
        if (this.aq == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.aq.hashCode()) {
                    this.aq.hashCode();
                    return;
                }
            }
        }
    }

    public void B_() {
        this.kd = xj(this.w, this.c, this.u, this.qt, !zg(), this.dk, this.et);
        dk();
        this.wn = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.dc = nativeVideoTsView.y.getViewTreeObserver();
                if (NativeVideoTsView.this.dc == null || NativeVideoTsView.this.vm == null) {
                    return;
                }
                NativeVideoTsView.this.dc.addOnGlobalLayoutListener(NativeVideoTsView.this.vm);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.ra();
            }
        };
        this.vm = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.y.getWidth();
                int height = NativeVideoTsView.this.y.getHeight();
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) NativeVideoTsView.this.kd).xj(width, height);
                NativeVideoTsView.this.ra();
                NativeVideoTsView.this.hf(width, height);
            }
        };
    }

    public void C_() {
        r.xj((View) this.tf, 8);
        w.InterfaceC0013w interfaceC0013w = this.wo;
        if (interfaceC0013w != null && !this.lw) {
            this.lw = true;
            interfaceC0013w.q_();
        }
        r.xj((View) this.tf, 8);
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c cVar = this.tu;
        if (cVar != null) {
            cVar.xj();
        }
    }

    public boolean am() {
        return this.xj;
    }

    public void c() {
        ws wsVar = this.u;
        if (wsVar == null) {
            return;
        }
        int d = wo.d(wsVar);
        int c = pz.hf().c(d);
        if (c == 1) {
            this.xj = com.bytedance.sdk.component.utils.am.u(this.w);
        } else if (c == 2) {
            this.xj = com.bytedance.sdk.component.utils.am.kd(this.w) || com.bytedance.sdk.component.utils.am.u(this.w) || com.bytedance.sdk.component.utils.am.y(this.w) || com.bytedance.sdk.component.utils.am.w(pz.getContext()) == 1;
        } else if (c == 3) {
            this.xj = false;
        } else if (c == 4) {
            this.yo = true;
        } else if (c == 5) {
            this.xj = com.bytedance.sdk.component.utils.am.u(this.w) || com.bytedance.sdk.component.utils.am.y(this.w);
        }
        if (this.hf) {
            this.f = false;
        } else {
            this.f = pz.hf().u(d);
        }
        if ("splash_ad".equals(this.qt)) {
            this.xj = true;
            this.f = true;
        }
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            wVar.u(this.xj);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.u.xj
    public void d() {
        this.wa = true;
        if (this.z.hasMessages(1)) {
            return;
        }
        this.z.sendEmptyMessage(1);
    }

    public void e() {
        com.bykv.vk.openvk.component.video.api.u.hf yo;
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar == null || (yo = wVar.yo()) == null) {
            return;
        }
        yo.xj();
        View w2 = yo.w();
        if (w2 != null) {
            w2.setVisibility(8);
            if (w2.getParent() != null) {
                ((ViewGroup) w2.getParent()).removeView(w2);
            }
        }
    }

    public void g() {
        if (!this.jk.get()) {
            this.jk.set(true);
            if (this.kd != null) {
                ai aiVar = this.z;
                if (aiVar != null) {
                    aiVar.removeCallbacksAndMessages(null);
                }
                this.kd.xj(true, 3);
            }
        }
        this.gh.set(false);
    }

    public com.bykv.vk.openvk.component.video.api.u.w getNativeVideoController() {
        return this.kd;
    }

    public boolean getVideoError() {
        return this.ra;
    }

    public void kd() {
        this.v = null;
        e();
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (this.tj) {
            ViewGroup viewGroup = this.y;
            if (viewGroup != null && (onAttachStateChangeListener = this.wn) != null) {
                viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            u();
            com.bytedance.sdk.openadsdk.core.qt.f.xj(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.y;
        if (viewGroup != null && (onAttachStateChangeListener = this.wn) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        kd();
        this.hl = null;
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.tj) {
            u();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        tf();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        kd();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.bykv.vk.openvk.component.video.api.u.w wVar;
        com.bykv.vk.openvk.component.video.api.u.w wVar2;
        com.bykv.vk.openvk.component.video.api.u.w wVar3;
        com.bykv.vk.openvk.component.video.api.u.w wVar4;
        super.onWindowFocusChanged(z);
        if (this.tj) {
            this.r = z;
            j();
            if (ai() && (wVar4 = this.kd) != null && wVar4.jk()) {
                q();
                r.xj((View) this.tf, 8);
                u(true);
                f();
                return;
            }
            c();
            if (!zg() && am() && (wVar2 = this.kd) != null && !wVar2.zg()) {
                if (this.z != null) {
                    if (z && (wVar3 = this.kd) != null && !wVar3.jk()) {
                        this.z.obtainMessage(1).sendToTarget();
                        return;
                    } else {
                        this.z.removeMessages(1);
                        hf(false);
                        return;
                    }
                }
                return;
            }
            if (am()) {
                return;
            }
            if (!z && (wVar = this.kd) != null && wVar.e() != null && this.kd.e().g()) {
                this.z.removeMessages(1);
                hf(false);
            } else if (z) {
                this.z.obtainMessage(1).sendToTarget();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        com.bykv.vk.openvk.component.video.api.u.w wVar;
        com.bykv.vk.openvk.component.video.api.u.w wVar2;
        com.bykv.vk.openvk.component.video.api.u.w wVar3;
        super.onWindowVisibilityChanged(i);
        if (this.tj) {
            z();
            j();
            if (this.bl) {
                this.bl = i == 0;
            }
            if (ai() && (wVar3 = this.kd) != null && wVar3.jk()) {
                q();
                r.xj((View) this.tf, 8);
                u(true);
                f();
                return;
            }
            c();
            if (zg() || !am() || (wVar = this.kd) == null || wVar.zg() || this.u == null) {
                return;
            }
            boolean hf2 = l.hf(this, 20, 5);
            isShown();
            if (this.ai && h.am(this.u) != null && hf2) {
                com.bykv.vk.openvk.component.video.api.w.u xj2 = h.xj(4, this.u);
                xj2.hf(this.u.ho());
                xj2.hf(this.y.getWidth());
                xj2.w(this.y.getHeight());
                xj2.w(this.u.jf());
                xj2.xj(this.q);
                xj2.hf(qt());
                xj(xj2);
                r.xj((View) this.tf, 8);
            } else {
                try {
                    StringBuilder sb = new StringBuilder("onWindowVisibilityChanged materialMeta.getVideo() is null ");
                    sb.append(this.tf == null);
                    sb.append(" ");
                    sb.append(this.bl);
                    sb.append(" ");
                    sb.append(hashCode());
                    pl.u("NativeVideoAdView", sb.toString());
                    if (this.bl && this.tf == null) {
                        p();
                        r.xj((View) this.tf, 0);
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
            if (i != 0 || !this.r || this.z == null || (wVar2 = this.kd) == null || wVar2.jk()) {
                return;
            }
            this.z.obtainMessage(1).sendToTarget();
        }
    }

    public void p() {
        TTViewStub tTViewStub;
        if (et() || this.w == null || (tTViewStub = this.l) == null || tTViewStub.getParent() == null || this.u == null || this.tf != null) {
            return;
        }
        if (this.l.getParent() != null && (this.l.getParent() instanceof ViewGroup)) {
            this.tf = (RelativeLayout) this.l.xj();
        }
        this.p = (ImageView) findViewById(2114387954);
        ImageView imageView = (ImageView) findViewById(2114387847);
        this.g = imageView;
        if (this.am) {
            r.xj((View) imageView, 0);
        }
        if (!TextUtils.isEmpty(h.hf(this.u))) {
            com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.u)).to(this.p);
            xj(this.p, h.hf(this.u));
        }
        ht();
    }

    public boolean pl() {
        ws wsVar = this.u;
        return wsVar != null && wsVar.uh() == 4 && hl.xj(this.u) == 1 && !TextUtils.equals("draw_ad", this.qt);
    }

    public boolean qt() {
        return this.f;
    }

    public void setAdCreativeClickListener(xj xjVar) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) wVar).xj(xjVar);
        }
    }

    public void setComplete(boolean z) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            wVar.w(z);
        }
    }

    public void setControllerStatusCallBack(u uVar) {
        this.v = uVar;
    }

    public void setDrawVideoListener(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) wVar).xj(xjVar);
        }
    }

    public void setEasyPlayableEventSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c cVar) {
        this.tu = cVar;
    }

    public void setEnableAutoCheck(boolean z) {
        this.tj = z;
    }

    public void setEnableBlur(boolean z) {
        this.d = z;
    }

    public void setIsAutoPlay(boolean z) {
        ws wsVar;
        if (this.j || (wsVar = this.u) == null) {
            return;
        }
        int c = pz.hf().c(wo.d(wsVar));
        if (z && c != 4 && (!com.bytedance.sdk.component.utils.am.kd(this.w) ? !(!com.bytedance.sdk.component.utils.am.y(this.w) ? com.bytedance.sdk.component.utils.am.u(this.w) : en() || l()) : !en())) {
            z = false;
        }
        this.xj = z;
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            wVar.u(z);
        }
        if (this.xj) {
            r.xj((View) this.tf, 8);
        } else {
            p();
            RelativeLayout relativeLayout = this.tf;
            if (relativeLayout != null) {
                r.xj((View) relativeLayout, 0);
                if (h.am(this.u) != null) {
                    com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.u)).to(this.p);
                    xj(this.p, h.hf(this.u));
                } else {
                    pl.u("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        }
        this.j = true;
    }

    public void setIsQuiet(boolean z) {
        this.f = z;
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            wVar.hf(z);
        }
    }

    public void setMaterialMeta(ws wsVar) {
        this.u = wsVar;
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.x = nativeExpressVideoView;
    }

    public void setNativeVideoAdListener(w.xj xjVar) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            wVar.xj(xjVar);
        }
    }

    public void setNativeVideoController(com.bykv.vk.openvk.component.video.api.u.w wVar) {
        this.kd = wVar;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.am = z;
    }

    public void setVideoAdClickListenerTTNativeAd(g gVar) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) wVar).xj(gVar);
        }
    }

    public void setVideoAdInteractionListener(w.InterfaceC0013w interfaceC0013w) {
        this.wo = interfaceC0013w;
    }

    public void setVideoAdLoadListener(w.u uVar) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            wVar.xj(uVar);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.pz = str;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            g();
        }
    }

    public void tf() {
        u uVar;
        com.bykv.vk.openvk.component.video.api.u.w wVar;
        if (this.hf || (uVar = this.v) == null || (wVar = this.kd) == null) {
            return;
        }
        uVar.xj(wVar.jk(), this.kd.am(), this.kd.am() + this.kd.pl(), this.kd.p(), this.xj, this.f);
    }

    public void v() {
        ai aiVar = this.z;
        if (aiVar != null) {
            aiVar.removeCallbacksAndMessages(null);
        }
    }

    public void yo() {
        if (this.kd != null) {
            ff();
            this.kd.hf();
        }
    }

    public boolean zg() {
        return this.hf;
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    public void hf(long j, int i) {
        this.ra = true;
    }

    public void u() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar == null) {
            B_();
        } else if ((wVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.u) && !zg()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) this.kd).hl();
        }
        if (this.kd == null || !this.jk.get()) {
            return;
        }
        this.jk.set(false);
        c();
        if (!am()) {
            if (this.kd.jk()) {
                u(true);
                return;
            }
            pl.xj("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            p();
            r.xj((View) this.tf, 0);
            return;
        }
        ImageView imageView = this.f10445pl;
        if (imageView != null) {
            r.xj((View) imageView, 8);
        }
        if (h.am(this.u) == null) {
            pl.u("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        com.bykv.vk.openvk.component.video.api.w.u xj2 = h.xj(4, this.u);
        xj2.hf(this.u.ho());
        xj2.hf(this.y.getWidth());
        xj2.w(this.y.getHeight());
        xj2.w(this.u.jf());
        xj2.xj(0L);
        xj2.xj(tf.xj(this.u));
        xj2.hf(qt());
        if (et()) {
            String w2 = d.xj(0).w();
            if (this.u.qe()) {
                w2 = d.xj();
            }
            xj2.xj(w2);
        }
        xj(xj2);
        this.kd.w(false);
    }

    public void w(boolean z) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c cVar = this.tu;
        if (cVar != null) {
            cVar.xj(z);
        }
    }

    public NativeVideoTsView(Context context, ws wsVar, boolean z, boolean z2) {
        this(context, wsVar, z, z2, "embeded_ad", false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(int i, int i2) {
        if (zg()) {
            return;
        }
        ws wsVar = this.u;
        am fj = wsVar == null ? null : wsVar.fj();
        if (fj != null && i2 > 0) {
            if (!fj.f()) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.u, this.qt, 1);
                return;
            }
            this.ws = i;
            this.eu = i2;
            if (this.hl == null) {
                this.hl = new w(fj, this.y, this.u, this.qt, i, i2);
            }
            com.bytedance.sdk.openadsdk.f.hf.xj(fj.kd()).type(3).config(Bitmap.Config.RGB_565).to(this.hl);
        }
    }

    public NativeVideoTsView(Context context, ws wsVar, String str, boolean z, boolean z2) {
        this(context, wsVar, false, false, str, z, z2);
    }

    public NativeVideoTsView(Context context, ws wsVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        this.xj = true;
        this.f = true;
        this.hf = false;
        this.ht = false;
        this.ra = false;
        this.dk = false;
        this.et = true;
        this.f10444io = false;
        this.am = true;
        this.qt = "embeded_ad";
        this.zg = 50;
        this.ai = true;
        this.e = new AtomicBoolean(false);
        this.j = false;
        this.en = com.bytedance.sdk.openadsdk.core.a.tf.hf();
        this.yo = false;
        this.ff = 50L;
        this.f10443a = 500L;
        this.r = true;
        this.b = false;
        this.tj = true;
        this.n = true;
        this.qd = false;
        this.jk = new AtomicBoolean(false);
        this.bl = true;
        this.wa = false;
        this.gh = new AtomicBoolean(false);
        this.qt = str;
        this.w = context;
        this.u = wsVar;
        this.hf = z;
        this.f10444io = z2;
        this.dk = z3;
        this.et = z4;
        this.z = new ai(com.bytedance.sdk.openadsdk.x.c.hf(), this);
        setContentDescription("NativeVideoAdView");
        c();
        pz();
        com.bytedance.sdk.openadsdk.x.c.hf(new com.bytedance.sdk.component.tf.d("ts_video") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeVideoTsView.s == null) {
                    com.bytedance.sdk.component.u.hf.w unused = NativeVideoTsView.s = NativeVideoTsView.this.getKvCache();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.xj
    public void xj(long j, int i) {
        this.qd = true;
        w.InterfaceC0013w interfaceC0013w = this.wo;
        if (interfaceC0013w != null) {
            interfaceC0013w.t_();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.xj
    public void xj() {
        if (this.wo == null || !et()) {
            return;
        }
        this.wo.t_();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.xj
    public void xj(long j, long j2) {
        com.bykv.vk.openvk.component.video.api.u.w wVar;
        if (j != j2) {
            this.qd = false;
        }
        w.InterfaceC0013w interfaceC0013w = this.wo;
        if (interfaceC0013w != null) {
            interfaceC0013w.xj(j, j2);
        }
        if (x() || (wVar = this.kd) == null) {
            return;
        }
        wVar.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(boolean z) {
        if (this.qd || this.ht == z) {
            return;
        }
        if (!z) {
            com.bytedance.sdk.component.utils.f.hf().removeCallbacks(this.dq);
        }
        this.ht = z;
        w(z);
        if (this.u == null || this.kd == null) {
            return;
        }
        boolean ai = ai();
        q();
        if (ai && this.kd.jk()) {
            u(true);
            f();
            return;
        }
        if (z && !this.kd.jk() && !this.kd.zg()) {
            if (this.kd.e() != null && this.kd.e().am()) {
                if (this.xj) {
                    if ("ALP-AL00".equals(this.en)) {
                        this.kd.f();
                    } else {
                        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) this.kd).y(ai);
                    }
                    w.InterfaceC0013w interfaceC0013w = this.wo;
                    if (interfaceC0013w != null) {
                        interfaceC0013w.s_();
                        return;
                    }
                    return;
                }
                this.ht = false;
                return;
            }
            if (this.xj && this.kd.e() == null) {
                if (!this.jk.get()) {
                    this.jk.set(true);
                }
                this.gh.set(false);
                u();
                return;
            }
            return;
        }
        if (this.kd.e() == null || !this.kd.e().g()) {
            return;
        }
        this.kd.y();
        w.InterfaceC0013w interfaceC0013w2 = this.wo;
        if (interfaceC0013w2 != null) {
            interfaceC0013w2.r_();
        }
    }

    private View xj(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387848);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.y = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387756);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.c = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.kd());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387607);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.l = tTViewStub;
        return frameLayout;
    }

    public void u(boolean z) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            wVar.w(z);
            com.bykv.vk.openvk.component.video.api.u.hf yo = this.kd.yo();
            if (yo != null) {
                yo.hf();
                View w2 = yo.w();
                if (w2 != null) {
                    if (w2.getParent() != null) {
                        ((ViewGroup) w2.getParent()).removeView(w2);
                    }
                    w2.setVisibility(0);
                    addView(w2);
                    yo.xj(this.u, new WeakReference<>(this.w), false);
                }
            }
        }
    }

    public void xj(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.kd.xj.xj(this.u) || com.bytedance.sdk.openadsdk.kd.xj.c(this.u)) {
            return;
        }
        com.bytedance.sdk.openadsdk.f.hf.xj(str).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg<Bitmap> zgVar) {
                Bitmap result;
                if (zgVar == null || (result = zgVar.getResult()) == null) {
                    return;
                }
                final Bitmap xj2 = com.bytedance.sdk.component.adexpress.u.hf.xj(NativeVideoTsView.this.w, result, 25);
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (xj2 != null) {
                            imageView.setBackground(new BitmapDrawable(xj2));
                        }
                    }
                });
            }
        }, 4);
    }

    public void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.l.getParent() != null && (this.l.getParent() instanceof ViewGroup)) {
            this.tf = (RelativeLayout) this.l.xj();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.p = imageView;
        imageView.setImageDrawable(null);
        this.g = (ImageView) findViewById(2114387847);
        com.bytedance.sdk.openadsdk.f.hf.xj(str).to(this.p);
        xj(this.p, str);
        r.xj((View) this.tf, 0);
    }

    public void hf(boolean z, boolean z2) {
        this.n = z;
        this.yy = z2;
    }

    public void hf(int i) {
        if (com.bytedance.sdk.component.utils.am.w(pz.getContext()) == 0) {
            return;
        }
        if (this.kd.e() != null) {
            if (this.kd.e().g() && i == 2) {
                hf(false);
                ai aiVar = this.z;
                if (aiVar != null) {
                    aiVar.removeMessages(1);
                }
                xj(true);
                return;
            }
            if (this.kd.e().am() && i == 3) {
                this.xj = true;
                hf(true);
                c();
                ai aiVar2 = this.z;
                if (aiVar2 != null) {
                    aiVar2.sendEmptyMessageDelayed(1, this.ff);
                }
                xj(false);
                return;
            }
        }
        if (am() || this.gh.get()) {
            return;
        }
        this.gh.set(true);
        if (h.am(this.u) != null) {
            ff();
            com.bykv.vk.openvk.component.video.api.w.u xj2 = h.xj(4, this.u);
            xj2.hf(this.u.ho());
            xj2.hf(this.y.getWidth());
            xj2.w(this.y.getHeight());
            xj2.w(this.u.jf());
            xj2.xj(this.q);
            xj2.hf(qt());
            xj2.xj(d.xj(this.u.ul()).u());
            xj(xj2);
        } else {
            pl.u("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        ai aiVar3 = this.z;
        if (aiVar3 != null) {
            aiVar3.sendEmptyMessageDelayed(1, this.ff);
        }
        xj(false);
    }

    public com.bykv.vk.openvk.component.video.api.u.w xj(Context context, ViewGroup viewGroup, ws wsVar, String str, boolean z, boolean z2, boolean z3) {
        return new com.bytedance.sdk.openadsdk.core.video.nativevideo.u(context, viewGroup, wsVar, str, z, z2, z3);
    }

    public boolean xj(long j, boolean z, boolean z2) {
        boolean z3 = false;
        this.y.setVisibility(0);
        if (this.kd == null) {
            this.kd = new com.bytedance.sdk.openadsdk.core.video.nativevideo.u(this.w, this.c, this.u, this.qt, this.dk, this.et);
            dk();
        }
        this.q = j;
        if (zg()) {
            this.kd.xj(false);
            if (h.am(this.u) != null) {
                com.bykv.vk.openvk.component.video.api.w.u xj2 = h.xj(4, this.u);
                xj2.hf(this.u.ho());
                xj2.hf(this.y.getWidth());
                xj2.w(this.y.getHeight());
                xj2.w(this.u.jf());
                xj2.xj(j);
                xj2.hf(qt());
                if (z2) {
                    this.kd.hf(xj2);
                    return true;
                }
                z3 = xj(xj2);
            }
            if (((j > 0 && !z && !z2) || (j > 0 && z && !this.f10444io)) && (this.kd instanceof com.bytedance.sdk.openadsdk.core.video.xj.xj)) {
                e.xj xjVar = new e.xj();
                xjVar.xj(this.kd.p());
                xjVar.w(this.kd.am());
                xjVar.hf(this.kd.pl());
                com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) wVar).hf(wVar.yo(), xjVar);
            }
            return z3;
        }
        if (pl() || this.d) {
            xj(this.w, 25, h.hf(this.u));
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what != 1) {
            return;
        }
        io();
    }

    public void hf() {
        if (com.bytedance.sdk.component.utils.am.w(pz.getContext()) == 0) {
            return;
        }
        if (this.kd.e() != null) {
            if (this.kd.e().g()) {
                hf(false);
                ai aiVar = this.z;
                if (aiVar != null) {
                    aiVar.removeMessages(1);
                }
                xj(true);
                return;
            }
            if (this.kd.e().am()) {
                this.xj = true;
                hf(true);
                c();
                ai aiVar2 = this.z;
                if (aiVar2 != null) {
                    aiVar2.sendEmptyMessageDelayed(1, this.ff);
                }
                xj(false);
                return;
            }
        }
        if (am() || this.gh.get()) {
            return;
        }
        this.gh.set(true);
        if (h.am(this.u) != null) {
            ff();
            com.bykv.vk.openvk.component.video.api.w.u xj2 = h.xj(4, this.u);
            xj2.hf(this.u.ho());
            xj2.hf(this.y.getWidth());
            xj2.w(this.y.getHeight());
            xj2.w(this.u.jf());
            xj2.xj(this.q);
            xj2.hf(qt());
            xj(xj2);
        } else {
            pl.u("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        ai aiVar3 = this.z;
        if (aiVar3 != null) {
            aiVar3.sendEmptyMessageDelayed(1, this.ff);
        }
        xj(false);
    }

    public boolean xj(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        if (this.kd == null) {
            return false;
        }
        this.ai = false;
        this.ff = this.f10443a;
        if (this.yy) {
            uVar.hf(this.n);
        }
        return this.kd.xj(uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.u.xj
    public void xj(int i) {
        c();
    }

    public void xj(boolean z) {
        if (this.f10445pl == null) {
            this.f10445pl = new ImageView(getContext());
            if (f.zg().eu() != null) {
                this.f10445pl.setImageBitmap(f.zg().eu());
            } else {
                jk.xj(pz.getContext(), "tt_new_play_video", this.f10445pl);
            }
            this.f10445pl.setScaleType(ImageView.ScaleType.FIT_XY);
            int w2 = r.w(getContext(), this.zg);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(w2, w2);
            layoutParams.gravity = 17;
            this.y.addView(this.f10445pl, layoutParams);
        }
        if (z) {
            this.f10445pl.setVisibility(0);
        } else {
            this.f10445pl.setVisibility(8);
        }
    }

    public void xj(int i, int i2) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) wVar).xj(i, i2);
        }
    }

    public void xj(final Context context, final int i, String str) {
        final com.bykv.vk.openvk.component.video.api.u.hf yo;
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar == null || (yo = wVar.yo()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.f.hf.xj(str).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i2, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg<Bitmap> zgVar) {
                Bitmap xj2 = com.bytedance.sdk.component.adexpress.u.hf.xj(context, zgVar.getResult(), i);
                if (xj2 == null) {
                    return;
                }
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(NativeVideoTsView.this.getResources(), xj2);
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bykv.vk.openvk.component.video.api.u.hf hfVar = yo;
                        if (hfVar != null) {
                            hfVar.xj(bitmapDrawable);
                        }
                    }
                });
            }
        }, 4);
    }
}
