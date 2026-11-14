package com.bytedance.sdk.openadsdk.hf;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bykv.vk.openvk.component.video.api.w.w;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.et.kd;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.x.d;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private ReentrantLock hf;
    private Set<String> w;
    private Map<String, com.bytedance.sdk.openadsdk.hf.xj> xj;

    public static final class xj {
        private static final hf xj = new hf();

        static {
            tUIiDx();
        }

        private static /* synthetic */ void tUIiDx() {
            char[] charArray = "r~|?vp|t?s~h?byt}}?[\u007fxScxuvt".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 17);
            }
            String str = new String(charArray);
            char[] charArray2 = "r}x\u007fxe".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 17);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private void delete(Map<String, com.bytedance.sdk.openadsdk.hf.xj> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            map.get(it.next()).hf(d.xj());
        }
    }

    private com.bytedance.sdk.component.d.xj hf() {
        return kd.xj().hf();
    }

    private Map<String, com.bytedance.sdk.openadsdk.hf.xj> kd() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.sdk.openadsdk.hf.xj>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.bytedance.sdk.openadsdk.hf.xj> next = it.next();
            if (next.getValue().u()) {
                hashMap.put(next.getKey(), next.getValue());
                it.remove();
            } else {
                arrayList.add(next.getValue());
            }
        }
        int size = this.xj.size() - pz.hf().it();
        if (size > 0) {
            Collections.sort(arrayList, new Comparator<com.bytedance.sdk.openadsdk.hf.xj>() { // from class: com.bytedance.sdk.openadsdk.hf.hf.3
                @Override // java.util.Comparator
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public int compare(com.bytedance.sdk.openadsdk.hf.xj xjVar, com.bytedance.sdk.openadsdk.hf.xj xjVar2) {
                    long w = xjVar2.w() - xjVar.w();
                    if (w == 0) {
                        String xj2 = d.xj();
                        w = xjVar.xj(xj2) - xjVar2.xj(xj2);
                    }
                    return (int) w;
                }
            });
            for (int i = 0; i < size; i++) {
                com.bytedance.sdk.openadsdk.hf.xj xjVar = (com.bytedance.sdk.openadsdk.hf.xj) arrayList.get(i);
                this.xj.remove(xjVar.hf());
                hashMap.put(xjVar.hf(), xjVar);
            }
        }
        return hashMap;
    }

    private void u() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.xj.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.hf.xj xjVar = this.xj.get(it.next());
            if (xjVar != null) {
                jSONArray.put(xjVar.kd());
            }
        }
        com.bytedance.sdk.openadsdk.core.hf.xj().put("sdk_brand_video_cahce", jSONArray.toString());
    }

    private JSONArray w(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creatives");
        JSONArray jSONArray = new JSONArray();
        if (optJSONArray2 != null) {
            for (int i = 0; i < optJSONArray2.length(); i++) {
                JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("precache_brand_video")) != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        jSONArray.put(optJSONArray.opt(i2));
                    }
                }
            }
        }
        return jSONArray;
    }

    private hf() {
        this.xj = new HashMap();
        this.hf = new ReentrantLock();
        this.w = new HashSet();
        String str = com.bytedance.sdk.openadsdk.core.hf.xj().get("sdk_brand_video_cahce", "");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                hf(jSONArray.optJSONObject(i));
            }
        } catch (Throwable unused) {
        }
    }

    private void hf(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.hf.xj xjVar = new com.bytedance.sdk.openadsdk.hf.xj(jSONObject);
            this.xj.put(xjVar.hf(), xjVar);
        }
    }

    public static hf xj() {
        return xj.xj;
    }

    public void xj(JSONObject jSONObject) {
        final JSONArray w = w(jSONObject);
        if (w == null || w.length() == 0) {
            return;
        }
        f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.hf.hf.1
            @Override // java.lang.Runnable
            public void run() {
                w.length();
                hf.this.xj(w);
            }
        }, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(JSONArray jSONArray) {
        try {
            this.hf.lock();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                hf(jSONArray.optJSONObject(i));
            }
            Map<String, com.bytedance.sdk.openadsdk.hf.xj> kd = kd();
            int w = w();
            u();
            delete(kd);
            this.hf.unlock();
            xj(w);
        } catch (Throwable th) {
            this.hf.unlock();
            throw th;
        }
    }

    private int w() {
        Iterator<String> it = this.xj.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            u xj2 = xj(this.xj.get(it.next()));
            if (xj2 != null) {
                String kd = xj2.kd();
                String e = xj2.e();
                String zg = xj2.zg();
                File file = new File(kd, e);
                if (!file.exists() || file.length() <= 0) {
                    i++;
                    if (this.w.contains(e)) {
                        pl.xj("BrandVideoCacheManager", " task :" + e + " is running!");
                    } else {
                        this.w.add(e);
                        xj(zg, kd, e);
                    }
                }
            }
        }
        return i;
    }

    private void xj(int i) {
        File[] listFiles = new File(d.xj()).listFiles();
        int it = pz.hf().it();
        if (listFiles == null || listFiles.length <= it - i) {
            return;
        }
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            String xj2 = xj(listFiles[i2]);
            if (!this.xj.containsKey(xj2) && listFiles[i2].exists()) {
                listFiles[i2].delete();
                pl.hf("BrandVideoCacheManager", "delete not need:".concat(String.valueOf(xj2)));
            }
        }
    }

    private String xj(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        return lastIndexOf != -1 ? name.substring(0, lastIndexOf) : name;
    }

    private void xj(final String str, String str2, final String str3) {
        com.bytedance.sdk.component.d.hf.hf u = hf().u();
        u.xj(str);
        u.xj(str2, str3);
        u.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.hf.hf.2
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                hf.this.xj(str3);
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                pl.hf("BrandVideoCacheManager", "download " + str + " failed: " + iOException);
                hf.this.xj(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str) {
        try {
            this.hf.lock();
            this.w.remove(str);
        } finally {
            this.hf.unlock();
        }
    }

    private u xj(com.bytedance.sdk.openadsdk.hf.xj xjVar) {
        if (xjVar == null) {
            return null;
        }
        String hf = xjVar.hf();
        if (TextUtils.isEmpty(hf)) {
            hf = com.bytedance.sdk.component.utils.kd.hf(xjVar.xj());
        }
        w wVar = new w();
        wVar.w(xjVar.xj());
        wVar.kd(hf);
        wVar.kd(0);
        u uVar = new u(d.xj(), wVar, wVar, 0, 0);
        uVar.xj(d.xj());
        return uVar;
    }
}
