package com.kwad.components.ad.h.a.a;

import J3FDQU.A2egSU;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int qn = 1;
    public static int qo = 2;
    private com.kwad.sdk.core.webview.c.c qm;
    private int qp;
    private int qq;
    private InterfaceC0234b qs;
    private c qr = new c(this, 0);
    private Runnable qt = null;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int qv;
        public int qw;
    }

    /* renamed from: com.kwad.components.ad.h.a.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0234b {
        void Q(int i);
    }

    private b(int i, int i2) {
        this.qp = i;
        this.qq = i2;
    }

    public static b I(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bd(er)) {
            return null;
        }
        if (com.kwad.sdk.core.response.b.a.bL(er)) {
            return new b(qo, f(er));
        }
        int i = er.adInsertScreenInfo.autoCloseTime;
        if (i > 0) {
            return new b(qn, i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i) {
        StringBuilder B9tovu2 = A2egSU.B9tovu(i, "updateTimer: ", ", mCallBackFunction: ");
        B9tovu2.append(this.qm);
        com.kwad.sdk.core.d.c.d("RegisterTimer", B9tovu2.toString());
        if (i >= 0 && this.qm != null) {
            InterfaceC0234b interfaceC0234b = this.qs;
            if (interfaceC0234b != null && i == 0) {
                interfaceC0234b.Q(this.qp);
            }
            a aVar = new a();
            aVar.qw = i;
            aVar.qv = this.qp;
            com.kwad.sdk.core.webview.c.c cVar = this.qm;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    private static int f(AdInfo adInfo) {
        int b = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (b <= 0) {
            b = 60;
        }
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        return i > 0 ? Math.min(b, i) : b;
    }

    public final void at() {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.qm);
        if (this.qm == null) {
            this.qt = new Runnable() { // from class: com.kwad.components.ad.h.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.at();
                }
            };
        } else {
            this.qr.X(this.qq);
            bw.runOnUiThread(this.qr);
        }
    }

    public final void fQ() {
        this.qr.z(true);
    }

    public final void fR() {
        this.qr.z(false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qm = null;
    }

    public final void a(InterfaceC0234b interfaceC0234b) {
        this.qs = interfaceC0234b;
    }

    public class c implements Runnable {
        private boolean qx;
        private int qy;

        private c() {
            this.qx = false;
            this.qy = -1;
        }

        public final void X(int i) {
            this.qy = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StringBuilder sb = new StringBuilder("TimerRunnable run timerPaused:  ");
            sb.append(this.qx);
            sb.append(", currentTime: ");
            com.bykv.vk.component.ttvideo.player.A2egSU.BChYOn(sb, this.qy, "RegisterTimer");
            if (this.qx) {
                bw.a(this, null, 1000L);
                return;
            }
            int i = this.qy;
            if (i < 0) {
                return;
            }
            b.this.W(i);
            this.qy--;
            bw.a(this, null, 1000L);
        }

        public final void z(boolean z) {
            this.qx = z;
        }

        public /* synthetic */ c(b bVar, byte b) {
            this();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.qm = cVar;
        Runnable runnable = this.qt;
        if (runnable != null) {
            runnable.run();
            this.qt = null;
        }
    }
}
