package AaHO0E;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D07BeM extends Spinner {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final int[] f711B7CMnp = {R.attr.spinnerMode};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f712AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Context f713AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final CTkVKb f714AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public SpinnerAdapter f715AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final boolean f716B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final CtxOCS f717B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f718B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Rect f719B4ZgIw;

    static {
        fAoTWoT();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        if (r7 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public D07BeM(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r12 = this;
            r0 = 2130969894(0x7f040526, float:1.7548483E38)
            r12.<init>(r13, r14, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r12.f719B4ZgIw = r1
            android.content.Context r1 = r12.getContext()
            AaHO0E.GIi2tl.A2egSU(r1, r12)
            int[] r1 = androidx.appcompat.R$styleable.f8034BChYOn
            AaHO0E.GYpKKt r2 = AaHO0E.GYpKKt.ARc23Z(r13, r14, r1, r0)
            AaHO0E.B7CMnp r3 = new AaHO0E.B7CMnp
            r3.<init>(r12)
            r12.f712AcNBzu = r3
            android.content.res.TypedArray r3 = r2.f884A4TApA
            r4 = 4
            r5 = 0
            int r4 = r3.getResourceId(r4, r5)
            if (r4 == 0) goto L33
            AZOQYO.ADYaiT r6 = new AZOQYO.ADYaiT
            r6.<init>(r13, r4)
            r12.f713AlLFFp = r6
            goto L35
        L33:
            r12.f713AlLFFp = r13
        L35:
            r4 = -1
            r6 = 0
            int[] r7 = AaHO0E.D07BeM.f711B7CMnp     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            android.content.res.TypedArray r7 = r13.obtainStyledAttributes(r14, r7, r0, r5)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            boolean r8 = r7.hasValue(r5)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r8 == 0) goto L4d
            int r4 = r7.getInt(r5, r5)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            goto L4d
        L48:
            r13 = move-exception
            r6 = r7
            goto L56
        L4b:
            goto L5c
        L4d:
            r7.recycle()
            goto L5f
        L51:
            r13 = move-exception
            goto L56
        L53:
            r7 = r6
            goto L5c
        L56:
            if (r6 == 0) goto L5b
            r6.recycle()
        L5b:
            throw r13
        L5c:
            if (r7 == 0) goto L5f
            goto L4d
        L5f:
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L97
            if (r4 == r8) goto L66
            goto La4
        L66:
            AaHO0E.CrfGsy r4 = new AaHO0E.CrfGsy
            android.content.Context r9 = r12.f713AlLFFp
            r4.<init>(r12, r9, r14)
            android.content.Context r9 = r12.f713AlLFFp
            AaHO0E.GYpKKt r1 = AaHO0E.GYpKKt.ARc23Z(r9, r14, r1, r0)
            r9 = 3
            r10 = -2
            android.content.res.TypedArray r11 = r1.f884A4TApA
            int r9 = r11.getLayoutDimension(r9, r10)
            r12.f718B3GDIM = r9
            android.graphics.drawable.Drawable r9 = r1.A4TApA(r8)
            r4.ASJ6gh(r9)
            java.lang.String r7 = r3.getString(r7)
            r4.f705CcAIMM = r7
            r1.ASJ6gh()
            r12.f717B2KMhB = r4
            AaHO0E.CTkVKb r1 = new AaHO0E.CTkVKb
            r1.<init>(r12, r12, r4)
            r12.f714AmA8tU = r1
            goto La4
        L97:
            AaHO0E.Cd8JRx r1 = new AaHO0E.Cd8JRx
            r1.<init>(r12)
            r12.f717B2KMhB = r1
            java.lang.String r4 = r3.getString(r7)
            r1.f697AmA8tU = r4
        La4:
            java.lang.CharSequence[] r1 = r3.getTextArray(r5)
            if (r1 == 0) goto Lbb
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r13, r4, r1)
            r13 = 2131493347(0x7f0c01e3, float:1.8610172E38)
            r3.setDropDownViewResource(r13)
            r12.setAdapter(r3)
        Lbb:
            r2.ASJ6gh()
            r12.f716B25kr6 = r8
            android.widget.SpinnerAdapter r13 = r12.f715AzWtSf
            if (r13 == 0) goto Lc9
            r12.setAdapter(r13)
            r12.f715AzWtSf = r6
        Lc9:
            AaHO0E.B7CMnp r13 = r12.f712AcNBzu
            r13.ADYaiT(r14, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.D07BeM.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private static /* synthetic */ void fAoTWoT() {
        char[] charArray = "\u001d\u0011\u0013P\u0019\u001f\u0013\u001bP\u001c\u0011\u0007P\r\u0016\u001b\u0012\u0012P4\u0010\u0017<\f\u0017\u001a\u0019\u001b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '~');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001d\u0012\u0017\u0010\u0017\n".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '~');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int A2egSU(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        Rect rect = this.f719B4ZgIw;
        drawable.getPadding(rect);
        return rect.left + rect.right + i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.f712AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        CtxOCS ctxOCS = this.f717B2KMhB;
        return ctxOCS != null ? ctxOCS.A2egSU() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        CtxOCS ctxOCS = this.f717B2KMhB;
        return ctxOCS != null ? ctxOCS.AcNBzu() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f717B2KMhB != null ? this.f718B3GDIM : super.getDropDownWidth();
    }

    public final CtxOCS getInternalPopup() {
        return this.f717B2KMhB;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        CtxOCS ctxOCS = this.f717B2KMhB;
        return ctxOCS != null ? ctxOCS.ADYaiT() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f713AlLFFp;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        CtxOCS ctxOCS = this.f717B2KMhB;
        return ctxOCS != null ? ctxOCS.A5SV6n() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f712AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f712AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CtxOCS ctxOCS = this.f717B2KMhB;
        if (ctxOCS == null || !ctxOCS.isShowing()) {
            return;
        }
        ctxOCS.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f717B2KMhB == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), A2egSU(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        CtFAbx ctFAbx = (CtFAbx) parcelable;
        super.onRestoreInstanceState(ctFAbx.getSuperState());
        if (!ctFAbx.f710AcNBzu || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new AZkASS.A5SV6n(2, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        CtFAbx ctFAbx = new CtFAbx(super.onSaveInstanceState());
        CtxOCS ctxOCS = this.f717B2KMhB;
        ctFAbx.f710AcNBzu = ctxOCS != null && ctxOCS.isShowing();
        return ctFAbx;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        CTkVKb cTkVKb = this.f714AmA8tU;
        if (cTkVKb == null || !cTkVKb.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        CtxOCS ctxOCS = this.f717B2KMhB;
        if (ctxOCS == null) {
            return super.performClick();
        }
        if (ctxOCS.isShowing()) {
            return true;
        }
        this.f717B2KMhB.AaHO0E(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f712AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f712AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        CtxOCS ctxOCS = this.f717B2KMhB;
        if (ctxOCS == null) {
            super.setDropDownHorizontalOffset(i);
        } else {
            ctxOCS.AZkASS(i);
            ctxOCS.A4TApA(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        CtxOCS ctxOCS = this.f717B2KMhB;
        if (ctxOCS != null) {
            ctxOCS.AYUAbz(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f717B2KMhB != null) {
            this.f718B3GDIM = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        CtxOCS ctxOCS = this.f717B2KMhB;
        if (ctxOCS != null) {
            ctxOCS.ASJ6gh(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(NOd7IU.AlLFFp.CQhlFr(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        CtxOCS ctxOCS = this.f717B2KMhB;
        if (ctxOCS != null) {
            ctxOCS.ARc23Z(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.f712AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f712AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f716B25kr6) {
            this.f715AzWtSf = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        CtxOCS ctxOCS = this.f717B2KMhB;
        if (ctxOCS != null) {
            Context context = this.f713AlLFFp;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            CkXcdM ckXcdM = new CkXcdM();
            ckXcdM.f699A2egSU = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                ckXcdM.f700A4TApA = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && CikNvS.BIYEnU(spinnerAdapter)) {
                CcAIMM.A2egSU(CikNvS.AcNBzu(spinnerAdapter), theme);
            }
            ctxOCS.AlLFFp(ckXcdM);
        }
    }
}
