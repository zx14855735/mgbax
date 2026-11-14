package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CSJConfig implements AdConfig {
    private int am;
    private boolean c;
    private int[] d;
    private IMediationConfig e;
    private boolean f;
    private int g;
    private String hf;
    private String kd;
    private Map<String, Object> p;

    /* renamed from: pl, reason: collision with root package name */
    private TTCustomController f10265pl;
    private int qt;
    private boolean tf;
    private String u;
    private boolean w;
    private String xj;
    private int y;
    private boolean zg;

    public static class xj {
        private int[] d;
        private String hf;
        private String kd;
        private TTCustomController p;

        /* renamed from: pl, reason: collision with root package name */
        private int f10266pl;
        private boolean qt;
        private String u;
        private String xj;
        private IMediationConfig zg;
        private boolean w = false;
        private int y = 0;
        private boolean c = true;
        private boolean f = false;
        private boolean tf = false;
        private int g = 2;
        private int am = 0;
        private Map<String, Object> e = null;

        public xj hf(String str) {
            this.hf = str;
            return this;
        }

        public xj kd(boolean z) {
            this.qt = z;
            return this;
        }

        public xj u(String str) {
            this.kd = str;
            return this;
        }

        public xj w(String str) {
            this.u = str;
            return this;
        }

        public xj xj(String str) {
            this.xj = str;
            return this;
        }

        public xj hf(boolean z) {
            this.c = z;
            return this;
        }

        public xj u(boolean z) {
            this.tf = z;
            return this;
        }

        public xj w(boolean z) {
            this.f = z;
            return this;
        }

        public xj xj(boolean z) {
            this.w = z;
            return this;
        }

        public xj hf(int i) {
            this.f10266pl = i;
            return this;
        }

        public xj u(int i) {
            this.am = i;
            return this;
        }

        public xj w(int i) {
            this.g = i;
            return this;
        }

        public xj xj(int i) {
            this.y = i;
            return this;
        }

        public xj xj(int... iArr) {
            this.d = iArr;
            return this;
        }

        public xj xj(TTCustomController tTCustomController) {
            this.p = tTCustomController;
            return this;
        }

        public xj xj(IMediationConfig iMediationConfig) {
            this.zg = iMediationConfig;
            return this;
        }

        public xj xj(String str, Object obj) {
            if (this.e == null) {
                this.e = new HashMap();
            }
            this.e.put(str, obj);
            return this;
        }
    }

    public CSJConfig(xj xjVar) {
        this.w = false;
        this.y = 0;
        this.c = true;
        this.f = false;
        this.tf = false;
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w;
        this.u = xjVar.u;
        this.kd = xjVar.kd;
        this.y = xjVar.y;
        this.c = xjVar.c;
        this.f = xjVar.f;
        this.d = xjVar.d;
        this.tf = xjVar.tf;
        this.f10265pl = xjVar.p;
        this.g = xjVar.f10266pl;
        this.qt = xjVar.am;
        this.am = xjVar.g;
        this.zg = xjVar.qt;
        this.e = xjVar.zg;
        this.p = xjVar.e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.qt;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.f10265pl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.p;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.am;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.zg;
    }

    public void setAgeGroup(int i) {
        this.qt = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.c = z;
    }

    public void setAppId(String str) {
        this.xj = str;
    }

    public void setAppName(String str) {
        this.hf = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.f10265pl = tTCustomController;
    }

    public void setData(String str) {
        this.kd = str;
    }

    public void setDebug(boolean z) {
        this.f = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.d = iArr;
    }

    public void setKeywords(String str) {
        this.u = str;
    }

    public void setPaid(boolean z) {
        this.w = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.tf = z;
    }

    public void setThemeStatus(int i) {
        this.g = i;
    }

    public void setTitleBarTheme(int i) {
        this.y = i;
    }
}
