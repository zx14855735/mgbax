package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import com.sigmob.sdk.archives.tar.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaac {
    public static byte[] aaaaaaaa(String str, HashMap hashMap, boolean z) {
        return aaaaaaaa(str, null, hashMap, an.c, 5000, z);
    }

    public static byte[] aaaaaaaa(String str, HashMap hashMap, boolean z, String[] strArr) {
        return aaaaaaaa(str, null, hashMap, an.c, 5000, z, false, strArr);
    }

    private static byte[] aaaaaaaa(String str, String str2, HashMap hashMap, String str3, int i, boolean z) {
        return aaaaaaaa(str, str2, hashMap, str3, i, z, false, null);
    }

    private static byte[] aaaaaaaa(String str, String str2, HashMap hashMap, String str3, int i, boolean z, boolean z2, String[] strArr) {
        if (str != null && str.length() != 0) {
            if (hashMap == null) {
                try {
                    hashMap = new HashMap();
                } catch (Exception e) {
                    if (strArr != null) {
                        strArr[0] = e.getMessage();
                    }
                }
            }
            HttpURLConnection aaaaaaaa = aaaaaaaa(new URL(str), str3, i, z, z2);
            if (!hashMap.isEmpty()) {
                for (String str4 : hashMap.keySet()) {
                    aaaaaaaa.setRequestProperty(str4, (String) hashMap.get(str4));
                }
            }
            if (!TextUtils.isEmpty(str3) && TextUtils.equals(str3.toLowerCase(Locale.ENGLISH), "post")) {
                aaaaaaaa(aaaaaaaa.getOutputStream(), str2);
            }
            int responseCode = aaaaaaaa.getResponseCode();
            if (responseCode == 200) {
                return aaaaaaaa(aaaaaaaa.getInputStream());
            }
            if (strArr != null) {
                strArr[0] = String.valueOf(responseCode);
            }
            return null;
        }
        return null;
    }

    public static InputStream aaaaaaaa(String str, int i, boolean z, String[] strArr) {
        return aaaaaaaa(str, null, an.c, i, z, false, strArr);
    }

    private static InputStream aaaaaaaa(String str, String str2, String str3, int i, boolean z, boolean z2, String[] strArr) {
        if (str != null && str.length() != 0) {
            try {
                HashMap hashMap = new HashMap();
                HttpURLConnection aaaaaaaa = aaaaaaaa(new URL(str), str3, i, z, z2);
                if (!hashMap.isEmpty()) {
                    for (String str4 : hashMap.keySet()) {
                        aaaaaaaa.setRequestProperty(str4, (String) hashMap.get(str4));
                    }
                }
                if (!TextUtils.isEmpty(str3) && TextUtils.equals(str3.toLowerCase(Locale.ENGLISH), "post")) {
                    aaaaaaaa(aaaaaaaa.getOutputStream(), str2);
                }
                int responseCode = aaaaaaaa.getResponseCode();
                if (responseCode == 200) {
                    return aaaaaaaa.getInputStream();
                }
                if (strArr != null) {
                    strArr[0] = String.valueOf(responseCode);
                }
                return null;
            } catch (Exception e) {
                if (strArr != null) {
                    strArr[0] = e.getMessage();
                }
            }
        }
        return null;
    }

    private static void aaaaaaaa(OutputStream outputStream, String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    outputStream.write(str.getBytes("UTF-8"));
                }
            } catch (IOException unused) {
            }
        }
    }

    private static byte[] aaaaaaaa(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int available = inputStream.available();
            int i = d.b;
            int min = Math.min(d.b, available);
            if (min > 0) {
                i = min;
            }
            byte[] bArr = new byte[i];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static HttpURLConnection aaaaaaaa(URL url, String str, int i, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection;
        try {
            if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaa0.aaaaaaaa) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            }
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] aaaaaaaa(String str, String str2, HashMap hashMap) {
        return aaaaaaaa(str, str2, hashMap, an.b, 5000, true);
    }

    public static byte[] aaaaaaaa(String str, String str2, HashMap hashMap, String[] strArr) {
        return aaaaaaaa(str, str2, hashMap, an.b, 5000, true, false, strArr);
    }
}
