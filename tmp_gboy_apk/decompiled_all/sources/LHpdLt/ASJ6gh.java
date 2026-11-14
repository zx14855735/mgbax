package LHpdLt;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh implements View.OnTouchListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public long f4467AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f4468AlLFFp;

    public ASJ6gh(AZOQYO azoqyo) {
        this.f4468AlLFFp = azoqyo;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        AZOQYO azoqyo = this.f4468AlLFFp;
        if (action == 0) {
            AZOQYO.A2egSU(azoqyo);
            azoqyo.BpkvW3 = azoqyo.f4477AYUAbz;
            azoqyo.f4501C2rE4F = azoqyo.f4478AZOQYO;
            azoqyo.f4502C4FrIb = motionEvent.getRawX();
            azoqyo.f4503CASmeH = motionEvent.getRawY();
            this.f4467AcNBzu = System.currentTimeMillis();
            return true;
        }
        if (action == 1) {
            view.performClick();
            azoqyo.AZOQYO();
            if (System.currentTimeMillis() - this.f4467AcNBzu < 200) {
                AZOQYO.A4TApA(azoqyo);
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        float rawX = (motionEvent.getRawX() - azoqyo.f4502C4FrIb) + azoqyo.BpkvW3;
        float rawY = (motionEvent.getRawY() - azoqyo.f4503CASmeH) + azoqyo.f4501C2rE4F;
        azoqyo.f4477AYUAbz = AZOQYO.ASJ6gh(rawX, Math.max(0, azoqyo.f4479AZkASS - azoqyo.f4481AcNBzu));
        azoqyo.f4478AZOQYO = AZOQYO.ASJ6gh(rawY, Math.max(0, azoqyo.f4480AaHO0E - azoqyo.f4482AlLFFp));
        azoqyo.AMqCpz.setX(azoqyo.f4477AYUAbz);
        azoqyo.AMqCpz.setY(azoqyo.f4478AZOQYO);
        return true;
    }
}
