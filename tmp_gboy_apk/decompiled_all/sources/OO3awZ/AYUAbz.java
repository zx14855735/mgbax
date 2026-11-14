package OO3awZ;

import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AYUAbz implements Function {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6407AcNBzu;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        double d;
        switch (this.f6407AcNBzu) {
            case 0:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 20.0d : 95.0d);
            case 1:
                return AZOQYO.ADYaiT();
            case 2:
                return ((AZkASS) obj).f6413ASJ6gh;
            case 3:
                return ((AZkASS) obj).f6412ARc23Z;
            case 4:
                return ((AZkASS) obj).f6414AYUAbz;
            case 5:
                return ((AZkASS) obj).f6416AZkASS;
            case 6:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 80.0d : 40.0d);
            case 7:
                return ((AZkASS) obj).f6414AYUAbz;
            case 8:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 10.0d : 90.0d);
            case 9:
                return ((AZkASS) obj).f6414AYUAbz;
            case 10:
                AZkASS aZkASS = (AZkASS) obj;
                boolean z = aZkASS.f6410A5SV6n;
                double d2 = aZkASS.f6411ADYaiT;
                if (z) {
                    d = 12.0d;
                    if (d2 > -1.0d) {
                        d = d2 < 0.0d ? A2egSU.AZkASS(12.0d, 12.0d, (d2 - (-1.0d)) / 1.0d) : d2 < 0.5d ? A2egSU.AZkASS(12.0d, 16.0d, (d2 - 0.0d) / 0.5d) : d2 < 1.0d ? A2egSU.AZkASS(16.0d, 20.0d, (d2 - 0.5d) / 0.5d) : 20.0d;
                    }
                } else {
                    double d3 = 94.0d;
                    if (d2 > -1.0d) {
                        if (d2 < 0.0d) {
                            d3 = A2egSU.AZkASS(94.0d, 94.0d, (d2 - (-1.0d)) / 1.0d);
                        } else if (d2 < 0.5d) {
                            d3 = A2egSU.AZkASS(94.0d, 92.0d, (d2 - 0.0d) / 0.5d);
                        } else if (d2 < 1.0d) {
                            d3 = A2egSU.AZkASS(92.0d, 90.0d, (d2 - 0.5d) / 0.5d);
                        } else {
                            d = 90.0d;
                        }
                    }
                    d = d3;
                }
                return Double.valueOf(d);
            case 11:
                return ((AZkASS) obj).f6415AZOQYO;
            case 12:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 80.0d : 30.0d);
            case 13:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 90.0d : 10.0d);
            case 14:
                return ((AZkASS) obj).f6414AYUAbz;
            case 15:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 90.0d : 20.0d);
            case 16:
                return ((AZkASS) obj).f6416AZkASS;
            case 17:
                AZkASS aZkASS2 = (AZkASS) obj;
                boolean ARc23Z2 = AZOQYO.ARc23Z(aZkASS2);
                boolean z2 = aZkASS2.f6410A5SV6n;
                if (ARc23Z2) {
                    return Double.valueOf(z2 ? 90.0d : 10.0d);
                }
                return Double.valueOf(z2 ? 90.0d : 30.0d);
            case 18:
                return ((AZkASS) obj).f6415AZOQYO;
            case 19:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 30.0d : 80.0d);
            case 20:
                return ((AZkASS) obj).f6416AZkASS;
            case 21:
                return Double.valueOf(((AZkASS) obj).f6410A5SV6n ? 30.0d : 90.0d);
            default:
                return AZOQYO.A5SV6n((AZkASS) obj);
        }
    }
}
