package com.kwad.components.core.page.widget.halfContainer;

import android.net.Uri;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.kwad.components.core.s.r;
import com.kwad.components.core.s.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e implements f {
    private static boolean aM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.page.widget.halfContainer.f
    public final d aL(String str) {
        d dVar = new d();
        if (TextUtils.isEmpty(str)) {
            return dVar;
        }
        Uri parse = Uri.parse(str);
        dVar.YW = r.a(u.a(parse, "heightRatio", Constants.FAIL), 0.0f);
        dVar.YX = r.a(u.a(parse, "absoluteHeight", Constants.FAIL), 0.0f);
        dVar.YZ = r.m(u.a(parse, "topRadius", Constants.FAIL), 0);
        dVar.YY = r.a(u.a(parse, "maskAlpha", Constants.FAIL), 0.0f);
        dVar.Za = aM(u.a(parse, "disableClickOutsideDismiss", "false"));
        dVar.Zb = aM(u.a(parse, "enableDragHalfToFull", "false"));
        dVar.Zc = aM(u.a(parse, "showStatusBar", "false"));
        dVar.Ze = aM(u.a(parse, "isAdjustKeyBoard", "true"));
        dVar.Zg = u.a(parse);
        return dVar;
    }
}
