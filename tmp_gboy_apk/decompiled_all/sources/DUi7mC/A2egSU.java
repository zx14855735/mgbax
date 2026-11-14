package DUi7mC;

import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.common.saas.bean.AdSource;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2152AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f2153AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f2154AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f2155AzWtSf;

    public /* synthetic */ A2egSU(int i, int i2, Object obj, Object obj2) {
        this.f2152AcNBzu = i2;
        this.f2154AmA8tU = obj;
        this.f2153AlLFFp = i;
        this.f2155AzWtSf = obj2;
    }

    private final void A2egSU() {
        EGM26s.A4TApA a4TApA;
        FdMWEC.AZkASS aZkASS = (FdMWEC.AZkASS) this.f2154AmA8tU;
        int i = this.f2153AlLFFp;
        FdMWEC.ASJ6gh aSJ6gh = (FdMWEC.ASJ6gh) this.f2155AzWtSf;
        aZkASS.getClass();
        synchronized (FdMWEC.AcNBzu.AMqCpz) {
            try {
                try {
                    FdMWEC.AcNBzu acNBzu = aZkASS.f2806EdhSi6;
                    if (acNBzu != null && (a4TApA = acNBzu.f2868A4TApA) != null) {
                        if (i == 0) {
                            a4TApA.onAdSkip();
                        } else if (i == 1) {
                            a4TApA.onAdTimeOver();
                        } else if (i == 2) {
                            a4TApA.onAdShow();
                        } else if (i == 3 && aZkASS.f2848HMGPfW != 1) {
                            a4TApA.onAdClick();
                            aZkASS.DXnQ0V();
                        }
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aSJ6gh != null) {
            aSJ6gh.run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        DyaChj.A4TApA a4TApA;
        switch (this.f2152AcNBzu) {
            case 0:
                ((A4TApA) this.f2154AmA8tU).f2157A4TApA.A5SV6n(this.f2153AlLFFp, (Serializable) this.f2155AzWtSf);
                return;
            case 1:
                FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) this.f2154AmA8tU;
                int i = this.f2153AlLFFp;
                Runnable runnable = (Runnable) this.f2155AzWtSf;
                aZkASS.getClass();
                synchronized (HH6JFw.ADYaiT.AMqCpz) {
                    try {
                        try {
                            HH6JFw.ADYaiT aDYaiT = aZkASS.f2693EicXu4;
                            if (aDYaiT != null && (a4TApA = aDYaiT.f3350A4TApA) != null) {
                                if (i == 0) {
                                    a4TApA.onAdShow();
                                } else if (i != 1) {
                                    if (i == 2) {
                                        a4TApA.onAdDismiss();
                                    } else if (i == 3) {
                                        a4TApA.onAdError(0, null);
                                    } else if (i == 4) {
                                        a4TApA.onSkippedVideo();
                                    }
                                } else if (aZkASS.f2747IDXjOL != 1) {
                                    a4TApA.onAdClick();
                                    aZkASS.DXnQ0V();
                                }
                            }
                        } catch (Exception unused) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 2:
                A2egSU();
                return;
            case 3:
                ((H0qugq.AZOQYO) this.f2154AmA8tU).f3188AZOQYO.onError(this.f2153AlLFFp, (String) this.f2155AzWtSf);
                return;
            case 4:
                ((ReportHelper) this.f2154AmA8tU).lambda$doRequest$0(this.f2153AlLFFp, (AdSource) this.f2155AzWtSf);
                return;
            case 5:
                ((aaaaaaaa) this.f2154AmA8tU).aaaaaaaa(this.f2153AlLFFp, (String) this.f2155AzWtSf);
                return;
            default:
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa) this.f2154AmA8tU).aaaaaaac(this.f2153AlLFFp, (String) this.f2155AzWtSf);
                return;
        }
    }
}
