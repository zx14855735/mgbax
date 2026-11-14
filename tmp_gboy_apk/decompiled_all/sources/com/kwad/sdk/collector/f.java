package com.kwad.sdk.collector;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f {
    public static JSONArray Fu() {
        Context context = ServiceProvider.getContext();
        List<g> bu = bu(context);
        bu.add(bt(context));
        return g.w(bu);
    }

    private static g bt(Context context) {
        boolean dw = au.dw(context);
        A2egSU.B9tovu("queryAccessibilityServicePermission result: ", "InfoCollector", dw);
        return new g(com.kuaishou.weapon.p0.g.k, dw ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    private static List<g> bu(Context context) {
        String[] cW;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (context != null && (cW = y.cW(context)) != null) {
            for (String str : cW) {
                int aw = au.aw(context, str);
                copyOnWriteArrayList.add(new g(str, aw == 0 ? g.PERMISSION_GRANTED : aw == -1 ? g.PERMISSION_DENIED : g.azs));
            }
        }
        return copyOnWriteArrayList;
    }
}
