package com.fl.saas.common.widget.h5;

import android.text.TextUtils;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.SPUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class QuickAppHelper {
    private static QuickAppHelper sInstance;
    private Map<String, Boolean> enableQuickAppConfig;
    private AdSource mAdSource;
    private List<String> whitelistHeaders;
    private final List<String> listQuickKey = new ArrayList();
    private int collectWebviewWakeup = 0;
    private double quickAppBlockRatio = 100.0d;
    private int webviewWakeupLimit = 0;
    private int quickAppInterceptionType = 1;
    private int quickAppFreqDay = 0;
    private final Map<String, Integer> startQuickAppTimesMap = new HashMap();

    private QuickAppHelper() {
    }

    private boolean checkInterceptRatio() {
        double d = this.quickAppBlockRatio;
        return d < 100.0d && d >= 0.0d && new Random().nextDouble() * 100.0d > this.quickAppBlockRatio;
    }

    private boolean checkQuickAppFreqDay(boolean z, String str, int i) {
        if (this.quickAppFreqDay <= 0) {
            if (!checkInterceptRatio()) {
                return true;
            }
            if (z) {
                this.startQuickAppTimesMap.put(str, Integer.valueOf(i + 1));
            }
            return false;
        }
        String date = DeviceUtil.getDate();
        if (!date.equals(SPUtil.getInstance().getString("lastOpenQuickAppDay", ""))) {
            if (!checkInterceptRatio()) {
                return true;
            }
            SPUtil.getInstance().putString("lastOpenQuickAppDay", date);
            SPUtil.getInstance().putInt("lastDayOpenQuickAppDayNumber", 1);
            if (z) {
                this.startQuickAppTimesMap.put(str, Integer.valueOf(i + 1));
            }
            return false;
        }
        int i2 = SPUtil.getInstance().getInt("lastDayOpenQuickAppDayNumber", 0);
        if (i2 >= this.quickAppFreqDay || !checkInterceptRatio()) {
            return true;
        }
        SPUtil.getInstance().putInt("lastDayOpenQuickAppDayNumber", i2 + 1);
        if (z) {
            this.startQuickAppTimesMap.put(str, Integer.valueOf(i + 1));
        }
        return false;
    }

    public static QuickAppHelper getInstance() {
        if (sInstance == null) {
            synchronized (QuickAppHelper.class) {
                sInstance = new QuickAppHelper();
            }
        }
        return sInstance;
    }

    public void addListQuickKey(List<String> list) {
        if (list != null) {
            for (String str : list) {
                if (!this.listQuickKey.contains(str)) {
                    this.listQuickKey.add(str);
                }
            }
        }
    }

    public void clearHistory() {
        this.mAdSource = null;
        this.startQuickAppTimesMap.clear();
    }

    public boolean enableQuickApp(String str) {
        Map<String, Boolean> map = this.enableQuickAppConfig;
        if (map != null) {
            return Boolean.TRUE.equals(map.get(str));
        }
        return false;
    }

    public int getQuickAppInterceptionType() {
        return this.quickAppInterceptionType;
    }

    public void reportUrl(String str) {
        if (this.collectWebviewWakeup == 0 || this.mAdSource == null || TextUtils.isEmpty(str)) {
            return;
        }
        ReportHelper.getInstance().reportDpUrl(this.mAdSource, str);
    }

    public void setAdSource(AdSource adSource) {
        this.mAdSource = adSource;
    }

    public void setCollectWebviewWakeup(int i) {
        this.collectWebviewWakeup = i;
    }

    public void setEnableQuickApp(String str, int i) {
        if (this.enableQuickAppConfig == null) {
            this.enableQuickAppConfig = new HashMap();
        }
        this.enableQuickAppConfig.put(str, Boolean.valueOf(i == 0));
    }

    public void setQuickAppBlockRatio(double d) {
        this.quickAppBlockRatio = d;
    }

    public void setQuickAppFreqDay(int i) {
        this.quickAppFreqDay = i;
    }

    public void setQuickAppInterceptionType(int i) {
        this.quickAppInterceptionType = i;
    }

    public void setWebviewWakeupLimit(int i) {
        this.webviewWakeupLimit = i;
    }

    public void setWhitelistHeaders(List<String> list) {
        this.whitelistHeaders = list;
    }

    public boolean urlIntercept(String str) {
        Integer num;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> list = this.whitelistHeaders;
        if (list != null && !list.isEmpty()) {
            for (String str2 : this.whitelistHeaders) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return false;
                }
            }
        }
        if (!this.listQuickKey.isEmpty()) {
            for (String str3 : this.listQuickKey) {
                if (!TextUtils.isEmpty(str3) && str.startsWith(str3)) {
                    if (this.webviewWakeupLimit <= 0) {
                        return checkQuickAppFreqDay(false, str, 0);
                    }
                    if (this.startQuickAppTimesMap.containsKey(str) && (num = this.startQuickAppTimesMap.get(str)) != null) {
                        if (num.intValue() < this.webviewWakeupLimit) {
                            return checkQuickAppFreqDay(true, str, num.intValue());
                        }
                        return true;
                    }
                    return checkQuickAppFreqDay(true, str, 0);
                }
            }
        }
        return false;
    }
}
