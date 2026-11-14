package H0qugq;

import ADYaiT.BChYOn;
import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.bean.Ca;
import com.alliance.ssp.ad.bean.Ldpca;
import com.alliance.ssp.ad.bean.Ledowncomptrs;
import com.alliance.ssp.ad.bean.Ledownstarttrs;
import com.alliance.ssp.ad.bean.Ledp;
import com.alliance.ssp.ad.bean.Ledpfailtrs;
import com.alliance.ssp.ad.bean.Lefirstquartile;
import com.alliance.ssp.ad.bean.Leinstallstarttrs;
import com.alliance.ssp.ad.bean.Lemidpoint;
import com.alliance.ssp.ad.bean.Lemute;
import com.alliance.ssp.ad.bean.Lepause;
import com.alliance.ssp.ad.bean.Leready;
import com.alliance.ssp.ad.bean.Leskip;
import com.alliance.ssp.ad.bean.Lethirdquartile;
import com.alliance.ssp.ad.bean.Leunmute;
import com.alliance.ssp.ad.bean.Levideoend;
import com.alliance.ssp.ad.bean.Levideoloaderror;
import com.alliance.ssp.ad.bean.Levideostart;
import com.alliance.ssp.ad.bean.Lurl;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.Monitor;
import com.alliance.ssp.ad.bean.Nurl;
import com.alliance.ssp.ad.bean.Pa;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.manager.ClickCacheManager;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.alliance.ssp.ad.utils.jni_interface;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AZOQYO {

    /* renamed from: EY4UKY, reason: collision with root package name */
    public static boolean f3180EY4UKY;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AtomicInteger f3181A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AtomicInteger f3182A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AtomicInteger f3183A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AtomicInteger f3184ADYaiT;
    public final ArrayList AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public WeakReference f3185ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final DuwtYk.AMqCpz f3186ASJ6gh;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final DuwtYk.A2egSU f3188AZOQYO;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final AZOQYO f3190AaHO0E;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final String f3200B9tovu;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public float f3202BI9f7h;

    /* renamed from: BTvldC, reason: collision with root package name */
    public AcNBzu f3207BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public Fyurov.ADYaiT f3208BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public String f3209BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public String f3210BniPrB;
    public String BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public String f3211C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public String f3212C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public String f3213CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public String f3214CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public String f3215COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public String f3216CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public String f3217CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public String f3218CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public String f3219CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public String f3220Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public String f3221CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public String f3222CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public final String f3223CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public String f3224CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public String f3225CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public String f3226CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public String f3227CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public final String f3228D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public String f3229D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public String f3230D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public String f3231D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public String f3232D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public String f3233D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public String f3234DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public String f3235DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public String f3236DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public String f3237DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public final String f3238DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public boolean f3239DXnQ0V;
    public boolean DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public boolean f3240DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public boolean f3241DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public boolean f3242DdagTj;
    public Handler Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public int f3243De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public int f3244DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public G58fqA.A2egSU f3245Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public boolean f3246DuwtYk;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public String f3247DvK7DB;

    /* renamed from: DyaChj, reason: collision with root package name */
    public boolean f3248DyaChj;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public boolean f3249ECyGFg;

    /* renamed from: EGM26s, reason: collision with root package name */
    public boolean f3250EGM26s;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public GnQT2j.AZOQYO f3251EH1KK8;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public GnQT2j.AZkASS f3252EPdU4G;

    /* renamed from: EQurEW, reason: collision with root package name */
    public String f3253EQurEW;

    /* renamed from: EUIRHA, reason: collision with root package name */
    public boolean f3254EUIRHA;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public SAAllianceAdData f3187AYUAbz = null;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f3189AZkASS = false;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public long f3191AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public long f3192AlLFFp = 0;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public long f3193AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public HFjH17.ADYaiT f3194AzWtSf = null;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f3195B25kr6 = false;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f3196B2KMhB = 0;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public String f3197B3GDIM = "";

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f3198B4ZgIw = false;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Bitmap f3199B7CMnp = null;

    /* renamed from: BChYOn, reason: collision with root package name */
    public String f3201BChYOn = "user";

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f3203BIYEnU = false;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f3204BJ7GGh = false;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int[] f3205BNL6CD = new int[3];

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f3206BPw6Q8 = false;

    public AZOQYO(WeakReference weakReference, DuwtYk.AMqCpz aMqCpz, DuwtYk.A2egSU a2egSU, String str, int i) {
        this.f3181A2egSU = null;
        this.f3182A4TApA = null;
        this.f3183A5SV6n = null;
        this.f3184ADYaiT = null;
        this.AMqCpz = null;
        this.f3185ARc23Z = null;
        this.f3186ASJ6gh = null;
        this.f3188AZOQYO = null;
        this.f3200B9tovu = "";
        String str2 = AcNBzu.f3257A5SV6n;
        this.f3207BTvldC = AaHO0E.f3256A2egSU;
        this.f3209BmvVmW = "";
        this.f3210BniPrB = "";
        this.BpkvW3 = "";
        this.f3211C2rE4F = "";
        this.f3212C4FrIb = "";
        this.f3213CASmeH = "";
        this.f3214CNPG0E = "";
        this.f3215COJEAR = "";
        this.f3216CQhlFr = "";
        this.f3217CSDoyG = "";
        this.f3218CTkVKb = "";
        this.f3219CcAIMM = "";
        this.f3220Cd8JRx = "";
        this.f3221CikNvS = "";
        this.f3222CkXcdM = "";
        this.f3223CmUvjW = "";
        this.f3224CqNSpT = "";
        this.f3225CrfGsy = "";
        this.f3226CtFAbx = "";
        this.f3227CtxOCS = "";
        this.f3228D07BeM = "";
        this.f3229D6DOie = "";
        this.f3230D6yqiO = "";
        this.f3231D8MqeW = "";
        this.f3232D8cQ8b = "";
        this.f3233D9tr6l = "";
        this.f3234DAk1zC = "";
        this.f3235DG07BK = "";
        this.f3236DRlcZ9 = "";
        this.f3237DUi7mC = "";
        this.f3238DV2E8K = "";
        this.f3239DXnQ0V = false;
        this.DXuj49 = false;
        this.f3240DaOi9o = false;
        this.f3241DcUJf1 = false;
        this.f3242DdagTj = false;
        this.Ddcejp = null;
        this.f3243De4eam = 0;
        this.f3244DjONCG = 0;
        this.f3246DuwtYk = false;
        this.f3248DyaChj = false;
        this.f3249ECyGFg = false;
        this.f3250EGM26s = false;
        this.f3251EH1KK8 = null;
        this.f3252EPdU4G = null;
        this.f3253EQurEW = "";
        this.f3254EUIRHA = false;
        this.f3190AaHO0E = this;
        String replace = UUID.randomUUID().toString().replace("-", "");
        this.f3200B9tovu = replace;
        this.f3185ARc23Z = weakReference;
        this.f3186ASJ6gh = aMqCpz;
        this.f3181A2egSU = new AtomicInteger(0);
        this.f3182A4TApA = new AtomicInteger(0);
        this.f3183A5SV6n = new AtomicInteger(0);
        this.f3184ADYaiT = new AtomicInteger(0);
        this.f3188AZOQYO = a2egSU;
        this.AMqCpz = new ArrayList();
        this.f3238DV2E8K = str;
        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz.append(aMqCpz.f2480A5SV6n);
        EY4UKY.ADYaiT.f2529BniPrB = AMqCpz.toString();
        StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz2.append(aMqCpz.f2479A4TApA);
        EY4UKY.ADYaiT.BpkvW3 = AMqCpz2.toString();
        StringBuilder AMqCpz3 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz3.append(1);
        EY4UKY.ADYaiT.f2530C2rE4F = AMqCpz3.toString();
        EY4UKY.ADYaiT.f2531C4FrIb = aMqCpz.f2484AYUAbz;
        new EY4UKY.ADYaiT().AYUAbz(0, 0, null, replace, aMqCpz.f2478A2egSU, str, Constants.FAIL, i, aMqCpz);
    }

    public static Point AaHO0E(FrameLayout frameLayout, float f, float f2) {
        frameLayout.getLocationOnScreen(new int[2]);
        return new Point(Math.round(r0[0] + f), Math.round(r0[1] + f2));
    }

    public static String AlLFFp(String str, String str2, String str3) {
        if (str == null) {
            return "";
        }
        if (str3 == null) {
            str3 = "";
        }
        try {
            return Pattern.compile(str2).matcher(str).replaceAll(str3);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String BNL6CD(String str, String str2, String str3) {
        String[] strArr = {str, str2};
        int i = 0;
        while (true) {
            if (i < 2) {
                String str4 = strArr[i];
                if (str4 == null || str4.isEmpty()) {
                    break;
                }
                i++;
            } else if (str.contains(str2)) {
                try {
                    Matcher matcher = Pattern.compile("#" + Pattern.quote(str2) + ":(.*?)#").matcher(str);
                    if (str3 != null && !str3.isEmpty()) {
                        return matcher.replaceAll(str3);
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        Objects.requireNonNull(group);
                        matcher.appendReplacement(stringBuffer, group);
                    }
                    matcher.appendTail(stringBuffer);
                    return stringBuffer.toString();
                } catch (Exception e) {
                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 041: "), new EY4UKY.ADYaiT(), "004", e);
                    return str;
                }
            }
        }
        return str;
    }

    public final void ARc23Z() {
        new EY4UKY.ADYaiT().B3GDIM(0, 0, this.f3187AYUAbz, this.f3200B9tovu, "");
    }

    public final void ASJ6gh() {
        this.f3192AlLFFp = System.currentTimeMillis();
        if (this.f3240DaOi9o) {
            return;
        }
        this.f3240DaOi9o = true;
        new EY4UKY.ADYaiT().AaHO0E(0, this.f3187AYUAbz, this.f3200B9tovu);
    }

    public final void AYUAbz() {
        new EY4UKY.ADYaiT().AaHO0E(1, this.f3187AYUAbz, this.f3200B9tovu);
    }

    public final void AZOQYO() {
        new EY4UKY.ADYaiT().B3GDIM(5, 0, this.f3187AYUAbz, this.f3200B9tovu, "");
        try {
            if (this.Ddcejp != null) {
                GnQT2j.AZOQYO azoqyo = this.f3251EH1KK8;
                if (azoqyo != null) {
                    azoqyo.A5SV6n(this.f3252EPdU4G.f3125A4TApA, GnQT2j.AZOQYO.f3116AYUAbz);
                    return;
                }
                return;
            }
            GnQT2j.AZOQYO azoqyo2 = (GnQT2j.AZOQYO) GnQT2j.ARc23Z.f3099ADYaiT.get(this.f3187AYUAbz.getMaterial().getDeeplink());
            GnQT2j.AZkASS aZkASS = (GnQT2j.AZkASS) GnQT2j.ARc23Z.AMqCpz.get(this.f3187AYUAbz.getMaterial().getDeeplink());
            if (azoqyo2 == null || aZkASS == null) {
                return;
            }
            azoqyo2.A5SV6n(aZkASS.f3125A4TApA, GnQT2j.AZOQYO.f3116AYUAbz);
        } catch (Exception e) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 014: restart download tas error", e);
        }
    }

    public final void AZkASS() {
        new EY4UKY.ADYaiT().B3GDIM(5, 1, this.f3187AYUAbz, this.f3200B9tovu, "");
        f3180EY4UKY = true;
        try {
            if (this.Ddcejp != null) {
                GnQT2j.AZOQYO azoqyo = this.f3251EH1KK8;
                if (azoqyo != null) {
                    azoqyo.A4TApA(this.f3252EPdU4G.f3125A4TApA);
                    return;
                }
                return;
            }
            GnQT2j.AZOQYO azoqyo2 = (GnQT2j.AZOQYO) GnQT2j.ARc23Z.f3099ADYaiT.get(this.f3187AYUAbz.getMaterial().getDeeplink());
            GnQT2j.AZkASS aZkASS = (GnQT2j.AZkASS) GnQT2j.ARc23Z.AMqCpz.get(this.f3187AYUAbz.getMaterial().getDeeplink());
            if (azoqyo2 == null || aZkASS == null) {
                return;
            }
            azoqyo2.A4TApA(aZkASS.f3125A4TApA);
        } catch (Exception e) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 014: pause download tas error", e);
        }
    }

    public final SAAllianceAdData AcNBzu(Context context, String str) {
        SAAllianceAdData AlLFFp2;
        if (str == null || str.isEmpty()) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return null;
        }
        try {
            String str2 = AcNBzu.f3257A5SV6n;
            AcNBzu acNBzu = AaHO0E.f3256A2egSU;
            this.f3207BTvldC = acNBzu;
            if (context != null && (AlLFFp2 = acNBzu.AlLFFp(context, str)) != null) {
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                return AlLFFp2;
            }
        } catch (Exception e) {
            e.getMessage();
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
        }
        return null;
    }

    public final void AmA8tU(int i, String str, String str2) {
        if (this.f3188AZOQYO != null) {
            GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new DUi7mC.A2egSU(i, 3, this, str2));
        }
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        String str3 = this.f3200B9tovu;
        String str4 = this.f3186ASJ6gh.f2478A2egSU;
        String str5 = this.f3238DV2E8K;
        aDYaiT.ARc23Z(1, 2, null, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() - EY4UKY.ADYaiT.f2509AaHO0E));
        try {
            if (aDYaiT.f2535A4TApA == null) {
                aDYaiT.f2535A4TApA = new JSONObject();
            }
            aDYaiT.f2535A4TApA.put("stage", 6);
            aDYaiT.f2535A4TApA.put("sdkecode", "" + i);
            aDYaiT.f2535A4TApA.put("errmsg", "" + i + "-" + str + "-" + str2);
            aDYaiT.f2534A2egSU.put("crequestid", str3);
            aDYaiT.f2534A2egSU.put("sposid", str4);
            aDYaiT.f2534A2egSU.put("spostype", str5);
            JSONObject jSONObject = new JSONObject();
            EY4UKY.ADYaiT.B2KMhB(jSONObject, str3);
            aDYaiT.f2534A2egSU.put(n.m, jSONObject.toString());
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 003: "), new EY4UKY.ADYaiT(), "004", e);
        }
        try {
            aDYaiT.ADYaiT();
        } catch (Exception e2) {
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 004: "), new EY4UKY.ADYaiT(), "004", e2);
        }
    }

    public final void AzWtSf(DuwtYk.A4TApA a4TApA) {
        int i = 0;
        if (this.f3184ADYaiT == null) {
            this.f3184ADYaiT = new AtomicInteger(0);
        }
        this.f3184ADYaiT.incrementAndGet();
        AtomicInteger atomicInteger = this.f3184ADYaiT;
        if (atomicInteger != null) {
            atomicInteger.get();
        }
        AtomicInteger atomicInteger2 = this.f3183A5SV6n;
        if (atomicInteger2 != null) {
            atomicInteger2.get();
        }
        AtomicInteger atomicInteger3 = this.f3182A4TApA;
        if (atomicInteger3 != null) {
            atomicInteger3.get();
        }
        AtomicInteger atomicInteger4 = this.f3181A2egSU;
        if (atomicInteger4 != null) {
            atomicInteger4.get();
        }
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        SAAllianceAdData sAAllianceAdData = this.f3187AYUAbz;
        if (sAAllianceAdData != null && sAAllianceAdData.getInteraction() != null) {
            if (this.f3187AYUAbz.getInteraction().getAuto() != null && this.f3187AYUAbz.getInteraction().getAuto().clickCountdownTime != null) {
                this.f3202BI9f7h = this.f3187AYUAbz.getInteraction().getAuto().clickCountdownTime.floatValue();
            }
            float f = this.f3202BI9f7h;
            Objects.toString(f == 0.0f ? "null" : Float.valueOf(f));
        }
        ArrayList arrayList = this.AMqCpz;
        if (a4TApA != null) {
            arrayList.add(a4TApA);
        }
        if (this.f3184ADYaiT.get() >= atomicInteger4.get()) {
            DuwtYk.A2egSU a2egSU = this.f3188AZOQYO;
            if (arrayList == null || arrayList.isEmpty()) {
                if (a2egSU != null) {
                    GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A2egSU(this, 4));
                }
            } else {
                if (a2egSU == null) {
                    return;
                }
                if (a2egSU instanceof EGM26s.A5SV6n) {
                    GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A2egSU(this, i));
                } else if (a2egSU instanceof DvK7DB.A5SV6n) {
                    GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A2egSU(this, 1));
                } else if (a2egSU instanceof ECyGFg.A5SV6n) {
                    GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A2egSU(this, 2));
                } else if (a2egSU instanceof DyaChj.A5SV6n) {
                    GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A2egSU(this, 3));
                }
            }
        }
        new EY4UKY.ADYaiT().AYUAbz(1, 0, this.f3187AYUAbz, this.f3200B9tovu, this.f3186ASJ6gh.f2478A2egSU, "", "", -1, null);
    }

    public final void B25kr6(Context context, Material material, SAAllianceAdData sAAllianceAdData, Handler handler) {
        String str;
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        try {
            str = context.getExternalCacheDir() + "/nmssp_download/";
            material.getApkname();
            Toast.makeText(context, "正在下载app", 1).show();
        } catch (Exception e) {
            e = e;
        }
        try {
            if (handler != null) {
                String deeplink = material.getDeeplink();
                if (deeplink != null) {
                    this.f3196B2KMhB = 1;
                    String A5SV6n2 = JrXYwF.A4TApA.A5SV6n(deeplink);
                    C4FrIb(sAAllianceAdData);
                    this.f3253EQurEW = A5SV6n2;
                    GnQT2j.A2egSU a2egSU = new GnQT2j.A2egSU(context);
                    AZOQYO azoqyo = this.f3190AaHO0E;
                    DUi7mC dUi7mC = new DUi7mC(this, handler, sAAllianceAdData, 8, false);
                    GnQT2j.AZOQYO azoqyo2 = GnQT2j.AZOQYO.f3117AZOQYO;
                    if (azoqyo2 == null && azoqyo2 == null) {
                        GnQT2j.AZOQYO.f3117AZOQYO = new GnQT2j.AZOQYO(a2egSU, dUi7mC);
                    }
                    GnQT2j.AZOQYO azoqyo3 = GnQT2j.AZOQYO.f3117AZOQYO;
                    azoqyo3.AMqCpz = azoqyo;
                    azoqyo3.f3120A5SV6n = dUi7mC;
                    this.f3251EH1KK8 = azoqyo3;
                    GnQT2j.AZkASS aZkASS = new GnQT2j.AZkASS(A5SV6n2, deeplink);
                    this.f3252EPdU4G = aZkASS;
                    azoqyo3.A2egSU(aZkASS);
                    GnQT2j.AZOQYO.f3116AYUAbz = str;
                    this.f3251EH1KK8.A5SV6n(this.f3252EPdU4G.f3125A4TApA, str);
                }
            } else {
                String deeplink2 = material.getDeeplink();
                K1Z3yj.A2egSU a2egSU2 = new K1Z3yj.A2egSU(this, sAAllianceAdData, 24, false);
                int i2 = GnQT2j.ARc23Z.f3096A2egSU;
                if (deeplink2 != null && !TextUtils.isEmpty(deeplink2)) {
                    new GnQT2j.ADYaiT(deeplink2, context, a2egSU2).start();
                }
            }
            D8MqeW();
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            exc.getMessage();
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
            CtFAbx.B4ZgIw(exc, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 011: "), new EY4UKY.ADYaiT(), "004", exc);
        }
    }

    public final void B2KMhB(View view, String str) {
        if (view == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int random = ((int) (Math.random() * width)) + i2;
        int random2 = ((int) (Math.random() * height)) + i3;
        if (this.f3225CrfGsy.isEmpty()) {
            this.f3225CrfGsy = Constants.FAIL;
        }
        if (this.f3226CtFAbx.isEmpty()) {
            this.f3226CtFAbx = Constants.FAIL;
        }
        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz.append(random - Integer.parseInt(this.f3225CrfGsy));
        this.f3217CSDoyG = AMqCpz.toString();
        StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz2.append(random2 - Integer.parseInt(this.f3226CtFAbx));
        this.f3218CTkVKb = AMqCpz2.toString();
        StringBuilder AMqCpz3 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz3.append(random - Integer.parseInt(this.f3225CrfGsy));
        this.f3219CcAIMM = AMqCpz3.toString();
        StringBuilder AMqCpz4 = JrXYwF.A4TApA.AMqCpz("");
        AMqCpz4.append(random2 - Integer.parseInt(this.f3226CtFAbx));
        this.f3220Cd8JRx = AMqCpz4.toString();
        this.f3212C4FrIb = AlLFFp.ASJ6gh(random, "");
        this.f3213CASmeH = AlLFFp.ASJ6gh(random2, "");
        this.f3214CNPG0E = AlLFFp.ASJ6gh(random, "");
        this.f3215COJEAR = AlLFFp.ASJ6gh(random2, "");
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f3224CqNSpT = str;
    }

    public final void B3GDIM(SAAllianceAdData sAAllianceAdData) {
        Material material;
        Context A4TApA2 = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z);
        if (A4TApA2 == null || sAAllianceAdData == null || (material = sAAllianceAdData.getMaterial()) == null) {
            return;
        }
        String ldp = material.getLdp();
        if (TextUtils.isEmpty(ldp)) {
            return;
        }
        if (ldp.endsWith(".apk")) {
            BI9f7h(material.getLdp(), sAAllianceAdData);
            return;
        }
        if (ldp.contains("http://") || ldp.contains("https://")) {
            if (sAAllianceAdData.getInteraction() == null) {
                sAAllianceAdData.setInteraction(this.f3187AYUAbz.getInteraction());
            }
            if ((sAAllianceAdData.getTagName() == null || sAAllianceAdData.getTagName().isEmpty()) && this.f3187AYUAbz.getTagName() != null && !this.f3187AYUAbz.getTagName().isEmpty()) {
                sAAllianceAdData.setTagName(this.f3187AYUAbz.getTagName());
            }
            if ((sAAllianceAdData.getTagVer() == null || sAAllianceAdData.getTagVer().isEmpty()) && this.f3187AYUAbz.getTagVer() != null && !this.f3187AYUAbz.getTagVer().isEmpty()) {
                sAAllianceAdData.setTagVer(this.f3187AYUAbz.getTagVer());
            }
            if ((sAAllianceAdData.getTagCode() == null || sAAllianceAdData.getTagCode().isEmpty()) && this.f3187AYUAbz.getTagCode() != null && !this.f3187AYUAbz.getTagCode().isEmpty()) {
                sAAllianceAdData.setTagCode(this.f3187AYUAbz.getTagCode());
            }
            sAAllianceAdData.setSpostype(this.f3187AYUAbz.getSpostype());
            Intent intent = new Intent(A4TApA2, (Class<?>) SAAllianceWebViewActivity.class);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            sAAllianceAdData.setCrequestid(this.f3200B9tovu);
            intent.putExtra("extra_name_land_page_ad_data", sAAllianceAdData.copy());
            A4TApA2.startActivity(intent);
            new EY4UKY.ADYaiT().B3GDIM(2, 0, this.f3187AYUAbz, this.f3200B9tovu, "");
            Objects.toString(this.f3187AYUAbz);
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            Monitor monitor = sAAllianceAdData.getMonitor();
            Objects.toString(monitor);
            if (monitor == null) {
                return;
            }
            List<Ldpca> ldpca = monitor.getLdpca();
            if (ldpca == null) {
                CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Ldpca is null, The old version will be incompatible ", null);
                return;
            }
            if (ldpca.isEmpty()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<Ldpca> it = ldpca.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    this.BpkvW3 = String.valueOf(currentTimeMillis);
                    this.f3227CtxOCS = String.valueOf((int) (currentTimeMillis / 1000));
                    if (url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                        url = BNL6CD(BNL6CD(url, "__SDKID__", ""), "__NTAGID__", "");
                    }
                    String str = url;
                    if (str.contains("__LEMON__PRICE__") && sAAllianceAdData.getPrice() != null) {
                        try {
                            String AZOQYO2 = com.bumptech.glide.AMqCpz.AZOQYO(sAAllianceAdData.getPrice());
                            if (AZOQYO2 != null) {
                                str = BNL6CD(str, "__LEMON__PRICE__", AZOQYO2);
                            }
                        } catch (Exception e) {
                            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 004: "), new EY4UKY.ADYaiT(), "004", e);
                        }
                    }
                    B7CMnp(BJ7GGh(str), "LDPCA", false);
                }
            }
        }
    }

    public final void B4ZgIw(String str, String str2, String str3) {
        this.f3239DXnQ0V = true;
        if (this.f3188AZOQYO != null) {
            GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new BChYOn(this, 9, str));
        }
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        SAAllianceAdData sAAllianceAdData = this.f3187AYUAbz;
        String str4 = this.f3200B9tovu;
        aDYaiT.ARc23Z(3, 2, sAAllianceAdData, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() - EY4UKY.ADYaiT.f2511AlLFFp));
        try {
            if (aDYaiT.f2535A4TApA == null) {
                aDYaiT.f2535A4TApA = new JSONObject();
            }
            aDYaiT.f2535A4TApA.put("stage", 7);
            aDYaiT.f2535A4TApA.put("sdkecode", "100006");
            aDYaiT.f2535A4TApA.put("errmsg", "100006-" + str2 + "-" + str3);
            aDYaiT.f2534A2egSU.put("crequestid", str4);
            JSONObject jSONObject = new JSONObject();
            if (sAAllianceAdData != null) {
                aDYaiT.f2534A2egSU.put("sposprice", sAAllianceAdData.getAdtype());
                aDYaiT.f2534A2egSU.put("adtesting", sAAllianceAdData.getIstesting());
                aDYaiT.f2534A2egSU.put("payload", sAAllianceAdData.getPayload());
                aDYaiT.f2534A2egSU.put("sposid", sAAllianceAdData.getSposid());
                aDYaiT.f2534A2egSU.put("spostype", Integer.valueOf(sAAllianceAdData.getSpostype()));
                Material material = sAAllianceAdData.getMaterial();
                aDYaiT.f2534A2egSU.put("restype", Integer.valueOf(sAAllianceAdData.getRestype()));
                aDYaiT.f2534A2egSU.put("aecpm", EY4UKY.ADYaiT.A5SV6n(sAAllianceAdData.getPrice()));
                aDYaiT.f2534A2egSU.put("ldptype", Integer.valueOf(material.getLdptype()));
                aDYaiT.f2534A2egSU.put("deeplink", material.getDeeplink());
                aDYaiT.f2534A2egSU.put("desc", material.getDesc());
                aDYaiT.f2534A2egSU.put("ldp", material.getLdp());
                String videourl = material.getVideourl();
                List<String> imgurl = material.getImgurl();
                if (videourl == null || TextUtils.isEmpty(videourl)) {
                    aDYaiT.f2534A2egSU.put("murl", (imgurl == null || imgurl.isEmpty()) ? "" : imgurl.get(0));
                } else {
                    aDYaiT.f2534A2egSU.put("murl", videourl);
                }
                aDYaiT.f2534A2egSU.put("tempid", material.getTempid() != null ? material.getTempid() : "");
                aDYaiT.f2534A2egSU.put("loadtype", Integer.valueOf(sAAllianceAdData.getLoadtype()));
                EY4UKY.ADYaiT.B25kr6(jSONObject, sAAllianceAdData);
            }
            EY4UKY.ADYaiT.B2KMhB(jSONObject, str4);
            aDYaiT.f2534A2egSU.put(n.m, jSONObject.toString());
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 009: "), new EY4UKY.ADYaiT(), "004", e);
        }
        try {
            aDYaiT.ADYaiT();
        } catch (Exception e2) {
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceAdConsoleMessageManager 010: "), new EY4UKY.ADYaiT(), "004", e2);
        }
    }

    public final void B7CMnp(String str, String str2, boolean z) {
        F32kj0.A4TApA a4TApA = new F32kj0.A4TApA(new DUi7mC(this, str2, str, 7, false));
        a4TApA.f2565A4TApA = new HashMap();
        a4TApA.f2566A5SV6n = z;
        a4TApA.f2567ADYaiT = 2;
        a4TApA.AMqCpz = str;
        a4TApA.A5SV6n();
    }

    public final void B9tovu(boolean z, float f, int i, int i2, int i3) {
        int i4;
        try {
            if (z) {
                D8cQ8b(this.f3187AYUAbz);
                i4 = 1;
            } else {
                D6yqiO(this.f3187AYUAbz);
                i4 = 2;
            }
            new EY4UKY.ADYaiT().AcNBzu(i4, this.f3187AYUAbz, this.f3200B9tovu, f, i, i2, i3);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f6, code lost:
    
        if (android.text.TextUtils.isEmpty(r11.getLdp()) != false) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean BChYOn(final com.alliance.ssp.ad.bean.Material r11, com.alliance.ssp.ad.bean.SAAllianceAdData r12, boolean r13, final FdMWEC.AYUAbz r14) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H0qugq.AZOQYO.BChYOn(com.alliance.ssp.ad.bean.Material, com.alliance.ssp.ad.bean.SAAllianceAdData, boolean, FdMWEC.AYUAbz):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean BI9f7h(java.lang.String r13, com.alliance.ssp.ad.bean.SAAllianceAdData r14) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H0qugq.AZOQYO.BI9f7h(java.lang.String, com.alliance.ssp.ad.bean.SAAllianceAdData):boolean");
    }

    public final void BIYEnU(SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (monitor == null) {
            return;
        }
        if (sAAllianceAdData.getInteraction() != null && sAAllianceAdData.getInteraction().getClick() != null) {
            this.f3243De4eam = sAAllianceAdData.getInteraction().getClick().clickTimes;
        }
        int i2 = this.f3243De4eam;
        if (i2 == 0 || this.f3244DjONCG < i2) {
            if (i2 > 0) {
                this.f3244DjONCG++;
            }
            Objects.toString(this.f3187AYUAbz);
            List<Ca> ca = monitor.getCa();
            if (ca == null || ca.isEmpty()) {
                CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Ca is null, The old version will be incompatible ", null);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (Ca ca2 : ca) {
                String url = ca2.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    this.BpkvW3 = String.valueOf(currentTimeMillis);
                    this.f3227CtxOCS = String.valueOf((int) (currentTimeMillis / 1000));
                    this.f3216CQhlFr = this.BpkvW3;
                    if (TextUtils.isEmpty(ca2.getSdkid()) && url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                        url = BNL6CD(BNL6CD(url, "__SDKID__", ""), "__NTAGID__", "");
                    }
                    B7CMnp(BJ7GGh(url), "CA", this.f3201BChYOn.equals("shake"));
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(41:0|1|(1:3)(2:195|(4:197|(3:201|202|200)|199|200))|4|(1:6)|7|(23:9|10|11|12|13|14|15|16|17|18|19|20|21|22|(1:24)(3:176|(3:177|178|(2:180|181)(1:182))|183)|25|(1:27)|28|29|30|31|32|33)(1:194)|34|(1:38)|39|(3:40|41|(1:167)(2:45|46))|(8:47|48|(1:162)(2:52|53)|54|55|(1:158)(2:59|60)|61|62)|(27:66|67|68|69|(2:71|72)(1:150)|73|74|(19:76|77|(1:79)(4:137|(1:139)(1:144)|140|(1:142)(1:143))|80|81|82|(2:84|85)(1:134)|86|87|(2:89|90)(1:129)|91|92|(2:94|95)(1:125)|96|97|(3:99|100|(1:118)(6:104|105|(2:108|106)|109|110|112))|121|100|(2:102|118)(1:119))|146|77|(0)(0)|80|81|82|(0)(0)|86|87|(0)(0)|91|92|(0)(0)|96|97|(0)|121|100|(0)(0))|154|67|68|69|(0)(0)|73|74|(0)|146|77|(0)(0)|80|81|82|(0)(0)|86|87|(0)(0)|91|92|(0)(0)|96|97|(0)|121|100|(0)(0)|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(43:0|1|(1:3)(2:195|(4:197|(3:201|202|200)|199|200))|4|(1:6)|7|(23:9|10|11|12|13|14|15|16|17|18|19|20|21|22|(1:24)(3:176|(3:177|178|(2:180|181)(1:182))|183)|25|(1:27)|28|29|30|31|32|33)(1:194)|34|(1:38)|39|40|41|(1:167)(2:45|46)|(8:47|48|(1:162)(2:52|53)|54|55|(1:158)(2:59|60)|61|62)|(27:66|67|68|69|(2:71|72)(1:150)|73|74|(19:76|77|(1:79)(4:137|(1:139)(1:144)|140|(1:142)(1:143))|80|81|82|(2:84|85)(1:134)|86|87|(2:89|90)(1:129)|91|92|(2:94|95)(1:125)|96|97|(3:99|100|(1:118)(6:104|105|(2:108|106)|109|110|112))|121|100|(2:102|118)(1:119))|146|77|(0)(0)|80|81|82|(0)(0)|86|87|(0)(0)|91|92|(0)(0)|96|97|(0)|121|100|(0)(0))|154|67|68|69|(0)(0)|73|74|(0)|146|77|(0)(0)|80|81|82|(0)(0)|86|87|(0)(0)|91|92|(0)(0)|96|97|(0)|121|100|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x055d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0561, code lost:
    
        ADYaiT.CtFAbx.B4ZgIw(r0, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 044: "), new EY4UKY.ADYaiT(), "004", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0542, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0543, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0526, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0527, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x050b, code lost:
    
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0508, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0509, code lost:
    
        r4 = "";
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0413, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0417, code lost:
    
        ADYaiT.CtFAbx.B4ZgIw(r0, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 043: "), new EY4UKY.ADYaiT(), "004", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03f8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03f9, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02bc A[Catch: Exception -> 0x02d7, TryCatch #5 {Exception -> 0x02d7, blocks: (B:41:0x02b4, B:43:0x02bc, B:45:0x02c4), top: B:40:0x02b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02e6 A[Catch: Exception -> 0x0301, TryCatch #17 {Exception -> 0x0301, blocks: (B:48:0x02de, B:50:0x02e6, B:52:0x02ee), top: B:47:0x02de }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x030d A[Catch: Exception -> 0x0328, TryCatch #11 {Exception -> 0x0328, blocks: (B:55:0x0305, B:57:0x030d, B:59:0x0315), top: B:54:0x0305 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0334 A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:62:0x032c, B:64:0x0334, B:66:0x033c), top: B:61:0x032c }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x03e8 A[Catch: Exception -> 0x03f8, TRY_LEAVE, TryCatch #3 {Exception -> 0x03f8, blocks: (B:69:0x03e0, B:71:0x03e8), top: B:68:0x03e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0404 A[Catch: Exception -> 0x0413, TRY_LEAVE, TryCatch #7 {Exception -> 0x0413, blocks: (B:74:0x03fc, B:76:0x0404), top: B:73:0x03fc }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x04f8 A[Catch: Exception -> 0x0508, TRY_LEAVE, TryCatch #10 {Exception -> 0x0508, blocks: (B:82:0x04f0, B:84:0x04f8), top: B:81:0x04f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0516 A[Catch: Exception -> 0x0526, TRY_LEAVE, TryCatch #13 {Exception -> 0x0526, blocks: (B:87:0x050e, B:89:0x0516), top: B:86:0x050e }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0532 A[Catch: Exception -> 0x0542, TRY_LEAVE, TryCatch #16 {Exception -> 0x0542, blocks: (B:92:0x052a, B:94:0x0532), top: B:91:0x052a }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x054e A[Catch: Exception -> 0x055d, TRY_LEAVE, TryCatch #8 {Exception -> 0x055d, blocks: (B:97:0x0546, B:99:0x054e), top: B:96:0x0546 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String BJ7GGh(java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 1552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H0qugq.AZOQYO.BJ7GGh(java.lang.String):java.lang.String");
    }

    public final void BPw6Q8(SAAllianceAdData sAAllianceAdData) {
        new EY4UKY.ADYaiT().B3GDIM(4, 0, this.f3187AYUAbz, this.f3200B9tovu, "");
        if (this.f3249ECyGFg) {
            return;
        }
        this.f3249ECyGFg = true;
        if (sAAllianceAdData == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Levideostart> levideostart = monitor.getAdvml().getLevideostart();
        if (levideostart != null && !levideostart.isEmpty()) {
            Iterator<Levideostart> it = levideostart.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_VIDEO_START", false);
                }
            }
        }
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void BTvldC(String str, String str2) {
        if (this.DXuj49) {
            return;
        }
        this.DXuj49 = true;
        new EY4UKY.ADYaiT().AlLFFp(this.f3187AYUAbz, this.f3200B9tovu, str, str2);
    }

    public final void BV3sI0() {
        Context A4TApA2 = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z);
        if (A4TApA2 == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String sposid = this.f3187AYUAbz.getSposid();
        List<Long> clickCacheTimes = ClickCacheManager.getClickCacheTimes(A4TApA2, sposid);
        clickCacheTimes.add(Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = A4TApA2.getSharedPreferences("click_cache_pref", 0);
        HashSet hashSet = new HashSet();
        Calendar calendar = Calendar.getInstance();
        int i = 1;
        int i2 = calendar.get(1);
        int i3 = calendar.get(2);
        int i4 = calendar.get(5);
        Iterator<Long> it = clickCacheTimes.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            calendar.setTimeInMillis(longValue);
            int i5 = calendar.get(i);
            int i6 = calendar.get(2);
            int i7 = calendar.get(5);
            if (i5 == i2 && i6 == i3 && i7 == i4) {
                hashSet.add(String.valueOf(longValue));
            }
            i = 1;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putStringSet("click_cache_times" + sposid, hashSet);
        edit.apply();
    }

    public final void BmvVmW(SAAllianceAdData sAAllianceAdData) {
        Monitor monitor;
        new EY4UKY.ADYaiT().B3GDIM(2, 1, this.f3187AYUAbz, this.f3200B9tovu, "");
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null || (monitor = sAAllianceAdData.getMonitor()) == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Ledp> ledp = monitor.getAdvml().getLedp();
        if (ledp == null || ledp.isEmpty()) {
            return;
        }
        for (Ledp ledp2 : ledp) {
            String url = ledp2.getUrl();
            if (!TextUtils.isEmpty(url)) {
                if (TextUtils.isEmpty(ledp2.getSdkid()) && url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                    url = BNL6CD(BNL6CD(url, "__SDKID__", ""), "__NTAGID__", "");
                }
                B7CMnp(BJ7GGh(url), "LE_DP_FINISH", false);
            }
        }
    }

    public final boolean BniPrB() {
        this.f3204BJ7GGh = false;
        if (this.f3203BIYEnU) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return false;
        }
        if (jni_interface.f9719A4TApA == null) {
            jni_interface.f9719A4TApA = new jni_interface();
        }
        jni_interface.f9719A4TApA.A2egSU(GJee0v.A2egSU.A5SV6n(), "2", this.f3187AYUAbz, new AMqCpz(this));
        return this.f3204BJ7GGh;
    }

    public final void BpkvW3(SAAllianceAdData sAAllianceAdData) {
        new EY4UKY.ADYaiT().B3GDIM(5, 2, this.f3187AYUAbz, this.f3200B9tovu, "");
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Ledowncomptrs> ledowncomptrs = monitor.getAdvml().getLedowncomptrs();
        if (ledowncomptrs == null || ledowncomptrs.isEmpty()) {
            return;
        }
        Iterator<Ledowncomptrs> it = ledowncomptrs.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                B7CMnp(BJ7GGh(url), "LE_DOWN_FINISH", false);
            }
        }
    }

    public final void C2rE4F() {
        this.f3203BIYEnU = true;
        try {
            Context A4TApA2 = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z);
            if (A4TApA2 != null && !GnQT2j.AZOQYO.f3116AYUAbz.contains("nmssp_download")) {
                GnQT2j.AZOQYO.f3116AYUAbz = A4TApA2.getExternalCacheDir() + "/nmssp_download/";
            }
            DeviceUtil.A5SV6n(A4TApA2, GnQT2j.AZOQYO.f3116AYUAbz, this.f3253EQurEW);
            COJEAR(this.f3187AYUAbz);
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 030: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    public final void C4FrIb(SAAllianceAdData sAAllianceAdData) {
        new EY4UKY.ADYaiT().B3GDIM(5, 0, this.f3187AYUAbz, this.f3200B9tovu, "");
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Ledownstarttrs> ledownstarttrs = monitor.getAdvml().getLedownstarttrs();
        if (ledownstarttrs == null || ledownstarttrs.isEmpty()) {
            return;
        }
        Iterator<Ledownstarttrs> it = ledownstarttrs.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                B7CMnp(BJ7GGh(url), "LE_DOWN_START", false);
            }
        }
    }

    public final void CASmeH(SAAllianceAdData sAAllianceAdData) {
        new EY4UKY.ADYaiT().B3GDIM(2, 2, this.f3187AYUAbz, this.f3200B9tovu, "");
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Ledpfailtrs> ledpfailtrs = monitor.getAdvml().getLedpfailtrs();
        if (ledpfailtrs == null || ledpfailtrs.isEmpty()) {
            return;
        }
        Iterator<Ledpfailtrs> it = ledpfailtrs.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                B7CMnp(BJ7GGh(url), "LE_DP_FAIL", false);
            }
        }
    }

    public final void CNPG0E(SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Lefirstquartile> lefirstquartile = monitor.getAdvml().getLefirstquartile();
        if (lefirstquartile != null && !lefirstquartile.isEmpty()) {
            Iterator<Lefirstquartile> it = lefirstquartile.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_VIDEO_QUARTILE", false);
                }
            }
        }
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void COJEAR(SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Leinstallstarttrs> leinstallstarttrs = monitor.getAdvml().getLeinstallstarttrs();
        if (leinstallstarttrs == null || leinstallstarttrs.isEmpty()) {
            return;
        }
        Iterator<Leinstallstarttrs> it = leinstallstarttrs.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                B7CMnp(BJ7GGh(url), "LE_INSTALL_START", false);
            }
        }
    }

    public final void CQhlFr(SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Lemidpoint> lemidpoint = monitor.getAdvml().getLemidpoint();
        if (lemidpoint != null && !lemidpoint.isEmpty()) {
            Iterator<Lemidpoint> it = lemidpoint.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_VIDEO_HALF", false);
                }
            }
        }
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void CSDoyG(SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        Objects.toString(this.f3187AYUAbz);
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Lemute> lemute = monitor.getAdvml().getLemute();
        if (lemute != null && !lemute.isEmpty()) {
            Iterator<Lemute> it = lemute.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_VIDEO_MUTE", false);
                }
            }
        }
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void CTkVKb(SAAllianceAdData sAAllianceAdData) {
        try {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            new EY4UKY.ADYaiT().B3GDIM(4, 1, this.f3187AYUAbz, this.f3200B9tovu, "");
            Objects.toString(this.f3187AYUAbz);
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 007: "), new EY4UKY.ADYaiT(), "004", e);
        }
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new EY4UKY.ADYaiT().AmA8tU("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Lepause> lepause = monitor.getAdvml().getLepause();
        if (lepause != null && !lepause.isEmpty()) {
            Iterator<Lepause> it = lepause.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_PAUSE", false);
                }
            }
        }
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void CcAIMM(SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData == null || this.f3239DXnQ0V || this.f3248DyaChj) {
            return;
        }
        this.f3248DyaChj = true;
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Leready> leready = monitor.getAdvml().getLeready();
        if (leready != null) {
            Iterator<Leready> it = leready.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_READY", false);
                }
            }
        }
    }

    public final void Cd8JRx(SAAllianceAdData sAAllianceAdData) {
        try {
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 005: "), new EY4UKY.ADYaiT(), "004", e);
        }
        if (sAAllianceAdData == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        Objects.toString(this.f3187AYUAbz);
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            new EY4UKY.ADYaiT().AmA8tU("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Leskip> leskip = monitor.getAdvml().getLeskip();
        if (leskip != null && !leskip.isEmpty()) {
            Iterator<Leskip> it = leskip.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_VIDEO_SKIP", false);
                }
            }
        }
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public void CikNvS() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void CkXcdM(SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Lethirdquartile> lethirdquartile = monitor.getAdvml().getLethirdquartile();
        if (lethirdquartile != null && !lethirdquartile.isEmpty()) {
            Iterator<Lethirdquartile> it = lethirdquartile.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_VIDEO_THIRD_QUARTILE", false);
                }
            }
        }
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public void CmUvjW() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void CqNSpT(SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        Objects.toString(this.f3187AYUAbz);
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Leunmute> leunmute = monitor.getAdvml().getLeunmute();
        if (leunmute != null && !leunmute.isEmpty()) {
            Iterator<Leunmute> it = leunmute.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    B7CMnp(BJ7GGh(url), "LE_VIDEO_UNMUTE", false);
                }
            }
        }
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public void CrfGsy() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void CtFAbx(SAAllianceAdData sAAllianceAdData) {
        int duration;
        new EY4UKY.ADYaiT().B3GDIM(4, 2, this.f3187AYUAbz, this.f3200B9tovu, "");
        if (this.f3250EGM26s) {
            return;
        }
        this.f3250EGM26s = true;
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null) {
            return;
        }
        Monitor monitor = sAAllianceAdData.getMonitor();
        Objects.toString(monitor);
        if (monitor == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Levideoend> levideoend = monitor.getAdvml().getLevideoend();
        if (levideoend != null && !levideoend.isEmpty()) {
            Iterator<Levideoend> it = levideoend.iterator();
            while (it.hasNext()) {
                String url = it.next().getUrl();
                if (!TextUtils.isEmpty(url)) {
                    if (this.f3194AzWtSf != null) {
                        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
                        MediaPlayer mediaPlayer = this.f3194AzWtSf.f3305B4ZgIw;
                        if (mediaPlayer != null) {
                            try {
                                duration = mediaPlayer.getDuration();
                            } catch (Exception unused) {
                            }
                            AMqCpz.append(duration / 1000);
                            String sb = AMqCpz.toString();
                            url = BNL6CD(BNL6CD(BNL6CD(url, "__LEMON__VIDEO_DURATION__", sb), "__LEMON__PROGRESS__", sb), "__LEMON__VD__", sb);
                        }
                        duration = 0;
                        AMqCpz.append(duration / 1000);
                        String sb2 = AMqCpz.toString();
                        url = BNL6CD(BNL6CD(BNL6CD(url, "__LEMON__VIDEO_DURATION__", sb2), "__LEMON__PROGRESS__", sb2), "__LEMON__VD__", sb2);
                    }
                    B7CMnp(BJ7GGh(url), "LE_VIDEO_FINISH", false);
                }
            }
        }
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void CtxOCS() {
        if (this.f3241DcUJf1) {
            return;
        }
        this.f3241DcUJf1 = true;
        if (this.f3242DdagTj) {
            new EY4UKY.ADYaiT().ASJ6gh(1, 2, this.f3187AYUAbz, this.f3200B9tovu, "", "", 1);
        } else {
            new EY4UKY.ADYaiT().B3GDIM(1, 2, this.f3187AYUAbz, this.f3200B9tovu, "");
        }
    }

    public final void D07BeM(SAAllianceAdData sAAllianceAdData) {
        Monitor monitor;
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null || (monitor = sAAllianceAdData.getMonitor()) == null) {
            return;
        }
        if (monitor.getAdvml() == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", null);
            return;
        }
        List<Levideoloaderror> levideoloaderror = monitor.getAdvml().getLevideoloaderror();
        if (levideoloaderror == null || levideoloaderror.isEmpty()) {
            return;
        }
        Iterator<Levideoloaderror> it = levideoloaderror.iterator();
        while (it.hasNext()) {
            String url = it.next().getUrl();
            if (!TextUtils.isEmpty(url)) {
                B7CMnp(BJ7GGh(url), "LE_VIDEO_ERROR", false);
            }
        }
    }

    public void D6DOie() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void D6yqiO(SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData != null) {
            try {
                if (sAAllianceAdData.getMonitor() != null && sAAllianceAdData.getMonitor().getLurl() != null && !sAAllianceAdData.getMonitor().getLurl().isEmpty()) {
                    List<Lurl> lurl = sAAllianceAdData.getMonitor().getLurl();
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator<Lurl> it = lurl.iterator();
                    while (it.hasNext()) {
                        String url = it.next().getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            this.BpkvW3 = String.valueOf(currentTimeMillis);
                            this.f3227CtxOCS = String.valueOf((int) (currentTimeMillis / 1000));
                            if (url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                                url = BNL6CD(BNL6CD(url, "__SDKID__", ""), "__NTAGID__", "");
                            }
                            B7CMnp(BJ7GGh(url), "LURL", false);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void D8MqeW() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void D8cQ8b(SAAllianceAdData sAAllianceAdData) {
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData != null) {
            try {
                if (sAAllianceAdData.getMonitor() != null && sAAllianceAdData.getMonitor().getNurl() != null && !sAAllianceAdData.getMonitor().getNurl().isEmpty()) {
                    List<Nurl> nurl = sAAllianceAdData.getMonitor().getNurl();
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator<Nurl> it = nurl.iterator();
                    while (it.hasNext()) {
                        String url = it.next().getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            this.BpkvW3 = String.valueOf(currentTimeMillis);
                            this.f3227CtxOCS = String.valueOf((int) (currentTimeMillis / 1000));
                            if (url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                                url = BNL6CD(BNL6CD(url, "__SDKID__", ""), "__NTAGID__", "");
                            }
                            B7CMnp(BJ7GGh(url), "NURL", false);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void D9tr6l() {
        if (this.f3189AZkASS) {
            return;
        }
        this.f3189AZkASS = true;
        if (this.f3188AZOQYO != null) {
            GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A2egSU(this, 5));
        }
        if (this.f3239DXnQ0V) {
            return;
        }
        new EY4UKY.ADYaiT().AYUAbz(2, 1, this.f3187AYUAbz, this.f3200B9tovu, this.f3186ASJ6gh.f2478A2egSU, "", "", -1, null);
    }

    public final void DAk1zC(SAAllianceAdData sAAllianceAdData) {
        this.f3191AcNBzu = System.currentTimeMillis();
        Objects.toString(this.f3187AYUAbz);
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (sAAllianceAdData == null || sAAllianceAdData.getMonitor() == null) {
            return;
        }
        List<Pa> pa = sAAllianceAdData.getMonitor().getPa();
        if (pa == null) {
            CtFAbx.B7CMnp("004", "BaseAllianceAdImpl 013: monitor-pa is null, The old version will be incompatible ", null);
            return;
        }
        if (pa.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f3193AmA8tU = currentTimeMillis - this.f3192AlLFFp;
        for (Pa pa2 : pa) {
            String url = pa2.getUrl();
            if (!TextUtils.isEmpty(url)) {
                this.BpkvW3 = String.valueOf(currentTimeMillis);
                this.f3227CtxOCS = String.valueOf((int) (currentTimeMillis / 1000));
                if (TextUtils.isEmpty(pa2.getSdkid()) && url.contains("__SDKID__") && url.contains("__NTAGID__")) {
                    url = BNL6CD(BNL6CD(url, "__SDKID__", ""), "__NTAGID__", "");
                }
                if (url.contains("__LEMON__PRICE__") && sAAllianceAdData.getPrice() != null) {
                    try {
                        String AZOQYO2 = com.bumptech.glide.AMqCpz.AZOQYO(sAAllianceAdData.getPrice());
                        if (AZOQYO2 != null) {
                            url = BNL6CD(url, "__LEMON__PRICE__", AZOQYO2);
                        }
                    } catch (Exception e) {
                        CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 008: "), new EY4UKY.ADYaiT(), "004", e);
                    }
                }
                B7CMnp(BJ7GGh(url), "PA", false);
            }
        }
    }

    public final void DG07BK() {
        new EY4UKY.ADYaiT().AYUAbz(2, 0, this.f3187AYUAbz, this.f3200B9tovu, this.f3186ASJ6gh.f2478A2egSU, "", "", -1, null);
    }

    public final void DRlcZ9() {
        if (this.DXuj49) {
            return;
        }
        this.DXuj49 = true;
        new EY4UKY.ADYaiT().AlLFFp(this.f3187AYUAbz, this.f3200B9tovu, "1", "素材加载超时");
    }

    public final void DUi7mC() {
        WeakReference weakReference = this.f3185ARc23Z;
        Context A5SV6n2 = weakReference != null ? (Context) weakReference.get() : GJee0v.A2egSU.A5SV6n();
        if (A5SV6n2 == null) {
            return;
        }
        try {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            FpcJKS.A2egSU A4TApA2 = ExjC7D.A2egSU.A4TApA(A5SV6n2);
            if (A4TApA2 != null) {
                A4TApA2.A2egSU(GTPRn3.A2egSU.f3057AlLFFp, new ADYaiT(this, 2));
                A4TApA2.A2egSU(GTPRn3.A2egSU.f3059AzWtSf, new ADYaiT(this, 0));
                A4TApA2.A2egSU(GTPRn3.A2egSU.f3060B25kr6, new ADYaiT(this, 1));
            }
        } catch (Exception e) {
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("BaseAllianceAdImpl 012: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    public final void DV2E8K() {
        new EY4UKY.ADYaiT().B3GDIM(1, 3, this.f3187AYUAbz, this.f3200B9tovu, this.f3201BChYOn);
    }

    public final void DXnQ0V() {
        new EY4UKY.ADYaiT().B3GDIM(1, 0, this.f3187AYUAbz, this.f3200B9tovu, this.f3201BChYOn);
    }

    public final void DXuj49() {
        new EY4UKY.ADYaiT().B3GDIM(4, 3, this.f3187AYUAbz, this.f3200B9tovu, "");
    }
}
