package FZu94u;

import ADYaiT.CtFAbx;
import ADYaiT.D8MqeW;
import DuwtYk.AMqCpz;
import Fyurov.B4ZgIw;
import GJee0v.AZkASS;
import H0qugq.AZOQYO;
import HFjH17.ADYaiT;
import HFjH17.ASJ6gh;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.RewardInfo;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SARewardVerifyData;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.bumptech.glide.A5SV6n;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends AZOQYO implements ASJ6gh {
    public String EdQ5bb;

    /* renamed from: EdhSi6, reason: collision with root package name */
    public boolean f2762EdhSi6;

    /* renamed from: EiK8oA, reason: collision with root package name */
    public boolean f2763EiK8oA;

    /* renamed from: EicXu4, reason: collision with root package name */
    public boolean f2764EicXu4;

    /* renamed from: EmJGcg, reason: collision with root package name */
    public boolean f2765EmJGcg;

    /* renamed from: ErKPGd, reason: collision with root package name */
    public int f2766ErKPGd;

    /* renamed from: EsrwYR, reason: collision with root package name */
    public boolean f2767EsrwYR;

    /* renamed from: EwN40Z, reason: collision with root package name */
    public HHLj6Q.A4TApA f2768EwN40Z;

    /* renamed from: ExjC7D, reason: collision with root package name */
    public Activity f2769ExjC7D;

    /* renamed from: F1loUV, reason: collision with root package name */
    public Material f2770F1loUV;

    /* renamed from: F32kj0, reason: collision with root package name */
    public String f2771F32kj0;

    /* renamed from: F508T2, reason: collision with root package name */
    public HHLj6Q.A2egSU f2772F508T2;

    /* renamed from: FG7pZc, reason: collision with root package name */
    public boolean f2773FG7pZc;

    /* renamed from: FM663C, reason: collision with root package name */
    public int f2774FM663C;

    /* renamed from: FOAO9d, reason: collision with root package name */
    public int f2775FOAO9d;

    /* renamed from: FSFw2u, reason: collision with root package name */
    public String f2776FSFw2u;

    /* renamed from: FZu94u, reason: collision with root package name */
    public int f2777FZu94u;

    /* renamed from: FdMWEC, reason: collision with root package name */
    public ADYaiT f2778FdMWEC;

    /* renamed from: Ff5QvW, reason: collision with root package name */
    public Bitmap f2779Ff5QvW;

    /* renamed from: Fmmv0E, reason: collision with root package name */
    public HHLj6Q.A2egSU f2780Fmmv0E;

    /* renamed from: FmyuN2, reason: collision with root package name */
    public SAAllianceAdData f2781FmyuN2;

    /* renamed from: FpcJKS, reason: collision with root package name */
    public String f2782FpcJKS;

    /* renamed from: Fyurov, reason: collision with root package name */
    public boolean f2783Fyurov;
    public B4ZgIw G16Pvp;
    public FrameLayout G2rdQT;

    /* renamed from: G58fqA, reason: collision with root package name */
    public int f2784G58fqA;

    /* renamed from: GEYgCP, reason: collision with root package name */
    public int f2785GEYgCP;

    /* renamed from: GGG1xW, reason: collision with root package name */
    public DjONCG.ADYaiT f2786GGG1xW;

    /* renamed from: GIi2tl, reason: collision with root package name */
    public G58fqA.A2egSU f2787GIi2tl;

    /* renamed from: GIl1rw, reason: collision with root package name */
    public boolean f2788GIl1rw;

    /* renamed from: GJee0v, reason: collision with root package name */
    public boolean f2789GJee0v;

    public static RewardInfo Ddcejp(A4TApA a4TApA, String str) {
        RewardInfo rewardInfo;
        a4TApA.getClass();
        if (str == null || str.isEmpty()) {
            rewardInfo = new RewardInfo();
            rewardInfo.setValid(false);
            AMqCpz aMqCpz = a4TApA.f3186ASJ6gh;
            rewardInfo.setExtraInfo(aMqCpz.f2483ASJ6gh);
            rewardInfo.setTransId(a4TApA.f2776FSFw2u);
            rewardInfo.setUserId(aMqCpz.f2482ARc23Z);
            rewardInfo.setTransId(a4TApA.f3187AYUAbz.getRequestid());
        } else {
            try {
                rewardInfo = (RewardInfo) new Gson().fromJson(str, new EiK8oA.A2egSU().getType());
                a4TApA.f2788GIl1rw = rewardInfo.isValid();
            } catch (Exception e) {
                CtFAbx.B4ZgIw(e, new StringBuilder("NMRewardVideoAdImpl 004: "), new EY4UKY.ADYaiT(), "004", e);
                return null;
            }
        }
        a4TApA.f2788GIl1rw = rewardInfo.isValid();
        return rewardInfo;
    }

    public static void DjONCG(A4TApA a4TApA, int i, String str, String str2) {
        HHLj6Q.A2egSU a2egSU;
        if (a4TApA.f2781FmyuN2 != null && (a2egSU = a4TApA.f2780Fmmv0E) != null) {
            a2egSU.removeCallbacksAndMessages(null);
            a4TApA.f2780Fmmv0E.sendEmptyMessage(0);
        } else {
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            a4TApA.AmA8tU(i, str, str2);
            String str3 = a4TApA.f3186ASJ6gh.f2478A2egSU;
            A5SV6n.ARc23Z();
        }
    }

    public static void Dphsd2(A4TApA a4TApA, SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) {
        String str;
        String str2 = a4TApA.f2776FSFw2u;
        String str3 = a4TApA.f3200B9tovu;
        try {
            if (sAAllianceAdData != null) {
                if (sAAllianceAdData2 != null && sAAllianceAdData.getPriceD() <= sAAllianceAdData2.getPriceD()) {
                    a4TApA.f3187AYUAbz = sAAllianceAdData2;
                    a4TApA.f2782FpcJKS = str3;
                }
                a4TApA.f3187AYUAbz = sAAllianceAdData;
                a4TApA.f2782FpcJKS = sAAllianceAdData.getRequestid();
                a4TApA.f3187AYUAbz.setParentCrequestid(sAAllianceAdData.getRequestid());
            } else {
                a4TApA.f3187AYUAbz = sAAllianceAdData2;
                a4TApA.f2782FpcJKS = str3;
            }
            a4TApA.f3187AYUAbz.setCrequestid(str3);
            a4TApA.f3207BTvldC.AaHO0E(str2, a4TApA.f2782FpcJKS);
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            a4TApA.f3187AYUAbz.setSpostype(Integer.parseInt(a4TApA.f3238DV2E8K));
            a4TApA.f3187AYUAbz.getTagCode();
            String price = a4TApA.f3187AYUAbz.getPrice();
            a4TApA.f3197B3GDIM = price;
            if (price == null || price.isEmpty()) {
                a4TApA.f3197B3GDIM = "-1";
            }
            int rdirection = a4TApA.f3187AYUAbz.getRdirection();
            a4TApA.f2766ErKPGd = rdirection;
            if (rdirection == 2) {
                a4TApA.f3221CikNvS = "" + Math.max(AMqCpz.f2468AZOQYO, AMqCpz.f2469AZkASS);
                a4TApA.f3222CkXcdM = "" + Math.min(AMqCpz.f2468AZOQYO, AMqCpz.f2469AZkASS);
            } else {
                a4TApA.f3221CikNvS = "" + Math.min(AMqCpz.f2468AZOQYO, AMqCpz.f2469AZkASS);
                a4TApA.f3222CkXcdM = "" + Math.max(AMqCpz.f2468AZOQYO, AMqCpz.f2469AZkASS);
            }
            a4TApA.f2784G58fqA = a4TApA.f3187AYUAbz.getVerifyWithServer();
            a4TApA.f2785GEYgCP = a4TApA.f3187AYUAbz.getClickCallbackSwitch();
            if (a4TApA.f3187AYUAbz.getInteraction() != null) {
                int i2 = a4TApA.f3187AYUAbz.getInteraction().clickArea;
                a4TApA.f2775FOAO9d = i2;
                if (i2 == -1) {
                    a4TApA.f2775FOAO9d = 0;
                }
            }
            if (a4TApA.f3187AYUAbz.getMaterial() == null) {
                a4TApA.AmA8tU(8196, "001", "广告素材为空，请联系运营检查代码位ID配置情况。01");
                A5SV6n.ARc23Z();
                return;
            }
            Material material = a4TApA.f3187AYUAbz.getMaterial();
            a4TApA.f2770F1loUV = material;
            a4TApA.f2771F32kj0 = material.getVideourl();
            AMqCpz aMqCpz = a4TApA.f3186ASJ6gh;
            if (aMqCpz != null && (str = aMqCpz.f2482ARc23Z) != null && !str.isEmpty()) {
                a4TApA.f3187AYUAbz.setUserId(aMqCpz.f2482ARc23Z);
            }
            HHLj6Q.A4TApA a4TApA2 = new HHLj6Q.A4TApA();
            a4TApA.f2768EwN40Z = a4TApA2;
            a4TApA2.f3255A2egSU = a4TApA.f3197B3GDIM;
            new FSFw2u.A2egSU().add(a4TApA.f2771F32kj0);
            a4TApA.AzWtSf(a4TApA.f2768EwN40Z);
            String str4 = aMqCpz.f2478A2egSU;
            if (A5SV6n.f9894AlLFFp) {
                System.currentTimeMillis();
            }
            a4TApA.f2783Fyurov = true;
            System.currentTimeMillis();
            System.currentTimeMillis();
            a4TApA.DaOi9o();
        } catch (Exception e) {
            e.toString();
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoAdImpl 001: "), new EY4UKY.ADYaiT(), "004", e);
            a4TApA.AmA8tU(8194, "001", "渲染失败。");
            A5SV6n.ARc23Z();
        }
    }

    @Override // HFjH17.ASJ6gh
    public final void A2egSU() {
    }

    @Override // HFjH17.ASJ6gh
    public final void A4TApA(int i) {
        if (i >= 25 && !this.f2762EdhSi6) {
            this.f2762EdhSi6 = true;
            CNPG0E(this.f3187AYUAbz);
        }
        if (i >= 50 && !this.f2763EiK8oA) {
            this.f2763EiK8oA = true;
            DXuj49();
            CQhlFr(this.f3187AYUAbz);
        }
        if (i < 75 || this.f2764EicXu4) {
            return;
        }
        this.f2764EicXu4 = true;
        CkXcdM(this.f3187AYUAbz);
    }

    @Override // HFjH17.ASJ6gh
    public final void A5SV6n(int i) {
        ADYaiT aDYaiT;
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        if (i != 3 || (aDYaiT = this.f2778FdMWEC) == null) {
            return;
        }
        aDYaiT.AYUAbz(false);
    }

    @Override // HFjH17.ASJ6gh
    public final void ADYaiT() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (this.f2773FG7pZc) {
            return;
        }
        this.f2773FG7pZc = true;
        De4eam(2, null, null);
        if (this.f2763EiK8oA) {
            CtFAbx(this.f3187AYUAbz);
        }
    }

    @Override // HFjH17.ASJ6gh
    public final void AMqCpz(MediaPlayer mediaPlayer) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        this.f2778FdMWEC.f3312BNL6CD = false;
        DisplayMetrics displayMetrics = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z).getResources().getDisplayMetrics();
        int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        boolean z = mediaPlayer.getVideoHeight() < mediaPlayer.getVideoWidth();
        this.f2767EsrwYR = z;
        if (this.f2766ErKPGd != 2) {
            this.f2778FdMWEC.AMqCpz(min, max);
        } else if (z) {
            this.f2778FdMWEC.AMqCpz(max, min);
        } else {
            this.f2778FdMWEC.AMqCpz((min * 9) / 16, min);
        }
        mediaPlayer.setVideoScalingMode(2);
        D9tr6l();
        CcAIMM(this.f3187AYUAbz);
        System.currentTimeMillis();
    }

    public final void DaOi9o() {
        Context A4TApA2;
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        try {
            DG07BK();
            A4TApA2 = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z);
        } catch (Exception e) {
            e = e;
        }
        try {
            if (A4TApA2 == null || ((A4TApA2 instanceof Activity) && ((Activity) A4TApA2).isFinishing())) {
                AmA8tU(8198, "001", "渲染失败，请检查Activity状态。");
                A5SV6n.ARc23Z();
                return;
            }
            View inflate = LayoutInflater.from(A4TApA2).inflate(2131493187, (ViewGroup) null, false);
            if (inflate != null) {
                this.G2rdQT = (FrameLayout) inflate.findViewById(2131296683);
            }
            ADYaiT aDYaiT = new ADYaiT(A4TApA2, this.f2771F32kj0, this.G2rdQT, this.f2765EmJGcg, this);
            this.f2778FdMWEC = aDYaiT;
            this.f3194AzWtSf = aDYaiT;
            aDYaiT.f3312BNL6CD = false;
            AZkASS.f3040ADYaiT.f3041A2egSU.execute(new D8MqeW(12, this));
        } catch (Exception e2) {
            e = e2;
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoAdImpl 002: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    public final void DcUJf1() {
        this.f2789GJee0v = true;
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (this.f2768EwN40Z != null) {
            if (this.f2784G58fqA != 1) {
                De4eam(5, null, null);
                return;
            }
            SARewardVerifyData sARewardVerifyData = new SARewardVerifyData();
            sARewardVerifyData.setAppId(DeviceUtil.f9708A2egSU);
            AMqCpz aMqCpz = this.f3186ASJ6gh;
            sARewardVerifyData.setExtraInfo(aMqCpz.f2483ASJ6gh);
            sARewardVerifyData.setPrice(this.f3197B3GDIM);
            sARewardVerifyData.setPlacementId(this.f2776FSFw2u);
            sARewardVerifyData.setUserId(aMqCpz.f2482ARc23Z);
            sARewardVerifyData.setTransId(this.f3200B9tovu);
            String json = new Gson().toJson(sARewardVerifyData);
            KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(22, this);
            EY4UKY.AMqCpz aMqCpz2 = new EY4UKY.AMqCpz();
            aMqCpz2.f2537AlLFFp = null;
            aMqCpz2.f2538AmA8tU = a5SV6n;
            aMqCpz2.f2539AzWtSf = json;
            aMqCpz2.f2540B25kr6 = this.EdQ5bb;
            aMqCpz2.f2536AcNBzu = new CtFAbx.A2egSU(4, aMqCpz2);
            new EY4UKY.ADYaiT().B3GDIM(3, 2, this.f3187AYUAbz, this.f3200B9tovu, "");
            CtFAbx.A2egSU a2egSU = (CtFAbx.A2egSU) aMqCpz2.f2536AcNBzu;
            if (a2egSU != null) {
                AZkASS.f3040ADYaiT.f3041A2egSU.execute(a2egSU);
            }
        }
    }

    public final void DdagTj() {
        Context A4TApA2 = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z);
        if (A4TApA2 == null) {
            return;
        }
        G58fqA.A2egSU a2egSU = new G58fqA.A2egSU(new Cd8JRx.ADYaiT(1, this), A4TApA2);
        this.f2787GIi2tl = a2egSU;
        a2egSU.AMqCpz("SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }

    public final void De4eam(int i, RewardInfo rewardInfo, Runnable runnable) {
        AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A2egSU(this, i, rewardInfo, runnable, 0));
    }

    public final void DuwtYk(NMRewardVideoActivity nMRewardVideoActivity) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (this.f2768EwN40Z != null) {
            De4eam(1, null, null);
            G58fqA.A2egSU a2egSU = this.f2787GIi2tl;
            if (a2egSU != null) {
                a2egSU.A4TApA();
            }
        }
        nMRewardVideoActivity.finish();
    }

    public final boolean DvK7DB(NMRewardVideoActivity nMRewardVideoActivity, int i, Runnable runnable) {
        this.f3206BPw6Q8 = i == 1;
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        this.f3185ARc23Z = new WeakReference(nMRewardVideoActivity);
        Material material = this.f2770F1loUV;
        if (material != null) {
            this.f2777FZu94u = material.getLdptype();
        }
        if (this.f2777FZu94u == 1 ? BChYOn(this.f3187AYUAbz.getMaterial(), this.f3187AYUAbz, false, null) : BChYOn(this.f3187AYUAbz.getMaterial(), this.f3187AYUAbz, true, null)) {
            this.f3198B4ZgIw = true;
            if (this.f2768EwN40Z != null) {
                De4eam(4, null, runnable);
                DdagTj();
                return true;
            }
        }
        return false;
    }

    public final void DyaChj(NMRewardVideoActivity nMRewardVideoActivity) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        De4eam(3, null, null);
        nMRewardVideoActivity.finish();
    }

    @Override // HFjH17.ASJ6gh
    public final void onError(int i, int i2) {
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
        De4eam(3, null, null);
        BTvldC("1", "加载素材失败, error.what = " + i + ", error.extra = " + i2);
        D07BeM(this.f3187AYUAbz);
    }
}
