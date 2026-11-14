package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bykv.vk.openvk.component.video.api.xj;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.upie.hf;
import com.czhj.sdk.common.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements com.bykv.vk.openvk.component.video.api.xj {

    /* renamed from: a, reason: collision with root package name */
    private ViewTreeObserverOnGlobalLayoutListenerC0207xj f10475a;
    private int ai;
    private final JSONObject am;
    private final Context c;
    private LottieAnimationView d;
    private boolean dk;
    private xj.InterfaceC0014xj e;
    private boolean et;
    private String f;
    private final String g;
    private final String hf;
    private boolean ht;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10476io;
    private boolean j;
    private boolean jk;
    private final int kd;
    private boolean pz;
    private long q;
    private final com.bykv.vk.openvk.component.video.api.xj qt;
    private boolean ra;
    private Bitmap tf;
    private final int u;
    private boolean v;
    private final long w;
    private final com.bykv.vk.openvk.component.video.api.renderview.hf y;
    private boolean zg;
    private final String xj = "TTLottieFakeVideoPlayer";
    private final Map<String, Bitmap> p = new HashMap();

    /* renamed from: pl, reason: collision with root package name */
    private final Map<String, Integer> f10477pl = new HashMap();
    private final Set<xj.InterfaceC0014xj> yo = new HashSet();
    private volatile int x = 200;
    private float z = 1.0f;
    private int en = 0;
    private int l = 0;
    private final Handler wo = new Handler(Looper.getMainLooper());
    private final Runnable r = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.4
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = xj.this.yo.iterator();
            while (it.hasNext()) {
                ((xj.InterfaceC0014xj) it.next()).xj(xj.this, r3.ai, xj.this.yo());
            }
            pl.xj("TTLottieFakeVideoPlayer", "--==--play curr: " + xj.this.ai);
            if (xj.this.ai < xj.this.yo()) {
                xj xjVar = xj.this;
                xjVar.ai = xj.this.x + xjVar.ai;
                xj.this.wo.postDelayed(xj.this.r, xj.this.x);
                return;
            }
            if (xj.this.d != null) {
                xj.this.d.y();
            }
            if (xj.this.pz && !xj.this.ra && xj.this.qt != null && xj.this.qt.g()) {
                xj.this.qt.w();
            }
            xj.this.jk = false;
            xj.this.ht = true;
            xj.this.et();
            Iterator it2 = xj.this.yo.iterator();
            while (it2.hasNext()) {
                ((xj.InterfaceC0014xj) it2.next()).xj(xj.this);
            }
        }
    };
    private long ff = SystemClock.elapsedRealtime();

    /* renamed from: com.bytedance.sdk.openadsdk.upie.video.lottie.xj$xj, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalLayoutListenerC0207xj implements ViewTreeObserver.OnGlobalLayoutListener {
        private final ViewGroup hf;
        private int w;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.hf.getWidth();
            int height = this.hf.getHeight();
            this.hf.removeAllViews();
            int i = this.w;
            this.w = i - 1;
            if (i < 0) {
                this.hf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (width <= 0 || height <= 0) {
                this.hf.addView(xj.this.d);
            } else {
                this.hf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float f = xj.this.u / xj.this.kd;
                float f2 = width;
                float f3 = height;
                float f4 = f2 / f3;
                if (xj.this.kd <= 0 || f < f4) {
                    width = (int) (f3 * f);
                } else {
                    height = (int) (f2 / f);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                this.hf.addView(xj.this.d, layoutParams);
            }
            if (!xj.this.v || xj.this.d.kd()) {
                return;
            }
            xj.this.d.xj();
        }

        private ViewTreeObserverOnGlobalLayoutListenerC0207xj(ViewGroup viewGroup) {
            this.w = 10;
            this.hf = viewGroup;
        }
    }

    public xj(com.bykv.vk.openvk.component.video.api.renderview.hf hfVar, com.bytedance.sdk.openadsdk.upie.xj xjVar, com.bykv.vk.openvk.component.video.api.xj xjVar2, u uVar) {
        this.c = hfVar.getView().getContext();
        this.y = hfVar;
        this.w = xjVar.y();
        this.u = xjVar.u();
        this.kd = xjVar.kd();
        String w = xjVar.w();
        this.g = w;
        String xj = xjVar.xj();
        this.hf = xj;
        String hf = xjVar.hf();
        this.am = xjVar.c();
        xj(xj);
        hf(w);
        this.qt = xjVar2;
        xj(hf, uVar);
    }

    public static /* synthetic */ int dk(xj xjVar) {
        int i = xjVar.en;
        xjVar.en = i + 1;
        return i;
    }

    public static /* synthetic */ int ht(xj xjVar) {
        int i = xjVar.l;
        xjVar.l = i + 1;
        return i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceHolder c() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceTexture f() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(boolean z) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(SurfaceTexture surfaceTexture) {
    }

    private void dk() {
        this.wo.removeCallbacksAndMessages(null);
        this.wo.post(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et() {
        this.wo.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht() {
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.13
            @Override // java.lang.Runnable
            public void run() {
                if (!xj.this.f10476io) {
                    pl.xj("TTLottieFakeVideoPlayer", "--==--audio buffering start");
                    if (xj.this.g()) {
                        xj.this.x();
                    }
                    Iterator it = xj.this.yo.iterator();
                    while (it.hasNext()) {
                        ((xj.InterfaceC0014xj) it.next()).xj(xj.this, -1, -1, -1);
                    }
                }
                xj.this.f10476io = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io() {
        com.bykv.vk.openvk.component.video.api.xj xjVar;
        pl.xj("TTLottieFakeVideoPlayer", "--==--play");
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null && this.pz && !lottieAnimationView.kd()) {
            pl.xj("TTLottieFakeVideoPlayer", "--==--play --- enter");
            if (this.ai > 0) {
                this.d.hf();
            } else {
                this.d.xj();
            }
        }
        if (this.pz && !this.ra && (xjVar = this.qt) != null && !xjVar.g()) {
            pl.xj("TTLottieFakeVideoPlayer", "--==--audio play --- enter");
            if (this.ai > 0) {
                this.qt.hf();
            } else {
                this.qt.xj(0L);
                this.qt.hf();
            }
        }
        this.jk = true;
        dk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        final ViewGroup viewGroup = (ViewGroup) this.y.getView();
        viewGroup.removeAllViews();
        viewGroup.addView(this.d);
        this.f10475a = new ViewTreeObserverOnGlobalLayoutListenerC0207xj(viewGroup);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.f10475a);
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 == view) {
                    viewGroup2.getViewTreeObserver().removeOnGlobalLayoutListener(xj.this.f10475a);
                    viewGroup.removeOnAttachStateChangeListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pz() {
        com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.8
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.tf == null || xj.this.f == null || !xj.this.zg || xj.this.d != null) {
                    return;
                }
                xj.this.d = new LottieAnimationView(xj.this.c);
                xj.this.d.xj(xj.this.f, xj.this.hf);
                xj.this.d.setRepeatCount(-1);
                xj.this.d.setSpeed(xj.this.z);
                xj.this.d.setTextDelegate(new jk(xj.this.d) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.8.1
                    @Override // com.bytedance.adsdk.lottie.jk
                    public String xj(String str) {
                        return com.bytedance.sdk.openadsdk.upie.xj.xj.xj(str, xj.this.am != null ? xj.this.am : null);
                    }
                });
                xj.this.d.setImageAssetDelegate(new com.bytedance.adsdk.lottie.u() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.8.2
                    @Override // com.bytedance.adsdk.lottie.u
                    public Bitmap xj(d dVar) {
                        if (dVar != null) {
                            String pl2 = dVar.pl();
                            if (!TextUtils.isEmpty(pl2)) {
                                if (pl2.startsWith("${") && pl2.endsWith("}")) {
                                    pl2 = com.bytedance.sdk.openadsdk.upie.xj.xj.xj(pl2, xj.this.am);
                                    if (TextUtils.isEmpty(pl2)) {
                                        return null;
                                    }
                                    if (!pl2.startsWith(Constants.HTTP) || TextUtils.equals(pl2, xj.this.g)) {
                                        Bitmap bitmap = xj.this.tf;
                                        if (bitmap != null && (bitmap.getWidth() != dVar.xj() || bitmap.getHeight() != dVar.hf())) {
                                            xj.this.tf = Bitmap.createScaledBitmap(bitmap, dVar.xj(), dVar.hf(), false);
                                        }
                                        return xj.this.tf;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) xj.this.p.get(pl2);
                                if (bitmap2 != null) {
                                    return bitmap2;
                                }
                                xj.this.xj(pl2, dVar.xj(), dVar.hf());
                            }
                        }
                        return null;
                    }
                });
                xj.this.jk();
                xj.this.pz = true;
                pl.xj("TTLottieFakeVideoPlayer", "--==--onPrepared");
                xj.this.ff = SystemClock.elapsedRealtime() - xj.this.ff;
                for (xj.InterfaceC0014xj interfaceC0014xj : xj.this.yo) {
                    interfaceC0014xj.hf(xj.this);
                    xj xjVar = xj.this;
                    interfaceC0014xj.xj((com.bykv.vk.openvk.component.video.api.xj) xjVar, xjVar.u, xj.this.kd);
                }
                if (xj.this.v) {
                    xj.this.qt.xj(xj.this.j);
                    xj.this.qt.w(true);
                    if (xj.this.q > 0) {
                        xj xjVar2 = xj.this;
                        xjVar2.hf(xjVar2.q);
                    } else {
                        xj.this.hf();
                    }
                }
                for (xj.InterfaceC0014xj interfaceC0014xj2 : xj.this.yo) {
                    xj xjVar3 = xj.this;
                    interfaceC0014xj2.xj(xjVar3, xjVar3.ff);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra() {
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.15
            @Override // java.lang.Runnable
            public void run() {
                pl.xj("TTLottieFakeVideoPlayer", "--==--audio buffering end");
                xj.this.f10476io = false;
                if (xj.this.am()) {
                    xj.this.io();
                }
                Iterator it = xj.this.yo.iterator();
                while (it.hasNext()) {
                    ((xj.InterfaceC0014xj) it.next()).xj((com.bykv.vk.openvk.component.video.api.xj) xj.this, -1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.bykv.vk.openvk.component.video.api.xj xjVar;
        pl.xj("TTLottieFakeVideoPlayer", "--==--pause");
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null && this.pz && lottieAnimationView.kd()) {
            pl.xj("TTLottieFakeVideoPlayer", "--==--pause --- enter");
            this.d.c();
        }
        if (this.pz && !this.ra && (xjVar = this.qt) != null && xjVar.g()) {
            pl.xj("TTLottieFakeVideoPlayer", "--==--audio pause --- enter");
            this.qt.w();
        }
        this.jk = false;
        et();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean am() {
        boolean z = (this.jk || this.ht || this.ra || !this.pz) ? false : true;
        pl.xj("TTLottieFakeVideoPlayer", "--==--isPaused: ".concat(String.valueOf(z)));
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean d() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--isCompleted: " + this.ht);
        return this.ht;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int e() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--getBufferCount: 1");
        return 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean g() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--isPlaying: " + this.jk);
        return this.jk;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int p() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--getVideoWidth: " + this.u);
        return this.u;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int pl() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--getVideoHeight: " + this.kd);
        return this.kd;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean qt() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--isReleased: " + this.ra);
        return this.ra;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean tf() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--isStarted: " + this.v);
        return this.v;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long v() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--getCurrentPosition: " + this.ai);
        return this.ai;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(SurfaceHolder surfaceHolder) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long yo() {
        return this.w;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long zg() {
        if (!this.pz) {
            pl.xj("TTLottieFakeVideoPlayer", "--==--is not prepared, getTotalBufferTime: 0");
            return 0L;
        }
        pl.xj("TTLottieFakeVideoPlayer", "--==--getTotalBufferTime: " + this.ff);
        return this.ff;
    }

    private void u(final boolean z) {
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.2
            @Override // java.lang.Runnable
            public void run() {
                pl.xj("TTLottieFakeVideoPlayer", "--==--seek completed");
                Iterator it = xj.this.yo.iterator();
                while (it.hasNext()) {
                    ((xj.InterfaceC0014xj) it.next()).xj(xj.this, z);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void kd() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--release");
        this.ra = true;
        et();
        this.p.clear();
        this.tf = null;
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.qt;
        if (xjVar != null) {
            if (this.pz) {
                xjVar.u();
            }
            this.qt.kd();
        }
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.7
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) xj.this.y.getView();
                if (viewGroup != null) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(xj.this.f10475a);
                }
                Iterator it = xj.this.yo.iterator();
                while (it.hasNext()) {
                    ((xj.InterfaceC0014xj) it.next()).w(xj.this);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean y() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--isFirstFrameSuccess: " + this.pz);
        return this.pz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final int i) {
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.14
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = xj.this.yo.iterator();
                while (it.hasNext()) {
                    ((xj.InterfaceC0014xj) it.next()).hf(xj.this, i);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void u() {
        com.bykv.vk.openvk.component.video.api.xj xjVar;
        pl.xj("TTLottieFakeVideoPlayer", "--==--stop");
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.y();
            this.v = false;
        }
        if (this.pz && !this.ra && (xjVar = this.qt) != null && xjVar.g()) {
            this.qt.w();
        }
        et();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w() {
        x();
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = xj.this.yo.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(final String str) {
        if (TextUtils.isEmpty(str)) {
            xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, "广告主图url为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.hf.xj().hf(str, new hf.xj<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.10
                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(Bitmap bitmap) {
                    xj.this.tf = bitmap;
                    xj.this.pz();
                }

                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(int i, String str2) {
                    xj.dk(xj.this);
                    if (xj.this.en <= 3) {
                        xj.this.hf(str);
                    } else {
                        xj.this.xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, AVMDLDataLoader.KeyIsStoRingBufferSizeKB, "广告主图url加载失败"));
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w(boolean z) {
        pl.xj("TTLottieFakeVideoPlayer", "--==--setLoop:".concat(String.valueOf(z)));
        this.dk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(long j) {
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.xj();
        }
        xj(j);
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.qt;
        if (xjVar != null) {
            xjVar.hf();
        }
        this.jk = true;
        dk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str) {
        if (TextUtils.isEmpty(str)) {
            xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.xj.hf.w(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.9
                @Override // java.lang.Runnable
                public void run() {
                    String xj = com.bytedance.sdk.openadsdk.upie.hf.xj().xj(str);
                    if (TextUtils.isEmpty(xj)) {
                        com.bytedance.sdk.openadsdk.upie.hf.xj().xj(str, new hf.xj<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.9.1
                            @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                            public void xj(String str2) {
                                pl.xj("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr ok");
                                xj.this.f = str2;
                                xj.this.pz();
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                            public void xj(int i, String str2) {
                                pl.xj("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    xj.this.xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, i, str2));
                                    return;
                                }
                                xj.ht(xj.this);
                                if (xj.this.l <= 3) {
                                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                    xj.this.xj(str);
                                } else {
                                    xj.this.xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, i, str2));
                                }
                            }
                        });
                    } else {
                        xj.this.f = xj;
                        xj.this.pz();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str, final int i, final int i2) {
        Integer num = this.f10477pl.get(str);
        if (num == null || num.intValue() != 1) {
            this.f10477pl.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.hf.xj().xj(this.c, str, new hf.xj<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.11
                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        xj.this.p.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (xj.this.d != null) {
                                    xj.this.d.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(int i3, String str2) {
                    xj.this.f10477pl.put(str, 2);
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf() {
        io();
        if (this.ai > 0) {
            com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.5
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = xj.this.yo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final com.bykv.vk.openvk.component.video.api.w.hf hfVar) {
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.12
            @Override // java.lang.Runnable
            public void run() {
                if (!xj.this.et) {
                    pl.xj("TTLottieFakeVideoPlayer", "--==--play err, code: " + hfVar.xj() + ", extra: " + hfVar.hf() + ", msg: " + hfVar.w());
                    Iterator it = xj.this.yo.iterator();
                    while (it.hasNext()) {
                        ((xj.InterfaceC0014xj) it.next()).xj(xj.this, hfVar);
                    }
                }
                xj.this.et = true;
            }
        });
    }

    private void xj(String str, u uVar) {
        if (TextUtils.isEmpty(str)) {
            xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "lottie音频url为空"));
            return;
        }
        xj.InterfaceC0014xj interfaceC0014xj = new xj.InterfaceC0014xj() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xj.3
            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar) {
                xj.this.zg = true;
                xj.this.pz();
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void w(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
                xj.this.w(i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, long j) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, long j, long j2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, JSONObject jSONObject, String str2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, boolean z) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, com.bykv.vk.openvk.component.video.api.w.hf hfVar) {
                int i;
                String str2;
                int i2;
                if (hfVar != null) {
                    i = hfVar.xj();
                    i2 = hfVar.hf();
                    str2 = hfVar.w();
                } else {
                    i = -1;
                    str2 = "";
                    i2 = -1;
                }
                xj.this.xj(new com.bykv.vk.openvk.component.video.api.w.hf(i, i2, "lottie音频播放失败:".concat(String.valueOf(str2))));
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2, int i3) {
                xj.this.ht();
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
                xj.this.ra();
            }
        };
        this.e = interfaceC0014xj;
        this.qt.xj(interfaceC0014xj);
        this.qt.xj(uVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(int i) {
        this.x = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(u uVar) {
        pl.xj("TTLottieFakeVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(uVar)));
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z) {
        pl.xj("TTLottieFakeVideoPlayer", "--==--setQuietPlay: ".concat(String.valueOf(z)));
        this.j = z;
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.qt;
        if (xjVar != null) {
            xjVar.xj(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(long j) {
        pl.xj("TTLottieFakeVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j)));
        this.ai = (int) j;
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = yo();
            }
            if (duration > 0) {
                this.d.setProgress((j % duration) / duration);
            }
        }
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.qt;
        if (xjVar != null && xjVar.yo() > 0) {
            this.qt.xj((int) (j % this.qt.yo()));
        }
        u(true);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(int i) {
        pl.xj("TTLottieFakeVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i)));
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z, long j, boolean z2) {
        pl.xj("TTLottieFakeVideoPlayer", "--==--start: " + z + ", " + j + ", " + z2);
        this.j = z2;
        this.v = true;
        this.q = j;
        this.qt.xj(z, j, z2);
        if (this.pz) {
            this.qt.xj(z2);
            this.qt.w(true);
            if (j > 0) {
                hf(j);
            } else {
                hf();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj() {
        pl.xj("TTLottieFakeVideoPlayer", "--==--reStart");
        et();
        this.ai = 0;
        this.pz = true;
        this.ht = false;
        this.ra = false;
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.y();
            this.d.setProgress(0.0f);
        }
        hf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(xj.InterfaceC0014xj interfaceC0014xj) {
        this.yo.add(interfaceC0014xj);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(float f) {
        this.z = f;
    }
}
