package com.alliance.ssp.ad.utils;

import A5SV6n.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class jni_interface {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static jni_interface f9719A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f9720A2egSU = 0;

    @A2egSU
    public interface Callback {
        void onEvent(String str);
    }

    static {
        try {
            System.loadLibrary("adalliance");
        } catch (Exception | UnsatisfiedLinkError unused) {
        }
    }

    public static native String GetBoot();

    public static native String GetUpdate();

    public final void A2egSU(Context context, String str, SAAllianceAdData sAAllianceAdData, Callback callback) {
        if (context == null || TextUtils.isEmpty(str)) {
            callback.onEvent("-1");
            return;
        }
        try {
            Activity A5SV6n2 = context instanceof Activity ? (Activity) context : GJee0v.A2egSU.A5SV6n();
            if (A5SV6n2 != null && A5SV6n2.isDestroyed()) {
                callback.onEvent("-2");
                return;
            }
            HashMap hashMap = new HashMap();
            if (sAAllianceAdData != null) {
                if (sAAllianceAdData.getDpss() != null) {
                    hashMap.put("dpss", sAAllianceAdData.getDpss());
                }
                if (sAAllianceAdData.getDpsm() != null) {
                    hashMap.put("dpsm", sAAllianceAdData.getDpsm());
                }
                if (sAAllianceAdData.getCrequestid() != null) {
                    hashMap.put("crequestid", sAAllianceAdData.getCrequestid());
                }
                if (sAAllianceAdData.getCsec() != null) {
                    hashMap.put("csec", sAAllianceAdData.getCsec());
                }
                if (sAAllianceAdData.getCsec2() != null) {
                    hashMap.put("csec2", sAAllianceAdData.getCsec2());
                }
                if (sAAllianceAdData.getMaterial() != null) {
                    hashMap.put("url", sAAllianceAdData.getMaterial().getDeeplink());
                }
                if (sAAllianceAdData.getInteraction() != null && sAAllianceAdData.getInteraction().getClick() != null) {
                    if (sAAllianceAdData.getInteraction().getClick().limitation != null) {
                        hashMap.put("limitation", sAAllianceAdData.getInteraction().getClick().limitation);
                    }
                    if (sAAllianceAdData.getInteraction().getClick().probability != null) {
                        hashMap.put("probability", sAAllianceAdData.getInteraction().getClick().probability + "");
                    }
                }
                if (sAAllianceAdData.getInteraction() != null && sAAllianceAdData.getInteraction().getAuto() != null) {
                    if (sAAllianceAdData.getInteraction().getAuto().limitation != null) {
                        hashMap.put("limitation", sAAllianceAdData.getInteraction().getAuto().limitation);
                    }
                    if (sAAllianceAdData.getInteraction().getAuto().probability != null) {
                        hashMap.put("probability", sAAllianceAdData.getInteraction().getAuto().probability + "");
                    }
                }
                if (sAAllianceAdData.getSposid() != null) {
                    hashMap.put("sPosId", sAAllianceAdData.getSposid());
                }
            }
            hashMap.put(PointParamKey.TYPE, str);
            hashMap.put("act", A5SV6n2);
            try {
                getCommonParams(hashMap, callback);
            } catch (Exception e) {
                callback.onEvent("-2,3" + e);
            } catch (UnsatisfiedLinkError e2) {
                callback.onEvent("-2,2" + e2);
            }
        } catch (Exception e3) {
            callback.onEvent("-2,1" + e3);
        }
    }

    @A2egSU
    public boolean curTime(String str) {
        if (str == null || str.equals(Constants.FAIL) || str.isEmpty()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f9720A2egSU <= Long.parseLong(str) * 60000) {
            return false;
        }
        this.f9720A2egSU = currentTimeMillis;
        return true;
    }

    public native void getCommonParams(Map<String, Object> map, Callback callback);
}
