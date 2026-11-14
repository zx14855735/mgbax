package com.sigmob.sdk.base.common;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.ResponseHeader;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class r extends AsyncTask<String, Void, HashMap<String, String>> {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13158a = 10;
    private final a b;

    public interface a {
        void a(String str, String str2);

        void a(String str, Throwable th);
    }

    private r(a aVar) {
        this.b = aVar;
    }

    public static String a(String str) {
        if (!str.toLowerCase().contains(".apk")) {
            return null;
        }
        String b = b(str);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String c = c(str);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        return c;
    }

    public static String b(String str) {
        try {
            Matcher matcher = Pattern.compile("(fsname=)(.*?apk)", 2).matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str) {
        try {
            Matcher matcher = Pattern.compile("[\\w\\.]+\\.apk", 2).matcher(str);
            if (matcher.find()) {
                return matcher.group(0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String d(String str) {
        String str2 = null;
        while (str != null) {
            try {
                str2 = str;
                str = e(str);
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                return str;
            }
        }
        return str2;
    }

    private static String e(String str) {
        HttpURLConnection httpURLConnection;
        String str2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.addRequestProperty(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
                int responseCode = httpURLConnection.getResponseCode();
                String headerField = httpURLConnection.getHeaderField("Location");
                if (responseCode >= 300 && responseCode < 400) {
                    str2 = headerField;
                }
                httpURLConnection.disconnect();
                return str2;
            } catch (Throwable th) {
                th = th;
                try {
                    SigmobLog.e("resolveRedirectLocation fail", th);
                    return null;
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    private String f(String str) {
        HttpURLConnection httpURLConnection;
        String str2;
        String str3 = null;
        HttpURLConnection httpURLConnection2 = null;
        str3 = null;
        try {
            if (TextUtils.isEmpty(null)) {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.addRequestProperty(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
                    String a2 = a(str, httpURLConnection);
                    if (a2 != null) {
                        if (a2.contains("fsname=")) {
                            str3 = b(str);
                        } else if (a2.contains(".apk")) {
                            str3 = c(a2);
                        } else {
                            httpURLConnection2 = httpURLConnection;
                            str2 = a2;
                        }
                    } else if (!TextUtils.isEmpty(str)) {
                        String[] split = Uri.parse(str).getPath().split("/");
                        if (split.length > 1) {
                            a2 = split[split.length - 1];
                        }
                        if (TextUtils.isEmpty(a2) || !a2.toLowerCase().endsWith(".apk")) {
                            str3 = Md5Util.md5(str) + ".apk";
                        }
                    }
                    str2 = str3;
                    httpURLConnection2 = httpURLConnection;
                } catch (Throwable th) {
                    th = th;
                    try {
                        SigmobLog.e("getDownloadUrlFilename", th);
                        return null;
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            } else {
                str2 = a(str);
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.b.a("Task for resolving url was cancelled", (Throwable) null);
    }

    private static String a(String str, HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 400) {
            return null;
        }
        try {
            return URLUtil.guessFileName(str, httpURLConnection.getHeaderField(com.sigmob.sdk.downloader.core.c.j), null);
        } catch (IllegalArgumentException unused) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str);
            throw new URISyntaxException(str, "Unable to parse invalid URL");
        } catch (NullPointerException e) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str);
            throw e;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, String> doInBackground(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String str = strArr[0];
            try {
                str = d(str);
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
            hashMap.put("url", str);
            hashMap.put("fileName", f(str));
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        return hashMap;
    }

    public static void a(String str, a aVar) {
        try {
            String a2 = a(str);
            if (TextUtils.isEmpty(a2)) {
                new r(aVar).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), str);
            } else {
                aVar.a(a2, str);
            }
        } catch (Throwable th) {
            aVar.a("Failed to resolve url", th);
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(HashMap<String, String> hashMap) {
        String str;
        String str2;
        if (hashMap != null) {
            str = hashMap.get("fileName");
            str2 = hashMap.get("url");
        } else {
            str = null;
            str2 = null;
        }
        this.b.a(str, str2);
    }
}
