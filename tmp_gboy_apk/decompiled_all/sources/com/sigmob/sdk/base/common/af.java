package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class af implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13103a = "RewardVideoViewAbilitySession";
    private boolean c;
    private int d;
    private int b = 0;
    private int e = 0;

    private String a(int i) {
        return i == 0 ? Constants.FAIL : String.valueOf(i / 1000);
    }

    private int b() {
        int i = this.e;
        return (i <= 0 || i * 1000 >= this.b) ? this.b : i * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, BaseAdUnit baseAdUnit, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setVtime(b(this.b));
            pointEntitySigmob.setSkip_show_time(b(this.d));
            pointEntitySigmob.setCurrent_time(b(i));
            pointEntitySigmob.setPlay_process(String.valueOf((i * 1.0d) / b()));
            if (str.equals("start")) {
                pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
                pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
                pointEntitySigmob.setBid_token(baseAdUnit.getBid_token());
            }
            pointEntitySigmob.setPlay_time(a(i));
            pointEntitySigmob.setSet_close_time(String.format(Locale.getDefault(), "%d", Integer.valueOf(this.e)));
            boolean a2 = a();
            String str2 = Constants.FAIL;
            pointEntitySigmob.setIs_truncation(a2 ? "1" : Constants.FAIL);
            if (this.c) {
                str2 = "1";
            }
            pointEntitySigmob.setIs_force(str2);
        }
    }

    private String b(int i) {
        return i == 0 ? Constants.FAIL : String.format(Locale.getDefault(), "%.2f", Float.valueOf(i / 1000.0f));
    }

    private void a(BaseAdUnit baseAdUnit, int i, String str, String str2, String str3) {
        a(baseAdUnit, PointCategory.PLAY, i, str);
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, a(i));
        macroCommon.addMarcoKey(SigMacroCommon._PROGRESS_, str2);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, str3);
    }

    private void b(BaseAdUnit baseAdUnit, String str, int i) {
        a(baseAdUnit, str, i, (String) null);
    }

    private void a(final BaseAdUnit baseAdUnit, final String str, final int i, String str2) {
        ae.a(str, str2, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.AMqCpz
            @Override // com.sigmob.sdk.base.common.ae.a
            public final void onAddExtra(Object obj) {
                af.this.a(i, str, baseAdUnit, obj);
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.t
    public boolean b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
        a(baseAdUnit, "ad_close", b(), (String) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(HashMap hashMap, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            if (com.sigmob.sdk.base.utils.e.b(hashMap)) {
                pointEntitySigmob.getOptions().putAll(hashMap);
            }
        }
    }

    private boolean a() {
        int i = this.e;
        return i > 0 && i * 1000 < this.b;
    }

    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit, int i, int i2) {
        this.b = i;
        this.e = baseAdUnit.getEndTime();
        baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._VIDEOTIME_, a(this.b));
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit, String str, int i) {
        boolean z;
        char c;
        af afVar;
        BaseAdUnit baseAdUnit2;
        String str2;
        String str3;
        int b;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        af afVar2;
        BaseAdUnit baseAdUnit3;
        String str9;
        int i2;
        try {
            switch (str.hashCode()) {
                case -2094212140:
                    if (str.equals(a.d)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -2050793311:
                    if (str.equals(a.k)) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case -1914882469:
                    if (str.equals(a.i)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1903355519:
                    if (str.equals("show_skip")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1274442605:
                    if (str.equals("finish")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -981662273:
                    if (str.equals(a.f)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -934326481:
                    if (str.equals("reward")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -840405966:
                    if (str.equals(a.A)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -776925738:
                    if (str.equals(a.r)) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -510724095:
                    if (str.equals(a.e)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -381416586:
                    if (str.equals(a.g)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -306511486:
                    if (str.equals(a.L)) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case -236894925:
                    if (str.equals(a.n)) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case -40300674:
                    if (str.equals(a.B)) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 3363353:
                    if (str.equals(a.z)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 3529469:
                    if (str.equals("show")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3532159:
                    if (str.equals("skip")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c = 7;
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
                case 115070740:
                    if (str.equals(a.t)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 471706373:
                    if (str.equals(a.m)) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 844450526:
                    if (str.equals(a.v)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 975213205:
                    if (str.equals(a.s)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 1531785700:
                    if (str.equals(a.o)) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            z = true;
            char c2 = c;
            Object obj = SigMacroCommon._TEMPLATE_;
            String str10 = "1";
            String str11 = Constants.FAIL;
            try {
                try {
                    try {
                        switch (c2) {
                            case 0:
                                a(baseAdUnit, "start", i, (String) null);
                                SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
                                macroCommon.addMarcoKey(SigMacroCommon._SETCLOSETIME_, String.valueOf(this.e));
                                macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, Constants.FAIL);
                                macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, a(this.b));
                                macroCommon.addMarcoKey(SigMacroCommon._COMPLETED_, Constants.FAIL);
                                macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, Constants.FAIL);
                                macroCommon.addMarcoKey(SigMacroCommon._IS_TRUNCATION_, a() ? "1" : Constants.FAIL);
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case 1:
                                b(baseAdUnit, "skip", i);
                                SigMacroCommon macroCommon2 = baseAdUnit.getMacroCommon();
                                macroCommon2.addMarcoKey(SigMacroCommon._ENDTIME_, a(i));
                                if (this.b <= 0 || i <= 0) {
                                    macroCommon2.addMarcoKey(SigMacroCommon._PROGRESS_, Constants.FAIL);
                                } else {
                                    macroCommon2.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf((i * 100) / b()));
                                }
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case 2:
                                afVar = this;
                                baseAdUnit2 = baseAdUnit;
                                str2 = PointCategory.CLOSECARD;
                                str3 = "show";
                                b = i == 0 ? afVar.b() : i;
                                afVar.a(baseAdUnit2, str2, b, str3);
                                break;
                            case 3:
                                afVar = this;
                                baseAdUnit2 = baseAdUnit;
                                str3 = "close";
                                b = i == 0 ? afVar.b() : i;
                                str2 = PointCategory.CLOSECARD;
                                afVar.a(baseAdUnit2, str2, b, str3);
                                break;
                            case 4:
                                afVar = this;
                                baseAdUnit2 = baseAdUnit;
                                str2 = PointCategory.FOURELEMENTS;
                                b = i == 0 ? afVar.b() : i;
                                str3 = "show";
                                afVar.a(baseAdUnit2, str2, b, str3);
                                break;
                            case 5:
                                afVar = this;
                                baseAdUnit2 = baseAdUnit;
                                b = i == 0 ? afVar.b() : i;
                                str3 = "close";
                                str2 = PointCategory.FOURELEMENTS;
                                afVar.a(baseAdUnit2, str2, b, str3);
                                break;
                            case 6:
                                int b2 = i == 0 ? b() : i;
                                a(baseAdUnit, "endcard", b2, str);
                                SigMacroCommon macroCommon3 = baseAdUnit.getMacroCommon();
                                macroCommon3.addMarcoKey(SigMacroCommon._ENDTIME_, a(b2));
                                if (this.b <= 0 || b2 <= 0) {
                                    macroCommon3.addMarcoKey(SigMacroCommon._PROGRESS_, Constants.FAIL);
                                } else {
                                    macroCommon3.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf((b2 * 100) / b()));
                                }
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case 7:
                                int b3 = i == 0 ? b() : i;
                                String str12 = baseAdUnit.getClickCommon().is_final_click ? "1" : Constants.FAIL;
                                SigMacroCommon macroCommon4 = baseAdUnit.getMacroCommon();
                                macroCommon4.addMarcoKey("_AX_", Constants.FAIL);
                                macroCommon4.addMarcoKey("_AY_", Constants.FAIL);
                                ClientMetadata clientMetadata = ClientMetadata.getInstance();
                                macroCommon4.addMarcoKey("_AW_", String.valueOf(clientMetadata.getDeviceScreenRealWidthDip()));
                                macroCommon4.addMarcoKey("_AH_", String.valueOf(clientMetadata.getDeviceScreenRealHeightDip()));
                                if (baseAdUnit.getTemplateId() > 0) {
                                    macroCommon4.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                                }
                                if (com.sigmob.sdk.base.utils.o.b(baseAdUnit.getClickCommon().click_area)) {
                                    macroCommon4.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                                }
                                if (com.sigmob.sdk.base.utils.o.b(baseAdUnit.getClickCommon().click_scene)) {
                                    macroCommon4.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                                }
                                macroCommon4.addMarcoKey(SigMacroCommon._FINALCLICK_, str12);
                                macroCommon4.addMarcoKey(SigMacroCommon._ENDTIME_, a(b3));
                                if (this.b <= 0 || b3 <= 0) {
                                    macroCommon4.addMarcoKey(SigMacroCommon._PROGRESS_, Constants.FAIL);
                                } else {
                                    macroCommon4.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf((b3 * 100) / b()));
                                }
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case '\b':
                                int b4 = i == 0 ? b() : i;
                                ClickCommon clickCommon = baseAdUnit.getClickCommon();
                                String str13 = clickCommon.is_final_click ? "1" : Constants.FAIL;
                                SigMacroCommon macroCommon5 = baseAdUnit.getMacroCommon();
                                macroCommon5.addMarcoKey("_AX_", Constants.FAIL);
                                macroCommon5.addMarcoKey("_AY_", Constants.FAIL);
                                ClientMetadata clientMetadata2 = ClientMetadata.getInstance();
                                macroCommon5.addMarcoKey("_AW_", String.valueOf(clientMetadata2.getDeviceScreenRealWidthDip()));
                                macroCommon5.addMarcoKey("_AH_", String.valueOf(clientMetadata2.getDeviceScreenRealHeightDip()));
                                if ("5".equals(clickCommon.sld)) {
                                    macroCommon5.updateClickMarco(SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY);
                                    macroCommon5.addMarcoKey(SigMacroCommon._SLD_, clickCommon.sld);
                                    macroCommon5.addMarcoKey("_TURNX_", clickCommon.turn_x);
                                    macroCommon5.addMarcoKey("_TURNY_", clickCommon.turn_y);
                                    macroCommon5.addMarcoKey("_TURNZ_", clickCommon.turn_z);
                                    macroCommon5.addMarcoKey("_TURNTIME_", clickCommon.turn_time);
                                    str4 = "5";
                                } else {
                                    str4 = "5";
                                    if ("2".equals(clickCommon.sld)) {
                                        macroCommon5.updateClickMarco(SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY, SigMacroCommon.DEFAULT_XY);
                                        macroCommon5.addMarcoKey(SigMacroCommon._SLD_, clickCommon.sld);
                                        macroCommon5.addMarcoKey("_XMAXACC_", clickCommon.x_max_acc);
                                        macroCommon5.addMarcoKey("_YMAXACC_", clickCommon.y_max_acc);
                                        macroCommon5.addMarcoKey("_ZMAXACC_", clickCommon.z_max_acc);
                                    } else {
                                        macroCommon5.updateClickMarco(clickCommon.down, clickCommon.up);
                                        macroCommon5.addMarcoKey(SigMacroCommon._SLD_, Constants.FAIL);
                                    }
                                }
                                if (baseAdUnit.getTemplateId() > 0) {
                                    macroCommon5.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                                }
                                if (com.sigmob.sdk.base.utils.o.b(clickCommon.click_area)) {
                                    macroCommon5.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(clickCommon.click_area));
                                }
                                if (com.sigmob.sdk.base.utils.o.b(clickCommon.click_scene)) {
                                    macroCommon5.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(clickCommon.click_scene));
                                }
                                macroCommon5.addMarcoKey(SigMacroCommon._FINALCLICK_, str13);
                                macroCommon5.addMarcoKey(SigMacroCommon._ENDTIME_, a(b4));
                                if (this.b <= 0 || b4 <= 0) {
                                    macroCommon5.addMarcoKey(SigMacroCommon._PROGRESS_, Constants.FAIL);
                                } else {
                                    macroCommon5.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf((b4 * 100) / b()));
                                }
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
                                HashMap hashMap = new HashMap();
                                hashMap.put("template_id", clickCommon.template_id);
                                hashMap.put("sld", clickCommon.sld);
                                hashMap.put("adarea_x", Constants.FAIL);
                                hashMap.put("adarea_y", Constants.FAIL);
                                hashMap.put("adarea_w", String.valueOf(clientMetadata2.getDeviceScreenRealWidthDip()));
                                hashMap.put("adarea_h", String.valueOf(clientMetadata2.getDeviceScreenRealHeightDip()));
                                if (!str4.equals(clickCommon.sld)) {
                                    if ("2".equals(clickCommon.sld)) {
                                        hashMap.put("x_max_acc", clickCommon.x_max_acc);
                                        hashMap.put("y_max_acc", clickCommon.y_max_acc);
                                        str5 = "z_max_acc";
                                        str6 = clickCommon.z_max_acc;
                                    }
                                    hashMap.put(ClickCommon.CLICK_AREA, clickCommon.click_area);
                                    hashMap.put("click_scene", clickCommon.click_scene);
                                    hashMap.put("cwidth", String.valueOf(clientMetadata2.getDeviceScreenRealWidthDip()));
                                    hashMap.put("cheight", String.valueOf(clientMetadata2.getDeviceScreenRealHeightDip()));
                                    hashMap.put("is_final_click", str13);
                                    hashMap.put("coordinate", macroCommon5.getCoordinate());
                                    ae.a(clickCommon.click_scene, "click", baseAdUnit, new ARc23Z(hashMap, 0));
                                    break;
                                } else {
                                    hashMap.put("turn_x", clickCommon.turn_x);
                                    hashMap.put("turn_y", clickCommon.turn_y);
                                    hashMap.put("turn_z", clickCommon.turn_z);
                                    str5 = "turn_time";
                                    str6 = clickCommon.turn_time;
                                }
                                hashMap.put(str5, str6);
                                hashMap.put(ClickCommon.CLICK_AREA, clickCommon.click_area);
                                hashMap.put("click_scene", clickCommon.click_scene);
                                hashMap.put("cwidth", String.valueOf(clientMetadata2.getDeviceScreenRealWidthDip()));
                                hashMap.put("cheight", String.valueOf(clientMetadata2.getDeviceScreenRealHeightDip()));
                                hashMap.put("is_final_click", str13);
                                hashMap.put("coordinate", macroCommon5.getCoordinate());
                                ae.a(clickCommon.click_scene, "click", baseAdUnit, new ARc23Z(hashMap, 0));
                            case '\t':
                                int i3 = i;
                                if (i3 == 0) {
                                    i3 = b();
                                }
                                String str14 = baseAdUnit.getClickCommon().is_final_click ? "1" : Constants.FAIL;
                                SigMacroCommon macroCommon6 = baseAdUnit.getMacroCommon();
                                macroCommon6.addMarcoKey("_AX_", Constants.FAIL);
                                macroCommon6.addMarcoKey("_AY_", Constants.FAIL);
                                ClientMetadata clientMetadata3 = ClientMetadata.getInstance();
                                macroCommon6.addMarcoKey("_AW_", String.valueOf(clientMetadata3.getDeviceScreenRealWidthDip()));
                                macroCommon6.addMarcoKey("_AH_", String.valueOf(clientMetadata3.getDeviceScreenRealHeightDip()));
                                if (baseAdUnit.getTemplateId() > 0) {
                                    macroCommon6.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                                }
                                if (com.sigmob.sdk.base.utils.o.b(baseAdUnit.getClickCommon().click_area)) {
                                    macroCommon6.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                                }
                                if (com.sigmob.sdk.base.utils.o.b(baseAdUnit.getClickCommon().click_scene)) {
                                    macroCommon6.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                                }
                                macroCommon6.addMarcoKey(SigMacroCommon._FINALCLICK_, str14);
                                macroCommon6.addMarcoKey(SigMacroCommon._ENDTIME_, a(i3));
                                if (this.b <= 0 || i3 <= 0) {
                                    macroCommon6.addMarcoKey(SigMacroCommon._PROGRESS_, Constants.FAIL);
                                } else {
                                    macroCommon6.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf((i3 * 100) / b()));
                                }
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case '\n':
                                int i4 = i;
                                if (i4 == 0) {
                                    i4 = b();
                                }
                                SigMacroCommon macroCommon7 = baseAdUnit.getMacroCommon();
                                if (!baseAdUnit.getClickCommon().is_final_click) {
                                    str10 = Constants.FAIL;
                                }
                                macroCommon7.addMarcoKey("_AX_", Constants.FAIL);
                                macroCommon7.addMarcoKey("_AY_", Constants.FAIL);
                                ClientMetadata clientMetadata4 = ClientMetadata.getInstance();
                                macroCommon7.addMarcoKey("_AW_", String.valueOf(clientMetadata4.getDeviceScreenRealWidthDip()));
                                macroCommon7.addMarcoKey("_AH_", String.valueOf(clientMetadata4.getDeviceScreenRealHeightDip()));
                                if (baseAdUnit.getTemplateId() > 0) {
                                    macroCommon7.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                                }
                                if (com.sigmob.sdk.base.utils.o.b(baseAdUnit.getClickCommon().click_area)) {
                                    macroCommon7.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                                }
                                if (com.sigmob.sdk.base.utils.o.b(baseAdUnit.getClickCommon().click_scene)) {
                                    macroCommon7.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                                }
                                macroCommon7.addMarcoKey(SigMacroCommon._FINALCLICK_, str10);
                                macroCommon7.addMarcoKey(SigMacroCommon._ENDTIME_, a(i4));
                                if (this.b <= 0 || i4 <= 0) {
                                    macroCommon7.addMarcoKey(SigMacroCommon._PROGRESS_, Constants.FAIL);
                                } else {
                                    macroCommon7.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf((i4 * 100) / b()));
                                }
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case 11:
                                SigMacroCommon macroCommon8 = baseAdUnit.getMacroCommon();
                                macroCommon8.addMarcoKey(SigMacroCommon._SHOWSKIPTIME_, a(i));
                                if (this.b <= 0 || i <= 0) {
                                    macroCommon8.addMarcoKey(SigMacroCommon._PROGRESS_, Constants.FAIL);
                                } else {
                                    macroCommon8.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf((i * 100) / b()));
                                }
                                macroCommon8.addMarcoKey(SigMacroCommon._ENDTIME_, a(i));
                                macroCommon8.addMarcoKey(SigMacroCommon._VIDEOTIME_, a(this.b));
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case '\f':
                                int b5 = i == 0 ? b() : i;
                                b(baseAdUnit, "complete", b5);
                                SigMacroCommon macroCommon9 = baseAdUnit.getMacroCommon();
                                macroCommon9.addMarcoKey(SigMacroCommon._ENDTIME_, a(b5));
                                macroCommon9.addMarcoKey(SigMacroCommon._PROGRESS_, "100");
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case '\r':
                                b(baseAdUnit, "reward", i == 0 ? b() : i);
                                break;
                            case 14:
                                int b6 = i == 0 ? b() : i;
                                b(baseAdUnit, "finish", b6);
                                SigMacroCommon macroCommon10 = baseAdUnit.getMacroCommon();
                                if (this.b > 0 && b6 > 0) {
                                    str11 = String.valueOf((b6 * 100) / b());
                                }
                                macroCommon10.addMarcoKey(SigMacroCommon._PROGRESS_, str11);
                                macroCommon10.addMarcoKey(SigMacroCommon._COMPLETED_, "1");
                                macroCommon10.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
                                macroCommon10.addMarcoKey(SigMacroCommon._ENDTIME_, a(b6));
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                            case 15:
                                a(baseAdUnit, PointCategory.VCLOSE, i, (String) null);
                                break;
                            case 16:
                                a(baseAdUnit, PointCategory.SILENT, i, "1");
                                break;
                            case 17:
                                a(baseAdUnit, PointCategory.SILENT, i, Constants.FAIL);
                                break;
                            case 18:
                                ClientMetadata clientMetadata5 = ClientMetadata.getInstance();
                                if (!com.sigmob.sdk.base.utils.q.b(clientMetadata5)) {
                                    break;
                                } else {
                                    a(baseAdUnit, PointCategory.SCREENSWITCH, i, clientMetadata5.getRotation());
                                    break;
                                }
                            case 19:
                                a(baseAdUnit, PointCategory.PLAY, i, Constants.FAIL);
                                break;
                            case 20:
                                try {
                                    a(baseAdUnit, i, "0.25", "25", str);
                                    break;
                                } catch (Throwable th) {
                                    th = th;
                                    obj = this;
                                    com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("RewardVideoViewAbilitySessionrecordDisplayEvent: error = "));
                                    return z;
                                }
                            case 21:
                                str7 = "0.50";
                                str8 = "50";
                                afVar2 = this;
                                baseAdUnit3 = baseAdUnit;
                                str9 = str;
                                i2 = i;
                                afVar2.a(baseAdUnit3, i2, str7, str8, str9);
                                break;
                            case 22:
                                str7 = "0.75";
                                str8 = "75";
                                afVar2 = this;
                                baseAdUnit3 = baseAdUnit;
                                str9 = str;
                                i2 = i;
                                afVar2.a(baseAdUnit3, i2, str7, str8, str9);
                                break;
                            case 23:
                                str7 = "0.85";
                                str8 = "85";
                                afVar2 = this;
                                baseAdUnit3 = baseAdUnit;
                                str9 = str;
                                i2 = i;
                                afVar2.a(baseAdUnit3, i2, str7, str8, str9);
                                break;
                            case 24:
                                b(baseAdUnit, str, i);
                                break;
                            default:
                                b(baseAdUnit, str, i);
                                com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                                break;
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("RewardVideoViewAbilitySessionrecordDisplayEvent: error = "));
                        return z;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("RewardVideoViewAbilitySessionrecordDisplayEvent: error = "));
                    return z;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            z = true;
        }
    }

    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit, boolean z, int i) {
        this.c = z;
        this.d = i;
        return true;
    }
}
