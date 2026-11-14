package com.sigmob.sdk.base;

import B4ZgIw.AYUAbz;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.v;
import com.sigmob.sdk.base.models.config.SigmobAndroid;
import com.sigmob.sdk.base.models.config.SigmobAntiFraudLogConfig;
import com.sigmob.sdk.base.models.config.SigmobCommon;
import com.sigmob.sdk.base.models.config.SigmobCommonEndpointsConfig;
import com.sigmob.sdk.base.models.config.SigmobDialogSetting;
import com.sigmob.sdk.base.models.config.SigmobMotionConfig;
import com.sigmob.sdk.base.models.config.SigmobNativeConfig;
import com.sigmob.sdk.base.models.config.SigmobRvConfig;
import com.sigmob.sdk.base.models.config.SigmobSdkConfig;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigResponse;
import com.sigmob.sdk.base.models.config.SigmobSplashConfig;
import com.sigmob.sdk.base.network.f;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.sdk.base.utils.s;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f13203a = null;
    private static final String b = "sdkConfigVer";
    private static o c;
    private static boolean d;
    private static String m;
    private static boolean n;
    private a l;
    private final String g = n.k;
    private long i = 0;
    private SigmobSdkConfig j = null;
    private SigmobSdkConfig k = null;
    private final Handler e = new Handler(Looper.getMainLooper());
    private final Runnable f = new com.fl.saas.common.crash.A2egSU(2, this);
    private final boolean h = true;

    /* renamed from: com.sigmob.sdk.base.o$1, reason: invalid class name */
    public class AnonymousClass1 implements f.a {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(SigmobSdkConfig sigmobSdkConfig) {
            o.this.a(sigmobSdkConfig, true);
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            String unused = o.m = o.this.ao();
            if (o.n) {
                o.this.as();
            } else {
                boolean unused2 = o.n = true;
                o.this.e.post(o.this.f);
            }
            SigmobLog.e(volleyError.toString());
        }

        @Override // com.sigmob.sdk.base.network.f.a
        public void a(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
            boolean unused = o.n = false;
            SigmobLog.d(sigmobSdkConfigResponse.toString());
            final SigmobSdkConfig sigmobSdkConfig = sigmobSdkConfigResponse.config;
            if (sigmobSdkConfig == null) {
                SigmobLog.e(sigmobSdkConfigResponse.error_message);
            } else {
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.A2egSU
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.AnonymousClass1.this.a(sigmobSdkConfig);
                    }
                });
                o.this.a(sigmobSdkConfig);
            }
            o.this.as();
        }
    }

    public interface a {
        void onUpdate(boolean z);
    }

    private o() {
        ak();
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            try {
                if (c == null) {
                    c = new o();
                }
                oVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    private void ak() {
        if (this.j == null) {
            SigmobSdkConfig.Builder builder = new SigmobSdkConfig.Builder();
            SigmobCommon.Builder builder2 = new SigmobCommon.Builder();
            SigmobAndroid.Builder builder3 = new SigmobAndroid.Builder();
            SigmobCommonEndpointsConfig.Builder builder4 = new SigmobCommonEndpointsConfig.Builder();
            builder4.native_ad(t());
            builder2.endpoints(builder4.build());
            SigmobRvConfig.Builder builder5 = new SigmobRvConfig.Builder();
            builder5.cacheTop(4);
            builder2.rv_config(builder5.build());
            builder2.configRefresh(1000);
            Boolean bool = Boolean.FALSE;
            builder2.disable_up_location(bool);
            builder2.is_gdpr_region(bool);
            builder2.enable_debug_level(bool);
            Boolean bool2 = Boolean.TRUE;
            builder3.disable_boot_mark(bool2);
            builder3.disableUpAppInfo(bool2);
            builder3.oaid_api_is_disable(bool2);
            builder3.enable_permission(bool);
            builder3.enable_report_crash(bool);
            builder.common_config(builder2.build());
            builder.android_config(builder3.build());
            this.j = builder.build();
        }
        SigmobLog.d("Default config: " + this.j.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (com.sigmob.sdk.b.e() == null) {
            return;
        }
        if (ClientMetadata.getInstance().isNetworkConnected(c()) && i.a().i()) {
            an();
        } else {
            SigmobLog.d("Can't load an ad because there is no network connectivity.");
            as();
        }
    }

    private boolean am() {
        SigmobCommon p = p();
        if (p == null) {
            return false;
        }
        return ((Boolean) Wire.get(p.log_enc, Boolean.FALSE)).booleanValue();
    }

    private void an() {
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        com.sigmob.sdk.base.network.f fVar = new com.sigmob.sdk.base.network.f(c(), new AnonymousClass1());
        if (sigRequestQueue == null) {
            SigmobLog.e("queue is null");
            as();
        } else {
            sigRequestQueue.add(fVar);
            SigmobLog.i("update sdk config");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ao() {
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig;
        SigmobCommon p = p();
        return (p == null || (sigmobCommonEndpointsConfig = p.endpoints) == null) ? "" : (String) Wire.get(sigmobCommonEndpointsConfig.config, "https://c.etoolads.cn/s/config");
    }

    private int ap() {
        SigmobCommon p = p();
        if (p == null) {
            return 0;
        }
        return ((Integer) Wire.get(p.network_timeout, 0)).intValue();
    }

    private boolean aq() {
        if (!q.b((Object) f13203a)) {
            SigmobCommon p = p();
            if (p == null) {
                return false;
            }
            f13203a = (Boolean) Wire.get(p.noncompliance_mark, Boolean.FALSE);
            SigmobLog.d("noncomplianceMark(config) = " + f13203a);
        }
        return f13203a.booleanValue();
    }

    private void ar() {
        this.e.removeCallbacks(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as() {
        ar();
        if (this.h) {
            this.e.postDelayed(this.f, Math.max(30000L, this.i));
        }
    }

    private SigmobSplashConfig at() {
        SigmobCommon p = p();
        if (p == null) {
            return null;
        }
        return p.splash_config;
    }

    private SigmobNativeConfig au() {
        SigmobCommon p = p();
        if (p == null) {
            return null;
        }
        return p.native_config;
    }

    public static boolean n() {
        return d;
    }

    public long A() {
        SigmobSplashConfig at = at();
        int intValue = at != null ? ((Integer) Wire.get(at.material_expired_time, 2)).intValue() : 2;
        return intValue < 0 ? intValue : intValue * 86400000;
    }

    public int B() {
        SigmobNativeConfig au = au();
        if (au == null) {
            return 50;
        }
        return ((Integer) Wire.get(au.cacheTop, 50)).intValue();
    }

    public long C() {
        SigmobNativeConfig au = au();
        if (au == null) {
            return 45000L;
        }
        int intValue = ((Integer) Wire.get(au.ad_load_timeout, 45)).intValue();
        if (intValue < 10) {
            intValue = 10;
        }
        return intValue * 1000;
    }

    public boolean D() {
        SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig;
        SigmobCommon p = p();
        return (p == null || (sigmobAntiFraudLogConfig = p.anti_fraud_log) == null || sigmobAntiFraudLogConfig.events == null) ? false : true;
    }

    public int E() {
        SigmobMotionConfig sigmobMotionConfig;
        SigmobCommon p = p();
        if (!D() || (sigmobMotionConfig = p.anti_fraud_log.motion_config) == null) {
            return 0;
        }
        return ((Integer) Wire.get(sigmobMotionConfig.interval, 0)).intValue();
    }

    public int F() {
        if (!D() || p().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return ((Integer) Wire.get(p().anti_fraud_log.motion_config.count, 0)).intValue();
    }

    public int G() {
        if (!D() || p().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return p().anti_fraud_log.motion_config.queue_max.intValue() + (-50) < p().anti_fraud_log.motion_config.count.intValue() * 2 ? (((Integer) Wire.get(p().anti_fraud_log.motion_config.count, 0)).intValue() * 2) + 50 : ((Integer) Wire.get(p().anti_fraud_log.motion_config.queue_max, 0)).intValue();
    }

    public long H() {
        long intValue = p() != null ? ((Integer) Wire.get(p().tracking_expiration_time, 86400)).intValue() : 86400L;
        if (intValue < 180) {
            return 180L;
        }
        return intValue;
    }

    public int I() {
        int intValue = p() != null ? ((Integer) Wire.get(p().tracking_retry_interval, 180)).intValue() : 180;
        if (intValue < 10) {
            return 10;
        }
        return intValue;
    }

    public int J() {
        Integer num = SigmobCommon.DEFAULT_MAX_SEND_LOG_RECORDS;
        int intValue = num.intValue();
        if (p() != null) {
            intValue = ((Integer) Wire.get(p().max_send_log_records, num)).intValue();
        }
        return intValue < 10 ? num.intValue() : intValue;
    }

    public int K() {
        int intValue;
        if (p() == null || (intValue = ((Integer) Wire.get(p().send_log_interval, 3)).intValue()) < 3) {
            return 3;
        }
        return intValue;
    }

    public boolean L() {
        SigmobAndroid q;
        if (j() || (q = q()) == null) {
            return false;
        }
        return ((Boolean) Wire.get(q.enable_open_pkg_list, Boolean.FALSE)).booleanValue();
    }

    public boolean M() {
        SigmobAndroid q;
        if (j() || (q = q()) == null) {
            return false;
        }
        return ((Boolean) Wire.get(q.enable_open_pkg_dir_list, Boolean.FALSE)).booleanValue();
    }

    public Boolean N() {
        o a2 = a();
        return Boolean.valueOf(a2.L() || a2.M());
    }

    public List<Integer> O() {
        SigmobCommon p = p();
        if (p == null) {
            return null;
        }
        return p.dclog_blacklist;
    }

    public boolean P() {
        SigmobCommon p = p();
        if (p == null) {
            return false;
        }
        return ((Boolean) Wire.get(p.enable_debug_level, Boolean.FALSE)).booleanValue();
    }

    public long Q() {
        SigmobCommon p = p();
        if (p == null) {
            return 0L;
        }
        long intValue = ((Integer) Wire.get(p.load_interval, 0)).intValue();
        if (intValue < 1) {
            return 0L;
        }
        return intValue * 1000;
    }

    public String R() {
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig;
        SigmobCommon p = p();
        if (p == null || (sigmobCommonEndpointsConfig = p.endpoints) == null) {
            return "";
        }
        String str = (String) Wire.get(sigmobCommonEndpointsConfig.native_ad, "");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, str.indexOf(63) == -1 ? "?" : "&");
        A5SV6n2.append(b());
        return A5SV6n2.toString();
    }

    public boolean S() {
        SigmobCommon p;
        if (j() || (p = p()) == null) {
            return true;
        }
        return ((Boolean) Wire.get(p.disable_up_location, Boolean.FALSE)).booleanValue();
    }

    public boolean T() {
        SigmobAndroid q;
        if (j() || (q = q()) == null) {
            return true;
        }
        return ((Boolean) Wire.get(q.disableUpAppInfo, Boolean.FALSE)).booleanValue();
    }

    public int U() {
        SigmobAndroid q = q();
        if (q == null) {
            return 0;
        }
        return ((Integer) Wire.get(q.report_log, 0)).intValue();
    }

    public List<String> V() {
        SigmobAndroid q = q();
        return q == null ? Collections.EMPTY_LIST : q.open_pkg_list;
    }

    public boolean W() {
        SigmobAndroid q = q();
        return q != null && ((Integer) Wire.get(q.up_wifi_list_interval, 0)).intValue() >= 60;
    }

    public int X() {
        SigmobAndroid q = q();
        if (q == null) {
            return 0;
        }
        return ((Integer) Wire.get(q.disable_up_oaid, 0)).intValue();
    }

    public boolean Y() {
        SigmobAndroid q = q();
        if (q == null) {
            return false;
        }
        return ((Boolean) Wire.get(q.enable_permission, Boolean.FALSE)).booleanValue();
    }

    public int Z() {
        SigmobAndroid q = q();
        if (q == null) {
            return 0;
        }
        return ((Integer) Wire.get(q.apk_expired_time, 0)).intValue();
    }

    public boolean aa() {
        SigmobAndroid q = q();
        if (q == null) {
            return false;
        }
        return ((Boolean) Wire.get(q.enable_report_crash, Boolean.FALSE)).booleanValue();
    }

    public boolean ab() {
        SigmobAndroid q = q();
        if (q == null) {
            return true;
        }
        return ((Boolean) Wire.get(q.oaid_api_is_disable, Boolean.FALSE)).booleanValue();
    }

    public boolean ac() {
        return false;
    }

    public boolean ad() {
        SigmobAndroid q;
        if (j() || (q = q()) == null) {
            return true;
        }
        return ((Boolean) Wire.get(q.disable_install_monitor, Boolean.FALSE)).booleanValue();
    }

    public int ae() {
        SigmobAndroid q = q();
        if (q == null) {
            return 0;
        }
        return ((Integer) Wire.get(q.enable_app_list, 0)).intValue();
    }

    public boolean af() {
        SigmobAndroid q = q();
        if (q == null) {
            return true;
        }
        return ((Boolean) Wire.get(q.disable_boot_mark, Boolean.FALSE)).booleanValue();
    }

    public boolean ag() {
        SigmobAndroid q = q();
        if (q == null) {
            return false;
        }
        return ((Boolean) Wire.get(q.use_web_source_cache, Boolean.FALSE)).booleanValue();
    }

    public boolean ah() {
        SigmobCommon p = p();
        if (p == null) {
            return false;
        }
        return ((Boolean) Wire.get(p.enable_extra_dclog, Boolean.FALSE)).booleanValue();
    }

    public int ai() {
        SigmobAndroid q = q();
        if (q == null) {
            return 0;
        }
        return ((Integer) Wire.get(q.web_source_cache_expiration_time, 0)).intValue();
    }

    public Boolean b(String str) {
        boolean b2;
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        Context e = com.sigmob.sdk.b.e();
        boolean L = L();
        boolean M = M();
        if (L) {
            b2 = v.a(e, str);
        } else {
            if (!M) {
                return Boolean.FALSE;
            }
            b2 = v.b(e, str);
        }
        return Boolean.valueOf(b2);
    }

    public void e() {
        ObjectInputStream objectInputStream = null;
        String a2 = s.a(com.sigmob.sdk.b.e(), (String) null, b, (String) null);
        File file = new File(com.sigmob.sdk.base.utils.k.a() + "/config");
        if (n.k.equals(a2)) {
            try {
                if (file.exists()) {
                    try {
                        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file));
                        try {
                            a(SigmobSdkConfig.ADAPTER.decode(objectInputStream2), false);
                            objectInputStream2.close();
                        } catch (Throwable th) {
                            th = th;
                            objectInputStream = objectInputStream2;
                            try {
                                a(this.j, false);
                                SigmobLog.e(th.getMessage());
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Throwable th3) {
                                        SigmobLog.e(th3.getMessage());
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    return;
                }
            } catch (Throwable th5) {
                SigmobLog.e(th5.getMessage());
                return;
            }
        }
        a(this.j, false);
    }

    public void f() {
        ar();
        this.e.post(this.f);
    }

    public boolean g() {
        SigmobCommon p = p();
        if (p == null) {
            return false;
        }
        return ((Boolean) Wire.get(p.feedback_debug, Boolean.FALSE)).booleanValue();
    }

    public boolean h() {
        SigmobAndroid q = q();
        if (q == null) {
            return false;
        }
        return ((Boolean) Wire.get(q.lock_play, Boolean.FALSE)).booleanValue();
    }

    public boolean i() {
        SigmobAndroid q = q();
        if (q == null) {
            return false;
        }
        return ((Boolean) Wire.get(q.screen_keep, Boolean.FALSE)).booleanValue();
    }

    public boolean j() {
        return !aq();
    }

    public int k() {
        SigmobCommon p = p();
        if (p == null) {
            return 0;
        }
        int intValue = ((Integer) Wire.get(p.expire_monitor_interval, 0)).intValue();
        SigmobLog.d("expireMonitorInterval = " + intValue);
        return intValue;
    }

    public boolean l() {
        SigmobCommon p = p();
        if (p == null) {
            return false;
        }
        return ((Boolean) Wire.get(p.enable_active_expire, Boolean.FALSE)).booleanValue();
    }

    public int m() {
        SigmobCommon p = p();
        if (p == null) {
            return 0;
        }
        Integer num = (Integer) Wire.get(p.sniffing_type, 0);
        SigmobLog.d("sniffingType = " + num);
        return num.intValue();
    }

    public SigmobSdkConfig o() {
        SigmobSdkConfig sigmobSdkConfig = this.k;
        return sigmobSdkConfig == null ? this.j : sigmobSdkConfig;
    }

    public SigmobCommon p() {
        SigmobSdkConfig o = o();
        if (o == null) {
            return null;
        }
        return o.sigmobCommon_config;
    }

    public SigmobAndroid q() {
        SigmobSdkConfig o = o();
        if (o == null) {
            return null;
        }
        return o.sigmobAndroid_config;
    }

    public String r() {
        String str = p().endpoints.log;
        if (TextUtils.isEmpty(str)) {
            str = "https://dc.sigmob.cn/log";
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, str.indexOf(63) == -1 ? "?" : "&");
        A5SV6n2.append(b());
        return A5SV6n2.toString();
    }

    public String s() {
        String str = (String) Wire.get(p().endpoints.feedback, "https://adxtool.sigmob.cn/debug/feedback");
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, str.indexOf(63) == -1 ? "?" : "&");
        A5SV6n2.append(b());
        return A5SV6n2.toString();
    }

    public String t() {
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig;
        SigmobCommon p = p();
        String str = (p == null || (sigmobCommonEndpointsConfig = p.endpoints) == null) ? "" : sigmobCommonEndpointsConfig.ads;
        if (TextUtils.isEmpty(str)) {
            str = "https://adservice.sigmob.cn/ad/v4";
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, str.indexOf(63) == -1 ? "?" : "&");
        A5SV6n2.append(b());
        return A5SV6n2.toString();
    }

    public String u() {
        String str = p().endpoints.hb_ads;
        if (TextUtils.isEmpty(str)) {
            str = "https://adservice.sigmob.cn/hb/v2/ad";
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, str.indexOf(63) == -1 ? "?" : "&");
        A5SV6n2.append(b());
        return A5SV6n2.toString();
    }

    public SigmobRvConfig v() {
        SigmobCommon p = p();
        if (p == null) {
            return null;
        }
        return p.rv_config;
    }

    public int w() {
        SigmobRvConfig v = v();
        if (v == null) {
            return 5;
        }
        return ((Integer) Wire.get(v.cacheTop, 5)).intValue();
    }

    public long x() {
        SigmobRvConfig v = v();
        if (v == null) {
            return 45000L;
        }
        int intValue = ((Integer) Wire.get(v.ad_load_timeout, 45)).intValue();
        if (intValue < 10) {
            intValue = 10;
        }
        return intValue * 1000;
    }

    public SigmobDialogSetting y() {
        SigmobRvConfig v = v();
        if (v == null) {
            return null;
        }
        return v.close_dialog_setting;
    }

    public int z() {
        SigmobSplashConfig at = at();
        if (at == null) {
            return 50;
        }
        return ((Integer) Wire.get(at.cacheTop, 50)).intValue();
    }

    public static String b() {
        return "appId=" + WindAds.sharedAds().getAppId() + "&sdkVersion=4.24.7";
    }

    public static String c() {
        StringBuilder sb;
        String str;
        if (TextUtils.isEmpty(m)) {
            sb = !TextUtils.isEmpty("https://adservice.sigmob.cn/s/config") ? new StringBuilder("https://adservice.sigmob.cn/s/config?") : new StringBuilder("https://adservice.sigmob.cn/s/config?");
        } else {
            if (m.indexOf(63) == -1) {
                sb = new StringBuilder();
                sb.append(m);
                str = "?";
            } else {
                sb = new StringBuilder();
                sb.append(m);
                str = "&";
            }
            sb.append(str);
        }
        sb.append(b());
        return sb.toString();
    }

    public static String d() {
        return "https://adservice.sigmob.cn/extconfig?" + b();
    }

    public o a(a aVar) {
        this.l = aVar;
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SigmobSdkConfig sigmobSdkConfig) {
        ObjectOutputStream objectOutputStream;
        if (sigmobSdkConfig == null) {
            return;
        }
        File file = new File(com.sigmob.sdk.base.utils.k.a() + "/config");
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                } catch (IOException e) {
                    SigmobLog.e(e.getMessage());
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            sigmobSdkConfig.encode(objectOutputStream);
            s.b(com.sigmob.sdk.b.e(), (String) null, b, n.k);
            objectOutputStream.close();
        } catch (IOException e3) {
            e = e3;
            objectOutputStream2 = objectOutputStream;
            SigmobLog.e(e.getMessage());
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e4) {
                    SigmobLog.e(e4.getMessage());
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SigmobSdkConfig sigmobSdkConfig, boolean z) {
        SigmobCommon sigmobCommon;
        if (sigmobSdkConfig == null || (sigmobCommon = sigmobSdkConfig.sigmobCommon_config) == null) {
            return;
        }
        this.k = sigmobSdkConfig;
        this.i = ((Integer) Wire.get(sigmobCommon.configRefresh, 1800)).intValue() * 1000;
        int k = k();
        if (k <= 0) {
            com.sigmob.sdk.manager.d.a().c();
        } else {
            com.sigmob.sdk.manager.d.a().a(k);
        }
        SigmobLog.d("config: " + sigmobSdkConfig);
        a aVar = this.l;
        if (aVar != null) {
            aVar.onUpdate(z);
        }
        Config.sharedInstance().setEnable_okhttp3(ac());
        Config.sharedInstance().setNetworkTimeout(ap());
        Config.sharedInstance().update(d, af(), ab(), X(), r(), K(), J(), am());
        TrackManager.getInstance().setRetryInterval(I());
        TrackManager.getInstance().setRetryExpiredTime(H());
    }

    public boolean a(String str) {
        List<String> list;
        SigmobCommon p = p();
        if (!D() || (list = p.anti_fraud_log.events) == null) {
            return false;
        }
        return list.contains(str);
    }
}
