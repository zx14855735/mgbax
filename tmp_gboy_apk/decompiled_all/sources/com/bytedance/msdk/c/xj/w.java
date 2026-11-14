package com.bytedance.msdk.c.xj;

import android.text.TextUtils;
import com.bytedance.msdk.core.f.g;
import com.bytedance.msdk.core.f.p;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.w.f.u;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static volatile w xj;
    private volatile Map<Integer, ai> hf = new ConcurrentHashMap();
    private Map<String, com.bytedance.msdk.core.tf.hf> w = new ConcurrentHashMap();

    private w() {
    }

    private synchronized void hf(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    try {
                        this.w.clear();
                        u.hf.clear();
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            com.bytedance.msdk.core.tf.hf xj2 = com.bytedance.msdk.core.tf.hf.xj(jSONObject, false);
                            if (xj2 != null && !TextUtils.isEmpty(xj2.ff())) {
                                this.w.put(xj2.ff(), xj2);
                                concurrentHashMap.put(xj2.ff(), jSONObject.toString());
                            }
                        }
                        xj(concurrentHashMap);
                        u.xj();
                        com.bytedance.msdk.c.xj.xj().xj("prime_rit_count", jSONArray.length());
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void w(final JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        y.u(new Runnable() { // from class: com.bytedance.msdk.c.xj.w.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.c.hf.hf.xj().xj(jSONArray);
            }
        });
    }

    public synchronized boolean w() {
        return com.bytedance.msdk.c.xj.xj().hf("prime_rit_count", -1) <= 0;
    }

    public static w xj() {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        xj = new w();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ai xj(int i) {
        ai aiVar;
        aiVar = this.hf.get(Integer.valueOf(i));
        if (aiVar == null) {
            aiVar = com.bytedance.msdk.c.xj.xj(i);
            this.hf.put(Integer.valueOf(i), aiVar);
        }
        return aiVar;
    }

    public synchronized void xj(JSONArray jSONArray) {
        hf(jSONArray);
        w(jSONArray);
    }

    public synchronized com.bytedance.msdk.core.tf.hf xj(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.msdk.core.tf.hf hfVar = this.w.get(str);
        if (hfVar == null && (hfVar = com.bytedance.msdk.core.tf.hf.c(xj(i, str))) != null) {
            this.w.put(str, hfVar);
        }
        if (i2 == 102) {
            return hfVar;
        }
        com.bytedance.msdk.core.tf.hf xj2 = com.bytedance.msdk.core.d.u.xj(hfVar, i2);
        return xj2 != null ? xj2 : hfVar;
    }

    public synchronized void hf() {
        Map<String, com.bytedance.msdk.core.tf.hf> map = this.w;
        if (map != null) {
            map.clear();
        }
    }

    private String xj(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(5);
            arrayList.add(7);
            arrayList.add(8);
            arrayList.add(9);
            arrayList.add(10);
        } else {
            arrayList.add(Integer.valueOf(i));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String hf = xj(((Integer) it.next()).intValue()).hf(str);
            if (!TextUtils.isEmpty(hf)) {
                return hf;
            }
        }
        return null;
    }

    private synchronized void xj(final Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                y.u(new Runnable() { // from class: com.bytedance.msdk.c.xj.w.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Map.Entry entry : map.entrySet()) {
                            try {
                                String str = (String) entry.getKey();
                                String str2 = (String) entry.getValue();
                                com.bytedance.msdk.core.tf.hf hfVar = (com.bytedance.msdk.core.tf.hf) w.this.w.get(str);
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && hfVar != null) {
                                    w.this.xj(hfVar.a()).xj(str, str2);
                                    w.this.xj(hfVar);
                                }
                            } catch (Throwable th) {
                                pl.xj(th);
                            }
                        }
                        map.clear();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void xj(com.bytedance.msdk.core.tf.hf hfVar) {
        if (hfVar != null) {
            try {
                if (hfVar.ff() != null) {
                    if (hfVar.p()) {
                        if (g.xj().xj(hfVar.tf())) {
                            g.xj().hf(hfVar.tf());
                        }
                        if (g.xj().xj(hfVar.d())) {
                            g.xj().hf(hfVar.d());
                        }
                    } else {
                        g.xj().u(hfVar.ff());
                        g.xj().d(hfVar.ff());
                    }
                    for (tf tfVar : hfVar.yy()) {
                        if (tfVar.u()) {
                            if (com.bytedance.msdk.core.f.pl.xj().xj(tfVar.w())) {
                                com.bytedance.msdk.core.f.pl.xj().hf(tfVar.w());
                            }
                            if (p.xj().xj(tfVar.hf())) {
                                p.xj().hf(tfVar.hf());
                            }
                        } else {
                            com.bytedance.msdk.core.f.pl.xj().delete(hfVar.ff(), tfVar.yo());
                            p.xj().delete(hfVar.ff(), tfVar.yo());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
