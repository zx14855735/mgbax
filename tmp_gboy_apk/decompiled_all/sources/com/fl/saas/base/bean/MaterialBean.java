package com.fl.saas.base.bean;

import A5SV6n.A2egSU;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.utils.DeviceUtil;
import org.json.JSONObject;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialBean {
    private static final String version = "2.8.8";
    private final int adv_id;
    private String adv_version;
    private String creative_str;
    private final String group_id;
    private final String id;
    private final String place_id;
    private final int price;
    private final String tagid;
    private final String test_id;
    private final String track_id;
    private final String user_defined;
    private final AppInfo app = AppInfo.create();
    private final DeviceInfo device = DeviceInfo.create();

    public MaterialBean(AdSource adSource, AdMaterial.AdMaterialData adMaterialData) {
        this.id = adSource.req_id;
        this.place_id = adSource.place_id;
        this.group_id = adSource.group_id;
        this.tagid = adSource.tagid;
        this.price = adSource.getPrice();
        this.test_id = adSource.test_id;
        this.track_id = adSource.track_id;
        this.adv_id = adSource.adv_id;
        this.user_defined = DeviceUtil.customMap != null ? new JSONObject(DeviceUtil.customMap).toString() : "";
        this.creative_str = adMaterialData.getData();
        this.adv_version = adMaterialData.getAdvVer();
    }
}
