package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class tf {
    public static int hf(RecyclerView.jk jkVar, f fVar, View view, View view2, RecyclerView.d dVar, boolean z) {
        if (dVar.v() == 0 || jkVar.u() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return jkVar.u();
        }
        return (int) (((fVar.hf(view2) - fVar.xj(view)) / (Math.abs(dVar.u(view) - dVar.u(view2)) + 1)) * jkVar.u());
    }

    public static int xj(RecyclerView.jk jkVar, f fVar, View view, View view2, RecyclerView.d dVar, boolean z, boolean z2) {
        if (dVar.v() == 0 || jkVar.u() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (jkVar.u() - Math.max(dVar.u(view), dVar.u(view2))) - 1) : Math.max(0, Math.min(dVar.u(view), dVar.u(view2)));
        if (z) {
            return Math.round((max * (Math.abs(fVar.hf(view2) - fVar.xj(view)) / (Math.abs(dVar.u(view) - dVar.u(view2)) + 1))) + (fVar.w() - fVar.xj(view)));
        }
        return max;
    }

    public static int xj(RecyclerView.jk jkVar, f fVar, View view, View view2, RecyclerView.d dVar, boolean z) {
        if (dVar.v() == 0 || jkVar.u() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(dVar.u(view) - dVar.u(view2)) + 1;
        }
        return Math.min(fVar.y(), fVar.hf(view2) - fVar.xj(view));
    }
}
