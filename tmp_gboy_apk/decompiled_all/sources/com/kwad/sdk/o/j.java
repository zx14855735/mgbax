package com.kwad.sdk.o;

import AZOQYO.ADYaiT;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j {
    private static final String CLAZZ_NAME = "com.kwad.sdk.o.j";
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean biZ = new AtomicBoolean(false);

    public static class a {
        private WeakReference<Context> auq;
        private int aur;
        private StackTraceElement[] aus;
        private int aut;
        private long auu;

        private a() {
            this.auq = new WeakReference<>(null);
            this.aur = 0;
            this.aus = null;
            this.aut = 0;
        }

        public static /* synthetic */ int c(a aVar) {
            int i = aVar.aur;
            aVar.aur = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.auq = new WeakReference<>(null);
            this.aur = 0;
            this.aus = null;
            this.aut = 0;
            this.auu = 0L;
        }

        public static /* synthetic */ int g(a aVar) {
            int i = aVar.aut;
            aVar.aut = i + 1;
            return i;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        pFmVpYJ();
    }

    public static boolean UP() {
        return biZ.get();
    }

    private static boolean a(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, aVar.aus)) {
            a.g(aVar);
            aVar.aus = stackTrace;
            return aVar.aut >= 5;
        }
        if (aVar.aus != null) {
            aVar.clear();
            return false;
        }
        aVar.aus = stackTrace;
        int i = 0;
        int i2 = 0;
        while (i < stackTrace.length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            for (String str : getAutoUnWrapStackList()) {
                if (!TextUtils.isEmpty(str) && className.contains(str)) {
                    return true;
                }
            }
            String methodName = stackTraceElement.getMethodName();
            i++;
            if (i < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                StackTraceElement stackTraceElement2 = stackTrace[i];
                if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void b(final Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            com.kwad.sdk.core.c.b.Ji();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.o.j.1
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityDestroyed */
                public final void b(Activity activity) {
                    if (activity == context) {
                        com.kwad.sdk.core.c.b.Ji();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        j.onDestroy(context);
                    }
                }
            });
        }
    }

    public static void cx(boolean z) {
        biZ.set(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static Context es(Context context) {
        boolean z = context instanceof b;
        Context context2 = context;
        if (z) {
            context2 = ((b) context).getDelegatedContext();
        }
        if (m.ez(context2)) {
            return context2;
        }
        RuntimeException runtimeException = null;
        int i = 0;
        Context context3 = context2;
        while (i < 10) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context3.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            boolean aW = k.aW(context3);
            ?? r5 = context3;
            if (aW) {
                r5 = k.aV(context3);
            }
            boolean z2 = r5 instanceof b;
            Context context4 = r5;
            if (z2) {
                context4 = ((b) r5).getDelegatedContext();
            }
            if (m.ez(context4)) {
                return context4;
            }
            i++;
            context3 = context4;
        }
        return context3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static Context et(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context applicationContext = es(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        int i = 0;
        Context context2 = applicationContext;
        while (i < 10) {
            Context applicationContext2 = context2.getApplicationContext();
            if (applicationContext2 instanceof Application) {
                return applicationContext2;
            }
            if (applicationContext2 instanceof b) {
                applicationContext2 = ((b) applicationContext2).getDelegatedContext();
            }
            i++;
            context2 = applicationContext2;
        }
        return context2;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    private static /* synthetic */ void pFmVpYJ() {
        char[] charArray = "¬ ¢á¨®¢ªá\u00ad ¶á¼§ª££á\u0085¡¦\u008d½¦«¨ª".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 207);
        }
        String str = new String(charArray);
        char[] charArray2 = "¬£¦¡¦»".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 207);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = f.UK().getClassLoader();
        return classLoader2 != null ? classLoader2 : classLoader;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources resources = f.UK().getResources();
        if (resources == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i, true);
        return newTheme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        byte b = 0;
        if (aVar == null) {
            threadLocal.set(new a(b));
        } else if (aVar.auq.get() != context || Math.abs(System.currentTimeMillis() - aVar.auu) >= 150) {
            aVar.clear();
            aVar.auq = new WeakReference(context);
            aVar.auu = System.currentTimeMillis();
        } else {
            a.c(aVar);
            if (aVar.aur >= (context instanceof Application ? 15 : 5) && a(context, aVar)) {
                aVar.clear();
                return true;
            }
        }
        return false;
    }

    public static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        }
        com.kwad.sdk.core.d.c.w("Wrapper", "wrapContextIfNeed run context is: " + context);
        if (!m.UV() || (context instanceof b)) {
            return context;
        }
        if (k.aW(context)) {
            context = k.unwrapContextIfNeed(context);
            if (k.aW(context)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                return context;
            }
        }
        Context context3 = sResContextCache.get(context);
        if (context3 instanceof b) {
            return context3;
        }
        if (l.eu(context)) {
            return context;
        }
        if (returnUnWrappedContext(context)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: ".concat(context.getClass().getName())));
            return context;
        }
        if (context instanceof Application) {
            try {
                g gVar = new g((Application) context, new h(context, f.UK()));
                m.b(gVar);
                context2 = gVar;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.w("Wrapper", "wrapContextIfNeed Application error: " + th.getMessage());
                th.printStackTrace();
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("wrapper Application fail --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CW()));
                return context;
            }
        } else {
            context2 = context instanceof ContextThemeWrapper ? new c((ContextThemeWrapper) context) : context instanceof ADYaiT ? new d((ADYaiT) context) : context instanceof ContextWrapper ? new e(context) : new e(context);
        }
        b(context, context2);
        return context2;
    }
}
