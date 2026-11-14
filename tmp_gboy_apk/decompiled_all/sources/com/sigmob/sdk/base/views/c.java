package com.sigmob.sdk.base.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends RelativeLayout implements MediaPlayer.OnBufferingUpdateListener, SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    SurfaceView f13280a;
    private MediaPlayer b;
    private SurfaceHolder c;
    private String d;
    private int e;
    private int f;
    private int g;

    public c(Context context) {
        super(context);
        this.d = "";
        SurfaceView surfaceView = new SurfaceView(context);
        this.f13280a = surfaceView;
        addView(surfaceView, new ViewGroup.LayoutParams(-1, -1));
        SurfaceHolder holder = this.f13280a.getHolder();
        this.c = holder;
        holder.addCallback(this);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.b = mediaPlayer;
        mediaPlayer.setLooping(true);
        this.b.setOnBufferingUpdateListener(this);
    }

    private void g() {
        try {
            this.b.reset();
            this.b.setDataSource(this.d);
            this.b.prepareAsync();
        } catch (IOException e) {
            SigmobLog.e(e.getMessage());
        }
    }

    public void a() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.b.pause();
        this.g = this.b.getCurrentPosition();
        com.sigmob.sdk.videoplayer.c.g(com.sigmob.sdk.b.e());
    }

    public void b() {
        if (this.b == null) {
            return;
        }
        if (r0.getCurrentPosition() == 0) {
            this.b.seekTo(this.g);
        }
        this.b.start();
        com.sigmob.sdk.videoplayer.c.f(com.sigmob.sdk.b.e());
    }

    public void c() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
        this.b.reset();
        this.b.release();
        this.b = null;
    }

    public void d() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        com.sigmob.sdk.videoplayer.c.f(com.sigmob.sdk.b.e());
    }

    public void e() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
    }

    public void f() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.pause();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(0, i);
        int defaultSize2 = View.getDefaultSize(0, i2);
        int i3 = this.f;
        int i4 = this.e;
        if (defaultSize2 > defaultSize) {
            if (i3 <= i4) {
                defaultSize2 = (int) (defaultSize * (i3 / i4));
            }
        } else if (i3 > i4) {
            defaultSize = (int) (defaultSize2 * (i4 / i3));
        }
        int i5 = this.f;
        if (i5 != this.e) {
            setMeasuredDimension(defaultSize, defaultSize2);
        } else if (i5 == -1) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(onPreparedListener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.b.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setVideoPath(String str) {
        this.d = str;
        g();
    }

    public void setVolume(int i) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        float f = i;
        mediaPlayer.setVolume(f, f);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.b.stop();
        this.b.reset();
        this.b.release();
        com.sigmob.sdk.videoplayer.c.g(com.sigmob.sdk.b.e());
        this.b = null;
    }

    public void a(int i) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i);
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public void a(boolean z) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        float f = !z ? 1 : 0;
        mediaPlayer.setVolume(f, f);
    }
}
