package com.fl.saas.s2s.sdk.helper;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.NetDataUtils;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.db.a;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import com.sigmob.sdk.mraid.g;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2sRequestHelper {
    private static S2sRequestHelper sInstance;
    private int adCount;
    private long reqTime;

    /* JADX INFO: Access modifiers changed from: private */
    public void analyzeResponse(String str, OnYqAdListener onYqAdListener, AdSource adSource) {
        int i;
        double d;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str2;
        int i8;
        int i9;
        int i10;
        String str3;
        String str4;
        YdError create;
        String str5 = "S";
        if (onYqAdListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            onYqAdListener.onAdFailed(YdError.create(ErrorCodeConstant.AD_DATA_ERROR, "return null-string response"));
            return;
        }
        try {
            JSONObject parseResponseNew = NetDataUtils.parseResponseNew(str);
            int optInt = parseResponseNew.optInt(PluginConstants.KEY_ERROR_CODE, -1);
            if (optInt == -1) {
                create = YdError.create(ErrorCodeConstant.AD_DATA_ERROR, "ret==" + optInt);
            } else {
                JSONArray optJSONArray = parseResponseNew.optJSONArray(a.f13169a);
                ArrayList arrayList = new ArrayList();
                int optInt2 = parseResponseNew.optInt("adv_id", 0);
                if (optInt2 != 0) {
                    adSource.adv_id = optInt2;
                    adSource.mAdv_id = optInt2;
                }
                int optInt3 = parseResponseNew.optInt("hotspot_type");
                int optInt4 = parseResponseNew.optInt("scale_type");
                String optString = parseResponseNew.optString("is_download", "S");
                String optString2 = parseResponseNew.optString("hotspot");
                if (adSource.isApiBidAd) {
                    adSource.parseJson(parseResponseNew);
                    int optInt5 = parseResponseNew.optInt(g.b, 50);
                    adSource.setCloseButtonShow(parseResponseNew.optString("close_button_type", "A"));
                    adSource.count_down = parseResponseNew.optInt("count_down", 5);
                    adSource.button_size = parseResponseNew.optInt("button_size", 50);
                    i = optInt5;
                } else {
                    i = adSource.sensitivity;
                }
                int optInt6 = parseResponseNew.optInt("template_type_id");
                int optInt7 = parseResponseNew.optInt("left_right_margin");
                String str6 = optString;
                int i11 = i;
                int i12 = optInt4;
                int optInt8 = parseResponseNew.optInt("top_bottom_margin");
                double optDouble = parseResponseNew.optDouble("click_callback_ratio", 100.0d);
                int i13 = adSource.rd_type;
                int i14 = adSource.rd_countdown;
                int i15 = adSource.rd_skip_time;
                int i16 = adSource.rd_click_time;
                int i17 = adSource.rd_auto_type;
                int i18 = adSource.rd_auto_time;
                String str7 = adSource.rd_autoskip_sts;
                if (parseResponseNew.has("rd_countdown")) {
                    d = optDouble;
                    int optInt9 = parseResponseNew.optInt("rd_type", 1);
                    int optInt10 = parseResponseNew.optInt("rd_countdown", 15);
                    i4 = parseResponseNew.optInt("rd_skip_time", -1);
                    int optInt11 = parseResponseNew.optInt("rd_click_time", -1);
                    int optInt12 = parseResponseNew.optInt("rd_auto_type", 2);
                    i7 = parseResponseNew.optInt("rd_auto_time", 0);
                    str2 = parseResponseNew.optString("rd_autoskip_sts", "S");
                    i2 = optInt9;
                    i3 = optInt10;
                    i5 = optInt11;
                    i6 = optInt12;
                } else {
                    d = optDouble;
                    i2 = i13;
                    i3 = i14;
                    i4 = i15;
                    i5 = i16;
                    i6 = i17;
                    i7 = i18;
                    str2 = str7;
                }
                int i19 = adSource.display_mask;
                if (parseResponseNew.has("display_mask")) {
                    i19 = parseResponseNew.optInt("display_mask", 1);
                }
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    i8 = i19;
                } else {
                    i8 = i19;
                    int i20 = 0;
                    while (i20 < optJSONArray.length()) {
                        AdInfoPoJo adInfoPojo = getAdInfoPojo(optJSONArray.optJSONObject(i20));
                        adInfoPojo.autoPlayType = parseResponseNew.optInt("auto_play_type", 0);
                        arrayList.add(adInfoPojo);
                        i20++;
                        optJSONArray = optJSONArray;
                    }
                }
                if (arrayList.size() != 0) {
                    int i21 = 0;
                    while (i21 < arrayList.size()) {
                        ((AdInfoPoJo) arrayList.get(i21)).place_id = adSource.place_id;
                        ((AdInfoPoJo) arrayList.get(i21)).trackId = adSource.track_id;
                        if (optInt2 != 0) {
                            ((AdInfoPoJo) arrayList.get(i21)).adv_id = optInt2;
                        } else {
                            ((AdInfoPoJo) arrayList.get(i21)).adv_id = adSource.adv_id;
                        }
                        ((AdInfoPoJo) arrayList.get(i21)).hotspot = optString2;
                        ((AdInfoPoJo) arrayList.get(i21)).hotspot_type = optInt3;
                        if (i12 != 0) {
                            i9 = i12;
                            ((AdInfoPoJo) arrayList.get(i21)).scale_type = i9;
                            i10 = optInt2;
                        } else {
                            i9 = i12;
                            i10 = optInt2;
                            ((AdInfoPoJo) arrayList.get(i21)).scale_type = adSource.scale_type;
                        }
                        ((AdInfoPoJo) arrayList.get(i21)).template_type_id = optInt6;
                        ((AdInfoPoJo) arrayList.get(i21)).left_right_margin = optInt7;
                        int i22 = optInt8;
                        ((AdInfoPoJo) arrayList.get(i21)).top_bottom_margin = i22;
                        int i23 = optInt6;
                        int i24 = i11;
                        ((AdInfoPoJo) arrayList.get(i21)).sensitivity = i24;
                        i11 = i24;
                        ((AdInfoPoJo) arrayList.get(i21)).isApiBidAd = adSource.isApiBidAd;
                        if (str5.equals(adSource.is_download)) {
                            str3 = str6;
                            if (str5.equals(str3)) {
                                str4 = str5;
                                ((AdInfoPoJo) arrayList.get(i21)).rd_type = i2;
                                ((AdInfoPoJo) arrayList.get(i21)).rd_countdown = i3;
                                ((AdInfoPoJo) arrayList.get(i21)).rd_skip_time = i4;
                                int i25 = i5;
                                ((AdInfoPoJo) arrayList.get(i21)).rd_click_time = i25;
                                int i26 = i3;
                                int i27 = i6;
                                ((AdInfoPoJo) arrayList.get(i21)).rd_auto_type = i27;
                                int i28 = i7;
                                ((AdInfoPoJo) arrayList.get(i21)).rd_auto_time = i28;
                                String str8 = str2;
                                ((AdInfoPoJo) arrayList.get(i21)).rd_autoskip_sts = str8;
                                int i29 = i8;
                                ((AdInfoPoJo) arrayList.get(i21)).display_mask = i29;
                                AdInfoPoJo adInfoPoJo = (AdInfoPoJo) arrayList.get(i21);
                                int i30 = i21;
                                double d2 = d;
                                adInfoPoJo.click_value = d2;
                                d = d2;
                                i21 = i30 + 1;
                                i3 = i26;
                                optInt6 = i23;
                                i6 = i27;
                                i7 = i28;
                                str2 = str8;
                                i8 = i29;
                                i5 = i25;
                                optInt8 = i22;
                                str5 = str4;
                                optInt2 = i10;
                                str6 = str3;
                                i12 = i9;
                            }
                        } else {
                            str3 = str6;
                        }
                        str4 = str5;
                        ((AdInfoPoJo) arrayList.get(i21)).isShowDownloadDialog = true;
                        ((AdInfoPoJo) arrayList.get(i21)).rd_type = i2;
                        ((AdInfoPoJo) arrayList.get(i21)).rd_countdown = i3;
                        ((AdInfoPoJo) arrayList.get(i21)).rd_skip_time = i4;
                        int i252 = i5;
                        ((AdInfoPoJo) arrayList.get(i21)).rd_click_time = i252;
                        int i262 = i3;
                        int i272 = i6;
                        ((AdInfoPoJo) arrayList.get(i21)).rd_auto_type = i272;
                        int i282 = i7;
                        ((AdInfoPoJo) arrayList.get(i21)).rd_auto_time = i282;
                        String str82 = str2;
                        ((AdInfoPoJo) arrayList.get(i21)).rd_autoskip_sts = str82;
                        int i292 = i8;
                        ((AdInfoPoJo) arrayList.get(i21)).display_mask = i292;
                        AdInfoPoJo adInfoPoJo2 = (AdInfoPoJo) arrayList.get(i21);
                        int i302 = i21;
                        double d22 = d;
                        adInfoPoJo2.click_value = d22;
                        d = d22;
                        i21 = i302 + 1;
                        i3 = i262;
                        optInt6 = i23;
                        i6 = i272;
                        i7 = i282;
                        str2 = str82;
                        i8 = i292;
                        i5 = i252;
                        optInt8 = i22;
                        str5 = str4;
                        optInt2 = i10;
                        str6 = str3;
                        i12 = i9;
                    }
                    AdInfoPoJo adInfoPoJo3 = (AdInfoPoJo) Check.findFirstNonNull(arrayList);
                    if (adInfoPoJo3 != null) {
                        adSource.setCtype(adInfoPoJo3.creative.ctype);
                        adSource.setTitle(adInfoPoJo3.title);
                        adSource.setDesc(adInfoPoJo3.description);
                        adSource.isDownLoad = "1".equals(adInfoPoJo3.ac_type) && TextUtils.isEmpty(adInfoPoJo3.deep_url);
                        adSource.is_black = adInfoPoJo3.is_black;
                    }
                    if (TextUtils.equals(parseResponseNew.optString("priority_race"), "A")) {
                        adSource.setPriorityStrategy(new ADYaiT(parseResponseNew.optInt("floating_type"), parseResponseNew.optInt("floating_value")));
                    }
                    adSource.price = ((AdInfoPoJo) arrayList.get(0)).price;
                    if (((AdInfoPoJo) arrayList.get(0)).price > 0 && adSource.isApiBidAd) {
                        adSource.bidfloor = ((AdInfoPoJo) arrayList.get(0)).price;
                    }
                    adSource.responseStr = str;
                    onYqAdListener.onNativeAdReceived(arrayList);
                    return;
                }
                create = YdError.create(ErrorCodeConstant.AD_DATA_ERROR, "adInfoList is empty");
            }
            onYqAdListener.onAdFailed(create);
        } catch (Exception e) {
            e.printStackTrace();
            onYqAdListener.onAdFailed(YdError.create(ErrorCodeConstant.AD_DATA_ERROR, e.getMessage()));
        }
    }

    private AdInfoPoJo getAdInfoPojo(JSONObject jSONObject) {
        JSONObject jSONObject2;
        AdInfoPoJo adInfoPoJo = new AdInfoPoJo();
        adInfoPoJo.reqTime = this.reqTime;
        adInfoPoJo.adid = jSONObject.optString("adid");
        adInfoPoJo.advName = jSONObject.optString("adv_name", "广告");
        adInfoPoJo.ac_type = jSONObject.optString("ac_type");
        adInfoPoJo.price = jSONObject.optInt("price");
        adInfoPoJo.click_url = jSONObject.optString("landing_page");
        adInfoPoJo.deep_url = jSONObject.optString("deeplink_url");
        adInfoPoJo.download_url = jSONObject.optString("download_url");
        adInfoPoJo.app_package = jSONObject.optString("app_package");
        adInfoPoJo.ad_logo = jSONObject.optString("ad_logo");
        adInfoPoJo.app_name = jSONObject.optString("app_name");
        adInfoPoJo.advertiser_name = jSONObject.optString("advertiser_name");
        adInfoPoJo.app_version = jSONObject.optString(n.r);
        adInfoPoJo.package_size_bytes = jSONObject.optString("package_size_bytes");
        adInfoPoJo.permissions_url = jSONObject.optString("permissions_url");
        adInfoPoJo.privacy_agreement = jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.PRIVACY_AGREEMENT);
        JSONArray optJSONArray = jSONObject.optJSONArray("permission_list");
        if (optJSONArray != null) {
            adInfoPoJo.permission_list = optJSONArray.toString();
        }
        adInfoPoJo.app_intro_url = jSONObject.optString("app_intro_url");
        adInfoPoJo.wxAppId = jSONObject.optString("wx_app_id");
        adInfoPoJo.miniProgramOriginId = jSONObject.optString("wx_mini_pro_id");
        adInfoPoJo.miniPath = jSONObject.optString("wx_mini_pro_path");
        adInfoPoJo.autoPlayType = jSONObject.optInt("auto_play_type", 0);
        adInfoPoJo.draw_type = jSONObject.optInt("draw_type", 0);
        adInfoPoJo.is_black = jSONObject.optInt("is_black", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("creative");
        AdInfoPoJo.Creative creative = new AdInfoPoJo.Creative();
        if (optJSONObject != null) {
            creative.cid = optJSONObject.optString("cid");
            creative.ctype = optJSONObject.optInt("ctype");
            creative.title = optJSONObject.optString("title");
            adInfoPoJo.title = optJSONObject.optString("title");
            creative.desc = optJSONObject.optString("desc");
            adInfoPoJo.description = optJSONObject.optString("desc");
            creative.button = optJSONObject.optString("button");
            creative.brand = optJSONObject.optString(bn.j);
            jSONObject2 = optJSONObject.optJSONObject("video");
        } else {
            jSONObject2 = null;
        }
        AdInfoPoJo.Video video = new AdInfoPoJo.Video();
        if (jSONObject2 != null) {
            video.video_url = jSONObject2.optString("video_url");
            adInfoPoJo.video_url = jSONObject2.optString("video_url");
            video.width = jSONObject2.optInt(MediaFormat.KEY_WIDTH);
            video.height = jSONObject2.optInt(MediaFormat.KEY_HEIGHT);
            video.duration = jSONObject2.optInt(MediationConstant.EXTRA_DURATION);
            adInfoPoJo.VIDEO_TIME = jSONObject2.optInt(MediationConstant.EXTRA_DURATION);
            video.size = jSONObject2.optLong("size");
            video.end_url = jSONObject2.optString("end_url");
            adInfoPoJo.end_html = jSONObject2.optString("end_url");
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("cover");
            if (optJSONObject2 != null) {
                AdInfoPoJo.Img img = new AdInfoPoJo.Img();
                img.url = optJSONObject2.optString("url");
                img.width = optJSONObject2.optInt(MediaFormat.KEY_WIDTH);
                img.height = optJSONObject2.optInt(MediaFormat.KEY_HEIGHT);
                video.cover = img;
            }
            creative.video = video;
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("imgs");
        ArrayList arrayList = new ArrayList();
        AdInfoPoJo.Img img2 = new AdInfoPoJo.Img();
        if (optJSONArray2 != null) {
            for (int i = 0; i < optJSONArray2.length(); i++) {
                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i);
                img2.url = optJSONObject3.optString("url");
                img2.width = optJSONObject3.optInt(MediaFormat.KEY_WIDTH);
                img2.height = optJSONObject3.optInt(MediaFormat.KEY_HEIGHT);
                arrayList.add(img2);
                if (i == 0) {
                    adInfoPoJo.img_url = optJSONObject3.optString("url");
                    adInfoPoJo.width = optJSONObject3.optInt(MediaFormat.KEY_WIDTH);
                    adInfoPoJo.height = optJSONObject3.optInt(MediaFormat.KEY_HEIGHT);
                }
            }
        }
        creative.imgs = arrayList;
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("icon");
        AdInfoPoJo.Img img3 = new AdInfoPoJo.Img();
        if (optJSONObject4 != null) {
            img3.url = optJSONObject4.optString("url");
            img3.width = optJSONObject4.optInt(MediaFormat.KEY_WIDTH);
            img3.height = optJSONObject4.optInt(MediaFormat.KEY_HEIGHT);
            creative.icon = img3;
            adInfoPoJo.logo_icon = optJSONObject4.optString("url");
        }
        adInfoPoJo.creative = creative;
        AdInfoPoJo.AdInteractiveMode adInteractiveMode = new AdInfoPoJo.AdInteractiveMode();
        JSONObject optJSONObject5 = jSONObject.optJSONObject("ad_interactio_mode");
        if (optJSONObject5 != null) {
            adInteractiveMode.normalclick = optJSONObject5.optString("normalclick", "");
            adInteractiveMode.shake = optJSONObject5.optString("shake", "");
            adInteractiveMode.slideclick = optJSONObject5.optString("slideclick", "");
            adInteractiveMode.twist = optJSONObject5.optString("twist", "");
        }
        adInfoPoJo.adInteractiveMode = adInteractiveMode;
        JSONArray optJSONArray3 = jSONObject.optJSONArray("imp_notice_urls");
        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray3.length(); i2 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray3, i2, adInfoPoJo.impress_notice_urls, i2, 1)) {
            }
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("notice_success_urls");
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray4.length(); i3 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray4, i3, adInfoPoJo.notice_success_urls, i3, 1)) {
            }
        }
        JSONArray optJSONArray5 = jSONObject.optJSONArray("notice_failed_urls");
        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray5.length(); i4 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray5, i4, adInfoPoJo.notice_failed_urls, i4, 1)) {
            }
        }
        JSONArray optJSONArray6 = jSONObject.optJSONArray("click_notice_urls");
        if (optJSONArray6 != null && optJSONArray6.length() > 0) {
            for (int i5 = 0; i5 < optJSONArray6.length(); i5 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray6, i5, adInfoPoJo.click_notice_urls, i5, 1)) {
            }
        }
        JSONArray optJSONArray7 = jSONObject.optJSONArray("dpsuccess_notice_urls");
        if (optJSONArray7 != null && optJSONArray7.length() > 0) {
            for (int i6 = 0; i6 < optJSONArray7.length(); i6 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray7, i6, adInfoPoJo.deeplink_notice_urls, i6, 1)) {
            }
        }
        JSONArray optJSONArray8 = jSONObject.optJSONArray("video_end_notice_urls");
        if (optJSONArray8 != null && optJSONArray8.length() > 0) {
            for (int i7 = 0; i7 < optJSONArray8.length(); i7 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray8, i7, adInfoPoJo.playing_end_notice_urls, i7, 1)) {
            }
        }
        JSONArray optJSONArray9 = jSONObject.optJSONArray("download_start_notice_urls");
        if (optJSONArray9 != null && optJSONArray9.length() > 0) {
            for (int i8 = 0; i8 < optJSONArray9.length(); i8 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray9, i8, adInfoPoJo.download_start_notice_urls, i8, 1)) {
            }
        }
        JSONArray optJSONArray10 = jSONObject.optJSONArray("download_end_notice_urls");
        if (optJSONArray10 != null && optJSONArray10.length() > 0) {
            for (int i9 = 0; i9 < optJSONArray10.length(); i9 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray10, i9, adInfoPoJo.download_notice_urls, i9, 1)) {
            }
        }
        JSONArray optJSONArray11 = jSONObject.optJSONArray("install_start_notice_urls");
        if (optJSONArray11 != null && optJSONArray11.length() > 0) {
            for (int i10 = 0; i10 < optJSONArray11.length(); i10 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray11, i10, adInfoPoJo.install_start_notice_urls, i10, 1)) {
            }
        }
        JSONArray optJSONArray12 = jSONObject.optJSONArray("install_end_notice_urls");
        if (optJSONArray12 != null && optJSONArray12.length() > 0) {
            for (int i11 = 0; i11 < optJSONArray12.length(); i11 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray12, i11, adInfoPoJo.install_end_notice_urls, i11, 1)) {
            }
        }
        JSONArray optJSONArray13 = jSONObject.optJSONArray("open_notice_urls");
        if (optJSONArray13 != null && optJSONArray13.length() > 0) {
            for (int i12 = 0; i12 < optJSONArray13.length(); i12 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray13, i12, adInfoPoJo.open_notice_urls, i12, 1)) {
            }
        }
        JSONArray optJSONArray14 = jSONObject.optJSONArray("video_view_urls");
        if (optJSONArray14 != null && optJSONArray14.length() > 0) {
            for (int i13 = 0; i13 < optJSONArray14.length(); i13 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray14, i13, adInfoPoJo.video_view_urls, i13, 1)) {
            }
        }
        JSONArray optJSONArray15 = jSONObject.optJSONArray("close");
        if (optJSONArray15 != null && optJSONArray15.length() > 0) {
            for (int i14 = 0; i14 < optJSONArray15.length(); i14 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray15, i14, adInfoPoJo.closes, i14, 1)) {
            }
        }
        JSONArray optJSONArray16 = jSONObject.optJSONArray("video_start_notice_urls");
        if (optJSONArray16 != null && optJSONArray16.length() > 0) {
            for (int i15 = 0; i15 < optJSONArray16.length(); i15 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray16, i15, adInfoPoJo.video_start_notice_urls, i15, 1)) {
            }
        }
        JSONArray optJSONArray17 = jSONObject.optJSONArray("video_pause_notice_urls");
        if (optJSONArray17 != null && optJSONArray17.length() > 0) {
            for (int i16 = 0; i16 < optJSONArray17.length(); i16 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray17, i16, adInfoPoJo.video_pause_notice_urls, i16, 1)) {
            }
        }
        JSONArray optJSONArray18 = jSONObject.optJSONArray("video_fullscreen_notice_urls");
        if (optJSONArray18 != null && optJSONArray18.length() > 0) {
            for (int i17 = 0; i17 < optJSONArray18.length(); i17 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray18, i17, adInfoPoJo.video_fullscreen_notice_urls, i17, 1)) {
            }
        }
        JSONArray optJSONArray19 = jSONObject.optJSONArray("video_continue_notice_urls");
        if (optJSONArray19 != null && optJSONArray19.length() > 0) {
            for (int i18 = 0; i18 < optJSONArray19.length(); i18 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray19, i18, adInfoPoJo.video_continue_notice_urls, i18, 1)) {
            }
        }
        JSONArray optJSONArray20 = jSONObject.optJSONArray("video_skip_notice_urls");
        if (optJSONArray20 != null && optJSONArray20.length() > 0) {
            for (int i19 = 0; i19 < optJSONArray20.length(); i19 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray20, i19, adInfoPoJo.video_skip_notice_urls, i19, 1)) {
            }
        }
        JSONArray optJSONArray21 = jSONObject.optJSONArray("video_mute_notice_urls");
        if (optJSONArray21 != null && optJSONArray21.length() > 0) {
            for (int i20 = 0; i20 < optJSONArray21.length(); i20 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray21, i20, adInfoPoJo.video_mute_notice_urls, i20, 1)) {
            }
        }
        JSONArray optJSONArray22 = jSONObject.optJSONArray("video_first_quartile_notice_urls");
        if (optJSONArray22 != null && optJSONArray22.length() > 0) {
            for (int i21 = 0; i21 < optJSONArray22.length(); i21 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray22, i21, adInfoPoJo.video_first_quartile_notice_urls, i21, 1)) {
            }
        }
        JSONArray optJSONArray23 = jSONObject.optJSONArray("video_midpoint_notice_urls");
        if (optJSONArray23 != null && optJSONArray23.length() > 0) {
            for (int i22 = 0; i22 < optJSONArray23.length(); i22 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray23, i22, adInfoPoJo.video_midpoint_notice_urls, i22, 1)) {
            }
        }
        JSONArray optJSONArray24 = jSONObject.optJSONArray("video_third_quartile_notice_urls");
        if (optJSONArray24 != null && optJSONArray24.length() > 0) {
            for (int i23 = 0; i23 < optJSONArray24.length(); i23 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray24, i23, adInfoPoJo.video_third_quartile_notice_urls, i23, 1)) {
            }
        }
        JSONArray optJSONArray25 = jSONObject.optJSONArray("app_installed_notice_urls");
        if (optJSONArray25 != null && optJSONArray25.length() > 0) {
            for (int i24 = 0; i24 < optJSONArray25.length(); i24 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray25, i24, adInfoPoJo.app_installed_notice_urls, i24, 1)) {
            }
        }
        JSONArray optJSONArray26 = jSONObject.optJSONArray("dp_attempt_notice_urls");
        if (optJSONArray26 != null && optJSONArray26.length() > 0) {
            for (int i25 = 0; i25 < optJSONArray26.length(); i25 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray26, i25, adInfoPoJo.dp_attempt_notice_urls, i25, 1)) {
            }
        }
        JSONArray optJSONArray27 = jSONObject.optJSONArray("dpfail_notice_urls");
        if (optJSONArray27 != null && optJSONArray27.length() > 0) {
            for (int i26 = 0; i26 < optJSONArray27.length(); i26 = com.bykv.vk.component.ttvideo.player.A2egSU.ADYaiT(optJSONArray27, i26, adInfoPoJo.dpfail_notice_urls, i26, 1)) {
            }
        }
        return adInfoPoJo;
    }

    private JSONObject getImp(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("adcount", Integer.valueOf(this.adCount));
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("bidfloor", Integer.valueOf(adSource.bidfloor));
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static S2sRequestHelper getInstance() {
        if (sInstance == null) {
            synchronized (S2sRequestHelper.class) {
                sInstance = new S2sRequestHelper();
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$analyzeResponse$0(int i, int i2, Integer num) {
        int intValue;
        if (i == 1) {
            intValue = ((i2 + 1) * num.intValue()) / 100;
        } else {
            intValue = i2 + num.intValue();
        }
        return Integer.valueOf(intValue);
    }

    private JSONObject requestBidParam(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("place_id", adSource.tagid);
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject requestParam(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, adSource.req_id);
            jSONObject.putOpt("version", "2.8.8");
            jSONObject.putOpt("imp", getImp(adSource));
            jSONObject.putOpt(PointCategory.APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("timeout", "5000");
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void requestAd(int i, final AdSource adSource, final OnYqAdListener onYqAdListener) {
        this.adCount = i;
        this.reqTime = DeviceUtil.getBootTime();
        if (adSource == null) {
            if (onYqAdListener == null) {
                return;
            }
            onYqAdListener.onAdFailed(YdError.create(ErrorCodeConstant.NETWORK_ERROR, "adSource null"));
        } else {
            if (adSource.getAdCacheBean() != null) {
                analyzeResponse(adSource.getAdCacheBean().getValue(), onYqAdListener, adSource);
                return;
            }
            boolean z = adSource.isApiBidAd;
            AdHttpUtils.getInstance().doPost(z ? CommConstant.API.NEW_API_BID : CommConstant.API.NEW_S2S, AesUtils.encrypt((z ? requestBidParam(adSource) : requestParam(adSource)).toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.S2sRequestHelper.1
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.e(exc.getMessage());
                    OnYqAdListener onYqAdListener2 = onYqAdListener;
                    if (onYqAdListener2 == null) {
                        return;
                    }
                    onYqAdListener2.onAdFailed(YdError.create(ErrorCodeConstant.NETWORK_ERROR, exc.getMessage()));
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    S2sRequestHelper.this.analyzeResponse(str, onYqAdListener, adSource);
                }
            });
        }
    }
}
