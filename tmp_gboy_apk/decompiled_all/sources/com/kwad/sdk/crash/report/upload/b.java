package com.kwad.sdk.crash.report.upload;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private static void a(File file, String str, String str2, Map<String, String> map, a aVar) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.Jz().X("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i = -1;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod(an.b);
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                httpURLConnection2.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection2.setRequestProperty("Content-MD5", Base64.encodeToString(com.kwad.sdk.utils.a.hd(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", "." + w.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty(com.sigmob.sdk.base.e.f13172a, "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), uuid));
                    }
                    byte[] bytes = ("\r\n--" + uuid + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(uuid);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                outputStream.write(bArr, 0, read);
                            }
                        }
                        outputStream.write("\r\n".getBytes());
                        outputStream.write(bytes);
                        outputStream.flush();
                        int responseCode = httpURLConnection2.getResponseCode();
                        cVar.code = responseCode;
                        cVar.aIU = responseCode;
                        if (responseCode == 200) {
                            cVar.aIW = h.inputStream2String(httpURLConnection2.getInputStream());
                            try {
                                if (new JSONObject(cVar.aIW).optInt("result", -1) == 1) {
                                    aVar.NQ();
                                } else {
                                    e eVar = e.aVA;
                                    aVar.NP();
                                }
                            } catch (JSONException unused) {
                                e eVar2 = e.aVA;
                                aVar.NP();
                            }
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "response.body= " + cVar.aIW);
                        } else {
                            e.aVG.AF();
                            aVar.NP();
                            com.kwad.sdk.core.network.idc.a Jz = com.kwad.sdk.core.network.idc.a.Jz();
                            int i2 = cVar.code;
                            if (i2 == 0) {
                                i2 = -1;
                            }
                            Jz.a(str3, i2, (Throwable) null);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        try {
                            e eVar3 = e.aVA;
                            e.getCause();
                            aVar.NP();
                            com.kwad.sdk.core.network.idc.a Jz2 = com.kwad.sdk.core.network.idc.a.Jz();
                            int i3 = cVar.code;
                            if (i3 != 0) {
                                i = i3;
                            }
                            Jz2.a(str3, i, e);
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] e(String str, String str2, String str3) {
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("--", str3, "\r\n");
        B3GDIM2.append("Content-Disposition: form-data; name=\"" + str + "\"");
        B3GDIM2.append("\r\n");
        B3GDIM2.append("Content-Length: " + str2.length());
        B3GDIM2.append("\r\n\r\n");
        B3GDIM2.append(str2);
        B3GDIM2.append("\r\n");
        return B3GDIM2.toString().getBytes();
    }

    private static Map<String, String> a(f fVar) {
        HashMap hashMap = new HashMap();
        if (fVar != null) {
            if (!TextUtils.isEmpty(fVar.aVR)) {
                hashMap.put("uploadToken", fVar.aVR);
            }
            if (!TextUtils.isEmpty(fVar.aVO)) {
                hashMap.put("sys", fVar.aVO);
            }
            if (!TextUtils.isEmpty(fVar.aVN)) {
                hashMap.put("did", fVar.aVN);
            }
            if (!TextUtils.isEmpty(fVar.aVM)) {
                hashMap.put("sid", fVar.aVM);
            }
            if (!TextUtils.isEmpty(fVar.aUi)) {
                hashMap.put("appver", fVar.aUi);
            }
            if (!TextUtils.isEmpty(fVar.mTaskId)) {
                hashMap.put("taskId", fVar.mTaskId);
            }
            if (!TextUtils.isEmpty(fVar.mToken)) {
                hashMap.put(Constants.TOKEN, fVar.mToken);
            }
            if (!TextUtils.isEmpty(fVar.aVL)) {
                hashMap.put("uid", fVar.aVL);
            }
            if (!TextUtils.isEmpty(fVar.aVP)) {
                hashMap.put(MediationConstant.KEY_EXTRA_INFO, fVar.aVP);
            }
        }
        return hashMap;
    }

    public static void a(File file, f fVar, a aVar) {
        a(file, fVar.aVN, fVar.mToken, a(fVar), aVar);
    }
}
