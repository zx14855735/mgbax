package androidx.preference;

import BTvldC.A4TApA;
import DRlcZ9.BV3sI0;
import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, A4TApA.A2egSU(context, 2130969749, R.attr.preferenceCategoryStyle));
    }

    @Override // androidx.preference.Preference
    public final boolean AYUAbz() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void AlLFFp(BV3sI0 bV3sI0) {
        super.AlLFFp(bV3sI0);
        if (Build.VERSION.SDK_INT >= 28) {
            bV3sI0.itemView.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public final boolean BTvldC() {
        return !super.AYUAbz();
    }
}
