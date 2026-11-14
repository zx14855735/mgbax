package com.fl.saas.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CircularCountDownView extends View {
    private int mBgColor;
    private float mCurrentAngle;
    private float mCurrentProgress;
    private int mEndAngle;
    private float mMaxProgress;
    private int mProgressColor;
    private int mProgressbarBgColor;
    private int mRadius;
    private int mStartAngle;
    private int mStrokeWidth;
    private String mText;
    private int mTextColor;
    private float mTextSize;
    private final String skipDes;

    public CircularCountDownView(Context context) {
        this(context, null);
    }

    private void drawCenterBg(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(this.mStrokeWidth);
        paint.setAntiAlias(true);
        paint.setColor(this.mBgColor);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF, this.mStartAngle, this.mEndAngle, false, paint);
    }

    private void drawCenterText(Canvas canvas, int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.mTextColor);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(this.mTextSize);
        Rect rect = new Rect();
        String str = this.mText;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.mText, i, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    private void drawProgress(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.mStrokeWidth);
        paint.setColor(this.mProgressColor);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        float f = (this.mCurrentProgress / this.mMaxProgress) * 360.0f;
        this.mCurrentAngle = f;
        canvas.drawArc(rectF, this.mStartAngle, f, false, paint);
    }

    private void drawProgressbarBg(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.mStrokeWidth);
        paint.setAntiAlias(true);
        paint.setColor(this.mProgressbarBgColor);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF, this.mStartAngle, this.mEndAngle, false, paint);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        RectF rectF = new RectF();
        int i = this.mStrokeWidth;
        float f = i;
        rectF.left = f;
        rectF.top = f;
        float f2 = (width * 2) - i;
        rectF.right = f2;
        rectF.bottom = f2;
        drawCenterBg(canvas, rectF);
        drawProgressbarBg(canvas, rectF);
        drawProgress(canvas, rectF);
        drawCenterText(canvas, width);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = (mode == Integer.MIN_VALUE || mode == 0) ? this.mRadius * 2 : mode != 1073741824 ? 0 : View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, size);
    }

    public void setProgress(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Progress value can not be less than 0");
        }
        float f2 = this.mMaxProgress;
        if (f > f2) {
            f = f2;
        }
        this.mCurrentProgress = f;
        this.mCurrentAngle = (f / f2) * 360.0f;
        invalidate();
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTextColor(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Color value can not be less than 0");
        }
        this.mTextColor = i;
    }

    public void setTextSize(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("textSize can not be less than 0");
        }
        this.mTextSize = f;
    }

    public CircularCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStartAngle = 0;
        this.mCurrentAngle = 0.0f;
        this.mEndAngle = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        String str = TextUtils.equals("zh-CN", DeviceUtil.getSysLanguage()) ? "跳过 " : "Skip ";
        this.skipDes = str;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YdCircularCountDownView);
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YdCircularCountDownView_yd_radius, DeviceUtil.dip2px(20.0f));
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YdCircularCountDownView_yd_strokeWidth, DeviceUtil.dip2px(2.0f));
        this.mBgColor = obtainStyledAttributes.getColor(R.styleable.YdCircularCountDownView_yd_centerBackgroundColor, Color.parseColor("#FFFFFF"));
        this.mProgressbarBgColor = obtainStyledAttributes.getColor(R.styleable.YdCircularCountDownView_yd_progressbarBackgroundColor, Color.parseColor("#F4F4F4"));
        this.mProgressColor = obtainStyledAttributes.getColor(R.styleable.YdCircularCountDownView_yd_progressbarColor, Color.parseColor("#CD853F"));
        this.mMaxProgress = obtainStyledAttributes.getInt(R.styleable.YdCircularCountDownView_yd_maxProgress, 100);
        this.mCurrentProgress = obtainStyledAttributes.getInt(R.styleable.YdCircularCountDownView_yd_progress, 0);
        String string = obtainStyledAttributes.getString(R.styleable.YdCircularCountDownView_yd_text);
        this.mText = string != null ? string : str;
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.YdCircularCountDownView_yd_textColor, Color.parseColor("#696969"));
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YdCircularCountDownView_yd_textSize, (int) TypedValue.applyDimension(2, 10.0f, getResources().getDisplayMetrics()));
        obtainStyledAttributes.recycle();
    }
}
