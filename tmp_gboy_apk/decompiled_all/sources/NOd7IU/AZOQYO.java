package NOd7IU;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AZOQYO extends NUY5pn.A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f5869A2egSU;

    public AZOQYO(byte[] bArr) {
        String str;
        String str2;
        if (bArr.length != 25) {
            int length = bArr.length;
            int length2 = bArr.length;
            if (bArr.length == 0 || length2 <= 0 || length2 > bArr.length) {
                str = null;
            } else {
                StringBuilder sb = new StringBuilder(((length2 + 15) / 16) * 57);
                int i = length2;
                int i2 = 0;
                int i3 = 0;
                while (i > 0) {
                    if (i2 == 0) {
                        str2 = length2 < 65536 ? String.format("%04X:", Integer.valueOf(i3)) : String.format("%08X:", Integer.valueOf(i3));
                    } else {
                        str2 = i2 == 8 ? " -" : str2;
                        sb.append(String.format(" %02X", Integer.valueOf(bArr[i3] & 255)));
                        i--;
                        i2++;
                        if (i2 != 16 || i == 0) {
                            sb.append('\n');
                            i2 = 0;
                        }
                        i3++;
                    }
                    sb.append(str2);
                    sb.append(String.format(" %02X", Integer.valueOf(bArr[i3] & 255)));
                    i--;
                    i2++;
                    if (i2 != 16) {
                    }
                    sb.append('\n');
                    i2 = 0;
                    i3++;
                }
                str = sb.toString();
            }
            String valueOf = String.valueOf(str);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 51);
            sb2.append("Cert hash data has incorrect length (");
            sb2.append(length);
            sb2.append("):\n");
            sb2.append(valueOf);
            Log.wtf("GoogleCertificates", sb2.toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            boolean z = bArr.length == 25;
            int length3 = bArr.length;
            StringBuilder sb3 = new StringBuilder(55);
            sb3.append("cert hash data has incorrect length. length=");
            sb3.append(length3);
            NUY5pn.AYUAbz.ASJ6gh(z, sb3.toString());
        }
        this.f5869A2egSU = Arrays.hashCode(bArr);
    }

    public static byte[] A2egSU(String str) {
        try {
            return str.getBytes(CharEncoding.ISO_8859_1);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public abstract byte[] A4TApA();

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NUY5pn.A5SV6n)) {
            return false;
        }
        try {
            NUY5pn.A5SV6n a5SV6n = (NUY5pn.A5SV6n) obj;
            if (((AZOQYO) a5SV6n).f5869A2egSU != this.f5869A2egSU) {
                return false;
            }
            return Arrays.equals(A4TApA(), new N8piWc.A4TApA(((AZOQYO) a5SV6n).A4TApA()).f5592A2egSU);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return this.f5869A2egSU;
    }
}
