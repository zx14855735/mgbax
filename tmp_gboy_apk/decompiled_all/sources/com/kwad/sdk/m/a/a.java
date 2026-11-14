package com.kwad.sdk.m.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private final List<b> bbQ = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.bbQ.add(bVar);
        }
    }

    public final boolean onBackPressed() {
        Iterator<b> it = this.bbQ.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.bbQ.remove(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i) {
        if (bVar != null) {
            this.bbQ.add(i, bVar);
        }
    }
}
