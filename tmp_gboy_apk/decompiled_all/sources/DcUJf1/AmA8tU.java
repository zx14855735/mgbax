package DcUJf1;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AmA8tU extends AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public BV3sI0.ARc23Z[] f2352A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public String f2353A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f2354A5SV6n;

    public AmA8tU() {
        this.f2352A2egSU = null;
        this.f2354A5SV6n = 0;
    }

    public BV3sI0.ARc23Z[] getPathData() {
        return this.f2352A2egSU;
    }

    public String getPathName() {
        return this.f2353A4TApA;
    }

    public void setPathData(BV3sI0.ARc23Z[] aRc23ZArr) {
        if (!com.bumptech.glide.AMqCpz.B25kr6(this.f2352A2egSU, aRc23ZArr)) {
            this.f2352A2egSU = com.bumptech.glide.AMqCpz.BIYEnU(aRc23ZArr);
            return;
        }
        BV3sI0.ARc23Z[] aRc23ZArr2 = this.f2352A2egSU;
        for (int i = 0; i < aRc23ZArr.length; i++) {
            aRc23ZArr2[i].f1487A2egSU = aRc23ZArr[i].f1487A2egSU;
            int i2 = 0;
            while (true) {
                float[] fArr = aRc23ZArr[i].f1488A4TApA;
                if (i2 < fArr.length) {
                    aRc23ZArr2[i].f1488A4TApA[i2] = fArr[i2];
                    i2++;
                }
            }
        }
    }

    public AmA8tU(AmA8tU amA8tU) {
        this.f2352A2egSU = null;
        this.f2354A5SV6n = 0;
        this.f2353A4TApA = amA8tU.f2353A4TApA;
        this.f2352A2egSU = com.bumptech.glide.AMqCpz.BIYEnU(amA8tU.f2352A2egSU);
    }
}
