package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.ax;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.OkHttpClient;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class g {
    private final c aPS;
    private final AtomicInteger aPW = new AtomicInteger(0);
    private volatile e aPX;
    private final List<b> aPY;
    private final b aPZ;
    private final String url;

    public static final class a extends Handler implements b {
        private final List<b> aPY;
        private final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.aPY = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<b> it = this.aPY.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.aPY = copyOnWriteArrayList;
        this.url = ax.hy(str);
        this.aPS = (c) ax.checkNotNull(cVar);
        this.aPZ = new a(str, copyOnWriteArrayList);
    }

    private synchronized void Mi() {
        try {
            if (this.aPS.aPE == 1 && isOkHttpSupported()) {
                this.aPX = this.aPX == null ? Ml() : this.aPX;
            } else {
                this.aPX = this.aPX == null ? Mk() : this.aPX;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void Mj() {
        if (this.aPW.decrementAndGet() <= 0) {
            this.aPX.shutdown();
            this.aPX = null;
        }
    }

    private e Mk() {
        String str = this.url;
        c cVar = this.aPS;
        e eVar = new e(new h(str, cVar.aPC, cVar.aPD), new com.kwad.sdk.core.videocache.a.b(this.aPS.eW(this.url), this.aPS.aPB));
        eVar.a(this.aPZ);
        return eVar;
    }

    private e Ml() {
        String str = this.url;
        c cVar = this.aPS;
        e eVar = new e(new j(str, cVar.aPC, cVar.aPD), new com.kwad.sdk.core.videocache.a.b(this.aPS.eW(this.url), this.aPS.aPB));
        eVar.a(this.aPZ);
        return eVar;
    }

    private static boolean isOkHttpSupported() {
        try {
            int i = OkHttpClient.f14069AcNBzu;
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final int Mf() {
        return this.aPW.get();
    }

    public final void a(d dVar, Socket socket) {
        Mi();
        try {
            this.aPW.incrementAndGet();
            this.aPX.a(dVar, socket);
        } finally {
            Mj();
        }
    }

    public final void shutdown() {
        this.aPY.clear();
        e eVar = this.aPX;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.aPX = null;
        this.aPW.set(0);
    }
}
