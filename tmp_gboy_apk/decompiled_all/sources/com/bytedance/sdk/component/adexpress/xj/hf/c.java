package com.bytedance.sdk.component.adexpress.xj.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private static volatile c xj;
    private AtomicBoolean hf = new AtomicBoolean(false);

    public interface xj {
        void hf();

        void xj();
    }

    private c() {
    }

    private JSONObject w(String str) {
        com.bytedance.sdk.component.adexpress.xj.xj.w w = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w();
        if (w == null) {
            return null;
        }
        com.bytedance.sdk.component.d.hf.w kd = w.kd();
        kd.xj(str);
        com.bytedance.sdk.component.d.hf xj2 = kd.xj();
        if (xj2 != null) {
            try {
                if (xj2.f() && xj2.u() != null) {
                    return new JSONObject(xj2.u());
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        return null;
    }

    public Set<com.bytedance.sdk.component.adexpress.xj.w.hf> hf(String str) {
        return y.xj().hf(str);
    }

    private void hf() {
        if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() == null) {
            return;
        }
        int xj2 = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().xj();
        if (xj2 <= 0) {
            xj2 = 100;
        }
        List<com.bytedance.sdk.component.adexpress.xj.w.hf> hf = y.xj().hf();
        if (hf == null || hf.isEmpty() || xj2 >= hf.size()) {
            if (hf != null) {
                hf.size();
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.xj.w.hf hfVar : hf) {
            treeMap.put(hfVar.c(), hfVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (hf.size() - (xj2 * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).getClass();
                com.bytedance.sdk.component.adexpress.xj.w.hf hfVar2 = (com.bytedance.sdk.component.adexpress.xj.w.hf) entry.getValue();
                if (hfVar2 != null) {
                    hashSet.add(hfVar2.hf());
                }
            }
        }
        xj(hashSet);
        this.hf.set(false);
    }

    public static c xj() {
        if (xj == null) {
            synchronized (c.class) {
                try {
                    if (xj == null) {
                        xj = new c();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public com.bytedance.sdk.component.adexpress.xj.w.hf xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return y.xj().xj(str);
    }

    private JSONObject xj(String str, xj xjVar) {
        if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() == null) {
            xjVar.hf();
            return null;
        }
        com.bytedance.sdk.component.d.hf.w kd = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().kd();
        kd.xj(str);
        com.bytedance.sdk.component.d.hf xj2 = kd.xj();
        if (xj2 != null) {
            try {
                if (xj2.f() && xj2.u() != null) {
                    return new JSONObject(xj2.u());
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        xjVar.hf();
        return null;
    }

    private void hf(String str, String str2, String str3, String str4, String str5, String str6) {
        y.xj().xj(new com.bytedance.sdk.component.adexpress.xj.w.hf().xj(str).hf(str2).w(str3).u(str4).kd(str5).y(str6).xj(Long.valueOf(System.currentTimeMillis())), false);
        hf();
    }

    public void xj(com.bytedance.sdk.component.adexpress.xj.w.u uVar, String str) {
        String str2;
        if (uVar == null) {
            pl.u("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str3 = uVar.xj;
        final String str4 = uVar.w;
        final String str5 = uVar.hf;
        final String str6 = uVar.u;
        final String str7 = uVar.kd;
        if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() != null) {
            str2 = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().y();
        } else {
            str2 = "";
        }
        final String str8 = TextUtils.isEmpty(str) ? str2 : str;
        if (TextUtils.isEmpty(str3)) {
            pl.u("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.u.kd.xj(new d("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.xj.hf.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.xj(str3, str4, str5, str6, str7, str8);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void xj(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        try {
            try {
                if (xj(str) != null) {
                    if (!TextUtils.isEmpty(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str7 = str5;
                            hf(str6, str, str3, str2, str4, str7);
                        }
                    }
                    return;
                }
                str7 = str5;
                if (TextUtils.isEmpty(str4)) {
                    xj(str2, str6, str);
                } else if (TextUtils.isEmpty(str3)) {
                    xj(str2, str6, str);
                } else {
                    hf(str6, str, str3, str2, str4, str7);
                }
                boolean xj2 = f.xj(str7);
                if (!hf.kd() || xj2) {
                    kd.hf().xj(true);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private void xj(String str, String str2, String str3) {
        JSONObject w;
        if (TextUtils.isEmpty(str) || (w = w(str)) == null) {
            return;
        }
        String optString = w.optString(TKDownloadReason.KSAD_TK_MD5);
        String optString2 = w.optString("version");
        String optString3 = w.optString(PointParamKey.DATA);
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.xj.w.hf xj2 = new com.bytedance.sdk.component.adexpress.xj.w.hf().xj(str2).hf(str3).w(optString).u(str).kd(optString3).y(optString2).xj(Long.valueOf(System.currentTimeMillis()));
        y.xj().xj(xj2, false);
        hf();
        if (f.xj(optString2)) {
            xj2.y(optString2);
            kd.hf().xj(true);
        }
    }

    public void xj(com.bytedance.sdk.component.adexpress.xj.w.u uVar, xj xjVar) {
        xj(uVar, uVar.hf(), xjVar);
    }

    public void xj(com.bytedance.sdk.component.adexpress.xj.w.u uVar, String str, final xj xjVar) {
        String str2;
        if (xjVar == null) {
            return;
        }
        if (uVar == null) {
            pl.u("TmplDiffManager", "saveTemplate error: tplInfo == null");
            xjVar.hf();
            return;
        }
        final String str3 = uVar.xj;
        final String str4 = uVar.w;
        final String str5 = uVar.hf;
        final String str6 = uVar.u;
        final String str7 = uVar.kd;
        if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() != null) {
            str2 = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().y();
        } else {
            str2 = "";
        }
        final String str8 = TextUtils.isEmpty(str) ? str2 : str;
        if (TextUtils.isEmpty(str3)) {
            pl.u("TmplDiffManager", "saveTemplate error:tmpId is empty");
            xjVar.hf();
        } else {
            com.bytedance.sdk.component.adexpress.u.kd.xj(new d("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.xj.hf.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.xj(str3, str4, str5, str6, str7, str8, xjVar);
                }
            }, 10);
        }
    }

    public synchronized void xj(String str, String str2, String str3, String str4, String str5, String str6, xj xjVar) {
        String str7;
        try {
            try {
                if (xj(str) != null) {
                    if (!TextUtils.isEmpty(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str7 = str5;
                            hf(str6, str, str3, str2, str4, str7);
                            xjVar.xj();
                        }
                    }
                    xjVar.xj();
                    return;
                }
                str7 = str5;
                if (TextUtils.isEmpty(str4)) {
                    xj(str2, str6, str, xjVar);
                } else if (TextUtils.isEmpty(str3)) {
                    xj(str2, str6, str, xjVar);
                } else {
                    hf(str6, str, str3, str2, str4, str7);
                    xjVar.xj();
                }
                boolean xj2 = f.xj(str7);
                if (!hf.kd() || xj2) {
                    kd.hf().xj(true);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private void xj(String str, String str2, String str3, xj xjVar) {
        if (TextUtils.isEmpty(str)) {
            xjVar.hf();
            return;
        }
        JSONObject xj2 = xj(str, xjVar);
        if (xj2 != null) {
            String optString = xj2.optString(TKDownloadReason.KSAD_TK_MD5);
            String optString2 = xj2.optString("version");
            String optString3 = xj2.optString(PointParamKey.DATA);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                com.bytedance.sdk.component.adexpress.xj.w.hf xj3 = new com.bytedance.sdk.component.adexpress.xj.w.hf().xj(str2).hf(str3).w(optString).u(str).kd(optString3).y(optString2).xj(Long.valueOf(System.currentTimeMillis()));
                if (xj3 != null && com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().hf() != null) {
                    if (TextUtils.isEmpty(xj3.hf())) {
                        xjVar.hf();
                        return;
                    }
                    y.xj().xj(xj3, false);
                    hf();
                    if (f.xj(optString2)) {
                        xj3.y(optString2);
                        kd.hf().xj(true);
                    }
                    xjVar.xj();
                    return;
                }
                xjVar.hf();
                return;
            }
            xjVar.hf();
        }
    }

    public void xj(Set<String> set) {
        try {
            y.xj().xj(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
