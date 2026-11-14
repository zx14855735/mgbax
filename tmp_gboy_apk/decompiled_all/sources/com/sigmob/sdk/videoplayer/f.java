package com.sigmob.sdk.videoplayer;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.common.util.FileTypeUtils;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.nativead.m;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener, h {
    private static final String V = "android.media.VOLUME_CHANGED_ACTION";
    private static final String W = "android.media.EXTRA_VOLUME_STREAM_TYPE";

    /* renamed from: a, reason: collision with root package name */
    public static final String f13771a = "VideoPlayerView";
    public static final int b = -1;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = 7;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 0;
    public static final int o = 80;
    public static boolean p = true;
    public static int q = 6;
    public static int r = 1;
    public static boolean s = false;
    public static boolean t = true;
    public static int u;
    public int A;
    public Class B;
    public boolean C;
    public i D;
    public int E;
    public int F;
    public int G;
    public long H;
    public ImageView I;
    public ImageView J;
    public ImageView K;
    public boolean L;
    protected long M;
    protected Timer N;
    protected int O;
    protected int P;
    protected AudioManager Q;
    protected a R;
    protected boolean S;
    l T;
    public AudioManager.OnAudioFocusChangeListener U;
    private ViewGroup aa;
    private ViewGroup ab;
    private ViewGroup ac;
    private ViewGroup ad;
    private ViewGroup ae;
    private ViewGroup af;
    private ViewGroup ag;
    private ViewGroup ah;
    private ProgressBar ai;
    private ImageView aj;
    private com.sigmob.sdk.nativead.l ak;
    private boolean al;
    private com.sigmob.sdk.videoplayer.b am;
    private ImageView an;
    private int ao;
    private int ap;
    private c aq;
    private boolean ar;
    private View as;
    private boolean at;
    private View au;
    public f v;
    public int w;
    public int x;
    public g y;
    public int z;

    /* renamed from: com.sigmob.sdk.videoplayer.f$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13773a;

        static {
            int[] iArr = new int[e.values().length];
            f13773a = iArr;
            try {
                iArr[e.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13773a[e.RETRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13773a[e.VOLUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13773a[e.FULLSCREEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13773a[e.BIGRETRY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13773a[e.BACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class a extends TimerTask {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            long currentPositionWhenPlaying = f.this.getCurrentPositionWhenPlaying();
            long duration = f.this.getDuration();
            f.this.a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i = f.this.w;
            if (i == 4 || i == 5) {
                WindAds.sharedAds().getHandler().post(new A2egSU(this, 1));
            }
        }
    }

    public interface b {
        void onVolumeChanged(int i);
    }

    public class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        b f13775a;

        public c(b bVar) {
            this.f13775a = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int streamVolume;
            if (!f.V.equals(intent.getAction()) || intent.getIntExtra(f.W, -1) != 3 || this.f13775a == null || (streamVolume = ((AudioManager) f.this.getApplicationContext().getSystemService(MediaFormat.KEY_AUDIO)).getStreamVolume(3)) < 0) {
                return;
            }
            this.f13775a.onVolumeChanged(streamVolume);
        }
    }

    public f(Context context) {
        super(context.getApplicationContext());
        this.w = -1;
        this.x = -1;
        this.z = 0;
        this.A = 0;
        this.C = true;
        this.E = -1;
        this.F = 0;
        this.G = -1;
        this.H = 0L;
        this.L = false;
        this.M = 0L;
        this.U = new AudioManager.OnAudioFocusChangeListener() { // from class: com.sigmob.sdk.videoplayer.f.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i2) {
                StringBuilder sb;
                if (i2 == -2) {
                    sb = new StringBuilder("AUDIOFOCUS_LOSS_TRANSIENT [");
                } else {
                    if (i2 != -1) {
                        return;
                    }
                    f.this.E();
                    sb = new StringBuilder("AUDIOFOCUS_LOSS [");
                }
                sb.append(hashCode());
                sb.append("]");
                SigmobLog.i(sb.toString());
            }
        };
        this.al = true;
        this.ar = false;
        a(context.getApplicationContext());
    }

    private void F() {
        try {
            i iVar = this.D;
            if (iVar != null) {
                iVar.f();
            }
            Class cls = this.B;
            this.D = cls == null ? new j(this) : (i) cls.getConstructor(f.class).newInstance(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void A() {
    }

    public void B() {
    }

    public void C() {
        int i2;
        f fVar = this.v;
        if (fVar == null || (i2 = fVar.w) == 0) {
            k();
            return;
        }
        if (i2 == 5) {
            com.sigmob.sdk.nativead.l lVar = this.ak;
            if (lVar != null) {
                lVar.onVideoResume();
            }
            this.v.f();
            this.v.D.a();
            return;
        }
        if (i2 == 3) {
            com.sigmob.sdk.nativead.l lVar2 = this.ak;
            if (lVar2 != null) {
                lVar2.onVideoStart();
            }
            this.v.D.a();
            this.v.f();
        }
    }

    public void D() {
        f fVar = this.v;
        if (fVar == null) {
            return;
        }
        int i2 = fVar.w;
        if (i2 == 6 || i2 == 0 || i2 == 1 || i2 == 7) {
            E();
        } else if (i2 != 5) {
            fVar.g();
            this.v.D.d();
        }
    }

    public void E() {
        SigmobLog.i("releaseAllVideos");
        f fVar = this.v;
        if (fVar == null) {
            return;
        }
        fVar.j();
        this.v = null;
    }

    public void a() {
        E();
        r();
        if (this.aq == null) {
            return;
        }
        getContext().unregisterReceiver(this.aq);
        this.aq = null;
    }

    public void b() {
        SigmobLog.d("onStateNormal stat" + this.w + " [" + hashCode() + "] ");
        this.w = 0;
        a(this.aj, 0);
        a(this.ab, 0);
        r();
        i iVar = this.D;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void c() {
        SigmobLog.d("onStatePreparing  [" + hashCode() + "] ");
        this.w = 1;
        s();
    }

    public void d() {
        this.L = true;
        k();
    }

    public void e() {
        if (this.w == 3) {
            this.D.a();
        } else {
            this.L = false;
            k();
        }
    }

    public void f() {
        SigmobLog.d("onStatePlaying  [" + hashCode() + "] ");
        a(this.aj, 4);
        a(this.ab, 4);
        if (this.w == 3) {
            long j2 = this.H;
            if (j2 != 0) {
                this.D.a(j2);
                this.H = 0L;
            }
        }
        this.w = 4;
        n();
    }

    public void g() {
        SigmobLog.i("onStatePause  [" + hashCode() + "] ");
        this.w = 5;
        a(this.ab, 0);
        com.sigmob.sdk.nativead.l lVar = this.ak;
        if (lVar != null) {
            lVar.onVideoPause();
        }
        r();
    }

    public ViewGroup getAppContainer() {
        return this.ah;
    }

    public Context getApplicationContext() {
        Context applicationContext;
        Context context = getContext();
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public ImageView getBlurImageView() {
        return this.an;
    }

    public View getBottomLayoutView() {
        return this.au;
    }

    public long getCurrentPositionWhenPlaying() {
        int i2 = this.w;
        if (i2 != 4 && i2 != 5) {
            return 0L;
        }
        try {
            return this.D.g();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        i iVar = this.D;
        if (iVar == null) {
            return 0L;
        }
        try {
            return iVar.j();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_video_player_layout");
    }

    public ViewGroup getSigAdView() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        while (!(viewGroup instanceof m)) {
            viewGroup = (ViewGroup) getParent();
            if (viewGroup == null) {
                return viewGroup;
            }
        }
        return viewGroup;
    }

    public Bitmap getTextureBitmap() {
        l lVar = this.T;
        if (lVar == null) {
            return null;
        }
        return lVar.getBitmap();
    }

    public ImageView getThumbView() {
        return this.aj;
    }

    public View getTopLayoutView() {
        return this.as;
    }

    public int getVideoHeight() {
        return this.ao;
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public g getVideoPlayerDataSource() {
        return this.y;
    }

    public int getVideoSurferViewHeight() {
        l lVar = this.T;
        if (lVar == null) {
            return 0;
        }
        return lVar.getHeight();
    }

    public int getVideoWidth() {
        return this.ap;
    }

    public void h() {
        SigmobLog.d("onStateError  [" + hashCode() + "] ");
        this.w = 7;
        r();
        a(this.x == 1 ? this.ab : this.ad, 0);
    }

    public void i() {
        SigmobLog.i("onStateAutoComplete  [" + hashCode() + "] ");
        this.w = 6;
        r();
        ProgressBar progressBar = this.ai;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
    }

    public void j() {
        SigmobLog.d("reset  [" + hashCode() + "] ");
        r();
        s();
        B();
        z();
        A();
        b();
        this.aa.removeAllViews();
        Window c2 = com.sigmob.sdk.videoplayer.c.c(getContext());
        if (c2 != null) {
            c2.clearFlags(r.b.d);
        }
        i iVar = this.D;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void k() {
        SigmobLog.d("startVideo [" + hashCode() + "] ");
        setCurrentVideoAdView(this);
        try {
            F();
            a(this.ad, 4);
            a(this.af, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Window c2 = com.sigmob.sdk.videoplayer.c.c(getContext());
        if (c2 != null) {
            c2.setFlags(16777216, 16777216);
            c2.addFlags(r.b.d);
        }
        l();
        c();
    }

    public void l() {
        l lVar = this.T;
        if (lVar != null) {
            this.aa.removeView(lVar);
        }
        l lVar2 = new l(getContext().getApplicationContext());
        this.T = lVar2;
        lVar2.setSurfaceTextureListener(this.D);
        this.aa.addView(this.T, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void m() {
        Window c2 = com.sigmob.sdk.videoplayer.c.c(getContext());
        if (c2 != null) {
            ((ViewGroup) c2.findViewById(R.id.content)).removeView(this);
        }
    }

    public void n() {
        r();
        this.N = new Timer();
        a aVar = new a();
        this.R = aVar;
        this.N.schedule(aVar, 0L, 300L);
        com.sigmob.sdk.videoplayer.c.f(com.sigmob.sdk.b.e());
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void o() {
        SigmobLog.d("onPrepared  [" + hashCode() + "] ");
        this.w = 3;
        setSoundChange(this.al);
        com.sigmob.sdk.nativead.l lVar = this.ak;
        if (lVar != null) {
            lVar.onVideoLoad();
        }
        if (!this.L) {
            com.sigmob.sdk.nativead.l lVar2 = this.ak;
            if (lVar2 != null) {
                lVar2.onVideoStart();
            }
            SigmobLog.d("mediaInterface start");
            f();
            this.D.a();
            this.L = false;
        } else if (this.ar) {
            this.aj.setImageBitmap(this.T.getBitmap());
        }
        String lowerCase = this.y.a().toString().toLowerCase();
        if (lowerCase.contains(FileTypeUtils.FILE_TYPE_MP3) || lowerCase.contains("wma") || lowerCase.contains("aac") || lowerCase.contains("m4a") || lowerCase.contains(FileTypeUtils.FILE_TYPE_WAV)) {
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onTouch(view, null);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.x;
        if (i4 == 1 || i4 == 2) {
            super.onMeasure(i2, i3);
            return;
        }
        if (this.z == 0 || this.A == 0) {
            super.onMeasure(i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int i5 = (int) ((size * this.A) / this.z);
        setMeasuredDimension(size, i5);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        if (z) {
            getDuration();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        r();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        SigmobLog.d("bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        n();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i2 = this.w;
        if (i2 == 4 || i2 == 5) {
            long duration = (getDuration() * seekBar.getProgress()) / 100;
            this.G = seekBar.getProgress();
            this.D.a(duration);
            SigmobLog.d("seekTo " + duration + " [" + hashCode() + "] ");
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() != 1) {
            return false;
        }
        if (view == this.ac) {
            int i2 = this.x;
            if (i2 == 0) {
                t();
                return false;
            }
            if (i2 != 1) {
                return false;
            }
            u();
            return false;
        }
        if (view == this.ae) {
            setSoundChange(!this.al);
            return false;
        }
        if (view == this.ad || view == this.af) {
            com.sigmob.sdk.nativead.l lVar = this.ak;
            if (lVar != null) {
                lVar.a();
            }
            k();
            return false;
        }
        if (view != this.ab) {
            return false;
        }
        int i3 = this.w;
        if (i3 != 0) {
            if (i3 == 4) {
                SigmobLog.d("pauseVideo [" + hashCode() + "] ");
                this.D.d();
                g();
            } else if (i3 == 5) {
                com.sigmob.sdk.nativead.l lVar2 = this.ak;
                if (lVar2 != null) {
                    lVar2.onVideoResume();
                }
                this.D.a();
                f();
            } else if (i3 != 6) {
                if (i3 == 3) {
                    this.D.a();
                    f();
                    com.sigmob.sdk.nativead.l lVar3 = this.ak;
                    if (lVar3 != null) {
                        lVar3.onVideoStart();
                    }
                }
            }
            return true;
        }
        if (!t && !this.y.a().toString().startsWith(n.z) && !this.y.a().toString().startsWith("/") && !com.sigmob.sdk.videoplayer.c.a(getContext())) {
            y();
            return true;
        }
        k();
        return true;
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void p() {
        Runtime.getRuntime().gc();
        com.sigmob.sdk.nativead.l lVar = this.ak;
        if (lVar != null) {
            lVar.onVideoCompleted();
        }
        SigmobLog.d("onAutoCompletion  [" + hashCode() + "] ");
        r();
        B();
        z();
        A();
        i();
        Window c2 = com.sigmob.sdk.videoplayer.c.c(getContext());
        if (c2 != null) {
            c2.clearFlags(r.b.d);
        }
        s();
        this.v = null;
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void q() {
    }

    public void r() {
        Timer timer = this.N;
        if (timer != null) {
            timer.cancel();
            this.N = null;
        }
        a aVar = this.R;
        if (aVar != null) {
            aVar.cancel();
            this.R = null;
        }
        com.sigmob.sdk.videoplayer.c.g(com.sigmob.sdk.b.e());
    }

    public void s() {
        ProgressBar progressBar = this.ai;
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress(0);
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.ag;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setOnClickListener(onClickListener);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void setBufferProgress(int i2) {
    }

    public void setCurrentVideoAdView(f fVar) {
        this.v = fVar;
    }

    public void setHolderImageResource(int i2) {
    }

    public void setMediaInterface(Class cls) {
        j();
        this.B = cls;
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        this.T.setRotation(f2);
    }

    public void setScreen(int i2) {
        if (i2 == 0) {
            v();
        } else if (i2 == 1) {
            w();
        } else {
            if (i2 != 2) {
                return;
            }
            x();
        }
    }

    public void setSoundChange(boolean z) {
        ImageView imageView;
        Context context;
        String str;
        Context e2 = com.sigmob.sdk.b.e();
        this.al = z;
        if (z) {
            com.sigmob.sdk.videoplayer.c.g(e2);
            i iVar = this.D;
            if (iVar != null) {
                iVar.a(0.0f);
            }
            imageView = this.K;
            context = getContext();
            str = "sig_image_video_mute";
        } else {
            com.sigmob.sdk.videoplayer.c.f(e2);
            i iVar2 = this.D;
            if (iVar2 != null) {
                iVar2.a(1.0f);
            }
            imageView = this.K;
            context = getContext();
            str = "sig_image_video_unmute";
        }
        imageView.setImageResource(ResourceUtil.getDrawableId(context, str));
    }

    public void setState(int i2) {
        a(i2, 0, 0);
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        l lVar = this.T;
        if (lVar == null) {
            return;
        }
        lVar.setSurfaceTexture(surfaceTexture);
    }

    public void setTextureViewRotation(int i2) {
        l lVar;
        f fVar = this.v;
        if (fVar == null || (lVar = fVar.T) == null) {
            return;
        }
        lVar.setRotation(i2);
    }

    public void setUp(String str) {
        a(new g(str, (String) null), 0);
    }

    public void setVideoAdStatusListener(com.sigmob.sdk.nativead.l lVar) {
        this.ak = lVar;
    }

    public void setVideoAdViewListener(com.sigmob.sdk.videoplayer.b bVar) {
        this.am = bVar;
    }

    public void setVideoImageDisplayType(int i2) {
        l lVar;
        u = i2;
        f fVar = this.v;
        if (fVar == null || (lVar = fVar.T) == null) {
            return;
        }
        lVar.requestLayout();
    }

    public void t() {
        com.sigmob.sdk.videoplayer.b bVar = this.am;
        if (bVar != null) {
            bVar.g();
        }
        w();
        this.J.setImageResource(ResourceUtil.getDrawableId(getContext(), "sig_image_video_small"));
    }

    public void u() {
        this.M = System.currentTimeMillis();
        com.sigmob.sdk.videoplayer.b bVar = this.am;
        if (bVar != null) {
            bVar.f();
        }
        v();
        this.J.setImageResource(ResourceUtil.getDrawableId(getContext(), "sig_image_video_fullscreen"));
    }

    public void v() {
        this.x = 0;
    }

    public void w() {
        this.x = 1;
    }

    public void x() {
        this.x = 2;
    }

    public void y() {
    }

    public void z() {
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = -1;
        this.x = -1;
        this.z = 0;
        this.A = 0;
        this.C = true;
        this.E = -1;
        this.F = 0;
        this.G = -1;
        this.H = 0L;
        this.L = false;
        this.M = 0L;
        this.U = new AudioManager.OnAudioFocusChangeListener() { // from class: com.sigmob.sdk.videoplayer.f.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i2) {
                StringBuilder sb;
                if (i2 == -2) {
                    sb = new StringBuilder("AUDIOFOCUS_LOSS_TRANSIENT [");
                } else {
                    if (i2 != -1) {
                        return;
                    }
                    f.this.E();
                    sb = new StringBuilder("AUDIOFOCUS_LOSS [");
                }
                sb.append(hashCode());
                sb.append("]");
                SigmobLog.i(sb.toString());
            }
        };
        this.al = true;
        this.ar = false;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i2) {
        ImageView imageView;
        int drawableId;
        if (i2 == 0 || this.al) {
            imageView = this.K;
            drawableId = ResourceUtil.getDrawableId(getContext(), "sig_image_video_mute");
        } else {
            imageView = this.K;
            drawableId = ResourceUtil.getDrawableId(getContext(), "sig_image_video_unmute");
        }
        imageView.setImageResource(drawableId);
    }

    public void a(float f2) {
        int i2;
        if (this.v != null) {
            int i3 = this.w;
            if ((i3 != 4 && i3 != 5) || (i2 = this.x) == 1 || i2 == 2) {
                return;
            }
            t();
        }
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void c(int i2, int i3) {
        this.ao = i3;
        this.ap = i2;
        l lVar = this.T;
        if (lVar == null) {
            return;
        }
        int i4 = this.F;
        if (i4 != 0) {
            lVar.setRotation(i4);
        }
        this.T.a(i2, i3);
    }

    public void a(float f2, int i2) {
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void b(int i2, int i3) {
        String str;
        SigmobLog.d("onInfo what - " + i2 + " extra - " + i3);
        if (i2 == 3) {
            int i4 = this.w;
            if (i4 == 3 || i4 == 2) {
                f();
                return;
            }
            return;
        }
        if (i2 == 701) {
            if (this.w == 4) {
                this.at = true;
                this.D.d();
                g();
            }
            str = "MEDIA_INFO_BUFFERING_START";
        } else {
            if (i2 != 702) {
                return;
            }
            if (this.at) {
                this.at = false;
                this.D.a();
                f();
            }
            str = "MEDIA_INFO_BUFFERING_END";
        }
        SigmobLog.d(str);
    }

    public void a(float f2, String str, long j2, String str2, long j3) {
    }

    public void b(boolean z) {
        this.ar = z;
    }

    public void a(int i2) {
    }

    @Override // com.sigmob.sdk.videoplayer.h
    public void a(int i2, int i3) {
        StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(i2, i3, "onError ", " - ", " [");
        B7CMnp2.append(hashCode());
        B7CMnp2.append("] ");
        SigmobLog.e(B7CMnp2.toString());
        com.sigmob.sdk.nativead.l lVar = this.ak;
        if (lVar != null) {
            lVar.onVideoError(WindAdError.ERROR_SIGMOB_PLAY_VIDEO);
        }
        if (i2 == 38 || i3 == -38 || i2 == -38 || i3 == 38 || i3 == -19) {
            return;
        }
        h();
        this.D.f();
    }

    public void a(int i2, int i3, int i4) {
        if (i2 == 0) {
            b();
            return;
        }
        if (i2 == 1) {
            c();
            return;
        }
        if (i2 == 2) {
            a(i3, i4);
            return;
        }
        if (i2 == 4) {
            f();
            return;
        }
        if (i2 == 5) {
            g();
        } else if (i2 == 6) {
            i();
        } else {
            if (i2 != 7) {
                return;
            }
            h();
        }
    }

    public void a(int i2, long j2) {
        this.w = 2;
        this.H = j2;
        this.y.b = i2;
        this.D.a((Surface) null);
        this.D.f();
        this.D.c();
    }

    public void a(int i2, long j2, long j3) {
        ProgressBar progressBar;
        if (!this.S) {
            int i3 = this.G;
            if (i3 != -1) {
                if (i3 > i2) {
                    return;
                } else {
                    this.G = -1;
                }
            } else if (i2 != 0 && (progressBar = this.ai) != null) {
                progressBar.setProgress(i2);
            }
        }
        com.sigmob.sdk.nativead.l lVar = this.ak;
        if (lVar != null) {
            lVar.a(j2, j3);
        }
    }

    public void a(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.ae = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_sound_rl"));
        this.ab = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_start_rl"));
        this.ac = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_fullscreen_rl"));
        this.ad = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_replay_rl"));
        this.K = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_sound_btn"));
        this.I = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_start_btn"));
        this.J = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_fullscreen_btn"));
        this.aa = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_surface_container"));
        this.ah = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_app_container"));
        this.ai = (ProgressBar) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_bottom_progress"));
        this.af = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_big_replay"));
        this.aj = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_thumb"));
        this.an = (ImageView) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_blurImageView"));
        this.ag = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_native_video_back_rl"));
        this.as = findViewById(ResourceUtil.getId(getContext(), "sig_native_video_layout_top"));
        this.au = findViewById(ResourceUtil.getId(getContext(), "sig_native_video_layout_bottom"));
        this.ad.setOnClickListener(this);
        this.ae.setOnClickListener(this);
        this.ab.setOnClickListener(this);
        this.ac.setOnClickListener(this);
        this.af.setOnClickListener(this);
        this.O = getContext().getResources().getDisplayMetrics().widthPixels;
        this.P = getContext().getResources().getDisplayMetrics().heightPixels;
        this.aq = new c(new b() { // from class: com.sigmob.sdk.videoplayer.A4TApA
            @Override // com.sigmob.sdk.videoplayer.f.b
            public final void onVolumeChanged(int i2) {
                f.this.b(i2);
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(V);
        IntentUtil.registerReceiver(context, this.aq, intentFilter);
        this.w = -1;
    }

    private void a(View view, int i2) {
        if (view == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void a(ViewGroup viewGroup) {
        try {
            f fVar = (f) getClass().getConstructor(Context.class).newInstance(getContext());
            fVar.setId(getId());
            viewGroup.addView(fVar);
            fVar.a(this.y.c(), 0, this.B);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    public void a(e eVar, boolean z) {
        switch (AnonymousClass2.f13773a[eVar.ordinal()]) {
            case 1:
                a(this.ab, z ? 0 : 4);
                break;
            case 2:
                a(this.ad, z ? 0 : 4);
                break;
            case 3:
                a(this.ae, z ? 0 : 4);
                break;
            case 4:
                a(this.ac, z ? 0 : 4);
                break;
            case 5:
                a(this.af, z ? 0 : 4);
                break;
            case 6:
                a(this.ag, z ? 0 : 4);
                break;
        }
    }

    public void a(g gVar, int i2) {
        a(gVar, i2, (Class) null);
    }

    public void a(g gVar, int i2, Class cls) {
        if (System.currentTimeMillis() - this.M < 200) {
            return;
        }
        this.y = gVar;
        this.x = i2;
        b();
        this.B = cls;
    }

    public void a(g gVar, long j2) {
        this.w = 2;
        this.H = j2;
        this.y = gVar;
        this.D.a((Surface) null);
        this.D.f();
        this.D.c();
    }

    public void a(String str, String str2) {
        a(new g(str, str2), 0);
    }

    public void a(String str, String str2, int i2) {
        a(new g(str, str2), i2);
    }

    public void a(String str, String str2, int i2, Class cls) {
        a(new g(str, str2), i2, cls);
    }

    public void a(String str, String str2, long j2) {
        a(new g(str, str2), j2);
    }

    public void a(boolean z) {
        a(this.ac, z ? 0 : 4);
    }
}
