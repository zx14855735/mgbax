package EY4UKY;

import ADYaiT.CtFAbx;
import FOAO9d.AcNBzu;
import FdMWEC.AZkASS;
import FdMWEC.AaHO0E;
import GJee0v.AZOQYO;
import GJee0v.AmA8tU;
import GYpKKt.ASJ6gh;
import GYpKKt.AYUAbz;
import GnQT2j.AlLFFp;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.BV3sI0;
import androidx.core.content.FileProvider;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.event.AdnTypeEnum;
import com.alliance.ssp.ad.event.CurrencyEnum;
import com.alliance.ssp.ad.event.LoseReasonEnum;
import com.alliance.ssp.ad.template.SAAllianceContainerView;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.bykv.vk.component.ttvideo.player.C;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements DuwtYk.A5SV6n, AlLFFp {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Object f2536AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f2537AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Object f2538AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Object f2539AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Object f2540B25kr6;

    public static String A2egSU(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("cipher") && jSONObject.has("encryptParams")) {
                    return com.bumptech.glide.A5SV6n.AMqCpz(jSONObject.getString("cipher"), jSONObject.getString("encryptParams"));
                }
            } catch (Exception e) {
                ADYaiT("002", e);
            }
        }
        return null;
    }

    public static void ADYaiT(String str, Exception exc) {
        CtFAbx.B4ZgIw(exc, CtFAbx.B3GDIM("SAHttpRequestUtils_", str, " : "), new ADYaiT(), "004", exc);
    }

    public static void ARc23Z() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new AYUAbz()}, new SecureRandom());
            HttpsURLConnection.setDefaultHostnameVerifier(new ASJ6gh());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void A4TApA(int i, Activity activity, ViewGroup viewGroup) {
        int i2 = 1;
        int i3 = 0;
        if (i == 1) {
            AZkASS aZkASS = (AZkASS) this.f2539AzWtSf;
            if (aZkASS != null) {
                aZkASS.f3221CikNvS = "" + viewGroup.getWidth();
                StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz.append(viewGroup.getHeight());
                aZkASS.f3222CkXcdM = AMqCpz.toString();
                int i4 = AZOQYO.f3039AcNBzu;
                aZkASS.f2851HSr46Q = viewGroup;
                Context A4TApA2 = GJee0v.A2egSU.A4TApA(aZkASS.f3185ARc23Z);
                try {
                    SAAllianceContainerView sAAllianceContainerView = new SAAllianceContainerView(A4TApA2, aZkASS.EdQ5bb);
                    viewGroup.addView(sAAllianceContainerView);
                    FrameLayout frameLayout = new FrameLayout(A4TApA2);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    sAAllianceContainerView.addView(frameLayout);
                    aZkASS.f2807EiK8oA = frameLayout;
                    frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new AZkASS.A5SV6n(4, aZkASS));
                } catch (Exception e) {
                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMSplashAdImpl 008: "), new ADYaiT(), "004", e);
                }
                AaHO0E aaHO0E = new AaHO0E(aZkASS, Looper.getMainLooper(), i3);
                aZkASS.f2839GnQT2j = aaHO0E;
                aaHO0E.sendEmptyMessageDelayed(0, 50L);
                int i5 = AZOQYO.f3039AcNBzu;
                aZkASS.ASJ6gh();
                return;
            }
            return;
        }
        if (i == 4) {
            return;
        }
        if (i == 5) {
            FSFw2u.AZkASS aZkASS2 = (FSFw2u.AZkASS) this.f2537AlLFFp;
            if (aZkASS2 != null) {
                aZkASS2.f2691EdhSi6 = activity;
                HH6JFw.A2egSU a2egSU = new HH6JFw.A2egSU(aZkASS2, Looper.getMainLooper(), 2);
                aZkASS2.f2736HSr46Q = a2egSU;
                a2egSU.sendEmptyMessageDelayed(0, 50L);
                int i6 = AZOQYO.f3039AcNBzu;
                aZkASS2.ASJ6gh();
                return;
            }
            return;
        }
        if (i != 6) {
            if (i != 3 || ((AcNBzu) this.f2540B25kr6) == null) {
                return;
            }
            int i7 = AZOQYO.f3039AcNBzu;
            return;
        }
        FZu94u.A4TApA a4TApA = (FZu94u.A4TApA) this.f2538AmA8tU;
        if (a4TApA != null) {
            int i8 = AZOQYO.f3039AcNBzu;
            a4TApA.f2769ExjC7D = activity;
            HHLj6Q.A2egSU a2egSU2 = new HHLj6Q.A2egSU(a4TApA, Looper.getMainLooper(), i2);
            a4TApA.f2772F508T2 = a2egSU2;
            a2egSU2.sendEmptyMessageDelayed(0, 50L);
            a4TApA.ASJ6gh();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void A5SV6n(DuwtYk.AMqCpz aMqCpz, int i, int i2, DuwtYk.A2egSU a2egSU) {
        int i3 = 1;
        boolean z = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        String str = DeviceUtil.f9708A2egSU;
        if (str == null || str.isEmpty()) {
            a2egSU.onError(4097, "请求失败，请检查是否初始化SDK。");
            return;
        }
        String str2 = aMqCpz.f2478A2egSU;
        if (str2 == null || str2.isEmpty()) {
            a2egSU.onError(4098, "请求失败，请检查是否设置代码位ID。");
            return;
        }
        NOd7IU.AlLFFp.f5900BPw6Q8 = aMqCpz.f2484AYUAbz;
        if (i == 1) {
            AZkASS aZkASS = new AZkASS((WeakReference) this.f2536AcNBzu, aMqCpz, (EGM26s.A5SV6n) a2egSU, "1", i2);
            aZkASS.f2806EdhSi6 = null;
            aZkASS.f2812EwN40Z = null;
            aZkASS.f2814F1loUV = null;
            aZkASS.f2815F32kj0 = null;
            aZkASS.f2816F508T2 = null;
            aZkASS.f2817FG7pZc = null;
            aZkASS.f2818FM663C = null;
            aZkASS.f2819FOAO9d = null;
            aZkASS.f2820FSFw2u = null;
            aZkASS.f2822FdMWEC = null;
            aZkASS.f2823Ff5QvW = null;
            aZkASS.f2827Fyurov = "";
            aZkASS.G16Pvp = "";
            aZkASS.f2829GEYgCP = 1;
            aZkASS.f2830GGG1xW = 0;
            aZkASS.f2831GIi2tl = 0L;
            aZkASS.f2832GIl1rw = false;
            aZkASS.f2833GJee0v = false;
            aZkASS.f2834GL2Jh7 = false;
            aZkASS.f2835GTPRn3 = false;
            aZkASS.f2836GYpKKt = false;
            aZkASS.GZqyMh = false;
            aZkASS.f2837GcSJYy = false;
            aZkASS.f2838GhvxjZ = false;
            aZkASS.f2842H1wUHe = 1;
            aZkASS.f2844HFjH17 = false;
            aZkASS.f2845HH6JFw = true;
            aZkASS.f2846HHLj6Q = 0;
            aZkASS.HHoABE = 0;
            aZkASS.f2847HIguqb = 0;
            aZkASS.f2848HMGPfW = 0;
            aZkASS.f2849HPJABZ = 3000;
            aZkASS.f2865IQ76hF = 1;
            aZkASS.f2851HSr46Q = null;
            aZkASS.f2853HZUvgL = null;
            aZkASS.f2854Hdahpu = null;
            aZkASS.f2855HieBYM = false;
            aZkASS.f2857HtmBAy = null;
            aZkASS.f2858HwAeAU = false;
            aZkASS.f2859I3HV03 = false;
            aZkASS.f2860I3bnmY = -1.0f;
            aZkASS.f2861I9dkCd = false;
            aZkASS.f2862IDXjOL = false;
            aZkASS.f2863IJPJ4E = false;
            aZkASS.f2864IOxIEW = 0;
            this.f2539AzWtSf = aZkASS;
            aZkASS.EdQ5bb = aZkASS;
            String str3 = aMqCpz.f2478A2egSU;
            aZkASS.G2rdQT = str3;
            if (ADYaiT.f2522BIYEnU > 4500) {
                aZkASS.f2850HSHyT0 = true;
            }
            if (i2 > 0) {
                aZkASS.f2849HPJABZ = i2;
            }
            System.currentTimeMillis();
            int i4 = AZOQYO.f3039AcNBzu;
            Context A4TApA2 = GJee0v.A2egSU.A4TApA(aZkASS.f3185ARc23Z);
            SAAllianceAdData AcNBzu2 = aZkASS.AcNBzu(A4TApA2, str3);
            aZkASS.f2843H3v3Sq = AcNBzu2;
            if (AcNBzu2 != null) {
                aZkASS.f3207BTvldC.getClass();
                long A5SV6n2 = H0qugq.AcNBzu.A5SV6n(A4TApA2, str3);
                aZkASS.f2843H3v3Sq.getRequestid();
                aZkASS.f2843H3v3Sq.getPriceD();
                AaHO0E aaHO0E = new AaHO0E(aZkASS, Looper.getMainLooper(), i3);
                aZkASS.f2840H0R8Px = aaHO0E;
                aaHO0E.sendEmptyMessageDelayed(0, A5SV6n2);
            }
            aZkASS.f2831GIi2tl = System.currentTimeMillis();
            aMqCpz.f2479A4TApA = DuwtYk.AMqCpz.f2468AZOQYO;
            aMqCpz.f2480A5SV6n = DuwtYk.AMqCpz.f2469AZkASS;
            aZkASS.f2845HH6JFw = true;
            aMqCpz.f2481ADYaiT = 1;
            F32kj0.A5SV6n a5SV6n = new F32kj0.A5SV6n(new K1Z3yj.A2egSU(aZkASS, A4TApA2, 20, z), aZkASS.f2849HPJABZ);
            a5SV6n.AMqCpz = "https://de.ad.gameley.com/delivery/request/getad/adn";
            a5SV6n.f2568ARc23Z = aZkASS.f3200B9tovu;
            a5SV6n.f2569ASJ6gh = 0;
            NOd7IU.AlLFFp.f5904BniPrB = true;
            NOd7IU.AlLFFp.Cd8JRx();
            a5SV6n.f2565A4TApA.putAll(a5SV6n.A4TApA(aMqCpz));
            a5SV6n.AYUAbz(aMqCpz);
            com.bumptech.glide.A5SV6n.AYUAbz(null);
            a5SV6n.A5SV6n();
            aZkASS.f2865IQ76hF = 2;
            return;
        }
        if (i == 4) {
            throw new ClassCastException();
        }
        if (i == 3) {
            new AcNBzu((WeakReference) this.f2536AcNBzu, aMqCpz, (DvK7DB.A5SV6n) a2egSU, this);
            return;
        }
        if (i != 5) {
            if (i != 6) {
                if (i == 2) {
                    throw new ClassCastException();
                }
                return;
            }
            FZu94u.A4TApA a4TApA = new FZu94u.A4TApA((WeakReference) this.f2536AcNBzu, aMqCpz, (ECyGFg.A5SV6n) a2egSU, "6", -1);
            a4TApA.EdQ5bb = "delivery/request/getad/serverReward";
            a4TApA.f2762EdhSi6 = false;
            a4TApA.f2763EiK8oA = false;
            a4TApA.f2764EicXu4 = false;
            a4TApA.f2765EmJGcg = true;
            a4TApA.f2766ErKPGd = 1;
            a4TApA.f2767EsrwYR = false;
            a4TApA.f2768EwN40Z = null;
            a4TApA.f2773FG7pZc = false;
            a4TApA.f2774FM663C = 0;
            a4TApA.f2775FOAO9d = 0;
            a4TApA.f2783Fyurov = false;
            a4TApA.G16Pvp = null;
            a4TApA.G2rdQT = null;
            a4TApA.f2784G58fqA = 0;
            a4TApA.f2785GEYgCP = 0;
            a4TApA.f2788GIl1rw = false;
            a4TApA.f2789GJee0v = false;
            this.f2538AmA8tU = a4TApA;
            String str4 = aMqCpz.f2478A2egSU;
            a4TApA.f2776FSFw2u = str4;
            System.currentTimeMillis();
            int i5 = AZOQYO.f3039AcNBzu;
            Context A4TApA3 = GJee0v.A2egSU.A4TApA(a4TApA.f3185ARc23Z);
            SAAllianceAdData AcNBzu3 = a4TApA.AcNBzu(A4TApA3, str4);
            a4TApA.f2781FmyuN2 = AcNBzu3;
            if (AcNBzu3 != null) {
                a4TApA.f3207BTvldC.getClass();
                long A5SV6n3 = H0qugq.AcNBzu.A5SV6n(A4TApA3, str4);
                a4TApA.f2781FmyuN2.getRequestid();
                a4TApA.f2781FmyuN2.getPriceD();
                HHLj6Q.A2egSU a2egSU2 = new HHLj6Q.A2egSU(a4TApA, Looper.getMainLooper(), objArr2 == true ? 1 : 0);
                a4TApA.f2780Fmmv0E = a2egSU2;
                a2egSU2.sendEmptyMessageDelayed(0, A5SV6n3);
            }
            System.currentTimeMillis();
            SharedPreferences sharedPreferences = AmA8tU.A2egSU().f3053A2egSU;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();
            }
            a4TApA.f3233D9tr6l = "100";
            aMqCpz.f2479A4TApA = DuwtYk.AMqCpz.f2468AZOQYO;
            aMqCpz.f2480A5SV6n = DuwtYk.AMqCpz.f2469AZkASS;
            a4TApA.f2765EmJGcg = true;
            aMqCpz.f2481ADYaiT = 6;
            F32kj0.A5SV6n a5SV6n2 = new F32kj0.A5SV6n(aMqCpz, a4TApA.f3200B9tovu, new K1Z3yj.A2egSU(a4TApA, A4TApA3, 19, objArr == true ? 1 : 0));
            com.bumptech.glide.A5SV6n.AYUAbz(null);
            a5SV6n2.A5SV6n();
            return;
        }
        FSFw2u.AZkASS aZkASS2 = new FSFw2u.AZkASS((WeakReference) this.f2536AcNBzu, aMqCpz, (DyaChj.A5SV6n) a2egSU, "5", -1);
        aZkASS2.f2691EdhSi6 = null;
        aZkASS2.f2693EicXu4 = null;
        aZkASS2.f2697EwN40Z = null;
        aZkASS2.f2698ExjC7D = null;
        aZkASS2.f2699F1loUV = null;
        aZkASS2.f2703FM663C = null;
        aZkASS2.G2rdQT = false;
        aZkASS2.f2713G58fqA = 0;
        aZkASS2.f2714GEYgCP = -1;
        aZkASS2.f2715GGG1xW = null;
        aZkASS2.f2716GIi2tl = null;
        aZkASS2.f2717GIl1rw = null;
        aZkASS2.f2719GL2Jh7 = null;
        aZkASS2.f2721GYpKKt = 1;
        aZkASS2.GZqyMh = "";
        aZkASS2.f2722GcSJYy = "1";
        aZkASS2.f2723GhvxjZ = "";
        aZkASS2.f2725H0R8Px = 0;
        aZkASS2.f2726H0qugq = 0;
        aZkASS2.f2727H1wUHe = 1;
        aZkASS2.f2728H3v3Sq = false;
        aZkASS2.H6qKiO = false;
        aZkASS2.f2729HFjH17 = false;
        aZkASS2.f2730HH6JFw = false;
        aZkASS2.f2731HHLj6Q = 0;
        aZkASS2.f2732HIguqb = 0;
        aZkASS2.f2733HMGPfW = 0;
        aZkASS2.f2734HPJABZ = false;
        aZkASS2.f2735HSHyT0 = false;
        aZkASS2.f2740HieBYM = null;
        aZkASS2.f2743HwAeAU = false;
        aZkASS2.f2744I3HV03 = true;
        aZkASS2.f2746I9dkCd = 0;
        aZkASS2.f2747IDXjOL = 0;
        aZkASS2.f2749IOxIEW = false;
        aZkASS2.f2750IQ76hF = 0;
        aZkASS2.f2751IYh8XG = 32;
        aZkASS2.f2753IhMMDv = false;
        aZkASS2.f2754IlwJBd = false;
        aZkASS2.f2755IsbtnO = false;
        aZkASS2.f2756IssTRV = false;
        this.f2537AlLFFp = aZkASS2;
        aZkASS2.EdQ5bb = aZkASS2;
        String str5 = aMqCpz.f2478A2egSU;
        aZkASS2.HHoABE = str5;
        if (ADYaiT.f2522BIYEnU > 4500) {
            aZkASS2.f2748IJPJ4E = true;
        }
        int i6 = AZOQYO.f3039AcNBzu;
        Context A4TApA4 = GJee0v.A2egSU.A4TApA(aZkASS2.f3185ARc23Z);
        SAAllianceAdData AcNBzu4 = aZkASS2.AcNBzu(A4TApA4, str5);
        aZkASS2.f2741Hjvs0g = AcNBzu4;
        if (AcNBzu4 != null) {
            aZkASS2.f3207BTvldC.getClass();
            long A5SV6n4 = H0qugq.AcNBzu.A5SV6n(A4TApA4, str5);
            HH6JFw.A2egSU a2egSU3 = new HH6JFw.A2egSU(aZkASS2, Looper.getMainLooper(), i3);
            aZkASS2.f2737HXc4pW = a2egSU3;
            a2egSU3.sendEmptyMessageDelayed(0, A5SV6n4);
        }
        System.currentTimeMillis();
        aMqCpz.f2479A4TApA = DuwtYk.AMqCpz.f2468AZOQYO;
        aMqCpz.f2480A5SV6n = DuwtYk.AMqCpz.f2469AZkASS;
        aZkASS2.f2744I3HV03 = true;
        aMqCpz.f2481ADYaiT = 5;
        F32kj0.A5SV6n a5SV6n3 = new F32kj0.A5SV6n(aMqCpz, aZkASS2.f3200B9tovu, new K1Z3yj.A2egSU(aZkASS2, A4TApA4, 17, objArr3 == true ? 1 : 0));
        com.bumptech.glide.A5SV6n.AYUAbz(null);
        a5SV6n3.A5SV6n();
    }

    public void AMqCpz(boolean z, float f, int i, int i2, int i3) {
        try {
            FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) this.f2537AlLFFp;
            if (aZkASS != null) {
                aZkASS.B9tovu(z, f, i, i2, i3);
                return;
            }
            AZkASS aZkASS2 = (AZkASS) this.f2539AzWtSf;
            if (aZkASS2 != null) {
                aZkASS2.B9tovu(z, f, i, i2, i3);
                return;
            }
            FZu94u.A4TApA a4TApA = (FZu94u.A4TApA) this.f2538AmA8tU;
            if (a4TApA != null) {
                a4TApA.B9tovu(z, f, i, i2, i3);
                return;
            }
            AcNBzu acNBzu = (AcNBzu) this.f2540B25kr6;
            if (acNBzu != null) {
                acNBzu.B9tovu(z, f, i, i2, i3);
            }
        } catch (Exception unused) {
        }
    }

    public void ASJ6gh(float f, CurrencyEnum currencyEnum, AdnTypeEnum adnTypeEnum, LoseReasonEnum loseReasonEnum, HashMap hashMap) {
        if (currencyEnum == null) {
            try {
                currencyEnum = CurrencyEnum.CNY;
            } catch (Exception unused) {
                return;
            }
        }
        if (adnTypeEnum == null) {
            adnTypeEnum = AdnTypeEnum.OTHER_ADN;
        }
        if (loseReasonEnum == null) {
            loseReasonEnum = LoseReasonEnum.OTHER;
        }
        AMqCpz(false, f, currencyEnum.ordinal(), adnTypeEnum.ordinal(), loseReasonEnum.ordinal());
    }

    public void AYUAbz(float f, CurrencyEnum currencyEnum, AdnTypeEnum adnTypeEnum) {
        if (currencyEnum == null) {
            try {
                currencyEnum = CurrencyEnum.CNY;
            } catch (Exception unused) {
                return;
            }
        }
        if (adnTypeEnum == null) {
            adnTypeEnum = AdnTypeEnum.OTHER_ADN;
        }
        AMqCpz(true, f, currencyEnum.ordinal(), adnTypeEnum.ordinal(), -1);
    }

    @Override // GnQT2j.AlLFFp
    public void a() {
        NotificationManager notificationManager;
        if (GnQT2j.ARc23Z.f3102AYUAbz || GnQT2j.ARc23Z.f3104AZkASS) {
            GnQT2j.ARc23Z.f3104AZkASS = false;
            return;
        }
        GnQT2j.ARc23Z.f3103AZOQYO = true;
        if (H0qugq.AZOQYO.f3180EY4UKY) {
            H0qugq.AZOQYO.f3180EY4UKY = false;
            return;
        }
        ArrayList arrayList = GnQT2j.ARc23Z.f3097A4TApA;
        String str = (String) this.f2536AcNBzu;
        if (arrayList.contains(str)) {
            arrayList.remove(str);
        }
        G58fqA.A4TApA a4TApA = GnQT2j.ARc23Z.f3100ARc23Z;
        if (a4TApA.AMqCpz && a4TApA.f2982A5SV6n != null && (notificationManager = a4TApA.f2981A4TApA) != null) {
            int i = a4TApA.f2980A2egSU;
            notificationManager.cancel(i);
            BV3sI0 bV3sI0 = a4TApA.f2982A5SV6n;
            bV3sI0.getClass();
            bV3sI0.AMqCpz = BV3sI0.A4TApA("下载完成，点击安装");
            bV3sI0.f8515ARc23Z = BV3sI0.A4TApA(str);
            bV3sI0.f8528B4ZgIw = 0;
            bV3sI0.f8529B7CMnp = 0;
            bV3sI0.f8530B9tovu = false;
            File file = (File) this.f2537AlLFFp;
            if (str != null) {
                BV3sI0 bV3sI02 = a4TApA.f2982A5SV6n;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                intent.addFlags(1);
                StringBuilder sb = new StringBuilder();
                Context context = a4TApA.f2984ARc23Z;
                sb.append(context.getPackageName());
                sb.append(".NMSSPFileProvider");
                intent.setDataAndType(FileProvider.getUriForFile(context, sb.toString(), file), AdBaseConstants.MIME_APK);
                bV3sI02.f8516ASJ6gh = PendingIntent.getActivity(context, 0, intent, 201326592);
            }
            Notification A2egSU2 = a4TApA.f2982A5SV6n.A2egSU();
            A2egSU2.flags &= -3;
            a4TApA.f2981A4TApA.notify(i, A2egSU2);
        }
        ((GnQT2j.AMqCpz) this.f2538AmA8tU).a();
        DeviceUtil.A5SV6n((Context) this.f2540B25kr6, (String) this.f2539AzWtSf, str);
    }

    @Override // GnQT2j.AlLFFp
    public void a(int i, int i2) {
        int i3 = (int) ((i2 * 100.0f) / i);
        if (GnQT2j.ARc23Z.f3096A2egSU == i3) {
            return;
        }
        GnQT2j.ARc23Z.f3096A2egSU = i3;
        if (GnQT2j.ARc23Z.f3097A4TApA.contains((String) this.f2536AcNBzu)) {
            if (i2 >= i) {
                GnQT2j.ARc23Z.f3096A2egSU = 100;
            }
            GnQT2j.ARc23Z.f3100ARc23Z.A2egSU(GnQT2j.ARc23Z.f3096A2egSU, 100, null, CtFAbx.AZkASS("%", GnQT2j.ARc23Z.f3096A2egSU, new StringBuilder()));
        }
    }
}
