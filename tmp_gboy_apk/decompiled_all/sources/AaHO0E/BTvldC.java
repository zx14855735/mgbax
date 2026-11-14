package AaHO0E;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BTvldC {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TextView f665A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AZkASS.ARc23Z f666A4TApA;

    public BTvldC(TextView textView) {
        this.f665A2egSU = textView;
        this.f666A4TApA = new AZkASS.ARc23Z(textView);
    }

    public final InputFilter[] A2egSU(InputFilter[] inputFilterArr) {
        return ((JrXYwF.A4TApA) this.f666A4TApA.f451AlLFFp).CASmeH(inputFilterArr);
    }

    public final void A4TApA(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f665A2egSU.getContext().obtainStyledAttributes(attributeSet, R$styleable.f8021AZOQYO, i, 0);
        try {
            boolean z = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
            obtainStyledAttributes.recycle();
            ADYaiT(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void A5SV6n(boolean z) {
        ((JrXYwF.A4TApA) this.f666A4TApA.f451AlLFFp).D07BeM(z);
    }

    public final void ADYaiT(boolean z) {
        ((JrXYwF.A4TApA) this.f666A4TApA.f451AlLFFp).D8MqeW(z);
    }
}
