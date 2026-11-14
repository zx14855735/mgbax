package OpB85q;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends FrameLayout implements AZOQYO {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f6660AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f6661AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f6662AmA8tU;

    @Override // AZkASS.BPw6Q8
    public final void A2egSU(AZkASS.B25kr6 b25kr6) {
        A4TApA();
    }

    public final void A4TApA() {
        setVisibility((!this.f6662AmA8tU || (!this.f6660AcNBzu && this.f6661AlLFFp)) ? 8 : 0);
    }

    @Override // AZkASS.BPw6Q8
    public AZkASS.B25kr6 getItemData() {
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setDividersEnabled(boolean z) {
        this.f6662AmA8tU = z;
        A4TApA();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
    }

    @Override // OpB85q.AZOQYO
    public void setExpanded(boolean z) {
        this.f6660AcNBzu = z;
        A4TApA();
    }

    public void setIcon(Drawable drawable) {
    }

    @Override // OpB85q.AZOQYO
    public void setOnlyShowWhenExpanded(boolean z) {
        this.f6661AlLFFp = z;
        A4TApA();
    }

    public void setTitle(CharSequence charSequence) {
    }
}
