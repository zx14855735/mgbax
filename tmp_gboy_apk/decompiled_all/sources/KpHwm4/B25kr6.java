package KpHwm4;

import android.os.Handler;
import android.os.Message;
import com.game.boy.emu.gba.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final UUID f4349AcNBzu = UUID.fromString("3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47");

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Handler f4350A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public McNXgv.A4TApA f4351A4TApA;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f4354ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public volatile boolean f4355ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public volatile boolean f4356AYUAbz;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final AaHO0E f4359AaHO0E;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final CopyOnWriteArrayList f4352A5SV6n = new CopyOnWriteArrayList();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final CopyOnWriteArrayList f4353ADYaiT = new CopyOnWriteArrayList();

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final AtomicInteger f4357AZOQYO = new AtomicInteger(0);

    /* renamed from: AZkASS, reason: collision with root package name */
    public final ArrayList f4358AZkASS = new ArrayList();

    static {
        nwtLz();
    }

    public B25kr6(Handler handler, AaHO0E aaHO0E) {
        this.f4350A2egSU = handler;
        this.f4359AaHO0E = aaHO0E;
    }

    public static int A2egSU(int i, int i2) {
        if (i == 1) {
            return i2 + 1;
        }
        if (i == 2) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return 2;
            }
        } else {
            if (i != 3) {
                if (i != 4) {
                    return 0;
                }
                return 2 - i2;
            }
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 1) {
                return 0;
            }
        }
        return 3;
    }

    public static ByteBuffer ARc23Z(short s, int i) {
        int i2 = i + 2;
        ByteBuffer allocate = ByteBuffer.allocate(i + 6);
        allocate.putInt(i2);
        return allocate.putShort(s);
    }

    private static /* synthetic */ void nwtLz() {
        char[] charArray = "õùû¸ñ÷ûó¸ôùï¸åþóúú¸ÜøÿÔäÿòñó".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 150);
        }
        String str = new String(charArray);
        char[] charArray2 = "õúÿøÿâ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 150);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.AbstractQueue, java.util.concurrent.BlockingQueue] */
    public final int A4TApA(InputStream inputStream, OutputStream outputStream) {
        BTvldC.ADYaiT aDYaiT = new BTvldC.ADYaiT(inputStream);
        McNXgv.A5SV6n a5SV6n = new McNXgv.A5SV6n(outputStream, this.f4354ARc23Z);
        this.f4353ADYaiT.add(aDYaiT);
        this.f4352A5SV6n.add(a5SV6n);
        if (!this.AMqCpz) {
            a5SV6n.A2egSU(ARc23Z((short) 1, 4).putInt(6));
        }
        ByteBuffer ADYaiT2 = aDYaiT.ADYaiT();
        if (ADYaiT2.getShort() == 1) {
            if (this.AMqCpz) {
                if (ADYaiT2.getInt() == 6) {
                    a5SV6n.A2egSU(ARc23Z((short) 1, 4).putInt(6));
                }
            }
            this.f4350A2egSU.obtainMessage(3, new McNXgv.A2egSU(a5SV6n)).sendToTarget();
            ByteBuffer ADYaiT3 = aDYaiT.ADYaiT();
            if (ADYaiT3.getShort() == 2) {
                byte[] bArr = new byte[32];
                ADYaiT3.get(bArr);
                byte[] bArr2 = new byte[ADYaiT3.getShort()];
                ADYaiT3.get(bArr2);
                A5SV6n(this.f4350A2egSU.obtainMessage(4, new McNXgv.A2egSU(new String[]{new String(bArr), new String(bArr2)}, a5SV6n, this.AMqCpz ? 1 : 0)), a5SV6n);
                if (aDYaiT.ADYaiT().getShort() == 3) {
                    if (!this.AMqCpz) {
                        this.f4350A2egSU.obtainMessage(5, new McNXgv.A2egSU(a5SV6n)).sendToTarget();
                    }
                    ByteBuffer ADYaiT4 = aDYaiT.ADYaiT();
                    if (ADYaiT4.getShort() == 6) {
                        Console console = a5SV6n.f5295BI9f7h;
                        byte[] bArr3 = new byte[ADYaiT4.getInt()];
                        ADYaiT4.get(bArr3);
                        int loadStateFromMemory = console.loadStateFromMemory(bArr3);
                        int i = loadStateFromMemory != -5 ? loadStateFromMemory != 0 ? 1 : 0 : 3;
                        if (i != 0) {
                            return i;
                        }
                        if (this.AMqCpz) {
                            this.f4350A2egSU.obtainMessage(5, new McNXgv.A2egSU(a5SV6n)).sendToTarget();
                        }
                        this.f4359AaHO0E.f4307AzWtSf.f11100A2egSU.reset(false);
                        a5SV6n.f5295BI9f7h.reset(false);
                        A5SV6n(this.f4350A2egSU.obtainMessage(1, new McNXgv.A2egSU(a5SV6n)), a5SV6n);
                        while (this.f4355ASJ6gh) {
                            ByteBuffer ADYaiT5 = aDYaiT.ADYaiT();
                            if (ADYaiT5 != null) {
                                try {
                                    a5SV6n.f5296BIYEnU.put(ADYaiT5);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return 2;
    }

    public final void A5SV6n(Message message, McNXgv.A5SV6n a5SV6n) {
        synchronized (this) {
            message.sendToTarget();
            a5SV6n.f5294BChYOn = message.what;
            while (a5SV6n.f5294BChYOn != 0) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public final void ADYaiT(McNXgv.A5SV6n a5SV6n) {
        synchronized (this) {
            a5SV6n.f5294BChYOn = 0;
            notify();
        }
    }

    public final void AMqCpz(InetAddress inetAddress, int i, boolean z, ArrayList arrayList, ArrayList arrayList2) {
        this.AMqCpz = false;
        this.f4354ARc23Z = true;
        if (z) {
            ASJ6gh(new AzWtSf(this, this, inetAddress, i, arrayList, arrayList2));
        } else {
            ASJ6gh(new AmA8tU(this, this, inetAddress, i, arrayList, arrayList2));
        }
    }

    public final void ASJ6gh(McNXgv.A4TApA a4TApA) {
        if (this.f4351A4TApA != null) {
            throw new IllegalStateException();
        }
        this.f4355ASJ6gh = true;
        this.f4356AYUAbz = false;
        this.f4351A4TApA = a4TApA;
        a4TApA.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r1 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0035, code lost:
    
        if (r1 != 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x003c, code lost:
    
        if (r1 != 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0043, code lost:
    
        if (r1 != 4) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0008 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractQueue, java.util.concurrent.BlockingQueue] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AYUAbz(McNXgv.A5SV6n r10) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: KpHwm4.B25kr6.AYUAbz(McNXgv.A5SV6n):void");
    }

    public final void AZOQYO(int i) {
        try {
            ((McNXgv.A5SV6n) this.f4352A5SV6n.get(0)).A2egSU(ARc23Z((short) 9, 4).putInt(i));
        } catch (IOException unused) {
        }
    }
}
