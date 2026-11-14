package HFjH17;

import android.media.MediaPlayer;
import java.util.concurrent.ScheduledFuture;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3326AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ DG07BK.A2egSU f3327AlLFFp;

    public /* synthetic */ AYUAbz(DG07BK.A2egSU a2egSU, int i) {
        this.f3326AcNBzu = i;
        this.f3327AlLFFp = a2egSU;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AZkASS aZkASS;
        MediaPlayer mediaPlayer;
        switch (this.f3326AcNBzu) {
            case 0:
                AZOQYO.A2egSU((AZOQYO) this.f3327AlLFFp.f2059A4TApA);
                break;
            case 1:
                AZOQYO azoqyo = (AZOQYO) this.f3327AlLFFp.f2059A4TApA;
                if (!azoqyo.f3331AzWtSf && (mediaPlayer = (aZkASS = azoqyo.f3332B25kr6).f3333A2egSU) != null && mediaPlayer.getCurrentPosition() >= 1) {
                    aZkASS.A4TApA(65543, null);
                    azoqyo.f3331AzWtSf = true;
                    ScheduledFuture scheduledFuture = aZkASS.f3339AYUAbz;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(true);
                        break;
                    }
                }
                break;
            default:
                AZOQYO.A2egSU((AZOQYO) this.f3327AlLFFp.f2059A4TApA);
                break;
        }
    }
}
