package ADYaiT;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Cd8JRx extends ContentFrameLayout {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final /* synthetic */ CkXcdM f137B7CMnp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cd8JRx(CkXcdM ckXcdM, AZOQYO.ADYaiT aDYaiT) {
        super(aDYaiT, null);
        this.f137B7CMnp = ckXcdM;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f137B7CMnp.BChYOn(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                CkXcdM ckXcdM = this.f137B7CMnp;
                ckXcdM.B7CMnp(ckXcdM.BTvldC(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(NOd7IU.AlLFFp.CQhlFr(getContext(), i));
    }
}
