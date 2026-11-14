package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c {
    private final Set<g> alL;

    public static class a {
        private static final c alR = new c(0);

        static {
            Wrfzuus();
        }

        private static /* synthetic */ void Wrfzuus() {
            char[] charArray = "[WU\u0016_YU]\u0016ZWA\u0016KP]TT\u0016rVQzJQ\\_]".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '8');
            }
            String str = new String(charArray);
            char[] charArray2 = "[TQVQL".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '8');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2) {
        if (this.alL.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.alL).iterator();
        while (it.hasNext()) {
            ((g) it.next()).v(str2);
        }
    }

    public static c xp() {
        return a.alR;
    }

    public final void b(g gVar) {
        this.alL.remove(gVar);
    }

    public final void c(final String str, final long j, final long j2, final long j3) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.b(str, j, j2, j3);
            }
        });
    }

    public final void t(final String str, final String str2) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.s(str, str2);
            }
        });
    }

    public final void xq() {
        this.alL.clear();
    }

    private c() {
        this.alL = new CopyOnWriteArraySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, long j2, long j3) {
        if (this.alL.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.alL).iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(str, j, j2, j3);
        }
    }

    public final void a(g gVar) {
        if (gVar != null) {
            this.alL.add(gVar);
        }
    }
}
