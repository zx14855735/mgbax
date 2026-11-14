package N8W1LJ;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.github.chrisbanes.photoview.PhotoView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f5547A2egSU = -1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f5548A4TApA = 0;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ScaleGestureDetector f5549A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public VelocityTracker f5550ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float f5551ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f5552ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f5553AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final float f5554AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final IQ76hF.AmA8tU f5555AZkASS;

    public A4TApA(Context context, IQ76hF.AmA8tU amA8tU) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5554AZOQYO = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5553AYUAbz = viewConfiguration.getScaledTouchSlop();
        this.f5555AZkASS = amA8tU;
        this.f5549A5SV6n = new ScaleGestureDetector(context, new A2egSU(this));
    }

    public final void A2egSU(MotionEvent motionEvent) {
        float x;
        float y;
        float x2;
        float y2;
        RectF rectF;
        int i;
        int i2;
        int i3;
        int i4;
        float x3;
        float y3;
        int i5;
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            IQ76hF.AmA8tU amA8tU = this.f5555AZkASS;
            if (action == 1) {
                this.f5547A2egSU = -1;
                if (this.AMqCpz && this.f5550ADYaiT != null) {
                    try {
                        x2 = motionEvent.getX(this.f5548A4TApA);
                    } catch (Exception unused) {
                        x2 = motionEvent.getX();
                    }
                    this.f5551ARc23Z = x2;
                    try {
                        y2 = motionEvent.getY(this.f5548A4TApA);
                    } catch (Exception unused2) {
                        y2 = motionEvent.getY();
                    }
                    this.f5552ASJ6gh = y2;
                    this.f5550ADYaiT.addMovement(motionEvent);
                    this.f5550ADYaiT.computeCurrentVelocity(1000);
                    float xVelocity = this.f5550ADYaiT.getXVelocity();
                    float yVelocity = this.f5550ADYaiT.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f5554AZOQYO) {
                        AmA8tU amA8tU2 = (AmA8tU) amA8tU.f3956AlLFFp;
                        AlLFFp alLFFp = new AlLFFp(amA8tU2, amA8tU2.f5575B4ZgIw.getContext());
                        amA8tU2.f5586BmvVmW = alLFFp;
                        PhotoView photoView = amA8tU2.f5575B4ZgIw;
                        int width = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
                        int height = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
                        int i6 = (int) (-xVelocity);
                        int i7 = (int) (-yVelocity);
                        amA8tU2.A4TApA();
                        Matrix A5SV6n2 = amA8tU2.A5SV6n();
                        if (amA8tU2.f5575B4ZgIw.getDrawable() != null) {
                            rectF = amA8tU2.f5581BJ7GGh;
                            rectF.set(0.0f, 0.0f, r12.getIntrinsicWidth(), r12.getIntrinsicHeight());
                            A5SV6n2.mapRect(rectF);
                        } else {
                            rectF = null;
                        }
                        if (rectF != null) {
                            int round = Math.round(-rectF.left);
                            float f = width;
                            if (f < rectF.width()) {
                                i = Math.round(rectF.width() - f);
                                i2 = 0;
                            } else {
                                i = round;
                                i2 = i;
                            }
                            int round2 = Math.round(-rectF.top);
                            float f2 = height;
                            if (f2 < rectF.height()) {
                                i3 = Math.round(rectF.height() - f2);
                                i4 = 0;
                            } else {
                                i3 = round2;
                                i4 = i3;
                            }
                            alLFFp.f5565AlLFFp = round;
                            alLFFp.f5566AmA8tU = round2;
                            if (round != i || round2 != i3) {
                                alLFFp.f5564AcNBzu.fling(round, round2, i6, i7, i2, i, i4, i3, 0, 0);
                            }
                        }
                        photoView.post(amA8tU2.f5586BmvVmW);
                    }
                }
                VelocityTracker velocityTracker = this.f5550ADYaiT;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f5550ADYaiT = null;
                }
            } else if (action == 2) {
                try {
                    x3 = motionEvent.getX(this.f5548A4TApA);
                } catch (Exception unused3) {
                    x3 = motionEvent.getX();
                }
                try {
                    y3 = motionEvent.getY(this.f5548A4TApA);
                } catch (Exception unused4) {
                    y3 = motionEvent.getY();
                }
                float f3 = x3 - this.f5551ARc23Z;
                float f4 = y3 - this.f5552ASJ6gh;
                if (!this.AMqCpz) {
                    this.AMqCpz = Math.sqrt((double) ((f4 * f4) + (f3 * f3))) >= ((double) this.f5553AYUAbz);
                }
                if (this.AMqCpz) {
                    AmA8tU amA8tU3 = (AmA8tU) amA8tU.f3956AlLFFp;
                    if (!amA8tU3.f5577B9tovu.f5549A5SV6n.isInProgress()) {
                        amA8tU3.f5580BIYEnU.postTranslate(f3, f4);
                        amA8tU3.A2egSU();
                        ViewParent parent = amA8tU3.f5575B4ZgIw.getParent();
                        if (amA8tU3.f5573B2KMhB && !amA8tU3.f5577B9tovu.f5549A5SV6n.isInProgress() && !amA8tU3.f5574B3GDIM) {
                            int i8 = amA8tU3.f5587BniPrB;
                            if ((i8 == 2 || ((i8 == 0 && f3 >= 1.0f) || ((i8 == 1 && f3 <= -1.0f) || (((i5 = amA8tU3.BpkvW3) == 0 && f4 >= 1.0f) || (i5 == 1 && f4 <= -1.0f))))) && parent != null) {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                        } else if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    this.f5551ARc23Z = x3;
                    this.f5552ASJ6gh = y3;
                    VelocityTracker velocityTracker2 = this.f5550ADYaiT;
                    if (velocityTracker2 != null) {
                        velocityTracker2.addMovement(motionEvent);
                    }
                }
            } else if (action == 3) {
                this.f5547A2egSU = -1;
                VelocityTracker velocityTracker3 = this.f5550ADYaiT;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f5550ADYaiT = null;
                }
            } else if (action == 6) {
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                if (motionEvent.getPointerId(action2) == this.f5547A2egSU) {
                    int i9 = action2 != 0 ? 0 : 1;
                    this.f5547A2egSU = motionEvent.getPointerId(i9);
                    this.f5551ARc23Z = motionEvent.getX(i9);
                    this.f5552ASJ6gh = motionEvent.getY(i9);
                }
            }
        } else {
            this.f5547A2egSU = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f5550ADYaiT = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            try {
                x = motionEvent.getX(this.f5548A4TApA);
            } catch (Exception unused5) {
                x = motionEvent.getX();
            }
            this.f5551ARc23Z = x;
            try {
                y = motionEvent.getY(this.f5548A4TApA);
            } catch (Exception unused6) {
                y = motionEvent.getY();
            }
            this.f5552ASJ6gh = y;
            this.AMqCpz = false;
        }
        int i10 = this.f5547A2egSU;
        this.f5548A4TApA = motionEvent.findPointerIndex(i10 != -1 ? i10 : 0);
    }
}
