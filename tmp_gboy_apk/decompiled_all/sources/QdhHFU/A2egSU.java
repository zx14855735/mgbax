package QdhHFU;

import AZkASS.A5SV6n;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sigmob.sdk.base.blurkit.d;
import com.skydoves.colorpickerview.ColorPickerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class A2egSU extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ColorPickerView f7474AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Paint f7475AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Paint f7476AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public float f7477AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f7478B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Drawable f7479B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f7480B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f7481B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f7482B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final ImageView f7483B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public String f7484BChYOn;

    public A2egSU(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7477AzWtSf = 1.0f;
        this.f7478B25kr6 = 0;
        this.f7480B3GDIM = 2;
        this.f7481B4ZgIw = d.f13043a;
        this.f7482B7CMnp = -1;
        A4TApA(attributeSet);
        this.f7475AlLFFp = new Paint(1);
        Paint paint = new Paint(1);
        this.f7476AmA8tU = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f7476AmA8tU.setStrokeWidth(this.f7480B3GDIM);
        this.f7476AmA8tU.setColor(this.f7481B4ZgIw);
        setBackgroundColor(-1);
        this.f7483B9tovu = new ImageView(getContext());
        Drawable drawable = this.f7479B2KMhB;
        if (drawable != null) {
            setSelectorDrawable(drawable);
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new A5SV6n(6, this));
    }

    public abstract int A2egSU();

    public abstract void A4TApA(AttributeSet attributeSet);

    public final float A5SV6n(float f) {
        float width = getWidth() - (this.f7483B9tovu.getWidth() / 2);
        if (f >= width) {
            return width;
        }
        if (f <= getSelectorSize() / 2.0f) {
            return 0.0f;
        }
        return f - (getSelectorSize() / 2.0f);
    }

    public final void ADYaiT() {
        this.f7482B7CMnp = this.f7474AcNBzu.getPureColor();
        ARc23Z(this.f7475AlLFFp);
        invalidate();
    }

    public abstract void AMqCpz();

    public abstract void ARc23Z(Paint paint);

    public final void ASJ6gh(int i) {
        float width = this.f7483B9tovu.getWidth() / 2.0f;
        float f = i;
        float width2 = (f - width) / ((getWidth() - width) - width);
        this.f7477AzWtSf = width2;
        if (width2 < 0.0f) {
            this.f7477AzWtSf = 0.0f;
        }
        if (this.f7477AzWtSf > 1.0f) {
            this.f7477AzWtSf = 1.0f;
        }
        int A5SV6n2 = (int) A5SV6n(f);
        this.f7478B25kr6 = A5SV6n2;
        this.f7483B9tovu.setX(A5SV6n2);
        this.f7474AcNBzu.A2egSU(A2egSU(), false);
    }

    public int getBorderHalfSize() {
        return (int) (this.f7480B3GDIM * 0.5f);
    }

    public float getSelectorPosition() {
        return this.f7477AzWtSf;
    }

    public int getSelectorSize() {
        return this.f7483B9tovu.getWidth();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth();
        float measuredHeight = getMeasuredHeight();
        canvas.drawRect(0.0f, 0.0f, width, measuredHeight, this.f7475AlLFFp);
        canvas.drawRect(0.0f, 0.0f, width, measuredHeight, this.f7476AmA8tU);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f7474AcNBzu != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0 && actionMasked != 1 && actionMasked != 2) {
                this.f7483B9tovu.setPressed(false);
                return false;
            }
            this.f7483B9tovu.setPressed(true);
            if (motionEvent.getX() <= getWidth() && motionEvent.getX() >= 0.0f) {
                float x = motionEvent.getX();
                float width = this.f7483B9tovu.getWidth() / 2.0f;
                float width2 = getWidth() - width;
                if (x > width2) {
                    x = width2;
                }
                float f = (x - width) / (width2 - width);
                this.f7477AzWtSf = f;
                if (f < 0.0f) {
                    this.f7477AzWtSf = 0.0f;
                }
                if (this.f7477AzWtSf > 1.0f) {
                    this.f7477AzWtSf = 1.0f;
                }
                int A5SV6n2 = (int) A5SV6n(new Point((int) motionEvent.getX(), (int) motionEvent.getY()).x);
                this.f7478B25kr6 = A5SV6n2;
                this.f7483B9tovu.setX(A5SV6n2);
                if (this.f7474AcNBzu.getActionMode() != QJCbnW.A2egSU.f7466AlLFFp) {
                    this.f7474AcNBzu.A2egSU(A2egSU(), true);
                } else if (motionEvent.getAction() == 1) {
                    this.f7474AcNBzu.A2egSU(A2egSU(), true);
                }
                this.f7474AcNBzu.getFlagView();
                float width3 = getWidth() - this.f7483B9tovu.getWidth();
                if (this.f7483B9tovu.getX() >= width3) {
                    this.f7483B9tovu.setX(width3);
                }
                if (this.f7483B9tovu.getX() <= 0.0f) {
                    this.f7483B9tovu.setX(0.0f);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f7483B9tovu.setVisibility(z ? 0 : 4);
        setClickable(z);
    }

    public void setSelectorByHalfSelectorPosition(float f) {
        this.f7477AzWtSf = Math.min(f, 1.0f);
        int A5SV6n2 = (int) A5SV6n(((getWidth() * f) - (getSelectorSize() * 0.5f)) - getBorderHalfSize());
        this.f7478B25kr6 = A5SV6n2;
        this.f7483B9tovu.setX(A5SV6n2);
    }

    public void setSelectorDrawable(Drawable drawable) {
        removeView(this.f7483B9tovu);
        this.f7479B2KMhB = drawable;
        this.f7483B9tovu.setImageDrawable(drawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.f7483B9tovu, layoutParams);
    }

    public void setSelectorPosition(float f) {
        this.f7477AzWtSf = Math.min(f, 1.0f);
        int A5SV6n2 = (int) A5SV6n(((getWidth() * f) - getSelectorSize()) - getBorderHalfSize());
        this.f7478B25kr6 = A5SV6n2;
        this.f7483B9tovu.setX(A5SV6n2);
    }
}
