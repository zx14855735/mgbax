package com.ss.android.downloadad.api.xj;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.pl;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements xj {

    /* renamed from: a, reason: collision with root package name */
    private String f13827a;
    private long ai;
    private int am;
    private boolean aq;
    private boolean b;
    private boolean bl;
    private long c;
    private boolean cy;
    private int d;
    private long dc;
    private int dk;
    private String dq;
    private int e;
    private int en;
    private boolean et;
    private String eu;
    private String f;
    private boolean ff;
    private String g;
    private transient boolean gh;
    private boolean gj;
    private boolean gy;
    protected boolean hf;

    @AdBaseConstants.FunnelType
    private int hl;
    private long ht;

    /* renamed from: io, reason: collision with root package name */
    private int f13828io;
    private int j;
    private String jk;
    public final AtomicBoolean kd;
    private String l;
    private boolean lw;
    private boolean n;
    private boolean nb;
    private boolean op;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f13829pl;
    private boolean pz;
    private long q;
    private boolean qd;
    private int qt;
    private boolean r;
    private JSONObject ra;
    private long s;
    private boolean ss;
    private String tf;
    private boolean tj;
    private long tu;
    public final AtomicBoolean u;
    private String v;
    private long vl;
    private long vm;
    public final AtomicBoolean w;
    private long wa;
    private boolean wn;
    private boolean wo;
    private String ws;
    private int x;
    protected boolean xj;
    private String xv;
    private long y;
    private String yo;
    private int yy;
    private long z;
    private int zg;

    private hf() {
        this.d = 1;
        this.pz = true;
        this.et = false;
        this.f13828io = 0;
        this.x = 0;
        this.ff = false;
        this.wo = false;
        this.r = true;
        this.b = true;
        this.xj = true;
        this.hf = true;
        this.w = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.kd = new AtomicBoolean(false);
        this.hl = 1;
        this.wn = true;
        this.wa = -1L;
    }

    public int a() {
        return this.e;
    }

    public long ai() {
        long j = this.ai;
        return j == 0 ? this.ht : j;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public List<String> am() {
        return null;
    }

    public boolean aq() {
        return this.ff;
    }

    public boolean b() {
        return this.et;
    }

    public boolean bl() {
        return this.nb;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public JSONObject c() {
        return this.ra;
    }

    public AdDownloadEventConfig cy() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.ws).setRefer(this.eu).setIsEnableV3Event(this.tj).build();
    }

    public void d(int i) {
        this.hl = i;
    }

    public long dc() {
        return this.vm;
    }

    public int dk() {
        return this.f13828io;
    }

    public boolean dq() {
        return this.gh;
    }

    public void e(boolean z) {
        this.aq = z;
    }

    public String en() {
        return this.l;
    }

    public synchronized void et() {
        this.f13828io++;
    }

    public String eu() {
        return this.v;
    }

    public void f(int i) {
        this.yy = i;
    }

    public long ff() {
        return this.ht;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public boolean g() {
        return this.tj;
    }

    public boolean gh() {
        return this.gj;
    }

    public AdDownloadModel gj() {
        return new AdDownloadModel.Builder().setAdId(this.y).setExtraValue(this.c).setLogExtra(this.f).setPackageName(this.tf).setExtra(this.ra).setIsAd(this.pz).setVersionCode(this.e).setVersionName(this.yo).setDownloadUrl(this.p).setModelType(this.am).setMimeType(this.f13827a).setAppName(this.v).setAppIcon(this.jk).setTaskKey(this.xv).setDeepLink(new DeepLink(this.f13829pl, this.g, null)).build();
    }

    public String gy() {
        return this.xv;
    }

    public void hf(int i) {
        this.x = i;
    }

    public boolean hl() {
        return this.n;
    }

    public void ht(boolean z) {
        this.cy = z;
    }

    public int io() {
        return this.x;
    }

    public int j() {
        return this.en;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public int jk() {
        return -1;
    }

    public void kd(long j) {
        this.c = j;
    }

    public int l() {
        return this.d;
    }

    public boolean lw() {
        return this.gy;
    }

    public String n() {
        return this.dq;
    }

    public long nb() {
        return this.vl;
    }

    public boolean op() {
        return this.cy;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public JSONObject p() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public long pl() {
        return this.c;
    }

    public void pz(boolean z) {
        this.hf = z;
    }

    public long q() {
        return this.q;
    }

    public boolean qd() {
        return this.op;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public Object qt() {
        return null;
    }

    public int r() {
        return this.yy;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public DownloadController ra() {
        return xv();
    }

    public boolean s() {
        return this.wo;
    }

    public JSONObject ss() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.y);
            jSONObject.put("mExtValue", this.c);
            jSONObject.put("mLogExtra", this.f);
            jSONObject.put("mDownloadStatus", this.d);
            jSONObject.put("mPackageName", this.tf);
            jSONObject.put("mIsAd", this.pz);
            jSONObject.put("mTimeStamp", this.ht);
            jSONObject.put("mExtras", this.ra);
            jSONObject.put("mVersionCode", this.e);
            jSONObject.put("mVersionName", this.yo);
            jSONObject.put("mDownloadId", this.dk);
            jSONObject.put("mIsV3Event", this.tj);
            jSONObject.put("mScene", this.yy);
            jSONObject.put("mEventTag", this.ws);
            jSONObject.put("mEventRefer", this.eu);
            jSONObject.put("mDownloadUrl", this.p);
            jSONObject.put("mEnableBackDialog", this.et);
            jSONObject.put("hasSendInstallFinish", this.w.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.u.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.kd.get());
            jSONObject.put("mLastFailedErrCode", this.en);
            jSONObject.put("mLastFailedErrMsg", this.l);
            jSONObject.put("mOpenUrl", this.f13829pl);
            jSONObject.put("mLinkMode", this.qt);
            jSONObject.put("mDownloadMode", this.zg);
            jSONObject.put("mModelType", this.am);
            jSONObject.put("mAppName", this.v);
            jSONObject.put("mAppIcon", this.jk);
            jSONObject.put("mDownloadFailedTimes", this.f13828io);
            long j = this.ai;
            if (j == 0) {
                j = this.ht;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.x);
            jSONObject.put("mJumpInstallTime", this.q);
            jSONObject.put("mCancelInstallTime", this.z);
            jSONObject.put("mLastFailedResumeCount", this.j);
            jSONObject.put("mIsUpdateDownload", this.ff);
            jSONObject.put("mOriginMimeType", this.f13827a);
            jSONObject.put("mIsPatchApplyHandled", this.wo);
            jSONObject.put("downloadFinishReason", this.dq);
            jSONObject.put("clickDownloadTime", this.vm);
            jSONObject.put("clickDownloadSize", this.dc);
            jSONObject.put("installAfterCleanSpace", this.n);
            jSONObject.put("funnelType", this.hl);
            jSONObject.put("webUrl", this.g);
            jSONObject.put("enableShowComplianceDialog", this.wn);
            jSONObject.put("isAutoDownloadOnCardShow", this.aq);
            jSONObject.put("enable_new_activity", this.r ? 1 : 0);
            jSONObject.put("enable_pause", this.b ? 1 : 0);
            jSONObject.put("enable_ah", this.xj ? 1 : 0);
            jSONObject.put("enable_am", this.hf ? 1 : 0);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.cy));
            jSONObject.put("task_key", this.xv);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.vl));
            jSONObject.putOpt("download_pause_timestamp", Long.valueOf(this.tu));
            jSONObject.putOpt("download_finish_timestamp", Long.valueOf(this.s));
            return jSONObject;
        } catch (Exception e) {
            pl.jk().xj(e, "NativeDownloadModel toJson");
            return jSONObject;
        }
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String tf() {
        return this.ws;
    }

    public int tj() {
        return this.qt;
    }

    public String tu() {
        return this.f13827a;
    }

    public void u(int i) {
        this.en = i;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public int v() {
        return this.dk;
    }

    public boolean vm() {
        return this.lw;
    }

    public void w(long j) {
        this.z = j;
    }

    public boolean wa() {
        return this.ss;
    }

    public long wn() {
        return this.dc;
    }

    public String wo() {
        return this.yo;
    }

    public long ws() {
        return this.wa;
    }

    public synchronized void x() {
        this.x++;
    }

    public void xj(int i) {
        this.f13828io = i;
    }

    public AdDownloadController xv() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.et).setLinkMode(this.qt).setDownloadMode(this.zg).setEnableShowComplianceDialog(this.wn).setEnableAH(this.xj).setEnableAM(this.hf).build();
    }

    public void y(long j) {
        if (j > 0) {
            this.ht = j;
        }
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public JSONObject yo() {
        return null;
    }

    public boolean yy() {
        return this.bl;
    }

    public int z() {
        return this.j;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public JSONObject zg() {
        return null;
    }

    public void am(boolean z) {
        this.ss = z;
    }

    public void c(int i) {
        this.dk = i;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String d() {
        return this.eu;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public boolean e() {
        return this.r;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public int f() {
        return this.hl;
    }

    public void g(String str) {
        this.f13827a = str;
    }

    public void hf(long j) {
        this.q = j;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public DownloadEventConfig ht() {
        return cy();
    }

    public void jk(boolean z) {
        this.xj = z;
    }

    public void kd(int i) {
        this.d = i;
    }

    public void p(String str) {
        this.jk = str;
    }

    public void pl(int i) {
        this.am = i;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public DownloadModel pz() {
        return gj();
    }

    public void qt(boolean z) {
        this.gj = z;
    }

    public void tf(String str) {
        this.v = str;
    }

    public void u(long j) {
        this.y = j;
    }

    public void v(boolean z) {
        this.b = z;
    }

    public void w(int i) {
        this.j = i;
    }

    public void xj(long j) {
        this.ai = j;
    }

    public void y(int i) {
        this.e = i;
    }

    public void yo(boolean z) {
        this.r = z;
    }

    public void zg(boolean z) {
        this.wn = z;
    }

    public void am(String str) {
        this.xv = str;
    }

    public void c(String str) {
        this.eu = str;
    }

    public void d(String str) {
        this.f13829pl = str;
    }

    public void f(String str) {
        this.p = str;
    }

    public void g(boolean z) {
        this.gy = z;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public long hf() {
        return this.y;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String kd() {
        return this.tf;
    }

    public void p(int i) {
        this.zg = i;
    }

    public void pl(String str) {
        this.dq = str;
    }

    public void tf(int i) {
        this.qt = i;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String u() {
        return this.f;
    }

    public void w(String str) {
        this.f = str;
    }

    public void xj(String str) {
        this.l = str;
    }

    public void y(String str) {
        this.ws = str;
    }

    public void c(long j) {
        this.wa = j;
    }

    public void d(long j) {
        this.dc = j;
    }

    public void f(long j) {
        this.vm = j;
    }

    public void hf(String str) {
        this.tf = str;
    }

    public void kd(String str) {
        this.g = str;
    }

    public void p(boolean z) {
        this.op = z;
    }

    public void pl(boolean z) {
        this.nb = z;
    }

    public void tf(boolean z) {
        this.gh = z;
    }

    public void u(String str) {
        this.yo = str;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public boolean w() {
        return this.pz;
    }

    public void xj(boolean z) {
        this.pz = z;
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String y() {
        return this.f13829pl;
    }

    public void c(boolean z) {
        this.lw = z;
    }

    public void d(boolean z) {
        this.wo = z;
    }

    public void f(boolean z) {
        this.ff = z;
    }

    public void hf(boolean z) {
        this.tj = z;
    }

    public void kd(boolean z) {
        this.bl = z;
    }

    public void p(long j) {
        this.tu = j;
    }

    public void pl(long j) {
        this.s = j;
    }

    public void tf(long j) {
        this.vl = j;
    }

    public void u(boolean z) {
        this.qd = z;
    }

    public void w(boolean z) {
        this.et = z;
    }

    public void xj(JSONObject jSONObject) {
        this.ra = jSONObject;
    }

    public void y(boolean z) {
        this.n = z;
    }

    public static hf hf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hf hfVar = new hf();
        try {
            hfVar.u(com.ss.android.download.api.w.hf.xj(jSONObject, "mId"));
            hfVar.kd(com.ss.android.download.api.w.hf.xj(jSONObject, "mExtValue"));
            hfVar.w(jSONObject.optString("mLogExtra"));
            hfVar.kd(jSONObject.optInt("mDownloadStatus"));
            hfVar.hf(jSONObject.optString("mPackageName"));
            boolean z = true;
            hfVar.xj(jSONObject.optBoolean("mIsAd", true));
            hfVar.y(com.ss.android.download.api.w.hf.xj(jSONObject, "mTimeStamp"));
            hfVar.y(jSONObject.optInt("mVersionCode"));
            hfVar.u(jSONObject.optString("mVersionName"));
            hfVar.c(jSONObject.optInt("mDownloadId"));
            hfVar.hf(jSONObject.optBoolean("mIsV3Event"));
            hfVar.f(jSONObject.optInt("mScene"));
            hfVar.y(jSONObject.optString("mEventTag"));
            hfVar.c(jSONObject.optString("mEventRefer"));
            hfVar.f(jSONObject.optString("mDownloadUrl"));
            hfVar.w(jSONObject.optBoolean("mEnableBackDialog"));
            hfVar.w.set(jSONObject.optBoolean("hasSendInstallFinish"));
            hfVar.u.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            hfVar.kd.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            hfVar.u(jSONObject.optInt("mLastFailedErrCode"));
            hfVar.xj(jSONObject.optString("mLastFailedErrMsg"));
            hfVar.d(jSONObject.optString("mOpenUrl"));
            hfVar.tf(jSONObject.optInt("mLinkMode"));
            hfVar.p(jSONObject.optInt("mDownloadMode"));
            hfVar.pl(jSONObject.optInt("mModelType"));
            hfVar.tf(jSONObject.optString("mAppName"));
            hfVar.p(jSONObject.optString("mAppIcon"));
            hfVar.xj(jSONObject.optInt("mDownloadFailedTimes", 0));
            hfVar.xj(com.ss.android.download.api.w.hf.xj(jSONObject, "mRecentDownloadResumeTime"));
            hfVar.hf(jSONObject.optInt("mClickPauseTimes"));
            hfVar.hf(com.ss.android.download.api.w.hf.xj(jSONObject, "mJumpInstallTime"));
            hfVar.w(com.ss.android.download.api.w.hf.xj(jSONObject, "mCancelInstallTime"));
            hfVar.w(jSONObject.optInt("mLastFailedResumeCount"));
            hfVar.pl(jSONObject.optString("downloadFinishReason"));
            hfVar.d(jSONObject.optLong("clickDownloadSize"));
            hfVar.f(jSONObject.optLong("clickDownloadTime"));
            hfVar.f(jSONObject.optBoolean("mIsUpdateDownload"));
            hfVar.g(jSONObject.optString("mOriginMimeType"));
            hfVar.d(jSONObject.optBoolean("mIsPatchApplyHandled"));
            hfVar.y(jSONObject.optBoolean("installAfterCleanSpace"));
            hfVar.d(jSONObject.optInt("funnelType", 1));
            hfVar.kd(jSONObject.optString("webUrl"));
            hfVar.zg(jSONObject.optBoolean("enableShowComplianceDialog", true));
            hfVar.e(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            hfVar.yo(jSONObject.optInt("enable_new_activity", 1) == 1);
            hfVar.v(jSONObject.optInt("enable_pause", 1) == 1);
            hfVar.jk(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            hfVar.pz(z);
            hfVar.xj(jSONObject.optJSONObject("mExtras"));
            hfVar.ht(jSONObject.optBoolean("intent_jump_browser_success"));
            hfVar.am(jSONObject.optString("task_key"));
            hfVar.tf(jSONObject.optLong("market_install_finish_check_start_timestamp"));
            hfVar.p(jSONObject.optLong("download_pause_timestamp", 0L));
            hfVar.pl(jSONObject.optLong("download_finish_timestamp", 0L));
            return hfVar;
        } catch (Exception e) {
            pl.jk().xj(e, "NativeDownloadModel fromJson");
            return hfVar;
        }
    }

    @Override // com.ss.android.downloadad.api.xj.xj
    public String xj() {
        return this.p;
    }

    public hf(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public hf(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.d = 1;
        this.pz = true;
        this.et = false;
        this.f13828io = 0;
        this.x = 0;
        this.ff = false;
        this.wo = false;
        this.r = true;
        this.b = true;
        this.xj = true;
        this.hf = true;
        this.w = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.kd = new AtomicBoolean(false);
        this.hl = 1;
        this.wn = true;
        this.wa = -1L;
        this.y = downloadModel.getId();
        this.c = downloadModel.getExtraValue();
        this.f = downloadModel.getLogExtra();
        this.tf = downloadModel.getPackageName();
        this.ra = downloadModel.getExtra();
        this.pz = downloadModel.isAd();
        this.e = downloadModel.getVersionCode();
        this.yo = downloadModel.getVersionName();
        this.p = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.f13829pl = downloadModel.getDeepLink().getOpenUrl();
            this.g = downloadModel.getDeepLink().getWebUrl();
        }
        this.am = downloadModel.getModelType();
        this.v = downloadModel.getName();
        this.jk = downloadModel.getAppIcon();
        this.f13827a = downloadModel.getMimeType();
        this.ws = downloadEventConfig.getClickButtonTag();
        this.eu = downloadEventConfig.getRefer();
        this.tj = downloadEventConfig.isEnableV3Event();
        this.et = downloadController.isEnableBackDialog();
        this.qt = downloadController.getLinkMode();
        this.zg = downloadController.getDownloadMode();
        this.wn = downloadController.enableShowComplianceDialog();
        this.aq = downloadController.isAutoDownloadOnCardShow();
        this.r = downloadController.enableNewActivity();
        this.xj = downloadController.enableAH();
        this.hf = downloadController.enableAM();
        this.dk = i;
        long currentTimeMillis = System.currentTimeMillis();
        this.ht = currentTimeMillis;
        this.ai = currentTimeMillis;
        this.wo = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.xv = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
