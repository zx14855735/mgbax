package pl.droidsonroids.gif;

import ADYaiT.AZkASS;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.MediaController;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f14075AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public volatile boolean f14076AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public long f14077AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Rect f14078AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Paint f14079B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Bitmap f14080B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final GifInfoHandle f14081B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ConcurrentLinkedQueue f14082B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public ColorStateList f14083B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public PorterDuffColorFilter f14084B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public PorterDuff.Mode f14085BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final boolean f14086BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final AZkASS f14087BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final ADYaiT f14088BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final Rect f14089BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public ScheduledFuture f14090BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final int f14091BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final int f14092BV3sI0;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public A5SV6n(java.lang.String r4) {
        /*
            r3 = this;
            pl.droidsonroids.gif.GifInfoHandle r0 = new pl.droidsonroids.gif.GifInfoHandle
            r0.<init>()
            long r1 = pl.droidsonroids.gif.GifInfoHandle.openFile(r4)
            r0.f14096A2egSU = r1
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.A5SV6n.<init>(java.lang.String):void");
    }

    public final PorterDuffColorFilter A2egSU(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return this.f14081B3GDIM.AYUAbz() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return this.f14081B3GDIM.AYUAbz() > 1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z;
        PorterDuffColorFilter porterDuffColorFilter = this.f14084B9tovu;
        Paint paint = this.f14079B25kr6;
        if (porterDuffColorFilter == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f14084B9tovu);
            z = true;
        }
        canvas.drawBitmap(this.f14080B2KMhB, this.f14089BNL6CD, this.f14078AzWtSf, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f14079B25kr6.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f14079B25kr6.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.f14081B3GDIM.A5SV6n();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.f14081B3GDIM.ADYaiT();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f14092BV3sI0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f14091BTvldC;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return (!this.f14081B3GDIM.AZkASS() || this.f14079B25kr6.getAlpha() < 255) ? -2 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        super.invalidateSelf();
        if (this.f14086BI9f7h && this.f14076AlLFFp) {
            long j = this.f14077AmA8tU;
            if (j != Long.MIN_VALUE) {
                long max = Math.max(0L, j - SystemClock.uptimeMillis());
                this.f14077AmA8tU = Long.MIN_VALUE;
                this.f14075AcNBzu.remove(this.f14088BJ7GGh);
                this.f14090BPw6Q8 = this.f14075AcNBzu.schedule(this.f14088BJ7GGh, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        return this.f14076AlLFFp;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f14076AlLFFp;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f14083B7CMnp;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f14078AzWtSf.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f14083B7CMnp;
        if (colorStateList == null || (mode = this.f14085BChYOn) == null) {
            return false;
        }
        this.f14084B9tovu = A2egSU(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f14075AcNBzu.execute(new A4TApA(this, this, i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f14079B25kr6.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f14079B25kr6.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.f14079B25kr6.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.f14079B25kr6.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f14083B7CMnp = colorStateList;
        this.f14084B9tovu = A2egSU(colorStateList, this.f14085BChYOn);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f14085BChYOn = mode;
        this.f14084B9tovu = A2egSU(this.f14083B7CMnp, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.f14086BI9f7h) {
            if (z) {
                if (z2) {
                    this.f14075AcNBzu.execute(new A2egSU(this, this));
                }
                if (visible) {
                    start();
                    return visible;
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public final void start() {
        synchronized (this) {
            try {
                if (this.f14076AlLFFp) {
                    return;
                }
                this.f14076AlLFFp = true;
                long AlLFFp2 = this.f14081B3GDIM.AlLFFp();
                if (this.f14086BI9f7h) {
                    this.f14077AmA8tU = 0L;
                    this.f14087BIYEnU.sendEmptyMessageAtTime(-1, 0L);
                    return;
                }
                ScheduledFuture scheduledFuture = this.f14090BPw6Q8;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.f14087BIYEnU.removeMessages(-1);
                this.f14090BPw6Q8 = this.f14075AcNBzu.schedule(this.f14088BJ7GGh, Math.max(AlLFFp2, 0L), TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        synchronized (this) {
            try {
                if (this.f14076AlLFFp) {
                    this.f14076AlLFFp = false;
                    ScheduledFuture scheduledFuture = this.f14090BPw6Q8;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f14087BIYEnU.removeMessages(-1);
                    this.f14081B3GDIM.AmA8tU();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        GifInfoHandle gifInfoHandle = this.f14081B3GDIM;
        int AZOQYO2 = gifInfoHandle.AZOQYO();
        int AMqCpz = gifInfoHandle.AMqCpz();
        int AYUAbz2 = gifInfoHandle.AYUAbz();
        int ASJ6gh2 = gifInfoHandle.ASJ6gh();
        StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(AZOQYO2, AMqCpz, "GIF: size: ", "x", ", frames: ");
        B7CMnp2.append(AYUAbz2);
        B7CMnp2.append(", error: ");
        B7CMnp2.append(ASJ6gh2);
        return B7CMnp2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public A5SV6n(byte[] r4) {
        /*
            r3 = this;
            pl.droidsonroids.gif.GifInfoHandle r0 = new pl.droidsonroids.gif.GifInfoHandle
            r0.<init>()
            long r1 = pl.droidsonroids.gif.GifInfoHandle.openByteArray(r4)
            r0.f14096A2egSU = r1
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.A5SV6n.<init>(byte[]):void");
    }

    public A5SV6n(GifInfoHandle gifInfoHandle) {
        this.f14076AlLFFp = true;
        this.f14077AmA8tU = Long.MIN_VALUE;
        this.f14078AzWtSf = new Rect();
        this.f14079B25kr6 = new Paint(6);
        this.f14082B4ZgIw = new ConcurrentLinkedQueue();
        ADYaiT aDYaiT = new ADYaiT(this);
        this.f14088BJ7GGh = aDYaiT;
        this.f14086BI9f7h = true;
        int i = RujA7D.A5SV6n.f7916AcNBzu;
        this.f14075AcNBzu = RujA7D.A4TApA.f7915A2egSU;
        this.f14081B3GDIM = gifInfoHandle;
        Bitmap createBitmap = Bitmap.createBitmap(gifInfoHandle.AZOQYO(), gifInfoHandle.AMqCpz(), Bitmap.Config.ARGB_8888);
        this.f14080B2KMhB = createBitmap;
        createBitmap.setHasAlpha(true ^ gifInfoHandle.AZkASS());
        this.f14089BNL6CD = new Rect(0, 0, gifInfoHandle.AZOQYO(), gifInfoHandle.AMqCpz());
        this.f14087BIYEnU = new AZkASS(this);
        aDYaiT.A2egSU();
        this.f14091BTvldC = gifInfoHandle.AZOQYO();
        this.f14092BV3sI0 = gifInfoHandle.AMqCpz();
    }
}
