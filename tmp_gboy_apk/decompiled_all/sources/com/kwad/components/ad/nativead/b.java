package com.kwad.components.ad.nativead;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bz;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b {
    private static long hc;
    private com.kwad.sdk.core.g.d gX;
    private com.kwad.sdk.core.g.c gY;
    private int oB;
    private CopyOnWriteArrayList<d> oz = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<C0248b> oA = new CopyOnWriteArrayList<>();

    public static final class a {
        private static final b oE = new b();

        static {
            GgpNkYP();
        }

        private static /* synthetic */ void GgpNkYP() {
            char[] charArray = "¶º¸û²´¸°û·º¬û¦½°¹¹û\u009f»¼\u0097§¼±²°".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 213);
            }
            String str = new String(charArray);
            char[] charArray2 = "¶¹¼»¼¡".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 213);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    /* renamed from: com.kwad.components.ad.nativead.b$b, reason: collision with other inner class name */
    public static class C0248b {
        private Context mContext;
        private c oF;

        public C0248b(c cVar, Context context) {
            this.oF = cVar;
            this.mContext = context;
        }
    }

    public interface c {
        void B(String str);
    }

    public static class d {
        private final e oG;
        private final WeakReference<View> oH;

        public d(e eVar, View view) {
            this.oH = new WeakReference<>(view);
            this.oG = eVar;
        }
    }

    public interface e {
        void f(double d);
    }

    public static synchronized boolean bX() {
        synchronized (b.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - hc <= 500) {
                return false;
            }
            hc = elapsedRealtime;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(double d2) {
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.oz;
        int Hw = (int) (com.kwad.sdk.core.config.e.Hw() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<d> it = copyOnWriteArrayList.iterator();
        d dVar = null;
        d dVar2 = null;
        int i = Integer.MAX_VALUE;
        while (it.hasNext()) {
            d next = it.next();
            WeakReference weakReference = next.oH;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bz.q((View) weakReference.get(), Hw)) {
                    int i2 = this.oB / 2;
                    int min = Math.min(Math.abs(rect.top - i2), Math.abs(rect.bottom - i2));
                    if (min < i) {
                        dVar = next;
                        i = min;
                    } else if (min == i) {
                        dVar2 = next;
                    }
                }
            }
        }
        if (dVar != null) {
            if (dVar2 != null) {
                Rect rect2 = new Rect();
                ((View) dVar.oH.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) dVar2.oH.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    dVar = dVar2;
                }
            }
            dVar.oG.f(d2);
        }
    }

    public static b fn() {
        return a.oE;
    }

    public final void D(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = this.gY;
            if (cVar != null) {
                cVar.bQ(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void N(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = this.gY;
            if (cVar != null) {
                cVar.bP(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void a(float f, View view, e eVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.gX == null) {
            this.oB = com.kwad.sdk.c.a.a.br(view.getContext());
            a(f, view.getContext());
        }
        this.oz.add(new d(eVar, view));
    }

    public final void a(e eVar) {
        Iterator<d> it = this.oz.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.oG == eVar) {
                this.oz.remove(next);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "sShakeItems size " + this.oz.size());
    }

    private void a(float f, Context context) {
        this.gX = new com.kwad.sdk.core.g.d(f);
        this.oz = new CopyOnWriteArrayList<>();
        this.gX.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.nativead.b.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d2) {
                if (b.this.oz != null) {
                    b.this.e(d2);
                    bw.a(new bg() { // from class: com.kwad.components.ad.nativead.b.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "onShakeEvent openGate2");
                            b.this.gX.KT();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void cc() {
            }
        });
        this.gX.k(f);
        this.gX.bP(context);
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, c cVar) {
        com.kwad.sdk.core.g.c cVar2 = this.gY;
        if (cVar2 == null) {
            a(rotateInfo, context);
        } else {
            cVar2.a(rotateInfo);
        }
        this.oA.add(new C0248b(cVar, context));
    }

    public final void a(c cVar) {
        Iterator<C0248b> it = this.oA.iterator();
        while (it.hasNext()) {
            C0248b next = it.next();
            if (next != null && next.oF == cVar) {
                this.oA.remove(next);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "sRotateItems size " + this.oA.size());
    }

    private void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.g.c cVar = new com.kwad.sdk.core.g.c(rotateInfo);
        this.gY = cVar;
        cVar.a(new com.kwad.sdk.core.g.a() { // from class: com.kwad.components.ad.nativead.b.2
            @Override // com.kwad.sdk.core.g.a
            public final void cd() {
            }

            @Override // com.kwad.sdk.core.g.a
            public final void r(String str) {
                if (b.this.oA != null) {
                    Iterator it = b.this.oA.iterator();
                    while (it.hasNext()) {
                        C0248b c0248b = (C0248b) it.next();
                        if (c0248b != null && c0248b.oF != null) {
                            c0248b.oF.B(str);
                            return;
                        }
                    }
                }
            }
        });
        this.gY.bP(context);
    }
}
