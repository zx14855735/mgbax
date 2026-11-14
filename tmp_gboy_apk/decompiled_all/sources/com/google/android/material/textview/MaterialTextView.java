package com.google.android.material.textview;

import P3rngT.A4TApA;
import PXXBzr.A2egSU;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, R.attr.textViewStyle, 0), attributeSet, R.attr.textViewStyle);
        Context context2 = getContext();
        if (A4TApA.A4TApA(context2, 2130970031, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = R$styleable.f11244CASmeH;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
            int[] iArr2 = {1, 2};
            int i = -1;
            for (int i2 = 0; i2 < 2 && i < 0; i2++) {
                i = AMqCpz.BTvldC(context2, obtainStyledAttributes, iArr2[i2], -1);
            }
            obtainStyledAttributes.recycle();
            if (i != -1) {
                return;
            }
            TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
            int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
            obtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, R$styleable.f11243C4FrIb);
                Context context3 = getContext();
                int[] iArr3 = {2, 4};
                int i3 = -1;
                for (int i4 = 0; i4 < 2 && i3 < 0; i4++) {
                    i3 = AMqCpz.BTvldC(context3, obtainStyledAttributes3, iArr3[i4], -1);
                }
                obtainStyledAttributes3.recycle();
                if (i3 >= 0) {
                    setLineHeight(i3);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (A4TApA.A4TApA(context, 2130970031, true)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, R$styleable.f11243C4FrIb);
            Context context2 = getContext();
            int[] iArr = {2, 4};
            int i2 = -1;
            for (int i3 = 0; i3 < 2 && i2 < 0; i3++) {
                i2 = AMqCpz.BTvldC(context2, obtainStyledAttributes, iArr[i3], -1);
            }
            obtainStyledAttributes.recycle();
            if (i2 >= 0) {
                setLineHeight(i2);
            }
        }
    }
}
