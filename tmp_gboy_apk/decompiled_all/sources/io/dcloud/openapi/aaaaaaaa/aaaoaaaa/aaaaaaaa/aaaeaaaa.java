package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.player.C;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae;
import java.lang.ref.Reference;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaeaaaa {
    private static final Executor aaaaaaae = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean aaaaaaav = true;
    private final long aaaaaaa0;
    private final int aaaaaaaa;
    private final Deque aaaaaaac;
    boolean aaaaaaan;
    private final Runnable aaaaaaao;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaac aaaaaaau;

    public class aaaaaaaa implements Runnable {
        public aaaaaaaa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long aaaaaaaa = aaaeaaaa.this.aaaaaaaa(System.nanoTime());
                if (aaaaaaaa == -1) {
                    return;
                }
                if (aaaaaaaa > 0) {
                    long j = aaaaaaaa / C.MICROS_PER_SECOND;
                    long j2 = aaaaaaaa - (C.MICROS_PER_SECOND * j);
                    synchronized (aaaeaaaa.this) {
                        try {
                            aaaeaaaa.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    static {
        YnQRT();
    }

    public aaaeaaaa() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private static /* synthetic */ void YnQRT() {
        char[] charArray = "ãïí®çáíå®âïù®óèåìì®ÊîéÂòéäçå".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 128);
        }
        String str = new String(charArray);
        char[] charArray2 = "ãìéîéô".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 128);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar) {
        if (!aaaaaaav && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.aaaaaaan) {
            this.aaaaaaan = true;
            aaaaaaae.execute(this.aaaaaaao);
        }
        this.aaaaaaac.add(aaaaaaaoVar);
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar, aa0aaaaa aa0aaaaaVar) {
        if (!aaaaaaav && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar : this.aaaaaaac) {
            if (aaaaaaaoVar.aaaaaaaa(aaaaaaaaVar, aa0aaaaaVar)) {
                aaaaaaaeVar.aaaaaaaa(aaaaaaaoVar, true);
                return aaaaaaaoVar;
            }
        }
        return null;
    }

    public aaaeaaaa(int i, long j, TimeUnit timeUnit) {
        this.aaaaaaao = new aaaaaaaa();
        this.aaaaaaac = new ArrayDeque();
        this.aaaaaaau = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaac();
        this.aaaaaaaa = i;
        this.aaaaaaa0 = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("keepAliveDuration <= 0: ", j));
        }
    }

    public Socket aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar) {
        if (!aaaaaaav && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar : this.aaaaaaac) {
            if (aaaaaaaoVar.aaaaaaaa(aaaaaaaaVar, null) && aaaaaaaoVar.aaaaaaac() && aaaaaaaoVar != aaaaaaaeVar.aaaaaaao()) {
                return aaaaaaaeVar.aaaaaaa0(aaaaaaaoVar);
            }
        }
        return null;
    }

    public boolean aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar) {
        if (!aaaaaaav && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!aaaaaaaoVar.aaaaeaaa && this.aaaaaaaa != 0) {
            notifyAll();
            return false;
        }
        this.aaaaaaac.remove(aaaaaaaoVar);
        return true;
    }

    public long aaaaaaaa(long j) {
        synchronized (this) {
            try {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar2 : this.aaaaaaac) {
                    if (aaaaaaaa(aaaaaaaoVar2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - aaaaaaaoVar2.aeaaaaaa;
                        if (j3 > j2) {
                            aaaaaaaoVar = aaaaaaaoVar2;
                            j2 = j3;
                        }
                    }
                }
                long j4 = this.aaaaaaa0;
                if (j2 < j4 && i <= this.aaaaaaaa) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.aaaaaaan = false;
                    return -1L;
                }
                this.aaaaaaac.remove(aaaaaaaoVar);
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaoVar.aaaaaaan());
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar, long j) {
        List list = aaaaaaaoVar.eaaaaaaa;
        int i = 0;
        while (i < list.size()) {
            Reference reference = (Reference) list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa("A connection to " + aaaaaaaoVar.aaaaaaau().aaaaaaaa().aaaaeaaa() + " was leaked. Did you forget to close a response body?", ((aaaaaaae.aaaaaaaa) reference).aaaaaaaa);
                list.remove(i);
                aaaaaaaoVar.aaaaeaaa = true;
                if (list.isEmpty()) {
                    aaaaaaaoVar.aeaaaaaa = j - this.aaaaaaa0;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
