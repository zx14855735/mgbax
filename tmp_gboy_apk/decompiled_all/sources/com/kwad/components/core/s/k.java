package com.kwad.components.core.s;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class k {
    private static final ConcurrentHashMap<Integer, a> acI = new ConcurrentHashMap<>();
    public static final long acJ = com.kwad.sdk.core.config.e.Ic().longValue() * 1000;
    private static final Map<Integer, bg> acK = new ConcurrentHashMap();
    private static Map<Integer, Long> acL = new HashMap();

    public static class a {
        private long Jf;
        private final com.kwad.sdk.components.t acN;
        private final AtomicInteger acO;
        private long acP;
        private long acQ;
        private long acR;

        public a(com.kwad.sdk.components.t tVar, long j, long j2, long j3, long j4) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            this.acO = atomicInteger;
            this.acN = tVar;
            atomicInteger.set(1);
            this.acP = j;
            this.Jf = j2;
            this.acQ = j3;
            this.acR = j4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void uG() {
            this.acO.incrementAndGet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int uH() {
            return this.acO.decrementAndGet();
        }

        public final long uB() {
            return this.acP;
        }

        public final long uC() {
            return this.Jf;
        }

        public final long uD() {
            return this.acQ;
        }

        public final long uE() {
            return this.acR;
        }

        public final com.kwad.sdk.components.t uF() {
            return this.acN;
        }
    }

    static {
        JHKBbo();
    }

    private static /* synthetic */ void JHKBbo() {
        char[] charArray = "?31r;=19r>3%r/4900r\u001625\u001e.58;9".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\\');
        }
        String str = new String(charArray);
        char[] charArray2 = "?0525(".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\\');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a(Integer num, com.kwad.sdk.components.t tVar, long j, long j2, long j3, long j4) {
        if (tVar == null && (num == null || num.intValue() == 0)) {
            return;
        }
        try {
            e(num);
            ConcurrentHashMap<Integer, a> concurrentHashMap = acI;
            a aVar = concurrentHashMap.get(num);
            if (aVar != null) {
                aVar.uG();
            } else {
                concurrentHashMap.put(num, new a(tVar, j, j2, j3, j4));
            }
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    public static a b(Integer num) {
        if (num != null && num.intValue() != 0) {
            try {
                e(num);
                a aVar = acI.get(num);
                if (aVar == null) {
                    return null;
                }
                aVar.uG();
                return aVar;
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
        return null;
    }

    public static void c(Integer num) {
        if (num == null || num.intValue() == 0) {
            return;
        }
        try {
            a aVar = acI.get(num);
            if (aVar == null || aVar.uH() != 0) {
                return;
            }
            d(num);
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    private static void d(final Integer num) {
        if (num == null || num.intValue() == 0) {
            return;
        }
        e(num);
        bg bgVar = new bg() { // from class: com.kwad.components.core.s.k.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a aVar = (a) k.acI.get(num);
                if (aVar != null) {
                    aVar.acN.onDestroy();
                }
                k.acL.remove(num);
                k.acI.remove(num);
            }
        };
        acK.put(num, bgVar);
        bw.runOnUiThreadDelay(bgVar, acJ);
    }

    private static void e(Integer num) {
        Map<Integer, bg> map = acK;
        bg bgVar = map.get(num);
        if (bgVar != null) {
            bw.c(bgVar);
            map.remove(num);
        }
    }

    public static com.kwad.sdk.components.t a(Integer num) {
        if (num != null && num.intValue() != 0) {
            try {
                e(num);
                a aVar = acI.get(num);
                if (aVar == null) {
                    return null;
                }
                aVar.uG();
                return aVar.acN;
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
        return null;
    }
}
