package HFjH17;

import android.media.MediaPlayer;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public MediaPlayer f3333A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final H0qugq.AZOQYO f3334A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ADYaiT f3335A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AZOQYO f3336ADYaiT;
    public ScheduledExecutorService AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public ScheduledFuture f3337ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public ScheduledExecutorService f3338ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public ScheduledFuture f3339AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public DG07BK.A2egSU f3340AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final A4TApA f3341AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public HandlerThread f3342AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f3343AcNBzu = false;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f3344AlLFFp = new Object();

    /* JADX WARN: Multi-variable type inference failed */
    public AZkASS(ASJ6gh aSJ6gh, ADYaiT aDYaiT, A4TApA a4TApA) {
        this.f3334A4TApA = (H0qugq.AZOQYO) aSJ6gh;
        this.f3335A5SV6n = aDYaiT;
        this.f3341AZkASS = a4TApA;
    }

    public final void A2egSU() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        MediaPlayer mediaPlayer = this.f3333A2egSU;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(null);
        this.f3333A2egSU.setOnCompletionListener(null);
        this.f3333A2egSU.setOnErrorListener(null);
        this.f3333A2egSU.setOnInfoListener(null);
        ScheduledFuture scheduledFuture = this.f3337ARc23Z;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture scheduledFuture2 = this.f3339AYUAbz;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = this.AMqCpz;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            this.AMqCpz = null;
        }
        ScheduledExecutorService scheduledExecutorService2 = this.f3338ASJ6gh;
        if (scheduledExecutorService2 != null) {
            scheduledExecutorService2.shutdown();
            this.f3338ASJ6gh = null;
        }
        if (this.f3340AZOQYO != null) {
            this.f3340AZOQYO = null;
        }
        if (this.f3342AaHO0E != null) {
            this.f3342AaHO0E = null;
            this.f3343AcNBzu = false;
        }
    }

    public final void A4TApA(int i, Object obj) {
        A4TApA a4TApA = this.f3341AZkASS;
        Message obtainMessage = a4TApA.obtainMessage();
        obtainMessage.what = i;
        if (obj != null) {
            obtainMessage.obj = obj;
        }
        a4TApA.sendMessage(obtainMessage);
    }

    public final void A5SV6n() {
        AZOQYO azoqyo;
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        this.f3333A2egSU = this.f3335A5SV6n.AZOQYO();
        this.f3336ADYaiT = new AZOQYO(this);
        this.AMqCpz = Executors.newSingleThreadScheduledExecutor();
        MediaPlayer mediaPlayer = this.f3333A2egSU;
        if (mediaPlayer == null || (azoqyo = this.f3336ADYaiT) == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(azoqyo);
        this.f3333A2egSU.setOnCompletionListener(this.f3336ADYaiT);
        this.f3333A2egSU.setOnErrorListener(this.f3336ADYaiT);
        this.f3333A2egSU.setOnInfoListener(this.f3336ADYaiT);
    }
}
