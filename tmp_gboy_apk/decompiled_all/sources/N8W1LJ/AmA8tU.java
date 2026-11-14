package N8W1LJ;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.PhotoView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final PhotoView f5575B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final GestureDetector f5576B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final A4TApA f5577B9tovu;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public AZOQYO f5583BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public View.OnClickListener f5584BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public View.OnLongClickListener f5585BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public AlLFFp f5586BmvVmW;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final IQ76hF.AmA8tU f5590CASmeH;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AccelerateDecelerateInterpolator f5568AcNBzu = new AccelerateDecelerateInterpolator();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f5569AlLFFp = 200;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f5570AmA8tU = 1.0f;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public float f5571AzWtSf = 1.75f;

    /* renamed from: B25kr6, reason: collision with root package name */
    public float f5572B25kr6 = 3.0f;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f5573B2KMhB = true;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f5574B3GDIM = false;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final Matrix f5578BChYOn = new Matrix();

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final Matrix f5579BI9f7h = new Matrix();

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final Matrix f5580BIYEnU = new Matrix();

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final RectF f5581BJ7GGh = new RectF();

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final float[] f5582BNL6CD = new float[9];

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f5587BniPrB = 2;
    public int BpkvW3 = 2;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public boolean f5588C2rE4F = true;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public ImageView.ScaleType f5589C4FrIb = ImageView.ScaleType.FIT_CENTER;

    public AmA8tU(PhotoView photoView) {
        IQ76hF.AmA8tU amA8tU = new IQ76hF.AmA8tU(16, this);
        this.f5590CASmeH = amA8tU;
        this.f5575B4ZgIw = photoView;
        photoView.setOnTouchListener(this);
        photoView.addOnLayoutChangeListener(this);
        if (photoView.isInEditMode()) {
            return;
        }
        this.f5577B9tovu = new A4TApA(photoView.getContext(), amA8tU);
        GestureDetector gestureDetector = new GestureDetector(photoView.getContext(), new GJee0v.AzWtSf(2, this));
        this.f5576B7CMnp = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new AZkASS(this));
    }

    public final void A2egSU() {
        if (A4TApA()) {
            this.f5575B4ZgIw.setImageMatrix(A5SV6n());
        }
    }

    public final boolean A4TApA() {
        RectF rectF;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Matrix A5SV6n2 = A5SV6n();
        float f6 = 0.0f;
        if (this.f5575B4ZgIw.getDrawable() != null) {
            rectF = this.f5581BJ7GGh;
            rectF.set(0.0f, 0.0f, r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
            A5SV6n2.mapRect(rectF);
        } else {
            rectF = null;
        }
        if (rectF == null) {
            return false;
        }
        float height = rectF.height();
        float width = rectF.width();
        PhotoView photoView = this.f5575B4ZgIw;
        float height2 = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
        if (height <= height2) {
            int i = AaHO0E.f5557A2egSU[this.f5589C4FrIb.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f4 = (height2 - height) / 2.0f;
                    f5 = rectF.top;
                } else {
                    f4 = height2 - height;
                    f5 = rectF.top;
                }
                f = f4 - f5;
            } else {
                f = -rectF.top;
            }
            this.BpkvW3 = 2;
        } else {
            float f7 = rectF.top;
            if (f7 > 0.0f) {
                this.BpkvW3 = 0;
                f = -f7;
            } else {
                float f8 = rectF.bottom;
                if (f8 < height2) {
                    this.BpkvW3 = 1;
                    f = height2 - f8;
                } else {
                    this.BpkvW3 = -1;
                    f = 0.0f;
                }
            }
        }
        float width2 = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
        if (width <= width2) {
            int i2 = AaHO0E.f5557A2egSU[this.f5589C4FrIb.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f2 = (width2 - width) / 2.0f;
                    f3 = rectF.left;
                } else {
                    f2 = width2 - width;
                    f3 = rectF.left;
                }
                f6 = f2 - f3;
            } else {
                f6 = -rectF.left;
            }
            this.f5587BniPrB = 2;
        } else {
            float f9 = rectF.left;
            if (f9 > 0.0f) {
                this.f5587BniPrB = 0;
                f6 = -f9;
            } else {
                float f10 = rectF.right;
                if (f10 < width2) {
                    f6 = width2 - f10;
                    this.f5587BniPrB = 1;
                } else {
                    this.f5587BniPrB = -1;
                }
            }
        }
        this.f5580BIYEnU.postTranslate(f6, f);
        return true;
    }

    public final Matrix A5SV6n() {
        Matrix matrix = this.f5579BI9f7h;
        matrix.set(this.f5578BChYOn);
        matrix.postConcat(this.f5580BIYEnU);
        return matrix;
    }

    public final float ADYaiT() {
        Matrix matrix = this.f5580BIYEnU;
        float[] fArr = this.f5582BNL6CD;
        matrix.getValues(fArr);
        float pow = (float) Math.pow(fArr[0], 2.0d);
        matrix.getValues(fArr);
        return (float) Math.sqrt(pow + ((float) Math.pow(fArr[3], 2.0d)));
    }

    public final void AMqCpz(float f, float f2, float f3, boolean z) {
        if (f < this.f5570AmA8tU || f > this.f5572B25kr6) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.f5575B4ZgIw.post(new AcNBzu(this, ADYaiT(), f, f2, f3));
        } else {
            this.f5580BIYEnU.setScale(f, f, f2, f3);
            A2egSU();
        }
    }

    public final void ARc23Z(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        PhotoView photoView = this.f5575B4ZgIw;
        float width = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
        float height = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Matrix matrix = this.f5578BChYOn;
        matrix.reset();
        float f = intrinsicWidth;
        float f2 = width / f;
        float f3 = intrinsicHeight;
        float f4 = height / f3;
        ImageView.ScaleType scaleType = this.f5589C4FrIb;
        if (scaleType == ImageView.ScaleType.CENTER) {
            matrix.postTranslate((width - f) / 2.0f, (height - f3) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f2, f4);
            matrix.postScale(max, max);
            matrix.postTranslate((width - (f * max)) / 2.0f, (height - (f3 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f2, f4));
            matrix.postScale(min, min);
            matrix.postTranslate((width - (f * min)) / 2.0f, (height - (f3 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f, f3);
            RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
            if (((int) 0.0f) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f3, f);
            }
            int i = AaHO0E.f5557A2egSU[this.f5589C4FrIb.ordinal()];
            if (i == 1) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        Matrix matrix2 = this.f5580BIYEnU;
        matrix2.reset();
        matrix2.postRotate(0.0f);
        A2egSU();
        this.f5575B4ZgIw.setImageMatrix(A5SV6n());
        A4TApA();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        ARc23Z(this.f5575B4ZgIw.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00c4  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N8W1LJ.AmA8tU.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void update() {
        if (this.f5588C2rE4F) {
            ARc23Z(this.f5575B4ZgIw.getDrawable());
            return;
        }
        Matrix matrix = this.f5580BIYEnU;
        matrix.reset();
        matrix.postRotate(0.0f);
        A2egSU();
        this.f5575B4ZgIw.setImageMatrix(A5SV6n());
        A4TApA();
    }
}
