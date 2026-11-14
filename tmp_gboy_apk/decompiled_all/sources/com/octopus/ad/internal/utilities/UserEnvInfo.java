package com.octopus.ad.internal.utilities;

import com.octopus.ad.R;
import com.octopus.ad.model.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UserEnvInfo {
    private static UserEnvInfo sUserEnvInfoInstance;
    public String ip;
    public g.c isp = g.c.ISP_OTHER;
    public g.d net;

    private UserEnvInfo() {
    }

    public static UserEnvInfo getInstance() {
        UserEnvInfo userEnvInfo;
        synchronized (UserEnvInfo.class) {
            try {
                if (sUserEnvInfoInstance == null) {
                    sUserEnvInfoInstance = new UserEnvInfo();
                    HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.init));
                }
                userEnvInfo = sUserEnvInfoInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return userEnvInfo;
    }
}
