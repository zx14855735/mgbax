package com.kwad.sdk.crash.utils;

import ADYaiT.CtFAbx;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f {

    public static abstract class a {
        private a() {
        }

        public abstract Object NS();

        public abstract void println(Object obj);

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class b extends a {
        private final PrintWriter aVT;

        public b(PrintWriter printWriter) {
            super((byte) 0);
            this.aVT = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        public final Object NS() {
            return this.aVT;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        public final void println(Object obj) {
            this.aVT.println(obj);
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }

    private static void a(Throwable th, a aVar) {
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (aVar.NS()) {
            try {
                aVar.println(th);
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    aVar.println("\tat " + stackTraceElement);
                }
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, "Suppressed: ", "\t", newSetFromMap);
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    a(cause, aVar, "Caused by: ", "", newSetFromMap);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    private static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.println(str2 + str + th);
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.println(str2 + "\tat " + stackTraceElement);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, "Suppressed: ", CtFAbx.AcNBzu(str2, "\t"), set);
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + th + "]");
    }
}
