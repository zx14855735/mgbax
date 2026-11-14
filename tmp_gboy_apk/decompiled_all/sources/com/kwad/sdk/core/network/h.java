package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h {
    private static volatile h aJs;
    private List<a> aJr = new CopyOnWriteArrayList();

    public interface a {
        void a(f fVar, int i);
    }

    private h() {
    }

    public static h Js() {
        if (aJs == null) {
            synchronized (h.class) {
                try {
                    if (aJs == null) {
                        aJs = new h();
                    }
                } finally {
                }
            }
        }
        return aJs;
    }

    public final void a(a aVar) {
        this.aJr.add(aVar);
    }

    public final void b(f fVar, int i) {
        Iterator<a> it = this.aJr.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i);
        }
    }
}
