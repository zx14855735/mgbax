package com.kwad.sdk.n;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.n.d;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static final String TAG = "Ranger_c";

    public static void a(d dVar) {
        final List<d.a> list = dVar.bcb;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.n.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.a(activity, list);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.e(a.TAG, Log.getStackTraceString(th));
                }
            }
        });
    }

    private static String e(Object obj, String str) {
        Object field;
        return (TextUtils.isEmpty(str) || (field = z.getField(obj, str)) == null) ? "" : field.getClass().getName();
    }

    public static void a(Activity activity, List<d.a> list) {
        try {
            for (d.a aVar : list) {
                if (aVar != null) {
                    String str = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.bcd)) {
                        str = aVar.bcd;
                    } else if (!TextUtils.isEmpty(aVar.bce) && activity.getClass().getName().startsWith(aVar.bcd)) {
                        str = e(activity, aVar.bce);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int c = ag.c("ksadsdk_perf_ranger_v2", str, 0) + 1;
                        ag.b("ksadsdk_perf_ranger_v2", str, c);
                        com.kwad.sdk.core.d.c.d(TAG, "act:" + str + " num:" + c);
                    }
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, "record:" + Log.getStackTraceString(th));
        }
    }
}
