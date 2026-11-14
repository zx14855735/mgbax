package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> rh;

    public static class a {
        private static final b rj = new b(0);

        static {
            AeEC();
        }

        private static /* synthetic */ void AeEC() {
            char[] charArray = "~rp3z|px3\u007frd3nuxqq3Wst_otyzx".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 29);
            }
            String str = new String(charArray);
            char[] charArray2 = "~qtsti".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 29);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b gl() {
        return a.rj;
    }

    private void gm() {
        if (this.rh.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.l> it = this.rh.iterator();
        while (it.hasNext()) {
            it.next().onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.rh.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.rh.remove(lVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            gm();
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }

    private b() {
        this.rh = new HashSet();
    }
}
