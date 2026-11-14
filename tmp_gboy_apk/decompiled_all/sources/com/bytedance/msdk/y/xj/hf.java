package com.bytedance.msdk.y.xj;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.api.u.p;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.xj.xj.u;
import com.bytedance.msdk.xj.xj.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf {
    private final Set<String> hf = new CopyOnWriteArraySet();
    private boolean w = false;
    private w xj;

    private synchronized void w(p pVar) {
        try {
            if (this.w || !com.bytedance.msdk.y.hf.xj.u(hf())) {
                String w = w();
                if (!TextUtils.isEmpty(w)) {
                    throw new Exception("adn init ".concat(String.valueOf(w)));
                }
                Map<String, Object> xj = xj();
                if (xj == null) {
                    throw new Exception("adn init getConfig() is null");
                }
                xj.put(MediationConstant.EXTRA_ADN_NAME, hf());
                xj.put("q_x_c", Integer.valueOf(com.bytedance.msdk.c.xj.xj.xj().u()));
                xj.put("wf_q_x_c", Integer.valueOf(com.bytedance.msdk.c.xj.xj.xj().kd()));
                u xj2 = com.bytedance.msdk.y.hf.hf.xj().xj(hf(), pVar);
                if (xj2 == null) {
                    throw new Exception("configuration is null");
                }
                xj(xj2, xj);
                if (!this.w) {
                    com.bytedance.msdk.y.hf.xj.w(hf());
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
            com.bytedance.msdk.y.hf.xj.xj(hf(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, th.toString()));
        }
    }

    public abstract String hf();

    public void u() {
        hf((p) null);
    }

    public abstract String w();

    public abstract Map<String, Object> xj();

    private void hf(p pVar) {
        com.bytedance.msdk.core.tf.xj xj = com.bytedance.msdk.core.hf.hf().xj(hf());
        if (pVar == null && xj == null && !MediationConstant.ADN_PANGLE.equals(hf())) {
            return;
        }
        w(pVar);
    }

    public void xj(p pVar) {
        this.w = true;
        hf(pVar);
    }

    public void xj(p pVar, w wVar) {
        this.xj = wVar;
        this.w = true;
        hf(pVar);
    }

    private synchronized void xj(u uVar, Map<String, Object> map) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.xj.kd.w.xj("TMe", "--==--time: start " + hf());
        uVar.xj(com.bytedance.msdk.core.hf.getContext(), map, new w() { // from class: com.bytedance.msdk.y.xj.hf.1
            @Override // com.bytedance.msdk.xj.xj.w
            public void xj() {
                if (hf.this.xj != null) {
                    hf.this.xj.xj();
                }
                if (TextUtils.equals(hf.this.hf(), MediationConstant.ADN_PANGLE)) {
                    dk.xj();
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                com.bytedance.msdk.xj.kd.w.xj("TMe", "--==--time: " + hf.this.hf() + ", ----==----- " + elapsedRealtime2);
                if (!hf.this.hf.contains(hf.this.hf())) {
                    hf.this.hf.add(hf.this.hf());
                    ai.w(hf.this.hf(), elapsedRealtime2);
                }
                com.bytedance.msdk.y.hf.xj.xj(hf.this.hf(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
            }

            @Override // com.bytedance.msdk.xj.xj.w
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (hf.this.xj != null) {
                    hf.this.xj.xj(xjVar);
                }
                if (xjVar != null) {
                    com.bytedance.msdk.y.hf.xj.xj(hf.this.hf(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + xjVar.xj + " errorMessage = " + xjVar.hf));
                }
            }
        });
    }
}
