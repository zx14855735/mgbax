package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class ab implements w {
    private final SparseArray<Handler> aqI = new SparseArray<>();

    private static void b(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void c(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean bS(int i) {
        return this.aqI.get(i) != null;
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void q(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            c(this.aqI.get(it.next().intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void zs() {
        for (int i = 0; i < this.aqI.size(); i++) {
            b(this.aqI.get(this.aqI.keyAt(i)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int zt() {
        return this.aqI.size();
    }
}
