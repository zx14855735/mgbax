package com.bytedance.sdk.component.d.w;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.d.xj;
import com.bytedance.sdk.component.tf.tf;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.pl;
import com.kuaishou.weapon.p0.bi;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements ai.xj {
    private static ThreadPoolExecutor d;
    private static boolean f;
    private int am;
    private com.bytedance.sdk.component.d.xj g;
    private final boolean hf;
    private final Context p;
    private volatile boolean w = false;
    private boolean u = true;
    private boolean kd = false;
    private long y = 0;
    private long c = 0;
    private AtomicBoolean tf = new AtomicBoolean(false);

    /* renamed from: pl, reason: collision with root package name */
    private volatile boolean f10202pl = false;
    final ai xj = com.bytedance.sdk.component.tf.hf.xj.xj().xj(this, "tt-net");

    public xj(Context context, int i) {
        this.p = context;
        this.hf = e.xj(context);
        this.am = i;
    }

    public static ThreadPoolExecutor c() {
        if (d == null) {
            synchronized (xj.class) {
                try {
                    if (d == null) {
                        com.bytedance.sdk.component.tf.u.u uVar = new com.bytedance.sdk.component.tf.u.u(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new tf("tnc/AppConfig"));
                        d = uVar;
                        uVar.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return d;
    }

    private com.bytedance.sdk.component.d.xj d() {
        if (this.g == null) {
            xj.C0109xj c0109xj = new xj.C0109xj();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.g = c0109xj.xj(10L, timeUnit).hf(10L, timeUnit).w(10L, timeUnit).xj();
        }
        return this.g;
    }

    private boolean f() {
        String[] y = y();
        if (y != null && y.length != 0) {
            xj(0);
        }
        return false;
    }

    private void u(boolean z) {
        if (this.kd) {
            return;
        }
        if (this.u) {
            this.u = false;
            this.y = 0L;
            this.c = 0L;
        }
        long j = z ? 360000L : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.y > j) {
            if (currentTimeMillis - this.c > 120000 || !this.f10202pl) {
                w();
            }
        }
    }

    public Context getContext() {
        return this.p;
    }

    public void kd() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.hf) {
                u();
            } else {
                hf();
            }
        } catch (Throwable unused) {
        }
    }

    public boolean w() {
        com.bytedance.sdk.component.d.u.w.hf("TNCManager", "doRefresh: updating state " + this.tf.get());
        c().execute(new Runnable() { // from class: com.bytedance.sdk.component.d.w.xj.2
            @Override // java.lang.Runnable
            public void run() {
                boolean xj = com.bytedance.sdk.component.d.u.y.xj(xj.this.p);
                if (xj) {
                    xj.this.c = System.currentTimeMillis();
                    if (xj.this.tf.compareAndSet(false, true)) {
                        xj.this.w(xj);
                    } else {
                        com.bytedance.sdk.component.d.u.w.hf("TNCManager", "doRefresh, already running");
                    }
                }
            }
        });
        return true;
    }

    public String[] y() {
        String[] y = c.xj().xj(this.am).u() != null ? c.xj().xj(this.am).u().y() : null;
        return (y == null || y.length <= 0) ? new String[0] : y;
    }

    public static void hf(boolean z) {
        f = z;
    }

    public void w(boolean z) {
        com.bytedance.sdk.component.d.u.w.hf("TNCManager", "doRefresh, actual request");
        u();
        this.kd = true;
        if (!z) {
            this.xj.sendEmptyMessage(102);
            return;
        }
        try {
            f();
        } catch (Exception unused) {
            this.tf.set(false);
        }
    }

    public synchronized void hf() {
        if (System.currentTimeMillis() - this.y > bi.s) {
            this.y = System.currentTimeMillis();
            try {
                if (c.xj().xj(this.am).f() != null) {
                    c.xj().xj(this.am).f().hf();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void xj() {
        xj(false);
    }

    public synchronized void xj(boolean z) {
        if (this.hf) {
            u(z);
            return;
        }
        if (this.y <= 0) {
            try {
                c().execute(new Runnable() { // from class: com.bytedance.sdk.component.d.w.xj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.hf();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void u() {
        if (this.f10202pl) {
            return;
        }
        this.f10202pl = true;
        long j = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(this.p, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j > currentTimeMillis) {
            j = currentTimeMillis;
        }
        this.y = j;
        try {
            if (c.xj().xj(this.am).f() != null) {
                c.xj().xj(this.am).f().xj();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(int i) {
        ai aiVar = this.xj;
        if (aiVar != null) {
            aiVar.sendEmptyMessage(i);
        }
    }

    public static void xj(Context context, int i) {
        xj xj;
        if (f && (xj = c.xj().xj(i, context)) != null) {
            if (e.xj(context)) {
                xj.xj(true);
            } else {
                xj.xj();
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i = message.what;
        if (i == 101) {
            this.kd = false;
            this.y = System.currentTimeMillis();
            com.bytedance.sdk.component.d.u.w.hf("TNCManager", "doRefresh, succ");
            if (this.u) {
                xj();
            }
            this.tf.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.kd = false;
        if (this.u) {
            xj();
        }
        com.bytedance.sdk.component.d.u.w.hf("TNCManager", "doRefresh, error");
        this.tf.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(Object obj) {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!cb.o.equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(PointParamKey.DATA);
        synchronized (this) {
            SharedPreferences.Editor edit = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(this.p, "ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (c.xj().xj(this.am).f() == null) {
            return true;
        }
        c.xj().xj(this.am).f().xj(jSONObject2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final int i) {
        String[] y = y();
        if (y != null && y.length > i) {
            String str = y[i];
            if (TextUtils.isEmpty(str)) {
                hf(102);
                return;
            }
            try {
                String xj = xj(str);
                if (TextUtils.isEmpty(xj)) {
                    hf(102);
                    return;
                }
                com.bytedance.sdk.component.d.hf.w w = d().w();
                w.xj(xj);
                xj(w);
                w.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.component.d.w.xj.3
                    @Override // com.bytedance.sdk.component.d.xj.xj
                    public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                        JSONObject jSONObject;
                        if (hfVar == null || !hfVar.f()) {
                            xj.this.xj(i + 1);
                            return;
                        }
                        String str2 = null;
                        try {
                            jSONObject = new JSONObject(hfVar.u());
                        } catch (Exception unused) {
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            xj.this.xj(i + 1);
                            return;
                        }
                        try {
                            str2 = jSONObject.getString("message");
                        } catch (Exception unused2) {
                        }
                        if (!cb.o.equals(str2)) {
                            xj.this.xj(i + 1);
                            return;
                        }
                        try {
                            if (xj.this.xj(jSONObject)) {
                                xj.this.hf(101);
                            } else {
                                xj.this.xj(i + 1);
                            }
                        } catch (Exception unused3) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.d.xj.xj
                    public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                        xj.this.xj(i + 1);
                    }
                });
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.d.u.w.hf("AppConfig", "try app config exception: ".concat(String.valueOf(th)));
                return;
            }
        }
        hf(102);
    }

    private String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return CtFAbx.BI9f7h("https://", str, "/get_domains/v4/");
    }

    private void xj(com.bytedance.sdk.component.d.hf.w wVar) {
        if (wVar == null) {
            return;
        }
        Address xj = c.xj().xj(this.am).u() != null ? c.xj().xj(this.am).u().xj(this.p) : null;
        if (xj != null && xj.hasLatitude() && xj.hasLongitude()) {
            StringBuilder sb = new StringBuilder();
            sb.append(xj.getLatitude());
            wVar.xj("latitude", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(xj.getLongitude());
            wVar.xj("longitude", sb2.toString());
            String locality = xj.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                wVar.xj("city", Uri.encode(locality));
            }
        }
        if (this.w) {
            wVar.xj("force", "1");
        }
        try {
            wVar.xj("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable th) {
            pl.xj(th);
        }
        if (c.xj().xj(this.am).u() != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(c.xj().xj(this.am).u().xj());
            wVar.xj("aid", sb3.toString());
            wVar.xj("device_platform", c.xj().xj(this.am).u().w());
            wVar.xj("channel", c.xj().xj(this.am).u().hf());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(c.xj().xj(this.am).u().u());
            wVar.xj("version_code", sb4.toString());
            wVar.xj("custom_info_1", c.xj().xj(this.am).u().kd());
        }
    }

    public static void xj(ThreadPoolExecutor threadPoolExecutor) {
        d = threadPoolExecutor;
    }
}
