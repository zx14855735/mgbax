package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import ADYaiT.CtFAbx;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.am.c;
import com.bytedance.sdk.openadsdk.am.f;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am.kd;
import com.bytedance.sdk.openadsdk.core.am.y;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.hf.hf;
import com.bytedance.sdk.openadsdk.core.component.reward.u.d;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj implements ai.xj, kd.hf {
    private static final c.xj yy = new c.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.2
        @Override // com.bytedance.sdk.openadsdk.am.c.xj
        public void xj(String str, String str2, Throwable th) {
            pl.w(str, str2, th);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private boolean f10306a;
    final ai ai;
    private String aq;
    private RewardLpBottomView b;
    private DownloadListener dc;
    private com.bytedance.sdk.openadsdk.core.ugeno.w.w en;
    protected final AtomicBoolean et;
    private com.bytedance.sdk.openadsdk.core.multipro.hf.xj eu;
    private f ff;
    private final com.bytedance.sdk.openadsdk.core.jk.u hl;

    /* renamed from: io, reason: collision with root package name */
    protected final AtomicBoolean f10307io;
    private FrameLayout j;
    private y l;
    private hf.xj n;
    long q;
    private PlayableEndcardFrameLayout r;
    private final xj tj;
    private com.bytedance.sdk.openadsdk.core.jk.hf vm;
    private com.bytedance.sdk.openadsdk.core.hf.hf wn;
    private hf.InterfaceC0144hf wo;
    private final com.bytedance.sdk.openadsdk.core.playable.xj ws;
    protected final AtomicBoolean x;
    private final AtomicBoolean z;

    public interface xj {
        void xj(WebView webView, String str);

        void xj(WebView webView, String str, Bitmap bitmap);
    }

    static {
        mEjiLk();
    }

    public w(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, wsVar, str, i, i2, z);
        this.et = new AtomicBoolean(false);
        this.f10307io = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.z = new AtomicBoolean(false);
        this.ai = new ai(Looper.getMainLooper(), this);
        this.q = 0L;
        this.tj = new xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.xj
            public void xj(WebView webView, String str2) {
                if (w.this.xj.aq() instanceof d) {
                    return;
                }
                w.this.ai.removeMessages(101);
                if (w.this.et.getAndSet(true)) {
                    return;
                }
                if (ht.w(w.this.hf) || w.this.f10306a) {
                    if (w.this.ht()) {
                        w.this.xj(0);
                    } else if (w.this.n != null) {
                        w.this.n.xj();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.xj
            public void xj(WebView webView, String str2, Bitmap bitmap) {
                if (ht.w(w.this.hf)) {
                    if (w.this.hf.py() == 1 || v.p(w.this.hf)) {
                        w.this.ai.sendEmptyMessageDelayed(101, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                    }
                    if (w.this.f10307io.getAndSet(true)) {
                        return;
                    }
                    w.this.q = System.currentTimeMillis();
                    w.this.wo.xj();
                }
            }
        };
        this.hl = new com.bytedance.sdk.openadsdk.core.jk.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.3
            @Override // com.bytedance.sdk.openadsdk.core.jk.u
            public void hf() {
                if (!v.xj(w.this.hf) || v.p(w.this.hf)) {
                    return;
                }
                w.this.xj.xj(1);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jk.u
            public void xj(int i3) {
                w.this.f.d(true);
                if (v.p(w.this.hf)) {
                    w.this.wo.hf();
                }
                w.this.xj.w(i3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.jk.u
            public void xj() {
                if (aq.p(w.this.hf)) {
                    w.this.xj.u(3);
                }
            }
        };
        this.vm = new com.bytedance.sdk.openadsdk.core.jk.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.4
            @Override // com.bytedance.sdk.openadsdk.core.jk.hf
            public void xj(boolean z2, int i3, String str2) {
                if (z2) {
                    w.this.zg = true;
                }
            }
        };
        this.c = abstractEndCardFrameLayout.getPlayableWebView();
        this.j = (FrameLayout) this.xj.findViewById(2114387919);
        this.r = (PlayableEndcardFrameLayout) this.xj.findViewById(2114387675);
        this.b = (RewardLpBottomView) this.xj.findViewById(2114387824);
        this.ws = new com.bytedance.sdk.openadsdk.core.playable.xj(this.w, tTBaseVideoActivity, wsVar, ht.w(this.hf) ? 2 : 1, tTBaseVideoActivity.aq().l(), abstractEndCardFrameLayout.getVideoArea());
        xj();
    }

    private void a() {
        RewardLpBottomView rewardLpBottomView;
        if (!ht.c(this.hf)) {
            this.b = null;
            return;
        }
        if (v.u(this.hf)) {
            this.b = null;
            return;
        }
        if (!v.kd(this.hf)) {
            this.b = null;
        } else {
            if (this.r == null || (rewardLpBottomView = this.b) == null) {
                return;
            }
            rewardLpBottomView.xj(this.hf, this.w);
            this.r.xj(new PlayableEndcardFrameLayout.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.xj
                public void xj() {
                    if (w.this.b != null) {
                        w.this.b.hf();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = w.this.xj;
                    if (tTBaseVideoActivity != null) {
                        tTBaseVideoActivity.d(1);
                    }
                }
            });
        }
    }

    private void b() {
        if (this.xj.dc() == null) {
            return;
        }
        long zg = !this.xj.dc().xj() ? this.xj.dc().zg() : 0L;
        boolean g = this.xj.dc().g();
        if (!(this.xj.aq() instanceof d)) {
            f fVar = this.ff;
            g = fVar != null && fVar.c();
        }
        this.ws.xj(zg, g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff() {
        this.zg = true;
        this.x.set(true);
        this.ai.sendMessage(hf(4));
        TTBaseVideoActivity tTBaseVideoActivity = this.xj;
        if (tTBaseVideoActivity != null) {
            tTBaseVideoActivity.pl(8);
        }
        hf.InterfaceC0144hf interfaceC0144hf = this.wo;
        if (interfaceC0144hf != null) {
            interfaceC0144hf.xj();
        }
    }

    private static /* synthetic */ void mEjiLk() {
        char[] charArray = ":64w>84<w;6 w*1<55w\u001370\u001b+0=><".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Y');
        }
        String str = new String(charArray);
        char[] charArray2 = ":5070-".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void r() {
        this.ai.sendMessage(hf(3));
        hf.xj xjVar = this.n;
        if (xjVar != null) {
            xjVar.xj();
        }
        this.xj.w(0);
    }

    private void wo() {
        this.tf = ht.xj(this.hf);
        float yq = this.hf.yq();
        if (TextUtils.isEmpty(this.tf)) {
            return;
        }
        if (this.v == 1) {
            if (this.tf.contains("?")) {
                this.tf = CtFAbx.B25kr6(new StringBuilder(), this.tf, "&orientation=portrait");
            } else {
                this.tf = CtFAbx.B25kr6(new StringBuilder(), this.tf, "?orientation=portrait");
            }
        }
        if (this.tf.contains("?")) {
            this.tf += "&height=" + this.pz + "&width=" + this.jk + "&aspect_ratio=" + yq;
            return;
        }
        this.tf += "?height=" + this.pz + "&width=" + this.jk + "&aspect_ratio=" + yq;
    }

    public void ai() {
        xj(true);
        f fVar = this.ff;
        if (fVar != null) {
            fVar.hf(true);
        }
        w(true);
        xj(false, true);
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = this.p;
        if (uVar != null) {
            uVar.hf(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void am() {
        super.am();
        y yVar = this.l;
        if (yVar != null) {
            yVar.xj(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public String dk() {
        return "playable";
    }

    public boolean en() {
        return !this.x.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void et() {
        super.et();
        this.ws.w();
        com.bytedance.sdk.openadsdk.core.ugeno.w.w wVar = this.en;
        if (wVar != null) {
            wVar.w();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void g() {
        super.g();
        f fVar = this.ff;
        if (fVar != null) {
            fVar.hf(false);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.w.w wVar = this.en;
        if (wVar != null) {
            wVar.hf();
        }
    }

    public j j() {
        return this.f;
    }

    public void l() {
        if (this.c == null || this.ff != null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.f.zg().yy()) {
            c.xj(yy);
        }
        com.bytedance.sdk.openadsdk.core.pz.w wVar = new com.bytedance.sdk.openadsdk.core.pz.w();
        u uVar = new u(this.hl);
        com.bytedance.sdk.openadsdk.core.pz.kd kdVar = new com.bytedance.sdk.openadsdk.core.pz.kd(this.f);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.hf.ho());
            jSONObject.put("log_extra", this.hf.jf());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        f xj2 = wVar.xj(pz.getContext(), this.c, kdVar, uVar, hashSet, f.xj.LAND_PAGE).kd(this.tf).u(com.bytedance.sdk.openadsdk.core.f.xj.c()).xj(com.bytedance.sdk.openadsdk.core.f.xj.xj()).kd(jSONObject).xj("sdkEdition", com.bytedance.sdk.openadsdk.core.f.xj.w()).hf(com.bytedance.sdk.openadsdk.core.f.xj.kd()).w(com.bytedance.sdk.openadsdk.core.f.xj.u()).xj(10L).hf(10L).w(false).xj(false);
        this.ff = xj2;
        Set<String> tf = xj2.tf();
        if (this.f == null || tf == null || tf.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.ff);
        Iterator<String> it = tf.iterator();
        while (it.hasNext()) {
            this.f.y().xj(it.next(), (com.bytedance.sdk.component.xj.kd<?, ?>) new com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.8
                @Override // com.bytedance.sdk.component.xj.kd
                public JSONObject xj(JSONObject jSONObject2, com.bytedance.sdk.component.xj.y yVar) {
                    try {
                        f fVar = (f) weakReference.get();
                        if (fVar == null) {
                            return null;
                        }
                        return fVar.u(xj(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void pl() {
        super.pl();
        if (this.ff != null && r.u(this.c)) {
            this.ff.hf(true);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.w.w wVar = this.en;
        if (wVar != null) {
            wVar.w();
        }
        y yVar = this.l;
        if (yVar != null) {
            yVar.w();
        }
    }

    public long q() {
        return System.currentTimeMillis() - this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void qt() {
        super.qt();
        f fVar = this.ff;
        if (fVar != null) {
            fVar.l();
        }
        kd kdVar = this.f10308pl;
        if (kdVar != null) {
            kdVar.xj((kd.hf) null);
        }
        this.ws.u();
        com.bytedance.sdk.openadsdk.core.ugeno.w.w wVar = this.en;
        if (wVar != null) {
            wVar.u();
        }
        y yVar = this.l;
        if (yVar != null) {
            yVar.u();
        }
        this.dc = null;
    }

    public void x() {
        SSWebView sSWebView;
        if (this.qt || (sSWebView = this.c) == null || sSWebView.getWebView() == null) {
            return;
        }
        this.c.loadUrl(this.tf);
        this.qt = true;
        f fVar = this.ff;
        if (fVar != null) {
            fVar.y(this.tf);
        }
    }

    public boolean z() {
        j jVar = this.f;
        if (jVar != null) {
            return jVar.tf();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(boolean z, Map<String, Object> map, View view) {
        SSWebView sSWebView = this.c;
        if (sSWebView == null) {
            return;
        }
        kd hf = new kd(this.hf, sSWebView).hf(true);
        this.f10308pl = hf;
        hf.xj(this);
        this.f10308pl.xj(true);
        this.f10308pl.xj(z ? "reward_endcard" : "fullscreen_endcard");
        j jVar = new j(this.xj);
        this.f = jVar;
        jVar.hf(this.c).xj(this.hf).hf(this.hf.ho()).u(this.hf.jf()).w(z ? 7 : 5).xj(this.ra).kd(wo.zg(this.hf)).xj(this.c).hf(tf.xj(this.hf)).xj(this.w).xj(map).xj(this.dk).xj(view).w(this.xj.xj()).xj(this.hl);
        if (!ht.w(this.hf)) {
            this.f.f(true);
        }
        this.f.xj(this.vm);
        a();
        wo();
        l();
    }

    public void kd(boolean z) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        try {
            this.f.c(z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReward", z);
            this.f.xj("isVerifyReward", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void u(boolean z) {
        super.u(z);
        if (!z) {
            this.ws.hf();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.w.w wVar = this.en;
        if (wVar != null) {
            wVar.hf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void y() {
        SSWebView sSWebView = this.c;
        if (sSWebView != null && sSWebView.getVisibility() == 0) {
            this.wo.w().xj(true);
        }
        super.y();
        this.ws.xj();
        f fVar = this.ff;
        if (fVar != null) {
            fVar.hf(false);
        }
        xj(true, false);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar) {
        this.eu = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void xj(boolean z, Map<String, Object> map, View view) {
        if (wo.jk(this.hf) && this.j != null) {
            xj(map, view);
        } else {
            hf(z, map, view);
        }
    }

    public void y(boolean z) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        this.f10306a = z;
    }

    private void xj(final Map<String, Object> map, final View view) {
        y yVar = new y(this.hf);
        this.l = yVar;
        yVar.xj(true);
        this.l.xj();
        this.j.setVisibility(0);
        TTBaseVideoActivity tTBaseVideoActivity = this.xj;
        FrameLayout frameLayout = this.j;
        y yVar2 = this.l;
        ws wsVar = this.hf;
        String str = this.w;
        com.bytedance.sdk.openadsdk.core.ugeno.w.w wVar = new com.bytedance.sdk.openadsdk.core.ugeno.w.w(tTBaseVideoActivity, frameLayout, yVar2, wsVar, str, wo.hf(str), this.eu);
        this.en = wVar;
        wVar.xj();
        this.en.xj(new com.bytedance.sdk.openadsdk.core.ugeno.u.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(View view2) {
                w.this.ff();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(int i) {
                w.this.en = null;
                com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (w.this.j != null) {
                            w.this.j.setVisibility(8);
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        w wVar2 = w.this;
                        wVar2.qt = false;
                        wVar2.hf(wVar2.u, map, view);
                        w wVar3 = w.this;
                        wVar3.hf(wVar3.dc, w.this.wn);
                        w.this.dc = null;
                        w.this.x();
                    }
                });
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void xj(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        this.dc = downloadListener;
        this.wn = hfVar;
        hf(downloadListener, hfVar);
    }

    private void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        RewardLpBottomView rewardLpBottomView;
        if (!ht.c(this.hf) || (rewardLpBottomView = this.b) == null) {
            return;
        }
        rewardLpBottomView.setDownLoadClickListener(hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void xj(int i) {
        super.xj(i);
        b();
    }

    public void xj(hf.InterfaceC0144hf interfaceC0144hf) {
        this.wo = interfaceC0144hf;
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i = message.what;
        if (i == 101) {
            r();
            return;
        }
        if (i != 102) {
            return;
        }
        this.ai.removeMessages(102);
        this.wo.w().xj(true);
        this.xj.dq();
        int i2 = message.arg1;
        if (i2 == 2) {
            hf.xj xjVar = this.n;
            if (xjVar != null) {
                xjVar.xj();
                return;
            }
            return;
        }
        if (i2 == 0 || i2 == 1) {
            ai();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        if (this.c == null) {
            return;
        }
        this.wn = null;
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.xj, this.f, this.hf.ho(), this.f10308pl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (w.this.ff != null && str != null && !str.contains("about:blank")) {
                    w.this.ff.c(str);
                }
                super.onPageFinished(webView, str);
                w.this.tj.xj(webView, str);
                if (w.this.b != null) {
                    w.this.b.xj();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                w.this.x.set(true);
                w.this.tj.xj(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                w.this.e.set(false);
                w.this.yo = this.f;
                w wVar = w.this;
                wVar.g = i;
                wVar.am = str;
                if (wVar.ff != null) {
                    w.this.ff.xj(i, str, str2);
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (w.this.ff != null) {
                    try {
                        w.this.ff.xj(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                if (w.this.tf.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        w.this.e.set(false);
                        w.this.yo = this.f;
                    }
                    if (webResourceResponse != null) {
                        w.this.g = webResourceResponse.getStatusCode();
                        w.this.am = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    ws wsVar = w.this.hf;
                    if (wsVar == null) {
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    if (TextUtils.isEmpty(wsVar.db())) {
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    w.this.kd++;
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable th) {
                    pl.w("PlayableEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                int errorCode;
                CharSequence description;
                if (webResourceRequest.isForMainFrame()) {
                    w.this.e.set(false);
                    w.this.yo = this.f;
                }
                w wVar = w.this;
                errorCode = webResourceError.getErrorCode();
                wVar.g = errorCode;
                w wVar2 = w.this;
                description = webResourceError.getDescription();
                wVar2.am = String.valueOf(description);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.p = uVar;
        this.c.setWebViewClient(uVar);
        this.c.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.f, this.f10308pl));
        xj(this.c);
        this.c.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.c.setDisplayZoomControls(false);
        this.c.setDownloadListener(downloadListener);
        xj(hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.am.kd.hf
    public void xj(String str) {
        if (TextUtils.isEmpty(this.aq)) {
            this.aq = str;
        }
        if (TextUtils.equals(this.aq, str)) {
            return;
        }
        this.aq = str;
        this.xj.d(1);
    }

    public void hf(int i, int i2) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skip_remain_time", i);
            if (this.u) {
                jSONObject.put("reward_remain_time", i2);
            }
            this.f.xj("reward_button_status", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public void xj(hf.xj xjVar) {
        this.n = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void xj(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.am.d dVar = this.d;
        if (dVar != null) {
            dVar.tf();
        }
        if (map == null || !ht.w(this.hf)) {
            return;
        }
        map.put(MediationConstant.EXTRA_DURATION, Long.valueOf(q()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void hf(boolean z) {
        f fVar = this.ff;
        if (fVar != null) {
            fVar.xj(z);
        }
        this.ws.xj(z);
    }

    private Message hf(int i) {
        Message obtain = Message.obtain();
        obtain.what = 102;
        obtain.arg1 = i;
        return obtain;
    }
}
