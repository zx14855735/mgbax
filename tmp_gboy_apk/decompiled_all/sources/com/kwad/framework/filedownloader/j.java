package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class j {
    static int aqh = 10;
    static int aqi = 5;
    private final Executor aqd;
    private final LinkedBlockingQueue<t> aqe;
    private final Object aqf;
    private final ArrayList<t> aqg;
    private final Handler handler;

    public static final class a {
        private static final j aql = new j(0);

        static {
            EeDHZq();
        }

        private static /* synthetic */ void EeDHZq() {
            char[] charArray = ", \"a(.\"*a- 6a<'*##a\u0005!&\r=&+(*".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'O');
            }
            String str = new String(charArray);
            char[] charArray2 = ",#&!&;".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'O');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class b implements Handler.Callback {
        private b() {
        }

        private static void a(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null) {
                    next.yZ();
                }
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((t) message.obj).yZ();
            } else if (i == 2) {
                a((ArrayList) message.obj);
                j.yV().push();
            }
            return true;
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public /* synthetic */ j(byte b2) {
        this();
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.aqf) {
            this.aqe.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.aqf) {
            try {
                if (this.aqg.isEmpty()) {
                    if (this.aqe.isEmpty()) {
                        return;
                    }
                    int i = 0;
                    if (yW()) {
                        int i2 = aqh;
                        int min = Math.min(this.aqe.size(), aqi);
                        while (i < min) {
                            this.aqg.add(this.aqe.remove());
                            i++;
                        }
                        i = i2;
                    } else {
                        this.aqe.drainTo(this.aqg);
                    }
                    Handler handler = this.handler;
                    handler.sendMessageDelayed(handler.obtainMessage(2, this.aqg), i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static j yV() {
        return a.aql;
    }

    private static boolean yW() {
        return aqh > 0;
    }

    private j() {
        this.aqd = com.kwad.framework.filedownloader.f.b.u(5, "BlockCompleted");
        this.aqf = new Object();
        this.aqg = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.aqe = new LinkedBlockingQueue<>();
    }

    public final void a(t tVar) {
        a(tVar, false);
    }

    private void a(final t tVar, boolean z) {
        if (tVar.za()) {
            tVar.yZ();
            return;
        }
        if (tVar.zb()) {
            this.aqd.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.yZ();
                }
            });
            return;
        }
        if (!yW() && !this.aqe.isEmpty()) {
            synchronized (this.aqf) {
                try {
                    if (!this.aqe.isEmpty()) {
                        Iterator<t> it = this.aqe.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.aqe.clear();
                } finally {
                }
            }
        }
        if (!yW()) {
            b(tVar);
        } else {
            c(tVar);
        }
    }
}
