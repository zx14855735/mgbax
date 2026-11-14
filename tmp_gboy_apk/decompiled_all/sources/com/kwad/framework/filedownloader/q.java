package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class q {
    private final b aqw = new b();

    public static class a {
        private static final q aqx = new q();

        static {
            com.kwad.framework.filedownloader.message.e.Ax().a(new aa());
            Jmyjpc();
        }

        private static /* synthetic */ void Jmyjpc() {
            char[] charArray = "¨¤¦å¬ª¦®å©¤²å¸£®§§å\u0081¥¢\u0089¹¢¯¬®".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 203);
            }
            String str = new String(charArray);
            char[] charArray2 = "¨§¢¥¢¿".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 203);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class b {
        private ThreadPoolExecutor aqy;
        private LinkedBlockingQueue<Runnable> aqz;

        public b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aqz = linkedBlockingQueue;
            this.aqy = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aqz.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aqy.execute(new c(bVar));
        }
    }

    public static class c implements Runnable {
        private final x.b aqA;
        private boolean aqB = false;

        public c(x.b bVar) {
            this.aqA = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aqA;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aqB) {
                return;
            }
            this.aqA.start();
        }
    }

    public static q zk() {
        return a.aqx;
    }

    public final synchronized void a(x.b bVar) {
        this.aqw.c(bVar);
    }

    public final synchronized void b(x.b bVar) {
        this.aqw.b(bVar);
    }
}
