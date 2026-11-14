package com.fl.saas.s2s.sdk.helper.download;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommClickHelper;
import com.fl.saas.s2s.sdk.helper.CommNotificationHelper;
import com.fl.saas.s2s.sdk.util.ApkUtils;
import com.sigmob.sdk.downloader.core.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DownLoadSupportPauseUtil {
    public static final int DOWNLOAD_SUCCESS = 1002;
    public static final int MAX_REDIRECTION = 5;
    public static final int UPDATE_PROGRESS = 1001;
    public static String YD_CANCEL_DOWNLOAD = "YDActionCancelDownloadCheckUrl";
    public static String YD_CANCEL_LAST_DOWNLOAD = "YDActionCancelLastDownloadCheckUrl";
    public static String YD_DOWNLOAD_SUCCESS = "YDActionDownloadSuccess";
    public static String YD_PAUSE_DOWNLOAD = "YDActionPauseDownloadCheckUrl";
    public static String YD_START_DOWNLOAD = "YDActionStartDownloadCheckUrl";
    public static String YD_UPDATE_DOWNLOAD_PROGRESS = "YDActionUpdateProgress";
    private static DownloadAddReceiver adReceiver = new DownloadAddReceiver();
    private ActionReceiver actionReceiver;
    private AdInfoPoJo adInfoPoJo;
    private File file;
    private Handler handler;
    private Context mContext;
    private MyThread myThread;
    private String name;
    private CommNotificationHelper notificationHelper;
    private IProgress progressListener;
    private RandomAccessFile raf;
    private File rootFile;
    private long totalLength;
    private String urlPath;
    private boolean isDown = false;
    private long downSize = 0;
    private boolean isRegister = false;
    private final AtomicInteger redirectionCount = new AtomicInteger();

    public class ActionReceiver extends BroadcastReceiver {
        public ActionReceiver() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        
            if (r1.this$0.progressListener != null) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
        
            r1.this$0.progressListener.onCancel();
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
        
            if (r1.this$0.progressListener != null) goto L28;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(android.content.Context r2, android.content.Intent r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L81
                java.lang.String r2 = r3.getAction()
                java.lang.String r0 = "downLoadUrl"
                java.lang.String r3 = r3.getStringExtra(r0)
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r0 != 0) goto L81
                java.lang.String r0 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.YD_START_DOWNLOAD
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L2c
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                java.lang.String r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.access$200(r2)
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L81
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                r2.start()
                return
            L2c:
                java.lang.String r0 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L46
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                java.lang.String r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.access$200(r2)
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L81
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                r2.pause()
                return
            L46:
                java.lang.String r0 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.YD_CANCEL_DOWNLOAD
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L63
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                java.lang.String r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.access$200(r2)
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L81
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil$IProgress r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.access$000(r2)
                if (r2 == 0) goto L7c
                goto L73
            L63:
                java.lang.String r3 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.YD_CANCEL_LAST_DOWNLOAD
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L81
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil$IProgress r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.access$000(r2)
                if (r2 == 0) goto L7c
            L73:
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil$IProgress r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.access$000(r2)
                r2.onCancel()
            L7c:
                com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil r2 = com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.this
                r2.destroy()
            L81:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.ActionReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public interface IProgress {
        void onCancel();

        void onProgress(int i);

        void onSuccess(File file);
    }

    public class MyThread extends Thread {
        public MyThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            DownLoadSupportPauseUtil.this.downLoad();
        }
    }

    static {
        NgYhaH();
    }

    public DownLoadSupportPauseUtil(Context context, AdInfoPoJo adInfoPoJo, IProgress iProgress) {
        String str;
        this.mContext = context;
        this.adInfoPoJo = adInfoPoJo;
        this.progressListener = iProgress;
        this.urlPath = !TextUtils.isEmpty(adInfoPoJo.download_url) ? adInfoPoJo.download_url : adInfoPoJo.click_url;
        if (!TextUtils.isEmpty(adInfoPoJo.app_package)) {
            StringBuilder sb = new StringBuilder();
            sb.append((adInfoPoJo.app_package + adInfoPoJo.app_version).replace(".", ""));
            sb.append(".apk");
            str = sb.toString();
        } else if (this.urlPath.endsWith(".apk")) {
            String str2 = this.urlPath;
            str = str2.substring(str2.lastIndexOf("/") + 1, this.urlPath.length());
        } else {
            str = "temp.apk";
        }
        this.name = str;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 1001) {
                    if (i == 1002) {
                        File file = (File) message.obj;
                        if (DownLoadSupportPauseUtil.this.progressListener != null) {
                            DownLoadSupportPauseUtil.this.progressListener.onSuccess(file);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int i2 = message.arg1;
                String str3 = (String) message.obj;
                if (DownLoadSupportPauseUtil.this.progressListener != null) {
                    DownLoadSupportPauseUtil.this.progressListener.onProgress(i2);
                }
                if (DownLoadSupportPauseUtil.this.notificationHelper != null) {
                    DownLoadSupportPauseUtil.this.notificationHelper.updateProgress(i2, str3);
                }
            }
        };
    }

    private static /* synthetic */ void NgYhaH() {
        char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 204);
        }
        String str = new String(charArray);
        char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 204);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void downLoadComplete() {
        this.isDown = false;
        Message obtainMessage = this.handler.obtainMessage();
        obtainMessage.what = 1002;
        obtainMessage.obj = this.file;
        this.handler.sendMessage(obtainMessage);
        AdInfoPoJo adInfoPoJo = this.adInfoPoJo;
        if (adInfoPoJo != null) {
            DownloadAddReceiver downloadAddReceiver = adReceiver;
            if (downloadAddReceiver != null) {
                downloadAddReceiver.setPoJo(adInfoPoJo);
            }
            CommClickHelper.getInstance().report(this.mContext, this.adInfoPoJo, 5);
        }
        ApkUtils.installAPk(this.mContext, this.file, this.adInfoPoJo);
        if (!this.isRegister && adReceiver != null && DeviceUtil.enableCollectAppInstallStatus) {
            adReceiver.registerX(this.mContext.getApplicationContext());
            this.isRegister = true;
        }
        destroy();
    }

    public SSLContext createSSLContext() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.2
                @Override // javax.net.ssl.X509TrustManager
                @SuppressLint({"TrustAllX509TrustManager"})
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                @SuppressLint({"TrustAllX509TrustManager"})
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            return sSLContext;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void destroy() {
        if (this.isDown) {
            this.isDown = false;
            if (this.myThread != null) {
                ThreadPoolManager.getInstance().removeTask(this.myThread);
                this.myThread = null;
            }
        }
        CommNotificationHelper commNotificationHelper = this.notificationHelper;
        if (commNotificationHelper != null) {
            commNotificationHelper.cancel();
            this.notificationHelper = null;
        }
        ActionReceiver actionReceiver = this.actionReceiver;
        if (actionReceiver != null) {
            try {
                this.mContext.unregisterReceiver(actionReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.actionReceiver = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x019f A[Catch: all -> 0x0188, Exception -> 0x018e, TRY_LEAVE, TryCatch #13 {Exception -> 0x018e, all -> 0x0188, blocks: (B:32:0x010a, B:33:0x0110, B:35:0x0117, B:37:0x011b, B:39:0x0130, B:41:0x013b, B:47:0x0197, B:49:0x019f), top: B:31:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v9, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void downLoad() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.s2s.sdk.helper.download.DownLoadSupportPauseUtil.downLoad():void");
    }

    public HttpURLConnection innerRequest(Uri uri, long j) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(uri.toString());
        if ("https".equals(uri.getScheme())) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            SSLContext createSSLContext = createSSLContext();
            httpURLConnection = httpsURLConnection;
            if (createSSLContext != null) {
                httpsURLConnection.setSSLSocketFactory(createSSLContext.getSocketFactory());
                httpURLConnection = httpsURLConnection;
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        if (j > 0) {
            httpURLConnection.setRequestProperty(c.b, "bytes=" + j + "-");
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 307) {
            switch (responseCode) {
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return httpURLConnection;
            }
        }
        if (this.redirectionCount.decrementAndGet() < 0) {
            throw new DownloadException(responseCode, "redirects too many times");
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        return innerRequest(Uri.parse(headerField), j);
    }

    public void pause() {
        if (this.isDown) {
            this.isDown = false;
            if (this.myThread != null) {
                ThreadPoolManager.getInstance().removeTask(this.myThread);
                this.myThread = null;
            }
        }
        CommNotificationHelper commNotificationHelper = this.notificationHelper;
        if (commNotificationHelper != null) {
            commNotificationHelper.changeActionText(false);
        }
    }

    public void start() {
        if (this.isDown) {
            return;
        }
        this.isDown = true;
        if (this.myThread == null) {
            this.myThread = new MyThread();
        }
        ThreadPoolManager.getInstance().addTask(this.myThread);
    }
}
