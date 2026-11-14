package AaHO0E;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CNPG0E extends RatingBar {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final C4FrIb f686AcNBzu;

    public CNPG0E(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969783);
        GIi2tl.A2egSU(getContext(), this);
        C4FrIb c4FrIb = new C4FrIb(this);
        this.f686AcNBzu = c4FrIb;
        c4FrIb.A4TApA(attributeSet, 2130969783);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = (Bitmap) this.f686AcNBzu.f681A5SV6n;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
