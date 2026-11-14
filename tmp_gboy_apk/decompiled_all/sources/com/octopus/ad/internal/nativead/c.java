package com.octopus.ad.internal.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.Octopus;
import com.octopus.ad.OnSensorListener;
import com.octopus.ad.R;
import com.octopus.ad.internal.g;
import com.octopus.ad.internal.h;
import com.octopus.ad.internal.k;
import com.octopus.ad.internal.n;
import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.HTTPGet;
import com.octopus.ad.internal.utilities.ImageManager;
import com.octopus.ad.internal.utilities.JsonUtil;
import com.octopus.ad.internal.utilities.UrlUtil;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.internal.video.VideoStateListener;
import com.octopus.ad.internal.video.a;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.view.e;
import com.octopus.ad.internal.x;
import com.octopus.ad.model.ComplianceInfo;
import com.octopus.ad.model.ShakeValue;
import com.octopus.ad.model.c;
import com.octopus.ad.utils.ThreadUtils;
import com.octopus.ad.utils.b.f;
import com.octopus.ad.utils.d;
import com.octopus.ad.utils.i;
import com.octopus.ad.utils.l;
import com.octopus.ad.widget.RegionClickView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c implements NativeAdResponse {
    private String C;
    private HashMap<String, Object> D;
    private ServerResponse.AdLogoInfo K;
    private ServerResponse.AdLogoInfo L;
    private ServerResponse M;
    private a N;
    private Context O;
    private AppCompatTextView P;
    private c.u Q;
    private l R;
    private View S;
    private VideoView T;
    private TextureView U;
    private ImageView V;
    private LinearLayout W;
    private MediaPlayer X;
    private ProgressBar Y;
    private Handler Z;

    /* renamed from: a, reason: collision with root package name */
    private NativeAdResponse.b f12453a;
    private ArrayList<n> aA;
    private List<? extends View> aB;
    private OnSensorListener aC;
    private com.octopus.ad.a.a aD;
    private c.b aE;
    private ComplianceInfo aF;
    private Runnable aa;
    private com.octopus.ad.model.a ab;
    private String ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private int al;
    private int am;
    private ViewGroup an;
    private View ao;
    private View ap;
    private List<View> aq;
    private List<View> ar;
    private NativeAdEventListener as;
    private VideoStateListener at;
    private View.OnClickListener au;
    private View.OnTouchListener av;
    private View.OnClickListener aw;
    private x ax;
    private g ay;
    private h az;
    private String b;
    private String c;
    private String d;
    private String e;
    private Bitmap f;
    private Bitmap g;
    private String h;
    private String i;
    private double j;
    private String k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean s;
    private boolean t;
    private boolean v;
    private boolean w;
    private Boolean z;
    private boolean r = false;
    private boolean u = false;
    private int x = 0;
    private int y = 0;
    private boolean A = false;
    private boolean B = false;
    private boolean E = false;
    private final ArrayList<String> F = new ArrayList<>();
    private final ArrayList<String> G = new ArrayList<>();
    private final ArrayList<String> H = new ArrayList<>();
    private ArrayList<String> I = new ArrayList<>();
    private ArrayList<String> J = new ArrayList<>();
    private boolean aj = true;
    private boolean ak = true;

    /* renamed from: com.octopus.ad.internal.nativead.c$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f12454a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ ImageView c;
        final /* synthetic */ TextView d;
        final /* synthetic */ ImageView e;
        final /* synthetic */ TextView f;
        final /* synthetic */ TextView g;
        final /* synthetic */ FrameLayout h;
        final /* synthetic */ ImageView i;
        final /* synthetic */ FrameLayout j;

        /* renamed from: com.octopus.ad.internal.nativead.c$1$2, reason: invalid class name */
        public class AnonymousClass2 implements ImageManager.BitmapLoadedListener {
            public AnonymousClass2() {
            }

            @Override // com.octopus.ad.internal.utilities.ImageManager.BitmapLoadedListener
            public void onBitmapLoadFailed() {
                if (c.this.as != null) {
                    c.this.as.onAdRenderFailed(80101);
                }
            }

            @Override // com.octopus.ad.internal.utilities.ImageManager.BitmapLoadedListener
            public void onBitmapLoaded(final Bitmap bitmap) {
                d.a(c.this.O, bitmap, new d.a() { // from class: com.octopus.ad.internal.nativead.c.1.2.1
                    @Override // com.octopus.ad.utils.d.a
                    public void a(final Bitmap bitmap2) {
                        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.1.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (bitmap2 != null) {
                                        AnonymousClass1.this.i.setBackground(new BitmapDrawable(c.this.O.getResources(), bitmap2));
                                    }
                                    C04081 c04081 = C04081.this;
                                    AnonymousClass1.this.i.setImageBitmap(bitmap);
                                    if (c.this.Y != null) {
                                        c.this.Y.setVisibility(8);
                                    }
                                    c.this.w();
                                } catch (Exception unused) {
                                    if (c.this.as != null) {
                                        c.this.as.onAdRenderFailed(80101);
                                    }
                                }
                            }
                        });
                    }
                });
            }
        }

        public AnonymousClass1(float f, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2, TextView textView3, FrameLayout frameLayout, ImageView imageView4, FrameLayout frameLayout2) {
            this.f12454a = f;
            this.b = imageView;
            this.c = imageView2;
            this.d = textView;
            this.e = imageView3;
            this.f = textView2;
            this.g = textView3;
            this.h = frameLayout;
            this.i = imageView4;
            this.j = frameLayout2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.an == null) {
                return;
            }
            if (c.this.al <= 0) {
                c cVar = c.this;
                cVar.al = cVar.ao.getWidth();
                if (c.this.al <= 0) {
                    c cVar2 = c.this;
                    cVar2.al = ViewUtil.getScreenWidth(cVar2.ao.getContext());
                    c.this.ao.getLayoutParams().width = c.this.al;
                }
                c.this.ao.getLayoutParams().height = (int) (c.this.al / this.f12454a);
            }
            int unused = c.this.al;
            int i = c.this.ao.getLayoutParams().height;
            int px2dip = ViewUtil.px2dip(c.this.an.getContext(), c.this.al);
            float f = px2dip > 0 ? px2dip / 360.0f : 1.0f;
            float f2 = f <= 1.0f ? f : 1.0f;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            arrayList.add(this.f);
            arrayList.add(this.g);
            arrayList.add(c.this.Y);
            c.this.a((ArrayList<View>) arrayList, f2);
            if (c.this.aF != null) {
                c cVar3 = c.this;
                cVar3.P = ViewUtil.createComplianceView(cVar3.an.getContext(), c.this.aF, f2, true);
                if (c.this.x == 3 || c.this.x == 4) {
                    c.this.P.post(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ao.getLayoutParams().height = c.this.P.getHeight() + c.this.ao.getLayoutParams().height;
                        }
                    });
                }
            }
            if (c.this.isVideo()) {
                if (!c.this.getVideoUrls().isEmpty()) {
                    this.h.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
                    if (c.this.ae) {
                        c.this.U.setVisibility(0);
                        c.this.q();
                    } else {
                        c.this.T.setVisibility(0);
                        c.this.p();
                    }
                }
            } else if (!TextUtils.isEmpty(c.this.getImageUrl())) {
                ImageManager.with(null).getBitmap(c.this.getImageUrl(), new AnonymousClass2());
            }
            c.this.a(this.j);
            c.this.a((ViewGroup) this.h);
            c.this.a(this.f);
            c.this.e();
            if (c.this.M != null) {
                final String replaceFeedBackUrl = UrlUtil.replaceFeedBackUrl("https://www.adintl.cn/sdkFeedback.html?slotId=${SLOT_ID}&sdkVersion=${SDK_VERSION}&deviceId=${DEVICE_ID}", c.this.M.e(), Octopus.getOaid(c.this.O));
                this.g.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.nativead.c.1.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ViewUtil.openLocalBrowser(replaceFeedBackUrl, 0);
                        if (c.this.M != null) {
                            c.this.M.c();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.octopus.ad.internal.nativead.c$7, reason: invalid class name */
    public class AnonymousClass7 implements ImageManager.BitmapLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12487a;

        public AnonymousClass7(Context context) {
            this.f12487a = context;
        }

        @Override // com.octopus.ad.internal.utilities.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
        }

        @Override // com.octopus.ad.internal.utilities.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(final Bitmap bitmap) {
            d.a(this.f12487a, bitmap, new d.a() { // from class: com.octopus.ad.internal.nativead.c.7.1
                @Override // com.octopus.ad.utils.d.a
                public void a(final Bitmap bitmap2) {
                    ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.7.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (bitmap2 != null) {
                                    c.this.V.setBackground(new BitmapDrawable(AnonymousClass7.this.f12487a.getResources(), bitmap2));
                                }
                                c.this.V.setImageBitmap(bitmap);
                            } catch (Exception e) {
                                f.a("OctopusAd", "An Exception Caught", e);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void addShakeView(final ViewGroup viewGroup, final int i, final float f) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.Q == null || c.this.Q.a() == 0) {
                    c.this.Q = new c.u(1.5d, 0.0d, 0, "摇动或点击了解更多", 1, 0, 0, 3);
                }
                c.this.a(viewGroup, i, f);
            }
        });
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void bindUnifiedView(ViewGroup viewGroup, List<View> list, NativeAdEventListener nativeAdEventListener) {
        bindUnifiedView(viewGroup, list, null, nativeAdEventListener);
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void bindView(ViewGroup viewGroup, NativeAdEventListener nativeAdEventListener) {
        this.ah = true;
        this.an = viewGroup;
        this.as = nativeAdEventListener;
        j();
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            serverResponse.b();
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void destroy() {
        this.o = true;
        this.E = true;
        x();
        g gVar = this.ay;
        if (gVar != null) {
            gVar.a();
        }
        h hVar = this.az;
        if (hVar != null) {
            hVar.a();
        }
        l lVar = this.R;
        if (lVar != null) {
            lVar.a();
            this.R = null;
        }
        Handler handler = this.Z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.Z = null;
        }
        x xVar = this.ax;
        if (xVar != null) {
            xVar.c();
            this.ax = null;
        }
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            serverResponse.ah();
            this.M = null;
        }
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            bitmap.recycle();
            this.g = null;
        }
        Bitmap bitmap2 = this.f;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f = null;
        }
        MediaPlayer mediaPlayer = this.X;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.X = null;
        }
        this.aa = null;
        this.ap = null;
        this.aq = null;
        this.ar = null;
        this.an = null;
        this.aA = null;
        this.as = null;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getAdvertiser() {
        return this.C;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public View getBlurView(Context context) {
        return b(context);
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getButtonText() {
        return TextUtils.isEmpty(this.i) ? "查看详情" : this.i;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ComplianceInfo getComplianceInfo() {
        return this.aF;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public View getComplianceView(Context context) {
        ComplianceInfo complianceInfo = this.aF;
        if (complianceInfo != null) {
            return ViewUtil.createComplianceView(context, complianceInfo, 1.0f, true);
        }
        return null;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getDescription() {
        return this.c;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public Bitmap getIcon() {
        return this.g;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getIconUrl() {
        return this.e;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public Bitmap getImage() {
        return this.f;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getImageUrl() {
        return this.d;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ArrayList<String> getImageUrls() {
        return this.F;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getInteractionType() {
        c.b bVar = this.aE;
        if (bVar != null) {
            return bVar.d();
        }
        return 4;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getLandingPageUrl() {
        return this.h;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public Bitmap getLogo(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.oct_logo);
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ServerResponse.AdLogoInfo getLogoInfo() {
        return this.L;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getLogoUrl() {
        ServerResponse.AdLogoInfo adLogoInfo = this.L;
        if (adLogoInfo == null || adLogoInfo.getType() != ServerResponse.AdLogoInfo.TYPE_PIC) {
            return null;
        }
        return this.L.getAdurl();
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getMaterialType() {
        return isVideo() ? 2 : 1;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public Map<String, Object> getMediaExtraInfo() {
        ServerResponse serverResponse = this.M;
        return serverResponse != null ? serverResponse.X() : Collections.EMPTY_MAP;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public NativeAdResponse.b getNativeAdType() {
        return this.f12453a;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public HashMap<String, Object> getNativeElements() {
        return this.D;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public List<? extends View> getNativeInfoListView() {
        return this.aB;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public View getNativeView() {
        return this.an;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public NativeAdResponse.a getNetworkIdentifier() {
        return NativeAdResponse.a.OCTOPUS;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getPictureHeight() {
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            return serverResponse.n();
        }
        return 0;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getPictureWidth() {
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            return serverResponse.o();
        }
        return 0;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getPrice() {
        return this.l;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ShakeValue getShakeValue() {
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            return serverResponse.W();
        }
        return null;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public double getStarRating() {
        return this.j;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getStore() {
        return this.k;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ArrayList<String> getTextList() {
        return this.H;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public Bitmap getTextLogo(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.oct_logo_text);
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ServerResponse.AdLogoInfo getTextLogoInfo() {
        return this.K;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getTextLogoUrl() {
        ServerResponse.AdLogoInfo adLogoInfo = this.K;
        if (adLogoInfo == null || adLogoInfo.getType() != ServerResponse.AdLogoInfo.TYPE_PIC) {
            return null;
        }
        return this.K.getAdurl();
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getTitle() {
        return this.b;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ArrayList<String> getVideoUrls() {
        return this.G;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public View getVideoView(Context context) {
        if (context == null || !isVideo() || getVideoUrls().isEmpty()) {
            return null;
        }
        if (this.ae) {
            if (this.U == null) {
                this.U = new TextureView(context);
                q();
            }
            return this.U;
        }
        if (this.T == null) {
            this.T = new VideoView(context);
            p();
        }
        return this.T;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public boolean hasExpired() {
        return this.E;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public boolean isShakeAd() {
        return this.ag;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public boolean isVideo() {
        return this.af;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setAdWidth(int i) {
        this.al = i;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setIcon(Bitmap bitmap) {
        this.g = bitmap;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setImage(Bitmap bitmap) {
        this.f = bitmap;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setIsVideoMute(boolean z) {
        this.ak = z;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener) {
        this.aj = false;
        if (this.O == null) {
            this.O = q.a().j();
        }
        this.ah = false;
        FrameLayout frameLayout = new FrameLayout(this.O);
        this.an = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.as = nativeAdEventListener;
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            if (serverResponse.l() == p.DRAW) {
                l();
            } else if (this.M.l() == p.BANNER) {
                m();
            } else {
                j();
            }
            this.M.b();
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setNativeInfoListView(List<? extends View> list) {
        this.aB = list;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setOnSensorListener(OnSensorListener onSensorListener) {
        this.aC = onSensorListener;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setVideoStateListener(VideoStateListener videoStateListener) {
        this.at = videoStateListener;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void showCloseButton(boolean z) {
        this.t = z;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void unregisterViews() {
        View view = this.ap;
        if (view != null) {
            view.setOnClickListener(null);
        }
        List<View> list = this.aq;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.aq) {
                if (view2 != null) {
                    view2.setOnClickListener(null);
                }
            }
        }
        List<View> list2 = this.ar;
        if (list2 != null && !list2.isEmpty()) {
            for (View view3 : this.ar) {
                if (view3 != null) {
                    view3.setOnClickListener(null);
                }
            }
        }
        destroy();
    }

    private void A() {
        this.au = new View.OnClickListener() { // from class: com.octopus.ad.internal.nativead.c.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.a(cVar.v());
            }
        };
    }

    private void B() {
        this.av = new e(this.an, this.A, new e.a() { // from class: com.octopus.ad.internal.nativead.c.20
            @Override // com.octopus.ad.internal.view.e.a
            public void a(View view, com.octopus.ad.model.d dVar) {
                c.this.a(dVar);
            }
        });
    }

    private void C() {
        this.aw = new View.OnClickListener() { // from class: com.octopus.ad.internal.nativead.c.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.M != null) {
                    c cVar = c.this;
                    cVar.B = cVar.M.R();
                }
                if (c.this.B && !c.this.p) {
                    c.this.y = 2;
                    c cVar2 = c.this;
                    cVar2.a(cVar2.v());
                    return;
                }
                if (c.this.as != null) {
                    c.this.as.onAdClose();
                }
                if (c.this.M != null) {
                    c.this.M.Y();
                }
                if (c.this.an != null) {
                    if (c.this.ah) {
                        c.this.an.removeAllViews();
                    } else {
                        ViewUtil.removeChildFromParent(c.this.an);
                    }
                }
                c.this.destroy();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        NativeAdEventListener nativeAdEventListener;
        ServerResponse serverResponse;
        if (this.ad) {
            return;
        }
        this.ad = true;
        if (z && (serverResponse = this.M) != null) {
            z = serverResponse.O();
        }
        if (z && (nativeAdEventListener = this.as) != null) {
            nativeAdEventListener.onADExposed();
        }
        ServerResponse serverResponse2 = this.M;
        if (serverResponse2 != null) {
            serverResponse2.a(this.ab, z);
        }
        if (this.ab == null || !f().equals(this.ab.a())) {
            return;
        }
        q.a().g.remove(this.ab.b());
    }

    private void j() {
        if (this.an == null) {
            NativeAdEventListener nativeAdEventListener = this.as;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80101);
                return;
            }
            return;
        }
        u();
        int i = this.x;
        if (i == 1) {
            a(R.layout.oct_native_text_above_img, 1.4f);
            return;
        }
        if (i == 2) {
            a(R.layout.oct_native_text_below_img, 1.4f);
            return;
        }
        if (i == 3) {
            a(R.layout.oct_native_text_right_img, 4.74f);
        } else if (i != 4) {
            a(R.layout.oct_native_one_img, 1.78f);
        } else {
            a(R.layout.oct_native_text_left_img, 4.74f);
        }
    }

    private void k() {
        if (this.an != null) {
            e();
            u();
        } else {
            NativeAdEventListener nativeAdEventListener = this.as;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80101);
            }
        }
    }

    private void l() {
        if (this.an == null) {
            NativeAdEventListener nativeAdEventListener = this.as;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80101);
                return;
            }
            return;
        }
        u();
        View inflate = LayoutInflater.from(this.an.getContext()).inflate(R.layout.oct_layout_draw, this.an);
        this.ao = inflate;
        this.al = ViewUtil.getScreenWidth(inflate.getContext());
        a(1.0f);
    }

    private void m() {
        if (this.an != null) {
            u();
            a(isVideo() ? R.layout.oct_layout_banner_video : R.layout.oct_layout_banner, 6.4f);
        } else {
            NativeAdEventListener nativeAdEventListener = this.as;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80101);
            }
        }
    }

    private void n() {
        c.o I;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ServerResponse serverResponse = this.M;
        if (serverResponse == null || (I = serverResponse.I()) == null) {
            return;
        }
        c.m a2 = I.a();
        if (this.M.l() == p.DRAW) {
            if (a2 == null || a2.a() != 1 || (viewGroup2 = this.an) == null) {
                return;
            }
            viewGroup2.setOnClickListener(this.au);
            this.an.setOnTouchListener(this.av);
            return;
        }
        if ((a2 == null || a2.a() == 1) && (viewGroup = this.an) != null) {
            viewGroup.setOnClickListener(this.au);
            this.an.setOnTouchListener(this.av);
        }
    }

    private void o() {
        ViewGroup viewGroup = this.an;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.nativead.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (c.this.isVideo()) {
                            if (c.this.ae) {
                                if (c.this.X != null) {
                                    if (c.this.X.isPlaying()) {
                                        c.this.X.pause();
                                        c.this.u = true;
                                        if (c.this.at != null) {
                                            c.this.at.onVideoPause();
                                            return;
                                        }
                                        return;
                                    }
                                    c.this.X.start();
                                    c.this.u = false;
                                    if (c.this.at != null) {
                                        c.this.at.onVideoResume();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (c.this.T != null) {
                                if (c.this.T.isPlaying()) {
                                    c.this.T.pause();
                                    c.this.u = true;
                                    if (c.this.at != null) {
                                        c.this.at.onVideoPause();
                                        return;
                                    }
                                    return;
                                }
                                c.this.T.start();
                                c.this.u = false;
                                if (c.this.at != null) {
                                    c.this.at.onVideoResume();
                                }
                            }
                        }
                    } catch (Exception e) {
                        f.a("OctopusAd", "An Exception Caught", e);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.T == null) {
            return;
        }
        this.Z = new Handler();
        this.aa = new Runnable() { // from class: com.octopus.ad.internal.nativead.c.23
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.T == null || c.this.T.getDuration() <= 0) {
                    return;
                }
                int duration = c.this.T.getDuration();
                c cVar = c.this;
                cVar.am = cVar.T.getCurrentPosition();
                if (!c.this.T.isPlaying()) {
                    if (c.this.am <= 0 || c.this.ai || c.this.M == null) {
                        return;
                    }
                    c.this.M.ae();
                    return;
                }
                c.this.t();
                f.a("OctopusAd", "currentPosition:" + c.this.am + "/" + duration);
                int i = c.this.am / 1000 == duration / TTAdConstant.INIT_LOCAL_FAIL_CODE ? 1 : c.this.am / 1000 == duration / 2000 ? 2 : c.this.am / 1000 == (duration * 3) / TTAdConstant.INIT_LOCAL_FAIL_CODE ? 3 : 0;
                if (i > 0 && c.this.M != null) {
                    c.this.M.c(i);
                }
                f.a("OctopusAd", "video progress:" + i);
            }
        };
        this.T.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.octopus.ad.internal.nativead.c.24
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                c.this.ai = true;
                c.this.am = 0;
                if (c.this.M != null) {
                    c.this.M.af();
                }
                if (c.this.at != null) {
                    c.this.at.onVideoCompleted();
                }
            }
        });
        this.T.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.octopus.ad.internal.nativead.c.25
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (c.this.at == null) {
                    return true;
                }
                c.this.at.onVideoError(i, i2);
                return true;
            }
        });
        this.T.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.octopus.ad.internal.nativead.c.26
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                float e = q.a().e();
                if (c.this.M != null && c.this.M.z() && q.a().f() && c.this.ak) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else if (e > 0.0f) {
                    mediaPlayer.setVolume(e, e);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
                if (c.this.Y != null) {
                    c.this.Y.setVisibility(8);
                }
                if (c.this.M != null) {
                    c.this.M.ad();
                }
                if (c.this.at != null) {
                    c.this.at.onVideoStart();
                }
                c.this.t();
                c.this.w();
                c.this.r();
            }
        });
        this.T.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.octopus.ad.internal.nativead.c.27
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (c.this.T == null || c.this.T.isPlaying()) {
                    return;
                }
                if (c.this.am > 0) {
                    c.this.T.seekTo(c.this.am);
                }
                c.this.T.start();
                if (c.this.Y != null) {
                    c.this.Y.setVisibility(0);
                }
                if (c.this.at != null) {
                    c.this.at.onVideoReady();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        });
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        TextureView textureView = this.U;
        if (textureView == null) {
            return;
        }
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.octopus.ad.internal.nativead.c.28
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Surface surface = new Surface(surfaceTexture);
                c.this.X = new MediaPlayer();
                c.this.X.setSurface(surface);
                c.this.X.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.octopus.ad.internal.nativead.c.28.1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        c.this.ai = true;
                        c.this.am = 0;
                        if (c.this.M != null) {
                            c.this.M.af();
                        }
                        if (c.this.at != null) {
                            c.this.at.onVideoCompleted();
                        }
                    }
                });
                c.this.X.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.octopus.ad.internal.nativead.c.28.2
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i3, int i4) {
                        if (c.this.at == null) {
                            return true;
                        }
                        c.this.at.onVideoError(i3, i4);
                        return true;
                    }
                });
                c.this.X.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.octopus.ad.internal.nativead.c.28.3
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        c.this.s();
                        float e = q.a().e();
                        if (c.this.M != null && c.this.M.z() && q.a().f()) {
                            mediaPlayer.setVolume(0.0f, 0.0f);
                        } else if (e > 0.0f) {
                            mediaPlayer.setVolume(e, e);
                        } else {
                            mediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        if (c.this.Y != null) {
                            c.this.Y.setVisibility(8);
                        }
                        if (c.this.M != null) {
                            c.this.M.ad();
                        }
                        if (c.this.at != null) {
                            c.this.at.onVideoStart();
                        }
                        c.this.t();
                        c.this.w();
                        c.this.r();
                    }
                });
                c.this.d();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (c.this.Z != null) {
                    c.this.Z.removeCallbacksAndMessages(null);
                    c.this.Z = null;
                }
                if (c.this.X != null) {
                    c.this.X.release();
                    c.this.X = null;
                }
                c.this.aa = null;
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        this.Z = new Handler();
        this.aa = new Runnable() { // from class: com.octopus.ad.internal.nativead.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.X == null || c.this.X.getDuration() <= 0) {
                    return;
                }
                int duration = c.this.X.getDuration();
                c cVar = c.this;
                cVar.am = cVar.X.getCurrentPosition();
                if (!c.this.X.isPlaying()) {
                    if (c.this.am <= 0 || c.this.ai || c.this.M == null) {
                        return;
                    }
                    c.this.M.ae();
                    return;
                }
                c.this.t();
                f.a("OctopusAd", "currentPosition:" + c.this.am + "/" + duration);
                int i = c.this.am / 1000 == duration / TTAdConstant.INIT_LOCAL_FAIL_CODE ? 1 : c.this.am / 1000 == duration / 2000 ? 2 : c.this.am / 1000 == (duration * 3) / TTAdConstant.INIT_LOCAL_FAIL_CODE ? 3 : 0;
                if (i > 0 && c.this.M != null) {
                    c.this.M.c(i);
                }
                f.a("OctopusAd", "video progress:" + i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ServerResponse serverResponse;
        if (this.an == null || (serverResponse = this.M) == null || serverResponse.l() != p.DRAW || this.ay != null) {
            return;
        }
        this.ay = g.a(this.an, new NativeAdShownListener() { // from class: com.octopus.ad.internal.nativead.c.3
            @Override // com.octopus.ad.internal.nativead.NativeAdShownListener
            public void onAdShown(boolean z) {
                try {
                    if (!c.this.ae) {
                        if (!z) {
                            if (c.this.T.isPlaying()) {
                                c.this.T.pause();
                                return;
                            }
                            return;
                        } else {
                            if (c.this.u || c.this.T.isPlaying()) {
                                return;
                            }
                            c.this.T.start();
                            return;
                        }
                    }
                    if (c.this.X != null) {
                        if (!z) {
                            if (c.this.X.isPlaying()) {
                                c.this.X.pause();
                            }
                        } else {
                            if (c.this.u || c.this.X.isPlaying()) {
                                return;
                            }
                            c.this.X.start();
                        }
                    }
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Matrix a2;
        TextureView textureView = this.U;
        if (textureView == null || this.X == null || (a2 = new com.octopus.ad.internal.video.a(new a.c(textureView.getWidth(), this.U.getHeight()), new a.c(this.X.getVideoWidth(), this.X.getVideoHeight())).a(a.b.FIT_CENTER)) == null) {
            return;
        }
        this.U.setTransform(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Handler handler = this.Z;
        if (handler == null || this.aa == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.Z.postDelayed(this.aa, 1000L);
    }

    private void u() {
        ServerResponse serverResponse;
        c.o I;
        if (this.an == null || (serverResponse = this.M) == null || this.Q != null || (I = serverResponse.I()) == null) {
            return;
        }
        c.u c = I.c();
        this.Q = c;
        if (c == null || c.a() != 1) {
            return;
        }
        b(this.an);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.octopus.ad.model.d v() {
        int screenWidth;
        float f;
        int i;
        try {
            float f2 = 1.4f;
            if (!this.r && !this.n) {
                ViewGroup viewGroup = this.an;
                if (viewGroup != null) {
                    screenWidth = viewGroup.getWidth();
                    i = this.an.getHeight();
                } else {
                    screenWidth = 0;
                    i = 0;
                }
                if (screenWidth == 0 || i == 0) {
                    screenWidth = ViewUtil.getScreenWidth(q.a().j());
                    f = screenWidth;
                    i = (int) (f / f2);
                }
                int a2 = i.a(screenWidth);
                int a3 = i.a(i);
                int a4 = i.a(com.bykv.vk.component.ttvideo.player.MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS) + 50;
                com.octopus.ad.model.d dVar = new com.octopus.ad.model.d(1);
                float f3 = a2;
                dVar.a(f3);
                float f4 = a3;
                dVar.b(f4);
                dVar.a(String.valueOf(System.currentTimeMillis()));
                dVar.d(String.valueOf(System.currentTimeMillis()));
                dVar.c(String.valueOf(System.currentTimeMillis() / 1000));
                dVar.c(f3);
                dVar.d(f4);
                dVar.b(String.valueOf(System.currentTimeMillis() + a4));
                dVar.a(screenWidth);
                dVar.b(i);
                return dVar;
            }
            screenWidth = ViewUtil.getScreenWidth(q.a().j());
            f = screenWidth;
            int i2 = (int) (f / 1.4f);
            ServerResponse serverResponse = this.M;
            if (serverResponse != null) {
                if (serverResponse.l() == p.DRAW) {
                    i = ViewUtil.getScreenHeight(q.a().j());
                    int a22 = i.a(screenWidth);
                    int a32 = i.a(i);
                    int a42 = i.a(com.bykv.vk.component.ttvideo.player.MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS) + 50;
                    com.octopus.ad.model.d dVar2 = new com.octopus.ad.model.d(1);
                    float f32 = a22;
                    dVar2.a(f32);
                    float f42 = a32;
                    dVar2.b(f42);
                    dVar2.a(String.valueOf(System.currentTimeMillis()));
                    dVar2.d(String.valueOf(System.currentTimeMillis()));
                    dVar2.c(String.valueOf(System.currentTimeMillis() / 1000));
                    dVar2.c(f32);
                    dVar2.d(f42);
                    dVar2.b(String.valueOf(System.currentTimeMillis() + a42));
                    dVar2.a(screenWidth);
                    dVar2.b(i);
                    return dVar2;
                }
                if (this.M.l() == p.BANNER) {
                    f2 = 6.4f;
                    i = (int) (f / f2);
                    int a222 = i.a(screenWidth);
                    int a322 = i.a(i);
                    int a422 = i.a(com.bykv.vk.component.ttvideo.player.MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS) + 50;
                    com.octopus.ad.model.d dVar22 = new com.octopus.ad.model.d(1);
                    float f322 = a222;
                    dVar22.a(f322);
                    float f422 = a322;
                    dVar22.b(f422);
                    dVar22.a(String.valueOf(System.currentTimeMillis()));
                    dVar22.d(String.valueOf(System.currentTimeMillis()));
                    dVar22.c(String.valueOf(System.currentTimeMillis() / 1000));
                    dVar22.c(f322);
                    dVar22.d(f422);
                    dVar22.b(String.valueOf(System.currentTimeMillis() + a422));
                    dVar22.a(screenWidth);
                    dVar22.b(i);
                    return dVar22;
                }
            }
            i = i2;
            int a2222 = i.a(screenWidth);
            int a3222 = i.a(i);
            int a4222 = i.a(com.bykv.vk.component.ttvideo.player.MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS) + 50;
            com.octopus.ad.model.d dVar222 = new com.octopus.ad.model.d(1);
            float f3222 = a2222;
            dVar222.a(f3222);
            float f4222 = a3222;
            dVar222.b(f4222);
            dVar222.a(String.valueOf(System.currentTimeMillis()));
            dVar222.d(String.valueOf(System.currentTimeMillis()));
            dVar222.c(String.valueOf(System.currentTimeMillis() / 1000));
            dVar222.c(f3222);
            dVar222.d(f4222);
            dVar222.b(String.valueOf(System.currentTimeMillis() + a4222));
            dVar222.a(screenWidth);
            dVar222.b(i);
            return dVar222;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        ServerResponse serverResponse;
        if (this.w || this.ao == null || (serverResponse = this.M) == null || serverResponse.l() != p.DRAW) {
            return;
        }
        this.w = true;
        c.y j = this.M.j();
        if (j == null || j.a() != 1) {
            return;
        }
        this.W = (LinearLayout) this.ao.findViewById(R.id.rl_auto);
        final TextView textView = (TextView) this.ao.findViewById(R.id.tv_auto);
        TextView textView2 = (TextView) this.ao.findViewById(R.id.tv_stop);
        this.W.setVisibility(0);
        com.octopus.ad.a.a aVar = new com.octopus.ad.a.a(j.b() * 1000, 50L);
        this.aD = aVar;
        aVar.a(new com.octopus.ad.a.b() { // from class: com.octopus.ad.internal.nativead.c.17
            @Override // com.octopus.ad.a.b
            public void a(long j2) {
                int i = (int) ((j2 / 1000) + 1);
                TextView textView3 = textView;
                Locale locale = Locale.US;
                textView3.setText(i + "秒后自动跳转详情页");
                if (i <= 3) {
                    textView.setBackgroundResource(R.drawable.oct_bg_common_orange);
                }
            }

            @Override // com.octopus.ad.a.b
            public void b() {
            }

            @Override // com.octopus.ad.a.b
            public void a() {
                c.this.y = 3;
                c.this.q = true;
                c cVar = c.this;
                cVar.a(cVar.v());
                c.this.x();
            }
        });
        this.aD.a();
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.nativead.c.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.x();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.octopus.ad.a.a aVar = this.aD;
        if (aVar != null) {
            aVar.d();
        }
        LinearLayout linearLayout = this.W;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        ArrayList<String> arrayList = this.I;
        if (arrayList == null) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("?rv=1")) {
                ViewUtil.openLocalBrowser(next, 0);
            } else {
                if (next.contains("track=oct")) {
                    if (this.n) {
                        next = next.concat("&opt=10");
                    } else if (this.r) {
                        next = next.concat("&opt=1");
                    }
                }
                new com.octopus.ad.internal.i(next).execute();
            }
        }
    }

    private void z() {
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            this.A = serverResponse.Q();
        }
        A();
        B();
        C();
        List<View> list = this.aq;
        if (list == null || list.isEmpty()) {
            n();
        } else {
            for (View view : this.aq) {
                if (view != null) {
                    view.setOnClickListener(this.au);
                    view.setOnTouchListener(this.av);
                }
            }
        }
        List<View> list2 = this.ar;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        for (View view2 : this.ar) {
            if (view2 != null) {
                view2.setOnClickListener(this.aw);
            }
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void bindUnifiedView(ViewGroup viewGroup, List<View> list, List<View> list2, NativeAdEventListener nativeAdEventListener) {
        this.ah = true;
        this.an = viewGroup;
        this.as = nativeAdEventListener;
        this.aq = list;
        this.ar = list2;
        k();
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            serverResponse.b();
        }
    }

    public void h() {
        c.w J;
        c.p c;
        ServerResponse serverResponse = this.M;
        if (serverResponse == null || (J = serverResponse.J()) == null || (c = J.c()) == null || c.a() != 1) {
            return;
        }
        e(true);
        new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.14
            @Override // java.lang.Runnable
            public void run() {
                c.this.y();
            }
        }, c.c());
        if (c.b() == 1) {
            this.q = true;
            final k.a aVar = new k.a() { // from class: com.octopus.ad.internal.nativead.c.15
                @Override // com.octopus.ad.internal.k.a
                public void a(String str) {
                    if ("AppBackground".equals(str)) {
                        c.this.s = true;
                    }
                }
            };
            k.a().a(aVar);
            new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.16
                @Override // java.lang.Runnable
                public void run() {
                    if (!c.this.s) {
                        c cVar = c.this;
                        cVar.a(cVar.v());
                    }
                    k.a().b(aVar);
                }
            }, c.d());
        }
    }

    public boolean i() {
        return this.r;
    }

    public void d() {
        String str = getVideoUrls().get(0);
        if (this.X == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.octopus.ad.internal.a.h b = q.a().b();
            if (b != null) {
                String a2 = b.a(str);
                if (b.b(str)) {
                    str = a2;
                }
            }
            this.X.setDataSource(str);
            this.X.prepare();
            this.X.start();
            VideoStateListener videoStateListener = this.at;
            if (videoStateListener != null) {
                videoStateListener.onVideoReady();
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            NativeAdEventListener nativeAdEventListener = this.as;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80202);
            }
        }
    }

    public void e() {
        z();
        a(new NativeAdShownListener() { // from class: com.octopus.ad.internal.nativead.c.4
            @Override // com.octopus.ad.internal.nativead.NativeAdShownListener
            public void onAdShown(boolean z) {
                c.this.g(z);
            }
        });
    }

    public String f() {
        if (this.ac == null) {
            this.ac = "";
        }
        return this.ac;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public View getComplianceView(Context context, int i) {
        float f;
        if (this.aF == null) {
            return null;
        }
        float screenWidthDp = ViewUtil.getScreenWidthDp(context);
        if (screenWidthDp > 0.0f && i > 0) {
            float f2 = i;
            if (screenWidthDp > f2) {
                f = f2 / screenWidthDp;
                return ViewUtil.createComplianceView(context, this.aF, f, true);
            }
        }
        f = 1.0f;
        return ViewUtil.createComplianceView(context, this.aF, f, true);
    }

    public void b(ServerResponse.AdLogoInfo adLogoInfo) {
        this.L = adLogoInfo;
    }

    public void c() {
        String str = getVideoUrls().get(0);
        if (this.T == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.octopus.ad.internal.a.h b = q.a().b();
            if (b != null) {
                String a2 = b.a(str);
                if (b.b(str)) {
                    this.T.setVideoPath(a2);
                    return;
                } else {
                    this.T.setVideoPath(str);
                    return;
                }
            }
            this.T.setVideoPath(str);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            NativeAdEventListener nativeAdEventListener = this.as;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80202);
            }
        }
    }

    public String b() {
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            return serverResponse.f();
        }
        return "";
    }

    public void e(boolean z) {
        this.n = z;
    }

    public void f(boolean z) {
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            serverResponse.a(z);
        }
    }

    private void b(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.R == null) {
            l lVar = new l(viewGroup.getContext());
            this.R = lVar;
            lVar.a(this.Q);
            this.R.a(viewGroup);
            this.R.a(new l.a() { // from class: com.octopus.ad.internal.nativead.c.5
                @Override // com.octopus.ad.utils.l.a
                public void a(com.octopus.ad.model.d dVar) {
                    c.this.a(dVar);
                    if (c.this.aC != null) {
                        c.this.aC.onShakeTrigger(1, dVar.o(), dVar.p());
                    }
                }
            });
        }
        this.R.b();
    }

    public void g() {
        ServerResponse serverResponse;
        c.w J;
        c.p c;
        if (this.r || (serverResponse = this.M) == null || (J = serverResponse.J()) == null || (c = J.c()) == null || c.a() != 1) {
            return;
        }
        d(true);
        new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.10
            @Override // java.lang.Runnable
            public void run() {
                c.this.y();
            }
        }, c.c());
        if (c.b() == 1) {
            this.q = true;
            final k.a aVar = new k.a() { // from class: com.octopus.ad.internal.nativead.c.11
                @Override // com.octopus.ad.internal.k.a
                public void a(String str) {
                    if ("AppBackground".equals(str)) {
                        c.this.s = true;
                    }
                }
            };
            k.a().a(aVar);
            new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.13
                @Override // java.lang.Runnable
                public void run() {
                    if (!c.this.s) {
                        c cVar = c.this;
                        cVar.a(cVar.v());
                    }
                    k.a().b(aVar);
                }
            }, c.d());
        }
    }

    public void b(boolean z) {
        this.ag = z;
    }

    private View b(Context context) {
        if (this.V == null) {
            this.V = new ImageView(context);
            ImageManager.with(context).getBitmap(getImageUrl(), new AnonymousClass7(context));
        }
        return this.V;
    }

    private void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.S) == null) {
            return;
        }
        ViewUtil.removeChildFromParent(view);
        if (viewGroup instanceof RelativeLayout) {
            viewGroup.addView(this.S, A2egSU.AYUAbz(-2, -2, 13, -1));
        } else {
            viewGroup.addView(this.S);
        }
    }

    public void a(Context context) {
        this.O = context;
        if (context == null) {
            this.O = q.a().j();
        }
    }

    public void d(boolean z) {
        this.r = z;
    }

    public void a(ServerResponse.AdLogoInfo adLogoInfo) {
        this.K = adLogoInfo;
    }

    public void d(String str) {
        this.J.add(str);
    }

    public void a(int i) {
        this.m = i;
    }

    public int a() {
        return this.m;
    }

    public void b(String str) {
        this.h = str;
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ArrayList<String> stringArrayList = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(jSONObject, "ImpressionTrackers"));
        c cVar = new c();
        if (stringArrayList != null) {
            cVar.I = stringArrayList;
        }
        cVar.b = JsonUtil.getJSONString(jSONObject, "Headline");
        cVar.c = JsonUtil.getJSONString(jSONObject, "Body");
        cVar.d = JsonUtil.getJSONString(jSONObject, "Image");
        cVar.x = JsonUtil.getJSONInt(jSONObject, "LayoutType");
        cVar.t = JsonUtil.getJSONBoolean(jSONObject, "IsShowClose");
        JSONArray jSONArray = JsonUtil.getJSONArray(jSONObject, "Images");
        JSONArray jSONArray2 = JsonUtil.getJSONArray(jSONObject, "Videos");
        JSONArray jSONArray3 = JsonUtil.getJSONArray(jSONObject, "Texts");
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                cVar.F.add((String) jSONArray.get(i));
            }
        }
        if (jSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                cVar.G.add((String) jSONArray2.get(i2));
            }
        }
        if (jSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                cVar.H.add((String) jSONArray3.get(i3));
            }
        }
        if (jSONObject.has("AppIcon")) {
            cVar.f12453a = NativeAdResponse.b.APP_INSTALL;
            cVar.e = JsonUtil.getJSONString(jSONObject, "AppIcon");
            cVar.i = JsonUtil.getJSONString(jSONObject, "Action");
            cVar.j = JsonUtil.getJSONDouble(jSONObject, "Star");
            cVar.k = JsonUtil.getJSONString(jSONObject, "Store");
            cVar.l = JsonUtil.getJSONInt(jSONObject, "Price");
        } else {
            cVar.f12453a = NativeAdResponse.b.CONTENT;
            cVar.e = JsonUtil.getJSONString(jSONObject, "Logo");
            cVar.i = JsonUtil.getJSONString(jSONObject, "Action");
            cVar.C = JsonUtil.getJSONString(jSONObject, "Advertiser");
        }
        ArrayList<String> stringArrayList2 = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(jSONObject, "ClickTrackers"));
        if (stringArrayList2 != null) {
            cVar.J = stringArrayList2;
        }
        cVar.D = JsonUtil.getStringObjectHashMap(JsonUtil.getJSONObject(jSONObject, "Custom"));
        return cVar;
    }

    public void b(int i) {
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            serverResponse.b(i);
        }
    }

    public void c(boolean z) {
        this.ae = z;
    }

    public void c(String str) {
        this.I.add(str);
    }

    private void a(int i, float f) {
        ViewGroup viewGroup = this.an;
        if (viewGroup != null) {
            try {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, (ViewGroup) null);
                this.ao = inflate;
                if (this.al > 0) {
                    int i2 = this.al;
                    this.an.addView(this.ao, new ViewGroup.LayoutParams(i2, (int) (i2 / f)));
                } else {
                    this.an.addView(inflate);
                }
                a(f);
                return;
            } catch (Exception unused) {
                NativeAdEventListener nativeAdEventListener = this.as;
                if (nativeAdEventListener != null) {
                    nativeAdEventListener.onAdRenderFailed(80101);
                    return;
                }
                return;
            }
        }
        NativeAdEventListener nativeAdEventListener2 = this.as;
        if (nativeAdEventListener2 != null) {
            nativeAdEventListener2.onAdRenderFailed(80101);
        }
    }

    private void a(float f) {
        View view;
        if (this.an == null || (view = this.ao) == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_container);
        ImageView imageView = (ImageView) this.ao.findViewById(R.id.ad_image);
        TextView textView = (TextView) this.ao.findViewById(R.id.ad_feedback);
        FrameLayout frameLayout2 = (FrameLayout) this.ao.findViewById(R.id.ad_compliance);
        ImageView imageView2 = (ImageView) this.ao.findViewById(R.id.ad_logo);
        ImageView imageView3 = (ImageView) this.ao.findViewById(R.id.ad_logo_text);
        ImageView imageView4 = (ImageView) this.ao.findViewById(R.id.ad_close);
        TextView textView2 = (TextView) this.ao.findViewById(R.id.ad_title);
        TextView textView3 = (TextView) this.ao.findViewById(R.id.ad_action);
        this.T = (VideoView) this.ao.findViewById(R.id.ad_video);
        this.U = (TextureView) this.ao.findViewById(R.id.ad_texture);
        this.Y = (ProgressBar) this.ao.findViewById(R.id.ad_loading);
        if (!TextUtils.isEmpty(getTitle())) {
            textView2.setText(getTitle());
        }
        if (!TextUtils.isEmpty(getButtonText())) {
            textView3.setText(getButtonText());
        }
        if (!TextUtils.isEmpty(getLogoUrl()) && getLogoUrl().endsWith("octlogo.png")) {
            imageView2.setImageResource(R.drawable.oct_logo);
        } else {
            ImageManager.with(null).load(getLogoUrl()).into(imageView2);
        }
        if (!TextUtils.isEmpty(getTextLogoUrl()) && getTextLogoUrl().endsWith("remdad.png")) {
            imageView3.setImageResource(R.drawable.oct_logo_text);
        } else {
            ImageManager.with(null).load(getTextLogoUrl()).into(imageView3);
        }
        this.aq = new ArrayList();
        if (this.t) {
            imageView4.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            this.ar = arrayList;
            arrayList.add(imageView4);
        } else {
            imageView4.setVisibility(8);
        }
        this.an.post(new AnonymousClass1(f, imageView2, imageView3, textView2, imageView4, textView3, textView, frameLayout, imageView, frameLayout2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        c.o I;
        c.r b;
        ServerResponse serverResponse = this.M;
        if (serverResponse == null || serverResponse.l() != p.DRAW || (I = this.M.I()) == null || (b = I.b()) == null || b.a() != 1) {
            return;
        }
        a(view, b.b());
    }

    private void a(View view, String str) {
        View view2;
        try {
            if (this.an != null && (view2 = this.ao) != null) {
                RegionClickView regionClickView = (RegionClickView) view2.findViewById(R.id.regionClickView);
                if (TextUtils.isEmpty(str)) {
                    str = "点击跳转至第三方应用或详情页";
                }
                regionClickView.setTitle(str);
                regionClickView.setVisibility(0);
                this.aq.add(view);
                this.aq.add(regionClickView);
                o();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FrameLayout frameLayout) {
        AppCompatTextView appCompatTextView;
        if (frameLayout == null || (appCompatTextView = this.P) == null) {
            return;
        }
        ViewUtil.removeChildFromParent(appCompatTextView);
        frameLayout.addView(this.P, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup) {
        c.u uVar;
        if (viewGroup == null || (uVar = this.Q) == null || uVar.a() != 1) {
            return;
        }
        int i = this.x;
        if (i != 3 && i != 4) {
            addShakeView(viewGroup, 100, 10.0f);
        } else {
            addShakeView(viewGroup, com.bykv.vk.component.ttvideo.player.MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 13.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<View> arrayList, final float f) {
        final View next;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next instanceof TextView) {
                TextView textView = (TextView) next;
                textView.setTextSize(0, textView.getTextSize() * f);
            } else {
                next.post(new Runnable() { // from class: com.octopus.ad.internal.nativead.c.22
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewGroup.LayoutParams layoutParams = next.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = (int) (next.getWidth() * f);
                            layoutParams.height = (int) (next.getHeight() * f);
                            next.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
        }
    }

    public void a(boolean z) {
        this.af = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup, int i, float f) {
        ViewGroup viewGroup2;
        if (viewGroup != null) {
            try {
                c.u uVar = this.Q;
                if (uVar == null) {
                    return;
                }
                if (TextUtils.isEmpty(uVar.e())) {
                    if (this.Q.h() == 0) {
                        this.Q.a("摇动或点击了解更多");
                    } else {
                        this.Q.a("转动或点击了解更多");
                    }
                }
                if (this.R == null) {
                    b(viewGroup);
                }
                this.R.a("50%", "50%", i + "", i + "");
                if (this.M != null) {
                    viewGroup2 = viewGroup;
                    this.S = this.R.a(this.an, viewGroup2, f, this.Q.e(), this.M.l(), this.aj);
                } else {
                    viewGroup2 = viewGroup;
                }
                if (this.S != null) {
                    if (this.Q.b() == 1) {
                        this.y = 7;
                    }
                    if (this.Q.g() == 1) {
                        c(viewGroup2);
                    }
                    if (this.Q.i() == 1) {
                        this.S.setOnClickListener(this.au);
                        this.S.setOnTouchListener(this.av);
                    } else {
                        this.S.setOnClickListener(null);
                    }
                }
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.octopus.ad.model.d dVar) {
        if (this.ad || this.n || this.r) {
            boolean z = false;
            if (System.currentTimeMillis() - l.f12712a > 2000) {
                this.p = true;
                x();
                a aVar = this.N;
                boolean z2 = aVar != null && aVar.g();
                NativeAdEventListener nativeAdEventListener = this.as;
                if (nativeAdEventListener != null && z2) {
                    Boolean bool = Boolean.TRUE;
                    Boolean bool2 = this.z;
                    if (bool == bool2 || (Boolean.FALSE != bool2 && !this.q && !this.A && !this.B)) {
                        z = true;
                    }
                }
                if (z) {
                    nativeAdEventListener.onAdClick();
                }
                ServerResponse serverResponse = this.M;
                if (serverResponse != null) {
                    serverResponse.b(z);
                    this.M.a(this.O, this.y, this.n, this.r, z2, dVar);
                }
                l.f12712a = System.currentTimeMillis();
                return;
            }
            this.q = false;
            this.y = 0;
        }
    }

    private void a(final NativeAdShownListener nativeAdShownListener) {
        if (this.E || this.an == null) {
            return;
        }
        x xVar = this.ax;
        if (xVar != null) {
            xVar.c();
        }
        Object tag = this.an.getTag(55665918);
        if (tag instanceof x) {
            ((x) tag).c();
        }
        x a2 = x.a(this.an);
        this.ax = a2;
        this.an.setTag(55665918, a2);
        if (this.ax == null) {
            return;
        }
        if (this.N != null) {
            this.az = h.a(this.an, (NativeAdShownListener) null);
            this.aA = new ArrayList<>();
            Iterator<String> it = this.I.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.contains("?rv=1")) {
                    ViewUtil.openLocalBrowser(next, 0);
                } else {
                    if (next.contains("track=oct")) {
                        if (!this.N.g()) {
                            next = next.concat("&opt=4");
                        } else {
                            ServerResponse serverResponse = this.M;
                            if (serverResponse != null && !serverResponse.O()) {
                                next = next.concat("&opt=11");
                            }
                        }
                    }
                    String str = next;
                    long currentTimeMillis = System.currentTimeMillis();
                    com.octopus.ad.internal.d i = this.N.i();
                    if (i != null) {
                        currentTimeMillis = i.h();
                    }
                    n a3 = n.a("imp", this.N.c(), f(), currentTimeMillis, str, this.ax, this.an.getContext(), this.I);
                    if (a3 != null && str.contains("track=octimp")) {
                        a3.a(new HTTPGet.ResponseListener() { // from class: com.octopus.ad.internal.nativead.c.8
                            @Override // com.octopus.ad.internal.utilities.HTTPGet.ResponseListener
                            public void getResponse(int i2, boolean z, String str2) {
                                if (nativeAdShownListener != null) {
                                    if (z && c.this.N != null) {
                                        z = c.this.N.g();
                                    }
                                    nativeAdShownListener.onAdShown(z);
                                }
                            }
                        });
                    }
                    if (a3 != null) {
                        this.aA.add(a3);
                    }
                }
            }
        } else {
            this.ad = true;
        }
        this.ap = this.an;
        ServerResponse serverResponse2 = this.M;
        if (serverResponse2 == null || this.v) {
            return;
        }
        this.v = true;
        AdViewImpl.a(serverResponse2, new AdViewImpl.c() { // from class: com.octopus.ad.internal.nativead.c.9
            @Override // com.octopus.ad.internal.view.AdViewImpl.c
            public void a() {
                if (c.this.o || c.this.p || c.this.ap == null || c.this.M == null) {
                    return;
                }
                if (AdViewImpl.a(c.this.M)) {
                    c.this.q = false;
                    c.this.y = 0;
                } else {
                    c.this.q = true;
                    c.this.y = 9;
                }
                c cVar = c.this;
                cVar.a(cVar.v());
            }
        });
        this.z = this.M.P();
    }

    public void a(ServerResponse serverResponse) {
        this.M = serverResponse;
    }

    public void a(String str) {
        this.ac = str;
    }

    public void a(a aVar) {
        this.N = aVar;
    }

    public void a(long j, long j2) {
        c.l i;
        if (this.M == null || !q.a().d() || (i = this.M.i()) == null || TextUtils.isEmpty(i.c())) {
            return;
        }
        q.a().a(this.M.ac());
        if (i.b() == 1) {
            this.ab = q.a().g.get(i.c());
        }
        com.octopus.ad.model.a aVar = this.ab;
        if (aVar == null || !aVar.j() || this.ab.f() < getPrice()) {
            com.octopus.ad.model.a aVar2 = new com.octopus.ad.model.a();
            this.ab = aVar2;
            aVar2.a(getPrice());
            this.ab.a(j);
            this.ab.b(j2);
            this.ab.a(f());
            this.ab.b(i.a());
            this.ab.b(i.c());
            this.ab.c(i.d());
            this.ab.a(this.M.S());
            this.ab.e(this.M.V());
            if (this.M.a() != null) {
                this.ab.d(this.M.T());
                this.ab.a(this.M.a().t());
            }
            q.a().g.put(i.c(), this.ab);
        }
    }

    public void a(c.b bVar) {
        this.aE = bVar;
        if (bVar != null) {
            this.aF = bVar.i();
        }
    }

    public void a(int i, String str, String str2) {
        ServerResponse serverResponse = this.M;
        if (serverResponse != null) {
            serverResponse.a(i, str, str2);
        }
    }
}
