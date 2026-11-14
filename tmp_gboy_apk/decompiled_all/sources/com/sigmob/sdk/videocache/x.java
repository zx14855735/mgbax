package com.sigmob.sdk.videocache;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static x f13747a;
    private final ExecutorService b = Executors.newFixedThreadPool(8);
    private final Map<String, WeakReference<a>> c = new HashMap();
    private Context d;

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final String f13748a;
        private final AtomicBoolean b = new AtomicBoolean(false);

        public a(String str) {
            this.f13748a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x006c -> B:18:0x00a6). Please report as a decompilation issue!!! */
        private void a(String str) {
            ?? r6;
            HttpURLConnection httpURLConnection;
            InputStream inputStream = null;
            try {
            } catch (Throwable th) {
                th = th;
                r6 = str;
            }
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    byte[] bArr = new byte[1024];
                    inputStream = httpURLConnection.getInputStream();
                    while (true) {
                        if (inputStream.read(bArr) == -1) {
                            break;
                        }
                        if (this.b.get()) {
                            SigmobLog.d("cancelPreLoadVideo，取消网络请求，成功（正在下载数据），url = " + this.f13748a);
                            break;
                        }
                    }
                    SigmobLog.i("preloadVideo，网络文件，成功，url = " + this.f13748a);
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    httpURLConnection.disconnect();
                } catch (Exception e3) {
                    e = e3;
                    SigmobLog.e("preloadVideo，网络文件，失败，msg = " + e.getMessage() + "，url = " + this.f13748a);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                r6 = 0;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (r6 == 0) {
                    throw th;
                }
                try {
                    r6.disconnect();
                    throw th;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b.get()) {
                a(this.f13748a);
                return;
            }
            SigmobLog.i("cancelPreLoadVideo，取消网络请求，成功（未下载数据），url = " + this.f13748a);
        }

        public void a(boolean z) {
            this.b.set(z);
        }
    }

    private x(Context context) {
        this.d = context;
    }

    public static synchronized x a(Context context) {
        x xVar;
        synchronized (x.class) {
            try {
                if (f13747a == null && context != null) {
                    f13747a = new x(context.getApplicationContext());
                }
                xVar = f13747a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    public void b(String str) {
        WeakReference<a> weakReference;
        a aVar;
        SigmobLog.d("cancelPreLoadVideo，ulr = " + str);
        if (TextUtils.isEmpty(str) || (weakReference = this.c.get(str)) == null || (aVar = weakReference.get()) == null) {
            return;
        }
        SigmobLog.d("cancelPreLoadVideo，取消网络请求，ulr = " + str);
        aVar.a(true);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String url = StringUtil.getUrl(str);
        if (!url.startsWith(Constants.HTTP)) {
            SigmobLog.d("preloadVideo，本地文件：ulr = ".concat(url));
            return;
        }
        SigmobLog.d("preloadVideo，网络文件，开始下载：ulr = ".concat(url));
        a aVar = new a(url);
        this.c.put(url, new WeakReference<>(aVar));
        this.b.execute(aVar);
    }
}
