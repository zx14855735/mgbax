package com.kwad.components.ad.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.c.c.b;
import com.kwad.components.ad.c.e;
import com.kwad.components.ad.c.f;
import com.kwad.components.core.m.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.d;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a extends c<com.kwad.components.ad.c.c> implements View.OnClickListener, d {
    private KsAdVideoPlayConfig bU;
    private a.b cA;
    private OfflineOnAudioConflictListener cB;
    private f ce;
    private List<Integer> ck;
    private FrameLayout cl;
    private ImageView cm;
    private LinearLayout cn;
    private ImageView co;
    private boolean cp;
    private com.kwad.sdk.core.video.videoview.a cq;
    private e cr;
    private LinearLayout cs;
    private TextView ct;
    private TextView cu;
    private TextView cv;
    private ImageView cw;
    private KsLogoView cx;
    public InterfaceC0224a cy;
    private a.InterfaceC0370a cz;
    private AdInfo mAdInfo;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;

    /* renamed from: com.kwad.components.ad.c.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0224a {
        void a(int i, int i2, AdTemplate adTemplate);

        void ar();

        void d(AdTemplate adTemplate);

        void e(AdTemplate adTemplate);
    }

    public a(Context context, AdTemplate adTemplate, InterfaceC0224a interfaceC0224a) {
        super(context);
        this.mIsAudioEnable = true;
        this.cA = new a.b() { // from class: com.kwad.components.ad.c.b.a.1
            @Override // com.kwad.components.core.video.a.c
            public final void ap() {
                com.kwad.sdk.core.video.videoview.a aVar = a.this.cq;
                a aVar2 = a.this;
                aVar.setVideoSoundEnable(aVar2.f(aVar2.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.adlog.c.cb(((com.kwad.components.ad.c.c) a.this.SR).mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                a.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                InterfaceC0224a interfaceC0224a2 = a.this.cy;
                if (interfaceC0224a2 != null) {
                    interfaceC0224a2.ar();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.ca(a.this.mAdTemplate);
            }
        };
        this.cB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.c.b.a.2
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.b(a.this, false);
                if (a.this.cq != null) {
                    a.this.cq.setVideoSoundEnable(false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.mAdTemplate = adTemplate;
        this.mAdScene = adTemplate.mAdScene;
        this.cy = interfaceC0224a;
        this.mContext = getContext();
        rj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.c
    /* renamed from: al, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ad.c.c ak() {
        f fVar = new f(this.nX, com.kwad.sdk.core.response.b.a.cH(this.mAdInfo));
        this.ce = fVar;
        fVar.xJ();
        com.kwad.components.ad.c.c cVar = new com.kwad.components.ad.c.c();
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.mAdScene = this.mAdScene;
        cVar.mApkDownloadHelper = this.mApkDownloadHelper;
        return cVar;
    }

    private static Presenter am() {
        Presenter presenter = new Presenter();
        presenter.a(new b());
        return presenter;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean ao() {
        /*
            r3 = this;
            boolean r0 = com.kwad.sdk.core.config.e.HA()
            r1 = 1
            if (r0 != 0) goto L14
            android.content.Context r0 = r3.mContext
            com.kwad.components.core.s.a r0 = com.kwad.components.core.s.a.aG(r0)
            boolean r0 = r0.ur()
            if (r0 == 0) goto L14
            goto L34
        L14:
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.bU
            boolean r2 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
            if (r2 == 0) goto L2a
            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
            int r0 = r0.getVideoSoundValue()
            if (r0 == 0) goto L2a
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.bU
            boolean r0 = r0.isVideoSoundEnable()
            r0 = r0 ^ r1
            goto L35
        L2a:
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.bY(r0)
            if (r0 != 0) goto L33
            goto L34
        L33:
            r1 = 0
        L34:
            r0 = r1
        L35:
            com.kwad.sdk.core.response.model.AdTemplate r1 = r3.mAdTemplate
            if (r1 == 0) goto L3d
            r2 = r0 ^ 1
            r1.mIsAudioEnable = r2
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.b.a.ao():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z) {
        if (!z) {
            return false;
        }
        if (!com.kwad.sdk.core.config.e.HA()) {
            return !com.kwad.components.core.s.a.aG(this.mContext).us() ? com.kwad.components.core.s.a.aG(this.mContext).aU(false) : !com.kwad.components.core.s.a.aG(this.mContext).ur();
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.s.a.aG(this.mContext).aU(true);
        }
        return this.cp;
    }

    @Override // com.kwad.components.core.m.c, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
    }

    @Override // com.kwad.components.core.m.c
    public final boolean ai() {
        return true;
    }

    public final void an() {
        this.cl.setVisibility(0);
        this.cy.d(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.m.c
    public final int getLayoutId() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels > displayMetrics.heightPixels ? R.layout.ksad_banner_item_land : R.layout.ksad_banner_item;
    }

    @Override // com.kwad.components.core.m.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.er(this.mAdTemplate);
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.cl || view == this.cm || view == this.cq || view == this.co) {
            this.cy.a(100, 3, this.mAdTemplate);
            return;
        }
        if (view == this.cs || view == this.cn) {
            this.cy.a(53, 2, this.mAdTemplate);
            return;
        }
        if (view == this.ct) {
            this.cy.a(32, 2, this.mAdTemplate);
            return;
        }
        if (view == this.cu) {
            this.cy.a(31, 2, this.mAdTemplate);
        } else if (view == this.cv) {
            this.cy.a(29, 1, this.mAdTemplate);
        } else if (view == this.cw) {
            this.cy.e(this.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.m.c
    public final Presenter onCreatePresenter() {
        getContext();
        return am();
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.cp = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eg(this.mAdTemplate)) {
            onClick(view);
        }
    }

    @Override // com.kwad.components.core.m.c
    public final void a(ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) this.nX.findViewById(R.id.ksad_banner_item_content);
        this.cl = frameLayout;
        frameLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.nX.findViewById(R.id.ksad_banner_item_info);
        this.cs = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.nX.findViewById(R.id.ksad_banner_item_des);
        this.ct = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.ct.setOnClickListener(this);
        TextView textView2 = (TextView) this.nX.findViewById(R.id.ksad_banner_item_title);
        this.cu = textView2;
        textView2.setText(com.kwad.sdk.core.response.b.a.cm(this.mAdInfo));
        this.cu.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.nX.findViewById(R.id.ksad_banner_button_base);
        this.cn = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView3 = (TextView) this.nX.findViewById(R.id.ksad_banner_item_button);
        this.cv = textView3;
        textView3.setText(com.kwad.sdk.core.response.b.a.aF(this.mAdInfo));
        this.cv.setOnClickListener(this);
        ImageView imageView = (ImageView) this.nX.findViewById(R.id.ksad_banner_item_close);
        this.cw = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.nX.findViewById(R.id.ksad_banner_item_image);
        this.cm = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.nX.findViewById(R.id.ksad_banner_item_image_bg);
        this.co = imageView3;
        imageView3.setOnClickListener(this);
        this.cx = (KsLogoView) this.nX.findViewById(R.id.ksad_banner_logo);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(this.mAdInfo)) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).materialUrl)) {
            int i = (int) ((this.mContext.getResources().getDisplayMetrics().density * 40.0f) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 17;
            this.cm.setLayoutParams(layoutParams);
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.cp(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setCornerRound(8).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.3
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BitmapFactory.decodeStream(inputStream);
                    return true;
                }
            });
        } else if (!com.kwad.sdk.core.response.b.a.be(this.mAdInfo)) {
            this.cm.setScaleType(ImageView.ScaleType.CENTER_CROP);
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.bv(this.mAdInfo).getUrl(), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.4
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.cm.setOnClickListener(this);
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            AdInfo.AdMaterialInfo.MaterialFeature aV = com.kwad.sdk.core.response.b.a.aV(this.mAdInfo);
            if (!TextUtils.isEmpty(aV.materialUrl)) {
                int i2 = aV.width;
                int i3 = aV.height;
                if (i2 > 0 && i2 < i3) {
                    this.co.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    KSImageLoader.loadImage(this.co, com.kwad.sdk.core.response.b.a.P(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.5
                        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                            return true;
                        }
                    });
                    int i4 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((i4 / 16) * 9, i4);
                    layoutParams2.gravity = 5;
                    layoutParams2.rightMargin = (int) ((displayMetrics.density * 14.0f) + 0.5f);
                    this.cm.setLayoutParams(layoutParams2);
                }
            }
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).materialUrl, this.mAdTemplate);
        }
        this.cx.aS(this.mAdTemplate);
        this.cl.setVisibility(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.kwad.sdk.api.KsAdVideoPlayConfig r9) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.b.a.a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }
}
