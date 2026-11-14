package com.bytedance.sdk.openadsdk.core.j.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.component.u.hf.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.yo;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private void hf(JSONObject jSONObject, String str) {
        FileOutputStream fileOutputStream;
        byte[] u = u(jSONObject.toString());
        if (u == null || u.length <= 0) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(pz.getContext()), new File(str).getName()));
            try {
                fileOutputStream.write(u);
                com.bytedance.sdk.component.y.w.w.hf.xj(fileOutputStream);
            } catch (Throwable unused) {
                com.bytedance.sdk.component.y.w.w.hf.xj(fileOutputStream);
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
    }

    private boolean kd(String str) {
        File[] listFiles;
        long lastModified;
        File file = new File(str);
        boolean z = true;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (name.startsWith("._tt_")) {
                    try {
                        lastModified = Long.parseLong(name.substring(5));
                    } catch (Throwable unused) {
                        lastModified = file2.lastModified();
                    }
                    if (wo.xj(lastModified, System.currentTimeMillis())) {
                        z = false;
                    } else {
                        file2.delete();
                    }
                }
            }
        }
        if (z) {
            new File(file, "._tt_" + System.currentTimeMillis()).mkdirs();
        }
        return z;
    }

    private byte[] u(String str) {
        byte[] bytes = com.bytedance.sdk.component.utils.xj.hf(str).getBytes(StandardCharsets.UTF_8);
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 1);
        allocate.put((byte) 3);
        allocate.put(bytes);
        return allocate.array();
    }

    private JSONObject w(String str) {
        byte[] u = y.u(new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(pz.getContext()), new File(str).getName()));
        if (u == null) {
            return null;
        }
        try {
            String xj = xj(u);
            if (xj != null) {
                return new JSONObject(xj);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        return null;
    }

    private boolean xj(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        return j2 == 0 ? !wo.xj(j, currentTimeMillis) : currentTimeMillis - j >= j2;
    }

    public void xj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject xj;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("id_conf")) == null) {
            return;
        }
        try {
            w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
            long j = xj2.getLong("last_gather_id_time", 0L);
            long optLong = optJSONObject.optLong("delt", 0L);
            if (j <= 0 || xj(j, optLong)) {
                String optString = optJSONObject.optString("store");
                int optInt = optJSONObject.optInt("state", 0);
                if (optInt != 1) {
                    if (optInt != 2) {
                        if (optInt != 4) {
                            return;
                        }
                        File file = new File(optString);
                        File file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(pz.getContext()), file.getName());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        xj(file);
                    }
                    xj = null;
                } else {
                    xj = xj(optString);
                }
                int optInt2 = optJSONObject.optInt("upload", 0);
                if (optInt2 > 0) {
                    xj2.put("last_gather_id_time", System.currentTimeMillis());
                    File file3 = new File(optString);
                    xj.put("c_r", file3.canRead());
                    xj.put("c_w", file3.canWrite());
                    xj.put(t.t, optString);
                    xj(optString, xj, optInt2 == 2);
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private JSONObject hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        JSONObject w = w(str);
        if (file.exists() && file.isDirectory() && file.canRead()) {
            HashMap hashMap = new HashMap();
            xj(file, str, hashMap);
            if (hashMap.size() != 0) {
                if (w == null) {
                    w = new JSONObject();
                }
                JSONObject optJSONObject = w.optJSONObject("aid");
                try {
                    if (optJSONObject == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            w.put("aid", jSONObject);
                        } catch (JSONException unused) {
                        }
                        optJSONObject = jSONObject;
                    } else {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray((String) entry.getKey());
                            if (optJSONArray != null) {
                                Set set = (Set) entry.getValue();
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    String optString = optJSONArray.optString(i);
                                    if (!TextUtils.isEmpty(optString)) {
                                        set.add(optString);
                                    }
                                }
                            }
                        }
                    }
                } catch (JSONException unused2) {
                }
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    String str2 = (String) entry2.getKey();
                    Set set2 = (Set) entry2.getValue();
                    if (!TextUtils.isEmpty(str2) && set2 != null && set2.size() != 0) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = set2.iterator();
                            while (it.hasNext()) {
                                jSONArray.put((String) it.next());
                            }
                            optJSONObject.put(str2, jSONArray);
                        } catch (JSONException e) {
                            pl.xj(e);
                        }
                    }
                }
            }
        }
        return w;
    }

    private void xj(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        xj(file2);
                    }
                }
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject xj(String str) {
        String xj = tf.xj();
        if (TextUtils.isEmpty(xj)) {
            return null;
        }
        String AZkASS2 = CtFAbx.AZkASS(xj, !yo.kd() ? 1 : 0, new StringBuilder());
        JSONObject hf = hf(str);
        if (hf == null) {
            hf = new JSONObject();
        }
        JSONObject optJSONObject = hf.optJSONObject("aid");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            hf.putOpt("aid", optJSONObject);
        }
        String packageName = pz.getContext().getPackageName();
        if (packageName == null) {
            packageName = f.zg().pz();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(packageName);
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
            optJSONObject.put(packageName, optJSONArray);
        }
        int i = 0;
        while (true) {
            if (i >= optJSONArray.length()) {
                i = -1;
                break;
            }
            if (TextUtils.equals(optJSONArray.optString(i), AZkASS2)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            optJSONArray.put(AZkASS2);
        }
        hf(hf, str);
        xj(optJSONObject, str);
        return hf;
    }

    private void xj(JSONObject jSONObject, String str) {
        byte[] u;
        File file = new File(str);
        if (file.exists()) {
            if (!file.canWrite()) {
                return;
            }
        } else if (!file.mkdirs()) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray optJSONArray = jSONObject.optJSONArray(next);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString) && (u = u(CtFAbx.AlLFFp(next, "/", optString))) != null) {
                        File file2 = new File(str, xj.xj(u, 20));
                        if (file2.isFile()) {
                            file2.delete();
                        }
                        file2.mkdirs();
                        file2.getAbsolutePath();
                    }
                }
            }
        }
    }

    private void xj(File file, String str, Map<String, Set<String>> map) {
        if (file == null || !file.exists() || !file.canRead() || file.getName().startsWith("._tt_")) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (!file2.getName().startsWith("._tt_") && file2.isDirectory()) {
                        xj(file2, str, map);
                        file2.delete();
                    }
                }
                return;
            }
            file.delete();
            String absolutePath = file.getAbsolutePath();
            if (absolutePath.length() <= str.length()) {
                return;
            }
            try {
                String xj = xj(xj.xj(absolutePath.substring(str.length() + 1)));
                if (xj == null) {
                    return;
                }
                String[] split = xj.split("/");
                if (split.length != 2) {
                    return;
                }
                String str2 = split[0];
                String str3 = split[1];
                Set<String> set = map.get(str2);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(str2, set);
                }
                set.add(str3);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        file.delete();
    }

    private String xj(byte[] bArr) {
        byte b = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        if (b == 3) {
            return com.bytedance.sdk.component.utils.xj.w(new String(bArr2));
        }
        return null;
    }

    private void xj(String str, JSONObject jSONObject, boolean z) {
        if (z || kd(str)) {
            xj(str, jSONObject);
        }
    }

    private void xj(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            jSONObject = hf(str);
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("aid");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            HashSet hashSet = new HashSet();
            int i = 0;
            while (keys.hasNext()) {
                i++;
                JSONArray optJSONArray = optJSONObject.optJSONArray(keys.next());
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            hashSet.add(optString);
                        }
                    }
                }
            }
            try {
                jSONObject.put("size", i);
                if (!hashSet.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put("all", jSONArray);
                }
            } catch (JSONException unused) {
            }
        }
        am.xj().xj("s_d_i_c", jSONObject);
    }
}
