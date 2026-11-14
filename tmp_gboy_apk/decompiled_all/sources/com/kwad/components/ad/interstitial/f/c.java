package com.kwad.components.ad.interstitial.f;

import BmvVmW.ASJ6gh;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class c extends com.kwad.sdk.mvp.a {
    public KsAdVideoPlayConfig bU;
    public com.kwad.sdk.core.video.videoview.a cq;
    public KSFrameLayout fV;
    public com.kwad.components.ad.interstitial.g.b kN;
    public KsInterstitialAd.AdInteractionListener kP;
    public com.kwad.components.ad.interstitial.d kV;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.d mApkDownloadHelper;
    public com.kwad.components.ad.interstitial.h.d mj;
    public boolean mk;
    public boolean ml;
    public boolean mm;
    public a mn;
    public com.kwad.components.core.webview.tachikoma.f.g mp;
    public e mq;
    public boolean mu;
    public boolean mv;
    public List<b> mo = new CopyOnWriteArrayList();
    private Handler iK = new Handler(Looper.getMainLooper());
    public volatile boolean mt = false;
    public int mw = -1;

    /* renamed from: ms, reason: collision with root package name */
    public List<a.c> f12319ms = new CopyOnWriteArrayList();
    public List<d> mr = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.f.c$3, reason: invalid class name */
    public class AnonymousClass3 implements ImageLoadingListener {
        final /* synthetic */ Context dq;
        final /* synthetic */ View eu;

        public AnonymousClass3(Context context, View view) {
            this.dq = context;
            this.eu = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            h.execute(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.3.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.dq.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final ASJ6gh aSJ6gh = new ASJ6gh(AnonymousClass3.this.dq.getResources(), stackBlur);
                    if (aSJ6gh.f1513ASJ6gh != dimension) {
                        boolean z = dimension > 0.05f;
                        Paint paint = aSJ6gh.f1511ADYaiT;
                        if (z) {
                            paint.setShader(aSJ6gh.AMqCpz);
                        } else {
                            paint.setShader(null);
                        }
                        aSJ6gh.f1513ASJ6gh = dimension;
                        aSJ6gh.invalidateSelf();
                    }
                    AnonymousClass3.this.eu.post(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.3.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            AnonymousClass3.this.eu.setBackground(aSJ6gh);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    public interface a {
        void a(long j, long j2, boolean z);
    }

    public interface b {
        void c(long j, long j2);
    }

    /* renamed from: com.kwad.components.ad.interstitial.f.c$c, reason: collision with other inner class name */
    public static class C0240c {
        private final Context context;
        private int mF;
        private boolean mG;
        private int mH;
        private boolean mI;
        private aj.a mJ;
        public double mK;
        public boolean mL;

        public C0240c(Context context) {
            this.context = context;
        }

        public final C0240c L(int i) {
            this.mF = i;
            return this;
        }

        public final C0240c M(int i) {
            this.mH = i;
            return this;
        }

        public final C0240c a(aj.a aVar) {
            this.mJ = aVar;
            return this;
        }

        public final int dX() {
            return this.mF;
        }

        public final boolean dY() {
            return this.mG;
        }

        public final boolean dZ() {
            return this.mI;
        }

        public final int ea() {
            return this.mH;
        }

        public final double eb() {
            return this.mK;
        }

        public final Context getContext() {
            return this.context;
        }

        public final aj.a getTouchCoords() {
            return this.mJ;
        }

        public final C0240c l(boolean z) {
            this.mG = z;
            return this;
        }

        public final C0240c m(boolean z) {
            this.mI = true;
            return this;
        }

        public final C0240c n(boolean z) {
            this.mL = true;
            return this;
        }

        public final C0240c c(double d) {
            this.mK = d;
            return this;
        }
    }

    public interface d {
        void ec();
    }

    public interface e {
        void ed();
    }

    public final boolean M(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return com.kwad.sdk.core.response.b.a.bL(com.kwad.sdk.core.response.b.e.er(adTemplate));
        }
        com.kwad.sdk.core.d.c.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
        return false;
    }

    public final void Y() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kP;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public final void b(a.c cVar) {
        this.f12319ms.remove(cVar);
    }

    public final void dU() {
        e eVar = this.mq;
        if (eVar != null) {
            eVar.ed();
        }
    }

    public final void dV() {
        Iterator<d> it = this.mr.iterator();
        while (it.hasNext()) {
            it.next().ec();
        }
    }

    public final boolean dW() {
        com.kwad.components.ad.interstitial.h.d dVar = this.mj;
        boolean z = dVar == null || dVar.getParent() == null;
        A2egSU.B9tovu("isH5Interstitial :", "InterstitialCallerContext", z);
        return z;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.iK.removeCallbacksAndMessages(null);
        this.f12319ms.clear();
        this.mr.clear();
        com.kwad.components.ad.interstitial.g.b bVar = this.kN;
        if (bVar != null) {
            bVar.xK();
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    public final void b(C0240c c0240c) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.f(c0240c.getTouchCoords());
        if (!c0240c.dY() && !c0240c.mI) {
            c0240c.M(MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dv(c0240c.ea()).f(c0240c.getTouchCoords()).dJ(aq.SM() ? 2 : 1).l(c0240c.eb()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null) {
            long a2 = a(aVar);
            int b2 = b(this.cq);
            bVar.aw(a2);
            bVar.dD(b2);
        }
        this.mk = true;
        c(1L, c0240c.mH);
    }

    public final void c(long j, long j2) {
        Iterator<b> it = this.mo.iterator();
        while (it.hasNext()) {
            it.next().c(j, j2);
        }
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.kP;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        a aVar = this.mn;
        if (aVar != null) {
            aVar.a(j, j2, true);
        }
    }

    public final void a(a.c cVar) {
        if (this.f12319ms.contains(cVar)) {
            return;
        }
        this.f12319ms.add(cVar);
    }

    public final boolean a(final C0240c c0240c) {
        com.kwad.components.ad.interstitial.report.a.eP().a(this.mAdTemplate, 1L, c0240c.mH);
        boolean z = c0240c.dX() == 1;
        boolean z2 = com.kwad.components.ad.interstitial.b.b.dL() || z || c0240c.dZ() || c0240c.mL;
        if (z2) {
            com.kwad.components.core.e.d.a.a(new a.C0291a(c0240c.getContext()).aE(this.mAdTemplate).b(this.mApkDownloadHelper).as(z).aB(1).aC(c0240c.mH).A(this.cq.getCurrentPosition()).aD(c0240c.dX()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.c.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(c0240c);
                    c cVar = c.this;
                    if (cVar.kV == null || !com.kwad.components.ad.interstitial.d.b.t(cVar.mAdTemplate)) {
                        return;
                    }
                    c cVar2 = c.this;
                    cVar2.a(false, -1, cVar2.cq);
                    c.this.iK.postDelayed(new bg() { // from class: com.kwad.components.ad.interstitial.f.c.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            c.this.kV.dismiss();
                            c.this.Y();
                        }
                    }, 500L);
                }
            }));
        }
        return z2;
    }

    public final void c(Context context, AdTemplate adTemplate) {
        if (this.mt) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.mt = true;
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.mo.remove(bVar);
    }

    private static int b(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((currentPosition / duration) * 100.0f);
        }
        return -1;
    }

    public final void a(final Context context, final int i, int i2, int i3) {
        com.kwad.components.ad.interstitial.report.a.eP().a(this.mAdTemplate, 6L, i);
        final int i4 = 9;
        com.kwad.components.core.e.d.a.a(new a.C0291a(context).aE(this.mAdTemplate).b(this.mApkDownloadHelper).as(false).aD(2).aB(6).aC(i).a(new a.b() { // from class: com.kwad.components.ad.interstitial.f.c.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i5 = i4;
                int i6 = i;
                cVar.a(i5, i6, context, 6L, i6);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context, long j, long j2) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().dC(i).dv(i2).dJ(aq.SM() ? 2 : 1).GB(), (JSONObject) null);
        this.mk = true;
        c(j, j2);
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.mo.add(bVar);
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.aX(adInfo) && !aq.SM();
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.bv(adInfo).getUrl();
        if (bp.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view));
    }

    public final void a(boolean z, int i, com.kwad.sdk.core.video.videoview.a aVar) {
        long j;
        int a2;
        com.kwad.components.ad.interstitial.report.a.eP().a(this.mAdTemplate, bz.k(this.fV, true));
        if (aVar != null) {
            j = a(aVar);
            a2 = b(aVar);
        } else {
            j = i;
            a2 = a(j, this.mAdTemplate);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, z ? 14 : 1, j, a2, this.kV.getTimerHelper().getTime(), null);
    }

    private static long a(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    private static int a(long j, AdTemplate adTemplate) {
        if (j == -1) {
            return -1;
        }
        float N = com.kwad.sdk.core.response.b.a.N(com.kwad.sdk.core.response.b.e.er(adTemplate)) / 1000.0f;
        if (N != 0.0f) {
            return Math.round((j / N) * 100.0f);
        }
        return -1;
    }
}
