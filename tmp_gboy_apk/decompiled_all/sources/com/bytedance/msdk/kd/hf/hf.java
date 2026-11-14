package com.bytedance.msdk.kd.hf;

import android.os.SystemClock;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.f.l;
import com.bytedance.msdk.f.qt;
import com.bytedance.msdk.f.ra;
import com.bytedance.msdk.f.w;
import com.bytedance.msdk.kd.kd;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements xj<com.bytedance.msdk.kd.xj> {
    private static volatile boolean hf = true;
    public static volatile boolean xj;
    private int w = 0;
    private int u = 0;

    private byte[] hf(List<com.bytedance.msdk.kd.xj> list) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject w = w(list);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        try {
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (IOException e) {
                    pl.xj(e);
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(w.toString().getBytes());
            gZIPOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            gZIPOutputStream2 = gZIPOutputStream;
            xj("buildAdEventV3BodyRaw", "exception: " + e.toString());
            pl.xj(e);
            if (gZIPOutputStream2 != null) {
                gZIPOutputStream2.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException e4) {
                    pl.xj(e4);
                }
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] u(List<com.bytedance.msdk.kd.xj> list) {
        try {
            return xj(w.xj(w(list)).toString());
        } catch (Throwable th) {
            xj("buildAdEventV3Body2", "exception: " + th.toString());
            pl.xj(th);
            return null;
        }
    }

    private JSONObject w(List<com.bytedance.msdk.kd.xj> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", dk.z());
            jSONObject.put("client_ip", dk.ht());
            jSONObject.put("header", ra.hf());
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.msdk.kd.xj> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().hf);
            }
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
            return jSONObject;
        } catch (JSONException e) {
            xj("getAdEventV3Json", "exception: " + e.toString());
            pl.xj(e);
            return jSONObject;
        }
    }

    @Override // com.bytedance.msdk.kd.hf.xj
    public boolean xj() {
        com.bytedance.sdk.component.u.xj y = l.y();
        return (com.bytedance.msdk.core.hf.hf().hf() || y == null || !y.getArmorLoadStatus()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.msdk.kd.kd xj(java.lang.String r4, byte[] r5, boolean r6) {
        /*
            r3 = this;
            com.bytedance.msdk.u.hf r0 = com.bytedance.msdk.u.hf.xj()
            com.bytedance.sdk.component.d.xj r0 = r0.hf()
            com.bytedance.sdk.component.d.hf.kd r0 = r0.hf()
            r0.xj(r4)
            com.bytedance.msdk.core.xj r4 = com.bytedance.msdk.core.xj.p()
            java.lang.String r4 = r4.f()
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L29
            java.lang.String r1 = "X-Tt-Env"
            r0.hf(r1, r4)
            java.lang.String r4 = "x-use-ppe"
            java.lang.String r1 = "1"
            r0.hf(r4, r1)
        L29:
            if (r6 == 0) goto L3c
            java.lang.String r4 = "x-pglcypher"
            java.lang.String r6 = "4"
            r0.hf(r4, r6)
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r6 = "union_sdk_encode"
            r0.hf(r4, r6)
            java.lang.String r4 = "application/octet-stream"
            goto L3e
        L3c:
            java.lang.String r4 = "application/octet-stream;tt-data=a"
        L3e:
            java.lang.String r6 = "User-Agent"
            java.lang.String r1 = com.bytedance.msdk.hf.hf.xj
            r0.hf(r6, r1)
            r0.xj(r4, r5)
            com.bytedance.sdk.component.d.hf r4 = r0.xj()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L99
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L61
            java.lang.String r1 = r4.u()     // Catch: org.json.JSONException -> L61
            r0.<init>(r1)     // Catch: org.json.JSONException -> L61
            boolean r0 = r3.xj(r0)     // Catch: org.json.JSONException -> L61
            if (r0 == 0) goto L99
            r0 = 1
            goto L9a
        L61:
            r0 = move-exception
            int r1 = r3.u
            int r2 = r1 + 1
            r3.u = r2
            r2 = 20
            if (r1 >= r2) goto L7f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "exception: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "doUploadApplogAdEvent"
            xj(r2, r1)
        L7f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ignore:"
            r1.<init>(r2)
            java.lang.String r2 = r0.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "uploadEvent"
            com.bytedance.msdk.xj.kd.w.u(r2, r1)
            com.bytedance.sdk.component.utils.pl.xj(r0)
        L99:
            r0 = 0
        L9a:
            if (r4 == 0) goto La1
            int r1 = r4.xj()
            goto La2
        La1:
            r1 = 0
        La2:
            if (r0 != 0) goto Lab
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto Lab
            java.lang.String r4 = "server say not success"
            goto Lcb
        Lab:
            if (r4 == 0) goto Lc8
            java.lang.String r5 = r4.hf()
            if (r0 != 0) goto Lc6
            java.lang.String r2 = "::"
            java.lang.StringBuilder r5 = B4ZgIw.AYUAbz.A5SV6n(r5, r2)
            java.lang.String r4 = r4.u()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        Lc4:
            r5 = 0
            goto Lcb
        Lc6:
            r4 = r5
            goto Lc4
        Lc8:
            java.lang.String r4 = "error unknown"
            goto Lc4
        Lcb:
            com.bytedance.msdk.kd.kd r6 = new com.bytedance.msdk.kd.kd
            r6.<init>(r0, r1, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.kd.hf.hf.xj(java.lang.String, byte[], boolean):com.bytedance.msdk.kd.kd");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.msdk.kd.kd xj(java.lang.String r5, byte[] r6) {
        /*
            r4 = this;
            com.bytedance.msdk.u.hf r0 = com.bytedance.msdk.u.hf.xj()
            com.bytedance.sdk.component.d.xj r0 = r0.hf()
            com.bytedance.sdk.component.d.hf.kd r0 = r0.hf()
            r0.xj(r5)
            com.bytedance.msdk.core.xj r5 = com.bytedance.msdk.core.xj.p()
            java.lang.String r5 = r5.f()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L29
            java.lang.String r1 = "X-Tt-Env"
            r0.hf(r1, r5)
            java.lang.String r5 = "x-use-ppe"
            java.lang.String r1 = "1"
            r0.hf(r5, r1)
        L29:
            java.lang.String r5 = "User-Agent"
            java.lang.String r1 = com.bytedance.msdk.hf.hf.xj
            r0.hf(r5, r1)
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r1 = "union_sdk_encode"
            r0.hf(r5, r1)
            java.lang.String r5 = "application/json; charset=utf-8"
            r0.xj(r5, r6)
            com.bytedance.sdk.component.d.hf r5 = r0.xj()
            r6 = 1
            r0 = 0
            if (r5 == 0) goto L8d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L55
            java.lang.String r2 = r5.u()     // Catch: org.json.JSONException -> L55
            r1.<init>(r2)     // Catch: org.json.JSONException -> L55
            boolean r1 = r4.xj(r1)     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto L8d
            r1 = 1
            goto L8e
        L55:
            r1 = move-exception
            int r2 = r4.u
            int r3 = r2 + 1
            r4.u = r3
            r3 = 20
            if (r2 >= r3) goto L73
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "exception: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "doUploadApplogAdEventV3"
            xj(r3, r2)
        L73:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "ignore:"
            r2.<init>(r3)
            java.lang.String r3 = r1.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "uploadEvent"
            com.bytedance.msdk.xj.kd.w.u(r3, r2)
            com.bytedance.sdk.component.utils.pl.xj(r1)
        L8d:
            r1 = 0
        L8e:
            if (r5 == 0) goto L95
            int r2 = r5.xj()
            goto L96
        L95:
            r2 = 0
        L96:
            if (r1 != 0) goto L9f
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L9f
            java.lang.String r5 = "server say not success"
            goto Lbf
        L9f:
            if (r5 == 0) goto Lbc
            java.lang.String r6 = r5.hf()
            if (r1 != 0) goto Lba
            java.lang.String r3 = "::"
            java.lang.StringBuilder r6 = B4ZgIw.AYUAbz.A5SV6n(r6, r3)
            java.lang.String r5 = r5.u()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
        Lb8:
            r6 = 0
            goto Lbf
        Lba:
            r5 = r6
            goto Lb8
        Lbc:
            java.lang.String r5 = "error unknown"
            goto Lb8
        Lbf:
            com.bytedance.msdk.kd.kd r0 = new com.bytedance.msdk.kd.kd
            r0.<init>(r1, r2, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.kd.hf.hf.xj(java.lang.String, byte[]):com.bytedance.msdk.kd.kd");
    }

    @Override // com.bytedance.msdk.kd.hf.xj
    public kd xj(List<com.bytedance.msdk.kd.xj> list) {
        kd xj2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (list == null) {
            return null;
        }
        boolean z = true;
        try {
            if (list.isEmpty()) {
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- v3: " + list.size());
            boolean xj3 = xj();
            byte[] xj4 = xj(list, xj3);
            if (xj4 != null && xj4.length > 0) {
                xj2 = xj(com.bytedance.msdk.core.w.hf(), xj4, xj3);
            } else {
                xj2 = xj(com.bytedance.msdk.core.w.hf(), u(list));
            }
            if (list.size() < com.bytedance.msdk.core.hf.hf().io()) {
                z = false;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            ai.xj(xj2.xj, list.size(), xj(z), elapsedRealtime2, xj2.hf + "::" + xj2.w);
            return xj2;
        } catch (Throwable th) {
            int i = this.w;
            this.w = i + 1;
            if (i < 20) {
                xj("uploadEvent", "exception: " + th.toString());
            }
            com.bytedance.msdk.xj.kd.w.u("ReportNetApiImpl", "uploadEvent error:");
            pl.xj(th);
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
            ai.xj(false, 0, xj(z), elapsedRealtime3, "-1::" + th);
            return new kd(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, "service_busy", false);
        }
    }

    private String xj(boolean z) {
        if (hf) {
            hf = false;
            return "1";
        }
        if (xj) {
            xj = false;
            return "4";
        }
        if (z) {
            return "3";
        }
        return "2";
    }

    private byte[] xj(List<com.bytedance.msdk.kd.xj> list, boolean z) {
        byte[] xj2;
        byte[] hf2 = hf(list);
        if (hf2 == null) {
            xj("buildAdEventV3Body", "zipData is null");
        } else if (hf2.length <= 0) {
            xj("buildAdEventV3Body", "zipData len 0");
        }
        com.bytedance.sdk.component.u.xj y = l.y();
        if (z) {
            xj2 = y.encrypt(hf2);
        } else {
            xj2 = xj(hf2, hf2.length);
        }
        if (xj2 == null) {
            xj("buildAdEventV3Body", "data is null");
            return xj2;
        }
        if (xj2.length <= 0) {
            xj("buildAdEventV3Body", "data len 0");
        }
        return xj2;
    }

    private byte[] xj(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    private byte[] xj(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return qt.xj(bArr, i);
                }
            } catch (Throwable th) {
                xj("encrypt", "exception: " + th.toString());
                pl.xj(th);
                return null;
            }
        }
        StringBuilder sb = new StringBuilder("inputData is ");
        sb.append(bArr == null ? "null" : Constants.FAIL);
        xj("encrypt", sb.toString());
        return null;
    }

    public static void xj(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("v3_Id", str);
            jSONObject.putOpt("v3_err_msg", str2);
            ai.xj(jSONObject);
        } catch (Throwable unused) {
        }
    }

    private boolean xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt(PluginConstants.KEY_ERROR_CODE) != 20000) {
                    return cb.o.equals(jSONObject.optString("message"));
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
