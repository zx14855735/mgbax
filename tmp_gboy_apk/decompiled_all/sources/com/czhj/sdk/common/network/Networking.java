package com.czhj.sdk.common.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.SharedPreferencesUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.Cache;
import com.czhj.volley.ExecutorDelivery;
import com.czhj.volley.toolbox.BasicNetwork;
import com.czhj.volley.toolbox.FileDownloadNetwork;
import com.czhj.volley.toolbox.HurlStack;
import com.czhj.volley.toolbox.ImageLoader;
import com.czhj.volley.toolbox.NoCache;
import java.lang.reflect.Method;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Networking {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10572a = "sigmob-volley-cache";
    private static final String b;
    private static volatile SigmobRequestQueue c;
    private static volatile SigmobRequestQueue d;
    private static volatile SigmobRequestQueue e;
    private static volatile SigmobRequestQueue f;
    private static volatile String g;
    private static volatile String h;
    private static volatile MaxWidthImageLoader i;
    private static boolean j;
    private static HurlStack.UrlRewriter k;
    private static volatile Cache l;
    private static HashSet m;
    private static SigmobRequestQueue n;
    private static SigmobRequestQueue o;

    /* renamed from: com.czhj.sdk.common.network.Networking$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f10575a;

        public AnonymousClass4(Context context) {
            this.f10575a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    WebView webView = new WebView(this.f10575a);
                    webView.removeJavascriptInterface("searchBoxJavaBridge_");
                    webView.removeJavascriptInterface("accessibility");
                    webView.removeJavascriptInterface("accessibilityTraversal");
                    String unused = Networking.g = webView.getSettings().getUserAgentString();
                    SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(this.f10575a).edit();
                    edit.putString("user-agent-cache", Networking.g);
                    edit.apply();
                }
            } catch (Throwable unused2) {
            }
        }
    }

    static {
        String property = System.getProperty("http.agent");
        b = property;
        h = property;
        j = false;
        l = null;
        m = new HashSet();
        WHeUYjI();
    }

    public static void AddSigmobServerURL(String str) {
        m.add(str);
    }

    private static /* synthetic */ void WHeUYjI() {
        char[] charArray = "¡\u00ad¯ì¥£¯§ì \u00ad»ì±ª§®®ì\u0088¬«\u0080°«¦¥§".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 194);
        }
        String str = new String(charArray);
        char[] charArray2 = "¡®«¬«¶".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 194);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static Cache a(Context context) {
        if (l == null) {
            l = new NoCache();
        }
        return l;
    }

    private static HurlStack.UrlRewriter b(Context context) {
        if (k == null) {
            k = new PlayServicesUrlRewriter();
        }
        return k;
    }

    private static SigmobRequestQueue c(Context context) {
        SigmobRequestQueue sigmobRequestQueue;
        SigmobRequestQueue sigmobRequestQueue2 = n;
        if (sigmobRequestQueue2 != null) {
            return sigmobRequestQueue2;
        }
        synchronized (Networking.class) {
            try {
                sigmobRequestQueue = n;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue3 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 2, Integer.MAX_VALUE, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
                    n = sigmobRequestQueue3;
                    sigmobRequestQueue3.start();
                    sigmobRequestQueue = sigmobRequestQueue3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sigmobRequestQueue;
    }

    public static SigmobRequestQueue getAdTrackerRetryQueue() {
        return o;
    }

    public static String getBaseUrlScheme() {
        return b() ? "https" : Constants.HTTP;
    }

    public static SigmobRequestQueue getBuriedPointRequestQueue() {
        return e;
    }

    public static String getCachedUserAgent() {
        String str = g;
        return str == null ? b : str;
    }

    public static SigmobRequestQueue getCommonRequestQueue() {
        return f;
    }

    public static SigmobRequestQueue getDownloadRequestQueue() {
        return d;
    }

    public static SigmobRequestQueue getRequestQueue() {
        return n;
    }

    public static String getScheme() {
        return "https";
    }

    public static SigmobRequestQueue getSigRequestQueue() {
        return c;
    }

    public static HashSet getSigmobServerURLS() {
        return m;
    }

    public static HurlStack.UrlRewriter getUrlRewriter() {
        return k;
    }

    public static String getUserAgent() {
        return TextUtils.isEmpty(g) ? h : g;
    }

    public static void initialize(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context);
        initializeBuriedPointRequestQueue(context);
        initializeDownloadRequestQueue(context);
        c(context);
        initializeCommonRequestQueue(context);
        initializeImageLoader(context);
        initializeadTrackerReTryQueue(context);
    }

    public static SigmobRequestQueue initializeBuriedPointRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue;
        SigmobRequestQueue sigmobRequestQueue2 = e;
        if (sigmobRequestQueue2 != null) {
            return sigmobRequestQueue2;
        }
        synchronized (Networking.class) {
            try {
                sigmobRequestQueue = e;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue3 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 1, 2);
                    e = sigmobRequestQueue3;
                    sigmobRequestQueue3.start();
                    sigmobRequestQueue = sigmobRequestQueue3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sigmobRequestQueue;
    }

    public static SigmobRequestQueue initializeCommonRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue;
        SigmobRequestQueue sigmobRequestQueue2 = f;
        if (sigmobRequestQueue2 != null) {
            return sigmobRequestQueue2;
        }
        synchronized (Networking.class) {
            try {
                sigmobRequestQueue = f;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue3 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 2, 10);
                    f = sigmobRequestQueue3;
                    sigmobRequestQueue3.start();
                    sigmobRequestQueue = sigmobRequestQueue3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sigmobRequestQueue;
    }

    public static SigmobRequestQueue initializeDownloadRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue;
        SigmobRequestQueue sigmobRequestQueue2 = d;
        if (sigmobRequestQueue2 != null) {
            return sigmobRequestQueue2;
        }
        synchronized (Networking.class) {
            try {
                sigmobRequestQueue = d;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue3 = new SigmobRequestQueue(new FileDownloadNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 1, 6);
                    d = sigmobRequestQueue3;
                    sigmobRequestQueue3.start();
                    sigmobRequestQueue = sigmobRequestQueue3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sigmobRequestQueue;
    }

    public static ImageLoader initializeImageLoader(Context context) {
        MaxWidthImageLoader maxWidthImageLoader;
        MaxWidthImageLoader maxWidthImageLoader2 = i;
        if (maxWidthImageLoader2 != null) {
            return maxWidthImageLoader2;
        }
        synchronized (Networking.class) {
            try {
                maxWidthImageLoader = i;
                if (maxWidthImageLoader == null) {
                    SigmobRequestQueue downloadRequestQueue = getDownloadRequestQueue();
                    final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(DeviceUtils.memoryCacheSizeBytes(context)) { // from class: com.czhj.sdk.common.network.Networking.1
                        @Override // android.util.LruCache
                        public int sizeOf(String str, Bitmap bitmap) {
                            if (bitmap == null) {
                                return super.sizeOf((AnonymousClass1) str, (String) null);
                            }
                            return bitmap.getHeight() * bitmap.getRowBytes();
                        }
                    };
                    MaxWidthImageLoader maxWidthImageLoader3 = new MaxWidthImageLoader(downloadRequestQueue, context, new ImageLoader.ImageCache() { // from class: com.czhj.sdk.common.network.Networking.2
                        @Override // com.czhj.volley.toolbox.ImageLoader.ImageCache
                        public Bitmap getBitmap(String str) {
                            return (Bitmap) lruCache.get(str);
                        }

                        @Override // com.czhj.volley.toolbox.ImageLoader.ImageCache
                        public void putBitmap(String str, Bitmap bitmap) {
                            lruCache.put(str, bitmap);
                        }
                    });
                    i = maxWidthImageLoader3;
                    maxWidthImageLoader = maxWidthImageLoader3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return maxWidthImageLoader;
    }

    public static void initializeMill(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context.getApplicationContext());
        c(context);
        initializeCommonRequestQueue(context);
        initializeBuriedPointRequestQueue(context);
    }

    public static SigmobRequestQueue initializeSigRequestQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue;
        SigmobRequestQueue sigmobRequestQueue2 = c;
        if (sigmobRequestQueue2 != null) {
            return sigmobRequestQueue2;
        }
        synchronized (Networking.class) {
            try {
                sigmobRequestQueue = c;
                if (sigmobRequestQueue == null) {
                    SigmobRequestQueue sigmobRequestQueue3 = new SigmobRequestQueue(new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000))), 2, 5);
                    c = sigmobRequestQueue3;
                    sigmobRequestQueue3.start();
                    sigmobRequestQueue = sigmobRequestQueue3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sigmobRequestQueue;
    }

    public static String initializeUserAgent(final Context context) {
        String str;
        Preconditions.NoThrow.checkNotNull(context);
        String str2 = g;
        if (str2 != null) {
            return str2;
        }
        synchronized (Networking.class) {
            str = g;
            if (str == null) {
                try {
                    ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.network.Networking.3
                        @Override // java.lang.Runnable
                        public void run() {
                            long currentTimeMillis = System.currentTimeMillis();
                            String unused = Networking.g = WebSettings.getDefaultUserAgent(context);
                            SigmobLog.d("getUA time " + (System.currentTimeMillis() - currentTimeMillis));
                            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(context).edit();
                            edit.putString("user-agent-cache", Networking.g);
                            edit.apply();
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        }
        return str;
    }

    public static void initializeUserAgentCache(Context context) {
        h = SharedPreferencesUtil.getSharedPreferences(context).getString("user-agent-cache", b);
    }

    public static void initializeV2(Context context) {
        initializeUserAgentCache(context);
        initializeUserAgent(context);
        initializeBuriedPointRequestQueue(context);
        initializeDownloadRequestQueue(context);
        initializeCommonRequestQueue(context);
        initializeadTrackerReTryQueue(context);
    }

    public static SigmobRequestQueue initializeadTrackerReTryQueue(Context context) {
        SigmobRequestQueue sigmobRequestQueue;
        SigmobRequestQueue sigmobRequestQueue2 = o;
        if (sigmobRequestQueue2 != null) {
            return sigmobRequestQueue2;
        }
        synchronized (Networking.class) {
            try {
                sigmobRequestQueue = o;
                if (sigmobRequestQueue == null) {
                    BasicNetwork basicNetwork = new BasicNetwork(new RequestQueueHttpStack(CustomSSLSocketFactory.getDefault(10000)));
                    if (l == null) {
                        a(context);
                    }
                    SigmobRequestQueue sigmobRequestQueue3 = new SigmobRequestQueue(basicNetwork, 1, 10);
                    o = sigmobRequestQueue3;
                    sigmobRequestQueue3.start();
                    sigmobRequestQueue = sigmobRequestQueue3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sigmobRequestQueue;
    }

    public static void useHttps(boolean z) {
        j = z;
    }

    private static boolean b() {
        return j;
    }
}
