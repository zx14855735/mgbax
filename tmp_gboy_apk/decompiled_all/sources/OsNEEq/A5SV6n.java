package OsNEEq;

import OpB85q.ARc23Z;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends ARc23Z {
    @Override // OpB85q.ARc23Z
    public final int getItemDefaultMarginResId() {
        return 2131166473;
    }

    @Override // OpB85q.ARc23Z
    public final int getItemLayoutResId() {
        return 2131493248;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i2) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i2)));
        }
    }
}
