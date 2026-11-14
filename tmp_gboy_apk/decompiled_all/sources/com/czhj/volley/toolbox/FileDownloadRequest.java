package com.czhj.volley.toolbox;

import ADYaiT.CtFAbx;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.Request;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import com.sigmob.sdk.downloader.core.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FileDownloadRequest extends Request<DownloadItem> {

    /* renamed from: a, reason: collision with root package name */
    private File f10640a;
    private File b;
    private DownloadItem c;
    private long d;
    private final Object e;
    private FileDownloadListener f;

    public interface FileDownloadListener {
        void downloadProgress(DownloadItem downloadItem, long j, long j2);

        void onCancel(DownloadItem downloadItem);

        void onErrorResponse(DownloadItem downloadItem);

        void onSuccess(DownloadItem downloadItem);
    }

    public FileDownloadRequest(DownloadItem downloadItem, FileDownloadListener fileDownloadListener) {
        super(0, downloadItem.url, null);
        this.d = 0L;
        this.e = new Object();
        this.f = null;
        File file = new File(downloadItem.filePath);
        this.f10640a = file;
        if (file.getParentFile() != null && !this.f10640a.getParentFile().exists()) {
            this.f10640a.getParentFile().mkdirs();
        }
        if (this.f10640a.exists()) {
            this.f10640a.delete();
        }
        this.c = downloadItem;
        File file2 = new File(CtFAbx.B25kr6(new StringBuilder(), downloadItem.filePath, ".tmp"));
        this.b = file2;
        if (!downloadItem.userRange) {
            file2.delete();
        }
        this.f = fileDownloadListener;
        setRetryPolicy(new DefaultRetryPolicy(10000, 2, 0.0f));
        setShouldCache(false);
        VolleyLog.d("FileDownloadRequest()  [ %s ], url = [%s]", downloadItem.filePath, downloadItem.url);
    }

    @Override // com.czhj.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.e) {
            this.f = null;
        }
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        this.c.status = 0;
        if (this.f10640a.exists()) {
            this.f10640a.delete();
        }
        if (this.b.exists()) {
            this.b.delete();
        }
        DownloadItem downloadItem = this.c;
        downloadItem.error = volleyError;
        this.f.onErrorResponse(downloadItem);
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(DownloadItem downloadItem) {
        this.c.status = 1;
        this.f.onSuccess(downloadItem);
    }

    @Override // com.czhj.volley.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        this.d = this.b.length();
        hashMap.put("Connection", "Keep-Alive");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put(c.b, "bytes=" + this.d + "-");
        addMarker("Range,bytes=" + this.d + "-");
        return hashMap;
    }

    @Override // com.czhj.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(16:66|(1:85)(1:(1:(2:78|(2:80|(2:82|83))))(2:75|76))|84|7|8|9|11|(1:13)(1:48)|14|(3:15|16|(1:47)(2:18|(2:35|36)(3:20|(5:22|23|24|25|26)(2:33|34)|27)))|37|38|39|40|41|42)(1:5)|11|(0)(0)|14|(4:15|16|(0)(0)|27)|37|38|39|40|41|42) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(11:(16:66|(1:85)(1:(1:(2:78|(2:80|(2:82|83))))(2:75|76))|84|7|8|9|11|(1:13)(1:48)|14|(3:15|16|(1:47)(2:18|(2:35|36)(3:20|(5:22|23|24|25|26)(2:33|34)|27)))|37|38|39|40|41|42)(1:5)|11|(0)(0)|14|(4:15|16|(0)(0)|27)|37|38|39|40|41|42)|6|7|8|9|(1:(1:53))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01a6, code lost:
    
        com.czhj.volley.VolleyLog.v("Error occured when calling consumingContent", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b2, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00e4 A[Catch: all -> 0x00e9, TRY_ENTER, TryCatch #3 {all -> 0x00e9, blocks: (B:13:0x00e4, B:14:0x00ef, B:15:0x00f7, B:18:0x0103, B:36:0x0109, B:20:0x0126, B:27:0x015c, B:31:0x013d, B:38:0x0181, B:48:0x00ec, B:24:0x0132), top: B:11:0x00e2, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0103 A[Catch: all -> 0x00e9, TRY_ENTER, TryCatch #3 {all -> 0x00e9, blocks: (B:13:0x00e4, B:14:0x00ef, B:15:0x00f7, B:18:0x0103, B:36:0x0109, B:20:0x0126, B:27:0x015c, B:31:0x013d, B:38:0x0181, B:48:0x00ec, B:24:0x0132), top: B:11:0x00e2, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0123 A[EDGE_INSN: B:47:0x0123->B:37:0x0123 BREAK  A[LOOP:0: B:15:0x00f7->B:27:0x015c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ec A[Catch: all -> 0x00e9, TryCatch #3 {all -> 0x00e9, blocks: (B:13:0x00e4, B:14:0x00ef, B:15:0x00f7, B:18:0x0103, B:36:0x0109, B:20:0x0126, B:27:0x015c, B:31:0x013d, B:38:0x0181, B:48:0x00ec, B:24:0x0132), top: B:11:0x00e2, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] handleRawResponse(com.czhj.volley.toolbox.HttpResponse r19) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.FileDownloadRequest.handleRawResponse(com.czhj.volley.toolbox.HttpResponse):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.czhj.volley.Request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.czhj.volley.Response<com.czhj.volley.toolbox.DownloadItem> parseNetworkResponse(com.czhj.volley.NetworkResponse r9) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.FileDownloadRequest.parseNetworkResponse(com.czhj.volley.NetworkResponse):com.czhj.volley.Response");
    }

    public void setListener(FileDownloadListener fileDownloadListener) {
        this.f = fileDownloadListener;
    }
}
