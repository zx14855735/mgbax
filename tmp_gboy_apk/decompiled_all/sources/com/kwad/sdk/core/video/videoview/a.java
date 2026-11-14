package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.a.e;
import com.kwad.sdk.core.video.a.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.i;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    private static AtomicBoolean aPr = new AtomicBoolean(false);
    private AudioManager aPn;
    private com.kwad.sdk.core.video.a aPo;
    private b aPp;
    private boolean aPq;
    private boolean aPs;
    private boolean aPt;
    private ImageView aPu;
    private boolean aPv;
    private int adF;
    private com.kwad.sdk.core.video.a.c adG;
    private int adH;
    private long adI;
    private com.kwad.sdk.contentalliance.a.a.b adK;
    private c.e adW;
    private c.i adX;
    private c.b adY;
    private c.InterfaceC0369c adZ;
    private c.d aea;
    private c.a aeb;
    private SurfaceTexture aej;
    private TextView aek;
    private Surface ael;
    private InterfaceC0370a cz;
    private FrameLayout dm;
    private com.kwad.sdk.contentalliance.a.a.a fh;
    private Context mContext;
    private Map<String, String> mHeaders;
    private String mUrl;
    private final long maxTimeOut;

    /* renamed from: com.kwad.sdk.core.video.videoview.a$a, reason: collision with other inner class name */
    public interface InterfaceC0370a {
        com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar);
    }

    static {
        dNHnZ();
    }

    public a(Context context) {
        this(context, null);
    }

    private ImageView LU() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean LV() {
        return this.adF == 6;
    }

    private void LX() {
        if (this.adG == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            boolean z = fVar != null && fVar.CR();
            boolean z2 = fVar != null && fVar.CS();
            InterfaceC0370a interfaceC0370a = this.cz;
            com.kwad.sdk.core.video.a.c a2 = interfaceC0370a != null ? interfaceC0370a.a(this.adK) : null;
            if ((z && e.Ft() && e.LT()) || a2 == null) {
                this.adG = e.a(this.mContext, false, z, z2, 0);
            } else {
                this.adG = a2;
            }
            this.adG.setAudioStreamType(3);
            if (this.aPs) {
                return;
            }
            this.adG.setVolume(0.0f, 0.0f);
        }
    }

    private void LY() {
        this.dm.removeView(this.aPo);
        this.dm.addView(this.aPo, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void LZ() {
        if (!com.kwad.framework.c.a.oy.booleanValue() || this.adG == null || this.dm == null) {
            return;
        }
        if (this.aek == null) {
            this.aek = new TextView(this.mContext);
        }
        this.dm.removeView(this.aek);
        this.aek.setText(String.valueOf(this.adG.getMediaPlayerType()));
        this.aek.setTextColor(-65536);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        this.dm.addView(this.aek, r1.getChildCount() - 1, layoutParams);
    }

    private void Ma() {
        com.kwad.sdk.contentalliance.a.a.a aVar;
        this.dm.setKeepScreenOn(true);
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar == null) {
            com.kwad.sdk.core.d.c.w("KSVideoPlayerViewView", "mMediaPlayer is null");
            return;
        }
        cVar.b(this.adW);
        this.adG.a(this.adX);
        this.adG.a(this.adY);
        this.adG.a(this.adZ);
        this.adG.c(this.aea);
        this.adG.a(this.aeb);
        try {
            com.kwad.sdk.contentalliance.a.a.b bVar = this.adK;
            if (bVar != null && (aVar = this.fh) != null) {
                bVar.aAX = aVar;
            }
            this.adG.b(bVar);
            if (this.ael == null) {
                this.ael = new Surface(this.aej);
            }
            this.adG.setSurface(this.ael);
            if (this.adG.prepareAsync()) {
                this.adF = 1;
                this.aPp.onPlayStateChanged(1);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.core.d.c.e("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    private void Mb() {
        AudioManager audioManager = this.aPn;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.aPn = null;
        }
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar != null) {
            cVar.release();
            this.adG = null;
            com.kwad.sdk.core.video.a.a.a.eU("videoFinishPlay");
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.sdk.core.video.videoview.a.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.dm.removeView(a.this.aPo);
            }
        });
        Surface surface = this.ael;
        if (surface != null) {
            surface.release();
            this.ael = null;
        }
        SurfaceTexture surfaceTexture = this.aej;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.aej = null;
        }
        this.adF = 0;
    }

    private static /* synthetic */ void dNHnZ() {
        char[] charArray = "\u007fsq2{}qy2~se2otypp2Vru^nux{y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 28);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u007fpuruh".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 28);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void eO(AdTemplate adTemplate) {
        i iVar = (i) ServiceProvider.get(i.class);
        if (iVar != null) {
            iVar.load(this.aPu, com.kwad.sdk.core.response.b.e.ev(adTemplate), adTemplate);
        }
    }

    private void init() {
        this.aPu = LU();
        this.dm = new FrameLayout(this.mContext);
        addView(this.dm, new FrameLayout.LayoutParams(-1, -1));
    }

    private boolean isPreparing() {
        return this.adF == 1;
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.adK;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    private void vi() {
        if (this.aPo == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.mContext);
            this.aPo = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean LW() {
        return this.adF == 7;
    }

    public final void Mc() {
        if (this.aPq) {
            if (isPlaying() || LV() || LW() || isPaused()) {
                ag.e(this.mContext, this.mUrl, getCurrentPosition());
            } else if (isCompleted()) {
                ag.e(this.mContext, this.mUrl, 0L);
            }
        }
        Mb();
        b bVar = this.aPp;
        if (bVar != null) {
            bVar.reset();
        }
        this.aPv = false;
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar, Map<String, String> map) {
        this.adK = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        eO(bVar.adTemplate);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.adH;
    }

    public final b getController() {
        return this.aPp;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.aPn;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final b getVideoController() {
        return this.aPp;
    }

    public final int getVolume() {
        AudioManager audioManager = this.aPn;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        return this.adF == 9;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        return this.adF == 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        return this.adF == 5;
    }

    public final boolean isPlaying() {
        return this.adF == 4;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.aej;
        if (surfaceTexture2 != null) {
            this.aPo.setSurfaceTexture(surfaceTexture2);
        } else {
            this.aej = surfaceTexture;
            Ma();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar == null) {
            return;
        }
        int i = this.adF;
        if (i == 4) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.eU("videoPausePlay");
            this.adF = 5;
            this.aPp.onPlayStateChanged(5);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PAUSED");
            return;
        }
        if (i == 6) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.eU("videoPausePlay");
            this.adF = 7;
            this.aPp.onPlayStateChanged(7);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        if (isPreparing()) {
            this.aPv = true;
            postDelayed(new bg() { // from class: com.kwad.sdk.core.video.videoview.a.8
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (a.this.aPv) {
                        a.this.Mc();
                    }
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            return;
        }
        if (this.aPq) {
            if (isPlaying() || LV() || LW() || isPaused()) {
                ag.e(this.mContext, this.mUrl, getCurrentPosition());
            } else if (isCompleted()) {
                ag.e(this.mContext, this.mUrl, 0L);
            }
        }
        Mb();
        b bVar = this.aPp;
        if (bVar != null) {
            bVar.reset();
        }
        this.aPv = false;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i = this.adF;
        if (i == 5) {
            this.adG.start();
            com.kwad.sdk.core.video.a.a.a.eU("videoResumePlay");
            this.adF = 4;
            this.aPp.onPlayStateChanged(4);
            setPlayType(2);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_PLAYING");
            return;
        }
        if (i == 7) {
            this.adG.start();
            com.kwad.sdk.core.video.a.a.a.eU("videoResumePlay");
            this.adF = 6;
            this.aPp.onPlayStateChanged(6);
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
            return;
        }
        if (i == 9 || i == -1) {
            this.adG.reset();
            Ma();
            setPlayType(3);
        } else {
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.adF + " 时不能调用restart()方法.");
        }
    }

    public final void seekTo(int i) {
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar != null) {
            cVar.seekTo(i);
        }
    }

    public final void setController(b bVar) {
        this.dm.removeView(this.aPp);
        this.aPp = bVar;
        bVar.reset();
        this.dm.addView(this.aPp, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void setExternalPlayerListener(InterfaceC0370a interfaceC0370a) {
        this.cz = interfaceC0370a;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a aVar) {
        this.fh = aVar;
    }

    public final void setLooping(boolean z) {
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar != null) {
            cVar.setLooping(z);
        }
    }

    public final void setPortraitFullscreen(boolean z) {
        this.aPt = z;
    }

    public final void setVideoSoundEnable(boolean z) {
        this.aPs = z;
        com.kwad.sdk.core.video.a.c cVar = this.adG;
        if (cVar != null) {
            if (z) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i) {
        AudioManager audioManager = this.aPn;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.adF != 0) {
            com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        LX();
        vi();
        LY();
        LZ();
        com.kwad.sdk.contentalliance.a.a.b bVar = this.adK;
        if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
            if (videoPlayerStatus.mVideoPlayerType == 0) {
                setPlayType(1);
            } else {
                setPlayType(3);
            }
        }
        com.kwad.sdk.core.video.a.a.a.eU("videoStartPlay");
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.adF = 0;
        this.aPq = false;
        this.aPs = false;
        this.aPt = false;
        this.maxTimeOut = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.adW = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.adF = 2;
                    a.this.aPp.onPlayStateChanged(a.this.adF);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    if (a.this.aPv) {
                        a.this.release();
                        return;
                    }
                    cVar.start();
                    if (a.this.aPq) {
                        cVar.seekTo((int) ag.X(a.this.mContext, a.this.mUrl));
                    }
                    if (a.this.adI != 0) {
                        cVar.seekTo((int) a.this.adI);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.adX = new c.i() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void l(int i, int i2) {
                if (!a.this.aPt || i2 <= i) {
                    a.this.aPo.adaptVideoSize(i, i2);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
                }
            }
        };
        this.adY = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void rE() {
                if (a.this.adF != 9) {
                    a.this.adF = 9;
                    a.this.aPp.onPlayStateChanged(a.this.adF);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.dm.setKeepScreenOn(false);
                }
            }
        };
        this.adZ = new c.InterfaceC0369c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0369c
            public final boolean m(int i, int i2) {
                if (i == -38) {
                    return true;
                }
                a.this.adF = -1;
                a.this.aPp.p(i, i2);
                a.this.aPp.onPlayStateChanged(a.this.adF);
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                return true;
            }
        };
        this.aea = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean n(int i, int i2) {
                if (i == 3) {
                    a.this.adF = 4;
                    a.this.aPp.onPlayStateChanged(a.this.adF);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                    return true;
                }
                if (i == 701) {
                    if (a.this.adF == 5 || a.this.adF == 7) {
                        a.this.adF = 7;
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        a.this.adF = 6;
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    a.this.aPp.onPlayStateChanged(a.this.adF);
                    return true;
                }
                if (i == 702) {
                    if (a.this.adF == 6) {
                        a.this.adF = 4;
                        a.this.aPp.onPlayStateChanged(a.this.adF);
                        com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.adF != 7) {
                        return true;
                    }
                    a.this.adF = 5;
                    a.this.aPp.onPlayStateChanged(a.this.adF);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    return true;
                }
                if (i == 10001) {
                    if (a.this.aPo == null) {
                        return true;
                    }
                    a.this.aPo.setRotation(i2);
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频旋转角度：" + i2);
                    return true;
                }
                if (i == 801) {
                    com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                    return true;
                }
                com.kwad.sdk.core.d.c.i("KSVideoPlayerViewView", "onInfo ——> what：" + i);
                return true;
            }
        };
        this.aeb = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aM(int i) {
                a.this.adH = i;
            }
        };
        this.mContext = context;
        init();
    }
}
