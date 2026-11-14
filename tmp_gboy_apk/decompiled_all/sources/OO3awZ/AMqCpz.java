package OO3awZ;

import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AMqCpz implements Function {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6403AcNBzu;

    public /* synthetic */ AMqCpz(int i) {
        this.f6403AcNBzu = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        double AZkASS2;
        double d;
        double d2;
        switch (this.f6403AcNBzu) {
            case 0:
                return ((AZkASS) obj).f6414AYUAbz;
            case 1:
                return ((AZkASS) obj).AMqCpz;
            case 2:
                AZkASS aZkASS = (AZkASS) obj;
                boolean ARc23Z2 = AZOQYO.ARc23Z(aZkASS);
                boolean z = aZkASS.f6410A5SV6n;
                if (ARc23Z2) {
                    return Double.valueOf(z ? 100.0d : 0.0d);
                }
                return Double.valueOf(z ? 80.0d : 40.0d);
            case 3:
                return ((AZkASS) obj).f6413ASJ6gh;
            case 4:
                AZkASS aZkASS2 = (AZkASS) obj;
                boolean ARc23Z3 = AZOQYO.ARc23Z(aZkASS2);
                boolean z2 = aZkASS2.f6410A5SV6n;
                if (ARc23Z3) {
                    return Double.valueOf(z2 ? 90.0d : 25.0d);
                }
                return Double.valueOf(z2 ? 80.0d : 40.0d);
            case 5:
                return ((AZkASS) obj).f6414AYUAbz;
            case 6:
                AZkASS aZkASS3 = (AZkASS) obj;
                if (aZkASS3.f6410A5SV6n) {
                    AZkASS2 = 6.0d;
                } else {
                    double d3 = aZkASS3.f6411ADYaiT;
                    AZkASS2 = d3 <= -1.0d ? 87.0d : d3 < 0.0d ? A2egSU.AZkASS(87.0d, 87.0d, (d3 - (-1.0d)) / 1.0d) : d3 < 0.5d ? A2egSU.AZkASS(87.0d, 80.0d, (d3 - 0.0d) / 0.5d) : d3 < 1.0d ? A2egSU.AZkASS(80.0d, 75.0d, (d3 - 0.5d) / 0.5d) : 75.0d;
                }
                return Double.valueOf(AZkASS2);
            case 7:
                return ((AZkASS) obj).f6415AZOQYO;
            case 8:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 80.0d : 30.0d);
            case 9:
                return ((AZkASS) obj).AMqCpz;
            case 10:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 30.0d : 90.0d);
            case 11:
                return ((AZkASS) obj).f6414AYUAbz;
            case 12:
                AZkASS aZkASS4 = (AZkASS) obj;
                boolean z3 = aZkASS4.f6410A5SV6n;
                double d4 = aZkASS4.f6411ADYaiT;
                if (z3) {
                    d = 10.0d;
                    if (d4 > -1.0d) {
                        d = d4 < 0.0d ? A2egSU.AZkASS(10.0d, 10.0d, (d4 - (-1.0d)) / 1.0d) : d4 < 0.5d ? A2egSU.AZkASS(10.0d, 11.0d, (d4 - 0.0d) / 0.5d) : d4 < 1.0d ? A2egSU.AZkASS(11.0d, 12.0d, (d4 - 0.5d) / 0.5d) : 12.0d;
                    }
                } else {
                    double d5 = 96.0d;
                    if (d4 > -1.0d) {
                        if (d4 < 0.0d) {
                            d5 = A2egSU.AZkASS(96.0d, 96.0d, (d4 - (-1.0d)) / 1.0d);
                        } else if (d4 < 0.5d) {
                            d5 = A2egSU.AZkASS(96.0d, 96.0d, (d4 - 0.0d) / 0.5d);
                        } else if (d4 < 1.0d) {
                            d5 = A2egSU.AZkASS(96.0d, 95.0d, (d4 - 0.5d) / 0.5d);
                        } else {
                            d = 95.0d;
                        }
                    }
                    d = d5;
                }
                return Double.valueOf(d);
            case 13:
                return ((AZkASS) obj).f6412ARc23Z;
            case 14:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 6.0d : 98.0d);
            case 15:
                return ((AZkASS) obj).f6414AYUAbz;
            case 16:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 100.0d : 0.0d);
            case 17:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 0.2d : 0.12d);
            case 18:
                return ((AZkASS) obj).AMqCpz;
            case 19:
                return ((AZkASS) obj).f6414AYUAbz;
            case 20:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 6.0d : 98.0d);
            case 21:
                return ((AZkASS) obj).f6414AYUAbz;
            case 22:
                return ((AZkASS) obj).f6414AYUAbz;
            case 23:
                AZkASS aZkASS5 = (AZkASS) obj;
                boolean z4 = aZkASS5.f6410A5SV6n;
                double d6 = aZkASS5.f6411ADYaiT;
                if (z4) {
                    d2 = 17.0d;
                    if (d6 > -1.0d) {
                        d2 = d6 < 0.0d ? A2egSU.AZkASS(17.0d, 17.0d, (d6 - (-1.0d)) / 1.0d) : d6 < 0.5d ? A2egSU.AZkASS(17.0d, 21.0d, (d6 - 0.0d) / 0.5d) : d6 < 1.0d ? A2egSU.AZkASS(21.0d, 25.0d, (d6 - 0.5d) / 0.5d) : 25.0d;
                    }
                } else {
                    double d7 = 92.0d;
                    if (d6 > -1.0d) {
                        if (d6 < 0.0d) {
                            d7 = A2egSU.AZkASS(92.0d, 92.0d, (d6 - (-1.0d)) / 1.0d);
                        } else if (d6 < 0.5d) {
                            d7 = A2egSU.AZkASS(92.0d, 88.0d, (d6 - 0.0d) / 0.5d);
                        } else if (d6 < 1.0d) {
                            d7 = A2egSU.AZkASS(88.0d, 85.0d, (d6 - 0.5d) / 0.5d);
                        } else {
                            d2 = 85.0d;
                        }
                    }
                    d2 = d7;
                }
                return Double.valueOf(d2);
            case 24:
                return ((AZkASS) obj).f6414AYUAbz;
            case 25:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 90.0d : 10.0d);
            case 26:
                return new A5SV6n("background", new AMqCpz(19), new AMqCpz(20), true, null, null, null);
            case 27:
                return ((AZkASS) obj).f6415AZOQYO;
            case 28:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 30.0d : 80.0d);
            default:
                return ((AZkASS) obj).f6414AYUAbz;
        }
    }
}
