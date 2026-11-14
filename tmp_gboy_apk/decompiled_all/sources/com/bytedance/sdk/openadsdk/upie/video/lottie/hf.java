package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bykv.vk.openvk.component.video.api.xj;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.upie.hf;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements com.bykv.vk.openvk.component.video.api.xj {
    private final com.bykv.vk.openvk.component.video.api.xj d;
    private final int hf;
    private final com.bykv.vk.openvk.component.video.api.renderview.hf p;

    /* renamed from: pl, reason: collision with root package name */
    private LottieAnimationView f10474pl;
    private boolean u;
    private final int w;
    private long y;
    private final String xj = "UpieVideoPlayer";
    private int kd = 0;
    private volatile boolean c = false;
    private volatile boolean f = false;
    private final Map<xj.InterfaceC0014xj, xj.InterfaceC0014xj> tf = new ConcurrentHashMap();

    public hf(com.bykv.vk.openvk.component.video.api.xj xjVar, com.bytedance.sdk.openadsdk.upie.xj xjVar2, com.bykv.vk.openvk.component.video.api.renderview.hf hfVar) {
        this.d = xjVar;
        this.hf = xjVar2.u();
        this.w = xjVar2.kd();
        this.p = hfVar;
        if (hfVar instanceof UpieVideoView) {
            this.f10474pl = ((UpieVideoView) hfVar).getLottieAnimationView();
        }
        xj(xjVar2.xj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.hf.4
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.f && hf.this.c) {
                    hf.this.d.hf();
                    if (hf.this.f10474pl != null) {
                        hf.this.f10474pl.xj();
                        if (hf.this.y > 0) {
                            hf hfVar = hf.this;
                            hfVar.hf(hfVar.y);
                        }
                    }
                }
            }
        });
    }

    public static /* synthetic */ int xj(hf hfVar) {
        int i = hfVar.kd;
        hfVar.kd = i + 1;
        return i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean am() {
        boolean z = !this.u && this.d.am();
        pl.xj("UpieVideoPlayer", "--==--isPaused: " + z + ",      errorInvoked: " + this.u);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int e() {
        return this.d.e();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean g() {
        boolean z = !this.u && this.d.g();
        pl.xj("UpieVideoPlayer", "--==--isPlaying: " + z + ",      errorInvoked: " + this.u);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean qt() {
        boolean z = !this.u && this.d.qt();
        pl.xj("UpieVideoPlayer", "--==--isReleased: " + z + ",      errorInvoked: " + this.u);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long v() {
        return this.d.v();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long yo() {
        return this.d.yo();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long zg() {
        return this.d.zg();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceHolder c() {
        return this.d.c();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean d() {
        boolean z = !this.u && this.d.d();
        pl.xj("UpieVideoPlayer", "--==--isCompleted: " + z + ",      errorInvoked: " + this.u);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceTexture f() {
        return this.d.f();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void kd() {
        pl.xj("UpieVideoPlayer", "--==--release");
        this.d.kd();
        LottieAnimationView lottieAnimationView = this.f10474pl;
        if (lottieAnimationView != null) {
            lottieAnimationView.y();
        }
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.p;
        if (hfVar instanceof UpieVideoView) {
            ((UpieVideoView) hfVar).hf();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int p() {
        return this.hf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int pl() {
        return this.w;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean tf() {
        boolean z = !this.u && this.d.tf();
        pl.xj("UpieVideoPlayer", "--==--isStarted: " + z + ",      errorInvoked: " + this.u);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void u() {
        pl.xj("UpieVideoPlayer", "--==--stop");
        this.d.u();
        LottieAnimationView lottieAnimationView = this.f10474pl;
        if (lottieAnimationView != null) {
            lottieAnimationView.c();
        }
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.p;
        if (hfVar instanceof UpieVideoView) {
            ((UpieVideoView) hfVar).hf();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean y() {
        return this.d.y();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf() {
        pl.xj("UpieVideoPlayer", "--==--play");
        this.d.hf();
        LottieAnimationView lottieAnimationView = this.f10474pl;
        if (lottieAnimationView != null) {
            lottieAnimationView.hf();
        }
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.p;
        if (hfVar instanceof UpieVideoView) {
            ((UpieVideoView) hfVar).xj();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w() {
        pl.xj("UpieVideoPlayer", "--==--pause");
        this.d.w();
        LottieAnimationView lottieAnimationView = this.f10474pl;
        if (lottieAnimationView != null) {
            lottieAnimationView.c();
        }
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.p;
        if (hfVar instanceof UpieVideoView) {
            ((UpieVideoView) hfVar).hf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str) {
        if (TextUtils.isEmpty(str)) {
            xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.xj.hf.w(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    String xj = com.bytedance.sdk.openadsdk.upie.hf.xj().xj(str);
                    if (TextUtils.isEmpty(xj)) {
                        com.bytedance.sdk.openadsdk.upie.hf.xj().xj(str, new hf.xj<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.hf.1.1
                            @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                            public void xj(String str2) {
                                pl.xj("UpieVideoPlayer", "--==-- lottie load jsonStr ok");
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                hf.this.xj(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                            public void xj(int i, String str2) {
                                pl.xj("UpieVideoPlayer", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    hf.this.xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, i, str2));
                                    return;
                                }
                                hf.xj(hf.this);
                                if (hf.this.kd <= 3) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    hf.this.xj(str);
                                } else {
                                    hf.this.xj(new com.bykv.vk.openvk.component.video.api.w.hf(60008, i, str2));
                                }
                            }
                        });
                    } else {
                        pl.xj("UpieVideoPlayer", "--==-- lottie use cache ok");
                        hf.this.xj(xj, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(long j) {
        LottieAnimationView lottieAnimationView = this.f10474pl;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = yo();
            }
            if (duration > 0) {
                this.f10474pl.setProgress((j % duration) / duration);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w(boolean z) {
        this.d.w(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final com.bykv.vk.openvk.component.video.api.w.hf hfVar) {
        com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.hf.2
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.u) {
                    return;
                }
                hf.this.u = true;
                pl.xj("UpieVideoPlayer", "--==--play err, code: " + hfVar.xj() + ", extra: " + hfVar.hf() + ", msg: " + hfVar.w());
                Iterator it = hf.this.tf.entrySet().iterator();
                while (it.hasNext()) {
                    ((xj.InterfaceC0014xj) ((Map.Entry) it.next()).getKey()).xj(hf.this, hfVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.hf.3
            @Override // java.lang.Runnable
            public void run() {
                hf.this.c = true;
                if (hf.this.f10474pl != null) {
                    hf.this.f10474pl.xj(str, str2);
                }
                hf.this.jk();
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(u uVar) {
        pl.xj("UpieVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(uVar)));
        this.d.xj(uVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(boolean z) {
        this.d.hf(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(int i) {
        this.d.hf(i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z) {
        pl.xj("UpieVideoPlayer", "--==--isMute: ".concat(String.valueOf(z)));
        this.d.xj(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(int i) {
        pl.xj("UpieVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i)));
        this.d.xj(i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z, long j, boolean z2) {
        pl.xj("UpieVideoPlayer", "--==--start: " + z + ", " + j + ", " + z2);
        this.d.xj(z, j, z2);
        this.y = j;
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.p;
        if (hfVar instanceof UpieVideoView) {
            ((UpieVideoView) hfVar).xj();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj() {
        pl.xj("UpieVideoPlayer", "--==--restart");
        this.d.xj();
        LottieAnimationView lottieAnimationView = this.f10474pl;
        if (lottieAnimationView != null) {
            lottieAnimationView.y();
            this.f10474pl.setProgress(0.0f);
            this.f10474pl.xj();
        }
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.p;
        if (hfVar instanceof UpieVideoView) {
            ((UpieVideoView) hfVar).xj();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(long j) {
        pl.xj("UpieVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j)));
        this.d.xj(j);
        hf(j);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(SurfaceHolder surfaceHolder) {
        this.d.xj(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(SurfaceTexture surfaceTexture) {
        this.d.xj(surfaceTexture);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(final xj.InterfaceC0014xj interfaceC0014xj) {
        if (interfaceC0014xj == null) {
            return;
        }
        xj.InterfaceC0014xj interfaceC0014xj2 = new xj.InterfaceC0014xj() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.hf.5
            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar) {
                com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.hf.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.f = true;
                        if (!hf.this.c) {
                            hf.this.d.w();
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        interfaceC0014xj.hf(hf.this);
                        hf.this.jk();
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void w(com.bykv.vk.openvk.component.video.api.xj xjVar) {
                interfaceC0014xj.w(hf.this);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar) {
                interfaceC0014xj.xj(hf.this);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
                interfaceC0014xj.hf(hf.this, i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, final long j) {
                com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.hf.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        interfaceC0014xj.xj(hf.this, j);
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, com.bykv.vk.openvk.component.video.api.w.hf hfVar) {
                hf.this.xj(hfVar);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, boolean z) {
                interfaceC0014xj.xj(hf.this, z);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2) {
                xj.InterfaceC0014xj interfaceC0014xj3 = interfaceC0014xj;
                hf hfVar = hf.this;
                interfaceC0014xj3.xj((com.bykv.vk.openvk.component.video.api.xj) hfVar, hfVar.hf, hf.this.w);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2, int i3) {
                interfaceC0014xj.xj(hf.this, i, i2, i3);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
                interfaceC0014xj.xj((com.bykv.vk.openvk.component.video.api.xj) hf.this, i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, long j, long j2) {
                interfaceC0014xj.xj(hf.this, j, j2);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, JSONObject jSONObject, String str) {
                interfaceC0014xj.xj(hf.this, jSONObject, str);
            }
        };
        this.tf.put(interfaceC0014xj, interfaceC0014xj2);
        this.d.xj(interfaceC0014xj2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(float f) {
        this.d.xj(f);
        LottieAnimationView lottieAnimationView = this.f10474pl;
        if (lottieAnimationView != null) {
            lottieAnimationView.setSpeed(f);
        }
    }
}
