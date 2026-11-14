package com.bytedance.sdk.openadsdk.xj.xj;

import Qn9ulQ.A2egSU;
import Qn9ulQ.A4TApA;
import Qn9ulQ.A5SV6n;
import Qn9ulQ.ADYaiT;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.ra;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.qt.u;
import com.volcengine.mobsecBiz.matrix.pgla;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ms.bz.bd.c.Pgl.m0;
import ms.bz.bd.c.Pgl.n0;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static volatile u d = null;
    private static volatile xj xj = null;
    private static volatile String y = "";
    private final AtomicBoolean c = new AtomicBoolean(false);
    private volatile int f;
    private A5SV6n hf;
    private volatile String kd;
    private final String u;
    private volatile boolean w;

    private xj(String str) {
        this.f = 99999;
        String pz = f.zg().pz();
        com.bytedance.sdk.openadsdk.zg.w.w.u e = f.zg().e();
        if (e != null) {
            if (!e.w() || !e.u() || !e.kd()) {
                this.f = MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET;
            } else if (!e.hf()) {
                this.f = MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STAT_INFO;
            }
            if (ai.w >= 4600 && !e.y()) {
                this.f = MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET;
            }
        }
        this.kd = null;
        this.u = pz;
        this.w = kd(str);
    }

    private boolean kd(String str) {
        try {
            Context context = pz.getContext();
            String str2 = this.u;
            int i = this.f;
            A2egSU a2egSU = new A2egSU();
            a2egSU.f14054A4TApA = "1371";
            a2egSU.f14055A5SV6n = str2;
            a2egSU.f14056ADYaiT = "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx";
            a2egSU.f14058ASJ6gh = i;
            if (TextUtils.isEmpty("1371") || TextUtils.isEmpty(str2) || TextUtils.isEmpty("THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx")) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
            a2egSU.f14061AZkASS.add(new PglITokenObserver() { // from class: com.bytedance.sdk.openadsdk.xj.xj.xj.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str3) {
                    String unused = xj.y = str3;
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.w.u.xj().qt(str3);
                }
            });
            if (!f.zg().f()) {
                a2egSU.f14060AZOQYO.put("kOA1", "1");
            } else if (!f.zg().p()) {
                boolean equals = str.equals("timeout");
                HashMap hashMap = a2egSU.f14060AZOQYO;
                if (equals || str.equals("error")) {
                    hashMap.put("kOA1", "1");
                    a2egSU.AMqCpz = null;
                } else if (!str.isEmpty()) {
                    hashMap.put("kOA1", "1");
                    a2egSU.AMqCpz = str;
                }
            }
            if (!f.zg().kd()) {
                a2egSU.f14060AZOQYO.put("kS1", "1");
            }
            if (!f.zg().pl()) {
                a2egSU.f14060AZOQYO.put("kDisableBlueToothCollection", "1");
            }
            a2egSU.f14053A2egSU = this.kd;
            a2egSU.f14057ARc23Z = 1;
            A4TApA a4TApA = new A4TApA(a2egSU);
            synchronized (ADYaiT.class) {
                try {
                    n0.ADYaiT(context, a4TApA.f7760AaHO0E);
                } finally {
                }
            }
            ADYaiT.A4TApA();
            w();
            return true;
        } catch (Throwable th) {
            pl.hf("MSSdkImpl", "appid 为空，初始化失败！", th);
            return false;
        }
    }

    private static xj u(String str) {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj(str);
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public static xj xj() {
        return xj;
    }

    public void hf(String str) {
        if (this.w) {
            w();
            A5SV6n a5SV6n = this.hf;
            if (a5SV6n != null) {
                a5SV6n.A2egSU(str);
            }
        }
    }

    private void w() {
        if (this.hf == null) {
            this.hf = ADYaiT.A2egSU();
        }
    }

    public void xj(String str) {
        if (this.w) {
            w();
            if (TextUtils.isEmpty(str) || str.equals(this.kd) || this.hf == null) {
                return;
            }
            this.kd = str;
            m0 m0Var = this.hf.f7761A2egSU;
            m0Var.f14021A5SV6n.f14053A2egSU = str;
            long j = m0Var.f14019A2egSU;
            if (j != -1) {
                SparseArray sparseArray = pbly.f14067A2egSU;
                pgla.a(33554434, 0, j, str, m0Var.f14020A4TApA);
            }
        }
    }

    public static String hf() {
        if (TextUtils.isEmpty(y)) {
            y = com.bytedance.sdk.openadsdk.core.w.u.xj().pz();
        }
        return y;
    }

    public Map<String, String> xj(String str, byte[] bArr) {
        if (!this.w) {
            return new HashMap();
        }
        w();
        A5SV6n a5SV6n = this.hf;
        if (a5SV6n != null) {
            m0 m0Var = a5SV6n.f7761A2egSU;
            HashMap hashMap = new HashMap();
            if (str != null && str.length() != 0) {
                SparseArray sparseArray = pbly.f14067A2egSU;
                String[] strArr = (String[]) pgla.a(33554438, 0, m0Var.f14019A2egSU, str, bArr);
                if (strArr != null && strArr.length % 2 == 0) {
                    for (int i = 0; i < strArr.length; i += 2) {
                        String str2 = strArr[i];
                        String str3 = strArr[i + 1];
                        if (str2 != null && str3 != null) {
                            hashMap.put(str2, str3);
                        }
                    }
                }
            }
            return hashMap;
        }
        return new HashMap();
    }

    public static void xj(u uVar) {
        d = uVar;
        xj(true);
    }

    public static xj xj(boolean z) {
        if (f.zg().tf()) {
            if (d != null) {
                if (xj == null) {
                    return u(ra.w(d));
                }
                return xj;
            }
            if (z) {
                return u("error");
            }
            return null;
        }
        return u(null);
    }
}
