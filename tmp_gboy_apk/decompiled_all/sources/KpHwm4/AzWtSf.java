package KpHwm4;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.game.boy.emu.gba.Console;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf extends McNXgv.A4TApA {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final InetAddress f4338AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f4339AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final B25kr6 f4340AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ArrayList f4341B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public MhxuEA.A5SV6n f4342B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public volatile boolean f4343B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public McNXgv.A5SV6n f4344B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Object f4345B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final CountDownLatch f4346B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final ArrayList f4347BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final /* synthetic */ B25kr6 f4348BI9f7h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AzWtSf(B25kr6 b25kr6, B25kr6 b25kr62, InetAddress inetAddress, int i, ArrayList arrayList, ArrayList arrayList2) {
        super(b25kr62);
        this.f4348BI9f7h = b25kr6;
        this.f4343B3GDIM = false;
        this.f4345B7CMnp = new Object();
        this.f4346B9tovu = new CountDownLatch(1);
        this.f4338AlLFFp = inetAddress;
        this.f4339AmA8tU = i;
        this.f4340AzWtSf = b25kr62;
        this.f4341B25kr6 = arrayList;
        this.f4347BChYOn = arrayList2;
    }

    @Override // McNXgv.A4TApA
    public final void A2egSU() {
        IQ76hF.AmA8tU amA8tU;
        MhxuEA.A5SV6n a5SV6n = this.f4342B2KMhB;
        if (a5SV6n == null || (amA8tU = a5SV6n.f5370B2KMhB) == null) {
            return;
        }
        ((AzWtSf) amA8tU.f3956AlLFFp).f4346B9tovu.countDown();
        MhxuEA.A5SV6n a5SV6n2 = ((AzWtSf) amA8tU.f3956AlLFFp).f4342B2KMhB;
        for (MdiDtx.A5SV6n a5SV6n3 : a5SV6n2.f5356A4TApA.values()) {
            try {
                a5SV6n3.ADYaiT(MhxuEA.A5SV6n.f5354BChYOn);
                a5SV6n3.A2egSU(System.currentTimeMillis());
            } catch (Exception unused) {
            }
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused2) {
        }
        a5SV6n2.ADYaiT();
        a5SV6n2.f5364AaHO0E.set(false);
        Iterator it = a5SV6n2.f5356A4TApA.values().iterator();
        while (it.hasNext()) {
            try {
                ((MdiDtx.A5SV6n) it.next()).getClass();
            } catch (Exception unused3) {
            }
        }
        a5SV6n2.f5356A4TApA.clear();
        if (a5SV6n2.f5355A2egSU != null && !a5SV6n2.f5355A2egSU.isClosed()) {
            a5SV6n2.f5355A2egSU.close();
        }
        a5SV6n2.f5359ARc23Z.shutdown();
        a5SV6n2.f5360ASJ6gh.shutdown();
        a5SV6n2.f5361AYUAbz.shutdownNow();
        try {
            ScheduledExecutorService scheduledExecutorService = a5SV6n2.f5359ARc23Z;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (!scheduledExecutorService.awaitTermination(500L, timeUnit)) {
                a5SV6n2.f5359ARc23Z.shutdownNow();
            }
            if (!a5SV6n2.f5360ASJ6gh.awaitTermination(500L, timeUnit)) {
                a5SV6n2.f5360ASJ6gh.shutdownNow();
            }
            if (a5SV6n2.f5361AYUAbz.awaitTermination(500L, timeUnit)) {
                return;
            }
            a5SV6n2.f5361AYUAbz.shutdownNow();
        } catch (InterruptedException unused4) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.AbstractQueue, java.util.concurrent.BlockingQueue] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.AbstractQueue, java.util.concurrent.BlockingQueue] */
    @Override // McNXgv.A4TApA
    public final int A4TApA() {
        MhxuEA.A5SV6n a5SV6n = new MhxuEA.A5SV6n(new IQ76hF.AmA8tU(2, this));
        this.f4342B2KMhB = a5SV6n;
        a5SV6n.f5361AYUAbz.submit(new MOpbMP.A2egSU(a5SV6n, 12, new InetSocketAddress(this.f4338AlLFFp, this.f4339AmA8tU)));
        synchronized (this.f4345B7CMnp) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                while (!this.f4343B3GDIM && System.currentTimeMillis() - currentTimeMillis < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    this.f4345B7CMnp.wait(100L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!this.f4343B3GDIM) {
            return -1;
        }
        while (true) {
            if (!this.f4348BI9f7h.f4355ASJ6gh) {
                break;
            }
            ByteBuffer byteBuffer = (ByteBuffer) this.f4344B4ZgIw.f5296BIYEnU.take();
            if (byteBuffer.getShort() == 3) {
                int i = byteBuffer.getInt();
                this.f4344B4ZgIw.f5293B9tovu = i;
                int i2 = 0;
                while (i2 < this.f4341B25kr6.size() - 1) {
                    this.f4348BI9f7h.getClass();
                    int i3 = (i != 1 && (i != 2 ? i != 3 || i2 <= 1 : i2 == 0)) ? 0 : i2 + 1;
                    this.f4348BI9f7h.getClass();
                    int A2egSU2 = B25kr6.A2egSU(i, i2);
                    this.f4340AzWtSf.A5SV6n(this.f4348BI9f7h.f4350A2egSU.obtainMessage(4, new McNXgv.A2egSU(new String[]{(String) this.f4347BChYOn.get(A2egSU2)}, this.f4344B4ZgIw, i3)), this.f4344B4ZgIw);
                    B25kr6 b25kr6 = this.f4348BI9f7h;
                    byte[] bArr = (byte[]) this.f4341B25kr6.get(A2egSU2);
                    Console console = (Console) this.f4344B4ZgIw.f5289B2KMhB.get(i2);
                    b25kr6.getClass();
                    int loadStateFromMemory = console.loadStateFromMemory(bArr);
                    int i4 = loadStateFromMemory != -5 ? loadStateFromMemory != 0 ? 1 : 0 : 3;
                    if (i4 != 0) {
                        return i4;
                    }
                    i2++;
                }
                McNXgv.A5SV6n a5SV6n2 = this.f4344B4ZgIw;
                this.f4348BI9f7h.getClass();
                a5SV6n2.A2egSU(B25kr6.ARc23Z((short) 3, 0));
            }
        }
        while (true) {
            if (!this.f4348BI9f7h.f4355ASJ6gh) {
                break;
            }
            ByteBuffer byteBuffer2 = (ByteBuffer) this.f4344B4ZgIw.f5296BIYEnU.take();
            if (byteBuffer2.getShort() == 0) {
                int i5 = byteBuffer2.getInt();
                this.f4348BI9f7h.f4359AaHO0E.f4319BPw6Q8 = false;
                this.f4348BI9f7h.f4359AaHO0E.f4302AZkASS = i5;
                break;
            }
        }
        McNXgv.A5SV6n a5SV6n3 = this.f4344B4ZgIw;
        this.f4348BI9f7h.getClass();
        a5SV6n3.A2egSU(B25kr6.ARc23Z((short) 1, 0));
        this.f4340AzWtSf.A5SV6n(this.f4348BI9f7h.f4350A2egSU.obtainMessage(1, new McNXgv.A2egSU(this.f4344B4ZgIw, this.f4339AmA8tU)), this.f4344B4ZgIw);
        this.f4346B9tovu.await();
        return 1;
    }
}
