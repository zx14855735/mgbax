package com.kwad.sdk.commercial;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.bp;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    private static String a(AdMatrixInfo.MatrixTemplate matrixTemplate) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(matrixTemplate.templateId);
        stringBuffer.append("#");
        stringBuffer.append(matrixTemplate.templateVersionCode);
        return stringBuffer.toString();
    }

    public static BusinessType bh(AdTemplate adTemplate) {
        return adTemplate == null ? BusinessType.OTHER : cL(com.kwad.sdk.core.response.b.e.el(adTemplate));
    }

    public static AdMatrixInfo.MatrixTemplate bi(AdTemplate adTemplate) {
        String str;
        AdMatrixInfo.MatrixTemplate matrixTemplate = null;
        if (adTemplate.mAdScene == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.b.b.ct(adTemplate).adDataV2;
        int el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (el == 2) {
            str = adDataV2.neoTKInfo.templateId;
        } else if (el == 3) {
            str = adDataV2.fullScreenInfo.templateId;
        } else if (el == 4) {
            str = adDataV2.splashPlayCardTKInfo.templateId;
        } else if (el == 6) {
            str = adDataV2.drawTKCardInfo.templateId;
        } else if (el != 13) {
            if (el == 23) {
                int eJ = com.kwad.sdk.core.response.b.e.eJ(adTemplate);
                if (eJ == 1) {
                    str = adDataV2.fullScreenInfo.templateId;
                } else if (eJ == 2) {
                    str = adDataV2.interstitialCardInfo.templateId;
                }
            }
            str = "";
        } else {
            str = adDataV2.interstitialCardInfo.templateId;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<AdMatrixInfo.MatrixTemplate> it = com.kwad.sdk.core.response.b.b.cu(adTemplate).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdMatrixInfo.MatrixTemplate next = it.next();
            if (bp.isEquals(str, next.templateId)) {
                matrixTemplate = next;
                break;
            }
        }
        if (matrixTemplate == null) {
            matrixTemplate = com.kwad.sdk.core.response.b.b.k(adTemplate, str);
        }
        if (matrixTemplate != null) {
            matrixTemplate.publishType = ((h) ServiceProvider.get(h.class)).cu(a(matrixTemplate));
        }
        return matrixTemplate;
    }

    public static BusinessType cL(int i) {
        return i == 3 ? BusinessType.AD_FULLSCREEN : i == 2 ? BusinessType.AD_REWARD : i == 4 ? BusinessType.AD_SPLASH : (i == 13 || i == 23) ? BusinessType.AD_INTERSTITIAL : i == 1 ? BusinessType.AD_FEED : i == 10000 ? BusinessType.AD_NATIVE : BusinessType.OTHER;
    }

    public static int cM(int i) {
        if (i == -1) {
            return 100010;
        }
        if (i == -2) {
            return 100011;
        }
        return i;
    }
}
