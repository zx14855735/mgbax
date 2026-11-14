package com.sigmob.sdk.downloader.core.dispatcher;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sigmob.sdk.downloader.c;
import com.sigmob.sdk.downloader.d;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13369a = "CallbackDispatcher";
    private final c b;
    private final Handler c;

    /* renamed from: com.sigmob.sdk.downloader.core.dispatcher.a$a, reason: collision with other inner class name */
    public static class C0453a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f13373a;

        public C0453a(Handler handler) {
            this.f13373a = handler;
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f fVar, final int i, final int i2, final Map<String, List<String>> map) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "<----- finish connection task(" + fVar.c() + ") block(" + i + ") code[" + i2 + "]" + map);
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.a(fVar, i, i2, map);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.a(fVar, i, i2, map);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a_(final f fVar) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "taskStart: " + fVar.c());
            b(fVar);
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.a_(fVar);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.a_(fVar);
            }
        }

        public void b(f fVar) {
            d i = g.j().i();
            if (i != null) {
                i.a(fVar);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void c(final f fVar, final int i, final long j) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "fetchEnd: " + fVar.c());
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.c(fVar, i, j);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.c(fVar, i, j);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f fVar, final int i, final long j) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "fetchStart: " + fVar.c());
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.a(fVar, i, j);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.a(fVar, i, j);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(final f fVar, final int i, final long j) {
            if (fVar.t() > 0) {
                f.c.a(fVar, SystemClock.uptimeMillis());
            }
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.b(fVar, i, j);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.b(fVar, i, j);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f fVar, final int i, final Map<String, List<String>> map) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "<----- finish trial task(" + fVar.c() + ") code[" + i + "]" + map);
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.a(fVar, i, map);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.a(fVar, i, map);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(final f fVar, final int i, final Map<String, List<String>> map) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "-----> start connection task(" + fVar.c() + ") block(" + i + ") " + map);
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.b(fVar, i, map);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.b(fVar, i, map);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f fVar, final com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "downloadFromBreakpoint: " + fVar.c());
            b(fVar, cVar);
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.a(fVar, cVar);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.a(fVar, cVar);
            }
        }

        public void b(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            d i = g.j().i();
            if (i != null) {
                i.a(fVar, cVar);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f fVar, final com.sigmob.sdk.downloader.core.breakpoint.c cVar, final com.sigmob.sdk.downloader.core.cause.b bVar) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "downloadFromBeginning: " + fVar.c());
            b(fVar, cVar, bVar);
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.a(fVar, cVar, bVar);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.a(fVar, cVar, bVar);
            }
        }

        public void b(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
            d i = g.j().i();
            if (i != null) {
                i.a(fVar, cVar, bVar);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f fVar, final com.sigmob.sdk.downloader.core.cause.a aVar, final Exception exc) {
            if (aVar == com.sigmob.sdk.downloader.core.cause.a.ERROR) {
                com.sigmob.sdk.downloader.core.c.b(a.f13369a, "taskEnd: " + fVar.c() + " " + aVar + " " + exc);
            }
            b(fVar, aVar, exc);
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.a(fVar, aVar, exc);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.a(fVar, aVar, exc);
            }
        }

        public void b(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
            d i = g.j().i();
            if (i != null) {
                i.a(fVar, aVar, exc);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f fVar, final Map<String, List<String>> map) {
            com.sigmob.sdk.downloader.core.c.b(a.f13369a, "-----> start trial task(" + fVar.c() + ") " + map);
            if (fVar.s()) {
                this.f13373a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c F = fVar.F();
                        if (F != null) {
                            F.a(fVar, map);
                        }
                    }
                });
                return;
            }
            c F = fVar.F();
            if (F != null) {
                F.a(fVar, map);
            }
        }
    }

    public a() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.c = handler;
        this.b = new C0453a(handler);
    }

    public c a() {
        return this.b;
    }

    public a(Handler handler, c cVar) {
        this.c = handler;
        this.b = cVar;
    }

    public void a(final Collection<f> collection) {
        if (collection.size() <= 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(f13369a, "endTasksWithCanceled canceled[" + collection.size() + "]");
        Iterator<f> it = collection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.s()) {
                c F = next.F();
                if (F != null) {
                    F.a(next, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                }
                it.remove();
            }
        }
        this.c.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : collection) {
                    c F2 = fVar.F();
                    if (F2 != null) {
                        F2.a(fVar, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                    }
                }
            }
        });
    }

    public void a(final Collection<f> collection, final Exception exc) {
        if (collection.size() <= 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(f13369a, "endTasksWithError error[" + collection.size() + "] realCause: " + exc);
        Iterator<f> it = collection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.s()) {
                c F = next.F();
                if (F != null) {
                    F.a(next, com.sigmob.sdk.downloader.core.cause.a.ERROR, exc);
                }
                it.remove();
            }
        }
        this.c.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.1
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : collection) {
                    c F2 = fVar.F();
                    if (F2 != null) {
                        F2.a(fVar, com.sigmob.sdk.downloader.core.cause.a.ERROR, exc);
                    }
                }
            }
        });
    }

    public void a(final Collection<f> collection, final Collection<f> collection2, final Collection<f> collection3) {
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(f13369a, "endTasks completed[" + collection.size() + "] sameTask[" + collection2.size() + "] fileBusy[" + collection3.size() + "]");
        if (collection.size() > 0) {
            Iterator<f> it = collection.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!next.s()) {
                    c F = next.F();
                    if (F != null) {
                        F.a(next, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
                    }
                    it.remove();
                }
            }
        }
        if (collection2.size() > 0) {
            Iterator<f> it2 = collection2.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (!next2.s()) {
                    c F2 = next2.F();
                    if (F2 != null) {
                        F2.a(next2, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                    }
                    it2.remove();
                }
            }
        }
        if (collection3.size() > 0) {
            Iterator<f> it3 = collection3.iterator();
            while (it3.hasNext()) {
                f next3 = it3.next();
                if (!next3.s()) {
                    c F3 = next3.F();
                    if (F3 != null) {
                        F3.a(next3, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                    }
                    it3.remove();
                }
            }
        }
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        this.c.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.2
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : collection) {
                    c F4 = fVar.F();
                    if (F4 != null) {
                        F4.a(fVar, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
                    }
                }
                for (f fVar2 : collection2) {
                    c F5 = fVar2.F();
                    if (F5 != null) {
                        F5.a(fVar2, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                    }
                }
                for (f fVar3 : collection3) {
                    c F6 = fVar3.F();
                    if (F6 != null) {
                        F6.a(fVar3, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                    }
                }
            }
        });
    }

    public boolean a(f fVar) {
        long t = fVar.t();
        return t <= 0 || SystemClock.uptimeMillis() - f.c.a(fVar) >= t;
    }
}
