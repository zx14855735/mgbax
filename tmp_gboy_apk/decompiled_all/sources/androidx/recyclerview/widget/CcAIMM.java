package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CcAIMM extends Cd8JRx {
    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int A4TApA(View view) {
        return this.f9325A2egSU.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((DG07BK) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int A5SV6n(View view) {
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        return this.f9325A2egSU.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) dg07bk).topMargin + ((ViewGroup.MarginLayoutParams) dg07bk).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int ADYaiT(View view) {
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        return this.f9325A2egSU.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin + ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AMqCpz(View view) {
        return this.f9325A2egSU.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((DG07BK) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int ARc23Z() {
        return this.f9325A2egSU.getHeight();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int ASJ6gh() {
        RecyclerView.ARc23Z aRc23Z = this.f9325A2egSU;
        return aRc23Z.getHeight() - aRc23Z.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AYUAbz() {
        return this.f9325A2egSU.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AZOQYO() {
        return this.f9325A2egSU.getHeightMode();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AZkASS() {
        return this.f9325A2egSU.getWidthMode();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AaHO0E() {
        return this.f9325A2egSU.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AcNBzu() {
        RecyclerView.ARc23Z aRc23Z = this.f9325A2egSU;
        return (aRc23Z.getHeight() - aRc23Z.getPaddingTop()) - aRc23Z.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AlLFFp(View view) {
        RecyclerView.ARc23Z aRc23Z = this.f9325A2egSU;
        Rect rect = this.f9327A5SV6n;
        aRc23Z.getTransformedBoundingBox(view, true, rect);
        return rect.bottom;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final int AmA8tU(View view) {
        RecyclerView.ARc23Z aRc23Z = this.f9325A2egSU;
        Rect rect = this.f9327A5SV6n;
        aRc23Z.getTransformedBoundingBox(view, true, rect);
        return rect.top;
    }

    @Override // androidx.recyclerview.widget.Cd8JRx
    public final void AzWtSf(int i) {
        this.f9325A2egSU.offsetChildrenVertical(i);
    }
}
