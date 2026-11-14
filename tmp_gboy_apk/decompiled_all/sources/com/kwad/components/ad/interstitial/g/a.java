package com.kwad.components.ad.interstitial.g;

import android.app.Activity;
import android.content.DialogInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static boolean d(final c cVar) {
        Activity ownerActivity;
        d dVar = cVar.kV;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo er = e.er(cVar.mAdTemplate);
            int dP = com.kwad.components.ad.interstitial.c.b.dP();
            int dQ = com.kwad.components.ad.interstitial.c.b.dQ();
            if (dP > com.kwad.sdk.core.response.b.a.cx(er) && dQ < com.kwad.sdk.core.response.b.a.cy(er)) {
                if (com.kwad.sdk.core.response.b.a.cz(er) == 2) {
                    com.kwad.components.ad.interstitial.h.b.e(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.b.a.cz(er) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.b.a.cA(er), new a.InterfaceC0308a() { // from class: com.kwad.components.ad.interstitial.g.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0308a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.c(c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().dC(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0308a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = c.this;
                            cVar2.a(false, -1, cVar2.cq);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.e(c.this.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().dx(MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS).dC(8));
                            c.this.kV.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0308a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().dx(149).dC(8));
                    return true;
                }
            }
        }
        return false;
    }
}
