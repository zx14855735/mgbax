package com.bytedance.sdk.openadsdk.core.nativeexpress.xj;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import com.bytedance.sdk.component.d.hf.u;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.et.kd;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ss;
import com.sigmob.sdk.base.models.ClickCommon;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static volatile hf xj;

    public interface xj {
    }

    private void hf(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj();
        xjVar.w(str).kd(str3).u(str4).hf(str2).xj(str5).xj(Long.valueOf(System.currentTimeMillis()));
        w.xj().xj(xjVar, false);
        hf();
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(ss ssVar, String str, String str2) {
        if (ssVar == null) {
            return;
        }
        if (TextUtils.isEmpty(ssVar.xj())) {
            pl.u("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str2, "_");
        A5SV6n2.append(ssVar.xj());
        final String sb = A5SV6n2.toString();
        final String w = ssVar.w();
        final String hf = ssVar.hf();
        final String u = ssVar.u();
        if (TextUtils.isEmpty(str) && str2.equals(ClickCommon.CLICK_SCENE_AD)) {
            str = f.zg().pz();
        }
        final String str3 = str;
        c.xj(new d("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.xj.hf.1
            @Override // java.lang.Runnable
            public void run() {
                hf.this.xj(sb, w, hf, u, str3);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        int ol = pz.hf().ol();
        if (ol <= 0) {
            ol = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj> hf = w.xj().hf();
        if (hf == null || hf.isEmpty() || ol >= hf.size()) {
            if (hf != null) {
                hf.size();
                return;
            }
            return;
        }
        int size = (int) (hf.size() - (ol * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj xjVar : hf) {
            treeMap.put(xjVar.u(), xjVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj xjVar2 = (com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj) entry.getValue();
                if (xjVar2 != null) {
                    hashSet.add(xjVar2.xj());
                }
            }
        }
        xj(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, String str2, String str3, String str4, String str5) {
        if (xj(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            hf(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            xj(str2, str, str3, str5, (xj) null);
        } else {
            hf(str2, str3, str5, str4, str);
        }
    }

    private void xj(final String str, final String str2, final String str3, final String str4, final xj xjVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.component.d.hf.w w = kd.xj().hf().w();
        w.xj(str);
        w.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.xj.hf.2
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                if (hfVar != null && hfVar.f()) {
                    String u = hfVar.u();
                    if (TextUtils.isEmpty(u)) {
                        return;
                    }
                    w.xj().xj(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj().xj(str2).hf(str3).w(str).kd(str4).u(u).xj(Long.valueOf(System.currentTimeMillis())), false);
                    hf.this.hf();
                    if (xjVar != null) {
                        try {
                            new JSONObject(u);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(u uVar, IOException iOException) {
                if (xjVar != null) {
                    iOException.getMessage();
                }
            }
        });
    }

    public Set<com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj> xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return w.xj().xj(str);
    }

    public String xj(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj xj2 = xj(CtFAbx.AlLFFp(str, "_", str2), str3);
        if (xj2 == null) {
            return null;
        }
        xj(xj2);
        return xj2.kd();
    }

    private com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return w.xj().xj(str, str2);
    }

    private void xj(final com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj xjVar) {
        xjVar.xj(Long.valueOf(System.currentTimeMillis()));
        c.xj(new d("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.xj.hf.3
            @Override // java.lang.Runnable
            public void run() {
                w.xj().xj(xjVar, true);
            }
        }, 10);
    }

    public void xj(Set<String> set) {
        try {
            w.xj().xj(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
