package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import com.ss.android.downloadlib.addownload.kd;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private com.ss.android.downloadlib.addownload.hf.kd hf;
    private Handler xj;
    private AtomicBoolean w = new AtomicBoolean(false);
    private AtomicBoolean u = new AtomicBoolean(false);

    public u(Handler handler) {
        this.xj = handler;
    }

    public static long hf() {
        if (pl.g() != null) {
            return pl.g().xj();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long u() {
        return com.ss.android.downloadlib.c.g.hf(0L);
    }

    private void hf(com.ss.android.downloadad.api.xj.hf hfVar, JSONObject jSONObject, long j, long j2) {
        hfVar.pl("1");
        com.ss.android.downloadlib.addownload.hf.d.xj().xj(hfVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("cleanspace_download_after_quite_clean", jSONObject, hfVar);
    }

    public void xj(com.ss.android.downloadlib.addownload.hf.kd kdVar) {
        this.hf = kdVar;
    }

    public boolean xj() {
        return this.u.get();
    }

    public void xj(boolean z) {
        this.u.set(z);
    }

    public void xj(final int i, final long j, long j2, kd.xj xjVar) {
        final kd.xj xjVar2;
        this.u.set(false);
        if (xjVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.c.kd.y(i) && com.ss.android.downloadlib.c.kd.kd(i)) {
            long w = com.ss.android.downloadlib.c.kd.w(i);
            this.w.set(false);
            final String downloadUrl = this.hf.hf.getDownloadUrl();
            com.ss.android.downloadad.api.xj.hf hf = com.ss.android.downloadlib.addownload.hf.y.xj().hf(downloadUrl);
            if (hf == null) {
                com.ss.android.downloadlib.addownload.hf.kd kdVar = this.hf;
                hf = new com.ss.android.downloadad.api.xj.hf(kdVar.hf, kdVar.w, kdVar.u, 0);
                com.ss.android.downloadlib.addownload.hf.y.xj().xj(hf);
            }
            final com.ss.android.downloadad.api.xj.hf hfVar = hf;
            hfVar.kd(false);
            if (pl.g() != null) {
                pl.g();
                hfVar.hf();
            }
            com.ss.android.downloadlib.addownload.w.u.xj().xj(hfVar.xj());
            boolean u = com.ss.android.downloadlib.c.kd.u(i);
            if (j2 > 0) {
                xj(i, downloadUrl, j2, hfVar, j, xjVar);
                xjVar2 = xjVar;
            } else if (u) {
                xjVar2 = xjVar;
                xj(downloadUrl, hfVar, new kd.hf() { // from class: com.ss.android.downloadlib.addownload.u.1
                    @Override // com.ss.android.downloadlib.addownload.kd.hf
                    public void xj(long j3) {
                        u.this.xj(i, downloadUrl, j3, hfVar, j, xjVar2);
                    }
                });
            } else {
                xjVar2 = xjVar;
                w = 0;
            }
            this.xj.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.u.2
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.w.get()) {
                        return;
                    }
                    u.this.w.set(true);
                    xjVar2.xj();
                }
            }, w);
            return;
        }
        xjVar.xj();
    }

    private void xj(String str, com.ss.android.downloadad.api.xj.hf hfVar, final kd.hf hfVar2) {
        if (hfVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.xj.hf.xj(str, new com.ss.android.socialbase.downloader.network.tf() { // from class: com.ss.android.downloadlib.addownload.u.3
            @Override // com.ss.android.socialbase.downloader.network.tf
            public void xj(Map<String, String> map) {
                if (u.this.w.get()) {
                    return;
                }
                u.this.w.set(true);
                long xj = u.this.xj(map);
                if (xj > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(xj));
                        jSONObject.putOpt("available_space", Long.valueOf(u.u()));
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
                hfVar2.xj(xj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long xj(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(int r13, java.lang.String r14, long r15, final com.ss.android.downloadad.api.xj.hf r17, long r18, final com.ss.android.downloadlib.addownload.kd.xj r20) {
        /*
            r12 = this;
            r1 = r15
            r8 = r20
            java.util.concurrent.atomic.AtomicBoolean r0 = r12.w
            r9 = 1
            r0.set(r9)
            r3 = 0
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7d
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r0 = "apk_size"
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch: org.json.JSONException -> L1e
            r3.putOpt(r0, r4)     // Catch: org.json.JSONException -> L1e
            goto L22
        L1e:
            r0 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r0)
        L22:
            double r4 = com.ss.android.downloadlib.c.kd.xj(r13)
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 + r6
            double r0 = (double) r1
            double r4 = r4 * r0
            java.lang.Double r0 = java.lang.Double.valueOf(r4)
            long r0 = r0.longValue()
            long r4 = com.ss.android.downloadlib.c.kd.hf(r13)
            long r4 = r4 + r0
            long r4 = r4 - r18
            long r6 = u()
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L7d
            r1 = r12
            r2 = r17
            r1.xj(r2, r3, r4, r6)
            xj(r2)
            r10 = r4
            r4 = r6
            long r6 = u()
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 >= 0) goto L79
            r2.u(r9)
            java.lang.String r0 = r2.xj()
            com.ss.android.downloadlib.addownload.w.u r3 = com.ss.android.downloadlib.addownload.w.u.xj()
            com.ss.android.downloadlib.addownload.u$4 r4 = new com.ss.android.downloadlib.addownload.u$4
            r4.<init>()
            r3.xj(r0, r4)
            r1 = r12
            r4 = r14
            r3 = r2
            r5 = r10
            r2 = r13
            boolean r13 = r1.xj(r2, r3, r4, r5)
            r2 = r3
            if (r13 == 0) goto L7e
            r2.kd(r9)
            goto L7e
        L79:
            r1 = r12
            r1.hf(r2, r3, r4, r6)
        L7d:
            r13 = 0
        L7e:
            if (r13 != 0) goto L8a
            android.os.Handler r13 = r12.xj
            com.ss.android.downloadlib.addownload.u$5 r14 = new com.ss.android.downloadlib.addownload.u$5
            r14.<init>()
            r13.post(r14)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.u.xj(int, java.lang.String, long, com.ss.android.downloadad.api.xj.hf, long, com.ss.android.downloadlib.addownload.kd$xj):void");
    }

    private boolean xj(int i, com.ss.android.downloadad.api.xj.hf hfVar, String str, long j) {
        if (!com.ss.android.downloadlib.c.kd.y(i)) {
            return false;
        }
        if (pl.g() != null) {
            return pl.g().xj(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("cleanspace_window_show", jSONObject, hfVar);
        return false;
    }

    public static boolean xj(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        if (!com.ss.android.downloadlib.c.kd.y(id) || pl.g() == null) {
            return false;
        }
        boolean xj = pl.g().xj(id, downloadInfo.getUrl(), false, j);
        if (xj) {
            com.ss.android.downloadlib.addownload.w.u.xj().xj(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.w.kd() { // from class: com.ss.android.downloadlib.addownload.u.6
            });
        }
        return xj;
    }

    public static JSONObject xj(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }

    public static void xj(int i) {
        if (com.ss.android.downloadlib.c.kd.y(i) && pl.g() != null && pl.g().hf()) {
            pl.g();
        }
    }

    private static void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        long u = u();
        if (pl.g() != null) {
            pl.g();
        }
        com.ss.android.downloadlib.addownload.w.w.xj();
        com.ss.android.downloadlib.addownload.w.w.hf();
        if (com.ss.android.downloadlib.c.kd.c(hfVar.v())) {
            com.ss.android.downloadlib.addownload.w.w.xj(pl.getContext());
        }
        long u2 = u();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(u2 - u));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("clean_quite_finish", jSONObject, hfVar);
    }

    private void xj(com.ss.android.downloadad.api.xj.hf hfVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.ss.android.downloadlib.u.xj.xj().xj("clean_space_no_enough_for_download", jSONObject, hfVar);
    }
}
