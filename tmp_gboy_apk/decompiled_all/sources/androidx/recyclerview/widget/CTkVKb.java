package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CTkVKb extends Cd8JRx {
    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int A4TApA(View view) {
        return this.f9325A2egSU.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((DG07BK) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int A5SV6n(View view) {
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        return this.f9325A2egSU.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin + ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int ADYaiT(View view) {
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        return this.f9325A2egSU.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) dg07bk).topMargin + ((ViewGroup.MarginLayoutParams) dg07bk).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AMqCpz(View view) {
        return this.f9325A2egSU.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((DG07BK) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int ARc23Z() {
        return this.f9325A2egSU.getWidth();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int ASJ6gh() {
        RecyclerView.ARc23Z aRc23Z = this.f9325A2egSU;
        return aRc23Z.getWidth() - aRc23Z.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AYUAbz() {
        return this.f9325A2egSU.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AZOQYO() {
        return this.f9325A2egSU.getWidthMode();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AZkASS() {
        return this.f9325A2egSU.getHeightMode();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AaHO0E() {
        return this.f9325A2egSU.getPaddingLeft();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AcNBzu() {
        RecyclerView.ARc23Z aRc23Z = this.f9325A2egSU;
        return (aRc23Z.getWidth() - aRc23Z.getPaddingLeft()) - aRc23Z.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AlLFFp(View view) {
        RecyclerView.ARc23Z aRc23Z = this.f9325A2egSU;
        Rect rect = this.f9327A5SV6n;
        aRc23Z.getTransformedBoundingBox(view, true, rect);
        return rect.right;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AmA8tU(View view) {
        RecyclerView.ARc23Z aRc23Z = this.f9325A2egSU;
        Rect rect = this.f9327A5SV6n;
        aRc23Z.getTransformedBoundingBox(view, true, rect);
        return rect.left;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final void AzWtSf(int i) {
        this.f9325A2egSU.offsetChildrenHorizontal(i);
    }
}
