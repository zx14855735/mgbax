package com.sigmob.sdk.newInterstitial;

import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends l {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit, String str, int i) {
        char c;
        String str2;
        String str3;
        String str4;
        try {
            switch (str.hashCode()) {
                case -2050793311:
                    if (str.equals(com.sigmob.sdk.base.common.a.k)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1903355519:
                    if (str.equals("show_skip")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1618089666:
                    if (str.equals("video_link")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1361632588:
                    if (str.equals("charge")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1170756021:
                    if (str.equals("video_restart")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1152604194:
                    if (str.equals("ad_hide")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -981662273:
                    if (str.equals(com.sigmob.sdk.base.common.a.f)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -381416586:
                    if (str.equals(com.sigmob.sdk.base.common.a.g)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -236894925:
                    if (str.equals(com.sigmob.sdk.base.common.a.n)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 3532159:
                    if (str.equals("skip")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 471706373:
                    if (str.equals(com.sigmob.sdk.base.common.a.m)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 844450526:
                    if (str.equals(com.sigmob.sdk.base.common.a.v)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1110780470:
                    if (str.equals("show_close")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1382290738:
                    if (str.equals("video_pause")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1385608094:
                    if (str.equals("video_start")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str2 = "start";
                    a(baseAdUnit, str2, (String) null, (HashMap<String, String>) null);
                    break;
                case 1:
                    str2 = PointCategory.VCLOSE;
                    a(baseAdUnit, str2, (String) null, (HashMap<String, String>) null);
                    break;
                case 2:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str2 = "ad_hide";
                    a(baseAdUnit, str2, (String) null, (HashMap<String, String>) null);
                    break;
                case 3:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    a(baseAdUnit, "charge", (String) null, (HashMap<String, String>) null);
                    break;
                case 4:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    a(baseAdUnit, "show_skip", (String) null, (HashMap<String, String>) null);
                    break;
                case 5:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    a(baseAdUnit, "skip", (String) null, (HashMap<String, String>) null);
                    break;
                case 6:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    a(baseAdUnit, "show_close", (String) null, (HashMap<String, String>) null);
                    break;
                case 7:
                    a(baseAdUnit, str, true, "video_link");
                    break;
                case '\b':
                    a(baseAdUnit, str, false, "video_restart");
                    break;
                case '\t':
                    a(baseAdUnit, str, false, "video_start");
                    break;
                case '\n':
                    a(baseAdUnit, str, true, "video_pause");
                    break;
                case 11:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str3 = "0.25";
                    a(baseAdUnit, PointCategory.PLAY, str3, (HashMap<String, String>) null);
                    break;
                case '\f':
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str3 = "0.50";
                    a(baseAdUnit, PointCategory.PLAY, str3, (HashMap<String, String>) null);
                    break;
                case '\r':
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str3 = "0.75";
                    a(baseAdUnit, PointCategory.PLAY, str3, (HashMap<String, String>) null);
                    break;
                case 14:
                    a(baseAdUnit, str, true, "complete");
                    break;
                case 15:
                    String str5 = baseAdUnit.getClickCommon().is_final_click ? "1" : Constants.FAIL;
                    SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
                    macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                    macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                    macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                    macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str5);
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(ClickCommon.CLICK_AREA, baseAdUnit.getClickCommon().click_area);
                    hashMap.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                    hashMap.put("template_id", String.valueOf(baseAdUnit.getTemplateId()));
                    hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                    hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                    hashMap.put("is_final_click", str5);
                    hashMap.put("coordinate", macroCommon.getCoordinate());
                    a(baseAdUnit, baseAdUnit.getClickCommon().click_scene, "click", hashMap);
                    break;
                case 16:
                    str4 = "show";
                    a(baseAdUnit, PointCategory.FOURELEMENTS, str4, (HashMap<String, String>) null);
                    break;
                case 17:
                    str4 = "close";
                    a(baseAdUnit, PointCategory.FOURELEMENTS, str4, (HashMap<String, String>) null);
                    break;
            }
            return true;
        } catch (Throwable th) {
            SigmobLog.e(this.f13144a + "recordDisplayEvent: error = " + th.getMessage());
            return true;
        }
    }

    @Override // com.sigmob.sdk.base.common.t
    public boolean b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
        a(baseAdUnit, "ad_close", (String) null, (HashMap<String, String>) null);
        return true;
    }
}
