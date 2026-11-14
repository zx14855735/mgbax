package com.bytedance.sdk.openadsdk.pl.xj;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.qt;
import com.bytedance.sdk.component.hf.xj.tf;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.utils.kd;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.pl.xj.xj;
import com.kwad.sdk.api.model.AdnName;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    private static final ConcurrentLinkedDeque<String> f = new ConcurrentLinkedDeque<>();
    private long d;
    private String p;
    private final String tf;

    static {
        sXbSS();
    }

    public hf(com.bytedance.sdk.openadsdk.pl.xj xjVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(xjVar, str, str2, jSONObject, str3, str4);
        this.tf = "index_censorship.json";
    }

    private boolean hf(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.bytedance.sdk.openadsdk.pl.hf.hf.xj(str, str2);
            return true;
        } catch (Throwable th) {
            pl.xj(th);
            return false;
        }
    }

    private static /* synthetic */ void sXbSS() {
        char[] charArray = "\u0001\r\u000fL\u0005\u0003\u000f\u0007L\u0000\r\u001bL\u0011\n\u0007\u000e\u000eL(\f\u000b \u0010\u000b\u0006\u0005\u0007".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'b');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0001\u000e\u000b\f\u000b\u0016".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01a0 A[Catch: Exception -> 0x0197, LOOP:0: B:74:0x01a0->B:76:0x01a8, LOOP_START, TryCatch #3 {Exception -> 0x0197, blocks: (B:69:0x019c, B:74:0x01a0, B:76:0x01a8, B:78:0x01ac, B:80:0x01b4), top: B:68:0x019c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void kd() {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.pl.xj.hf.kd():void");
    }

    public boolean u() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void w() {
        if (f.contains(this.hf)) {
            this.xj.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pl.xj.hf.3
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.xj(null, com.bytedance.sdk.openadsdk.pl.u.hf(pz.getContext()), pz.getContext(), -1L, -1L);
                }
            });
        } else if (this.u.compareAndSet(false, true)) {
            this.xj.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.pl.xj.hf.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        hf.this.kd.set(true);
                        hf.this.kd();
                        hf.this.u.set(false);
                    } catch (Throwable th) {
                        pl.xj(th);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(final String str, final String str2) {
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.pl.xj.hf.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", str);
                    jSONObject.put("req_id", str2);
                } catch (Exception e) {
                    pl.xj(e);
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("web_upload_start").hf(jSONObject.toString());
            }
        }, "web_upload_start");
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void hf(Context context, String str, com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, Map<String, Object> map) {
        try {
            if (com.bytedance.sdk.openadsdk.pl.u.w()) {
                String xj = xj(context);
                String uri = hfVar.xj().toString();
                String hf = tfVar.hf();
                if (TextUtils.equals(hf.toLowerCase(), "javascript")) {
                    hf = "js";
                }
                File file = new File(xj);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = kd.hf(uri) + "." + hf;
                File file2 = new File(xj, str2);
                if (file2.exists()) {
                    file2.delete();
                    file2.createNewFile();
                }
                file2.getAbsolutePath();
                pz.hf().hl();
                if (com.bytedance.sdk.openadsdk.pl.hf.xj.xj(webResourceResponse.getData(), xj, str2, pz.hf().hl())) {
                    xj(this.y, str, tfVar, str2, uri, hfVar.w(), map);
                }
            }
        } catch (Exception e) {
            pl.xj(e);
            e.getMessage();
        }
    }

    public void xj(final String str, final String str2, final long j, final String str3, final long j2, final long j3) {
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.pl.xj.hf.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put(MediationConstant.EXTRA_DURATION, System.currentTimeMillis() - j);
                    jSONObject.put("weburl", str3);
                    jSONObject.put("size", j2);
                    jSONObject.put("avail_mem", j3);
                } catch (Exception e) {
                    pl.xj(e);
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("web_upload_finish").hf(jSONObject.toString());
            }
        }, "web_upload_finish");
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public boolean xj(WebView webView) {
        if (webView == null || f.contains(this.hf)) {
            return true;
        }
        AtomicBoolean atomicBoolean = this.kd;
        return (atomicBoolean != null && atomicBoolean.get()) || this.xj.hf().get() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(Context context, String str, com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, Map<String, Object> map) {
        int i;
        if (com.bytedance.sdk.openadsdk.pl.u.w()) {
            String uri = hfVar.xj().toString();
            String hf = tfVar.hf();
            if (TextUtils.equals(hf.toLowerCase(), "javascript")) {
                hf = "js";
            }
            String str2 = kd.hf(uri) + "." + hf;
            if (TextUtils.isEmpty(hf)) {
                return;
            }
            HashMap<String, byte[]> hashMap = this.xj.xj().get(hf);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                this.xj.xj().put(hf, hashMap);
            }
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[1024];
            InputStream data = webResourceResponse.getData();
            while (true) {
                try {
                    try {
                        i = 0;
                        if (data.read(bArr) == -1) {
                            break;
                        }
                        while (i < 1024) {
                            arrayList.add(Byte.valueOf(bArr[i]));
                            i++;
                        }
                    } catch (Exception e) {
                        pl.xj(e);
                        if (data != null) {
                            try {
                                data.close();
                                return;
                            } catch (IOException e2) {
                                pl.xj(e2);
                                return;
                            }
                        }
                        return;
                    }
                } finally {
                }
            }
            byte[] bArr2 = new byte[arrayList.size()];
            while (i < arrayList.size()) {
                bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
                i++;
            }
            if (arrayList.size() <= pz.hf().hl() * BaseConstants.MB_VALUE) {
                hashMap.put(str2, bArr2);
                xj(this.y, str, tfVar, str2, uri, hfVar.w(), map);
            }
            try {
                data.close();
            } catch (IOException e3) {
                pl.xj(e3);
            }
        }
    }

    private int hf(byte[] bArr, int i, File file) {
        if (i <= 0) {
            return -1;
        }
        return xj(bArr, i - 1, file);
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(JSONObject jSONObject, String str, tf tfVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("name", str2);
            jSONObject2.putOpt("url", str3);
            if (map != null) {
                jSONObject2.putOpt("request_headers", new JSONObject(map));
            }
            if (tfVar != null) {
                String lowerCase = tfVar.toString().toLowerCase();
                if (lowerCase.contains("image")) {
                    xj(jSONObject2, jSONObject, "sub_pic");
                    return;
                }
                if (!lowerCase.contains("js") && !lowerCase.contains("javascript")) {
                    if (lowerCase.contains("css")) {
                        xj(jSONObject2, jSONObject, "css");
                        return;
                    } else {
                        if (lowerCase.contains(a.f)) {
                            xj(jSONObject2, jSONObject, a.f);
                            return;
                        }
                        return;
                    }
                }
                xj(jSONObject2, jSONObject, "js");
                return;
            }
            xj(jSONObject2, jSONObject, AdnName.OTHER);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    private void xj(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONArray optJSONArray = jSONObject2.optJSONArray(str);
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.y.putOpt(str, jSONArray);
            } else {
                optJSONArray.put(jSONObject);
                this.y.putOpt(str, optJSONArray);
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj() {
        try {
            this.y.putOpt(a.f, new JSONArray());
            this.y.putOpt("js", new JSONArray());
            this.y.putOpt("css", new JSONArray());
            this.y.putOpt("sub_pic", new JSONArray());
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public boolean xj(tf tfVar) {
        try {
            Set<String> n = pz.hf().n();
            String str = tfVar.xj().trim().toLowerCase() + "/" + tfVar.hf().trim().toLowerCase();
            Objects.toString(n);
            return n.contains(str);
        } catch (Exception e) {
            pl.xj(e);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.pl.xj.xj
    public void xj(com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, xj.InterfaceC0203xj interfaceC0203xj) {
        interfaceC0203xj.xj(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(File file, String str, Context context, long j, long j2) {
        try {
            com.bytedance.sdk.openadsdk.pl.hf.xj.hf(str);
            if (file != null && file.exists()) {
                file.delete();
            }
            AtomicInteger atomicInteger = com.bytedance.sdk.openadsdk.pl.u.xj;
            int i = atomicInteger.get();
            if (i > 0) {
                atomicInteger.decrementAndGet();
            }
            if (i == 0) {
                com.bytedance.sdk.openadsdk.pl.hf.xj.hf(com.bytedance.sdk.openadsdk.pl.u.hf(context));
            }
            xj(this.hf, this.w, this.d, this.c, j, j2);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private byte[] xj(byte[] bArr, int i) {
        return com.bytedance.sdk.openadsdk.x.hf.xj(bArr, i);
    }

    private String xj(Context context) {
        String str = this.p;
        if (str != null) {
            return str;
        }
        try {
            String str2 = com.bytedance.sdk.openadsdk.pl.u.hf(context) + File.separator + this.hf;
            this.p = str2;
            return str2;
        } catch (Exception e) {
            pl.xj(e);
            StringBuilder sb = new StringBuilder();
            String str3 = File.separator;
            sb.append(str3);
            sb.append(".lp_cache");
            sb.append(str3);
            sb.append(this.hf);
            return sb.toString();
        }
    }

    private int xj(byte[] bArr, int i, File file) {
        try {
            com.bytedance.sdk.component.hf.xj.pl y = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y();
            qt xj = qt.xj(tf.xj("multipart/form-data"), bArr, n.z, file.getName());
            String aq = pz.hf().aq();
            String str = "?aid=" + f.zg().pz() + "&device_platform=android&device_type=android&source_type=union";
            zg hf = y.xj(new am.xj().xj(aq + str).xj(xj).hf()).hf();
            if (hf.w() == 200) {
                JSONObject jSONObject = new JSONObject(hf.y().hf());
                int optInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
                String optString = jSONObject.optString(br.c);
                if (optInt == 0 && TextUtils.equals(cb.o, optString)) {
                    return 200;
                }
                return hf(bArr, i, file);
            }
            return hf(bArr, i, file);
        } catch (Throwable th) {
            pl.xj(th);
            th.getMessage();
            return hf(bArr, i, file);
        }
    }
}
