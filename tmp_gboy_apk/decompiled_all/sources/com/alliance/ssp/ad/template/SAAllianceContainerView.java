package com.alliance.ssp.ad.template;

import H0qugq.AZOQYO;
import JrXYwF.A4TApA;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SAAllianceContainerView extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AZOQYO f9707AcNBzu;

    public SAAllianceContainerView(Context context, AZOQYO azoqyo) {
        super(context);
        this.f9707AcNBzu = azoqyo;
    }

    private void setupPoint(MotionEvent motionEvent) {
        AZOQYO azoqyo = this.f9707AcNBzu;
        if (azoqyo != null) {
            StringBuilder AMqCpz = A4TApA.AMqCpz("");
            AMqCpz.append((int) motionEvent.getRawX());
            azoqyo.f3212C4FrIb = AMqCpz.toString();
            AZOQYO azoqyo2 = this.f9707AcNBzu;
            StringBuilder AMqCpz2 = A4TApA.AMqCpz("");
            AMqCpz2.append((int) motionEvent.getRawY());
            azoqyo2.f3213CASmeH = AMqCpz2.toString();
            AZOQYO azoqyo3 = this.f9707AcNBzu;
            StringBuilder AMqCpz3 = A4TApA.AMqCpz("");
            AMqCpz3.append((int) motionEvent.getRawX());
            azoqyo3.f3214CNPG0E = AMqCpz3.toString();
            AZOQYO azoqyo4 = this.f9707AcNBzu;
            StringBuilder AMqCpz4 = A4TApA.AMqCpz("");
            AMqCpz4.append((int) motionEvent.getRawY());
            azoqyo4.f3215COJEAR = AMqCpz4.toString();
            AZOQYO azoqyo5 = this.f9707AcNBzu;
            StringBuilder AMqCpz5 = A4TApA.AMqCpz("");
            AMqCpz5.append((int) motionEvent.getX());
            azoqyo5.f3217CSDoyG = AMqCpz5.toString();
            AZOQYO azoqyo6 = this.f9707AcNBzu;
            StringBuilder AMqCpz6 = A4TApA.AMqCpz("");
            AMqCpz6.append((int) motionEvent.getY());
            azoqyo6.f3218CTkVKb = AMqCpz6.toString();
            AZOQYO azoqyo7 = this.f9707AcNBzu;
            StringBuilder AMqCpz7 = A4TApA.AMqCpz("");
            AMqCpz7.append((int) motionEvent.getX());
            azoqyo7.f3219CcAIMM = AMqCpz7.toString();
            AZOQYO azoqyo8 = this.f9707AcNBzu;
            StringBuilder AMqCpz8 = A4TApA.AMqCpz("");
            AMqCpz8.append((int) motionEvent.getY());
            azoqyo8.f3220Cd8JRx = AMqCpz8.toString();
            long currentTimeMillis = System.currentTimeMillis();
            this.f9707AcNBzu.BpkvW3 = String.valueOf(currentTimeMillis);
            this.f9707AcNBzu.f3227CtxOCS = String.valueOf((int) (currentTimeMillis / 1000));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AZOQYO azoqyo;
        int action = motionEvent.getAction();
        if (action == 0) {
            setupPoint(motionEvent);
        } else if (action == 1 && (azoqyo = this.f9707AcNBzu) != null) {
            StringBuilder AMqCpz = A4TApA.AMqCpz("");
            AMqCpz.append((int) motionEvent.getRawX());
            azoqyo.f3214CNPG0E = AMqCpz.toString();
            AZOQYO azoqyo2 = this.f9707AcNBzu;
            StringBuilder AMqCpz2 = A4TApA.AMqCpz("");
            AMqCpz2.append((int) motionEvent.getRawY());
            azoqyo2.f3215COJEAR = AMqCpz2.toString();
            AZOQYO azoqyo3 = this.f9707AcNBzu;
            StringBuilder AMqCpz3 = A4TApA.AMqCpz("");
            AMqCpz3.append((int) motionEvent.getX());
            azoqyo3.f3219CcAIMM = AMqCpz3.toString();
            AZOQYO azoqyo4 = this.f9707AcNBzu;
            StringBuilder AMqCpz4 = A4TApA.AMqCpz("");
            AMqCpz4.append((int) motionEvent.getY());
            azoqyo4.f3220Cd8JRx = AMqCpz4.toString();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setImpl(AZOQYO azoqyo) {
        this.f9707AcNBzu = azoqyo;
    }

    public SAAllianceContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9707AcNBzu = null;
    }
}
