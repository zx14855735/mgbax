package com.bytedance.sdk.component.pl.hf;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.openvk.component.video.api.w;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bykv.vk.openvk.component.video.api.xj;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.pl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements com.bykv.vk.openvk.component.video.api.xj, ai.xj {
    public static volatile boolean xj;
    private volatile ai dk;
    private TTVideoEngine hf;
    private SurfaceHolder ht;
    private int jk;
    private SurfaceTexture pz;
    private long tf;
    private int v;
    private boolean z;
    private boolean w = false;
    private boolean u = false;
    private boolean kd = false;
    private boolean y = false;
    private boolean c = false;
    private boolean f = false;
    private boolean d = false;
    private long p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private long f10214pl = 0;
    private long g = 0;
    private int am = 0;
    private int qt = 0;
    private boolean zg = false;
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean yo = new AtomicBoolean(false);
    private final List<WeakReference<xj.InterfaceC0014xj>> ra = Collections.synchronizedList(new ArrayList());
    private volatile boolean et = false;

    /* renamed from: io, reason: collision with root package name */
    private volatile int f10213io = 200;
    private long x = 0;
    private Runnable ai = new Runnable() { // from class: com.bytedance.sdk.component.pl.hf.hf.1
        @Override // java.lang.Runnable
        public void run() {
            long v = hf.this.v();
            if (hf.this.yo() > 0) {
                if (hf.this.x != v) {
                    if (w.u()) {
                        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "run: lastCur = ", Long.valueOf(hf.this.x), "  curPosition=", Long.valueOf(v));
                    }
                    hf hfVar = hf.this;
                    hfVar.xj(v, hfVar.yo());
                }
                hf.this.x = v;
            }
            if (hf.this.y) {
                hf hfVar2 = hf.this;
                hfVar2.xj(hfVar2.yo(), hf.this.yo());
            } else if (hf.this.dk != null) {
                hf.this.dk.postDelayed(this, hf.this.f10213io);
            }
        }
    };
    private final ArrayList<Runnable> q = new ArrayList<>();

    public hf(Context context, String str) {
        xj(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    private void dk() {
        ArrayList<Runnable> arrayList = this.q;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.q.clear();
    }

    private void et() {
        this.hf.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.bytedance.sdk.component.pl.hf.hf.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i) {
                if (hf.this.am == i) {
                    hf hfVar = hf.this;
                    hfVar.f10214pl = (System.currentTimeMillis() - hf.this.g) + hfVar.f10214pl;
                }
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onBufferEnd: code =", Integer.valueOf(i));
                for (WeakReference weakReference : hf.this.ra) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).xj((com.bykv.vk.openvk.component.video.api.xj) hf.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i, int i2, int i3) {
                hf.this.am = i;
                hf.this.qt++;
                hf.this.g = System.currentTimeMillis();
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onBufferStart: reason =", Integer.valueOf(i), "  afterFirstFrame =", Integer.valueOf(i2), "  action=", Integer.valueOf(i3));
                for (WeakReference weakReference : hf.this.ra) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).xj(hf.this, i, i2, i3);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onBufferingUpdate: percent =", Integer.valueOf(i));
                for (WeakReference weakReference : hf.this.ra) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).hf(hf.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onCompletion: ");
                hf.this.y = true;
                if (hf.this.dk != null) {
                    hf.this.dk.removeCallbacks(hf.this.ai);
                }
                for (WeakReference weakReference : hf.this.ra) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).xj(hf.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onError: ");
                com.bykv.vk.openvk.component.video.api.w.hf hfVar = new com.bykv.vk.openvk.component.video.api.w.hf(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : hf.this.ra) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).xj(hf.this, hfVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onLoadStateChanged: loadState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onMDLHitCache: MDLPlayTaskKey =", str, " hitCacheSize = ", Long.valueOf(j));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onPlaybackStateChanged: playbackState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onPrepare: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onPrepared: ");
                hf.this.c = true;
                for (WeakReference weakReference : hf.this.ra) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).hf(hf.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onRenderSeekComplete: isSeekInCached = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onRenderStart: ");
                hf.this.p = System.currentTimeMillis() - hf.this.tf;
                for (WeakReference weakReference : hf.this.ra) {
                    if (weakReference != null && weakReference.get() != null) {
                        xj.InterfaceC0014xj interfaceC0014xj = (xj.InterfaceC0014xj) weakReference.get();
                        hf hfVar = hf.this;
                        interfaceC0014xj.xj(hfVar, hfVar.p);
                    }
                }
                hf.this.zg = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onRetry: playType = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onUseMDLCacheEnd: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "onVideoSizeChanged: width = ", Integer.valueOf(i), " height = ", Integer.valueOf(i2));
                hf.this.v = i;
                hf.this.jk = i2;
                for (WeakReference weakReference : hf.this.ra) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).xj((com.bykv.vk.openvk.component.video.api.xj) hf.this, i, i2);
                    }
                }
            }
        });
    }

    private void ht() {
        if (this.z) {
            return;
        }
        this.z = true;
        Iterator it = new ArrayList(this.q).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.q.clear();
        this.z = false;
    }

    private void io() {
        this.w = false;
        this.u = false;
        this.y = false;
        this.c = false;
        this.f = false;
    }

    public static boolean jk() {
        return xj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pz() {
        this.f = true;
        this.u = true;
        if (this.dk != null) {
            this.dk.sendEmptyMessage(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra() {
        ArrayList<Runnable> arrayList = this.q;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ht();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int e() {
        return this.qt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long v() {
        try {
            return this.hf.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.hf(th.getMessage());
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long yo() {
        return this.hf.getDuration();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean am() {
        return this.hf.getPlaybackState() == 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceHolder c() {
        return this.ht;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean d() {
        return this.y;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceTexture f() {
        return this.pz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean g() {
        return this.hf.getPlaybackState() == 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void kd() {
        dk();
        ai aiVar = this.dk;
        if (aiVar != null) {
            aiVar.removeCallbacksAndMessages(null);
            aiVar.sendEmptyMessage(103);
            if (aiVar.getLooper() != null) {
                aiVar.post(new Runnable() { // from class: com.bytedance.sdk.component.pl.hf.hf.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!hf.this.et) {
                                com.bytedance.sdk.component.tf.hf.xj.xj().xj(hf.this.dk);
                            }
                            hf.this.dk = null;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO_TTVideo", "release error:" + th.getMessage());
                        }
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int p() {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "getVideoWidth: ");
        return this.v;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int pl() {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "getVideoHeight: ");
        return this.jk;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean qt() {
        return this.kd;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean tf() {
        return this.f;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(int i) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean y() {
        return this.zg;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long zg() {
        if (this.qt == 0) {
            return 0L;
        }
        if (this.f10214pl == 0 && this.g != 0) {
            this.f10214pl = System.currentTimeMillis() - this.g;
        }
        return this.f10214pl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void u() {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "stop: ");
        if (this.dk != null) {
            this.dk.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf() {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "play: ");
        ai aiVar = this.dk;
        if (aiVar != null) {
            aiVar.postDelayed(this.ai, this.f10213io);
            aiVar.post(new Runnable() { // from class: com.bytedance.sdk.component.pl.hf.hf.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (hf.this.hf != null) {
                            hf.this.hf.play();
                            for (WeakReference weakReference : hf.this.ra) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "play: catch exception:" + th.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w() {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "pause: ");
        ai aiVar = this.dk;
        if (aiVar != null) {
            aiVar.removeMessages(100);
            aiVar.sendEmptyMessage(101);
        }
    }

    private void hf(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.kd) {
            runnable.run();
        } else {
            xj(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j, long j2) {
        long j3;
        long j4;
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ra) {
            if (weakReference == null || weakReference.get() == null) {
                j3 = j;
                j4 = j2;
            } else {
                j3 = j;
                j4 = j2;
                weakReference.get().xj(this, j3, j4);
            }
            j = j3;
            j2 = j4;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w(boolean z) {
        this.hf.setLooping(z);
    }

    private void xj(Context context, String str, Looper looper) {
        this.hf = xj.xj(context);
        if (looper != null) {
            this.dk = new ai(looper, this);
            this.et = true;
        } else if (this.dk == null) {
            this.dk = com.bytedance.sdk.component.tf.hf.xj.xj().xj(this, "csj_".concat(String.valueOf(str)));
        }
        et();
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(boolean z) {
        this.d = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(int i) {
        this.f10213io = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(final SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "setDisplay:  SurfaceView");
        hf(true);
        this.ht = surfaceHolder;
        hf(new Runnable() { // from class: com.bytedance.sdk.component.pl.hf.hf.3
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.dk != null) {
                    hf.this.dk.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(final SurfaceTexture surfaceTexture) {
        hf(true);
        this.pz = surfaceTexture;
        hf(new Runnable() { // from class: com.bytedance.sdk.component.pl.hf.hf.4
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.dk != null) {
                    hf.this.dk.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(u uVar) {
        this.hf.setDirectUrlUseDataLoader(uVar.zg(), uVar.e(), (String) null, uVar.kd());
        this.w = true;
        this.qt = 0;
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "TTVideoPlayer setDirectUrlUseDataLoader:  url =", uVar.zg(), " isH265=", Boolean.valueOf(uVar.am()), " presize=", Integer.valueOf(uVar.y()), " path=", uVar.kd(), " fileName =", uVar.e());
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj() {
        TTVideoEngine tTVideoEngine = this.hf;
        boolean isMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.qt = 0;
        this.f10214pl = 0L;
        this.g = 0L;
        this.y = false;
        xj(true, 0L, isMute);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z, long j, boolean z2) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "start: firstSeek:" + j + " first:" + z + " quiet:" + z2);
        if (this.dk != null) {
            this.dk.postDelayed(this.ai, this.f10213io);
        }
        this.tf = System.currentTimeMillis();
        this.hf.setStartTime((int) j);
        this.hf.setIsMute(z2);
        if (this.yo.get() && this.w) {
            pz();
        } else {
            com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec play, please exec setDataSource && setSurface before seek");
            xj(new Runnable() { // from class: com.bytedance.sdk.component.pl.hf.hf.5
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.pz();
                }
            });
        }
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "start:end");
        this.e.set(true);
        if (!this.yo.get() || this.dk == null) {
            return;
        }
        this.dk.post(new Runnable() { // from class: com.bytedance.sdk.component.pl.hf.hf.6
            @Override // java.lang.Runnable
            public void run() {
                hf.this.ra();
            }
        });
    }

    private synchronized void xj(Runnable runnable) {
        this.q.add(runnable);
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i = message.what;
        try {
            if (i == 105) {
                TTVideoEngine tTVideoEngine = this.hf;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                    return;
                }
                return;
            }
            if (i == 110) {
                TTVideoEngine tTVideoEngine2 = this.hf;
                if (tTVideoEngine2 != null) {
                    tTVideoEngine2.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.yo.set(true);
                    if (this.e.get()) {
                        ra();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i != 111) {
                switch (i) {
                    case 100:
                        TTVideoEngine tTVideoEngine3 = this.hf;
                        if (tTVideoEngine3 != null) {
                            tTVideoEngine3.play();
                            break;
                        }
                        break;
                    case 101:
                        if (this.hf != null && this.dk != null) {
                            this.hf.pause();
                            for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ra) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                            this.dk.removeCallbacks(this.ai);
                            break;
                        }
                        break;
                    case 102:
                        io();
                        break;
                    case 103:
                        TTVideoEngine tTVideoEngine4 = this.hf;
                        if (tTVideoEngine4 != null) {
                            tTVideoEngine4.release();
                        }
                        this.kd = true;
                        for (WeakReference<xj.InterfaceC0014xj> weakReference2 : this.ra) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().w(this);
                            }
                        }
                        break;
                }
                return;
            }
            if (this.hf != null) {
                SurfaceTexture surfaceTexture = (SurfaceTexture) message.obj;
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "setSurface: TextureView ");
                this.hf.setSurface(new Surface(surfaceTexture));
                this.yo.set(true);
                if (this.e.get()) {
                    ra();
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(long j) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "seekTo: ");
        if (!this.u) {
            com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec seek, please exec setDataSource before seek");
        } else {
            this.hf.seekTo((int) j, new SeekCompletionListener() { // from class: com.bytedance.sdk.component.pl.hf.hf.8
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z) {
                    for (WeakReference weakReference : hf.this.ra) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((xj.InterfaceC0014xj) weakReference.get()).xj(hf.this, z);
                        }
                    }
                    com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "seekTo: ", " isSuccess =", Boolean.valueOf(z));
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(xj.InterfaceC0014xj interfaceC0014xj) {
        if (interfaceC0014xj == null) {
            return;
        }
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.ra) {
            if (weakReference != null && weakReference.get() == interfaceC0014xj) {
                return;
            }
        }
        this.ra.add(new WeakReference<>(interfaceC0014xj));
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO_TTVideo", "setIsMute: ");
        this.hf.setIsMute(z);
    }

    public static void xj(Context context, String str, int i, String[] strArr, long[] jArr, boolean z, VideoEventEngineUploader videoEventEngineUploader) {
        boolean z2;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), w.getContext()).release();
            xj.xj(context, str, i, strArr, jArr, videoEventEngineUploader);
            xj.xj(z);
            z2 = true;
        } catch (Throwable unused) {
            z2 = false;
        }
        xj = z2;
    }
}
