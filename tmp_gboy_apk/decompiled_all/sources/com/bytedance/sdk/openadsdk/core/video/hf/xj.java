package com.bytedance.sdk.openadsdk.core.video.hf;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.component.video.api.u.hf;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bykv.vk.openvk.component.video.api.xj;
import com.bykv.vk.openvk.component.video.xj.u.u;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.et;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.y;
import com.bytedance.sdk.openadsdk.core.widget.qt;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoPlayLayoutForLive;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.x.tf;
import com.czhj.sdk.common.Constants;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj extends com.bytedance.sdk.openadsdk.core.video.xj.xj {
    private int aq;
    private final String dc;
    private int dq;
    public long et;

    /* renamed from: io, reason: collision with root package name */
    protected ViewGroup f10442io;
    protected com.bytedance.sdk.openadsdk.core.hf.xj j;
    private final int n;
    private w.xj r;
    private long s;
    private WeakReference<w.hf> tj;
    private int tu;
    private long vm;
    private InterfaceC0194xj ws;
    protected long x = 0;
    protected boolean ai = false;
    protected boolean q = false;
    protected Map<String, Object> z = null;
    private final AtomicInteger l = new AtomicInteger(0);
    private final AtomicInteger ff = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    private long f10441a = 0;
    private long wo = 0;
    private final Runnable b = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.1
        @Override // java.lang.Runnable
        public void run() {
            if (xj.this.r != null) {
                xj.this.r.xj();
            }
            if (xj.this.ws != null) {
                xj.this.ws.hf();
            }
        }
    };
    private boolean eu = false;
    private boolean yy = false;
    private boolean hl = true;
    private boolean wn = false;
    xj.InterfaceC0014xj en = new xj.InterfaceC0014xj() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2
        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onPrepared: ");
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.removeCallbacks(xj.this.b);
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd != null) {
                        xj.this.y(0);
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd.hf();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void w(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onRelease: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onCompletion: ");
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.y(false);
                }
            });
            xj.this.xj(4);
            xj.this.w(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onBufferingUpdate: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, long j) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onRenderStart: ");
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd != null) {
                        xj.this.y(0);
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd.hf();
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.removeCallbacks(xj.this.b);
                        xj.this.yy = false;
                    }
                }
            });
            xj.this.xj(j, false);
            xj.this.vm = System.currentTimeMillis();
            xj.this.lw();
            if (xj.this.ws != null) {
                xj.this.ws.w();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(final com.bykv.vk.openvk.component.video.api.xj xjVar, final com.bykv.vk.openvk.component.video.api.w.hf hfVar) {
            if (hfVar == null) {
                return;
            }
            pl.xj("BaseVideoController", "IVideoPlayerCallback video_pip_big_error onError: code:" + hfVar.xj() + " msg:" + hfVar.w());
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bykv.vk.openvk.component.video.api.xj xjVar2;
                    com.bykv.vk.openvk.component.video.api.xj xjVar3;
                    int jk;
                    int xj = hfVar.xj();
                    if (xj == 308 && (xjVar2 = ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).u) != null && xjVar2 != (xjVar3 = xjVar) && (xjVar3 instanceof u) && ((jk = ((u) xjVar3).jk()) == 200 || jk == 203)) {
                        pl.u("BaseVideoController", "ignore errorCode:" + xj + " state:" + jk);
                        return;
                    }
                    xj.this.xj(xj, hfVar.hf(), hfVar.w(), (JSONArray) null);
                    ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.removeCallbacks(xj.this.b);
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd != null) {
                        xj.this.y(0);
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd.hf();
                    }
                    if (xj.this.r != null) {
                        xj.this.r.hf(xj.this.wo, com.bykv.vk.openvk.component.video.xj.kd.xj.xj(((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).c, xj.this.et));
                    }
                    if (xj.this.ws != null) {
                        xj.this.ws.xj(xj, hfVar.w());
                    }
                }
            });
            xj.this.xj(hfVar.xj(), hfVar.w());
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, boolean z) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onSeekCompletion: ");
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2.5
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.removeCallbacks(xj.this.b);
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd != null) {
                        xj.this.y(0);
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd.hf();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onVideoSizeChanged: ");
            xj.this.aq = i;
            xj.this.tu = i2;
            xj.this.wa();
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2, int i3) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onBufferStart: ");
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd != null) {
                        xj.this.y(8);
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd.ra();
                        xj.this.dc();
                        xj.this.yy = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
            pl.xj("BaseVideoController", "IVideoPlayerCallback onBufferEnd: ");
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd != null) {
                        xj.this.y(0);
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd.hf();
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.removeCallbacks(xj.this.b);
                        xj.this.yy = false;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
        public void xj(final com.bykv.vk.openvk.component.video.api.xj xjVar, final long j, final long j2) {
            if (Math.abs(j - ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).c) < 50) {
                return;
            }
            pl.xj("BaseVideoController", "IVideoPlayerCallback onPlayPositionUpdate: current = ", Long.valueOf(j), "; duration=", Long.valueOf(j2));
            ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).ra != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).ra.xj(j, j2);
                    }
                    xj.this.w(j, j2);
                    xj.this.hf(j, j2);
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y.mq() <= 0 || j2 <= ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y.mq() * 1000 || j < ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y.mq() * 1000 || ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).am) {
                        return;
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).am = true;
                    xjVar.u();
                    xj.this.y(false);
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
            com.bytedance.sdk.openadsdk.core.am.u.xj((Context) ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).d.get(), ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y, xj.this.dc, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private final et.xj qd = new et.xj() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.3
        @Override // com.bytedance.sdk.component.utils.et.xj
        public void xj(Context context, Intent intent, boolean z, int i) {
            xj.this.xj(context, i);
        }
    };
    private boolean bl = false;
    private long lw = 0;
    private AtomicBoolean wa = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.hf.xj$9, reason: invalid class name */
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

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.hf.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0194xj {
        void hf();

        void w();

        void xj();

        void xj(int i, String str);

        void xj(long j, long j2);
    }

    public xj(Context context, ViewGroup viewGroup, ws wsVar, com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        this.dq = 1;
        this.dq = am.w(context);
        this.f10442io = viewGroup;
        this.d = new WeakReference<>(context);
        this.y = wsVar;
        this.j = xjVar;
        xj(context);
        this.n = wo.d(this.y);
        this.dc = wo.hf(this.y);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void kd(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean pz() {
        return false;
    }

    public abstract int ra();

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void u(boolean z) {
    }

    public boolean v_() {
        ws wsVar = this.y;
        return wsVar == null || wsVar.yq() == 100.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj
    public boolean x() {
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(w.u uVar) {
    }

    private void c(boolean z) {
        if (!this.pz.xj(64) || w() || u()) {
            this.pz.w(64);
            if (!l() || this.y == null) {
                long j = this.et;
                w(j, j);
                long j2 = this.et;
                this.c = j2;
                this.f = j2;
                ws();
                return;
            }
            if (!z) {
                long j3 = this.et;
                w(j3, j3);
                long j4 = this.et;
                this.c = j4;
                this.f = j4;
                return;
            }
            ws();
            if (this.y.rh() != 8) {
                this.pz.xj();
                tj();
                xj(0L, true);
            }
        }
    }

    private boolean dk() {
        ws wsVar = this.y;
        if (com.bytedance.sdk.openadsdk.kd.xj.hf(wsVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.hf op = op();
            if (op == null) {
                if (this.en != null) {
                    StringBuilder sb = new StringBuilder("创建lottie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb.append(this.kd == null);
                    this.en.xj((com.bykv.vk.openvk.component.video.api.xj) null, new com.bykv.vk.openvk.component.video.api.w.hf(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, sb.toString()));
                }
                pl.u("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            this.u = new com.bytedance.sdk.openadsdk.upie.video.lottie.xj(op, com.bytedance.sdk.openadsdk.kd.xj.d(wsVar), new u(String.valueOf(wo.f(this.y))), h.e(wsVar));
        } else if (com.bytedance.sdk.openadsdk.kd.xj.w(wsVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.hf op2 = op();
            if (op2 == null) {
                if (this.en != null) {
                    StringBuilder sb2 = new StringBuilder("创建Upie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb2.append(this.kd == null);
                    this.en.xj((com.bykv.vk.openvk.component.video.api.xj) null, new com.bykv.vk.openvk.component.video.api.w.hf(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, sb2.toString()));
                }
                pl.u("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int f = wo.f(this.y);
            this.u = new com.bytedance.sdk.openadsdk.upie.video.lottie.hf((ai.u() && this.ht.yo() == 1) ? new com.bytedance.sdk.component.pl.hf.hf(pz.getContext(), String.valueOf(f)) : new u(String.valueOf(f)), com.bytedance.sdk.openadsdk.kd.xj.d(wsVar), op2);
        } else {
            int f2 = wo.f(this.y);
            if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y)) {
                this.u = new com.bytedance.sdk.component.pl.xj.xj(pz.getContext(), x(), (long) h.y(this.y), pz.hf().cy(), null);
            } else if (ai.u() && this.ht.yo() == 1) {
                this.u = new com.bytedance.sdk.component.pl.hf.hf(pz.getContext(), String.valueOf(f2));
            } else {
                this.u = new u(String.valueOf(f2));
            }
        }
        return true;
    }

    private boolean gh() {
        ws wsVar;
        WeakReference<Context> weakReference = this.d;
        return weakReference == null || weakReference.get() == null || op() == null || this.u == null || (wsVar = this.y) == null || hl.y(wsVar) != null || hl.c(this.y) != null || this.y.wa() == 1;
    }

    private void gy() {
        y yVar = this.kd;
        if (yVar != null) {
            yVar.u(0);
            this.kd.xj(false, false);
            this.kd.w(false);
            this.kd.kd();
            y(8);
            this.kd.c();
        }
    }

    private com.bykv.vk.openvk.component.video.api.renderview.hf op() {
        y yVar;
        WeakReference<Context> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null || (yVar = this.kd) == null) {
            return null;
        }
        return yVar.e();
    }

    private void p(boolean z) {
        if (this.ws != null) {
            if (!l() || z) {
                this.ws.xj();
            }
        }
    }

    public boolean aq() {
        return this.wn;
    }

    public boolean bl() {
        return l() ? qd() : w();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void d() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.kd();
            this.u = null;
        }
        y yVar = this.kd;
        if (yVar != null) {
            yVar.d();
        }
        this.xj.removeCallbacks(this.b);
        this.xj.removeCallbacksAndMessages(null);
        this.r = null;
        this.ws = null;
    }

    public void dc() {
        int vh;
        int ra = ra();
        if (ra != 2 && ra != 1) {
            vh = 5;
            if (ra != 5) {
                if (ra == 3) {
                    vh = pz.hf().d(String.valueOf(this.n));
                }
                this.xj.removeCallbacks(this.b);
                this.xj.postDelayed(this.b, vh);
            }
        }
        vh = pz.hf().vh() * 1000;
        this.xj.removeCallbacks(this.b);
        this.xj.postDelayed(this.b, vh);
    }

    public boolean dq() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        return xjVar != null && xjVar.g();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void f() {
        com.bykv.vk.openvk.component.video.api.w.u uVar;
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj();
            this.kd.jk();
            this.kd.dk();
        }
        pl.xj("BaseVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.tf));
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            if (xjVar.am()) {
                if (this.tf || (((uVar = this.ht) != null && uVar.c()) || com.bytedance.sdk.openadsdk.kd.xj.hf(this.y))) {
                    wo();
                } else {
                    hf(this.dk);
                }
                pl.xj("BaseVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.tf));
            } else {
                this.u.xj(false, this.c, this.e);
            }
        }
        if (!this.pz.xj(64) || w() || u()) {
            if (this.pz.xj(2) || tf.xj(this.y)) {
                eu();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public int g() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar == null) {
            return 0;
        }
        return xjVar.e();
    }

    public void hl() {
        ws wsVar = this.y;
        if (wsVar != null) {
            new xj.C0138xj().hf("auto_replay").xj(wo.hf(wsVar)).kd(this.y.ho()).u(this.y.jf()).xj(new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.4
                @Override // com.bytedance.sdk.openadsdk.y.xj.xj
                public void xj(JSONObject jSONObject) {
                    com.bykv.vk.openvk.component.video.api.w.w et;
                    JSONObject jSONObject2 = new JSONObject();
                    if (tf.xj(((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).ht != null && (et = ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).ht.et()) != null && et.c() > 0.0d) {
                        jSONObject2.put("start", et.c());
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean ht() {
        return this.yy;
    }

    public void lw() {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y)) {
            int ra = ra();
            boolean xj = this.pz.xj(1024);
            long longValue = this.pz.hf(1).longValue();
            if (xj) {
                return;
            }
            this.pz.w(1024);
            if (ra == 1) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "rewarded_video", System.currentTimeMillis() - longValue, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
            } else if (ra == 2) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "fullscreen_interstitial_ad", System.currentTimeMillis() - longValue, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj
    public Map<String, Object> n() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.z;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : wo.xj(this.x, this.y, e()).entrySet()) {
            hashMap.put(entry2.getKey(), entry2.getValue());
        }
        return hashMap;
    }

    public boolean qd() {
        boolean w = w();
        if (!w || vm() >= 2) {
            return w;
        }
        return this.lw >= am() - 400;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public int qt() {
        return com.bykv.vk.openvk.component.video.xj.kd.xj.xj(this.f, this.et);
    }

    public boolean s() {
        return this.u.d();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void tf() {
        w(-1);
        d();
    }

    public boolean tu() {
        return this.wa.get();
    }

    public int vm() {
        return tf.xj(this.y) ? this.ff.get() : this.l.get();
    }

    public void wa() {
        this.xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.8
            @Override // java.lang.Runnable
            public void run() {
                if (v.u(((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y) || !xj.this.v_()) {
                    xj xjVar = xj.this;
                    xjVar.xj(xjVar.aq, xj.this.tu);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y) && ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y.rs() == 2 && xj.this.v_()) {
                    return;
                }
                if (!xj.this.v_()) {
                    xj xjVar2 = xj.this;
                    xjVar2.xj(xjVar2.aq, xj.this.tu);
                    return;
                }
                if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y != null && ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y.bl() == 0) {
                    xj xjVar3 = xj.this;
                    xjVar3.u(xjVar3.aq, xj.this.tu);
                } else if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y == null || ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).y.bl() != 2) {
                    xj xjVar4 = xj.this;
                    xjVar4.w(xjVar4.aq, xj.this.tu);
                } else {
                    xj xjVar5 = xj.this;
                    xjVar5.hf(xjVar5.aq, xj.this.tu);
                }
            }
        });
    }

    public void wn() {
        if (!this.pz.xj(64) || w() || u()) {
            if (this.pz.xj(2) || tf.xj(this.y)) {
                eu();
            }
        }
    }

    public void y(boolean z) {
        if (ai() && this.kd != null) {
            this.xj.removeCallbacks(this.b);
            y(0);
            this.kd.hf();
            this.wo = System.currentTimeMillis() - this.f10441a;
            this.kd.kd(true);
            if (wo.y(this.y)) {
                this.kd.xj(this.y, this.d, true);
            } else {
                this.kd.io();
            }
            c(z);
            if (!z) {
                this.wa.set(true);
            }
            w.xj xjVar = this.r;
            if (xjVar != null) {
                xjVar.xj(this.wo, com.bykv.vk.openvk.component.video.xj.kd.xj.xj(this.c, this.et));
            }
            p(z);
            this.v = true;
        }
    }

    public long yy() {
        return this.lw;
    }

    public long kd(long j) {
        long am = (am() * vm()) + (j - ff());
        long j2 = this.lw;
        if (am < j2) {
            return j2;
        }
        this.lw = am;
        return am;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj, com.bykv.vk.openvk.component.video.api.u.w
    public boolean u() {
        if (tf.xj(this.y)) {
            return ((double) this.ff.get()) <= ((double) h.zg(this.y).c());
        }
        return super.u();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean w() {
        return this.l.get() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, int i2) {
        Throwable th;
        float f;
        try {
            pl.xj("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.y.gh());
            if (gh()) {
                return;
            }
            pl.xj("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
            int[] hf = r.hf(pz.getContext());
            boolean z = false;
            boolean z2 = this.y.rs() == 1;
            float f2 = hf[0];
            float f3 = hf[1];
            float f4 = i;
            float f5 = i2;
            try {
                if (z2) {
                    if (f4 > f5) {
                        try {
                            xj(f2, f3, f4, f5, true);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            pl.w("changeVideoSize", "changeSize error", th);
                        }
                    }
                } else if (f4 < f5) {
                    xj(f2, f3, f4, f5, false);
                    return;
                }
                float f6 = f4 / f5;
                float f7 = f2 / f3;
                if (z2) {
                    if (f7 < 0.5625f && f6 == 0.5625f) {
                        f = (f3 * 9.0f) / 16.0f;
                        f5 = f3;
                        z = true;
                    }
                    f = f4;
                } else {
                    if (f7 > 1.7777778f && f6 == 1.7777778f) {
                        f5 = (f2 * 9.0f) / 16.0f;
                        f = f2;
                        z = true;
                    }
                    f = f4;
                }
                pl.xj("changeVideoSize", "适配后宽高：videoHeight=" + f5 + ",videoWidth=" + f);
                if (z) {
                    f2 = f;
                    f3 = f5;
                } else {
                    pl.xj("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f3 + "，videoWidth=" + f2);
                }
                int i3 = (int) f2;
                int i4 = (int) f3;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
                layoutParams.addRule(13);
                Object op = op();
                if ((op instanceof TextureView) || (op instanceof UpieVideoView)) {
                    if (op instanceof TextureView) {
                        ((TextureView) op).setLayoutParams(layoutParams);
                    } else {
                        ((UpieVideoView) op).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.f10442io.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = i4;
                        layoutParams2.width = i3;
                        this.f10442io.setLayoutParams(layoutParams2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                pl.w("changeVideoSize", "changeSize error", th);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void hf() {
        if (this.u != null) {
            if (!kd()) {
                this.l.getAndAdd(1);
                hl();
            }
            this.ff.getAndAdd(1);
            if (!l()) {
                this.pz.xj();
                tj();
                xj(0L, true);
            }
            w(false);
            this.u.xj();
        }
    }

    private void u(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        if (uVar == null) {
            xj("model is null");
            return;
        }
        this.ht = uVar;
        final long w = w(uVar);
        if (this.u != null) {
            ws wsVar = this.y;
            if (wsVar != null) {
                uVar.u(String.valueOf(wo.d(wsVar)));
            }
            uVar.u(1);
            this.u.xj(uVar);
            this.u.xj(en());
        }
        this.f10441a = System.currentTimeMillis();
        if (!TextUtils.isEmpty(uVar.zg())) {
            this.kd.kd(8);
            this.kd.kd(0);
            xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.5
                @Override // java.lang.Runnable
                public void run() {
                    if (xj.this.pz.u(1)) {
                        xj.this.xj("multi play_start");
                        return;
                    }
                    xj.this.pz.xj();
                    if (!xj.this.l() || !xj.this.qd()) {
                        xj.this.tj();
                    }
                    xj.this.f10441a = System.currentTimeMillis();
                    ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).kd.u(0);
                    if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).u != null && ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).c == 0) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).u.xj(true, w, ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).e);
                    } else if (((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).u != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).u.xj(true, ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).c, ((com.bytedance.sdk.openadsdk.core.video.xj.xj) xj.this).e);
                    }
                }
            });
            return;
        }
        xj("url is null");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xj.xj, com.bykv.vk.openvk.component.video.api.u.w
    public boolean kd() {
        if (tf.xj(this.y)) {
            return ((double) this.ff.get()) < ((double) h.zg(this.y).c());
        }
        return super.u();
    }

    @SuppressLint({"InflateParams"})
    private void xj(Context context) {
        EnumSet noneOf = EnumSet.noneOf(hf.xj.class);
        noneOf.add(hf.xj.hideCloseBtn);
        noneOf.add(hf.xj.hideBackBtn);
        y yVar = new y(context.getApplicationContext(), new LayoutVideoPlayLayoutForLive(context), true, noneOf, this.y, this, this.j);
        this.kd = yVar;
        yVar.xj((com.bykv.vk.openvk.component.video.api.u.xj) this);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void kd(boolean z) {
        this.hl = z;
    }

    public void kd(int i) {
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

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void c() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(int i) {
        ws wsVar;
        int w = am.w(pz.getContext());
        if (w != 4 && w != 0) {
            y();
            this.qt = true;
            this.eu = false;
            y yVar = this.kd;
            if (yVar != null && (wsVar = this.y) != null) {
                return yVar.xj(i, h.am(wsVar), true);
            }
        } else if (w == 4) {
            this.qt = false;
            y yVar2 = this.kd;
            if (yVar2 != null) {
                yVar2.jk();
            }
        }
        return true;
    }

    private boolean c(int i) {
        return this.kd.w(i);
    }

    public void xj(long j, boolean z) {
        if (this.pz.xj(2)) {
            return;
        }
        this.x = j;
        tf(z);
        this.q = true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void hf(Map<String, Object> map) {
        this.z = map;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void y() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.w();
        }
        if (!this.pz.xj(64) || w() || u()) {
            if (this.pz.xj(2) || tf.xj(this.y)) {
                w((Map<String, Object>) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(int i, int i2) {
        Throwable th;
        xj xjVar;
        try {
            WeakReference<Context> weakReference = this.d;
            if (weakReference == null || weakReference.get() == null || op() == null || this.u == null || this.y == null) {
                return;
            }
            int[] hf = r.hf(pz.getContext());
            boolean z = this.y.rs() == 1;
            float f = hf[0];
            float f2 = hf[1];
            float f3 = i;
            float f4 = i2;
            try {
                if (z) {
                    if (f3 > f4) {
                        try {
                            xj(f, f2, f3, f4, true);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            pl.w("changeVideoSize", "changeVideoSizeByWidth error", th);
                        }
                    }
                    f2 = (f4 * f) / f3;
                    xjVar = this;
                } else if (f3 < f4) {
                    xj(f, f2, f3, f4, false);
                    return;
                } else {
                    xjVar = this;
                    f = (f3 * f2) / f4;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (xjVar.f10442io != null) {
                    Object op = op();
                    if (op instanceof TextureView) {
                        ((TextureView) op).setLayoutParams(layoutParams);
                    } else if (op instanceof UpieVideoView) {
                        ((UpieVideoView) op).setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                pl.w("changeVideoSize", "changeVideoSizeByWidth error", th);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean xj(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        if (uVar == null) {
            xj("model is null");
            return false;
        }
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null && xjVar.am()) {
            this.u.hf();
            return true;
        }
        this.ht = uVar;
        uVar.zg();
        if (TextUtils.isEmpty(uVar.zg())) {
            pl.u("BaseVideoController", "No video info");
            xj("url is null");
            return false;
        }
        this.ai = (uVar.zg().startsWith(Constants.HTTP) || com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y)) ? false : true;
        this.e = uVar.p();
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
            y(8);
            this.kd.c();
            this.kd.w(uVar.f(), uVar.d());
            this.kd.w(this.f10442io);
        }
        try {
            if (this.u == null) {
                if (!dk()) {
                    xj("create video error");
                    return false;
                }
                this.u.xj(this.en);
            }
            io();
            this.wo = 0L;
            u(uVar);
            return true;
        } catch (Throwable th) {
            xj(th.getMessage());
            pl.u("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
    }

    public void y(int i) {
        Object obj;
        if (this.d == null || !com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y) || this.d.get() == null || (obj = (Context) this.d.get()) == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.f.hf)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.f.hf) obj).xj(i == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2) {
        ws wsVar;
        try {
            WeakReference<Context> weakReference = this.d;
            if (weakReference != null && weakReference.get() != null && op() != null && this.u != null && (wsVar = this.y) != null) {
                boolean z = wsVar.rs() == 1;
                int[] hf = r.hf(pz.getContext());
                xj(hf[0], hf[1], i, i2, z);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j, long j2) {
        this.c = j;
        this.et = j2;
        this.kd.xj(j, j2);
        int xj = com.bykv.vk.openvk.component.video.xj.kd.xj.xj(j, j2);
        if (!w() && !u()) {
            this.kd.hf(xj);
        } else {
            this.kd.hf(100);
        }
        u(j, j2);
        try {
            w.xj xjVar = this.r;
            if (xjVar != null) {
                xjVar.xj(j, j2);
            }
            InterfaceC0194xj interfaceC0194xj = this.ws;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.xj(j, j2);
            }
        } catch (Throwable th) {
            pl.w("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    private void u(long j, long j2) {
        if (l()) {
            final int rh = this.y.rh();
            if (hf(rh)) {
                long ff = ff();
                if (bl() && j >= ff - 200 && this.wa.get() && Math.abs(j - j2) > 200) {
                    this.wa.set(false);
                    this.xj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.6
                        @Override // java.lang.Runnable
                        public void run() {
                            xj.this.y(true);
                            if (rh == 8) {
                                xj.this.e().u();
                            }
                        }
                    });
                }
            }
        }
        kd(j);
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
                    kd(z ? 8 : 0);
                    y yVar = this.kd;
                    if (yVar != null) {
                        yVar.xj(this.f10442io);
                        this.kd.w(false);
                    }
                } else {
                    kd(1);
                    y yVar2 = this.kd;
                    if (yVar2 != null) {
                        yVar2.hf(this.f10442io);
                        this.kd.w(false);
                    }
                }
                WeakReference<w.hf> weakReference = this.tj;
                w.hf hfVar2 = weakReference != null ? weakReference.get() : null;
                if (hfVar2 != null) {
                    hfVar2.xj(this.jk);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void u(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view) {
        if (this.jk) {
            d(false);
            y yVar = this.kd;
            if (yVar != null) {
                yVar.hf(this.f10442io);
            }
            kd(1);
            return;
        }
        xj(1);
        xj(true, 3);
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

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(w.hf hfVar) {
        this.tj = new WeakReference<>(hfVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(w.xj xjVar) {
        this.r = xjVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.w();
        }
        if (!this.pz.xj(64) || w() || u()) {
            if (this.pz.xj(2) || tf.xj(this.y)) {
                w(map);
            }
        }
    }

    private void hf(long j, boolean z) {
        if (this.u == null) {
            return;
        }
        if (z) {
            gy();
        }
        this.u.xj(j);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void hf(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        this.ht = uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(long j) {
        this.c = Math.max(j, e().v());
        this.f = Math.max(this.f, p());
        y yVar = this.kd;
        if (yVar != null) {
            yVar.xj();
        }
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.xj(false, this.c, this.e);
            this.u.xj(this.c);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(boolean z, int i) {
        w(i);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2) {
        ViewGroup viewGroup;
        try {
            if (op() != null && this.u != null && (viewGroup = this.f10442io) != null) {
                float f = i;
                float f2 = i2;
                float width = viewGroup.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.f10442io.getHeight();
                if (f3 <= f2 / (height * 1.0f)) {
                    width = (height / (f2 * 1.0f)) * f;
                } else {
                    height = (width / (f * 1.0f)) * f2;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                Object op = op();
                if (op instanceof TextureView) {
                    ((TextureView) op).setLayoutParams(layoutParams);
                } else if (op instanceof UpieVideoView) {
                    ((UpieVideoView) op).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            pl.w("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    private void xj(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = h.u(this.y);
                f4 = h.w(this.y);
            } catch (Throwable unused) {
                return;
            }
        }
        if (f4 > 0.0f && f3 > 0.0f) {
            if (z) {
                if (f3 < f4) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
            } else if (f3 > f4) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
            }
            layoutParams.addRule(13);
            Object op = op();
            if (op instanceof TextureView) {
                ((TextureView) op).setLayoutParams(layoutParams);
            } else if (op instanceof UpieVideoView) {
                ((UpieVideoView) op).setLayoutParams(layoutParams);
            }
            this.wn = true;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view) {
        if (this.u == null || !ai()) {
            return;
        }
        if (this.u.g()) {
            y();
            this.kd.hf(true, false);
            this.kd.y();
            return;
        }
        if (!this.u.am()) {
            y yVar = this.kd;
            if (yVar != null) {
                yVar.w(this.f10442io);
            }
            xj(this.c);
            y yVar2 = this.kd;
            if (yVar2 != null) {
                yVar2.hf(false, false);
                return;
            }
            return;
        }
        f();
        y yVar3 = this.kd;
        if (yVar3 != null) {
            yVar3.hf(false, false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, int i) {
        if (this.u == null) {
            return;
        }
        hf(this.s, c(i));
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, int i, boolean z) {
        if (ai()) {
            long j = (long) (((i * r0) * 1.0f) / 100.0f);
            if (this.et > 0) {
                this.s = (int) j;
            } else {
                this.s = 0L;
            }
            y yVar = this.kd;
            if (yVar != null) {
                yVar.xj(this.s);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, View view, boolean z, boolean z2) {
        if (this.f10453pl) {
            y();
        }
        if (z && !this.f10453pl && !s()) {
            this.kd.hf(!dq(), false);
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

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj() {
        y yVar = this.kd;
        if (yVar != null) {
            yVar.kd();
            this.kd.xj();
        }
        y yVar2 = this.kd;
        if (yVar2 != null) {
            yVar2.dk();
        }
        xj(-1L);
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
            this.eu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Context context, int i) {
        if (ai() && this.dq != i) {
            if (!this.eu) {
                com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.hf.xj.7
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.f(2);
                    }
                });
            }
            this.dq = i;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(int i) {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y)) {
            int ra = ra();
            long currentTimeMillis = System.currentTimeMillis() - this.vm;
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
                if (ra == 1) {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "rewarded_video", currentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
                } else if (ra == 2) {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "fullscreen_interstitial_ad", currentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
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
            int ra = ra();
            if (ra == 1) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "rewarded_video", i, str, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
            } else if (ra == 2) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.y, "fullscreen_interstitial_ad", i, str, com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd));
            }
        }
    }

    public void xj(InterfaceC0194xj interfaceC0194xj) {
        this.ws = interfaceC0194xj;
    }
}
