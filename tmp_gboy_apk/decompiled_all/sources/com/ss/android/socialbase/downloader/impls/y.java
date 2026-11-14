package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y implements com.ss.android.socialbase.downloader.network.f {
    @Override // com.ss.android.socialbase.downloader.network.f
    public com.ss.android.socialbase.downloader.network.c xj(String str, List<com.ss.android.socialbase.downloader.model.w> list) {
        OkHttpClient v = com.ss.android.socialbase.downloader.downloader.w.v();
        if (v == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder head = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.w wVar : list) {
                head.addHeader(wVar.xj(), com.ss.android.socialbase.downloader.tf.y.c(wVar.hf()));
            }
        }
        final Call newCall = v.newCall(head.build());
        final Response execute = newCall.execute();
        if (execute == null) {
            throw new IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.tf.xj.xj(2097152)) {
            execute.close();
        }
        return new com.ss.android.socialbase.downloader.network.c() { // from class: com.ss.android.socialbase.downloader.impls.y.1
            @Override // com.ss.android.socialbase.downloader.network.c
            public int hf() {
                return execute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.c
            public void w() {
                Call call = newCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                newCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.c
            public String xj(String str2) {
                return execute.header(str2);
            }
        };
    }
}
