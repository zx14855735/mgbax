package com.github.chrisbanes.photoview;

import N8W1LJ.A5SV6n;
import N8W1LJ.ADYaiT;
import N8W1LJ.AMqCpz;
import N8W1LJ.ARc23Z;
import N8W1LJ.ASJ6gh;
import N8W1LJ.AYUAbz;
import N8W1LJ.AZOQYO;
import N8W1LJ.AmA8tU;
import N8W1LJ.AzWtSf;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AmA8tU f11203AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ImageView.ScaleType f11204AlLFFp;

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11203AcNBzu = new AmA8tU(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f11204AlLFFp;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f11204AlLFFp = null;
        }
    }

    public AmA8tU getAttacher() {
        return this.f11203AcNBzu;
    }

    public RectF getDisplayRect() {
        AmA8tU amA8tU = this.f11203AcNBzu;
        amA8tU.A4TApA();
        Matrix A5SV6n2 = amA8tU.A5SV6n();
        if (amA8tU.f5575B4ZgIw.getDrawable() == null) {
            return null;
        }
        RectF rectF = amA8tU.f5581BJ7GGh;
        rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
        A5SV6n2.mapRect(rectF);
        return rectF;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f11203AcNBzu.f5579BI9f7h;
    }

    public float getMaximumScale() {
        return this.f11203AcNBzu.f5572B25kr6;
    }

    public float getMediumScale() {
        return this.f11203AcNBzu.f5571AzWtSf;
    }

    public float getMinimumScale() {
        return this.f11203AcNBzu.f5570AmA8tU;
    }

    public float getScale() {
        return this.f11203AcNBzu.ADYaiT();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f11203AcNBzu.f5589C4FrIb;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f11203AcNBzu.f5573B2KMhB = z;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f11203AcNBzu.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        AmA8tU amA8tU = this.f11203AcNBzu;
        if (amA8tU != null) {
            amA8tU.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        AmA8tU amA8tU = this.f11203AcNBzu;
        if (amA8tU != null) {
            amA8tU.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        AmA8tU amA8tU = this.f11203AcNBzu;
        if (amA8tU != null) {
            amA8tU.update();
        }
    }

    public void setMaximumScale(float f) {
        AmA8tU amA8tU = this.f11203AcNBzu;
        AlLFFp.BIYEnU(amA8tU.f5570AmA8tU, amA8tU.f5571AzWtSf, f);
        amA8tU.f5572B25kr6 = f;
    }

    public void setMediumScale(float f) {
        AmA8tU amA8tU = this.f11203AcNBzu;
        AlLFFp.BIYEnU(amA8tU.f5570AmA8tU, f, amA8tU.f5572B25kr6);
        amA8tU.f5571AzWtSf = f;
    }

    public void setMinimumScale(float f) {
        AmA8tU amA8tU = this.f11203AcNBzu;
        AlLFFp.BIYEnU(f, amA8tU.f5571AzWtSf, amA8tU.f5572B25kr6);
        amA8tU.f5570AmA8tU = f;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11203AcNBzu.f5584BTvldC = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f11203AcNBzu.f5576B7CMnp.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f11203AcNBzu.f5585BV3sI0 = onLongClickListener;
    }

    public void setOnMatrixChangeListener(A5SV6n a5SV6n) {
        this.f11203AcNBzu.getClass();
    }

    public void setOnOutsidePhotoTapListener(ADYaiT aDYaiT) {
        this.f11203AcNBzu.getClass();
    }

    public void setOnPhotoTapListener(AMqCpz aMqCpz) {
        this.f11203AcNBzu.getClass();
    }

    public void setOnScaleChangeListener(ARc23Z aRc23Z) {
        this.f11203AcNBzu.getClass();
    }

    public void setOnSingleFlingListener(ASJ6gh aSJ6gh) {
        this.f11203AcNBzu.getClass();
    }

    public void setOnViewDragListener(AYUAbz aYUAbz) {
        this.f11203AcNBzu.getClass();
    }

    public void setOnViewTapListener(AZOQYO azoqyo) {
        this.f11203AcNBzu.f5583BPw6Q8 = azoqyo;
    }

    public void setRotationBy(float f) {
        AmA8tU amA8tU = this.f11203AcNBzu;
        amA8tU.f5580BIYEnU.postRotate(f % 360.0f);
        amA8tU.A2egSU();
    }

    public void setRotationTo(float f) {
        AmA8tU amA8tU = this.f11203AcNBzu;
        amA8tU.f5580BIYEnU.setRotate(f % 360.0f);
        amA8tU.A2egSU();
    }

    public void setScale(float f) {
        AmA8tU amA8tU = this.f11203AcNBzu;
        PhotoView photoView = amA8tU.f5575B4ZgIw;
        amA8tU.AMqCpz(f, photoView.getRight() / 2, photoView.getBottom() / 2, false);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        AmA8tU amA8tU = this.f11203AcNBzu;
        if (amA8tU == null) {
            this.f11204AlLFFp = scaleType;
            return;
        }
        amA8tU.getClass();
        if (scaleType == null) {
            return;
        }
        if (AzWtSf.f5591A2egSU[scaleType.ordinal()] == 1) {
            throw new IllegalStateException("Matrix scale type is not supported");
        }
        if (scaleType != amA8tU.f5589C4FrIb) {
            amA8tU.f5589C4FrIb = scaleType;
            amA8tU.update();
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.f11203AcNBzu.f5569AlLFFp = i;
    }

    public void setZoomable(boolean z) {
        AmA8tU amA8tU = this.f11203AcNBzu;
        amA8tU.f5588C2rE4F = z;
        amA8tU.update();
    }
}
