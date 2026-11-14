package com.kwad.library.solder.a;

import android.content.Context;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    public static void a(Context context, b bVar, b.c cVar) {
        i.Bw().a(context, new c(bVar), cVar);
    }

    public static com.kwad.library.b.a m(Context context, String str) {
        com.kwad.library.solder.lib.a.a o = i.Bw().o(context, str);
        if (o != null && o.isLoaded() && (o instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) o;
        }
        return null;
    }

    public static void n(Context context, String str) {
        i.Bw().n(context, str);
    }

    public static void a(Context context, com.kwad.library.solder.lib.c.b bVar, b.a aVar) {
        i.Bw().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }
}
