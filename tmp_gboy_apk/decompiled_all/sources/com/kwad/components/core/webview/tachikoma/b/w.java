package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c akG;
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> akH = new CopyOnWriteArrayList<>();

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.akG != null) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.b.w.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (w.this.akG != null) {
                        w.this.akG.a(bVar);
                    }
                }
            });
        } else {
            this.akH.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.akG = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.akG = cVar;
        if (this.akH.size() > 0) {
            Iterator<com.kwad.sdk.core.b> it = this.akH.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.b next = it.next();
                b(next);
                this.akH.remove(next);
            }
        }
    }
}
