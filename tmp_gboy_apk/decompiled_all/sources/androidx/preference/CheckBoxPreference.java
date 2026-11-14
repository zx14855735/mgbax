package androidx.preference;

import DRlcZ9.A2egSU;
import DRlcZ9.BV3sI0;
import android.R;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: DG07BK, reason: collision with root package name */
    public final A2egSU f9059DG07BK;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CheckBoxPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130968771(0x7f0400c3, float:1.7546205E38)
            r1 = 16842895(0x101008f, float:2.369396E-38)
            int r0 = BTvldC.A4TApA.A2egSU(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            DRlcZ9.A2egSU r1 = new DRlcZ9.A2egSU
            r2 = 0
            r1.<init>(r2, r3)
            r3.f9059DG07BK = r1
            int[] r1 = androidx.preference.R$styleable.f9124A4TApA
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 5
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L26
            java.lang.String r5 = r4.getString(r2)
        L26:
            r3.f9153D8MqeW = r5
            boolean r5 = r3.f9152D6yqiO
            if (r5 == 0) goto L2f
            r3.AZOQYO()
        L2f:
            r5 = 4
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L3b
            r5 = 1
            java.lang.String r5 = r4.getString(r5)
        L3b:
            r3.f9154D8cQ8b = r5
            boolean r5 = r3.f9152D6yqiO
            if (r5 != 0) goto L44
            r3.AZOQYO()
        L44:
            r5 = 2
            boolean r5 = r4.getBoolean(r5, r2)
            r0 = 3
            boolean r5 = r4.getBoolean(r0, r5)
            r3.f9156DAk1zC = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.CheckBoxPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // androidx.preference.Preference
    public final void AlLFFp(BV3sI0 bV3sI0) {
        super.AlLFFp(bV3sI0);
        BpkvW3(bV3sI0.A2egSU(R.id.checkbox));
        BniPrB(bV3sI0.A2egSU(R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void B9tovu(View view) {
        super.B9tovu(view);
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            BpkvW3(view.findViewById(R.id.checkbox));
            BniPrB(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void BpkvW3(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f9152D6yqiO);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f9059DG07BK);
        }
    }
}
