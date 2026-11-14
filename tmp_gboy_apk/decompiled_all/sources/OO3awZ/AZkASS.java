package OO3awZ;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f6408A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f6409A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final boolean f6410A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final double f6411ADYaiT;
    public final AcNBzu AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final AcNBzu f6412ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final AcNBzu f6413ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final AcNBzu f6414AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final AcNBzu f6415AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final AcNBzu f6416AZkASS;

    public AZkASS(ADYaiT aDYaiT, boolean z, double d) {
        AcNBzu A2egSU2 = AcNBzu.A2egSU(aDYaiT.f6399A2egSU, aDYaiT.f6400A4TApA);
        double d2 = aDYaiT.f6399A2egSU;
        double d3 = aDYaiT.f6400A4TApA;
        AcNBzu A2egSU3 = AcNBzu.A2egSU(d2, Math.max(d3 - 32.0d, d3 * 0.5d));
        AZOQYO.ARc23Z aRc23Z = new AZOQYO.ARc23Z();
        aRc23Z.f363AcNBzu = aDYaiT;
        int round = (int) Math.round(aDYaiT.f6399A2egSU);
        ADYaiT aDYaiT2 = (ADYaiT) aRc23Z.AMqCpz().get(round);
        double AZkASS2 = aRc23Z.AZkASS(aDYaiT2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aDYaiT2);
        int i = 0;
        double d4 = 0.0d;
        while (i < 360) {
            int i2 = (round + i) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
            if (i2 < 0) {
                i2 += MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
            }
            double AZkASS3 = aRc23Z.AZkASS((ADYaiT) aRc23Z.AMqCpz().get(i2));
            d4 += Math.abs(AZkASS3 - AZkASS2);
            i++;
            AZkASS2 = AZkASS3;
        }
        int i3 = 6;
        double d5 = d4 / 6;
        double AZkASS4 = aRc23Z.AZkASS(aDYaiT2);
        int i4 = 1;
        double d6 = 0.0d;
        while (true) {
            if (arrayList.size() >= i3) {
                break;
            }
            int i5 = (round + i4) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
            ADYaiT aDYaiT3 = (ADYaiT) aRc23Z.AMqCpz().get(i5 < 0 ? i5 + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL : i5);
            double AZkASS5 = aRc23Z.AZkASS(aDYaiT3);
            d6 = Math.abs(AZkASS5 - AZkASS4) + d6;
            boolean z2 = d6 >= ((double) arrayList.size()) * d5;
            int i6 = 1;
            while (z2 && arrayList.size() < i3) {
                arrayList.add(aDYaiT3);
                int i7 = i4;
                z2 = d6 >= ((double) (arrayList.size() + i6)) * d5;
                i6++;
                i4 = i7;
                i3 = 6;
            }
            i4++;
            if (i4 > 360) {
                while (arrayList.size() < 6) {
                    arrayList.add(aDYaiT3);
                }
            } else {
                AZkASS4 = AZkASS5;
                i3 = 6;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aDYaiT);
        int floor = (int) Math.floor((3 - 1.0d) / 2.0d);
        for (int i8 = 1; i8 < floor + 1; i8++) {
            int i9 = 0 - i8;
            while (i9 < 0) {
                i9 += arrayList.size();
            }
            if (i9 >= arrayList.size()) {
                i9 %= arrayList.size();
            }
            arrayList2.add(0, (ADYaiT) arrayList.get(i9));
        }
        int i10 = 3 - floor;
        for (int i11 = 1; i11 < i10; i11++) {
            int i12 = i11;
            while (i12 < 0) {
                i12 += arrayList.size();
            }
            if (i12 >= arrayList.size()) {
                i12 %= arrayList.size();
            }
            arrayList2.add((ADYaiT) arrayList.get(i12));
        }
        ADYaiT ADYaiT2 = A2egSU.ADYaiT((ADYaiT) arrayList2.get(2));
        AcNBzu acNBzu = new AcNBzu(ADYaiT2.f6399A2egSU, ADYaiT2.f6400A4TApA);
        AcNBzu A2egSU4 = AcNBzu.A2egSU(aDYaiT.f6399A2egSU, aDYaiT.f6400A4TApA / 8.0d);
        AcNBzu A2egSU5 = AcNBzu.A2egSU(aDYaiT.f6399A2egSU, (aDYaiT.f6400A4TApA / 8.0d) + 4.0d);
        this.f6408A2egSU = aDYaiT;
        this.f6409A4TApA = 7;
        this.f6410A5SV6n = z;
        this.f6411ADYaiT = d;
        this.AMqCpz = A2egSU2;
        this.f6412ARc23Z = A2egSU3;
        this.f6413ASJ6gh = acNBzu;
        this.f6414AYUAbz = A2egSU4;
        this.f6415AZOQYO = A2egSU5;
        this.f6416AZkASS = AcNBzu.A2egSU(25.0d, 84.0d);
    }
}
