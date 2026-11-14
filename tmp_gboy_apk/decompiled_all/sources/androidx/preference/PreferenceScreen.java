package androidx.preference;

import BTvldC.A4TApA;
import DRlcZ9.B4ZgIw;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public final boolean f9122DRlcZ9;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, A4TApA.A2egSU(context, 2130969757, R.attr.preferenceScreenStyle));
        this.f9122DRlcZ9 = true;
    }

    @Override // androidx.preference.Preference
    public final void AmA8tU() {
        B4ZgIw b4ZgIw;
        if (this.f9089BIYEnU != null || this.f9090BJ7GGh != null || this.f9117D8MqeW.size() == 0 || (b4ZgIw = this.f9078AlLFFp.f2135AZkASS) == null) {
            return;
        }
        for (Fragment fragment = b4ZgIw; fragment != null; fragment = fragment.getParentFragment()) {
        }
        b4ZgIw.getContext();
        b4ZgIw.getActivity();
    }
}
