package HPJABZ;

import android.util.Log;
import com.sigmob.sdk.base.blurkit.d;
import com.sigmob.sdk.base.views.r;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A5SV6n {

    /* renamed from: A4TApA, reason: collision with root package name */
    public ByteBuffer f3435A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public A4TApA f3436A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final byte[] f3434A2egSU = new byte[256];

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f3437ADYaiT = 0;

    public final boolean A2egSU() {
        return this.f3436A5SV6n.f3425A4TApA != 0;
    }

    public final A4TApA A4TApA() {
        byte[] bArr;
        if (this.f3435A4TApA == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (A2egSU()) {
            return this.f3436A5SV6n;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) A5SV6n());
        }
        if (sb.toString().startsWith("GIF")) {
            this.f3436A5SV6n.f3428ARc23Z = this.f3435A4TApA.getShort();
            this.f3436A5SV6n.f3429ASJ6gh = this.f3435A4TApA.getShort();
            int A5SV6n2 = A5SV6n();
            A4TApA a4TApA = this.f3436A5SV6n;
            a4TApA.f3430AYUAbz = (A5SV6n2 & r.b.d) != 0;
            a4TApA.f3431AZOQYO = (int) Math.pow(2.0d, (A5SV6n2 & 7) + 1);
            this.f3436A5SV6n.f3432AZkASS = A5SV6n();
            A4TApA a4TApA2 = this.f3436A5SV6n;
            A5SV6n();
            a4TApA2.getClass();
            if (this.f3436A5SV6n.f3430AYUAbz && !A2egSU()) {
                A4TApA a4TApA3 = this.f3436A5SV6n;
                a4TApA3.f3424A2egSU = AMqCpz(a4TApA3.f3431AZOQYO);
                A4TApA a4TApA4 = this.f3436A5SV6n;
                a4TApA4.f3433AaHO0E = a4TApA4.f3424A2egSU[a4TApA4.f3432AZkASS];
            }
        } else {
            this.f3436A5SV6n.f3425A4TApA = 1;
        }
        if (!A2egSU()) {
            boolean z = false;
            while (!z && !A2egSU() && this.f3436A5SV6n.f3426A5SV6n <= Integer.MAX_VALUE) {
                int A5SV6n3 = A5SV6n();
                if (A5SV6n3 == 33) {
                    int A5SV6n4 = A5SV6n();
                    if (A5SV6n4 == 1) {
                        ARc23Z();
                    } else if (A5SV6n4 == 249) {
                        this.f3436A5SV6n.f3427ADYaiT = new A2egSU();
                        A5SV6n();
                        int A5SV6n5 = A5SV6n();
                        A2egSU a2egSU = this.f3436A5SV6n.f3427ADYaiT;
                        int i2 = (A5SV6n5 & 28) >> 2;
                        a2egSU.f3419ASJ6gh = i2;
                        if (i2 == 0) {
                            a2egSU.f3419ASJ6gh = 1;
                        }
                        a2egSU.f3418ARc23Z = (A5SV6n5 & 1) != 0;
                        short s = this.f3435A4TApA.getShort();
                        if (s < 2) {
                            s = 10;
                        }
                        A2egSU a2egSU2 = this.f3436A5SV6n.f3427ADYaiT;
                        a2egSU2.f3421AZOQYO = s * 10;
                        a2egSU2.f3420AYUAbz = A5SV6n();
                        A5SV6n();
                    } else if (A5SV6n4 == 254) {
                        ARc23Z();
                    } else if (A5SV6n4 != 255) {
                        ARc23Z();
                    } else {
                        ADYaiT();
                        StringBuilder sb2 = new StringBuilder();
                        int i3 = 0;
                        while (true) {
                            bArr = this.f3434A2egSU;
                            if (i3 >= 11) {
                                break;
                            }
                            sb2.append((char) bArr[i3]);
                            i3++;
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                ADYaiT();
                                if (bArr[0] == 1) {
                                    byte b = bArr[1];
                                    byte b2 = bArr[2];
                                    this.f3436A5SV6n.getClass();
                                }
                                if (this.f3437ADYaiT > 0) {
                                }
                            } while (!A2egSU());
                        } else {
                            ARc23Z();
                        }
                    }
                } else if (A5SV6n3 == 44) {
                    A4TApA a4TApA5 = this.f3436A5SV6n;
                    if (a4TApA5.f3427ADYaiT == null) {
                        a4TApA5.f3427ADYaiT = new A2egSU();
                    }
                    a4TApA5.f3427ADYaiT.f3414A2egSU = this.f3435A4TApA.getShort();
                    this.f3436A5SV6n.f3427ADYaiT.f3415A4TApA = this.f3435A4TApA.getShort();
                    this.f3436A5SV6n.f3427ADYaiT.f3416A5SV6n = this.f3435A4TApA.getShort();
                    this.f3436A5SV6n.f3427ADYaiT.f3417ADYaiT = this.f3435A4TApA.getShort();
                    int A5SV6n6 = A5SV6n();
                    boolean z2 = (A5SV6n6 & r.b.d) != 0;
                    int pow = (int) Math.pow(2.0d, (A5SV6n6 & 7) + 1);
                    A2egSU a2egSU3 = this.f3436A5SV6n.f3427ADYaiT;
                    a2egSU3.AMqCpz = (A5SV6n6 & 64) != 0;
                    if (z2) {
                        a2egSU3.f3423AaHO0E = AMqCpz(pow);
                    } else {
                        a2egSU3.f3423AaHO0E = null;
                    }
                    this.f3436A5SV6n.f3427ADYaiT.f3422AZkASS = this.f3435A4TApA.position();
                    A5SV6n();
                    ARc23Z();
                    if (!A2egSU()) {
                        A4TApA a4TApA6 = this.f3436A5SV6n;
                        a4TApA6.f3426A5SV6n++;
                        a4TApA6.AMqCpz.add(a4TApA6.f3427ADYaiT);
                    }
                } else if (A5SV6n3 != 59) {
                    this.f3436A5SV6n.f3425A4TApA = 1;
                } else {
                    z = true;
                }
            }
            A4TApA a4TApA7 = this.f3436A5SV6n;
            if (a4TApA7.f3426A5SV6n < 0) {
                a4TApA7.f3425A4TApA = 1;
            }
        }
        return this.f3436A5SV6n;
    }

    public final int A5SV6n() {
        try {
            return this.f3435A4TApA.get() & 255;
        } catch (Exception unused) {
            this.f3436A5SV6n.f3425A4TApA = 1;
            return 0;
        }
    }

    public final void ADYaiT() {
        int A5SV6n2 = A5SV6n();
        this.f3437ADYaiT = A5SV6n2;
        if (A5SV6n2 <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            try {
                int i2 = this.f3437ADYaiT;
                if (i >= i2) {
                    return;
                }
                int i3 = i2 - i;
                this.f3435A4TApA.get(this.f3434A2egSU, i, i3);
                i += i3;
            } catch (Exception unused) {
                Log.isLoggable("GifHeaderParser", 3);
                this.f3436A5SV6n.f3425A4TApA = 1;
                return;
            }
        }
    }

    public final int[] AMqCpz(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f3435A4TApA.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | d.f13043a | (bArr[i5] & 255);
                i2 = i7;
            }
            return iArr;
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.f3436A5SV6n.f3425A4TApA = 1;
            return iArr;
        }
    }

    public final void ARc23Z() {
        int A5SV6n2;
        do {
            A5SV6n2 = A5SV6n();
            this.f3435A4TApA.position(Math.min(this.f3435A4TApA.position() + A5SV6n2, this.f3435A4TApA.limit()));
        } while (A5SV6n2 > 0);
    }
}
