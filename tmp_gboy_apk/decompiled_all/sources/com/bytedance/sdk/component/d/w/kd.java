package com.bytedance.sdk.component.d.w;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.zg;
import com.czhj.sdk.common.Constants;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private Context c;
    private u f;
    private hf kd;
    private boolean u;
    private int v;
    private xj w;
    private long hf = 0;
    private boolean y = false;
    private int d = 0;
    private long tf = 19700101000L;
    private int p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private HashMap<String, Integer> f10200pl = new HashMap<>();
    private HashMap<String, Integer> g = new HashMap<>();
    private int am = 0;
    private HashMap<String, Integer> qt = new HashMap<>();
    private HashMap<String, Integer> zg = new HashMap<>();
    private boolean e = true;
    private Map<String, Integer> yo = new HashMap();
    Handler xj = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.d.w.kd.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            kd.this.hf(message.arg1 != 0);
        }
    };

    private kd() {
    }

    private void d() {
        SharedPreferences hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(this.c, xj(), 0);
        this.d = hf.getInt("tnc_probe_cmd", 0);
        this.tf = hf.getLong("tnc_probe_version", 19700101000L);
    }

    private void tf() {
        com.bytedance.sdk.component.d.u.w.hf("TNCManager", "resetTNCControlState");
        this.p = 0;
        this.f10200pl.clear();
        this.g.clear();
        this.am = 0;
        this.qt.clear();
        this.zg.clear();
    }

    private boolean xj(int i) {
        return i >= 200 && i < 400;
    }

    public Map<String, String> c() {
        w y = y();
        if (y != null) {
            return y.u;
        }
        return null;
    }

    public u f() {
        return this.f;
    }

    public xj hf() {
        return this.w;
    }

    public void kd() {
        this.yo.clear();
    }

    public hf u() {
        return this.kd;
    }

    public boolean w() {
        return this.u;
    }

    public w y() {
        u uVar = this.f;
        if (uVar != null) {
            return uVar.w();
        }
        return null;
    }

    private void hf(String str) {
        Map<String, String> c;
        if (TextUtils.isEmpty(str) || (c = c()) == null || !c.containsValue(str)) {
            return;
        }
        if (this.yo.get(str) == null) {
            this.yo.put(str, 1);
        } else {
            this.yo.put(str, Integer.valueOf(this.yo.get(str).intValue() + 1));
        }
    }

    private boolean u(String str) {
        Map<String, String> c = c();
        if (c == null) {
            return false;
        }
        String str2 = c.get(str);
        if (TextUtils.isEmpty(str2) || this.yo.get(str2) == null || this.yo.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.component.d.u.w.hf("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(str)));
        return true;
    }

    private void w(String str) {
        if (!TextUtils.isEmpty(str) && this.yo.containsKey(str)) {
            this.yo.put(str, 0);
        }
    }

    public String xj() {
        return "ttnet_tnc_config" + this.v;
    }

    public void xj(boolean z) {
        this.u = z;
    }

    public void xj(hf hfVar) {
        this.kd = hfVar;
    }

    public synchronized void xj(Context context, boolean z) {
        try {
            if (!this.y) {
                this.c = context;
                this.e = z;
                this.f = new u(context, z, this.v);
                if (z) {
                    d();
                }
                com.bytedance.sdk.component.d.u.w.hf("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.d + " probeVersion: " + this.tf);
                this.w = c.xj().xj(this.v, this.c);
                this.y = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(boolean z) {
        if (y() == null) {
            return;
        }
        com.bytedance.sdk.component.d.u.w.hf("TNCManager", "doUpdateRemote, ".concat(String.valueOf(z)));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z) {
            if ((r0.p * 1000) + this.hf > elapsedRealtime) {
                com.bytedance.sdk.component.d.u.w.hf("TNCManager", "doUpdateRemote, time limit");
                return;
            }
        }
        this.hf = elapsedRealtime;
        c.xj().xj(this.v, this.c).w();
    }

    public kd(int i) {
        this.v = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String xj(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto Lca
            java.lang.String r0 = "/network/get_network"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Lca
            java.lang.String r0 = "/get_domains/v4"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Lca
            java.lang.String r0 = "/ies/speed"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L20
            goto Lca
        L20:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L31
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r1.getProtocol()     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r1.getHost()     // Catch: java.lang.Throwable -> L2f
            goto L36
        L2f:
            r1 = move-exception
            goto L33
        L31:
            r1 = move-exception
            r2 = r0
        L33:
            com.bytedance.sdk.component.utils.pl.xj(r1)
        L36:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto Lca
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4c
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lca
        L4c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L54
            goto Lca
        L54:
            boolean r1 = r6.u(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L6a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "handleHostMapping, TNC host faild num over limit: "
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.d.u.w.hf(r3, r0)
            return r7
        L6a:
            java.util.Map r1 = r6.c()
            if (r1 == 0) goto Lbd
            boolean r4 = r1.containsKey(r0)
            if (r4 != 0) goto L77
            goto Lbd
        L77:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L84
            goto Lca
        L84:
            java.lang.String r4 = "handleHostMapping, match, origin: "
            java.lang.String r4 = r4.concat(r7)
            com.bytedance.sdk.component.d.u.w.hf(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "://"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = ADYaiT.CtFAbx.AlLFFp(r2, r5, r1)
            boolean r2 = r7.startsWith(r0)
            if (r2 == 0) goto Laf
            java.lang.String r7 = r7.replaceFirst(r0, r1)
        Laf:
            java.lang.String r0 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "handleHostMapping, target: "
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.d.u.w.hf(r3, r0)
            return r7
        Lbd:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "handleHostMapping, nomatch: "
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.d.u.w.hf(r3, r0)
        Lca:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.w.kd.xj(java.lang.String):java.lang.String");
    }

    private boolean hf(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        w y = y();
        return (y == null || TextUtils.isEmpty(y.g) || !y.g.contains(String.valueOf(i))) ? false : true;
    }

    public synchronized void xj(am amVar, zg zgVar) {
        URL url;
        if (amVar == null || zgVar == null) {
            return;
        }
        if (this.e) {
            if (com.bytedance.sdk.component.d.u.y.xj(this.c)) {
                try {
                    url = amVar.hf().xj();
                } catch (Exception unused) {
                    url = null;
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String xj = xj(amVar);
                int w = zgVar.w();
                if (Constants.HTTP.equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(xj)) {
                        return;
                    }
                    com.bytedance.sdk.component.d.u.w.hf("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + xj + "#" + w);
                    w y = y();
                    if (y != null && y.hf) {
                        xj(zgVar, host);
                    }
                    if (y == null) {
                        return;
                    }
                    com.bytedance.sdk.component.d.u.w.hf("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + xj + "#" + w + " " + this.p + "#" + this.f10200pl.size() + "#" + this.g.size() + " " + this.am + "#" + this.qt.size() + "#" + this.zg.size());
                    if (w > 0) {
                        if (xj(w)) {
                            if (this.p > 0 || this.am > 0) {
                                tf();
                            }
                            w(host);
                            return;
                        }
                        if (!hf(w)) {
                            this.am++;
                            this.qt.put(path, 0);
                            this.zg.put(xj, 0);
                            if (this.am >= y.f && this.qt.size() >= y.d && this.zg.size() >= y.tf) {
                                com.bytedance.sdk.component.d.u.w.hf("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + xj + "#" + w);
                                xj(false, 0L);
                                tf();
                            }
                            hf(host);
                        }
                    }
                }
            }
        }
    }

    private String xj(am amVar) {
        if (amVar != null && amVar.hf() != null && amVar.hf().xj() != null) {
            try {
                return InetAddress.getByName(amVar.hf().xj().getHost()).getHostAddress();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public synchronized void xj(am amVar, Exception exc) {
        URL url;
        if (amVar != null) {
            if (amVar.hf() != null && exc != null) {
                if (this.e) {
                    if (com.bytedance.sdk.component.d.u.y.xj(this.c)) {
                        try {
                            url = amVar.hf().xj();
                        } catch (Exception unused) {
                            url = null;
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String xj = xj(amVar);
                        if (Constants.HTTP.equals(protocol) || "https".equals(protocol)) {
                            w y = y();
                            if (y == null) {
                                return;
                            }
                            com.bytedance.sdk.component.d.u.w.hf("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + xj + "# " + this.p + "#" + this.f10200pl.size() + "#" + this.g.size() + " " + this.am + "#" + this.qt.size() + "#" + this.zg.size());
                            this.p = this.p + 1;
                            this.f10200pl.put(path, 0);
                            this.g.put(xj, 0);
                            if (this.p >= y.kd && this.f10200pl.size() >= y.y && this.g.size() >= y.c) {
                                com.bytedance.sdk.component.d.u.w.hf("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + xj);
                                xj(false, 0L);
                                tf();
                            }
                            hf(host);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(com.bytedance.sdk.component.hf.xj.zg r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.w.kd.xj(com.bytedance.sdk.component.hf.xj.zg, java.lang.String):void");
    }

    private void xj(boolean z, long j) {
        if (this.xj.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.xj.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.xj.sendMessageDelayed(obtainMessage, j);
        } else {
            this.xj.sendMessage(obtainMessage);
        }
    }
}
