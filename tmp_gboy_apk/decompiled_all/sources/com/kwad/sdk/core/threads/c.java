package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    public static final String TAG = "c";
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> aOA = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> aOB = new ConcurrentHashMap<>();
    private static int aOx;
    private static int aOy;
    private static int aOz;
    private static long interval;
    private static long startTime;

    static {
        vLziG();
    }

    public static /* synthetic */ int Ly() {
        int i = aOx;
        aOx = i + 1;
        return i;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        aOA.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        aOB.put(threadPoolExecutor, str);
    }

    public static void df(final String str) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d eT;
                int i;
                if (TextUtils.isEmpty(str) || (eT = c.eT(str)) == null || (i = eT.aOy) == 0) {
                    return;
                }
                int unused = c.aOy = i;
                if (Math.random() * c.aOy >= 1.0d) {
                    return;
                }
                c.a(eT);
            }
        });
    }

    public static d eT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }

    private static /* synthetic */ void vLziG() {
        char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '{');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '{');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        b bVar = new b();
        bVar.aOn = str;
        bVar.aOo = threadPoolExecutor.getCorePoolSize();
        bVar.aOp = threadPoolExecutor.getMaximumPoolSize();
        bVar.aOq = threadPoolExecutor.getPoolSize();
        bVar.aOr = threadPoolExecutor.getActiveCount();
        bVar.aOu = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = aOA;
        long longValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.aOt = completedTaskCount - longValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.a.c) {
            bVar.aOs = ((com.kwad.sdk.core.threads.a.c) threadPoolExecutor).LC();
        } else {
            bVar.aOs = 0L;
        }
        bVar.aOv = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.aOw = aOy;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(d dVar) {
        com.kwad.sdk.core.threads.a.b.aOF = true;
        com.kwad.sdk.core.threads.a.a.aOF = true;
        interval = dVar.interval;
        aOz = dVar.aOE;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new bg() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ExecutorService eS;
                for (String str : GlobalThreadPools.Ls()) {
                    if (str != null && !c.aOB.containsValue(str) && (eS = GlobalThreadPools.eS(str)) != null && (eS instanceof ThreadPoolExecutor) && !c.aOA.containsKey(eS)) {
                        c.a((ThreadPoolExecutor) eS, str);
                    }
                }
                int i = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.aOB.keySet()) {
                    String str2 = (String) c.aOB.get(threadPoolExecutor);
                    i += threadPoolExecutor.getPoolSize();
                    b b = c.b(threadPoolExecutor, str2);
                    if (b != null) {
                        com.kwad.sdk.commercial.c.s(b);
                    }
                }
                b bVar = new b();
                bVar.aOn = "total";
                bVar.aOq = i;
                com.kwad.sdk.commercial.c.s(bVar);
                c.Ly();
                if (c.aOx < c.aOz) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }
}
