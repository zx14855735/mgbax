package HXc4pW;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BmvVmW implements HSHyT0.AZkASS {

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final ItGa5w.AZOQYO f3638AZkASS = new ItGa5w.AZOQYO(50);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HZUvgL.AaHO0E f3639A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HSHyT0.AZkASS f3640A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HSHyT0.AZkASS f3641ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f3642ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Class f3643ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final HSHyT0.AmA8tU f3644AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final HSHyT0.B3GDIM f3645AZOQYO;

    static {
        nXiHObq();
    }

    public BmvVmW(HZUvgL.AaHO0E aaHO0E, HSHyT0.AZkASS aZkASS, HSHyT0.AZkASS aZkASS2, int i, int i2, HSHyT0.B3GDIM b3gdim, Class cls, HSHyT0.AmA8tU amA8tU) {
        this.f3639A4TApA = aaHO0E;
        this.f3640A5SV6n = aZkASS;
        this.f3641ADYaiT = aZkASS2;
        this.AMqCpz = i;
        this.f3642ARc23Z = i2;
        this.f3645AZOQYO = b3gdim;
        this.f3643ASJ6gh = cls;
        this.f3644AYUAbz = amA8tU;
    }

    private static /* synthetic */ void nXiHObq() {
        char[] charArray = "DHJ\t@FJB\tEH^\tTOBKK\tmINeUNC@B".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\'');
        }
        String str = new String(charArray);
        char[] charArray2 = "DKNINS".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\'');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        Object ARc23Z2;
        HZUvgL.AaHO0E aaHO0E = this.f3639A4TApA;
        synchronized (aaHO0E) {
            HZUvgL.AZkASS aZkASS = aaHO0E.f3664A4TApA;
            HZUvgL.AlLFFp alLFFp = (HZUvgL.AlLFFp) ((ArrayDeque) aZkASS.f3654AcNBzu).poll();
            if (alLFFp == null) {
                alLFFp = aZkASS.A5SV6n();
            }
            HZUvgL.AZOQYO azoqyo = (HZUvgL.AZOQYO) alLFFp;
            azoqyo.f3660A4TApA = 8;
            azoqyo.f3661A5SV6n = byte[].class;
            ARc23Z2 = aaHO0E.ARc23Z(azoqyo, byte[].class);
        }
        byte[] bArr = (byte[]) ARc23Z2;
        ByteBuffer.wrap(bArr).putInt(this.AMqCpz).putInt(this.f3642ARc23Z).array();
        this.f3641ADYaiT.A2egSU(messageDigest);
        this.f3640A5SV6n.A2egSU(messageDigest);
        messageDigest.update(bArr);
        HSHyT0.B3GDIM b3gdim = this.f3645AZOQYO;
        if (b3gdim != null) {
            b3gdim.A2egSU(messageDigest);
        }
        this.f3644AYUAbz.A2egSU(messageDigest);
        ItGa5w.AZOQYO azoqyo2 = f3638AZkASS;
        Class cls = this.f3643ASJ6gh;
        byte[] bArr2 = (byte[]) azoqyo2.A2egSU(cls);
        if (bArr2 == null) {
            bArr2 = cls.getName().getBytes(HSHyT0.AZkASS.f3465A2egSU);
            azoqyo2.ADYaiT(cls, bArr2);
        }
        messageDigest.update(bArr2);
        this.f3639A4TApA.AYUAbz(bArr);
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (obj instanceof BmvVmW) {
            BmvVmW bmvVmW = (BmvVmW) obj;
            if (this.f3642ARc23Z == bmvVmW.f3642ARc23Z && this.AMqCpz == bmvVmW.AMqCpz && ItGa5w.AlLFFp.A2egSU(this.f3645AZOQYO, bmvVmW.f3645AZOQYO) && this.f3643ASJ6gh.equals(bmvVmW.f3643ASJ6gh) && this.f3640A5SV6n.equals(bmvVmW.f3640A5SV6n) && this.f3641ADYaiT.equals(bmvVmW.f3641ADYaiT) && this.f3644AYUAbz.equals(bmvVmW.f3644AYUAbz)) {
                return true;
            }
        }
        return false;
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        int hashCode = ((((this.f3641ADYaiT.hashCode() + (this.f3640A5SV6n.hashCode() * 31)) * 31) + this.AMqCpz) * 31) + this.f3642ARc23Z;
        HSHyT0.B3GDIM b3gdim = this.f3645AZOQYO;
        if (b3gdim != null) {
            hashCode = (hashCode * 31) + b3gdim.hashCode();
        }
        return this.f3644AYUAbz.f3470A4TApA.hashCode() + ((this.f3643ASJ6gh.hashCode() + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f3640A5SV6n + ", signature=" + this.f3641ADYaiT + ", width=" + this.AMqCpz + ", height=" + this.f3642ARc23Z + ", decodedResourceClass=" + this.f3643ASJ6gh + ", transformation='" + this.f3645AZOQYO + "', options=" + this.f3644AYUAbz + '}';
    }
}
