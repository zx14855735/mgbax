package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BV3sI0 extends ImageButton {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f667AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final BmvVmW f668AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f669AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BV3sI0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GIl1rw.A2egSU(context);
        this.f669AmA8tU = false;
        GIi2tl.A2egSU(getContext(), this);
        B7CMnp b7CMnp = new B7CMnp(this);
        this.f667AcNBzu = b7CMnp;
        b7CMnp.ADYaiT(attributeSet, i);
        BmvVmW bmvVmW = new BmvVmW(this);
        this.f668AlLFFp = bmvVmW;
        bmvVmW.A4TApA(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.f667AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        BmvVmW bmvVmW = this.f668AlLFFp;
        if (bmvVmW != null) {
            bmvVmW.A2egSU();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f667AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f667AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        GJee0v gJee0v;
        BmvVmW bmvVmW = this.f668AlLFFp;
        if (bmvVmW == null || (gJee0v = bmvVmW.f671A4TApA) == null) {
            return null;
        }
        return gJee0v.f879A2egSU;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        GJee0v gJee0v;
        BmvVmW bmvVmW = this.f668AlLFFp;
        if (bmvVmW == null || (gJee0v = bmvVmW.f671A4TApA) == null) {
            return null;
        }
        return gJee0v.f880A4TApA;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(this.f668AlLFFp.f670A2egSU.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f667AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f667AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        BmvVmW bmvVmW = this.f668AlLFFp;
        if (bmvVmW != null) {
            bmvVmW.A2egSU();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        BmvVmW bmvVmW = this.f668AlLFFp;
        if (bmvVmW != null && drawable != null && !this.f669AmA8tU) {
            bmvVmW.f673ADYaiT = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (bmvVmW != null) {
            bmvVmW.A2egSU();
            if (this.f669AmA8tU) {
                return;
            }
            ImageView imageView = bmvVmW.f670A2egSU;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(bmvVmW.f673ADYaiT);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.f669AmA8tU = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        BmvVmW bmvVmW = this.f668AlLFFp;
        ImageView imageView = bmvVmW.f670A2egSU;
        if (i != 0) {
            Drawable CQhlFr2 = NOd7IU.AlLFFp.CQhlFr(imageView.getContext(), i);
            if (CQhlFr2 != null) {
                EGM26s.A2egSU(CQhlFr2);
            }
            imageView.setImageDrawable(CQhlFr2);
        } else {
            imageView.setImageDrawable(null);
        }
        bmvVmW.A2egSU();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        BmvVmW bmvVmW = this.f668AlLFFp;
        if (bmvVmW != null) {
            bmvVmW.A2egSU();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.f667AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f667AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        BmvVmW bmvVmW = this.f668AlLFFp;
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
        BmvVmW bmvVmW = this.f668AlLFFp;
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
}
