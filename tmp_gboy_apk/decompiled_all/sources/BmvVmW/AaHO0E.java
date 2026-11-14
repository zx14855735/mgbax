package BmvVmW;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends Drawable implements Drawable.Callback, AZkASS, AZOQYO {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final PorterDuff.Mode f1519B3GDIM = PorterDuff.Mode.SRC_IN;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static Method f1520B4ZgIw;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1521AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public PorterDuff.Mode f1522AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f1523AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AcNBzu f1524AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f1525B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Drawable f1526B2KMhB;

    static {
        CEtK();
    }

    private static /* synthetic */ void CEtK() {
        char[] charArray = "1=?|53?7|0=+|!:7>>|\u0018<;\u0010 ;657".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'R');
        }
        String str = new String(charArray);
        char[] charArray2 = "1>;<;&".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'R');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A2egSU() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f1526B2KMhB;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final AcNBzu A4TApA() {
        AcNBzu acNBzu = this.f1524AzWtSf;
        AcNBzu acNBzu2 = new AcNBzu();
        acNBzu2.f1529A5SV6n = null;
        acNBzu2.f1530ADYaiT = f1519B3GDIM;
        if (acNBzu != null) {
            acNBzu2.f1527A2egSU = acNBzu.f1527A2egSU;
            acNBzu2.f1528A4TApA = acNBzu.f1528A4TApA;
            acNBzu2.f1529A5SV6n = acNBzu.f1529A5SV6n;
            acNBzu2.f1530ADYaiT = acNBzu.f1530ADYaiT;
        }
        return acNBzu2;
    }

    public final boolean A5SV6n(int[] iArr) {
        return AYUAbz(iArr) || this.f1526B2KMhB.setState(iArr);
    }

    public final void ADYaiT(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public final void AMqCpz(ColorStateList colorStateList) {
        this.f1524AzWtSf.f1529A5SV6n = colorStateList;
        AYUAbz(this.f1526B2KMhB.getState());
    }

    public final void ARc23Z(PorterDuff.Mode mode) {
        this.f1524AzWtSf.f1530ADYaiT = mode;
        AYUAbz(this.f1526B2KMhB.getState());
    }

    public final void ASJ6gh(Drawable drawable) {
        Drawable drawable2 = this.f1526B2KMhB;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1526B2KMhB = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            AcNBzu acNBzu = this.f1524AzWtSf;
            if (acNBzu != null) {
                acNBzu.f1528A4TApA = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final boolean AYUAbz(int[] iArr) {
        if (A2egSU()) {
            AcNBzu acNBzu = this.f1524AzWtSf;
            ColorStateList colorStateList = acNBzu.f1529A5SV6n;
            PorterDuff.Mode mode = acNBzu.f1530ADYaiT;
            if (colorStateList == null || mode == null) {
                this.f1523AmA8tU = false;
                clearColorFilter();
                return false;
            }
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f1523AmA8tU || colorForState != this.f1521AcNBzu || mode != this.f1522AlLFFp) {
                setColorFilter(colorForState, mode);
                this.f1521AcNBzu = colorForState;
                this.f1522AlLFFp = mode;
                this.f1523AmA8tU = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.f1526B2KMhB.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        AcNBzu acNBzu = this.f1524AzWtSf;
        return changingConfigurations | (acNBzu != null ? acNBzu.getChangingConfigurations() : 0) | this.f1526B2KMhB.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        AcNBzu acNBzu = this.f1524AzWtSf;
        if (acNBzu == null || acNBzu.f1528A4TApA == null) {
            return null;
        }
        acNBzu.f1527A2egSU = getChangingConfigurations();
        return this.f1524AzWtSf;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f1526B2KMhB.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final Rect getDirtyBounds() {
        return this.f1526B2KMhB.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f1526B2KMhB.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f1526B2KMhB.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getLayoutDirection() {
        return com.bumptech.glide.A5SV6n.BPw6Q8(this.f1526B2KMhB);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f1526B2KMhB.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f1526B2KMhB.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f1526B2KMhB.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        this.f1526B2KMhB.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.f1526B2KMhB.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.f1526B2KMhB.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.f1526B2KMhB.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f1526B2KMhB.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isProjected() {
        Method method;
        Drawable drawable = this.f1526B2KMhB;
        if (drawable != null && (method = f1520B4ZgIw) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        AcNBzu acNBzu;
        ColorStateList colorStateList = (!A2egSU() || (acNBzu = this.f1524AzWtSf) == null) ? null : acNBzu.f1529A5SV6n;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1526B2KMhB.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f1526B2KMhB.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f1525B25kr6 && super.mutate() == this) {
            this.f1524AzWtSf = A4TApA();
            Drawable drawable = this.f1526B2KMhB;
            if (drawable != null) {
                drawable.mutate();
            }
            AcNBzu acNBzu = this.f1524AzWtSf;
            if (acNBzu != null) {
                Drawable drawable2 = this.f1526B2KMhB;
                acNBzu.f1528A4TApA = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1525B25kr6 = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1526B2KMhB;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        return com.bumptech.glide.A5SV6n.D8cQ8b(this.f1526B2KMhB, i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        return this.f1526B2KMhB.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f1526B2KMhB.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        this.f1526B2KMhB.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i) {
        this.f1526B2KMhB.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1526B2KMhB.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.f1526B2KMhB.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.f1526B2KMhB.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        this.f1526B2KMhB.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f1526B2KMhB.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (!A5SV6n(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        if (A2egSU()) {
            ADYaiT(i);
        } else {
            this.f1526B2KMhB.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (A2egSU()) {
            AMqCpz(colorStateList);
        } else {
            this.f1526B2KMhB.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (A2egSU()) {
            ARc23Z(mode);
        } else {
            this.f1526B2KMhB.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1526B2KMhB.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
