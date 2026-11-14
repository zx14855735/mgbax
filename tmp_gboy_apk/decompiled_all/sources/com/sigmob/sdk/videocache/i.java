package com.sigmob.sdk.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13732a = 1;
    private static final int b = 2;
    private final AtomicInteger c = new AtomicInteger(0);
    private final String d;
    private volatile g e;
    private final List<d> f;
    private final d g;
    private final e h;

    public static final class a extends Handler implements d {

        /* renamed from: a, reason: collision with root package name */
        private final String f13733a;
        private final List<d> b;

        public a(String str, List<d> list) {
            super(Looper.getMainLooper());
            this.f13733a = str;
            this.b = list;
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            obtainMessage.what = 1;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (d dVar : this.b) {
                int i = message.what;
                if (i == 1) {
                    dVar.a((File) message.obj, this.f13733a, message.arg1);
                } else if (i == 2) {
                    dVar.a(this.f13733a, (Throwable) message.obj);
                }
            }
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(String str, Throwable th) {
            Message obtainMessage = obtainMessage();
            obtainMessage.obj = th;
            obtainMessage.what = 2;
            sendMessage(obtainMessage);
        }
    }

    public i(String str, e eVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f = copyOnWriteArrayList;
        this.d = (String) o.a(str);
        this.h = (e) o.a(eVar);
        this.g = new a(str, copyOnWriteArrayList);
    }

    private synchronized void c() {
        try {
            this.e = this.e == null ? e() : this.e;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void d() {
        if (this.c.decrementAndGet() <= 0) {
            this.e.a();
            this.e = null;
        }
    }

    private g e() {
        String str = this.d;
        e eVar = this.h;
        g gVar = new g(t.a(str, eVar.d, eVar.e), new com.sigmob.sdk.videocache.file.b(this.h.a(this.d), this.h.c));
        gVar.a(this.g);
        return gVar;
    }

    public void a() {
        this.f.clear();
        if (this.e != null) {
            this.e.a((d) null);
            this.e.a();
            this.e = null;
        }
        this.c.set(0);
    }

    public int b() {
        return this.c.get();
    }

    public void a(d dVar) {
        this.f.add(dVar);
    }

    public void b(d dVar) {
        this.f.remove(dVar);
    }

    public void a(f fVar, Socket socket) {
        c();
        try {
            this.c.incrementAndGet();
            this.e.a(fVar, socket);
        } catch (Throwable th) {
            try {
                SigmobLog.e("processRequest error:", th);
            } finally {
                d();
            }
        }
    }
}
