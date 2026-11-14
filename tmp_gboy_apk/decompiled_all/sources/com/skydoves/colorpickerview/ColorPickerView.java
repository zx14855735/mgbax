package com.skydoves.colorpickerview;

import AZkASS.A5SV6n;
import BPw6Q8.ASJ6gh;
import NOd7IU.AlLFFp;
import QJCbnW.A2egSU;
import QJCbnW.ADYaiT;
import QTPNDK.A4TApA;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.B7CMnp;
import androidx.lifecycle.B9tovu;
import androidx.lifecycle.BmvVmW;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ColorPickerView extends FrameLayout implements B7CMnp {
    public static final /* synthetic */ int BpkvW3 = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f13797AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f13798AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Point f13799AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ImageView f13800AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ImageView f13801B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Drawable f13802B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Drawable f13803B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public AlphaSlideBar f13804B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public BrightnessSlideBar f13805B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public A4TApA f13806B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public long f13807BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final Handler f13808BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public A2egSU f13809BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public float f13810BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final float f13811BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final boolean f13812BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final int f13813BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f13814BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public String f13815BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final K7mCWO.A4TApA f13816BniPrB;

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        this.f13807BChYOn = 0L;
        this.f13808BI9f7h = new Handler();
        A2egSU a2egSU = A2egSU.f7465AcNBzu;
        this.f13809BIYEnU = a2egSU;
        this.f13810BJ7GGh = 1.0f;
        this.f13811BNL6CD = 1.0f;
        this.f13812BPw6Q8 = true;
        this.f13813BTvldC = 0;
        this.f13814BV3sI0 = false;
        this.f13816BniPrB = K7mCWO.A4TApA.A2egSU(getContext());
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f13819A5SV6n);
        try {
            if (obtainStyledAttributes.hasValue(5)) {
                this.f13802B2KMhB = obtainStyledAttributes.getDrawable(5);
            }
            if (obtainStyledAttributes.hasValue(7) && (resourceId = obtainStyledAttributes.getResourceId(7, -1)) != -1) {
                this.f13803B3GDIM = AlLFFp.CQhlFr(getContext(), resourceId);
            }
            if (obtainStyledAttributes.hasValue(8)) {
                this.f13810BJ7GGh = obtainStyledAttributes.getFloat(8, this.f13810BJ7GGh);
            }
            if (obtainStyledAttributes.hasValue(9)) {
                this.f13813BTvldC = obtainStyledAttributes.getDimensionPixelSize(9, this.f13813BTvldC);
            }
            if (obtainStyledAttributes.hasValue(2)) {
                this.f13811BNL6CD = obtainStyledAttributes.getFloat(2, this.f13811BNL6CD);
            }
            if (obtainStyledAttributes.hasValue(3)) {
                this.f13812BPw6Q8 = obtainStyledAttributes.getBoolean(3, this.f13812BPw6Q8);
            }
            if (obtainStyledAttributes.hasValue(0)) {
                int integer = obtainStyledAttributes.getInteger(0, 0);
                if (integer == 0) {
                    this.f13809BIYEnU = a2egSU;
                } else if (integer == 1) {
                    this.f13809BIYEnU = A2egSU.f7466AlLFFp;
                }
            }
            if (obtainStyledAttributes.hasValue(1)) {
                this.f13807BChYOn = obtainStyledAttributes.getInteger(1, (int) this.f13807BChYOn);
            }
            if (obtainStyledAttributes.hasValue(6)) {
                this.f13815BmvVmW = obtainStyledAttributes.getString(6);
            }
            if (obtainStyledAttributes.hasValue(4)) {
                setInitialColor(obtainStyledAttributes.getColor(4, -1));
            }
            obtainStyledAttributes.recycle();
            setPadding(0, 0, 0, 0);
            ImageView imageView = new ImageView(getContext());
            this.f13800AzWtSf = imageView;
            Drawable drawable = this.f13802B2KMhB;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(this.f13800AzWtSf, layoutParams);
            ImageView imageView2 = new ImageView(getContext());
            this.f13801B25kr6 = imageView2;
            Drawable drawable2 = this.f13803B3GDIM;
            if (drawable2 != null) {
                imageView2.setImageDrawable(drawable2);
            } else {
                imageView2.setImageDrawable(BPw6Q8.A2egSU.A4TApA(getContext(), 2131230880));
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            if (this.f13813BTvldC != 0) {
                layoutParams2.width = (int) ((this.f13813BTvldC * getContext().getResources().getDisplayMetrics().density) + 0.5f);
                layoutParams2.height = (int) ((this.f13813BTvldC * getContext().getResources().getDisplayMetrics().density) + 0.5f);
            }
            layoutParams2.gravity = 17;
            addView(this.f13801B25kr6, layoutParams2);
            this.f13801B25kr6.setAlpha(this.f13810BJ7GGh);
            getViewTreeObserver().addOnGlobalLayoutListener(new A5SV6n(5, this));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void A2egSU(int i, boolean z) {
        this.f13798AlLFFp = i;
        if (getAlphaSlideBar() != null) {
            getAlphaSlideBar().ADYaiT();
            this.f13798AlLFFp = getAlphaSlideBar().A2egSU();
        }
        if (getBrightnessSlider() != null) {
            getBrightnessSlider().ADYaiT();
            this.f13798AlLFFp = getBrightnessSlider().A2egSU();
        }
        A4TApA a4TApA = this.f13806B9tovu;
        if (a4TApA != null && (a4TApA instanceof QTPNDK.A2egSU)) {
            ((QTPNDK.A2egSU) this.f13806B9tovu).A2egSU(new QJCbnW.A4TApA(this.f13798AlLFFp));
        }
        if (this.f13814BV3sI0) {
            this.f13814BV3sI0 = false;
            ImageView imageView = this.f13801B25kr6;
            if (imageView != null) {
                imageView.setAlpha(this.f13810BJ7GGh);
            }
        }
    }

    public final int A4TApA(float f, float f2) {
        Matrix matrix = new Matrix();
        this.f13800AzWtSf.getImageMatrix().invert(matrix);
        float[] fArr = {f, f2};
        matrix.mapPoints(fArr);
        if (this.f13800AzWtSf.getDrawable() != null && (this.f13800AzWtSf.getDrawable() instanceof BitmapDrawable)) {
            float f3 = fArr[0];
            if (f3 >= 0.0f && fArr[1] >= 0.0f && f3 < this.f13800AzWtSf.getDrawable().getIntrinsicWidth() && fArr[1] < this.f13800AzWtSf.getDrawable().getIntrinsicHeight()) {
                invalidate();
                if (!(this.f13800AzWtSf.getDrawable() instanceof QJCbnW.A5SV6n)) {
                    Rect bounds = this.f13800AzWtSf.getDrawable().getBounds();
                    return ((BitmapDrawable) this.f13800AzWtSf.getDrawable()).getBitmap().getPixel((int) ((fArr[0] / bounds.width()) * ((BitmapDrawable) this.f13800AzWtSf.getDrawable()).getBitmap().getWidth()), (int) ((fArr[1] / bounds.height()) * ((BitmapDrawable) this.f13800AzWtSf.getDrawable()).getBitmap().getHeight()));
                }
                float width = f - (getWidth() * 0.5f);
                float[] fArr2 = {0.0f, 0.0f, 1.0f};
                fArr2[0] = ((float) ((Math.atan2(f2 - (getHeight() * 0.5f), -width) / 3.141592653589793d) * 180.0d)) + 180.0f;
                fArr2[1] = Math.max(0.0f, Math.min(1.0f, (float) (Math.sqrt((r13 * r13) + (width * width)) / (Math.min(getWidth(), getHeight()) * 0.5f))));
                return Color.HSVToColor(fArr2);
            }
        }
        return 0;
    }

    public final void A5SV6n(Point point) {
        new Point(point.x - (this.f13801B25kr6.getWidth() / 2), point.y - (this.f13801B25kr6.getMeasuredHeight() / 2));
    }

    public final void ADYaiT(int i) {
        if (!(this.f13800AzWtSf.getDrawable() instanceof QJCbnW.A5SV6n)) {
            throw new IllegalAccessException("selectByHsvColor(@ColorInt int color) can be called only when the palette is an instance of ColorHsvPalette. Use setHsvPaletteDrawable();");
        }
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        float width = getWidth() * 0.5f;
        float height = getHeight() * 0.5f;
        Point COJEAR2 = AlLFFp.COJEAR(this, new Point((int) ((Math.cos(Math.toRadians(fArr[0])) * Math.min(width, height) * fArr[1]) + width), (int) ((Math.sin(Math.toRadians(fArr[0])) * (-r4)) + height)));
        this.f13797AcNBzu = i;
        this.f13798AlLFFp = i;
        this.f13799AmA8tU = new Point(COJEAR2.x, COJEAR2.y);
        if (getAlphaSlideBar() != null) {
            getAlphaSlideBar().setSelectorByHalfSelectorPosition(getAlpha());
        }
        if (getBrightnessSlider() != null) {
            getBrightnessSlider().setSelectorByHalfSelectorPosition(fArr[2]);
        }
        AMqCpz(COJEAR2.x, COJEAR2.y);
        A2egSU(getColor(), false);
        A5SV6n(this.f13799AmA8tU);
    }

    public final void AMqCpz(int i, int i2) {
        this.f13801B25kr6.setX(i - (r0.getWidth() * 0.5f));
        this.f13801B25kr6.setY(i2 - (r4.getMeasuredHeight() * 0.5f));
    }

    public A2egSU getActionMode() {
        return this.f13809BIYEnU;
    }

    @Override // android.view.View
    public float getAlpha() {
        return Color.alpha(getColor()) / 255.0f;
    }

    public AlphaSlideBar getAlphaSlideBar() {
        return this.f13804B4ZgIw;
    }

    public BrightnessSlideBar getBrightnessSlider() {
        return this.f13805B7CMnp;
    }

    public int getColor() {
        return this.f13798AlLFFp;
    }

    public QJCbnW.A4TApA getColorEnvelope() {
        return new QJCbnW.A4TApA(getColor());
    }

    public long getDebounceDuration() {
        return this.f13807BChYOn;
    }

    public QR4yFL.A2egSU getFlagView() {
        return null;
    }

    public String getPreferenceName() {
        return this.f13815BmvVmW;
    }

    public int getPureColor() {
        return this.f13797AcNBzu;
    }

    public Point getSelectedPoint() {
        return this.f13799AmA8tU;
    }

    public ImageView getSelector() {
        return this.f13801B25kr6;
    }

    public float getSelectorX() {
        return this.f13801B25kr6.getX() - (this.f13801B25kr6.getWidth() * 0.5f);
    }

    public float getSelectorY() {
        return this.f13801B25kr6.getY() - (this.f13801B25kr6.getMeasuredHeight() * 0.5f);
    }

    @BmvVmW(androidx.lifecycle.AlLFFp.ON_DESTROY)
    public void onDestroy() {
        this.f13816BniPrB.A4TApA(this);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f13800AzWtSf.getDrawable() == null) {
            this.f13800AzWtSf.setImageDrawable(new QJCbnW.A5SV6n(getResources(), Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888)));
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1 && actionMasked != 2) {
            this.f13801B25kr6.setPressed(false);
            return false;
        }
        getFlagView();
        this.f13801B25kr6.setPressed(true);
        Point COJEAR2 = AlLFFp.COJEAR(this, new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
        int A4TApA2 = A4TApA(COJEAR2.x, COJEAR2.y);
        this.f13797AcNBzu = A4TApA2;
        this.f13798AlLFFp = A4TApA2;
        this.f13799AmA8tU = AlLFFp.COJEAR(this, new Point(COJEAR2.x, COJEAR2.y));
        AMqCpz(COJEAR2.x, COJEAR2.y);
        A2egSU a2egSU = this.f13809BIYEnU;
        A2egSU a2egSU2 = A2egSU.f7466AlLFFp;
        Handler handler = this.f13808BI9f7h;
        if (a2egSU != a2egSU2) {
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(new CtFAbx.A2egSU(14, this), this.f13807BChYOn);
            return true;
        }
        A5SV6n(this.f13799AmA8tU);
        if (motionEvent.getAction() == 1) {
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(new CtFAbx.A2egSU(14, this), this.f13807BChYOn);
        }
        return true;
    }

    public void setActionMode(A2egSU a2egSU) {
        this.f13809BIYEnU = a2egSU;
    }

    public void setColorListener(A4TApA a4TApA) {
        this.f13806B9tovu = a4TApA;
    }

    public void setDebounceDuration(long j) {
        this.f13807BChYOn = j;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f13801B25kr6.setVisibility(z ? 0 : 4);
        if (getAlphaSlideBar() != null) {
            getAlphaSlideBar().setEnabled(z);
        }
        if (getBrightnessSlider() != null) {
            getBrightnessSlider().setEnabled(z);
        }
        if (z) {
            this.f13800AzWtSf.clearColorFilter();
        } else {
            this.f13800AzWtSf.setColorFilter(Color.argb(70, 255, 255, 255));
        }
    }

    public void setFlagView(QR4yFL.A2egSU a2egSU) {
        throw null;
    }

    public void setInitialColor(int i) {
        if (getPreferenceName() != null) {
            if (getPreferenceName() == null) {
                return;
            }
            String preferenceName = getPreferenceName();
            K7mCWO.A4TApA a4TApA = this.f13816BniPrB;
            a4TApA.getClass();
            if (a4TApA.f4181A2egSU.getInt(preferenceName + "_COLOR", -1) != -1) {
                return;
            }
        }
        post(new ADYaiT(this, i, 0));
    }

    public void setInitialColorRes(int i) {
        setInitialColor(ASJ6gh.A4TApA(getContext(), i));
    }

    public void setLifecycleOwner(B9tovu b9tovu) {
        b9tovu.getLifecycle().A2egSU(this);
    }

    public void setPaletteDrawable(Drawable drawable) {
        removeView(this.f13800AzWtSf);
        ImageView imageView = new ImageView(getContext());
        this.f13800AzWtSf = imageView;
        this.f13802B2KMhB = drawable;
        imageView.setImageDrawable(drawable);
        addView(this.f13800AzWtSf);
        removeView(this.f13801B25kr6);
        addView(this.f13801B25kr6);
        this.f13797AcNBzu = -1;
        AlphaSlideBar alphaSlideBar = this.f13804B4ZgIw;
        if (alphaSlideBar != null) {
            alphaSlideBar.ADYaiT();
        }
        BrightnessSlideBar brightnessSlideBar = this.f13805B7CMnp;
        if (brightnessSlideBar != null) {
            brightnessSlideBar.ADYaiT();
            if (this.f13805B7CMnp.A2egSU() != -1) {
                this.f13798AlLFFp = this.f13805B7CMnp.A2egSU();
            } else {
                AlphaSlideBar alphaSlideBar2 = this.f13804B4ZgIw;
                if (alphaSlideBar2 != null) {
                    this.f13798AlLFFp = alphaSlideBar2.A2egSU();
                }
            }
        }
        if (this.f13814BV3sI0) {
            return;
        }
        this.f13814BV3sI0 = true;
        ImageView imageView2 = this.f13801B25kr6;
        if (imageView2 != null) {
            this.f13810BJ7GGh = imageView2.getAlpha();
            this.f13801B25kr6.setAlpha(0.0f);
        }
    }

    public void setPreferenceName(String str) {
        this.f13815BmvVmW = str;
        AlphaSlideBar alphaSlideBar = this.f13804B4ZgIw;
        if (alphaSlideBar != null) {
            alphaSlideBar.setPreferenceName(str);
        }
        BrightnessSlideBar brightnessSlideBar = this.f13805B7CMnp;
        if (brightnessSlideBar != null) {
            brightnessSlideBar.setPreferenceName(str);
        }
    }

    public void setPureColor(int i) {
        this.f13797AcNBzu = i;
    }

    public void setSelectorDrawable(Drawable drawable) {
        this.f13801B25kr6.setImageDrawable(drawable);
    }
}
