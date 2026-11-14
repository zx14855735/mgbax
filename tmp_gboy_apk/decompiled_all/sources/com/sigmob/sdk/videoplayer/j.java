package com.sigmob.sdk.videoplayer;

import BTvldC.B25kr6;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j extends i implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    private static final String f = "VideoPlayerMediaSystem";
    public MediaPlayer e;
    private boolean g;

    public j(h hVar) {
        super(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        hVar.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        hVar.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        hVar.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        try {
            g videoPlayerDataSource = this.d.getVideoPlayerDataSource();
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.e.setLooping(videoPlayerDataSource.e);
            this.e.setOnPreparedListener(this);
            this.e.setOnCompletionListener(this);
            this.e.setOnBufferingUpdateListener(this);
            this.e.setScreenOnWhilePlaying(true);
            this.e.setOnSeekCompleteListener(this);
            this.e.setOnErrorListener(this);
            this.e.setOnInfoListener(this);
            this.e.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.e, videoPlayerDataSource.a().toString(), videoPlayerDataSource.d);
            this.e.prepareAsync();
            if (this.f13777a != null) {
                this.g = false;
                this.e.setSurface(new Surface(this.f13777a));
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.c.post(new A5SV6n(this, 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        hVar.a(0, 0);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a() {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new A5SV6n(this, 3));
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void b() {
        c();
        this.g = true;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void c() {
        MediaPlayer mediaPlayer;
        if (this.g && (mediaPlayer = this.e) != null && this.f13777a != null) {
            this.g = false;
            mediaPlayer.setSurface(new Surface(this.f13777a));
            return;
        }
        f();
        this.c = new Handler();
        Handler iOHandler = ThreadPoolFactory.BackgroundThreadPool.getInstance().getIOHandler();
        this.b = iOHandler;
        iOHandler.post(new A5SV6n(this, 2));
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void d() {
        Handler handler = this.b;
        if (handler == null || this.e == null) {
            return;
        }
        handler.post(new A5SV6n(this, 1));
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public boolean e() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void f() {
        MediaPlayer mediaPlayer;
        Handler handler = this.b;
        if (handler == null || (mediaPlayer = this.e) == null) {
            return;
        }
        handler.post(new AMqCpz(this, 0, mediaPlayer));
        this.e = null;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public long g() {
        if (this.e == null) {
            return 0L;
        }
        return r0.getCurrentPosition();
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public int h() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return 0;
        }
        mediaPlayer.getVideoWidth();
        return 0;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public int i() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return 0;
        }
        mediaPlayer.getVideoHeight();
        return 0;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public long j() {
        if (this.e == null) {
            return 0L;
        }
        return r0.getDuration();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        handler.post(new B25kr6(i, 4, this));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        handler.post(new A5SV6n(this, 5));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Handler handler = this.c;
        if (handler == null) {
            return false;
        }
        handler.post(new ADYaiT(this, i, i2, 2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        Handler handler = this.c;
        if (handler != null && this.d != null) {
            handler.post(new ADYaiT(this, i, i2, 1));
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        handler.post(new A5SV6n(this, 6));
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        handler.post(new A5SV6n(this, 0));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.f13777a;
        if (surfaceTexture2 != null) {
            hVar.setSurfaceTexture(surfaceTexture2);
        } else {
            this.f13777a = surfaceTexture;
            c();
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

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        handler.post(new ADYaiT(this, i, i2, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(float f2) {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a(final float f2) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.ASJ6gh
            @Override // java.lang.Runnable
            public final void run() {
                j.this.c(f2);
            }
        });
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void b(float f2) {
        PlaybackParams playbackParams;
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null && Build.VERSION.SDK_INT >= 23) {
            playbackParams = mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f2);
            this.e.setPlaybackParams(playbackParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        hVar.setBufferProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, int i2) {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        hVar.b(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i, int i2) {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        hVar.a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, int i2) {
        h hVar = this.d;
        if (hVar == null) {
            return;
        }
        hVar.c(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(long j) {
        try {
            MediaPlayer mediaPlayer = this.e;
            if (mediaPlayer == null) {
                return;
            }
            mediaPlayer.seekTo((int) j);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a(final long j) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.ARc23Z
            @Override // java.lang.Runnable
            public final void run() {
                j.this.b(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MediaPlayer mediaPlayer) {
        mediaPlayer.setSurface(null);
        mediaPlayer.release();
        this.b = null;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a(Surface surface) {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setSurface(surface);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a(boolean z) {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setLooping(z);
    }
}
