package AaHO0E;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EiK8oA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f783AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ EicXu4 f784AlLFFp;

    public /* synthetic */ EiK8oA(EicXu4 eicXu4, int i) {
        this.f783AcNBzu = i;
        this.f784AlLFFp = eicXu4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f783AcNBzu) {
            case 0:
                ViewParent parent = this.f784AlLFFp.f788AzWtSf.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                EicXu4 eicXu4 = this.f784AlLFFp;
                eicXu4.A2egSU();
                View view = eicXu4.f788AzWtSf;
                if (view.isEnabled() && !view.isLongClickable() && eicXu4.A5SV6n()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    eicXu4.f791B3GDIM = true;
                    break;
                }
                break;
        }
    }
}
