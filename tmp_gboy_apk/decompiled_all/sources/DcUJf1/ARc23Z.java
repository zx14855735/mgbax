package DcUJf1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends AZOQYO implements Animatable {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final /* synthetic */ int f2322B3GDIM = 0;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Context f2324AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AaHO0E.A5SV6n f2325AzWtSf = null;

    /* renamed from: B25kr6, reason: collision with root package name */
    public ArrayList f2326B25kr6 = null;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ARc23Z.ASJ6gh f2327B2KMhB = new ARc23Z.ASJ6gh(this);

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ADYaiT f2323AlLFFp = new ADYaiT();

    public ARc23Z(Context context) {
        this.f2324AmA8tU = context;
    }

    @Override // DcUJf1.AZOQYO, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            BmvVmW.A2egSU.A2egSU(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            return BmvVmW.A2egSU.A4TApA(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        ADYaiT aDYaiT = this.f2323AlLFFp;
        aDYaiT.f2316A2egSU.draw(canvas);
        if (aDYaiT.f2317A4TApA.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.getAlpha() : this.f2323AlLFFp.f2316A2egSU.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f2323AlLFFp.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? BmvVmW.A2egSU.A5SV6n(drawable) : this.f2323AlLFFp.f2316A2egSU.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f2331AcNBzu == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new AMqCpz(0, this.f2331AcNBzu.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f2323AlLFFp.f2316A2egSU.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f2323AlLFFp.f2316A2egSU.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.getOpacity() : this.f2323AlLFFp.f2316A2egSU.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0136, code lost:
    
        if (r8.f2317A4TApA != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0138, code lost:
    
        r8.f2317A4TApA = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x013f, code lost:
    
        r8.f2317A4TApA.playTogether(r8.f2318A5SV6n);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0146, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.content.res.Resources.Theme r23) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: DcUJf1.ARc23Z.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.isAutoMirrored() : this.f2323AlLFFp.f2316A2egSU.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f2323AlLFFp.f2317A4TApA.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.isStateful() : this.f2323AlLFFp.f2316A2egSU.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2323AlLFFp.f2316A2egSU.setBounds(rect);
        }
    }

    @Override // DcUJf1.AZOQYO, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.setLevel(i) : this.f2323AlLFFp.f2316A2egSU.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.setState(iArr) : this.f2323AlLFFp.f2316A2egSU.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f2323AlLFFp.f2316A2egSU.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f2323AlLFFp.f2316A2egSU.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2323AlLFFp.f2316A2egSU.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            com.bumptech.glide.A5SV6n.D9tr6l(drawable, i);
        } else {
            this.f2323AlLFFp.f2316A2egSU.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            com.bumptech.glide.A5SV6n.DAk1zC(drawable, colorStateList);
        } else {
            this.f2323AlLFFp.f2316A2egSU.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            com.bumptech.glide.A5SV6n.DG07BK(drawable, mode);
        } else {
            this.f2323AlLFFp.f2316A2egSU.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f2323AlLFFp.f2316A2egSU.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        ADYaiT aDYaiT = this.f2323AlLFFp;
        if (aDYaiT.f2317A4TApA.isStarted()) {
            return;
        }
        aDYaiT.f2317A4TApA.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2323AlLFFp.f2317A4TApA.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
