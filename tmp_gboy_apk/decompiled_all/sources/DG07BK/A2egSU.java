package DG07BK;

import DRlcZ9.B4ZgIw;
import Fyurov.ADYaiT;
import GJee0v.AZkASS;
import HFjH17.ARc23Z;
import HFjH17.AYUAbz;
import HFjH17.AZOQYO;
import IQ76hF.AmA8tU;
import NGepWW.EH1KK8;
import NGepWW.EQurEW;
import NGepWW.EUIRHA;
import NUY5pn.AlLFFp;
import NUY5pn.BJ7GGh;
import QgOIY0.B3GDIM;
import QgOIY0.B7CMnp;
import QgOIY0.BNL6CD;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.preference.PreferenceScreen;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.czhj.sdk.common.Constants;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends Handler {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2058A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f2059A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A2egSU(Looper looper, Object obj, int i) {
        super(looper);
        this.f2058A2egSU = i;
        this.f2059A4TApA = obj;
    }

    private final void A2egSU(Message message) {
        synchronized (((ADYaiT) this.f2059A4TApA).f2910BIYEnU) {
            try {
                int i = message.what;
                if (i == 1) {
                    ADYaiT aDYaiT = (ADYaiT) this.f2059A4TApA;
                    if (aDYaiT.f2893ASJ6gh == 3) {
                        return;
                    }
                    aDYaiT.f2911BJ7GGh = ((Integer) message.obj).intValue();
                    ((ADYaiT) this.f2059A4TApA).getClass();
                    ((ADYaiT) this.f2059A4TApA).f2893ASJ6gh = 2;
                    final int i2 = 1;
                    AZkASS.f3040ADYaiT.f3043A5SV6n.post(new Runnable(this) { // from class: Fyurov.A4TApA

                        /* renamed from: AlLFFp, reason: collision with root package name */
                        public final /* synthetic */ DG07BK.A2egSU f2887AlLFFp;

                        {
                            this.f2887AlLFFp = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i2) {
                                case 0:
                                    ADYaiT aDYaiT2 = (ADYaiT) this.f2887AlLFFp.f2059A4TApA;
                                    aDYaiT2.f2902B25kr6.setText(aDYaiT2.f2891ADYaiT);
                                    aDYaiT2.f2906B7CMnp.setText("继续下载");
                                    aDYaiT2.f2909BI9f7h.setText("继续下载");
                                    break;
                                default:
                                    DG07BK.A2egSU a2egSU = this.f2887AlLFFp;
                                    int i3 = ((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh;
                                    ADYaiT aDYaiT3 = (ADYaiT) a2egSU.f2059A4TApA;
                                    if (i3 != aDYaiT3.f2912BNL6CD) {
                                        aDYaiT3.f2912BNL6CD = aDYaiT3.f2911BJ7GGh;
                                        ADYaiT aDYaiT4 = (ADYaiT) a2egSU.f2059A4TApA;
                                        aDYaiT4.f2901AzWtSf.setProgress(100 - aDYaiT4.f2911BJ7GGh);
                                        ((ADYaiT) a2egSU.f2059A4TApA).f2902B25kr6.setText(((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh + "%");
                                        ADYaiT aDYaiT5 = (ADYaiT) a2egSU.f2059A4TApA;
                                        aDYaiT5.f2905B4ZgIw.setProgress(100 - aDYaiT5.f2911BJ7GGh);
                                        ((ADYaiT) a2egSU.f2059A4TApA).f2906B7CMnp.setText(((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh + "%");
                                        ADYaiT aDYaiT6 = (ADYaiT) a2egSU.f2059A4TApA;
                                        aDYaiT6.f2908BChYOn.setProgress(100 - aDYaiT6.f2911BJ7GGh);
                                        ((ADYaiT) a2egSU.f2059A4TApA).f2909BI9f7h.setText(((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh + "%");
                                        if (((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh == 100 || ((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh == -100) {
                                            ADYaiT aDYaiT7 = (ADYaiT) a2egSU.f2059A4TApA;
                                            aDYaiT7.f2902B25kr6.setText(aDYaiT7.f2889A4TApA);
                                            ((ADYaiT) a2egSU.f2059A4TApA).f2906B7CMnp.setText("立即安装");
                                            ((ADYaiT) a2egSU.f2059A4TApA).f2909BI9f7h.setText("立即安装");
                                            ((ADYaiT) a2egSU.f2059A4TApA).getClass();
                                            ((ADYaiT) a2egSU.f2059A4TApA).f2893ASJ6gh = 4;
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }
                    });
                } else if (i != 2) {
                    if (i == 3) {
                        ADYaiT aDYaiT2 = (ADYaiT) this.f2059A4TApA;
                        if (aDYaiT2.f2893ASJ6gh == 3) {
                            aDYaiT2.f2893ASJ6gh = 2;
                        }
                    }
                } else if (((ADYaiT) this.f2059A4TApA).f2893ASJ6gh == 2) {
                    final int i3 = 0;
                    AZkASS.f3040ADYaiT.f3043A5SV6n.post(new Runnable(this) { // from class: Fyurov.A4TApA

                        /* renamed from: AlLFFp, reason: collision with root package name */
                        public final /* synthetic */ DG07BK.A2egSU f2887AlLFFp;

                        {
                            this.f2887AlLFFp = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i3) {
                                case 0:
                                    ADYaiT aDYaiT22 = (ADYaiT) this.f2887AlLFFp.f2059A4TApA;
                                    aDYaiT22.f2902B25kr6.setText(aDYaiT22.f2891ADYaiT);
                                    aDYaiT22.f2906B7CMnp.setText("继续下载");
                                    aDYaiT22.f2909BI9f7h.setText("继续下载");
                                    break;
                                default:
                                    DG07BK.A2egSU a2egSU = this.f2887AlLFFp;
                                    int i32 = ((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh;
                                    ADYaiT aDYaiT3 = (ADYaiT) a2egSU.f2059A4TApA;
                                    if (i32 != aDYaiT3.f2912BNL6CD) {
                                        aDYaiT3.f2912BNL6CD = aDYaiT3.f2911BJ7GGh;
                                        ADYaiT aDYaiT4 = (ADYaiT) a2egSU.f2059A4TApA;
                                        aDYaiT4.f2901AzWtSf.setProgress(100 - aDYaiT4.f2911BJ7GGh);
                                        ((ADYaiT) a2egSU.f2059A4TApA).f2902B25kr6.setText(((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh + "%");
                                        ADYaiT aDYaiT5 = (ADYaiT) a2egSU.f2059A4TApA;
                                        aDYaiT5.f2905B4ZgIw.setProgress(100 - aDYaiT5.f2911BJ7GGh);
                                        ((ADYaiT) a2egSU.f2059A4TApA).f2906B7CMnp.setText(((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh + "%");
                                        ADYaiT aDYaiT6 = (ADYaiT) a2egSU.f2059A4TApA;
                                        aDYaiT6.f2908BChYOn.setProgress(100 - aDYaiT6.f2911BJ7GGh);
                                        ((ADYaiT) a2egSU.f2059A4TApA).f2909BI9f7h.setText(((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh + "%");
                                        if (((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh == 100 || ((ADYaiT) a2egSU.f2059A4TApA).f2911BJ7GGh == -100) {
                                            ADYaiT aDYaiT7 = (ADYaiT) a2egSU.f2059A4TApA;
                                            aDYaiT7.f2902B25kr6.setText(aDYaiT7.f2889A4TApA);
                                            ((ADYaiT) a2egSU.f2059A4TApA).f2906B7CMnp.setText("立即安装");
                                            ((ADYaiT) a2egSU.f2059A4TApA).f2909BI9f7h.setText("立即安装");
                                            ((ADYaiT) a2egSU.f2059A4TApA).getClass();
                                            ((ADYaiT) a2egSU.f2059A4TApA).f2893ASJ6gh = 4;
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }
                    });
                    ((ADYaiT) this.f2059A4TApA).f2893ASJ6gh = 3;
                }
            } finally {
            }
        }
    }

    private final void A4TApA(Message message) {
        ScheduledExecutorService scheduledExecutorService;
        int i = 0;
        int i2 = 1;
        synchronized (((AZOQYO) this.f2059A4TApA).f3332B25kr6.f3344AlLFFp) {
            try {
                int i3 = message.what;
                int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                if (i3 == 65539) {
                    AZOQYO azoqyo = (AZOQYO) this.f2059A4TApA;
                    azoqyo.f3328AcNBzu = azoqyo.f3332B25kr6.f3333A2egSU.getDuration();
                    HFjH17.AZkASS aZkASS = ((AZOQYO) this.f2059A4TApA).f3332B25kr6;
                    if (aZkASS.AMqCpz == null) {
                        aZkASS.AMqCpz = Executors.newSingleThreadScheduledExecutor();
                    }
                    HFjH17.AZkASS aZkASS2 = ((AZOQYO) this.f2059A4TApA).f3332B25kr6;
                    ScheduledExecutorService scheduledExecutorService2 = aZkASS2.AMqCpz;
                    AYUAbz aYUAbz = new AYUAbz(this, i);
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    aZkASS2.f3337ARc23Z = scheduledExecutorService2.scheduleAtFixedRate(aYUAbz, 0L, 100L, timeUnit);
                    HFjH17.AZkASS aZkASS3 = ((AZOQYO) this.f2059A4TApA).f3332B25kr6;
                    if (aZkASS3.f3338ASJ6gh == null) {
                        aZkASS3.f3338ASJ6gh = Executors.newSingleThreadScheduledExecutor();
                    }
                    HFjH17.AZkASS aZkASS4 = ((AZOQYO) this.f2059A4TApA).f3332B25kr6;
                    aZkASS4.f3339AYUAbz = aZkASS4.f3338ASJ6gh.scheduleAtFixedRate(new AYUAbz(this, i2), 0L, 20L, timeUnit);
                } else if (i3 == 65541) {
                    ScheduledFuture scheduledFuture = ((AZOQYO) this.f2059A4TApA).f3332B25kr6.f3337ARc23Z;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(true);
                    }
                    AZOQYO azoqyo2 = (AZOQYO) this.f2059A4TApA;
                    azoqyo2.f3329AlLFFp = 0;
                    azoqyo2.f3330AmA8tU = 0;
                } else if (i3 == 65544) {
                    HFjH17.AZkASS aZkASS5 = ((AZOQYO) this.f2059A4TApA).f3332B25kr6;
                    if (aZkASS5.f3337ARc23Z != null && (scheduledExecutorService = aZkASS5.AMqCpz) != null) {
                        aZkASS5.f3337ARc23Z = scheduledExecutorService.scheduleAtFixedRate(new AYUAbz(this, 2), 0L, 100L, TimeUnit.MILLISECONDS);
                    }
                }
            } finally {
            }
        }
    }

    private final void A5SV6n(Message message) {
        Boolean bool;
        NOd7IU.A2egSU a2egSU;
        if (((BJ7GGh) this.f2059A4TApA).f5986A5SV6n.get() != message.arg1) {
            int i = message.what;
            if (i == 2 || i == 1 || i == 5) {
                ((AlLFFp) message.obj).A5SV6n();
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 5) && !((BJ7GGh) this.f2059A4TApA).AZkASS()) {
            ((AlLFFp) message.obj).A5SV6n();
            return;
        }
        int i3 = message.what;
        if (i3 == 3) {
            Object obj = message.obj;
            NOd7IU.A2egSU a2egSU2 = new NOd7IU.A2egSU(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            ((BJ7GGh) this.f2059A4TApA).f5985A4TApA.A4TApA(a2egSU2);
            BJ7GGh bJ7GGh = (BJ7GGh) this.f2059A4TApA;
            bJ7GGh.getClass();
            bJ7GGh.f5989ASJ6gh = a2egSU2.f5854AlLFFp;
            bJ7GGh.f5990AYUAbz = System.currentTimeMillis();
            return;
        }
        if (i3 == 4) {
            ((BJ7GGh) this.f2059A4TApA).A4TApA(4, null);
            NGepWW.A2egSU a2egSU3 = ((BJ7GGh) this.f2059A4TApA).f6000B3GDIM;
            if (a2egSU3 != null) {
                ((NSK3xo.AZkASS) a2egSU3.f5658AlLFFp).a(message.arg2);
            }
            BJ7GGh bJ7GGh2 = (BJ7GGh) this.f2059A4TApA;
            bJ7GGh2.f5987ADYaiT = message.arg2;
            bJ7GGh2.AMqCpz = System.currentTimeMillis();
            BJ7GGh.ADYaiT((BJ7GGh) this.f2059A4TApA, 4, 1, null);
            return;
        }
        if (i3 == 2 && !((BJ7GGh) this.f2059A4TApA).AZOQYO()) {
            ((AlLFFp) message.obj).A5SV6n();
            return;
        }
        int i4 = message.what;
        if (i4 != 2 && i4 != 1 && i4 != 5) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i4);
            Log.wtf("GmsClient", sb.toString(), new Exception());
            return;
        }
        AlLFFp alLFFp = (AlLFFp) message.obj;
        synchronized (alLFFp) {
            try {
                bool = alLFFp.f5959A2egSU;
                if (alLFFp.f5960A4TApA) {
                    new StringBuilder(String.valueOf(alLFFp).length() + 47);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            BJ7GGh bJ7GGh3 = alLFFp.f5963ARc23Z;
            int i5 = alLFFp.f5962ADYaiT;
            if (i5 != 0) {
                if (i5 == 10) {
                    bJ7GGh3.A4TApA(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                }
                bJ7GGh3.A4TApA(1, null);
                Bundle bundle = alLFFp.AMqCpz;
                a2egSU = new NOd7IU.A2egSU(i5, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            } else if (!alLFFp.A4TApA()) {
                bJ7GGh3.A4TApA(1, null);
                a2egSU = new NOd7IU.A2egSU(8, null);
            }
            alLFFp.A2egSU(a2egSU);
        }
        synchronized (alLFFp) {
            alLFFp.f5960A4TApA = true;
        }
        alLFFp.A5SV6n();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int size;
        K1Z3yj.A2egSU[] a2egSUArr;
        StringBuilder sb;
        StringBuilder sb2;
        GnQT2j.AlLFFp alLFFp;
        switch (this.f2058A2egSU) {
            case 0:
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                A5SV6n a5SV6n = (A5SV6n) this.f2059A4TApA;
                while (true) {
                    synchronized (a5SV6n.f2067A4TApA) {
                        try {
                            size = a5SV6n.f2069ADYaiT.size();
                            if (size <= 0) {
                                return;
                            }
                            a2egSUArr = new K1Z3yj.A2egSU[size];
                            a5SV6n.f2069ADYaiT.toArray(a2egSUArr);
                            a5SV6n.f2069ADYaiT.clear();
                        } finally {
                        }
                    }
                    for (int i = 0; i < size; i++) {
                        K1Z3yj.A2egSU a2egSU = a2egSUArr[i];
                        int size2 = ((ArrayList) a2egSU.f4175AmA8tU).size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            A4TApA a4TApA = (A4TApA) ((ArrayList) a2egSU.f4175AmA8tU).get(i2);
                            if (!a4TApA.f2063ADYaiT) {
                                a4TApA.f2061A4TApA.onReceive(a5SV6n.f2066A2egSU, (Intent) a2egSU.f4174AlLFFp);
                            }
                        }
                    }
                }
            case 1:
                if (message.what != 1) {
                    return;
                }
                B4ZgIw b4ZgIw = (B4ZgIw) this.f2059A4TApA;
                PreferenceScreen preferenceScreen = b4ZgIw.f2105AlLFFp.f2132ASJ6gh;
                if (preferenceScreen != null) {
                    b4ZgIw.f2106AmA8tU.setAdapter(b4ZgIw.AcNBzu(preferenceScreen));
                    preferenceScreen.AaHO0E();
                    return;
                }
                return;
            case 2:
                super.handleMessage(message);
                int i3 = message.what;
                if (i3 <= 0 || i3 > 100) {
                    return;
                }
                NMRewardVideoActivity nMRewardVideoActivity = (NMRewardVideoActivity) this.f2059A4TApA;
                if (!nMRewardVideoActivity.f9685EwN40Z) {
                    nMRewardVideoActivity.f9661DV2E8K = 1;
                    nMRewardVideoActivity.f9685EwN40Z = true;
                }
                if (i3 == nMRewardVideoActivity.f9686ExjC7D) {
                    return;
                }
                nMRewardVideoActivity.f9686ExjC7D = i3;
                Cd8JRx.ADYaiT aDYaiT = nMRewardVideoActivity.f9679EdhSi6;
                if (aDYaiT != null) {
                    aDYaiT.A2egSU(i3);
                }
                if (i3 == 100) {
                    nMRewardVideoActivity.f9661DV2E8K = 2;
                    FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                    if (a4TApA2 != null) {
                        a4TApA2.C2rE4F();
                        return;
                    }
                    return;
                }
                return;
            case 3:
                A2egSU(message);
                return;
            case 4:
                ARc23Z aRc23Z = (ARc23Z) this.f2059A4TApA;
                super.handleMessage(message);
                try {
                    if (((TextView) aRc23Z.AMqCpz) == null) {
                        int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                        return;
                    }
                    MediaPlayer mediaPlayer = (MediaPlayer) aRc23Z.f3321A5SV6n;
                    if (mediaPlayer == null) {
                        int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                        return;
                    }
                    if (!mediaPlayer.isPlaying()) {
                        ((A2egSU) aRc23Z.f3322ADYaiT).sendEmptyMessageDelayed(0, 1000L);
                        return;
                    }
                    int duration = (int) ((((MediaPlayer) aRc23Z.f3321A5SV6n).getDuration() - ((MediaPlayer) aRc23Z.f3321A5SV6n).getCurrentPosition()) * 0.001d);
                    int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                    if (duration <= 0) {
                        ((TextView) aRc23Z.AMqCpz).setText("00:00");
                        ((A2egSU) aRc23Z.f3322ADYaiT).sendEmptyMessageDelayed(0, 1000L);
                        return;
                    }
                    int i7 = duration / 60;
                    int i8 = duration % 60;
                    if (i7 < 10) {
                        sb = new StringBuilder();
                        sb.append(Constants.FAIL);
                    } else {
                        sb = new StringBuilder();
                        sb.append("");
                    }
                    sb.append(i7);
                    String sb3 = sb.toString();
                    if (i8 < 10) {
                        sb2 = new StringBuilder();
                        sb2.append(Constants.FAIL);
                        sb2.append(i8);
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("");
                        sb4.append(i8);
                        sb2 = sb4;
                    }
                    String sb5 = sb2.toString();
                    ((TextView) aRc23Z.AMqCpz).setText(sb3 + ":" + sb5);
                    ((A2egSU) aRc23Z.f3322ADYaiT).sendEmptyMessageDelayed(0, 1000L);
                    return;
                } catch (Exception e) {
                    e.getMessage();
                    int i9 = GJee0v.AZOQYO.f3039AcNBzu;
                    return;
                }
            case 5:
                int i10 = message.what;
                GnQT2j.AlLFFp alLFFp2 = (GnQT2j.AlLFFp) this.f2059A4TApA;
                if (i10 != 291) {
                    if (i10 == 292 && alLFFp2 != null) {
                        H0qugq.AZOQYO azoqyo = GnQT2j.AZOQYO.f3117AZOQYO.AMqCpz;
                        alLFFp2.a();
                        return;
                    }
                    return;
                }
                if (alLFFp2 != null) {
                    int i11 = message.arg1;
                    int i12 = message.arg2;
                    H0qugq.AZOQYO azoqyo2 = GnQT2j.AZOQYO.f3117AZOQYO.AMqCpz;
                    alLFFp2.a(i11, i12);
                    return;
                }
                return;
            case 6:
                int i13 = message.what;
                GnQT2j.AYUAbz aYUAbz = (GnQT2j.AYUAbz) this.f2059A4TApA;
                if (i13 != 291) {
                    if (i13 == 292 && (alLFFp = aYUAbz.f3111B25kr6) != null) {
                        H0qugq.AZOQYO azoqyo3 = GnQT2j.AZOQYO.f3117AZOQYO.AMqCpz;
                        alLFFp.a();
                        return;
                    }
                    return;
                }
                GnQT2j.AlLFFp alLFFp3 = aYUAbz.f3111B25kr6;
                if (alLFFp3 != null) {
                    int i14 = message.arg1;
                    int i15 = message.arg2;
                    H0qugq.AZOQYO azoqyo4 = GnQT2j.AZOQYO.f3117AZOQYO.AMqCpz;
                    alLFFp3.a(i14, i15);
                    return;
                }
                return;
            case 7:
                A4TApA(message);
                return;
            case 8:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                ((FrameLayout) this.f2059A4TApA).setVisibility(0);
                return;
            case 9:
                int i16 = message.what;
                EH1KK8 eh1kk8 = (EH1KK8) this.f2059A4TApA;
                if (i16 != 1) {
                    if (i16 != 2) {
                        return;
                    }
                    EH1KK8.AZOQYO(eh1kk8);
                    return;
                }
                ReentrantLock reentrantLock = eh1kk8.f5790B9tovu;
                reentrantLock.lock();
                try {
                    if (eh1kk8.AmA8tU()) {
                        eh1kk8.f5791BChYOn.f6010B25kr6 = true;
                        eh1kk8.f5792BI9f7h.a();
                    }
                    return;
                } finally {
                    reentrantLock.unlock();
                }
            case 10:
                int i17 = message.what;
                if (i17 != 1) {
                    if (i17 == 2) {
                        throw ((RuntimeException) message.obj);
                    }
                    return;
                }
                EQurEW eQurEW = (EQurEW) message.obj;
                EUIRHA euirha = (EUIRHA) this.f2059A4TApA;
                eQurEW.getClass();
                euirha.f5811AZOQYO.lock();
                try {
                    if (euirha.f5816AmA8tU == eQurEW.f5803A2egSU) {
                        eQurEW.A2egSU();
                    }
                    return;
                } finally {
                    euirha.f5811AZOQYO.unlock();
                }
            case 11:
                A5SV6n(message);
                return;
            default:
                int i18 = message.what;
                B7CMnp b7CMnp = (B7CMnp) this.f2059A4TApA;
                if (i18 == 1) {
                    if (b7CMnp.f7602B2KMhB) {
                        b7CMnp.A5SV6n(false);
                        return;
                    }
                    return;
                } else {
                    if (i18 != 2) {
                        super.handleMessage(message);
                        return;
                    }
                    AmA8tU amA8tU = b7CMnp.f7599AmA8tU;
                    BNL6CD bnl6cd = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n;
                    bnl6cd.f7623AzWtSf = false;
                    bnl6cd.f7612A5SV6n = true;
                    bnl6cd.A2egSU(5, false);
                    bnl6cd.f7612A5SV6n = false;
                    ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.CNPG0E();
                    return;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A2egSU(Object obj, Looper looper, int i) {
        super(looper);
        this.f2058A2egSU = i;
        this.f2059A4TApA = obj;
    }

    public A2egSU(B7CMnp b7CMnp) {
        this.f2058A2egSU = 12;
        this.f2059A4TApA = b7CMnp;
    }
}
