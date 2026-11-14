package AaHO0E;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CrfGsy extends FM663C implements CtxOCS {

    /* renamed from: CcAIMM, reason: collision with root package name */
    public CharSequence f705CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public CkXcdM f706Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public final Rect f707CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public int f708CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public final /* synthetic */ D07BeM f709CmUvjW;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrfGsy(D07BeM d07BeM, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969894);
        this.f709CmUvjW = d07BeM;
        this.f707CikNvS = new Rect();
        this.f835BNL6CD = d07BeM;
        this.f844CNPG0E = true;
        this.f845COJEAR.setFocusable(true);
        this.f836BPw6Q8 = new CmUvjW(0, this);
    }

    @Override // AaHO0E.CtxOCS
    public final CharSequence A5SV6n() {
        return this.f705CcAIMM;
    }

    @Override // AaHO0E.CtxOCS
    public final void ARc23Z(CharSequence charSequence) {
        this.f705CcAIMM = charSequence;
    }

    @Override // AaHO0E.CtxOCS
    public final void AZkASS(int i) {
        this.f708CkXcdM = i;
    }

    @Override // AaHO0E.CtxOCS
    public final void AaHO0E(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        BpkvW3 bpkvW3 = this.f845COJEAR;
        boolean isShowing = bpkvW3.isShowing();
        B25kr6();
        this.f845COJEAR.setInputMethodMode(2);
        show();
        EdQ5bb edQ5bb = this.f823AmA8tU;
        edQ5bb.setChoiceMode(1);
        edQ5bb.setTextDirection(i);
        edQ5bb.setTextAlignment(i2);
        D07BeM d07BeM = this.f709CmUvjW;
        int selectedItemPosition = d07BeM.getSelectedItemPosition();
        EdQ5bb edQ5bb2 = this.f823AmA8tU;
        if (bpkvW3.isShowing() && edQ5bb2 != null) {
            edQ5bb2.setListSelectionHidden(false);
            edQ5bb2.setSelection(selectedItemPosition);
            if (edQ5bb2.getChoiceMode() != 0) {
                edQ5bb2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (isShowing || (viewTreeObserver = d07BeM.getViewTreeObserver()) == null) {
            return;
        }
        AZkASS.A5SV6n a5SV6n = new AZkASS.A5SV6n(3, this);
        viewTreeObserver.addOnGlobalLayoutListener(a5SV6n);
        this.f845COJEAR.setOnDismissListener(new CqNSpT(this, a5SV6n));
    }

    @Override // AaHO0E.FM663C, AaHO0E.CtxOCS
    public final void AlLFFp(ListAdapter listAdapter) {
        super.AlLFFp(listAdapter);
        this.f706Cd8JRx = (CkXcdM) listAdapter;
    }

    public final void B25kr6() {
        int i;
        BpkvW3 bpkvW3 = this.f845COJEAR;
        Drawable background = bpkvW3.getBackground();
        D07BeM d07BeM = this.f709CmUvjW;
        if (background != null) {
            background.getPadding(d07BeM.f719B4ZgIw);
            boolean z = HSHyT0.f933A2egSU;
            int layoutDirection = d07BeM.getLayoutDirection();
            Rect rect = d07BeM.f719B4ZgIw;
            i = layoutDirection == 1 ? rect.right : -rect.left;
        } else {
            Rect rect2 = d07BeM.f719B4ZgIw;
            rect2.right = 0;
            rect2.left = 0;
            i = 0;
        }
        int paddingLeft = d07BeM.getPaddingLeft();
        int paddingRight = d07BeM.getPaddingRight();
        int width = d07BeM.getWidth();
        int i2 = d07BeM.f718B3GDIM;
        if (i2 == -2) {
            int A2egSU2 = d07BeM.A2egSU(this.f706Cd8JRx, bpkvW3.getBackground());
            int i3 = d07BeM.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = d07BeM.f719B4ZgIw;
            int i4 = (i3 - rect3.left) - rect3.right;
            if (A2egSU2 > i4) {
                A2egSU2 = i4;
            }
            AzWtSf(Math.max(A2egSU2, (width - paddingLeft) - paddingRight));
        } else if (i2 == -1) {
            AzWtSf((width - paddingLeft) - paddingRight);
        } else {
            AzWtSf(i2);
        }
        boolean z2 = HSHyT0.f933A2egSU;
        this.f826B2KMhB = d07BeM.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f825B25kr6) - this.f708CkXcdM) + i : paddingLeft + this.f708CkXcdM + i;
    }
}
