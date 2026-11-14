package com.bytedance.sdk.component.pl.xj;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.openvk.component.video.api.w;
import com.bykv.vk.openvk.component.video.api.w.hf;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bykv.vk.openvk.component.video.api.xj;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bykv.vk.openvk.component.video.api.xj, ai.xj {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10215a;
    private volatile boolean c;
    private long e;
    private boolean ff;

    /* renamed from: io, reason: collision with root package name */
    private SurfaceHolder f10216io;
    private int kd;
    private JSONObject l;
    private volatile u q;
    private long ra;
    private int u;
    private final Context w;
    private SurfaceTexture x;
    private ILivePlayer xj;
    private ai y;
    private final List<WeakReference<xj.InterfaceC0014xj>> hf = Collections.synchronizedList(new ArrayList());
    private AtomicBoolean f = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);
    private volatile boolean tf = false;
    private volatile boolean p = false;

    /* renamed from: pl, reason: collision with root package name */
    private volatile boolean f10217pl = false;
    private volatile boolean g = false;
    private volatile boolean am = false;
    private volatile boolean qt = false;
    private volatile boolean zg = true;
    private long yo = 0;
    private long v = 0;
    private final int jk = 0;
    private int pz = 0;
    private long ht = 0;
    private long dk = 0;
    private volatile boolean et = false;
    private volatile int ai = 200;
    private long z = 0;
    private final ArrayList<Runnable> j = new ArrayList<>();
    private final Runnable en = new Runnable() { // from class: com.bytedance.sdk.component.pl.xj.xj.1
        @Override // java.lang.Runnable
        public void run() {
            long v = xj.this.v();
            xj.this.dk += xj.this.ai;
            if (xj.this.yo() > 0 && xj.this.z != v) {
                if (w.u()) {
                    com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "run: lastCur = " + xj.this.z + "  currentPosition=" + v);
                }
                xj xjVar = xj.this;
                xjVar.xj(v, xjVar.yo());
            }
            xj.this.z = v;
            if (xj.this.v() >= xj.this.ra) {
                xj.this.g = true;
                xj.this.kd();
                for (WeakReference weakReference : xj.this.hf) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).xj(xj.this);
                    }
                }
            }
            if (xj.this.g) {
                xj xjVar2 = xj.this;
                xjVar2.xj(xjVar2.yo(), xj.this.yo());
            } else if (xj.this.y != null) {
                xj.this.y.postDelayed(this, xj.this.ai);
            }
        }
    };
    private final ILiveListener wo = new ILiveListener() { // from class: com.bytedance.sdk.component.pl.xj.xj.7
        private boolean hf = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            if (xj.this.y == null) {
                return;
            }
            xj.this.y.removeCallbacks(xj.this.en);
            for (WeakReference weakReference : xj.this.hf) {
                if (weakReference != null && weakReference.get() != null) {
                    ((xj.InterfaceC0014xj) weakReference.get()).xj(xj.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            if (liveError != null) {
                if (this.hf) {
                    return;
                }
                this.hf = true;
                hf hfVar = new hf(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : xj.this.hf) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).xj(xj.this, hfVar);
                    }
                }
            }
            xj.this.zg = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z) {
            if (xj.this.y == null) {
                return;
            }
            xj.this.et = true;
            xj.this.y.removeCallbacks(xj.this.en);
            if (xj.this.ra > 0) {
                xj.this.y.postDelayed(xj.this.en, xj.this.ai);
            }
            xj.this.zg = false;
            if (!z) {
                com.bykv.vk.openvk.component.video.api.y.w.hf("TTLiveVideoPlayer", "onFirstFrame-> not first frame , isFirstFrame=".concat(String.valueOf(z)));
                for (WeakReference weakReference : xj.this.hf) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((xj.InterfaceC0014xj) weakReference.get()).xj((com.bykv.vk.openvk.component.video.api.xj) xj.this, -1);
                    }
                }
                return;
            }
            xj.this.yo = System.currentTimeMillis() - xj.this.e;
            for (WeakReference weakReference2 : xj.this.hf) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    xj.InterfaceC0014xj interfaceC0014xj = (xj.InterfaceC0014xj) weakReference2.get();
                    xj xjVar = xj.this;
                    interfaceC0014xj.xj(xjVar, xjVar.yo);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            for (WeakReference weakReference : xj.this.hf) {
                if (weakReference != null && weakReference.get() != null) {
                    ((xj.InterfaceC0014xj) weakReference.get()).xj(xj.this, jSONObject, str);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "onPrepared.....");
            xj.this.am = true;
            for (WeakReference weakReference : xj.this.hf) {
                if (weakReference != null && weakReference.get() != null) {
                    ((xj.InterfaceC0014xj) weakReference.get()).hf(xj.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            if (xj.this.y == null) {
                return;
            }
            if (xj.this.ra > 0) {
                xj.this.y.postDelayed(xj.this.en, xj.this.ai);
            }
            xj xjVar = xj.this;
            xjVar.v = (System.currentTimeMillis() - xj.this.ht) + xjVar.v;
            for (WeakReference weakReference : xj.this.hf) {
                if (weakReference != null && weakReference.get() != null) {
                    ((xj.InterfaceC0014xj) weakReference.get()).xj((com.bykv.vk.openvk.component.video.api.xj) xj.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            if (xj.this.y == null) {
                return;
            }
            xj.e(xj.this);
            xj.this.ht = System.currentTimeMillis();
            xj.this.y.removeCallbacks(xj.this.en);
            for (WeakReference weakReference : xj.this.hf) {
                if (weakReference != null && weakReference.get() != null) {
                    ((xj.InterfaceC0014xj) weakReference.get()).xj(xj.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
            xj.this.u = i;
            xj.this.kd = i2;
            for (WeakReference weakReference : xj.this.hf) {
                if (weakReference != null && weakReference.get() != null) {
                    ((xj.InterfaceC0014xj) weakReference.get()).xj((com.bykv.vk.openvk.component.video.api.xj) xj.this, i, i2);
                }
            }
        }
    };

    /* renamed from: com.bytedance.sdk.component.pl.xj.xj$xj, reason: collision with other inner class name */
    public static class C0117xj implements INetworkClient {
        private final pl xj;

        public C0117xj() {
            pl.xj hf = w.w().hf();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.xj = hf.xj(10L, timeUnit).hf(10L, timeUnit).w(10L, timeUnit).xj();
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String str4;
            String str5 = null;
            String str6 = null;
            JSONObject jSONObject = null;
            try {
                try {
                    zg hf = this.xj.xj(new am.xj().xj(str).hf("host", str2).hf()).hf();
                    if (hf.u()) {
                        str4 = hf.y().hf();
                        try {
                            str6 = hf.c().toString();
                            jSONObject = new JSONObject(str4);
                        } catch (JSONException e) {
                            e = e;
                            String str7 = str6;
                            str5 = str4;
                            str3 = str7;
                            return INetworkClient.Result.newBuilder().setBody(str5).setHeader(str3).setException(e).build();
                        }
                    } else {
                        str4 = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(str4).build();
                } catch (JSONException e2) {
                    e = e2;
                    str3 = null;
                }
            } catch (IOException e3) {
                return INetworkClient.Result.newBuilder().setException(e3).build();
            } catch (Exception e4) {
                return INetworkClient.Result.newBuilder().setException(e4).build();
            }
        }
    }

    public xj(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        this.y = null;
        this.c = false;
        this.ra = 0L;
        this.w = context;
        this.l = jSONObject;
        this.ra = j > 0 ? j * 1000 : -1L;
        if (looper != null) {
            this.y = new ai(looper, this);
            this.c = true;
        } else if (this.y == null) {
            this.y = com.bytedance.sdk.component.tf.hf.xj.xj().xj(this, "tt-live-video-player");
        }
        u(z);
    }

    public static /* synthetic */ int e(xj xjVar) {
        int i = xjVar.pz;
        xjVar.pz = i + 1;
        return i;
    }

    private void ht() {
        ai aiVar = this.y;
        if (aiVar == null || aiVar.getLooper() == null) {
            return;
        }
        this.y.post(new Runnable() { // from class: com.bytedance.sdk.component.pl.xj.xj.6
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.y == null || xj.this.y.getLooper() == null) {
                    return;
                }
                try {
                    xj.this.x = null;
                    xj.this.f10216io = null;
                    if (xj.this.c) {
                        xj.this.y.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.tf.hf.xj.xj().xj(xj.this.y);
                    }
                    xj.this.y = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void jk() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList != null && !arrayList.isEmpty()) {
            pz();
        }
    }

    private synchronized void pz() {
        try {
            if (this.ff) {
                return;
            }
            this.ff = true;
            Iterator it = new ArrayList(this.j).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.j.clear();
            this.ff = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean am() {
        return this.zg;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceHolder c() {
        return this.f10216io;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean d() {
        com.bykv.vk.openvk.component.video.api.y.w.hf("TTLiveVideoPlayer", "TTLiveVideoPlayer...isCompleted......isComplete....=" + this.g);
        return this.g;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int e() {
        return this.pz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public SurfaceTexture f() {
        return this.x;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean g() {
        ILivePlayer iLivePlayer = this.xj;
        if (iLivePlayer == null) {
            return false;
        }
        try {
            return iLivePlayer.isPlaying();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "isPlaying: catch exception:", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int p() {
        return this.u;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public int pl() {
        return this.kd;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean qt() {
        return this.p;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean tf() {
        return this.qt;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long v() {
        return this.dk;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(int i) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long yo() {
        return this.ra;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public long zg() {
        return this.v;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void kd() {
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.removeCallbacks(this.en);
            aiVar.sendEmptyMessage(103);
            ht();
        }
        com.bykv.vk.openvk.component.video.api.y.w.hf("TTLiveVideoPlayer", "TTLiveVideoPlayer...release......release....");
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(long j) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public boolean y() {
        return this.et;
    }

    private void u(final boolean z) {
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.post(new Runnable() { // from class: com.bytedance.sdk.component.pl.xj.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.bytedance.sdk.component.pl.xj.xj.2.1
                            /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
                            /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public <T> T getSettingsValueForKey(java.lang.String r2, T r3) {
                                /*
                                    r1 = this;
                                    r2.getClass()
                                    java.lang.String r0 = "live_enable_close_play_retry"
                                    boolean r0 = r2.equals(r0)
                                    if (r0 != 0) goto L14
                                    java.lang.String r0 = "live_sdk_cancel_sdk_dns_fail_retry"
                                    boolean r2 = r2.equals(r0)
                                    if (r2 != 0) goto L23
                                    return r3
                                L14:
                                    java.lang.Class r2 = r3.getClass()
                                    java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
                                    if (r2 != r0) goto L23
                                    java.lang.String r2 = "1"
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                                    goto L24
                                L23:
                                    r2 = r3
                                L24:
                                    java.lang.Class r3 = r3.getClass()
                                    java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                                    if (r3 != r0) goto L2e
                                    java.lang.Boolean r2 = java.lang.Boolean.TRUE
                                L2e:
                                    return r2
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.pl.xj.xj.AnonymousClass2.AnonymousClass1.getSettingsValueForKey(java.lang.String, java.lang.Object):java.lang.Object");
                            }
                        };
                        xj xjVar = xj.this;
                        xjVar.xj = VideoLiveManager.newBuilder(xjVar.w).setProjectKey("pangle_ad_live").setNetworkClient(new C0117xj()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(xj.this.wo).build();
                        xj.this.xj.setIntOption(69, z ? 1 : 0);
                        xj.this.xj.setStringOption(72, com.bytedance.sdk.openadsdk.api.plugin.hf.xj(xj.this.w, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e) {
                        com.bykv.vk.openvk.component.video.api.y.w.w("TTLiveVideoPlayer", e.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w() {
        com.bykv.vk.openvk.component.video.api.y.w.hf("TTLiveVideoPlayer", "TTLiveVideoPlayer...pause......pause....currentPosition=" + v());
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.removeCallbacks(this.en);
            aiVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf() {
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.post(new Runnable() { // from class: com.bytedance.sdk.component.pl.xj.xj.5
                @Override // java.lang.Runnable
                public void run() {
                    if (xj.this.xj == null || xj.this.g()) {
                        return;
                    }
                    try {
                        xj.this.xj.play();
                        xj xjVar = xj.this;
                        xjVar.xj(xjVar.f10215a);
                        for (WeakReference weakReference : xj.this.hf) {
                            if (weakReference != null && weakReference.get() != null) {
                                weakReference.get();
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "play: catch exception", th);
                    }
                    xj.this.zg = false;
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void u() {
        com.bykv.vk.openvk.component.video.api.y.w.hf("TTLiveVideoPlayer", "TTLiveVideoPlayer...stop......stop....currentPosition=" + v());
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.removeCallbacks(this.en);
            aiVar.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(boolean z) {
        this.f10217pl = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void hf(int i) {
        this.ai = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void w(boolean z) {
        com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "setLoop: live is invalid ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j, long j2) {
        long j3;
        long j4;
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.hf) {
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
    public void xj(u uVar) {
        if (uVar == null) {
            return;
        }
        this.q = uVar;
        com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "setDataSource: model = " + uVar.zg());
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.sendEmptyMessage(107);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj() {
        this.pz = 0;
        this.v = 0L;
        this.ht = 0L;
        xj(true, 0L, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z, final long j, final boolean z2) {
        ai aiVar;
        if (this.d.get() && this.tf && this.xj != null) {
            this.dk = j;
            this.e = System.currentTimeMillis();
            xj(z2);
            ai aiVar2 = this.y;
            if (aiVar2 != null) {
                aiVar2.sendEmptyMessage(100);
            }
            com.bytedance.sdk.component.utils.pl.hf("TTLiveVideoPlayer", "TTLiveVideoPlayer...play......");
        } else {
            xj(new Runnable() { // from class: com.bytedance.sdk.component.pl.xj.xj.3
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.dk = j;
                    xj.this.e = System.currentTimeMillis();
                    xj.this.xj(z2);
                    if (xj.this.y != null) {
                        xj.this.y.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.f.set(true);
        if (!this.d.get() || (aiVar = this.y) == null) {
            return;
        }
        aiVar.post(new Runnable() { // from class: com.bytedance.sdk.component.pl.xj.xj.4
            @Override // java.lang.Runnable
            public void run() {
                xj.this.jk();
            }
        });
    }

    private synchronized void xj(Runnable runnable) {
        this.j.add(runnable);
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(boolean z) {
        this.f10215a = z;
        if (this.xj != null) {
            com.bykv.vk.openvk.component.video.api.y.w.hf("TTLiveVideoPlayer", "TTLiveVideoPlayer...setQuietPlay......isMute=".concat(String.valueOf(z)));
            try {
                this.xj.setMute(Boolean.valueOf(z));
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "setMute: catch exception:", th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(SurfaceHolder surfaceHolder) {
        this.f10216io = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.y.w.hf("TTLiveVideoPlayer", "TTLiveVideoPlayer...SurfaceHolder......".concat(String.valueOf(surfaceHolder)));
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(SurfaceTexture surfaceTexture) {
        this.x = surfaceTexture;
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.obtainMessage(111, surfaceTexture).sendToTarget();
        }
        com.bykv.vk.openvk.component.video.api.y.w.hf("TTLiveVideoPlayer", "setSurface...surface=");
    }

    @Override // com.bykv.vk.openvk.component.video.api.xj
    public void xj(xj.InterfaceC0014xj interfaceC0014xj) {
        if (interfaceC0014xj == null) {
            return;
        }
        for (WeakReference<xj.InterfaceC0014xj> weakReference : this.hf) {
            if (weakReference != null && weakReference.get() == interfaceC0014xj) {
                return;
            }
        }
        this.hf.add(new WeakReference<>(interfaceC0014xj));
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        try {
            switch (message.what) {
                case 100:
                    hf();
                    this.qt = true;
                    return;
                case 101:
                    ILivePlayer iLivePlayer = this.xj;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<xj.InterfaceC0014xj> weakReference : this.hf) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "pause: catch exception:", th);
                        }
                        this.zg = true;
                        return;
                    }
                    return;
                case 102:
                    ILivePlayer iLivePlayer2 = this.xj;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                        } catch (Throwable th2) {
                            com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "reset: catch exception:", th2);
                        }
                        this.zg = true;
                        return;
                    }
                    return;
                case 103:
                    ILivePlayer iLivePlayer3 = this.xj;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                        } catch (Throwable th3) {
                            com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "release: catch exception:", th3);
                        }
                        this.p = true;
                        this.zg = true;
                        return;
                    }
                    return;
                case 104:
                case 106:
                case 108:
                case AdEventType.AD_RENDER_SUCCESS /* 109 */:
                default:
                    return;
                case 105:
                    ILivePlayer iLivePlayer4 = this.xj;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                        } catch (Throwable th4) {
                            com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "stop: catch exception:", th4);
                        }
                        this.zg = true;
                        return;
                    }
                    return;
                case 107:
                    if (this.xj == null || this.q == null) {
                        return;
                    }
                    String zg = this.q.zg();
                    xj(zg);
                    this.xj.setStreamInfo(zg);
                    this.tf = true;
                    com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "set Datasource:" + this.tf);
                    this.pz = 0;
                    return;
                case 110:
                    ILivePlayer iLivePlayer5 = this.xj;
                    if (iLivePlayer5 != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        iLivePlayer5.setSurfaceHolder(surfaceHolder);
                        this.xj.setSurface(surfaceHolder.getSurface());
                        this.d.set(true);
                        if (this.f.get()) {
                            jk();
                            return;
                        }
                        return;
                    }
                    return;
                case 111:
                    ILivePlayer iLivePlayer6 = this.xj;
                    if (iLivePlayer6 != null) {
                        iLivePlayer6.setSurface(new Surface(this.x));
                        this.d.set(true);
                        if (this.f.get()) {
                            jk();
                            return;
                        }
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        e.getMessage();
    }

    private void xj(String str) {
        String str2 = LiveConfigKey.LOW;
        try {
            JSONObject jSONObject = this.l;
            if (jSONObject == null) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "live ".concat(String.valueOf(jSONObject)));
            int optInt = jSONObject.optInt("enable");
            String optString = jSONObject.optString("appids");
            if (optInt == 1 && !TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject optJSONObject = jSONObject2.optJSONObject("common");
                JSONObject optJSONObject2 = jSONObject2.optJSONObject(PointParamKey.DATA);
                if (optJSONObject != null && optJSONObject2 != null) {
                    String optString2 = optJSONObject.optString(PluginConstants.KEY_APP_ID);
                    com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "api ".concat(String.valueOf(optString2)));
                    if (optString.contains(optString2)) {
                        if (optJSONObject2.optJSONObject(LiveConfigKey.UHD) != null) {
                            str2 = LiveConfigKey.UHD;
                        } else if (optJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                            str2 = LiveConfigKey.HIGH;
                        } else if (optJSONObject2.optJSONObject(LiveConfigKey.STANDARD) != null) {
                            str2 = LiveConfigKey.STANDARD;
                        } else if (optJSONObject2.optJSONObject(LiveConfigKey.LOW) == null) {
                            str2 = null;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "update reso:".concat(String.valueOf(str2)));
                        this.xj.setStringOption(43, str2);
                    }
                }
            }
        } catch (Exception e) {
            com.bykv.vk.openvk.component.video.api.y.w.xj("TTLiveVideoPlayer", "updateStream: catch exception:", e.getMessage());
        }
    }
}
