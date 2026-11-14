package com.bytedance.sdk.openadsdk.core.video.xj;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.tu;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.hf;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.y;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.x.d;
import com.bytedance.sdk.openadsdk.x.tf;
import com.bytedance.sdk.openadsdk.y.w.e;
import com.sigmob.sdk.base.views.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements w, ai.xj, xj.InterfaceC0173xj, hf {
    protected WeakReference<Context> d;
    private long et;
    protected SurfaceHolder hf;
    protected u ht;

    /* renamed from: io, reason: collision with root package name */
    private long f10452io;
    protected y kd;
    protected List<Runnable> p;
    protected InterfaceC0196xj ra;
    protected com.bykv.vk.openvk.component.video.api.xj u;
    protected SurfaceTexture w;
    protected ws y;
    protected long zg;
    protected final ai xj = new ai(Looper.getMainLooper(), this);
    protected long c = 0;
    protected long f = 0;
    protected boolean tf = false;

    /* renamed from: pl, reason: collision with root package name */
    protected boolean f10453pl = true;
    protected long g = 0;
    protected boolean am = false;
    protected boolean qt = false;
    protected boolean e = false;
    protected volatile boolean yo = false;
    protected boolean v = false;
    protected boolean jk = false;
    public com.bytedance.sdk.openadsdk.y.hf.xj pz = new com.bytedance.sdk.openadsdk.y.hf.xj();
    protected Runnable dk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xj.xj.1
        @Override // java.lang.Runnable
        public void run() {
            pl.xj("BaseController", "resumeVideo: run ", Boolean.valueOf(xj.this.tf));
            xj.this.wo();
        }
    };
    private final AtomicBoolean x = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.xj.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0196xj {
        void xj(long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk() {
        Iterator it = new ArrayList(this.p).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.p.clear();
    }

    private boolean ra() {
        y yVar = this.kd;
        if (yVar == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.renderview.hf e = yVar.e();
        return (e instanceof SSRenderTextureView) || (e instanceof UpieVideoView);
    }

    public void a() {
        pl.xj("BaseController", "execPendingActions: before ");
        List<Runnable> list = this.p;
        if (list == null || list.isEmpty() || this.yo) {
            return;
        }
        pl.xj("BaseController", "execPendingActions:  exec");
        f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xj.xj.2
            @Override // java.lang.Runnable
            public void run() {
                xj.this.dk();
            }
        });
    }

    public boolean ai() {
        WeakReference<Context> weakReference = this.d;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public long am() {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar == null) {
            return 0L;
        }
        return xjVar.yo();
    }

    public boolean b() {
        return this.f10453pl;
    }

    public void d(boolean z) {
        this.jk = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public com.bykv.vk.openvk.component.video.api.xj e() {
        return this.u;
    }

    public int en() {
        int i = tu.xj(this.y) ? 3 : 0;
        if (l()) {
            return 3;
        }
        return i;
    }

    public void eu() {
        e.xj xjVar = new e.xj();
        long am = am();
        xjVar.xj(kd(am));
        xjVar.w(am);
        xjVar.hf(pl());
        u hf = com.bytedance.sdk.openadsdk.y.hf.u.hf(this.kd);
        if (hf != null) {
            hf.xj("EXTRA_PLAY_ACTION", n());
        }
        hf(yo(), xjVar);
    }

    public void f(boolean z) {
        this.yo = z;
    }

    public long ff() {
        return this.et;
    }

    public boolean hf(int i) {
        return i == 6 || i == 8 || i == 9;
    }

    public void io() {
        if (this.u == null) {
            return;
        }
        if (ra()) {
            SurfaceTexture surfaceTexture = this.w;
            if (surfaceTexture == null || surfaceTexture == this.u.f()) {
                return;
            }
            this.u.xj(this.w);
            return;
        }
        SurfaceHolder surfaceHolder = this.hf;
        if (surfaceHolder == null || surfaceHolder == this.u.c()) {
            return;
        }
        this.u.xj(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.hf.xj.InterfaceC0173xj
    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj j() {
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
        xjVar.c = this.c;
        xjVar.xj = jk();
        xjVar.f = v();
        xjVar.u = pz();
        return xjVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean jk() {
        return this.v;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean kd() {
        return false;
    }

    public boolean l() {
        return this.et > 0;
    }

    public Map<String, Object> n() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public long p() {
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public long pl() {
        if (e() == null) {
            return 0L;
        }
        return e().zg();
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.hf.xj.InterfaceC0173xj
    public boolean q() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public y yo() {
        return this.kd;
    }

    public void tf(boolean z) {
        e.xj xjVar = new e.xj();
        xjVar.hf(true);
        xjVar.w(z);
        u hf = com.bytedance.sdk.openadsdk.y.hf.u.hf(this.kd);
        if (hf != null) {
            hf.xj("EXTRA_PLAY_START", n());
        }
        w(this.kd, xjVar);
    }

    public void tj() {
        if (this.ht == null) {
            return;
        }
        this.pz.w(1);
        this.ht.xj("EXTRA_PLAY_START", n());
        com.bytedance.sdk.openadsdk.y.hf.u.xj(this.y, (com.bykv.vk.openvk.component.video.api.hf.xj) this.kd, this.ht, true);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean u() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean v() {
        return this.e;
    }

    public long w(u uVar) {
        com.bykv.vk.openvk.component.video.api.w.w et;
        if (uVar == null || (et = uVar.et()) == null) {
            return 0L;
        }
        int rh = this.y.rh();
        ws wsVar = this.y;
        if (wsVar != null) {
            int f = wo.f(wsVar);
            if (!hf(rh)) {
                return 0L;
            }
            if ((f != 7 && f != 8) || tu.xj(this.y)) {
                return 0L;
            }
        }
        double c = et.c();
        if (c < 0.0d || c >= et.y()) {
            return 0L;
        }
        long hf = d.xj(uVar.yo()).hf(uVar);
        int zg = et.zg();
        if (zg <= 0 || hf < zg) {
            return 0L;
        }
        long j = (long) (c * 1000.0d);
        this.et = j;
        return j;
    }

    public void wo() {
        this.xj.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.xj.xj.3
            @Override // java.lang.Runnable
            public void run() {
                xj xjVar = xj.this;
                if (xjVar.u != null) {
                    pl.xj("BaseController", "resumeVideo: execResumePlay", Boolean.valueOf(xjVar.tf));
                    xj.this.u.hf();
                }
            }
        });
    }

    public void ws() {
        e.xj xjVar = new e.xj();
        long am = am();
        xjVar.xj(kd(am));
        xjVar.w(am);
        xjVar.hf(pl());
        xjVar.y(g());
        u hf = com.bytedance.sdk.openadsdk.y.hf.u.hf(this.kd);
        if (hf != null) {
            hf.xj("EXTRA_PLAY_ACTION", n());
        }
        com.bytedance.sdk.openadsdk.y.hf.u.u(this.kd, xjVar);
    }

    public boolean x() {
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
    }

    public boolean z() {
        if ((!this.kd.g() || !this.tf) && !tf.xj(this.y) && !com.bytedance.sdk.openadsdk.kd.xj.hf(this.y)) {
            xj("not exec pending");
            return false;
        }
        f(false);
        a();
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public boolean zg() {
        return this.qt;
    }

    private long kd(long j) {
        long p = p();
        return l() ? xj(p, j) : p;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void hf(long j) {
        this.c = j;
        long j2 = this.f;
        if (j2 > j) {
            j = j2;
        }
        this.f = j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void u(long j) {
        this.zg = j;
    }

    public void u(int i) {
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.hf(i);
        }
    }

    public void xj(Runnable runnable) {
        if (runnable == null || this.y == null) {
            return;
        }
        if ((!this.kd.g() || !this.tf) && !tf.xj(this.y) && !com.bytedance.sdk.openadsdk.kd.xj.hf(this.y)) {
            hf(runnable);
        } else {
            runnable.run();
        }
    }

    public void hf(Runnable runnable) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(runnable);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void hf(com.bykv.vk.openvk.component.video.api.u.hf hfVar, SurfaceHolder surfaceHolder) {
        this.tf = false;
        this.hf = null;
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.hf(false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, SurfaceHolder surfaceHolder) {
        this.tf = true;
        this.hf = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar == null) {
            return;
        }
        if (xjVar != null) {
            xjVar.xj(surfaceHolder);
        }
        pl.xj("BaseController", "surfaceCreated: ");
        a();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void hf(com.bykv.vk.openvk.component.video.api.u.hf hfVar, SurfaceTexture surfaceTexture) {
        this.tf = false;
        pl.xj("BaseController", "surfaceTextureDestroyed: ");
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.hf(false);
        }
        this.w = null;
        a();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void w(long j) {
        this.g = j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void w(boolean z) {
        this.v = z;
    }

    public void w(int i) {
        if (this.pz.u(1)) {
            if (!this.f10453pl) {
                i *= 10;
            }
            xj(-900001, i, "only play start", (JSONArray) null);
        }
        JSONArray jSONArray = new JSONArray();
        if (this.pz.xj(1)) {
            return;
        }
        String hf = wo.hf(this.y);
        JSONObject xj = xj(4, hf);
        if (xj != null) {
            jSONArray.put(xj);
        }
        JSONObject xj2 = xj(2, hf);
        if (xj2 != null) {
            jSONArray.put(xj2);
        }
        JSONObject xj3 = xj(8, hf);
        if (xj3 != null) {
            jSONArray.put(xj3);
        }
        JSONObject xj4 = xj(32, hf);
        if (xj4 != null) {
            jSONArray.put(xj4);
        }
        JSONObject xj5 = xj(64, hf);
        if (xj5 != null) {
            jSONArray.put(xj5);
        }
        JSONObject xj6 = xj(r.b.d, hf);
        if (xj6 != null) {
            jSONArray.put(xj6);
        }
        xj(-900002, -701, "lack play start", jSONArray);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.xj
    public void xj(com.bykv.vk.openvk.component.video.api.u.hf hfVar, SurfaceTexture surfaceTexture) {
        this.tf = true;
        this.w = surfaceTexture;
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.xj(surfaceTexture);
            this.u.hf(this.tf);
        }
        pl.xj("BaseController", "surfaceTextureCreated: ");
        a();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void hf(boolean z) {
        this.e = z;
        com.bykv.vk.openvk.component.video.api.xj xjVar = this.u;
        if (xjVar != null) {
            xjVar.xj(z);
        }
    }

    public void hf(com.bykv.vk.openvk.component.video.api.hf.xj xjVar, e.xj xjVar2) {
        this.pz.w(8);
        com.bytedance.sdk.openadsdk.y.hf.u.hf(yo(), xjVar2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w
    public void xj(boolean z) {
        this.f10453pl = z;
        y yVar = this.kd;
        if (yVar != null) {
            yVar.u(z);
        }
    }

    public void hf(long j, long j2) {
        if (!this.x.get() && pz.hf().kr() && (j * 1.0d) / j2 > 0.3d) {
            this.x.set(true);
            com.bytedance.sdk.openadsdk.core.qt.w.kd().xj("videoPercent30", this.y);
        }
    }

    public long xj(long j, long j2) {
        long ff = ff();
        if (!w() && (j == ff || j - ff < 0 || j == 0)) {
            return 0L;
        }
        ws wsVar = this.y;
        if (wsVar == null) {
            return j;
        }
        if (wsVar.mq() > 0 && j2 > this.y.mq() * 1000) {
            if (this.am) {
                long mq = j2 - (this.y.mq() * 1000);
                long j3 = this.f10452io;
                if (j - j3 >= mq) {
                    return j3;
                }
            }
            j2 = this.y.mq();
        }
        long j4 = j - ff;
        long j5 = (j2 * (j4 > 0 ? 0 : 1)) + j4;
        this.f10452io = j5;
        return j5;
    }

    public void w(Map<String, Object> map) {
        e.xj xjVar = new e.xj();
        long am = am();
        xjVar.xj(kd(am));
        xjVar.w(am);
        xjVar.hf(pl());
        u hf = com.bytedance.sdk.openadsdk.y.hf.u.hf(this.kd);
        if (hf != null) {
            hf.xj("EXTRA_PLAY_ACTION", n());
        }
        if (map != null) {
            xjVar.xj(map);
        }
        xj(this.kd, xjVar);
    }

    public void xj(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error", str);
        } catch (JSONException unused) {
        }
        am.xj().xj("video", jSONObject, (Throwable) null);
    }

    public void xj(int i, int i2, String str, JSONArray jSONArray) {
        if (this.d == null) {
            return;
        }
        e.xj xjVar = new e.xj();
        xjVar.hf(pl());
        long am = am();
        xjVar.w(am);
        xjVar.xj(kd(am));
        xjVar.xj(i);
        xjVar.hf(i2);
        xjVar.xj(jSONArray);
        if (this.pz.xj(256)) {
            return;
        }
        this.pz.w(256);
        com.bytedance.sdk.openadsdk.y.hf.u.xj(yo(), xjVar, str, !this.pz.xj(2) ? 1 : 0, this.pz.xj(r.b.d));
    }

    public void w(com.bykv.vk.openvk.component.video.api.hf.xj xjVar, e.xj xjVar2) {
        this.pz.w(2);
        com.bytedance.sdk.openadsdk.y.hf.u.xj(xjVar, xjVar2);
    }

    private JSONObject xj(int i, String str) {
        String str2;
        try {
            if (this.pz.xj(r.b.d)) {
                str2 = "endcard_skip";
            } else if (this.pz.xj(8)) {
                str2 = "feed_continue";
            } else if (this.pz.xj(4)) {
                str2 = "feed_pause";
            } else if (this.pz.xj(2)) {
                str2 = "feed_play";
            } else if (this.pz.xj(64)) {
                str2 = "feed_over";
            } else {
                str2 = this.pz.xj(32) ? "feed_break" : null;
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("tag", str);
                jSONObject.putOpt("label", str2);
                jSONObject.putOpt("time", this.pz.hf(i));
                return jSONObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void xj(com.bykv.vk.openvk.component.video.api.hf.xj xjVar, e.xj xjVar2) {
        this.pz.w(4);
        com.bytedance.sdk.openadsdk.y.hf.u.xj(this.kd, xjVar2, !this.pz.xj(2) ? 1 : 0);
    }

    public void xj(InterfaceC0196xj interfaceC0196xj) {
        this.ra = interfaceC0196xj;
    }
}
