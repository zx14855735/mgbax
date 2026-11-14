package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bykv.vk.component.ttvideo.ILivePlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements AZkASS, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Runnable f7947AlLFFp;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f7949AzWtSf;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final long f7946AcNBzu = SystemClock.uptimeMillis() + ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f7948AmA8tU = false;

    public AaHO0E(ComponentActivity componentActivity) {
        this.f7949AzWtSf = componentActivity;
    }

    @Override // androidx.activity.AZkASS
    public final void A2egSU(View view) {
        if (this.f7948AmA8tU) {
            return;
        }
        this.f7948AmA8tU = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f7947AlLFFp = runnable;
        View decorView = this.f7949AzWtSf.getWindow().getDecorView();
        if (!this.f7948AmA8tU) {
            decorView.postOnAnimation(new CtFAbx.A2egSU(17, this));
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z;
        Runnable runnable = this.f7947AlLFFp;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f7946AcNBzu) {
                this.f7948AmA8tU = false;
                this.f7949AzWtSf.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f7947AlLFFp = null;
        AlLFFp alLFFp = this.f7949AzWtSf.mFullyDrawnReporter;
        synchronized (alLFFp.f7953A2egSU) {
            z = alLFFp.f7954A4TApA;
        }
        if (z) {
            this.f7948AmA8tU = false;
            this.f7949AzWtSf.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7949AzWtSf.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
