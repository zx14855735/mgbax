package com.google.android.material.snackbar;

import NdEzCJ.A2egSU;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.A5SV6n;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public TextView f11811AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Button f11812AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f11813AmA8tU;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        A5SV6n.D6DOie(context, 2130969633, A2egSU.f6037A4TApA);
    }

    public final boolean A2egSU(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f11811AcNBzu.getPaddingTop() == i2 && this.f11811AcNBzu.getPaddingBottom() == i3) {
            return z;
        }
        TextView textView = this.f11811AcNBzu;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i2, textView.getPaddingEnd(), i3);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i2, textView.getPaddingRight(), i3);
        return true;
    }

    public Button getActionView() {
        return this.f11812AlLFFp;
    }

    public TextView getMessageView() {
        return this.f11811AcNBzu;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f11811AcNBzu = (TextView) findViewById(2131297996);
        this.f11812AlLFFp = (Button) findViewById(2131297995);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165326);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131165325);
        Layout layout = this.f11811AcNBzu.getLayout();
        boolean z = layout != null && layout.getLineCount() > 1;
        if (!z || this.f11813AmA8tU <= 0 || this.f11812AlLFFp.getMeasuredWidth() <= this.f11813AmA8tU) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!A2egSU(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!A2egSU(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMaxInlineActionWidth(int i) {
        this.f11813AmA8tU = i;
    }
}
