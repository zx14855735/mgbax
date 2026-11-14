package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.config.v;
import com.ss.android.downloadlib.addownload.pl;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    private final AtomicInteger xj;

    public static class xj {
        private static y xj = new y();

        static {
            RimrNM();
        }

        private static /* synthetic */ void RimrNM() {
            char[] charArray = "ÔØÚ\u0099ÐÖÚÒ\u0099ÕØÎ\u0099ÄßÒÛÛ\u0099ýÙÞõÅÞÓÐÒ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 183);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÔÛÞÙÞÃ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 183);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private y() {
        this.xj = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hf() {
        return (this.xj.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com").concat("/customer/api/app/deep_link");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(final com.ss.android.downloadlib.addownload.hf.kd kdVar, final String str, final byte[] bArr, final f fVar) {
        pl.u().xj(str, bArr, "application/json; charset=utf-8", 0, new v() { // from class: com.ss.android.downloadlib.addownload.compliance.y.2
            @Override // com.ss.android.download.api.config.v
            public void xj(String str2) {
                y.this.xj(kdVar, str2, fVar);
            }

            @Override // com.ss.android.download.api.config.v
            public void xj(Throwable th) {
                y.this.xj(kdVar, str, bArr, fVar);
            }
        });
    }

    public static y xj() {
        return xj.xj;
    }

    public void xj(final com.ss.android.downloadlib.addownload.hf.kd kdVar, final f fVar) {
        if (pl.u() == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("getDownloadNetworkFactory == NULL");
            xj(401, kdVar);
        } else {
            com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y yVar = y.this;
                    yVar.hf(kdVar, yVar.hf(), y.this.xj(kdVar, true, 4), fVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.ss.android.downloadlib.addownload.hf.kd kdVar, String str, byte[] bArr, f fVar) {
        if (this.xj.get() < 6) {
            this.xj.incrementAndGet();
            hf(kdVar, str, bArr, fVar);
        } else {
            xj("当前网络不佳，请稍后再试");
            this.xj.set(0);
            xj(402, kdVar);
        }
    }

    private void xj(final String str) {
        com.ss.android.downloadlib.f.xj().hf().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.y.3
            @Override // java.lang.Runnable
            public void run() {
                pl.w().xj(6, pl.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] xj(com.ss.android.downloadlib.addownload.hf.kd kdVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", kdVar.xj());
            jSONObject.put(n.p, kdVar.kd());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", pl.getContext().getPackageName());
                jSONObject.put("sender_version", pl.tf().kd);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, String.valueOf(kdVar.hf()));
                if (kdVar.pz().getDeepLink() != null) {
                    if (TextUtils.isEmpty(kdVar.pz().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.kd.w.xj().xj("web_url is null");
                    }
                    jSONObject.put("web_url", kdVar.pz().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.kd.w.xj().xj("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.kd.w.xj().xj("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.ss.android.downloadlib.addownload.hf.kd kdVar, String str, f fVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.kd.w.xj().xj("response content is null");
                xj(404, kdVar);
                fVar.xj();
                return;
            }
            this.xj.set(0);
            kd c = kd.c(str);
            if (c.xj() != 0) {
                xj(403, kdVar);
                fVar.xj();
            } else if (TextUtils.isEmpty(c.hf())) {
                xj(405, kdVar);
                fVar.xj();
            } else {
                fVar.xj(c.hf());
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.kd.w.xj().xj(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void xj(int i, com.ss.android.downloadlib.addownload.hf.kd kdVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("get_miui_market_compliance_error", jSONObject, kdVar);
    }

    public void xj(int i, com.ss.android.downloadlib.addownload.hf.kd kdVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("get_miui_market_compliance_success", jSONObject, kdVar);
    }
}
