package com.bytedance.sdk.openadsdk.g;

import J3FDQU.A2egSU;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.x.u;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {

    /* renamed from: com.bytedance.sdk.openadsdk.g.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0200xj {
        void xj(int i, String str);

        void xj(String str);
    }

    private static SSLSocketFactory xj(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            throw new RuntimeException("No System TLS", th);
        }
    }

    private static X509TrustManager xj() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (Throwable th) {
            pl.hf("Https", th);
            return null;
        }
    }

    public void xj(String str, File file, Map<String, String> map, InterfaceC0200xj interfaceC0200xj, Map<String, String> map2) {
        DataOutputStream dataOutputStream;
        HttpsURLConnection httpsURLConnection;
        String uuid;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            try {
                httpsURLConnection.setRequestMethod(an.b);
                httpsURLConnection.setReadTimeout(20000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                uuid = UUID.randomUUID().toString();
                if (map2 != null) {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                httpsURLConnection.setSSLSocketFactory(xj(xj()));
                httpsURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = null;
        }
        try {
            dataOutputStream.writeBytes("--" + uuid + "\r\nContent-Disposition: form-data; name=\"logFile\"; filename=\"" + file.getName() + "\"\r\nContent-Type: multipart/form-data\r\nContent-Length: " + file.length() + "\r\n\r\n");
            dataOutputStream.flush();
            u.xj(dataOutputStream, file);
            dataOutputStream.writeBytes("\r\n");
            if (map != null) {
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    String key = entry2.getKey();
                    String value = entry2.getValue();
                    if (value != null && key != null) {
                        xj(dataOutputStream, key, value, uuid);
                    }
                }
            }
            dataOutputStream.writeBytes("--" + uuid + "--\r\n");
            dataOutputStream.flush();
            dataOutputStream.close();
            xj(httpsURLConnection, interfaceC0200xj);
            httpsURLConnection.disconnect();
            u.xj(dataOutputStream);
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection2 = httpsURLConnection;
            try {
                pl.hf("Https", th);
                if (interfaceC0200xj != null) {
                    interfaceC0200xj.xj(-1, th.getMessage());
                }
            } finally {
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                u.xj(dataOutputStream);
            }
        }
    }

    private void xj(DataOutputStream dataOutputStream, String str, String str2, String str3) {
        StringBuilder BChYOn2 = A2egSU.BChYOn("\r\n--", str3, "\r\nContent-Disposition: form-data; name=\"", str, "\";\r\nContent-Length: ");
        BChYOn2.append(str2.length());
        BChYOn2.append("\r\n\r\n");
        BChYOn2.append(str2);
        BChYOn2.append("\r\n");
        dataOutputStream.writeBytes(BChYOn2.toString());
    }

    private void xj(HttpURLConnection httpURLConnection, InterfaceC0200xj interfaceC0200xj) {
        int responseCode = httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            } else {
                sb.append(readLine);
            }
        }
        if (responseCode == 200) {
            if (interfaceC0200xj != null) {
                interfaceC0200xj.xj(sb.toString());
            }
        } else if (interfaceC0200xj != null) {
            interfaceC0200xj.xj(responseCode, sb.toString());
        }
    }
}
