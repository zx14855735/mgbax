package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements DownloadEventConfig {
    private boolean am;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private boolean hf;
    private String kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private Object f13823pl;
    private boolean qt;
    private String tf;
    private String u;
    private String w;
    private String xj;
    private String y;
    private String zg;

    public static final class xj {
        private boolean am;
        private String c;
        private String d;
        private String e;
        private String f;
        private boolean g;
        private boolean hf;
        private String kd;
        private String p;

        /* renamed from: pl, reason: collision with root package name */
        private Object f13824pl;
        private boolean qt;
        private String tf;
        private String u;
        private String w;
        private String xj;
        private String y;
        private String zg;

        public w xj() {
            return new w(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.xj;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.y;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.w;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.kd;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.u;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.f13823pl;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.tf;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.hf;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public w() {
    }

    private w(xj xjVar) {
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
        this.p = xjVar.p;
        this.f13823pl = xjVar.f13824pl;
        this.g = xjVar.g;
        this.am = xjVar.am;
        this.qt = xjVar.qt;
        this.zg = xjVar.zg;
        this.e = xjVar.e;
    }
}
