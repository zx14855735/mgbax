package PcHFaG;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements View.OnLayoutChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ A4TApA f7408AcNBzu;

    public A2egSU(A4TApA a4TApA) {
        this.f7408AcNBzu = a4TApA;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        A4TApA a4TApA = this.f7408AcNBzu;
        a4TApA.getClass();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        a4TApA.f7421DG07BK = iArr[0];
        view.getWindowVisibleDisplayFrame(a4TApA.f7414D07BeM);
    }
}
