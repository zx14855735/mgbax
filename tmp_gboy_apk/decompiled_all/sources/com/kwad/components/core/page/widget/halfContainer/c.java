package com.kwad.components.core.page.widget.halfContainer;

import android.app.Activity;
import android.app.Fragment;
import com.kwad.components.core.page.widget.halfContainer.b;
import com.kwad.components.core.proxy.j;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c {
    private j YS;

    public final j a(String str, Activity activity, j jVar) {
        return a(str, activity, jVar, new e(), -1);
    }

    public final void dismiss() {
        j jVar = this.YS;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    private j a(String str, Activity activity, j jVar, f fVar, int i) {
        return a(str, activity, jVar, fVar, -1, null);
    }

    private j a(String str, Activity activity, j jVar, f fVar, int i, ContainerBottomSheetBehavior containerBottomSheetBehavior) {
        if (fVar == null) {
            fVar = new e();
        }
        d aL = fVar.aL(str);
        aL.Zd = i;
        aL.Zf = null;
        aL.YY = 0.8f;
        aL.YZ = com.kwad.sdk.c.a.a.a(activity, 4.0f);
        a(activity, aL);
        return a(activity, jVar, aL);
    }

    private static void a(Activity activity, d dVar) {
        float f = dVar.YW;
        if (f >= 1.0f) {
            dVar.YV = true;
            dVar.YW = 1.0f;
        } else if (f < 0.0f) {
            dVar.YW = 0.0f;
        }
        if (dVar.YV) {
            dVar.YX = com.kwad.sdk.c.a.a.k(activity);
            return;
        }
        float f2 = dVar.YW;
        if (f2 <= 0.0f || f2 > 1.0f) {
            return;
        }
        dVar.YX = com.kwad.sdk.c.a.a.k(activity) * f;
    }

    private j a(Activity activity, j jVar, d dVar) {
        j a2 = a(jVar, dVar);
        this.YS = a2;
        a2.a(activity.getFragmentManager(), "WEB_HALF_DIALOG");
        return this.YS;
    }

    private j a(j jVar, d dVar) {
        a a2 = a.a(dVar);
        if (!dVar.Zb) {
            a2.aX((int) dVar.YX);
        }
        return a(a2, jVar, dVar);
    }

    private b a(a aVar, final j jVar, d dVar) {
        aVar.a(new b.a() { // from class: com.kwad.components.core.page.widget.halfContainer.c.1
            @Override // com.kwad.components.core.page.widget.halfContainer.b.a
            public final Fragment te() {
                return jVar;
            }
        });
        int i = dVar.Zd;
        if (i > 0) {
            aVar.aW(i);
        }
        return aVar;
    }
}
