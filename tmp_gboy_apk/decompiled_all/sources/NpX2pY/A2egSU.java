package NpX2pY;

import Oay4Bh.BmvVmW;
import Oay4Bh.BniPrB;
import Oay4Bh.C4FrIb;
import P3rngT.AMqCpz;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends Drawable implements BmvVmW {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final WeakReference f6072AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AaHO0E f6073AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final BniPrB f6074AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Rect f6075AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final A5SV6n f6076B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public float f6077B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public float f6078B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f6079B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public float f6080B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public float f6081B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public float f6082BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public WeakReference f6083BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public WeakReference f6084BIYEnU;

    public A2egSU(Context context, A4TApA a4TApA) {
        AMqCpz aMqCpz;
        WeakReference weakReference = new WeakReference(context);
        this.f6072AcNBzu = weakReference;
        C4FrIb.ARc23Z(context, C4FrIb.f6606A4TApA, "Theme.MaterialComponents");
        this.f6075AzWtSf = new Rect();
        BniPrB bniPrB = new BniPrB(this);
        this.f6074AmA8tU = bniPrB;
        TextPaint textPaint = bniPrB.f6599A2egSU;
        textPaint.setTextAlign(Paint.Align.CENTER);
        A5SV6n a5SV6n = new A5SV6n(context, a4TApA);
        this.f6076B25kr6 = a5SV6n;
        boolean ASJ6gh2 = ASJ6gh();
        A4TApA a4TApA2 = a5SV6n.f6116A4TApA;
        AaHO0E aaHO0E = new AaHO0E(B2KMhB.A2egSU(context, ASJ6gh2 ? a4TApA2.f6091B3GDIM.intValue() : a4TApA2.f6089B25kr6.intValue(), ASJ6gh() ? a4TApA2.f6092B4ZgIw.intValue() : a4TApA2.f6090B2KMhB.intValue()).A2egSU());
        this.f6073AlLFFp = aaHO0E;
        AZOQYO();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && bniPrB.f6604ASJ6gh != (aMqCpz = new AMqCpz(context2, a4TApA2.f6088AzWtSf.intValue()))) {
            bniPrB.A5SV6n(aMqCpz, context2);
            textPaint.setColor(a4TApA2.f6087AmA8tU.intValue());
            invalidateSelf();
            AaHO0E();
            invalidateSelf();
        }
        int i = a4TApA2.f6096BI9f7h;
        if (i != -2) {
            this.f6079B4ZgIw = ((int) Math.pow(10.0d, i - 1.0d)) - 1;
        } else {
            this.f6079B4ZgIw = a4TApA2.f6097BIYEnU;
        }
        bniPrB.AMqCpz = true;
        AaHO0E();
        invalidateSelf();
        bniPrB.AMqCpz = true;
        AZOQYO();
        AaHO0E();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(a4TApA2.f6086AlLFFp.intValue());
        if (aaHO0E.f7042AlLFFp.f7024ADYaiT != valueOf) {
            aaHO0E.B3GDIM(valueOf);
            invalidateSelf();
        }
        textPaint.setColor(a4TApA2.f6087AmA8tU.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.f6083BI9f7h;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.f6083BI9f7h.get();
            WeakReference weakReference3 = this.f6084BIYEnU;
            AZkASS(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        AaHO0E();
        setVisible(a4TApA2.f6104BniPrB.booleanValue(), false);
    }

    @Override // Oay4Bh.BmvVmW
    public final void A2egSU() {
        invalidateSelf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.ViewParent] */
    public final void A4TApA(View view, View view2) {
        float f;
        float f2;
        View view3;
        boolean z;
        FrameLayout AMqCpz = AMqCpz();
        if (AMqCpz == null) {
            float y = view.getY();
            f2 = view.getX();
            view3 = view.getParent();
            f = y;
        } else {
            f = 0.0f;
            f2 = 0.0f;
            view3 = AMqCpz;
        }
        while (true) {
            z = view3 instanceof View;
            if (!z || view3 == view2) {
                break;
            }
            ViewParent parent = view3.getParent();
            if (!(parent instanceof ViewGroup) || ((ViewGroup) parent).getClipChildren()) {
                break;
            }
            View view4 = view3;
            f += view4.getY();
            f2 += view4.getX();
            view3 = view3.getParent();
        }
        if (z) {
            float f3 = (this.f6078B3GDIM - this.f6082BChYOn) + f;
            float f4 = (this.f6077B2KMhB - this.f6081B9tovu) + f2;
            View view5 = view3;
            float height = ((this.f6078B3GDIM + this.f6082BChYOn) - view5.getHeight()) + f;
            float width = ((this.f6077B2KMhB + this.f6081B9tovu) - view5.getWidth()) + f2;
            if (f3 < 0.0f) {
                this.f6078B3GDIM = Math.abs(f3) + this.f6078B3GDIM;
            }
            if (f4 < 0.0f) {
                this.f6077B2KMhB = Math.abs(f4) + this.f6077B2KMhB;
            }
            if (height > 0.0f) {
                this.f6078B3GDIM -= Math.abs(height);
            }
            if (width > 0.0f) {
                this.f6077B2KMhB -= Math.abs(width);
            }
        }
    }

    public final String A5SV6n() {
        int i = this.f6079B4ZgIw;
        A5SV6n a5SV6n = this.f6076B25kr6;
        A4TApA a4TApA = a5SV6n.f6116A4TApA;
        String str = a4TApA.f6094B9tovu;
        boolean z = str != null;
        WeakReference weakReference = this.f6072AcNBzu;
        if (!z) {
            if (!AYUAbz()) {
                return null;
            }
            A4TApA a4TApA2 = a5SV6n.f6116A4TApA;
            if (i == -2 || ARc23Z() <= i) {
                return NumberFormat.getInstance(a4TApA2.f6098BJ7GGh).format(ARc23Z());
            }
            Context context = (Context) weakReference.get();
            return context == null ? "" : String.format(a4TApA2.f6098BJ7GGh, context.getString(2131886565), Integer.valueOf(i), "+");
        }
        int i2 = a4TApA.f6096BI9f7h;
        if (i2 == -2 || str == null || str.length() <= i2) {
            return str;
        }
        Context context2 = (Context) weakReference.get();
        if (context2 == null) {
            return "";
        }
        return String.format(context2.getString(2131886490), str.substring(0, i2 - 1), "…");
    }

    public final CharSequence ADYaiT() {
        Context context;
        int i = this.f6079B4ZgIw;
        if (!isVisible()) {
            return null;
        }
        A5SV6n a5SV6n = this.f6076B25kr6;
        A4TApA a4TApA = a5SV6n.f6116A4TApA;
        String str = a4TApA.f6094B9tovu;
        if (str != null) {
            String str2 = a4TApA.f6099BNL6CD;
            return str2 != null ? str2 : str;
        }
        boolean AYUAbz2 = AYUAbz();
        A4TApA a4TApA2 = a5SV6n.f6116A4TApA;
        if (!AYUAbz2) {
            return a4TApA2.f6100BPw6Q8;
        }
        if (a4TApA2.f6101BTvldC == 0 || (context = (Context) this.f6072AcNBzu.get()) == null) {
            return null;
        }
        return (i == -2 || ARc23Z() <= i) ? context.getResources().getQuantityString(a4TApA2.f6101BTvldC, ARc23Z(), Integer.valueOf(ARc23Z())) : context.getString(a4TApA2.f6102BV3sI0, Integer.valueOf(i));
    }

    public final FrameLayout AMqCpz() {
        WeakReference weakReference = this.f6084BIYEnU;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public final int ARc23Z() {
        int i = this.f6076B25kr6.f6116A4TApA.f6095BChYOn;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    public final boolean ASJ6gh() {
        return this.f6076B25kr6.f6116A4TApA.f6094B9tovu != null || AYUAbz();
    }

    public final boolean AYUAbz() {
        A4TApA a4TApA = this.f6076B25kr6.f6116A4TApA;
        return a4TApA.f6094B9tovu == null && a4TApA.f6095BChYOn != -1;
    }

    public final void AZOQYO() {
        Context context = (Context) this.f6072AcNBzu.get();
        if (context == null) {
            return;
        }
        boolean ASJ6gh2 = ASJ6gh();
        A5SV6n a5SV6n = this.f6076B25kr6;
        this.f6073AlLFFp.setShapeAppearanceModel(B2KMhB.A2egSU(context, ASJ6gh2 ? a5SV6n.f6116A4TApA.f6091B3GDIM.intValue() : a5SV6n.f6116A4TApA.f6089B25kr6.intValue(), ASJ6gh() ? a5SV6n.f6116A4TApA.f6092B4ZgIw.intValue() : a5SV6n.f6116A4TApA.f6090B2KMhB.intValue()).A2egSU());
        invalidateSelf();
    }

    public final void AZkASS(View view, FrameLayout frameLayout) {
        this.f6083BI9f7h = new WeakReference(view);
        this.f6084BIYEnU = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        AaHO0E();
        invalidateSelf();
    }

    public final void AaHO0E() {
        float f;
        WeakReference weakReference = this.f6072AcNBzu;
        Context context = (Context) weakReference.get();
        WeakReference weakReference2 = this.f6083BI9f7h;
        View view = weakReference2 != null ? (View) weakReference2.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = this.f6075AzWtSf;
        rect.set(rect2);
        Rect rect3 = new Rect();
        view.getDrawingRect(rect3);
        WeakReference weakReference3 = this.f6084BIYEnU;
        ViewGroup viewGroup = weakReference3 != null ? (ViewGroup) weakReference3.get() : null;
        if (viewGroup != null) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect3);
        }
        boolean ASJ6gh2 = ASJ6gh();
        A5SV6n a5SV6n = this.f6076B25kr6;
        float f2 = ASJ6gh2 ? a5SV6n.f6118ADYaiT : a5SV6n.f6117A5SV6n;
        this.f6080B7CMnp = f2;
        if (f2 != -1.0f) {
            this.f6081B9tovu = f2;
            this.f6082BChYOn = f2;
        } else {
            this.f6081B9tovu = Math.round((ASJ6gh() ? a5SV6n.f6120ASJ6gh : a5SV6n.AMqCpz) / 2.0f);
            this.f6082BChYOn = Math.round((ASJ6gh() ? a5SV6n.f6121AYUAbz : a5SV6n.f6119ARc23Z) / 2.0f);
        }
        if (ASJ6gh()) {
            String A5SV6n2 = A5SV6n();
            float f3 = this.f6081B9tovu;
            BniPrB bniPrB = this.f6074AmA8tU;
            this.f6081B9tovu = Math.max(f3, (bniPrB.A2egSU(A5SV6n2) / 2.0f) + a5SV6n.f6116A4TApA.BpkvW3.intValue());
            float f4 = this.f6082BChYOn;
            if (bniPrB.AMqCpz) {
                bniPrB.A4TApA(A5SV6n2);
                f = bniPrB.f6602ADYaiT;
            } else {
                f = bniPrB.f6602ADYaiT;
            }
            float max = Math.max(f4, (f / 2.0f) + a5SV6n.f6116A4TApA.f6105C2rE4F.intValue());
            this.f6082BChYOn = max;
            this.f6081B9tovu = Math.max(this.f6081B9tovu, max);
        }
        int intValue = a5SV6n.f6116A4TApA.f6107CASmeH.intValue();
        boolean ASJ6gh3 = ASJ6gh();
        A4TApA a4TApA = a5SV6n.f6116A4TApA;
        if (ASJ6gh3) {
            intValue = a4TApA.f6109COJEAR.intValue();
            Context context2 = (Context) weakReference.get();
            if (context2 != null) {
                intValue = NdEzCJ.A2egSU.A5SV6n(NdEzCJ.A2egSU.A4TApA(0.0f, 1.0f, 0.3f, 1.0f, context2.getResources().getConfiguration().fontScale - 1.0f), intValue, intValue - a4TApA.f6112CTkVKb.intValue());
            }
        }
        int i = a5SV6n.f6124AaHO0E;
        if (i == 0) {
            intValue -= Math.round(this.f6082BChYOn);
        }
        int intValue2 = a4TApA.f6111CSDoyG.intValue() + intValue;
        int intValue3 = a4TApA.f6103BmvVmW.intValue();
        if (intValue3 == 8388691 || intValue3 == 8388693) {
            this.f6078B3GDIM = rect3.bottom - intValue2;
        } else {
            this.f6078B3GDIM = rect3.top + intValue2;
        }
        int intValue4 = ASJ6gh() ? a4TApA.f6108CNPG0E.intValue() : a4TApA.f6106C4FrIb.intValue();
        if (i == 1) {
            intValue4 += ASJ6gh() ? a5SV6n.f6123AZkASS : a5SV6n.f6122AZOQYO;
        }
        int intValue5 = a4TApA.f6110CQhlFr.intValue() + intValue4;
        int intValue6 = a4TApA.f6103BmvVmW.intValue();
        if (intValue6 == 8388659 || intValue6 == 8388691) {
            this.f6077B2KMhB = a5SV6n.f6125AcNBzu == 0 ? view.getLayoutDirection() == 0 ? (rect3.left + this.f6081B9tovu) - ((this.f6082BChYOn * 2.0f) - intValue5) : (rect3.right - this.f6081B9tovu) + ((this.f6082BChYOn * 2.0f) - intValue5) : view.getLayoutDirection() == 0 ? (rect3.left - this.f6081B9tovu) + intValue5 : (rect3.right + this.f6081B9tovu) - intValue5;
        } else {
            this.f6077B2KMhB = a5SV6n.f6125AcNBzu == 0 ? view.getLayoutDirection() == 0 ? (rect3.right + this.f6081B9tovu) - intValue5 : (rect3.left - this.f6081B9tovu) + intValue5 : view.getLayoutDirection() == 0 ? (rect3.right - this.f6081B9tovu) + ((this.f6082BChYOn * 2.0f) - intValue5) : (rect3.left + this.f6081B9tovu) - ((this.f6082BChYOn * 2.0f) - intValue5);
        }
        if (a4TApA.f6113CcAIMM.booleanValue()) {
            ViewParent AMqCpz = AMqCpz();
            if (AMqCpz == null) {
                AMqCpz = view.getParent();
            }
            if ((AMqCpz instanceof View) && (AMqCpz.getParent() instanceof View)) {
                A4TApA(view, (View) AMqCpz.getParent());
            }
        } else {
            A4TApA(view, null);
        }
        float f5 = this.f6077B2KMhB;
        float f6 = this.f6078B3GDIM;
        float f7 = this.f6081B9tovu;
        float f8 = this.f6082BChYOn;
        rect2.set((int) (f5 - f7), (int) (f6 - f8), (int) (f5 + f7), (int) (f6 + f8));
        float f9 = this.f6080B7CMnp;
        AaHO0E aaHO0E = this.f6073AlLFFp;
        if (f9 != -1.0f) {
            B2KMhB.A2egSU ASJ6gh4 = aaHO0E.f7042AlLFFp.f7021A2egSU.ASJ6gh();
            ASJ6gh4.A5SV6n(f9);
            aaHO0E.setShapeAppearanceModel(ASJ6gh4.A2egSU());
        }
        if (rect.equals(rect2)) {
            return;
        }
        aaHO0E.setBounds(rect2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String A5SV6n2;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f6073AlLFFp.draw(canvas);
        if (!ASJ6gh() || (A5SV6n2 = A5SV6n()) == null) {
            return;
        }
        Rect rect = new Rect();
        BniPrB bniPrB = this.f6074AmA8tU;
        bniPrB.f6599A2egSU.getTextBounds(A5SV6n2, 0, A5SV6n2.length(), rect);
        float exactCenterY = this.f6078B3GDIM - rect.exactCenterY();
        canvas.drawText(A5SV6n2, this.f6077B2KMhB, rect.bottom <= 0 ? (int) exactCenterY : Math.round(exactCenterY), bniPrB.f6599A2egSU);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6076B25kr6.f6116A4TApA.f6093B7CMnp;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6075AzWtSf.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f6075AzWtSf.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, Oay4Bh.BmvVmW
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        A5SV6n a5SV6n = this.f6076B25kr6;
        a5SV6n.f6115A2egSU.f6093B7CMnp = i;
        a5SV6n.f6116A4TApA.f6093B7CMnp = i;
        this.f6074AmA8tU.f6599A2egSU.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
