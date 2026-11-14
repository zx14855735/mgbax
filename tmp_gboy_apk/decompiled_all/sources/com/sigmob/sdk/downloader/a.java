package com.sigmob.sdk.downloader;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.listener.f;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {
    private static final String c = "DownloadContext";
    private static final Executor d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Serial", false));

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f13337a;
    final com.sigmob.sdk.downloader.b b;
    private final f[] e;
    private final d f;
    private Handler g;

    /* renamed from: com.sigmob.sdk.downloader.a$a, reason: collision with other inner class name */
    public static class C0450a {

        /* renamed from: a, reason: collision with root package name */
        private final a f13340a;

        public C0450a(a aVar) {
            this.f13340a = aVar;
        }

        public C0450a a(f fVar, f fVar2) {
            f[] fVarArr = this.f13340a.e;
            for (int i = 0; i < fVarArr.length; i++) {
                if (fVarArr[i] == fVar) {
                    fVarArr[i] = fVar2;
                }
            }
            return this;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<f> f13341a;
        private final d b;
        private com.sigmob.sdk.downloader.b c;

        public b() {
            this(new d());
        }

        public b a(com.sigmob.sdk.downloader.b bVar) {
            this.c = bVar;
            return this;
        }

        public void b(f fVar) {
            this.f13341a.remove(fVar);
        }

        public b(d dVar) {
            this(dVar, new ArrayList());
        }

        public b a(f fVar) {
            int indexOf = this.f13341a.indexOf(fVar);
            if (indexOf >= 0) {
                this.f13341a.set(indexOf, fVar);
                return this;
            }
            this.f13341a.add(fVar);
            return this;
        }

        public b(d dVar, ArrayList<f> arrayList) {
            this.b = dVar;
            this.f13341a = arrayList;
        }

        public a a() {
            return new a((f[]) this.f13341a.toArray(new f[this.f13341a.size()]), this.c, this.b);
        }

        public f a(f.a aVar) {
            if (this.b.f13343a != null) {
                aVar.a(this.b.f13343a);
            }
            if (this.b.c != null) {
                aVar.d(this.b.c.intValue());
            }
            if (this.b.d != null) {
                aVar.e(this.b.d.intValue());
            }
            if (this.b.e != null) {
                aVar.f(this.b.e.intValue());
            }
            if (this.b.j != null) {
                aVar.d(this.b.j.booleanValue());
            }
            if (this.b.f != null) {
                aVar.g(this.b.f.intValue());
            }
            if (this.b.g != null) {
                aVar.b(this.b.g.booleanValue());
            }
            if (this.b.h != null) {
                aVar.b(this.b.h.intValue());
            }
            if (this.b.i != null) {
                aVar.c(this.b.i.booleanValue());
            }
            f a2 = aVar.a();
            if (this.b.k != null) {
                a2.a(this.b.k);
            }
            this.f13341a.add(a2);
            return a2;
        }

        public f a(String str) {
            if (this.b.b != null) {
                return a(new f.a(str, this.b.b).a(Boolean.TRUE));
            }
            throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
        }

        public void a(int i) {
            for (f fVar : (List) this.f13341a.clone()) {
                if (fVar.c() == i) {
                    this.f13341a.remove(fVar);
                }
            }
        }
    }

    public static class c extends com.sigmob.sdk.downloader.core.listener.b {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f13342a;
        private final com.sigmob.sdk.downloader.b b;
        private final a c;

        public c(a aVar, com.sigmob.sdk.downloader.b bVar, int i) {
            this.f13342a = new AtomicInteger(i);
            this.b = bVar;
            this.c = aVar;
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
            int decrementAndGet = this.f13342a.decrementAndGet();
            this.b.a(this.c, fVar, aVar, exc, decrementAndGet);
            if (decrementAndGet <= 0) {
                this.b.a(this.c);
                com.sigmob.sdk.downloader.core.c.b(a.c, "taskEnd and remainCount " + decrementAndGet);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a_(f fVar) {
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, List<String>> f13343a;
        private Uri b;
        private Integer c;
        private Integer d;
        private Integer e;
        private Integer f;
        private Boolean g;
        private Integer h;
        private Boolean i;
        private Boolean j;
        private Object k;

        public Uri b() {
            return this.b;
        }

        public int c() {
            Integer num = this.c;
            return num == null ? f.a.c : num.intValue();
        }

        public d d(int i) {
            this.f = Integer.valueOf(i);
            return this;
        }

        public int e() {
            Integer num = this.d;
            return num == null ? f.a.d : num.intValue();
        }

        public int f() {
            Integer num = this.e;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public int g() {
            Integer num = this.f;
            if (num == null) {
                return 2000;
            }
            return num.intValue();
        }

        public int i() {
            Integer num = this.h;
            if (num == null) {
                return 1000;
            }
            return num.intValue();
        }

        public b l() {
            return new b(this);
        }

        public d a(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public d b(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public d c(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public boolean h() {
            Boolean bool = this.g;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public Object j() {
            return this.k;
        }

        public boolean k() {
            Boolean bool = this.i;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public d a(Uri uri) {
            this.b = uri;
            return this;
        }

        public d b(Boolean bool) {
            this.g = bool;
            return this;
        }

        public boolean d() {
            Boolean bool = this.j;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public d a(File file) {
            if (file.isFile()) {
                throw new IllegalArgumentException("parent path only accept directory path");
            }
            this.b = Uri.fromFile(file);
            return this;
        }

        public d a(Boolean bool) {
            this.j = bool;
            return this;
        }

        public d a(Integer num) {
            this.h = num;
            return this;
        }

        public d a(Object obj) {
            this.k = obj;
            return this;
        }

        public d a(String str) {
            return a(new File(str));
        }

        public d a(boolean z) {
            this.i = Boolean.valueOf(z);
            return this;
        }

        public Map<String, List<String>> a() {
            return this.f13343a;
        }

        public void a(Map<String, List<String>> map) {
            this.f13343a = map;
        }
    }

    static {
        NSlaqD();
    }

    public a(f[] fVarArr, com.sigmob.sdk.downloader.b bVar, d dVar) {
        this.f13337a = false;
        this.e = fVarArr;
        this.b = bVar;
        this.f = dVar;
    }

    private static /* synthetic */ void NSlaqD() {
        char[] charArray = "mac iock law }fkbb D`gL|gjik".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 14);
        }
        String str = new String(charArray);
        char[] charArray2 = "mbg`gz".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 14);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void b(com.sigmob.sdk.downloader.c cVar) {
        a(cVar, false);
    }

    public C0450a c() {
        return new C0450a(this);
    }

    public void d() {
        if (this.f13337a) {
            g.j().a().a((com.sigmob.sdk.downloader.core.a[]) this.e);
        }
        this.f13337a = false;
    }

    public b e() {
        return new b(this.f, new ArrayList(Arrays.asList(this.e))).a(this.b);
    }

    public a(f[] fVarArr, com.sigmob.sdk.downloader.b bVar, d dVar, Handler handler) {
        this(fVarArr, bVar, dVar);
        this.g = handler;
    }

    public void a(com.sigmob.sdk.downloader.c cVar) {
        a(cVar, true);
    }

    public f[] b() {
        return this.e;
    }

    public void a(final com.sigmob.sdk.downloader.c cVar, boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        com.sigmob.sdk.downloader.core.c.b(c, "start " + z);
        this.f13337a = true;
        if (this.b != null) {
            cVar = new f.a().a(cVar).a(new c(this, this.b, this.e.length)).a();
        }
        if (z) {
            final ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.e);
            Collections.sort(arrayList);
            a(new Runnable() { // from class: com.sigmob.sdk.downloader.a.1
                @Override // java.lang.Runnable
                public void run() {
                    for (f fVar : arrayList) {
                        if (!a.this.a()) {
                            a.this.a(fVar.s());
                            return;
                        }
                        fVar.c(cVar);
                    }
                }
            });
        } else {
            f.a(this.e, cVar);
        }
        com.sigmob.sdk.downloader.core.c.b(c, "start finish " + z + " " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    public void a(Runnable runnable) {
        d.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.sigmob.sdk.downloader.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        if (!z) {
            bVar.a(this);
            return;
        }
        if (this.g == null) {
            this.g = new Handler(Looper.getMainLooper());
        }
        this.g.post(new Runnable() { // from class: com.sigmob.sdk.downloader.a.2
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.b.a(aVar);
            }
        });
    }

    public boolean a() {
        return this.f13337a;
    }
}
