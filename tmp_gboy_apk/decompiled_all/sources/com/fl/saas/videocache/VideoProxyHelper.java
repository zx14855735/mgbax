package com.fl.saas.videocache;

import android.content.Context;
import com.fl.saas.videocache.HttpProxyCacheServer;
import com.fl.saas.videocache.headers.HeaderInjector;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class VideoProxyHelper {
    private static final long DEFAULT_CACHE_LENGTH = 67108864;
    private static volatile VideoProxyHelper videoProxyHelper;
    private HttpProxyCacheServer proxy;
    private long maxCacheLength = DEFAULT_CACHE_LENGTH;
    private Map<String, String> globalHeaders = new HashMap();

    public class GlobalHeadersInjector implements HeaderInjector {
        public GlobalHeadersInjector() {
        }

        @Override // com.fl.saas.videocache.headers.HeaderInjector
        public Map<String, String> addHeaders(String str) {
            return VideoProxyHelper.this.globalHeaders;
        }
    }

    public static VideoProxyHelper getInstance() {
        if (videoProxyHelper == null) {
            synchronized (VideoProxyHelper.class) {
                try {
                    if (videoProxyHelper == null) {
                        videoProxyHelper = new VideoProxyHelper();
                    }
                } finally {
                }
            }
        }
        return videoProxyHelper;
    }

    private HttpProxyCacheServer newProxy(Context context) {
        return new HttpProxyCacheServer.Builder(context).cacheDirectory(CacheUtils.getVideoCacheDir(context)).headerInjector(new GlobalHeadersInjector()).maxCacheSize(this.maxCacheLength).build();
    }

    public long getFolderSize(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return -1L;
            }
            for (File file2 : listFiles) {
                j += file2.isDirectory() ? getFolderSize(file2) : file2.length();
            }
            return j;
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public Map<String, String> getGlobalHeaders() {
        return this.globalHeaders;
    }

    public HttpProxyCacheServer getProxy(Context context) {
        if (this.proxy == null && context != null) {
            this.proxy = newProxy(context);
        }
        return this.proxy;
    }

    public String getProxyUrl(Context context, VideoPreLoadModel videoPreLoadModel) {
        String proxyUrl = getInstance().getProxy(context).getProxyUrl(videoPreLoadModel.getOriginalUrl(), false);
        PreCatcher.getInstance().startCache(videoPreLoadModel.getOriginalUrl(), videoPreLoadModel.getPreLoadBytes());
        return proxyUrl;
    }

    public void setBuildConfig(Map<String, Object> map) {
        if (map == null || map.get("maxCacheLength") == null) {
            return;
        }
        this.maxCacheLength = Long.parseLong(String.valueOf(map.get("maxCacheLength")));
    }
}
