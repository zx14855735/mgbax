package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class z implements com.kwad.sdk.core.webview.c.a {
    private DialogInterface.OnDismissListener Bu;
    private int agE;
    private boolean agF;
    private final boolean agG;
    private boolean agH;
    private List<com.kwad.components.core.e.d.d> agI;
    private boolean agJ;
    protected final com.kwad.sdk.core.webview.b ags;
    private com.kwad.sdk.core.webview.d.a.a eT;

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.agF = false;
        this.agI = new ArrayList();
        this.agF = z;
        this.ags = bVar;
        this.agE = i;
        if (dVar != null) {
            dVar.aI(1);
            this.agI.add(dVar);
        }
        this.eT = aVar;
        this.agG = z2;
        this.agJ = z3;
    }

    public final com.kwad.components.core.e.d.d Q(long j) {
        List<com.kwad.components.core.e.d.d> list = this.agI;
        if (list == null) {
            return null;
        }
        if (j < 0 && list.size() == 1) {
            return this.agI.get(0);
        }
        for (com.kwad.components.core.e.d.d dVar : this.agI) {
            if (com.kwad.sdk.core.response.b.e.eB(dVar.pX()) == j) {
                return dVar;
            }
        }
        return null;
    }

    public void Y(int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickAction";
    }

    public void kC() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.eT = null;
    }

    public static /* synthetic */ boolean a(z zVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.ahJ == 1;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.ags.MD() && aVar.adTemplate == null) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.ags.aRN && !aVar.aSO) {
            bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.z.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    String str2;
                    TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                    com.kwad.sdk.core.webview.b bVar = z.this.ags;
                    if (bVar.aRO) {
                        com.kwad.sdk.core.webview.d.b.a aVar2 = aVar;
                        AdTemplate adTemplate = aVar2.adTemplate;
                        if (adTemplate != null) {
                            z.this.agI.add(new com.kwad.components.core.e.d.d(adTemplate));
                        } else if (aVar2.creativeId >= 0) {
                            List<AdTemplate> MC = bVar.MC();
                            com.kwad.sdk.core.webview.d.b.a aVar3 = aVar;
                            adTemplate = com.kwad.sdk.core.response.b.e.a(MC, aVar3.creativeId, aVar3.adStyle);
                        } else {
                            adTemplate = bVar.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.b.e.eB(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.b.e.em(adTemplate);
                        }
                        com.kwad.components.core.e.d.d Q = z.this.Q(aVar.creativeId);
                        if (z.this.Bu != null && Q != null) {
                            Q.setOnDismissListener(z.this.Bu);
                        }
                        if (TextUtils.isEmpty(aVar.PU)) {
                            str2 = (adTemplate == null || (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) == null) ? null : tKAdLiveShopItemInfo.itemId;
                        } else {
                            try {
                                str2 = com.kwad.components.core.e.b.a.y(Long.parseLong(aVar.PU));
                            } catch (Exception unused) {
                                str2 = aVar.PU;
                            }
                        }
                        z.this.Y(com.kwad.components.core.e.d.a.a(z.this.a(new a.C0291a(z.this.ags.Vs.getContext()).aE(adTemplate).b(Q).ao(str2).as(z.a(z.this, aVar)).at(z.this.agF).d(z.this.ags.mReportExtData).aD(aVar.ahJ).aB(aVar.aSN).aC(aVar.mH).au(z.this.agG || aVar.PG).aH(z.this.agE).ap(z.this.agJ).aw(z.this.agH).aA(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.z.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                z.this.kC();
                                if (z.this.eT != null) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (aVar.aSP) {
                                        return;
                                    }
                                    z.this.eT.a(aVar);
                                }
                            }
                        }), aVar, adTemplate)));
                    }
                }
            });
        } else if (this.eT != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.z.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (z.this.eT == null || aVar.aSP) {
                        return;
                    }
                    z.this.eT.a(aVar);
                }
            });
        }
        cVar.a(null);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, dVar, aVar, false, 0, false, false);
        this.Bu = onDismissListener;
    }

    public a.C0291a a(a.C0291a c0291a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.d.b.d dVar;
        int i;
        com.kwad.sdk.core.webview.d.b.d dVar2 = aVar.ahK;
        if (dVar2 != null && !TextUtils.isEmpty(dVar2.PI)) {
            c0291a.ap(aVar.ahK.PI);
        }
        com.kwad.sdk.core.webview.d.b.d dVar3 = aVar.ahK;
        if (dVar3 != null && (i = dVar3.convertType) != 0) {
            c0291a.aF(i);
        }
        if (com.kwad.sdk.core.response.b.e.eK(adTemplate) && (dVar = aVar.ahK) != null && dVar.aSQ != null) {
            aj.a aVar2 = new aj.a();
            com.kwad.sdk.core.webview.d.b.c cVar = aVar.ahK.aSQ;
            aVar2.g((float) cVar.x, (float) cVar.y);
            com.kwad.sdk.core.webview.d.b.c cVar2 = aVar.ahK.aSQ;
            aVar2.f((float) cVar2.x, (float) cVar2.y);
            com.kwad.sdk.core.webview.d.b.c cVar3 = aVar.ahK.aSQ;
            aVar2.C(cVar3.width, cVar3.height);
            c0291a.d(aVar2);
        } else {
            com.kwad.sdk.widget.g gVar = this.ags.aRL;
            if (gVar != null) {
                c0291a.d(gVar.getTouchCoords());
            }
        }
        c0291a.a(null, null, null);
        return c0291a;
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, dVar, aVar, false, 0, false, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, dVar, aVar, false, 0, false, false);
        this.agH = true;
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, int i, boolean z) {
        this(bVar, dVar, null, false, 2, z, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, int i) {
        this(bVar, dVar, aVar, false, 1, false, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, List<com.kwad.components.core.e.d.d> list, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, null, aVar, false, 0, false, false);
        if (list != null) {
            this.agI.addAll(list);
        }
    }
}
