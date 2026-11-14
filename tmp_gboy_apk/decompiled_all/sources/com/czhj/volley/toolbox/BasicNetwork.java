package com.czhj.volley.toolbox;

import android.os.SystemClock;
import com.czhj.volley.Cache;
import com.czhj.volley.Header;
import com.czhj.volley.Network;
import com.czhj.volley.Request;
import com.czhj.volley.RetryPolicy;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;

    /* renamed from: a, reason: collision with root package name */
    private static final int f10637a = 3000;
    private static final int b = 4096;
    private final BaseHttpStack c;
    protected final ByteArrayPool mPool;

    static {
        CMpKLU();
    }

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    private static /* synthetic */ void CMpKLU() {
        char[] charArray = "½±³ð¹¿³»ð¼±§ð\u00ad¶»²²ð\u0094°·\u009c¬·º¹»".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 222);
        }
        String str = new String(charArray);
        char[] charArray2 = "½²·°·ª".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 222);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static List<Header> a(List<Header> list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<Header> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<Header> list2 = entry.allResponseHeaders;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Header header : entry.allResponseHeaders) {
                    if (!treeSet.contains(header.getName())) {
                        arrayList.add(header);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static Map<String, String> convertHeaders(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < list.size(); i++) {
            Header header = list.get(i);
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }

    public void logError(String str, String str2, long j) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0234 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0178 A[Catch: all -> 0x016a, TRY_ENTER, TryCatch #5 {all -> 0x016a, blocks: (B:4:0x0010, B:48:0x0178, B:50:0x0193, B:61:0x01b7, B:63:0x01bd, B:64:0x01c2, B:77:0x01c6, B:78:0x01cb, B:82:0x01d4, B:84:0x01da, B:86:0x01e0, B:87:0x01e5, B:89:0x01e8, B:91:0x01ee, B:93:0x01f4, B:94:0x01f9, B:96:0x01fa, B:97:0x01ff, B:98:0x0200, B:99:0x020b, B:100:0x0211, B:102:0x0234, B:103:0x0239, B:168:0x023a, B:169:0x0254, B:171:0x0255), top: B:3:0x0010 }] */
    @Override // com.czhj.volley.Network
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.czhj.volley.NetworkResponse performRequest(com.czhj.volley.Request<?> r23) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.BasicNetwork.performRequest(com.czhj.volley.Request):com.czhj.volley.NetworkResponse");
    }

    public BasicNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.c = baseHttpStack;
        this.mPool = byteArrayPool;
    }

    private Map<String, String> a(Cache.Entry entry) {
        if (entry == null) {
            return Collections.EMPTY_MAP;
        }
        HashMap hashMap = new HashMap();
        String str = entry.etag;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = entry.lastModified;
        if (j > 0) {
            hashMap.put("If-Modified-Since", HttpHeaderParser.a(j));
        }
        return hashMap;
    }

    private void a(long j, Request<?> request, byte[] bArr, int i) {
        if (DEBUG || j > 3000) {
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", request, Long.valueOf(j), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i), Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount()));
        }
    }

    private static void a(String str, Request<?> request) {
        request.addMarker(str + "-Redirect [timeout=" + request.getTimeoutMs() + "]");
    }

    private static void a(String str, Request<?> request, VolleyError volleyError) {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(str + "-retry [timeout=" + timeoutMs + "]");
        } catch (VolleyError e) {
            request.addMarker(str + "-timeout-giveup [timeout=" + timeoutMs + "]");
            throw e;
        }
    }

    private byte[] a(InputStream inputStream, int i) {
        byte[] byteArray;
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, i);
        int i2 = 1024;
        if (i > 0 && i < 1024) {
            i2 = i;
        }
        byte[] bArr = null;
        try {
            bArr = this.mPool.getBuf(i2);
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr, 0, i2);
                if (read == -1 || (i >= 1 && j >= i)) {
                    break;
                }
                poolingByteArrayOutputStream.write(bArr, 0, read);
                j += read;
            }
            byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
            }
            this.mPool.returnBuf(bArr);
        } catch (Throwable th) {
            try {
                VolleyLog.e("readError", th.getMessage());
                byteArray = poolingByteArrayOutputStream.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.mPool.returnBuf(bArr);
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.mPool.returnBuf(bArr);
                poolingByteArrayOutputStream.close();
                throw th2;
            }
        }
        poolingByteArrayOutputStream.close();
        return byteArray;
    }
}
