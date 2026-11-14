package LHpdLt;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B4ZgIw implements View.OnTouchListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public float f4523AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f4524AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f4525AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public float f4526AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public long f4527B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ BTvldC f4528B2KMhB;

    public B4ZgIw(BTvldC bTvldC) {
        this.f4528B2KMhB = bTvldC;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        BTvldC bTvldC = this.f4528B2KMhB;
        if (action == 0) {
            this.f4523AcNBzu = bTvldC.f4565ARc23Z;
            this.f4524AlLFFp = bTvldC.f4566ASJ6gh;
            this.f4525AmA8tU = motionEvent.getRawX();
            this.f4526AzWtSf = motionEvent.getRawY();
            this.f4527B25kr6 = System.currentTimeMillis();
            if (bTvldC.f4563A5SV6n.getWidth() > 0) {
                bTvldC.f4569AZkASS = bTvldC.f4563A5SV6n.getWidth();
                bTvldC.f4570AaHO0E = bTvldC.f4563A5SV6n.getHeight();
            }
            ViewGroup viewGroup = bTvldC.f4562A4TApA;
            if (viewGroup == null || viewGroup.getWidth() <= 0) {
                bTvldC.B2KMhB();
                return true;
            }
            bTvldC.f4567AYUAbz = bTvldC.f4562A4TApA.getWidth();
            bTvldC.f4568AZOQYO = bTvldC.f4562A4TApA.getHeight();
            return true;
        }
        if (action == 1) {
            view.performClick();
            bTvldC.AlLFFp();
            if (System.currentTimeMillis() - this.f4527B25kr6 < 200 && bTvldC.f4583BIYEnU.getVisibility() == 8) {
                bTvldC.f4583BIYEnU.setVisibility(0);
                bTvldC.f4584BJ7GGh.setVisibility(8);
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        float rawX = (motionEvent.getRawX() - this.f4525AmA8tU) + this.f4523AcNBzu;
        float rawY = (motionEvent.getRawY() - this.f4526AzWtSf) + this.f4524AlLFFp;
        float max = Math.max(0, bTvldC.f4567AYUAbz - bTvldC.f4569AZkASS);
        float max2 = Math.max(0, bTvldC.f4568AZOQYO - bTvldC.f4570AaHO0E);
        bTvldC.f4565ARc23Z = BTvldC.A2egSU(bTvldC, rawX, max);
        bTvldC.f4566ASJ6gh = BTvldC.A2egSU(bTvldC, rawY, max2);
        bTvldC.f4563A5SV6n.setX(bTvldC.f4565ARc23Z);
        bTvldC.f4563A5SV6n.setY(bTvldC.f4566ASJ6gh);
        return true;
    }
}
