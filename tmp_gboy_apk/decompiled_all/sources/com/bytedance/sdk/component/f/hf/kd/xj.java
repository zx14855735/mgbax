package com.bytedance.sdk.component.f.hf.kd;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.f.hf.w.w;
import com.bytedance.sdk.component.f.xj.f;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.u;
import com.bytedance.sdk.component.f.xj.xj.y;
import io.dcloud.openapi.core.util.Const;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.f.xj.xj.xj<com.bytedance.sdk.component.f.xj.hf> {
    private static final SimpleDateFormat hf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private kd u;
    private final String w = "x-pglcypher";
    private final boolean xj = hf();

    static {
        sKRWHsi();
    }

    public static byte[] hf(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    private int kd(JSONObject jSONObject) {
        String optString;
        int indexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            optString = jSONObject.optString("s_sig_ts");
        } catch (Throwable unused) {
        }
        if (optString == null || (indexOf = optString.indexOf("_")) < 5) {
            return 512;
        }
        String substring = optString.substring(0, indexOf);
        String substring2 = optString.substring(indexOf + 1);
        JSONObject d = xj().u().pl().d();
        if (xj((d != null ? d.optString("device_id") : "") + "_" + substring, substring2)) {
            if (Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(substring).longValue()) > 300) {
                return MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID;
            }
            return 0;
        }
        return 512;
    }

    private static /* synthetic */ void sKRWHsi() {
        char[] charArray = "Q]_\u001cUS_W\u001cP]K\u001cAZW^^\u001cx\\[p@[VUW".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '2');
        }
        String str = new String(charArray);
        char[] charArray2 = "Q^[\\[F".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '2');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Map<String, String> u(JSONObject jSONObject) {
        HashMap BI9f7h2 = A2egSU.BI9f7h("Content-Type", "application/json; charset=utf-8");
        if (y(jSONObject)) {
            BI9f7h2.put("Content-Encoding", "union_sdk_encode");
        }
        return BI9f7h2;
    }

    private boolean y(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    public boolean w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase(cb.o);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean hf() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static PublicKey w() {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public kd xj() {
        if (this.u == null) {
            this.u = com.bytedance.sdk.component.f.hf.xj.w(Const.TYPE_CSJ).w();
        }
        return this.u;
    }

    public List<com.bytedance.sdk.component.f.xj.hf> hf(List<com.bytedance.sdk.component.f.xj.hf> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.component.f.xj.hf hfVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject c = hfVar.c();
                String optString = c.optString("label");
                if (TextUtils.isEmpty(optString)) {
                    optString = c.optString("event");
                }
                jSONObject.putOpt("event", optString);
                long optLong = c.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(optLong));
                jSONObject.putOpt("datetime", hf.format(new Date(optLong)));
                JSONObject jSONObject2 = new JSONObject();
                if (c.has("params") && c.has("event")) {
                    jSONObject2 = c.optJSONObject("params");
                } else {
                    Iterator<String> keys = c.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.equals(next, "label")) {
                            jSONObject2.putOpt(next, c.opt(next));
                        }
                    }
                }
                jSONObject.putOpt("params", jSONObject2);
                com.bytedance.sdk.component.f.hf.u.xj.xj xjVar = new com.bytedance.sdk.component.f.hf.u.xj.xj(hfVar.w(), jSONObject);
                xjVar.xj(hfVar.u());
                xjVar.hf(hfVar.kd());
                arrayList.add(xjVar);
            } catch (Exception e) {
                w.w(e.getMessage(), xj());
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.f.xj.xj.xj
    public com.bytedance.sdk.component.f.hf.hf.w.hf xj(List<com.bytedance.sdk.component.f.xj.hf> list) {
        f pl2;
        com.bytedance.sdk.component.f.hf.hf.w.hf xj;
        String str;
        u u = xj().u();
        if (u != null) {
            try {
                if (u.u() && (pl2 = u.pl()) != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    String str2 = "1streqid";
                    String str3 = "2ndreqid";
                    String str4 = "";
                    boolean z = false;
                    for (com.bytedance.sdk.component.f.xj.hf hfVar : list) {
                        if (TextUtils.equals("show", com.bytedance.sdk.component.f.hf.w.xj.xj(hfVar, xj()))) {
                            String xj2 = com.bytedance.sdk.component.f.hf.w.xj.xj(hfVar.c(), this.u);
                            if (!z) {
                                str = com.bytedance.sdk.component.f.hf.w.xj.y(hfVar, this.u);
                            } else {
                                str3 = com.bytedance.sdk.component.f.hf.w.xj.y(hfVar, this.u);
                                str = str3;
                            }
                            str4 = xj2;
                            str2 = str;
                            z = true;
                        }
                        arrayList.add(hfVar);
                    }
                    int tf = pl2.tf();
                    if (!arrayList.isEmpty()) {
                        JSONObject xj3 = pl2.xj(hf(arrayList), this.xj);
                        byte[] xj4 = pl2.xj(xj3, tf);
                        if (xj4 == null) {
                            JSONObject xj5 = pl2.xj(xj3);
                            xj4 = hf(xj5);
                            xj = xj(xj4, u(xj5), "application/json; charset=utf-8");
                        } else {
                            xj = xj(xj4, xj(tf), hf(tf));
                        }
                        if (z) {
                            int length = xj4 != null ? xj4.length : 0;
                            if (xj != null) {
                                com.bytedance.sdk.component.f.hf.w.xj.xj(xj.xj, xj.hf, xj.w, CtFAbx.AlLFFp(str2, "|", str3), length, str4);
                            }
                        }
                        return xj;
                    }
                }
                return null;
            } catch (Throwable th) {
                w.w("NetApiImpl", A2egSU.B4ZgIw(th, new StringBuilder("uploadEvent error")), xj());
                return new com.bytedance.sdk.component.f.hf.hf.w.hf(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, th.getMessage(), false, "error");
            }
        }
        return null;
    }

    private void hf(byte[] bArr, Map<String, String> map, String str) {
        kd xj;
        u u;
        f pl2;
        if (bArr == null || bArr.length == 0 || (xj = xj()) == null || (u = xj.u()) == null || (pl2 = u.pl()) == null || !pl2.xj()) {
            return;
        }
        y kd = pl2.kd();
        kd.xj(pl2.hf());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                kd.xj(entry.getKey(), entry.getValue());
            }
        }
        kd.xj(str, bArr);
        kd.xj("User-Agent", u.kd());
        kd.xj(new com.bytedance.sdk.component.f.xj.xj.w() { // from class: com.bytedance.sdk.component.f.hf.kd.xj.1
            @Override // com.bytedance.sdk.component.f.xj.xj.w
            public void xj(com.bytedance.sdk.component.f.xj.xj.u uVar, com.bytedance.sdk.component.f.xj.xj.kd kdVar) {
                if (kdVar == null || !kdVar.xj()) {
                    xj.this.xj();
                } else {
                    kdVar.hf();
                    xj.this.xj();
                }
            }

            @Override // com.bytedance.sdk.component.f.xj.xj.w
            public void xj(com.bytedance.sdk.component.f.xj.xj.u uVar, IOException iOException) {
                iOException.getMessage();
                xj.this.xj();
            }
        });
    }

    private String hf(int i) {
        if (i >= 4) {
            return "application/octet-stream";
        }
        return "application/octet-stream;tt-data=a";
    }

    private Map<String, String> xj(int i) {
        HashMap hashMap = new HashMap();
        if (i >= 4) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
            hashMap.put("x-pglcypher", String.valueOf(i));
        }
        hashMap.put("Content-Type", hf(i));
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.sdk.component.f.hf.hf.w.hf xj(byte[] r10, java.util.Map<java.lang.String, java.lang.String> r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.kd.xj.xj(byte[], java.util.Map, java.lang.String):com.bytedance.sdk.component.f.hf.hf.w.hf");
    }

    private boolean xj(String str, String str2) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(w().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(generatePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
    
        if (r2 == 60005) goto L50;
     */
    @Override // com.bytedance.sdk.component.f.xj.xj.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.f.hf.hf.w.hf xj(org.json.JSONObject r13) {
        /*
            r12 = this;
            com.bytedance.sdk.component.f.xj.kd r0 = r12.xj()
            com.bytedance.sdk.component.f.xj.u r0 = r0.u()
            r1 = 0
            if (r0 == 0) goto Ld2
            boolean r2 = r0.u()
            if (r2 != 0) goto L13
            goto Ld2
        L13:
            if (r13 == 0) goto Ld2
            int r2 = r13.length()
            if (r2 > 0) goto L1d
            goto Ld2
        L1d:
            com.bytedance.sdk.component.f.xj.f r2 = r0.pl()
            if (r2 != 0) goto L24
            return r1
        L24:
            com.bytedance.sdk.component.f.xj.xj.y r1 = r2.kd()
            java.lang.String r3 = r2.c()
            r1.xj(r3)
            int r3 = r2.tf()
            byte[] r4 = r2.hf(r13, r3)
            if (r4 != 0) goto L45
            org.json.JSONObject r13 = r2.xj(r13)
            java.lang.String r13 = r13.toString()
            r1.hf(r13)
            goto L55
        L45:
            java.lang.String r13 = r12.hf(r3)
            r1.xj(r13, r4)
            java.lang.String r13 = "x-pglcypher"
            java.lang.String r2 = java.lang.String.valueOf(r3)
            r1.xj(r13, r2)
        L55:
            java.lang.String r13 = "User-Agent"
            java.lang.String r0 = r0.kd()
            r1.xj(r13, r0)
            java.lang.String r5 = "error unknown"
            r13 = 0
            com.bytedance.sdk.component.f.xj.xj.kd r0 = r1.xj()     // Catch: java.lang.Throwable -> Lc5
            if (r0 != 0) goto L72
            com.bytedance.sdk.component.f.hf.hf.w.hf r2 = new com.bytedance.sdk.component.f.hf.hf.w.hf     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r7 = "ignore"
            r3 = 0
            r4 = 0
            r6 = 0
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lc5
            return r2
        L72:
            boolean r1 = r0.xj()     // Catch: java.lang.Throwable -> Lc5
            if (r1 == 0) goto Laa
            java.lang.String r1 = r0.hf()     // Catch: java.lang.Throwable -> Lc5
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lc5
            if (r1 != 0) goto Laa
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = r0.hf()     // Catch: java.lang.Throwable -> Lc5
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = "code"
            r3 = -1
            int r2 = r1.optInt(r2, r3)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r3 = "data"
            java.lang.String r4 = ""
            java.lang.String r5 = r1.optString(r3, r4)     // Catch: java.lang.Throwable -> Lc5
            r1 = 20000(0x4e20, float:2.8026E-41)
            r3 = 1
            if (r2 != r1) goto La1
            r1 = 1
            goto La2
        La1:
            r1 = 0
        La2:
            r4 = 60005(0xea65, float:8.4085E-41)
            if (r2 != r4) goto La8
            goto Lac
        La8:
            r3 = 0
            goto Lac
        Laa:
            r1 = 0
            goto La8
        Lac:
            int r13 = r0.w()     // Catch: java.lang.Throwable -> Lc2
            boolean r2 = r0.xj()     // Catch: java.lang.Throwable -> Lbf
            if (r2 != 0) goto Lba
            java.lang.String r5 = r0.u()     // Catch: java.lang.Throwable -> Lbf
        Lba:
            r8 = r13
            r7 = r1
        Lbc:
            r10 = r3
            r9 = r5
            goto Lca
        Lbf:
            r0 = r13
            r13 = r1
            goto Lc7
        Lc2:
            r13 = r1
            r0 = 0
            goto Lc7
        Lc5:
            r0 = 0
            r3 = 0
        Lc7:
            r7 = r13
            r8 = r0
            goto Lbc
        Lca:
            com.bytedance.sdk.component.f.hf.hf.w.hf r6 = new com.bytedance.sdk.component.f.hf.hf.w.hf
            java.lang.String r11 = "ignore"
            r6.<init>(r7, r8, r9, r10, r11)
            return r6
        Ld2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.kd.xj.xj(org.json.JSONObject):com.bytedance.sdk.component.f.hf.hf.w.hf");
    }
}
