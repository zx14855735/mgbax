package com.alliance.ssp.ad.activity;

import ADYaiT.CtFAbx;
import Dphsd2.AaHO0E;
import Dphsd2.AcNBzu;
import Dphsd2.AmA8tU;
import FZu94u.A4TApA;
import Fyurov.ASJ6gh;
import Fyurov.AZOQYO;
import Fyurov.B4ZgIw;
import GJee0v.A2egSU;
import GJee0v.A5SV6n;
import GJee0v.AZOQYO;
import GnQT2j.ARc23Z;
import GnQT2j.AYUAbz;
import GnQT2j.AZkASS;
import HFjH17.ADYaiT;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.bean.Interaction;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.Shake;
import com.alliance.ssp.ad.template.SAAllianceContainerView;
import com.bumptech.glide.request.RequestOptions;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.base.views.r;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class NMRewardVideoActivity extends Activity {

    /* renamed from: F1loUV, reason: collision with root package name */
    public static A4TApA f9613F1loUV;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f9616AmA8tU;

    /* renamed from: B25kr6, reason: collision with root package name */
    public GhvxjZ.A4TApA f9618B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public FrameLayout f9619B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ADYaiT f9620B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public View f9621B4ZgIw;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public SAAllianceAdData f9650CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public Material f9651D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public String f9652D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public ASJ6gh f9653D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public Shake f9654D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public int f9655D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public boolean f9656D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public int f9657DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public Fyurov.ADYaiT f9658DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public long f9659DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public int f9660DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public int f9661DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public int f9662DXnQ0V;
    public int DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public int f9663DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public boolean f9664DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public boolean f9665DdagTj;
    public boolean Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public boolean f9666De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public boolean f9667DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public int f9668Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public boolean f9669DuwtYk;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public int f9670DvK7DB;

    /* renamed from: DyaChj, reason: collision with root package name */
    public ImageView f9671DyaChj;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public ImageView f9672ECyGFg;

    /* renamed from: EGM26s, reason: collision with root package name */
    public ImageView f9673EGM26s;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public AZkASS.ADYaiT f9674EH1KK8;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public AcNBzu f9675EPdU4G;

    /* renamed from: EQurEW, reason: collision with root package name */
    public AcNBzu f9676EQurEW;

    /* renamed from: EUIRHA, reason: collision with root package name */
    public AcNBzu f9677EUIRHA;

    /* renamed from: EY4UKY, reason: collision with root package name */
    public AcNBzu f9678EY4UKY;
    public AcNBzu EdQ5bb;

    /* renamed from: EdhSi6, reason: collision with root package name */
    public Cd8JRx.ADYaiT f9679EdhSi6;

    /* renamed from: EiK8oA, reason: collision with root package name */
    public boolean f9680EiK8oA;

    /* renamed from: EicXu4, reason: collision with root package name */
    public FrameLayout f9681EicXu4;

    /* renamed from: EmJGcg, reason: collision with root package name */
    public int f9682EmJGcg;

    /* renamed from: ErKPGd, reason: collision with root package name */
    public boolean f9683ErKPGd;

    /* renamed from: EsrwYR, reason: collision with root package name */
    public boolean f9684EsrwYR;

    /* renamed from: EwN40Z, reason: collision with root package name */
    public boolean f9685EwN40Z;

    /* renamed from: ExjC7D, reason: collision with root package name */
    public int f9686ExjC7D;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public WeakReference f9614AcNBzu = null;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f9615AlLFFp = false;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public NMRewardVideoActivity f9617AzWtSf = null;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public FrameLayout f9622B7CMnp = null;

    /* renamed from: B9tovu, reason: collision with root package name */
    public LinearLayout f9623B9tovu = null;

    /* renamed from: BChYOn, reason: collision with root package name */
    public LinearLayout f9624BChYOn = null;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public LinearLayout f9625BI9f7h = null;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public LinearLayout f9626BIYEnU = null;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public LinearLayout f9627BJ7GGh = null;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public LinearLayout f9628BNL6CD = null;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public LinearLayout f9629BPw6Q8 = null;

    /* renamed from: BTvldC, reason: collision with root package name */
    public FrameLayout f9630BTvldC = null;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public FrameLayout f9631BV3sI0 = null;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public FrameLayout f9632BmvVmW = null;

    /* renamed from: BniPrB, reason: collision with root package name */
    public FrameLayout f9633BniPrB = null;
    public FrameLayout BpkvW3 = null;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public FrameLayout f9634C2rE4F = null;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public TextView f9635C4FrIb = null;

    /* renamed from: CASmeH, reason: collision with root package name */
    public TextView f9636CASmeH = null;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public TextView f9637CNPG0E = null;

    /* renamed from: COJEAR, reason: collision with root package name */
    public TextView f9638COJEAR = null;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public TextView f9639CQhlFr = null;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public TextView f9640CSDoyG = null;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public TextView f9641CTkVKb = null;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public TextView f9642CcAIMM = null;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public ImageView f9643Cd8JRx = null;

    /* renamed from: CikNvS, reason: collision with root package name */
    public ImageView f9644CikNvS = null;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public ImageView f9645CkXcdM = null;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public ImageView f9646CmUvjW = null;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public LinearLayout f9647CqNSpT = null;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public LinearLayout f9648CrfGsy = null;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public LinearLayout f9649CtFAbx = null;

    public NMRewardVideoActivity() {
        new AtomicInteger(0);
        this.f9650CtxOCS = null;
        this.f9655D8cQ8b = 0;
        this.f9656D9tr6l = false;
        this.f9657DAk1zC = 0;
        this.f9658DG07BK = null;
        this.f9661DV2E8K = 0;
        this.f9662DXnQ0V = 1;
        this.f9664DcUJf1 = false;
        this.f9665DdagTj = false;
        this.Ddcejp = false;
        this.f9666De4eam = false;
        this.f9667DjONCG = false;
        this.f9668Dphsd2 = 0;
        this.f9669DuwtYk = false;
        this.f9670DvK7DB = 0;
        this.f9679EdhSi6 = null;
        this.f9683ErKPGd = false;
        this.f9685EwN40Z = false;
        this.f9686ExjC7D = 0;
    }

    public static Bitmap A2egSU(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        float f = 80;
        float f2 = 1.0f * f;
        float width = f2 / bitmap.getWidth();
        float height = f2 / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(width, height);
        Bitmap createBitmap = Bitmap.createBitmap(80, 80, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f3 = 16;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, f), f3, f3, paint);
        return createBitmap;
    }

    public static Bitmap A4TApA(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
                return mediaMetadataRetriever.getFrameAtTime((Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000) - 1000, 3);
            } catch (RuntimeException e) {
                e.printStackTrace();
                mediaMetadataRetriever.release();
                return null;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static void AMqCpz(NMRewardVideoActivity nMRewardVideoActivity, String str) {
        nMRewardVideoActivity.getClass();
        int i = AZOQYO.f3039AcNBzu;
        SAAllianceAdData copy = nMRewardVideoActivity.f9650CtxOCS.copy();
        if (copy != null) {
            if (copy.getMaterial() == null) {
                copy.setMaterial(new Material(null));
            }
            copy.getMaterial().setLdp(str);
            if (copy.getInteraction() == null) {
                copy.setInteraction(new Interaction(null));
            }
            copy.setInteraction(nMRewardVideoActivity.f9650CtxOCS.getInteraction());
            Intent intent = new Intent(nMRewardVideoActivity, (Class<?>) SAAllianceWebViewActivity.class);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra("extra_name_land_page_ad_data", copy);
            nMRewardVideoActivity.startActivity(intent);
        }
    }

    public final void A5SV6n(ImageView imageView, String str) {
        if (!this.f9680EiK8oA) {
            GnQT2j.AcNBzu.A2egSU().A4TApA(str, new AmA8tU(this, imageView, 0));
            return;
        }
        WeakReference weakReference = this.f9614AcNBzu;
        if (weakReference != null) {
            try {
                if (weakReference.get() != null) {
                    if (((Activity) weakReference.get()).isDestroyed()) {
                        return;
                    }
                    Activity activity = (Activity) weakReference.get();
                    com.bumptech.glide.A4TApA.A5SV6n(activity).A4TApA(activity).AaHO0E(str).apply((RequestOptions) new RequestOptions().B2KMhB(new A5SV6n(weakReference), true)).BpkvW3(0.1f).BTvldC(imageView);
                    return;
                }
            } catch (Exception e) {
                e.getMessage();
                int i = AZOQYO.f3039AcNBzu;
                return;
            }
        }
        Activity A5SV6n2 = A2egSU.A5SV6n();
        if (A5SV6n2 == null || A5SV6n2.isDestroyed()) {
            return;
        }
        com.bumptech.glide.A4TApA.A5SV6n(A5SV6n2).A4TApA(A5SV6n2).AaHO0E(str).BpkvW3(0.1f).BTvldC(imageView);
    }

    public final void ADYaiT(NMRewardVideoActivity nMRewardVideoActivity, View view) {
        int i;
        if (view == null) {
            return;
        }
        this.f9668Dphsd2 = 52;
        if (this.f9665DdagTj) {
            this.f9668Dphsd2 = MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA;
            i = 5;
        } else {
            i = 4;
        }
        try {
            this.f9658DG07BK = new Fyurov.ADYaiT(nMRewardVideoActivity, this.f9668Dphsd2, i, this.f9660DUi7mC == 1 ? this.f9669DuwtYk ? 4 : 1 : 5, new AaHO0E(this));
            FrameLayout frameLayout = new FrameLayout(nMRewardVideoActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 16;
            frameLayout.setLayoutParams(layoutParams);
            ((LinearLayout) view).addView(frameLayout);
            FrameLayout frameLayout2 = this.f9658DG07BK.f2900AmA8tU;
            if (frameLayout2 != null) {
                frameLayout.addView(frameLayout2);
            }
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 014: "), new EY4UKY.ADYaiT(), "004", e);
        }
        this.f9679EdhSi6 = this.f9658DG07BK.f2899AlLFFp;
        A4TApA a4TApA = f9613F1loUV;
        if (a4TApA != null) {
            a4TApA.Ddcejp = new DG07BK.A2egSU(this, Looper.getMainLooper(), 2);
        }
    }

    public final void ARc23Z(boolean z) {
        ASJ6gh aSJ6gh;
        if (!z || (aSJ6gh = this.f9653D6yqiO) == null || this.f9657DAk1zC != 1 || f9613F1loUV == null) {
            return;
        }
        aSJ6gh.A4TApA(this.f9654D8MqeW.getAccelerationDefault(), this.f9654D8MqeW.getRotationAngleDefault(), this.f9654D8MqeW.getOperationTimeDefault(), this.f9654D8MqeW.getDirection());
        A4TApA a4TApA = f9613F1loUV;
        SAAllianceAdData sAAllianceAdData = a4TApA.f3187AYUAbz;
        if (sAAllianceAdData == null || sAAllianceAdData.getInteraction() == null || a4TApA.f3187AYUAbz.getInteraction().getShake() == null) {
            return;
        }
        a4TApA.f3187AYUAbz.getInteraction().getShake().setAcceleration(a4TApA.f3187AYUAbz.getInteraction().getShake().getAccelerationDefault());
        a4TApA.f3187AYUAbz.getInteraction().getShake().setRotationAngle(a4TApA.f3187AYUAbz.getInteraction().getShake().getRotationAngleDefault());
        a4TApA.f3187AYUAbz.getInteraction().getShake().setOperationTime(a4TApA.f3187AYUAbz.getInteraction().getShake().getOperationTimeDefault());
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        if (r4 != 3) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean ASJ6gh(java.lang.String r6, int r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.activity.NMRewardVideoActivity.ASJ6gh(java.lang.String, int, boolean):boolean");
    }

    public final void AYUAbz() {
        A4TApA a4TApA = f9613F1loUV;
        if (a4TApA != null) {
            B4ZgIw b4ZgIw = a4TApA.G16Pvp;
            if (b4ZgIw != null) {
                b4ZgIw.A4TApA();
            }
            ADYaiT aDYaiT = this.f9620B3GDIM;
            if (aDYaiT != null) {
                boolean AcNBzu2 = aDYaiT.AcNBzu();
                A4TApA a4TApA2 = f9613F1loUV;
                if (a4TApA2 != null && AcNBzu2) {
                    a4TApA2.CTkVKb(a4TApA2.f3187AYUAbz);
                }
            }
            this.f9656D9tr6l = true;
            ASJ6gh aSJ6gh = this.f9653D6yqiO;
            if (aSJ6gh != null) {
                aSJ6gh.A2egSU();
            }
        }
    }

    public final void AZOQYO() {
        A4TApA a4TApA = f9613F1loUV;
        if (a4TApA != null) {
            B4ZgIw b4ZgIw = a4TApA.G16Pvp;
            if (b4ZgIw != null) {
                b4ZgIw.A5SV6n();
            }
            this.f9667DjONCG = false;
            ADYaiT aDYaiT = this.f9620B3GDIM;
            if (aDYaiT != null && aDYaiT.AmA8tU()) {
                A4TApA a4TApA2 = f9613F1loUV;
                a4TApA2.BPw6Q8(a4TApA2.f3187AYUAbz);
            }
            this.f9656D9tr6l = false;
            ASJ6gh aSJ6gh = this.f9653D6yqiO;
            if (aSJ6gh != null) {
                aSJ6gh.AMqCpz();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [Dphsd2.AcNBzu] */
    /* JADX WARN: Type inference failed for: r0v2, types: [Dphsd2.AcNBzu] */
    /* JADX WARN: Type inference failed for: r0v3, types: [Dphsd2.AcNBzu] */
    /* JADX WARN: Type inference failed for: r0v4, types: [Dphsd2.AcNBzu] */
    /* JADX WARN: Type inference failed for: r0v5, types: [Dphsd2.AcNBzu] */
    public final void AZkASS() {
        this.f9674EH1KK8 = new AZkASS.ADYaiT(2, this);
        final int i = 0;
        this.f9675EPdU4G = new View.OnClickListener(this) { // from class: Dphsd2.AcNBzu

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ NMRewardVideoActivity f2457AlLFFp;

            {
                this.f2457AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GnQT2j.AZOQYO azoqyo;
                NMRewardVideoActivity nMRewardVideoActivity = this.f2457AlLFFp;
                switch (i) {
                    case 0:
                        if (NMRewardVideoActivity.f9613F1loUV != null) {
                            if (nMRewardVideoActivity.f9655D8cQ8b != 1 || nMRewardVideoActivity.f9660DUi7mC == 1) {
                                nMRewardVideoActivity.ASJ6gh("user", 0, false);
                                break;
                            }
                        } else {
                            nMRewardVideoActivity.getClass();
                            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                            break;
                        }
                        break;
                    case 1:
                        FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA2 != null) {
                            if (a4TApA2.f3202BI9f7h <= 0.0f && a4TApA2.BniPrB()) {
                                if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                                } else {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                                }
                                if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                    FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA3.f3203BIYEnU = true;
                                    a4TApA3.BV3sI0();
                                    if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                }
                            }
                            if (nMRewardVideoActivity.f9684EsrwYR) {
                                HFjH17.ADYaiT aDYaiT = nMRewardVideoActivity.f9620B3GDIM;
                                if (aDYaiT != null) {
                                    aDYaiT.AlLFFp();
                                }
                                FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                if (a4TApA4 != null) {
                                    a4TApA4.Cd8JRx(a4TApA4.f3187AYUAbz);
                                    NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                                    NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                                    FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA5.getClass();
                                    new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA5.f3187AYUAbz, a4TApA5.f3200B9tovu, "");
                                    G58fqA.A2egSU a2egSU = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                                    if (a2egSU != null) {
                                        a2egSU.A4TApA();
                                        break;
                                    }
                                }
                            } else {
                                GhvxjZ.A4TApA a4TApA6 = new GhvxjZ.A4TApA(nMRewardVideoActivity, 1);
                                a4TApA6.f3084B7CMnp = null;
                                a4TApA6.f3085B9tovu = null;
                                nMRewardVideoActivity.f9618B25kr6 = a4TApA6;
                                a4TApA6.setCanceledOnTouchOutside(false);
                                nMRewardVideoActivity.f9618B25kr6.f3085B9tovu = nMRewardVideoActivity.getResources().getString(2131886632);
                                GhvxjZ.A4TApA a4TApA7 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu = nMRewardVideoActivity.f9677EUIRHA;
                                a4TApA7.f3080B25kr6 = a4TApA7.getContext().getString(2131886624);
                                a4TApA7.f3082B3GDIM = acNBzu;
                                GhvxjZ.A4TApA a4TApA8 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu2 = nMRewardVideoActivity.f9678EY4UKY;
                                a4TApA8.f3079AzWtSf = a4TApA8.getContext().getString(2131886628);
                                a4TApA8.f3081B2KMhB = acNBzu2;
                                try {
                                    if (!nMRewardVideoActivity.isFinishing() && !nMRewardVideoActivity.f9618B25kr6.isShowing() && !nMRewardVideoActivity.f9667DjONCG) {
                                        nMRewardVideoActivity.f9618B25kr6.show();
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                } catch (Exception e) {
                                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 011: "), new EY4UKY.ADYaiT(), "004", e);
                                    return;
                                }
                            }
                        }
                        break;
                    case 2:
                        FZu94u.A4TApA a4TApA9 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                        HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT2 != null) {
                            aDYaiT2.AlLFFp();
                        }
                        FZu94u.A4TApA a4TApA10 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA10 != null) {
                            a4TApA10.Cd8JRx(a4TApA10.f3187AYUAbz);
                            NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            FZu94u.A4TApA a4TApA11 = NMRewardVideoActivity.f9613F1loUV;
                            a4TApA11.getClass();
                            new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA11.f3187AYUAbz, a4TApA11.f3200B9tovu, "");
                            G58fqA.A2egSU a2egSU2 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU2 != null) {
                                a2egSU2.A4TApA();
                                break;
                            }
                        }
                        break;
                    case 3:
                        FZu94u.A4TApA a4TApA12 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                        nMRewardVideoActivity.AZOQYO();
                        break;
                    default:
                        FZu94u.A4TApA a4TApA13 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA14 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA14 != null && a4TApA14.f3202BI9f7h <= 0.0f && a4TApA14.BniPrB()) {
                            if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                            } else {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                            }
                            if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                FZu94u.A4TApA a4TApA15 = NMRewardVideoActivity.f9613F1loUV;
                                a4TApA15.f3203BIYEnU = true;
                                a4TApA15.BV3sI0();
                                if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                    nMRewardVideoActivity.AYUAbz();
                                    break;
                                }
                            }
                        }
                        HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT3 != null) {
                            aDYaiT3.AlLFFp();
                        }
                        try {
                            FZu94u.A4TApA a4TApA16 = NMRewardVideoActivity.f9613F1loUV;
                            if (a4TApA16 != null && (azoqyo = a4TApA16.f3251EH1KK8) != null && nMRewardVideoActivity.f9661DV2E8K == 1) {
                                azoqyo.A4TApA(a4TApA16.f3252EPdU4G.f3125A4TApA);
                            }
                        } catch (Exception e2) {
                            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 001: "), new EY4UKY.ADYaiT(), "004", e2);
                        }
                        FZu94u.A4TApA a4TApA17 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA17 != null) {
                            a4TApA17.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            G58fqA.A2egSU a2egSU3 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU3 != null) {
                                a2egSU3.A4TApA();
                                break;
                            }
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.f9676EQurEW = new View.OnClickListener(this) { // from class: Dphsd2.AcNBzu

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ NMRewardVideoActivity f2457AlLFFp;

            {
                this.f2457AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GnQT2j.AZOQYO azoqyo;
                NMRewardVideoActivity nMRewardVideoActivity = this.f2457AlLFFp;
                switch (i2) {
                    case 0:
                        if (NMRewardVideoActivity.f9613F1loUV != null) {
                            if (nMRewardVideoActivity.f9655D8cQ8b != 1 || nMRewardVideoActivity.f9660DUi7mC == 1) {
                                nMRewardVideoActivity.ASJ6gh("user", 0, false);
                                break;
                            }
                        } else {
                            nMRewardVideoActivity.getClass();
                            int i22 = GJee0v.AZOQYO.f3039AcNBzu;
                            break;
                        }
                        break;
                    case 1:
                        FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA2 != null) {
                            if (a4TApA2.f3202BI9f7h <= 0.0f && a4TApA2.BniPrB()) {
                                if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                                } else {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                                }
                                if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                    FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA3.f3203BIYEnU = true;
                                    a4TApA3.BV3sI0();
                                    if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                }
                            }
                            if (nMRewardVideoActivity.f9684EsrwYR) {
                                HFjH17.ADYaiT aDYaiT = nMRewardVideoActivity.f9620B3GDIM;
                                if (aDYaiT != null) {
                                    aDYaiT.AlLFFp();
                                }
                                FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                if (a4TApA4 != null) {
                                    a4TApA4.Cd8JRx(a4TApA4.f3187AYUAbz);
                                    NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                                    NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                                    FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA5.getClass();
                                    new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA5.f3187AYUAbz, a4TApA5.f3200B9tovu, "");
                                    G58fqA.A2egSU a2egSU = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                                    if (a2egSU != null) {
                                        a2egSU.A4TApA();
                                        break;
                                    }
                                }
                            } else {
                                GhvxjZ.A4TApA a4TApA6 = new GhvxjZ.A4TApA(nMRewardVideoActivity, 1);
                                a4TApA6.f3084B7CMnp = null;
                                a4TApA6.f3085B9tovu = null;
                                nMRewardVideoActivity.f9618B25kr6 = a4TApA6;
                                a4TApA6.setCanceledOnTouchOutside(false);
                                nMRewardVideoActivity.f9618B25kr6.f3085B9tovu = nMRewardVideoActivity.getResources().getString(2131886632);
                                GhvxjZ.A4TApA a4TApA7 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu = nMRewardVideoActivity.f9677EUIRHA;
                                a4TApA7.f3080B25kr6 = a4TApA7.getContext().getString(2131886624);
                                a4TApA7.f3082B3GDIM = acNBzu;
                                GhvxjZ.A4TApA a4TApA8 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu2 = nMRewardVideoActivity.f9678EY4UKY;
                                a4TApA8.f3079AzWtSf = a4TApA8.getContext().getString(2131886628);
                                a4TApA8.f3081B2KMhB = acNBzu2;
                                try {
                                    if (!nMRewardVideoActivity.isFinishing() && !nMRewardVideoActivity.f9618B25kr6.isShowing() && !nMRewardVideoActivity.f9667DjONCG) {
                                        nMRewardVideoActivity.f9618B25kr6.show();
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                } catch (Exception e) {
                                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 011: "), new EY4UKY.ADYaiT(), "004", e);
                                    return;
                                }
                            }
                        }
                        break;
                    case 2:
                        FZu94u.A4TApA a4TApA9 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                        HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT2 != null) {
                            aDYaiT2.AlLFFp();
                        }
                        FZu94u.A4TApA a4TApA10 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA10 != null) {
                            a4TApA10.Cd8JRx(a4TApA10.f3187AYUAbz);
                            NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            FZu94u.A4TApA a4TApA11 = NMRewardVideoActivity.f9613F1loUV;
                            a4TApA11.getClass();
                            new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA11.f3187AYUAbz, a4TApA11.f3200B9tovu, "");
                            G58fqA.A2egSU a2egSU2 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU2 != null) {
                                a2egSU2.A4TApA();
                                break;
                            }
                        }
                        break;
                    case 3:
                        FZu94u.A4TApA a4TApA12 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                        nMRewardVideoActivity.AZOQYO();
                        break;
                    default:
                        FZu94u.A4TApA a4TApA13 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA14 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA14 != null && a4TApA14.f3202BI9f7h <= 0.0f && a4TApA14.BniPrB()) {
                            if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                            } else {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                            }
                            if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                FZu94u.A4TApA a4TApA15 = NMRewardVideoActivity.f9613F1loUV;
                                a4TApA15.f3203BIYEnU = true;
                                a4TApA15.BV3sI0();
                                if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                    nMRewardVideoActivity.AYUAbz();
                                    break;
                                }
                            }
                        }
                        HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT3 != null) {
                            aDYaiT3.AlLFFp();
                        }
                        try {
                            FZu94u.A4TApA a4TApA16 = NMRewardVideoActivity.f9613F1loUV;
                            if (a4TApA16 != null && (azoqyo = a4TApA16.f3251EH1KK8) != null && nMRewardVideoActivity.f9661DV2E8K == 1) {
                                azoqyo.A4TApA(a4TApA16.f3252EPdU4G.f3125A4TApA);
                            }
                        } catch (Exception e2) {
                            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 001: "), new EY4UKY.ADYaiT(), "004", e2);
                        }
                        FZu94u.A4TApA a4TApA17 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA17 != null) {
                            a4TApA17.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            G58fqA.A2egSU a2egSU3 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU3 != null) {
                                a2egSU3.A4TApA();
                                break;
                            }
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.f9677EUIRHA = new View.OnClickListener(this) { // from class: Dphsd2.AcNBzu

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ NMRewardVideoActivity f2457AlLFFp;

            {
                this.f2457AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GnQT2j.AZOQYO azoqyo;
                NMRewardVideoActivity nMRewardVideoActivity = this.f2457AlLFFp;
                switch (i3) {
                    case 0:
                        if (NMRewardVideoActivity.f9613F1loUV != null) {
                            if (nMRewardVideoActivity.f9655D8cQ8b != 1 || nMRewardVideoActivity.f9660DUi7mC == 1) {
                                nMRewardVideoActivity.ASJ6gh("user", 0, false);
                                break;
                            }
                        } else {
                            nMRewardVideoActivity.getClass();
                            int i22 = GJee0v.AZOQYO.f3039AcNBzu;
                            break;
                        }
                        break;
                    case 1:
                        FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i32 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA2 != null) {
                            if (a4TApA2.f3202BI9f7h <= 0.0f && a4TApA2.BniPrB()) {
                                if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                                } else {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                                }
                                if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                    FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA3.f3203BIYEnU = true;
                                    a4TApA3.BV3sI0();
                                    if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                }
                            }
                            if (nMRewardVideoActivity.f9684EsrwYR) {
                                HFjH17.ADYaiT aDYaiT = nMRewardVideoActivity.f9620B3GDIM;
                                if (aDYaiT != null) {
                                    aDYaiT.AlLFFp();
                                }
                                FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                if (a4TApA4 != null) {
                                    a4TApA4.Cd8JRx(a4TApA4.f3187AYUAbz);
                                    NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                                    NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                                    FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA5.getClass();
                                    new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA5.f3187AYUAbz, a4TApA5.f3200B9tovu, "");
                                    G58fqA.A2egSU a2egSU = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                                    if (a2egSU != null) {
                                        a2egSU.A4TApA();
                                        break;
                                    }
                                }
                            } else {
                                GhvxjZ.A4TApA a4TApA6 = new GhvxjZ.A4TApA(nMRewardVideoActivity, 1);
                                a4TApA6.f3084B7CMnp = null;
                                a4TApA6.f3085B9tovu = null;
                                nMRewardVideoActivity.f9618B25kr6 = a4TApA6;
                                a4TApA6.setCanceledOnTouchOutside(false);
                                nMRewardVideoActivity.f9618B25kr6.f3085B9tovu = nMRewardVideoActivity.getResources().getString(2131886632);
                                GhvxjZ.A4TApA a4TApA7 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu = nMRewardVideoActivity.f9677EUIRHA;
                                a4TApA7.f3080B25kr6 = a4TApA7.getContext().getString(2131886624);
                                a4TApA7.f3082B3GDIM = acNBzu;
                                GhvxjZ.A4TApA a4TApA8 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu2 = nMRewardVideoActivity.f9678EY4UKY;
                                a4TApA8.f3079AzWtSf = a4TApA8.getContext().getString(2131886628);
                                a4TApA8.f3081B2KMhB = acNBzu2;
                                try {
                                    if (!nMRewardVideoActivity.isFinishing() && !nMRewardVideoActivity.f9618B25kr6.isShowing() && !nMRewardVideoActivity.f9667DjONCG) {
                                        nMRewardVideoActivity.f9618B25kr6.show();
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                } catch (Exception e) {
                                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 011: "), new EY4UKY.ADYaiT(), "004", e);
                                    return;
                                }
                            }
                        }
                        break;
                    case 2:
                        FZu94u.A4TApA a4TApA9 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                        HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT2 != null) {
                            aDYaiT2.AlLFFp();
                        }
                        FZu94u.A4TApA a4TApA10 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA10 != null) {
                            a4TApA10.Cd8JRx(a4TApA10.f3187AYUAbz);
                            NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            FZu94u.A4TApA a4TApA11 = NMRewardVideoActivity.f9613F1loUV;
                            a4TApA11.getClass();
                            new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA11.f3187AYUAbz, a4TApA11.f3200B9tovu, "");
                            G58fqA.A2egSU a2egSU2 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU2 != null) {
                                a2egSU2.A4TApA();
                                break;
                            }
                        }
                        break;
                    case 3:
                        FZu94u.A4TApA a4TApA12 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                        nMRewardVideoActivity.AZOQYO();
                        break;
                    default:
                        FZu94u.A4TApA a4TApA13 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA14 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA14 != null && a4TApA14.f3202BI9f7h <= 0.0f && a4TApA14.BniPrB()) {
                            if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                            } else {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                            }
                            if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                FZu94u.A4TApA a4TApA15 = NMRewardVideoActivity.f9613F1loUV;
                                a4TApA15.f3203BIYEnU = true;
                                a4TApA15.BV3sI0();
                                if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                    nMRewardVideoActivity.AYUAbz();
                                    break;
                                }
                            }
                        }
                        HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT3 != null) {
                            aDYaiT3.AlLFFp();
                        }
                        try {
                            FZu94u.A4TApA a4TApA16 = NMRewardVideoActivity.f9613F1loUV;
                            if (a4TApA16 != null && (azoqyo = a4TApA16.f3251EH1KK8) != null && nMRewardVideoActivity.f9661DV2E8K == 1) {
                                azoqyo.A4TApA(a4TApA16.f3252EPdU4G.f3125A4TApA);
                            }
                        } catch (Exception e2) {
                            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 001: "), new EY4UKY.ADYaiT(), "004", e2);
                        }
                        FZu94u.A4TApA a4TApA17 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA17 != null) {
                            a4TApA17.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            G58fqA.A2egSU a2egSU3 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU3 != null) {
                                a2egSU3.A4TApA();
                                break;
                            }
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.f9678EY4UKY = new View.OnClickListener(this) { // from class: Dphsd2.AcNBzu

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ NMRewardVideoActivity f2457AlLFFp;

            {
                this.f2457AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GnQT2j.AZOQYO azoqyo;
                NMRewardVideoActivity nMRewardVideoActivity = this.f2457AlLFFp;
                switch (i4) {
                    case 0:
                        if (NMRewardVideoActivity.f9613F1loUV != null) {
                            if (nMRewardVideoActivity.f9655D8cQ8b != 1 || nMRewardVideoActivity.f9660DUi7mC == 1) {
                                nMRewardVideoActivity.ASJ6gh("user", 0, false);
                                break;
                            }
                        } else {
                            nMRewardVideoActivity.getClass();
                            int i22 = GJee0v.AZOQYO.f3039AcNBzu;
                            break;
                        }
                        break;
                    case 1:
                        FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i32 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA2 != null) {
                            if (a4TApA2.f3202BI9f7h <= 0.0f && a4TApA2.BniPrB()) {
                                if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                                } else {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                                }
                                if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                    FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA3.f3203BIYEnU = true;
                                    a4TApA3.BV3sI0();
                                    if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                }
                            }
                            if (nMRewardVideoActivity.f9684EsrwYR) {
                                HFjH17.ADYaiT aDYaiT = nMRewardVideoActivity.f9620B3GDIM;
                                if (aDYaiT != null) {
                                    aDYaiT.AlLFFp();
                                }
                                FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                if (a4TApA4 != null) {
                                    a4TApA4.Cd8JRx(a4TApA4.f3187AYUAbz);
                                    NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                                    NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                                    FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA5.getClass();
                                    new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA5.f3187AYUAbz, a4TApA5.f3200B9tovu, "");
                                    G58fqA.A2egSU a2egSU = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                                    if (a2egSU != null) {
                                        a2egSU.A4TApA();
                                        break;
                                    }
                                }
                            } else {
                                GhvxjZ.A4TApA a4TApA6 = new GhvxjZ.A4TApA(nMRewardVideoActivity, 1);
                                a4TApA6.f3084B7CMnp = null;
                                a4TApA6.f3085B9tovu = null;
                                nMRewardVideoActivity.f9618B25kr6 = a4TApA6;
                                a4TApA6.setCanceledOnTouchOutside(false);
                                nMRewardVideoActivity.f9618B25kr6.f3085B9tovu = nMRewardVideoActivity.getResources().getString(2131886632);
                                GhvxjZ.A4TApA a4TApA7 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu = nMRewardVideoActivity.f9677EUIRHA;
                                a4TApA7.f3080B25kr6 = a4TApA7.getContext().getString(2131886624);
                                a4TApA7.f3082B3GDIM = acNBzu;
                                GhvxjZ.A4TApA a4TApA8 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu2 = nMRewardVideoActivity.f9678EY4UKY;
                                a4TApA8.f3079AzWtSf = a4TApA8.getContext().getString(2131886628);
                                a4TApA8.f3081B2KMhB = acNBzu2;
                                try {
                                    if (!nMRewardVideoActivity.isFinishing() && !nMRewardVideoActivity.f9618B25kr6.isShowing() && !nMRewardVideoActivity.f9667DjONCG) {
                                        nMRewardVideoActivity.f9618B25kr6.show();
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                } catch (Exception e) {
                                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 011: "), new EY4UKY.ADYaiT(), "004", e);
                                    return;
                                }
                            }
                        }
                        break;
                    case 2:
                        FZu94u.A4TApA a4TApA9 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i42 = GJee0v.AZOQYO.f3039AcNBzu;
                        HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT2 != null) {
                            aDYaiT2.AlLFFp();
                        }
                        FZu94u.A4TApA a4TApA10 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA10 != null) {
                            a4TApA10.Cd8JRx(a4TApA10.f3187AYUAbz);
                            NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            FZu94u.A4TApA a4TApA11 = NMRewardVideoActivity.f9613F1loUV;
                            a4TApA11.getClass();
                            new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA11.f3187AYUAbz, a4TApA11.f3200B9tovu, "");
                            G58fqA.A2egSU a2egSU2 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU2 != null) {
                                a2egSU2.A4TApA();
                                break;
                            }
                        }
                        break;
                    case 3:
                        FZu94u.A4TApA a4TApA12 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                        nMRewardVideoActivity.AZOQYO();
                        break;
                    default:
                        FZu94u.A4TApA a4TApA13 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA14 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA14 != null && a4TApA14.f3202BI9f7h <= 0.0f && a4TApA14.BniPrB()) {
                            if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                            } else {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                            }
                            if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                FZu94u.A4TApA a4TApA15 = NMRewardVideoActivity.f9613F1loUV;
                                a4TApA15.f3203BIYEnU = true;
                                a4TApA15.BV3sI0();
                                if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                    nMRewardVideoActivity.AYUAbz();
                                    break;
                                }
                            }
                        }
                        HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT3 != null) {
                            aDYaiT3.AlLFFp();
                        }
                        try {
                            FZu94u.A4TApA a4TApA16 = NMRewardVideoActivity.f9613F1loUV;
                            if (a4TApA16 != null && (azoqyo = a4TApA16.f3251EH1KK8) != null && nMRewardVideoActivity.f9661DV2E8K == 1) {
                                azoqyo.A4TApA(a4TApA16.f3252EPdU4G.f3125A4TApA);
                            }
                        } catch (Exception e2) {
                            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 001: "), new EY4UKY.ADYaiT(), "004", e2);
                        }
                        FZu94u.A4TApA a4TApA17 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA17 != null) {
                            a4TApA17.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            G58fqA.A2egSU a2egSU3 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU3 != null) {
                                a2egSU3.A4TApA();
                                break;
                            }
                        }
                        break;
                }
            }
        };
        final int i5 = 4;
        this.EdQ5bb = new View.OnClickListener(this) { // from class: Dphsd2.AcNBzu

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ NMRewardVideoActivity f2457AlLFFp;

            {
                this.f2457AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GnQT2j.AZOQYO azoqyo;
                NMRewardVideoActivity nMRewardVideoActivity = this.f2457AlLFFp;
                switch (i5) {
                    case 0:
                        if (NMRewardVideoActivity.f9613F1loUV != null) {
                            if (nMRewardVideoActivity.f9655D8cQ8b != 1 || nMRewardVideoActivity.f9660DUi7mC == 1) {
                                nMRewardVideoActivity.ASJ6gh("user", 0, false);
                                break;
                            }
                        } else {
                            nMRewardVideoActivity.getClass();
                            int i22 = GJee0v.AZOQYO.f3039AcNBzu;
                            break;
                        }
                        break;
                    case 1:
                        FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i32 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA2 != null) {
                            if (a4TApA2.f3202BI9f7h <= 0.0f && a4TApA2.BniPrB()) {
                                if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                                } else {
                                    NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                                }
                                if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                    FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA3.f3203BIYEnU = true;
                                    a4TApA3.BV3sI0();
                                    if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                }
                            }
                            if (nMRewardVideoActivity.f9684EsrwYR) {
                                HFjH17.ADYaiT aDYaiT = nMRewardVideoActivity.f9620B3GDIM;
                                if (aDYaiT != null) {
                                    aDYaiT.AlLFFp();
                                }
                                FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                if (a4TApA4 != null) {
                                    a4TApA4.Cd8JRx(a4TApA4.f3187AYUAbz);
                                    NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                                    NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                                    FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA5.getClass();
                                    new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA5.f3187AYUAbz, a4TApA5.f3200B9tovu, "");
                                    G58fqA.A2egSU a2egSU = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                                    if (a2egSU != null) {
                                        a2egSU.A4TApA();
                                        break;
                                    }
                                }
                            } else {
                                GhvxjZ.A4TApA a4TApA6 = new GhvxjZ.A4TApA(nMRewardVideoActivity, 1);
                                a4TApA6.f3084B7CMnp = null;
                                a4TApA6.f3085B9tovu = null;
                                nMRewardVideoActivity.f9618B25kr6 = a4TApA6;
                                a4TApA6.setCanceledOnTouchOutside(false);
                                nMRewardVideoActivity.f9618B25kr6.f3085B9tovu = nMRewardVideoActivity.getResources().getString(2131886632);
                                GhvxjZ.A4TApA a4TApA7 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu = nMRewardVideoActivity.f9677EUIRHA;
                                a4TApA7.f3080B25kr6 = a4TApA7.getContext().getString(2131886624);
                                a4TApA7.f3082B3GDIM = acNBzu;
                                GhvxjZ.A4TApA a4TApA8 = nMRewardVideoActivity.f9618B25kr6;
                                AcNBzu acNBzu2 = nMRewardVideoActivity.f9678EY4UKY;
                                a4TApA8.f3079AzWtSf = a4TApA8.getContext().getString(2131886628);
                                a4TApA8.f3081B2KMhB = acNBzu2;
                                try {
                                    if (!nMRewardVideoActivity.isFinishing() && !nMRewardVideoActivity.f9618B25kr6.isShowing() && !nMRewardVideoActivity.f9667DjONCG) {
                                        nMRewardVideoActivity.f9618B25kr6.show();
                                        nMRewardVideoActivity.AYUAbz();
                                        break;
                                    }
                                } catch (Exception e) {
                                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 011: "), new EY4UKY.ADYaiT(), "004", e);
                                    return;
                                }
                            }
                        }
                        break;
                    case 2:
                        FZu94u.A4TApA a4TApA9 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i42 = GJee0v.AZOQYO.f3039AcNBzu;
                        HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT2 != null) {
                            aDYaiT2.AlLFFp();
                        }
                        FZu94u.A4TApA a4TApA10 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA10 != null) {
                            a4TApA10.Cd8JRx(a4TApA10.f3187AYUAbz);
                            NMRewardVideoActivity.f9613F1loUV.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            FZu94u.A4TApA a4TApA11 = NMRewardVideoActivity.f9613F1loUV;
                            a4TApA11.getClass();
                            new EY4UKY.ADYaiT().B3GDIM(3, 1, a4TApA11.f3187AYUAbz, a4TApA11.f3200B9tovu, "");
                            G58fqA.A2egSU a2egSU2 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU2 != null) {
                                a2egSU2.A4TApA();
                                break;
                            }
                        }
                        break;
                    case 3:
                        FZu94u.A4TApA a4TApA12 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i52 = GJee0v.AZOQYO.f3039AcNBzu;
                        nMRewardVideoActivity.AZOQYO();
                        break;
                    default:
                        FZu94u.A4TApA a4TApA13 = NMRewardVideoActivity.f9613F1loUV;
                        nMRewardVideoActivity.getClass();
                        int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                        FZu94u.A4TApA a4TApA14 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA14 != null && a4TApA14.f3202BI9f7h <= 0.0f && a4TApA14.BniPrB()) {
                            if (nMRewardVideoActivity.f9655D8cQ8b == 1) {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9647CqNSpT, "1");
                            } else {
                                NMRewardVideoActivity.f9613F1loUV.B2KMhB(nMRewardVideoActivity.f9621B4ZgIw, null);
                            }
                            if (nMRewardVideoActivity.ASJ6gh("close_button", 0, false)) {
                                FZu94u.A4TApA a4TApA15 = NMRewardVideoActivity.f9613F1loUV;
                                a4TApA15.f3203BIYEnU = true;
                                a4TApA15.BV3sI0();
                                if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                                    nMRewardVideoActivity.AYUAbz();
                                    break;
                                }
                            }
                        }
                        HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT3 != null) {
                            aDYaiT3.AlLFFp();
                        }
                        try {
                            FZu94u.A4TApA a4TApA16 = NMRewardVideoActivity.f9613F1loUV;
                            if (a4TApA16 != null && (azoqyo = a4TApA16.f3251EH1KK8) != null && nMRewardVideoActivity.f9661DV2E8K == 1) {
                                azoqyo.A4TApA(a4TApA16.f3252EPdU4G.f3125A4TApA);
                            }
                        } catch (Exception e2) {
                            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 001: "), new EY4UKY.ADYaiT(), "004", e2);
                        }
                        FZu94u.A4TApA a4TApA17 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA17 != null) {
                            a4TApA17.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            NMRewardVideoActivity.f9613F1loUV.CtxOCS();
                            G58fqA.A2egSU a2egSU3 = NMRewardVideoActivity.f9613F1loUV.f2787GIi2tl;
                            if (a2egSU3 != null) {
                                a2egSU3.A4TApA();
                                break;
                            }
                        }
                        break;
                }
            }
        };
    }

    public final boolean AaHO0E() {
        int i = AZOQYO.f3039AcNBzu;
        try {
            this.f9652D6DOie = this.f9651D07BeM.getVideourl();
            A4TApA a4TApA = f9613F1loUV;
            ADYaiT aDYaiT = a4TApA.f2778FdMWEC;
            this.f9620B3GDIM = aDYaiT;
            if (aDYaiT != null) {
                return true;
            }
            a4TApA.DyaChj(this);
            return false;
        } catch (Exception e) {
            e.toString();
            int i2 = AZOQYO.f3039AcNBzu;
            A4TApA a4TApA2 = f9613F1loUV;
            if (a4TApA2 != null) {
                a4TApA2.DyaChj(this);
            }
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 007: "), new EY4UKY.ADYaiT(), "004", e);
            return false;
        }
    }

    public final View AcNBzu() {
        int i = AZOQYO.f3039AcNBzu;
        View inflate = LayoutInflater.from(this).inflate(2131493182, (ViewGroup) null, false);
        if (inflate == null || this.f9651D07BeM == null || TextUtils.isEmpty(this.f9652D6DOie)) {
            return null;
        }
        this.f9637CNPG0E = (TextView) inflate.findViewById(2131298212);
        this.f9639CQhlFr = (TextView) inflate.findViewById(2131298213);
        this.f9638COJEAR = (TextView) inflate.findViewById(2131298214);
        this.f9624BChYOn = (LinearLayout) inflate.findViewById(2131297532);
        this.f9625BI9f7h = (LinearLayout) inflate.findViewById(2131297531);
        this.f9622B7CMnp = (FrameLayout) inflate.findViewById(2131296681);
        this.f9627BJ7GGh = (LinearLayout) inflate.findViewById(2131297536);
        SAAllianceContainerView sAAllianceContainerView = (SAAllianceContainerView) inflate.findViewById(2131297874);
        if (sAAllianceContainerView != null) {
            sAAllianceContainerView.setImpl(f9613F1loUV);
        }
        this.f9635C4FrIb = (TextView) inflate.findViewById(2131298219);
        this.f9630BTvldC = (FrameLayout) inflate.findViewById(2131296786);
        this.f9631BV3sI0 = (FrameLayout) inflate.findViewById(2131296787);
        this.f9636CASmeH = (TextView) inflate.findViewById(2131298218);
        this.f9623B9tovu = (LinearLayout) inflate.findViewById(2131297496);
        this.f9647CqNSpT = (LinearLayout) inflate.findViewById(2131296542);
        this.f9648CrfGsy = (LinearLayout) inflate.findViewById(2131296540);
        this.f9649CtFAbx = (LinearLayout) inflate.findViewById(2131296541);
        this.f9643Cd8JRx = (ImageView) inflate.findViewById(2131296783);
        this.f9671DyaChj = (ImageView) inflate.findViewById(2131296791);
        this.f9672ECyGFg = (ImageView) inflate.findViewById(2131296789);
        this.f9673EGM26s = (ImageView) inflate.findViewById(2131296788);
        this.f9640CSDoyG = (TextView) inflate.findViewById(2131298215);
        this.f9641CTkVKb = (TextView) inflate.findViewById(2131298217);
        this.f9642CcAIMM = (TextView) inflate.findViewById(2131298216);
        if (this.f9651D07BeM.getDesc() != null && !this.f9651D07BeM.getDesc().isEmpty()) {
            this.f9640CSDoyG.setText(this.f9651D07BeM.getDesc());
            this.f9641CTkVKb.setText(this.f9651D07BeM.getDesc());
            this.f9642CcAIMM.setText(this.f9651D07BeM.getDesc());
        }
        this.f9632BmvVmW = (FrameLayout) inflate.findViewById(2131298351);
        this.f9633BniPrB = (FrameLayout) inflate.findViewById(2131296680);
        this.f9626BIYEnU = (LinearLayout) inflate.findViewById(2131297534);
        this.f9645CkXcdM = (ImageView) inflate.findViewById(2131296790);
        this.f9646CmUvjW = (ImageView) inflate.findViewById(2131296792);
        this.f9628BNL6CD = (LinearLayout) inflate.findViewById(2131297533);
        this.f9629BPw6Q8 = (LinearLayout) inflate.findViewById(2131297535);
        this.BpkvW3 = (FrameLayout) inflate.findViewById(2131296682);
        A4TApA a4TApA = f9613F1loUV;
        if (a4TApA != null) {
            StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
            AMqCpz.append(this.f9651D07BeM.getDuration());
            a4TApA.f3229D6DOie = AMqCpz.toString();
        }
        if (this.f9635C4FrIb != null) {
            this.f9635C4FrIb.setText(String.format(getResources().getString(2131886633), Integer.valueOf(this.f9682EmJGcg)));
        }
        TextView textView = this.f9636CASmeH;
        if (textView != null) {
            textView.setOnClickListener(this.f9676EQurEW);
        }
        FrameLayout frameLayout = this.f9632BmvVmW;
        if (frameLayout != null && this.Ddcejp) {
            NMRewardVideoActivity nMRewardVideoActivity = this.f9617AzWtSf;
            try {
                if (nMRewardVideoActivity != null) {
                    ASJ6gh aSJ6gh = new ASJ6gh(nMRewardVideoActivity, 1, (this.f9651D07BeM.getTempid() == null || this.f9651D07BeM.getTempid().isEmpty()) ? 108 : r.b.d, this.f9654D8MqeW, new AaHO0E(this));
                    this.f9653D6yqiO = aSJ6gh;
                    this.f9632BmvVmW.addView(aSJ6gh.f2923AZOQYO);
                    this.f9632BmvVmW.setVisibility(0);
                    this.f9657DAk1zC = this.f9654D8MqeW.getResetSensitivity();
                } else {
                    frameLayout.setVisibility(8);
                }
            } catch (Exception e) {
                e.getMessage();
                int i2 = AZOQYO.f3039AcNBzu;
            }
        }
        FrameLayout frameLayout2 = (FrameLayout) inflate.findViewById(2131298352);
        this.f9681EicXu4 = frameLayout2;
        if (this.f9660DUi7mC == 1) {
            AZOQYO.A2egSU a2egSU = new AZOQYO.A2egSU();
            FrameLayout frameLayout3 = this.f9681EicXu4;
            boolean z = this.f9662DXnQ0V == 0;
            Fyurov.AZOQYO azoqyo = a2egSU.f2939A2egSU;
            azoqyo.f2932ARc23Z = z;
            azoqyo.f2929A4TApA = frameLayout3;
            azoqyo.f2928A2egSU = 1;
            azoqyo.f2933ASJ6gh = 31;
            Material material = this.f9651D07BeM;
            azoqyo.f2930A5SV6n = this;
            azoqyo.f2931ADYaiT = material;
            azoqyo.AMqCpz = new DjONCG.ADYaiT(this);
            a2egSU.A2egSU();
        } else {
            frameLayout2.setVisibility(8);
            ImageView imageView = this.f9643Cd8JRx;
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.bottomMargin = 16;
                this.f9643Cd8JRx.setLayoutParams(marginLayoutParams);
            }
        }
        ImageView imageView2 = this.f9643Cd8JRx;
        if (imageView2 != null) {
            imageView2.setImageResource(2131231427);
        }
        return inflate;
    }

    public final boolean AlLFFp() {
        if (this.f9617AzWtSf == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return false;
        }
        try {
            AppInfoViewActivity.f9606B3GDIM = this;
            Intent intent = new Intent(this.f9617AzWtSf, (Class<?>) AppInfoViewActivity.class);
            intent.putExtra("app_info_ad_data_copy", this.f9650CtxOCS.copy());
            this.f9617AzWtSf.startActivity(intent);
            f9613F1loUV.ARc23Z();
            return true;
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 032: "), new EY4UKY.ADYaiT(), "004", e);
            return false;
        }
    }

    public final boolean AmA8tU() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        String deeplink = this.f9651D07BeM.getDeeplink();
        if (this.f9660DUi7mC == 1 && deeplink != null && !deeplink.isEmpty()) {
            String str = getExternalCacheDir() + "/nmssp_download/";
            String deeplink2 = this.f9651D07BeM.getDeeplink();
            if (deeplink2 != null) {
                f9613F1loUV.f3253EQurEW = JrXYwF.A4TApA.A5SV6n(deeplink2);
                try {
                    SQLiteDatabase writableDatabase = new GnQT2j.A2egSU(this).getWritableDatabase();
                    AZkASS A2egSU2 = GnQT2j.A2egSU.A2egSU(writableDatabase, deeplink2);
                    if (A2egSU2.f3127ADYaiT > 0) {
                        try {
                            if (AYUAbz.A2egSU(new File(str, A2egSU2.f3124A2egSU)) == 0) {
                                A2egSU2.f3127ADYaiT = 0;
                                GnQT2j.A2egSU.A4TApA(writableDatabase, A2egSU2);
                                return false;
                            }
                            if (A2egSU2.f3127ADYaiT == A2egSU2.f3126A5SV6n) {
                                this.f9661DV2E8K = 2;
                                return true;
                            }
                        } catch (Exception e) {
                            new EY4UKY.ADYaiT().AmA8tU("004", "NMRewardVideoActivity 009: " + e.getMessage(), e);
                        }
                    }
                } catch (Exception e2) {
                    CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 010: "), new EY4UKY.ADYaiT(), "004", e2);
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0140 A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:5:0x001e, B:10:0x002d, B:12:0x0033, B:14:0x0037, B:19:0x0069, B:21:0x006d, B:23:0x0071, B:26:0x0078, B:28:0x007e, B:30:0x008a, B:31:0x0098, B:33:0x00a5, B:34:0x00a7, B:36:0x00b9, B:38:0x00bd, B:41:0x00c4, B:43:0x00ca, B:44:0x00d1, B:46:0x00de, B:47:0x00e6, B:49:0x00ee, B:50:0x00f3, B:52:0x00f7, B:53:0x00fd, B:55:0x0107, B:57:0x010d, B:59:0x0113, B:60:0x0117, B:61:0x011a, B:63:0x0120, B:65:0x0124, B:67:0x0128, B:69:0x012e, B:72:0x013a, B:74:0x0140, B:77:0x014c, B:86:0x0150, B:88:0x0159, B:89:0x015c, B:92:0x0185, B:94:0x01d2, B:96:0x01e1, B:98:0x01e5, B:99:0x01ec, B:101:0x020a, B:103:0x0210, B:106:0x0229, B:108:0x022b, B:110:0x0252, B:112:0x0256, B:114:0x025a, B:116:0x0265, B:117:0x0268, B:119:0x026c, B:120:0x0272, B:121:0x0277, B:123:0x027d, B:125:0x0281, B:127:0x0285, B:128:0x0288, B:130:0x028e, B:131:0x029e, B:133:0x02e2, B:135:0x02e6, B:136:0x02fb, B:140:0x0308, B:142:0x030c, B:144:0x0310, B:146:0x0314, B:148:0x0347, B:155:0x0161, B:157:0x016a, B:158:0x016f, B:161:0x004a, B:163:0x0066, B:18:0x003e), top: B:4:0x001e, inners: #1 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.activity.NMRewardVideoActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        f9613F1loUV = null;
        this.f9620B3GDIM = null;
        Material material = this.f9651D07BeM;
        if (material != null) {
            ARc23Z.A2egSU(material.getDeeplink());
        }
        ADYaiT aDYaiT = this.f9620B3GDIM;
        if (aDYaiT != null) {
            aDYaiT.AlLFFp();
        }
        if (this.f9679EdhSi6 != null) {
            this.f9679EdhSi6 = null;
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public final void onResume() {
        A4TApA a4TApA;
        super.onResume();
        if (this.f9620B3GDIM != null && (a4TApA = f9613F1loUV) != null) {
            a4TApA.f3198B4ZgIw = false;
        }
        AZOQYO();
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        AYUAbz();
    }
}
