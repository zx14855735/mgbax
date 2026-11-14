package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ci implements com.kwad.sdk.core.d<a.C0353a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0353a c0353a, JSONObject jSONObject) {
        a2(c0353a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0353a c0353a, JSONObject jSONObject) {
        return b2(c0353a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0353a c0353a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0353a.aBs = jSONObject.optInt("ad_retry_type");
        c0353a.templateId = jSONObject.optString("template_id");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0353a.templateId)) {
            c0353a.templateId = "";
        }
        c0353a.aBt = jSONObject.optString("template_sub_id");
        if (obj.toString().equals(c0353a.aBt)) {
            c0353a.aBt = "";
        }
        c0353a.aBu = jSONObject.optString("default_type");
        if (obj.toString().equals(c0353a.aBu)) {
            c0353a.aBu = "";
        }
        c0353a.aBw = jSONObject.optString("template_show_type");
        if (obj.toString().equals(c0353a.aBw)) {
            c0353a.aBw = "";
        }
        c0353a.aBx = A2egSU.A5SV6n("3", "network_download_status", jSONObject);
        c0353a.aBy = jSONObject.optInt("award_task_name");
        c0353a.aBz = jSONObject.optInt("jumps_liveroom_type");
        c0353a.aBA = jSONObject.optInt("universe_feature_freg");
        c0353a.aBB = jSONObject.optInt("replace_url_succ");
        c0353a.aBC = jSONObject.optBoolean("is_dp_opt");
        c0353a.aBD = jSONObject.optString("component_module");
        if (obj.toString().equals(c0353a.aBD)) {
            c0353a.aBD = "";
        }
        c0353a.aBF = jSONObject.optInt("is_carousel");
        c0353a.aBG = jSONObject.optInt("is_special_preload");
        c0353a.aBH = jSONObject.optInt("card_type");
        c0353a.aBI = jSONObject.optInt("is_closure");
        c0353a.aBJ = jSONObject.optString("authorization_status");
        if (obj.toString().equals(c0353a.aBJ)) {
            c0353a.aBJ = "";
        }
        c0353a.aBK = jSONObject.optString("login_source");
        if (obj.toString().equals(c0353a.aBK)) {
            c0353a.aBK = "";
        }
        c0353a.aBL = jSONObject.optInt("is_login");
        c0353a.aBM = jSONObject.optInt("coupon_receive_status");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0353a c0353a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0353a.aBs;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_retry_type", i);
        }
        String str = c0353a.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", c0353a.templateId);
        }
        String str2 = c0353a.aBt;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_sub_id", c0353a.aBt);
        }
        String str3 = c0353a.aBu;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "default_type", c0353a.aBu);
        }
        String str4 = c0353a.aBw;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_show_type", c0353a.aBw);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "network_download_status", c0353a.aBx);
        int i2 = c0353a.aBy;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "award_task_name", i2);
        }
        int i3 = c0353a.aBz;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jumps_liveroom_type", i3);
        }
        int i4 = c0353a.aBA;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "universe_feature_freg", i4);
        }
        int i5 = c0353a.aBB;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "replace_url_succ", i5);
        }
        boolean z = c0353a.aBC;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_dp_opt", z);
        }
        String str5 = c0353a.aBD;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "component_module", c0353a.aBD);
        }
        int i6 = c0353a.aBF;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_carousel", i6);
        }
        int i7 = c0353a.aBG;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_special_preload", i7);
        }
        int i8 = c0353a.aBH;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "card_type", i8);
        }
        int i9 = c0353a.aBI;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_closure", i9);
        }
        String str6 = c0353a.aBJ;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorization_status", c0353a.aBJ);
        }
        String str7 = c0353a.aBK;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "login_source", c0353a.aBK);
        }
        int i10 = c0353a.aBL;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_login", i10);
        }
        int i11 = c0353a.aBM;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "coupon_receive_status", i11);
        }
        return jSONObject;
    }
}
