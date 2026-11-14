package AaHO0E;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class H6qKiO implements DvK7DB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Toolbar f898A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f899A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final View f900A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Drawable f901ADYaiT;
    public Drawable AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Drawable f902ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f903ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public CharSequence f904AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final CharSequence f905AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final CharSequence f906AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public Window.Callback f907AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f908AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AzWtSf f909AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f910AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Drawable f911AzWtSf;

    public H6qKiO(Toolbar toolbar, boolean z) {
        Drawable drawable;
        this.f910AmA8tU = 0;
        this.f898A2egSU = toolbar;
        this.f904AYUAbz = toolbar.getTitle();
        this.f905AZOQYO = toolbar.getSubtitle();
        this.f903ASJ6gh = this.f904AYUAbz != null;
        this.f902ARc23Z = toolbar.getNavigationIcon();
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(toolbar.getContext(), null, R$styleable.f8014A2egSU, 2130968583);
        int i = 15;
        this.f911AzWtSf = ARc23Z2.A4TApA(15);
        if (z) {
            TypedArray typedArray = ARc23Z2.f884A4TApA;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                this.f903ASJ6gh = true;
                this.f904AYUAbz = text;
                if ((this.f899A4TApA & 8) != 0) {
                    Toolbar toolbar2 = this.f898A2egSU;
                    toolbar2.setTitle(text);
                    if (this.f903ASJ6gh) {
                        COJEAR.DG07BK.B7CMnp(toolbar2.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.f905AZOQYO = text2;
                if ((this.f899A4TApA & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable A4TApA2 = ARc23Z2.A4TApA(20);
            if (A4TApA2 != null) {
                this.AMqCpz = A4TApA2;
                A5SV6n();
            }
            Drawable A4TApA3 = ARc23Z2.A4TApA(17);
            if (A4TApA3 != null) {
                this.f901ADYaiT = A4TApA3;
                A5SV6n();
            }
            if (this.f902ARc23Z == null && (drawable = this.f911AzWtSf) != null) {
                this.f902ARc23Z = drawable;
                int i2 = this.f899A4TApA & 4;
                Toolbar toolbar3 = this.f898A2egSU;
                if (i2 != 0) {
                    toolbar3.setNavigationIcon(drawable);
                } else {
                    toolbar3.setNavigationIcon((Drawable) null);
                }
            }
            A2egSU(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f900A5SV6n;
                if (view != null && (this.f899A4TApA & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f900A5SV6n = inflate;
                if (inflate != null && (this.f899A4TApA & 16) != 0) {
                    toolbar.addView(inflate);
                }
                A2egSU(this.f899A4TApA | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.ADYaiT();
                toolbar.f8238BniPrB.A2egSU(max, max2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f8230BI9f7h = resourceId2;
                AppCompatTextView appCompatTextView = toolbar.f8220AlLFFp;
                if (appCompatTextView != null) {
                    appCompatTextView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f8231BIYEnU = resourceId3;
                AppCompatTextView appCompatTextView2 = toolbar.f8221AmA8tU;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f911AzWtSf = toolbar.getNavigationIcon();
            } else {
                i = 11;
            }
            this.f899A4TApA = i;
        }
        ARc23Z2.ASJ6gh();
        if (2131886083 != this.f910AmA8tU) {
            this.f910AmA8tU = 2131886083;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i3 = this.f910AmA8tU;
                this.f906AZkASS = i3 != 0 ? getContext().getString(i3) : null;
                A4TApA();
            }
        }
        this.f906AZkASS = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new H3v3Sq(this));
    }

    public final void A2egSU(int i) {
        View view;
        int i2 = this.f899A4TApA ^ i;
        this.f899A4TApA = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    A4TApA();
                }
                int i3 = this.f899A4TApA & 4;
                Toolbar toolbar = this.f898A2egSU;
                if (i3 != 0) {
                    Drawable drawable = this.f902ARc23Z;
                    if (drawable == null) {
                        drawable = this.f911AzWtSf;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                A5SV6n();
            }
            int i4 = i2 & 8;
            Toolbar toolbar2 = this.f898A2egSU;
            if (i4 != 0) {
                if ((i & 8) != 0) {
                    toolbar2.setTitle(this.f904AYUAbz);
                    toolbar2.setSubtitle(this.f905AZOQYO);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.f900A5SV6n) == null) {
                return;
            }
            if ((i & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    public final void A4TApA() {
        if ((this.f899A4TApA & 4) != 0) {
            boolean isEmpty = TextUtils.isEmpty(this.f906AZkASS);
            Toolbar toolbar = this.f898A2egSU;
            if (isEmpty) {
                toolbar.setNavigationContentDescription(this.f910AmA8tU);
            } else {
                toolbar.setNavigationContentDescription(this.f906AZkASS);
            }
        }
    }

    public final void A5SV6n() {
        Drawable drawable;
        int i = this.f899A4TApA;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.AMqCpz;
            if (drawable == null) {
                drawable = this.f901ADYaiT;
            }
        } else {
            drawable = this.f901ADYaiT;
        }
        this.f898A2egSU.setLogo(drawable);
    }

    @Override // AaHO0E.DvK7DB
    public Context getContext() {
        return this.f898A2egSU.getContext();
    }
}
