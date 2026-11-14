package androidx.appcompat.widget;

import AaHO0E.B7CMnp;
import AaHO0E.BmvVmW;
import AaHO0E.EGM26s;
import AaHO0E.GIi2tl;
import AaHO0E.GIl1rw;
import AaHO0E.GJee0v;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AppCompatImageView extends ImageView {
    private final B7CMnp mBackgroundTintHelper;
    private boolean mHasLevel;
    private final BmvVmW mImageHelper;

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.mBackgroundTintHelper;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW != null) {
            bmvVmW.A2egSU();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.mBackgroundTintHelper;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.mBackgroundTintHelper;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        GJee0v gJee0v;
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW == null || (gJee0v = bmvVmW.f671A4TApA) == null) {
            return null;
        }
        return gJee0v.f879A2egSU;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        GJee0v gJee0v;
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW == null || (gJee0v = bmvVmW.f671A4TApA) == null) {
            return null;
        }
        return gJee0v.f880A4TApA;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return !(this.mImageHelper.f670A2egSU.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.mBackgroundTintHelper;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.mBackgroundTintHelper;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW != null) {
            bmvVmW.A2egSU();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW != null && drawable != null && !this.mHasLevel) {
            bmvVmW.f673ADYaiT = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        BmvVmW bmvVmW2 = this.mImageHelper;
        if (bmvVmW2 != null) {
            bmvVmW2.A2egSU();
            if (this.mHasLevel) {
                return;
            }
            BmvVmW bmvVmW3 = this.mImageHelper;
            ImageView imageView = bmvVmW3.f670A2egSU;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(bmvVmW3.f673ADYaiT);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW != null) {
            ImageView imageView = bmvVmW.f670A2egSU;
            if (i != 0) {
                Drawable CQhlFr2 = AlLFFp.CQhlFr(imageView.getContext(), i);
                if (CQhlFr2 != null) {
                    EGM26s.A2egSU(CQhlFr2);
                }
                imageView.setImageDrawable(CQhlFr2);
            } else {
                imageView.setImageDrawable(null);
            }
            bmvVmW.A2egSU();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW != null) {
            bmvVmW.A2egSU();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.mBackgroundTintHelper;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.mBackgroundTintHelper;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW != null) {
            if (bmvVmW.f671A4TApA == null) {
                bmvVmW.f671A4TApA = new GJee0v();
            }
            GJee0v gJee0v = bmvVmW.f671A4TApA;
            gJee0v.f879A2egSU = colorStateList;
            gJee0v.f882ADYaiT = true;
            bmvVmW.A2egSU();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        BmvVmW bmvVmW = this.mImageHelper;
        if (bmvVmW != null) {
            if (bmvVmW.f671A4TApA == null) {
                bmvVmW.f671A4TApA = new GJee0v();
            }
            GJee0v gJee0v = bmvVmW.f671A4TApA;
            gJee0v.f880A4TApA = mode;
            gJee0v.f881A5SV6n = true;
            bmvVmW.A2egSU();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GIl1rw.A2egSU(context);
        this.mHasLevel = false;
        GIi2tl.A2egSU(getContext(), this);
        B7CMnp b7CMnp = new B7CMnp(this);
        this.mBackgroundTintHelper = b7CMnp;
        b7CMnp.ADYaiT(attributeSet, i);
        BmvVmW bmvVmW = new BmvVmW(this);
        this.mImageHelper = bmvVmW;
        bmvVmW.A4TApA(attributeSet, i);
    }
}
