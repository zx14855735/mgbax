package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import B4ZgIw.AYUAbz;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CycleCountDownView extends View {

    /* renamed from: a, reason: collision with root package name */
    private String f10429a;
    private final RectF ai;
    private Paint am;
    private String b;
    protected boolean c;
    protected float d;
    private Bitmap dk;
    private AnimatorSet e;
    private final Rect en;
    private Bitmap et;
    protected float f;
    private float ff;
    private Paint g;
    protected int hf;
    private boolean ht;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10430io;
    private final Rect j;
    private ValueAnimator jk;
    protected float kd;
    private final Rect l;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private Paint f10431pl;
    private boolean pz;
    private final Rect q;
    private Paint qt;
    private String r;
    private Bitmap ra;
    protected int tf;
    protected float u;
    private ValueAnimator v;
    protected int w;
    private String wo;
    private boolean x;
    protected int xj;
    protected int y;
    private ValueAnimator yo;
    private final Rect z;
    private float zg;

    public CycleCountDownView(Context context) {
        super(context);
        this.xj = Color.parseColor("#FFDA7B");
        this.hf = Color.parseColor("#4D000000");
        this.w = Color.parseColor("#ffffff");
        this.y = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.c = false;
        this.f = 5.0f;
        this.d = 0.0f;
        this.tf = 0;
        this.p = false;
        this.zg = 0.0f;
        this.pz = false;
        this.ht = false;
        this.f10430io = false;
        this.x = false;
        this.ai = new RectF();
        this.q = new Rect();
        this.z = new Rect();
        this.j = new Rect();
        this.en = new Rect();
        this.l = new Rect();
        this.ff = 1.0f;
        this.u = xj(4.0f);
        this.kd = xj(34.0f);
        this.y %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        hf();
        w();
        setBackgroundColor(-16711681);
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.v;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.v = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.zg, this.ff);
        this.v = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.v.setDuration(1000L);
        this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleCountDownView.this.zg = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleCountDownView.this.postInvalidate();
            }
        });
        return this.v;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    private int u() {
        return (int) ((((this.u / 2.0f) + this.kd) * 2.0f) + xj(4.0f));
    }

    private void w() {
        this.ra = jk.u(getContext(), "tt_reward_chest_gift2");
        this.dk = jk.u(getContext(), "tt_reward_chest_gift_open2");
        this.et = xj(getContext(), "tt_reward_chest_btn_bg");
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.e;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.e = null;
            }
            ValueAnimator valueAnimator = this.jk;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.jk = null;
            }
            ValueAnimator valueAnimator2 = this.yo;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.yo = null;
            }
            ValueAnimator valueAnimator3 = this.v;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.v = null;
            }
            this.zg = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        xj(canvas);
        w(canvas);
        hf(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = u();
        }
        if (mode2 != 1073741824) {
            size2 = u();
        }
        xj(size, size2);
        setMeasuredDimension(size, size2);
        RectF rectF = this.ai;
        float f = this.kd;
        rectF.left = -f;
        rectF.right = f;
        rectF.top = -f;
        rectF.bottom = f;
        Rect rect = this.q;
        rect.left = 0;
        rect.top = 0;
        Bitmap bitmap = this.ra;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.q;
        Bitmap bitmap2 = this.ra;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
        Rect rect3 = this.z;
        rect3.left = 0;
        rect3.top = 0;
        Bitmap bitmap3 = this.dk;
        rect3.right = bitmap3 != null ? bitmap3.getWidth() : 0;
        Rect rect4 = this.z;
        Bitmap bitmap4 = this.dk;
        rect4.bottom = bitmap4 != null ? bitmap4.getHeight() : 0;
        int minLine = getMinLine();
        Rect rect5 = this.j;
        int i3 = -minLine;
        int i4 = i3 / 2;
        rect5.left = i4;
        rect5.top = i4;
        int i5 = minLine / 2;
        rect5.right = i5;
        rect5.bottom = i5;
        Rect rect6 = this.en;
        rect6.left = 0;
        rect6.top = 0;
        rect6.right = this.et.getWidth();
        this.en.bottom = this.et.getHeight();
        Rect rect7 = this.l;
        rect7.left = i3 / 3;
        rect7.top = minLine / 8;
        int i6 = minLine / 3;
        rect7.right = i6;
        rect7.bottom = i6;
        this.am.setTextSize(((i6 - r0) / 2) - hf(2.0f));
    }

    public void setBoxFinish(Bitmap bitmap) {
        this.dk = bitmap;
        this.x = true;
        Rect rect = this.z;
        rect.left = 0;
        rect.top = 0;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.z;
        Bitmap bitmap2 = this.dk;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
    }

    public void setBoxImage(Bitmap bitmap) {
        this.ra = bitmap;
        this.f10430io = true;
        Rect rect = this.q;
        rect.left = 0;
        rect.top = 0;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.q;
        Bitmap bitmap2 = this.ra;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
    }

    public void setCanSkip(boolean z) {
        this.p = z;
    }

    private void hf() {
        Paint paint = new Paint(1);
        this.f10431pl = paint;
        paint.setColor(this.xj);
        this.f10431pl.setStrokeWidth(this.u);
        this.f10431pl.setAntiAlias(true);
        this.f10431pl.setStrokeCap(Paint.Cap.ROUND);
        this.f10431pl.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.g = paint2;
        paint2.setColor(this.hf);
        this.g.setAntiAlias(true);
        this.g.setStrokeWidth(this.u);
        this.g.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.am = paint3;
        paint3.setColor(this.w);
        this.am.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(1);
        this.qt = paint4;
        paint4.setFilterBitmap(true);
        this.qt.setDither(true);
    }

    private void w(Canvas canvas) {
        float f;
        canvas.save();
        float f2 = this.zg * 360.0f;
        if (this.c) {
            f = this.y - f2;
        } else {
            f = this.y;
        }
        float f3 = f;
        canvas.drawCircle(0.0f, 0.0f, this.kd, this.g);
        canvas.drawArc(this.ai, f3, f2, false, this.f10431pl);
        canvas.restore();
    }

    private void xj(int i, int i2) {
        this.kd = (Math.min(i, i2) / 2.0f) - this.u;
    }

    private void xj(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        boolean z = false;
        if (this.tf <= 0 && (bitmap = this.dk) != null) {
            boolean z2 = this.f10430io;
            if (!(z2 && this.x) && (z2 || this.x)) {
                bitmap = this.ra;
            } else {
                z = true;
            }
        } else {
            bitmap = this.ra;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, z ? this.z : this.q, this.j, this.qt);
        }
        canvas.restore();
    }

    private float xj(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void xj() {
        AnimatorSet animatorSet = this.e;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.e.cancel();
            this.e = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.e = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.e.setInterpolator(new LinearInterpolator());
        this.e.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleCountDownView.this.pz = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleCountDownView.this.pz) {
                    CycleCountDownView.this.pz = false;
                } else {
                    CycleCountDownView.this.ht = true;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.e.start();
    }

    private void hf(Canvas canvas) {
        String str;
        canvas.save();
        canvas.drawBitmap(this.et, this.en, this.l, this.qt);
        Paint.FontMetrics fontMetrics = this.am.getFontMetrics();
        float f = (fontMetrics.bottom - fontMetrics.top) / 2.0f;
        if (TextUtils.isEmpty(this.b)) {
            str = this.f10429a + this.tf + this.wo;
        } else if (this.tf <= 0) {
            str = this.b;
        } else {
            str = this.f10429a + this.tf + this.wo;
        }
        if (this.p) {
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, "｜");
            A5SV6n2.append(this.r);
            str = A5SV6n2.toString();
        }
        canvas.drawText(str, 0.0f, (f / 2.0f) + ((getMinLine() / 3.0f) - (getMinLine() / 9.0f)), this.am);
        canvas.restore();
    }

    public void xj(int i, int i2, int i3) {
        float f = i;
        this.f = f;
        float f2 = i2;
        this.d = f2;
        this.tf = i3;
        this.ff = f2 / f;
        xj();
    }

    private Bitmap xj(Context context, String str) {
        Drawable w = jk.w(context, str);
        Bitmap createBitmap = Bitmap.createBitmap(w.getIntrinsicWidth(), w.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        w.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        w.draw(canvas);
        return createBitmap;
    }

    public void xj(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f10429a = str;
        this.wo = TextUtils.isEmpty(str2) ? "" : str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "跳过";
        }
        this.r = str3;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        this.b = str4;
    }

    private float hf(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }
}
