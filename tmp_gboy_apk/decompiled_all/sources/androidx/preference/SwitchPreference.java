package androidx.preference;

import DRlcZ9.A2egSU;
import DRlcZ9.BV3sI0;
import android.R;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.Switch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: DG07BK, reason: collision with root package name */
    public final A2egSU f9146DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public final String f9147DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final String f9148DUi7mC;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SwitchPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130969957(0x7f040565, float:1.754861E38)
            r1 = 16843629(0x101036d, float:2.3696016E-38)
            int r0 = BTvldC.A4TApA.A2egSU(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            DRlcZ9.A2egSU r1 = new DRlcZ9.A2egSU
            r2 = 1
            r1.<init>(r2, r3)
            r3.f9146DG07BK = r1
            int[] r1 = androidx.preference.R$styleable.f9133AcNBzu
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 7
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L27
            java.lang.String r5 = r4.getString(r2)
        L27:
            r3.f9153D8MqeW = r5
            boolean r5 = r3.f9152D6yqiO
            if (r5 == 0) goto L30
            r3.AZOQYO()
        L30:
            r5 = 6
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L3c
            r5 = 1
            java.lang.String r5 = r4.getString(r5)
        L3c:
            r3.f9154D8cQ8b = r5
            boolean r5 = r3.f9152D6yqiO
            if (r5 != 0) goto L45
            r3.AZOQYO()
        L45:
            r5 = 9
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L52
            r5 = 3
            java.lang.String r5 = r4.getString(r5)
        L52:
            r3.f9147DRlcZ9 = r5
            r3.AZOQYO()
            r5 = 8
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L64
            r5 = 4
            java.lang.String r5 = r4.getString(r5)
        L64:
            r3.f9148DUi7mC = r5
            r3.AZOQYO()
            r5 = 2
            boolean r5 = r4.getBoolean(r5, r2)
            r0 = 5
            boolean r5 = r4.getBoolean(r0, r5)
            r3.f9156DAk1zC = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.SwitchPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // androidx.preference.Preference
    public final void AlLFFp(BV3sI0 bV3sI0) {
        super.AlLFFp(bV3sI0);
        BpkvW3(bV3sI0.A2egSU(R.id.switch_widget));
        BniPrB(bV3sI0.A2egSU(R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void B9tovu(View view) {
        super.B9tovu(view);
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            BpkvW3(view.findViewById(R.id.switch_widget));
            BniPrB(view.findViewById(R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void BpkvW3(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f9152D6yqiO);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.f9147DRlcZ9);
            r4.setTextOff(this.f9148DUi7mC);
            r4.setOnCheckedChangeListener(this.f9146DG07BK);
        }
    }
}
