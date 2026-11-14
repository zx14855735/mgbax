package com.bytedance.msdk.core.admanager.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.am;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.f.l;
import com.bytedance.msdk.hf.w;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.d.hf.kd;
import com.bytedance.sdk.component.d.hf.u;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.windad.WindAds;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private w am;
    private com.bytedance.msdk.api.w.xj c;
    private hf e;
    private com.bytedance.msdk.api.xj.hf g;
    private int hf;
    private long qt;
    private int w;
    private String zg;
    private boolean u = false;
    private boolean kd = false;
    private long y = -1;
    private boolean f = false;
    private boolean d = false;
    private boolean tf = true;
    private int p = -1;

    /* renamed from: pl, reason: collision with root package name */
    private String f10121pl = "";
    AtomicInteger xj = new AtomicInteger(1);

    /* renamed from: com.bytedance.msdk.core.admanager.reward.xj$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xj.this.u) {
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经destroy, 直接return");
                return;
            }
            xj.this.f = true;
            if (xj.this.c != null) {
                if (xj.this.e == null || xj.this.d) {
                    return;
                }
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经有结果，直接给开发者回调");
                xj.this.d = true;
                xj.this.e.xj(xj.this.c);
                return;
            }
            if (xj.this.y == -1) {
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，先进来发起请求");
                xj.this.y = SystemClock.elapsedRealtime();
                if (xj.this.tf) {
                    xj.this.c();
                } else {
                    com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                }
            } else if (SystemClock.elapsedRealtime() - xj.this.y > 2000) {
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，后进来但大于2s，发起请求");
                if (xj.this.tf) {
                    xj.this.c();
                } else {
                    com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                }
            }
            y.xj(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.xj.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (xj.this.u) {
                        com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，已经destroy了, 直接return");
                        return;
                    }
                    if (xj.this.e == null || xj.this.d) {
                        return;
                    }
                    com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，给开发者verify回调");
                    xj.this.d = true;
                    com.bytedance.msdk.api.w.xj xjVar = new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.core.admanager.reward.xj.3.1.1
                        @Override // com.bytedance.msdk.api.w.xj
                        public float hf() {
                            if (xj.this.g != null) {
                                return xj.this.g.z();
                            }
                            return 0.0f;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public Map<String, Object> u() {
                            HashMap hashMap = new HashMap();
                            hashMap.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                            hashMap.put("transId", xj.this.zg);
                            hashMap.put(MediationConstant.KEY_REASON, 0);
                            hashMap.put("gromoreExtra", (xj.this.g == null || xj.this.g.r() == null) ? "" : xj.this.g.r().get("gromoreExtra"));
                            hashMap.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(xj.this.p));
                            hashMap.put(MediationConstant.KEY_ERROR_MSG, xj.this.f10121pl);
                            com.bytedance.msdk.api.w xj = am.xj(xj.this.g, xj.this.am, true);
                            hashMap.put(MediationConstant.KEY_ADN_NAME, xj != null ? xj.pl() : "");
                            hashMap.put("ecpm", xj != null ? xj.g() : "");
                            return hashMap;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public String w() {
                            return xj.this.g != null ? xj.this.g.q() : "";
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public boolean xj() {
                            return false;
                        }
                    };
                    hf hfVar = xj.this.e;
                    if (xj.this.c != null) {
                        xjVar = xj.this.c;
                    }
                    hfVar.xj(xjVar);
                }
            }, 3000L);
        }
    }

    public interface hf {
        void xj(com.bytedance.msdk.api.w.xj xjVar);
    }

    /* renamed from: com.bytedance.msdk.core.admanager.reward.xj$xj, reason: collision with other inner class name */
    public class RunnableC0053xj implements Runnable {
        private final int hf;

        public RunnableC0053xj(int i) {
            this.hf = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xj.this.c != null || xj.this.d || !xj.this.tf || xj.this.u || xj.this.kd) {
                return;
            }
            com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify 进行第" + this.hf + "次重试请求");
            xj.this.c();
        }
    }

    public xj(String str) {
        com.bytedance.msdk.core.tf.hf xj;
        com.bytedance.msdk.core.am.w hf2 = com.bytedance.msdk.core.hf.hf();
        if (hf2 != null && (xj = hf2.xj(str, 7, 101)) != null) {
            this.hf = xj.eu();
            this.w = xj.tj();
        }
        if (this.hf < 0) {
            this.hf = 15000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        kd hf2 = com.bytedance.msdk.u.hf.xj().hf().hf();
        hf2.xj(com.bytedance.msdk.core.w.u());
        final long currentTimeMillis = System.currentTimeMillis();
        String f = com.bytedance.msdk.core.xj.p().f();
        if (!TextUtils.isEmpty(f)) {
            hf2.hf("X-Tt-Env", f);
            hf2.hf("x-use-ppe", "1");
        }
        hf2.hf("User-Agent", com.bytedance.msdk.hf.hf.xj);
        boolean w = com.bytedance.msdk.core.hf.hf().w();
        final boolean z = !w;
        if (w) {
            hf2.w(xj(false));
        } else {
            hf2.hf("x-pglcypher", "4");
            hf2.xj("application/octet-stream", l.hf(xj(true)));
        }
        hf2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.msdk.core.admanager.reward.xj.7
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(u uVar, final com.bytedance.sdk.component.d.hf hfVar) {
                y.xj(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.xj.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        xj.this.xj(hfVar, z, currentTimeMillis);
                    }
                });
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(u uVar, final IOException iOException) {
                y.xj(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.xj.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + iOException.toString());
                        xj.this.xj(-2, "request error" + iOException.getMessage(), z);
                    }
                });
            }
        });
    }

    private void y() {
        com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- showListen回调进来，开始计时");
        y.xj(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.xj.6
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.y != -1 || xj.this.u || xj.this.kd) {
                    com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，已经destroy，或者skip，或者比complete/verify回调还晚，直接return");
                    return;
                }
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，发起请求");
                xj.this.c();
                y.xj(xj.this.new RunnableC0053xj(1), 3000L);
                y.xj(xj.this.new RunnableC0053xj(2), 6000L);
                y.xj(xj.this.new RunnableC0053xj(3), 9000L);
            }
        }, this.hf);
    }

    public void kd() {
        y.xj(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.xj.4
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.u) {
                    com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经destroy, 直接return");
                    return;
                }
                if (xj.this.c != null || xj.this.d) {
                    StringBuilder sb = new StringBuilder("--==-- complete回调进来，已经有响应(");
                    sb.append(xj.this.c != null);
                    sb.append(")或已经给出开发者回调(");
                    sb.append(xj.this.d);
                    sb.append("), 直接return");
                    com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", sb.toString());
                    return;
                }
                if (xj.this.y == -1) {
                    com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，先进来发起请求");
                    xj.this.y = SystemClock.elapsedRealtime();
                    if (xj.this.tf) {
                        xj.this.c();
                        return;
                    } else {
                        com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                        return;
                    }
                }
                if (SystemClock.elapsedRealtime() - xj.this.y > 2000) {
                    com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，后进来但大于2s，发起请求");
                    if (xj.this.tf) {
                        xj.this.c();
                    } else {
                        com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                    }
                }
            }
        });
    }

    public void hf() {
        y.xj(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.xj.1
            @Override // java.lang.Runnable
            public void run() {
                xj.this.kd = true;
            }
        });
    }

    public void u() {
        y.xj(new AnonymousClass3());
    }

    public void w() {
        y.xj(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.xj.2
            @Override // java.lang.Runnable
            public void run() {
                xj.this.u = true;
            }
        });
    }

    public boolean xj() {
        boolean z = this.w == 1;
        com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- 判断是否开启了M服务端激励验证： ".concat(String.valueOf(z)));
        return z;
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, w wVar) {
        this.qt = System.currentTimeMillis();
        this.g = hfVar;
        this.am = wVar;
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.component.d.hf hfVar, boolean z, long j) {
        if (this.u) {
            return;
        }
        if (hfVar == null) {
            com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify netResponse is null");
            xj(-1, "response is null", z);
            return;
        }
        int xj = hfVar.xj();
        if (l.xj(hfVar)) {
            String xj2 = l.xj(hfVar.tf());
            if (TextUtils.isEmpty(xj2)) {
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data v4 is null");
                xj(xj, "data is empty", z);
                return;
            }
            try {
                this.p = 20000;
                xj(new JSONObject(xj2), z, j);
                return;
            } catch (Throwable th) {
                pl.xj(th);
                this.p = 1;
                xj(-1, th.getMessage(), z);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(hfVar.u());
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString("message");
            this.p = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
            this.f10121pl = jSONObject.optString("desc");
            int i = this.p;
            if (i == 50001) {
                this.tf = true;
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: 50001，请求媒体服务端失败，需要重试");
                xj(this.p, this.f10121pl, z);
                return;
            }
            if (i != 0 && i != 20000) {
                this.tf = false;
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: " + this.p + ", msg: " + this.f10121pl + "，不能再重试");
                xj(this.p, this.f10121pl, z);
                return;
            }
            if (optInt < 0 || TextUtils.isEmpty(optString)) {
                com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify cypher error or message is null");
                xj(xj, "message is null", z);
                return;
            }
            JSONObject jSONObject2 = null;
            if (optInt == 2) {
                String xj3 = l.xj(optString);
                if (!TextUtils.isEmpty(xj3)) {
                    jSONObject2 = new JSONObject(xj3);
                }
            } else if (optInt == 1) {
                String hf2 = com.bytedance.msdk.f.xj.hf(optString, com.bytedance.msdk.f.hf.xj());
                if (!TextUtils.isEmpty(hf2)) {
                    jSONObject2 = new JSONObject(hf2);
                }
            } else if (optInt == 0) {
                jSONObject2 = new JSONObject(optString);
            }
            xj(jSONObject2, z, j);
        } catch (Throwable th2) {
            xj(-1, th2.getMessage(), z);
        }
    }

    private void xj(JSONObject jSONObject, boolean z, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (jSONObject == null) {
            com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data is null");
            xj(-1, "data is null", z);
            return;
        }
        com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- data: " + jSONObject.toString());
        final boolean optBoolean = jSONObject.optBoolean("is_verify");
        final int optInt = jSONObject.optInt(MediationConstant.KEY_REASON);
        final String optString = jSONObject.optString(MediationConstant.REWARD_NAME);
        final int optInt2 = jSONObject.optInt(MediationConstant.REWARD_AMOUNT);
        this.c = new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.core.admanager.reward.xj.5
            @Override // com.bytedance.msdk.api.w.xj
            public float hf() {
                return optInt2;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public Map<String, Object> u() {
                HashMap hashMap = new HashMap();
                hashMap.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                hashMap.put("transId", xj.this.zg);
                hashMap.put(MediationConstant.KEY_REASON, Integer.valueOf(optInt));
                hashMap.put("gromoreExtra", (xj.this.g == null || xj.this.g.r() == null) ? "" : xj.this.g.r().get("gromoreExtra"));
                hashMap.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(xj.this.p));
                hashMap.put(MediationConstant.KEY_ERROR_MSG, xj.this.f10121pl);
                com.bytedance.msdk.api.w xj = am.xj(xj.this.g, xj.this.am, true);
                hashMap.put(MediationConstant.KEY_ADN_NAME, xj != null ? xj.pl() : "");
                hashMap.put("ecpm", xj != null ? xj.g() : "");
                return hashMap;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public String w() {
                return optString;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public boolean xj() {
                return optBoolean;
            }
        };
        if (this.f && this.e != null && !this.d) {
            com.bytedance.msdk.xj.kd.w.xj("GROMORE_SS_REWARD_VERIFY", "--==-- verify接口请求回来，给开发者verify回调");
            this.d = true;
            this.e.xj(this.c);
        }
        xj(z, currentTimeMillis);
    }

    private void xj(boolean z, long j) {
        ai.xj(z ? "v4Enc_reward" : "v2Enc_reward", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, String str, boolean z) {
        ai.xj(z ? "v4Enc_reward" : "v2Enc_reward", false, 0L, "code = " + i + "，msg = " + str);
    }

    private String xj(boolean z) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, com.bytedance.msdk.hf.hf.hf());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.hf.hf.u());
            jSONObject.put("user_agent", com.bytedance.msdk.hf.hf.xj);
            jSONObject.put("try_value", this.xj.getAndIncrement());
            jSONObject.put("network", dk.kd());
            jSONObject.put("play_start_ts", this.qt);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            com.bytedance.msdk.api.xj.hf hfVar = this.g;
            jSONObject.put("user_id", hfVar != null ? hfVar.en() : "");
            if (TextUtils.isEmpty(this.zg)) {
                str = UUID.randomUUID().toString();
                this.zg = str;
            } else {
                str = this.zg;
            }
            jSONObject.put(WindAds.TRANS_ID, str);
            com.bytedance.msdk.api.xj.hf hfVar2 = this.g;
            jSONObject.put("link_id", hfVar2 != null ? hfVar2.xj() : "");
            com.bytedance.msdk.api.xj.hf hfVar3 = this.g;
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, hfVar3 != null ? hfVar3.ra() : "");
            w wVar = this.am;
            jSONObject.put("adn_rit", wVar != null ? wVar.cy() : "");
            com.bytedance.msdk.api.xj.hf hfVar4 = this.g;
            jSONObject.put(MediationConstant.REWARD_NAME, hfVar4 != null ? hfVar4.q() : "");
            com.bytedance.msdk.api.xj.hf hfVar5 = this.g;
            jSONObject.put(MediationConstant.REWARD_AMOUNT, hfVar5 != null ? hfVar5.z() : 0);
            com.bytedance.msdk.api.xj.hf hfVar6 = this.g;
            jSONObject.put("media_extra", (hfVar6 == null || hfVar6.r() == null) ? "" : this.g.r().get("gromoreExtra"));
            com.bytedance.msdk.api.xj.hf hfVar7 = this.g;
            if (hfVar7 != null && hfVar7.dk() != null) {
                jSONObject.put("scenario_id", this.g.dk());
            }
            com.bytedance.msdk.api.w xj = am.xj(this.g, this.am, true);
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, xj != null ? xj.pl() : "");
            jSONObject.put("ecpm", xj != null ? xj.g() : "");
        } catch (JSONException e) {
            pl.xj(e);
        }
        if (z) {
            return jSONObject.toString();
        }
        return l.xj(jSONObject).toString();
    }

    public void xj(hf hfVar) {
        this.e = hfVar;
    }
}
