package com.kwad.sdk.core.response.b;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    public static long ed(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eh(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String ee(AdTemplate adTemplate) {
        return adTemplate == null ? "" : eh(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String ef(AdTemplate adTemplate) {
        return adTemplate == null ? "" : eh(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean eg(AdTemplate adTemplate) {
        if (adTemplate != null && e.ej(adTemplate)) {
            return eh(adTemplate).slideClick;
        }
        return false;
    }

    private static AdStyleInfo eh(AdTemplate adTemplate) {
        return e.er(adTemplate).adStyleInfo;
    }

    public static List<String> ei(AdTemplate adTemplate) {
        AdStyleInfo eh = eh(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = eh.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
