package com.ss.android.downloadlib.addownload.hf;

import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd implements com.ss.android.downloadad.api.xj.xj {
    public DownloadModel hf;
    public com.ss.android.downloadad.api.xj.hf kd;
    public DownloadController u;
    public DownloadEventConfig w;
    public long xj;

    public kd() {
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public List<String> am() {
        return this.hf.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public JSONObject c() {
        return this.hf.getExtra();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String d() {
        return this.w.getRefer();
    }

    public boolean dk() {
        DownloadModel downloadModel;
        if (this.xj == 0 || (downloadModel = this.hf) == null || this.w == null || this.u == null) {
            return true;
        }
        return downloadModel.isAd() && this.xj <= 0;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public boolean e() {
        return this.u.enableNewActivity();
    }

    public boolean et() {
        if (dk()) {
            return false;
        }
        if (!this.hf.isAd()) {
            return this.hf instanceof AdDownloadModel;
        }
        DownloadModel downloadModel = this.hf;
        return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.w instanceof AdDownloadEventConfig) && (this.u instanceof AdDownloadController);
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public int f() {
        if (this.u.getDownloadMode() == 2) {
            return 2;
        }
        return this.hf.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public boolean g() {
        return this.w.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public long hf() {
        return this.hf.getId();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public DownloadEventConfig ht() {
        return this.w;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public int jk() {
        return this.w.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String kd() {
        return this.hf.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public JSONObject p() {
        return this.w.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public long pl() {
        return this.hf.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public DownloadModel pz() {
        return this.hf;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public Object qt() {
        return this.w.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public DownloadController ra() {
        return this.u;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String tf() {
        return this.w.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String u() {
        return this.hf.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public int v() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public boolean w() {
        return this.hf.isAd();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String xj() {
        return this.hf.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String y() {
        if (this.hf.getDeepLink() != null) {
            return this.hf.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public JSONObject yo() {
        return this.hf.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public JSONObject zg() {
        return this.w.getExtraJson();
    }

    public kd(long j, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this.xj = j;
        this.hf = downloadModel;
        this.w = downloadEventConfig;
        this.u = downloadController;
    }
}
