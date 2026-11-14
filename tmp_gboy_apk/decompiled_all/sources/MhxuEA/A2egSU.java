package MhxuEA;

import IQ76hF.AmA8tU;
import KpHwm4.AzWtSf;
import com.sigmob.sdk.downloader.f;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5346AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ A5SV6n f5347AlLFFp;

    public /* synthetic */ A2egSU(A5SV6n a5SV6n, int i) {
        this.f5346AcNBzu = i;
        this.f5347AlLFFp = a5SV6n;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5346AcNBzu) {
            case 0:
                byte[] bArr = new byte[f.a.c];
                while (this.f5347AlLFFp.f5364AaHO0E.get() && !Thread.currentThread().isInterrupted()) {
                    DatagramSocket datagramSocket = this.f5347AlLFFp.f5355A2egSU;
                    try {
                        datagramSocket.setSoTimeout(500);
                        DatagramPacket datagramPacket = new DatagramPacket(bArr, f.a.c);
                        datagramSocket.receive(datagramPacket);
                        MdiDtx.A5SV6n a5SV6n = (MdiDtx.A5SV6n) this.f5347AlLFFp.f5356A4TApA.get(Integer.valueOf(A5SV6n.A4TApA(this.f5347AlLFFp, datagramPacket.getData())));
                        if (a5SV6n != null) {
                            byte[] data = datagramPacket.getData();
                            datagramPacket.getLength();
                            a5SV6n.A4TApA(data);
                        }
                    } catch (SocketException unused) {
                        if (!this.f5347AlLFFp.f5364AaHO0E.get()) {
                            return;
                        }
                        if (datagramSocket == this.f5347AlLFFp.f5355A2egSU) {
                            A5SV6n.A5SV6n(this.f5347AlLFFp);
                        }
                    } catch (SocketTimeoutException unused2) {
                    } catch (IOException e) {
                        if (!this.f5347AlLFFp.f5364AaHO0E.get()) {
                            return;
                        }
                        if (!(e instanceof SocketTimeoutException)) {
                            A5SV6n.A5SV6n(this.f5347AlLFFp);
                        }
                    }
                }
            case 1:
                A5SV6n a5SV6n2 = this.f5347AlLFFp;
                if (a5SV6n2.f5364AaHO0E.get()) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        for (MdiDtx.A5SV6n a5SV6n3 : a5SV6n2.f5356A4TApA.values()) {
                            a5SV6n3.update(currentTimeMillis);
                            a5SV6n3.A5SV6n();
                        }
                        break;
                    } catch (Exception unused3) {
                        return;
                    }
                }
                break;
            default:
                try {
                    if (this.f5347AlLFFp.f5364AaHO0E.get()) {
                        if (this.f5347AlLFFp.f5356A4TApA.isEmpty()) {
                            this.f5347AlLFFp.ADYaiT();
                            break;
                        } else {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            long j = currentTimeMillis2 - this.f5347AlLFFp.f5367AmA8tU.get();
                            if (j > 1500) {
                                for (MdiDtx.A5SV6n a5SV6n4 : this.f5347AlLFFp.f5356A4TApA.values()) {
                                    a5SV6n4.ADYaiT(A5SV6n.f5352B7CMnp);
                                    a5SV6n4.A2egSU(currentTimeMillis2);
                                }
                            }
                            if (j <= 3000) {
                                this.f5347AlLFFp.AMqCpz = 0L;
                                this.f5347AlLFFp.f5368AzWtSf.set(0);
                                this.f5347AlLFFp.f5369B25kr6.set(false);
                                break;
                            } else {
                                if (this.f5347AlLFFp.AMqCpz == 0) {
                                    this.f5347AlLFFp.AMqCpz = currentTimeMillis2;
                                }
                                this.f5347AlLFFp.f5368AzWtSf.incrementAndGet();
                                if (currentTimeMillis2 - this.f5347AlLFFp.AMqCpz > 60000 && this.f5347AlLFFp.f5369B25kr6.compareAndSet(false, true)) {
                                    Iterator it = new ArrayList(this.f5347AlLFFp.f5356A4TApA.keySet()).iterator();
                                    while (it.hasNext()) {
                                        Integer num = (Integer) it.next();
                                        AmA8tU amA8tU = this.f5347AlLFFp.f5370B2KMhB;
                                        num.getClass();
                                        ((AzWtSf) amA8tU.f3956AlLFFp).f4343B3GDIM = false;
                                        ((AzWtSf) amA8tU.f3956AlLFFp).f4346B9tovu.countDown();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        break;
                    }
                } catch (Exception unused4) {
                    return;
                }
                break;
        }
    }
}
