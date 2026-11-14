package OpB85q;

import ADYaiT.DUi7mC;
import AaHO0E.GYpKKt;
import COJEAR.Ddcejp;
import COJEAR.DyaChj;
import Oay4Bh.BI9f7h;
import Oay4Bh.BPw6Q8;
import PCV8se.B2KMhB;
import PCV8se.BTvldC;
import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.NavigationMenuView;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class B9tovu extends BPw6Q8 implements Ogw3zR.A4TApA {

    /* renamed from: COJEAR, reason: collision with root package name */
    public static final int[] f6798COJEAR = {R.attr.state_checked};

    /* renamed from: CQhlFr, reason: collision with root package name */
    public static final int[] f6799CQhlFr = {-16842910};

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Oay4Bh.AcNBzu f6800B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final BI9f7h f6801B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public B4ZgIw f6802B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final int f6803BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final int[] f6804BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public AZOQYO.AZkASS f6805BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final Mt2q9w.ARc23Z f6806BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f6807BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f6808BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f6809BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f6810BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f6811BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final boolean f6812BniPrB;
    public final int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final BTvldC f6813C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final Ogw3zR.AZkASS f6814C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final DUi7mC f6815CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final B3GDIM f6816CNPG0E;

    static {
        RDiyv();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public B9tovu(android.content.Context r19, android.util.AttributeSet r20) {
        /*
            Method dump skipped, instructions count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OpB85q.B9tovu.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private static /* synthetic */ void RDiyv() {
        char[] charArray = "\r\u0001\u0003@\t\u000f\u0003\u000b@\f\u0001\u0017@\u001d\u0006\u000b\u0002\u0002@$\u0000\u0007,\u001c\u0007\n\t\u000b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'n');
        }
        String str = new String(charArray);
        char[] charArray2 = "\r\u0002\u0007\u0000\u0007\u001a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'n');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private MenuInflater getMenuInflater() {
        if (this.f6805BIYEnU == null) {
            this.f6805BIYEnU = new AZOQYO.AZkASS(getContext());
        }
        return this.f6805BIYEnU;
    }

    @Override // Ogw3zR.A4TApA
    public final void A2egSU(androidx.activity.A4TApA a4TApA) {
        AZkASS();
        this.f6814C4FrIb.f6641ARc23Z = a4TApA;
    }

    @Override // Ogw3zR.A4TApA
    public final void A4TApA(androidx.activity.A4TApA a4TApA) {
        int i = ((CrfGsy.ADYaiT) AZkASS().second).f1861A2egSU;
        Ogw3zR.AZkASS aZkASS = this.f6814C4FrIb;
        androidx.activity.A4TApA a4TApA2 = aZkASS.f6641ARc23Z;
        aZkASS.f6641ARc23Z = a4TApA;
        float f = a4TApA.f7937A5SV6n;
        if (a4TApA2 != null) {
            aZkASS.A5SV6n(f, a4TApA.f7938ADYaiT == 0, i);
        }
        if (this.f6812BniPrB) {
            this.f6811BmvVmW = NdEzCJ.A2egSU.A5SV6n(aZkASS.f6637A2egSU.getInterpolation(f), 0, this.BpkvW3);
            AZOQYO(getWidth(), getHeight());
        }
    }

    @Override // Ogw3zR.A4TApA
    public final void A5SV6n() {
        Pair AZkASS2 = AZkASS();
        DrawerLayout drawerLayout = (DrawerLayout) AZkASS2.first;
        Ogw3zR.AZkASS aZkASS = this.f6814C4FrIb;
        androidx.activity.A4TApA a4TApA = aZkASS.f6641ARc23Z;
        aZkASS.f6641ARc23Z = null;
        if (a4TApA == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.A5SV6n(this, true);
            return;
        }
        int i = ((CrfGsy.ADYaiT) AZkASS2.second).f1861A2egSU;
        int i2 = A4TApA.f6659A2egSU;
        aZkASS.A4TApA(a4TApA, i, new DyaChj((View) this, 3, (Object) drawerLayout), new Ddcejp(3, drawerLayout));
    }

    @Override // Ogw3zR.A4TApA
    public final void ADYaiT() {
        AZkASS();
        this.f6814C4FrIb.A2egSU();
        if (!this.f6812BniPrB || this.f6811BmvVmW == 0) {
            return;
        }
        this.f6811BmvVmW = 0;
        AZOQYO(getWidth(), getHeight());
    }

    public final ColorStateList AMqCpz(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList A5SV6n2 = BPw6Q8.ASJ6gh.A5SV6n(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(2130968881, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = A5SV6n2.getDefaultColor();
        int[] iArr = f6799CQhlFr;
        return new ColorStateList(new int[][]{iArr, f6798COJEAR, FrameLayout.EMPTY_STATE_SET}, new int[]{A5SV6n2.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    public final InsetDrawable ARc23Z(GYpKKt gYpKKt, ColorStateList colorStateList) {
        TypedArray typedArray = gYpKKt.f884A4TApA;
        PCV8se.AaHO0E aaHO0E = new PCV8se.AaHO0E(PCV8se.B2KMhB.A2egSU(getContext(), typedArray.getResourceId(18, 0), typedArray.getResourceId(19, 0)).A2egSU());
        aaHO0E.B3GDIM(colorStateList);
        return new InsetDrawable((Drawable) aaHO0E, typedArray.getDimensionPixelSize(23, 0), typedArray.getDimensionPixelSize(24, 0), typedArray.getDimensionPixelSize(22, 0), typedArray.getDimensionPixelSize(21, 0));
    }

    public abstract View ASJ6gh(int i);

    public abstract void AYUAbz(int i);

    public final void AZOQYO(int i, int i2) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof CrfGsy.ADYaiT)) {
            if ((this.f6811BmvVmW > 0 || this.f6812BniPrB) && (getBackground() instanceof PCV8se.AaHO0E)) {
                boolean z = Gravity.getAbsoluteGravity(((CrfGsy.ADYaiT) getLayoutParams()).f1861A2egSU, getLayoutDirection()) == 3;
                PCV8se.AaHO0E aaHO0E = (PCV8se.AaHO0E) getBackground();
                B2KMhB.A2egSU ASJ6gh2 = aaHO0E.f7042AlLFFp.f7021A2egSU.ASJ6gh();
                ASJ6gh2.A5SV6n(this.f6811BmvVmW);
                if (z) {
                    ASJ6gh2.ARc23Z(0.0f);
                    ASJ6gh2.ADYaiT(0.0f);
                } else {
                    ASJ6gh2.ASJ6gh(0.0f);
                    ASJ6gh2.AMqCpz(0.0f);
                }
                PCV8se.B2KMhB A2egSU2 = ASJ6gh2.A2egSU();
                aaHO0E.setShapeAppearanceModel(A2egSU2);
                BTvldC bTvldC = this.f6813C2rE4F;
                bTvldC.f7142A5SV6n = A2egSU2;
                bTvldC.A5SV6n();
                bTvldC.A2egSU(this);
                bTvldC.f7143ADYaiT = new RectF(0.0f, 0.0f, i, i2);
                bTvldC.A5SV6n();
                bTvldC.A2egSU(this);
                bTvldC.f7141A4TApA = true;
                bTvldC.A2egSU(this);
            }
        }
    }

    public final Pair AZkASS() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof CrfGsy.ADYaiT)) {
            return new Pair((DrawerLayout) parent, (CrfGsy.ADYaiT) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        BTvldC bTvldC = this.f6813C2rE4F;
        if (bTvldC.A4TApA()) {
            Path path = bTvldC.AMqCpz;
            if (!path.isEmpty()) {
                canvas.save();
                canvas.clipPath(path);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
        }
        super.dispatchDraw(canvas);
    }

    public Ogw3zR.AZkASS getBackHelper() {
        return this.f6814C4FrIb;
    }

    public MenuItem getCheckedItem() {
        return this.f6801B7CMnp.f6550B25kr6.f6538AlLFFp;
    }

    public int getDividerInsetEnd() {
        return this.f6801B7CMnp.f6565BniPrB;
    }

    public int getDividerInsetStart() {
        return this.f6801B7CMnp.f6564BmvVmW;
    }

    public int getHeaderCount() {
        return this.f6801B7CMnp.f6547AlLFFp.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.f6801B7CMnp.f6558BIYEnU;
    }

    public int getItemHorizontalPadding() {
        return this.f6801B7CMnp.f6560BNL6CD;
    }

    public int getItemIconPadding() {
        return this.f6801B7CMnp.f6562BTvldC;
    }

    public ColorStateList getItemIconTintList() {
        return this.f6801B7CMnp.f6557BI9f7h;
    }

    public int getItemMaxLines() {
        return this.f6801B7CMnp.f6569CNPG0E;
    }

    public ColorStateList getItemTextColor() {
        return this.f6801B7CMnp.f6556BChYOn;
    }

    public int getItemVerticalPadding() {
        return this.f6801B7CMnp.f6561BPw6Q8;
    }

    public Menu getMenu() {
        return this.f6800B4ZgIw;
    }

    public int getSubheaderInsetEnd() {
        return this.f6801B7CMnp.f6566C2rE4F;
    }

    public int getSubheaderInsetStart() {
        return this.f6801B7CMnp.BpkvW3;
    }

    @Override // Oay4Bh.BPw6Q8, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        NOd7IU.AlLFFp.D07BeM(this);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            DUi7mC dUi7mC = this.f6815CASmeH;
            if (((Ogw3zR.A5SV6n) dUi7mC.f239AlLFFp) != null) {
                DrawerLayout drawerLayout = (DrawerLayout) parent;
                B3GDIM b3gdim = this.f6816CNPG0E;
                if (b3gdim == null) {
                    drawerLayout.getClass();
                } else {
                    ArrayList arrayList = drawerLayout.f8638BniPrB;
                    if (arrayList != null) {
                        arrayList.remove(b3gdim);
                    }
                }
                drawerLayout.A2egSU(b3gdim);
                if (DrawerLayout.AcNBzu(this)) {
                    dUi7mC.BChYOn(true);
                }
            }
        }
    }

    @Override // Oay4Bh.BPw6Q8, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f6806BJ7GGh);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            B3GDIM b3gdim = this.f6816CNPG0E;
            if (b3gdim == null) {
                drawerLayout.getClass();
            } else {
                ArrayList arrayList = drawerLayout.f8638BniPrB;
                if (arrayList != null) {
                    arrayList.remove(b3gdim);
                }
            }
        }
        this.f6815CASmeH.BIYEnU();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int i3 = this.f6803BChYOn;
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), i3), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof B7CMnp)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        B7CMnp b7CMnp = (B7CMnp) parcelable;
        super.onRestoreInstanceState(b7CMnp.getSuperState());
        this.f6800B4ZgIw.B7CMnp(b7CMnp.f6797AcNBzu);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        B7CMnp b7CMnp = new B7CMnp(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        b7CMnp.f6797AcNBzu = bundle;
        this.f6800B4ZgIw.BChYOn(bundle);
        return b7CMnp;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        AZOQYO(i, i2);
    }

    public void setBottomInsetScrimEnabled(boolean z) {
        this.f6808BPw6Q8 = z;
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f6800B4ZgIw.findItem(i);
        if (findItem != null) {
            this.f6801B7CMnp.f6550B25kr6.A4TApA((AZkASS.B25kr6) findItem);
        }
    }

    public void setDividerInsetEnd(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6565BniPrB = i;
        bI9f7h.AMqCpz();
    }

    public void setDividerInsetStart(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6564BmvVmW = i;
        bI9f7h.AMqCpz();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        NOd7IU.AlLFFp.CtFAbx(this, f);
    }

    public void setEndInsetScrimEnabled(boolean z) {
        this.f6810BV3sI0 = z;
    }

    public void setForceCompatClippingEnabled(boolean z) {
        BTvldC bTvldC = this.f6813C2rE4F;
        if (z != bTvldC.f7140A2egSU) {
            bTvldC.f7140A2egSU = z;
            bTvldC.A2egSU(this);
        }
    }

    public void setItemBackground(Drawable drawable) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6558BIYEnU = drawable;
        bI9f7h.AlLFFp();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(getContext().getDrawable(i));
    }

    public void setItemHorizontalPadding(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6560BNL6CD = i;
        bI9f7h.AlLFFp();
    }

    public void setItemHorizontalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6560BNL6CD = dimensionPixelSize;
        bI9f7h.AlLFFp();
    }

    public void setItemIconPadding(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6562BTvldC = i;
        bI9f7h.AlLFFp();
    }

    public void setItemIconPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6562BTvldC = dimensionPixelSize;
        bI9f7h.AlLFFp();
    }

    public void setItemIconSize(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        if (bI9f7h.f6563BV3sI0 != i) {
            bI9f7h.f6563BV3sI0 = i;
            bI9f7h.f6567C4FrIb = true;
            bI9f7h.AlLFFp();
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6557BI9f7h = colorStateList;
        bI9f7h.AlLFFp();
    }

    public void setItemMaxLines(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6569CNPG0E = i;
        bI9f7h.AlLFFp();
    }

    public void setItemTextAppearance(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6554B7CMnp = i;
        bI9f7h.AlLFFp();
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6555B9tovu = z;
        bI9f7h.AlLFFp();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6556BChYOn = colorStateList;
        bI9f7h.AlLFFp();
    }

    public void setItemVerticalPadding(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6561BPw6Q8 = i;
        bI9f7h.AlLFFp();
    }

    public void setItemVerticalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6561BPw6Q8 = dimensionPixelSize;
        bI9f7h.AlLFFp();
    }

    public void setNavigationItemSelectedListener(B4ZgIw b4ZgIw) {
        this.f6802B9tovu = b4ZgIw;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        BI9f7h bI9f7h = this.f6801B7CMnp;
        if (bI9f7h != null) {
            bI9f7h.f6572CSDoyG = i;
            NavigationMenuView navigationMenuView = bI9f7h.f6546AcNBzu;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    public void setStartInsetScrimEnabled(boolean z) {
        this.f6809BTvldC = z;
    }

    public void setSubheaderInsetEnd(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.f6566C2rE4F = i;
        bI9f7h.AcNBzu();
    }

    public void setSubheaderInsetStart(int i) {
        BI9f7h bI9f7h = this.f6801B7CMnp;
        bI9f7h.BpkvW3 = i;
        bI9f7h.AcNBzu();
    }

    public void setTopInsetScrimEnabled(boolean z) {
        this.f6807BNL6CD = z;
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f6800B4ZgIw.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f6801B7CMnp.f6550B25kr6.A4TApA((AZkASS.B25kr6) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
