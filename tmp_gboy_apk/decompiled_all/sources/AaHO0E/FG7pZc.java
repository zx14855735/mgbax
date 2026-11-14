package AaHO0E;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class FG7pZc implements View.OnTouchListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f816AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f817AlLFFp;

    public /* synthetic */ FG7pZc(int i, Object obj) {
        this.f816AcNBzu = i;
        this.f817AlLFFp = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        BpkvW3 bpkvW3;
        switch (this.f816AcNBzu) {
            case 0:
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                FM663C fm663c = (FM663C) this.f817AlLFFp;
                if (action == 0 && (bpkvW3 = fm663c.f845COJEAR) != null && bpkvW3.isShowing() && x >= 0 && x < fm663c.f845COJEAR.getWidth() && y >= 0 && y < fm663c.f845COJEAR.getHeight()) {
                    fm663c.f841C2rE4F.postDelayed(fm663c.f838BV3sI0, 250L);
                    break;
                } else if (action == 1) {
                    fm663c.f841C2rE4F.removeCallbacks(fm663c.f838BV3sI0);
                    break;
                }
                break;
            case 1:
                int action2 = motionEvent.getAction();
                LHpdLt.AZOQYO azoqyo = (LHpdLt.AZOQYO) this.f817AlLFFp;
                if (action2 == 0) {
                    LHpdLt.AZOQYO.A2egSU(azoqyo);
                    azoqyo.BpkvW3 = azoqyo.f4477AYUAbz;
                    azoqyo.f4501C2rE4F = azoqyo.f4478AZOQYO;
                    azoqyo.f4502C4FrIb = motionEvent.getRawX();
                    azoqyo.f4503CASmeH = motionEvent.getRawY();
                    break;
                } else if (action2 == 1) {
                    view.performClick();
                    azoqyo.AZOQYO();
                    break;
                } else if (action2 == 2) {
                    float rawX = (motionEvent.getRawX() - azoqyo.f4502C4FrIb) + azoqyo.BpkvW3;
                    float rawY = (motionEvent.getRawY() - azoqyo.f4503CASmeH) + azoqyo.f4501C2rE4F;
                    azoqyo.f4477AYUAbz = LHpdLt.AZOQYO.ASJ6gh(rawX, Math.max(0, azoqyo.f4479AZkASS - azoqyo.f4481AcNBzu));
                    azoqyo.f4478AZOQYO = LHpdLt.AZOQYO.ASJ6gh(rawY, Math.max(0, azoqyo.f4480AaHO0E - azoqyo.f4482AlLFFp));
                    azoqyo.AMqCpz.setX(azoqyo.f4477AYUAbz);
                    azoqyo.AMqCpz.setY(azoqyo.f4478AZOQYO);
                    break;
                }
                break;
            default:
                ((GestureDetector) this.f817AlLFFp).onTouchEvent(motionEvent);
                break;
        }
        return true;
    }
}
