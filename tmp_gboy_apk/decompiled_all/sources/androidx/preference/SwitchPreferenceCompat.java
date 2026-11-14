package androidx.preference;

import DRlcZ9.A2egSU;
import DRlcZ9.BV3sI0;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import androidx.appcompat.widget.SwitchCompat;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: DG07BK, reason: collision with root package name */
    public final A2egSU f9149DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public final String f9150DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final String f9151DUi7mC;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969956);
        this.f9149DG07BK = new A2egSU(2, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f9134AlLFFp, 2130969956, 0);
        String string = obtainStyledAttributes.getString(7);
        this.f9153D8MqeW = string == null ? obtainStyledAttributes.getString(0) : string;
        if (this.f9152D6yqiO) {
            AZOQYO();
        }
        String string2 = obtainStyledAttributes.getString(6);
        this.f9154D8cQ8b = string2 == null ? obtainStyledAttributes.getString(1) : string2;
        if (!this.f9152D6yqiO) {
            AZOQYO();
        }
        String string3 = obtainStyledAttributes.getString(9);
        this.f9150DRlcZ9 = string3 == null ? obtainStyledAttributes.getString(3) : string3;
        AZOQYO();
        String string4 = obtainStyledAttributes.getString(8);
        this.f9151DUi7mC = string4 == null ? obtainStyledAttributes.getString(4) : string4;
        AZOQYO();
        this.f9156DAk1zC = obtainStyledAttributes.getBoolean(5, obtainStyledAttributes.getBoolean(2, false));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void AlLFFp(BV3sI0 bV3sI0) {
        super.AlLFFp(bV3sI0);
        BpkvW3(bV3sI0.A2egSU(2131298043));
        BniPrB(bV3sI0.A2egSU(R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void B9tovu(View view) {
        super.B9tovu(view);
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            BpkvW3(view.findViewById(2131298043));
            BniPrB(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void BpkvW3(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f9152D6yqiO);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f9150DRlcZ9);
            switchCompat.setTextOff(this.f9151DUi7mC);
            switchCompat.setOnCheckedChangeListener(this.f9149DG07BK);
        }
    }
}
