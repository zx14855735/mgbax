package com.bykv.vk.openvk.component.video.xj.u;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.component.sdk.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.n;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends com.bykv.vk.openvk.component.video.xj.u.xj {
    private volatile boolean c;
    private final MediaPlayer hf;
    private Surface kd;
    private com.bykv.vk.openvk.component.video.xj.xj.xj u;
    private final xj w;
    private final Object y;

    public static class xj implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<hf> xj;

        public xj(hf hfVar) {
            this.xj = new WeakReference<>(hfVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                hf hfVar = this.xj.get();
                if (hfVar != null) {
                    hfVar.xj(i);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                hf hfVar = this.xj.get();
                if (hfVar != null) {
                    hfVar.w();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO", "onError: ", Integer.valueOf(i), Integer.valueOf(i2));
                hf hfVar = this.xj.get();
                if (hfVar != null) {
                    if (hfVar.xj(i, i2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_VIDEO", "onInfo: ");
                hf hfVar = this.xj.get();
                if (hfVar != null) {
                    if (hfVar.hf(i, i2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                hf hfVar = this.xj.get();
                if (hfVar != null) {
                    hfVar.hf();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                hf hfVar = this.xj.get();
                if (hfVar != null) {
                    hfVar.u();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                hf hfVar = this.xj.get();
                if (hfVar != null) {
                    hfVar.xj(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }
    }

    public hf() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.y = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.hf = mediaPlayer;
        }
        xj(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.w = new xj(this);
        zg();
    }

    private void e() {
        try {
            Surface surface = this.kd;
            if (surface != null) {
                surface.release();
                this.kd = null;
            }
        } catch (Throwable unused) {
        }
    }

    private void qt() {
        com.bykv.vk.openvk.component.video.xj.xj.xj xjVar;
        if (Build.VERSION.SDK_INT < 23 || (xjVar = this.u) == null) {
            return;
        }
        try {
            xjVar.close();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
        }
        this.u = null;
    }

    private void xj(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.component.video.api.w.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(newInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
            } catch (Throwable th) {
                try {
                    com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    private void zg() {
        this.hf.setOnPreparedListener(this.w);
        this.hf.setOnBufferingUpdateListener(this.w);
        this.hf.setOnCompletionListener(this.w);
        this.hf.setOnSeekCompleteListener(this.w);
        this.hf.setOnVideoSizeChangedListener(this.w);
        this.hf.setOnErrorListener(this.w);
        this.hf.setOnInfoListener(this.w);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public int am() {
        MediaPlayer mediaPlayer = this.hf;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void c() {
        this.hf.pause();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public long d() {
        try {
            return this.hf.getCurrentPosition();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void f() {
        MediaPlayer mediaPlayer = this.hf;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    public void finalize() {
        super.finalize();
        e();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public int g() {
        MediaPlayer mediaPlayer = this.hf;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void hf(boolean z) {
        this.hf.setScreenOnWhilePlaying(z);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void kd() {
        this.hf.start();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void p() {
        synchronized (this.y) {
            try {
                if (!this.c) {
                    this.hf.release();
                    this.c = true;
                    e();
                    qt();
                    xj();
                    zg();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void pl() {
        try {
            this.hf.reset();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "reset error: ", th);
        }
        qt();
        xj();
        zg();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public long tf() {
        try {
            return this.hf.getDuration();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.w("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void u(boolean z) {
        MediaPlayer mediaPlayer = this.hf;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void w(boolean z) {
        this.hf.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void y() {
        this.hf.stop();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void kd(boolean z) {
        try {
            MediaPlayer mediaPlayer = this.hf;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void xj(SurfaceHolder surfaceHolder) {
        synchronized (this.y) {
            try {
                if (!this.c && surfaceHolder != null && surfaceHolder.getSurface() != null && this.xj) {
                    this.hf.setDisplay(surfaceHolder);
                }
            } finally {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    @TargetApi(14)
    public void xj(Surface surface) {
        e();
        this.kd = surface;
        this.hf.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    @RequiresApi(api = 23)
    public void xj(com.bykv.vk.openvk.component.video.api.hf hfVar) {
        PlaybackParams playbackParams;
        PlaybackParams speed;
        if (Build.VERSION.SDK_INT >= 23) {
            playbackParams = this.hf.getPlaybackParams();
            speed = playbackParams.setSpeed(hfVar.xj());
            this.hf.setPlaybackParams(speed);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void xj(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(n.z)) {
            this.hf.setDataSource(parse.getPath());
        } else {
            this.hf.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void xj(FileDescriptor fileDescriptor) {
        this.hf.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    @RequiresApi(api = 23)
    public synchronized void xj(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        this.u = com.bykv.vk.openvk.component.video.xj.xj.xj.xj(com.bykv.vk.openvk.component.video.api.w.getContext(), uVar);
        com.bykv.vk.openvk.component.video.xj.xj.hf.w.xj(uVar);
        this.hf.setDataSource(this.u);
    }

    @Override // com.bykv.vk.openvk.component.video.xj.u.w
    public void xj(long j, int i) {
        if (Build.VERSION.SDK_INT < 26) {
            this.hf.seekTo((int) j);
            return;
        }
        if (i == 0) {
            this.hf.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.hf.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.hf.seekTo((int) j, 2);
        } else if (i == 3) {
            this.hf.seekTo((int) j, 3);
        } else {
            this.hf.seekTo((int) j);
        }
    }
}
