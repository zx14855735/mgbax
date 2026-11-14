package MhxuEA;

import IQ76hF.AmA8tU;
import com.sigmob.sdk.archives.tar.e;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final byte[] f5350B3GDIM = {72, e.Q};

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final byte[] f5351B4ZgIw = {72, 75};

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final byte[] f5352B7CMnp = {80, 73, 78, 71};

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final byte[] f5353B9tovu = {80, 79, 78, 71};

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final byte[] f5354BChYOn = {68, 73, e.Q, 67};

    /* renamed from: AZOQYO, reason: collision with root package name */
    public ScheduledExecutorService f5362AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public ScheduledFuture f5363AZkASS;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final AmA8tU f5370B2KMhB;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ConcurrentHashMap f5356A4TApA = new ConcurrentHashMap();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f5357A5SV6n = new Object();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public volatile long f5358ADYaiT = 0;
    public volatile long AMqCpz = 0;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final ScheduledExecutorService f5359ARc23Z = Executors.newSingleThreadScheduledExecutor(new A4TApA("KCP-Receive"));

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final ScheduledExecutorService f5360ASJ6gh = Executors.newSingleThreadScheduledExecutor(new A4TApA("KCP-Update"));

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ScheduledExecutorService f5361AYUAbz = Executors.newSingleThreadScheduledExecutor(new A4TApA("KCP-Connect"));

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final AtomicBoolean f5364AaHO0E = new AtomicBoolean(true);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AtomicBoolean f5365AcNBzu = new AtomicBoolean(false);

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AtomicBoolean f5366AlLFFp = new AtomicBoolean(false);

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AtomicLong f5367AmA8tU = new AtomicLong(System.currentTimeMillis());

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AtomicInteger f5368AzWtSf = new AtomicInteger(0);

    /* renamed from: B25kr6, reason: collision with root package name */
    public final AtomicBoolean f5369B25kr6 = new AtomicBoolean(false);

    /* renamed from: A2egSU, reason: collision with root package name */
    public volatile DatagramSocket f5355A2egSU = new DatagramSocket();

    public A5SV6n(AmA8tU amA8tU) {
        this.f5370B2KMhB = amA8tU;
    }

    public static void A2egSU(A5SV6n a5SV6n) {
        synchronized (a5SV6n) {
            ScheduledExecutorService scheduledExecutorService = a5SV6n.f5362AZOQYO;
            if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                a5SV6n.f5362AZOQYO = Executors.newSingleThreadScheduledExecutor(new A4TApA("KCP-Heartbeat"));
                a5SV6n.f5367AmA8tU.set(System.currentTimeMillis());
                a5SV6n.f5368AzWtSf.set(0);
                a5SV6n.AMqCpz = 0L;
                a5SV6n.f5369B25kr6.set(false);
                a5SV6n.f5363AZkASS = a5SV6n.f5362AZOQYO.scheduleAtFixedRate(new A2egSU(a5SV6n, 2), 1L, 1L, TimeUnit.SECONDS);
            }
        }
    }

    public static int A4TApA(A5SV6n a5SV6n, byte[] bArr) {
        if (bArr.length < 4) {
            return 0;
        }
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    public static void A5SV6n(A5SV6n a5SV6n) {
        synchronized (a5SV6n.f5357A5SV6n) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - a5SV6n.f5358ADYaiT < 300) {
                    return;
                }
                a5SV6n.f5358ADYaiT = currentTimeMillis;
                try {
                    DatagramSocket datagramSocket = new DatagramSocket();
                    DatagramSocket datagramSocket2 = a5SV6n.f5355A2egSU;
                    a5SV6n.f5355A2egSU = datagramSocket;
                    Iterator it = a5SV6n.f5356A4TApA.values().iterator();
                    while (it.hasNext()) {
                        ((MdiDtx.A5SV6n) it.next()).f5342A4TApA = datagramSocket;
                    }
                    if (datagramSocket2 != null) {
                        if (!datagramSocket2.isClosed()) {
                            try {
                                datagramSocket2.close();
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (IOException unused2) {
                }
            } finally {
            }
        }
    }

    public final synchronized void ADYaiT() {
        try {
            ScheduledFuture scheduledFuture = this.f5363AZkASS;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.f5363AZkASS = null;
            }
            ScheduledExecutorService scheduledExecutorService = this.f5362AZOQYO;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.f5362AZOQYO = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
