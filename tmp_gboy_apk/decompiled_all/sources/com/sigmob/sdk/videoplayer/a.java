package com.sigmob.sdk.videoplayer;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.views.r;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends RelativeLayout implements h {
    private static final int u = 6000;

    /* renamed from: a, reason: collision with root package name */
    i f13765a;
    Class b;
    l c;
    public g d;
    public d e;
    private ViewGroup f;
    private int g;
    private Timer h;
    private C0463a i;
    private boolean j;
    private boolean k;
    private final Handler l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private float q;
    private k r;
    private int s;
    private String t;
    private boolean v;

    /* renamed from: com.sigmob.sdk.videoplayer.a$a, reason: collision with other inner class name */
    public class C0463a extends TimerTask {
        public C0463a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            long currentPositionWhenPlaying = a.this.getCurrentPositionWhenPlaying();
            long duration = a.this.getDuration();
            if (a.this.r == null) {
                return;
            }
            a.this.r.a(currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = a.this;
            d dVar = aVar.e;
            if (dVar == d.STATE_PLAYING || dVar == d.STATE_PAUSE) {
                aVar.post(new A2egSU(this, 0));
            }
        }
    }

    public a(Context context) {
        super(context);
        this.e = d.STATE_IDLE;
        this.l = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.videoplayer.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 6000 || a.this.j || a.this.k) {
                    return;
                }
                a.this.j = true;
                a.this.setState(d.STATE_BUFFERING_START);
            }
        };
        FrameLayout frameLayout = new FrameLayout(context);
        this.f = frameLayout;
        frameLayout.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void s() {
        try {
            i iVar = this.f13765a;
            if (iVar != null) {
                iVar.f();
            }
            Class cls = this.b;
            this.f13765a = cls == null ? new j(this) : (i) cls.getConstructor(a.class).newInstance(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a() {
        SigmobLog.d("startVideo [" + hashCode() + "] ");
        try {
            s();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Window c = c.c(getContext());
        if (c != null) {
            c.setFlags(16777216, 16777216);
            c.addFlags(r.b.d);
        }
        m();
        b();
    }

    public void b() {
        SigmobLog.d("onStatePreparing  [" + hashCode() + "] ");
        setState(d.STATE_PREPARING);
    }

    public void d() {
        i iVar;
        this.n = false;
        d dVar = this.e;
        if (dVar == d.STATE_NORMAL || (iVar = this.f13765a) == null) {
            a();
            return;
        }
        if (dVar == d.STATE_PAUSE || dVar == d.STATE_BUFFERING_END || dVar == d.STATE_AUTO_COMPLETE || dVar == d.STATE_PREPARED) {
            iVar.a();
            e();
        }
    }

    public void e() {
        SigmobLog.d("onStatePlaying  [" + hashCode() + "] ");
        if (this.e == d.STATE_PREPARED) {
            int i = this.g;
            if (i != 0) {
                this.f13765a.a(i);
                this.g = 0;
            }
            if (!this.k) {
                this.l.sendEmptyMessageDelayed(6000, 3000L);
            }
        }
        setState(d.STATE_PLAYING);
        f();
    }

    public void f() {
        SigmobLog.d("startProgressTimer:  [" + hashCode() + "] ");
        l();
        this.h = new Timer();
        C0463a c0463a = new C0463a();
        this.i = c0463a;
        this.h.schedule(c0463a, 0L, 300L);
    }

    public boolean g() {
        return this.v;
    }

    public long getCurrentPositionWhenPlaying() {
        d dVar = this.e;
        if (dVar != d.STATE_PLAYING && dVar != d.STATE_PAUSE) {
            return 0L;
        }
        try {
            return this.f13765a.g();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            i iVar = this.f13765a;
            if (iVar != null) {
                return iVar.j();
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public int getErrorCode() {
        return this.s;
    }

    public String getErrorMessage() {
        return this.t;
    }

    public int getVideoHeight() {
        return this.o;
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public g getVideoPlayerDataSource() {
        return this.d;
    }

    public int getVideoWidth() {
        return this.p;
    }

    public void h() {
        SigmobLog.d("reset  [" + hashCode() + "] ");
        l();
        c();
        this.f.removeAllViews();
        Window c = c.c(getContext());
        if (c != null) {
            c.clearFlags(r.b.d);
        }
        i iVar = this.f13765a;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void i() {
        setState(d.STATE_STOP);
        h();
    }

    public void j() {
        d dVar = this.e;
        if (dVar == d.STATE_NORMAL || dVar == d.STATE_PREPARING || dVar == d.STATE_ERROR) {
            h();
        } else {
            if (dVar == d.STATE_PAUSE || this.f13765a == null) {
                return;
            }
            k();
            this.f13765a.d();
        }
    }

    public void k() {
        SigmobLog.i("onStatePause  [" + hashCode() + "] ");
        setState(d.STATE_PAUSE);
        f();
    }

    public void l() {
        Timer timer = this.h;
        if (timer != null) {
            timer.cancel();
        }
        C0463a c0463a = this.i;
        if (c0463a != null) {
            c0463a.cancel();
        }
    }

    public void m() {
        SigmobLog.d("addTextureView [" + hashCode() + "] ");
        l lVar = this.c;
        if (lVar != null) {
            this.f.removeView(lVar);
        }
        l lVar2 = new l(getContext().getApplicationContext());
        this.c = lVar2;
        lVar2.setSurfaceTextureListener(this.f13765a);
        this.f.addView(this.c, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void n() {
        this.n = true;
        a();
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void o() {
        SigmobLog.d("onPrepared  [" + hashCode() + "] ");
        setState(d.STATE_PREPARED);
        setMute(this.m);
        if (this.n) {
            return;
        }
        SigmobLog.d("mediaInterface start");
        e();
        this.f13765a.a();
        this.n = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SigmobLog.d("onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void p() {
        setState(d.STATE_AUTO_COMPLETE);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void q() {
    }

    public void r() {
        this.r = null;
        h();
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void setBufferProgress(int i) {
    }

    public void setLooping(boolean z) {
        i iVar = this.f13765a;
        if (iVar == null) {
            return;
        }
        try {
            iVar.a(z);
            this.v = z;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setMute(boolean z) {
        this.m = z;
        i iVar = this.f13765a;
        if (iVar == null) {
            return;
        }
        iVar.a(z ? 0.0f : 1.0f);
    }

    public void setState(d dVar) {
        this.e = dVar;
        Context e = com.sigmob.sdk.b.e();
        if (dVar == d.STATE_PLAYING) {
            c.f(e);
        } else if (dVar == d.STATE_NORMAL || dVar == d.STATE_PAUSE || dVar == d.STATE_AUTO_COMPLETE || dVar == d.STATE_STOP) {
            c.g(e);
        }
        k kVar = this.r;
        if (kVar == null) {
            return;
        }
        kVar.a(dVar);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        l lVar = this.c;
        if (lVar == null) {
            return;
        }
        lVar.setSurfaceTexture(surfaceTexture);
    }

    public void setTextureViewContainer(ViewGroup viewGroup) {
        this.f = viewGroup;
    }

    public void setUp(String str) {
        a(new g(str, (String) null), 0);
    }

    public void setVideoPlayerStatusListener(k kVar) {
        this.r = kVar;
    }

    public void a(int i) {
        d dVar = this.e;
        if (dVar != d.STATE_PAUSE && dVar != d.STATE_PREPARED && dVar != d.STATE_AUTO_COMPLETE && dVar != d.STATE_PLAYING) {
            this.g = i;
            return;
        }
        i iVar = this.f13765a;
        if (iVar == null) {
            return;
        }
        iVar.a(i);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void b(int i, int i2) {
        d dVar;
        SigmobLog.d("onInfo() called with: what = [" + i + "], extra = [" + i2 + "]");
        if (i == 3) {
            if (!this.k) {
                this.k = true;
                this.l.removeMessages(6000);
            }
            if (!this.j) {
                return;
            } else {
                this.j = false;
            }
        } else if (i == 701) {
            dVar = d.STATE_BUFFERING_START;
            setState(dVar);
        } else if (i != 702) {
            return;
        }
        dVar = d.STATE_BUFFERING_END;
        setState(dVar);
    }

    public void c() {
        SigmobLog.d("onStateNormal stat" + this.e + " [" + hashCode() + "] ");
        setState(d.STATE_NORMAL);
        i iVar = this.f13765a;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void a(int i, int i2) {
        this.s = i;
        this.t = CtFAbx.ARc23Z(i2, "");
        setState(d.STATE_ERROR);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void c(int i, int i2) {
        this.o = i2;
        this.p = i;
        SigmobLog.d("onVideoSizeChanged  [" + hashCode() + "] ");
        l lVar = this.c;
        if (lVar == null) {
            return;
        }
        float f = this.q;
        if (f != 0.0f) {
            lVar.setRotation(f);
        }
        this.c.a(i, i2);
    }

    public void a(g gVar, int i) {
        this.d = gVar;
        c();
    }
}
