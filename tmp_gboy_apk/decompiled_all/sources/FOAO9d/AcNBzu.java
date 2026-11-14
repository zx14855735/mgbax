package FOAO9d;

import ADYaiT.CtFAbx;
import ADYaiT.D8MqeW;
import Fyurov.AZOQYO;
import Fyurov.B4ZgIw;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.bean.Interaction;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu extends H1wUHe.A2egSU implements HFjH17.ASJ6gh {
    public final AcNBzu EdQ5bb;

    /* renamed from: EdhSi6, reason: collision with root package name */
    public int f2599EdhSi6;

    /* renamed from: EiK8oA, reason: collision with root package name */
    public int f2600EiK8oA;

    /* renamed from: EicXu4, reason: collision with root package name */
    public int f2601EicXu4;

    /* renamed from: EmJGcg, reason: collision with root package name */
    public int f2602EmJGcg;

    /* renamed from: ErKPGd, reason: collision with root package name */
    public final int f2603ErKPGd;

    /* renamed from: EsrwYR, reason: collision with root package name */
    public final boolean f2604EsrwYR;

    /* renamed from: EwN40Z, reason: collision with root package name */
    public int f2605EwN40Z;

    /* renamed from: ExjC7D, reason: collision with root package name */
    public int f2606ExjC7D;

    /* renamed from: F1loUV, reason: collision with root package name */
    public AlLFFp f2607F1loUV;

    /* renamed from: F32kj0, reason: collision with root package name */
    public LinearLayout f2608F32kj0;

    /* renamed from: F508T2, reason: collision with root package name */
    public int f2609F508T2;

    /* renamed from: FG7pZc, reason: collision with root package name */
    public boolean f2610FG7pZc;

    /* renamed from: FM663C, reason: collision with root package name */
    public int f2611FM663C;

    /* renamed from: FOAO9d, reason: collision with root package name */
    public boolean f2612FOAO9d;

    /* renamed from: FSFw2u, reason: collision with root package name */
    public boolean f2613FSFw2u;

    /* renamed from: FZu94u, reason: collision with root package name */
    public boolean f2614FZu94u;

    /* renamed from: FdMWEC, reason: collision with root package name */
    public boolean f2615FdMWEC;

    /* renamed from: Ff5QvW, reason: collision with root package name */
    public boolean f2616Ff5QvW;

    /* renamed from: Fmmv0E, reason: collision with root package name */
    public boolean f2617Fmmv0E;

    /* renamed from: FmyuN2, reason: collision with root package name */
    public boolean f2618FmyuN2;

    /* renamed from: FpcJKS, reason: collision with root package name */
    public int f2619FpcJKS;

    /* renamed from: Fyurov, reason: collision with root package name */
    public boolean f2620Fyurov;
    public boolean G16Pvp;
    public boolean G2rdQT;

    /* renamed from: G58fqA, reason: collision with root package name */
    public int f2621G58fqA;

    /* renamed from: GEYgCP, reason: collision with root package name */
    public Material f2622GEYgCP;

    /* renamed from: GGG1xW, reason: collision with root package name */
    public int f2623GGG1xW;

    /* renamed from: GIi2tl, reason: collision with root package name */
    public String f2624GIi2tl;

    /* renamed from: GIl1rw, reason: collision with root package name */
    public String f2625GIl1rw;

    /* renamed from: GJee0v, reason: collision with root package name */
    public String f2626GJee0v;

    /* renamed from: GL2Jh7, reason: collision with root package name */
    public String f2627GL2Jh7;

    /* renamed from: GTPRn3, reason: collision with root package name */
    public final String f2628GTPRn3;

    /* renamed from: GYpKKt, reason: collision with root package name */
    public List f2629GYpKKt;
    public GIi2tl.A2egSU GZqyMh;

    /* renamed from: GcSJYy, reason: collision with root package name */
    public FrameLayout f2630GcSJYy;

    /* renamed from: GhvxjZ, reason: collision with root package name */
    public ArrayList f2631GhvxjZ;

    /* renamed from: GnQT2j, reason: collision with root package name */
    public String f2632GnQT2j;

    /* renamed from: H0R8Px, reason: collision with root package name */
    public FrameLayout f2633H0R8Px;

    /* renamed from: H0qugq, reason: collision with root package name */
    public FrameLayout f2634H0qugq;

    /* renamed from: H1wUHe, reason: collision with root package name */
    public Bitmap f2635H1wUHe;

    /* renamed from: H3v3Sq, reason: collision with root package name */
    public HFjH17.ADYaiT f2636H3v3Sq;
    public Cd8JRx.ADYaiT H6qKiO;

    /* renamed from: HFjH17, reason: collision with root package name */
    public float f2637HFjH17;

    /* renamed from: HH6JFw, reason: collision with root package name */
    public boolean f2638HH6JFw;

    /* renamed from: HHLj6Q, reason: collision with root package name */
    public boolean f2639HHLj6Q;
    public volatile boolean HHoABE;

    /* renamed from: HIguqb, reason: collision with root package name */
    public boolean f2640HIguqb;

    /* renamed from: HMGPfW, reason: collision with root package name */
    public EQurEW.A4TApA f2641HMGPfW;

    /* renamed from: HPJABZ, reason: collision with root package name */
    public ASJ6gh f2642HPJABZ;

    /* renamed from: HSHyT0, reason: collision with root package name */
    public final SAAllianceAdData f2643HSHyT0;

    /* renamed from: HSr46Q, reason: collision with root package name */
    public String f2644HSr46Q;

    /* renamed from: HXc4pW, reason: collision with root package name */
    public boolean f2645HXc4pW;

    /* renamed from: HZUvgL, reason: collision with root package name */
    public final ARc23Z f2646HZUvgL;

    /* renamed from: Hdahpu, reason: collision with root package name */
    public ASJ6gh f2647Hdahpu;

    /* renamed from: HieBYM, reason: collision with root package name */
    public HandlerThread f2648HieBYM;

    /* renamed from: Hjvs0g, reason: collision with root package name */
    public int f2649Hjvs0g;

    /* renamed from: HtmBAy, reason: collision with root package name */
    public final ASJ6gh f2650HtmBAy;

    /* renamed from: HwAeAU, reason: collision with root package name */
    public volatile boolean f2651HwAeAU;

    /* renamed from: I3HV03, reason: collision with root package name */
    public final Object f2652I3HV03;

    /* renamed from: I3bnmY, reason: collision with root package name */
    public B4ZgIw f2653I3bnmY;

    /* renamed from: I9dkCd, reason: collision with root package name */
    public boolean f2654I9dkCd;

    /* renamed from: IDXjOL, reason: collision with root package name */
    public FrameLayout f2655IDXjOL;

    /* renamed from: IJPJ4E, reason: collision with root package name */
    public boolean f2656IJPJ4E;

    /* renamed from: IOxIEW, reason: collision with root package name */
    public boolean f2657IOxIEW;

    /* renamed from: IQ76hF, reason: collision with root package name */
    public G58fqA.A2egSU f2658IQ76hF;

    /* renamed from: IYh8XG, reason: collision with root package name */
    public ASJ6gh f2659IYh8XG;

    /* renamed from: Ifhupb, reason: collision with root package name */
    public final ASJ6gh f2660Ifhupb;

    /* renamed from: IhMMDv, reason: collision with root package name */
    public final ASJ6gh f2661IhMMDv;

    /* renamed from: IlwJBd, reason: collision with root package name */
    public final ASJ6gh f2662IlwJBd;

    /* renamed from: IsbtnO, reason: collision with root package name */
    public boolean f2663IsbtnO;

    /* renamed from: IssTRV, reason: collision with root package name */
    public int f2664IssTRV;

    /* renamed from: ItGa5w, reason: collision with root package name */
    public boolean f2665ItGa5w;

    /* renamed from: Ixu71n, reason: collision with root package name */
    public boolean f2666Ixu71n;

    /* renamed from: IySJvm, reason: collision with root package name */
    public boolean f2667IySJvm;

    /* renamed from: IzHBwY, reason: collision with root package name */
    public int f2668IzHBwY;

    /* renamed from: J3EcKw, reason: collision with root package name */
    public int f2669J3EcKw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcNBzu(WeakReference weakReference, DuwtYk.AMqCpz aMqCpz, DvK7DB.A5SV6n a5SV6n, EY4UKY.AMqCpz aMqCpz2) {
        super(weakReference, aMqCpz, a5SV6n, "3", -1);
        int i = 0;
        this.EdQ5bb = null;
        this.f2668IzHBwY = 1;
        this.f2669J3EcKw = 1;
        this.f2599EdhSi6 = 0;
        this.f2600EiK8oA = 0;
        this.f2601EicXu4 = 1;
        this.f2603ErKPGd = 0;
        this.f2604EsrwYR = true;
        this.f2605EwN40Z = 0;
        this.f2607F1loUV = null;
        this.f2608F32kj0 = null;
        this.f2609F508T2 = 1;
        this.f2610FG7pZc = false;
        this.f2611FM663C = 0;
        this.f2612FOAO9d = false;
        this.f2613FSFw2u = false;
        this.f2614FZu94u = true;
        this.f2615FdMWEC = false;
        this.f2616Ff5QvW = false;
        this.f2617Fmmv0E = false;
        this.f2618FmyuN2 = false;
        this.f2619FpcJKS = 0;
        this.f2620Fyurov = false;
        this.G16Pvp = false;
        this.G2rdQT = false;
        this.f2621G58fqA = 0;
        this.f2630GcSJYy = null;
        this.f2631GhvxjZ = new ArrayList();
        this.f2632GnQT2j = "";
        this.H6qKiO = null;
        this.f2637HFjH17 = 0.0f;
        this.f2638HH6JFw = true;
        this.f2639HHLj6Q = false;
        this.HHoABE = false;
        this.f2640HIguqb = false;
        this.f2645HXc4pW = false;
        ARc23Z aRc23Z = new ARc23Z();
        ARc23Z aRc23Z2 = new ARc23Z();
        aRc23Z2.put(1, "false");
        aRc23Z2.put(2, "");
        aRc23Z2.put(3, "");
        aRc23Z.put(0, aRc23Z2);
        ARc23Z aRc23Z3 = new ARc23Z();
        aRc23Z3.put(1, "false");
        aRc23Z3.put(2, "");
        aRc23Z3.put(3, "");
        aRc23Z.put(1, aRc23Z3);
        ARc23Z aRc23Z4 = new ARc23Z();
        aRc23Z4.put(1, "false");
        aRc23Z4.put(2, "");
        aRc23Z4.put(3, "");
        aRc23Z.put(2, aRc23Z4);
        this.f2646HZUvgL = aRc23Z;
        this.f2647Hdahpu = null;
        this.f2648HieBYM = null;
        this.f2650HtmBAy = new ASJ6gh(this, Looper.getMainLooper(), i);
        this.f2651HwAeAU = false;
        this.f2652I3HV03 = new Object();
        this.f2653I3bnmY = null;
        this.f2654I9dkCd = false;
        this.f2656IJPJ4E = false;
        this.f2657IOxIEW = false;
        this.f2659IYh8XG = new ASJ6gh(this, Looper.getMainLooper(), 1);
        this.f2660Ifhupb = new ASJ6gh(this, Looper.getMainLooper(), 2);
        this.f2661IhMMDv = new ASJ6gh(this, Looper.getMainLooper(), 3);
        this.f2662IlwJBd = new ASJ6gh(this, Looper.getMainLooper(), 4);
        this.f2663IsbtnO = false;
        this.f2664IssTRV = 0;
        this.f2665ItGa5w = false;
        this.f2666Ixu71n = false;
        this.f2667IySJvm = false;
        aMqCpz2.f2540B25kr6 = this;
        String str = aMqCpz.f2478A2egSU;
        this.f2628GTPRn3 = str;
        this.EdQ5bb = this;
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        Context A4TApA2 = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z);
        DuwtYk.AMqCpz aMqCpz3 = this.f3186ASJ6gh;
        this.f2602EmJGcg = aMqCpz3.f2479A4TApA;
        this.f2603ErKPGd = aMqCpz3.f2480A5SV6n;
        this.f2604EsrwYR = true;
        int i3 = GIi2tl.A5SV6n.f3026A2egSU[aMqCpz3.AMqCpz.ordinal()];
        AZOQYO.ARc23Z aRc23Z5 = AZOQYO.ARc23Z.f359B25kr6;
        if (i3 != 1) {
            AZOQYO.ARc23Z aRc23Z6 = AZOQYO.ARc23Z.f360B2KMhB;
            if (i3 == 2) {
                AZOQYO.ARc23Z.f361B3GDIM = aRc23Z6;
            } else if (i3 == 3 && A4TApA2 != null) {
                if ((A4TApA2.getResources().getConfiguration().uiMode & 48) == 32) {
                    AZOQYO.ARc23Z.f361B3GDIM = aRc23Z6;
                } else {
                    AZOQYO.ARc23Z.f361B3GDIM = aRc23Z5;
                }
            }
        } else {
            AZOQYO.ARc23Z.f361B3GDIM = aRc23Z5;
        }
        if (this.f2602EmJGcg <= 0) {
            AmA8tU(4099, "001", "请求失败，请检查是否设置广告宽度。");
            return;
        }
        try {
            SAAllianceAdData AcNBzu2 = AcNBzu(A4TApA2, str);
            this.f2643HSHyT0 = AcNBzu2;
            if (AcNBzu2 != null) {
                this.f3207BTvldC.getClass();
                long A5SV6n2 = H0qugq.AcNBzu.A5SV6n(A4TApA2, str);
                this.f2643HSHyT0.getRequestid();
                this.f2643HSHyT0.getPriceD();
                ASJ6gh aSJ6gh = new ASJ6gh(this, Looper.getMainLooper(), 7);
                this.f2642HPJABZ = aSJ6gh;
                aSJ6gh.sendEmptyMessageDelayed(0, A5SV6n2);
            }
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 002: "), new EY4UKY.ADYaiT(), "004", e);
        }
        System.currentTimeMillis();
        this.f2668IzHBwY = 2;
        aMqCpz.f2481ADYaiT = 3;
        F32kj0.A5SV6n a5SV6n2 = new F32kj0.A5SV6n(aMqCpz, this.f3200B9tovu, new AZOQYO(i, this, A4TApA2));
        String.valueOf(this.f2603ErKPGd);
        com.bumptech.glide.A5SV6n.AYUAbz(String.valueOf(this.f2602EmJGcg));
        a5SV6n2.A5SV6n();
    }

    public static Bitmap Dphsd2(AcNBzu acNBzu, Bitmap bitmap, int i, int i2, int i3) {
        acNBzu.getClass();
        if (bitmap == null) {
            return null;
        }
        try {
            float f = i;
            float f2 = i2;
            float height = (1.0f * f2) / bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.setScale((f * 1.0f) / bitmap.getWidth(), height);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint(1);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            float f3 = i3;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, f2), f3, f3, paint);
            return createBitmap;
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 028: "), new EY4UKY.ADYaiT(), "004", e);
            return null;
        }
    }

    public static void DvK7DB(AcNBzu acNBzu, int i, String str, String str2) {
        ASJ6gh aSJ6gh;
        acNBzu.getClass();
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        if (acNBzu.f2643HSHyT0 == null || (aSJ6gh = acNBzu.f2642HPJABZ) == null) {
            acNBzu.AmA8tU(i, str, str2);
            com.bumptech.glide.A5SV6n.ARc23Z();
        } else {
            aSJ6gh.removeCallbacksAndMessages(null);
            acNBzu.f2642HPJABZ.sendEmptyMessage(0);
        }
    }

    public static void DyaChj(AcNBzu acNBzu, SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) {
        String str;
        String str2;
        acNBzu.getClass();
        String str3 = acNBzu.f2628GTPRn3;
        String str4 = acNBzu.f3200B9tovu;
        try {
            if (sAAllianceAdData != null) {
                if (sAAllianceAdData2 != null && sAAllianceAdData.getPriceD() <= sAAllianceAdData2.getPriceD()) {
                    acNBzu.f3187AYUAbz = sAAllianceAdData2;
                    acNBzu.f2644HSr46Q = str4;
                }
                acNBzu.f3187AYUAbz = sAAllianceAdData;
                acNBzu.f2644HSr46Q = sAAllianceAdData.getRequestid();
                acNBzu.f3187AYUAbz.setParentCrequestid(sAAllianceAdData.getRequestid());
            } else {
                acNBzu.f3187AYUAbz = sAAllianceAdData2;
                acNBzu.f2644HSr46Q = str4;
            }
            acNBzu.f3187AYUAbz.setCrequestid(str4);
            acNBzu.f3207BTvldC.AaHO0E(str3, acNBzu.f2644HSr46Q);
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            acNBzu.f3187AYUAbz.setSpostype(Integer.parseInt(acNBzu.f3238DV2E8K));
            acNBzu.f2611FM663C = acNBzu.f3187AYUAbz.getClickCallbackSwitch();
            if (acNBzu.f3187AYUAbz.getMaterial() == null) {
                acNBzu.AmA8tU(8196, "001", "广告素材为空，请联系运营检查代码位ID配置情况。01");
                com.bumptech.glide.A5SV6n.ARc23Z();
                return;
            }
            acNBzu.f2600EiK8oA = acNBzu.f3187AYUAbz.getDlConfig();
            Material material = acNBzu.f3187AYUAbz.getMaterial();
            acNBzu.f2622GEYgCP = material;
            acNBzu.f2629GYpKKt = material.getImgurl();
            acNBzu.f2626GJee0v = acNBzu.f2622GEYgCP.getVideourl();
            acNBzu.f2623GGG1xW = acNBzu.f2622GEYgCP.getLdptype();
            float validExposeTime = acNBzu.f3187AYUAbz.getValidExposeTime();
            acNBzu.f2637HFjH17 = validExposeTime;
            if (validExposeTime <= 0.0f) {
                acNBzu.f2637HFjH17 = 1.0f;
            }
            List list = acNBzu.f2629GYpKKt;
            if ((list != null && !list.isEmpty()) || ((str = acNBzu.f2626GJee0v) != null && !str.isEmpty())) {
                acNBzu.f3187AYUAbz.getTagCode();
                String price = acNBzu.f3187AYUAbz.getPrice();
                acNBzu.f3197B3GDIM = price;
                if (price == null || price.isEmpty()) {
                    acNBzu.f3197B3GDIM = "-1";
                }
                if (acNBzu.f3187AYUAbz.getRstyle() != null && !acNBzu.f3187AYUAbz.getRstyle().isEmpty()) {
                    acNBzu.f2601EicXu4 = Integer.parseInt(acNBzu.f3187AYUAbz.getRstyle());
                }
                if (acNBzu.f3187AYUAbz.getInteraction().getClickArea() != -1) {
                    acNBzu.f2605EwN40Z = acNBzu.f3187AYUAbz.getInteraction().getClickArea();
                }
                acNBzu.f2624GIi2tl = acNBzu.f2622GEYgCP.getTitle();
                acNBzu.f2625GIl1rw = acNBzu.f2622GEYgCP.getDesc();
                acNBzu.f2627GL2Jh7 = acNBzu.f2622GEYgCP.getTempid();
                DuwtYk.AMqCpz aMqCpz = acNBzu.f3186ASJ6gh;
                if (aMqCpz != null && (str2 = aMqCpz.f2482ARc23Z) != null && !str2.isEmpty()) {
                    acNBzu.f3187AYUAbz.setUserId(aMqCpz.f2482ARc23Z);
                }
                acNBzu.DdagTj();
                if (com.bumptech.glide.A5SV6n.f9894AlLFFp) {
                    System.currentTimeMillis();
                }
                acNBzu.f2645HXc4pW = true;
                if (acNBzu.f2648HieBYM == null) {
                    acNBzu.f2648HieBYM = new HandlerThread("ExpressHandlerThread");
                }
                if (!acNBzu.f2656IJPJ4E) {
                    acNBzu.f2648HieBYM.start();
                    acNBzu.f2656IJPJ4E = true;
                }
                acNBzu.f2647Hdahpu = new ASJ6gh(acNBzu, acNBzu.f2648HieBYM.getLooper(), 5);
                return;
            }
            acNBzu.AmA8tU(8196, "002", "广告素材为空，请联系运营检查代码位ID配置情况。02");
            com.bumptech.glide.A5SV6n.ARc23Z();
        } catch (Exception e) {
            e.toString();
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 003: "), new EY4UKY.ADYaiT(), "004", e);
            acNBzu.AmA8tU(8194, "001", "渲染失败。");
            com.bumptech.glide.A5SV6n.ARc23Z();
        }
    }

    public static void ECyGFg(AcNBzu acNBzu, String str) {
        acNBzu.getClass();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        Context A4TApA2 = GJee0v.A2egSU.A4TApA(acNBzu.f3185ARc23Z);
        if (A4TApA2 == null) {
            return;
        }
        try {
            SAAllianceAdData copy = acNBzu.f3187AYUAbz.copy();
            if (copy != null) {
                if (copy.getMaterial() == null) {
                    copy.setMaterial(new Material(null));
                }
                copy.getMaterial().setLdp(str);
                if (copy.getInteraction() == null) {
                    copy.setInteraction(new Interaction(null));
                }
                copy.setInteraction(acNBzu.f3187AYUAbz.getInteraction());
                Intent intent = new Intent(A4TApA2, (Class<?>) SAAllianceWebViewActivity.class);
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                intent.putExtra("extra_name_land_page_ad_data", copy);
                A4TApA2.startActivity(intent);
            }
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 031: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    @Override // HFjH17.ASJ6gh
    public final void A2egSU() {
        this.f2617Fmmv0E = false;
        if (this.f2657IOxIEW) {
            return;
        }
        this.f2657IOxIEW = true;
        BPw6Q8(this.f3187AYUAbz);
    }

    @Override // HFjH17.ASJ6gh
    public final void A4TApA(int i) {
        if (i >= 25 && !this.f2665ItGa5w) {
            this.f2665ItGa5w = true;
            CNPG0E(this.f3187AYUAbz);
        }
        if (i >= 50 && !this.f2666Ixu71n) {
            this.f2666Ixu71n = true;
            DXuj49();
            CQhlFr(this.f3187AYUAbz);
        }
        if (i < 75 || this.f2667IySJvm) {
            return;
        }
        this.f2667IySJvm = true;
        CkXcdM(this.f3187AYUAbz);
    }

    @Override // HFjH17.ASJ6gh
    public final void A5SV6n(int i) {
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
    }

    @Override // HFjH17.ASJ6gh
    public final void ADYaiT() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (this.f2657IOxIEW) {
            CtFAbx(this.f3187AYUAbz);
            this.f2617Fmmv0E = true;
            this.f2657IOxIEW = false;
        }
        if (this.f2618FmyuN2 && this.f2639HHLj6Q) {
            FrameLayout frameLayout = this.f2634H0qugq;
            if (frameLayout == null || frameLayout.getVisibility() != 0) {
                if (this.f2669J3EcKw == 4) {
                    this.f2669J3EcKw = 3;
                }
                DjONCG();
                return;
            }
            return;
        }
        if (this.f2639HHLj6Q) {
            return;
        }
        FrameLayout frameLayout2 = this.f2634H0qugq;
        if (frameLayout2 == null || frameLayout2.getVisibility() != 0) {
            if (this.f2669J3EcKw == 4) {
                this.f2669J3EcKw = 3;
            }
            DjONCG();
        }
    }

    @Override // HFjH17.ASJ6gh
    public final void AMqCpz(MediaPlayer mediaPlayer) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        boolean z = false;
        try {
            this.f2616Ff5QvW = true;
            ASJ6gh aSJ6gh = this.f2659IYh8XG;
            if (aSJ6gh != null) {
                aSJ6gh.removeCallbacksAndMessages(null);
            }
            D9tr6l();
            CcAIMM(this.f3187AYUAbz);
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            if (!this.f2615FdMWEC) {
                this.f2615FdMWEC = true;
                this.G2rdQT = true;
                if (this.G16Pvp) {
                    DuwtYk(4, this.f2608F32kj0, 0, null);
                }
            }
            if (this.f2636H3v3Sq == null || this.f2630GcSJYy == null) {
                return;
            }
            if (this.GZqyMh != null && mediaPlayer != null && mediaPlayer.getVideoWidth() < mediaPlayer.getVideoHeight()) {
                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new D8MqeW(11, this));
            }
            if (this.f2636H3v3Sq.f3302B25kr6.getParent() == null) {
                this.f2630GcSJYy.addView(this.f2636H3v3Sq.f3302B25kr6);
            }
            EPdU4G(this.f2630GcSJYy);
            GIi2tl.A2egSU a2egSU = this.GZqyMh;
            if (a2egSU == null || (frameLayout = a2egSU.f3011B7CMnp) == null) {
                return;
            }
            if (frameLayout.getParent() == null) {
                this.f2630GcSJYy.addView(this.GZqyMh.f3011B7CMnp);
            }
            this.f2669J3EcKw = 3;
            FrameLayout frameLayout3 = this.GZqyMh.f3008B2KMhB;
            if (frameLayout3 != null) {
                int i2 = this.f2601EicXu4;
                float f = (i2 == 5 || i2 == 1) ? 8.0f : 11.0f;
                frameLayout3.removeAllViews();
                this.GZqyMh.f3008B2KMhB.addView(this.f2636H3v3Sq.A4TApA(f));
            }
            FrameLayout frameLayout4 = this.GZqyMh.f3009B3GDIM;
            if (frameLayout4 != null) {
                frameLayout4.removeAllViews();
                FrameLayout frameLayout5 = this.GZqyMh.f3009B3GDIM;
                HFjH17.ADYaiT aDYaiT = this.f2636H3v3Sq;
                if (aDYaiT.f3306B7CMnp == null) {
                    aDYaiT.f3306B7CMnp = new SeekBar(aDYaiT.f3288A2egSU);
                }
                HFjH17.ARc23Z aRc23Z = aDYaiT.f3300AmA8tU;
                SeekBar seekBar = aDYaiT.f3306B7CMnp;
                aRc23Z.getClass();
                HFjH17.ARc23Z.AMqCpz(seekBar);
                frameLayout5.addView(seekBar);
            }
            if (this.f2604EsrwYR || (frameLayout2 = this.GZqyMh.f3010B4ZgIw) == null) {
                return;
            }
            frameLayout2.removeAllViews();
            FrameLayout frameLayout6 = this.GZqyMh.f3010B4ZgIw;
            HFjH17.ADYaiT aDYaiT2 = this.f2636H3v3Sq;
            frameLayout6.addView(aDYaiT2.f3300AmA8tU.A4TApA(new K1Z3yj.A2egSU(aDYaiT2, new AYUAbz(this), 25, z)));
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 026: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    @Override // H0qugq.AZOQYO
    public final void CmUvjW() {
        HFjH17.ADYaiT aDYaiT = this.f2636H3v3Sq;
        if (aDYaiT != null) {
            this.f2612FOAO9d = false;
            this.f3198B4ZgIw = false;
            aDYaiT.AmA8tU();
            if (this.f2614FZu94u || this.f2617Fmmv0E || this.f2657IOxIEW) {
                this.f2614FZu94u = false;
            } else {
                BPw6Q8(this.f3187AYUAbz);
                this.f2657IOxIEW = true;
            }
        }
        EY4UKY(3);
        EY4UKY(6);
    }

    @Override // H0qugq.AZOQYO
    public final void CrfGsy() {
        this.f2614FZu94u = false;
        EY4UKY(5);
        if (this.f2636H3v3Sq != null && !this.f3198B4ZgIw) {
            this.f2612FOAO9d = true;
        }
        EY4UKY(4);
    }

    public final synchronized void DaOi9o() {
        try {
            if (this.HHoABE) {
                return;
            }
            this.HHoABE = true;
            ASJ6gh();
            DAk1zC(this.f3187AYUAbz);
            this.f2653I3bnmY = B4ZgIw.A2egSU((long) (Math.max(this.f3202BI9f7h, Math.max(3, ((int) this.f2637HFjH17) + 1)) * 1000.0f), new A2egSU(this));
            if (this.f2599EdhSi6 == 2) {
                DUi7mC();
                if (this.f2604EsrwYR) {
                    CSDoyG(this.f3187AYUAbz);
                }
            }
            this.f2668IzHBwY = 5;
            HFjH17.ADYaiT aDYaiT = this.f2636H3v3Sq;
            if (aDYaiT != null) {
                aDYaiT.AmA8tU();
            }
            De4eam();
            Context A4TApA2 = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z);
            if (this.f3207BTvldC != null) {
                H0qugq.AcNBzu.ASJ6gh(A4TApA2, this.f2628GTPRn3, this.f2644HSr46Q);
            }
            EY4UKY(3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean DcUJf1() {
        LinearLayout linearLayout;
        int i = this.f2668IzHBwY;
        return (i == 1 || i == 7 || i == 8 || (linearLayout = this.f2608F32kj0) == null || linearLayout.getVisibility() != 0 || !this.f2638HH6JFw) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void DdagTj() {
        /*
            Method dump skipped, instructions count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: FOAO9d.AcNBzu.DdagTj():void");
    }

    public final boolean Ddcejp() {
        Context A4TApA2 = GJee0v.A2egSU.A4TApA(this.f3185ARc23Z);
        if (A4TApA2 == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return false;
        }
        try {
            AppInfoViewActivity.f9605B2KMhB = this;
            Intent intent = new Intent(A4TApA2, (Class<?>) AppInfoViewActivity.class);
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra("app_info_ad_data_copy", this.f3187AYUAbz.copy());
            A4TApA2.startActivity(intent);
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            ARc23Z();
            return true;
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 032: "), new EY4UKY.ADYaiT(), "004", e);
            return false;
        }
    }

    public final void De4eam() {
        GIi2tl.A2egSU a2egSU;
        FrameLayout frameLayout;
        if (this.f3187AYUAbz.getInteraction().getShake() == null || (a2egSU = this.GZqyMh) == null) {
            return;
        }
        int i = this.f2601EicXu4;
        if (i == 5 || i == 1) {
            this.f2606ExjC7D = 1;
        } else if (i == 4) {
            this.f2606ExjC7D = 3;
        } else {
            this.f2606ExjC7D = 2;
        }
        try {
            FrameLayout A4TApA2 = a2egSU.A4TApA(this.f2606ExjC7D, this.f3187AYUAbz.getInteraction().getShake(), new A2egSU(this));
            this.f2634H0qugq = A4TApA2;
            this.f2639HHLj6Q = true;
            if (A4TApA2 == null || (frameLayout = this.f2630GcSJYy) == null || this.f2669J3EcKw == 4) {
                return;
            }
            frameLayout.addView(A4TApA2);
            this.f2630GcSJYy.bringChildToFront(this.f2634H0qugq);
            this.f2630GcSJYy.requestLayout();
            this.f2630GcSJYy.invalidate();
            this.f2669J3EcKw = 4;
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 018: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    public final synchronized void DjONCG() {
        AcNBzu acNBzu = this;
        synchronized (this) {
            try {
                int i = acNBzu.f2669J3EcKw;
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                if (acNBzu.f2599EdhSi6 == 2 && acNBzu.f2630GcSJYy != null && acNBzu.GZqyMh != null && i == 3) {
                    FrameLayout frameLayout = acNBzu.f2634H0qugq;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    FrameLayout frameLayout2 = acNBzu.f2655IDXjOL;
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(8);
                    }
                    if (acNBzu.f2633H0R8Px == null) {
                        int i3 = acNBzu.f2601EicXu4;
                        if (i3 == 5 || i3 == 1) {
                            GIi2tl.A2egSU a2egSU = acNBzu.GZqyMh;
                            a2egSU.getClass();
                            FrameLayout frameLayout3 = new FrameLayout(a2egSU.f2994A4TApA);
                            frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            frameLayout3.setBackgroundColor(Color.parseColor("#42000000"));
                            FrameLayout frameLayout4 = new FrameLayout(a2egSU.f2994A4TApA);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2egSU.A2egSU((float) (a2egSU.f2995A5SV6n * 0.22d)), a2egSU.A2egSU((float) (a2egSU.f2995A5SV6n * 0.06d)));
                            layoutParams.gravity = 17;
                            frameLayout4.setLayoutParams(layoutParams);
                            ImageView imageView = new ImageView(a2egSU.f2994A4TApA);
                            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2egSU.A2egSU((float) (a2egSU.f2995A5SV6n * 0.117d)), a2egSU.A2egSU((float) (a2egSU.f2995A5SV6n * 0.05d)));
                            layoutParams2.gravity = 8388691;
                            imageView.setLayoutParams(layoutParams2);
                            imageView.setImageResource(2131231427);
                            FrameLayout frameLayout5 = new FrameLayout(a2egSU.f2994A4TApA);
                            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a2egSU.A2egSU((float) (a2egSU.f2995A5SV6n * 0.13d)), a2egSU.A2egSU((float) (a2egSU.f2995A5SV6n * 0.05d)));
                            layoutParams3.gravity = 8388693;
                            layoutParams3.setMargins(0, 0, a2egSU.A2egSU(2.0f), a2egSU.A2egSU(4.0f));
                            frameLayout5.setLayoutParams(layoutParams3);
                            frameLayout3.addView(frameLayout4);
                            frameLayout3.addView(imageView);
                            frameLayout3.addView(frameLayout5);
                            a2egSU.f3012B9tovu = frameLayout5;
                            a2egSU.f3013BChYOn = frameLayout4;
                            acNBzu.f2633H0R8Px = frameLayout3;
                        } else {
                            GIi2tl.A2egSU a2egSU2 = acNBzu.GZqyMh;
                            Bitmap bitmap = acNBzu.f2635H1wUHe;
                            String apkname = acNBzu.f3187AYUAbz.getMaterial().getApkname();
                            a2egSU2.getClass();
                            FrameLayout frameLayout6 = new FrameLayout(a2egSU2.f2994A4TApA);
                            frameLayout6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            frameLayout6.setBackgroundColor(Color.parseColor("#42000000"));
                            FrameLayout frameLayout7 = new FrameLayout(a2egSU2.f2994A4TApA);
                            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams4.gravity = 17;
                            frameLayout7.setLayoutParams(layoutParams4);
                            LinearLayout A5SV6n2 = a2egSU2.A5SV6n(-2, 1.0f, -2, 1);
                            A5SV6n2.setBackgroundColor(0);
                            frameLayout7.addView(A5SV6n2);
                            frameLayout6.addView(frameLayout7);
                            if (bitmap != null) {
                                try {
                                    ImageView imageView2 = new ImageView(a2egSU2.f2994A4TApA);
                                    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.22d)), a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.16d)));
                                    layoutParams5.gravity = 1;
                                    imageView2.setLayoutParams(layoutParams5);
                                    imageView2.setImageBitmap(bitmap);
                                    A5SV6n2.addView(imageView2);
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                            if (apkname == null || apkname.isEmpty()) {
                                View frameLayout8 = new FrameLayout(a2egSU2.f2994A4TApA);
                                frameLayout8.setLayoutParams(new FrameLayout.LayoutParams(a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.22d)), a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.07d))));
                                A5SV6n2.addView(frameLayout8);
                            } else {
                                FrameLayout frameLayout9 = new FrameLayout(a2egSU2.f2994A4TApA);
                                frameLayout9.setLayoutParams(new FrameLayout.LayoutParams(a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.22d)), a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.07d))));
                                frameLayout9.setBackgroundColor(Color.parseColor("#00000000"));
                                TextView textView = new TextView(a2egSU2.f2994A4TApA);
                                FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
                                layoutParams6.gravity = 17;
                                textView.setText(apkname);
                                textView.setTextSize(11.0f);
                                textView.setEllipsize(TextUtils.TruncateAt.END);
                                textView.setMaxLines(1);
                                int i4 = a2egSU2.f2995A5SV6n;
                                if (i4 <= 180) {
                                    textView.setTextSize(8.0f);
                                } else if (i4 <= 240) {
                                    textView.setTextSize(9.0f);
                                } else if (i4 <= 300) {
                                    textView.setTextSize(10.0f);
                                }
                                textView.setTextColor(Color.parseColor("#ffffffff"));
                                frameLayout9.addView(textView, layoutParams6);
                                A5SV6n2.addView(frameLayout9);
                            }
                            FrameLayout frameLayout10 = new FrameLayout(a2egSU2.f2994A4TApA);
                            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.22d)), a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.06d)));
                            layoutParams7.gravity = 17;
                            frameLayout10.setLayoutParams(layoutParams7);
                            A5SV6n2.addView(frameLayout10);
                            int i5 = a2egSU2.f2993A2egSU;
                            if (i5 != 2 && i5 != 3) {
                                ImageView imageView3 = new ImageView(a2egSU2.f2994A4TApA);
                                FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.117d)), a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.05d)));
                                layoutParams8.gravity = 8388691;
                                layoutParams8.setMargins(a2egSU2.A2egSU(8.0f), 0, 0, a2egSU2.A2egSU(8.0f));
                                imageView3.setLayoutParams(layoutParams8);
                                imageView3.setImageResource(2131231427);
                                frameLayout6.addView(imageView3);
                            }
                            FrameLayout frameLayout11 = new FrameLayout(a2egSU2.f2994A4TApA);
                            FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.13d)), a2egSU2.A2egSU((float) (a2egSU2.f2995A5SV6n * 0.05d)));
                            layoutParams9.gravity = 8388693;
                            layoutParams9.setMargins(0, 0, a2egSU2.A2egSU(4.0f), a2egSU2.A2egSU(4.0f));
                            frameLayout11.setLayoutParams(layoutParams9);
                            frameLayout6.addView(frameLayout11);
                            a2egSU2.f3012B9tovu = frameLayout11;
                            a2egSU2.f3013BChYOn = frameLayout10;
                            acNBzu = this;
                            acNBzu.f2633H0R8Px = frameLayout6;
                        }
                        if (acNBzu.f2633H0R8Px == null) {
                        } else {
                            GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A4TApA(acNBzu, 5));
                        }
                    } else {
                        GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new A4TApA(acNBzu, 0));
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void DuwtYk(int i, LinearLayout linearLayout, int i2, String str) {
        GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new AMqCpz(this, i, i2, str, linearLayout, 0));
    }

    public final void EGM26s(Context context, View view) {
        if (view == null || this.f2622GEYgCP.getIconurl() == null || this.f2622GEYgCP.getIconurl().isEmpty()) {
            return;
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        GnQT2j.AcNBzu A2egSU2 = GnQT2j.AcNBzu.A2egSU();
        String iconurl = this.f2622GEYgCP.getIconurl();
        AZOQYO.ARc23Z aRc23Z = new AZOQYO.ARc23Z();
        aRc23Z.f366AzWtSf = this;
        aRc23Z.f363AcNBzu = imageView;
        aRc23Z.f365AmA8tU = (LinearLayout) view;
        aRc23Z.f364AlLFFp = context;
        A2egSU2.A4TApA(iconurl, aRc23Z);
    }

    public final void EH1KK8(Context context, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (linearLayout != null) {
            try {
                TextView textView = new TextView(context);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                textView.setTextSize(17.0f);
                int i = this.f2602EmJGcg;
                if (i <= 180) {
                    textView.setTextSize(11.0f);
                } else if (i <= 240) {
                    textView.setTextSize(13.0f);
                } else if (i <= 300) {
                    textView.setTextSize(15.0f);
                }
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setMaxLines(2);
                textView.setText(this.f2632GnQT2j);
                textView.setTextColor(Color.parseColor((String) AZOQYO.ARc23Z.f361B3GDIM.f365AmA8tU));
                textView.setGravity(8388691);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 16;
                linearLayout.addView(textView, layoutParams);
            } catch (Exception e) {
                CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 012: "), new EY4UKY.ADYaiT(), "004", e);
            }
        }
        if (linearLayout2 != null) {
            try {
                if (this.f2622GEYgCP.getApkname() == null || this.f2622GEYgCP.getApkname().isEmpty()) {
                    return;
                }
                TextView textView2 = new TextView(context);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                textView2.setTextSize(12.0f);
                int i2 = this.f2602EmJGcg;
                if (i2 <= 180) {
                    textView2.setTextSize(9.0f);
                } else if (i2 <= 240) {
                    textView2.setTextSize(10.0f);
                } else if (i2 <= 300) {
                    textView2.setTextSize(11.0f);
                }
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setMaxLines(1);
                textView2.setTextColor(Color.parseColor((String) AZOQYO.ARc23Z.f361B3GDIM.f366AzWtSf));
                textView2.setText(this.f2622GEYgCP.getApkname());
                textView2.setGravity(8388691);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.gravity = 16;
                linearLayout2.addView(textView2, layoutParams2);
            } catch (Exception e2) {
                CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 013: "), new EY4UKY.ADYaiT(), "004", e2);
            }
        }
    }

    public final void EPdU4G(View view) {
        try {
            ((ViewGroup) view).addView(new GIi2tl.A4TApA(GJee0v.A2egSU.A4TApA(this.f3185ARc23Z)), new FrameLayout.LayoutParams(-1, -1));
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 033: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:
    
        if (r7 != 3) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean EQurEW(java.lang.String r7, int r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: FOAO9d.AcNBzu.EQurEW(java.lang.String, int, boolean):boolean");
    }

    public final boolean EUIRHA(Context context, String str) {
        if (this.f2623GGG1xW == 1 && context != null && str != null && !str.isEmpty()) {
            String str2 = context.getExternalCacheDir() + "/nmssp_download/";
            String deeplink = this.f2622GEYgCP.getDeeplink();
            this.f3253EQurEW = JrXYwF.A4TApA.A5SV6n(deeplink);
            try {
                SQLiteDatabase writableDatabase = new GnQT2j.A2egSU(context).getWritableDatabase();
                GnQT2j.AZkASS A2egSU2 = GnQT2j.A2egSU.A2egSU(writableDatabase, deeplink);
                if (A2egSU2.f3127ADYaiT > 0) {
                    try {
                        if (GnQT2j.AYUAbz.A2egSU(new File(str2, A2egSU2.f3124A2egSU)) == 0) {
                            A2egSU2.f3127ADYaiT = 0;
                            GnQT2j.A2egSU.A4TApA(writableDatabase, A2egSU2);
                            return false;
                        }
                        if (A2egSU2.f3127ADYaiT == A2egSU2.f3126A5SV6n) {
                            this.f3196B2KMhB = 2;
                            return true;
                        }
                    } catch (Exception e) {
                        new EY4UKY.ADYaiT().AmA8tU("004", "NMExpressFeedImpl 005: " + e.getMessage(), e);
                    }
                }
            } catch (Exception e2) {
                CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMExpressFeedImpl 004: "), new EY4UKY.ADYaiT(), "004", e2);
            }
        }
        return false;
    }

    public final void EY4UKY(int i) {
        HandlerThread handlerThread = this.f2648HieBYM;
        if (handlerThread == null) {
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        if (!handlerThread.isAlive()) {
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        ASJ6gh aSJ6gh = this.f2647Hdahpu;
        if (aSJ6gh != null) {
            synchronized (aSJ6gh) {
                try {
                    ASJ6gh aSJ6gh2 = this.f2647Hdahpu;
                    if (aSJ6gh2 != null) {
                        Message obtainMessage = aSJ6gh2.obtainMessage();
                        obtainMessage.what = i;
                        this.f2647Hdahpu.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void EdQ5bb(Context context, LinearLayout linearLayout) {
        int i;
        if (linearLayout == null) {
            return;
        }
        this.f2649Hjvs0g = NOd7IU.AlLFFp.AMqCpz(context, (int) (this.f2602EmJGcg * 0.06d));
        int i2 = this.f2601EicXu4;
        if (i2 == 1 || i2 == 5) {
            this.f2649Hjvs0g = NOd7IU.AlLFFp.AMqCpz(context, (int) (this.f2602EmJGcg * 0.05d));
            i = 2;
        } else {
            i = 1;
        }
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new AaHO0E(this, linearLayout, context));
        try {
            this.f3208BV3sI0 = new Fyurov.ADYaiT(context, this.f2602EmJGcg, i, this.f2623GGG1xW == 1 ? this.f2610FG7pZc ? 4 : 1 : 5, new A2egSU(this));
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 16;
            frameLayout.setLayoutParams(layoutParams);
            linearLayout.addView(frameLayout);
            FrameLayout frameLayout2 = this.f3208BV3sI0.f2900AmA8tU;
            if (frameLayout2 != null) {
                frameLayout.addView(frameLayout2);
            }
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 014: "), new EY4UKY.ADYaiT(), "004", e);
        }
        this.H6qKiO = this.f3208BV3sI0.f2899AlLFFp;
        this.Ddcejp = new ASJ6gh(this, Looper.getMainLooper(), 6);
    }

    public final void EdhSi6(Context context, LinearLayout linearLayout) {
        if (this.f2623GGG1xW != 1 || linearLayout == null) {
            return;
        }
        AZOQYO.A2egSU a2egSU = new AZOQYO.A2egSU();
        Fyurov.AZOQYO azoqyo = a2egSU.f2939A2egSU;
        azoqyo.f2932ARc23Z = false;
        azoqyo.f2929A4TApA = linearLayout;
        azoqyo.f2928A2egSU = 2;
        azoqyo.f2933ASJ6gh = 55;
        Material material = this.f2622GEYgCP;
        azoqyo.f2930A5SV6n = context;
        azoqyo.f2931ADYaiT = material;
        azoqyo.AMqCpz = new AZkASS.ARc23Z(13, this);
        a2egSU.A2egSU();
    }

    @Override // HFjH17.ASJ6gh
    public final void onError(int i, int i2) {
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
        B4ZgIw("Show failure", "1", "素材不可用");
        new EY4UKY.ADYaiT().AmA8tU("004", NOd7IU.AlLFFp.ASJ6gh(i, "NMExpressFeedAdImpl 006: 视频错误，what = "), null);
        BTvldC("1", "视频素材出现错误");
        D07BeM(this.f3187AYUAbz);
    }
}
