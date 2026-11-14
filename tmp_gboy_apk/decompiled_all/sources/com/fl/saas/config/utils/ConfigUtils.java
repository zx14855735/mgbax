package com.fl.saas.config.utils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ConfigUtils {
    public static boolean checkImpressFreq(String str) {
        boolean z;
        try {
            String string = SPUtil.getInstance().getString(str + "lastShowDay");
            int i = SPUtil.getInstance().getInt(str + "lastDayShowNumber");
            long j = SPUtil.getInstance().getLong(str + "lastShowHour");
            int i2 = SPUtil.getInstance().getInt(str + "lastHourShowNumber");
            long j2 = SPUtil.getInstance().getLong(str + "lastShowSec");
            int i3 = SPUtil.getInstance().getInt(str + "impressFreqDay");
            int i4 = SPUtil.getInstance().getInt(str + "impressFreqHour");
            int i5 = SPUtil.getInstance().getInt(str + "impressFreqInterval");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String date = DeviceUtil.getDate();
            if (i5 > 0) {
                z = true;
                if (currentTimeMillis - j2 <= i5) {
                    return true;
                }
            } else {
                z = true;
            }
            if (i4 > 0 && currentTimeMillis - j <= 3600 && i2 >= i4) {
                return z;
            }
            if (i3 > 0) {
                if (date.equals(string) && i >= i3) {
                    return z;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
