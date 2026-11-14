package OLy1FW;

import ADYaiT.CtFAbx;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f6351A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f6352A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f6353A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f6354ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final ArrayList f6355ARc23Z = new ArrayList();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final ArrayList f6356ASJ6gh = new ArrayList();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ArrayList f6357AYUAbz = new ArrayList();

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ArrayList f6358AZOQYO = new ArrayList();

    /* renamed from: AZkASS, reason: collision with root package name */
    public final boolean f6359AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final int f6360AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f6361AcNBzu;

    public ARc23Z(boolean z, String... strArr) {
        byte[] bArr;
        char c = 3;
        this.f6359AZkASS = z;
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            if (this.f6359AZkASS) {
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                byte[] ARc23Z2 = AYUAbz.ARc23Z((short) str.length());
                byte[] ARc23Z3 = AYUAbz.ARc23Z((short) bytes.length);
                byte[][] bArr2 = new byte[4][];
                bArr2[0] = ARc23Z2;
                bArr2[1] = ARc23Z3;
                bArr2[2] = bytes;
                bArr2[c] = new byte[]{0};
                int i3 = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    i3 += bArr2[i4].length;
                }
                bArr = new byte[i3];
                int i5 = 0;
                for (int i6 = 0; i6 < 4; i6++) {
                    byte[] bArr3 = bArr2[i6];
                    System.arraycopy(bArr3, 0, bArr, i5, bArr3.length);
                    i5 += bArr3.length;
                }
            } else {
                char[] charArray = str.toCharArray();
                int length2 = charArray.length * 2;
                byte[] bArr4 = new byte[length2 + 4];
                byte[] AcNBzu2 = AYUAbz.AcNBzu((short) charArray.length);
                bArr4[0] = AcNBzu2[0];
                bArr4[1] = AcNBzu2[1];
                for (int i7 = 0; i7 < charArray.length; i7++) {
                    byte[] A5SV6n2 = AYUAbz.A5SV6n(charArray[i7]);
                    int i8 = i7 * 2;
                    bArr4[i8 + 2] = A5SV6n2[0];
                    bArr4[i8 + 3] = A5SV6n2[1];
                }
                bArr4[length2 + 2] = 0;
                bArr4[length2 + 3] = 0;
                bArr = bArr4;
            }
            Pair pair = new Pair(bArr, Collections.EMPTY_LIST);
            this.f6355ARc23Z.add(Integer.valueOf(i2));
            byte[] bArr5 = (byte[]) pair.first;
            i2 += bArr5.length;
            this.f6357AYUAbz.add(bArr5);
            this.f6358AZOQYO.add((List) pair.second);
            i++;
            c = 3;
        }
        Iterator it = this.f6358AZOQYO.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            List list = (List) it.next();
            Iterator it2 = list.iterator();
            if (it2.hasNext()) {
                if (it2.next() != null) {
                    throw new ClassCastException();
                }
                this.f6355ARc23Z.add(Integer.valueOf(i2));
                throw null;
            }
            this.f6356ASJ6gh.add(Integer.valueOf(i9));
            i9 += (list.size() * 12) + 4;
        }
        int i10 = i2 % 4;
        int i11 = i10 == 0 ? 0 : 4 - i10;
        this.f6360AaHO0E = i11;
        int size = this.f6357AYUAbz.size();
        this.f6352A4TApA = size;
        this.f6353A5SV6n = this.f6357AYUAbz.size() - strArr.length;
        boolean z2 = this.f6357AYUAbz.size() - strArr.length > 0;
        if (!z2) {
            this.f6356ASJ6gh.clear();
            this.f6358AZOQYO.clear();
        }
        int size2 = (this.f6356ASJ6gh.size() * 4) + (size * 4) + 28;
        this.f6354ADYaiT = size2;
        int i12 = i2 + i11;
        this.AMqCpz = z2 ? size2 + i12 : 0;
        int i13 = size2 + i12 + (z2 ? i9 : 0);
        this.f6361AcNBzu = i13;
        this.f6351A2egSU = new ADYaiT((short) 1, (short) 28, i13);
    }

    public final void A2egSU(ByteArrayOutputStream byteArrayOutputStream) {
        this.f6351A2egSU.A2egSU(byteArrayOutputStream);
        byteArrayOutputStream.write(AYUAbz.A2egSU(this.f6352A4TApA));
        byteArrayOutputStream.write(AYUAbz.A2egSU(this.f6353A5SV6n));
        byteArrayOutputStream.write(AYUAbz.A2egSU(this.f6359AZkASS ? 256 : 0));
        byteArrayOutputStream.write(AYUAbz.A2egSU(this.f6354ADYaiT));
        byteArrayOutputStream.write(AYUAbz.A2egSU(this.AMqCpz));
        Iterator it = this.f6355ARc23Z.iterator();
        while (it.hasNext()) {
            byteArrayOutputStream.write(AYUAbz.A2egSU(((Integer) it.next()).intValue()));
        }
        Iterator it2 = this.f6356ASJ6gh.iterator();
        while (it2.hasNext()) {
            byteArrayOutputStream.write(AYUAbz.A2egSU(((Integer) it2.next()).intValue()));
        }
        Iterator it3 = this.f6357AYUAbz.iterator();
        while (it3.hasNext()) {
            byteArrayOutputStream.write((byte[]) it3.next());
        }
        int i = this.f6360AaHO0E;
        if (i > 0) {
            byteArrayOutputStream.write(new byte[i]);
        }
        Iterator it4 = this.f6358AZOQYO.iterator();
        while (it4.hasNext()) {
            Iterator it5 = ((List) it4.next()).iterator();
            if (it5.hasNext()) {
                throw CtFAbx.A5SV6n(it5);
            }
            byteArrayOutputStream.write(AYUAbz.A2egSU(-1));
        }
    }
}
