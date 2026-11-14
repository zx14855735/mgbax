package McNXgv;

import AZkASS.ARc23Z;
import IQ76hF.AmA8tU;
import KpHwm4.AzWtSf;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.game.boy.emu.gba.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends Thread {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public volatile OutputStream f5284AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ARc23Z f5285AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final boolean f5286AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f5287AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public volatile boolean f5288B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final CopyOnWriteArrayList f5289B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public volatile IOException f5290B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public volatile long f5291B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public volatile boolean f5292B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f5293B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f5294BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public Console f5295BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final AbstractQueue f5296BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f5297BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f5298BNL6CD;

    public A5SV6n(OutputStream outputStream, boolean z) {
        this.f5288B25kr6 = true;
        this.f5289B2KMhB = new CopyOnWriteArrayList();
        this.f5297BJ7GGh = 1;
        this.f5298BNL6CD = 1;
        this.f5284AcNBzu = outputStream;
        this.f5285AlLFFp = null;
        this.f5286AmA8tU = false;
        this.f5287AzWtSf = new ArrayList(4);
        if (z) {
            this.f5296BIYEnU = new LinkedBlockingQueue();
        } else {
            this.f5296BIYEnU = new ArrayBlockingQueue(1);
        }
        start();
    }

    public final void A2egSU(ByteBuffer byteBuffer) {
        if (!isAlive()) {
            throw new IOException("Sender thread is dead.");
        }
        synchronized (this) {
            try {
                if (this.f5287AzWtSf.isEmpty()) {
                    notify();
                }
                this.f5287AzWtSf.add(byteBuffer);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ByteBuffer byteBuffer;
        while (this.f5288B25kr6) {
            try {
                synchronized (this) {
                    while (this.f5287AzWtSf.isEmpty()) {
                        try {
                            wait();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    byteBuffer = (ByteBuffer) this.f5287AzWtSf.remove(0);
                }
                if (this.f5286AmA8tU) {
                    ARc23Z aRc23Z = this.f5285AlLFFp;
                    if (aRc23Z != null) {
                        MhxuEA.A5SV6n a5SV6n = ((AzWtSf) ((AmA8tU) aRc23Z.f451AlLFFp).f3956AlLFFp).f4342B2KMhB;
                        byte[] array = byteBuffer.array();
                        for (MdiDtx.A5SV6n a5SV6n2 : a5SV6n.f5356A4TApA.values()) {
                            a5SV6n2.ADYaiT(array);
                            a5SV6n2.A2egSU(System.currentTimeMillis());
                        }
                    }
                } else {
                    OutputStream outputStream = this.f5284AcNBzu;
                    try {
                        outputStream.write(byteBuffer.array());
                        outputStream.flush();
                        this.f5290B3GDIM = null;
                        this.f5291B4ZgIw = 0L;
                    } catch (IOException e) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (this.f5290B3GDIM == null) {
                            this.f5291B4ZgIw = currentTimeMillis;
                            e.printStackTrace();
                        }
                        this.f5290B3GDIM = e;
                        if (!this.f5292B7CMnp && this.f5291B4ZgIw > 0 && currentTimeMillis - this.f5291B4ZgIw >= PushUIConfig.dismissTime) {
                            this.f5292B7CMnp = true;
                            System.err.getClass();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                        }
                    }
                }
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public A5SV6n(ARc23Z aRc23Z) {
        this.f5288B25kr6 = true;
        this.f5289B2KMhB = new CopyOnWriteArrayList();
        this.f5297BJ7GGh = 1;
        this.f5298BNL6CD = 1;
        this.f5284AcNBzu = null;
        this.f5285AlLFFp = aRc23Z;
        this.f5286AmA8tU = true;
        this.f5287AzWtSf = new ArrayList(4);
        this.f5296BIYEnU = new LinkedBlockingQueue();
        start();
    }
}
