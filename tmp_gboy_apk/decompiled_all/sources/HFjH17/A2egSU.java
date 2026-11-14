package HFjH17;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements SurfaceHolder.Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ADYaiT f3285AcNBzu;

    public A2egSU(ADYaiT aDYaiT) {
        this.f3285AcNBzu = aDYaiT;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.f3285AcNBzu.f3305B4ZgIw;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.f3285AcNBzu.f3305B4ZgIw;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(null);
        }
    }
}
