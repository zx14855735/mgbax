package com.kwad.components.core.widget;

import COJEAR.B9tovu;
import COJEAR.BChYOn;
import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.y;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements B9tovu {
    private BChYOn WM;
    private com.kwad.components.core.video.e Xe;
    private ViewGroup Zj;
    private ImageView amA;
    private ViewGroup amB;
    private ViewGroup amC;
    private TextView amD;
    private ViewGroup amE;
    private int amF;
    private boolean amG;
    private boolean amH;
    private long amI;
    private boolean amJ;
    private KsAdVideoPlayConfig amK;
    private a amL;
    private View amM;
    private boolean amN;
    private Runnable amO;
    private y amP;
    private RatioFrameLayout amq;
    private TextView amr;
    private TextView ams;
    private TextView amt;
    private View amu;
    private KSCornerImageView amv;
    private TextView amw;
    private ScaleAnimSeekBar amx;
    private ImageView amy;
    private ImageView amz;
    private List<Integer> ck;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0370a cz;
    private KsAppDownloadListener dW;
    private View.OnClickListener fN;
    private TextView hA;
    private ImageView hM;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public interface a {
        void sc();

        void sd();
    }

    public FeedVideoView(Context context) {
        super(context);
        this.amF = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.amB.setVisibility(8);
                FeedVideoView.this.amA.setVisibility(8);
                if (FeedVideoView.this.Xe != null) {
                    FeedVideoView.this.Xe.aV(true);
                }
            }
        };
        this.amO = runnable;
        this.amP = new y(runnable);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dW == null) {
            this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.amt.setText(com.kwad.sdk.core.response.b.a.aF(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.amt.setText(com.kwad.sdk.core.response.b.a.cp(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.amt.setText(com.kwad.sdk.core.response.b.a.aF(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.amt.setText(com.kwad.sdk.core.response.b.a.ad(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    FeedVideoView.this.amt.setText(com.kwad.sdk.core.response.b.a.dY(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    FeedVideoView.this.amt.setText(com.kwad.sdk.core.response.b.a.dX(i));
                }
            };
        }
        return this.dW;
    }

    private boolean xA() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.amI;
        if (j > 888) {
            this.amI = elapsedRealtime;
        }
        return j > 888;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB() {
        a aVar = this.amL;
        if (aVar != null) {
            aVar.sc();
        }
        if ((this.amF == 100) && xA()) {
            this.amC.setVisibility(0);
            this.amD.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.b.a.S(this.mAdInfo) > com.kwad.sdk.core.response.b.a.R(this.mAdInfo);
            this.amG = aq.dq(getContext());
            getContext();
            this.amH = aq.SM();
            if (z) {
                aq.dt(getContext());
            } else {
                aq.ds(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.amE.getParent();
            this.Zj = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.amE);
                View view = new View(this.amE.getContext());
                this.amM = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.amE.getWidth(), this.amE.getHeight()));
                viewGroup.addView(this.amM);
            }
            aq.g(getContext(), false);
            Activity activityFromContext = m.getActivityFromContext(getContext());
            if (activityFromContext != null) {
                ViewGroup viewGroup2 = (ViewGroup) activityFromContext.getWindow().getDecorView();
                this.amE.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.amq.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.amE, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC() {
        if ((this.amF == 101) & xA()) {
            this.amC.setVisibility(8);
            if (this.amG) {
                aq.dq(getContext());
            } else {
                aq.dr(getContext());
            }
            if (this.amH) {
                aq.dt(getContext());
            } else {
                aq.ds(getContext());
            }
            aq.g(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.amE.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.amE);
            }
            this.amE.setLayoutParams(new ViewGroup.LayoutParams(this.Zj.getWidth(), this.Zj.getHeight()));
            this.amq.setRatio(0.5600000023841858d);
            View view = this.amM;
            if (view != null) {
                this.Zj.removeView(view);
                this.amM = null;
            }
            this.Zj.addView(this.amE, new FrameLayout.LayoutParams(-1, -2));
            this.amE.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.amL;
        if (aVar != null) {
            aVar.sd();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.k
    public final void G(View view) {
        super.G(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bs() {
        super.bs();
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        sO();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.amP);
            getHandler().postDelayed(this.amP, PushUIConfig.dismissTime);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bt() {
        super.bt();
        if (this.cq != null) {
            uX();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.amP);
                getHandler().postDelayed(this.amP, PushUIConfig.dismissTime);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bv() {
        this.WM = new BChYOn(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.amq = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.hM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.hA = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.amx = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.amx.setMinProgress(0);
        this.amt = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.amu = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.amw = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.amv = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.amr = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.ams = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.amy = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.amA = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.amz = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.amB = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.amE = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.amC = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.amD = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.WM.A2egSU(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.WM.A4TApA(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.WM.A5SV6n(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.WM.ADYaiT(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // com.kwad.components.core.widget.b
    public int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.WM.ARc23Z(0);
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.WM.f1647ADYaiT;
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.Xe;
        if (eVar != null) {
            eVar.release();
        }
    }

    public final void sK() {
        this.Xe.vr();
    }

    public final void sO() {
        this.Xe.vu();
        this.Xe.setVisibility(0);
        this.Xe.setAlpha(1.0f);
        this.amy.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.amA.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.WM.ASJ6gh(z);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.fN = onClickListener;
    }

    public void setUIWithStateAndMode(int i) {
        if (i == 101) {
            this.amz.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.amz.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
        this.amF = i;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.amL = aVar;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.WM.AYUAbz(i, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.WM.AZOQYO(0);
    }

    public final void uX() {
        this.Xe.vt();
        this.amA.setVisibility(0);
        this.amA.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.amy.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    public final boolean xD() {
        if (this.amF != 101) {
            return false;
        }
        xC();
        return true;
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
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d((FeedVideoView) adResultData);
    }

    public static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z) {
        feedVideoView.amN = true;
        return true;
    }

    public final void a(KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.d dVar) {
        this.mApkDownloadHelper = dVar;
        this.amN = false;
        com.kwad.sdk.core.response.model.b bv = com.kwad.sdk.core.response.b.a.bv(this.mAdInfo);
        this.amK = ksAdVideoPlayConfig;
        String url = bv.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate);
            this.hM.setVisibility(0);
        } else {
            this.hM.setVisibility(8);
        }
        this.ck = com.kwad.sdk.core.response.b.a.bq(this.mAdInfo);
        String L = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
        if (TextUtils.isEmpty(L)) {
            return;
        }
        this.cq = AdVideoPlayerViewCache.getInstance().eV(L);
        if (com.kwad.sdk.core.response.b.a.ar(this.mAdInfo)) {
            this.hA.setVisibility(8);
            View view = this.amu;
            if (view != null) {
                view.setVisibility(0);
                this.amt.setText(com.kwad.sdk.core.response.b.a.aF(this.mAdInfo));
                this.amw.setText(com.kwad.sdk.core.response.b.a.cm(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.amv, com.kwad.sdk.core.response.b.a.cp(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.d dVar2 = this.mApkDownloadHelper;
                if (dVar2 != null) {
                    dVar2.b(getAppDownloadListener());
                }
                this.amt.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.fN != null) {
                            FeedVideoView.this.fN.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.amu;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.hA.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar == null) {
            this.cq = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.b.a.ac(this.mAdInfo);
            this.cq.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).dt(com.kwad.sdk.core.response.b.e.et(this.mAdTemplate)).du(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.es(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Ga(), null);
            a.InterfaceC0370a interfaceC0370a = new a.InterfaceC0370a() { // from class: com.kwad.components.core.widget.FeedVideoView.6
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0370a
                public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                    if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aGw)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aGx)).booleanValue()) {
                        return null;
                    }
                    com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, FeedVideoView.this.mAdTemplate);
                    if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                        return gVar;
                    }
                    return null;
                }
            };
            this.cz = interfaceC0370a;
            this.cq.setExternalPlayerListener(interfaceC0370a);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.cq, ksAdVideoPlayConfig);
            this.Xe = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.cq.setController(this.Xe);
            this.Xe.setAutoRelease(false);
            if (com.kwad.sdk.core.config.e.GE() == 2) {
                AdVideoPlayerViewCache.getInstance().a(L, this.cq);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.ck = (List) this.cq.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.cq.getController();
            this.Xe = eVar2;
            eVar2.setAutoRelease(false);
            this.Xe.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.cq.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.cq.getParent() != null) {
            ((ViewGroup) this.cq.getParent()).removeView(this.cq);
            this.Xe.vr();
        }
        if (this.amq.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.amq;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.amq.setTag(null);
        }
        this.amq.addView(this.cq);
        this.amq.setTag(this.cq);
        this.amB.setVisibility(8);
        this.amA.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.hA.setVisibility(8);
        } else {
            this.hA.setVisibility(0);
            this.hA.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Xe, this.cq);
    }

    public FeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amF = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.amB.setVisibility(8);
                FeedVideoView.this.amA.setVisibility(8);
                if (FeedVideoView.this.Xe != null) {
                    FeedVideoView.this.Xe.aV(true);
                }
            }
        };
        this.amO = runnable;
        this.amP = new y(runnable);
    }

    public FeedVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amF = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.amB.setVisibility(8);
                FeedVideoView.this.amA.setVisibility(8);
                if (FeedVideoView.this.Xe != null) {
                    FeedVideoView.this.Xe.aV(true);
                }
            }
        };
        this.amO = runnable;
        this.amP = new y(runnable);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.amE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.amB.getVisibility() != 8) {
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.amO);
                        if (FeedVideoView.this.amJ) {
                            return;
                        }
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.amP, 1000L);
                        return;
                    }
                    return;
                }
                if (!FeedVideoView.this.cq.isCompleted()) {
                    FeedVideoView.this.amB.setVisibility(0);
                    FeedVideoView.this.amA.setVisibility(0);
                    if (FeedVideoView.this.Xe != null) {
                        FeedVideoView.this.Xe.aV(false);
                    }
                    if (FeedVideoView.this.getHandler() != null) {
                        FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.amO);
                        FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.amP, PushUIConfig.dismissTime);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.amF != 101) {
                    if (FeedVideoView.this.fN != null) {
                        FeedVideoView.this.fN.onClick(view);
                        return;
                    }
                    return;
                }
                FeedVideoView.this.amB.setVisibility(0);
                FeedVideoView.this.amA.setVisibility(8);
                if (FeedVideoView.this.Xe != null) {
                    FeedVideoView.this.Xe.aV(false);
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.amO);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.amP, PushUIConfig.dismissTime);
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            private boolean eE = false;

            @Override // com.kwad.components.core.video.a.c
            public final void ap() {
                if (!FeedVideoView.this.amN) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.aq(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setLooping(com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.eE) {
                    return;
                }
                this.eE = true;
                com.kwad.components.core.o.a.tz().a(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.adlog.c.cb(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.amB.setVisibility(8);
                FeedVideoView.this.amA.setVisibility(8);
                FeedVideoView.this.amx.setProgress(100);
                FeedVideoView.this.ams.setText(bu.aq(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                FeedVideoView.this.c(j);
                float duration = (j * 100.0f) / aVar2.getDuration();
                if (!FeedVideoView.this.amJ) {
                    FeedVideoView.this.amx.setProgress((int) duration);
                    FeedVideoView.this.ams.setText(bu.aq(j));
                }
                FeedVideoView.this.amr.setText(bu.aq(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.amN) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.aq(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.cq.setLooping(com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.adlog.c.ca(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.amr.setText(bu.aq(aVar2.getDuration()));
            }
        });
        this.Xe.setAdClickListener(new a.InterfaceC0313a() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // com.kwad.components.core.video.a.InterfaceC0313a
            public final void a(int i, aj.a aVar3) {
                int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            i2 = com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i3 = 1;
                            z = true;
                        } else if (com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo) == 0) {
                            i2 = 108;
                        }
                    } else if (com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo) == 0) {
                        i2 = 82;
                    }
                } else if (com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo) == 0) {
                    i2 = 13;
                }
                com.kwad.components.core.e.d.a.a(new a.C0291a(FeedVideoView.this.getContext()).aE(FeedVideoView.this.mAdTemplate).ax(true).b(FeedVideoView.this.mApkDownloadHelper).aD(i3).as(z).au(true).aC(i2).d(aVar3).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.xw();
                    }
                }));
            }
        });
        this.amx.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    FeedVideoView.this.amx.bz(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.amP);
                    FeedVideoView.this.amJ = true;
                    FeedVideoView.this.ams.setText(bu.aq((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void xE() {
                FeedVideoView.this.amx.bz(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.amP);
                FeedVideoView.this.amJ = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.amx.bz(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.amP);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.amP, PushUIConfig.dismissTime);
                }
                FeedVideoView.this.amJ = false;
            }
        });
        this.amy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (aVar2.isPaused() || aVar2.isIdle()) {
                    FeedVideoView.this.Xe.vu();
                    FeedVideoView.this.amy.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.amA.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                } else if (aVar2.isPlaying()) {
                    FeedVideoView.this.Xe.vt();
                    FeedVideoView.this.amA.setVisibility(0);
                    FeedVideoView.this.amA.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                    FeedVideoView.this.amy.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.amP);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.amP, PushUIConfig.dismissTime);
                }
            }
        });
        this.amA.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.cq.isPaused() || FeedVideoView.this.cq.isIdle()) {
                    FeedVideoView.this.sO();
                } else if (FeedVideoView.this.cq.isPlaying()) {
                    FeedVideoView.this.uX();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.amP);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.amP, PushUIConfig.dismissTime);
                }
            }
        });
        this.amC.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.xC();
            }
        });
        this.amz.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.amF == 100) {
                    FeedVideoView.this.xB();
                } else if (FeedVideoView.this.amF == 101) {
                    FeedVideoView.this.xC();
                }
            }
        });
    }
}
