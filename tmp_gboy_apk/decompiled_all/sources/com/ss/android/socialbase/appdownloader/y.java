package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.am;
import com.ss.android.socialbase.downloader.depend.dk;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.yo;
import com.ss.android.socialbase.downloader.downloader.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private boolean f13837a;
    private IDownloadListener am;
    private JSONObject aq;
    private int b;
    private int bl;
    private String c;
    private j dc;
    private String dk;
    private int dq;
    private boolean e;
    private String et;
    private dk eu;
    private List<com.ss.android.socialbase.downloader.model.w> f;
    private boolean ff;
    private IDownloadListener g;
    private String gh;
    private String gy;
    private Context hf;
    private yo hl;
    private boolean ht;

    /* renamed from: io, reason: collision with root package name */
    private long f13838io;
    private String j;
    private v jk;
    private String kd;
    private boolean l;
    private boolean lw;
    private com.ss.android.socialbase.appdownloader.w.y n;
    private int[] nb;
    private com.ss.android.socialbase.downloader.notification.xj pz;
    private int q;
    private long qd;
    private String qt;
    private boolean ra;
    private am tj;
    private String tu;
    private List<String> u;
    private com.ss.android.socialbase.downloader.downloader.f v;
    private boolean vm;
    private String w;
    private boolean wn;
    private boolean x;
    private Activity xj;
    private String y;
    private com.ss.android.socialbase.downloader.downloader.c yo;
    private IDownloadFileUriProvider yy;
    private boolean z;
    private boolean d = true;
    private boolean tf = false;
    private boolean p = true;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f13839pl = false;
    private String zg = AdBaseConstants.MIME_APK;
    private int ai = 5;
    private boolean en = true;
    private EnqueueType wo = EnqueueType.ENQUEUE_NONE;
    private int r = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
    private boolean ws = true;
    private List<g> s = new ArrayList();
    private boolean wa = true;
    private boolean op = true;

    public y(Context context, String str) {
        this.hf = context.getApplicationContext();
        this.w = str;
    }

    public boolean a() {
        return this.vm;
    }

    public boolean ai() {
        return this.l;
    }

    public com.ss.android.socialbase.downloader.notification.xj am() {
        return this.pz;
    }

    public long aq() {
        return this.qd;
    }

    public String b() {
        return this.y;
    }

    public boolean bl() {
        return this.wa;
    }

    public boolean c() {
        return this.p;
    }

    public IDownloadListener d() {
        return this.g;
    }

    public boolean dc() {
        return this.wn;
    }

    public int dk() {
        return this.q;
    }

    public int[] dq() {
        return this.nb;
    }

    public boolean e() {
        return this.ht;
    }

    public boolean en() {
        return this.ff;
    }

    public boolean et() {
        return this.z;
    }

    public am eu() {
        return this.tj;
    }

    public boolean f() {
        return this.f13839pl;
    }

    public boolean ff() {
        return this.ws;
    }

    public boolean g() {
        return this.e;
    }

    public Activity getActivity() {
        return this.xj;
    }

    public Context getContext() {
        return this.hf;
    }

    public yo gh() {
        return this.hl;
    }

    public String hf() {
        return this.kd;
    }

    public List<g> hl() {
        return this.s;
    }

    public long ht() {
        return this.f13838io;
    }

    public String io() {
        return this.j;
    }

    public int j() {
        return this.b;
    }

    public String jk() {
        return this.dk;
    }

    public boolean kd() {
        return this.d;
    }

    public boolean l() {
        return this.f13837a;
    }

    public String lw() {
        return this.tu;
    }

    public IDownloadFileUriProvider n() {
        return this.yy;
    }

    public JSONObject op() {
        return this.aq;
    }

    public String p() {
        return this.qt;
    }

    public String pl() {
        return this.zg;
    }

    public String pz() {
        return this.et;
    }

    public v q() {
        return this.jk;
    }

    public boolean qd() {
        return this.lw;
    }

    public com.ss.android.socialbase.downloader.downloader.f qt() {
        return this.v;
    }

    public boolean r() {
        return this.x;
    }

    public int ra() {
        return this.ai;
    }

    public String s() {
        return this.gy;
    }

    public IDownloadListener tf() {
        return this.am;
    }

    public com.ss.android.socialbase.appdownloader.w.y tj() {
        return this.n;
    }

    public boolean tu() {
        return this.op;
    }

    public List<com.ss.android.socialbase.downloader.model.w> u() {
        return this.f;
    }

    public int v() {
        return this.bl;
    }

    public String vm() {
        return this.gh;
    }

    public String w() {
        return this.c;
    }

    public List<String> wa() {
        return this.u;
    }

    public int wn() {
        return this.dq;
    }

    public EnqueueType wo() {
        return this.wo;
    }

    public dk ws() {
        return this.eu;
    }

    public boolean x() {
        return this.en;
    }

    public String xj() {
        return this.w;
    }

    public boolean y() {
        return this.tf;
    }

    public boolean yo() {
        return this.ra;
    }

    public j yy() {
        return this.dc;
    }

    public int z() {
        return this.r;
    }

    public com.ss.android.socialbase.downloader.downloader.c zg() {
        return this.yo;
    }

    public y am(boolean z) {
        this.x = z;
        return this;
    }

    public y c(String str) {
        this.dk = str;
        return this;
    }

    public y d(String str) {
        this.j = str;
        return this;
    }

    public y f(String str) {
        this.et = str;
        return this;
    }

    public y g(boolean z) {
        this.ws = z;
        return this;
    }

    public y hf(String str) {
        this.y = str;
        return this;
    }

    public y kd(String str) {
        this.qt = str;
        return this;
    }

    public y p(boolean z) {
        this.ff = z;
        return this;
    }

    public y pl(boolean z) {
        this.f13837a = z;
        return this;
    }

    public y qt(boolean z) {
        this.lw = z;
        return this;
    }

    public y tf(boolean z) {
        this.l = z;
        return this;
    }

    public y u(String str) {
        this.gh = str;
        return this;
    }

    public y w(String str) {
        this.c = str;
        return this;
    }

    public void xj(int i) {
        this.bl = i;
    }

    public y y(String str) {
        this.zg = str;
        return this;
    }

    public y zg(boolean z) {
        this.wa = z;
        return this;
    }

    public y c(boolean z) {
        this.z = z;
        return this;
    }

    public y d(boolean z) {
        this.en = z;
        return this;
    }

    public y f(boolean z) {
        this.vm = z;
        return this;
    }

    public y hf(boolean z) {
        this.tf = z;
        return this;
    }

    public y kd(boolean z) {
        this.ht = z;
        return this;
    }

    public y p(String str) {
        this.tu = str;
        return this;
    }

    public y tf(String str) {
        this.gy = str;
        return this;
    }

    public y u(boolean z) {
        this.e = z;
        return this;
    }

    public y w(boolean z) {
        this.f13839pl = z;
        return this;
    }

    public y xj(String str) {
        this.kd = str;
        return this;
    }

    public y y(boolean z) {
        this.ra = z;
        return this;
    }

    public y hf(int i) {
        this.ai = i;
        return this;
    }

    public y kd(int i) {
        this.b = i;
        return this;
    }

    public y u(int i) {
        this.r = i;
        return this;
    }

    public y w(int i) {
        this.q = i;
        return this;
    }

    public y xj(List<com.ss.android.socialbase.downloader.model.w> list) {
        this.f = list;
        return this;
    }

    public y y(int i) {
        this.dq = i;
        return this;
    }

    public y hf(List<String> list) {
        this.u = list;
        return this;
    }

    public y xj(boolean z) {
        this.d = z;
        return this;
    }

    public y xj(IDownloadListener iDownloadListener) {
        this.g = iDownloadListener;
        return this;
    }

    public y xj(long j) {
        this.f13838io = j;
        return this;
    }

    public y xj(EnqueueType enqueueType) {
        this.wo = enqueueType;
        return this;
    }

    public y xj(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.yy = iDownloadFileUriProvider;
        return this;
    }

    public y xj(yo yoVar) {
        this.hl = yoVar;
        return this;
    }

    public y xj(JSONObject jSONObject) {
        this.aq = jSONObject;
        return this;
    }

    public y xj(g gVar) {
        synchronized (this.s) {
            if (gVar != null) {
                try {
                    if (!this.s.contains(gVar)) {
                        this.s.add(gVar);
                        return this;
                    }
                } finally {
                }
            }
            return this;
        }
    }
}
