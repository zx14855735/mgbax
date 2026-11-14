package com.bytedance.sdk.component.d.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.e;
import com.bytedance.sdk.component.hf.xj.kd;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.qt;
import com.bytedance.sdk.component.hf.xj.tf;
import com.bytedance.sdk.component.hf.xj.y;
import com.bytedance.sdk.component.hf.xj.zg;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends u {
    qt xj;

    public kd(pl plVar) {
        super(plVar);
        this.xj = null;
    }

    public void w(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.xj = qt.xj(tf.xj("application/json; charset=utf-8"), str);
    }

    public void xj(JSONObject jSONObject) {
        String str;
        if (jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str = "{}";
        }
        this.xj = qt.xj(tf.xj("application/json; charset=utf-8"), str);
    }

    public void xj(Map<String, String> map) {
        kd.xj xjVar = new kd.xj();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                xjVar.xj(str, map.get(str));
            }
        }
        this.xj = xjVar.xj();
    }

    public void xj(String str, byte[] bArr) {
        this.xj = qt.xj(tf.xj(str), bArr);
    }

    public void xj(final com.bytedance.sdk.component.d.xj.xj xjVar) {
        try {
            am.xj xjVar2 = new am.xj();
            if (TextUtils.isEmpty(this.y)) {
                xjVar.xj(this, new IOException("Url is Empty"));
                return;
            }
            xjVar2.xj(this.y);
            if (this.xj == null) {
                if (xjVar != null) {
                    xjVar.xj(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                xj(xjVar2);
                xjVar2.xj((Object) hf());
                this.w.xj(xjVar2.xj(this.xj).hf()).xj(new com.bytedance.sdk.component.hf.xj.w() { // from class: com.bytedance.sdk.component.d.hf.kd.1
                    @Override // com.bytedance.sdk.component.hf.xj.w
                    public void onFailure(com.bytedance.sdk.component.hf.xj.hf hfVar, IOException iOException) {
                        com.bytedance.sdk.component.d.xj.xj xjVar3 = xjVar;
                        if (xjVar3 != null) {
                            xjVar3.xj(kd.this, iOException);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:34:0x00ec  */
                    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
                    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.sdk.component.hf.xj.y] */
                    /* JADX WARN: Type inference failed for: r13v5, types: [com.bytedance.sdk.component.d.xj.xj] */
                    /* JADX WARN: Type inference failed for: r2v0 */
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.sdk.component.d.hf] */
                    /* JADX WARN: Type inference failed for: r2v10 */
                    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
                    /* JADX WARN: Type inference failed for: r2v13 */
                    /* JADX WARN: Type inference failed for: r2v14 */
                    /* JADX WARN: Type inference failed for: r2v15 */
                    /* JADX WARN: Type inference failed for: r2v16 */
                    /* JADX WARN: Type inference failed for: r2v17 */
                    /* JADX WARN: Type inference failed for: r2v3 */
                    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.sdk.component.d.hf] */
                    @Override // com.bytedance.sdk.component.hf.xj.w
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void onResponse(com.bytedance.sdk.component.hf.xj.hf r13, com.bytedance.sdk.component.hf.xj.zg r14) {
                        /*
                            Method dump skipped, instructions count: 261
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.hf.kd.AnonymousClass1.onResponse(com.bytedance.sdk.component.hf.xj.hf, com.bytedance.sdk.component.hf.xj.zg):void");
                    }
                });
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            xjVar.xj(this, new IOException(th.getMessage()));
        }
    }

    @Override // com.bytedance.sdk.component.d.hf.u
    public com.bytedance.sdk.component.d.hf xj() {
        com.bytedance.sdk.component.d.hf hfVar;
        try {
            am.xj xjVar = new am.xj();
            if (TextUtils.isEmpty(this.y)) {
                com.bytedance.sdk.component.d.u.kd.xj("PostExecutor", "execute: Url is Empty");
                return new com.bytedance.sdk.component.d.hf(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            xjVar.xj(this.y);
            if (this.xj == null) {
                com.bytedance.sdk.component.d.u.kd.xj("PostExecutor", "RequestBody is null, content type is not support!!");
                return new com.bytedance.sdk.component.d.hf(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            xj(xjVar);
            xjVar.xj((Object) hf());
            zg hf = this.w.xj(xjVar.xj(this.xj).hf()).hf();
            if (hf == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            y c = hf.c();
            if (c != null) {
                for (int i = 0; i < c.xj(); i++) {
                    String xj = c.xj(i);
                    String hf2 = c.hf(i);
                    hashMap.put(xj, hf2);
                    if (xj != null && xj.equalsIgnoreCase("content-type")) {
                        hashMap.put("content-type", hf2 == null ? "" : hf2.toLowerCase());
                    }
                }
            }
            if (com.bytedance.sdk.component.d.u.xj.xj(hashMap)) {
                byte[] u = hf.y().u();
                hfVar = new com.bytedance.sdk.component.d.hf(hf.u(), hf.w(), hf.kd(), hashMap, null, hf.hf(), hf.xj());
                hfVar.xj(u);
            } else if (this.c) {
                byte[] u2 = hf.y().u();
                hfVar = new com.bytedance.sdk.component.d.hf(hf.u(), hf.w(), hf.kd(), hashMap, new String(u2, xj(xj(hf.y()))), hf.hf(), hf.xj());
                hfVar.xj(u2);
            } else {
                hfVar = new com.bytedance.sdk.component.d.hf(hf.u(), hf.w(), hf.kd(), hashMap, hf.y().hf(), hf.hf(), hf.xj());
            }
            xj(hfVar, hf);
            return hfVar;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.d.hf(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset xj(tf tfVar) {
        try {
            return tfVar != null ? tfVar.xj(com.bytedance.sdk.component.hf.xj.hf.tf.xj) : com.bytedance.sdk.component.hf.xj.hf.tf.xj;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.hf.xj.hf.tf.xj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tf xj(e eVar) {
        try {
            return eVar.kd();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.component.d.hf hfVar, zg zgVar) {
        if (hfVar == null || zgVar == null) {
            return;
        }
        hfVar.xj(zgVar.d());
    }
}
