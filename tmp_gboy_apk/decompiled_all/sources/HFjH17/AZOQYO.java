package HFjH17;

import android.media.MediaPlayer;
import android.os.HandlerThread;
import java.util.concurrent.ScheduledFuture;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f3328AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f3329AlLFFp = 0;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f3330AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f3331AzWtSf = false;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ AZkASS f3332B25kr6;

    public AZOQYO(AZkASS aZkASS) {
        this.f3332B25kr6 = aZkASS;
        if (aZkASS.f3342AaHO0E == null) {
            aZkASS.f3342AaHO0E = new HandlerThread("VideoEventListener");
        }
        if (!aZkASS.f3343AcNBzu) {
            aZkASS.f3342AaHO0E.start();
            aZkASS.f3343AcNBzu = true;
        }
        aZkASS.f3340AZOQYO = new DG07BK.A2egSU(this, aZkASS.f3342AaHO0E.getLooper(), 7);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [H0qugq.AZOQYO, HFjH17.ASJ6gh] */
    public static void A2egSU(AZOQYO azoqyo) {
        int i;
        int currentPosition;
        int i2;
        int i3 = azoqyo.f3328AcNBzu;
        AZkASS aZkASS = azoqyo.f3332B25kr6;
        if (i3 <= 0) {
            int i4 = GJee0v.AZOQYO.f3039AcNBzu;
            azoqyo.f3328AcNBzu = aZkASS.f3333A2egSU.getDuration();
            return;
        }
        MediaPlayer mediaPlayer = aZkASS.f3333A2egSU;
        int i5 = 0;
        if (mediaPlayer != null) {
            i = mediaPlayer.getCurrentPosition();
            aZkASS.A4TApA(65542, Integer.valueOf(i));
            if (i > 0) {
                i /= 1000;
            }
        } else {
            i = 0;
        }
        if (azoqyo.f3329AlLFFp != i) {
            azoqyo.f3329AlLFFp = i;
        }
        MediaPlayer mediaPlayer2 = aZkASS.f3333A2egSU;
        if (mediaPlayer2 != null && (currentPosition = mediaPlayer2.getCurrentPosition()) > 0 && (i2 = azoqyo.f3328AcNBzu) > 0) {
            i5 = (int) ((currentPosition / i2) * 100.0d);
        }
        if (azoqyo.f3330AmA8tU != i5) {
            azoqyo.f3330AmA8tU = i5;
            aZkASS.f3334A4TApA.A4TApA(i5);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [H0qugq.AZOQYO, HFjH17.ASJ6gh] */
    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        AZkASS aZkASS = this.f3332B25kr6;
        ADYaiT aDYaiT = aZkASS.f3335A5SV6n;
        if (aDYaiT == null || aDYaiT.f3317BniPrB != 8) {
            aZkASS.f3334A4TApA.ADYaiT();
            ScheduledFuture scheduledFuture = aZkASS.f3337ARc23Z;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            aZkASS.A4TApA(65538, null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [H0qugq.AZOQYO, HFjH17.ASJ6gh] */
    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
        AZkASS aZkASS = this.f3332B25kr6;
        aZkASS.f3334A4TApA.onError(i, i2);
        aZkASS.A4TApA(65545, null);
        ScheduledFuture scheduledFuture = aZkASS.f3337ARc23Z;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture scheduledFuture2 = aZkASS.f3339AYUAbz;
        if (scheduledFuture2 == null) {
            return false;
        }
        scheduledFuture2.cancel(true);
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [H0qugq.AZOQYO, HFjH17.ASJ6gh] */
    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
        this.f3332B25kr6.f3334A4TApA.A5SV6n(i);
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [H0qugq.AZOQYO, HFjH17.ASJ6gh] */
    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        AZkASS aZkASS = this.f3332B25kr6;
        aZkASS.f3334A4TApA.AMqCpz(mediaPlayer);
        aZkASS.A4TApA(65537, aZkASS.f3340AZOQYO);
    }
}
