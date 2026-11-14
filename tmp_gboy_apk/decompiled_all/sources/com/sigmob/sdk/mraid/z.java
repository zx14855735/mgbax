package com.sigmob.sdk.mraid;

import android.os.Handler;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    static final int f13502a = 50;
    static final long b = 3000000;
    private static final long d = 3000000;
    private static final Map<String, a> e = J3FDQU.A2egSU.BIYEnU();
    static final b c = new b();
    private static Handler f = new Handler();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final com.sigmob.sdk.base.views.g f13503a;
        private final WeakReference<com.sigmob.sdk.base.common.y> b;
        private final com.sigmob.sdk.base.common.u c;
        private final h d;

        public a(com.sigmob.sdk.base.views.g gVar, com.sigmob.sdk.base.common.y yVar, com.sigmob.sdk.base.common.u uVar, h hVar) {
            this.f13503a = gVar;
            this.b = new WeakReference<>(yVar);
            this.c = uVar;
            this.d = hVar;
        }

        public com.sigmob.sdk.base.views.g a() {
            return this.f13503a;
        }

        public WeakReference<com.sigmob.sdk.base.common.y> b() {
            return this.b;
        }

        public com.sigmob.sdk.base.common.u c() {
            return this.c;
        }

        public h d() {
            return this.d;
        }
    }

    public static class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.a();
        }
    }

    static {
        iLCQHwe();
    }

    private z() {
    }

    public static a a(String str) {
        Preconditions.checkNotNull(str);
        return e.remove(str);
    }

    @Deprecated
    public static void b() {
        e.clear();
        f.removeCallbacks(c);
    }

    @Deprecated
    public static Map<String, a> c() {
        return e;
    }

    private static /* synthetic */ void iLCQHwe() {
        char[] charArray = "\u009c\u0090\u0092Ñ\u0098\u009e\u0092\u009aÑ\u009d\u0090\u0086Ñ\u008c\u0097\u009a\u0093\u0093Ñµ\u0091\u0096½\u008d\u0096\u009b\u0098\u009a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 255);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009c\u0093\u0096\u0091\u0096\u008b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 255);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized void a() {
        synchronized (z.class) {
            try {
                Iterator<Map.Entry<String, a>> it = e.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, a> next = it.next();
                    if (next.getValue().b().get() == null) {
                        next.getValue().c().a();
                        it.remove();
                    }
                }
                if (e.isEmpty()) {
                    return;
                }
                Handler handler = f;
                b bVar = c;
                handler.removeCallbacks(bVar);
                f.postDelayed(bVar, 3000000L);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static void a(Handler handler) {
        f = handler;
    }

    public static void a(String str, i iVar, com.sigmob.sdk.base.views.g gVar, com.sigmob.sdk.base.common.u uVar, h hVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(iVar);
        Preconditions.checkNotNull(gVar);
        a();
        Map<String, a> map = e;
        if (map.size() >= 50) {
            SigmobLog.w("Unable to cache web view. Please destroy some via #destroy() and try again.");
        } else {
            map.put(str, new a(gVar, iVar, uVar, hVar));
        }
    }
}
