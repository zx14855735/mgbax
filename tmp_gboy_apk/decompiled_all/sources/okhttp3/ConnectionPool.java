package okhttp3;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.player.C;
import java.lang.ref.Reference;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.A5SV6n;
import okhttp3.internal.connection.ADYaiT;
import okhttp3.internal.connection.AMqCpz;
import okhttp3.internal.connection.AYUAbz;
import okhttp3.internal.platform.ARc23Z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor;
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<ADYaiT> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final AMqCpz routeDatabase;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = A5SV6n.EMPTY_BYTE_ARRAY;
        executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new okhttp3.internal.ADYaiT("OkHttp ConnectionPool", true));
        JMQtz();
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private static /* synthetic */ void JMQtz() {
        char[] charArray = "\f\u0000\u0002A\b\u000e\u0002\nA\r\u0000\u0016A\u001c\u0007\n\u0003\u0003A%\u0001\u0006-\u001d\u0006\u000b\b\n".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'o');
        }
        String str = new String(charArray);
        char[] charArray2 = "\f\u0003\u0006\u0001\u0006\u001b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'o');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private int pruneAndGetAllocationCount(ADYaiT aDYaiT, long j) {
        List<Reference<AYUAbz>> list = aDYaiT.allocations;
        int i = 0;
        while (i < list.size()) {
            Reference<AYUAbz> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                ARc23Z.AZOQYO().AzWtSf(((AYUAbz.A2egSU) reference).callStackTrace, "A connection to " + aDYaiT.route().address().url() + " was leaked. Did you forget to close a response body?");
                list.remove(i);
                aDYaiT.noNewStreams = true;
                if (list.isEmpty()) {
                    aDYaiT.idleAtNanos = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long cleanup(long j) {
        synchronized (this) {
            try {
                ADYaiT aDYaiT = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (ADYaiT aDYaiT2 : this.connections) {
                    if (pruneAndGetAllocationCount(aDYaiT2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - aDYaiT2.idleAtNanos;
                        if (j3 > j2) {
                            aDYaiT = aDYaiT2;
                            j2 = j3;
                        }
                    }
                }
                long j4 = this.keepAliveDurationNs;
                if (j2 < j4 && i <= this.maxIdleConnections) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.cleanupRunning = false;
                    return -1L;
                }
                this.connections.remove(aDYaiT);
                A5SV6n.ASJ6gh(aDYaiT.socket());
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean connectionBecameIdle(ADYaiT aDYaiT) {
        if (aDYaiT.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(aDYaiT);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    @Nullable
    public Socket deduplicate(Address address, AYUAbz aYUAbz) {
        for (ADYaiT aDYaiT : this.connections) {
            if (aDYaiT.AYUAbz(address, null) && aDYaiT.AZkASS() && aDYaiT != aYUAbz.ADYaiT()) {
                return aYUAbz.AcNBzu(aDYaiT);
            }
        }
        return null;
    }

    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<ADYaiT> it = this.connections.iterator();
                while (it.hasNext()) {
                    ADYaiT next = it.next();
                    if (next.allocations.isEmpty()) {
                        next.noNewStreams = true;
                        arrayList.add(next);
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            A5SV6n.ASJ6gh(((ADYaiT) it2.next()).socket());
        }
    }

    @Nullable
    public ADYaiT get(Address address, AYUAbz aYUAbz, Route route) {
        for (ADYaiT aDYaiT : this.connections) {
            if (aDYaiT.AYUAbz(address, route)) {
                aYUAbz.A2egSU(aDYaiT, true);
                return aDYaiT;
            }
        }
        return null;
    }

    public synchronized int idleConnectionCount() {
        int i;
        Iterator<ADYaiT> it = this.connections.iterator();
        i = 0;
        while (it.hasNext()) {
            if (it.next().allocations.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public void put(ADYaiT aDYaiT) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(aDYaiT);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.cleanupRunnable = new Runnable() { // from class: okhttp3.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long cleanup = ConnectionPool.this.cleanup(System.nanoTime());
                    if (cleanup == -1) {
                        return;
                    }
                    if (cleanup > 0) {
                        long j2 = cleanup / C.MICROS_PER_SECOND;
                        long j3 = cleanup - (C.MICROS_PER_SECOND * j2);
                        synchronized (ConnectionPool.this) {
                            try {
                                ConnectionPool.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.connections = new ArrayDeque();
        this.routeDatabase = new AMqCpz();
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("keepAliveDuration <= 0: ", j));
        }
    }
}
