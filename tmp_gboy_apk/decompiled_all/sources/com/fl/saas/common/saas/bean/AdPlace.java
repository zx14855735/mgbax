package com.fl.saas.common.saas.bean;

import J3FDQU.A2egSU;
import com.fl.saas.base.rest.ConfigHelper;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdPlace {
    public List<AdSource> ad_sources;
    public ArrayList<Integer> advCacheabledList;
    public List<AdSource> bid_ad_sources;
    public int bid_notice_type;
    public List<AdSource> bottom_ad_sources;
    public List<AdSource> c2s_bid_ad_sources;
    public String group_id;
    public int impress_freq_day;
    public int impress_freq_hour;
    public int impress_interval;
    public String place_id;
    public int refresh_num;
    public String req_id;
    public long request_logic;
    private String sourceStr;
    public String test_id;
    public String track_id;
    public long update_time;
    public int all_time = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
    public int request_num = 1;
    public int api_timeout = 3000;
    public boolean isOpenCache = false;
    public int enhanceTarget = 0;
    public double floatingRatio = 1.0d;
    public long cacheValidTime = 0;
    public boolean has_api_bid = false;
    public int timeout = 3000;
    public int requestInterval = 500;
    public int client_timeout = 5000;
    public boolean server_verify = false;
    public int cache_queue_length = 1;
    public int use_public_adplace = 1;
    public int rela_public_adplace = 0;
    public int lbs = 0;
    public int lbjg = 0;
    public int lbsx = 3;
    public int highest_bid_difference = 0;
    public int refresh = 0;
    public int refresh_time = 0;
    public int verify_ad_refresh = 0;
    public int fill_price = 1;

    public AdPlace cloneObject(String str) {
        try {
            return ConfigHelper.getInstance().handleData(new JSONObject(this.sourceStr), str, this.place_id);
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }

    public boolean isBidding() {
        List<AdSource> list = this.bid_ad_sources;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isCachedECPMFirst() {
        return this.enhanceTarget == 2;
    }

    public boolean isCachedSpeedFirst() {
        return this.enhanceTarget == 1;
    }

    public boolean isOpenCycle() {
        return this.lbs == 1 && this.lbjg > 0;
    }

    public boolean isOpenPlaceCache() {
        return this.isOpenCache;
    }

    public void setSourceStr(String str) {
        this.sourceStr = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdPlace{ad_sources=");
        sb.append(this.ad_sources);
        sb.append(", all_time=");
        sb.append(this.all_time);
        sb.append(", group_id='");
        sb.append(this.group_id);
        sb.append("', place_id='");
        sb.append(this.place_id);
        sb.append("', request_num=");
        sb.append(this.request_num);
        sb.append(", timeout=");
        return A2egSU.B2KMhB(sb, this.timeout, '}');
    }
}
