package KpHwm4;

import ADYaiT.D8MqeW;
import android.media.AudioTrack;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.C;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.game.boy.emu.gba.Console;
import com.game.boy.emu.gba.Link;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public LLcl8r.ARc23Z f4294A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Object f4295A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Object f4296A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public LNKngO.ADYaiT f4297ADYaiT;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AudioTrack f4298ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public volatile int f4299ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f4300AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f4301AZOQYO;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f4303AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f4304AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public LqstKO.AMqCpz f4305AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public LqstKO.ARc23Z f4306AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Link f4307AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f4308B25kr6;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Runnable f4310B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public B25kr6 f4311B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f4312B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f4313B9tovu;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final Thread f4316BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public volatile boolean f4317BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public volatile boolean f4318BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public volatile boolean f4319BPw6Q8 = false;
    public final ByteBuffer AMqCpz = ByteBuffer.allocateDirect(76800);

    /* renamed from: AZkASS, reason: collision with root package name */
    public float f4302AZkASS = 1.0f;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public volatile int f4309B2KMhB = 0;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final A5SV6n f4314BChYOn = new A5SV6n();

    /* renamed from: BI9f7h, reason: collision with root package name */
    public volatile short[] f4315BI9f7h = new short[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];

    public AaHO0E(Link link) {
        Thread thread = new Thread(new D8MqeW(23, this));
        this.f4316BIYEnU = thread;
        this.f4307AzWtSf = link;
        thread.start();
    }

    public final void A2egSU(Runnable runnable) {
        synchronized (this) {
            ASJ6gh();
            this.f4310B3GDIM = runnable;
            notify();
            while (this.f4310B3GDIM != null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            AMqCpz();
        }
    }

    public final void A4TApA(Console console, int i) {
        int audioSamples;
        int write;
        LNKngO.ADYaiT aDYaiT = this.f4297ADYaiT;
        if (aDYaiT != null) {
            aDYaiT.A2egSU();
        }
        if (this.f4298ARc23Z == null || console == null || (audioSamples = console.getAudioSamples(this.f4315BI9f7h, i)) <= 0) {
            return;
        }
        if (!this.f4318BNL6CD || this.f4302AZkASS == 1.0f) {
            int i2 = 0;
            if (Build.VERSION.SDK_INT < 23 || this.f4317BJ7GGh) {
                this.f4298ARc23Z.write(this.f4315BI9f7h, 0, audioSamples);
                return;
            }
            while (i2 < audioSamples) {
                write = this.f4298ARc23Z.write(this.f4315BI9f7h, i2, audioSamples - i2, 1);
                if (write <= 0) {
                    return;
                } else {
                    i2 += write;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [KpHwm4.AZkASS, java.lang.Object] */
    public final void A5SV6n() {
        if (this.f4308B25kr6) {
            this.f4308B25kr6 = false;
            ASJ6gh();
            ?? r0 = this.f4295A4TApA;
            if (r0 != 0) {
                r0.b();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [KpHwm4.AZkASS, java.lang.Object] */
    public final void ADYaiT() {
        if (this.f4308B25kr6) {
            return;
        }
        this.f4308B25kr6 = true;
        ?? r0 = this.f4295A4TApA;
        if (r0 != 0) {
            r0.a();
        }
        AMqCpz();
    }

    public final void AMqCpz() {
        synchronized (this) {
            if (this.f4308B25kr6 && this.f4307AzWtSf.f11100A2egSU != null && this.f4306AmA8tU != null && this.f4309B2KMhB == 0) {
                this.f4309B2KMhB = 3;
                notify();
                while (this.f4309B2KMhB == 3) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final void ARc23Z(B25kr6 b25kr6) {
        ASJ6gh();
        this.f4311B4ZgIw = b25kr6;
        if (b25kr6 != null && b25kr6.f4354ARc23Z) {
            Link link = this.f4307AzWtSf;
            link.f11100A2egSU.AMqCpz.a();
            Console console = link.f11100A2egSU;
            console.getClass();
            console.reset(false);
            Iterator it = ((McNXgv.A5SV6n) this.f4311B4ZgIw.f4352A5SV6n.get(0)).f5289B2KMhB.iterator();
            while (it.hasNext()) {
                Console console2 = (Console) it.next();
                console2.getClass();
                console2.reset(false);
            }
        }
        this.f4312B7CMnp = false;
        this.f4313B9tovu = 5;
        AMqCpz();
    }

    public final void ASJ6gh() {
        synchronized (this) {
            if (this.f4309B2KMhB == 1) {
                this.f4309B2KMhB = 2;
                this.f4316BIYEnU.interrupt();
                while (this.f4309B2KMhB == 2) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final void AYUAbz(float f) {
        this.f4302AZkASS = f;
        A5SV6n a5SV6n = this.f4314BChYOn;
        a5SV6n.getClass();
        a5SV6n.f4276A2egSU = C.NANOS_PER_SECOND / ((int) (f * 60.0f));
        float f2 = this.f4302AZkASS;
        int i = this.f4301AZOQYO;
        int max = Math.max(1, Math.round(f2));
        a5SV6n.f4278A5SV6n = max > 1 ? Math.max(0, max - 1) : Math.max(0, i);
        a5SV6n.f4277A4TApA = System.nanoTime();
        a5SV6n.f4279ADYaiT = 0;
    }
}
