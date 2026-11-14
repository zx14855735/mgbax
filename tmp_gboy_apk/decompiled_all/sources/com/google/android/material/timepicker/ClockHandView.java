package com.google.android.material.timepicker;

import Oay4Bh.C4FrIb;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class ClockHandView extends View {

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public static final /* synthetic */ int f12008BJ7GGh = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ValueAnimator f12009AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f12010AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ArrayList f12011AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f12012AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final float f12013B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Paint f12014B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final RectF f12015B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f12016B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public float f12017B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f12018B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public double f12019BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f12020BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f12021BIYEnU;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969559);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f12009AcNBzu = valueAnimator;
        this.f12011AmA8tU = new ArrayList();
        Paint paint = new Paint();
        this.f12014B2KMhB = paint;
        this.f12015B3GDIM = new RectF();
        this.f12021BIYEnU = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11222AcNBzu, 2130969559, 2131952922);
        com.bumptech.glide.A5SV6n.D07BeM(context, 2130969617, 200);
        com.bumptech.glide.A5SV6n.D6DOie(context, 2130969633, NdEzCJ.A2egSU.f6037A4TApA);
        this.f12020BI9f7h = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f12012AzWtSf = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f12016B4ZgIw = getResources().getDimensionPixelSize(2131166237);
        this.f12013B25kr6 = r5.getDimensionPixelSize(2131166235);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        A4TApA(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        obtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.ADYaiT
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i = ClockHandView.f12008BJ7GGh;
                ClockHandView.this.A5SV6n(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new AMqCpz());
    }

    public final int A2egSU(int i) {
        return i == 2 ? Math.round(this.f12020BI9f7h * 0.66f) : this.f12020BI9f7h;
    }

    public final void A4TApA(float f) {
        this.f12009AcNBzu.cancel();
        A5SV6n(f);
    }

    public final void A5SV6n(float f) {
        float f2 = f % 360.0f;
        this.f12017B7CMnp = f2;
        this.f12019BChYOn = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float A2egSU2 = A2egSU(this.f12021BIYEnU);
        float cos = (((float) Math.cos(this.f12019BChYOn)) * A2egSU2) + width;
        float sin = (A2egSU2 * ((float) Math.sin(this.f12019BChYOn))) + height;
        float f3 = this.f12012AzWtSf;
        this.f12015B3GDIM.set(cos - f3, sin - f3, cos + f3, sin + f3);
        Iterator it = this.f12011AmA8tU.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((ARc23Z) it.next());
            if (Math.abs(clockFaceView.f12006CqNSpT - f2) > 0.001f) {
                clockFaceView.f12006CqNSpT = f2;
                clockFaceView.AYUAbz();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float A2egSU2 = A2egSU(this.f12021BIYEnU);
        float cos = (((float) Math.cos(this.f12019BChYOn)) * A2egSU2) + f;
        float f2 = height;
        float sin = (A2egSU2 * ((float) Math.sin(this.f12019BChYOn))) + f2;
        Paint paint = this.f12014B2KMhB;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.f12012AzWtSf, paint);
        double sin2 = Math.sin(this.f12019BChYOn);
        paint.setStrokeWidth(this.f12016B4ZgIw);
        canvas.drawLine(f, f2, width + ((int) (Math.cos(this.f12019BChYOn) * r2)), height + ((int) (r2 * sin2)), paint);
        canvas.drawCircle(f, f2, this.f12013B25kr6, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f12009AcNBzu.isRunning()) {
            return;
        }
        A4TApA(this.f12017B7CMnp);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z3 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                z = this.f12018B9tovu;
                if (this.f12010AlLFFp) {
                    this.f12021BIYEnU = ((float) Math.hypot((double) (x - ((float) (getWidth() / 2))), (double) (y - ((float) (getHeight() / 2))))) <= ((float) A2egSU(2)) + C4FrIb.AYUAbz(getContext(), 12) ? 2 : 1;
                }
            } else {
                z = false;
            }
            z2 = false;
        } else {
            this.f12018B9tovu = false;
            z = false;
            z2 = true;
        }
        boolean z4 = this.f12018B9tovu;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME;
        }
        float f = i;
        boolean z5 = this.f12017B7CMnp != f;
        if (!z2 || !z5) {
            if (z5 || z) {
                A4TApA(f);
            }
            this.f12018B9tovu = z4 | z3;
            return true;
        }
        z3 = true;
        this.f12018B9tovu = z4 | z3;
        return true;
    }
}
