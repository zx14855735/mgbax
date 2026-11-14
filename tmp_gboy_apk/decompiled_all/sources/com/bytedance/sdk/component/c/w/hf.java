package com.bytedance.sdk.component.c.w;

import android.util.Pair;
import com.czhj.sdk.common.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements com.bytedance.sdk.component.c.hf, com.bytedance.sdk.component.c.xj {
    private final com.bytedance.sdk.component.u.hf.xj hf;
    private final boolean w;
    private com.bytedance.sdk.component.u.hf.xj xj;

    public hf(com.bytedance.sdk.component.u.hf.xj xjVar, boolean z) {
        this.xj = xjVar;
        this.hf = xjVar;
        this.w = z;
    }

    private Pair<String, String> getType(String str) {
        if (str.contains(".")) {
            String[] split = str.split("\\.");
            if (split.length >= 2) {
                return new Pair<>(split[0], split[1]);
            }
        }
        return new Pair<>("s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto Lb
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> Lb
            goto Lc
        Lb:
            r2 = 0
        Lc:
            if (r2 != 0) goto L12
            r2 = 0
            r1.xj = r2
            return
        L12:
            com.bytedance.sdk.component.u.hf.xj r0 = r1.xj
            if (r0 == 0) goto L1c
            int r0 = r0.type()
            if (r0 == r2) goto L2e
        L1c:
            java.lang.String r0 = "kv_store_factory"
            java.lang.Object r0 = com.bytedance.sdk.openadsdk.ats.w.xj(r0)
            com.bytedance.sdk.component.u.d r0 = (com.bytedance.sdk.component.u.d) r0
            if (r0 == 0) goto L2e
            com.bytedance.sdk.component.u.hf.xj r2 = r0.getEncrypt(r2)
            if (r2 == 0) goto L2e
            r1.xj = r2
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.c.w.hf.xj(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014e A[Catch: all -> 0x00ba, TRY_LEAVE, TryCatch #4 {all -> 0x00ba, blocks: (B:67:0x00b0, B:52:0x00fb, B:56:0x0102, B:57:0x0116, B:59:0x011c, B:61:0x0126, B:62:0x012a, B:63:0x0136, B:64:0x0142, B:65:0x014e, B:97:0x00bd, B:100:0x00c7, B:103:0x00d1, B:106:0x00db, B:109:0x00e5), top: B:66:0x00b0 }] */
    @Override // com.bytedance.sdk.component.c.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map<java.lang.String, java.lang.Object> xj(java.io.File r19) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.c.w.hf.xj(java.io.File):java.util.Map");
    }

    @Override // com.bytedance.sdk.component.c.hf
    public void xj(Map<String, Object> map, File file) {
        FileWriter fileWriter;
        Throwable th;
        String str;
        String concat;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Properties properties = new Properties();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    concat = "ss.".concat(key);
                    value = jSONArray.toString();
                } else if (entry.getValue() instanceof Boolean) {
                    concat = "b.".concat(key);
                } else if (entry.getValue() instanceof Integer) {
                    concat = "i.".concat(key);
                } else if (entry.getValue() instanceof Long) {
                    concat = "l.".concat(key);
                } else if (entry.getValue() instanceof Float) {
                    concat = "f.".concat(key);
                } else if (entry.getValue() instanceof Double) {
                    concat = "f.".concat(key);
                } else {
                    concat = "s.".concat(key);
                }
                String valueOf = String.valueOf(value);
                if (this.w) {
                    concat = this.hf.encrypt(concat);
                }
                com.bytedance.sdk.component.u.hf.xj xjVar = this.hf;
                if (xjVar != null) {
                    valueOf = xjVar.encrypt(valueOf);
                }
                properties.put(concat, valueOf);
            }
        }
        try {
            fileWriter = new FileWriter(file);
            try {
                com.bytedance.sdk.component.u.hf.xj xjVar2 = this.hf;
                if (xjVar2 != null) {
                    str = String.valueOf(xjVar2.type());
                } else {
                    str = Constants.FAIL;
                }
                properties.put(".i.tt_ect", str);
                properties.store(fileWriter, (String) null);
                fileWriter.flush();
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                        throw th;
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
        }
    }
}
