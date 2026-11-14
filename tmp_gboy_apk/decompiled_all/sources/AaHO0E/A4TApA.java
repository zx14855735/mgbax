package AaHO0E;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends Drawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f596A2egSU = 1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Object f597A4TApA;

    public /* synthetic */ A4TApA() {
    }

    private final void A2egSU(int i) {
    }

    private final void A4TApA(ColorFilter colorFilter) {
    }

    public void A5SV6n(Drawable drawable) {
        this.f597A4TApA = drawable;
        if (drawable != null) {
            drawable.setBounds(getBounds());
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        switch (this.f596A2egSU) {
            case 0:
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.f597A4TApA;
                if (!actionBarContainer.f8083B3GDIM) {
                    Drawable drawable = actionBarContainer.f8080AzWtSf;
                    if (drawable != null) {
                        drawable.draw(canvas);
                    }
                    Drawable drawable2 = actionBarContainer.f8081B25kr6;
                    if (drawable2 != null && actionBarContainer.f8084B4ZgIw) {
                        drawable2.draw(canvas);
                        break;
                    }
                } else {
                    Drawable drawable3 = actionBarContainer.f8082B2KMhB;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                        break;
                    }
                }
                break;
            default:
                Drawable drawable4 = (Drawable) this.f597A4TApA;
                if (drawable4 != null) {
                    drawable4.draw(canvas);
                    break;
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        switch (this.f596A2egSU) {
            case 1:
                Drawable drawable = (Drawable) this.f597A4TApA;
                if (drawable != null) {
                    return drawable.getIntrinsicHeight();
                }
                return 100;
            default:
                return super.getIntrinsicHeight();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        switch (this.f596A2egSU) {
            case 1:
                Drawable drawable = (Drawable) this.f597A4TApA;
                if (drawable != null) {
                    return drawable.getIntrinsicWidth();
                }
                return 100;
            default:
                return super.getIntrinsicWidth();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        switch (this.f596A2egSU) {
            case 0:
                return 0;
            default:
                Drawable drawable = (Drawable) this.f597A4TApA;
                if (drawable != null) {
                    return drawable.getOpacity();
                }
                return -2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        switch (this.f596A2egSU) {
            case 0:
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.f597A4TApA;
                if (!actionBarContainer.f8083B3GDIM) {
                    Drawable drawable = actionBarContainer.f8080AzWtSf;
                    if (drawable != null) {
                        drawable.getOutline(outline);
                        break;
                    }
                } else if (actionBarContainer.f8082B2KMhB != null) {
                    actionBarContainer.f8080AzWtSf.getOutline(outline);
                    break;
                }
                break;
            default:
                super.getOutline(outline);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        switch (this.f596A2egSU) {
            case 0:
                break;
            default:
                Drawable drawable = (Drawable) this.f597A4TApA;
                if (drawable != null) {
                    drawable.setAlpha(i);
                    break;
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        switch (this.f596A2egSU) {
            case 1:
                super.setBounds(i, i2, i3, i4);
                Drawable drawable = (Drawable) this.f597A4TApA;
                if (drawable != null) {
                    drawable.setBounds(i, i2, i3, i4);
                    break;
                }
                break;
            default:
                super.setBounds(i, i2, i3, i4);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        switch (this.f596A2egSU) {
            case 0:
                break;
            default:
                Drawable drawable = (Drawable) this.f597A4TApA;
                if (drawable != null) {
                    drawable.setColorFilter(colorFilter);
                    break;
                }
                break;
        }
    }

    public A4TApA(ActionBarContainer actionBarContainer) {
        this.f597A4TApA = actionBarContainer;
    }
}
