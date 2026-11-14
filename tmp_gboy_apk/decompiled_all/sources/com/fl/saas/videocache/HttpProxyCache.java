package com.fl.saas.videocache;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.fl.saas.videocache.file.FileCache;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class HttpProxyCache extends ProxyCache {
    private static final float NO_CACHE_BARRIER = 0.2f;
    private final FileCache cache;
    private CacheListener listener;
    private final HttpUrlSource source;

    public HttpProxyCache(HttpUrlSource httpUrlSource, FileCache fileCache) {
        super(httpUrlSource, fileCache);
        this.cache = fileCache;
        this.source = httpUrlSource;
    }

    private String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean isUseCache(GetRequest getRequest) {
        long length = this.source.length();
        boolean z = length > 0;
        long available = this.cache.available();
        if (z && getRequest.partial) {
            if (getRequest.rangeOffset > (length * NO_CACHE_BARRIER) + available) {
                return false;
            }
        }
        return true;
    }

    private String newResponseHeaders(GetRequest getRequest) {
        String mime = this.source.getMime();
        boolean isEmpty = TextUtils.isEmpty(mime);
        long available = this.cache.isCompleted() ? this.cache.available() : this.source.length();
        boolean z = available >= 0;
        boolean z2 = getRequest.partial;
        long j = z2 ? available - getRequest.rangeOffset : available;
        boolean z3 = z && z2;
        StringBuilder sb = new StringBuilder();
        sb.append(getRequest.partial ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z ? format("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z3 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(getRequest.rangeOffset), Long.valueOf(available - 1), Long.valueOf(available)) : "");
        return CtFAbx.B25kr6(sb, isEmpty ? "" : format("Content-Type: %s\n", mime), "\n");
    }

    private void responseWithCache(OutputStream outputStream, long j) {
        byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        while (true) {
            int read = read(bArr, j, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            if (read == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, read);
                j += read;
            }
        }
    }

    private void responseWithoutCache(OutputStream outputStream, long j) {
        HttpUrlSource httpUrlSource = new HttpUrlSource(this.source);
        try {
            httpUrlSource.open((int) j);
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = httpUrlSource.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    httpUrlSource.close();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            httpUrlSource.close();
            throw th;
        }
    }

    @Override // com.fl.saas.videocache.ProxyCache
    public void onCachePercentsAvailableChanged(int i) {
        CacheListener cacheListener = this.listener;
        if (cacheListener != null) {
            cacheListener.onCacheAvailable(this.cache.file, this.source.getUrl(), i);
        }
    }

    public void processRequest(GetRequest getRequest, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(newResponseHeaders(getRequest).getBytes("UTF-8"));
        long j = getRequest.rangeOffset;
        if (isUseCache(getRequest)) {
            responseWithCache(bufferedOutputStream, j);
        } else {
            responseWithoutCache(bufferedOutputStream, j);
        }
    }

    public void registerCacheListener(CacheListener cacheListener) {
        this.listener = cacheListener;
    }
}
