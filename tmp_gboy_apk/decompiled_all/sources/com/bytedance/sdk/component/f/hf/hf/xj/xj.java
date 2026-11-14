package com.bytedance.sdk.component.f.hf.hf.xj;

import com.bytedance.sdk.component.f.hf.hf.hf;
import com.bytedance.sdk.component.f.xj.f;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.u;
import com.bytedance.sdk.component.utils.pl;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private StringBuffer xj = new StringBuffer();
    private AtomicLong hf = new AtomicLong(0);
    private AtomicLong w = new AtomicLong(0);
    private AtomicLong u = new AtomicLong(0);
    private AtomicLong kd = new AtomicLong(0);
    private AtomicLong y = new AtomicLong(0);
    private AtomicLong c = new AtomicLong(0);
    private AtomicLong f = new AtomicLong(0);
    private AtomicLong d = new AtomicLong(0);
    private AtomicLong tf = new AtomicLong(0);
    private AtomicLong p = new AtomicLong(0);

    /* renamed from: pl, reason: collision with root package name */
    private AtomicLong f10204pl = new AtomicLong(0);
    private AtomicLong g = new AtomicLong(0);
    private AtomicLong am = new AtomicLong(0);
    private AtomicLong qt = new AtomicLong(0);
    private AtomicLong zg = new AtomicLong(0);
    private AtomicLong e = new AtomicLong(0);
    private AtomicLong yo = new AtomicLong(0);
    private AtomicLong v = new AtomicLong(0);
    private AtomicLong jk = new AtomicLong(0);
    private AtomicLong pz = new AtomicLong(0);
    private AtomicLong ht = new AtomicLong(0);
    private AtomicLong ra = new AtomicLong(0);
    private AtomicLong dk = new AtomicLong(0);

    public AtomicLong am() {
        return this.y;
    }

    public AtomicLong c() {
        return this.d;
    }

    public AtomicLong d() {
        return this.w;
    }

    public AtomicLong dk() {
        return this.v;
    }

    public AtomicLong e() {
        return this.tf;
    }

    public StringBuffer et() {
        return this.xj;
    }

    public AtomicLong f() {
        return this.kd;
    }

    public AtomicLong g() {
        return this.u;
    }

    public AtomicLong hf() {
        return this.ra;
    }

    public AtomicLong ht() {
        return this.e;
    }

    public AtomicLong jk() {
        return this.qt;
    }

    public AtomicLong kd() {
        return this.g;
    }

    public AtomicLong p() {
        return this.jk;
    }

    public AtomicLong pl() {
        return this.hf;
    }

    public AtomicLong pz() {
        return this.zg;
    }

    public AtomicLong qt() {
        return this.c;
    }

    public AtomicLong ra() {
        return this.yo;
    }

    public AtomicLong tf() {
        return this.p;
    }

    public AtomicLong u() {
        return this.pz;
    }

    public AtomicLong v() {
        return this.am;
    }

    public AtomicLong w() {
        return this.ht;
    }

    public AtomicLong xj() {
        return this.dk;
    }

    public synchronized void y() {
        g().set(0L);
        pz().set(0L);
        ht().set(0L);
        jk().set(0L);
        dk().set(0L);
        ra().set(0L);
        v().set(0L);
        yo().set(0L);
        zg().set(0L);
        pl().set(0L);
        am().set(0L);
        e().set(0L);
        qt().set(0L);
        tf().set(0L);
        f().set(0L);
        d().set(0L);
        c().set(0L);
        p().set(0L);
        u().set(0L);
        w().set(0L);
        hf().set(0L);
        xj().set(0L);
        try {
            if (this.xj.length() != 0) {
                this.xj.setLength(0);
            }
        } catch (Exception unused) {
        }
    }

    public AtomicLong yo() {
        return this.f10204pl;
    }

    public AtomicLong zg() {
        return this.f;
    }

    public synchronized void xj(long j) {
        this.hf.getAndAdd(j);
        this.w.incrementAndGet();
    }

    public JSONObject xj(long j, kd kdVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j2 = d().get();
            long j3 = 1;
            jSONObject.put("create_save_cost_ts_avg", (pl().get() * 1.0f) / (j2 == 0 ? 1L : j2));
            jSONObject.put("save_success_count", j2);
            long j4 = f().get();
            jSONObject.put("save_upload_cost_ts_avg", (g().get() * 1.0f) / (j4 == 0 ? 1L : j4));
            jSONObject.put("will_send_count", j4);
            jSONObject.put("sdk_event_index", j);
            jSONObject.put("sdk_send_success_count", this.g.get());
            jSONObject.put("all_delete_count", am().get());
            jSONObject.put("success_delete_count", qt().get());
            jSONObject.put("invalid_delete_count", zg().get());
            jSONObject.put("will_save_count", e().get());
            jSONObject.put("did_send_count", tf().get());
            jSONObject.put("send_success_valid_count", yo().get());
            long j5 = c().get();
            jSONObject.put("send_success_invalid_count", v().get());
            jSONObject.put("send_fail_count", j5);
            jSONObject.put("before_save_count", p().get());
            jSONObject.put("success_tm", u().get());
            jSONObject.put("queue_timeout_tm", w().get());
            jSONObject.put("after_upload_tm", hf().get());
            jSONObject.put("quit_tm", xj().get());
            long j6 = pz().get();
            long j7 = ht().get();
            jSONObject.put("success_request_cost_ts_avg", (ra().get() * 1.0f) / (j6 == 0 ? 1L : j6));
            float f = dk().get() * 1.0f;
            if (j7 != 0) {
                j3 = j7;
            }
            jSONObject.put("fail_request_cost_ts_avg", f / j3);
            jSONObject.put("request_count", jk().get());
            jSONObject.put("request_success_count", j6);
            jSONObject.put("request_fail_count", j7);
            jSONObject.put("is_multi_process", kdVar.p());
            jSONObject.put("app_start_time", hf.w);
            jSONObject.put("app_first_time", hf.u);
            jSONObject.put("fail_code_list", this.xj.toString());
            u u = kdVar.u();
            if (u != null) {
                jSONObject.put("is_debug", u.xj());
                f pl2 = u.pl();
                if (pl2 != null) {
                    jSONObject.put("is_plugin", pl2.f());
                    return jSONObject;
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return jSONObject;
    }
}
