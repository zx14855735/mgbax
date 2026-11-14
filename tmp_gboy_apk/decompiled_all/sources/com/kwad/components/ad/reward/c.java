package com.kwad.components.ad.reward;

import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> rk;

    public static class a {
        private static final c rn = new c(0);

        static {
            enIMAP();
        }

        private static /* synthetic */ void enIMAP() {
            char[] charArray = "BNL\u000fF@LD\u000fCNX\u000fRIDMM\u000fkOHcSHEFD".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '!');
            }
            String str = new String(charArray);
            char[] charArray2 = "BMHOHU".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '!');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c go() {
        return a.rn;
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.rk.remove(mVar);
    }

    public final void c(final r rVar) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.b(rVar);
            }
        });
    }

    private c() {
        this.rk = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (this.rk.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> it = this.rk.iterator();
        while (it.hasNext()) {
            it.next().a(rVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.rk.add(mVar);
        }
    }
}
