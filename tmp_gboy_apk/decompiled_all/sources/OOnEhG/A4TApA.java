package OOnEhG;

import ADYaiT.AZOQYO;
import ADYaiT.AlLFFp;
import ADYaiT.AmA8tU;
import PCV8se.AaHO0E;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A4TApA extends AlLFFp {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AaHO0E f6438AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Rect f6439AzWtSf;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public A4TApA(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OOnEhG.A4TApA.<init>(android.content.Context):void");
    }

    @Override // ADYaiT.AlLFFp
    public AmA8tU A2egSU() {
        AmA8tU A2egSU2 = super.A2egSU();
        Window window = A2egSU2.getWindow();
        View decorView = window.getDecorView();
        AaHO0E aaHO0E = this.f6438AmA8tU;
        if (aaHO0E != null) {
            aaHO0E.B2KMhB(decorView.getElevation());
        }
        Rect rect = this.f6439AzWtSf;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) aaHO0E, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new A2egSU(A2egSU2, rect));
        return A2egSU2;
    }

    @Override // ADYaiT.AlLFFp
    public /* bridge */ /* synthetic */ void A5SV6n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AzWtSf(null, null);
    }

    public A4TApA ARc23Z(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f39B3GDIM = listAdapter;
        azoqyo.f40B4ZgIw = onClickListener;
        return this;
    }

    public A4TApA ASJ6gh() {
        this.f81AcNBzu.f35AmA8tU = false;
        return this;
    }

    public A4TApA AYUAbz() {
        this.f81AcNBzu.f25A5SV6n = 2131689472;
        return this;
    }

    public A4TApA AZOQYO(int i) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f28ASJ6gh = azoqyo.f23A2egSU.getText(i);
        return this;
    }

    @Override // ADYaiT.AlLFFp
    /* renamed from: AZkASS, reason: merged with bridge method [inline-methods] */
    public A4TApA A4TApA(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        super.A4TApA(charSequenceArr, zArr, onMultiChoiceClickListener);
        return this;
    }

    public A4TApA AaHO0E(int i, DialogInterface.OnClickListener onClickListener) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f31AZkASS = azoqyo.f23A2egSU.getText(i);
        azoqyo.f32AaHO0E = onClickListener;
        return this;
    }

    public A4TApA AcNBzu(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f31AZkASS = charSequence;
        azoqyo.f32AaHO0E = onClickListener;
        return this;
    }

    public A4TApA AlLFFp(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f33AcNBzu = charSequence;
        azoqyo.f34AlLFFp = onClickListener;
        return this;
    }

    public A4TApA AmA8tU(int i, DialogInterface.OnClickListener onClickListener) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.f29AYUAbz = azoqyo.f23A2egSU.getText(i);
        azoqyo.f30AZOQYO = onClickListener;
        return this;
    }

    public A4TApA AzWtSf(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.A5SV6n(charSequence, onClickListener);
        return this;
    }

    @Override // ADYaiT.AlLFFp
    /* renamed from: B25kr6, reason: merged with bridge method [inline-methods] */
    public A4TApA ADYaiT(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        super.ADYaiT(charSequenceArr, i, onClickListener);
        return this;
    }

    public A4TApA B2KMhB(int i) {
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.AMqCpz = azoqyo.f23A2egSU.getText(i);
        return this;
    }
}
