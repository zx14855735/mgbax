package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.hf.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.hf.y;
import com.bytedance.sdk.openadsdk.core.component.reward.kd.u;
import com.bytedance.sdk.openadsdk.core.component.reward.kd.w;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.u.d;
import com.bytedance.sdk.openadsdk.core.component.reward.u.f;
import com.bytedance.sdk.openadsdk.core.component.reward.u.p;
import com.bytedance.sdk.openadsdk.core.component.reward.u.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.dislike.ui.xj;
import com.bytedance.sdk.openadsdk.core.f.hf;
import com.bytedance.sdk.openadsdk.core.hf.kd;
import com.bytedance.sdk.openadsdk.core.hf.xj.w.w;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.dk;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.j;
import com.bytedance.sdk.openadsdk.core.ra.n;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import com.bytedance.sdk.openadsdk.core.video.hf.xj;
import com.bytedance.sdk.openadsdk.d.xj.hf;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.sigmob.sdk.base.views.r;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class TTBaseVideoActivity extends BaseThemeActivity implements ai.xj, hf {

    /* renamed from: a, reason: collision with root package name */
    y f10297a;
    RewardFullBaseLayout ai;
    protected final AtomicBoolean am;
    protected com.bytedance.sdk.openadsdk.core.playable.hf.hf aq;
    protected xj b;
    private final AtomicBoolean bl;
    public final AtomicBoolean c;
    private int cy;
    protected final AtomicBoolean d;
    protected kd dc;
    protected boolean dk;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj dq;
    protected final AtomicBoolean e;
    com.bytedance.sdk.openadsdk.core.component.reward.hf.kd en;
    protected long et;
    protected w eu;
    protected final AtomicBoolean f;
    com.bytedance.sdk.openadsdk.core.component.reward.hf.xj ff;
    private com.bytedance.sdk.openadsdk.x.xj ft;
    protected final AtomicBoolean g;
    private com.bytedance.sdk.openadsdk.core.hf.hf gh;
    private int gj;
    private xj.InterfaceC0145xj gy;
    private long h;
    protected final ai hf;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.xj hl;
    protected boolean ht;

    /* renamed from: io, reason: collision with root package name */
    protected boolean f10298io;
    AbstractEndCardFrameLayout j;
    protected final AtomicBoolean jk;
    com.bytedance.sdk.openadsdk.core.component.reward.hf.hf l;
    private boolean lw;
    protected String n;
    private float nb;
    private long ne;
    private xj.hf op;
    protected final AtomicBoolean p;

    /* renamed from: pl, reason: collision with root package name */
    protected final AtomicBoolean f10299pl;
    protected final AtomicBoolean pz;
    com.bytedance.sdk.openadsdk.core.component.reward.layout.hf q;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj qd;
    protected final AtomicBoolean qt;
    protected com.bytedance.sdk.openadsdk.core.component.reward.hf.w r;
    protected boolean ra;
    private final xj.InterfaceC0173xj rg;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj s;
    private u se;
    private int ss;
    private AtomicBoolean t;
    protected final AtomicBoolean tf;
    protected int tj;
    protected xj.InterfaceC0194xj tu;
    protected final ConcurrentHashMap<Integer, Boolean> u;
    protected final AtomicBoolean v;
    private hf.xj vl;
    protected int vm;
    protected final AtomicBoolean w;
    private int wa;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u wn;
    com.bytedance.sdk.openadsdk.core.component.reward.hf.u wo;
    protected TTBaseVideoActivity ws;
    protected int x;
    protected final String xj;
    private Double xv;
    protected final ConcurrentHashMap<Integer, Boolean> y;
    protected final AtomicBoolean yo;
    protected String yy;
    com.bytedance.sdk.openadsdk.core.component.reward.layout.kd z;
    protected final AtomicBoolean zg;

    public TTBaseVideoActivity() {
        this.xj = io() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.hf = new ai(Looper.getMainLooper(), this);
        this.w = new AtomicBoolean(false);
        this.u = new ConcurrentHashMap<>();
        this.y = new ConcurrentHashMap<>();
        this.c = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.bl = new AtomicBoolean(false);
        this.tf = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.f10299pl = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.am = new AtomicBoolean(false);
        this.qt = new AtomicBoolean(false);
        this.zg = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.yo = new AtomicBoolean(false);
        this.v = new AtomicBoolean(false);
        this.jk = new AtomicBoolean(false);
        this.pz = new AtomicBoolean(false);
        this.x = -1;
        this.ss = 1;
        this.xv = null;
        this.h = 0L;
        this.tu = new xj.InterfaceC0194xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void hf() {
                TTBaseVideoActivity.this.hf.removeMessages(300);
                TTBaseVideoActivity.this.zg();
                TTBaseVideoActivity.this.xj(false, false);
                TTBaseVideoActivity.this.f10297a.xj(6);
                TTBaseVideoActivity.this.f10297a.d();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void w() {
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u uVar = TTBaseVideoActivity.this.wn;
                if (uVar == null || uVar.xj() == null) {
                    return;
                }
                TTBaseVideoActivity.this.wn.xj().xj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void xj() {
                TTBaseVideoActivity.this.hf.removeMessages(300);
                TTBaseVideoActivity.this.zg();
                if (!TTBaseVideoActivity.this.f10297a.pl()) {
                    if (TTBaseVideoActivity.this.ne()) {
                        y yVar = TTBaseVideoActivity.this.f10297a;
                        yVar.hf(yVar.j());
                    } else {
                        y yVar2 = TTBaseVideoActivity.this.f10297a;
                        yVar2.hf(yVar2.z() + 1000);
                    }
                }
                if (TTBaseVideoActivity.this.b.y() && !TTBaseVideoActivity.this.f10297a.pl()) {
                    TTBaseVideoActivity.this.z.hf(true);
                }
                TTBaseVideoActivity.this.lw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void xj(int i, String str) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (tTBaseVideoActivity.ra) {
                    tTBaseVideoActivity.hf.removeMessages(300);
                    TTBaseVideoActivity.this.g();
                    TTBaseVideoActivity.this.f10297a.xj(5);
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    tTBaseVideoActivity2.hf(tTBaseVideoActivity2.f10297a.hf());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
            public void xj(long j, long j2) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (!tTBaseVideoActivity.ra && tTBaseVideoActivity.f10297a.hf()) {
                    TTBaseVideoActivity.this.f10297a.xj((Map<String, Object>) null);
                }
                boolean z = true;
                if (TTBaseVideoActivity.this.l.l()) {
                    TTBaseVideoActivity.this.f10297a.w(true);
                    return;
                }
                TTBaseVideoActivity.this.hf.removeMessages(300);
                if (j != TTBaseVideoActivity.this.f10297a.z()) {
                    TTBaseVideoActivity.this.zg();
                }
                if (TTBaseVideoActivity.this.f10297a.hf() || j2 == j) {
                    TTBaseVideoActivity.this.f10297a.hf(j);
                    if (TTBaseVideoActivity.this.le()) {
                        TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = tTBaseVideoActivity2.z;
                        String valueOf = String.valueOf(tTBaseVideoActivity2.f10297a.q());
                        int z2 = (int) (TTBaseVideoActivity.this.f10297a.z() / 1000);
                        if (j != j2 && !TTBaseVideoActivity.this.f10297a.l()) {
                            z = false;
                        }
                        kdVar.xj(valueOf, z2, 0, z);
                    }
                    TTBaseVideoActivity.this.w(0);
                    TTBaseVideoActivity.this.yy();
                    TTBaseVideoActivity.this.b.jk();
                }
            }
        };
        this.s = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.12
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public long getActualPlayDuration() {
                return TTBaseVideoActivity.this.b.n().getActualPlayDuration();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public int hf() {
                return TTBaseVideoActivity.this.b.n().hf();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void kd() {
                TTBaseVideoActivity.this.b.n().kd();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void setPauseFromExpressView(boolean z) {
                TTBaseVideoActivity.this.b.n().setPauseFromExpressView(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void u() {
                TTBaseVideoActivity.this.b.n().u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public int w() {
                return TTBaseVideoActivity.this.b.n().w();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void y() {
                TTBaseVideoActivity.this.b.n().y();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void hf(int i) {
                TTBaseVideoActivity.this.b.n().hf(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void w(int i) {
                TTBaseVideoActivity.this.w(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(int i) {
                TTBaseVideoActivity.this.b.n().xj(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void hf(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                tf tfVar;
                if ((i == 1 || i == 2) && (wVar instanceof ra)) {
                    ra raVar = (ra) wVar;
                    tfVar = new tf();
                    tfVar.xj(raVar.xj);
                    tfVar.hf(raVar.hf);
                    tfVar.w(raVar.w);
                    tfVar.u(raVar.u);
                    tfVar.xj(raVar.kd);
                    tfVar.hf(raVar.y);
                    tfVar.xj(raVar.qt);
                } else {
                    tfVar = null;
                }
                if (i == 2) {
                    TTBaseVideoActivity.this.dc.xj(view, tfVar);
                }
                if (i == 1) {
                    TTBaseVideoActivity.this.dc.xj(view, tfVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public long xj() {
                return TTBaseVideoActivity.this.b.n().xj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(int i, String str) {
                TTBaseVideoActivity.this.b.n().xj(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(float f) {
                TTBaseVideoActivity.this.b.n().xj(f);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(View view) {
                TTBaseVideoActivity.this.xj(2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                tf tfVar;
                if (TTBaseVideoActivity.this.dc != null) {
                    if (wVar instanceof ra) {
                        ra raVar = (ra) wVar;
                        tfVar = new tf();
                        tfVar.xj(raVar.xj);
                        tfVar.hf(raVar.hf);
                        tfVar.w(raVar.w);
                        tfVar.u(raVar.u);
                        tfVar.xj(raVar.kd);
                        tfVar.hf(raVar.y);
                        tfVar.xj(raVar.qt);
                    } else {
                        tfVar = null;
                    }
                    TTBaseVideoActivity.this.dc.xj(view, tfVar);
                }
            }
        };
        this.rg = new xj.InterfaceC0173xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.multipro.hf.xj.InterfaceC0173xj
            public com.bytedance.sdk.openadsdk.core.multipro.hf.xj j() {
                com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
                y yVar = TTBaseVideoActivity.this.f10297a;
                if (yVar != null) {
                    xjVar.c = yVar.zg();
                    xjVar.xj = TTBaseVideoActivity.this.f10297a.xj();
                    xjVar.f = TTBaseVideoActivity.this.ht;
                }
                return xjVar;
            }

            @Override // com.bytedance.sdk.openadsdk.core.multipro.hf.xj.InterfaceC0173xj
            public boolean q() {
                return false;
            }
        };
        this.dq = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.hf(new xj.InterfaceC0143xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public boolean c() {
                return TTBaseVideoActivity.this.jk.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public boolean d() {
                return TTBaseVideoActivity.this.b.vm();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public boolean f() {
                return TTBaseVideoActivity.this.tu();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public TTBaseVideoActivity getActivity() {
                return TTBaseVideoActivity.this.ws;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public boolean hf() {
                return TTBaseVideoActivity.this.io();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public int kd() {
                return TTBaseVideoActivity.this.b.io();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public void p() {
                com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = TTBaseVideoActivity.this.b;
                if (xjVar instanceof p) {
                    ((p) xjVar).ss();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public void tf() {
                com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = TTBaseVideoActivity.this.b;
                if (xjVar instanceof p) {
                    ((p) xjVar).nb();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public boolean u() {
                return TTBaseVideoActivity.this.lw;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public ws w() {
                return ((BaseThemeActivity) TTBaseVideoActivity.this).kd;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public RewardFullBaseLayout xj() {
                return TTBaseVideoActivity.this.ai;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public int y() {
                return TTBaseVideoActivity.this.b.y(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public void xj(int i, int i2) {
                if (i == 3) {
                    TTBaseVideoActivity.this.g(2);
                }
                TTBaseVideoActivity.this.xj(i, i2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xj.InterfaceC0143xj
            public void xj(int i) {
                if (i == 3) {
                    TTBaseVideoActivity.this.am(2);
                }
            }
        });
        this.qd = new com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf(new xj.InterfaceC0140xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.17
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.InterfaceC0140xj
            public Activity getActivity() {
                return TTBaseVideoActivity.this.ws;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.InterfaceC0140xj
            public String hf() {
                return TTBaseVideoActivity.this.n;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.InterfaceC0140xj
            public void kd() {
                y yVar = TTBaseVideoActivity.this.f10297a;
                if (yVar != null) {
                    yVar.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.InterfaceC0140xj
            public void u() {
                TTBaseVideoActivity.this.ws();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.InterfaceC0140xj
            public void w() {
                TTBaseVideoActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.InterfaceC0140xj
            public ws xj() {
                return ((BaseThemeActivity) TTBaseVideoActivity.this).kd;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.InterfaceC0140xj
            public void xj(int i, TTProgressBar tTProgressBar) {
                try {
                    TTBaseVideoActivity.this.ai.xj(i, tTProgressBar);
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.InterfaceC0140xj
            public void xj(boolean z, String str, String str2) {
                if (ht.w(((BaseThemeActivity) TTBaseVideoActivity.this).kd)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible", z);
                    jSONObject.put("entrance_text", n.xj(((BaseThemeActivity) TTBaseVideoActivity.this).kd, str, str2));
                } catch (JSONException e) {
                    pl.xj(e);
                }
                TTBaseVideoActivity.this.z.xj("showPlayAgainEntrance", jSONObject);
                TTBaseVideoActivity.this.l.xj(jSONObject);
                if (TTBaseVideoActivity.this.l.l()) {
                    return;
                }
                TTBaseVideoActivity.this.en.c(z);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.en.xj(n.xj(((BaseThemeActivity) tTBaseVideoActivity).kd, str, str2));
            }
        });
        this.t = new AtomicBoolean(true);
    }

    private void cy() {
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, getClass().getName());
        this.tj = wo.d(this.kd);
        this.nb = this.kd.yq();
        this.ss = this.kd.rs();
        aq.xj(this.kd, false);
        aq.hf(this.kd, false);
        com.bytedance.sdk.openadsdk.core.f.u.w = false;
        com.bytedance.sdk.openadsdk.core.f.u.hf = 0;
        com.bytedance.sdk.openadsdk.core.f.u.xj = 0;
        com.bytedance.sdk.openadsdk.core.f.u.u = false;
    }

    private void da() {
        if (this.f10297a.en().tu()) {
            if (this.kd.rh() == 9 && this.f10297a.ff()) {
                this.z.hf(true);
                this.f10297a.b();
            } else {
                this.z.hf(false);
            }
            y(1);
            return;
        }
        this.z.hf(true);
        if (this.f10297a.en().vm() < 2) {
            zb();
        }
        if (this.kd.rh() == 8) {
            y(1);
        } else {
            yo();
        }
    }

    private void ft() {
        final View view;
        try {
            view = getWindow().getDecorView();
        } catch (Throwable unused) {
            view = null;
        }
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    view.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        });
        view.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    view.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        }, 300L);
    }

    private void gj() {
        ws wsVar = this.kd;
        if (wsVar == null || this.ai == null) {
            return;
        }
        String jv = wsVar.jv();
        if (TextUtils.isEmpty(jv)) {
            return;
        }
        try {
            int optInt = new JSONObject(jv).optInt("auth_reward_gold");
            if (optInt > 0) {
                this.ai.addView(new RewardAuthToastLayout(this.ws, optInt));
            }
        } catch (JSONException e) {
            pl.hf("TTBaseVideoActivity", e);
        }
    }

    private boolean gy() {
        if (this.kd != null && com.bytedance.sdk.openadsdk.core.live.hf.xj().hf(this.kd)) {
            String jv = this.kd.jv();
            if (TextUtils.isEmpty(jv)) {
                return false;
            }
            try {
                return new JSONObject(jv).optInt("saas_play_time_type") == 1;
            } catch (JSONException e) {
                pl.hf("TTBaseVideoActivity", e);
            }
        }
        return false;
    }

    private void h() {
        if (this.l.l() || !this.ra || s() || !this.b.dq() || this.f10297a.ws()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if ((xjVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.u.w) || (xjVar instanceof p)) {
            return;
        }
        this.hf.removeMessages(300);
        this.hf.sendEmptyMessageDelayed(300, PushUIConfig.dismissTime);
    }

    private void k() {
        this.f10299pl.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean le() {
        return (this.kd.rx() == 180 && aq.e(this.kd) && com.bytedance.sdk.openadsdk.x.tf.xj(this.kd) && this.z.d() == 7) ? false : true;
    }

    private void nb() {
        this.ai = new RewardFullBaseLayout(this.ws);
        this.en = new com.bytedance.sdk.openadsdk.core.component.reward.hf.kd(this.ws);
        this.l = new com.bytedance.sdk.openadsdk.core.component.reward.hf.hf(this.ws);
        this.ff = new com.bytedance.sdk.openadsdk.core.component.reward.hf.xj(this.ws);
        this.f10297a = new y(this.ws);
        this.wo = new com.bytedance.sdk.openadsdk.core.component.reward.hf.u(this.ws);
        this.r = new com.bytedance.sdk.openadsdk.core.component.reward.hf.w(this.ws);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ne() {
        com.bykv.vk.openvk.component.video.api.u.w r = dc().r();
        if (r instanceof com.bytedance.sdk.openadsdk.core.video.hf.xj) {
            return ((com.bytedance.sdk.openadsdk.core.video.hf.xj) r).l();
        }
        return false;
    }

    private boolean rg() {
        hf.xj xjVar = this.vl;
        return xjVar != null && xjVar.u();
    }

    private int se() {
        com.bykv.vk.openvk.component.video.api.u.w r = dc().r();
        if (r instanceof com.bytedance.sdk.openadsdk.core.video.hf.xj) {
            return ((com.bytedance.sdk.openadsdk.core.video.hf.xj) r).vm();
        }
        return 0;
    }

    private void ss() {
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xj = com.bytedance.sdk.openadsdk.core.component.reward.u.u.xj(this.ws, this.kd);
        this.b = xj;
        if (xj == null) {
            pl.u("TTBaseVideoActivity", "initAdType failed , finish activity");
            finish();
            return;
        }
        xj.getClass();
        if (!j.hf(io(), this.kd, true)) {
            this.ht = pz.hf().xj(this.kd, this.tj);
        }
        this.b.xj(this.en, this.f10297a, this.l, this.wo, this.ff);
        w wVar = new w(io(), this.kd, this.f10297a, this.b);
        this.eu = wVar;
        wVar.hf(this.wa);
        this.b.xj(this.xj, this.ht, io(), this.eu);
        this.b.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (et()) {
            h();
            this.f10297a.xj(false, this);
        }
    }

    private void vl() {
        final View view;
        ws wsVar = this.kd;
        if (wsVar == null || !wsVar.u()) {
            final int jb = pz.hf().jb();
            try {
                requestWindowFeature(1);
                getWindow().addFlags(16777216);
                getWindow().addFlags(r.b.d);
                pz.xj(this.ws);
                if (!this.b.tj()) {
                    getWindow().addFlags(1024);
                    if (jb == 1) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            getWindow().setDecorFitsSystemWindows(true);
                        }
                        getWindow().getDecorView().setFitsSystemWindows(true);
                    }
                }
            } catch (Throwable unused) {
            }
            if (jb == 1) {
                return;
            }
            try {
                view = getWindow().getDecorView();
            } catch (Throwable unused2) {
                view = null;
            }
            if (view == null) {
                return;
            }
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (com.bytedance.sdk.openadsdk.core.a.r.hf() && TTBaseVideoActivity.this.ss == 1 && TTBaseVideoActivity.this.ws.getResources().getConfiguration().orientation == 1) {
                            int height = TTBaseVideoActivity.this.getWindow().getDecorView().getHeight();
                            if (jb == 1) {
                                Rect rect = new Rect();
                                TTBaseVideoActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                                height = rect.bottom - rect.top;
                            }
                            if (Math.abs(com.bytedance.sdk.openadsdk.core.a.r.d((Context) TTBaseVideoActivity.this.ws) - height) == 0 && view.isAttachedToWindow()) {
                                View view2 = view;
                                view2.setPadding(view2.getPaddingLeft(), (int) (view.getPaddingTop() + com.bytedance.sdk.openadsdk.core.a.r.p((Context) TTBaseVideoActivity.this.ws)), view.getPaddingRight(), view.getPaddingBottom());
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            });
        }
    }

    private void xv() {
        am.xj().w(this.kd, "stats_reward_full_destroy");
        com.bytedance.sdk.openadsdk.core.f.u.w = false;
        com.bytedance.sdk.openadsdk.core.f.u.hf = 0;
        com.bytedance.sdk.openadsdk.core.f.u.xj = 0;
        com.bytedance.sdk.openadsdk.core.f.u.u = false;
        this.hf.removeCallbacksAndMessages(null);
        this.f10297a.et();
        this.ff.y();
        this.l.y();
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u uVar = this.wn;
        if (uVar != null) {
            uVar.hf();
        }
        w(true);
        x();
        u("recycleRes");
        ws wsVar = this.kd;
        if (wsVar != null) {
            com.bytedance.sdk.openadsdk.core.ht.xj(wsVar.ke());
            ff.hf(this.kd.kd());
        }
    }

    private void zb() {
        if (v.u(this.kd)) {
            this.f10297a.eu();
            return;
        }
        pl();
        if (!aq.e(this.kd)) {
            com.bykv.vk.openvk.component.video.api.u.w r = dc().r();
            if (!(r instanceof com.bytedance.sdk.openadsdk.core.video.xj.xj) || !((com.bytedance.sdk.openadsdk.core.video.xj.xj) r).l()) {
                w(0);
                this.en.xj(false, null, null, true, true);
                if (aq.c(this.kd) && this.f10297a.pz() >= aq.tf(this.kd)) {
                    w(2);
                }
                this.b.en();
            }
        }
        k();
        if (aq.c(this.kd)) {
            w(2);
        }
        this.b.en();
    }

    public void a() {
        this.wo.hf();
    }

    public boolean ai() {
        return false;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.u.xj aq() {
        return this.b;
    }

    public void b() {
        this.hf.removeMessages(600);
    }

    public void bl() {
        this.dq.w();
    }

    public y dc() {
        return this.f10297a;
    }

    public boolean dk() {
        return rg() || pz() || this.b.z();
    }

    public void dq() {
        this.en.y();
    }

    public String en() {
        return "";
    }

    public boolean et() {
        if (dk() || this.f10297a.ws()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if ((xjVar != null && !xjVar.dq()) || this.wo.u() || this.l.l()) {
            return false;
        }
        if (this.f10297a.ra()) {
            if ((!this.f10297a.w() && !this.f10297a.hf()) || this.f10297a.hf()) {
                return false;
            }
            this.f10297a.w();
        }
        return true;
    }

    public void eu() {
        am(0);
    }

    public void f(int i) {
    }

    public void ff() {
        boolean z = !this.ht;
        this.ht = z;
        this.b.kd(z);
    }

    @Override // android.app.Activity
    public void finish() {
        Map<String, Object> tj = tj();
        com.bytedance.sdk.openadsdk.core.component.reward.hf.hf hfVar = this.l;
        if (hfVar != null) {
            hfVar.xj(tj);
            this.l.u();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if (xjVar != null) {
            xjVar.hf(tj);
        }
        com.bytedance.sdk.openadsdk.core.am.u.y(this.kd, this.xj, "click_close", tj);
        x();
        super.finish();
    }

    public void gh() {
        this.b.dc();
    }

    public void hl() {
        if (this.g.getAndSet(true)) {
            return;
        }
        y(3);
    }

    public abstract boolean io();

    public String j() {
        return "";
    }

    public RewardFullBaseLayout l() {
        return this.ai;
    }

    public void lw() {
        if (ne()) {
            da();
            return;
        }
        if (!this.f10297a.ff() && !this.f10297a.pl()) {
            zb();
        }
        y(1);
    }

    public Double n() {
        return this.xv;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.openadsdk.core.a.r.hf((Activity) this.ws);
        try {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        com.bytedance.sdk.openadsdk.core.playable.hf.hf hfVar = TTBaseVideoActivity.this.aq;
                        if (hfVar != null) {
                            hfVar.xj();
                        }
                        try {
                            if (TTBaseVideoActivity.this.isFinishing()) {
                                return;
                            }
                            if (TTBaseVideoActivity.this.ss == 2) {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.bytedance.sdk.openadsdk.core.a.r.xj((Activity) TTBaseVideoActivity.this.ws);
                                    }
                                }, 2500L);
                            } else {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.bytedance.sdk.openadsdk.core.a.r.hf((Activity) TTBaseVideoActivity.this.ws);
                                    }
                                }, 500L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ws wsVar = this.kd;
        if (wsVar == null) {
            return;
        }
        if (ws.w(wsVar) || this.kd.py() == 1 || (this.b instanceof d)) {
            this.l.qt();
        }
        com.bytedance.sdk.openadsdk.core.playable.hf.hf hfVar = this.aq;
        if ((hfVar == null || !hfVar.hf(this.ws, this.kd)) && v.p(this.kd)) {
            tf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ws = this;
        nb();
        xj(getIntent());
        hf(bundle);
        hf(getIntent());
        if (xj(bundle)) {
            cy();
            ss();
            vl();
            d();
            this.b.xj(this.gj, this.cy);
            setContentView(this.ai);
            u();
            this.b.hf();
            com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.z;
            if (kdVar != null) {
                kdVar.xj(this.rg);
            }
            if (gy()) {
                this.se = new u();
            }
            SaasAuthRewardDialog saasAuthRewardDialog = (SaasAuthRewardDialog) findViewById(2114387968);
            if (saasAuthRewardDialog != null) {
                saasAuthRewardDialog.xj(this.kd, this.xj, io() ? 7 : 5);
            }
            if (j.hf(io(), this.kd, true)) {
                l().getSceneFrameContainer().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.18
                    @Override // java.lang.Runnable
                    public void run() {
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, TTBaseVideoActivity.this.l().getSceneFrameContainer().getHeight(), 0.0f);
                        translateAnimation.setDuration(300L);
                        translateAnimation.setFillAfter(true);
                        TTBaseVideoActivity.this.l().getSceneFrameContainer().startAnimation(translateAnimation);
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if (xjVar != null) {
            xjVar.qt();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar2 = this.hl;
        if (xjVar2 != null) {
            xjVar2.hf();
        }
        xv();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.bytedance.sdk.openadsdk.core.playable.hf.hf hfVar = this.aq;
        if (hfVar != null) {
            hfVar.xj(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        ws();
        this.ra = false;
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if (xjVar != null) {
            xjVar.am();
        }
        this.ff.kd();
        this.l.u();
        u uVar = this.se;
        if (uVar != null) {
            uVar.w();
        }
        this.hf.removeMessages(1300);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (io() && this.qd.hf()) {
            hf();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dq.kd()) {
            hf();
            return;
        }
        u uVar = this.se;
        if (uVar != null) {
            uVar.u();
            int xj = (int) this.se.xj(TimeUnit.SECONDS);
            xj(xj, false);
            this.se.kd();
            if (this.z != null && !aq.e(this.kd)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", xj);
                } catch (JSONException e) {
                    pl.xj(e);
                }
                this.z.xj("reduceTime", jSONObject);
            }
        }
        this.ra = true;
        this.l.hf();
        this.ff.u();
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if (xjVar != null) {
            xjVar.hf(this.u.containsKey(0));
            eu();
            this.wo.xj();
            ft();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u uVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u();
        uVar2.xj = j.xj(io()) > 0;
        uVar2.hf = j.xj(io());
        xj(1, uVar2);
        this.hf.sendEmptyMessageDelayed(1300, this.eu.d());
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("multi_process_key", this.n);
            bundle.putBoolean("is_preload", this.dk);
            bundle.putLong("object_create_ts", this.et);
            bundle.putBoolean("is_adm", this.f10298io);
            bundle.putInt("key_video_cache_callback", this.x);
            bundle.putLong("video_current", this.f10297a.zg());
            bundle.putBoolean("is_mute", this.ht);
            bundle.putString("rit_scene", this.yy);
            Double d = this.xv;
            bundle.putString("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSkipBorderClick(View view) {
        this.b.xj(view);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.l.pl();
        com.bytedance.sdk.openadsdk.x.xj xjVar = this.ft;
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if (xjVar != null) {
            xjVar.w(this.c.get());
        }
        this.l.kd();
        com.bytedance.sdk.openadsdk.x.xj xjVar2 = this.ft;
        if (xjVar2 != null) {
            xjVar2.hf();
        }
    }

    public void op() {
        this.dq.xj(this.ai);
    }

    public int q() {
        return 0;
    }

    public void qd() {
        this.jk.set(true);
    }

    public int r() {
        return Math.max(this.b.hl() - (this.b.yy() + ((int) (this.f10297a.z() / 1000))), 0);
    }

    public boolean s() {
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        return (xjVar != null && xjVar.gy()) || !this.y.isEmpty();
    }

    public Map<String, Object> tj() {
        return xj(this.kd);
    }

    public boolean tu() {
        return this.u.containsKey(0);
    }

    public void u(int i) {
    }

    public abstract void u(String str);

    public boolean vm() {
        return this.wo.u() || this.l.l();
    }

    public void w(int i) {
    }

    public abstract void w(boolean z);

    public void wa() {
        this.dq.hf(false);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.hf.w wn() {
        return this.r;
    }

    public ai wo() {
        return this.hf;
    }

    public void ws() {
        g(0);
    }

    public abstract void x();

    public String xj() {
        return null;
    }

    public void yy() {
    }

    public String z() {
        return "";
    }

    public void am() {
        if (this.p.get() || this.d.getAndSet(true)) {
            return;
        }
        u("onSkippedVideo");
    }

    public void c() {
        kd kdVar = new kd(this.ws, this.kd, this.xj, io() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.hf.kd
            public void hf(View view, tf tfVar) {
                TTBaseVideoActivity.this.xj(2);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.ff.xj(view, tTBaseVideoActivity.gy, tfVar);
            }
        };
        this.dc = kdVar;
        if (this.b instanceof com.bytedance.sdk.openadsdk.core.component.reward.u.y) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.rg);
        }
        xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) this.dc.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        this.dc.xj(this.q.g());
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.dc.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(tj());
        com.bytedance.sdk.openadsdk.core.hf.hf hfVar = new com.bytedance.sdk.openadsdk.core.hf.hf(this.ws, this.kd, this.xj, io() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.20
            @Override // com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
            public void xj(View view, tf tfVar) {
                TTBaseVideoActivity.this.r.xj(view, tfVar);
            }
        };
        this.gh = hfVar;
        xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        this.gy = new xj.InterfaceC0145xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.InterfaceC0145xj
            public void xj(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.r.xj(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.InterfaceC0145xj
            public void xj(View view, tf tfVar) {
                TTBaseVideoActivity.this.r.xj(view, tfVar);
            }
        };
        this.op = new xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.hf
            public void hf(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.l.xj(j2, j, 2);
                }
                TTBaseVideoActivity.this.xj("下载暂停");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.hf
            public void w(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.l.xj(j2, j, 4);
                }
                TTBaseVideoActivity.this.xj("下载失败");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.hf
            public void xj(boolean z) {
                if (z) {
                    TTBaseVideoActivity.this.l.xj(1, 0);
                }
                TTBaseVideoActivity.this.xj("点击开始下载");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.hf
            public void xj(boolean z, long j, long j2, String str, String str2) {
                long j3;
                long j4;
                if (z) {
                    j3 = j;
                    j4 = j2;
                    TTBaseVideoActivity.this.l.xj(j4, j3, 3);
                } else {
                    j3 = j;
                    j4 = j2;
                }
                if (j3 > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.xj("已下载" + ((int) ((100 * j4) / j3)) + "%");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.hf
            public void xj(boolean z, long j, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.l.xj(5, 100);
                }
                TTBaseVideoActivity.this.xj("点击安装");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.hf
            public void xj(boolean z, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.l.xj(6, 100);
                }
                TTBaseVideoActivity.this.xj("点击打开");
            }
        };
        this.b.xj(this.dc);
    }

    public void d() {
        float[] xj = com.bytedance.sdk.openadsdk.core.component.reward.kd.hf.xj(this.ws.getApplicationContext(), this.nb, this.ss);
        float f = xj[0];
        float f2 = xj[1];
        if (this.nb == 100.0f) {
            this.gj = (int) f;
            this.cy = (int) f2;
            return;
        }
        int[] xj2 = com.bytedance.sdk.openadsdk.core.component.reward.kd.hf.xj(this.ws.getApplicationContext(), this.nb, this.kd.eq(), this.ss);
        int i = xj2[0];
        int i2 = xj2[1];
        int i3 = xj2[2];
        int i4 = xj2[3];
        float f3 = i;
        float f4 = i3;
        this.gj = (int) ((f - f3) - f4);
        float f5 = i2;
        float f6 = i4;
        this.cy = (int) ((f2 - f5) - f6);
        if (!x.xj(this.kd) || com.bytedance.sdk.openadsdk.core.zg.u.xj(String.valueOf(this.tj))) {
            try {
                this.ai.xj(com.bytedance.sdk.openadsdk.core.a.r.w(this.ws, f3), com.bytedance.sdk.openadsdk.core.a.r.w(this.ws, f5), com.bytedance.sdk.openadsdk.core.a.r.w(this.ws, f4), com.bytedance.sdk.openadsdk.core.a.r.w(this.ws, f6));
            } catch (Throwable unused) {
            }
        }
    }

    public void e() {
        if (!ne()) {
            yo();
        }
        this.f10297a.tf();
    }

    public void g() {
        if (this.tf.getAndSet(true)) {
            return;
        }
        u("onVideoError");
    }

    public void hf() {
        finish();
    }

    public void ht() {
        this.en.xj(1);
        if (!aq.e(this.kd)) {
            this.en.xj(false, null, null, true, true);
        }
        this.en.xj(true);
        this.en.kd(true);
        this.en.y(false);
        this.en.hf(this.kd.oz());
        this.wo.xj(this.ht, this.u.containsKey(0));
        this.hf.sendEmptyMessage(1200);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 1);
            this.z.xj("playableStateChange", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public void jk() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar;
        if (this.wn == null || (kdVar = this.z) == null || kdVar.pl() == null) {
            return;
        }
        this.z.pl().setEasyPlayableSender(this.wn.xj());
        this.wn.xj(l().getEasyPlayableContainer(), null);
    }

    public void kd() {
        com.bytedance.sdk.openadsdk.core.component.reward.hf.hf hfVar;
        am.xj().w(this.kd, "stats_reward_full_show_endcard");
        if (isDestroyed() || isFinishing() || (hfVar = this.l) == null || hfVar.l()) {
            return;
        }
        if (!v.u(this.kd)) {
            this.l.u(true);
        }
        this.b.dk();
        if (this.b instanceof p) {
            this.dq.hf(true);
            this.dq.y();
        }
        if (!(this.b instanceof f) || !this.l.v() || (this.b instanceof d)) {
            this.l.pz();
        }
        this.en.xj(true);
        this.wo.xj(this.ht);
        this.l.p();
        if ((this.b instanceof f) && this.l.ai()) {
            this.l.f();
            return;
        }
        this.en.xj(2);
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = this.hl;
        if (xjVar != null) {
            xjVar.hf();
        }
        hf.xj xjVar2 = this.vl;
        if (xjVar2 != null) {
            xjVar2.kd();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar2 = this.q;
        if (hfVar2 != null) {
            hfVar2.kd(8);
        }
        this.l.w(false);
        if (!this.l.zg()) {
            if (!h.tf(this.kd)) {
                this.l.xj(false, TTAdConstant.INTERACTION_TYPE_CODE, "end_card_timeout");
            }
            this.l.kd(true);
            this.f10297a.f();
            return;
        }
        if (!h.tf(this.kd) && !ht.hf(this.kd)) {
            this.l.xj(true, 0, (String) null);
        }
        this.l.g();
        this.hf.sendEmptyMessageDelayed(500, 100L);
    }

    public void p() {
        if (this.b.dq()) {
            this.f10297a.xj(3);
            this.f10297a.v();
            this.f10297a.w(true);
            xj(false, false);
        }
    }

    public void pl() {
        am.xj().xj(this.kd, "stats_reward_full_completed", this.r.xj(new JSONObject()));
        if (this.p.getAndSet(true)) {
            return;
        }
        u("onVideoComplete");
    }

    public boolean pz() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = this.hl;
        if (xjVar != null) {
            return xjVar.w();
        }
        return false;
    }

    public void qt() {
        this.hf.removeMessages(700);
        this.hf.removeMessages(600);
    }

    public void ra() {
        this.wo.w();
        this.l.ff();
        this.en.xj(1);
        this.hf.removeMessages(1200);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 0);
            if (io()) {
                jSONObject.put("reduce_duration", this.b.yy());
            }
            this.z.xj("playableStateChange", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
        if (!this.dq.xj(1)) {
            this.zg.set(true);
        }
        xj(1, (com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u) null);
    }

    public void tf() {
        if (this.l.am()) {
            this.l.qt();
            return;
        }
        if (!this.l.et() && !com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.kd) && !com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.kd)) {
            hf();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar = new com.bytedance.sdk.openadsdk.core.component.reward.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                if (v.p(((BaseThemeActivity) TTBaseVideoActivity.this).kd)) {
                    new xj.C0138xj().kd(((BaseThemeActivity) TTBaseVideoActivity.this).kd.ho()).xj("rewarded_video").hf("popup_cancel").u(((BaseThemeActivity) TTBaseVideoActivity.this).kd.jf()).xj((com.bytedance.sdk.openadsdk.y.xj.xj) null);
                    TTBaseVideoActivity.this.am();
                    TTBaseVideoActivity.this.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj() {
                if (v.p(((BaseThemeActivity) TTBaseVideoActivity.this).kd)) {
                    new xj.C0138xj().kd(((BaseThemeActivity) TTBaseVideoActivity.this).kd.ho()).xj("rewarded_video").hf("popup_play").u(((BaseThemeActivity) TTBaseVideoActivity.this).kd.jf()).xj((com.bytedance.sdk.openadsdk.y.xj.xj) null);
                    if (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(((BaseThemeActivity) TTBaseVideoActivity.this).kd) || com.bytedance.sdk.openadsdk.core.ugeno.tf.u(((BaseThemeActivity) TTBaseVideoActivity.this).kd)) {
                        return;
                    }
                    TTBaseVideoActivity.this.hf("onClickModalCallback");
                }
            }
        };
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.kd) || com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.kd)) {
            xj(tfVar);
        } else {
            hf(tfVar);
        }
    }

    public void v() {
        kd();
    }

    public void y() {
        if (this.b.dq()) {
            if (hf(this.f10297a.y(), false)) {
                return;
            }
            xj(true, true);
        } else {
            if (ht.c(this.kd)) {
                return;
            }
            hf(true, true);
        }
    }

    public void yo() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.z;
        if (kdVar != null) {
            kdVar.xj("videoLoopBegin", (JSONObject) null);
        }
    }

    public void zg() {
        this.hf.removeMessages(MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL);
    }

    private void hf(final com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar) {
        final boolean[] zArr = {false};
        com.bytedance.sdk.openadsdk.d.xj.hf.xj(new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.d.xj.hf.xj
            public void xj() {
                zArr[0] = true;
                tfVar.hf();
            }

            @Override // com.bytedance.sdk.openadsdk.d.xj.hf.xj
            public void xj(int i) {
                zArr[0] = true;
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this.ws;
                if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
                    TTBaseVideoActivity.this.ws.getIntent().putExtra("remainTime", i);
                }
                if (i > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    if (tTBaseVideoActivity2.xj(((BaseThemeActivity) tTBaseVideoActivity2).kd, tfVar)) {
                        return;
                    }
                }
                tfVar.hf();
            }
        });
        hf("onClickBrowseClose");
        new CountDownTimer(1000L, 1000L) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (zArr[0]) {
                    return;
                }
                TTBaseVideoActivity.this.hf();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public Map<String, Object> f() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar;
        Map<String, Object> tj = tj();
        if (this.et > 0) {
            tj.put("object_media_holder_time", Long.valueOf((System.currentTimeMillis() - this.et) / 1000));
        }
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if (xjVar != null && xjVar.y() && (kdVar = this.z) != null) {
            dk.xj(tj, this.kd, kdVar.pl());
        }
        return tj;
    }

    public void u() {
        this.ai.xj(this.b);
        gj();
        this.q = this.b.xj(io());
        this.z = this.b.pl();
        this.j = this.b.g();
        this.q.xj();
        c();
        this.q.xj(this.dc, this.gh);
        this.q.xj(this.ff.c());
        this.en.xj(this.kd, this.l, io(), this.dc);
        this.en.u(this.ht);
        if (this.ff.w()) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.dc.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.ff.hf());
            this.ff.xj(this.gy);
        }
        this.ff.xj(this.op);
        this.ff.xj(this.rg);
        this.l.xj(this.en, this.ff, io(), this.xj, this.gj, this.cy);
        this.l.xj(this.kd, this.dc, this.rg.j(), this.j);
        this.wo.xj(this.l, this.kd, this.xj, this.en);
        this.r.xj(this.kd, this.xj, this.q.g());
        this.f10297a.xj(this.kd);
        this.ft = new com.bytedance.sdk.openadsdk.x.xj();
        this.wn = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u(this.kd, false, this.s);
        this.aq = new com.bytedance.sdk.openadsdk.core.playable.hf.hf(this.xj);
    }

    public void w() {
        this.f10297a.b();
        this.f10297a.xj(2);
        this.f10297a.d();
        am();
        y(2);
    }

    public boolean xj(Bundle bundle) {
        this.ff.xj(this.kd, this.xj, this.n);
        if (bundle != null) {
            this.ff.xj();
        }
        com.bytedance.sdk.openadsdk.core.u.xj().hf(this.kd);
        if (this.kd != null) {
            return true;
        }
        pl.u("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
        hf();
        return false;
    }

    public void zg(int i) {
        if (i == 0) {
            return;
        }
        this.y.remove(Integer.valueOf(i));
    }

    public void g(int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar;
        if (this.f10297a.hf()) {
            HashMap hashMap = new HashMap();
            hashMap.put("pause_from", Integer.valueOf(i));
            this.f10297a.xj(hashMap);
        }
        this.hf.removeMessages(300);
        this.hf.removeMessages(1200);
        qt(i);
        if ((s() && aq.e(this.kd) && this.wo.u()) || (xjVar = this.b) == null) {
            return;
        }
        xjVar.pz();
        this.l.hf(s());
    }

    public void qt(int i) {
        if (i == 0) {
            return;
        }
        this.y.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public void am(int i) {
        zg(i);
        if (this.b instanceof d) {
            this.hf.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.t();
                }
            }, 500L);
        } else {
            t();
        }
        if (dk()) {
            return;
        }
        if (this.l.q()) {
            this.hf.sendEmptyMessageDelayed(1200, 1000L);
        }
        if (!s() || this.l.l() || this.l.q()) {
            this.b.ht();
        }
        this.l.w();
    }

    public void pl(int i) {
        this.q.kd(i);
    }

    public void p(int i) {
        this.b.w(i);
        w(0);
    }

    public void y(int i) {
        int kd = kd(i);
        if (i != 2) {
            if (this.wo.u()) {
                return;
            }
            if (this.f10297a.pl()) {
                this.f10297a.tf();
                return;
            }
            if (aq.e(this.kd)) {
                if (this.f10299pl.get() && !this.g.get()) {
                    if (kd == 1 && !this.u.containsKey(0) && io()) {
                        this.en.hf((this.kd.vw() == 3 && aq.yo(this.kd)) ? "奖励就快来了\n去详情页看看也累计时长哦～" : "奖励还在路上狂奔\n再等一下下哦～");
                    }
                    this.f10297a.eu();
                }
                if (!this.f10299pl.get() && this.g.get() && (!ne() || i == 3)) {
                    return;
                }
                if (kd == 1 && (!this.f10299pl.get() || !this.g.get())) {
                    return;
                }
            }
        }
        if (kd == 1) {
            hf();
            return;
        }
        if (kd == 2) {
            if (this.f.get()) {
                this.l.pz();
            }
            kd();
        } else if (kd == 3) {
            this.f10297a.eu();
        } else if (kd == 4 && i != 3) {
            e();
        }
    }

    public void hf(String str) {
        com.bytedance.sdk.openadsdk.core.j io2 = this.l.io();
        if (io2 != null && !isFinishing()) {
            try {
                io2.hf(str, (JSONObject) null);
                return;
            } catch (Exception e) {
                hf();
                pl.xj(e);
                return;
            }
        }
        hf();
    }

    public void w(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.hl == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(this.ws, this.kd.xl(), this.xj, true);
            this.hl = xjVar;
            com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.ws, this.kd, xjVar);
            this.hl.xj(new xj.InterfaceC0158xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                public void hf() {
                    TTBaseVideoActivity.this.eu();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                public void xj() {
                    TTBaseVideoActivity.this.ws();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                public void xj(int i, String str2, boolean z) {
                    TTBaseVideoActivity.this.hf.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TTBaseVideoActivity.this.eu();
                        }
                    });
                }
            });
        }
        this.hl.xj(str);
        this.hl.xj();
    }

    public boolean xj(long j, boolean z) {
        if (!this.f10297a.ra()) {
            return false;
        }
        if (!z || !this.f10297a.dk()) {
            h();
        }
        boolean xj = this.f10297a.xj(j, this.ht, this.b.ra());
        if (xj && !z) {
            if (ht.c(this.kd)) {
                return true;
            }
            hf(true, true);
        }
        return xj;
    }

    public void tf(int i) {
        if (this.z != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", i);
            } catch (JSONException e) {
                pl.xj(e);
            }
            this.z.xj("reduceTime", jSONObject);
        }
    }

    public void hf(int i) {
        if (i <= 0) {
            this.en.xj(false, null, null, true, true);
        } else {
            this.hf.sendEmptyMessageDelayed(600, i);
        }
    }

    public void c(int i) {
        this.ai.xj(i);
    }

    public void xj(final com.bytedance.sdk.openadsdk.core.hf.xj.w.w wVar) {
        wVar.xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.3
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.w.w.xj
            public boolean xj() {
                wVar.xj(TTBaseVideoActivity.this.f());
                wVar.xj(TTBaseVideoActivity.this.xj);
                wVar.xj(TTBaseVideoActivity.this.xv);
                return TTBaseVideoActivity.this.bl.get();
            }
        });
    }

    public void hf(boolean z) {
        Message message = new Message();
        message.what = MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL;
        this.hf.sendMessageDelayed(message, z ? 2000L : 0L);
    }

    public void xj(String str) {
        this.l.xj(str);
    }

    private void xj(com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar) {
        int a2 = this.b.a();
        TTBaseVideoActivity tTBaseVideoActivity = this.ws;
        if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
            this.ws.getIntent().putExtra("remainTime", a2);
        }
        if (a2 > 0) {
            if (xj(this.kd, tfVar)) {
                return;
            }
            tfVar.hf();
            return;
        }
        hf();
    }

    public void hf(boolean z, boolean z2) {
        Integer valueOf;
        int i = 1;
        if (z) {
            Map<String, Object> f = f();
            this.bl.set(true);
            try {
                String zf = this.kd.zf();
                Integer remove = com.bytedance.sdk.openadsdk.core.f.u.kd.remove(zf);
                if (remove == null) {
                    valueOf = 1;
                } else {
                    valueOf = Integer.valueOf(remove.intValue() + 1);
                }
                com.bytedance.sdk.openadsdk.core.f.u.kd.put(zf, valueOf);
                f.put("meta_show_count", valueOf);
                String tf = wo.tf(this.kd);
                Integer remove2 = com.bytedance.sdk.openadsdk.core.f.u.y.remove(tf);
                if (remove2 != null) {
                    i = Integer.valueOf(remove2.intValue() + 1);
                }
                com.bytedance.sdk.openadsdk.core.f.u.y.put(tf, i);
                f.put("meta_origin_show_count", i);
            } catch (Throwable unused) {
            }
            f.put("cache_strategy", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.xj.kd.xj(io())));
            f.put("is_adm", Boolean.valueOf(this.f10298io));
            f.put("is_play_again", Boolean.valueOf(ai()));
            f.put("if_cache_callback", Integer.valueOf(this.x == 1 ? 1 : 0));
            f.put("src_req_id", this.kd.az());
            f.put("is_map", Boolean.valueOf(this.kd.fc()));
            f.put("is_repeat", Boolean.valueOf(this.v.getAndSet(true)));
            com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, this.xj, f, this.xv);
            com.bytedance.sdk.openadsdk.core.q.xj.xj().u();
            ff.xj(this.kd.kd());
        }
        if (z2) {
            if (!j.hf(io(), this.kd, true)) {
                boolean db = pz.hf().db();
                if (this.yo.getAndSet(true) && !db) {
                    am.xj().w(this.kd, "stats_callback_repeat");
                } else {
                    u("onAdShow");
                }
            }
            if (this.b.y()) {
                this.z.c();
            }
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u uVar = this.wn;
            if (uVar != null && uVar.xj() != null) {
                this.wn.xj().u();
            }
        }
        w(false);
    }

    public void d(int i) {
        com.bytedance.sdk.openadsdk.core.video.hf.hf l;
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar = this.b;
        if (!(xjVar instanceof d) || (l = xjVar.l()) == null) {
            return;
        }
        if (l.p() == 1 && i == 1 && this.t.getAndSet(false)) {
            int f = com.bytedance.sdk.openadsdk.core.a.r.f(pz.getContext());
            float y = com.bytedance.sdk.openadsdk.core.a.r.y(pz.getContext());
            float c = com.bytedance.sdk.openadsdk.core.a.r.c(pz.getContext());
            Map<String, Object> tj = tj();
            tj.putAll(l.c());
            com.bytedance.sdk.openadsdk.core.am.u.xj("click", this.kd, new d.xj().y(-1.0f).kd(-1.0f).u(-1.0f).w(-1.0f).hf(-1L).xj(-1L).w(-1).u(-1).kd(-1024).hf(com.bytedance.sdk.openadsdk.core.f.zg().w() ? 1 : 2).xj(f).xj(y).hf(c).xj(), this.xj, true, tj, -1, false);
        }
    }

    public boolean xj(ws wsVar, final com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar) {
        if (!io() || !pz.hf().c(String.valueOf(this.tj)) || this.u.containsKey(0) || isFinishing()) {
            return false;
        }
        if (System.currentTimeMillis() - this.h < 1000) {
            return true;
        }
        this.h = System.currentTimeMillis();
        hf.xj xj = this.b.xj(wsVar, new com.bytedance.sdk.openadsdk.core.component.reward.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                TTBaseVideoActivity.this.am.set(true);
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.hf();
                }
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.r.xj("reward_retain_dialog_skip", tTBaseVideoActivity.vl.xj(), TTBaseVideoActivity.this.vl.hf());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj() {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.xj();
                }
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.r.xj("reward_retain_dialog_cancel", tTBaseVideoActivity.vl.xj(), TTBaseVideoActivity.this.vl.hf());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj(int i) {
                TTBaseVideoActivity.this.xj(i, true);
                TTBaseVideoActivity.this.en.hf("恭喜您，可提前" + i + "s获得奖励～");
            }
        });
        this.vl = xj;
        this.r.xj("reward_retain_dialog_show", xj.xj(), this.vl.hf());
        return this.vl.w();
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i = message.what;
        if (i == 300) {
            p();
            return;
        }
        if (i == 400) {
            this.f10297a.d();
            if (this.b.y()) {
                this.z.xj(true);
            }
            xj(false, true);
            return;
        }
        if (i == 500) {
            this.l.c();
            this.f10297a.f();
            this.q.w(false);
            this.z.w(false);
            this.z.u();
            return;
        }
        if (i == 600) {
            this.en.xj(false, null, null, true, true);
            return;
        }
        if (i == 700) {
            this.l.j();
            return;
        }
        if (i == 1200) {
            if (aq.e(this.kd)) {
                return;
            }
            if (this.l.q()) {
                xj(1, false);
                this.wo.xj(r(), this.b.a());
                w(0);
            }
            this.hf.sendEmptyMessageDelayed(1200, 1000L);
            return;
        }
        if (i != 1300) {
            return;
        }
        this.hf.sendEmptyMessageDelayed(1300, this.eu.d());
        if (dk()) {
            return;
        }
        this.eu.f();
        if (!s()) {
            this.eu.c();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u uVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u();
        if (j.hf(io()) > 0) {
            int kd = j.kd(this.kd) / 1000;
            int hf = j.hf(io());
            if (kd < hf) {
                hf = kd;
            }
            if (kd - hf <= this.b.io()) {
                uVar.xj = true;
                uVar.hf = hf;
            }
        }
        xj(2, uVar);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u uVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u();
        uVar2.xj = true;
        xj(3, uVar2);
        this.dq.c();
        this.b.aq();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0027, code lost:
    
        if (r3 > 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:
    
        if (r7 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0035, code lost:
    
        if (r6.am.get() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0039, code lost:
    
        if (r7 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0041, code lost:
    
        if (r7 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int kd(int r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 2
            if (r7 != r1) goto L6
            r7 = 1
            goto L7
        L6:
            r7 = 0
        L7:
            com.bytedance.sdk.openadsdk.core.component.reward.u.xj r2 = r6.b
            boolean r2 = r2.s()
            com.bytedance.sdk.openadsdk.core.ra.ws r3 = r6.kd
            int r3 = r3.rh()
            r4 = 3
            r5 = 4
            switch(r3) {
                case 1: goto L37;
                case 2: goto L18;
                case 3: goto L41;
                case 4: goto L3c;
                case 5: goto L3c;
                case 6: goto L39;
                case 7: goto L2d;
                case 8: goto L1a;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r5 = 2
            goto L44
        L1a:
            boolean r3 = r6.ne()
            if (r3 == 0) goto L2a
            int r3 = r6.se()
            if (r7 == 0) goto L27
            goto L37
        L27:
            if (r3 <= 0) goto L44
            goto L18
        L2a:
            if (r7 == 0) goto L18
            goto L37
        L2d:
            if (r7 == 0) goto L18
            java.util.concurrent.atomic.AtomicBoolean r3 = r6.am
            boolean r3 = r3.get()
            if (r3 == 0) goto L18
        L37:
            r5 = 1
            goto L44
        L39:
            if (r7 == 0) goto L44
            goto L37
        L3c:
            if (r7 == 0) goto L3f
            goto L37
        L3f:
            r5 = 3
            goto L44
        L41:
            if (r7 == 0) goto L18
            goto L37
        L44:
            if (r5 != r1) goto L49
            if (r2 != 0) goto L49
            r5 = 1
        L49:
            com.bytedance.sdk.openadsdk.core.component.reward.u.xj r1 = r6.b
            boolean r1 = r1 instanceof com.bytedance.sdk.openadsdk.core.component.reward.u.y
            if (r1 == 0) goto L5b
            com.bytedance.sdk.openadsdk.core.ra.ws r1 = r6.kd
            boolean r1 = com.bytedance.sdk.openadsdk.x.tf.xj(r1)
            if (r1 == 0) goto L5b
            if (r7 == 0) goto L5a
            return r0
        L5a:
            return r4
        L5b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.kd(int):int");
    }

    public boolean hf(long j, boolean z) {
        this.f10297a.xj(this.dc);
        this.f10297a.xj(this.b.yo(), this.xj, io());
        this.f10297a.hf(f());
        if (this.b.y()) {
            this.z.xj(this.f10297a.r());
        }
        this.f10297a.xj(this.tu);
        boolean xj = xj(j, z);
        if (xj && !z) {
            this.vm = (int) (System.currentTimeMillis() / 1000);
        }
        return xj;
    }

    public void hf(Bundle bundle) {
        if (bundle != null) {
            this.n = bundle.getString("multi_process_key");
            this.dk = bundle.getBoolean("is_preload");
            this.et = bundle.getLong("object_create_ts");
            this.f10298io = bundle.getBoolean("is_adm");
            this.x = bundle.getInt("key_video_cache_callback", -1);
            this.yy = bundle.getString("rit_scene");
            String string = bundle.getString("_client_bidding_aution_price");
            this.xv = TextUtils.isEmpty(string) ? null : Double.valueOf(Double.parseDouble(string));
            this.ht = bundle.getBoolean("is_mute");
            long j = bundle.getLong("video_current");
            if (j > 0) {
                this.f10297a.xj(j);
            }
        }
    }

    public void xj(long j) {
        Message obtain = Message.obtain();
        obtain.what = 700;
        this.hf.sendMessageDelayed(obtain, j);
    }

    public void hf(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getStringExtra("insert_ad_bundle"))) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w wVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w(intent.getStringExtra("insert_ad_bundle"));
        this.n = wVar.xj();
        if (j.xj(this.kd) == 1) {
            this.wa = wVar.tf();
        }
        this.lw = wVar.p();
        this.p.set(wVar.u());
        this.u.putAll(wVar.f());
        this.dq.xj(wVar);
        this.ht = wVar.kd();
        this.qd.w(wVar.y());
    }

    @Override // com.bytedance.sdk.openadsdk.core.f.hf
    public void xj(boolean z) {
        if (z) {
            if (this.z.y()) {
                return;
            }
            this.b.u(true);
            return;
        }
        if (this.z.y() && this.f10297a.a() != null) {
            this.f10297a.a().xj(8);
        }
        this.b.u(false);
        if (this.z.y() || this.ss == 2 || !com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.kd)) {
            return;
        }
        this.q.y(8);
    }

    public void xj(boolean z, boolean z2) {
        this.f10297a.hf(z2);
        g();
        if (z) {
            this.qt.set(true);
            if (aq.e(this.kd)) {
                this.b.ai();
            }
            this.en.xj(false, null, null, true, true);
            kd();
            return;
        }
        if (aq.pz(this.kd)) {
            this.l.wo();
        } else {
            this.en.xj(false, null, null, true, true);
            u(0);
        }
        if (this.f10297a.ws()) {
            return;
        }
        if (aq.e(this.kd)) {
            this.b.ai();
        }
        kd();
    }

    public void xj(int i, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u uVar) {
        if (ht.w(this.kd) || this.am.get() || this.tf.get()) {
            return;
        }
        int i2 = 0;
        if (i == 1) {
            if (!this.zg.get()) {
                return;
            }
            if (uVar == null || !uVar.xj) {
                this.zg.set(false);
            }
        }
        int xj = this.dq.xj(i, uVar != null && uVar.u);
        if (xj == 0) {
            return;
        }
        if (xj == 3 && uVar != null && uVar.w) {
            i2 = j.tf();
        }
        this.dq.xj(new w.xj().xj(this.n).xj(this.b.a()).hf(i2).xj(this.p.get()).xj(this.u.keySet()).hf(this.ht).xj(this.qd).w(xj).u(this.b.io()).w(this.dq.u() ? this.lw : ws.hf(this.kd)).xj(), xj, uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f.hf
    public void xj(int i) {
        this.jk.set(true);
        if (System.currentTimeMillis() - this.ne > 50) {
            this.ne = System.currentTimeMillis();
            u("onAdVideoBarClick");
        }
        if (!isFinishing()) {
            c.xj(this.z.pl());
        }
        if (!this.c.get()) {
            this.c.set(true);
        }
        if (!this.dq.xj(1)) {
            this.zg.set(true);
        }
        w(0);
        d(i);
    }

    public void xj(Intent intent) {
        if (intent != null) {
            this.yy = intent.getStringExtra("rit_scene");
            this.dk = intent.getBooleanExtra("is_preload", false);
            this.et = intent.getLongExtra("object_create_ts", 0L);
            this.f10298io = intent.getBooleanExtra("is_adm", false);
            this.n = intent.getStringExtra("multi_process_key");
            this.x = intent.getIntExtra("key_video_cache_callback", -1);
            String stringExtra = intent.getStringExtra("_client_bidding_aution_price");
            this.xv = TextUtils.isEmpty(stringExtra) ? null : Double.valueOf(Double.parseDouble(stringExtra));
        }
    }

    public void xj(int i, boolean z) {
        p(i);
        if (z) {
            tf(i);
        }
    }

    public void xj(float f, float f2, float f3, float f4, int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.z;
        if (kdVar == null || kdVar.xj() == null) {
            return;
        }
        int measuredWidth = this.z.xj().getMeasuredWidth();
        int measuredHeight = this.z.xj().getMeasuredHeight();
        if (this.f10297a.r() instanceof com.bytedance.sdk.openadsdk.core.video.hf.xj ? ((com.bytedance.sdk.openadsdk.core.video.hf.xj) this.f10297a.r()).aq() : false) {
            this.z.xj().animate().translationY(-((1.0f - f2) * measuredHeight)).setDuration(i).start();
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(i);
        this.z.xj().startAnimation(scaleAnimation);
    }

    public Map<String, Object> xj(ws wsVar) {
        HashMap hashMap = new HashMap();
        String str = this.yy;
        if (str != null) {
            hashMap.put("rit_scene", str);
        }
        hashMap.put("insert_ad_control", Integer.valueOf(j.xj(wsVar)));
        hashMap.put("carousel_pos", Integer.valueOf(j.u(wsVar)));
        hashMap.put("refresh_ad_control", Integer.valueOf(j.hf(wsVar)));
        if (this.dq.hf() != 0) {
            hashMap.put("carousel_type", Integer.valueOf(this.dq.hf()));
        } else if (vm.f(wsVar)) {
            hashMap.put("carousel_type", 4);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.hf.w wVar = this.r;
        if (wVar != null) {
            wVar.xj(hashMap);
        }
        return hashMap;
    }

    public void xj(ws wsVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        this.l.xj(wsVar, hfVar);
        this.wo.xj(wsVar);
    }

    public void xj(int i, int i2) {
        this.dq.xj(i, i2, 0);
    }

    public void xj(int i, int i2, int i3) {
        this.dq.xj(i, i2, i3);
    }
}
