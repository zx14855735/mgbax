package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class d {
    private static com.kwad.sdk.core.g.d gX;
    private static com.kwad.sdk.core.g.c gY;
    private static Vibrator gZ;
    private static List<c> ha = new CopyOnWriteArrayList();
    private static List<a> hb = new CopyOnWriteArrayList();
    private static long hc;

    public static class a {
        private b hf;
        private Context mContext;

        public a(b bVar, Context context) {
            this.hf = bVar;
            this.mContext = context;
        }
    }

    public interface b {
        boolean s(String str);
    }

    public static class c {
        private InterfaceC0229d hg;
        private Context mContext;

        public c(InterfaceC0229d interfaceC0229d, Context context) {
            this.hg = interfaceC0229d;
            this.mContext = context;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.d$d, reason: collision with other inner class name */
    public interface InterfaceC0229d {
        boolean b(double d);
    }

    static {
        gUwHKs();
    }

    public static void D(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = gY;
            if (cVar != null) {
                cVar.bQ(context);
                gY = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void E(Context context) {
        try {
            com.kwad.sdk.core.g.d dVar = gX;
            if (dVar != null) {
                dVar.bQ(context);
                gX = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Vibrator F(Context context) {
        if (gZ == null) {
            gZ = (Vibrator) context.getSystemService("vibrator");
        }
        return gZ;
    }

    public static void a(float f, Context context, InterfaceC0229d interfaceC0229d) {
        if (gX == null) {
            a(f, context);
        }
        ha.add(new c(interfaceC0229d, context));
    }

    public static synchronized boolean bX() {
        synchronized (d.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - hc <= 500) {
                return false;
            }
            hc = elapsedRealtime;
            return true;
        }
    }

    private static /* synthetic */ void gUwHKs() {
        char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '}');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '}');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a(InterfaceC0229d interfaceC0229d) {
        for (c cVar : ha) {
            if (cVar != null && cVar.hg == interfaceC0229d) {
                ha.remove(cVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sShakeItems size " + ha.size());
    }

    private static void a(float f, Context context) {
        gX = new com.kwad.sdk.core.g.d(f);
        ha = new CopyOnWriteArrayList();
        gX.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d) {
                if (d.ha != null) {
                    Iterator it = d.ha.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c cVar = (c) it.next();
                        if (cVar != null && cVar.hg != null && cVar.hg.b(d)) {
                            bw.a(cVar.mContext, d.F(cVar.mContext));
                            break;
                        }
                    }
                    bw.a(new bg() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onShakeEvent openGate2");
                            if (d.gX != null) {
                                d.gX.KT();
                            }
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void cc() {
            }
        });
        gX.k(f);
        gX.bP(context);
    }

    public static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, b bVar) {
        com.kwad.sdk.core.g.c cVar = gY;
        if (cVar == null) {
            a(rotateInfo, context);
        } else {
            cVar.a(rotateInfo);
        }
        hb.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : hb) {
            if (aVar != null && aVar.hf == bVar) {
                hb.remove(aVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sRotateItems size " + hb.size());
    }

    private static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.g.c cVar = new com.kwad.sdk.core.g.c(rotateInfo);
        gY = cVar;
        cVar.a(new com.kwad.sdk.core.g.a() { // from class: com.kwad.components.ad.feed.d.2
            @Override // com.kwad.sdk.core.g.a
            public final void cd() {
            }

            @Override // com.kwad.sdk.core.g.a
            public final void r(String str) {
                a aVar;
                if (d.hb != null) {
                    Iterator it = d.hb.iterator();
                    while (it.hasNext() && ((aVar = (a) it.next()) == null || aVar.hf == null || !aVar.hf.s(str))) {
                    }
                    bw.a(new bg() { // from class: com.kwad.components.ad.feed.d.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onRotateEvent openGate2");
                            if (d.gY != null) {
                                d.gY.KT();
                            }
                        }
                    }, null, 1000L);
                }
            }
        });
        gY.bP(context);
    }
}
