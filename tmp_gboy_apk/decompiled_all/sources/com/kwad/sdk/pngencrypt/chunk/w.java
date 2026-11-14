package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class w {
    private final e bbA;
    private final boolean bbB;

    public w(e eVar) {
        this.bbA = eVar;
        if (eVar instanceof f) {
            this.bbB = false;
        } else {
            this.bbB = true;
        }
    }

    private List<? extends t> gS(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.bbA.an("tEXt", str));
        arrayList.addAll(this.bbA.an("zTXt", str));
        arrayList.addAll(this.bbA.an("iTXt", str));
        return arrayList;
    }

    public final String gT(String str) {
        List<? extends t> gS = gS(str);
        if (gS.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends t> it = gS.iterator();
        while (it.hasNext()) {
            sb.append(it.next().QC());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
