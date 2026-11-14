package IJPJ4E;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends Drawable implements ARc23Z, Animatable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final DcUJf1.AMqCpz f3888AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f3889AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f3890AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f3891AzWtSf;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f3893B2KMhB;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f3895B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Paint f3896B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public Rect f3897B9tovu;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f3892B25kr6 = true;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f3894B3GDIM = -1;

    public A4TApA(DcUJf1.AMqCpz aMqCpz) {
        this.f3888AcNBzu = aMqCpz;
    }

    public final void A2egSU() {
        ItGa5w.ARc23Z.A2egSU(!this.f3891AzWtSf, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        AYUAbz aYUAbz = (AYUAbz) this.f3888AcNBzu.f2321A4TApA;
        if (aYUAbz.f3905A2egSU.f3448AcNBzu.f3426A5SV6n == 1) {
            invalidateSelf();
            return;
        }
        if (this.f3889AlLFFp) {
            return;
        }
        this.f3889AlLFFp = true;
        if (aYUAbz.f3913AZkASS) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        ArrayList arrayList = aYUAbz.f3907A5SV6n;
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (isEmpty && !aYUAbz.f3909ARc23Z) {
            aYUAbz.f3909ARc23Z = true;
            aYUAbz.f3913AZkASS = false;
            aYUAbz.A2egSU();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f3891AzWtSf) {
            return;
        }
        if (this.f3895B4ZgIw) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f3897B9tovu == null) {
                this.f3897B9tovu = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f3897B9tovu);
            this.f3895B4ZgIw = false;
        }
        AYUAbz aYUAbz = (AYUAbz) this.f3888AcNBzu.f2321A4TApA;
        AMqCpz aMqCpz = aYUAbz.f3912AZOQYO;
        Bitmap bitmap = aMqCpz != null ? aMqCpz.f3902B3GDIM : aYUAbz.f3915AcNBzu;
        if (this.f3897B9tovu == null) {
            this.f3897B9tovu = new Rect();
        }
        Rect rect = this.f3897B9tovu;
        if (this.f3896B7CMnp == null) {
            this.f3896B7CMnp = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f3896B7CMnp);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f3888AcNBzu;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((AYUAbz) this.f3888AcNBzu.f2321A4TApA).f3919B25kr6;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((AYUAbz) this.f3888AcNBzu.f2321A4TApA).f3918AzWtSf;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f3889AlLFFp;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3895B4ZgIw = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f3896B7CMnp == null) {
            this.f3896B7CMnp = new Paint(2);
        }
        this.f3896B7CMnp.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f3896B7CMnp == null) {
            this.f3896B7CMnp = new Paint(2);
        }
        this.f3896B7CMnp.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        ItGa5w.ARc23Z.A2egSU(!this.f3891AzWtSf, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f3892B25kr6 = z;
        if (!z) {
            this.f3889AlLFFp = false;
            AYUAbz aYUAbz = (AYUAbz) this.f3888AcNBzu.f2321A4TApA;
            ArrayList arrayList = aYUAbz.f3907A5SV6n;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                aYUAbz.f3909ARc23Z = false;
            }
        } else if (this.f3890AmA8tU) {
            A2egSU();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f3890AmA8tU = true;
        this.f3893B2KMhB = 0;
        if (this.f3892B25kr6) {
            A2egSU();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f3890AmA8tU = false;
        this.f3889AlLFFp = false;
        AYUAbz aYUAbz = (AYUAbz) this.f3888AcNBzu.f2321A4TApA;
        ArrayList arrayList = aYUAbz.f3907A5SV6n;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            aYUAbz.f3909ARc23Z = false;
        }
    }
}
