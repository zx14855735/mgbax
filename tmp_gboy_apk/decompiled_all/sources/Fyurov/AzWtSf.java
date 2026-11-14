package Fyurov;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements View.OnTouchListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ boolean f2953AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ B2KMhB f2954AlLFFp;

    public AzWtSf(B2KMhB b2KMhB, boolean z) {
        this.f2954AlLFFp = b2KMhB;
        this.f2953AcNBzu = z;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        B2KMhB b2KMhB = this.f2954AlLFFp;
        if (action == 0) {
            b2KMhB.f2969AaHO0E = motionEvent.getX();
            b2KMhB.f2970AcNBzu = motionEvent.getY();
            return false;
        }
        if (action != 1) {
            return false;
        }
        float f = b2KMhB.f2969AaHO0E;
        float f2 = b2KMhB.f2970AcNBzu;
        float x = motionEvent.getX() - f;
        float y = motionEvent.getY() - f2;
        float abs = Math.abs((float) Math.sqrt((y * y) + (x * x)));
        motionEvent.getX();
        motionEvent.getY();
        if (abs != 0.0f || !this.f2953AcNBzu) {
            if (b2KMhB.f2961A4TApA != 1) {
                if (abs <= b2KMhB.A2egSU(b2KMhB.AMqCpz)) {
                    return false;
                }
                b2KMhB.f2964ARc23Z.A2egSU(b2KMhB.f2965ASJ6gh, b2KMhB.f2969AaHO0E, b2KMhB.f2970AcNBzu, motionEvent.getX(), motionEvent.getY());
                return true;
            }
            float y2 = motionEvent.getY() - b2KMhB.f2970AcNBzu;
            float x2 = motionEvent.getX() - b2KMhB.f2969AaHO0E;
            if (y2 >= 0.0f) {
                return false;
            }
            double degrees = Math.toDegrees(Math.atan2(Math.abs(x2), Math.abs(y2)));
            if (abs <= b2KMhB.A2egSU(b2KMhB.AMqCpz) || degrees > b2KMhB.f2963ADYaiT) {
                return false;
            }
            b2KMhB.f2964ARc23Z.A2egSU(b2KMhB.f2965ASJ6gh, b2KMhB.f2969AaHO0E, b2KMhB.f2970AcNBzu, motionEvent.getX(), motionEvent.getY());
            return true;
        }
        FdMWEC.AYUAbz aYUAbz = b2KMhB.f2964ARc23Z;
        FrameLayout frameLayout = b2KMhB.f2965ASJ6gh;
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        FdMWEC.AZkASS aZkASS = aYUAbz.f2804A2egSU;
        if (aZkASS.f2865IQ76hF != 5) {
            return true;
        }
        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
        int i = (int) x3;
        AMqCpz.append(i);
        aZkASS.f3217CSDoyG = AMqCpz.toString();
        StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
        int i2 = (int) y3;
        AMqCpz2.append(i2);
        aZkASS.f3218CTkVKb = AMqCpz2.toString();
        aZkASS.f3219CcAIMM = NOd7IU.AlLFFp.ASJ6gh(i, "");
        aZkASS.f3220Cd8JRx = NOd7IU.AlLFFp.ASJ6gh(i2, "");
        Point AaHO0E2 = H0qugq.AZOQYO.AaHO0E(frameLayout, x3, y3);
        StringBuilder AMqCpz3 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz3.append(AaHO0E2.x);
        aZkASS.f3212C4FrIb = AMqCpz3.toString();
        StringBuilder AMqCpz4 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz4.append(AaHO0E2.y);
        aZkASS.f3213CASmeH = AMqCpz4.toString();
        StringBuilder AMqCpz5 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz5.append(AaHO0E2.x);
        aZkASS.f3214CNPG0E = AMqCpz5.toString();
        StringBuilder AMqCpz6 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz6.append(AaHO0E2.y);
        aZkASS.f3215COJEAR = AMqCpz6.toString();
        aZkASS.EH1KK8("user", 1);
        return true;
    }
}
