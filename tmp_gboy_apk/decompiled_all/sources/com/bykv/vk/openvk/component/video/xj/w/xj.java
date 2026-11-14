package com.bykv.vk.openvk.component.video.xj.w;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.component.video.xj.hf.d;
import com.bykv.vk.openvk.component.video.xj.hf.hf.w;
import com.bykv.vk.openvk.component.video.xj.hf.kd;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.downloader.core.c;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj {
    private static final Handler hf = new Handler(Looper.getMainLooper());
    public static final Charset xj = Charset.forName("UTF-8");

    /* renamed from: com.bykv.vk.openvk.component.video.xj.w.xj$1, reason: invalid class name */
    public static class AnonymousClass1 implements FilenameFilter {
        private Pattern xj = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.xj.matcher(str).matches();
        }
    }

    static {
        cbesXF();
    }

    private static /* synthetic */ void cbesXF() {
        char[] charArray = "º¶´÷¾¸´¼÷»¶ ÷ª±¼µµ÷\u0093·°\u009b«°½¾¼".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 217);
        }
        String str = new String(charArray);
        char[] charArray2 = "ºµ°·°\u00ad".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 217);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int hf(String str) {
        return xj(str, 0);
    }

    public static boolean w(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static void xj(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String hf(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return CtFAbx.ARc23Z(i2, "-");
    }

    public static void xj(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void xj(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void xj(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean xj(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return false;
    }

    public static int xj(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static String xj(com.bykv.vk.openvk.component.video.xj.hf.kd.xj xjVar, int i) {
        int xj2;
        if (xjVar == null || !xjVar.hf()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(xjVar.kd().toUpperCase());
        sb.append(' ');
        sb.append(xjVar.xj());
        sb.append(' ');
        sb.append(xjVar.y());
        sb.append("\r\n");
        if (kd.w) {
            pl.xj("TAG_PROXY_headers", xjVar.kd().toUpperCase() + " " + xjVar.xj() + " " + xjVar.y());
        }
        List<d.hf> xj3 = xj(xjVar.w());
        boolean z = true;
        if (xj3 != null) {
            int size = xj3.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.hf hfVar = xj3.get(i2);
                if (hfVar != null) {
                    String str = hfVar.xj;
                    String str2 = hfVar.hf;
                    A2egSU.BIYEnU(sb, str, ": ", str2, "\r\n");
                    if (c.f.equalsIgnoreCase(str) || (c.i.equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        }
        if (z && (xj2 = xj(xjVar)) > 0) {
            sb.append("Content-Range: bytes ");
            sb.append(Math.max(i, 0));
            sb.append("-");
            sb.append(xj2 - 1);
            sb.append("/");
            sb.append(xj2);
            sb.append("\r\n");
        }
        sb.append("Connection: close\r\n\r\n");
        String sb2 = sb.toString();
        if (kd.w) {
            pl.xj("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static boolean hf() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static String hf(List<d.hf> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d.hf hfVar = list.get(0);
                if (hfVar != null) {
                    sb.append(hfVar.xj);
                    sb.append(": ");
                    sb.append(hfVar.hf);
                    sb.append("\r\n");
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String hf(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append(": ");
                sb.append((Object) entry.getValue());
                sb.append("\r\n");
            }
            return sb.toString();
        }
        return "";
    }

    public static String xj(int i, int i2) {
        String hf2 = hf(i, i2);
        if (hf2 == null) {
            return null;
        }
        return "bytes=".concat(hf2);
    }

    public static List<String> xj(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (xj(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String xj(com.bykv.vk.openvk.component.video.xj.hf.hf.xj xjVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb.append("Accept-Ranges: bytes\r\nContent-Type: ");
        sb.append(xjVar.hf);
        sb.append("\r\n");
        if (i <= 0) {
            sb.append("Content-Length: ");
            sb.append(xjVar.w);
            sb.append("\r\n");
        } else {
            sb.append("Content-Range: bytes ");
            sb.append(i);
            sb.append("-");
            sb.append(xjVar.w - 1);
            sb.append("/");
            sb.append(xjVar.w);
            sb.append("\r\nContent-Length: ");
            sb.append(xjVar.w - i);
            sb.append("\r\n");
        }
        sb.append("Connection: close\r\n\r\n");
        String sb2 = sb.toString();
        if (kd.w) {
            pl.xj("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static int xj() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    public static int xj(com.bykv.vk.openvk.component.video.xj.hf.kd.xj xjVar) {
        int lastIndexOf;
        if (xjVar == null) {
            return -1;
        }
        if (xjVar.xj() == 200) {
            return xj(xjVar.xj(c.e, null), -1);
        }
        if (xjVar.xj() == 206) {
            String xj2 = xjVar.xj(c.f, null);
            if (!TextUtils.isEmpty(xj2) && (lastIndexOf = xj2.lastIndexOf("/")) >= 0 && lastIndexOf < xj2.length() - 1) {
                return xj(xj2.substring(lastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String xj(com.bykv.vk.openvk.component.video.xj.hf.kd.xj xjVar, boolean z, boolean z2) {
        String xj2;
        if (xjVar == null) {
            if (kd.w) {
                pl.u("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!xjVar.hf()) {
            if (kd.w) {
                pl.u("TAG_PROXY_Response", "response code: " + xjVar.xj());
            }
            return "response code: " + xjVar.xj();
        }
        String xj3 = xjVar.xj("Content-Type", null);
        if (!w(xj3)) {
            if (kd.w) {
                pl.u("TAG_PROXY_Response", "Content-Type: " + xj3);
            }
            return CtFAbx.BChYOn("Content-Type: ", xj3);
        }
        int xj4 = xj(xjVar);
        if (xj4 <= 0) {
            if (kd.w) {
                pl.u("TAG_PROXY_Response", "Content-Length: " + xj4);
            }
            return CtFAbx.ARc23Z(xj4, "Content-Length: ");
        }
        if (z && ((xj2 = xjVar.xj(c.i, null)) == null || !xj2.contains("bytes"))) {
            if (kd.w) {
                pl.u("TAG_PROXY_Response", "Accept-Ranges: " + xj2);
            }
            return CtFAbx.BChYOn("Accept-Ranges: ", xj2);
        }
        if (!z2 || xjVar.u() != null) {
            return null;
        }
        if (kd.w) {
            pl.u("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static void xj(com.bytedance.sdk.component.tf.d dVar) {
        if (dVar != null) {
            if (hf()) {
                com.bytedance.sdk.component.tf.c.hf(dVar);
                if (kd.w) {
                    pl.u("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            dVar.run();
            if (kd.w) {
                pl.u("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void xj(Runnable runnable) {
        if (runnable != null) {
            if (hf()) {
                runnable.run();
            } else {
                hf.post(runnable);
            }
        }
    }

    public static List<d.hf> xj(List<d.hf> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (kd.w) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d.hf hfVar = list.get(i);
                if (hfVar != null) {
                    pl.xj("TAG_PROXY_PRE_FILTER", hfVar.xj + ": " + hfVar.xj);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (d.hf hfVar2 : list) {
            if ("Host".equals(hfVar2.xj) || "Keep-Alive".equals(hfVar2.xj) || "Connection".equals(hfVar2.xj) || "Proxy-Connection".equals(hfVar2.xj)) {
                arrayList.add(hfVar2);
            }
        }
        list.removeAll(arrayList);
        if (kd.w) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                d.hf hfVar3 = list.get(i2);
                if (hfVar3 != null) {
                    pl.xj("TAG_PROXY_POST_FILTER", hfVar3.xj + ": " + hfVar3.hf);
                }
            }
        }
        return list;
    }

    public static List<d.hf> xj(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : entrySet) {
                    arrayList.add(new d.hf(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.xj.hf.hf.xj xj(com.bykv.vk.openvk.component.video.xj.hf.kd.xj xjVar, w wVar, String str, int i) {
        String str2;
        String str3;
        com.bykv.vk.openvk.component.video.xj.hf.hf.xj query = wVar.query(str, i);
        if (query == null) {
            int xj2 = xj(xjVar);
            String xj3 = xjVar.xj("Content-Type", null);
            if (xj2 > 0 && !TextUtils.isEmpty(xj3)) {
                com.bykv.vk.openvk.component.video.xj.hf.kd.kd c = xjVar.c();
                String str4 = "";
                if (c == null) {
                    str2 = "";
                    str3 = str2;
                } else {
                    str3 = c.hf;
                    str2 = hf(c.kd);
                }
                String hf2 = hf(xjVar.w());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("requestUrl", str3);
                    jSONObject.put("requestHeaders", str2);
                    jSONObject.put("responseHeaders", hf2);
                    str4 = jSONObject.toString();
                } catch (Throwable unused) {
                }
                com.bykv.vk.openvk.component.video.xj.hf.hf.xj xjVar2 = new com.bykv.vk.openvk.component.video.xj.hf.hf.xj(str, xj3, xj2, i, str4);
                wVar.insert(xjVar2);
                return xjVar2;
            }
        }
        return query;
    }
}
