package com.sigmob.sdk.nativead;

import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h extends com.sigmob.sdk.base.common.l {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit, String str, int i) {
        char c;
        String str2;
        String str3;
        try {
            switch (str.hashCode()) {
                case -2050793311:
                    if (str.equals(com.sigmob.sdk.base.common.a.k)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1618089666:
                    if (str.equals("video_link")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1170756021:
                    if (str.equals("video_restart")) {
                        c = 4;
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
                case -1152277095:
                    if (str.equals("ad_show")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -981662273:
                    if (str.equals(com.sigmob.sdk.base.common.a.f)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -381416586:
                    if (str.equals(com.sigmob.sdk.base.common.a.g)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -236894925:
                    if (str.equals(com.sigmob.sdk.base.common.a.n)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c = 11;
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
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1382290738:
                    if (str.equals("video_pause")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1385608094:
                    if (str.equals("video_start")) {
                        c = 5;
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
                    a(baseAdUnit, "start", (String) null, (HashMap<String, String>) null);
                    break;
                case 1:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    a(baseAdUnit, "ad_show", (String) null, (HashMap<String, String>) null);
                    break;
                case 2:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    a(baseAdUnit, "ad_hide", (String) null, (HashMap<String, String>) null);
                    break;
                case 3:
                    a(baseAdUnit, str, true, "video_link");
                    break;
                case 4:
                    a(baseAdUnit, str, false, "video_restart");
                    break;
                case 5:
                    a(baseAdUnit, str, false, "video_start");
                    break;
                case 6:
                    a(baseAdUnit, str, true, "video_pause");
                    break;
                case 7:
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str2 = "0.25";
                    a(baseAdUnit, PointCategory.PLAY, str2, (HashMap<String, String>) null);
                    break;
                case '\b':
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str2 = "0.50";
                    a(baseAdUnit, PointCategory.PLAY, str2, (HashMap<String, String>) null);
                    break;
                case '\t':
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str2 = "0.75";
                    a(baseAdUnit, PointCategory.PLAY, str2, (HashMap<String, String>) null);
                    break;
                case '\n':
                    a(baseAdUnit, str, true, "complete");
                    break;
                case 11:
                    ClickCommon clickCommon = baseAdUnit.getClickCommon();
                    String str4 = clickCommon.is_final_click ? "1" : Constants.FAIL;
                    SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
                    macroCommon.addMarcoKey(SigMacroCommon._SLD_, clickCommon.sld);
                    macroCommon.addMarcoKey("_AX_", clickCommon.adarea_x);
                    macroCommon.addMarcoKey("_AY_", clickCommon.adarea_y);
                    macroCommon.addMarcoKey("_AW_", clickCommon.adarea_w);
                    macroCommon.addMarcoKey("_AH_", clickCommon.adarea_h);
                    if ("5".equals(clickCommon.sld)) {
                        macroCommon.updateClickMarco(SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY);
                        macroCommon.addMarcoKey("_TURNX_", clickCommon.turn_x);
                        macroCommon.addMarcoKey("_TURNY_", clickCommon.turn_y);
                        macroCommon.addMarcoKey("_TURNZ_", clickCommon.turn_z);
                        macroCommon.addMarcoKey("_TURNTIME_", clickCommon.turn_time);
                        macroCommon.addMarcoKey("_CPTIDS_", String.valueOf(clickCommon.widget_id));
                    } else if ("2".equals(clickCommon.sld)) {
                        macroCommon.updateClickMarco(SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY);
                        macroCommon.addMarcoKey("_CPTIDS_", String.valueOf(clickCommon.widget_id));
                        macroCommon.addMarcoKey("_XMAXACC_", clickCommon.x_max_acc);
                        macroCommon.addMarcoKey("_YMAXACC_", clickCommon.y_max_acc);
                        macroCommon.addMarcoKey("_ZMAXACC_", clickCommon.z_max_acc);
                    } else {
                        macroCommon.updateClickMarco(clickCommon.down, clickCommon.up);
                    }
                    String str5 = clickCommon.click_area;
                    macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                    macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(str5));
                    macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(clickCommon.click_scene));
                    macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str4);
                    if (com.sigmob.sdk.base.utils.o.a((CharSequence) str5, (CharSequence) "appinfo")) {
                        SigmobLog.d(this.f13144a + "recordDisplayEvent: Do Not Track");
                    } else {
                        SigmobLog.d(this.f13144a + "recordDisplayEvent: Track");
                        com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("template_id", clickCommon.template_id);
                    hashMap.put("sld", clickCommon.sld);
                    hashMap.put("adarea_x", clickCommon.adarea_x);
                    hashMap.put("adarea_y", clickCommon.adarea_y);
                    hashMap.put("adarea_w", clickCommon.adarea_w);
                    hashMap.put("adarea_h", clickCommon.adarea_h);
                    if ("5".equals(clickCommon.sld)) {
                        hashMap.put("turn_x", clickCommon.turn_x);
                        hashMap.put("turn_y", clickCommon.turn_y);
                        hashMap.put("turn_z", clickCommon.turn_z);
                        hashMap.put("cpt_id", String.valueOf(clickCommon.widget_id));
                        hashMap.put("turn_time", clickCommon.turn_time);
                    } else if ("2".equals(clickCommon.sld)) {
                        hashMap.put("x_max_acc", clickCommon.x_max_acc);
                        hashMap.put("y_max_acc", clickCommon.y_max_acc);
                        hashMap.put("z_max_acc", clickCommon.z_max_acc);
                        hashMap.put("cpt_id", String.valueOf(clickCommon.widget_id));
                    }
                    hashMap.put(ClickCommon.CLICK_AREA, str5);
                    hashMap.put("click_scene", clickCommon.click_scene);
                    hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                    hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                    hashMap.put("is_final_click", str4);
                    hashMap.put("coordinate", macroCommon.getCoordinate());
                    hashMap.put(ClickCommon.CLICK_LOSE_RATE, String.valueOf(clickCommon.click_lose_rate));
                    hashMap.put(ClickCommon.CLICK_CB_STATE, String.valueOf(clickCommon.click_cb_state));
                    if (com.sigmob.sdk.base.utils.q.b(clickCommon.aim)) {
                        hashMap.put(ClickCommon.AIM, String.valueOf(clickCommon.aim));
                        clickCommon.aim = null;
                    }
                    if (com.sigmob.sdk.base.utils.q.b(clickCommon.cpt_render_type)) {
                        hashMap.put(ClickCommon.CPT_RENDER_TYPE, String.valueOf(clickCommon.cpt_render_type));
                        clickCommon.cpt_render_type = null;
                    }
                    a(baseAdUnit, clickCommon.click_scene, "click", hashMap);
                    break;
                case '\f':
                    str3 = "show";
                    a(baseAdUnit, PointCategory.FOURELEMENTS, str3, (HashMap<String, String>) null);
                    break;
                case '\r':
                    str3 = "close";
                    a(baseAdUnit, PointCategory.FOURELEMENTS, str3, (HashMap<String, String>) null);
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
        return true;
    }
}
