package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationAdEcpmInfo {
    private String am;
    private String c;
    private String d;
    private String f;
    private String g;
    private String hf;
    private String kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10473pl;
    private String qt;
    private String tf;
    private String u;
    private String w;
    private String xj;
    private int y;
    private Map<String, String> zg;

    public MediationAdEcpmInfo() {
        this.zg = new HashMap();
    }

    public String getAbTestId() {
        return this.am;
    }

    public String getChannel() {
        return this.f10473pl;
    }

    public Map<String, String> getCustomData() {
        return this.zg;
    }

    public String getCustomSdkName() {
        return this.hf;
    }

    public String getEcpm() {
        return this.kd;
    }

    public String getErrorMsg() {
        return this.c;
    }

    public String getLevelTag() {
        return this.u;
    }

    public int getReqBiddingType() {
        return this.y;
    }

    public String getRequestId() {
        return this.f;
    }

    public String getRitType() {
        return this.d;
    }

    public String getScenarioId() {
        return this.qt;
    }

    public String getSdkName() {
        return this.xj;
    }

    public String getSegmentId() {
        return this.p;
    }

    public String getSlotId() {
        return this.w;
    }

    public String getSubChannel() {
        return this.g;
    }

    public String getSubRitType() {
        return this.tf;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.zg = hashMap;
        this.xj = str;
        this.hf = str2;
        this.w = str3;
        this.u = str4;
        this.kd = str5;
        this.y = i;
        this.c = str6;
        this.f = str7;
        this.d = str8;
        this.tf = str9;
        this.p = str10;
        this.f10473pl = str11;
        this.g = str12;
        this.am = str13;
        this.qt = str14;
        if (map != null) {
            this.zg = map;
        } else {
            hashMap.clear();
        }
    }
}
