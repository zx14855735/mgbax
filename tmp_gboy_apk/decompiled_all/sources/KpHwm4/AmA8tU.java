package KpHwm4;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.game.boy.emu.gba.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU extends McNXgv.A4TApA {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final InetAddress f4324AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f4325AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Socket f4326AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final B25kr6 f4327B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f4328B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ArrayList f4329B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public BTvldC.ADYaiT f4330B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public McNXgv.A5SV6n f4331B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public volatile boolean f4332B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public volatile long f4333BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public volatile boolean f4334BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public volatile long f4335BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final ArrayList f4336BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final /* synthetic */ B25kr6 f4337BNL6CD;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmA8tU(B25kr6 b25kr6, B25kr6 b25kr62, InetAddress inetAddress, int i, ArrayList arrayList, ArrayList arrayList2) {
        super(b25kr62);
        this.f4337BNL6CD = b25kr6;
        this.f4332B9tovu = false;
        this.f4333BChYOn = 0L;
        this.f4334BI9f7h = false;
        this.f4335BIYEnU = 0L;
        this.f4324AlLFFp = inetAddress;
        this.f4325AmA8tU = i;
        this.f4327B25kr6 = b25kr62;
        this.f4329B3GDIM = arrayList;
        this.f4336BJ7GGh = arrayList2;
    }

    @Override // McNXgv.A4TApA
    public final void A2egSU() {
        try {
            Socket socket = this.f4326AzWtSf;
            if (socket == null || socket.isClosed()) {
                return;
            }
            this.f4326AzWtSf.close();
        } catch (IOException unused) {
        }
    }

    @Override // McNXgv.A4TApA
    public final int A4TApA() {
        this.f4328B2KMhB = -1;
        while (this.f4337BNL6CD.f4355ASJ6gh && !Thread.currentThread().isInterrupted()) {
            try {
                Socket socket = new Socket();
                this.f4326AzWtSf = socket;
                socket.connect(new InetSocketAddress(this.f4324AlLFFp, this.f4325AmA8tU), 10000);
                this.f4326AzWtSf.setSoTimeout(500);
                this.f4326AzWtSf.setTcpNoDelay(true);
            } catch (IOException e) {
                if (!this.f4332B9tovu) {
                    throw e;
                }
                long j = this.f4335BIYEnU;
                this.f4335BIYEnU = 0L;
                if (j > 0 && System.currentTimeMillis() - j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    this.f4333BChYOn = 0L;
                }
                if (this.f4333BChYOn == 0) {
                    this.f4333BChYOn = System.currentTimeMillis();
                }
                if (System.currentTimeMillis() - this.f4333BChYOn >= 50000) {
                    ADYaiT();
                    throw e;
                }
                AMqCpz();
                e.toString();
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            try {
                if (this.f4332B9tovu) {
                    ARc23Z(this.f4326AzWtSf);
                    return this.f4328B2KMhB;
                }
                int A5SV6n2 = A5SV6n(this.f4326AzWtSf);
                this.f4328B2KMhB = A5SV6n2;
                return A5SV6n2;
            } catch (InterruptedException unused2) {
            } catch (Exception e2) {
                try {
                    Socket socket2 = this.f4326AzWtSf;
                    if (socket2 != null && !socket2.isClosed()) {
                        this.f4326AzWtSf.close();
                    }
                } catch (IOException unused3) {
                }
                if (!this.f4337BNL6CD.f4355ASJ6gh || Thread.currentThread().isInterrupted()) {
                    break;
                }
                if (!this.f4332B9tovu) {
                    throw e2;
                }
                long j2 = this.f4335BIYEnU;
                this.f4335BIYEnU = 0L;
                if (j2 > 0 && System.currentTimeMillis() - j2 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    this.f4333BChYOn = 0L;
                }
                if (this.f4333BChYOn == 0) {
                    this.f4333BChYOn = System.currentTimeMillis();
                }
                if (System.currentTimeMillis() - this.f4333BChYOn >= 50000) {
                    ADYaiT();
                    throw e2;
                }
                AMqCpz();
                e2.toString();
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException unused4) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.AbstractQueue, java.util.concurrent.BlockingQueue] */
    public final int A5SV6n(Socket socket) {
        this.f4330B4ZgIw = new BTvldC.ADYaiT(socket.getInputStream());
        this.f4331B7CMnp = new McNXgv.A5SV6n(socket.getOutputStream(), this.f4337BNL6CD.f4354ARc23Z);
        this.f4337BNL6CD.f4353ADYaiT.add(this.f4330B4ZgIw);
        this.f4337BNL6CD.f4352A5SV6n.add(this.f4331B7CMnp);
        this.f4337BNL6CD.getClass();
        ByteBuffer putInt = B25kr6.ARc23Z((short) 1, 10).putInt(Mi9UWv.ASJ6gh.f5402BniPrB);
        if (Mi9UWv.ASJ6gh.f5402BniPrB == 1) {
            putInt.putShort((short) 0);
            putInt.putInt(this.f4329B3GDIM.size());
        }
        this.f4331B7CMnp.A2egSU(putInt);
        while (true) {
            if (!this.f4337BNL6CD.f4355ASJ6gh) {
                break;
            }
            ByteBuffer ADYaiT2 = this.f4330B4ZgIw.ADYaiT();
            short s = ADYaiT2.getShort();
            if (s == 3) {
                int i = ADYaiT2.getInt();
                this.f4331B7CMnp.f5293B9tovu = i;
                int i2 = 0;
                while (i2 < this.f4329B3GDIM.size() - 1) {
                    this.f4337BNL6CD.getClass();
                    int i3 = (i != 1 && (i != 2 ? i != 3 || i2 <= 1 : i2 == 0)) ? 0 : i2 + 1;
                    this.f4337BNL6CD.getClass();
                    int A2egSU2 = B25kr6.A2egSU(i, i2);
                    this.f4327B25kr6.A5SV6n(this.f4337BNL6CD.f4350A2egSU.obtainMessage(4, new McNXgv.A2egSU(new String[]{(String) this.f4336BJ7GGh.get(A2egSU2)}, this.f4331B7CMnp, i3)), this.f4331B7CMnp);
                    B25kr6 b25kr6 = this.f4337BNL6CD;
                    byte[] bArr = (byte[]) this.f4329B3GDIM.get(A2egSU2);
                    Console console = (Console) this.f4331B7CMnp.f5289B2KMhB.get(i2);
                    b25kr6.getClass();
                    int loadStateFromMemory = console.loadStateFromMemory(bArr);
                    int i4 = loadStateFromMemory != -5 ? loadStateFromMemory != 0 ? 1 : 0 : 3;
                    if (i4 != 0) {
                        McNXgv.A5SV6n a5SV6n = this.f4331B7CMnp;
                        this.f4337BNL6CD.getClass();
                        a5SV6n.A2egSU(B25kr6.ARc23Z((short) 1, 0));
                        return i4;
                    }
                    i2++;
                }
                McNXgv.A5SV6n a5SV6n2 = this.f4331B7CMnp;
                this.f4337BNL6CD.getClass();
                a5SV6n2.A2egSU(B25kr6.ARc23Z((short) 3, 0));
            } else {
                if (s != 0) {
                    return 2;
                }
                try {
                    int i5 = ADYaiT2.getInt();
                    this.f4337BNL6CD.f4359AaHO0E.f4319BPw6Q8 = false;
                    this.f4337BNL6CD.f4359AaHO0E.f4302AZkASS = i5;
                } catch (Exception unused) {
                }
            }
        }
        McNXgv.A5SV6n a5SV6n3 = this.f4331B7CMnp;
        this.f4337BNL6CD.getClass();
        a5SV6n3.A2egSU(B25kr6.ARc23Z((short) 1, 0));
        this.f4327B25kr6.A5SV6n(this.f4337BNL6CD.f4350A2egSU.obtainMessage(1, new McNXgv.A2egSU(this.f4331B7CMnp, this.f4325AmA8tU)), this.f4331B7CMnp);
        this.f4332B9tovu = true;
        while (this.f4337BNL6CD.f4355ASJ6gh) {
            ByteBuffer ADYaiT3 = this.f4330B4ZgIw.ADYaiT();
            if (ADYaiT3 != null) {
                try {
                    this.f4331B7CMnp.f5296BIYEnU.put(ADYaiT3);
                } catch (InterruptedException unused2) {
                }
            }
        }
        return 1;
    }

    public final void ADYaiT() {
        if (this.f4334BI9f7h) {
            this.f4334BI9f7h = false;
            try {
                this.f4337BNL6CD.f4350A2egSU.obtainMessage(8).sendToTarget();
            } catch (Throwable unused) {
            }
        }
    }

    public final void AMqCpz() {
        if (this.f4334BI9f7h) {
            return;
        }
        this.f4334BI9f7h = true;
        try {
            this.f4337BNL6CD.f4350A2egSU.obtainMessage(7, (int) Math.max(0L, 50000 - (System.currentTimeMillis() - this.f4333BChYOn)), 0).sendToTarget();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.AbstractQueue, java.util.concurrent.BlockingQueue] */
    public final void ARc23Z(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        McNXgv.A5SV6n a5SV6n = this.f4331B7CMnp;
        int i = a5SV6n != null ? a5SV6n.f5293B9tovu : -1;
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.putInt(6);
        allocate.putShort((short) 100);
        allocate.putInt(i);
        outputStream.write(allocate.array());
        outputStream.flush();
        McNXgv.A5SV6n a5SV6n2 = this.f4331B7CMnp;
        if (a5SV6n2 != null) {
            a5SV6n2.f5284AcNBzu = outputStream;
            McNXgv.A5SV6n a5SV6n3 = this.f4331B7CMnp;
            a5SV6n3.f5290B3GDIM = null;
            a5SV6n3.f5291B4ZgIw = 0L;
            a5SV6n3.f5292B7CMnp = false;
        }
        BTvldC.ADYaiT aDYaiT = new BTvldC.ADYaiT(socket.getInputStream());
        this.f4330B4ZgIw = aDYaiT;
        this.f4337BNL6CD.f4353ADYaiT.add(aDYaiT);
        this.f4335BIYEnU = System.currentTimeMillis();
        ADYaiT();
        while (this.f4337BNL6CD.f4355ASJ6gh) {
            ByteBuffer ADYaiT2 = this.f4330B4ZgIw.ADYaiT();
            if (ADYaiT2 != null) {
                try {
                    this.f4331B7CMnp.f5296BIYEnU.put(ADYaiT2);
                } catch (InterruptedException unused) {
                }
            }
        }
    }
}
