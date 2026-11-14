package OLy1FW;

import LLiCI0.BChYOn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f6340A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A5SV6n f6341A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ARc23Z f6342A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ARc23Z f6343ADYaiT;
    public final ASJ6gh AMqCpz;

    public A4TApA(A5SV6n a5SV6n, List list) {
        String[] strArr;
        int i;
        this.f6341A4TApA = a5SV6n;
        if (list.isEmpty()) {
            strArr = new String[0];
        } else {
            int i2 = ((A2egSU) list.get(0)).f6337A4TApA;
            strArr = new String[i2];
            int i3 = 0;
            while (true) {
                i = i2 - 1;
                if (i3 >= i) {
                    break;
                }
                StringBuilder sb = new StringBuilder("?");
                int i4 = i3 + 1;
                sb.append(i4);
                strArr[i3] = sb.toString();
                i3 = i4;
            }
            strArr[i] = "color";
        }
        this.f6342A5SV6n = new ARc23Z(false, strArr);
        String[] strArr2 = new String[list.size()];
        for (int i5 = 0; i5 < list.size(); i5++) {
            strArr2[i5] = ((A2egSU) list.get(i5)).f6339ADYaiT;
        }
        this.f6343ADYaiT = new ARc23Z(true, strArr2);
        this.AMqCpz = new ASJ6gh(list);
        this.f6340A2egSU = new ADYaiT((short) 512, (short) 288, A2egSU());
    }

    public final int A2egSU() {
        int i = this.f6342A5SV6n.f6361AcNBzu + MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE + this.f6343ADYaiT.f6361AcNBzu;
        ASJ6gh aSJ6gh = this.AMqCpz;
        int i2 = (aSJ6gh.f6363A4TApA * 4) + 16;
        BChYOn bChYOn = aSJ6gh.f6365ADYaiT;
        return (((AMqCpz[]) bChYOn.AMqCpz).length * 16) + (((int[]) bChYOn.f4728ADYaiT).length * 4) + 84 + i2 + i;
    }
}
