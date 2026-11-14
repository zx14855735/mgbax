package com.bytedance.sdk.openadsdk.core.w;

import ADYaiT.CtFAbx;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.Logger;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.a.p;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.a.x;
import com.bytedance.sdk.openadsdk.core.pz;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class w {
    private static volatile w hf;
    private volatile boolean f;
    private SharedPreferences tf;
    private AtomicBoolean xj = new AtomicBoolean(false);
    private AtomicBoolean w = new AtomicBoolean(false);
    private AtomicInteger u = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger kd = new AtomicInteger(Integer.MAX_VALUE);
    private volatile String y = null;
    private AtomicInteger c = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger d = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger p = new AtomicInteger(Integer.MAX_VALUE);

    /* renamed from: pl, reason: collision with root package name */
    private AtomicInteger f10459pl = new AtomicInteger(Integer.MAX_VALUE);

    private w() {
    }

    private void am() {
        com.bytedance.sdk.openadsdk.core.io.xj xjVar = new com.bytedance.sdk.openadsdk.core.io.xj();
        tf.hf(xjVar);
        tf.xj();
        tf.u(xjVar);
        tf.xj(xjVar);
        tf.kd(xjVar);
        tf.w(xjVar);
        tf.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        boolean w = w();
        if (w) {
            com.bytedance.sdk.openadsdk.core.component.splash.xj.u.u();
            u.xj();
            hf.xj();
        }
        try {
            if (!com.bytedance.sdk.openadsdk.core.u.xj.w()) {
                String xj = xj("/api/ad/union/ping");
                if (!TextUtils.isEmpty(xj)) {
                    com.bytedance.sdk.component.d.hf.w w2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
                    w2.xj(xj);
                    w2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.w.w.2
                        @Override // com.bytedance.sdk.component.d.xj.xj
                        public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                        }

                        @Override // com.bytedance.sdk.component.d.xj.xj
                        public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        if (w) {
            p.xj(3, false);
            xj.xj(pz.getContext(), 3);
            dk.y();
            am();
            x.xj(259200000L);
        }
    }

    private SharedPreferences pl() {
        return com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext(), "sp_bidding_opt_libra", 0);
    }

    private boolean xj(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        return i2 == 3 && i != 5;
    }

    public int c() {
        try {
            if (this.d.get() == Integer.MAX_VALUE) {
                if (this.xj.get()) {
                    this.d.set(com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_req_build_opt", 1));
                } else {
                    if (this.tf == null) {
                        this.tf = pl();
                    }
                    this.d.set(this.tf.getInt("key_req_build_opt", 1));
                }
            }
            return this.d.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean d() {
        try {
            if (this.f10459pl.get() == Integer.MAX_VALUE) {
                if (this.xj.get()) {
                    this.f10459pl.set(com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "boost_save_config", 0));
                } else {
                    if (this.tf == null) {
                        this.tf = pl();
                    }
                    this.f10459pl.set(this.tf.getInt("boost_save_config", 0));
                }
                Logger.i("bstsdk", "isBstTwConf get: " + this.f10459pl.get());
            }
        } catch (Throwable unused) {
        }
        return this.f10459pl.get() == 1;
    }

    public boolean f() {
        try {
            if (this.p.get() == Integer.MAX_VALUE) {
                if (this.xj.get()) {
                    this.p.set(com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "_use_pl_", 0));
                } else {
                    if (this.tf == null) {
                        this.tf = pl();
                    }
                    this.p.set(this.tf.getInt("_use_pl_", 0));
                }
            }
        } catch (Throwable unused) {
        }
        return this.p.get() == 1;
    }

    public int kd() {
        try {
            if (this.kd.get() == Integer.MAX_VALUE) {
                if (this.xj.get()) {
                    this.kd.set(com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_net_queue_limit", 7));
                } else {
                    if (this.tf == null) {
                        this.tf = pl();
                    }
                    this.kd.set(this.tf.getInt("key_net_queue_limit", 7));
                }
            }
            return this.kd.get();
        } catch (Throwable unused) {
            return 7;
        }
    }

    public void p() {
        c.xj(new d("advance_init_rb") { // from class: com.bytedance.sdk.openadsdk.core.w.w.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (w.this.w.get()) {
                        return;
                    }
                    w.this.w.set(true);
                    w.this.g();
                } catch (Throwable unused) {
                }
            }
        }, 10);
    }

    public void tf() {
        try {
            com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra");
            SharedPreferences.Editor edit = pl().edit();
            edit.clear();
            edit.apply();
            this.u.set(0);
            this.kd.set(7);
            this.d.set(0);
        } catch (Throwable unused) {
        }
    }

    public String u() {
        try {
            if (TextUtils.isEmpty(this.y)) {
                if (this.xj.get()) {
                    this.y = com.bytedance.sdk.component.c.w.xj.hf.hf("sp_bidding_opt_libra", "key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                } else {
                    if (this.tf == null) {
                        this.tf = pl();
                    }
                    this.y = this.tf.getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                }
            }
        } catch (Throwable unused) {
        }
        this.y = TextUtils.isEmpty(this.y) ? "api-access.pangolin-sdk-toutiao.com" : this.y;
        return this.y;
    }

    public boolean w() {
        try {
            if (this.u.get() == Integer.MAX_VALUE) {
                if (this.xj.get()) {
                    this.u.set(com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_req_body_opt", 1));
                } else {
                    if (this.tf == null) {
                        this.tf = pl();
                    }
                    this.u.set(this.tf.getInt("key_req_body_opt", 1));
                }
            }
        } catch (Throwable unused) {
        }
        return this.u.get() == 1;
    }

    public int y() {
        try {
            if (this.c.get() == Integer.MAX_VALUE) {
                if (this.xj.get()) {
                    this.c.set(com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_network_module", 1));
                } else {
                    if (this.tf == null) {
                        this.tf = pl();
                    }
                    this.c.set(this.tf.getInt("key_network_module", 1));
                }
            }
            return this.c.get();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public boolean hf() {
        if (!this.f) {
            this.xj.set(com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_support_multiprocess", 2) == 1);
            this.f = true;
        }
        return this.xj.get();
    }

    public static w xj() {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new w();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public void xj(boolean z) {
        this.xj.set(z);
        if (z) {
            xj("key_support_multiprocess", 1);
        }
    }

    private void xj(String str, int i) {
        try {
            if (this.xj.get()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", str, Integer.valueOf(i));
                return;
            }
            if (this.tf == null) {
                this.tf = pl();
            }
            SharedPreferences.Editor edit = this.tf.edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    private void xj(String str, String str2) {
        try {
            if (this.xj.get()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", str, str2);
                return;
            }
            if (this.tf == null) {
                this.tf = pl();
            }
            SharedPreferences.Editor edit = this.tf.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static String xj(String str) {
        String u = xj().u();
        if (TextUtils.isEmpty(u)) {
            return null;
        }
        return CtFAbx.BI9f7h("https://", u, str);
    }

    public void xj(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
            this.y = optString;
            JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
            if (optJSONObject == null) {
                if (com.bytedance.sdk.openadsdk.core.u.xj.y()) {
                    return;
                }
                xj("key_url_ads", optString);
                return;
            }
            int optInt = optJSONObject.optInt("network_module", 1);
            int optInt2 = optJSONObject.optInt("if_req_body_opt", 1);
            this.u.set(optInt2);
            int optInt3 = optJSONObject.optInt("net_queue_limit", 7);
            this.kd.set(optInt3);
            int optInt4 = optJSONObject.optInt("req_build_opt", 0);
            this.d.set(optInt4);
            boolean optBoolean = optJSONObject.optBoolean("_use_pl_", false);
            int optInt5 = optJSONObject.optInt("boost_save_config", 0);
            this.f10459pl.set(optInt5);
            if (com.bytedance.sdk.openadsdk.core.u.xj.y()) {
                return;
            }
            if (this.xj.get()) {
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_network_module", Integer.valueOf(optInt));
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_req_body_opt", Integer.valueOf(optInt2));
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_net_queue_limit", Integer.valueOf(optInt3));
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_req_build_opt", Integer.valueOf(optInt4));
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "_use_pl_", Integer.valueOf(optBoolean ? 1 : 0));
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "key_url_ads", optString);
                com.bytedance.sdk.component.c.w.xj.hf.xj("sp_bidding_opt_libra", "boost_save_config", Integer.valueOf(optInt5));
                return;
            }
            if (this.tf == null) {
                this.tf = pl();
            }
            SharedPreferences.Editor edit = this.tf.edit();
            edit.putInt("key_network_module", optInt);
            edit.putInt("key_req_body_opt", optInt2);
            edit.putInt("key_net_queue_limit", optInt3);
            edit.putInt("key_req_build_opt", optInt4);
            edit.putInt("_use_pl_", optBoolean ? 1 : 0);
            edit.putString("key_url_ads", optString);
            edit.putInt("boost_save_config", optInt5);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    public boolean xj(int i) {
        if (i <= 0) {
            return false;
        }
        return xj(i, c());
    }
}
