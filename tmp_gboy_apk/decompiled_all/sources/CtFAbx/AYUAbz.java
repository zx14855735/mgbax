package CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public double f1908A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public double f1909A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f1910A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public double f1911ADYaiT;
    public double AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public double f1912ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public double f1913ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public double f1914AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public double f1915AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final ARc23Z f1916AZkASS;

    public AYUAbz() {
        this.f1908A2egSU = Math.sqrt(1500.0d);
        this.f1909A4TApA = 0.5d;
        this.f1910A5SV6n = false;
        this.f1915AZOQYO = Double.MAX_VALUE;
        this.f1916AZkASS = new ARc23Z();
    }

    public final void A2egSU(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f1909A4TApA = f;
        this.f1910A5SV6n = false;
    }

    public final void A4TApA(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f1908A2egSU = Math.sqrt(f);
        this.f1910A5SV6n = false;
    }

    public final ARc23Z A5SV6n(double d, double d2, long j) {
        double sin;
        double cos;
        if (!this.f1910A5SV6n) {
            if (this.f1915AZOQYO == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d3 = this.f1909A4TApA;
            if (d3 > 1.0d) {
                double d4 = this.f1908A2egSU;
                this.f1912ARc23Z = (Math.sqrt((d3 * d3) - 1.0d) * d4) + ((-d3) * d4);
                double d5 = this.f1909A4TApA;
                double d6 = this.f1908A2egSU;
                this.f1913ASJ6gh = ((-d5) * d6) - (Math.sqrt((d5 * d5) - 1.0d) * d6);
            } else if (d3 >= 0.0d && d3 < 1.0d) {
                this.f1914AYUAbz = Math.sqrt(1.0d - (d3 * d3)) * this.f1908A2egSU;
            }
            this.f1910A5SV6n = true;
        }
        double d7 = j / 1000.0d;
        double d8 = d - this.f1915AZOQYO;
        double d9 = this.f1909A4TApA;
        if (d9 > 1.0d) {
            double d10 = this.f1913ASJ6gh;
            double d11 = ((d10 * d8) - d2) / (d10 - this.f1912ARc23Z);
            double d12 = d8 - d11;
            sin = (Math.pow(2.718281828459045d, this.f1912ARc23Z * d7) * d11) + (Math.pow(2.718281828459045d, d10 * d7) * d12);
            double d13 = this.f1913ASJ6gh;
            double pow = Math.pow(2.718281828459045d, d13 * d7) * d12 * d13;
            double d14 = this.f1912ARc23Z;
            cos = (Math.pow(2.718281828459045d, d14 * d7) * d11 * d14) + pow;
        } else if (d9 == 1.0d) {
            double d15 = this.f1908A2egSU;
            double d16 = (d15 * d8) + d2;
            double d17 = (d16 * d7) + d8;
            double pow2 = Math.pow(2.718281828459045d, (-d15) * d7) * d17;
            double pow3 = Math.pow(2.718281828459045d, (-this.f1908A2egSU) * d7) * d17;
            double d18 = -this.f1908A2egSU;
            cos = (Math.pow(2.718281828459045d, d18 * d7) * d16) + (pow3 * d18);
            sin = pow2;
        } else {
            double d19 = 1.0d / this.f1914AYUAbz;
            double d20 = this.f1908A2egSU;
            double d21 = ((d9 * d20 * d8) + d2) * d19;
            sin = ((Math.sin(this.f1914AYUAbz * d7) * d21) + (Math.cos(this.f1914AYUAbz * d7) * d8)) * Math.pow(2.718281828459045d, (-d9) * d20 * d7);
            double d22 = this.f1908A2egSU;
            double d23 = this.f1909A4TApA;
            double d24 = (-d22) * sin * d23;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d7);
            double d25 = this.f1914AYUAbz;
            double sin2 = Math.sin(d25 * d7) * (-d25) * d8;
            double d26 = this.f1914AYUAbz;
            cos = (((Math.cos(d26 * d7) * d21 * d26) + sin2) * pow4) + d24;
        }
        float f = (float) (sin + this.f1915AZOQYO);
        ARc23Z aRc23Z = this.f1916AZkASS;
        aRc23Z.f1888A2egSU = f;
        aRc23Z.f1889A4TApA = (float) cos;
        return aRc23Z;
    }

    public AYUAbz(float f) {
        this.f1908A2egSU = Math.sqrt(1500.0d);
        this.f1909A4TApA = 0.5d;
        this.f1910A5SV6n = false;
        this.f1916AZkASS = new ARc23Z();
        this.f1915AZOQYO = f;
    }
}
