package OO3awZ;

import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ASJ6gh implements Function {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6406AcNBzu;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        double d;
        double d2;
        double d3;
        switch (this.f6406AcNBzu) {
            case 0:
                AZkASS aZkASS = (AZkASS) obj;
                if (aZkASS.f6410A5SV6n) {
                    d = 24.0d;
                    double d4 = aZkASS.f6411ADYaiT;
                    if (d4 > -1.0d) {
                        d = d4 < 0.0d ? A2egSU.AZkASS(24.0d, 24.0d, (d4 - (-1.0d)) / 1.0d) : d4 < 0.5d ? A2egSU.AZkASS(24.0d, 29.0d, (d4 - 0.0d) / 0.5d) : d4 < 1.0d ? A2egSU.AZkASS(29.0d, 34.0d, (d4 - 0.5d) / 0.5d) : 34.0d;
                    }
                } else {
                    d = 98.0d;
                }
                return Double.valueOf(d);
            case 1:
                return ((AZkASS) obj).AMqCpz;
            case 2:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 10.0d : 90.0d);
            case 3:
                AZkASS aZkASS2 = (AZkASS) obj;
                boolean ARc23Z2 = AZOQYO.ARc23Z(aZkASS2);
                boolean z = aZkASS2.f6410A5SV6n;
                if (ARc23Z2) {
                    return Double.valueOf(z ? 10.0d : 90.0d);
                }
                return Double.valueOf(z ? 20.0d : 100.0d);
            case 4:
                return ((AZkASS) obj).AMqCpz;
            case 5:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 40.0d : 80.0d);
            case 6:
                return AZOQYO.ADYaiT();
            case 7:
                return ((AZkASS) obj).f6416AZkASS;
            case 8:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 20.0d : 100.0d);
            case 9:
                return ((AZkASS) obj).f6414AYUAbz;
            case 10:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 10.0d : 90.0d);
            case 11:
                return ((AZkASS) obj).f6413ASJ6gh;
            case 12:
                return ((AZkASS) obj).AMqCpz;
            case 13:
                return ((AZkASS) obj).f6415AZOQYO;
            case 14:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 30.0d : 90.0d);
            case 15:
                return ((AZkASS) obj).f6414AYUAbz;
            case 16:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 10.0d : 90.0d);
            case 17:
                return ((AZkASS) obj).f6414AYUAbz;
            case 18:
                AZkASS aZkASS3 = (AZkASS) obj;
                boolean z2 = aZkASS3.f6410A5SV6n;
                double d5 = aZkASS3.f6411ADYaiT;
                if (z2) {
                    d2 = 22.0d;
                    if (d5 > -1.0d) {
                        d2 = d5 < 0.0d ? A2egSU.AZkASS(22.0d, 22.0d, (d5 - (-1.0d)) / 1.0d) : d5 < 0.5d ? A2egSU.AZkASS(22.0d, 26.0d, (d5 - 0.0d) / 0.5d) : d5 < 1.0d ? A2egSU.AZkASS(26.0d, 30.0d, (d5 - 0.5d) / 0.5d) : 30.0d;
                    }
                } else {
                    double d6 = 90.0d;
                    if (d5 > -1.0d) {
                        if (d5 < 0.0d) {
                            d6 = A2egSU.AZkASS(90.0d, 90.0d, (d5 - (-1.0d)) / 1.0d);
                        } else if (d5 < 0.5d) {
                            d6 = A2egSU.AZkASS(90.0d, 84.0d, (d5 - 0.0d) / 0.5d);
                        } else if (d5 < 1.0d) {
                            d6 = A2egSU.AZkASS(84.0d, 80.0d, (d5 - 0.5d) / 0.5d);
                        } else {
                            d2 = 80.0d;
                        }
                    }
                    d2 = d6;
                }
                return Double.valueOf(d2);
            case 19:
                return ((AZkASS) obj).f6413ASJ6gh;
            case 20:
                AZkASS aZkASS4 = (AZkASS) obj;
                boolean ARc23Z3 = AZOQYO.ARc23Z(aZkASS4);
                boolean z3 = aZkASS4.f6410A5SV6n;
                if (ARc23Z3) {
                    return Double.valueOf(z3 ? 10.0d : 90.0d);
                }
                return Double.valueOf(z3 ? 20.0d : 100.0d);
            case 21:
                return ((AZkASS) obj).f6412ARc23Z;
            case 22:
                AZkASS aZkASS5 = (AZkASS) obj;
                boolean ARc23Z4 = AZOQYO.ARc23Z(aZkASS5);
                boolean z4 = aZkASS5.f6410A5SV6n;
                if (ARc23Z4) {
                    return Double.valueOf(z4 ? 10.0d : 100.0d);
                }
                return Double.valueOf(z4 ? 20.0d : 100.0d);
            case 23:
                return ((AZkASS) obj).f6412ARc23Z;
            case 24:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 80.0d : 40.0d);
            case 25:
                return ((AZkASS) obj).f6414AYUAbz;
            case 26:
                AZkASS aZkASS6 = (AZkASS) obj;
                if (aZkASS6.f6410A5SV6n) {
                    d3 = 4.0d;
                    double d7 = aZkASS6.f6411ADYaiT;
                    if (d7 > -1.0d) {
                        d3 = d7 < 0.0d ? A2egSU.AZkASS(4.0d, 4.0d, (d7 - (-1.0d)) / 1.0d) : d7 < 0.5d ? A2egSU.AZkASS(4.0d, 2.0d, (d7 - 0.0d) / 0.5d) : d7 < 1.0d ? A2egSU.AZkASS(2.0d, 0.0d, (d7 - 0.5d) / 0.5d) : 0.0d;
                    }
                } else {
                    d3 = 100.0d;
                }
                return Double.valueOf(d3);
            case 27:
                return ((AZkASS) obj).f6415AZOQYO;
            case 28:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 60.0d : 50.0d);
            default:
                return ((AZkASS) obj).f6414AYUAbz;
        }
    }
}
