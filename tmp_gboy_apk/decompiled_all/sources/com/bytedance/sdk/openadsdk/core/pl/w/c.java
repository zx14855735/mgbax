package com.bytedance.sdk.openadsdk.core.pl.w;

import android.content.Context;
import android.os.Message;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends kd {

    /* renamed from: io, reason: collision with root package name */
    private Map<String, Object> f10386io;

    public c(Context context, ws wsVar, String str, boolean z) {
        super(context, wsVar, str, z);
    }

    private void e() {
        com.bytedance.sdk.openadsdk.core.ra.kd vh = this.kd.vh();
        if (vh != null) {
            this.f10386io.put("download_url", vh.hf());
        }
        this.f10386io.put("download_status_listener", this.et);
        this.f10386io.put("event_tag", this.y);
        this.f10386io.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.c.1
            @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
            public boolean xj(Map<String, Object> map) {
                c cVar = c.this;
                Context context = cVar.getContext();
                c cVar2 = c.this;
                return cVar.xj(context, cVar2.kd, cVar2.y);
            }
        });
        this.f10386io.put("download_popup_manager", f());
        this.f10386io.put("download_manager_hash_code", Integer.valueOf(hashCode()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public void f(boolean z) {
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.y, this.kd, (JSONObject) null, c());
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.kd, c(), z);
        this.f10386io = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd, com.bytedance.sdk.openadsdk.core.pl.hf.w
    public Map<String, Object> kd() {
        return this.f10386io;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public synchronized void p() {
        try {
            if (this.u == null) {
                return;
            }
            if (this.ht != null && ai.w >= 6400 && !ai.c()) {
                com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj((com.bytedance.sdk.openadsdk.core.pl.xj.u) null, c());
            }
            AtomicBoolean atomicBoolean = this.tf;
            if (atomicBoolean != null && atomicBoolean.get()) {
                this.tf.set(false);
                if (this.ht != null) {
                    this.ht.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(4).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(c()))).hf());
                }
            }
            tf();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public boolean qt() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void u() {
        if (this.u == null) {
            return;
        }
        this.tf.set(false);
        Function<SparseArray<Object>, Object> function = this.ht;
        if (function != null) {
            function.apply(A2egSU.AZOQYO(8, Void.class).xj(0, new en().xj("force", Boolean.TRUE).xj("hashCode", Integer.valueOf(c()))).hf());
        }
        zg();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public boolean w(JSONObject jSONObject, boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd, com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public boolean y() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public synchronized void zg() {
        e();
        this.tf.set(true);
        if (this.ht != null) {
            this.ht.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(5).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(c())).xj("downloadStatusChangeListener", com.bytedance.sdk.openadsdk.zg.w.u.xj(this.et))).hf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd, com.bytedance.sdk.openadsdk.core.pl.hf.w
    public boolean w() {
        Function<SparseArray<Object>, Object> function = this.ht;
        return function != null && com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(function, c()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd, com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(ws wsVar, boolean z) {
        if (getContext() == null) {
            return;
        }
        xj(wo.v(wsVar), z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public void y(boolean z) {
        this.f10386io.put("convert_from_landing_page", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void w(boolean z) {
        this.f10386io.put("is_open_oppo_market_auto_download", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd, com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(int i) {
        this.f10386io.put("need_check_compliance", Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(JSONObject jSONObject, boolean z) {
        wo.x();
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.kd);
        hashMap.put("context", pz.getContext());
        hashMap.put("is_market_covert", Boolean.valueOf(w()));
        com.bytedance.sdk.openadsdk.core.ra.kd vh = this.kd.vh();
        if (vh != null) {
            hashMap.put("download_url", vh.hf());
        }
        Map<String, Object> map = this.f10386io;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("download_status_listener", this.et);
        hashMap.put("event_tag", this.y);
        hashMap.put(n.l, Integer.valueOf(wo.hf(this.y)));
        hashMap.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.d.xj.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.c.2
            @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
            public boolean xj(Map<String, Object> map2) {
                c cVar = c.this;
                Context context = cVar.getContext();
                c cVar2 = c.this;
                return cVar.xj(context, cVar2.kd, cVar2.y);
            }
        });
        hashMap.put("download_popup_manager", f());
        hashMap.putAll(com.bytedance.sdk.component.p.kd.xj.xj().xj(this.kd.hashCode() + this.kd.zf()));
        hashMap.put("convert_from_downloader", Boolean.TRUE);
        hashMap.put("download_manager_hash_code", Integer.valueOf(c()));
        hashMap.put("is_feed_register_direct_download", Boolean.valueOf(z));
        HashMap hashMap2 = new HashMap();
        hashMap.put("download_manager_hash_code", Integer.valueOf(c()));
        com.bytedance.sdk.openadsdk.core.d.xj.u.xj.xj(this.kd, hashMap2, "clickEvent", hashMap, this.y, new HashMap());
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd, com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void u(boolean z) {
        this.dk = z;
        this.f10386io.put("is_click_button", Boolean.valueOf(z));
    }
}
