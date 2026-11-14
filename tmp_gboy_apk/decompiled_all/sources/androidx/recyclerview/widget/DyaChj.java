package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class DyaChj {
    public static int A2egSU(RecyclerView.AaHO0E aaHO0E, Cd8JRx cd8JRx, View view, View view2, RecyclerView.ARc23Z aRc23Z, boolean z) {
        if (aRc23Z.getChildCount() == 0 || aaHO0E.A4TApA() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(aRc23Z.getPosition(view) - aRc23Z.getPosition(view2)) + 1;
        }
        return Math.min(cd8JRx.AcNBzu(), cd8JRx.A4TApA(view2) - cd8JRx.AMqCpz(view));
    }

    public static int A4TApA(RecyclerView.AaHO0E aaHO0E, Cd8JRx cd8JRx, View view, View view2, RecyclerView.ARc23Z aRc23Z, boolean z, boolean z2) {
        if (aRc23Z.getChildCount() == 0 || aaHO0E.A4TApA() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (aaHO0E.A4TApA() - Math.max(aRc23Z.getPosition(view), aRc23Z.getPosition(view2))) - 1) : Math.max(0, Math.min(aRc23Z.getPosition(view), aRc23Z.getPosition(view2)));
        if (z) {
            return Math.round((max * (Math.abs(cd8JRx.A4TApA(view2) - cd8JRx.AMqCpz(view)) / (Math.abs(aRc23Z.getPosition(view) - aRc23Z.getPosition(view2)) + 1))) + (cd8JRx.AaHO0E() - cd8JRx.AMqCpz(view)));
        }
        return max;
    }

    public static int A5SV6n(RecyclerView.AaHO0E aaHO0E, Cd8JRx cd8JRx, View view, View view2, RecyclerView.ARc23Z aRc23Z, boolean z) {
        if (aRc23Z.getChildCount() == 0 || aaHO0E.A4TApA() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return aaHO0E.A4TApA();
        }
        return (int) (((cd8JRx.A4TApA(view2) - cd8JRx.AMqCpz(view)) / (Math.abs(aRc23Z.getPosition(view) - aRc23Z.getPosition(view2)) + 1)) * aaHO0E.A4TApA());
    }
}
