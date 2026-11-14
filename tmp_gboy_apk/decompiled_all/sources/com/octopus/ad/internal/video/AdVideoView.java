package com.octopus.ad.internal.video;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.octopus.ad.R;
import com.octopus.ad.internal.a.h;
import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.StringUtil;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.internal.video.a;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import com.octopus.ad.internal.view.b;
import com.octopus.ad.internal.view.e;
import com.octopus.ad.model.d;
import com.octopus.ad.utils.b.f;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AdVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, b {

    /* renamed from: a, reason: collision with root package name */
    public com.octopus.ad.internal.view.a f12527a;
    protected MediaPlayer b;
    protected a.b c;
    private final AdViewImpl d;
    private final ServerResponse e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private e r;
    private VideoStateListener s;
    private com.octopus.ad.a.a t;
    private com.octopus.ad.a.a u;
    private String v;
    private Handler w;
    private Runnable x;
    private a y;
    private int z;

    public enum a {
        NRF_NONE,
        NRF_START,
        NRF_PAUSE;

        static {
            sBdO();
        }

        private static /* synthetic */ void sBdO() {
            char[] charArray = "59;x17;3x49/x%>3::x\u001c8?\u0014$?213".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'V');
            }
            String str = new String(charArray);
            char[] charArray2 = "5:?8?\"".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'V');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public AdVideoView(com.octopus.ad.internal.view.a aVar) {
        super(aVar.a());
        this.f = false;
        this.g = false;
        this.h = false;
        this.n = -1;
        this.o = false;
        this.p = true;
        this.q = false;
        this.y = a.NRF_NONE;
        this.c = a.b.FIT_CENTER;
        this.z = 0;
        this.f12527a = aVar;
        AdViewImpl adViewImpl = aVar.f12591a;
        this.d = adViewImpl;
        this.e = aVar.b;
        if (adViewImpl != null) {
            adViewImpl.setAdVideoView(this);
            this.s = adViewImpl.getVideoStateListener();
        }
    }

    private void p() {
        if (this.b != null) {
            e();
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.b = mediaPlayer;
        mediaPlayer.setOnVideoSizeChangedListener(this);
        setSurfaceTextureListener(this);
    }

    private void q() {
        this.w = new Handler();
        this.x = new Runnable() { // from class: com.octopus.ad.internal.video.AdVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer mediaPlayer = AdVideoView.this.b;
                if (mediaPlayer == null || !mediaPlayer.isPlaying() || AdVideoView.this.b.getDuration() <= 0) {
                    return;
                }
                int duration = AdVideoView.this.b.getDuration();
                int currentPosition = AdVideoView.this.b.getCurrentPosition();
                f.a("OctopusAd", "currentPosition:" + currentPosition + "/" + duration);
                int i = currentPosition / 1000;
                int i2 = i == duration / TTAdConstant.INIT_LOCAL_FAIL_CODE ? 1 : i == duration / 2000 ? 2 : i == (duration * 3) / TTAdConstant.INIT_LOCAL_FAIL_CODE ? 3 : 0;
                if (i2 > 0 && AdVideoView.this.e != null) {
                    AdVideoView.this.e.c(i2);
                }
                f.a("OctopusAd", "video progress:" + i2);
                AdVideoView.this.r();
            }
        };
        a(new MediaPlayer.OnPreparedListener() { // from class: com.octopus.ad.internal.video.AdVideoView.5
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                AdVideoView.this.setScalableType(a.b.FIT_CENTER);
                AdVideoView.this.n = mediaPlayer.getDuration() / 1000;
                int unused = AdVideoView.this.n;
                if (AdVideoView.this.o) {
                    HaoboLog.e(HaoboLog.baseLogTag, "Video start called!");
                    AdVideoView.this.c();
                    AdVideoView.this.y = a.NRF_START;
                    if (AdVideoView.this.e != null) {
                        AdVideoView.this.e.ad();
                    }
                    if (AdVideoView.this.s != null) {
                        AdVideoView.this.s.onVideoStart();
                    }
                    if (AdVideoView.this.d != null) {
                        AdVideoView.this.d.m();
                    }
                    AdVideoView.this.r();
                } else {
                    AdVideoView.this.y = a.NRF_PAUSE;
                }
                if (AdVideoView.this.n > 0 || AdVideoView.this.d == null) {
                    return;
                }
                AdVideoView.this.d.b(80202);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Handler handler = this.w;
        if (handler == null || this.x == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.w.postDelayed(this.x, 1000L);
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        a(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    @Override // com.octopus.ad.internal.view.b
    public com.octopus.ad.internal.view.a getAdWebView() {
        return this.f12527a;
    }

    @Override // com.octopus.ad.internal.view.b
    public int getCreativeHeight() {
        return this.l;
    }

    public int getCreativeLeft() {
        return this.i;
    }

    public int getCreativeTop() {
        return this.j;
    }

    @Override // com.octopus.ad.internal.view.b
    public int getCreativeWidth() {
        return this.k;
    }

    public int getCurrentPosition() {
        return this.b.getCurrentPosition();
    }

    public int getDuration() {
        return this.b.getDuration();
    }

    public int getRefreshInterval() {
        return this.m;
    }

    public int getVideoHeight() {
        return this.b.getVideoHeight();
    }

    public String getVideoUrl() {
        return this.v;
    }

    public int getVideoWidth() {
        return this.b.getVideoWidth();
    }

    @Override // com.octopus.ad.internal.view.b
    public View getView() {
        return this;
    }

    @Override // com.octopus.ad.internal.view.b
    public boolean j() {
        return this.f;
    }

    @Override // com.octopus.ad.internal.view.b
    public void k() {
        d();
        ViewUtil.removeChildFromParent(this);
    }

    @Override // com.octopus.ad.internal.view.b
    public void l() {
        if (this.d != null) {
            ServerResponse serverResponse = this.e;
            if (serverResponse != null) {
                this.q = serverResponse.Q();
            }
            this.r = new e(this, this.q, new e.a() { // from class: com.octopus.ad.internal.video.AdVideoView.7
                @Override // com.octopus.ad.internal.view.e.a
                public void a(View view, d dVar) {
                    AdVideoView.this.a(dVar);
                }
            });
            this.d.d(this);
            this.d.c(this);
            this.d.e(this);
            com.octopus.ad.internal.view.a aVar = this.f12527a;
            if (aVar == null || !aVar.d()) {
                return;
            }
            if (this.d.getMediaType() == p.INTERSTITIAL || this.d.getMediaType() == p.FULLSCREEN) {
                this.d.a(this.f12527a.g(), this.f12527a.h(), this);
            } else if (this.d.getMediaType() == p.REWARD) {
                this.d.a(this.n, this.f12527a.g(), Math.min(this.f12527a.h(), this.n));
            }
            this.d.a(this, this.p);
            this.d.setAdWebView(this.f12527a);
            this.d.a(this);
        }
    }

    @Override // com.octopus.ad.internal.view.b
    public void m() {
        if (this.h || this.y != a.NRF_START) {
            return;
        }
        b();
        com.octopus.ad.a.a aVar = this.t;
        if (aVar != null) {
            aVar.b();
        }
        ServerResponse serverResponse = this.e;
        if (serverResponse != null) {
            serverResponse.ae();
        }
        VideoStateListener videoStateListener = this.s;
        if (videoStateListener != null) {
            videoStateListener.onVideoPause();
        }
        this.y = a.NRF_PAUSE;
    }

    @Override // com.octopus.ad.internal.view.b
    public void n() {
        if (this.h || this.y != a.NRF_PAUSE) {
            return;
        }
        c();
        com.octopus.ad.a.a aVar = this.t;
        if (aVar != null) {
            aVar.c();
        }
        VideoStateListener videoStateListener = this.s;
        if (videoStateListener != null) {
            videoStateListener.onVideoResume();
        }
        this.y = a.NRF_START;
    }

    @Override // com.octopus.ad.internal.view.b
    public void o() {
        k();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b == null) {
            return;
        }
        if (a()) {
            d();
        }
        f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
            h();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar = this.r;
        return eVar != null ? eVar.onTouch(this, motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        b(getWindowVisibility(), i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b(i, getVisibility());
    }

    public void setAssetData(String str) {
        setDataSource(getContext().getAssets().openFd(str));
    }

    public void setCountDownTimer(com.octopus.ad.a.a aVar) {
        this.t = aVar;
    }

    public void setCreativeLeft(int i) {
        this.i = i;
    }

    public void setCreativeTop(int i) {
        this.j = i;
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.b.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.b.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.b.setOnInfoListener(onInfoListener);
    }

    public void setOpt(int i) {
        this.z = i;
    }

    public void setRawData(int i) {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setRefreshInterval(int i) {
        this.m = i;
    }

    public void setScalableType(a.b bVar) {
        this.c = bVar;
        a(getVideoWidth(), getVideoHeight());
    }

    public void c() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void d() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void e() {
        this.b.reset();
    }

    public void f() {
        e();
        Handler handler = this.w;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.w = null;
        }
        this.x = null;
        this.b.release();
        this.b = null;
    }

    public boolean g() {
        boolean z = this.p;
        this.p = !z;
        if (z) {
            a(1.0f, 1.0f);
        } else {
            a(0.0f, 0.0f);
        }
        return this.p;
    }

    public void h() {
        ServerResponse serverResponse;
        if (TextUtils.isEmpty(this.v)) {
            return;
        }
        try {
            h b = q.a().b();
            if (b == null || !b.b(this.v)) {
                setDataSource(this.v);
            } else {
                setDataSource(b.a(this.v));
            }
            q();
            AdViewImpl adViewImpl = this.d;
            if (adViewImpl == null || adViewImpl.getMediaType() == p.SPLASH || (serverResponse = this.e) == null) {
                return;
            }
            serverResponse.a(this.d.g(), new com.octopus.ad.a() { // from class: com.octopus.ad.internal.video.AdVideoView.6
                @Override // com.octopus.ad.a
                public void a(boolean z) {
                    if (AdVideoView.this.d.getAdDispatcher() != null) {
                        AdVideoView.this.d.getAdDispatcher().a(z);
                    }
                }
            });
        } catch (Exception e) {
            e.getMessage();
            HaoboLog.e(HaoboLog.videoLogTag, HaoboLog.getString(R.string.failed_video_load, this.v, e.getMessage()));
            AdViewImpl adViewImpl2 = this.d;
            if (adViewImpl2 != null) {
                adViewImpl2.b(80202);
            }
        }
    }

    public void i() {
        com.octopus.ad.internal.view.a aVar = this.f12527a;
        if (aVar != null) {
            aVar.r();
        }
        this.f = true;
    }

    public void b() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void setDataSource(String str) {
        p();
        this.b.setDataSource(str);
    }

    private void b(int i, int i2) {
        this.o = i == 0 && i2 == 0;
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        p();
        this.b.setDataSource(fileDescriptor);
    }

    private void a(int i, int i2) {
        Matrix a2;
        if (i == 0 || i2 == 0 || (a2 = new com.octopus.ad.internal.video.a(new a.c(getWidth(), getHeight()), new a.c(i, i2)).a(this.c)) == null) {
            return;
        }
        setTransform(a2);
    }

    public void a(FileDescriptor fileDescriptor, long j, long j2) {
        p();
        this.b.setDataSource(fileDescriptor, j, j2);
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.b.setOnPreparedListener(onPreparedListener);
        this.b.prepareAsync();
        VideoStateListener videoStateListener = this.s;
        if (videoStateListener != null) {
            videoStateListener.onVideoReady();
        }
    }

    public boolean a() {
        return this.b.isPlaying();
    }

    public void a(float f, float f2) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    private void a(HashMap hashMap) {
        String str;
        if (hashMap.isEmpty() || !hashMap.containsKey("SCALE") || (str = (String) hashMap.get("SCALE")) == null) {
            return;
        }
        switch (str) {
            case "RIGHT_TOP_CROP":
                this.c = a.b.RIGHT_TOP_CROP;
                break;
            case "RIGHT_BOTTOM":
                this.c = a.b.RIGHT_BOTTOM;
                break;
            case "RIGHT_CENTER":
                this.c = a.b.RIGHT_CENTER;
                break;
            case "LEFT_TOP":
                this.c = a.b.LEFT_TOP;
                break;
            case "RIGHT_CENTER_CROP":
                this.c = a.b.RIGHT_CENTER_CROP;
                break;
            case "LEFT_TOP_CROP":
                this.c = a.b.LEFT_TOP_CROP;
                break;
            case "END_INSIDE":
                this.c = a.b.END_INSIDE;
                break;
            case "LEFT_BOTTOM":
                this.c = a.b.LEFT_BOTTOM;
                break;
            case "LEFT_CENTER":
                this.c = a.b.LEFT_CENTER;
                break;
            case "CENTER_CROP":
                this.c = a.b.CENTER_CROP;
                break;
            case "CENTER_BOTTOM_CROP":
                this.c = a.b.CENTER_BOTTOM_CROP;
                break;
            case "CENTER_TOP_CROP":
                this.c = a.b.CENTER_TOP_CROP;
                break;
            case "LEFT_CENTER_CROP":
                this.c = a.b.LEFT_CENTER_CROP;
                break;
            case "FIT_END":
                this.c = a.b.FIT_END;
                break;
            case "START_INSIDE":
                this.c = a.b.START_INSIDE;
                break;
            case "RIGHT_BOTTOM_CROP":
                this.c = a.b.RIGHT_BOTTOM_CROP;
                break;
            case "FIT_START":
                this.c = a.b.FIT_START;
                break;
            case "FIT_CENTER":
                this.c = a.b.FIT_CENTER;
                break;
            case "RIGHT_TOP":
                this.c = a.b.RIGHT_TOP;
                break;
            case "CENTER_BOTTOM":
                this.c = a.b.CENTER_BOTTOM;
                break;
            case "CENTER_TOP":
                this.c = a.b.CENTER_TOP;
                break;
            case "CENTER_INSIDE":
                this.c = a.b.CENTER_INSIDE;
                break;
            case "LEFT_BOTTOM_CROP":
                this.c = a.b.LEFT_BOTTOM_CROP;
                break;
            case "CENTER":
                this.c = a.b.CENTER;
                break;
            case "FIT_XY":
                this.c = a.b.FIT_XY;
                break;
            default:
                this.c = a.b.FIT_CENTER;
                break;
        }
    }

    public void a(String str) {
        int creativeWidth;
        int creativeHeight;
        if (StringUtil.isEmpty(str)) {
            i();
            AdViewImpl adViewImpl = this.d;
            if (adViewImpl != null) {
                adViewImpl.b(80200);
                return;
            }
            return;
        }
        if (!str.endsWith(".jpg") && !str.endsWith(".jpeg") && !str.endsWith(".png")) {
            com.octopus.ad.internal.view.a aVar = this.f12527a;
            if (aVar != null) {
                this.l = aVar.getCreativeHeight();
                this.k = this.f12527a.getCreativeWidth();
                this.j = this.f12527a.f();
                this.i = this.f12527a.e();
                this.m = this.f12527a.u();
            }
            try {
                new URI(str);
                this.c = a.b.FIT_CENTER;
                HaoboLog.v(HaoboLog.videoLogTag, HaoboLog.getString(R.string.videoview_loading, str));
                com.octopus.ad.internal.view.a aVar2 = this.f12527a;
                if (aVar2 != null) {
                    a(aVar2.b());
                    this.p = this.f12527a.i() && q.a().f();
                }
                this.v = str;
                p();
                float e = q.a().e();
                if (this.p) {
                    a(0.0f, 0.0f);
                } else if (e > 0.0f) {
                    a(e, e);
                } else {
                    a(1.0f, 1.0f);
                }
                float n = q.a().n();
                float o = q.a().o();
                if (getCreativeWidth() == 1 && getCreativeHeight() == 1) {
                    creativeHeight = -1;
                    creativeWidth = -1;
                } else {
                    creativeWidth = (int) ((getCreativeWidth() * n) + 0.5f);
                    creativeHeight = (int) ((getCreativeHeight() * o) + 0.5f);
                }
                if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                    setLayoutParams(new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17));
                } else {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 8388659);
                    layoutParams.setMargins((int) ((getCreativeLeft() * n) + 0.5f), (int) ((getCreativeTop() * o) + 0.5f), 0, 0);
                    setLayoutParams(layoutParams);
                }
                setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.octopus.ad.internal.video.AdVideoView.1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        AdVideoView.this.h = true;
                        if (AdVideoView.this.e != null) {
                            AdVideoView.this.e.af();
                        }
                        if (AdVideoView.this.d != null) {
                            AdVideoView.this.d.p();
                        }
                        if (AdVideoView.this.s != null) {
                            AdVideoView.this.s.onVideoCompleted();
                        }
                        com.octopus.ad.internal.view.a aVar3 = AdVideoView.this.f12527a;
                        if ((aVar3 == null || aVar3.a(1)) && (AdVideoView.this.d instanceof InterstitialAdViewImpl) && ((InterstitialAdViewImpl) AdVideoView.this.d).getAdImplementation() != null) {
                            ((com.octopus.ad.internal.activity.a) ((InterstitialAdViewImpl) AdVideoView.this.d).getAdImplementation()).f();
                        }
                        if (AdVideoView.this.d != null) {
                            AdVideoView.this.d.v();
                        }
                    }
                });
                setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.octopus.ad.internal.video.AdVideoView.2
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                        if (i != 3 && i != 702) {
                            if (AdVideoView.this.t == null || !AdVideoView.this.t.f()) {
                                return false;
                            }
                            AdVideoView.this.t.b();
                            if (AdVideoView.this.s != null) {
                                AdVideoView.this.s.onVideoStart();
                            }
                            if (AdVideoView.this.d != null) {
                                AdVideoView.this.d.a(AdVideoView.this);
                            }
                            if (AdVideoView.this.u == null) {
                                AdVideoView.this.u = new com.octopus.ad.a.a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 50L);
                                AdVideoView.this.u.a(new com.octopus.ad.a.b() { // from class: com.octopus.ad.internal.video.AdVideoView.2.1
                                    @Override // com.octopus.ad.a.b
                                    public void a(long j) {
                                    }

                                    @Override // com.octopus.ad.a.b
                                    public void b() {
                                    }

                                    @Override // com.octopus.ad.a.b
                                    public void a() {
                                        if (AdVideoView.this.t != null) {
                                            AdVideoView.this.t.c();
                                        }
                                    }
                                });
                            }
                            AdVideoView.this.u.a();
                            return false;
                        }
                        if (AdVideoView.this.d != null && AdVideoView.this.d.getAdDispatcher() != null) {
                            if (!AdVideoView.this.g) {
                                AdVideoView.this.g = true;
                                AdVideoView adVideoView = AdVideoView.this;
                                if (adVideoView.f12527a != null && adVideoView.d.d() && AdVideoView.this.t == null) {
                                    AdVideoView.this.d.a(AdVideoView.this.n, AdVideoView.this.f12527a.g(), AdVideoView.this.f12527a.h());
                                }
                            }
                            AdVideoView.this.d.i();
                            AdVideoView.this.d.getAdDispatcher().d();
                        }
                        if (AdVideoView.this.t != null) {
                            AdVideoView.this.t.c();
                        }
                        if (AdVideoView.this.u == null) {
                            return false;
                        }
                        AdVideoView.this.u.e();
                        return false;
                    }
                });
                setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.octopus.ad.internal.video.AdVideoView.3
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (i == -38) {
                            AdVideoView.this.c();
                        } else if (AdVideoView.this.d != null) {
                            AdVideoView.this.d.b(80202);
                        }
                        if (AdVideoView.this.s == null) {
                            return false;
                        }
                        AdVideoView.this.s.onVideoError(i, i2);
                        return false;
                    }
                });
                return;
            } catch (NullPointerException | URISyntaxException unused) {
                HaoboLog.e(HaoboLog.videoLogTag, HaoboLog.getString(R.string.invalid_video_url, str));
                i();
                AdViewImpl adViewImpl2 = this.d;
                if (adViewImpl2 != null) {
                    adViewImpl2.b(80201);
                    return;
                }
                return;
            }
        }
        i();
        AdViewImpl adViewImpl3 = this.d;
        if (adViewImpl3 != null) {
            adViewImpl3.b(80201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        AdViewImpl adViewImpl = this.d;
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
            return;
        }
        AdViewImpl adViewImpl2 = this.d;
        adViewImpl2.j++;
        if (adViewImpl2.g()) {
            this.d.getAdDispatcher().b();
        }
        ServerResponse serverResponse = this.e;
        if (serverResponse != null) {
            serverResponse.a(this.d.getOpensNativeBrowser());
            this.e.a(this, this.z, this.d.g(), dVar);
        }
    }
}
