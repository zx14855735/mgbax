package com.octopus.ad.internal;

import com.octopus.ad.R;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import com.octopus.ad.internal.view.SplashAdViewImpl;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private final com.octopus.ad.internal.a d;
    private s e;

    /* renamed from: a, reason: collision with root package name */
    private int f12426a = -1;
    private long b = -1;
    private long c = -1;
    private a f = a.STOPPED;
    private boolean g = false;

    /* renamed from: com.octopus.ad.internal.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12427a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[p.values().length];
            b = iArr;
            try {
                iArr[p.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[p.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[p.FULLSCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[p.REWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[p.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[p.BANNER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[p.DRAW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[p.PREFETCH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[a.values().length];
            f12427a = iArr2;
            try {
                iArr2[a.STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12427a[a.SINGLE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12427a[a.AUTO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public enum a {
        STOPPED,
        SINGLE_REQUEST,
        AUTO_REFRESH;

        static {
            QIrOCKl();
        }

        private static /* synthetic */ void QIrOCKl() {
            char[] charArray = "3?=~71=5~2?)~#85<<~\u001a>9\u0012\"9475".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'P');
            }
            String str = new String(charArray);
            char[] charArray2 = "3<9>9$".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'P');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public c(com.octopus.ad.internal.a aVar) {
        this.d = aVar;
        com.octopus.ad.utils.b.f.c("OctopusAd_Time", "AdFetcher 开始");
    }

    public void a(int i) {
        boolean z = this.f12426a != i;
        this.f12426a = i;
        if (!z || this.f.equals(a.STOPPED)) {
            return;
        }
        HaoboLog.d(HaoboLog.baseLogTag, "AdFetcher refresh mPeriod changed to " + this.f12426a);
        HaoboLog.d(HaoboLog.baseLogTag, "Resetting AdFetcher");
        a();
        c();
    }

    public void b() {
        this.g = true;
    }

    public void c() {
        HaoboLog.d(HaoboLog.baseLogTag, HaoboLog.getString(R.string.start));
        int i = AnonymousClass1.f12427a[this.f.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fetcher_start_single));
            e();
            return;
        }
        if (this.f12426a <= 0) {
            HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fetcher_start_single));
            e();
            this.f = a.SINGLE_REQUEST;
            return;
        }
        HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fetcher_start_auto));
        int i2 = this.f12426a;
        long j = this.c;
        long j2 = 0;
        if (j != -1) {
            long j3 = this.b;
            if (j3 != -1) {
                long j4 = i2;
                j2 = Math.min(j4, Math.max(0L, j4 - (j - j3)));
            }
        }
        HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.request_delayed_by_x_ms, j2));
        e();
        this.f = a.AUTO_REFRESH;
    }

    public void d() {
        this.b = -1L;
        this.c = -1L;
    }

    public void e() {
        com.octopus.ad.internal.a aVar;
        try {
            if (!this.g && (aVar = this.d) != null && aVar.a()) {
                if (this.b != -1) {
                    HaoboLog.d(HaoboLog.baseLogTag, HaoboLog.getString(R.string.new_ad_since, Math.max(0, (int) (System.currentTimeMillis() - this.b))));
                }
                this.b = System.currentTimeMillis();
                switch (AnonymousClass1.b[this.d.getMediaType().ordinal()]) {
                    case 1:
                        this.e = new f((SplashAdViewImpl) this.d);
                        break;
                    case 2:
                    case 3:
                    case 4:
                        this.e = new f((InterstitialAdViewImpl) this.d);
                        break;
                    case 5:
                    case 6:
                    case 7:
                        this.e = new com.octopus.ad.internal.nativead.b((com.octopus.ad.internal.nativead.a) this.d);
                        break;
                    case 8:
                        this.e = new r();
                        break;
                }
                this.e.a();
            }
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a() {
        s sVar = this.e;
        if (sVar != null) {
            sVar.c();
            this.e = null;
        }
        HaoboLog.d(HaoboLog.baseLogTag, HaoboLog.getString(R.string.stop));
        this.c = System.currentTimeMillis();
        this.f = a.STOPPED;
    }
}
