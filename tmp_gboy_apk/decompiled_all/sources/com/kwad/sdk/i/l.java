package com.kwad.sdk.i;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int aYc;

    public interface a {
        void onSuccess();
    }

    public static void a(List<k> list, a aVar) {
        if (aYc > 10) {
            j.al("LogReportUtil", "request error");
            return;
        }
        g OW = h.OS().OW();
        Map<String, String> requestHeader = OW.getRequestHeader();
        JSONObject OR = OW.OR();
        c.putValue(OR, "actionList", list);
        c.putValue(OR, "timestamp", System.currentTimeMillis());
        a(OW.OQ(), requestHeader, a(requestHeader, OR), aVar);
    }

    private static String c(Map<String, String> map, String str) {
        g OW = h.OS().OW();
        JSONObject jSONObject = new JSONObject();
        c.putValue(jSONObject, "version", OW.getSdkVersion());
        c.putValue(jSONObject, MedProConst.AD_APPID, OW.getAppId());
        c.putValue(jSONObject, "message", com.kwad.sdk.i.a.av(str));
        com.kwad.sdk.i.a.a(OW.OQ(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    private static String inputStream2String(InputStream inputStream) {
        try {
            try {
                return c(inputStream);
            } catch (IOException unused) {
                j.Pc();
                j.closeQuietly(inputStream);
                return null;
            }
        } finally {
            j.closeQuietly(inputStream);
        }
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static String c(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
                try {
                    String a2 = a(bufferedReader);
                    j.closeQuietly(bufferedReader);
                    j.closeQuietly(inputStreamReader);
                    return a2;
                } catch (Throwable th2) {
                    th = th2;
                    j.closeQuietly(bufferedReader);
                    j.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    private static String a(Map<String, String> map, JSONObject jSONObject) {
        if (h.OS().OW().OP()) {
            return jSONObject.toString();
        }
        return c(map, jSONObject.toString());
    }

    private static void a(String str, Map<String, String> map, String str2, a aVar) {
        Closeable closeable;
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod(an.b);
                httpURLConnection2.setRequestProperty("Content-Type", an.d);
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                httpURLConnection2.setUseCaches(false);
                setConnectionHeader(httpURLConnection2, map);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.flush();
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    String inputStream2String = inputStream2String(httpURLConnection2.getInputStream());
                    j.Pd();
                    if (!TextUtils.isEmpty(inputStream2String)) {
                        if (new JSONObject(inputStream2String).optInt("result") == 1) {
                            aYc = 0;
                            aVar.onSuccess();
                        } else {
                            aYc++;
                            j.Pd();
                        }
                    } else {
                        aYc++;
                        j.Pd();
                    }
                } else {
                    aYc++;
                    j.Pd();
                }
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(outputStream);
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                closeable = null;
                try {
                    aYc++;
                    j.Pc();
                    j.closeQuietly(httpURLConnection);
                    j.closeQuietly(closeable);
                } catch (Throwable th) {
                    th = th;
                    j.closeQuietly(httpURLConnection);
                    j.closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                closeable = null;
                j.closeQuietly(httpURLConnection);
                j.closeQuietly(closeable);
                throw th;
            }
        } catch (Exception unused2) {
            closeable = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    private static String a(Reader reader) {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th2) {
            stringWriter = stringWriter2;
            th = th2;
        }
        try {
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    String stringWriter3 = stringWriter.toString();
                    j.closeQuietly(reader);
                    j.closeQuietly(stringWriter);
                    return stringWriter3;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            j.closeQuietly(reader);
            j.closeQuietly(stringWriter);
            throw th;
        }
    }
}
