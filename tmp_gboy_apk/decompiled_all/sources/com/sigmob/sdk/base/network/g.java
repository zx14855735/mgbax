package com.sigmob.sdk.base.network;

import ADYaiT.CtFAbx;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLogger;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ai;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.utils.o;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13201a = "g";

    public static void a(AdTracker adTracker, BaseAdUnit baseAdUnit, boolean z) {
        a(adTracker, baseAdUnit, z, true, true, null);
    }

    public static int b(BaseAdUnit baseAdUnit, String str, boolean z) {
        if (baseAdUnit == null || o.a((CharSequence) str)) {
            return -1;
        }
        List<ai> adTracker = baseAdUnit.getAdTracker(str);
        if (adTracker == null || adTracker.isEmpty()) {
            return -2;
        }
        for (ai aiVar : adTracker) {
            if (z) {
                aiVar.setSource("js");
            }
            baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, "1");
            a((AdTracker) aiVar, baseAdUnit, false);
        }
        return 0;
    }

    public static void a(AdTracker adTracker, final BaseAdUnit baseAdUnit, boolean z, boolean z2, final boolean z3, final TrackManager.Listener listener) {
        if (adTracker == null) {
            return;
        }
        String source = adTracker.getSource();
        String event = adTracker.getEvent();
        if ((event.equals(com.sigmob.sdk.base.common.a.s) || event.equals("click")) && (source.equals("js") || source.equals("native"))) {
            SigmobLogger.d(f13201a, CtFAbx.AmA8tU("sendTracking: source = ", source, ", event = ", event), new Object[0]);
        }
        if (adTracker.getMessageType() == AdTracker.MessageType.TRACKING_URL) {
            if (!adTracker.isTracked() || z) {
                String url = adTracker.getUrl();
                SigMacroCommon macroCommon = Sigmob.getInstance().getMacroCommon();
                final String macroProcess = baseAdUnit == null ? macroCommon.macroProcess(url) : baseAdUnit.getMacroCommon().macroProcess(url, macroCommon.getMacroMap());
                adTracker.setUrl(macroProcess);
                TrackManager.sendTracking(adTracker, null, z, z2, new TrackManager.Listener() { // from class: com.sigmob.sdk.base.network.g.1
                    @Override // com.czhj.sdk.common.track.TrackManager.Listener
                    public void onErrorResponse(AdTracker adTracker2, VolleyError volleyError) {
                        if (z3) {
                            ae.a(adTracker2, macroProcess, baseAdUnit, volleyError);
                        }
                        TrackManager.Listener listener2 = listener;
                        if (listener2 != null) {
                            listener2.onErrorResponse(adTracker2, volleyError);
                        }
                    }

                    @Override // com.czhj.sdk.common.track.TrackManager.Listener
                    public void onSuccess(AdTracker adTracker2, NetworkResponse networkResponse) {
                        if (z3) {
                            ae.a(adTracker2, macroProcess, baseAdUnit, networkResponse, (ae.a) null);
                        }
                        TrackManager.Listener listener2 = listener;
                        if (listener2 != null) {
                            listener2.onSuccess(adTracker2, networkResponse);
                        }
                    }
                });
            }
        }
    }

    public static void a(BaseAdUnit baseAdUnit, String str) {
        a(baseAdUnit, str, false);
    }

    public static void a(BaseAdUnit baseAdUnit, String str, boolean z) {
        List<ai> adTracker;
        if (baseAdUnit == null || o.a((CharSequence) str) || (adTracker = baseAdUnit.getAdTracker(str)) == null || adTracker.isEmpty()) {
            return;
        }
        for (ai aiVar : adTracker) {
            baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, "1");
            a(aiVar, baseAdUnit, z);
        }
    }
}
