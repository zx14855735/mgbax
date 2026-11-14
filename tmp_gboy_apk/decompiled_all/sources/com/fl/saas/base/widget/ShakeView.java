package com.fl.saas.base.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.ShakeControlUtil;
import com.fl.saas.s2s.R;
import com.sigmob.sdk.base.common.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ShakeView extends FrameLayout implements SensorEventListener {
    private static final int SHAKE_DEFAULT_THRESHOLD = 400;
    private final float[] accelerometerReading;
    private Sensor accelerometerSensor;
    private Runnable checkValidAreaRunnable;
    private boolean isCallback;
    private boolean isVisibility;
    private long lastUpdate;
    private float last_x;
    private float last_y;
    private float last_z;
    private Animator mAnimator;
    private ImageView mImageView;
    private ShakeListener mShakeListener;
    private Sensor magneticSensor;
    private final float[] magnetometerReading;
    private final float[] orientationAngles;
    private final float[] rotationMatrix;
    private SensorManager sensorManager;
    private int shakeThreshold;
    private long startTime;
    private double startXAngle;
    private double startYAngle;
    private double startZAngle;

    public interface ShakeListener {
        void onShake(int i, int i2, int i3);
    }

    public ShakeView(Context context) {
        super(context);
        this.shakeThreshold = 400;
        this.isVisibility = false;
        this.isCallback = false;
        this.lastUpdate = 0L;
        this.accelerometerReading = new float[3];
        this.magnetometerReading = new float[3];
        this.rotationMatrix = new float[9];
        this.orientationAngles = new float[3];
    }

    private void cancelAnimator() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkValidArea() {
        if (isShow()) {
            registerAccelerometer(true);
            return;
        }
        if (this.checkValidAreaRunnable == null) {
            this.checkValidAreaRunnable = new A2egSU(this, 1);
        }
        DeviceUtil.postUIDelayed(200L, this.checkValidAreaRunnable);
    }

    private Animator createAnimatorSet(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        float measuredHeight = view.getMeasuredHeight();
        float measuredWidth = view.getMeasuredWidth();
        if (measuredHeight == 0.0f && measuredWidth == 0.0f) {
            float dip2px = DeviceUtil.dip2px(24.0f);
            measuredWidth = DeviceUtil.dip2px(24.0f);
            measuredHeight = dip2px;
        }
        Interpolator A4TApA2 = CSDoyG.A2egSU.A4TApA(0.33f, 0.0f, 0.36f, 1.0f);
        view.setPivotX(measuredHeight / 2.0f);
        view.setPivotY(measuredWidth / 2.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, a.B, 0.0f, f);
        ofFloat.setDuration(j);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, a.B, f, -f);
        ofFloat2.setDuration(2 * j);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setInterpolator(A4TApA2);
        ofFloat2.setRepeatCount(3);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, a.B, f, 0.0f);
        ofFloat3.setDuration(j);
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setStartDelay(400L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.base.widget.ShakeView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (ShakeView.this.mImageView != null) {
                    ShakeView.this.mImageView.setRotation(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ShakeView.this.isVisibility) {
                    animator.start();
                }
            }
        });
        return animatorSet;
    }

    private void createImageView() {
        ImageView imageView = new ImageView(getContext());
        this.mImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mImageView.setAdjustViewBounds(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(this.mImageView, layoutParams);
        this.mImageView.setImageResource(R.drawable.yd_saas_icon_shake_hand);
    }

    private boolean isShow() {
        return getGlobalVisibleRect(new Rect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimator() {
        if (this.mAnimator == null) {
            this.mAnimator = createAnimatorSet(this.mImageView, 100L, 16.0f);
        }
        if (this.mAnimator.isRunning()) {
            return;
        }
        this.mAnimator.start();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimator();
        this.mAnimator = null;
        unRegisterAccelerometer(true);
        this.sensorManager = null;
        this.accelerometerSensor = null;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.isCallback) {
            return;
        }
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() != 1) {
            if (sensor.getType() == 2) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = this.magnetometerReading;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
                return;
            }
            return;
        }
        try {
            if (this.shakeThreshold >= 0) {
                float[] fArr3 = sensorEvent.values;
                float f = fArr3[0];
                float f2 = fArr3[1];
                float f3 = fArr3[2];
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis - this.lastUpdate;
                if (j > 100) {
                    this.lastUpdate = currentTimeMillis;
                    float f4 = this.last_x;
                    if (f4 == 0.0f && this.last_y == 0.0f && this.last_z == 0.0f) {
                        this.last_x = f;
                        this.last_y = f2;
                        this.last_z = f3;
                        return;
                    }
                    float f5 = f - f4;
                    float f6 = f2 - this.last_y;
                    float f7 = f3 - this.last_z;
                    boolean z = (Math.sqrt((double) ((f7 * f7) + ((f6 * f6) + (f5 * f5)))) / ((double) j)) * 10000.0d >= ((double) this.shakeThreshold);
                    this.last_x = f;
                    this.last_y = f2;
                    this.last_z = f3;
                    if (z && isShow()) {
                        this.isCallback = true;
                        ShakeListener shakeListener = this.mShakeListener;
                        if (shakeListener != null) {
                            shakeListener.onShake(Math.round(f * 100.0f), Math.round(f2 * 100.0f), Math.round(f3 * 100.0f));
                        }
                        ((Vibrator) getContext().getSystemService("vibrator")).vibrate(500L);
                        return;
                    }
                    return;
                }
                return;
            }
            float[] fArr4 = sensorEvent.values;
            float[] fArr5 = this.accelerometerReading;
            System.arraycopy(fArr4, 0, fArr5, 0, fArr5.length);
            SensorManager.getRotationMatrix(this.rotationMatrix, null, this.accelerometerReading, this.magnetometerReading);
            SensorManager.getOrientation(this.rotationMatrix, this.orientationAngles);
            float[] fArr6 = this.orientationAngles;
            double d = (fArr6[0] * 180.0f) / 3.141592653589793d;
            double d2 = (fArr6[1] * 180.0f) / 3.141592653589793d;
            double d3 = (fArr6[2] * 180.0f) / 3.141592653589793d;
            if (this.startXAngle == 0.0d) {
                this.startXAngle = d2;
                this.startYAngle = d3;
                this.startZAngle = d;
                return;
            }
            float[] fArr7 = sensorEvent.values;
            float f8 = fArr7[0];
            float f9 = fArr7[1];
            float f10 = fArr7[2];
            long currentTimeMillis2 = System.currentTimeMillis();
            long j2 = currentTimeMillis2 - this.lastUpdate;
            if (j2 > 100) {
                boolean z2 = Math.abs(d2 - this.startXAngle) > 35.0d || Math.abs(d3 - this.startYAngle) > 35.0d || Math.abs(d - this.startZAngle) > 35.0d;
                if (z2 && this.startTime == 0) {
                    this.startTime = currentTimeMillis2;
                }
                this.lastUpdate = currentTimeMillis2;
                float f11 = this.last_x;
                if (f11 == 0.0f && this.last_y == 0.0f && this.last_z == 0.0f) {
                    this.last_x = f8;
                    this.last_y = f9;
                    this.last_z = f10;
                    return;
                }
                float f12 = f8 - f11;
                float f13 = f9 - this.last_y;
                float f14 = f10 - this.last_z;
                boolean z3 = (Math.sqrt((double) ((f14 * f14) + ((f13 * f13) + (f12 * f12)))) / ((double) j2)) * 10000.0d >= 600.0d;
                if (z3 && this.startTime == 0) {
                    this.startTime = currentTimeMillis2;
                }
                this.last_x = f8;
                this.last_y = f9;
                this.last_z = f10;
                if (z3 && z2 && currentTimeMillis2 - this.startTime > 3000 && isShow()) {
                    this.isCallback = true;
                    ShakeListener shakeListener2 = this.mShakeListener;
                    if (shakeListener2 != null) {
                        shakeListener2.onShake(Math.round(f8 * 100.0f), Math.round(f9 * 100.0f), Math.round(f10 * 100.0f));
                    }
                    ((Vibrator) getContext().getSystemService("vibrator")).vibrate(500L);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisibility = i == 0;
        if (i != 0) {
            cancelAnimator();
            unRegisterAccelerometer(true);
            return;
        }
        this.mImageView.post(new A2egSU(this, 0));
        if (isShow()) {
            registerAccelerometer(true);
        } else {
            checkValidArea();
        }
    }

    public void registerAccelerometer(boolean z) {
        try {
            if (!this.isCallback && DeviceUtil.isCanUseSensor) {
                if (z) {
                    ShakeControlUtil.getInstance().addView(this);
                }
                if (this.sensorManager == null) {
                    this.sensorManager = (SensorManager) getContext().getSystemService("sensor");
                }
                if (this.accelerometerSensor == null) {
                    this.accelerometerSensor = this.sensorManager.getDefaultSensor(1);
                }
                this.sensorManager.registerListener(this, this.accelerometerSensor, 3);
                if (this.magneticSensor == null) {
                    this.magneticSensor = this.sensorManager.getDefaultSensor(2);
                }
                this.sensorManager.registerListener(this, this.magneticSensor, 3, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCallback(boolean z) {
        this.isCallback = z;
    }

    public void setShakeListener(int i, ShakeListener shakeListener) {
        this.shakeThreshold = (i < 0 || i > 100) ? -1 : i < 50 ? i * 5 : i <= 70 ? i * 8 : i * 15;
        this.mShakeListener = shakeListener;
    }

    public void unRegisterAccelerometer(boolean z) {
        if (z) {
            try {
                ShakeControlUtil.getInstance().removeView(this);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.startTime = 0L;
        this.startXAngle = 0.0d;
        this.startYAngle = 0.0d;
        this.startZAngle = 0.0d;
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            Sensor sensor = this.accelerometerSensor;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.magneticSensor;
            if (sensor2 != null) {
                this.sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shakeThreshold = 400;
        this.isVisibility = false;
        this.isCallback = false;
        this.lastUpdate = 0L;
        this.accelerometerReading = new float[3];
        this.magnetometerReading = new float[3];
        this.rotationMatrix = new float[9];
        this.orientationAngles = new float[3];
        createImageView();
    }
}
