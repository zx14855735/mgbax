package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.component.video.api.u.hf;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bykv.vk.openvk.component.video.api.xj;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.et;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.gy;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.qt;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.x.tf;
import com.bytedance.sdk.openadsdk.y.w.e;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import com.sigmob.sdk.base.blurkit.d;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.core.video.xj.xj {
    private Map<String, Object> aq;
    private int bl;
    private long dc;
    private long dq;
    private boolean en;
    private WeakReference<xj> eu;
    private WeakReference<w.hf> ff;

    /* renamed from: io, reason: collision with root package name */
    private ViewGroup f10448io;
    private String j;
    private boolean l;
    private int n;
    private w.xj q;
    private int tj;
    private int wn;
    private WeakReference<w.u> ws;
    private final boolean z;
    private long x = 0;
    private long ai = 0;

    /* renamed from: a, reason: collision with root package name */
    private boolean f10447a = false;
    private boolean wo = false;
    private boolean r = true;
    private volatile boolean b = false;
    private int yy = 0;
    private boolean hl = false;
    private boolean vm = true;
    private xj.InterfaceC0014xj tu = new xj.InterfaceC0014xj() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1
        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void w(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            u.this.op();
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.wn();
                }
            });
            u.this.xj(4);
            u.this.w(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            if (!u.this.z || tf.xj(((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).y)) {
                u.this.qd();
            }
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.ws != null && u.this.ws.get() != null) {
                        ((w.u) u.this.ws.get()).p_();
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd != null && (!u.this.bl() || !pz.hf().kc())) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.hf();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.removeCallbacks(u.this.et);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, long j) {
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd != null) {
                        if (u.this.bl() && pz.hf().kc()) {
                            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.x();
                        } else {
                            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.hf();
                        }
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.removeCallbacks(u.this.et);
                        u.this.hl = false;
                    }
                    if (u.this.eu != null && u.this.eu.get() != null) {
                        ((xj) u.this.eu.get()).C_();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.removeCallbacks(u.this.et);
                }
            });
            u.this.qd();
            u.this.dc = System.currentTimeMillis();
            u.this.nb();
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, final com.bykv.vk.openvk.component.video.api.w.hf hfVar) {
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.4
                /* JADX WARN: Removed duplicated region for block: B:22:0x00d7  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x00ec  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 327
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.AnonymousClass1.AnonymousClass4.run():void");
                }
            });
            u.this.xj(hfVar.xj(), hfVar.w());
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, boolean z) {
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.hf();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, final int i, final int i2) {
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.6
                @Override // java.lang.Runnable
                public void run() {
                    u.this.hf(i, i2);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2, int i3) {
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.ra();
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.postDelayed(u.this.et, 8000L);
                        u.this.hl = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.hf();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.removeCallbacks(u.this.et);
                    u.this.hl = false;
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, final long j, final long j2) {
            if (Math.abs(j - ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).c) < 50) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ra != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ra.xj(j, j2);
                    }
                    u.this.hf(j, j2);
                    u.this.w(j, j2);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, JSONObject jSONObject, String str) {
            if (f.zg().yy()) {
                jSONObject.optString("start");
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong("start");
            }
            com.bytedance.sdk.openadsdk.core.am.u.xj((Context) ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).d.get(), ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).y, u.this.j, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private int s = 0;
    Runnable et = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.4
        @Override // java.lang.Runnable
        public void run() {
            if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd != null) {
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.xj(((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).y, ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).d, false);
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.hf();
                u.this.w(true);
                pl.u("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private final et.xj qd = new et.xj() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.6
        @Override // com.bytedance.sdk.component.utils.et.xj
        public void xj(Context context, Intent intent, boolean z, int i) {
            u.this.w(context, i);
        }
    };
    private boolean lw = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.u$9, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[qt.xj.values().length];
            xj = iArr;
            try {
                iArr[qt.xj.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[qt.xj.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[qt.xj.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface xj {
        void C_();

        void d();

        void xj(int i);
    }

    public u(Context context, ViewGroup viewGroup, ws wsVar, String str, boolean z, boolean z2, boolean z3) {
        this.j = "embeded_ad";
        this.en = false;
        this.l = true;
        this.tj = 0;
        this.n = 0;
        this.bl = 1;
        this.bl = am.w(context);
        xj(z);
        this.j = str;
        try {
            this.tj = viewGroup.getWidth();
            this.n = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f10448io = viewGroup;
        this.d = new WeakReference<>(context);
        this.y = wsVar;
        xj(context);
        this.z = true;
        this.en = z2;
        this.l = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj, com.bykv.vk.openvk.component.video.api.u.w
    public boolean kd() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj, com.bykv.vk.openvk.component.video.api.u.w
    public boolean u() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean w() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj
    public boolean x() {
        return true;
    }

    private boolean aq() {
        return this.s > 0 && wo.w(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bl() {
        return TextUtils.equals(this.j, "splash_ad") || TextUtils.equals(this.j, "cache_splash_ad");
    }

    private boolean dc() {
        ws wsVar = this.y;
        if (com.bytedance.sdk.openadsdk.kd.xj.hf(wsVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.hf ra = ra();
            if (ra == null) {
                if (this.tu != null) {
                    StringBuilder sb = new StringBuilder("创建lottie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb.append(this.kd == null);
                    this.tu.xj((com.bykv.vk.openvk.component.video.api.xj) null, new com.bykv.vk.openvk.component.video.api.w.hf(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, sb.toString()));
                }
                pl.u("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            this.u = new com.bytedance.sdk.openadsdk.upie.video.lottie.xj(ra, com.bytedance.sdk.openadsdk.kd.xj.d(wsVar), new com.bykv.vk.openvk.component.video.xj.u.u(String.valueOf(wo.f(this.y))), h.e(wsVar));
        } else if (com.bytedance.sdk.openadsdk.kd.xj.w(wsVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.hf ra2 = ra();
            if (ra2 == null) {
                if (this.tu != null) {
                    StringBuilder sb2 = new StringBuilder("创建Upie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb2.append(this.kd == null);
                    this.tu.xj((com.bykv.vk.openvk.component.video.api.xj) null, new com.bykv.vk.openvk.component.video.api.w.hf(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, sb2.toString()));
                }
                pl.u("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int f = wo.f(this.y);
            this.u = new com.bytedance.sdk.openadsdk.upie.video.lottie.hf((ai.u() && this.ht.yo() == 1) ? new com.bytedance.sdk.component.pl.hf.hf(pz.getContext(), String.valueOf(f)) : new com.bykv.vk.openvk.component.video.xj.u.u(String.valueOf(f)), com.bytedance.sdk.openadsdk.kd.xj.d(wsVar), ra2);
        } else {
            int f2 = wo.f(this.y);
            if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y)) {
                this.u = new com.bytedance.sdk.component.pl.xj.xj(pz.getContext(), x(), (long) h.y(this.y), pz.hf().cy(), null);
            } else if (ai.u() && this.ht.yo() == 1) {
                this.u = new com.bytedance.sdk.component.pl.hf.hf(pz.getContext(), String.valueOf(f2));
            } else {
                this.u = new com.bykv.vk.openvk.component.video.xj.u.u(String.valueOf(f2));
            }
        }
        return true;
    }

    private void dq() {
        com.bykv.vk.openvk.component.video.api.w.u uVar;
        pl.xj("NativeVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.tf));
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            if (xjVar.am() && !s()) {
                if (this.tf || (((uVar = this.ht) != null && uVar.c()) || com.bytedance.sdk.openadsdk.kd.xj.hf(this.y))) {
                    wo();
                } else {
                    hf(this.dk);
                }
                pl.xj("NativeVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.tf));
            } else if (s()) {
                this.c = f.zg().qd();
                f.zg().xj(-1L);
                this.u.xj(this.c);
                this.u.hf();
            } else {
                this.u.xj(false, this.c, this.e);
            }
        }
        if (this.pz.xj(2)) {
            e.xj xjVar2 = new e.xj();
            xjVar2.xj(p());
            xjVar2.w(am());
            xjVar2.hf(pl());
            hf(yo(), xjVar2);
        }
    }

    private void gh() {
        if (ai()) {
            d(!this.jk);
            if (this.d.get() instanceof Activity) {
                y yVar = this.kd;
                if (yVar != null) {
                    yVar.hf(this.f10448io);
                    this.kd.w(false);
                }
                y(1);
                WeakReference<w.hf> weakReference = this.ff;
                w.hf hfVar = weakReference != null ? weakReference.get() : null;
                if (hfVar != null) {
                    hfVar.xj(this.jk);
                }
            }
        }
    }

    private void gy() {
        y yVar = this.kd;
        if (yVar != null) {
            yVar.u(0);
            this.kd.xj(false, false);
            this.kd.w(false);
            this.kd.kd();
            this.kd.c();
        }
    }

    private boolean lw() {
        gy xf;
        if (!bl()) {
            return false;
        }
        ws wsVar = this.y;
        return wsVar == null || (xf = wsVar.xf()) == null || xf.xj() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb() {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y) && !TextUtils.isEmpty(this.j)) {
            boolean xj2 = this.pz.xj(1024);
            long longValue = this.pz.hf(1).longValue();
            if (xj2) {
                return;
            }
            this.pz.w(1024);
            if (this.j.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "embeded_ad", System.currentTimeMillis() - longValue, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
            } else if (this.j.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "draw_ad", System.currentTimeMillis() - longValue, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op() {
        y yVar;
        if (!this.b || (yVar = this.kd) == null || yVar.w() == null) {
            return;
        }
        this.b = false;
        this.kd.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.5
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht == null) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.hf(((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).y.ho());
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.hf(u.this.tj);
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.w(u.this.n);
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.xj((List<String>) null);
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.w(((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).y.jf());
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.xj(0L);
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.hf(u.this.v());
                ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.xj(((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).ht.kd());
                u uVar = u.this;
                uVar.xj(((com.bytedance.sdk.openadsdk.core.video.xj.xj) uVar).ht);
                u.this.w(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        if (!this.pz.xj(2) || aq()) {
            e.xj xjVar = new e.xj();
            if (bl()) {
                this.r = true;
            }
            xjVar.hf(this.r);
            xjVar.w(am());
            this.pz.w(2);
            com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd, xjVar);
        }
    }

    private boolean s() {
        return this.f10453pl && f.zg().qd() > 0;
    }

    private boolean tu() {
        return this.s > 0 && tf.xj(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200 || i == 60008;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    private boolean wa() {
        ws wsVar = this.y;
        return wsVar != null && wsVar.bl() == 1 && "draw_ad".equals(this.j) && this.f10448io != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wn() {
        y yVar;
        this.s++;
        if (ai() && (yVar = this.kd) != null) {
            yVar.hf();
            w.xj xjVar = this.q;
            if (xjVar != null) {
                xjVar.xj(this.ai, com.bykv.vk.openvk.component.video.xj.kd.xj.xj(this.c, this.zg));
            }
            this.ai = System.currentTimeMillis() - this.x;
            this.kd.kd(true);
            boolean xj2 = com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y);
            int aq = this.y.aq();
            boolean z = aq <= 0;
            boolean z2 = !z && this.s >= aq;
            boolean w = wo.w(this.y);
            if (!w || z2 || xj2) {
                this.kd.xj(this.y, this.d, true);
            }
            if (!this.pz.xj(64) || aq() || tu()) {
                this.pz.w(64);
                long j = this.zg;
                w(j, j);
                long j2 = this.zg;
                this.c = j2;
                this.f = j2;
                e.xj xjVar2 = new e.xj();
                xjVar2.xj(p());
                xjVar2.w(am());
                xjVar2.hf(pl());
                xjVar2.y(g());
                com.bytedance.sdk.openadsdk.y.hf.u.u(this.kd, xjVar2);
            }
            if (!this.f10453pl && this.jk) {
                kd(this.kd, null);
            }
            this.v = true;
            if (xj2) {
                return;
            }
            if (w && (z || this.s < aq)) {
                et();
                return;
            }
            boolean z3 = am() / 1000 < 10;
            if (tf.xj(this.y) && z3 && this.s < 2) {
                et();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void c() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.w();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void d() {
        xj(true, 3);
    }

    public boolean dk() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        return xjVar == null || xjVar.d();
    }

    public void et() {
        if (am.w(pz.getContext()) == 0) {
            return;
        }
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj();
        }
        w(false);
        if (this.u != null) {
            this.pz.xj();
            tj();
            this.u.xj();
            qd();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void f() {
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj();
        }
        y yVar2 = this.kd;
        if (yVar2 != null) {
            yVar2.dk();
        }
        dq();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public int g() {
        if (e() == null) {
            return 0;
        }
        return e().e();
    }

    public void hl() {
        if (this.lw || !this.vm) {
            return;
        }
        this.lw = true;
        et.xj(this.qd, pz.getContext().getApplicationContext());
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean ht() {
        return this.hl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj
    public Map<String, Object> n() {
        return this.aq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj, com.bykv.vk.openvk.component.video.api.u.w
    public long pl() {
        if (e() == null) {
            return 0L;
        }
        return e().zg();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean pz() {
        return this.r;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public int qt() {
        return com.bykv.vk.openvk.component.video.xj.kd.xj.xj(this.f, this.zg);
    }

    public com.bykv.vk.openvk.component.video.api.renderview.hf ra() {
        y yVar;
        WeakReference<Context> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        if ((this.d.get().getResources().getConfiguration().orientation == 1 || com.bytedance.sdk.openadsdk.kd.xj.xj(this.y)) && (yVar = this.kd) != null) {
            return yVar.e();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void tf() {
        w(am() == 0 ? -2 : -1);
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.kd();
            this.u = null;
        }
        ws wsVar = this.y;
        int aq = wsVar == null ? 2 : wsVar.aq();
        boolean z = aq > 0 && this.s == aq;
        if (!wo.w(this.y) || z) {
            try {
                this.kd.xj(this.y, this.d, true);
            } catch (Exception e) {
                pl.u("NativeVideoController", e.getMessage());
            }
        }
        com.bytedance.sdk.component.utils.ai aiVar = this.xj;
        if (aiVar != null) {
            aiVar.removeCallbacksAndMessages(null);
        }
        List<Runnable> list = this.p;
        if (list != null) {
            list.clear();
        }
        vm();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj
    public void tj() {
        if (this.d == null) {
            return;
        }
        this.pz.w(1);
        com.bytedance.sdk.openadsdk.y.hf.u.xj(this.y, this.kd, this.ht, this.r);
    }

    public void vm() {
        if (this.lw) {
            this.lw = false;
            try {
                et.xj(this.qd);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void y() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.w();
        }
        if ((!this.pz.xj(64) || aq()) && this.pz.xj(2)) {
            e.xj xjVar2 = new e.xj();
            xjVar2.xj(p());
            xjVar2.w(am());
            xjVar2.hf(pl());
            xj(this.kd, xjVar2);
        }
    }

    public boolean yy() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        return xjVar != null && xjVar.g();
    }

    private boolean w(int i, int i2) {
        return i < i2 && wa();
    }

    public void kd(int i) {
        this.wn = i;
    }

    private boolean c(int i) {
        y yVar = this.kd;
        return yVar != null && yVar.w(i);
    }

    private View hf(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(d.f13043a);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387651);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(jk.w(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        View hf = new com.bytedance.sdk.openadsdk.res.layout.video.u().hf(context);
        hf.setId(2114387688);
        hf.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(hf);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387626);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        jk.xj(context, "tt_play_movebar_textpage", imageView2);
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, jk.f(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387653);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float A4TApA2 = A2egSU.A4TApA("#A5FFFFFF", gradientDrawable, context, 1.0f);
        gradientDrawable.setCornerRadius(A4TApA2);
        int w = r.w(context, 2.0f);
        gradientDrawable.setSize(-1, w);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(A4TApA2);
        gradientDrawable2.setSize(-1, w);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(A4TApA2);
        gradientDrawable3.setSize(-1, w);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        View tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.y());
        ViewGroup.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        View tTViewStub2 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.hf());
        ViewGroup.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        View tTViewStub3 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.c());
        ViewGroup.LayoutParams AYUAbz2 = A2egSU.AYUAbz(-2, -2, 13, -1);
        tTViewStub3.setId(2114387828);
        tTViewStub3.setLayoutParams(AYUAbz2);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    private void u(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        if (uVar == null) {
            xj("model is null");
            return;
        }
        final long w = w(uVar);
        if (this.u != null) {
            ws wsVar = this.y;
            if (wsVar != null) {
                uVar.u(String.valueOf(wo.d(wsVar)));
            }
            uVar.u(0);
            this.u.xj(uVar);
            this.u.xj(en());
        }
        this.x = System.currentTimeMillis();
        if (!TextUtils.isEmpty(uVar.zg())) {
            y yVar = this.kd;
            if (yVar != null) {
                yVar.kd(8);
                this.kd.kd(0);
            }
            boolean w2 = wo.w(this.y);
            y yVar2 = this.kd;
            boolean hf = yVar2 != null ? l.hf(yVar2.xj, 50, 9) : true;
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.3
                @Override // java.lang.Runnable
                public void run() {
                    u.this.pz.xj();
                    u.this.tj();
                    u.this.x = System.currentTimeMillis();
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).kd.u(0);
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).u != null && ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).c == 0) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).u.xj(true, w, ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).e);
                    } else if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).u != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).u.xj(true, ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).c, ((com.bytedance.sdk.openadsdk.core.video.xj.xj) u.this).e);
                    }
                }
            };
            if (w2 && !hf) {
                hf(runnable);
                f(true);
                WeakReference<xj> weakReference = this.eu;
                if (weakReference != null && weakReference.get() != null) {
                    this.eu.get().d();
                }
            } else {
                xj(runnable);
            }
        } else {
            xj("url is null");
        }
        if (this.f10453pl) {
            hl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j, long j2) {
        this.c = j;
        this.zg = j2;
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj(j, j2);
            this.kd.hf(com.bykv.vk.openvk.component.video.xj.kd.xj.xj(j, j2));
        }
        try {
            w.xj xjVar = this.q;
            if (xjVar != null) {
                xjVar.xj(j, j2);
            }
        } catch (Throwable th) {
            pl.w("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void kd(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view) {
        xj(hfVar, view, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void kd(boolean z) {
        this.vm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(int i) {
        ws wsVar;
        int w = am.w(pz.getContext());
        if (w == 0) {
            y();
            this.qt = true;
            y yVar = this.kd;
            if (yVar != null) {
                yVar.xj(this.y, this.d, false);
            }
        }
        if (w != 4 && w != 0) {
            y yVar2 = this.kd;
            if (yVar2 != null) {
                yVar2.xj();
            }
            y();
            this.qt = true;
            this.f10447a = false;
            y yVar3 = this.kd;
            if (yVar3 != null && (wsVar = this.y) != null) {
                return yVar3.xj(i, h.am(wsVar), this.l);
            }
        } else if (w == 4) {
            this.qt = false;
            y yVar4 = this.kd;
            if (yVar4 != null) {
                yVar4.jk();
            }
        }
        return true;
    }

    public void xj(ws wsVar) {
        this.y = wsVar;
    }

    public void y(boolean z) {
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj();
        }
        y yVar2 = this.kd;
        if (yVar2 != null && z) {
            yVar2.dk();
        }
        dq();
    }

    public void xj(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar) {
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj(xjVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void w(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view) {
        y yVar = this.kd;
        if (yVar != null) {
            yVar.d();
        }
        xj(1);
        xj(true, 3);
    }

    public void xj(final NativeVideoTsView.xj xjVar) {
        y yVar;
        if (!this.f10453pl || (yVar = this.kd) == null) {
            return;
        }
        yVar.xj(new NativeVideoTsView.xj() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xj
            public void xj(View view, int i) {
                NativeVideoTsView.xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj(view, i);
                }
            }
        });
    }

    public void xj(g gVar) {
        y yVar;
        if (!this.f10453pl || (yVar = this.kd) == null) {
            return;
        }
        yVar.xj(gVar);
    }

    public void y(int i) {
        if (ai()) {
            boolean z = i == 0 || i == 8;
            Context context = this.d.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Context context, int i) {
        hf(context, i);
        if (i == 4) {
            this.qt = false;
        }
    }

    public void xj(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.tj = i;
        this.n = i2;
    }

    @SuppressLint({"InflateParams"})
    private void xj(Context context) {
        EnumSet<hf.xj> noneOf = EnumSet.noneOf(hf.xj.class);
        noneOf.add(hf.xj.hideCloseBtn);
        noneOf.add(hf.xj.hideBackBtn);
        try {
            y xj2 = xj(context, noneOf);
            this.kd = xj2;
            if (xj2 != null) {
                xj2.xj((com.bykv.vk.openvk.component.video.api.u.xj) this);
                this.kd.xj((xj.InterfaceC0173xj) this);
            }
        } catch (Throwable th) {
            pl.u("NativeVideoController", th.getMessage());
        }
    }

    public y xj(Context context, EnumSet<hf.xj> enumSet) {
        View layoutVideoDetail;
        if (this.f10453pl) {
            layoutVideoDetail = hf(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.f10453pl) {
            return new y(context, view, true, enumSet, this.y, this, b(), null);
        }
        return new kd(context, view, true, enumSet, this.y, this, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void u(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view) {
        if (this.jk) {
            d(false);
            y yVar = this.kd;
            if (yVar != null) {
                yVar.hf(this.f10448io);
            }
            y(1);
            return;
        }
        xj(1);
        xj(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(w.u uVar) {
        this.ws = new WeakReference<>(uVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean xj(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        uVar.zg();
        if (TextUtils.isEmpty(uVar.zg())) {
            xj("url is null");
            pl.u("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.ht = uVar;
        this.e = uVar.p();
        this.c = uVar.tf();
        if (uVar.tf() > 0) {
            long tf = uVar.tf();
            this.c = tf;
            long j = this.f;
            if (j > tf) {
                tf = j;
            }
            this.f = tf;
        }
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj();
            if (this.s == 0) {
                this.kd.c();
            }
            this.kd.w(uVar.f(), uVar.d());
            this.kd.w(this.f10448io);
            this.kd.xj(uVar.f(), uVar.d());
        }
        try {
            if (this.u == null) {
                if (!dc()) {
                    xj("create video error");
                    return false;
                }
                this.u.xj(this.tu);
            }
            io();
            this.ai = 0L;
            u(uVar);
            return true;
        } catch (Throwable th) {
            xj(th.getMessage());
            pl.u("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    public u(Context context, ViewGroup viewGroup, ws wsVar, String str, boolean z, boolean z2) {
        this.j = "embeded_ad";
        this.en = false;
        this.l = true;
        this.tj = 0;
        this.n = 0;
        this.bl = 1;
        this.bl = am.w(context);
        try {
            this.tj = viewGroup.getWidth();
            this.n = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f10448io = viewGroup;
        this.j = str;
        this.d = new WeakReference<>(context);
        this.y = wsVar;
        xj(context);
        this.z = true;
        this.en = z;
        this.l = z2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void u(boolean z) {
        this.r = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(w.hf hfVar) {
        this.ff = new WeakReference<>(hfVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(w.xj xjVar) {
        this.q = xjVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.w();
        }
        if ((!this.pz.xj(64) || aq()) && this.pz.xj(2)) {
            e.xj xjVar2 = new e.xj();
            xjVar2.xj(p());
            xjVar2.w(am());
            xjVar2.hf(pl());
            if (map != null) {
                xjVar2.xj(map);
            }
            xj(this.kd, xjVar2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(long j) {
        this.c = j;
        long j2 = this.f;
        if (j2 > j) {
            j = j2;
        }
        this.f = j;
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj();
        }
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.xj(true, this.c, this.e);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(boolean z, int i) {
        if (this.f10453pl) {
            xj(1);
        }
        long am = am();
        if ((!this.pz.xj(64) || aq()) && this.pz.xj(1) && am > 0) {
            if (z) {
                e.xj xjVar = new e.xj();
                xjVar.xj(p());
                xjVar.w(am);
                xjVar.hf(pl());
                xjVar.kd(i);
                xjVar.y(g());
                this.pz.w(32);
                com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd, xjVar, this.aq, !this.pz.xj(2) ? 1 : 0);
            } else {
                e.xj xjVar2 = new e.xj();
                xjVar2.xj(p());
                xjVar2.w(am);
                xjVar2.hf(pl());
                xj(this.kd, xjVar2);
            }
        }
        tf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void hf(Map<String, Object> map) {
        this.aq = map;
    }

    public void hf(int i, int i2) {
        com.bykv.vk.openvk.component.video.api.xj xjVar;
        ViewGroup viewGroup;
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams;
        try {
            WeakReference<Context> weakReference = this.d;
            if (weakReference != null && weakReference.get() != null && ra() != null && (xjVar = this.u) != null && (viewGroup = this.f10448io) != null && viewGroup != null) {
                if (i < 0 && i2 < 0) {
                    i = xjVar.p();
                    i2 = this.u.pl();
                }
                int width = this.f10448io.getWidth();
                int height = this.f10448io.getHeight();
                if (width > 0 && height > 0 && i2 > 0 && i > 0) {
                    if (i == i2) {
                        i4 = width > height ? height : width;
                        i3 = i4;
                    } else if (i > i2) {
                        i3 = (int) Math.round((width * 1.0d) / ((i * 1.0f) / i2));
                        i4 = width;
                    } else if (lw()) {
                        i3 = 0;
                        i4 = 0;
                    } else {
                        i4 = (int) Math.round((height * 1.0f) / ((i2 * 1.0f) / i));
                        i3 = height;
                    }
                    if (i3 > height || i3 <= 0) {
                        i3 = height;
                    }
                    if (hf(i, i2, i4, width)) {
                        i4 = width;
                    }
                    if (lw()) {
                        xj(i, i2, width, height);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, i3);
                    layoutParams2.addRule(13);
                    Object ra = ra();
                    if (ra instanceof TextureView) {
                        ((TextureView) ra).setLayoutParams(layoutParams2);
                    } else if (ra instanceof UpieVideoView) {
                        ((UpieVideoView) ra).setLayoutParams(layoutParams2);
                    } else if (ra instanceof SurfaceView) {
                        ((SurfaceView) ra).setLayoutParams(layoutParams2);
                    }
                    if (!w(i, i2) || (layoutParams = this.f10448io.getLayoutParams()) == null) {
                        return;
                    }
                    layoutParams.height = i3;
                    layoutParams.width = i4;
                    this.f10448io.setLayoutParams(layoutParams);
                    y yVar = this.kd;
                    if (yVar != null) {
                        yVar.xj(layoutParams.width, layoutParams.height);
                        return;
                    }
                    return;
                }
                return;
            }
            WeakReference<Context> weakReference2 = this.d;
            if (weakReference2 != null) {
                weakReference2.get();
            }
            ra();
        } catch (Throwable unused) {
        }
    }

    private void xj(int i, int i2, int i3, int i4) {
        Matrix matrix;
        if (i3 == 0 || i4 == 0) {
            return;
        }
        float f = i3;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i2;
        float f6 = f4 / f5;
        try {
            Object ra = ra();
            if (ra instanceof TextureView) {
                matrix = ((TextureView) ra).getMatrix();
            } else if (ra instanceof UpieVideoView) {
                matrix = ((UpieVideoView) ra).getMatrix();
            } else {
                matrix = ra instanceof SurfaceView ? ((SurfaceView) ra).getMatrix() : null;
            }
            float max = Math.max(f3, f6);
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            matrix.preTranslate((i3 - i) / 2, (i4 - i2) / 2);
            matrix.preScale(f2 / f, f5 / f4);
            matrix.postScale(max, max, i3 / 2, i4 / 2);
            if (ra instanceof TextureView) {
                ((TextureView) ra).setTransform(matrix);
                ((TextureView) ra).postInvalidate();
            } else if (ra instanceof UpieVideoView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((UpieVideoView) ra).setAnimationMatrix(matrix);
                }
                ((UpieVideoView) ra).postInvalidate();
            } else if (ra instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) ra).setAnimationMatrix(matrix);
                }
                ((SurfaceView) ra).postInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view) {
        if (this.u == null || !ai()) {
            return;
        }
        if (this.u.g()) {
            y();
            y yVar = this.kd;
            if (yVar != null) {
                yVar.hf(true, false);
                this.kd.y();
                return;
            }
            return;
        }
        if (!this.u.am()) {
            y yVar2 = this.kd;
            if (yVar2 != null) {
                yVar2.w(this.f10448io);
            }
            xj(this.c);
            y yVar3 = this.kd;
            if (yVar3 != null) {
                yVar3.hf(false, false);
                return;
            }
            return;
        }
        y(false);
        y yVar4 = this.kd;
        if (yVar4 != null) {
            yVar4.hf(false, false);
        }
    }

    private boolean hf(int i, int i2, int i3, int i4) {
        return (i3 > i4 && !w(i, i2)) || i3 <= 0;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void hf(com.bykv.vk.openvk.component.video.api.u.hf hfVar, int i) {
        y yVar = this.kd;
        if (yVar != null) {
            yVar.y();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void hf(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view) {
        hf(hfVar, view, false, false);
    }

    public void hf(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view, boolean z, boolean z2) {
        if (ai()) {
            d(!this.jk);
            if (this.d.get() instanceof Activity) {
                if (this.jk) {
                    y(z ? 8 : 0);
                    y yVar = this.kd;
                    if (yVar != null) {
                        yVar.xj(this.f10448io);
                        this.kd.w(false);
                    }
                } else {
                    y(1);
                    y yVar2 = this.kd;
                    if (yVar2 != null) {
                        yVar2.hf(this.f10448io);
                        this.kd.w(false);
                    }
                }
                WeakReference<w.hf> weakReference = this.ff;
                w.hf hfVar2 = weakReference != null ? weakReference.get() : null;
                if (hfVar2 != null) {
                    hfVar2.xj(this.jk);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, int i) {
        if (this.u == null) {
            return;
        }
        xj(this.dq, c(i));
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, int i, boolean z) {
        if (ai()) {
            long j = (long) (((i * r0) * 1.0f) / 100.0f);
            if (this.zg > 0) {
                this.dq = (int) j;
            } else {
                this.dq = 0L;
            }
            y yVar = this.kd;
            if (yVar != null) {
                yVar.xj(this.dq);
            }
        }
    }

    private void hf(Context context, int i) {
        if (!ai() || context == null || this.bl == i) {
            return;
        }
        this.bl = i;
        if (i != 4 && i != 0) {
            this.f10447a = false;
        }
        if (!this.f10447a && !jk() && this.en) {
            com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.7
                @Override // java.lang.Runnable
                public void run() {
                    u.this.f(2);
                }
            });
        }
        WeakReference<xj> weakReference = this.eu;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eu.get().xj(this.bl);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view, boolean z, boolean z2) {
        if (this.f10453pl) {
            y();
        }
        if (this.kd == null) {
            return;
        }
        if (z && !this.f10453pl && !dk()) {
            this.kd.hf(!yy(), false);
            this.kd.xj(z2, true, false);
        }
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null && xjVar.g()) {
            this.kd.y();
            this.kd.kd();
        } else {
            this.kd.y();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void hf(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        this.ht = uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void hf() {
        if (this.u != null) {
            w(false);
            this.u.xj();
        }
    }

    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view, boolean z) {
        gh();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj() {
        if (am.w(pz.getContext()) == 0) {
            return;
        }
        this.b = true;
        if (this.u == null) {
            tf();
            op();
        } else {
            tf();
        }
    }

    private void xj(long j, boolean z) {
        if (this.u == null) {
            return;
        }
        if (z) {
            gy();
        }
        this.u.xj(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.hf
    public void xj(qt.xj xjVar, String str) {
        int i = AnonymousClass9.xj[xjVar.ordinal()];
        if (i == 1) {
            y();
            return;
        }
        if (i == 2) {
            xj(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            f();
            this.qt = false;
            this.f10447a = true;
        }
    }

    public void xj(Context context, int i) {
        hf(context, i);
        if (i == 4) {
            this.qt = false;
            com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.u.8
                @Override // java.lang.Runnable
                public void run() {
                    u.this.f();
                }
            });
        }
    }

    public void xj(xj xjVar) {
        this.eu = new WeakReference<>(xjVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(int i) {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y)) {
            if (this.dc <= 0) {
                this.dc = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis() - this.dc;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(g()));
                jSONObject.putOpt("buffer_time", Long.valueOf(pl()));
            } catch (Exception e) {
                pl.xj(e);
            }
            if (!this.pz.xj(512)) {
                this.pz.w(512);
                if (this.j.equals("embeded_ad")) {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "embeded_ad", currentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
                } else if (this.j.equals("draw_ad")) {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "draw_ad", currentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y)) {
                if (com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(this.y)) {
                    com.bytedance.sdk.openadsdk.core.live.hf.xj().xj("tobsdk_livesdk_live_window_duration_v2", this.y, currentTimeMillis);
                } else {
                    com.bytedance.sdk.openadsdk.core.video.w.xj.xj("tobsdk_livesdk_live_window_duration_v2", this.y, currentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y)) {
            if (this.j.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "embeded_ad", i, str, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
            } else if (this.j.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "draw_ad", i, str, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
            }
        }
    }
}
