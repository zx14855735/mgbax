package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c implements IDownloadHttpService {
    private final com.ss.android.socialbase.downloader.tf.f<String, OkHttpClient> xj = new com.ss.android.socialbase.downloader.tf.f<>(4, 8);

    private OkHttpClient xj(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.xj) {
                    try {
                        OkHttpClient okHttpClient = this.xj.get(str3);
                        if (okHttpClient != null) {
                            return okHttpClient;
                        }
                        OkHttpClient.Builder pz = com.ss.android.socialbase.downloader.downloader.w.pz();
                        pz.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.c.2
                        });
                        OkHttpClient build = pz.build();
                        synchronized (this.xj) {
                            this.xj.put(str3, build);
                        }
                        return build;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.pl.xj(th2);
        }
        return com.ss.android.socialbase.downloader.downloader.w.v();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.d downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.w> list) {
        String str2;
        Request.Builder url = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (com.ss.android.socialbase.downloader.model.w wVar : list) {
                String xj = wVar.xj();
                if (str2 == null && "ss_d_request_host_ip_114".equals(xj)) {
                    str2 = wVar.hf();
                } else {
                    url.addHeader(xj, com.ss.android.socialbase.downloader.tf.y.c(wVar.hf()));
                }
            }
        }
        OkHttpClient xj2 = !TextUtils.isEmpty(str2) ? xj(str, str2) : com.ss.android.socialbase.downloader.downloader.w.v();
        if (xj2 == null) {
            throw new IOException("can't get httpClient");
        }
        final Call newCall = xj2.newCall(url.build());
        final Response execute = newCall.execute();
        if (execute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody body = execute.body();
        if (body == null) {
            return null;
        }
        InputStream byteStream = body.byteStream();
        String header = execute.header("Content-Encoding");
        final InputStream gZIPInputStream = (header == null || !"gzip".equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream);
        return new com.ss.android.socialbase.downloader.network.kd() { // from class: com.ss.android.socialbase.downloader.impls.c.1
            @Override // com.ss.android.socialbase.downloader.network.c
            public int hf() {
                return execute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.xj
            public String kd() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.network.d
            public void u() {
                try {
                    ResponseBody responseBody = body;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = newCall;
                    if (call == null || call.isCanceled()) {
                        return;
                    }
                    newCall.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.c
            public void w() {
                Call call = newCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                newCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.d
            public InputStream xj() {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.network.c
            public String xj(String str3) {
                return execute.header(str3);
            }
        };
    }
}
