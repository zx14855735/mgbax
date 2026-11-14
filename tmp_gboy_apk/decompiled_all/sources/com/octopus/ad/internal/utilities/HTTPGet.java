package com.octopus.ad.internal.utilities;

import com.baidu.mobads.sdk.internal.an;
import com.octopus.ad.internal.q;
import com.octopus.ad.utils.ThreadUtils;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class HTTPGet {
    private static final String TAG = "HTTPGet";
    private final boolean isResponse;

    public interface ResponseListener {
        void getResponse(int i, boolean z, String str);
    }

    public HTTPGet(boolean z) {
        this.isResponse = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection createConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(an.c);
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionParams(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", q.a().k());
    }

    public void execute() {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.octopus.ad.internal.utilities.HTTPGet.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:44:0x00f6 A[Catch: Exception -> 0x00c6, TRY_ENTER, TryCatch #9 {Exception -> 0x00c6, blocks: (B:31:0x00bd, B:33:0x00c2, B:35:0x00ca, B:56:0x00dc, B:58:0x00e1, B:60:0x00e6, B:44:0x00f6, B:46:0x00fb, B:48:0x0100), top: B:2:0x0009 }] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00fb A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:31:0x00bd, B:33:0x00c2, B:35:0x00ca, B:56:0x00dc, B:58:0x00e1, B:60:0x00e6, B:44:0x00f6, B:46:0x00fb, B:48:0x0100), top: B:2:0x0009 }] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0100 A[Catch: Exception -> 0x00c6, TRY_LEAVE, TryCatch #9 {Exception -> 0x00c6, blocks: (B:31:0x00bd, B:33:0x00c2, B:35:0x00ca, B:56:0x00dc, B:58:0x00e1, B:60:0x00e6, B:44:0x00f6, B:46:0x00fb, B:48:0x0100), top: B:2:0x0009 }] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x00dc A[Catch: Exception -> 0x00c6, TRY_ENTER, TryCatch #9 {Exception -> 0x00c6, blocks: (B:31:0x00bd, B:33:0x00c2, B:35:0x00ca, B:56:0x00dc, B:58:0x00e1, B:60:0x00e6, B:44:0x00f6, B:46:0x00fb, B:48:0x0100), top: B:2:0x0009 }] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x00e1 A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:31:0x00bd, B:33:0x00c2, B:35:0x00ca, B:56:0x00dc, B:58:0x00e1, B:60:0x00e6, B:44:0x00f6, B:46:0x00fb, B:48:0x0100), top: B:2:0x0009 }] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x00e6 A[Catch: Exception -> 0x00c6, TRY_LEAVE, TryCatch #9 {Exception -> 0x00c6, blocks: (B:31:0x00bd, B:33:0x00c2, B:35:0x00ca, B:56:0x00dc, B:58:0x00e1, B:60:0x00e6, B:44:0x00f6, B:46:0x00fb, B:48:0x0100), top: B:2:0x0009 }] */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v2 */
            /* JADX WARN: Type inference failed for: r0v27 */
            /* JADX WARN: Type inference failed for: r0v28 */
            /* JADX WARN: Type inference failed for: r0v3 */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r0v7 */
            /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 283
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.utilities.HTTPGet.AnonymousClass1.run():void");
            }
        });
    }

    public abstract String getUrl();

    public abstract void onPostExecute(HTTPResponse hTTPResponse);
}
