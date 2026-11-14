package OO3awZ;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final double f6399A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final double f6400A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final double f6401A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f6402ADYaiT;

    public ADYaiT(int i) {
        this.f6402ADYaiT = i;
        AmA8tU amA8tU = AmA8tU.f6424AaHO0E;
        int i2 = i & 255;
        double AcNBzu2 = A2egSU.AcNBzu((16711680 & i) >> 16);
        double AcNBzu3 = A2egSU.AcNBzu((65280 & i) >> 8);
        double AcNBzu4 = A2egSU.AcNBzu(i2);
        double d = (0.18051042d * AcNBzu4) + (0.35762064d * AcNBzu3) + (0.41233895d * AcNBzu2);
        double d2 = (0.0722d * AcNBzu4) + (0.7152d * AcNBzu3) + (0.2126d * AcNBzu2);
        double d3 = (AcNBzu4 * 0.95034478d) + (AcNBzu3 * 0.11916382d) + (AcNBzu2 * 0.01932141d);
        double[][] dArr = A2egSU.f6381A2egSU;
        double[] dArr2 = dArr[0];
        double d4 = (dArr2[2] * d3) + (dArr2[1] * d2) + (dArr2[0] * d);
        double[] dArr3 = dArr[1];
        double d5 = (dArr3[2] * d3) + (dArr3[1] * d2) + (dArr3[0] * d);
        double[] dArr4 = dArr[2];
        double d6 = (d3 * dArr4[2]) + (d2 * dArr4[1]) + (d * dArr4[0]);
        double[] dArr5 = amA8tU.f6430ASJ6gh;
        double d7 = dArr5[0] * d4;
        double d8 = dArr5[1] * d5;
        double d9 = dArr5[2] * d6;
        double abs = Math.abs(d7);
        double d10 = amA8tU.f6431AYUAbz;
        double pow = Math.pow((abs * d10) / 100.0d, 0.42d);
        double pow2 = Math.pow((Math.abs(d8) * d10) / 100.0d, 0.42d);
        double pow3 = Math.pow((Math.abs(d9) * d10) / 100.0d, 0.42d);
        double signum = ((Math.signum(d7) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d8) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d9) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d11 = ((((-12.0d) * signum2) + (signum * 11.0d)) + signum3) / 11.0d;
        double d12 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d13 = signum2 * 20.0d;
        double d14 = ((21.0d * signum3) + ((signum * 20.0d) + d13)) / 20.0d;
        double d15 = (((signum * 40.0d) + d13) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d12, d11));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double radians = Math.toRadians(degrees);
        double d16 = d15 * amA8tU.f6426A4TApA;
        double d17 = amA8tU.f6425A2egSU;
        double d18 = d16 / d17;
        double d19 = amA8tU.f6433AZkASS;
        double d20 = amA8tU.f6428ADYaiT;
        double pow4 = (Math.pow(d18, d20 * d19) * 100.0d) / 100.0d;
        Math.sqrt(pow4);
        double d21 = d17 + 4.0d;
        double pow5 = Math.pow((Math.hypot(d11, d12) * (((((Math.cos(Math.toRadians(degrees < 20.14d ? 360.0d + degrees : degrees) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * amA8tU.AMqCpz) * amA8tU.f6427A5SV6n)) / (d14 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, amA8tU.f6429ARc23Z), 0.73d);
        double sqrt = Math.sqrt(pow4) * pow5;
        double d22 = amA8tU.f6432AZOQYO * sqrt;
        Math.sqrt((pow5 * d20) / d21);
        Math.log1p(d22 * 0.0228d);
        Math.cos(radians);
        Math.sin(radians);
        this.f6399A2egSU = degrees;
        this.f6400A4TApA = sqrt;
        this.f6401A5SV6n = (A2egSU.AYUAbz(A2egSU.AlLFFp(new double[]{A2egSU.AcNBzu((i >> 16) & 255), A2egSU.AcNBzu((i >> 8) & 255), A2egSU.AcNBzu(i2)}, A2egSU.f6382A4TApA)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x01b2, code lost:
    
        if (r0[1] > 100.01d) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01b8, code lost:
    
        if (r0[2] <= 100.01d) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01bb, code lost:
    
        r0 = (OO3awZ.A2egSU.A5SV6n(r0[2]) & 255) | ((((OO3awZ.A2egSU.A5SV6n(r1) & 255) << 16) | com.sigmob.sdk.base.blurkit.d.f13043a) | ((OO3awZ.A2egSU.A5SV6n(r0[1]) & 255) << 8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01a3, code lost:
    
        r1 = r0[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01ac, code lost:
    
        if (r1 > 100.01d) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static OO3awZ.ADYaiT A2egSU(double r45, double r47, double r49) {
        /*
            Method dump skipped, instructions count: 1064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OO3awZ.ADYaiT.A2egSU(double, double, double):OO3awZ.ADYaiT");
    }
}
