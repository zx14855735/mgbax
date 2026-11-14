package com.octopus.ad.internal.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f12395a = new AtomicInteger(0);
    private final String b;
    private volatile g c;
    private final List<b> d;
    private final b e;
    private final c f;

    public static final class a extends Handler implements b {

        /* renamed from: a, reason: collision with root package name */
        private final String f12396a;
        private final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f12396a = str;
            this.b = list;
        }

        @Override // com.octopus.ad.internal.a.b
        public void a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, this.f12396a, message.arg1);
            }
        }
    }

    public i(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = (String) n.a(str);
        this.f = (c) n.a(cVar);
        this.e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void b() {
        try {
            this.c = this.c == null ? d() : this.c;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void c() {
        if (this.f12395a.decrementAndGet() <= 0) {
            this.c.a();
            this.c = null;
        }
    }

    private g d() {
        String str = this.b;
        c cVar = this.f;
        g gVar = new g(new j(str, cVar.d, cVar.e), new com.octopus.ad.internal.a.a.b(this.f.a(this.b), this.f.c));
        gVar.a(this.e);
        return gVar;
    }

    public void a(e eVar, Socket socket) {
        b();
        try {
            this.f12395a.incrementAndGet();
            this.c.a(eVar, socket);
        } finally {
            c();
        }
    }

    public void b(b bVar) {
        this.d.remove(bVar);
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }

    public int a() {
        return this.f12395a.get();
    }
}
