package com.kwad.components.ad.c.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.bg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a extends c {
    private FrameLayout cV;
    private boolean cW;
    private az cX;
    private o cY;
    private boolean cp;
    private Context mContext;

    public a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        if (this.cD.bO) {
            return;
        }
        az azVar = this.cX;
        if (azVar != null) {
            azVar.wk();
            this.cX.wg();
            this.cX.wh();
        }
        this.cV.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cV;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cv(this.cD.mAdTemplate).bannerTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_full_tk_card_view);
        this.cV = frameLayout;
        b((ViewGroup) frameLayout.getParent());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.wi();
            this.cX.wj();
        }
        super.onUnbind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z) {
        if (!z) {
            com.kwad.components.core.s.a.aG(this.mContext).aU(false);
            return false;
        }
        if (!e.HA()) {
            return !com.kwad.components.core.s.a.aG(this.mContext).us() ? com.kwad.components.core.s.a.aG(this.mContext).aU(false) : !com.kwad.components.core.s.a.aG(this.mContext).ur();
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.s.a.aG(this.mContext).aU(true);
        }
        return this.cp;
    }

    private void b(ViewGroup viewGroup) {
        if (e.Hz() || e.Hy() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new a.InterfaceC0325a() { // from class: com.kwad.components.ad.c.d.a.1
            @Override // com.kwad.components.core.widget.a.InterfaceC0325a
            public final void aa() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0325a
            public final void ab() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0325a
            public final void ax() {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewFirstInVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0325a
            public final void c(View view) {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0325a
            public final void onWindowFocusChanged(boolean z) {
                if (a.this.cX != null) {
                    if (!z) {
                        a aVar2 = a.this;
                        aVar2.f(aVar2.cD.mAdTemplate.mIsAudioEnable);
                        a.this.cX.wl();
                        return;
                    }
                    a.this.cX.wk();
                    n nVar = new n();
                    if (a.this.cW) {
                        a aVar3 = a.this;
                        nVar.alc = !aVar3.f(aVar3.cD.mAdTemplate.mIsAudioEnable);
                    } else {
                        nVar.alc = false;
                    }
                    a.this.cY.c(nVar);
                }
            }
        });
        aVar.xv();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.wi();
            this.cX.wj();
        }
        this.cV.setVisibility(8);
        com.kwad.components.ad.c.b bVar = this.cD;
        bVar.bO = true;
        bVar.bI.Z();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cD.bH.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cD.bH.getHeight());
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.cX = azVar;
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
    }

    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, (d) null, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.c.d.a.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.cD.bH.post(new bg() { // from class: com.kwad.components.ad.c.d.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.this.cD.X();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.cX.wj();
        this.cD.bH.removeAllViews();
        onDestroy();
        this.cD.Y();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.cY = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.c.d.a.3
            /* JADX WARN: Removed duplicated region for block: B:11:0x0064 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x005a, B:11:0x0064, B:12:0x0070, B:16:0x001c, B:18:0x0028, B:20:0x0038, B:21:0x0046), top: B:2:0x0001 }] */
            @Override // com.kwad.components.core.webview.tachikoma.b.o.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final boolean isMuted() {
                /*
                    r4 = this;
                    r0 = 1
                    boolean r1 = com.kwad.sdk.core.config.e.HA()     // Catch: java.lang.Throwable -> L76
                    r2 = 0
                    if (r1 != 0) goto L1c
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.h(r1)     // Catch: java.lang.Throwable -> L76
                    android.content.Context r1 = r1.mContext     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.core.s.a r1 = com.kwad.components.core.s.a.aG(r1)     // Catch: java.lang.Throwable -> L76
                    boolean r1 = r1.ur()     // Catch: java.lang.Throwable -> L76
                    if (r1 == 0) goto L1c
                L1a:
                    r2 = 1
                    goto L59
                L1c:
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.i(r1)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bJ     // Catch: java.lang.Throwable -> L76
                    boolean r1 = r1 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl     // Catch: java.lang.Throwable -> L76
                    if (r1 == 0) goto L46
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.j(r1)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bJ     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r1 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r1     // Catch: java.lang.Throwable -> L76
                    int r1 = r1.getVideoSoundValue()     // Catch: java.lang.Throwable -> L76
                    if (r1 == 0) goto L46
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.k(r1)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bJ     // Catch: java.lang.Throwable -> L76
                    boolean r1 = r1.isVideoSoundEnable()     // Catch: java.lang.Throwable -> L76
                    r1 = r1 ^ r0
                    goto L5a
                L46:
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.l(r1)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.core.response.model.AdTemplate r1 = r1.mAdTemplate     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.core.response.model.AdInfo r1 = com.kwad.sdk.core.response.b.e.er(r1)     // Catch: java.lang.Throwable -> L76
                    boolean r1 = com.kwad.sdk.core.response.b.a.bY(r1)     // Catch: java.lang.Throwable -> L76
                    if (r1 != 0) goto L59
                    goto L1a
                L59:
                    r1 = r2
                L5a:
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r2 = com.kwad.components.ad.c.d.a.m(r2)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L76
                    if (r2 == 0) goto L70
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.b r2 = com.kwad.components.ad.c.d.a.n(r2)     // Catch: java.lang.Throwable -> L76
                    com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L76
                    r3 = r1 ^ 1
                    r2.mIsAudioEnable = r3     // Catch: java.lang.Throwable -> L76
                L70:
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L76
                    com.kwad.components.ad.c.d.a.b(r2, r1)     // Catch: java.lang.Throwable -> L76
                    return r1
                L76:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.d.a.AnonymousClass3.isMuted():boolean");
            }
        });
    }
}
